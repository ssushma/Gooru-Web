package org.ednovo.gooru.client.mvp.gshelf.taxonomy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.code.CourseSubjectDo;
import org.ednovo.gooru.application.shared.model.library.DomainStandardsDo;
import org.ednovo.gooru.application.shared.model.library.SubDomainStandardsDo;
import org.ednovo.gooru.application.shared.model.library.SubSubDomainStandardsDo;
import org.ednovo.gooru.client.mvp.gshelf.util.LiPanelWithClose;
import org.ednovo.gooru.client.uc.LiPanel;
import org.ednovo.gooru.client.uc.UlPanel;
import org.ednovo.gooru.client.ui.HTMLEventPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Cursor;
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
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;

public class TaxonomyPopupView extends PopupViewWithUiHandlers<TaxonomyPopupUiHandlers> implements IsTaxonomyPopupView {
	
	private TaxonomyPopupViewUiBinder uiBinder = GWT.create(TaxonomyPopupViewUiBinder.class);
	
	@UiTemplate("TaxonomyPopupView.ui.xml")
	interface TaxonomyPopupViewUiBinder extends UiBinder<Widget, TaxonomyPopupView> {
	}
	
	static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	private PopupPanel appPopUp;
	
	@UiField HTMLPanel taxonomyMainContainer;
	
	@UiField Image closeBtn;
	
	@UiField Button k12Btn,higherEduBtn, profLearningBtn,addTaxonomyBtn;
	
	@UiField UlPanel subjectUlContainer,courseUlContainer,domainUlContainer, standardsUlContainer,selectedUlContainer;
	
	LiPanel previousSelectedLiPanel = new LiPanel();
	
	LiPanel previousSelectedCourseLiPanel = new LiPanel();
	
	LiPanel previousSelectedDomainLiPanel = new LiPanel();
	
	LiPanel previousSelectedStdLiPanel = new LiPanel();
	
	List<Button> buttonsList = new ArrayList<Button>();
	
	List<LiPanelWithClose> liPanelWithCloseArray = new ArrayList<LiPanelWithClose>();
	
	private String viewType;
	
	@Inject
	public TaxonomyPopupView(EventBus eventbus){
		super(eventbus);
		appPopUp=new PopupPanel();
		appPopUp.setGlassEnabled(true);
		appPopUp.add(uiBinder.createAndBindUi(this));
		setElementsId();
		
	}

	private void setElementsId() { 
		buttonsList.add(k12Btn);
		buttonsList.add(higherEduBtn);
		buttonsList.add(profLearningBtn);
		taxonomyMainContainer.getElement().setId("taxonomyStructureSelectionPopup");
		closeBtn.getElement().getStyle().setCursor(Cursor.POINTER);
		setButtonActiveStyle(k12Btn);
	}

	@Override
	public Widget asWidget() {
		return appPopUp;
	}

	@Override
	public void reset() {
	}

	@Override
	public void onLoad() {
	}

	@Override
	public void onUnload() {
	}
	
	/**
	 * 
	 * @param event
	 */
	@UiHandler("closeBtn")
	public void onColseButtonClicked(ClickEvent event){
		hide();
	}
	
	/**
	 * 
	 * @param event
	 */
	@UiHandler("k12Btn")
	public void onClickK12Btn(ClickEvent event){
		setButtonActiveStyle(k12Btn);
		clearAllContainers();
		getUiHandlers().populateK12TaxonomyData(1,"subject",0,20); 
	}
	
	
	/**
	 * 
	 * @param event
	 */
	@UiHandler("higherEduBtn")
	public void onClickHigherEduBtn(ClickEvent event){
		setButtonActiveStyle(higherEduBtn);
		clearAllContainers();
		getUiHandlers().getPopulateHigherEduData(2,"subject",0,20);
	}
	

