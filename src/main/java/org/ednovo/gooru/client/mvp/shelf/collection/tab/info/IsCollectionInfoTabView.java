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
package org.ednovo.gooru.client.mvp.shelf.collection.tab.info;

import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.gin.IsViewWithHandlers;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.code.LibraryCodeDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.search.SearchDo;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * @author Search Team
 *
 */
public interface IsCollectionInfoTabView extends IsViewWithHandlers<CollectionInfoTabUiHandlers> {
	
	/**
	 * Set collection meta data info
	 * @param collectionDo instance of {@link CollectionDo}
	 */
	void setData(CollectionDo collectionDo);
	
	/**
	 * Set suggest standards
	 * @param mapSearchDo instance of {@link SearchDo} type of {@link CodeDo}
	 */
	void setStandardSuggestions(SearchDo<CodeDo> mapSearchDo);
	
	/**
	 * Set collection default course
	 * @param libraryCode instance {@link LibraryCodeDo} as List
	 */
	void setCourseList(List<LibraryCodeDo> libraryCode);
	
	/**
	 * Update collection course
	 * @param collectionDo instance of {@link CollectionDo}
	 */
	void onPostCourseUpdate(CollectionDo collectionDo);
	
	/**
	 * Update collection standards 
	 * @param collectionDo instance of {@link CollectionDo}
	 */
	void onPostStandardUpdate(CollectionDo collectionDo);

	void closeAllOpenedPopUp();
	
	FlowPanel getStandardContainer();
	
	void getUserStandardPrefCodeId(List<String> list);

	void OnStandardsClickEvent(Button addBtn);

	void setUpdatedStandards(String standardsCode, Integer codeId,String description);

	Button getBrowseBtn();
/*	void displayErrorMsgTeacherTip();

	void setExistingTeacherTip(CollectionDo collectionDo);*/
	/**
	 * This method is used add 21 century skills add button
	 * @param addBtn
	 */
	void OnCenturyClickEvent(Button addBtn);
	/**
	 * This method is used to display selected 21 skills values in the FE and for updating
	 * @param selectedValues
	 */
	void setUpdatedCentury(Map<Long, String> selectedValues);
}
