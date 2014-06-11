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
package org.ednovo.gooru.client.mvp.shelf.collection;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.uc.BlueButtonUc;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

public abstract class CollectionShareAlertPopup extends PopupPanel implements MessageProperties{

	@UiField Label shareMsgTitle, shareMsgTxt, shareMsgLbl, privateResourceLbl;
	
	@UiField HTMLPanel shareAlertPopup, buttonContainer, privateResourcePanel, alertSuccessTitleTxt, alertSuccessTxt, alertBodyStyle;

	@UiField BlueButtonUc okButton, goBackBtn;
	
	@UiField ScrollPanel resourceHeaderPanel;
	
	@UiField Image gooruPublicShare;
	
	private boolean isPrivateResource = false;
	
	private static CollectionShareAlertPopupUiBinder uiBinder = GWT
			.create(CollectionShareAlertPopupUiBinder.class);

	interface CollectionShareAlertPopupUiBinder extends
			UiBinder<Widget, CollectionShareAlertPopup> {
	}

	public CollectionShareAlertPopup() {
		setWidget(uiBinder.createAndBindUi(this));
//		gooruPublicShare.setUrl("images/gooru-public-share-popup.png");
		privateResourceLbl.setText(GL0840);
//		goBackBtn.setText(GL0841);
		goBackBtn.setText(GL1923);
//		okButton.setText(GL0190);
		okButton.setText(GL1922);
		okButton.getElement().setId("btnOk");
		goBackBtn.getElement().setId("btnGoBack");
	}

	@UiHandler("okButton")
	public void onClickOkBtn(ClickEvent clickEvent) {
		Window.enableScrolling(true);
		this.hide();
		if(isPrivateResource) {
			setPublicFromAlert();
		}
	}
	
	@UiHandler("goBackBtn")
	public void onClickGoBackBtn(ClickEvent clickEvent) {
		Window.enableScrolling(true);
		this.hide();
	}
	
	public void setPublicMsgData(CollectionDo collection) {
		isPrivateResource = false;
		for(int i = 0; i < collection.getCollectionItems().size(); i++) {
			if(collection.getCollectionItems().get(i).getResource().getSharing().equalsIgnoreCase("private")) {
				isPrivateResource = true;
				privateResourcePanel.add(new CollectionSharePrivateResource(collection.getCollectionItems().get(i)));
			}
		}
		if(isPrivateResource) {
			setVisibilityData(false, false);
			shareMsgTitle.setText(GL0363);
			shareMsgTxt.setText(GL0364);
			shareMsgLbl.setText(GL0365);
			alertSuccessTitleTxt.setVisible(true);
		} else {
			setPublicMsgData();
//			setPublicFromAlert();
		}
	}
	
	public void setPublicMsgData() {
		isPrivateResource = true;
		setVisibilityData(true, true);
//		shareMsgTitle.setText(GL0362 + GL0329 +GL0686);
		shareMsgTitle.setText(GL1921);
		shareMsgTxt.getElement().getStyle().setFontSize(12, Unit.PX);
		shareMsgTxt.getElement().getStyle().setFontWeight(FontWeight.NORMAL);
		shareMsgTxt.setText(GL1919);
		shareMsgLbl.setText(GL1920 + GL1918);
		gooruPublicShare.setVisible(true);
		alertSuccessTxt.setVisible(true);
		alertSuccessTitleTxt.setVisible(true);
		okButton.setText(GL1922);
		goBackBtn.setVisible(true);
	}
	
	public void setPrivateMsgData() {
		setVisibilityData(true, false);
		shareMsgTitle.setText(GL0362 + GL0700);
		shareMsgTxt.setText(GL0688 + GL0687 + GL0333 +GL0686);
		shareMsgLbl.setText(GL0366);
		okButton.setText(GL0190);
		goBackBtn.setVisible(false);
	}

	public void setShareableMsgData() {
		setVisibilityData(true, false);
		shareMsgTitle.setText(GL0362 + GL0701);
		shareMsgTxt.setText(GL0689 + GL0687 + GL0331 + GL0686);
		shareMsgLbl.setText(GL0367);
		okButton.setText(GL0190);
		goBackBtn.setVisible(false);
	}
	
	public void setVisibilityData(boolean isVisible, boolean isPublicResource) {
		if(isVisible==true) {
			shareAlertPopup.setWidth("350px");
		} else {
			shareAlertPopup.setWidth("450px");
		}
		if(isPublicResource==true) {
			setPopupMargins(true);
			shareAlertPopup.setWidth("500px");
		} else {
			setPopupMargins(false);
		}
		gooruPublicShare.setVisible(false);
		alertSuccessTxt.setVisible(true);
		privateResourceLbl.setVisible(!isVisible);
		resourceHeaderPanel.setVisible(!isVisible);
		alertSuccessTitleTxt.setVisible(isVisible);
//		goBackBtn.setVisible(isVisible);
		showPopup();
	}
	
	private void setPopupMargins(boolean isZero) {
		if(isZero==true) {
			alertBodyStyle.getElement().getStyle().setMargin(0, Unit.PX);
			alertBodyStyle.getElement().getStyle().setPadding(0, Unit.PX);
		} else {
			alertBodyStyle.getElement().getStyle().setMargin(4, Unit.PX);
			alertBodyStyle.getElement().getStyle().setMarginTop(-4, Unit.PX);
			alertBodyStyle.getElement().getStyle().setPaddingTop(50, Unit.PX);
			alertBodyStyle.getElement().getStyle().setPaddingRight(30, Unit.PX);
			alertBodyStyle.getElement().getStyle().setPaddingBottom(15, Unit.PX);
			alertBodyStyle.getElement().getStyle().setPaddingLeft(30, Unit.PX);
		}
	}
	
	public void showPopup() {
		this.setGlassEnabled(true);
        Window.enableScrolling(false);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, false));
        if(isPrivateResource) {
    		int top = Window.getClientHeight();
        	int left = Window.getClientWidth();
        	left = (left - 450)/2;
        	top = ((top - 400)/2)+Window.getScrollTop();
        	this.setPopupPosition(left, top);
        } else {
        	this.center();
        }
        this.show();
        
	}
	
	public abstract void setPublicFromAlert();

}
