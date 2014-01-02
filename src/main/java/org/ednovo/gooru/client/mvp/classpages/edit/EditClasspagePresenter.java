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
/**
 * 
*/
package org.ednovo.gooru.client.mvp.classpages.edit;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SeoTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BasePlacePresenter;
import org.ednovo.gooru.client.mvp.classpages.assignments.AddAssignmentContainerPresenter;
import org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter.IsEditClasspageProxy;
import org.ednovo.gooru.client.mvp.classpages.event.RefreshAssignmentsListEvent;
import org.ednovo.gooru.client.mvp.classpages.event.UpdateClasspageImageEvent;
import org.ednovo.gooru.client.mvp.home.event.HeaderTabType;
import org.ednovo.gooru.client.mvp.home.event.HomeEvent;
import org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter;
import org.ednovo.gooru.client.mvp.search.event.ConfirmStatusPopupEvent;
import org.ednovo.gooru.client.mvp.search.event.SetFooterEvent;
import org.ednovo.gooru.client.mvp.shelf.ErrorPopup;
import org.ednovo.gooru.client.mvp.shelf.event.AssignmentEvent;
import org.ednovo.gooru.client.service.ClasspageServiceAsync;
import org.ednovo.gooru.shared.model.content.AssignmentsListDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
/**
 * 
 * @fileName : EditClasspagePresenter.java
 *
 * @description : This is the presenter of the  Edit Classpage.
 *
 * @version : 1.0
 *
 * @date: 27-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class EditClasspagePresenter extends BasePlacePresenter<IsEditClasspageView, IsEditClasspageProxy> implements EditClasspageUiHandlers {

	
	@Inject
	private ClasspageServiceAsync classpageService;
	
	private SimpleAsyncCallback<CollectionDo> collectionAsyncCallback;
	
	private SimpleAsyncCallback<CollectionItemDo> assignmentAsyncCallback;
	
	private SimpleAsyncCallback<CollectionDo> assignmentListAsyncCallback;
	
	private SimpleAsyncCallback<AssignmentsListDo> assignmentsListAsyncCallback;	

//	private ShelfListPresenter shelfListPresenter;
	
	private SimpleAsyncCallback<Map<String, String>> shareUrlGenerationAsyncCallback;
	
	private SimpleAsyncCallback<CollectionDo> updateAssignmentAsyncCallback;

	AddAssignmentContainerPresenter assignmentContainer=null;
	
	
	
	private ImageUploadPresenter imageUploadPresenter;
	
	String classpageId="";
	
	private boolean isApiCalled = false;
	
	//ShelfListPresenter shelfTabPresenter
	/**
	 * This is used to register the handlers.
	 * @param view
	 * @param proxy
	 * @param assignmentContainer
	 * @param imageUploadPresenter
	 */
	@Inject
	public EditClasspagePresenter(IsEditClasspageView view, IsEditClasspageProxy proxy, AddAssignmentContainerPresenter assignmentContainer,ImageUploadPresenter imageUploadPresenter) {
		super(view, proxy);
		
		getView().setUiHandlers(this);
		
//		this.shelfListPresenter = shelfTabPresenter;
		this.assignmentContainer = assignmentContainer;
		this.imageUploadPresenter=imageUploadPresenter;
		addRegisteredHandler(AssignmentEvent.TYPE, this);
		addRegisteredHandler(RefreshAssignmentsListEvent.TYPE, this);
		addRegisteredHandler(UpdateClasspageImageEvent.TYPE, this);
	}
	/**
	 * 
	 * Manually reveals a presenter. Only use this method if your presenter is configured
     * to use manual reveal via {@link Presenter#useManualReveal()}. This method should be
     * called following one or more asynchronous server calls in
     * {@link Presenter#prepareFromRequest(PlaceRequest)}.
	 *
	 */
	@ProxyCodeSplit
	@NameToken(PlaceTokens.EDIT_CLASSPAGE)
	public interface IsEditClasspageProxy extends ProxyPlace<EditClasspagePresenter> {
	}
	
	
	@Override
	public String getViewToken() {
		throw new RuntimeException("Not implemented");
	}
	/**
	 * Lifecycle method called whenever this presenter is about to be
	 * revealed.
	 */
	@Override
	protected void onReveal() {
		super.onReveal();
		Window.scrollTo(0, 0);
		AppClientFactory.fireEvent(new HomeEvent(HeaderTabType.TEACH));
		getView().clearPanel();
		if (AppClientFactory.isAnonymous()){
			AppClientFactory.getPlaceManager().redirectPlace(PlaceTokens.HOME);
		}
		
		//Call Event for Setting Confirm popup
		AppClientFactory.fireEvent(new ConfirmStatusPopupEvent(true));
		AppClientFactory.fireEvent(new SetFooterEvent(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken()));
	}
	/**
	 * This LifeCycle method called when the present is going to hide and it will close the all the popup's which are visible.
	 */
	@Override
	protected void onHide() {
		super.onHide();
		getView().closeAllOpenedPopUp();
		imageUploadPresenter.getView().closeImageUploadWidget();
		assignmentContainer.getView().onUnload();
		
	}
	/**
	 * This LifeCycle method is called when the binding the object. And it will check the permissions based on that it will 
	 * load the related view. 
	 */
	@Override
	public void onBind() {
		super.onBind();
		
		setCollectionAsyncCallback(new SimpleAsyncCallback<CollectionDo>() {

			@Override
			public void onSuccess(CollectionDo collectionDo) {
				try{
					if (collectionDo.getMeta().getPermissions().toString().contains("edit")){
						isApiCalled = true;
						getView().setData(collectionDo);
					}else{
						isApiCalled = false;
						ErrorPopup error = new ErrorPopup(MessageProperties.GL0341);
						error.center();
						error.show();
					}
				}catch(Exception e){
					
				}
			}
		});
		
		setAssignmentAsyncCallback(new SimpleAsyncCallback<CollectionItemDo>() {

			@Override
			public void onSuccess(CollectionItemDo result) {
//				getView().setAssignmentData(result,true);
//				TO DO....
			}
		});
		setShareUrlGenerationAsyncCallback(new SimpleAsyncCallback<Map<String, String>>() {
			@Override
			public void onSuccess(Map<String, String> shortenUrl) {
				getView().setShareUrl(shortenUrl);
			}
		});
		setAssignmentListAsyncCallback(new SimpleAsyncCallback<CollectionDo>() {

			@Override
			public void onSuccess(CollectionDo result) {
			
			}
		});
		
		setAssignmentsListAsyncCallback(new SimpleAsyncCallback<AssignmentsListDo>() {

			@Override
			public void onSuccess(AssignmentsListDo result) {
				getView().listAssignments(result);
			}
		});
		
	}
	/*@Override
	private void generateShareLink(String classpageId){
		Map<String, String> params = new HashMap<String, String>();
		params.put("type", AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken());
		AppClientFactory.getInjector().getSearchService().getShortenShareUrl(classpageId, params, getShareShortenUrlAsyncCallback());
	}*/
	
	/**
	 * This method is used to generate share link.
	 */
	@Override
	public void generateShareLink(String classpageId) {
		try{
			Map<String, String> params = new HashMap<String, String>();
			params.put("type", AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken());
			AppClientFactory.getInjector().getSearchService().getShortenShareUrl(classpageId, params, getShareShortenUrlAsyncCallback());
		}catch(Exception e){
			
		}
	}
	/**
	 * Lifecycle method called on all visible presenters whenever a
	 * presenter is revealed anywhere in the presenter hierarchy.
	 */
	@Override
	protected void onReset() {
//		setInSlot(TYPE_SHELF_TAB, shelfListPresenter);
		AppClientFactory.setBrowserWindowTitle(SeoTokens.TEACH_TITLE);
		AppClientFactory.setMetaDataDescription(SeoTokens.HOME_META_DESCRIPTION);
		AppClientFactory.fireEvent(new SetFooterEvent(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken()));
	}
	
	
	/**
	 * This method is used to get the class page details based on the classpageID.
	 */
	@Override
	public void getClasspageById(final String classpageId) {
		if (!isApiCalled){
			isApiCalled = true;
			getClasspageService().v2GetClasspageById(classpageId, getCollectionAsyncCallback());
//			AppClientFactory.getInjector().getClasspageService().checkPermissionsForClasspage(classpageId, new SimpleAsyncCallback<PermissionsDO>() {
//	
//				@Override
//				public void onSuccess(PermissionsDO result) {
//					String permissionValues = result.getPermissions().toString();
//					if (permissionValues.contains("edit")){
//						getClasspageService().v2GetClasspageById(classpageId, getCollectionAsyncCallback());
//					}else{
//						isApiCalled = false;
//						ErrorPopup error = new ErrorPopup(MessageProperties.GL0341);
//						error.center();
//						error.show();
//					}
//				}
//			});
		}
	}
	
	
	//// Setters and Getters //
	/** 
	 * This method is to get the assignmentsListAsyncCallback
	 */
	public AsyncCallback<AssignmentsListDo> getAssignmentsListAsyncCallback() {
		return assignmentsListAsyncCallback;
	}

	/** 
	 * This method is to set the assignmentsListAsyncCallback
	 */
	public void setAssignmentsListAsyncCallback(
			SimpleAsyncCallback<AssignmentsListDo> assignmentsListAsyncCallback) {
		this.assignmentsListAsyncCallback = assignmentsListAsyncCallback;
	}
	/**
	 * This method is used to set the share url Async call back.
	 */
	public void setShareUrlGenerationAsyncCallback(SimpleAsyncCallback<Map<String, String>> shareShortenUrlAsyncCallback) {
		this.shareUrlGenerationAsyncCallback = shareShortenUrlAsyncCallback;
	}
	/**
	 * This method is used to get the share url Async call back.
	 */
	public SimpleAsyncCallback<Map<String, String>> getShareShortenUrlAsyncCallback() {
		return shareUrlGenerationAsyncCallback;
	}
	
	/** 
	 * This method is to get the assignmentListAsyncCallback
	 */
	public SimpleAsyncCallback<CollectionDo> getAssignmentListAsyncCallback() {
		return assignmentListAsyncCallback;
	}

	/** 
	 * This method is to set the assignmentListAsyncCallback
	 */
	public void setAssignmentListAsyncCallback(
			SimpleAsyncCallback<CollectionDo> assignmentListAsyncCallback) {
		this.assignmentListAsyncCallback = assignmentListAsyncCallback;
	}
	
	/** 
	 * This method is to get the classpageService
	 */
	public ClasspageServiceAsync getClasspageService() {
		return classpageService;
	}

	/** 
	 * This method is to set the classpageService
	 */
	public void setClasspageService(ClasspageServiceAsync classpageService) {
		this.classpageService = classpageService;
	}
	
	/** 
	 * This method is to get the collectionAsyncCallback
	 */
	public SimpleAsyncCallback<CollectionDo> getCollectionAsyncCallback() {
		return collectionAsyncCallback;
	}

	/** 
	 * This method is to set the collectionAsyncCallback
	 */
	public void setCollectionAsyncCallback(
			SimpleAsyncCallback<CollectionDo> collectionAsyncCallback) {
		this.collectionAsyncCallback = collectionAsyncCallback;
	}
	/** 
	 * This method is to get the assignmentAsyncCallback
	 */
	public SimpleAsyncCallback<CollectionItemDo> getAssignmentAsyncCallback() {
		return assignmentAsyncCallback;
	}

	/** 
	 * This method is to set the assignmentAsyncCallback
	 */
	public void setAssignmentAsyncCallback(
			SimpleAsyncCallback<CollectionItemDo> assignmentAsyncCallback) {
		this.assignmentAsyncCallback = assignmentAsyncCallback;
	}
	// Custom Methods //
	/**
	 * This will allow the callback to reveal the presenter when the callback happens and it will call the initParam() method.
	 */
	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		if (AppClientFactory.getPlaceManager().refreshPlace()) {
			initParam();
		}
	}
	/**
	 * @function initParam 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This method is used to get the read the all the paremeters passed in the URL.
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private void initParam() {
		classpageId = getPlaceManager().getRequestParameter("classpageid");
		String pageSize = getPlaceManager().getRequestParameter("pageSize");
		String pageNum = getPlaceManager().getRequestParameter("pageNum");
		String pos = getPlaceManager().getRequestParameter("pos");
				
		getView().setClasspageId(classpageId);
		isApiCalled = false;
		getView().getClasspageById(classpageId, pageSize, pageNum, pos);
//		getView().getAssignemntsByClasspageId(classpageId, pageSize, pageNum);
//		getAssignmentsByClasspageById(classpageId, pageSize, pageNum);
//		generateShareLink(classpageId);
	}
	/**
	 * This method is used to add the assignments popup to the container.
	 */
	@Override
	public void addAssignmentsContainerPopup(String classpageId) {
		this.classpageId = classpageId;
		assignmentContainer.setClasspageId(classpageId);
		addToPopupSlot(assignmentContainer);
	}

	@Override
	public void insertAssignment(CollectionItemDo collectionItemDo) {	
		
//		getView().setAssignmentData(collectionItemDo,false);
	}
	
	// @description to get all Assignments of a particular classpages
	/**
	 * This method is used to get the Assignment By classpageID.
	 */
	@Override
	public void getAssignmentsByClasspageById(String classpageId, String pageSize, String pageNum) {
		getClasspageService().v2GetAssignemtsByClasspageId(classpageId,pageSize,pageNum, getAssignmentsListAsyncCallback());
	}

	/**
	 * This method is used to refresh the Assignments list.
	 */
	@Override
	public void refreshAssignmentsList(boolean isPostDeleteAssignment) {
		getView().onDeleteAssignment(isPostDeleteAssignment);
	}
	/**
	 * This method is used to update the class page info.
	 */
	@Override
	public void updateClassPageInfo(String classPageId,String collectionType, String title) {
		getClasspageService().v2UpdateClassPageByid(classPageId,collectionType, title, getUpdateAssignmentAsyncCallback());
	}
	/**
	 * @function getUpdateAssignmentAsyncCallback 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This method is used to get all update Assignments.
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : SimpleAsyncCallback<CollectionDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public SimpleAsyncCallback<CollectionDo> getUpdateAssignmentAsyncCallback() {
		if (updateAssignmentAsyncCallback == null) {
			updateAssignmentAsyncCallback = new SimpleAsyncCallback<CollectionDo>() {

				@Override
				public void onSuccess(CollectionDo result) {
					getView().onPostClassPageUpdate();
				}
			};
		}
		return updateAssignmentAsyncCallback;
	}
	/**
	 * @function setUpdateAssignmentAsyncCallback 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description :This method is used to set all update Assignments callback.
	 * 
	 * @parm(s) : @param updateAssignmentAsyncCallback
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setUpdateAssignmentAsyncCallback(
			SimpleAsyncCallback<CollectionDo> updateAssignmentAsyncCallback) {
		this.updateAssignmentAsyncCallback = updateAssignmentAsyncCallback;
	}
	/**
	 * This will display the upload image Widget
	 */
	@Override
	public void showImageUploadWidget() {
		imageUploadPresenter.setCollectionImage(false);
		imageUploadPresenter.setClassPageImage(true);
		imageUploadPresenter.setEditResourceImage(false);
		imageUploadPresenter.setClasspageId(classpageId);
		addToPopupSlot(imageUploadPresenter);
	}
	/**
	 * This will set the uploaded image to class page.
	 */
	@Override
	public void setUploadedImageToClassPage(String url){
		getView().setUploadedImageToClassPage(url);
	}
}
