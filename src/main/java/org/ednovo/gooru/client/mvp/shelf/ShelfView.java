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
package org.ednovo.gooru.client.mvp.shelf;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.folders.FoldersWelcomePage;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionCollaboratorTabVc;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareTabVc;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionStatisticsTabVc;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionUploadImageUc;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshCollectionInShelfListEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshType;
import org.ednovo.gooru.client.mvp.socialshare.event.UpdateSocialShareMetaDataEvent;
import org.ednovo.gooru.client.uc.BalloonPopupVc;
import org.ednovo.gooru.client.uc.EditableLabelUc;
import org.ednovo.gooru.client.uc.EditableTextAreaUc;
import org.ednovo.gooru.client.uc.tooltip.ToolTip;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.FontStyle;
import com.google.gwt.dom.client.Style.Position;
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
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;


/**
 * 
 * @fileName : ShelfView.java
 *
 * @description : This file deals with collections in shelf.
 *
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class ShelfView extends BaseViewWithHandlers<ShelfUiHandlers> implements
		IsShelfView, ClickHandler {

	@UiField(provided = true)
	EditableLabelUc collectionTitleUc;

	@UiField(provided = true)
	EditableTextAreaUc collectionDescriptionUc;

	@UiField
	SimplePanel collectionMetaDataSimPanel;

	@UiField
	Label copyCollectionLbl, deleteUserCollectionLbl, collectionEditImageLbl,
			simplePencilPanel,collectionDescriptionTitle;

	@UiField
	SimplePanel shelfTabSimPanel;

	@UiField
	CollectionTabTitleVc infoTabVc, resourceTabVc, collaboratorTabVc,
			shareTabVc, statisticsTabVc, assignTabVc;

	@UiField
	HTML backToSearchHtml, backToSearchPreHtml;

	@UiField
	FlowPanel backToSearchFloPanel, noCollectionResetPanel, collectionFloPanel;

	@UiField(provided = true)
	ShelfCBundle res;

	@UiField
	Button collectionPreviewBtn,editSelfCollectionDescSaveButton,editSelfCollectionSaveButton,editSelfCollectionSaveButtonCancel,editSelfCollectionDescSaveButtonCancel;

	@UiField
	CollectionUploadImageUc collectionImageShelfUc;

	/*
	 * @UiField FocusPanel simplePencilFocPanel;
	 */
	@UiField
	HTMLPanel collPopup, statPopup,loadingImageLabel,panelFriendly;

	@UiField
	FlowPanel shelfViewMainContainer;

	@UiField Image imgNotFriendly;
	
	@UiField
	HTMLEventPanel collectionTitleContainer,
			collectionDescriptionTitleContainer, 
			editCollectionTitle, editCollectionDescTitle;
	
	ToolTip toolTip=null;
	
	@UiField Image imgFriendly;
	
	@UiField Label lblFriendly;
	
	boolean collectionItemsNotFriendly = false;

	private DeleteConfirmPopupVc deleteConfirmPopup;

	private CollectionCollaboratorTabVc collectionCollaboratorTabVc;

	private CollectionShareTabVc collectionShareTabVc;
	
	private CollectionStatisticsTabVc collectionStatisticsTabVc;

	private static CollectionDo collectionDo = null;

	private PlaceRequest searchRequest = null;
	
	private PlaceRequest oldSearchRequest = null;
	
	private boolean isEditCopy=false;
	
	private boolean isShowTitlePencil=true;
	
	private boolean isShowDescPencil=true;

	/* HTML5 Storage implementation for tab persistance */
	private Storage stockStore = null;

	Image categoryImage = new Image();

	@UiField
	Label titleAlertMessageLbl;

	@UiField
	Label descriptionAlertMessageLbl;

	private Timer tooltipTimer = null;
	
	boolean refresh = false;

	private static final String WHAT_IS_THIS_COLLECTION_ABOUT = "Add a learning objective for your collection...";

	private static final String PRE_SEARCH_LINK = "Back To Search \"";
	
	private static final String PRE_CLASSPAGE_LINK="Back To ClassPage";

	private static final String DELETE_COLLECTION = "Delete";

	private static final String NO_COLLECTION_MESSAGE = "You have no collections!";

	private static final int TOOLTIP_DELAY_TIME = 1000;

	private static ShelfViewUiBinder uiBinder = GWT
			.create(ShelfViewUiBinder.class);

	interface ShelfViewUiBinder extends UiBinder<Widget, ShelfView> {
	}

	/**
	 * class constructor
	 */
	public ShelfView() {
		this.res = ShelfCBundle.INSTANCE;
		
				/**
		 * this method is used to save collection description after update
		 */
		collectionDescriptionUc = new EditableTextAreaUc() {

			@Override
			public void onEditDisabled(String text) {
				descriptionAlertMessageLbl
						.addStyleName("titleAlertMessageDeActive");
				descriptionAlertMessageLbl
						.removeStyleName("titleAlertMessageActive");
				editSelfCollectionDescSaveButtonCancel.getElement().getStyle()
						.setDisplay(Display.NONE);
				editSelfCollectionDescSaveButton.getElement().getStyle()
						.setDisplay(Display.NONE);
				collectionDo.setGoals(text);
				getUiHandlers().updateCollectionInfo(
						collectionDo.getGooruOid(), null, text);

			}
		/**
		 * This method is used to validate collection description length and return error message
		 */
			@Override
			public void checkCharacterLimit(String text) {
				if (text.length() >= 415) {
					descriptionAlertMessageLbl
							.addStyleName("titleAlertMessageActive");
					descriptionAlertMessageLbl
							.removeStyleName("titleAlertMessageDeActive");
				} else {
					descriptionAlertMessageLbl
							.addStyleName("titleAlertMessageDeActive");
					descriptionAlertMessageLbl
							.removeStyleName("titleAlertMessageActive");
				}
			}
		};
		/**
		 * this method is used to save collection title after update
		 */
		collectionTitleUc = new EditableLabelUc() {

			@Override
			public void onEditDisabled(String text) {
				titleAlertMessageLbl.addStyleName("titleAlertMessageDeActive");
				titleAlertMessageLbl.removeStyleName("titleAlertMessageActive");
				collectionDo.setTitle(text);
				editSelfCollectionSaveButton.getElement().getStyle()
						.setDisplay(Display.NONE);
				editSelfCollectionSaveButtonCancel.getElement().getStyle()
						.setDisplay(Display.NONE);

				getUiHandlers().updateCollectionInfo(
						collectionDo.getGooruOid(), text, null);
			}
			/**
			 * This method is used to validate collection title length and return error message
			 */
			@Override
			public void checkCharacterLimit(String text) {
				if (text.length() >= 50) {
					titleAlertMessageLbl
							.addStyleName("titleAlertMessageActive");
					titleAlertMessageLbl
							.removeStyleName("titleAlertMessageDeActive");
				} else {
					titleAlertMessageLbl
							.addStyleName("titleAlertMessageDeActive");
					titleAlertMessageLbl
							.removeStyleName("titleAlertMessageActive");
				}
			}
		};
		

		collectionDescriptionUc.setPlaceholder(WHAT_IS_THIS_COLLECTION_ABOUT);
		// collectionDescriptionUc.getElement().setAttribute("placeholder",
		// WHAT_IS_THIS_COLLECTION_ABOUT);
		CollectionCBundle.INSTANCE.css().ensureInjected();
		res.css().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));
		editSelfCollectionDescSaveButtonCancel.getElement().setId("btnEditDescCancel");
		editSelfCollectionSaveButtonCancel.getElement().setId("btnEditCancel");
		editSelfCollectionDescSaveButton.getElement().setId("btnEditDescSave");
		editSelfCollectionSaveButton.getElement().setId("btnSave");
		collectionDescriptionUc.getElement().setId("tatCollectionDescription");
		backToSearchHtml.addClickHandler(this);
		infoTabVc.addClickHandler(this);
		resourceTabVc.addClickHandler(this);
		shareTabVc.addClickHandler(this);
		/* Disabled */
		collaboratorTabVc.addStyleName("deactivated");
