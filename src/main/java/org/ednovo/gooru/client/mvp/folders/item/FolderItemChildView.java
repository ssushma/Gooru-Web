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
package org.ednovo.gooru.client.mvp.folders.item;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.child.ChildView;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.model.content.CollectionDo;
import org.ednovo.gooru.application.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.client.mvp.dnd.IsDraggableMirage;
import org.ednovo.gooru.client.mvp.folders.event.RequestFolderEvent;
import org.ednovo.gooru.client.mvp.folders.newfolder.FolderDeleteConfirmationPopUp;
import org.ednovo.gooru.client.mvp.resource.dnd.ResourceDragUc;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshCollectionInShelfListEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshLevelFolderInShelfListEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshType;
import org.ednovo.gooru.client.mvp.shelf.event.RequestShelfEvent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Gooru Team
 * 
 */
public class FolderItemChildView extends ChildView<FolderItemChildPresenter> implements IsFolderItemView {

	@UiField(provided = true)
	FolderItemCBundle res;

	private CollectionItemDo collectionItemDo;

	@UiField
	Label folderTitleLbl,confirmDeleteLbl, openFolderpageLbl, folderdescriptionLbl;

	@UiField
	HTMLPanel folderIcon, collectionIcon, myFolderPageGoals,folderItemPanel;
	
	@UiField
	VerticalPanel actionVerPanel;

	private FolderDeleteConfirmationPopUp folderDeleteConfirmationPopUp;
	
	private String currentFolderLevel = null;
	
	private String currentLevel  = null;
	
	private final String FIRST_LEVEL_FOLDER = "1";

	private final String SECOND_LEVEL_FOLDER = "2";

	private final String THIRD_LEVEL_FOLDER = "3";

	private static FolderItemChildViewUiBinder uiBinder = GWT.create(FolderItemChildViewUiBinder.class);

	interface FolderItemChildViewUiBinder extends UiBinder<Widget, FolderItemChildView> {
	}

