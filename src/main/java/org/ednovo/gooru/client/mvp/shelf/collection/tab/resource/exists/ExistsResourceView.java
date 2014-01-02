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
package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.exists;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddResourceView;
import org.ednovo.gooru.client.mvp.shelf.event.InsertCollectionItemInAddResourceEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshCollectionItemInShelfListEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshType;
import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.client.uc.FlaggingPopUp;
import org.ednovo.gooru.player.resource.shared.GetFlagContentDO;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.ExistsResourceDo;
import org.ednovo.gooru.shared.util.ResourceImageUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.FontStyle;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : ExistsResourceView.java
 *
 * @description : This file is responsible show view based on ExistsResourceView.ui.xml
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class ExistsResourceView extends AppPopUp{

	private static ExistsResourceViewUiBinder uiBinder = GWT.create(ExistsResourceViewUiBinder.class);

	private static final String DEFULT_IMAGE_PREFIX = "images/default-";

	private static final String PNG = ".png";
	
	CollectionDo collectionDo=null;
	
	interface ExistsResourceViewUiBinder extends UiBinder<Widget, ExistsResourceView> {
	}
	
	@UiField Label cancelExistsResourcePopupBtnLbl, addExistsResourceBtnLbl;
	
	@UiField Label resourceUrlLbl,resourceTitleLbl,loadingTextLbl;
	
	@UiField Anchor reportResInfoLbl;
	
	@UiField Image resourceThumbnailImg,resourceIconImg;
	
	@UiField HTMLPanel buttonContainer;

	AddResourceView appPopup=null;
	
	ExistsResourceDo existsResourceDo=null;
	

	String idStr=null, url=null, title=null, description=null, category=null, thumbnailUrl=null;
	
	interface NewResourcePopupViewUiBinder extends
			UiBinder<Widget, ExistsResourceView> {
		
	}
	/**
	 * Class constructor.
	 */
	public ExistsResourceView() {
		
		setWidget(uiBinder.createAndBindUi(this));
				
        setModal(true);
		Window.enableScrolling(false);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, false));

        addExistsResourceBtnLbl.getElement().setId("lblAdd");
        cancelExistsResourcePopupBtnLbl.getElement().setId("lblCancel");
		cancelExistsResourcePopupBtnLbl.addClickHandler(new CloseExistsClickHandler());
		addExistsResourceBtnLbl.addClickHandler(new AddExistsClickHandler());	
		loadingTextLbl.getElement().getStyle().setFontStyle(FontStyle.ITALIC);
		loadingTextLbl.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		buttonContainer.setVisible(true);
		loadingTextLbl.setVisible(false);
		}
	/**
	 * 
	 * @function onClickReport 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This will handle the click event on the report res info label.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("reportResInfoLbl")
	public void onClickReport(ClickEvent event){
		hide();
		FlaggingPopUp flagging = new FlaggingPopUp(idStr, title);
		flagging.center();
		flagging.show();
	}
		
	//Click handler for Close/Cancel
	/**
	 * This inner class is used to handle the click events (close/ cancel)
	 */
	private class CloseExistsClickHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			
			appPopup.getAddWebResourceWidget().clearFields();
			
			appPopup.getAddWebResourceWidget().addResourceBtnLbl.setVisible(false);
			appPopup.getAddWebResourceWidget().addResourceBtnPanel.setVisible(false);
			appPopup.getAddWebResourceWidget().setThumbnailImage.setVisible(false);
			
			hide();
			Window.enableScrolling(true);
			appPopup.show();
		}		
	}
	//Click event to handle Add existing resource/collection item to collection.
	private class AddExistsClickHandler implements ClickHandler{
		
		@Override
		public void onClick(ClickEvent event) {
			buttonContainer.setVisible(false);
			loadingTextLbl.setVisible(true);
			AppClientFactory.getInjector().getResourceService().createCollectionItem(collectionDo.getGooruOid(), existsResourceDo.getId(), new SimpleAsyncCallback<CollectionItemDo>() {

				@Override
				public void onSuccess(CollectionItemDo result) {
					hide();
					Window.enableScrolling(true);
			        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
					AppClientFactory.fireEvent(new RefreshCollectionItemInShelfListEvent(result, RefreshType.INSERT));
					AppClientFactory.fireEvent(new InsertCollectionItemInAddResourceEvent(result, RefreshType.INSERT));
				}
			});
		}
	}
	/**
	 * This will get the resourceDo model object.
	 */
	public ExistsResourceDo getExistsResourceDo() {
		return existsResourceDo;
	}
	/**
	 * This will set the resourceDo model object.
	 */
	public void setExistsResourceDo(ExistsResourceDo existsResourceDo) {
		this.existsResourceDo = existsResourceDo;
	}
	/**
	 * This will get the collectionDo model object.
	 */
	public CollectionDo getCollectionDo() {
		return collectionDo;
	}
	/**
	 * This will set the collectionDo model object.
	 */
	public void setCollectionDo(CollectionDo collectionDo) {
		this.collectionDo = collectionDo;
	}
	/**
	 * @function displayResourceInformation 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This method is used to display resource information.
	 * 
	 * @parm(s) : @param existsResourceDo
	 * @parm(s) : @param collectionDo
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void displayResourceInformation(ExistsResourceDo existsResourceDo, CollectionDo collectionDo) {
		this.existsResourceDo = existsResourceDo;
		setCollectionDo(collectionDo);
		
		idStr = existsResourceDo.getId();
		url = existsResourceDo.getNativeurl();
		title = existsResourceDo.getLabel();
		description = existsResourceDo.getDescription();
		category = existsResourceDo.getCategory().toLowerCase();
		thumbnailUrl = existsResourceDo.getThumbnails().getUrl();
		
		resourceUrlLbl.setText(url);
		resourceTitleLbl.setText(title);
		
		if (thumbnailUrl.endsWith("null")){
			if (url.indexOf("youtube") >0){
				String youTubeIbStr = ResourceImageUtil.getYoutubeVideoId(url);
				thumbnailUrl = "http://img.youtube.com/vi/"+youTubeIbStr+"/1.jpg";
			}else{
				thumbnailUrl = DEFULT_IMAGE_PREFIX+category+PNG;
			}
		}
		resourceThumbnailImg.setStyleName("thumbnailImageDec");
		resourceThumbnailImg.setUrl(thumbnailUrl);
		
		setResourceIconStyle(category, resourceIconImg);
		AppClientFactory.getInjector().getResourceService().getContentReport(idStr, new AsyncCallback<GetFlagContentDO>() {
			@Override
			public void onSuccess(GetFlagContentDO result) {
				if(result==null ){
					reportResInfoLbl.setText("Flag this Resource.");
				}
				else
				{
					reportResInfoLbl.setText("You have already flagged this resource. Flag it again.");	
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}
	/**
	 * @function setResourceIconStyle 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method will set the resource icons styles.
	 * 
	 * 
	 * @parm(s) : @param categoryStr
	 * @parm(s) : @param resourceThumbnailImage
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setResourceIconStyle(String categoryStr, Image resourceThumbnailImage){
		if (categoryStr.equalsIgnoreCase("Video")){
			resourceThumbnailImage.setStyleName("resourceExistsResourceTypeSpriteVideo");
		}else if (categoryStr.equalsIgnoreCase("Interactive")){
			resourceThumbnailImage.setStyleName("resourceExistsResourceTypeSpriteInteractive");
		}else if (categoryStr.equalsIgnoreCase("Website")){
			resourceThumbnailImage.setStyleName("resourceExistsResourceTypeSpriteWebsite");
		}else if (categoryStr.equalsIgnoreCase("Slide")){
			resourceThumbnailImage.setStyleName("resourceExistsResourceTypeSpriteSlide");
		}else if (categoryStr.equalsIgnoreCase("Handout")){
			resourceThumbnailImage.setStyleName("resourceExistsResourceTypeSpriteHandout");
		}else if (categoryStr.equalsIgnoreCase("Textbook")){
			resourceThumbnailImage.setStyleName("resourceExistsResourceTypeSpriteTextbook");
		}else if (categoryStr.equalsIgnoreCase("Lesson")){
			resourceThumbnailImage.setStyleName("resourceExistsResourceTypeSpriteLesson");
		}else if (categoryStr.equalsIgnoreCase("Question")){
			resourceThumbnailImage.setStyleName("resourceExistsResourceTypeSpriteQuestion");
		}else if (categoryStr.equalsIgnoreCase("Exam")){
			resourceThumbnailImage.setStyleName("resourceExistsResourceTypeSpriteExam");
		}else{
			
		}
	}
	/**
	 * This method will set the add new resource popup.
	 */
	public void setAddNewPopup(AddResourceView appPopup) {
		this.appPopup = appPopup;
	}
	/*native void redirect(String url)
    -{
            $wnd.location.reload();
    }-;*/
}
