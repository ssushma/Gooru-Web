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

/**
 * @fileName : IsUserSettingsView.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: Apr 18, 2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: 
 */


import java.util.Map;

import org.ednovo.gooru.client.gin.IsViewWithHandlers;
import org.ednovo.gooru.shared.model.code.UserDashBoardCommonInfoDO;
import org.ednovo.gooru.shared.model.user.ProfileRatingsReactionsDO;

public interface IsUserDashBoardView extends IsViewWithHandlers<UserDashBoardUiHandlers>{

	void dispalyDashBoardHomePage();
	
	void setProfileAnalyticsFlaggedChatData(Map<String, Integer> result);
	
	void setProfileAnalyticsViewsChatData(Map<String, Integer> result);
	
	void setProfileAnalyticsSharedChatData(Map<String, Integer> result);
	
	void setProfileAnalyticsAddedCollectionChatData(Map<String, Integer> result);

	void setPublishedCollectionData(UserDashBoardCommonInfoDO result);


	void getFiveStarRatedResults(UserDashBoardCommonInfoDO result);

	void getFiveStarReviewedResources(UserDashBoardCommonInfoDO result);

	
	void setProfileRatingsData(ProfileRatingsReactionsDO result);
	
	void setProfileReationsData(ProfileRatingsReactionsDO result);

}
