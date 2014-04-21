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
package org.ednovo.gooru.client.mvp.play.collection.preview.home.assign;

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
import org.ednovo.gooru.client.mvp.home.library.assign.AssignCollectionView;
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
import org.ednovo.gooru.shared.util.StringUtil;

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
 * @author BLR Team
 * 
 */
public abstract class AssignPopupPlayerVc extends PopupPanel implements MessageProperties{

	@UiField
	HTMLPanel loadingImageLabel,popupContentAssign;

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
	Label lblPleaseWait, swithUrlLbl, swithToEmbedLbl,assignDes,lblAssignPopDes,lblAssignTitle,lblpopupTitle,lblLoginPopupTitle,donothaveAccountText;

	private boolean isPrivate = false;
	private static final String SWITCH_FULL_URL = GL0643;
	private static final String SWITCH_EMBED_CODE = GL0640;
	private static final String SWITCH_BITLY = GL0639;
	private static final String SWITCH_URL_LABEL = "swithUrlLbl";
	private static final String SWITCH_TO_EMBED_LABEL = "swithToEmbedLbl";
	private String bitlyLink, decodeRawUrl, embedBitlyLink, rawUrl;
	private static final String OOPS = GL0061;
	private static final String LOGIN_ERROR = GL0347;
	private static final String LOGIN_COOKIE_DISABLE_MESSAGE =GL0348;
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
	private static AssignPopupPlayerVcUiBinder uiBinder = GWT
			.create(AssignPopupPlayerVcUiBinder.class);

	public interface AssignPopupPlayerVcUiBinder extends
	UiBinder<Widget, AssignPopupPlayerVc> {
	}

	@UiField(provided = true)
	AssignPopUpCBundle res;

	@UiTemplate("AssignPopupPlayerVc.ui.xml")
	interface Binder extends UiBinder<Widget, AssignPopupPlayerVc> {

	}

	private static final Binder binder = GWT.create(Binder.class);



	/**
	 * 
	 */
	public AssignPopupPlayerVc(String collectionIdVal) {
		super(false);


		res = AssignPopUpCBundle.INSTANCE;
		AssignPopUpCBundle.INSTANCE.css().ensureInjected();
		add(uiBinder.createAndBindUi(this));
		this.setGlassEnabled(true);
		donothaveAccountText.getElement().setInnerHTML(GL0634);
		donothaveAccountText.getElement().setAttribute("style", "float: left;margin-left: 22%;");
		ancSignUp.setText(GL0207+GL_SPL_EXCLAMATION);
		swithUrlLbl.setText(GL0639);
		swithToEmbedLbl.setText(GL0640);
		ancSignUp.getElement().setAttribute("style", "float: left;margin-left: 2%;");


		setLabelsAndIds();
		setHandlers();

		shareContainer = new ShareViewUc("", "");
		ftmPanel = new HTMLPanel("");

		htmlLoginPanel.setVisible(false);

		loadingImageLabel.setVisible(true);
		popupContentAssign.setVisible(false);

		try
		{

			AppClientFactory.getInjector().getClasspageService().getSCollIdClasspageById(collectionIdVal, new AsyncCallback<CollectionDo>(){

				@Override
				public void onFailure(Throwable caught) {


				}

				@Override
				public void onSuccess(CollectionDo result) {
					MixpanelUtil.Preview_Click_Assign_successful();
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
		}
		catch(Exception ex)
		{
			ex.printStackTrace();	
		}
		setShareUrlGenerationAsyncCallback(new SimpleAsyncCallback<Map<String,String>>() {
			
			@Override
			public void onSuccess(Map<String, String> result) {
				embedBitlyLink=result.get("decodeRawUrl");
			}
		});
		Window.enableScrolling(false);
		this.getElement().setAttribute("style", "z-index:99999;");
		this.getGlassElement().setAttribute("style", "z-index:99999; position:absolute; left:0px; top:0px;");

		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99999, false));
		this.center();	
	}

	public void hideContainers() {
		htmlEvenPanelContainer.setVisible(false);
		htmlLoginPanel.setVisible(true);

	}

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
		loginTxtBox.setPlaceholder(GL0202);
		loginTxtBox.getElement().setAttribute("placeholder",
				GL0202);
		loginTxtBox.setFocus(true);
		passwordTxtBox.setPlaceholder(GL0204);
		forgotPwd.setText(GL0205);
		loginButton.setText(GL0187);

		lblPleaseWait.setText(GL0242);

		loginTxtBox.getElement().setId("tbLoginUsername");
		passwordTxtBox.getElement().setId("tbLoginPassword");
		loginButton.getElement().setId("btnLogin");

		lblPleaseWait.setVisible(false);

		shareLinkTxtBox.setReadOnly(true);
		shareLinkTxtBox.addClickHandler(new OnClickShareHandler());
		assignDes.setText(GL0513);
		lblAssignPopDes.setText(GL0514);
		lblAssignTitle.setText(GL0518);
		lblpopupTitle.setText(GL0519);
		lblLoginPopupTitle.setText(GL0520);
		loginButton.setText(GL0187);
		ancSignUp.setText(GL0207+GL_SPL_EXCLAMATION);

	}

