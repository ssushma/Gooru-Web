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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.faq.CopyRightPolicyVc;
import org.ednovo.gooru.client.mvp.faq.TermsAndPolicyVc;
import org.ednovo.gooru.client.mvp.faq.TermsOfUse;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.event.GetEditPageHeightEvent;
import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.client.util.SetStyleForProfanity;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.ResourceMetaInfoDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.ResourceImageUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.FontStyle;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.regexp.shared.MatchResult;
import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public abstract class EditResourcePopupVc extends AppPopUp implements MessageProperties{

	CollectionItemDo collectionItemDo;

	@UiField
	public Button addResourceBtn;
	
	@UiField
	public Label generateImageLbl;

	@UiField
	Label mandatoryUrlLbl, mandatoryTitleLbl,agreeText,additionalText;

	@UiField
	Label mandatoryCategoryLbl, urlTextLbl,andText;

	@UiField
	Label leftArrowLbl, rightArrowLbl, uploadImageLbl,mandatoryDescLblForSwareWords,mandatoryTitleLblForSwareWords;

	@UiField
	public TextBox titleTextBox;

	@UiField
	public TextArea descriptionTxtAera;
	
	@UiField HTMLEventPanel videoResourcePanel,lblContentRights;

	/*@UiField
	public ListBox resourceTypeListBox;*/

	@UiField
	Image setThumbnailImage;
	
	// Drop down for Resource Type//
	@UiField
	HTMLPanel descCharcterLimit,saveButtonContainer,panelContentRights,rightsContainer,videoPanel,interactivePanel,websitePanel,imagePanel,textsPanel,audioPanel;//otherPanel
	
	@UiField Label resourceCategoryLabel,loadingTextLbl,rightsLbl;
	
	 @UiField HTMLPanel categorypanel,video,interactive,website,resourceTypePanel,image,texts,audio,resourceFormat,resDescription,urlTextPanel,titleTextPanel,thumbnailLbl,orLbl,refreshLblPanel;//other,
	 @UiField CheckBox rightsChkBox;
	 @UiField Anchor copyRightAnr;
	 @UiField Anchor termsAndPolicyAnr,privacyAnr;
	@UiField Anchor commuGuideLinesAnr,cancelResourcePopupBtnLbl;
	ResourceMetaInfoDo resMetaInfoDo = null;
	private CopyRightPolicyVc copyRightPolicy;
	
	private TermsAndPolicyVc termsAndPolicyVc;
	private TermsOfUse termsOfUse;
	private int activeImageIndex = 0;
	protected List<String> thumbnailImagesLink;
	
	private String thumbnailUrlStr = null;
	
	String fileNameWithOutRespUrl = null;
	
	public boolean resoureDropDownLblOpen = false;
	
	private static final String DEFULT_IMAGE_PREFIX = "images/default-";

	private static final String PNG = ".png";
	boolean isHavingBadWordsInTextbox=false,isHavingBadWordsInRichText=false;
	
	private static EditResourcePopupVcUiBinder uiBinder = GWT
			.create(EditResourcePopupVcUiBinder.class);

	interface EditResourcePopupVcUiBinder extends
			UiBinder<Widget, EditResourcePopupVc> {
	}

	public abstract void updateResource(CollectionItemDo collectionItemDo);

	public EditResourcePopupVc(CollectionItemDo collectionItemDo) {
		super();
		// this.getElement().getStyle().setWidth(450, Unit.PX);
		// this.getElement().getStyle().setHeight(788, Unit.PX);
		this.collectionItemDo = collectionItemDo;
		setContent(GL0949, uiBinder.createAndBindUi(this));

		addResourceBtn.addClickHandler(new AddClickHandler());
		addResourceBtn.getElement().getStyle().setFloat(Float.LEFT);
		uploadImageLbl.addClickHandler(new OnEditImageClick());

		titleTextBox.addKeyUpHandler(new TitleKeyUpHandler());
		descriptionTxtAera.addKeyUpHandler(new DescriptionKeyUpHandler());
		titleTextBox.getElement().setAttribute("maxlength", "50");
		descriptionTxtAera.getElement().setAttribute("maxlength", "300");
		mandatoryUrlLbl.setVisible(false);
		mandatoryTitleLbl.setVisible(false);
		mandatoryCategoryLbl.setVisible(false);
		descCharcterLimit.setVisible(false);
		leftArrowLbl.setVisible(false);
		rightArrowLbl.setVisible(false);
		setThumbnailImage.setVisible(true);
		resourceTypePanel.setVisible(false);
		loadingTextLbl.getElement().getStyle().setFontStyle(FontStyle.ITALIC);
		generateImageLbl.setVisible(false);
		saveButtonContainer.setVisible(true);
		loadingTextLbl.setVisible(false);
		panelContentRights.setVisible(false);
		mandatoryTitleLblForSwareWords.setVisible(false);
		mandatoryDescLblForSwareWords.setVisible(false);
		rightsChkBox.addClickHandler(new rightsChecked());
		rightsChkBox.getElement().setId("chkRights");
		setModal(true);
		Window.enableScrolling(false);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, false));
        mandatoryTitleLbl.setText(GL0173);
        descCharcterLimit.getElement().setInnerText(GL0143);
        mandatoryCategoryLbl.setText(GL1515);
        thumbnailLbl.getElement().setInnerText(GL0911);
        titleTextPanel.getElement().setInnerText(GL0318+GL_SPL_STAR);
        videoPanel.getElement().setInnerHTML(GL0918);
        interactivePanel.getElement().setInnerHTML(GL0919);
		websitePanel.getElement().setInnerHTML(GL1396);
		textsPanel.getElement().setInnerHTML(GL1044);
		audioPanel.getElement().setInnerHTML(GL1045);
		imagePanel.getElement().setInnerHTML(GL1046);
		generateImageLbl.setText(GL0922);
		orLbl.getElement().setInnerText(GL_GRR_Hyphen+GL0209.toLowerCase()+GL_GRR_Hyphen);
		uploadImageLbl.setText(GL0912);
		refreshLblPanel.getElement().setInnerText(GL0923);
		rightsLbl.setText(GL0869);
		agreeText.setText(GL0870);
		commuGuideLinesAnr.setText(GL0871);
		termsAndPolicyAnr.setText(" "+GL0872+GL_GRR_COMMA);
		privacyAnr.setText(" "+GL0873);
		andText.setText(" "+GL_GRR_AND+" ");
		copyRightAnr.setText(" "+GL0875);
		additionalText.setText(GL0874);
		addResourceBtn.setText(GL0141);
		cancelResourcePopupBtnLbl.setText(GL0142);
		loadingTextLbl.setText(GL0808.toLowerCase());
