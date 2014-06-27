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
package org.ednovo.gooru.client.mvp.folders.edit.tab.content;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.folders.event.RefreshFolderType;
import org.ednovo.gooru.client.mvp.folders.item.FolderItemChildView;
import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 * 
 */
public class FolderContentTabView extends BaseViewWithHandlers<FolderContentTabUiHandlers> implements IsFolderContentTabView {

	
	@UiField
	Label newFolderUIHandler, newCollectionUIHandler;

	@UiField
	VerticalPanel workspaceFoldersList;
	
	@UiField
	HTMLPanel noWorkspaceLbl;
	
	@UiField
	SecondThirdLevelFoldersPanelVc secondThirdLevelFoldersPanelVc;

	private String folderLevel;
	
	private String folderId;
	
	private CollectionDo collectionDo;
	
	private static FolderContentTabViewUiBinder uiBinder = GWT.create(FolderContentTabViewUiBinder.class);

	interface FolderContentTabViewUiBinder extends UiBinder<Widget, FolderContentTabView> {
	}

	/**
	 * Class constructor
	 */
	public FolderContentTabView() {
		setWidget(uiBinder.createAndBindUi(this));
		noWorkspaceLbl.getElement().getStyle().setDisplay(Display.NONE);
		workspaceFoldersList.getElement().getStyle().setFloat(Float.LEFT);
		secondThirdLevelFoldersPanelVc.getElement().getStyle().setFloat(Float.LEFT);
		newFolderUIHandler.getElement().setId("lblNewFolderUIHandler");
		newCollectionUIHandler.getElement().setId("lblNewCollectionUIHandler");
		noWorkspaceLbl.getElement().setId("lblNoWorkspace");
		workspaceFoldersList.getElement().setId("vpnlWorkspaceFoldersList");
		secondThirdLevelFoldersPanelVc.getElement().setId("stlfpnlSecondThirdLevelFoldersPanelVc");
	}

	@Override
	public void reset() {
		super.reset();
		secondThirdLevelFoldersPanelVc.clear();
	}

	@Override
	public void disablenoWorkspaceLbl() {
		noWorkspaceLbl.getElement().getStyle().setDisplay(Display.NONE);
	}
	
	@Override
	public void enablenoWorkspaceLbl() {
		noWorkspaceLbl.getElement().getStyle().setDisplay(Display.BLOCK);
	}

	@Override
	public void clearWorkspaceFoldersListPanel() {
		workspaceFoldersList.clear();
	}

	@UiHandler("newFolderUIHandler")
	public void OnClickNewFolder(ClickEvent event) {
		if(checkFolderCollectionSize()){
			AlertContentUc alertContentUc = new AlertContentUc("Oops!", "You've reached the limit of folders/collections you can add to a folder!");
		} else {
			folderLevel = AppClientFactory.getPlaceManager().getRequestParameter("level");
			folderId = AppClientFactory.getPlaceManager().getRequestParameter("folderid");
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("level", folderLevel);
			params.put("folderid", folderId);
			
			String courseName = "";
			int courseId = 0;
			for (CodeDo code : collectionDo.getTaxonomySet()) {
				if (code.getDepth() == 2 && !(courseId==0)) {
					courseName = code.getLabel();
					courseId = code.getCodeId();
				}
			}
			
			//AppClientFactory.fireEvent(new InsertMetaDataInNewFolderEvent(collectionDo.getGrade(), courseName, courseId));
			AppClientFactory.getPlaceManager().revealPlace(
					PlaceTokens.CREATEFOLDER, params);
		}
	}
	
	@UiHandler("newCollectionUIHandler")
	public void OnClickNewCollection(ClickEvent event) {
		if(checkFolderCollectionSize()){
			AlertContentUc alertContentUc = new AlertContentUc("Oops!", "You've reached the limit of folders/collections you can add to a folder!");
		} else {
		folderLevel = AppClientFactory.getPlaceManager().getRequestParameter("level");
		folderId = AppClientFactory.getPlaceManager().getRequestParameter("folderid");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("level", folderLevel);
		params.put("folderid", folderId);
		AppClientFactory.getPlaceManager().revealPlace(
				PlaceTokens.COLLECTION, params);
		}
	}
	
	@Override
	public void addFolder(CollectionItemDo collectionItemDo) {
		Label label = new Label("");
		label.setStyleName("secondThirdFolderDragdropSpacer");
		secondThirdLevelFoldersPanelVc.superAdd(label);
		Label toplabel = new Label("");
		toplabel.setStyleName("secondThirdFolderDragdropSpacer");
		secondThirdLevelFoldersPanelVc.add(toplabel);
		FolderItemChildView folderItemChildView = new FolderItemChildView(collectionItemDo);
		workspaceFoldersList.add(folderItemChildView);
		secondThirdLevelFoldersPanelVc.addDraggable(folderItemChildView, collectionItemDo.getItemSequence());
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
	public void setData(CollectionDo collectionDo) {
		this.collectionDo = collectionDo;
		getUiHandlers().getSecondThirdLevelFolders();
	}

	@Override
	public void refreshCollectionInFolderLevelList(CollectionItemDo collectionItemDo, RefreshFolderType refreshType) {
		FolderItemChildView folderItemChildView = new FolderItemChildView(collectionItemDo);
		workspaceFoldersList.insert(folderItemChildView, 0);
		
	}

	@Override
	public void disableNewFolderUiHandler() {
		newFolderUIHandler.getElement().getStyle().setDisplay(Display.NONE);
	}

	@Override
	public void enableNewFolderUiHandler() {
		newFolderUIHandler.getElement().getStyle().setDisplay(Display.BLOCK);
	}
}
