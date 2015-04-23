package org.ednovo.gooru.client.mvp.search.util;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.rating.RatingWidgetView;
import org.ednovo.gooru.client.mvp.search.SearchUiUtil;
import org.ednovo.gooru.client.util.ImageUtil;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.search.CollectionSearchResultDo;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;
import org.ednovo.gooru.shared.model.search.SearchDo;
import org.ednovo.gooru.shared.util.ResourceImageUtil;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class CollectionResourceWidget extends Composite {

	private static CollectionResourceWidgetUiBinder uiBinder = GWT
			.create(CollectionResourceWidgetUiBinder.class);

	interface CollectionResourceWidgetUiBinder extends
			UiBinder<Widget, CollectionResourceWidget> {
	}
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	@UiField Label resourceTitle,lblViewCount,lbladdCount;
	@UiField InlineLabel lblUserCount;
	@UiField HTMLPanel resourceDescription,imageOverlay;
	@UiField Image resourseImage,relatedCollectionImage,creatorImage;
	@UiField FlowPanel standardsDataPanel,ratingWidgetPanel;
	@UiField InlineLabel relatedCollectionTitle;
	@UiField Button btnAddResource;
	
	private SearchDo<CollectionSearchResultDo> usedInSearchDo;
	
	private boolean failedThumbnailGeneration = false;
	
	private static final String DEFULT_IMAGE_PREFIX = "images/default-";
	private static String DEFULT_IMAGE = "images/default-collection-image.png";
	
	private static final String NULL = "null";
	
	private static final String PLAYER_NAME = "resource";
	
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
		lblUserCount.setText("Used by "+ resourceSearchResultDo.getResourceUsedUserCount()+" poeple");
		lbladdCount.setText(resourceSearchResultDo.getResourceAddedCount()+"");
		lblViewCount.setText(resourceSearchResultDo.getTotalViews()+"");
		String category = resourceSearchResultDo.getResourceFormat().getValue() != null ? resourceSearchResultDo.getResourceFormat().getValue() : "webpage";
		imageOverlay.addStyleName(category.toLowerCase()+"Small");
		setUrl(resourceSearchResultDo.getUrl(),null,category, resourceTitleText, false);
		SearchUiUtil.renderStandards(standardsDataPanel, resourceSearchResultDo);
		ratingWidgetView=new RatingWidgetView();
		ratingWidgetView.setAvgStarRating(resourceSearchResultDo.getRatings().getAverage()); 
		ratingWidgetPanel.add(ratingWidgetView);
		
		resourseImage.addClickHandler(new ResourceImageClick(resourceSearchResultDo.getGooruOid()));
		resourceTitle.addClickHandler(new ResourceImageClick(resourceSearchResultDo.getGooruOid()));
		imageOverlay.addDomHandler(new ResourceImageClick(resourceSearchResultDo.getGooruOid()),ClickEvent.getType());
		
		usedInSearchDo = new SearchDo<CollectionSearchResultDo>();
		usedInSearchDo.setQuery(resourceSearchResultDo.getGooruOid());  
		usedInSearchDo.setPageSize(1);
		AppClientFactory.getInjector().getSearchService().getResourceCollections(usedInSearchDo,new SimpleAsyncCallback<SearchDo<CollectionSearchResultDo>>() {
			@Override
			public void onSuccess(SearchDo<CollectionSearchResultDo> result) {
				if(result.getSearchResults().size()>0){
					relatedCollectionImage.setVisible(true);
					creatorImage.setVisible(true);
					if(!StringUtil.isEmpty(result.getSearchResults().get(0).getUrl())){
						relatedCollectionImage.setUrl(result.getSearchResults().get(0).getUrl());
						relatedCollectionTitle.setStyleName("collectionTitle");
						relatedCollectionTitle.setText(result.getSearchResults().get(0).getResourceTitle());
						relatedCollectionTitle.setTitle(result.getSearchResults().get(0).getResourceTitle());
						creatorImage.setUrl(AppClientFactory.getLoggedInUser().getSettings().getProfileImageUrl()+result.getSearchResults().get(0).getGooruUId()+".png");
					}
				}
				else
				{
					relatedCollectionImage.setVisible(false);
					creatorImage.setVisible(false);
					relatedCollectionTitle.setStyleName("collectionTitleNoCollection");
					relatedCollectionTitle.setText(i18n.GL3212());
				}
			}
		});
		
		relatedCollectionImage.addErrorHandler(new ErrorHandler() {
			@Override
			public void onError(ErrorEvent event) {
				relatedCollectionImage.setUrl(DEFULT_IMAGE);
			}
		});
		creatorImage.addErrorHandler(new ErrorHandler() {
			@Override
			public void onError(ErrorEvent event) {
				creatorImage.setUrl("images/profilepage/user-profile-pic.png");
			}
		});
	}
	/**
	 * This inner class will handle the click event on the resource image click and it will play that resoruce
	 * @author Gooru
	 *
	 */
	public class ResourceImageClick implements ClickHandler{
		String resoruceId;
		ResourceImageClick(String resoruceId){
			this.resoruceId=resoruceId;
		}
		@Override
		public void onClick(ClickEvent event) {
			Map<String, String> params = new HashMap<String, String>();
			params.put("id", resoruceId);
			params.put("pn", PLAYER_NAME);
			AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.RESOURCE_PLAY, params);	
		}
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
		resourseImage.addErrorHandler(new ErrorHandler() {
			@Override
			public void onError(ErrorEvent event) {
				setDefaultThumbnail(thumbnailUrl, realUrl, categoryString, generateYoutube);
				failedThumbnailGeneration = true;
			}
		});
		if (thumbnailUrl == null || thumbnailUrl.endsWith(NULL) || thumbnailUrl.equalsIgnoreCase("") ) {
			setDefaultThumbnail(thumbnailUrl, realUrl, categoryString.trim(), generateYoutube);
		} else {
			resourseImage.setUrl(thumbnailUrl);
		}
		resourseImage.setAltText(title);
		resourseImage.setTitle(title);
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
			resourseImage.setUrl(ResourceImageUtil.youtubeImageLink(ResourceImageUtil.getYoutubeVideoId(url), Window.Location.getProtocol()));
		}else if (!failedThumbnailGeneration && thumbnailUrl!=null && thumbnailUrl.endsWith("/")) {
			resourseImage.setUrl(DEFULT_IMAGE_PREFIX + categoryString + i18n.GL0899());
		}else {
			resourseImage.setUrl(DEFULT_IMAGE_PREFIX + categoryString + i18n.GL0899());
		}
	}
	/**
	 * This method will return the add button
	 * @return
	 */
	public Button getAddResoruce(){
		return btnAddResource;
	}
}
