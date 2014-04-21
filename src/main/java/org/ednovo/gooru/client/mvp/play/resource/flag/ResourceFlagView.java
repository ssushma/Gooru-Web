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
package org.ednovo.gooru.client.mvp.play.resource.flag;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.play.collection.flag.FlagThankYouPopUpView;
import org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.ContentReportDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class ResourceFlagView extends PopupViewWithUiHandlers<ResourceFlagUiHandler> implements IsResourceFlag,MessageProperties {

	private static FlaggingPopUpUiBinder uiBinder = GWT
			.create(FlaggingPopUpUiBinder.class);

	interface FlaggingPopUpUiBinder extends
			UiBinder<Widget, ResourceFlagView> {
	}

	@UiField HTMLEventPanel closeButton;
	@UiField Button cancelButton,submitButton,submitButtonGray;
	@UiField TextArea descriptionTextArea;
	@UiField CheckBox checkBox1,checkBox2,checkBox3,checkBox4;
	@UiField HTML titleText;
	@UiField Label flagText,inappropriateText,unavailableText,inaccurateText,otherReasonText,provideMoreText;
	private FlagThankYouPopUpView thankYouToolTip=null;
	int formateSize=0;
	
	ArrayList<String> contentReportList=new ArrayList<String>();
	
	
	public PopupPanel appPopUp;
	private String resourceTitle;
    private String resourceGooruId;
	private String deleteContentReportGooruOids="";
	
	@Inject
	public ResourceFlagView(EventBus eventBus) {
		super(eventBus);
		appPopUp = new FlagPopupPanel(false);
		appPopUp.setWidget(uiBinder.createAndBindUi(this));
		cancelButton.setText(GL0608);
		submitButton.setText(GL0486);
		submitButtonGray.setText(GL0486);
		cancelButton.getElement().setAttribute("id", "cancelButton");
		submitButton.getElement().setAttribute("id", "SubmitButton");
		submitButtonGray.setVisible(true);
		submitButton.setVisible(false);
		flagText.setText(GL0600);
		inappropriateText.setText(GL0612);
		inaccurateText.setText(GL0614);
		unavailableText.setText(GL0613);
		otherReasonText.setText(GL0606);
		provideMoreText.setText(GL0607);
		closeButton.addClickHandler(new CloseFlagPopupEvent());
	}
	@UiHandler("cancelButton")
	public void onClickOfCancelButton(ClickEvent event){
		resetFlagData();
	}
	@UiHandler("checkBox1")
	public void onClickOfcheckBox1(ClickEvent event)
	{
	if(checkBox1.isChecked()||checkBox2.isChecked()||checkBox3.isChecked()||checkBox4.isChecked())
		{
			submitButtonGray.setVisible(false);
			submitButton.setVisible(true);
		}
		else
		{
			submitButtonGray.setVisible(true);
			submitButton.setVisible(false);
		}
		
	}
	@UiHandler("checkBox2")
	public void onClickOfcheckBox2(ClickEvent event)
	{
		if(checkBox2.isChecked()||checkBox3.isChecked()||checkBox4.isChecked()||checkBox1.isChecked()){
			submitButtonGray.setVisible(false);
			submitButton.setVisible(true);
		}
		else{
			submitButtonGray.setVisible(true);
			submitButton.setVisible(false);
		}
		
	}
	@UiHandler("checkBox3")
	public void onClickOfcheckBox3(ClickEvent event)
	{
		if(checkBox3.isChecked()||checkBox4.isChecked()||checkBox2.isChecked()||checkBox1.isChecked()){
			submitButtonGray.setVisible(false);
			submitButton.setVisible(true);
		}
		else{
			submitButtonGray.setVisible(true);
			submitButton.setVisible(false);
		}
		
	}
	
	@UiHandler("checkBox4")
	public void onClickOfcheckBox4(ClickEvent event)
	{
		if(checkBox4.isChecked()||checkBox3.isChecked()||checkBox2.isChecked()||checkBox1.isChecked()){
			submitButtonGray.setVisible(false);
			submitButton.setVisible(true);
		}
		else{
			submitButtonGray.setVisible(true);
			submitButton.setVisible(false);
		}
	
	}
	
	@UiHandler("submitButton")
	public void onClicksubmitButton(ClickEvent event){
		if(checkBox1.isChecked())
		{
			contentReportList.add("missing-concept");
		}
		if(checkBox2.isChecked())
		{
			contentReportList.add("not-loading");
		}
		if(checkBox3.isChecked())
		{
			contentReportList.add("inappropriate");
		}
		if(checkBox4.isChecked())
		{
		
			contentReportList.add("other");
		}
		getUiHandlers().createReport(resourceGooruId, descriptionTextArea.getText(), contentReportList, deleteContentReportGooruOids);
		//getThankYouPopUp();
		//resetFlagData();
	}
	
	@Override
	public void showSuccessPopup() {
		resetFlagData();
		appPopUp.hide();
		thankYouToolTip=new FlagThankYouPopUpView();
		thankYouToolTip.getOkButton().addClickHandler(new CloseFlagPopupEvent());
		thankYouToolTip.getCloseButton().addClickHandler(new CloseFlagPopupEvent());
		thankYouToolTip.show();
		thankYouToolTip.center();
		submitButtonGray.setVisible(true);
		submitButton.setVisible(false);
		
	}
	public void getThankYouPopUp(){
		resetFlagData();
		appPopUp.hide();
		FlagThankYouPopUpView thankYouToolTip=new FlagThankYouPopUpView();
		thankYouToolTip.show();
		thankYouToolTip.center();
		submitButtonGray.setVisible(true);
		submitButton.setVisible(false);
	}
	@Override
	public Widget asWidget() {
		return appPopUp;
	}

	@Override
	public void setFlagView(CollectionItemDo collectionItemDo) {
		resourceTitle=collectionItemDo.getResourceTitle();
		resourceGooruId=collectionItemDo.getResource().getGooruOid();
		resourceTitle=resourceTitle.replaceAll("</p>", " ").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "");
		titleText.setHTML(GL1430 +resourceTitle+" \" "+GL1431+"");
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stubdd
		
	}

	@Override
	public void onLoad() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUnload() {
		// TODO Auto-generated method stub
		
	}
	public void resetFlagData(){
		checkBox1.setChecked(false);
		checkBox2.setChecked(false);
		checkBox3.setChecked(false);
		checkBox4.setChecked(false);
		descriptionTextArea.setText("");
		submitButtonGray.setVisible(true);
		submitButton.setVisible(false);
	}
	@Override
	public void getreportData(ContentReportDo contentReportDo,String gooruFlagId) {
		deleteContentReportGooruOids=gooruFlagId;	
	}
	@Override
	public HTMLEventPanel resourceCloseButton() {
		return closeButton;
	}
	@Override
	public Button getSubmitButton() {
		return submitButton;
	}
	
	private class CloseFlagPopupEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			if(thankYouToolTip!=null){
				thankYouToolTip.hide();
			}
			hide();
			hideResourceFlagPopup();
		}
	}
	public void hideResourceFlagPopup(){
		resetFlagData();
		String viewToken=AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
		String collectionId=AppClientFactory.getPlaceManager().getRequestParameter("id", null);
		String resourceId=AppClientFactory.getPlaceManager().getRequestParameter("rid", null);
		
		Map<String,String> params = new LinkedHashMap<String,String>();
		params.put("id", collectionId);
		params = PreviewPlayerPresenter.setConceptPlayerParameters(params);
		params.put("rid", resourceId);		
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
	@Override
	public void setContentDeleteIds(String gooruFlagId) {
		this.deleteContentReportGooruOids=gooruFlagId;
	}
	

}
