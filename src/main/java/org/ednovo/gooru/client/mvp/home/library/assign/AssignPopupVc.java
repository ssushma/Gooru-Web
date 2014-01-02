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
package org.ednovo.gooru.client.mvp.home.library.assign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.home.ForgotPasswordVc;
import org.ednovo.gooru.client.mvp.home.event.SetTexasAccountEvent;
import org.ednovo.gooru.client.mvp.home.event.SetTexasPlaceHolderEvent;
import org.ednovo.gooru.client.mvp.home.event.SetUserDetailsInCollectionPlayEvent;
import org.ednovo.gooru.client.mvp.home.event.SetUserDetailsInPlayEvent;
import org.ednovo.gooru.client.mvp.home.library.events.SetLoginStatusEvent;
import org.ednovo.gooru.client.mvp.home.library.events.SetLoginStatusHandler;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderEvent;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.service.ClasspageServiceAsync;
import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.client.uc.AlertMessageUc;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.client.uc.ShareViewUc;
import org.ednovo.gooru.client.uc.TextBoxWithPlaceholder;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.content.AssignmentsListDo;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.social.SocialShareDo;
import org.ednovo.gooru.shared.model.user.UserDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : AssignPopupVc.java
 *
 * @description : Related to AssignmentPopup.
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
public abstract class AssignPopupVc extends PopupPanel {

	@UiField
	HTMLPanel socialSharePanel,loadingImageLabel,popupContentAssign;

	@UiField
	HTMLEventPanel htmlEvenPanelContainer;
	@UiField
	HTMLEventPanel htmlLoginPanel;

	@UiField
	TextBoxWithPlaceholder loginTxtBox;

	@UiField
	TextBoxWithPlaceholder passwordTxtBox;

	@UiField
	Button loginButton;

	@UiField
	TextArea shareLinkTxtBox;

	@UiField
	Anchor forgotPwd,ancSignUp;

	@UiField
	Label lblPleaseWait, swithUrlLbl, swithToEmbedLbl;

	private boolean isPrivate = false;
	private static final String SWITCH_FULL_URL = "Switch to full URL";
	private static final String SWITCH_EMBED_CODE = "Switch to embed code";
	private static final String SWITCH_BITLY = "Switch to Bit.ly";
	private static final String SWITCH_URL_LABEL = "swithUrlLbl";
	private static final String SWITCH_TO_EMBED_LABEL = "swithToEmbedLbl";
	private String bitlyLink, decodeRawUrl, embedBitlyLink, rawUrl;
	private static final String OOPS = MessageProperties.GL0061;
	private static final String LOGIN_ERROR = MessageProperties.GL0347;
	private static final String LOGIN_COOKIE_DISABLE_MESSAGE = MessageProperties.GL0348;
	private SimpleAsyncCallback<Map<String, String>> shareUrlGenerationAsyncCallback;
	private ClasspageServiceAsync classpageService;
	private SimpleAsyncCallback<ClasspageListDo> getClasspageList;
	private SimpleAsyncCallback<AssignmentsListDo> assignmentsListAsyncCallback;
	private SimpleAsyncCallback<CollectionDo> collectionDoAsyncCallback;
	String shareType = null;
	ShareViewUc shareContainer;
	HTMLPanel ftmPanel;
	String toAssignStr = null;
	String limit = "10";// pagesize
	int classpageOffSet = 0;
	int assignmentOffSet = 0;
	boolean isApiCalling = false;
	boolean toClear = true;
	boolean isAdded = false;
	List<String> collectionsList = new ArrayList<String>();
	boolean toClearAssignment = true;
	boolean isAssignmentsEnabled = false;
	CollectionDo collectionDoGlobal = null;
	String classpageId = null;
	String assignmentId = null;
	boolean isMoreThanLimit = false; // Limit = 10
	private static AssignPopupVcUiBinder uiBinder = GWT
			.create(AssignPopupVcUiBinder.class);

