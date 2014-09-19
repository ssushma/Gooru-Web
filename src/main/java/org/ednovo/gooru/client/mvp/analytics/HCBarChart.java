package org.ednovo.gooru.client.mvp.analytics;

import org.moxieapps.gwt.highcharts.client.AxisTitle;
import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.ChartSubtitle;
import org.moxieapps.gwt.highcharts.client.ChartTitle;
import org.moxieapps.gwt.highcharts.client.Credits;
import org.moxieapps.gwt.highcharts.client.Legend;
import org.moxieapps.gwt.highcharts.client.Point;
import org.moxieapps.gwt.highcharts.client.Series;
import org.moxieapps.gwt.highcharts.client.ToolTip;
import org.moxieapps.gwt.highcharts.client.ToolTipData;
import org.moxieapps.gwt.highcharts.client.ToolTipFormatter;
import org.moxieapps.gwt.highcharts.client.labels.AxisLabelsData;
import org.moxieapps.gwt.highcharts.client.labels.AxisLabelsFormatter;
import org.moxieapps.gwt.highcharts.client.labels.DataLabels;
import org.moxieapps.gwt.highcharts.client.labels.DataLabelsData;
import org.moxieapps.gwt.highcharts.client.labels.DataLabelsFormatter;
import org.moxieapps.gwt.highcharts.client.labels.PieDataLabels;
import org.moxieapps.gwt.highcharts.client.labels.YAxisLabels;
import org.moxieapps.gwt.highcharts.client.plotOptions.BarPlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PiePlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions;


