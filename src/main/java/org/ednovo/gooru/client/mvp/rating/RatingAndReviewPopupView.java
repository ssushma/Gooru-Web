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
package org.ednovo.gooru.client.mvp.rating;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.shared.model.content.ContentStarRatingsDo;
import org.ednovo.gooru.shared.model.content.ResourceTagsDo;
import org.ednovo.gooru.shared.model.content.StarRatingsDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;

public class RatingAndReviewPopupView extends PopupViewWithUiHandlers<RatingAndReviewPopupUiHandlers> implements IsRatingAndReviewPopupView,MessageProperties{

	public PopupPanel appPopUp;

	@UiField Label closeButton;

	@UiField Label lblResourceTitle;

	@UiField Label excellentScore, verygoodScore, goodScore, fairScore, poorScore;

	/*@UiField InlineLabel oneStar,twoStar,threeStar,fourStar,fiveStar,averageStarRating;*/

	@UiField HTMLPanel reviewsContainer, userRatingContainer, dataOne, dataTwo, dataThree, dataFour, dataFive;

	@UiField FlowPanel ratingWidgetPanel;

	@UiField Button rateResourceBtn;
	
	private String gooruOid = null;
	private String createrName = null;
	
	private boolean isRated=false;
	
	private RatingWidgetView ratingWidgetView= new RatingWidgetView();

	private static ResourceNarrationViewUiBinder uiBinder = GWT.create(ResourceNarrationViewUiBinder.class);

	interface ResourceNarrationViewUiBinder extends UiBinder<Widget, RatingAndReviewPopupView> {

	}

	@Inject
	public RatingAndReviewPopupView(EventBus eventsBus){
		super(eventsBus);
		appPopUp=new PopupPanel();
		appPopUp.setGlassEnabled(true);
		appPopUp.setWidget(uiBinder.createAndBindUi(this));
		PlayerBundle.INSTANCE.getPlayerStyle().ensureInjected();
	}

	@UiHandler("closeButton")
	public void closeRatingAndReviewPopup(ClickEvent event){
		String currentToken = AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken();
		hide();
		if (!currentToken.equalsIgnoreCase(PlaceTokens.PREVIEW_PLAY)){
			Window.enableScrolling(true);
		}
	}

	@Override
	public Widget asWidget() {
		return appPopUp;
	}
	@Override
	public void reset() {

	}
	@Override
	public void onLoad() {

	}
	@Override
	public void onUnload() {

	}

	@Override
	public void displayPopUp(String resourceTitle, String gooruOid,String createrName) {
		this.gooruOid = gooruOid;
		this.createrName = createrName;
		userRatingContainer.setVisible(false);
		lblResourceTitle.setText("Reviews for "+resourceTitle);
		getAverageRatingForContent(gooruOid);
		getUserRatingsAndReviews(gooruOid);
	}

	public void getUserRatingsAndReviews(String resourceId)
	{
		getUiHandlers().getUserRatingsReviews(resourceId);
	}

	public void getAverageRatingForContent(String resourceId)
	{
		getUiHandlers().getAverageRatingForContent(resourceId);
	}

	@Override
	public void setGraphAndAvgContentRating(ContentStarRatingsDo result) {
		setContentGraph(result); 
		ratingWidgetView.setAvgStarRating(result.getAverage());
		ratingWidgetView.getRatingCountLabel().setText(result.getCount().toString());
		ratingWidgetPanel.add(ratingWidgetView);
	}

