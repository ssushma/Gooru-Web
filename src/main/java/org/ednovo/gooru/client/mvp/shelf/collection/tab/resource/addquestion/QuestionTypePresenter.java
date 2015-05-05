package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.addquestion;

import java.util.List;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.home.library.events.StandardPreferenceSettingEvent;
import org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter;
import org.ednovo.gooru.client.mvp.search.standards.AddStandardsPresenter;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.IsAddResourceView;
import org.ednovo.gooru.client.mvp.shelf.event.AddResouceImageEvent;
import org.ednovo.gooru.client.service.ResourceServiceAsync;
import org.ednovo.gooru.shared.model.user.ProfileDo;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

/**
 * @author Hari
 *
 */
public class QuestionTypePresenter extends PresenterWidget<IsQuestionTypeView> implements QuestionTypeUiHandlers {

	private ImageUploadPresenter imageUploadPresenter;
	private IsAddResourceView isAddResourceView;
	private SimpleAsyncCallback<Void> removeQuestionImageAsyncCallback; 
	@Inject
	private ResourceServiceAsync resourceService;
	
    private static final String USER_META_ACTIVE_FLAG = "0";
   	
	private boolean isCCSSAvailable =false;
	private boolean isNGSSAvailable =false;
	private boolean isTEKSAvailable =false;
	private boolean isCAAvailable =false;
	
	private boolean isQuestionResource = false;
	private boolean isUserResource = false;
	
	AddStandardsPresenter addStandardsPresenter = null;
	/**
	 * Class Constructor
	 * @param eventBus {@link EventBus}
	 * @param view {@link View}
	 */
	@Inject
	public QuestionTypePresenter(EventBus eventBus, IsQuestionTypeView view,AddStandardsPresenter addStandardsPresenter) {
		super(eventBus, view);
		getView().setUiHandlers(this);
		addRegisteredHandler(AddResouceImageEvent.TYPE, this);
		this.addStandardsPresenter = addStandardsPresenter;
	}

	@Override
	public void onBind() {
		super.onBind();
	}
	
	public ResourceServiceAsync getResourceService() {
		return resourceService;
	}

	public void setResourceService(ResourceServiceAsync resourceService) {
		this.resourceService = resourceService;
	}
	
	public SimpleAsyncCallback<Void> getRemoveQuestionImageAsyncCallback() {
		return removeQuestionImageAsyncCallback;
	}

	public void setRemoveQuestionImageAsyncCallback(
			SimpleAsyncCallback<Void> removeQuestionImageAsyncCallback) {
		this.removeQuestionImageAsyncCallback = removeQuestionImageAsyncCallback;
	}
	
	
	public void ImageUpload(ImageUploadPresenter imageUploadPresenter,IsAddResourceView view){
		this.imageUploadPresenter=imageUploadPresenter;
		this.isAddResourceView =view;
	}
	
	
	@Override
	protected void onReveal() {
		super.onReveal();
		getView().getRevealType();
	}

	@Override
	public void setResourceImageUrl(String fileName,String fileNameWithoutRepository,boolean isQuestionImage,boolean isUserOwnResourceImage) {
		getView().setImageUrl(fileName,fileNameWithoutRepository,isQuestionImage,isUserOwnResourceImage);	
	}

	@Override
	public void removeQuestionImage(String collectionItemId) {
		getResourceService().removeQuestionImage(collectionItemId, getRemoveQuestionImageAsyncCallback());
	}

	@Override
	public void questionImageUpload(String collectionItemId) {
		
			addToPopupSlot(imageUploadPresenter);
			imageUploadPresenter.setCollectionImage(false);
			imageUploadPresenter.setUpdateQuestionImage(true);
			imageUploadPresenter.setCollectionItemId(collectionItemId);
			imageUploadPresenter.setEditResourceImage(false);
	        imageUploadPresenter.setQuestionImage(false);
	        imageUploadPresenter.setUserOwnResourceImage(false);
	        imageUploadPresenter.setEditUserOwnResourceImage(false);
	        imageUploadPresenter.getView().isFromEditQuestion(true);
	}

	@Override
	public void questionImageUpload() {
		addToPopupSlot(imageUploadPresenter);
		imageUploadPresenter.setCollectionImage(false);
		imageUploadPresenter.setQuestionImage(true);
		imageUploadPresenter.setEditResourceImage(false);
		imageUploadPresenter.setUserOwnResourceImage(false);
		imageUploadPresenter.setEditUserOwnResourceImage(false);
		imageUploadPresenter.getView().isFromEditQuestion(true);
	}
	
	@Override
	public void answerImageUpload() {
		addToPopupSlot(imageUploadPresenter);
		imageUploadPresenter.setCollectionImage(false);
		imageUploadPresenter.setQuestionImage(false);
		imageUploadPresenter.setEditResourceImage(false);
		imageUploadPresenter.setUserOwnResourceImage(false);
		imageUploadPresenter.setEditUserOwnResourceImage(false);
		imageUploadPresenter.setAnswerImage(true);
		imageUploadPresenter.getView().isFromEditQuestion(false);
	}

	@Override
	public void browseStandardsInfo(final boolean isQuestion,final boolean isUserOwnResource) {
		AppClientFactory.getInjector().getUserService().getUserProfileV2Details(AppClientFactory.getLoggedInUser().getGooruUId(),
				USER_META_ACTIVE_FLAG,
				new SimpleAsyncCallback<ProfileDo>() {
					@Override
					public void onSuccess(final ProfileDo profileObj) {
					AppClientFactory.fireEvent(new StandardPreferenceSettingEvent(profileObj.getUser().getMeta().getTaxonomyPreference().getCode()));
					checkStandarsList(profileObj.getUser().getMeta().getTaxonomyPreference().getCode());
					}
					public void checkStandarsList(List<String> standarsPreferencesList) {
						
					if(standarsPreferencesList!=null){
							if(standarsPreferencesList.contains("CCSS")){
								isCCSSAvailable = true;
							}else{
								isCCSSAvailable = false;
							}
							if(standarsPreferencesList.contains("NGSS")){
								isNGSSAvailable = true;
							}else{
								isNGSSAvailable = false;
							}
							if(standarsPreferencesList.contains("TEKS")){
								isTEKSAvailable = true;
							}else{
								isTEKSAvailable = false;
							}
							if(standarsPreferencesList.contains("CA")){
								isCAAvailable = true;
							}else{
								isCAAvailable = false;
							}
								if(isCCSSAvailable || isNGSSAvailable || isTEKSAvailable || isCAAvailable){
									isQuestionResource = isQuestion;
									isUserResource = isUserOwnResource;
									addStandardsPresenter.enableStandardsData(isCCSSAvailable,isTEKSAvailable,isNGSSAvailable,isCAAvailable);
									addToPopupSlot(addStandardsPresenter);
									getView().OnBrowseStandardsClickEvent(addStandardsPresenter.getAddBtn());
								}
					}
						
					}

				});
	}

	@Override
	public void addUpdatedBrowseStandards() {
		getView().setUpdatedStandardsCode(addStandardsPresenter.setStandardsVal(),addStandardsPresenter.setStandardsIdVal(),addStandardsPresenter.setStandardDesc());
	}

	@Override
	public void closeStandardsPopup() {
		addStandardsPresenter.hidePopup();
	}

	@Override
	public void hidePopup() {
		isAddResourceView.hidePopup();
	}

	@Override
	public void removeAnswerImage(String collectionItemId) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void answerImageUpload(String collectionItemId) {
		throw new RuntimeException("Not implemented");
	}



}