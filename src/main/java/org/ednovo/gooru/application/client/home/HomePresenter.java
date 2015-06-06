/****************************************************************************** * Copyright 2013 Ednovo d/b/a Gooru. All rights reserved.
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
/**
 *
 */
package org.ednovo.gooru.application.client.home;

import java.util.Map;

import org.ednovo.gooru.application.client.AppPlaceKeeper;
import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BasePlacePresenter;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.search.SearchDo;
import org.ednovo.gooru.client.SeoTokens;
import org.ednovo.gooru.client.mvp.home.event.HeaderTabType;
import org.ednovo.gooru.client.mvp.home.event.HomeEvent;
import org.ednovo.gooru.client.mvp.home.register.UserRegistrationPresenter;
import org.ednovo.gooru.client.util.MixpanelUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

/**
 * @author Search Team
 *
 */
public class HomePresenter extends BasePlacePresenter<IsHomeView, HomePresenter.IsHomeProxy> implements HomeUiHandlers {


	@NameToken(PlaceTokens.HOME)
	@UseGatekeeper(AppPlaceKeeper.class)
	@ProxyCodeSplit
	public interface IsHomeProxy extends ProxyPlace<HomePresenter> {
	}


	private MessageProperties i18n = GWT.create(MessageProperties.class);

	/**
	 * Class constructor
	 * @param userRegistrationPresenter instance of {@link UserRegistrationPresenter}
	 * @param view {@link View}
	 * @param proxy {@link Proxy}
	 */
	@Inject
	public HomePresenter(IsHomeView view, IsHomeProxy proxy) {
		super(view, proxy);
		getView().setUiHandlers(this);

	}

	@Override
	public void onBind() {
		super.onBind();
		Window.enableScrolling(true);
		Window.scrollTo(0, 0);
		MixpanelUtil.Arrive_Landing_Page();
	}

	@Override
	public void onReveal() {
		super.onReveal();

		if(AppClientFactory.isAnonymous()) {
			AppClientFactory.setBrowserWindowTitle(SeoTokens.HOME_TITLE_ANONYMOUS);
		} else {
			AppClientFactory.setBrowserWindowTitle(SeoTokens.HOME_TITLE_LOGGEDIN);
		}
		AppClientFactory.setMetaDataDescription(SeoTokens.HOME_META_DESCRIPTION);
		AppClientFactory.fireEvent(new HomeEvent(HeaderTabType.HOME));
		if (AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken() != null){
		}

		Document doc = Document.get();
		doc.getElementById("uvTab").getStyle().setDisplay(Display.BLOCK);
	}


