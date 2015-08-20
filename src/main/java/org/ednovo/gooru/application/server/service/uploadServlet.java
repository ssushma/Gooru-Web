package org.ednovo.gooru.application.server.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.commons.io.FilenameUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import gwtupload.server.UploadAction;

public class uploadServlet extends UploadAction{
	private static final long serialVersionUID = -4035393951562844790L;

	private static final Logger logger = LoggerFactory.getLogger(uploadServlet.class);


	private static final String REST_ENDPOINT = "rest.endpoint";
	
	private static final String IMAGE_UPLOAD_URL = "/v2/media?sessionToken={0}";



	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		 FileItem uploadedFileItem = null;
		 String fileName="";
		 boolean isMultiPart = ServletFileUpload.isMultipartContent(new ServletRequestContext(request));
		 if(isMultiPart) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(31457280);
			String responsedata = "" ;
			try {
					try{
					@SuppressWarnings("rawtypes")
					java.util.List items = upload.parseRequest(request);


					 ApplicationContext appContext = new ClassPathXmlApplicationContext(
						        "gooruContext-service.xml");
						    Properties restConstants = (Properties) appContext.getBean("restConstants");

					for(int i=0;i<items.size();i++)
					{
						uploadedFileItem = (FileItem) items.get(i);
					}
				  // we only upload one file
					String stoken = (String)request.getSession(false).getAttribute("gooru-session-token");
					
					try {
						String fileNameVal = uploadedFileItem.getName();						
						String basename = FilenameUtils.getBaseName(fileNameVal);
						logger.info("basename:::"+basename);
						String extension = FilenameUtils.getExtension(fileNameVal);
						logger.info("extension:::"+extension);
						fileName=basename.replaceAll("[^a-zA-Z0-9]", "_")+"."+extension;
					} catch (Exception e) {
						logger.error("Exception:::"+e);
					}

					String requestData = "uploadFileName=" + fileName + "&imageURL=&sessionToken=" + stoken;
					String url = UrlGenerator.generateUrl(restConstants.getProperty(REST_ENDPOINT)+IMAGE_UPLOAD_URL, stoken);
					try {

						responsedata = webInvokeForImage("POST", requestData,"multipart/form-data", request,uploadedFileItem.get(), fileName,uploadedFileItem.getSize(),url);


					} catch (UnsupportedEncodingException e) {
						logger.error("UnsupportedEncodingException:::"+e);
					}
					response.setContentType("text/html");
					response.getOutputStream().print(responsedata);
					response.getOutputStream().flush();
				}
				catch (FileUploadBase.FileSizeLimitExceededException e) {
					logger.error("FileSizeLimitExceededException:::"+e);
					responsedata = "file size error" ;
					response.setContentType("text/html");
					response.getOutputStream().print(responsedata);
					response.getOutputStream().flush();
			    }
			}
			catch(Exception e) {
				logger.error("Exception1sttry:::"+e);
			}
		}
	}



		public String webInvokeForImage(String methodName, String data,String contentType, HttpServletRequest req, byte[] bytes,String fileName,Long fileSize, String urlVal) throws UnsupportedEncodingException {
			String ret = "";
			try {
					ret = fileUpload(bytes, data, fileName,fileSize,urlVal);
			} catch (Exception e) {
				logger.error("webInvokeForImage Exception:::"+e);
			}
			return ret;
		}



	    public String fileUpload(byte[] bytes, String data, String fileName,Long fileSize, String urlVal)
                throws Exception {
            String ret = "";
            logger.info("upload Url:::"+urlVal);
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost httppost = new HttpPost(urlVal);
            MultipartEntityBuilder reqEntity=MultipartEntityBuilder.create();
            ByteArrayBody bab = new ByteArrayBody(bytes, fileName);
            reqEntity.addPart("image", bab);
            httppost.setEntity(reqEntity.build());
            HttpResponse response = httpClient.execute(httppost);
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                ret = EntityUtils.toString(resEntity);
            }
        	logger.info("upload response:::"+ret);
            return ret;
        }
}