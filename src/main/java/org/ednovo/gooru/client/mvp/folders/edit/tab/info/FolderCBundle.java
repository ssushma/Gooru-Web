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
package org.ednovo.gooru.client.mvp.folders.edit.tab.info;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;



/**
 * @author Search Team
 *
 */
public interface FolderCBundle extends ClientBundle{
	
	static final FolderCBundle INSTANCE = GWT.create(FolderCBundle.class);
	
	public interface  FolderCss extends CssResource{
		
		String addButtonForFolder();
		
		String folderInformationTextContainer();
		
		String folderInformationText();
		
		String selectAllContentContainer();
		
		String selectAllContent();
		
		String shelfItemContentDiv();
		
		String contentAlign();
		
		String shelfItemContentInnerDiv();
		
		String contentAlignInputs();
		
		String errorClass();
		
		String courseMoreInfo();
		
		String newColletionOR();
		
		String actionField();
		
		String errorValidation();
		
		String validationErrorContainer();
		
		String important();
		
		String collectionThumbnail();
		
		String collectionThumbnails();
		
		String collectionNotify();
		
		String changeImage();
		
		String shelfGradeInfoTitle();
		
		String infoContainer();
		
		String gradeInfoContainer();
		
		String gradeInfoTitleContainer();
		
		String shelfGradeInfoBottom();
		
		String shelfGradeInfogarden();
		
		String infoTextBox();
		
		String infoAddButton();
		
		String standardsCont();
		
		String gradeListCont();
		
		String gradeList();
		
		String standardsListContainer();
		
		String shelfCourseList();
		
		String shelfVocabulary();
		
		String shelfNameCourse();
		
		String shelfCourseSubject();
		
		String shelfCourseAdded();
		
		String subjectBox();
		
		String floatLeft();
		
		String deleteCollection();
		
		String deleteText();
		
		String shelfGradeInfoHigherEd();
		
		String shelfHigherEd();
		
		String courseMaxMsg();
		
		String ErrorShow();
		
		String coursesContainer();
		
		String courseTextBox();
		
		String courseAddButton();
		
		String courseMaxMsgShow();
		
		String addedCoursesList();
		
		String standardTxtBox();
		
		String standardAddBtn();
		
		String standardMax();
		
		String standardMaxHide();
		
		String floatLeftNeeded();
		
		String shelfGradeInfogardenContainer();
		
		/********** Collection Collaborator Tab ************/
		
		String collaboratorPanel();
		
		String addCollaborator();
		
		String addedCollaborator();
		
		String clear();
		
		String addCollaboratorText();
		
		String collaboratorBox();
		
		String addButton();
		
		String collabData();
		
		String collabList();
		
		String addco();
		
		String addCollabBlueBtn();
		
		String collaboratorPanelRight();
		
		String collaboratorRecent();
		
		String kinderGartenGrade();
		
		String higherEducationGrade();
		String gradeInfoLabel();
		

	}
	@Source("Folder.css")
	FolderCss css();

}
