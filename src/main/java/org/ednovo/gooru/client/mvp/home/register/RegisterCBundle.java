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
 * @fileName : RegisterCBundle.java
 *
 * @description : This file is used to apply css styles for RegisterVc
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
public interface RegisterCBundle extends ClientBundle {
	
	static final RegisterCBundle INSTANCE = GWT.create(RegisterCBundle.class);
	
	public interface RegisterCss extends CssResource{
		
		String registerPopup();
		
		String registerPopupGlassPanel();
		
		String registerFormContainer();
		
		String registerMessageDiv();
		
		String registerFieldsContainer();
		
		String registerLeftContainer();
		
		String registerRightContainer();
		
		String registerFormField();
		
		String registerGenderRow();
		
		String registerTermsAndCondtion();
		
		String actionField();
		
		String registerFormInputs();
		
		String registerFormFields();
		
		String genderoptions();
		
		String genderInputField();
		
		String containerText();
		
		String collectionFormCancelButton();
		
		String overRideBlueButton();
		
		String supportText();
		
		String footerDiv();
		
		String errorValidation();
		
		String listBoxAlign();
		
		String registerRightFormField();
		
		String registerRightsFormFields();
		
		String registerContentDiv();
		
		String registerActionField();
		
		String emailTxtBox();
		
		String calendarStyle();
		
		String dateStyle();
		
		String errorBoxStyle();
		
		String userRegErrorStyle();
		
		String registerTextAlign();
		
		String registerAlignInputs();
		
		String registerContentAlign();
		
		String userRegistrationText();
		
		String userErrorLabel();
		
		String userRegistrationError();
		
		String validationTextBox();
		
		String registerRightFormInputs();
		
		String childAccountText1();
		
		String childAccountText2();
		
		String childRegisterContent();
		
		String childConfirmButton();

		String registerErrorLabel();
		
		String rightErrorLabel();
		
		String registerEmailDiv();
		
		String guardianEmailId();
		
		String registerLabelAlign();
		
		String emailIdParent();
		
		String parentFormButtonDiv();
		
		String guardianErrorEmail();
		
		String parentErrorLabel();
		
		String gooruDateError();
		
		String gooruDateBoxError();
		
		String parentDateTextError();
		
		String parentDateBoxError();
		
		String registerPopupStyle();
		
		String registerHeaderDiv();
		
		String registerHeaderText(); 
		
		String welcomePopup();
		
		String getstartMessage();
		
		String happyLearning();
		
		String welcomeButtonBox();
		
		String shelfItemContentDiv();
		
		String registerSuccessMessage();
		
		String registerFormButtonDiv();
		
		String supportTextMsg();
		
		String contactUsText();
		
		String registerContactMessage();
		
		

		String registerSaveAndShareText();

		//String registerTextAlign1();

		String registerTextAlign2();
		
		String registerInnerContainer();
		
		String saveAndShareHaveAnAccountTwo();
		

		String registerSaveAndShareHeaderTitle();
		
		String registerSaveAndShareContentDiv();
		
		String registerSaveAndShareAlignInputs();
		
		String registersaveAndSharePopupTotalContainerNew();
		
		String resourceRegisterError();

//		String registerSearchSecoundContainer();
		
//		String registerPopupStyleForSearch();
		
		String registerContentsize();
		String resourceRegisterAlign(); 
String overResourceRideBlueButton();
	}
	@Source("register.css")
	RegisterCss css();
}
