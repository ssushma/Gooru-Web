package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.drive;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.drive.event.DriveEvent;
import org.ednovo.gooru.shared.model.drive.GoogleDriveItemDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class GoogleWebResource extends Composite {
	private static GoogleWebResourceUiBinder uiBinder = GWT
			.create(GoogleWebResourceUiBinder.class);

	interface GoogleWebResourceUiBinder extends
			UiBinder<Widget, GoogleWebResource> {

	}

	String folderMimeType = "application/vnd.google-apps.folder";
	String type = null;

	String dataIconType = null;
	@UiField
	Label imageIcon;
	@UiField
	HTML driveText;
	@UiField
	HTMLPanel contentPanel;
	@UiField
	HTMLPanel folderContent;

	GoogleDriveItemDo driveDo = new GoogleDriveItemDo();

	public GoogleWebResource(GoogleDriveItemDo driveDo) {

		initWidget(uiBinder.createAndBindUi(this));
		this.driveDo = driveDo;
		System.out.println("value s enter  wideget" + driveDo.getTitle());
		driveText.setText(driveDo.getTitle());
		driveText.getElement().setId("htmlDriveText");
		driveText.getElement().setAttribute("alt", driveDo.getTitle());
		driveText.getElement().setAttribute("title", driveDo.getTitle());
		contentPanel.getElement().setId("pnlContentPanel");
		folderContent.getElement().setId("pnlFolderContent");
		imageIcon.getElement().setId("lblImageIcon");
		contentPanel.addDomHandler(contentClick, ClickEvent.getType());
		type = driveDo.getMimeType();
		String dataType[] = type.split("\\.");
		System.out.println("dataypes" + dataType[0].toString());
		dataIconType = dataType[0];

	}

	ClickHandler contentClick = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			System.out.println("datfaypeicon" + dataIconType);

			if (type.equalsIgnoreCase(folderMimeType)) {

				folderContent(driveDo.getId());

				System.out.println("enter in folder condition");

			} else {
				AppClientFactory.fireEvent(new DriveEvent(driveDo));
				System.out.println("elase condion in  widget");

			}

		}

	};

	private void folderContent(String id) {
		folderContent.clear();
		// TODO Auto-generated method stub
//		AppClientFactory.getInjector().getResourceService()
//				.getfolderList(id, new AsyncCallback<List<GoogleDriveItemDo>>() {
//
//					@Override
//					public void onFailure(Throwable caught) {
//						// TODO Auto-generated method stub
//
//					}
//
//					@Override
//					public void onSuccess(List<GoogleDriveItemDo> result) {
//
//						System.out.println("enteringb   successssssss");
//						AppClientFactory.fireEvent(new FolderEvent(driveDo
//								.getTitle(), driveDo.getId(), result));
//						// TODO Auto-generated method stub
//						// System.out.println("on sucesssss"+result.get(0).getTitle());
//						/*
//						 * if (result != null) {
//						 * 
//						 * for(int m=0;m<result.size();m++){
//						 * 
//						 * folderContent.add(new
//						 * GoogleWebResource(result.get(m)));
//						 * 
//						 * }
//						 * 
//						 * }
//						 */
//					}
//				});

	}
}
