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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter;
import org.ednovo.gooru.client.uc.DownToolTipWidgetUc;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.client.uc.StandardSgItemVc;
import org.ednovo.gooru.client.uc.ToolTipPopUp;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.LicenseDo;
import org.ednovo.gooru.shared.model.content.ResoruceCollectionDo;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class ResourceInfoView extends BaseViewWithHandlers<ResourceInfoUiHandlers> implements IsResourceInfoView,MessageProperties{
	
	public static final String STANDARD_CODE = "code";
	public static final String STANDARD_DESCRIPTION = "description";
	
	@UiField HTMLPanel resourceDescription,rightsLogoContainer,courseInfo,reosourceReleatedCollections,mobileFriendly,collectionsText,originalUrlText,publisherPanel,coursePanel,gradesPanel,
	oerPanel,mobileFriendlyPanel,DataTypePanel,interactivityTypePanel,eduAllignPanel,eduUsePanel,eduRolePanel,ageRangePanel,dKnowledgePanel,
	readingLevelPanel,schoolLevelPanel,languagePanel,countryCodePanel,addsPanel,copyRightPanel,hostPanel,courseNumberPanel,
	seriesPanel,accessibilityPanel,controlPanel,accessHazardPanel,mediaFeaturePanel,accessModePanel;
	
	@UiField static  HTMLPanel standardsContentContainer;
	
	@UiField ScrollPanel scrollPanel;
	
	//@UiField Label staticGradeText;
	
	@UiField Label resourceTypeImage,resourceView,collectionsCount,lblPublisher,lblresourceType,publisherText,courseText,legalText,learningobjectiveText,
					standardsText,hideText,resourceInfoText,gradeTitle,gradesText,originalUrlTitle,timeRequiredLabel,oerTitle,mbFriendlyLbl,
					mbFriendlyText,dataTypeLbl,dataTypeFormat,interactiveLbl,interactiveType,eduAllignLbl,eduAllignType,eduUseLbl,eduUseType,
					eduRoleLbl,eduRoleType,ageRangeLbl,ageRangeType,dKnowledgeLbl,dKnowledgeType,readingLevelLbl,readingLevelType,
					schoolLevelType,schoolLevelLbl,languageLbl,languageType,countryCodeLbl,countryCodeType,addsLbl,addsType,
					copyRightType,copyRightLbl,hostType,hostLbl,cNoLbl,cNoType,seriesType,seriesLbl,controlType,controlLbl,
					acessHazardlLbl,acessHazardType,mediaFeatureLbl,mediaFeatureType,accessModelLbl,accessModeType,accesibilityLbl,generalLbl;
	
	@UiField static Label standaInfo;
	
	@UiField FlowPanel standardsInfoConatiner,licenceContainer;
	
	@UiField HTML resourceInfoSeparator,resourceInfoSeparatorTimeLbl,metadataBottomseperatorLine,metadataBottomseperatorLineTwo;
	@UiField
	HTMLEventPanel hideButton;
	
	ToolTipPopUp toolTip ; 
	
	private static final String SEPARATOR="|";
	
	private static final String ALL_GRADES = "ALL GRADES";
	
    private static final  String PAGE_SIZES="20";
    
    private static final String NOT_FRIENDY_TAG="not_iPad_friendly";
    
    private static final String BOTTOMSEPARATOR="____________________________________________________________________";
    
    
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
		standardsInfoConatiner.clear();
		generalLbl.setText(GL1684);
		publisherText.setText(GL0566);
		courseText.setText(GL0616);
		legalText.setText(GL0730+ ""+GL_SPL_SEMICOLON);
		learningobjectiveText.setText(GL0904 + ""+GL_SPL_SEMICOLON);
		standardsText.setText(GL0619);
		collectionsText.getElement().setInnerHTML(GL0620);
		hideText.setText(GL0592);
		resourceInfoText.setText(GL0621);
		gradeTitle.setText(GL0325+ ""+GL_SPL_SEMICOLON);
		originalUrlTitle.setText(GL0976+ ""+GL_SPL_SEMICOLON);
	//	standaInfo.setText(GL0977);
		resourceInfoSeparator.setHTML(SEPARATOR);
		resourceInfoSeparatorTimeLbl.setHTML(SEPARATOR);
		resourceInfoSeparator.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().sourceSepartor());
		timeRequiredLabel.setText(GL1660+GL_SPL_SEMICOLON);
		resourceInfoSeparatorTimeLbl.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().sourceSepartor());
		oerTitle.setText(GL1661+GL_SPL_SEMICOLON);
		mbFriendlyLbl.setText(GL1662+GL_SPL_SEMICOLON);
		mbFriendlyText.setText("");
		metadataBottomseperatorLine.setHTML(BOTTOMSEPARATOR);
		dataTypeLbl.setText(GL1663+GL_SPL_SEMICOLON);
		dataTypeFormat.setText("");
		interactiveLbl.setText(GL1664+GL_SPL_SEMICOLON);
		interactiveType.setText("");
		eduAllignLbl.setText(GL1665+GL_SPL_SEMICOLON);
		eduAllignType.setText("");
		eduUseLbl.setText(GL1666+GL_SPL_SEMICOLON);
		eduUseType.setText("");
		eduRoleLbl.setText(GL1667+GL_SPL_SEMICOLON);
		eduRoleType.setText("");
		ageRangeLbl.setText(GL1668+GL_SPL_SEMICOLON);
		ageRangeType.setText("");
		dKnowledgeLbl.setText(GL1669+GL_SPL_SEMICOLON);
		dKnowledgeType.setText("");
		readingLevelLbl.setText(GL1670+GL_SPL_SEMICOLON);
		readingLevelType.setText("");
		schoolLevelLbl.setText(GL1671+GL_SPL_SEMICOLON);
		schoolLevelType.setText("");
		languageLbl.setText(GL1672+GL_SPL_SEMICOLON);
		languageType.setText("");
		countryCodeLbl.setText(GL1673+GL_SPL_SEMICOLON);
		countryCodeType.setText("");
		addsLbl.setText(GL1674+GL_SPL_SEMICOLON);
		addsType.setText("");
		copyRightLbl.setText(GL1675+GL_SPL_SEMICOLON);
		copyRightType.setText("");
		hostLbl.setText(GL1676+GL_SPL_SEMICOLON);
		hostType.setText("");
		cNoLbl.setText(GL1677+GL_SPL_SEMICOLON);
		cNoType.setText("");
		seriesLbl.setText(GL1678+GL_SPL_SEMICOLON);
		seriesType.setText("");
		metadataBottomseperatorLineTwo.setHTML(BOTTOMSEPARATOR);
		accesibilityLbl.setText(GL1679);
		controlLbl.setText(GL1680+GL_SPL_SEMICOLON);
		controlType.setText("");
		acessHazardlLbl.setText(GL1681+GL_SPL_SEMICOLON);
		acessHazardType.setText("");
		mediaFeatureLbl.setText(GL1682+GL_SPL_SEMICOLON);
		mediaFeatureType.setText("");
		accessModelLbl.setText(GL1683+GL_SPL_SEMICOLON);
		accessModeType.setText("");
		generalLbl.setVisible(false);
		timeRequiredLabel.setVisible(false);
		resourceInfoSeparatorTimeLbl.setVisible(false);
		oerPanel.setVisible(false);
		mobileFriendlyPanel.setVisible(false);
		metadataBottomseperatorLine.setVisible(false);
		DataTypePanel.setVisible(false);
		interactivityTypePanel.setVisible(false);
		eduAllignPanel.setVisible(false);
		eduUsePanel.setVisible(false);
		eduRolePanel.setVisible(false);
		ageRangePanel.setVisible(false);
		dKnowledgePanel.setVisible(false);
		readingLevelPanel.setVisible(false);
		schoolLevelPanel.setVisible(false);
		languagePanel.setVisible(false);
		countryCodePanel.setVisible(false);
		addsPanel.setVisible(false);
		copyRightPanel.setVisible(false);
		hostPanel.setVisible(false);
		courseNumberPanel.setVisible(false);
		seriesPanel.setVisible(false);
		metadataBottomseperatorLineTwo.setVisible(false);
		accessibilityPanel.setVisible(false);
		controlPanel.setVisible(false);
		accessHazardPanel.setVisible(false);
		mediaFeaturePanel.setVisible(false);
		accessModePanel.setVisible(false);
		
	}

	@Override
	public void setResourceMedaDataInfo(CollectionItemDo collectionItemDo) {
		if(collectionItemDo.getResource().getMediaType()!=null){
			if(collectionItemDo.getResource().getMediaType().equals(NOT_FRIENDY_TAG)){	
				mobileFriendly.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().ipadFriendlyIconBlock());
			}
		}
		if(collectionItemDo.getResource().getResourceFormat()!=null){
			setResourceTypeImage(collectionItemDo.getResource().getResourceFormat().getDisplayName());
		}
		setResourceAttribution(collectionItemDo.getResource().getResourceSource()!=null?collectionItemDo.getResource().getResourceSource().getAttribution():
				null,collectionItemDo.getResource().getTaxonomySet());
		setResourceDescription(collectionItemDo.getResource().getDescription());
		setResourceViewsCount(collectionItemDo.getViews());
		setResourceLicenceLogo(collectionItemDo.getResource().getAssetURI(), collectionItemDo.getResource().getLicense());
		renderStandards(standardsInfoConatiner,collectionItemDo.getStandards());
		setGrades(collectionItemDo.getResource().getGrade());
		setOriginalUrl(collectionItemDo.getResource().getAssetURI(),collectionItemDo.getResource().getFolder(),
							collectionItemDo.getResource().getUrl(),collectionItemDo.getResource().getResourceType().getName());
		loadResourceReleatedCollections(collectionItemDo.getResource().getGooruOid());
		setPublisher(collectionItemDo.getResource().getResourceSource()!=null?collectionItemDo.getResource().getResourceSource().getAttribution():"",collectionItemDo.getResource().getUrl());
		
	}
	
	public void setResourceDescription(String resourceDescription){
		this.resourceDescription.clear();
		if(resourceDescription!=null && !resourceDescription.equalsIgnoreCase("null") && !resourceDescription.equalsIgnoreCase("")){
			this.resourceDescription.setVisible(true);
			this.learningobjectiveText.setVisible(true);
			if(resourceDescription.length()>415){
				resourceDescription =(resourceDescription.substring(0, 415))+"...";
				this.resourceDescription.add(setText(resourceDescription));
			}
			else{
				this.resourceDescription.add(setText(resourceDescription));
			}
		}
		else
		{
			//this.resourceDescription.add(setText(GL0977));
			this.resourceDescription.setVisible(false);
			this.learningobjectiveText.setVisible(false);
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
			final Label courseInfoLabel=new Label(coursesList.get(0));
			courseInfoLabel.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().resourceCourseLabel());
			courseInfo.add(courseInfoLabel);
			coursePanel.setVisible(true);
		}
		if(coursesList.size()>1){
			final Label courseCountLabel=new Label("+"+(coursesList.size()-1)); 
			courseCountLabel.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().resourceCourseNum());
			courseInfo.add(courseCountLabel);
			Widget Coursewidget = getToolTipwidgets(coursesList);
			courseCountLabel.addMouseOverHandler(new MouseOverShowToolTip(Coursewidget));
			courseCountLabel.addMouseOutHandler(new MouseOutHideToolTip());
			 coursePanel.setVisible(true);
			
		}
		if(coursesList.size()==0){
			 /*Label courseInfoLabel=new Label();
			 courseInfoLabel.setText(GL0977);
			 courseInfo.clear();
			 courseInfo.add(courseInfoLabel);*/
			 coursePanel.setVisible(false);
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
		resourceView.setText(viewCountLabel);
		//resourceViewsCount.setText(viewCountLabel);
	}
	
	
	public void setCourseInfo(){
		
	}
	public void setPublisher(String publisherName,String resourceUrl){
		if(publisherName==null||publisherName.equalsIgnoreCase("")||publisherName.equalsIgnoreCase("null")){
			//lblPublisher.setText(GL0977);
			publisherPanel.setVisible(false);
		}
		else{
			if((!resourceUrl.startsWith("https://docs.google.com"))&&(!resourceUrl.startsWith("http://docs.google.com"))){
				lblPublisher.setText(publisherName);
				publisherPanel.setVisible(true);
				}
				else{
				//	lblPublisher.setText(GL0977);	
					publisherPanel.setVisible(false);
				}
		}
	}
	public void setGrades(String gradesText){
		if(gradesText!=null&&!gradesText.equalsIgnoreCase("")&&!gradesText.equalsIgnoreCase("null")){
				this.gradesText.setText(getGrades(gradesText));
				gradesPanel.setVisible(true);
			}else{
				gradesPanel.setVisible(false);
				//this.gradesText.setText(GL0977);
			}
	}
	public void setOriginalUrl(String assetUri,String folder,String originalUrl,String resourceTypeName){
		this.originalUrlText.clear();
		if(originalUrl!=null&&!originalUrl.equalsIgnoreCase("")&&!originalUrl.equalsIgnoreCase("null")){
			if(resourceTypeName.equalsIgnoreCase("image/png")){
				if(!originalUrl.substring(0, 4).equalsIgnoreCase("http")){
					originalUrl=assetUri+folder+originalUrl;
				}
			}
			String[] urlFormat = originalUrl.split("\\.");
			String urlExtension = urlFormat[urlFormat.length - 1];
			if(urlExtension.equalsIgnoreCase("pdf")){
				if(!originalUrl.substring(0, 4).equalsIgnoreCase("http")){
					originalUrl=assetUri+folder+originalUrl;
				}
			}
			Anchor originalUrlAnchor=new Anchor(originalUrl);
			originalUrlAnchor.setHref(originalUrl);
			originalUrlAnchor.setStyleName("");
			originalUrlAnchor.setTarget("_blank");
			this.originalUrlText.add(originalUrlAnchor);
			this.originalUrlTitle.setVisible(true);
			this.originalUrlText.setVisible(true);
		}else{
			/*HTML html=new HTML(GL0977);
			html.setStyleName("");
			this.originalUrlText.add(html);*/
			this.originalUrlTitle.setVisible(false);
			this.originalUrlText.setVisible(false);
		}
	}
	
	public String getGrades(String grade){
		if (grade != null) {
			grade = grade.replace("null,", "").replace("null ,", "").replace("null", "");
			
		}
		if (StringUtil.hasValidString(grade)) {
			boolean isKindergarten = false;
			boolean isHigherEducation = false;

			if (grade.indexOf("Kindergarten") != -1) {
				isKindergarten = true;
			}

			if (grade.indexOf("Higher Education") != -1) {
				isHigherEducation = true;
			}
			if (grade.indexOf("-") > 0) {
				if (grade.indexOf(",") == -1) {
					grade = generateGradeIfHypen(grade);
					
				}
			}

			List<String> gradeList = Arrays.asList(grade.split(","));
			int gradeListSize = gradeList.size();

			StringBuilder finalGradeStringB = new StringBuilder();
			
			
			List<Integer> gradeListInt = new ArrayList<Integer>();
			//finalGradeStringB.append(gradeListSize > 1 ? "Grades: " : "Grade: ");
			

			
			
			for (String eachGrade1 : gradeList) {
				if (!eachGrade1.equalsIgnoreCase("Kindergarten")
						&& !eachGrade1.equalsIgnoreCase("Higher Education")) {

					eachGrade1 = eachGrade1.replaceAll("th", "")
							.replaceAll("TH", "").replaceAll("st", "")
							.replaceAll("ST", "").replaceAll("nd", "")
							.replaceAll("ND", "").replaceAll("rd", "")
							.replaceAll("RD", "");
					eachGrade1 = eachGrade1.toLowerCase()
							.replaceAll("Grade", "").replaceAll("grade", "");
					eachGrade1 = eachGrade1.toLowerCase().replaceAll("K-", "")
							.replaceAll("k-", "");
					eachGrade1 = eachGrade1.toLowerCase().replaceAll("K", "")
							.replaceAll("k", "");
					try {

						
						 
					//	gradeListInt.clear();
						String grad[] = generateGradeIfHypen(eachGrade1).trim().split(",");
						for (int i = 0; i < grad.length; i++) {
 
							gradeListInt.add(Integer.parseInt(grad[i]));
							
						}

					} catch (Exception e) {
						//gradeListInt.add(0);
						e.printStackTrace();
					}
				}
			}
			gradeListInt = sortList(gradeListInt);
			String finalGrde = formatGrades(gradeListInt);
			if(finalGrde.equalsIgnoreCase(ALL_GRADES)){
				finalGradeStringB.append(ALL_GRADES);
			}else{
			   if(isKindergarten&&isHigherEducation){
				    finalGradeStringB.append(finalGrde.equalsIgnoreCase("")?"Kindergarten":"Kindergarten, ");
					finalGradeStringB.append(finalGrde);
					finalGradeStringB.append(finalGrde.equalsIgnoreCase("")?", Higher Education":", Higher Education");
			   }else if(isKindergarten){
					finalGradeStringB.append(finalGrde.equalsIgnoreCase("")?"Kindergarten":"Kindergarten, ");
					finalGradeStringB.append(finalGrde);
				}else if(isHigherEducation){
					finalGradeStringB.append(finalGrde);
					finalGradeStringB.append(finalGrde.equalsIgnoreCase("")?"Higher Education":", Higher Education");
				}else{
					finalGradeStringB.append(finalGrde);
				}
			}
			

			

			grade = finalGradeStringB.toString();
			
		}
		return grade;
	}
	private String generateGradeIfHypen(String grade) {
		String gradeList[];
	 
		StringBuilder gradeStr = new StringBuilder();
		gradeList = grade.split("-");
		if (gradeList.length >= 2) {
			int start = Integer.parseInt(gradeList[0].trim());
			int end = Integer.parseInt(gradeList[1].trim());
			if (start < end) {
				for (int i = start; i <= end; i++) {
					if (i == end) {
						gradeStr.append(i);
					} else {
						gradeStr.append(i).append(",");
					}
				}
			}
		} else {
			gradeStr.append(Math.round(Double.parseDouble(gradeList[0].trim())));
			/*gradeStr.append(Integer.parseInt("0"));*/
		}
		return gradeStr.toString();
	}	
	public List<Integer> sortList(List<Integer> list) {

		int listSize = list.size();

		for (int i = 0; i < listSize; i++) {

			for (int j = 1; j < listSize - i; j++) {
				if (list.get(j - 1) > list.get(j)) {
					int temp = list.get(j - 1);
					list.set(j - 1, list.get(j));
					list.set(j, temp);
				}
			}
		}

		return list;
	}
	private String formatGrades(List<Integer> list) {
		
    	StringBuffer grade = new StringBuffer();
		try {
			if(list.size()>3){
                int firstGrade=list.get(0);
                int lastGrade=list.get(list.size()-1);
                String displayGrade=firstGrade+"-"+lastGrade;
                if(list.size()>=5){
                	if(firstGrade<=4&&lastGrade>=9){
                		grade.append("ALL GRADES");
                	}
                	else{
                		grade.append(firstGrade);
                		grade.append("-");
                		grade.append(lastGrade);
                	}
                	
                }else{
                        if(displayGrade.equalsIgnoreCase("1-12")){
                                grade.append("ALL GRADES");
                        }else{
                                grade.append(firstGrade);
                                grade.append("-");
                                grade.append(lastGrade);
                        }
                }
        }else{
                for(int i=0;i<list.size();i++){
                	grade.append(list.get(i));
                	if(i!=(list.size()-1)){
						grade.append(", ");
					}
                }
        }
			
			
		} catch (Exception e) {
		}
		return grade.toString();
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
				image.addMouseOverHandler(new MouseOverShowStandardToolTip(licenseDo.getDefinition()));
				//image.addMouseOverHandler(new MouseOverShowStandardToolTip(licenseDo.getName()));
				image.addMouseOutHandler(new MouseOutHideToolTip());
				licenceContainer.setVisible(true);
				rightsLogoContainer.clear();
				rightsLogoContainer.add(image);
			}
			else{
				licenceContainer.setVisible(false);
				rightsLogoContainer.clear();
				//rightsLogoContainer.add(setText(GL0977));
			}
		}else{
			licenceContainer.setVisible(false);
			rightsLogoContainer.clear();
			//rightsLogoContainer.add(setText(GL0977));
		}		
	}	
	
	
	
	public static void renderStandards(FlowPanel standardsContainer, List<Map<String,String>> standardsList) {
		standardsContainer.clear();
		if (standardsList != null) {
			standaInfo.setVisible(false);
			standardsContentContainer.setVisible(true);
			//List<Map<String, String>> standards = searchResultDo.getStandards();
			Iterator<Map<String, String>> iterator = standardsList.iterator();
			int count = 0;
			FlowPanel toolTipwidgets = new FlowPanel();
			while (iterator.hasNext()) {
				Map<String, String> standard = iterator.next();
				String stdCode = standard.get(STANDARD_CODE);
				String stdDec = standard.get(STANDARD_DESCRIPTION);
				if (count > 2) {
					if (count < 18){
						StandardSgItemVc standardItem = new StandardSgItemVc(stdCode, stdDec);
						toolTipwidgets.add(standardItem);
					}
				} else {
					DownToolTipWidgetUc toolTipUc = new DownToolTipWidgetUc(new Label(stdCode), new Label(stdDec), standardsList);
					toolTipUc.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().getstandardMoreInfo());
					standardsContainer.add(toolTipUc);
				}
				count++;
			}
			if (standardsList.size()>18){
				final Label left = new Label("+"+(standardsList.size() - 18));
				toolTipwidgets.add(left);
				standardsContentContainer.setVisible(true);
			}
			if (standardsList.size() > 2) {
				Integer moreStandardsCount = standardsList.size() - 3;
				if (moreStandardsCount >0){
					DownToolTipWidgetUc toolTipUc = new DownToolTipWidgetUc(new Label("+" + moreStandardsCount), toolTipwidgets, standardsList);
					toolTipUc.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().getstandardMoreLink());
					standardsContainer.add(toolTipUc);
					standardsContentContainer.setVisible(true);
				}
			}
			if(standardsList.size()==0)
			{
				//standaInfo.setVisible(true);
				standardsContentContainer.setVisible(false);
			}
		}
		else{
			standardsContentContainer.setVisible(false);
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
		if(resourceType.equalsIgnoreCase("Video")||resourceType.equalsIgnoreCase("Videos")){
			return PlayerBundle.INSTANCE.getPlayerStyle().videoResourceTypeInfo();
		}else if(resourceType.equalsIgnoreCase("Interactive")){
			return PlayerBundle.INSTANCE.getPlayerStyle().interactiveResourceTypeInfo();
		}
		else if(resourceType.equalsIgnoreCase("Website")||resourceType.equalsIgnoreCase("Webpage")){
			return PlayerBundle.INSTANCE.getPlayerStyle().websiteResourceTypeInfo();		
		}
		else if(resourceType.equalsIgnoreCase("Slide")){
			return PlayerBundle.INSTANCE.getPlayerStyle().imageResourceTypeInfo();
		}
		else if(resourceType.equalsIgnoreCase("Textbook")){
			return PlayerBundle.INSTANCE.getPlayerStyle().textResourceTypeInfo();
		}
		else if(resourceType.equalsIgnoreCase("Question")){
			return PlayerBundle.INSTANCE.getPlayerStyle().questionResourceTypeInfo();
		}
		else if(resourceType.equalsIgnoreCase("lesson")){
			return PlayerBundle.INSTANCE.getPlayerStyle().lessonResourceTypeInfo();
			
		}else if(resourceType.equalsIgnoreCase("Handout")){
			return PlayerBundle.INSTANCE.getPlayerStyle().textResourceTypeInfo();
		} else if(resourceType.equalsIgnoreCase("text")){
			return PlayerBundle.INSTANCE.getPlayerStyle().textResourceTypeInfo();
		}
		else if(resourceType.equalsIgnoreCase("image")){
			return PlayerBundle.INSTANCE.getPlayerStyle().imageResourceTypeInfo();
		}
		else if(resourceType.equalsIgnoreCase("audio")){
			return PlayerBundle.INSTANCE.getPlayerStyle().audioResourceTypeInfo();
		}else if(resourceType.equalsIgnoreCase("exam")){
			return PlayerBundle.INSTANCE.getPlayerStyle().websiteResourceTypeInfo();
		}
		else {
			return PlayerBundle.INSTANCE.getPlayerStyle().otherResourceTypeInfo();
		}
	}
	public void setResourceTypeImage(String resourceType){
		if(resourceType!=null){
			resourceType=resourceType.toLowerCase();
			if(resourceType.equalsIgnoreCase("lesson")||resourceType.equalsIgnoreCase("textbook")||resourceType.equalsIgnoreCase("handout"))
			{
				resourceType=resourceType.replaceAll("lesson", "Text").replaceAll("textbook", "Text").replaceAll("handout", "Text");
			}
			if(resourceType.equalsIgnoreCase("slide"))
			{
				resourceType=resourceType.replaceAll("slide","Image");
			}
			if(resourceType.equalsIgnoreCase("exam")||resourceType.equalsIgnoreCase("challenge")||resourceType.equalsIgnoreCase("website"))
			{
				resourceType=resourceType.replaceAll("exam","Webpage").replaceAll("challenge", "Webpage").replaceAll("website", "Webpage");
			}
			lblresourceType.setText(resourceType);
			resourceTypeImage.setStyleName(getResourceTypeImage(resourceType));
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
			toolTip = new ToolTipPopUp(desc, (event.getRelativeElement().getAbsoluteLeft()-83),(event.getRelativeElement().getAbsoluteTop()+22));
			toolTip.setStyleName("");
			toolTip.show();
			toolTip.getElement().getStyle().setZIndex(99999);
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
			//toolTip = new ToolTipPopUp(widget,getWidget().getAbsoluteLeft() + (getWidget().getOffsetWidth() / 2) - (tooltipPopUpUc.getOffsetWidth() / 2), getWidget().getAbsoluteTop() + getWidget().getOffsetHeight());	
			toolTip = new ToolTipPopUp(widget,(event.getRelativeElement().getAbsoluteLeft()-55),(event.getRelativeElement().getAbsoluteTop()+5)); 
			toolTip.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().courseTooltip());
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

	public HTMLEventPanel getHideButton()
	{
		return hideButton;
	}
	
	/**
	 * 
	 * @function onhideBtnClicked 
	 * 
	 * @created_date : 11-Dec-2013
	 * 
	 * @description
	 * 
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("hideButton")
	public void onhideBtnClicked(ClickEvent clickEvent) 
	{
		PlaceRequest collectionRequest = AppClientFactory.getPlaceManager().getCurrentPlaceRequest();
		String collectionId = collectionRequest.getParameter("id", null);
		String collectionItemId = collectionRequest.getParameter("rid", null);
		String chkViewParam = collectionRequest.getParameter("view", null);
		
		Map<String,String> params = new LinkedHashMap<String,String>();
		params.put("id", collectionId);
		params = PreviewPlayerPresenter.setConceptPlayerParameters(params);
		
	if(AppClientFactory.getCurrentPlaceToken().contains(PlaceTokens.RESOURCE_PLAY))
	{
		PlaceRequest request=new PlaceRequest(PlaceTokens.RESOURCE_PLAY).
				with("id", collectionId);
		AppClientFactory.getPlaceManager().revealPlace(false,request,true);
	}
	else if(AppClientFactory.getCurrentPlaceToken().contains(PlaceTokens.COLLECTION_PLAY) && chkViewParam == null && collectionItemId != null)
	{
		PlaceRequest request=new PlaceRequest(PlaceTokens.COLLECTION_PLAY).
				with("id", collectionId).with("rid", collectionItemId);
		AppClientFactory.getPlaceManager().revealPlace(false,request,true);
	}
	else if(AppClientFactory.getCurrentPlaceToken().contains(PlaceTokens.PREVIEW_PLAY) && chkViewParam == null && collectionItemId != null)
	{
		params.put("rid", collectionItemId);
		PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.PREVIEW_PLAY, params);
		AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
	}
	else if(AppClientFactory.getCurrentPlaceToken().contains(PlaceTokens.COLLECTION_PLAY) && chkViewParam == null && collectionItemId == null)
	{
		PlaceRequest request=new PlaceRequest(PlaceTokens.COLLECTION_PLAY).
				with("id", collectionId);
		AppClientFactory.getPlaceManager().revealPlace(false,request,true);
	}
	else if(AppClientFactory.getCurrentPlaceToken().contains(PlaceTokens.PREVIEW_PLAY) && chkViewParam == null && collectionItemId == null)
	{
		PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.PREVIEW_PLAY, params);
		AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
	}
	else if(AppClientFactory.getCurrentPlaceToken().contains(PlaceTokens.COLLECTION_PLAY) && chkViewParam.equalsIgnoreCase("end"))
	{
		PlaceRequest request=new PlaceRequest(PlaceTokens.COLLECTION_PLAY).
				with("id", collectionId).with("view", "end");
		AppClientFactory.getPlaceManager().revealPlace(false,request,true);
	}
	else if(AppClientFactory.getCurrentPlaceToken().contains(PlaceTokens.PREVIEW_PLAY) && chkViewParam.equalsIgnoreCase("end"))
	{
		params.put("view", "end");
		PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.PREVIEW_PLAY, params);
		AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
	}
	}

}
