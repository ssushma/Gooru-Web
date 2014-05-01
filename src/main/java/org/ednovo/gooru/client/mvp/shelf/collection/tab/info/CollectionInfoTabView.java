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
package org.ednovo.gooru.client.mvp.shelf.collection.tab.info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.effects.FadeInAndOut;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle;
import org.ednovo.gooru.client.mvp.shelf.event.AddCourseEvent;
import org.ednovo.gooru.client.mvp.shelf.event.AddCourseHandler;
import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.client.uc.AppMultiWordSuggestOracle;
import org.ednovo.gooru.client.uc.AppSuggestBox;
import org.ednovo.gooru.client.uc.CloseLabel;
import org.ednovo.gooru.client.uc.CourseListUc;
import org.ednovo.gooru.client.uc.DownToolTipWidgetUc;
import org.ednovo.gooru.client.uc.GradeLabel;
import org.ednovo.gooru.client.uc.StandardsPreferenceOrganizeToolTip;
import org.ednovo.gooru.client.uc.tooltip.ToolTip;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.code.LibraryCodeDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.StandardFo;
import org.ednovo.gooru.shared.model.search.SearchDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.tractionsoftware.gwt.user.client.ui.GroupedListBox;

/**
 * @author Search Team
 * 
 */
public class CollectionInfoTabView extends BaseViewWithHandlers<CollectionInfoTabUiHandlers> implements IsCollectionInfoTabView, SelectionHandler<SuggestOracle.Suggestion>,MessageProperties {

	/*@UiField
	FlowPanel collectionCourseLstPanel;
*/
	@UiField
	Button addCourseBtn, addStandardBtn,removeCourseBtn;

	@UiField
	FlowPanel gradeTopList, gradeMiddleList, gradeBottomList, courseData, standardsPanel, KinderGarten, higherEducation,standardContainer;

	@UiField
	Label  standardMaxMsg, courseLabel, standardLabel,courseLbl, standardsDefaultText,gradeLbl,selectGradeLbl,selectCourseLbl,toggleArrowButtonPrimary,toggleArrowButtonSecondary,instructionalMethod,audienceLabel,audienceTitle,instructionalTitle,languageObjectiveHeader,depthOfKnowledgeHeader,depthOfKnowledgeTitle,learningInnovationHeader,learningInnovationTitle;
	
	@UiField Label lblAudiencePlaceHolder,lblAudienceArrow,lblInstructionalPlaceHolder,lblInstructionalArrow;
	
	@UiField ScrollPanel spanelAudiencePanel,spanelInstructionalPanel;	

	@UiField
	HTMLPanel panelLoading,mainInfoPanel,secondaryContentsContainer,htmlAudienceListContainer,htmlInstructionalListContainer,primaryLabelTag,secondaryHeaderLabel;
	
	@UiField TextArea textAreaVal;
	
	@UiField CheckBox chkLevelRecall,chkLevelSkillConcept,chkLevelStrategicThinking,chkLevelExtendedThinking,learninglevel1,learninglevel2,learninglevel3;
	
	
/*	@UiField TextArea teacherTipTextarea;*/
	
	@UiField(provided = true)
	AppSuggestBox standardSgstBox;

	@UiField(provided = true)
	CollectionCBundle res;
	
	ToolTip toolTip=null;
	
	String courseCode="";
	
	private CollectionDo collectionDo = null;

	private AppMultiWordSuggestOracle standardSuggestOracle;

	private SearchDo<CodeDo> standardSearchDo = new SearchDo<CodeDo>();

	private Map<String, String> standardCodesMap = new HashMap<String, String>();
	
	private GroupedListBox collectionCourseLst;

	private AlertContentUc alertContentUc;
	
	private static final String ADD_COURSE=GL0847;
	
	private static final String CHANGE_COURSE=GL1496;
	
	private static final String FLT_CODE_ID = "id";
	
	CourseListUc courseListUc;
	
	List<String> standardPreflist=null;
	
	private static CollectionInfoTabViewUiBinder uiBinder = GWT.create(CollectionInfoTabViewUiBinder.class);

	interface CollectionInfoTabViewUiBinder extends UiBinder<Widget, CollectionInfoTabView> {
	}