	/**
	 * 
	 * @param event
	 */
	@UiHandler("addTaxonomyBtn")
	public void onClickAddTaxonomy(ClickEvent event){
		hide();
//		getUiHandlers().addTaxonomyData(selectedUlContainer); 
		liPanelWithCloseArray.clear();
		for(int i=0;i<selectedUlContainer.getWidgetCount();i++){
			liPanelWithCloseArray.add((LiPanelWithClose) selectedUlContainer.getWidget(i));
		}
		getUiHandlers().addTaxonomyData(liPanelWithCloseArray); 
	}
	
	
	/**
	 * 
	 * @param event
	 */
	@UiHandler("profLearningBtn")
	public void onClickProfLearningBtn(ClickEvent event){
		setButtonActiveStyle(profLearningBtn);
		clearAllContainers();
		getUiHandlers().populateProfLearningData(3,"subject",0,20);
	}
	
	
	/**
	 * 
	 * @param k12Btn2
	 */
	private void setButtonActiveStyle(Button activeButton) { 
		for(Button button:buttonsList){
			if(button==activeButton){
				button.addStyleName("active");
			}else{
				button.removeStyleName("active");
			}
		}
	}

	@Override
	public void addTaxonomySubjects(List<CourseSubjectDo> result) {
		subjectUlContainer.clear();
		if(result.size()>0){
			for(CourseSubjectDo courseSubjectDo:result){
				LiPanel liPanel=new LiPanel();
				Anchor title=new Anchor(courseSubjectDo.getName().trim());
				liPanel.setTitle(title.getText());
				title.addClickHandler(new OnClickSubjects(liPanel,courseSubjectDo.getSubjectId())); 
				liPanel.add(title);
				subjectUlContainer.add(liPanel);
			}
		}
		
		if(subjectUlContainer.getWidgetCount()>0){
			subjectUlContainer.getWidget(0).addStyleName("active");
			previousSelectedLiPanel = (LiPanel) subjectUlContainer.getWidget(0);
		}
	}
	
	
	/**
	 * Written functionality for subject click, which displays all subject related domains
	 * 
	 *
	 */
	public class OnClickSubjects implements ClickHandler{
		LiPanel liPanel;
		int subId;
		public OnClickSubjects(LiPanel liPanel,int subId) {
			this.liPanel = liPanel;
			this.subId = subId;
		}
		@Override
		public void onClick(ClickEvent event) {
			setSubCouDomainActiveStyle(liPanel,previousSelectedLiPanel);
			previousSelectedLiPanel = liPanel;
			courseUlContainer.clear();
			domainUlContainer.clear();
			standardsUlContainer.clear();
			getUiHandlers().getCoursesBasedOnSelectedSub(subId,"course",0,20);
		}
	}


	@Override
	public void addTaxonomyCourses(List<CourseSubjectDo> taxonomyCourseList) {
		courseUlContainer.clear();
		
		if(taxonomyCourseList.size()>0){
			for(CourseSubjectDo courseSubjectDo:taxonomyCourseList){
				LiPanel liPanel=new LiPanel();
				Anchor title=new Anchor(courseSubjectDo.getName());
				liPanel.setTitle(title.getText().trim());
				title.addClickHandler(new OnClickCourses(liPanel,courseSubjectDo.getCourseId(),title));
				liPanel.add(title);
				courseUlContainer.add(liPanel);
			}
		}
		if(courseUlContainer.getWidgetCount()>0){
			courseUlContainer.getWidget(0).addStyleName("active");
			previousSelectedCourseLiPanel = (LiPanel) courseUlContainer.getWidget(0);
		}
	}
	
	
	public class OnClickCourses implements ClickHandler{
		LiPanel liPanel;
		int courseId;
		Anchor title;
		public OnClickCourses(LiPanel liPanel,int courseId, Anchor title) {
			this.liPanel = liPanel;
			this.courseId = courseId;
			this.title = title;
		}
		@Override
		public void onClick(ClickEvent event) {
			setSubCouDomainActiveStyle(liPanel,previousSelectedCourseLiPanel);
			previousSelectedCourseLiPanel = liPanel;
			domainUlContainer.clear();
			standardsUlContainer.clear();
			getUiHandlers().getDomainsBasedOnSelectedCourse(courseId,"domain",0,20);
		}
	}


