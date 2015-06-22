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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.content.CollectionDo;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.effects.FontWeightEffect;
import org.ednovo.gooru.client.mvp.resource.dnd.ResourceDropController;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.SetFolderParentNameEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.UpdateAssmntUrlOnMycollEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.UpdateShelfFolderNameEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.UpdateShelfFolderNameHandler;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.item.EditAssessmentPopup;
import org.ednovo.gooru.client.mvp.shelf.event.CollectionAssignShareEvent;
import org.ednovo.gooru.client.mvp.shelf.event.CollectionAssignShareHandler;
import org.ednovo.gooru.client.mvp.shelf.list.ShelfResource;
import org.ednovo.gooru.client.uc.tooltip.LibraryTopicCollectionToolTip;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.util.DOMUtils;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
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
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 * 
 */
public class ShelfTreeWidget extends FocusPanel {

	private static ShelfCollectionUiBinder uiBinder = GWT.create(ShelfCollectionUiBinder.class);
	
	private static MessageProperties i18n = GWT.create(MessageProperties.class);

	interface ShelfCollectionUiBinder extends UiBinder<Widget, ShelfTreeWidget> {
	}

	@UiField
	HTML titleLbl;

	/*@UiField
	VerticalPanel contentVerPanel;*/

	/*@UiField(provided = true)
	ShelfListCBundle res;*/

	@UiField
	FocusPanel titleFocPanel;

	/*@UiField
	Label addSuccessMsg;*/
	
	@UiField
	Button myShelfEditButton;
	
	/*@UiField HTML htmlToolTipContent;*/
	
	@UiField HTMLPanel panelToolTip;
	
	private String draggedCollectionId="";
	
	private FolderDo collectionDo;

	private ResourceDropController dropController;
	
	private PopupPanel toolTipPopupPanel=new PopupPanel();
	
	private static ShelfTreeWidget shelfTreeWidget;
	
	private boolean isEditButtonSelected = false;

	HTMLPanel htmlPanel;

	private boolean isValue=true;
	
	private boolean isOpen=false;
	
	private int level = 1;
	
	private int position;
	
	private FolderDo folderDo;

	private boolean folderIsOpened = false;
	
	private boolean collectionIsOpened = false;
	
	/*@UiField FolderStyleBundle folderStyle;*/

	HashMap<String,String> urlParams = new HashMap<String,String>();
	
	private static final String O1_LEVEL = "o1";
	
	private static final String O2_LEVEL = "o2";
	
	private static final String O3_LEVEL = "o3";
	
	private static final String ID = "id";
	
	private static final String ASSESSMENT = "assessment";
	
	private static final String ASSESSMENT_URL = "assessment/url";

	private static final String DRAGGING_INTO_COLOR="#E1F0D1";
	
	EditAssessmentPopup editAssessmentPopup=null;
	

