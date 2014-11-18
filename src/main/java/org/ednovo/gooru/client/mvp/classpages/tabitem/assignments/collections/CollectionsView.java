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
package org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ednovo.gooru.client.DataInsightsUrlTokens;
import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.child.ChildView;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.analytics.AnalyticsPresenter;
import org.ednovo.gooru.client.mvp.classpages.assignments.AddAssignmentContainerCBundle;
import org.ednovo.gooru.client.mvp.search.SearchResultWrapperCBundle;
import org.ednovo.gooru.client.uc.DownToolTipWidgetUc;
import org.ednovo.gooru.client.uc.StandardSgItemVc;
import org.ednovo.gooru.client.uc.UcCBundle;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.analytics.CollectionSummaryMetaDataDo;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.shared.model.content.StandardFo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : CollectionsView.java
 *
 * @description : This class is used to display the collection in an assignment tab.
 *
 *
 * @version : 1.0
 *
 * @date: May 10, 2013
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
public class CollectionsView extends ChildView<CollectionsPresenter> implements IsCollectionsView{
	
	public static final String STANDARD_CODE = "code";
	
	public static final String STANDARD_DESCRIPTION = "description";
	
	public static final String COMPLETED="completed";
	
	public static final String OPEN="open";
	
	@UiField HTMLPanel thumbnailContainer,directionContentPanel,minimumScoreContentPanel,dueDateContentPanel,editAssignmentContainer;
	
	@UiField HTML learningObject;
	
	@UiField Anchor classpageItemTitle;
	
	@UiField Image collectionImage;
	
	@UiField Label assignmentSequenceLabel,dueDateText,dueDateButton,savingLabel,scoreErrorLabel,minutesErrorLabel,avarageReactionLabel,viewsLabel;
	
	@UiField FlowPanel frameContainer,analyticsContainer,standardsContainer;
	
	@UiField ChangeAssignmentStatusView changeAssignmentStatusView;
	
	@UiField Button editAssignmentDetailsButton,cancelAssignmentDetailsButton,saveAssignmentDetailsButton,editCollectionButton,studyCollectionButton;
	
	@UiField InlineLabel suggestedHourLabel,suggestedMinutesLabel;
	
	@UiField Frame reportsFrame;
	
	@UiField Button btnSummary,btnProgress;
	
	@UiField CheckBox assignmentMarkCheckBox;
	
	@UiField FlowPanel clearFixPanel,averageTimeLabel;
	
	private Label directionErrorLabel=new Label();
	
	private TextArea directionTextArea;
	
	private TextBox mimimunScoreTextBox;
	

	private TextBox suggestedHourTextBox;
	
	private TextBox suggestedMinTextBox;
	
	private boolean directionChanged; 
	
	EditToolBarView editToolBarView;

	public ClasspageItemDo classpageItemDo=null;
	
	/* HTML5 Storage implementation for tab persistance */
	private Storage stockStore = null;

	
	private static CollectionsViewUiBinder uiBinder = GWT.create(CollectionsViewUiBinder.class);
	
	MessageProperties i18n = GWT.create(MessageProperties.class);
	
	public interface CollectionsViewUiBinder extends UiBinder<Widget, CollectionsView> {}
	
	public CollectionsView(){
		
	}
	
	public CollectionsView(ClasspageItemDo classpageItemDo){
		initWidget(uiBinder.createAndBindUi(this));
		setPresenter(new CollectionsPresenter(this));
		this.classpageItemDo=classpageItemDo;
		CollectionsCBundle.INSTANCE.css().ensureInjected();
		SearchResultWrapperCBundle.INSTANCE.css().ensureInjected();
		AddAssignmentContainerCBundle.INSTANCE.css().ensureInjected();
		UcCBundle.INSTANCE.css().ensureInjected();
		showSaveButtons(false);
		showAssignmentDetils();
		frameContainer.setVisible(false);
		String pageLocation=AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
		if(pageLocation.equals(PlaceTokens.STUDENT))
		{
			editAssignmentDetailsButton.removeFromParent();
			analyticsContainer.removeFromParent();
			editCollectionButton.removeFromParent();
			changeAssignmentStatusView.removeFromParent();
			dueDateButton.removeFromParent();
			displayAssignmentMarkButton();
			assignmentMarkCheckBox.addValueChangeHandler(new MarkProgressEvent());
			studyCollectionButton.addClickHandler(new StudyCollectionEvent());
		}else if(pageLocation.equalsIgnoreCase(PlaceTokens.EDIT_CLASSPAGE)){
			dueDateButton.setVisible(true);
			assignmentMarkCheckBox.removeFromParent();
			studyCollectionButton.removeFromParent();
		}
		changeAssignmentStatusView.getChangeAssignmentStatusButton().addClickHandler(new ChangeStatusEvent());
		//btnSummary.addClickHandler(new SummaryEvent());
		//btnProgress.addClickHandler(new ProgressEvent());
		editAssignmentDetailsButton.addClickHandler(new EditAssignmentEvent());
		saveAssignmentDetailsButton.addClickHandler(new UpdateAssignmentDetailsEvent());
		cancelAssignmentDetailsButton.addClickHandler(new CancelEditAssignmentEvent());
		dueDateButton.addClickHandler(new EditDueDateEvent());
		editCollectionButton.addClickHandler(new CollectionEditEvent());
	}
	
	
	public void showAssignmentDetils(){
		if(classpageItemDo!=null){
			setAssignmentSequence(classpageItemDo.getItemSequence());
			setAssignmentStatus(classpageItemDo.getIsRequired()!=null?classpageItemDo.getIsRequired():false);
			setDueDate(classpageItemDo.getPlannedEndDate());
			setClasspageItemTitle(classpageItemDo.getResource().getTitle());
			setLearningObject();

			setDirection(classpageItemDo.getNarration());

			setThumbnailUrl();
			setMinimumScore(classpageItemDo.getMinimumScore());
			setSuggestedTime(classpageItemDo.getEstimatedTime());
			
			renderStandards(standardsContainer, getStandardsMap(classpageItemDo.getStandards()));
			//frameContainer.setVisible(false);
		}
		
	}
	
