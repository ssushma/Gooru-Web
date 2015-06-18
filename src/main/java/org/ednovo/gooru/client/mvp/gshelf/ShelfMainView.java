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
import java.util.Iterator;
import java.util.List;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.content.ClassPageCollectionDo;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.client.mvp.shelf.list.ShelfCollection;
import org.ednovo.gooru.client.mvp.shelf.list.TreeMenuImages;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

/**
 * @fileName : ShelfView.java
 * 
 * @description :
 * 
 * 
 * @version : 5.5
 * 
 * @date: June 17, 2013
 * 
 * @Author Gooru Team
 * 
 * @Reviewer:
 */
public class ShelfMainView extends BaseViewWithHandlers<ShelfMainUiHandlers> implements IsShelfMainView {

	@UiField HTMLPanel floderTreeContainer,gShelfMainContainer,pnlSlot;
	
	@UiField HTMLEventPanel organizeRootPnl;
	
	@UiField Button btnSelectedText;
	
	@UiField Anchor lnkMyCourses,lnkMyFolders,lnkMyCollections;
	
	@UiField Label organizelbl;
	
	@UiField static ScrollPanel collectionListScrollpanel;
	
	private static final String O1_LEVEL = "o1";
	
	private static final String O2_LEVEL = "o2";
	
	private static final String O3_LEVEL = "o3";
	
	private static final String ID = "id";

	private static final String FOLDER = "folder";
	
	private static final String TYPE = "type";
	
	private static final String SCOLLECTION = "scollection";
	
	static Integer pageNumber = 1;

	private TreeItem treeChildSelectedItem = new TreeItem();

	private TreeItem previousTreeChildSelectedItem = new TreeItem();

	private static final String GOORU_UID = "gooruuid";
	
	private Integer childPageNumber = 1;
	
	int collectionItemDoSize, count;

	boolean collectionItemsNotFriendly = false;

	static MessageProperties i18n = GWT.create(MessageProperties.class);

	String selectedFolderId = "";

	List<ClassPageCollectionDo> classpageTitles = null;

	private static final List<FolderDo> SHELF_COLLECTIONS = new ArrayList<FolderDo>();

	private static ShelfMainViewUiBinder uiBinder = GWT
			.create(ShelfMainViewUiBinder.class);

	interface ShelfMainViewUiBinder extends UiBinder<Widget, ShelfMainView> {
	}

	private Tree shelfFolderTree = new Tree(new TreeMenuImages()) {
		@Override
		public void onBrowserEvent(Event event) {
			int eventType = DOM.eventGetType(event);
			if (!(eventType == Event.ONKEYUP || eventType == Event.ONKEYPRESS || eventType == Event.ONKEYDOWN)) {
				super.onBrowserEvent(event);
			}
		}
		public void onLoad(){
			 super.onLoad();
			 adjustTreeItemElementsStyle(shelfFolderTree);
		}
	};

	/**
	 * class constructor
	 */
	public ShelfMainView() {
		setWidget(uiBinder.createAndBindUi(this));
		setIdForFields();
		setTreeStucture();
		//setDefaultOrganizePanel();
		organizelbl.setText("My Courses");
		lnkMyCourses.addClickHandler(new DropDownClickEvent(0));
		lnkMyFolders.addClickHandler(new DropDownClickEvent(1));
		lnkMyCollections.addClickHandler(new DropDownClickEvent(2));
	}

	/**
	 * This inner class will handle the click event on the drop down box
	 */
	class DropDownClickEvent implements ClickHandler{
		int selectedIndex;
		DropDownClickEvent(int selectedIndex){
			this.selectedIndex=selectedIndex;
		}
		@Override
		public void onClick(ClickEvent event) {
			Anchor selected=(Anchor) event.getSource();
			btnSelectedText.setText(selected.getText());
			if(selectedIndex==0){
				organizelbl.setText("My Courses");
				getUiHandlers().setListPresenterBasedOnType("Course");
			}else if(selectedIndex==1){
			    organizelbl.setText("My Folders");
				getUiHandlers().setListPresenterBasedOnType("Folder");
			}else if(selectedIndex==2){
				organizelbl.setText("My Collections");
				getUiHandlers().setListPresenterBasedOnType("Collection");
			}
		}
	}
	
