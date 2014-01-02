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
package org.ednovo.gooru.client.mvp.profilepage;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ednovo.gooru.client.AppPlaceKeeper;
import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SeoTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BasePlacePresenter;
import org.ednovo.gooru.client.mvp.home.event.HeaderTabType;
import org.ednovo.gooru.client.mvp.home.event.HomeEvent;
import org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter;
import org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter.IsProfilePageProxy;
import org.ednovo.gooru.client.mvp.profilepage.event.RequestCollectionOpenEvent;
import org.ednovo.gooru.client.mvp.profilepage.event.RequestFolderOpenEvent;
import org.ednovo.gooru.client.mvp.profilepage.event.SetUserPublicProfileImageEvent;
import org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListPresenter;
import org.ednovo.gooru.client.mvp.search.event.ConfirmStatusPopupEvent;
import org.ednovo.gooru.client.mvp.search.event.ConfirmStatusPopupHandler;
import org.ednovo.gooru.client.mvp.search.event.SetFooterEvent;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.service.ProfilePageServiceAsync;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.code.LibraryCodeDo;
import org.ednovo.gooru.shared.model.code.ProfileCodeDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.user.BiographyDo;
import org.ednovo.gooru.shared.model.user.ProfileDo;
import org.ednovo.gooru.shared.model.user.ProfilePageDo;

import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

