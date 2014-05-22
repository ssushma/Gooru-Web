/**
 * 
 */
package org.ednovo.gooru.client.mvp.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.addTagesPopup.AddTagesPopupView;
import org.ednovo.gooru.client.uc.DownToolTipWidgetUc;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.client.uc.StandardSgItemVc;
import org.ednovo.gooru.client.uc.ToolTipPopUp;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.LicenseDo;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;
import org.ednovo.gooru.shared.util.CollResInfo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author mitraJ
 *
 */
public class SearchInfoWidget extends Composite implements MessageProperties{

	private static SearchInfoWidgetUiBinder uiBinder = GWT
			.create(SearchInfoWidgetUiBinder.class);

	interface SearchInfoWidgetUiBinder extends
	UiBinder<Widget, SearchInfoWidget> {
	}

	@UiField Label lblPublisher,publisherText,courseText,legalText,
	standardsText,gradeTitle,gradesText,originalUrlTitle,contributorTitle,mbFriendlyLbl,
	mbFriendlyText,dataTypeLbl,dataTypeFormat,interactiveLbl,interactiveType,eduAllignLbl,eduAllignType,eduUseLbl,
	eduRoleLbl,eduRoleType,ageRangeLbl,ageRangeType,dKnowledgeLbl,readingLevelLbl,
	hasAdaptationType,hasAdaptationLbl,languageLbl,languageType,countryCodeLbl,countryCodeType,isAdaptationLbl,isAdaptationType,
	copyRightType,copyRightLbl,hostType,hostLbl,accessibilityAPILbl,controlType,controlLbl,
	acessHazardlLbl,acessHazardType,mediaFeatureLbl,accessModelLbl,accesibilityLbl,generalLbl,
	thumbnailText,licenceCodeLbl,licenceCodeType,educationallLbl,resourceInfoLbl,dateCreatedLbl,
	createdDateInfo,authorLbl,authorName,contributorName,schLevelLbl,schLevelInfo,keywordsTitle,
	momentsoflearningLbl,resourceTypeImage;

	@UiField HTMLPanel rightsLogoContainer,courseInfo,originalUrlText,publisherPanel,coursePanel,gradesPanel,
	contributorPanel,mobileFriendlyPanel,DataTypePanel,interactivityTypePanel,eduAllignPanel,eduUsePanel,eduRolePanel,ageRangePanel,dKnowledgePanel,
	readingLevelPanel,hasAdaptationPanel,languagePanel,countryCodePanel,isAdaptationPanel,copyRightPanel,hostPanel,
	accessibilityAPIPanel,accessibilityPanel,controlPanel,accessHazardPanel,mediaFeaturePanel,accessModePanel,thumbnailPanel,licenceCodePanel,dateCreatedPanel,
	authorPanel,schLevelPanel,eduUseType,keyWordsPanel,keywordsInfo,readingLevelType,accessModeType,mediaFeatureType,accessibilityAPIType,dKnowledgeType,
	momentsoflearningPanel,momentsoflearningType,thumbnailurlValue;

	@UiField FlowPanel licenceContainer,standardsInfoConatiner;

	@UiField static  HTMLPanel standardsContentContainer;
	@UiField static Label standaInfo;

	@UiField Button addTagsBtn;

	AddTagesPopupView popup;

	ToolTipPopUp toolTip ; 

	private static final String ALL_GRADES = "ALL GRADES";
	public static final String STANDARD_CODE = "code";
	public static final String STANDARD_DESCRIPTION = "description";

	private ResourceSearchResultDo searchResultDo;
	private CollectionItemDo collectionItemDo;

	@UiField HTML lblcollectionName;

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
	public SearchInfoWidget() {
		initWidget(uiBinder.createAndBindUi(this));
		PlayerBundle.INSTANCE.getPlayerStyle().ensureInjected();
		setResourceInfoData();


	}

