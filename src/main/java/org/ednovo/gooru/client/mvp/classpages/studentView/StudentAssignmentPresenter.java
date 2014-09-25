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

import java.util.ArrayList;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SeoTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BasePlacePresenter;
import org.ednovo.gooru.client.mvp.authentication.SignUpPresenter;
import org.ednovo.gooru.client.mvp.classpages.event.DeleteClasspageListEvent;
import org.ednovo.gooru.client.mvp.classpages.studentView.StudentAssignmentPresenter.IsStudentAssignmentProxy;
import org.ednovo.gooru.client.mvp.classpages.unitSetup.UnitSetupPresenter;
import org.ednovo.gooru.client.mvp.classpages.unitSetup.UnitSetupStudentPresenter;
import org.ednovo.gooru.client.mvp.classpages.unitdetails.UnitAssignmentPresenter;
import org.ednovo.gooru.client.mvp.home.event.HeaderTabType;
import org.ednovo.gooru.client.mvp.home.event.HomeEvent;
import org.ednovo.gooru.client.mvp.play.collection.GwtUUIDGenerator;
import org.ednovo.gooru.client.mvp.search.event.ConfirmStatusPopupEvent;
import org.ednovo.gooru.client.mvp.search.event.SetFooterEvent;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.ErrorPopup;
import org.ednovo.gooru.client.service.ClasspageServiceAsync;
import org.ednovo.gooru.client.util.PlayerDataLogEvents;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.AssignmentsListDo;
import org.ednovo.gooru.shared.model.content.ClasspageDo;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;


public class StudentAssignmentPresenter extends BasePlacePresenter<IsStudentAssignmentView, IsStudentAssignmentProxy> implements StudentAssignmentUiHandlers {

	
	@Inject
	private ClasspageServiceAsync classpageServiceAsync;
	
	private SimpleAsyncCallback<CollectionDo> collectionAsyncCallback;
	
	private SimpleAsyncCallback<AssignmentsListDo> assignmentsListAsyncCallback;
	
	private UnitSetupStudentPresenter unitSetupStudentPresenter;
	
	private UnitAssignmentPresenter unitAssignmentPresenter;
	
	SignUpPresenter signUpViewPresenter = null;
	private Integer offset=0;
	private Integer limit=5;
	private Integer defaultOffsetForPath=0;
	private Integer defaultLimitForPath=20;
	private static final Integer DEFAULT_LIMITVALUE=5;
	
	public static final  Object STUDY_SLOT = new Object();
	
	private ClasspageDo classpageDo=null;
	
	@ProxyCodeSplit
	@NameToken(PlaceTokens.STUDENT)
	public interface IsStudentAssignmentProxy extends ProxyPlace<StudentAssignmentPresenter> {
	}
	
	MessageProperties i18n = GWT.create(MessageProperties.class);
	
	//IndirectProvider<AssignmentPresenter> assignmentFactory;
	
	@Inject
	public StudentAssignmentPresenter(IsStudentAssignmentView view,IsStudentAssignmentProxy proxy,SignUpPresenter signUpViewPresenter,UnitSetupStudentPresenter unitSetupStudentPresenter,UnitAssignmentPresenter unitAssignmentPresenter) {
		super(view, proxy);
		this.signUpViewPresenter = signUpViewPresenter;
		this.unitSetupStudentPresenter = unitSetupStudentPresenter;
		this.unitAssignmentPresenter =unitAssignmentPresenter;
		getView().setUiHandlers(this);	
		
	}
	
	@Override
	public void onBind() {
		super.onBind();
	}
	
