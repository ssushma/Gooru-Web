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

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.faq.CopyRightPolicyVc;
import org.ednovo.gooru.client.mvp.faq.TermsAndPolicyVc;
import org.ednovo.gooru.client.mvp.faq.TermsOfUse;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.CollectionEditResourceCBundle;
import org.ednovo.gooru.client.uc.BlueButtonUc;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.client.util.SetStyleForProfanity;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
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
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public abstract class AddUserOwnResourceView extends Composite {
	public interface AddUserOwnResourceViewUiBinder extends UiBinder<Widget,AddUserOwnResourceView> {
		
	}
	public static AddUserOwnResourceViewUiBinder uiBinder = GWT.create(AddUserOwnResourceViewUiBinder.class);
	
	private static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	@UiField HTMLPanel loadingImagePanel,rightsContent;
	
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
	HTMLPanel panelContentRights,resourceTitleContainer,filePathContainer,thumbnailImageText;

	@UiField
	public HTMLPanel loadingPanel,imageContainer,fileSizeLimit,titleText,descriptionText,categoryPanelText,imageText,textsPanelLabel;

	@UiField
	HTMLPanel categorypanel,texts,image;

	@UiField
	HTMLPanel resourceTypePanel, resourceDescriptionContainer,panelAction;

	@UiField
	Label resoureDropDownLbl, resourceCategoryLabel,rightsLbl,mandatoryDescLblForSwareWords,mandatoryTitleLblForSwareWords;
	
	@UiField
	FormPanel fileuploadForm;
	
	
	@UiField
	FileUpload chooseResourceBtn;
	
	@UiField
	CheckBox rightsChkBox;

	@UiField Label lblAdding;
	@UiField InlineLabel agreeText,andText,additionalText,commuGuideLinesAnr, termsAndPolicyAnr,privacyAnr,copyRightAnr;
	@UiField org.ednovo.gooru.client.uc.HTMLEventPanel imageResourcePanel,textsResourcePanel;
	
	 
	
	
	
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
	
	private boolean isValidImageSize=true,isHavingBadWordsInTextbox=false,isHavingBadWordsInRichText=false;
	
	String originalFileName=null;
	
	private CopyRightPolicyVc copyRightPolicy;
	
	private TermsAndPolicyVc termsAndPolicyVc;
	private TermsOfUse termsOfUse;
	
	String thumbnailUrlStr = null;
	
	String filePath,resourceTitle,resourceDesc,resourceCategory;
	
	private static final String RESOURCE_UPLOAD_FILE_PATTERN = "([^\\s]+([^?#]*\\.(?:jpg|jpeg|pdf))$)";
	private static final String RESOURCE_FILE_SUPPORT_MSG = i18n.GL0955();
	
	private static final String IMAGE_UPLOAD_URL = "/v2/media?sessionToken={0}";
	boolean isEnabled = true;
	boolean isValidText=false,isValidTextArea=false,isValidFilePath=false;
	CollectionDo collectionDo;
	
	/**
	 *  Class constructor
	 *  
	 * @param collectionDo instance of {@link CollectionDo}
	 */
	
	public AddUserOwnResourceView(CollectionDo collectionDo){ 
		this.collectionDo = collectionDo;
		initWidget(uiBinder.createAndBindUi(this));
		fileSizeLimit.getElement().setInnerHTML(" "+i18n.GL0901());
		fileSizeLimit.getElement().setId("pnlFileSizeLimit");
		fileSizeLimit.getElement().setAttribute("alt", i18n.GL0901());
		fileSizeLimit.getElement().setAttribute("title", i18n.GL0901());
		browseResourceBtn.setText(i18n.GL0902());
		browseResourceBtn.getElement().setId("btnBrowseResourceBtn");
		browseResourceBtn.getElement().setAttribute("alt", i18n.GL0902());
		browseResourceBtn.getElement().setAttribute("title", i18n.GL0902());
		titleText.getElement().setInnerHTML(i18n.GL0318());
		titleText.getElement().setId("pnlTitleText");
		titleText.getElement().setAttribute("alt", i18n.GL0318());
		titleText.getElement().setAttribute("title", i18n.GL0318());
		descriptionText.getElement().setInnerHTML(i18n.GL0904());
		descriptionText.getElement().setId("pnlDescriptionText");
		descriptionText.getElement().setAttribute("alt", i18n.GL0904());
		descriptionText.getElement().setAttribute("title", i18n.GL0904());
		categoryPanelText.getElement().setInnerHTML(i18n.GL0906());
		categoryPanelText.getElement().setId("pnlCategoryPanelText");
		categoryPanelText.getElement().setAttribute("alt", i18n.GL0906());
		categoryPanelText.getElement().setAttribute("title", i18n.GL0906());
		textsPanelLabel.getElement().setInnerHTML(i18n.GL1044());
		textsPanelLabel.getElement().setId("pnlTextsPanelLabel");
		textsPanelLabel.getElement().setAttribute("alt", i18n.GL1044());
		textsPanelLabel.getElement().setAttribute("title", i18n.GL1044());
		
		imageText.getElement().setInnerHTML(i18n.GL1046());
		imageText.getElement().setId("pnlImageText");
		imageText.getElement().setAttribute("alt", i18n.GL1046());
		imageText.getElement().setAttribute("title", i18n.GL1046());
		
		thumbnailImageText.getElement().setInnerHTML(i18n.GL0911());
		thumbnailImageText.getElement().setId("pnlThumbnailImageText");
		thumbnailImageText.getElement().setAttribute("alt", i18n.GL0911());
		thumbnailImageText.getElement().setAttribute("title", i18n.GL0911());
		
		uploadImageLbl.setText(i18n.GL0912());
		uploadImageLbl.getElement().setAttribute("alt", i18n.GL0912());
		uploadImageLbl.getElement().setAttribute("title", i18n.GL0912());
		rightsLbl.setText(i18n.GL0869());
		rightsLbl.getElement().setId("lblRightsLbl");
		rightsLbl.getElement().setAttribute("alt", i18n.GL0869());
		rightsLbl.getElement().setAttribute("title", i18n.GL0869());
		agreeText.setText(i18n.GL0870());
		agreeText.getElement().setId("lblAgreeText");
		agreeText.getElement().setAttribute("alt", i18n.GL0870());
		agreeText.getElement().setAttribute("title", i18n.GL0870());
		commuGuideLinesAnr.setText(i18n.GL0871()+i18n.GL_GRR_COMMA());
		commuGuideLinesAnr.getElement().setId("lnkCommuGuideLinesAnr");
		commuGuideLinesAnr.getElement().setAttribute("alt", i18n.GL0871());
		commuGuideLinesAnr.getElement().setAttribute("title", i18n.GL0871());
		termsAndPolicyAnr.setText(" "+i18n.GL0872()+i18n.GL_GRR_COMMA());
		termsAndPolicyAnr.getElement().setId("lnkTermsAndPolicyAnr");
		termsAndPolicyAnr.getElement().setAttribute("alt", i18n.GL0872());
		termsAndPolicyAnr.getElement().setAttribute("title", i18n.GL0872());
		privacyAnr.setText(" "+i18n.GL0873());
		privacyAnr.getElement().setId("lnkPrivacyAnr");
		privacyAnr.getElement().setAttribute("alt", i18n.GL0873());
		privacyAnr.getElement().setAttribute("title", i18n.GL0873());
		andText.setText(i18n.GL_GRR_AND());
		andText.getElement().setId("lblAndText");
		andText.getElement().setAttribute("alt", i18n.GL_GRR_AND());
		andText.getElement().setAttribute("title", i18n.GL_GRR_AND());
		copyRightAnr.setText(" "+i18n.GL0875());
		copyRightAnr.getElement().setId("lnkCopyRightAnr");
		copyRightAnr.getElement().setAttribute("alt", i18n.GL0875());
		copyRightAnr.getElement().setAttribute("title", i18n.GL0875());
		additionalText.setText(i18n.GL0874());
		additionalText.getElement().setId("lblAdditionalText");
		additionalText.getElement().setAttribute("alt", i18n.GL0874());
		additionalText.getElement().setAttribute("title", i18n.GL0874());
		cancelResourcePopupBtnLbl.setText(i18n.GL0142());
		cancelResourcePopupBtnLbl.getElement().setAttribute("alt", i18n.GL0142());
		cancelResourcePopupBtnLbl.getElement().setAttribute("title", i18n.GL0142());
		cancelResourcePopupBtnLbl.getElement().setAttribute("style", "margin-left:10px;");
		addResourceBtnLbl.setText(i18n.GL0590());
		addResourceBtnLbl.getElement().setAttribute("alt", i18n.GL0590());
		addResourceBtnLbl.getElement().setAttribute("title", i18n.GL0590());
		lblAdding.setText(i18n.GL0591().toLowerCase());
		lblAdding.getElement().setAttribute("alt", i18n.GL0591().toLowerCase());
		lblAdding.getElement().setAttribute("title", i18n.GL0591().toLowerCase());

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
		StringUtil.setAttributes(resourcePathTextBox, true);
		titleTextBox.getElement().setId("tbTitle");
		StringUtil.setAttributes(titleTextBox, true);
		descriptionTxtAera.getElement().setId("taDescription");
		StringUtil.setAttributes(descriptionTxtAera, true);
		descriptionTxtAera.getElement().setAttribute("placeholder", i18n.GL0359());
		resourcePathTextBox.addKeyUpHandler(new ResourcePathKeyUpHandler());
		titleTextBox.addKeyUpHandler(new TitleKeyUpHandler());
		descriptionTxtAera.addKeyUpHandler(new DescriptionKeyUpHandler());
		titleTextBox.getElement().setAttribute("maxlength", "50");
		descriptionTxtAera.getElement().setAttribute("maxlength", "300");
		resourceCategoryLabel.setText(i18n.GL0360());
		resourceCategoryLabel.getElement().setId("lblResourceCategoryLabel");
		resourceCategoryLabel.getElement().setAttribute("alt", i18n.GL0360());
		resourceCategoryLabel.getElement().setAttribute("title", i18n.GL0360());
		resourceContentChkLbl.setVisible(false);
		resourceContentChkLbl.getElement().setId("lblResourceContentChkLbl");
		loadingPanel.getElement().setId("pnlLoadingPanel");
		mandatoryTitleLbl.setVisible(false);
		mandatoryTitleLbl.getElement().setId("lblMandatoryTitleLbl");
		descCharcterLimit.getElement().setId("lblDescCharcterLimit");
		descCharcterLimit.setVisible(false);
		setThumbnailImage.getElement().setId("imgSetThumbnailImage");
		setThumbnailImage.setVisible(false);
		resourceTypePanel.setVisible(false);
		loadingPanel.setVisible(false);
		panelContentRights.setVisible(false);
		panelContentRights.getElement().setId("pnlPanelContentRights");
		imageContainer.getElement().setId("pnlImageContainer");
		imageContainer.getElement().getStyle().setDisplay(Display.NONE);
		rightsLbl.getElement().getStyle().setColor("black");
		chooseResourceBtn.getElement().setId("fileUpload1");
		filePathContainer.getElement().setId("pnlFilePathContainer");
		fileuploadForm.getElement().setId("fpFileuploadForm");
		resourceTitleContainer.getElement().setId("pnlResourceTitleContainer");
		mandatoryTitleLblForSwareWords.getElement().setId("lblMandatoryTitleLblForSwareWords");
		resourceDescriptionContainer.getElement().setId("pnlResourceDescriptionContainer");
		mandatoryDescLblForSwareWords.getElement().setId("lblMandatoryDescLblForSwareWords");
		categorypanel.getElement().setId("pnlCategorypanel");
		resoureDropDownLbl.getElement().setId("lblResoureDropDownLbl");
		resourceTypePanel.getElement().setId("pnlResourceTypePanel");
		imageResourcePanel.getElement().setId("epnlImageResourcePanel");
		image.getElement().setId("pnlImage");
		textsResourcePanel.getElement().setId("epnlTextsResourcePanel");
		texts.getElement().setId("pnlTexts");
		lblContentRights.getElement().setId("epnlLblContentRights");
		rightsContent.getElement().setId("pnlRightsContent");
		panelAction.getElement().setId("pnlPanelAction");
		loadingImagePanel.getElement().setId("pnlLoadingImagePanel");
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
				Window.open("http://support.goorulearning.org/hc/en-us/articles/200688506","_blank",""); 
			}
		});
		
		
		
		resourceCategoryLabel.setText(i18n.GL1044());
		resourceCategoryLabel.getElement().setAttribute("alt", i18n.GL1044());
		resourceCategoryLabel.getElement().setAttribute("title", i18n.GL1044());
		categorypanel.setStyleName(texts.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
		
		
		lblAdding.getElement().getStyle().setDisplay(Display.NONE);
		panelAction.getElement().getStyle().setDisplay(Display.BLOCK);
		titleTextBox.addBlurHandler(new CheckProfanityInOnBlur(titleTextBox, null, mandatoryTitleLblForSwareWords,resourcePathTextBox));
		descriptionTxtAera.addBlurHandler(new CheckProfanityInOnBlur(null, descriptionTxtAera, mandatoryDescLblForSwareWords,resourcePathTextBox));
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
				resourceContentChkLbl.setText(i18n.GL0913());
				resourceContentChkLbl.getElement().setAttribute("alt", i18n.GL0913());
				resourceContentChkLbl.getElement().setAttribute("title", i18n.GL0913());
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
				resourcePathTextBox.getElement().getStyle().setBorderColor("#dddddd");

				 if(hasValidateResource()){
					 isValidImageSize=true;
					 resourceContentChkLbl.setVisible(false);
					 resourcePathTextBox.setText(chooseResourceBtn.getFilename().trim());
					 resourcePathTextBox.getElement().setAttribute("alt", chooseResourceBtn.getFilename().trim());
					 resourcePathTextBox.getElement().setAttribute("title", chooseResourceBtn.getFilename().trim());
				 }
				 else{
					 if(!chooseResourceBtn.getFilename().trim().equalsIgnoreCase("")){
						 resourceContentChkLbl.setVisible(true);
						 resourceContentChkLbl.setText(RESOURCE_FILE_SUPPORT_MSG);
						 resourceContentChkLbl.getElement().setAttribute("alt", RESOURCE_FILE_SUPPORT_MSG);
						 resourceContentChkLbl.getElement().setAttribute("title", RESOURCE_FILE_SUPPORT_MSG);
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
		resourceCategoryLabel.setText(i18n.GL0360());
		resourceCategoryLabel.getElement().setAttribute("alt", i18n.GL0360());
		resourceCategoryLabel.getElement().setAttribute("title", i18n.GL0360());
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
			addResourceBtnLbl.setEnabled(true);
			addResourceBtnLbl.getElement().addClassName("secondary");
			addResourceBtnLbl.getElement().removeClassName("primary");
			//addResourceBtnLbl.getElement().setAttribute("style", "background: #999;border: none;");
			final Map<String, String> parms = new HashMap<String, String>();
			parms.put("text", titleTextBox.getValue());
			AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {
				@Override
				public void onSuccess(Boolean value) {
						isHavingBadWordsInTextbox = value;
						if(value){
							SetStyleForProfanity.SetStyleForProfanityForTextBox(titleTextBox, mandatoryTitleLblForSwareWords,value);
							addResourceBtnLbl.setEnabled(true);
							addResourceBtnLbl.getElement().removeClassName("secondary");
							addResourceBtnLbl.getElement().addClassName("primary");
						}else{
							parms.put("text", descriptionTxtAera.getText());
							AppClientFactory.getInjector().getResourceService().checkProfanity(parms,new SimpleAsyncCallback<Boolean>() {
								
								@Override
								public void onSuccess(Boolean result) {
									isHavingBadWordsInRichText=result;
									if(result){
										SetStyleForProfanity.SetStyleForProfanityForTextArea(descriptionTxtAera, mandatoryDescLblForSwareWords, result);
										addResourceBtnLbl.setEnabled(true);
										addResourceBtnLbl.getElement().removeClassName("secondary");
										addResourceBtnLbl.getElement().addClassName("primary");
									}else{
										
										MixpanelUtil.mixpanelEvent("Collaborator_edits_collection");
										//lblAdding.getElement().getStyle().setDisplay(Display.BLOCK);
										//panelAction.getElement().getStyle().setDisplay(Display.NONE);
										filePath = resourcePathTextBox.getText().trim();
										resourceTitle = titleTextBox.getText().trim();
										resourceDesc = descriptionTxtAera.getText().trim();
										resourceCategory = resourceCategoryLabel.getText();
										boolean isValidate = true;
										if(filePath==null || filePath.equals("")){
											 isValidate = false;
											 isEnabled = false;
											 resourcePathTextBox.setStyleName(CollectionEditResourceCBundle.INSTANCE.css().ownResourceFormInputControlForErrors());
											 resourceContentChkLbl.setText(i18n.GL0914());
											 resourceContentChkLbl.getElement().setAttribute("alt", i18n.GL0914());
											 resourceContentChkLbl.getElement().setAttribute("title", i18n.GL0914());
											 resourceContentChkLbl.setVisible(true);
										}
										if(resourceTitle==null || resourceTitle.equals("")){
											isValidate = false;
											isEnabled = false;
											resourceTitleContainer.setStyleName(CollectionEditResourceCBundle.INSTANCE.css().myFolderCollectionFormInputControlForErrors());
											mandatoryTitleLbl.setText(i18n.GL0903());
											mandatoryTitleLbl.getElement().setAttribute("alt", i18n.GL0903());
											mandatoryTitleLbl.getElement().setAttribute("title", i18n.GL0903());
											mandatoryTitleLbl.setVisible(true);
										}
										if(resourceDesc==null || resourceDesc.equals("")){
											isValidate = false;
											isEnabled = false;
											resourceDescriptionContainer.setStyleName(CollectionEditResourceCBundle.INSTANCE.css().myFolderCollectionFormInputControlForErrors());
											resourceDescriptionContainer.addStyleName(CollectionEditResourceCBundle.INSTANCE.css().myFolderCollectionFormTextarea());
										
											descCharcterLimit.setText(i18n.GL0905());
											descCharcterLimit.getElement().setAttribute("alt", i18n.GL0905());
											descCharcterLimit.getElement().setAttribute("title", i18n.GL0905());
											descCharcterLimit.setVisible(true);
										}
										if(resourceCategory==null || resourceCategory.equals("-1") || resourceCategory.equalsIgnoreCase("Choose a resource format") ){ 
											isValidate = false;
											isEnabled = false;
										}
										if(!rightsChkBox.getValue()){
											rightsLbl.getElement().getStyle().setColor("orange");
											isValidate = false;
											isEnabled = false;
										}
										if(isValidate){
											addResourceBtnLbl.setEnabled(true);
											addResourceBtnLbl.getElement().removeClassName("secondary");
											addResourceBtnLbl.getElement().addClassName("primary");
											/*addResourceBtnLbl.getElement().setAttribute("style", "background: #1076BB;border: 1px solid #1076BB;");*/
											loadingImagePanel.clear();
											loadingImagePanel.add(setLoadingPanel());
											fileuploadForm.setAction(AppClientFactory.getLoggedInUser().getSettings().getRestEndPoint() + StringUtil.generateMessage(IMAGE_UPLOAD_URL, AppClientFactory.getLoggedInUser().getToken(), chooseResourceBtn.getFilename()));
											fileuploadForm.addFormHandler(new FormHandler() {
												
												public void onSubmitComplete(FormSubmitCompleteEvent event) {
													panelAction.getElement().getStyle().setDisplay(Display.NONE);
													lblAdding.getElement().getStyle().setDisplay(Display.BLOCK);
													loadingImagePanel.setVisible(false);
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
											
											
											/*
											 String str ="{\"deleteType\":\"DELETE\",\"deleteUrl\":\"media/f310515f-2908-4bb4-83a5-e4626b72d7dd.pdf\",\"imageValidationMsg\":null,\"name\":\"f310515f-2908-4bb4-83a5-e4626b72d7dd.pdf\",\"originalFilename\":\"gwtb_html5_a_web_develops_dream.pdf\",\"size\":462358,\"statusCode\":200,\"uploadImageSource\":\"local\",\"url\":\"http://westrepository.goorulearning.org/prod1/uploaded-media/f310515f-2908-4bb4-83a5-e4626b72d7dd.pdf\"}";
							                 parseUploadFileDetails(str,true);*/
											
										}else{
											lblAdding.getElement().getStyle().setDisplay(Display.NONE);
											panelAction.getElement().getStyle().setDisplay(Display.BLOCK);
										/*	addResourceBtnLbl.setEnabled(true);*/
										}
									}
								}
							});
						}
				}
			});
		}

		protected void parseUploadFileDetails(String jsonString,boolean showPreview) { 
			if(jsonString!=null){
				JSONValue jsonParseValue=JSONParser.parseStrict(jsonString);
				JSONObject jsonObject=jsonParseValue.isObject();
				JSONValue jsonMediaFileValue=jsonObject.get("name");
				String mediaFileName=jsonMediaFileValue.isString().toString().replaceAll("^\"|\"$", "");
				JSONValue jsonOriginalFileValue=jsonObject.get("originalFilename");
				String originalFileName=jsonOriginalFileValue.isString().toString().replaceAll("^\"|\"$", "");
				if(resourceCategory.equalsIgnoreCase("Image")||resourceCategory.equalsIgnoreCase("Text"))
				{
					//resourceCategory=resourceCategory.substring(0, resourceCategory.length()-1);
					 if(resourceCategory.equalsIgnoreCase("Image")){
						 resourceCategory="Image";
					 }
				}
				if(showPreview){
					showResourcePreview(filePath,mediaFileName,originalFileName,resourceTitle,resourceDesc,resourceCategory);
					addResourceBtnLbl.setEnabled(true);
				}else{
					addUserResource(filePath,mediaFileName,originalFileName,resourceTitle,resourceDesc,resourceCategory);
					addResourceBtnLbl.setEnabled(true);
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
			addResourceBtnLbl.setEnabled(true);
			addResourceBtnLbl.getElement().removeClassName("secondary");
			addResourceBtnLbl.getElement().addClassName("primary");
			/*addResourceBtnLbl.getElement().setAttribute("style", "background: #1076BB;border: 1px solid #1076BB;");*/
		}
	}
	
	private class TitleKeyUpHandler implements KeyUpHandler {

		public void onKeyUp(KeyUpEvent event) {
			addResourceBtnLbl.setEnabled(true);
			addResourceBtnLbl.getElement().removeClassName("secondary");
			addResourceBtnLbl.getElement().addClassName("primary");
			/*addResourceBtnLbl.getElement().setAttribute("style", "background: #1076BB;border: 1px solid #1076BB;");*/
			mandatoryTitleLbl.setVisible(false);
			resourceTitleContainer.setStyleName(CollectionEditResourceCBundle.INSTANCE.css().myFolderCollectionFormInputControl());
			if (titleTextBox.getText().length() >= 50) {
				mandatoryTitleLbl.setText(i18n.GL0143());
				mandatoryTitleLbl.getElement().setAttribute("alt", i18n.GL0143());
				mandatoryTitleLbl.getElement().setAttribute("title", i18n.GL0143());
				mandatoryTitleLbl.setVisible(true);
			}
		}
	}
	
	
	private class DescriptionKeyUpHandler implements KeyUpHandler {
		public void onKeyUp(KeyUpEvent event) {
			addResourceBtnLbl.setEnabled(true);
			addResourceBtnLbl.getElement().removeClassName("secondary");
			addResourceBtnLbl.getElement().addClassName("primary");
			/*addResourceBtnLbl.getElement().setAttribute("style", "background: #1076BB;border: 1px solid #1076BB;");*/
			descCharcterLimit.setVisible(false);
			resourceDescriptionContainer.setStyleName(CollectionEditResourceCBundle.INSTANCE.css().myFolderCollectionFormInputControl());
			resourceDescriptionContainer.addStyleName(CollectionEditResourceCBundle.INSTANCE.css().myFolderCollectionFormTextarea());
			if (descriptionTxtAera.getText().length() >= 300) {
//				descriptionTxtAera.setText(descriptionTxtAera.getText().trim().substring(0, 300));
				descCharcterLimit.setText(i18n.GL0143());
				descCharcterLimit.getElement().setAttribute("alt", i18n.GL0143());
				descCharcterLimit.getElement().setAttribute("title", i18n.GL0143());
				descCharcterLimit.setVisible(true);
			}

		}
	}

	@UiHandler("imageResourcePanel")
	void slideResourcePanel(ClickEvent event) {
		MixpanelUtil.mixpanelEvent("organize_add_resource_image_selected");
		resourceCategoryLabel.setText(i18n.GL1046());
		resourceCategoryLabel.getElement().setAttribute("alt", i18n.GL1046());
		resourceCategoryLabel.getElement().setAttribute("title", i18n.GL1046());
		categorypanel.setStyleName(image.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
	}

	@UiHandler("textsResourcePanel")
	void handoutResourcePanel(ClickEvent event) {
		MixpanelUtil.mixpanelEvent("organize_add_resource_text_selected");
		resourceCategoryLabel.setText(i18n.GL1044());
		resourceCategoryLabel.getElement().setAttribute("alt", i18n.GL1044());
		resourceCategoryLabel.getElement().setAttribute("title", i18n.GL1044());
		categorypanel.setStyleName(texts.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
	}

	/*@UiHandler("textbookResourcePanel")
	void textbookResourcePanel(ClickEvent event) {
		resourceCategoryLabel.setText(i18n.GL0909);
		categorypanel.setStyleName(textbook.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
	}*/

	/*@UiHandler("lessonResourcePanel")
	void lessonResourcePanel(ClickEvent event) {
		resourceCategoryLabel.setText(i18n.GL0910);
		categorypanel.setStyleName(lesson.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
	}*/


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
	public class CheckProfanityInOnBlur implements BlurHandler{
		private TextBox textBox;
		private Label label;
		private TextArea textArea;
		private TextBox filePathVal;
		
		public CheckProfanityInOnBlur(TextBox textBox,TextArea textArea,Label label,TextBox path){
			this.textBox=textBox;
			this.label=label;
			this.textArea=textArea;
			this.filePathVal=path;
		}
		@Override
		public void onBlur(BlurEvent event) {
			Map<String, String> parms = new HashMap<String, String>();
			if(textBox!=null){
				parms.put("text", textBox.getValue());
			}else{
				parms.put("text", textArea.getText());
			}
			addResourceBtnLbl.setEnabled(true);
			addResourceBtnLbl.getElement().removeClassName("secondary");
			addResourceBtnLbl.getElement().addClassName("primary");
			AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {

				@Override
				public void onSuccess(Boolean value) {
					addResourceBtnLbl.setEnabled(true);
					if(textBox!=null){
						isHavingBadWordsInTextbox = value;
						SetStyleForProfanity.SetStyleForProfanityForTextBox(textBox, label, value);
						isEnabled = false;
						if(value || textBox.getValue().trim().equalsIgnoreCase("")){
							isValidText=false;
						}else{
							isValidText=true;
						}
					
					}else{
						isHavingBadWordsInRichText=value;
						SetStyleForProfanity.SetStyleForProfanityForTextArea(textArea, label, value);
						isEnabled = false;
						if(value || textArea.getText().trim().equalsIgnoreCase("")){
							isValidTextArea=false;
						}else{
							isValidTextArea=true;
						}
					}
					if(filePathVal.getText().trim().equalsIgnoreCase("")){
						isValidFilePath =false;
					}else{
						isValidFilePath =true;
					}
					/*if(isValidText && isValidTextArea && isValidFilePath){
						addResourceBtnLbl.setEnabled(true);
						addResourceBtnLbl.getElement().setAttribute("style", "background: #1076BB;border: 1px solid #1076BB;");
					}else{
						addResourceBtnLbl.setEnabled(false);
						addResourceBtnLbl.getElement().setAttribute("style", "background: #999;border: none;");
					}*/
				}
			});
		}
	}
	public Label setLoadingPanel(){
		Label loadingImage=new Label();
		loadingImage.setStyleName(CollectionEditResourceCBundle.INSTANCE.css().loadingpanelImage());
		return loadingImage;
	}
	
}
