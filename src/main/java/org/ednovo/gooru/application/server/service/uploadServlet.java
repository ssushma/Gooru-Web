/*******************************************************************************
 * Copyright 2013 Ednovo d/b/a Gooru. All rights reserved.
 *
 *  http://www.goorulearning.org/
 *
 *  Permission is hereby granted, free of charge, to any person obtaining
 *  a copy of this software and associated documentation files (the
 *  "Software"), to deal in the Software without restriction, including
 *  without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to
 *  permit persons to whom the Software is furnished to do so, subject to
 *  the following conditions:
 *
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 *  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 *  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 *  WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
package org.ednovo.gooru.application.server.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.ednovo.gooru.application.server.request.UrlToken;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import gwtupload.server.UploadAction;

public class uploadServlet extends UploadAction {
    private static final long serialVersionUID = -4035393951562844790L;
    private static final Logger logger = LoggerFactory.getLogger(uploadServlet.class);
    private static final String REST_ENDPOINT = "rest.endpoint";
    private static final String GOORU_SESSION_TOKEN = "gooru-session-token";
    
	@Inject
	private BaseServiceImpl baseService;
    
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
         FileItem uploadedFileItem = null;
         String fileName="";
         JSONArray jsonArray = null;
         boolean isMultiPart = ServletFileUpload.isMultipartContent(new ServletRequestContext(request));
         logger.info("uploadServlet.doPost, isMultiPart: " + isMultiPart);
         if(isMultiPart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(31457280);
            String responsedata = "" ;
            try{
                try{
                    if(request == null){
                        logger.error("UploadServlet.doPost, request is null!");
                    }

                    @SuppressWarnings("rawtypes")
                    java.util.List items = upload.parseRequest(request);

                    if(items!=null) {
                        logger.info("UploadServlet.doPost, parsed request, successfully, itemSize:" + items.size());
                    }else {
                        logger.error("UploadServlet.doPost, could not parse request!");
                    }

                    ApplicationContext appContext = new ClassPathXmlApplicationContext("gooruContext-service.xml");
                    Properties restConstants = (Properties) appContext.getBean("restConstants");

                    logger.info("UploadServlet.doPost, got appContext and restConstants");

                    for(int i=0;i<items.size();i++){//strangeness
                        uploadedFileItem = (FileItem) items.get(i);
                    }

                    if(uploadedFileItem!= null){
                        logger.info("UploadServlet.doPost, uploadedFileItem fileName:" + uploadedFileItem.getName() + ", fileSize: ", uploadedFileItem.getSize());
                    }else {
                        logger.info("UploadServlet.doPost, uploadedFileItem is null!");
                    }
                    //AA: We do not have sticky sessions or session replication configuration.
                    //AA: We cannot assume that any request that we make will land on the same server that had our session set (we will never scale like this).
                    //AA: We can read the session from the cookie instead...
                    //String stoken = (String)request.getSession(false).getAttribute("gooru-session-token");
                    String stoken = baseService.getLoggedInSessionToken();
                    


                    if(stoken == null || stoken.isEmpty()){
                        logger.error("UploadServlet.doPost, could not obtain a sessionToken from the cookies, please check the request header!");
                    }

                    logger.info("UploadServlet.doPost, sessionToken:" + stoken);
                    try {

                        //This will replace all the non-word characters with '_' excluding the dot.
                        fileName=uploadedFileItem.getName().replaceAll("[^\\w.]", "_");

                        logger.info("UploadServlet.doPost, modified fileName :" + fileName);

                    } catch (Exception e) {
                        logger.error("UploadServlet.doPost, Exception:", e);
                    }
                    String requestData = "uploadFileName=" + fileName + "&imageURL=&sessionToken=" + stoken;
                    logger.info("UploadServlet.doPost, forming requestData:" + requestData);

                    String url = UrlGenerator.generateUrl(restConstants.getProperty(REST_ENDPOINT), UrlToken.FILE_UPLOAD_GET_URL, fileName, stoken);
                    logger.info("UploadServlet.doPost, forming url:" + url);

                    try {
                        responsedata = webInvokeForImage("POST", requestData,"multipart/form-data", request,uploadedFileItem.get(), fileName,uploadedFileItem.getSize(),url);
                        logger.info("uploadServlet.doPost, got responseData:" + responsedata);
                        jsonArray = new JSONArray(responsedata);
                        if(jsonArray!=null) {
                            logger.info("UploadServlet.doPost, got some jsonArray from responseData with length:" + jsonArray.length());
                        }

                    } catch (UnsupportedEncodingException e) {
                        logger.error("UnsupportedEncodingException:", e);
                    }
                    response.setContentType("text/html");

                    response.getOutputStream().print(jsonArray.get(0).toString());
                    response.getOutputStream().flush();
                    logger.info("UploadServlet.doPost,  flushed outputStream with data:" + jsonArray.get(0).toString());

                }catch(FileUploadBase.FileSizeLimitExceededException  e) {
                    logger.error("UploadServlet.doPost, FileSizeLimitExceededException:", e);
                    responsedata = "file size error" ;
                    response.setContentType("text/html");
                    response.getOutputStream().print(responsedata);
                    response.getOutputStream().flush();
               }
            }catch(Exception e){
                logger.error("uploadServlet.doPost, why did i come here? Global exception:", e);
            }
        }
    }
    public String webInvokeForImage(String methodName, String data,String contentType, HttpServletRequest req, byte[] bytes,String fileName,Long fileSize, String urlVal) throws UnsupportedEncodingException {
        String ret = "";
        try {
            logger.info("In UploadServlet.webInvokeForImage, upload fileName:" + fileName);
            ret = fileUpload(bytes, data, fileName,fileSize,urlVal);
            logger.info("In UploadServlet.webInvokeForImage, from fileUpload call got data:"+ ret);
        } catch (Exception e) {
            logger.error("UploadServlet.webInvokeForImage Exception:", e);
        }
        logger.info("Out UploadServlet.webInvokeForImage with return data:" + ret);
        return ret;
    }
    public String fileUpload(byte[] bytes, String data, String fileName,Long fileSize, String urlVal) throws Exception {
        logger.info("In UploadServlet.fileUpload, preparing to upload url:" + urlVal);
        String ret = "";
        logger.info("upload Url:::"+urlVal);
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httppost = new HttpPost(urlVal);
        MultipartEntityBuilder reqEntity=MultipartEntityBuilder.create();
        ByteArrayBody bab = new ByteArrayBody(bytes, fileName);
        reqEntity.addPart("image", bab);
        httppost.setEntity(reqEntity.build());
        try {
            HttpResponse response = httpClient.execute(httppost);

            if (response != null) {
                int statusCode = response.getStatusLine().getStatusCode();
                logger.info("UploadServlet.fileUpload response statusCode: " + statusCode);
            }else {
                logger.error("UploadServlet.fileUpload, response is null!");
            }

            HttpEntity resEntity = response.getEntity();

            if (resEntity != null) {
                ret = EntityUtils.toString(resEntity);
            }
            logger.info("upload response:::" + ret);
        }catch(Exception e){
            logger.error("UploadServlet.fileUpload exception:", e);
            e.printStackTrace();
        }
        logger.info("Out UploadServlet.fileUpload, uploaded with return data:" + ret);
        return ret;
     }
}