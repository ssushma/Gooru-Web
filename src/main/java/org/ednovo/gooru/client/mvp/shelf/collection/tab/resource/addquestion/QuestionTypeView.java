package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.addquestion;


import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

public class QuestionTypeView extends BaseViewWithHandlers<QuestionTypeUiHandlers>
implements IsQuestionTypeView {

	@UiField QuestionTypeCBundle res;

	private static QuestionTypeViewUiBinder uiBinder = GWT	.create(QuestionTypeViewUiBinder.class);

	public MessageProperties msgProperties = GWT.create(MessageProperties.class);

	interface QuestionTypeViewUiBinder extends UiBinder<Widget, QuestionTypeView> {
	}

	public QuestionTypeView() {
		setWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void getRevealType() {
		System.out.println("");
	}

}