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
/**
* @fileName : AddResourceView.java 
*
* @description :This file is a UiBinder for AddResourceView.ui.xml.
*
* @version :5.1
*
* @date: Apr 6 2013
   	
* @Author  Anil Tumbalam, Shiva Linga Reddy
* 
* @Reviewer 
*
*/

import java.util.List;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.exists.ExistsResourceView;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.CollectionEditResourceCBundle;
import org.ednovo.gooru.client.mvp.shelf.event.GetEditPageHeightEvent;
import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.client.uc.ConfirmationPopupVc;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.CollectionQuestionItemDo;
import org.ednovo.gooru.shared.model.content.ExistsResourceDo;
import org.ednovo.gooru.shared.model.content.ResourceMetaInfoDo;
import org.ednovo.gooru.shared.model.user.MediaUploadDo;
import org.ednovo.gooru.shared.util.ResourceImageUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;

public class AddResourceView extends PopupViewWithUiHandlers<AddResourceUiHandlers> implements IsAddResourceView{

	private static AddResourcePopupViewUiBinder uiBinder = GWT.create(AddResourcePopupViewUiBinder.class);

	interface AddResourcePopupViewUiBinder extends
			UiBinder<Widget, AddResourceView> {
	}
	private static final String MESSAGE_HEADER = "Are you sure?";
	private static final String MESSAGE_CONTENT = "Are you sure you want to remove the question image?";
	private AddWebResourceWidget addWebResourceWidget;
	private AddQuestionResourceWidget addQuestionResourceWidget;
	private AddSearchResourceWidget addSearchResourceWidget;
	private AddUserOwnResourceWidget addUserOwnResourceWidget;

	private DeleteConfirmationPopupVc deleteConfirmationPopup;

	private String ownResourceImgUrl;

	public AddWebResourceWidget getAddWebResourceWidget() {
		return addWebResourceWidget;
	}
	protected AppPopUp appPopUp;
	
	public UserOwnResourcePreview userOwnResourcePreview;
	
	public WebResourcePreview webResourcePreview;
	
	@UiField HTMLPanel tabViewContainer,addResourceTabContainer;
	
	@UiField Anchor fromweb,fromfile,fromwsearch,multiplechoice,truefalase,openended;

	@UiField HTMLEventPanel questionTabButton,urlTabButton,searchTabButton,trueOrFlaseButton,openEndedButton/*,multipleAnswerTabButton*//*,fillInTheBlankTabButton*/,myComputerTabButton,fillInTheBlankTabButton;

	
	@UiField Label titleLbl,addResourceCloseButton;
	
	@UiField RadioButton multipleChoiceRadioButton,trueOrFalseRadioButton,openEndedRadioButton,fillInTheBlankRadioButton/*,multipleAnswerRadioButton*//*,fillInTheBlankRadioButton*/;
	
	private ResourceMetaInfoDo resMetaInfo;
	
	private ExistsResourceView existsResource=null;
	
	@UiField CollectionEditResourceCBundle res;
	
	CollectionDo collectionDo=null;
	String title,desc,category,mediaFilename,originalFileName;
	
	String webResourceId;
	String webResourceUrl;
	String webResourceTitle;
	String webResourceDescription;
	String webResourceCategory;
	String webResourceThumbnail;
	Integer webResourceEnd; 
	
