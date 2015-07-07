package org.ednovo.gooru.client.mvp.gshelf.collectiondetails;

import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class ExternalAssessmentView extends BaseViewWithHandlers<ExternalAssessmentInfoUiHandlers> implements IsExternalAssessmentView {

	private static ExternalAssessmentViewUiBinder uiBinder = GWT
			.create(ExternalAssessmentViewUiBinder.class);

	interface ExternalAssessmentViewUiBinder extends
			UiBinder<Widget, ExternalAssessmentView> {
	}

	@UiField HTMLPanel pnlExternalAssessmentContainter;
	
	public ExternalAssessmentView() {
		setWidget(uiBinder.createAndBindUi(this));
		pnlExternalAssessmentContainter.getElement().setId("pnlExternalAssessmentContainter");
	}
}
