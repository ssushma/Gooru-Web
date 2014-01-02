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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.client.uc.ToolTipPopUp;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.LicenseDo;
import org.ednovo.gooru.shared.model.content.ResoruceCollectionDo;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class ResourceInfoView extends BaseViewWithHandlers<ResourceInfoUiHandlers> implements IsResourceInfoView{
	
	public static final String STANDARD_CODE = "code";
	public static final String STANDARD_DESCRIPTION = "description";
	
	@UiField HTMLPanel resourceDescription,rightsLogoContainer,courseInfo,reosourceReleatedCollections;
	
	@UiField ScrollPanel scrollPanel;
	
	@UiField Label staticGradeText,resourceViewsCount,resourceOriginalUrl,resourceLikesCount;
	
	@UiField Label resourceTypeImage,resourceAttributon,collectionsCount;
	
	@UiField FlowPanel standardsInfoConatiner;
	
	@UiField HTML resourceInfoSeparator;
	
	ToolTipPopUp toolTip ; 
	
	private static final String NOT_AVAILABLE="Not available";
	
	private static final String NONE_ADDED="None added";
	
	private static final String SEPARATOR="&#8226;";
	
	
    private static final  String PAGE_SIZES="20";
    
    private int collectionItemSizeData=0;
    
    private int totalItemSize=0;
    
    private Integer currentPageSize=1;
    
    private String gooruResourceOId;
	
	private static ResourceInfoViewUiBinder uiBinder = GWT.create(ResourceInfoViewUiBinder.class);

	interface ResourceInfoViewUiBinder extends UiBinder<Widget, ResourceInfoView> {
		
	}
	@Inject
	public ResourceInfoView(){
		setWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setResourceMedaDataInfo(CollectionItemDo collectionItemDo) {
		setResourceTypeImage(collectionItemDo.getResource().getCategory());
		setResourceAttribution(collectionItemDo.getResource().getResourceSource()!=null?collectionItemDo.getResource().getResourceSource().getAttribution():
				null,collectionItemDo.getResource().getTaxonomySet());
		setResourceDescription(collectionItemDo.getResource().getDescription());
		setResourceViewsCount(collectionItemDo.getViews());
		setResourceLikesCount(collectionItemDo.getRating().getVotesUp());
		setResourceOriginalUrl(collectionItemDo.getResource().getUrl());
		setResourceLicenceLogo(collectionItemDo.getResource().getAssetURI(), collectionItemDo.getResource().getLicense());
		renderStandards(collectionItemDo.getStandards());
		setGrades(collectionItemDo.getResource().getGrade());
		loadResourceReleatedCollections(collectionItemDo.getResource().getGooruOid());
	}
	
	public void setResourceTypeImage(String resouceType){
		resourceTypeImage.addStyleName(getResourceTypeImage(resouceType));
	}
	
	public void setResourceDescription(String resourceDescription){
		this.resourceDescription.clear();
		if(resourceDescription!=null && !resourceDescription.equalsIgnoreCase("null")){
			this.resourceDescription.add(setText(resourceDescription));
		}
	}
	
	public void setResourceAttribution(String attribution,Set<CodeDo> taxonomoyList){
		List<String> coursesList=new ArrayList<String>();
		if(taxonomoyList!=null){
			Iterator<CodeDo> taxonomyIterator=taxonomoyList.iterator();
			while (taxonomyIterator.hasNext()) {
				CodeDo codeDo=taxonomyIterator.next();
				if(codeDo.getDepth()==2){
					coursesList.add(codeDo.getLabel());
				}
			}
		}
		courseInfo.clear();
		if(coursesList.size()>0){
			resourceInfoSeparator.setHTML(SEPARATOR);
			resourceInfoSeparator.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().sourceSepartor());
			final Label courseInfoLabel=new Label(coursesList.get(0));
			courseInfoLabel.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().resourceCourseLabel());
			courseInfo.add(courseInfoLabel);
		}
		if(coursesList.size()>1){
			final Label courseCountLabel=new Label("+"+(coursesList.size()-1)); 
			courseCountLabel.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().resourceCourseNum());
			courseInfo.add(courseCountLabel);
			Widget Coursewidget = getToolTipwidgets(coursesList);
			courseCountLabel.addMouseOverHandler(new MouseOverShowToolTip(Coursewidget));
			courseCountLabel.addMouseOutHandler(new MouseOutHideToolTip());
			
		}
		if(attribution!=null && !attribution.equalsIgnoreCase("null")){
			resourceAttributon.setText(attribution);
		}else{
			resourceAttributon.setText("");
			resourceInfoSeparator.setStyleName("");
			resourceInfoSeparator.setHTML("");
		}
	}
	
	private Widget getToolTipwidgets(List<String> coursesList) {
		
		FlowPanel toolTipwidgets = new FlowPanel();
		for(int i=1;i<coursesList.size();i++){
			Label courseLabel = new Label(coursesList.get(i));
			toolTipwidgets.add(courseLabel);
		}
		return toolTipwidgets;
	}

	public void setResourceViewsCount(String viewCount){
		String viewCountLabel=viewCount.equals("1")?viewCount+" View":viewCount+" Views";
		resourceViewsCount.setText(viewCountLabel);
	}
	
	public void setResourceLikesCount(int likesCount){
		String likesCountLabel=likesCount==1?likesCount+" Like":likesCount+" Likes";
		resourceLikesCount.setText(likesCountLabel);
	}
	
	public void setCourseInfo(){
		
	}
	
	public void setGrades(String gradesText){
		if(gradesText!=null){
			staticGradeText.setText(getGrades(gradesText));
		}else{
			staticGradeText.setText("");
		}
	}
	
	public String getGrades(String gradesText){
		String addedGrades="";
		if(gradesText!=null&&!gradesText.equals("")){
			String[] gradesArray=gradesText.split("\\,");
			Set<Integer> gradesList=new TreeSet<Integer>();
			for(int i=0;i<gradesArray.length;i++){
				try{
					int grade=Integer.parseInt(gradesArray[i]);
					gradesList.add(grade);
				}catch(NumberFormatException exception){
				}
			}
			Iterator<Integer> itr=gradesList.iterator();
			int gradeCount=0;
			while(itr.hasNext()){
				addedGrades=addedGrades+itr.next();
				gradeCount++;
				if(gradesList.size()!=gradeCount){
					addedGrades=addedGrades+",";
				}
			}
			if(gradesText.contains("Kindergarten")&&gradesText.contains("Higher Education")){
				addedGrades="Kindergarten,"+addedGrades+",Higher Education";
			}else if(gradesText.contains("Kindergarten")){
				addedGrades="Kindergarten,"+addedGrades;
			}else if(gradesText.contains("Higher Education")){
				addedGrades=addedGrades+",Higher Education";
			}
		}else{
			addedGrades=NONE_ADDED;
		}
		return addedGrades;
	}
	
	public void setResourceOriginalUrl(String url){
		if(url!=null && !url.equals("")){
			resourceOriginalUrl.setText(url);
		}
		else{
			resourceOriginalUrl.setText(NONE_ADDED);
		}
	}
	
	public HTML setText(String text){
		text=text.replaceAll("</p>", " ").replaceAll("&nbsp;", " ").replaceAll("<p>", "")
					.replaceAll("<span>", "").replaceAll("<br", "").replaceAll(">", "");
		HTML html=new HTML(text);
		html.setStyleName("");
		return html;
	}
	
	public void setResourceLicenceLogo(String assetUrl,LicenseDo licenseDo){
		if(licenseDo!=null){
			if(licenseDo.getIcon()!=null&&!licenseDo.getIcon().trim().equals("")){
				Image image=new Image();
				image.setUrl(assetUrl+licenseDo.getIcon());
				rightsLogoContainer.clear();
				rightsLogoContainer.add(image);
				image.addMouseOverHandler(new MouseOverShowStandardToolTip(licenseDo.getDefinition()));
				image.addMouseOutHandler(new MouseOutHideToolTip());
			}
			else{
				rightsLogoContainer.clear();
				rightsLogoContainer.add(setText(NOT_AVAILABLE));
			}
		}else{
			rightsLogoContainer.clear();
			rightsLogoContainer.add(setText(NOT_AVAILABLE));
		}		
	}	
	public void renderStandards(List<Map<String,String>> standardsList){
		if(standardsList!=null&&standardsList.size()>0){
			standardsInfoConatiner.clear();
			for(int i=0;i<standardsList.size();i++){
				Map<String,String> standardMap=standardsList.get(i);
				final Label standardText=new Label(standardMap.get(STANDARD_CODE));
				standardText.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().standardText());
				standardsInfoConatiner.add(standardText);
				standardText.addMouseOverHandler(new MouseOverShowStandardToolTip(standardMap.get(STANDARD_DESCRIPTION)));
				standardText.addMouseOutHandler(new MouseOutHideToolTip());
			}
		}else{
			standardsInfoConatiner.clear();
			standardsInfoConatiner.add(setText(NONE_ADDED));
		}
	}
	
	public void loadResourceReleatedCollections(String resourceGooruOid){
		reosourceReleatedCollections.clear();
		collectionItemSizeData=0;
		currentPageSize=1;
		collectionsCount.setText("");
		gooruResourceOId = resourceGooruOid;
		getUiHandlers().getCollectionList(resourceGooruOid, currentPageSize.toString(), PAGE_SIZES); 
		
	}
	
	public String getResourceTypeImage(String resourceType){
		if(resourceType.equalsIgnoreCase("Video")){
			return PlayerBundle.INSTANCE.getPlayerStyle().videoResourceType();
		}else if(resourceType.equalsIgnoreCase("Interactive")){
			return PlayerBundle.INSTANCE.getPlayerStyle().interactiveResourceType();
		}
		else if(resourceType.equalsIgnoreCase("Website")){
			return PlayerBundle.INSTANCE.getPlayerStyle().websiteResourceType();		
		}
		else if(resourceType.equalsIgnoreCase("Slide")){
			return PlayerBundle.INSTANCE.getPlayerStyle().slideResourceType();
		}
		else if(resourceType.equalsIgnoreCase("Textbook")){
			return PlayerBundle.INSTANCE.getPlayerStyle().textbookResourceType();
		}
		else if(resourceType.equalsIgnoreCase("Question")){
			return PlayerBundle.INSTANCE.getPlayerStyle().questionResourceType();
		}
		else if(resourceType.equalsIgnoreCase("lesson")){
			return PlayerBundle.INSTANCE.getPlayerStyle().lessonResourceType();
		}else if(resourceType.equalsIgnoreCase("Handout")){
			return PlayerBundle.INSTANCE.getPlayerStyle().handoutResourceType();
		}else {
			return PlayerBundle.INSTANCE.getPlayerStyle().examResourceType();
		}
	}

	@Override
	public void loadResourceCollection(ResoruceCollectionDo resoruceCollectionDo) {
		List<ResourceSearchResultDo> resourceSearchResultList=resoruceCollectionDo.getSearchResults();
		collectionsCount.setText("("+resoruceCollectionDo.getTotalHitCount()+")");
		totalItemSize = resoruceCollectionDo.getTotalHitCount();
		collectionItemSizeData=currentPageSize*Integer.parseInt(PAGE_SIZES);
		for(int i=0;i<resourceSearchResultList.size();i++){
			reosourceReleatedCollections.add(new ResourceCollectionView(resourceSearchResultList.get(i)));
		}
	}
	
	@UiHandler("scrollPanel")
	public void onScrollReosourceReleatedCollections(ScrollEvent scrollEvent ){
		
		if(scrollPanel.getVerticalScrollPosition() == scrollPanel.getMaximumVerticalScrollPosition() && collectionItemSizeData<totalItemSize){
			currentPageSize=currentPageSize+1;
			getUiHandlers().getCollectionList(gooruResourceOId, currentPageSize.toString(), PAGE_SIZES);
		}
		
	}
	
	public class MouseOverShowStandardToolTip implements MouseOverHandler
	{
		String desc=null;
		
		public MouseOverShowStandardToolTip(String description) {
			this.desc = description;
		}
		
		@Override
		public void onMouseOver(MouseOverEvent event) {
			toolTip = new ToolTipPopUp(desc, (event.getRelativeElement().getAbsoluteLeft()-45),(event.getRelativeElement().getAbsoluteTop()+22));
			toolTip.show();
		}
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