	/**
	 * To set the default organize list.
	 */
	@Override
	public void setDefaultOrganizePanel() {
		if(treeChildSelectedItem!=null){
			if(getFolderLevel()==0) {
				organizeRootPnl.addStyleName("active");
			} else {
				organizeRootPnl.removeStyleName("active");
			}
			ShelfTreeWidget treeItemShelfTree = (ShelfTreeWidget) treeChildSelectedItem.getWidget();
			if(treeItemShelfTree!=null){
				if(organizeRootPnl.getStyleName().contains("active")) {
					treeItemShelfTree.setActiveStyle(false);
				} else {
					treeItemShelfTree.setActiveStyle(true);
				}
			}
		}
		collectionListScrollpanel.getElement().getStyle().setMarginRight(0, Unit.PX);
		collectionListScrollpanel.getElement().getStyle().setWidth(235, Unit.PX);
		collectionListScrollpanel.getElement().getStyle().setHeight(Window.getClientHeight(), Unit.PX);
	}
	
	/**
	 * To set id's for Ui fields
	 */
	private void setIdForFields() {
		gShelfMainContainer.getElement().setId("gShelfMainContainer");
		btnSelectedText.getElement().setId("btnSelectedText");
		lnkMyCourses.getElement().setId("lnkMyCourses");
		lnkMyFolders.getElement().setId("lnkMyFolders");
		lnkMyCollections.getElement().setId("lnkMyCollections");
		StringUtil.setAttributes(organizeRootPnl.getElement(), "organizeRootPnl", "", "");
		StringUtil.setAttributes(organizelbl.getElement(), "organizelbl", "", "");
		StringUtil.setAttributes(collectionListScrollpanel.getElement(), "FoldersListScrollpanel", "", "");
		
	}
	private void setTreeStucture() {
		floderTreeContainer.clear();
		shelfFolderTree.addSelectionHandler(new SelectionHandler<TreeItem>() {
			@Override
			public void onSelection(SelectionEvent<TreeItem> event) {
				ShelfTreeWidget shelfCollection = (ShelfTreeWidget) event.getSelectedItem().getWidget();
				if(!shelfCollection.getCollectionDo().getCollectionType().equals("assessment/url")){
					treeChildSelectedItem = event.getSelectedItem();
					((ShelfTreeWidget) treeChildSelectedItem.getWidget()).openFolderItem();
					setFolderActiveStatus();
				}
			}
		});
		floderTreeContainer.add(shelfFolderTree);
	}
	
	/**
	 * To get Level of Folder
	 * @return folderLevel 
	 */
	public int getFolderLevel() {
		int folderLevel = 0;
		String o1=AppClientFactory.getPlaceManager().getRequestParameter(O1_LEVEL);
		String o2=AppClientFactory.getPlaceManager().getRequestParameter(O2_LEVEL);
		String o3=AppClientFactory.getPlaceManager().getRequestParameter(O3_LEVEL);
		String id=AppClientFactory.getPlaceManager().getRequestParameter(ID);
		if(o3!=null) {folderLevel = 3;} else if (o2!=null) {folderLevel = 2;} else if(o1!=null) {folderLevel = 1;} else if(id!=null) {folderLevel = 4;}
		return folderLevel;
	}


