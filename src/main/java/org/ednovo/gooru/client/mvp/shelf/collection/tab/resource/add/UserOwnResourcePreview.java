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
/**
 * @fileName : UserOwnResourcePreview.java
 *
 * @description : This class is used to display user resource preview.
 *
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public abstract class UserOwnResourcePreview extends PopupPanel  {
	
	/*@UiField Label shareMsgTitle,descriptionTxt,filePathValueLbl,filePathLbl;
	
	@UiField HTMLPanel shareAlertPopup, buttonContainer,descriptionTxtContainer,filePathTxtContainer;

	@UiField BlueButtonUc okButton, goBackBtn;*/
	
	@UiField BlueButtonUc okButton, goBackBtn;
	
	
	@UiField Label descriptionTxtValueLbl,filePathValueLbl,resourceTitleValueLbl,categoryValueLbl,thumbnailLbl,previewCloseButton;
	
	@UiField
	public Image setThumbnailImage;
	
	@UiField HTMLPanel actionPanel;
	
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
	@UiField Label lblConfirmAdding;
	
	private static UserOwnResourcePreviewUiBinder uiBinder = GWT.create(UserOwnResourcePreviewUiBinder.class);

	interface UserOwnResourcePreviewUiBinder extends UiBinder<Widget, UserOwnResourcePreview> {
	}
	/**
	 * Class constructor.
	 */
	public UserOwnResourcePreview() {
		setWidget(uiBinder.createAndBindUi(this));
		
		lblConfirmAdding.getElement().getStyle().setDisplay(Display.NONE);
		actionPanel.getElement().getStyle().setDisplay(Display.BLOCK);
	}
	/**
	 * @function onClickClosePreviewBtn 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This will handle the click event on preview close button.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("previewCloseButton")
	public void onClickClosePreviewBtn(ClickEvent event){
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		hide();
		closeAppPopUp();
	}
	/**
	 * @function hidePop 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This will handle the click event on go back button.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("goBackBtn")
	public void hidePop(ClickEvent event){
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		showAddResourcePopup();
	}
	/**
	 * @function onAddResourceClick 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This will handle the click event on ok button.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("okButton")
	public void onAddResourceClick(ClickEvent event){
		addUserOwnResource();
	}

	public abstract void showAddResourcePopup(); 
	public abstract void addUserOwnResource(); 
	public abstract void closeAppPopUp();

}
