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
package org.ednovo.gooru.client.mvp.classpages.assignments;

/*
 * 
 * @fileName : AssignmentPopupView.java
 *
 * @description : This class is responsible to show and add assignments 
 *
 *
 * @version : 5.3
 *
 * @date: May 4, 2013
 *
 * @Author Gooru team
 *
 * @Reviewer:
 */

import java.util.Date;

import org.ednovo.gooru.client.uc.DateBoxUc;
import org.ednovo.gooru.client.uc.ErrorLabelUc;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.content.AssignmentDo;
import org.ednovo.gooru.shared.model.content.AttachToDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.TaskDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public abstract class AssignmentPopupView extends Composite implements MessageProperties{

	private static final String MANDATORY_TITLE = GL0173;
	private static final String CHARACTERS_LIMIT = GL0143;
	String classpageId = "";

	public interface AssignmentPopupViewUiBinder extends
			UiBinder<Widget, AssignmentPopupView> {

	}

	@UiField
	SimplePanel dateSimPanel;

	@UiField
	ErrorLabelUc dateValidationUc;

	private DateBoxUc dateBoxUc;

	public static AssignmentPopupViewUiBinder uiBinder = GWT
			.create(AssignmentPopupViewUiBinder.class);

	@UiField
	public Label cancelResourcePopupBtnLbl, addResourceBtnLbl,assignmentTitleLabel,assignmentDirectionLabel;

	@UiField
	Label mandatoryTitleLabel, mandatoryDueDateLabel, mandatoryDirectionLabel,assignmentDueDateLabel;

	@UiField
	TextBox assignmentTitleTxt;

	@UiField
	TextArea assignmentDirectionsTxtArea;
	
    boolean isClicked = false;

	public AssignmentPopupView() {
		initWidget(uiBinder.createAndBindUi(this));
		assignmentTitleLabel.setText(GL1407+GL_SPL_STAR);
		mandatoryTitleLabel.setText(GL0173);
		assignmentDueDateLabel.setText(GL0238);
		mandatoryDueDateLabel.setText(GL0235);
		assignmentDirectionLabel.setText(GL1408);
		mandatoryDirectionLabel.setText(GL0236);
		addResourceBtnLbl.setText(GL0590);
		cancelResourcePopupBtnLbl.setText(GL0142);
		mandatoryDueDateLabel.getElement().setAttribute("id", "datePickerErrorMessageLabel");
		assignmentTitleTxt.getElement().setAttribute("id", "txtAssignmentTitle");
		assignmentDirectionsTxtArea.getElement().setAttribute("id", "txtAreaDirections");
		addResourceBtnLbl.getElement().setId("lblAdd");
		cancelResourcePopupBtnLbl.getElement().setId("lblCancel");
		cancelResourcePopupBtnLbl.addClickHandler(new CloseClickHandler());
		addResourceBtnLbl.addClickHandler(new AddClickHandler());

		assignmentTitleTxt.getElement().setAttribute("maxlength", "50");
		assignmentDirectionsTxtArea.getElement().setAttribute("maxlength",
				"400");

		assignmentTitleTxt.addKeyUpHandler(new TitleKeyUpHandler());
		assignmentDirectionsTxtArea
				.addKeyUpHandler(new DirectionsKeyUpHandler());

		dateBoxUc = new DateBoxUc(false, false,false);
		dateSimPanel.add(dateBoxUc);
		dateValidationUc.setStyleName(AddAssignmentContainerCBundle.INSTANCE.css().registerErrorLabel());

		dateBoxUc.getDateBox().addFocusHandler(new OnDateFocus());
		dateBoxUc.getDateBox().addBlurHandler(new OnDateBlur());
		dateBoxUc.addDomHandler(new OnDateFocus(), FocusEvent.getType());
		dateBoxUc.getDoneButton().addClickHandler(new OnDoneClick());

		dateValidationUc.setVisible(false);

		//Dont enable this.
//		Window.enableScrolling(false);
//        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, false));

		
		clearFields();
	}

	public abstract void hidePopup();

	public abstract void createAssignment(CollectionDo collectionDo, String todaysDate);
	
	public abstract void createAssignment(AssignmentDo assignmentDo);

	/**
	 * Validate Assignment Date
	 * 
	 * @return true if valid
	 */
	private boolean hasValidateDate(String dueDate) {

		boolean isValid = true;
		if (dueDate == null || (dueDate != null && dueDate.isEmpty())) {
		//dateBoxUc.addStyleName(AddAssignmentContainerCBundle.INSTANCE.css().gooruDateBoxError());
			//dateBoxUc.getDateBox().addStyleName(AddAssignmentContainerCBundle.INSTANCE.css().gooruDateError());
			dateValidationUc.setText("");
			dateValidationUc.setVisible(true);
			
			isValid = false;
		}
		return isValid;
	}

	private class OnDateFocus implements FocusHandler {
		@Override
		public void onFocus(FocusEvent event) {
dateBoxUc.removeStyleName(AddAssignmentContainerCBundle.INSTANCE.css().gooruDateBoxError());
			dateBoxUc.getDateBox().removeStyleName(
					AddAssignmentContainerCBundle.INSTANCE.css()
							.gooruDateError());
			if (dateValidationUc.isVisible()) {
				dateValidationUc.setVisible(false);
			}

		}
	}

	private class OnDoneClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			if (dateBoxUc.dateValidation()){
				if (!(dateBoxUc.getValue() == null || dateBoxUc.getDateBox()
						.getText().isEmpty())
						&& dateBoxUc.hasValidateDate()) {
				Date date = dateBoxUc.getValue();
				
				} else {
					dateBoxUc.getDatePickerUc().hide();
				}
			}
		}
	}

	private class OnDateBlur implements BlurHandler {
		@Override
		public void onBlur(BlurEvent event) {
			dateBoxUc.removeStyleName(AddAssignmentContainerCBundle.INSTANCE.css().gooruDateBoxError());
			dateBoxUc.getDateBox().removeStyleName(
					AddAssignmentContainerCBundle.INSTANCE.css()
							.gooruDateError());
		}
	}

	/*
	 * Event handlers for all controls in this class
	 */
	private class CloseClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			clearFields();
			hidePopup();
		}
	}

	private class AddClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			boolean isFormFilled = true;
			
			String title = assignmentTitleTxt.getText().trim();
			String dueDate = dateBoxUc.getDateBox().getText();
			String directions = assignmentDirectionsTxtArea.getText().trim();

			if (title == null || title.equalsIgnoreCase("")) {
				mandatoryTitleLabel.setText(MANDATORY_TITLE);
				mandatoryTitleLabel.setVisible(true);
				isFormFilled = false;
			} else if (title.length() > 50) {
				mandatoryTitleLabel.setText(CHARACTERS_LIMIT);
				mandatoryTitleLabel.setVisible(true);
				isFormFilled = false;
			}
			if (dueDate != null && !dueDate.equalsIgnoreCase("")){
				isFormFilled = hasValidateDate(dueDate);
				if (!isFormFilled){
					mandatoryDueDateLabel.setVisible(true);
				}
			}
