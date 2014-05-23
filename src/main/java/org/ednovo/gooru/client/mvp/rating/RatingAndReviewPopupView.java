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

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.shared.model.content.ContentStarRatingsDo;
import org.ednovo.gooru.shared.model.content.StarRatingsDo;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;

public class RatingAndReviewPopupView extends PopupViewWithUiHandlers<RatingAndReviewPopupUiHandlers> implements IsRatingAndReviewPopupView,MessageProperties{
	
	public PopupPanel appPopUp;
	
	@UiField Label closeButton;
	
	@UiField Label lblResourceTitle;
	
	@UiField Label excellentScore, verygoodScore, goodScore, fairScore, poorScore;
	
	@UiField InlineLabel oneStar,twoStar,threeStar,fourStar,fiveStar,averageStarRating;
	
	@UiField HTMLPanel reviewsContainer;
	
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
		hide();
		Window.enableScrolling(true);
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
	public void displayPopUp(ResourceSearchResultDo searchResultDo) {
		System.out.println("titlereceived::"+searchResultDo.getResourceTitle());
		lblResourceTitle.setText("Reviews for "+searchResultDo.getResourceTitle());
		getAverageRatingForContent(searchResultDo.getGooruOid());
		getUserRatingsAndReviews(searchResultDo.getGooruOid());
	}
	
