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
package org.ednovo.gooru.client.mvp.classpages.study;

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.uc.TextBoxWithFocus;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class ClassCodeView extends BaseViewWithHandlers<ClassCodeUiHandlers> implements IsClassCodeView {
	
	private static ClassCodeViewUiBinder uiBinder = GWT
			.create(ClassCodeViewUiBinder.class);
	/**
	 * 
	 * @fileName : ClassCodeView.java
	 *
	 * @description : 
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 27-Dec-2013
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	interface ClassCodeViewUiBinder extends UiBinder<Widget, ClassCodeView> {

	}
	@UiField TextBoxWithFocus tbCode;

	@UiField Label errorLbl;
	
	@UiField Button enterLbl;
    /**
     * Constructor.
     */
	@Inject
	public ClassCodeView() {
		setWidget(uiBinder.createAndBindUi(this));
		tbCode.getElement().setAttribute("maxlength", "10");
		enterLbl.getElement().setId("btnEnter");
		tbCode.getElement().setId("txtCode");
	}
	/**
	 * 
	 * @function OnClickEnterBtnClick 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This UIHandler is used to go to student view on click of enter label.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("enterLbl")
	public void OnClickEnterBtnClick(ClickEvent event) {
		String tbvalue=tbCode.getText();
		if(tbvalue==null || tbvalue.isEmpty()){
			errorLbl.getElement().getStyle().setDisplay(Display.BLOCK);
		}
		else{
		   getUiHandlers().gotoStudentsView(tbvalue);
		  
		}
		
	}
	/**
	 * 
	 * @function OnKeyupTbx 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This is used to hide error label.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	
	@UiHandler("tbCode")
	public void OnKeyupTbx(KeyDownEvent event) {
		
		errorLbl.getElement().getStyle().setDisplay(Display.NONE);
	}
	/**
	 * This is used to get the error label.
	 */
	public Label getErrorLbl() {
		return errorLbl;
	}
	/**
	 * This is used to clear the error label.
	 */
	@Override
	public void clearAll() {
		tbCode.setText("");
		errorLbl.setVisible(false);
	}	
}
