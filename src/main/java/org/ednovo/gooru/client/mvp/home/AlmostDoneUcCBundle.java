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

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

	/**
	 * 
	 * @fileName : AlmostDoneUcCBundle.java
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

public interface AlmostDoneUcCBundle  extends ClientBundle {
	
	static final AlmostDoneUcCBundle INSTANCE = GWT.create(AlmostDoneUcCBundle.class);
	
	public interface AlmostDoneUcCss extends CssResource
	{
		String almostDoneFormInputBottomText();
		String registrationPopupContainer();
		String registrationPopupInnerdiv();
		String registrationPopupHeaderBg();
		String registrationPopupHeaderTitle();
		String registrationPopupCloseBtnContainer();
		String registrationPopupBtnSprite();
		String registrationPopupCloseBtn();
		String registrationPopupDesc();
		String registrationPopupInputContainer();
		String registrationPopupInputText();
		String registrationPopupInputOuterDiv();
		String registrationPopupInputControl();
		String registrationPopupInputBorderNone();
		String registrationPopupDownArrContainer();
		String registrationPopupDownArrSprite();
		String registrationPopupDownArr();
		String registrationPopupButtonCotnainer();
		String registrationLegalMessage();
		String registrationPopupBlueButton();
		String registrationPopupButtonText();
		String registrationPopupDropdownControl();
		String registrationPopupDropdownDesc();
		String registrationPopupDropdown();
		String registrationPopupDropdownList();
		String registrationPopupButton();
		String registrationPopupRoleText();
		String registrationPopupInputDropDownText();
		String almostDoneFormInputBottomRoleText();
		String anchorText();
	}
	@Source("AlmostDonePopUp.css")
	AlmostDoneUcCss css();

}
