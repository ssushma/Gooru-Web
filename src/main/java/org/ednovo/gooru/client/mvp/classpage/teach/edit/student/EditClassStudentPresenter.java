
/**
 * 
*/
package org.ednovo.gooru.client.mvp.classpage.teach.edit.student;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;


/**
 * @fileName : EditClassStudentPresenter.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 03-Jul-2015
 *
 * @Author tumbalam
 *
 * @Reviewer: 
 */
public class EditClassStudentPresenter extends PresenterWidget<IsEditClassStudentView> implements EditClassStudentViewUiHandler{
	
	
	@Inject
	public EditClassStudentPresenter(EventBus eventBus,IsEditClassStudentView view){
		super(eventBus, view);
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
