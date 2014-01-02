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
package org.ednovo.gooru.client.mvp.home.register;


import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
/**
 * 
 * @fileName : NewRegisterCBundle.java
 *
 * @description : This file is used to apply css styles.
 *
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public interface NewRegisterCBundle extends ClientBundle{
	
	static final NewRegisterCBundle INSTANCE = GWT.create(NewRegisterCBundle.class);
	
	public interface RegisterPopUpCss extends CssResource{
		
		String loginPopupContainer();
		String loginPopupInnerdiv();
		String loginPopupHeaderBg();
		String loginPopupHeaderTitle();
		String loginPopupCloseBtnContainer();
		String textBoxPlaceHolderWidth();
		String keepMeLoginContainer();
		String loginPopupCheckBoxDescText();
		
		String loginPopupBtnSprite();
		String loginPopupCloseBtn();
		String loginPopupGooruLogoContainer();
		String loginPopupGooruLogo();
		String loginPopupInputContainer();
		String loginPopupInputControl();
		String loginPopupInputPwdText();
		String loginPopupCheckBoxContainer();
		String loginPopupCheckBoxControl();
		String loginPopupCheckBox();
		String loginPopupCheckBoxDesc();
		String loginPopupButtonContainer();
		String loginPopupButtonBg();
		String loginPopupButtonText();
		
		String loginPopupBottomTextContainer();
		String loginPopupBottomText();
		String loginPopupBottomBlueText();
		
		String loginPopupBorderBottom();
		String loginPopupOrText();
		String loginPopupGplusButtonContainer();
		String loginPopupGplusButton();

		String loginPopupGplusOuterdiv();
		
		String loginPopupGplusBtn();
		String loginPopupGplusDesc();
		String clear();
		
		
		String registerInfoText();
		String registerContentAlign();
		String registerAlignInputs();
		String emailTxtBox();
		String calendarStyle();
		String registerPopupStyle();
		String registerErrorLabel();
		String errorBoxStyle();
		String gooruDateError();
		String gooruDateBoxError();
		String collectionFormCancelButton();
		String registerEmailErrorLabel();
		String goAndCancelContainer();
		
	}
	@Source("NewReg-popup.css")
	RegisterPopUpCss css();

	
	
}
