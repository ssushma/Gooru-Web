package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.addquestion;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

/**
 * @author Hari
 *
 */
public class QuestionTypePresenter extends PresenterWidget<IsQuestionTypeView> implements QuestionTypeUiHandlers {

	/**
	 * Class Constructor
	 * @param eventBus {@link EventBus}
	 * @param view {@link View}
	 */
	@Inject
	public QuestionTypePresenter(EventBus eventBus, IsQuestionTypeView view) {
		super(eventBus, view);
	}

	@Override
	public void onBind() {
		super.onBind();
	}
	
	@Override
	protected void onReveal() {
		super.onReveal();
		getView().getRevealType();
	}

	
	

}