//			if (!isFormFilled || dueDate == null || dueDate.equalsIgnoreCase("")){
//				

//			}
//			if (directions == null || directions.equalsIgnoreCase("")) {
//				mandatoryDirectionLabel.setText(MANDATORY_DIRECTIONS);
//				mandatoryDirectionLabel.setVisible(true);
//				isFormFilled = false;
//			} else 
			if (directions.length() > 400) {
				mandatoryDirectionLabel.setText(CHARACTERS_LIMIT);
				mandatoryDirectionLabel.setVisible(true);
				isFormFilled = false;
			}

			if (isFormFilled) {

				// //noAssignmentsMessagePanel.setVisible(false);
//				CollectionDo collectionDo = new CollectionDo();
//				collectionDo.setTitle(title);
//				collectionDo.setDescription(directions);
//				collectionDo.setCollectionType("assignment");
//				collectionDo.setGooruOid(getClasspageId());
//				collectionDo.setTaxonomySet(null);
//				collectionDo.setTrackActivity(null);
				
				AssignmentDo assignmentDo = new AssignmentDo();
				if (dueDate!=null && !dueDate.equalsIgnoreCase("")){
					assignmentDo.setPlannedEndDate(dueDate);
				}
				assignmentDo.setClasspageId(classpageId);
				
				TaskDo taskDo = new TaskDo();
				taskDo.setTitle(title);
				taskDo.setTypeName("assignment");
				if (directions!=null && !directions.trim().equalsIgnoreCase("")){
					taskDo.setDescription(directions);
				}
				
				assignmentDo.setTask(taskDo);
				
				AttachToDo attachToDo = new AttachToDo();
				attachToDo.setId(classpageId);
				attachToDo.setType("classpage");
				
				assignmentDo.setAttachTo(attachToDo);
				
				if(!isClicked){
					isClicked = true;
					MixpanelUtil.Create_Assignment_Success();
					createAssignment(assignmentDo);
				}
			}

		}
	}

	// private class DueDateCalender implements ClickHandler {
	//
	// @Override
	// public void onClick(ClickEvent event) {
	// mandatoryDueDateLabel.setVisible(false);
	//
	// }
	// }
	//
	// private class DueDateKeyUpHandler implements KeyUpHandler {
	//
	// public void onKeyUp(KeyUpEvent event) {
	// mandatoryDueDateLabel.setVisible(false);
	// }
	// }

	private class TitleKeyUpHandler implements KeyUpHandler {

		public void onKeyUp(KeyUpEvent event) {
			String title = assignmentTitleTxt.getText().trim();
			mandatoryTitleLabel.setVisible(false);
			if (title.length() >= 50) {
				mandatoryTitleLabel.setText(CHARACTERS_LIMIT);
				mandatoryTitleLabel.setVisible(true);
			}
		}
	}

	private class DirectionsKeyUpHandler implements KeyUpHandler {

		public void onKeyUp(KeyUpEvent event) {
			String directions = assignmentDirectionsTxtArea.getText().trim();

			mandatoryDirectionLabel.setVisible(false);

			if (directions.length() >= 400) {
				mandatoryDirectionLabel.setText(CHARACTERS_LIMIT);
				mandatoryDirectionLabel.setVisible(true);
			}
		}
	}

	/*
	 * Custom methods
	 */

	public void clearFields() {
		mandatoryDirectionLabel.setVisible(false);
		mandatoryDueDateLabel.setVisible(false);
		mandatoryTitleLabel.setVisible(false);

		// mandatoryTitleLabel.getElement().setAttribute("style",
		// "display:none");

		assignmentDirectionsTxtArea.setText("");
		assignmentTitleTxt.setText("");
		dateBoxUc.getDateBox().setText("");
		
		isClicked = false;
	}

	/* Setter and getters */
	/**
	 * This method is to get the classpageId
	 */
	public String getClasspageId() {
		return classpageId;
	}

	/**
	 * This method is to set the classpageId
	 */
	public void setClasspageId(String classpageId) {
		this.classpageId = classpageId;
	}
	
	public void isClikedMethod(){
			isClicked = false;
			}

}
