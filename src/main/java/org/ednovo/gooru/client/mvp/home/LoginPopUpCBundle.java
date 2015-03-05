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
package org.ednovo.gooru.client.mvp.home;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/**
 * 
 * @author BLR Team
 *
 */

public interface LoginPopUpCBundle extends ClientBundle{
	
	static final LoginPopUpCBundle INSTANCE = GWT.create(LoginPopUpCBundle.class);
	
	public interface LoginPopUpCss extends CssResource{
		
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
//		String loginPopupGplusButtonQ();
		String loginPopupGplusOuterdiv();
		
		String loginPopupGplusBtn();
		String loginPopupGplusDesc();
		String clear();
		
		String loginPopupGlassStyle();
		
		// New Login popup css.//
		
		String processing();
	
		String popupInner();

		String popupHeader();

		String popup(); 
		
		String closeButton();

		String popupContent();

		String imgBG();

		String h1();

		String signInContainer();

		String gConnectButton();

		String divider();

		String dividerText();

		String emailSignIn();

		String btnLogin();

		String forgotPasswordLink();

		String haveAccount();
		
		String haveAccountContainer();
		 
		String forgotPasswordText();
		
		String forgotPasswordTextBoxContainer();
		
		String btnSubmit();
		
		String forgotPasswordBottomContainer();
		
		String footerText();
		
		String forgetImgBG();
		
		String forgotPasswordErrorMessage();
		
		String forgotPasswordPopupContent();
		
		String forgotPasswordSuccessText();
		
		String forgotPasswordSuccessPopupContent();
		
		String forgotPasswordSuceessButtonContainer();
		
		String forgotPasswordPopupResendContent();
		
		String h1SuccessConfirmMessage();
		
		String h1SuccessConfirmMessage1();
		
		String separator();
		
		String green();
		
		String errorLabel();
		
		String loginWithGooru();
	}
	@Source("Newlogin-popup.css")
	LoginPopUpCss css();

	
	
}

