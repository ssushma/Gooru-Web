package org.ednovo.gooru.client.mvp.play.resource.body;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.rating.RatingWidgetView;
import org.ednovo.gooru.client.mvp.rating.events.OpenReviewPopUpEvent;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class RatingsConfirmationPopup extends PopupPanel implements MessageProperties {

	@UiField Button btnOk;
	@UiField public FlowPanel ratingWidgetPanel;
	private RatingWidgetView ratingWidgetView=null;
	String assocGooruOId;
	
	private static RatingsConfirmationPopupUiBinder uiBinder = GWT
			.create(RatingsConfirmationPopupUiBinder.class);

	interface RatingsConfirmationPopupUiBinder extends
			UiBinder<Widget, RatingsConfirmationPopup> {
	}
	
	public RatingsConfirmationPopup(String assocGooruOId, Integer score,
			Integer count, double average) {
			setWidget(uiBinder.createAndBindUi(this));
			this.assocGooruOId=assocGooruOId;
			setAvgRatingWidget(assocGooruOId,score,count,average);
	}
	/**
	 * Average star ratings widget will get integrated.
	 */
	private void setAvgRatingWidget(String assocGooruOId, Integer score,Integer count, double average){
		ratingWidgetView=new RatingWidgetView();
		if(count!=null)
		ratingWidgetView.getRatingCountLabel().setText(count.toString());
		ratingWidgetView.setAvgStarRating(average);
		ratingWidgetView.getRatingCountLabel().addClickHandler(new ShowRatingPopupEvent());
		ratingWidgetPanel.add(ratingWidgetView);
	}
	/**
	 * 
	 * Inner class implementing {@link ClickEvent}
	 *
	 */
	private class ShowRatingPopupEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			/**
			 * OnClick of count label event to invoke Review pop-pup
			 */
			AppClientFactory.fireEvent(new OpenReviewPopUpEvent(assocGooruOId)); 
		}
	}
	
	@UiHandler("btnOk")
	public void btnOkClick(ClickEvent event){
		this.hide();
	}
}
