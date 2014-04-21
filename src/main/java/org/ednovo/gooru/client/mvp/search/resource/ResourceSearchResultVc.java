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
package org.ednovo.gooru.client.mvp.search.resource;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.dnd.IsDraggable;
import org.ednovo.gooru.client.mvp.dnd.IsDraggableMirage;
import org.ednovo.gooru.client.mvp.resource.dnd.ResourceDragController;
import org.ednovo.gooru.client.mvp.resource.dnd.ResourceDragWithImgUc;
import org.ednovo.gooru.client.mvp.search.SearchUiUtil;
import org.ednovo.gooru.client.mvp.search.collection.IsSearchResultVc;
import org.ednovo.gooru.client.mvp.search.event.UpdateSearchResultMetaDataEvent;
import org.ednovo.gooru.client.mvp.search.event.UpdateSearchResultMetaDataHandler;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.client.uc.ResourceImageUc;
import org.ednovo.gooru.client.uc.tooltip.ToolTip;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
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
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 *
 */
public class ResourceSearchResultVc extends Composite implements IsDraggable, IsSearchResultVc,MessageProperties {

	private static ResourceSearchResultVcUiBinder uiBinder = GWT.create(ResourceSearchResultVcUiBinder.class);

	interface ResourceSearchResultVcUiBinder extends UiBinder<Widget, ResourceSearchResultVc> {
	}
	
	@UiField HTML lblResourceTitle;
	
	@UiField Image imgNotFriendly;
	
	@UiField
	HTMLEventPanel resourceTitleContainer;

	@UiField
	FlowPanel metaDataFloPanel;

	@UiField
	HTML resourceDescriptionHtml;

	@UiField
	ResourceImageUc resourceImageUc;

	@UiField
	FlowPanel standardsFloPanel;

	@UiField(provided = true)
	ResourceSearchResultWrapperVc wrapperVcr;

	@UiField(provided = true)
	ResourceSearchResultCBundle res;
	
	ToolTip toolTip = null;

	private ResourceSearchResultDo resourceSearchResultDo;
	
	
	private static final String PLAYER_NAME = "resource";
	
	private static final String VIDEO = "Video";
	
	private static final String QUESTION = "Question";
	
	private static final String PAGES = " "+GL1471;
	
	private static final String VIEW = " "+GL1428;
	
	private static final String VIEWS = " "+GL0934;
	
	private static final String NULL = "null";
	
