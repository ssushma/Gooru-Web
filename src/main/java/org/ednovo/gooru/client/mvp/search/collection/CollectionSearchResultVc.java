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
package org.ednovo.gooru.client.mvp.search.collection;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.dnd.IsDraggable;
import org.ednovo.gooru.client.mvp.dnd.IsDraggableMirage;
import org.ednovo.gooru.client.mvp.resource.dnd.ResourceDragController;
import org.ednovo.gooru.client.mvp.resource.dnd.ResourceDragWithImgUc;
import org.ednovo.gooru.client.mvp.search.SearchUiUtil;
import org.ednovo.gooru.client.mvp.search.event.UpdateSearchResultMetaDataEvent;
import org.ednovo.gooru.client.mvp.search.event.UpdateSearchResultMetaDataHandler;
import org.ednovo.gooru.client.service.UserServiceAsync;
import org.ednovo.gooru.client.uc.CollectionImageUc;
import org.ednovo.gooru.client.uc.SeparatorUc;
import org.ednovo.gooru.client.uc.UserProfileUc;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.search.CollectionSearchResultDo;
import org.ednovo.gooru.shared.model.user.ProfileDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * 
 * @fileName : CollectionSearchResultVc.java
 *
 * @description : This file is related to collection search results.
 *
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class CollectionSearchResultVc extends Composite implements IsDraggable, IsSearchResultVc {

	private static CollectionSearchResultVcUiBinder uiBinder = GWT.create(CollectionSearchResultVcUiBinder.class);

	interface CollectionSearchResultVcUiBinder extends UiBinder<Widget, CollectionSearchResultVc> {
	}
	
	private final FlowPanel profilePanel=new FlowPanel();

	@UiField
	Label  creatorNameLblValue, creatorNameLbl, resourceCountLbl;

	@UiField
	HTML collectionDescriptionHtml,collectionTitleLbl;
	
	@UiField
	HTMLPanel containerPanel;

	@UiField
	FlowPanel metaDataPanelFloPanel, standardsFloPanel;

	@UiField
	CollectionImageUc collectionImageUc;

	@UiField(provided = true)
	CollectionSearchResultWrapperVc wrapperVc;

	@UiField(provided = true)
	CollectionSearchResultCBundle res;
	
	@Inject
	private UserServiceAsync userService;
	
	

	private SimpleAsyncCallback<ProfileDo> userProfileAsyncCallback;
	
	private CollectionSearchResultDo collectionResultDo;
	
	private static final String VIEWS = " Views";
	private static final String VIEW = " View";
	
	private static final String CREATED_BY = "Created by ";
	
	private static final String RESOURCES = " Resources";
	
	private static final String RESOURCE = " Resource";

	private static final String USER_META_ACTIVE_FLAG = "0";
	/**
	 * Class constructor, creates new instance of CollectionSearchResultWrapperVc and call collection search result setData method
	 * @param collectionResultDo instance {@link CollectionSearchResultDo}
	 * @param searchDragController instance of {@link ResourceDragController}
	 */
	public CollectionSearchResultVc(CollectionSearchResultDo collectionResultDo, ResourceDragController searchDragController) {
		long startTime = System.currentTimeMillis();
		wrapperVc = new CollectionSearchResultWrapperVc(searchDragController,collectionResultDo.getGooruOid());
		this.res = CollectionSearchResultCBundle.INSTANCE;
		res.css().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));
		setData(collectionResultDo);
		wrapperVc.addStyleName("collectionSearchResultBox");
		
		AppClientFactory.getEventBus().addHandler(UpdateSearchResultMetaDataEvent.TYPE,setUpdateMetaData);
	}
	UpdateSearchResultMetaDataHandler setUpdateMetaData =new UpdateSearchResultMetaDataHandler(){

		@Override
		public void updateSearchResultMetaData(String count, String resourceId,
				String whatToUpdate) {
			if(count!=null){
			updateViews(count, resourceId, whatToUpdate);
			}
		}
	};

	
	/**
	 * 
	 * @function updateViews 
	 * 
	 * @created_date : Aug 11, 2013
	 * 
	 * @description: This is to update metadata.
	 * 
	 * 
	 * @parm(s) : @param count
	 * @parm(s) : @param contentId
	 * @parm(s) : @param whatToUpdate
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void updateViews(String count, String contentId, String whatToUpdate){
		if (collectionResultDo.getGooruOid().equalsIgnoreCase(contentId)){
			metaDataPanelFloPanel.clear();
			SearchUiUtil.renderMetaData(metaDataPanelFloPanel, collectionResultDo.getCourseNames(), 30);
			SearchUiUtil.renderMetaData(metaDataPanelFloPanel, count + "", (Integer.parseInt(count) >1 ? VIEWS : VIEW));
			metaDataPanelFloPanel.add(new SeparatorUc());
			resourceCountLbl.setText(collectionResultDo.getResourceCount() +" " + (collectionResultDo.getResourceCount()>1 ? RESOURCES : RESOURCE));
		}
	}
	
	

	/**
	 * Set collection meta info such as collection title, image, creator, etc..
	 * @param collectionResultDo instance of {@link CollectionSearchResultDo}
	 */
	public void setData(final CollectionSearchResultDo collectionResultDo) {
		this.collectionResultDo = collectionResultDo;
		wrapperVc.setData(collectionResultDo);
		//collectionTitleLbl.setText(StringUtil.truncateText(collectionResultDo.getResourceTitle(), 40));
		collectionTitleLbl.setHTML(StringUtil.truncateText(collectionResultDo.getResourceTitle(), 40));

		creatorNameLbl.setText(CREATED_BY);
		creatorNameLblValue.setText(collectionResultDo.getOwner().getUsername());
		
		if ((collectionResultDo.getOwner().isProfileUserVisibility())){
			if(collectionResultDo.getOwner().getUsername().equalsIgnoreCase("Autodesk") || collectionResultDo.getOwner().getUsername().equalsIgnoreCase("Lessonopoly") || collectionResultDo.getOwner().getUsername().equalsIgnoreCase("CommonSenseMedia") || collectionResultDo.getOwner().getUsername().equalsIgnoreCase("FTE") || collectionResultDo.getOwner().getUsername().equalsIgnoreCase("WSPWH") || collectionResultDo.getOwner().getUsername().equalsIgnoreCase("lisaNGC"))
			{
			creatorNameLblValue.getElement().getStyle().setColor("#1076bb");
			creatorNameLblValue.getElement().getStyle().setCursor(Cursor.POINTER);
			creatorNameLblValue.getElement().getStyle().setFloat(Float.LEFT);
			
			creatorNameLblValue.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					
					MixpanelUtil.Click_Username();
					Map<String, String> params = new HashMap<String, String>();
					params.put("id", collectionResultDo.getOwner().getGooruUId());
					params.put("user", collectionResultDo.getOwner().getUsername());
					AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.PROFILE_PAGE, params);
				}
			});
			
			creatorNameLblValue.addMouseOverHandler(new MouseOverHandler() {
				
				@Override
				public void onMouseOver(MouseOverEvent event) {
					
					AppClientFactory.getInjector().getUserService().getUserProfileV2Details(collectionResultDo.getOwner().getGooruUId(), USER_META_ACTIVE_FLAG, new SimpleAsyncCallback<ProfileDo>(){

						@Override
						public void onSuccess(ProfileDo result) {
							String username=result.getUser().getUsernameDisplay();
							String aboutMe=result.getAboutMe();
							UserProfileUc userProfileUc = new UserProfileUc(username,aboutMe, result.getUser().getProfileImageUrl());
							profilePanel.clear();
							profilePanel.add(userProfileUc);
							
						}
						
					});
					
					containerPanel.clear();
					containerPanel.add(profilePanel);
				}
			});
			
			creatorNameLblValue.addMouseOutHandler(new MouseOutHandler() {
				
				@Override
				public void onMouseOut(MouseOutEvent event) {
					//profilePanel.clear();
					containerPanel.clear();
				}
			});
			
			}
		}/*else{
			creatorNameLblValue.setText(" "+collectionResultDo.getOwner().getUsername());
		}*/
		collectionImageUc.setUrl(collectionResultDo.getUrl(),collectionResultDo.getResourceTitle());
		collectionImageUc.getElement().getStyle().setZIndex(9999);
		collectionImageUc.setGooruOid(collectionResultDo.getGooruOid());
		String description=collectionResultDo.getDescription();
		if(description!=null && description.length()>235){
		description = description.trim().substring(0, 235) +"...";	
		}
		collectionDescriptionHtml.setHTML(description);
		
		
		SearchUiUtil.renderMetaData(metaDataPanelFloPanel, collectionResultDo.getCourseNames(), 30);
		SearchUiUtil.renderMetaData(metaDataPanelFloPanel, collectionResultDo.getTotalViews() + "", VIEWS);
		metaDataPanelFloPanel.add(new SeparatorUc());
		resourceCountLbl.setText(collectionResultDo.getResourceCount() +" " + (collectionResultDo.getResourceCount()>1 ? RESOURCES : RESOURCE));
		
		SearchUiUtil.renderStandards(standardsFloPanel, collectionResultDo);
	}

	/**
	 * 
	 * @function onClickCollectionTitle 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This method is used to go to collection play on collection title click.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("collectionTitleLbl")
	public void onClickCollectionTitle(ClickEvent event){
		MixpanelUtil.Preview_Collection_From_Search("CollectionTitleLbl");
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", collectionResultDo.getGooruOid());
		com.google.gwt.user.client.Window.scrollTo(0, 0);
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.COLLECTION_PLAY, params);
	}
	
	/**
	 * @return type of {@link CollectionSearchResultWrapperVc}
	 */
	public CollectionSearchResultWrapperVc getSearchResultVc() {
		return wrapperVc;
	}

	/**
	 * Assign {@link CollectionSearchResultWrapperVc} instance
	 * @param searchResultVc instance of {@link CollectionSearchResultWrapperVc}
	 */
	public void setSearchResultVc(CollectionSearchResultWrapperVc searchResultVc) {
		this.wrapperVc = searchResultVc;
	}
	/**
	 * To get drag id.
	 */
	@Override
	public String getDragId() {
		return collectionResultDo.getGooruOid();
	}
	/**
	 * To get drag type.
	 */
	@Override
	public DRAG_TYPE getDragType() {
		return DRAG_TYPE.COLLECTION;
	}
	/**
	 * returns isDraggableMirrage.
	 */
	@Override
	public IsDraggableMirage initDraggableMirage() {
		return new ResourceDragWithImgUc(DRAG_TYPE.COLLECTION.getName(), collectionResultDo.getResourceTitle());
	}
	/**
	 * Blur handler for drag event.
	 */
	@Override
	public void onDragBlur() {
		getSearchResultVc().onMouseOut(null);
	}
	/**
	 * To get drag Handle.
	 */
	@Override
	public Widget getDragHandle() {
		return getSearchResultVc().getDragHandlePanel();
	}
	/**
	 * To get drag top correction.
	 */
	@Override
	public int getDragTopCorrection() {
		return 27;
	}
	/**
	 * To get drag left correction.
	 */
	@Override
	public int getDragLeftCorrection() {
		return 20;
	}

	/**
	 * @return the collectionResultDo instance
	 */
	public CollectionSearchResultDo getCollectionResultDo() {
		return collectionResultDo;
	}
	/**
	 * @param collectionResultDo
	 *            the collectionResultDo to set
	 */
	public void setCollectionResultDo(CollectionSearchResultDo collectionResultDo) {
		this.collectionResultDo = collectionResultDo;
	}
	/**
	 * To add to shelf
	 */
	@Override
	public void setAddedToShelf(boolean addedToShelf) {
		wrapperVc.setAddedToShelf(addedToShelf);
	}
	/**
	 * 
	 * @function setUserProfileAsyncCallback 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : setter method for userProfileAsyncCallback.
	 * 
	 * 
	 * @parm(s) : @param userProfileAsyncCallback
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setUserProfileAsyncCallback(SimpleAsyncCallback<ProfileDo> userProfileAsyncCallback) {
		this.userProfileAsyncCallback = userProfileAsyncCallback;
	}
	/**
	 * 
	 * @function getUserService 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : returns userService.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : UserServiceAsync
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public UserServiceAsync getUserService() {
		return userService;
	}
	/**
	 * 
	 * @function setUserService 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :To set userService
	 * 
	 * 
	 * @parm(s) : @param userService
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setUserService(UserServiceAsync userService) {
		this.userService = userService;
	}
	/**
	 * 
	 * @function getUserprofileAsyncCallback 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :returns userProfileAsyncCallback.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : SimpleAsyncCallback<ProfileDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public SimpleAsyncCallback<ProfileDo> getUserprofileAsyncCallback() {
		return userProfileAsyncCallback;
	}
}
