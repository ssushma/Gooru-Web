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
import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public abstract class GoalViewVc extends Composite {

	private static GoalViewVcUiBinder uiBinder = GWT.create(GoalViewVcUiBinder.class);

	@UiField Label lblAssignmentNumber;
	
	@UiField HTMLPanel panelMembers;
	
	String assignmentNo;
	
	interface GoalViewVcUiBinder extends UiBinder<Widget, GoalViewVc> {
	}
	
	public MessageProperties i18N = GWT.create(MessageProperties.class);
	
	public GoalViewVc(String assignmentNo) {
		initWidget(uiBinder.createAndBindUi(this));
		this.assignmentNo = assignmentNo;
		setDebugId();		
	}
	
	@Override
	public void onLoad() {
//		setDebugId();
	}

	public void setDebugId() {
		
		int value = Integer.parseInt(assignmentNo) % 2;
		
		lblAssignmentNumber.setText(assignmentNo);
		lblAssignmentNumber.setVisible(false);
		panelMembers.getElement().addClassName(AssignmentGoalCBundle.INSTANCE.css().circleSmall());
		panelMembers.getElement().addClassName(value ==0 ? AssignmentGoalCBundle.INSTANCE.css().green() : AssignmentGoalCBundle.INSTANCE.css().grey());
	}
	
	private void removeThisFromParent(){		
		this.removeFromParent();
	}
}