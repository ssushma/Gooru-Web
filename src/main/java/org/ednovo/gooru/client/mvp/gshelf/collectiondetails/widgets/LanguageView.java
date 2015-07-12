package org.ednovo.gooru.client.mvp.gshelf.collectiondetails.widgets;

import org.ednovo.gooru.application.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class LanguageView extends Composite {

	@UiField HTMLPanel mainContainer;
	
	@UiField TextArea languegeObjective;
	
	
	
	private static LanguageViewUiBinder uiBinder = GWT
			.create(LanguageViewUiBinder.class);

	interface LanguageViewUiBinder extends	UiBinder<Widget, LanguageView> {
	}

	static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	
	public LanguageView() {
		initWidget(uiBinder.createAndBindUi(this));
		mainContainer.getElement().setId("languageObjective");
	}
	
	public String getLanguageObjective(){
		
		return languegeObjective.getText();
	}
	
	
	
	
}
