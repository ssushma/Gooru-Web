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
/**
 * 
*/
package org.ednovo.gooru.client.mvp.classpages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SeoTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BasePlacePresenter;
import org.ednovo.gooru.client.mvp.classpages.ClasspagePresenter.IsClasspageProxy;
import org.ednovo.gooru.client.mvp.classpages.event.RefreshClasspageListEvent;
import org.ednovo.gooru.client.mvp.classpages.event.RefreshClasspageResourceItemListEvent;
import org.ednovo.gooru.client.mvp.home.event.HeaderTabType;
import org.ednovo.gooru.client.mvp.home.event.HomeEvent;
import org.ednovo.gooru.client.mvp.search.event.SetFooterEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshType;
import org.ednovo.gooru.client.service.ClasspageServiceAsync;
import org.ednovo.gooru.shared.model.content.AssignmentDo;
import org.ednovo.gooru.shared.model.content.AttachToDo;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.TaskDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.event.dom.client.ScrollHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
/**
 * 
 * @fileName : ClasspagePresenter.java
 *
 * @description :  This is the presenter of the Classpage.
 *
 * @version : 1.0
 *
 * @date: 26-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class ClasspagePresenter extends BasePlacePresenter<IsClasspageView, IsClasspageProxy> implements ClasspageUiHandlers {

	
	@Inject
	private ClasspageServiceAsync classpageService;
	
	private SimpleAsyncCallback<CollectionDo> collectionAsyncCallback;
	
	private SimpleAsyncCallback<ClasspageListDo> getAllClasspagesAsyncCallback;
	
	private LinkedHashMap<String, CollectionDo> classpageHash = new LinkedHashMap<String, CollectionDo>();
	
	private boolean toClear = true;
	
	private String limit="10";//pagesize
    int resultSize;
	private int offSet=0;
	/**
	 * 
	 * Manually reveals a presenter. Only use this method if your presenter is configured
     * to use manual reveal via {@link Presenter#useManualReveal()}. This method should be
     * called following one or more asynchronous server calls in
     * {@link Presenter#prepareFromRequest(PlaceRequest)}.
	 *
	 */
	@ProxyCodeSplit
	@NameToken(PlaceTokens.TEACH)
	public interface IsClasspageProxy extends ProxyPlace<ClasspagePresenter> {
	}
	/**
	 * This is used to register the handlers.
	 * @param eventBus
	 * @param view
	 * @param proxy
	 */
	@Inject
	public ClasspagePresenter(EventBus eventBus, IsClasspageView view, IsClasspageProxy proxy) {
		
		super(view, proxy);
		getView().setUiHandlers(this);
		addRegisteredHandler(RefreshClasspageResourceItemListEvent.TYPE, this);
	/**
	 * To get more classpages after scroll down if class page is more than 10
	 */
		getView().getClassPageScrollPanel().addScrollHandler(new ScrollHandler() {
			
			@Override
			public void onScroll(ScrollEvent event) {
				if (getView().getClassPageScrollPanel().getVerticalScrollPosition() == getView().getClassPageScrollPanel().getMaximumVerticalScrollPosition() &&resultSize>=10){
					offSet=offSet+10;
					toClear=false;
					getAllClasspages(limit, String.valueOf(offSet));	
				}
			}
		});
		
	}
	
	@Override
	public String getViewToken() {
		throw new RuntimeException("Not implemented");
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
		if (AppClientFactory.isAnonymous()){
			AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.HOME);
			
		}
		getView().clearClasspageListPanel();  
		getView().showPlaceHolderForEmptyTeach(false);
		
		//Populating all classpages
		offSet = 0;
		getAllClasspages(limit, String.valueOf(offSet));
		AppClientFactory.fireEvent(new HomeEvent(HeaderTabType.TEACH));
		
		AppClientFactory.fireEvent(new SetFooterEvent(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken()));
		
	}

	/**
	 * Lifecycle method called on all visible presenters whenever a
	 * presenter is revealed anywhere in the presenter hierarchy.
	 */
	@Override
	protected void onReset() {
		AppClientFactory.fireEvent(new SetFooterEvent(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken()));
	}
	 /**
	   * Lifecycle method called when binding the object.
	   * Any event handler should be
	   * initialised here rather than in the constructor. Also, it is good practice to
	   * perform any costly initialisation here.
	   * <p />
	   * Handlers registered by calling
	   * {@link #registerHandler(HandlerRegistration)} will be removed
	   * when unbinding. Any other initialisation that takes place here (or as a
	   * side-effect of what is done here) should be taken down in {@link #onUnbind()}.
	   * <p />
	   * This method will never be invoked more then once, or if it is, the second
	   * time will necessarily be preceded by an invocation of {@link #onUnbind()}.
	   */
	@Override
	public void onBind() {
		super.onBind();
		
		setCollectionAsyncCallback(new SimpleAsyncCallback<CollectionDo>() {

			@Override
			public void onSuccess(CollectionDo collectionDo) {
				
				final String classpageId = collectionDo.getGooruOid();
				AssignmentDo assignmentDo = new AssignmentDo();
				assignmentDo.setClasspageId(classpageId);
				
				TaskDo taskDo = new TaskDo();
				taskDo.setTitle(MessageProperties.GL0121);
				taskDo.setTypeName("assignment");
				assignmentDo.setTask(taskDo);
				
				AttachToDo attachToDo = new AttachToDo();
				attachToDo.setId(classpageId);
				attachToDo.setType("classpage");
				
				assignmentDo.setAttachTo(attachToDo);				
				
				AppClientFactory.getInjector().getClasspageService().v2CreateAssignment(assignmentDo, new SimpleAsyncCallback<AssignmentDo>() {

					@Override
					public void onSuccess(AssignmentDo result) {
						getView().getNewPopup().hide();
						getView().OpenClasspageEdit(classpageId);
						AppClientFactory.fireEvent(new RefreshClasspageListEvent());
					}
				});
			}
		});
	
		setGetAllClasspagesAsyncCallback(new SimpleAsyncCallback<ClasspageListDo>() {

			@Override
			public void onSuccess(ClasspageListDo result) {
				int resultSize = result.getSearchResults().size();
				if (resultSize>0){
					OpenClasspageEdit(result.getSearchResults().get(0).getGooruOid());					
				}
			}
		});
	}
	/**
	 * 
	 * @function OpenClasspageEdit
	 * 
	 * @created_date : Aug 15, 2013
	 * 
	 * @description : This method is used to open a class page in the Edit mode.
	 * 
	 * @parm(s) : @param gooruOId
	 * 
	 * @return : void
	 * 
	 * @throws : <Mentioned if any exceptions>
	 * 
	 */
	private void OpenClasspageEdit(String gooruOId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("classpageid", gooruOId);
		params.put("pageNum", "0");
		params.put("pageSize", "10");
		params.put("pos", "1");
		AppClientFactory.getPlaceManager().revealPlace(
				PlaceTokens.EDIT_CLASSPAGE, params);
	}
	/**
	 * This method is used to refresh the all class page items.
	 */
	@Override
	public void refreshClasspageResourceItemList(
			CollectionDo classpageResourceItem, RefreshType refreshType) {
					
			classpageHash.remove(classpageResourceItem.getGooruOid());
			if(classpageHash.size()==0)
			{
				offSet=0;
				getAllClasspages(limit, String.valueOf(offSet));		
			}
			toClear = true;
			refreshClasspage();
		
	}
	/**
	 * @function refreshClasspage 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description : This method is used to refresh the class pages.
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 */
	void refreshClasspage(){
	  List<CollectionDo> tmpClasspageList = new ArrayList<CollectionDo>();
		
	  if (toClear){
		  getView().clearClasspageListPanel();  
	  }
	  	
		getView().getLoadingPanel().setVisible(false);
	
		resultSize = classpageHash.size();
	
		Collection classpageCollection = classpageHash.values();
		
		   
	    //obtain an Iterator for Collection
	    Iterator itr = classpageCollection.iterator();
	   
	    //iterate through LinkedHashMap values iterator
	  
	     
	    while(itr.hasNext()){
	    	tmpClasspageList.add((CollectionDo) itr.next());	    	
	    }
	    
		for (int i = resultSize-1; i >= 0 ; i--) {
			getView().insertClasspage(tmpClasspageList.get(i), false);
			
			
		}
		if(getView().getClasspageListPanel().getWidgetCount()>0) {
//			getView().showPlaceHolderForEmptyTeach(false);
//			getView().getClassPageScrollPanel().setVisible(true);
		} else {
			getView().showPlaceHolderForEmptyTeach(true);
			getView().getClassPageScrollPanel().setVisible(false);
		}
		
	}
	
	/**
	 * This method is used to create a new class page.
	 */
	@Override
	public void createClasspage(CollectionDo collectionDo) {

//		getClasspageService().createClasspage(collectionDo, getCollectionAsyncCallback());
		getClasspageService().v2CreateClasspage(collectionDo, getCollectionAsyncCallback());
		 getView().getClassPageScrollPanel().scrollToTop();
		
	}
	/**
	 * This method is used to get all the list of class pages.
	 */
	@Override
	public void getAllClasspages(String limit, String offSet) {

		
		getClasspageService().v2GetAllClasspages(limit, offSet, getGetAllClasspagesAsyncCallback());
	}
	
	//// Setters and Getters //
	/** 
	 * This method is to get the classpageService
	 */
	public ClasspageServiceAsync getClasspageService() {
		return classpageService;
	}

	/** 
	 * This method is to set the classpageService
	 */
	public void setClasspageService(ClasspageServiceAsync classpageService) {
		this.classpageService = classpageService;
	}
	
	/** 
	 * This method is to get the collectionAsyncCallback
	 */
	public SimpleAsyncCallback<CollectionDo> getCollectionAsyncCallback() {
		return collectionAsyncCallback;
	}

	/** 
	 * This method is to set the collectionAsyncCallback
	 */
	public void setCollectionAsyncCallback(
			SimpleAsyncCallback<CollectionDo> collectionAsyncCallback) {
		this.collectionAsyncCallback = collectionAsyncCallback;
	}
	
	/**
	 * @return the getAllClasspagesAsyncCallback
	 */
	public SimpleAsyncCallback<ClasspageListDo> getGetAllClasspagesAsyncCallback() {
		return getAllClasspagesAsyncCallback;
	}

	/**
	 * @param getAllClasspagesAsyncCallback the getAllClasspagesAsyncCallback to set
	 */
	public void setGetAllClasspagesAsyncCallback(
			SimpleAsyncCallback<ClasspageListDo> getAllClasspagesAsyncCallback) {
		this.getAllClasspagesAsyncCallback = getAllClasspagesAsyncCallback;
	}
	

	
}
