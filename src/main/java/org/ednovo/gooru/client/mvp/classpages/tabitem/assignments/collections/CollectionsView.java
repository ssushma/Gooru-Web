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
import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.child.ChildView;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.classpages.assignments.AddAssignmentContainerCBundle;
import org.ednovo.gooru.client.mvp.classpages.edit.EditClasspageView;
import org.ednovo.gooru.client.mvp.home.WaitPopupVc;
import org.ednovo.gooru.client.mvp.search.event.SetMarkButtonEvent;
import org.ednovo.gooru.client.mvp.search.event.SetMarkButtonHandler;
import org.ednovo.gooru.client.mvp.socialshare.event.UpdateSocialShareMetaDataEvent;
import org.ednovo.gooru.client.mvp.socialshare.event.UpdateSocialShareMetaDataHandler;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.NativeEvent;
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
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

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
	
	@UiField HTMLPanel thumbnailContainer,directionContentPanel;
	
	@UiField HTML learningObject;
	
	@UiField Anchor classpageItemTitle;
	
	@UiField Image collectionImage;
	
	@UiField Label assignmentSequenceLabel,dueDateText,dueDateButton;
	
	@UiField ChangeAssignmentStatusView changeAssignmentStatusView;
	
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
	}
	
	private void setAssignmentSequence(int sequenceNumber){
		assignmentSequenceLabel.setText("Assignment "+sequenceNumber);
	}
	
	private void setAssignmentStatus(boolean assignmentStatus){
		//changeAssignmentStatusView
	}
	
	private void setDueDate(String dueDate){
		//dueDateText
	}
	
	private void setMinimumScore(String score){
		
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
	
}