//		otherPanel.getElement().setInnerHTML(MessageProperties.GL1047);  
		resourceFormat.getElement().setInnerHTML(GL0906); 
		resDescription.getElement().setInnerHTML(GL0904); 
		urlTextPanel.getElement().setInnerHTML(GL0915);
		mandatoryUrlLbl.setText(GL0916);
		
		displayResourceInfo();
		show();
		center();
		AppClientFactory.fireEvent(new GetEditPageHeightEvent(this, false));
		getResourceMetaInfo(collectionItemDo.getResource().getUrl());
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
		titleTextBox.addBlurHandler(new CheckProfanityInOnBlur(titleTextBox, null, mandatoryTitleLblForSwareWords));
		descriptionTxtAera.addBlurHandler(new CheckProfanityInOnBlur(null, descriptionTxtAera, mandatoryDescLblForSwareWords));
	}
	public void onLoad(){
		super.onLoad();
		Scheduler.get().scheduleDeferred(new ScheduledCommand(){

			@Override
			public void execute() {
				setResourceDescription();
			}
        });
	}
	@UiHandler("lblContentRights")
	public void onMouseOver(MouseOverEvent event){
		panelContentRights.setVisible(true);
	}
	
	@UiHandler("lblContentRights")
	public void onMouseOut(MouseOutEvent event){
		panelContentRights.setVisible(false);
	}

	@UiHandler("cancelResourcePopupBtnLbl")
	public void cancelPopUp(ClickEvent clickEvent) {
		AppClientFactory.fireEvent(new GetEditPageHeightEvent(this, true));

		Window.enableScrolling(true);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));

		hide();
	}

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

	public void setData(ResourceMetaInfoDo result) {
		setResMetaInfo(result);
		setThumbnailImages(result.getImages());
		updateUi();
		rightArrowLbl.setVisible(true);
	}
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
	private void setThumbnailImages(List<String> images) {
		thumbnailImagesLink = images;
	}

	private void setResMetaInfo(ResourceMetaInfoDo result) {
		this.resMetaInfoDo = result;
	}
	
	public void setResourceDescription(){
		descriptionTxtAera.setText(collectionItemDo.getResource().getDescription());
	}

	public void displayResourceInfo() {
		String url = collectionItemDo.getResource().getUrl();
		urlTextLbl.setText(url);
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
		
		if (category.equalsIgnoreCase("Video")||category.equalsIgnoreCase("Videos")) {
			resourceCategoryLabel.setText(GL0918);
			categorypanel.setStyleName(video.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
			
		} else if (category.equalsIgnoreCase("Interactive")) {
			resourceCategoryLabel.setText(GL0919);
			categorypanel.setStyleName(interactive.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
		} else if (category.equalsIgnoreCase("Website")||category.equalsIgnoreCase("websites")||category.equalsIgnoreCase("webpage")) {
			resourceCategoryLabel.setText(GL1396);
			categorypanel.setStyleName(website.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
		}
		else if(category.equalsIgnoreCase("audio")) {
			resourceCategoryLabel.setText(GL1045);
			categorypanel.setStyleName(audio.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
		}
	//	else if((category.equalsIgnoreCase("texts")||(category.equalsIgnoreCase("Slide")||(category.equalsIgnoreCase("Handout")||(category.equalsIgnoreCase("Textbook")||(category.equalsIgnoreCase("Lesson")) {
		else if(category.equalsIgnoreCase("texts")||category.equalsIgnoreCase("text")) {
				resourceCategoryLabel.setText(GL1044);
			categorypanel.setStyleName(texts.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
		}
		else if (category.equalsIgnoreCase("image")) {
			resourceCategoryLabel.setText(GL1046);
			categorypanel.setStyleName(image.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
		}
//		else if (category.equalsIgnoreCase("other")) {
//			resourceCategoryLabel.setText(MessageProperties.GL1047);
//			categorypanel.setStyleName(other.getStyleName());
//			resourceTypePanel.setVisible(false);
//			resoureDropDownLblOpen=false;
//		} 
		else if (category.equalsIgnoreCase("Slide")) {
			resourceCategoryLabel.setText(GL1046);
			categorypanel.setStyleName(image.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
		} else if (category.equalsIgnoreCase("Handout")) {
			resourceCategoryLabel.setText(GL1044);
			categorypanel.setStyleName(texts.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
		} else if (category.equalsIgnoreCase("Textbook")) {
			resourceCategoryLabel.setText(GL1044);
			categorypanel.setStyleName(texts.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
		} else if (category.equalsIgnoreCase("Lesson")) {
			resourceCategoryLabel.setText(GL1044);
			categorypanel.setStyleName(texts.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
//		} else if (category.equalsIgnoreCase("Question")) {
//			resourceCategoryLabel.setText("Question");
//			categorypanel.setStyleName(question.getStyleName());
//			resourceTypePanel.setVisible(false);
//			resoureDropDownLblOpen=false;
		} else if (category.equalsIgnoreCase("Exam")) {
			resourceCategoryLabel.setText(GL1396);
			categorypanel.setStyleName(website.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
		}

		thumbnailUrlStr = collectionItemDo.getResource().getThumbnailUrl();
		setImage(url, category);
	}

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
	public void updateUi() {
		generateImageLbl.setVisible(false);
		setThumbnailImage.setVisible(true);

		if (urlTextLbl.getText().indexOf("youtube") != -1) {
			rightArrowLbl.setVisible(false);
		}
	}

	private class AddClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			final Map<String, String> parms = new HashMap<String, String>();
			parms.put("text", titleTextBox.getValue());
			AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {
				@Override
				public void onSuccess(Boolean value) {
						isHavingBadWordsInTextbox = value;
						if(value){
							SetStyleForProfanity.SetStyleForProfanityForTextBox(titleTextBox, mandatoryTitleLblForSwareWords,value);
						}else{
							parms.put("text", descriptionTxtAera.getText());
							AppClientFactory.getInjector().getResourceService().checkProfanity(parms,new SimpleAsyncCallback<Boolean>() {
								
								@Override
								public void onSuccess(Boolean result) {
									isHavingBadWordsInRichText=result;
									if(result){
										SetStyleForProfanity.SetStyleForProfanityForTextArea(descriptionTxtAera, mandatoryDescLblForSwareWords, result);
									}else{
										if (!isHavingBadWordsInRichText && !isHavingBadWordsInTextbox) {
											boolean isValidate = true;
											
											String titleStr = titleTextBox.getText().trim();
											String categoryStr =resourceCategoryLabel.getText();// resourceTypeListBox.getItemText(resourceTypeListBox.getSelectedIndex());
											
											String urlStr = urlTextLbl.getText().trim();
											String youTubeId = getYoutubeVideoId(urlStr);

											
											if (titleStr.toLowerCase().contains("http://") || titleStr.toLowerCase().contains("https://") || titleStr.toLowerCase().contains("ftp://")){
												mandatoryTitleLbl.setText(GL0323);
												mandatoryTitleLbl.setVisible(true);
												isValidate = false;
											}
											
											if(!rightsChkBox.getValue()){
												rightsLbl.getElement().getStyle().setColor("orange");
												isValidate = false;
											}
											if (titleStr == null || titleStr.equalsIgnoreCase("")) {
												mandatoryTitleLbl.setText(GL0173);
												mandatoryTitleLbl.setVisible(true);
												isValidate = false;
											}
											if (categoryStr == null
													|| categoryStr.equalsIgnoreCase("-1")
													|| categoryStr
															.equalsIgnoreCase("Choose a resource format")) {
												mandatoryCategoryLbl.setText(GL0917);
												mandatoryCategoryLbl.setVisible(true);
												isValidate = false;
											}
											
											if(urlStr.indexOf("youtube")!=-1){
												if(youTubeId==null || youTubeId.equalsIgnoreCase("null") || youTubeId.equalsIgnoreCase("")){
													if(!categoryStr.equalsIgnoreCase("Webpage")){
														mandatoryCategoryLbl.setText(GL0927);
														mandatoryCategoryLbl.setVisible(true);
														isValidate = false;
													}else{
														isValidate = true;
													}
												}
											}

											if (isValidate) {
												saveButtonContainer.setVisible(false);
												loadingTextLbl.setVisible(true);
												collectionItemDo.getResource().setTitle(titleStr);
												collectionItemDo.getResource().setDescription(descriptionTxtAera.getText().trim());
												if(categoryStr.contains("Videos")||categoryStr.contains("Interactives")||categoryStr.contains("Images")||categoryStr.contains("Texts"))
												{
													categoryStr=categoryStr.substring(0, categoryStr.length()-1);
													/* if(categoryStr.contains("Image")||categoryStr.contains("Images")){
														 categoryStr="Slide";
													 }*/
												}
												collectionItemDo.getResource().setCategory(categoryStr);
												
												if (thumbnailUrlStr!=null){
													collectionItemDo.getResource().getThumbnails().setUrl(thumbnailUrlStr);
												}else{
													collectionItemDo.getResource().getThumbnails().setUrl(null);
												}
												collectionItemDo.getResource().setUrl(urlStr);
												updateResource(collectionItemDo);
											}
										}
									}
								}
							});
						}
				}
			});
		}
	}

	private class OnEditImageClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			resourceImageUpload();
		}
	}

	public abstract void resourceImageUpload();

	private class TitleKeyUpHandler implements KeyUpHandler {

		public void onKeyUp(KeyUpEvent event) {
			mandatoryTitleLbl.setVisible(false);
			if (titleTextBox.getText().length() >= 50) {
				mandatoryTitleLbl.setText(GL0143);
				mandatoryTitleLbl.setVisible(true);
			}
		}
	}

	private class DescriptionKeyUpHandler implements KeyUpHandler {

		public void onKeyUp(KeyUpEvent event) {
			descCharcterLimit.setVisible(false);
			if (descriptionTxtAera.getText().length() >= 300) {
				descriptionTxtAera.setText(descriptionTxtAera.getText().trim().substring(0,300));
				descCharcterLimit.setVisible(true);
			}
		}
	}

	@UiHandler("leftArrowLbl")
	void leftArrowClick(ClickEvent event) {
		activeImageIndex--;
		setImageThumbnail();
	}

	@UiHandler("rightArrowLbl")
	void rightArrowClick(ClickEvent event) {
		activeImageIndex++;
		setImageThumbnail();
	}
	@UiHandler("videoResourcePanel")
	void videoResourcePanel(ClickEvent event){
		resourceCategoryLabel.setText(GL0918);
		//resourceCategoryLabel.setStyleName(video.getStyleName());
		categorypanel.setStyleName(video.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen=false;
	}
	@UiHandler("interactiveResourcePanel")
	void interactiveResourcePanel(ClickEvent event){
		resourceCategoryLabel.setText(GL0919);
		categorypanel.setStyleName(interactive.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen=false;
	}
	@UiHandler("websiteResourcePanel")
	void websiteResourcePanel(ClickEvent event){
		resourceCategoryLabel.setText(GL1396);
		categorypanel.setStyleName(website.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen=false;
	}
	@UiHandler("imageResourcePanel")
	void slideResourcePanel(ClickEvent event) {
		resourceCategoryLabel.setText(GL1046);
		categorypanel.setStyleName(image.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
		mandatoryCategoryLbl.setVisible(false);
	}

	@UiHandler("textResourcePanel")
	void handoutResourcePanel(ClickEvent event) {
		resourceCategoryLabel.setText(GL1044);
		categorypanel.setStyleName(texts.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
		mandatoryCategoryLbl.setVisible(false);
	}

	@UiHandler("audioResourcePanel")
	void textbookResourcePanel(ClickEvent event) {
		resourceCategoryLabel.setText(GL1045);
		categorypanel.setStyleName(audio.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
		mandatoryCategoryLbl.setVisible(false);
	}

//	@UiHandler("otherResourcePanel")
//	void lessonResourcePanel(ClickEvent event) {
//		resourceCategoryLabel.setText(MessageProperties.GL1047);
//		categorypanel.setStyleName(other.getStyleName());
//		resourceTypePanel.setVisible(false);
//		resoureDropDownLblOpen = false;
//		mandatoryCategoryLbl.setVisible(false);
//	}
	/*@UiHandler("slideResourcePanel")
	void slideResourcePanel(ClickEvent event){
		resourceCategoryLabel.setText("Slide");
		categorypanel.setStyleName(slide.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen=false;
	}
	@UiHandler("handoutResourcePanel")
	void handoutResourcePanel(ClickEvent event){
		resourceCategoryLabel.setText("Handout");
		categorypanel.setStyleName(handout.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen=false;
	}
	@UiHandler("textbookResourcePanel")
	void textbookResourcePanel(ClickEvent event){
		resourceCategoryLabel.setText("Textbook");
		categorypanel.setStyleName(textbook.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen=false;
	}
	@UiHandler("lessonResourcePanel")
	void lessonResourcePanel(ClickEvent event){
		resourceCategoryLabel.setText("Lesson");
		categorypanel.setStyleName(lesson.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen=false;
	}
//	@UiHandler("questionResourcePanel")
//	void questionResourcePanel(ClickEvent event){
//		resourceCategoryLabel.setText("Question");
//		categorypanel.setStyleName(question.getStyleName());
//		resourceTypePanel.setVisible(false);
//		resoureDropDownLblOpen=false;
//	}
	@UiHandler("examResourcePanel")
	void examResourcePanel(ClickEvent event){
		resourceCategoryLabel.setText("Exam");
		categorypanel.setStyleName(exam.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen=false;
	}*/
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

	public void setImageThumbnail() {
		if (activeImageIndex == 0) {
			leftArrowLbl.setVisible(false);
		} else {
			leftArrowLbl.setVisible(true);
		}
		if (activeImageIndex == thumbnailImagesLink.size()) {
			rightArrowLbl.setVisible(false);
		} else {
			rightArrowLbl.setVisible(true);
		}
		setThumbnailImage.setUrl(thumbnailImagesLink.get(activeImageIndex));
		thumbnailUrlStr = thumbnailImagesLink.get(activeImageIndex);
	}

	@UiHandler("refreshLbl")
	void refreshClick(ClickEvent event) {
		
		setImage(collectionItemDo.getResource()
				.getThumbnailUrl(), collectionItemDo.getResource().getCategory());
		
		leftArrowLbl.setVisible(false);
		if (urlTextLbl.getText().contains("youtube")) {
			rightArrowLbl.setVisible(false);
		}
	}

	/*public void clearFields() {
		titleTextBox.setText("");
		descriptionTxtAera.setText("");
		//resourceTypeListBox.setSelectedIndex(0);
		generateImageLbl.setVisible(true);
		setThumbnailImage.setUrl("");
	}
*/
	/*private RegExp urlValidator;
	private RegExp urlPlusTldValidator;
*/
	
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
	
	public void setFileNameWithOutRespUrl(String fileNameWithOutRespUrl ){
		this.fileNameWithOutRespUrl = fileNameWithOutRespUrl;
		rightArrowLbl.setVisible(false);
	}
	
	
	public String getYoutubeVideoId(String youtubeUrl) {

		youtubeUrl=youtubeUrl.replaceAll("feature=player_detailpage&", "");
		youtubeUrl=youtubeUrl.replaceAll("feature=player_embedded&","");


			String pattern = "^.*((youtu.be"+ "\\/)" + "|(v\\/)|(\\/u\\/w\\/)|(embed\\/)|(watch\\?))\\??v?=?([^#\\&\\?]*).*";
			String videoId = null; 
		    try {
		    	RegExp reg = RegExp.compile(pattern, "gi");
		    	MatchResult res = reg.exec(youtubeUrl);
		    	videoId = res.getGroup(7);
		    } catch (Exception e) {
		    	
			}
			return videoId;
	
	}
	public class CheckProfanityInOnBlur implements BlurHandler{
		private TextBox textBox;
		private Label label;
		private TextArea textArea;
		public CheckProfanityInOnBlur(TextBox textBox,TextArea textArea,Label label){
			this.textBox=textBox;
			this.label=label;
			this.textArea=textArea;
		}
		@Override
		public void onBlur(BlurEvent event) {
			Map<String, String> parms = new HashMap<String, String>();
			if(textBox!=null){
				parms.put("text", textBox.getValue());
			}else{
				parms.put("text", textArea.getText());
			}
			addResourceBtn.setEnabled(false);
			AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {

				@Override
				public void onSuccess(Boolean value) {
					addResourceBtn.setEnabled(true);
					if(textBox!=null){
						isHavingBadWordsInTextbox = value;
						SetStyleForProfanity.SetStyleForProfanityForTextBox(textBox, label, value);
					}else{
						isHavingBadWordsInRichText=value;
						SetStyleForProfanity.SetStyleForProfanityForTextArea(textArea, label, value);
					}
					
				}
			});
		}
	}
}
