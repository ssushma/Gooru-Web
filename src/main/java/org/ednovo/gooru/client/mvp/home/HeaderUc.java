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
package org.ednovo.gooru.client.mvp.home;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.GooruCBundle;
import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SearchAsyncCallback;
import org.ednovo.gooru.client.SeoTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.event.InvokeLoginEvent;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.classpages.ClasspageListVc;
import org.ednovo.gooru.client.mvp.classpages.event.ClearClasspageListEvent;
import org.ednovo.gooru.client.mvp.classpages.event.ClearClasspageListHandler;
import org.ednovo.gooru.client.mvp.classpages.event.OpenClasspageListEvent;
import org.ednovo.gooru.client.mvp.classpages.event.OpenClasspageListHandler;
import org.ednovo.gooru.client.mvp.home.event.HeaderTabType;
import org.ednovo.gooru.client.mvp.home.event.HomeEvent;
import org.ednovo.gooru.client.mvp.search.event.ConfirmStatusPopupEvent;
import org.ednovo.gooru.client.mvp.search.event.ConfirmStatusPopupHandler;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderEvent;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderHandler;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexHandler;
import org.ednovo.gooru.client.uc.AppMultiWordSuggestOracle;
import org.ednovo.gooru.client.uc.AppSuggestBox;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.client.uc.tooltip.DiscoverToolTip;
import org.ednovo.gooru.client.uc.tooltip.OrganizeToolTip;
import org.ednovo.gooru.client.uc.tooltip.StudyNowToolTip;
import org.ednovo.gooru.client.uc.tooltip.StudyToolTip;
import org.ednovo.gooru.client.uc.tooltip.TeachToolTip;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.search.AutoSuggestKeywordSearchDo;
import org.ednovo.gooru.shared.model.search.SearchDo;
import org.ednovo.gooru.shared.model.user.UserDo;
import org.ednovo.gooru.shared.util.DataLogEvents;
import org.ednovo.gooru.shared.util.GwtUUIDGenerator;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * 
 * @fileName : HeaderUc.java
 *
 * @description : Related to Header section.
 *
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class HeaderUc extends Composite implements MessageProperties,
		SelectionHandler<SuggestOracle.Suggestion> {

	private static HeaderUcUiBinder uiBinder = GWT
			.create(HeaderUcUiBinder.class);

	interface HeaderUcUiBinder extends UiBinder<Widget, HeaderUc> {
	}
	/**
	 * List Handlers
	 */
	OpenClasspageListHandler openClasspageListHandler = new OpenClasspageListHandler() {

		@Override
		public void openClasspageList() {
			OpenClasspageList();
		}
	};

	ClearClasspageListHandler clearHandler = new ClearClasspageListHandler() {

		@Override
		public void clearClasspage() {
			clearClasspageList();
		}
	};

	SetHeaderHandler setHeader = new SetHeaderHandler() {

		@Override
		public void setHeaderEvent(UserDo userDo) {
			AppClientFactory
					.setBrowserWindowTitle(SeoTokens.HOME_TITLE_LOGGEDIN);
			AppClientFactory
					.setMetaDataDescription(SeoTokens.HOME_META_DESCRIPTION);
			setLoggedInUser(userDo);
		}
	};

	SetHeaderZIndexHandler setZindex = new SetHeaderZIndexHandler() {

		@Override
		public void setHeaderZIndex(int value, boolean isClearZIndex) {
			Document doc = Document.get();
			if (isClearZIndex) {
				try {
					doc.getElementById("headerMainPanel").getStyle()
							.clearZIndex();
					doc.getElementById("goToClasicInnerPanel").getStyle()
							.clearZIndex();
				} catch (Exception ex) {
					// Window.confirm("cleasezindex ex : "+ex.getMessage());
				}
			} else {
				try {
					doc.getElementById("headerMainPanel").getStyle()
							.setZIndex(value);
					doc.getElementById("goToClasicInnerPanel").getStyle()
							.setZIndex(value);
				} catch (Exception e) {
					// Window.confirm("cleasezindex e : "+e.getMessage());
				}
			}
		}

	};

	ConfirmStatusPopupHandler confirmUser = new ConfirmStatusPopupHandler() {

		@Override
		public void setVisibility(boolean value) {
			if (AppClientFactory.getLoggedInUser().getConfirmStatus() == 0) {
				acctActivationPl.setVisible(true);
			} else {
				acctActivationPl.setVisible(false);
			}

			if (AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(
					PlaceTokens.HOME)) {
				acctActivationPl.getElement().getStyle()
						.setMarginTop(51, Unit.PX);
			} else {
				acctActivationPl.getElement().getStyle().clearMarginTop();
			}
		}
	};

	private static final int TOOLTIP_DELAY_TIME = 1000;
	private String name;

	@UiField(provided = true)
	public AppSuggestBox editSearchTxtBox;

	@UiField
	FlowPanel editSearchInputFloPanel;

	@UiField
	FlowPanel logInfoFloPanel;

	@UiField
	Button editSearchBtn, StudyLbl;

	@UiField
	Anchor resendEmailAncr;

	@UiField
	Label logoutDownArrowLbl, registerLinkLbl, loginLink;

	@UiField
	HTMLEventPanel acctActivationPl;

	boolean isGooruGuidePanelOpen = false;

	private boolean isOpenSettingDropDown = true;

	private boolean isSettingIcon = false;

	private boolean isClassCodePopupOpen = true;

	private boolean isStudyNow = false;
	
	private boolean hasAutoSelected = false;
	/*
	 * @UiField Anchor registerLinkAnr;
	 */

	private LogoutPanelVc logoutPanelVc;

	private ClasspageListVc classpageListVc;

	private SaveSharePanel saveSharePanel;

	@Inject
	HomeUiHandlers homeUiHandlers;

	@Inject
	HomePresenter homePresenter;

	@UiField
	AnchorElement gooruLearning;

	@UiField
	VerticalPanel headerSearchBarVerPanel;

	@UiField
	FlowPanel headerSearchBarFloPanel;

	@UiField(provided = true)
	GooruCBundle res;

	@UiField
	Label lblBeta; // gooruClassicViewLbl

	@UiField
	HTMLPanel dotsPanel, mainDotsPanel;

	@UiField
	Label discoverLink, organizeLink, teachLink, studyLink, loggedInfoLbl;

	@UiField
	HTMLEventPanel discoverLinkContainer, organizeLinkContainer,
			teachLinkContainer, studyLinkContainer, LoginLinkContainer;

	Label noneMenu = null;

	@UiField
	HTMLPanel headerMainPanel;

	// @UiField TextBoxWithPlaceholder classCodeTxtBox;

	private UserDo userDo;
	private LoginPopupUc popup;

	private StudyNowToolTip studyNowToolTip;
	private static boolean addedAccounts = false;

	private PopupPanel toolTipPopupPanel = new PopupPanel();
	private SearchDo<AutoSuggestKeywordSearchDo> autoSuggestKeywordDo = new SearchDo<AutoSuggestKeywordSearchDo>();
	private SearchAsyncCallback<SearchDo<AutoSuggestKeywordSearchDo>> autoKeyWordSuggestionAsyncCallback;

	private Timer tooltipTimer = null;

	private static final String GOORU_UID = "gooruUid";

	private static final String ACCOUNT_TYPE = "accountType";
	private AppMultiWordSuggestOracle autokeySuggestOracle;
	String searchData = "";
	private String GOORU_SEARCH = " -<n> Gooru Search</n>";

	private String discoverLinkUrl = null;

	/**
	 * Class constructor , set logged in user , gooru classic view link
	 */
	public HeaderUc() {
		this.res = GooruCBundle.INSTANCE;
		res.css().ensureInjected();
		autokeySuggestOracle = new AppMultiWordSuggestOracle(true);
		setEditSearchTxtBox(new AppSuggestBox(autokeySuggestOracle) {

			@Override
			public HandlerRegistration addClickHandler(ClickHandler handler) {
				return null;
			}

			@Override
			public void keyAction(String text) {
				MixpanelUtil.Search_autocomplete_select();
				autokeySuggestOracle.clear();
				autoSuggestKeywordDo.setQuery(text);
				searchData = getEditSearchTxtBox().getText();
				autoSuggestKeywordDo.setType("resource");
				if (text != null && text.trim().length() > 0) {
					requestAutoSuggestKeyword(autoSuggestKeywordDo);
				} else {
					getEditSearchTxtBox().hideSuggestionList();
				}

			}

		});
		getEditSearchTxtBox().addSelectionHandler(this);
		getEditSearchTxtBox().setPopupStyleName("shelfEditSearchTextBox");
		initWidget(uiBinder.createAndBindUi(this));

		headerMainPanel.getElement().setAttribute("id", "headerMainPanel");

		logoutPanelVc = new LogoutPanelVc();

		saveSharePanel = new SaveSharePanel() {

			@Override
			@UiHandler("closeButton")
			public void closeButton(ClickEvent clickEvent) {
				isGooruGuidePanelOpen = false;
				Window.enableScrolling(true);
				hide();
			}
		};

		mainDotsPanel.setVisible(false);
		logoutPanelVc.setStyleName(GooruCBundle.INSTANCE.css().logoutPanel());
		editSearchInputFloPanel.setVisible(false);
		LoginLinkContainer.setVisible(false);
		loggedInfoLbl.setVisible(false);
		logoutDownArrowLbl.setVisible(false);
		/*
		 * classCodeTxtBox.setText("");
		 * classCodeTxtBox.getElement().setAttribute("maxlength", "10");
		 * classCodeTxtBox.getElement().setId("txtClassCode");
		 */

		StudyLbl.addClickHandler(new studyClickHandler());

		getEditSearchTxtBox().addKeyUpHandler(new SearchKeyUpHandler());
		editSearchInputFloPanel.setVisible(false);
		// gooruGuideImgLbl.setStyleName(GooruCBundle.INSTANCE.css().gooruGuideImg());
		this.switchToClassicView();
		headerSearchBarVerPanel.setCellVerticalAlignment(
				headerSearchBarFloPanel, HasVerticalAlignment.ALIGN_MIDDLE);

		noneMenu = new Label();

		discoverLink.getParent().getElement().setId("LinkheaderElement1");
		organizeLink.getParent().getElement().setId("LinkheaderElement2");
		teachLink.getParent().getElement().setId("LinkheaderElement3");
		studyLink.getParent().getElement().setId("LinkheaderElement4");
		loggedInfoLbl.getParent().getElement().setId("LinkheaderElement5");

		discoverLink.getParent().setStyleName(
				GooruCBundle.INSTANCE.css().menu());

		noneMenu = new Label();

		activateOnlyDiscover();

		discoverLinkContainer
				.addClickHandler(new OnClickDiscoverEventHandler());

		organizeLinkContainer
				.addClickHandler(new OnClickOrganizeEventHandler());

		teachLinkContainer.addClickHandler(new OnClickTeachEventHandler());

		studyLinkContainer.addClickHandler(new OnClickStudyEventHandler());

		// gooruClassicViewLbl.setText(MessageProperties.GL0094);
		getEditSearchTxtBox().getElement().setId("txtEditSearch");
		editSearchBtn.getElement().setId("btnEditSearch");
		editSearchBtn.setText(MessageProperties.GL0176);
		getEditSearchTxtBox().getElement().setAttribute("placeholder",
				MessageProperties.GL0177);
		lblBeta.setText(MessageProperties.GL0178);
		discoverLink.setText(MessageProperties.GL0179);
		organizeLink.setText(MessageProperties.GL0180);
		teachLink.setText(MessageProperties.GL0181);
		studyLink.setText(MessageProperties.GL0182);
		loggedInfoLbl.setText(MessageProperties.GL0183);
		// classCodeTxtBox.setPlaceholder(MessageProperties.GL0184);
		StudyLbl.setText(MessageProperties.GL0185);
		StudyLbl.getElement().setId("btnStudy");
		registerLinkLbl.setText(MessageProperties.GL0186);
		loginLink.setText(MessageProperties.GL0187);
		loginLink.getElement().setId("lblLogin");
		registerLinkLbl.getElement().setId("lblRegister");

		ClickHandler eve1 = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (!isSettingIcon) {
					isOpenSettingDropDown = true;
				} else {
					isSettingIcon = false;
				}
				if (!isStudyNow && studyNowToolTip != null) {
					isClassCodePopupOpen = true;
					studyNowToolTip.hide();
				} else {
					isStudyNow = false;
				}
			}
		};
		acctActivationPl.setVisible(false);
		resendEmailAncr.addClickHandler(new ResendEmailConfirmation());

		// goToClasicGooruPanel.setVisible(false);
		// goToClasicInnerPanel.getElement().setAttribute("id",
		// "goToClasicInnerPanel");
		// goToClasicGooruPanel.getElement().getStyle().setVisibility(Visibility.HIDDEN);

		if (!AppClientFactory.isAnonymous()) {
			if (AppClientFactory.getLoggedInUser().getConfirmStatus() == 0) {
				acctActivationPl.setVisible(true);
			}
		} else {
			acctActivationPl.setVisible(false);
		}

		ClickHandler dotsClick = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				getEditSearchTxtBox().setText("");
			}
		};
		mainDotsPanel.addDomHandler(dotsClick, ClickEvent.getType());

		AppClientFactory.getEventBus().addHandler(SetHeaderEvent.TYPE,
				setHeader);
		AppClientFactory.getEventBus().addHandler(SetHeaderZIndexEvent.TYPE,
				setZindex);
		AppClientFactory.getEventBus().addHandler(ClearClasspageListEvent.TYPE,
				clearHandler);
		AppClientFactory.getEventBus().addHandler(OpenClasspageListEvent.TYPE,
				openClasspageListHandler);
		AppClientFactory.getEventBus().addHandler(ConfirmStatusPopupEvent.TYPE, confirmUser);
		
		RootPanel.get().addDomHandler(eve1, ClickEvent.getType());

		/*
		 * if((AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens
		 * .SHELF))||(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(
		 * PlaceTokens
		 * .STUDY)||(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase
		 * (PlaceTokens
		 * .TEACH)))||(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase
		 * (PlaceTokens
		 * .SETTINGS))||(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase
		 * (PlaceTokens.PROFILE_PAGE))){ editSearchTxtBox.setText(""); }
		 */
		discoverLinkUrl = null;
	}
	/**
	 * 
	 * @function clearClasspageList 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :To clear class page list.
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void clearClasspageList() {

		classpageListVc = null;
	}

	/**
	 * Signin using the popup
	 * 
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */
	@UiHandler("loginLink")
	public void onLinkPopupClicked(ClickEvent clickEvent) {

		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, false));
		popup = new LoginPopupUc(this);
		popup.setGlassEnabled(true);
		popup.center();
		popup.show();
		if (name != null) {
			if (name.equalsIgnoreCase("teach")) {
				popup.setNameToken(PlaceTokens.TEACH);
			} else if (name.equalsIgnoreCase("organize")) {
				popup.setNameToken(PlaceTokens.SHELF);
			}
			name = null;
		}
	}

	/**
	 * Selection Control DOTS panel
	 * 
	 * @param Label
	 */

	public void manageDotsMenuSelection(Label dotsLink) {

		for (int i = 1; i < 6; i++) {

			if (userDo != null
					&& !userDo.getUserUid().equals(
							AppClientFactory.GOORU_ANONYMOUS)
					|| userDo.getUserUid().equals(
							AppClientFactory.GOORU_ANONYMOUS)) {
				try {
					Document.get()
							.getElementById("LinkheaderElement" + i)
							.removeClassName(GooruCBundle.INSTANCE.css().menu());
					Document.get()
							.getElementById("LinkheaderElement" + i)
							.removeClassName(
									GooruCBundle.INSTANCE.css().menuActive());
					Document.get().getElementById("LinkheaderElement" + i)
							.addClassName(GooruCBundle.INSTANCE.css().menu());
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				activateOnlyDiscover();

			}

		}
		if (dotsLink.equals(noneMenu)) {

		} else {
			dotsLink.getParent().setStyleName(
					GooruCBundle.INSTANCE.css().menuActive());
		}
	}
	/**
	 * 
	 * @function activateAllMenu 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :Activating Discover menu item.
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void activateOnlyDiscover() {
		organizeLink.getParent().setStyleName(
				GooruCBundle.INSTANCE.css().menu());
		teachLink.getParent().setStyleName(GooruCBundle.INSTANCE.css().menu());
		studyLink.getParent().setStyleName(GooruCBundle.INSTANCE.css().menu());
		loggedInfoLbl.getParent().setStyleName(
				GooruCBundle.INSTANCE.css().menu());
		discoverLink.getParent().setStyleName(
				GooruCBundle.INSTANCE.css().menuActive());
		if (classpageListVc != null) {
			if (classpageListVc.isShowing()) {
				classpageListVc.hide();
			}
		}

		if (logoutPanelVc != null) {
			if (logoutPanelVc.isShowing()) {
				logoutPanelVc.hide();
			}
			if (logoutPanelVc.logoutPopupVc != null) {
				if (logoutPanelVc.logoutPopupVc.appPopUp != null) {
					if (logoutPanelVc.logoutPopupVc.appPopUp.isShowing()) {
						logoutPanelVc.logoutPopupVc.appPopUp.hide();
					}
				}
			}

		}

	}
	/**
	 * 
	 * @function activateAllMenu 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :Activating all menu items.
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void activateAllMenu() {
		discoverLink.getParent().setStyleName(
				GooruCBundle.INSTANCE.css().menuActive());
		organizeLink.getParent().setStyleName(
				GooruCBundle.INSTANCE.css().menu());
		teachLink.getParent().setStyleName(GooruCBundle.INSTANCE.css().menu());
		studyLink.getParent().setStyleName(GooruCBundle.INSTANCE.css().menu());
		loggedInfoLbl.getParent().setStyleName(
				GooruCBundle.INSTANCE.css().menu());
	}

	/**
	 * Register using the popup
	 * 
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */
	@UiHandler("registerLinkLbl")
	public void onRegisterPopupClicked(ClickEvent clickEvent) {
		MixpanelUtil.Arrive_Register_popup();

		DataLogEvents.signUp(GwtUUIDGenerator.uuid(), "home",
				System.currentTimeMillis(), System.currentTimeMillis(), "");

		// RegisterVc registerVc = new RegisterVc();
		// registerVc.show();
		// registerVc.center();

		Map<String, String> map = StringUtil.splitQuery(Window.Location
				.getHref());
		map.put("callback", "signup");
		map.put("type", "1");
		AppClientFactory.getPlaceManager().revealPlace(
				AppClientFactory.getCurrentPlaceToken(), map);

	}

	/* Click event hanlder for Menu items */
	/**
	 * 
	 * @fileName : HeaderUc.java
	 *
	 * @description : DiscoverEvent Click Handler.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 30-Dec-2013
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	public class OnClickDiscoverEventHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			Window.enableScrolling(true);
			Cookies.setCookie("searchvalue", "");
			AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, true));
			Element e = null;
			if ((e = event.getRelativeElement()) != null) {
				if (e.getInnerHTML() != null
						&& e.getInnerHTML().contains("gwt-Label"))
					MixpanelUtil.Click_Discover_LandingPage();
			}
			manageDotsMenuSelection(discoverLink);
			if ((discoverLinkUrl != null)
					&& (!discoverLinkUrl.contains("featured-contributors"))) {
				Map<String, String> params = StringUtil
						.splitQuery(discoverLinkUrl);
				AppClientFactory.getPlaceManager().revealPlace(
						PlaceTokens.HOME, params);
			} else {
				AppClientFactory.getPlaceManager()
						.revealPlace(PlaceTokens.HOME);
			}
		}

	}
	/**
	 * 
	 * @fileName : HeaderUc.java
	 *
	 * @description :OrganizeEvent Click Handler. 
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 30-Dec-2013
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	public class OnClickOrganizeEventHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			AppClientFactory.setPreviousPlaceRequest(AppClientFactory
					.getPlaceManager().getCurrentPlaceRequest());
			Storage stockStore = Storage.getLocalStorageIfSupported();

			if (stockStore != null) {
				stockStore.setItem("tabKey", "resourceTab");
			}
			if (userDo != null
					&& !userDo.getUserUid().equals(
							AppClientFactory.GOORU_ANONYMOUS)) {
				Window.enableScrolling(true);
				AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, true));
				Element e = null;
				if ((e = event.getRelativeElement()) != null) {
					if (e.getInnerHTML() != null
							&& e.getInnerHTML().contains("gwt-Label"))
						MixpanelUtil.Click_Organize_LandingPage();
				}
				manageDotsMenuSelection(organizeLink);
				AppClientFactory
						.getInjector()
						.getResourceService()
						.getUserCollectionList(1, 0, false,
								new SimpleAsyncCallback<List<CollectionDo>>() {

									@Override
									public void onSuccess(
											List<CollectionDo> result) {
										if (result.size() > 0) {
											AppClientFactory
													.getPlaceManager()
													.revealPlace(
															PlaceTokens.SHELF,
															new String[] {
																	"id",
																	result.get(
																			0)
																			.getGooruOid() });
										} else {
											AppClientFactory.getPlaceManager()
													.revealPlace(
															PlaceTokens.SHELF);
										}
									}
								});
			} else {

				name = "organize";
				AppClientFactory.fireEvent(new InvokeLoginEvent());

			}
		}

	}
	/**
	 * 
	 * @fileName : HeaderUc.java
	 *
	 * @description : TeachEvent Click handler.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 30-Dec-2013
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	public class OnClickTeachEventHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {

			if (userDo != null
					&& !userDo.getUserUid().equals(
							AppClientFactory.GOORU_ANONYMOUS)) {
				Window.enableScrolling(true);
				AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, true));
				OpenClasspageList();

			} else {
				name = "teach";
				onLinkPopupClicked(null);
			}
		}

	}
	/**
	 * 
	 * @function OpenClasspageList 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : To open showTeachPanelAsPopup.
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void OpenClasspageList() {
		int left = teachLinkContainer.getAbsoluteLeft() - 139;
		int top = teachLinkContainer.getAbsoluteTop() + 51;
		showTeachPanelAsPopup(left, top);
	}
	/**
	 * 
	 * @fileName : HeaderUc.java
	 *
	 * @description : study onclick event handler.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 30-Dec-2013
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	public class OnClickStudyEventHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			Window.enableScrolling(true);
			AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, true));
			Element e = null;

			if ((e = event.getRelativeElement()) != null) {
				if (e.getInnerHTML() != null
						&& e.getInnerHTML().contains("gwt-Label"))
					MixpanelUtil.Click_Study_LandingPage();
			}
			manageDotsMenuSelection(studyLink);
			AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.STUDY);
		}
	}

	/* On mouse over and out handlers */
	/**
	 * 
	 * @fileName : HeaderUc.java
	 *
	 * @description : To show tooltip on Discover mouse over.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 30-Dec-2013
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	public class DiscoverMouseOver implements MouseOverHandler {
		@Override
		public void onMouseOver(MouseOverEvent event) {
			toolTipPopupPanel.clear();
			toolTipPopupPanel.setWidget(new DiscoverToolTip());
			toolTipPopupPanel.setStyleName("");
			tooltipTimer = new Timer() {
				public void run() {
					toolTipPopupPanel.show();
				}
			};
			if (event.getSource().equals(discoverLink)) {
				toolTipPopupPanel.setPopupPosition(event.getRelativeElement()
						.getAbsoluteLeft() - 95, event.getRelativeElement()
						.getAbsoluteTop() + 25);
			} else {
				toolTipPopupPanel.setPopupPosition(event.getRelativeElement()
						.getAbsoluteLeft() - 79, event.getRelativeElement()
						.getAbsoluteTop() + 41);
			}
			tooltipTimer.schedule(TOOLTIP_DELAY_TIME);
		}
	}
	/**
	 * 
	 * @fileName : HeaderUc.java
	 *
	 * @description : To show tooltip on Discover mouse out.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 30-Dec-2013
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	public class DiscoverMouseOut implements MouseOutHandler {

		@Override
		public void onMouseOut(MouseOutEvent event) {
			tooltipTimer.cancel();
			toolTipPopupPanel.hide();
		}
	}
	/**
	 * 
	 * @fileName : HeaderUc.java
	 *
	 * @description : To show tooltip on organize mouse over.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 30-Dec-2013
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	public class OrganizeMouseOver implements MouseOverHandler {

		@Override
		public void onMouseOver(final MouseOverEvent event) {
			GWT.log("inside oraganize mouseover");
			toolTipPopupPanel.clear();
			toolTipPopupPanel.setWidget(new OrganizeToolTip());
			toolTipPopupPanel.setStyleName("");
			if (event.getSource().equals(organizeLink)) {
				toolTipPopupPanel.setPopupPosition(event.getRelativeElement()
						.getAbsoluteLeft() - 95, event.getRelativeElement()
						.getAbsoluteTop() + 25);
			} else {
				toolTipPopupPanel.setPopupPosition(event.getRelativeElement()
						.getAbsoluteLeft() - 79, event.getRelativeElement()
						.getAbsoluteTop() + 41);
			}
			tooltipTimer = new Timer() {
				public void run() {
					toolTipPopupPanel.show();
				}
			};
			tooltipTimer.schedule(TOOLTIP_DELAY_TIME);
		}
	}
	/**
	 * 
	 * @fileName : HeaderUc.java
	 *
	 * @description : To hide tooltip on organize mouse out.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 30-Dec-2013
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	public class OrganizeMouseOut implements MouseOutHandler {

		@Override
		public void onMouseOut(MouseOutEvent event) {
			tooltipTimer.cancel();
			toolTipPopupPanel.hide();
		}
	}
	/**
	 * 
	 * @fileName : HeaderUc.java
	 *
	 * @description : To show tooltip on Teach mouse over.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 30-Dec-2013
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	public class TeachMouseOver implements MouseOverHandler {

		@Override
		public void onMouseOver(final MouseOverEvent event) {
			toolTipPopupPanel.clear();
			toolTipPopupPanel.setWidget(new TeachToolTip());
			toolTipPopupPanel.setStyleName("");
			if (event.getSource().equals(teachLink)) {
				toolTipPopupPanel.setPopupPosition(event.getRelativeElement()
						.getAbsoluteLeft() - 101, event.getRelativeElement()
						.getAbsoluteTop() + 25);
			} else {
				toolTipPopupPanel.setPopupPosition(event.getRelativeElement()
						.getAbsoluteLeft() - 85, event.getRelativeElement()
						.getAbsoluteTop() + 41);
			}
			tooltipTimer = new Timer() {
				public void run() {
					toolTipPopupPanel.show();
				}
			};
			tooltipTimer.schedule(TOOLTIP_DELAY_TIME);
		}
	}
	/**
	 * 
	 * @fileName : HeaderUc.java
	 *
	 * @description : To hide tooltip on Teach mouse out.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 30-Dec-2013
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	public class TeachMouseOut implements MouseOutHandler {

		@Override
		public void onMouseOut(MouseOutEvent event) {
			tooltipTimer.cancel();
			toolTipPopupPanel.hide();
		}

	}
	/**
	 * 
	 * @fileName : HeaderUc.java
	 *
	 * @description : To show tooltip on Study mouse over.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 30-Dec-2013
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	public class StudyMouseOver implements MouseOverHandler {

		@Override
		public void onMouseOver(final MouseOverEvent event) {
			toolTipPopupPanel.clear();
			toolTipPopupPanel.setWidget(new StudyToolTip());
			toolTipPopupPanel.setStyleName("");
			if (event.getSource().equals(studyLink)) {
				toolTipPopupPanel.setPopupPosition(event.getRelativeElement()
						.getAbsoluteLeft() - 101, event.getRelativeElement()
						.getAbsoluteTop() + 25);
			} else {
				toolTipPopupPanel.setPopupPosition(event.getRelativeElement()
						.getAbsoluteLeft() - 85, event.getRelativeElement()
						.getAbsoluteTop() + 41);
			}

			tooltipTimer = new Timer() {
				public void run() {
					toolTipPopupPanel.show();
				}
			};
			tooltipTimer.schedule(TOOLTIP_DELAY_TIME);
		}
	}
	/**
	 * 
	 * @fileName : HeaderUc.java
	 *
	 * @description : To hide tooltip on Study mouse out.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 30-Dec-2013
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	public class StudyMouseOut implements MouseOutHandler {

		@Override
		public void onMouseOut(MouseOutEvent event) {
			tooltipTimer.cancel();
			toolTipPopupPanel.hide();
		}
	}

	/*
	 * @UiHandler("gooruGuideImgLbl") public void mouseOverOnGooruGuide(final
	 * MouseOverEvent event){
	 * 
	 * 
	 * toolTipPopupPanel.clear(); toolTipPopupPanel.setWidget(new
	 * GooruGuideToolTip()); toolTipPopupPanel.setStyleName("");
	 * toolTipPopupPanel
	 * .setPopupPosition(event.getRelativeElement().getAbsoluteLeft()-215,
	 * event.getRelativeElement().getAbsoluteTop()+28); tooltipTimer=new
	 * Timer(){ public void run() { toolTipPopupPanel.show(); } };
	 * tooltipTimer.schedule(TOOLTIP_DELAY_TIME); }
	 * 
	 * @UiHandler("gooruGuideImgLbl") public void
	 * mouseOutOnGooruGuide(MouseOutEvent event){ tooltipTimer.cancel();
	 * toolTipPopupPanel.hide(); }
	 */
	/**
	 * 
	 * @function manageDotsMenuSelectionFromEvent 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : It will redirdect you to load perticular page by HeaderTabEventType.
	 * 
	 * 
	 * @parm(s) : @param tabType
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */

	public void manageDotsMenuSelectionFromEvent(HeaderTabType tabType) {

		if (tabType == HeaderTabType.DISCOVER) {
			manageDotsMenuSelection(discoverLink);
		} else if (tabType == HeaderTabType.ORGANIZE) {
			manageDotsMenuSelection(organizeLink);
		} else if (tabType == HeaderTabType.TEACH) {
			manageDotsMenuSelection(teachLink);
		} else if (tabType == HeaderTabType.STUDY) {
			manageDotsMenuSelection(studyLink);
		} else if (tabType == HeaderTabType.USERNAME) {
			manageDotsMenuSelection(loggedInfoLbl);
		} else {
			manageDotsMenuSelection(noneMenu);
		}

	}

	/**
	 * View about goorulearning link , logout link
	 * 
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */
	@UiHandler("logoutDownArrowLbl")
	public void logoutPanel(ClickEvent clickEvent) {
		int left = logoutDownArrowLbl.getAbsoluteLeft() - 57;
		int top = logoutDownArrowLbl.getAbsoluteTop() + 41;
		isSettingIcon = true;
		if (isOpenSettingDropDown) {
			showLogoutPopup(left, top);
		} else {
			logoutPanelVc.hide();
			isOpenSettingDropDown = true;
		}
	}

	/**
	 * View sign out popup
	 * 
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */
	@UiHandler("LoginLinkContainer")
	public void signoutPanel(ClickEvent clickEvent) {

		/*
		 * int left = logoutDownArrowLbl.getAbsoluteLeft() - 85; int top =
		 * logoutDownArrowLbl.getAbsoluteTop() + 13; showLogoutPopup(left, top);
		 */
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, true));
		Element e = null;
		if ((e = clickEvent.getRelativeElement()) != null) {
			if (e.getInnerHTML() != null
					&& e.getInnerHTML().contains("gwt-Label"))
				MixpanelUtil.Click_Discover_LandingPage();
		}
		manageDotsMenuSelection(loggedInfoLbl);
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", userDo.getGooruUId());
		params.put("user", userDo.getUsername());
		MixpanelUtil.Click_On_UserName();
		AppClientFactory.getPlaceManager().revealPlace(
				PlaceTokens.PROFILE_PAGE, params);

	}

	/**
	 * Search resource by entered keyword
	 * 
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */
	@UiHandler("editSearchBtn")
	public void OnSearchClick(ClickEvent clickEvent) {
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		if (getEditSearchTxtBox().getText() != null
				&& getEditSearchTxtBox().getText().length() > 0) {
			MixpanelUtil.Perform_Search(getEditSearchTxtBox().getText().trim()
					.toLowerCase(), "HeaderUc");
			Map<String, String> params = new HashMap<String, String>();
			params = updateParams(params);
			if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.COLLECTION_SEARCH)){
				AppClientFactory.getPlaceManager().revealPlace(
						PlaceTokens.COLLECTION_SEARCH, params);
			}else{
				AppClientFactory.getPlaceManager().revealPlace(
						PlaceTokens.RESOURCE_SEARCH, params);
			}
			AppClientFactory.fireEvent(new HomeEvent(HeaderTabType.NONE));
			getEditSearchTxtBox().hideSuggestionList();
		}
		
		if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.SHELF)){
			MixpanelUtil.mixpanelEvent("Perform_Search_FromOrganize");
		}else if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.STUDY)){
			MixpanelUtil.mixpanelEvent("Perform_Search_FromStudy");
		}else if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.SETTINGS)){
			MixpanelUtil.mixpanelEvent("Perform_Search_FromSettings");
		}else if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.PROFILE_PAGE)){
			MixpanelUtil.mixpanelEvent("Perform_Search_FromProfile");
		}else if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.EDIT_CLASSPAGE)){
			MixpanelUtil.mixpanelEvent("Perform_Search_FromTeach");
		}else if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.HOME)){
			MixpanelUtil.mixpanelEvent("Perform_Search_FromLandingPage");
			if(AppClientFactory.isAnonymous()){
				MixpanelUtil.mixpanelEvent("Perform_Search_FromLandingPage_Loggedout");
			}else{	
				MixpanelUtil.mixpanelEvent("Perform_Search_FromLandingPage_Loggedin");
			}
			if(AppClientFactory.getPlaceManager().getRequestParameter("courseId")!=null){
				MixpanelUtil.mixpanelEvent("Perform_Search_FromCoursePage");
			}
			if(AppClientFactory.getPlaceManager().getRequestParameter("page")!=null && AppClientFactory.getPlaceManager().getRequestParameter("page").equalsIgnoreCase("featured-contributors")){
				MixpanelUtil.mixpanelEvent("Perform_Search_FromContributorsPage");
			}
		}
		if(hasAutoSelected){
			MixpanelUtil.mixpanelEvent("Select_Autocomplete_Search");
		}
		
	}

	/**
	 * Set pagination for search
	 * 
	 * @param params
	 *            variable for Map<String,String>
	 * @return pagination values
	 */
	public Map<String, String> updateParams(Map<String, String> params) {
		params.put("query", getEditSearchText());
		params.put("pageNum", "1");
		params.put("pageSize", "8");
		return params;
	}

	/**
	 * @param text
	 *            Search keyword
	 */
	public void setEditSearchText(String text) {
		getEditSearchTxtBox().setText(text);
	}

	/**
	 * Set loggedIn user details
	 * 
	 * @param userDo
	 *            instance of {@link UserDo}
	 */
	public void setLoggedInUser(UserDo userDo) {
		this.userDo = userDo;
		if (userDo != null
				&& !userDo.getUserUid()
						.equals(AppClientFactory.GOORU_ANONYMOUS)) {
			// int flag = userDo.getViewFlag() != null ? userDo.getViewFlag() :
			// 0;
			loggedInfoLbl.setText(userDo.getUsername());
			LoginLinkContainer.setVisible(true);
			loggedInfoLbl.setVisible(true);
			logoutDownArrowLbl.setVisible(true);
			logInfoFloPanel.setVisible(false);
			if (AppClientFactory.getLoggedInUser().getConfirmStatus() == 0) {
				acctActivationPl.setVisible(true);
			}
			mainDotsPanel.setVisible(true);
			activateAllMenu();

			// gooruGuideImgLbl.addStyleName(GooruCBundle.INSTANCE.css().loggedInGooruGuideImg());
			this.switchToClassicView();

			if (userDo.isBeforeProductionSwitch()) {
				// goToClasicGooruPanel.setVisible(true);
				logoutPanelVc.displayClassicGooruLink(true);
				// goToClasicGooruPanel.getElement().getStyle().setVisibility(Visibility.VISIBLE);
			} else {
				// goToClasicGooruPanel.setVisible(false);
				logoutPanelVc.displayClassicGooruLink(false);
				// goToClasicGooruPanel.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			}

		} else {
			LoginLinkContainer.setVisible(false);
			loggedInfoLbl.setVisible(false);
			logoutDownArrowLbl.setVisible(false);
			acctActivationPl.setVisible(false);
			logInfoFloPanel.setVisible(true);
			mainDotsPanel.setVisible(false);
			// goToClasicGooruPanel.setVisible(false);
			// goToClasicGooruPanel.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			activateOnlyDiscover();
			// gooruGuideImgLbl.addStyleName(GooruCBundle.INSTANCE.css().loggedInGooruGuideImg());
			// gooruClassicViewLbl.setStyleName(GooruCBundle.INSTANCE.css().gooruClassicView());

		}
		if (AppClientFactory.getLoggedInUser() != null) {
			gooruLearning.setHref(AppClientFactory.getLoggedInUser()
					.getSettings().getHomeEndPoint());
		}
		try {
			String googleAnaltics = userDo.getSettings()
					.getGoogleAnalticsExtraAccounts();
			if (GWT.isScript() && googleAnaltics != null
					&& !googleAnaltics.startsWith("$") && !addedAccounts) {
				String[] accounts = googleAnaltics.split(",");
				for (String account : accounts) {
					String[] accountParams = account.split(":");
					if (accountParams.length == 2) {
						AppClientFactory.getInjector().getGoogleAnalytics()
								.addAccount(accountParams[0], accountParams[1]);
					}
				}
				addedAccounts = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @return search keyword
	 */
	public String getEditSearchText() {
		String searchText = getEditSearchTxtBox().getText();
		if (searchText != null && searchText.length() > 0) {
			return searchText;
		} else {
			return null;
		}
	}

	/**
	 * search KeyUpHandler.
	 * 
	 */
	private class SearchKeyUpHandler implements KeyUpHandler {

		@Override
		public void onKeyUp(KeyUpEvent event) {
			if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
				if (getEditSearchTxtBox().getText() != null
						&& getEditSearchTxtBox().getText().length() > 0) {
					if (AppClientFactory.getCurrentPlaceToken()
							.equalsIgnoreCase(PlaceTokens.TEACH)) {
						MixpanelUtil.Perform_Search_FromTeach();

					} else if (AppClientFactory.getCurrentPlaceToken()
							.equalsIgnoreCase(PlaceTokens.SHELF)) {
						MixpanelUtil.Perform_Search_FromOrganize();
					}
					if(hasAutoSelected){
						MixpanelUtil.mixpanelEvent("Select_Autocomplete_Search");	
					}
					
					MixpanelUtil.Perform_Search(getEditSearchTxtBox().getText()
							.trim().toLowerCase(), "HeaderUc");
					Map<String, String> params = new HashMap<String, String>();
					params = updateParams(params);
					if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.COLLECTION_SEARCH)){
						AppClientFactory.getPlaceManager().revealPlace(
								PlaceTokens.COLLECTION_SEARCH, params);
					}else{
						AppClientFactory.getPlaceManager().revealPlace(
								PlaceTokens.RESOURCE_SEARCH, params);
					}
					
					/*
					 * if(!(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase
					 * (PlaceTokens.COLLECTION)) ||
					 * (!(AppClientFactory.getCurrentPlaceToken
					 * ().equalsIgnoreCase(PlaceTokens.RESOURCE_SEARCH)))){
					 * editSearchTxtBox.setText(""); }
					 */
					if ((AppClientFactory.getCurrentPlaceToken()
							.equalsIgnoreCase(PlaceTokens.SHELF))
							|| (AppClientFactory.getCurrentPlaceToken()
									.equalsIgnoreCase(PlaceTokens.STUDY) || (AppClientFactory
									.getCurrentPlaceToken()
									.equalsIgnoreCase(PlaceTokens.TEACH)))
							|| (AppClientFactory.getCurrentPlaceToken()
									.equalsIgnoreCase(PlaceTokens.SETTINGS))
							|| (AppClientFactory.getCurrentPlaceToken()
									.equalsIgnoreCase(PlaceTokens.PROFILE_PAGE))) {
						getEditSearchTxtBox().setText("");
					}

					AppClientFactory.fireEvent(new HomeEvent(
							HeaderTabType.DISCOVER));
					getEditSearchTxtBox().hideSuggestionList();
				}
			}
		}
	}

	/**
	 * To show tooltip on study click
	 * 
	 */
	private class studyClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			isStudyNow = true;
			if (isClassCodePopupOpen) {
				if(studyNowToolTip!=null && studyNowToolTip.isShowing()){
					studyNowToolTip.hide();
				}else{
					studyNowToolTip = new StudyNowToolTip();
					studyNowToolTip.getElement().getStyle()
							.setBackgroundColor("transparent");
					studyNowToolTip.getElement().getStyle()
							.setPosition(Position.ABSOLUTE);
					studyNowToolTip.setPopupPosition(event.getRelativeElement()
							.getAbsoluteLeft() - (150 + 22), event
							.getRelativeElement().getAbsoluteTop() + 22);
					studyNowToolTip.show();
					getEditSearchTxtBox().setText("");
					ClickHandler handler = new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							studyNowToolTip.show();
							isStudyNow = true;
						}
					};
					studyNowToolTip.addDomHandler(handler, ClickEvent.getType());
					isClassCodePopupOpen = false;
				}
				
			} else {
				studyNowToolTip.hide();
				isClassCodePopupOpen = true;
			}
			
			 Window.addWindowScrollHandler(new Window.ScrollHandler() {
			       public void onWindowScroll(Window.ScrollEvent event) {
			    	   studyNowToolTip.getElement().getStyle()
						.setPosition(Position.FIXED);	
//			    	   studyNowToolTip.setPopupPosition(event.getScrollLeft(),event.getScrollTop());
			    	   studyNowToolTip.setPopupPosition(950,33);
			       }
			    });
		}
	}

	/**
	 * View or hide search bar in header
	 * 
	 * @param enabled
	 *            to view or hide
	 */
	public void setSearchBarEnabled(boolean enabled) {
		editSearchInputFloPanel.setVisible(enabled);
	}

	/**
	 * Set classic link location
	 * 
	 * @param enabled
	 *            to left view or right view
	 */
	public void setClassicButtonEnabled(boolean enabled) {
		/*
		 * if (enabled) {
		 * gooruClassicViewLbl.getElement().getStyle().setFloat(Float.RIGHT); }
		 * else {
		 */
		// gooruClassicViewLbl.getElement().getStyle().setFloat(Float.LEFT);
		/* } */
	}

	/**
	 * Set logout popup location
	 * 
	 * @param left
	 *            value to set popup location from left
	 * @param top
	 *            value to set popup location from top
	 */
	public void showLogoutPopup(int left, int top) {
		logoutPanelVc.setWidth("80px");
		logoutPanelVc.setStyleName(GooruCBundle.INSTANCE.css().logoutPopup());
		logoutPanelVc.setPopupPosition(left, top);
		logoutPanelVc.show();
		isOpenSettingDropDown = false;
	}

	/**
	 * To view the gooru guide panel
	 * 
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */
	/*
	 * @UiHandler("gooruGuideImgLbl") public void gooruGuideLabel(ClickEvent
	 * clickEvent) { MixpanelUtil.Click_On_Help(); // openGooruGuide(); }
	 */
	/**
	 * To view the gooru guide panel
	 * 
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */
	/*
	 * @UiHandler("gooruGuidePanel") public void gooruGuidePanel(ClickEvent
	 * clickEvent) { tooltipTimer.cancel(); toolTipPopupPanel.hide();
	 * Window.enableScrolling(false); openGooruGuide(); }
	 */
	/**
	 * To set the top position.
	 */
	public void openGooruGuide() {
		// int left = logoutDownArrowLbl.getAbsoluteLeft() -1160 ;
		int top = logoutDownArrowLbl.getAbsoluteTop() + 53;

	}

	/*
	 * public int getGooruGuideIconLeft() { return
	 * gooruGuideImgLbl.getAbsoluteLeft(); }
	 */

	/*
	 * public int getGooruGuideIconTop() { return
	 * gooruGuideImgLbl.getAbsoluteTop(); }
	 */

	/**
	 * Allow the user to go classic view of gooru
	 */
	public void switchToClassicView() {
		// gooruClassicViewLbl.addClickHandler(new ClickHandler() {
		//
		// @Override
		// public void onClick(ClickEvent event) {
		// Window.Location.replace(AppClientFactory.getLoggedInUser().getSettings().getClassicEndPoint());
		//
		// }
		// });
	}
	/**
	 * 
	 * @function showTeachPanelAsPopup 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :To set showTeachPanelAsPopup.
	 * 
	 * 
	 * @parm(s) : @param left
	 * @parm(s) : @param top
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void showTeachPanelAsPopup(int left, int top) {
		if (classpageListVc == null) {
			classpageListVc = new ClasspageListVc();
		}

		classpageListVc.setWidth("202px !important");
		classpageListVc.setHeight("246px !important");
		classpageListVc.setStyleName(HomeCBundle.INSTANCE.css()
				.classpageListContainer());
		classpageListVc.setPopupPosition(left, top);
		classpageListVc.show();
		// classpageListVc.getAllClasspages();
	}

	/**
	 * ReSend confirmation mail to user.
	 * 
	 * @param params
	 *            contains gooruUid, accountType
	 */

	public class ResendEmailConfirmation implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			Map<String, String> params = new HashMap<String, String>();
			params.put(GOORU_UID, userDo.getGooruUId());

			if (userDo.getAccountTypeId() == 2
					|| userDo.getAccountTypeId() == 1) {
				params.put(ACCOUNT_TYPE, "Parent");
			} else {
				params.put(ACCOUNT_TYPE, "NonParent");
			}

			AppClientFactory
					.getInjector()
					.getUserService()
					.resendConfirmationMail(params,
							new SimpleAsyncCallback<Object>() {
								@Override
								public void onSuccess(Object result) {

								}
							});
		}

	}
	/**
	 * On selection it will load either collection search or resource search.
	 */
	@Override
	public void onSelection(SelectionEvent<Suggestion> event) {
		String searchText = editSearchTxtBox.getText();
		searchText= searchText.replaceAll("-<n> Gooru Search</n>", "");
		editSearchTxtBox.setText(searchText.trim());
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		if (editSearchTxtBox.getText() != null && editSearchTxtBox.getText().length() > 0) {
			MixpanelUtil.Perform_Search(editSearchTxtBox.getText().trim().toLowerCase(),"HeaderUc");
			Map<String, String> params = new HashMap<String, String>();
			params = updateParams(params);
			if (AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(
					PlaceTokens.COLLECTION_SEARCH)) {
				AppClientFactory.getPlaceManager().revealPlace(
						PlaceTokens.COLLECTION_SEARCH, params);
			} else {
				AppClientFactory.getPlaceManager().revealPlace(
						PlaceTokens.RESOURCE_SEARCH, params);
			}
			editSearchTxtBox.setText("");
			AppClientFactory.fireEvent(new HomeEvent(HeaderTabType.DISCOVER));
			editSearchTxtBox.hideSuggestionList();
		}
		
		hasAutoSelected=true;
		MixpanelUtil.mixpanelEvent("Select_Autocomplete_Search");
		getEditSearchTxtBox().setText(searchText.trim());

	}
	/**
	 * @return suggestion standards for the collection as map string
	 */
	public void requestAutoSuggestKeyword(
			SearchDo<AutoSuggestKeywordSearchDo> searchDo) {
		getAutoSuggestionKeyWordAsyncCallback().execute(searchDo);
	}
	/**
	 * @return suggestion standards for the collection as map string
	 */
	public void setAutoKeyWordSuggestions(
			SearchDo<AutoSuggestKeywordSearchDo> autoSuggestKeywordDo) {
		autokeySuggestOracle.clear();
		this.autoSuggestKeywordDo = autoSuggestKeywordDo;
		searchData = searchData + GOORU_SEARCH;
		autokeySuggestOracle.add(searchData);
		if (this.autoSuggestKeywordDo.getSearchResults() != null) {
			for (AutoSuggestKeywordSearchDo autoSuggestKeywordSearchDo : autoSuggestKeywordDo
					.getSearchResults()) {
				autokeySuggestOracle.add(autoSuggestKeywordSearchDo
						.getKeyword());
			}
		}
		getEditSearchTxtBox().showSuggestionList();

	}

	/**
	 * @return suggestion standards for the collection as map string
	 */
	public SearchAsyncCallback<SearchDo<AutoSuggestKeywordSearchDo>> getAutoSuggestionKeyWordAsyncCallback() {
		if (autoKeyWordSuggestionAsyncCallback == null) {
			autoKeyWordSuggestionAsyncCallback = new SearchAsyncCallback<SearchDo<AutoSuggestKeywordSearchDo>>() {

				@Override
				protected void run(SearchDo<AutoSuggestKeywordSearchDo> searchDo) {
					AppClientFactory.getInjector().getSearchService()
							.getSuggestedAutokeyword(searchDo, this);

				}

				@Override
				public void onCallSuccess(
						SearchDo<AutoSuggestKeywordSearchDo> result) {
					setAutoKeyWordSuggestions(result);

				}

			};
		}
		return autoKeyWordSuggestionAsyncCallback;
	}
	/**
	 * 
	 * @function getEditSearchTxtBox 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : returns editSearchTxtBox.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : AppSuggestBox
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public AppSuggestBox getEditSearchTxtBox() {
		return editSearchTxtBox;
	}
	/**
	 * 
	 * @function setEditSearchTxtBox 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : setter method for editSearchTxtBox.
	 * 
	 * 
	 * @parm(s) : @param editSearchTxtBox
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setEditSearchTxtBox(AppSuggestBox editSearchTxtBox) {
		this.editSearchTxtBox = editSearchTxtBox;
	}
	/**
	 * 
	 * @function setDiscoverLinkFromLibrary 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :setter method for discoverLinkUrl.
	 * 
	 * 
	 * @parm(s) : @param discoverLink
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setDiscoverLinkFromLibrary(String discoverLink) {
		this.discoverLinkUrl = discoverLink;
	}
	/**
	 * This method is called immediately after a widget becomes attached to the browser's document.
	 */
	@Override
	protected void onLoad() {
		// TODO Auto-generated method stub
		//super.onLoad();
		getEditSearchTxtBox().setFocus(true);
	}

}