	private void setResourceInfoData() {
		publisherText.setText(GL0566);
		courseText.setText(GL0616);
		legalText.setText(GL0730+ ""+GL_SPL_SEMICOLON);
		standardsText.setText(GL0619);
		//		resourceInfoText.setText(GL0621);
		gradeTitle.setText(GL0325+ ""+GL_SPL_SEMICOLON);
		originalUrlTitle.setText(GL0976+ ""+GL_SPL_SEMICOLON);
		generalLbl.setText(GL1708);
		hostLbl.setText(GL1700+ ""+GL_SPL_SEMICOLON);
		legalText.setText("License:");
		
		//Educational static data
		educationallLbl.setText(GL1720);
		eduAllignLbl.setText(GL1690+GL_SPL_SEMICOLON);
		eduUseLbl.setText(GL1664+GL_SPL_SEMICOLON);
		eduRoleLbl.setText("Educational Role:");
		interactiveLbl.setText(GL1689+GL_SPL_SEMICOLON);
		ageRangeLbl.setText(GL1692+GL_SPL_SEMICOLON);
		momentsoflearningLbl.setText(GL1678+GL_SPL_SEMICOLON);
		readingLevelLbl.setText(GL1694+GL_SPL_SEMICOLON);
		schLevelLbl.setText(GL1694+GL_SPL_SEMICOLON);
		
		//Resource Info Static data
		resourceInfoLbl.setText(GL1716);
		dateCreatedLbl.setText(GL1717+GL_SPL_SEMICOLON);
		countryCodeLbl.setText(GL1697+GL_SPL_SEMICOLON);
		languageLbl.setText(GL1696+GL_SPL_SEMICOLON);
		dataTypeLbl.setText(GL1688+GL_SPL_SEMICOLON);
		authorLbl.setText(GL0573+GL_SPL_SEMICOLON);
		copyRightLbl.setText(GL1699+GL_SPL_SEMICOLON);
		keywordsTitle.setText("Keywords"+GL_SPL_SEMICOLON);
		
		//Accessibility Static data
		accesibilityLbl.setText("Accessibility");
		mbFriendlyLbl.setText(GL1687+GL_SPL_SEMICOLON);
		accessModelLbl.setText(GL1707+GL_SPL_SEMICOLON);
		mediaFeatureLbl.setText(GL1706+GL_SPL_SEMICOLON);
		controlLbl.setText(GL1704+GL_SPL_SEMICOLON);
		acessHazardlLbl.setText(GL1705+GL_SPL_SEMICOLON);
		mbFriendlyLbl.setText(GL1687+GL_SPL_SEMICOLON);
		
	}

	/**
	 * Assign {@link ResourceSearchResultDo} instance
	 * 
	 * @param searchResultDo
	 *            instance of {@link ResourceSearchResultDo}
	 *//*
	public void setData(ResourceSearchResultDo searchResultDo) {
		this.searchResultDo = searchResultDo;
	}*/

	public void setData(ResourceSearchResultDo searchResultsDo) {
		this.searchResultDo=searchResultsDo;
		if(searchResultsDo.getResourceFormat()!=null){
			setResourceTypeImage(searchResultsDo.getResourceFormat().getValue());
		}
		if(searchResultsDo.getResourceTitle()!=null){
			lblcollectionName.setHTML(removeHtmlTags(searchResultsDo.getResourceTitle()));

		}
		if(searchResultsDo.getGrade()!=null)
		{
			gradesText.setText(searchResultsDo.getGrade());
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
			//lblresourceType.setText(resourceType);
			resourceTypeImage.setStyleName(getResourceTypeImage(resourceType));
		}
	}

	private String removeHtmlTags(String html){
		html = html.replaceAll("</p>", " ").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "");
		return html;
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

	/**
	 * @param collectionItemDo
	 *            instance of {@link collectionItemDo}
	 * 
	 */

	public void setData(CollectionItemDo collectionItemDo) {
		this.collectionItemDo =collectionItemDo;
	}

