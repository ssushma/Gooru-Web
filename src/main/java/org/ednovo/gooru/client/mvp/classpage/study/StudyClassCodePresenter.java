
/**
 * 
*/
package org.ednovo.gooru.client.mvp.classpage.study;

import org.ednovo.gooru.application.client.child.ChildPresenter;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.model.content.ClasspageDo;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;


/**
 * @fileName : StudyClassCodePresenter.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 21-Jul-2015
 *
 * @Author tumbalam
 *
 * @Reviewer: 
 */
public class StudyClassCodePresenter extends ChildPresenter<StudyClassCodePresenter,IsStudyClassCodeView> implements StudyClassCodeUiHandlers{
	
	
	
	@Inject
	public StudyClassCodePresenter(IsStudyClassCodeView view){
		super(view);
	}

	
	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.classpage.study.StudyClassCodeUiHandlers#createNewClass(java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public void createNewClass(String title, String grade, boolean sharing) {
		System.out.println("createNew class");
		AppClientFactory.getInjector().getClasspageService().createClass(title, grade, sharing, new AsyncCallback<ClasspageDo>() {
			
			@Override
			public void onSuccess(ClasspageDo result) {
				getView().setCreatedClass(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				
			}
		});
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.classpage.study.StudyClassCodeUiHandlers#getClassData(java.lang.String)
	 */
	@Override
	public void getClassData(String classCodeText) {
		AppClientFactory.getInjector().getClasspageService().v3GetClassById(classCodeText, new AsyncCallback<ClasspageDo>() {

			@Override
			public void onFailure(Throwable caught) {
				
			}

			@Override
			public void onSuccess(ClasspageDo result) {
				getView().setClassData(result);
			}
		});
	}
	
	
}
