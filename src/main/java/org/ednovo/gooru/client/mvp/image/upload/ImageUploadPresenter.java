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

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.service.MediaUploadServiceAsync;
import org.ednovo.gooru.application.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.application.shared.model.folder.CreateDo;
import org.ednovo.gooru.application.shared.model.user.MediaUploadDo;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.mvp.classpage.event.setClassImageEvent;
import org.ednovo.gooru.client.mvp.classpages.event.UpdateClasspageImageEvent;
import org.ednovo.gooru.client.mvp.gshelf.collectiondetails.IsCollectionInfoView;
import org.ednovo.gooru.client.mvp.home.event.SetUpdateProfileImageEvent;
import org.ednovo.gooru.client.mvp.home.event.SetUserProfileImageEvent;
import org.ednovo.gooru.client.mvp.profilepage.event.SetUserPublicProfileImageEvent;
import org.ednovo.gooru.client.mvp.profilepage.event.UpdateProfileHeaderImageEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddResourcePresenter;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.IsAddResourceView;
import org.ednovo.gooru.client.mvp.shelf.event.AddAnswerImageEvent;
import org.ednovo.gooru.client.mvp.shelf.event.AddResouceImageEvent;
import org.ednovo.gooru.client.mvp.shelf.event.UpdateEditResourceImageEvent;
import org.ednovo.gooru.client.util.MixpanelUtil;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

