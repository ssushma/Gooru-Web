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
package org.ednovo.gooru.client.mvp.gshelf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.application.client.AppPlaceKeeper;
import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BasePlacePresenter;
import org.ednovo.gooru.application.client.service.ResourceServiceAsync;
import org.ednovo.gooru.application.client.service.ShelfServiceAsync;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.application.shared.model.folder.FolderListDo;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.mvp.authentication.SignUpPresenter;
import org.ednovo.gooru.client.mvp.gshelf.courselist.MyCollectionsListPresenter;
import org.ednovo.gooru.client.mvp.gshelf.righttabs.MyCollectionsRightClusterPresenter;
import org.ednovo.gooru.client.mvp.home.AlmostDoneUc;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.SetFolderMetaDataEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.SetFolderParentNameEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabPresenter;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabPresenter;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabPresenter;
import org.ednovo.gooru.client.mvp.shelf.event.GetEditPageHeightEvent;
import org.ednovo.gooru.client.mvp.shelf.event.UpdateResourceCountEvent;
import org.ednovo.gooru.client.mvp.shelf.list.ShelfListView;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

/**
 * @author Search Team
 * 
 */
public class ShelfMainPresenter extends BasePlacePresenter<IsShelfMainView, ShelfMainPresenter.IsShelfMainProxy> implements ShelfMainUiHandlers {

	@Inject
	private ShelfServiceAsync shelfService;

	@Inject
	private ResourceServiceAsync resourceService;

	private boolean clrPanel=false;
	
	public static final  Object RIGHT_SLOT = new Object();
	
	MyCollectionsListPresenter myCollectionsListPresenter;
	
	SignUpPresenter signUpViewPresenter;
	
	MyCollectionsRightClusterPresenter myCollectionsRightClusterPresenter;
	
	boolean isApiCalled=false;
	
    private String O1_LEVEL_VALUE = null, O2_LEVEL_VALUE = null, O3_LEVEL_VALUE = null;
	
	private SimpleAsyncCallback<FolderListDo> userCollectionAsyncCallback;
	
	
	private static final String CALLBACK = "callback";
	
	String parentId;
	
	private List<FolderDo> searchResult = new ArrayList<FolderDo>();
	
	@ProxyCodeSplit
	@NameToken(PlaceTokens.MYCOLLECTION)
	@UseGatekeeper(AppPlaceKeeper.class)
	public interface IsShelfMainProxy extends ProxyPlace<ShelfMainPresenter> {

	}

