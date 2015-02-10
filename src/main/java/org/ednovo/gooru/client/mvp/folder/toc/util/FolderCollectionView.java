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
package org.ednovo.gooru.client.mvp.folder.toc.util;

import java.util.List;

import org.ednovo.gooru.client.mvp.classpages.assignments.AddAssignmentContainerCBundle;
import org.ednovo.gooru.client.mvp.classpages.assignments.AddAssignmentContainerView.CollectionTreeItem;
import org.ednovo.gooru.client.mvp.classpages.assignments.AddAssignmentContainerView.FolderTreeItem;
import org.ednovo.gooru.client.mvp.shelf.list.TreeMenuImages;
import org.ednovo.gooru.client.uc.H4Panel;
import org.ednovo.gooru.shared.model.folder.FolderDo;
import org.ednovo.gooru.shared.model.folder.FolderListDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : FolderCollectionView.java
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
public class FolderCollectionView extends Composite {

	private static FolderCollectionViewUiBinder uiBinder = GWT
			.create(FolderCollectionViewUiBinder.class);

	interface FolderCollectionViewUiBinder extends
			UiBinder<Widget, FolderCollectionView> {
	}
	@UiField FlowPanel pnlResources,pnlCollections;
	@UiField H4Panel lblCollectionTitle;
	
	private FolderListDo folderListDo;
	
	private Tree folderTreePanel = new Tree(new TreeMenuImages()){
		 @Override
		 public void onBrowserEvent(Event event) {
			    int eventType = DOM.eventGetType(event);
			    if(!(eventType==Event.ONKEYUP||eventType==Event.ONKEYPRESS||eventType==Event.ONKEYDOWN)) {
			    	super.onBrowserEvent(event);
			    }
		 }
	};
	private CollectionTreeItem cureentcollectionTreeItem=null;
	private CollectionTreeItem previousSelectedItem=null;
	private FolderTreeItem currentFolderSelectedTreeItem=null;
	private FolderTreeItem previousFolderSelectedTreeItem=null;
	
	
	
	public FolderCollectionView(FolderListDo folderListDo) {
		initWidget(uiBinder.createAndBindUi(this));
		this.folderListDo=folderListDo;
		AddAssignmentContainerCBundle.INSTANCE.css().ensureInjected();
		FolderTocCBundle.INSTANCE.css().ensureInjected();
		displayWorkspaceData(folderListDo,true);
		 // folderTitle.setText("FolderTitle1");
		 /* lblCollectionTitle.setText("Why England Was the First to Industrialize Why England Was the First to Industrialize");
		  pnlResources.add(new FolderCollectionResourceView());*/
		 
		  
		  folderTreePanel.addSelectionHandler(new SelectionHandler<TreeItem>() {
			  @Override
			  public void onSelection(SelectionEvent<TreeItem> event) {
			   final TreeItem item = (TreeItem) event.getSelectedItem();
			    Widget folderWidget= item.getWidget();
			    FolderTreeItem folderTreeItemWidget=null;
			    if(folderWidget instanceof FolderTreeItem){
			    	folderTreeItemWidget=(FolderTreeItem)folderWidget;
			    	if(folderTreeItemWidget.isOpen()){
			    		folderTreeItemWidget.removeStyleName(AddAssignmentContainerCBundle.INSTANCE.css().open());
			    		folderTreeItemWidget.setOpen(false);
			    	}else{
			    		folderTreeItemWidget.addStyleName(AddAssignmentContainerCBundle.INSTANCE.css().open());
			    		folderTreeItemWidget.setOpen(true);
			    	}
			    	removePreviousSelectedItem();
			    	currentFolderSelectedTreeItem=folderTreeItemWidget;
			    	previousFolderSelectedTreeItem=currentFolderSelectedTreeItem;
			    	//currentFolderSelectedTreeItem.addStyleName(AddAssignmentContainerCBundle.INSTANCE.css().selected());
			    	previousSelectedItem=cureentcollectionTreeItem=null;
				    TreeItem parent = item.getParentItem();
				    item.getTree().setSelectedItem(parent, false); // TODO FIX ME
				    if(!folderTreeItemWidget.isApiCalled()){
				    	folderTreeItemWidget.setApiCalled(true);
				    	//getFolderItems(item,folderTreeItemWidget.getGooruOid());
				    }
				    if(parent != null)
				    	parent.setSelected(false);   // TODO FIX ME
				    item.setState(!item.getState(), false);
				    //setSelectedCollectionsCount(getCollectionCountFromFolder(item));
			    }else if(folderWidget instanceof CollectionTreeItem){
			    	removePreviousSelectedItem();
			    	cureentcollectionTreeItem=(CollectionTreeItem)folderWidget;
			    	previousSelectedItem=cureentcollectionTreeItem;
			    	//cureentcollectionTreeItem.addStyleName(AddAssignmentContainerCBundle.INSTANCE.css().selected());
			    	previousFolderSelectedTreeItem=currentFolderSelectedTreeItem=null;
			    	//setSelectedCollectionTitle();
			    	//closeDropDown();
			    }
			  }
			});
		  
		  /*TreeItem folderItem=new TreeItem(new FolderTreeItem(null,"FolderTitle1",""));
			 folderTreePanel.addItem(folderItem);*/
			 pnlCollections.add(folderTreePanel);
	}
	
	
	/**
	 * 
	 * @function removePreviousSelectedItem 
	 * 
	 * @created_date : 09-Feb-2015
	 * 
	 * @description
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	protected void removePreviousSelectedItem(){
		if(previousFolderSelectedTreeItem!=null){
    		previousFolderSelectedTreeItem.removeStyleName(AddAssignmentContainerCBundle.INSTANCE.css().selected());
    	}
		if(previousSelectedItem!=null){
    		previousSelectedItem.removeStyleName(AddAssignmentContainerCBundle.INSTANCE.css().selected());
    	}
	}
	
	/**
	 * 
	 * @fileName : AddAssignmentContainerView.java
	 *
	 * @description : 
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 07-Dec-2014
	 *
	 * @Author tumbalam
	 *
	 * @Reviewer:
	 */
	public class FolderTreeItem extends Composite{
		private FlowPanel folderContainer=null;
		private String gooruOid=null;
		Label floderName=null;
		Label arrowLabel=null;
		private boolean isOpen=false;
		private boolean isApiCalled=false;
		private int folerLevel=1;
		public FolderTreeItem(){
			initWidget(folderContainer=new FlowPanel());
			//folderContainer.setStyleName(AddAssignmentContainerCBundle.INSTANCE.css().folderLevel());
			Label arrowLabel=new Label();
			arrowLabel.setStyleName(FolderTocCBundle.INSTANCE.css().folderTitlearrow());
			folderContainer.add(arrowLabel);
			floderName=new Label();
			floderName.setStyleName(FolderTocCBundle.INSTANCE.css().folderTitleStyle());
			folderContainer.add(floderName);
		}
		public FolderTreeItem(String levelStyleName,String folderTitle,String gooruOid){
			this();
			if(levelStyleName!=null){
				folderContainer.addStyleName(levelStyleName);
			}
			this.gooruOid=gooruOid;
			System.out.println("foldername::"+folderTitle);
			floderName.setText(folderTitle);
		}
		public boolean isOpen() {
			return isOpen;
		}
		public void setOpen(boolean isOpen) {
			this.isOpen = isOpen;
		}
		public String getGooruOid(){
			return gooruOid;
		}
		public boolean isApiCalled() {
			return isApiCalled;
		}
		public void setApiCalled(boolean isApiCalled) {
			this.isApiCalled = isApiCalled;
		}
		public int getFolerLevel() {
			return folerLevel;
		}
		public void setFolerLevel(int folerLevel) {
			this.folerLevel = folerLevel;
		}
	}
	
