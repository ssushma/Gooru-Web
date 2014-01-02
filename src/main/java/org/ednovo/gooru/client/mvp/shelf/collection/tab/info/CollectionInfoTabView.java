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
import org.ednovo.gooru.client.uc.tooltip.ToolTip;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.code.LibraryCodeDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.StandardFo;
import org.ednovo.gooru.shared.model.search.SearchDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.Widget;
import com.tractionsoftware.gwt.user.client.ui.GroupedListBox;

/**
 * 
 * @fileName : CollectionInfoTabView.java
 *
 * @description : This file is related to Collection Information Tab View.
 *
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class CollectionInfoTabView extends BaseViewWithHandlers<CollectionInfoTabUiHandlers> implements IsCollectionInfoTabView, SelectionHandler<SuggestOracle.Suggestion> {

	/*@UiField
	FlowPanel collectionCourseLstPanel;
*/
	@UiField
	Button addCourseBtn, addStandardBtn,removeCourseBtn;

	@UiField
	FlowPanel gradeTopList, gradeMiddleList, gradeBottomList, courseData, standardsPanel, KinderGarten, higherEducation;

	@UiField
	Label  standardMaxMsg, courseLabel, standardLabel,courseLbl;
	
	@UiField
	HTMLPanel panelLoading,mainInfoPanel;
	
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
	
	private static final String ADD_COURSE="Add a Course";
	
	private static final String CHANGE_COURSE="Change Course";
	
	CourseListUc courseListUc;
	
	private static CollectionInfoTabViewUiBinder uiBinder = GWT.create(CollectionInfoTabViewUiBinder.class);

	interface CollectionInfoTabViewUiBinder extends UiBinder<Widget, CollectionInfoTabView> {
	}

	/**
	 * Class constructor
	 */
	public CollectionInfoTabView() {
		
		standardSuggestOracle = new AppMultiWordSuggestOracle(true);
		standardSearchDo.setPageSize(10);
		standardSgstBox = new AppSuggestBox(standardSuggestOracle) {

			@Override
			public void keyAction(String text) {
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
		res = CollectionCBundle.INSTANCE;
		CollectionCBundle.INSTANCE.css().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));
		addStandardBtn.setVisible(false);
		panelLoading.setVisible(true);
		mainInfoPanel.setVisible(false);
		removeCourseBtn.setVisible(false);
		addCourseBtn.getElement().getStyle().setMarginRight(10, Unit.PX);
		removeCourseBtn.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		removeCourseBtn.setVisible(false);
		courseLbl.getElement().getStyle().setDisplay(Display.NONE);
//		courseLbl.getElement().getStyle().setMarginLeft(4, Unit.PX);
		AppClientFactory.getEventBus().addHandler(AddCourseEvent.TYPE, addCourseHandler);
		
	}
	/**
	 * This method is used to reset the data.
	 */
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
	/**
	 * This method is used to set the data.
	 */
	@Override
	public void setData(CollectionDo collectionDo) {
		if (this.collectionDo == null) {
			this.collectionDo = collectionDo;
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
	/**
	 * This method is used to set the course list.
	 */
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
	/**
	 * This method is used to clear standardSgstBox.
	 */
	@Override
	public void onSelection(SelectionEvent<Suggestion> event) {
		addStandard(standardSgstBox.getValue(), getCodeIdByCode(standardSgstBox.getValue(), standardSearchDo.getSearchResults()));
		standardSgstBox.setText("");
		standardSuggestOracle.clear();
	}
	/**
	 * This method is used to set the standard suggestions.
	 */
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
		courseLabel.setText("COURSE");
		/*if (coursesPanel.getWidgetCount() > 0) {
			courseLabel.setText("COURSE" + " (" + coursesPanel.getWidgetCount() + ")");
		} else {
			courseLabel.setText("COURSE");
		}*/
	}
	/**
	 * This is used to add the course handler.
	 */
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
	/**
	 * 
	 * @function onClickRemoveCourseBtn 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This method is used to updateCourse.
	 * 
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("removeCourseBtn")
	public void onClickRemoveCourseBtn(ClickEvent clickEvent){
		courseLbl.getElement().getStyle().setDisplay(Display.NONE);
		addCourseBtn.setText(ADD_COURSE);
		removeCourseBtn.setVisible(false);
		getUiHandlers().updateCourse(collectionDo.getGooruOid(), courseCode, "delete");
	}
	/**
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */
	@UiHandler("addStandardBtn")
	public void onAddStandardsClick(ClickEvent clickEvent) {
		addStandard(standardSgstBox.getText(), getCodeIdByCode(standardSgstBox.getText(), standardSearchDo.getSearchResults()));
	}
	/**
	 * 
	 * @function getCodeIdByCode 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method is used to get the CodeId By Code.
	 * 
	 * 
	 * @parm(s) : @param code
	 * @parm(s) : @param codes
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
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
	/**
	 * This is to set the collectionDo onPostCourseUpdate.
	 */
	@Override
	public void onPostCourseUpdate(CollectionDo collectionDo) {
//		collectionCourseLst.setSelectedIndex(0);
		this.collectionDo = collectionDo;
		//resetCourseCount();
	}
	/**
	 *  This is to set the collectionDo onPostStandardUpdate.
	 */
	@Override
	public void onPostStandardUpdate(CollectionDo collectionDo) {
		this.collectionDo = collectionDo;
	}
	/**
	 * This method is used to close the opened popup's.
	 */
	@Override
	public void closeAllOpenedPopUp() {
		if(alertContentUc!=null){
			alertContentUc.getAlertBox().hide();
		}
	}

}
