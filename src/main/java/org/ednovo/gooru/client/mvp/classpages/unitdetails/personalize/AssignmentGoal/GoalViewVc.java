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
package org.ednovo.gooru.client.mvp.classpages.unitdetails.personalize.AssignmentGoal;

import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.InsightsUserDataDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public abstract class GoalViewVc extends Composite {

	private static GoalViewVcUiBinder uiBinder = GWT
			.create(GoalViewVcUiBinder.class);

	@UiField
	Label lblAssignmentNumber, lblPercentage;

	@UiField
	HTMLEventPanel panelMembers;

	@UiField
	HTMLPanel panelProgressBar;

	@UiField
	HTML htmlTitle;

	InsightsUserDataDo insightsDo = null;

	String assignmentNo;

	int percentage = 85;

	int minGoal = 75;

	boolean isOptional = true;

	boolean goalStatus;

	interface GoalViewVcUiBinder extends UiBinder<Widget, GoalViewVc> {
	}

	public MessageProperties i18N = GWT.create(MessageProperties.class);

	public GoalViewVc(String assignmentNo, InsightsUserDataDo insightsDo) {
		initWidget(uiBinder.createAndBindUi(this));
		this.assignmentNo = assignmentNo;
		this.insightsDo = insightsDo;

		goalStatus = percentage < minGoal ? false : true;
		
		setData();
	}

	/**
	 * @function setData
	 * 
	 * @created_date : 17-Sep-2014
	 * 
	 * @description
	 * 
	 * 
	 * 
	 * @return : void
	 * 
	 * @throws : <Mentioned if any exceptions>
	 * 
	 * 
	 * 
	 * 
	 */

	private void setData() {
		isOptional = true;
		
		panelProgressBar.getElement().setAttribute("role", "progressbar");
		panelProgressBar.getElement().setAttribute("aria-valuenow",
				"" + percentage);
		panelProgressBar.getElement().setAttribute("aria-valuemin", "0");
		panelProgressBar.getElement().setAttribute("aria-valuemax", "100");
		panelProgressBar.getElement().setAttribute("role", "progressbar");
		panelProgressBar.getElement().getStyle().setWidth(percentage, Unit.PCT);

		panelProgressBar.getElement().addClassName(
				goalStatus ? "progress-bar-success" : "progress-bar-danger");

		
		lblAssignmentNumber.getElement().addClassName("numaric");
		lblAssignmentNumber.setText(assignmentNo);
		
		
		htmlTitle.setHTML(assignmentNo + ". "+ insightsDo.getTitle());

		
		lblPercentage.setText(percentage + "%");
		lblPercentage.getElement().addClassName(
				percentage < minGoal ? "colorRed" : "colorGreen");
		
		panelMembers.getElement().addClassName(
				isOptional ? "optional" : "dummyOptional");

		if (isOptional) {
			if (goalStatus) {
				panelMembers.getElement().addClassName("optionalGreen");
			} else {
				panelMembers.getElement().addClassName("optionalRed");
			}
		} else {
			if (goalStatus) {
				panelMembers.getElement().addClassName("greenBubble");
			} else {
				panelMembers.getElement().addClassName("redBubble");
			}
		}

	}

	@Override
	public void onLoad() {
		// setDebugId();
	}
	
	private void removeThisFromParent() {
		this.removeFromParent();
	}
}