	/**
	 * Class constructor, assign new instance of {@link ResourceSearchResultWrapperVc}, and call resource search result setData method
	 * @param resourceSearchResultDo instance of {@link ResourceSearchResultDo}
	 * @param searchDragController instance of {@link ResourceDragController}
	 */
	public ResourceSearchResultVc(ResourceSearchResultDo resourceSearchResultDo, ResourceDragController searchDragController) {
		wrapperVcr = new ResourceSearchResultWrapperVc(searchDragController);
		this.res = ResourceSearchResultCBundle.INSTANCE;
		res.css().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));
		imgNotFriendly.setTitle(GL0737);
		imgNotFriendly.setAltText(GL0737);
		imgNotFriendly.setUrl("images/mos/ipadFriendly.png");
		setData(resourceSearchResultDo);
		wrapperVcr.addStyleName("resourceSearchResultBox");
		
		AppClientFactory.getEventBus().addHandler(UpdateSearchResultMetaDataEvent.TYPE,setUpdateMetaData);		
	}
	/**
	 * 
	 * @function updateViews 
	 * 
	 * @created_date : Aug 11, 2013
	 * 
	 * @description
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
		if (resourceSearchResultDo.getGooruOid().equalsIgnoreCase(contentId)){
			metaDataFloPanel.clear();
			String category = resourceSearchResultDo.getResourceFormat().getValue() != null ? resourceSearchResultDo.getResourceFormat().getValue() : "webpage";
			boolean shortenMetaLength = category.equalsIgnoreCase(VIDEO) || category.equalsIgnoreCase(QUESTION) ? true : false;
			
			String source = resourceSearchResultDo.getResourceSource() != null ? resourceSearchResultDo.getResourceSource().getAttribution() : null;
			SearchUiUtil.renderSourceMetadata(metaDataFloPanel, source ,null, shortenMetaLength ? 15 : 25);
			SearchUiUtil.renderMetaData(metaDataFloPanel, resourceSearchResultDo.getCourseNames(), shortenMetaLength ? 15 : 18);
			
	        SearchUiUtil.renderMetaData(metaDataFloPanel, count + (Integer.parseInt(count) == 1 ? VIEW : VIEWS));
			if (category.equalsIgnoreCase(VIDEO)) {
				SearchUiUtil.renderMetaData(metaDataFloPanel, StringUtil.stringToTime(resourceSearchResultDo.getDurationInSec()));
			} else if (category.equalsIgnoreCase(QUESTION)) {
				SearchUiUtil.renderMetaData(metaDataFloPanel, StringUtil.getQuestionType(resourceSearchResultDo.getQuestionType() !=null ? resourceSearchResultDo.getQuestionType() : ""));
			}
			if (resourceSearchResultDo.getNumOfPages() != null && !resourceSearchResultDo.getNumOfPages().equals("0") && !resourceSearchResultDo.getNumOfPages().equalsIgnoreCase(NULL) && resourceSearchResultDo.getNumOfPages().length() > 0) {
				SearchUiUtil.renderMetaData(metaDataFloPanel, resourceSearchResultDo.getNumOfPages() + PAGES);
			}
		}
	}
	/**
	 * Set resource search result meta data info such as title, image, description , etc..
	 * @param resourceSearchResultDo instance of {@link ResourceSearchResultDo}
	 */
	public void setData(ResourceSearchResultDo resourceSearchResultDo) {
		this.resourceSearchResultDo = resourceSearchResultDo;
		
		String category = resourceSearchResultDo.getResourceFormat().getValue() != null ? resourceSearchResultDo.getResourceFormat().getValue() : "webpage";
		wrapperVcr.setData(resourceSearchResultDo);
        String description = resourceSearchResultDo.getDescription();
        String title = "";
        String resourceTitle;
        if (resourceSearchResultDo.getResourceTitle().contains("class")){
        	title = resourceSearchResultDo.getResourceTitle();
        }else{
        	title = StringUtil.truncateText(resourceSearchResultDo.getResourceTitle(), 38);
        }
		boolean shortenMetaLength = category.equalsIgnoreCase(VIDEO) || category.equalsIgnoreCase(QUESTION) ? true : false;
		
		
		String source = resourceSearchResultDo.getResourceSource() != null ? resourceSearchResultDo.getResourceSource().getAttribution() : null;
		SearchUiUtil.renderSourceMetadata(metaDataFloPanel, source ,null, shortenMetaLength ? 15 : 25);
				SearchUiUtil.renderMetaData(metaDataFloPanel, resourceSearchResultDo.getCourseNames(), shortenMetaLength ? 15 : 18);
        SearchUiUtil.renderMetaData(metaDataFloPanel, resourceSearchResultDo.getTotalViews() + (resourceSearchResultDo.getTotalViews() == 1 ? VIEW : VIEWS));
		if (category.equalsIgnoreCase(VIDEO)) {
			SearchUiUtil.renderMetaData(metaDataFloPanel, StringUtil.stringToTime(resourceSearchResultDo.getDurationInSec()));
		} else if (category.equalsIgnoreCase(QUESTION)) {
			SearchUiUtil.renderMetaData(metaDataFloPanel, StringUtil.getQuestionType(resourceSearchResultDo.getQuestionType() !=null ? resourceSearchResultDo.getQuestionType() : ""));
		}
		if (resourceSearchResultDo.getNumOfPages() != null && !resourceSearchResultDo.getNumOfPages().equals("0") && !resourceSearchResultDo.getNumOfPages().equalsIgnoreCase(NULL) && resourceSearchResultDo.getNumOfPages().length() > 0) {
			SearchUiUtil.renderMetaData(metaDataFloPanel, resourceSearchResultDo.getNumOfPages() + PAGES);
		}
		title = title.replaceAll("<p>", "").replaceAll("</p>", "");
		lblResourceTitle.setHTML(title);
		resourceTitle=resourceSearchResultDo.getResourceTitle();
		lblResourceTitle.getElement().setId(resourceSearchResultDo.getGooruOid());
		if (lblResourceTitle.getText().length()>38){
			lblResourceTitle.getElement().getStyle().setWidth(350, Unit.PX);
		}
		String mediaType = resourceSearchResultDo.getMediaType();
		
		boolean setVisibility = mediaType !=null ?  mediaType.equalsIgnoreCase("not_iPad_friendly") ? true : false : false;
		
		imgNotFriendly.setVisible(setVisibility);
		
		if (imgNotFriendly.isVisible()){
			lblResourceTitle.getElement().getStyle().setFloat(Float.LEFT);
		}else{
			lblResourceTitle.getElement().getStyle().clearFloat();
		}
		
		
		imgNotFriendly.addMouseOverHandler(new MouseOverHandler() {
			
			@Override
			public void onMouseOver(MouseOverEvent event) {
				toolTip = new ToolTip(GL0454+""+"<img src='/images/mos/ipadFriendly.png' style='margin-top:0px;'/>"+" "+GL04431);
				toolTip.getElement().getStyle().setBackgroundColor("transparent");
				toolTip.getElement().getStyle().setZIndex(9999999);
				toolTip.getElement().getStyle().setPosition(Position.ABSOLUTE);
				toolTip.setPopupPosition(imgNotFriendly.getAbsoluteLeft()-(50+22), imgNotFriendly.getAbsoluteTop()+22);
				toolTip.show();
			}
		});
		imgNotFriendly.addMouseOutHandler(new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
				
				EventTarget target = event.getRelatedTarget();
				  if (Element.is(target)) {
					  if (!toolTip.getElement().isOrHasChild(Element.as(target))){
						  toolTip.hide();
					  }
				  }
			}
		});
		if(description!=null && description.length()>205){
			description = description.trim().substring(0, 205) +"...";	
		}
		resourceDescriptionHtml.setHTML(description);
		resourceTitleContainer.getElement().getStyle().setZIndex(99999);
		resourceImageUc.getElement().getStyle().setZIndex(99999);
		resourceImageUc.renderSearch(category, resourceSearchResultDo.getUrl(), null, resourceSearchResultDo.getGooruOid(), PLAYER_NAME, resourceTitle, false,"");
		SearchUiUtil.renderStandards(standardsFloPanel, resourceSearchResultDo);
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
	
	
	@UiHandler("resourceTitleContainer")
	public void onClickResourceTitle(ClickEvent event){
		MixpanelUtil.Preview_Resource_From_Search("ResourceTitleLbl");
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", resourceSearchResultDo.getGooruOid());
		params.put("pn", "resource");
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.RESOURCE_PLAY, params);
	}
	
	/**
	 * @return wrapperVcr instance of {@link ResourceSearchResultWrapperVc}
	 */
	public ResourceSearchResultWrapperVc getSearchResultVc() {
		return wrapperVcr;
	}

	/**
	 * @param searchResultVc instance of {@link ResourceSearchResultWrapperVc}
	 */
	public void setSearchResultVc(ResourceSearchResultWrapperVc searchResultVc) {
		this.wrapperVcr = searchResultVc;
	}

	@Override
	public String getDragId() {
		return resourceSearchResultDo.getGooruOid();
	}

	@Override
	public DRAG_TYPE getDragType() {
		return DRAG_TYPE.RESOURCE;
	}

	@Override
	public IsDraggableMirage initDraggableMirage() {
		return new ResourceDragWithImgUc(resourceSearchResultDo.getCategory(), resourceSearchResultDo.getResourceTitle());
	}

	/**
	 * @return the resourceSearchResultDo instance of {@link ResourceSearchResultDo}
	 */
	public ResourceSearchResultDo getResourceSearchResultDo() {
		return resourceSearchResultDo;
	}

	/**
	 * @param resourceSearchResultDo
	 *            the resourceSearchResultDo to set
	 */
	public void setResourceSearchResultDo(ResourceSearchResultDo resourceSearchResultDo) {
		this.resourceSearchResultDo = resourceSearchResultDo;
	}

	@Override
	public void onDragBlur() {
		getSearchResultVc().onMouseOut(null);
	}

	@Override
	public Widget getDragHandle() {
		return getSearchResultVc().getDragHandlePanel();
	}

	@Override
	public int getDragTopCorrection() {
		return 27;
	}

	@Override
	public int getDragLeftCorrection() {
		return 20;
	}

	@Override
	public void setAddedToShelf(boolean addedToShelf) {
		wrapperVcr.setAddedToShelf(addedToShelf);
	}

}
