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
package org.ednovo.gooru.client.uc;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.util.ImageUtil;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.ResourceImageUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : ResourceImageUc.java
 *
 * @description : This class is used to show the resource image.
 *
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class ResourceImageUc extends Composite implements ClickHandler {

	private static ResourceImageUcUiBinder uiBinder = GWT.create(ResourceImageUcUiBinder.class);

	interface ResourceImageUcUiBinder extends UiBinder<Widget, ResourceImageUc> {
	}

	@UiField
	Label resourceType;

	@UiField
	Image image;

	@UiField(provided = true)
	UcCBundle res;

	@UiField
	FlowPanel resourceThumbnail;

	private String resourceId;

	private String playerName;

	private static final String DEFULT_IMAGE_PREFIX = "images/default-";

	private static final String NULL = "null";

//	private static final String DEFAULT_THUMBNAIL = "slides/thumbnail.jpg";

	private boolean failedThumbnailGeneration = false;

	/**
	 * Class constructor
	 */
	private static final String SMALL = "Small";

	private static final String PNG = ".png";
/**
 * Class constructor.
 */
	public ResourceImageUc() {
		this.res = UcCBundle.INSTANCE;
		res.css().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));
		addDomHandler(this, ClickEvent.getType());
	}

	/**
	 * Class constructor with multi parameter
	 * 
	 * @param category
	 *            of the resource
	 * @param thumbnailUrl
	 *            of the image
	 * @param gooruOid
	 *            of the resource
	 * @param playerName
	 */
	public ResourceImageUc(String category, String thumbnailUrl, String realUrl, String gooruOid, String playerName, String title, boolean generateYoutube) {
		this();
		renderSearch(category, thumbnailUrl, realUrl, gooruOid, playerName, title, generateYoutube);
	}

	/**
	 * Set resource image info
	 * 
	 * @param category
	 *            of the resource
	 * @param thumbnailUrl
	 *            of the image
	 * @param gooruOid
	 *            of the resource
	 * @param playerName
	 */
	public void renderSearch(String category, String thumbnailUrl, String realUrl, String gooruOid, String playerName, String title, boolean generateYoutube) {
		final String categoryString = category == null || category.startsWith("assessment") ? ImageUtil.QUESTION : category.toLowerCase();
		resourceType.addStyleName(categoryString + SMALL);
		setUrl(thumbnailUrl, realUrl, categoryString, title, generateYoutube);
		setResourceId(gooruOid);
		setPlayerName(playerName);
	}
	/**
	 * @function setUrl 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : set the resoruce url
	 * 
	 * 
	 * @parm(s) : @param thumbnailUrl
	 * @parm(s) : @param realUrl
	 * @parm(s) : @param category
	 * @parm(s) : @param title
	 * @parm(s) : @param generateYoutube
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setUrl(final String thumbnailUrl, final String realUrl, final String category, final String title, final boolean generateYoutube) {
		failedThumbnailGeneration = false;
		final String categoryString = category == null || category.startsWith("assessment") ? ImageUtil.QUESTION : category;
		image.addErrorHandler(new ErrorHandler() {

			@Override
			public void onError(ErrorEvent event) {
				setDefaultThumbnail(thumbnailUrl, realUrl, categoryString, generateYoutube);
				failedThumbnailGeneration = true;
			}
		});
		if (thumbnailUrl == null || thumbnailUrl.endsWith(NULL)) {
			setDefaultThumbnail(thumbnailUrl, realUrl, categoryString, generateYoutube);
		} else {
		
			image.setUrl(thumbnailUrl);
		}
		image.setAltText(title);
		image.setTitle(title);
	}
	/**
	 * 
	 * @function setDefaultThumbnail 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :set the default image.
	 * 
	 * 
	 * @parm(s) : @param thumbnailUrl
	 * @parm(s) : @param url
	 * @parm(s) : @param categoryString
	 * @parm(s) : @param generateYoutube
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private void setDefaultThumbnail(String thumbnailUrl, String url, String categoryString, boolean generateYoutube) {
		if (generateYoutube) {
			String protocol = AppClientFactory.getLoggedInUser().getSettings().getHomeEndPoint().contains(MessageProperties.HTTPS)?MessageProperties.HTTPS:MessageProperties.HTTP;
			image.setUrl(ResourceImageUtil.youtubeImageLink(ResourceImageUtil.getYoutubeVideoId(url), protocol));
		} else if (!failedThumbnailGeneration && thumbnailUrl!=null && thumbnailUrl.endsWith("/")) {
			//image.setUrl(thumbnailUrl + DEFAULT_THUMBNAIL);
			image.setUrl(DEFULT_IMAGE_PREFIX + categoryString + PNG);
		} else {
			image.setUrl(DEFULT_IMAGE_PREFIX + categoryString + PNG);
		}
	}
	/**
	 * this will handle the click event.
	 */
	@Override
	public void onClick(ClickEvent event) {
		//Implementing Mixpanel
		if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.PROFILE_PAGE)) {
			MixpanelUtil.Preview_Resource_From_Profile("ResourceImageUc");
		} else {
			MixpanelUtil.Preview_Resource_From_Search("ResourceImageUc");
		}		
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", getResourceId());
		params.put("pn", getPlayerName());
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.RESOURCE_PLAY, params);
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerName() {
		return playerName;
	}
}
