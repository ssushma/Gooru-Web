package org.ednovo.gooru.client.mvp.gsearch.addResourcePopup;

import java.util.List;

import org.ednovo.gooru.client.mvp.classpages.assignments.AddAssignmentContainerCBundle;
import org.ednovo.gooru.client.mvp.search.AddResourceContainerCBundle;
import org.ednovo.gooru.client.mvp.search.AddResourceContainerView.CollectionTreeItem;
import org.ednovo.gooru.client.mvp.search.AddResourceContainerView.FolderTreeItem;
import org.ednovo.gooru.client.mvp.shelf.list.TreeMenuImages;
import org.ednovo.gooru.shared.model.folder.FolderDo;
import org.ednovo.gooru.shared.model.folder.FolderListDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
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
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;

public class SearchAddResourceToCollectionView extends PopupViewWithUiHandlers<SearchAddResourceToCollectionUiHandlers> implements IsSearchAddResourceToCollectionView {

	private static SearchAddResourceToCollectionViewUiBinder uiBinder = GWT
			.create(SearchAddResourceToCollectionViewUiBinder.class);

	interface SearchAddResourceToCollectionViewUiBinder extends
			UiBinder<Widget, SearchAddResourceToCollectionView> {
	}
	
	@UiField HTMLPanel floderTreeContainer;
	@UiField Image cancelResourcePopupBtnLbl;
	@UiField ScrollPanel dropdownListContainerScrollPanel;
	
	private int limit=20;
	private int totalHitCount=0;
	private int pageNum=1;
	private FolderTreeItem previousFolderSelectedTreeItem = null;
	private CollectionTreeItem previousSelectedItem = null;
	private FolderTreeItem currentFolderSelectedTreeItem = null;
	private CollectionTreeItem cureentcollectionTreeItem = null;
	
	PopupPanel appPopUp;
	private Tree folderTreePanel = new Tree(new TreeMenuImages()){
		 @Override
		 public void onBrowserEvent(Event event) {
			    int eventType = DOM.eventGetType(event);
			    if(!(eventType==Event.ONKEYUP||eventType==Event.ONKEYPRESS||eventType==Event.ONKEYDOWN)) {
			    	super.onBrowserEvent(event);
			    }
		 }
	};
	@Inject
	public SearchAddResourceToCollectionView(EventBus eventBus) {
		super(eventBus);
		appPopUp=new PopupPanel();
		appPopUp.setWidget(uiBinder.createAndBindUi(this));
		appPopUp.setGlassEnabled(true);
		floderTreeContainer.clear();
		floderTreeContainer.add(folderTreePanel);
		dropdownListContainerScrollPanel.addScrollHandler(new ScrollDropdownListContainer());
		dropdownListContainerScrollPanel.getElement().setId("sbDropDownListContainer");
		folderTreePanel.getElement().setId("addResourcefolderTreePanel");
		folderTreePanel.addSelectionHandler(new SelectionHandler<TreeItem>() {
			  @Override
			  public void onSelection(SelectionEvent<TreeItem> event) {
			   final TreeItem item = (TreeItem) event.getSelectedItem();
			    Widget folderWidget= item.getWidget();
			    FolderTreeItem folderTreeItemWidget=null;
			    if(folderWidget instanceof FolderTreeItem){
			    	removePreviousSelectedItem();
			    	folderTreeItemWidget=(FolderTreeItem)folderWidget;
			    	currentFolderSelectedTreeItem = folderTreeItemWidget;
			    	previousFolderSelectedTreeItem = currentFolderSelectedTreeItem;
			    	previousSelectedItem = cureentcollectionTreeItem = null;
			    	currentFolderSelectedTreeItem.addStyleName("selected");
			    	if(folderTreeItemWidget.isOpen()){
			    		folderTreeItemWidget.setOpen(false);
			    		folderTreeItemWidget.removeStyleName("open");
			    	}else{
			    		folderTreeItemWidget.addStyleName("open");
			    		folderTreeItemWidget.setOpen(true);
			    	}
				    TreeItem parent = item.getParentItem();
				    item.getTree().setSelectedItem(parent, false); 
				    if(!folderTreeItemWidget.isApiCalled()){
				    	folderTreeItemWidget.setApiCalled(true);
				    	getFolderItems(item,folderTreeItemWidget.getGooruOid());
				    }
				    if(parent != null)
				    	parent.setSelected(false);   
				    item.setState(!item.getState(), false);
			    }else if(folderWidget instanceof CollectionTreeItem){
			    	removePreviousSelectedItem();
			    	cureentcollectionTreeItem=(CollectionTreeItem) folderWidget;
			    	previousSelectedItem = cureentcollectionTreeItem;
			    	cureentcollectionTreeItem.addStyleName("selected");
			    	previousFolderSelectedTreeItem = currentFolderSelectedTreeItem = null;
			    }
			  }
		});
	}

