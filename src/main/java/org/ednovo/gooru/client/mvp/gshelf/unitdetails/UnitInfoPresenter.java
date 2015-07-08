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
package org.ednovo.gooru.client.mvp.gshelf.unitdetails;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.SimpleAsyncCallback;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.service.TaxonomyServiceAsync;
import org.ednovo.gooru.application.shared.model.code.CourseSubjectDo;
import org.ednovo.gooru.application.shared.model.folder.CreateDo;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.client.mvp.gshelf.righttabs.MyCollectionsRightClusterPresenter;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.Proxy;

/**
 * @author Search TeamUnitInfoPresenter.java
 *
 */
public class UnitInfoPresenter extends PresenterWidget<IsUnitInfoView> implements UnitInfoUiHandlers {

	@Inject
	private TaxonomyServiceAsync taxonomyService;

	MyCollectionsRightClusterPresenter myCollectionsRightClusterPresenter;
	
	final String SUBJECT="subject";
	
	final String UNIT="Unit";
	
	private String LESSON = "Lesson";
	
	private static final String O1_LEVEL = "o1";
	
	/**
	 * Class constructor
	 * @param view {@link View}
	 * @param proxy {@link Proxy}
	 */
	@Inject
	public UnitInfoPresenter( EventBus eventBus,IsUnitInfoView view) {
		super(eventBus,view);
		getView().setUiHandlers(this);
	}

	@Override
	public void onBind() {
		super.onBind();
	}

	@Override
	protected void onReveal(){
		super.onReveal();
	}

	public TaxonomyServiceAsync getTaxonomyService() {
		return taxonomyService;
	}

	public void setTaxonomyService(TaxonomyServiceAsync taxonomyService) {
		this.taxonomyService = taxonomyService;
	}

	@Override
	public void callTaxonomyService() {
		getTaxonomyService().getSubjectsList(1, SUBJECT, 0, 0, new SimpleAsyncCallback<List<CourseSubjectDo>>() {
			@Override
			public void onSuccess(List<CourseSubjectDo> result) {
				getView().setCourseList(result);
				if(result.size()>0){
					callCourseBasedOnSubject(result.get(0).getSubjectId(),result.get(0).getName());
				}
			}
		});
	}
	@Override
	public void callCourseBasedOnSubject(int subjectId,final String selectedText) {
		getTaxonomyService().getSubjectsList(subjectId, UNIT, 0, 10, new SimpleAsyncCallback<List<CourseSubjectDo>>() {
			@Override
			public void onSuccess(List<CourseSubjectDo> result) {
				if(result.size()>0){
					getView().showCourseDetailsBasedOnSubjectd(result,selectedText);
				}
			}
		});
	}

	@Override
	public void createAndSaveUnitDetails(CreateDo createDo,final boolean isCreateLesson) {
		String o1=AppClientFactory.getPlaceManager().getRequestParameter(O1_LEVEL,null);
		AppClientFactory.getInjector().getfolderService().createCourse(createDo, true, o1,null,null, new SimpleAsyncCallback<FolderDo>() {
			@Override
			public void onSuccess(FolderDo result) {
				String[] uri=result.getUri().split("/");
				Map<String, String> params= new HashMap<String, String>();
				params.put("o1", AppClientFactory.getPlaceManager().getRequestParameter("o1"));
				params.put("o2", uri[uri.length-1]);
				params.put("view", "Course");
				result.setGooruOid(uri[uri.length-1]);
				myCollectionsRightClusterPresenter.getShelfMainPresenter().updateTitleOfTreeWidget(result,isCreateLesson);
				myCollectionsRightClusterPresenter.updateBreadCrumbsTitle(result,UNIT); 
				if(isCreateLesson){
					myCollectionsRightClusterPresenter.setTabItems(1, LESSON, null);
					myCollectionsRightClusterPresenter.setUnitTemplate(LESSON);
				}else{
					myCollectionsRightClusterPresenter.setTabItems(2, UNIT, result);
				}
				AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.MYCONTENT, params);
			}
		});
	}
	@Override
	public void updateUnitDetails(final CreateDo createDo, final String id,final boolean isCreateUnit) {
		String o1= AppClientFactory.getPlaceManager().getRequestParameter("o1",null);
		AppClientFactory.getInjector().getfolderService().updateCourse(o1,id,null,null,createDo, new SimpleAsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				FolderDo folderDo = new FolderDo();
				folderDo.setTitle(createDo.getTitle());
				folderDo.setType(UNIT);
				//folderDo.setGooruOid(id);
				myCollectionsRightClusterPresenter.setTabItems(1, UNIT, folderDo);
				myCollectionsRightClusterPresenter.getShelfMainPresenter().updateTitleOfTreeWidget(folderDo,isCreateUnit);
				if(isCreateUnit){
					myCollectionsRightClusterPresenter.setTabItems(1, LESSON, null);
					myCollectionsRightClusterPresenter.setUnitTemplate(LESSON);
				}
			}
		});
	}
	@Override
	public void checkProfanity(String textValue,final boolean isCreate,final int index){
		final Map<String, String> parms = new HashMap<String, String>();
		parms.put("text",textValue);
		AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {
			@Override
			public void onSuccess(Boolean value) {
				getView().callCreateAndUpdate(isCreate,value,index);
			}
		});
	}
	@Override
	public void showUnitInfo() {
		//myCollectionsRightClusterPresenter.setUnitInfo();
	}
	@Override
	public void showUnitTemplate() {
		//myCollectionsRightClusterPresenter.setUnitTemplate();
	}

	public void setMyCollectionRightClusterPresenter(MyCollectionsRightClusterPresenter myCollectionsRightClusterPresenter) {
		this.myCollectionsRightClusterPresenter=myCollectionsRightClusterPresenter;
	}

	public void setData(FolderDo folderObj) {
		getView().setCouseData(folderObj);
	}
}
