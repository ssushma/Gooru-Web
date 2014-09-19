package org.ednovo.gooru.client.mvp.library.partner.ccstcaltac;

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.library.partner.autodesk.AutodeskLibraryUiHandlers;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class CcstCalTacLibraryView extends BaseViewWithHandlers<CcstCalTacLibraryUiHandlers> implements IsCcstCalTacLibraryView {

	
	@UiField SimplePanel partnerPanel;
	
	private static CcstCalTacLibraryViewUiBinder uiBinder = GWT.create(CcstCalTacLibraryViewUiBinder.class);

	interface CcstCalTacLibraryViewUiBinder extends UiBinder<Widget, CcstCalTacLibraryView> {
	}
	
	public CcstCalTacLibraryView() {
		setWidget(uiBinder.createAndBindUi(this));
		partnerPanel.getElement().setId("spnlPartnerPanel");
	}
	
	
	@Override
	public void setInSlot(Object slot, Widget content) {
		if (content != null) {
			if (slot == CcstCalTacLibraryUiHandlers.TYPE_FOLDERS_SLOT) {
				partnerPanel.setWidget(content);
			}
		}
	}
}
