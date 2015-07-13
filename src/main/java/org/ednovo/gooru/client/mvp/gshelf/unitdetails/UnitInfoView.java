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
import org.ednovo.gooru.application.shared.model.folder.CreateDo;
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

	@UiField HTMLPanel unitInfo,pnlGradeContainer,pnlGradeDescContainer;
	@UiField UlPanel ulMainGradePanel,ulSelectedItems;
	@UiField Button saveUnitBtn,nextCreateLessonBtn,taxonomyBtn;
	@UiField TextBox unitTitle;
	@UiField Label lblErrorMessage,lblErrorMessageForBig,lblErrorMessageForEssential;
	@UiField TextArea txaBigIdeas,txaEssentialQuestions;
	
	Map<Integer, ArrayList<String>> selectedValues=new HashMap<Integer,ArrayList<String>>();
	
	CourseGradeWidget courseGradeWidget;
	public FolderDo courseObj;
	final String ACTIVE="active";
	
	private static final String UNIT = "Unit";
	
	LiPanel tempLiPanel=null;
	List<Integer> firstSelectedSubject = new ArrayList<Integer>();
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
		taxonomyBtn.getElement().setId("taxonomyBtn");
		taxonomyBtn.addClickHandler(new OnClickTaxonomy());
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
	public void showCourseDetailsBasedOnSubjectd(final List<CourseSubjectDo> libraryCodeDo,final int selectedId) {
		pnlGradeContainer.clear();
		courseGradeWidget=new CourseGradeWidget(libraryCodeDo,selectedValues.get(selectedId),"domain") {
			@Override
			public void setSelectedGrade(final CourseSubjectDo courseObj, final long codeId,boolean isAdd) {
				for(CourseSubjectDo courseSubjectDo : libraryCodeDo) {
					if(courseSubjectDo.getSubdomainId()==codeId){
						pnlGradeDescContainer.getElement().setInnerHTML(courseSubjectDo.getDescription());
					}
				}
				firstSelectedSubject.add((int)codeId);
				if(isAdd){
					final LiPanelWithClose liPanelWithClose=new LiPanelWithClose(courseObj.getName());
					liPanelWithClose.getCloseButton().addClickHandler(new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							//This will remove the selected value when we are trying by close button
							for(Iterator<Map.Entry<Integer,ArrayList<String>>>it=selectedValues.entrySet().iterator();it.hasNext();){
							     Map.Entry<Integer, ArrayList<String>> entry = it.next();
							     if(entry.getValue().contains(courseObj.getName())){
							    	 entry.getValue().remove(courseObj.getName());
							     }
							 }
							removeGradeWidget(courseGradeWidget.getGradePanel(),codeId);
							liPanelWithClose.removeFromParent();
						}
					});
					selectedValues.get(selectedId).add(courseObj.getName());
					liPanelWithClose.setId(codeId);
					liPanelWithClose.setName(courseObj.getName());
					liPanelWithClose.setRelatedId(courseObj.getCourseId());
					liPanelWithClose.setRelatedSubjectId(courseObj.getSubjectId());
					ulSelectedItems.add(liPanelWithClose);
				}else{
					if(selectedValues.get(selectedId).contains(courseObj.getName())){
						selectedValues.get(selectedId).remove(courseObj.getName());
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
	public void setCourseList(List<CourseSubjectDo> libraryCode,int selectedId) {
		ulMainGradePanel.clear();
		if (libraryCode.size()>0) {
			for (CourseSubjectDo libraryCodeDo : libraryCode) {
				String titleText=libraryCodeDo.getName().trim();
				if(!selectedValues.containsKey(libraryCodeDo.getCourseId())){
					selectedValues.put(libraryCodeDo.getCourseId(), new ArrayList<String>());
				}
				LiPanel liPanel=new LiPanel();
				Anchor title=new Anchor(titleText);
				title.addClickHandler(new ClickOnSubject(titleText,liPanel,libraryCodeDo.getCourseId()));
				liPanel.add(title);
				if(selectedId==libraryCodeDo.getCourseId()){
					liPanel.addStyleName(ACTIVE);
					tempLiPanel=liPanel;
					getUiHandlers().getDomainsBasedOnCourseId(libraryCodeDo.getCourseId(), libraryCodeDo.getCourseId());
				}
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
		int courseId;
		ClickOnSubject(String selectedText,LiPanel liPanel,int courseId){
			this.selectedText=selectedText;
			this.liPanel=liPanel;
			this.courseId=courseId;
		}
		@Override
		public void onClick(ClickEvent event) {
			if(tempLiPanel!=null){
				tempLiPanel.removeStyleName(ACTIVE);
				tempLiPanel=liPanel;
			}else{
				tempLiPanel=liPanel;
			}
			if(liPanel.getStyleName().contains(ACTIVE)){
				if(selectedValues.get(courseId).size()>0){
					getUiHandlers().getDomainsBasedOnCourseId(courseId, courseId);
				}else{
					liPanel.removeStyleName(ACTIVE);
				}
			}else{
				liPanel.addStyleName(ACTIVE);
				getUiHandlers().getDomainsBasedOnCourseId(courseId, courseId);
			}
		}
	}
	
	@UiHandler("saveUnitBtn")
	public void clickOnSaveUnitBtn(ClickEvent saveCourseEvent){
		getUiHandlers().checkProfanity(unitTitle.getText().trim(),false,0);
	}
	
	@UiHandler("nextCreateLessonBtn")
	public void clickOnNextLessonBtn(ClickEvent saveCourseEvent){
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
				CreateDo createOrUpDate=new CreateDo();
				createOrUpDate.setTitle(unitTitle.getText());
				createOrUpDate.setIdeas(txaBigIdeas.getText());
				createOrUpDate.setQuestions(txaEssentialQuestions.getText());
				createOrUpDate.setSubdomainIds(getSelectedSubDomainIds());
				String id= AppClientFactory.getPlaceManager().getRequestParameter("o2",null);
				if(id!=null){
					getUiHandlers().updateUnitDetails(createOrUpDate,id,isCreate,courseObj);
				}else{
					getUiHandlers().createAndSaveUnitDetails(createOrUpDate,isCreate,courseObj);
				}
			}
		}
	}
	/**
	 * This method is used to get the selected course id's
	 * @return
	 */
	public List<Integer> getSelectedSubDomainIds(){
		List<Integer> taxonomyCourseIds=new ArrayList<Integer>();
		Iterator<Widget> widgets=ulSelectedItems.iterator();
		List<CourseSubjectDo> courseList=new ArrayList<CourseSubjectDo>();
		while (widgets.hasNext()) {
			Widget widget=widgets.next();
			if(widget instanceof LiPanelWithClose){
				LiPanelWithClose obj=(LiPanelWithClose) widget;
				Integer intVal = (int)obj.getId();
				taxonomyCourseIds.add(intVal);
				CourseSubjectDo courseObj=new CourseSubjectDo();
				courseObj.setId((int)obj.getId());
				courseObj.setName(obj.getName());
				courseObj.setSubjectId(obj.getRelatedSubjectId());
				courseObj.setCourseId(obj.getRelatedId());
				courseList.add(courseObj);
			}
		}
		if(courseObj!=null)
		courseObj.setSubdomain(courseList);
		return taxonomyCourseIds;
	}

	@Override
	public void setCouseData(FolderDo courseObj) {
		if(courseObj!=null){
			this.courseObj=courseObj;
			txaBigIdeas.setText(courseObj.getIdeas()!=null?courseObj.getIdeas():"");
			txaEssentialQuestions.setText(courseObj.getQuestions()!=null?courseObj.getQuestions():"");
		}
		unitTitle.setText(courseObj==null?i18n.GL3364():courseObj.getTitle());
		ulSelectedItems.clear();
		firstSelectedSubject.clear();
		selectedValues.clear();
		//This will push the previous selected values to map
		if(courseObj!=null && courseObj.getSubdomain()!=null){
			//To set default selection if the user is already selected any subject
			firstSelectedSubject.add(courseObj.getSubdomain().get(0).getSubdomainId());
			getUiHandlers().callCourseBasedOnSubject(courseObj.getSubdomain().get(0).getSubjectId(),courseObj.getSubdomain().get(0).getCourseId());
			for (final CourseSubjectDo courseSubjectDo : courseObj.getSubdomain()) {
				if(selectedValues.containsKey(courseSubjectDo.getCourseId())){
					selectedValues.get(courseSubjectDo.getCourseId()).add(courseSubjectDo.getName());
				}else{
					selectedValues.put(courseSubjectDo.getCourseId(), new ArrayList<String>());
					selectedValues.get(courseSubjectDo.getCourseId()).add(courseSubjectDo.getName());
				}
				final LiPanelWithClose liPanelWithClose=new LiPanelWithClose(courseSubjectDo.getName());
				liPanelWithClose.getCloseButton().addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						for(Iterator<Map.Entry<Integer,ArrayList<String>>>it=selectedValues.entrySet().iterator();it.hasNext();){
						     Map.Entry<Integer, ArrayList<String>> entry = it.next();
						     if(entry.getValue().contains(courseSubjectDo.getName())){
						    	 entry.getValue().remove(courseSubjectDo.getName());
						     }
						 }
						removeGradeWidget(courseGradeWidget.getGradePanel(),courseSubjectDo.getId());
						liPanelWithClose.removeFromParent();
					}
				});
				liPanelWithClose.setId(courseSubjectDo.getId());
				liPanelWithClose.setName(courseSubjectDo.getName());
				liPanelWithClose.setRelatedId(courseSubjectDo.getCourseId());
				liPanelWithClose.setRelatedSubjectId(courseSubjectDo.getSubjectId());
				ulSelectedItems.add(liPanelWithClose);
			}
		}
		if(getUiHandlers().getMyCollectionsRightClusterPresenter().getFirstSelectedData()!=null){
			for (Map.Entry<Integer, Integer> entry : getUiHandlers().getMyCollectionsRightClusterPresenter().getFirstSelectedData().entrySet()) {
				firstSelectedSubject.add(entry.getKey());
				if(entry.getValue()!=null)
				getUiHandlers().callCourseBasedOnSubject(entry.getKey(),entry.getValue());
				break;
			}
		}
	}
	@Override
	public List<Integer> getFirstSelectedValue(){
		return firstSelectedSubject;
	}
	private class OnClickTaxonomy implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			getUiHandlers().invokeTaxonomyPopup(UNIT);
		}
	}
}
