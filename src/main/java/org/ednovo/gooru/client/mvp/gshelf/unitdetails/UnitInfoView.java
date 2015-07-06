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
package org.ednovo.gooru.client.mvp.gshelf.unitdetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.code.CourseSubjectDo;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.client.mvp.gshelf.util.CourseGradeWidget;
import org.ednovo.gooru.client.mvp.gshelf.util.LiPanelWithClose;
import org.ednovo.gooru.client.uc.LiPanel;
import org.ednovo.gooru.client.uc.UlPanel;
import org.ednovo.gooru.client.util.SetStyleForProfanity;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * @author Search Team
 *
 */
public class UnitInfoView extends BaseViewWithHandlers<UnitInfoUiHandlers> implements IsUnitInfoView {

	private static UnitInfoViewUiBinder uiBinder = GWT.create(UnitInfoViewUiBinder.class);
	
	@UiTemplate("UnitInfoView.ui.xml")
	interface UnitInfoViewUiBinder extends UiBinder<Widget, UnitInfoView> {
	}	
	
	public MessageProperties i18n = GWT.create(MessageProperties.class);

	@UiField HTMLPanel unitInfo,pnlGradeContainer;
	@UiField UlPanel ulMainGradePanel,ulSelectedItems;
	@UiField Button saveCourseBtn,nextUnitBtn;
	@UiField TextBox unitTitle;
	@UiField Label lblErrorMessage,lblErrorMessageForBig,lblErrorMessageForEssential;
	@UiField TextArea txaBigIdeas,txaEssentialQuestions;
	
	Map<String, ArrayList<String>> selectedValues=new HashMap<String,ArrayList<String>>();
	