//		assignTabVc.addStyleName("deactivated");
		statisticsTabVc.addStyleName("deactivated");
		
		collectionEditImageLbl.setVisible(false);
		editSelfCollectionDescSaveButton.getElement().setId("btnEditDescSave");
		infoTabVc.getElement().setId("lblInfoTab");
		resourceTabVc.getElement().setId("lblResourceTab");
		shareTabVc.getElement().setId("lblShareTab");
		assignTabVc.getElement().setId("lblAssignTab");
		statisticsTabVc.getElement().setId("lblStatisticsTab");
		collaboratorTabVc.getElement().setId("lblCollaboratorTab");
		collectionPreviewBtn.getElement().setId("btnCollectionPreview");
		copyCollectionLbl.getElement().setId("lblCopyCollection");
		deleteUserCollectionLbl.getElement().setId("lblDeleteUserCollection");
		editSelfCollectionDescSaveButtonCancel.getElement().setAttribute(
				"style", "margin-top:3px");
		editSelfCollectionSaveButton.getElement().getStyle()
				.setDisplay(Display.NONE);
		editSelfCollectionSaveButtonCancel.getElement().getStyle()
				.setDisplay(Display.NONE);
		editSelfCollectionDescSaveButton.getElement().getStyle()
				.setDisplay(Display.NONE);
		editSelfCollectionDescSaveButtonCancel.getElement().getStyle()
				.setDisplay(Display.NONE);
		//collectionPreviewBtn.getElement().getStyle().setFontWeight(FontWeight.NORMAL);
		simplePencilPanel.setVisible(false);

		editCollectionDescTitle
				.addMouseOverHandler(new OnCollectionDescriptionClick());
		editCollectionDescTitle
				.addMouseOutHandler(new OnCollectionDescriptionOut());
		collectionDescriptionTitle.addMouseOverHandler(new OnCollectionDescriptionClick());
		collectionDescriptionTitle.addMouseOutHandler(new OnCollectionDescriptionOut());
		
		collectionTitleContainer.addMouseOverHandler(new hideEditPencil());
		collectionTitleContainer.addMouseOutHandler(new showEditPencil());

		assignTabVc.addClickHandler(this);
		// collaboratorTab.addClickHandler(this);
		// statisticsTab.addClickHandler(this);
		handelChangeImageEvent();
		// simplePencilFocPanel.addMouseOverHandler(new hideEditPencil());
		// simplePencilFocPanel.addMouseOutHandler(new showEditPencil());
		collectionEditImageLbl.addClickHandler(new OnEditImageClick());
		editCollectionTitle.addClickHandler(new OnEditImageClick());
		collectionTitleUc.getElement().setId("txtCollectionTitle");
		 editCollectionDescTitle.addClickHandler(new
		 OpenCollectionEditDescription());
		simplePencilPanel.addClickHandler(new OpenCollectionEditDescription());
		collectionDescriptionTitle.addClickHandler(new OpenCollectionEditDescription());

		collectionFloPanel.addDomHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				event.stopPropagation();
			}
		}, ClickEvent.getType());
		collaboratorTabVc.addMouseOverHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(MouseOverEvent event) {
				tooltipTimer = new Timer() {
					public void run() {
						collPopup.setVisible(true);
					}
				};
				tooltipTimer.schedule(TOOLTIP_DELAY_TIME);
			}
		});
		collaboratorTabVc.addMouseOutHandler(new MouseOutHandler() {

			@Override
			public void onMouseOut(MouseOutEvent event) {
				tooltipTimer.cancel();
				collPopup.setVisible(false);
			}
		});
		statisticsTabVc.addMouseOverHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(MouseOverEvent event) {

				tooltipTimer = new Timer() {
					public void run() {
						statPopup.setVisible(true);
					}
				};
				tooltipTimer.schedule(TOOLTIP_DELAY_TIME);
			}
		});
		statisticsTabVc.addMouseOutHandler(new MouseOutHandler() {

			@Override
			public void onMouseOut(MouseOutEvent event) {
				tooltipTimer.cancel();
				statPopup.setVisible(false);
			}
		});
		
		
		imgNotFriendly.addMouseOverHandler(new MouseOverHandler() {
			
			@Override
			public void onMouseOver(MouseOverEvent event) {
				toolTip = new ToolTip();
				
				toolTip.getElement().getStyle().setBackgroundColor("transparent");
				toolTip.getElement().getStyle().setPosition(Position.ABSOLUTE);
				toolTip.setPopupPosition(imgNotFriendly.getAbsoluteLeft()-(150+22), imgNotFriendly.getAbsoluteTop()+22);
				toolTip.show();
			}
		});
		imgNotFriendly.addMouseOutHandler(new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
				
				EventTarget target = event.getRelatedTarget();
				  if (Element.is(target)) {
					  if (!toolTip.getElement().isOrHasChild(Element.as(target))){
						  toolTip.hide();
					  }
				  }
			}
		});
		
		noCollectionResetPanel.getElement().getStyle().setDisplay(Display.NONE);
		collPopup.setVisible(false);
		statPopup.setVisible(false);
	}
	/**
	 * This class is used to edit collection description
	 */
	public class OpenCollectionEditDescription implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			/*collectionDescriptionUc.switchToEdit();
			collectionDescriptionUc.setText(collectionDo.getGoals());*/
			editSelfCollectionDescSaveButton.getElement().getStyle()
					.setDisplay(Display.BLOCK);
			editSelfCollectionDescSaveButtonCancel.getElement().getStyle()
					.setDisplay(Display.BLOCK);
			/*
			 * editSelfCollectionSaveButton.getElement().getStyle().setDisplay(
			 * Display.NONE);
			 * editSelfCollectionSaveButtonCancel.getElement().getStyle
			 * ().setDisplay(Display.NONE);
			 */
			simplePencilPanel.setVisible(false);
			isShowDescPencil=false;
			collectionDescriptionUc.switchToEdit();
		}
	}
	/**
	 * This method is used to get collection title
	 * @return collection title
	 */
	public static String getCollectionTitle() {
		return collectionDo.getTitle();
	}
	/**
	 * To Set collection meta data info
	 */
	@Override
	public void setCollection(CollectionDo collection) {
		noCollectionResetPanel.getElement().getStyle().setDisplay(Display.NONE);
		this.collectionDo = collection;
		getUiHandlers().clearTabSlot();

		setTab(getPersistantTabObjectUsingTabFlag());
		collectionTitleUc.setText(collection.getTitle());
		collectionDescriptionUc.setText(collection.getGoals());
		collectionImageShelfUc.setUrl(collection.getThumbnails().getUrl());
		collectionImageShelfUc.getCollectionImg().setAltText(collection.getTitle());
		collectionImageShelfUc.getCollectionImg().setTitle(collection.getTitle());
		collectionFloPanel.setVisible(true);
		if (AppClientFactory.isContentAdmin()
				|| collectionDo
						.getUser()
						.getGooruUId()
						.equals(AppClientFactory.getLoggedInUser()
								.getGooruUId())) {
			deleteUserCollectionLbl.setText(DELETE_COLLECTION);
		}
	}
	/**
	 * setInSlot() is a method used by GWTP in it's lifecycle to set the widget hierarchy that has to be shown to the user. Each time setInSlot is called, it will replace the previous presenter that was assigned to that slot
	 */
	@Override
	public void setInSlot(Object slot, Widget content) {
		if (content != null) {
			if (slot == ShelfUiHandlers.TYPE_SHELF_TAB) {
				shelfTabSimPanel.setWidget(content);
			}
		}
	}
	/**
	 * This method is used if we want to add multiple widgets to the same presenter.
	 */
	@Override
	public void addToSlot(Object slot, Widget content) {
		if (content != null) {
			if (slot == ShelfUiHandlers.TYPE_COLLECTION_RESOURCE_TAB) {
				collectionMetaDataSimPanel.setWidget(content);
				if (content != null) {
					Integer resourcesCount = 0;
					if (collectionDo.getCollectionItems() != null
							&& collectionDo.getCollectionItems().size() != 0) {
						resourcesCount = collectionDo.getCollectionItems()
								.size();
					}
					resourceTabVc.setLabel("Content (" + resourcesCount + ")");
				}
			} else if (slot == ShelfUiHandlers.TYPE_COLLECTION_INFO_TAB || slot == ShelfUiHandlers.TYPE_ASSIGN_INFO_TAB ) {
				collectionMetaDataSimPanel.setWidget(content);
			}
		}
	}
	/**
	 * This method is used to reset the data.
	 */
	@Override
	public void reset() {
		super.reset();
		this.collectionDo = null;
		collectionCollaboratorTabVc = null;
		collectionShareTabVc = null;
		collectionStatisticsTabVc = null;
		collectionMetaDataSimPanel.clear();
		collectionFloPanel.setVisible(false);
		collectionTitleUc.setValue("");
		if(!isEditCopy){
			editSelfCollectionSaveButton.getElement().getStyle()
			.setDisplay(Display.NONE);
	        editSelfCollectionSaveButtonCancel.getElement().getStyle()
			.setDisplay(Display.NONE);
	        collectionTitleUc.switchToCancelLabel();
	        editSelfCollectionDescSaveButton.getElement().getStyle()
			.setDisplay(Display.NONE);
	        editSelfCollectionDescSaveButtonCancel.getElement().getStyle()
			.setDisplay(Display.NONE);
	        collectionDescriptionUc.switchToDesCancelLabel();
		}
		collectionDescriptionUc.setValue(WHAT_IS_THIS_COLLECTION_ABOUT);
		collectionDescriptionUc.getElement().setId("tatCollectionDescription");
		isEditCopy=false;
	}
	/**
	 * Back to search view
	 */
	@Override
	public void setBackToSearch() {
		boolean visible = false;
		
		try{
			searchRequest = AppClientFactory.getPlaceManager().getPreviousRequest();
			/*String sercReq = null;
			String clsPageId=null;
			if(searchRequest!=null){
				 sercReq = searchRequest.getParameter("query", null);
				 clsPageId =searchRequest.getParameter("classpageid", null);
			}
			
			if(sercReq!=null || clsPageId!=null){
				oldSearchRequest=searchRequest;
			}
			if((searchRequest!=null) && oldSearchRequest!=null){ 
				String oldSearchReq = searchRequest.getParameter("query", null);
				String newSearchReq = oldSearchRequest.getParameter("query", null);

				if(oldSearchReq!=null && newSearchReq!=null){
					if(oldSearchReq!=newSearchReq){
						refresh=false;
					}
				}

			}

			if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.SHELF)&&!refresh){
				oldSearchRequest=searchRequest;
				refresh=true;
			}*/
			
			
			if (searchRequest != null) {
				String query = searchRequest.getParameter("query", null);
				String classpageId=searchRequest.getParameter("classpageid", null);
				visible = searchRequest != null && query != null;
				boolean 	isVisible = searchRequest != null && classpageId != null;
				if (visible) {
					if ((query.length()) >= 30) {
						query = query.substring(0, 30) + "...";
						backToSearchHtml.setHTML(PRE_SEARCH_LINK + query + "\"");
					} else {
						backToSearchHtml.setHTML(PRE_SEARCH_LINK + query + "\"");
					}

				}
				
				backToSearchPreHtml.setVisible(visible);
				backToSearchHtml.setVisible(visible);

				if(isVisible){
					backToSearchHtml.setHTML(PRE_CLASSPAGE_LINK);
					backToSearchPreHtml.setVisible(isVisible);
					backToSearchHtml.setVisible(isVisible);
				}
			}
		}
		catch(Exception e){
		}

	}
	/**
	 * This is used to go back to search.
	 */
	@Override
	public void onClick(ClickEvent event) {
		Object source = event.getSource();
		getUiHandlers().clearTabSlot();
		if (source.equals(backToSearchHtml)) {
			if(backToSearchHtml.getText().equalsIgnoreCase("Back To ClassPage")){
				AppClientFactory.getPlaceManager().revealPlace(true, searchRequest);
			} else {
				AppClientFactory.getPlaceManager().revealPlace(false, searchRequest);
			}
			
		} else {
			setTab(source);
		}
	}

	/**
	 * view the collection tab
	 * 
	 * @param tab
	 *            which needs to be viewed
	 */
	public void setTab(Object tab) {

		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		panelFriendly.setVisible(false);
		if (tab.equals(infoTabVc)) {
			MixpanelUtil.Click_Info_CollectionEdit();
			setPersistantTabFlag("infoTab");
			infoTabVc.setSelected(true);
			getUiHandlers().revealTab(ShelfUiHandlers.TYPE_COLLECTION_INFO_TAB,
					collectionDo);
		} else if (tab.equals(resourceTabVc)) {
			MixpanelUtil.Click_Resource_CollectionEdit();
			setPersistantTabFlag("resourceTab");
			resourceTabVc.setSelected(true);
			panelFriendly.setVisible(true);
			
			setIpadFriendly();
			
			getUiHandlers().revealTab(
					ShelfUiHandlers.TYPE_COLLECTION_RESOURCE_TAB, collectionDo);
		} else if (tab.equals(statisticsTabVc)) {
			setPersistantTabFlag("statisticsTab");
			statisticsTabVc.setSelected(true);
			collectionMetaDataSimPanel
					.setWidget(getCollectionStatisticsTabVc());
		} else if (tab.equals(collaboratorTabVc)) {
			setPersistantTabFlag("collaboratorTab");
			collaboratorTabVc.setSelected(true);
			collectionMetaDataSimPanel
					.setWidget(getCollectionCollaboratorTabVc());
		}
		else if (tab.equals(assignTabVc)) {
			MixpanelUtil.Click_Assign_CollectionEdit();
			setPersistantTabFlag("assignTab");
			assignTabVc.setSelected(true);
			collectionMetaDataSimPanel.clear();
			getUiHandlers().revealTab(
						ShelfUiHandlers.TYPE_ASSIGN_INFO_TAB, collectionDo);
		}
		else if (tab.equals(shareTabVc)) {
			MixpanelUtil.Click_Share_CollectionEdit();
			setPersistantTabFlag("shareTab");
			shareTabVc.setSelected(true);
			collectionMetaDataSimPanel.setWidget(getCollectionShareTabVc());
			collectionShareTabVc.onReveal();
		}
	}
	/**
	 * 
	 * @function setIpadFriendly 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method is used to set ipad friendly data.
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
	private void setIpadFriendly() {
		int notFriendlyCount = 0;
		for (CollectionItemDo collectionItemDo : collectionDo.getCollectionItems()){
			if (collectionItemDo.getResource().getMediaType() !=null && collectionItemDo.getResource().getMediaType().equalsIgnoreCase("not_ipad_friendly")){
				notFriendlyCount++;
			}
		}
		if (notFriendlyCount>0){
			imgFriendly.getElement().getStyle().clearWidth();
			imgFriendly.setUrl("images/mos/ipadFriendly.png");
			lblFriendly.setText(StringUtil.generateMessage( MessageProperties.GL0449, String.valueOf(notFriendlyCount), notFriendlyCount>1 ? MessageProperties.GL_GRR_ARE : MessageProperties.GL_GRR_IS));
		}else{
			imgFriendly.getElement().getStyle().setWidth(25, Unit.PX);
			imgFriendly.setUrl("images/mos/friendlyResource.png");
			lblFriendly.setText(MessageProperties.GL0453);
		}
	}

	/**
	 * To get the right CollectionTabTitleVc object for display based on tabFlag
	 * in persistant store
	 * 
	 * @return instance of {@link CollectionTabTitleVc}
	 */
	public CollectionTabTitleVc getPersistantTabObjectUsingTabFlag() {

		CollectionTabTitleVc objectToReturn = resourceTabVc;
		stockStore = Storage.getLocalStorageIfSupported();
		if (stockStore != null) {

			String tabFlag = stockStore.getItem("tabKey");

			if (tabFlag != null) {
				if (tabFlag.equalsIgnoreCase("infoTab")) {

					objectToReturn = infoTabVc;

				} else if (tabFlag.equalsIgnoreCase("resourceTab")) {

					objectToReturn = resourceTabVc;

				} else if (tabFlag.equalsIgnoreCase("statisticsTab")) {

					objectToReturn = statisticsTabVc;

				} else if (tabFlag.equalsIgnoreCase("collaboratorTab")) {

					objectToReturn = collaboratorTabVc;

				} else if (tabFlag.equalsIgnoreCase("assignTab")) {

					 objectToReturn = assignTabVc;

				} else if (tabFlag.equalsIgnoreCase("shareTab")) {

					objectToReturn = shareTabVc;

				}
			} else {
				objectToReturn = resourceTabVc;
			}

		}

		return objectToReturn;

	}

	/**
	 * Sets the incoming tabFlag into Persistant store
	 * 
	 * @param flag
	 *            generated when tabs are being switched
	 */
	public void setPersistantTabFlag(String flag) {

		stockStore = Storage.getLocalStorageIfSupported();
		if (stockStore != null) {
			stockStore.setItem("tabKey", flag);
		}

	}

	/**
	 * get collection collaborator tab view
	 * 
	 * @return collection collaborator view
	 */
	public CollectionCollaboratorTabVc getCollectionCollaboratorTabVc() {
		if (collectionCollaboratorTabVc == null) {
			collectionCollaboratorTabVc = new CollectionCollaboratorTabVc(
					collectionDo);
		}
		return collectionCollaboratorTabVc;
	}

	/**
	 * get collection share tab view
	 * 
	 * @return collection share tab view
	 */
	public CollectionShareTabVc getCollectionShareTabVc() {
//		if (collectionShareTabVc == null) {
			collectionShareTabVc = new CollectionShareTabVc(collectionDo);
//		}
		return collectionShareTabVc;
	}

	/**
	 * get collection statistics tab view
	 * 
	 * @return collection statistics tab view
	 */
	public CollectionStatisticsTabVc getCollectionStatisticsTabVc() {
		if (collectionStatisticsTabVc == null) {
			collectionStatisticsTabVc = new CollectionStatisticsTabVc(
					collectionDo);
		}
		return collectionStatisticsTabVc;
	}

	/**
	 * create delete confirmation pop and delete the collection if user wants
	 * 
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */
	@UiHandler("deleteUserCollectionLbl")
	public void deleteCollectionPopup(ClickEvent clickEvent) {
		/*collectionEditButtonContainer.getElement().getStyle()
		.setVisibility(Visibility.HIDDEN);
		
*/		MixpanelUtil.Organize_Click_Collection_Delete();
		deleteConfirmPopup = new DeleteConfirmPopupVc("Are you sure?", "\""
				+ collectionDo.getTitle() + "\"" + " Collection.") {

			@Override
			public void onTextConfirmed() {
				getUiHandlers().deleteCollection(collectionDo.getGooruOid());

				Window.enableScrolling(true);
				AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));

			}
		};
	}
	/*@UiHandler("PreviewBtn")
	public void clickOnPreviewBtn(ClickEvent clickEvent)
	{
		//new CustomAnimation(collectionEditButtonContainer).run(500);
		if (collectionEditButtonContainer.getElement().getStyle()
				.getVisibility().equalsIgnoreCase("VISIBLE")) {
			collectionEditButtonContainer.getElement().getStyle()
					.setVisibility(Visibility.HIDDEN);
		} else {
			collectionEditButtonContainer.getElement().getStyle()
					.setVisibility(Visibility.VISIBLE);
		}
		
	}*/
	/**
	 * allows user to play collection
	 * 
	 * @param event
	 *            {@link ClickEvent} instance
	 */
	@UiHandler("collectionPreviewBtn")
	public void collectionPlay(ClickEvent event) {
	/*	collectionEditButtonContainer.getElement().getStyle()
		.setVisibility(Visibility.HIDDEN);
	*/	MixpanelUtil.Preview_Collection_From_CollectionEdit();
		AppClientFactory.getPlaceManager().revealPlace(
				PlaceTokens.COLLECTION_PLAY,
				new String[] { "id", collectionDo.getGooruOid() });
	}

	/**
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */
	@UiHandler("copyCollectionLbl")
	public void onCopyCollectionClick(ClickEvent clickEvent) {
	/*	collectionEditButtonContainer.getElement().getStyle()
		.setVisibility(Visibility.HIDDEN);
*/		MixpanelUtil.Organize_Click_Collection_Copy();
		getLoadingImageVisible();
		getUiHandlers().copyCollection(collectionDo.getGooruOid());
	}

	/**
	 * change the collection image
	 */
	private void handelChangeImageEvent() {
		collectionImageShelfUc.getChangeImage().addClickHandler(
				new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						collectionImageShelfUc.getChangeImage().getElement().getStyle().setDisplay(Display.NONE);
						getUiHandlers().imageUpload();
					}
				});
	}
	/**
	 * Image upload for collection
	 */
	@Override
	public void onPostCollectionImageUpload(String url) {
		collectionImageShelfUc.setUrl(url);
		collectionImageShelfUc.getCollectionImg().setAltText(collectionDo.getTitle());
		collectionImageShelfUc.getCollectionImg().setTitle(collectionDo.getTitle());
		categoryImage.setUrl(url);
		AppClientFactory.fireEvent(new UpdateSocialShareMetaDataEvent(
				collectionTitleUc.getText(), collectionDescriptionUc.getText(),
				categoryImage.getUrl()));
	}
	/**
	 * Delete the collection
	 */
	@Override
	public void onPostCollectionDelete() {
		deleteConfirmPopup.hide();
		AppClientFactory.fireEvent(new RefreshCollectionInShelfListEvent(
				collectionDo, RefreshType.DELETE));
	}
	/**
	 * Update collection
	 */
	@Override
	public void onPostCollectionUpdate() {
		AppClientFactory.fireEvent(new RefreshCollectionInShelfListEvent(
				collectionDo, RefreshType.UPDATE));
	}
	/**
	 * 
	 * @fileName : ShelfView.java
	 *
	 * @description : This is used to hide the edit pencil.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 02-Jan-2014
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	public class hideEditPencil implements MouseOverHandler {

		@Override
		public void onMouseOver(MouseOverEvent event) {
			if(isShowTitlePencil)
			collectionEditImageLbl.setVisible(true);
		}

	}
	/**
	 * 
	 * @fileName : ShelfView.java
	 *
	 * @description : To show the edit pencil.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 02-Jan-2014
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	public class showEditPencil implements MouseOutHandler {

		@Override
		public void onMouseOut(MouseOutEvent event) {
			collectionEditImageLbl.setVisible(false);
		}

	}
	/**
	 * This class is used to edit collection title and description on click of pencil image  
	 *
	 *
	 */
	private class OnEditImageClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			editSelfCollectionSaveButton.getElement().getStyle()
					.setDisplay(Display.BLOCK);
			editSelfCollectionSaveButtonCancel.getElement().getStyle()
					.setDisplay(Display.BLOCK);
			/*
			 * editSelfCollectionDescSaveButton.getElement().getStyle().setDisplay
			 * (Display.NONE);
			 * editSelfCollectionDescSaveButtonCancel.getElement(
			 * ).getStyle().setDisplay(Display.NONE);
			 */
			collectionTitleUc.switchToEdit();
			isShowTitlePencil=false;
			collectionEditImageLbl.setVisible(false);

		}
	}

	/**
	 * edit the collection title of copy collection.
	 * 
	 */
	@Override
	public void editCopyCollectionTitle() {
		isEditCopy=true;
		editSelfCollectionSaveButton.getElement().getStyle()
		.setDisplay(Display.BLOCK);
        editSelfCollectionSaveButtonCancel.getElement().getStyle()
		.setDisplay(Display.BLOCK);
		collectionEditImageLbl.setVisible(false);
		collectionTitleUc.switchToEdit();
	}
	
	/**
	 * Set focus to the collection title of copy collection.
	 * 
	 */
	@Override
	public void setFocusCollectionTitle() {
		collectionTitleUc.setFocus();
	}
	/**
	 * 
	 * @fileName : ShelfView.java
	 *
	 * @description : This is used to make the simplePencilPanel visible on MouseOver.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 02-Jan-2014
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	public class OnCollectionDescriptionClick implements MouseOverHandler {
		@Override
		public void onMouseOver(MouseOverEvent event) {
			if(isShowDescPencil)
			simplePencilPanel.setVisible(true);
		}
	}
	/**
	 * 
	 * @fileName : ShelfView.java
	 *
	 * @description : This is used to hide the simplePencilPanel  on MouseOut.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 02-Jan-2014
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	public class OnCollectionDescriptionOut implements MouseOutHandler {
		@Override
		public void onMouseOut(MouseOutEvent event) {
			simplePencilPanel.setVisible(false);
		}
	}
/**
 * This method is used to update and save collection title
 * @param event instance of ClickEvent
 */
	@UiHandler("editSelfCollectionSaveButton")
	public void clickedOneditSelfCollectionSaveButton(ClickEvent event) {
		titleAlertMessageLbl.setVisible(false);
		collectionTitleUc.switchToLabel();
		AppClientFactory.fireEvent(new UpdateSocialShareMetaDataEvent(
				collectionTitleUc.getText(), collectionDescriptionUc.getText(),
				categoryImage.getUrl()));
		isShowTitlePencil=true;
	}
	/**
	 * This method is used to update and save collection description
	 * @param event instance of ClickEvent
	 */
	@UiHandler("editSelfCollectionDescSaveButton")
	public void clickedOneditFolderDescSaveButton(ClickEvent event) {
		descriptionAlertMessageLbl.setVisible(false);
		collectionDescriptionUc.switchToLabel();
		AppClientFactory.fireEvent(new UpdateSocialShareMetaDataEvent(
				collectionTitleUc.getText(), collectionDescriptionUc.getText(),
				categoryImage.getUrl()));
		 isShowDescPencil=true;
	}
	/**
	 * This method is used to cancel collection title update
	 * @param event instance of ClickEvent
	 */
	@UiHandler("editSelfCollectionSaveButtonCancel")
	public void clickedOneditSelfCollectionSaveButtonCancel(ClickEvent event) {
		titleAlertMessageLbl.addStyleName("titleAlertMessageDeActive");
		titleAlertMessageLbl.removeStyleName("titleAlertMessageActive");
		titleAlertMessageLbl.setVisible(false);
		editSelfCollectionSaveButton.getElement().getStyle()
				.setDisplay(Display.NONE);
		editSelfCollectionSaveButtonCancel.getElement().getStyle()
				.setDisplay(Display.NONE);
		collectionTitleUc.switchToCancelLabel();
		isShowTitlePencil=true;

	}
	/**
	 * This method is used to cancel collection description update
	 * @param event instance of ClickEvent
	 */
	@UiHandler("editSelfCollectionDescSaveButtonCancel")
	public void clickedOnEditFolderDescSaveButtonCancel(ClickEvent event) {
		descriptionAlertMessageLbl.addStyleName("titleAlertMessageDeActive");
		descriptionAlertMessageLbl.removeStyleName("titleAlertMessageActive");
		descriptionAlertMessageLbl.setVisible(false);
		editSelfCollectionDescSaveButton.getElement().getStyle()
				.setDisplay(Display.NONE);
		editSelfCollectionDescSaveButtonCancel.getElement().getStyle()
				.setDisplay(Display.NONE);
        isShowDescPencil=true;
		collectionDescriptionUc.switchToDesCancelLabel();

	}
	/**
	 * Set No Data of the collection
	 */
	@Override
	public void setNoDataCollection() {
		noCollectionResetPanel.getElement().getStyle()
				.setDisplay(Display.BLOCK);
		noCollectionResetPanel.clear();
		Label noCollectionMessage = new Label(NO_COLLECTION_MESSAGE);
		noCollectionMessage.getElement().getStyle()
				.setTextAlign(TextAlign.CENTER);
		noCollectionMessage.getElement().getStyle()
				.setMarginBottom(30, Unit.PX);
		noCollectionMessage.getElement().getStyle().setMarginTop(30, Unit.PX);
		noCollectionMessage.getElement().getStyle().setColor("#999999");
		noCollectionMessage.getElement().getStyle()
				.setFontStyle(FontStyle.ITALIC);
//		noCollectionResetPanel.add(noCollectionMessage);
		noCollectionResetPanel.add(new FoldersWelcomePage());
		getLoadingImageInvisible();
	}
	/**
	 * To set balloon popup.
	 */
	@Override
	public void setBalloonPopup() {
		BalloonPopupVc balloonPopup = new BalloonPopupVc("", "Coming soon!");
		collPopup.add(balloonPopup);

		BalloonPopupVc balloonStatsPopup = new BalloonPopupVc("",
				"Coming soon!");
		balloonStatsPopup.getPopupContainer().getElement()
				.removeClassName("hoverCollPopupContainerPos");
		balloonStatsPopup.getPopupContainer().getElement()
				.addClassName("hoverStasPopupContainerPos");
		statPopup.add(balloonStatsPopup);
	}
	/**
	 * returns shelfViewMainContainer.
	 */
	public FlowPanel getShelfViewMainContainer() {
		return shelfViewMainContainer;
	}
	/**
	 * To update the resource count.
	 */
	public void updateResoureCount(int resourceCount) {
		com.google.gwt.core.shared.GWT.log("resource count" + resourceCount);
		resourceTabVc.setLabel("Content (" + resourceCount + ")");
		
		setIpadFriendly();
	}
/**
 * This method is used to hide loading image
 */
	@Override
	public void getLoadingImageInvisible() {
		backToSearchFloPanel.setVisible(true);
		loadingImageLabel.setVisible(false);
	}
	/**
	 * This method is used to display loading image
	 */
	public void getLoadingImageVisible() {
		backToSearchFloPanel.setVisible(false);
		loadingImageLabel.setVisible(true);
	}
	/**
	 * To close the delete ConfirmPopup.
	 */
	@Override
	public void hideAllOpenedPopUp() {
		if(deleteConfirmPopup!=null && deleteConfirmPopup.isShowing()){
			deleteConfirmPopup.hide();
		}
		
	}


	
}

