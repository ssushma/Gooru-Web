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

import org.ednovo.gooru.client.child.ChildView;
import org.ednovo.gooru.client.mvp.classpages.assignments.AddAssignmentContainerCBundle;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
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
	
	@UiField HTMLPanel thumbnailContainer,directionContentPanel,minimumScoreContentPanel;
	
	@UiField HTML learningObject;
	
	@UiField Anchor classpageItemTitle;
	
	@UiField Image collectionImage;
	
	@UiField Label assignmentSequenceLabel,dueDateText,dueDateButton;
	
	@UiField ChangeAssignmentStatusView changeAssignmentStatusView;
	
	@UiField Button editAssignmentDetailsButton,cancelAssignmentDetailsButton,saveAssignmentDetailsButton;
	
	@UiField InlineLabel suggestedHourLabel,suggestedMinutesLabel;
	
	private Label directionErrorLabel=new Label();
	
	private TextArea directionTextArea;
	
	private static CollectionsViewUiBinder uiBinder = GWT.create(CollectionsViewUiBinder.class);
	
	MessageProperties i18n = GWT.create(MessageProperties.class);
	
	public interface CollectionsViewUiBinder extends UiBinder<Widget, CollectionsView> {}
	
	public CollectionsView(){
		
	}
	
	public CollectionsView(ClasspageItemDo classpageItemDo,int sequenceNum){
		initWidget(uiBinder.createAndBindUi(this));
		setPresenter(new CollectionsPresenter(this));
		CollectionsCBundle.INSTANCE.css().ensureInjected();
		AddAssignmentContainerCBundle.INSTANCE.css().ensureInjected();
		showSaveButtons(false);
		changeAssignmentStatusView.getChangeAssignmentStatusButton().addClickHandler(new ChangeStatusEvent());
		editAssignmentDetailsButton.addClickHandler(new EditAssignmentEvent());
		setDirection("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam porttitor turpis id nisl iaculis, sit amet convallis nibh dapibus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam porttitor turpis id nisl iaculis, sit amet convallis nibh dapibus.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam porttitor turpis id nisl iaculis, sit amet convallis nibh dapibus.");
		setMinimumScore("85");
	}
	
	private void setAssignmentSequence(int sequenceNumber){
		assignmentSequenceLabel.setText("Assignment "+sequenceNumber);
	}
	
	private void setAssignmentStatus(boolean assignmentStatus){
		changeAssignmentStatusView.getChangeAssignmentStatusButton().setValue(assignmentStatus);
	}
	
	private void setDueDate(String dueDate){
		//dueDateText
	}
	
	private void setMinimumScore(String score){
		minimumScoreContentPanel.clear();
		HTML scorePanel=new HTML(score+"%");
		scorePanel.setStyleName("");
		minimumScoreContentPanel.add(scorePanel);
	}
	
	private void setSuggestedTime(String time){
		
	}
	
	private void setClasspageItemTitle(String collectionItemTitle){
//		classpageItemTitle.setHTML(classpageItemDo.getCollectionTitle());
//		classpageItemTitle.setHref("#"+PlaceTokens.COLLECTION_PLAY+"&id="+classpageItemDo.getCollectionId()+"&cid="+classpageItemDo.getCollectionItemId()+"&page="+getCurrentPlaceToken());
	}
	
	private void setAssignmentStandards(){
		
	}
	
	
	public void setLearningObject(){
//		String learningObject=classpageItemDo.getGoal();
//		if(learningObject!=null&&!learningObject.equals("")&&!learningObject.equals("null")){
//			this.learningObject.setHTML(learningObject);
//			this.learningObject.getElement().setAttribute("alt",learningObject);
//			this.learningObject.getElement().setAttribute("title",learningObject);
//		}else{
//			this.learningObject.setStyleName(CollectionsCBundle.INSTANCE.css().systemMessage());
//			this.learningObject.setHTML(i18n.GL1374());
//			this.learningObject.getElement().setAttribute("alt",i18n.GL1374());
//			this.learningObject.getElement().setAttribute("title",i18n.GL1374());
//		}
	}
	
	public void setThumbnailUrl(){
//		collectionImage.setUrl(classpageItemDo.getThumbnailUrl()!=null?StringUtil.formThumbnailName(classpageItemDo.getThumbnailUrl(),"-160x120."):"null");
//		Anchor thumbnailAnchor=new Anchor();
//		thumbnailAnchor.setHref("#"+PlaceTokens.COLLECTION_PLAY+"&id="+classpageItemDo.getCollectionId()+"&cid="+classpageItemDo.getCollectionItemId()+"&page="+getCurrentPlaceToken());
//		thumbnailAnchor.getElement().appendChild(collectionImage.getElement());
//		thumbnailContainer.add(thumbnailAnchor);
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
		Window.alert("Assignment status====>"+changeAssignmentStatusView.getChangeAssignmentStatusButton().getValue());
	}
	
	
	public class EditAssignmentEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			showSaveButtons(true);
			editDirection("direction texttttttttt directes test direction texttttttttt directes test direction texttttttttt directes test direction texttttttttt directes test direction texttttttttt directes test ");
			editMinimumScore("54");
			editSuggestedTime("04","50");
		}
	}
	
	public void editMinimumScore(String minimumScore){
		minimumScoreContentPanel.clear();
		TextBox mimimunScoreTextBox=new TextBox();
		mimimunScoreTextBox.setStyleName(CollectionsCBundle.INSTANCE.css().minimumScoreTextbox());
		mimimunScoreTextBox.setText(minimumScore);
		minimumScoreContentPanel.add(mimimunScoreTextBox);
	}
	
	public void editSuggestedTime(String suggestedHour, String suggestedMinutes){
		suggestedHourLabel.setText("");
		TextBox suggestedHourTextBox=new TextBox();
		suggestedHourTextBox.setStyleName(CollectionsCBundle.INSTANCE.css().minimumScoreTextbox());
		suggestedHourTextBox.setText(suggestedHour);
		suggestedHourLabel.getElement().appendChild(suggestedHourTextBox.getElement());
		
		suggestedMinutesLabel.setText("");
		TextBox suggestedMinTextBox=new TextBox();
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
	
	
}
