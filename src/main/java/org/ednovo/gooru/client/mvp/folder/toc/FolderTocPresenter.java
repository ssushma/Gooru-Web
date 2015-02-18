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

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BasePlacePresenter;
import org.ednovo.gooru.client.mvp.folder.toc.FolderTocPresenter.IsFolderTocProxy;
import org.ednovo.gooru.shared.model.folder.FolderTocDo;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
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
	}
	
	@Override
	protected void onReset() {
		super.onReset();
		Window.enableScrolling(true);
		String folderId=AppClientFactory.getPlaceManager().getRequestParameter("id");
		AppClientFactory.getInjector().getfolderService().getTocFolders(folderId, new SimpleAsyncCallback<FolderTocDo>() {
			@Override
			public void onSuccess(FolderTocDo folderListDo) {
				getView().clearTocData();
				getView().setFolderItems(folderListDo);
			}
		});
	}
	
	@Override
	public void onBind() {
		super.onBind();
	}

	@Override
	public void getFolderItems(final TreeItem item, String folderId) {
		AppClientFactory.getInjector().getfolderService().getTocFolders(folderId,new SimpleAsyncCallback<FolderTocDo>() {
			@Override
			public void onSuccess(FolderTocDo folderListDo) {
				getView().setFolderItems(item,folderListDo);
			}
		});
	}
}
