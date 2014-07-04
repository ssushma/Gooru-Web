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
package org.ednovo.gooru.client.mvp.play.collection.body;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.DataInsightsUrlTokens;
import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerPresenter;
import org.ednovo.gooru.client.mvp.search.SearchResultWrapperCBundle;
import org.ednovo.gooru.client.mvp.search.SearchUiUtil;
import org.ednovo.gooru.client.uc.CollaboratorsUc;
import org.ednovo.gooru.client.uc.DownToolTipWidgetUc;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.client.uc.StandardSgItemVc;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.StandardFo;
import org.ednovo.gooru.shared.model.library.ConceptDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;
import org.ednovo.gooru.shared.util.UAgentInfo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.BodyElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.IFrameElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window.Navigator;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class CollectionPlayerMetadataView extends BaseViewWithHandlers<CollectionPlayerMetadataUiHandlers> implements IsCollectionPlayerMetadataView,MessageProperties{

	
	@UiField
	static FlowPanel studyMainContianer;
	@UiField
	FlowPanel metadataContainer,dataInsightsPanel;
	@UiField
	FlowPanel standardsContainer;
	@UiField
	FlowPanel teamContainer;
	@UiField
	FlowPanel messageContainer;
	@UiField
	FlowPanel frameContainer;
	@UiField
	FlowPanel courseTitle;
	@UiField Label userNameLabel,viewsCountLabel,lblClassInfo,classTitleValue,lblclassTitle,lblTeacher,lbldueDate,lblDirections,lblDirectionsDesc;
	@UiField Label lblAuthor, lblCourse, lblStandards,teacherNameLabel,dueDate,insightsHeaderText,insightsContentText,lbllanguageObjectiveText,lbllanguageObjective;//collectionSummaryLbl,emptyMsgDescOne,emptyMsgDescTwo
	@UiField Image profileThumbnailImage;
	@UiField HTMLPanel teacherPanel,classInfoPanel,authorPanel,courseSection,standardSection,teacherContainer,viewSection,dueDateSection,directionSection,teacherProfileContainer,languageObjectiveContainer;
	@UiField Anchor previewFlagButton,seeMoreAnchor;
	@UiField CollectionPlayerStyleBundle playerStyle;
	//@UiField Frame insightsFrame;
//	@UiField Button collectionSummaryPrintBtn;
	private String languageObjectiveValue;
	private CollectionDo collectionDo=null;
	
	public static final String STANDARD_CODE = "code";
	
	public static final String STANDARD_DESCRIPTION = "description";
	private Anchor usernameAnchor;
	private static CollectionPlayerMetadataViewUiBinder uiBinder = GWT.create(CollectionPlayerMetadataViewUiBinder.class);

	interface CollectionPlayerMetadataViewUiBinder extends UiBinder<Widget, CollectionPlayerMetadataView> {
	}
	
	@Inject
	public CollectionPlayerMetadataView(){
		setWidget(uiBinder.createAndBindUi(this));
		setLabelAndIds();
		teacherContainer.setVisible(false);
		messageContainer.setVisible(false);
		PlayerBundle.INSTANCE.getPlayerStyle().ensureInjected();
		SearchResultWrapperCBundle.INSTANCE.css().ensureInjected();
		
		  Boolean isIpad = !!Navigator.getUserAgent().matches("(.*)iPad(.*)");
		  Boolean isAndriod = !!Navigator.getUserAgent().matches("(.*)Android(.*)");
		  Boolean isWinDskp = !!Navigator.getUserAgent().matches("(.*)NT(.*)");
		  
		  UAgentInfo detector = new UAgentInfo(Navigator.getUserAgent());
		  
		  if(isIpad && !StringUtil.IPAD_MESSAGE_Close_Click)
		  {
			  studyMainContianer.getElement().setAttribute("style", "margin-top:0px;");
			 
		  }
		  else if(isAndriod && !StringUtil.IPAD_MESSAGE_Close_Click)
		  {
			  studyMainContianer.getElement().setAttribute("style", "margin-top:0px;");
		  }
		  else
		  {
			  studyMainContianer.getElement().setAttribute("style", "margin-top:50px;");
			  
		  }
	}
	
	@Override
	public void setCollectionMetadata(CollectionDo collectionDo) {
		this.collectionDo = collectionDo;
		teamContainer.clear();
		//getUiHandlers().getFlagedReport(collectionDo.getGooruOid());
		if (collectionDo.getMeta() !=null && collectionDo.getMeta().getCollaboratorCount()>0){
			 CollaboratorsUc collaboratorsUc=new CollaboratorsUc(collectionDo);
			 teamContainer.add(collaboratorsUc);
			setUserName(collectionDo.getUser().getUsernameDisplay() +" " + GL_GRR_AND);
		}else{
			setUserName(collectionDo.getUser().getUsernameDisplay());
		}
		setViewCount(collectionDo.getViews());
		setUserProfileImage(collectionDo.getUser().getGooruUId());
		renderCourseInfo(collectionDo.getMetaInfo().getCourse());
		renderStandards(standardsContainer,getStandardsMap(this.collectionDo.getMetaInfo().getStandards()));
		renderLanguageObjective(collectionDo.getLanguageObjective());
		
	}
	

	public List<Map<String,String>> getStandardsMap(List<StandardFo> standareds){
		List<Map<String,String>> standardsList=new ArrayList<Map<String,String>>();
		for(int i=0;i<standareds.size();i++){
			Map<String, String> standardMap=new HashMap<String, String>();
			standardMap.put(STANDARD_CODE, standareds.get(i).getCode());
			standardMap.put(STANDARD_DESCRIPTION, standareds.get(i).getDescription());
			standardsList.add(standardMap);
		}
		return standardsList;
	}
	
	@Override
    public void setInSlot(Object slot, Widget content) {
		if(slot==CollectionPlayerMetadataPresenter.METADATA_PRESENTER_SLOT){
			metadataContainer.clear();
			if(content!=null){
				metadataContainer.add(content);
			}
		}
	}
	

	public void setLabelAndIds() {
//		collectionSummaryLbl.setVisible(false);
		lblAuthor.setText(GL0573);
		lblAuthor.getElement().setId("lblAuthor");
		lblAuthor.getElement().setAttribute("alt",GL0573);
		lblAuthor.getElement().setAttribute("title",GL0573);
		  
		lblCourse.setText(GL0574);
		lblCourse.getElement().setId("lblCourse");
		lblCourse.getElement().setAttribute("alt",GL0574);
		lblCourse.getElement().setAttribute("title",GL0574);
		
		lblStandards.setText(GL0575);
		lblStandards.getElement().setId("lblStandards");
		lblStandards.getElement().setAttribute("alt",GL0575);
		lblStandards.getElement().setAttribute("title",GL0575);
		
		previewFlagButton.setText(GL0556);
		previewFlagButton.getElement().setId("lnkPreviewFlagButton");
		previewFlagButton.getElement().setAttribute("alt",GL0556);
		previewFlagButton.getElement().setAttribute("title",GL0556);
		
//		collectionSummaryLbl.setText(GL1544);
//		emptyMsgDescOne.setText(GL1545);
//		emptyMsgDescTwo.setText(GL1546);
		insightsHeaderText.setText(GL1626);
		insightsHeaderText.getElement().setId("lblInsightsHeaderText");
		insightsHeaderText.getElement().setAttribute("alt",GL1626);
		insightsHeaderText.getElement().setAttribute("title",GL1626);
		
		insightsContentText.setText(GL1627);
		insightsContentText.getElement().setId("lblInsightsContentText");
		insightsContentText.getElement().setAttribute("alt",GL1627);
		insightsContentText.getElement().setAttribute("title",GL1627);
		
		previewFlagButton.removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().previewCoverFlagImageOrange());
		previewFlagButton.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().playerPreviewCoverFlagImage());
		lbllanguageObjectiveText.setText(GL1721);
		lbllanguageObjectiveText.getElement().setId("lblLanguageObjectiveText");
		lbllanguageObjectiveText.getElement().setAttribute("alt",GL1721);
		lbllanguageObjectiveText.getElement().setAttribute("title",GL1721);
		
		studyMainContianer.getElement().setId("fpnlStudyMainContianer");
		metadataContainer.getElement().setId("fpnlMetadataContainer");
		teacherContainer.getElement().setId("pnlTeacherContainer");
		classInfoPanel.getElement().setId("pnlClassInfoPanel");
		lblClassInfo.getElement().setId("lblClassInfo");
		lblclassTitle.getElement().setId("lblClassTitle");
		classTitleValue.getElement().setId("lblClassTitleValue");
		teacherPanel.getElement().setId("pnlTeacherPanel");
		lblTeacher.getElement().setId("lblTeacher");
		teacherProfileContainer.getElement().setId("pnlTeacherProfileContainer");
		teacherNameLabel.getElement().setId("lblTeacherNameLabel");
		dueDateSection.getElement().setId("pnlDueDateSection");
		lbldueDate.getElement().setId("lbldueDate");
		dueDate.getElement().setId("lbldueDateLabel");
		directionSection.getElement().setId("pnlDirectionSection");
		lblDirections.getElement().setId("lblDirections");
		lblDirectionsDesc.getElement().setId("lblDirectionsDesc");
		authorPanel.getElement().setId("pnlAuthorPanel");
		profileThumbnailImage.getElement().setId("imgProfileThumbnailImage");
		userNameLabel.getElement().setId("lblUserNameLabel");
		teamContainer.getElement().setId("fpnlTeamContainer");
		courseSection.getElement().setId("pnlCourseSection");
		courseTitle.getElement().setId("fpnlCourseTitle");
		standardSection.getElement().setId("pnlStandardSection");
		standardsContainer.getElement().setId("fpnlStandardsContainer");
		viewSection.getElement().setId("pnlViewSection");
		viewsCountLabel.getElement().setId("lblViewsCountLabel");
		languageObjectiveContainer.getElement().setId("pnlLanguageObjectiveContainer");
		lbllanguageObjective.getElement().setId("lbllanguageObjective");
		seeMoreAnchor.getElement().setId("lnkSeeMoreAnchor");
		dataInsightsPanel.getElement().setId("pnlDataInsightsPanel");
		frameContainer.getElement().setId("fpnlFrameContainer");
		messageContainer.getElement().setId("fpnlMessageContainer");
	}
	
	/*public void setUserName(String userName){
		userNameLabel.setText(userName);
		usernameAnchor = new Anchor();
		//userNameLabel.setText(userName);
		if(StringUtil.isPartnerUser(collectionDo.getUser().getUsername())){
			usernameAnchor.setHref("#"+collectionDo.getUser().getUsernameDisplay());
		}
	else{
		String token= "#"+PlaceTokens.PROFILE_PAGE+"&id="+collectionDo.getUser().getGooruUId()+"&user="+collectionDo.getUser().getUsername();
		usernameAnchor.setHref(token);
	}
		usernameAnchor.setText(userName);
		usernameAnchor.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().setUserText());
		usernameAnchor.setTarget("_blank");
		userNameLabel.setText("");
		userNameLabel.getElement().appendChild(usernameAnchor.getElement());
	}*/
	public void setUserName(String userName){
		
		//userNameLabel.setText(userName);
		if(collectionDo.getUser().getCustomFields()!=null){
			if(collectionDo.getUser().getCustomFields().get(0).getOptionalValue()!=null){
				String getUserProfileStatus	=collectionDo.getUser().getCustomFields().get(0).getOptionalValue();
				if(getUserProfileStatus.equalsIgnoreCase("true")){
					usernameAnchor = new Anchor();
					if(StringUtil.isPartnerUser(collectionDo.getUser().getUsername())){
						usernameAnchor.setHref("#"+collectionDo.getUser().getUsernameDisplay());
					}
				else{
					String token= "#"+PlaceTokens.PROFILE_PAGE+"&id="+collectionDo.getUser().getGooruUId()+"&user="+collectionDo.getUser().getUsername();
					usernameAnchor.setHref(token);
				}
					usernameAnchor.setText(userName);
					usernameAnchor.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().setUserText());
					usernameAnchor.setTarget("_blank");
					userNameLabel.setText("");
					userNameLabel.getElement().appendChild(usernameAnchor.getElement());
				}
				else{
					userNameLabel.setText(userName);
					userNameLabel.getElement().setAttribute("alt",userName);
					userNameLabel.getElement().setAttribute("title",userName);
				}
			}
			
		}
		
	}
	public void setUserProfileImage(String profileUserId){
		profileThumbnailImage.setUrl(AppClientFactory.loggedInUser.getSettings().getProfileImageUrl()+profileUserId+".png?p="+Math.random());
	}
	@UiHandler("profileThumbnailImage")
	public void setDefaultProfileImage(ErrorEvent event){
		profileThumbnailImage.setUrl("images/settings/setting-user-image.png");
	}
	public void setViewCount(String viewCount){
		String viewsText=Integer.parseInt(viewCount)==1?viewCount+" "+GL1428:viewCount+" "+GL0934;
		viewsCountLabel.setText(viewsText);
		viewsCountLabel.getElement().setAttribute("alt",viewsText);
		viewsCountLabel.getElement().setAttribute("title",viewsText);
	}
	public void renderCourseInfo(List<String> courseInfo){
		courseTitle.clear();
		if(courseInfo!=null&&courseInfo.size()>0){
			courseSection.setVisible(true);
			//setCourseTitle(courseInfo.get(0));
			SearchUiUtil.renderMetaData(courseTitle, courseInfo, 0);
			Label dummyLabel=new Label();
			dummyLabel.setStyleName(playerStyle.clearBoth());
			courseTitle.add(dummyLabel);
		}else{
			courseSection.setVisible(false);
		}
	}
	public void setCourseTitle(String title){
		//courseTitle.setText(title);
	}
	public void setLikesCount(int likesCount){
		
	}
	public void resetMetadataFields(){
		userNameLabel.setText("");
		viewsCountLabel.setText("");
		getFlagButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().previewCoverFlagImageOrange());
		getFlagButton().setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().playerPreviewCoverFlagImage());
		this.collectionDo=null;
	}

	@Override
	public void setUserProfileName(String gooruUid) {
		Anchor anchor = new Anchor();
		String userName = userNameLabel.getText();
		if(StringUtil.isPartnerUser(collectionDo.getUser().getUsername())){
			anchor.setHref("#"+collectionDo.getUser().getUsernameDisplay());
		}else{
			String token= "#"+PlaceTokens.PROFILE_PAGE+"&id="+gooruUid+"&user="+collectionDo.getUser().getUsername();
			anchor.setHref(token);
		}
		anchor.setText(userName);
		anchor.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().setUserText());
		anchor.setTarget("_blank");
		userNameLabel.setText("");
		userNameLabel.getElement().appendChild(anchor.getElement());
	}
	public void renderStandards(FlowPanel standardsContainer, List<Map<String,String>> standardsList) {
		standardsContainer.clear();
		if (standardsList != null&&standardsList.size()>0) {
			standardSection.setVisible(true);
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
			}
			if (standardsList.size() > 2) {
				Integer moreStandardsCount = standardsList.size() - 3;
				if (moreStandardsCount > 0){
					DownToolTipWidgetUc toolTipUc = new DownToolTipWidgetUc(new Label("+" + moreStandardsCount), toolTipwidgets, standardsList);
					toolTipUc.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().getstandardMoreLink());
					standardsContainer.add(toolTipUc);
				}
			}
		}else{
			standardSection.setVisible(false);
		}
	}
	
	public void displayAuthorDetails(boolean isDisplayDetails) {
		authorPanel.setVisible(isDisplayDetails);
	}
	
	@UiHandler("previewFlagButton")
	public void clickOnpreviewFlagButton(ClickEvent event) {
		String view=AppClientFactory.getPlaceManager().getRequestParameter("view", null);
		Map<String,String> params = new LinkedHashMap<String,String>();
		params.put("id", collectionDo.getGooruOid());
		params = PreviewPlayerPresenter.setConceptPlayerParameters(params);
		if(view!=null&&view.equalsIgnoreCase("end")){
			params.put("view", "end");
			params.put("tab", "flag");
			PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(AppClientFactory.getCurrentPlaceToken(), params);
			AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
		}else{
			params.put("tab", "flag");
			PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(AppClientFactory.getCurrentPlaceToken(), params);
			AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
		}
		
	}

	public Anchor getFlagButton() {
		return previewFlagButton;
	}

	@Override
	public void setRelatedConceptsContent(ArrayList<ConceptDo> conceptDoList,
			String coursePage, String subject, String lessonId,
			String libraryName) {
		
	}

	@Override
	public void isConceptsContainerVisible(boolean isVisible) {
		
	}

	@Override
	public void setTeacherInfo(ClasspageItemDo classpageItemDo) {
		hideCollectionDetails(true);
		teacherContainer.setVisible(true);
		classTitleValue.setText(classpageItemDo.getTitle());
		classTitleValue.getElement().setAttribute("alt",classpageItemDo.getTitle());
		classTitleValue.getElement().setAttribute("title",classpageItemDo.getTitle());
		
		lblclassTitle.setText(GL1578);
		lblclassTitle.getElement().setAttribute("alt",GL1578);
		lblclassTitle.getElement().setAttribute("title",GL1578);
		
		lblClassInfo.setText(GL1579);
		lblClassInfo.getElement().setAttribute("alt",GL1579);
		lblClassInfo.getElement().setAttribute("title",GL1579);
		
		lblTeacher.setText(GL1580);
		lblTeacher.getElement().setAttribute("alt",GL1580);
		lblTeacher.getElement().setAttribute("title",GL1580);
		
		lbldueDate.setText(GL1581);
		lbldueDate.getElement().setAttribute("alt",GL1581);
		lbldueDate.getElement().setAttribute("title",GL1581);
		
		lblDirections.setText(GL1582);
		lblDirections.getElement().setAttribute("alt",GL1582);
		lblDirections.getElement().setAttribute("title",GL1582);
		
		setDueDateText(classpageItemDo.getPlannedEndDate());
		setDirectionText(classpageItemDo.getDirection());
		teacherNameLabel.setText(classpageItemDo.getUserNameDispaly());
		teacherNameLabel.getElement().setAttribute("alt",classpageItemDo.getUserNameDispaly());
		teacherNameLabel.getElement().setAttribute("title",classpageItemDo.getUserNameDispaly());
		
		teacherProfileContainer.clear();
		//teacherProfileThumbnailImage.setUrl(classpageItemDo.getProfileImageUrl()+"?p="+Math.random()); 
		teacherProfileContainer.add(new TeacherImage(classpageItemDo.getProfileImageUrl()+"?p="+Math.random()));
	}
	
	public void setDueDateText(String text){
		if(text!=null&&!text.trim().equals("")){
			dueDate.setText(text);
			dueDate.getElement().setAttribute("alt",text);
			dueDate.getElement().setAttribute("title",text);
			dueDateSection.setVisible(true);
		}else{
			dueDateSection.setVisible(false);
		}
	}
	public void setDirectionText(String text){
		if(text!=null&&!text.trim().equals("")){
			lblDirectionsDesc.setText(text);
			lblDirectionsDesc.getElement().setAttribute("alt",text);
			lblDirectionsDesc.getElement().setAttribute("title",text);
			directionSection.setVisible(true);
		}else{
			directionSection.setVisible(false);
		}
	}
	
