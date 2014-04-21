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
package org.ednovo.gooru.client.uc;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public abstract class ContentConfirmationPopupVc  extends Composite implements MessageProperties{
	private AppPopUp appPopUp;

	@UiField
	Anchor cancelButton;

	@UiField
	BlueButtonUc okButton;

	@UiField 
	Label contentText;
	
	private static ContentConfirmationPopupVcUiBinder uiBinder = GWT.create(ContentConfirmationPopupVcUiBinder.class);

	interface ContentConfirmationPopupVcUiBinder extends UiBinder<Widget, ContentConfirmationPopupVc> {
	}
	
	public ContentConfirmationPopupVc(String messageHeader, String  messageContent) {
		initWidget(uiBinder.createAndBindUi(this));
		appPopUp = new AppPopUp();
		appPopUp.setStyleName("removeResourcePopup");
		appPopUp.setContent(messageHeader, uiBinder.createAndBindUi(this));
		contentText.setText(messageContent);
		appPopUp.getElement().getStyle().setZIndex(9999);
		appPopUp.show();
		appPopUp.center();
		okButton.setText(GL0190);
		cancelButton.setText(GL0142);
		okButton.getElement().setId("btnOk");
		cancelButton.getElement().setId("lnkCancel");
	}

	@UiHandler("cancelButton")
	public void onCancelClick(ClickEvent clickEvent) {
		hide();

		Window.enableScrolling(true);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));

	}
	
	public void hide() {
		appPopUp.hide();

		Window.enableScrolling(true);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));

	}
	
	public void setGlassZindex(int index){
		if(appPopUp!=null){
			appPopUp.setGlassZindex(index);
		}
	}
	public void setPopupZindex(int index){
		if(appPopUp!=null){
			appPopUp.setPopupZindex(index);
		}
	}

	@UiHandler("okButton")
	public abstract void onConform(ClickEvent clickEvent);
	

}
