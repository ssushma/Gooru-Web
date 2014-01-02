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
package org.ednovo.gooru.client.mvp.classpages.studentView;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SeoTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BasePlacePresenter;
import org.ednovo.gooru.client.mvp.authentication.SignUpPresenter;
import org.ednovo.gooru.client.mvp.classpages.studentView.StudentAssignmentPresenter.IsStudentAssignmentProxy;
import org.ednovo.gooru.client.mvp.home.event.HeaderTabType;
import org.ednovo.gooru.client.mvp.home.event.HomeEvent;
import org.ednovo.gooru.client.mvp.search.event.ConfirmStatusPopupEvent;
import org.ednovo.gooru.client.mvp.search.event.SetFooterEvent;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.service.ClasspageServiceAsync;
import org.ednovo.gooru.shared.model.content.AssignmentsListDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;

import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
/**
 * 
 * @fileName : StudentAssignmentPresenter.java
 *
 * @description : This is the presenter for the Student Assignment View.
 *
 * @version : 1.0
 *
 * @date: 27-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */

public class StudentAssignmentPresenter extends BasePlacePresenter<IsStudentAssignmentView, IsStudentAssignmentProxy> implements StudentAssignmentUiHandlers {

	
	@Inject
	private ClasspageServiceAsync classpageServiceAsync;
	
	private SimpleAsyncCallback<CollectionDo> collectionAsyncCallback;
	
	private SimpleAsyncCallback<AssignmentsListDo> assignmentsListAsyncCallback;	
	
	SignUpPresenter signUpViewPresenter = null;
	
	/**
	 * 
	 * Manually reveals a presenter. Only use this method if your presenter is configured
     * to use manual reveal via {@link Presenter#useManualReveal()}. This method should be
     * called following one or more asynchronous server calls in
     * {@link Presenter#prepareFromRequest(PlaceRequest)}.
	 *
	 */
	@ProxyCodeSplit
	@NameToken(PlaceTokens.STUDENT)
	public interface IsStudentAssignmentProxy extends ProxyPlace<StudentAssignmentPresenter> {
	}
	
	//IndirectProvider<AssignmentPresenter> assignmentFactory;
	/**
	 * Class constructor and registering the handlers.
	 * @param view
	 * @param proxy
	 * @param signUpViewPresenter
	 */
	@Inject
	public StudentAssignmentPresenter(IsStudentAssignmentView view,IsStudentAssignmentProxy proxy,SignUpPresenter signUpViewPresenter) {
		super(view, proxy);
		this.signUpViewPresenter = signUpViewPresenter;
		//this.assignmentFactory= new StandardProvider<AssignmentPresenter>(assignmentFactory);
		getView().setUiHandlers(this);	
		
	}
	/**
	 * This LifeCycle method is called when the binding the object. And it will set the collection data.
	 */
	@Override
	public void onBind() {
		super.onBind();
		getView().clearAll();
		setcollectionAsyncCallback(new SimpleAsyncCallback<CollectionDo>() {
			@Override
			public void onSuccess(final CollectionDo result) {
				if(result!=null){
					getView().setData(result);
				}
//				else{
//					getView().getMainTitleLbl().setText(result.getTitle());
//					getView().noAssignments();
//				}
			}

			@Override
			public void onFailure(Throwable caught) {
				super.onFailure(caught);
			}
		});
		
		setAssignmentsListAsyncCallback(new SimpleAsyncCallback<AssignmentsListDo>() {

			@Override
			public void onSuccess(AssignmentsListDo result) {
				if(result.getSearchResults().size()!=0){
				getView().listAssignments(result);
				}else{
					//getView().getMainTitleLbl().setText(result.);
        			getView().noAssignments();
				}
			}
		});
		
		
	}	
	
