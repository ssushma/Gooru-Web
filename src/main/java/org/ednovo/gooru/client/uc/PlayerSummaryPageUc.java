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

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class PlayerSummaryPageUc extends PopupPanel{

	@UiField
	Button leaveBtn, stayBtn;
	@UiField Label alertMessageHeaderField,alertMessageField,alertMessageField1;
	@UiField FlowPanel contentPanel;
	
	private static PlayerSummaryPageUcUiBinder uiBinder = GWT
			.create(PlayerSummaryPageUcUiBinder.class);

	interface PlayerSummaryPageUcUiBinder extends
			UiBinder<Widget, PlayerSummaryPageUc> {
	}
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);

	public PlayerSummaryPageUc() {
		setWidget(uiBinder.createAndBindUi(this));
		CollectionCBundle.INSTANCE.css().ensureInjected();
		this.getElement().getStyle().setZIndex(999999);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, false));
		this.setGlassStyleName(CollectionCBundle.INSTANCE.css().playerSummaryPageGlassPanel());
		this.show();
		this.center();
		alertMessageHeaderField.setText(i18n.GL1037());
		alertMessageHeaderField.getElement().setId("lblAlertMessageHeaderField");
		alertMessageHeaderField.getElement().setAttribute("alt", i18n.GL1037());
		alertMessageHeaderField.getElement().setAttribute("title", i18n.GL1037());
		alertMessageField.setText(i18n.GL1038());
		alertMessageField.getElement().setId("lblAlertMessageField");
		alertMessageField.getElement().setAttribute("alt", i18n.GL1038());
		alertMessageField.getElement().setAttribute("title", i18n.GL1038());
		alertMessageField1.setText(i18n.GL1039());
		alertMessageField1.getElement().setId("lblAlertMessageField1");
		alertMessageField1.getElement().setAttribute("alt", i18n.GL1039());
		alertMessageField1.getElement().setAttribute("title",i18n.GL1039());
		contentPanel.getElement().setId("fpnlContentPanel");
		leaveBtn.setText(i18n.GL1040());
		leaveBtn.getElement().setId("btnLeaveBtn");
		leaveBtn.getElement().setAttribute("alt", i18n.GL1040());
		leaveBtn.getElement().setAttribute("title",i18n.GL1040());
		stayBtn.setText(i18n.GL1041());
		stayBtn.getElement().setId("btnStayBtn");
		stayBtn.getElement().setAttribute("alt", i18n.GL1041());
		stayBtn.getElement().setAttribute("title",i18n.GL1041());
	}

	public Button getLeaveButton() {
		return leaveBtn;
	}

	public Button getStayButton() {
		return stayBtn;
	}
	
	/*public void closePlayerSummaryPageUc() {
		this.hide();
	}*/
}
