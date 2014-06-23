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
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class RatingsConfirmationPopup extends PopupPanel implements MessageProperties {

	@UiField Button btnOk;
	@UiField public FlowPanel ratingWidgetPanel;
	private RatingWidgetView ratingWidgetView=null;
	String assocGooruOId,createrName;
	@UiField Label reviewRatingText;
	@UiField HTMLPanel averageRationPanel;
	
	private static RatingsConfirmationPopupUiBinder uiBinder = GWT
			.create(RatingsConfirmationPopupUiBinder.class);

	interface RatingsConfirmationPopupUiBinder extends
			UiBinder<Widget, RatingsConfirmationPopup> {
	}
	
	public RatingsConfirmationPopup(String assocGooruOId, Integer score,
			Integer count, double average,String createrName) {
			setWidget(uiBinder.createAndBindUi(this));
			this.assocGooruOId=assocGooruOId;
			this.createrName = createrName;
			reviewRatingText.setText(GL1856);
			averageRationPanel.getElement().setInnerHTML(GL1848);
			btnOk.setText(GL0190);
			setAvgRatingWidget(assocGooruOId,score,count,average,createrName);
	}
	/**
	 * Average star ratings widget will get integrated.
	 */
	private void setAvgRatingWidget(String assocGooruOId, Integer score,Integer count, double average,String createrName){
		ratingWidgetView=new RatingWidgetView();
		if(count!=null)
		ratingWidgetView.getRatingCountLabel().setText(count.toString());
		ratingWidgetView.setAvgStarRating(average);
		if(count>0)
		{
		ratingWidgetView.getRatingCountLabel().getElement().removeAttribute("class");
		ratingWidgetView.getRatingCountLabel().getElement().setAttribute("style", "cursor: pointer;text-decoration: none !important;color: #1076bb;");
		ratingWidgetView.getRatingCountLabel().addClickHandler(new ShowRatingPopupEvent());
		}
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
			closeAction();
			AppClientFactory.fireEvent(new OpenReviewPopUpEvent(assocGooruOId, "",createrName)); 
		}
	}
	
	public void closeAction()
	{
		this.hide();
	}
	
	@UiHandler("btnOk")
	public void btnOkClick(ClickEvent event){
		this.hide();
	}
}
