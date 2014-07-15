package org.ednovo.gooru.client.uc;

import org.ednovo.gooru.shared.i18n.CopyOfMessageProperties;

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
	
	private CopyOfMessageProperties i18n = GWT.create(CopyOfMessageProperties.class);
	
	@UiField
	HTMLPanel lblTitle;
	public StandardsPreferenceOrganizeToolTip() {
		setWidget(uiBinder.createAndBindUi(this));
		lblTitle.getElement().setInnerHTML(i18n.GL1613());
	}

}
