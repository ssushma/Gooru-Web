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
package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.uc.BlueButtonUc;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public abstract class WebResourcePreview extends PopupPanel implements MessageProperties {
	
	@UiField BlueButtonUc okButton, goBackBtn;
	
	
	@UiField Label descriptionTxtValueLbl,descriptionTxtLbl,filePathValueLbl,resourceTitleValueLbl,categoryValueLbl,thumbnailLbl,previewCloseButton;
	
	@UiField
	public Image setThumbnailImage;
	
	@UiField HTMLPanel actionPanel,areYouSureText;
	
	@UiField Label lblConfirmAdding,messageText,titleText,categoryText;
	
	private static WebResourcePreviewUiBinder uiBinder = GWT.create(WebResourcePreviewUiBinder.class);

	interface WebResourcePreviewUiBinder extends UiBinder<Widget, WebResourcePreview> {
	}
	
	
	public WebResourcePreview() {
		setWidget(uiBinder.createAndBindUi(this));
		
		lblConfirmAdding.getElement().getStyle().setDisplay(Display.NONE);
		actionPanel.getElement().getStyle().setDisplay(Display.BLOCK);
		setGlassEnabled(true);
		areYouSureText.getElement().setInnerHTML(GL0363);
		messageText.setText(GL0930);
		titleText.setText(GL0318);
		descriptionTxtLbl.setText(GL0904);
		categoryText.setText(GL0906);
		thumbnailLbl.setText(GL0911);
		goBackBtn.setText(GL0841);
		okButton.setText(GL_GRR_YES);
		lblConfirmAdding.setText(GL0591.toLowerCase());
		setWidth("508px");
		setHeight("481px");
		center();
	}
	
	
	
	@UiHandler("previewCloseButton")
	public void onClickClosePreviewBtn(ClickEvent event){
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		hide();
		closeAppPopUp();
	}
	
	@UiHandler("goBackBtn")
	public void hidePop(ClickEvent event){
		showAddResourcePopup();
	}
	
	
	@UiHandler("okButton")
	public void onAddResourceClick(ClickEvent event){
		MixpanelUtil.mixpanelEvent("Collaborator_edits_collection");
		addWebResource();
	}
	
	public abstract void showAddResourcePopup(); 
	public abstract void addWebResource(); 
	public abstract void closeAppPopUp();
	
	
	
	
	/** 
	 * This method is to get the actionPanel
	 */
	public HTMLPanel getActionPanel() {
		return actionPanel;
	}

	/** 
	 * This method is to set the actionPanel
	 */
	public void setActionPanel(HTMLPanel actionPanel) {
		this.actionPanel = actionPanel;
	}

	/** 
	 * This method is to get the lblAdding
	 */
	public Label getLblAdding() {
		return lblConfirmAdding;
	}

	/** 
	 * This method is to set the lblAdding
	 */
	public void setLblAdding(Label lblAdding) {
		this.lblConfirmAdding = lblAdding;
	}	
}
