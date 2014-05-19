/**
 * 
 */
package org.ednovo.gooru.client.mvp.search;

import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author ibc
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
	copyRightType,copyRightLbl,hostType,hostLbl,gooruCourseLbl,accessibilityAPILbl,controlType,controlLbl,
	acessHazardlLbl,acessHazardType,mediaFeatureLbl,accessModelLbl,accesibilityLbl,generalLbl,
	thumbnailText,licenceCodeLbl,licenceCodeType,educationallLbl,resourceInfoLbl,dateCreatedLbl,
	createdDateInfo,authorLbl,authorName,contributorName,gooruSubjectLbl,gooruSubjectInfo,keywordsTitle,
	momentsoflearningLbl;
	
	@UiField HTMLPanel rightsLogoContainer,courseInfo,originalUrlText,publisherPanel,coursePanel,gradesPanel,
	contributorPanel,mobileFriendlyPanel,DataTypePanel,interactivityTypePanel,eduAllignPanel,eduUsePanel,eduRolePanel,ageRangePanel,dKnowledgePanel,
	readingLevelPanel,hasAdaptationPanel,languagePanel,countryCodePanel,isAdaptationPanel,copyRightPanel,hostPanel,gooruCoursePanel,
	accessibilityAPIPanel,accessibilityPanel,controlPanel,accessHazardPanel,mediaFeaturePanel,accessModePanel,thumbnailPanel,licenceCodePanel,dateCreatedPanel,
	authorPanel,gooruSubjectPanel,eduUseType,keyWordsPanel,keywordsInfo,readingLevelType,gooruCourseInfo,accessModeType,mediaFeatureType,accessibilityAPIType,dKnowledgeType,
	momentsoflearningPanel,momentsoflearningType,thumbnailurlValue;
	
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
		
		publisherText.setText(GL0566);
		courseText.setText(GL0616);
		legalText.setText(GL0730+ ""+GL_SPL_SEMICOLON);
		standardsText.setText(GL0619);
//		resourceInfoText.setText(GL0621);
		gradeTitle.setText(GL0325+ ""+GL_SPL_SEMICOLON);
		originalUrlTitle.setText(GL0976+ ""+GL_SPL_SEMICOLON);

		generalLbl.setText(GL1708);
		resourceInfoLbl.setText(GL1716);
		educationallLbl.setText(GL1720);
		
	}

}