	private CollectionItemDo collectionItemDo=null;
		
	
	@Inject
	public AddResourceView(EventBus eventBus) {
		super(eventBus);
		appPopUp = new AppPopUp("type");
		appPopUp.setContent(uiBinder.createAndBindUi(this));
		tabViewContainer.clear();
		fromweb.getElement().setId("lnkFromWeb");
		fromfile.getElement().setId("lnkFromFile");
		fromwsearch.getElement().setId("lnkFromwSearch");
		multiplechoice.getElement().setId("lnkMultipleChoice");
		truefalase.getElement().setId("lnkTrueFalse");
		openended.getElement().setId("lnkOpenEnded");
		questionTabButton.addClickHandler(new showMultipleChoiceWidget());
		trueOrFlaseButton.addClickHandler(new showTrueOrFalseWidget());
		openEndedButton.addClickHandler(new showOpenEndedWidget());
		fillInTheBlankTabButton.addClickHandler(new ShowFillInTheBlanWidget());
		//multipleAnswerTabButton.addClickHandler(new ShowMultipleAnswerWidget());
		urlTabButton.addClickHandler(new ClickHandler() {	
			@Override
			public void onClick(ClickEvent event) {
				tabViewContainer.clear();
				questionTabButton.getElement().getStyle().setDisplay(Display.NONE);
				trueOrFlaseButton.getElement().getStyle().setDisplay(Display.NONE);
				openEndedButton.getElement().getStyle().setDisplay(Display.NONE);
				fillInTheBlankTabButton.getElement().getStyle().setDisplay(Display.NONE);
				addWebResourceWidget=new AddWebResourceWidget(getUiHandlers().getParentCollectionDetails());
				tabViewContainer.add(addWebResourceWidget);
				urlTabButton.setStyleName(res.css().buttonSelected());
				questionTabButton.setStyleName(res.css().buttonDeSelected());
				searchTabButton.setStyleName(res.css().buttonDeSelected());
				myComputerTabButton.setStyleName(res.css().buttonDeSelected());
				MixpanelUtil.Add_Resource_Click_Computer();
			}
		});
		
		
		myComputerTabButton.addClickHandler(new ClickHandler() {	
			@Override
			public void onClick(ClickEvent event) {
				tabViewContainer.clear();
				questionTabButton.getElement().getStyle().setDisplay(Display.NONE);
				trueOrFlaseButton.getElement().getStyle().setDisplay(Display.NONE);
				openEndedButton.getElement().getStyle().setDisplay(Display.NONE);
				fillInTheBlankTabButton.getElement().getStyle().setDisplay(Display.NONE);
				addUserOwnResourceWidget=new AddUserOwnResourceWidget(getUiHandlers().getParentCollectionDetails());
				tabViewContainer.add(addUserOwnResourceWidget);
				myComputerTabButton.setStyleName(res.css().buttonSelected());
				questionTabButton.setStyleName(res.css().buttonDeSelected());
				searchTabButton.setStyleName(res.css().buttonDeSelected());
				urlTabButton.setStyleName(res.css().buttonDeSelected());
			}
		});
		
		searchTabButton.addClickHandler(new ClickHandler() {	
			@Override
			public void onClick(ClickEvent event) {
				tabViewContainer.clear();
				questionTabButton.getElement().getStyle().setDisplay(Display.NONE);
				trueOrFlaseButton.getElement().getStyle().setDisplay(Display.NONE);
				openEndedButton.getElement().getStyle().setDisplay(Display.NONE);
				fillInTheBlankTabButton.getElement().getStyle().setDisplay(Display.NONE);
				addSearchResourceWidget=new AddSearchResourceWidget(getUiHandlers().getParentCollectionDetails());
				tabViewContainer.add(addSearchResourceWidget);
				searchTabButton.setStyleName(res.css().buttonSelected());
				questionTabButton.setStyleName(res.css().buttonDeSelected());
				urlTabButton.setStyleName(res.css().buttonDeSelected());
				myComputerTabButton.setStyleName(res.css().buttonDeSelected());
			}
		});

		Window.enableScrolling(false);
	}
	@Override
	public void setCollectionItemDo(CollectionItemDo collectionItemDo){
		this.collectionItemDo=collectionItemDo;
	}
	@Override
	public void getResourceMetaInfo(String webUrl){
		addWebResourceWidget.getResourceInfo(webUrl);
	}
	/**
	 * 
	 * @function closePopup 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method is used for add Resource CloseButton
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("addResourceCloseButton")
	public void closePopup(ClickEvent event){
		fillInTheBlankRadioButton.setValue(false);
		openEndedRadioButton.setValue(false);
		trueOrFalseRadioButton.setValue(false);
		fillInTheBlankTabButton.setStyleName(res.css().buttonDeSelected());
		trueOrFlaseButton.setStyleName(res.css().buttonDeSelected());
		openEndedButton.setStyleName(res.css().buttonDeSelected());
		closeAddResourcePopup();
		tabViewContainer.clear();	
		addWebResourceWidget=new AddWebResourceWidget(getUiHandlers().getParentCollectionDetails());
		tabViewContainer.add(addWebResourceWidget);
		urlTabButton.setStyleName(res.css().buttonSelected());
		myComputerTabButton.setStyleName(res.css().buttonSelected());
		questionTabButton.setStyleName(res.css().buttonDeSelected());
		searchTabButton.setStyleName(res.css().buttonDeSelected());
	}
	/**
	 * 
	 * @fileName : AddResourceView.java
	 *
	 * @description : This class is used to Add Web Resource Widget.
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
	public class AddWebResourceWidget extends AddWebResourceView{

		public AddWebResourceWidget(CollectionDo parentCollectionDetails) {
			super(parentCollectionDetails);
		}

/**
 * @description :This method is used to get Resource Information
 * 
 */
		@Override
		public void getResourceInfo(String userUrlStr) {
		
			//Check whether the resource already existing or not.
			userUrlStr=userUrlStr.replaceAll("feature=player_detailpage&", "");
			userUrlStr=userUrlStr.replaceAll("feature=player_embedded&","");
			getUiHandlers().getResourceExists(userUrlStr);
			//Get Meta Info for Resource
			getUiHandlers().getResourceMetaInfo(userUrlStr);
		}
		
