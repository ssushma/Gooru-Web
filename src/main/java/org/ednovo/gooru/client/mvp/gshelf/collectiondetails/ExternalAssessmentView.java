package org.ednovo.gooru.client.mvp.gshelf.collectiondetails;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.folder.CreateDo;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.client.util.SetStyleForProfanity;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ExternalAssessmentView extends BaseViewWithHandlers<ExternalAssessmentInfoUiHandlers> implements IsExternalAssessmentView {

	private static ExternalAssessmentViewUiBinder uiBinder = GWT
			.create(ExternalAssessmentViewUiBinder.class);

	interface ExternalAssessmentViewUiBinder extends
			UiBinder<Widget, ExternalAssessmentView> {
	}

	static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	@UiField HTMLPanel pnlExternalAssessmentContainter,pnlPublic,pnlSharable,pnlPrivate;
	@UiField Label lblRequiresYes,lblRequiresNo,lblErrorMessage,lblErrorMessageForURL,lblErrorMessageForDesc;
	@UiField Button btnSaveExternalAssessment;
	@UiField TextBox txtAssessmentTitle,txtAssessmentURL;
	@UiField TextArea txaAssessmentDescription;
	
	final String SELECTEDSTYLE="setSelected",ASSESSMENTURL="assessment/url";
	final String PUBLIC="public",PRIVATE="private",ANYONEWITHLINK="anyonewithlink";
	
	String selectedSharing,isLoginRequired;
	
	FolderDo folderObj;
	
	public ExternalAssessmentView() {
		setWidget(uiBinder.createAndBindUi(this));
		pnlExternalAssessmentContainter.getElement().setId("pnlExternalAssessmentContainter");
		pnlPublic.addDomHandler(new PanelClickHandler(0,true), ClickEvent.getType());
		pnlSharable.addDomHandler(new PanelClickHandler(1,true), ClickEvent.getType());
		pnlPrivate.addDomHandler(new PanelClickHandler(2,true), ClickEvent.getType());
		lblRequiresYes.addClickHandler(new PanelClickHandler(0, false));
		lblRequiresNo.addClickHandler(new PanelClickHandler(1, false));
		txtAssessmentTitle.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				SetStyleForProfanity.SetStyleForProfanityForTextBox(txtAssessmentTitle, lblErrorMessage, false);
			}
		});
		txtAssessmentURL.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				SetStyleForProfanity.SetStyleForProfanityForTextBox(txtAssessmentURL, lblErrorMessageForURL, false);
			}
		});
		txaAssessmentDescription.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				SetStyleForProfanity.SetStyleForProfanityForTextArea(txaAssessmentDescription, lblErrorMessageForDesc, false);
			}
		});
	}
	/**
	 * This inner class will handle the click event on the radio buttons of Privacy and Requires login
	 */
	class PanelClickHandler implements ClickHandler{
		int index;
		boolean isPrivacy;
		PanelClickHandler(int index,boolean isPrivacy){
			this.index=index;
			this.isPrivacy=isPrivacy;
		}
		@Override
		public void onClick(ClickEvent event) {
			removeSelectedStyle(isPrivacy);
			if(isPrivacy){
				if(index==0){
					pnlPublic.addStyleName(SELECTEDSTYLE);
					selectedSharing=PUBLIC;
				}else if(index==1){
					pnlSharable.addStyleName(SELECTEDSTYLE);
					selectedSharing=ANYONEWITHLINK;
				}else if(index==2){
					pnlPrivate.addStyleName(SELECTEDSTYLE);
					selectedSharing=PRIVATE;
				}
			}else{
				if(index==0){
					lblRequiresYes.addStyleName(SELECTEDSTYLE);
					isLoginRequired="yes";
				}else if(index==1){
					lblRequiresNo.addStyleName(SELECTEDSTYLE);
					isLoginRequired="no";
				}
			}
		}
	}
	/**
	 * This method is used to remove previously selected styles
	 */
	private void removeSelectedStyle(boolean isPrivacy) {
		if(isPrivacy){
			pnlPublic.removeStyleName(SELECTEDSTYLE);
			pnlSharable.removeStyleName(SELECTEDSTYLE);
			pnlPrivate.removeStyleName(SELECTEDSTYLE);
		}else{
			lblRequiresYes.removeStyleName(SELECTEDSTYLE);
			lblRequiresNo.removeStyleName(SELECTEDSTYLE);
		}
	}
	
	@UiHandler("btnSaveExternalAssessment")
	public void clickEventOfSave(ClickEvent event){
		String assessmentExistingTitle=txtAssessmentTitle.getText();
		String assessmentURL=txtAssessmentURL.getText();
		if(StringUtil.isEmpty(assessmentExistingTitle)){
			lblErrorMessage.setVisible(true);
			lblErrorMessage.setText(i18n.GL1026());
		}else if(StringUtil.isEmpty(assessmentURL)){
			lblErrorMessage.setVisible(false);
			lblErrorMessage.setText("");
			lblErrorMessageForURL.setVisible(true);
			lblErrorMessageForURL.setText(i18n.GL3166());
		}else{
			assessmentURL = URL.encode(assessmentURL);
			if(StringUtil.checkUrlContainesGooruUrl(assessmentURL)){
				lblErrorMessage.setVisible(false);
				lblErrorMessage.setText("");
				lblErrorMessageForURL.setVisible(true);
				lblErrorMessageForURL.setText(i18n.GL0924());
				return;
			}else{
				boolean isStartWithHttp = assessmentURL.matches("^(http|https)://.*$");
				if (!isStartWithHttp) {
					assessmentURL = "http://" + assessmentURL;
					txtAssessmentURL.setText(assessmentURL);
					StringUtil.setAttributes(txtAssessmentURL.getElement(), assessmentURL, assessmentURL);
				}
			}
			if(!StringUtil.isValidUrl(assessmentURL, true)){
				lblErrorMessage.setVisible(false);
				lblErrorMessage.setText("");
				lblErrorMessageForURL.setVisible(true);
				lblErrorMessageForURL.setText(i18n.GL0926());
			}else{
				getUiHandlers().checkProfanity(txtAssessmentTitle.getText().trim(),true,0);
			}
		}
	}

	@Override
	public void callCreateAndUpdate(boolean isCreate, boolean result, int index) {
		if(result && index==0){
			SetStyleForProfanity.SetStyleForProfanityForTextBox(txtAssessmentTitle, lblErrorMessage, result);
		}else if(result && index==1){
			SetStyleForProfanity.SetStyleForProfanityForTextBox(txtAssessmentURL, lblErrorMessageForURL, result);
		}else if(result && index==2){
			SetStyleForProfanity.SetStyleForProfanityForTextArea(txaAssessmentDescription, lblErrorMessageForDesc, result);
		}else{
			if(index==0){
				getUiHandlers().checkProfanity(txtAssessmentURL.getText().trim(),isCreate,1);
			}else if(index==1){
				getUiHandlers().checkProfanity(txaAssessmentDescription.getText().trim(),isCreate,2);
			}else if(index==2){
				CreateDo createOrUpDate=new CreateDo();
				createOrUpDate.setTitle(txtAssessmentTitle.getText());
				createOrUpDate.setUrl(txtAssessmentURL.getText());
				createOrUpDate.setGoals(txaAssessmentDescription.getText());
				createOrUpDate.setCollectionType(ASSESSMENTURL);
				createOrUpDate.setSharing(selectedSharing);
				createOrUpDate.setIsLoginRequired(isLoginRequired);
				String id= AppClientFactory.getPlaceManager().getRequestParameter("id",null);
				if(id!=null){
					getUiHandlers().updateAssessmentDetails(createOrUpDate,id,isCreate,folderObj);
				}else{
					getUiHandlers().createAndSaveAssessmentDetails(createOrUpDate,isCreate);
				}
			}
		}
	}

	@Override
	public void setData(FolderDo folderObj) {
		if(folderObj!=null){
			this.folderObj = folderObj;
			txtAssessmentTitle.setText(folderObj.getTitle());
			txtAssessmentURL.setText(folderObj.getUrl());
			txaAssessmentDescription.setText(folderObj.getGoals());
			String sharingVal=folderObj.getSharing();
			if(sharingVal!=null){
				if(PUBLIC.equalsIgnoreCase(sharingVal)){
					pnlPublic.addStyleName(SELECTEDSTYLE);
				}else if(ANYONEWITHLINK.equalsIgnoreCase(sharingVal)){
					pnlSharable.addStyleName(SELECTEDSTYLE);
				}else if(PRIVATE.equalsIgnoreCase(sharingVal)){
					pnlPrivate.addStyleName(SELECTEDSTYLE);
				}
			}
		}else{
			txtAssessmentTitle.setText("UntitledExternalAssessment");
			txtAssessmentURL.setText("Paste URL here");
			pnlSharable.addStyleName(SELECTEDSTYLE);
			lblRequiresNo.addStyleName(SELECTEDSTYLE);
		}
		
	}
}
