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
package org.ednovo.gooru.client.mvp.classpages.assignments;

import java.util.Date;
import java.util.List;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.settings.CustomAnimation;
import org.ednovo.gooru.client.mvp.shelf.list.TreeMenuImages;
import org.ednovo.gooru.client.uc.DateBoxUcCustomizedForAssign;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.folder.FolderDo;
import org.ednovo.gooru.shared.model.folder.FolderListDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.event.dom.client.ScrollHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.EventBus;
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
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;

public class AddAssignmentContainerView extends PopupViewWithUiHandlers<AddAssignmentContainerUiHandlers> implements IsAddAssignmentContainerView {
	
	private static AddAssignmentContainerViewUiBinder uiBinder = GWT.create(AddAssignmentContainerViewUiBinder.class);
	
	public MessageProperties i18n = GWT.create(MessageProperties.class);

	interface AddAssignmentContainerViewUiBinder extends UiBinder<Widget, AddAssignmentContainerView> {
	}

//	@UiField SimplePanel datePanelContainer;
	@UiField HTMLPanel floderTreeContainer,buttonsContainer;
	@UiField Button addResourceBtnLbl,cancelResourcePopupBtnLbl;
	@UiField ScrollPanel dropdownListContainerScrollPanel;
	@UiField Label /*dropdownListPlaceHolder,addingText,chooseCollectionErrorLabel,directionErrorLabel,*/ 
				addCollectionPopupHeader, addingText,emptyMsgLbl,subHeadingMsgLbl,displayCountLabel; /*,assignmentTitleLabel,chooseCollectionHelpText,assignmentDirectionLabel,assignmentDueDateLabel,remainderLbl*/
//	@UiField TextArea assignmentDirectionsTxtArea;
	
	@UiField FlowPanel popupContent;
	
	private int offset=0;
	private int limit=20;
	private int totalHitCount=0;
	private int pageNum=1;

