package org.ednovo.gooru.client.mvp.analytics.collectionSummaryIndividual;

import java.util.ArrayList;

import org.ednovo.gooru.client.mvp.analytics.util.AnalyticsReactionWidget;
import org.ednovo.gooru.client.mvp.analytics.util.AnalyticsUtil;
import org.ednovo.gooru.shared.model.analytics.CollectionSummaryMetaDataDo;

import com.google.gwt.core.client.GWT;
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
	@UiField Label totalTimeSpentlbl,totalViewlbl;
	@UiField HTMLPanel totalAvgReactionlbl;
	
	public CollectionOverViewWidget() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	void setData(ArrayList<CollectionSummaryMetaDataDo> result){
		totalTimeSpentlbl.setText(AnalyticsUtil.getTimeSpent(result.get(0).getAvgTimeSpent()));
		totalViewlbl.setText(Integer.toString(result.get(0).getViews()));
		totalAvgReactionlbl.clear();
		totalAvgReactionlbl.add(new AnalyticsReactionWidget(result.get(0).getAvgReaction()));
	}

}
