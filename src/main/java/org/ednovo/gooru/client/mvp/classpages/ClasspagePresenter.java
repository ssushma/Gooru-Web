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
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.AssignmentDo;
import org.ednovo.gooru.shared.model.content.AttachToDo;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.TaskDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.event.dom.client.ScrollHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;


/**
 * @fileName : ClasspagesPresenter.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: Apr 17, 2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: 
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
	
	private MessageProperties i18n = GWT.create(MessageProperties.class); 
	
	@ProxyCodeSplit
	@NameToken(PlaceTokens.TEACH)
	public interface IsClasspageProxy extends ProxyPlace<ClasspagePresenter> {
	}

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
	
	@Override
	protected void onReset() {
		AppClientFactory.fireEvent(new SetFooterEvent(AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken()));
	}
	
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
				taskDo.setTitle(i18n.GL0121());
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
	 * @description
	 * 
	 * 
	 * @parm(s) : @param gooruOId
	 * 
	 * @return : void
	 * 
	 * @throws : <Mentioned if any exceptions>
	 * 
	 * 
	 * 
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
	

	@Override
	public void createClasspage(CollectionDo collectionDo) {

//		getClasspageService().createClasspage(collectionDo, getCollectionAsyncCallback());
		getClasspageService().v2CreateClasspage(collectionDo, getCollectionAsyncCallback());
		 getView().getClassPageScrollPanel().scrollToTop();
		
	}
	
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