	@UiHandler("swithUrlLbl")
	public void onClickSwithUrl(ClickEvent clickevent) {
		if (!getIsPrivate()) {
			changeShareUrlEvents(SWITCH_BITLY);
		}
	}

	public boolean getIsPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
		setSwitchButtonStyles();
	}

	public void setSwitchButtonStyles() {
		if (getIsPrivate()) {
			swithToEmbedLbl.getElement().getStyle().setCursor(Cursor.DEFAULT);
			swithUrlLbl.getElement().getStyle().setCursor(Cursor.DEFAULT);
		} else {
			swithToEmbedLbl.getElement().getStyle().setCursor(Cursor.POINTER);
			swithUrlLbl.getElement().getStyle().setCursor(Cursor.POINTER);
		}
	}

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

	private String getIframeText() {
		String iframeText = null;
		if (embedBitlyLink == null) {
			embedBitlyLink = shareLinkTxtBox.getText();
		}
		iframeText = "<iframe width=\"1024px\" height=\"768px\" src=\""
				+ decodeRawUrl + "\" frameborder=\"0\" ></iframe>";

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

	public void setShareUrlGenerationAsyncCallback(
			SimpleAsyncCallback<Map<String, String>> shareShortenUrlAsyncCallback) {
		this.shareUrlGenerationAsyncCallback = shareShortenUrlAsyncCallback;
	}

	public SimpleAsyncCallback<Map<String, String>> getShareShortenUrlAsyncCallback() {
		return shareUrlGenerationAsyncCallback;
	}

	public void generateShareLink(String classpageId) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("type", "");
		params.put("shareType", "");

		AppClientFactory
		.getInjector()
		.getSearchService()
		.getShortenShareUrlforAssign(classpageId, params,
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
		params.put("shareType", "embed");
		AppClientFactory.getInjector().getSearchService().getShortenShareUrl(classpageId, params, getShareShortenUrlAsyncCallback());

	}

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
			shareDo.setDecodeRawUrl(link);
			shareDo.setShareType(shareType);
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

				AppClientFactory
				.getInjector()
				.getAppService()
				.v2Signin(login.toString(),
						new SimpleAsyncCallback<UserDo>() {
					@Override
					public void onSuccess(UserDo result) {
						MixpanelUtil.Regular_User_Logged_In();
						AppClientFactory
						.setLoggedInUser(result);
						AppClientFactory
						.fireEvent(new SetUserDetailsInPlayEvent(
								result.getToken()));
						AppClientFactory
						.fireEvent(new SetUserDetailsInCollectionPlayEvent(
								result.getToken(),
								result.getGooruUId()));

						AppClientFactory
						.fireEvent(new SetHeaderEvent(
								result));

						if (result.getUsername()
								.equalsIgnoreCase(
										"TexasTeacher")) {
							AppClientFactory
							.fireEvent(new SetTexasAccountEvent(
									"failure"));
							AppClientFactory
							.fireEvent(new SetTexasPlaceHolderEvent(
									true));
						} else {
							AppClientFactory
							.fireEvent(new SetTexasAccountEvent(
									"success"));
							AppClientFactory
							.fireEvent(new SetTexasPlaceHolderEvent(
									false));
						}

						AppClientFactory.setUserflag(true);
						AppClientFactory.resetPlace();

						loadListContainers();
						MixpanelUtil
						.mixpanelEvent("Login_FromAssign_Pop-up");
						// heeere add widget

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
			new AlertMessageUc(GL0738, new HTML(LOGIN_COOKIE_DISABLE_MESSAGE));
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

	private void setHandlers() {

		this.setSize("515px", "547px");

		loginTxtBox.addKeyUpHandler(new LoginKeyupHandler());
		passwordTxtBox.addKeyUpHandler(new LoginKeyupHandler());
	}

	@UiHandler("forgotPwd")
	public void onForgotPwdClicked(ClickEvent clickEvent) {

		ForgotPasswordVc forgotPasswordVc = new ForgotPasswordVc();
		forgotPasswordVc.setGlassEnabled(true);
		forgotPasswordVc.show();
		forgotPasswordVc.center();
		closePoup();
	}

	@UiHandler("ancSignUp")
	public void onSignUp(ClickEvent clickEvent) {
		MixpanelUtil.mixpanelEvent("Library_Assign_Signup");
		Map<String, String> params = StringUtil.splitQuery(Window.Location.getHref());
		if(params.containsKey("query"))
		{
			String queryVal = AppClientFactory.getPlaceManager().getRequestParameter("query");
			params.put("query", queryVal);
		}
		if(params.containsKey("flt.subjectName"))
		{
			String subjectNameVal = AppClientFactory.getPlaceManager().getRequestParameter("flt.subjectName");
			params.put("flt.subjectName", subjectNameVal);	
		}
		params.put("callback", "signup");
		params.put("type", "1");
		AppClientFactory.getPlaceManager().revealPlace(
				AppClientFactory.getCurrentPlaceToken(), params);
		closePoup();
	}

	public class OnClickShareHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			shareLinkTxtBox.selectAll();
			shareLinkTxtBox.setFocus(true);
		}

	}

	private static native boolean isCookieEnabled() /*-{
													return navigator.cookieEnabled;
													}-*/;
}
