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
package org.ednovo.gooru.client.mvp.folders.edit.tab.info;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.effects.FadeInAndOut;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.client.uc.AppMultiWordSuggestOracle;
import org.ednovo.gooru.client.uc.AppSuggestBox;
import org.ednovo.gooru.client.uc.CloseLabel;
import org.ednovo.gooru.client.uc.DownToolTipWidgetUc;
import org.ednovo.gooru.client.uc.GradeLabel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.code.LibraryCodeDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.StandardFo;
import org.ednovo.gooru.shared.model.search.SearchDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.Widget;
import com.tractionsoftware.gwt.user.client.ui.GroupedListBox;

/**
 * @author Search Team
 * 
 */
public class FolderInfoTabView extends BaseViewWithHandlers<FolderInfoTabUiHandlers> implements IsFolderInfoTabView, SelectionHandler<SuggestOracle.Suggestion> {

	@UiField
	GroupedListBox collectionCourseLst;

	@UiField
	Button addCourseBtn, addStandardBtn;

	@UiField
	FlowPanel gradeTopList, gradeMiddleList, gradeBottomList, courseData, standardsPanel, coursesPanel, KinderGarten, higherEducation;

	@UiField
	Label GradeUpdate,courseMaxMsg, standardMaxMsg, courseLabel, standardLabel;

	@UiField(provided = true)
	AppSuggestBox standardSgstBox;

	@UiField(provided = true)
	FolderCBundle res;

	private CollectionDo collectionDo = null;
	
	private static final List<String> gradeList = new ArrayList<String>();
	
	private CollectionDo parentCollectionDo = null;

	private AppMultiWordSuggestOracle standardSuggestOracle;

	private SearchDo<CodeDo> standardSearchDo = new SearchDo<CodeDo>(); 

	private Map<String, String> standardCodesMap = new HashMap<String, String>();
	
	private String parentTitle = null;
	
	private String folderLevel=null;
	
	private List<String> courseList = null;

	private static FolderInfoTabViewUiBinder uiBinder = GWT.create(FolderInfoTabViewUiBinder.class);

	interface FolderInfoTabViewUiBinder extends UiBinder<Widget, FolderInfoTabView> {
	}

