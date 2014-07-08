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
import java.util.Date;
import java.util.List;

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.shared.i18n.CopyOfMessageProperties;
import org.ednovo.gooru.shared.model.drive.GoogleDriveDo;
import org.ednovo.gooru.shared.model.drive.GoogleDriveItemDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.event.dom.client.ScrollHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team ` *
 */
public class DriveView extends BaseViewWithHandlers<DriveUiHandlers> implements
		IsDriveView, MessageProperties {

	public static final String DOCUMENT_MIMETYPE="application/vnd.google-apps.document";
	public static final String DRAWING_MIMETYPE="application/vnd.google-apps.drawing";
	public static final String FOLDER_MIMETYPE="application/vnd.google-apps.folder";
	public static final String FORM_MIMETYPE="application/vnd.google-apps.form";
	public static final String PRESENTATION_MIMETYPE="application/vnd.google-apps.presentation";
	public static final String SPREADSHEET_MIMETYPE="application/vnd.google-apps.spreadsheet";
	
	@UiField FlowPanel panelDriveBreadCrums, panelFileList;
	@UiField ScrollPanel driveScrollContainer;
	@UiField GoogleDriveFilesStyleBundle driveStyle;
	
	private String pageToken=null;
	
	private static DriveViewUiBinder uiBinder = GWT.create(DriveViewUiBinder.class);

	public CopyOfMessageProperties i18n = GWT.create(CopyOfMessageProperties.class);
	
	
	interface DriveViewUiBinder extends UiBinder<Widget, DriveView> {
	}
	
	String webResourceId;
	String webResourceUrl;
	String webResourceTitle;
	String webResourceDescription;
	String webResourceCategory;
	String webResourceThumbnail;
	Integer webResourceEnd; 
	
	public DriveView() {
		setWidget(uiBinder.createAndBindUi(this));
		driveScrollContainer.addScrollHandler(new DriveScrollEvent());

	}

	
	/**
	 * @return the panelFileList
	 */
	public FlowPanel getPanelFileList() {
		return panelFileList;
	}



	/**
	 * @param panelFileList the panelFileList to set
	 */
	public void setPanelFileList(FlowPanel panelFileList) {
		this.panelFileList = panelFileList;
	}
	
	@Override
	public void setInSlot(Object slot, Widget content) {

	}

	@Override
	public void getDriveDetails(GoogleDriveItemDo driveDo) {
		panelFileList.clear();
		panelFileList.setVisible(true);
		panelDriveBreadCrums.setVisible(true);
		//lblLoading.setVisible(false);
		panelFileList.add(new GoogleDocsResourceView(driveDo));

	}
	
	private class DriveScrollEvent implements ScrollHandler{
		@Override
		public void onScroll(ScrollEvent event) {
			if((driveScrollContainer.getVerticalScrollPosition() == driveScrollContainer.getMaximumVerticalScrollPosition())&&pageToken!=null){
				String folderId=getFolderIdFromBreadCrumbs();
				getUiHandlers().getGoogleDriveFiles(folderId, pageToken, false);
				pageToken=null;
			}
		}
	}
	
	public String getFolderIdFromBreadCrumbs(){
		int widgetCount=panelDriveBreadCrums.getWidgetCount();
		Widget widget=panelDriveBreadCrums.getWidget(widgetCount-1);
		String folderId=null;
		if(widget instanceof BreadCrumbLabel){
			BreadCrumbLabel breadCrumbLabel=(BreadCrumbLabel)widget;
			folderId=breadCrumbLabel.getFolderId();
		}
		return folderId;
	}

	@Override
	public void getFolderDetails(String title, String id, List<GoogleDriveItemDo> result) {
		panelDriveBreadCrums.add(new Label(" "+title+""));
		panelFileList.clear();
		panelFileList.setVisible(true);
		panelDriveBreadCrums.setVisible(true);
		//lblLoading.setVisible(false);
		for (int n = 0; n < result.size(); n++) {
			panelFileList.add(new GoogleWebResource(result.get(n)));
		}
	}

	@Override
	public void driveContentList(GoogleDriveDo googleDriveDo) {
		panelFileList.setVisible(true);
		panelDriveBreadCrums.setVisible(true);
		if (googleDriveDo != null && googleDriveDo.getItems() != null
				&& googleDriveDo.getItems().size() > 0) {
			pageToken=googleDriveDo.getNextPageToken();

			ArrayList<GoogleDriveItemDo> googleDriveItemsList = googleDriveDo.getItems();
			for (int i = 0; i < googleDriveItemsList.size(); i++) {
				DriveFileView driveFileView = new DriveFileView(googleDriveItemsList.get(i).getMimeType(), googleDriveItemsList.get(i).getTitle());
				driveFileView.addClickHandler(new GoogleFolderClickEvent(googleDriveItemsList.get(i)));
				panelFileList.add(driveFileView);
			}
		}else{
			showNoDriveAccess(0);
		}
	}
	
	
	@Override
	public void showNoDriveAccess(int errorCode) {
		panelFileList.clear();
		panelDriveBreadCrums.setVisible(false);
		Cookies.setCookie("google-access-token", "", new Date());
		if (errorCode==401){
			showErrorMessage(i18n.GL2013(),i18n.GL2014());
		}else if (errorCode==0){
			showErrorMessage("",i18n.GL2018());
		}else if (errorCode==403){
			showErrorMessage(i18n.GL2013(),i18n.GL2015());
		}
	}
	@Override
	public void showDriveNotConnectedErrorMessage() {
		showErrorMessage(i18n.GL2013(),i18n.GL2014());
	}
	public void showErrorMessage(String errorHeading, String errorSubHeading){
		FlowPanel errorContainer=new FlowPanel();
		errorContainer.setStyleName(driveStyle.pannelError());
		Label lblErrorHeading=new Label();
		lblErrorHeading.setStyleName(driveStyle.errorHeading());
		lblErrorHeading.setText(i18n.GL2013());
		lblErrorHeading.getElement().setAttribute("alt", i18n.GL2013()); 
		lblErrorHeading.getElement().setAttribute("title", i18n.GL2013());
		Label lblErrorSubHeading=new Label();
		lblErrorSubHeading.setStyleName("");
		lblErrorSubHeading.setText(i18n.GL2014());
		lblErrorSubHeading.getElement().setAttribute("alt", i18n.GL2014());
		lblErrorSubHeading.getElement().setAttribute("title", i18n.GL2014());
		errorContainer.add(lblErrorHeading);
		errorContainer.add(lblErrorSubHeading);
		panelFileList.add(errorContainer);
	}
	
	public class DriveFileView extends Composite implements HasClickHandlers{
		private FlowPanel conatiner=null;
		private HTMLPanel fileTypeImage=new HTMLPanel("");
		private Label label=new Label();
		public DriveFileView(String mimeType,String title){
			initWidget(conatiner=new FlowPanel());
			fileTypeImage.add(label);
			conatiner.add(fileTypeImage);
			setFileTypeImage(mimeType);
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
			}else if(mimeType.equals(FORM_MIMETYPE)){
				fileTypeImage.setStyleName(driveStyle.googleDriveFormStyle());
			}else if(mimeType.equals(DRAWING_MIMETYPE)){
				fileTypeImage.setStyleName(driveStyle.googleDriveDrawingStyle());
			}
		}
		private void setFileTitle(String title){
			label.setText(title);
			label.setStyleName("");
		}
		@Override
		public HandlerRegistration addClickHandler(ClickHandler handler) {
			return addDomHandler(handler, ClickEvent.getType());
		}
	}
	
	private class GoogleFolderClickEvent implements ClickHandler{
		private GoogleDriveItemDo googleDriveItemDo=null;
		public  GoogleFolderClickEvent(GoogleDriveItemDo googleDriveItemDo){
			this.googleDriveItemDo=googleDriveItemDo;
		}
		@Override
		public void onClick(ClickEvent event) {
			if(googleDriveItemDo.getMimeType().equals(FOLDER_MIMETYPE)){
				getGoogleFolderItems(googleDriveItemDo.getId());
				setBreadCrumbLabel(googleDriveItemDo.getId(),googleDriveItemDo.getTitle());
			}else {
				pageToken=null;
				getUiHandlers().showAddResourceWidget(googleDriveItemDo);
				setBreadCrumbLabel(googleDriveItemDo.getId(),googleDriveItemDo.getTitle());
			}
		}
	}
	
	private void getGoogleFolderItems(String folderId){
		getUiHandlers().getGoogleDriveFiles(folderId, null, true);
	}
	
	
	public void setBreadCrumbLabel(String folderId,String folderTitle){
		if(folderId!=null){
			BreadCrumbLabel  breadCrumbLabel=new BreadCrumbLabel(folderId);
			breadCrumbLabel.setText(folderTitle);
			BreadCrumbLabel arrowPanel=new BreadCrumbLabel();
			arrowPanel.setStyleName(driveStyle.breadCrumbsArrow());
			addClickEventForBreadCrumbs();
			panelDriveBreadCrums.add(arrowPanel);
			panelDriveBreadCrums.add(breadCrumbLabel);
		}else{
			BreadCrumbLabel  breadCrumbLabel=new BreadCrumbLabel(folderId);
			breadCrumbLabel.setText("Drive");
			panelDriveBreadCrums.clear();
			panelDriveBreadCrums.add(breadCrumbLabel);
		}
	}
	public void removeBreadCrumbs(int index){
		int widgetCount=panelDriveBreadCrums.getWidgetCount();
		for(int i=index+1;i<widgetCount;){
			BreadCrumbLabel breadCrumbLabel=(BreadCrumbLabel)panelDriveBreadCrums.getWidget(i);
			breadCrumbLabel.setText("");
			breadCrumbLabel.removeFromParent();
			widgetCount=panelDriveBreadCrums.getWidgetCount();
		}
		BreadCrumbLabel lastbreadCrumbLabel=(BreadCrumbLabel)panelDriveBreadCrums.getWidget(index);
		BreadCrumbLabel newbreadCrumbLabel=new BreadCrumbLabel(lastbreadCrumbLabel.getFolderId());
		newbreadCrumbLabel.setText(lastbreadCrumbLabel.getText());
		lastbreadCrumbLabel.removeFromParent();
		panelDriveBreadCrums.add(newbreadCrumbLabel);
	}
	public void addClickEventForBreadCrumbs(){
		int widgetCount=panelDriveBreadCrums.getWidgetCount();
		Widget widget=panelDriveBreadCrums.getWidget(widgetCount-1);
		if(widget instanceof BreadCrumbLabel){
			BreadCrumbLabel breadCrumbLabel=(BreadCrumbLabel)widget;
			breadCrumbLabel.setStyleName(driveStyle.breadCrumbsText());
			breadCrumbLabel.addClickHandler(new GoogleDriveClickEvent(breadCrumbLabel.getFolderId(),widgetCount-1));
		}
	}
	private class GoogleDriveClickEvent implements ClickHandler{
		private String folderId=null;
		private int index=0;
		public  GoogleDriveClickEvent(String folderId,int widgetIndex){
			this.folderId=folderId;
			this.index=widgetIndex;
		}
		@Override
		public void onClick(ClickEvent event) {
			removeBreadCrumbs(index);
			getGoogleFolderItems(folderId);
		}
	}
	public class BreadCrumbLabel extends InlineLabel{
		private String folderId=null;
		public BreadCrumbLabel(String folderId){
			super();
			this.folderId=folderId;
		}
		public BreadCrumbLabel(){
			super();
			this.setText(">");
		}
		public String getFolderId(){
			return folderId;
		}
	}

}