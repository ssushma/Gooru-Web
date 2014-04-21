package org.ednovo.gooru.client.mvp.shelf.collection.folders;


import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class FoldersWelcomePageToolTip extends Composite implements MessageProperties {
	
	@UiField Label mainHeadTitle;
	@UiField Label gerStartedLbl;

	private static FoldersWelcomePageToolTipUiBinder uiBinder = GWT.create(FoldersWelcomePageToolTipUiBinder.class);

	interface FoldersWelcomePageToolTipUiBinder extends UiBinder<Widget, FoldersWelcomePageToolTip> {
	}
	
	public FoldersWelcomePageToolTip() {
		initWidget(uiBinder.createAndBindUi(this));
		mainHeadTitle.setText(GL1293+GL_SPL_EXCLAMATION);
		gerStartedLbl.setText(GL1474);
	}
	
}