	/**
	 * This method is used to add Resource 
	 */
		@Override
		public void addResource(String idStr, String urlStr, String titleStr,String descriptionStr, String categoryStr,String thumbnailUrlStr, Integer endTime,boolean conformationFlag) {
//			this.setVisible(false);
			 webResourceId = idStr;
			 webResourceUrl = urlStr;
			 webResourceTitle = titleStr;
			 webResourceDescription = descriptionStr;
			 webResourceCategory = categoryStr;
			 webResourceThumbnail = thumbnailUrlStr;
			 webResourceEnd = endTime; 
			urlStr=urlStr.replaceAll("feature=player_detailpage&", "");
			urlStr=urlStr.replaceAll("feature=player_embedded&","");
			if(conformationFlag){
				webResourcePreview = new WebResourcePreview() {
					
					@Override
					public void showAddResourcePopup() {
						webResourcePreview.hide();
						webResourcePreview.removeFromParent();
						appPopUp.getElement().getStyle().setVisibility(Visibility.VISIBLE);
						loadingTextLbl.getElement().getStyle().setDisplay(Display.NONE);
						buttonsPanel.getElement().getStyle().setDisplay(Display.BLOCK);
					}
					
					@Override
					public void closeAppPopUp() {
						appPopUp.hide();
					}
					
					@Override
					public void addWebResource() {
						getUiHandlers().addResource( webResourceId,  webResourceUrl,  webResourceTitle,  webResourceDescription, webResourceCategory,  webResourceThumbnail,  webResourceEnd);
						/*webResourcePreview.lblConfirmAdding.getElement().getStyle().setDisplay(Display.BLOCK);
						webResourcePreview.actionPanel.getElement().getStyle().setDisplay(Display.NONE);*/
						webResourcePreview.hide();
						webResourcePreview.setGlassEnabled(false);
						appPopUp.hide();
						webResourcePreview.removeFromParent();
					}
				};
				appPopUp.getElement().getStyle().setVisibility(Visibility.HIDDEN);
				webResourcePreview.filePathValueLbl.setText(urlStr);
				webResourcePreview.resourceTitleValueLbl.setText(titleStr);
				if(descriptionStr.equalsIgnoreCase("")||descriptionStr==null){
					webResourcePreview.descriptionTxtLbl.setVisible(false);
				}
				else{
					webResourcePreview.descriptionTxtValueLbl.setText(descriptionStr);
				}
				
				webResourcePreview.categoryValueLbl.setText(categoryStr);
				if(thumbnailUrlStr!=null){
					webResourcePreview.setThumbnailImage.setUrl(thumbnailUrlStr);
				}else{
					webResourcePreview.setThumbnailImage.setVisible(false);
					webResourcePreview.thumbnailLbl.setVisible(false);
				}
								
				webResourcePreview.center();
				webResourcePreview.show();
				
			}else{
				getUiHandlers().addResource(idStr, urlStr, titleStr, descriptionStr, categoryStr, thumbnailUrlStr, endTime);
			}
		}
		
			public void hidePopup(){
			closeAddResourcePopup();
		}

		@Override
		public void resourceImageUpload() {
			getUiHandlers().resourceImageUpload();	
		}


