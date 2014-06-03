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

import java.io.File;

import org.ednovo.gooru.client.service.MediaUploadService;
import org.ednovo.gooru.server.annotation.ServiceURL;
import org.ednovo.gooru.server.request.JsonResponseRepresentation;
import org.ednovo.gooru.server.request.ServiceProcessor;
import org.ednovo.gooru.server.request.UrlToken;
import org.ednovo.gooru.server.serializer.JsonDeserializer;
import org.ednovo.gooru.shared.model.user.MediaUploadDo;
import org.json.JSONArray;
import org.json.JSONException;
import org.restlet.data.Form;
import org.restlet.ext.json.JsonRepresentation;
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

	@Override
	public MediaUploadDo imageWebUpload(String imageURL) {
		MediaUploadDo mediaUploadDo = null;
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator
				.generateUrl(getRestEndPoint(), UrlToken.MEDIA_FILE_UPLOAD,
						getLoggedInSessionToken(), imageURL);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.post(url, getRestUsername(),getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		try {
			mediaUploadDo = JsonDeserializer.deserialize(jsonRep.getJsonArray()
					.get(0).toString(), MediaUploadDo.class);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return mediaUploadDo;

	}

	@Override
	public String saveImage(String gooruOid, String fileName) {
		String filePath = null;
		JsonRepresentation jsonRep = null;
		String url = UrlGenerator.generateUrl(getRestEndPoint(),
				UrlToken.MEDIA_FILE_SAVE, gooruOid, getLoggedInSessionToken(),fileName);
	
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.post(url, getRestUsername(),
				getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		try {
			filePath = jsonRep.getText(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filePath;
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
	public String saveQuestionImage(String collectionItemId, String fileName) {
		String filePath = null;
		JsonRepresentation jsonRep = null;

		String url = UrlGenerator.generateUrl(getRestEndPoint(), UrlToken.UPDATE_QUESTION_IMAGE, collectionItemId, getLoggedInSessionToken(), fileName);
		JsonResponseRepresentation jsonResponseRep = ServiceProcessor.post(url, getRestUsername(), getRestPassword());
		jsonRep = jsonResponseRep.getJsonRepresentation();
		try {
			filePath = jsonRep.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filePath;
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

}
