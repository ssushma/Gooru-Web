
package org.ednovo.gooru.client.util;

import org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle;
import org.ednovo.gooru.client.ui.TinyMCE;
import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

/**
 * @fileName : SetStyleForProfanity.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 21-Jan-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class SetStyleForProfanity {
	
    static MessageProperties i18n = GWT.create(MessageProperties.class); 
	
	public static void SetStyleForProfanityForTextBox(TextBox textbox,Label errorlabel,boolean value) {
		CollectionCBundle.INSTANCE.css().ensureInjected();
		if (value){
			textbox.getElement().setAttribute("style", "border-color:#fab03a !important");	
			errorlabel.setText(i18n.GL0554());
			errorlabel.setVisible(true);
			errorlabel.setStyleName(CollectionCBundle.INSTANCE.css().mandatoryLabelError());
		}else{
			textbox.getElement().getStyle().clearBackgroundColor();
//			textbox.getElement().getStyle().setBorderColor("#ccc");
			textbox.getElement().setAttribute("style", "border-color:#ccc");
			errorlabel.setVisible(false);
		}
	}
	public static void SetStyleForProfanityForTextArea(TextArea textArea,Label errorlabel,boolean value) {
		CollectionCBundle.INSTANCE.css().ensureInjected();
		if (value){
			textArea.getElement().getStyle().setBorderColor("orange");
			errorlabel.setText(i18n.GL0554());
			errorlabel.setVisible(true);
			errorlabel.setStyleName(CollectionCBundle.INSTANCE.css().mandatoryLabelError());
		}else{
			textArea.getElement().getStyle().clearBackgroundColor();
			textArea.getElement().getStyle().setBorderColor("#ccc");
			errorlabel.setVisible(false);
		}
	}
	public static void SetStyleForProfanityForRichTextArea(RichTextArea richTextArea,Label errorlabel,boolean value) {
		CollectionCBundle.INSTANCE.css().ensureInjected();
		if (value){
			richTextArea.getElement().getStyle().setBorderColor("orange");
			errorlabel.setText(i18n.GL0554());
			errorlabel.setVisible(true);
			errorlabel.setStyleName(CollectionCBundle.INSTANCE.css().mandatoryLabelError());
		}else{
			richTextArea.getElement().getStyle().clearBackgroundColor();
			richTextArea.getElement().getStyle().setBorderColor("#ccc");
			errorlabel.setVisible(false);
		}
	}
	public static void SetStyleForProfanityForSearchRenameCollTextBox(TextBox copycollectionTextbox, Label errorLabel,boolean isHavingBadWords) {
		CollectionCBundle.INSTANCE.css().ensureInjected();
		if (isHavingBadWords){
			copycollectionTextbox.getElement().getStyle().setBorderColor("orange");
			errorLabel.setText(i18n.GL0554());
			errorLabel.setVisible(true);
			errorLabel.setStyleName(CollectionCBundle.INSTANCE.css().searchRenameCollProfanityErrLbl());
		}else{
			copycollectionTextbox.getElement().getStyle().clearBackgroundColor();
			copycollectionTextbox.getElement().getStyle().setBorderColor("#ccc");
			errorLabel.setVisible(false);
		}
	}
	public static void SetStyleForProfanityForTinyMCE(TinyMCE tinyMCE,Label errorlabel,boolean value) {
		CollectionCBundle.INSTANCE.css().ensureInjected();
		if (value){
			tinyMCE.getElement().getStyle().setBorderColor("orange");
			errorlabel.setText(i18n.GL0554());
			errorlabel.setVisible(true);
			errorlabel.setStyleName(CollectionCBundle.INSTANCE.css().mandatoryLabelError());
		}else{
			tinyMCE.getElement().getStyle().clearBackgroundColor();
			tinyMCE.getElement().getStyle().setBorderColor("#ccc");
			errorlabel.setVisible(false);
		}
	}
}
