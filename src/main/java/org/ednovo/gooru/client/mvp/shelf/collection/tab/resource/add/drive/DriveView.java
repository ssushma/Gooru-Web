/*******************************************************************************
 * Copyright 2013 Ednovo d/b/a Gooru. All rights reserved.
 * 
 *  http://www.goorulearning.org/
 * 
 *  Permission is hereby granted, free of charge, to any person obtaining
 *  a copy of this software and associated documentation files (the
 *  "Software"), to deal in the Software without restriction, including
 *  without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to
 *  permit persons to whom the Software is furnished to do so, subject to
 *  the following conditions:
 * 
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 * 
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 *  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 *  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 *  WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.drive;

import java.util.ArrayList;
import java.util.List;

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.shared.model.drive.GoogleDriveDo;
import org.ednovo.gooru.shared.model.drive.GoogleDriveItemDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team ` *
 */
public class DriveView extends BaseViewWithHandlers<DriveUiHandlers> implements
		IsDriveView, MessageProperties {

	private static final String AUDIO_MIMETYPE="application/vnd.google-apps.audio";
	private static final String DOCUMENT_MIMETYPE="application/vnd.google-apps.document";
	private static final String DRAWING_MIMETYPE="application/vnd.google-apps.drawing";
	private static final String FILE_MIMETYPE="application/vnd.google-apps.file";
	private static final String FOLDER_MIMETYPE="application/vnd.google-apps.folder";
	private static final String FORM_MIMETYPE="application/vnd.google-apps.form";
	private static final String FUSIONTABLE_MIMETYPE="application/vnd.google-apps.fusiontable";
	private static final String PHOTO_MIMETYPE="application/vnd.google-apps.photo";
	private static final String PRESENTATION_MIMETYPE="application/vnd.google-apps.presentation";
	private static final String SCRIPT_MIMETYPE="application/vnd.google-apps.script";
	private static final String SITES_MIMETYPE="application/vnd.google-apps.sites";
	private static final String SPREADSHEET_MIMETYPE="application/vnd.google-apps.spreadsheet";
	private static final String UNKNOWN_MIMETYPE="application/vnd.google-apps.unknown";
	private static final String VIDEO_MIMETYPE="application/vnd.google-apps.video";
	
	@UiField FlowPanel panelDriveBreadCrums, panelFileList;
	@UiField GoogleDriveFilesStyleBundle driveStyle;

	private static DriveViewUiBinder uiBinder = GWT.create(DriveViewUiBinder.class);

	interface DriveViewUiBinder extends UiBinder<Widget, DriveView> {
	}

	public DriveView() {
		setWidget(uiBinder.createAndBindUi(this));
//		rootDriveLabel.setText("Drive");
		panelDriveBreadCrums.add(new Label("Drive > "));
	}

	
	
	
	@Override
	public void setInSlot(Object slot, Widget content) {

	}

	@Override
	public void getDriveDetails(GoogleDriveItemDo driveDo) {
		// TODO Auto-generated method stub
		panelFileList.clear();
		panelFileList.add(new GoogleDocsResourceView(driveDo));

	}

//	@UiHandler("rootDriveLabel")
//	public void rootDriveLabelclick(ClickEvent event) {
//		getUiHandlers().getdriveListAgain();
//
//	}

	@Override
	public void getFolderDetails(String title, String id, List<GoogleDriveItemDo> result) {
		// TODO Auto-generated method stub
		panelDriveBreadCrums.add(new Label(" "+title+""));
		panelFileList.clear();
		for (int n = 0; n < result.size(); n++) {
			panelFileList.add(new GoogleWebResource(result.get(n)));

		}
	}

	@Override
	public void driveContentList(GoogleDriveDo googleDriveDo) {
		panelFileList.clear();
		if(googleDriveDo!=null&&googleDriveDo.getItems()!=null&&googleDriveDo.getItems().size()>0){
			ArrayList<GoogleDriveItemDo> googleDriveItemsList=googleDriveDo.getItems();
			for(int i=0;i<googleDriveItemsList.size();i++){
				DriveFileView driveFileView=new DriveFileView(googleDriveItemsList.get(i).getMimeType(),googleDriveItemsList.get(i).getTitle());
				panelFileList.add(driveFileView);
			}
		}
	}
	
	public class DriveFileView extends Composite{
		private FlowPanel conatiner=null;
		private HTMLPanel fileTypeImage=new HTMLPanel("");
		private Label label=new Label();
		public DriveFileView(String mimeType,String title){
			initWidget(conatiner=new FlowPanel());
			fileTypeImage.add(label);
			conatiner.add(fileTypeImage);
			setFileTypeImage(mimeType);
			System.out.println("mime typeee===>"+mimeType);
			setFileTitle(title);
		}
		private void setFileTypeImage(String mimeType){
			if(mimeType.equals(FOLDER_MIMETYPE)){
				fileTypeImage.setStyleName(driveStyle.googleDriveFolderStyle());
			}else if(mimeType.equals(DOCUMENT_MIMETYPE)){
				fileTypeImage.setStyleName(driveStyle.googleDriveWordStyle());
			}else if(mimeType.equals(SPREADSHEET_MIMETYPE)){
				fileTypeImage.setStyleName(driveStyle.googleDriveExcelStyle());
			}else if(mimeType.equals(PRESENTATION_MIMETYPE)){
				fileTypeImage.setStyleName(driveStyle.googleDrivePptStyle());
			}else{
				fileTypeImage.setStyleName(driveStyle.googleDrivePptStyle());
			}
		}
		private void setFileTitle(String title){
			label.setText(title);
			label.setStyleName("");
		}
		
	}

}