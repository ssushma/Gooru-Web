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
package org.ednovo.gooru.client.mvp.classpages.unitdetails.personalize;

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.classpages.unitdetails.personalize.AssignmentGoal.AssignmentGoalView;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.StudentsAssociatedListDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;


/**
 * 
 * @fileName : PersonalizeUnitView.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 09-Sep-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
public class PersonalizeUnitView extends
		BaseViewWithHandlers<PersonalizeUnitUiHandlers> implements
		IsPersonalizeUnitView {

	private static PersonalizeUnitViewUiBinder uiBinder = GWT
			.create(PersonalizeUnitViewUiBinder.class);	
	
	@UiField HTMLPanel panelPersonalizeContainer;

	interface PersonalizeUnitViewUiBinder extends
			UiBinder<Widget, PersonalizeUnitView> {

	}

	private MessageProperties i18n = GWT.create(MessageProperties.class);

	public PersonalizeUnitView() {
		setWidget(uiBinder.createAndBindUi(this));		
	}

	@Override
	public void displayAssignmentsGoals(StudentsAssociatedListDo result){
		for (int k=0;k<result.getSearchResults().size();k++){
			panelPersonalizeContainer.add(new AssignmentGoalView(result.getSearchResults().get(k)));
		}
	}
}
