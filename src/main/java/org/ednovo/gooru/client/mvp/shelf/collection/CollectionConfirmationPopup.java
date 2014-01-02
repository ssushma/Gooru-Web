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
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * 
 * @fileName : CollectionConfirmationPopup.java
 *
 * @description : This file is related to Collection Confirmation Popup.
 *
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public  class CollectionConfirmationPopup extends PopupPanel implements MessageProperties{

	@UiField Label shareMsgTitle, shareMsgTxt, shareMsgLbl, closeButton,classPageNames;
	

	@UiField BlueButtonUc okButton, goBackBtn;
	
	
	
	private static CollectionConfirmationPopupUiBinder uiBinder = GWT
			.create(CollectionConfirmationPopupUiBinder.class);

	interface CollectionConfirmationPopupUiBinder extends
			UiBinder<Widget, CollectionConfirmationPopup> {
	}
	/**
	 * Class Constructor.
	 */
	public CollectionConfirmationPopup() {
		setWidget(uiBinder.createAndBindUi(this));
		
		shareMsgTitle.setText("This collection is in use!");
		shareMsgTxt.setText("This collection is currently being used in the ");
		shareMsgLbl.setText("If you would like to make this collection private, the collection will be removed and no longer be available in the classpage(s).");
		okButton.getElement().getStyle().setMarginLeft(7, Unit.PX);
		goBackBtn.getElement().setId("btnGoBack");
		okButton.getElement().setId("btnOk");
		this.setGlassEnabled(true);
		
        /*this.setPopupPositionAndShow(new PopupPanel.PositionCallback() {

            public void setPosition(int offsetWidth, int offsetHeight) {
                int left = (Window.getClientWidth() - offsetWidth) / 3;
                int top = (Window.getClientHeight() - offsetHeight) / 3;
                left=left+250;
                top=top+40;
                setPopupPosition(left, top);
            }
        });*/
		this.center();
        this.show();
        
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, false));
	}
	/**
	 * 
	 * @function onClickCloseBtn 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This UIHandler is used to close the popup.
	 * 
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("closeButton")
	public void onClickCloseBtn(ClickEvent clickEvent) {
		Window.enableScrolling(true);
		this.hide();
	}
	/**
	 * 
	 * @function onClickGoBackBtn 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This is used to close the popup.
	 * 
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("goBackBtn")
	public void onClickGoBackBtn(ClickEvent clickEvent) {
		Window.enableScrolling(true);
		this.hide();
	}
	/**
	 * return OkButton 
	 */
	public BlueButtonUc getOkButtonMethod(){
		return okButton;
	}
	/**
	 * return classPageNames Label
	 */
	public Label getClassPageNames(){
		return classPageNames;
	}
	

}
