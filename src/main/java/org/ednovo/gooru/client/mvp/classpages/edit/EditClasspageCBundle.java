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
package org.ednovo.gooru.client.mvp.classpages.edit;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;


/**
 * 
 * @fileName : EditClasspageCBundle.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 07-Dec-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
public interface EditClasspageCBundle extends ClientBundle{
	
	static final EditClasspageCBundle INSTANCE = GWT.create(EditClasspageCBundle.class);
	
	public interface  EditClasspageCss extends CssResource{
		String userShelfViewContainer();

		String floatShelfTabLeft();

		String userShelfViewList();

		String newMockLeftAlignController();

		String howToUseThisPageBlue();

		String myCollectionShareStudentContainer();

		String myClasspageWrapperTwoChapterTextNoWelcome();

		String myClasspageWrapperTwoChapterText();
		
		String myClassPageTitle();

		String blueButtonView();

		String tabs();

		String tabsli();
		
		String tabsliactive();

		String active();
		
		String addAsAnAssignmentMarginBlue();
		
		String noAssignmentMsg();
		
		String myClassPageTitleButtonContainer();
		
		String editTitleButton();
		
		String searchResultContainer();
		
		String paginationContainer();

		String paginationPanel();
				
		String classPageEditArrContainer();
		String classPageEditArrOuterDiv();
		String classPageEditArrImg();
		String classPageEditArrText();
		String classPageEditArrIcon();

		String simplePencil();
		
		String collectionEditImage();
		
		String collectionDescriptionTxtArea();
		String collectionDescriptionHtml();
		String descriptionAlertMessage();
		String collectionDescription();
		String collectionDescriptionTitle();
		String titleAlertMessage();
		String collectionTitle();
		String titleAlertContainer();
		String userCollectionInfo();
		String classPagebuttonContainer();
		String classPageEditTitleCancelButton();
		String cursor();
		String classPageEditTitleSaveButton();
		String classPageEditTitle();
		String loadingpanelImage();
		
		String classpageHoverButton();
		
		String classpageTitleSave();
		
		String classpageTitleCancel();
		
		String classpageClasscode();

		String classpageCodeDesc();
		
		String classpageCodeShare();
		
		String classpageCodeShareInput();

		String classpageCodeHelp();
		
		String classpageShareCodeInput();
		
		String classpageShareLinkInput();
		
		String classpageEditButton();
		
		String classpageDeleteButton();
		
		String classpageTopLine();
		
		String addAssignment();
				
		String classpageAddPlusIcon();
		
		String assignmentsContainer();
		
		String classpageCodeInnerPopup();
		
		String classpageCodePopupTitle();
		
		String arrowShadow();

		String arrowBorder();

		String arrow ();
		
		String codePopupContainer();
		
		String webLinkPopupContainer();
		
		String classpageImage();
		
		String classpageCodeShareOr();
		
		String teachTab();
        String deselect();
        String select();
        String selected();
        String classpageHoverTitle();
        String classpageHover();
        String headerContainer();
        String iframeBorder();
        
        String monitorButton();
        
        String backArrowButton();
        
        String labelCenterAlign();
        String labelCenterAlignText();
        String classcodeStyles();
        String assignmentPath();
        String assignmentProgress();
        
        String assignmentPathContainer();
        String line();
        String squre();
        String progressStart();
        String path();
        String classcodeContainer();
        String containerProgress();
        String next();
        String previous();
        String rightArrow();
        String leftArrow();
        
        String dropdowncontainer();
        String dropdownPlaceHolder();
        String dropdownListContainerScrollPanel();
        String dropdownTextLabel();
        
        
        String dropdownContainerInstructional();
        String placeHolderText();
        String arrowInstructional();
        String scrollPanelContainerInstructional();
        String btnContainer();
        String btnContainerStyle();
        String addAssignmentStyle();
        
        String subtitle();
        String contentBox();
        String h3();
        String circleBlock();
        String circleBg();
        String circleTitle();
        String desc();
        String collectionView();
        String img();
        String btn();
        String dropdowncontainerStudent();
        String dropdownPlaceHolderStudent();
        String dropdownListContainerScrollPanelStudent();
        String containerProgressWidth();
        String assignmentsContainerHead();
        String btnContainerClasswithBG();
        String section2Div();
        String section3Div();
        String assignementOrderHeader();
        String errorMessage();
        
        String desHtml();
        String desHeader();
        String imgStyle();
        String imgStyleDiv();
        String assignText();
        
        String studentStyle();
        String techerStyle();

	}
	@NotStrict
	@Source("editclasspage.css")
	EditClasspageCss css();

}
