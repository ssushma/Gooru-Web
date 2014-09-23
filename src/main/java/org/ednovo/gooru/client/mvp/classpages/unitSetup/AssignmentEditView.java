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
package org.ednovo.gooru.client.mvp.classpages.unitSetup;
import org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections.ChangeAssignmentStatusView;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.ClassUnitsListDo;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
public class AssignmentEditView extends Composite{


	private static AssignmentEditViewUiBinder uiBinder = GWT.create(AssignmentEditViewUiBinder.class);

	interface AssignmentEditViewUiBinder extends UiBinder<Widget, AssignmentEditView> {
		
	}
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	ClassUnitsListDo classUnitsDo;
	
	public @UiField Label deleteAssignmentLbl,assignmentReorderLbl;

	public String assignmentId=null;
	
	private String unitGooruOid=null;
	
	@UiField ChangeAssignmentStatusView changeAssignmentStatusView;

	public AssignmentEditView(ClasspageItemDo classpageItemDo){ 
		initWidget(uiBinder.createAndBindUi(this));	
		Boolean isRequired=classpageItemDo.getIsRequired()!=null?classpageItemDo.getIsRequired():false;
		setAssignementRequiredStatus(isRequired);
		setAssignmentId(classpageItemDo.getCollectionItemId());
	}
	
	public void setAssignementRequiredStatus(Boolean isRequired){
		changeAssignmentStatusView.getChangeAssignmentStatusButton().setValue(isRequired);
	}
	
	public ChangeAssignmentStatusView getChangeAssignmentStatusView(){
		return changeAssignmentStatusView;
	}
	

	/**
	 * @return the assignmentReorderLbl
	 */
	public Label getAssignmentReorderLbl() {
		return assignmentReorderLbl;
	}


	/**
	 * @param assignmentReorderLbl the assignmentReorderLbl to set
	 */
	public void setAssignmentReorderLbl(Label assignmentReorderLbl) {
		this.assignmentReorderLbl = assignmentReorderLbl;
	}
	
	
	/**
	 * @return the deleteAssignmentLbl
	 */
	public Label getDeleteAssignmentLbl() {
		return deleteAssignmentLbl;
	}

	
	
	/**
	 * @return the assignmentId
	 */
	public String getAssignmentId() {
		return assignmentId;
	}


	/**
	 * @param assignmentId the assignmentId to set
	 */
	public void setAssignmentId(String assignmentId) {
		this.assignmentId = assignmentId;
	}

	public void setUnitId(String unitGooruOid) {
		this.unitGooruOid=unitGooruOid;
	}
	
	public String getUnitId() {
		return unitGooruOid;
	}
}
