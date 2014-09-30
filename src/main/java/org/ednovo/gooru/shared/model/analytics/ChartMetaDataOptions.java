package org.ednovo.gooru.shared.model.analytics;

import java.io.Serializable;

public class ChartMetaDataOptions implements Serializable {
	private static final long serialVersionUID = -4629006109833216512L;
	
	private Integer height;
	private Integer width;
	private Integer rotation;
	private boolean isClickable;
	private boolean isPercentage;
	private String title;
	private boolean isDonut = true;
	private String xAxisTitle;
	private String yAxisTitle;
	private int yMinValue;
	private int yMaxValue;
	private boolean isLegendBottom = false;
	private boolean showXaxisTop=false;
	private boolean showLegends=true;
	private boolean showGridLines=true;
	
	
	public boolean isShowXaxisTop() {
		return showXaxisTop;
	}
	public void setShowXaxisTop(boolean showXaxisTop) {
		this.showXaxisTop = showXaxisTop;
	}
	public boolean isShowGridLines() {
		return showGridLines;
	}
	public void setShowGridLines(boolean showGridLines) {
		this.showGridLines = showGridLines;
	}
	public boolean isShowLegends() {
		return showLegends;
	}
	public void setShowLegends(boolean showLegends) {
		this.showLegends = showLegends;
	}
	public int getyMinValue() {
		return yMinValue;
	}
	public void setyMinValue(int yMinValue) {
		this.yMinValue = yMinValue;
	}
	public int getyMaxValue() {
		return yMaxValue;
	}
	public void setyMaxValue(int yMaxValue) {
		this.yMaxValue = yMaxValue;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public boolean isClickable() {
		return isClickable;
	}
	public void setClickable(boolean isClickable) {
		this.isClickable = isClickable;
	}
	public boolean isPercentage() {
		return isPercentage;
	}
	public void setPercentage(boolean isPercentage) {
		this.isPercentage = isPercentage;
	}
	public boolean isDonut() {
		return isDonut;
	}
	public void setDonut(boolean isDonut) {
		this.isDonut = isDonut;
	}
	public Integer getRotation() {
		return rotation;
	}
	public void setRotation(Integer rotation) {
		this.rotation = rotation;
	}
	public String getxAxisTitle() {
		return xAxisTitle;
	}
	public void setxAxisTitle(String xAxisTitle) {
		this.xAxisTitle = xAxisTitle;
	}
	public String getyAxisTitle() {
		return yAxisTitle;
	}
	public void setyAxisTitle(String yAxisTitle) {
		this.yAxisTitle = yAxisTitle;
	}
	public boolean isLegendBottom() {
		return isLegendBottom;
	}
	public void setLegendBottom(boolean isLegendBottom) {
		this.isLegendBottom = isLegendBottom;
	}
}