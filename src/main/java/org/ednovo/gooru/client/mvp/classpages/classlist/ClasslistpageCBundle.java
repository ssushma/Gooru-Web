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
package org.ednovo.gooru.client.mvp.classpages.classlist;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;



/**
 * @author Search Team
 *
 */
public interface ClasslistpageCBundle extends ClientBundle{
	
	static final ClasslistpageCBundle INSTANCE = GWT.create(ClasslistpageCBundle.class);
	
	public interface  ClasslistpageCss extends CssResource{
			
		String teachContainer();
		
		String teachContent();
		
		String teachTitle();
		
		String toggle();
		
		String publicPrivate();
		
		String teachDesc();
		
		String teachItalic();
		String teachBold();
		String assignDiv();
		String assignTitle();
		String subTitle();
		String titleBold();
		String assignTextArea();
		String btn1();
		String teachContentView();
		String title();
		String twoActions();
		String manage();
		String progress();
		String manageStudents();
		String progressStudents();
		String manageDes();
		String manageProgressStudents();
		
		String assignSec();
		String assignSecTitle();
		String input1();
		String inputWidth();
		
		String shareTextboxLink();
		String classTypeCheckbox();
		
		String ToggleButton();
		String ToggleButtonuphovering();
		String ToggleButtondown();
		String ToggleButtondownhovering();
		String toggleMainSpan();
		String toggleSubContainer();
		
		String spanContainer();
		String classlistCheckbox();
		
		//Invite Students css
		String buttonContainer();
		String buttonTooltip();

		String tooltipContainer();
		String arrowBorder();
		String arrow();
		String tooltipContent();
		String pleaseWait();
		String error();
		String subBody();
		String pendingMembers();
		String activeMembers();
		String membersList();
		String pendingContainer();
		String activeContainer();
		String noActiveStudents();
//		Members Css
		String membersListPanel();
		String panelCollaborators();		
		String radioButtonImg();
		String usernameCss();
		String emailIdCss();
		String btnRemove();
		
		String emailButton();
		String emailStyle();
		
		//New Features Class css
		String teachPopupDisplay();
		String existPopup();
		String teachPopupInner();
		String teachPopupHeader();
		String teachPopupContent();
		String existPopupContent();
		String threeActions();
		String heading();
		String publicImage();
		String analystic();
		String classList();
		String buttonBlock();
		String extra();
		String checkboxContainer();
		String seeMoreActive();
		String seeMorePending();
		
		String checkboxStyle();
		String activeMembersDesc();
		
		String privacyAlignStyle();
		String visibilityDivContainer();
		String radioBtnVisiblity();
		String radioBtnVisiblitySecondContainer();
		String subBodyInviteContainer();
		String leftInviteContainer();
		String rightInviteContainer();
		String inviteDivContainer();
		String assignSecTitleheader();
		
		String manageText();
		String regularRadioButton();
	}
	@NotStrict
	@Source("classlistPage.css")
	ClasslistpageCss css();

}