	protected PopupPanel appPopUp;
	private DateBoxUcCustomizedForAssign dateBoxUc;
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
	private String unitTitle ="";
	
	
	@Inject
	public AddAssignmentContainerView(EventBus eventBus) {
		super(eventBus);
		appPopUp=new PopupPanel();
		appPopUp.setWidget(uiBinder.createAndBindUi(this));
		AddAssignmentContainerCBundle.INSTANCE.css().ensureInjected();
		appPopUp.setStyleName(AddAssignmentContainerCBundle.INSTANCE.css().popupContainer());
		setStaticTexts();
		enableAssignButton(false);
		//assignmentDirectionsTxtArea.addStyleName(AddAssignmentContainerCBundle.INSTANCE.css().assignmentsystemMessage());
		//assignmentDirectionsTxtArea.getElement().setAttribute("maxlength", "400");
//		dropdownListContainerScrollPanel.setVisible(false);
		addingText.setVisible(false);
		appPopUp.setGlassEnabled(true);
		appPopUp.setAutoHideOnHistoryEventsEnabled(true);
		
		//datePanelContainer.clear();
		dateBoxUc = new DateBoxUcCustomizedForAssign(false, false,false);
		//datePanelContainer.add(dateBoxUc);
		//dateBoxUc.getDoneButton().addClickHandler(new OnDoneClick());
		//dropdownListPlaceHolder.addClickHandler(new OnDropdownListPlaceHolderClick());
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
			    	removePreviousSelectedItem();
			    	currentFolderSelectedTreeItem=folderTreeItemWidget;
			    	previousFolderSelectedTreeItem=currentFolderSelectedTreeItem;
			    	currentFolderSelectedTreeItem.addStyleName(AddAssignmentContainerCBundle.INSTANCE.css().selected());
			    	previousSelectedItem=cureentcollectionTreeItem=null;
				    TreeItem parent = item.getParentItem();
				    item.getTree().setSelectedItem(parent, false); // TODO FIX ME
				    if(!folderTreeItemWidget.isApiCalled()){
				    	folderTreeItemWidget.setApiCalled(true);
				    	
				    	getFolderItems(item,folderTreeItemWidget.getGooruOid());
				    }
				    if(parent != null)
				    	parent.setSelected(false);   // TODO FIX ME
				    item.setState(!item.getState(), false);
				    setSelectedCollectionsCount(getCollectionCountFromFolder(item));
			    }else if(folderWidget instanceof CollectionTreeItem){
			    	removePreviousSelectedItem();
			    	cureentcollectionTreeItem=(CollectionTreeItem)folderWidget;
			    	previousSelectedItem=cureentcollectionTreeItem;
			    	cureentcollectionTreeItem.addStyleName(AddAssignmentContainerCBundle.INSTANCE.css().selected());
			    	previousFolderSelectedTreeItem=currentFolderSelectedTreeItem=null;
			    	setSelectedCollectionTitle();
			    	//closeDropDown();
			    }
			  }
			});
		floderTreeContainer.clear();
		floderTreeContainer.add(folderTreePanel);
		folderTreePanel.addItem(loadingTreeItem());
		
	}
	
	public int getCollectionCountFromFolder(TreeItem item){
	    int childCount = item.getChildCount();
	    int collectionCount=0;
	    for(int i=0;i<childCount;i++){
	    	TreeItem childTree=item.getChild(i);
	    	Widget childWidget=childTree.getWidget();
	    	 if(childWidget instanceof CollectionTreeItem){
	    		 collectionCount++;
	    	 }
	    }
	    return collectionCount;
	}
	
	public void setStaticTexts(){
		subHeadingMsgLbl.setText(i18n.GL1974());
		subHeadingMsgLbl.getElement().setId("lblSubHeadingMsg");
		subHeadingMsgLbl.getElement().setAttribute("alt",i18n.GL1974());
		subHeadingMsgLbl.getElement().setAttribute("title",i18n.GL1974());
		
		addCollectionPopupHeader.setText(i18n.GL1973());
		addCollectionPopupHeader.getElement().setId("lblAddCollectionPopupHeader");
		addCollectionPopupHeader.getElement().setAttribute("alt",i18n.GL1973());
		addCollectionPopupHeader.getElement().setAttribute("title",i18n.GL1973());
		
		//assignmentTitleLabel.setText(GL1376);
//		dropdownListPlaceHolder.setText(GL1377);
//		chooseCollectionHelpText.setText(GL1378);
//		assignmentDirectionLabel.setText(GL1379);
//		assignmentDueDateLabel.setText(GL1380);
		cancelResourcePopupBtnLbl.setText(i18n.GL0142());
		cancelResourcePopupBtnLbl.getElement().setId("btnCancelResourcePoup");
		cancelResourcePopupBtnLbl.getElement().setAttribute("alt",i18n.GL0142());
		cancelResourcePopupBtnLbl.getElement().setAttribute("title",i18n.GL0142());
		
		addResourceBtnLbl.setText(i18n.GL0104());
		addResourceBtnLbl.getElement().setId("btnAddResource");
		addResourceBtnLbl.getElement().setAttribute("alt",i18n.GL0104());
		addResourceBtnLbl.getElement().setAttribute("title",i18n.GL0104());
		
		addingText.setText(i18n.GL1172());
		addingText.getElement().setId("lblAddText");
		addingText.getElement().setAttribute("alt",i18n.GL1172());
		addingText.getElement().setAttribute("title",i18n.GL1172());
		
//		assignmentDirectionsTxtArea.setText(GL1389);
//		assignmentDueDateLabel.setText(GL1380);
//		remainderLbl.setText(GL1889);
		popupContent.getElement().setId("pnlPopupContent");
		emptyMsgLbl.getElement().setId("lblEmptyMsg");
		dropdownListContainerScrollPanel.getElement().setId("sbDropDownListContainer");
		floderTreeContainer.getElement().setId("pnlFolderTreeContainer");
		displayCountLabel.getElement().setId("lblDisplayCount");
		buttonsContainer.getElement().setId("pnlButtonsContainer");
	}
	
	public void setSelectedCollectionTitle(){
		if(cureentcollectionTreeItem!=null){
			enableAssignButton(true);
			String pageLocation=AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
			if(pageLocation.equals(PlaceTokens.STUDENT)){
				displayCountLabel.setText("\""+cureentcollectionTreeItem.getCollectionName()+"\" "+StringUtil.generateMessage(i18n.GL2242(), unitTitle));
			}else if(pageLocation.equals(PlaceTokens.EDIT_CLASSPAGE)){
				displayCountLabel.setText("\""+cureentcollectionTreeItem.getCollectionName()+"\" "+StringUtil.generateMessage(i18n.GL2242(), unitTitle));
			}else{
				displayCountLabel.setText("\""+cureentcollectionTreeItem.getCollectionName()+"\" "+i18n.GL1975());
			}
			displayCountLabel.getElement().setAttribute("alt","\""+cureentcollectionTreeItem.getCollectionName()+"\" "+i18n.GL1975());
			displayCountLabel.getElement().setAttribute("title","\""+cureentcollectionTreeItem.getCollectionName()+"\" "+i18n.GL1975());
		}
	}
	public void setSelectedCollectionsCount(int count){
		if(count>0){
			enableAssignButton(true);
			String label=count==1?count+" collection":count+" collections";
			String pageLocation=AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
			if(pageLocation.equals(PlaceTokens.STUDENT)){
				displayCountLabel.setText(label+" "+StringUtil.generateMessage(i18n.GL2242(), unitTitle));
			}else if(pageLocation.equals(PlaceTokens.EDIT_CLASSPAGE)){
				displayCountLabel.setText(label+" "+StringUtil.generateMessage(i18n.GL2242(), unitTitle));
			}else{
				displayCountLabel.setText(label+" "+i18n.GL1975());
			}
			displayCountLabel.getElement().setAttribute("alt",label+" "+i18n.GL1975());
			displayCountLabel.getElement().setAttribute("title",label+" "+i18n.GL1975());
		
		}else{
			enableAssignButton(false);
			displayCountLabel.setText("");
			displayCountLabel.getElement().setAttribute("alt","");
			displayCountLabel.getElement().setAttribute("title","");
		}
	}
	public void enableAssignButton(boolean enable){
		if(enable){
			addResourceBtnLbl.setEnabled(enable);
			addResourceBtnLbl.removeStyleName("secondary");
			addResourceBtnLbl.addStyleName("primary");
		}else{
			addResourceBtnLbl.setEnabled(enable);
			addResourceBtnLbl.removeStyleName("primary");
			addResourceBtnLbl.addStyleName("secondary");
		}
	}
	protected void removePreviousSelectedItem(){
		if(previousFolderSelectedTreeItem!=null){
    		previousFolderSelectedTreeItem.removeStyleName(AddAssignmentContainerCBundle.INSTANCE.css().selected());
    	}
		if(previousSelectedItem!=null){
    		previousSelectedItem.removeStyleName(AddAssignmentContainerCBundle.INSTANCE.css().selected());
    	}
	}
	public void closeDropDown(){
		new CustomAnimation(dropdownListContainerScrollPanel).run(300);
	}
	public void setFolderItems(TreeItem item,FolderListDo folderListDo){
		displayWorkspaceData(item,folderListDo);
	}
	public void getFolderItems(TreeItem item,String parentId){
		getUiHandlers().getFolderItems(item,parentId);
	}
	@UiHandler("addResourceBtnLbl")
	public void addButtonEvent(ClickEvent event){
		if(addResourceBtnLbl.getText().trim().equalsIgnoreCase("Create a Collection")){
			hide();
			AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.COLLECTION);
		}else{
			addResourceBtnLbl.setEnabled(false);
			addCollectionToAssign();
		}
		
	}
	@UiHandler("cancelResourcePopupBtnLbl")
	public void cancelButtonEvent(ClickEvent event){
		//directionErrorLabel.setText("");
		hide();
	}
