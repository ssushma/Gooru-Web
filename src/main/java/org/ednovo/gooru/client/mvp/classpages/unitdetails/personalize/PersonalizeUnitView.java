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

import java.util.ArrayList;

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.classpages.unitdetails.personalize.AssignmentGoal.AssignmentGoalView;
import org.ednovo.gooru.client.uc.PaginationButtonUc;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.StudentsAssociatedListDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;


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
		IsPersonalizeUnitView, ClickHandler  {

	private static PersonalizeUnitViewUiBinder uiBinder = GWT
			.create(PersonalizeUnitViewUiBinder.class);	
	
	@UiField HTMLPanel panelPersonalizeContainer, panelPagination;
	
	int currentPage = 0;
	
	int limit = 2;
	
	ArrayList<CollectionItemDo> goalsList = null;

	private int offSet;

	interface PersonalizeUnitViewUiBinder extends
			UiBinder<Widget, PersonalizeUnitView> {

	}

	private static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	private static final String PREVIOUS = i18n.GL1462().toUpperCase();

	private static final String NEXT = i18n.GL1463().toUpperCase();

	public PersonalizeUnitView() {
		setWidget(uiBinder.createAndBindUi(this));		
	}
	
	public void setGoalsList(ArrayList<CollectionItemDo> goalsList){
		this.goalsList = goalsList;
	}

	@Override
	public void displayAssignmentsGoals(StudentsAssociatedListDo result){
		panelPersonalizeContainer.clear();
		if (result.getSearchResults().size() <=0){
			Label noStudents = new Label();
			noStudents.setText(i18n.GL2243());
			panelPersonalizeContainer.add(noStudents);
		}else{
			for (int k=0;k<result.getSearchResults().size();k++){
				panelPersonalizeContainer.add(new AssignmentGoalView(result.getSearchResults().get(k)));
			}
		}
	}
	@Override
	public void displayPagination(StudentsAssociatedListDo result, int offSet, int limit){
		panelPagination.clear();
		this.offSet = offSet;
		int noOfItem = result.getTotalHitCount() / (limit==0 ? 1 : limit);
		System.out.println("noOfItem : "+noOfItem);
		System.out.println("currentPage : "+currentPage);
		if (result.getSearchResults() != null && result.getSearchResults().size() > 0 && noOfItem > 0) {
			if (result.getTotalHitCount() > 1) {
				
				if (currentPage > 0) {
					panelPagination.add(new PaginationButtonUc(currentPage - 1, PREVIOUS, this));
				}
				
				for (int count=0; count<noOfItem; count++){
					panelPagination.add(new PaginationButtonUc(count+1, count == currentPage, this));
				}
								
				if (currentPage < (noOfItem-1)) {
					panelPagination.add(new PaginationButtonUc(currentPage + 1, NEXT, this));
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.event.dom.client.ClickHandler#onClick(com.google.gwt.event.dom.client.ClickEvent)
	 */
	@Override
	public void onClick(ClickEvent event) {
		if (event.getSource() instanceof PaginationButtonUc) {
			currentPage = ((PaginationButtonUc) event.getSource()).getPage();
			System.out.println("currentPage : "+currentPage);
			getUiHandlers().getStudentsList((limit+offSet), limit, "active", null);
		} else {
			Window.alert("Event is not caught");
		}
	}	
}
