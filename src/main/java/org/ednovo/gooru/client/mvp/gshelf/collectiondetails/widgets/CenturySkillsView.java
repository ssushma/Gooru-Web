package org.ednovo.gooru.client.mvp.gshelf.collectiondetails.widgets;

import org.ednovo.gooru.application.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class CenturySkillsView extends Composite {

	private static DepthKnowledgeViewUiBinder uiBinder = GWT.create(DepthKnowledgeViewUiBinder.class);

	interface DepthKnowledgeViewUiBinder extends UiBinder<Widget, CenturySkillsView> {
	}

	static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	
	public CenturySkillsView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
}
