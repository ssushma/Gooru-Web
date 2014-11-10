package org.ednovo.gooru.client.mvp.analytics.util;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public abstract class AnalyticsTabContainer extends Composite {

	private static AnalyticsTabContainerUiBinder uiBinder = GWT
			.create(AnalyticsTabContainerUiBinder.class);

	interface AnalyticsTabContainerUiBinder extends
			UiBinder<Widget, AnalyticsTabContainer> {
	}

	@UiField Button btnScoredQuestions,btnOpenEndedQuestions,btnCollectionBreakDown,btnPtint,btnSave,btnEmail;
	final String SCORED="scoredTab",OPENENDED="openendedTab",BREAKDOWN="breakdownTab",PRINT="print",SAVEBTN="save",EMAIL="email";
	
	public AnalyticsTabContainer() {
		initWidget(uiBinder.createAndBindUi(this));
		btnScoredQuestions.addClickHandler(new ClickImplemntation(SCORED));
		btnOpenEndedQuestions.addClickHandler(new ClickImplemntation(OPENENDED));
		btnCollectionBreakDown.addClickHandler(new ClickImplemntation(BREAKDOWN));
		btnPtint.addClickHandler(new ClickImplemntation(PRINT));
		btnEmail.addClickHandler(new ClickImplemntation(EMAIL));
		btnSave.addClickHandler(new ClickImplemntation(SAVEBTN));
	}
	
	public class ClickImplemntation implements ClickHandler{
		private String tabClicked;
		ClickImplemntation(String tabClicked){
			this.tabClicked=tabClicked;
		}
		@Override
		public void onClick(ClickEvent event) {
			onTabClick(tabClicked);
		}
	}
	public Button getEmailButton(){
		return btnEmail;
	}
	public abstract void onTabClick(String tabClicked);
}
