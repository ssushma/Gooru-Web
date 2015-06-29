
/**
 * 
*/
package org.ednovo.gooru.client.mvp.classpage.teach.edit;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;


/**
 * @fileName : EditClassPresenter.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 26-Jun-2015
 *
 * @Author tumbalam
 *
 * @Reviewer: 
 */
public class EditClassPresenter extends PresenterWidget<IsEditClassView> implements EditClassViewUiHandlers{
	
	@Inject
	public EditClassPresenter(EventBus eventBus,IsEditClassView view){
		super(eventBus, view);
		getView().setUiHandlers(this);
	}
	
	@Override
	public void onBind() {
		super.onBind();
		
	}

	@Override
	public void onReveal() {
		super.onReveal();
	}

	@Override
	protected void onHide() {
		super.onHide();
	}

}