	private void callBackMethods(){
//		GWT.runAsync(new SimpleRunAsyncCallback() {
//
//			@Override
//			public void onSuccess() {
//				if(AppClientFactory.getLoggedInUser().getConfirmStatus()==0){
//					AppClientFactory.fireEvent(new ConfirmStatusPopupEvent(true));
//				}
//				AppClientFactory.printInfoLogger("getPlaceManager().getRequestParameter(CALLBACK) : "+getPlaceManager().getRequestParameter(CALLBACK));
//				if (getPlaceManager().getRequestParameter(CALLBACK) != null && getPlaceManager().getRequestParameter(CALLBACK).equalsIgnoreCase("registration")) {
//					getUserService().getRegistredUserDetails(AppClientFactory.getPlaceManager().getRequestParameter(GOORU_UID), getRegisterdUserAsyncCallback());
//					parentGooruUID=AppClientFactory.getPlaceManager().getRequestParameter(GOORU_UID);
//				}else if (getPlaceManager().getRequestParameter(CALLBACK) != null && getPlaceManager().getRequestParameter(CALLBACK).equalsIgnoreCase("changePassword")) {
//					validateResetLink(AppClientFactory.getPlaceManager().getRequestParameter("resetToken"));
//				}else if (getPlaceManager().getRequestParameter(CALLBACK) != null && getPlaceManager().getRequestParameter(CALLBACK).equalsIgnoreCase("signup")) {
//					//To show SignUp (Registration popup)
//					if (AppClientFactory.isAnonymous()){
//						Window.enableScrolling(false);
//						AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
//						String type = getPlaceManager().getRequestParameter("type") ;
//						int displayScreen =getPlaceManager().getRequestParameter("type") !=null  ? Integer.parseInt(type) : 1;
//						signUpViewPresenter.displayPopup(displayScreen);
//						addToPopupSlot(signUpViewPresenter);
//					}
//				}else if (getPlaceManager().getRequestParameter(CALLBACK) != null && getPlaceManager().getRequestParameter(CALLBACK).equalsIgnoreCase("registerChild")){
//					if (getPlaceManager().getRequestParameter("dob") != null && getPlaceManager().getRequestParameter("userName") != null){
//						String externalId = AppClientFactory.getLoggedInUser().getExternalId();
//						String email = AppClientFactory.getLoggedInUser().getEmailId();
//
//						String parentEmailId = email !=null && !email.equalsIgnoreCase("") ? email : externalId !=null && externalId.equalsIgnoreCase("") ? externalId : null;
//						String parameterEmailId = getPlaceManager().getRequestParameter("emailId", null);
//						parentEmailId = parameterEmailId !=null && !parameterEmailId.equalsIgnoreCase("") ? parameterEmailId : parentEmailId;
//
//						StudentSignUpUc studentSignUp = new StudentSignUpUc(parentEmailId, getPlaceManager().getRequestParameter("userName"), getPlaceManager().getRequestParameter("dob").replaceAll("D", "\\/"), AppClientFactory.isAnonymous() ? getPlaceManager().getRequestParameter("privateGooruUId") : AppClientFactory.getLoggedInUser().getGooruUId());
//						studentSignUp.center();
//						studentSignUp.show();
//					}
//				}else if (getPlaceManager().getRequestParameter(CALLBACK) != null && getPlaceManager().getRequestParameter(CALLBACK).equalsIgnoreCase("guide")){
//
//				}else if (getPlaceManager().getRequestParameter(CALLBACK) != null && getPlaceManager().getRequestParameter(CALLBACK).equalsIgnoreCase("profileUpdate")){
//					if (AppClientFactory.isAnonymous()){
//						AppClientFactory.fireEvent(new InvokeLoginEvent());
//					}else{
//						signUpCompletePresenter.displayView();
//						addToPopupSlot(signUpCompletePresenter);
//					}
//				}
//				else if (getPlaceManager().getRequestParameter(CALLBACK) != null && getPlaceManager().getRequestParameter(CALLBACK).equalsIgnoreCase("turn13")){
//					if (AppClientFactory.isAnonymous()){
//						AppClientFactory.fireEvent(new InvokeLoginEvent());
//					}else{
//						if(!signUpAfterThirteenPresenter.isVisible()) {
//							signUpAfterThirteenPresenter.displayView();
//							addToPopupSlot(signUpAfterThirteenPresenter);
//						}
//					}
//				}
//				else if  (getPlaceManager().getRequestParameter(CALLBACK) != null && getPlaceManager().getRequestParameter(CALLBACK).equalsIgnoreCase("confirmUser")){
//					//SignUpGradeCourseView gradeCourseView = new SignUpGradeCourseView(AppClientFactory.getLoggedInUser());
//					//Check if user is logged or not.
//					if (AppClientFactory.isAnonymous()){
//						//If not Open Login Popup
//						AppClientFactory.fireEvent(new InvokeLoginEvent());
//					}else{
//						if (AppClientFactory.getLoggedInUser().getConfirmStatus() == 0){
//							String gooruUid = getPlaceManager().getRequestParameter("gooruuid") !=null ? getPlaceManager().getRequestParameter("gooruuid") : "";
//							String token = getPlaceManager().getRequestParameter("sessionid") !=null ? getPlaceManager().getRequestParameter("sessionid") : "";
//							Map<String, String> params = new HashMap<String, String>();
//							params.put("confirmUser", "true");
//							params.put("gooruUid", AppClientFactory.getLoggedInUser().getGooruUId());
//							// Confirm User and remove/hide Not confirmed Popup.
//							AppClientFactory.getInjector().getUserService().updateUserDetails(gooruUid, token, params, new SimpleAsyncCallback<ProfileDo>() {
//								@Override
//								public void onSuccess(ProfileDo result) {
//									//Display thanks popup if required.
//									//Set Visiblity to false
//									AppClientFactory.setLoggedInUser(result.getUser());
//									boolean isConfirmed = result.getUser().getConfirmStatus() == 1 ? true : false;
//									if (isConfirmed){
//										AppClientFactory.fireEvent(new ConfirmStatusPopupEvent(isConfirmed));
//										ThanksEmailConfirmPopupUc confirmPopup = new ThanksEmailConfirmPopupUc();
//										confirmPopup.center();
//										confirmPopup.show();
//									}
//								}
//							});
//						}
//					}
//				}
//
//				if (getPlaceManager().getRequestParameter(LOGINEVENT) != null && getPlaceManager().getRequestParameter(LOGINEVENT).equalsIgnoreCase("true") && AppClientFactory.isAnonymous()) {
//					AppClientFactory.fireEvent(new InvokeLoginEvent());
//				}
//
//				if (getPlaceManager().getRequestParameter(ERROR) != null && getPlaceManager().getRequestParameter(ERROR).equals("401") && AppClientFactory.isAnonymous()) {
//					new AlertContentUc(i18n.GL1966(), i18n.GL1938());
//				}
//
//
//				final UserDo userDo = AppClientFactory.getLoggedInUser();
//				int flag = userDo.getViewFlag();
//				final String loginType = AppClientFactory.getLoggedInUser().getLoginType() !=null ? AppClientFactory.getLoggedInUser().getLoginType() : "";
//				//Show Popup where user can update his details like, username and role. Show this only for non regular user and if he is logging for the first time.
//				if(!AppClientFactory.isAnonymous() && flag==0 &&  !loginType.equalsIgnoreCase(CREDENTIAL)) {
//					Window.enableScrolling(false);
//					AlmostDoneUc update = new AlmostDoneUc(AppClientFactory.getLoggedInUser().getEmailId(), AppClientFactory.getLoggedInUser());
//					update.setGlassEnabled(true);
//					update.show();
//					update.center();
//					Document doc=Document.get();
//					Element bodyelement = doc.getBody();
//					Window.scrollTo(0, 0);
//					bodyelement.getParentElement().setAttribute("style", "overflow:hidden");
//				}
//				else if(flag>0 && flag<=11 && !AppClientFactory.isAnonymous()){
//				}
//
//				AppClientFactory.fireEvent(new SetFooterEvent(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken()));
//			}
//		});
	}



