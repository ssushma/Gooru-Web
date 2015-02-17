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
package org.ednovo.gooru.client.mvp.shelf.collection.tab.info;

import java.util.List;

import org.ednovo.gooru.client.SearchAsyncCallback;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.home.library.events.StandardPreferenceSettingEvent;
import org.ednovo.gooru.client.mvp.search.CenturySkills.AddCenturyPresenter;
import org.ednovo.gooru.client.mvp.search.standards.AddStandardsPresenter;
import org.ednovo.gooru.client.service.SearchServiceAsync;
import org.ednovo.gooru.client.service.TaxonomyServiceAsync;
import org.ednovo.gooru.client.uc.tooltip.BrowseStandardsTooltip;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.code.LibraryCodeDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.search.SearchDo;
import org.ednovo.gooru.shared.model.user.ProfileDo;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

/**
 * @author Search Team
 *
 */
public class CollectionInfoTabPresenter extends PresenterWidget<IsCollectionInfoTabView> implements CollectionInfoTabUiHandlers {

	@Inject
	private TaxonomyServiceAsync taxonomyService;

	@Inject
	private SearchServiceAsync searchService;

	private SearchAsyncCallback<SearchDo<CodeDo>> standardSuggestionAsyncCallback;
	private SearchAsyncCallback<SearchDo<CodeDo>> standardSuggestionByFilterAsyncCallback;
	
	private static final String USER_META_ACTIVE_FLAG = "0";
	private boolean isCCSSAvailable =false;
	private boolean isNGSSAvailable =false;
	private boolean isTEKSAvailable =false;
	private boolean isCAAvailable =false;
	
	AddStandardsPresenter addStandardsPresenter = null;
	AddCenturyPresenter addCenturyPresenter = null;
	BrowseStandardsTooltip browseStandardsTooltip;
	private boolean isBrowseStandardsToolTip = false;
	private boolean isBrowseTooltip =false;

	/**
	 * Class constructor
	 * 
	 * @param eventBus {@link EventBus}
	 * @param view {@link View}
	 */
	@Inject
	public CollectionInfoTabPresenter(EventBus eventBus, IsCollectionInfoTabView view,AddStandardsPresenter addStandardsPresenter,AddCenturyPresenter addCenturyPresenter) {
		super(eventBus, view);
		this.addStandardsPresenter = addStandardsPresenter;
		this.addCenturyPresenter=addCenturyPresenter;
		getView().setUiHandlers(this);
	}

	@Override
	public void onBind() {
		super.onBind();
	}
	
	

	@Override
	public void onReveal() {
		super.onReveal();
	
		getView().onLoad();
		getView().reset();
			getTaxonomyService().getCourse(new SimpleAsyncCallback<List<LibraryCodeDo>>() {

				@Override
				public void onSuccess(List<LibraryCodeDo> result) {
					getView().setCourseList(result);
				}
			});
			AppClientFactory.getInjector().getUserService().getUserProfileV2Details(AppClientFactory.getGooruUid(),USER_META_ACTIVE_FLAG,new SimpleAsyncCallback<ProfileDo>() {

				@Override
				public void onSuccess(ProfileDo profileObj) {
				if(profileObj.getUser().getMeta().getTaxonomyPreference().getCodeId()!=null){
						if(profileObj.getUser().getMeta().getTaxonomyPreference().getCodeId().size()==0){
							getView().getStandardContainer().setVisible(true);
							isBrowseTooltip = true;
							DisableStandars();
						}else
						{
							getView().getUserStandardPrefCodeId(profileObj.getUser().getMeta().getTaxonomyPreference().getCode());
							getView().getStandardContainer().setVisible(true);
							isBrowseTooltip = false;
							enableStandards();
						}
					}else{
						getView().getStandardContainer().setVisible(true);
						isBrowseTooltip = true;
						DisableStandars();
					}
				}

			});
			String collectionUid = AppClientFactory.getPlaceManager().getRequestParameter("id");
			AppClientFactory.getInjector().getResourceService().getCollection(collectionUid,true, new SimpleAsyncCallback<CollectionDo>() {

				@Override
				public void onSuccess(CollectionDo result) {
					getView().setData(result);
				}
			});
	}
	
	@Override
	protected void onReset() {
		// TODO Auto-generated method stub
		super.onReset();
	}

	@Override
	protected void onHide() {
		super.onHide();
		getView().onUnload();
		getView().closeAllOpenedPopUp();
	}

	/**
	 * @return suggestion standards for the collection as map string
	 */
	public SearchAsyncCallback<SearchDo<CodeDo>> getStandardSuggestionAsyncCallback() {
		if (standardSuggestionAsyncCallback == null) {
			standardSuggestionAsyncCallback = new SearchAsyncCallback<SearchDo<CodeDo>>() {

				@Override
				protected void run(SearchDo<CodeDo> searchDo) {
					getSearchService().getSuggestStandard(searchDo, this);
				}

				@Override
				public void onCallSuccess(SearchDo<CodeDo> result) {
					getView().setStandardSuggestions(result);
				}
			};
		}
		return standardSuggestionAsyncCallback;
	}

