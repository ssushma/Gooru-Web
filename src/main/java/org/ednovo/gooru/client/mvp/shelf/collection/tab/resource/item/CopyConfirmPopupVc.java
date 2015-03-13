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
package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item;

import java.util.List;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.classpages.assignments.AddAssignmentContainerCBundle;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.settings.CustomAnimation;
import org.ednovo.gooru.client.mvp.shelf.list.TreeMenuImages;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.folder.FolderDo;
import org.ednovo.gooru.shared.model.folder.FolderListDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.event.dom.client.ScrollHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

/**
 * @fileName : CopyConfirmPopupVc.java
 * 
 * @description :This class is used to copy collection in self page
 * 
 * @version : 5.5
 * 
 * @date: Apr 17, 2013
 * 
 * @Author :Gooru Team
 * 
 * @Reviewer:
 */
public abstract class CopyConfirmPopupVc{

//	@UiField BlueButtonUc btnCopy;
//	
//	@UiField Label btnCancel, resourceFirstElement,loadingTextLbl,copyLabelText;
//	
//	@UiField HTMLEventPanel popUpCopyCollection;
//	
//	@UiField ScrollPanel copyPopUpScrollHtmlPanel;
//	
//	@UiField FocusPanel copyPopUpResourceListImage;
//	
//	@UiField HTMLPanel copyLabel, htmlScrollPanel, loadingPanel,copyCollectionText;
	
	@UiField HTMLPanel floderTreeContainer;
	@UiField Button copyResourceBtnLbl,cancelResourcePopupBtnLbl;
	@UiField ScrollPanel dropdownListContainerScrollPanel;
	@UiField Label dropdownListPlaceHolder,addingText,chooseCollectionErrorLabel,copyCollectionPopupHeader,copyResourceTitleLabel;
	
	private PopupPanel popupPanel;
	
	private int limit=20;
	private int totalHitCount=0;
	private int pageNum=1;
	
	private static final String ASSESSMENT = "assessment";
	
	private CollectionTreeItem cureentcollectionTreeItem=null;
	private CollectionTreeItem previousSelectedItem=null;
	
	List<Integer> collectionItemDoSize;

	/* Setter and getters */
	/**
	 * This method is used to get collectionItem size
	 * 
	 * @return collectionItemDoSize
	 */
	public List<Integer> getCollectionItemDoSize() {
		return collectionItemDoSize;
	}

	/**
	 * This method is used to set collectionItem size
	 */

	public void setCollectionItemDoSize(List<Integer> collectionItemDoSize) {
		this.collectionItemDoSize = collectionItemDoSize;
	}

	private static CopyConfirmPopupVcUiBinder uiBinder = GWT.create(CopyConfirmPopupVcUiBinder.class);

	interface CopyConfirmPopupVcUiBinder extends UiBinder<Widget, CopyConfirmPopupVc> {
	}
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	private Tree folderTreePanel = new Tree(new TreeMenuImages()){
		 @Override
		 public void onBrowserEvent(Event event) {
			    int eventType = DOM.eventGetType(event);
			    if(!(eventType==Event.ONKEYUP||eventType==Event.ONKEYPRESS||eventType==Event.ONKEYDOWN)) {
			    	super.onBrowserEvent(event);
			    }
		 }
	};

