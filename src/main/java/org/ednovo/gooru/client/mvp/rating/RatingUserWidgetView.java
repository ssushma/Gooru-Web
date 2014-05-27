package org.ednovo.gooru.client.mvp.rating;

import java.util.ArrayList;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.rating.events.UpdateUserStarReviewEvent;
import org.ednovo.gooru.shared.model.content.StarRatingsDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class RatingUserWidgetView extends Composite {

	@UiField HTMLPanel reviewContainer;
	
	@UiField Label userName, timeStamp, review,mouseOverStarValue,starValue;
	
	@UiField Button editReview,editReviewBtn,cancelReviewBtn;
	
	@UiField HTMLPanel editReviewTextareaContainer,editReviewLabelContainer;
	
	@UiField InlineHTML starOne,starTwo,starThree,starFour,starFive;
	
	@UiField TextArea editReviewText;
	
	@UiField InlineHTML userratingOne,userratingTwo,userratingThree,userratingFour,userratingFive;
	
	@UiField RatingAndReviewStyleBundle style;
	
	private static final String ONE_STAR="oneStar";
	private static final String TWO_STAR="twoStar";
	private static final String THREE_STAR="threeStar";
	private static final String FOUR_STAR="fourStar";
	private static final String FIVE_STAR="fiveStar";
	
	private StarRatingsDo starRatingsDo;
	private static final String POOR="Poor";
	private static final String FAIR="Fair";
	private static final String GOOD="Good";
	private static final String VERY_GOOD="Very Good";
	private static final String EXCELLENT="Excellent";
	
	int currentRating=0,clickedRating;
	private static final String FILLED_BLUE = "filled filledBlue";
	
	private static RatingUserWidgetViewUiBinder uiBinder = GWT
			.create(RatingUserWidgetViewUiBinder.class);

	interface RatingUserWidgetViewUiBinder extends
			UiBinder<Widget, RatingUserWidgetView> {
	}

	public RatingUserWidgetView(StarRatingsDo starRatingsDo) {
		initWidget(uiBinder.createAndBindUi(this));
		setData(starRatingsDo);
		this.starRatingsDo = starRatingsDo;
	}
	public void setData(StarRatingsDo starRatingsDo) {
		//timeStamp.setText("3 days ago");
		currentRating = starRatingsDo.getScore();
		review.setText(starRatingsDo.getFreeText());
		editReviewText.setText(starRatingsDo.getFreeText());
		editReview.setVisible(false);
		editReviewTextareaContainer.setVisible(false);
	
			userName.setText(starRatingsDo.getCreator().getUsername());
			if(starRatingsDo.getScore() == 1)
			{
				System.out.println("here1");
				clearAllStarsReadOnly();
				starOne.addStyleName(style.filled());
				starTwo.removeStyleName(style.filled());
				starThree.removeStyleName(style.filled());
				starFour.removeStyleName(style.filled());
				starFive.removeStyleName(style.filled());
			}
			else if(starRatingsDo.getScore() == 2)
			{
				clearAllStarsReadOnly();
				starOne.addStyleName(style.filled());
				starTwo.addStyleName(style.filled());
				starThree.removeStyleName(style.filled());
				starFour.removeStyleName(style.filled());
				starFive.removeStyleName(style.filled());
			}
			else if(starRatingsDo.getScore() == 3)
			{
				clearAllStarsReadOnly();
				starOne.addStyleName(style.filled());
				starTwo.addStyleName(style.filled());
				starThree.addStyleName(style.filled());
				starFour.removeStyleName(style.filled());
				starFive.removeStyleName(style.filled());
			}
			else if(starRatingsDo.getScore() == 4)
			{
				starOne.addStyleName(style.filled());
				starTwo.addStyleName(style.filled());
				starThree.addStyleName(style.filled());
				starFour.addStyleName(style.filled());
				starFive.removeStyleName(style.filled());
			}
			else if(starRatingsDo.getScore() == 5)
			{
				starOne.addStyleName(style.filled());
				starTwo.addStyleName(style.filled());
				starThree.addStyleName(style.filled());
				starFour.addStyleName(style.filled());
				starFive.addStyleName(style.filled());
			}
			
		  if(starRatingsDo.getFreeText()!=null && !starRatingsDo.getFreeText().equals("")){
			reviewContainer.setVisible(true);
			editReviewLabelContainer.setVisible(true);
		  }else{
			reviewContainer.setVisible(false);
			userName.setText(starRatingsDo.getCreator().getUsername());
			editReviewLabelContainer.setVisible(false);
		}
			
		if(starRatingsDo.getCreator().getUsername().equals(AppClientFactory.getLoggedInUser().getUsername())) {
			reviewContainer.addStyleName(style.creatorReviewPanel());
			editReview.addStyleName(style.editReview());
			editReviewBtn.removeStyleName(style.editReview());
			cancelReviewBtn.removeStyleName(style.editReview());
			editReview.setVisible(true);
			userName.setText("Your Rating and Review!");
	
		} else {
			editReview.removeStyleName(style.editReview());
		}
		
	}
	
	@UiHandler("editReview")
	public void editReview(ClickEvent event) {
		editReviewTextareaContainer.setVisible(true);
		editReviewLabelContainer.setVisible(false);
		getStarsData(Integer.toString(currentRating));
		userratingOne.addMouseOverHandler(new OnStarMouseOver(ONE_STAR));
		userratingTwo.addMouseOverHandler(new OnStarMouseOver(TWO_STAR));
		userratingThree.addMouseOverHandler(new OnStarMouseOver(THREE_STAR));
		userratingFour.addMouseOverHandler(new OnStarMouseOver(FOUR_STAR));
		userratingFive.addMouseOverHandler(new OnStarMouseOver(FIVE_STAR));
		
		userratingOne.addMouseOutHandler(new OnStarMouseOut(ONE_STAR));
		userratingTwo.addMouseOutHandler(new OnStarMouseOut(TWO_STAR));
		userratingThree.addMouseOutHandler(new OnStarMouseOut(THREE_STAR));
		userratingFour.addMouseOutHandler(new OnStarMouseOut(FOUR_STAR));
		userratingFive.addMouseOutHandler(new OnStarMouseOut(FIVE_STAR));
		editReviewBtn.removeStyleName(style.editReview());
		cancelReviewBtn.removeStyleName(style.editReview());
	}

	private void getStarsData(String starScore) {
		System.out.println("starScore::::::"+starScore);
		clearAllStars();
		if(starScore.equalsIgnoreCase(ONE_STAR)){
			mouseOverStarValue.setText(POOR);
			userratingOne.getElement().addClassName(FILLED_BLUE);
		}else if(starScore.equalsIgnoreCase(TWO_STAR)){
			mouseOverStarValue.setText(FAIR);
			userratingOne.getElement().addClassName(FILLED_BLUE);
			userratingTwo.getElement().addClassName(FILLED_BLUE);
		}else if(starScore.equalsIgnoreCase(THREE_STAR)){
			mouseOverStarValue.setText(GOOD);
			userratingOne.getElement().addClassName(FILLED_BLUE);
			userratingTwo.getElement().addClassName(FILLED_BLUE);
			userratingThree.getElement().addClassName(FILLED_BLUE);
		}else if(starScore.equalsIgnoreCase(FOUR_STAR)){
			mouseOverStarValue.setText(VERY_GOOD);
			userratingOne.getElement().addClassName(FILLED_BLUE);
			userratingTwo.getElement().addClassName(FILLED_BLUE);
			userratingThree.getElement().addClassName(FILLED_BLUE);
			userratingFour.getElement().addClassName(FILLED_BLUE);
		}else if(starScore.equalsIgnoreCase(FIVE_STAR)){
			mouseOverStarValue.setText(EXCELLENT);
			userratingOne.getElement().addClassName(FILLED_BLUE);
			userratingTwo.getElement().addClassName(FILLED_BLUE);
			userratingThree.getElement().addClassName(FILLED_BLUE);
			userratingFour.getElement().addClassName(FILLED_BLUE);
			userratingFive.getElement().addClassName(FILLED_BLUE);
		}
	
		
	}
	@UiHandler("editReviewBtn")
	public void editReviewForEditingReview(ClickEvent event) {
	AppClientFactory.getInjector().getPlayerAppService().updateResourceStarReviews(starRatingsDo.getDeleteRatingGooruOid(),this.currentRating, editReviewText.getText(), new SimpleAsyncCallback<ArrayList<StarRatingsDo>>(){
		@Override
		public void onSuccess(ArrayList<StarRatingsDo> result) {
			if(result.size()>0){
				AppClientFactory.fireEvent(new UpdateUserStarReviewEvent(result));
				editReviewTextareaContainer.setVisible(false);
				review.setText(result.get(0).getFreeText());
				editReviewLabelContainer.setVisible(true);
				editReviewBtn.removeStyleName(style.editReview());
				cancelReviewBtn.removeStyleName(style.editReview());
				System.out.println(result.get(0));
				updateStars(result.get(0));
			}
		}
	}); 
		
	}
	
	private void updateStars(StarRatingsDo starRatingsDo) {
		clearAllStarsReadOnly();
		// TODO Auto-generated method stub
		if(starRatingsDo.getScore() == 1)
		{
			System.out.println("here1");
			starOne.addStyleName(style.filled());
			starTwo.removeStyleName(style.filled());
			starThree.removeStyleName(style.filled());
			starFour.removeStyleName(style.filled());
			starFive.removeStyleName(style.filled());
		}
		else if(starRatingsDo.getScore() == 2)
		{
			
			starOne.addStyleName(style.filled());
			starTwo.addStyleName(style.filled());
			starThree.removeStyleName(style.filled());
			starFour.removeStyleName(style.filled());
			starFive.removeStyleName(style.filled());
		}
		else if(starRatingsDo.getScore() == 3)
		{
			
			starOne.addStyleName(style.filled());
			starTwo.addStyleName(style.filled());
			starThree.addStyleName(style.filled());
			starFour.removeStyleName(style.filled());
			starFive.removeStyleName(style.filled());
		}
		else if(starRatingsDo.getScore() == 4)
		{
			starOne.addStyleName(style.filled());
			starTwo.addStyleName(style.filled());
			starThree.addStyleName(style.filled());
			starFour.addStyleName(style.filled());
			starFive.removeStyleName(style.filled());
		}
		else if(starRatingsDo.getScore() == 5)
		{
			starOne.addStyleName(style.filled());
			starTwo.addStyleName(style.filled());
			starThree.addStyleName(style.filled());
			starFour.addStyleName(style.filled());
			starFive.addStyleName(style.filled());
		}
	}
	
	
	@UiHandler("userratingOne")
	public void userratingOne(ClickEvent event) {
		clickedRating=1;
		this.currentRating =1;
		userratingOne.addStyleName(FILLED_BLUE);
		userratingTwo.removeStyleName(FILLED_BLUE);
		userratingThree.removeStyleName(FILLED_BLUE);
		userratingFour.removeStyleName(FILLED_BLUE);
		userratingFive.removeStyleName(FILLED_BLUE);
		
	}

	@UiHandler("userratingTwo")
	public void userratingTwo(ClickEvent event) {
		this.currentRating =2;
		userratingOne.addStyleName(FILLED_BLUE);
		userratingTwo.addStyleName(FILLED_BLUE);
		userratingThree.removeStyleName(FILLED_BLUE);
		userratingFour.removeStyleName(FILLED_BLUE);
		userratingFive.removeStyleName(FILLED_BLUE);
	
	}
	@UiHandler("userratingThree")
	public void userratingThree(ClickEvent event) {
		this.currentRating =3;
		userratingOne.addStyleName(FILLED_BLUE);
		userratingTwo.addStyleName(FILLED_BLUE);
		userratingThree.addStyleName(FILLED_BLUE);
		userratingFour.removeStyleName(FILLED_BLUE);
		userratingFive.removeStyleName(FILLED_BLUE);
	}
	@UiHandler("userratingFour")
	public void userratingFour(ClickEvent event) {
		this.currentRating =4;
		userratingOne.addStyleName(FILLED_BLUE);
		userratingTwo.addStyleName(FILLED_BLUE);
		userratingThree.addStyleName(FILLED_BLUE);
		userratingFour.addStyleName(FILLED_BLUE);
		userratingFive.removeStyleName(FILLED_BLUE);
	}
	@UiHandler("userratingFive")
	public void userratingFive(ClickEvent event) {
		this.currentRating =5;
		userratingOne.addStyleName(FILLED_BLUE);
		userratingTwo.addStyleName(FILLED_BLUE);
		userratingThree.addStyleName(FILLED_BLUE);
		userratingFour.addStyleName(FILLED_BLUE);
		userratingFive.addStyleName(FILLED_BLUE);
	}
	@UiHandler("cancelReviewBtn")
	public void cancelReview(ClickEvent event) {
		editReviewTextareaContainer.setVisible(false);
		editReviewLabelContainer.setVisible(true);
		editReviewBtn.removeStyleName(style.editReview());
		cancelReviewBtn.removeStyleName(style.editReview());
	}
	
	
	public class OnStarMouseOver implements MouseOverHandler{
		private String starScore="";
		/**
		 * Class Constructor.
		 * @param starScore {@link String}
		 */
		public OnStarMouseOver(String starScore) {
			this.starScore=starScore;
		}
		@Override
		public void onMouseOver(MouseOverEvent event) {
			clearAllStars();
			if(starScore.equalsIgnoreCase(ONE_STAR)){
				mouseOverStarValue.setText(POOR);
				userratingOne.getElement().addClassName(FILLED_BLUE);
			}else if(starScore.equalsIgnoreCase(TWO_STAR)){
				mouseOverStarValue.setText(FAIR);
				userratingOne.getElement().addClassName(FILLED_BLUE);
				userratingTwo.getElement().addClassName(FILLED_BLUE);
			}else if(starScore.equalsIgnoreCase(THREE_STAR)){
				mouseOverStarValue.setText(GOOD);
				userratingOne.getElement().addClassName(FILLED_BLUE);
				userratingTwo.getElement().addClassName(FILLED_BLUE);
				userratingThree.getElement().addClassName(FILLED_BLUE);
			}else if(starScore.equalsIgnoreCase(FOUR_STAR)){
				mouseOverStarValue.setText(VERY_GOOD);
				userratingOne.getElement().addClassName(FILLED_BLUE);
				userratingTwo.getElement().addClassName(FILLED_BLUE);
				userratingThree.getElement().addClassName(FILLED_BLUE);
				userratingFour.getElement().addClassName(FILLED_BLUE);
			}else if(starScore.equalsIgnoreCase(FIVE_STAR)){
				mouseOverStarValue.setText(EXCELLENT);
				userratingOne.getElement().addClassName(FILLED_BLUE);
				userratingTwo.getElement().addClassName(FILLED_BLUE);
				userratingThree.getElement().addClassName(FILLED_BLUE);
				userratingFour.getElement().addClassName(FILLED_BLUE);
				userratingFive.getElement().addClassName(FILLED_BLUE);
			}
		}
		
	}
	
	public class OnStarMouseOut implements MouseOutHandler{
		private String starScore="";
		public OnStarMouseOut(String starScore) {
			this.starScore=starScore;
		}

		@Override
		public void onMouseOut(MouseOutEvent event) {
			clearAllStars();
			if(starScore.equalsIgnoreCase(ONE_STAR)){
				starValue.setVisible(true);
				mouseOverStarValue.setText("");
			}else if(starScore.equalsIgnoreCase(TWO_STAR)){
				starValue.setVisible(true);
				mouseOverStarValue.setText("");
			}else if(starScore.equalsIgnoreCase(THREE_STAR)){
				starValue.setVisible(true);
				mouseOverStarValue.setText("");
			}else if(starScore.equalsIgnoreCase(FOUR_STAR)){
				starValue.setVisible(true);
				mouseOverStarValue.setText("");
			}else if(starScore.equalsIgnoreCase(FIVE_STAR)){
				starValue.setVisible(true);
				mouseOverStarValue.setText("");
			}
			setStarRatingValue(currentRating);
		}

		private void setStarRatingValue(int currentRating) {
			clearAllStars();
			if(currentRating==1){
				userratingOne.getElement().addClassName(FILLED_BLUE);
			}else if(currentRating==2){
				userratingOne.getElement().addClassName(FILLED_BLUE);
				userratingTwo.getElement().addClassName(FILLED_BLUE);
			}else if(currentRating==3){
				userratingOne.getElement().addClassName(FILLED_BLUE);
				userratingTwo.getElement().addClassName(FILLED_BLUE);
				userratingThree.getElement().addClassName(FILLED_BLUE);
			}else if(currentRating==4){
				userratingOne.getElement().addClassName(FILLED_BLUE);
				userratingTwo.getElement().addClassName(FILLED_BLUE);
				userratingThree.getElement().addClassName(FILLED_BLUE);
				userratingFour.getElement().addClassName(FILLED_BLUE);
			}else if(currentRating==5){
				userratingOne.getElement().addClassName(FILLED_BLUE);
				userratingTwo.getElement().addClassName(FILLED_BLUE);
				userratingThree.getElement().addClassName(FILLED_BLUE);
				userratingFour.getElement().addClassName(FILLED_BLUE);
				userratingFive.getElement().addClassName(FILLED_BLUE);
			}else{
				clearAllStars();
			}
		}
	}
	
	public void clearAllStars(){
		userratingOne.getElement().removeClassName(FILLED_BLUE);
		userratingTwo.getElement().removeClassName(FILLED_BLUE);
		userratingThree.getElement().removeClassName(FILLED_BLUE);
		userratingFour.getElement().removeClassName(FILLED_BLUE);
		userratingFive.getElement().removeClassName(FILLED_BLUE);
	}
	public void clearAllStarsReadOnly(){
		starOne.removeStyleName(style.filled());
		starTwo.removeStyleName(style.filled());
		starThree.removeStyleName(style.filled());
		starFour.removeStyleName(style.filled());
		starFive.removeStyleName(style.filled());
	}
}