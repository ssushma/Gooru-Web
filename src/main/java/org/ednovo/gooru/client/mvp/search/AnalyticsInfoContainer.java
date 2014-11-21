/**
 * 
 */
package org.ednovo.gooru.client.mvp.search;

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
/*import org.ednovo.gooru.client.mvp.analytics.util.AnalyticsReactionWidget;*/
import org.ednovo.gooru.client.mvp.rating.RatingWidgetView;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.ContentStarRatingsDo;
import org.ednovo.gooru.shared.model.search.CollectionSearchResultDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author mitraJ
 *
 */
public class AnalyticsInfoContainer extends BaseViewWithHandlers<AnalyticsInfoContainerUiHandlers> implements IsAnalyticsInfoContainerView {

	private static AnalyticsInfoWidgetUiBinder uiBinder = GWT
			.create(AnalyticsInfoWidgetUiBinder.class);
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);

	interface AnalyticsInfoWidgetUiBinder extends
	UiBinder<Widget, AnalyticsInfoContainer> {
	}
	
	@UiField Label excellentScore, verygoodScore, goodScore, fairScore, poorScore,excellentLbl,veryGoodLbl,goodLbl,fairLbl,poorLbl,avgLbl,ratingDistributionLbl,
	avgReactionLbl,reviewDistributionLbl;
	
	@UiField HTMLPanel panelRatingValues,panelRatingLabels, dataOne, dataTwo, dataThree, dataFour, dataFive,reviewFive,reviewFour,reviewThree,reviewTwo,reviewOne,ratingVisualizations;
	
	@UiField FlowPanel ratingWidgetPanel,reviewWidgetPanel;
	
	private RatingWidgetView ratingWidgetView= new RatingWidgetView();
	
	private String gooruOid="";

	public AnalyticsInfoContainer() {
		setWidget(uiBinder.createAndBindUi(this));
		ratingDistributionLbl.setText("Rating Distribution");
		reviewDistributionLbl.setText("Review Distribution");
		excellentLbl.setText(i18n.GL1842());
		excellentLbl.getElement().setId("lblExcellentLbl");
		excellentLbl.getElement().setAttribute("alt",i18n.GL1842());
		excellentLbl.getElement().setAttribute("title",i18n.GL1842());
		
		veryGoodLbl.setText(i18n.GL1843());
		veryGoodLbl.getElement().setId("lblVeryGoodLbl");
		veryGoodLbl.getElement().setAttribute("alt",i18n.GL1843());
		veryGoodLbl.getElement().setAttribute("title",i18n.GL1843());
		
		goodLbl.setText(i18n.GL1844());
		goodLbl.getElement().setId("lblGoodLbl");
		goodLbl.getElement().setAttribute("alt",i18n.GL1844());
		goodLbl.getElement().setAttribute("title",i18n.GL1844());
		
		fairLbl.setText(i18n.GL1845());
		fairLbl.getElement().setId("lblFairLbl");
		fairLbl.getElement().setAttribute("alt",i18n.GL1845());
		fairLbl.getElement().setAttribute("title",i18n.GL1845());
		
		poorLbl.setText(i18n.GL1846());
		poorLbl.getElement().setId("lblPoorLbl");
		poorLbl.getElement().setAttribute("alt",i18n.GL1846());
		poorLbl.getElement().setAttribute("title",i18n.GL1846());
		
		avgLbl.setText(i18n.GL1848());
		avgLbl.getElement().setId("lblAvgLbl");
		avgLbl.getElement().setAttribute("alt",i18n.GL1848());
		avgLbl.getElement().setAttribute("title",i18n.GL1848());
	}
	
	private String removeHtmlTags(String html){
		html = html.replaceAll("</p>", " ").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "");
		return html;
	}
	public void setData(String gooruOid) {
		// TODO Auto-generated method stub
		this.gooruOid = gooruOid;
	}
	
	
	
	private double getBarGraphWidth(Integer count, Integer totalCount) {
		double width = 0.0;
		if(totalCount>0) {
			width = ((double)count / (double)totalCount);
		}
		return (width * 100);
	}

	@Override
	public void setContentGraph(ContentStarRatingsDo result) {
			ratingVisualizations.setVisible(true);
		int totalReviewCount = result.getScores().getFive() + result.getScores().getFour() + result.getScores().getThree() + result.getScores().getTwo() + result.getScores().getOne();
				
				dataFive.getElement().getStyle().setWidth(getBarGraphWidth(result.getScores().getFive(), totalReviewCount), Unit.PCT);
				dataFour.getElement().getStyle().setWidth(getBarGraphWidth(result.getScores().getFour(), totalReviewCount), Unit.PCT);
				dataThree.getElement().getStyle().setWidth(getBarGraphWidth(result.getScores().getThree(), totalReviewCount), Unit.PCT);
				dataTwo.getElement().getStyle().setWidth(getBarGraphWidth(result.getScores().getTwo(), totalReviewCount), Unit.PCT);
				dataOne.getElement().getStyle().setWidth(getBarGraphWidth(result.getScores().getOne(), totalReviewCount), Unit.PCT);
				
				excellentScore.setText("("+result.getScores().getFive()+")");
				excellentScore.getElement().setAttribute("alt","("+result.getScores().getFive()+")");
				excellentScore.getElement().setAttribute("title","("+result.getScores().getFive()+")");
				
				verygoodScore.setText("("+result.getScores().getFour()+")");
				verygoodScore.getElement().setAttribute("alt","("+result.getScores().getFour()+")");
				verygoodScore.getElement().setAttribute("title","("+result.getScores().getFour()+")");
				
				goodScore.setText("("+result.getScores().getThree()+")");
				goodScore.getElement().setAttribute("alt","("+result.getScores().getThree()+")");
				goodScore.getElement().setAttribute("title","("+result.getScores().getThree()+")");
				
				fairScore.setText("("+result.getScores().getTwo()+")");
				fairScore.getElement().setAttribute("alt","("+result.getScores().getTwo()+")");
				fairScore.getElement().setAttribute("title","("+result.getScores().getTwo()+")");
				
				poorScore.setText("("+result.getScores().getOne()+")");
				poorScore.getElement().setAttribute("alt","("+result.getScores().getOne()+")");
				poorScore.getElement().setAttribute("title","("+result.getScores().getOne()+")");
				
				reviewFive.getElement().getStyle().setWidth(getBarGraphWidth(1, totalReviewCount), Unit.PCT);
				reviewFour.getElement().getStyle().setWidth(getBarGraphWidth(1, totalReviewCount), Unit.PCT);
				reviewThree.getElement().getStyle().setWidth(getBarGraphWidth(1, totalReviewCount), Unit.PCT);
				reviewTwo.getElement().getStyle().setWidth(getBarGraphWidth(1, totalReviewCount), Unit.PCT);
				reviewOne.getElement().getStyle().setWidth(getBarGraphWidth(1, totalReviewCount), Unit.PCT);
	}

	@Override
	public void setAverageRatingWidget(ContentStarRatingsDo result) {
		// TODO Auto-generated method stub
		ratingWidgetView.setAvgStarRating(result.getAverage());
		ratingWidgetView.getRatingCountOpenBrace().setText(i18n. GL_SPL_OPEN_SMALL_BRACKET());
		ratingWidgetView.getRatingCountLabel().setText(result.getCount().toString());
		ratingWidgetView.getRatingCountCloseBrace().setText(i18n. GL_SPL_CLOSE_SMALL_BRACKET());
		ratingWidgetPanel.add(ratingWidgetView);
	}

	@Override
	public void setCollectionAnalyticsData(CollectionSearchResultDo searchResultDo) {
		// TODO Auto-generated method stub
		ratingVisualizations.setVisible(false);
		int totalReviewCount = 1 + 1 + 1 + 1 + 1;
		reviewFive.getElement().getStyle().setWidth(getBarGraphWidth(1, totalReviewCount), Unit.PCT);
		reviewFour.getElement().getStyle().setWidth(getBarGraphWidth(0, totalReviewCount), Unit.PCT);
		reviewThree.getElement().getStyle().setWidth(getBarGraphWidth(1, totalReviewCount), Unit.PCT);
		reviewTwo.getElement().getStyle().setWidth(getBarGraphWidth(1, totalReviewCount), Unit.PCT);
		reviewOne.getElement().getStyle().setWidth(getBarGraphWidth(0, totalReviewCount), Unit.PCT);
	}

	@Override
	public void setAverageReactionWidget(int count) {
		reviewWidgetPanel.clear();
		avgReactionLbl.setText("Average Reaction");
		//reviewWidgetPanel.add(new AnalyticsReactionWidget(count));
	}
}