	public void getUserRatingsAndReviews(String resourceId)
	{
		AppClientFactory.getInjector().getPlayerAppService().getResourceRatingWithReviews(resourceId,AppClientFactory.getLoggedInUser().getGooruUId(), new AsyncCallback<ArrayList<StarRatingsDo>>() {
			
			@Override
			public void onSuccess(ArrayList<StarRatingsDo> result) {
				
				reviewsContainer.clear();
				
				for(int userReviews=0; userReviews<result.size(); userReviews++)
				{
					HTMLEventPanel reviewContainer = new HTMLEventPanel("");
					HTMLPanel pnlHeader = new HTMLPanel("");
					final HTMLPanel htmlEdittingContainer = new HTMLPanel("");
					
					final HTMLPanel ratingPanel = new HTMLPanel("");
					
					HTML hrTag = new HTML("<hr/>");
					Label usernameLabel = new Label();
					usernameLabel.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().ratingUserName());
					if(result.get(userReviews).getCreator() != null)
					{
					if(result.get(userReviews).getCreator().getUsername().equalsIgnoreCase(AppClientFactory.getLoggedInUser().getUsername()))
					{
						pnlHeader.getElement().setAttribute("style", "height:38px;");
						reviewContainer.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().htmlUserReviewContainer());
						Button btnEditRating = new Button();
						btnEditRating.setText("Edit your rating and review");						
						btnEditRating.setStyleName("secondary");
						btnEditRating.addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().editRatingBtn());
					
						TextArea txtArea = new TextArea();
						txtArea.setText(result.get(userReviews).getFreeText());
						txtArea.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().textAreaRating());
						Button btnEditReview = new Button();
						Button btnCancel = new Button();
						
						btnEditReview.setText("Edit");
						btnEditReview.setStyleName("primary");
						btnCancel.setText("Cancel");
						btnCancel.setStyleName("secondary");
						
						htmlEdittingContainer.add(txtArea);
						htmlEdittingContainer.add(btnEditReview);		
						htmlEdittingContainer.add(btnCancel);
						
						htmlEdittingContainer.setVisible(false);
						
						btnEditRating.addClickHandler(new ClickHandler() {
							
							@Override
							public void onClick(ClickEvent event) {
								htmlEdittingContainer.setVisible(true);
								ratingPanel.setVisible(false);
								
							}
						});
						
				
					
/*						reviewContainer.addMouseOverHandler(new MouseOverHandler() {
							
							@Override
							public void onMouseOver(MouseOverEvent event) {
								btnEditRating.setVisible(true);
								
							}
						});
						reviewContainer.addMouseOutHandler(new MouseOutHandler() {
							
							@Override
							public void onMouseOut(MouseOutEvent event) {
								btnEditRating.setVisible(false);
								
							}
						});*/
						pnlHeader.add(btnEditRating);

						usernameLabel.setText("Your rating and review");	
					}
					else
					{
					usernameLabel.setText(result.get(userReviews).getCreator().getUsername());	
					}
					}
					pnlHeader.add(usernameLabel);
					reviewContainer.add(pnlHeader);
					RatingWidgetView ratingWidgetView=new RatingWidgetView();
					ratingWidgetView.getRatingCountLabel().setText(result.get(userReviews).getScore().toString());
					ratingWidgetView.setAvgStarRating(result.get(userReviews).getScore());
					//reviewsContainer.add(reviewContainer);
					reviewContainer.add(hrTag);					

					InlineLabel reviewsLabel = new InlineLabel();
					reviewsLabel.setText(result.get(userReviews).getFreeText());		
				
					
					ratingPanel.add(ratingWidgetView);
					ratingPanel.add(reviewsLabel);
					reviewContainer.add(ratingPanel);
					
					
					reviewContainer.add(htmlEdittingContainer);
					reviewsContainer.add(reviewContainer);
		
				}
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void getAverageRatingForContent(String resourceId)
	{
		AppClientFactory.getInjector().getPlayerAppService().getContentStarRatings(resourceId, new AsyncCallback<ContentStarRatingsDo>() {
			
			@Override
			public void onSuccess(ContentStarRatingsDo result) {
			
				excellentScore.setText("("+result.getScores().getFive()+")");
				verygoodScore.setText("("+result.getScores().getFour()+")");
				goodScore.setText("("+result.getScores().getThree()+")");
				fairScore.setText("("+result.getScores().getTwo()+")");
				poorScore.setText("("+result.getScores().getOne()+")");
				averageStarRating.setText("("+result.getCount()+")");
				int averageRating = (int) result.getAverage();
				
				oneStar.getElement().removeAttribute("class");
				twoStar.getElement().removeAttribute("class");
				threeStar.getElement().removeAttribute("class");
				fourStar.getElement().removeAttribute("class");
				fiveStar.getElement().removeAttribute("class");
				
				oneStar.getElement().addClassName(PlayerBundle.INSTANCE.getPlayerStyle().star());
				twoStar.getElement().addClassName(PlayerBundle.INSTANCE.getPlayerStyle().star());
				threeStar.getElement().addClassName(PlayerBundle.INSTANCE.getPlayerStyle().star());
				fourStar.getElement().addClassName(PlayerBundle.INSTANCE.getPlayerStyle().star());
				fiveStar.getElement().addClassName(PlayerBundle.INSTANCE.getPlayerStyle().star());
				
				if(averageRating == 1)
				{
					oneStar.getElement().addClassName(PlayerBundle.INSTANCE.getPlayerStyle().filled());
				}
				else if(averageRating == 2)
				{
					oneStar.getElement().addClassName(PlayerBundle.INSTANCE.getPlayerStyle().filled());
					twoStar.getElement().addClassName(PlayerBundle.INSTANCE.getPlayerStyle().filled());
				}
				else if(averageRating == 3)
				{
					oneStar.getElement().addClassName(PlayerBundle.INSTANCE.getPlayerStyle().filled());
					twoStar.getElement().addClassName(PlayerBundle.INSTANCE.getPlayerStyle().filled());
					threeStar.getElement().addClassName(PlayerBundle.INSTANCE.getPlayerStyle().filled());
				}
				else if(averageRating == 4)
				{
					oneStar.getElement().addClassName(PlayerBundle.INSTANCE.getPlayerStyle().filled());
					twoStar.getElement().addClassName(PlayerBundle.INSTANCE.getPlayerStyle().filled());
					threeStar.getElement().addClassName(PlayerBundle.INSTANCE.getPlayerStyle().filled());
					fourStar.getElement().addClassName(PlayerBundle.INSTANCE.getPlayerStyle().filled());
				}
				else if(averageRating == 5)
				{
					oneStar.getElement().addClassName(PlayerBundle.INSTANCE.getPlayerStyle().filled());
					twoStar.getElement().addClassName(PlayerBundle.INSTANCE.getPlayerStyle().filled());
					threeStar.getElement().addClassName(PlayerBundle.INSTANCE.getPlayerStyle().filled());
					fourStar.getElement().addClassName(PlayerBundle.INSTANCE.getPlayerStyle().filled());
					fiveStar.getElement().addClassName(PlayerBundle.INSTANCE.getPlayerStyle().filled());
				}
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}
	

	
}