	/**
	 * Class constructor , assign the {@link CollectionDo} instance
	 * 
	 * @param collectionDo
	 *            instance of {@link CollectionDo}
	 * @param nextLevel 
	 */
	public ShelfTreeWidget(final FolderDo collectionDo, final int nextLevel) {
		setWidget(uiBinder.createAndBindUi(this));
		myShelfEditButton.setText(i18n.GL0140());
		myShelfEditButton.getElement().setAttribute("alt", i18n.GL0140());
		myShelfEditButton.getElement().setAttribute("title", i18n.GL0140());
		myShelfEditButton.getElement().setId("btnMyShelfEdit");
		if(collectionDo!=null){
			setData(collectionDo,nextLevel);
			this.folderDo=collectionDo;
		}else{
			setData();
		}
		this.getElement().setAttribute("style", "min-height: 42px;");
		myShelfEditButton.getElement().getStyle().setDisplay(Display.NONE);
		myShelfEditButton.getElement().getStyle().setMarginRight(20, Unit.PX);
		titleFocPanel.getElement().setId("focuspnlTitleFocPanel");
		titleLbl.getElement().setId("htmlTitleLbl");
		panelToolTip.getElement().setId("pnlPanelToolTip");
		//htmlToolTipContent.getElement().setId("htmlHtmlToolTipContent");
		titleFocPanel.addClickHandler(new ClickOnFolderItem());
		titleFocPanel.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				if(collectionDo.getCollectionType().equalsIgnoreCase(ASSESSMENT_URL)) {
					myShelfEditButton.getElement().getStyle().setDisplay(Display.BLOCK);
				}

			}
		});
		titleFocPanel.addMouseOutHandler(new MouseOutHandler() {
			@Override
			public void onMouseOut(MouseOutEvent event) {
				myShelfEditButton.getElement().getStyle().setDisplay(Display.NONE);
				/*if(!AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.MYCOLLECTION)) {
					myShelfEditButton.getElement().getStyle().setDisplay(Display.NONE);
				}else{
					myShelfEditButton.getElement().getStyle().setDisplay(Display.NONE);
				}*/
			}
		});
		myShelfEditButton.addMouseOverHandler(new MouseOverHandler() {
		
			@Override
			public void onMouseOver(MouseOverEvent event) {
				if(!AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.MYCOLLECTION)) {
					String tooltipText="";
					if(collectionDo.getType().equalsIgnoreCase("folder")){
						tooltipText = i18n.GL1472();
					}else{
						tooltipText = i18n.GL1473();
					}
					
					toolTipPopupPanel.clear();
					toolTipPopupPanel.setWidget(new LibraryTopicCollectionToolTip(tooltipText,""));
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
		
		/*htmlToolTipContent.setHTML(i18n.GL1395());
		htmlToolTipContent.getElement().setAttribute("alt", i18n.GL1395());
		htmlToolTipContent.getElement().setAttribute("title", i18n.GL1395());*/
		
		AppClientFactory.getEventBus().addHandler(CollectionAssignShareEvent.TYPE, handler);

		AppClientFactory.getEventBus().addHandler(UpdateShelfFolderNameEvent.TYPE,updateShelfFolderName);
		/*if(ASSESSMENT_URL.equalsIgnoreCase(collectionDo.getCollectionType())){
			showAssessmentUrlInfo(collectionDo);
		}*/
	}

	@UiHandler("myShelfEditButton")
	public void myShelfEditButtonHandler(ClickEvent event){
		if(!AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.MYCOLLECTION)) {
			myShelfEditButton.getElement().getStyle().setDisplay(Display.NONE);
			isValue=false;
			if(collectionDo.getType().equalsIgnoreCase("folder")){
				MixpanelUtil.mixpanelEvent("Search_click_folder_edit");
				isEditButtonSelected=true;
				openFolderInShelf();
			}else {
				openCollectionInShelf();
			}
		}else{
			if(ASSESSMENT_URL.equals(collectionDo.getCollectionType())){
				Window.enableScrolling(false);
				editAssessmentPopup=new EditAssessmentPopup(collectionDo) {
					@Override
					public void clickEventOnSaveAssessmentHandler(FolderDo result) {
						if(result!=null){
							showAssessmentUrlInfo(result);
							AppClientFactory.fireEvent(new UpdateAssmntUrlOnMycollEvent(result));
							
						}
						editAssessmentPopup.hide();
					}
					
					@Override
					public void clickEventOnCancelAssessmentHandler(ClickEvent event) {
						editAssessmentPopup.hide();
					}
				};
					
					
				
				editAssessmentPopup.setGlassEnabled(true);
				editAssessmentPopup.show();
				editAssessmentPopup.center();
			}
		}
		
	}
	
	/**
	 * Displays the updated info.
	 * @param result {@link FolderDo}
	 */
	public void showAssessmentUrlInfo(FolderDo result) {
		this.collectionDo = result;
		if(result.getTitle()!=null){
			titleLbl.setHTML(result.getTitle());	
		}
		collectionDo.setTitle(StringUtil.isEmpty(result.getTitle())?"":result.getTitle());
		collectionDo.setUrl(StringUtil.isEmpty(result.getUrl())?"":result.getUrl());
		collectionDo.setGoals(StringUtil.isEmpty(result.getGoals())?"":result.getGoals());
		collectionDo.setSharing(StringUtil.isEmpty(result.getSharing())?"":result.getSharing());
		if(result.getSettings()!=null){
			collectionDo.getSettings().setIsLoginRequired(StringUtil.isEmpty(result.getSettings().getIsLoginRequired())?"":result.getSettings().getIsLoginRequired());
		}
	}

	public void setData(FolderDo collectionDo, int nextLevel) {
		updateData(collectionDo);
		if(!collectionDo.getType().equals("folder")) {
			titleFocPanel.addStyleName("collection");
		}
		if(collectionDo.getCollectionType().contains(ASSESSMENT)){
			titleFocPanel.addStyleName("assessment");
		}
		if(collectionDo.getSharing()!=null && !collectionDo.getSharing().equalsIgnoreCase("") && collectionDo.getSharing().equals("public")) {
			if(collectionDo.getCollectionType().equals("collection") ){
				titleFocPanel.addStyleName("publicIcon");
				panelToolTip.getElement().getStyle().clearDisplay();
			}else if(collectionDo.getCollectionType().equals(ASSESSMENT)){
				titleFocPanel.addStyleName("assesstpublicIcon");
				panelToolTip.getElement().getStyle().clearDisplay();
			}else{
				panelToolTip.getElement().getStyle().setDisplay(Display.NONE);
			}
		}else{
			panelToolTip.getElement().getStyle().setDisplay(Display.NONE);
		}
		
		if(nextLevel == 1) {
			titleLbl.setWidth("138px");
			titleLbl.getElement().getNextSiblingElement().removeAttribute("style");
			//htmlToolTipContent.getParent().getElement().getPreviousSiblingElement().removeAttribute("style");
		} else if(nextLevel == 2) {
			titleLbl.setWidth("111px");
			//titleFocPanel.setWidth("143px");
			titleFocPanel.addStyleName("parent");
			titleLbl.getElement().getNextSiblingElement().removeAttribute("style");
			//htmlToolTipContent.getParent().getElement().getPreviousSiblingElement().removeAttribute("style");
		} else if(nextLevel == 3) {
			titleLbl.setWidth("82px");
			//titleFocPanel.setWidth("115px");
			titleFocPanel.addStyleName("child");
			titleLbl.getElement().getNextSiblingElement().setAttribute("style", "left:105px;");
			//htmlToolTipContent.getParent().getElement().getPreviousSiblingElement().setAttribute("style", "left:20px;");
		} else if(nextLevel == 4) {
			titleLbl.setWidth("100px");
			//titleFocPanel.setWidth("89px");
			titleLbl.getElement().getNextSiblingElement().setAttribute("style", "left:133px;");
			//htmlToolTipContent.getParent().getElement().getPreviousSiblingElement().setAttribute("style", "left:21px;");
			titleFocPanel.addStyleName("collectionChild");
			/*try {
				titleFocPanel.getParent().getParent().getParent().getParent().getElement().getStyle().setPadding(0, Unit.PX);
			} catch (Exception e){
				AppClientFactory.printSevereLogger(e.getMessage());
			}*/
		}
	}
	
	public void setData() {
		String viewType=AppClientFactory.getPlaceManager().getRequestParameter("view",null);
		if(viewType!=null && viewType.equals("Collection")){
			titleFocPanel.addStyleName("collection");
		}
		titleLbl.setWidth("138px");
		titleLbl.getElement().getNextSiblingElement().removeAttribute("style");
	}
	
	CollectionAssignShareHandler handler = new CollectionAssignShareHandler() {

		@Override
		public void updateShareType(String shareType,String publishStatus,boolean isPublish,CollectionDo collec) {
           if(!isPublish){
        	   if(collectionDo.getType().equals("scollection") || collectionDo.getType().equals("collection") || collectionDo.getType().equals(ASSESSMENT)){
   				if(titleFocPanel.getStyleName().contains("open")) {
   					if(shareType.equalsIgnoreCase("public")){
   						if(collectionDo.getCollectionType().equals(ASSESSMENT)){
   							titleFocPanel.addStyleName("assesstpublicIcon");
   						}else{
   							titleFocPanel.addStyleName("publicIcon");
   						}
   						panelToolTip.getElement().getStyle().clearDisplay();
   					}else{
   						if(titleFocPanel.getStyleName().contains("public")){
   							if(collectionDo.getCollectionType().equals(ASSESSMENT)){
   								titleFocPanel.removeStyleName("assesstpublicIcon");
   							}else{
   								titleFocPanel.removeStyleName("publicIcon");
   							}
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
	 * Get collection item
	 * 
	 * @param collectionItemId
	 *            get collection by collection item id
	 * @return instance of {@link ShelfResource} as widget
	 *//*
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
	}*/


	public void setOpen(boolean isOpen) {
		if(isOpen) {
			titleFocPanel.addStyleName("open");
		} else {
			titleFocPanel.removeStyleName("open");
		}
		//setOpenStatus(false);
	}

	
	public boolean isOpen() {
		return isOpen;
	}
	
	public class ClickOnFolderItem implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			if(!collectionDo.getType().equals("folder") && !collectionDo.getCollectionType().equals(ASSESSMENT_URL)) {
				if (event.getSource().equals(titleFocPanel)) {
		        	MixpanelUtil.Expand_CollectionPanel();
		        	if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.MYCOLLECTION)) {
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
		        }  
			}
		}
	}
	
	public void openFolderItem() {
		if(collectionDo.getType().equals("folder")) {
			if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.MYCOLLECTION) && !isEditButtonSelected) {
     			openFolderInShelf();
			}
		}
	}
	
	public void setOpen() {
	    if (shelfTreeWidget == null || !shelfTreeWidget.equals(this)) {
            if (shelfTreeWidget != null) {
                shelfTreeWidget.setOpen(false);
                setOpenStyle(false, shelfTreeWidget.level);
            }
            shelfTreeWidget = this;
            setOpen(isOpen);
        } else if (shelfTreeWidget != null) {
            //shelfCollection.enableGlassPanel(false);
        }
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
		if (folderDo.size() > 0) { 
			for(FolderDo folderItemDo : folderDo) {
				//addCollectionItem(folderItemDo, false);
			}
		} else {
//			/contentVerPanel.clear();
			htmlPanel = new HTMLPanel(i18n.GL0854());
			htmlPanel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
			htmlPanel.getElement().getStyle().setMarginLeft(19, Unit.PX);
			htmlPanel.getElement().getStyle().setColor("#999999");
			htmlPanel.getElement().getStyle().setFontStyle(FontStyle.ITALIC);
			htmlPanel.getElement().setId(collectionDo.getGooruOid());
			//contentVerPanel.add(htmlPanel);
		}
	}

	/*public void addCollectionItem(FolderDo collectionItemDo, boolean isNew) { 
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
	            if(contentVerPanel.getWidgetCount()==2 && (AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.SEARCH_RESOURCE))){
	        		AppClientFactory.fireEvent(new UserInfoMsgShelfEvent(CONGRATS_MSG));
	        	}
		}
	}*/
	
	public HashMap<String,String> getUrlParams() {
		return urlParams;
	}
	
	public void setActiveStyle(boolean isActive) {
		if(isActive){
			titleFocPanel.addStyleName("active");
		} else {
			titleFocPanel.removeStyleName("active");
		}
		
	}

	
	public void setOpenStyle(boolean isOpen, int subElementsCount) 
	{
		Element[] docElement = DOMUtils.getElementsByClassName("arrows", titleFocPanel.getElement());

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
			titleFocPanel.addStyleName("open");
		} 
		else 
		{
			titleFocPanel.removeStyleName("open");
		}
	}
	public void openFolderInShelf() {
		AppClientFactory.printInfoLogger("Openfolderinshelf"+getLevel());
		Map<String,String> params = new HashMap<String,String>();
		if(getLevel()==1) {
			params.put(O1_LEVEL, collectionDo.getGooruOid());
		} else if(getLevel()==2) {
			AppClientFactory.printInfoLogger(" urlParams.get(O1_LEVEL):"+ urlParams.get(O1_LEVEL));
			params.put(O1_LEVEL, urlParams.get(O1_LEVEL));
			params.put(O2_LEVEL, collectionDo.getGooruOid());
		} else if(getLevel()==3) {
			params.put(O1_LEVEL, urlParams.get(O1_LEVEL));
			params.put(O2_LEVEL, urlParams.get(O2_LEVEL));
			params.put(O3_LEVEL, collectionDo.getGooruOid());
		}
		params.put("view", AppClientFactory.getPlaceManager().getRequestParameter("view")); 
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.MYCOLLECTION, params);
		AppClientFactory.fireEvent(new SetFolderParentNameEvent(collectionDo.getTitle()));
		/*AppClientFactory.getInjector().getfolderService().getTocFolders(collectionDo.getGooruOid(),true,new SimpleAsyncCallback<FolderTocDo>() {
			@Override
			public void onSuccess(FolderTocDo result) {
				AppClientFactory.fireEvent(new SetFolderMetaDataEvent(StringUtil.getFolderMetaDataTocAPI(result)));
				
			}
		});*/
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
    	params.put("view", AppClientFactory.getPlaceManager().getRequestParameter("view")); 
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.MYCOLLECTION, params);
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
					titleFocPanel.removeStyleName("draggingInto");
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
