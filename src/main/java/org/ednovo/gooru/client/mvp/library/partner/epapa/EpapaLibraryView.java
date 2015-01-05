package org.ednovo.gooru.client.mvp.library.partner.epapa;

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class EpapaLibraryView extends BaseViewWithHandlers<EpapaLibraryUiHandlers> implements IsEpapaLibraryView {
	

	@UiField SimplePanel partnerPanel;
	
	private static EpapaLibraryViewUiBinder uiBinder = GWT.create(EpapaLibraryViewUiBinder.class);

	interface EpapaLibraryViewUiBinder extends UiBinder<Widget, EpapaLibraryView> {
	}
	
	public EpapaLibraryView() {
		setWidget(uiBinder.createAndBindUi(this));
		partnerPanel.getElement().setId("spnlPartnerPanel");
	}
	
	
	@Override
	public void setInSlot(Object slot, Widget content) {
		if (content != null) {
			if (slot == EpapaLibraryUiHandlers.TYPE_FOLDERS_SLOT) {
				partnerPanel.setWidget(content);
			}
		}
	}


}
