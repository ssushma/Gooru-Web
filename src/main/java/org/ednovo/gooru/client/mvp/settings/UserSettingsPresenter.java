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
package org.ednovo.gooru.client.mvp.settings;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SeoTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.event.InvokeLoginEvent;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BasePlacePresenter;
import org.ednovo.gooru.client.mvp.home.event.HeaderTabType;
import org.ednovo.gooru.client.mvp.home.event.HomeEvent;
import org.ednovo.gooru.client.mvp.home.event.SetUserProfileImageEvent;
import org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter;
import org.ednovo.gooru.client.mvp.search.event.ConfirmStatusPopupEvent;
import org.ednovo.gooru.client.mvp.search.event.SetFooterEvent;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.service.UserServiceAsync;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.code.LibraryCodeDo;
import org.ednovo.gooru.shared.model.code.ProfileCodeDo;
import org.ednovo.gooru.shared.model.user.BiographyDo;
import org.ednovo.gooru.shared.model.user.ProfileDo;
import org.ednovo.gooru.shared.model.user.ProfilePageDo;
import org.ednovo.gooru.shared.model.user.SettingDo;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
/**
 * This is the presenter class for UserSettingsView.java
 */
public class UserSettingsPresenter
		extends
		BasePlacePresenter<IsUserSettingsView, UserSettingsPresenter.IsUserSettingProxy>
		implements UserSettingsUiHandlers {

	// private static final String
	// PROFILE_IMAGE_REPOSITORY_URL="http://profile-demo.s3.amazonaws.com/profile-qalive/";
	// private static final String
	// PROFILE_IMAGE_REPOSITORY_URL="http://profile-demo.s3.amazonaws.com/profile-prod/";

	@Inject
	private UserServiceAsync userService;

	private ImageUploadPresenter imageUploadPresenter;

	private static final String GOORU_UID = "gooruuid";

	private SimpleAsyncCallback<SettingDo> userProfileAsyncCallback;

	private SimpleAsyncCallback<ProfilePageDo> userProfilePageAsyncCallback;

	private SimpleAsyncCallback<BiographyDo> userProfileBiographyAsyncCallback;

	Date dob;
	SettingDo user = null;
	private boolean isUserUnder13 = false;
	private SavePopup savePopup;

	public SettingDo getUser() {
		return user;
	}

	public void setUser(SettingDo user) {
		this.user = user;
	}

	BiographyDo biographyDo;
	String gooruUid;
	String aboutUs;
	String userName;
	String gender;

	private static final String USER_META_ACTIVE_FLAG = "0";

	private String emailId = "";

	@ProxyCodeSplit
	@NameToken(PlaceTokens.SETTINGS)
	public interface IsUserSettingProxy extends
			ProxyPlace<UserSettingsPresenter> {

	}
	/**
	 * Class Constructor.
	 * @param view
	 * @param proxy
	 * @param imageUploadPresenter
	 */
	@Inject
	public UserSettingsPresenter(final IsUserSettingsView view,
			final IsUserSettingProxy proxy,
			ImageUploadPresenter imageUploadPresenter) {
		super(view, proxy);
		getView().setUiHandlers(this);
		Window.enableScrolling(true);
		this.imageUploadPresenter = imageUploadPresenter;
		addRegisteredHandler(SetUserProfileImageEvent.TYPE, this);
	}
	/**
	 * This method is called whenever the Presenter was not visible on screen and becomes visible.
	 */
	@Override
	public void onReveal() {
		Window.scrollTo(0, 0);
		AppClientFactory.setBrowserWindowTitle(SeoTokens.SETTINGS_TITLE);
		AppClientFactory
				.setMetaDataDescription(SeoTokens.HOME_META_DESCRIPTION);
		getView().clearPanels();
		getView().getAboutUsContainer().setVisible(false);
		boolean isConfirmStatus = true;
		String newMailId = AppClientFactory.getPlaceManager()
				.getRequestParameter("newMailId");
		String userId = AppClientFactory.getPlaceManager().getRequestParameter(
				"userId");
		String confirmStatus = AppClientFactory.getPlaceManager()
				.getRequestParameter("confirmStatus");
		if (confirmStatus != null && confirmStatus.equalsIgnoreCase("true")) {
			isConfirmStatus = true;
		} else {
			isConfirmStatus = false;
		}

		if (newMailId != null && userId != null && isConfirmStatus != false) {
			emailId = newMailId;
			if (!AppClientFactory.getLoggedInUser().getUserUid().equals(AppClientFactory.GOORU_ANONYMOUS)) {
				saveEmail(isConfirmStatus);
			}
			else
			{
				AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.HOME);
				AppClientFactory.fireEvent(new InvokeLoginEvent());
			}
		} else {
			displaySettingsPage();
		}
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		if (AppClientFactory.getLoggedInUser().getConfirmStatus() == 0 && isConfirmStatus){
			String gooruUid = AppClientFactory.getGooruUid();
			String token = AppClientFactory.getLoginSessionToken();
			Map<String, String> params = new HashMap<String, String>();
			params.put("confirmUser", "true");
			params.put("gooruUid", AppClientFactory.getLoggedInUser().getGooruUId());
			// Confirm User and remove/hide Not confirmed Popup.
			AppClientFactory.getInjector().getUserService().updateUserDetails(gooruUid, token, params, new SimpleAsyncCallback<ProfileDo>() {
				@Override
				public void onSuccess(ProfileDo result) {
					//Display thanks popup if required.
					//Set Visiblity to false
					AppClientFactory.setLoggedInUser(result.getUser());
					boolean isConfirmed = result.getUser().getConfirmStatus() == 1 ? true : false;
					if (isConfirmed){
						AppClientFactory.fireEvent(new ConfirmStatusPopupEvent(isConfirmed));
					}
				}
			});
		}
		AppClientFactory.fireEvent(new ConfirmStatusPopupEvent(false));
	}
	/**
	 * 
	 * @function displaySettingsPage 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to display settings page.
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
	void displaySettingsPage() {
		this.getUserService().getUserProfileDetails(
				AppClientFactory.getPlaceManager().getRequestParameter(
						GOORU_UID), getUserprofileAsyncCallback());
		AppClientFactory.fireEvent(new HomeEvent(HeaderTabType.NONE));
		AppClientFactory.fireEvent(new SetFooterEvent(AppClientFactory
				.getPlaceManager().getCurrentPlaceRequest().getNameToken()));
		this.getUserService().getUserProfilePage(
				AppClientFactory.getPlaceManager().getRequestParameter(
						GOORU_UID), getUserProfilePageAsyncCallback());
		getView().setUserProfileImageUrl("EMPTY");
	}
	/**
	 * This method is called when the presenter is instantiated and it deals with user profile settings.
	 */
	@Override
	public void onBind() {
		super.onBind();

		getView().clearPanels();
		setUserProfilePageAsyncCallback(new SimpleAsyncCallback<ProfilePageDo>() {

			@Override
			public void onSuccess(ProfilePageDo result) {
				if (result.getOptionalValue() == "true"
						|| result.getOptionalValue().equalsIgnoreCase("true")) {
					getView().getSeeMyPageButton().setVisible(true);
					getView().getprofileOnButton();

				} else {
					getView().getSeeMyPageButton().setVisible(false);
					getView().getProfileOffButton();

				}
				// Click Event to see my page
				if (result.getOptionalValue() == "true"
						|| result.getOptionalValue().equalsIgnoreCase("true")) {
					getView().getSeeMyPageButton().addClickHandler(
							new ClickHandler() {

								@Override
								public void onClick(ClickEvent event) {
									Map<String, String> params = new HashMap<String, String>();
									params.put("id", gooruUid);
									params.put("user", userName);
									MixpanelUtil.Click_On_SeemyPage();
									AppClientFactory.getPlaceManager()
											.revealPlace(
													PlaceTokens.PROFILE_PAGE,
													params);
								}
							});
				}
			}
		});
		setUserProfileBiographyAsyncCallback(new SimpleAsyncCallback<BiographyDo>() {

			@Override
			public void onSuccess(BiographyDo result) {
				if (result.getAboutMe() != null) {
					getView().getProfileBiographyEditUC().setText(
							result.getAboutMe());
					getView().getSettingDo().setAboutMe(result.getAboutMe());
				}

			}
		});

		setUserProfileAsyncCallback(new SimpleAsyncCallback<SettingDo>() {
			@Override
			public void onSuccess(final SettingDo user) {
				// For child account set the edit button visibility false.
				// for some old account, AccountTypeId is null.

				getView().getAccountSavingText().setVisible(false);
				getView().getEditButtonAccount().setVisible(true);
				if (user.getUser() != null) {
					if (user.getUser().getAccountTypeId() != null) {
						getView().getEditEmailButton().setVisible(
								user.getUser().getAccountTypeId() == 2 ? false
										: true);
						getView().setChildAccount(
								user.getUser().getAccountTypeId() == 2 ? true
										: false);
					} else {
						getView().getEditEmailButton().setVisible(true);
						getView().setChildAccount(false);
					}

					getView().setSettingDo(user);
					// getView().setData(user);
					dob = user.getDateOfBirth();
					gooruUid = user.getUser().getGooruUId();
					userName = user.getUser().getUsername();

					if (user.getGender() != null) {

						gender = user.getGender() != null ? user.getGender()
								.getGenderId() : "";
						if (gender.equalsIgnoreCase("M")) {
							getView().getLbMale().setStyleName(
									getView().getSelectedButton());
						} else if (gender.equalsIgnoreCase("F")) {
							getView().getLbFemale().setStyleName(
									getView().getSelectedButton());
						} else if (gender.equalsIgnoreCase("O")) {
							getView().getLbOther().setStyleName(
									getView().getSelectedButton());
						} else if (gender.equalsIgnoreCase("X")) {
							getView().getLbShare().setStyleName(
									getView().getSelectedButton());
						}

						if (user.getGender().getName() != null) {
							String gender = user.getGender().getName()
									.substring(0, 1).toUpperCase()
									+ user.getGender().getName().substring(1);
							if ("Do not wish to share".equalsIgnoreCase(gender)) {
								String gender1 = gender.replace(
										"Do not wish to share",
										"Prefer not to share");
								getView().getGenderText().setText(gender1);
							} else {
								getView().getGenderText().setText(gender);
							}
						} else {
							getView().getGenderText().setText("");
						}
					}
					// getView().getGenderText().setText(user.getGender().getName().substring(0,1).toUpperCase()+user.getGender().getName().substring(1));

					if (user.getAboutMe() != null) {
						getView().noAboutUsContainer().setVisible(false);
						getView().getProfileBiographyEditUC().setText(
								user.getAboutMe());
					} else {
						getView().noAboutUsContainer().setVisible(true);
					}
					getView().getLbUName()
							.setText(user.getUser().getUsername());
					getView().getTbFirstName().setText(
							user.getUser().getFirstName());
					getView().getTbLastName().setText(
							user.getUser().getLastName());

					if (user.getUser().getLoginType()
							.equalsIgnoreCase("credential")) {
						if (dob != null) {
							getView().getLbUName().getElement()
									.setAttribute("dob", "" + dob);
							int age = getAge(dob);
							getView().getLbUName().getElement()
									.setAttribute("date", "" + age);
							if (age < 13) {
								getView().getLbRole().setText("Student");
							} else {
								getView().getLbRole().setText(
										user.getUserType());
							}
						} else if (user.getUser().getAccountTypeId() != null) {
							if (user.getUser().getAccountTypeId() == 2) {
								getView().getLbRole().setText("Student");
								
							} else {
								getView().getLbRole().setText(
										user.getUserType());
							}
						} else {
							getView().getLbRole().setText(user.getUserType());
						}
					} else {
						getView().getLbRole().setText(
								user.getUserType() != null ? user.getUserType()
										: "");
					}

					if (user.getExternalId() != null) {
						getView().getLbEmail().setText(user.getExternalId());
					} else {
						if(user.getUser().getAccountTypeId() != 2){
						getView().getLbEmail().setText(
								user.getUser().getEmailId());
						}
					}
					// getView().getLbEmail().setText(user.getExternalId());
					getView().getLbName().setText(
							user.getUser().getFirstName() + " "
									+ user.getUser().getLastName());
					getView().getLbUserName().setText(
							user.getUser().getUsername());
					if (user.getUser().getLoginType() != null) {
						if (user.getUser().getLoginType().trim()
								.equalsIgnoreCase("apps")) {
							getView().getForgetPassword().setVisible(false);
							getView().getForgetPasswordMsg().setVisible(true);
						} else if (user.getUser().getLoginType().trim()
								.equalsIgnoreCase("Credential")) {
							getView().getForgetPassword().setVisible(true);
							getView().getForgetPasswordMsg().setVisible(false);
						}
					}

					if (user.getUser().getLoginType()
							.equalsIgnoreCase("credential")) {
						if (dob != null) {
							getView().getLbUName().getElement()
									.setAttribute("dob", "" + dob);
							int age = getAge(dob);
							getView().getLbUName().getElement()
									.setAttribute("date", "" + age);
							if (age < 13) {
								getView().getAboutUsContainer().setVisible(
										false);
								setUserUnder13(true);
							} else {
								getView().getAboutUsContainer()
										.setVisible(true);
								setUserUnder13(false);
							}
						} else if (user.getUser().getAccountTypeId() != null) {
							// All child accounts have account type id is set to
							// 2.
							// Based on this will not show PPP for child
							// account.,
							// but we need to look when child trun >13.
							if (user.getUser().getAccountTypeId() == 2) {
								getView().getAboutUsContainer().setVisible(
										false);
								
								setUserUnder13(true);
							} else {
								getView().getAboutUsContainer()
										.setVisible(true);
								setUserUnder13(false);
							}
						} else {
							getView().getAboutUsContainer().setVisible(true);
							setUserUnder13(false);
						}
					} else {
						getView().getAboutUsContainer().setVisible(true);
						setUserUnder13(false);
					}
					getView().setUserProfileImageUrl(
							AppClientFactory.getLoggedInUser().getSettings()
									.getProfileImageUrl()
									+ user.getUser().getGooruUId()
									+ "-158x158.png");

					getView().setData(user);
				} else {
					
				}
				/**
				 * This RPC is to get the User profile Details(grade value)
				 */
				AppClientFactory
						.getInjector()
						.getUserService()
						.getUserProfileV2Details(gooruUid,
								USER_META_ACTIVE_FLAG,
								new SimpleAsyncCallback<ProfileDo>() {

									@Override
									public void onSuccess(ProfileDo profileObj) {
										getView().setProfileData(profileObj);
									}

								});
				/**
				 * This RPC is to get the Courses
				 */
				AppClientFactory
						.getInjector()
						.getTaxonomyService()
						.getCourse(
								new SimpleAsyncCallback<List<LibraryCodeDo>>() {
									@Override
									public void onSuccess(
											List<LibraryCodeDo> result) {
										getView().setCourseList(result);
									}
								});

			}

		});
		UpdateGender();
	}

	// Label work like radio button functionality
	/**
	 * 
	 * @function UpdateGender 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to update the gender.
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
	public void UpdateGender() {
		getView().getLbMale().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				getView().getLbFemale()
						.setStyleName(getView().getRadioButton());
				getView().getLbOther().setStyleName(getView().getRadioButton());
				getView().getLbShare().setStyleName(getView().getRadioButton());
				getView().getLbMale().setStyleName(
						getView().getSelectedButton());

			}
		});
		getView().getLbShare().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				getView().getLbMale().setStyleName(getView().getRadioButton());
				getView().getLbFemale()
						.setStyleName(getView().getRadioButton());
				getView().getLbOther().setStyleName(getView().getRadioButton());
				getView().getLbShare().setStyleName(
						getView().getSelectedButton());

			}
		});
		getView().getLbFemale().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				getView().getLbMale().setStyleName(getView().getRadioButton());
				getView().getLbOther().setStyleName(getView().getRadioButton());
				getView().getLbShare().setStyleName(getView().getRadioButton());
				getView().getLbFemale().setStyleName(
						getView().getSelectedButton());
			}
		});
		getView().getLbOther().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				getView().getLbMale().setStyleName(getView().getRadioButton());
				getView().getLbFemale()
						.setStyleName(getView().getRadioButton());
				getView().getLbShare().setStyleName(getView().getRadioButton());
				getView().getLbOther().setStyleName(
						getView().getSelectedButton());
			}
		});
	}
	/**
	 * 
	 * @function getLbMale 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :returns FocusWidget.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : FocusWidget
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	private FocusWidget getLbMale() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * To close the opened popup's 
	 */
	@Override
	protected void onHide() {
		super.onHide();
		getView().closeAllOpenedPopUp();
		imageUploadPresenter.getView().closeImageUploadWidget();
	}
	/**
	 * 
	 * @function setUserProfileAsyncCallback 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :returns userProfileAsyncCallback.
	 * 
	 * 
	 * @parm(s) : @param userProfileAsyncCallback
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setUserProfileAsyncCallback(
			SimpleAsyncCallback<SettingDo> userProfileAsyncCallback) {
		this.userProfileAsyncCallback = userProfileAsyncCallback;
	}
	/**
	 * 
	 * @function getUserService 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :returns userService.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : UserServiceAsync
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public UserServiceAsync getUserService() {
		return userService;
	}
	/**
	 * 
	 * @function getUserprofileAsyncCallback 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : returns userProfileAsyncCallback.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : SimpleAsyncCallback<SettingDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public SimpleAsyncCallback<SettingDo> getUserprofileAsyncCallback() {
		return userProfileAsyncCallback;
	}
	/**
	 * 
	 * @function getUserProfileBiographyAsyncCallback 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :returns userProfileBiographyAsyncCallback.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : SimpleAsyncCallback<BiographyDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public SimpleAsyncCallback<BiographyDo> getUserProfileBiographyAsyncCallback() {
		return userProfileBiographyAsyncCallback;
	}
	/**
	 * 
	 * @function setUserProfileBiographyAsyncCallback 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :To set userProfileBiographyAsyncCallback
	 * 
	 * 
	 * @parm(s) : @param userProfileBiographyAsyncCallback
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setUserProfileBiographyAsyncCallback(
			SimpleAsyncCallback<BiographyDo> userProfileBiographyAsyncCallback) {
		this.userProfileBiographyAsyncCallback = userProfileBiographyAsyncCallback;
	}
	/**
	 * 
	 * @function getUserProfilePageAsyncCallback 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :returns userProfilePageAsyncCallback.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : SimpleAsyncCallback<ProfilePageDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public SimpleAsyncCallback<ProfilePageDo> getUserProfilePageAsyncCallback() {
		return userProfilePageAsyncCallback;
	}
	/**
	 * 
	 * @function setUserProfilePageAsyncCallback 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :To set userProfilePageAsyncCallback.
	 * 
	 * 
	 * @parm(s) : @param userProfilePageAsyncCallback
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setUserProfilePageAsyncCallback(
			SimpleAsyncCallback<ProfilePageDo> userProfilePageAsyncCallback) {
		this.userProfilePageAsyncCallback = userProfilePageAsyncCallback;
	}
	/**
	 * To get place token
	 */
	@Override
	public String getViewToken() {
		return null;
	}
	/**
	 * This is used to save settings information.
	 */
	@Override
	public void saveSettingsInformation() {
		// String emailValue="";
		Map<String, String> updateUserDetails = new HashMap<String, String>();
		String fnValue = getView().getTbFirstName().getText().trim();
		String lnValue = getView().getTbLastName().getText().trim();

		updateUserDetails.put("firstName", fnValue);
		updateUserDetails.put("lastName", lnValue);
		// updateUserDetails.put("externalId", emailValue);
		if (getView().getLbRole().getText().equalsIgnoreCase("Student")) {
			updateUserDetails.put("userType", "Student");
		} else if (getView().getLbRole().getText().equalsIgnoreCase("Teacher")) {
			updateUserDetails.put("userType", "Teacher");
		} else if (getView().getLbRole().getText().equalsIgnoreCase("Parent")) {
			updateUserDetails.put("userType", "Parent");
		} else if (getView().getLbRole().getText().equalsIgnoreCase("Other")) {
			updateUserDetails.put("userType", "Other");
		}

		if (getView().getLbFemale().getStyleName()
				.equals(getView().getSelectedButton())) {
			updateUserDetails.put("gender", "F");
		} else if (getView().getLbMale().getStyleName()
				.equals(getView().getSelectedButton())) {
			updateUserDetails.put("gender", "M");
		} else if (getView().getLbOther().getStyleName()
				.equals(getView().getSelectedButton())) {
			updateUserDetails.put("gender", "O");
		} else if (getView().getLbShare().getStyleName()
				.equals(getView().getSelectedButton())) {
			updateUserDetails.put("gender", "X");
		}
		updateUserDetails.put("aboutMe", getView().getProfileBiographyEditUC()
				.getText());
		this.getUserService().updateProfileSettings(
				AppClientFactory.getPlaceManager().getRequestParameter(
						GOORU_UID), updateUserDetails,
				getUserprofileAsyncCallback());

	}
	/**
	 * This is used to update profile visibility settings.
	 */
	@Override
	public void updateProfileVisibilitySetting(String optionalValue) {
		getUserService().updateUserProfileVisibility(
				AppClientFactory.getPlaceManager().getRequestParameter(
						GOORU_UID), optionalValue,
				getUserProfilePageAsyncCallback());
	}
	/**
	 * This is used to update user Profile Biography.
	 */
	@Override
	public void updateUserBiography(String biography, String role,
			String firstName, String lastName, String gender) {
		getUserService().updateProfileBiography(
				AppClientFactory.getPlaceManager().getRequestParameter(
						GOORU_UID), biography, role, firstName, lastName,
				this.gender, getUserProfileBiographyAsyncCallback());
	}
	/**
	 * 
	 * @function getAge 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : THis is used to get the age based on DOB.
	 * 
	 * 
	 * @parm(s) : @param birthDate
	 * @parm(s) : @return
	 * 
	 * @return : int
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	private int getAge(Date birthDate) {
		long ageInMillis = new Date().getTime() - birthDate.getTime();
		Date age = new Date(ageInMillis);
		return age.getYear() - 70;
	}
	/**
	 * This method is used to show the updated profile images.
	 */
	public void showUploadProfileImageWidget() {
		imageUploadPresenter.showUploadTypeWidgets(isUserUnder13());
		addToPopupSlot(imageUploadPresenter);
		imageUploadPresenter.setProfileImage(true);
		imageUploadPresenter.setCollectionImage(false);
		imageUploadPresenter.setEditResourceImage(false);
	}
	/**
	 * This method is used to add course.
	 */
	@Override
	public void addCourse(Set<ProfileCodeDo> profileCodeDo) {
		AppClientFactory
				.getInjector()
				.getProfilePageService()
				.addCourseUserProfile(profileCodeDo, "settings",
						new SimpleAsyncCallback<Void>() {
							@Override
							public void onSuccess(Void result) {

							}
						});
	}
	/**
	 * This method is used to delete course.
	 */
	@Override
	public void deleteCourse(CodeDo codeDo) {
		AppClientFactory
				.getInjector()
				.getProfilePageService()
				.deleteCourseUserProfile(codeDo, "settings",
						new SimpleAsyncCallback<Void>() {
							@Override
							public void onSuccess(Void result) {

							}
						});
	}
	/**
	 * This method is used to set the user profile image.
	 */
	@Override
	public void setUserProfileImage(String imageUrl) {
		getView().setUserProfileImageUrl(imageUrl);

	}
	/**
	 * 
	 * @function isUserUnder13 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : returns isUserUnder13.
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
	public boolean isUserUnder13() {
		return isUserUnder13;
	}
	/**
	 * 
	 * @function setUserUnder13 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to set isUserUnder13.
	 * 
	 * 
	 * @parm(s) : @param isUserUnder13
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setUserUnder13(boolean isUserUnder13) {
		this.isUserUnder13 = isUserUnder13;
	}
	/**
	 * This method is used to save email.
	 */
	@Override
	public void saveEmail(final boolean isEmailConfirmed) {
		String emailValue = "";

		if (isEmailConfirmed == true) {
			emailValue = emailId;
		} else {
			getView().getSavingTextLabel().setVisible(true);
			Map<String, String> updateUserDetails = new HashMap<String, String>();
			if (getView().getLbEmail().getText() != null
					&& getView().getLbEmail().getText() != "") {
				emailValue = getView().getLbEmail().getText().trim();
			}
		}

		AppClientFactory
				.getInjector()
				.getUserService()
				.updateNewEmailStatus(emailValue, isEmailConfirmed,
						new AsyncCallback<Void>() {
							@Override
							public void onSuccess(Void Result) {
								if (isEmailConfirmed) {
									displaySettingsPage();
								} else {
									if (savePopup != null
											&& savePopup.isShowing()) {
										savePopup.hide();
									}
									savePopup = new SavePopup();
									getView().getSavingTextLabel().setVisible(
											false);
									getView().getEditEmailButton().setVisible(
											true);
									getView().getEmailTextConfirmation()
											.setVisible(true);
								}
								AppClientFactory.fireEvent(new ConfirmStatusPopupEvent(false));
							}

							@Override
							public void onFailure(Throwable caught) {
							}
						});
	}

}