	public void setData(){
		System.out.println("gooruoid::"+searchResultDo.getGooruOid());
		AppClientFactory.getInjector().getPlayerAppService().getResourceCollectionItem(null, searchResultDo.getGooruOid(), null, new SimpleAsyncCallback<CollectionItemDo>() {

			@Override
			public void onSuccess(CollectionItemDo collectionItemDo) {
				// TODO Auto-generated method stub
				setGrades(collectionItemDo.getResource().getGrade());
				setResourceAttribution(collectionItemDo.getResource().getResourceSource()!=null?collectionItemDo.getResource().getResourceSource().getAttribution():
					null,collectionItemDo.getResource().getTaxonomySet());
				renderStandards(standardsInfoConatiner,collectionItemDo.getStandards());
				setOriginalUrl(collectionItemDo.getResource().getAssetURI(),collectionItemDo.getResource().getFolder(),
						collectionItemDo.getResource().getUrl(),collectionItemDo.getResource().getResourceType().getName());
				setResourceLicenceLogo(collectionItemDo.getResource().getAssetURI(), collectionItemDo.getResource().getLicense());
				setPublisher(collectionItemDo.getResource().getResourceSource()!=null?collectionItemDo.getResource().getResourceSource().getAttribution():"",collectionItemDo.getResource().getUrl());
				if(collectionItemDo.getResource().getThumbnails()!=null){
					setThumbnailUrl(collectionItemDo.getResource().getThumbnails().getUrl());
				}
				if(collectionItemDo.getResource().getCreatedOn()!=null){
					setCreatedDate(collectionItemDo.getResource().getCreatedOn());
				}
                setGeneralResourceInfo(collectionItemDo);
				setEducationInfoDetails(collectionItemDo);
			}
		});
	}

	protected void setGeneralResourceInfo(CollectionItemDo CollectiongenealInfo) {
		// TODO Auto-generated method stub
		hostPanel.setVisible(true);
		if(CollectiongenealInfo.getResource()!=null && CollectiongenealInfo.getResource().getHost()!=null){
			hostType.setText(CollectiongenealInfo.getResource().getHost());
		}else{
			hostPanel.setVisible(false);
		}
	}