	/**
	 * 
	 * @fileName : AddAssignmentContainerView.java
	 *
	 * @description : 
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 07-Dec-2014
	 *
	 * @Author tumbalam
	 *
	 * @Reviewer:
	 */
	public class CollectionTreeItem extends Composite{
		private FlowPanel collectionContainer=null;
		Label folderName=null;
		private FlowPanel resourceContainer= new FlowPanel();
		private String collectionName=null;
		private String gooruOid=null;
		private boolean isOpen=false;
		public CollectionTreeItem(){
			initWidget(collectionContainer=new FlowPanel());
			//folderContainer.setStyleName(AddAssignmentContainerCBundle.INSTANCE.css().foldercollection());
			folderName=new Label();
			folderName.setStyleName(FolderTocCBundle.INSTANCE.css().folderTitleStyle());
			resourceContainer.add(folderName);
			collectionContainer.add(resourceContainer);

		}
		public CollectionTreeItem(String levelStyleName){
			this();
			collectionContainer.addStyleName(levelStyleName);
		}
		public CollectionTreeItem(String levelStyleName,FolderDo folderDo){
			this();
			if(levelStyleName!=null){
				collectionContainer.addStyleName(levelStyleName);
			}
			this.gooruOid=folderDo.getGooruOid();
			this.collectionName=folderDo.getTitle();
			folderName.setText(collectionName);
			 if(folderDo.getCollectionItems().size()>0){
				 System.out.println("INININ");
				 resourceContainer.add(new FolderCollectionResourceView(folderDo));
			 }
			 collectionContainer.add(resourceContainer);
		}
		public boolean isOpen() {
			return isOpen;
		}
		public void setOpen(boolean isOpen) {
			this.isOpen = isOpen;
		}
		public String getGooruOid(){
			return gooruOid;
		}
		public String getCollectionName(){
			return collectionName;
		}
		
	}
	
	
	public void displayWorkspaceData(FolderListDo folderListDo,boolean clearShelfPanel) {
		//resetEmptyCollMsg();
		/*if(!dropdownListContainerScrollPanel.isVisible()){
			dropdownListContainerScrollPanel.setVisible(true);
		}*/
		System.out.println("display:::");
		if(clearShelfPanel){
			folderTreePanel.clear();
		}
		if(folderListDo!=null){
			System.out.println("ininin");
			 List<FolderDo> foldersArrayList=folderListDo.getSearchResult();
			 //setPagination(folderListDo.getCount());
			 if(foldersArrayList!=null&&foldersArrayList.size()>0){
				 for(int i=0;i<foldersArrayList.size();i++){
					 FolderDo floderDo=foldersArrayList.get(i);
					 System.out.println("type::"+floderDo.getType());
					 if(floderDo.getType().equals("folder")){
						 TreeItem folderItem=new TreeItem(new FolderTreeItem(null,floderDo.getTitle(),floderDo.getGooruOid()));
						 folderTreePanel.addItem(folderItem);
						 adjustTreeItemStyle(folderItem);
					 }else if(floderDo.getType().equals("scollection")){
						 TreeItem folderItem=new TreeItem(new CollectionTreeItem(null,floderDo));
						 folderTreePanel.addItem(folderItem);
						
						 
						 adjustTreeItemStyle(folderItem);
					 }
				 }
			 }
		}
	}
	
	/**
	 * 
	 * @function adjustTreeItemStyle 
	 * 
	 * @created_date : 07-Dec-2014
	 * 
	 * @description
	 * 
	 * 
	 * @parm(s) : @param uiObject
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
   	private  void adjustTreeItemStyle(final UIObject uiObject) {
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

}
