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

import java.util.List;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.faq.CopyRightPolicyVc;
import org.ednovo.gooru.client.mvp.faq.TermsAndPolicyVc;
import org.ednovo.gooru.client.mvp.faq.TermsOfUse;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.uc.BlueButtonUc;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.content.CollectionDo;

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
/**
 * 
 * @fileName : AddWebResourceView.java
 *
 * @description :This class is used to add web resources view. 
 *
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public abstract class AddWebResourceView extends Composite {

	public interface AddWebResourceViewUiBinder extends
			UiBinder<Widget, AddWebResourceView> {

	}

	public static AddWebResourceViewUiBinder uiBinder = GWT
			.create(AddWebResourceViewUiBinder.class);

	@UiField
	public Label cancelResourcePopupBtnLbl, generateImageLbl;
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
	HTMLPanel descCharcterLimit,contentPanel,panelContentRights;

	@UiField
	public HTMLPanel addResourceBtnPanel,loadingPanel;

	@UiField
	HTMLPanel categorypanel, video, interactive, website, slide, handout,
			textbook, lesson, exam;

	@UiField
	HTMLPanel resourceTypePanel, resourceDescriptionContainer,buttonsPanel;

	@UiField
	Label resoureDropDownLbl, resourceCategoryLabel, loadingTextLbl;
	
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

	int activeImageIndex = 0;
	protected List<String> thumbnailImages;
	String thumbnailUrlStr = null;
	CollectionDo collectionDo;
	/**
	 * constructor
	 * @param collectionDo
	 */
	public AddWebResourceView(CollectionDo collectionDo) { 
		this.collectionDo = collectionDo;
		initWidget(uiBinder.createAndBindUi(this));
		cancelResourcePopupBtnLbl.addClickHandler(new CloseClickHandler());
		addResourceBtnLbl.addClickHandler(new AddClickHandler());
		uploadImageLbl.addClickHandler(new OnEditImageClick());
		uploadImageLbl.getElement().setId("lblUploadImage");
		addResourceBtnLbl.getElement().setId("btnAdd");
		urlTextBox.getElement().setId("tbUrl");
		titleTextBox.getElement().setId("tbTitle");
		cancelResourcePopupBtnLbl.getElement().setId("lblCancel");
		descriptionTxtAera.getElement().setId("taDescription");
		descriptionTxtAera.getElement().setAttribute("placeholder", "Please describe what the resource is about.");
		urlTextBox.addKeyUpHandler(new UrlKeyUpHandler());
		urlTextBox.addBlurHandler(new UrlBlurHandler());
		titleTextBox.addKeyUpHandler(new TitleKeyUpHandler());
		descriptionTxtAera.addKeyUpHandler(new DescriptionKeyUpHandler());
		titleTextBox.getElement().setAttribute("maxlength", "50");
		descriptionTxtAera.getElement().setAttribute("maxlength", "300");
		resourceCategoryLabel.setText("Choose a resource category");
		mandatoryUrlLbl.setVisible(false);
		mandatoryTitleLbl.setVisible(false);
		mandatoryCategoryLbl.setVisible(false);
		descCharcterLimit.setVisible(false);
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
				Window.open("http://support.goorulearning.org/entries/24471116-Gooru-Community-Guidelines","_blank",""); 
			}
		});
		
		
	}

	public void onLoad() {
		super.onLoad();
		urlTextBox.setFocus(true);
		clearFields();
		// resourceDescriptionContainer.clear();
		// tinyMce=new TinyMCE();
		// resourceDescriptionContainer.add(tinyMce);
	}