	/**
	 * class constructor to set all class of instance
	 * 
	 * @param myCollectionsListPresenter
	 *            instance of {@link MyCollectionsListPresenter}
	 * @param signUpPresenter
	 *            instance of {@link SignUpPresenter}
	 * @param collectionResourceTabPresenter
	 *            instance of {@link CollectionResourceTabPresenter}
	 * @param collectionInfoTabPresenter
	 *            instance {@link CollectionInfoTabPresenter}
	 * @param collectionAssignTabPresenter
	 *            instance {@link CollectionAssignTabPresenter}
	 * @param view
	 *            {@link View}
	 * @param proxy
	 *            {@link Proxy}
	 */
	@Inject
	public ShelfMainPresenter(SignUpPresenter signUpViewPresenter,MyCollectionsListPresenter myCollectionsListPresenter,MyCollectionsRightClusterPresenter myCollectionsRightClusterPresenter,IsShelfMainView view, IsShelfMainProxy proxy) {
		super(view, proxy);
		getView().setUiHandlers(this);
		//getView().getLoadingImageVisible();
		this.signUpViewPresenter = signUpViewPresenter;
		this.myCollectionsListPresenter=myCollectionsListPresenter;
		this.myCollectionsRightClusterPresenter=myCollectionsRightClusterPresenter;
		
		addRegisteredHandler(GetEditPageHeightEvent.TYPE, this);
		addRegisteredHandler(UpdateResourceCountEvent.TYPE, this);
		Document doc = Document.get();
		doc.getBody().setClassName(""); 
		addRegisteredHandler(SetFolderParentNameEvent.TYPE, this);
		addRegisteredHandler(SetFolderMetaDataEvent.TYPE, this);
	}
	
	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		callBackMethods();
		getUserSheldId(); // this API call is to get shelf Id
	}

	private void callBackMethods(){
		if (getPlaceManager().getRequestParameter(CALLBACK) != null && getPlaceManager().getRequestParameter(CALLBACK).equalsIgnoreCase("signup")) {
			//To show SignUp (Registration popup)
			if (AppClientFactory.isAnonymous()){
				Window.enableScrolling(false);
				AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
				String type = getPlaceManager().getRequestParameter("type") ;
				int displayScreen =getPlaceManager().getRequestParameter("type") !=null  ? Integer.parseInt(type) : 1;
				signUpViewPresenter.displayPopup(displayScreen);
				addToPopupSlot(signUpViewPresenter);
			}
		}
		int flag = AppClientFactory.getLoggedInUser().getViewFlag();
		final String loginType = AppClientFactory.getLoggedInUser().getLoginType() !=null ? AppClientFactory.getLoggedInUser().getLoginType() : "";
		if(!AppClientFactory.isAnonymous() && flag==0 &&  !loginType.equalsIgnoreCase("Credential")) {
			AlmostDoneUc update = new AlmostDoneUc(AppClientFactory.getLoggedInUser().getEmailId(), AppClientFactory.getLoggedInUser());
			update.setGlassEnabled(true);
			update.show();
			update.center();
		}
	}
	
	
	@Override
	public void onBind() {
		super.onBind();
		Window.enableScrolling(true);
	}
	
	@Override
	public void onUnbind(){
		super.onUnbind();
	}
	
	@Override
	protected void onReveal() {
		super.onReveal();
		getResourceService().getFolderWorkspace((ShelfListView.getpageNumber()-1)*20, 20,null,null,false,getUserCollectionAsyncCallback(true));
		myCollectionsListPresenter.setData("Course");
		setInSlot(RIGHT_SLOT, myCollectionsListPresenter,false);	
	}
	
	@Override
	protected void onReset() {
		super.onReset();
		Window.enableScrolling(true);
		Window.scrollTo(0, 0);
	}
	
	public ShelfServiceAsync getShelfService() {
		return shelfService;
	}

	public ResourceServiceAsync getResourceService() {
		return resourceService;
	}

	public void setResourceService(ResourceServiceAsync resourceService) {
		this.resourceService = resourceService;
	}
	@Override
	public String getViewToken() {
		return PlaceTokens.SHELF;
	}

	@Override
	public void updateResourceCount(int resourceCount) {
		//getView().updateResoureCount(resourceCount);
		
	}
	
	public void getUserSheldId(){
		if(!AppClientFactory.isAnonymous()){
			String userUid=AppClientFactory.getLoggedInUser().getGooruUId();
			AppClientFactory.getInjector().getResourceService().getUserShelfDetails(userUid, new SimpleAsyncCallback<String>() {
				@Override
				public void onSuccess(String result) {
					AppClientFactory.getPlaceManager().setUserShelfId(result);
				}
			});
		}
	}

	@Override
	public void getEditPageHeight(PopupPanel editQuestionPopupPanel,boolean isHeightClear) {
		
	}
	
	public SimpleAsyncCallback<FolderListDo> getUserCollectionAsyncCallback(boolean clearShelfPanel) {
		clrPanel=clearShelfPanel;
		if (userCollectionAsyncCallback == null) {
			userCollectionAsyncCallback = new SimpleAsyncCallback<FolderListDo>() {
				@Override
				public void onSuccess(FolderListDo result) {
					getView().setUserShelfData(result.getSearchResult(),clrPanel);
				}
			};
		}
		return userCollectionAsyncCallback;
	}
	
	@Override
	public void getChildFolderItems(final String folderId, final boolean isDataCalled) {
		if(isDataCalled) {
			getView().getChildFolderItems(null);
		} else {
			AppClientFactory.getInjector().getfolderService().getChildFolders((getView().getChildPageNumber()-1)*20, 20, folderId,null, null,false,new SimpleAsyncCallback<FolderListDo>() {
				@Override
				public void onSuccess(FolderListDo result) {
					searchResult.addAll(result.getSearchResult());
					if(result.getSearchResult().size()==20) {
						getView().setChildPageNumber(getView().getChildPageNumber()+1);
						setPaginatedChildFolders(folderId, isDataCalled);
					} else {
						getView().setChildPageNumber(1);
						getView().getChildFolderItems(searchResult);
						searchResult.clear();
					}
				}
			});
		}
	}

	private void setPaginatedChildFolders(String folderId, boolean isDataCalled) {
		getChildFolderItems(folderId, isDataCalled);
	}

	@Override
	public void setFolderParentName(String folderName) {
		
	}

	@Override
	public void setFolderMetaData(Map<String, String> folderMetaData) {
		
	}

	@Override
	public void setListPresenterBasedOnType(String type) {
		clearSlot(RIGHT_SLOT);
		myCollectionsListPresenter.setData(type);
		setInSlot(RIGHT_SLOT, myCollectionsListPresenter,false);	
	}
}