//	@UiHandler("teacherProfileThumbnailImage")
//	public void setDefaultTeacherProfileImage(ErrorEvent event){
//		teacherProfileThumbnailImage.setUrl("images/settings/setting-user-image.png");
//	}
	
	public void hideCollectionDetails(boolean hide){
		authorPanel.setVisible(!hide);
		courseSection.setVisible(!hide);
		standardSection.setVisible(!hide);
		viewSection.setVisible(!hide);
	}
	

	public class TeacherImage extends Composite{
		private Image image=null;
		private String teacherImageUrl="";
		public TeacherImage(String imageUrl){
			initWidget(image=new Image());
			this.teacherImageUrl=imageUrl;
			image.setStyleName(playerStyle.userImage());
			image.addErrorHandler(new TeacherErrorEvent());
		}
		public void onLoad(){
			image.setUrl(teacherImageUrl);
		}
		public class TeacherErrorEvent implements ErrorHandler{
			@Override
			public void onError(ErrorEvent event) {
				image.setUrl("images/settings/setting-user-image.png");
			}
		}
	}
	
	
	
	
//	@UiHandler("insightsFrame")
//	public void ifrmaeContentLoaded(LoadEvent laodEvent){
//		loginPopupTimer.schedule(500);
//	}
	
	public void setDataInsightsUrl(){
		String page=AppClientFactory.getPlaceManager().getRequestParameter("page", null);
		if(AppClientFactory.isAnonymous()){
			frameContainer.clear();
			frameContainer.setVisible(false);
			messageContainer.setVisible(true);
		}else if(page!=null&&page.equals("teach")){
			frameContainer.clear();
			frameContainer.setVisible(false);
			messageContainer.setVisible(false);
		}else{
			frameContainer.clear();
			frameContainer.setVisible(true);
			messageContainer.setVisible(false);
			frameContainer.add(new DataInsightsIframe(StringUtil.generateMessage(AppClientFactory.getLoggedInUser().getSettings().getAnalyticsEndPoint()+DataInsightsUrlTokens.STUDYPLAYER_SUMMARY_DATA,
					collectionDo.getGooruOid(),AppClientFactory.getGooruUid(),"",AppClientFactory.getLoginSessionToken())));
		}
	}
	
	public void setClasspageInsightsUrl(String classpageId, String sessionId){
		if(sessionId==null) {
			sessionId = "";
		}
		String page=AppClientFactory.getPlaceManager().getRequestParameter("page", null);
		if(AppClientFactory.isAnonymous()){
			frameContainer.clear();
			frameContainer.setVisible(false);
			messageContainer.setVisible(true);
		}else if(page!=null&&page.equals("teach")){
			frameContainer.clear();
			frameContainer.setVisible(false);
			messageContainer.setVisible(false);
		}else{
			frameContainer.clear();
			frameContainer.setVisible(true);
			messageContainer.setVisible(false);
			frameContainer.add(new DataInsightsIframe(StringUtil.generateMessage(AppClientFactory.getLoggedInUser().getSettings().getAnalyticsEndPoint()+DataInsightsUrlTokens.PLAYER_CLASS_PREVIOUS_DATA,
					classpageId,collectionDo.getGooruOid(),AppClientFactory.getGooruUid(),sessionId,AppClientFactory.getLoginSessionToken())));
		}
	}
	
	public void setDataInsightsSummaryUrl(String sessionId){
		String page=AppClientFactory.getPlaceManager().getRequestParameter("page", null);
		if(AppClientFactory.isAnonymous()){
			frameContainer.clear();
			frameContainer.setVisible(false);
			messageContainer.setVisible(true);
		}else if(page!=null&&page.equals("teach")){
			frameContainer.clear();
			frameContainer.setVisible(false);
			messageContainer.setVisible(false);
		}else{
			frameContainer.clear();
			frameContainer.setVisible(true);
			messageContainer.setVisible(false);
			sessionId=sessionId!=null?sessionId:"";
			frameContainer.add(new DataInsightsIframe(StringUtil.generateMessage(AppClientFactory.getLoggedInUser().getSettings().getAnalyticsEndPoint()+DataInsightsUrlTokens.STUDYPLAYER_SUMMARY_DATA,
					collectionDo.getGooruOid(),AppClientFactory.getGooruUid(),sessionId,AppClientFactory.getLoginSessionToken())));
		}
	}
	
	public class DataInsightsIframe extends Composite{
		private Frame dataInsightsFrame=null;
		private String insightsUrl="";
		public DataInsightsIframe(String insightsUrl){
			initWidget(dataInsightsFrame=new Frame());
			this.insightsUrl=insightsUrl;
			dataInsightsFrame.setStyleName(playerStyle.insightsFrameContent());
			dataInsightsFrame.getElement().setAttribute("id", "student-dashboard");
		}
		public void onLoad(){
			dataInsightsFrame.setUrl(insightsUrl);
		}
	}
	
	public void clearDashBoardIframe(){
		//insightsFrame.setUrl("");
	}
	
	public void renderLanguageObjective(String languageObjective)
	{	
	lbllanguageObjective.getElement().setAttribute("style", "word-wrap: break-word;");
	if(languageObjective!=null)
		{
			languageObjectiveValue=languageObjective;
			languageObjectiveContainer.setVisible(true);
			//lbllanguageObjectiveAll.setVisible(false);
			seeMoreAnchor.getElement().setAttribute("style", "float:right;");
			if(languageObjective.length()>=200){
				seeMoreAnchor.setText(GL1728);	
				seeMoreAnchor.getElement().setAttribute("alt",GL1728);
				seeMoreAnchor.getElement().setAttribute("title",GL1728);
				seeMoreAnchor.setVisible(true);
				lbllanguageObjective.setText(languageObjective.substring(0,200));
				lbllanguageObjective.getElement().setAttribute("alt",languageObjective.substring(0,200));
				lbllanguageObjective.getElement().setAttribute("title",languageObjective.substring(0,200));
				//lbllanguageObjectiveAll.setText(languageObjective.substring(80,languageObjective.length()));
			}
			else
			{
				seeMoreAnchor.setVisible(false);
				lbllanguageObjective.setText(languageObjective);
				lbllanguageObjective.getElement().setAttribute("alt",languageObjective);
				lbllanguageObjective.getElement().setAttribute("title",languageObjective);
			}
			
		}
		else
		{
			languageObjectiveContainer.setVisible(false);
			
		}
	}
	@UiHandler("seeMoreAnchor")
	public void clickSeeAll(ClickEvent event)
	{
		//lbllanguageObjectiveAll.setVisible(true);
		seeMoreAnchor.setVisible(false);
		lbllanguageObjective.setText("");
		lbllanguageObjective.setText(languageObjectiveValue);
	}
	
	public static void onClosingAndriodorIpaddiv()
	{
		studyMainContianer.getElement().setAttribute("style", "margin-top:50px;");
	}
}