	/**
	 * Class constructor
	 */
	public CollectionInfoTabView() {
		standardSuggestOracle = new AppMultiWordSuggestOracle(true);
		standardSearchDo.setPageSize(10);
		
		/*if(standardPreflist!=null){
		for (String istandardPreflistcodeId : standardPreflist) {
			standardcodeIdPref=istandardPreflistcodeId;
		}
		}*/
		
		standardSgstBox = new AppSuggestBox(standardSuggestOracle) {
			final StandardsPreferenceOrganizeToolTip standardsPreferenceOrganizeToolTip=new StandardsPreferenceOrganizeToolTip();
			@Override
			public void keyAction(String text) {
				text=text.toUpperCase();
				standardsPreferenceOrganizeToolTip.hide();
				standardSearchDo.setSearchResults(null);
				boolean standardsPrefDisplayPopup = false;
				//standardSgstBox.hideSuggestionList();
				if(!courseCode.isEmpty()) {
					Map<String,String> filters = new HashMap<String, String>();
					filters.put(FLT_CODE_ID,courseCode);
					standardSearchDo.setFilters(filters);
				}
				standardSearchDo.setQuery(text);
				if (text != null && text.trim().length() > 0) {
					standardsPreferenceOrganizeToolTip.hide();
					if(standardPreflist!=null){
						for(int count=0; count<standardPreflist.size();count++) {
							if(text.contains(standardPreflist.get(count))) {
								standardsPrefDisplayPopup = true;
								break;
							} else {
								standardsPrefDisplayPopup = false;
							}
						}
						
						
					}
					if(standardsPrefDisplayPopup){
						standardsPreferenceOrganizeToolTip.hide();
						getUiHandlers().requestStandardsSuggestion(standardSearchDo);
						//standardSgstBox.showSuggestionList();
					}
					else{
						standardSgstBox.hideSuggestionList();
						standardSuggestOracle.clear();
						standardsPreferenceOrganizeToolTip.show();
						standardsPreferenceOrganizeToolTip.setPopupPosition(standardSgstBox.getAbsoluteLeft()+3, standardSgstBox.getAbsoluteTop()+33);
	
						//standardSuggestOracle.add(GL1613);
						
					}
					}
					
				
			}

			@Override
			public HandlerRegistration addClickHandler(ClickHandler handler) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		standardSgstBox.addSelectionHandler(this);
		res = CollectionCBundle.INSTANCE;
		CollectionCBundle.INSTANCE.css().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));
		gradeLbl.setText(GL1076.toUpperCase());
		selectGradeLbl.setText(GL0820);
		selectCourseLbl.setText(GL0846);
		addCourseBtn.setText(GL0847);
		removeCourseBtn.setText(GL0848);
		standardLabel.setText(GL0575.toUpperCase());
		addStandardBtn.setText(GL0590);
		standardMaxMsg.setText(GL0849);
		instructionalMethod.setText(GL1637);
		audienceLabel.setText(GL1638);
		instructionalTitle.setText(GL1639);
		audienceTitle.setText(GL1640);
		textAreaVal.setText(GL1641);
		languageObjectiveHeader.setText(GL1642);
		depthOfKnowledgeHeader.setText(GL1643);
		depthOfKnowledgeTitle.setText(GL1644);
	
		chkLevelRecall.setText(GL1645);
		chkLevelSkillConcept.setText(GL1646);
		chkLevelStrategicThinking.setText(GL1647);
		chkLevelExtendedThinking.setText(GL1648);
		
		learningInnovationHeader.setText(GL1649);
		learningInnovationTitle.setText(GL1650);
		
		learninglevel1.setText(GL1651);
		learninglevel2.setText(GL1652);
		learninglevel3.setText(GL1653);
		
		lblInstructionalPlaceHolder.setText(GL0105);
		lblAudiencePlaceHolder.setText(GL0105);
		
		toggleArrowButtonPrimary.removeStyleName(res.css().primaryToggleArrowBottomrotateRight());
		toggleArrowButtonSecondary.removeStyleName(res.css().primaryToggleArrowBottomrotateRight());
		
	
		
		primaryLabelTag.getElement().setInnerHTML(GL1656);
		secondaryHeaderLabel.getElement().setInnerHTML(GL1657);

		textAreaVal.getElement().setAttribute("maxlength", "1000");
		
		textAreaVal.addFocusHandler(new FocusHandler() {
			@Override
			public void onFocus(FocusEvent event) {
				String directionText=textAreaVal.getText().trim();
				if(directionText.equalsIgnoreCase(GL1641)){
					textAreaVal.setText("");
				}
				textAreaVal.getElement().getStyle().setColor("black");
			}
		});
		
