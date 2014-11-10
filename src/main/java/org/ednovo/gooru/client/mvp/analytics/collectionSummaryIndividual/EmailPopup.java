package org.ednovo.gooru.client.mvp.analytics.collectionSummaryIndividual;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class EmailPopup extends PopupPanel {
	private static EmailPopupUiBinder uiBinder = GWT
			.create(EmailPopupUiBinder.class);

	interface EmailPopupUiBinder extends UiBinder<Widget, EmailPopup> {
	}
	private static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	@UiField Button sendBtn,cancelBtn;
	@UiField Label emailErrorlbl,userNamelbl,displayPdfPathlbl;
	@UiField TextArea messageTextArea;
	@UiField TextBox subjectTxt,emailTextbox;
	@UiField CheckBox sendmecopy;
	boolean isValidate=true;
	String fileName,filePath;
	
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	CollectionSummaryIndividualCBundle res;
	
	public EmailPopup() {
		this.res = CollectionSummaryIndividualCBundle.INSTANCE;
		res.css().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));
		this.setGlassEnabled(true);
		this.setStyleName(res.css().setEmailGlassStyleName());
		this.setGlassStyleName(res.css().setEmailPopupCenter());
		this.center();
		this.hide();
		displayPdfPathlbl.setText("Adding Attachment....");
		sendBtn.setEnabled(false);
		emailTextbox.getElement().setAttribute("placeholder","Separate email addresses with a comma or semicolon");
		emailErrorlbl.setVisible(false);
	}
	public void setEmailData(String pdfName,String path){
		pdfName=pdfName.replaceAll(" ", "_");
		pdfName = pdfName + "_Collection_Summary.pdf";
		displayPdfPathlbl.setText(pdfName);
		fileName=pdfName;
		filePath=path;
		sendBtn.setEnabled(true);
	}
	public void setData(){
		userNamelbl.setText(AppClientFactory.getLoggedInUser().getUsernameDisplay());
	}
	@UiHandler("cancelBtn")
	public void onClickOfCancelButton(ClickEvent e){
		this.hide();
	}
	@UiHandler("sendBtn")
	public void onClickOfSendButton(ClickEvent e){
		isValidate=true;
		isValidate=checkValidataions();
		if(isValidate){
			String emailIds=emailTextbox.getText();
			if(sendmecopy.isChecked()){
				emailIds=emailIds+","+AppClientFactory.getLoggedInUser().getEmailId();
			}
			AppClientFactory.getInjector().getAnalyticsService().sendEmail(emailIds, subjectTxt.getText(), messageTextArea.getText(), userNamelbl.getText(), fileName, filePath, new AsyncCallback<Void>() {
				@Override
				public void onSuccess(Void result) {
				}
				@Override
				public void onFailure(Throwable caught) {
				}
			});
		}
	}
	boolean checkValidataions(){
		String emailIds=emailTextbox.getText().trim();
		if(emailIds.isEmpty()){
			isValidate=false;
			emailErrorlbl.setText(i18n.GL0216());
			emailErrorlbl.setVisible(true);
		}
		String[] getAllEmailAddress = emailIds.split(",");
		System.out.println(emailIds+"::"+getAllEmailAddress.length);
		for ( int i = 0; i < getAllEmailAddress.length; i++) {
			String getMailId = getAllEmailAddress[i].trim();
			boolean isEmail = validateEmail(getMailId);
			if (!isEmail) {
				
			}
		}
		return isValidate;
	}
	boolean validateEmail(String email) {
		 boolean result = email.matches(EMAIL_PATTERN);
		 System.out.println("result::"+result);
		 return result;
	}
}