	@Override
	public void addTaxonomyDomains(List<CourseSubjectDo> taxonomyDomainList) {
		domainUlContainer.clear();
		if(taxonomyDomainList.size()>0){
			for(CourseSubjectDo courseSubjectDo:taxonomyDomainList){
				LiPanel liPanel=new LiPanel();
				Anchor title=new Anchor(courseSubjectDo.getName());
				liPanel.setTitle(courseSubjectDo.getName());
				liPanel.setCodeId(courseSubjectDo.getSubdomainId());
				title.addClickHandler(new OnClickDomain(liPanel,courseSubjectDo.getSubdomainId(),title)); 
				liPanel.add(title);
				domainUlContainer.add(liPanel);
			}
		}
		if(domainUlContainer.getWidgetCount()>0){
			if(!"Unit".equalsIgnoreCase(viewType)){
				domainUlContainer.getWidget(0).addStyleName("active");
				previousSelectedDomainLiPanel = (LiPanel) domainUlContainer.getWidget(0);
			}
		}
	}
	
	public class OnClickDomain implements ClickHandler{
		LiPanel liPanel;
		int subDomainId;
		Anchor title;
		public OnClickDomain(LiPanel liPanel,int subDomainId,Anchor title) {
			this.liPanel = liPanel;
			this.subDomainId = subDomainId;
			this.title = title;
		}
		@Override
		public void onClick(ClickEvent event) {
			if("Unit".equalsIgnoreCase(viewType)){
				setStandardsActiveStyle(liPanel,previousSelectedDomainLiPanel);
				final LiPanelWithClose liPanelWithClose=new LiPanelWithClose(title.getText());
				liPanelWithClose.setId(subDomainId);
				liPanelWithClose.setName(title.getText());
				liPanelWithClose.getCloseButton().addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						removeSelectedDomainStyle(liPanelWithClose,viewType);
						liPanelWithClose.removeFromParent();
					}
				});
				addOrRemoveContent(liPanel,previousSelectedDomainLiPanel,liPanelWithClose);
			}else{
				setSubCouDomainActiveStyle(liPanel,previousSelectedDomainLiPanel);
			}
			previousSelectedDomainLiPanel = liPanel;
			standardsUlContainer.clear();
			getUiHandlers().getStdBasedOnSelectedDomain(subDomainId);
		}
	}
	
	

	@Override
	public void addTaxonomyStandards(List<DomainStandardsDo> taxonomyStdList) {
		standardsUlContainer.clear();
		
		for(DomainStandardsDo domainStandardsDo:taxonomyStdList){
			LiPanel liPanel=new LiPanel();
			HTMLEventPanel htmlPanel = new HTMLEventPanel("");
			Anchor title=new Anchor(domainStandardsDo.getCode());
			Label lblStandardDesc = new Label();
			lblStandardDesc.setText(domainStandardsDo.getLabel());			
			Label lblStandardcode = new Label();
			lblStandardcode.setText(domainStandardsDo.getCode());

			liPanel.setCodeId(domainStandardsDo.getCodeId());
			if(!domainStandardsDo.getCode().contains("Math"))
			{
			htmlPanel.add(lblStandardcode);
			htmlPanel.add(lblStandardDesc);
			htmlPanel.setStyleName("standardDiv");
			htmlPanel.addClickHandler(new OnClickStandards(liPanel,domainStandardsDo.getCodeId(),title));
			}
			else
			{
			htmlPanel.add(lblStandardDesc);	
			htmlPanel.setStyleName("standardDiv");
			}
			liPanel.add(htmlPanel);
			standardsUlContainer.add(liPanel);
			displaysubTaxonomyStandards(domainStandardsDo.getNode());
		}
		/*if(standardsUlContainer.getWidgetCount()>0){
			standardsUlContainer.getWidget(0).addStyleName("active");
			previousSelectedStdLiPanel = (LiPanel) standardsUlContainer.getWidget(0);
		}*/
	}
	
	
	public void displaysubTaxonomyStandards(List<SubDomainStandardsDo> taxonomyStdList) {
		//standardsUlContainer.clear();
		
		for(SubDomainStandardsDo subdomainStandardsDo:taxonomyStdList){
			LiPanel liPanel=new LiPanel();
			HTMLEventPanel htmlPanel = new HTMLEventPanel("");
			Anchor title=new Anchor(subdomainStandardsDo.getCode());
			Label lblStandardDesc = new Label();
			lblStandardDesc.setText(subdomainStandardsDo.getLabel());			
			Label lblStandardcode = new Label();
			lblStandardcode.setText(subdomainStandardsDo.getCode());
			htmlPanel.add(lblStandardcode);
			htmlPanel.add(lblStandardDesc);
			htmlPanel.setStyleName("standardDivSub");
			liPanel.setCodeId(subdomainStandardsDo.getCodeId());
			htmlPanel.addClickHandler(new OnClickStandards(liPanel,subdomainStandardsDo.getCodeId(),title)); 
			liPanel.add(htmlPanel);
			standardsUlContainer.add(liPanel);
			displaysubsubTaxonomyStandards(subdomainStandardsDo.getNode());
		}
		/*if(standardsUlContainer.getWidgetCount()>0){
			standardsUlContainer.getWidget(0).addStyleName("active");
			previousSelectedStdLiPanel = (LiPanel) standardsUlContainer.getWidget(0);
		}*/
	}
	
	public void displaysubsubTaxonomyStandards(List<SubSubDomainStandardsDo> taxonomyStdList) {
		//standardsUlContainer.clear();
		
		for(SubSubDomainStandardsDo subsubdomainStandardsDo:taxonomyStdList){
			LiPanel liPanel=new LiPanel();
			HTMLEventPanel htmlPanel = new HTMLEventPanel("");
			Anchor title=new Anchor(subsubdomainStandardsDo.getCode());
			Label lblStandardDesc = new Label();
			lblStandardDesc.setText(subsubdomainStandardsDo.getLabel());			
			Label lblStandardcode = new Label();
			lblStandardcode.setText(subsubdomainStandardsDo.getCode());
			htmlPanel.add(lblStandardcode);
			htmlPanel.add(lblStandardDesc);
			htmlPanel.setStyleName("standardDivSubSub");
			liPanel.setCodeId(subsubdomainStandardsDo.getCodeId());
			htmlPanel.addClickHandler(new OnClickStandards(liPanel,subsubdomainStandardsDo.getCodeId(),title)); 
			liPanel.add(htmlPanel);
			standardsUlContainer.add(liPanel);
		}
		/*if(standardsUlContainer.getWidgetCount()>0){
			standardsUlContainer.getWidget(0).addStyleName("active");
			previousSelectedStdLiPanel = (LiPanel) standardsUlContainer.getWidget(0);
		}*/
	}
	
	

	public class OnClickStandards implements ClickHandler{
		LiPanel liPanel;
		int id;
		Anchor title;
		public OnClickStandards(LiPanel liPanel,int id,Anchor title) {
			this.liPanel = liPanel;
			this.id = id;
			this.title = title;
		}
		@Override
		public void onClick(ClickEvent event) {
			setStandardsActiveStyle(liPanel,previousSelectedStdLiPanel);
			final LiPanelWithClose liPanelWithClose=new LiPanelWithClose(title.getText());
			liPanelWithClose.setId(id);
			liPanelWithClose.getCloseButton().addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					removeSelectedDomainStyle(liPanelWithClose, viewType); 
					liPanelWithClose.removeFromParent();
				}
			});
			addOrRemoveContent(liPanel,previousSelectedDomainLiPanel,liPanelWithClose);
			previousSelectedStdLiPanel = liPanel;
		}
	} 


	public void setStandardsActiveStyle(LiPanel selectedLiPanel,LiPanel previousSelectedStdLiPanel) {
		if(selectedLiPanel.getStyleName().contains("active")){ 
			selectedLiPanel.removeStyleName("active");
		}else{
			selectedLiPanel.addStyleName("active");
		}
	}
	
	private void setSubCouDomainActiveStyle(LiPanel selectedLiPanel,LiPanel previousSelectedLiPanel) {
		selectedLiPanel.addStyleName("active");
		previousSelectedLiPanel.removeStyleName("active");
	}
	
	public void addOrRemoveContent(LiPanel selectedLiPanel,	LiPanel previousSelectedDomainLiPanel, LiPanelWithClose liPanelWithClose) {
		if(!selectedLiPanel.getStyleName().contains("active")){
			removeAddedContent(String.valueOf(liPanelWithClose.getId())); 
		}else{
			selectedUlContainer.add(liPanelWithClose);
		}
	}


	private void removeAddedContent(String id) {
		Iterator<Widget> widgets=selectedUlContainer.iterator();
		while (widgets.hasNext()) {
			Widget widget = widgets.next();
			if (widget instanceof LiPanelWithClose && (String.valueOf(((LiPanelWithClose) widget).getId())).equals(id)) {
				widget.removeFromParent();
			}
		}
	}
	
	public void removeSelectedDomainStyle(LiPanelWithClose liPanelWithClose, String type) {
		Iterator<Widget> widgets;
		if("Unit".equalsIgnoreCase(type)){
			widgets = domainUlContainer.iterator();
		}else{
			widgets = standardsUlContainer.iterator();
		}
		while(widgets.hasNext()){
			Widget widget = widgets.next();
			if(widget instanceof LiPanel && (((LiPanel) widget).getCodeId()==liPanelWithClose.getId())){
				widget.removeStyleName("active");
			}
		}
	}

	@Override
	public void setCurrentTypeView(String viewType) {
		this.viewType = viewType;
		selectedUlContainer.clear();
		clearAllContainers();
		setButtonActiveStyle(k12Btn);
	}
	
	private void clearAllContainers() {
		subjectUlContainer.clear();
		courseUlContainer.clear();
		domainUlContainer.clear();
		standardsUlContainer.clear();
	}

	/*@Override
	public void displaySelectedTaxonomyData(UlPanel ulSelectedItems) {
		Iterator<Widget> widgets = ulSelectedItems.iterator();
		
		while(widgets.hasNext()){
			Widget widget = widgets.next();
			if(widget instanceof LiPanelWithClose){
				setActiveStyle(((LiPanelWithClose) widget).getId());
				selectedUlContainer.add(widget);
			}
		}
	}*/

	private void setActiveStyle(long id) {
		Iterator<Widget> widgets;
		if("Unit".equalsIgnoreCase(viewType)){
			widgets = domainUlContainer.iterator();
		}else{
			widgets = standardsUlContainer.iterator();
		}
		while(widgets.hasNext()){
			Widget widget = widgets.next();
			if(widget instanceof LiPanel && ((LiPanel) widget).getCodeId() == id){
				widget.setStyleName("active");
			}
		}
	}

	@Override
	public void displaySelectedTaxonomyData(List<LiPanelWithClose> liPanelWithCloseArrayData) {
		
		for(int i=0;i<liPanelWithCloseArrayData.size();i++){
			setActiveStyle(liPanelWithCloseArrayData.get(i).getId()); 
			selectedUlContainer.add(liPanelWithCloseArrayData.get(i));
		}
		
//		Iterator<Widget> widgets = ulSelectedItems.iterator();
		
		/*while(widgets.hasNext()){
			Widget widget = widgets.next();
			if(widget instanceof LiPanelWithClose){
				setActiveStyle(((LiPanelWithClose) widget).getId());
				selectedUlContainer.add(widget);
			}
		}*/
	}

}
