package org.ednovo.gooru.client.mvp.addTagesPopup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignCBundle;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.ResourceTagsDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

public class AddTagesPopupView extends PopupPanel implements MessageProperties{

	public PopupPanel appPopUp;
	
	private static AddTagesPopupViewUiBinder uiBinder = GWT
			.create(AddTagesPopupViewUiBinder.class);

	interface AddTagesPopupViewUiBinder extends
			UiBinder<Widget, AddTagesPopupView> {
	}

	@UiField(provided = true)
	AddTagesCBundle res;
	
	@UiField Label lexileHeader, kindergarden, level1, level2, level3, level4, level5, level6, level7, level8, level9, level10, level11, level12;
	
	@UiField Label headerEducationalUse, handout, homework, game, presentation, refMaterial, quiz, currPlan, lessonPlan, unitPlan, projectPlan, reading, textbook, article, book, activity;
	
	@UiField Button cancelBtn,addTagsBtn;
	
	@UiField HTMLPanel htmlMediaFeatureListContainer;
	
	@UiField ScrollPanel spanelMediaFeaturePanel;
	
	@UiField Label mediaLabel,lblMediaPlaceHolder,lblMediaFeatureArrow;
	
	@UiField Label noAds,modAds,aggreAds;
	
	@UiField Label accessHazard,flashing,flashingHazard,motionSimulation,motionSimulationHazard,sound,soundHazard;
	
	String mediaFeatureStr = GL1763;
/*	
	@UiField(provided = true)
	SlideBarView slideBar;*/
	
/*	@UiField HTMLEventPanel barSlider;
	
	@UiField HTMLPanel moveCircle;*/

	public AddTagesPopupView() {
		super(false);
/*		slideBar=new SlideBarView(1,12);
		slideBar.setStepSize(1.0);
		slideBar.setCurrentValue(1);
		slideBar.setNumTicks(12);
		slideBar.setNumLabels(12);*/
		
		this.res = AddTagesCBundle.INSTANCE;
		res.css().ensureInjected();
		add(uiBinder.createAndBindUi(this));
		
		CollectionAssignCBundle.INSTANCE.css().ensureInjected();
		
		spanelMediaFeaturePanel.setVisible(false);
		
		mediaLabel.setText("Media Feature");
		
		
		lblMediaPlaceHolder.setText("Choose a Media Feature Option:");
		
		lblMediaFeatureArrow.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				OpenMediaFeatureDropdown();
			}
		});
		
		lblMediaPlaceHolder.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				OpenMediaFeatureDropdown();
			}
		});
		
		getTagsServiceRequest("");
		
/*		barSlider.addClickHandler(new ClickHandler() 
		{
			
			@Override
			public void onClick(ClickEvent event) 
			{
		
			     Object soruce = event.getSource();			     
			     int leftPos = event.getNativeEvent().getClientX();
		            if (soruce instanceof HTMLPanel) {  //check that the source is really a button
		                int sliderBarLeftPos = (leftPos- ((HTMLPanel) soruce).getAbsoluteLeft());  //cast the source to a button
		                moveCircle.getElement().setAttribute("style", "left:"+(sliderBarLeftPos-5)+Unit.PX+";");
		            } 
		            else 
		            {
		               // RootPanel.get().add(new Label("Not a Button, can't be..."));
		            }
				
			}
		});*/
