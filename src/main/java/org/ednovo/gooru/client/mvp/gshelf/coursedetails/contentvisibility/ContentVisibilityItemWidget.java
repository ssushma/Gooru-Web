package org.ednovo.gooru.client.mvp.gshelf.coursedetails.contentvisibility;

import java.util.Iterator;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.model.classpages.PlanProgressDo;
import org.ednovo.gooru.client.CssTokens;
import org.ednovo.gooru.client.mvp.gshelf.coursedetails.HighlightContentSpanEvent;
import org.ednovo.gooru.client.mvp.gshelf.coursedetails.HighlightContentSpanHandler;
import org.ednovo.gooru.client.ui.HTMLEventPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ContentVisibilityItemWidget extends Composite {

	@UiField HTMLEventPanel rowItem, contentPanel, spanDot, rightRow;
	@UiField InlineLabel arrowPanel, iconPanel;
	@UiField Label lblContentName;
	@UiField Anchor anrSelect;
	
	private String contentType = null, unitId = null, lessonId = null;
	private int collectionId;
	private boolean isVisible = false, isClicked = false;
	
	private static ContentVisibilityItemWidgetUiBinder uiBinder = GWT
			.create(ContentVisibilityItemWidgetUiBinder.class);

	interface ContentVisibilityItemWidgetUiBinder extends
			UiBinder<Widget, ContentVisibilityItemWidget> {
	}
	
	public ContentVisibilityItemWidget(String contentType, PlanProgressDo planProgressDo, String unitId, String lessonId) {
		initWidget(uiBinder.createAndBindUi(this));
		arrowPanel.setVisible(false);
		this.contentType = contentType;
		this.unitId = unitId;
		this.lessonId = lessonId;
		setCollectionId(planProgressDo.getCollectionId());
		setData(contentType, planProgressDo);
		setVisibility(planProgressDo.isVisibility());
		spanDot.addClickHandler(new SpanDot(contentType,planProgressDo.isVisibility()));
		anrSelect.addClickHandler(new AllContentItems());
		AppClientFactory.getEventBus().addHandler(HighlightContentSpanEvent.TYPE, highlightContentHandler);
		if("collection".equalsIgnoreCase(contentType)) {
			anrSelect.setVisible(false);
		}
	}
	
	private void setData(String contentType, PlanProgressDo data) {
		lblContentName.setText(data.getTitle());
		if(data.isVisibility()) {
			spanDot.addStyleName(CssTokens.GREEN_STYLE);
			spanDot.addStyleName("tick");
		}
		if("unit".equalsIgnoreCase(contentType)) {
			rowItem.setStyleName("unitRow");
			lblContentName.addStyleName("levelOne");
			lblContentName.addStyleName("cursor");
			arrowPanel.setVisible(true);
			iconPanel.addStyleName("contentVisibility unit");
		} else if("lesson".equalsIgnoreCase(contentType)) {
			rowItem.setStyleName("lessonRow");
			lblContentName.addStyleName("levelTwo");
			lblContentName.addStyleName("cursor");
			arrowPanel.setVisible(true);
			arrowPanel.getElement().getStyle().setMarginLeft(25, Unit.PX);
			iconPanel.addStyleName("contentVisibility lesson");
		} else if("collection".equalsIgnoreCase(contentType)) {
			rowItem.setStyleName("collectionRow");
			lblContentName.addStyleName("levelThree");
			if(data.getCollectionType()!=null&&data.getCollectionType().equalsIgnoreCase("collection")) {
				iconPanel.addStyleName("contentVisibility collection");
			} else {
				iconPanel.addStyleName("contentVisibility assessment");
			}
		}
	}
	
	public class AllContentItems implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			spanDot.addStyleName(CssTokens.GREEN_STYLE);
			Iterator<Widget> widgets= rowItem.iterator();
			while (widgets.hasNext()){
				  Widget widget = widgets.next();
				  if (widget instanceof ContentVisibilityItemWidget) {
					  ContentVisibilityItemWidget childWidget = (ContentVisibilityItemWidget)widget;
					  childWidget.getSpanDot().addStyleName(CssTokens.GREEN_STYLE);
					  Iterator<Widget> childWidgets= childWidget.getRowItem().iterator();
					  while (childWidgets.hasNext()){
						  Widget collectionWidget = childWidgets.next();
						  if (collectionWidget instanceof ContentVisibilityItemWidget) {
							  ContentVisibilityItemWidget collectionWidgetItem = (ContentVisibilityItemWidget)collectionWidget;
							  collectionWidgetItem.getSpanDot().addStyleName(CssTokens.GREEN_STYLE);
						  }
					  }
				  }
			}
		}
	}
	
	
	public class SpanDot implements ClickHandler {
		String contentType = null;
		boolean isVisible = false;
		public SpanDot(String contentType, boolean isVisible) {
			this.contentType = contentType;
			this.isVisible = isVisible;
		}
		
		@Override
		public void onClick(ClickEvent event) {
			setSpanDot(contentType, isVisible);
		}
	}
	
	public void setSpanDot(String contentType, boolean isVisible) {
		String style = spanDot.getStyleName();
		if(style.contains(CssTokens.GREEN_STYLE)) {
			if(!isVisible()) {
				spanDot.removeStyleName(CssTokens.GREEN_STYLE);
			}
			if ("lesson".equalsIgnoreCase(contentType) || "unit".equalsIgnoreCase(contentType)) {
				removeSpanDot();
			}
		} else {
			spanDot.addStyleName(CssTokens.GREEN_STYLE);
			addParentSpanDots(contentType);
		}
	}
	
	public void addParentSpanDots(String contentValue) {
		if("collection".equalsIgnoreCase(contentType)||"lesson".equalsIgnoreCase(contentType)) {
			AppClientFactory.fireEvent(new HighlightContentSpanEvent(contentType,unitId,lessonId));
		}
	}
	
	HighlightContentSpanHandler highlightContentHandler = new HighlightContentSpanHandler() {
		@Override
		public void highlightContentSpan(String contentValue, String unitKey, String lessonKey) {
			if("collection".equalsIgnoreCase(contentValue)&&!"collection".equalsIgnoreCase(contentType)&&unitId.equalsIgnoreCase(unitKey)&&(lessonId!=null&&lessonKey!=null&&lessonId.equalsIgnoreCase(lessonKey))) {
				getSpanDot().addStyleName(CssTokens.GREEN_STYLE);
			} else if("collection".equalsIgnoreCase(contentValue)&&!"collection".equalsIgnoreCase(contentType)&&unitId.equalsIgnoreCase(unitKey)&&lessonId==null) {
				getSpanDot().addStyleName(CssTokens.GREEN_STYLE);
			} else if("lesson".equalsIgnoreCase(contentValue)&&"unit".equalsIgnoreCase(contentType)&&unitId.equalsIgnoreCase(unitKey)) {
				getSpanDot().addStyleName(CssTokens.GREEN_STYLE);
			}
		}
	};
	
	public void removeSpanDot() {
		Iterator<Widget> widgets= rowItem.iterator();
		while (widgets.hasNext()){
			  Widget widget = widgets.next();
			  if (widget instanceof ContentVisibilityItemWidget) {
				  ContentVisibilityItemWidget childWidget = (ContentVisibilityItemWidget)widget;
				  if(!childWidget.isVisible()) {
					  childWidget.getSpanDot().removeStyleName(CssTokens.GREEN_STYLE);
				  }
				  Iterator<Widget> childWidgets= childWidget.getRowItem().iterator();
				  while (childWidgets.hasNext()){
					  Widget collectionWidget = childWidgets.next();
					  if (collectionWidget instanceof ContentVisibilityItemWidget) {
						  ContentVisibilityItemWidget collectionWidgetItem = (ContentVisibilityItemWidget)collectionWidget;
						  if(!collectionWidgetItem.isVisible()) {
							  collectionWidgetItem.getSpanDot().removeStyleName(CssTokens.GREEN_STYLE);
						  }
					  }
				  }
			  }
		}
	}
	
	public HTMLEventPanel getLblContentName() {
		return contentPanel;
	}
	
	public HTMLEventPanel getRowItem() {
		return rowItem;
	}
	
	public HTMLEventPanel getSpanDot() {
		return spanDot;
	}
	
	public int getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(int collectionId) {
		this.collectionId = collectionId;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisibility(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	public boolean isClicked() {
		return isClicked;
	}

	public void setClicked(boolean isClicked) {
		this.isClicked = isClicked;
	}

	public void setArrowStyle(boolean isVisible) {
		arrowPanel.setVisible(isVisible);
		arrowPanel.setStyleName("class-name-arrow-down");
		if(isVisible) {
			iconPanel.addStyleName("open");
		} else {
			if("unit".equalsIgnoreCase(contentType)) {
				iconPanel.getElement().getStyle().setMarginLeft(15, Unit.PX);
			} else if("lesson".equalsIgnoreCase(contentType)) {
				iconPanel.getElement().getStyle().setMarginLeft(35, Unit.PX);
			}
		}
	}
}