		textAreaVal.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				if(textAreaVal.getText().length() > 1000)
				{
					textAreaVal.cancelKey();
				}			
			}
		});
		
		textAreaVal.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				if(textAreaVal.getText().length() == 0){
					textAreaVal.setText(GL1641);
					textAreaVal.getElement().getStyle().setColor("#999");
				}
			}
		});
		
		
		lblAudiencePlaceHolder.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				OpenAudienceDropdown();
			}

			
		});
		
		lblAudienceArrow.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				OpenAudienceDropdown();
			}
		});
		
		lblInstructionalPlaceHolder.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				OpenInstructionalDropdown();
			}
		});
		
		lblInstructionalArrow.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				OpenInstructionalDropdown();	
			}
		});
		
		AppClientFactory.getEventBus().addHandler(AddCourseEvent.TYPE, addCourseHandler);
/*		addTeacherTip.addBlurHandler(new BlurHandler() {
			
			@Override
			public void onBlur(BlurEvent event) {
				if(teacherTipTextarea.getText().length()>0){
					errorLabelForTeacherTip.setVisible(false);
				}
				
			}
		});
		teacherTipTextLabel.setText(MessageProperties.GL0750);*/
		standardsDefaultText.setText(GL0749);
		addStandardBtn.setVisible(false);
		panelLoading.setVisible(true);
		mainInfoPanel.setVisible(false);
		removeCourseBtn.setVisible(false);
		addCourseBtn.getElement().getStyle().setMarginRight(10, Unit.PX);
		removeCourseBtn.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		removeCourseBtn.setVisible(false);
		courseLbl.getElement().getStyle().setDisplay(Display.NONE);
		
		spanelInstructionalPanel.setVisible(false);
		spanelAudiencePanel.setVisible(false);
	}

	private void OpenAudienceDropdown() {
		if (spanelInstructionalPanel.isVisible()){
			spanelInstructionalPanel.setVisible(false);
		}
		
		if (spanelAudiencePanel.isVisible()){
			spanelAudiencePanel.setVisible(false);
		}else{
			spanelAudiencePanel.setVisible(true);
		}
	}
	
	private void OpenInstructionalDropdown() {
		if (spanelAudiencePanel.isVisible()){
			spanelAudiencePanel.setVisible(false);
		}
		
		if (spanelInstructionalPanel.isVisible()){
			spanelInstructionalPanel.setVisible(false);
		}else{
			spanelInstructionalPanel.setVisible(true);
		}
		
		
	}
	
	@Override
	public void reset() {
		super.reset();
		collectionDo = null;
		gradeTopList.clear();
		gradeMiddleList.clear();
		gradeBottomList.clear();
		standardsPanel.clear();
		KinderGarten.clear();
		higherEducation.clear();
		standardSuggestOracle.clear();
		standardCodesMap.clear();
		courseLbl.setText("");
		courseLbl.getElement().getStyle().setDisplay(Display.NONE);
		addCourseBtn.setText(ADD_COURSE);
		addCourseBtn.setVisible(true);
		removeCourseBtn.setVisible(false);
		
	}

	@Override
	public void setData(CollectionDo collectionDo) {
		if (this.collectionDo == null) {
			this.collectionDo = collectionDo;
			
		//	getUiHandlers().getCollectionTeacherTipInfo(collectionDo.getGooruOid());
			
			for (CodeDo code : collectionDo.getTaxonomySet()) {
				if (code.getDepth() == 2) {
					courseLbl.setText(code.getLabel());
					courseLbl.getElement().getStyle().setDisplay(Display.BLOCK);
					courseCode=Integer.toString(code.getCodeId());
					addCourseBtn.setText(CHANGE_COURSE);
					removeCourseBtn.setVisible(true);
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
			/*if(collectionDo.getMediaType()!=null) {
				if(collectionDo.getMediaType().equalsIgnoreCase("iPad_friendly")){
					isCheckedValue=true;
					checkMobileSupport.setStyleName(res.css().classPageEmailCheckBoxBgHover());
				}else{
					checkMobileSupport.setStyleName(res.css().classPageEmailCheckBoxBgHoverSprite());
					isCheckedValue = false;
				}
			}*/
		}
	}

	@Override
	public void setCourseList(List<LibraryCodeDo> libraryCode) {
		collectionCourseLst = new GroupedListBox();
		collectionCourseLst.addStyleName(res.css().infoTextBox());
		collectionCourseLst.addItem(" - Select Course(s) - ", "-1");
		if (libraryCode != null) {
			for (LibraryCodeDo libraryCodeDo : libraryCode) {
				for (LibraryCodeDo liCodeDo : libraryCodeDo.getNode()) {
					collectionCourseLst.addItem(libraryCodeDo.getLabel() + "|" + liCodeDo.getLabel(), liCodeDo.getCodeId() + "");
				}
			}
		}
		/*collectionCourseLstPanel.clear();
		collectionCourseLstPanel.add(collectionCourseLst);*/

		toggleArrowButtonPrimary.removeStyleName(res.css().primaryToggleArrowBottomrotateRight());
		toggleArrowButtonSecondary.removeStyleName(res.css().primaryToggleArrowBottomrotateRight());
		
		secondaryContentsContainer.setVisible(true);
		
		panelLoading.setVisible(false);
		mainInfoPanel.setVisible(true);
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
		return new CloseLabel(courseLabel) {
           
			@Override
			public void onCloseLabelClick(ClickEvent event) {
				this.removeFromParent();
				getUiHandlers().updateCourse(collectionDo.getGooruOid(), courseCode, "delete");
				resetCourseCount();
			
			}
		};
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
		if(courseListUc!=null){
			courseListUc.center();
			courseListUc.show();
			courseListUc.setDefaultCourseData();
		}else{
			courseListUc=new CourseListUc(collectionDo);
			courseListUc.setPopupPosition(clickEvent.getRelativeElement().getAbsoluteLeft()-(450), Window.getScrollTop()+50);
		}
		
		Window.enableScrolling(false);
	}
	
	
	

	/**
	 * to display message if course exceeds more than five
	 */
	public void courseMaxShow() {
		courseData.setStyleName(CollectionCBundle.INSTANCE.css().coursesContainer());
		//collectionCourseLst.setStyleName(CollectionCBundle.INSTANCE.css().courseTextBox());
		//addCourseBtn.setStyleName(CollectionCBundle.INSTANCE.css().courseAddButton());
	}

	/**
	 * to hide message if course exceeds less than five
	 */
	public void courseMaxHide() {
		courseData.setStyleName(CollectionCBundle.INSTANCE.css().floatLeft());
		collectionCourseLst.setStyleName(CollectionCBundle.INSTANCE.css().infoTextBox());
		addCourseBtn.setStyleName(CollectionCBundle.INSTANCE.css().infoAddButton());
//		courseMaxMsg.setStyleName(CollectionCBundle.INSTANCE.css().courseMaxMsg());
	}

	/**
	 * to display message if standard exceeds more than fifteen
	 */
	public void standardMaxShow() {
		standardSgstBox.addStyleName(CollectionCBundle.INSTANCE.css().standardTxtBox());
		addStandardBtn.addStyleName(CollectionCBundle.INSTANCE.css().floatLeftNeeded());
		standardMaxMsg.setStyleName(CollectionCBundle.INSTANCE.css().standardMax());
		standardsPanel.addStyleName(CollectionCBundle.INSTANCE.css().floatLeftNeeded());
		new FadeInAndOut(standardMaxMsg.getElement(), 5000, 5000);
	}

	/**
	 * to hide message if standard less than fifteen
	 *//*
    	public void standardMaxHide() {
		standardSgstBox.removeStyleName(CollectionCBundle.INSTANCE.css().standardTxtBox());
		addStandardBtn.removeStyleName(CollectionCBundle.INSTANCE.css().floatLeftNeeded());
		standardMaxMsg.removeStyleName(CollectionCBundle.INSTANCE.css().standardMax());
		standardsPanel.removeStyleName(CollectionCBundle.INSTANCE.css().floatLeftNeeded());
	}*/

	/**
	 * separate the view according to grade level of the collection
	 */
	public void setGradeList() {
		KinderGarten.add(new GradeLabel("Kindergarten", collectionDo));
		higherEducation.add(new GradeLabel("Higher Education", collectionDo));
		for (int i = 1; i <= 12; i++) {
			if (i <= 4) {
				gradeTopList.add(new GradeLabel(i + "", collectionDo));
			}
			if (i <= 8 && i >= 5) {
				gradeMiddleList.add(new GradeLabel(i + "", collectionDo));
			}
			if (i <= 12 && i >= 9) {
				gradeBottomList.add(new GradeLabel(i + "", collectionDo));
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
			standardLabel.setText(GL0575.toUpperCase() + " (" + standardsPanel.getWidgetCount() + ")");
		} else {
			standardLabel.setText(GL0575.toUpperCase());
		}
	}

	/**
	 * set the course text with count while adding and removing the course
	 */
	private void resetCourseCount() {		
		courseLabel.setText(GL0574.toUpperCase());
		/*if (coursesPanel.getWidgetCount() > 0) {
			courseLabel.setText("COURSE" + " (" + coursesPanel.getWidgetCount() + ")");
		} else {
			courseLabel.setText("COURSE");
		}*/
	}
	
	AddCourseHandler addCourseHandler=new AddCourseHandler() {
		@Override
		public void onAddCourse(String courseName, String courseId) {
			courseLbl.setText(courseName);
			courseLbl.setVisible(true);
			addCourseBtn.setText(CHANGE_COURSE);
			removeCourseBtn.setVisible(true);
			courseCode=courseId;
		}
	};

	
	@UiHandler("removeCourseBtn")
	public void onClickRemoveCourseBtn(ClickEvent clickEvent){
		courseLbl.getElement().getStyle().setDisplay(Display.NONE);
		addCourseBtn.setText(ADD_COURSE);
		removeCourseBtn.setVisible(false);
		getUiHandlers().updateCourse(collectionDo.getGooruOid(), courseCode, "delete");
		courseCode="";
	}
	
	@UiHandler("toggleArrowButtonPrimary")
	public void onClickHidePrimaryContainer(ClickEvent clickEvent){
		if(mainInfoPanel.isVisible())
		{
			mainInfoPanel.setVisible(false);
			//toggleArrowButtonPrimary.removeStyleName(res.css().primaryToggleArrowBottom());
			toggleArrowButtonPrimary.addStyleName(res.css().primaryToggleArrowBottomrotateRight());
			
		}
		else
		{
			mainInfoPanel.setVisible(true);
			toggleArrowButtonPrimary.removeStyleName(res.css().primaryToggleArrowBottomrotateRight());
			//toggleArrowButtonPrimary.setStyleName(res.css().primaryToggleArrowBottom());
		}
	}
	
	@UiHandler("toggleArrowButtonSecondary")
	public void onClickHideSecondaryContainer(ClickEvent clickEvent){
		if(secondaryContentsContainer.isVisible())
		{
			secondaryContentsContainer.setVisible(false);
			//toggleArrowButtonPrimary.removeStyleName(res.css().primaryToggleArrowBottom());
			toggleArrowButtonSecondary.addStyleName(res.css().primaryToggleArrowBottomrotateRight());
			
		}
		else
		{
			secondaryContentsContainer.setVisible(true);
			toggleArrowButtonSecondary.removeStyleName(res.css().primaryToggleArrowBottomrotateRight());
			//toggleArrowButtonPrimary.setStyleName(res.css().primaryToggleArrowBottom());
		}
	}
	
/*	@UiHandler("addTeacherTip")
	public void onClickAddTeacherTip(ClickEvent clickEvent){
		getUiHandlers().updateCollectionTeacherTipInfo(collectionDo, teacherTipTextarea.getText());
		
		
	}*/

/*	public void displayErrorMsgTeacherTip(){

		errorLabelForTeacherTip.setVisible(true);
		errorLabelForTeacherTip.setText(MessageProperties.GL1116);
		
	}*/
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
		return new DownToolTipWidgetUc(closeLabel, description);
	}

	@Override
	public void onPostCourseUpdate(CollectionDo collectionDo) {
//		collectionCourseLst.setSelectedIndex(0);
		this.collectionDo = collectionDo;
		//resetCourseCount();
	}

/*	@Override
	public void setExistingTeacherTip(CollectionDo collectionDo) {
		this.collectionDo = collectionDo;
		teacherTipTextarea.setText(collectionDo.getKeyPoints());
	}*/
	
	@Override
	public void onPostStandardUpdate(CollectionDo collectionDo) {
		this.collectionDo = collectionDo;
	}

	@Override
	public void closeAllOpenedPopUp() {
		if(alertContentUc!=null){
			alertContentUc.getAlertBox().hide();
		}
	}

	@Override
	public FlowPanel getStandardContainer() {
		return standardContainer;
	}

	@Override
	public void getUserStandardPrefCodeId(List<String> list) {
		if(list!=null){
		standardPreflist=new ArrayList<String>();
		for (String code : list) {
			standardPreflist.add(code);
			standardPreflist.add(code.substring(0, 2));
		 }
		}
		
	}

	

}
