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
package org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.child.ChildView;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.dnd.IsDraggableMirage;
import org.ednovo.gooru.client.mvp.home.WaitPopupVc;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.shared.model.content.ResourceDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

	/**
	 * 
	 * @fileName : CollectionsView.java
	 *
	 * @description : This class is used to display the collection in an assignment tab.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 27-Dec-2013
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
public class CollectionsView extends ChildView<CollectionsPresenter> implements
		IsCollectionsView, MessageProperties {
	 
	@UiField(provided = true)
	CollectionsCBundle res;

	private static String DEFULT_IMAGE = "images/default-collection-image.png";

	private static final String NULL = "null";

//	private CollectionItemDo collectionItemDo;
	
	private ResourceDo resourceDo;
	
	private  String assignmentId;
	
	boolean isTeacherView;

	@UiField
	Label removeCollectionLbl;
	
	@UiField
	Button  editCollectionLbl;

	@UiField
	HTML collectionDesc,collectionTitle;

	@UiField
	Image collectionImage;

	@UiField
	HTMLPanel actionPanel;
	int itemSize;
	int itemCounter;

	WaitPopupVc waitConfirmVc=null;
		
	private static CollectionsViewUiBinder uiBinder = GWT
			.create(CollectionsViewUiBinder.class);

	interface CollectionsViewUiBinder extends UiBinder<Widget, CollectionsView> {
	}

	/**
	 * Class constructor
	 * 
	 * @param resourceDo instance of {@link ResourceDo}
	 * @param isTeacherView to handle show and hiding the controls
	 * @param assignmentID
	 *            
	 */
	public CollectionsView(final ResourceDo resourceDo, boolean isTeacherView,  String assignmentId) {

		res = CollectionsCBundle.INSTANCE;
		CollectionsCBundle.INSTANCE.css().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));
		this.resourceDo = resourceDo;
		this.isTeacherView = isTeacherView;
		this.assignmentId = assignmentId;
		editCollectionLbl.getElement().setId("btnEditCollection");
		removeCollectionLbl.getElement().setId("lblRemoveCollection");
		setPresenter(new CollectionsPresenter(this));
		//To handle error thumbnail urls and set the gooru default images
		collectionImage.addErrorHandler(new ErrorHandler() {

			@Override
			public void onError(ErrorEvent event) {
				collectionImage.setUrl(DEFULT_IMAGE);
				collectionImage.setAltText(resourceDo.getTitle());
				collectionImage.setTitle(resourceDo.getTitle());
			}
		});
		setUiElements();	
		addDomHandler(new ActionPanelHover(), MouseOverEvent.getType());
		addDomHandler(new ActionPanelOut(), MouseOutEvent.getType());
		actionPanel.setVisible(false);
		//Setting click handlers
		collectionImage.addClickHandler(new CollectionImageClick());
		collectionTitle.addClickHandler(new CollectionTitleClick());
		editCollectionLbl.addClickHandler(new CollectionEditClick());
		removeCollectionLbl.addClickHandler(new CollectionRemoveClick());
		
		
	}
	/**
	 * 
	 * @function setUiElements 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : To Display the content to UI
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	private void setUiElements() {
		//collectionTitle.setText(resourceDo.getTitle());
		collectionTitle.setHTML(resourceDo.getTitle());
		collectionDesc.setHTML(resourceDo.getGoals());

		setUrl(resourceDo.getThumbnails().getUrl());
	}
	/**
	 * Class for Handling Click event for Removing the collections from Assignments
	 * On Confirmation by user the Collection will removed.
	 */
	private class CollectionRemoveClick implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			waitConfirmVc = new WaitPopupVc("Wait!","Are you sure you want to remove this collection? Students may be using this... Don't worry, however, because the collection will not be deleted from your folders.")  {
				
				@Override
				public void onTextConfirmed() {
					
					getPresenter().RemoveCollectionFormAssignemnt(resourceDo.getGooruOid(), assignmentId);
					
				}
			};
		}
	}
	/**
	 * Click event handler for editing the collection.
	 */
	private class CollectionEditClick implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			AppClientFactory.setPreviousPlaceRequest(AppClientFactory.getPlaceManager().getCurrentPlaceRequest());
			AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.SHELF, new String[] { "id", resourceDo.getGooruOid() });
		}
	}
	
	/**
	 * Click event handler for Collection Title 
	 */
	
	private class CollectionTitleClick implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			OpenPlayer();
		}
	}
	/**
	 * Click event handler for Collection Image 
	 */
	private class CollectionImageClick implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			OpenPlayer();
		}
	}
	/**
	 * 
	 * @function OpenPlayer 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description :Open collection player on clicking on Collection title or image
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void OpenPlayer(){
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", resourceDo.getGooruOid());
		com.google.gwt.user.client.Window.scrollTo(0, 0);
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.COLLECTION_PLAY, params);
	}
	
	/**
	 * 
	 * To show the ResourceMetaDataInfo Edit,Copy and Remove buttons
	 */
	private class ActionPanelHover implements MouseOverHandler {

		@Override
		public void onMouseOver(MouseOverEvent event) {
			if (isTeacherView){
				actionPanel.setVisible(true);
			}
		}
	}

	/**
	 * 
	 * To hide the ResourceMetaDataInfo Edit,Copy and Remove buttons
	 */
	private class ActionPanelOut implements MouseOutHandler {

		@Override
		public void onMouseOut(MouseOutEvent event) {
			if (isTeacherView){
				actionPanel.setVisible(false);
			}
		}
	}

	/**
	 * @param url of the image
	 *            
	 */
	public void setUrl(String url) {
		if (url == null || url.endsWith(NULL)) {
			collectionImage.setUrl(DEFULT_IMAGE);
		} else {
			collectionImage.setUrl(StringUtil.formThumbnailName(url,
					"-160x120."));
		}
		collectionImage.setAltText(resourceDo.getTitle());
		collectionImage.setTitle(resourceDo.getTitle());
	}
	/**
	 * Method to return drag handle widget
	 */
	@Override
	public Widget getDragHandle() {
		throw new RuntimeException("Not implemented");
	}
	/**
	 * Method to return initDraggableMirage
	 */
	@Override
	public IsDraggableMirage initDraggableMirage() {
		throw new RuntimeException("Not implemented");
	}
	/**
	 * To handle drag events on blur handler.
	 */
	@Override
	public void onDragBlur() {
		throw new RuntimeException("Not implemented");
	}
	/**
	 * To get Drag Id.
	 */
	@Override
	public String getDragId() {
		throw new RuntimeException("Not implemented");
	}
    /**
     * To get Drag Type.
     */
	@Override
	public DRAG_TYPE getDragType() {
		throw new RuntimeException("Not implemented");
	}
	/**
	 * To get DragTopCorrection
	 */
	@Override
	public int getDragTopCorrection() {
		throw new RuntimeException("Not implemented");
	}
	/**
	 * To get DragLeftCorrection
	 */
	@Override
	public int getDragLeftCorrection() {
		throw new RuntimeException("Not implemented");
	}
	/**
	 * To hide the Wait Popup.
	 */
	@Override
	public void hideWaitPopup() {
		if(waitConfirmVc != null){
			waitConfirmVc.hide();
			Window.enableScrolling(true);
	        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		}
		

	}
}