/**
 * 
 * @fileName : AddWebResourceView.java
 *
 * @description : This method is used to close on click
 *
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
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
	/**
	 * 
	 * @fileName : AddWebResourceView.java
	 *
	 * @description : This method is used to add resources 
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 02-Jan-2014
	 *
	 * @Author Gooru Team
	 *
	 * @Reviewer: Gooru Team
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
	public abstract void resourceImageUpload();
/**
 * This inner class will handle the click event.
 */
	private class AddClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
		
			boolean isValidate = true;

			String urlStr = urlTextBox.getText();
			urlStr = urlStr.replaceAll("feature=player_detailpage&", "");
			urlStr = urlStr.replaceAll("feature=player_embedded&", "");
			urlStr = URL.encode(urlStr);
			urlStr = urlStr.replaceAll("#", "%23");
			String youTubeId = getYoutubeVideoId(urlStr);
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
							.setText("Oops! You can't add a Gooru URL as a resource.");
					mandatoryUrlLbl.setVisible(true);
					isValidate = false;
				}
			}
			if(!rightsChkBox.getValue()){
				rightsLbl.getElement().getStyle().setColor("orange");
				isValidate = false;
			}
			if (urlStr == null || urlStr.equalsIgnoreCase("")) {
				mandatoryUrlLbl.setText("Please enter a URL.");
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
				mandatoryTitleLbl.setText("Title cannot be a URL.");
				mandatoryTitleLbl.setVisible(true);
				isValidate = false;
			}

			if (titleStr == null || titleStr.equalsIgnoreCase("")) {
				mandatoryTitleLbl.setText("Please enter a title.");
				mandatoryTitleLbl.setVisible(true);
				isValidate = false;
			}
			if (categoryStr == null
					|| categoryStr.equalsIgnoreCase("-1")
					|| categoryStr
							.equalsIgnoreCase("Choose a resource category")) {
				mandatoryCategoryLbl.setText("Please choose a category.");
				mandatoryCategoryLbl.setVisible(true);
				isValidate = false;
			}

			if (!isValidYoutubeUrlFlag && categoryStr.equalsIgnoreCase("Video")) {
				mandatoryCategoryLbl
						.setText("Thats a Playlist/Channel. Please choose another category.");
				mandatoryCategoryLbl.setVisible(true);
				isValidate = false;

			}

			if (!isValidUrl(urlStr, true)) {
				mandatoryUrlLbl.setText("Please enter a valid URL.");
				mandatoryUrlLbl.setVisible(true);
				isValidate = false;
			}
			if(urlStr.indexOf("youtube")!=-1){
				if(youTubeId==null || youTubeId.equalsIgnoreCase("null") || youTubeId.equalsIgnoreCase("")){
					if(!categoryStr.equalsIgnoreCase("Website")){
						mandatoryCategoryLbl.setText("Looks like this is a Playlist not a video! Please select Website.");
						mandatoryCategoryLbl.setVisible(true);
						isValidate = false;
					}
				}
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
				}
				
			}
		}
	}

	
	public abstract void addResource(String idStr, String urlStr,	String titleStr, String descriptionStr, String categoryStr,	String thumbnailUrlStr, Integer endTime, boolean conformationFlag);

//	public abstract void addResource(String idStr, String urlStr,	String titleStr, String descriptionStr, String categoryStr,	String thumbnailUrlStr, Integer endTime);
	/**
	 * This inner class will handle the blur event.
	 */
	private class UrlBlurHandler implements BlurHandler {

		@Override
		public void onBlur(BlurEvent event) {
			addResourceBtnLbl.setVisible(true);
			addResourceBtnPanel.setVisible(true);
			String userUrlStr = urlTextBox.getText().trim();

			if (userUrlStr.contains("goorulearning.org")) {
				if (userUrlStr.contains("support.goorulearning.org")
						|| userUrlStr.contains("about.goorulearning.org")) {

				} else {
					mandatoryUrlLbl
							.setText("Oops! You can't add a Gooru URL as a resource.");
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
					mandatoryUrlLbl.setText("Please enter a valid URL.");
					mandatoryUrlLbl.setVisible(true);
				}
			}
		}
	}

	public abstract void getResourceInfo(String userUrlStr);

	public abstract void checkShortenUrl(String userUrlStr);
	/**
	 * This inner class will handle the Key up event.
	 */
	private class UrlKeyUpHandler implements KeyUpHandler {

		public void onKeyUp(KeyUpEvent event) {

			mandatoryUrlLbl.setVisible(false);
		}
	}
	/**
	 * This inner class will handle the key up event.
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
	 * This inner class will handle the key up event.
	 */
	private class DescriptionKeyUpHandler implements KeyUpHandler {
		public void onKeyUp(KeyUpEvent event) {
			descCharcterLimit.setVisible(false);
			if (descriptionTxtAera.getText().length() >= 300) {
				descriptionTxtAera.setText(descriptionTxtAera.getText().trim()
						.substring(0, 300));
				descCharcterLimit.setVisible(true);
			}

		}
	}
