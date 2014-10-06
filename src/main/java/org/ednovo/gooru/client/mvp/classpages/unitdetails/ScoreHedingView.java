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
package org.ednovo.gooru.client.mvp.classpages.unitdetails;



import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.classpages.event.UpdateUnitSetGoalEvent;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.ClassUnitsListDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @description : This class used to show student score in Assignments
 *
 * @version :1.1
 *
 * @date: Sep 16 2014

 * @Author Gooru Team
 * 
 * Reviewer Gooru Team
 *
 */
public class ScoreHedingView extends Composite {

	private static ScoreHedingViewUiBinder uiBinder = GWT
			.create(ScoreHedingViewUiBinder.class);

	private MessageProperties i18n = GWT.create(MessageProperties.class);

	interface ScoreHedingViewUiBinder extends UiBinder<Widget, ScoreHedingView> {
	}

	@UiField Label lblTitle,lblControl,lblRedControl,lblScore,lblValidation;

	@UiField TextBox txtScore;

	@UiField Button btnSetGoal;

	String collectionItemId;

	ClassUnitsListDo classUnitsListDo;

	private int redScore, finalScore;

	private String SETGOAL= i18n.GL2197();

	private String EDITGOAL= i18n.GL2196();



	/**
	 * Because this class has a default constructor, it can
	 * be used as a binder template. In other words, it can be used in other
	 * *.ui.xml files as follows:
	 * <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
	 *   xmlns:g="urn:import:**user's package**">
	 *  <g:**UserClassName**>Hello!</g:**UserClassName>
	 * </ui:UiBinder>
	 * Note that depending on the widget that is used, it may be necessary to
	 * implement HasHTML instead of HasText.
	 */
	public ScoreHedingView(ClassUnitsListDo classUnitsListDo) {
		this.classUnitsListDo=classUnitsListDo;
		initWidget(uiBinder.createAndBindUi(this));
		setStaticText();
		txtScore.addBlurHandler(new ScoreHandler());
		txtScore.addKeyPressHandler(new HasNumbersOnly());
		txtScore.setMaxLength(3);
		lblScore.setVisible(false);
		lblValidation.setVisible(false);
	}

	private void setStaticText() {
		lblTitle.setText(i18n.GL2195());
		lblControl.getElement().setId("controll");
		btnSetGoal.setText(SETGOAL);
		StringUtil.setAttributes(lblTitle.getElement(),"lblTitle", null, lblTitle.getText());
		StringUtil.setAttributes(btnSetGoal.getElement(),"btnSetGoal", btnSetGoal.getText(), btnSetGoal.getText());
		StringUtil.setAttributes(txtScore.getElement(), "txtScore",null,null);
		StringUtil.setAttributes(lblScore.getElement(),"lblScore", null, null);
	}

	/**
	 * To show unit goals values 
	 */
	public void showUnitStatus() {
		// TODO Auto-generated method stub
		if(classUnitsListDo!=null){
			System.out.println("title:"+getLblTitle().getText());
			if(getLblTitle().getText().equals(i18n.GL2195())){
				System.out.println("minimumscore::"+classUnitsListDo.getMinimumScoreByUser());
				if(classUnitsListDo.getMinimumScoreByUser()!=null){
					showAndHideTextBox();
					txtScore.setText(classUnitsListDo.getMinimumScoreByUser()+"");
					lblScore.setText(txtScore.getText());
					StringUtil.setAttributes(lblScore.getElement(),"lblScore", null, lblScore.getText());
					btnSetGoal.setStyleName("secondary");
					btnSetGoal.setText(EDITGOAL);
					StringUtil.setAttributes(btnSetGoal.getElement(),"btnSetGoal", btnSetGoal.getText(), btnSetGoal.getText());
					showingScoreReader();
				}
			}else{
				System.out.println("else::::");
				if(classUnitsListDo.getAssignmentCompleted()!=null){
					showAndHideTextBox();
					txtScore.setText(classUnitsListDo.getAssignmentCompleted()+"");
					lblScore.setText(txtScore.getText());
					StringUtil.setAttributes(lblScore.getElement(),"lblScore", null, lblScore.getText());
					btnSetGoal.setStyleName("secondary");
					btnSetGoal.setText(EDITGOAL);
					StringUtil.setAttributes(btnSetGoal.getElement(),"btnSetGoal", btnSetGoal.getText(), btnSetGoal.getText());
					showingScoreReader();
				}
			}
		}
	}
	/**
	 * To show the score reader values and validate the set goal values
	 *
	 */
	public class ScoreHandler implements BlurHandler{

