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
import java.util.Map;

import org.ednovo.gooru.client.DataInsightsUrlTokens;
import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.child.ChildView;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.classpages.assignments.AddAssignmentContainerCBundle;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;
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
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
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
	
	@UiField HTMLPanel thumbnailContainer,directionContentPanel,minimumScoreContentPanel,dueDateContentPanel,editAssignmentContainer;
	
	@UiField HTML learningObject;
	
	@UiField Anchor classpageItemTitle;
	
	@UiField Image collectionImage;
	
	@UiField Label assignmentSequenceLabel,dueDateText,dueDateButton,savingLabel;
	
	@UiField FlowPanel frameContainer,analyticsContainer;
	
	@UiField ChangeAssignmentStatusView changeAssignmentStatusView;
	
	@UiField Button editAssignmentDetailsButton,cancelAssignmentDetailsButton,saveAssignmentDetailsButton,editCollectionButton;
	
	@UiField InlineLabel suggestedHourLabel,suggestedMinutesLabel;
	
	@UiField Frame reportsFrame;
	
	@UiField Button btnSummary,btnProgress;
	
	private Label directionErrorLabel=new Label();
	
	private TextArea directionTextArea;
	
	private TextBox mimimunScoreTextBox;
	

	private TextBox suggestedHourTextBox;
	
	private TextBox suggestedMinTextBox;
	

	EditToolBarView editToolBarView;

	public ClasspageItemDo classpageItemDo=null;
	
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
		AddAssignmentContainerCBundle.INSTANCE.css().ensureInjected();
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
		}

		changeAssignmentStatusView.getChangeAssignmentStatusButton().addClickHandler(new ChangeStatusEvent());
		btnSummary.addClickHandler(new SummaryEvent());
		btnProgress.addClickHandler(new ProgressEvent());
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
			//frameContainer.setVisible(false);
		}
		
	}
	
	private void setAssignmentSequence(int sequenceNumber){
		assignmentSequenceLabel.setText("Assignment "+sequenceNumber);
	}
	
	private void setAssignmentStatus(boolean assignmentStatus){
		changeAssignmentStatusView.getChangeAssignmentStatusButton().setValue(assignmentStatus);
		changeAssignmentStatusView.changeLabelStyle(CollectionsCBundle.INSTANCE.css().enableLabelText(), CollectionsCBundle.INSTANCE.css().disableLabelText());
	}
	
	private void setDueDate(Long dueDate){
		removeEditDueDatePanel();
		showDueDatePanel(true);
		if(dueDate!=null){
			dueDateText.setText("Due Date:"+convertMillisecondsToDate(dueDate));
		}else{
			dueDateText.setText("Due Date");
		}
	}
	
	private void setMinimumScore(String score){
		minimumScoreContentPanel.clear();
		if(score!=null){
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
	
	private void setAssignmentStandards(){
		
	}
	
	public void setLearningObject(){
		String learningObject=classpageItemDo.getResource().getGoals();
		if(learningObject!=null&&!learningObject.equals("")&&!learningObject.equals("null")){
			this.learningObject.setHTML(learningObject);
			this.learningObject.getElement().setAttribute("alt",learningObject);
			this.learningObject.getElement().setAttribute("title",learningObject);
		}else{
			this.learningObject.setStyleName(CollectionsCBundle.INSTANCE.css().systemMessage());
			this.learningObject.setHTML(i18n.GL1374());
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
			directionText=i18n.GL1374();
		}
		directionContent.setHTML(directionText);
		directionContentPanel.add(directionContent);
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
		updateAssignmentDetails(classpageItemDo.getCollectionItemId(), null, null, null, null, null, assignmentStaus, true, false);
	}
	
	public void updateAssignmentDueDate(String dueDate){
		showAndHideEditToolBarButtons(false);
		updateAssignmentDetails(classpageItemDo.getCollectionItemId(), null, dueDate, null, null, null, null, false, true);
	}
	
	public void updateAssignmentDetails(String direction,String minimumScore,String suggestedTime){
		savingLabel.getElement().setInnerText("Saving...");
		savingLabel.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		hideCancelAndSaveButtons(false);
		updateAssignmentDetails(classpageItemDo.getCollectionItemId(), direction, null, null, minimumScore, suggestedTime, null, false, false);
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

	private String frameAnalyticsUrlForMonitor() {

		String classpageId = AppClientFactory.getPlaceManager().getRequestParameter("classpageid");
		String urlVal = StringUtil.generateMessage(AppClientFactory.getLoggedInUser().getSettings().getAnalyticsEndPoint()+DataInsightsUrlTokens.CLASS_COLLECTION_MONITOR_DATA,
					classpageId,classpageItemDo.getResource().getGooruOid(),AppClientFactory.getLoginSessionToken());
		
		urlVal = urlVal+"&"+Math.random();			
		return urlVal;
	}
	
	private String frameAnalyticsUrl() {
		String classpageId = AppClientFactory.getPlaceManager().getRequestParameter("classpageid");
		String urlVal = StringUtil.generateMessage(AppClientFactory.getLoggedInUser().getSettings().getAnalyticsEndPoint()+DataInsightsUrlTokens.CLASS_COLLECTION_SUMMARY_DATA,classpageId,classpageItemDo.getResource().getGooruOid(),AppClientFactory.getLoginSessionToken());

		urlVal = urlVal+"&"+Math.random();			
		return urlVal;
	}
	
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
			showUpdatedAssignmentDetails();
		}
	}
	public class UpdateAssignmentDetailsEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			updateAssignmentDetails();
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
	
	public void updateAssignmentDetails(){
		String direction=directionTextArea.getValue();
		String minimumScore=mimimunScoreTextBox.getValue();
		String suggestedHour=suggestedHourTextBox.getValue();
		String suggestedMinutes=suggestedMinTextBox.getValue();
		String suggestedTime=suggestedHour+"hrs "+suggestedMinutes+"mins";
		updateAssignmentDetails(direction, minimumScore, suggestedTime);
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
		suggestedHourTextBox.addKeyPressHandler(new NumbersOnly());
		suggestedHourTextBox.setMaxLength(2);
		suggestedHourTextBox.setStyleName(CollectionsCBundle.INSTANCE.css().minimumScoreTextbox());
		suggestedHourTextBox.setText(suggestedHour);
		suggestedHourLabel.getElement().appendChild(suggestedHourTextBox.getElement());
		
		suggestedMinutesLabel.setText("");
		suggestedMinTextBox=new TextBox();
		suggestedMinTextBox.addKeyPressHandler(new NumbersOnly());
		suggestedMinTextBox.setMaxLength(2);
		suggestedMinTextBox.setStyleName(CollectionsCBundle.INSTANCE.css().minimumScoreTextbox());
		suggestedMinTextBox.setText(suggestedMinutes);
		suggestedMinutesLabel.getElement().appendChild(suggestedMinTextBox.getElement());
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
		if(classpageItemDo.getPlannedEndDate()!=null){
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
			editToolBarView.saveButton.setVisible(false);
			editToolBarView.cancelButton.setVisible(false);
			editToolBarView.savingText.setVisible(true);
				String dueDate=editToolBarView.dateBoxUc.getDate();
				if(dueDate!=null){
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
	
	private class CollectionEditEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			getCollectionFolders();
		};
	}
	public void getCollectionFolders(){
		AppClientFactory.getInjector().getClasspageService().getCollectionParentFolders(classpageItemDo.getCollectionId(), new SimpleAsyncCallback<ArrayList<String>>() {
			@Override
			public void onSuccess(ArrayList<String> foldersList) {
				if(foldersList!=null){
					Map<String,String> parametesMap=new HashMap<String,String>();
					parametesMap.put("id", classpageItemDo.getCollectionId());
					if(foldersList.size()>0){
						for(int i=0;i<foldersList.size();i++){
							parametesMap.put("o"+(i+1), foldersList.get(i));
						}
					}
					AppClientFactory.getPlaceManager().revealPlace(true, AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.SHELF, parametesMap));
				}
			}
		});
	}
	
	public void updateAssignmentDetails(String collectionItemId,String direction,String dueDate,String readStatus,String minimumScore,String suggestedTime, Boolean isRequiredStatus,final boolean isUpdateRequiredStatus,final boolean isUpdateDuedate){
		String classId=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
		String unitId=AppClientFactory.getPlaceManager().getRequestParameter("uid", null);
		AppClientFactory.getInjector().getClasspageService().updateAssignmentDetails(classId,unitId,collectionItemId, direction, dueDate, readStatus, minimumScore, suggestedTime, isRequiredStatus, new SimpleAsyncCallback<ClasspageItemDo>() {
			@Override
			public void onSuccess(ClasspageItemDo classpageItemDo) {
				if(classpageItemDo!=null){
					CollectionsView.this.classpageItemDo=classpageItemDo;
					if(isUpdateRequiredStatus){
						updateAssignmentRequiredStatus(classpageItemDo.getIsRequired(),classpageItemDo.getCollectionItemId());
					}
				}
				if(isUpdateRequiredStatus||isUpdateDuedate){
					setAssignmentStatus(classpageItemDo.getIsRequired()!=null?classpageItemDo.getIsRequired():false);
					setDueDate(classpageItemDo.getPlannedEndDate());
				}else{
					showUpdatedAssignmentDetails();
				}
			}
		});
	}
	
	public void updateAssignmentRequiredStatus(Boolean isRequired,String collectionItemId){
		
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
					
		}
    }
	
}