	private void setAssignmentSequence(int sequenceNumber){
		assignmentSequenceLabel.setText(i18n.GL0103()+" "+sequenceNumber);
	}
	
	private void setAssignmentStatus(boolean assignmentStatus){
		changeAssignmentStatusView.getChangeAssignmentStatusButton().setValue(assignmentStatus);
		changeAssignmentStatusView.changeLabelStyle(CollectionsCBundle.INSTANCE.css().enableLabelText(), CollectionsCBundle.INSTANCE.css().disableLabelText());
	}
	
	private void setDueDate(Long dueDate){
		removeEditDueDatePanel();
		showDueDatePanel(true);
		if(dueDate!=null&&!dueDate.equals("")&&!dueDate.equals("null")){
			dueDateText.setText(i18n.GL1390()+convertMillisecondsToDate(dueDate));
		}else{
			dueDateText.setText(i18n.GL1581());
		}
	}
	
	private void setMinimumScore(String score){
		minimumScoreContentPanel.clear();
		if(score!=null&&!score.equals("")){
			HTML scorePanel=new HTML(score+"%");
			scorePanel.setStyleName("");
			minimumScoreContentPanel.add(scorePanel);
		}
	}
	
	private void setSuggestedTime(String suggestedTime){
		suggestedHourLabel.setText("");
		suggestedMinutesLabel.setText("");
		if(suggestedTime!=null){
			String[] timeArray=suggestedTime.split(" ");
			if(timeArray.length>0&&timeArray[0].contains("hrs")){
				String hours=timeArray[0].replace("hrs", "");
				suggestedHourLabel.setText(hours);
			} 
			if(timeArray.length>1&&timeArray[1].contains("mins")){
				String minutes=timeArray[1].replace("mins", "");
				suggestedMinutesLabel.setText(minutes);
			}
		}
	}
	
	private void setClasspageItemTitle(String collectionItemTitle){
		classpageItemTitle.setHTML(collectionItemTitle);
		classpageItemTitle.setHref("#"+PlaceTokens.COLLECTION_PLAY+"&id="+classpageItemDo.getResource().getGooruOid()+"&cid="+classpageItemDo.getCollectionItemId()+"&page="+getCurrentPlaceToken());
	}
	
	
	
	public void setLearningObject(){
		String learningObject=classpageItemDo.getResource().getGoals();
		if(learningObject!=null&&!learningObject.equals("")&&!learningObject.equals("null")){
			this.learningObject.setHTML(learningObject);
			this.learningObject.getElement().setAttribute("alt",learningObject);
			this.learningObject.getElement().setAttribute("title",learningObject);
		}else{
			this.learningObject.setStyleName(CollectionsCBundle.INSTANCE.css().systemMessage());
			//this.learningObject.setHTML(i18n.GL1374());
			this.learningObject.getElement().setAttribute("alt",i18n.GL1374());
			this.learningObject.getElement().setAttribute("title",i18n.GL1374());
		}
	}
	
	public void setThumbnailUrl(){
		collectionImage.setUrl(classpageItemDo.getResource().getThumbnails().getUrl()!=null?StringUtil.formThumbnailName(classpageItemDo.getResource().getThumbnails().getUrl(),"-160x120."):"null");
		Anchor thumbnailAnchor=new Anchor();
		thumbnailAnchor.setHref("#"+PlaceTokens.COLLECTION_PLAY+"&id="+classpageItemDo.getResource().getGooruOid()+"&cid="+classpageItemDo.getCollectionItemId()+"&page="+getCurrentPlaceToken());
		thumbnailAnchor.getElement().appendChild(collectionImage.getElement());
		thumbnailContainer.add(thumbnailAnchor);
	}
	
	private void setDirection(String directionText){
		directionContentPanel.clear();
		HTML directionContent=new HTML();
		directionContent.setStyleName("");
		if(directionText==null||directionText.equals("")||directionText.equals("null")){
			directionContent.setStyleName(CollectionsCBundle.INSTANCE.css().systemMessage());
			//directionText=i18n.GL1374();
		}
		directionContent.setHTML(directionText);
		directionContentPanel.add(directionContent);
	}
	