	/**
	 * @return suggestion standards for the collection as map string
	 */
	public SearchAsyncCallback<SearchDo<CodeDo>> getStandardSuggestionByFilterCourseIdAsyncCallback() {
		if (standardSuggestionByFilterAsyncCallback == null) {
			standardSuggestionByFilterAsyncCallback = new SearchAsyncCallback<SearchDo<CodeDo>>() {

				@Override
				protected void run(SearchDo<CodeDo> searchDo) {
					getSearchService().getSuggestStandardByFilterCourseId(searchDo, this);
				}

				@Override
				public void onCallSuccess(SearchDo<CodeDo> result) {
					getView().setStandardSuggestions(result);
				}
			};
		}
		return standardSuggestionByFilterAsyncCallback;
	}

	@Override
	public void requestStandardsSuggestion(SearchDo<CodeDo> searchDo) {
		getStandardSuggestionByFilterCourseIdAsyncCallback().execute(searchDo);
	}

	public void setSearchService(SearchServiceAsync searchService) {
		this.searchService = searchService;
	}

	public SearchServiceAsync getSearchService() {
		return searchService;
	}

	public TaxonomyServiceAsync getTaxonomyService() {
		return taxonomyService;
	}

	@Override
	public void updateCourse(String collectionId, String courseCode, String action) {
		  	
		AppClientFactory.getInjector().getResourceService().updateCollectionMetadata(collectionId, null, null, null, null, null, courseCode, null, null, action, new SimpleAsyncCallback<CollectionDo>() {

			@Override
			public void onSuccess(CollectionDo result) {	
				getView().onPostCourseUpdate(result);
			}
		});
	}
	
/*	@Override
	public void updateCollectionTeacherTipInfo(CollectionDo collectionDo, String teacherTip) {
		if(teacherTip.length()>0)
		{
		AppClientFactory.getInjector().getResourceService().updateCollectionInfo(collectionDo, teacherTip, new AsyncCallback<CollectionDo>() {

			@Override
			public void onSuccess(CollectionDo result) {
				getView().setExistingTeacherTip(result);
				//getView().onPostCourseUpdate(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
		}
		else
		{
			getView().displayErrorMsgTeacherTip();
		}

	}*/
	
/*	@Override
	public void getCollectionTeacherTipInfo(String collectionId) {

		AppClientFactory.getInjector().getResourceService().getCollectionInfoV2API(collectionId, new AsyncCallback<CollectionDo>() {

			@Override
			public void onSuccess(CollectionDo result) {
				getView().setExistingTeacherTip(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});


	}*/

