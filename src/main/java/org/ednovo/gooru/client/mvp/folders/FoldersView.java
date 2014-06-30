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
package org.ednovo.gooru.client.mvp.folders;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.classpages.resource.item.ClasspageResourceItemChildView;
import org.ednovo.gooru.client.mvp.folders.event.RefreshFolderType;
import org.ednovo.gooru.client.mvp.folders.item.FolderItemChildView;
import org.ednovo.gooru.client.mvp.shelf.ShelfCBundle;
import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class FoldersView extends BaseViewWithHandlers<FoldersUiHandlers> implements IsFoldersView,ClickHandler {

	@UiField(provided = true)
	ShelfCBundle res;

	@UiField
	Label newFolderUIHandler, newCollectionUIHandler/*, folderPanelRedirect*/;
	
	@UiField 
	SimplePanel shelfTabSimPanel;
	
	@UiField
	VerticalPanel workspaceFoldersList;
	
	@UiField
	HTMLPanel noWorkspaceLbl, noFoldersLeftPanelmsg;
	
	@UiField
	HTML backToSearchPreHtml, backToSearchHtml;
	
	@UiField
	FlowPanel welcomeWorkspaceMsg, backToSearchFloPanel;
	
	@UiField
	FoldersPanelVc foldersPanelVc;

	private PlaceRequest searchRequest = null;
	
	private static final String PRE_SEARCH_LINK = "Back To Search \"";
	
	private static FoldersViewUiBinder uiBinder = GWT
			.create(FoldersViewUiBinder.class);

	interface FoldersViewUiBinder extends UiBinder<Widget, FoldersView> {

	}

	@Inject
	public FoldersView() {
		res = ShelfCBundle.INSTANCE;
		ShelfCBundle.INSTANCE.css().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));
		noWorkspaceLbl.getElement().getStyle().setDisplay(Display.NONE);
		noFoldersLeftPanelmsg.getElement().getStyle().setDisplay(Display.NONE);
		welcomeWorkspaceMsg.getElement().getStyle().setDisplay(Display.NONE);
		backToSearchFloPanel.getElement().getStyle().setDisplay(Display.NONE);
		backToSearchHtml.addClickHandler(this);
		
		backToSearchFloPanel.getElement().setId("fpnlBackToSearchFloPanel");
		backToSearchPreHtml.getElement().setId("htmlBackToSearchPreHtml");
		backToSearchHtml.getElement().setId("htmlBackToSearchHtml");
		noFoldersLeftPanelmsg.getElement().setId("pnlNoFoldersLeftPanelmsg");
		shelfTabSimPanel.getElement().setId("spnlShelfTabSim");
		newFolderUIHandler.getElement().setId("lblNewFolderUIHandler");
		newCollectionUIHandler.getElement().setId("lblNewCollectionUIHandler");
		noWorkspaceLbl.getElement().setId("pnlNoWorkspace");
		welcomeWorkspaceMsg.getElement().setId("fpnlWelcomeWorkspaceMsg");
		workspaceFoldersList.getElement().setId("vpnlWorkspaceFoldersList");
		foldersPanelVc.getElement().setId("folderpnlFoldersPanelVc");
	}

	@UiHandler("newFolderUIHandler")
	public void OnClickNewFolder(ClickEvent event) {
		if(checkFolderCollectionSize()) {
			AlertContentUc alertContentUc = new AlertContentUc("Oops!", "You've reached the limit of folders/collections you can add to a folder!");
		} else {
			getUiHandlers().initCreateFolder();
		}
	}
	
