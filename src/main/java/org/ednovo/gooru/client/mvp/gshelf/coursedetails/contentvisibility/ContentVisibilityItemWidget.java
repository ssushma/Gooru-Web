package org.ednovo.gooru.client.mvp.gshelf.coursedetails.contentvisibility;

import java.util.Iterator;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.client.CssTokens;
import org.ednovo.gooru.client.mvp.gshelf.coursedetails.HighlightContentSpanEvent;
import org.ednovo.gooru.client.mvp.gshelf.coursedetails.HighlightContentSpanHandler;
import org.ednovo.gooru.client.ui.HTMLEventPanel;

import com.google.gwt.core.client.GWT;
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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ContentVisibilityItemWidget extends Composite {

	@UiField HTMLEventPanel rowItem, spanDot, rightRow;
	@UiField Label lblContentName;
	@UiField Anchor anrSelect;
	
	private String contentType = null, unitId = null, lessonId = null;
	
	private static ContentVisibilityItemWidgetUiBinder uiBinder = GWT
			.create(ContentVisibilityItemWidgetUiBinder.class);

	interface ContentVisibilityItemWidgetUiBinder extends
			UiBinder<Widget, ContentVisibilityItemWidget> {
	}

	public ContentVisibilityItemWidget(String contentType, String contentName, String unitId, String lessonId) {
		initWidget(uiBinder.createAndBindUi(this));
		this.contentType = contentType;
		this.unitId = unitId;
		this.lessonId = lessonId;
		setData(contentType, contentName);
		spanDot.addClickHandler(new SpanDot(contentType));
		anrSelect.addClickHandler(new AllContentItems());
		anrSelect.setVisible(false);
		AppClientFactory.getEventBus().addHandler(HighlightContentSpanEvent.TYPE, highlightContentHandler);
		if(!"collection".equalsIgnoreCase(contentType)) {
			rightRow.addMouseOverHandler(new MouseOverShowAnchor());
			rightRow.addMouseOutHandler(new MouseOverHideAnchor());
		}
	}
	
	public class MouseOverShowAnchor implements MouseOverHandler{
		@Override
		public void onMouseOver(MouseOverEvent event) {
			if(rowItem.getWidgetCount()>2) {
				anrSelect.setVisible(true);
			}
		}
	}
	
	public class MouseOverHideAnchor implements MouseOutHandler{
		@Override
		public void onMouseOut(MouseOutEvent event) {
			if(rowItem.getWidgetCount()>2) {
				anrSelect.setVisible(false);
			}
		}
	}
	
	private void setData(String contentType, String contentName) {
		lblContentName.setText(contentName);
		if("unit".equalsIgnoreCase(contentType)) {
			rowItem.setStyleName("unitRow");
			lblContentName.addStyleName("levelOne");
			lblContentName.addStyleName("cursor");
		} else if("lesson".equalsIgnoreCase(contentType)) {
			rowItem.setStyleName("lessonRow");
			lblContentName.addStyleName("levelTwo");
			lblContentName.addStyleName("cursor");
		} else if("collection".equalsIgnoreCase(contentType)) {
			rowItem.setStyleName("collectionRow");
			lblContentName.addStyleName("levelThree");
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
		public SpanDot(String contentType) {
			this.contentType = contentType;
		}

		@Override
		public void onClick(ClickEvent event) {
			setSpanDot(contentType);
		}
	}
	
	public void setSpanDot(String contentType) {
		String style = spanDot.getStyleName();
		if(style.contains(CssTokens.GREEN_STYLE)) {
			spanDot.removeStyleName(CssTokens.GREEN_STYLE);
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
				  childWidget.getSpanDot().removeStyleName(CssTokens.GREEN_STYLE);
				  Iterator<Widget> childWidgets= childWidget.getRowItem().iterator();
				  while (childWidgets.hasNext()){
					  Widget collectionWidget = childWidgets.next();
					  if (collectionWidget instanceof ContentVisibilityItemWidget) {
						  ContentVisibilityItemWidget collectionWidgetItem = (ContentVisibilityItemWidget)collectionWidget;
						  collectionWidgetItem.getSpanDot().removeStyleName(CssTokens.GREEN_STYLE);
					  }
				  }
			  }
		}
	}
	
	public Label getLblContentName() {
		return lblContentName;
	}
	
	public HTMLEventPanel getRowItem() {
		return rowItem;
	}
	
	public HTMLEventPanel getSpanDot() {
		return spanDot;
	}
}