	@Override
	public void onReset() {
		super.onReset();
		/*Window.enableScrolling(true);
		Window.scrollTo(0, 0);*/
		if (AppClientFactory.isAnonymous()){
		}else{
		}
	}

	private void getIntoLibrarypage() {
//		if (getPlaceManager().getRequestParameter(LIBRARY_PAGE) != null && getPlaceManager().getRequestParameter(LIBRARY_PAGE).equalsIgnoreCase("featured-contributors")) {
//			getView().loadFeaturedContributors("featured-contributors",getViewToken());
//		} else if (getPlaceManager().getRequestParameter(LIBRARY_PAGE) != null && getPlaceManager().getRequestParameter(LIBRARY_PAGE).equalsIgnoreCase("course-page")) {
//			getView().loadFeaturedContributors("course-page",getViewToken());
//		} else if (getPlaceManager().getRequestParameter(LIBRARY_PAGE) != null && getPlaceManager().getRequestParameter(LIBRARY_PAGE).equalsIgnoreCase("featured-course")) {
//			getView().loadFeaturedContributors("featured-course",getViewToken());
//		} else if (getPlaceManager().getRequestParameter(LIBRARY_PAGE) == null) {
//			getView().loadFeaturedContributors("featured-course",getViewToken());
//		}
	}

	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		request.getParameter("", "register");
		callBackMethods();

		getIntoLibrarypage();
		if (AppClientFactory.isAnonymous()){
		}else{
		}
	}


	/**
	 * Reset the search result
	 * @param searchDo instance of {@link SearchDo}
	 */
	public void resetSearchInfo(SearchDo<?> searchDo) {
		searchDo.setSearchResults(null);
		searchDo.setSearchHits(0);
	}

	/**
	 * Take to search page , resource search or collection search
	 * @param isResourceSearch takes to resource search view if it is true otherwise to collection search view
	 * @param params search filters as map value
	 */
	public void homeSearch(boolean isResourceSearch, Map<String, String> params) {
		getPlaceManager().revealPlace(isResourceSearch ? PlaceTokens.SEARCH_RESOURCE : PlaceTokens.SEARCH_COLLECTION, params);
	}

	@Override
	public String getViewToken() {
		return PlaceTokens.HOME;
	}
}
