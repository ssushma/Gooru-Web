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
package org.ednovo.gooru.client.mvp.image.upload;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.classpages.event.UpdateClasspageImageEvent;
import org.ednovo.gooru.client.mvp.home.event.SetUpdateProfileImageEvent;
import org.ednovo.gooru.client.mvp.home.event.SetUserProfileImageEvent;
import org.ednovo.gooru.client.mvp.profilepage.event.SetUserPublicProfileImageEvent;
import org.ednovo.gooru.client.mvp.shelf.IsShelfView;
import org.ednovo.gooru.client.mvp.shelf.ShelfPresenter;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddResourcePresenter;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.IsAddResourceView;
import org.ednovo.gooru.client.mvp.shelf.event.AddResouceImageEvent;
import org.ednovo.gooru.client.mvp.shelf.event.UpdateEditResourceImageEvent;
import org.ednovo.gooru.client.service.MediaUploadServiceAsync;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.user.MediaUploadDo;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
/**
 * @fileName : ImageUploadPresenter.java
 *
 * @description : This is presenter for the image upload. 
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class ImageUploadPresenter extends PresenterWidget<IsImageUploadView> implements ImageUploadUiHandlers {
	private boolean isCollectionImage=true;
	private boolean isEditResourceImage=true;
	private boolean isEditUserOwnResourceImage=false;
	private boolean isQuestionImage=false;
	private boolean isUpdateQuestionImage=false;
	private boolean isProfileImage=false;
    private boolean isPublicProfileImage=false;
    private boolean isuserOwnResourceImage=false;
    private boolean isUdateProfileImage=false;
	
	private String collectionItemId;
	private String fileNameWithoutRepository=null;
	private boolean isImageUploadedFromUrl=false;
	private boolean isClassPageImage=false;
	private String classpageId=null;
	
	

	@Inject
	private MediaUploadServiceAsync mediaUploadService;

	private SimpleAsyncCallback<MediaUploadDo> imageWebUploadAsyncCallback;
	
	private SimpleAsyncCallback<String> cropImageAsyncCallback;
	
	private SimpleAsyncCallback<String> saveImageAsyncCallback;
	
	private SimpleAsyncCallback<MediaUploadDo> imageFileUploadAsyncCallback;
	
	private SimpleAsyncCallback<String> saveQuestionImageAysncCallback;
	
	private SimpleAsyncCallback<String> editResourceImageAysncCallback;
	
	private SimpleAsyncCallback<String> uploadProfileImageAsyncCallback;
	
	private SimpleAsyncCallback<MediaUploadDo> gooruDefaultProfileUploadAsyncCallback;
	
	private static final String GOORU_OID = "id";
	
	private IsShelfView shelfView; 
	
	private IsAddResourceView addResourceView;
	
	private AddResourcePresenter addResourcePresenter;
	

	/**
	 * Creates a {@link ImageUploadPresenter} by inherits the {@link PresenterWidget }
	 * for binding.
	 * @param isShelfView instance of {@link IsShelfView}, 
	 * it is inject via  {@link ImageUploadPresenter} to creates
	 * communication between the {@link ImageUploadPresenter} and {@link ShelfPresenter}  
	 * @param eventBus instance of {@link EventBus}
	 * @param view instance of {@link View}
	 */
	@Inject
	public ImageUploadPresenter(IsShelfView isShelfView, IsAddResourceView addResourceView, EventBus eventBus, IsImageUploadView view) {
		super(eventBus, view);
		this.setShelfView(isShelfView);
		this.setAddResourceView(addResourceView);
		//this.setAddResourcePresenter(addResourcePresenter);
		getView().setUiHandlers(this);
	}
	/**
	 * This LifeCycle method is called when the binding the object. And it will set the view for the upload image.
	 */
	@Override
	public void onBind() {
		super.onBind();
		setImageWebUploadAsyncCallback(new SimpleAsyncCallback<MediaUploadDo>() {

			@Override
			public void onSuccess(MediaUploadDo mediaUploadDo) {
				getView().glasspanelLoadingImage(false);
				getView().setImageUpload(mediaUploadDo);
				isImageUploadedFromUrl=true;
			}
			@Override
			public void onFailure(Throwable caught) {
				getView().glasspanelLoadingImage(false);
			}
		});
		setCropImageAsyncCallback(new SimpleAsyncCallback<String>() {
			@Override
			public void onSuccess(String filename) {
				
				if(isCollectionImage){
					saveImage(AppClientFactory.getPlaceManager().getRequestParameter(GOORU_OID), filename);
				}else if(isClassPageImage){
					saveImage(getClasspageId(), filename);
				}
				else if(isQuestionImage){
					AppClientFactory.fireEvent(new AddResouceImageEvent(filename,fileNameWithoutRepository,isQuestionImage,isuserOwnResourceImage));
					getView().closeImageUploadWidget();
					getView().resetImageUploadWidget();
					
				}else if(isUpdateQuestionImage){

					saveQuestionImage(filename);
				}else if (isEditResourceImage){
//					saveImage(AppClientFactory.getPlaceManager().getRequestParameter(GOORU_OID), filename);
					AppClientFactory.fireEvent(new UpdateEditResourceImageEvent(filename,fileNameWithoutRepository,isEditUserOwnResourceImage));
					getView().closeImageUploadWidget();
					getView().resetImageUploadWidget();
				}else if(isEditUserOwnResourceImage){
					AppClientFactory.fireEvent(new UpdateEditResourceImageEvent(filename,fileNameWithoutRepository,isEditUserOwnResourceImage));
					getView().closeImageUploadWidget();
					getView().resetImageUploadWidget();
				}
				
				
				else if(isProfileImage||isPublicProfileImage||isUdateProfileImage){

					saveUserProfileImage(filename);
				}else if(isuserOwnResourceImage){
					AppClientFactory.fireEvent(new AddResouceImageEvent(filename,fileNameWithoutRepository,isQuestionImage,isuserOwnResourceImage));
					getView().closeImageUploadWidget();
					getView().resetImageUploadWidget();
				}
				else{
				    //getAddResourceView().setImageUrl(filename);
					AppClientFactory.fireEvent(new AddResouceImageEvent(filename,fileNameWithoutRepository,isQuestionImage,isuserOwnResourceImage));
					getView().closeImageUploadWidget();
					getView().resetImageUploadWidget();
				}
				
			}
			@Override
			public void onFailure(Throwable caught) {
				getView().glasspanelLoadingImage(false);
			}
		});
		setSaveImageAsyncCallback(new SimpleAsyncCallback<String>() {
			@Override
			public void onSuccess(String url) {
				if(isClassPageImage){
					AppClientFactory.fireEvent(new UpdateClasspageImageEvent(url));
				}else{
					if(isImageUploadedFromUrl){
						MixpanelUtil.AddImageByUrlOntheWeb();
					}else{
						MixpanelUtil.AddImageFromMyComputer();
					}
					getShelfView().onPostCollectionImageUpload(url);
				}
				getView().closeImageUploadWidget();
				getView().resetImageUploadWidget();
			}
			
			@Override
			public void onFailure(Throwable caught) {
				getView().glasspanelLoadingImage(false);
			}
		});
		setSaveQuestionImageAysncCallback(new SimpleAsyncCallback<String>() {
			@Override
			public void onSuccess(String url) {
				//AppClientFactory.fireEvent(new UpdateQuestionImageEvent(url,fileNameWithoutRepository));
				AppClientFactory.fireEvent(new AddResouceImageEvent(url,fileNameWithoutRepository,isUpdateQuestionImage,isuserOwnResourceImage));
				getView().closeImageUploadWidget();
				getView().resetImageUploadWidget();
			}
			@Override
			public void onFailure(Throwable caught) {
				getView().glasspanelLoadingImage(false);
			}
		});
		
		setImageFileUploadAsyncCallback(new SimpleAsyncCallback<MediaUploadDo>() {
			@Override
			public void onSuccess(MediaUploadDo mediaUploadDo) {
				getView().setImageUpload(mediaUploadDo);
				isImageUploadedFromUrl=false;
			}
		});
		
		setUploadProfileImage(new SimpleAsyncCallback<String>() {
			@Override
			public void onSuccess(String imageUrl) {
				if(isProfileImage){
					AppClientFactory.fireEvent(new SetUserProfileImageEvent(imageUrl));
				}else if(isUdateProfileImage){
					AppClientFactory.fireEvent(new SetUpdateProfileImageEvent(imageUrl));
				}
				else{
					AppClientFactory.fireEvent(new SetUserPublicProfileImageEvent(imageUrl));
				}
				getView().closeImageUploadWidget();
				getView().resetImageUploadWidget();
			}
		});
		setGooruDefaultProfileUploadAsyncCallback(new SimpleAsyncCallback<MediaUploadDo>() {

			@Override
			public void onSuccess(MediaUploadDo mediaUploadDo) {
				saveUserProfileImage(mediaUploadDo);
			}
			@Override
			public void onFailure(Throwable caught) {
				getView().glasspanelLoadingImage(false);
			}
		});
	}
	/** 
	 * This method is to get the editResourceImageAysncCallback
	 */
	public SimpleAsyncCallback<String> getEditResourceImageAysncCallback() {
		return editResourceImageAysncCallback;
	}

	/** 
	 * This method is to set the editResourceImageAysncCallback
	 */
	public void setEditResourceImageAysncCallback(
			SimpleAsyncCallback<String> editResourceImageAysncCallback) {
		this.editResourceImageAysncCallback = editResourceImageAysncCallback;
	}
	/**
	 * This method is used when the user uploading from the web.
	 */
	@Override
	public void imageWebUpload(String imageURL) {
		this.getMediaUploadService().imageWebUpload(imageURL, getImageWebUploadAsyncCallback());
	}
	/**
	 * This method is used to save the images.
	 */
	@Override
	public void saveImage(String gooruOid, String fileName) {
		this.getMediaUploadService().saveImage(gooruOid, fileName, getSaveImageAsyncCallback());
	}
	/**
	 * @function saveQuestionImage 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : This method is used to save the question image.
	 * 
	 * @parm(s) : @param fileName
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void saveQuestionImage(String fileName){
		this.getMediaUploadService().saveQuestionImage(getCollectionItemId(), fileName, saveQuestionImageAysncCallback);
	}
	
	/*public void saveResourceImage(String fileName){
		this.getMediaUploadService().saveResourceImage(getCollectionItemId(), fileName, editResourceImageAysncCallback);
	}*/
	/**
	 * @function saveUserProfileImage 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : This method is used to save the user profile image.
	 * 
	 * @parm(s) : @param fileName
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void saveUserProfileImage(String fileName){
		this.getMediaUploadService().uploadProfileImage(fileNameWithoutRepository,fileName, uploadProfileImageAsyncCallback);
	}
	/**
	 * 
	 * @function saveUserProfileImage 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : This method is used to save the user profile image.
	 * 
	 * @parm(s) : @param mediaUpload
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void saveUserProfileImage(MediaUploadDo mediaUpload){
		this.getMediaUploadService().uploadProfileImage(mediaUpload.getName(),mediaUpload.getUrl(), uploadProfileImageAsyncCallback);
	}
	/**
	 * This method is used to upload gooru default image.
	 */
	public void uploadGooruDefaultImage(String imageURL) {
		this.getMediaUploadService().imageWebUpload(imageURL, getGooruDefaultProfileUploadAsyncCallback());
	}
	/**
	 * This method is used to crop the image.
	 */
	@Override
	public void cropImage(String fileName, String height, String width, String xPostion, String yPosition,String imageUrl) {
		this.fileNameWithoutRepository=fileName;
		//if(isCollectionImage||isQuestionImage){

		if(isCollectionImage||isUpdateQuestionImage||isClassPageImage){
			this.getMediaUploadService().cropImage(fileName, height, width, xPostion, yPosition,null, getCropImageAsyncCallback());
		}
		else{
			this.getMediaUploadService().cropImage(fileName, height, width, xPostion, yPosition,imageUrl, getCropImageAsyncCallback());
		}
	}
	/**
	 * This method is used to upload the image .
	 */
	@Override
	public void imageFileUpload(String response) {
		this.getMediaUploadService().imageFileUpload(response, getImageFileUploadAsyncCallback());
	}
	/**
	 * This method is used to set the image web async callback.
	 */
	public void setImageWebUploadAsyncCallback(SimpleAsyncCallback<MediaUploadDo> imageWebUploadAsyncCallback) {
		this.imageWebUploadAsyncCallback = imageWebUploadAsyncCallback;
	}
	/**
	 * This method is used to get the web uploaded async call.
	 */
	public SimpleAsyncCallback<MediaUploadDo> getImageWebUploadAsyncCallback() {
		return imageWebUploadAsyncCallback;
	}
	/**
	 * This method is used to set the upload service.
	 */
	public void setMediaUploadService(MediaUploadServiceAsync mediaUploadService) {
		this.mediaUploadService = mediaUploadService;
	}
	/**
	 * This method is used to get the media upload service.
	 */
	public MediaUploadServiceAsync getMediaUploadService() {
		return mediaUploadService;
	}
	/**
	 * This method is used to set the save image async call back.
	 */
	public void setSaveImageAsyncCallback(SimpleAsyncCallback<String> saveImageAsyncCallback) {
		this.saveImageAsyncCallback = saveImageAsyncCallback;
	}
	/**
	 * This method is used to get the save iamge async call back.
	 */
	public SimpleAsyncCallback<String> getSaveImageAsyncCallback() {
		return saveImageAsyncCallback;
	}
	/**
	 * This method is used to set crop image async callback.
	 */
	public void setCropImageAsyncCallback(SimpleAsyncCallback<String> cropImageAsyncCallback) {
		this.cropImageAsyncCallback = cropImageAsyncCallback;
	}
	/**
	 * This method is used to get the crop image async call back.
	 */
	public SimpleAsyncCallback<String> getCropImageAsyncCallback() {
		return cropImageAsyncCallback;
	}
	/**
	 * This method will assign the shelf view.
	 */
	public void setShelfView(IsShelfView shelfView) {
		this.shelfView = shelfView;
	}
	/**
	 * This method will get the shelf view.
	 */

	public IsShelfView getShelfView() {
		return shelfView;
	}
	/**
	 * This method will set the image file upalod async call back.
	 */
	public void setImageFileUploadAsyncCallback(SimpleAsyncCallback<MediaUploadDo> imageFileUploadAsyncCallback) {
		this.imageFileUploadAsyncCallback = imageFileUploadAsyncCallback;
	}
	/**
	 * This method will get the image file upalod async call back.
	 */
	public SimpleAsyncCallback<MediaUploadDo> getImageFileUploadAsyncCallback() {
		return imageFileUploadAsyncCallback;
	}
	/**
	 * This method will check is the user uploading collection image.
	 */
	public boolean isCollectionImage() {
		return isCollectionImage;
	}
	/**
	 * This method will set the user upload type as collection image.
	 */
	public void setCollectionImage(boolean isCollectionImage) {
		this.isCollectionImage = isCollectionImage;
	}
	/**
	 * This method will check is the user is in resource view.
	 */
	public IsAddResourceView getAddResourceView() {
		return addResourceView;
	}
	/**
	 * This method will set the user  in resource view.
	 */
	public void setAddResourceView(IsAddResourceView addResourceView) {
		this.addResourceView = addResourceView;
	}

	public AddResourcePresenter getAddResourcePresenter() {
		return addResourcePresenter;
	}

	public void setAddResourcePresenter(AddResourcePresenter addResourcePresenter) {
		this.addResourcePresenter = addResourcePresenter;
	}

	public boolean isQuestionImage() {
		return isQuestionImage;
	}

	public void setQuestionImage(boolean isQuestionImage) {
		this.isQuestionImage = isQuestionImage;
	}

	
	public SimpleAsyncCallback<String> getSaveQuestionImageAysncCallback() {
		return saveQuestionImageAysncCallback;
	}

	public void setSaveQuestionImageAysncCallback(
			SimpleAsyncCallback<String> saveQuestionImageAysncCallback) {
		this.saveQuestionImageAysncCallback = saveQuestionImageAysncCallback;
	}

	public boolean isUpdateQuestionImage() {
		return isUpdateQuestionImage;
	}

	public void setUpdateQuestionImage(boolean isUpdateQuestionImage) {
		this.isUpdateQuestionImage = isUpdateQuestionImage;
	}

	public String getCollectionItemId() {
		return collectionItemId;
	}

	public void setCollectionItemId(String collectionItemId) {
		this.collectionItemId = collectionItemId;
	}
	/** 
	 * This method is to get the isEditResourceImage
	 */
	public boolean getEditResourceImage() {
		return isEditResourceImage;
	}

	/** 
	 * This method is to set the isEditResourceImage
	 */
	public void setEditResourceImage(boolean isEditResourceImage) {
		this.isEditResourceImage = isEditResourceImage;
	}
	/**
	 * This method will return the simple async call back.
	 */
	public SimpleAsyncCallback<String> getUploadProfileImage() {
		return uploadProfileImageAsyncCallback;
	}
	/**
	 * This method will set the upload profile image view.
	 */
	public void setUploadProfileImage(SimpleAsyncCallback<String> uploadProfileImageAsyncCallback) {
		this.uploadProfileImageAsyncCallback = uploadProfileImageAsyncCallback;
	}
	/**
	 * This method will check the is on profile image view.
	 */
	public boolean isProfileImage() {
		return isProfileImage;
	}
	/**
	 * This method will set the profile image.
	 */
	public void setProfileImage(boolean isProfileImage) {
		getView().setAspectRatio(1.0f);
		this.isProfileImage = isProfileImage;
	}
	/**
	 * This method will display the upload type widgets.
	 */
	public void showUploadTypeWidgets(boolean isUserUnder13){
		getView().showUploadTypeWidgets(isUserUnder13);
	}
	/**
	 * This method will return the simple async call back.
	 */
	public SimpleAsyncCallback<MediaUploadDo> getGooruDefaultProfileUploadAsyncCallback() {
		return gooruDefaultProfileUploadAsyncCallback;
	}
	/**
	 * This method will set the gooru default image async call back.
	 */
	public void setGooruDefaultProfileUploadAsyncCallback(
			SimpleAsyncCallback<MediaUploadDo> gooruDefaultProfileUploadAsyncCallback) {
		this.gooruDefaultProfileUploadAsyncCallback = gooruDefaultProfileUploadAsyncCallback;
	}
	/**
	 * This method will check the public profile image.
	 */
	public boolean isPublicProfileImage() {
		return isPublicProfileImage;
	}
	/**
	 * This method will set the public profile image.
	 */
	public void setPublicProfileImage(boolean isPublicProfileImage) {
		getView().setAspectRatio(1.0f);
		this.isPublicProfileImage = isPublicProfileImage;
	}
	/**
	  * This method will check the user is on class page view.
	  */
	public boolean isClassPageImage() {
		return isClassPageImage;
	}
	/**
	  * This method will set the class page image.
	  */
	public void setClassPageImage(boolean isClassPageImage) {
		getView().setAspectRatio(4.53f);
		this.isClassPageImage = isClassPageImage;
	}
	/**
	  * This method will return the class page id.
	  */
	public String getClasspageId() {
		return classpageId;
	}
	/**
	  * This method will set the class page id.
	  */
	public void setClasspageId(String classpageId) {
		this.classpageId = classpageId;
	}
	/**
	  * This method will check the user own resoruce image view.
	  */
	public boolean isUserOwnResourceImage() {
		return isuserOwnResourceImage;
	}
	 /**
	  * This method will set the user own resoruce image view.
	  */
	public void setUserOwnResourceImage(boolean isuserOwnResourceImage) {
		this.isuserOwnResourceImage = isuserOwnResourceImage;
	}
	 /**
	  * This method will check the edit user own resource image.
	  */
	public boolean isEditUserOwnResourceImage() {
		return isEditUserOwnResourceImage;
	}
	 /**
	  * This method will set the edit user own resource image.
	  */
	public void setEditUserOwnResourceImage(boolean isEditUserOwnResourceImage) {
		this.isEditUserOwnResourceImage = isEditUserOwnResourceImage;
	}
	 /**
	  * This method will check is update profile image.
	  */
	public boolean isUdateProfileImage() {
		return isUdateProfileImage;
	}
	 /**
	  * This method will set the update profile image.
	  */
	public void setUdateProfileImage(boolean isUdateProfileImage) {
		getView().setAspectRatio(1.0f);
		this.isUdateProfileImage = isUdateProfileImage;
	}


}