	public void setFolderActiveStatus() { 
		ShelfTreeWidget shelfCollection = (ShelfTreeWidget) treeChildSelectedItem.getWidget();
		if(!shelfCollection.getCollectionDo().getCollectionType().equals("assessment/url")){
			if(shelfCollection.getCollectionDo().getType().equals("folder")) {
				TreeItem parent = treeChildSelectedItem.getParentItem();
				treeChildSelectedItem.getTree().setSelectedItem(parent, false);
				if(parent != null)parent.setSelected(false);
				treeChildSelectedItem.setState(treeChildSelectedItem.getState(), false);
				getUiHandlers().getChildFolderItems(shelfCollection.getCollectionDo().getGooruOid(),shelfCollection.getFolderOpenedStatus());
				shelfCollection.setFolderOpenedStatus(true);
				
			} else {
				//getUiHandlers().getCollectionItems(shelfCollection.getCollectionDo().getGooruOid(),shelfCollection.getCollectionOpenedStatus()); 
				shelfCollection.setCollectionOpenedStatus(true);
			}
			shelfCollection.setActiveStyle(true);
			ShelfTreeWidget previousShelfCollection = (ShelfTreeWidget) previousTreeChildSelectedItem.getWidget();
			if(previousShelfCollection==null) {
				previousTreeChildSelectedItem = treeChildSelectedItem;
			}
			if(previousShelfCollection!=null&&(shelfCollection.getCollectionDo().getGooruOid()!=previousShelfCollection.getCollectionDo().getGooruOid())) {
				previousShelfCollection.setActiveStyle(false);
			}
			previousTreeChildSelectedItem = treeChildSelectedItem;
		}
	}

	/* (non-Javadoc)
	 * @see com.gwtplatform.mvp.client.ViewImpl#setInSlot(java.lang.Object, com.google.gwt.user.client.ui.Widget)
	 */
	@Override
	public void setInSlot(Object slot, Widget content) {
		pnlSlot.clear();
		if (content != null) {
			 if(slot==ShelfMainPresenter.RIGHT_SLOT){
				 pnlSlot.add(content);
			 }else{
				 
			}
		}else{

		}
		Window.enableScrolling(false);
	}
	@Override
	public void getChildFolderItems(List<FolderDo> folderListDo) {
		String o2 = null, o3 = null, selectedFolder = null, selectedFolderName = null, id = null;
		FolderDo folderDo = null;
		TreeItem selectedItem = null;
		ShelfTreeWidget selectedWidget = (ShelfTreeWidget) treeChildSelectedItem.getWidget();
		if(folderListDo!=null) {
			int nextLevel = 1;
			if(selectedWidget.getLevel()==1) {
				o2=AppClientFactory.getPlaceManager().getRequestParameter(O2_LEVEL);
				id=AppClientFactory.getPlaceManager().getRequestParameter(ID);
				nextLevel = 2;
			} else if (selectedWidget.getLevel()==2) { 
				o3=AppClientFactory.getPlaceManager().getRequestParameter(O3_LEVEL);
				id=AppClientFactory.getPlaceManager().getRequestParameter(ID);
				nextLevel = 3;
			}else if (selectedWidget.getLevel()==3) {
				id=AppClientFactory.getPlaceManager().getRequestParameter(ID);
				nextLevel = 4;
			}
			for(int i=0;i<folderListDo.size();i++) {
				ShelfTreeWidget shelfCollection = new ShelfTreeWidget(folderListDo.get(i), nextLevel);
				shelfCollection.setWidgetPositions(nextLevel, i, selectedWidget.getUrlParams());
				TreeItem item = new TreeItem(shelfCollection);
				treeChildSelectedItem.addItem(item);
				correctStyle(item);
				if(nextLevel==2&& (o2!=null&&o2.equalsIgnoreCase(folderListDo.get(i).getGooruOid()) || id!=null&&id.equalsIgnoreCase(folderListDo.get(i).getGooruOid()))) {
					if(o2!=null) {
						selectedFolder = o2;
					} else {
						selectedFolder = id;
					}
					selectedItem = item;
					selectedFolderName = folderListDo.get(i).getTitle();
					folderDo = folderListDo.get(i);
				} else if(nextLevel==3&& (o3!=null&&o3.equalsIgnoreCase(folderListDo.get(i).getGooruOid()) || id!=null&&id.equalsIgnoreCase(folderListDo.get(i).getGooruOid()))) {
					if(o3!=null) {
						selectedFolder = o3;
					} else {
						selectedFolder = id;
					}
					selectedItem = item;
					selectedFolderName = folderListDo.get(i).getTitle();
					folderDo = folderListDo.get(i);
				} else if (nextLevel==4&&id!=null&&id.equalsIgnoreCase(folderListDo.get(i).getGooruOid())) {
					selectedFolder = id;
					selectedItem = item;
					selectedFolderName = folderListDo.get(i).getTitle();
					folderDo = folderListDo.get(i);
				} 
			}
		}
		if(treeChildSelectedItem.getState()) {
			treeChildSelectedItem.setState(false);
			selectedWidget.setOpenStyle(false, treeChildSelectedItem.getChildCount());
		} else {
			treeChildSelectedItem.setState(true);
			selectedWidget.setOpenStyle(true, treeChildSelectedItem.getChildCount());
		}
		
		if(selectedFolder!=null&&selectedItem!=null) { 
			checkShelfRefreshStatus(selectedItem, selectedFolder);
			ShelfTreeWidget selectedWidget1 = (ShelfTreeWidget) treeChildSelectedItem.getWidget();
			selectedWidget1.setFolderOpenedStatus(true);
		}
		
	}	
	