	/**
	 * To set Resource License
	 * @param assetUrl 
	 * @param licenseDo instance of {@link LicenseDo}
	 */
	public void setResourceLicenceLogo(String assetUrl,LicenseDo licenseDo){
		if(licenseDo!=null){
			if(licenseDo.getIcon()!=null&&!licenseDo.getIcon().trim().equals("")){
				Image image=new Image();
				image.setUrl(assetUrl+licenseDo.getIcon());
				//image.addMouseOverHandler(new MouseOverShowStandardToolTip(licenseDo.getDefinition()));
				image.addMouseOverHandler(new MouseOverShowStandardToolTip(licenseDo.getCode()+"         "+licenseDo.getName()));
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

	public class MouseOutHideToolTip implements MouseOutHandler
	{
		@Override
		public void onMouseOut(MouseOutEvent event) {
			toolTip.hide();
		}

	}
	/**
	 * To set Resource Grades
	 * @param gradesText  {@value String}
	 */
	public void setGrades(String gradesText){

		if(gradesText!=null&&!gradesText.equalsIgnoreCase("")&&!gradesText.equalsIgnoreCase("null")){
			this.gradesText.setText(getGrades(gradesText));
			gradesPanel.setVisible(true);
		}else{
			gradesPanel.setVisible(false);
			//this.gradesText.setText(GL0977);
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

	/**
	 * 
	 * @param standardsContainer
	 * @param standardsList
	 */

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
	/**
	 * To set the Resource Original Url
	 * @param assetUri
	 * @param folder
	 * @param originalUrl
	 * @param resourceTypeName
	 */
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
	/**
	 * To set the Resource publisherName
	 * @param publisherName
	 * @param resourceUrl
	 */
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
	/**
	 * 
	 * @param url
	 */
	private void setThumbnailUrl(String url) {
		thumbnailurlValue.clear();
		if(url==null||url.equalsIgnoreCase("")||url.equalsIgnoreCase("null")){
			thumbnailPanel.setVisible(false);
		}else{
			thumbnailPanel.setVisible(false);
		}
	}
	/**
	 * 
	 * @param code
	 *//*
	private void setLicenCode(String code) {

		if(code==null||code.equalsIgnoreCase("")||code.equalsIgnoreCase("null") || code.equalsIgnoreCase("Not Available")){
			licenceCodePanel.setVisible(false);
		}else{
			licenceCodePanel.setVisible(true);
			licenceCodeType.setText(code);
			licenceCodeLbl.setText(GL1719+GL_SPL_SEMICOLON);
		}		
	}*/
	/**
	 * 
	 * @param createdOn
	 */
	private void setCreatedDate(Date createdOn) {

		String dateString = DateTimeFormat.getFormat("MM/dd/yyyy").format(createdOn);
		dateCreatedPanel.setVisible(true);
		createdDateInfo.setText(dateString);
		dateCreatedLbl.setText(GL1717+GL_SPL_SEMICOLON);
	}
	/**
	 * 
	 * @param attribution
	 * @param taxonomoyList
	 */
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

	private void seteducationaluseDetails(List<String> eduUsedetails) {
		// TODO Auto-generated method stub
		eduUseType.clear();
		if(eduUsedetails == null || eduUsedetails.size() == 0 || eduUsedetails.contains(null) || eduUsedetails.contains("") ){
			eduUsePanel.setVisible(false);
		}else{
			educationallLbl.setText(GL1720);
			if(eduUsedetails.size()>0){
				final Label eduUseLabel=new Label(eduUsedetails.get(0));
				eduUseLabel.getElement().setAttribute("style", "float: left;");
				eduUseType.add(eduUseLabel);
				eduUsePanel.setVisible(true);
				educationallLbl.setText(GL1720);
				eduUseLbl.setText(GL1664+GL_SPL_SEMICOLON);
				educationallLbl.setVisible(true);
			}
			if(eduUsedetails.size()>2){
				final Label eduUseLabel=new Label("+"+(eduUsedetails.size()-2)); 
				eduUseLabel.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().resourceCourseNum());
				eduUseType.add(eduUseLabel);
				Widget eduusewidget = getCommonwidget(eduUsedetails);
				eduUseLabel.addMouseOverHandler(new MouseOverShowToolTip(eduusewidget));
				eduUseLabel.addMouseOutHandler(new MouseOutHideToolTip());
				eduUsePanel.setVisible(true);
				educationallLbl.setText(GL1720);
				eduUseLbl.setText(GL1664+GL_SPL_SEMICOLON);
				educationallLbl.setVisible(true);
			}
		}
	}

	/*private void setDepthofknowledgeDetails(List<String> depthOfKnowledgedetails) {
		// TODO Auto-generated method stub
		dKnowledgeType.clear();
		if(depthOfKnowledgedetails == null || depthOfKnowledgedetails.size() == 0 || depthOfKnowledgedetails.contains(null) || depthOfKnowledgedetails.contains("") ){
			dKnowledgePanel.setVisible(false);
		}else{
			dKnowledgeLbl.setText(GL1693+GL_SPL_SEMICOLON);
			if(depthOfKnowledgedetails.size()>0){
				if(depthOfKnowledgedetails.size()==1){
					final Label deapthknowledgeLabel=new Label(depthOfKnowledgedetails.get(0));
					deapthknowledgeLabel.getElement().setAttribute("style", "float: left;");
					dKnowledgeType.add(deapthknowledgeLabel);
					dKnowledgePanel.setVisible(true);
				} if(depthOfKnowledgedetails.size()==2){
					final Label deapthknowledgeLabel=new Label(depthOfKnowledgedetails.get(0)+","+depthOfKnowledgedetails.get(1));
					deapthknowledgeLabel.getElement().setAttribute("style", "float: left;");
					dKnowledgeType.add(deapthknowledgeLabel);
					dKnowledgePanel.setVisible(true);
				}

			}
			if(depthOfKnowledgedetails.size()>2){
				final Label deapthknowledgeLabel=new Label("+"+(depthOfKnowledgedetails.size()-2)); 
				deapthknowledgeLabel.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().resourceCourseNum());
				final Label deapthknowledgeLabelNew=new Label(depthOfKnowledgedetails.get(0)+","+depthOfKnowledgedetails.get(1));
				deapthknowledgeLabelNew.getElement().setAttribute("style", "float:left;");
				dKnowledgeType.add(deapthknowledgeLabelNew);
				dKnowledgeType.add(deapthknowledgeLabel);
				Widget depthofwidget = getCommonwidget(depthOfKnowledgedetails);
				deapthknowledgeLabel.addMouseOverHandler(new MouseOverShowToolTip(depthofwidget));
				deapthknowledgeLabel.addMouseOutHandler(new MouseOutHideToolTip());
				dKnowledgePanel.setVisible(true);
			}
		}

	}*/

	/*private void setmonentoflearningDetails(List<String> momentoflearningdetails) {
		momentsoflearningType.clear();
		if(momentoflearningdetails == null || momentoflearningdetails.size() == 0 || momentoflearningdetails.contains(null) || momentoflearningdetails.contains("") ){
			momentsoflearningPanel.setVisible(false);
		}else{
			momentsoflearningLbl.setText("Moments Of Learning:");
			if(momentoflearningdetails.size()>0){
				final Label momentsofLabel=new Label(momentoflearningdetails.get(0));
				momentsofLabel.getElement().setAttribute("style", "float: left;");
				momentsoflearningType.add(momentsofLabel);
				momentsoflearningPanel.setVisible(true);
			}
			if(momentoflearningdetails.size()>2){
				final Label momentsofLabel=new Label("+"+(momentoflearningdetails.size()-2)); 
				momentsofLabel.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().resourceCourseNum());
				momentsoflearningType.add(momentsofLabel);
				Widget momentswidget = getCommonwidget(momentoflearningdetails);
				momentsofLabel.addMouseOverHandler(new MouseOverShowToolTip(momentswidget));
				momentsofLabel.addMouseOutHandler(new MouseOutHideToolTip());
				momentsoflearningPanel.setVisible(true);
			}
		}

	}
*/


	private Widget getCommonwidget(List<String> commonList) {

		FlowPanel toolTipwidgets = new FlowPanel();
		for(int i=2;i<commonList.size();i++){
			Label commonLabel = new Label(commonList.get(i));
			toolTipwidgets.add(commonLabel);
		}
		return toolTipwidgets;
	}

	/**
	 * To set Resource Educational details
	 * @param collectionItemDo
	 */

	private void setEducationInfoDetails(
			CollectionItemDo collectionItemDo) {
		// TODO Auto-generated method stub
		List<String> eduUsedetails = new ArrayList<String>();

		if(collectionItemDo.getResource().getEducationalUse()!=null){
			if(collectionItemDo.getResource().getEducationalUse().size()>0){
				for(int i=0;i<collectionItemDo.getResource().getEducationalUse().size();i++){
					if(collectionItemDo.getResource().getEducationalUse().get(i).isSelected())
					{
						eduUsedetails.add(collectionItemDo.getResource().getEducationalUse().get(i).getValue());
					}
				}
				seteducationaluseDetails(eduUsedetails);
			}else{
				eduUsePanel.setVisible(false);
			}
		}
		List<String> depthofknowledgedetails = new ArrayList<String>();
		List<String> momentoflearningdetails = new ArrayList<String>();

		if(collectionItemDo.getResource().getResourceFormat().getValue().equalsIgnoreCase("question")){
			depthofknowledgedetails = new ArrayList<String>();
			if(collectionItemDo.getResource().getDepthOfKnowledges()!=null){
				if(collectionItemDo.getResource().getDepthOfKnowledges().size()>0){
					for(int i=0;i<collectionItemDo.getResource().getDepthOfKnowledges().size();i++){
						if(collectionItemDo.getResource().getDepthOfKnowledges().get(i).isSelected())
						{
							depthofknowledgedetails.add(collectionItemDo.getResource().getDepthOfKnowledges().get(i).getValue());
						}
					}
					CollResInfo.setDepthofknowledgeDetails(depthofknowledgedetails, dKnowledgeType, dKnowledgeLbl, dKnowledgePanel);
					//dKnowledgePanel.setVisible(true);
				}else{
					dKnowledgePanel.setVisible(false);
				}
			}else{
				dKnowledgePanel.setVisible(false);
			}
			momentsoflearningPanel.setVisible(false);
		}
		else{
			momentoflearningdetails = new ArrayList<String>();
			if(collectionItemDo.getResource().getMomentsOfLearning()!=null){
				if(collectionItemDo.getResource().getMomentsOfLearning().size()>0){
					for(int i=0;i<collectionItemDo.getResource().getMomentsOfLearning().size();i++){
						if(collectionItemDo.getResource().getMomentsOfLearning().get(i).isSelected())
						{
							momentoflearningdetails.add(collectionItemDo.getResource().getMomentsOfLearning().get(i).getValue());
						}
					}
					CollResInfo.setDepthofknowledgeDetails(momentoflearningdetails,momentsoflearningType,momentsoflearningLbl,momentsoflearningPanel);
					//momentsoflearningPanel.setVisible(true);
				}else{
					momentsoflearningPanel.setVisible(false);	
				}
			}else{
				momentsoflearningPanel.setVisible(false);
			}
			dKnowledgePanel.setVisible(false);
		}

		if(collectionItemDo.getResource().getGrade()==null
				&& collectionItemDo.getResource().getUrl()==null 
				&& collectionItemDo.getResource().getThumbnailUrl()==null
				&& collectionItemDo.getResource().getTaxonomySet()==null
				&& collectionItemDo.getResource().getLicense() ==null && collectionItemDo.getStandards()==null){
			generalLbl.setVisible(false);
		}else{
			if(collectionItemDo.getResource().getGrade()!=null && !collectionItemDo.getResource().getGrade().equalsIgnoreCase("")&&!collectionItemDo.getResource().getGrade().equalsIgnoreCase("null")){
				generalLbl.setVisible(true);
			}
			else if(collectionItemDo.getResource().getUrl()!=null&&!collectionItemDo.getResource().getUrl().equalsIgnoreCase("")&&!collectionItemDo.getResource().getUrl().equalsIgnoreCase("null")){
				generalLbl.setVisible(true);
			}else if(collectionItemDo.getResource().getTaxonomySet()!=null && collectionItemDo.getResource().getTaxonomySet().size()>0){
				List<String> coursesList=new ArrayList<String>();
				Set<CodeDo>	taxonomoyList = collectionItemDo.getResource().getTaxonomySet();
				if(taxonomoyList!=null){
					Iterator<CodeDo> taxonomyIterator=taxonomoyList.iterator();
					while (taxonomyIterator.hasNext()) {
						CodeDo codeDo=taxonomyIterator.next();
						if(codeDo.getDepth()==2){
							coursesList.add(codeDo.getLabel());
						}
					}
				}
				if(coursesList.size()>0){
					generalLbl.setVisible(true);	
				}
			}else if(collectionItemDo.getStandards()!=null && collectionItemDo.getStandards().size()>0){
				List<Map<String,String>> standardsList1	=collectionItemDo.getStandards();
				Iterator<Map<String, String>> iterator = standardsList1.iterator();
				int count = 0;
				while (iterator.hasNext()) {
					Map<String, String> standard = iterator.next();
					String stdCode = standard.get(STANDARD_CODE);
					String stdDec = standard.get(STANDARD_DESCRIPTION);
					count++;
				}
				if(standardsList1.size()>0){
					generalLbl.setVisible(true);	
				}
			}else if(collectionItemDo.getResource().getLicense()!=null && collectionItemDo.getResource().getLicense().getIcon()!=null &&!collectionItemDo.getResource().getLicense().getIcon().trim().equals("") ){
				generalLbl.setVisible(true);	
			}
			else if(collectionItemDo.getResource().getResourceSource()!=null && collectionItemDo.getResource().getResourceSource().getAttribution()!=null && !collectionItemDo.getResource().getResourceSource().getAttribution().equalsIgnoreCase("") && !collectionItemDo.getResource().getResourceSource().getAttribution().equalsIgnoreCase("null")){
				generalLbl.setVisible(true);	
			}
			else{
				generalLbl.setVisible(false);
			}
		}
		if(collectionItemDo.getResource().getResourceFormat().getValue().equalsIgnoreCase("question")){
			if(depthofknowledgedetails!=null && eduUsedetails!=null){
				if(depthofknowledgedetails.size()>0 || eduUsedetails.size()>0){
					educationallLbl.setVisible(true);
					if(eduUsedetails.size()>0){
						eduUsePanel.setVisible(true);
					}else if(depthofknowledgedetails.size()>0){
						dKnowledgePanel.setVisible(true);
					}
					//eduUsePanel.setVisible(true);
				}else if(depthofknowledgedetails.size()==0 && eduUsedetails.size()==0){
					educationallLbl.setVisible(false);
					eduUsePanel.setVisible(false);
					dKnowledgePanel.setVisible(false);
				}
			}
			else{
				if(depthofknowledgedetails ==null || eduUsedetails==null){
					if(depthofknowledgedetails!=null && depthofknowledgedetails.size()>0){
						educationallLbl.setVisible(true);
						dKnowledgePanel.setVisible(true);
					}else if(eduUsedetails!=null && eduUsedetails.size()>0){
						educationallLbl.setVisible(true);
						eduUsePanel.setVisible(true);
					}
				}

			}
		}else{
			if(momentoflearningdetails!=null && eduUsedetails!=null){
				if(momentoflearningdetails.size()>0 || eduUsedetails.size()>0){
					educationallLbl.setVisible(true);
					if(momentoflearningdetails.size()>0){
						momentsoflearningPanel.setVisible(true);
					}else if(eduUsedetails.size()>0){
						eduUsePanel.setVisible(true);
					}
				}else if(momentoflearningdetails.size()==0 && eduUsedetails.size()==0){
					educationallLbl.setVisible(false);
					eduUsePanel.setVisible(false);
					momentsoflearningPanel.setVisible(false);
				}
			}
			else{
				if(momentoflearningdetails==null || eduUsedetails==null){
					if(momentoflearningdetails!=null && momentoflearningdetails.size()>0){
						educationallLbl.setVisible(true);
						momentsoflearningPanel.setVisible(true);
					}else if(eduUsedetails!=null && eduUsedetails.size()>0){
						educationallLbl.setVisible(true);
						eduUsePanel.setVisible(true);
					}
				}
			}
		}
	}

	@UiHandler("addTagsBtn")
	public void onAddTagsBtnClicked(ClickEvent clickEvent) 
	{
		System.out.println("resourceIdforaddingtags::"+searchResultDo.getGooruOid());
		popup=new AddTagesPopupView(searchResultDo.getGooruOid()) {

			@Override
			public void closePoup() {
				Window.enableScrolling(true);
				this.hide();
			}
		};
		popup.show();
		popup.setPopupPosition(popup.getAbsoluteLeft(),Window.getScrollTop()+10);
	}


}
