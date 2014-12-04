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


*
* @description : 
*
* @version :1.0
*
* @date: APR 19 2013
   	
* @Author Gooru Team
* 
* Reviewer Gooru Team
*
*/
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.code.UserDashBoardCommonInfoDO;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;



public class UserDashBoardView extends BaseViewWithHandlers<UserDashBoardUiHandlers> implements IsUserDashBoardView{
	
	@UiField HTMLPanel CollectionsPublishedWidget,ResourceAddedWidget,commentsMadeWIdget,endorsementsGivenWidget,reviewsWrittenWidget,
	topRemixedCollectionsWidget,topEndorsedCollectionsWidget,fiveStarRatedResourcesWidget,reactionsWidgetPanel,reactionsGivenWidget,ratingsGivenWidget,googleMapContainer;
	@UiField HTMLEventPanel profileAnalyticsGrageContainer;
	
	
	private static UserDashBoardViewUiBinder uiBinder = GWT
			.create(UserDashBoardViewUiBinder.class);

	interface UserDashBoardViewUiBinder extends
			UiBinder<Widget, UserDashBoardView> {

	}
	
	public MessageProperties i18n = GWT.create(MessageProperties.class);
	
	public interface Binder extends UiBinder<Widget, UserDashBoardView> {
	}

	@Inject
	public UserDashBoardView() {
		setWidget(uiBinder.createAndBindUi(this));
		ResourceAddedWidget.add(new UserDashBoardCommonInfo(new Label(Integer.toString(132)),new Label("Resources Added")));
		commentsMadeWIdget.add(new UserDashBoardCommonInfo(new Label(Integer.toString(85)),new Label("Comments Made")));
		endorsementsGivenWidget.add(new UserDashBoardCommonInfo(new Label(Integer.toString(26)),new Label("endorsements given")));
		reviewsWrittenWidget.add(new UserDashBoardCommonInfo(new Label(Integer.toString(121)),new Label("Reviews Written")));
		topEndorsedCollectionsWidget.add(new TopRemixedAndEndorsedCollections("Top Endorsed Collections","Roman Poets","23 endorsments"));
		topRemixedCollectionsWidget.add(new TopRemixedAndEndorsedCollections("Top Remixed Collections","Dogs","12 remixes"));
		fiveStarRatedResourcesWidget.add(new FiveStarRatings("fivestarRatings"));
		reactionsWidgetPanel.add(new FiveStarRatings("fivestarReviews"));
		ratingsGivenWidget.add(new ReactionsAndRatingsGivenCommonInfo("ratings"));
		reactionsGivenWidget.add(new ReactionsAndRatingsGivenCommonInfo("reactions"));
		googleMapContainer.add(new GoogleMapWidget());
		profileAnalyticsGrageContainer.add(new ProfileAnalyticsGradeWidget());
	}

	@Override
	public void dispalyDashBoardHomePage() {
		
	}
	
	public void setGraphData(){
	}

	@Override
	public void setPublishedCollectionData(UserDashBoardCommonInfoDO result) {
		CollectionsPublishedWidget.add(new UserDashBoardCommonInfo(new Label(Integer.toString(result.getContent().get(0).getPublishedCollection())),new Label("Collections Published")));
	}
}