//	@UiHandler("assignmentDirectionsTxtArea")
//	public void diectionFocusEvent(FocusEvent event){
//		String directionText=assignmentDirectionsTxtArea.getText().trim();
//		if(directionText.equalsIgnoreCase(GL1389)){
//			assignmentDirectionsTxtArea.setText("");
//		}
//		assignmentDirectionsTxtArea.removeStyleName(AddAssignmentContainerCBundle.INSTANCE.css().assignmentsystemMessage());
//	}
//	@UiHandler("assignmentDirectionsTxtArea")
//	public void diectionKeyUpEvent(KeyUpEvent event){
//		String directionText=assignmentDirectionsTxtArea.getText().trim();
//		if(directionText.length()>=400){
//			directionErrorLabel.setText(GL0143);
//			//event.preventDefault();
//			
//		}else{
//			directionErrorLabel.setText("");
//		}
//	}
//	@UiHandler("assignmentDirectionsTxtArea")
//	public void diectionBlurEvent(BlurEvent event){
//		String directionText=assignmentDirectionsTxtArea.getText().trim();
//		if(!directionText.equalsIgnoreCase(GL1389)&&directionText.length()>0){
//			if(directionText.length()>=400){
//				directionErrorLabel.setText(GL0143);
//			}else{
//				Map<String, String> parms = new HashMap<String, String>();
//				parms.put("text", directionText);
//				AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {
//					@Override
//					public void onSuccess(Boolean isFound) {
//						if(isFound && appPopUp.isShowing()){
//							directionErrorLabel.setText(GL0554);
//						}else{
//							directionErrorLabel.setText("");
//						}
//					}		
//				});
//			}
//		}else{
//			assignmentDirectionsTxtArea.setText(GL1389);
//			assignmentDirectionsTxtArea.addStyleName(AddAssignmentContainerCBundle.INSTANCE.css().assignmentsystemMessage());
//		}
//	}
	
	public void addCollectionToAssign(){
		if(cureentcollectionTreeItem!=null){
			addResourceBtnLbl.setVisible(false);
			cancelResourcePopupBtnLbl.setVisible(false);
			addingText.setVisible(true);
			getUiHandlers().addCollectionToAssign(cureentcollectionTreeItem.getGooruOid());
			addResourceBtnLbl.setEnabled(true);
		}else if(currentFolderSelectedTreeItem!=null){
			addResourceBtnLbl.setVisible(false);
			cancelResourcePopupBtnLbl.setVisible(false);
			addingText.setVisible(true);
			getUiHandlers().addCollectionToAssign(currentFolderSelectedTreeItem.getGooruOid());
			addResourceBtnLbl.setEnabled(true);
		}else{
			
		}
		
//		if(cureentcollectionTreeItem!=null){
//			final String directions=assignmentDirectionsTxtArea.getText().trim().equals(GL1389)?null:assignmentDirectionsTxtArea.getText().trim();
//			final String dueDate=dateBoxUc.getDateBox().getValue()==null||dateBoxUc.getDateBox().getValue().equals("")?null:dateBoxUc.getDateBox().getValue();
//			Map<String, String> parms = new HashMap<String, String>();
//			parms.put("text", assignmentDirectionsTxtArea.getText());
//			AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {
//				@Override
//				public void onSuccess(Boolean isFound) {
//					if(isFound){
//						directionErrorLabel.setText(GL0554);
//						addResourceBtnLbl.setVisible(true);
//						cancelResourcePopupBtnLbl.setVisible(true);
//						addingText.setVisible(false);
//						addResourceBtnLbl.setEnabled(true);
//					}else{
//						directionErrorLabel.setText("");
//						addResourceBtnLbl.setVisible(false);
//						cancelResourcePopupBtnLbl.setVisible(false);
//						addingText.setVisible(true);
//						getUiHandlers().addCollectionToAssign(cureentcollectionTreeItem.getGooruOid(), directions, dueDate);
//						addResourceBtnLbl.setEnabled(true);
//					}
//				}		
//			});
//		}else{
//			chooseCollectionErrorLabel.setText(GL1475);
////			chooseCollectionErrorLabel.getElement().getStyle().setMarginTop(0, Unit.PX);
//			addResourceBtnLbl.setEnabled(true);
//		}
		
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
		public CollectionTreeItem(String levelStyleName,String folderTitle,String gooruOid){
			this();
			if(levelStyleName!=null){
				folderContainer.addStyleName(levelStyleName);
			}
			this.gooruOid=gooruOid;
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
		
	}
	@Override
	public void displayWorkspaceData(FolderListDo folderListDo,boolean clearShelfPanel) {
		resetEmptyCollMsg();
		if(!dropdownListContainerScrollPanel.isVisible()){
			dropdownListContainerScrollPanel.setVisible(true);
		}
		
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
					 }else if(floderDo.getType().equals("scollection")){
						 TreeItem folderItem=new TreeItem(new CollectionTreeItem(null,floderDo.getTitle(),floderDo.getGooruOid()));
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
			 int collectionCount=0;
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
					 }else if(floderDo.getType().equals("scollection")){
						 collectionCount++;
						 TreeItem folderItem=new TreeItem(new CollectionTreeItem(getTreeItemStyleName(folderLevel),floderDo.getTitle(),floderDo.getGooruOid()));
						 item.addItem(folderItem);
						 adjustTreeItemStyle(folderItem);
					 }
				 }
					item.setState(folderTreeItemWidget.isOpen());
			 }
			 setSelectedCollectionsCount(collectionCount);
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
					getUiHandlers().getWorkspaceData(pageNum*limit, limit,false);
					pageNum++;
				}
			}
	}
	
	private class OnDoneClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			if (dateBoxUc.dateValidation()){
				if (!(dateBoxUc.getValue() == null || dateBoxUc.getDateBox()
						.getText().isEmpty())
						&& dateBoxUc.hasValidateDate()) {
				Date date = dateBoxUc.getValue();
				
				} else {
					dateBoxUc.getDatePickerUc().hide();
				}
			}
		}
	}
	
	@Override
	public Widget asWidget() {
		return appPopUp;
	}
	
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onLoad() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onUnload() {
		appPopUp.hide();
	}

	public void hide(){
		resetEmptyCollMsg();
		dropdownListContainerScrollPanel.setVisible(true);
		//addingText.setVisible(false);
		addResourceBtnLbl.setVisible(true);
		cancelResourcePopupBtnLbl.setVisible(true);
		displayCountLabel.setText("");
//		chooseCollectionErrorLabel.setText("");
//		directionErrorLabel.setText("");
//		assignmentDirectionsTxtArea.setText(GL1389);
//		assignmentDirectionsTxtArea.addStyleName(AddAssignmentContainerCBundle.INSTANCE.css().assignmentsystemMessage());
		dateBoxUc.getDateBox().setValue("");
		enableAssignButton(false);
		Window.enableScrolling(true);
		super.hide();
	}
	@Override
	public void clearShelfData() {
		addingText.setVisible(false);
		folderTreePanel.clear();
		folderTreePanel.addItem(loadingTreeItem());
		cureentcollectionTreeItem=null;
		previousSelectedItem=null;
		//dropdownListPlaceHolder.setText(GL1377);
		offset=0;
		limit=20;
		totalHitCount=0;
		pageNum=1;
	}
	@Override
	public void hideAddCollectionPopup(String collectionTitle) {
		hide();
		clearShelfData();
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
		new SuccessMessagePopupView(collectionTitle);
		Window.enableScrolling(false);
	}
	
	public TreeItem loadingTreeItem(){
		Label loadingText=new Label(i18n.GL1452());
		loadingText.setStyleName(AddAssignmentContainerCBundle.INSTANCE.css().loadingText());
		return new TreeItem(loadingText);
	}

	@Override
	public void displayNoCollectionsMsg() {
		dropdownListContainerScrollPanel.setVisible(false);
		enableAssignButton(true);
		addResourceBtnLbl.setText(i18n.GL1964());
		emptyMsgLbl.setText(i18n.GL1963()); 
		emptyMsgLbl.getElement().setAttribute("alt",i18n.GL1963());
		emptyMsgLbl.getElement().setAttribute("title",i18n.GL1963());
		subHeadingMsgLbl.setVisible(false);
		emptyMsgLbl.setVisible(true);
//		buttonsContainer.getElement().getStyle().setMarginTop(66, Unit.PX); 
//		buttonsContainer.getElement().getStyle().setMarginLeft(110, Unit.PX); 
		appPopUp.removeStyleName(AddAssignmentContainerCBundle.INSTANCE.css().popupContainer());
		appPopUp.setStyleName(AddAssignmentContainerCBundle.INSTANCE.css().noCollectionMsgOuterContainer());
		popupContent.setStyleName(AddAssignmentContainerCBundle.INSTANCE.css().noCollectionMsgContainer());
	}
	
	public void resetEmptyCollMsg(){
		dropdownListContainerScrollPanel.setVisible(true);
		addResourceBtnLbl.setText(i18n.GL0104());
		emptyMsgLbl.setVisible(false);
		subHeadingMsgLbl.setVisible(true);
		buttonsContainer.setStyleName(AddAssignmentContainerCBundle.INSTANCE.css().assignmentButtonsContainer()); 
		appPopUp.setStyleName(AddAssignmentContainerCBundle.INSTANCE.css().popupContainer());
		appPopUp.removeStyleName(AddAssignmentContainerCBundle.INSTANCE.css().noCollectionMsgOuterContainer());
		popupContent.removeStyleName(AddAssignmentContainerCBundle.INSTANCE.css().noCollectionMsgContainer());
	}

	@Override
	public void setUnitTitle(String pathwayTitle) {
		// TODO Auto-generated method stub
		this.unitTitle = pathwayTitle;
	}

}
