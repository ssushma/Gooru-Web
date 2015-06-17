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
package org.ednovo.gooru.client.mvp.gshelf.util;

import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.client.SimpleRunAsyncCallback;
import org.ednovo.gooru.client.uc.H3Panel;
import org.ednovo.gooru.client.uc.suggestbox.widget.Paragraph;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public abstract class ContentWidgetWithMove extends Composite {

	private static ContentWidgetWithMoveUiBinder uiBinder = GWT
			.create(ContentWidgetWithMoveUiBinder.class);

	interface ContentWidgetWithMoveUiBinder extends
			UiBinder<Widget, ContentWidgetWithMove> {
	}
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	@UiField Label lblTopArrow,lblDownArrow;
	@UiField TextBox txtMoveTextBox;
	@UiField H3Panel h3CourseTitle;
	@UiField InlineLabel spnUnitsCount,spnLessonsCount,spnCollectionsCount,spnAssessmentsCount,spnResourcesCount,spnQuestionsCount;
	@UiField HTMLPanel pnlTitleContainer;
	@UiField Paragraph pTitle;
	
	final String COURSE="Course",UNIT="Unit",LESSON="Lesson",FOLDER="Folder",COLLECTION="Collection";
	
	String type;
	/**
	 * This constructor is used to set data.
	 * @param index
	 * @param type
	 */
	public ContentWidgetWithMove(int index,String type,FolderDo folderObj) {
		initWidget(uiBinder.createAndBindUi(this));
		this.type=type;
		
		if(folderObj.getTitle()!=null){
			pTitle.setText(folderObj.getTitle());
		}
		
		lblTopArrow.addClickHandler(new ArrowClickHandler(false));
		lblDownArrow.addClickHandler(new ArrowClickHandler(true));
		spnResourcesCount.setVisible(false);
		spnQuestionsCount.setVisible(false);
		setData();
		if(COURSE.equalsIgnoreCase(type)){
			h3CourseTitle.setText(i18n.GL0326()+" "+(index+1));
		}else if(UNIT.equalsIgnoreCase(type)){
			spnUnitsCount.setVisible(false);
			h3CourseTitle.setText(i18n.GL3281()+" "+(index+1));
		}else if(LESSON.equalsIgnoreCase(type)){
			spnUnitsCount.setVisible(false);
			spnLessonsCount.setVisible(false);
			h3CourseTitle.setText(i18n.GL0910()+" "+(index+1));
		}else if(FOLDER.equalsIgnoreCase(type)){
			spnUnitsCount.setVisible(false);
			spnLessonsCount.setVisible(false);
			h3CourseTitle.setText(i18n.GL1501()+" "+(index+1));
		}else if(COLLECTION.equalsIgnoreCase(type)){
			spnResourcesCount.setVisible(true);
			spnQuestionsCount.setVisible(true);
			spnUnitsCount.setVisible(false);
			spnLessonsCount.setVisible(false);
			spnCollectionsCount.setVisible(false);
			spnAssessmentsCount.setVisible(false);
			h3CourseTitle.setText(i18n.GL0645()+" "+(index+1));
		}
		txtMoveTextBox.getElement().setAttribute("index",index+"");
	}
	/**
	 * This method is used to set count for Units,Lessons,Collections and Assessments.
	 */
	public void setData(){
		spnUnitsCount.setText(i18n.GL3279()+"( )");
		spnLessonsCount.setText(i18n.GL3280()+"( )");
		spnCollectionsCount.setText(i18n.GL1754()+"( )");
		spnAssessmentsCount.setText(i18n.GL1325()+"( )");
		spnResourcesCount.setText(i18n.GL1755()+"( )");
		spnQuestionsCount.setText(i18n.GL2290()+"( )");
	}
	/**
	 * This inner class will handle the click event on the Arrows
	 */
	class ArrowClickHandler implements ClickHandler{
		boolean isDownArrow;
		ArrowClickHandler(boolean isDownArrow){
			this.isDownArrow=isDownArrow;
		}
		@Override
		public void onClick(ClickEvent event) {
			GWT.runAsync(new SimpleRunAsyncCallback() {
				@Override
				public void onSuccess() {
					String movingPosition=txtMoveTextBox.getText().toString().trim();
					String currentWidgetPosition=txtMoveTextBox.getElement().getAttribute("index");
					if(!movingPosition.isEmpty()){
						moveWidgetPosition(movingPosition,currentWidgetPosition,isDownArrow);
					}
				}
			});
		}
	}
	
	public H3Panel getH3Panel(){
		return h3CourseTitle;
	}
	public TextBox getTextBox(){
		return txtMoveTextBox;
	}
	public HTMLPanel getTitleContainer(){
		return pnlTitleContainer;
	}
	public abstract void moveWidgetPosition(String movingPosition,String currentWidgetPosition,boolean isDownArrow);
}
