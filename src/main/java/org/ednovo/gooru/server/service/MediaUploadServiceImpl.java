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
package org.ednovo.gooru.server.service;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.ednovo.gooru.client.service.MediaUploadService;
import org.ednovo.gooru.server.annotation.ServiceURL;
import org.ednovo.gooru.server.form.ResourceFormFactory;
import org.ednovo.gooru.server.request.JsonResponseRepresentation;
import org.ednovo.gooru.server.request.ServiceProcessor;
import org.ednovo.gooru.server.request.ServiceRequest;
import org.ednovo.gooru.server.request.UrlToken;
import org.ednovo.gooru.server.serializer.JsonDeserializer;
import org.ednovo.gooru.server.serializer.JsonSerializer;
import org.ednovo.gooru.shared.model.content.CollectionAddQuestionItemDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.QuestionAnswerDo;
import org.ednovo.gooru.shared.model.content.ResourceDo;
import org.ednovo.gooru.shared.model.user.MediaUploadDo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.ext.html.FormData;
import org.restlet.ext.html.FormDataSet;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.springframework.stereotype.Service;

/**
 * @author Search Team
 * 
 */
@Service("mediaUploadService")
@ServiceURL("/mediaUploadService")
public class MediaUploadServiceImpl extends BaseServiceImpl implements
		MediaUploadService {

	/**
	 * 
	 */
		 
	private static final long serialVersionUID = -8673556966040594979L;
	private static final String ADDED = "added";

	@Override
	public MediaUploadDo imageWebUpload(String imageURL) {
		MediaUploadDo mediaUploadDo = null;
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator
				.generateUrl(getRestEndPoint(), UrlToken.MEDIA_FILE_UPLOAD,
						getLoggedInSessionToken());
		JSONObject jsonObj=new JSONObject();
		try {
			jsonObj.put("imageURL", imageURL);
			jsonObj.put("reSize",true);
			jsonObj.put("width",750);
			jsonObj.put("height",525);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}		

		String responseText ="";
			try {
				responseText = fileUploadImage(jsonObj.toString(), url);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				mediaUploadDo = JsonDeserializer.deserialize(responseText, MediaUploadDo.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return mediaUploadDo;

	}

	@Override
	public CollectionItemDo saveImage(String gooruOid, String resourceId, String fileName) {
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_CREATE_COLLECTION_ITEM,gooruOid, getLoggedInSessionToken());
		try{
		JSONObject createCollectionJsonObject=new JSONObject();
		JSONObject itemTypeJsonObject=new JSONObject();
		itemTypeJsonObject.put("itemType", ADDED);
		createCollectionJsonObject.put("collectionItem", itemTypeJsonObject);
		if (resourceId != null) {
			createCollectionJsonObject.put("resourceId", resourceId);
		}
		if (fileName != null) {
			createCollectionJsonObject.put("mediaFileName", fileName);
		}
		
		System.out.println("saveImage::"+url);
		System.out.println("saveImagedata::"+createCollectionJsonObject.toString());
		
//		url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.COPY_COLLLECTION_ITEM, resourceId,getLoggedInSessionToken(), collectionId);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword(),createCollectionJsonObject.toString());		
		jsonRep = jsonResponseRep.getJsonRepresentation();
		}catch(Exception e){}
		return deserializeCollectionItem(jsonRep);
	}
	
	public CollectionItemDo deserializeCollectionItem(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				
				return JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), CollectionItemDo.class);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new CollectionItemDo();
	}

	@Override
	public String cropImage(String fileName, String height, String width,
			String xPosition, String yPosition, String imageUrl) {
		String url = UrlGenerator.generateUrl(getRestEndPoint(),
				UrlToken.IMAGE_CROP, fileName, getLoggedInSessionToken(),
				height, width, xPosition, yPosition);

		try
		{
		ServiceProcessor.put(url, getRestUsername(), getRestPassword(),
				new Form());
		}
		catch(Exception ex)
		{
			
		}
		
		if (imageUrl == null) {
			return fileName;
		} 
		else {
			return imageUrl;
		}

	}

	@Override
	public MediaUploadDo imageFileUpload(String response) {
		MediaUploadDo mediaUploadDo = null;
		if (response != null) {
			try {
				JSONArray responseJson = new JSONArray(response);
				mediaUploadDo = JsonDeserializer.deserialize(responseJson.get(0).toString(), MediaUploadDo.class);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return mediaUploadDo;
	}

	// Request
	// URL:http://www.goorulearning.org/gooruapi/rest/quiz-question/newQuestion/media?sessionToken=f6ded446-a9a9-11e2-ba82-123141016e2a&mediaFileName=bbda9546-cb15-453e-a107-f073b09eccdc.jpg&assetKey=asset-question
	public CollectionItemDo saveQuestionImage(String collectionItemId, String fileName) {
	
		CollectionItemDo collItemDo = getCollectionItem(collectionItemId);

		JsonRepresentation jsonRep = null;
		CollectionAddQuestionItemDo collectionAddQuestionItemDo=new CollectionAddQuestionItemDo();
		collectionAddQuestionItemDo.setQuestion(collItemDo.getCollectionQuestionItemDo());
		collectionAddQuestionItemDo.setMediaFileName(fileName);
	
		CollectionItemDo collectionItemDoNew=new CollectionItemDo();
		

		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.V2_UPDATE_QUESTION_ITEM, collItemDo.getCollectionItemId(), getLoggedInSessionToken());
		
		collItemDo.getQuestionInfo().setLicense(null);
		collItemDo.getQuestionInfo().setResourceFormat(null);
		collItemDo.getQuestionInfo().setTaxonomySet(null);
		collItemDo.getQuestionInfo().setThumbnails(null);
		collItemDo.getQuestionInfo().setResourceType(null);
		collItemDo.getQuestionInfo().setCreator(null);
		collItemDo.getQuestionInfo().setUser(null);
		collItemDo.getQuestionInfo().setCreatedOn(null);
		collItemDo.getQuestionInfo().setUrl(null);
		collItemDo.getQuestionInfo().setViews(null);
		collItemDo.getQuestionInfo().setGooruOid(null);
		collItemDo.getQuestionInfo().setAssets(null);
		
		TreeSet<QuestionAnswerDo> treeSet = new TreeSet<QuestionAnswerDo>();
		treeSet.addAll(collItemDo.getQuestionInfo().getAnswers());
		
		 Object[] objArray = treeSet.toArray();
		 JSONArray jArr = new JSONArray();
		 
		 for(int i=0; i < objArray.length ; i++)
		 {
			 System.out.println("objectarray::"+objArray[i]);
			 try {
				JSONObject jsonObjVal = new JSONObject(ResourceFormFactory.generateStringDataForm(objArray[i],null));
				jArr.put(jsonObjVal);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 System.out.println("objectarrayformatted::"+jArr);
		
		 }



		collItemDo.getQuestionInfo().setAnswers(null);

		  JSONObject mainQuestionTempObj = new JSONObject();
		  JSONObject mainAnswerTempObj = new JSONObject();
		  JSONObject mainQTempObj = new JSONObject();
		  String data = "";
		 // mainQTempObj. = new LinkedHashMap();
		  try {
			  
			  mainQuestionTempObj.put("question", ResourceFormFactory.generateStringDataForm(collItemDo.getQuestionInfo(), null));
			  JSONObject mainQuestionTempObj1 = new JSONObject(mainQuestionTempObj.get("question").toString());
			  mainAnswerTempObj.put("answer", jArr);
			  mainQuestionTempObj1.put("answers", mainAnswerTempObj);

		
			  
 	data = "{\""+"question"+"\" : " + mainQuestionTempObj1.toString() +", \""+"mediaFileName"+"\" : " +fileName+"}";
			  
			
			  mainQTempObj.put("question", mainQuestionTempObj1).put("mediaFileName", fileName);
			  //mainQTempObj.put("mediaFileName", fileName);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  

		  
		  System.out.println("data passed::"+data);
		  System.out.println("url::"+url);

		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.put(url, getRestUsername(), getRestPassword(), data);
		jsonRep = jsonResponseRep.getJsonRepresentation();
		collectionItemDoNew=deserializeCollectionItem(jsonRep);
		collItemDo.setResource(collectionItemDoNew.getQuestionInfo());
		collItemDo.setStandards(collectionItemDoNew.getStandards());
		return collItemDo;
	}
	
	
	public CollectionItemDo convertResourceToCollectionItemDo(ResourceDo resourceDo,CollectionItemDo collectionItemDo){	
		
		collectionItemDo.setResource(resourceDo);// replacing the update question details Do
		collectionItemDo.setCollectionQuestionItemDo(null);// removing existing collection item object details.
		
		return collectionItemDo;
	}
	
	public ResourceDo deserializeResourceDoItem(JsonRepresentation jsonRep) {
		if (jsonRep != null && jsonRep.getSize() != -1) {
			try {
				return JsonDeserializer.deserialize(jsonRep.getJsonObject().toString(), ResourceDo.class);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public CollectionItemDo getCollectionItem(String collectionItemId) {
		
		JsonRepresentation jsonRep = null;		
		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.GET_COLLLECTION_ITEM, collectionItemId, getLoggedInSessionToken());
		System.out.println("getCollectionItem::"+url);
		
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.get(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		return deserializeCollectionItem(jsonRep);
	}


	/*@Override
	public String saveResourceImage(String gooruOid, String fileName) {
		String filePath = null;
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(),
				UrlToken.MEDIA_FILE_SAVE, gooruOid, getLoggedInSessionToken(),
				fileName);
		jsonRep = ServiceProcessor.post(url, getRestUsername(),
				getRestPassword());
		try {
			filePath = jsonRep.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filePath;
	}*/

	@Override
	public String uploadProfileImage(String fileNameWithOurRespository,String fileName) {
		String url = UrlGenerator.generateUrl(getRestEndPoint(),UrlToken.UPLOAD_PROFILE_IMAGE, getLoggedInUserUid(), getLoggedInSessionToken(),fileNameWithOurRespository);
		Form form = new Form();
		form.add("sessionToken",getLoggedInSessionToken());
		ServiceProcessor.post(url, getRestUsername(),getRestPassword(),form);
		return fileName;
	}
	
	public String fileUploadImage(String data,String webServiceUrl)
			throws Exception {
		String respStr = "";
		FormData fd = new FormData("data", data);        
	    FormDataSet fds = new FormDataSet();
	    fds.setMultipart(true);
	    String boundary = "boundary";
	    fds.setMediaType(MediaType.MULTIPART_FORM_DATA);
	    fds.setMultipartBoundary(boundary);
	    fds.setMultipart(true);
	    fds.getEntries().add(fd);
	    ClientResource c = new ClientResource(webServiceUrl);
		c.setEntityBuffering(true);
	    Representation cr = c.post(fds, MediaType.MULTIPART_FORM_DATA);
		respStr = cr.getText();
		return respStr;
	}

}
