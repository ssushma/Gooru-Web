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
package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add;
/**
* @fileName : AddResourcePresenter.java 
*
* @description :This file is a UiBinder for AddResourcePresenter.
*
* @version :5.1
*
* @date: Apr 6 2013
   	
* @Author  Anil Tumbalam, Shiva Linga Reddy
* 
* @Reviewer 
*
*/


import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.IsCollectionResourceTabView;
import org.ednovo.gooru.client.mvp.shelf.event.AddResouceImageEvent;
import org.ednovo.gooru.client.service.ResourceServiceAsync;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.CollectionQuestionItemDo;
import org.ednovo.gooru.shared.model.content.ExistsResourceDo;
import org.ednovo.gooru.shared.model.content.ResourceMetaInfoDo;
import org.ednovo.gooru.shared.model.user.MediaUploadDo;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
/**
 * 
 * @fileName : AddResourcePresenter.java
 *
 * @description :This method is used to Add Resource 
 *
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class AddResourcePresenter extends PresenterWidget<IsAddResourceView> implements AddResourceUiHandlers{
	
	private ImageUploadPresenter imageUploadPresenter;
	
//	private ExistsResourcePresenter alreadyExistsResourcePresenter;
	
	private SimpleAsyncCallback<CollectionDo> collectionAsyncCallback;
	
	private SimpleAsyncCallback<CollectionItemDo> collectionItemAsyncCallback;
	
	private SimpleAsyncCallback<CollectionItemDo> userResourceCollectionItemAsyncCallback;
	
	private SimpleAsyncCallback<ResourceMetaInfoDo> resoureMetaInfoAsyncCallback;
	
	private SimpleAsyncCallback<ExistsResourceDo> resoureCheckAsyncCallback;
	
	private SimpleAsyncCallback<CollectionItemDo> addQuestionResourceAsyncCallback;
	
	private SimpleAsyncCallback<CollectionItemDo> updateQuestionResourceAsyncCallback;
	
	private SimpleAsyncCallback<Void> removeQuestionImageAsyncCallback; 
	
	/**
	 * 
	 * @function getAddQuestionResourceAsyncCallback 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This method is used to Get Added Question resources.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : SimpleAsyncCallback<CollectionItemDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public SimpleAsyncCallback<CollectionItemDo> getAddQuestionResourceAsyncCallback() {
		return addQuestionResourceAsyncCallback;
	}

	/**
	 * 
	 * @function setAddQuestionResourceAsyncCallback 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method is used to Set Added Question Resources.
	 * 
	 * 
	 * @parm(s) : @param addQuestionResourceAsyncCallback
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setAddQuestionResourceAsyncCallback(
			SimpleAsyncCallback<CollectionItemDo> addQuestionResourceAsyncCallback) {
		this.addQuestionResourceAsyncCallback = addQuestionResourceAsyncCallback;
	}

	IsCollectionResourceTabView isCollResourceTabView=null;
	
	@Inject
	private ResourceServiceAsync resourceService;
	
	CollectionDo collectionDo;
	
	String clickType;
	/**
	 * Constructor with below parameters.
	 * @param isCollResourceTabView
	 * @param eventBus
	 * @param view
	 * @param imageUploadPresenter
	 */
	@Inject
	public AddResourcePresenter(IsCollectionResourceTabView isCollResourceTabView, EventBus eventBus, IsAddResourceView view,ImageUploadPresenter imageUploadPresenter) {
		super(eventBus, view);
		this.setImageUploadPresenter(imageUploadPresenter);
		getView().setUiHandlers(this);
		addRegisteredHandler(AddResouceImageEvent.TYPE, this);
		
		this.isCollResourceTabView = isCollResourceTabView;
//		,ExistsResourcePresenter alreadyExistsResourcePresenter
//		this.alreadyExistsResourcePresenter = alreadyExistsResourcePresenter;

	}

	/**
	 * 
	 * @function resourceImageUpload 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method is used For image upload for Image Upload.
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@Override
	public void resourceImageUpload() {
		addToPopupSlot(imageUploadPresenter);
		imageUploadPresenter.setCollectionImage(false);
		imageUploadPresenter.setQuestionImage(false);
		imageUploadPresenter.setEditResourceImage(false);
		imageUploadPresenter.setUserOwnResourceImage(false);
		imageUploadPresenter.setEditUserOwnResourceImage(false);
		imageUploadPresenter.getView().isFromEditQuestion(true);
		
	}
	/**
	 * 
	 * @function userOwnResourceImageUpload 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method is used to Upload User Own Resource.
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@Override
	public void userOwnResourceImageUpload() {
		addToPopupSlot(imageUploadPresenter);
		imageUploadPresenter.setCollectionImage(false);
		imageUploadPresenter.setQuestionImage(false);
		imageUploadPresenter.setEditResourceImage(false);
		imageUploadPresenter.setEditUserOwnResourceImage(false);
		imageUploadPresenter.setUserOwnResourceImage(true);
		imageUploadPresenter.getView().isFromEditQuestion(true);
	}
	/**
	 * 
	 * @function questionImageUpload 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method is used to Upload Image Upload.
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@Override
	public void questionImageUpload() {
		addToPopupSlot(imageUploadPresenter);
		imageUploadPresenter.setCollectionImage(false);
		imageUploadPresenter.setQuestionImage(true);
		imageUploadPresenter.setEditResourceImage(false);
		imageUploadPresenter.setUserOwnResourceImage(false);
		imageUploadPresenter.setEditUserOwnResourceImage(false);
		imageUploadPresenter.getView().isFromEditQuestion(true);
	}
	/**
	 * 
	 * @function questionImageUpload 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method is used to Upload Image for question.
	 * 
	 * 
	 * @parm(s) : @param collectionItemId
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@Override
	public void questionImageUpload(String collectionItemId) {
		addToPopupSlot(imageUploadPresenter);
		imageUploadPresenter.setCollectionImage(false);
		imageUploadPresenter.setUpdateQuestionImage(true);
		imageUploadPresenter.setCollectionItemId(collectionItemId);
		imageUploadPresenter.setEditResourceImage(false);
        imageUploadPresenter.setQuestionImage(false);
        imageUploadPresenter.setUserOwnResourceImage(false);
        imageUploadPresenter.setEditUserOwnResourceImage(false);
        imageUploadPresenter.getView().isFromEditQuestion(true);
	}
/**
 * 
 * @function getImageUploadPresenter 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :This method is used to Get ImageUpload Presenter  
 * 
 * 
 * @parm(s) : @return
 * 
 * @return : ImageUploadPresenter
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	public ImageUploadPresenter getImageUploadPresenter() {
		return imageUploadPresenter;
	}

	/**
	 * 
	 * @function setImageUploadPresenter 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method is used to Set ImageUpload Presenter
	 * 
	 * 
	 * @parm(s) : @param imageUploadPresenter
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setImageUploadPresenter(ImageUploadPresenter imageUploadPresenter) {
		this.imageUploadPresenter = imageUploadPresenter;
	}
	
//	public void setImageUrl(String fileName,boolean isQuestionImage){
//		getView().setImageUrl(fileName,isQuestionImage);
//	}
/**
 * 
 * @function setResourceImageUrl 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :This method is used to Set Resource Url.
 * 
 * 
 * @parm(s) : @param fileName
 * @parm(s) : @param fileNameWithoutRepository
 * @parm(s) : @param isQuestionImage
 * @parm(s) : @param isUserOwnResourceImage
 * 
 * @return : void
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	@Override
	public void setResourceImageUrl(String fileName,String fileNameWithoutRepository,boolean isQuestionImage,boolean isUserOwnResourceImage) {
	    getView().setImageUrl(fileName,fileNameWithoutRepository,isQuestionImage,isUserOwnResourceImage);	
	}

	@Override
	protected void onBind() {
		super.onBind();
		
		setUserResourceCollectionItemAsyncCallback(new SimpleAsyncCallback<CollectionItemDo>() {

			@Override
			public void onSuccess(CollectionItemDo result) {
				getView().hide();
				isCollResourceTabView.insertData(result);
			}
		});
		/**
		 * This method is used to Set Collection Item.
		 */
		setCollectionItemAsyncCallback(new SimpleAsyncCallback<CollectionItemDo>() {

			@Override
			public void onSuccess(CollectionItemDo result) {
				
				getView().hide();
				isCollResourceTabView.insertData(result);
				MixpanelUtil.AddResourceByUrl();
				
//				updateShare("private");
				
			}
		});
		/**
		 * This method is used to Set Resource  MetaInformation
		 */
		setResoureMetaInfoAsyncCallback(new SimpleAsyncCallback<ResourceMetaInfoDo>() {

			@Override
			public void onSuccess(ResourceMetaInfoDo result) {
				getView().setNewResourcePopupData(result);

			}
		});
		/**
		 * This method is used to Set Resource  Check.
		 * 
		 */
		setResoureCheckAsyncCallback(new SimpleAsyncCallback<ExistsResourceDo>() {
			@Override
			public void onSuccess(ExistsResourceDo result) {
				
				if (result.getNativeurl()!=null)
					getView().setExistingResourceData(result, getCollectionDo());
			}
		});
		/**
		 * This method is used to Set Add Question .
		 */
		setAddQuestionResourceAsyncCallback(new SimpleAsyncCallback<CollectionItemDo>() {
            @Override
            public void onSuccess(CollectionItemDo result) {
            		getView().hide();
                    isCollResourceTabView.insertData(result);
                    MixpanelUtil.AddQuestion();
            }
		});
		/**
		 * This method is used to Set Remove Question Image 
		 */
		setRemoveQuestionImageAsyncCallback(new SimpleAsyncCallback<Void>(){
			@Override
			public void onSuccess(Void result) {
				getView().removeQuestionEditImage();
			}	
		});
		/**
		 * This method is used to Set Update Question Resources. 
		 */
		setUpdateQuestionResourceAsyncCallback(new SimpleAsyncCallback<CollectionItemDo>() {
            @Override
            public void onSuccess(CollectionItemDo result) {
            		getView().hide();
                    isCollResourceTabView.updateCollectionItem(result);
                    //MixpanelUtil.AddQuestion();
            }
		});
		
	}
	/**
	 * 
	 * @function addResource 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method is used to Add Resource 
	 * 
	 * 
	 * @parm(s) : @param idStr
	 * @parm(s) : @param urlStr
	 * @parm(s) : @param titleStr
	 * @parm(s) : @param descriptionStr
	 * @parm(s) : @param categoryStr
	 * @parm(s) : @param thumbnailImgSrcStr
	 * @parm(s) : @param endTime
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@Override
	public void addResource(String idStr, String urlStr,String titleStr, String descriptionStr, String categoryStr, String thumbnailImgSrcStr, Integer endTime) {
	
		getResourceService().addNewResource("", collectionDo.getGooruOid(), urlStr, titleStr, descriptionStr, categoryStr, thumbnailImgSrcStr, endTime, getCollectionItemAsyncCallback());
		
	}
	/**
	 * This method is used to get Resource Meta Information
	 */
	@Override
	public void getResourceMetaInfo(String url){
		getResourceService().getResourceMetaInfo(url, resoureMetaInfoAsyncCallback);
	}
	/**
	 * This method is used to get Resource Exists
	 */
	@Override
	public void getResourceExists(String url){
		getResourceService().checkResourceExists(url, resoureCheckAsyncCallback);
	}
	/**
	 * This method is used to Set Simple Async Callback
	 */
	public SimpleAsyncCallback<ResourceMetaInfoDo> getResoureMetaInfoAsyncCallback() {
		return resoureMetaInfoAsyncCallback;
	}
	/**
	 * This method is used to set Resoure Meta Information 
	 */
	public void setResoureMetaInfoAsyncCallback(
			SimpleAsyncCallback<ResourceMetaInfoDo> resoureMetaInfoAsyncCallback) {
		this.resoureMetaInfoAsyncCallback = resoureMetaInfoAsyncCallback;
	}
	/**
	 * This method is used to Set Simple Async Callback
	 */
	public SimpleAsyncCallback<CollectionDo> getCollectionAsyncCallback() {
		return collectionAsyncCallback;
	}
	/**
	 * This method is used to setCollection 
	 */
	public void setCollectionAsyncCallback(SimpleAsyncCallback<CollectionDo> collectionAsyncCallback) {
		this.collectionAsyncCallback = collectionAsyncCallback;
	}
	/**
	 * This method is used to Set Resource 
	 */
	public ResourceServiceAsync getResourceService() {
		return resourceService;
	}
	/**
	 * This method is used to set Resource Service
	 */
	public void setResourceService(ResourceServiceAsync resourceService) {
		this.resourceService = resourceService;
	}
	
	/*@Override
	public void updateShare(String shareType) {
		AppClientFactory.getInjector().getResourceService().updateCollectionMetadata(collectionDo.getGooruOid(), null, null, null, shareType, null, null, null, null, new SimpleAsyncCallback<CollectionDo>() {

			@Override
			public void onSuccess(CollectionDo result) {
				collectionDo = result;
				getView().hide();
			}
		});
	}*/
	public CollectionDo getCollectionDo() {
		return collectionDo;
	}
	/**
	 * This method is used to set Collection
	 */
	public void setCollectionDo(CollectionDo collectionDo) {
		
		this.collectionDo = collectionDo;
	}
	/**
	 * This method is used to set Collection ItemDo
	 */
	public void setCollectionItemDo(CollectionItemDo collectionItemDo){
		getView().setCollectionItemDo(collectionItemDo);
	}
	/**
	 * This method is used to Set Simple Async Callback
	 */
	public SimpleAsyncCallback<CollectionItemDo> getCollectionItemAsyncCallback() {
		return collectionItemAsyncCallback;
	}
	/**
	 * This method is used to Set  Collection Item
	 */
	public void setCollectionItemAsyncCallback(SimpleAsyncCallback<CollectionItemDo> collectionItemAsyncCallback) {
		this.collectionItemAsyncCallback = collectionItemAsyncCallback;
	}
	/**
	 * This method is used to Set Simple Async
	 */
	public SimpleAsyncCallback<ExistsResourceDo> getResoureCheckAsyncCallback() {
		return resoureCheckAsyncCallback;
	}
	/**
	 * This method is used to Set Resoure Check
	 */
	public void setResoureCheckAsyncCallback(SimpleAsyncCallback<ExistsResourceDo> resoureCheckAsyncCallback) {
		this.resoureCheckAsyncCallback = resoureCheckAsyncCallback;
	}
	/**
	 * This method is used to add Qeustion Resource
	 */
	@Override
	public void addQeustionResource(String mediaFileName, CollectionQuestionItemDo collectionQuestionItemDo) {
		getResourceService().addQuestionResource(collectionDo.getGooruOid(), mediaFileName, collectionQuestionItemDo, getAddQuestionResourceAsyncCallback());
		
	}
	/**
	 * This method is used to update Question Resource
	 */
	@Override
	public void updateQuestionResource(CollectionItemDo collectionItemDo,CollectionQuestionItemDo collectionQuestionItemDo,String thumbnailUrl) {
		getResourceService().updateQuestionResource(collectionItemDo, collectionQuestionItemDo,thumbnailUrl, getUpdateQuestionResourceAsyncCallback());
	}
	/**
	 * This method is used to get Parent Collection Details
	 */
	@Override
	public CollectionDo getParentCollectionDetails() {
		return this.collectionDo;
	}
	/**
	 * This method is used to Set CollectionDo And Type
	 */
	public void setCollectionDoAndType(CollectionDo collectionDo, String clickType) {
		this.collectionDo = collectionDo;
		this.clickType=clickType;
		getView().setPopup(clickType);
	}
	/**
	 * This method is used to Set Remove Question Image 
	 */
	@Override
	public void isShortenUrl(final String userUrlStr) {
		AppClientFactory.getInjector().getResourceService().checkShortenUrl(userUrlStr.trim(),new AsyncCallback<String>(){
			@Override
			public void onFailure(Throwable caught) {
				
			}

			@Override
			public void onSuccess(String result) {
				if(result.equalsIgnoreCase("True")){
					getView().setShortenUrlAlertMsg();
				}else{
					getView().getResourceMetaInfo(userUrlStr);
				}
				
			}
			
		});
	}
	
	@Override
	public void onHide(){
		super.onHide();
		getView().closePopUp();
	}
	/**
	 * This method is used to Set user Own Resource Upload
	 */
	@Override
	public void userOwnResourceUpload() {
		addToPopupSlot(imageUploadPresenter);
		
	}
	/**
	 * This method is used to Add User Own Resource
	 */
	@Override
	public void addUserOwnResource(String jsonString) {
		MixpanelUtil.Add_Resource_Computer_Success();
		getResourceService().addNewUserResource(jsonString, collectionDo.getGooruOid(), getUserResourceCollectionItemAsyncCallback());
	}
	/**
	 * This method is used to Set Remove Simple Async Callback
	 */
	public SimpleAsyncCallback<CollectionItemDo> getUserResourceCollectionItemAsyncCallback() {
		return userResourceCollectionItemAsyncCallback;
	}
	/**
	 * This method is used to Set Remove User Resource Collection Item
	 */
	public void setUserResourceCollectionItemAsyncCallback(SimpleAsyncCallback<CollectionItemDo> userResourceCollectionItemAsyncCallback) {
		this.userResourceCollectionItemAsyncCallback = userResourceCollectionItemAsyncCallback;
	}
	/**
	 * This method is used to Set Save User Resource
	 */
	@Override
	public void saveUserResource(String filePath) {
		AppClientFactory.getInjector().getResourceService().saveUserOwnResource(filePath,new SimpleAsyncCallback<MediaUploadDo>() {

			@Override
			public void onSuccess(MediaUploadDo result) {
				getView().uploadResource(result);
			}
		});
	}
	
	/**
	 * This method is used to Set Remove Question Image 
	 */
	@Override
	public void removeQuestionImage(String collectionItemId) {
		getResourceService().removeQuestionImage(collectionItemId, getRemoveQuestionImageAsyncCallback());
	}
	/**
	 * This method is used to Set simple Async Callback
	 */
	public SimpleAsyncCallback<Void> getRemoveQuestionImageAsyncCallback() {
		return removeQuestionImageAsyncCallback;
	}
	/**
	 * This method is used to Set Remove Question Image 
	 */
	public void setRemoveQuestionImageAsyncCallback(
			SimpleAsyncCallback<Void> removeQuestionImageAsyncCallback) {
		this.removeQuestionImageAsyncCallback = removeQuestionImageAsyncCallback;
	}
	/**
	 * This method is used to Set Remove Question Image 
	 */
	public SimpleAsyncCallback<CollectionItemDo> getUpdateQuestionResourceAsyncCallback() {
		return updateQuestionResourceAsyncCallback;
	}
	/**
	 * This method is used to Set Update Question Resource
	 */
	public void setUpdateQuestionResourceAsyncCallback(
			SimpleAsyncCallback<CollectionItemDo> updateQuestionResourceAsyncCallback) {
		this.updateQuestionResourceAsyncCallback = updateQuestionResourceAsyncCallback;
	}

}

