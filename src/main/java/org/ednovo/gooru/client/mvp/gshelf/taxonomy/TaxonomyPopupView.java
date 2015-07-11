package org.ednovo.gooru.client.mvp.gshelf.taxonomy;

import java.util.ArrayList;
import java.util.List;

import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.client.uc.LiPanel;
import org.ednovo.gooru.client.uc.UlPanel;

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
	
	@UiField Button k12Btn,higherEduBtn, profLearningBtn;
	
	@UiField UlPanel subjectUlContainer,courseUlContainer,domainUlContainer, standardsUlContainer;
	
	LiPanel previousSelectedLiPanel = new LiPanel();
	
	LiPanel previousSelectedCourseLiPanel = new LiPanel();
	
	LiPanel previousSelectedDomainLiPanel = new LiPanel();
	
	LiPanel previousSelectedStdLiPanel = new LiPanel();
	
	List<Button> buttonsList = new ArrayList<Button>();
	
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
	}
	
	
	/**
	 * 
	 * @param event
	 */
	@UiHandler("higherEduBtn")
	public void onClickHigherEduBtn(ClickEvent event){
		setButtonActiveStyle(higherEduBtn);
	}
	
	
	/**
	 * 
	 * @param event
	 */
	@UiHandler("profLearningBtn")
	public void onClickProfLearningBtn(ClickEvent event){
		setButtonActiveStyle(profLearningBtn);
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
	public void addTaxonomySubjects() {
		subjectUlContainer.clear();
		for(int i=0;i<4;i++){
			LiPanel liPanel=new LiPanel();
			Anchor title=new Anchor("Science "+i);
			liPanel.setTitle("Science "+i);
			title.addClickHandler(new OnClickSubjects(liPanel,i)); 
			liPanel.add(title);
			subjectUlContainer.add(liPanel);
		}
		subjectUlContainer.getWidget(0).addStyleName("active");
		previousSelectedLiPanel = (LiPanel) subjectUlContainer.getWidget(0);
	}
	
	
	
	public class OnClickSubjects implements ClickHandler{
		LiPanel liPanel;
		int id;
		public OnClickSubjects(LiPanel liPanel,int id) {
			this.liPanel = liPanel;
			this.id = id;
		}
		@Override
		public void onClick(ClickEvent event) {
			setSubCouDomainActiveStyle(liPanel,previousSelectedLiPanel);
			previousSelectedLiPanel = liPanel;
			getUiHandlers().getCoursesBasedOnSelectedSub();
		}
	}


	@Override
	public void addTaxonomyCourses() {
		courseUlContainer.clear();
		for(int i=0;i<7;i++){
			LiPanel liPanel=new LiPanel();
			Anchor title=new Anchor("Course "+i);
			liPanel.setTitle("Course "+i);
			title.addClickHandler(new OnClickCourses(liPanel,i,title));
			liPanel.add(title);
			courseUlContainer.add(liPanel);
		}
		courseUlContainer.getWidget(0).addStyleName("active");
		previousSelectedCourseLiPanel = (LiPanel) courseUlContainer.getWidget(0);
	}
	
	
	public class OnClickCourses implements ClickHandler{
		LiPanel liPanel;
		int id;
		Anchor title;
		public OnClickCourses(LiPanel liPanel,int id, Anchor title) {
			this.liPanel = liPanel;
			this.id = id;
			this.title = title;
		}
		@Override
		public void onClick(ClickEvent event) {
			setSubCouDomainActiveStyle(liPanel,previousSelectedCourseLiPanel);
			previousSelectedCourseLiPanel = liPanel;
			getUiHandlers().getDomainsBasedOnSelectedCourse();
		}
	}


	@Override
	public void addTaxonomyDomains() {
		domainUlContainer.clear();
		for(int i=0;i<9;i++){
			LiPanel liPanel=new LiPanel();
			Anchor title=new Anchor("Domain "+i);
			liPanel.setTitle("Domain "+i);
			title.addClickHandler(new OnClickDomain(liPanel,i,title)); 
			liPanel.add(title);
			domainUlContainer.add(liPanel);
		}
		domainUlContainer.getWidget(0).addStyleName("active");
		previousSelectedDomainLiPanel = (LiPanel) domainUlContainer.getWidget(0);
	}
	
	public class OnClickDomain implements ClickHandler{
		LiPanel liPanel;
		int id;
		Anchor title;
		public OnClickDomain(LiPanel liPanel,int id,Anchor title) {
			this.liPanel = liPanel;
			this.id = id;
			this.title = title;
		}
		@Override
		public void onClick(ClickEvent event) {
			setSubCouDomainActiveStyle(liPanel,previousSelectedDomainLiPanel);
			previousSelectedDomainLiPanel = liPanel;
			getUiHandlers().getSubjectsBasedOnSelectedDomain();
		}
	}


	@Override
	public void addTaxonomyStandards() {
		standardsUlContainer.clear();
		for(int i=0;i<11;i++){
			LiPanel liPanel=new LiPanel();
			Anchor title=new Anchor("Standard "+i);
			liPanel.setTitle("Standard "+i);
			title.addClickHandler(new OnClickStandards(liPanel,i,title)); 
			liPanel.add(title);
			standardsUlContainer.add(liPanel);
		}
		standardsUlContainer.getWidget(0).addStyleName("active");
		previousSelectedStdLiPanel = (LiPanel) standardsUlContainer.getWidget(0);
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

}
