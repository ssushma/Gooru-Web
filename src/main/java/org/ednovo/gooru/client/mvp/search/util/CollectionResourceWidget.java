package org.ednovo.gooru.client.mvp.search.util;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.rating.RatingWidgetView;
import org.ednovo.gooru.client.mvp.rating.events.DeletePlayerStarReviewEvent;
import org.ednovo.gooru.client.mvp.rating.events.DeletePlayerStarReviewHandler;
import org.ednovo.gooru.client.mvp.rating.events.UpdateResourceRatingCountEvent;
import org.ednovo.gooru.client.mvp.rating.events.UpdateResourceRatingCountEventHandler;
import org.ednovo.gooru.client.mvp.rating.events.UpdateResourceReviewCountEvent;
import org.ednovo.gooru.client.mvp.rating.events.UpdateResourceReviewCountEventHandler;
import org.ednovo.gooru.client.mvp.search.SearchUiUtil;
import org.ednovo.gooru.client.util.ImageUtil;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.search.CollectionSearchResultDo;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;
import org.ednovo.gooru.shared.model.search.SearchDo;
import org.ednovo.gooru.shared.util.ResourceImageUtil;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

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
	@UiField Anchor ancViewMore;

	private SearchDo<CollectionSearchResultDo> usedInSearchDo;

	private boolean failedThumbnailGeneration = false;

	private static final String DEFULT_IMAGE_PREFIX = "images/default-";

	private static String DEFULT_IMAGE = "images/default-collection-image.png";

	private static final String NULL = "null";

	private static final String PLAYER_NAME = "resource";

	private int updateReviewCount = 0;

	private ResourceSearchResultDo resourceSearchResultDo;

	private RatingWidgetView ratingWidgetView = null;

	public CollectionResourceWidget(ResourceSearchResultDo resourceSearchResultDo) {
		initWidget(uiBinder.createAndBindUi(this));
		String resourceTitleText=!StringUtil.isEmpty(resourceSearchResultDo.getResourceTitle())?resourceSearchResultDo.getResourceTitle():"";
		resourceTitle.setText(resourceTitleText);
		String resourceDesc=!StringUtil.isEmpty(resourceSearchResultDo.getDescription())?resourceSearchResultDo.getDescription():"";
		if(resourceDesc.length()>=120){
			resourceDesc=resourceDesc.substring(0, 120)+"...";
		}
		resourceDescription.getElement().setInnerText(resourceDesc);
		if(resourceSearchResultDo.getResourceUsedUserCount()>1)
		{
			ancViewMore.setVisible(true);
		}
		else
		{
			ancViewMore.setVisible(false);
		}
		if(resourceSearchResultDo.getResourceUsedUserCount()>0)
		{
			if(resourceSearchResultDo.getResourceUsedUserCount()==1)
			{
			lblUserCount.setText("Used by "+ resourceSearchResultDo.getResourceUsedUserCount()+" person");
			}
			else
			{
			lblUserCount.setText("Used by "+ resourceSearchResultDo.getResourceUsedUserCount()+" people");
			}
		}
		else
		{
			lblUserCount.setText("");
		}
		
		lbladdCount.setText(resourceSearchResultDo.getResourceAddedCount()+"");
		lblViewCount.setText(resourceSearchResultDo.getTotalViews()+"");
		String category = resourceSearchResultDo.getResourceFormat().getValue() != null ? resourceSearchResultDo.getResourceFormat().getValue() : "webpage";
		imageOverlay.addStyleName(category.toLowerCase()+"Small");
		setUrl(resourceSearchResultDo.getUrl(),null,category, resourceTitleText, false);
		SearchUiUtil.renderStandardsForresourceSearch(standardsDataPanel, resourceSearchResultDo);
		ratingWidgetView=new RatingWidgetView();
		ratingWidgetView.setAvgStarRating(resourceSearchResultDo.getRatings().getAverage()); 
		Integer reviewCount = resourceSearchResultDo.getRatings().getReviewCount();
		if (reviewCount == null) {
			reviewCount = 0;
		}

		if(reviewCount!=0){
			ratingWidgetView.getRatingCountLabel().setVisible(true);
			if(reviewCount==1){
				ratingWidgetView.getRatingCountLabel().setText(" "+reviewCount.toString()+" "+i18n.GL3006()); 
			}else{
				ratingWidgetView.getRatingCountLabel().setText(" "+reviewCount.toString()+" "+i18n.GL2024()); 
			}
		}else{
			ratingWidgetView.getRatingCountLabel().setVisible(false);
		}
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
						relatedCollectionTitle.addClickHandler(new ResourceCollectionHandler(result.getSearchResults().get(0).getGooruOid()));
						relatedCollectionImage.addClickHandler(new ResourceCollectionHandler(result.getSearchResults().get(0).getGooruOid()));
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

		
		//relatedCollectionTitle.addClickHandler(new ResourceCollectionHandler());

		StringUtil.setAttributes(standardsDataPanel.getElement(), "pnlStandards", "", "");
		StringUtil.setAttributes(ratingWidgetPanel.getElement(), "pnlRatings", "", "");
		StringUtil.setAttributes(resourceTitle.getElement(), "lblResourceTitle", "", "");
		StringUtil.setAttributes(lblViewCount.getElement(), "lblViewCount", "", "");
		StringUtil.setAttributes(lbladdCount.getElement(), "lbladdCount", "", "");
		StringUtil.setAttributes(lblUserCount.getElement(), "lbladdCount", "", "");
		StringUtil.setAttributes(creatorImage.getElement(), "imgCreator", "", "");
		StringUtil.setAttributes(relatedCollectionImage.getElement(), "imgRelatedCollection", "", "");
		StringUtil.setAttributes(relatedCollectionTitle.getElement(), "lblRelatedCollectionTitle", "", "");
		StringUtil.setAttributes(resourceDescription.getElement(), "pnlResourceDescription", "", "");
		StringUtil.setAttributes(imageOverlay.getElement(), "imageOverlay", "", "");
		StringUtil.setAttributes(btnAddResource.getElement(), "btnAddResource", "", "");
		StringUtil.setAttributes(resourseImage.getElement(), "imgResoruce", "", "");

		AppClientFactory.getEventBus().addHandler(
				UpdateResourceRatingCountEvent.TYPE, setRatingCount);
		AppClientFactory.getEventBus().addHandler(
				DeletePlayerStarReviewEvent.TYPE, deleteStarRating);
		AppClientFactory.getEventBus().addHandler(
				UpdateResourceReviewCountEvent.TYPE, setReviewCount);
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
			GWT.runAsync(new RunAsyncCallback() {
				@Override
				public void onFailure(Throwable reason) {
				}
				@Override
				public void onSuccess() {
					Map<String, String> params = new HashMap<String, String>();
					params.put("id", resoruceId);
					params.put("pn", PLAYER_NAME);
					AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.RESOURCE_PLAY, params);	
				}
			});
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
	public void setUpdateReviewCount(Integer updateReviewCount) {
		// TODO Auto-generated method stub
		this.updateReviewCount = updateReviewCount;
		ratingWidgetView.getRatingCountLabel().getElement()
		.removeAttribute("class");
		if (updateReviewCount > 0) {
			ratingWidgetView
			.getRatingCountLabel()
			.getElement()
			.setAttribute("style",
					"cursor: pointer;text-decoration: none !important;color: #1076bb;");
			ratingWidgetView.getRatingCountLabel().getElement().getStyle()
			.setPadding(4, Unit.PX);
		} else {
			ratingWidgetView
			.getRatingCountLabel()
			.getElement()
			.setAttribute("style",
					"cursor: none;text-decoration: none !important;color: #4e9746;");
		}

	}
	/**
	 * @return the ratingWidgetView
	 */
	public RatingWidgetView getRatingWidgetView() {
		return ratingWidgetView;
	}
	/**
	 * @param ratingWidgetView the ratingWidgetView to set
	 */
	public void setRatingWidgetView(RatingWidgetView ratingWidgetView) {
		this.ratingWidgetView = ratingWidgetView;
	}
	/**
	 * @return the updateReviewCount
	 */
	public int getUpdateReviewCount() {
		return updateReviewCount;
	}
	/**
	 * @param updateReviewCount the updateReviewCount to set
	 */
	public void setUpdateReviewCount(int updateReviewCount) {
		this.updateReviewCount = updateReviewCount;
	}

	public Anchor getAncViewMore() {
		return ancViewMore;
	}

	UpdateResourceReviewCountEventHandler setReviewCount = new UpdateResourceReviewCountEventHandler() {
		@Override
		public void setReviewCount(String resourceId,Integer count) {
			if(resourceSearchResultDo.getGooruOid().equals(resourceId)){
				if(count!=0){
					ratingWidgetView.getRatingCountLabel().setVisible(true); 
					setUpdateReviewCount(count);
					if(count==1){
						ratingWidgetView.getRatingCountLabel().setText(" "+Integer.toString(count)+" "+i18n.GL3006()); 
					}else{
						ratingWidgetView.getRatingCountLabel().setText(" "+Integer.toString(count)+" "+i18n.GL2024());
					}
				}else{
					ratingWidgetView.getRatingCountLabel().setVisible(false);
				}
				ratingWidgetView.getAverageRatingLabel().setVisible(false);

			}
		}

	};

	UpdateResourceRatingCountEventHandler setRatingCount = new UpdateResourceRatingCountEventHandler() {
		@Override
		public void setResourceRatingCount(String resourceId, double avg,
				Integer count) {
			if (resourceSearchResultDo.getGooruOid().equals(resourceId)) {
				ratingWidgetView.setAvgStarRating(avg);
			}
		}

	};

	DeletePlayerStarReviewHandler deleteStarRating = new DeletePlayerStarReviewHandler() {
		@Override
		public void deleteStarRatings(String resourceGooruOid) {
			if(resourceSearchResultDo.getGooruOid().equals(resourceGooruOid)){
				if(ratingWidgetView!=null){
					String[] revCount = ratingWidgetView.getRatingCountLabel().getText().split(" "); 
					if(Integer.parseInt(revCount[1].trim())==1){
						ratingWidgetView.setAvgStarRating(0);
						ratingWidgetView.getRatingCountLabel().setVisible(false);	
						/**
						 * Commented the following code as 0 reviews we should not show.
						 */
						/*ratingWidgetView.getRatingCountLabel().setText(" "+ (Integer.parseInt(revCount[1])-1)+" "+i18n.GL2024());
						setUpdateReviewCount(Integer.parseInt(revCount[1])-1);*/
					}else{
						ratingWidgetView.getRatingCountLabel().setVisible(true); 
						setUpdateReviewCount(Integer.parseInt(revCount[1])-1);
						if((Integer.parseInt(revCount[1])-1)==1){
							ratingWidgetView.getRatingCountLabel().setText(" "+(Integer.parseInt(revCount[1])-1)+" "+i18n.GL3006());  
						}else{
							ratingWidgetView.getRatingCountLabel().setText(" "+(Integer.parseInt(revCount[1])-1)+" "+i18n.GL2024()); 
						}

					}
				}
			}
		}

	};
	
 public class ResourceCollectionHandler implements ClickHandler{
    String gooruOid;
	public ResourceCollectionHandler(String gooruOid) {
		this.gooruOid=gooruOid;
	}

	@Override
	public void onClick(ClickEvent event) {
		GWT.runAsync(new RunAsyncCallback() {
			
			@Override
			public void onSuccess() {
				Map<String, String> params = new HashMap<String, String>();
				params.put("id", gooruOid);
				PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.COLLECTION_PLAY, params);
				AppClientFactory.getPlaceManager().revealPlace(false,placeRequest,true);
			}
			
			@Override
			public void onFailure(Throwable reason) {
				
			}
		});
	}
	 
 }

}
