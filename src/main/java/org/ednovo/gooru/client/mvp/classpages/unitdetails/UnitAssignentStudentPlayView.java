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
package org.ednovo.gooru.client.mvp.classpages.unitdetails;

import java.util.HashMap;

import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * 
 * @fileName : UnitAssignentStudentPlayView.java
 * 
 * @description : This class is used to display the assignment tooltip for student
 * 
 * 
 * @version : 1.1
 * 
 * @date: Sep 23, 2014
 * 
 * @Author Gooru Team
 * 
 * @Reviewer:
 */


public class UnitAssignentStudentPlayView extends PopupPanel {

	private static UnitAssignentStudentPlayViewUiBinder uiBinder = GWT
			.create(UnitAssignentStudentPlayViewUiBinder.class);
	
	MessageProperties i18n = GWT.create(MessageProperties.class);
	
	interface UnitAssignentStudentPlayViewUiBinder extends
			UiBinder<Widget, UnitAssignentStudentPlayView> {
	}
	@UiField HTMLPanel panelCicle1,dueDateContainer;
	@UiField Label lblCircle1;
	@UiField HTML assignmentCollectiontitle;
	@UiField Button studyButtonText;
	UnitAssignmentCssBundle res;
	
	public UnitAssignentStudentPlayView(int seq,String title,String dueDate,String direction,String collectionId,String collectionItemId) {
		setWidget(uiBinder.createAndBindUi(this));
		this.res = UnitAssignmentCssBundle.INSTANCE;
		res.unitAssignment().ensureInjected();
		setView(seq,title,dueDate,direction,collectionId,collectionItemId);
	}
	/**
	 * @method name :setView
	 * 
	 * @description : This method is used to display the view 
	 * 
	 * @param : Sequence number
	 * @param : assignment title
	 * @param : due date
	 * @param : direction
	 * @param : collectionId
	 * @param : collectionItemId
	 * @return type : void
	 */
	
	public void setView(int seq,String title,String dueDate,String direction,final String collectionId,final String collectionItemId)
	{
		studyButtonText.setText(i18n.GL0182());
		studyButtonText.getElement().setAttribute("alt",i18n.GL0182());
		studyButtonText.getElement().setAttribute("title",i18n.GL0182());
		panelCicle1.getElement().setId("pnlCircle1");
		lblCircle1.getElement().setId("lblCircle1");
		lblCircle1.setText(seq+".");
		studyButtonText.getElement().setId("btnStudy");
		dueDateContainer.getElement().setId("pnlDueDateContainer");
		assignmentCollectiontitle.getElement().setId("htmlAssignmentCollectionTitle");
		assignmentCollectiontitle.setText(title);
		
		studyButtonText.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map<String, String> parms = new HashMap<String, String>();
				parms.put("id", collectionId);
				parms.put("cid", collectionItemId);
				parms.put("page", "study");
				
				AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.COLLECTION_PLAY, parms, false);
			}
		});
		dueDateContainer.clear();
		if(dueDate!=null&&!dueDate.equals("")){
			Label dueDateText=new Label(i18n.GL1390());
			dueDateText.setStyleName(res.unitAssignment().dueDataIcon());
			Label dueDateLabel=new Label(dueDate.toString());
			dueDateLabel.setStyleName(res.unitAssignment().headerDueDate());
			dueDateContainer.add(dueDateText);
			dueDateContainer.add(dueDateLabel);
		}
	
		if(direction!=null&&!direction.equals("")){
			InlineLabel directionHeadLabel=new InlineLabel(i18n.GL1372());
			directionHeadLabel.setStyleName(res.unitAssignment().directionHeading());
			InlineLabel directionTextLabel=new InlineLabel(direction);
			directionTextLabel.setStyleName(res.unitAssignment().directionDesc());
			dueDateContainer.add(directionHeadLabel);
			dueDateContainer.add(directionTextLabel);
		}
	}

}
