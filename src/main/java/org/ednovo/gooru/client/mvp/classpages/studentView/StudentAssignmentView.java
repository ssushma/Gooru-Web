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
package org.ednovo.gooru.client.mvp.classpages.studentView;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.uc.PaginationButtonUc;
import org.ednovo.gooru.shared.model.content.AssignmentsListDo;
import org.ednovo.gooru.shared.model.content.AssignmentsSearchDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.util.DataLogEvents;
import org.ednovo.gooru.shared.util.GwtUUIDGenerator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
/**
 * @fileName : StudentAssignmentView.java
 *
 * @description : This is student Assignment View.
 *
 * @version : 1.0
 *
 * @date: 27-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class StudentAssignmentView extends BaseViewWithHandlers<StudentAssignmentUiHandlers> implements IsStudentAssignmentView ,ClickHandler{
	
	private static StudentAssignmentViewUiBinder uiBinder = GWT.create(StudentAssignmentViewUiBinder.class);

	interface StudentAssignmentViewUiBinder extends UiBinder<Widget, StudentAssignmentView> {    

	}
	
	@UiField Label mainTitleLbl,noAssignmentMsg;
	
	@UiField HTMLPanel contentpanel;
	
	/*@UiField HTMLEventPanel backToEditPanel;*/
	
	@UiField Button backToEditPanel;
	
	@UiField FlowPanel paginationPanel;
	
	@UiField Image studentViewImage;

	private String DEFAULT_CLASSPAGE_IMAGE = "images/Classpage/default-classpage.png";
	
	private int pageSize = 10;
	
	private int pageNum = 1;
	
	private int pos = 1;
	
	private int noOfItems = 10;
	
	private int assignmentCount=0;
	
	private String classPageId=null;
	
	private String source;
	
	private boolean isClicked=false;
	
	private static final String PREVIOUS = "PREVIOUS";

	private static final String NEXT = "NEXT";
	
	/**
	 * Class constructor.
	 */
	@Inject
	public StudentAssignmentView() {
		setWidget(uiBinder.createAndBindUi(this));
//		backToEditPanel.setVisible(false);
		backToEditPanel.getElement().setId("btnBackToEdit");
	}
	/**
	 * This method is used to get the content panel.
	 */
	public HTMLPanel getContentpanel() {
		return contentpanel;
	}
	/**
	 * GWTP will call setInSlot when a child presenter asks to be added under this view. 
	 */
	@Override
	public void setInSlot(Object slot, Widget content) {
	
			if (slot == StudentAssignmentUiHandlers.SLOT_assignment) {
				contentpanel.clear();
				if(content!=null)
				contentpanel.add(content);	
			}
		else
		{
			super.setInSlot(slot, content);
		}
	}
	/**
	 * This method adds some content in a specific slot of the Presenter. 
	 */
	@Override
	public void addToSlot(Object slot, Widget content) {
		
		if(slot==StudentAssignmentUiHandlers.SLOT_assignment){
			if(content!=null){
				
				contentpanel.add(content);
			}
		}else{
			super.addToSlot(slot, content);
		}
		
	}
	
	/**
	 * This method is used to get the main title label.
	 */
	public Label getMainTitleLbl() {
		return mainTitleLbl;
	}
	
    
	/**
	 * This method is used to get the back button.
	 */
	public Button getBackToEditPanel() {
		return backToEditPanel;
	}
	/**
	 * This method is used to set the Data.
	 */
	@Override
	public void setData(CollectionDo result) {
		
		mainTitleLbl.setText(result.getTitle());
	    String url=result.getThumbnails().getUrl() ==null ? null : result.getThumbnails().getUrl();
		if (url == null || url.endsWith("null") || url.contains("null") || url.endsWith("/")){
			studentViewImage.setUrl(DEFAULT_CLASSPAGE_IMAGE);
		}else{
		   studentViewImage.setUrl(result.getThumbnails().getUrl());
		}
//		for(int i=0;i<result.getCollectionItems().size();i++){
//			CollectionDo newCollectionDo = new CollectionDo();
//			setAssignmentData(result.getCollectionItems().get(i));
//			
//		}
		getUiHandlers().getAssignmentsList(pageNum+"", pageSize+"");
		
	}
	/**
	 * @function onClickHandler 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This will handle the click event on the backToEditPanel
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("backToEditPanel")
	public void onClickHandler(ClickEvent event){
		//getPreviousPage();
		if(isClicked){
			isClicked=false;
		String pageSize=Cookies.getCookie("pageSize");
		String classpageid=Cookies.getCookie("classpageid");
		String pageNum=Cookies.getCookie("pageNum");
		String pos=Cookies.getCookie("pos");
		
		if(AppClientFactory.getPlaceManager().getRequestParameter("source").equalsIgnoreCase("T")){
//			AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.TEACH);
		}
		else if(AppClientFactory.getPlaceManager().getRequestParameter("source").equalsIgnoreCase("E")){
			
			Map<String, String> params=new HashMap<String, String>();
			params.put("pageSize", pageSize);
			params.put("classpageid", classpageid);
			params.put("pageNum", pageNum);
			params.put("pos", pos);
			
			AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.EDIT_CLASSPAGE,params,true);
		}
		backToEditPanel.setVisible(false);
		}
	}
	/**
	 * 
	 * @function insertAssignment 
	 * 
	 * @created_date : Nov 22, 2013
	 * 
	 * @description : This method is used to insert the assignment.
	 * 
	 * @parm(s) : @param assignmentsSearchDo
	 * @parm(s) : @param isNew
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 */
	public void insertAssignment(AssignmentsSearchDo assignmentsSearchDo, boolean isNew){
		AssignmentsView assignmentTabView = new AssignmentsView(assignmentsSearchDo, isNew);
		contentpanel.add(assignmentTabView);		
	}
	/**
	 * This method is used to set the meta Data.
	 */
	@Override
	public void metaData(String classPageId,String pageNum,String pageSize, String source, String pos) {
		paginationPanel.clear();
		this.classPageId=classPageId;
		this.pageNum=Integer.parseInt(pageNum);
		this.pageSize=Integer.parseInt(pageSize);
		this.pos = Integer.parseInt(pos);
		this.source = source;
		getUiHandlers().asyMethodCall();
		
		DataLogEvents.classpageView(GwtUUIDGenerator.uuid(), "classpage-view", classPageId, AppClientFactory.getLoggedInUser().getGooruUId(), System.currentTimeMillis(), System.currentTimeMillis(),"",0L, AppClientFactory.getLoggedInUser().getToken()	,"start");
	}
	/**
	 * This method is used to list all assignments.
	 */
	@Override
	public void listAssignments(AssignmentsListDo result) {
		if(result.getSearchResults().size()>0){
			contentpanel.clear();
			for (int i=0; i<result.getSearchResults().size(); i++){
				boolean isDisplay = i == 0 ? true : false;
				insertAssignment(result.getSearchResults().get(i), isDisplay);
			}
			//loadingPanel.setVisible(false);
			isClicked=true;
			paginationPanel.clear();
			assignmentCount = (result.getTotalHitCount() / noOfItems) + ((result.getTotalHitCount()  % noOfItems) > 0 ? 1 : 0);
		
			if (assignmentCount > 1) {
				if (pos > 1) {
					paginationPanel.add(new PaginationButtonUc(pos-1, PREVIOUS, this));
				}
				int page = pos < 10 ? 1 : pos - 10;
				for (int count = 0; count < 10 && page <= assignmentCount; page++, ++count) {
					paginationPanel.add(new PaginationButtonUc(page, page == pos, this));
				}
				if (pos < assignmentCount) {
					paginationPanel.add(new PaginationButtonUc(pos + 1, NEXT, this));
				}
			 }
		}else{
			//noAssignmentsMessagePanel.setVisible(true);
			//loadingPanel.setVisible(false);
		}
		
	}
	/**
	 * This will handle the click event for the pagination.
	 */
	@Override
	public void onClick(ClickEvent event) {
		if (event.getSource() instanceof PaginationButtonUc) {
			int pagenumber = ((PaginationButtonUc) event.getSource()).getPage();
			
			pageNum = (pagenumber -1) * pageSize;
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("id", classPageId);
			params.put("pageSize", pageSize+"");
			params.put("pageNum", pageNum+"");
			params.put("source", source);
			params.put("pos", pagenumber+"");
			AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.STUDENT, params,true);
			
			
		} else {
		}
	}
	/**
	 * This method is used to clear.
	 */
	@Override
	public void clearAll() {
		contentpanel.clear();
		noAssignmentMsg.setVisible(false);
		mainTitleLbl.setText("");
	}
	/**
	 * This method is used to display the message when there are no assignments.
	 */
	@Override
	public void noAssignments() {
		isClicked=true;
		noAssignmentMsg.getElement().getStyle().setDisplay(Display.BLOCK);
	}

	/*public final native void getPreviousPage() -{
	 
	 window.history.back();
	    
	  }-;*/

	
	}
	

