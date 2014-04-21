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
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.faq.CopyRightPolicyVc;
import org.ednovo.gooru.client.mvp.faq.TermsAndPolicyVc;
import org.ednovo.gooru.client.mvp.faq.TermsOfUse;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.uc.BlueButtonUc;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.client.util.SetStyleForProfanity;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.FontStyle;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.http.client.URL;
import com.google.gwt.regexp.shared.MatchResult;
import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public abstract class AddWebResourceView extends Composite implements MessageProperties{

	public interface AddWebResourceViewUiBinder extends
			UiBinder<Widget, AddWebResourceView> {

	}

	public static AddWebResourceViewUiBinder uiBinder = GWT
			.create(AddWebResourceViewUiBinder.class);

	@UiField
	public Label cancelResourcePopupBtnLbl, generateImageLbl,agreeText,andText,additionalText;
	@UiField
	public BlueButtonUc addResourceBtnLbl;

	@UiField
	Label mandatoryUrlLbl, mandatoryTitleLbl,rightsLbl;

	@UiField
	Label mandatoryCategoryLbl;
	@UiField
	HTMLEventPanel refreshLbl,lblContentRights;
	@UiField
	Label leftArrowLbl, rightArrowLbl, uploadImageLbl;

	@UiField
	public TextBox urlTextBox, titleTextBox;

	@UiField
	public TextArea descriptionTxtAera;

	// @UiField public ListBox resourceTypeListBox;

	@UiField
	public Image setThumbnailImage;
	// Drop down for Resource Type//
	@UiField
	HTMLPanel descCharcterLimit,contentPanel,panelContentRights,titleText,categoryTitle,orText,refreshText;

	@UiField
	public HTMLPanel addResourceBtnPanel,loadingPanel,urlTitle,descriptionLabel,videoLabel,interactiveText,websiteText,imagesText,textsText,audioText;//otherText

	@UiField
	HTMLPanel categorypanel, video, interactive, website,thumbnailText,audio,texts,image;//other

	@UiField
	HTMLPanel resourceTypePanel, resourceDescriptionContainer,buttonsPanel;

	@UiField
	Label resoureDropDownLbl, resourceCategoryLabel, loadingTextLbl,mandatoryDescLblForSwareWords,mandatoryTitleLblForSwareWords;
	
	@UiField
	CheckBox rightsChkBox;
	@UiField
	Anchor copyRightAnr;
	
	@UiField
	Anchor termsAndPolicyAnr,privacyAnr;
	
	@UiField
	Anchor commuGuideLinesAnr;
		
	Integer videoDuration=0;
	private CopyRightPolicyVc copyRightPolicy;
	
	private TermsAndPolicyVc termsAndPolicyVc;
	private TermsOfUse termsOfUse;
	// public TinyMCE tinyMce=null; 
	public boolean isValidYoutubeUrlFlag = true;

	public boolean resoureDropDownLblOpen = false;
	
	private boolean isShortenedUrl;
	
	boolean isValidate = true;

	int activeImageIndex = 0;
	protected List<String> thumbnailImages;
	String thumbnailUrlStr = null;
	CollectionDo collectionDo;
	boolean isHavingBadWordsInTextbox=false,isHavingBadWordsInRichText=false;
	private static final String RESOURCE_UPLOAD_FILE_PATTERN = "([^\\s]+([^?#]*\\.(?:mp3))$)";
		
	public AddWebResourceView(CollectionDo collectionDo) { 
		this.collectionDo = collectionDo;
		initWidget(uiBinder.createAndBindUi(this));
		urlTitle.getElement().setInnerHTML(GL0915);
		titleText.getElement().setInnerHTML(GL0318+GL_SPL_STAR);
		descriptionLabel.getElement().setInnerHTML(GL0904);
		categoryTitle.getElement().setInnerHTML(GL0906);
		videoLabel.getElement().setInnerHTML(GL0918);
		interactiveText.getElement().setInnerHTML(GL0919);
		websiteText.getElement().setInnerHTML(GL1396);
		/*slideText.getElement().setInnerHTML(GL0908);
		handoutText.getElement().setInnerHTML(GL0907);
		textbookLabel.getElement().setInnerHTML(GL0909);
		lessonText.getElement().setInnerHTML(GL0910);
		examText.getElement().setInnerHTML(GL0921);*/
		textsText.getElement().setInnerHTML(GL1044);
		audioText.getElement().setInnerHTML(GL1045);
		imagesText.getElement().setInnerHTML(GL1046);
//		otherText.getElement().setInnerHTML(GL1047);
		
		
		thumbnailText.getElement().setInnerHTML(GL0911);
		generateImageLbl.setText(GL0922);
		orText.getElement().setInnerHTML(GL_GRR_Hyphen+GL0209+GL_GRR_Hyphen);
		uploadImageLbl.setText(GL0912);
		refreshText.getElement().setInnerHTML(GL0923);
		rightsLbl.setText(GL0869);
		addResourceBtnLbl.setText(GL0590);
		cancelResourcePopupBtnLbl.setText(GL0142);
		loadingTextLbl.setText(GL0591.toLowerCase());
		cancelResourcePopupBtnLbl.addClickHandler(new CloseClickHandler());
		addResourceBtnLbl.addClickHandler(new AddClickHandler());
		uploadImageLbl.addClickHandler(new OnEditImageClick());
		uploadImageLbl.getElement().setId("lblUploadImage");
		addResourceBtnLbl.getElement().setId("btnAdd");
		urlTextBox.getElement().setId("tbUrl");
		titleTextBox.getElement().setId("tbTitle");
		cancelResourcePopupBtnLbl.getElement().setId("lblCancel");
		descriptionTxtAera.getElement().setId("taDescription");
		descriptionTxtAera.getElement().setAttribute("placeholder", GL0359);
		urlTextBox.addKeyUpHandler(new UrlKeyUpHandler());
		urlTextBox.addBlurHandler(new UrlBlurHandler());
		titleTextBox.addKeyUpHandler(new TitleKeyUpHandler());
		descriptionTxtAera.addKeyUpHandler(new DescriptionKeyUpHandler());
		titleTextBox.getElement().setAttribute("maxlength", "50");
		descriptionTxtAera.getElement().setAttribute("maxlength", "300");
		resourceCategoryLabel.setText(GL0360);
		mandatoryUrlLbl.setVisible(false);
		mandatoryTitleLbl.setVisible(false);
		mandatoryTitleLblForSwareWords.setVisible(false);
		mandatoryDescLblForSwareWords.setVisible(false);
		mandatoryCategoryLbl.setVisible(false);
		descCharcterLimit.getElement().setInnerText(GL0143);
		descCharcterLimit.setVisible(false);
		agreeText.setText(GL0870);
		commuGuideLinesAnr.setText(GL0871);
		termsAndPolicyAnr.setText(" "+GL0872+GL_GRR_COMMA);
		privacyAnr.setText(" "+GL0873);
		andText.setText(" "+GL_GRR_AND+" ");
		copyRightAnr.setText(" "+GL0875);
		additionalText.setText(GL0874);
		leftArrowLbl.setVisible(false);
		rightArrowLbl.setVisible(false);
		setThumbnailImage.setVisible(false);
		loadingTextLbl.getElement().getStyle().setFontStyle(FontStyle.ITALIC);
		resourceTypePanel.setVisible(false);
		loadingPanel.setVisible(false);
		panelContentRights.setVisible(false);
		rightsChkBox.addClickHandler(new rightsChecked());
		rightsChkBox.getElement().setId("chkRights");
		clearFields();
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

	public void onLoad() {
		super.onLoad();
		urlTextBox.setFocus(true);
		clearFields();
		// resourceDescriptionContainer.clear();
		// tinyMce=new TinyMCE();
		// resourceDescriptionContainer.add(tinyMce);
	}

	private class CloseClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			clearFields();
			hidePopup();
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
	public abstract void hidePopup();

	private class OnEditImageClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			// getUiHandlers().resourceImageUpload();
			resourceImageUpload();
		}
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
	public abstract void resourceImageUpload();

	private class AddClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			addResourceBtnLbl.setEnabled(false);
			final Map<String, String> parms = new HashMap<String, String>();
			parms.put("text", titleTextBox.getValue());
			AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {
				@Override
				public void onSuccess(Boolean value) {
						isHavingBadWordsInTextbox = value;
						if(value){
							SetStyleForProfanity.SetStyleForProfanityForTextBox(titleTextBox, mandatoryTitleLblForSwareWords,value);
							addResourceBtnLbl.setEnabled(true);
						}else{
							parms.put("text", descriptionTxtAera.getText());
							AppClientFactory.getInjector().getResourceService().checkProfanity(parms,new SimpleAsyncCallback<Boolean>() {
								
								@Override
								public void onSuccess(Boolean result) {
									isValidate = true;
									isHavingBadWordsInRichText=result;
									if(result){
										SetStyleForProfanity.SetStyleForProfanityForTextArea(descriptionTxtAera, mandatoryDescLblForSwareWords, result);
										addResourceBtnLbl.setEnabled(true);
									}else{
										if (!isHavingBadWordsInRichText && !isHavingBadWordsInTextbox) {
											
											String urlStr = urlTextBox.getText();
											urlStr = urlStr.replaceAll("feature=player_detailpage&", "");
											urlStr = urlStr.replaceAll("feature=player_embedded&", "");
											urlStr = URL.encode(urlStr);
											urlStr = urlStr.replaceAll("#", "%23");
											String youTubeId = getYoutubeVideoId(urlStr);
											System.out.println("youTubeId :"+youTubeId);
											if (urlStr.endsWith("/")) {
												urlStr = urlStr.substring(0, urlStr.length() - 1);
											}

											String descriptionStr = descriptionTxtAera.getText().trim(); // tinyMce.getText().trim();
											String titleStr = titleTextBox.getText().trim();
											String categoryStr = resourceCategoryLabel.getText();// resourceTypeListBox.getItemText(resourceTypeListBox.getSelectedIndex());
											String idStr = "";

											if (urlStr.contains("goorulearning.org")) {
												if (urlStr.contains("support.goorulearning.org")
														|| urlStr.contains("about.goorulearning.org")) {
													isValidate = true;
												} else {
													mandatoryUrlLbl
															.setText(GL0924);
													mandatoryUrlLbl.setVisible(true);
													isValidate = false;
												}
											}
											if(!rightsChkBox.getValue()){
												rightsLbl.getElement().getStyle().setColor("orange");
												isValidate = false;
											}
											if (urlStr == null || urlStr.equalsIgnoreCase("")) {
												mandatoryUrlLbl.setText(GL0916);
												mandatoryUrlLbl.setVisible(true);
												isValidate = false;
											} else {
												boolean isStartWithHttp = urlStr.matches("^(http|https)://.*$");
												if (!isStartWithHttp) {
													urlStr = "http://" + urlStr;
													urlTextBox.setText(urlStr);
												}
											}

											if (titleStr.toLowerCase().contains("www.")
													|| titleStr.toLowerCase().contains("http://")
													|| titleStr.toLowerCase().contains("https://")
													|| titleStr.toLowerCase().contains("ftp://")) {
												mandatoryTitleLbl.setText(GL0323);
												mandatoryTitleLbl.setVisible(true);
												isValidate = false;
											}

											if (titleStr == null || titleStr.equalsIgnoreCase("")) {
												mandatoryTitleLbl.setText(GL0173);
												mandatoryTitleLbl.setVisible(true);
												isValidate = false;
											}
											if (descriptionStr.length() >300) {
												descCharcterLimit.setVisible(true);
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

											if (!isValidYoutubeUrlFlag && categoryStr.equalsIgnoreCase("Video")) {
												mandatoryCategoryLbl
														.setText(GL0925);
												mandatoryCategoryLbl.setVisible(true);
												isValidate = false;

											}

											if (!isValidUrl(urlStr, true)) {
												mandatoryUrlLbl.setText(GL0926);
												mandatoryUrlLbl.setVisible(true);
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
											if(categoryStr.equalsIgnoreCase("Audio") && !hasValidateResource())
											{
												mandatoryUrlLbl.setText(GL1161);
												mandatoryUrlLbl.setVisible(true);
												isValidate = false;
											}
											
											//AreYouSurceToolTip AreYouSurceToolTip=new AreYouSurceToolTip();
											if (isValidate && !isShortenedUrl()) {
												MixpanelUtil.Create_NewResource();
												// getUiHandlers().addResource(idStr, urlStr, titleStr,
												// descriptionStr, categoryStr, thumbnailUrlStr);
												loadingTextLbl.getElement().getStyle().setDisplay(Display.BLOCK);
												buttonsPanel.getElement().getStyle().setDisplay(Display.NONE);
												descriptionStr = descriptionTxtAera.getText().trim();
												// String descriptionStr ="";
												urlStr = urlStr.replaceAll("feature=player_detailpage&", "");
												urlStr = urlStr.replaceAll("feature=player_embedded&", "");
												if(collectionDo.getSharing().equalsIgnoreCase("public")){
													
													addResource(idStr, urlStr, titleStr, descriptionStr,categoryStr, thumbnailUrlStr, getVideoDuration(),true);
													addResourceBtnLbl.setEnabled(true);
													/*WebResourcePreview webResourcePreview = new WebResourcePreview() {
														
														@Override
														public void showAddResourcePopup() {
															
														}
														
														@Override
														public void closeAppPopUp() {
															
														}
														
														@Override
														public void addWebResource() {
															
														}
													};
													webResourcePreview.filePathValueLbl.setText(urlStr);
													webResourcePreview.resourceTitleValueLbl.setText(titleStr);
													webResourcePreview.descriptionTxtValueLbl.setText(descriptionStr);
													webResourcePreview.categoryValueLbl.setText(categoryStr);
													if(thumbnailUrlStr!=null){
														webResourcePreview.setThumbnailImage.setUrl(thumbnailUrlStr);
													}else{
														webResourcePreview.setThumbnailImage.setVisible(false);
														webResourcePreview.thumbnailLbl.setVisible(false);
													}
													webResourcePreview.setGlassEnabled(true);
													webResourcePreview.show();
													webResourcePreview.center();*/
													
													
												}
												else{
													addResource(idStr, urlStr, titleStr, descriptionStr,categoryStr, thumbnailUrlStr, getVideoDuration(),false);
													addResourceBtnLbl.setEnabled(true);
												}
												
											}
											addResourceBtnLbl.setEnabled(true);
										}
									}
								}
							});
						}
				}
			});
		}
	}

	public abstract void addResource(String idStr, String urlStr,	String titleStr, String descriptionStr, String categoryStr,	String thumbnailUrlStr, Integer endTime, boolean conformationFlag);