	public interface AssignPopupVcUiBinder extends
			UiBinder<Widget, AssignPopupVc> {
	}

	@UiField(provided = true)
	AssignPopUpCBundle res;

	@UiTemplate("AssignPopupVc.ui.xml")
	interface Binder extends UiBinder<Widget, AssignPopupVc> {

	}

	private static final Binder binder = GWT.create(Binder.class);



	/**
	 * Constructor
	 */
	public AssignPopupVc(String collectionIdVal) {
		super(false);
		
	
		res = AssignPopUpCBundle.INSTANCE;
		AssignPopUpCBundle.INSTANCE.css().ensureInjected();
		add(uiBinder.createAndBindUi(this));
		this.setGlassEnabled(true);
		
		AppClientFactory.getEventBus().addHandler(SetLoginStatusEvent.TYPE, setLoginStatusHandler);

		setLabelsAndIds();
		setHandlers();
		
		shareContainer = new ShareViewUc("", "");
		ftmPanel = new HTMLPanel("");

		htmlLoginPanel.setVisible(false);
		
		loadingImageLabel.setVisible(true);
		popupContentAssign.setVisible(false);

		AppClientFactory.getInjector().getClasspageService().getSCollIdClasspageById(collectionIdVal, new AsyncCallback<CollectionDo>(){

			@Override
			public void onFailure(Throwable caught) {
		
				
			}

			@Override
			public void onSuccess(CollectionDo result) {
	
				String collectionId = "";



				if (result.getGooruOid() != null) {
					collectionId = result.getGooruOid();
				} else {
					collectionId = "4b4bb39d-2892-4dd6-bd7f-5fd1227751de";
				}

				toAssignStr = collectionId;

				if (collectionId != null) {

					collectionDoGlobal = result;

					if (AppClientFactory.isAnonymous()) {
						hideContainers();

					} else {
						loadListContainers();

					}
					generateShareLink(toAssignStr);

				}


				
				loadingImageLabel.setVisible(false);
				popupContentAssign.setVisible(true);

			
			}
		});
		
		Window.enableScrolling(false);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, false));
		this.center();	
	}
	/**
	 * 
	 * @function hideContainers 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This will hide htmlEvenPanelContainer and enable htmlLoginPanel.
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
	public void hideContainers() {
		htmlEvenPanelContainer.setVisible(false);
		htmlLoginPanel.setVisible(true);

	}
	/**
	 * 
	 * @function loadListContainers 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :
	 * 
	 * 
	 * @parm(s) : To hide the Popup.
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void loadListContainers() {

		AssignCollectionView assignWidget = new AssignCollectionView(
				collectionDoGlobal) {

			@Override
			public void closePoupfromChild() {
				closePoup();

			}
		};
		htmlEvenPanelContainer.add(assignWidget);
		htmlEvenPanelContainer.setVisible(true);
		htmlLoginPanel.setVisible(false);

	}

	public abstract void closePoup();

	/**
	 * Added click handler to hide the login popup.
	 * 
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */
	@UiHandler("cancelButton")
	public void onCancelClicked(ClickEvent clickEvent) {
		closePoup();
	}

	/**
	 * 
	 * @function setLabelsAndIds
	 * 
	 * @created_date : Jul 30, 2013
	 * 
	 * @description To set the default values for labels, button and id for
	 *              button.
	 * 
	 * @parm(s) : NONE
	 * 
	 * @return : void
	 * 
	 * @throws : <Mentioned if any exceptions>
	 * 
	 * 
	 * 
	 * 
	 */
	public void setLabelsAndIds() {

		forgotPwd.getElement().setId("lnkForgotPwd");
		loginTxtBox.setPlaceholder(MessageProperties.GL0202);
		loginTxtBox.getElement().setAttribute("placeholder",
				MessageProperties.GL0202);
		loginTxtBox.setFocus(true);
		passwordTxtBox.setPlaceholder(MessageProperties.GL0204);
		forgotPwd.setText(MessageProperties.GL0205);
		loginButton.setText(MessageProperties.GL0187);

		lblPleaseWait.setText(MessageProperties.GL0242);

		loginTxtBox.getElement().setId("tbLoginUsername");
		passwordTxtBox.getElement().setId("tbLoginPassword");
		loginButton.getElement().setId("btnLogin");

		lblPleaseWait.setVisible(false);

		shareLinkTxtBox.setReadOnly(true);
		shareLinkTxtBox.addClickHandler(new OnClickShareHandler());

	}
	/**
	 * 
	 * @function onClickSwithUrl 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This will deals with share url's.
	 * 
	 * 
	 * @parm(s) : @param clickevent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("swithUrlLbl")
	public void onClickSwithUrl(ClickEvent clickevent) {
		if (!getIsPrivate()) {
			changeShareUrlEvents(SWITCH_BITLY);
		}
	}
	/**
	 * 
	 * @function getIsPrivate 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :Returns isPrivate.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : boolean
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public boolean getIsPrivate() {
		return isPrivate;
	}
	/**
	 * 
	 * @function setPrivate 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :To initialize isPrivate.
	 * 
	 * 
	 * @parm(s) : @param isPrivate
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
		setSwitchButtonStyles();
	}
	/**
	 * 
	 * @function setSwitchButtonStyles 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This is used to set styles to Switch button.
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
	public void setSwitchButtonStyles() {
		if (getIsPrivate()) {
			swithToEmbedLbl.getElement().getStyle().setCursor(Cursor.DEFAULT);
			swithUrlLbl.getElement().getStyle().setCursor(Cursor.DEFAULT);
		} else {
			swithToEmbedLbl.getElement().getStyle().setCursor(Cursor.POINTER);
			swithUrlLbl.getElement().getStyle().setCursor(Cursor.POINTER);
		}
	}
	/**
	 * 
	 * @function changeShareUrlEvents 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This is used to change share url events.
	 * 
	 * 
	 * @parm(s) : @param buttonType
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	private void changeShareUrlEvents(String buttonType) {
		if (swithToEmbedLbl.getText().equalsIgnoreCase(SWITCH_BITLY)
				&& swithUrlLbl.getText().equalsIgnoreCase(SWITCH_EMBED_CODE)) {
			if (buttonType.equalsIgnoreCase(SWITCH_TO_EMBED_LABEL)) {
				shareLinkTxtBox.setText(bitlyLink);
				swithUrlLbl.setText(SWITCH_EMBED_CODE);
				swithToEmbedLbl.setText(SWITCH_FULL_URL);
			} else {
				shareLinkTxtBox.setText(getIframeText());
				swithUrlLbl.setText(SWITCH_FULL_URL);
				swithToEmbedLbl.setText(SWITCH_BITLY);
			}
		} else if (swithToEmbedLbl.getText()
				.equalsIgnoreCase(SWITCH_EMBED_CODE)
				&& swithUrlLbl.getText().equalsIgnoreCase(SWITCH_BITLY)) {
			if (buttonType.equalsIgnoreCase(SWITCH_TO_EMBED_LABEL)) {
				shareLinkTxtBox.setText(getIframeText());
				swithUrlLbl.setText(SWITCH_BITLY);
				swithToEmbedLbl.setText(SWITCH_FULL_URL);
			} else {
				shareLinkTxtBox.setText(bitlyLink);
				swithUrlLbl.setText(SWITCH_FULL_URL);
				swithToEmbedLbl.setText(SWITCH_EMBED_CODE);
			}
		} else if (swithToEmbedLbl.getText().equalsIgnoreCase(SWITCH_FULL_URL)
				&& swithUrlLbl.getText().equalsIgnoreCase(SWITCH_EMBED_CODE)) {
			if (buttonType.equalsIgnoreCase(SWITCH_TO_EMBED_LABEL)) {
				shareLinkTxtBox.setText(decodeRawUrl);
				fullUrlMixPanelEvent();
				swithUrlLbl.setText(SWITCH_EMBED_CODE);
				swithToEmbedLbl.setText(SWITCH_BITLY);
			} else {
				shareLinkTxtBox.setText(getIframeText());
				swithUrlLbl.setText(SWITCH_BITLY);
				swithToEmbedLbl.setText(SWITCH_FULL_URL);
			}
		} else if (swithToEmbedLbl.getText()
				.equalsIgnoreCase(SWITCH_EMBED_CODE)
				&& swithUrlLbl.getText().equalsIgnoreCase(SWITCH_FULL_URL)) {
			if (buttonType.equalsIgnoreCase(SWITCH_TO_EMBED_LABEL)) {
				shareLinkTxtBox.setText(getIframeText());
				swithUrlLbl.setText(SWITCH_FULL_URL);
				swithToEmbedLbl.setText(SWITCH_BITLY);
			} else {
				shareLinkTxtBox.setText(decodeRawUrl);
				fullUrlMixPanelEvent();
				swithUrlLbl.setText(SWITCH_BITLY);
				swithToEmbedLbl.setText(SWITCH_EMBED_CODE);
			}
		} else if (swithToEmbedLbl.getText().equalsIgnoreCase(SWITCH_BITLY)
				&& swithUrlLbl.getText().equalsIgnoreCase(SWITCH_FULL_URL)) {
			if (buttonType.equalsIgnoreCase(SWITCH_TO_EMBED_LABEL)) {
				shareLinkTxtBox.setText(bitlyLink);
				swithUrlLbl.setText(SWITCH_FULL_URL);
				swithToEmbedLbl.setText(SWITCH_EMBED_CODE);
			} else {
				shareLinkTxtBox.setText(decodeRawUrl);
				fullUrlMixPanelEvent();
				swithUrlLbl.setText(SWITCH_EMBED_CODE);
				swithToEmbedLbl.setText(SWITCH_BITLY);
			}
		} else if (swithToEmbedLbl.getText().equalsIgnoreCase(SWITCH_FULL_URL)
				&& swithUrlLbl.getText().equalsIgnoreCase(SWITCH_BITLY)) {
			if (buttonType.equalsIgnoreCase(SWITCH_TO_EMBED_LABEL)) {
				shareLinkTxtBox.setText(decodeRawUrl);
				fullUrlMixPanelEvent();
				swithUrlLbl.setText(SWITCH_BITLY);
				swithToEmbedLbl.setText(SWITCH_EMBED_CODE);
			} else {
				shareLinkTxtBox.setText(bitlyLink);
				swithUrlLbl.setText(SWITCH_EMBED_CODE);
				swithToEmbedLbl.setText(SWITCH_FULL_URL);
			}
		}
	}

	private void fullUrlMixPanelEvent() {
		/*
		 * if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.
		 * COLLECTION_SEARCH)){ MixpanelUtil.Share_direct_search(); } else
		 * if(AppClientFactory
		 * .getCurrentPlaceToken().equals(PlaceTokens.SHELF)){
		 * MixpanelUtil.Share_direct_collection_edit(); }
		 */
	}
	/**
	 * 
	 * @function getIframeText 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This method is used to get the iframe text.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	private String getIframeText() {
		String iframeText = null;
		if (embedBitlyLink == null) {
			embedBitlyLink = shareLinkTxtBox.getText();
		}
		iframeText = "<iframe width=\"1024px\" height=\"768px\" src=\""
				+ bitlyLink + "\" frameborder=\"0\" ></iframe>";
		
		return iframeText;
	}

	/**
	 * Switching between Url and Bitly link
	 * 
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */
	@UiHandler("swithToEmbedLbl")
	public void onClickSwithToEmbed(ClickEvent clickevent) {
		if (!getIsPrivate()) {
			changeShareUrlEvents(SWITCH_TO_EMBED_LABEL);
		}
	}
	/**
	 * 
	 * @function setShareUrlGenerationAsyncCallback 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :To set shareUrlGenerationAsyncCallback
	 * 
	 * 
	 * @parm(s) : @param shareShortenUrlAsyncCallback
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setShareUrlGenerationAsyncCallback(
			SimpleAsyncCallback<Map<String, String>> shareShortenUrlAsyncCallback) {
		this.shareUrlGenerationAsyncCallback = shareShortenUrlAsyncCallback;
	}
	/**
	 * 
	 * @function getShareShortenUrlAsyncCallback 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :Returns shareUrlGenerationAsyncCallback.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : SimpleAsyncCallback<Map<String,String>>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public SimpleAsyncCallback<Map<String, String>> getShareShortenUrlAsyncCallback() {
		return shareUrlGenerationAsyncCallback;
	}
	/**
	 * 
	 * @function generateShareLink 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This ethod is used to generate share link.
	 * 
	 * 
	 * @parm(s) : @param classpageId
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void generateShareLink(String classpageId) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("type", "");
		params.put("shareType", "");

		AppClientFactory
				.getInjector()
				.getSearchService()
				.getShortenShareUrl(classpageId, params,
						new AsyncCallback<Map<String, String>>() {

							@Override
							public void onFailure(Throwable caught) {

							}

							@Override
							public void onSuccess(Map<String, String> result) {
								decodeRawUrl = result.get("decodeRawUrl");
								shareLinkTxtBox.setText(decodeRawUrl);
								bitlyLink = result.get("shortenUrl");
								rawUrl = result.get("rawUrl");
								addShareWidgetInPlay(decodeRawUrl, rawUrl,
										collectionDoGlobal.getTitle(),
										collectionDoGlobal.getDescription(),
										bitlyLink, "",
										collectionDoGlobal.getSharing());
								// addShareWidgetInPlay(decodeRawUrl,rawUrl,
								// "","",bitlyLink,"","");

							}

						});

	}
	/**
	 * 
	 * @function addShareWidgetInPlay 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This is used to add the share widget in play.
	 * 
	 * 
	 * @parm(s) : @param link
	 * @parm(s) : @param rawUrl
	 * @parm(s) : @param title
	 * @parm(s) : @param desc
	 * @parm(s) : @param shortenUrl
	 * @parm(s) : @param type
	 * @parm(s) : @param shareType
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void addShareWidgetInPlay(String link, String rawUrl, String title,
			String desc, String shortenUrl, String type, String shareType) {
		try {
			SocialShareDo shareDo = new SocialShareDo();
			shareDo.setBitlylink(link);
			shareDo.setRawUrl(rawUrl);
			shareDo.setTitle(title);
			shareDo.setDescription(desc);
			shareDo.setThumbnailurl(shortenUrl);
			shareDo.setCategoryType(type);
			shareDo.setOnlyIcon(false);
			shareDo.setShareType(shareType);
			SocialShareSmallView socialView = new SocialShareSmallView(shareDo);
			ftmPanel.add(socialView);
			socialSharePanel.add(ftmPanel);
		} catch (Exception ex) {

		}
	}

	/**
	 * Added click handler to perform Login operation by taking entered user
	 * name and password from the user.
	 * 
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */

	@UiHandler("loginButton")
	public void onLoginClicked(ClickEvent clickEvent) {

		if (isCookieEnabled()) {

			String username = loginTxtBox.getText().trim();
			String password = passwordTxtBox.getText().trim();

			JSONObject login = new JSONObject();
			login.put("username", new JSONString(username));
			login.put("password", new JSONString(password));

			if (username.length() > 1 && password.length() > 1) {

				loginButton.setVisible(false);
				lblPleaseWait.setVisible(true);

				AppClientFactory.getInjector().getAppService().v2Signin(login.toString(), new SimpleAsyncCallback<UserDo>() {
									@Override
									public void onSuccess(UserDo result) {
										MixpanelUtil.Regular_User_Logged_In();
										AppClientFactory.setLoggedInUser(result);
										AppClientFactory.fireEvent(new SetUserDetailsInPlayEvent(result.getToken()));
										AppClientFactory.fireEvent(new SetUserDetailsInCollectionPlayEvent(result.getToken(),result.getGooruUId()));

										AppClientFactory.fireEvent(new SetHeaderEvent(result));

										if (result.getUsername().equalsIgnoreCase("TexasTeacher")) {
											AppClientFactory.fireEvent(new SetTexasAccountEvent("failure"));
											AppClientFactory.fireEvent(new SetTexasPlaceHolderEvent(true));
										} else {
											AppClientFactory.fireEvent(new SetTexasAccountEvent("success"));
											AppClientFactory.fireEvent(new SetTexasPlaceHolderEvent(false));
										}

										AppClientFactory.setUserflag(true);
										AppClientFactory.resetPlace();

										loadListContainers();
										MixpanelUtil.mixpanelEvent("Login_FromAssign_Pop-up");
									}

									@Override
									public void onFailure(Throwable caught) {
										loginButton.setVisible(true);
										lblPleaseWait.setVisible(false);
										new AlertContentUc(OOPS, LOGIN_ERROR);
									}
								});
			} else {
				loginButton.setVisible(true);
				lblPleaseWait.setVisible(false);
				new AlertContentUc(OOPS, LOGIN_ERROR);
			}
		} else {
			loginButton.setVisible(true);
			lblPleaseWait.setVisible(false);
			new AlertMessageUc("Aww!", new HTML(LOGIN_COOKIE_DISABLE_MESSAGE));
		}

	}

	/**
	 * creating inner class implementing KeyUpHandler interface.
	 * 
	 */
	public class LoginKeyupHandler implements KeyUpHandler {

		@Override
		public void onKeyUp(KeyUpEvent event) {
			if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
				onLoginClicked(null);
			}
		}

	}
	/**
	 * 
	 * @function setHandlers 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This method is used to set the Handlers.
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
	private void setHandlers() {

		this.setSize("515px", "547px");

		loginTxtBox.addKeyUpHandler(new LoginKeyupHandler());
		passwordTxtBox.addKeyUpHandler(new LoginKeyupHandler());
	}
	/**
	 * 
	 * @function onForgotPwdClicked 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This is used to show Forgot Password popup.
	 * 
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("forgotPwd")
	public void onForgotPwdClicked(ClickEvent clickEvent) {

		ForgotPasswordVc forgotPasswordVc = new ForgotPasswordVc();
		forgotPasswordVc.setGlassEnabled(true);
		forgotPasswordVc.show();
		forgotPasswordVc.center();
		closePoup();
	}
	/**
	 * 
	 * @function onSignUp 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :ancSignUp UIHandler.
	 * 
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("ancSignUp")
	public void onSignUp(ClickEvent clickEvent) {
		MixpanelUtil.mixpanelEvent("Library_Assign_Signup");
		Map<String, String> params = new HashMap<String, String>();
		params.put("callback", "signup");
		params.put("type", "1");
		AppClientFactory.getPlaceManager().revealPlace(
				AppClientFactory.getCurrentPlaceToken(), params);
		closePoup();
	}
	/**
	 * 
	 * @fileName : AssignPopupVc.java
	 *
	 * @description : On click of this UIHandler this will enable  focus in shareLinkTxtBox.
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
	public class OnClickShareHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			shareLinkTxtBox.selectAll();
			shareLinkTxtBox.setFocus(true);
		}

	}
	/**
	 * To load ListContainers.
	 */
	SetLoginStatusHandler setLoginStatusHandler = new SetLoginStatusHandler() {
		@Override
		public void setLoginStatusHandler(boolean isLoggedIn) {
			if(isLoggedIn) {
				loadListContainers();
			}
		}
	};
	/**
	 * 
	 * @function isCookieEnabled 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :To check wheather the cookie is enabled or not.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : boolean
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	private static native boolean isCookieEnabled() /*-{
													return navigator.cookieEnabled;
													}-*/;
}