/*		slideBar.setStyleName(res.css().gwtSliderBarshell());*/
		
		List<String> mediaFeatureList = Arrays.asList(mediaFeatureStr.split(","));
		
		for(int n=0; n<mediaFeatureList.size(); n++)
		{

				String mediaTitleVal = mediaFeatureList.get(n);
				
				final Label titleLabel = new Label(mediaTitleVal);
				titleLabel.setStyleName(CollectionAssignCBundle.INSTANCE.css().classpageTitleText());
				titleLabel.getElement().setAttribute("id", mediaTitleVal);
				//Set Click event for title
				titleLabel.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {		
						String optionSelected = titleLabel.getElement().getId();
						lblMediaPlaceHolder.setText(optionSelected);
						spanelMediaFeaturePanel.setVisible(false);
						lblMediaPlaceHolder.getElement().setId(titleLabel.getElement().getId());
						lblMediaPlaceHolder.setStyleName(CollectionAssignCBundle.INSTANCE.css().selectedClasspageText());


							lblMediaPlaceHolder.setText(optionSelected);
				
					}
				});
				htmlMediaFeatureListContainer.add(titleLabel);
				
			
		}
		
	}
	
	
	@UiHandler("kindergarden")
	public void onKindergardenClick(ClickEvent click){
		System.out.println("stylename::"+kindergarden.getStyleName().toString().contains("selected"));
		if(kindergarden.getStyleName().toString().contains("selected"))
		{
			kindergarden.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			kindergarden.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("level1")
	public void onLevel1Click(ClickEvent click){
		if(level1.getStyleName().toString().contains("selected"))
		{
			level1.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			level1.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("level2")
	public void onLevel2Click(ClickEvent click){
		if(level2.getStyleName().toString().contains("selected"))
		{
			level2.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			level2.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("level3")
	public void onLevel3Click(ClickEvent click){
		if(level3.getStyleName().toString().contains("selected"))
		{
			level3.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			level3.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("level4")
	public void onLevel4Click(ClickEvent click){
		if(level4.getStyleName().toString().contains("selected"))
		{
			level4.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			level4.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("level5")
	public void onLevel5Click(ClickEvent click){
		if(level5.getStyleName().toString().contains("selected"))
		{
			level5.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			level5.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("level6")
	public void onLevel6Click(ClickEvent click){
		if(level6.getStyleName().toString().contains("selected"))
		{
			level6.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			level6.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("level7")
	public void onLevel7Click(ClickEvent click){
		if(level7.getStyleName().toString().contains("selected"))
		{
			level7.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			level7.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("level8")
	public void onLevel8Click(ClickEvent click){
		if(level8.getStyleName().toString().contains("selected"))
		{
			level8.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			level8.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("level9")
	public void onLevel9Click(ClickEvent click){
		if(level9.getStyleName().toString().contains("selected"))
		{
			level9.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			level9.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("level10")
	public void onLevel10Click(ClickEvent click){
		if(level10.getStyleName().toString().contains("selected"))
		{
			level10.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			level10.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("level11")
	public void onLevel11Click(ClickEvent click){
		if(level11.getStyleName().toString().contains("selected"))
		{
			level11.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			level11.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("level12")
	public void onLevel12Click(ClickEvent click){
		if(level12.getStyleName().toString().contains("selected"))
		{
			level12.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			level12.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	
	@UiHandler("activity")
	public void onactivityClick(ClickEvent click){
		if(activity.getStyleName().toString().contains("selected"))
		{
			activity.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		 else if (handout.getStyleName().toString().contains("selected")
						|| homework.getStyleName().toString().contains("selected")
						|| game.getStyleName().toString().contains("selected")
						|| presentation.getStyleName().toString().contains("selected")
						|| refMaterial.getStyleName().toString().contains("selected")
						|| quiz.getStyleName().toString().contains("selected")
						|| currPlan.getStyleName().toString().contains("selected")
						|| lessonPlan.getStyleName().toString().contains("selected")
						|| unitPlan.getStyleName().toString().contains("selected")
						|| projectPlan.getStyleName().toString().contains("selected")
						|| reading.getStyleName().toString().contains("selected")
						|| textbook.getStyleName().toString().contains("selected")
						|| article.getStyleName().toString().contains("selected")
						|| book.getStyleName().toString().contains("selected")) {
			 
			 activity.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
			 handout.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 homework.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 game.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 presentation.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 refMaterial.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 quiz.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 currPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 lessonPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 unitPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 projectPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 reading.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());			 
			 textbook.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 article.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 book.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			activity.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("handout")
	public void onhandoutClick(ClickEvent click){
		if(handout.getStyleName().toString().contains("selected"))
		{
			handout.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		 else if (activity.getStyleName().toString().contains("selected")
					|| homework.getStyleName().toString().contains("selected")
					|| game.getStyleName().toString().contains("selected")
					|| presentation.getStyleName().toString().contains("selected")
					|| refMaterial.getStyleName().toString().contains("selected")
					|| quiz.getStyleName().toString().contains("selected")
					|| currPlan.getStyleName().toString().contains("selected")
					|| lessonPlan.getStyleName().toString().contains("selected")
					|| unitPlan.getStyleName().toString().contains("selected")
					|| projectPlan.getStyleName().toString().contains("selected")
					|| reading.getStyleName().toString().contains("selected")
					|| textbook.getStyleName().toString().contains("selected")
					|| article.getStyleName().toString().contains("selected")
					|| book.getStyleName().toString().contains("selected")) {
		 
		 handout.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		 activity.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 homework.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 game.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 presentation.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 refMaterial.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 quiz.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 currPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 lessonPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 unitPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 projectPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 reading.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());			 
		 textbook.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 article.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 book.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 }
		else
		{
			handout.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("homework")
	public void onhomeworkClick(ClickEvent click){
		if(homework.getStyleName().toString().contains("selected"))
		{
			homework.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		 else if (activity.getStyleName().toString().contains("selected")
					|| handout.getStyleName().toString().contains("selected")
					|| game.getStyleName().toString().contains("selected")
					|| presentation.getStyleName().toString().contains("selected")
					|| refMaterial.getStyleName().toString().contains("selected")
					|| quiz.getStyleName().toString().contains("selected")
					|| currPlan.getStyleName().toString().contains("selected")
					|| lessonPlan.getStyleName().toString().contains("selected")
					|| unitPlan.getStyleName().toString().contains("selected")
					|| projectPlan.getStyleName().toString().contains("selected")
					|| reading.getStyleName().toString().contains("selected")
					|| textbook.getStyleName().toString().contains("selected")
					|| article.getStyleName().toString().contains("selected")
					|| book.getStyleName().toString().contains("selected")) {
		 
		 homework.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		 activity.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 handout.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 game.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 presentation.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 refMaterial.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 quiz.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 currPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 lessonPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 unitPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 projectPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 reading.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());			 
		 textbook.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 article.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 book.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 }
		else
		{
			homework.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("game")
	public void ongameClick(ClickEvent click){
		if(game.getStyleName().toString().contains("selected"))
		{
			game.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		 else if (activity.getStyleName().toString().contains("selected")
					|| handout.getStyleName().toString().contains("selected")
					|| homework.getStyleName().toString().contains("selected")
					|| presentation.getStyleName().toString().contains("selected")
					|| refMaterial.getStyleName().toString().contains("selected")
					|| quiz.getStyleName().toString().contains("selected")
					|| currPlan.getStyleName().toString().contains("selected")
					|| lessonPlan.getStyleName().toString().contains("selected")
					|| unitPlan.getStyleName().toString().contains("selected")
					|| projectPlan.getStyleName().toString().contains("selected")
					|| reading.getStyleName().toString().contains("selected")
					|| textbook.getStyleName().toString().contains("selected")
					|| article.getStyleName().toString().contains("selected")
					|| book.getStyleName().toString().contains("selected")) {
		 
		 game.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		 activity.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 handout.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 homework.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 presentation.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 refMaterial.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 quiz.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 currPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 lessonPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 unitPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 projectPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 reading.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());			 
		 textbook.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 article.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 book.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 }
		else
		{
			game.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("presentation")
	public void onpresentationClick(ClickEvent click){
		if(presentation.getStyleName().toString().contains("selected"))
		{
			presentation.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		 else if (activity.getStyleName().toString().contains("selected")
					|| handout.getStyleName().toString().contains("selected")
					|| homework.getStyleName().toString().contains("selected")
					|| game.getStyleName().toString().contains("selected")
					|| refMaterial.getStyleName().toString().contains("selected")
					|| quiz.getStyleName().toString().contains("selected")
					|| currPlan.getStyleName().toString().contains("selected")
					|| lessonPlan.getStyleName().toString().contains("selected")
					|| unitPlan.getStyleName().toString().contains("selected")
					|| projectPlan.getStyleName().toString().contains("selected")
					|| reading.getStyleName().toString().contains("selected")
					|| textbook.getStyleName().toString().contains("selected")
					|| article.getStyleName().toString().contains("selected")
					|| book.getStyleName().toString().contains("selected")) {
		 
		 presentation.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		 activity.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 handout.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 homework.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 game.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 refMaterial.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 quiz.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 currPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 lessonPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 unitPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 projectPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 reading.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());			 
		 textbook.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 article.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 book.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 }
		else
		{
			presentation.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("refMaterial")
	public void onrefMaterialClick(ClickEvent click){
		if(refMaterial.getStyleName().toString().contains("selected"))
		{
			refMaterial.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if (activity.getStyleName().toString().contains("selected")
					|| handout.getStyleName().toString().contains("selected")
					|| homework.getStyleName().toString().contains("selected")
					|| game.getStyleName().toString().contains("selected")
					|| presentation.getStyleName().toString().contains("selected")
					|| quiz.getStyleName().toString().contains("selected")
					|| currPlan.getStyleName().toString().contains("selected")
					|| lessonPlan.getStyleName().toString().contains("selected")
					|| unitPlan.getStyleName().toString().contains("selected")
					|| projectPlan.getStyleName().toString().contains("selected")
					|| reading.getStyleName().toString().contains("selected")
					|| textbook.getStyleName().toString().contains("selected")
					|| article.getStyleName().toString().contains("selected")
					|| book.getStyleName().toString().contains("selected")) {
		 
		 refMaterial.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		 activity.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 handout.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 homework.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 game.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 presentation.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 quiz.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 currPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 lessonPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 unitPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 projectPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 reading.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());			 
		 textbook.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 article.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 book.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		 }
		else
		{
			refMaterial.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("quiz")
	public void onquizClick(ClickEvent click){
		if(quiz.getStyleName().toString().contains("selected"))
		{
			quiz.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if (activity.getStyleName().toString().contains("selected")
				|| handout.getStyleName().toString().contains("selected")
				|| homework.getStyleName().toString().contains("selected")
				|| game.getStyleName().toString().contains("selected")
				|| presentation.getStyleName().toString().contains("selected")
				|| refMaterial.getStyleName().toString().contains("selected")
				|| currPlan.getStyleName().toString().contains("selected")
				|| lessonPlan.getStyleName().toString().contains("selected")
				|| unitPlan.getStyleName().toString().contains("selected")
				|| projectPlan.getStyleName().toString().contains("selected")
				|| reading.getStyleName().toString().contains("selected")
				|| textbook.getStyleName().toString().contains("selected")
				|| article.getStyleName().toString().contains("selected")
				|| book.getStyleName().toString().contains("selected")) {
	 
			 quiz.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
			 activity.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 handout.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 homework.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 game.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 presentation.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 refMaterial.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 currPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 lessonPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 unitPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 projectPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 reading.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());			 
			 textbook.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 article.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 book.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			quiz.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("currPlan")
	public void oncurrPlanClick(ClickEvent click){
		if(currPlan.getStyleName().toString().contains("selected"))
		{
			currPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if (activity.getStyleName().toString().contains("selected")
				|| handout.getStyleName().toString().contains("selected")
				|| homework.getStyleName().toString().contains("selected")
				|| game.getStyleName().toString().contains("selected")
				|| presentation.getStyleName().toString().contains("selected")
				|| refMaterial.getStyleName().toString().contains("selected")
				|| quiz.getStyleName().toString().contains("selected")
				|| lessonPlan.getStyleName().toString().contains("selected")
				|| unitPlan.getStyleName().toString().contains("selected")
				|| projectPlan.getStyleName().toString().contains("selected")
				|| reading.getStyleName().toString().contains("selected")
				|| textbook.getStyleName().toString().contains("selected")
				|| article.getStyleName().toString().contains("selected")
				|| book.getStyleName().toString().contains("selected")) {
	 
			 currPlan.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
			 activity.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 handout.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 homework.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 game.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 presentation.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 refMaterial.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 quiz.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 lessonPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 unitPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 projectPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 reading.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());			 
			 textbook.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 article.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 book.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			currPlan.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("lessonPlan")
	public void onlessonPlanClick(ClickEvent click){
		if(lessonPlan.getStyleName().toString().contains("selected"))
		{
			lessonPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if (activity.getStyleName().toString().contains("selected")
				|| handout.getStyleName().toString().contains("selected")
				|| homework.getStyleName().toString().contains("selected")
				|| game.getStyleName().toString().contains("selected")
				|| presentation.getStyleName().toString().contains("selected")
				|| refMaterial.getStyleName().toString().contains("selected")
				|| quiz.getStyleName().toString().contains("selected")
				|| currPlan.getStyleName().toString().contains("selected")
				|| unitPlan.getStyleName().toString().contains("selected")
				|| projectPlan.getStyleName().toString().contains("selected")
				|| reading.getStyleName().toString().contains("selected")
				|| textbook.getStyleName().toString().contains("selected")
				|| article.getStyleName().toString().contains("selected")
				|| book.getStyleName().toString().contains("selected")) {
	 
			 lessonPlan.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
			 activity.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 handout.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 homework.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 game.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 presentation.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 refMaterial.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 quiz.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 currPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 unitPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 projectPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 reading.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());			 
			 textbook.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 article.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 book.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			lessonPlan.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("unitPlan")
	public void onunitPlanClick(ClickEvent click){
		if(unitPlan.getStyleName().toString().contains("selected"))
		{
			unitPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if (activity.getStyleName().toString().contains("selected")
				|| handout.getStyleName().toString().contains("selected")
				|| homework.getStyleName().toString().contains("selected")
				|| game.getStyleName().toString().contains("selected")
				|| presentation.getStyleName().toString().contains("selected")
				|| refMaterial.getStyleName().toString().contains("selected")
				|| quiz.getStyleName().toString().contains("selected")
				|| currPlan.getStyleName().toString().contains("selected")
				|| lessonPlan.getStyleName().toString().contains("selected")
				|| projectPlan.getStyleName().toString().contains("selected")
				|| reading.getStyleName().toString().contains("selected")
				|| textbook.getStyleName().toString().contains("selected")
				|| article.getStyleName().toString().contains("selected")
				|| book.getStyleName().toString().contains("selected")) {
	 
			 unitPlan.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
			 activity.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 handout.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 homework.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 game.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 presentation.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 refMaterial.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 quiz.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 currPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 lessonPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 projectPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 reading.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());			 
			 textbook.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 article.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 book.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			unitPlan.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("projectPlan")
	public void onprojectPlanClick(ClickEvent click){
		if(projectPlan.getStyleName().toString().contains("selected"))
		{
			projectPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if (activity.getStyleName().toString().contains("selected")
				|| handout.getStyleName().toString().contains("selected")
				|| homework.getStyleName().toString().contains("selected")
				|| game.getStyleName().toString().contains("selected")
				|| presentation.getStyleName().toString().contains("selected")
				|| refMaterial.getStyleName().toString().contains("selected")
				|| quiz.getStyleName().toString().contains("selected")
				|| currPlan.getStyleName().toString().contains("selected")
				|| lessonPlan.getStyleName().toString().contains("selected")
				|| unitPlan.getStyleName().toString().contains("selected")
				|| reading.getStyleName().toString().contains("selected")
				|| textbook.getStyleName().toString().contains("selected")
				|| article.getStyleName().toString().contains("selected")
				|| book.getStyleName().toString().contains("selected")) {
	 
			 projectPlan.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
			 activity.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 handout.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 homework.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 game.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 presentation.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 refMaterial.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 quiz.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 currPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 lessonPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 unitPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 reading.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());			 
			 textbook.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 article.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 book.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			projectPlan.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("reading")
	public void onreadingClick(ClickEvent click){
		if(reading.getStyleName().toString().contains("selected"))
		{
			reading.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if (activity.getStyleName().toString().contains("selected")
				|| handout.getStyleName().toString().contains("selected")
				|| homework.getStyleName().toString().contains("selected")
				|| game.getStyleName().toString().contains("selected")
				|| presentation.getStyleName().toString().contains("selected")
				|| refMaterial.getStyleName().toString().contains("selected")
				|| quiz.getStyleName().toString().contains("selected")
				|| currPlan.getStyleName().toString().contains("selected")
				|| lessonPlan.getStyleName().toString().contains("selected")
				|| unitPlan.getStyleName().toString().contains("selected")
				|| projectPlan.getStyleName().toString().contains("selected")
				|| textbook.getStyleName().toString().contains("selected")
				|| article.getStyleName().toString().contains("selected")
				|| book.getStyleName().toString().contains("selected")) {
	 
			 reading.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
			 activity.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 handout.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 homework.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 game.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 presentation.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 refMaterial.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 quiz.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 currPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 lessonPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 unitPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 projectPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());			 
			 textbook.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 article.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 book.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			reading.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("textbook")
	public void ontextbookClick(ClickEvent click){
		if(textbook.getStyleName().toString().contains("selected"))
		{
			textbook.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if (activity.getStyleName().toString().contains("selected")
				|| handout.getStyleName().toString().contains("selected")
				|| homework.getStyleName().toString().contains("selected")
				|| game.getStyleName().toString().contains("selected")
				|| presentation.getStyleName().toString().contains("selected")
				|| refMaterial.getStyleName().toString().contains("selected")
				|| quiz.getStyleName().toString().contains("selected")
				|| currPlan.getStyleName().toString().contains("selected")
				|| lessonPlan.getStyleName().toString().contains("selected")
				|| unitPlan.getStyleName().toString().contains("selected")
				|| projectPlan.getStyleName().toString().contains("selected")
				|| reading.getStyleName().toString().contains("selected")
				|| article.getStyleName().toString().contains("selected")
				|| book.getStyleName().toString().contains("selected")) {
	 
			textbook.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
			 activity.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 handout.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 homework.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 game.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 presentation.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 refMaterial.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 quiz.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 currPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 lessonPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 unitPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 projectPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());			 
			 reading.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 article.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 book.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			textbook.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("article")
	public void onarticleClick(ClickEvent click){
		if(article.getStyleName().toString().contains("selected"))
		{
			article.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if (activity.getStyleName().toString().contains("selected")
				|| handout.getStyleName().toString().contains("selected")
				|| homework.getStyleName().toString().contains("selected")
				|| game.getStyleName().toString().contains("selected")
				|| presentation.getStyleName().toString().contains("selected")
				|| refMaterial.getStyleName().toString().contains("selected")
				|| quiz.getStyleName().toString().contains("selected")
				|| currPlan.getStyleName().toString().contains("selected")
				|| lessonPlan.getStyleName().toString().contains("selected")
				|| unitPlan.getStyleName().toString().contains("selected")
				|| projectPlan.getStyleName().toString().contains("selected")
				|| reading.getStyleName().toString().contains("selected")
				|| textbook.getStyleName().toString().contains("selected")
				|| book.getStyleName().toString().contains("selected")) {
	 
			article.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
			 activity.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 handout.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 homework.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 game.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 presentation.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 refMaterial.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 quiz.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 currPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 lessonPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 unitPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 projectPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());			 
			 reading.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 textbook.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 book.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			article.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("book")
	public void onbookClick(ClickEvent click){
		if(book.getStyleName().toString().contains("selected"))
		{
			book.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if (activity.getStyleName().toString().contains("selected")
				|| handout.getStyleName().toString().contains("selected")
				|| homework.getStyleName().toString().contains("selected")
				|| game.getStyleName().toString().contains("selected")
				|| presentation.getStyleName().toString().contains("selected")
				|| refMaterial.getStyleName().toString().contains("selected")
				|| quiz.getStyleName().toString().contains("selected")
				|| currPlan.getStyleName().toString().contains("selected")
				|| lessonPlan.getStyleName().toString().contains("selected")
				|| unitPlan.getStyleName().toString().contains("selected")
				|| projectPlan.getStyleName().toString().contains("selected")
				|| reading.getStyleName().toString().contains("selected")
				|| textbook.getStyleName().toString().contains("selected")
				|| article.getStyleName().toString().contains("selected")) {
	 
			book.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
			 activity.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 handout.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 homework.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 game.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 presentation.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 refMaterial.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 quiz.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 currPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 lessonPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 unitPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 projectPlan.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());			 
			 reading.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 textbook.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			 article.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			book.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("cancelBtn")
	public void onCancelClick(ClickEvent click)
	{
		this.hide();

	}
	
	private void OpenMediaFeatureDropdown() {
		if (spanelMediaFeaturePanel.isVisible()){
			spanelMediaFeaturePanel.setVisible(false);
		}
		
		if (spanelMediaFeaturePanel.isVisible()){
			spanelMediaFeaturePanel.setVisible(false);
		}else{
			spanelMediaFeaturePanel.setVisible(true);
		}
	}
	@UiHandler("noAds")
	public void onnoAdsClick(ClickEvent click){
		if(noAds.getStyleName().toString().contains("selected"))
		{
			noAds.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(modAds.getStyleName().toString().contains("selected") || aggreAds.getStyleName().toString().contains("selected"))
		{
			noAds.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
			modAds.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			aggreAds.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			noAds.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("modAds")
	public void onmodAdsClick(ClickEvent click){
		if(modAds.getStyleName().toString().contains("selected"))
		{
			modAds.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(noAds.getStyleName().toString().contains("selected") || aggreAds.getStyleName().toString().contains("selected"))
		{
			modAds.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
			noAds.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			aggreAds.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			modAds.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	@UiHandler("aggreAds")
	public void onaggreAdsClick(ClickEvent click){
		if(aggreAds.getStyleName().toString().contains("selected"))
		{
			aggreAds.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(noAds.getStyleName().toString().contains("selected") || modAds.getStyleName().toString().contains("selected"))
		{
			aggreAds.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
			noAds.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
			modAds.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else
		{
			aggreAds.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}

	@UiHandler("flashing")
	public void onflashingClick(ClickEvent click){
		if(flashing.getStyleName().toString().contains("select"))
		{
			flashing.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else if(soundHazard.getStyleName().toString().contains("select") ||sound.getStyleName().toString().contains("select") ||motionSimulationHazard.getStyleName().toString().contains("select") || flashingHazard.getStyleName().toString().contains("select") || motionSimulation.getStyleName().toString().contains("select"))
		{
			flashing.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
			soundHazard.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
			sound.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
			flashingHazard.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
			motionSimulation.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
			motionSimulationHazard.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else
		{
			flashing.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
		}
	}
	@UiHandler("flashingHazard")
	public void onflashingHazardClick(ClickEvent click){
		if(flashingHazard.getStyleName().toString().contains("select"))
		{
			flashingHazard.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else if(soundHazard.getStyleName().toString().contains("select") ||sound.getStyleName().toString().contains("select") ||motionSimulationHazard.getStyleName().toString().contains("select") || flashing.getStyleName().toString().contains("select") || motionSimulation.getStyleName().toString().contains("select"))
		{
			flashingHazard.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
			soundHazard.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
			sound.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
			flashing.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
			motionSimulation.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
			motionSimulationHazard.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else
		{
			flashingHazard.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
		}
	}
	@UiHandler("motionSimulation")
	public void onmotionSimulationClick(ClickEvent click){
		if(motionSimulation.getStyleName().toString().contains("select"))
		{
			motionSimulation.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else if(soundHazard.getStyleName().toString().contains("select") ||sound.getStyleName().toString().contains("select") ||motionSimulationHazard.getStyleName().toString().contains("select") || flashing.getStyleName().toString().contains("select") || flashingHazard.getStyleName().toString().contains("select"))
		{
			motionSimulation.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
			soundHazard.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
			sound.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
			flashing.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
			flashingHazard.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
			motionSimulationHazard.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else
		{
			motionSimulation.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
		}
	}
	@UiHandler("motionSimulationHazard")
	public void onmotionSimulationHazardClick(ClickEvent click){
		if(motionSimulationHazard.getStyleName().toString().contains("select"))
		{
			motionSimulationHazard.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else if(soundHazard.getStyleName().toString().contains("select") ||sound.getStyleName().toString().contains("select") ||motionSimulation.getStyleName().toString().contains("select") || flashing.getStyleName().toString().contains("select") || flashingHazard.getStyleName().toString().contains("select"))
		{
			motionSimulationHazard.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
			soundHazard.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
			sound.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
			flashing.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
			flashingHazard.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
			motionSimulation.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else
		{
			motionSimulationHazard.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
		}
	}
	@UiHandler("sound")
	public void onsoundClick(ClickEvent click){
		if(sound.getStyleName().toString().contains("select"))
		{
			sound.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else if(soundHazard.getStyleName().toString().contains("select") ||motionSimulationHazard.getStyleName().toString().contains("select") ||motionSimulation.getStyleName().toString().contains("select") || flashing.getStyleName().toString().contains("select") || flashingHazard.getStyleName().toString().contains("select"))
		{
			sound.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
			soundHazard.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
			motionSimulationHazard.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
			flashing.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
			flashingHazard.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
			motionSimulation.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else
		{
			sound.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
		}
	}
	@UiHandler("soundHazard")
	public void onsoundHazardClick(ClickEvent click){
		if(soundHazard.getStyleName().toString().contains("select"))
		{
			soundHazard.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else if(sound.getStyleName().toString().contains("select") ||motionSimulationHazard.getStyleName().toString().contains("select") ||motionSimulation.getStyleName().toString().contains("select") || flashing.getStyleName().toString().contains("select") || flashingHazard.getStyleName().toString().contains("select"))
		{
			soundHazard.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
			sound.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
			motionSimulationHazard.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
			flashing.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
			flashingHazard.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
			motionSimulation.getElement().removeClassName(AddTagesCBundle.INSTANCE.css().select());
		}
		else
		{
			soundHazard.getElement().addClassName(AddTagesCBundle.INSTANCE.css().select());
		}
	}
	
	@UiHandler("addTagsBtn")
	public void onaddTagsBtnClick(ClickEvent click)
	{
		String frameTagsStr = "";
		String educationStr = "";
		
		List<String> tagList = new ArrayList<String>();
		
		educationStr = setEducationalUseString();
		if(!educationStr.isEmpty())
		{
			frameTagsStr = educationStr;
			tagList.add("\"" + frameTagsStr +"\"");
		}
		String[] lexileMainarr = setLexileLevel();
		if(lexileMainarr != null)
		{
			for(int i=0;i<lexileMainarr.length;i++)
			{
				tagList.add("\"" + lexileMainarr[i].toString() +"\"");
			}
		
		}

		addTagsServiceRequest(tagList.toString(), "fc81bf4f-1f62-4d30-8e2a-3f518bbc8ee4");
	
	}
	
	public void addTagsServiceRequest(String frameTagsStr, String resourceId)
	{
		AppClientFactory.getInjector().getResourceService().addTagsToResource(resourceId, frameTagsStr, new SimpleAsyncCallback<List<ResourceTagsDo>>() {
			@Override
			public void onSuccess(List<ResourceTagsDo> result) {
				bindObjectsToUI(result);
			}
		});
	
	}
	
	public void getTagsServiceRequest(String resourceId)
	{
		AppClientFactory.getInjector().getResourceService().getTagsToResource("fc81bf4f-1f62-4d30-8e2a-3f518bbc8ee4", new SimpleAsyncCallback<List<ResourceTagsDo>>() {
			@Override
			public void onSuccess(List<ResourceTagsDo> result) {
				bindObjectsToUI(result);
			}
		});
	
	}
	
	public void bindObjectsToUI(List<ResourceTagsDo> resultResourceTags)
	{
		for(int objVal=0;objVal<resultResourceTags.size();objVal++)
		{
			if(resultResourceTags.get(objVal).getLabel().contains(headerEducationalUse.getText()))
			{
				setEducationalObjectVal(resultResourceTags.get(objVal).getLabel());
			}
			if(resultResourceTags.get(objVal).getLabel().contains(lexileHeader.getText()))
			{
				setLexileObjectVal(resultResourceTags.get(objVal).getLabel());
			}
		}
	}
	public void setLexileObjectVal(String lexileStr)
	{
		if(kindergarden.getText().contains(lexileStr))
		{
			kindergarden.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		if(level1.getText().contains(lexileStr))
		{
			level1.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		if(level2.getText().contains(lexileStr))
		{
			level2.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		if(level3.getText().contains(lexileStr))
		{
			level3.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		if(level4.getText().contains(lexileStr))
		{
			level4.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		if(level5.getText().contains(lexileStr))
		{
			level5.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		if(level6.getText().contains(lexileStr))
		{
			level6.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		if(level7.getText().contains(lexileStr))
		{
			level7.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		if(level8.getText().contains(lexileStr))
		{
			level8.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		if(level9.getText().contains(lexileStr))
		{
			level9.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		if(level10.getText().contains(lexileStr))
		{
			level10.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		if(level11.getText().contains(lexileStr))
		{
			level11.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		if(level12.getText().contains(lexileStr))
		{
			level12.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		
	}
	
	public void setEducationalObjectVal(String educationalStr)
	{
		if(activity.getText().contains(educationalStr))
		{
			activity.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(handout.getText().contains(educationalStr))
		{
			handout.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());	
		}
		else if(homework.getText().contains(educationalStr))
		{
			homework.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(game.getText().contains(educationalStr))
		{
			game.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(presentation.getText().contains(educationalStr))
		{
			presentation.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(refMaterial.getText().contains(educationalStr))
		{
			refMaterial.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(quiz.getText().contains(educationalStr))
		{
			quiz.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(currPlan.getText().contains(educationalStr))
		{
			currPlan.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(lessonPlan.getText().contains(educationalStr))
		{
			lessonPlan.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(unitPlan.getText().contains(educationalStr))
		{
			unitPlan.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(projectPlan.getText().contains(educationalStr))
		{
			projectPlan.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(reading.getText().contains(educationalStr))
		{
			reading.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(textbook.getText().contains(educationalStr))
		{
			textbook.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(article.getText().contains(educationalStr))
		{
			article.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
		else if(book.getText().contains(educationalStr))
		{
			book.getElement().addClassName(AddTagesCBundle.INSTANCE.css().selected());
		}
	}
	
	public String setEducationalUseString()
	{
		String educationalUse = "";
		if(activity.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + activity.getText();
		}
		else if(handout.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + handout.getText();	
		}
		else if(homework.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + homework.getText();	
		}
		else if(game.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + game.getText();
		}
		else if(presentation.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + presentation.getText();
		}
		else if(refMaterial.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + refMaterial.getText();
		}
		else if(quiz.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + quiz.getText();
		}
		else if(currPlan.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + currPlan.getText();
		}
		else if(lessonPlan.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + lessonPlan.getText();
		}
		else if(unitPlan.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + unitPlan.getText();
		}
		else if(projectPlan.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + projectPlan.getText();
		}
		else if(reading.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + reading.getText();
		}
		else if(textbook.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + textbook.getText();
		}
		else if(article.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + article.getText();
		}
		else if(book.getElement().getClassName().contains("selected"))
		{
			educationalUse = headerEducationalUse.getText() + " : " + book.getText();
		}
		return educationalUse;
	}
	
	public String[] setLexileLevel()
	{
		String[] lexileLevelArr = null;
		List<String> lexileSelectedOptions = new ArrayList<String>();
		
		if(kindergarden.getElement().getClassName().contains("selected"))
		{
			String lexileStr = lexileHeader.getText() + " : " + kindergarden.getText();
			lexileSelectedOptions.add(lexileStr);
		}
		if(level1.getElement().getClassName().contains("selected"))
		{
			String lexileStr = lexileHeader.getText() + " : " + level1.getText();
			lexileSelectedOptions.add(lexileStr);
		}
		if(level2.getElement().getClassName().contains("selected"))
		{
			String lexileStr = lexileHeader.getText() + " : " + level2.getText();
			lexileSelectedOptions.add(lexileStr);
		}
		if(level3.getElement().getClassName().contains("selected"))
		{
			String lexileStr = lexileHeader.getText() + " : " + level3.getText();
			lexileSelectedOptions.add(lexileStr);
		}
		if(level4.getElement().getClassName().contains("selected"))
		{
			String lexileStr = lexileHeader.getText() + " : " + level4.getText();
			lexileSelectedOptions.add(lexileStr);
		}
		if(level5.getElement().getClassName().contains("selected"))
		{
			String lexileStr = lexileHeader.getText() + " : " + level5.getText();
			lexileSelectedOptions.add(lexileStr);
		}
		if(level6.getElement().getClassName().contains("selected"))
		{
			String lexileStr = lexileHeader.getText() + " : " + level6.getText();
			lexileSelectedOptions.add(lexileStr);
		}
		if(level7.getElement().getClassName().contains("selected"))
		{
			String lexileStr = lexileHeader.getText() + " : " + level7.getText();
			lexileSelectedOptions.add(lexileStr);
		}
		if(level8.getElement().getClassName().contains("selected"))
		{
			String lexileStr = lexileHeader.getText() + " : " + level8.getText();
			lexileSelectedOptions.add(lexileStr);
		}
		if(level9.getElement().getClassName().contains("selected"))
		{
			String lexileStr = lexileHeader.getText() + " : " + level9.getText();
			lexileSelectedOptions.add(lexileStr);
		}
		if(level10.getElement().getClassName().contains("selected"))
		{
			String lexileStr = lexileHeader.getText() + " : " + level10.getText();
			lexileSelectedOptions.add(lexileStr);
		}
		if(level11.getElement().getClassName().contains("selected"))
		{
			String lexileStr = lexileHeader.getText() + " : " + level11.getText();
			lexileSelectedOptions.add(lexileStr);
		}
		if(level12.getElement().getClassName().contains("selected"))
		{
			String lexileStr = lexileHeader.getText() + " : " + level12.getText();
			lexileSelectedOptions.add(lexileStr);
		}
		System.out.println("array lexileSelectedOptions:"+lexileSelectedOptions);
		lexileLevelArr = lexileSelectedOptions.toArray(new String[lexileSelectedOptions.size()]);
		
		System.out.println("array added:"+lexileLevelArr);
		return lexileLevelArr;
		
	}
	
	
	
	@Override
	public Widget asWidget() {
		
		return null;
	}
}
