package org.ednovo.gooru.application.server.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Hashtable;
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
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.ednovo.gooru.application.client.service.ClasspageServiceAsync;
import org.ednovo.gooru.application.server.request.UrlToken;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import gwtupload.server.UploadAction;
import gwtupload.server.exceptions.UploadActionException;
import gwtupload.server.exceptions.UploadSizeLimitException;
import gwtupload.shared.UConsts;

public class uploadServlet extends UploadAction{
	private static final long serialVersionUID = -4035393951562844790L;

	private ClasspageServiceAsync classpageService;
	
	private static final Logger logger = LoggerFactory.getLogger(uploadServlet.class);


	private static final String REST_ENDPOINT = "rest.endpoint";
	
	String stoken ="";



	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		 FileItem uploadedFileItem = null;
		 String fileName="";
		 JSONArray jsonArray = null;
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
					stoken = (String)request.getSession(false).getAttribute("gooru-session-token");
					
					try {
						fileName=URLEncoder.encode(uploadedFileItem.getName(), "UTF-8");
					} catch (Exception e) {
						logger.info("Exception::@--:"+stoken);
						e.printStackTrace();
					}

					String requestData = "uploadFileName=" + fileName + "&imageURL=&sessionToken=" + stoken;

					String url = UrlGenerator.generateUrl(restConstants.getProperty(REST_ENDPOINT), UrlToken.FILE_UPLOAD_GET_URL, fileName, stoken);



					try {

						responsedata = webInvokeForImage("POST", requestData,"multipart/form-data", request,uploadedFileItem.get(), fileName,uploadedFileItem.getSize(),url);
						logger.info("responsebody::@:"+stoken+"------"+response.getContentType());
						jsonArray = new JSONArray(responsedata);
						logger.info("responsedata::@:"+stoken+"------"+responsedata);

					} catch (UnsupportedEncodingException e) {
						logger.info("UnsupportedEncodingException::@:"+stoken);
						e.printStackTrace();
					}

					logger.info("responsecode::@:"+stoken+"------"+response.getStatus());
					response.setContentType("text/html");
					response.getOutputStream().print(jsonArray.get(0).toString());
					response.getOutputStream().flush();
				}
				catch (FileUploadBase.FileSizeLimitExceededException e) {
					logger.info("FileSizeLimitExceededException:::"+stoken);
					e.printStackTrace();
					responsedata = "file size error" ;
					response.setContentType("text/html");
					response.getOutputStream().print(responsedata);
					response.getOutputStream().flush();
			    }
			}
			catch(Exception e) {
				logger.info("Exception1sttry:::"+stoken);
				
			}
		}
	}



		public String webInvokeForImage(String methodName, String data,String contentType, HttpServletRequest req, byte[] bytes,String fileName,Long fileSize, String urlVal) throws UnsupportedEncodingException {
			String ret = "";
			try {
					ret = fileUpload(bytes, data, fileName,fileSize,urlVal);
			} catch (Exception e) {
				logger.info("webInvokeForImage Exception:::"+stoken);
			}
			return ret;
		}





		public ClasspageServiceAsync getClasspageService() {
			return classpageService;
		}

		public void setClasspageService(ClasspageServiceAsync classpageService) {
			this.classpageService = classpageService;
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