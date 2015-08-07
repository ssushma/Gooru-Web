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
package org.ednovo.gooru.client.mvp.folders.newfolder;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.DeleteConfirmPopupVc;
import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.client.uc.BlueButtonUc;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @author BLR Team
 *
 */

public abstract class FolderDeleteConfirmationPopUp extends AppPopUp  {
	@UiField
	Anchor cancelAnr;

	@UiField
	BlueButtonUc okButtonUc;

	@UiField
	TextBox inlineTxtBox;

	@UiField
	Label entityLbl;
	@UiField FlowPanel buttonContainer;
	
//	@UiField BlueButtonUc deleteCollectionDisabledButton;

	private String confirmText = "DELETE";
	private static FolderDeleteConfirmationPopUpUiBinder uiBinder = GWT
			.create(FolderDeleteConfirmationPopUpUiBinder.class);

	interface FolderDeleteConfirmationPopUpUiBinder extends
			UiBinder<Widget, FolderDeleteConfirmationPopUp> {
	}

	/**
	 * Class constructor, creates the folder delete popup.
	 * @param title 
	 * @param entityInfo
	 */
	public FolderDeleteConfirmationPopUp(String title, String entityInfo) {
		super();
		setContent(title, uiBinder.createAndBindUi(this));
		setStyleName("deleteResourcePopup");
		inlineTxtBox.addKeyUpHandler(new ValidateConfirmText());
		entityLbl.setText(entityInfo);
		entityLbl.getElement().setId("lblEntity");
		entityLbl.getElement().setAttribute("alt",entityInfo);
		entityLbl.getElement().setAttribute("title",entityInfo);
		inlineTxtBox.getElement().setId("txtInlineTxtBox");
		StringUtil.setAttributes(inlineTxtBox,true);
		buttonContainer.getElement().setId("pnlButtonContainer");
		okButtonUc.getElement().setId("btnDeleteCollectionDisabled");
		cancelAnr.getElement().setId("lnkCancelAnr");
		
        setModal(true);
		Window.enableScrolling(false);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, false));

		
		show();
		center();
	}
	/**
	 * Hide {@link DeleteConfirmPopupVc} popup
	 * 
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */
	@UiHandler("cancelAnr")
	public void onCancelClick(ClickEvent clickEvent) {
		hide();
		Window.enableScrolling(true);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));

	}
	/**
	 * confirm to to remove the content
	 * 
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */
	@UiHandler("okButtonUc")
	public void removeResource(ClickEvent clickEvent) {
		if (inlineTxtBox.getText().trim().equalsIgnoreCase(getConfirmText())) {
			this.onTextConfirmed();
		}
	}
	/**
	 * key handler to validate action text
	 * 
	 * @author BLR Team
	 * 
	 */
	private class ValidateConfirmText implements KeyUpHandler {

		@Override
		public void onKeyUp(KeyUpEvent event) {
			okButtonUc.setStyleName("deleteCollectionDisabledButton");
			if (inlineTxtBox.getText().trim().equalsIgnoreCase(getConfirmText())) {
				okButtonUc.setStyleName("overRideBlueButtonDelete");
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					onTextConfirmed();
				}
			}
		}
	}

	public abstract void onTextConfirmed();

	/**
	 * @return the confirmText
	 */
	public String getConfirmText() {
		return confirmText;
	}

	/**
	 * @param confirmText
	 *            the confirmText to set
	 */
	public void setConfirmText(String confirmText) {
		this.confirmText = confirmText;
	}

	
}