		@Override
		public void checkShortenUrl(String userUrlStr) {
			getUiHandlers().isShortenUrl(userUrlStr);
		}
		
	}
	
	/**
	 * 
	 * @fileName : AddResourceView.java
	 *
	 * @description : This class is used to ADD	 Resource Information
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
	public class AddQuestionResourceWidget extends AddQuestionResourceView{
		private CollectionItemDo collectionItemDo;
		public AddQuestionResourceWidget(){
			super();
			collectionItemDo=null;
		}
		public AddQuestionResourceWidget(CollectionItemDo collectionItemDo){
			super(collectionItemDo);
			this.collectionItemDo=collectionItemDo;
		}
		@Override
		public void hidePopup() {
			multipleChoiceRadioButton.setValue(true);
			closeAddResourcePopup();
			tabViewContainer.clear();	
			questionTabButton.setStyleName(res.css().buttonSelected());
			urlTabButton.setStyleName(res.css().buttonDeSelected());
			myComputerTabButton.setStyleName(res.css().buttonSelected());
		    searchTabButton.setStyleName(res.css().buttonDeSelected());
		    openEndedButton.setStyleName(res.css().buttonDeSelected());
			fillInTheBlankTabButton.setStyleName(res.css().buttonDeSelected());
			trueOrFlaseButton.setStyleName(res.css().buttonDeSelected());
		}
		@Override
		public void onLoad(){
			super.onLoad();
			setEditQuestionImage();
			Scheduler.get().scheduleDeferred(new ScheduledCommand() {
				@Override
				public void execute() {
					if(collectionItemDo!=null){
						showEditQuestionResourceView();
					}
				}
			});
		}

		@Override
		public void uploadQuestionImage() {
			getUiHandlers().questionImageUpload();	
		}
/**
 * This method is used to create Question Resource
 */
		@Override
		public void createQuestionResource(String mediaFileName, CollectionQuestionItemDo collectionQuestionItemDo) {
//			hidePopup();
			if(getQuestionEditMode()){
				String thumbnailUrl=null;
				if(addQuestionResourceWidget.addQuestImgContainer.getWidgetCount()>0){
					AddQuestionImg addQuestionImage=(AddQuestionImg)addQuestionResourceWidget.addQuestImgContainer.getWidget(0);
					thumbnailUrl=addQuestionImage.getFileName();
				}
				getUiHandlers().updateQuestionResource(collectionItemDo,collectionQuestionItemDo,thumbnailUrl==null?null:"asset-question_"+thumbnailUrl);
			}else{
				getUiHandlers().addQeustionResource(mediaFileName,collectionQuestionItemDo);
			}
			
			
		}
		@Override
		public void setEditQuestionImage(String fileName) {
			setImageUrl(fileName, null, true, false);
		}
		
	}
	/**
	 * 
	 * @fileName : AddResourceView.java
	 *
	 * @description : This method is used to add Resource Information
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
	public class AddSearchResourceWidget extends AddSearchResourceView{
		@Override
		public void hidePopup() {
			closeAddResourcePopup();
			tabViewContainer.clear();	
			addWebResourceWidget=new AddWebResourceWidget(getUiHandlers().getParentCollectionDetails());
			tabViewContainer.add(addWebResourceWidget);
			urlTabButton.setStyleName(res.css().buttonSelected());
			questionTabButton.setStyleName(res.css().buttonDeSelected());
			searchTabButton.setStyleName(res.css().buttonDeSelected());
			myComputerTabButton.setStyleName(res.css().buttonSelected());
		}
		
		public AddSearchResourceWidget(CollectionDo collectionDo){
			super(collectionDo);
		}
	}
	/**
	 * 
	 * @fileName : AddResourceView.java
	 *
	 * @description : This class is used to get Resource Information
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
	public class AddUserOwnResourceWidget extends AddUserOwnResourceView {
		public AddUserOwnResourceWidget(CollectionDo collectionDo) {
			super(collectionDo);
		}

		@Override
		public void hidePopup() {
			closeAddResourcePopup();
		}

		@Override
		public void resourceImageUpload() {
			getUiHandlers().userOwnResourceImageUpload();
		}

		@Override
		public void resourceUpload() {
			getUiHandlers().userOwnResourceUpload();
		}
/**
 * This method is used to Show Resource preview
 */
		@Override
		public void showResourcePreview(final String filePath,String resourceMediaFileName,String resourceOriginalFileName,  String resourceTitle,  String resourceDesc, String resourceCategory) { 
			title=resourceTitle;
			desc=resourceDesc;
			category=resourceCategory;
			mediaFilename=resourceMediaFileName;
			originalFileName= resourceOriginalFileName;
			userOwnResourcePreview = new UserOwnResourcePreview() {
				@Override
				public void showAddResourcePopup() {
					userOwnResourcePreview.hide();
					userOwnResourcePreview.removeFromParent();
					//appPopUp.show();
					appPopUp.getElement().getStyle().setVisibility(Visibility.VISIBLE);
					lblAdding.getElement().getStyle().setDisplay(Display.NONE);
					panelAction.getElement().getStyle().setDisplay(Display.BLOCK);
				}
				
				@Override
				public void addUserOwnResource() {
					JSONObject jsonObject = setImageUploadJsonObject(originalFileName,mediaFilename, title, desc, category, ownResourceImgUrl);
					ownResourceImgUrl = null;
					userOwnResourcePreview.lblConfirmAdding.getElement().getStyle().setDisplay(Display.BLOCK);
					userOwnResourcePreview.actionPanel.getElement().getStyle().setDisplay(Display.NONE);
					
					getUiHandlers().addUserOwnResource(jsonObject.toString());
					userOwnResourcePreview.hide();
					userOwnResourcePreview.setGlassEnabled(false);
					appPopUp.hide();
					userOwnResourcePreview.removeFromParent();
//					saveUserResource(filePath);
				}

				@Override
				public void closeAppPopUp() {
					appPopUp.hide();
				}
			};
			//appPopUp.hide();
			appPopUp.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			userOwnResourcePreview.filePathValueLbl.setText(filePath);
			userOwnResourcePreview.resourceTitleValueLbl.setText(resourceTitle);
			userOwnResourcePreview.descriptionTxtValueLbl.setText(resourceDesc);
			userOwnResourcePreview.categoryValueLbl.setText(resourceCategory);
			if(ownResourceImgUrl!=null){
				userOwnResourcePreview.setThumbnailImage.setUrl(ownResourceImgUrl);
			}
			else{
				userOwnResourcePreview.setThumbnailImage.setVisible(false);
				userOwnResourcePreview.thumbnailLbl.setVisible(false);
			}
			userOwnResourcePreview.setGlassEnabled(true);
			userOwnResourcePreview.show();
			userOwnResourcePreview.center();
			
		}

		/*protected void saveUserResource(String filePath) {
			
			getUiHandlers().saveUserResource(filePath);
			
		}*/
