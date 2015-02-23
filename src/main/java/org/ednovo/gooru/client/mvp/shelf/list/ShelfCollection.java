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

package org.ednovo.gooru.client.mvp.shelf.list;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.effects.FontWeightEffect;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.dnd.Draggable;
import org.ednovo.gooru.client.mvp.dnd.DropBox;
import org.ednovo.gooru.client.mvp.dnd.IsDraggable.DRAG_TYPE;
import org.ednovo.gooru.client.mvp.resource.dnd.ResourceDropController;
import org.ednovo.gooru.client.mvp.search.event.RegisterSearchDropEvent;
import org.ednovo.gooru.client.mvp.search.event.UnregisterSearchDropEvent;
import org.ednovo.gooru.client.mvp.shelf.FolderStyleBundle;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.SetFolderMetaDataEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.SetFolderParentNameEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.UpdateShelfFolderNameEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.UpdateShelfFolderNameHandler;
import org.ednovo.gooru.client.mvp.shelf.event.CollectionAssignShareEvent;
import org.ednovo.gooru.client.mvp.shelf.event.CollectionAssignShareHandler;
import org.ednovo.gooru.client.mvp.shelf.event.CreateCollectionItemEvent;
import org.ednovo.gooru.client.mvp.shelf.event.DragOverOpenFolderEvent;
import org.ednovo.gooru.client.mvp.shelf.event.UserInfoMsgShelfEvent;
import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.client.uc.LabelGlassPanel;
import org.ednovo.gooru.client.uc.tooltip.LibraryTopicCollectionToolTip;
import org.ednovo.gooru.client.uc.tooltip.SearchDragToolTip;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.player.resource.client.view.resourceplayer.CustomAnimation;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.folder.FolderDo;
import org.ednovo.gooru.shared.model.folder.FolderItemDo;
import org.ednovo.gooru.shared.model.folder.FolderListDo;
import org.ednovo.gooru.shared.util.DOMUtils;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.FontStyle;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 * 
 */
