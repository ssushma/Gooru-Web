package org.ednovo.gooru.client.mvp.search.util;

import org.ednovo.gooru.client.mvp.rating.RatingWidgetView;
import org.ednovo.gooru.client.mvp.search.SearchUiUtil;
import org.ednovo.gooru.client.util.ImageUtil;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;
import org.ednovo.gooru.shared.util.ResourceImageUtil;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class CollectionResourceWidget extends Composite {

	private static CollectionResourceWidgetUiBinder uiBinder = GWT
			.create(CollectionResourceWidgetUiBinder.class);

	interface CollectionResourceWidgetUiBinder extends
			UiBinder<Widget, CollectionResourceWidget> {
	}
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	@UiField Label resourceTitle,lblViewCount;
	@UiField HTMLPanel resourceDescription,imageOverlay;
	@UiField Image resoruceImage;
	@UiField FlowPanel standardsDataPanel,ratingWidgetPanel;
	
	private boolean failedThumbnailGeneration = false;
	
	private static final String DEFULT_IMAGE_PREFIX = "images/default-";
	
	private static final String NULL = "null";
	
	RatingWidgetView ratingWidgetView;
	
	public CollectionResourceWidget(ResourceSearchResultDo resourceSearchResultDo) {
		initWidget(uiBinder.createAndBindUi(this));
		String resourceTitleText=!StringUtil.isEmpty(resourceSearchResultDo.getResourceTitle())?resourceSearchResultDo.getResourceTitle():"";
		resourceTitle.setText(resourceTitleText);
		String resourceDesc=!StringUtil.isEmpty(resourceSearchResultDo.getDescription())?resourceSearchResultDo.getDescription():"";
		if(resourceDesc.length()>=120){
			resourceDesc=resourceDesc.substring(0, 120)+"...";
		}
		resourceDescription.getElement().setInnerText(resourceDesc);
		lblViewCount.setText(resourceSearchResultDo.getTotalViews()+"");
		resoruceImage.setUrl("");
		String category = resourceSearchResultDo.getResourceFormat().getValue() != null ? resourceSearchResultDo.getResourceFormat().getValue() : "webpage";
		imageOverlay.addStyleName(category.toLowerCase()+"Small");
		setUrl(resourceSearchResultDo.getUrl(),null,category, resourceTitleText, false);
		SearchUiUtil.renderStandards(standardsDataPanel, resourceSearchResultDo);
		ratingWidgetView=new RatingWidgetView();
		ratingWidgetView.setAvgStarRating(resourceSearchResultDo.getRatings().getAverage()); 
		ratingWidgetPanel.add(ratingWidgetView);
	}
	/**
	 * This method will set the thumbnail image
	 * @param thumbnailUrl
	 * @param realUrl
	 * @param category
	 * @param title
	 * @param generateYoutube
	 */
	public void setUrl(final String thumbnailUrl, final String realUrl, final String category, final String title, final boolean generateYoutube) {
		failedThumbnailGeneration = false;
		final String categoryString = category == null || category.startsWith("assessment") ? ImageUtil.QUESTION : category;
		resoruceImage.addErrorHandler(new ErrorHandler() {
			@Override
			public void onError(ErrorEvent event) {
				setDefaultThumbnail(thumbnailUrl, realUrl, categoryString, generateYoutube);
				failedThumbnailGeneration = true;
			}
		});
		if (thumbnailUrl == null || thumbnailUrl.endsWith(NULL) || thumbnailUrl.equalsIgnoreCase("") ) {
			setDefaultThumbnail(thumbnailUrl, realUrl, categoryString.trim(), generateYoutube);
		} else {
			resoruceImage.setUrl(thumbnailUrl);
		}
		resoruceImage.setAltText(title);
		resoruceImage.setTitle(title);
	}
	/**
	 * This method will set the default image
	 * @param thumbnailUrl
	 * @param url
	 * @param categoryString
	 * @param generateYoutube
	 */
	private void setDefaultThumbnail(String thumbnailUrl, String url, String categoryString, boolean generateYoutube) {
		categoryString = StringUtil.getCategory(categoryString.trim().replaceAll("gooru_classplan", "webpage"));
		if(generateYoutube) {
			resoruceImage.setUrl(ResourceImageUtil.youtubeImageLink(ResourceImageUtil.getYoutubeVideoId(url), Window.Location.getProtocol()));
		}else if (!failedThumbnailGeneration && thumbnailUrl!=null && thumbnailUrl.endsWith("/")) {
			resoruceImage.setUrl(DEFULT_IMAGE_PREFIX + categoryString + i18n.GL0899());
		}else {
			resoruceImage.setUrl(DEFULT_IMAGE_PREFIX + categoryString + i18n.GL0899());
		}
	}
}
