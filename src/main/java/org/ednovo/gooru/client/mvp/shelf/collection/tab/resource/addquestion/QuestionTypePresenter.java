package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.addquestion;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter;
import org.ednovo.gooru.client.mvp.shelf.event.AddResouceImageEvent;
import org.ednovo.gooru.client.service.ResourceServiceAsync;

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
	private SimpleAsyncCallback<Void> removeQuestionImageAsyncCallback; 
	@Inject
	private ResourceServiceAsync resourceService;
	/**
	 * Class Constructor
	 * @param eventBus {@link EventBus}
	 * @param view {@link View}
	 */
	@Inject
	public QuestionTypePresenter(EventBus eventBus, IsQuestionTypeView view) {
		super(eventBus, view);
		getView().setUiHandlers(this);
		addRegisteredHandler(AddResouceImageEvent.TYPE, this);
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
	
	
	public void ImageUpload(ImageUploadPresenter imageUploadPresenter){
		this.imageUploadPresenter=imageUploadPresenter;
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


}