	private void displayAssignmentMarkButton(){
		if(classpageItemDo!=null){
			Boolean isRequired=classpageItemDo.getIsRequired()!=null?classpageItemDo.getIsRequired():false;
			boolean assignmentStudyStatus=classpageItemDo.getStatus()!=null&&classpageItemDo.getStatus().equals("completed")?true:false;
			if(isRequired){
				assignmentMarkCheckBox.setStyleName(CollectionsCBundle.INSTANCE.css().requiredBuble());				
				assignmentMarkCheckBox.removeStyleName(CollectionsCBundle.INSTANCE.css().assignmentCompleted());
				assignmentMarkCheckBox.removeStyleName(CollectionsCBundle.INSTANCE.css().assignmentCompletedWithOptional());
				if(assignmentStudyStatus){
					assignmentMarkCheckBox.addStyleName(CollectionsCBundle.INSTANCE.css().assignmentCompleted());
				}
			}else{
				assignmentMarkCheckBox.setStyleName(CollectionsCBundle.INSTANCE.css().optionalBuble());
				//Boolean assignmentStudyStatus=classpageItemDo.getStatus()!=null&&classpageItemDo.getStatus().equals(COMPLETED)?true:false;
				assignmentMarkCheckBox.removeStyleName(CollectionsCBundle.INSTANCE.css().assignmentCompleted());
				//assignmentMarkCheckBox.setStyleName(CollectionsCBundle.INSTANCE.css().assignmentCompletedWithOptional());
				if(assignmentStudyStatus){
					assignmentMarkCheckBox.setStyleName(CollectionsCBundle.INSTANCE.css().assignmentCompletedWithOptional());
				}
			}
		}
	}
	
	@UiHandler("collectionImage")
	public void setErrorImage(ErrorEvent event){
		collectionImage.setUrl("images/default-collection-image-160x120.png");
	}
	
	public class ChangeStatusEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			updateAssignmentStatus(changeAssignmentStatusView.getChangeAssignmentStatusButton().getValue());
		}
	}
	
	public void updateAssignmentStatus(boolean assignmentStaus){
		updateAssignmentDetails(classpageItemDo.getCollectionItemId(), null, null, null, null, null, assignmentStaus, true, false,false);
	}
	
	public void updateAssignmentDueDate(String dueDate){
		showAndHideEditToolBarButtons(false);
		updateAssignmentDetails(classpageItemDo.getCollectionItemId(), null, dueDate, null, null, null, null, false, true,false);
	}
	
	public void updateAssignmentDetails(String direction,String minimumScore,String suggestedTime){
		updateAssignmentDetails(classpageItemDo.getCollectionItemId(), direction, null, null, minimumScore, suggestedTime, null, false, false,false);
	}
	
	public class SummaryEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			frameContainer.setVisible(true);
			reportsFrame.getElement().getStyle().setWidth(771, Unit.PX);
			//reportsFrame.getElement().getStyle().setMarginLeft(-136, Unit.PX);
			reportsFrame.getElement().getStyle().setHeight(800, Unit.PX);
			reportsFrame.setUrl(frameAnalyticsUrl());
		}
	}
	
	public class ProgressEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			frameContainer.setVisible(true);
			reportsFrame.getElement().getStyle().setWidth(771, Unit.PX);
			//reportsFrame.getElement().getStyle().setMarginLeft(-136, Unit.PX);
			reportsFrame.getElement().getStyle().setHeight(800, Unit.PX);
			reportsFrame.setUrl(frameAnalyticsUrlForMonitor());
		}
	}

	@Override
	public void setInSlot(Object slot, Widget content) {
		frameContainer.clear();
		if (content != null) {
			 if(slot==AnalyticsPresenter.COLLECTION_PROGRESS_SLOT){
				 frameContainer.setVisible(true);
				 frameContainer.add(content);
			}else{
				frameContainer.setVisible(false);
			}
		}else{
			frameContainer.setVisible(false);
		}
	}
	
	private String frameAnalyticsUrlForMonitor() {

		String classpageId = AppClientFactory.getPlaceManager().getRequestParameter("classpageid");
		String urlVal = StringUtil.generateMessage(AppClientFactory.getLoggedInUser().getSettings().getAnalyticsEndPointOld()+DataInsightsUrlTokens.CLASS_COLLECTION_MONITOR_DATA,
					classpageId,classpageItemDo.getResource().getGooruOid(),AppClientFactory.getLoginSessionToken());
		
		urlVal = urlVal+"&"+Math.random();			
		return urlVal;
	}
	
	private String frameAnalyticsUrl() {
		String classpageId = AppClientFactory.getPlaceManager().getRequestParameter("classpageid");
		String urlVal = StringUtil.generateMessage(AppClientFactory.getLoggedInUser().getSettings().getAnalyticsEndPointOld()+DataInsightsUrlTokens.CLASS_COLLECTION_SUMMARY_DATA,classpageId,classpageItemDo.getResource().getGooruOid(),AppClientFactory.getLoginSessionToken());

		urlVal = urlVal+"&"+Math.random();			
		return urlVal;
	}
	
	public class MarkProgressEvent implements ValueChangeHandler<Boolean>{
		@Override
		public void onValueChange(ValueChangeEvent<Boolean> event) {
			Boolean assignmentMarkStatus=event.getValue();
			if(assignmentMarkStatus){
				updateAssignmentDetails(classpageItemDo.getCollectionItemId(), null, null, COMPLETED, null, null, null, false, false,true);
			}else{
				updateAssignmentDetails(classpageItemDo.getCollectionItemId(), null, null, OPEN, null, null, null, false, false,true);
			}
		}
	}
	
	
