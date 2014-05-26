package org.ednovo.gooru.client.mvp.rating;

import java.util.Date;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.shared.model.content.StarRatingsDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class RatingUserWidgetView extends Composite implements MessageProperties {

	@UiField HTMLPanel reviewContainer;
	
	@UiField Label userName, timeStamp, review;
	
	@UiField Button editReview,editReviewBtn,cancelReviewBtn;
	
	@UiField HTMLPanel editReviewTextareaContainer,editReviewLabelContainer;
	
	@UiField InlineHTML starOne,starTwo,starThree,starFour,starFive;
	
	@UiField TextArea editReviewText;
	
	@UiField InlineHTML userratingOne,userratingTwo,userratingThree,userratingFour,userratingFive;
	
	@UiField RatingAndReviewStyleBundle style;
	
	private static final String DATE_FORMAT="MMMM dd, yyyy";
	
	private static RatingUserWidgetViewUiBinder uiBinder = GWT
			.create(RatingUserWidgetViewUiBinder.class);

	interface RatingUserWidgetViewUiBinder extends
			UiBinder<Widget, RatingUserWidgetView> {
	}

	public RatingUserWidgetView(StarRatingsDo starRatingsDo) {
		initWidget(uiBinder.createAndBindUi(this));
		setData(starRatingsDo);
	}
	
	public void setData(StarRatingsDo starRatingsDo) {
		String commentTime = getCreatedTime(Long.toString(starRatingsDo.getCreatedDate())); 
		timeStamp.setText(commentTime);
		review.setText(starRatingsDo.getFreeText());
		editReviewText.setText(starRatingsDo.getFreeText());
		editReview.setVisible(false);
		editReviewTextareaContainer.setVisible(false);
		if(starRatingsDo.getFreeText()!=null && !starRatingsDo.getFreeText().equals("")){
			reviewContainer.setVisible(true);
			editReviewLabelContainer.setVisible(true);
			userName.setText(starRatingsDo.getCreator().getUsername());
			if(starRatingsDo.getScore() == 1)
			{
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
		editReviewBtn.removeStyleName(style.editReview());
		cancelReviewBtn.removeStyleName(style.editReview());
	}
	
	@UiHandler("editReviewBtn")
	public void editReviewForEditingReview(ClickEvent event) {
	
	}
	@UiHandler("userratingOne")
	public void userratingOne(ClickEvent event) {
		userratingOne.addStyleName(style.filled());
		userratingTwo.removeStyleName(style.filled());
		userratingThree.removeStyleName(style.filled());
		userratingFour.removeStyleName(style.filled());
		userratingFive.removeStyleName(style.filled());
		
	}
	@UiHandler("userratingTwo")
	public void userratingTwo(ClickEvent event) {
		userratingOne.addStyleName(style.filled());
		userratingTwo.addStyleName(style.filled());
		userratingThree.removeStyleName(style.filled());
		userratingFour.removeStyleName(style.filled());
		userratingFive.removeStyleName(style.filled());
	
	}
	@UiHandler("userratingThree")
	public void userratingThree(ClickEvent event) {
		userratingOne.addStyleName(style.filled());
		userratingTwo.addStyleName(style.filled());
		userratingThree.addStyleName(style.filled());
		userratingFour.removeStyleName(style.filled());
		userratingFive.removeStyleName(style.filled());
	}
	@UiHandler("userratingFour")
	public void userratingFour(ClickEvent event) {
		userratingOne.addStyleName(style.filled());
		userratingTwo.addStyleName(style.filled());
		userratingThree.addStyleName(style.filled());
		userratingFour.addStyleName(style.filled());
		userratingFive.removeStyleName(style.filled());
	}
	@UiHandler("userratingFive")
	public void userratingFive(ClickEvent event) {
		userratingOne.addStyleName(style.filled());
		userratingTwo.addStyleName(style.filled());
		userratingThree.addStyleName(style.filled());
		userratingFour.addStyleName(style.filled());
		userratingFive.addStyleName(style.filled());
	}
	@UiHandler("cancelReviewBtn")
	public void cancelReview(ClickEvent event) {
		editReviewTextareaContainer.setVisible(false);
		editReviewLabelContainer.setVisible(true);
		editReviewBtn.removeStyleName(style.editReview());
		cancelReviewBtn.removeStyleName(style.editReview());
	}
	
	private String getCreatedTime(String commentCreatedTime) {
		String createdTime = null;
		Long currentTime = System.currentTimeMillis();
		Long commentTime = Long.parseLong(commentCreatedTime);
		Long elapsedTime = (currentTime - commentTime);
		int seconds = (int) (elapsedTime / 1000) % 60 ;
		int minutes = (int) ((elapsedTime / (1000*60)) % 60);
		int hours   = (int) ((elapsedTime / (1000*60*60)) % 24);
		int days = (int) (elapsedTime / (1000*60*60*24));
		Date currentDate = new Date(commentTime);
		DateTimeFormat fmt = DateTimeFormat.getFormat (DATE_FORMAT);
		if(days>6){
			createdTime = fmt.format (currentDate);
		}
		else if(days>0&&days<=6) {
			createdTime = days + getTimePrefix(days," "+GL0562, GL0579, GL0580);
		} else if(hours>0&&hours<24) {
			createdTime = hours + getTimePrefix(hours," "+GL0563, GL1435, GL1436);
		} else if(minutes>0&&minutes<60) {
			createdTime = minutes + getTimePrefix(minutes," "+GL0564, GL1437, GL1438);
		} else if(seconds<=60) {
			createdTime = GL0561;
		}
		return createdTime;
	}
	
	private String getTimePrefix(int count, String msg, String regex, String replacement) {
		if(count==1) {
			msg = msg.replaceAll(regex, replacement);
		}
		return msg;
	}
}