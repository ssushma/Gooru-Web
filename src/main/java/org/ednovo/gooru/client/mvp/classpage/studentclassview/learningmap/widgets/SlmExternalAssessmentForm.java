package org.ednovo.gooru.client.mvp.classpage.studentclassview.learningmap.widgets;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.model.classpages.PlanProgressDo;
import org.ednovo.gooru.client.mvp.play.collection.GwtUUIDGenerator;
import org.ednovo.gooru.client.uc.PPanel;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.PlayerDataLogEvents;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class SlmExternalAssessmentForm extends Composite {

	@UiField PPanel scoreLbl, evidenceLbl;
	
	@UiField HTMLEventPanel submit;
	
	@UiField TextBox scoreTextBox;
	
	@UiField TextArea evidence;
	
	@UiField Anchor submitTxt, inProgressTxt;
	
	int attemptedScore;
	
	private PlanProgressDo planProgressDo = null;
	
	private static SlmExternalAssessmentFormUiBinder uiBinder = GWT
			.create(SlmExternalAssessmentFormUiBinder.class);

	interface SlmExternalAssessmentFormUiBinder extends
			UiBinder<Widget, SlmExternalAssessmentForm> {
	}

	public SlmExternalAssessmentForm(PlanProgressDo planProgressDo) {
		initWidget(uiBinder.createAndBindUi(this));
		this.planProgressDo = planProgressDo;
		setIds();
		if(planProgressDo.getEvidence()!=null) {
			evidence.setText(planProgressDo.getEvidence());
		} else {
			evidence.setText("--");
		}
		scoreTextBox.setText(planProgressDo.getScoreInPercentage()+"");
	}
	
	private void setIds() {
		scoreTextBox.setMaxLength(3);
		setButtonVisibility(true);
		scoreLbl.setText("Score");
		evidenceLbl.setText("Evidence");
		scoreTextBox.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				validateScoreEvidence();
			}
		});
		scoreTextBox.addKeyPressHandler(new NumbersOnly());
		submit.addClickHandler(new SaveData());
	}
	
	private class SaveData implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			setButtonVisibility(false);
			validateScoreEvidence();
		}
	}
	
	private class NumbersOnly implements KeyPressHandler{
		@Override
		public void onKeyPress(KeyPressEvent event) {
			if (!Character.isDigit(event.getCharCode()) 
                    && event.getNativeEvent().getKeyCode() != KeyCodes.KEY_TAB 
                    && event.getNativeEvent().getKeyCode() != KeyCodes.KEY_BACKSPACE
                    && event.getNativeEvent().getKeyCode() != KeyCodes.KEY_SHIFT
                    && event.getNativeEvent().getKeyCode() != KeyCodes.KEY_ENTER
                    && event.getNativeEvent().getKeyCode() != KeyCodes.KEY_LEFT
                    && event.getNativeEvent().getKeyCode() != KeyCodes.KEY_RIGHT
                    && event.getNativeEvent().getKeyCode() != KeyCodes.KEY_DELETE){
                ((TextBox) event.getSource()).cancelKey();
            }
		}
	}
	
	private void validateScoreEvidence() {
		boolean isScore = false, isEvidence = false;
		String score = scoreTextBox.getText();
		if(score.isEmpty()){
			scoreTextBox.getElement().getStyle().setBorderColor("orange");
		}else if(score != null || score != ""){
			if(Integer.parseInt(score) >100 || Integer.parseInt(score) <0){
				scoreTextBox.getElement().getStyle().setBorderColor("orange");
			}else{
				scoreTextBox.getElement().getStyle().setBorderColor("");
				attemptedScore=Integer.valueOf(score);
				isScore = true;
			}
		}
		
		String evidenceStr = evidence.getText();
		if(evidenceStr.isEmpty()){
			evidence.getElement().getStyle().setBorderColor("orange");
		}else if(evidenceStr != null || evidenceStr.length()>0){
			scoreTextBox.getElement().getStyle().setBorderColor("");
			isEvidence = true;
		}
		if(isScore==true&&isEvidence==true) {
			logDataEvent();
		}
		setButtonVisibility(true);
	}
	
	private void logDataEvent() {
		try
		{
			JSONObject collectionDataLog=new JSONObject();
			collectionDataLog.put(PlayerDataLogEvents.EVENTID, new JSONString(GwtUUIDGenerator.uuid()));
			collectionDataLog.put(PlayerDataLogEvents.EVENTNAME, new JSONString(PlayerDataLogEvents.COLLECTION_PLAY));
			collectionDataLog.put(PlayerDataLogEvents.CONTENTGOORUID, new JSONString(planProgressDo.getGooruOId()));
			collectionDataLog.put(PlayerDataLogEvents.SESSION, PlayerDataLogEvents.getDataLogSessionObject(GwtUUIDGenerator.uuid()));
			collectionDataLog.put(PlayerDataLogEvents.STARTTIME, new JSONNumber(0L));
			collectionDataLog.put(PlayerDataLogEvents.ENDTIME, new JSONNumber(0L));
			collectionDataLog.put(PlayerDataLogEvents.USER, PlayerDataLogEvents.getDataLogUserObject());
			collectionDataLog.put(PlayerDataLogEvents.EVIDENCE, new JSONString(evidence.getText()));
			collectionDataLog.put(PlayerDataLogEvents.TYPE, new JSONString(PlayerDataLogEvents.STOP_EVENT_TYPE));
			collectionDataLog.put(PlayerDataLogEvents.COLLECTIONTYPE, new JSONString("assessment/url"));
			collectionDataLog.put(PlayerDataLogEvents.VERSION,PlayerDataLogEvents.getDataLogVersionObject());
			collectionDataLog.put(PlayerDataLogEvents.VIEWSCOUNT,new JSONNumber(1));
			collectionDataLog.put(PlayerDataLogEvents.SCORE_IN_PERCENTAGE,new JSONNumber(Integer.parseInt(scoreTextBox.getText())));
			System.out.println(collectionDataLog.toString());
			PlayerDataLogEvents.collectionStartStopEvent(collectionDataLog);
		}
		catch(Exception ex)
		{
			AppClientFactory.printSevereLogger(ex.getMessage());
		}
	}
	
	public void setButtonVisibility(boolean isVisible) {
		submitTxt.setVisible(isVisible);
		inProgressTxt.setVisible(!isVisible);
	}
}