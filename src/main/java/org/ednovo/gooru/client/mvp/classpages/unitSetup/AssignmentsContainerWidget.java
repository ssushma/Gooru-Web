package org.ednovo.gooru.client.mvp.classpages.unitSetup;


import org.ednovo.gooru.client.mvp.classpages.unitdetails.UnitCricleView;
import org.ednovo.gooru.client.mvp.home.register.RegisterCBundle;
import org.ednovo.gooru.client.mvp.play.collection.preview.home.assign.AssignPopUpCBundle;
import org.ednovo.gooru.client.mvp.profilepage.ProfilePageCBundle;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class AssignmentsContainerWidget extends Composite  {
	
	private static AssignmentsContainerWidgetUiBinder uibinder = GWT.create(AssignmentsContainerWidgetUiBinder.class);
	interface AssignmentsContainerWidgetUiBinder extends UiBinder<Widget, AssignmentsContainerWidget>{
		
	}
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	@UiField Image assignmentThumbnail;
	
	@UiField Label dueDays;
	
	@UiField UnitCricleView unitCircleView;
	
	@UiField AssignmentContainerWidgetCBundle unitStyle;
	

	
	public AssignmentsContainerWidget(ClasspageItemDo classpageItemDo){ 
		initWidget(uibinder.createAndBindUi(this));
		unitCircleView.setUnitSequenceNumber(classpageItemDo.getItemSequence());
		assignmentThumbnail.setUrl(classpageItemDo.getResource().getThumbnails().getUrl());
		if(classpageItemDo.getStatus() != null)
		{
			if(classpageItemDo.getStatus().equalsIgnoreCase("completed"))
			{
				unitCircleView.setUnitSequenceNumber(0);
				unitCircleView.getElement().getFirstChildElement().setClassName(unitStyle.greenBubble());
			}
		}
		if(classpageItemDo.getIsRequired() != null)
		{
			if(!classpageItemDo.getIsRequired())
			{
				unitCircleView.getElement().getFirstChildElement().setClassName(unitStyle.stylishBub());
			}
		}
		
	}
	
	@UiHandler("assignmentThumbnail")
	public void setErrorImage(ErrorEvent event){
		assignmentThumbnail.setUrl("images/default-collection-image-160x120.png");
	}
	
}