	/**
	 * Class constructor
	 */
	public FolderInfoTabView() {
		
		standardSuggestOracle = new AppMultiWordSuggestOracle(true);
		standardSearchDo.setPageSize(10);
		standardSgstBox = new AppSuggestBox(standardSuggestOracle) {

			@Override
			public void keyAction(String text,KeyUpEvent event) {
				standardSearchDo.setSearchResults(null);
				standardSearchDo.setQuery(text);
				if (text != null && text.trim().length() > 0) {
					getUiHandlers().requestStandardsSuggestion(standardSearchDo);
				}
			}

			@Override
			public HandlerRegistration addClickHandler(ClickHandler handler) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		standardSgstBox.addSelectionHandler(this);
		res = FolderCBundle.INSTANCE;
		FolderCBundle.INSTANCE.css().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));
		addStandardBtn.setVisible(false);
		courseLabel.getElement().setId("lblCourse");
		courseData.getElement().setId("fpnlCourseData");
		collectionCourseLst.getElement().setId("glbCollectionCourseLst");
		addCourseBtn.getElement().setId("btnAddCource");
		courseMaxMsg.getElement().setId("lblCourseMaxMsg");
		coursesPanel.getElement().setId("pnlCoursesPanel");
		KinderGarten.getElement().setId("fpnlKinderGarten");
		gradeTopList.getElement().setId("fpnlGradeTopList");
		gradeMiddleList.getElement().setId("fpnlGradeMiddleList");
		gradeBottomList.getElement().setId("fpnlGradeBottomList");
		higherEducation.getElement().setId("fpnlHigherEducation");
		standardLabel.getElement().setId("lblStandard");
		standardSgstBox.getElement().setId("tbautoStandardsSgst");
		addStandardBtn.getElement().setId("btnAddStandard");
		standardMaxMsg.getElement().setId("lblStandardMaxMsg");
		standardsPanel.getElement().setId("pnlStandards");
	}

	@Override
	public void reset() {
		super.reset();
		collectionDo = null;
		parentTitle = null;
		gradeTopList.clear();
		gradeMiddleList.clear();
		gradeBottomList.clear();
		standardsPanel.clear();
		KinderGarten.clear();
		higherEducation.clear();
		coursesPanel.clear();
		standardSuggestOracle.clear();
		standardCodesMap.clear();
	}

	@Override
	public void setData(CollectionDo collectionDo) {
		
			this.collectionDo = collectionDo;
			folderLevel = AppClientFactory.getPlaceManager().getRequestParameter("level");
			if(folderLevel.equals("1")){
				setMetaData(collectionDo);
			}
			
			
	}

	public void setMetaData(CollectionDo collectionDo) {
		for (CodeDo code : collectionDo.getTaxonomySet()) {
			if (code.getDepth() == 2) {
				coursesPanel.add(createCourseLabel(code.getLabel(), code.getCodeId() + ""));
			}
		}
		if (collectionDo.getMetaInfo() != null && collectionDo.getMetaInfo().getStandards() != null) {
			for (StandardFo standard : collectionDo.getMetaInfo().getStandards()) {
				standardsPanel.add(createStandardLabel(standard.getCode(), standard.getCodeId() + "", standard.getDescription()));
			}
		}
		resetStandardCount();
		resetCourseCount();
		setGradeList();
	}
	
	
	@Override
	public void setParentData(CollectionDo collectionDo) {
			this.collectionDo = collectionDo;
			this.parentCollectionDo = collectionDo;
			this.parentTitle = collectionDo.getTitle();
			for (CodeDo code : collectionDo.getTaxonomySet()) {
				if (code.getDepth() == 2) {
					coursesPanel.add(createCourseLabel(code.getLabel(), code.getCodeId() + ""));
				}
			}
			if (collectionDo.getMetaInfo() != null && collectionDo.getMetaInfo().getStandards() != null) {
				for (StandardFo standard : collectionDo.getMetaInfo().getStandards()) {
					standardsPanel.add(createStandardLabel(standard.getCode(), standard.getCodeId() + "", standard.getDescription()));
				}
			}
			resetStandardCount();
			resetCourseCount();
			//setGradeList();
	}

	@Override
	public void setCourseList(List<LibraryCodeDo> libraryCode) {
		collectionCourseLst.clear();
		collectionCourseLst.addItem(" - Select Course(s) - ", "-1");
		if (libraryCode != null) {
			for (LibraryCodeDo libraryCodeDo : libraryCode) {
				for (LibraryCodeDo liCodeDo : libraryCodeDo.getNode()) {
					collectionCourseLst.addItem(libraryCodeDo.getLabel() + "|" + liCodeDo.getLabel(), liCodeDo.getCodeId() + "");
				}
			}
		}
	}

	/**
	 * New course is created for collection	
	 * 
	 * @param courseLabel
	 *            the course of the label widget which is used to get all
	 *            courses
	 * @param courseCode
	 *            the course of the course code, an absolute course code will be
	 *            used to create a new course
	 * @return the label of all course created for the collection.
	 */
	protected CloseLabel createCourseLabel(final String courseLabel, final String courseCode) {

		CloseLabel closeLabel = new CloseLabel(courseLabel) {

			@Override
			public void onCloseLabelClick(ClickEvent event) {
					resetCourseCount();
					getUiHandlers().updateCourse(collectionDo.getGooruOid(), courseCode, "delete");
				}
		};
		
		if(parentTitle!=null){
			if(parentTitle.equalsIgnoreCase(collectionDo.getTitle())){
				closeLabel.disableParentRemoveFunction();
			}
		}
		
		return closeLabel;
	}

	/**
	 * Adding new course for the collection , will check it has more than five
	 * courses and the selected course is repeated or not
	 * 
	 * @param clickEvent
	 *            specifies event type
	 */
	@UiHandler("addCourseBtn")
	public void onAddCourseClick(ClickEvent clickEvent) {
		
		
		if (coursesPanel.getWidgetCount() < 5) {
			
			final String courseCodeLabel = collectionCourseLst.getItemText(collectionCourseLst.getSelectedIndex());
			final String courseCode = collectionCourseLst.getValue(collectionCourseLst.getSelectedIndex());
			

			if (collectionCourseLst.getSelectedIndex() == 0) {
				
				return;
			}
			if (validateCourse(courseCodeLabel) && courseCode != null) {
				new AlertContentUc("Oops", "Please add different courses");
			} else {
			
				getUiHandlers().updateCourse(collectionDo.getGooruOid(), courseCode, "add");
				coursesPanel.add(createCourseLabel(courseCodeLabel, courseCode));
				this.resetCourseCount();	
				collectionCourseLst.setSelectedIndex(0);
			}
			courseMaxHide();
		} else {
			courseMaxShow();
		}
	}

	/**
	 * Will check it ,the selected course is repeated or not
	 * 
	 * @param course
	 *            to validate with already added course
	 * @return true if repeated course is selected or false
	 */
	protected boolean validateCourse(String course) {
		for (Widget widget : coursesPanel) {
			if (course.equals(((CloseLabel) widget).getSourceText())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * to display message if course exceeds more than five
	 */
	public void courseMaxShow() {
		courseData.setStyleName(FolderCBundle.INSTANCE.css().coursesContainer());
		collectionCourseLst.setStyleName(FolderCBundle.INSTANCE.css().courseTextBox());
		addCourseBtn.setStyleName(FolderCBundle.INSTANCE.css().addButtonForFolder());
		courseMaxMsg.setStyleName(FolderCBundle.INSTANCE.css().courseMaxMsgShow());
		new FadeInAndOut(courseMaxMsg.getElement(), 10000, 10000);
	}

	/**
	 * to hide message if course exceeds less than five
	 */
	public void courseMaxHide() {
		courseData.setStyleName(FolderCBundle.INSTANCE.css().floatLeft());
		collectionCourseLst.setStyleName(FolderCBundle.INSTANCE.css().infoTextBox());
		addCourseBtn.setStyleName(FolderCBundle.INSTANCE.css().addButtonForFolder());
		courseMaxMsg.setStyleName(FolderCBundle.INSTANCE.css().courseMaxMsg());
	}

	/**
	 * to display message if standard exceeds more than fifteen
	 */
	public void standardMaxShow() {
		standardSgstBox.addStyleName(FolderCBundle.INSTANCE.css().standardTxtBox());
		addStandardBtn.addStyleName(FolderCBundle.INSTANCE.css().floatLeftNeeded());
		standardMaxMsg.setStyleName(FolderCBundle.INSTANCE.css().standardMax());
		standardsPanel.addStyleName(FolderCBundle.INSTANCE.css().floatLeftNeeded());
		new FadeInAndOut(standardMaxMsg.getElement(), 5000, 5000);
	}

	/**
	 * to hide message if standard less than fifteen
	 */
	public void standardMaxHide() {
		standardSgstBox.removeStyleName(FolderCBundle.INSTANCE.css().standardTxtBox());
		addStandardBtn.removeStyleName(FolderCBundle.INSTANCE.css().floatLeftNeeded());
		standardMaxMsg.removeStyleName(FolderCBundle.INSTANCE.css().standardMax());
		standardsPanel.removeStyleName(FolderCBundle.INSTANCE.css().floatLeftNeeded());
	}
	
	public GradeLabel setGradeLabelValues(String label, CollectionDo collectionDoInternal)
	{
		GradeLabel gradeLblKindergarten = new GradeLabel(label, collectionDoInternal) {			
			@Override
			public void onClick(ClickEvent event) {
				GradeUpdate.setVisible(true);
			
				gradeTopList.setVisible(false);
				gradeMiddleList.setVisible(false);
				gradeBottomList.setVisible(false);
				KinderGarten.setVisible(false);
				higherEducation.setVisible(false);
				if(this.getElement().getAttribute("selected") != null)
				{
				if(this.getElement().getAttribute("selected").contains("selected")){
					this.getElement().getStyle().setProperty("background", "");
					this.getElement().getStyle().setColor("#999");
					this.getElement().removeAttribute("selected");
					try
					{
					gradeList.remove(this.getText());	
					}
					catch(Exception ex)
					{
						
					}
				
				} else {
					this.getElement().getStyle().setProperty("background", "#0F76BB");
					this.getElement().getStyle().setColor("#fff");
					this.getElement().setAttribute("selected", "selected");
					if(!gradeList.contains(this.getText())){
						gradeList.add(this.getText());
						if (AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equalsIgnoreCase(PlaceTokens.SHELF)){
							MixpanelUtil.mixpanelEvent("Collaborator_edits_collection");
						}
					}
				}
				} else {
					this.getElement().getStyle().setProperty("background", "#0F76BB");
					this.getElement().getStyle().setColor("#fff");
					this.getElement().setAttribute("selected", "selected");
					if(!gradeList.contains(this.getText())){
						gradeList.add(this.getText());
						//updateGrade(gradeList);
						if (AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equalsIgnoreCase(PlaceTokens.SHELF)){
							MixpanelUtil.mixpanelEvent("Collaborator_edits_collection");
						}
					}
				}
				updateGrade(gradeList);
				
			}
			
		
		};
		return gradeLblKindergarten;
	}

	/**
	 * separate the view according to grade level of the collection
	 */
	public void setGradeList() {
		
		KinderGarten.add(setGradeLabelValues("Kindergarten", collectionDo));
		higherEducation.add(setGradeLabelValues("Higher Education", collectionDo));
		for (int i = 1; i <= 12; i++) {
			if (i <= 4) {
				gradeTopList.add(setGradeLabelValues(i + "", collectionDo));
			}
			if (i <= 8 && i >= 5) {
				gradeMiddleList.add(setGradeLabelValues(i + "", collectionDo));
			}
			if (i <= 12 && i >= 9) {
				gradeBottomList.add(setGradeLabelValues(i + "", collectionDo));
			}
		}
	}

	@Override
	public void onSelection(SelectionEvent<Suggestion> event) {
		addStandard(standardSgstBox.getValue(), getCodeIdByCode(standardSgstBox.getValue(), standardSearchDo.getSearchResults()));
		standardSgstBox.setText("");
		standardSuggestOracle.clear();
	}

	public void setStandardSuggestions(SearchDo<CodeDo> standardSearchDo) {
		standardSuggestOracle.clear();
		this.standardSearchDo = standardSearchDo;
		if (this.standardSearchDo.getSearchResults() != null) {
			List<String> sources = getAddedStandards(standardsPanel);
			for (CodeDo code : standardSearchDo.getSearchResults()) {
				if (!sources.contains(code.getCode())) {
					standardSuggestOracle.add(code.getCode());
				}
				standardCodesMap.put(code.getCodeId() + "", code.getLabel());
			}
		}
		standardSgstBox.showSuggestionList();
	}

	/**
	 * get the standards are added for collection
	 * 
	 * @param flowPanel
	 *            having all added standards label
	 * @return standards text in list which are added for the collection
	 */
	private List<String> getAddedStandards(FlowPanel flowPanel) {
		List<String> suggestions = new ArrayList<String>();
		for (Widget widget : flowPanel) {
			if (widget instanceof DownToolTipWidgetUc) {
				suggestions.add(((CloseLabel) ((DownToolTipWidgetUc) widget).getWidget()).getSourceText());
			}
		}
		return suggestions;
	}

	/**
	 * set the standard text with count while adding and removing the standard
	 */
	private void resetStandardCount() {
		if (standardsPanel.getWidgetCount() > 0) {
			standardLabel.setText("STANDARDS" + " (" + standardsPanel.getWidgetCount() + ")");
		} else {
			standardLabel.setText("STANDARDS");
		}
	}

	/**
	 * set the course text with count while adding and removing the course
	 */
	private void resetCourseCount() {
		if (coursesPanel.getWidgetCount() > 0) {
			/*courseLabel.setText("COURSE" + " (" + coursesPanel.getWidgetCount() + ")");*/
			
			courseLabel.setText("COURSE(S)");
			courseLabel.getElement().setAttribute("alt","COURSE(S)");
			courseLabel.getElement().setAttribute("title","COURSE(S)");
			
		} else {
			courseLabel.setText("COURSE(S)");
			courseLabel.getElement().setAttribute("alt","COURSE(S)");
			courseLabel.getElement().setAttribute("title","COURSE(S)");
		}
	}

	/**
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */
	@UiHandler("addStandardBtn")
	public void onAddStandardsClick(ClickEvent clickEvent) {
		addStandard(standardSgstBox.getText(), getCodeIdByCode(standardSgstBox.getText(), standardSearchDo.getSearchResults()));
	}

	private static String getCodeIdByCode(String code, List<CodeDo> codes) {
		if (codes != null) {
			for (CodeDo codeDo : codes) {
				if (code.equals(codeDo.getCode())) {
					return codeDo.getCodeId() + "";
				}
			}
		}
		return null;
	}

	/**
	 * Adding new standard for the collection , will check it has more than
	 * fifteen standards
	 * 
	 * @param standard
	 *            which to be added for the collection
	 */
	public void addStandard(String standard, String id) {
		if (standardsPanel.getWidgetCount() < 15) {
			if (standard != null && !standard.isEmpty()) {
				standardsPanel.add(createStandardLabel(standard, id, standardCodesMap.get(id)));
				this.resetStandardCount();
				getUiHandlers().updateStandard(collectionDo.getGooruOid(), id, "add");
			}
		} else {
			standardMaxShow();
			standardSgstBox.setText("");
		}
	}

	/**
	 * new label is created for the standard which needs to be added
	 * 
	 * @param standardCode
	 *            update standard code
	 * @return instance of {@link DownToolTipWidgetUc}
	 */
	public DownToolTipWidgetUc createStandardLabel(final String standardCode, final String id, String description) {

		CloseLabel closeLabel = new CloseLabel(standardCode) {

			@Override
			public void onCloseLabelClick(ClickEvent event) {
				this.getParent().removeFromParent();
				resetCourseCount();
				getUiHandlers().updateStandard(collectionDo.getGooruOid(), id, "delete");
				resetStandardCount();
			}
		};
		
		if(parentTitle!=null) {
			if(parentTitle.equalsIgnoreCase(collectionDo.getTitle())) {
				closeLabel.disableParentRemoveFunction();
			}
		}
		return new DownToolTipWidgetUc(closeLabel, description);
	}

	@Override
	public void onPostCourseUpdate(CollectionDo collectionDo) {
		collectionCourseLst.setSelectedIndex(0);
		this.collectionDo = collectionDo;
	}

	@Override
	public void onPostStandardUpdate(CollectionDo collectionDo) {
		this.collectionDo = collectionDo;
	}
	
	private String generateGrade(String gradeTxt){
		String tmpGradeTxt = "";
		if (gradeTxt.indexOf("-") > 0){
			if (gradeTxt.indexOf(",") == -1){
				tmpGradeTxt = generateGradeIfHypen(gradeTxt);
			}else{
				String gradeList[];
				gradeList = gradeTxt.split(",");
				for (int k=0; k<gradeList.length;k++){
					if (gradeList[k].indexOf("-") > 0){
						if (k==gradeList.length){
							tmpGradeTxt = tmpGradeTxt + generateGradeIfHypen(gradeList[k]);
						}else{
							tmpGradeTxt = tmpGradeTxt + generateGradeIfHypen(gradeList[k]) + ",";
						}
					}else{
						if (k==gradeList.length-1){
							tmpGradeTxt = tmpGradeTxt + gradeList[k];
						}else{
							tmpGradeTxt = tmpGradeTxt + gradeList[k] + ",";
						}
					}
				}
			}
		}
		return tmpGradeTxt;
	}
	
	private String generateGradeIfHypen(String grade){
		String gradeList[];
		StringBuilder gradeStr = new StringBuilder();
		gradeList = grade.split("-");
		if (gradeList.length>=2){
			int start = Integer.parseInt(gradeList[0].trim());
			int end = Integer.parseInt(gradeList[1].trim());
			if ( start < end){
				for (int i = start; i<=end; i++){
					if (i==end){
						gradeStr.append(i);
					}else{
						gradeStr.append(i).append(",");
					}
				}
			}
		}else{
			gradeStr.append(Integer.parseInt(gradeList[0]));
		}
		return gradeStr.toString();
	}
	
	private void updateGrade(List<String> gradeListInternal){
	AppClientFactory.getInjector().getResourceService().updateCollectionMetadata(collectionDo.getGooruOid(), null, null, join(gradeListInternal, ","), null, null, null,null,null,null, new SimpleAsyncCallback<CollectionDo>(){
			
			@Override
			public void onSuccess(CollectionDo result) {
				GradeUpdate.setVisible(false);
				gradeTopList.setVisible(true);
				gradeMiddleList.setVisible(true);
				gradeBottomList.setVisible(true);
				KinderGarten.setVisible(true);
				higherEducation.setVisible(true);
				gradeList.clear();
				List<String> items = Arrays.asList(result.getGrade().split("\\s*,\\s*"));
				gradeList.addAll(items);
				collectionDo.setGrade(result.getGrade());
			}
		});
	}
	
	private String join(List<?> list,String separator){
		StringBuilder builder =null;
		if(list != null){
			builder = new StringBuilder();
			for(Object value:list){
				if(builder.length() > 0){
					builder.append(separator);
				}
				builder.append(value);
			}
		}
		return builder.toString();
	}


}
