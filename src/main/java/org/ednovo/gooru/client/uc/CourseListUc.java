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
package org.ednovo.gooru.client.uc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.CollectionEditResourceCBundle;
import org.ednovo.gooru.client.mvp.shelf.event.AddCourseEvent;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.code.LibraryCodeDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : CourseListUc.java
 *
 * @description : This class is used to set the courses list.
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class CourseListUc extends PopupPanel {

	private static CourseListUcUiBinder uiBinder = GWT
			.create(CourseListUcUiBinder.class);

	interface CourseListUcUiBinder extends UiBinder<Widget, CourseListUc> {
	}

/*	@UiField Anchor fromweb;
*/	
/*	@UiField HTMLEventPanel urlTabButton;
*/	
	@UiField static FlowPanel contentPanel;
	
	@UiField HTMLPanel buttonsPanel,addCourseBtnPanel,loadingPanel;
	
	@UiField static HTMLPanel addResourceTabContainer;
	
	@UiField Button cancelCourseBtn;
	
	@UiField BlueButtonUc addCourseBtnLbl;
	
	private int courseCode;
	
	HTMLEventPanel subjectWidget;
	
    HTMLPanel subjectPanel;
	
	List<LibraryCodeDo> libraryCode;
	
	CollectionDo collectionDo;
	
	private String courseName, collectionId;
	
	private boolean isSelected;
	
	Map<String, ArrayList<String>> map;
	
	
	@UiField CollectionEditResourceCBundle res;
	/**
	 * Class constructor.
	 */
	public CourseListUc(CollectionDo collectionDo ) {
		setWidget(uiBinder.createAndBindUi(this));
		this.collectionDo=collectionDo;
		res = CollectionEditResourceCBundle.INSTANCE;
		CollectionEditResourceCBundle.INSTANCE.css().ensureInjected();
		this.setGlassStyleName(res.css().loginPopupGlassStyle());
	  	this.getElement().getStyle().setZIndex(99999);
		setGlassEnabled(true);
		isSelected=false;
		this.center();
		this.show();
		loadingPanel.setVisible(true);
		setCourseData();
		collectionId=collectionDo.getGooruOid();
		Window.enableScrolling(false);
	}
	
	
	/**
	 * @function setCourseData 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is used to set the course data.
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private void setCourseData() {
		AppClientFactory.getInjector().getTaxonomyService().getCourse(new SimpleAsyncCallback<List<LibraryCodeDo>>() {

			@Override
			public void onSuccess(List<LibraryCodeDo> result) {
				setCourseList(result);
				loadingPanel.setVisible(false);
			}
		});
	}


	/**
	 * @function setCourseList 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is used to set the course list.
	 * 
	 * @parm(s) : @param libraryCode
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setCourseList(final List<LibraryCodeDo> libraryCode) {
		this.libraryCode=libraryCode;
		Map<String,Integer> subjectList = new HashMap<String, Integer>();
		subjectPanel=new HTMLPanel("");
		for(int i = 0; i < libraryCode.size(); i++) {
			String subjectName = libraryCode.get(i).getLabel();
		    subjectWidget = new HTMLEventPanel(subjectName);
			subjectWidget.setStyleName(res.css().buttonDeSelected());
			subjectWidget.getElement().setId(subjectName);
			subjectList.put(subjectName, i);
			subjectPanel.add(subjectWidget);
			if(i==0) {
				List<LibraryCodeDo> libraryCodeDo = libraryCode.get(i).getNode();
				subjectWidget.addStyleName(res.css().collectionInfobuttonSelected());
				setCourseData(libraryCodeDo);
			}
		}
		addResourceTabContainer.add(subjectPanel);
		final Map<String,Integer> subjects = subjectList;
		
		Iterator<Widget> widgets = subjectPanel.iterator();
		while (widgets.hasNext()) {
			final Widget widget = widgets.next();
			if (widget instanceof HTMLEventPanel) {
				((HTMLEventPanel) widget).addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						int subjectCode = subjects.get(widget.getElement().getId());
						final Iterator<Widget> widgetsPanel = subjectPanel.iterator();
						while (widgetsPanel.hasNext()) {
							 widgetsPanel.next().removeStyleName(res.css().collectionInfobuttonSelected());
							}
						if(subjectCode==0){
							 widget.addStyleName(res.css().buttonDeSelected());
						 }
						widget.addStyleName(res.css().collectionInfobuttonSelected());
						setCourseData(libraryCode.get(subjectCode).getNode());
					}
				});
			}
		}
	}
	/**
	 * @function setCourseData 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is used to set the course data.
	 * 
	 * 
	 * @parm(s) : @param libraryCodeDo
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private void setCourseData(final List<LibraryCodeDo> libraryCodeDo) {
		final HTMLPanel panel=new HTMLPanel("");
		panel.clear();
		contentPanel.clear();
		Map<String,Integer> courseList = new HashMap<String, Integer>();
		for(int j=0; j<libraryCodeDo.size(); j++) {
			String courseListValues=libraryCodeDo.get(j).getLabel();
			Label courseValues=new Label(courseListValues);
			courseValues.setStyleName(res.css().infoCourseListText());
			courseValues.getElement().setId(courseListValues);
			courseList.put(courseListValues, j);
			panel.add(courseValues);
			
		}
		contentPanel.add(panel);
		final Map<String,Integer> course = courseList;
		Iterator<Widget> widgets = panel.iterator();
		while (widgets.hasNext()) {
			final Widget widget = widgets.next();
			if (widget instanceof Label) {
				((Label) widget).addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						isSelected=true;
						int subjectCode = course.get(widget.getElement().getId());
					    courseName=libraryCodeDo.get(subjectCode).getLabel();
					    
					    courseCode=libraryCodeDo.get(subjectCode).getCodeId();
					    final Iterator<Widget> widgetsPanel = panel.iterator();
						
						while (widgetsPanel.hasNext()) {
							 widgetsPanel.next().removeStyleName(res.css().collectionInfoCourseList());
						}
						widget.addStyleName(res.css().collectionInfoCourseList());
						
					}
				});
			}
		}

	}
	/**
	 * @function setDefaultCourseData 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is used to set the default course data.
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setDefaultCourseData(){
		collectionId=collectionDo.getGooruOid();
		isSelected=false;
		for(int i = 0; i < libraryCode.size(); i++) {
			if(i==0) {
				List<LibraryCodeDo> libraryCodeDo = libraryCode.get(i).getNode();
				setCourseData(libraryCodeDo);
			}
		}
		
		final Iterator<Widget> widgetsPanel = subjectPanel.iterator();
		while (widgetsPanel.hasNext()) {
			 widgetsPanel.next().removeStyleName(res.css().collectionInfobuttonSelected());
			 subjectPanel.getWidget(0).addStyleName(res.css().collectionInfobuttonSelected());
			}
	}
	
	/**
	 * @function onClickClose 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This will handle the click event on the cancel button.
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("cancelCourseBtn")
	public void onClickClose(ClickEvent clickEvent){
		hide();
		Window.enableScrolling(true);
	}
	/**
	 * @function onAddCourseBtnClick 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This will handle the click event on the add course label.
	 * 
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("addCourseBtnLbl")
	public void onAddCourseBtnClick(ClickEvent clickEvent){
		MixpanelUtil.mixpanelEvent("Organize_Add_Course");
		String oldCourseId = "";
		String courseId= Integer.toString(courseCode);
		if(isSelected){
			System.out.println("ininininin");
			collectionId=collectionDo.getGooruOid();
			for (CodeDo code : collectionDo.getTaxonomySet()) {
				if(code.getDepth()==2){
					oldCourseId=Integer.toString(code.getCodeId());
					updateCourse(collectionId, oldCourseId, "delete");
				}
				
			}
			updateCourse(collectionId, courseId, "add");
			AppClientFactory.fireEvent(new AddCourseEvent(courseName,courseId));
			hide();
			Window.enableScrolling(true);
		}else{
			new AlertContentUc(MessageProperties.GL0061, "Please select course.");
		}
		
		
	}
	/**
	 * @function updateCourse 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This method is used to update the course details.
	 * 
	 * 
	 * @parm(s) : @param collectionId
	 * @parm(s) : @param courseCode
	 * @parm(s) : @param action
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void updateCourse(String collectionId, String courseCode, String action) {
	  	
		AppClientFactory.getInjector().getResourceService().updateCollectionMetadata(collectionId, null, null, null, null, null, courseCode, null, null, action, new SimpleAsyncCallback<CollectionDo>() {

			@Override
			public void onSuccess(CollectionDo result) {	
				collectionDo=result;
			}
		});

	}
	
	
}
