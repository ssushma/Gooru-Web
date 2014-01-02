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
package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.faq.CopyRightPolicyVc;
import org.ednovo.gooru.client.mvp.faq.TermsAndPolicyVc;
import org.ednovo.gooru.client.mvp.faq.TermsOfUse;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.event.GetEditPageHeightEvent;
import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.ResourceMetaInfoDo;
import org.ednovo.gooru.shared.util.ResourceImageUtil;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.Unit;
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
/**
 * 
 * @fileName : EditUserOwnResourcePopupVc.java
 *
 * @description : This class is used to display edit user own resource popup.
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public abstract class EditUserOwnResourcePopupVc extends AppPopUp  {
	CollectionItemDo collectionItemDo;

	@UiField
	public Button addResourceBtn,changeFileBtn,browseResourceBtn;
	
	@UiField
	FormPanel fileuploadForm;
	
	@UiField
	HTMLPanel uploadContainer,uploadName,defaultFileTxtContainer,panelContentRights;
	

	@UiField
	Label resourceContentChkLbl, mandatoryTitleLbl,uploadImageLbl,fileTextLbl,rightsLbl;

	@UiField
	Label mandatoryCategoryLbl/*urlTextLbl*/;

	@UiField
	public TextBox titleTextBox,resourcePathTextBox;
	
	@UiField
	FileUpload chooseResourceBtn;

	@UiField
	public TextArea descriptionTxtAera;
	
	@UiField Label lblAdding;
	
	@UiField HTMLEventPanel lblContentRights;

	@UiField
	Image setThumbnailImage;
	
	@UiField
	Label descCharcterLimit;
	@UiField
	CheckBox rightsChkBox;
	@UiField Label resourceCategoryLabel;
	@UiField HTMLPanel categorypanel,slide,handout,textbook,lesson,resourceTypePanel,panelAction;
	@UiField Anchor copyRightAnr;
	@UiField Anchor termsAndPolicyAnr,privacyAnr;
	@UiField Anchor commuGuideLinesAnr;
	private CopyRightPolicyVc copyRightPolicy;
	private TermsAndPolicyVc termsAndPolicyVc;
	private TermsOfUse termsOfUse;
	ResourceMetaInfoDo resMetaInfoDo = null;

	boolean isValidImageSize=true;
	
	private String thumbnailUrlStr = null;
	
	String fileNameWithOutRespUrl = null;
	
	public boolean resoureDropDownLblOpen = false;
	
	private static final String DEFULT_IMAGE_PREFIX = "images/default-";

	private static final String PNG = ".png";
	public boolean fileChanged=false;
	String mediaFileName=null;
	String originalFileName=null;
	String titleStr ;
	String categoryStr ;
	String filePath;
	
	private static final String RESOURCE_UPLOAD_FILE_PATTERN = "([^\\s]+([^?#]*\\.(?:jpg|jpeg|pdf))$)";
	private static final String RESOURCE_FILE_SUPPORT_MSG = "Oops! We only support PDF and JPG files.";
	private static final String IMAGE_UPLOAD_URL = "/v2/media?sessionToken={0}";
	
	private static EditUserOwnResourcePopupVcUiBinder uiBinder = GWT.create(EditUserOwnResourcePopupVcUiBinder.class);
	
	interface EditUserOwnResourcePopupVcUiBinder extends UiBinder<Widget, EditUserOwnResourcePopupVc> {
	}
	

	/**
	 * Class constructor.
	 * @param collectionItemDo
	 */
	public EditUserOwnResourcePopupVc(CollectionItemDo collectionItemDo) {
		
		super();
		this.collectionItemDo = collectionItemDo;
		setContent("Edit Resource", uiBinder.createAndBindUi(this));

		addResourceBtn.addClickHandler(new AddClickHandler());
		addResourceBtn.getElement().getStyle().setFloat(Float.LEFT);
		uploadImageLbl.addClickHandler(new OnEditImageClick());
		
		changeFileBtn.addClickHandler(new ChangeFileBtnClick());

		titleTextBox.addKeyUpHandler(new TitleKeyUpHandler());
		descriptionTxtAera.addKeyUpHandler(new DescriptionKeyUpHandler());
		resourcePathTextBox.addKeyUpHandler(new ResourcePathKeyUpHandler());
		titleTextBox.getElement().setAttribute("maxlength", "50");
		descriptionTxtAera.getElement().setAttribute("maxlength", "300");
		resourceContentChkLbl.setVisible(false);
		mandatoryTitleLbl.setVisible(false);
		mandatoryCategoryLbl.setVisible(false);
		descCharcterLimit.setVisible(false);
		setThumbnailImage.setVisible(true);
		resourceTypePanel.setVisible(false);
		chooseResourceBtn.getElement().setId("uploadFile");
		panelContentRights.setVisible(false);
		rightsChkBox.addClickHandler(new rightsChecked());
		rightsChkBox.getElement().setId("chkRights");

        setModal(true);
		Window.enableScrolling(false);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, false));

		
		displayResourceInfo();
		show();
		center();
		AppClientFactory.fireEvent(new GetEditPageHeightEvent(this, false));
		getResourceMetaInfo(collectionItemDo.getResource().getUrl());
		handelFormEvent();
		
		lblAdding.getElement().getStyle().setDisplay(Display.NONE);
		panelAction.getElement().getStyle().setDisplay(Display.BLOCK);
		
		defaultFileTxtContainer.getElement().getStyle().setDisplay(Display.BLOCK);
		uploadContainer.getElement().getStyle().setDisplay(Display.NONE);
		uploadName.getElement().getStyle().setDisplay(Display.NONE);
		fileTextLbl.setText("Your file is uploaded.");
		browseResourceBtn.getElement().getStyle().setMarginRight(-94, Unit.PX);
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
	}
	/**
	 * This method will call at the time of loading and it will set the rich text box.
	 */
	public void onLoad(){
		super.onLoad();
		Scheduler.get().scheduleDeferred(new ScheduledCommand(){

			@Override
			public void execute() {
				setResourceDescription();
			}
        });
	}
	/**
	 * @function cancelPopUp 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This will handle the click event on cancel button of resoruce popup.
	 * 
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("cancelResourcePopupBtnLbl")
	public void cancelPopUp(ClickEvent clickEvent) {
		AppClientFactory.fireEvent(new GetEditPageHeightEvent(this, true));

		Window.enableScrolling(true);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));

		hide();
	}
	/**
	 * @function getResourceMetaInfo 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This method is used to get resource meta information.
	 * 
	 * 
	 * @parm(s) : @param url
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void getResourceMetaInfo(String url) {
		AppClientFactory
				.getInjector()
				.getResourceService()
				.getResourceMetaInfo(url,
						new SimpleAsyncCallback<ResourceMetaInfoDo>() {

							@Override
							public void onSuccess(ResourceMetaInfoDo result) {
								setData(result);
							}
						});
	}
	/**
	 * 
	 * @function setData 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This method is used to set data.
	 * 
	 * 
	 * @parm(s) : @param result
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setData(ResourceMetaInfoDo result) {
		setResMetaInfo(result);
		updateUi();
	}
	/**
	 * This inner class will handle the click event on rights.
	 */
	 private class rightsChecked implements ClickHandler {
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
	 /**
		 * This method is used to set the resource meta information.
		 */
	private void setResMetaInfo(ResourceMetaInfoDo result) {
		this.resMetaInfoDo = result;
	}
	/**
	 * @function setResourceDescription 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method is used to set the resource description.
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setResourceDescription(){
		descriptionTxtAera.setText(collectionItemDo.getResource().getDescription());
	}
	/**
	 * @function onChangeFileUploadBtn 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This will handle the change event on choose resoruce button.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
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
	
	/**
	 * @function displayResourceInfo 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This method is used to display the resource information.
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void displayResourceInfo() {
		String url = collectionItemDo.getResource().getUrl();
		if (collectionItemDo.getResource().getDescription().length() >= 300) {
			descriptionTxtAera.setText(collectionItemDo.getResource()
					.getDescription().substring(0, 300));
		} else {
			descriptionTxtAera.setText(collectionItemDo.getResource()
					.getDescription());
		}
		if (collectionItemDo.getResource().getTitle().length() >= 50) {
			titleTextBox.setText(collectionItemDo.getResource().getTitle()
					.substring(0, 50));
		} else {
			titleTextBox.setText(collectionItemDo.getResource().getTitle());
		}

		setThumbnailImage.setVisible(true);
		String category = collectionItemDo.getResource().getCategory();
		 if (category.equalsIgnoreCase("Slide")) {
			resourceCategoryLabel.setText("Slide");
			categorypanel.setStyleName(slide.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
		} else if (category.equalsIgnoreCase("Handout")) {
			resourceCategoryLabel.setText("Handout");
			categorypanel.setStyleName(handout.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
		} else if (category.equalsIgnoreCase("Textbook")) {
			resourceCategoryLabel.setText("Textbook");
			categorypanel.setStyleName(textbook.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
		} else if (category.equalsIgnoreCase("Lesson")) {
			resourceCategoryLabel.setText("Lesson");
			categorypanel.setStyleName(lesson.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
//		} else if (category.equalsIgnoreCase("Question")) {
//			resourceCategoryLabel.setText("Question");
//			categorypanel.setStyleName(question.getStyleName());
//			resourceTypePanel.setVisible(false);
//			resoureDropDownLblOpen=false;
		} 

		thumbnailUrlStr = collectionItemDo.getResource().getThumbnailUrl();
		setImage(url, category);
	}
	/**
	 * @function setImage 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This method is used to set image.
	 * 
	 * 
	 * @parm(s) : @param url
	 * @parm(s) : @param category
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setImage(String url, String category){
		if (thumbnailUrlStr.endsWith("null")) {
			if (url.indexOf("youtube") >0){
				String youTubeIbStr = ResourceImageUtil.getYoutubeVideoId(url);
				thumbnailUrlStr = "http://img.youtube.com/vi/"+youTubeIbStr+"/1.jpg";
			}else{
				thumbnailUrlStr = DEFULT_IMAGE_PREFIX + category.toLowerCase() + PNG;
			}
		} 
		setThumbnailImage.setUrl(thumbnailUrlStr);
	}
	/**
	 * @function updateUi 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This method is used to update ui.
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void updateUi() {
		setThumbnailImage.setVisible(true);

	}
	/**
	 * This inner class is used to handle the click events on upload button.
	 */
	private class ChangeFileBtnClick implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			defaultFileTxtContainer.getElement().getStyle().setDisplay(Display.NONE);
			uploadName.getElement().getStyle().setDisplay(Display.BLOCK);
			uploadContainer.getElement().getStyle().setDisplay(Display.BLOCK);
			if(!resourcePathTextBox.getText().trim().equalsIgnoreCase("")){
				resourcePathTextBox.setText("");
			}
			
		}
		
	}
	/**
	 * @function onMouseOver 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This will handle the mouse over event on the content rights label.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("lblContentRights")
	public void onMouseOver(MouseOverEvent event){
		panelContentRights.setVisible(true);
	}
	/**
	 * @function onMouseOut 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This will handle the mouse out event on the content rights label.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("lblContentRights")
	public void onMouseOut(MouseOutEvent event){
		panelContentRights.setVisible(false);
	}
	/**
	 * @function onClickRollBackPaperClip 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This will handle the click event on roll back to paper clip.
	 * 
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("rollBackToPaperClip")
	public void onClickRollBackPaperClip(ClickEvent clickEvent){
		uploadName.getElement().getStyle().setDisplay(Display.NONE);
		uploadContainer.getElement().getStyle().setDisplay(Display.NONE);
		defaultFileTxtContainer.getElement().getStyle().setDisplay(Display.BLOCK);
		resourceContentChkLbl.setVisible(false);
	}
	/**
	 * This inner class is used to handle the click events.
	 */
	private class AddClickHandler implements ClickHandler {
		@SuppressWarnings("deprecation")
		@Override
		public void onClick(ClickEvent event) {
			
			lblAdding.getElement().getStyle().setDisplay(Display.BLOCK);
			panelAction.getElement().getStyle().setDisplay(Display.NONE);

			boolean isValidate = true;

			 titleStr = titleTextBox.getText().trim();
			 categoryStr =resourceCategoryLabel.getText();// resourceTypeListBox.getItemText(resourceTypeListBox.getSelectedIndex());
			 filePath = resourcePathTextBox.getText().trim();
			 
			 if(uploadContainer.isVisible()){
				 if(resourcePathTextBox.getText().trim() == null || resourcePathTextBox.getText().trim().equalsIgnoreCase("")){
					 resourceContentChkLbl.setText("Please add a file.");
					 resourceContentChkLbl.setVisible(true);
					 isValidate = false;
				 }
			 }
			
			
			if (titleStr == null || titleStr.equalsIgnoreCase("")) {
				mandatoryTitleLbl.setText("Please enter a title.");
				mandatoryTitleLbl.setVisible(true);
				isValidate = false;
			}
			if(!rightsChkBox.getValue()){
				rightsLbl.getElement().getStyle().setColor("orange");
				isValidate = false;
			}
			if(descriptionTxtAera.getText().trim()==null || descriptionTxtAera.getText().trim().equals("")){
				isValidate = false;
				descCharcterLimit.setText("Please add a description.");
				descCharcterLimit.setVisible(true);
			}
			if (categoryStr == null	|| categoryStr.equalsIgnoreCase("-1")|| categoryStr.equalsIgnoreCase("Choose a resource category")) {
				mandatoryCategoryLbl.setText("Please choose a category.");
				mandatoryCategoryLbl.setVisible(true);
				isValidate = false;
			}

			if (isValidate) {
				/*String str ="{\"deleteType\":\"DELETE\",\"deleteUrl\":\"media/0deeb890-8a4b-468e-87c0-5615d69e856e.jpg\",\"imageValidationMsg\":null,\"name\":\"555cb7a6-4312-434e-8e09-004a72fa4073.jpg\",\"originalFilename\":\"download(2).jpg\",\"size\":462358,\"statusCode\":200,\"uploadImageSource\":\"local\",\"url\":\"http://devrepo.goorulearning.org/qalive/uploaded-media/0deeb890-8a4b-468e-87c0-5615d69e856e.jpg\"}";
				parseUploadFileDetails(str);*/ 
				
				if(fileChanged && (uploadContainer.isVisible())){ 
					fileuploadForm.setAction(AppClientFactory.getLoggedInUser().getSettings().getRestEndPoint() + StringUtil.generateMessage(IMAGE_UPLOAD_URL, AppClientFactory.getLoggedInUser().getToken(), chooseResourceBtn.getFilename()));
					fileuploadForm.addFormHandler(new FormHandler() {
						public void onSubmitComplete(FormSubmitCompleteEvent event) {
							if(isValidImageSize){
								parseUploadFileDetails(event.getResults());
							}
							
						}
						
						@Override
						public void onSubmit(FormSubmitEvent event) {
							
						}
					});
					fileuploadForm.submit();
				}
				else{
					updateUserOwnResource(filePath,mediaFileName,originalFileName,titleStr,descriptionTxtAera.getText().trim(),categoryStr,thumbnailUrlStr);
				}
			}
			else{
				lblAdding.getElement().getStyle().setDisplay(Display.NONE);
				panelAction.getElement().getStyle().setDisplay(Display.BLOCK);
			}
		}

		protected void parseUploadFileDetails(String jsonString) {
			if(jsonString!=null){
				JSONValue jsonParseValue=JSONParser.parseStrict(jsonString);
				JSONObject jsonObject=jsonParseValue.isObject();
				JSONValue jsonMediaFileValue=jsonObject.get("name");
				String mediaFileName=jsonMediaFileValue.isString().toString().replaceAll("^\"|\"$", "");
				JSONValue jsonOriginalFileValue=jsonObject.get("originalFilename");
				String originalFileName=jsonOriginalFileValue.isString().toString().replaceAll("^\"|\"$", "");
				updateUserOwnResource(filePath,mediaFileName,originalFileName,titleStr,descriptionTxtAera.getText().trim(),categoryStr,thumbnailUrlStr);
			}
		}
	}

	/**
	 * This will handle the click event on edit image button.
	 */
	private class OnEditImageClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			resourceImageUpload();
		}
	}

	public abstract void resourceImageUpload();

	public abstract void updateUserOwnResource(String resourceFilePath,String resMediaFileName,String resOriginalFileName,String titleStr, String desc,String categoryStr, String thumbnailUrlStr);
	
	private class ResourcePathKeyUpHandler implements KeyUpHandler {
		public void onKeyUp(KeyUpEvent event) {
			resourceContentChkLbl.setVisible(false);
		}
	}
	/**
	 * This will handle the keyup event on titleTextBox.
	 */
	private class TitleKeyUpHandler implements KeyUpHandler {

		public void onKeyUp(KeyUpEvent event) {
			mandatoryTitleLbl.setVisible(false);
			if (titleTextBox.getText().length() >= 50) {
				mandatoryTitleLbl.setText("Character limit reached.");
				mandatoryTitleLbl.setVisible(true);
			}
		}
	}
	/**
	 * This will handle the keyup event on descriptionTxtAera.
	 */
	private class DescriptionKeyUpHandler implements KeyUpHandler {

		public void onKeyUp(KeyUpEvent event) {
			descCharcterLimit.setVisible(false);
			if (descriptionTxtAera.getText().length() >= 300) {
				descriptionTxtAera.setText(descriptionTxtAera.getText().trim().substring(0,300));
				descCharcterLimit.setText("Character limit reached.");
				descCharcterLimit.setVisible(true);
			}
		}
	}


	/**
	 * @function slideResourcePanel 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This will handle the click event on slide resource panel.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("slideResourcePanel")
	void slideResourcePanel(ClickEvent event){
		resourceCategoryLabel.setText("Slide");
		categorypanel.setStyleName(slide.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen=false;
	}
	/**
	 * 
	 * @function handoutResourcePanel 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This will handle the click event on handout resource panel.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("handoutResourcePanel")
	void handoutResourcePanel(ClickEvent event){
		resourceCategoryLabel.setText("Handout");
		categorypanel.setStyleName(handout.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen=false;
	}
	/**
	 * 
	 * @function textbookResourcePanel 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This will handle the click event on textbook resource panel.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("textbookResourcePanel")
	void textbookResourcePanel(ClickEvent event){
		resourceCategoryLabel.setText("Textbook");
		categorypanel.setStyleName(textbook.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen=false;
	}
	/**
	 * @function lessonResourcePanel 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This will handle the click event on lesson resource panel.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("lessonResourcePanel")
	void lessonResourcePanel(ClickEvent event){
		resourceCategoryLabel.setText("Lesson");
		categorypanel.setStyleName(lesson.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen=false;
	}	
	/**
	 * @function dropDownClick 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This will handle the click event on resource drop down.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("resoureDropDownLbl")
	public void dropDownClick(ClickEvent event){
		if(resoureDropDownLblOpen==false){
			resourceTypePanel.setVisible(true);
			resoureDropDownLblOpen=true;
			
		} else {
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
		}
		
	}

	/*public void setImageThumbnail() {
		setThumbnailImage.setUrl(thumbnailImagesLink.get(activeImageIndex));
		thumbnailUrlStr = thumbnailImagesLink.get(activeImageIndex);
	}*/

	/*public void clearFields() {
		titleTextBox.setText("");
		descriptionTxtAera.setText("");
		//resourceTypeListBox.setSelectedIndex(0);
		setThumbnailImage.setUrl("");
	}*/


	/** 
	 * This method is to get the setThumbnailImage
	 */
	public Image getSetThumbnailImage() {
		return setThumbnailImage;
	}

	/** 
	 * This method is to set the setThumbnailImage
	 */
	public void setSetThumbnailImage(Image setThumbnailImage) {
		this.setThumbnailImage = setThumbnailImage;
	}
	
	/** 
	 * This method is to get the thumbnailUrlStr
	 */
	public String getThumbnailUrlStr() {
		return thumbnailUrlStr;
	}

	/** 
	 * This method is to set the thumbnailUrlStr
	 */
	public void setThumbnailUrlStr(String thumbnailUrlStr) {
		this.thumbnailUrlStr = thumbnailUrlStr;
	}
	/** 
	 * This method is to set the file name with out resp url.
	 */
	public void setFileNameWithOutRespUrl(String fileNameWithOutRespUrl ){
		this.fileNameWithOutRespUrl = fileNameWithOutRespUrl;
	}
	/**
	 * @function handelFormEvent 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This method is used to handle form the event.
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private void handelFormEvent() {
		chooseResourceBtn.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				 if(hasValidateResource()){
					 isValidImageSize=true;
					 resourceContentChkLbl.setVisible(false);
					 resourcePathTextBox.setText(chooseResourceBtn.getFilename().trim());
					 fileChanged=true;
					 
				 }
				 else{
						if(!chooseResourceBtn.getFilename().trim().equalsIgnoreCase("")){
							 resourceContentChkLbl.setText(RESOURCE_FILE_SUPPORT_MSG);
							 resourceContentChkLbl.setVisible(true);
							 
						 }
					
					 
					 
				 }
				
			}
		});
	}
	/**
	 * @function hasValidateResource 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This method is used to validate the resoruce.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : boolean
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
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
        var sPath =   $wnd.$("#uploadFile")[0].value;
        var objFile = objFSO.getFile(sPath);
         var iSize = objFile.size;
        fileSize = iSize/ 1048576;
    
        }
    
     
     
        else 
        {
  
       fileSize =  $wnd.$("#uploadFile")[0].files[0].size ;//size in kb
       
        fileSize = fileSize / 1048576; //size in mb 
 
         }
 
        
     
        
           return fileSize.toString();
   
                 
    
  }-*/;

}
