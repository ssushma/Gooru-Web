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
package org.ednovo.gooru.client.mvp.classpages.edit;

import java.util.HashMap;
import java.util.Map;

import org.apache.tools.ant.taskdefs.XSLTProcess.Param;
import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.event.ResetProgressEvent;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : AssignmentProgress.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: Jun 9, 2014
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
public class AssignmentProgressVc extends Composite implements MessageProperties {


	private static AssignmentProgressVcUiBinder uiBinder = GWT
			.create(AssignmentProgressVcUiBinder.class);

	interface AssignmentProgressVcUiBinder extends UiBinder<Widget, AssignmentProgressVc> {
	}
	
	@UiField(provided = true)
	AssignmentProgressCBundle res;
	
	@UiField 
	Label lblLineStart, lblLineEnd, lblAssignmentNo, lblCircle1;
	
	@UiField HTMLPanel panelCircle,panelCicle1, resourceTypePanel,moveAssignmentPopup,dueDateContainer;
	
	@UiField HTML htmlCollectiontitle,assignmentCollectiontitle;
	
	@UiField Label lblMoveTo, resoureDropDownLbl, resourceCategoryLabel;
	
	@UiField FlowPanel panelMainContainer,assignmentInfoPopup;	
	
	@UiField Button studyButtonText;
	
	boolean isLast;
	private ClasspageItemDo classpageItemDo;
	int assignmentNumber;
	
