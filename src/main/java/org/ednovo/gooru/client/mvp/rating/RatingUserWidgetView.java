package org.ednovo.gooru.client.mvp.rating;

import java.util.Date;
import java.util.Iterator;

import org.ednovo.gooru.client.effects.FadeInAndOut;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.shared.model.content.StarRatingsDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;

import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;

import com.google.gwt.i18n.client.DateTimeFormat;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class RatingUserWidgetView extends Composite implements MessageProperties {

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
	
	
	private static final String DATE_FORMAT="MMMM dd, yyyy";
	
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
		String commentTime = getCreatedTime(Long.toString(starRatingsDo.getCreatedDate())); 
		timeStamp.setText(commentTime);
		deleteReview.setVisible(false);
		deleteReview.setText("Delete Review");
		
		review.setText(starRatingsDo.getFreeText());
		id = starRatingsDo.getDeleteRatingGooruOid();
		editReviewText.setText(starRatingsDo.getFreeText());
		editReview.setVisible(false);
		
		deleteReview.getElement().setAttribute("style", "float: right");
		deleteReview.getElement().setAttribute("style", "margin-right: 30px");
		editReviewTextareaContainer.setVisible(false);
		if(starRatingsDo.getCreator().getUsername().equals(AppClientFactory.getLoggedInUser().getUsername())){
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
		}
		
		if(starRatingsDo.getCreator().getUsername().equals(AppClientFactory.getLoggedInUser().getUsername())) {
			reviewContainer.addStyleName(style.creatorReviewPanel());
			editReview.addStyleName(style.editReview());
			editReviewBtn.removeStyleName(style.editReview());
			cancelReviewBtn.removeStyleName(style.editReview());
			//editReview.setVisible(true);
			userName.setText("Your Review!");
			deleteReview.removeStyleName(style.editReview());
			
	
		} else {
			editReview.removeStyleName(style.editReview());
			deleteReview.removeStyleName(style.editReview());
			
		}
		reviewContainer.addMouseOverHandler(new MouseOverHandler() {
			
			@Override
			public void onMouseOver(MouseOverEvent event) {
				if(starRatingsDo.getCreator().getUsername().equals(AppClientFactory.getLoggedInUser().getUsername())) {
				editReview.setVisible(true);
			
				}
				if(AppClientFactory.getLoggedInUser().getUsername().equalsIgnoreCase(createrName))
				{
					deleteReview.setVisible(true);
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
				reviewContainer.getElement().setAttribute("style", "background: #f0f0f0");
				reviewContainer.clear();
				final HTMLPanel deletePanel = new HTMLPanel(MessageProperties.GL1853);
				deletePanel.getElement().setAttribute("style", "height:40px");
				reviewContainer.add(deletePanel);
						
				new FadeInAndOut(deletePanel.getElement(), 1000);
				Timer timer = new Timer()
		        {
		            @Override
		            public void run()
		            {
		            	int deleteIndex = reviewContainer.getWidgetIndex(deletePanel);
		            	reviewContainer.remove(deleteIndex);
		            	reviewContainer.setVisible(false);
					
		            }
		        };
		        timer.schedule(1000);
		     
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
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