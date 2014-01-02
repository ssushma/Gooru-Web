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
package org.ednovo.gooru.client.mvp.image.upload;

import org.ednovo.gooru.client.GooruCBundle;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.client.uc.AlertForImageUpload;
import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.client.uc.BlueButtonUc;
import org.ednovo.gooru.client.uc.ErrorLabelUc;
import org.ednovo.gooru.client.uc.GlassPanelWithLoadingUc;
import org.ednovo.gooru.shared.model.user.MediaUploadDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormHandler;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.FormSubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormSubmitEvent;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;
/**
 * @fileName : ImageUploadView.java
 *
 * @description : This is the top-level for the image uplaod view.
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class ImageUploadView extends PopupViewWithUiHandlers<ImageUploadUiHandlers> implements IsImageUploadView, MessageProperties {

	private static ImageUploadViewUiBinder uiBinder = GWT.create(ImageUploadViewUiBinder.class);

	interface ImageUploadViewUiBinder extends UiBinder<Widget, ImageUploadView> {
	}
	
	private boolean isUserUnder13=false;
	private boolean isUploadProfileWidget=false;
	private int selectedWidgetIndex=-1;
	private float aspectRatio=1.34f;
	private boolean isEdit=false;
	public AppPopUp appPopUp;
	protected AppPopUp imageCropPopup;

	@UiField
	FileUpload fileUpload;

	@UiField
	Anchor imageUploadOnWebLbl,uploadGooruImages;

	@UiField
	Anchor imageUploadOnComputerLbl;

	@UiField
	FlowPanel imageUploadOnUrlFloPanel,gooruProfileDefaultImagesContainer;
	@UiField Button okButtonOnUploadGooruImages;
	@UiField Label cancelButtonOnUploadGooruImages;

	@UiField
	FlowPanel imageUploadOnWebFloPanel;

	@UiField
	BlueButtonUc onWebCancelBtn;

	@UiField
	BlueButtonUc onSystemCancelBtn;

	@UiField
	TextBox imageWebUploadUrlTxtBox;

	@UiField
	BlueButtonUc uploadImageButtonOnWeb;

	@UiField
	FormPanel fileuploadForm;

	@UiField
	FlowPanel imagUploadFloPanel,uploadGooruImagesContainer;

	@UiField
	FlowPanel imageCropFloPanel;

	@UiField
	GlassPanelWithLoadingUc glassPanelWithLoadingUc;

	@UiField
	ErrorLabelUc urlValidation;
	
	private static final String IMAGE_UPLOAD_URL = "/media?sessionToken={0}&uploadFileName={1}&resize=true&width=600&height=450";
	
	private static final String IMAGE_UPLOAD_URL_PATTERN = "(?:([^:/?#]+):)?(?://([^/?#]*))?([^?#]*\\.(?:jpg|gif|jpeg|png))(?:\\?([^#]*))?(?:#(.*))?";
	
	private static final String IMAGE_UPLOAD_FILE_PATTERN = "([^\\s]+([^?#]*\\.(?:jpg|gif|jpeg|png))$)";
	

	/**
	 * See for more details  {@link PopupViewWithUiHandlers} for details.
	 * 
	 * @param eventBus instance of {@link EventBus}
	 */
	@Inject
	public ImageUploadView(EventBus eventBus) {
		super(eventBus);
		GooruCBundle.INSTANCE.css().ensureInjected();
		appPopUp = new AppPopUp("type");
		appPopUp.setContent(uiBinder.createAndBindUi(this));
		appPopUp.setStyleName(GooruCBundle.INSTANCE.css().imageUploadPopup());
		imageCropPopup = new AppPopUp("type");
		imageCropPopup.setStyleName(GooruCBundle.INSTANCE.css().imageUploadPopup());
		fileUpload.getElement().setAttribute("size", "25");
		fileUpload.getElement().setId("fileUpload");
		onWebCancelBtn.getElement().setId("btnCancel");
		onSystemCancelBtn.getElement().setId("btnCancel");
		fileUpload.getElement().setId("fileUpload");
		imageUploadOnWebLbl.getElement().setId("lnkOnWeb");
		imageUploadOnComputerLbl.getElement().setId("lnkOnComputer");
		uploadGooruImages.getElement().setId("lnkGooruImages");
		imageUploadOnComputerLbl.setStyleName(GooruCBundle.INSTANCE.css().uploadClose());
		imageUploadOnWebLbl.setStyleName(GooruCBundle.INSTANCE.css().uploadActive());
		uploadGooruImages.setStyleName(GooruCBundle.INSTANCE.css().uploadClose());
		uploadGooruImages.getElement().getStyle().setDisplay(Display.NONE);
		imageWebUploadUrlTxtBox.getElement().setId("tbImageWebUploadUrl");
		uploadImageButtonOnWeb.getElement().setId("btnUpload");
		urlValidation.setVisible(false);
		imageWebUploadUrlTxtBox.addFocusHandler(new OnTextFocus());
		urlValidation.setStyleName(GooruCBundle.INSTANCE.css().imageUrlError());
		handelFormEvent();
		appPopUp.setModal(true);
//		Window.enableScrolling(false);
//		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, false));
		addClickEventToDefaultImages();
		fileuploadForm.addSubmitHandler(new FormPanel.SubmitHandler() {
			public void onSubmit(SubmitEvent event) {
				if (!"".equalsIgnoreCase(fileUpload.getFilename())) {
					String size=getFileNameSize();
					  
					double sizeOfImage=Double.parseDouble(size);
					if(sizeOfImage>5){
						
				 
				 
						new AlertForImageUpload(GL0061,"The image you are trying to upload is either the wrong file type or too large! Please upload another image.");
						 glasspanelLoadingImage(false);
							 
						fileuploadForm.reset();
						
						event.cancel(); 
				//		Window.enableScrolling(true);
				//		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
						
						 
					}
		
				}
				else{
					event.cancel(); // cancel the event
				//	Window.enableScrolling(true);
				//	AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
				}

			}
		});
		
		
	}

	@Override
	public Widget asWidget() {
		return appPopUp;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUnload() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onLoad() {
		// TODO Auto-generated method stub

	}
	/**
	 * @function addClickEventToDefaultImages 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : This method is used to add click events to the default images.
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void addClickEventToDefaultImages(){
		int widgetsCount=gooruProfileDefaultImagesContainer.getWidgetCount();
		for(int widgetIndex=0;widgetsCount>widgetIndex;widgetIndex++){
			final int selectedWidget=widgetIndex;
			GooruImagesView gooruImagesView=(GooruImagesView)gooruProfileDefaultImagesContainer.getWidget(widgetIndex);
			gooruImagesView.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					highlightSelectedImage(selectedWidget);
				}
			});
		}
	}
	/**
	 * @function highlightSelectedImage 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : This method is used to highlight the selected image.
	 * 
	 * 
	 * @parm(s) : @param widgetIndex
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private void highlightSelectedImage(int widgetIndex){
		GooruImagesView gooruImagesView=(GooruImagesView)gooruProfileDefaultImagesContainer.getWidget(widgetIndex);
		gooruImagesView.profileGooruDefaultImage.setStyleName(GooruCBundle.INSTANCE.css().profileImageActive());
		if(selectedWidgetIndex!=-1){
			GooruImagesView gooruImagesView1=(GooruImagesView)gooruProfileDefaultImagesContainer.getWidget(selectedWidgetIndex);
			gooruImagesView1.profileGooruDefaultImage.setStyleName(GooruCBundle.INSTANCE.css().profileImageContainer());
		}
		this.selectedWidgetIndex=widgetIndex;
	}
	/**
	 * @function resetProfileImageSelected 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : This method is used to reset the profile image selected one.
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private void resetProfileImageSelected(){
		this.selectedWidgetIndex=-1;
		int widgetsCount=gooruProfileDefaultImagesContainer.getWidgetCount();
		for(int widgetIndex=0;widgetsCount>widgetIndex;widgetIndex++){
			GooruImagesView gooruImagesView=(GooruImagesView)gooruProfileDefaultImagesContainer.getWidget(widgetIndex);
			gooruImagesView.profileGooruDefaultImage.setStyleName(GooruCBundle.INSTANCE.css().profileImageContainer());
		}
	}
	
	/**
	 * This inner class is used to set the focus handler.
	 */
	private class OnTextFocus implements FocusHandler {
		@Override
		public void onFocus(FocusEvent event) {
			imageWebUploadUrlTxtBox.removeStyleName(GooruCBundle.INSTANCE.css().textboxUrlError());
			urlValidation.setVisible(false);
		}
	}
	/**
	 * This method is used to set the display based on the age.
	 */
	public void showUploadTypeWidgets(boolean isUserUnder13){
		this.isUserUnder13=isUserUnder13;
		if(isUserUnder13){
			uploadGooruImages.getElement().getStyle().setDisplay(Display.BLOCK);
			imageUploadOnComputerLbl.getElement().getStyle().setDisplay(Display.NONE);
			imageUploadOnWebLbl.getElement().getStyle().setDisplay(Display.NONE);
			uploadGooruImages.setStyleName(GooruCBundle.INSTANCE.css().uploadActive());
			imageUploadOnComputerLbl.setStyleName(GooruCBundle.INSTANCE.css().uploadClose());
			imageUploadOnWebLbl.setStyleName(GooruCBundle.INSTANCE.css().uploadClose());
			uploadGooruImagesContainer.getElement().getStyle().setDisplay(Display.BLOCK);
			imageUploadOnUrlFloPanel.getElement().getStyle().setDisplay(Display.NONE);
			imageUploadOnWebFloPanel.getElement().getStyle().setDisplay(Display.NONE);
		}else{
			uploadGooruImages.getElement().getStyle().setDisplay(Display.BLOCK);
		}
	}

	/**
	 * Upload image from local machine to enable or disable tab.
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("imageUploadOnComputerLbl")
	public void imageUploadOnComputer(ClickEvent clickEvent) {
			imageUploadOnComputerLbl.setStyleName(GooruCBundle.INSTANCE.css().uploadActive());
			uploadGooruImages.setStyleName(GooruCBundle.INSTANCE.css().uploadClose());
			imageUploadOnWebLbl.setStyleName(GooruCBundle.INSTANCE.css().uploadClose());
			imageUploadOnUrlFloPanel.getElement().getStyle().setDisplay(Display.NONE);
			uploadGooruImagesContainer.getElement().getStyle().setDisplay(Display.NONE);
			imageUploadOnWebFloPanel.getElement().getStyle().setDisplay(Display.BLOCK);
	}

	/**
	 * Upload image from web to enable or disable tab.
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("imageUploadOnWebLbl")
	public void imageUploadOnWeb(ClickEvent clickEvent) {
		if(isUserUnder13){
			uploadGooruImages.getElement().getStyle().setDisplay(Display.BLOCK);
			imageUploadOnComputerLbl.getElement().getStyle().setDisplay(Display.NONE);
			imageUploadOnWebLbl.getElement().getStyle().setDisplay(Display.NONE);
			uploadGooruImages.setStyleName(GooruCBundle.INSTANCE.css().uploadActive());
			imageUploadOnComputerLbl.setStyleName(GooruCBundle.INSTANCE.css().uploadClose());
			imageUploadOnWebLbl.setStyleName(GooruCBundle.INSTANCE.css().uploadClose());
			uploadGooruImagesContainer.getElement().getStyle().setDisplay(Display.BLOCK);
			imageUploadOnUrlFloPanel.getElement().getStyle().setDisplay(Display.NONE);
			imageUploadOnWebFloPanel.getElement().getStyle().setDisplay(Display.NONE);
		}else{
			imageUploadOnWebLbl.setStyleName(GooruCBundle.INSTANCE.css().uploadActive());
			uploadGooruImages.setStyleName(GooruCBundle.INSTANCE.css().uploadClose());
			imageUploadOnComputerLbl.setStyleName(GooruCBundle.INSTANCE.css().uploadClose());
			imageUploadOnUrlFloPanel.getElement().getStyle().setDisplay(Display.BLOCK);
			imageUploadOnWebFloPanel.getElement().getStyle().setDisplay(Display.NONE);
			uploadGooruImagesContainer.getElement().getStyle().setDisplay(Display.NONE);
		}
	}
	/**
	 * @function uploadImagesFromGooru 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : This will hanle the click event on the uplaod gooru images.
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("uploadGooruImages")
	public void uploadImagesFromGooru(ClickEvent clickEvent){
		uploadGooruImages.setStyleName(GooruCBundle.INSTANCE.css().uploadActive());
		imageUploadOnComputerLbl.setStyleName(GooruCBundle.INSTANCE.css().uploadClose());
		imageUploadOnWebLbl.setStyleName(GooruCBundle.INSTANCE.css().uploadClose());
		uploadGooruImagesContainer.getElement().getStyle().setDisplay(Display.BLOCK);
		imageUploadOnUrlFloPanel.getElement().getStyle().setDisplay(Display.NONE);
		imageUploadOnWebFloPanel.getElement().getStyle().setDisplay(Display.NONE);
	}
	
	/**
	 * Hide {@link AppPopUp}
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("onSystemCancelBtn")
	public void onSystemCancelClick(ClickEvent clickEvent) {
		appPopUp.hide();
		resetImageUploadWidget();
		if(isEdit){
			Window.enableScrolling(false);
		}else{
			Window.enableScrolling(true);
			AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		}
		
	}
	/**
	 * @function cancelOnGooruImages 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : This will handle the click event on the cancel and upload buttons.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("cancelButtonOnUploadGooruImages")
	public void cancelOnGooruImages(ClickEvent event){
		appPopUp.hide();
		resetImageUploadWidget();
		if(isEdit){
			Window.enableScrolling(false);
		}else{
			Window.enableScrolling(true);
			AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		}
	}

	

	/**
	 * Hide {@link AppPopUp}
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("onWebCancelBtn")
	public void onWebCancelClick(ClickEvent clickEvent) {
		appPopUp.hide();
		resetImageUploadWidget();
	}

	/**
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("uploadImageButtonOnWeb")
	public void uploadImageButtonOnWeb(ClickEvent clickEvent) {
		if (hasValidateData()) {
			glasspanelLoadingImage(true);
			getUiHandlers().imageWebUpload(imageWebUploadUrlTxtBox.getText());
		}
	}
	/**
	 * @function uploadGooruDefaultImage 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : This will handle the click event on the ok and upload gooru images.
	 * 
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("okButtonOnUploadGooruImages")
	public void uploadGooruDefaultImage(ClickEvent clickEvent){
		if(this.selectedWidgetIndex!=-1){
			glasspanelLoadingImage(true);
			GooruImagesView gooruImagesView=(GooruImagesView)gooruProfileDefaultImagesContainer.getWidget(selectedWidgetIndex);
			String url=gooruImagesView.gooruDefaultImage.getUrl();
			getUiHandlers().uploadGooruDefaultImage(url);
			//getUiHandlers().uploadGooruDefaultImage("http://devrepo.goorulearning.org/qalive/f000/0237/5845/63daa896-aaa4-43f2-a6fb-c67e15514e00-280x215.png");
		}
	}
	/**
	 * Validate web image url
	 * @return true if upload image url is valid else false 
	 */
	private boolean hasValidateData() {
		boolean isValid = true;
		String url = imageWebUploadUrlTxtBox.getText();
		try {
			RegExp reg = RegExp.compile(IMAGE_UPLOAD_URL_PATTERN, "gi");
			
			if (url == null || (url != null && url.isEmpty())) {
				urlValidation.setText(GL0080);
				imageWebUploadUrlTxtBox.addStyleName(GooruCBundle.INSTANCE.css().textboxUrlError());
				urlValidation.setVisible(true);
				return isValid = false;
			}
			if(url != null && !reg.test(url)){
				new AlertContentUc(GL0060,GL0059);
				return isValid = false;
			}
		}catch (Exception e) {

		}
		return isValid;
	}
	
	/**
	 * validate image which uploaded from local machine
	 * @return true if upload image file is valid else false 
	 */
	public boolean hasValidateImage(){
		boolean isValid = true;
		String uploadImageName = fileUpload.getFilename();
		try {
			RegExp reg = RegExp.compile(IMAGE_UPLOAD_FILE_PATTERN, "gi");
			if(uploadImageName != null && !reg.test(uploadImageName)){
				new AlertContentUc(GL0060,GL0059);
				return isValid = false;
			}
		}catch (Exception e) {
			
		}
		return isValid;
	}
	/**
	 * This method is used to set the upload image.
	 */
	@Override
	public void setImageUpload(final MediaUploadDo mediaUploadDo) {
		imageCropPopup.clear();
		imagUploadFloPanel.setVisible(false);
		appPopUp.hide();
		if (mediaUploadDo != null && mediaUploadDo.getStatusCode() == 200) {
			ImageCropView imageCropView = new ImageCropView() {
				@Override
				public void onCancelCrop() {
					resetImageUploadWidget();
					appPopUp.hide();
					imageCropPopup.hide();
//					AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
				}

				@Override
				public void onBackToUpload() {
					resetImageUploadWidget();
					imageCropPopup.clear();
					imageCropPopup.hide();
					appPopUp.show();
//					AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
				}

				@Override
				public void onCrop() {
					glasspanelLoadingImage(true);
					getUiHandlers().cropImage(mediaUploadDo.getName(), getSelectionHeight(), getSelectionWidth(), getSelectionXCoordinate(), getSelectionYCoordinate(),mediaUploadDo.getUrl());
				}
				@Override
				public void onLoad(){
					super.onLoad();
					imageCropPopup.center();
				}
			};
			imageCropView.cropImage(mediaUploadDo.getUrl(),aspectRatio);
			imageCropView.addCanvasLoadHandler(new LoadHandler() {			
				@Override
				public void onLoad(LoadEvent event) {
					
					imageCropPopup.center();
				}
			});
			//imageCropFloPanel.add(imageCropView);
//			AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, false));
			imageCropPopup.clear();
			imageCropPopup.add(imageCropView);
			imageCropPopup.show();
//			Window.enableScrolling(true);
		} else {
			appPopUp.hide();
			imageCropPopup.hide();
			resetImageUploadWidget();
			new AlertContentUc("Oops", mediaUploadDo != null && mediaUploadDo.getImageValidationMsg() != null ? mediaUploadDo.getImageValidationMsg() : "Something went wrong, please try again with some other cover image.");
		}
	}
	/**
	 * This will handle the form event for uploading.
	 */
	@Override
	public void handelFormEvent() {
		fileUpload.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				
				if(hasValidateImage()){
					glasspanelLoadingImage(true);
					fileuploadForm.setAction(AppClientFactory.getLoggedInUser().getSettings().getRestEndPoint() + StringUtil.generateMessage(IMAGE_UPLOAD_URL, AppClientFactory.getLoggedInUser().getToken(), fileUpload.getFilename()));
					fileuploadForm.submit();
				} else {
					new AlertContentUc(GL0060,GL0059);
				}
			}
		});

		fileuploadForm.addFormHandler(new FormHandler() {
			public void onSubmitComplete(FormSubmitCompleteEvent event) {
				glasspanelLoadingImage(false);
				getUiHandlers().imageFileUpload(event.getResults());
			}

			@Override
			public void onSubmit(FormSubmitEvent event) {

			}
		});

	}
	/**
	 * This will close the upload image popup.
	 */
	@Override
	public void closeImageUploadWidget() {
		appPopUp.hide();
	}
	/**
	 * This will enable the glass panel in the back ground of the popup.
	 */
	@Override
	public void glasspanelLoadingImage(boolean state) {
		glassPanelWithLoadingUc.setVisible(state);
	}

	@Override			
	public void resetImageUploadWidget() {
		imageCropFloPanel.clear();
		imagUploadFloPanel.setVisible(true);
		imageUploadOnWeb(null);
		imageWebUploadUrlTxtBox.setText("");
		fileUpload.getElement().getPropertyString("");
		fileUpload.getElement().setPropertyString("value","");
		glasspanelLoadingImage(false);
		resetProfileImageSelected();
		imageCropPopup.clear();
		imageCropPopup.hide();
		if(isEdit){
			
		}else{
		  AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		}
	}
	
	
	/**
	 * To get the upload file size from client end
	 * @return it will return the upload file size in mb
	 */
	 
	public final native String getFileNameSize() /*-{
 
var fileSize;
      if ($wnd.$.browser.msie) 
         {
   
     	 var objFSO = new ActiveXObject("Scripting.FileSystemObject");
        var sPath =   $wnd.$("#fileUpload")[0].value;
        var objFile = objFSO.getFile(sPath);
         var iSize = objFile.size;
        fileSize = iSize/ 1048576;
    
        }
    
     
     
        else 
        {
  
       fileSize =  $wnd.$("#fileUpload")[0].files[0].size ;//size in kb
       
        fileSize = fileSize / 1048576; //size in mb 
 
         }
 
        
     
        
           return fileSize.toString();
   
                 
    
  }-*/;
	/**
	 * This method is used to set the aspect ratio
	 */
	public void setAspectRatio(float aspectRatio){
		this.aspectRatio=aspectRatio;
	}
	/**
	 * This method is used to set the boolean value is the user editing the form question or not.
	 */
	@Override
	public void isFromEditQuestion(boolean isEdit) {
		this.isEdit=isEdit;
	}
	

}
