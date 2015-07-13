package org.ednovo.gooru.client.mvp.gshelf.util;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class FolderInfoWidget extends Composite {
	
	@UiField TextBox folderTitleTxtBox;
	@UiField Label lblErrorMessage;
	@UiField HTMLPanel folderInfo;
	@UiField Button saveFolderBtn;

	private static FolderInfoWidgetUiBinder uiBinder = GWT
			.create(FolderInfoWidgetUiBinder.class);

	interface FolderInfoWidgetUiBinder extends
			UiBinder<Widget, FolderInfoWidget> {
	}
	
	

	public FolderInfoWidget() {
		initWidget(uiBinder.createAndBindUi(this));
		folderInfo.getElement().setId("pnlCollectionInfo");
	}

}