	CourseGradeWidget courseGradeWidget;
	public FolderDo courseObj;
	final String ACTIVE="active";
	/**
	 * Class constructor 
	 * @param eventBus {@link EventBus}
	 */
	@Inject
	public UnitInfoView() {
		setWidget(uiBinder.createAndBindUi(this));
		unitInfo.getElement().setId("pnlCourseInfo");
		pnlGradeContainer.getElement().setId("pnlGradeContainer");
		ulMainGradePanel.getElement().setId("ulMainGradePanel");
		unitTitle.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				SetStyleForProfanity.SetStyleForProfanityForTextBox(unitTitle, lblErrorMessage, false);
			}
		});
		txaBigIdeas.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				SetStyleForProfanity.SetStyleForProfanityForTextArea(txaBigIdeas, lblErrorMessageForBig, false);
			}
		});
		txaEssentialQuestions.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				SetStyleForProfanity.SetStyleForProfanityForTextArea(txaEssentialQuestions, lblErrorMessageForEssential, false);
			}
		});
	}
	
	/**
	 * This method will display the Grades according to the subject
	 */
	@Override
	public void showCourseDetailsBasedOnSubjectd(List<CourseSubjectDo> libraryCodeDo,final String selectedText) {
		pnlGradeContainer.clear();
		courseGradeWidget=new CourseGradeWidget(libraryCodeDo,selectedValues.get(selectedText)) {
			@Override
			public void setSelectedGrade(final String lblvalue, final long codeId,boolean isAdd) {
				if(isAdd){
					final LiPanelWithClose liPanelWithClose=new LiPanelWithClose(lblvalue);
					liPanelWithClose.getCloseButton().addClickHandler(new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							//This will remove the selected value when we are trying by close button
							for(Iterator<Map.Entry<String,ArrayList<String>>>it=selectedValues.entrySet().iterator();it.hasNext();){
							     Map.Entry<String, ArrayList<String>> entry = it.next();
							     if(entry.getValue().contains(lblvalue)){
							    	 entry.getValue().remove(lblvalue);
							     }
							 }
							removeGradeWidget(courseGradeWidget.getGradePanel(),codeId);
							liPanelWithClose.removeFromParent();
						}
					});
					selectedValues.get(selectedText).add(lblvalue);
					liPanelWithClose.setId(codeId);
					ulSelectedItems.add(liPanelWithClose);
				}else{
					if(selectedValues.get(selectedText).contains(lblvalue)){
						selectedValues.get(selectedText).remove(lblvalue);
					}
					removeGradeWidget(ulSelectedItems,codeId);
				}
			}
		};
		pnlGradeContainer.add(courseGradeWidget);
	}
	/**
	 * This method will remove the widget based on the codeId in the UlPanel
	 * @param ulPanel
	 * @param codeId
	 */
	public void removeGradeWidget(UlPanel ulPanel,long codeId){
		Iterator<Widget> widgets=ulPanel.iterator();
		while (widgets.hasNext()) {
			Widget widget=widgets.next();
			if(widget instanceof LiPanelWithClose){
				LiPanelWithClose obj=(LiPanelWithClose) widget;
				if(obj.getId()==codeId){
					obj.removeFromParent();
				}
			}
			if(widget instanceof LiPanel){
				LiPanel obj=(LiPanel) widget;
				if(obj.getCodeId()==codeId){
					obj.removeStyleName("active");
				}
			}
		}
	}

	@Override
	public void setCourseList(List<CourseSubjectDo> libraryCode) {
		selectedValues.clear();
		ulMainGradePanel.clear();
		if (libraryCode.size()>0) {
			for (CourseSubjectDo libraryCodeDo : libraryCode) {
				String titleText=libraryCodeDo.getName().trim();
				selectedValues.put(titleText, new ArrayList<String>());
				LiPanel liPanel=new LiPanel();
				Anchor title=new Anchor(titleText);
				title.addClickHandler(new ClickOnSubject(titleText,liPanel,libraryCodeDo.getSubjectId()));
				liPanel.add(title);
				ulMainGradePanel.add(liPanel);
			}
		}
	}
	/**
	 * This inner class is used to get selected subjects grades
	 */
	class ClickOnSubject implements ClickHandler{
		String selectedText;
		LiPanel liPanel;
		int subjectId;
		ClickOnSubject(String selectedText,LiPanel liPanel,int subjectId){
			this.selectedText=selectedText;
			this.liPanel=liPanel;
			this.subjectId=subjectId;
		}
		@Override
		public void onClick(ClickEvent event) {
			if(liPanel.getStyleName().contains(ACTIVE)){
				if(selectedValues.get(selectedText).size()>0){
					getUiHandlers().callCourseBasedOnSubject(subjectId, selectedText);
				}else{
					liPanel.removeStyleName(ACTIVE);
				}
			}else{
				liPanel.addStyleName(ACTIVE);
				getUiHandlers().callCourseBasedOnSubject(subjectId, selectedText);
			}
		}
	}
	
	@UiHandler("saveCourseBtn")
	public void clickOnSaveCourseBtn(ClickEvent saveCourseEvent){
		getUiHandlers().checkProfanity(unitTitle.getText().trim(),false,0);
	}
	
	@UiHandler("nextUnitBtn")
	public void clickOnNextUnitBtn(ClickEvent saveCourseEvent){
		getUiHandlers().checkProfanity(unitTitle.getText().trim(),true,0);
	}
	/**
	 * This method is used to call create and update API
	 * @param index
	 * @param isCreate
	 */
	@Override
	public void callCreateAndUpdate(boolean isCreate,boolean result,int index){
		if(result && index==0){
			SetStyleForProfanity.SetStyleForProfanityForTextBox(unitTitle, lblErrorMessage, result);
		}else if(result && index==1){
			SetStyleForProfanity.SetStyleForProfanityForTextArea(txaBigIdeas, lblErrorMessageForBig, result);
		}else if(result && index==2){
			SetStyleForProfanity.SetStyleForProfanityForTextArea(txaEssentialQuestions, lblErrorMessageForEssential, result);
		}else{
			if(index==0){
				getUiHandlers().checkProfanity(txaBigIdeas.getText().trim(),isCreate,1);
			}else if(index==1){
				getUiHandlers().checkProfanity(txaEssentialQuestions.getText().trim(),isCreate,2);
			}else if(index==2){
				String id= AppClientFactory.getPlaceManager().getRequestParameter("o2",null);
				if(id!=null){
					getUiHandlers().updateCourseDetails(unitTitle.getText(),id,isCreate);
				}else{
					getUiHandlers().createAndSaveCourseDetails(unitTitle.getText(),isCreate);
				}
			}
		}
	}

	@Override
	public void setCouseData(FolderDo courseObj) {
		this.courseObj=courseObj;
		unitTitle.setText(courseObj==null?i18n.GL3364():courseObj.getTitle());
	}
}
