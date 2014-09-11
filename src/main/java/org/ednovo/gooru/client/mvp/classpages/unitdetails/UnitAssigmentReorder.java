package org.ednovo.gooru.client.mvp.classpages.unitdetails;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class UnitAssigmentReorder extends PopupPanel {

	private static UnitAssigmentReorderUiBinder uiBinder = GWT
			.create(UnitAssigmentReorderUiBinder.class);

	interface UnitAssigmentReorderUiBinder extends
			UiBinder<Widget, UnitAssigmentReorder> {
	}
	@UiField Image popupArrow;
	@UiField Button saveButton,CancelButton;
	public UnitAssigmentReorder() {
		setWidget(uiBinder.createAndBindUi(this));
		popupArrow.setUrl("images/popArrow.png");
		saveButton.setText("Save");
		CancelButton.setText("Cancel");
	}

}
