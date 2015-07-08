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
package org.ednovo.gooru.client.mvp.assessments.play.collection.end;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.client.service.ResourceServiceAsync;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.analytics.CollectionSummaryMetaDataDo;
import org.ednovo.gooru.application.shared.model.analytics.CollectionSummaryUsersDataDo;
import org.ednovo.gooru.application.shared.model.analytics.MetaDataDo;
import org.ednovo.gooru.application.shared.model.analytics.PrintUserDataDO;
import org.ednovo.gooru.application.shared.model.analytics.UserDataDo;
import org.ednovo.gooru.application.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.application.shared.model.content.CollectionDo;
import org.ednovo.gooru.application.shared.model.content.ResourceDo;
import org.ednovo.gooru.application.shared.model.content.StandardFo;
import org.ednovo.gooru.application.shared.model.folder.FolderWhatsNextCollectionDo;
import org.ednovo.gooru.application.shared.model.library.ConceptDo;
import org.ednovo.gooru.client.SimpleRunAsyncCallback;
import org.ednovo.gooru.client.htmltags.SectionTag;
import org.ednovo.gooru.client.mvp.analytics.collectionSummaryIndividual.EmailPopup;
import org.ednovo.gooru.client.mvp.analytics.collectionSummaryIndividual.SummaryAnswerStatusPopup;
import org.ednovo.gooru.client.mvp.analytics.collectionSummaryIndividual.CollectionSummaryIndividualView.SummaryPopupClick;
import org.ednovo.gooru.client.mvp.analytics.util.AnalyticsReactionWidget;
import org.ednovo.gooru.client.mvp.analytics.util.AnalyticsUtil;
import org.ednovo.gooru.client.mvp.analytics.util.Print;
import org.ednovo.gooru.client.mvp.assessments.play.collection.body.AssessmentsPlayerMetadataPresenter;
import org.ednovo.gooru.client.mvp.assessments.play.collection.body.AssessmentsPlayerStyleBundle;
import org.ednovo.gooru.client.mvp.assessments.play.collection.preview.AssessmentsPreviewPlayerPresenter;
import org.ednovo.gooru.client.mvp.assessments.play.resource.body.AssessmentsResourcePlayerMetadataView;
import org.ednovo.gooru.client.mvp.gsearch.addResourcePopup.SearchAddResourceToCollectionPresenter;
import org.ednovo.gooru.client.mvp.home.LoginPopupUc;
import org.ednovo.gooru.client.mvp.home.library.assign.AssignPopupVc;
import org.ednovo.gooru.client.mvp.search.SearchResultWrapperCBundle;
import org.ednovo.gooru.client.uc.BrowserAgent;
import org.ednovo.gooru.client.uc.H2Panel;
import org.ednovo.gooru.client.uc.H3Panel;
import org.ednovo.gooru.client.uc.H4Panel;
import org.ednovo.gooru.client.uc.PPanel;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.client.uc.tooltip.GlobalToolTip;
import org.ednovo.gooru.client.uc.tooltip.ToolTip;
import org.ednovo.gooru.client.util.PlayerDataLogEvents;
import org.ednovo.gooru.shared.util.ClientConstants;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.ajaxloader.client.Properties;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Clear;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.Navigator;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.visualizations.Table;
import com.google.gwt.visualization.client.visualizations.Table.Options;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class AssessmentsEndView extends BaseViewWithHandlers<AssessmentsEndUiHandlers> implements IsAssessmentsEndView,ClientConstants{
	@UiField
	static FlowPanel studyMainContianer,PrintPnl;
	@UiField
	FlowPanel metadataContainer;
	@UiField
	FlowPanel messageContainer,thumbnailContainer,spendTimeContainer,scoreContainer,nextCollectionContainer,scoreMainContainer;

	@UiField SectionTag dataInsightsPanel;

	@UiField
	FlowPanel frameContainer,progressRadial,questionsTable;


	@UiField Label replayCollection,whatNextCollectionTitle,
	resourceCount,questionCount,avgReactionImage,insightsHeaderText,insightsContentText,headingText;
	@UiField HTMLPanel pnlSummary, pnlCollectionLastAccessed,sessionspnl,collectionSummaryText,collectionMetaDataPnl,loadingImageLabel;
	@UiField AssessmentsPlayerStyleBundle playerStyle;
	@UiField Image collectionThumbnail,nextCollectionThumbnail;
	@UiField Button customizeCollectionBtn,shareCollectionBtn;

	@UiField ListBox sessionsDropDown;
	@UiField Image collectionImage,sessionsTooltip;
	@UiField InlineLabel collectionResourcesCount,collectionLastAccessed,correctStatus;
	@UiField H3Panel collectionTitle;
	@UiField H4Panel scoreTitle;
	@UiField H2Panel score;
	@UiField PPanel lastModifiedTime,goal;
	@UiField HTMLPanel printWidget;
	@UiField Button printButton,downloadButton;
	@UiField Frame downloadFile;

	HTMLPanel printScoredData=new HTMLPanel("");
	EmailPopup emailPopup=null;

	private ToolTip toolTip;

	Map<String, Long> sessionData=new HashMap<String, Long>();
	PrintUserDataDO printData=new PrintUserDataDO();
	String urlDomain = "";
	String style="";

	@Inject
	private ResourceServiceAsync resourceService;

	/*@UiField Frame insightsFrame;*/
	private String languageObjectiveValue;

	private CollectionDo collectionDo=null;

	private CollectionDo nextCollectionDo = null;

	FolderWhatsNextCollectionDo folderCollectionWhatsNext = null;

	public static final String STANDARD_CODE = "code";

	public static final String STANDARD_DESCRIPTION = "description";

	private static final String COLLECTION_COMMENTS="COLLECTION_COMMENTS";

	private static final String INITIAL_COMMENT_LIMIT = "10";

	private static final String CREATE = "CREATE";

	private static final String DELETE = "DELETE";

	private static final String EDIT = "EDIT";

	private static final String PAGINATION = "page";


	private static final String PRIMARY_STYLE = "primary";

	private static final String SECONDARY_STYLE = "secondary";

	private static final String DISABLED_STYLE = "disabled";

	private static final int INCREMENT_BY_ONE = 1;

	private static final int DECREMENT_BY_ONE = -1;

	private static final String EDUCATOR_DEFAULT_IMG = "../images/settings/setting-user-image.png";
	private Anchor usernameAnchor;

	private int totalCommentCount = 0;

	private int totalHitCount = 0;

	private int paginationCount = 0;

	private boolean isHavingBadWords;

	private boolean isCustomizePopup = false;

	private boolean isSharePopup = false;

	private HandlerRegistration whatsNextHandler;

	SearchAddResourceToCollectionPresenter remixPresenterWidget = AppClientFactory.getInjector().getRemixPresenterWidget();


	private PopupPanel toolTipPopupPanel=new PopupPanel();

	private static AssessmentsPlayerMetadataViewUiBinder uiBinder = GWT.create(AssessmentsPlayerMetadataViewUiBinder.class);

	interface AssessmentsPlayerMetadataViewUiBinder extends UiBinder<Widget, AssessmentsEndView> {
	}

	private MessageProperties i18n = GWT.create(MessageProperties.class);

	@Inject
	public AssessmentsEndView(){
		setWidget(uiBinder.createAndBindUi(this));
		setLabelAndIds();
		pnlCollectionLastAccessed.setVisible(false);
		urlDomain=Window.Location.getProtocol()+"//"+Window.Location.getHost();
		style="<link rel='styleSheet' type='text/css' href='"+urlDomain+"/css/googleVisualization.css'><link href='"+urlDomain+"/css/printAnalytics.css' rel='stylesheet' type='text/css'><link href='"+urlDomain+"/css/assessment.css' rel='stylesheet' type='text/css'>";
		downloadFile.setVisible(false);
		//teacherContainer.setVisible(false);
		messageContainer.setVisible(false);
		PlayerBundle.INSTANCE.getPlayerStyle().ensureInjected();
		SearchResultWrapperCBundle.INSTANCE.css().ensureInjected();

		customizeCollectionBtn.setText(i18n.GL2037());
		customizeCollectionBtn.getElement().setId("btnCustomizeCollectionEndBtn");
		customizeCollectionBtn.getElement().setAttribute("alt",i18n.GL2037());
		customizeCollectionBtn.getElement().setAttribute("title",i18n.GL2037());

		shareCollectionBtn.setText(i18n.GL0536());
		shareCollectionBtn.getElement().setId("btnShareCollectionEndBtn");
		shareCollectionBtn.getElement().setAttribute("alt",i18n.GL0536());
		shareCollectionBtn.getElement().setAttribute("title",i18n.GL0536());


		sessionsTooltip.addMouseOverHandler(new QuestionMarkHover());
		sessionsTooltip.addMouseOutHandler(new QuestionMarkHoverOut());
		customizeCollectionBtn.addMouseOverHandler(new OncustomizeCollectionBtnMouseOver());
		customizeCollectionBtn.addMouseOutHandler(new OncustomizeCollectionBtnMouseOut());
		customizeCollectionBtn.addBlurHandler(new customizeCollectionBtnOnBlur());
		shareCollectionBtn.addMouseOverHandler(new OnshareCollectionBtnMouseOver());
		shareCollectionBtn.addMouseOutHandler(new OnshareCollectionBtnMouseOut());
		Boolean isIpad = !!Navigator.getUserAgent().matches("(.*)iPad(.*)");
		Boolean isAndriod = !!Navigator.getUserAgent().matches("(.*)Android(.*)");
		if(isIpad && !StringUtil.IPAD_MESSAGE_Close_Click)
		{
			studyMainContianer.getElement().setAttribute("style", "margin-top:0px;");

		}
		else if(isAndriod && !StringUtil.IPAD_MESSAGE_Close_Click)
		{
			studyMainContianer.getElement().setAttribute("style", "margin-top:0px;");
		}
		sessionsDropDown.addChangeHandler(new StudentsSessionsChangeHandler());

		StringUtil.loadVisualizationLibraries();
	}
	public class StudentsSessionsChangeHandler implements ChangeHandler{
		@Override
		public void onChange(ChangeEvent event) {
			int selectedIndex=sessionsDropDown.getSelectedIndex();
			String classpageId=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
			if(classpageId==null){
				classpageId="";
			}
			setSessionStartTime(selectedIndex);
			getUiHandlers().setCollectionSummaryData(collectionDo.getGooruOid(), classpageId,AppClientFactory.getLoggedInUser().getGooruUId(),sessionsDropDown.getValue(selectedIndex),printData);
		}
	}

	public class OncustomizeCollectionBtnMouseOver implements MouseOverHandler{

		@Override
		public void onMouseOver(MouseOverEvent event) {
			toolTipPopupPanel.clear();
			toolTipPopupPanel.setWidget(new GlobalToolTip(i18n.GL0677()));
			toolTipPopupPanel.setStyleName("");
			toolTipPopupPanel.setPopupPosition(customizeCollectionBtn.getElement().getAbsoluteLeft()+18, customizeCollectionBtn.getElement().getAbsoluteTop()+10);
			toolTipPopupPanel.getElement().getStyle().setZIndex(999999);
			toolTipPopupPanel.show();
		}

	}

	public class OncustomizeCollectionBtnMouseOut implements MouseOutHandler{

		@Override
		public void onMouseOut(MouseOutEvent event) {
			toolTipPopupPanel.hide();
		}



	}
	public class customizeCollectionBtnOnBlur implements BlurHandler
	{

		@Override
		public void onBlur(BlurEvent event) {
			toolTipPopupPanel.hide();

		}

	}
	public class OnshareCollectionBtnMouseOver implements MouseOverHandler{

		@Override
		public void onMouseOver(MouseOverEvent event) {
			toolTipPopupPanel.clear();
			toolTipPopupPanel.setWidget(new GlobalToolTip(i18n.GL0678()));
			toolTipPopupPanel.setStyleName("");
			toolTipPopupPanel.setPopupPosition(shareCollectionBtn.getElement().getAbsoluteLeft()+5, shareCollectionBtn.getElement().getAbsoluteTop()+10);
			toolTipPopupPanel.getElement().getStyle().setZIndex(999999);
			toolTipPopupPanel.show();
		}

	}

	public class OnshareCollectionBtnMouseOut implements MouseOutHandler{

		@Override
		public void onMouseOut(MouseOutEvent event) {
			toolTipPopupPanel.hide();
		}



	}

	public class QuestionMarkHover implements MouseOverHandler{

		@Override
		public void onMouseOver(MouseOverEvent event) {
			toolTip = new ToolTip(i18n.GL3113());
			toolTip.getLblLink().setVisible(false);
			toolTip.getElement().getStyle().setBackgroundColor("transparent");
			toolTip.getElement().getStyle().setPosition(Position.ABSOLUTE);
			toolTip.setPopupPosition(sessionsTooltip.getAbsoluteLeft()-72, sessionsTooltip.getAbsoluteTop()+25);
			toolTip.getElement().getStyle().setZIndex(99999);
			toolTip.show();
		}
	}

	public class QuestionMarkHoverOut implements MouseOutHandler{

		@Override
		public void onMouseOut(MouseOutEvent event) {
			toolTip.hide();
		}
	}

	@Override
	public void setCollectionMetadata(CollectionDo collectionDo) {
		this.collectionDo = collectionDo;
		if(!"assessment".equals(collectionDo.getCollectionType())){
			scoreMainContainer.setVisible(false);
		}else{
			scoreMainContainer.setVisible(true);
		}
		setCollectionImage(collectionDo.getThumbnails() != null ?  collectionDo.getThumbnails().getUrl() : "");

		String message=(collectionDo.getCollectionType()!=null&&collectionDo.getCollectionType().equals("assessment"))?i18n.GL3044():i18n.GL2083();

		headingText.setText(message);
		customizeCollectionBtn.getElement().setAttribute("collectionId", collectionDo.getGooruOid());
		shareCollectionBtn.getElement().setAttribute("collectionId", collectionDo.getGooruOid());
		setReplyLink();
		setViewCount(collectionDo.getViews());
		getAverageReaction();

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
		if(slot==AssessmentsPlayerMetadataPresenter.METADATA_PRESENTER_SLOT){
			metadataContainer.clear();
			if(content!=null){
				metadataContainer.add(content);
			}
		}else if(slot==AssessmentsEndPresenter.COLLECTION_REPORTS_SLOT){
			pnlSummary.clear();
			if(content!=null){
				pnlSummary.add(content);
			}
		}
	}


	public void setLabelAndIds() {

		insightsHeaderText.setText(i18n.GL1626());
		insightsHeaderText.getElement().setId("lblInsightsHeaderText");
		insightsHeaderText.getElement().setAttribute("alt",i18n.GL1626());
		insightsHeaderText.getElement().setAttribute("title",i18n.GL1626());

		insightsContentText.setText(i18n.GL1627());
		insightsContentText.getElement().setId("lblInsightsContentText");
		insightsContentText.getElement().setAttribute("alt",i18n.GL1627());
		insightsContentText.getElement().setAttribute("title",i18n.GL1627());

		studyMainContianer.getElement().setId("fpnlStudyMainContianer");
		metadataContainer.getElement().setId("fpnlMetadataContainer");

		dataInsightsPanel.getElement().setId("pnlDataInsightsPanel");
		messageContainer.getElement().setId("fpnlMessageContainer");
		progressRadial.getElement().setId("fpnlprogressRadial");

		replayCollection.setText(i18n.GL0632());
		replayCollection.getElement().setId("lblReplayCollection");
		replayCollection.getElement().setAttribute("alt",i18n.GL0632());
		replayCollection.getElement().setAttribute("title",i18n.GL0632());


		collectionSummaryText.getElement().setInnerText(i18n.GL4006());
		StringUtil.setAttributes(collectionSummaryText.getElement(), "pnlCollectionSummaryText", i18n.GL4006(), i18n.GL4006());

		collectionThumbnail.getElement().setId("imgCollectionThumbnail");
		thumbnailContainer.getElement().setId("fpnlThumbnailContainer");

		printButton.getElement().setId("printButton");
		downloadButton.getElement().setId("downloadButton");
		String html = "<span class='printIcon'></span>";
		printButton.setHTML(html);
		printButton.setText(i18n.GL4007());
		downloadButton.setText(i18n.GL4008());
		
		studyMainContianer.setVisible(false);
	}

	@UiHandler("collectionThumbnail")
	public void thumbnailErrorImage(ErrorEvent event){
		String collectionType=StringUtil.isEmpty(collectionDo.getCollectionType())?null:collectionDo.getCollectionType();
		StringUtil.setDefaultImages(collectionType, collectionThumbnail, "high");
	}

	@UiHandler("nextCollectionThumbnail")
	public void nextThumbnailErrorImage(ErrorEvent event){
		String collectionType=StringUtil.isEmpty(folderCollectionWhatsNext.getCollectionType())?null:folderCollectionWhatsNext.getCollectionType();
		StringUtil.setDefaultImages(collectionType, nextCollectionThumbnail, "toc");
		//nextCollectionThumbnail.setUrl("images/default-collection-image-160x120.png");
	}


	public void setReplyLink(){
		Anchor resourceAnchor=new Anchor();
		resourceAnchor.setHref(getReplayLink());
		resourceAnchor.setStyleName("");
		HTMLPanel collectionHTMLPanel = new HTMLPanel("");
		resourceAnchor.addClickHandler(new ReplayCollectionEvent());
		collectionHTMLPanel.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().collectionreplayContainer());
		Label collectionReplayButton=new Label(i18n.GL0632());
		collectionReplayButton.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().collectionreplayText());
		collectionHTMLPanel.add(collectionReplayButton);
		resourceAnchor.getElement().appendChild(collectionHTMLPanel.getElement());
		thumbnailContainer.clear();
		thumbnailContainer.add(resourceAnchor);
	}

	private class ReplayCollectionEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			getUiHandlers().resetCollectionActivityEventId();
		}
	}
	public String getReplayLink(){
		String collectionId=AppClientFactory.getPlaceManager().getRequestParameter("id", null);
		String viewToken=AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
		String resourceLink="#"+viewToken+"&id="+collectionId;
		resourceLink += AssessmentsPreviewPlayerPresenter.setConceptPlayerParameters();
		return resourceLink;
	}
	public void setCollectionImage(String thumbnailUrl){
		String collectionType=StringUtil.isEmpty(collectionDo.getCollectionType())?null:collectionDo.getCollectionType();
		StringUtil.setDefaultImages(collectionType, collectionThumbnail, "high");
		collectionThumbnail.setUrl(thumbnailUrl);
	}
	/**
	 *
	 * @function oncustomizeCollectionBtnClicked
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
	@UiHandler("customizeCollectionBtn")
	public void oncustomizeCollectionBtnClicked(ClickEvent clickEvent) {

		final String collectionId = clickEvent.getRelativeElement().getAttribute("collectionId");

		if(!isCustomizePopup){
			Window.scrollTo(0, 0);
			if(AppClientFactory.isAnonymous()){
				LoginPopupUc loginPopupUc=new LoginPopupUc() {
					@Override
					public	void onLoginSuccess(){
						Window.enableScrolling(false);
						remixPresenterWidget.getUserShelfCollectionsData(collectionId, "collection");
						remixPresenterWidget.getView().getAppPopUp().show();
						isCustomizePopup = false;
						remixPresenterWidget.getView().getAppPopUp().center();
						remixPresenterWidget.getView().getAppPopUp().setGlassEnabled(true);
						remixPresenterWidget.getView().getAppPopUp().setGlassStyleName("setGlassPanelZIndex");
					}
				};
				loginPopupUc.show();
				loginPopupUc.setGlassEnabled(true);
				loginPopupUc.setGlassStyleName("setGlassPanelZIndex");
			}else{
				remixPresenterWidget.getUserShelfCollectionsData(collectionId, "collection");
				remixPresenterWidget.getView().getAppPopUp().show();
				isCustomizePopup = false;
				remixPresenterWidget.getView().getAppPopUp().center();
				remixPresenterWidget.getView().getAppPopUp().setGlassEnabled(true);
				remixPresenterWidget.getView().getAppPopUp().setGlassStyleName("setGlassPanelZIndex");
			}

			/*Window.scrollTo(0, 0);
				if (!BrowserAgent.isDevice() && AppClientFactory.isAnonymous()){
					successPopupVc.setWidth("500px");
					successPopupVc.setHeight("515px");
				}else if(!BrowserAgent.isDevice() && !AppClientFactory.isAnonymous()){
					successPopupVc.setWidth("500px");
					successPopupVc.setHeight("336px");
				}
				successPopupVc.center();
				successPopupVc.show();*/

			Map<String,String> params = new HashMap<String,String>();
			params.put("id", AppClientFactory.getPlaceManager().getRequestParameter("id"));

			if(AppClientFactory.getPlaceManager().getRequestParameter("subject")!=null){
				params.put("subject", AppClientFactory.getPlaceManager().getRequestParameter("subject"));

			}
			if(AppClientFactory.getPlaceManager().getRequestParameter("lessonId")!=null){
				params.put("lessonId", AppClientFactory.getPlaceManager().getRequestParameter("lessonId"));
				params.put("customize", "yes");


			}
			if(AppClientFactory.getPlaceManager().getRequestParameter("folderId")!=null){
				params.put("folderId", AppClientFactory.getPlaceManager().getRequestParameter("folderId"));


			}
			if(AppClientFactory.getPlaceManager().getRequestParameter("folderItemId")!=null){
				params.put("folderItemId", AppClientFactory.getPlaceManager().getRequestParameter("folderItemId"));


			}

		}

	}

	/**
	 *
	 * @function oncustomizeCollectionBtnClicked
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
	@UiHandler("shareCollectionBtn")
	public void onshareCollectionBtnClicked(ClickEvent clickEvent) {
		getUiHandlers().triggerCollectionShareDataEvent(null,PlayerDataLogEvents.COLLECTION,"gooru",false);
		final Map<String, String> params = StringUtil.splitQuery(Window.Location.getHref());
		String collectionId = collectionDo.getGooruOid();
		AssignPopupVc successPopupVc = new AssignPopupVc(collectionId, collectionDo.getTitle(), collectionDo.getGoals()) {
			@Override
			public void closePoup() {
				Window.enableScrolling(true);
				this.hide();
			}
		};
		successPopupVc.show();

		if (!BrowserAgent.isDevice() && AppClientFactory.isAnonymous()){
			/*successPopupVc.setWidth("550px");
			successPopupVc.setHeight("625px");
			successPopupVc.center();*/
			successPopupVc.setPopupPosition(0, (Window.getClientHeight()-625)/2);
		}else if(!BrowserAgent.isDevice() && !AppClientFactory.isAnonymous()){
			/*successPopupVc.setWidth("550px");
			successPopupVc.setHeight("502px");
			successPopupVc.center();*/
			successPopupVc.setPopupPosition(0, (Window.getClientHeight()-527)/2);
		}
		//till here
		params.put("assign", "yes");
	}

	public void resetMetadataFields(){
		getFlagButton().setText(i18n.GL0556());
		getFlagButton().removeStyleName(PlayerBundle.INSTANCE.getPlayerStyle().previewCoverFlagImageOrange());
		getFlagButton().setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().playerPreviewCoverFlagImage());
		this.collectionDo=null;
	}

	@Override
	public void setRelatedConceptsContent(ArrayList<ConceptDo> conceptDoList,
			String coursePage, String subject, String lessonId,
			String libraryName) {

	}

	@Override
	public void isConceptsContainerVisible(boolean isVisible) {

	}


	public void setDataInsightsUrl(){
		String page=AppClientFactory.getPlaceManager().getRequestParameter("page", null);
		frameContainer.setVisible(true);
		if(AppClientFactory.isAnonymous()){
			messageContainer.setVisible(true);
			frameContainer.setVisible(false);
			loadingImageLabel.setVisible(false);
		}else{
			messageContainer.setVisible(false);
			getUiHandlers().setCollectionSummaryBasedOnClasspageIdSessionId();
		}
	}

	public void setClasspageInsightsUrl(String classpageId, String sessionId){
		if(sessionId==null) {
			sessionId = "";
		}
		String page=AppClientFactory.getPlaceManager().getRequestParameter("page", null);
		frameContainer.setVisible(true);
		if(AppClientFactory.isAnonymous()){
			messageContainer.setVisible(true);
			frameContainer.setVisible(false);

			loadingImageLabel.setVisible(false);
		}else{
			messageContainer.setVisible(false);
			getUiHandlers().setCollectionSummaryBasedOnClasspageIdSessionId();
		}
	}

	public void setDataInsightsSummaryUrl(String sessionId){
		String page=AppClientFactory.getPlaceManager().getRequestParameter("page", null);
		frameContainer.setVisible(true);
		if(AppClientFactory.isAnonymous()){
			messageContainer.setVisible(true);
			frameContainer.setVisible(false);
			loadingImageLabel.setVisible(false);
		}else{
			messageContainer.setVisible(false);
			sessionId=sessionId!=null?sessionId:"";
			getUiHandlers().setCollectionSummaryBasedOnClasspageIdSessionId();
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
	}




	public static void onClosingAndriodorIpaddiv()
	{
		//studyMainContianer.getElement().setAttribute("style", "margin-top:50px;");
	}

	@Override
	public void setViewCount(String viewCount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUserProfileName(String gooruUid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLikesCount(int likesCount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayAuthorDetails(boolean isDisplayDetails) {
		// TODO Auto-generated method stub

	}

	@Override
	public Anchor getFlagButton() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTeacherInfo(ClasspageItemDo classpageItemDo) {
		// TODO Auto-generated method stub

	}


	@Override
	public void displaySpendTime(Long hours, Long mins, Double secs) {
		spendTimeContainer.clear();
		if(AppClientFactory.isAnonymous()){
			dispalyTime();
			return;
		}
		String minsString = (mins == 0)? "00": ((mins < 10)? "0"+mins : ""+mins );
		String formattedTime="";
		formattedTime=((int) Math.round(secs))+"";
		String secsString ="";
		if(secs>0 && secs<1){
			formattedTime="<1";
		}/*else{
				formattedTime = (secs == 0)? "00": ((secs < 10)? "0" + secs : "" + secs);
			}*/
		if (hours > 0){
			displayTime(hours.toString(),hours==1?"hr":"hrs");
			displayTime(" "+minsString.toString(),minsString.equals("01")?"min":"mins");
			displayTime(" "+formattedTime.toString(),formattedTime.equals("01")?"sec":"secs");
		}
		else if (mins > 0){
			displayTime(minsString.toString(),minsString.equals("01")?"min":"mins");
			displayTime(" "+formattedTime.toString(),formattedTime.equals("01")?"sec":"sec");
		}
		else {
			displayTime(formattedTime.toString(),formattedTime.equals("01")?"sec":"sec");
		}
	}
	public void displayTime(String time, String timeText){
		InlineLabel inlineTimeLabel=new InlineLabel(time);
		inlineTimeLabel.setStyleName(playerStyle.timeTextBig());
		InlineLabel inlineTimeString=new InlineLabel(timeText);
		inlineTimeString.setStyleName(playerStyle.timeTextSmall());
		spendTimeContainer.add(inlineTimeLabel);
		spendTimeContainer.add(inlineTimeString);
	}
	public void dispalyTime(){
		spendTimeContainer.clear();
		InlineLabel inlineTimeLabel=new InlineLabel("-");
		inlineTimeLabel.setStyleName(playerStyle.timeTextBig());
		spendTimeContainer.add(inlineTimeLabel);
	}
	public void displayScore(String collectionScore, String noOfQuestions){
		InlineLabel inlineTimeLabel=new InlineLabel(collectionScore);
		inlineTimeLabel.setStyleName(playerStyle.timeTextBig());
		InlineLabel inlineTimeString=new InlineLabel("/"+noOfQuestions);
		inlineTimeString.setStyleName(playerStyle.timeTextSmall());
		scoreContainer.add(inlineTimeLabel);
		scoreContainer.add(inlineTimeString);

		score.setText(collectionScore+" %");
		goal.setText("Goal : 90%");
		correctStatus.setText(collectionScore+"/"+noOfQuestions+" "+i18n.GL2278());

		int scorePercentage=(Integer.parseInt(collectionScore)/Integer.parseInt(noOfQuestions))*100;
		String progressRedialStyle="blue-progress-"+scorePercentage;

		progressRadial.addStyleName(progressRedialStyle);
	}


	@Override
	public void displayScoreCount(Integer collectionScore, Integer noOfQuestions) {
		if(AppClientFactory.isAnonymous()){
			noOfQuestions=0;
		}
		scoreContainer.clear();
		if(noOfQuestions==0){
			InlineLabel inlineTimeLabel=new InlineLabel("-");
			inlineTimeLabel.setStyleName(playerStyle.timeTextBig());
			scoreContainer.add(inlineTimeLabel);
		}else{
			displayScore(collectionScore.toString(),noOfQuestions.toString());
		}
	}

	public void displayNextCollectionDetails(final CollectionDo nextCollectionDo,final String subjectId,final String lessonId,final String libraryType){

		if(nextCollectionDo!=null){
			this.nextCollectionDo=nextCollectionDo;
			hideNextCollectionContainer(true);
			whatNextCollectionTitle.setText(nextCollectionDo.getTitle().toString().length()>20?nextCollectionDo.getTitle().substring(0,20)+"...":nextCollectionDo.getTitle());
			whatNextCollectionTitle.setTitle(nextCollectionDo.getTitle());
			nextCollectionThumbnail.setUrl(nextCollectionDo.getThumbnails().getUrl());
			if(nextCollectionDo!=null&&nextCollectionDo.getCollectionItems()!=null){
				hideNextCollectionContainer(false);
				int questionCount=0;
				int resourceCount=0;
				for(int i=0;i<nextCollectionDo.getCollectionItems().size();i++){
					if(nextCollectionDo.getCollectionItems().get(i).getResource().getResourceFormat()!=null){
						if(nextCollectionDo.getCollectionItems().get(i).getResource().getResourceFormat().getDisplayName().equalsIgnoreCase("Question")){
							questionCount++;
						}else{
							resourceCount++;
						}
					}
				}
				if(resourceCount>0){
					this.resourceCount.setText(resourceCount==1?resourceCount+" Resource":resourceCount+" Resources");
				}
				if(questionCount>0){
					this.questionCount.setText(questionCount==1?questionCount+" Question":questionCount+" Questions");
				}
				nextCollectionThumbnail.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						Map<String,String> params = new LinkedHashMap<String,String>();
						params.put("id", nextCollectionDo.getGooruOid());
						if(subjectId!=null){
							params.put("subject", subjectId);
						}
						if(lessonId!=null){
							params.put("lessonId", lessonId);
						}
						if(libraryType!=null){
							params.put("library", libraryType);
						}
						AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.ASSESSMENT_PLAY, params);
					}
				});
			}
		}else{
			hideNextCollectionContainer(true);
		}


	}

	public void displayWhatsNextContent(final FolderWhatsNextCollectionDo folderCollectionWhatsNext,final String urlValue)
	{
		final String folderId = AppClientFactory.getPlaceManager().getRequestParameter("folderId");
		this.folderCollectionWhatsNext=folderCollectionWhatsNext;
		if(folderCollectionWhatsNext.getTitle()!=null)
		{
			hideNextCollectionContainer(false);
			whatNextCollectionTitle.setText(folderCollectionWhatsNext.getTitle());
			whatNextCollectionTitle.setTitle(folderCollectionWhatsNext.getTitle());
			String collectionType=StringUtil.isEmpty(folderCollectionWhatsNext.getCollectionType())?null:folderCollectionWhatsNext.getCollectionType();
			StringUtil.setDefaultImages(collectionType, nextCollectionThumbnail, "toc");
			nextCollectionThumbnail.setUrl(folderCollectionWhatsNext.getThumbnails().getUrl());
			int resourcesCounter = folderCollectionWhatsNext.getResourceCount();
			int questionsCounter = folderCollectionWhatsNext.getQuestionCount();
			if(resourcesCounter>0){
				this.resourceCount.setText(resourcesCounter==1?resourcesCounter+" Resource":resourcesCounter+" Resources");
			}else{
				this.resourceCount.setText("");
			}
			if(questionsCounter>0){
				this.questionCount.setText(questionsCounter==1?questionsCounter+" Question":questionsCounter+" Questions");
			}else{
				this.questionCount.setText("");
			}
			if(folderCollectionWhatsNext.getCollectionType().equalsIgnoreCase("assessment/url"))
			{
				if(whatsNextHandler!=null){
					whatsNextHandler.removeHandler();
				}
				whatsNextHandler = nextCollectionThumbnail.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {

						Window.open(urlValue, "_blank", "");

					}
				});
			}
			else
			{
				if(whatsNextHandler!=null){
					whatsNextHandler.removeHandler();
				}
				whatsNextHandler = nextCollectionThumbnail.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {

						Map<String,String> params = new LinkedHashMap<String,String>();
						params.put("id", folderCollectionWhatsNext.getGooruOid());

						if(folderCollectionWhatsNext.getCollectionItemId()!=null)
						{
							params.put("folderId", folderId);
							params.put("folderItemId", folderCollectionWhatsNext.getCollectionItemId());
						}
						AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.ASSESSMENT_PLAY, params);

					}
				});
			}

		}
		else
		{
			hideNextCollectionContainer(true);
		}
	}

	public void hideNextCollectionContainer(boolean hide){
		nextCollectionContainer.setVisible(!hide);
	}

	public void  getAverageReaction(){
		getUiHandlers().getAvgReaction();
	}

	public void showAvgReaction(String reactionType){
		if(AppClientFactory.isAnonymous()){
			reactionType=null;
		}
		avgReactionImage.setText("");
		if(reactionType!=null){
			if(reactionType.equals(AssessmentsResourcePlayerMetadataView.REACTION_CAN_EXPLAIN)){
				avgReactionImage.setStyleName(playerStyle.reactionCanExplain());
			}else if(reactionType.equals(AssessmentsResourcePlayerMetadataView.REACTION_CAN_UNDERSTAND)){
				avgReactionImage.setStyleName(playerStyle.reactionCanUnderstand());
			}else if(reactionType.equals(AssessmentsResourcePlayerMetadataView.REACTION_DONOT_UNDERSTAND)){
				avgReactionImage.setStyleName(playerStyle.reactionDonotUnderstand());
			}else if(reactionType.equals(AssessmentsResourcePlayerMetadataView.REACTION_MEH)){
				avgReactionImage.setStyleName(playerStyle.reactionMeh());
			}else if(reactionType.equals(AssessmentsResourcePlayerMetadataView.REACTION_NEED_HELP)){
				avgReactionImage.setStyleName(playerStyle.reactionNeedHelp());
			}
		}else{
			avgReactionImage.setText("-");
			avgReactionImage.setStyleName(playerStyle.timeTextBig());
		}
	}

	public ResourceServiceAsync getResourceService() {
		return resourceService;
	}

	public void setResourceService(ResourceServiceAsync resourceService) {
		this.resourceService = resourceService;
	}



	@Override
	public void setSessionsData(ArrayList<CollectionSummaryUsersDataDo> result) {
		sessionspnl.setVisible(true);
		collectionMetaDataPnl.setVisible(true);
		sessionsDropDown.clear();
		sessionData.clear();
		for (CollectionSummaryUsersDataDo collectionSummaryUsersDataDo : result) {
			sessionData.put(collectionSummaryUsersDataDo.getSessionId(), collectionSummaryUsersDataDo.getTimeStamp());
			int day=collectionSummaryUsersDataDo.getFrequency();
			sessionsDropDown.addItem(day+AnalyticsUtil.getOrdinalSuffix(day)+" Attempt",collectionSummaryUsersDataDo.getSessionId());
		}
		setSessionStartTime(result.size()-1);
	}
	public void setSessionStartTime(int selectedIndex) {
		if(sessionData.size()!=0){
			lastModifiedTime.setText(i18n.GL4005()+AnalyticsUtil.getSessionsCreatedTime(Long.toString(sessionData.get(sessionsDropDown.getValue(selectedIndex)))));
			sessionsDropDown.setSelectedIndex(selectedIndex);
			printData.setUserName(null);
			printData.setSession(sessionsDropDown.getItemText(selectedIndex));
			printData.setSessionStartTime(AnalyticsUtil.getSessionsCreatedTime(Long.toString(sessionData.get(sessionsDropDown.getValue(selectedIndex)))));
		}
	}

	@Override
	public void setCollectionMetaDataByUserAndSession(ArrayList<CollectionSummaryMetaDataDo> result) {
		if(result.size()!=0){
			collectionTitle.setText(result.get(0).getTitle());
			collectionLastAccessed.setText(AnalyticsUtil.getCreatedTime(Long.toString(result.get(0).getLastModified())));
			if(result.get(0).getThumbnail()!=null && !result.get(0).getThumbnail().trim().equalsIgnoreCase("")){
				collectionImage.setUrl(result.get(0).getThumbnail());
			}else{
				collectionImage.setUrl("images/analytics/default-collection-image.png");
			}
			collectionImage.addErrorHandler(new ErrorHandler() {
				@Override
				public void onError(ErrorEvent event) {
					collectionImage.setUrl("images/analytics/default-collection-image.png");
				}
			});
			collectionResourcesCount.setText(result.get(0).getNonResourceCount()+" Questions");
		}
	}

	@Override
	public void resetCollectionMetaData(){
		collectionTitle.setText("");
		collectionLastAccessed.setText("");
		collectionImage.setUrl("");
		collectionResourcesCount.setText("");
	}

	@Override
	public HTMLPanel getLoadingImageLabel() {
		return loadingImageLabel;
	}

	/**
	 * @function removeHtmlTags
	 *
	 * @created_date : 15-Dec-2014
	 *
	 * @description this method is used to remove the html tags in comment input box
	 *
	 * @parm(s) : @param String
	 *
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private String removeHtmlTags(String html){
		html = html.replaceAll("(<\\w+)[^>]*(>)", "$1$2");
		html = html.replaceAll("</p>", " ").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "").replaceAll("</a>", "").replaceAll("<a>", "");
		return html;
	}
	@Override
	public void hidePanel(){
		sessionspnl.setVisible(false);
		collectionMetaDataPnl.setVisible(false);
	}
	@Override
	public void resetData(){
		pnlSummary.clear();
	}

	@Override
	public void showMessageWhenDataNotFound() {
		messageContainer.setVisible(true);
		frameContainer.setVisible(false);
		loadingImageLabel.setVisible(false);
		insightsContentText.setText(i18n.GL2038());
	}



	@Override
	public void setQuestionsData(final ArrayList<UserDataDo> result) {
		GWT.runAsync(new SimpleRunAsyncCallback() {

			@Override
			public void onSuccess() {

				questionsTable.clear();

				DataTable data = DataTable.create();
				data.addColumn(ColumnType.NUMBER, i18n.GL3259());
				data.addColumn(ColumnType.STRING, i18n.GL0308());
				data.addColumn(ColumnType.STRING, i18n.GL0315());
				data.addColumn(ColumnType.STRING, i18n.GL3270());
				data.addColumn(ColumnType.STRING, i18n.GL2084());
				data.addColumn(ColumnType.STRING, i18n.GL3271());

				data.addRows(result.size());
				if(result.size()!=0){
					for(int i=0;i<result.size();i++) {
						data.setCell(i, 0, result.get(i).getItemSequence(), null, getPropertiesCell());

						Label questionTitle=new Label(AnalyticsUtil.html2text(result.get(i).getTitle()));
						questionTitle.setStyleName(STYLE_TABLE_CENTER);
						questionTitle.setStyleName(STYLE_TXTLEFT);
						data.setValue(i, 1, questionTitle.toString());
						int noOfAttempts=result.get(i).getAttempts();

						//Set Answer choices
						String questionType= result.get(i).getType();
						if(questionType.equalsIgnoreCase("HS")){
							questionType= result.get(i).getQuestionType();
						}
						String correctAnser = null;
						if(MC.equalsIgnoreCase(questionType) ||TF.equalsIgnoreCase(questionType)){ 
							Label anserlbl=new Label();
							if(result.get(i).getMetaData()!=null && result.get(i).getOptions()!=null){
								JSONValue value = JSONParser.parseStrict(result.get(i).getOptions());
								JSONObject authorObject = value.isObject();
								if(authorObject.keySet().size()!=0){
									String userSelectedOption=authorObject.keySet().iterator().next();
									correctAnser=getCorrectAnswer(result.get(i).getMetaData());
									if(userSelectedOption!=null && correctAnser!=null){
										anserlbl.setText(userSelectedOption);
										if(userSelectedOption.equalsIgnoreCase(correctAnser) && noOfAttempts==1){
											anserlbl.getElement().getStyle().setColor(CORRECT);
										}else if(userSelectedOption.equalsIgnoreCase(correctAnser) && noOfAttempts>1){
											anserlbl.getElement().getStyle().setColor(ONMULTIPULEATTEMPTS);
										}else{
											anserlbl.getElement().getStyle().setColor(INCORRECT);
										}
									}
								}
							}
							anserlbl.setStyleName(STYLE_TABLE_CENTER);
							data.setValue(i, 2, anserlbl.toString());
						}else if (FIB.equalsIgnoreCase(questionType)){
							VerticalPanel answerspnl=new VerticalPanel();
							if(result.get(i).getMetaData()!=null && result.get(i).getOptions()!=null){
								String answerTextFormat = "";
								String[] answersArry = null;
								ArrayList<MetaDataDo> questionList=result.get(i).getMetaData();
								for (MetaDataDo metaDataDo : questionList) {
									String answerText = "";
									if((metaDataDo.getAnswer_text() != null)) {
										answerText = metaDataDo.getAnswer_text();
									}
									answerTextFormat += '[' + answerText +']';
									if(questionList.size()  != metaDataDo.getSequence()){
										answerTextFormat += ",";
									}
								}
								String[] userFibOption = null;
								if(result.get(i).getText() != null) {
									answersArry=answerTextFormat.split(",");
									userFibOption =result.get(i).getText().split(",");
								}
								if(answersArry!=null && userFibOption!=null){
									for (int k = 0; k < answersArry.length; k++) { 
										Label answerChoice=new Label();
										if(answersArry[k]!=null && k<userFibOption.length){
											if((answersArry[k].toLowerCase().trim().equalsIgnoreCase(userFibOption[k].toLowerCase().trim())) && (noOfAttempts == 1)){
												answerChoice.setText(userFibOption[k]);
												answerChoice.getElement().getStyle().setColor(CORRECT);
											}else if((answersArry[k].toLowerCase().trim().equalsIgnoreCase(userFibOption[k].toLowerCase().trim())) && (noOfAttempts > 1)) {
												answerChoice.setText(userFibOption[k]);
												answerChoice.getElement().getStyle().setColor(ONMULTIPULEATTEMPTS);
											}else{
												answerChoice.setText(userFibOption[k]);
												answerChoice.getElement().getStyle().setColor(INCORRECT);
											}
											answerChoice.setStyleName(STYLE_TABLE_CENTER);
											answerspnl.add(answerChoice);
										}
									}
								}
							}
							answerspnl.setStyleName(STYLE_MARGIN_AUTO);
							data.setValue(i, 2, answerspnl.toString());
						}else  if(MA.equalsIgnoreCase(questionType)){
							VerticalPanel answerspnl=new VerticalPanel();
							if(result.get(i).getAnswerObject()!=null) {
								JSONValue value = JSONParser.parseStrict(result.get(i).getAnswerObject());
								JSONObject answerObject = value.isObject();
								Set<String> keys=answerObject.keySet();
								Iterator<String> itr = keys.iterator();
								while(itr.hasNext()) {
									answerspnl.clear();
									JSONArray attemptsObj=(JSONArray) answerObject.get(itr.next().toString());
									for(int j=0;j<attemptsObj.size();j++){
										Label answerChoice=new Label();
										String showMessage = null;
										boolean skip = attemptsObj.get(j).isObject().get("skip").isBoolean().booleanValue();
										String status =attemptsObj.get(j).isObject().get("status").isString().stringValue();
										String matext =attemptsObj.get(j).isObject().get("text").isString().stringValue();
										if(skip == false)
										{
											if(ZERO_NUMERIC.equalsIgnoreCase(matext)) {
												showMessage = i18n.GL_GRR_NO();
											} else if(ONE.equalsIgnoreCase(matext)) {
												showMessage = i18n.GL_GRR_YES();
											}
											answerChoice.setText(showMessage);
											if(ZERO_NUMERIC.equalsIgnoreCase(status)) {
												answerChoice.getElement().getStyle().setColor(INCORRECT);
											} else if(ONE.equalsIgnoreCase(status) && (noOfAttempts == 1)) {
												answerChoice.getElement().getStyle().setColor(CORRECT);
											} else if(ONE.equalsIgnoreCase(status) && (noOfAttempts > 1)) {
												answerChoice.getElement().getStyle().setColor(ONMULTIPULEATTEMPTS);
											}
										}
										answerChoice.setStyleName(STYLE_TABLE_CENTER);
										answerspnl.add(answerChoice);
									}
								}
							}
							answerspnl.setStyleName(STYLE_MARGIN_AUTO);
							data.setValue(i, 2, answerspnl.toString());
						}else if(HT_RO.equalsIgnoreCase(questionType) || HT_HL.equalsIgnoreCase(questionType) || HS_TXT.equalsIgnoreCase(questionType) || HS_IMG.equalsIgnoreCase(questionType)){
							VerticalPanel answerspnl=new VerticalPanel();
							if(result.get(i).getAnswerObject()!=null) {
								Label viewResponselbl=new Label(VIEWRESPONSE);
								viewResponselbl.setStyleName("summaryViewResponse");
								viewResponselbl.getElement().setAttribute("resourceGooruId", result.get(i).getResourceGooruOId());
								viewResponselbl.getElement().setAttribute("questionType", result.get(i).getType());
								viewResponselbl.getElement().setAttribute("answerObj", result.get(i).getAnswerObject());
								viewResponselbl.getElement().setAttribute("attempts",String.valueOf(noOfAttempts));
								answerspnl.add(viewResponselbl);
							}
							answerspnl.setStyleName(STYLE_MARGIN_AUTO);
							data.setValue(i, 2, answerspnl.toString());
						}   

						//Set attempts
						Label attempts=new Label(Integer.toString(noOfAttempts));
						attempts.setStyleName(STYLE_TABLE_CENTER);
						data.setValue(i, 3, attempts.toString());

						//Set time spent
						data.setValue(i, 4, AnalyticsUtil.getTimeStampLabel(result.get(i).getTimeSpent()).toString());

						//Set reactions
						int reaction=result.get(i).getReaction();
						data.setValue(i, 5, new AnalyticsReactionWidget(reaction).toString());
					}
				}
				Options options = Options.create();
				options.setAllowHtml(true);
				Table table = new Table(data, options);
				table.addDomHandler(new SummaryPopupClick(), ClickEvent.getType());
				table.getElement().setId("individulaDataScored");
				questionsTable.add(table);
				if(result.size()==0){
					Label erroeMsg=new Label();
					erroeMsg.setStyleName(STYLE_ERROR_MSG);
					erroeMsg.setText(i18n.GL3265());
					questionsTable.add(erroeMsg);
				}
				table.getElement().getFirstChildElement().getFirstChildElement().getFirstChildElement().getStyle().setProperty("width", "98% !important");

			}
		});
	}


	/**
	 * This will set the cell properties
	 * @return
	 */
	com.google.gwt.visualization.client.Properties getPropertiesCell(){
		Properties properties=Properties.create();
		properties.set("style", "text-align:center;");
		com.google.gwt.visualization.client.Properties p=properties.cast();
		return p;
	}

	/**
	 * This will return the correct answers
	 * @param metaDataObj
	 * @return
	 */
	String getCorrectAnswer(ArrayList<MetaDataDo> metaDataObj){
		for (MetaDataDo metaDataDo : metaDataObj) {
			if(metaDataDo.getIs_correct()==1){
				return AnalyticsUtil.getCharForNumber(metaDataDo.getSequence()-1);
			}
		}
		return null;
	}


	public class SummaryPopupClick implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			Element ele=event.getNativeEvent().getEventTarget().cast();
			if(ele.getInnerText().equalsIgnoreCase(VIEWRESPONSE) && !StringUtil.isEmpty(ele.getAttribute("resourceGooruId")) && !StringUtil.isEmpty(ele.getAttribute("answerObj"))){
				JSONValue value = JSONParser.parseStrict(ele.getAttribute("answerObj").toString());
				JSONObject answerObject = value.isObject();
				Set<String> keys=answerObject.keySet();
				Iterator<String> itr = keys.iterator();
				JSONArray attemptsObj=null;
				while(itr.hasNext()) {
					attemptsObj=(JSONArray) answerObject.get(itr.next().toString());
				}
				if(attemptsObj!=null){
					SummaryAnswerStatusPopup summaryPopup=new SummaryAnswerStatusPopup(attemptsObj, ele.getAttribute("questionType"),ele.getAttribute("attempts"));
				}
			}
		}
	};


	@Override
	public void setQuestionsPrintData(final ArrayList<UserDataDo> result) {
		GWT.runAsync(new SimpleRunAsyncCallback() {

			@Override
			public void onSuccess() {

				try{
					printScoredData.clear();
					boolean isTickdisplay=false;
					DataTable data = DataTable.create();
					data.addColumn(ColumnType.NUMBER, i18n.GL3259());
					data.addColumn(ColumnType.STRING, i18n.GL0308());
					data.addColumn(ColumnType.STRING, i18n.GL2288());
					data.addColumn(ColumnType.STRING, i18n.GL3269());
					data.addColumn(ColumnType.STRING, i18n.GL3270());
					data.addColumn(ColumnType.STRING, i18n.GL2084());
					data.addColumn(ColumnType.STRING, i18n.GL3271());

					data.addRows(result.size());
					if(result.size()!=0){
						for(int i=0;i<result.size();i++) {
							isTickdisplay=false;
							data.setCell(i, 0, result.get(i).getItemSequence(), null, getPropertiesCell());

							Label questionTitle=new Label(AnalyticsUtil.html2text(result.get(i).getTitle()));
							questionTitle.setStyleName(STYLE_TABLE_CENTER);
							questionTitle.setStyleName(STYLE_TXTLEFT);
							data.setValue(i, 1, questionTitle.toString());
							int noOfAttempts=result.get(i).getAttempts();


							//Set Answer choices
							String questionType= result.get(i).getType();
							if(questionType.equalsIgnoreCase("HS")){
								questionType= result.get(i).getQuestionType();
							}
							String correctAnser = null;
							if(questionType.equalsIgnoreCase(MC) ||questionType.equalsIgnoreCase(TF)){ 
								Label anserlbl=new Label();
								if(result.get(i).getMetaData()!=null && result.get(i).getOptions()!=null){
									JSONValue value = JSONParser.parseStrict(result.get(i).getOptions());
									JSONObject authorObject = value.isObject();
									if(authorObject.keySet().size()!=0){
										String userSelectedOption=authorObject.keySet().iterator().next();
										correctAnser=getCorrectAnswer(result.get(i).getMetaData());
										if(userSelectedOption!=null && correctAnser!=null){
											anserlbl.setText(userSelectedOption);
											if(userSelectedOption.equalsIgnoreCase(correctAnser) && noOfAttempts==1){
												anserlbl.getElement().getStyle().setColor(CORRECT);
												isTickdisplay=true;
											}else if(userSelectedOption.equalsIgnoreCase(correctAnser) && noOfAttempts>1){
												anserlbl.getElement().getStyle().setColor(ONMULTIPULEATTEMPTS);
											}else{
												anserlbl.getElement().getStyle().setColor(INCORRECT);
											}
										}
									}
								}
								anserlbl.setStyleName(STYLE_TABLE_CENTER);
								data.setValue(i, 3, anserlbl.toString());
							}else if (FIB.equalsIgnoreCase(questionType)){
								VerticalPanel answerspnl=new VerticalPanel();
								if(result.get(i).getMetaData()!=null && result.get(i).getOptions()!=null){
									String answerTextFormat = "";
									String[] answersArry = null;
									ArrayList<MetaDataDo> questionList=result.get(i).getMetaData();
									for (MetaDataDo metaDataDo : questionList) {
										String answerText = "";
										if((metaDataDo.getAnswer_text() != null)) {
											answerText = metaDataDo.getAnswer_text();
										}
										answerTextFormat += '[' + answerText +']';
										if(questionList.size()  != metaDataDo.getSequence()){
											answerTextFormat += ",";
										}
									}
									String[] userFibOption = null;
									if(result.get(i).getText() != null) {
										answersArry=answerTextFormat.split(",");
										userFibOption =result.get(i).getText().split(",");
									}
									if(answersArry!=null && userFibOption!=null){
										boolean isCorrect=false;
										for (int k = 0; k < answersArry.length; k++) { 
											Label answerChoice=new Label();
											if(answersArry[k]!=null && k<userFibOption.length){
												if((answersArry[k].toLowerCase().trim().equalsIgnoreCase(userFibOption[k].toLowerCase().trim())) && (noOfAttempts == 1)){
													answerChoice.setText(userFibOption[k]);
													answerChoice.getElement().getStyle().setColor(CORRECT);
												}else if((answersArry[k].toLowerCase().trim().equalsIgnoreCase(userFibOption[k].toLowerCase().trim())) && (noOfAttempts > 1)) {
													answerChoice.setText(userFibOption[k]);
													answerChoice.getElement().getStyle().setColor(ONMULTIPULEATTEMPTS);
													isCorrect=true;
												}else{
													answerChoice.setText(userFibOption[k]);
													answerChoice.getElement().getStyle().setColor(INCORRECT);
													isCorrect=true;
												}
												answerChoice.setStyleName(STYLE_TABLE_CENTER);
												answerspnl.add(answerChoice);
											}
										}
										if(!isCorrect){
											isTickdisplay=true;
										}
									}
								}
								answerspnl.setStyleName(STYLE_MARGIN_AUTO);
								data.setValue(i, 3, answerspnl.toString());
							}else  if(MA.equalsIgnoreCase(questionType)){
								VerticalPanel answerspnl=new VerticalPanel();
								if(result.get(i).getAnswerObject()!=null) {
									JSONValue value = JSONParser.parseStrict(result.get(i).getAnswerObject());
									JSONObject answerObject = value.isObject();
									Set<String> keys=answerObject.keySet();
									Iterator<String> itr = keys.iterator();
									boolean isCorrect=false;
									while(itr.hasNext()) {
										answerspnl.clear();
										JSONArray attemptsObj=(JSONArray) answerObject.get(itr.next().toString());
										for(int j=0;j<attemptsObj.size();j++){
											Label answerChoice=new Label();
											String showMessage = null;
											boolean skip = attemptsObj.get(j).isObject().get("skip").isBoolean().booleanValue();
											String status =attemptsObj.get(j).isObject().get("status").isString().stringValue();
											String matext =attemptsObj.get(j).isObject().get("text").isString().stringValue();
											if(skip == false)
											{
												if(ZERO_NUMERIC.equalsIgnoreCase(matext)) {
													showMessage = i18n.GL_GRR_NO();
												} else if(ONE.equalsIgnoreCase(matext)) {
													showMessage = i18n.GL_GRR_YES();
												}
												answerChoice.setText(showMessage);
												if(ZERO_NUMERIC.equalsIgnoreCase(status)) {
													answerChoice.getElement().getStyle().setColor(INCORRECT);
													isCorrect=true;
												} else if(ONE.equalsIgnoreCase(status) && (noOfAttempts == 1)) {
													answerChoice.getElement().getStyle().setColor(CORRECT);
												} else if(ONE.equalsIgnoreCase(status) && (noOfAttempts > 1)) {
													answerChoice.getElement().getStyle().setColor(ONMULTIPULEATTEMPTS);
												}
											}else{
												isCorrect=true;
											}
											answerChoice.setStyleName(STYLE_TABLE_CENTER);
											answerspnl.add(answerChoice);
										}
									}
									if(!isCorrect){
										isTickdisplay=true;
									}
								}
								answerspnl.setStyleName(STYLE_MARGIN_AUTO);
								data.setValue(i, 3, answerspnl.toString());
							}else if(HT_RO.equalsIgnoreCase(questionType) || HT_HL.equalsIgnoreCase(questionType) || HS_TXT.equalsIgnoreCase(questionType) || HS_IMG.equalsIgnoreCase(questionType) ){
								VerticalPanel answerspnl=new VerticalPanel();
								if(result.get(i).getAnswerObject()!=null) {
									Label viewResponselbl=new Label(VIEWRESPONSE);
									viewResponselbl.setStyleName("summaryViewResponse");
									viewResponselbl.getElement().setAttribute("resourceGooruId", result.get(i).getResourceGooruOId());
									viewResponselbl.getElement().setAttribute("questionType", result.get(i).getType());
									viewResponselbl.getElement().setAttribute("answerObj", result.get(i).getAnswerObject());
									viewResponselbl.getElement().setAttribute("attempts",String.valueOf(noOfAttempts));
									answerspnl.add(viewResponselbl);
								}
								answerspnl.setStyleName(STYLE_MARGIN_AUTO);
								data.setValue(i, 3, answerspnl.toString());
							}

							Image correctImg=new Image();      	            
							if(isTickdisplay){
								correctImg.setUrl(urlDomain+"/images/analytics/tick.png");
							}else{ 
								correctImg.setUrl(urlDomain+"/images/analytics/wrong.png");				        		
							}
							data.setCell(i, 2, correctImg.toString(), null, getPropertiesCell());
							//Set attempts
							Label attempts=new Label(Integer.toString(noOfAttempts));
							attempts.setStyleName(STYLE_TABLE_CENTER);
							data.setValue(i, 4, attempts.toString());

							//Set time spent
							data.setValue(i, 5,AnalyticsUtil.getTimeStampLabel(result.get(i).getTimeSpent()).toString());

							//Set reactions
							int reaction=result.get(i).getReaction();
							data.setValue(i, 6, new AnalyticsReactionWidget(reaction).toString());
						}
					}
					Options options = Options.create();
					options.setAllowHtml(true);
					Table table = new Table(data, options);
					table.addDomHandler(new SummaryPopupClick(), ClickEvent.getType());
					printScoredData.add(table);
					if(result.size()==0){
						Label erroeMsg=new Label();
						erroeMsg.setStyleName(STYLE_ERROR_MSG);
						erroeMsg.setText(i18n.GL3265());
						printScoredData.add(erroeMsg);
					}
				}catch(Exception e){
					AppClientFactory.printSevereLogger(e.getMessage());
				}

			}
		});
	}

	public void setPrintIndividualSummayData(final boolean isClickedOnSave, final boolean isClickedOnEmail){
		GWT.runAsync(new SimpleRunAsyncCallback() {

			@Override
			public void onSuccess() {

				printWidget.clear();
				Label collectionSummaryText=new Label();
				collectionSummaryText.setText(i18n.GL4006());
				collectionSummaryText.getElement().getStyle().setPaddingBottom(15, Unit.PX);
				collectionSummaryText.addStyleName("collectionSummaryText");
				printWidget.add(collectionSummaryText);
				//printWidget.add(collectionSummaryWidget);

				//To add scored questions
				Label scoredQuestionHeading=new Label();
				scoredQuestionHeading.setText(i18n.GL2282());
				scoredQuestionHeading.getElement().getStyle().setClear(Clear.BOTH);
				scoredQuestionHeading.getElement().getStyle().setPaddingTop(15, Unit.PX);
				scoredQuestionHeading.getElement().getStyle().setPaddingBottom(20, Unit.PX);
				printWidget.add(scoredQuestionHeading);
				printWidget.add(printScoredData);
				printScoredData.getElement().getStyle().setPaddingBottom(20, Unit.PX);

				//To add resource breakdown
				//printWidget.add(collectionOverViewWidget);
				//printWidget.add(printResourceData);
				if(isClickedOnSave){
					getUiHandlers().setHtmltopdf(style.toString().replaceAll("'", "\\\\\"")+printWidget.getElement().getInnerHTML().toString().replaceAll("\"", "\\\\\""),collectionTitle.getText(),isClickedOnEmail);
					printWidget.clear();
				}else{
					Print.it(style,printWidget);
					printWidget.clear();
				}

			}
		});
	}

	@UiHandler("printButton")
	public void printButtonClick(ClickEvent event){
		setPrintIndividualSummayData(false,false);
	}

	@UiHandler("downloadButton")
	public void downlaodButtonClick(ClickEvent event){
		setPrintIndividualSummayData(true,false);
	}



	@Override
	public void setPdfForEmail(String path) {
		if(emailPopup!=null){
			emailPopup.setEmailData(collectionTitle.getText(),path);
		}
	}



	@Override
	public Frame getFrame() {
		return downloadFile;
	}

}