	/**
	 * default constructor of CopyConfirmPopupVc
	 */
	public CopyConfirmPopupVc() {
		super();
		popupPanel=new PopupPanel();
		popupPanel.setWidget(uiBinder.createAndBindUi(this));
		setStaticTexts();
		AddAssignmentContainerCBundle.INSTANCE.css().ensureInjected();
		popupPanel.setStyleName(AddAssignmentContainerCBundle.INSTANCE.css().copyResourcePopupContainerShelf());
		popupPanel.setGlassEnabled(true);
		popupPanel.setAutoHideOnHistoryEventsEnabled(true);
		popupPanel.show();
		popupPanel.center();
		popupPanel.setModal(true);
		dropdownListContainerScrollPanel.getElement().setId("sbDropdownListContainerScrollPanel");
		dropdownListContainerScrollPanel.getElement().getStyle().setMarginTop(0, Unit.PX);
		dropdownListContainerScrollPanel.setVisible(false);
		chooseCollectionErrorLabel.getElement().setId("lblChooseCollectionErrorLabel");
		floderTreeContainer.getElement().setId("pnlFloderTreeContainer");
		addingText.setVisible(false);
		dropdownListPlaceHolder.addClickHandler(new OnDropdownListPlaceHolderClick());
		dropdownListContainerScrollPanel.addScrollHandler(new ScrollDropdownListContainer());
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
				    TreeItem parent = item.getParentItem();
				    item.getTree().setSelectedItem(parent, false); // TODO FIX ME
				    if(!folderTreeItemWidget.isApiCalled()){
				    	folderTreeItemWidget.setApiCalled(true);
				    	getFolderItems(item,folderTreeItemWidget.getGooruOid());
				    }
				    if(parent != null)
				    	parent.setSelected(false);   // TODO FIX ME
				    item.setState(!item.getState(), false);
			    }else if(folderWidget instanceof CollectionTreeItem){
			    	if(previousSelectedItem!=null){
			    		previousSelectedItem.removeStyleName(AddAssignmentContainerCBundle.INSTANCE.css().selected());
			    	}
			    	cureentcollectionTreeItem=(CollectionTreeItem)folderWidget;
			    	previousSelectedItem=cureentcollectionTreeItem;
			    	cureentcollectionTreeItem.addStyleName(AddAssignmentContainerCBundle.INSTANCE.css().selected());
			    	setSelectedCollectionTitle();
			    	closeDropDown();
			    }
			  }
			});
		floderTreeContainer.clear();
		floderTreeContainer.add(folderTreePanel);
		folderTreePanel.addItem(loadingTreeItem());
		getWorkspaceData(0,20,true);
		/*setWidget(uiBinder.createAndBindUi(this));*/
		//copyCollectionText.getElement().setInnerHTML(i18n.GL0947);
		//loadingTextLbl.setText(i18n.GL0110.toLowerCase()+i18n.GL_SPL_FULLSTOP+i18n.GL_SPL_FULLSTOP+i18n.GL_SPL_FULLSTOP);
//		btnCopy.setText(i18n.GL0827);
//		btnCancel.setText(i18n.GL0142);
//		copyLabelText.setText(i18n.GL0505.toLowerCase());
		//i18n.GL0505
//		setModal(true);
//		Window.enableScrolling(false);
//		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(88, false));

//		show();
//		center();
//		loadingTextLbl.setVisible(true);
//		populateUserCollections();
//		btnCopy.getElement().setId("btnCopy");
//		btnCancel.getElement().setId("lblCancel");
//		loadingPanel.setVisible(false);
//		copyLabel.setVisible(false);
//		btnCancel.setVisible(false);
//		loadingPanel.setVisible(true);
//		copyPopUpScrollHtmlPanel.getElement().getStyle().setVisibility(Visibility.HIDDEN);
//		copyPopUpResourceListImage.getElement().removeAttribute("tabindex");
		/**
		 * on click for display list of collection in listbox
		 */
