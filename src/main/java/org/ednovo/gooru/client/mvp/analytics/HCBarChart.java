package org.ednovo.gooru.client.mvp.analytics;

import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Credits;
import org.moxieapps.gwt.highcharts.client.Point;
import org.moxieapps.gwt.highcharts.client.Series;
import org.moxieapps.gwt.highcharts.client.ToolTip;
import org.moxieapps.gwt.highcharts.client.labels.PieDataLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.PiePlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions;


public class HCBarChart {
   
    public Chart pieChart(String backGroundColor,int[] pieChatValues) {
    	final String Colors[]={"#fac6c4","#a6caa2","#A7A9AC"};
		final Chart chart = new Chart()
		.setType(Series.Type.PIE)
		.setChartTitleText("")
		.setWidth(130)
		.setHeight(130)
		.setBackgroundColor(backGroundColor)
		.setPlotBackgroundColor((String) null)
		.setPlotBorderWidth(null)
		.setPlotShadow(true)
		.setCredits(new Credits().setText(""))
		.setPiePlotOptions(new PiePlotOptions()
			.setAllowPointSelect(true)
			.setCursor(PlotOptions.Cursor.POINTER)
			.setPieDataLabels(new PieDataLabels()
				.setEnabled(false)
			)
			.setAllowPointSelect(true)
			.setShowInLegend(false)
		)
		.setToolTip(new ToolTip()
			.setEnabled(false)
		);
		Point[] pointArr = new Point[3];
		for(int i = 0; i <3; i++){
			Point pointArray = new Point("text",pieChatValues[i]).setColor(Colors[i]);
			pointArr[i] = pointArray;
		}

		PiePlotOptions options = new PiePlotOptions();
		options.setSize(1.0);
		options.setInnerSize(0.20);
		
		chart.addSeries(chart.createSeries()
				.setPoints(pointArr)
			);
		return chart;
	}
}
