package org.ednovo.gooru.server.service;

import gwtupload.server.UploadAction;
import gwtupload.server.exceptions.UploadActionException;
import gwtupload.server.exceptions.UploadSizeLimitException;
import gwtupload.shared.UConsts;

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
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.ednovo.gooru.client.service.ClasspageServiceAsync;
import org.ednovo.gooru.server.request.UrlToken;
import org.json.JSONArray;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class uploadServlet extends UploadAction{
	private static final long serialVersionUID = -4035393951562844790L;
	
	private ClasspageServiceAsync classpageService;	

	
	private static final String REST_ENDPOINT = "rest.endpoint";
	

	 /**
     * Maintain a list with received files and their content types.
     */
    Hashtable<String, String> receivedContentTypes = new Hashtable<String, String>();

    /**
     * Maintain a list with received files.
     */
    Hashtable<String, File> receivedFiles = new Hashtable<String, File>();


	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		 FileItem uploadedFileItem = null;
		 String fileName="";
		 Long fileSize = null;
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
					
					byte[] imageBytes=null;
					String ebookId="";
					 ApplicationContext appContext = new ClassPathXmlApplicationContext(
						        "gooruContext-service.xml");
						    Properties restConstants = (Properties) appContext.getBean("restConstants");
						    
					for(int i=0;i<items.size();i++)
					{
						uploadedFileItem = (FileItem) items.get(i);
					}
				  // we only upload one file
					String stoken = (String)request.getSession(false).getAttribute("gooru-session-token");
					
					String requestData = "uploadFileName=" + fileName + "&imageURL=&sessionToken=" + stoken;
					
					String url = UrlGenerator.generateUrl(restConstants.getProperty(REST_ENDPOINT), UrlToken.FILE_UPLOAD_GET_URL, fileName, stoken);

					try {
						fileName=URLEncoder.encode(uploadedFileItem.getName(), "UTF-8");
					} catch (Exception e) {}
					
					try {
					
						responsedata = webInvokeForImage("POST", requestData,"multipart/form-data", request,uploadedFileItem.get(), fileName,uploadedFileItem.getSize(),url);
						jsonArray = new JSONArray(responsedata);
						
					} catch (UnsupportedEncodingException e) {
					}
					
					
					response.setContentType("text/html");
					response.getOutputStream().print(jsonArray.get(0).toString());
					response.getOutputStream().flush();	 
				}
				catch (FileUploadBase.FileSizeLimitExceededException e) {
					responsedata = "file size error" ;
					response.setContentType("text/html");
					response.getOutputStream().print(responsedata);
					response.getOutputStream().flush();	 
			    }
			} 
			catch(Exception e) {
			}
		}
	}
	

	  
		public String webInvokeForImage(String methodName, String data,String contentType, HttpServletRequest req, byte[] bytes,String fileName,Long fileSize, String urlVal) throws UnsupportedEncodingException {
			String ret = "";
			try {
					ret = testUpload(bytes, data, fileName,fileSize,urlVal);
			} catch (Exception e) {
			}
			return ret;
		}





		public ClasspageServiceAsync getClasspageService() {
			return classpageService;
		}

		public void setClasspageService(ClasspageServiceAsync classpageService) {
			this.classpageService = classpageService;
		}
		
		

		public String testUpload(byte[] bytes, String data, String fileName,Long fileSize, String urlVal)
				throws Exception {
			String ret = "";
			HttpParams myParams = new BasicHttpParams();
			DefaultHttpClient httpClient =  new DefaultHttpClient(myParams);
			HttpPost httppost = new HttpPost(urlVal);
			MultipartEntity reqEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
			reqEntity.addPart("string_field", new StringBody("field value"));
			ByteArrayBody bab = new ByteArrayBody(bytes, fileName);
			reqEntity.addPart("image", bab);
			httppost.setEntity(reqEntity);
			HttpResponse response = httpClient.execute(httppost);
			HttpEntity resEntity = response.getEntity();
			if (resEntity != null) {
				ret = EntityUtils.toString(resEntity);
			}
			return ret;
		}
		
		  /**
		   * Override this method if you want to check the request before it is passed 
		   * to commons-fileupload parser.
		   * 
		   * @param request
		   * @throws RuntimeException
		   */
		  @Override
		  public void checkRequest(HttpServletRequest request) {
			  try
			  {
		    if (request.getContentLength() > 10 * 1024 * 1024) {
		      throw new UploadSizeLimitException(maxSize, request.getContentLength());
		    }
			  }
			  catch(Exception ex)
			  {
			  }
		  }
		
		/**
	     * Get the content of an uploaded file.
	     */
	    @Override
	    public void getUploadedFile(HttpServletRequest request,
	            HttpServletResponse response) throws IOException
	    {
	        String fieldName = request.getParameter(UConsts.PARAM_SHOW);
	        File f = receivedFiles.get(fieldName);
	        if (f != null)
	        {
	            response.setContentType(receivedContentTypes.get(fieldName));
	            FileInputStream is = new FileInputStream(f);
	            copyFromInputStreamToOutputStream(is, response.getOutputStream());
	        }
	        else
	        {
	            renderXmlResponse(request, response, "");
	        }
	    }

	    /**
	     * Remove a file when the user sends a delete request.
	     */
	    @Override
	    public void removeItem(HttpServletRequest request, String fieldName)
	            throws UploadActionException
	    {
	        File file = receivedFiles.get(fieldName);
	        receivedFiles.remove(fieldName);
	        receivedContentTypes.remove(fieldName);
	        if (file != null)
	        {
	            file.delete();
	        }
	    }
	

}
