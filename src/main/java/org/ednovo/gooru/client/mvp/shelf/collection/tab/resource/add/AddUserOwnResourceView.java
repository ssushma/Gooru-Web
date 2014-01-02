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
package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.faq.CopyRightPolicyVc;
import org.ednovo.gooru.client.mvp.faq.TermsAndPolicyVc;
import org.ednovo.gooru.client.mvp.faq.TermsOfUse;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.CollectionEditResourceCBundle;
import org.ednovo.gooru.client.uc.BlueButtonUc;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormHandler;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormSubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormSubmitEvent;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public abstract class AddUserOwnResourceView extends Composite {
	public interface AddUserOwnResourceViewUiBinder extends UiBinder<Widget,AddUserOwnResourceView> {
		
	}
	public static AddUserOwnResourceViewUiBinder uiBinder = GWT.create(AddUserOwnResourceViewUiBinder.class);
	
	
	@UiField
	public Button cancelResourcePopupBtnLbl,uploadImageLbl,browseResourceBtn;
	@UiField
	public BlueButtonUc addResourceBtnLbl;

	@UiField
	Label resourceContentChkLbl, mandatoryTitleLbl,descCharcterLimit;
	
	@UiField
	HTMLEventPanel lblContentRights;


	@UiField
	public TextBox resourcePathTextBox, titleTextBox;

	@UiField
	public TextArea descriptionTxtAera;


	@UiField
	public Image setThumbnailImage;
	// Drop down for Resource Type//
	@UiField
	HTMLPanel panelContentRights,resourceTitleContainer,filePathContainer;

	@UiField
	public HTMLPanel loadingPanel,imageContainer;

	@UiField
	HTMLPanel categorypanel, handout,lesson,slide,rightsContent,
			textbook;

	@UiField
	HTMLPanel resourceTypePanel, resourceDescriptionContainer,panelAction;

	@UiField
	Label resoureDropDownLbl, resourceCategoryLabel,rightsLbl;
	
	@UiField
	Anchor copyRightAnr;
	
	@UiField
	Anchor termsAndPolicyAnr,privacyAnr;
	
	@UiField
	Anchor commuGuideLinesAnr;
	
	@UiField
	FormPanel fileuploadForm;
	
	
	@UiField
	FileUpload chooseResourceBtn;
	
	@UiField
	CheckBox rightsChkBox;

	@UiField Label lblAdding;
	
	/** 
	 * This method is to get the lblAdding
	 */
	public Label getLblAdding() {
		return lblAdding;
	}

	/** 
	 * This method is to set the lblAdding
	 */
	public void setLblAdding(Label lblAdding) {
		this.lblAdding = lblAdding;
	}
	public boolean resoureDropDownLblOpen = false;
	
	private boolean isValidImageSize=true;
	
	String originalFileName=null;
	
	private CopyRightPolicyVc copyRightPolicy;
	
	private TermsAndPolicyVc termsAndPolicyVc;
	private TermsOfUse termsOfUse;
	
	String thumbnailUrlStr = null;
	
	String filePath,resourceTitle,resourceDesc,resourceCategory;
	
	private static final String RESOURCE_UPLOAD_FILE_PATTERN = "([^\\s]+([^?#]*\\.(?:jpg|jpeg|pdf))$)";
	private static final String RESOURCE_FILE_SUPPORT_MSG = "Oops! We only support PDF and JPG files.";
	
	private static final String IMAGE_UPLOAD_URL = "/v2/media?sessionToken={0}";
	
	CollectionDo collectionDo;
	
	/**
	 *  Class constructor
	 *  
	 * @param collectionDo instance of {@link CollectionDo}
	 */
	
	public AddUserOwnResourceView(CollectionDo collectionDo){ 
		this.collectionDo = collectionDo;
		initWidget(uiBinder.createAndBindUi(this));
		CollectionEditResourceCBundle.INSTANCE.css().ensureInjected();
		cancelResourcePopupBtnLbl.addClickHandler(new CloseClickHandler());
		addResourceBtnLbl.addClickHandler(new AddClickHandler());
		uploadImageLbl.addClickHandler(new OnEditImageClick());
		browseResourceBtn.addClickHandler(new OnBrowseBtnClick());
		rightsChkBox.addClickHandler(new OnRightsChecked());
		cancelResourcePopupBtnLbl.getElement().setId("btnCancel");
		rightsChkBox.getElement().setId("chkRights");
		uploadImageLbl.getElement().setId("btnUploadImage");
		addResourceBtnLbl.getElement().setId("btnAdd");
		resourcePathTextBox.getElement().setId("tbUrl");
		titleTextBox.getElement().setId("tbTitle");	
		descriptionTxtAera.getElement().setId("taDescription");
		descriptionTxtAera.getElement().setAttribute("placeholder", MessageProperties.GL0359);
		resourcePathTextBox.addKeyUpHandler(new ResourcePathKeyUpHandler());
		titleTextBox.addKeyUpHandler(new TitleKeyUpHandler());
		descriptionTxtAera.addKeyUpHandler(new DescriptionKeyUpHandler());
		titleTextBox.getElement().setAttribute("maxlength", "50");
		descriptionTxtAera.getElement().setAttribute("maxlength", "300");
		resourceCategoryLabel.setText(MessageProperties.GL0360);
		resourceContentChkLbl.setVisible(false);
		mandatoryTitleLbl.setVisible(false);
		descCharcterLimit.setVisible(false);
		setThumbnailImage.setVisible(false);
		resourceTypePanel.setVisible(false);
		loadingPanel.setVisible(false);
		panelContentRights.setVisible(false);
		imageContainer.getElement().getStyle().setDisplay(Display.NONE);
		rightsLbl.getElement().getStyle().setColor("black");
		chooseResourceBtn.getElement().setId("fileUpload1");
		clearFields();
		handelFormEvent();
		

		copyRightAnr.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.enableScrolling(false);
				copyRightPolicy = new  CopyRightPolicyVc() {
					@Override
					public void openParentPopup() {
						Window.enableScrolling(false);
						AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98,false));
					}
				};
				
				copyRightPolicy.show();
				copyRightPolicy.setSize("902px", "300px");
				copyRightPolicy.center();
				copyRightPolicy.getElement().getStyle().setZIndex(999);
				
			}
		});
		
		termsAndPolicyAnr.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.enableScrolling(false);
				termsOfUse = new TermsOfUse() {
					@Override
					public void openParentPopup() {
						Window.enableScrolling(false);
						AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98,false));
					}
				};
				
				termsOfUse.show();
				termsOfUse.setSize("902px", "300px");
				termsOfUse.center();
				termsOfUse.getElement().getStyle().setZIndex(999);
			}
			
		});
		privacyAnr.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.enableScrolling(false);
				termsAndPolicyVc = new TermsAndPolicyVc(false) {
					@Override
					public void openParentPopup() {
						Window.enableScrolling(false);
						AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98,false));
					}
				};
				
				termsAndPolicyVc.show();
				termsAndPolicyVc.setSize("902px", "300px");
				termsAndPolicyVc.center();
				termsAndPolicyVc.getElement().getStyle().setZIndex(999);
			}
			
		});
		commuGuideLinesAnr.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Window.open("http://support.goorulearning.org/entries/24471116-Gooru-Community-Guidelines","_blank",""); 
			}
		});
		
		
		
		resourceCategoryLabel.setText("Handout");
		categorypanel.setStyleName(handout.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
		
		
		lblAdding.getElement().getStyle().setDisplay(Display.NONE);
		panelAction.getElement().getStyle().setDisplay(Display.BLOCK);
	}
	
	/**
	 * On click of this button can browse for file from local computer.
	 * 
	 * @param event is a instance of {@link ClickEvent}
	 */
	
	@UiHandler("chooseResourceBtn")
	public void onChangeFileUploadBtn(ChangeEvent event){
		if (!"".equalsIgnoreCase(chooseResourceBtn.getFilename())) {
			String size=getFileNameSize();
			double sizeOfImage=Double.parseDouble(size);
			if(sizeOfImage>5){
				isValidImageSize=false;
				resourceContentChkLbl.setText("Oops! We only support files under 5MB.");
				resourceContentChkLbl.setVisible(true);
				fileuploadForm.reset();
				if(!resourcePathTextBox.getText().equalsIgnoreCase("")){
					resourcePathTextBox.setText("");
				}
			}
		}
	}
	
	private void handelFormEvent() {
		chooseResourceBtn.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				filePathContainer.setStyleName(CollectionEditResourceCBundle.INSTANCE.css().ownResourceFormInputControl());
				 if(hasValidateResource()){
					 isValidImageSize=true;
					 resourceContentChkLbl.setVisible(false);
					 resourcePathTextBox.setText(chooseResourceBtn.getFilename().trim());
				 }
				 else{
					 if(!chooseResourceBtn.getFilename().trim().equalsIgnoreCase("")){
						 resourceContentChkLbl.setVisible(true);
						 resourceContentChkLbl.setText(RESOURCE_FILE_SUPPORT_MSG);
					 }
					 
				 }
				
			}
		});
		
	}

	

	private class CloseClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			clearFields();
			hidePopup();
		}
	}
	public abstract void hidePopup();
	
	public void clearFields() {
		resourcePathTextBox.setText("");
		titleTextBox.setText("");
		descriptionTxtAera.setText("");
		setThumbnailImage.setUrl("");
		resourceCategoryLabel.setText("Choose a resource category");
		categorypanel.setStyleName("");
		mandatoryTitleLbl.setVisible(false);
		resourceContentChkLbl.setVisible(false);
		descCharcterLimit.setVisible(false);
		setVisible(true);
	}
	
	private class AddClickHandler implements ClickHandler {
		@SuppressWarnings("deprecation")
		@Override
		public void onClick(ClickEvent event) {
			
			lblAdding.getElement().getStyle().setDisplay(Display.BLOCK);
			panelAction.getElement().getStyle().setDisplay(Display.NONE);
			
			filePath = resourcePathTextBox.getText().trim();
			resourceTitle = titleTextBox.getText().trim();
			resourceDesc = descriptionTxtAera.getText().trim();
			resourceCategory = resourceCategoryLabel.getText();
			boolean isValidate = true;
			if(filePath==null || filePath.equals("")){
				 isValidate = false;
				 filePathContainer.setStyleName(CollectionEditResourceCBundle.INSTANCE.css().ownResourceFormInputControlForErrors());
				 resourceContentChkLbl.setText("Please add a file.");
				 resourceContentChkLbl.setVisible(true);
			}
			if(resourceTitle==null || resourceTitle.equals("")){
				isValidate = false;
				resourceTitleContainer.setStyleName(CollectionEditResourceCBundle.INSTANCE.css().myFolderCollectionFormInputControlForErrors());
				mandatoryTitleLbl.setText("Please add a title.");
				mandatoryTitleLbl.setVisible(true);
				
			}
			if(resourceDesc==null || resourceDesc.equals("")){
				isValidate = false;
				resourceDescriptionContainer.setStyleName(CollectionEditResourceCBundle.INSTANCE.css().myFolderCollectionFormInputControlForErrors());
				resourceDescriptionContainer.addStyleName(CollectionEditResourceCBundle.INSTANCE.css().myFolderCollectionFormTextarea());
			
				descCharcterLimit.setText("Please add a description.");
				descCharcterLimit.setVisible(true);
			}
			if(resourceCategory==null || resourceCategory.equals("-1") || resourceCategory.equalsIgnoreCase("Choose a resource category") ){ 
				isValidate = false;
			}
			if(!rightsChkBox.getValue()){
				rightsLbl.getElement().getStyle().setColor("orange");
				isValidate = false;
			}
			if(isValidate){
				fileuploadForm.setAction(AppClientFactory.getLoggedInUser().getSettings().getRestEndPoint() + StringUtil.generateMessage(IMAGE_UPLOAD_URL, AppClientFactory.getLoggedInUser().getToken(), chooseResourceBtn.getFilename()));
				fileuploadForm.addFormHandler(new FormHandler() {
					
					public void onSubmitComplete(FormSubmitCompleteEvent event) {
						if(isValidImageSize){
							if(collectionDo.getSharing().equalsIgnoreCase("public")){
								parseUploadFileDetails(event.getResults(),true);
							}
							else{
								parseUploadFileDetails(event.getResults(),false);
							}
						}
					}
					
					@Override
					public void onSubmit(FormSubmitEvent event) {
					}
				});
				
				fileuploadForm.submit();
//				 String str ="{\"deleteType\":\"DELETE\",\"deleteUrl\":\"media/0deeb890-8a4b-468e-87c0-5615d69e856e.jpg\",\"imageValidationMsg\":null,\"name\":\"07d5e417-0c0d-418a-b9fc-d1b6ec4ef557.pdf\",\"originalFilename\":\"gwtb_html5_a_web_develops_dream.pdf\",\"size\":462358,\"statusCode\":200,\"uploadImageSource\":\"local\",\"url\":\"http://devrepo.goorulearning.org/qalive/uploaded-media/0deeb890-8a4b-468e-87c0-5615d69e856e.jpg\"}";
//                 parseUploadFileDetails(str,true);
				
			}else{
				lblAdding.getElement().getStyle().setDisplay(Display.NONE);
				panelAction.getElement().getStyle().setDisplay(Display.BLOCK);
			}
		}

		protected void parseUploadFileDetails(String jsonString,boolean showPreview) { 
			if(jsonString!=null){
				JSONValue jsonParseValue=JSONParser.parseStrict(jsonString);
				JSONObject jsonObject=jsonParseValue.isObject();
				JSONValue jsonMediaFileValue=jsonObject.get("name");
				String mediaFileName=jsonMediaFileValue.isString().toString().replaceAll("^\"|\"$", "");
				JSONValue jsonOriginalFileValue=jsonObject.get("originalFilename");
				String originalFileName=jsonOriginalFileValue.isString().toString().replaceAll("^\"|\"$", "");
				if(showPreview){
					showResourcePreview(filePath,mediaFileName,originalFileName,resourceTitle,resourceDesc,resourceCategory);
				}else{
					addUserResource(filePath,mediaFileName,originalFileName,resourceTitle,resourceDesc,resourceCategory);
				}
				
			}
		}
	}
	

	public abstract void showResourcePreview(String filePath, String mediaFileName,String originalFileName,String resourceTitle, String resourceDesc, String resourceCategory);
	public abstract void addUserResource(String filePath,String mediaFileName,String originalFileName, String resourceTitle, String resourceDesc, String resourceCategory);
	
	
	private class OnEditImageClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			resourceImageUpload();
		}
	}
	
	private class OnBrowseBtnClick implements ClickHandler { 
		@Override
		public void onClick(ClickEvent event) {
//			resourceUpload();
		}
	}
	
	private class OnRightsChecked implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			if(rightsChkBox.getValue()){
				rightsLbl.getElement().getStyle().setColor("black");
			}
			else{
				rightsLbl.getElement().getStyle().setColor("orange");
			}
			
		}
	}
	
	public abstract void resourceImageUpload();
	public abstract void resourceUpload();
	
	private class ResourcePathKeyUpHandler implements KeyUpHandler {
		public void onKeyUp(KeyUpEvent event) {
			filePathContainer.setStyleName(CollectionEditResourceCBundle.INSTANCE.css().ownResourceFormInputControl());
			resourceContentChkLbl.setVisible(false);
		}
	}
	
	private class TitleKeyUpHandler implements KeyUpHandler {

		public void onKeyUp(KeyUpEvent event) {
			mandatoryTitleLbl.setVisible(false);
			resourceTitleContainer.setStyleName(CollectionEditResourceCBundle.INSTANCE.css().myFolderCollectionFormInputControl());
			if (titleTextBox.getText().length() >= 50) {
				mandatoryTitleLbl.setText("Character limit reached.");
				mandatoryTitleLbl.setVisible(true);
			}
		}
	}
	
	
	private class DescriptionKeyUpHandler implements KeyUpHandler {
		public void onKeyUp(KeyUpEvent event) {
			descCharcterLimit.setVisible(false);
			resourceDescriptionContainer.setStyleName(CollectionEditResourceCBundle.INSTANCE.css().myFolderCollectionFormInputControl());
			resourceDescriptionContainer.addStyleName(CollectionEditResourceCBundle.INSTANCE.css().myFolderCollectionFormTextarea());
			if (descriptionTxtAera.getText().length() >= 300) {
//				descriptionTxtAera.setText(descriptionTxtAera.getText().trim().substring(0, 300));
				descCharcterLimit.setText("Character limit reached.");
				descCharcterLimit.setVisible(true);
			}

		}
	}
	
	

	@UiHandler("slideResourcePanel")
	void slideResourcePanel(ClickEvent event) {
		resourceCategoryLabel.setText("Slide");
		categorypanel.setStyleName(slide.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
	}

	@UiHandler("handoutResourcePanel")
	void handoutResourcePanel(ClickEvent event) {
		resourceCategoryLabel.setText("Handout");
		categorypanel.setStyleName(handout.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
	}

	@UiHandler("textbookResourcePanel")
	void textbookResourcePanel(ClickEvent event) {
		resourceCategoryLabel.setText("Textbook");
		categorypanel.setStyleName(textbook.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
	}

	@UiHandler("lessonResourcePanel")
	void lessonResourcePanel(ClickEvent event) {
		resourceCategoryLabel.setText("Lesson");
		categorypanel.setStyleName(lesson.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
	}


	@UiHandler("resoureDropDownLbl")
	public void dropDownClick(ClickEvent event) {
		if (resoureDropDownLblOpen == false) {
			resourceTypePanel.setVisible(true);
			resoureDropDownLblOpen = true;

		} else {
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen = false;
		}

	}
	
	@UiHandler("lblContentRights")
	public void onMouseOver(MouseOverEvent event){
		panelContentRights.setVisible(true);
	}
	
	@UiHandler("lblContentRights")
	public void onMouseOut(MouseOutEvent event){
		panelContentRights.setVisible(false);
	}
	
	public boolean hasValidateResource(){
		boolean isValid = true;
		String uploadResourceName = chooseResourceBtn.getFilename();
		try {
			RegExp reg = RegExp.compile(RESOURCE_UPLOAD_FILE_PATTERN, "gi");
			if(uploadResourceName != null && !reg.test(uploadResourceName)){
				return isValid = false;
			}
		}catch (Exception e) {
			
		}
		return isValid;
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
			var sPath =   $wnd.$("#fileUpload1")[0].value;
			var objFile = objFSO.getFile(sPath);
			var iSize = objFile.size;
			fileSize = iSize/ 1048576;
		}
		else 
		{
			fileSize =  $wnd.$("#fileUpload1")[0].files[0].size ;//size in kb
			fileSize = fileSize / 1048576; //size in mb 
		}
		return fileSize.toString();
	}-*/;
	

}
