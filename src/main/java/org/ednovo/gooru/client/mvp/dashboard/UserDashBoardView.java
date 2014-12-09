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
package org.ednovo.gooru.client.mvp.dashboard;

import java.util.Map;

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.client.util.ProfileAnalyticsChat;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.code.UserDashBoardCommonInfoDO;
import org.ednovo.gooru.shared.model.user.ProfileRatingsReactionsDO;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;


/**
 * 
 * @fileName : UserDashBoardView.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 07-Dec-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
public class UserDashBoardView extends BaseViewWithHandlers<UserDashBoardUiHandlers> implements IsUserDashBoardView{
	
	@UiField HTMLPanel profileActivityBreakDown,CollectionsPublishedWidget,ResourceAddedWidget,commentsMadeWIdget,endorsementsGivenWidget,reviewsWrittenWidget,
	topRemixedCollectionsWidget,topEndorsedCollectionsWidget,fiveStarRatedResourcesWidget,reactionsWidgetPanel,reactionsGivenWidget,ratingsGivenWidget,googleMapContainer;
	@UiField HTMLEventPanel profileAnalyticsGrageContainer;
	
	private static UserDashBoardViewUiBinder uiBinder = GWT
			.create(UserDashBoardViewUiBinder.class);

	interface UserDashBoardViewUiBinder extends
			UiBinder<Widget, UserDashBoardView> {

	}
	TopRemixedAndEndorsedCollections topEndorsedCollection,topRemixedCollection;
	FiveStarRatings fiveStarRatings,fiveStarReactions;
	
	public MessageProperties i18n = GWT.create(MessageProperties.class);
	
	public interface Binder extends UiBinder<Widget, UserDashBoardView> {
	}
	ProfileAnalyticsChat profileAnalyticChat=new ProfileAnalyticsChat();
	/**
	 * Constructor
	 */
	@Inject
	public UserDashBoardView() {
		setWidget(uiBinder.createAndBindUi(this));
		ResourceAddedWidget.add(new UserDashBoardCommonInfo(new Label(Integer.toString(132)),new Label("Resources Added")));
		endorsementsGivenWidget.add(new UserDashBoardCommonInfo(new Label(Integer.toString(26)),new Label("endorsements given")));
		googleMapContainer.add(new GoogleMapWidget());
		profileAnalyticsGrageContainer.add(new ProfileAnalyticsGradeWidget());
		profileActivityBreakDown.add(profileAnalyticChat.createChart());
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.dashboard.IsUserDashBoardView#dispalyDashBoardHomePage()
	 */
	@Override
	public void dispalyDashBoardHomePage() {
		
	}
	/**
	 * 
	 * @function setGraphData 
	 * 
	 * @created_date : 07-Dec-2014
	 * 
	 * @description
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
	public void setGraphData(){
	}
	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.dashboard.IsUserDashBoardView#setProfileAnalyticsFlaggedChatData(java.util.Map)
	 */
	@Override
	public void setProfileAnalyticsFlaggedChatData(Map<String, Integer> result) {
		profileAnalyticChat.updateProfileAnalyticsFlaggedChatData(result);
	}
	
	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.dashboard.IsUserDashBoardView#setProfileAnalyticsSharedChatData(java.util.Map)
	 */
	@Override
	public void setProfileAnalyticsSharedChatData(Map<String, Integer> result) {
		profileAnalyticChat.updateProfileAnalyticsSharedChatData(result);
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.dashboard.IsUserDashBoardView#setProfileAnalyticsViewsChatData(java.util.Map)
	 */
	@Override
	public void setProfileAnalyticsViewsChatData(Map<String, Integer> result) {
		profileAnalyticChat.updateProfileAnalyticsViewsChatData(result);
	}
	
	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.dashboard.IsUserDashBoardView#setProfileAnalyticsAddedCollectionChatData(java.util.Map)
	 */
	@Override
	public void setProfileAnalyticsAddedCollectionChatData(Map<String, Integer> result) {
		profileAnalyticChat.updateProfileAnalyticsAddedToCollectionChatData(result);
	}
	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.dashboard.IsUserDashBoardView#setPublishedCollectionData(org.ednovo.gooru.shared.model.code.UserDashBoardCommonInfoDO)
	 */
	public void setPublishedCollectionData(UserDashBoardCommonInfoDO result) {
		CollectionsPublishedWidget.add(new UserDashBoardCommonInfo(new Label(Integer.toString(result.getContent().get(0).getPublishedCollection())),new Label("Collections Published")));
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.dashboard.IsUserDashBoardView#setProfileRatingsData(org.ednovo.gooru.shared.model.user.ProfileRatingsReactionsDO)
	 */
	@Override
	public void getFiveStarRatedResults(UserDashBoardCommonInfoDO result) {
		fiveStarRatedResourcesWidget.add(fiveStarRatings=new FiveStarRatings("fivestarRatings",result));
		fiveStarRatings.getViewAllLabel().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				getUiHandlers().clickedOnMoreButton(null,"true");
			}
		});
	}

	@Override
	public void getFiveStarReviewedResources(UserDashBoardCommonInfoDO result) {
		reactionsWidgetPanel.add(fiveStarReactions=new FiveStarRatings("fivestarReviews",result));
		fiveStarReactions.getViewAllLabel().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				getUiHandlers().clickedOnMoreButton(null,"false");
			}
		});
	}
	/**
	 * This method is used to set the count of comments,reviews written and ratings
	 */
	public void setProfileRatingsData(ProfileRatingsReactionsDO result) {
		commentsMadeWIdget.add(new UserDashBoardCommonInfo(new Label(Integer.toString(result.getCommentCount())),new Label("Comments Made")));
		reviewsWrittenWidget.add(new UserDashBoardCommonInfo(new Label(Integer.toString(result.getReviewCount())),new Label("Reviews Written")));
		ratingsGivenWidget.add(new ReactionsAndRatingsGivenCommonInfo("ratings",result));
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.dashboard.IsUserDashBoardView#setProfileReationsData(org.ednovo.gooru.shared.model.user.ProfileRatingsReactionsDO)
	 */
	@Override
	public void setProfileReationsData(ProfileRatingsReactionsDO result) {
		reactionsGivenWidget.add(new ReactionsAndRatingsGivenCommonInfo("reactions",result));

	}
	/**
	 * This method is used to set the top viewed collections info 
	 */
	@Override
	public void getTopViewedCOllectionsData(UserDashBoardCommonInfoDO result) {
		topEndorsedCollectionsWidget.add(topEndorsedCollection=new TopRemixedAndEndorsedCollections("Top Endorsed Collections",result));
		topEndorsedCollection.getClickOnMorelbl().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				getUiHandlers().clickedOnMoreButton("true", null);
			}
		});
		topRemixedCollectionsWidget.add(topRemixedCollection=new TopRemixedAndEndorsedCollections("Top Remixed Collections",result));
		topRemixedCollection.getClickOnMorelbl().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				getUiHandlers().clickedOnMoreButton("false",null);
			}
		});
	}
}