public class HCBarChart {
    public Chart createLineChart(){
	    	String[] timeSpent={"AVG spent","Suggested time spent"};
	        final Chart chart = new Chart()  
	            .setType(Series.Type.LINE)  
	            .setMarginRight(130)  
	            .setMarginBottom(25)  
	            .setChartTitle(new ChartTitle()  
	                .setText("Monthly Average Temperature")  
	                .setX(-20)  // center  
	            )  
	            .setChartSubtitle(new ChartSubtitle()  
	                .setText("Source: WorldClimate.com")  
	                .setX(-20)  
	            )  
	            .setLegend(new Legend()  
	                .setLayout(Legend.Layout.VERTICAL)  
	                .setAlign(Legend.Align.RIGHT)  
	                .setVerticalAlign(Legend.VerticalAlign.TOP)  
	                .setX(-10)  
	                .setY(100)  
	                .setBorderWidth(0)  
	            )  
	            .setToolTip(new ToolTip()  
	                .setFormatter(new ToolTipFormatter() {  
	                    public String format(ToolTipData toolTipData) {  
	                        return "<b>" + toolTipData.getSeriesName() + "</b><br/>" +  
	                            toolTipData.getXAsString() + ": " + toolTipData.getYAsDouble() + "Â°C";  
	                    }  
	                })  
	            );  
	  
	        chart.getXAxis()  
	            .setCategories(  
	                "1", "2", "3", "4", "5", "6",  
	                "7", "8", "9", "10", "11", "12"  
	            );  
	  
	        chart.getYAxis()  
	           .setLabels(new YAxisLabels()  
	                .setFormatter(  
	                    new AxisLabelsFormatter() {  
	                        public String format(AxisLabelsData axisLabelsData) {  
	                            return axisLabelsData.getValueAsLong() + "Â°";  
	                        }  
	                    }  
	                )  
	            );  
	  
	        chart.addSeries(chart.createSeries()  
	            .setName("Tokyo")  
	            .setPoints(new Number[]{  
	                7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6  
	            })  
	        );  
	        chart.addSeries(chart.createSeries()  
	            .setName("New York")  
	            .setPoints(new Number[]{  
	                -0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5  
	            })  
	        );  
	        chart.addSeries(chart.createSeries()  
	            .setName("Berlin")  
	            .setPoints(new Number[]{  
	                -0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0  
	            })  
	        );  
	        chart.addSeries(chart.createSeries()  
	            .setName("London")  
	            .setPoints(new Number[]{  
	                3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8  
	            })  
	        );  
	       
	        return chart;  
        }  
    public Chart createBarChart(){
	    	  final Chart chart = new Chart()  
	          .setType(Series.Type.BAR)  
	          .setBarPlotOptions(new BarPlotOptions()  
	              .setDataLabels(new DataLabels()  
	                  .setEnabled(true)  
	              )  
	          )  
	          .setLegend(new Legend()  
	              .setLayout(Legend.Layout.VERTICAL)  
	              .setAlign(Legend.Align.RIGHT)  
	              .setVerticalAlign(Legend.VerticalAlign.TOP)  
	              .setX(-100)  
	              .setY(100)  
	              .setFloating(true)  
	              .setBorderWidth(1)  
	              .setBackgroundColor("#FFFFFF")  
	              .setShadow(true)  
	          )  
	          .setCredits(new Credits()  
	              .setEnabled(false)  
	          )  
	          .setToolTip(new ToolTip()  
	              .setFormatter(new ToolTipFormatter() {  
	                  public String format(ToolTipData toolTipData) {  
	                      return toolTipData.getSeriesName() + ": " + toolTipData.getYAsLong() +" million";  
	                  }  
	              })  
	          );  
	
	      chart.getXAxis()  
	          .setCategories("Africa");  
	
	      chart.getYAxis()  
	          .setAxisTitle(new AxisTitle()  
	              .setText("Population (millions)")  
	              .setAlign(AxisTitle.Align.HIGH)  
	          );  
	
	      chart.addSeries(chart.createSeries()  
	          .setName("Year 1800")  
	          .setPoints(new Number[] { 107, 31, 635, 203, 2 })  
	      );  
	      
	      chart.setWidth(150);
	    chart.setHeight(150);
	      return chart;  
        } 
    public Chart createPieChart(){
	    	 final Chart chart = new Chart()  
	         .setType(Series.Type.PIE)  
	         .setChartTitleText("")
	         .setPlotBackgroundColor((String) null)  
	         .setPlotBorderWidth(null)  
	         .setPlotShadow(false)  
	         .setPiePlotOptions(new PiePlotOptions()  
	         /*  .setAllowPointSelect(false)  
	             .setCursor(PlotOptions.Cursor.POINTER)  
	            /* .setPieDataLabels(new PieDataLabels()  
	                 .setConnectorColor("#000000")  
	                 .setEnabled(true)  
	                 .setColor("#000000")  
	                 .setFormatter(new DataLabelsFormatter() {  
	                     public String format(DataLabelsData dataLabelsData) {  
	                         return "<b>" + dataLabelsData.getPointName() + "</b>: " + dataLabelsData.getYAsDouble() + " %";  
	                     }  
	                 })  
	             )  */
	         )  
	         .setToolTip(new ToolTip()
	         	.setEnabled(false)
	         )
	         .setLegend(new Legend()  
	             .setLayout(Legend.Layout.VERTICAL)  
	             .setAlign(Legend.Align.RIGHT)  
	             .setVerticalAlign(Legend.VerticalAlign.TOP)  
	             .setX(-100)  
	             .setY(100)  
	             .setFloating(false)  
	             .setBorderWidth(1)  
	             .setBackgroundColor("#FFFFFF")  
	             .setShadow(false)  
	         ) ; 
	        /* .setToolTip(new ToolTip()  
	             .setFormatter(new ToolTipFormatter() {  
	                 public String format(ToolTipData toolTipData) {  
	                     return "<b>" + toolTipData.getPointName() + "</b>: " + toolTipData.getYAsDouble() + " %";  
	                 }  
	             })  
	         );  */
	    	 chart.addSeries(chart.createSeries()  
	    	            .setPoints(new Point[]{  
	    	                new Point("", 45.0),  
	    	                new Point("", 26.8),  
	    	                new Point("", 50)  
	    	            })  
	    	        ); 
	    	 chart.setWidth(150);
	    	 chart.setHeight(100);
	
	     return chart;  
        }  
}