/*	@UiHandler("folderPanelRedirect")
	public void OnClickFolderPanelRedirect(ClickEvent event) {
			getUiHandlers().initFolderRedirect();
	}
*/	
	@UiHandler("newCollectionUIHandler")
	public void OnClickNewCollection(ClickEvent event) {
		if(checkFolderCollectionSize()) {
			AlertContentUc alertContentUc = new AlertContentUc("Oops!", "You've reached the limit of folders/collections you can add to a folder!");
		} else {
			getUiHandlers().initCreateCollection();
		}
	}
		
	@Override
	public void setInSlot(Object slot, Widget content) {
		if (content != null) {
			if (slot == FoldersUiHandlers.TYPE_FOLDERS_SHELF_VIEW) {
				shelfTabSimPanel.setWidget(content);
			}
		}
	}

	@Override
	public void addFolder(CollectionItemDo collectionItemDo) {
		Label label = new Label("");
//		label.setStyleName(res.css().folderDragdropSpacer());
		foldersPanelVc.superAdd(label);
		Label toplabel = new Label("");
//		toplabel.setStyleName(res.css().folderDragdropSpacer());
		foldersPanelVc.add(toplabel);
		FolderItemChildView folderItemChildView = new FolderItemChildView(collectionItemDo);
		workspaceFoldersList.add(folderItemChildView);
		foldersPanelVc.addDraggable(folderItemChildView,collectionItemDo.getItemSequence());
	}

	@Override
	public void removeFolder(CollectionItemDo collectionItemDo,
			ClasspageResourceItemChildView classpageChildView) {
	}

	@Override
	public void disablenoWorkspaceLbl() {
		noWorkspaceLbl.getElement().getStyle().setDisplay(Display.NONE);
		noFoldersLeftPanelmsg.getElement().getStyle().setDisplay(Display.NONE);
		welcomeWorkspaceMsg.getElement().getStyle().setDisplay(Display.NONE);
	}

	@Override
	public void enablenoWorkspaceLbl() {
		if(!(workspaceFoldersList.getWidgetCount()>0)){
			noWorkspaceLbl.getElement().getStyle().setDisplay(Display.BLOCK);
			noFoldersLeftPanelmsg.getElement().getStyle().setDisplay(Display.BLOCK);
			welcomeWorkspaceMsg.getElement().getStyle().setDisplay(Display.BLOCK);
			welcomeWorkspaceMsg.clear();
			welcomeWorkspaceMsg.add(new FoldersWelcomePage());
		}
	}

	@Override
	public void clearWorkspaceFoldersListPanel() {
		workspaceFoldersList.clear();
		foldersPanelVc.clear();
	}

	@Override
	public void refreshCollectionInFolderList(CollectionItemDo collectionItemDo,
			RefreshFolderType refreshType) {
		FolderItemChildView folderItemChildView = new FolderItemChildView(collectionItemDo);
		workspaceFoldersList.insert(folderItemChildView, 0);
		foldersPanelVc.addDraggable(folderItemChildView,0);
	}

	@Override
	public void setBackToSearch() {
		boolean visible = false;
		searchRequest = AppClientFactory.getPlaceManager().getPreviousRequest();
		if (searchRequest != null) {
			String query = searchRequest.getParameter("query", null);
			visible = searchRequest != null && query != null;
			backToSearchFloPanel.getElement().getStyle().setDisplay(Display.BLOCK);
			if (visible) {
				if (query.length() > 50) {
					query = query.substring(0, 50) + "...";
					backToSearchHtml.setHTML(PRE_SEARCH_LINK + query + "\"");
					backToSearchHtml.getElement().setAttribute("alt",PRE_SEARCH_LINK + query + "\"");
					backToSearchHtml.getElement().setAttribute("title",PRE_SEARCH_LINK + query + "\"");
				} else {
					backToSearchHtml.setHTML(PRE_SEARCH_LINK + query + "\"");
					backToSearchHtml.getElement().setAttribute("alt",PRE_SEARCH_LINK + query + "\"");
					backToSearchHtml.getElement().setAttribute("title",PRE_SEARCH_LINK + query + "\"");
				}

			}
		}
		backToSearchPreHtml.setVisible(visible);
		backToSearchHtml.setVisible(visible);
	}

	/**
	 * This method checks for the limit of each folder/subfolder
	 * @return boolean
	 */
	public boolean checkFolderCollectionSize(){
		if(workspaceFoldersList.getWidgetCount()>50) {
			return true;
		}
		return false;
	}
	
	@Override
	public void onClick(ClickEvent event) {
		Object source = event.getSource();
		if (source.equals(backToSearchHtml)) {
			AppClientFactory.getPlaceManager().revealPlace(false, searchRequest);
		}
	}
}
