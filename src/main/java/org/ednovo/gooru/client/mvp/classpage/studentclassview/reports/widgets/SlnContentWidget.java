package org.ednovo.gooru.client.mvp.classpage.studentclassview.reports.widgets;

import org.ednovo.gooru.client.uc.EmPanel;
import org.ednovo.gooru.client.uc.SpanPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class SlnContentWidget extends Composite {
	
	@UiField SpanPanel collectionViews, assessmentViews;
	@UiField HTMLPanel assessmentCountData, collectionCountData, assessmentRadial, collectionRadial, contentPanel;
	@UiField Label score;
	@UiField EmPanel timeSpent;
	@UiField Image contentImageStyle;
	
	private static final String ASSESSMENT_RADIAL = "org-progress-";
	
	private static SlnContentWidgetUiBinder uiBinder = GWT
			.create(SlnContentWidgetUiBinder.class);

	interface SlnContentWidgetUiBinder extends
			UiBinder<Widget, SlnContentWidget> {
	}

	public SlnContentWidget(String contentType, String lastItem) {
		initWidget(uiBinder.createAndBindUi(this));
		setData(contentType,lastItem);
	}

	public void setData(String contentType, String lastItem) {
		setContentIcon(contentType);
		if(contentType.equalsIgnoreCase("assessment")) {
			int scoreLbl = 80;
			assessmentViews.setText("2");
			score.setText(scoreLbl+"%");
			assessmentRadial.addStyleName(ASSESSMENT_RADIAL+scoreLbl);
			collectionCountData.setVisible(false);
			collectionRadial.setVisible(false);
		} else if(contentType.equalsIgnoreCase("collection")){
			collectionViews.setText("4");
			timeSpent.setText("20");
			assessmentCountData.setVisible(false);
			assessmentRadial.setVisible(false);
		}
		if(!lastItem.isEmpty()) {
			contentPanel.addStyleName(lastItem);
		}
	}
	
	private void setContentIcon(String icon) {
		if(icon.equalsIgnoreCase("assessment")) {
			contentImageStyle.setUrl("../images/folders/panel/assessment-smal.png");
		} else {
			contentImageStyle.setUrl("../images/folders/panel/collection-icon-small.png");
		}
	}
}