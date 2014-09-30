package org.ednovo.gooru.client.mvp.analytics.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.shared.model.analytics.ChartMetaDataOptions;
import org.ednovo.gooru.shared.model.analytics.GradeJsonData;
import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.ChartTitle;
import org.moxieapps.gwt.highcharts.client.Credits;
import org.moxieapps.gwt.highcharts.client.Legend;
import org.moxieapps.gwt.highcharts.client.Series;
import org.moxieapps.gwt.highcharts.client.Style;
import org.moxieapps.gwt.highcharts.client.ToolTip;
import org.moxieapps.gwt.highcharts.client.ToolTipData;
import org.moxieapps.gwt.highcharts.client.ToolTipFormatter;
import org.moxieapps.gwt.highcharts.client.labels.Labels;
import org.moxieapps.gwt.highcharts.client.labels.XAxisLabels;
import org.moxieapps.gwt.highcharts.client.labels.YAxisLabels;

import com.google.gwt.user.client.ui.HTMLPanel;

public class HCLineChart {
	final Chart chart = new Chart();
	
	
public HTMLPanel chart(ArrayList<GradeJsonData> gradeData){
		HTMLPanel studyChartContainer=new HTMLPanel("");
		ChartMetaDataOptions chartmetadata=new ChartMetaDataOptions();
		chartmetadata.setHeight(100);
		chartmetadata.setShowLegends(false);
	
		int size=gradeData.size();
		Number series1[]=new Number[size];
	    Number series2[]=new Number[size];
	   
	    for(int i=0;i<size;i++){
	    	if(gradeData.get(i).getEstimatedTime()!=null){
	    		String estimatedTime=gradeData.get(i).getEstimatedTime().replaceAll("hrs", ":").replaceAll("mins", "").trim();
	    		if(estimatedTime.contains(":"))
	    		{
	    		String[] convertMins=estimatedTime.split(":");
	    		int convertedTime=(Integer.parseInt(convertMins[0].trim())*60)+(Integer.parseInt(convertMins[1].trim()));
	    		series1[i]=convertedTime-(convertedTime/2);
	    		series2[i]=convertedTime;
	    		}
	    	}else{
	    		series1[i]=0;
	    		series2[i]=0;
	    	}
	    }
    
	    List<Number[]> numberArrays=new ArrayList<Number[]>();
	    numberArrays.add(series1);
	    numberArrays.add(series2);
	    
		List<String> contentListNew=new ArrayList<String>();
		String subjects[]={"question1","question2"};
		for(String subject:subjects){
			contentListNew.add(subject);
		}
		
		String category[]=new String[size];
		   
		Map<String,Number[]> data = new HashMap<String,Number[]>();
		for(int i=0;i<contentListNew.size();i++){
			data.put(contentListNew.get(i), numberArrays.get(i));
		}
		chartmetadata.setShowXaxisTop(true);
		
		LineChartView lineChartView=new LineChartView();
		lineChartView.createLineChart("Average Time", "Suggested Time", category, contentListNew, data, chartmetadata);
		chartmetadata.setShowXaxisTop(false);
		
		Map<String,Number[]> data1 = new HashMap<String,Number[]>();
		List<String> contentListNew1=new ArrayList<String>();
		LineChartView lineChartView1=new LineChartView();
		lineChartView1.createLineChart("Average Score", "Minimum Score", category, contentListNew1, data1, chartmetadata);
		
		Map<String,Number[]> data2 = new HashMap<String,Number[]>();
		LineChartView lineChartView2=new LineChartView();
		lineChartView2.createLineChart("Average Reaction","", category, contentListNew1, data2, chartmetadata);
		
		Map<String,Number[]> data3 = new HashMap<String,Number[]>();
		LineChartView lineChartView3=new LineChartView();
		lineChartView3.createLineChart("Student Completion","", category, contentListNew1, data3, chartmetadata);
		
		studyChartContainer.add(lineChartView);
		studyChartContainer.add(lineChartView1);
		studyChartContainer.add(lineChartView2);
		studyChartContainer.add(lineChartView3);
		
		return studyChartContainer;
	}
		
	
	
	public Chart createChartLine(String[] categories, List<String> legend, Map<String, Number[]> data,ChartMetaDataOptions chartmetadata) {
		chart.setType(Series.Type.LINE)  
	        .setZoomType(Chart.ZoomType.X_AND_Y)
			.setChartTitle(new ChartTitle()  
				.setText("")
			)
			.setHeight(chartmetadata.getHeight())
			.setWidth(chartmetadata.getWidth())
			.setCredits(new Credits().setText(""))
			
			.setToolTip(new ToolTip()  
				.setFormatter(new ToolTipFormatter() {  
					public String format(ToolTipData toolTipData) {  
						long hours = Math.round(toolTipData.getYAsDouble()) / 60;
						long minutes = Math.round(toolTipData.getYAsDouble()) % 60;
						return 	hours+"hrs "+minutes+"mins";
					}  
				})  
			);  
		
		chart.getXAxis().setCategories(categories);

		if(chartmetadata.isShowXaxisTop()){
				chart.getXAxis().setOpposite(true);
		 } else {
			 	chart.getXAxis().setLabels(new XAxisLabels().setEnabled(false));
				chart.getXAxis().setLineColor("transparent");
				chart.getXAxis().setLineWidth(0);
				chart.getXAxis().setTickWidth(0);
				chart.getXAxis().setTickLength(0);
		 }
		
		if(chartmetadata.getyAxisTitle()!=null&&!chartmetadata.getyAxisTitle().isEmpty()) {
			chart.getYAxis().setAxisTitleText(chartmetadata.getyAxisTitle());
		} else {
			chart.getYAxis().setAxisTitleText("");
		}
		chart.getYAxis().setLabels(new YAxisLabels().setEnabled(false));
		
		chart.getYAxis().setGridLineWidth(0);
		chart.getYAxis().setGridLineColor("transparent");
		

		chart.getYAxis().setMin(0);
		if(categories.length>15) {
			chart.getXAxis()
			.setLabels(new XAxisLabels()  
	            .setRotation(-45)  
	            .setAlign(Labels.Align.RIGHT)  
	            .setStyle(new Style()
	                .setFont("normal 10px Verdana, sans-serif")  
	            )  
	        );
		}
       for(int series=0; series<legend.size();series++) {
			chart.addSeries(chart.createSeries()
					.setName(legend.get(series))
					.setPoints(data.get(legend.get(series))));
		}
		
		if(chartmetadata.getyMaxValue()!=0){
			chart.getYAxis().setMax(chartmetadata.getyMaxValue());
		}
		if(!chartmetadata.isShowLegends()){
			chart.setLegend(new Legend().setEnabled(false));
		}
		
		return chart;
	}
}