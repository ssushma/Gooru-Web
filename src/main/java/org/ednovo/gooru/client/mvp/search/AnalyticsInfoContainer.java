/**
 * 
 */
package org.ednovo.gooru.client.mvp.search;

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
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
	
	@UiField public HTMLPanel totalReviewsContainer,averageReactionsContainer,averageRatingsContainer;
	
	
	AverageRatingsWidget averageRatingsWidgetobj = new AverageRatingsWidget();
	AverageReactionsWidget averageReactionsWidgetobj = new AverageReactionsWidget();
	CommonRatingsAndReviewsWidget  commonRatingsAndReviewsWidget = new CommonRatingsAndReviewsWidget();
	
	public AnalyticsInfoContainer() {
		setWidget(uiBinder.createAndBindUi(this));
	}
	
	private String removeHtmlTags(String html){
		html = html.replaceAll("</p>", " ").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "");
		return html;
	}
	
	@Override
	public void setResourceData() {
		ClearData();
		averageRatingsContainer.add(averageRatingsWidgetobj);
		averageReactionsContainer.add(averageReactionsWidgetobj);
		totalReviewsContainer.add(commonRatingsAndReviewsWidget);
	}

	public void ClearData(){
		averageRatingsContainer.clear();
		averageReactionsContainer.clear();
		totalReviewsContainer.clear();
	}

	@Override
	public void setCollectionData() {
		ClearData();
		totalReviewsContainer.add(commonRatingsAndReviewsWidget.totalReviesLeftPnl);
		averageReactionsContainer.add(averageReactionsWidgetobj);
	}

}