	private static void correctStyle(final UIObject uiObject) {
	      if (uiObject instanceof TreeItem) {
	         if (uiObject != null && uiObject.getElement() != null) {
	            Element element = uiObject.getElement();
	            element.getStyle().setPadding(0, Unit.PX);
	            element.getStyle().setMarginLeft(0, Unit.PX);
	         }
	      } else {
	         if (uiObject != null && uiObject.getElement() != null && uiObject.getElement().getParentElement() != null
	               && uiObject.getElement().getParentElement().getParentElement() != null
	               && uiObject.getElement().getParentElement().getParentElement().getStyle() != null) {
	            Element element = uiObject.getElement().getParentElement().getParentElement();
	            element.getStyle().setPadding(0, Unit.PX);
	            element.getStyle().setMarginLeft(0, Unit.PX);
	         }
	      }
 }
	/** 
	 * This method is to get the childPageNumber
	 */
	public int getChildPageNumber() {
		return childPageNumber;
	}

	@Override
	public void setChildPageNumber(Integer childPageNumber) {
		this.childPageNumber = childPageNumber;
	}

	@Override
	public void setUserShelfData(List<FolderDo> collections, boolean clearShelfPanel) {
		String o1 = AppClientFactory.getPlaceManager().getRequestParameter(O1_LEVEL);
		String id = AppClientFactory.getPlaceManager().getRequestParameter(ID);
		if (clearShelfPanel) {
			pageNumber = 1;
			shelfFolderTree.clear();
		}
		SHELF_COLLECTIONS.clear();
		if(collections != null) {
			SHELF_COLLECTIONS.addAll(collections);
			collectionItemDoSize = SHELF_COLLECTIONS.size();
		}
		String gooruOid = o1!=null?o1:id;
		int collectionCount=0;
		if(collections!=null){
			collectionItemDoSize = collections.size();
			for(int i=0;i<collections.size();i++){
				FolderDo floderDo=collections.get(i);
				if(!getShelffCollection(floderDo.getGooruOid())){
					ShelfTreeWidget shelfCollection = new ShelfTreeWidget(floderDo, 1);
					shelfCollection.setWidgetPositions(1, collectionCount, null);
					TreeItem folderItem=new TreeItem(new ShelfTreeWidget(floderDo, 1));
					shelfFolderTree.addItem(folderItem);
					//When page is refreshed, the folderItem previously selected will be highlighted.
					if(gooruOid!=null&&gooruOid.equalsIgnoreCase(floderDo.getGooruOid())) {
						checkShelfRefreshStatus(folderItem, floderDo.getGooruOid());
						shelfCollection.setFolderOpenedStatus(true);
					}
					collectionCount++;

				}
				floderTreeContainer.clear();
				floderTreeContainer.add(shelfFolderTree);
			}
		}
	}
	
