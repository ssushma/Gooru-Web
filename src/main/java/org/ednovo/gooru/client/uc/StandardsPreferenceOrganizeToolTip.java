package org.ednovo.gooru.client.uc;

import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class StandardsPreferenceOrganizeToolTip extends PopupPanel {

	private static StandardsPreferenceOrganizeToolTipUiBinder uiBinder = GWT
			.create(StandardsPreferenceOrganizeToolTipUiBinder.class);

	interface StandardsPreferenceOrganizeToolTipUiBinder extends
			UiBinder<Widget, StandardsPreferenceOrganizeToolTip> {
	}
	@UiField
	HTMLPanel lblTitle;
	public StandardsPreferenceOrganizeToolTip() {
		setWidget(uiBinder.createAndBindUi(this));
		lblTitle.getElement().setInnerHTML(MessageProperties.GL1613);
	}

}