public class ShelfCollection extends FocusPanel implements DropBox,
		MouseOverHandler {

	private static ShelfCollectionUiBinder uiBinder = GWT
			.create(ShelfCollectionUiBinder.class);
	
	private static MessageProperties i18n = GWT.create(MessageProperties.class);

	interface ShelfCollectionUiBinder extends UiBinder<Widget, ShelfCollection> {
	}

	@UiField
	HTML titleLbl;

	@UiField
	VerticalPanel contentVerPanel;

	@UiField(provided = true)
	ShelfListCBundle res;

	@UiField
	LabelGlassPanel glassContainer;

	@UiField
	FocusPanel titleFocPanel;

	@UiField
	FocusPanel wrapperFocPanel;

	@UiField
	DisclosurePanel disPanel;

	@UiField
	Label addSuccessMsg;
	
	@UiField
	Button myShelfEditButton;
	
	@UiField HTML htmlToolTipContent;
	
	@UiField HTMLPanel panelToolTip, arrowIcon;
	
	private String draggedCollectionId="";
	
	private String levelOneFolderId="";
	
	private FolderDo collectionDo;

	private FolderItemDo collectionItemDo;

	private ResourceDropController dropController;
	
	private PopupPanel toolTipPopupPanel=new PopupPanel();
	
	private TreeItem treeChildSelectedItem = new TreeItem();

	//private static final String ADD_TO_THIS_COLLECTION = "Add to this Collection";

//	private static final String ADD_TO_THIS_COLLECTION = "Drag a resource here to add to this collection";
	
//	private static final String EDIT_THIS_COLLECTION = "Drop resource here";
	
	private final String CONGRATS_MSG=i18n.GL0483().toLowerCase();

	//private static final String EDIT_THIS_COLLECTION = "Edit this Collection";

	private static final String FOLDER_LEVEL = "1";

	private static ShelfCollection shelfCollection;
	
	private boolean isEditButtonSelected = false;

	HTMLPanel htmlPanel;

	private Draggable draggable;
	
	private boolean isValue=true;
	
	private int level = 0;
	
	private int position;
	
	private FolderDo folderDo;

	private boolean folderIsOpened = false;
	
	private boolean collectionIsOpened = false;
	
	@UiField FolderStyleBundle folderStyle;

	HashMap<String,String> urlParams = new HashMap<String,String>();
	
	private static final String O1_LEVEL = "o1";
	
	private static final String O2_LEVEL = "o2";
	
	private static final String O3_LEVEL = "o3";
	
	private static final String ID = "id";

	private static final String DRAGGING_INTO_COLOR="#E1F0D1";
	

	/**
	 * Class constructor , assign the {@link CollectionDo} instance
	 * 
	 * @param collectionDo
	 *            instance of {@link CollectionDo}
	 * @param nextLevel 
	 */
	public ShelfCollection(final FolderDo collectionDo, final int nextLevel) {
		res = ShelfListCBundle.INSTANCE;
		res.css().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));
		myShelfEditButton.setText(i18n.GL0140());
		myShelfEditButton.getElement().setAttribute("alt", i18n.GL0140());
		myShelfEditButton.getElement().setAttribute("title", i18n.GL0140());
		myShelfEditButton.getElement().setId("btnMyShelfEdit");
		glassContainer.getElement().setId("GlassContainer");
		glassContainer.setGlassVisible(false);
		
		setData(collectionDo,nextLevel);
		this.folderDo=collectionDo;
		this.getElement().setAttribute("style", "min-height: 42px;");
		dropController = new ResourceDropController(this);
		myShelfEditButton.getElement().getStyle().setDisplay(Display.NONE);
		myShelfEditButton.getElement().getStyle().setMarginRight(20, Unit.PX);
		titleFocPanel.getElement().setId("focuspnlTitleFocPanel");
		arrowIcon.getElement().setId("pnlArrowIcon");
		titleLbl.getElement().setId("htmlTitleLbl");
		panelToolTip.getElement().setId("pnlPanelToolTip");
		htmlToolTipContent.getElement().setId("htmlHtmlToolTipContent");
		disPanel.getElement().setId("discpnlDisPanel");
		wrapperFocPanel.getElement().setId("focuspnlWrapperFocPanel");
		addSuccessMsg.getElement().setId("lblAddSuccessMsg");
		contentVerPanel.getElement().setId("vpnlContentVerPanel");
		titleFocPanel.addClickHandler(new ClickOnFolderItem());
		titleFocPanel.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				if(!AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.SHELF)) {
					myShelfEditButton.getElement().getStyle().setDisplay(Display.BLOCK);
				}
			}
		});
		titleFocPanel.addMouseOutHandler(new MouseOutHandler() {
			@Override
			public void onMouseOut(MouseOutEvent event) {
				if(!AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.SHELF)) {
					myShelfEditButton.getElement().getStyle().setDisplay(Display.NONE);
				}
			}
		});
		myShelfEditButton.addMouseOverHandler(new MouseOverHandler() {
		
			@Override
			public void onMouseOver(MouseOverEvent event) {
				if(collectionDo.getType().equalsIgnoreCase("folder")){
				toolTipPopupPanel.clear();
				toolTipPopupPanel.setWidget(new LibraryTopicCollectionToolTip(i18n.GL1472(),""));
				toolTipPopupPanel.setStyleName("");
				toolTipPopupPanel.setPopupPosition(event.getRelativeElement().getAbsoluteLeft() - 2, event.getRelativeElement().getAbsoluteTop() + 27);
				toolTipPopupPanel.show();
				}else{
					toolTipPopupPanel.clear();
					toolTipPopupPanel.setWidget(new LibraryTopicCollectionToolTip(i18n.GL1473(), ""));
					toolTipPopupPanel.setStyleName("");
					toolTipPopupPanel.setPopupPosition(event.getRelativeElement().getAbsoluteLeft() - 2, event.getRelativeElement().getAbsoluteTop() + 27);
					toolTipPopupPanel.show();
				}
			}
			
		});
		myShelfEditButton.addMouseOutHandler(new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
				toolTipPopupPanel.hide();
			}
		});
		wrapperFocPanel.addMouseOverHandler(this);
		wrapperFocPanel.addMouseOutHandler(new MouseOutHandler() {

			@Override
			public void onMouseOut(MouseOutEvent event) {
				if (!getDropController().isDropActive()) {
					glassContainer.setGlassVisible(false);
				}
			}
		});
		
		htmlToolTipContent.setHTML(i18n.GL1395());
		htmlToolTipContent.getElement().setAttribute("alt", i18n.GL1395());
		htmlToolTipContent.getElement().setAttribute("title", i18n.GL1395());
		
		AppClientFactory.getEventBus().addHandler(CollectionAssignShareEvent.TYPE, handler);
		addSuccessMsg.setVisible(false);
		addSuccessMsg.setText(i18n.GL0591().toLowerCase());
		addSuccessMsg.getElement().setAttribute("alt", i18n.GL0591().toLowerCase());
		addSuccessMsg.getElement().setAttribute("title", i18n.GL0591().toLowerCase());

		wrapperFocPanel.addClickHandler(new ClickOnFolderItem());
		AppClientFactory.getEventBus().addHandler(UpdateShelfFolderNameEvent.TYPE,updateShelfFolderName);
	}

	@UiHandler("myShelfEditButton")
	public void myShelfEditButtonHandler(ClickEvent event){
		myShelfEditButton.getElement().getStyle().setDisplay(Display.NONE);
		isValue=false;
		if(collectionDo.getType().equalsIgnoreCase("folder")){
			MixpanelUtil.mixpanelEvent("Search_click_folder_edit");
			isEditButtonSelected=true;
			openFolderInShelf();
		} else {
			openCollectionInShelf();
		}
	}
	
	public void setData(FolderDo collectionDo, int nextLevel) {
		updateData(collectionDo);
		
		if(!collectionDo.getType().equals("folder")) {
			titleFocPanel.addStyleName(folderStyle.collection());
			arrowIcon.getElement().getStyle().setDisplay(Display.NONE);
		}
		if(collectionDo.getCollectionItems()!=null) {
			if(collectionDo.getType().equals("folder") && collectionDo.getCollectionItems().size() == 0)
			{
				arrowIcon.getElement().getStyle().setDisplay(Display.NONE);
			}
		} else {
			arrowIcon.getElement().getStyle().setDisplay(Display.NONE);
		}
		
		if(collectionDo.getSharing()!=null && !collectionDo.getSharing().equalsIgnoreCase("") && collectionDo.getSharing().equals("public")) {
			if(collectionDo.getType().equals("scollection") || collectionDo.getType().equals("collection") ){
				titleFocPanel.addStyleName(folderStyle.publicIcon());
				panelToolTip.getElement().getStyle().clearDisplay();
			}else{
				panelToolTip.getElement().getStyle().setDisplay(Display.NONE);
			}
		}else{
			panelToolTip.getElement().getStyle().setDisplay(Display.NONE);
		}
		
		if(nextLevel == 1) {
			titleLbl.setWidth("170px");
			titleLbl.getElement().getNextSiblingElement().removeAttribute("style");
			htmlToolTipContent.getParent().getElement().getPreviousSiblingElement().removeAttribute("style");
		} else if(nextLevel == 2) {
			titleLbl.setWidth("142px");
			titleFocPanel.setWidth("143px");
			titleFocPanel.addStyleName(folderStyle.parent());
			titleLbl.getElement().getNextSiblingElement().removeAttribute("style");
			htmlToolTipContent.getParent().getElement().getPreviousSiblingElement().removeAttribute("style");
		} else if(nextLevel == 3) {
			titleLbl.setWidth("114px");
			titleFocPanel.setWidth("115px");
			titleFocPanel.addStyleName(folderStyle.child());
			titleLbl.getElement().getNextSiblingElement().setAttribute("style", "left:105px;");
			htmlToolTipContent.getParent().getElement().getPreviousSiblingElement().setAttribute("style", "left:20px;");
		} else if(nextLevel == 4) {
			titleLbl.setWidth("100px");
			titleFocPanel.setWidth("89px");
			titleLbl.getElement().getNextSiblingElement().setAttribute("style", "left:133px;");
			htmlToolTipContent.getParent().getElement().getPreviousSiblingElement().setAttribute("style", "left:21px;");
			titleFocPanel.addStyleName(folderStyle.collectionChild());
			try {
				titleFocPanel.getParent().getParent().getParent().getParent().getElement().getStyle().setPadding(0, Unit.PX);
			} catch (Exception e){}
		}
	}
	
	CollectionAssignShareHandler handler = new CollectionAssignShareHandler() {

		@Override
		public void updateShareType(String shareType,String publishStatus,boolean isPublish,CollectionDo collec) {
			
           if(!isPublish){
        	   if(collectionDo.getType().equals("scollection") || collectionDo.getType().equals("collection")){
   				if(titleFocPanel.getStyleName().contains(folderStyle.open())) {
   					if(shareType.equalsIgnoreCase("public")){
   						titleFocPanel.addStyleName(folderStyle.publicIcon());
   						panelToolTip.getElement().getStyle().clearDisplay();
   					}else{
   						if(titleFocPanel.getStyleName().contains("public")){
   							titleFocPanel.removeStyleName(folderStyle.publicIcon());
   							panelToolTip.getElement().getStyle().setDisplay(Display.NONE);
   						}
   					}

   				}
   			} 
           }
			
		}
	};

	public void setEmptyData() {
		htmlPanel = new HTMLPanel(i18n.GL0989());
		htmlPanel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		htmlPanel.getElement().getStyle().setMarginLeft(19, Unit.PX);
		htmlPanel.getElement().getStyle().setColor("#999999");
		htmlPanel.getElement().setId(collectionDo.getGooruOid());
		contentVerPanel.add(htmlPanel);
	}

	public void removeEmptyData() {
		if (contentVerPanel.getWidget(0) instanceof HTMLPanel) {
			contentVerPanel.clear();
		}
	}

	/**
	 * Update collection information
	 * 
	 * @param collectionDo
	 *            instance of {@link CollectionDo}
	 */
	public void updateData(FolderDo collectionDo) {
		this.collectionDo = collectionDo;
		titleLbl.setHTML(collectionDo.getTitle());
		titleLbl.getElement().setAttribute("alt", collectionDo.getTitle());
		titleLbl.getElement().setAttribute("title", collectionDo.getTitle());
	}

	/**
	 * Update collection item
	 * 
	 * @param collectionItemDo
	 *            instance of {@link CollectionItemDo}
	 */
	public void updateCollectionItem(FolderDo collectionItemDo,int Newsequence) {
//		this.collectionDo = collectionItemDo;
		ShelfResource shelfResource = getShelfResource(collectionItemDo.getGooruOid());
		int widgetCount = contentVerPanel.getWidgetCount();
		int sequence = Newsequence - 1;
		if (Newsequence > sequence) {
			contentVerPanel.insert(shelfResource,widgetCount > 0 ? sequence >= widgetCount ? widgetCount: (sequence + 1) : 0);
		}
		if (sequence < Newsequence) {
			contentVerPanel.insert(shelfResource,widgetCount > 0 ? sequence >= widgetCount ? widgetCount: sequence : 0);
		}
		
//		 contentVerPanel.insert(shelfResource,widgetCount > 0 ? sequence >= widgetCount ? widgetCount: sequence : 0);
		
		/** commented temporarily **/
/*		int sequence = collectionItemDo.getItemSequence() - 1;
		if (collectionItemDo.getItemSequence() > sequence) {
			contentVerPanel.insert(shelfResource,
					widgetCount > 0 ? sequence >= widgetCount ? widgetCount
							: (sequence + 1) : 0);
		}
		if (sequence < collectionItemDo.getItemSequence()) {
			contentVerPanel.insert(shelfResource,
					widgetCount > 0 ? sequence >= widgetCount ? widgetCount
							: sequence : 0);
		}
*/
		/** commented temporarily **/

		// contentVerPanel.insert(shelfResource,widgetCount > 0 ? sequence >=
		// widgetCount ? widgetCount: sequence : 0);
		shelfResource.glowTitle();
	}

	/**
	 * Create new collection item to collection
	 * 
	 * @param collectionItemDo
	 *            which is to be added to collection
	 * @param isNew
	 *            check new collection or exists collection
	 */
	/*public void addCollectionItem(FolderItemDo collectionItemDo, boolean isNew) {
		Document doc = Document.get();
        if (doc.getElementById(collectionDo.getGooruOid()) != null)
            doc.getElementById(collectionDo.getGooruOid()).removeFromParent();
		if (isNew) {
			if (this.collectionDo.getCollectionItems() == null) {
				this.collectionDo.setCollectionItems(new ArrayList<FolderItemDo>());
			}
			this.collectionDo.getCollectionItems().add(collectionItemDo);
		}
		ShelfResource shelfResource = new ShelfResource(collectionItemDo);
		int widgetCount = contentVerPanel.getWidgetCount();
		//int sequence = collectionItemDo.getItemSequence() - 1;
		int sequence = 0;
		if (collectionDo.getType().equals("collection") || collectionDo.getType().equals("scollection") ) {  
			contentVerPanel.insert(shelfResource,widgetCount > 0 ? sequence >= widgetCount ? widgetCount: sequence : 0);
		}
		if (isNew) {
			addSuccessMsg.setVisible(false);
			contentVerPanel.setVisible(true);
			shelfResource.glowTitle();
	            if(contentVerPanel.getWidgetCount()==2 && (AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.RESOURCE_SEARCH))){
	        		AppClientFactory.fireEvent(new UserInfoMsgShelfEvent(CONGRATS_MSG));
	        	}
		}
	}*/

	/**
	 * Remove the collection item from the collection
	 * 
	 * @param collectionItemDo
	 *            which is to be removed
	 */
	public void removeCollectionItem(FolderDo collectionItemDo) {
		this.collectionDo.getCollectionItems().remove(collectionItemDo);
		//this.collectionDo.getCollectionItems().remove(1);
		ShelfResource shelfResource = getShelfResource(collectionItemDo.getGooruOid());
		if (shelfResource != null) {
			contentVerPanel.remove(shelfResource);
		}
		if(collectionItemDo.getItemCount()==0){
			if (collectionDo.getType().equals("collection") || collectionDo.getType().equals("scollection")) {
				htmlPanel = new HTMLPanel(i18n.GL0854());
				htmlPanel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
				htmlPanel.getElement().getStyle().setMarginLeft(19, Unit.PX);
				htmlPanel.getElement().getStyle().setColor("#999999");
				htmlPanel.getElement().getStyle().setFontStyle(FontStyle.ITALIC);
				htmlPanel.getElement().setId(collectionDo.getGooruOid());
				contentVerPanel.add(htmlPanel);
			}
		}
		/*if (collectionItemDo.getCollection().getCollectionItems().size() <= 0) {
			if (collectionDo.getType().equals("folder")) {
				htmlPanel = new HTMLPanel(i18n.GL0989());
				htmlPanel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
				htmlPanel.getElement().getStyle().setMarginLeft(19, Unit.PX);
				htmlPanel.getElement().getStyle().setColor("#999999");
				htmlPanel.getElement().setId(collectionDo.getGooruOid());
				contentVerPanel.add(htmlPanel);
			} else if (collectionDo.getType().equals("collection") || collectionDo.getType().equals("scollection") ) {
				htmlPanel = new HTMLPanel(i18n.GL0854());
				htmlPanel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
				htmlPanel.getElement().getStyle().setMarginLeft(19, Unit.PX);
				htmlPanel.getElement().getStyle().setColor("#999999");
				htmlPanel.getElement().getStyle().setFontStyle(FontStyle.ITALIC);
				htmlPanel.getElement().setId(collectionDo.getGooruOid());
				contentVerPanel.add(htmlPanel);
			}
		}*/
	}

	/**
	 * Get collection item
	 * 
	 * @param collectionItemId
	 *            get collection by collection item id
	 * @return instance of {@link ShelfResource} as widget
	 */
	private ShelfResource getShelfResource(String collectionItemId) {
		Iterator<Widget> widgets = contentVerPanel.iterator();
		while (widgets.hasNext()) {
			Widget widget = widgets.next();
			if (widget instanceof ShelfResource
					&& ((ShelfResource) widget).getCollectionItemDo().getGooruOid().equals(collectionItemId)) {
				return (ShelfResource) widget;
			}
		}
		return null;
	}

	@Override
	public void onDragOver(final Draggable draggable) {
	        if (draggable.getType().equals(DRAG_TYPE.RESOURCE)) {
	        	if(folderDo.getType().equalsIgnoreCase("folder")){
	        		draggable.getDraggableMirageUc().onDroppable(false);
	        		titleFocPanel.removeStyleName(folderStyle.draggingInto());
	        		wrapperFocPanel.getElement().getStyle().clearBackgroundColor();
	        		toolTipPopupPanel.clear();
	    			toolTipPopupPanel.setWidget(new SearchDragToolTip(i18n.GL1135()));
	    			toolTipPopupPanel.setStyleName("");
	    			toolTipPopupPanel.setPopupPosition(draggable.getElement().getAbsoluteLeft()+8, draggable.getElement().getAbsoluteTop()+10);
	    			toolTipPopupPanel.show();
	        	}else{
	        		if(collectionIsOpened) {
	        			draggable.getDraggableMirageUc().onDroppable(true);
    	        		titleFocPanel.addStyleName(folderStyle.draggingInto());
    	        		wrapperFocPanel.getElement().getStyle().setBackgroundColor(DRAGGING_INTO_COLOR);
    	        		toolTipPopupPanel.hide();
	        		}else{
	        			draggable.getDraggableMirageUc().onDroppable(true);
    	        		titleFocPanel.addStyleName(folderStyle.draggingInto());
    	        		wrapperFocPanel.getElement().getStyle().setBackgroundColor(DRAGGING_INTO_COLOR);
    	        		toolTipPopupPanel.hide();
    	        		
	        			/** Changed to new API call for fetching resources in a order **/
    	        		AppClientFactory.getInjector().getfolderService().getCollectionResources(folderDo.getGooruOid(),null, null, new SimpleAsyncCallback<FolderListDo>(){
							@Override
							public void onSuccess(FolderListDo result) {
								setAllResources(result.getSearchResult());
		    					setCollectionOpenedStatus(true);
							}
    	        		});
    	        		
    	        		/** Previously used API Call **/
    	        		/*AppClientFactory.getInjector().getfolderService().getChildFolders(folderDo.getGooruOid(),null, null,false, new AsyncCallback<FolderListDo>() {
		    				@Override
		    				public void onSuccess(FolderListDo result) { 
		    					setAllResources(result.getSearchResult());
		    					setCollectionOpenedStatus(true);
		    				}
		    				@Override
		    				public void onFailure(Throwable caught) {
		    				}
		    			});*/
	        		}
	        		this.setOpen();
//	        		AppClientFactory.fireEvent(new ResourceDragOverShelfEvent(folderDo.getGooruOid())); 
	        	}
	        }else if(draggable.getType().equals(DRAG_TYPE.COLLECTION)){ 
	        	if(folderDo.getType().equalsIgnoreCase("scollection")||folderDo.getType().equalsIgnoreCase("collection")){
	        		toolTipPopupPanel.clear();
	    			toolTipPopupPanel.setWidget(new SearchDragToolTip(i18n.GL1136()));
	    			toolTipPopupPanel.setStyleName("");
	    			toolTipPopupPanel.setPopupPosition(draggable.getElement().getAbsoluteLeft()+8, draggable.getElement().getAbsoluteTop()+10);
	    			toolTipPopupPanel.show();
	        	}else{
	        		setDraggingIntoStyle(draggable);
	        		/*if(level==1){
	        			setDraggingIntoStyle(draggable);
	        		}else if(level==2){
	        			titleFocPanel.removeStyleName(folderStyle.draggingInto());
	        			draggable.getDraggableMirageUc().onDroppable(false);
	        			if(folderIsOpened){
	        				setDraggingIntoStyle(draggable);
	        			}
	        			setDraggingIntoStyle(draggable);
	        		}else if(level==3){
        				titleFocPanel.removeStyleName(folderStyle.draggingInto());
        				draggable.getDraggableMirageUc().onDroppable(false);
        				if(folderIsOpened){
        					setDraggingIntoStyle(draggable);
        				}
	        			setDraggingIntoStyle(draggable);
        			}*/
	        		toolTipPopupPanel.hide();
	        	}
	        }
	}
	

	private void setDraggingIntoStyle(Draggable draggable) {
		draggable.getDraggableMirageUc().onDroppable(true);
		titleFocPanel.addStyleName(folderStyle.draggingInto());
		toolTipPopupPanel.hide();
	}

	@Override
	public void onDragOut(Draggable draggable) {
        glassContainer.setGlassVisible(false);
        if (draggable.getType().equals(DRAG_TYPE.RESOURCE)) {
            draggable.getDraggableMirageUc().onDroppable(false);
            titleFocPanel.removeStyleName(folderStyle.draggingInto());
            wrapperFocPanel.getElement().getStyle().clearBackgroundColor();
            toolTipPopupPanel.hide();
        }else if(draggable.getType().equals(DRAG_TYPE.COLLECTION)){
        	   toolTipPopupPanel.hide();
        	   titleFocPanel.removeStyleName(folderStyle.draggingInto());
        }
    }

	@Override
	public Widget getDropTarget() {
		return this;
	}

	@Override
	public void onDrop(final Draggable draggable) {
        if (draggable.getType().equals(DRAG_TYPE.RESOURCE)) {
            //setOpen();
        	if(folderDo.getType().equalsIgnoreCase("folder")){
        		toolTipPopupPanel.hide();
        	}else{
        		new CustomAnimation(draggable).run(50);
        		/** Changed to new API call for fetching resources in a order **/
        		AppClientFactory.getInjector().getfolderService().getCollectionResources(folderDo.getGooruOid(),null, null, new SimpleAsyncCallback<FolderListDo>(){
					@Override
					public void onSuccess(FolderListDo result) {
						if (result.getCount()<25){
	    	               	contentVerPanel.setVisible(false);
	    	        		addSuccessMsg.setVisible(true);
	    	        		Document doc = Document.get();
	    	                if (doc.getElementById(collectionDo.getGooruOid()) != null)
	    	                    doc.getElementById(collectionDo.getGooruOid()).removeFromParent();
	    	                AppClientFactory.fireEvent(new CreateCollectionItemEvent(collectionDo.getGooruOid(), draggable.getDragId()));
	    	                }else{
	    	                	AlertContentUc alertContentUc = new AlertContentUc(i18n.GL0061(),i18n.GL0302());
	    	                }
					}
        		});
        		
        		
        		
        		/** Previously used API call **/
        		/*AppClientFactory.getInjector().getfolderService().getChildFolders(collectionDo.getGooruOid(),null, null,false, new AsyncCallback<FolderListDo>() {
    				@Override
    				public void onSuccess(FolderListDo result) { 
    	                if (result.getCount()<25){
    	               	contentVerPanel.setVisible(false);
    	        		addSuccessMsg.setVisible(true);
    	        		Document doc = Document.get();
    	                if (doc.getElementById(collectionDo.getGooruOid()) != null)
    	                    doc.getElementById(collectionDo.getGooruOid()).removeFromParent();
    	                AppClientFactory.fireEvent(new CreateCollectionItemEvent(collectionDo.getGooruOid(), draggable.getDragId()));
    	                }else{
    	                	AlertContentUc alertContentUc = new AlertContentUc(i18n.GL0061,i18n.GL0302);
    	                }
    				}
    				@Override
    				public void onFailure(Throwable caught) {
    				}
    			});*/
        	
        	}
        }else if(draggable.getType().equals(DRAG_TYPE.COLLECTION)){
        	if(folderDo.getType().equalsIgnoreCase("folder")){
        		draggedCollectionId = draggable.getDragId(); 
        		new CustomAnimation(draggable).run(50);
        		toolTipPopupPanel.hide();
        		AppClientFactory.fireEvent(new DragOverOpenFolderEvent(folderDo.getGooruOid(),true));   
        		/*if(level==1){
            		draggedCollectionId = draggable.getDragId(); 
            		new CustomAnimation(draggable).run(50);
            		toolTipPopupPanel.hide();
            		AppClientFactory.fireEvent(new DragOverOpenFolderEvent(folderDo.getGooruOid(),true));   
            		if(!folderIsOpened){
//        				AppClientFactory.fireEvent(new DragOverOpenFolderEvent(folderDo.getGooruOid())); 
        			}else{
        				getCollectionForm();
        			}
            	}else if(level==2 || level==3){
            		draggedCollectionId = draggable.getDragId(); 
            		new CustomAnimation(draggable).run(50);
            		toolTipPopupPanel.hide();
            		AppClientFactory.fireEvent(new DragOverOpenFolderEvent(folderDo.getGooruOid(),true));  
            		if(!folderIsOpened){
//        				AppClientFactory.fireEvent(new DragOverOpenFolderEvent(folderDo.getGooruOid())); 
        			}else{
        				getCollectionForm();
        			}
            	}*/
        		
        	}
        	toolTipPopupPanel.hide();
        	titleFocPanel.removeStyleName(folderStyle.draggingInto());
        }
	}

	public void disableDraggableOnDrop() {
		this.draggable.getDraggableMirageUc().onDroppable(true);
	}
	
	public void setOpen(boolean isOpen) {
		if(isOpen) {
			titleFocPanel.addStyleName(folderStyle.open());
		} else {
			titleFocPanel.removeStyleName(folderStyle.open());
		}
		setOpenStatus(false);
		disPanel.setOpen(isOpen);
	}

	public boolean isOpen() {
		return disPanel.isOpen();
	}
	
	public void setOpenStatus(boolean isNewPage) {
		if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.SHELF)) {
			disPanel.getElement().getStyle().setDisplay(Display.NONE);
		} else if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.RESOURCE_SEARCH)||AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.COLLECTION_SEARCH)){
			disPanel.getElement().getStyle().setDisplay(Display.BLOCK);
//			if(folderDo.getItemCount()==null || folderDo.getItemCount()==0){
			
			/** Changed to new API call for fetching resources in a order **/
    		AppClientFactory.getInjector().getfolderService().getCollectionResources(folderDo.getGooruOid(),null, null, new SimpleAsyncCallback<FolderListDo>(){
				@Override
				public void onSuccess(FolderListDo result) {
					if(result.getSearchResult().size()==0){
						setCollectionItems(result.getSearchResult());
					}else{
						setCollectionItems(result.getSearchResult());
					}
				}
    		});
			
			/**Previously used API call **/
			/*AppClientFactory.getInjector().getfolderService().getChildFolders(folderDo.getGooruOid(),null, null,false, new AsyncCallback<FolderListDo>() {
				@Override
				public void onSuccess(FolderListDo result) {
					if(result.getSearchResult().size()==0){
						setCollectionItems(result.getSearchResult());
					}else{
						setCollectionItems(result.getSearchResult());
					}

				}

				@Override
				public void onFailure(Throwable caught) {
				}
			});*/
//			}
			
			
		}
	}
	
	public void enableGlassPanel(boolean enable) {
		glassContainer.setGlassVisible(enable);
	}

	@Override
	public void onMouseOver(MouseOverEvent event) {
		if (event.getSource().equals(wrapperFocPanel)) {
			if (!getDropController().isDropActive()) {
			}
		}
	}

	public class ClickOnFolderItem implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			if(!collectionDo.getType().equals("folder")) {
				if (event.getSource().equals(titleFocPanel)) {
		        	MixpanelUtil.Expand_CollectionPanel();
		        	if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.SHELF)) {
		          		Storage stockStore = Storage.getLocalStorageIfSupported();
		                if (stockStore != null) {
		                    stockStore.setItem("tabKey", "resourceTab");
		                }
		                if(isValue){
		                	openCollectionInShelf();
		                }
		                isValue=true;
		        	}
		        	setOpen();
		        }  else if (event.getSource().equals(wrapperFocPanel)) {
		            if (!getDropController().isDropActive()) 
		            {
		            	MixpanelUtil.Edit_This_Collection();
		                Storage stockStore = Storage.getLocalStorageIfSupported();
		            
		                if (stockStore != null) {
		                    stockStore.setItem("tabKey", "resourceTab");
		                }
		            }
		        }
			}
		}
	}
	
	public void openFolderItem() {
		if(collectionDo.getType().equals("folder")) {
			if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.SHELF) && !isEditButtonSelected) {
     			openFolderInShelf();
			}
		}
	}
	
	public VerticalPanel getContentVerPanel() {
		return contentVerPanel;  
	}

	public void setOpen() {
	    if (shelfCollection == null || !shelfCollection.equals(this)) {
            if (shelfCollection != null) {
                shelfCollection.setOpen(false);
                setOpenStyle(false, shelfCollection.level);
            }
            shelfCollection = this;
            setOpen(!isOpen());
        } else if (shelfCollection != null) {
            shelfCollection.enableGlassPanel(false);
        }
	}

	@Override
	protected void onLoad() {
		super.onLoad();
		registerDropController();
	}

	@Override
	protected void onUnload() {
		super.onUnload();
		unregisterDropController();
	}

	@Override
	public void registerDropController() {
		AppClientFactory.fireEvent(new RegisterSearchDropEvent(dropController,
				RegisterSearchDropEvent.DROP_AREA.COLLECTION));
	}

	@Override
	public void unregisterDropController() {
		AppClientFactory.fireEvent(new UnregisterSearchDropEvent(
				dropController, RegisterSearchDropEvent.DROP_AREA.COLLECTION));
	}

	/**
	 * @return dropController instance of {@link ResourceDropController}
	 */
	public ResourceDropController getDropController() {
		return dropController;
	}

	public void setDropController(ResourceDropController dropController) {
		this.dropController = dropController;
	}

	/**
	 * @return collectionDo
	 */
	public FolderDo getCollectionDo() {
		return collectionDo;
	}

	@Override
	public void reregisterDropController() {
		unregisterDropController();
		registerDropController();
	}

	public void glowTitle() {
		new FontWeightEffect(titleLbl.getElement(), FontWeight.BOLD, FontWeight.NORMAL, 5000);
	}
	
	public void setWidgetPositions(int level, int position, HashMap<String,String> urlParams) {
		this.level = level;
		this.position = position;

		if(level==1) {
			this.urlParams.put(O1_LEVEL, collectionDo.getGooruOid());
		}
		if(level==2) {
			this.urlParams.put(O1_LEVEL, urlParams.get(O1_LEVEL));
			this.urlParams.put(O2_LEVEL, collectionDo.getGooruOid());
		}
		if(level==3) {
			this.urlParams.put(O1_LEVEL, urlParams.get(O1_LEVEL));
			this.urlParams.put(O2_LEVEL, urlParams.get(O2_LEVEL));
			this.urlParams.put(O3_LEVEL, collectionDo.getGooruOid());
		}
		if(level==4) {
			this.urlParams.put(O1_LEVEL, urlParams.get(O1_LEVEL));
			this.urlParams.put(O2_LEVEL, urlParams.get(O2_LEVEL));
			this.urlParams.put(O3_LEVEL, urlParams.get(O3_LEVEL));
			this.urlParams.put(ID, collectionDo.getGooruOid());
		}
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getPosition() {
		return position;
	}
	
	public boolean getFolderOpenedStatus() {
		return folderIsOpened;
	}
	
	public void setFolderOpenedStatus(boolean folderIsOpened) {
		this.folderIsOpened = folderIsOpened;
	}
	
	public boolean getCollectionOpenedStatus() {
		return collectionIsOpened;
	}
	
	public void setCollectionOpenedStatus(boolean collectionIsOpened) {
		this.collectionIsOpened = collectionIsOpened;
	}

	public void setCollectionItems(List<FolderDo> folderDo) {
		setAllResources(folderDo);
	}
	
	public void setAllResources(List<FolderDo> folderDo) { 
		contentVerPanel.clear();
		if (folderDo.size() > 0) { 
			for(FolderDo folderItemDo : folderDo) {
				addCollectionItem(folderItemDo, false);
			}
		} else {
			contentVerPanel.clear();
			htmlPanel = new HTMLPanel(i18n.GL0854());
			htmlPanel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
			htmlPanel.getElement().getStyle().setMarginLeft(19, Unit.PX);
			htmlPanel.getElement().getStyle().setColor("#999999");
			htmlPanel.getElement().getStyle().setFontStyle(FontStyle.ITALIC);
			htmlPanel.getElement().setId(collectionDo.getGooruOid());
			contentVerPanel.add(htmlPanel);
		}
	}

	public void addCollectionItem(FolderDo collectionItemDo, boolean isNew) { 
		Document doc = Document.get();
        if (doc.getElementById(collectionDo.getGooruOid()) != null)
            doc.getElementById(collectionDo.getGooruOid()).removeFromParent();
		if (isNew) {
			/*if (this.collectionDo.getCollectionItems() == null) {
				this.collectionDo.setCollectionItems(new ArrayList<FolderItemDo>());
			}
			this.collectionDo.getCollectionItems().add(collectionItemDo);*/
		}
		ShelfResource shelfResource = new ShelfResource(collectionItemDo); 
		int widgetCount = contentVerPanel.getWidgetCount();
//		int sequence = collectionItemDo.getItemSequence() - 1;
		int sequence = 0;
		
		if (collectionDo.getType().equals("collection") || collectionDo.getType().equals("scollection") ) { 
//			contentVerPanel.insert(shelfResource,widgetCount > 0 ? sequence >= widgetCount ? widgetCount: sequence : 0);
			contentVerPanel.add(shelfResource); 
		}
		if (isNew) {
			addSuccessMsg.setVisible(false);
			contentVerPanel.setVisible(true);
			shelfResource.glowTitle();
	            if(contentVerPanel.getWidgetCount()==2 && (AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.RESOURCE_SEARCH))){
	        		AppClientFactory.fireEvent(new UserInfoMsgShelfEvent(CONGRATS_MSG));
	        	}
		}
	}
	
	public HashMap<String,String> getUrlParams() {
		return urlParams;
	}
	
	public void setActiveStyle(boolean isActive) {
		if(isActive){
			titleFocPanel.addStyleName(folderStyle.active());
		} else {
			titleFocPanel.removeStyleName(folderStyle.active());
		}
		
	}

	
	public void setOpenStyle(boolean isOpen, int subElementsCount) 
	{
		Element[] docElement = DOMUtils.getElementsByClassName(folderStyle.arrow(), titleFocPanel.getElement());

		
		if(docElement.length>0 && !(titleFocPanel.getStyleName().contains("folderStyle-collection")))
		{

			if(subElementsCount == 0)
			{
				if(docElement[0].getStyle().getDisplay() != null && docElement[0].getStyle().getDisplay().equalsIgnoreCase("block"))
				{
					docElement[0].getStyle().setDisplay(Display.NONE);	
				}
			}
			if(subElementsCount > 0)
			{
			if(docElement[0].getStyle().getDisplay() != null && docElement[0].getStyle().getDisplay().equalsIgnoreCase("none"))
			{
				docElement[0].getStyle().setDisplay(Display.BLOCK);
			}
			}

		}
		if(isOpen) 
		{
			titleFocPanel.addStyleName(folderStyle.open());
		} 
		else 
		{
			titleFocPanel.removeStyleName(folderStyle.open());
		}
	}

	
	public void openFolderInShelf() {
		Map<String,String> params = new HashMap<String,String>();
		if(getLevel()==1) {
			params.put(O1_LEVEL, collectionDo.getGooruOid());
		} else if(getLevel()==2) {
			params.put(O1_LEVEL, urlParams.get(O1_LEVEL));
			params.put(O2_LEVEL, collectionDo.getGooruOid());
		} else if(getLevel()==3) {
			params.put(O1_LEVEL, urlParams.get(O1_LEVEL));
			params.put(O2_LEVEL, urlParams.get(O2_LEVEL));
			params.put(O3_LEVEL, collectionDo.getGooruOid());
		}
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.SHELF, params);
		AppClientFactory.fireEvent(new SetFolderParentNameEvent(collectionDo.getTitle()));
		AppClientFactory.fireEvent(new SetFolderMetaDataEvent(StringUtil.getFolderMetaData(collectionDo)));

	}
	
	public void openCollectionInShelf() {
    	Map<String,String> params = new HashMap<String,String>();
    	if(getLevel()==2) {
			params.put(O1_LEVEL, urlParams.get(O1_LEVEL));
		} else if(getLevel()==3) {
			params.put(O1_LEVEL, urlParams.get(O1_LEVEL));
			params.put(O2_LEVEL, urlParams.get(O2_LEVEL));
		} else if(getLevel()==4){
			params.put(O1_LEVEL, urlParams.get(O1_LEVEL));
			params.put(O2_LEVEL, urlParams.get(O2_LEVEL));
			params.put(O3_LEVEL, urlParams.get(O3_LEVEL));
		}
    	params.put(ID, collectionDo.getGooruOid());
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.SHELF, params);
	}

	public void getCollectionForm() {
		if(!draggedCollectionId.isEmpty()){
			AppClientFactory.getInjector().getClasspageService().getSCollIdClasspageById(draggedCollectionId, new SimpleAsyncCallback<CollectionDo>(){
				@Override
				public void onSuccess(CollectionDo result) {
					Map<String, String> params = new HashMap<String, String>();
					params.put("collectionId", result.getGooruOid());
					params.put("draggedCollectionTitle", result.getTitle());
					params.put("droppingInto", "Folder");
					params.put("selectedFolderId", folderDo.getGooruOid());
					titleFocPanel.removeStyleName(folderStyle.draggingInto());
					AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.COLLECTION, params);
				}
			});
		}
	}
	
	UpdateShelfFolderNameHandler updateShelfFolderName = new UpdateShelfFolderNameHandler(){

		@Override
		public void updateShelfFolderName(String folderName,String folderId) {
			if(collectionDo.getGooruOid().equals(folderId)){
				collectionDo.setTitle(folderName);
				titleLbl.setHTML(folderName);
				titleLbl.getElement().setAttribute("alt", folderName);
				titleLbl.getElement().setAttribute("title", folderName);
			}
		}
		
	};
		
	
	
}
