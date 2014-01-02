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
package org.ednovo.gooru.client.mvp.classpages.newclasspage;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
/**
 * 
 * @fileName : NewClasspagePopupView.java
 *
 * @description : This file is responsible to show view based on ExistsResourceView.ui.xml for adding classpage title
 *
 *
 * @version : 1.0
 *
 * @date: 27-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public abstract class NewClasspagePopupView extends AppPopUp{

	private static NewClasspagePopupViewUiBinder uiBinder = GWT.create(NewClasspagePopupViewUiBinder.class);
	
	@UiField(provided = true)
	NewClasspagePopupCBundle res;
	
	@UiField Label cancelPopupBtnLbl, addBtnLbl,mandatoryClasspageTitleLbl;
	@UiField TextBox classpageTitleTxt;
	
	@UiField Label panelLoading;
	
	@UiField HTMLPanel panelControls;
		
	interface NewClasspagePopupViewUiBinder extends
		UiBinder<Widget, NewClasspagePopupView> {
	}
	
	public abstract void createNewClasspage(String title);
	/**
	 * Class constructor , to inject the css and set the values for the label and values.
	 */
	public NewClasspagePopupView() {
		
		this.res = NewClasspagePopupCBundle.INSTANCE;
		res.css().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));
		this.getElement().getStyle().setWidth(450,Unit.PX);
		cancelPopupBtnLbl.addClickHandler(new CloseExistsClickHandler());
		addBtnLbl.addClickHandler(new AddExistsClickHandler());
		classpageTitleTxt.getElement().setAttribute("placeholder", "What do you Teach? ie. Algebra, Period 1");
		classpageTitleTxt.getElement().setAttribute("maxlength", "50");
		classpageTitleTxt.getElement().setId("txtClassPageTitle");
		addBtnLbl.getElement().setId("lblAdd");
		cancelPopupBtnLbl.getElement().setId("lblcancel");

		classpageTitleTxt.addKeyUpHandler(new TitleKeyUpHandler());
        setModal(true);
		Window.enableScrolling(false);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, false));
		mandatoryClasspageTitleLbl.setVisible(false);
		panelLoading.setVisible(false);
		panelLoading.setText(MessageProperties.GL0122);
		panelControls.setVisible(true);
		show();
		center();
		classpageTitleTxt.setFocus(true);
	}
	/**
	 * This inner class will handle the Key up handler for the Title Text box.
	 */
	private class TitleKeyUpHandler implements KeyUpHandler {

		public void onKeyUp(KeyUpEvent event) {
			mandatoryClasspageTitleLbl.setVisible(false);
			if (classpageTitleTxt.getText().length() >= 50) {
				mandatoryClasspageTitleLbl.setText("Character limit reached.");
				mandatoryClasspageTitleLbl.setVisible(true);
			}
		}
	}
	/**
	 * This inner class will handle the click handler for the {@link CloseExistsClickHandler}.
	 */
	private class CloseExistsClickHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			hide();
			Window.enableScrolling(true);
	        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		}		
	}
	//
	/**
	 * This inner class will handle the Click event to Add existing resource/collection item to collection.
	 */
	private class AddExistsClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			if (validateFields()){
				String title = classpageTitleTxt.getText().trim();
				panelControls.setVisible(false);
				panelLoading.setVisible(true);
				createNewClasspage(title);
			}
		}
	}
	/**
	 * @function validateFields 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This method is used to validate the Text boxes.
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : boolean
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public boolean validateFields(){
		boolean isValid=true;
		String title = classpageTitleTxt.getText().trim();
		if (title==null || title.equalsIgnoreCase("")){
			mandatoryClasspageTitleLbl.setVisible(true);
			return false;
		}
		
		return isValid;
	}
	/**
	 * @function ClosePopup 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This method is used to close the popup's.
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void ClosePopup(){
		Window.enableScrolling(true);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		panelLoading.setVisible(false);
		hide();
	}
	
}