	private void setContentGraph(ContentStarRatingsDo result) {
		
		int totalReviewCount = result.getScores().getFive() + result.getScores().getFour() + result.getScores().getThree() + result.getScores().getTwo() + result.getScores().getOne();
		
		dataFive.getElement().getStyle().setWidth(getBarGraphWidth(result.getScores().getFive(), totalReviewCount), Unit.PCT);
		dataFour.getElement().getStyle().setWidth(getBarGraphWidth(result.getScores().getFour(), totalReviewCount), Unit.PCT);
		dataThree.getElement().getStyle().setWidth(getBarGraphWidth(result.getScores().getThree(), totalReviewCount), Unit.PCT);
		dataTwo.getElement().getStyle().setWidth(getBarGraphWidth(result.getScores().getTwo(), totalReviewCount), Unit.PCT);
		dataOne.getElement().getStyle().setWidth(getBarGraphWidth(result.getScores().getOne(), totalReviewCount), Unit.PCT);
		
		excellentScore.setText("("+result.getScores().getFive()+")");
		verygoodScore.setText("("+result.getScores().getFour()+")");
		goodScore.setText("("+result.getScores().getThree()+")");
		fairScore.setText("("+result.getScores().getTwo()+")");
		poorScore.setText("("+result.getScores().getOne()+")");
	}

	private double getBarGraphWidth(Integer count, Integer totalCount) {
		double width = 0.0;
		if(totalCount>0) {
			width = ((double)count / (double)totalCount);
		}
		return (width * 100);
	}
	
	@Override
	public void setUserRatingsAndReviews(ArrayList<StarRatingsDo> result) {
		reviewsContainer.clear();
		if(result.size()>0)
		{
			for(int i=0;i<result.size();i++){
				if(result.get(i).getCreator().getUsername().equals(AppClientFactory.getLoggedInUser().getUsername())){
					isRated=true;
					break;
				}
			}
			if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.RESOURCE_SEARCH)){
				if(isRated){
					isRated=false;
					userRatingContainer.setVisible(false);
					
				}else{
					userRatingContainer.setVisible(true);
				}
			}
		}else{
			if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.RESOURCE_SEARCH)){
				userRatingContainer.setVisible(true);
			}
		}
		
		for(int userReviews=0; userReviews<result.size(); userReviews++)
		{
			reviewsContainer.add(new RatingUserWidgetView(result.get(userReviews),createrName));
		}

	}

	public class OnClickEditRatingButton implements ClickHandler{
		HTMLPanel htmlEdittingContainer;
		HTMLPanel ratingPanel;
		
		public OnClickEditRatingButton(HTMLPanel htmlEdittingContainer,HTMLPanel ratingPanel) {
			this.htmlEdittingContainer=htmlEdittingContainer;
			this.ratingPanel=ratingPanel;
		}

		@Override
		public void onClick(ClickEvent event) {
			htmlEdittingContainer.setVisible(true);
			ratingPanel.setVisible(false);
		}

	}

	public class OnClickCancelRatingButton implements ClickHandler{
		HTMLPanel htmlEdittingContainer;
		HTMLPanel ratingPanel;
		public OnClickCancelRatingButton(HTMLPanel htmlEdittingContainer,HTMLPanel ratingPanel) {
			this.htmlEdittingContainer=htmlEdittingContainer;
			this.ratingPanel=ratingPanel;
		}

		@Override
		public void onClick(ClickEvent event) {
			htmlEdittingContainer.setVisible(false);
			ratingPanel.setVisible(true);
		}

	}
	
	public class OnRatingReviewContainerMouseOver implements MouseOverHandler{
		Button btnEditRating;
		
		public OnRatingReviewContainerMouseOver(Button btnEditRating,Button btnDeleteRating) {
			this.btnEditRating=btnEditRating;
			
		}

		@Override
		public void onMouseOver(MouseOverEvent event) {
			btnEditRating.setVisible(true);
			
		}

	}
	
	public class OnRatingReviewContainerMouseOut implements MouseOutHandler{
		Button btnEditRating;
		public OnRatingReviewContainerMouseOut(Button btnEditRating) {
			this.btnEditRating=btnEditRating;
		}

		@Override
		public void onMouseOut(MouseOutEvent event) {
			btnEditRating.setVisible(false); 
		}

	}

	@UiHandler("rateResourceBtn")
	public void openResourcePlayer(ClickEvent event) {
		hide();
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", gooruOid);
		params.put("pn", "resource");
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.RESOURCE_PLAY, params);
	}
	


}
