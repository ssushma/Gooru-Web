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

import java.util.List;

import org.ednovo.gooru.client.child.ChildView;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.event.DisplayNextSetAssignmentsEvent;
import org.ednovo.gooru.client.mvp.search.event.DisplayNextSetAssignmentsHandler;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.shared.model.content.CollaboratorsDo;
import org.ednovo.gooru.shared.model.content.InsightsUserDataDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : AssignmentGoalView.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 10-Sep-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
public class AssignmentGoalView extends ChildView<AssignmentGoalPresenter> implements IsAssignmentGoalView{

	private ClasspageItemDo classpageItemDo=null;
	CollaboratorsDo collaboratorsDo = null;
	private static AssignmentGoalUiBinder uiBinder = GWT.create(AssignmentGoalUiBinder.class);
	
	MessageProperties i18n = GWT.create(MessageProperties.class);
	
	String classpageId = null;
	
	String unitId = null;
	
	List<InsightsUserDataDo> list = null;
	
	
	@UiField Label lblStudentsList, lblPleaseWait;
	
	@UiField HTMLPanel panelAssignmentList;
	
	int pageSize = 20;
	int pageNum = 0;
	
	int displayLimit = 10;
	int displayStartFrom = 0;
	
	public interface AssignmentGoalUiBinder extends UiBinder<Widget, AssignmentGoalView> {}
	
	public AssignmentGoalView(CollaboratorsDo collaboratorsDo){
		initWidget(uiBinder.createAndBindUi(this));
		this.collaboratorsDo = collaboratorsDo; 
		setStaticTexts();
		setPresenter(new AssignmentGoalPresenter(this));
		
		AssignmentGoalCBundle.INSTANCE.css().ensureInjected();
		
		Event.addNativePreviewHandler(new NativePreviewHandler() {
			public void onPreviewNativeEvent(NativePreviewEvent event) {
	        
	        }
	    });
		
		classpageId = AppClientFactory.getPlaceManager().getRequestParameter("classpageid") != null ? AppClientFactory.getPlaceManager().getRequestParameter("classpageid") : null;
		unitId = AppClientFactory.getPlaceManager().getRequestParameter("uid") != null ? AppClientFactory.getPlaceManager().getRequestParameter("uid") : null;
		
		
		getPresenter().getAnalyticData(collaboratorsDo.getGooruUid(), classpageId, pageSize, pageNum, unitId);
		
		AppClientFactory.getEventBus().addHandler(DisplayNextSetAssignmentsEvent.TYPE,
				handler);
	}
	
	public void setStaticTexts(){
		lblStudentsList.setText(collaboratorsDo.getFirstName() + " " + collaboratorsDo.getLastName());
		StringUtil.setAttributes(lblStudentsList.getElement(), collaboratorsDo.getGooruUid(), null, null);
		
//		setAssignments();
	}
	@Override
	public void setAssignments(List<InsightsUserDataDo> list){
		this.list = list;
		if (list !=null && list.size() > 0){
			lblPleaseWait.setVisible(false);
			for (int i=displayStartFrom; i<displayLimit; i++){
				if (list.get(i) != null && list.get(i).getTitle() != null){
					GoalViewVc goalsVc = new GoalViewVc(""+(i+1), list.get(i)) {
					};
					panelAssignmentList.add(goalsVc);
				}
			}
		}else{
			//show messaging...
			lblPleaseWait.setText(i18n.GL2206());
		}
	}
	
	public void displayNextSet(int displayStartFrom, String type){
		if (type.equalsIgnoreCase("next")){
			displayLimit = this.displayStartFrom + displayLimit;
		}else{
			displayLimit = this.displayStartFrom - displayLimit;
		}
		this.displayStartFrom = displayStartFrom;
		System.out.println("displayStartFrom : "+displayStartFrom);
		System.out.println("this.displayStartFrom : "+this.displayStartFrom);
		System.out.println("this.displayLimit : "+this.displayLimit);
		setAssignments(this.list);
	}
	
	DisplayNextSetAssignmentsHandler handler = new DisplayNextSetAssignmentsHandler() {
		
		@Override
		public void displayNextSetFrom(int offSet, String type) {
			displayNextSet(offSet, type);
		}
	};
	
}