	private void removePreviousSelectedItem() {
		if (previousFolderSelectedTreeItem != null) {
			previousFolderSelectedTreeItem
					.removeStyleName("selected");
		}
		if (previousSelectedItem != null) {
			previousSelectedItem
					.removeStyleName("selected");
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
	@Override
	public Widget asWidget() {
		return appPopUp;
	}

	@Override
	public void reset() {
	}

	@Override
	public void onLoad() {
		
	}

	@Override
	public void onUnload() {
		
	}

	@Override
	public void displayWorkspaceData(FolderListDo folderListDo,boolean clearShelfPanel) {
		totalHitCount = folderListDo.getCount();
		if(clearShelfPanel){
			folderTreePanel.clear();
		}
		if(folderListDo!=null){
			 List<FolderDo> foldersArrayList=folderListDo.getSearchResult();
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
			 if(foldersArrayList!=null&&foldersArrayList.size()>0){
				 FolderTreeItem folderTreeItemWidget=(FolderTreeItem)item.getWidget();
				 int folderLevel=folderTreeItemWidget.getFolerLevel();
				 for(int i=0;i<foldersArrayList.size();i++){
					 FolderDo floderDo=foldersArrayList.get(i);
					 if(floderDo.getType().equals("folder")){
						 FolderTreeItem innerFolderTreeItem=new FolderTreeItem(folderLevel+"",floderDo.getTitle(),floderDo.getGooruOid());
						 innerFolderTreeItem.setFolerLevel(folderLevel+1);
						 TreeItem folderItem=new TreeItem(innerFolderTreeItem);
						 item.addItem(folderItem);
						 adjustTreeItemStyle(folderItem);
					 }else if(floderDo.getType().equals("scollection")){
						 TreeItem folderItem=new TreeItem(new CollectionTreeItem(getTreeItemStyleName(folderLevel),floderDo.getTitle(),floderDo.getGooruOid()));
						 item.addItem(folderItem);
						 adjustTreeItemStyle(folderItem);
					 }
				 }
					item.setState(folderTreeItemWidget.isOpen());
			 }
		}
	}
	@Override
	public void setFolderItems(TreeItem item, FolderListDo folderListDo) {
		displayWorkspaceData(item,folderListDo);
	}

	@Override
	public void displayNoCollectionsMsg() {
		
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
	private String  getTreeItemStyleName(int folderLevel){
		if(folderLevel==1){
			return "foldercollection1";
		}else if(folderLevel==2){
			return "foldercollection2";
		}else{
			return "foldercollection3";
		}
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
			folderContainer.setStyleName("foldermenuLevel");
		}
		public FolderTreeItem(String levelStyleName,String folderTitle,String gooruOid){
			this();
			if(levelStyleName!=null){
				folderContainer.addStyleName("foldermenuLevel"+levelStyleName);
			}
			this.gooruOid=gooruOid;
			folderContainer.getElement().setInnerText(folderTitle);
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
			folderContainer.setStyleName("foldercollection");
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
			folderContainer.getElement().setInnerText(folderTitle);
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
	@UiHandler("cancelResourcePopupBtnLbl")
	public void cancelButtonEvent(ClickEvent event){
		hide();
		Window.enableScrolling(true);
	}
	public void getFolderItems(TreeItem item,String parentId){
		getUiHandlers().getFolderItems(item,parentId);
	}
}
