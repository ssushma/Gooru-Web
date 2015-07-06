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
package org.ednovo.gooru.client.mvp.classpages.studentclassview;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BasePlacePresenter;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.client.SeoTokens;
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.ednovo.gooru.client.mvp.authentication.SignUpPresenter;
import org.ednovo.gooru.client.mvp.classpages.studentclassview.StudentClassPresenter.IsStudentClassProxy;
import org.ednovo.gooru.client.mvp.classpages.studentclassview.learningmap.StudentClassLearningMapPresenter;
import org.ednovo.gooru.client.mvp.classpages.studentclassview.reports.StudentClassReportPresenter;
import org.ednovo.gooru.client.mvp.home.AlmostDoneUc;
import org.ednovo.gooru.client.mvp.home.event.HeaderTabType;
import org.ednovo.gooru.client.mvp.home.event.HomeEvent;
import org.ednovo.gooru.client.mvp.search.event.ConfirmStatusPopupEvent;
import org.ednovo.gooru.client.mvp.search.event.SetFooterEvent;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.util.PlayerDataLogEvents;
import org.ednovo.gooru.shared.util.GwtUUIDGenerator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

/**
 * 
 * @fileName : StudentClassPresenter.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 19-Jun-2015
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
public class StudentClassPresenter extends BasePlacePresenter<IsStudentClassView, IsStudentClassProxy> implements StudentClassUiHandlers {
	
	SignUpPresenter signUpViewPresenter = null;
	
	StudentClassLearningMapPresenter studentClassLearningMapPresenter = null;
	
	StudentClassReportPresenter studentClassReportPresenter = null;
	
	@ProxyCodeSplit
	@NameToken(PlaceTokens.STUDENT_VIEW)
	public interface IsStudentClassProxy extends ProxyPlace<StudentClassPresenter> {
	}
	
	MessageProperties i18n = GWT.create(MessageProperties.class);
		
	@Inject
	public StudentClassPresenter(IsStudentClassView view,IsStudentClassProxy proxy,SignUpPresenter signUpViewPresenter, StudentClassLearningMapPresenter studentClassLearningMapPresenter, StudentClassReportPresenter studentClassReportPresenter) {
		super(view, proxy);
		this.signUpViewPresenter = signUpViewPresenter;
		this.studentClassLearningMapPresenter = studentClassLearningMapPresenter;
		this.studentClassReportPresenter = studentClassReportPresenter;
		getView().setUiHandlers(this);
	}
	
	@Override
	public void onBind() {
		super.onBind();
		Window.enableScrolling(true);
		Window.scrollTo(0, 0);
	}	
	
	
	@Override
	protected void onReveal() {
		super.onReveal();
		Window.enableScrolling(true);
		Window.scrollTo(0, 0);
		AppClientFactory.setBrowserWindowTitle(SeoTokens.STUDY_TITLE);
		AppClientFactory.setMetaDataDescription(SeoTokens.HOME_META_DESCRIPTION);
		AppClientFactory.fireEvent(new HomeEvent(HeaderTabType.TEACH));
		
		//Call Event for Setting Confirm popup
		AppClientFactory.fireEvent(new ConfirmStatusPopupEvent(true));
		AppClientFactory.fireEvent(new SetFooterEvent(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken()));
	}
	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		if (AppClientFactory.getPlaceManager().refreshPlace()) {
			initParam();
		}
	}
	private void initParam() {
		getView().clearAll();
	}
	
	@Override
	protected void onReset() {
		super.onReset();
		Window.enableScrolling(true);
		Window.scrollTo(0, 0);
		loadNavigationPage();
		
		//Call Event for Setting Confirm popup
		AppClientFactory.fireEvent(new ConfirmStatusPopupEvent(true));
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
		int flag = AppClientFactory.getLoggedInUser().getViewFlag();
		final String loginType = AppClientFactory.getLoggedInUser().getLoginType() !=null ? AppClientFactory.getLoggedInUser().getLoginType() : "";
		if(!AppClientFactory.isAnonymous() && flag==0 &&  !loginType.equalsIgnoreCase("Credential")) {
			AlmostDoneUc update = new AlmostDoneUc(AppClientFactory.getLoggedInUser().getEmailId(), AppClientFactory.getLoggedInUser());
			update.setGlassEnabled(true);
			update.show();
			update.center();
		}
		
	}
	
	private void loadNavigationPage() {
		String loadPage = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.STUDENT_CLASSPAGE_TAB, UrlNavigationTokens.STUDENT_CLASSPAGE_LEARNING_MAP_ITEM);
		clearSlot(LEARNING_MAP_TAB);
		clearSlot(CLASSPAGE_REPORT_TAB);
		if(loadPage.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_LEARNING_MAP_ITEM)) {
			addToSlot(LEARNING_MAP_TAB, studentClassLearningMapPresenter);
		} else if(loadPage.equalsIgnoreCase(UrlNavigationTokens.STUDENT_CLASSPAGE_REPORT_ITEM)) {
			addToSlot(CLASSPAGE_REPORT_TAB, studentClassReportPresenter);
		}
	}
	
	@Override
	protected void onHide() {
		AppClientFactory.getPlaceManager().setClasspageEventId(null);
	}

	@Override
	public String getViewToken() {
		return PlaceTokens.STUDENT_VIEW;
	}
	
	/**
	 * 
	 * @function triggerClassPageNewDataLogStartStopEvent 
	 * 
	 * @created_date : 07-Dec-2014
	 * 
	 * @description
	 * 
	 * 
	 * @parm(s) : @param classpageId
	 * @parm(s) : @param classCode
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void triggerClassPageNewDataLogStartStopEvent(String classpageId, String classCode){
		JSONObject classpageDataLog=new JSONObject();
		String classpageEventId=GwtUUIDGenerator.uuid();
		AppClientFactory.getPlaceManager().setClasspageEventId(classpageEventId);
		classpageDataLog.put(PlayerDataLogEvents.EVENTID, new JSONString(classpageEventId));
		classpageDataLog.put(PlayerDataLogEvents.EVENTNAME, new JSONString(PlayerDataLogEvents.CLASSPAGE_VIEW));
		classpageDataLog.put(PlayerDataLogEvents.SESSION, PlayerDataLogEvents.getDataLogSessionObject(null));
		classpageDataLog.put(PlayerDataLogEvents.USER, PlayerDataLogEvents.getDataLogUserObject());
		classpageDataLog.put(PlayerDataLogEvents.STARTTIME, new JSONNumber(PlayerDataLogEvents.getUnixTime()));
		classpageDataLog.put(PlayerDataLogEvents.ENDTIME, new JSONNumber(PlayerDataLogEvents.getUnixTime()));
		classpageDataLog.put(PlayerDataLogEvents.CONTEXT, PlayerDataLogEvents.getDataLogContextObject(classpageId, "", "", "", "","",null,classpageId,"study"));
		classpageDataLog.put(PlayerDataLogEvents.VERSION,PlayerDataLogEvents.getDataLogVersionObject());
		classpageDataLog.put(PlayerDataLogEvents.METRICS,PlayerDataLogEvents.getDataLogMetricsObject(0L, 0));
		classpageDataLog.put(PlayerDataLogEvents.PAYLOADOBJECT,PlayerDataLogEvents.getClassPagePayLoadObject(classCode));
		PlayerDataLogEvents.collectionStartStopEvent(classpageDataLog);
	}
}