//		copyPopUpResourceListImage.addClickHandler(new ClickHandler() {
//
//			@Override
//			public void onClick(ClickEvent event) {
//				if (copyPopUpScrollHtmlPanel.getElement().getStyle()
//						.getVisibility().equalsIgnoreCase("VISIBLE")) {
//					copyPopUpScrollHtmlPanel.getElement().getStyle()
//							.setVisibility(Visibility.HIDDEN);
//				} else {
//					copyPopUpScrollHtmlPanel.getElement().getStyle()
//							.setVisibility(Visibility.VISIBLE);
//				}
//			}
//		});

	}
	public void setStaticTexts(){
		copyCollectionPopupHeader.setText(i18n.GL0946());
		copyCollectionPopupHeader.getElement().setId("lblCopyCollectionPopupHeader");
		copyCollectionPopupHeader.getElement().setAttribute("alt", i18n.GL0946());
		copyCollectionPopupHeader.getElement().setAttribute("title", i18n.GL0946());
		copyResourceTitleLabel.setText(i18n.GL0947());
		copyResourceTitleLabel.getElement().setId("lblCopyResourceTitleLabel");
		copyResourceTitleLabel.getElement().setAttribute("alt", i18n.GL0947());
		copyResourceTitleLabel.getElement().setAttribute("title", i18n.GL0947());
		dropdownListPlaceHolder.setText(i18n.GL1377());
		dropdownListPlaceHolder.getElement().setId("lblDropdownListPlaceHolder");
		dropdownListPlaceHolder.getElement().setAttribute("alt", i18n.GL1377());
		dropdownListPlaceHolder.getElement().setAttribute("title", i18n.GL1377());
		copyResourceBtnLbl.setText(i18n.GL0827());
		cancelResourcePopupBtnLbl.setText(i18n.GL0142());
		copyResourceBtnLbl.getElement().setId("btnCopy");
		copyResourceBtnLbl.getElement().setAttribute("alt", i18n.GL0827());
		copyResourceBtnLbl.getElement().setAttribute("title", i18n.GL0827());
		
		cancelResourcePopupBtnLbl.getElement().setId("lblCancel");
		cancelResourcePopupBtnLbl.getElement().setAttribute("alt", i18n.GL0142());
		cancelResourcePopupBtnLbl.getElement().setAttribute("title", i18n.GL0142());
		addingText.setText(i18n.GL0505().toLowerCase());
		addingText.getElement().setId("btnCopy");
		addingText.getElement().setAttribute("alt", i18n.GL0505().toLowerCase());
		addingText.getElement().setAttribute("title", i18n.GL0505().toLowerCase());
		
	}
	
	public void setSelectedCollectionTitle(){
		if(cureentcollectionTreeItem!=null){
			dropdownListPlaceHolder.setText(cureentcollectionTreeItem.getCollectionName());
			dropdownListPlaceHolder.getElement().setAttribute("alt", cureentcollectionTreeItem.getCollectionName());
			dropdownListPlaceHolder.getElement().setAttribute("title", cureentcollectionTreeItem.getCollectionName());
			chooseCollectionErrorLabel.setText("");
		}
	}
	public void closeDropDown(){
		new CustomAnimation(dropdownListContainerScrollPanel).run(300);
	}
	public void setFolderItems(TreeItem item,FolderListDo folderListDo){
		displayWorkspaceData(item,folderListDo);
	}
	public void getFolderItems(TreeItem item,String parentId){
		getFolderInnerItems(item,parentId);
	}
	
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
			folderContainer.setStyleName(AddAssignmentContainerCBundle.INSTANCE.css().folderLevel());
			Label arrowLabel=new Label();
			arrowLabel.setStyleName(AddAssignmentContainerCBundle.INSTANCE.css().arrow());
			folderContainer.add(arrowLabel);
			floderName=new Label();
			floderName.setStyleName(AddAssignmentContainerCBundle.INSTANCE.css().title());
			folderContainer.add(floderName);
		}
		public FolderTreeItem(String levelStyleName,String folderTitle,String gooruOid){
			this();
			if(levelStyleName!=null){
				folderContainer.addStyleName(levelStyleName);
			}
			this.gooruOid=gooruOid;
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
	public class CollectionTreeItem extends Composite{
		private FlowPanel folderContainer=null;
		Label folderName=null;
		private String collectionName=null;
		private String gooruOid=null;
		private boolean isOpen=false;
		private int itemCount=0;
		public CollectionTreeItem(){
			initWidget(folderContainer=new FlowPanel());
			folderContainer.setStyleName(AddAssignmentContainerCBundle.INSTANCE.css().foldercollection());
			folderName=new Label();
			folderName.setStyleName(AddAssignmentContainerCBundle.INSTANCE.css().title());
			folderContainer.add(folderName);
		}
		public CollectionTreeItem(String levelStyleName){
			this();
			folderContainer.addStyleName(levelStyleName);
		}
		public CollectionTreeItem(String levelStyleName,String folderTitle,String gooruOid,int itemCount, String collectionType){
			this();
			if(ASSESSMENT.equals(collectionType)){
				folderContainer.setStyleName(AddAssignmentContainerCBundle.INSTANCE.css().folderAssessment());
			}
			if(levelStyleName!=null){
				folderContainer.addStyleName(levelStyleName);
			}
			this.gooruOid=gooruOid;
			this.setItemCount(itemCount);
			this.collectionName=folderTitle;
			folderName.setText(folderTitle);
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
		public int getItemCount() {
			return itemCount;
		}
		public void setItemCount(int itemCount) {
			this.itemCount = itemCount;
		}
		
	}
	
	public void displayWorkspaceData(FolderListDo folderListDo,boolean clearShelfPanel) {
		if(clearShelfPanel){
			folderTreePanel.clear();
		}
		if(folderListDo!=null){
			 List<FolderDo> foldersArrayList=folderListDo.getSearchResult();
			 setPagination(folderListDo.getCount());
			 if(foldersArrayList!=null&&foldersArrayList.size()>0){
				 for(int i=0;i<foldersArrayList.size();i++){
					 FolderDo floderDo=foldersArrayList.get(i);
					 if(floderDo.getType().equals("folder")){
						 TreeItem folderItem=new TreeItem(new FolderTreeItem(null,floderDo.getTitle(),floderDo.getGooruOid()));
						 folderTreePanel.addItem(folderItem);
						 adjustTreeItemStyle(folderItem);
					 }else{
						 String collectionType=floderDo.getCollectionType().equals(ASSESSMENT)?floderDo.getCollectionType():floderDo.getType();
						 TreeItem folderItem=new TreeItem(new CollectionTreeItem(null,floderDo.getTitle(),floderDo.getGooruOid(),floderDo.getItemCount(),collectionType));
						 folderTreePanel.addItem(folderItem);
						 adjustTreeItemStyle(folderItem);
					 }
				 }
			 }
		}
	}
	
	public void displayWorkspaceData(TreeItem item, FolderListDo folderListDo) {
		if(folderListDo!=null){
			 List<FolderDo> foldersArrayList=folderListDo.getSearchResult();
			 if(foldersArrayList!=null&&foldersArrayList.size()>0){
				 FolderTreeItem folderTreeItemWidget=(FolderTreeItem)item.getWidget();
				 int folderLevel=folderTreeItemWidget.getFolerLevel();
				 for(int i=0;i<foldersArrayList.size();i++){
					 FolderDo floderDo=foldersArrayList.get(i);
					 if(floderDo.getType().equals("folder")){
						 String styleName=folderLevel==1?AddAssignmentContainerCBundle.INSTANCE.css().parent():AddAssignmentContainerCBundle.INSTANCE.css().child();
						 FolderTreeItem innerFolderTreeItem=new FolderTreeItem(styleName,floderDo.getTitle(),floderDo.getGooruOid());
						 innerFolderTreeItem.setFolerLevel(folderLevel+1);
						 TreeItem folderItem=new TreeItem(innerFolderTreeItem);
						 item.addItem(folderItem);
						 adjustTreeItemStyle(folderItem);
					 }else{
						 String collectionType=floderDo.getCollectionType().equals(ASSESSMENT)?floderDo.getCollectionType():floderDo.getType();
						 TreeItem folderItem=new TreeItem(new CollectionTreeItem(getTreeItemStyleName(folderLevel),floderDo.getTitle(),floderDo.getGooruOid(),floderDo.getItemCount(),collectionType));
						 item.addItem(folderItem);
						 adjustTreeItemStyle(folderItem);
					 }
				 }
					item.setState(folderTreeItemWidget.isOpen());
			 }
		}
	}
	private String  getTreeItemStyleName(int folderLevel){
		if(folderLevel==1){
			return AddAssignmentContainerCBundle.INSTANCE.css().parent();
		}else if(folderLevel==2){
			return AddAssignmentContainerCBundle.INSTANCE.css().child();
		}else{
			return AddAssignmentContainerCBundle.INSTANCE.css().innerchild();
		}
	}
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
	public void setPagination(int count){
		totalHitCount=count;
	}
	private class OnDropdownListPlaceHolderClick implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			new CustomAnimation(dropdownListContainerScrollPanel).run(300);
		}
	}
	private class ScrollDropdownListContainer implements ScrollHandler{
		@Override
		public void onScroll(ScrollEvent event) {
			if((dropdownListContainerScrollPanel.getVerticalScrollPosition() == dropdownListContainerScrollPanel.getMaximumVerticalScrollPosition())&&(totalHitCount>pageNum*limit)){
					getWorkspaceData(pageNum*limit, limit,false);
					pageNum++;
				}
			}
	}
	

	public abstract void populateUserCollections();
	public abstract void getFolderInnerItems(TreeItem item,String parentId);
	public abstract void getWorkspaceData(int offset,int limit,boolean clearShelfPanel);

	/**
	 * for close copy collection popup
	 * 
	 * @param clickEvent
	 */
	@UiHandler("cancelResourcePopupBtnLbl")
	public void onCancelClick(ClickEvent clickEvent) {
		hide();
	}