	/**
	 * Lifecycle method called whenever this presenter is about to be
	 * revealed.
	 */
	@Override
	protected void onReveal() {
		super.onReveal();
		AppClientFactory.setBrowserWindowTitle(SeoTokens.TEACH_TITLE);
		AppClientFactory.setMetaDataDescription(SeoTokens.HOME_META_DESCRIPTION);
		AppClientFactory.fireEvent(new HomeEvent(HeaderTabType.STUDY));
//		if (!AppClientFactory.isAnonymous()){
//			getView().getBackToEditPanel().getElement().getStyle().setDisplay(Display.INLINE);
//			AppClientFactory.fireEvent(new HomeEvent(HeaderTabType.TEACH));
//		}
		if(AppClientFactory.getPlaceManager().getRequestParameter("b") != null){
			if (AppClientFactory.getPlaceManager().getRequestParameter("b").equalsIgnoreCase("true")){
				getView().getBackToEditPanel().getElement().getStyle().setDisplay(Display.INLINE);
				getView().getBackToEditPanel().setVisible(true);
				AppClientFactory.fireEvent(new HomeEvent(HeaderTabType.TEACH));
			}else{
				getView().getBackToEditPanel().getElement().getStyle().setDisplay(Display.NONE);
				getView().getBackToEditPanel().setVisible(false);
				AppClientFactory.fireEvent(new HomeEvent(HeaderTabType.STUDY));
			}
		}else{
			getView().getBackToEditPanel().getElement().getStyle().setDisplay(Display.NONE);
			getView().getBackToEditPanel().setVisible(false);
			AppClientFactory.fireEvent(new HomeEvent(HeaderTabType.STUDY));
		}
		//Call Event for Setting Confirm popup
		AppClientFactory.fireEvent(new ConfirmStatusPopupEvent(true));
		AppClientFactory.fireEvent(new SetFooterEvent(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken()));
	}
	/**
	 * This will allow the callback to reveal the presenter when the callback happens and it will call the initParam() method.
	 */
	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		if (AppClientFactory.getPlaceManager().refreshPlace()) {
			initParam();
		}
	}
	/**
	 * @function initParam 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This method is used to get the read the all the paremeters passed in the URL.
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private void initParam() {
		String classPageId= getPlaceManager().getRequestParameter("id");
		String pageSize = getPlaceManager().getRequestParameter("pageSize");
		String pageNum = getPlaceManager().getRequestParameter("pageNum");
		String source = getPlaceManager().getRequestParameter("source");
		String pos = getPlaceManager().getRequestParameter("pos");
		
		//getView().setClasspageId(classPageId);
		//getView().getClasspageById(classPageId, pageSize, pageNum);
		getView().clearAll();
		getView().metaData(classPageId, pageNum, pageSize, source,pos);
	}

	/**
	 * Lifecycle method called on all visible presenters whenever a
	 * presenter is revealed anywhere in the presenter hierarchy.
	 */
	@Override
	protected void onReset() {
		super.onReset();
		AppClientFactory.fireEvent(new SetFooterEvent(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken()));
		
		if (getPlaceManager().getRequestParameter("callback") != null && getPlaceManager().getRequestParameter("callback").equalsIgnoreCase("signup")) {
			//To show SignUp (Registration popup)
			Window.enableScrolling(false);
			AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
			String type = getPlaceManager().getRequestParameter("type") ;
			int displayScreen =getPlaceManager().getRequestParameter("type") !=null  ? Integer.parseInt(type) : 1;
			signUpViewPresenter.displayPopup(displayScreen);
			addToPopupSlot(signUpViewPresenter);
		}
		
	}
	/**
	 * This method is used to get the view token.
	 */
	@Override
	public String getViewToken() {
		return PlaceTokens.STUDENT;
	}
	/**
	 * @function setcollectionAsyncCallback 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This method is used to set the collection details.
	 * 
	 * 
	 * @parm(s) : @param collectionAsyncCallback
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setcollectionAsyncCallback(SimpleAsyncCallback<CollectionDo> collectionAsyncCallback) {
		this.collectionAsyncCallback = collectionAsyncCallback;
	}
	
	/** 
	 * This method is to get the assignmentListAsyncCallback
	 */
	public SimpleAsyncCallback<CollectionDo> getcollectionAsyncCallback() {
		return collectionAsyncCallback;
	}
	/** 
	 * This method is to get the ClasspageServiceAsync
	 */
	public ClasspageServiceAsync getclasspageServiceAsync() {
		return classpageServiceAsync;
	}
	/**
	 * This method is used to get the class page by id.
	 */
	public void asyMethodCall(){
		this.getclasspageServiceAsync().v2GetClasspageById(AppClientFactory.getPlaceManager().getRequestParameter("id"), getcollectionAsyncCallback());
		
	}
	/**
	 * This method is used to get the assignments by class page Id.
	 */
	public void getAssignmentsList(String pageNum,String pageSize){
		this.getclasspageServiceAsync().v2GetAssignemtsByClasspageId(AppClientFactory.getPlaceManager().getRequestParameter("id"), pageSize, pageNum, getAssignmentsListAsyncCallback());
	}
	/** 
	 * This method is to get the assignmentsListAsyncCallback
	 */
	public SimpleAsyncCallback<AssignmentsListDo> getAssignmentsListAsyncCallback() {
		return assignmentsListAsyncCallback;
	}
	/** 
	 * This method is to set the assignmentsListAsyncCallback
	 */
	public void setAssignmentsListAsyncCallback(
			SimpleAsyncCallback<AssignmentsListDo> assignmentsListAsyncCallback) {
		this.assignmentsListAsyncCallback = assignmentsListAsyncCallback;
	}
}