	private boolean getShelffCollection(String collectionId) {
		boolean flag = false;
		Iterator<Widget> widgets = shelfFolderTree.iterator();
		while (widgets.hasNext()) {
			Widget widget = widgets.next();
			if (widget instanceof ShelfTreeWidget && ((ShelfTreeWidget) widget).getCollectionDo().getGooruOid().equals(collectionId)) {
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * @function checkShelfRefreshStatus 
	 * @created_date : 11-Jun-2015
	 * @description
	 * @parm(s) : @param treeItem
	 * @return : void
	 * @throws : <Mentioned if any exceptions>
	*/
	
	private void checkShelfRefreshStatus(TreeItem treeItem, String parentId) {
		treeChildSelectedItem = treeItem;
		ShelfTreeWidget shelfCollection = (ShelfTreeWidget) treeChildSelectedItem.getWidget();
		shelfCollection.setActiveStyle(true);
		String id = AppClientFactory.getPlaceManager().getRequestParameter(ID);
		id = id!=null?id:"";
		if(!parentId.equalsIgnoreCase(id)) {
			getUiHandlers().getChildFolderItems(parentId,false);
		}
		ShelfTreeWidget previousShelfCollection = (ShelfTreeWidget) previousTreeChildSelectedItem.getWidget();
		if(previousShelfCollection!=null) {
			previousShelfCollection.setActiveStyle(false);
		}
		previousTreeChildSelectedItem = treeChildSelectedItem;
	}
	
	public void adjustTreeItemElementsStyle(Tree shelfTreePanel){
		int treeItemsCount=shelfTreePanel.getItemCount();
		if(shelfTreePanel!=null&&treeItemsCount>0){
			for(int i=0;i<treeItemsCount;i++){
				TreeItem treeItem=shelfTreePanel.getItem(i);
				Widget shelfWidget= treeItem.getWidget();
				if(shelfWidget instanceof ShelfTreeWidget){
					adjustChildTreeItemsStyle(treeItem);
				}
				correctStyle(treeItem);
			}
		}
	}
	public void adjustChildTreeItemsStyle(TreeItem treeItem){
		int treeItemsCount=treeItem.getChildCount();
		if(treeItem!=null&&treeItemsCount>0){
			for(int i=0;i<treeItemsCount;i++){
				TreeItem childTreeItem=treeItem.getChild(i);
				Widget shelfWidget= childTreeItem.getWidget();
				if(shelfWidget instanceof ShelfTreeWidget){
					adjustChildTreeItemsStyle(childTreeItem);
				}
				correctStyle(childTreeItem);
			}
		}
	}
	
	@UiHandler("organizeRootPnl")
	public void clickOnOrganizeRootPnl(ClickEvent event) {
		ShelfCollection shelfCollection = (ShelfCollection) treeChildSelectedItem.getWidget();
		if(shelfCollection!=null&&shelfCollection.getLevel()!=0) {
			shelfCollection.setActiveStyle(false);
		}
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.SHELF);
	}
	
	/**
	 * To get more collection item after scroll down,if collection is more than 20.
	 * @param event instance of ScrollEvent
	 */
	@UiHandler("collectionListScrollpanel")
	public void dragImageSimPanelscroll(ScrollEvent event) {
		if (collectionListScrollpanel.getVerticalScrollPosition() == collectionListScrollpanel.getMaximumVerticalScrollPosition() && collectionItemDoSize >= 20) {
			pageNumber = pageNumber + 1;
			getUiHandlers().getMoreListItems(20, pageNumber, false);
		}
	}

	
   	@Override
   	public HTMLPanel getSlot(){
   		return pnlSlot;
   	}
}