/**
 * 
 * @fileName : ProfilePagePresenter.java
 *
 * @description : This is the presenter class for ProfilePageView.java
 *
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class ProfilePagePresenter extends BasePlacePresenter<IsProfilePageView, IsProfilePageProxy> implements ProfilePageUiHandlers {
	
//	private SimpleAsyncCallback<List<CollectionDo>> userCollectionAsyncCallback;

	@Inject 
	private ProfilePageListPresenter profilePageListPresenter;
	
	private ImageUploadPresenter imageUploadPresenter;

	private ProfileDo profileDo;

	private Date dob;
	
	private boolean isUserUnder13=false;

	@Inject
	private ProfilePageServiceAsync profilePageService;

	private SimpleAsyncCallback<List<CollectionItemDo>> getWorkSpaceAsyncCallback;
	
	private SimpleAsyncCallback<BiographyDo> userProfileBiographyAsyncCallback;

	private int PARENT_FOLDER_ID = 0;
	
	private static String USER_META_ACTIVE_FLAG = "1";
	
	private String profileUrl=null;
	
	private String userId = "";

	private String callBack = "";
	
	@Inject
	public ProfilePagePresenter(ProfilePageListPresenter profilePageListPresenter, IsProfilePageView view, IsProfilePageProxy proxy,ImageUploadPresenter imageUploadPresenter) {
		super(view, proxy);
		getView().setUiHandlers(this);
		this.profilePageListPresenter = profilePageListPresenter;
		this.imageUploadPresenter=imageUploadPresenter;
		addRegisteredHandler(RequestFolderOpenEvent.TYPE, this);
		addRegisteredHandler(RequestCollectionOpenEvent.TYPE, this);
		addRegisteredHandler(SetUserPublicProfileImageEvent.TYPE, this);
	}

	@ProxyCodeSplit
	@NameToken(PlaceTokens.PROFILE_PAGE)
	@UseGatekeeper(AppPlaceKeeper.class)
	public interface IsProfilePageProxy extends ProxyPlace<ProfilePagePresenter> {
	}
	/**
	 * This method is used to get the view token.
	 */
	@Override
	public String getViewToken() {
		throw new RuntimeException("Not implemented");
	}
	/**
	 * This method is called whenever the Presenter was not visible on screen and becomes visible.
	 */
	@Override
	protected void onReveal() {
		AppClientFactory.setBrowserWindowTitle(SeoTokens.PROFILE_PAGE_TITLE);
		AppClientFactory.setMetaDataDescription(SeoTokens.HOME_META_DESCRIPTION);
		userId = AppClientFactory.getPlaceManager().getRequestParameter("id");
		AppClientFactory.fireEvent(new ConfirmStatusPopupEvent(false));
		callBack = "reveal";
		createProfileUserData();
		//getUserWorkSpace();
	}
	/**
	 * This method is called whenever the user navigates to a page that shows the presenter, whether it was visible or not.
	 */
	@Override
	protected void onReset() {
		String userResetId = AppClientFactory.getPlaceManager().getRequestParameter("id");
		String folderId = AppClientFactory.getPlaceManager().getRequestParameter("folderid");
		if(folderId!=null) {
			callBack = "reset";
		}
		if(userResetId != userId) {
			userId = userResetId;
			createProfileUserData();
		}
		getUserWorkSpace();
	}
	/**
	 * 
	 * @function getUserWorkSpace 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This method is used to get the folders based on folder id.
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
	protected void getUserWorkSpace() {
		String folderId = AppClientFactory.getPlaceManager().getRequestParameter("folderid");
		getView().setContentTabVisibility(true);
		if(folderId!=null) {
			getProfilePageService().getFolders(folderId, getGetWorkSpaceAsyncCallback());
		} else {
			getProfilePageService().getUserWorkSpace(userId, getGetWorkSpaceAsyncCallback());
		}
	}
	/**
	 * onUnBind() is not called when the Presenter is hidden, that would trigger the onHide() method.
	 */
	@Override
	protected void onUnbind() {
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
	}
	/**
	 * This method is used to close all the opened popup's and to close ImageUpload Widget.
	 */
	@Override
	protected void onHide() {
		super.onHide();
		getView().closeAllOpenedPopUp();
		imageUploadPresenter.getView().closeImageUploadWidget();
	}
	/**
	 * 
	 * @function createProfileUserData 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This method is used to create profile user data.
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
	private void createProfileUserData() {
		getView().showProfileView(true);
		if(userId.equalsIgnoreCase(AppClientFactory.getLoggedInUser().getGooruUId())) {
			AppClientFactory.fireEvent(new HomeEvent(HeaderTabType.USERNAME));
		}
		AppClientFactory.getInjector().getUserService().getUserPublicProfilePage(userId,new SimpleAsyncCallback<ProfilePageDo>(){
			@Override
			public void onSuccess(ProfilePageDo result) {
				final String profileOptionvalue=result.getOptionalValue();
				AppClientFactory.getInjector().getUserService().getUserProfileV2Details(userId, USER_META_ACTIVE_FLAG, new SimpleAsyncCallback<ProfileDo>(){
					@Override
					public void onSuccess(ProfileDo result) {
						profileDo = result;
						AppClientFactory.setBrowserWindowTitle(SeoTokens.PROFILE_PAGE_TITLE + profileDo.getUser().getUsernameDisplay());
						getView().setProfileData(profileDo);
						setInSlot(TYPE_PUBLIC_SHELF_VIEW, profilePageListPresenter);
						profilePageListPresenter.setUserData(profileDo.getUser().getUsernameDisplay());
						
						if(userId.equalsIgnoreCase(AppClientFactory.getLoggedInUser().getGooruUId())&&!isChildUser(result)) {
							getView().enableEditableData(profileOptionvalue);
							getView().getChilNoShareOption().setVisible(false);
						} else if(userId.equalsIgnoreCase(AppClientFactory.getLoggedInUser().getGooruUId())&&isChildUser(result)){
							getView().disableChildData();
							getView().getChilNoShareOption().setVisible(true);
						}
					}
				});
				
				//User Editing their own profile page.
				if (userId.equalsIgnoreCase(AppClientFactory.getLoggedInUser().getGooruUId())){
					getView().getOffProfileContainer().setVisible(false);
					getView().getOnProfileContainer().setVisible(true);
					getView().editOptions(true);
				}else{ //User trying to access somebody PPP.
					if (profileOptionvalue.equalsIgnoreCase("true")){	// and PPP is enabled.
						getView().getOffProfileContainer().setVisible(false);
						getView().getOnProfileContainer().setVisible(true);
						getView().editOptions(false);
						getView().getChilNoShareOption().setVisible(false);
					}else{	// and PPP is not enabled.
						getView().getOffProfileContainer().setVisible(true);
						getView().getOnProfileContainer().setVisible(false);
						getView().editOptions(false);
						getView().getChilNoShareOption().setVisible(false);
					}
				}
			}
		});
		AppClientFactory.fireEvent(new SetFooterEvent(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken()));
		getProfilePageService().profileVisitEvent(userId, new SimpleAsyncCallback<Void>(){
			@Override
			public void onSuccess(Void result) {
			}
		});
	}
	/**
	 * 
	 * @function isChildUser 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This method is used to check wheather the user is child user or not.
	 * 
	 * 
	 * @parm(s) : @param profileDo
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
	private boolean isChildUser(ProfileDo profileDo) {
		dob = profileDo.getDateOfBirth();
		if (profileDo.getUser().getLoginType().equalsIgnoreCase("credential")) {
			if (dob != null) {
				int age = getAge(dob);
				if (age < 13) {
					setUserUnder13(true);
				} else {
					setUserUnder13(false);
				}
			} else if (profileDo.getUser().getAccountTypeId()!=null){
				//All child accounts have account type id is set to 2.
				//Based on this will not show PPP for child account., but we need to look when child trun >13.
				if (profileDo.getUser().getAccountTypeId()==2){
					setUserUnder13(true);
				}else{
					setUserUnder13(false);
				}
			} else {
				setUserUnder13(false);
			}
		} else {
			setUserUnder13(false);
		}
		return isUserUnder13();
	}
	/**
	 * 
	 * @function getAge 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This method is used to get the age based on dob.
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
	 * This method is used to set the share view.
	 */
	@Override
	public void setShareView() {
		String id=AppClientFactory.getPlaceManager().getRequestParameter("id");
		String user=AppClientFactory.getPlaceManager().getRequestParameter("user");
		profileUrl = PlaceTokens.PROFILE_PAGE+"&id="+id+"&user="+user;
		AppClientFactory.getInjector().getClasspageService().ShotenUrl(profileUrl, new SimpleAsyncCallback<List<String>>() {
			/*@Override
			public void onSuccess(Sting shortenUrl) {
				getVie)w().setShareData(profileDo, shortenUrl, profileUrl);
			}*/

			@Override
			public void onSuccess(List<String> shortenUrl) {
				getView().setShareData(profileDo, shortenUrl, profileUrl);
			}
		});
	}
	/**
	 * This method is called when the presenter is instantiated.
	 */
	@Override
	public void onBind() {
		super.onBind();
		
		setUserProfileBiographyAsyncCallback(new SimpleAsyncCallback<BiographyDo>() {

			@Override
			public void onSuccess(BiographyDo result) {
				if(result.getAboutMe()!=null){
					//getView().getProfileBiographyEditUC().setText(
						//result.getAboutMe());
					getView().getProfileDo().setAboutMe(result.getAboutMe());
				}
			}
		});

		setGetWorkSpaceAsyncCallback(new SimpleAsyncCallback<List<CollectionItemDo>>() {
			@Override
			public void onSuccess(List<CollectionItemDo> collectionItemDo) {
				getView().clearContentItemData();
				if(collectionItemDo.size()>0) {
					String folderId = AppClientFactory.getPlaceManager().getRequestParameter("folderid");
					if(folderId!=null) {
						getView().setMetaData(collectionItemDo.get(PARENT_FOLDER_ID));
					}
				}
				getView().setContentItemData(collectionItemDo);
				if(callBack.equalsIgnoreCase("reveal")) {
					profilePageListPresenter.setShelfListData(collectionItemDo);
				}
			}
		});
	}
	/**
	 * This method is used to get the url parameters.
	 */
	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
	}
	/**
	 * This method is use dto go to profile page.
	 */
	@Override
	public void requestFolderView(String collectionId, Map<String, String> params) {
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.PROFILE_PAGE, params);
	}
	/**
	 * This method is used to update profile visibility setting.
	 * 
	 */
	@Override
	public void updateProfileVisibilitySetting(String optionalValue) {
		AppClientFactory.getInjector().getUserService().updateUserProfileVisibility(
			AppClientFactory.getLoggedInUser().getGooruUId(), optionalValue, new SimpleAsyncCallback<ProfilePageDo>() {
				@Override
				public void onSuccess(ProfilePageDo result) {
					
				}
		});
	}

	/** 
	 * This method is to get the profilePageService
	 */
	public ProfilePageServiceAsync getProfilePageService() {
		return profilePageService;
	}

	/** 
	 * This method is to set the profilePageService
	 */
	public void setProfilePageService(ProfilePageServiceAsync profilePageService) {
		this.profilePageService = profilePageService;
	}

	/**
	 * @return the getGetWorkSpaceAsyncCallback
	 */
	public SimpleAsyncCallback<List<CollectionItemDo>> getGetWorkSpaceAsyncCallback() {
		return getWorkSpaceAsyncCallback;
	}

	/**
	 * @param getWorkSpaceAsyncCallback
	 *            the getWorkSpaceAsyncCallback to set
	 */
	public void setGetWorkSpaceAsyncCallback(
			SimpleAsyncCallback<List<CollectionItemDo>> getWorkSpaceAsyncCallback) {
		this.getWorkSpaceAsyncCallback = getWorkSpaceAsyncCallback;
	}
	/**
	 * @return the userProfileBiographyAsyncCallback
	 */
	public SimpleAsyncCallback<BiographyDo> getUserProfileBiographyAsyncCallback() {
		return userProfileBiographyAsyncCallback;
	}
	/**
	 * @param userProfileBiographyAsyncCallback
	 *            the userProfileBiographyAsyncCallback to set
	 */
	public void setUserProfileBiographyAsyncCallback(
			SimpleAsyncCallback<BiographyDo> userProfileBiographyAsyncCallback) {
		this.userProfileBiographyAsyncCallback = userProfileBiographyAsyncCallback;
	}
	/**
	 * This method is used to clear the Content Item Data and to set the Collection Data.
	 */
	@Override
	public void requestCollectionView(CollectionItemDo collectionItemDo,
			Map<String, String> params) {
		getView().clearContentItemData();
		getView().setCollectionData(collectionItemDo);
	}
	/**
	 * This method is used to show the upload image widget.
	 */
	@Override
	public void showUploadImageWidget() {
		//FIXME under age 13 
		imageUploadPresenter.showUploadTypeWidgets(false);
		addToPopupSlot(imageUploadPresenter);
		imageUploadPresenter.setPublicProfileImage(true);
		imageUploadPresenter.setCollectionImage(false);
		imageUploadPresenter.setEditResourceImage(false);
	}
	/**
	 * This method is used to set the profile image.
	 */
	@Override
	public void setUserProfileImage(String imageUrl) {
		getView().setUserProfileImage(imageUrl);
	}
	/**
	 * This methodis used to update user biography.
	 */
	@Override
	public void updateUserBiography(String gooruUid, String bioText, String userType,
			String firstName, String lastName, String gender) {
		AppClientFactory.getInjector().getUserService().updateProfileBiography(
				AppClientFactory.getPlaceManager().getRequestParameter(
						gooruUid), bioText, userType, firstName, lastName,
						gender, getUserProfileBiographyAsyncCallback());
	}
	/**
	 * This method is used to add course.
	 */
	@Override
	public void addCourse(Set<ProfileCodeDo> profileCodeDo) {
		AppClientFactory.getInjector().getProfilePageService().addCourseUserProfile(profileCodeDo, "profilePage", new SimpleAsyncCallback<Void>(){
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
		AppClientFactory.getInjector().getProfilePageService().deleteCourseUserProfile(codeDo, "profilePage", new SimpleAsyncCallback<Void>(){
			@Override
			public void onSuccess(Void result) {
				
			}
		});
	}
	/**
	 * 
	 * @function isUserUnder13 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :Returns isUserUnder13.
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
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This is used to set isUserUnder13.
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
	 * This method is used to get taxonomy data.
	 */
	@Override
	public void getTaxonomyData() {
		final String userId = AppClientFactory.getPlaceManager().getRequestParameter("id");
		if(userId.equalsIgnoreCase(AppClientFactory.getLoggedInUser().getGooruUId())) {
			AppClientFactory.getInjector().getTaxonomyService().getCourse(new SimpleAsyncCallback<List<LibraryCodeDo>>() {
				@Override
				public void onSuccess(List<LibraryCodeDo> result) {
					getView().setCourseList(result);
				}
			});
		}
	}
}