	/**
	 * Class constructor
	 * 
	 * @param collectionItem
	 *            instance of {@link CollectionItemDo}
	 */
	public FolderItemChildView(CollectionItemDo collectionItemDo) {
		res = FolderItemCBundle.INSTANCE;
		FolderItemCBundle.INSTANCE.css().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));
		this.collectionItemDo = collectionItemDo;
		setData(collectionItemDo);
		addDomHandler(new ActionPanelHover(), MouseOverEvent.getType());
		addDomHandler(new ActionPanelOut(), MouseOutEvent.getType());
		setPresenter(new FolderItemChildPresenter(this));
		actionVerPanel.setVisible(false);
		folderItemPanel.getElement().setId("pnlFolderItem");
		folderIcon.getElement().setId("pnlFolderIcon");
		collectionIcon.getElement().setId("pnlCollectionIcon");
		folderTitleLbl.getElement().setId("lblFolderTitle");
		myFolderPageGoals.getElement().setId("pnlMyFolderPageGoals");
		folderdescriptionLbl.getElement().setId("lblFolderdescription");
		actionVerPanel.getElement().setId("vpnlActionVer");
		openFolderpageLbl.getElement().setId("lblOpenFolderpage");
		confirmDeleteLbl.getElement().setId("lblConfirmDelete");
	}

	/**
	 * 
	 * To show the ResourceMetaDataInfo Edit,Copy and Remove buttons
	 */
	private class ActionPanelHover implements MouseOverHandler {
		@Override
		public void onMouseOver(MouseOverEvent event) {
			actionVerPanel.setVisible(true);
		}
	}

	/**
	 * 
	 * To hide the ResourceMetaDataInfo Edit,Copy and Remove buttons
	 */
	private class ActionPanelOut implements MouseOutHandler {
		@Override
		public void onMouseOut(MouseOutEvent event) {
			actionVerPanel.setVisible(false);
		}
	}

	/**
	 * set collection meta data , set title
	 * 
	 * 
	 * @param collection
	 *            instance of {@link CollectionDo}
	 */
	private void setData(CollectionItemDo collectionItemDo) {
		folderTitleLbl.setText(collectionItemDo.getResource().getTitle());
		folderdescriptionLbl.setText(collectionItemDo.getResource().getGoals());
		if(collectionItemDo.getResource().getResourceType().getName().equalsIgnoreCase("folder")){
			collectionIcon.removeFromParent();
			confirmDeleteLbl.setText("Delete Folder");
			myFolderPageGoals.setStyleName(res.css().myFolderPageGoals());
		} else if(collectionItemDo.getResource().getResourceType().getName().equalsIgnoreCase("collection")||collectionItemDo.getResource().getResourceType().getName().equalsIgnoreCase("scollection")) {
			folderIcon.removeFromParent();
			confirmDeleteLbl.setText("Delete Collection");
			myFolderPageGoals.setStyleName(res.css().myCollectionPageGoals());
		}
	}
	@UiHandler("confirmDeleteLbl")
	public void OnClickOnConfirmDeleteLbl(ClickEvent event)
	{
		folderDeleteConfirmationPopUp = new FolderDeleteConfirmationPopUp("Are you sure?", "\""+collectionItemDo.getResource().getTitle()+"\"" +  " Folder.") {

			@Override
			public void onTextConfirmed() {
				CollectionDo collectionDo = null;
				getPresenter().deleteMyFolder(collectionItemDo.getResource().getGooruOid(), collectionItemDo);
				folderDeleteConfirmationPopUp.hide();
//				Window.enableScrolling(true);
		        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));

//					AppClientFactory.fireEvent(new RefreshCollectionInShelfListEvent(collectionDo, RefreshType.DELETE));
			}
		};
	}

	@UiHandler("openFolderpageLbl")
	public void OnClickOpenFolderPage(ClickEvent event){
		String currentCollectionlevel="";
		currentLevel = AppClientFactory.getPlaceManager().getRequestParameter("level");
		if(currentLevel!=null){
			if(currentLevel.equalsIgnoreCase("1")) {
				currentCollectionlevel = "2"; 
			}else if(currentLevel.equalsIgnoreCase("2")) {
				currentCollectionlevel = "3";
			} 
		}else {
			currentCollectionlevel = "4";
		}
		if(collectionItemDo.getResource().getResourceType().getName().equalsIgnoreCase("collection")||collectionItemDo.getResource().getResourceType().getName().equalsIgnoreCase("scollection")) {
			AppClientFactory.fireEvent(new RequestShelfEvent(collectionItemDo.getResource().getGooruOid()));
			AppClientFactory.fireEvent(new RefreshLevelFolderInShelfListEvent(collectionItemDo.getResource().getGooruOid(), RefreshType.OPEN, currentCollectionlevel,0,false));
		} else {
			
			String currentFolder = AppClientFactory.getPlaceManager().getRequestParameter("folderid");
			Map<String, String> params = new HashMap<String, String>();
			
			if(currentLevel!=null){
				if(currentLevel.equalsIgnoreCase("1")) {
					params.put("level", "2");
					currentFolderLevel = "2"; 
				} else if(currentLevel.equalsIgnoreCase("2")) {
					params.put("level", "3");
					currentFolderLevel = "3";
				}
				params.put("parentid", currentFolder);
				params.put("folderid", collectionItemDo.getResource().getGooruOid());
				AppClientFactory.fireEvent(new RefreshLevelFolderInShelfListEvent(collectionItemDo.getResource().getGooruOid(), RefreshType.OPEN, currentFolderLevel,0,false));
				AppClientFactory.fireEvent(new RequestFolderEvent(collectionItemDo.getResource().getGooruOid(),params,true));
			} else {
				params.put("level", "1");
				currentFolderLevel = "1";
				params.put("parentid", currentFolder);
				params.put("folderid", collectionItemDo.getResource().getGooruOid());
				AppClientFactory.fireEvent(new RefreshLevelFolderInShelfListEvent(collectionItemDo.getResource().getGooruOid(), RefreshType.OPEN, currentFolderLevel,0,false));
				AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.EDIT_FOLDERS, params,false);
			}
			}
	}

	@Override
	public Widget getDragHandle() {
		return null;
	}

	@Override
	public IsDraggableMirage initDraggableMirage() {
		return new ResourceDragUc(collectionItemDo.getResource().getResourceType().getName(),
				collectionItemDo.getResource().getTitle());
	}

	@Override
	public void onDragBlur() {

	}

	@Override
	public String getDragId() {
		return collectionItemDo.getCollectionItemId();
	}

	@Override
	public DRAG_TYPE getDragType() {
		return DRAG_TYPE.COLLECTION_ITEM;
	}

	@Override
	public int getDragTopCorrection() {
		return 5;
	}

	@Override
	public int getDragLeftCorrection() {
		return 225;
	}
	@Override
	public void onPostFolderDelete() {
		CollectionDo collectionDo = new CollectionDo();
		folderDeleteConfirmationPopUp.hide();
		collectionDo.setTitle(collectionItemDo.getResource().getTitle());
		collectionDo.setGoals(collectionItemDo.getResource().getGoals());
		collectionDo.setGooruOid(collectionItemDo.getResource().getGooruOid());
		collectionDo.setCollectionType(collectionItemDo.getResource().getResourceType().getName());

		currentLevel = AppClientFactory.getPlaceManager().getRequestParameter("level");
		
		if(currentLevel!=null) {
				AppClientFactory.fireEvent(new RefreshLevelFolderInShelfListEvent(collectionItemDo.getResource().getGooruOid(), RefreshType.DELETE, currentLevel, 0, false));
		} else {
				AppClientFactory.fireEvent(new RefreshCollectionInShelfListEvent(collectionDo, RefreshType.DELETE));
		}
	}
	
	public void reorderFolderItem(int newSequence) { 
		collectionItemDo.setItemSequence(newSequence);
		getPresenter().reorderCollectionItem(collectionItemDo);
		new Timer() {

			@Override
			public void run() {
//				setEditMode(false);
			}
		}.schedule(2000);
		
	}
	@Override
	public void onPostReorder(CollectionItemDo collectionItem) {
		collectionItem.setCollection(this.collectionItemDo.getCollection());
		this.collectionItemDo.setItemSequence(collectionItem.getItemSequence());
		String folderLevel = AppClientFactory.getPlaceManager().getRequestParameter("level");
		String Flevels = null;
		if(folderLevel!=null){
			if(folderLevel.equalsIgnoreCase("1")) {
				Flevels = "2"; 
			} else if(folderLevel.equalsIgnoreCase("2")) {
				Flevels = "3";
			}
			AppClientFactory.fireEvent(new RefreshLevelFolderInShelfListEvent(collectionItemDo.getResource().getGooruOid(), RefreshType.UPDATE, Flevels,collectionItemDo.getItemSequence(),false));
		}
		else {
			Flevels = "1";
			AppClientFactory.fireEvent(new RefreshLevelFolderInShelfListEvent(collectionItemDo.getResource().getGooruOid(), RefreshType.UPDATE, Flevels,collectionItemDo.getItemSequence(),false));
		}
		
		
	}

}
