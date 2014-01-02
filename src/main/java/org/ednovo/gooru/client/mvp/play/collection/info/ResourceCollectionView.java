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
package org.ednovo.gooru.client.mvp.play.collection.info;

import java.util.List;

import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.client.uc.ToolTipPopUp;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ResourceCollectionView extends Composite{
	
	@UiField Image collectionThumbnail;
	
	@UiField Label collectionTitle,userName;
	
	@UiField HTMLPanel metadataContainer;
	
	ToolTipPopUp toolTip ; 
	
	private ResourceSearchResultDo resourceSearchResultDo;
	
	private static final String SEPARATOR="&#8226;";
	
	private static ResourceCollectionViewUiBinder uiBinder = GWT.create(ResourceCollectionViewUiBinder.class);

	interface ResourceCollectionViewUiBinder extends UiBinder<Widget, ResourceCollectionView> {
		
	}
	
	public ResourceCollectionView(){
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiConstructor
	public ResourceCollectionView(ResourceSearchResultDo resourceSearchResultDo){
		initWidget(uiBinder.createAndBindUi(this));
		this.resourceSearchResultDo=resourceSearchResultDo;
		setCollectionTitle(resourceSearchResultDo.getResourceTitle());
		setUserNameDisplay(resourceSearchResultDo.getOwner().getUsername());
		setCollectionMetadata();
	}
	
	public void setCollectionTitle(String collectionTitle){
		this.collectionTitle.setText(collectionTitle);
	}
	
	public void setUserNameDisplay(String userNameDisplay){
		userName.setText(userNameDisplay);
	}
	
	public void setCollectionMetadata(){
		metadataContainer.clear();
		metadataContainer.add(getCourseNames());
		metadataContainer.add(getViewsLabel());
		metadataContainer.add(getSeparator());
		metadataContainer.add(setResourceCount());
	}
	
	private HTMLPanel getCourseNames(){
		HTMLPanel cousreContainer=new HTMLPanel("");
		List<String> coursesList=resourceSearchResultDo.getCourseNames();
		if(coursesList.size()>0){
			Label courseName=new Label(coursesList.get(0));
			courseName.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().getCourseTitle());
			cousreContainer.add(courseName);
			if(coursesList.size()>1){
				Label courseCount=new Label("+"+(coursesList.size()-1));
				courseCount.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().getCourseCount());
				cousreContainer.add(courseCount);
				Widget Coursewidget = getToolTipwidgets(coursesList);
				courseCount.addMouseOverHandler(new MouseOverShowToolTip(Coursewidget));
				courseCount.addMouseOutHandler(new MouseOutHideToolTip());
			}
			cousreContainer.add(getSeparator());
		}
		return cousreContainer;
	}
	
	private Widget getToolTipwidgets(List<String> coursesList) {
		FlowPanel toolTipwidgets = new FlowPanel();
		for(int i=1;i<coursesList.size();i++){
			Label courseLabel = new Label(coursesList.get(i));
			toolTipwidgets.add(courseLabel);
		}
		return toolTipwidgets;
	}

	
	private Label getViewsLabel(){
		String views=resourceSearchResultDo.getTotalViews()==1?resourceSearchResultDo.getTotalViews()+" View":resourceSearchResultDo.getTotalViews()+" Views";
		Label viewsLabel=new Label(views);
		viewsLabel.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().getCourseTitle());
		return viewsLabel;
	}
	
	private HTMLPanel getSeparator(){
		HTMLPanel separator=new HTMLPanel(SEPARATOR);
		separator.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().sourceSepartor());
		return separator;
	}
	
	private Label setResourceCount(){
		String resourcesCount=resourceSearchResultDo.getNoOfResources()==1?resourceSearchResultDo.getNoOfResources()+" Resource":resourceSearchResultDo.getNoOfResources()+" Resources";
		Label resourceCountLabel=new Label(resourcesCount);
		resourceCountLabel.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().getResourceCount());
		return resourceCountLabel;
	}

	@UiHandler("collectionThumbnail")
	public void setDefaultCollectionThumbnail(ErrorEvent event){
		collectionThumbnail.setUrl("images/default-collection-image-160x120.png");
	}
	
	
	@Override
	public void onLoad(){
		collectionThumbnail.setUrl(resourceSearchResultDo.getUrl());
	}
	
	public class MouseOverShowToolTip implements MouseOverHandler
	{
		Widget widget;
		
		public MouseOverShowToolTip(Widget coursewidget) {
			this.widget = coursewidget;
		}

		@Override
		public void onMouseOver(MouseOverEvent event) {
			toolTip = new ToolTipPopUp(widget,(event.getRelativeElement().getAbsoluteLeft()-45),(event.getRelativeElement().getAbsoluteTop()+22)); 
			toolTip.show();
		}
		
	}
	
	public class MouseOutHideToolTip implements MouseOutHandler
	{
		@Override
		public void onMouseOut(MouseOutEvent event) {
			toolTip.hide();
		}
		
	}
	
}
