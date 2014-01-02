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

import java.util.List;

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

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.FontStyle;
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
/**
 * @fileName : EditResourcePopupVc.java
 *
 * @description : This class is used to display  edit resource popup.
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public abstract class EditResourcePopupVc extends AppPopUp {

	CollectionItemDo collectionItemDo;

	@UiField
	public Button addResourceBtn;
	
	@UiField
	public Label generateImageLbl;

	@UiField
	Label mandatoryUrlLbl, mandatoryTitleLbl;

	@UiField
	Label mandatoryCategoryLbl, urlTextLbl;

	@UiField
	Label leftArrowLbl, rightArrowLbl, uploadImageLbl;

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
	HTMLPanel descCharcterLimit,saveButtonContainer,panelContentRights,rightsContainer;
	
	@UiField Label resourceCategoryLabel,loadingTextLbl,rightsLbl;
	
	 @UiField HTMLPanel categorypanel,video,interactive,website,slide,handout,textbook,lesson,exam,resourceTypePanel;
	 @UiField CheckBox rightsChkBox;
	 @UiField Anchor copyRightAnr;
	 @UiField Anchor termsAndPolicyAnr,privacyAnr;
	@UiField Anchor commuGuideLinesAnr;
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

	private static EditResourcePopupVcUiBinder uiBinder = GWT
			.create(EditResourcePopupVcUiBinder.class);

	interface EditResourcePopupVcUiBinder extends
			UiBinder<Widget, EditResourcePopupVc> {
	}

	public abstract void updateResource(CollectionItemDo collectionItemDo);
	/**
	 * Class constructor.
	 * @param collectionItemDo
	 */
	public EditResourcePopupVc(CollectionItemDo collectionItemDo) {
		super();
		// this.getElement().getStyle().setWidth(450, Unit.PX);
		// this.getElement().getStyle().setHeight(788, Unit.PX);
		this.collectionItemDo = collectionItemDo;
		setContent("Edit Resource", uiBinder.createAndBindUi(this));

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
	 * This will handle the mouse over event on content rights label.
	 */
	@UiHandler("lblContentRights")
	public void onMouseOver(MouseOverEvent event){
		panelContentRights.setVisible(true);
	}
	/**
	 * This will handle the mouse out event on content rights label.
	 */
	@UiHandler("lblContentRights")
	public void onMouseOut(MouseOutEvent event){
		panelContentRights.setVisible(false);
	}
	/**
	 * This will handle the click event on cancel button in the resoruce popup.
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
	 * @description : This method is used to get the resource meta info.
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
		setThumbnailImages(result.getImages());
		updateUi();
		rightArrowLbl.setVisible(true);
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
	 * This method is used to set the thumbnail images.
	 */
	private void setThumbnailImages(List<String> images) {
		thumbnailImagesLink = images;
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
		if (category.equalsIgnoreCase("Video")) {
			resourceCategoryLabel.setText("Video");
			categorypanel.setStyleName(video.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
			
		} else if (category.equalsIgnoreCase("Interactive")) {
			resourceCategoryLabel.setText("Interactive");
			categorypanel.setStyleName(interactive.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
		} else if (category.equalsIgnoreCase("Website")) {
			resourceCategoryLabel.setText("Website");
			categorypanel.setStyleName(website.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
		} else if (category.equalsIgnoreCase("Slide")) {
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
		} else if (category.equalsIgnoreCase("Exam")) {
			resourceCategoryLabel.setText("Exam");
			categorypanel.setStyleName(exam.getStyleName());
			resourceTypePanel.setVisible(false);
			resoureDropDownLblOpen=false;
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
		generateImageLbl.setVisible(false);
		setThumbnailImage.setVisible(true);

		if (urlTextLbl.getText().indexOf("youtube") != -1) {
			rightArrowLbl.setVisible(false);
		}
	}
	/**
	 * This inner class is used to handle the click events.
	 */
	private class AddClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {

			boolean isValidate = true;

			String descriptionStr = descriptionTxtAera.getText().trim();
			String titleStr = titleTextBox.getText().trim();
			String categoryStr =resourceCategoryLabel.getText();// resourceTypeListBox.getItemText(resourceTypeListBox.getSelectedIndex());
			String idStr = "";
			String urlStr = urlTextLbl.getText().trim();
			String youTubeId = getYoutubeVideoId(urlStr);

			
			if (titleStr.toLowerCase().contains("http://") || titleStr.toLowerCase().contains("https://") || titleStr.toLowerCase().contains("ftp://")){
				mandatoryTitleLbl.setText("Title cannot be a URL.");
				mandatoryTitleLbl.setVisible(true);
				isValidate = false;
			}
			
			if(!rightsChkBox.getValue()){
				rightsLbl.getElement().getStyle().setColor("orange");
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
			
			if(urlStr.indexOf("youtube")!=-1){
				if(youTubeId==null || youTubeId.equalsIgnoreCase("null") || youTubeId.equalsIgnoreCase("")){
					if(!categoryStr.equalsIgnoreCase("Website")){
						mandatoryCategoryLbl.setText("Looks like this is a Playlist not a video! Please select Website.");
						mandatoryCategoryLbl.setVisible(true);
						isValidate = false;
					}
				}
			}

			if (isValidate) {
				saveButtonContainer.setVisible(false);
				loadingTextLbl.setVisible(true);
				collectionItemDo.getResource().setTitle(titleStr);
				collectionItemDo.getResource().setDescription(descriptionTxtAera.getText().trim());
				collectionItemDo.getResource().setCategory(categoryStr);
				
				if (thumbnailUrlStr!=null){
					collectionItemDo.getResource().getThumbnails().setUrl(thumbnailUrlStr);
				}else{
					collectionItemDo.getResource().getThumbnails().setUrl(null);
				}
				
				updateResource(collectionItemDo);
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
				descCharcterLimit.setVisible(true);
			}
		}
	}
	/**
	 * @function leftArrowClick 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This will handle the click event on left arrow.
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
	 * @function rightArrowClick 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : this will handle the click event on right arrow.
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
	 * @function videoResourcePanel 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This will handle the click event on video resource panel.
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("videoResourcePanel")
	void videoResourcePanel(ClickEvent event){
		resourceCategoryLabel.setText("Video");
	//	resourceCategoryLabel.setStyleName(video.getStyleName());
		categorypanel.setStyleName(video.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen=false;
	}
	/**
	 * @function interactiveResourcePanel 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This will handle the click event on interactive resource panel.
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
	void interactiveResourcePanel(ClickEvent event){
		resourceCategoryLabel.setText("Interactive");
		categorypanel.setStyleName(interactive.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen=false;
	}
	/**
	 * @function websiteResourcePanel 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This will handle the click event on website resource panel.
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
	void websiteResourcePanel(ClickEvent event){
		resourceCategoryLabel.setText("Website");
		categorypanel.setStyleName(website.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen=false;
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
//	@UiHandler("questionResourcePanel")
//	void questionResourcePanel(ClickEvent event){
//		resourceCategoryLabel.setText("Question");
//		categorypanel.setStyleName(question.getStyleName());
//		resourceTypePanel.setVisible(false);
//		resoureDropDownLblOpen=false;
//	}
	/**
	 * 
	 * @function examResourcePanel 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This will handle the click event on exam resource panel.
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
	void examResourcePanel(ClickEvent event){
		resourceCategoryLabel.setText("Exam");
		categorypanel.setStyleName(exam.getStyleName());
		resourceTypePanel.setVisible(false);
		resoureDropDownLblOpen=false;
	}
	/**
	 * @function dropDownClick 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This will handle the click event on resource drop down label.
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
	/**
	 * @function setImageThumbnail 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method is used to set thumbnail images.
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
	/**
	 * @function refreshClick 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This will handle the click event on refresh label.
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
	/** 
	 * This method is to set file name with out resp url
	 */
	public void setFileNameWithOutRespUrl(String fileNameWithOutRespUrl ){
		this.fileNameWithOutRespUrl = fileNameWithOutRespUrl;
		rightArrowLbl.setVisible(false);
	}
	
	/**
	 * @function getYoutubeVideoId 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This method is used to get youtube video id.
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
}