		@Override
		public void onBlur(BlurEvent event) {
			String score = txtScore.getText();
			if(score != null || score != ""){
				try{
					if(Integer.parseInt(score) >100 || Integer.parseInt(score)<0){
						lblControl.getElement().setId("controll");
						setGoalValidation(i18n.GL2253());
					}else{
						txtScore.getElement().setAttribute("style", "border-color: #efefef !important;");
						lblValidation.setVisible(false);
						showingScoreReader();
					}
				}catch(NumberFormatException numberFormatException){
					numberFormatException.printStackTrace();
				}

			}
		}

	}
	/**
	 * To show the score reader position.
	 */
	private void showingScoreReader() {
		// TODO Auto-generated method stub
		int scoreValue= Integer.parseInt(txtScore.getText());
		finalScore=((scoreValue*176)/100);
		finalScore=finalScore-176;
		redScore=((50*66)/100);
		redScore=redScore-119;
		lblControl.getElement().setId("controll");
		lblControl.getElement().setAttribute("style", "-webkit-transform: rotate("+finalScore+"deg);");
	}

	/**
	 * Get the valid assignments average score
	 * @param score
	 * @return valid score
	 */

	private String getValidationScore(String score) {
		if(Integer.parseInt(score) >100){
			return "100";
		}
		if(Integer.parseInt(score)<0){

			return "0";
		}
		return null;
	}

	/**
	 * This inner class used for to restrict text box values only numbers
	 *
	 */

	public class HasNumbersOnly implements KeyPressHandler {

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
	/**
	 * Click event for Set Goal Button
	 * @param clickEvent
	 */
	@UiHandler("btnSetGoal")
	public void clickOnSetGoal(ClickEvent clickEvent){
		String score = txtScore.getText();
		if(score!=null && !score.equals("")){
			try{
				if(Integer.parseInt(score) >100 || Integer.parseInt(score)<0){
					lblControl.getElement().setId("controll");
					setGoalValidation(i18n.GL2253());
				}else{
					txtScore.getElement().setAttribute("style", "border-color: #efefef !important;");
					lblValidation.setVisible(false);
					if(btnSetGoal.getText().equals(SETGOAL)){
						showAndHideTextBox();
						lblScore.setText(txtScore.getText());
						StringUtil.setAttributes(lblScore.getElement(),"lblScore", null, lblScore.getText());
						btnSetGoal.setStyleName("secondary");
						btnSetGoal.setText(EDITGOAL);
						StringUtil.setAttributes(btnSetGoal.getElement(),"btnSetGoal", btnSetGoal.getText(), btnSetGoal.getText());
						collectionItemId=classUnitsListDo.getCollectionItemId();
						if(collectionItemId!=null){
							if(getLblTitle().getText().equals(i18n.GL2195())){
								updateUnitstatus(collectionItemId, txtScore.getText(), null, null);
							}else{
								updateUnitstatus(collectionItemId, null, txtScore.getText(), null);
							}
						}


					}else{
						showAndHideTextBox();
						btnSetGoal.setStyleName("primary");
						btnSetGoal.setText(SETGOAL);
						StringUtil.setAttributes(btnSetGoal.getElement(),"btnSetGoal", btnSetGoal.getText(), btnSetGoal.getText());
						lblRedControl.getElement().setId("redControll");
					}
				}
			}catch(Exception e){
				
			}
			
		}else{

			setGoalValidation(i18n.GL2252());

		}
	}
	/**
	 * To set the score/goal validation messages
	 */
	private void setGoalValidation(String msg) {
		txtScore.getElement().setAttribute("style", "border-color: #FBB03B !important;");
		lblValidation.setVisible(true);
		lblValidation.setStyleName("errorMessage");
		lblValidation.setText(msg);
		StringUtil.setAttributes(lblValidation.getElement(), "lblValidation", null, lblValidation.getText());
	}

	/**
	 * show and hide text boxes
	 */
	public void showAndHideTextBox(){
		if(btnSetGoal.getText().equals(SETGOAL)){
			txtScore.setVisible(false);
			lblScore.setVisible(true);
		}else{
			txtScore.setVisible(true);
			lblScore.setVisible(false);
		}
	}
	/**
	 * @return lblTitle
	 */
	public Label getLblTitle() {
		return lblTitle;
	}
	/**
	 * This API used for to Update the Unit status.
	 * @param collectionItemId as Unit id	
	 * @param minimumScoreByuser 
	 * @param assignmentStatus
	 * @param time
	 */
	public void updateUnitstatus(String collectionItemId, String minimumScoreByuser, String assignmentStatus, String time){
		AppClientFactory.getInjector().getClasspageService().updateUnitStatus(collectionItemId, minimumScoreByuser,assignmentStatus,time, new SimpleAsyncCallback<ClassUnitsListDo>() {

			@Override
			public void onSuccess(ClassUnitsListDo result) {
				// TODO Auto-generated method stub
				if(result!=null){
					int minScore=(result.getMinimumScoreByUser()!=null && !result.getMinimumScoreByUser().equals("")) ? result.getMinimumScoreByUser():0;
					int assignmentStatusValue=(result.getAssignmentCompleted()!=null && !result.getAssignmentCompleted().equals("")) ? result.getAssignmentCompleted():0;
					AppClientFactory.fireEvent(new UpdateUnitSetGoalEvent(minScore, assignmentStatusValue, null));
				}
				
			}
		});
	}


}