/**
 * 
 * @function leftArrowClick 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :this will handle the click on left arrow
 * 
 * 
 * @parm(s) : @param event
 * 
 * @return : void
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	@UiHandler("leftArrowLbl")
	void leftArrowClick(ClickEvent event) {
		activeImageIndex--;
		setImageThumbnail();
	}
/**
 * 
 * @function rightArrowClick 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :@description :this will handle the click on right arrow
 * 
 * 
 * @parm(s) : @param event
 * 
 * @return : void
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	@UiHandler("rightArrowLbl")
	void rightArrowClick(ClickEvent event) {
		activeImageIndex++;
		setImageThumbnail();
	}
/**
 * 
 * @function videoResourcePanel 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :this will handle the click event on video resource panel
 * 
 * 
 * @parm(s) : @param event
 * 
 * @return : void
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	@UiHandler("videoResourcePanel")
	void videoResourcePanel(ClickEvent event) {
		resourceCategoryLabel.setText("Video");
		categorypanel.setStyleName(video.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
		mandatoryCategoryLbl.setVisible(false);
	}
/**
 * 
 * @function interactiveResourcePanel 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :this will handle the click event on interactive resource panel
 * 
 * 
 * @parm(s) : @param event
 * 
 * @return : void
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	@UiHandler("interactiveResourcePanel")
	void interactiveResourcePanel(ClickEvent event) {
		resourceCategoryLabel.setText("Interactive");
		categorypanel.setStyleName(interactive.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
		mandatoryCategoryLbl.setVisible(false);
	}
/**
 * 
 * @function websiteResourcePanel 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :this will handle the click event on web site resource panel
 * 
 * 
 * @parm(s) : @param event
 * 
 * @return : void
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	@UiHandler("websiteResourcePanel")
	void websiteResourcePanel(ClickEvent event) {
		resourceCategoryLabel.setText("Website");
		categorypanel.setStyleName(website.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
		mandatoryCategoryLbl.setVisible(false);
	}
/**
 * 
 * @function slideResourcePanel 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :this will handle the click event on slide resource panel
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
	void slideResourcePanel(ClickEvent event) {
		resourceCategoryLabel.setText("Slide");
		categorypanel.setStyleName(slide.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
		mandatoryCategoryLbl.setVisible(false);
	}
/**
 * 
 * @function handoutResourcePanel 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :this will handle the click event on hand out resource panel
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
	void handoutResourcePanel(ClickEvent event) {
		resourceCategoryLabel.setText("Handout");
		categorypanel.setStyleName(handout.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
		mandatoryCategoryLbl.setVisible(false);
	}
/**
 * 
 * @function textbookResourcePanel 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :this will handle the click event on text book resource panel
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
	void textbookResourcePanel(ClickEvent event) {
		resourceCategoryLabel.setText("Textbook");
		categorypanel.setStyleName(textbook.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
		mandatoryCategoryLbl.setVisible(false);
	}
/**
 * 
 * @function lessonResourcePanel 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :this will handle the click event on lesson resource panel
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
	void lessonResourcePanel(ClickEvent event) {
		resourceCategoryLabel.setText("Lesson");
		categorypanel.setStyleName(lesson.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
		mandatoryCategoryLbl.setVisible(false);
	}

	// @UiHandler("questionResourcePanel")
	// void questionResourcePanel(ClickEvent event){
	// resourceCategoryLabel.setText("Question");
	// categorypanel.setStyleName(question.getStyleName());
	// resourceTypePanel.setVisible(false);
	// resoureDropDownLblOpen=false;
	// mandatoryCategoryLbl.setVisible(false);
	// }
	/**
	 * 
	 * @function examResourcePanel 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :this will handle the click event on exam resource panel
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("examResourcePanel")
	void examResourcePanel(ClickEvent event) {
		resourceCategoryLabel.setText("Exam");
		categorypanel.setStyleName(exam.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen = false;
		mandatoryCategoryLbl.setVisible(false);
	}
/**
 * 
 * @function dropDownClick 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :this will handle the click event on  resource drop down
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
	public void dropDownClick(ClickEvent event) {
		if (resoureDropDownLblOpen == false) {
			resourceTypePanel.setVisible(true);
			resoureDropDownLblOpen = true;

		} else {
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen = false;
		}

	}
/**
 * 
 * @function setImageThumbnail 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :This method will set thumbnail image
 * 
 * 
 * @parm(s) : 
 * 
 * @return : void
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
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
/**
 * 
 * @function refreshClick 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :this will handle the click event on refresh label
 * 
 * 
 * @parm(s) : @param event
 * 
 * @return : void
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
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
	/**
	 * 
	 * @function clearFields 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :this method will clear the fields
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
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
		resourceCategoryLabel.setText("Choose a resource category");
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


/**
 * This method will set the visibility
 */
	public void setVisible(boolean visible) {
		addResourceBtnLbl.setVisible(visible);
		addResourceBtnPanel.setVisible(visible);
	}

	private RegExp urlValidator;
	private RegExp urlPlusTldValidator;
/**
 * 
 * @function isValidUrl 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :This method will check for valid url
 * 
 * 
 * @parm(s) : @param url
 * @parm(s) : @param topLevelDomainRequired
 * @parm(s) : @return
 * 
 * @return : boolean
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
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
	/**
	 * 
	 * @function getYoutubeVideoId 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method will return You tube id
	 * 
	 * 
	 * @parm(s) : @param youtubeUrl
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
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
	
	
	/** 
	 * This method is to get the shorten url
	 */
	public boolean isShortenedUrl() {
		return isShortenedUrl;
	}
	/** 
	 * This method is to set the shorten url
	 */
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
}
