package org.ednovo.gooru.client.mvp.classpage.studentclassview.reports.widgets;

import org.ednovo.gooru.client.uc.H2Panel;
import org.ednovo.gooru.client.uc.H3Panel;
import org.ednovo.gooru.client.uc.PPanel;
import org.ednovo.gooru.client.ui.HTMLEventPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class SlnUnitReportView extends Composite {
	
	@UiField HTMLEventPanel unitBlock;
	@UiField HTMLPanel slnContentPanel;
	@UiField Label numericOrder;
	@UiField H3Panel lessonCountName;
	@UiField PPanel lessonName;
	@UiField H2Panel totalScore;
	
	private static SlnUnitReportViewUiBinder uiBinder = GWT.create(SlnUnitReportViewUiBinder.class);

	interface SlnUnitReportViewUiBinder extends UiBinder<Widget, SlnUnitReportView> {
	}

	public SlnUnitReportView(int count) {
		initWidget(uiBinder.createAndBindUi(this));
		setReportData(count);
	}
	
	public void setReportData(int count) {
		numericOrder.setText(count+"");
		lessonCountName.setText("Intro to Fractions");
		lessonName.setText("Lesson");
		totalScore.setText("60");
		slnContentPanel.clear();
		slnContentPanel.add(new SlnContentWidget("collection",""));
		slnContentPanel.add(new SlnContentWidget("assessment",""));
		slnContentPanel.add(new SlnContentWidget("assessment","lastItem"));
	}
	
}