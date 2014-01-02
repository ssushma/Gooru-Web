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

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.child.ChildView;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.dnd.IsDraggableMirage;
import org.ednovo.gooru.client.mvp.home.LoginPopupUc;
import org.ednovo.gooru.client.mvp.socialshare.event.UpdateSocialShareMetaDataEvent;
import org.ednovo.gooru.client.mvp.socialshare.event.UpdateSocialShareMetaDataHandler;
import org.ednovo.gooru.client.service.UserServiceAsync;
import org.ednovo.gooru.client.uc.EmailShareUc;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.social.SocialShareDo;
import org.ednovo.gooru.shared.model.user.SettingDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : SocialShareSmallView.java
 *
 * @description : This file used to share the user data by using 
 *                     social web-sites or through email.
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

public class SocialShareSmallView extends ChildView<SocialShareSmallPresenter> implements
IsSocialShareSmallView, MessageProperties {

	private static SocialShareSmallViewUiBinder uiBinder = GWT
			.create(SocialShareSmallViewUiBinder.class);

	interface SocialShareSmallViewUiBinder extends UiBinder<Widget, SocialShareSmallView> {
	}


	@UiField
	HTMLEventPanel fbPanel,twitterPanel,emailPanel,fbIconPanel,twIconPanel,emailIconPanel;

	@UiField
	HTMLPanel shareTextPanel,shareIconPanel,panelfbIcon,panelTwIcon, panelEmailIcon,panelTwitter,panelEmail,socialShareContainer;

	private SocialShareDo socialDo;

	private UserServiceAsync userService;

	private SimpleAsyncCallback<SettingDo> userProfileAsyncCallback;

	@UiField Image categoryImage;;

	@UiField
	SocialShareSmallStyle socialShareSmallStyle;

	private String category;

	private String description;	

	private static final String DEFULT_IMAGE = "images/default-collection-image.png";

	private static final String DEFULT_VIMAGE = "images/default-video.png";

	private static final String DEFULT_QIMAGE = "images/default-question.png";

	private static final String DEFULT_IIMAGE = "images/default-interactive.png";

	private static final String DEFULT_WIMAGE = "images/default-website.png";

	private static final String DEFULT_TIMAGE = "images/default-textbook.png";

	private static final String DEFULT_EIMAGE = "images/default-exam.png";

	private static final String DEFULT_SIMAGE = "images/default-slide.png";

	private static final String DEFULT_HIMAGE = "images/default-handout.png";

	private static final String DEFULT_LIMAGE = "images/default-lesson.png";

	private boolean isProfilePageView = false;

	/**
	 * Class constructor
	 * 
	 * @param collectionDo
	 *            instance of {@link CollectionDo}
	 */
	public SocialShareSmallView(SocialShareDo shareDo) {

		this.socialDo=shareDo;

		initWidget(uiBinder.createAndBindUi(this));

		category=socialDo.getCategoryType();

		description=socialDo.getDescription();
		String title=socialDo.getTitle();
		if(description==null){
			description = "";
		} else {
			description = description.replaceAll("\\<.*?\\>", "");
		}

		if(title==null){
			title="";
		}

		setPresenter(new SocialShareSmallPresenter(this));
		//		shareTextPanel.getElement().getStyle().setCursor(Cursor.POINTER);

		try {
			if(socialDo.getIsSearchShare()){
				socialShareContainer.getElement().getStyle().setWidth(100, Unit.PX);
			}
		} catch (Exception e) {

		}

		if (socialDo.isOnlyIcon()) {
			shareTextPanel.setVisible(false);
			shareIconPanel.setVisible(true);
		} else {
			shareIconPanel.setVisible(false);
			shareTextPanel.setVisible(true);
		}


		if(title.contains("img")){
			socialDo.setTitle("Question");
		}else{
			if (title.length() > 50) {
				title = title.substring(0,50)+ "...";
				socialDo.setTitle(title.replaceAll("<p>","").replaceAll("</p>", ""));
			}else{
				socialDo.setTitle(title.replaceAll("<p>","").replaceAll("</p>", ""));
			}
		}
		//        if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.SHELF)){
		if((socialDo.getShareType().equalsIgnoreCase("private"))){

			panelfbIcon.setStyleName(socialShareSmallStyle.classPageShareButtonsFTEBgDisable());
			panelTwIcon.setStyleName(socialShareSmallStyle.classPageShareButtonsFTEBgDisable());
			panelEmailIcon.setStyleName(socialShareSmallStyle.classPageShareButtonsFTEBgDisable());

			fbPanel.setStyleName(socialShareSmallStyle.classPageShareButtonsBgDisable());
			panelTwitter.setStyleName(socialShareSmallStyle.classPageShareButtonsBgDisable());
			panelEmail.setStyleName(socialShareSmallStyle.classPageShareButtonsBgDisable());

			//				shareTextPanel.getElement().getStyle().setCursor(Cursor.DEFAULT);
			//				shareIconPanel.getElement().getStyle().setCursor(Cursor.DEFAULT);
		}else{

			panelfbIcon.setStyleName(socialShareSmallStyle.fbPageShareIconButtonsBg());
			panelTwIcon.setStyleName(socialShareSmallStyle.twitterPageShareIconButtonsBg());
			panelEmailIcon.setStyleName(socialShareSmallStyle.classPageShareButtonsFTEBg());

			fbPanel.setStyleName(socialShareSmallStyle.fbPageShareButtonsBg());
			panelTwitter.setStyleName(socialShareSmallStyle.twitterPageShareButtonsBg());
			panelEmail.setStyleName(socialShareSmallStyle.classPageShareButtonsBg());

			//				shareTextPanel.getElement().getStyle().setCursor(Cursor.POINTER);
			//				shareIconPanel.getElement().getStyle().setCursor(Cursor.POINTER);
		}
		//		}

		categoryImage.addErrorHandler(new ErrorHandler() {

			@Override
			public void onError(ErrorEvent event) {
				String url = socialDo.getThumbnailurl();
				if (url == null || url.endsWith("null") || url.contains("null") || url.endsWith("/")){
					if(category==null){
						categoryImage.setUrl(DEFULT_IMAGE);
					}
					else if (category.equalsIgnoreCase("collection")) {
						categoryImage.setUrl(DEFULT_IMAGE);
					} else if (category.equalsIgnoreCase("video")) {
						categoryImage.setUrl(DEFULT_VIMAGE);
					} else if (category.equalsIgnoreCase("question")) {
						categoryImage.setUrl(DEFULT_QIMAGE);
					} else if (category.equalsIgnoreCase("interactive")) {
						categoryImage.setUrl(DEFULT_IIMAGE);
					} else if (category.equalsIgnoreCase("website")) {
						categoryImage.setUrl(DEFULT_WIMAGE);
					} else if (category.equalsIgnoreCase("slide")) {
						categoryImage.setUrl(DEFULT_SIMAGE);
					} else if (category.equalsIgnoreCase("textbook")) {
						categoryImage.setUrl(DEFULT_TIMAGE);
					} else if (category.equalsIgnoreCase("handout")) {
						categoryImage.setUrl(DEFULT_HIMAGE);
					} else if (category.equalsIgnoreCase("lesson")) {
						categoryImage.setUrl(DEFULT_LIMAGE);
					} else if (category.equalsIgnoreCase("exam")) {
						categoryImage.setUrl(DEFULT_EIMAGE);
					}
				}
				socialDo.setThumbnailurl(categoryImage.getUrl());
			}
		});
		setUrl(socialDo.getThumbnailurl());
		if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.PROFILE_PAGE)) {
			isProfilePageView = true;
		}

		/**
		 * Adding Event Handler.
		 * @param UpdateSocialShareMetaDataEvent.TYPE is type of event.
		 * @param setHeader is Object of Handler.
		 */
		AppClientFactory.getEventBus().addHandler(UpdateSocialShareMetaDataEvent.TYPE,setHeader);
	}
	/**
	 * 
	 * @function setSocialShareContainerId 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :This method is used to set socialShareId.
	 * 
	 * 
	 * @parm(s) : @param socialShareId
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setSocialShareContainerId(String socialShareId) {
		socialShareContainer.getElement().setId(socialShareId);
	}

	/**
	 * @param url
	 *            of the image
	 */
	public void setUrl(String url) {
		categoryImage.setUrl(StringUtil.formThumbnailName(url, "."));	
		categoryImage.setAltText(socialDo.getTitle());
		categoryImage.setTitle(socialDo.getTitle());
	}

	/**
	 * Call FaceBook share event
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("fbPanel")
	public void onFbClickEvent(ClickEvent event) {
		if(!(socialDo.getShareType().equalsIgnoreCase("private"))){
			if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.RESOURCE_SEARCH)){
				MixpanelUtil.Click_Facebook_FromResource();
			}else if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.COLLECTION_SEARCH)){
				MixpanelUtil.Click_Facebook_FromCollection();
			}
			else if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.COLLECTION_PLAY)){
				if(socialShareContainer.getElement().getId().equalsIgnoreCase("collectionShareViewPage")) {
					MixpanelUtil.ClickFacebookFromShareInCollectionplayer();
				} else if (socialShareContainer.getElement().getId().equalsIgnoreCase("collectionShareSummaryPage")) {
					MixpanelUtil.ClickFacebookFromSummaryPageInCollectionplayer();
				}

			}
			onFbShareEvent();
		}
	}
	/**
	 * Call FaceBook share event
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("fbIconPanel")
	public void onFbIconClickEvent(ClickEvent event){
		if(!isProfilePageView || !(socialDo.getShareType().equalsIgnoreCase("private"))){
			if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.RESOURCE_SEARCH)){
				MixpanelUtil.Click_Facebook_FromResource();
			}else if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.COLLECTION_SEARCH)){
				MixpanelUtil.Click_Facebook_FromCollection();
			}else if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.COLLECTION_PLAY)){
				if(socialShareContainer.getElement().getId().equalsIgnoreCase("collectionShareViewPage")) {
					MixpanelUtil.ClickFacebookFromShareInCollectionplayer();
				} else if (socialShareContainer.getElement().getId().equalsIgnoreCase("collectionShareSummaryPage")) {

					MixpanelUtil.ClickFacebookFromSummaryPageInCollectionplayer();
				}

			}

			onFbShareEvent();
		}
	}

	/**
	 * Call Email share event
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("emailPanel")
	public void onEmailClickEvent(ClickEvent event){
		if(!(socialDo.getShareType().equalsIgnoreCase("private"))){
			if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.RESOURCE_SEARCH)){
				MixpanelUtil.Click_Email_FromResource();
			}else if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.COLLECTION_SEARCH)){
				MixpanelUtil.Click_Email_FromCollection();
			}
			else if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.COLLECTION_PLAY)){
				if(socialShareContainer.getElement().getId().equalsIgnoreCase("collectionShareViewPage")) {
					MixpanelUtil.ClickEmailFromShareInCollectionplayer();
				} else if (socialShareContainer.getElement().getId().equalsIgnoreCase("collectionShareSummaryPage")) {
					MixpanelUtil.ClickEmailFromSummaryPageInCollectionplayer();
				}
			}
			onEmailShareEvent();
		}
	}
	/**
	 * Call Email share event
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("emailIconPanel")
	public void onEmailIconClickEvent(ClickEvent event){
		if(!isProfilePageView || !(socialDo.getShareType().equalsIgnoreCase("private"))){
			if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.RESOURCE_SEARCH)){
				MixpanelUtil.Click_Email_FromResource();
			}else if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.COLLECTION_SEARCH)){
				MixpanelUtil.Click_Email_FromCollection();

			}
			else if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.COLLECTION_PLAY)){
				if(socialShareContainer.getElement().getId().equalsIgnoreCase("collectionShareViewPage")) {
					MixpanelUtil.ClickEmailFromShareInCollectionplayer();
				} else if (socialShareContainer.getElement().getId().equalsIgnoreCase("collectionShareSummaryPage")) {
					MixpanelUtil.ClickEmailFromSummaryPageInCollectionplayer();
				}
			}

			onEmailShareEvent();
		}
	}

	/**
	 * Call Twitter share event
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("twitterPanel")
	public void onTwitterClickEvent(ClickEvent event) {
		if(!(socialDo.getShareType().equalsIgnoreCase("private"))){
			if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.RESOURCE_SEARCH)){
				MixpanelUtil.Click_Twitter_FromResource();
			}else if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.COLLECTION_SEARCH)){
				MixpanelUtil.Click_Twitter_FromCollection();
			}
			else if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.COLLECTION_PLAY)){
				if(socialShareContainer.getElement().getId().equalsIgnoreCase("collectionShareViewPage")) {
					MixpanelUtil.ClickTwitterFromShareInCollectionplayer();
				} else if (socialShareContainer.getElement().getId().equalsIgnoreCase("collectionShareSummaryPage")) {
					MixpanelUtil.ClickTwitterFromSummaryPageInCollectionplayer();
				}
			}
			onTwisterShareEvent();
		}
	}

	/**
	 * Call Twitter share event
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("twIconPanel")
	public void onTwitterIconClickEvent(ClickEvent event) {
		if(!isProfilePageView || !(socialDo.getShareType().equalsIgnoreCase("private"))){
			if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.RESOURCE_SEARCH)){
				MixpanelUtil.Click_Twitter_FromResource();
			}else if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.COLLECTION_SEARCH)){
				MixpanelUtil.Click_Twitter_FromCollection();

			}	else if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.COLLECTION_PLAY)){
				if(socialShareContainer.getElement().getId().equalsIgnoreCase("collectionShareViewPage")) {
					MixpanelUtil.ClickTwitterFromShareInCollectionplayer();
				} else if (socialShareContainer.getElement().getId().equalsIgnoreCase("collectionShareSummaryPage")) {
					MixpanelUtil.ClickTwitterFromSummaryPageInCollectionplayer();
				}
			}

			onTwisterShareEvent();
		}
	}

	/**
	 * Share the data by using FB.
	 */
	private void onFbShareEvent() {
		MixpanelUtil.Click_On_FaceBook();
		if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.PROFILE_PAGE)){
			if(socialDo.getIsSearchShare()){
				Window.open(
						"http://www.facebook.com/sharer/sharer.php?s=100&p[url]="
								+ socialDo.getRawUrl() + "&p[images][0]="
								+ socialDo.getThumbnailurl() + "&p[title]="
								+ socialDo.getTitle().replaceAll("\\+", "%2B") + "&p[summary]=" + description,
								"_blank", "width=626,height=436");
			}
			else{
				Window.open(
						"http://www.facebook.com/sharer/sharer.php?s=100&p[url]="
								+socialDo.getRawUrl() + "&p[images][0]="
								+ socialDo.getThumbnailurl() + "&p[title]="
								+ "Check out "+socialDo.getTitle().replaceAll("\\+", "%2B")+" on Gooru" + "&p[summary]=" + description,
								"_blank", "width=626,height=436");
			}
		}
		else{
			Window.open(
					"http://www.facebook.com/sharer/sharer.php?s=100&p[url]="
							+ socialDo.getRawUrl() + "&p[images][0]="
							+ socialDo.getThumbnailurl() + "&p[title]="
							+ socialDo.getTitle().replaceAll("\\+", "%2B") + "&p[summary]=" + description,
							"_blank", "width=626,height=436");
		}
	}

	/**
	 * Share the data by using Twister.
	 */
	private void onTwisterShareEvent() {
		MixpanelUtil.Click_On_Twitter();
		if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.PROFILE_PAGE)){
			if(socialDo.getIsSearchShare()){
				Window.open("http://twitter.com/intent/tweet?text=" + "Gooru - "+socialDo.getTitle().replaceAll("\\+", "%2B")+ ": " + socialDo.getBitlylink(), "_blank", "width=600,height=300");  
			}else{
				Window.open("http://twitter.com/intent/tweet?text=" + "Check out "+socialDo.getTitle().replaceAll("\\+", "%2B")+ "'s Gooru Profile Page - " + socialDo.getBitlylink(), "_blank", "width=600,height=300");
			}
		}else{
			Window.open("http://twitter.com/intent/tweet?text=" + "Gooru - "+socialDo.getTitle().replaceAll("\\+", "%2B")+ ": " + socialDo.getBitlylink(), "_blank", "width=600,height=300");
		}
	}
	/**
	 * Share the data by using Email.
	 */
	private void onEmailShareEvent() {
		MixpanelUtil.Click_On_Email();
		if(!(AppClientFactory.isAnonymous())){
			AppClientFactory.getInjector().getUserService().getUserProfileDetails(AppClientFactory.getLoggedInUser().getGooruUId(), new SimpleAsyncCallback<SettingDo>() {

				@Override
				public void onSuccess(SettingDo result) {
					socialDo.setEmailId(result.getExternalId());
					EmailShareUc emailShare=new EmailShareUc(socialDo);
					emailShare.show();
					emailShare.center();
				}
			});
		}else{
			LoginPopupUc popup = new LoginPopupUc();
			popup.setGlassEnabled(true);
			popup.show();
			popup.center();
		}
	}
	/**
	 * Returns Widget.
	 */
	@Override
	public Widget getDragHandle() {
		return null;
	}
	/**
	 * Returns IsDraggableMirage.
	 */
	@Override
	public IsDraggableMirage initDraggableMirage() {
		return null;
	}
	/**
	 * Executes on Blur handler of DragEvent.
	 */
	@Override
	public void onDragBlur() {
		// TODO Auto-generated method stub
	}
	/**
	 * This is used to get the Drag Id.
	 */
	@Override
	public String getDragId() {
		return null;
	}
	/**
	 * This is used to get the Drag Type.
	 */
	@Override
	public DRAG_TYPE getDragType() {
		return null;
	}
	/**
	 * This is used to get the Drag Top Correction.
	 */
	@Override
	public int getDragTopCorrection() {
		return 0;
	}
	/**
	 * This is used to get the Drag Left Correction.
	 */
	@Override
	public int getDragLeftCorrection() {
		return 0;
	}
	/**
	 * 
	 * @function setUserProfileAsyncCallback 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :setter method for userProfileAsyncCallback.
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
	public void setUserProfileAsyncCallback(SimpleAsyncCallback<SettingDo> userProfileAsyncCallback) {
		this.userProfileAsyncCallback = userProfileAsyncCallback;
	}
	/**
	 * 
	 * @function getUserService 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :Returns userService
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
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :Returns userProfileAsyncCallback
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
	 * Updating the User Meta data (Title, Description)
	 * by using UpdateSocialShareMetaDataHandler.
	 */
	UpdateSocialShareMetaDataHandler setHeader = new UpdateSocialShareMetaDataHandler() {
		@Override
		public void updateSocialShareMetaData(String title,
				String description1, String imageUrl) {
			socialDo.setTitle(title);

			socialDo.setDescription(description1);

			description = socialDo.getDescription();
			if(description==null){
				description = "";
			} else {
				description = description.replaceAll("\\<.*?\\>", "");
			}

			if (!imageUrl.equalsIgnoreCase("")) {
				socialDo.setThumbnailurl(imageUrl);
			}
		}
	};
}