/**
 * @author Search Team
 *
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
    private boolean isAnswerImage=false;

	private String collectionItemId;
	private String fileNameWithoutRepository=null;
	private String fileNameWithRepository=null;
	private boolean isImageUploadedFromUrl=false;
	private boolean isClassPageImage=false;
	private String classpageId=null;

	CreateDo createDoObj = new CreateDo();

	@Inject
	private MediaUploadServiceAsync mediaUploadService;

	private SimpleAsyncCallback<MediaUploadDo> imageWebUploadAsyncCallback;

	private SimpleAsyncCallback<String> cropImageAsyncCallback;

	private SimpleAsyncCallback<CollectionItemDo> saveImageAsyncCallback;

	private SimpleAsyncCallback<MediaUploadDo> imageFileUploadAsyncCallback;

	private SimpleAsyncCallback<CollectionItemDo> saveQuestionImageAysncCallback;

	private SimpleAsyncCallback<String> editResourceImageAysncCallback;

	private SimpleAsyncCallback<String> uploadProfileImageAsyncCallback;

	private SimpleAsyncCallback<MediaUploadDo> gooruDefaultProfileUploadAsyncCallback;

	private static final String GOORU_OID = "id";

	private IsCollectionInfoView shelfView;

	private IsAddResourceView addResourceView;

	private AddResourcePresenter addResourcePresenter;

	private SimpleAsyncCallback<String> saveImageCollectionAsyncCallback;


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
	public ImageUploadPresenter(IsCollectionInfoView isShelfView, IsAddResourceView addResourceView, EventBus eventBus, IsImageUploadView view) {
		super(eventBus, view);
		this.setShelfView(isShelfView);
		this.setAddResourceView(addResourceView);
		//this.setAddResourcePresenter(addResourcePresenter);
		getView().setUiHandlers(this);
	}

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
				super.onFailure(caught);
				getView().glasspanelLoadingImage(false);
			}
		});
		setCropImageAsyncCallback(new SimpleAsyncCallback<String>(){
			@Override
			public void onSuccess(String filename) {
				//getView().setCroppedImage(filename);
				setUploadData(filename);
			}
			@Override
			public void onFailure(Throwable caught) {
				super.onFailure(caught);
				getView().glasspanelLoadingImage(false);
			}
		});
		setSaveImageAsyncCallback(new SimpleAsyncCallback<CollectionItemDo>() {
			@Override
			public void onSuccess(CollectionItemDo collDo) {
				if(isClassPageImage){
					AppClientFactory.fireEvent(new UpdateClasspageImageEvent(collDo.getUrl()));
				}else{
					if(isImageUploadedFromUrl){
						MixpanelUtil.AddImageByUrlOntheWeb();
					}else{
						MixpanelUtil.AddImageFromMyComputer();
					}
				}
				getView().closeImageUploadWidget();
				getView().resetImageUploadWidget();
			}

			@Override
			public void onFailure(Throwable caught) {
				super.onFailure(caught);
				getView().glasspanelLoadingImage(false);
			}
		});
		setSaveImageCollectionAsyncCallback(new SimpleAsyncCallback<String>() {
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
				}
				getView().closeImageUploadWidget();
				getView().resetImageUploadWidget();
			}

			@Override
			public void onFailure(Throwable caught) {
				super.onFailure(caught);
				getView().glasspanelLoadingImage(false);
			}
		});
		setSaveQuestionImageAysncCallback(new SimpleAsyncCallback<CollectionItemDo>() {
			@Override
			public void onSuccess(CollectionItemDo collItem) {
				//AppClientFactory.fireEvent(new UpdateQuestionImageEvent(url,fileNameWithoutRepository));
				AppClientFactory.fireEvent(new AddResouceImageEvent(collItem.getUrl(),fileNameWithoutRepository,isUpdateQuestionImage,isuserOwnResourceImage));
				getView().closeImageUploadWidget();
				getView().resetImageUploadWidget();
			}
			@Override
			public void onFailure(Throwable caught) {
				super.onFailure(caught);
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
				}else{
					AppClientFactory.fireEvent(new SetUserPublicProfileImageEvent(imageUrl));
				}
				AppClientFactory.fireEvent(new UpdateProfileHeaderImageEvent(imageUrl));
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
				super.onFailure(caught);
				getView().glasspanelLoadingImage(false);
			}
		});
	}
	@Override
	public void setUploadData(String filename){
		if(isCollectionImage){
			getShelfView().setCollectionImage(fileNameWithRepository,fileNameWithoutRepository);
			getView().closeImageUploadWidget();
			getView().resetImageUploadWidget();
		}else if(isClassPageImage){
			saveImageClass(getClasspageId(), filename);
		}else if(isQuestionImage){
			AppClientFactory.fireEvent(new AddResouceImageEvent(filename,fileNameWithoutRepository,isQuestionImage,isuserOwnResourceImage));
			getView().closeImageUploadWidget();
			getView().resetImageUploadWidget();
		}else if(isUpdateQuestionImage){
			saveQuestionImage(filename);
		}else if (isEditResourceImage){
			AppClientFactory.fireEvent(new UpdateEditResourceImageEvent(filename,fileNameWithoutRepository,isEditUserOwnResourceImage));
			getView().closeImageUploadWidget();
			getView().resetImageUploadWidget();
		}else if(isEditUserOwnResourceImage){
			AppClientFactory.fireEvent(new UpdateEditResourceImageEvent(filename,fileNameWithoutRepository,isEditUserOwnResourceImage));
			getView().closeImageUploadWidget();
			getView().resetImageUploadWidget();
		}else if(isProfileImage||isPublicProfileImage||isUdateProfileImage){
			saveUserProfileImage(filename);
		}else if(isuserOwnResourceImage){
			AppClientFactory.fireEvent(new AddResouceImageEvent(filename,fileNameWithoutRepository,isQuestionImage,isuserOwnResourceImage));
			getView().closeImageUploadWidget();
			getView().resetImageUploadWidget();
		}else if(isAnswerImage){
			AppClientFactory.fireEvent(new AddAnswerImageEvent(filename,fileNameWithoutRepository,isAnswerImage,false));
			getView().closeImageUploadWidget();
			getView().resetImageUploadWidget();
		}else{
			AppClientFactory.fireEvent(new AddResouceImageEvent(filename,fileNameWithoutRepository,isQuestionImage,isuserOwnResourceImage));
			getView().closeImageUploadWidget();
			getView().resetImageUploadWidget();
		}
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
	@Override
	public void imageWebUpload(String imageURL) {
		AppClientFactory.printInfoLogger("imageURL---"+imageURL);
		this.getMediaUploadService().imageWebUpload(imageURL, getImageWebUploadAsyncCallback());
	}
	
	@Override
	public void checkFor404(final String imageURL) {
		this.getMediaUploadService().getResponseCode(imageURL, new AsyncCallback<Integer>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Integer result) {
				if(result==200)
				{
				getMediaUploadService().imageWebUpload(imageURL, getImageWebUploadAsyncCallback());
				getView().setDataUrlText(imageURL);
				}
				
			}
		});
	}

	@Override
	public void saveImage(String gooruOid, String fileName, String resourceId) {
		this.getMediaUploadService().saveImage(gooruOid, resourceId, fileName, getSaveImageAsyncCallback());
	}

	@Override
	public void saveImageCollection(String gooruOid, String fileName) {
		String o1= AppClientFactory.getPlaceManager().getRequestParameter("o1",null);
		String o2= AppClientFactory.getPlaceManager().getRequestParameter("o2",null);
		String o3= AppClientFactory.getPlaceManager().getRequestParameter("o3",null);
		String o4= AppClientFactory.getPlaceManager().getRequestParameter("id",null);
		//this.getMediaUploadService().saveImageCollection(o1,o2,o3,o4,createDoObj, fileName, getSaveImageCollectionAsyncCallback());
	}

	public void saveImageClass(String gooruOid,String fileName){
		getView().closeImageUploadWidget();
		getView().resetImageUploadWidget();
		AppClientFactory.getEventBus().fireEvent(new setClassImageEvent(fileNameWithRepository,fileNameWithoutRepository));
	}



	public void saveQuestionImage(String fileName){
		AppClientFactory.fireEvent(new AddResouceImageEvent(fileNameWithRepository,fileNameWithoutRepository,isUpdateQuestionImage,isuserOwnResourceImage));
		getView().closeImageUploadWidget();
		getView().resetImageUploadWidget();
		//this.getMediaUploadService().saveQuestionImage(getCollectionItemId(), fileName, saveQuestionImageAysncCallback);
	}

	/*public void saveResourceImage(String fileName){
		this.getMediaUploadService().saveResourceImage(getCollectionItemId(), fileName, editResourceImageAysncCallback);
	}*/

	public void saveUserProfileImage(String fileName){
		this.getMediaUploadService().uploadProfileImage(fileNameWithoutRepository,fileName, uploadProfileImageAsyncCallback);
	}
	public void saveUserProfileImage(MediaUploadDo mediaUpload){
		this.getMediaUploadService().uploadProfileImage(mediaUpload.getName(),mediaUpload.getUrl(), uploadProfileImageAsyncCallback);
	}
	public void uploadGooruDefaultImage(String imageURL) {
		this.getMediaUploadService().imageWebUpload(imageURL, getGooruDefaultProfileUploadAsyncCallback());
	}
	@Override
	public void cropImage(MediaUploadDo mediaUploadDo, String height, String width, String xPostion, String yPosition) {
		Window.enableScrolling(true);
		this.fileNameWithoutRepository=mediaUploadDo.getName();
		this.fileNameWithRepository=mediaUploadDo.getUrl();
		this.getMediaUploadService().cropImage(mediaUploadDo.getName(), height, width, xPostion, yPosition,mediaUploadDo.getUrl(), getCropImageAsyncCallback());
	}

	@Override
	public void imageFileUpload(String response) {
		AppClientFactory.printInfoLogger("imageFileUpload response---"+response);
		this.getMediaUploadService().imageFileUpload(response, getImageFileUploadAsyncCallback());
	}

	public void setImageWebUploadAsyncCallback(SimpleAsyncCallback<MediaUploadDo> imageWebUploadAsyncCallback) {
		this.imageWebUploadAsyncCallback = imageWebUploadAsyncCallback;
	}

	public SimpleAsyncCallback<MediaUploadDo> getImageWebUploadAsyncCallback() {
		return imageWebUploadAsyncCallback;
	}

	public void setMediaUploadService(MediaUploadServiceAsync mediaUploadService) {
		this.mediaUploadService = mediaUploadService;
	}

	public MediaUploadServiceAsync getMediaUploadService() {
		return mediaUploadService;
	}

	public void setSaveImageAsyncCallback(SimpleAsyncCallback<CollectionItemDo> saveImageAsyncCallback) {
		this.saveImageAsyncCallback = saveImageAsyncCallback;
	}

	public SimpleAsyncCallback<CollectionItemDo> getSaveImageAsyncCallback() {
		return saveImageAsyncCallback;
	}

	public void setCropImageAsyncCallback(SimpleAsyncCallback<String> cropImageAsyncCallback) {
		this.cropImageAsyncCallback = cropImageAsyncCallback;
	}

	public SimpleAsyncCallback<String> getCropImageAsyncCallback() {
		return cropImageAsyncCallback;
	}

	public void setShelfView(IsCollectionInfoView shelfView) {
		this.shelfView = shelfView;
	}

	public IsCollectionInfoView getShelfView() {
		return shelfView;
	}

	public void setImageFileUploadAsyncCallback(SimpleAsyncCallback<MediaUploadDo> imageFileUploadAsyncCallback) {
		this.imageFileUploadAsyncCallback = imageFileUploadAsyncCallback;
	}

	public SimpleAsyncCallback<MediaUploadDo> getImageFileUploadAsyncCallback() {
		return imageFileUploadAsyncCallback;
	}

	public boolean isCollectionImage() {
		return isCollectionImage;
	}

	public void setCollectionImage(boolean isCollectionImage) {
		getView().setAspectRatio(1.3f);
		this.isCollectionImage = isCollectionImage;
	}

	public void setCollectionData(CreateDo createDo) {
		this.createDoObj = createDo;
	}

	public IsAddResourceView getAddResourceView() {
		return addResourceView;
	}

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


	public SimpleAsyncCallback<CollectionItemDo> getSaveQuestionImageAysncCallback() {
		return saveQuestionImageAysncCallback;
	}

	public void setSaveQuestionImageAysncCallback(
			SimpleAsyncCallback<CollectionItemDo> saveQuestionImageAysncCallback) {
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

	public SimpleAsyncCallback<String> getUploadProfileImage() {
		return uploadProfileImageAsyncCallback;
	}

	public void setUploadProfileImage(SimpleAsyncCallback<String> uploadProfileImageAsyncCallback) {
		this.uploadProfileImageAsyncCallback = uploadProfileImageAsyncCallback;
	}

	public boolean isProfileImage() {
		return isProfileImage;
	}

	public void setProfileImage(boolean isProfileImage) {
		getView().setAspectRatio(1.3f);
		this.isProfileImage = isProfileImage;
	}

	public void showUploadTypeWidgets(boolean isUserUnder13){
		getView().showUploadTypeWidgets(isUserUnder13);
	}

	public SimpleAsyncCallback<MediaUploadDo> getGooruDefaultProfileUploadAsyncCallback() {
		return gooruDefaultProfileUploadAsyncCallback;
	}

	public void setGooruDefaultProfileUploadAsyncCallback(
			SimpleAsyncCallback<MediaUploadDo> gooruDefaultProfileUploadAsyncCallback) {
		this.gooruDefaultProfileUploadAsyncCallback = gooruDefaultProfileUploadAsyncCallback;
	}

	public boolean isPublicProfileImage() {
		return isPublicProfileImage;
	}

	public void setPublicProfileImage(boolean isPublicProfileImage) {
		getView().setAspectRatio(1.3f);
		this.isPublicProfileImage = isPublicProfileImage;
	}

	public boolean isClassPageImage() {
		return isClassPageImage;
	}

	public void setClassPageImage(boolean isClassPageImage) {
		getView().setAspectRatio(4.53f);
		this.isClassPageImage = isClassPageImage;
	}

	public String getClasspageId() {
		return classpageId;
	}

	public void setClasspageId(String classpageId) {
		this.classpageId = classpageId;
	}

	public boolean isUserOwnResourceImage() {
		return isuserOwnResourceImage;
	}

	public void setUserOwnResourceImage(boolean isuserOwnResourceImage) {
		this.isuserOwnResourceImage = isuserOwnResourceImage;
	}

	public boolean isEditUserOwnResourceImage() {
		return isEditUserOwnResourceImage;
	}

	public void setEditUserOwnResourceImage(boolean isEditUserOwnResourceImage) {
		this.isEditUserOwnResourceImage = isEditUserOwnResourceImage;
	}

	public boolean isUdateProfileImage() {
		return isUdateProfileImage;
	}

	public void setUdateProfileImage(boolean isUdateProfileImage) {
		getView().setAspectRatio(1.3f);
		this.isUdateProfileImage = isUdateProfileImage;
	}

	public SimpleAsyncCallback<String> getSaveImageCollectionAsyncCallback() {
		return saveImageCollectionAsyncCallback;
	}

	public void setSaveImageCollectionAsyncCallback(
			SimpleAsyncCallback<String> saveImageCollectionAsyncCallback) {
		this.saveImageCollectionAsyncCallback = saveImageCollectionAsyncCallback;
	}

	public boolean isAnswerImage() {
		return isAnswerImage;
	}

	public void setAnswerImage(boolean isAnswerImage) {
		if(isAnswerImage){
			getView().setAspectRatio(1.0f);
		}
		this.isAnswerImage = isAnswerImage;
	}
}