	@Override
	protected void onHide() {
		super.onHide();
		classpageDo=null;
		getView().hidePanel();
	}
	
	
	@Override
	protected void onReveal() {
		super.onReveal();
		AppClientFactory.setBrowserWindowTitle(SeoTokens.STUDY_TITLE);
		AppClientFactory.setMetaDataDescription(SeoTokens.HOME_META_DESCRIPTION);
		AppClientFactory.fireEvent(new HomeEvent(HeaderTabType.TEACH));
//		if (!AppClientFactory.isAnonymous()){
//			getView().getBackToEditPanel().getElement().getStyle().setDisplay(Display.INLINE);
//			AppClientFactory.fireEvent(new HomeEvent(HeaderTabType.TEACH));
//		}
		
		if(AppClientFactory.getPlaceManager().getRequestParameter("b") != null){
			if (AppClientFactory.getPlaceManager().getRequestParameter("b").equalsIgnoreCase("true")){
				getView().getBackToEditPanel().getElement().getStyle().setDisplay(Display.INLINE);
				getView().getBackToEditPanel().setVisible(true);
				AppClientFactory.setBrowserWindowTitle(SeoTokens.TEACH_TITLE);
				AppClientFactory.fireEvent(new HomeEvent(HeaderTabType.TEACH));
			}else{
				getView().getBackToEditPanel().getElement().getStyle().setDisplay(Display.NONE);
				getView().getBackToEditPanel().setVisible(false);
				AppClientFactory.setBrowserWindowTitle(SeoTokens.TEACH_TITLE);
				AppClientFactory.fireEvent(new HomeEvent(HeaderTabType.TEACH));
			}
		}else{
			getView().getBackToEditPanel().getElement().getStyle().setDisplay(Display.NONE);
			getView().getBackToEditPanel().setVisible(false);
			AppClientFactory.setBrowserWindowTitle(SeoTokens.TEACH_TITLE);
			AppClientFactory.fireEvent(new HomeEvent(HeaderTabType.TEACH));
		}
  
		//Call Event for Setting Confirm popup
		AppClientFactory.fireEvent(new ConfirmStatusPopupEvent(true));
		AppClientFactory.fireEvent(new SetFooterEvent(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken()));
	}
	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		if (AppClientFactory.getPlaceManager().refreshPlace()) {
		}
		initParam();
		//getClasspage();
	}
	private void initParam() {
		getView().clearAll();
		getClasspage();
	}
	public void getClasspage(){
		String classpageId=getPlaceManager().getRequestParameter("id");
		final String sortingOrder=getPlaceManager().getRequestParameter("order",null);
		final String tabMode=getPlaceManager().getRequestParameter("tab",null);
		System.out.println("classpageId:::"+classpageId);
		if(classpageId != null)
		{
		if(classpageDo==null||(!classpageDo.getClasspageId().equals(classpageId))){
			getView().resetAll();
			this.classpageServiceAsync.getClasspage(classpageId, new SimpleAsyncCallback<ClasspageDo>() {
				@Override
				public void onSuccess(ClasspageDo classpageDo) {
					if(classpageDo!=null && classpageDo.getClasspageId() != null){
						StudentAssignmentPresenter.this.classpageDo=classpageDo;
//							offset=0;
//							limit=5;
//							getClasspageItems(classpageDo.getClasspageId(),offset.toString(),limit.toString(),false,sortingOrder);	//To display Assignments
//							//getView().setSortingOrderInDropdown(sortingOrder);
//							getClasspageItems(classpageDo.getClasspageId(),""+defaultOffsetForPath,""+defaultLimitForPath,true, "all");	//To do display Assignment progress.
							getView().setClasspageData(classpageDo);
							showTabWidget(tabMode);
							triggerClassPageNewDataLogStartStopEvent(classpageDo.getClasspageId(), classpageDo.getClasspageCode());
							
					}else{
						ErrorPopup error = new ErrorPopup(i18n.GL1632());
						error.center();
						error.show();
					}
				}
			});
		}else{
			showTabWidget(tabMode);
		}
	  }
	}
	
	public void showTabWidget(String tab){
		if(tab!=null)
		{
		 if(tab.equalsIgnoreCase("classList")){
			 
			 String pageNum=AppClientFactory.getPlaceManager().getRequestParameter("pageNum", null);
				int offsetVal = 0;
				if(pageNum != null)
				{
					offsetVal = Integer.parseInt(pageNum);
					if(offsetVal!=0)
					{
					offsetVal = (offsetVal-1);
					}
				}
			unitSetupStudentPresenter.getPathwayCompleteDetails(limit, (offsetVal)*limit);
	    	 setInSlot(STUDY_SLOT, unitSetupStudentPresenter,false);
	     }else if(tab.equalsIgnoreCase("reports")){
	     	
	     }else if(tab!=null&&tab.equalsIgnoreCase("unitsetup")){
	    	 String pageNum=AppClientFactory.getPlaceManager().getRequestParameter("pageNum", null);
				int offsetVal = 0;
				if(pageNum != null)
				{
					offsetVal = Integer.parseInt(pageNum);
					if(offsetVal!=0)
					{
					offsetVal = (offsetVal-1);
					}
				}
			unitSetupStudentPresenter.getPathwayCompleteDetails(limit, (offsetVal)*limit);
	    	 setInSlot(STUDY_SLOT, unitSetupStudentPresenter,false);
	     }
	     else if(tab.equalsIgnoreCase("unitdetails")){
	    	 unitAssignmentPresenter.showDashBoardDetails();
	    	 unitAssignmentPresenter.getClassUnits(classpageDo.getClasspageId());
	    	 setInSlot(STUDY_SLOT, unitAssignmentPresenter,false);
	     }
	     else {
	     	 String pageNum=AppClientFactory.getPlaceManager().getRequestParameter("pageNum", null);
				int offsetVal = 0;
				if(pageNum != null)
				{
					offsetVal = Integer.parseInt(pageNum);
					if(offsetVal!=0)
					{
					offsetVal = (offsetVal-1);
					}
				}
			unitSetupStudentPresenter.getPathwayCompleteDetails(limit, (offsetVal)*limit);
	    	 setInSlot(STUDY_SLOT, unitSetupStudentPresenter,false);
	     }
		}
	     else {
	     	 String pageNum=AppClientFactory.getPlaceManager().getRequestParameter("pageNum", null);
				int offsetVal = 0;
				if(pageNum != null)
				{
					offsetVal = Integer.parseInt(pageNum);
					if(offsetVal!=0)
					{
					offsetVal = (offsetVal-1);
					}
				}
			unitSetupStudentPresenter.getPathwayCompleteDetails(limit, (offsetVal)*limit);
	    	 setInSlot(STUDY_SLOT, unitSetupStudentPresenter,false);
	     }
		
	}
	public void getClasspageItems(String classpageId,String offset,final String limit,final boolean isForAssignmentPath, final String sortOrder){
		this.classpageServiceAsync.getClassPageItems(classpageId, offset, limit,sortOrder,null, new SimpleAsyncCallback<ArrayList<ClasspageItemDo>>() {
			@Override
			public void onSuccess(ArrayList<ClasspageItemDo> classpageItemsList) {
				if(classpageItemsList!=null){
					if(isForAssignmentPath){
						getView().showClasspageItemsForAssignmentPath(classpageItemsList);
					}else{
						getView().showClasspageItems(classpageItemsList,sortOrder);
					}
				}
			}
		});
	}
	
	public Integer getOffsetValue(){
		String pageNum=getPlaceManager().getRequestParameter("pageNum","1");
		int pageNumber=0;
		try{
			pageNumber=Integer.parseInt(pageNum);
			if(pageNumber==0){
				pageNumber=1;
			}
		}catch(Exception e){}
		
		return (((pageNumber-1)*DEFAULT_LIMITVALUE));
	}
	@Override
	public void getNextClasspageItems(Integer offset,Integer limit) {
		String classpageId=getPlaceManager().getRequestParameter("id");
		 String sortingOrder=getPlaceManager().getRequestParameter("order",null);
		getClasspageItems(classpageId,offset.toString(),limit.toString(),false,sortingOrder);
		
	}


	@Override
	protected void onReset() {
		super.onReset();
		if(AppClientFactory.getPlaceManager().getRequestParameter("b") != null){
			if (AppClientFactory.getPlaceManager().getRequestParameter("b").equalsIgnoreCase("true")){
				getView().getBackToEditPanel().getElement().getStyle().setDisplay(Display.INLINE);
				getView().getBackToEditPanel().setVisible(true);
				AppClientFactory.setBrowserWindowTitle(SeoTokens.TEACH_TITLE);
				AppClientFactory.fireEvent(new HomeEvent(HeaderTabType.TEACH));
			}else{
				getView().getBackToEditPanel().getElement().getStyle().setDisplay(Display.NONE);
				getView().getBackToEditPanel().setVisible(false);
				AppClientFactory.setBrowserWindowTitle(SeoTokens.TEACH_TITLE);
				AppClientFactory.fireEvent(new HomeEvent(HeaderTabType.TEACH));
			}
		}else{
			getView().getBackToEditPanel().getElement().getStyle().setDisplay(Display.NONE);
			getView().getBackToEditPanel().setVisible(false);
			AppClientFactory.setBrowserWindowTitle(SeoTokens.TEACH_TITLE);
			AppClientFactory.fireEvent(new HomeEvent(HeaderTabType.TEACH));
		}
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
		
	}

	@Override
	public String getViewToken() {
		return PlaceTokens.STUDENT;
	}
	
	public void setcollectionAsyncCallback(SimpleAsyncCallback<CollectionDo> collectionAsyncCallback) {
		this.collectionAsyncCallback = collectionAsyncCallback;
	}
	
	/** 
	 * This method is to get the assignmentListAsyncCallback
	 */
	public SimpleAsyncCallback<CollectionDo> getcollectionAsyncCallback() {
		return collectionAsyncCallback;
	}
	
	public ClasspageServiceAsync getclasspageServiceAsync() {
		return classpageServiceAsync;
	}
	
	public void asyMethodCall(){
		this.getclasspageServiceAsync().v2GetClasspageById(AppClientFactory.getPlaceManager().getRequestParameter("id"), getcollectionAsyncCallback());
		
	}
	public void getAssignmentsList(String pageNum,String pageSize){
		this.getclasspageServiceAsync().v2GetAssignemtsByClasspageId(AppClientFactory.getPlaceManager().getRequestParameter("id"), pageSize, pageNum, getAssignmentsListAsyncCallback());
	}

	public SimpleAsyncCallback<AssignmentsListDo> getAssignmentsListAsyncCallback() {
		return assignmentsListAsyncCallback;
	}

	public void setAssignmentsListAsyncCallback(
			SimpleAsyncCallback<AssignmentsListDo> assignmentsListAsyncCallback) {
		this.assignmentsListAsyncCallback = assignmentsListAsyncCallback;
	}

	public void triggerClassPageNewDataLogStartStopEvent(String classpageId, String classCode){
		JSONObject classpageDataLog=new JSONObject();
		String classpageEventId=GwtUUIDGenerator.uuid();
		AppClientFactory.getPlaceManager().setClasspageEventId(classpageEventId);
		classpageDataLog.put(PlayerDataLogEvents.EVENTID, new JSONString(classpageEventId));
		classpageDataLog.put(PlayerDataLogEvents.EVENTNAME, new JSONString(PlayerDataLogEvents.CLASSPAGE_VIEW));
		classpageDataLog.put(PlayerDataLogEvents.SESSION, PlayerDataLogEvents.getDataLogSessionObject(null));
		classpageDataLog.put(PlayerDataLogEvents.USER, PlayerDataLogEvents.getDataLogUserObject());
		classpageDataLog.put(PlayerDataLogEvents.STARTTIME, new JSONNumber(System.currentTimeMillis()));
		classpageDataLog.put(PlayerDataLogEvents.ENDTIME, new JSONNumber(System.currentTimeMillis()));
		classpageDataLog.put(PlayerDataLogEvents.CONTEXT, PlayerDataLogEvents.getDataLogContextObject(classpageId, "", "", "", "","",null,classpageId,"study"));
		classpageDataLog.put(PlayerDataLogEvents.VERSION,PlayerDataLogEvents.getDataLogVersionObject());
		classpageDataLog.put(PlayerDataLogEvents.METRICS,PlayerDataLogEvents.getDataLogMetricsObject(0L, 0));
		classpageDataLog.put(PlayerDataLogEvents.PAYLOADOBJECT,PlayerDataLogEvents.getClassPagePayLoadObject(classCode));
		PlayerDataLogEvents.collectionStartStopEvent(classpageDataLog);
	}
	@Override
	public void removeUserFromClass(final ClasspageDo classpageDo, String emailId){
		AppClientFactory.getInjector().getClasspageService().removeStudentFromClass(classpageDo.getClasspageCode(), classpageDo.getSharing(), emailId, new SimpleAsyncCallback<Void>() {

			@Override
			public void onSuccess(Void result) {
				AppClientFactory.fireEvent(new DeleteClasspageListEvent(classpageDo.getClasspageId()));
				AppClientFactory.getInjector().getClasspageService().v2GetAllClass("2", "0",new SimpleAsyncCallback<ClasspageListDo>() {
					@Override
					public void onSuccess(ClasspageListDo result) {
				//	hasClasses = result.getSearchResults().size() > 0 ? true : false; 
						if(result.getSearchResults()!=null){
						if (result.getSearchResults().size()>0){
							AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.CLASSHOME);
							////classpageId = result.getSearchResults().get(0).getGooruOid();
							//String userId = result.getSearchResults().get(0).getUser().getGooruUId();
						//OpenClasspageEdit(classpageId, userId);
							//AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.CLASSHOME,null,true);
						}else{
							AppClientFactory.getPlaceManager().redirectPlace(PlaceTokens.STUDY);
							//AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.STUDY);
						}
					}else
					{
						AppClientFactory.getPlaceManager().redirectPlace(PlaceTokens.STUDY);
					}
					}
			});
				AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
				Window.enableScrolling(true);
				
			}
		});
		
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.classpages.studentView.StudentAssignmentUiHandlers#getAssignmentsProgress(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void getAssignmentsProgress(String classpageId, String offSet,
			String limit) {
		AppClientFactory.getInjector().getClasspageService().getClassPageItems(classpageId, offSet.toString(), limit.toString(),null,null, new SimpleAsyncCallback<ArrayList<ClasspageItemDo>>() {
			
			@Override
			public void onSuccess(ArrayList<ClasspageItemDo> classpageItemsList) {
				if(classpageItemsList!=null){
					getView().showClasspageItemsForAssignmentPath(classpageItemsList);
				}
			}
		});
	}

}
