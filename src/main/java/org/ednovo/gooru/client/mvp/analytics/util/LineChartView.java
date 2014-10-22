package org.ednovo.gooru.client.mvp.analytics.util;

import java.util.List;
import java.util.Map;

import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.analytics.ChartMetaDataOptions;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : CollectionChartView.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 24-Jun-2014
 *
 * @Author ibc
 *
 * @Reviewer:
 */
public class LineChartView extends Composite {

	/*@UiField Label option1,option2;*/
	@UiField HTMLPanel chartContainer;
	private static LineChartViewUiBinder uiBinder = GWT	.create(LineChartViewUiBinder.class);
	public MessageProperties msgProperties = GWT.create(MessageProperties.class);

	interface LineChartViewUiBinder extends UiBinder<Widget, LineChartView> {
	}
	@UiField CollectionChartCBundle res;
	
	public LineChartView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	public void createLineChart(String title1,String title2,String []categories,List<String> contentList,Map<String,Number[]> data,ChartMetaDataOptions chartmetadata){
	/*	option1.setText(title1);
		option2.setText(title2);*/
		chartContainer.add(new HCLineChart().createChartLine(categories,contentList,data,chartmetadata));
	}
}