	/**
	 * Class constructor
	 */
	public AssignmentProgressVc(boolean isLast, ClasspageItemDo classpageList, int assignmentNumber, int assignmentTotalCount) {
		
		this.isLast = isLast;
		this.classpageItemDo = classpageList;
		this.assignmentNumber = assignmentNumber;
		
		this.res = AssignmentProgressCBundle.INSTANCE;
		initWidget(uiBinder.createAndBindUi(this));
		res.css().ensureInjected();
		assignmentInfoPopup.removeFromParent();
		
		panelMainContainer.getElement().setAttribute("id", classpageList.getCollectionItemId());
		lblLineEnd.setVisible(this.isLast ? false : true);
		lblLineStart.setVisible(assignmentNumber == 1 ? false : true);
//		if (isLast){
//			lblAssignmentNo.getElement().getStyle().setTextAlign(TextAlign.RIGHT);			
//		}else{
//			lblAssignmentNo.getElement().getStyle().clearTextAlign();
//		}
		
//		if (assignmentNumber >9){
//			lblAssignmentNo.getElement().getStyle().clearMarginRight();				
//		}else{
//			lblAssignmentNo.getElement().getStyle().setMarginRight(4, Unit.PX);
//		}
//		lblCircle.getElement().addClassName(res.css().viewedCircle());
		lblAssignmentNo.setText(String.valueOf(assignmentNumber));
		
		htmlCollectiontitle.setHTML(classpageList.getCollectionTitle());
		lblMoveTo.setText(GL1912);
		
		resourceTypePanel.setVisible(false);
		resourceCategoryLabel.setText(String.valueOf(assignmentNumber));
		
		resoureDropDownLbl.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				resourceTypePanel.setVisible(resourceTypePanel.isVisible() ? false : true);
			}
		});
		
		resourceCategoryLabel.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				resourceTypePanel.setVisible(resourceTypePanel.isVisible() ? false : true);
			}
		});
		
		for (int i=0; i<assignmentTotalCount; i++){
			resourceTypePanel.add(createLabel(""+(i+1)));
		}
	}
	
	
	public AssignmentProgressVc(boolean isLastCollection, final ClasspageItemDo classpageItemDo, int sequenceNumber) {
		this.res = AssignmentProgressCBundle.INSTANCE;
		initWidget(uiBinder.createAndBindUi(this));
		this.res.css().ensureInjected();
		this.classpageItemDo=classpageItemDo;
		moveAssignmentPopup.removeFromParent();
		setDueDateAndDirection();
		assignmentCollectiontitle.setHTML(classpageItemDo.getCollectionTitle());
		panelMainContainer.getElement().setAttribute("id", classpageItemDo.getCollectionItemId());
//		if (isLastCollection){
//			lblAssignmentNo.getElement().getStyle().setTextAlign(TextAlign.RIGHT);			
//		}else{
//			lblAssignmentNo.getElement().getStyle().clearTextAlign();
//		}
		lblLineStart.setVisible(sequenceNumber == 1 ? false : true);
		lblLineEnd.setVisible(isLastCollection ? false : true);
//		if (sequenceNumber >9){
//			lblAssignmentNo.getElement().getStyle().clearMarginRight();				
//		}else{
//			lblAssignmentNo.getElement().getStyle().setMarginRight(4, Unit.PX);
//		}
		lblAssignmentNo.setText(""+sequenceNumber);
		lblCircle1.setText(""+sequenceNumber);
		if(classpageItemDo.getStatus().equalsIgnoreCase("open")){
			panelCircle.setStyleName(this.res.css().bluecircle());
			panelCicle1.setStyleName(this.res.css().bluecircle());
		}else{
			panelCircle.setStyleName(this.res.css().greencircle());
			panelCicle1.setStyleName(this.res.css().greencircle());
		}
		studyButtonText.setText(GL0182);
		studyButtonText.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Map<String, String> parms = new HashMap<String, String>();
				parms.put("id", classpageItemDo.getCollectionId());
				parms.put("cid", classpageItemDo.getCollectionItemId());
				parms.put("page", "study");
				
				AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.COLLECTION_PLAY, parms, false);
			}
		});
	}
	
	public void updateDotsCircle(String readStatus){
		classpageItemDo.setStatus(readStatus);
		System.out.println("classpageItemDo.getStatus() : "+classpageItemDo.getStatus());
		if(classpageItemDo.getStatus().equalsIgnoreCase("open")){
			panelCircle.setStyleName(this.res.css().bluecircle());
			panelCicle1.setStyleName(this.res.css().bluecircle());
		}else{
			panelCircle.setStyleName(this.res.css().greencircle());
			panelCicle1.setStyleName(this.res.css().greencircle());
		}
	}
	
	public void setDueDateAndDirection(){
		dueDateContainer.clear();
		String dueDate=classpageItemDo.getPlannedEndDate();
		if(dueDate!=null&&!dueDate.equals("")){
			Label dueDateText=new Label(GL1390);
			dueDateText.setStyleName(this.res.css().dueDataIcon());
			Label dueDateLabel=new Label(dueDate.toString());
			dueDateLabel.setStyleName(this.res.css().headerDueDate());
			dueDateContainer.add(dueDateText);
			dueDateContainer.add(dueDateLabel);
		}
		String directionDescription=classpageItemDo.getDirection();
		if(directionDescription!=null&&!directionDescription.equals("")){
			InlineLabel directionHeadLabel=new InlineLabel(GL1372);
			directionHeadLabel.setStyleName(this.res.css().directionHeading());
			InlineLabel directionTextLabel=new InlineLabel(directionDescription);
			directionTextLabel.setStyleName(this.res.css().directionDesc());
			dueDateContainer.add(directionHeadLabel);
			dueDateContainer.add(directionTextLabel);
		}
	}
	
	
	public Label createLabel(String title){
		Label lblLabel = new Label();
		lblLabel.setText(title);
		lblLabel.getElement().addClassName(res.css().myFolderCollectionFolderDropdown());
		lblLabel.getElement().addClassName(res.css().myFolderCollectionFolderVideoTitle());
		lblLabel.getElement().setAttribute("alt", title);
		lblLabel.getElement().setAttribute("title", title);
		lblLabel.getElement().setAttribute("id", title);
		lblLabel.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Label lbl = (Label)event.getSource();
				resourceCategoryLabel.setText(lbl.getText());
				
				
				AppClientFactory.getInjector().getClasspageService().v2ChangeAssignmentSequence("", classpageItemDo.getCollectionItemId(), Integer.parseInt(lbl.getText()), new SimpleAsyncCallback<Void>() {

					@Override
					public void onSuccess(Void result) {
						resourceTypePanel.setVisible(resourceTypePanel.isVisible() ? false : true);
						AppClientFactory.fireEvent(new ResetProgressEvent());
					}
				});
			}
		});
		return lblLabel;
	}
}