/**
 * This method is used to add user Resource Information
 */
		@Override
		public void addUserResource(String filePath,String mediaFileName,String originalFileName, String resourceTitle,String resourceDesc, String resourceCategory) {
			title=resourceTitle;
			desc=resourceDesc;
			category=resourceCategory;
			JSONObject jsonObject = setImageUploadJsonObject(originalFileName,mediaFileName, title, desc, category, ownResourceImgUrl); 
			ownResourceImgUrl = null;
			getUiHandlers().addUserOwnResource(jsonObject.toString());
//			saveUserResource(filePath);
		}
		
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
	public void onLoad() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onUnload() {
		// TODO Auto-generated method stub
		
	}
	public List<String> getThumbnailImages() {
		return addWebResourceWidget.thumbnailImages;
	}

	public void setThumbnailImages(List<String> thumbnailImages) {
		addWebResourceWidget.thumbnailImages = thumbnailImages;
		addWebResourceWidget.activeImageIndex=0;
        addWebResourceWidget.setImageThumbnail();
	}
	
	public ResourceMetaInfoDo getResMetaInfo() {
		return resMetaInfo;
	}

	public void setResMetaInfo(ResourceMetaInfoDo resMetaInfo) {
		this.resMetaInfo = resMetaInfo;
	}
	/**
	 * 	
	 * @function updateUi 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method is used to Update ui
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void updateUi(){
		String userUrlStr = addWebResourceWidget.urlTextBox.getText().trim();
		addWebResourceWidget.generateImageLbl.setVisible(false);
		if (userUrlStr.indexOf("youtube")==-1){
			addWebResourceWidget.rightArrowLbl.setVisible(true);
			addWebResourceWidget.isValidYoutubeUrlFlag = true;
			
		}else{
			if(userUrlStr.indexOf("user") == -1 && userUrlStr.indexOf("list") == -1 && userUrlStr.indexOf("channel") == -1){
				String youTubeIbStr = ResourceImageUtil.getYoutubeVideoId(userUrlStr);
				addWebResourceWidget.thumbnailUrlStr = "http://img.youtube.com/vi/"+youTubeIbStr+"/1.jpg";
				addWebResourceWidget.rightArrowLbl.setVisible(false);
				addWebResourceWidget.isValidYoutubeUrlFlag = true;
				addWebResourceWidget.setVideoDuration(resMetaInfo.getVideoDuration());
			}else{
				addWebResourceWidget.rightArrowLbl.setVisible(true);
				addWebResourceWidget.isValidYoutubeUrlFlag = false;
			}
		}
		if(addWebResourceWidget.thumbnailUrlStr!=null){
			//addWebResourceWidget.setThumbnailImage.setUrlAndVisibleRect(addWebResourceWidget.thumbnailUrlStr, 0, 0, 80, 60);
			addWebResourceWidget.setThumbnailImage.setUrl(addWebResourceWidget.thumbnailUrlStr);
			addWebResourceWidget.setThumbnailImage.setHeight("60px");
			addWebResourceWidget.setThumbnailImage.setWidth("80px");
			addWebResourceWidget.setThumbnailImage.setVisible(true);
		}else{
			addWebResourceWidget.generateImageLbl.setVisible(true);
			addWebResourceWidget.rightArrowLbl.setVisible(false);
		}
	}
	
	/**
	 * This method is used to Set Image url
	 */
	
	public void setImageUrl(String fileName,String fileNameWithoutRepository,boolean isQuestionImage,boolean isUserOwnResourceImage){
		double randNumber = Math.random();
		if(isQuestionImage){
			AddQuestionImg addQuestionImage = new AddQuestionImg();
			addQuestionImage.setQuestionImage(fileName+"?"+randNumber);
			addQuestionImage.setFileName(fileNameWithoutRepository);
			addQuestionResourceWidget.addQuestImgContainer.clear();
			addQuestionResourceWidget.addQuestionImg.getElement().getStyle().setDisplay(Display.NONE);
			addQuestionResourceWidget.addQuestImgContainer.add(addQuestionImage);
			addQuestionImage.changeImgLbl.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					if(addQuestionResourceWidget.getQuestionEditMode()){
						getUiHandlers().questionImageUpload(collectionItemDo.getResource().getGooruOid());
					}else{
						getUiHandlers().questionImageUpload();
					}
				}
			});
			addQuestionImage.removeImgLbl.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					boolean isQuestionEditMode=addQuestionResourceWidget.getQuestionEditMode();
					if(isQuestionEditMode){
						deleteConfirmationPopup=new DeleteConfirmationPopupVc(MESSAGE_HEADER,MESSAGE_CONTENT);
					}else{
						addQuestionResourceWidget.addQuestImgContainer.clear();
						addQuestionResourceWidget.addQuestionImg.getElement().getStyle().setDisplay(Display.BLOCK);
					}
				}
			});
		}
		else if(isUserOwnResourceImage){
			addUserOwnResourceWidget.thumbnailUrlStr = fileName+"?"+randNumber;
			addUserOwnResourceWidget.setThumbnailImage.setUrl(addUserOwnResourceWidget.thumbnailUrlStr);
			addUserOwnResourceWidget.setThumbnailImage.setHeight("60px");
			addUserOwnResourceWidget.setThumbnailImage.setWidth("80px");
			addUserOwnResourceWidget.imageContainer.getElement().getStyle().setDisplay(Display.BLOCK);
			addUserOwnResourceWidget.setThumbnailImage.setVisible(true);
			ownResourceImgUrl = fileName+"?"+randNumber;
		
		}
		else{
			addWebResourceWidget.rightArrowLbl.setVisible(false);
			addWebResourceWidget.leftArrowLbl.setVisible(false);
			addWebResourceWidget.generateImageLbl.setVisible(false);	
			addWebResourceWidget.thumbnailUrlStr = fileName+"?"+randNumber;
			addWebResourceWidget.setThumbnailImage.setUrl(addWebResourceWidget.thumbnailUrlStr);
			addWebResourceWidget.setThumbnailImage.setHeight("60px");
			addWebResourceWidget.setThumbnailImage.setWidth("80px");
			addWebResourceWidget.setThumbnailImage.setVisible(true);
			//addWebResourceWidget.setThumbnailImage.setUrlAndVisibleRect(addWebResourceWidget.thumbnailUrlStr, 18, 14, 80, 60);
		}
	}
	/**
	 * 
	 * @function closeAddResourcePopup 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method is used to close add resource pop up 
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void closeAddResourcePopup(){
		AppClientFactory.fireEvent(new GetEditPageHeightEvent(appPopUp, true));
		Window.enableScrolling(true);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		appPopUp.hide();
	}
/**
 * This method is used to set new Resource pop up data
 */
	@Override
	public void setNewResourcePopupData(ResourceMetaInfoDo resMetaInfo) {
		addWebResourceWidget.loadingPanel.setVisible(false);
		addWebResourceWidget.contentPanel.getElement().getStyle().clearOpacity();
		if(resMetaInfo!=null){
			if (resMetaInfo.getTitle().length()>50){
				addWebResourceWidget.titleTextBox.setText(resMetaInfo.getTitle().substring(0, 50));
			}else{
				addWebResourceWidget.titleTextBox.setText(resMetaInfo.getTitle());
			}
			
			if (resMetaInfo.getDescription().length()>300){
				addWebResourceWidget.descriptionTxtAera.setText(resMetaInfo.getDescription().substring(0, 300));
			}else{
				addWebResourceWidget.descriptionTxtAera.setText(resMetaInfo.getDescription());
			}
			setResMetaInfo(resMetaInfo);
			setThumbnailImages(resMetaInfo.getImages());
			updateUi();
			if(resMetaInfo.getImages().size()<=0){
				addWebResourceWidget.generateImageLbl.setVisible(true);
				addWebResourceWidget.rightArrowLbl.setVisible(false);
				addWebResourceWidget.leftArrowLbl.setVisible(false);
				addWebResourceWidget.setThumbnailImage.setVisible(false);
			}
			//addWebResourceWidget.setThumbnailImage.setUrlAndVisibleRect(resMetaInfo.getImages().get(0), 0, 0, 80, 60);
			addWebResourceWidget.setThumbnailImage.setUrl(resMetaInfo.getImages().get(0));
			addWebResourceWidget.setThumbnailImage.setHeight("60px");
			addWebResourceWidget.setThumbnailImage.setWidth("80px");
		}
	}
	/**
	 * This method is used to set existing resources data.
	 */
	@Override
	public void setExistingResourceData(ExistsResourceDo resourceDo, CollectionDo collectionDo){
		this.hide();
		
		existsResource = new ExistsResourceView();
		existsResource.displayResourceInformation(resourceDo, collectionDo);
		existsResource.setAddNewPopup(this);
		

		existsResource.show();
		existsResource.center();
		
	}
	/**
	 * This method is used to set  shorten url alert message
	 */
	@Override
	public void setShortenUrlAlertMsg(){
		addWebResourceWidget.mandatoryUrlLbl.setText("Oops! You can't add a shortened URL as a resource.");
		addWebResourceWidget.mandatoryUrlLbl.setVisible(true);
		addWebResourceWidget.setShortenedUrl(true); 
	}
	
	public HTMLEventPanel getQuestionTabButton() {
		return questionTabButton;
	}
	public CollectionDo getCollectionDo() {
		return collectionDo;
	}
	public void setCollectionDo(CollectionDo collectionDo) {
		this.collectionDo = collectionDo;
	}
	/**
	 * This method is used to Set pop up .
	 */
	@Override
	public void setPopup(String clickType) {
		if(clickType.equalsIgnoreCase("Url")){			
			tabViewContainer.clear();
			Window.enableScrolling(false);
			titleLbl.setText("Add a Resource");
			urlTabButton.getElement().getStyle().setDisplay(Display.BLOCK);
			searchTabButton.getElement().getStyle().setDisplay(Display.BLOCK);
			myComputerTabButton.getElement().getStyle().setDisplay(Display.BLOCK);
			questionTabButton.getElement().getStyle().setDisplay(Display.NONE);
			trueOrFlaseButton.getElement().getStyle().setDisplay(Display.NONE);
			openEndedButton.getElement().getStyle().setDisplay(Display.NONE);
//			multipleAnswerTabButton.getElement().getStyle().setDisplay(Display.NONE);
			fillInTheBlankTabButton.getElement().getStyle().setDisplay(Display.NONE);
			addWebResourceWidget=new AddWebResourceWidget(getUiHandlers().getParentCollectionDetails());
			tabViewContainer.add(addWebResourceWidget);
			urlTabButton.setStyleName(res.css().buttonSelected());
			questionTabButton.setStyleName(res.css().buttonDeSelected());
			searchTabButton.setStyleName(res.css().buttonDeSelected());
			myComputerTabButton.setStyleName(res.css().buttonDeSelected());
		} else if(clickType.equalsIgnoreCase("Question")){
			try{
				Window.enableScrolling(false);
				tabViewContainer.clear();
				titleLbl.setText("Add a Question");
				addQuestionResourceWidget=new AddQuestionResourceWidget();
				questionTabButton.getElement().getStyle().setDisplay(Display.BLOCK);
				trueOrFlaseButton.getElement().getStyle().setDisplay(Display.BLOCK);
				openEndedButton.getElement().getStyle().setDisplay(Display.BLOCK);
				fillInTheBlankTabButton.getElement().getStyle().setDisplay(Display.BLOCK);
		//		multipleAnswerTabButton.getElement().getStyle().setDisplay(Display.BLOCK);
				urlTabButton.getElement().getStyle().setDisplay(Display.NONE);
				myComputerTabButton.getElement().getStyle().setDisplay(Display.NONE);
				searchTabButton.getElement().getStyle().setDisplay(Display.NONE);
				multipleChoiceRadioButton.setValue(true);
				addQuestionResourceWidget.setQuestionType("MC");
				addQuestionResourceWidget.showMulipleAnswerChoice();
				tabViewContainer.add(addQuestionResourceWidget);
				questionTabButton.setStyleName(res.css().buttonSelected());
				AppClientFactory.fireEvent(new GetEditPageHeightEvent(appPopUp, false));
			    urlTabButton.setStyleName(res.css().buttonDeSelected());
			    myComputerTabButton.setStyleName(res.css().buttonDeSelected());
			    searchTabButton.setStyleName(res.css().buttonDeSelected());
			    fillInTheBlankTabButton.setStyleName(res.css().buttonDeSelected());
			//    multipleAnswerTabButton.setStyleName(res.css().buttonDeSelected());
			    trueOrFlaseButton.setStyleName(res.css().buttonDeSelected());
			    openEndedButton.setStyleName(res.css().buttonDeSelected());
			}catch(Exception e) {
				
			}
		} else if(clickType.equalsIgnoreCase("QuestionEdit")){
			try{
				Window.enableScrolling(false);
				tabViewContainer.clear();
				titleLbl.setText("Edit Question");
				addQuestionResourceWidget=new AddQuestionResourceWidget(collectionItemDo);
				addQuestionResourceWidget.getHideRightsToolTip();
				questionTabButton.getElement().getStyle().setDisplay(Display.BLOCK);
				trueOrFlaseButton.getElement().getStyle().setDisplay(Display.BLOCK);
				openEndedButton.getElement().getStyle().setDisplay(Display.BLOCK);
				fillInTheBlankTabButton.getElement().getStyle().setDisplay(Display.BLOCK);
			//	multipleAnswerTabButton.getElement().getStyle().setDisplay(Display.BLOCK);
				urlTabButton.getElement().getStyle().setDisplay(Display.NONE);
				myComputerTabButton.getElement().getStyle().setDisplay(Display.NONE);
				searchTabButton.getElement().getStyle().setDisplay(Display.NONE);
				tabViewContainer.add(addQuestionResourceWidget);
				int questionTypeNum=collectionItemDo.getResource().getType();
				if(questionTypeNum==1){
					highlightSelectedTab("MC");
					multipleChoiceRadioButton.setValue(true);
				}else if(questionTypeNum==3){
					highlightSelectedTab("TF");
					trueOrFalseRadioButton.setValue(true);
				}else if(questionTypeNum==6){
					highlightSelectedTab("OE");
					openEndedRadioButton.setValue(true);
				}else if(questionTypeNum==7){
					highlightSelectedTab("MA");
					//multipleAnswerRadioButton.setValue(true);
				}else if(questionTypeNum==4){
					highlightSelectedTab("FIB");
					fillInTheBlankRadioButton.setValue(true);
				}
				AppClientFactory.fireEvent(new GetEditPageHeightEvent(appPopUp, false));
			}catch(Exception e) {
				
			}
		}else if(clickType.equalsIgnoreCase("Search")) {
			Window.enableScrolling(true);
			titleLbl.setText("Add a Resource");
			tabViewContainer.clear();
			addSearchResourceWidget=new AddSearchResourceWidget(getUiHandlers().getParentCollectionDetails());
			tabViewContainer.add(addSearchResourceWidget);
			searchTabButton.setStyleName(res.css().buttonSelected());
			questionTabButton.setStyleName(res.css().buttonDeSelected());
			urlTabButton.setStyleName(res.css().buttonDeSelected());
			myComputerTabButton.setStyleName(res.css().buttonDeSelected());
			questionTabButton.getElement().getStyle().setDisplay(Display.NONE);
			trueOrFlaseButton.getElement().getStyle().setDisplay(Display.NONE);
			openEndedButton.getElement().getStyle().setDisplay(Display.NONE);
			fillInTheBlankTabButton.getElement().getStyle().setDisplay(Display.NONE);
		}
	}

	@Override
	public void closePopUp() {
		if(appPopUp.isShowing()){
			appPopUp.hide();
		}
	}
