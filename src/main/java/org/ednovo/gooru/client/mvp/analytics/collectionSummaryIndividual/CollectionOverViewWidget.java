package org.ednovo.gooru.client.mvp.analytics.collectionSummaryIndividual;

import org.ednovo.gooru.client.mvp.analytics.util.AnalyticsReactionWidget;
import org.ednovo.gooru.client.mvp.analytics.util.AnalyticsUtil;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.analytics.CollectionSummaryMetaDataDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class CollectionOverViewWidget extends Composite {

	private static CollectionOverViewWidgetUiBinder uiBinder = GWT
			.create(CollectionOverViewWidgetUiBinder.class);

	interface CollectionOverViewWidgetUiBinder extends
			UiBinder<Widget, CollectionOverViewWidget> {
	}
	private static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	@UiField Label collectionOverViewlbl,timeSpentTxtlbl,totalTimeSpentlbl,totalViewlbl;
	@UiField HTMLPanel totalAvgReactionlbl;
	
	public CollectionOverViewWidget() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	public void setData(CollectionSummaryMetaDataDo result,boolean isTeacherSummary){
		collectionOverViewlbl.getElement().getStyle().setTextAlign(TextAlign.LEFT);
		if(isTeacherSummary){
			timeSpentTxtlbl.setText(i18n.GL2230());
		}else{
			timeSpentTxtlbl.setText(i18n.GL2275());
		}
		totalTimeSpentlbl.setText(AnalyticsUtil.getTimeSpent(result.getAvgTimeSpent()));
		totalViewlbl.setText(Integer.toString(result.getViews()));
		totalAvgReactionlbl.clear();
		totalAvgReactionlbl.add(new AnalyticsReactionWidget(result.getAvgReaction()));
	}

}