	@Override
	public void updateStandard(String collectionId, String taxonomyCodeId, String action) {
		AppClientFactory.getInjector().getResourceService().updateCollectionMetadata(collectionId, null, null, null, null, null, taxonomyCodeId, "false", null,action, new SimpleAsyncCallback<CollectionDo>() {

			@Override
			public void onSuccess(CollectionDo result) {
				getView().onPostStandardUpdate(result);
			}
		});
		
	}
	
/* 
 *  This method used to update the mediaType value of the collection
 *  @param collectionId of the collection
 *  @param mediaType of the collection which is being updated
 */
	@Override
	public void updateMediaType(String collectionId, String mediaType) {
		AppClientFactory.getInjector().getResourceService().updateCollectionMetadata(collectionId, null, null, null, null, null, null, null, mediaType, null, new SimpleAsyncCallback<CollectionDo>() {

			@Override
			public void onSuccess(CollectionDo result) {
				getView().onPostStandardUpdate(result);
			}
		});
		
	}
	@Override
	public void deleteCourseOrStandard(String collectionId, String courseCode) {
		AppClientFactory.getInjector().getResourceService().deleteTaxonomyResource(collectionId, Integer.valueOf(courseCode), new SimpleAsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
			}
		});
	}

	@Override
	public void getAutoSuggestedStandardsList(SearchDo<CodeDo> searchDo) {
		AppClientFactory.getInjector().getSearchService().getSuggestStandardByFilterCourseIdsource(searchDo, new AsyncCallback<SearchDo<CodeDo>>() {
			
			@Override
			public void onSuccess(SearchDo<CodeDo> result) {
				// TODO Auto-generated method stub
				getView().setStandardSuggestions(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public void getAddStandards() {
		

		AppClientFactory.getInjector().getUserService().getUserProfileV2Details(AppClientFactory.getLoggedInUser().getGooruUId(),
				USER_META_ACTIVE_FLAG,
				new SimpleAsyncCallback<ProfileDo>() {
					@Override
					public void onSuccess(final ProfileDo profileObj) {
					AppClientFactory.fireEvent(new StandardPreferenceSettingEvent(profileObj.getUser().getMeta().getTaxonomyPreference().getCode()));
					checkStandarsList(profileObj.getUser().getMeta().getTaxonomyPreference().getCode());
					}
					public void checkStandarsList(List<String> standarsPreferencesList) {
						
					if(standarsPreferencesList!=null){
							if(standarsPreferencesList.contains("CCSS")){
								isCCSSAvailable = true;
							}else{
								isCCSSAvailable = false;
							}
							if(standarsPreferencesList.contains("NGSS")){
								isNGSSAvailable = true;
							}else{
								isNGSSAvailable = false;
							}
							if(standarsPreferencesList.contains("TEKS")){
								isTEKSAvailable = true;
							}else{
								isTEKSAvailable = false;
							}
							if(standarsPreferencesList.contains("CA")){
								isCAAvailable = true;
							}else{
								isCAAvailable = false;
							}
								if(isCCSSAvailable || isNGSSAvailable || isTEKSAvailable || isCAAvailable){
									addStandardsPresenter.enableStandardsData(isCCSSAvailable,isTEKSAvailable,isNGSSAvailable,isCAAvailable);
									addToPopupSlot(addStandardsPresenter);
									getView().OnStandardsClickEvent(addStandardsPresenter.getAddBtn());
								}
					}
						
					}

				});
	}
	
	@Override
	public void setUpdatedStandards() {
		getView().setUpdatedStandards(addStandardsPresenter.setStandardsVal(), addStandardsPresenter.setStandardsIdVal(),addStandardsPresenter.setStandardDesc());
	}
	
	@Override
	public void closeStandardsPopup() {
		addStandardsPresenter.hidePopup();
	}
	
    public void DisableStandars(){
   	 browseStandardsTooltip=new BrowseStandardsTooltip("To see all standards, please edit your standards preference in","settings");
		getView().getBrowseBtn().getElement().getStyle().setColor("#999");
		getView().getBrowseBtn().getElement().addClassName("disabled");
		getView().getBrowseBtn().addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
					if(isBrowseTooltip == true){
						browseStandardsTooltip.show();
						browseStandardsTooltip.setPopupPosition(getView().getBrowseBtn().getAbsoluteLeft()+3, getView().getBrowseBtn().getAbsoluteTop()+33);
						browseStandardsTooltip.getElement().getStyle().setZIndex(999999);
						isBrowseStandardsToolTip= true;
					}
				}
		});
		
		Event.addNativePreviewHandler(new NativePreviewHandler() {
	        public void onPreviewNativeEvent(NativePreviewEvent event) {
	        	hideBrowseStandardsPopup(event);
	          }
	    });
	}
	
	public void hideBrowseStandardsPopup(NativePreviewEvent event){
		try{
			if(event.getTypeInt()==Event.ONMOUSEOVER){
				Event nativeEvent = Event.as(event.getNativeEvent());
				boolean target=eventTargetsPopup(nativeEvent);
				if(!target)
				{
					if(isBrowseStandardsToolTip){
						browseStandardsTooltip.hide();
					}
				}
			}
		}catch(Exception ex){ex.printStackTrace();}
	}
	
	private boolean eventTargetsPopup(NativeEvent event) {
		EventTarget target = event.getEventTarget();
		if (Element.is(target)) {
			try{
				return browseStandardsTooltip.getElement().isOrHasChild(Element.as(target));
			}catch(Exception ex){}
		}
		return false;
	}

	public void enableStandards(){
		getView().getBrowseBtn().getElement().getStyle().clearColor();
		getView().getBrowseBtn().getElement().removeClassName("disabled");
	}

	@Override
	public void getAutoSuggestedCenturyList(SearchDo<CodeDo> standardSearchDo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUpdatedCentury() {
		// TODO Auto-generated method stub
		getView().setUpdatedCentury(addStandardsPresenter.setStandardsVal(), addStandardsPresenter.setStandardsIdVal(),addStandardsPresenter.setStandardDesc());
		
	}

	@Override
	public void getAddCentury() {
		//addCenturyPresenter.enableStandardsData();
		addToPopupSlot(addCenturyPresenter);
		//getView().OnCenturyClickEvent(addCenturyPresenter.getAddBtn());
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeCenturyPopup() {
		// TODO Auto-generated method stub
		addCenturyPresenter.hidePopup();
		
	}

	@Override
	public void updateCentury(String gooruOid, String string, String string2) {
		// TODO Auto-generated method stub
	/*	AppClientFactory.getInjector().getResourceService().updateCollectionMetadata(collectionId, null, null, null, null, null, taxonomyCodeId, "false", null,action, new SimpleAsyncCallback<CollectionDo>() {

			@Override
			public void onSuccess(CollectionDo result) {
				getView().onPostStandardUpdate(result);
			}
		});*/
		
	}

}