//	/**
//	 * on click for hide listbox when user click outside the listbox
//	 */
//	@UiHandler("copyResourceBtnLbl")
//	public void onpopUpCopyCollection(ClickEvent clickEvent) {
//		if (copyPopUpScrollHtmlPanel.getElement().getStyle().getVisibility()
//				.equalsIgnoreCase("VISIBLE")) {
//			copyPopUpScrollHtmlPanel.getElement().getStyle()
//					.setVisibility(Visibility.HIDDEN);
//		}
//
//	}

	@UiHandler("copyResourceBtnLbl")
	public void onClickCopyBtn(ClickEvent clickEvent){
		if(cureentcollectionTreeItem!=null){
			if(cureentcollectionTreeItem.getItemCount()>= 25){
				chooseCollectionErrorLabel.setText(i18n.GL0302());
				chooseCollectionErrorLabel.getElement().setAttribute("alt", i18n.GL0302());
				chooseCollectionErrorLabel.getElement().setAttribute("title", i18n.GL0302());
			}else{
				hideButton(false);
				copyResourceToCollection(cureentcollectionTreeItem.getGooruOid());
			}
		}else{
			chooseCollectionErrorLabel.setText(i18n.GL1377_1());
			chooseCollectionErrorLabel.getElement().setAttribute("alt", i18n.GL1377_1());
			chooseCollectionErrorLabel.getElement().setAttribute("title", i18n.GL1377_1());
		}
	}
	public void hideButton(boolean hideButtons){
		copyResourceBtnLbl.setVisible(hideButtons);
		cancelResourcePopupBtnLbl.setVisible(hideButtons);
		addingText.setVisible(!hideButtons);
		
	}
	public void hide(){
		popupPanel.hide();
//		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
	}
	public abstract void copyResourceToCollection(String collectionId);
	
	
	/**
	 * for close copy collection popup
	 * 
	 * @param clickEvent
	 *//*
	@UiHandler("cancelButton")
	public void onCloseClick(ClickEvent clickEvent) {
		hide();
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));

	}*/
	public TreeItem loadingTreeItem(){
		Label loadingText=new Label(i18n.GL1452());
		loadingText.setStyleName(AddAssignmentContainerCBundle.INSTANCE.css().loadingText());
		return new TreeItem(loadingText);
	}

}
