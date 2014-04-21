package org.ednovo.gooru.client.mvp.play.collection.flag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.ednovo.gooru.client.GooruCBundle;
import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter;
import org.ednovo.gooru.client.mvp.settings.CustomAnimation;
import org.ednovo.gooru.client.mvp.shelf.ShelfCBundle;
import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.player.collection.client.view.add.AddResourceToCollectionStylesBundle;
import org.ednovo.gooru.player.collection.client.view.add.tooltip.FlagBundle;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.ContentReportDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

/**
 * @fileName : CollectionFlagView.java
 * 
 * @description :This file is responsible to show view based on
 *              CollectionFlagPopUp.ui.xml for flag in the collection and
 *              resources
 * 
 * @version :5.8
 * 
 * @date: aug 30 2013
 * 
 * @Author Gooru Team
 * 
 * @Reviewer
 * 
 */
public class CollectionFlagView extends
		PopupViewWithUiHandlers<CollectionFlagUiHandler> implements
		IsCollectionFlagView,MessageProperties {
	private static CollectionFlagPopUpUiBinder uiBinder = GWT
			.create(CollectionFlagPopUpUiBinder.class);

	interface CollectionFlagPopUpUiBinder extends
			UiBinder<Widget, CollectionFlagView> {
	}

	@UiField
	HTMLEventPanel flagCollections, flagResources, collectionCancelButton,
			collectionSubmitButton, submitButtonGray;
	
	@UiField
	HTMLPanel resourceFlagContainer, collectionFlagContainer,
			dropdownListContainer;
	@UiField
	CheckBox resourceCheckBox1, resourceCheckBox2, resourceCheckBox3,
			resourceCheckBox4, collectionCheckBox1, collectionCheckBox2,
			collectionCheckBox3, collectionCheckBox4;
	@UiField
	TextArea resourceDescTextArea, collectionDescTextArea;
	@UiField
	HTML collectionTitleField;
	@UiField
	Image popUpCloseButton;
	@UiField
	HTML dropdownListPlaceHolder;
	@UiField
	ScrollPanel dropdownListContainerScrollPanel;
	@UiField Label headerflagtext,incorporateText,notAppropriateText,inaccurateText,otherReasonText,provideMoreDetails,chooseResourceText,becauseText,
	incorporateresourceText,unavailableresourceText,inaccurateTextresource,otherReason,provideMore;
	@UiField HTMLPanel flagCollectionText,flagResourceText;
	HTMLEventPanel flagButtonOnCover = new HTMLEventPanel("");
	HTMLEventPanel flagButtonOnSummary = new HTMLEventPanel("");
	private static final String HEADER_LINK =GL1430;
	
	String collectionGooruOid = "";
	String getDeleteContentGooruOid="";
	String getDeleteContentResourceGooruOid="";
	private PopupPanel appPopUp;
	CollectionItemDo collectionItemDo;
	String collectionTitle="";
	ArrayList<String> resourcesList = new ArrayList<String>();
	ArrayList<String> resourcesListId = new ArrayList<String>();
	ArrayList<String> contentReportList=new ArrayList<String>();
	ArrayList<String> reourceContentReportList=new ArrayList<String>();
	private FlagThankYouPopUpView flagThankYouPopUpView=null;
	@Inject
	public CollectionFlagView(EventBus eventBus) {
		super(eventBus);
		appPopUp = new FlagPopupPanel(false);
		appPopUp.setWidget(uiBinder.createAndBindUi(this));
		popUpCloseButton.addClickHandler(new CloseFlagPopupEvent());
		headerflagtext.setText(GL0600);
		flagCollectionText.getElement().setInnerHTML(GL0601);
		flagResourceText.getElement().setInnerHTML(GL0601);
		flagResourceText.getElement().setInnerHTML(GL0602);
		incorporateText.setText(GL0603);
		notAppropriateText.setText(GL0604);
		inaccurateText.setText(GL0605);
		otherReasonText.setText(GL0606);
		provideMoreDetails.setText(GL0607);
		collectionCancelButton.getElement().setInnerHTML(GL0608);
		collectionSubmitButton.getElement().setInnerHTML(GL0486);
		submitButtonGray.getElement().setInnerHTML(GL0486);
		chooseResourceText.setText(GL0609);
		dropdownListPlaceHolder.getElement().setInnerHTML(GL0610);
		becauseText.setText(GL0611);
		incorporateresourceText.setText(GL0612);
		unavailableresourceText.setText(GL0613);
		inaccurateTextresource.setText(GL0614);
		otherReason.setText(GL0606);
		provideMore.setText(GL0607);
		resourceFlagContainer.setVisible(false);
		submitButtonGray.setVisible(true);
		collectionSubmitButton.setVisible(false);
		dropdownListContainerScrollPanel.getElement().getStyle().setDisplay(Display.NONE);	
		dropdownListPlaceHolder
		.addClickHandler(new OnDropdownListPlaceHolderClick());
		
	}

	public void displayView(String collectionTitle,ArrayList<String> resourcesList,ArrayList<String> resourcesListId) {
		
		FlagBundle.IMAGEBUNDLEINSTANCE.flagstyle().ensureInjected();
				AddResourceToCollectionStylesBundle.IMAGEBUNDLEINSTANCE
				.addResourceToCollectionStyles().ensureInjected();
		popUpCloseButton.setResource(FlagBundle.IMAGEBUNDLEINSTANCE
				.closeFlagPopUpImages());
		
		collectionTitle = collectionTitle.replaceAll("</p>", " ")
				.replaceAll("<p>", "")
				.replaceAll("<br data-mce-bogus=\"1\">", "")
				.replaceAll("<br>", "").replaceAll("</br>", "");
		collectionTitleField.setHTML(HEADER_LINK+" "+ collectionTitle+ " \" "+GL1431+"");
		flagCollections.setStyleName(FlagBundle.IMAGEBUNDLEINSTANCE.flagstyle()
				.flagButtonselected());
		flagResources.setStyleName(FlagBundle.IMAGEBUNDLEINSTANCE.flagstyle()
				.flagbuttonDeSelected());

		// To get content report
			
		getUiHandlers().getContentReport(collectionGooruOid);
		
	}

	private class OnDropdownItemClick implements ClickHandler {

		private String Resourcetitle = "";
		private String resourceId = "";
		private int resourceItemSize;

		public OnDropdownItemClick(String Resourcetitle, String resourceId,
				int resourceItemSize) {
			this.Resourcetitle = Resourcetitle;
			this.resourceId = resourceId;
			this.resourceItemSize = resourceItemSize;

		}

		@Override
		public void onClick(ClickEvent event) {
			dropdownListPlaceHolder.setHTML(Resourcetitle);
			dropdownListPlaceHolder.getElement().setAttribute("id", resourceId);
			dropdownListPlaceHolder.getElement().setAttribute("itemsSize",
					"" + resourceItemSize);
			
			getDeleteContentResourceGooruOid=getUiHandlers().getResourceContentReport(dropdownListPlaceHolder.getElement().getId());
			new CustomAnimation(dropdownListContainerScrollPanel).run(400);
			
				
		}
	}

	private class OnDropdownListPlaceHolderClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			new CustomAnimation(dropdownListContainerScrollPanel).run(400);

		}
	}

	@UiHandler("collectionCancelButton")
	public void onClickOfCollectionCancelButton(ClickEvent event) {
		clearAll();

	}

	@UiHandler("collectionCheckBox1")
	public void onClickOfcollectionCheckBox1(ClickEvent event) {
		if (collectionCheckBox1.isChecked() || collectionCheckBox2.isChecked()
				|| collectionCheckBox3.isChecked()
				|| collectionCheckBox4.isChecked()
				|| resourceCheckBox1.isChecked()
				|| resourceCheckBox2.isChecked()
				|| resourceCheckBox3.isChecked()
				|| resourceCheckBox4.isChecked()) {
			submitButtonGray.setVisible(false);
			collectionSubmitButton.setVisible(true);
		} else {
			submitButtonGray.setVisible(true);
			collectionSubmitButton.setVisible(false);
		}
	}

	// }
	@UiHandler("collectionCheckBox2")
	public void onClickOfcollectionCheckBox2(ClickEvent event) {
		if (collectionCheckBox1.isChecked() || collectionCheckBox2.isChecked()
				|| collectionCheckBox3.isChecked()
				|| collectionCheckBox4.isChecked()
				|| resourceCheckBox1.isChecked()
				|| resourceCheckBox2.isChecked()
				|| resourceCheckBox3.isChecked()
				|| resourceCheckBox4.isChecked()) {
			submitButtonGray.setVisible(false);
			collectionSubmitButton.setVisible(true);
		} else {
			submitButtonGray.setVisible(true);
			collectionSubmitButton.setVisible(false);
		}
	}

	@UiHandler("collectionCheckBox3")
	public void onClickOfcollectionCheckBox3(ClickEvent event) {
		if (collectionCheckBox1.isChecked() || collectionCheckBox2.isChecked()
				|| collectionCheckBox3.isChecked()
				|| collectionCheckBox4.isChecked()
				|| resourceCheckBox1.isChecked()
				|| resourceCheckBox2.isChecked()
				|| resourceCheckBox3.isChecked()
				|| resourceCheckBox4.isChecked()) {
			submitButtonGray.setVisible(false);
			collectionSubmitButton.setVisible(true);
		} else {
			submitButtonGray.setVisible(true);
			collectionSubmitButton.setVisible(false);
		}

	}

	@UiHandler("collectionCheckBox4")
	public void onClickOfcollectionCheckBox4(ClickEvent event) {
		if (collectionCheckBox1.isChecked() || collectionCheckBox2.isChecked()
				|| collectionCheckBox3.isChecked()
				|| collectionCheckBox4.isChecked()
				|| resourceCheckBox1.isChecked()
				|| resourceCheckBox2.isChecked()
				|| resourceCheckBox3.isChecked()
				|| resourceCheckBox4.isChecked()) {
			submitButtonGray.setVisible(false);
			collectionSubmitButton.setVisible(true);
		} else {
			submitButtonGray.setVisible(true);
			collectionSubmitButton.setVisible(false);
		}
	}
	@UiHandler("resourceCheckBox1")
	public void onClickOfresourceCheckBox1(ClickEvent event)
	{
		if(collectionCheckBox1.isChecked()||collectionCheckBox2.isChecked()||collectionCheckBox3.isChecked()||collectionCheckBox4.isChecked()||resourceCheckBox1.isChecked()||resourceCheckBox2.isChecked()||resourceCheckBox3.isChecked()||resourceCheckBox4.isChecked())
			
		{
			submitButtonGray.setVisible(false);
			collectionSubmitButton.setVisible(true);
		}
		else
		{
			submitButtonGray.setVisible(true);
			collectionSubmitButton.setVisible(false);
		}
	}
	
	@UiHandler("resourceCheckBox2")
	public void onClickOfresourceCheckBox2(ClickEvent event)
	{
		if(collectionCheckBox1.isChecked()||collectionCheckBox2.isChecked()||collectionCheckBox3.isChecked()||collectionCheckBox4.isChecked()||resourceCheckBox1.isChecked()||resourceCheckBox2.isChecked()||resourceCheckBox3.isChecked()||resourceCheckBox4.isChecked())
			{
				submitButtonGray.setVisible(false);
				collectionSubmitButton.setVisible(true);
			}
			else
			{
				submitButtonGray.setVisible(true);
				collectionSubmitButton.setVisible(false);
			}
		}
		
	
	@UiHandler("resourceCheckBox3")
	public void onClickOfresourceCheckBox3(ClickEvent event)
	{
		if(collectionCheckBox1.isChecked()||collectionCheckBox2.isChecked()||collectionCheckBox3.isChecked()||collectionCheckBox4.isChecked()||resourceCheckBox1.isChecked()||resourceCheckBox2.isChecked()||resourceCheckBox3.isChecked()||resourceCheckBox4.isChecked())
			{
				submitButtonGray.setVisible(false);
				collectionSubmitButton.setVisible(true);
			}	else
			{
				submitButtonGray.setVisible(true);
				collectionSubmitButton.setVisible(false);
			}
		}
	
	@UiHandler("resourceCheckBox4")
	public void onClickOfresourceCheckBox4(ClickEvent event)
	{
		if(collectionCheckBox1.isChecked()||collectionCheckBox2.isChecked()||collectionCheckBox3.isChecked()||collectionCheckBox4.isChecked()||resourceCheckBox1.isChecked()||resourceCheckBox2.isChecked()||resourceCheckBox3.isChecked()||resourceCheckBox4.isChecked())
			{
				submitButtonGray.setVisible(false);
				collectionSubmitButton.setVisible(true);
			}
			else
			{
				submitButtonGray.setVisible(true);
				collectionSubmitButton.setVisible(false);
			}
			}
	
	@UiHandler("flagCollections")
	public void onClickOfflagCollections(ClickEvent event) {
		flagCollections.setStyleName(FlagBundle.IMAGEBUNDLEINSTANCE.flagstyle()
				.flagButtonselected());
		flagCollections.removeStyleName(FlagBundle.IMAGEBUNDLEINSTANCE
				.flagstyle().flagbuttonDeSelected());
		flagResources.removeStyleName(FlagBundle.IMAGEBUNDLEINSTANCE
				.flagstyle().flagButtonselected());
		flagResources.setStyleName(FlagBundle.IMAGEBUNDLEINSTANCE.flagstyle()
				.flagbuttonDeSelected());
		collectionFlagContainer.setVisible(true);
		resourceFlagContainer.setVisible(false);
	}

	@UiHandler("flagResources")
	public void onClickOfflagResources(ClickEvent event) {
		flagResources.setStyleName(FlagBundle.IMAGEBUNDLEINSTANCE.flagstyle()
				.flagButtonselected());
		flagResources.removeStyleName(FlagBundle.IMAGEBUNDLEINSTANCE
				.flagstyle().flagbuttonDeSelected());
		flagCollections.removeStyleName(FlagBundle.IMAGEBUNDLEINSTANCE
				.flagstyle().flagButtonselected());
		flagCollections.setStyleName(FlagBundle.IMAGEBUNDLEINSTANCE.flagstyle()
				.flagbuttonDeSelected());
		collectionFlagContainer.setVisible(false);
		resourceFlagContainer.setVisible(true);
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
		// TODO Auto-generated method stub

	}

	@Override
	public Widget asWidget() {
		return appPopUp;
	}

	@Override
	public void getDisplayData(CollectionDo collectionDo) {
		collectionTitle = collectionDo.getTitle();
		collectionGooruOid=collectionDo.getGooruOid();
		dropdownListContainer.clear();
		resourcesList.clear();
		resourcesListId.clear();
		if (collectionDo.getCollectionItems().size() > 0) {
			for (CollectionItemDo collectionItem : collectionDo
					.getCollectionItems()) {
				resourcesList.add(collectionItem.getResourceTitle());
				resourcesListId.add(collectionItem.getResource().getGooruOid());
				String Resourcetitle = collectionItem.getResourceTitle().replaceAll("</p>", " ").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "");
				HTML dropDownListItemTitle=new HTML();
				dropDownListItemTitle.setHTML(Resourcetitle);
				dropDownListItemTitle.setStyleName(FlagBundle.IMAGEBUNDLEINSTANCE.flagstyle().dropdownListItemContainer());

				dropdownListContainer.add(dropDownListItemTitle);
				dropDownListItemTitle.addClickHandler(new OnDropdownItemClick(Resourcetitle,collectionItem.getResource().getGooruOid(),resourcesList.size()));
				dropdownListPlaceHolder.getElement().setAttribute("id", collectionItem.getResource().getGooruOid());
			
			}
		}
		displayView(collectionTitle,resourcesList,resourcesListId);

	}
	@UiHandler("collectionSubmitButton")
	public void onClickOfcollectionSubmitButton(ClickEvent event){
			//For Resource Flag
			
			
			if(resourceCheckBox1.isChecked())
			{
				reourceContentReportList.add("missing-concept");
			}
			if(resourceCheckBox2.isChecked())
			{
				reourceContentReportList.add("not-loading");
			}
			if(resourceCheckBox3.isChecked())
			{
				reourceContentReportList.add("inappropriate");
			}
			if(resourceCheckBox4.isChecked())
			{
				reourceContentReportList.add("other");
			}
			//For Collection Flag
		
			if(collectionCheckBox1.isChecked())
			{
				contentReportList.add("missing-concept");
			}
			if(collectionCheckBox2.isChecked())
			{
				contentReportList.add("not-loading");
			}
			if(collectionCheckBox3.isChecked())
			{
				contentReportList.add("inappropriate");
			}
			if(collectionCheckBox4.isChecked())
			{
				contentReportList.add("other");
			}
			
			if(resourceCheckBox1.isChecked()||resourceCheckBox2.isChecked()||resourceCheckBox3.isChecked()||resourceCheckBox4.isChecked()){
			getUiHandlers().createCollectionContentReport(dropdownListPlaceHolder.getElement().getId(),resourceDescTextArea.getText(),reourceContentReportList,getDeleteContentResourceGooruOid);
			}else{
				getUiHandlers().createCollectionContentReport(collectionGooruOid, collectionDescTextArea.getText(), contentReportList, getDeleteContentGooruOid);
			}
			
	
	}
	public void showSuccesmessagePopup(){
		appPopUp.hide();
		clearAll();
		flagThankYouPopUpView=new FlagThankYouPopUpView();
		flagThankYouPopUpView.getCloseButton().addClickHandler(new CloseFlagPopupEvent());
		flagThankYouPopUpView.getOkButton().addClickHandler(new CloseFlagPopupEvent());
		flagThankYouPopUpView.show();
		flagThankYouPopUpView.center();
	}
	public void clearAll()
	{
		resourceCheckBox1.setChecked(false);
		resourceCheckBox2.setChecked(false);
		resourceCheckBox3.setChecked(false);
		resourceCheckBox4.setChecked(false);
		resourceDescTextArea.setText("");
		collectionCheckBox1.setChecked(false);
		collectionCheckBox2.setChecked(false);
		collectionCheckBox3.setChecked(false);
		collectionCheckBox4.setChecked(false);
		collectionDescTextArea.setText("");
		submitButtonGray.setVisible(true);
		collectionSubmitButton.setVisible(false);
		contentReportList.clear();
		reourceContentReportList.clear();
	}

	@Override
	public void setDefaultView() {
		
		
	}

	@Override
	public void setFlag(ContentReportDo contentReportDo, String gooruFlagId) {
		getDeleteContentGooruOid=gooruFlagId;
		
	}

	@Override
	public Image getCloseButton() {
		return popUpCloseButton;
	}

	@Override
	public HTMLEventPanel getSubmitButton() {
		return collectionSubmitButton;
	}
	
	private class CloseFlagPopupEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			if(flagThankYouPopUpView!=null){
				flagThankYouPopUpView.hide();
			}
			hide();
			hideResourceFlagPopup();
		}
	}
	public void hideResourceFlagPopup(){
		clearAll();
		String viewToken=AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
		String collectionId=AppClientFactory.getPlaceManager().getRequestParameter("id", null);
		String viewParam=AppClientFactory.getPlaceManager().getRequestParameter("view", null);

		Map<String,String> params = new LinkedHashMap<String,String>();
		params.put("id", collectionId);
		params = PreviewPlayerPresenter.setConceptPlayerParameters(params);
		if(viewParam != null)
		{
			params.put("view", viewParam);
		}
		PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(viewToken, params);
		AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
	}
	private class FlagPopupPanel extends PopupPanel{
		public FlagPopupPanel(boolean isAutoHide){
			super(isAutoHide);
			this.setGlassEnabled(true);
			this.setStyleName("");
			this.getGlassElement().getStyle().setZIndex(99999);
			this.getElement().getStyle().setZIndex(99999);
		}
	}
	
	
}
