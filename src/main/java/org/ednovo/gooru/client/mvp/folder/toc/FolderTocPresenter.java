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
package org.ednovo.gooru.client.mvp.folder.toc;

import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BasePlacePresenter;
import org.ednovo.gooru.client.mvp.folder.toc.FolderTocPresenter.IsFolderTocProxy;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.folder.FolderDo;
import org.ednovo.gooru.shared.model.folder.FolderTocDo;
import org.ednovo.gooru.shared.model.user.ProfileDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
/**
 * @fileName : FolderTocPresenter.java
 *
 * @description : 
 *
 * @version : 1.3
 *
 * @date: 06-02-2015
 *
 * @Author Gooru Team
 *
 * @Reviewer: 
 */
public class FolderTocPresenter extends BasePlacePresenter<IsFolderTocView, IsFolderTocProxy> implements FolderTocUiHandlers {

	private MessageProperties i18n = GWT.create(MessageProperties.class);

	@ProxyCodeSplit
	@NameToken(PlaceTokens.FOLDER_TOC)
	public interface IsFolderTocProxy extends ProxyPlace<FolderTocPresenter> {
	}

	@Inject
	public FolderTocPresenter(EventBus eventBus, IsFolderTocView view, IsFolderTocProxy proxy) {
		super(view, proxy);
		getView().setUiHandlers(this);
	}

	@Override
	public String getViewToken() {
		throw new RuntimeException("Not implemented");
	}

	@Override
	protected void onReveal() {
		super.onReveal();
		getView().getTreePanel();
		String folderId=AppClientFactory.getPlaceManager().getRequestParameter("id");
		final String parentId=AppClientFactory.getPlaceManager().getRequestParameter("parentId",null);
		final String libName=AppClientFactory.getPlaceManager().getRequestParameter("libName",null);
		final String userId=AppClientFactory.getPlaceManager().getRequestParameter("userId",null);
		//Check the user is logged in or not, and enabling the TOC if we are viewing from library
		if(AppClientFactory.isAnonymous() && StringUtil.isEmpty(folderId)){
			AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.HOME);
		}else{
			Window.enableScrolling(true);
			AppClientFactory.getInjector().getfolderService().getTocFolders(folderId, new SimpleAsyncCallback<FolderTocDo>() {
				@Override
				public void onSuccess(FolderTocDo folderListDo) {
					getView().clearTocData();
					getView().setFolderItems(folderListDo);
					//Set the back button text
					if(libName!=null){
						getView().setBackButtonText(i18n.GL3170());
					}else if(userId!=null){
						getView().setBackButtonText(i18n.GL3171());
					}else{
						getView().setBackButtonText(i18n.GL3172());
					}
				}
			});
			if(libName!=null){
				//This API used for to get the course image details of library.
				if(parentId!=null){
					AppClientFactory.getInjector().getfolderService().getFolderMetaData(parentId, new SimpleAsyncCallback<FolderDo>() {
						@Override
						public void onSuccess(FolderDo result) {
							if(result!=null && result.getThumbnails()!=null && result.getThumbnails().getUrl()!=""){
								getView().setCourseBanner(result);
							}else{
								getView().setBannerImages();
							}
						}
					});
				}else{
					getView().setBannerImages();
				}
			}else if(userId==null){
				//getView().showProfileBanner();
				getView().hidePanels();
			}
		}
	}

	@Override
	protected void onReset() {
		super.onReset();
	}

	@Override
	public void onBind() {
		super.onBind();
	}

	@Override
	public void getFolderItems(final TreeItem item,final String folderId) {
		AppClientFactory.getInjector().getfolderService().getTocFolders(folderId,new SimpleAsyncCallback<FolderTocDo>() {
			@Override
			public void onSuccess(FolderTocDo folderListDo) {
				getView().setFolderItems(item,folderListDo,folderId);
			}
		});
	}

	@Override
	public void getShortenUrl(String folderId, Map<String, String> params) {
		AppClientFactory.getInjector().getSearchService().getShortenShareUrl(folderId, params, new AsyncCallback<Map<String,String>>() {
			@Override
			public void onSuccess(Map<String, String> result) {
			}
			
			@Override
			public void onFailure(Throwable caught) {
			}
		});		
	}
    /**
     * To get the User profile details 
	 * @param profId {@link String}
     */
	@Override
	public void getProfilePageDetails(String profId) {
		AppClientFactory.getInjector().getUserService().getUserProfileV2Details(profId, "0", new SimpleAsyncCallback<ProfileDo>() {
			@Override
			public void onSuccess(ProfileDo profileDo) {
				if(profileDo!=null){
				 getView().setProfileBannerDetails(profileDo);	
				}
			}
		});
	}
}