/**
 * 
 * @fileName : AddResourceView.java
 *
 * @description : This class is used to Show multiple choice widget
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
	private class showMultipleChoiceWidget implements ClickHandler{
		public void onClick(ClickEvent event) {
			Window.enableScrolling(false);
			if(!multipleChoiceRadioButton.getValue()){
				//Window.enableScrolling(true);
				multipleChoiceRadioButton.setValue(true);
				highlightSelectedTab("MC");
				addQuestionResourceWidget.setQuestionType("MC");
				addQuestionResourceWidget.showMulipleAnswerChoice();
				addQuestionResourceWidget.addResourceFormTitleChoice.setText("Answer Choices *");
				AppClientFactory.fireEvent(new GetEditPageHeightEvent(appPopUp, false));
			}
		}
	}
	/**
	 * 
	 * @fileName : AddResourceView.java
	 *
	 * @description : This class is used to Show TrueOrFalse widget
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
	private class showTrueOrFalseWidget implements ClickHandler{
		public void onClick(ClickEvent event) {
			Window.enableScrolling(false);
			if(!trueOrFalseRadioButton.getValue()){
				trueOrFalseRadioButton.setValue(true);
				highlightSelectedTab("TF");
				addQuestionResourceWidget.setQuestionType("T/F");
				addQuestionResourceWidget.showTrueOrFalseAnswerChoice();
				addQuestionResourceWidget.addResourceFormTitleChoice.setText("Answer Choices *");

			}
		}
	}
	/**
	 * 
	 * @fileName : AddResourceView.java
	 *
	 * @description : This class is used to Show show Open Ended widget
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
	private class showOpenEndedWidget implements ClickHandler{
		public void onClick(ClickEvent event) {
			Window.enableScrolling(false);
			if(!openEndedRadioButton.getValue()){
				openEndedRadioButton.setValue(true);
				highlightSelectedTab("OE");
				addQuestionResourceWidget.setQuestionType("OE");
				addQuestionResourceWidget.showOpenEndedQuestion();
			}
		}
	}
	/*private class ShowMultipleAnswerWidget implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			Window.enableScrolling(false);
			if(!multipleAnswerRadioButton.getValue()){
				//Window.enableScrolling(true);
				highlightSelectedTab("MA");
				multipleAnswerRadioButton.setValue(true);
				addQuestionResourceWidget.setQuestionType("MA");
				addQuestionResourceWidget.addResourceFormTitleChoice.setText("Enter answers and select correct ones *");
				addQuestionResourceWidget.showMulipleAnswerChoice();
			}
		}
		
	}*/
	/**
	 * 
	 * @fileName : AddResourceView.java
	 *
	 * @description : This class is used to Show FillInTheBlank widget
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
	private class ShowFillInTheBlanWidget implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			Window.enableScrolling(false);
			if(!fillInTheBlankRadioButton.getValue()){
				fillInTheBlankRadioButton.setValue(true);
				highlightSelectedTab("FIB");
				addQuestionResourceWidget.setQuestionType("FIB");
				addQuestionResourceWidget.showFillInTheBlank();
				
			} 
		}	
	}
	
	private void deselectSelectedButton(){
		int widgetsCount=addResourceTabContainer.getWidgetCount();
		for(int i=0;i<widgetsCount;i++){
			Widget widget=addResourceTabContainer.getWidget(i);
			if( widget instanceof HTMLEventPanel){
				widget.setStyleName(res.css().buttonDeSelected());
			}
		}
	}
	private void highlightSelectedTab(String tabType){
		deselectSelectedButton();
		if(tabType.equals("FIB")){
			fillInTheBlankTabButton.setStyleName(res.css().buttonSelected());
		}else if(tabType.equals("TF")){
			trueOrFlaseButton.setStyleName(res.css().buttonSelected());
		}else if(tabType.equals("MA")){
			//multipleAnswerTabButton.setStyleName(res.css().buttonSelected());
		}else if(tabType.equals("MC")){
			questionTabButton.setStyleName(res.css().buttonSelected());
		}else if(tabType.equals("OE")){
			openEndedButton.setStyleName(res.css().buttonSelected());
		}else if(tabType.equals("URL")){
			urlTabButton.setStyleName(res.css().buttonSelected());
		}else if(tabType.equals("SEARCH")){
			searchTabButton.setStyleName(res.css().buttonSelected());
		}
	}
	@Override
	public void removeQuestionEditImage() {
		deleteConfirmationPopup.hide();
		addQuestionResourceWidget.addQuestImgContainer.clear();
		addQuestionResourceWidget.addQuestionImg.getElement().getStyle().setDisplay(Display.BLOCK);
		
	}
	
	private class DeleteConfirmationPopupVc extends ConfirmationPopupVc{
		public DeleteConfirmationPopupVc(String messageHeader,String messageContent){
			super(messageHeader, messageContent);
			setPopupZindex(9999);
			setGlassZindex(9998);
			setScrollDisable();
		}
		@Override
		public void onDelete(ClickEvent clickEvent) {
			getUiHandlers().removeQuestionImage(collectionItemDo.getCollectionItemId());
		}
		public void hide() {
			 super.hide();
			 
			//Window.enableScrolling(true);
			//AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0,true));
		}
	}

/**
 * this method is used to upload Resource
 */
	@Override
	public void uploadResource(MediaUploadDo result) {
		JSONObject jsonObject = setImageUploadJsonObject(result.getOriginalFilename(),result.getName(), title, desc, category, ownResourceImgUrl);
		getUiHandlers().addUserOwnResource(jsonObject.toString());
		userOwnResourcePreview.hide();
		userOwnResourcePreview.setGlassEnabled(false);
	}
	
	public JSONObject setImageUploadJsonObject(String originalFileName,String mediaFileName,String resourceTitle, String resourceDesc,	String resourceCategory, String ownResourceImgUrl) {
		JSONObject file = new JSONObject();
        file.put("filename", new JSONString(originalFileName));
        file.put("mediaFilename", new JSONString(mediaFileName));
        JSONObject attach = new JSONObject();
        attach.put("title", new JSONString(resourceTitle));
        attach.put("description", new JSONString(resourceDesc));
        attach.put("category", new JSONString(resourceCategory));
        if(ownResourceImgUrl!=null){
        	 attach.put("thumbnail", new JSONString(ownResourceImgUrl));
        }
        attach.put("attach", file);
        JSONObject resource = new JSONObject();
        resource.put("resource", attach);
        
		return resource;
	}
/**
 * 
 * @function getYoutubeVideoLength 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :this method is used to get youtube video length.
 * 
 * 
 * @parm(s) : @param length
 * @parm(s) : @return
 * 
 * @return : String
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	public String getYoutubeVideoLength(Integer length){
		int totalVideoLength = length;
		String tolTimeInmin = "";
		String totalTimeSec = "";

		int tolTimeInminutes = totalVideoLength / 60;
		if (tolTimeInminutes < 10) {
			tolTimeInmin = "0"
					+ tolTimeInminutes;
		} else {
			tolTimeInmin = tolTimeInminutes
					+ "";
		}

		int totalTimeInseconds = totalVideoLength % 60;
		if (totalTimeInseconds < 10) {
			totalTimeSec = "0"
					+ totalTimeInseconds;
		} else {
			totalTimeSec = totalTimeInseconds
					+ "";
		}
		return tolTimeInmin+":"+totalTimeSec;
	}
	
}