//	public abstract void addResource(String idStr, String urlStr,	String titleStr, String descriptionStr, String categoryStr,	String thumbnailUrlStr, Integer endTime);

	private class UrlBlurHandler implements BlurHandler {

		@Override
		public void onBlur(BlurEvent event) {
			final Map<String, String> parms = new HashMap<String, String>();
			parms.put("text", urlTextBox.getText().trim());
			AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {

				@Override
				public void onSuccess(Boolean value) {
					if(!value){
						addResourceBtnLbl.setVisible(true);
						addResourceBtnPanel.setVisible(true);
						String userUrlStr = urlTextBox.getText().trim();
						System.out.println("domain : "+Window.Location.getHost());
						System.out.println("domain : "+Window.Location.getHostName());
						if (userUrlStr.contains("goorulearning.org")) {
							if (userUrlStr.contains("support.goorulearning.org")
									|| userUrlStr.contains("about.goorulearning.org")) {

							} else {
								mandatoryUrlLbl
										.setText(GL0924);
								mandatoryUrlLbl.setVisible(true);
								return;
							}
						}

						if (userUrlStr.endsWith("/")) {
							userUrlStr = userUrlStr.substring(0, userUrlStr.length() - 1);
						}
						if (!userUrlStr.equalsIgnoreCase("")) {

							boolean isStartWithHttp = userUrlStr
									.matches("^(http|https)://.*$");
							if (!isStartWithHttp) {
								userUrlStr = "http://" + userUrlStr;
								urlTextBox.setText(userUrlStr);
							}

							if (isValidUrl(userUrlStr, true)) {
								userUrlStr = URL.encode(userUrlStr);
								userUrlStr = userUrlStr.replaceAll("#", "%23");
								String userUrlStr1 = userUrlStr.replaceAll(
										"feature=player_detailpage&", "");
								userUrlStr1 = userUrlStr.replaceAll(
										"feature=player_embedded&", "");
								// getResourceInfo(userUrlStr1);
								checkShortenUrl(userUrlStr);
								loadingPanel.setVisible(true);
								contentPanel.getElement().getStyle().setOpacity(0.6);

							} else {
								mandatoryUrlLbl.setText(GL0926);
								mandatoryUrlLbl.setVisible(true);
							}
						}
					}else{
						SetStyleForProfanity.SetStyleForProfanityForTextBox(urlTextBox, mandatoryUrlLbl, value);
					}
				}
			});
		}
	}

	public abstract void getResourceInfo(String userUrlStr);

	public abstract void checkShortenUrl(String userUrlStr);

	private class UrlKeyUpHandler implements KeyUpHandler {

		public void onKeyUp(KeyUpEvent event) {

			mandatoryUrlLbl.setVisible(false);
		}
	}

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
			if (descriptionTxtAera.getText().length() >=300) {
				descriptionTxtAera.setText(descriptionTxtAera.getText().trim()
						.substring(0, 300));
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
	void videoResourcePanel(ClickEvent event) {
		MixpanelUtil.mixpanelEvent("organize_add_resource_video_selected");
		resourceCategoryLabel.setText(GL0918);
		categorypanel.setStyleName(video.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
		mandatoryCategoryLbl.setVisible(false);
	}

	@UiHandler("interactiveResourcePanel")
	void interactiveResourcePanel(ClickEvent event) {
		MixpanelUtil.mixpanelEvent("organize_add_resource_interactive_selected");
		resourceCategoryLabel.setText(GL0919);
		categorypanel.setStyleName(interactive.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
		mandatoryCategoryLbl.setVisible(false);
	}

	@UiHandler("websiteResourcePanel")
	void websiteResourcePanel(ClickEvent event) {
		MixpanelUtil.mixpanelEvent("organize_add_resource_website_selected");
		resourceCategoryLabel.setText(GL1396);
		categorypanel.setStyleName(website.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
		mandatoryCategoryLbl.setVisible(false);
	}

	@UiHandler("imageResourcePanel")
	void slideResourcePanel(ClickEvent event) {
		MixpanelUtil.mixpanelEvent("organize_add_resource_image_selected");
		resourceCategoryLabel.setText(GL1046);
		categorypanel.setStyleName(image.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
		mandatoryCategoryLbl.setVisible(false);
	}

	@UiHandler("textResourcePanel")
	void handoutResourcePanel(ClickEvent event) {
		MixpanelUtil.mixpanelEvent("organize_add_resource_text_selected");
		resourceCategoryLabel.setText(GL1044);
		categorypanel.setStyleName(texts.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
		mandatoryCategoryLbl.setVisible(false);
	}

	@UiHandler("audioResourcePanel")
	void textbookResourcePanel(ClickEvent event) {
		MixpanelUtil.mixpanelEvent("organize_add_resource_audio_selected");
		resourceCategoryLabel.setText(GL1045);
		categorypanel.setStyleName(audio.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
		mandatoryCategoryLbl.setVisible(false);
	}

//	@UiHandler("otherResourcePanel")
//	void lessonResourcePanel(ClickEvent event) {
//		MixpanelUtil.mixpanelEvent("organize_add_resource_other_selected");
//		resourceCategoryLabel.setText(GL1047);
//		categorypanel.setStyleName(other.getStyleName());
//		resourceTypePanel.setVisible(false);
//		resoureDropDownLblOpen = false;
//		mandatoryCategoryLbl.setVisible(false);
//	}

	// @UiHandler("questionResourcePanel")
	// void questionResourcePanel(ClickEvent event){
	// resourceCategoryLabel.setText("Question");
	// categorypanel.setStyleName(question.getStyleName());
	// resourceTypePanel.setVisible(false);
	// resoureDropDownLblOpen=false;
	// mandatoryCategoryLbl.setVisible(false);
	// }
	/*@UiHandler("examResourcePanel")
	void examResourcePanel(ClickEvent event) {
		resourceCategoryLabel.setText(GL0921);
		//categorypanel.setStyleName(exam.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
		mandatoryCategoryLbl.setVisible(false);
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

	public void setImageThumbnail() {
		if( thumbnailImages.size()>0){
		if (activeImageIndex == 0) {
			leftArrowLbl.setVisible(false);
		} else {
			leftArrowLbl.setVisible(true);
		}
		if (thumbnailImages != null) {
			if (activeImageIndex == thumbnailImages.size()) {
				rightArrowLbl.setVisible(false);
			} else {
				rightArrowLbl.setVisible(true);
			}
			// setThumbnailImage.setUrlAndVisibleRect(thumbnailImages.get(activeImageIndex),
			// 0, 0, 80, 60);
			setThumbnailImage.getElement().setAttribute("style",
					"width: 80px;height: 60px;");
			setThumbnailImage.setUrl(thumbnailImages.get(activeImageIndex));
			thumbnailUrlStr = thumbnailImages.get(activeImageIndex);
		}
		}
		}

	@UiHandler("refreshLbl")
	void refreshClick(ClickEvent event) {
		String userUrlStr = urlTextBox.getText().trim();
		if (userUrlStr.indexOf("youtube") == -1) {
			activeImageIndex = 0;
			setImageThumbnail();
		}
	}

	/*
	 * @UiHandler("refreshlabel") void refreshlabelClick(ClickEvent event){
	 * String userUrlStr = urlTextBox.getText().trim(); if
	 * (userUrlStr.indexOf("youtube")==-1){ activeImageIndex=0;
	 * setImageThumbnail(); } }
	 */
	public void clearFields() {
		urlTextBox.setText("");
		titleTextBox.setText("");

		// if(tinyMce!=null){
		// tinyMce.setEmptyContent("");
		// }
		// try {
		// tinyMce.setEmptyContent("");
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }

		descriptionTxtAera.setText("");
		// resourceTypeListBox.setSelectedIndex(0);
		generateImageLbl.setVisible(true);
		setThumbnailImage.setUrl("");
		if (thumbnailImages != null) {
			thumbnailImages.clear();
		}
		resourceCategoryLabel.setText(GL0360);
		categorypanel.setStyleName("");

		mandatoryCategoryLbl.setVisible(false);
		mandatoryTitleLbl.setVisible(false);
		mandatoryUrlLbl.setVisible(false);
		descCharcterLimit.setVisible(false);
		loadingTextLbl.getElement().getStyle().setDisplay(Display.NONE);
		buttonsPanel.getElement().getStyle().setDisplay(Display.BLOCK);
//		buttonsPanel.setVisible(true);
//		loadingTextLbl.setVisible(false);
		setVisible(true);
	}



	public void setVisible(boolean visible) {
		addResourceBtnLbl.setVisible(visible);
		addResourceBtnPanel.setVisible(visible);
	}

	private RegExp urlValidator;
	private RegExp urlPlusTldValidator;

	public boolean isValidUrl(String url, boolean topLevelDomainRequired) {
		if (urlValidator == null || urlPlusTldValidator == null) {
			urlValidator = RegExp
					.compile("^((ftp|http|https)://[\\w@.\\-\\_\\()]+(:\\d{1,5})?(/[\\w#!:.?+=&%@!\\_\\-/\\()]+)*){1}$");
			urlPlusTldValidator = RegExp
					.compile("^((ftp|http|https)://[\\w@.\\-\\_\\()]+\\.[a-zA-Z]{2,}(:\\d{1,5})?(/[\\w#!:.?+=&%@!\\,\\_\\-/\\()]+)*){1}$");
		}
		return (topLevelDomainRequired ? urlPlusTldValidator : urlValidator)
				.exec(url) != null;
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
	
	

	public boolean isShortenedUrl() {
		return isShortenedUrl;
	}

	public void setShortenedUrl(boolean isShortenedUrl) {
		this.isShortenedUrl = isShortenedUrl;
	}

	/** 
	 * This method is to get the videoDuration
	 */
	public Integer getVideoDuration() {
		return videoDuration;
	}

	/** 
	 * This method is to set the videoDuration
	 */
	public void setVideoDuration(Integer videoDuration) {
		this.videoDuration = videoDuration;
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
				descCharcterLimit.setVisible(false);
				parms.put("text", textArea.getText());
			}
			addResourceBtnLbl.setEnabled(false);
			AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {

				@Override
				public void onSuccess(Boolean value) {
					addResourceBtnLbl.setEnabled(true);
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
	public boolean hasValidateResource(){
		String userUrlStr = urlTextBox.getText().trim();
		boolean isValid;
		if(userUrlStr.endsWith(".mp3"))
		{
			return isValid = false;	
		}
		else
		{
			return isValid = true;		
		}
		
	}
	
}