//	public class MarkProgressEvent implements ValueChangeHandler<T>{
//		@Override
//		public void onClick(ClickEvent event) {
//			String status=classpageItemDo.getStatus();
//			updateAssignmentDetails(classpageItemDo.getCollectionItemId(), null, null, null, null, null, null, false, true);
//		}
//	}
	
	
	public class EditAssignmentEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			showSaveButtons(true);
			editDirection(classpageItemDo.getNarration());
			editMinimumScore(classpageItemDo.getMinimumScore());
			editSuggestedTime(classpageItemDo.getEstimatedTime());
		}
	}
	public class CancelEditAssignmentEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			scoreErrorLabel.setText("");
			minutesErrorLabel.setText("");
			directionErrorLabel.setText("");
			showUpdatedAssignmentDetails();
		}
	}
	public class UpdateAssignmentDetailsEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			//updateAssignmentDetails();
			savingLabel.setText(i18n.GL0808());
			savingLabel.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
			hideCancelAndSaveButtons(false);
			isTextHavingBadWords();
		}
	}
	
	public void isTextHavingBadWords(){
		String direction=directionTextArea.getValue();
		if(direction==null||direction.trim().equals("")||direction.trim().equals(i18n.GL1389())){
			direction="";
			updateAssignmentDetails(direction,false);
		}else{
			final Map<String, String> parms = new HashMap<String, String>();
			parms.put("text", direction);
			AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {
				@Override
				public void onSuccess(Boolean value) {
					if(value){
						directionErrorLabel.setText(i18n.GL0554());
					}else{
						directionErrorLabel.setText("");
					}
					updateAssignmentDetails(parms.get("text"),value);
				}
			});
		}
	}
	
	public void showUpdatedAssignmentDetails(){
		savingLabel.getElement().setInnerText("");
		showSaveButtons(false);
		if(classpageItemDo!=null){
			setDirection(classpageItemDo.getNarration());
			setMinimumScore(classpageItemDo.getMinimumScore());
			setSuggestedTime(classpageItemDo.getEstimatedTime());
		}
	}
	
	public void updateAssignmentDetails(String direction,boolean isHavingBadWords){
		boolean scoreFlag=true,minutesFlag=true,hoursFlag=true;
		Integer minScore=null,hour=null,minutes=null;
		String minimumScore=mimimunScoreTextBox.getValue();
		String suggestedHour=suggestedHourTextBox.getValue();
		String suggestedMinutes=suggestedMinTextBox.getValue();
		try{
			if(minimumScore!=null&&!minimumScore.trim().equals("")){
				minScore=new Integer(minimumScore.trim());
				if(minScore>100){
					scoreFlag=false;
					scoreErrorLabel.setText(i18n.GL2231());
				}else{
					scoreFlag=true;
				}
			}else{
				scoreFlag=true;
			}
		}catch(NumberFormatException e){
			scoreFlag=false;
			scoreErrorLabel.setText(i18n.GL2232());
		}
		try{
			if(suggestedHour!=null&&!suggestedHour.trim().equals("")){
				hour=new Integer(suggestedHour.trim());
			}
			minutesFlag=true;
		}catch(NumberFormatException e){
			minutesFlag=false;
			minutesErrorLabel.setText(i18n.GL2233());
		}
		try{
			if(suggestedMinutes!=null&&!suggestedMinutes.trim().equals("")){
				minutes=new Integer(suggestedMinutes.trim());
				if(minutes>59){
					hoursFlag=false;
					minutesErrorLabel.setText(i18n.GL2234());
				}else{
					hoursFlag=true;
				}
			}else{
				hoursFlag=true;
			}
		}catch(NumberFormatException e){
			hoursFlag=false;
			minutesErrorLabel.setText(i18n.GL2235());
		}
		if(!isHavingBadWords&&scoreFlag&&minutesFlag&&hoursFlag){
			minutesErrorLabel.setText("");
			scoreErrorLabel.setText("");
			directionErrorLabel.setText("");
			minimumScore=minScore!=null?minScore.toString():"";
			String suggestedTime="";
			if(hour==null&&minutes!=null){
				suggestedTime="0"+i18n.GL2184()+" "+minutes+i18n.GL2185();
			}else if(hour!=null&&minutes==null){
				suggestedTime=hour+i18n.GL2184()+" "+"00"+i18n.GL2185();
			}else if(hour!=null&&minutes!=null){
				suggestedTime=hour+i18n.GL2184()+" "+minutes+i18n.GL2185();
			}
			updateAssignmentDetails(direction, minimumScore, suggestedTime);
		}else{
			savingLabel.setText("");
			hideCancelAndSaveButtons(true);
		}
	}
	

	public void editMinimumScore(final String minimumScore){
		minimumScoreContentPanel.clear();
		mimimunScoreTextBox=new TextBox();
		mimimunScoreTextBox.setMaxLength(3);
		mimimunScoreTextBox.addKeyPressHandler(new NumbersOnly());
		mimimunScoreTextBox.setStyleName(CollectionsCBundle.INSTANCE.css().minimumScoreTextbox());
		InlineLabel percentageLabel=new InlineLabel("%");
		percentageLabel.setStyleName("");
		mimimunScoreTextBox.setText(minimumScore);
		minimumScoreContentPanel.add(mimimunScoreTextBox);
		minimumScoreContentPanel.add(percentageLabel);
	}
	
	public void editSuggestedTime(String suggestedTime){
		String suggestedHour="",suggestedMinutes="";
		if(suggestedTime!=null){
			String[] timeArray=suggestedTime.split(" ");
			if(timeArray.length>0&&timeArray[0].contains("hrs")){
				suggestedHour=timeArray[0].replace("hrs", "");
				suggestedHourLabel.setText(suggestedHour);
			} 
			if(timeArray.length>1&&timeArray[1].contains("mins")){
				suggestedMinutes=timeArray[1].replace("mins", "");
				suggestedMinutesLabel.setText(suggestedMinutes);
			}
		}
		suggestedHourLabel.setText("");
		suggestedHourTextBox=new TextBox();
		suggestedHourTextBox.setMaxLength(2);
		suggestedHourTextBox.addKeyPressHandler(new NumbersOnly());
		suggestedHourTextBox.setStyleName(CollectionsCBundle.INSTANCE.css().minimumScoreTextbox());
		suggestedHourTextBox.setText(suggestedHour);
		clearFixPanel.clear();
		clearFixPanel.setVisible(false);
		clearFixPanel.add(suggestedHourTextBox);
		suggestedHourLabel.getElement().appendChild(clearFixPanel.getWidget(0).getElement());
		clearFixPanel.setVisible(true);
		
		suggestedMinutesLabel.setText("");
		suggestedMinTextBox=new TextBox();
		suggestedMinTextBox.addKeyPressHandler(new NumbersOnly());
		suggestedMinTextBox.setMaxLength(2);
		suggestedMinTextBox.setStyleName(CollectionsCBundle.INSTANCE.css().minimumScoreTextbox());
		suggestedMinTextBox.setText(suggestedMinutes);
		//clearFixPanel.clear();
		clearFixPanel.setVisible(false);
		clearFixPanel.add(suggestedMinTextBox);
		suggestedMinutesLabel.getElement().appendChild(clearFixPanel.getWidget(1).getElement());
		clearFixPanel.setVisible(true);
	}
	
	public void editDirection(String directionText){
		directionContentPanel.clear();
		directionTextArea =new TextArea();
		directionTextArea.getElement().setAttribute("maxlength", "400");
		directionTextArea.setStyleName(CollectionsCBundle.INSTANCE.css().classpageTextarea());
		if(directionText!=null&&!directionText.equals("")&&!directionText.equals("null")){
			directionTextArea.removeStyleName(AddAssignmentContainerCBundle.INSTANCE.css().assignmentsystemMessage());
			directionTextArea.setText(directionText);
		}else{
			directionTextArea.setText(i18n.GL1389());
			directionTextArea.addStyleName(AddAssignmentContainerCBundle.INSTANCE.css().assignmentsystemMessage());
		}
		directionTextArea.addFocusHandler(new DirectonFoucsEvent());
		directionTextArea.addBlurHandler(new DirectionBlurEvent());
		directionTextArea.addKeyUpHandler(new DirectionKeypressEvent());
		directionErrorLabel.setStyleName(AddAssignmentContainerCBundle.INSTANCE.css().assignmentDirectiomErrorMessage());
		directionContentPanel.clear();
		directionErrorLabel.setText("");
		directionContentPanel.add(directionTextArea);
		directionContentPanel.add(directionErrorLabel);
	}
	private class DirectonFoucsEvent implements FocusHandler{
		@Override
		public void onFocus(FocusEvent event) {
			String directionText=directionTextArea.getText().trim();
			if(directionText.equalsIgnoreCase(i18n.GL1389())){
				directionTextArea.setText("");
			}
			directionTextArea.removeStyleName(AddAssignmentContainerCBundle.INSTANCE.css().assignmentsystemMessage());
		}
	}
	
	private class DirectionBlurEvent implements BlurHandler{
		@Override
		public void onBlur(BlurEvent event) {
			String directionText=directionTextArea.getText().trim();
			if(!directionText.equalsIgnoreCase(i18n.GL1389())&&directionText.length()>0){
				if(directionText.length()>=400){
					directionErrorLabel.setText(i18n.GL0143());
				}else{
					directionErrorLabel.setText("");
				}
			}else{
				directionTextArea.setText(i18n.GL1389());
				directionTextArea.addStyleName(AddAssignmentContainerCBundle.INSTANCE.css().assignmentsystemMessage());
			}
		}
	}
	
	private class DirectionKeypressEvent implements KeyUpHandler{
		@Override
		public void onKeyUp(KeyUpEvent event) {
			String directionText=directionTextArea.getText().trim();
			if(directionText.length()>=400){
				directionErrorLabel.setText(i18n.GL0143());
				//event.preventDefault();
				}else{
				directionErrorLabel.setText("");
			}
			directionChanged=true;
		}
	}
	
	public void showSaveButtons(boolean buttonVisibility){
		editAssignmentDetailsButton.setVisible(!buttonVisibility);
		cancelAssignmentDetailsButton.setVisible(buttonVisibility);
		saveAssignmentDetailsButton.setVisible(buttonVisibility);
		
	}
	
	public void showAndHideEditToolBarButtons(boolean buttonVisibility){
		editToolBarView.saveButton.setVisible(buttonVisibility);
		editToolBarView.cancelButton.setVisible(buttonVisibility);
		editToolBarView.savingText.setVisible(!buttonVisibility);
	}
	
	public void hideCancelAndSaveButtons(boolean buttonVisibility){
		cancelAssignmentDetailsButton.setVisible(buttonVisibility);
		saveAssignmentDetailsButton.setVisible(buttonVisibility);
	}
	
	
	private class EditDueDateEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			showEditDueDateView();
		}
	}
	
	public void showEditDueDateView(){
		showDueDatePanel(false);
		editToolBarView=new EditToolBarView(true);
		editToolBarView.dueDateText.add(new Label(i18n.GL1390()));
		if(classpageItemDo.getPlannedEndDate()!=null&&!classpageItemDo.getPlannedEndDate().equals("")){
			editToolBarView.dateBoxUc.getDateBox().setValue(convertMillisecondsToDate(classpageItemDo.getPlannedEndDate()));
		}
		editToolBarView.dueDateText.setStyleName(CollectionsCBundle.INSTANCE.css().dueDataIcon());
		editToolBarView.cancelButton.addClickHandler(new ResetEditContentEvent());
		editToolBarView.saveButton.addClickHandler(new UpdateEditedDueDateEvent(editToolBarView));
		dueDateContentPanel.add(editToolBarView);
	}
	private void showDueDatePanel(boolean visible){
		dueDateText.setVisible(visible);
		dueDateButton.setVisible(visible);
	}
	private class ResetEditContentEvent implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			removeEditDueDatePanel();
			showDueDatePanel(true);
		}
	}
	private class UpdateEditedDueDateEvent implements ClickHandler{
		private EditToolBarView editToolBarView;
		public UpdateEditedDueDateEvent(EditToolBarView editToolBarView){
			this.editToolBarView=editToolBarView;
		}
		@Override
		public void onClick(ClickEvent event) {
			String dueDate=editToolBarView.dateBoxUc.getDateBox().getValue();
			if(dueDate!=null&&!dueDate.equals("")){
				editToolBarView.saveButton.setVisible(false);
				editToolBarView.cancelButton.setVisible(false);
				editToolBarView.savingText.setVisible(true);
				updateAssignmentDueDate(dueDate);
			}
		}
	}
	private void removeEditDueDatePanel(){
		Iterator<Widget> iterator= dueDateContentPanel.iterator();
		while(iterator.hasNext()){
			Widget widget=iterator.next();
			if(widget instanceof EditToolBarView){
				widget.removeFromParent();
			}
		}
	}
	public String getCurrentPlaceToken(){
		String placeToken=AppClientFactory.getCurrentPlaceToken();
		if(placeToken!=null){
			if(placeToken.equals(PlaceTokens.EDIT_CLASSPAGE)){
				placeToken="teach";
			}else if(placeToken.equals(PlaceTokens.STUDENT)){
				placeToken="study";
			}
		}
		return placeToken;
	}
	private class StudyCollectionEvent implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			Map<String,String> parametesMap=new HashMap<String,String>();
			parametesMap.put("id", classpageItemDo.getResource().getGooruOid());
			parametesMap.put("cid", classpageItemDo.getCollectionItemId());
			parametesMap.put("page", getCurrentPlaceToken());
			AppClientFactory.getPlaceManager().revealPlace(true, AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.COLLECTION_PLAY, parametesMap));
		}
		
	}
	
	private class CollectionEditEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			getCollectionFolders();
		};
	}
	public void getCollectionFolders(){
		AppClientFactory.getInjector().getClasspageService().getCollectionParentFolders(classpageItemDo.getResource().getGooruOid(), new SimpleAsyncCallback<ArrayList<String>>() {
			@Override
			public void onSuccess(ArrayList<String> foldersList) {
				if(foldersList!=null){
					Map<String,String> parametesMap=new HashMap<String,String>();
					parametesMap.put("id", classpageItemDo.getResource().getGooruOid());
					if(foldersList.size()>0){
						for(int i=0;i<foldersList.size();i++){
							parametesMap.put("o"+(i+1), foldersList.get(i));
						}
					}
					parametesMap.put("edit","assignment");
					stockStore = Storage.getLocalStorageIfSupported();
					if (stockStore != null) {
						stockStore = Storage.getLocalStorageIfSupported();
						if (stockStore != null) {
							stockStore.setItem("tabKey", "resourceTab");
						}
					}
					AppClientFactory.getPlaceManager().revealPlace(true, AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.SHELF, parametesMap));
				}
			}
		});
	}
	
	public void updateAssignmentDetails(String collectionItemId,String direction,String dueDate,String readStatus,String minimumScore,String suggestedTime, Boolean isRequiredStatus,final boolean isUpdateRequiredStatus,final boolean isUpdateDuedate,final boolean isReadStatus){
		String classId=getClasspageId();
		String unitId=AppClientFactory.getPlaceManager().getRequestParameter("uid", null);
		AppClientFactory.getInjector().getClasspageService().updateAssignmentDetails(classId,unitId,collectionItemId, direction, dueDate, readStatus, minimumScore, suggestedTime, isRequiredStatus, new SimpleAsyncCallback<ClasspageItemDo>() {
			@Override
			public void onSuccess(ClasspageItemDo classpageItemDo) {
				if(classpageItemDo!=null){
					CollectionsView.this.classpageItemDo=classpageItemDo;
					if(isUpdateRequiredStatus){
						updateAssignmentRequiredStatus(classpageItemDo.getIsRequired(),classpageItemDo.getCollectionItemId(),classpageItemDo.getStatus(),true);
					}
					if(isReadStatus){
						updateAssignmentRequiredStatus(classpageItemDo.getIsRequired(),classpageItemDo.getCollectionItemId(),classpageItemDo.getStatus(),false);
					}
				}
				if(isUpdateRequiredStatus||isUpdateDuedate){
					setAssignmentStatus(classpageItemDo.getIsRequired()!=null?classpageItemDo.getIsRequired():false);
					setDueDate(classpageItemDo.getPlannedEndDate());
				}else if(isReadStatus){
					displayAssignmentMarkButton();
				}else{
					showUpdatedAssignmentDetails();
				}
				
				if(directionChanged&&(classpageItemDo.getNarration()!=null&&!classpageItemDo.getNarration().equalsIgnoreCase(""))){
					
					updateAssignmentDirection(classpageItemDo.getCollectionItemId(), classpageItemDo.getNarration());
					
				}
				
			}
		});
	}
	
	public String getClasspageId(){
		String viewToken=AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
		if(viewToken.equals(PlaceTokens.EDIT_CLASSPAGE)){
			return AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
		}else{
			return AppClientFactory.getPlaceManager().getRequestParameter("id", null);
		}
	}
	public void updateAssignmentRequiredStatus(Boolean isRequired,String collectionItemId,String readStatus,boolean isUpdateRequiredStatus){
		
	}
	
	public void updateAssignmentDirection(String collectionItemId,String readStatus){
		
	}
	
	public static String convertMillisecondsToDate(Long milliseconds){
		Date currentDate = new Date(milliseconds);
		DateTimeFormat fmt = DateTimeFormat.getFormat ("MM/dd/yyyy");
		String date=fmt.format(currentDate);
		return date;
	}
	private class NumbersOnly implements KeyPressHandler {
	      
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
			if(event.getNativeEvent().getKeyCode() == 46 &&event.getNativeEvent().getKeyCode() == 37)
			{
				((TextBox) event.getSource()).cancelKey();
			}

		}
    }
	

	public List<Map<String,String>> getStandardsMap(Set<StandardFo> taxonomyset){
		List<Map<String,String>> standardsList=new ArrayList<Map<String,String>>();
		Iterator<StandardFo> iterator = taxonomyset.iterator();
		while (iterator.hasNext()) {
			StandardFo standardFo=iterator.next();
			Map<String, String> standardMap=new HashMap<String, String>();
			standardMap.put(STANDARD_CODE, standardFo.getCode());
			standardMap.put(STANDARD_DESCRIPTION, standardFo.getDescription());
			standardsList.add(standardMap);
		}
		return standardsList;
	}
	
	public void renderStandards(FlowPanel standardsContainer, List<Map<String,String>> standards) {
		standardsContainer.clear();
		if (standards != null) {
			Iterator<Map<String, String>> iterator = standards.iterator();
			int count = 0;
			FlowPanel toolTipwidgets = new FlowPanel();
			while (iterator.hasNext()) {
				Map<String, String> standard = iterator.next();
				String stdCode = standard.get(STANDARD_CODE);
				String stdDec = standard.get(STANDARD_DESCRIPTION);
				if (count > 1) {
					if (count < 18){
						StandardSgItemVc standardItem = new StandardSgItemVc(stdCode, stdDec);
						toolTipwidgets.add(standardItem);
					}
				} else {
					DownToolTipWidgetUc toolTipUc = new DownToolTipWidgetUc(new Label(stdCode), new Label(stdDec), standards);
					toolTipUc.setStyleName(UcCBundle.INSTANCE.css().searchStandard());
					standardsContainer.add(toolTipUc);
				}
				count++;
			}
			if (standards.size()>18){
				final Label left = new Label(i18n.GL_SPL_PLUS()+(standards.size() - 18));
				toolTipwidgets.add(left);
			}
			if (standards.size() > 2) {
				Integer moreStandardsCount = standards.size() - 2;
				DownToolTipWidgetUc toolTipUc = new DownToolTipWidgetUc(new Label(i18n.GL_SPL_PLUS() + moreStandardsCount), toolTipwidgets, standards);
				toolTipUc.setStyleName(SearchResultWrapperCBundle.INSTANCE.css().blueLink());
				standardsContainer.add(toolTipUc);
				toolTipUc.getTooltipPopUpUcCount(moreStandardsCount);
				
			}
		}
	}
	
	public void setCollectionSummaryData(CollectionSummaryMetaDataDo collectionSummaryMetaDataDo){
		if(collectionSummaryMetaDataDo != null)
		{
		displayAverageTime(collectionSummaryMetaDataDo.getAvgTimeSpent());
		displayViewCount(collectionSummaryMetaDataDo.getViews());
		displayAverageReaction(collectionSummaryMetaDataDo.getAvgReaction());
		}
		//avarageReactionLabel,viewsLabel,averageTimeLabel
	}

	public void displayAverageTime(Long milliSeconds){
		averageTimeLabel.clear();
		if(milliSeconds!=null&&milliSeconds!=0&&!milliSeconds.equals("")){
			Long totalSecs = milliSeconds/1000;
		    Long hours = (totalSecs / 3600);
		    Long mins = (totalSecs / 60) % 60;
		    Long secs = totalSecs % 60;
		    String minsString = (mins == 0)? "00": ((mins < 10)? "0"+mins : ""+mins );
		    String secsString = (secs == 0)? "00": ((secs < 10)? "0" + secs : "" + secs);
	        if (hours > 0){
	        	displayTime(hours.toString(),hours==1?"hr":"hrs");
	        	displayTime(" "+minsString.toString(),minsString.equals("01")?"min":"mins");
	        	displayTime(" "+secsString.toString(),secsString.equals("01")?"sec":"secs");
	        }
	        else if (mins > 0){
	        	displayTime(minsString.toString(),minsString.equals("01")?"min":"mins");
	        	displayTime(" "+secsString.toString(),secsString.equals("01")?"sec":"sec");
	        }
	        else {
	        	displayTime(secsString.toString(),secsString.equals("01")?"sec":"sec");
	        }
		}else{
			dispalyTime();
		}
	}
	
	
	public void displayTime(String time, String timeText){
		InlineLabel inlineTimeLabel=new InlineLabel(time);
		//inlineTimeLabel.setStyleName(playerStyle.timeTextBig());
		InlineLabel inlineTimeString=new InlineLabel(timeText);
		//inlineTimeString.setStyleName(playerStyle.timeTextSmall());
		averageTimeLabel.add(inlineTimeLabel);
		averageTimeLabel.add(inlineTimeString);
	}
	public void dispalyTime(){
		averageTimeLabel.clear();
		InlineLabel inlineTimeLabel=new InlineLabel("-");
		//inlineTimeLabel.setStyleName(playerStyle.timeTextBig());
		averageTimeLabel.add(inlineTimeLabel);
	}
	
	public void displayViewCount(int viewCount){
		if(viewCount>0){
			viewsLabel.setText(""+viewCount);
		}else{
			viewsLabel.setText("-");
		}
	}
	
	public void displayAverageReaction(int averageReaction){
		if(averageReaction>0){
			displayAvgReactionImage(averageReaction);
		}else{
			avarageReactionLabel.setText("-");
			avarageReactionLabel.setStyleName(CollectionsCBundle.INSTANCE.css().reactionText());
		}
	}
	
	public void displayAvgReactionImage(int averageReaction){
	
		switch(averageReaction){
			case 1: avarageReactionLabel.setStyleName(CollectionsCBundle.INSTANCE.css().needHelpReaction());
					break;
			case 2: avarageReactionLabel.setStyleName(CollectionsCBundle.INSTANCE.css().notUnderstandReaction());
					break;
			case 3: avarageReactionLabel.setStyleName(CollectionsCBundle.INSTANCE.css().mehReaction());
					break;
			case 4: avarageReactionLabel.setStyleName(CollectionsCBundle.INSTANCE.css().understandReaction());
					break;
			case 5: avarageReactionLabel.setStyleName(CollectionsCBundle.INSTANCE.css().canExplainReaction());
					break;
				
		}
	}
	
	public Button getBtnSummary(){
		return btnSummary;
	}
	public Button getBtnProgress(){
		return btnProgress;
	}
	public FlowPanel getFlowPnl(){
		return frameContainer;
	}
}
