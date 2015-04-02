package org.ednovo.gooru.client.mvp.classpages.classlist;

import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class InviteStudentsPopup extends PopupPanel {

	private static final String AT_SYMBOL = "@";

	private static InviteStudentsPopupUiBinder uiBinder = GWT.create(InviteStudentsPopupUiBinder.class);
	
	 MessageProperties i18n = GWT.create(MessageProperties.class);

	interface InviteStudentsPopupUiBinder extends
	UiBinder<Widget, InviteStudentsPopup> {
	}

	@UiField Button cancelBtn,inviteBtn;

	@UiField TextArea emailTextArea;

	@UiField Label emailValidationLbl;
	
	@UiField HTMLPanel titlePanel,headerPanel;

	private boolean isvalid;


	public InviteStudentsPopup() {
		setWidget(uiBinder.createAndBindUi(this));
		setPixelSize(456,224);
		setStaticText();
		emailTextArea.getElement().setAttribute("placeholder", "Separate email addresses with a comma or semicolon");
		emailValidationLbl.setVisible(false);
		setGlassEnabled(true);
		center();
		show();
		Window.enableScrolling(false);
	}

	private void setStaticText() {
		headerPanel.getElement().setInnerHTML(i18n.GL1522());
		headerPanel.getElement().setId("pnlHeader");
		headerPanel.getElement().setAttribute("alt",i18n.GL1522());
		headerPanel.getElement().setAttribute("title",i18n.GL1522());
		
		titlePanel.getElement().setInnerHTML(i18n.GL1521());
		titlePanel.getElement().setId("pnlTitle");
		titlePanel.getElement().setAttribute("alt",i18n.GL1521());
		titlePanel.getElement().setAttribute("title",i18n.GL1521());
		
		emailTextArea.getElement().setId("tatEmail");
		StringUtil.setAttributes(emailTextArea, true);
		emailValidationLbl.getElement().setId("errlblEmailValidation");
		
		cancelBtn.setText(i18n.GL0142());
		cancelBtn.getElement().setId("btnCancel");
		cancelBtn.getElement().setAttribute("alt",i18n.GL0142());
		cancelBtn.getElement().setAttribute("title",i18n.GL0142());
		
		inviteBtn.setText(i18n.GL0944());
		inviteBtn.getElement().setId("btnInvite");
		inviteBtn.getElement().setAttribute("alt",i18n.GL0944());
		inviteBtn.getElement().setAttribute("title",i18n.GL0944());
	}

	@UiHandler("cancelBtn")
	public void clickCancelBtn(ClickEvent clickEvent){
		hide();
		Window.enableScrolling(true);
	}

	@UiHandler("inviteBtn")
	public void inviteStudentsMtd(ClickEvent clickEvent){
		isvalid=true;
		if(!emailTextArea.getText().trim().equals("")){
			String EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
			String strEmails = emailTextArea.getText().trim();
			String emailIds[] = strEmails.split("\\s*,\\s*");
			if (strEmails.contains(",")){
				emailIds = strEmails.split("\\s*,\\s*");
			}else if (strEmails.contains(";")){
				emailIds = strEmails.split("\\s*;\\s*");
			}

			for (int i=0; i<emailIds.length; i++){
				boolean to = emailIds[i].matches(EMAIL_REGEX);
				if(to){
					isvalid = true;
				}else{
					emailValidationLbl.setText(StringUtil.generateMessage(i18n.GL1019(), emailIds[i]));
					emailValidationLbl.getElement().setAttribute("alt",StringUtil.generateMessage(i18n.GL1019(), emailIds[i]));
					emailValidationLbl.getElement().setAttribute("title",StringUtil.generateMessage(i18n.GL1019(), emailIds[i]));
					emailValidationLbl.setVisible(true);
					isvalid = false;
					break;
				}
			}
		}
		if ((emailTextArea.getText() != null && !emailTextArea.getText().isEmpty())
				&& !emailTextArea.getText().contains(AT_SYMBOL)) {
			emailValidationLbl.setText(i18n.GL1027());
			emailValidationLbl.getElement().setAttribute("alt",i18n.GL1027());
			emailValidationLbl.getElement().setAttribute("title",i18n.GL1027());
			emailValidationLbl.setVisible(true);
			isvalid = false;

		}
		if (emailTextArea.getText().equals("") || emailTextArea.getText().trim().equals("")) {
			emailValidationLbl.setText(i18n.GL0216_1());
			emailValidationLbl.getElement().setAttribute("alt",i18n.GL0216_1());
			emailValidationLbl.getElement().setAttribute("title",i18n.GL0216_1());
			emailValidationLbl.setVisible(true);
			isvalid = false;
		}

		if(isvalid){
			Window.enableScrolling(true);
			hide();
		}

	}


}
