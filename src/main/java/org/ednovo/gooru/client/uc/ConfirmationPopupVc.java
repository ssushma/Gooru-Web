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

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : ConfirmationPopupVc.java
 *
 * @description : This class is used to display the confirmation popup view.
 *
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public abstract class ConfirmationPopupVc extends Composite {

	private AppPopUp appPopUp;
	private boolean isEditQuestion=false;
	@UiField
	Anchor cancelButton;

	@UiField
	BlueButtonUc okButton;

	@UiField 
	Label contentText,loadingTextLbl;
	
	@UiField
	FlowPanel buttonContainer;
	
	private static RemoveResourcePopupVcUiBinder uiBinder = GWT.create(RemoveResourcePopupVcUiBinder.class);

	interface RemoveResourcePopupVcUiBinder extends UiBinder<Widget, ConfirmationPopupVc> {
	}

	/**
	 * Class constructor
	 * @param messageHeader header for popup
	 * @param messageContent for popup
	 */
	public ConfirmationPopupVc(String messageHeader, String  messageContent) {
		initWidget(uiBinder.createAndBindUi(this));
		appPopUp = new AppPopUp();
		appPopUp.setStyleName("removeResourcePopup");
		appPopUp.setContent(messageHeader, uiBinder.createAndBindUi(this));
		contentText.setText(messageContent);
		appPopUp.show();
		appPopUp.center();
		okButton.getElement().setId("btnOk");
		cancelButton.getElement().setId("lnkCancel");
		loadingTextLbl.setVisible(false);
        buttonContainer.setVisible(true);
	}
	/**
	 * @function onCancelClick 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This will handle the click event on the cancel button.
	 * 
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("cancelButton")
	public void onCancelClick(ClickEvent clickEvent) {
		hide();
        if(isEditQuestion){
        	Window.enableScrolling(false);
        }else{
        	Window.enableScrolling(true);
	        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
        }
	}
	/**
	 * @function hide 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is used to hide the popup.
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void hide() {
		appPopUp.hide();
		if(isEditQuestion){
        	Window.enableScrolling(false);
        }else{
        	Window.enableScrolling(true);
            AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
        }
		

	}
	/**
	 * @function setGlassZindex 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is used to set the z- index.
	 * 
	 * 
	 * @parm(s) : @param index
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setGlassZindex(int index){
		if(appPopUp!=null){
			appPopUp.setGlassZindex(index);
		}
	}
	/**
	 * @function setPopupZindex 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is used to set the z-index.
	 * 
	 * 
	 * @parm(s) : @param index
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setPopupZindex(int index){
		if(appPopUp!=null){
			appPopUp.setPopupZindex(index);
		}
	}
	/**
	 * @function onClickDelete 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This will handle the click event on the ok button.
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("okButton")
	public void onClickDelete(ClickEvent clickEvent){
		loadingTextLbl.setVisible(true);
        buttonContainer.setVisible(false);
		onDelete(clickEvent);
	}
	
	public abstract void onDelete(ClickEvent clickEvent);
	
	public void setScrollDisable(){
		isEditQuestion=true;
	}

}
