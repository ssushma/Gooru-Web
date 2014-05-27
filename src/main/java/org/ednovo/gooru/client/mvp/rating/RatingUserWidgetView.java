package org.ednovo.gooru.client.mvp.rating;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.shared.model.content.StarRatingsDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class RatingUserWidgetView extends Composite {

	@UiField HTMLEventPanel reviewContainer;
	
	@UiField Label userName, timeStamp, review;
	
	@UiField Button editReview,editReviewBtn,cancelReviewBtn,deleteReview;
	
	@UiField HTMLPanel editReviewTextareaContainer,editReviewLabelContainer;
	
	@UiField InlineHTML starOne,starTwo,starThree,starFour,starFive;
	
	@UiField TextArea editReviewText;
	
	@UiField InlineHTML userratingOne,userratingTwo,userratingThree,userratingFour,userratingFive;
	
	@UiField RatingAndReviewStyleBundle style;
	private String createrName;
	private String id;
	
	
	private static RatingUserWidgetViewUiBinder uiBinder = GWT
			.create(RatingUserWidgetViewUiBinder.class);

	interface RatingUserWidgetViewUiBinder extends
			UiBinder<Widget, RatingUserWidgetView> {
	}

	public RatingUserWidgetView(StarRatingsDo starRatingsDo,String createrName) {
		initWidget(uiBinder.createAndBindUi(this));
		this.createrName=createrName;
		setData(starRatingsDo,createrName);
	}
	
	public void setData(final StarRatingsDo starRatingsDo,final String createrName) {
		//timeStamp.setText("3 days ago");
		review.setText(starRatingsDo.getFreeText());
		id = starRatingsDo.getDeleteRatingGooruOid();
		editReviewText.setText(starRatingsDo.getFreeText());
		editReview.setVisible(false);
		deleteReview.setVisible(false);
		deleteReview.getElement().setAttribute("style", "float: right");
		deleteReview.getElement().setAttribute("style", "margin-right: 30px");
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
			//editReview.setVisible(true);
			userName.setText("Your Review!");
			
	
		} else {
			editReview.removeStyleName(style.editReview());
			
		}
		reviewContainer.addMouseOverHandler(new MouseOverHandler() {
			
			@Override
			public void onMouseOver(MouseOverEvent event) {
				if(starRatingsDo.getCreator().getUsername().equals(AppClientFactory.getLoggedInUser().getUsername())) {
				editReview.setVisible(true);
				
				deleteReview.setText("Delete rating and review");
				}
				if(AppClientFactory.getLoggedInUser().getUsername().equalsIgnoreCase(createrName))
				{
					deleteReview.setVisible(true);
					deleteReview.setText("Delete Review");
					
				}
				
			}
		});
		reviewContainer.addMouseOutHandler(new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
				editReview.setVisible(false);
				deleteReview.setVisible(false);
				
			}
		});
		
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
	@UiHandler("deleteReview")
	public void onClickDeleteReview(ClickEvent event){
		AppClientFactory.getInjector().getPlayerAppService().deleteRating(id, new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				reviewContainer.clear();
				Label deleteMsg=new Label();
				deleteMsg.getElement().setAttribute("style","float: left");
				deleteMsg.getElement().setAttribute("style","margin-left: 101px;");
				deleteMsg.setText(MessageProperties.GL1853);
				reviewContainer.add(deleteMsg);
				reviewContainer.getElement().setAttribute("style", "height: 30px");
				
				
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
}