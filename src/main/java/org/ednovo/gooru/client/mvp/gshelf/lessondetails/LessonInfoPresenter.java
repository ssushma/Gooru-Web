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
package org.ednovo.gooru.client.mvp.gshelf.lessondetails;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.service.TaxonomyServiceAsync;
import org.ednovo.gooru.application.shared.model.code.CourseSubjectDo;
import org.ednovo.gooru.application.shared.model.folder.CreateDo;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.application.shared.model.library.DomainStandardsDo;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.mvp.gshelf.righttabs.MyCollectionsRightClusterPresenter;
import org.ednovo.gooru.client.mvp.gshelf.taxonomy.TaxonomyPopupPresenter;
import org.ednovo.gooru.client.mvp.standards.StandardsPopupPresenter;
import org.ednovo.gooru.client.uc.UlPanel;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.Proxy;

/**
 * @author Search Team
 *
 */
public class LessonInfoPresenter extends PresenterWidget<IsLessonInfoView> implements LessonInfoUiHandlers {

	@Inject
	private TaxonomyServiceAsync taxonomyService;

	StandardsPopupPresenter standardsPopupPresenter;

	MyCollectionsRightClusterPresenter myCollectionsRightClusterPresenter;
	
	TaxonomyPopupPresenter taxonomyPopupPresenter;
	
	private static final String O1_LEVEL = "o1";
	private static final String O2_LEVEL = "o2";

	final String LESSON="Lesson";

	/**
	 * Class constructor
	 * @param view {@link View}
	 * @param proxy {@link Proxy}
	 */
	@Inject
	public LessonInfoPresenter( EventBus eventBus,IsLessonInfoView view,StandardsPopupPresenter standardsPopupPresenter, TaxonomyPopupPresenter taxonomyPopupPresenter) {
		super(eventBus,view);
		this.standardsPopupPresenter = standardsPopupPresenter;
		this.taxonomyPopupPresenter = taxonomyPopupPresenter;
		taxonomyPopupPresenter.setLessonInfoPresenterInstance(this);
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
	public void showStandardsPopup(String standardVal, String titleVal) {
		standardsPopupPresenter.callStandardsBasedonTypeService(standardVal,titleVal);
		addToPopupSlot(standardsPopupPresenter);
	}

	@Override
	public void createAndSaveLessonDetails(CreateDo createDo,final boolean isCreateCollOrAssessment,final String creationType) {
		String o1=AppClientFactory.getPlaceManager().getRequestParameter(O1_LEVEL,null);
		String o2=AppClientFactory.getPlaceManager().getRequestParameter(O2_LEVEL,null);
		AppClientFactory.getInjector().getfolderService().createCourse(createDo, true, o1,o2,null, new SimpleAsyncCallback<FolderDo>() {
			@Override
			public void onSuccess(FolderDo result) {
				Map<String, String> params= new HashMap<String, String>();
				params.put("o1", AppClientFactory.getPlaceManager().getRequestParameter("o1"));
				params.put("o2", AppClientFactory.getPlaceManager().getRequestParameter("o2"));
				params.put("o3",result.getGooruOid());
				params.put("view", "Course");

				myCollectionsRightClusterPresenter.getShelfMainPresenter().updateTitleOfTreeWidget(result,isCreateCollOrAssessment);
				if(isCreateCollOrAssessment && creationType!=null){
					myCollectionsRightClusterPresenter.setTabItems(1, LESSON, result);
					myCollectionsRightClusterPresenter.setTabItems(1, creationType, null);
					myCollectionsRightClusterPresenter.setUnitTemplate(creationType);
				}else{
					myCollectionsRightClusterPresenter.setTabItems(2, LESSON, result);
				}
				AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.MYCONTENT, params);
			}
		});
	}
	@Override
	public void updateLessonDetails(final CreateDo createDo, final String id,final boolean isCreateColl,final String type,final FolderDo folderObj) {
		String o1= AppClientFactory.getPlaceManager().getRequestParameter("o1",null);
		String o2= AppClientFactory.getPlaceManager().getRequestParameter("o2",null);
		AppClientFactory.getInjector().getfolderService().updateCourse(o1,o2,id,null,createDo, new SimpleAsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				folderObj.setTitle(createDo.getTitle());
				folderObj.setType(LESSON);
				//folderDo.setGooruOid(id);
				
				myCollectionsRightClusterPresenter.getShelfMainPresenter().updateTitleOfTreeWidget(folderObj,isCreateColl);
				if(isCreateColl && type!=null){
					myCollectionsRightClusterPresenter.setTabItems(1, LESSON, folderObj);
					myCollectionsRightClusterPresenter.setTabItems(1, type, null);
					myCollectionsRightClusterPresenter.setUnitTemplate(type);
				}else{
					myCollectionsRightClusterPresenter.setTabItems(2, LESSON, folderObj);
				}
			}
		});
	}
	
	@Override
	public MyCollectionsRightClusterPresenter getMyCollectionsRightClusterPresenter() {
		return myCollectionsRightClusterPresenter;
	}
	
	public void setMyCollectionRightClusterPresenter(MyCollectionsRightClusterPresenter myCollectionsRightClusterPresenter) {
		this.myCollectionsRightClusterPresenter=myCollectionsRightClusterPresenter;
	}

	public void setLessonData(FolderDo folderObj) {
		getView().setLessonInfoData(folderObj);
		//callTaxonomyService(1);
	}

	@Override
	public void checkProfanity(String textValue, final boolean isCreate,final String type) {
		final Map<String, String> parms = new HashMap<String, String>();
		parms.put("text",textValue);
		AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {
			@Override
			public void onSuccess(Boolean value) {
				getView().callCreateAndUpdate(isCreate,value,type);
			}
		});
	}
	@Override
	public void callTaxonomyService(int subdomainId) {
		getTaxonomyService().getStandardsList(subdomainId,new SimpleAsyncCallback<List<DomainStandardsDo>>() {
			@Override
			public void onSuccess(List<DomainStandardsDo> result) {
				if(result.size()>0){
					getView().displayStandardsList(result);
				}
			}
		});
	}

	@Override
	public void invokeTaxonomyPopup(String viewType) {
		taxonomyPopupPresenter.getTaxonomySubjects(viewType, 1, "subject", 0, 20);
		addToPopupSlot(taxonomyPopupPresenter);
	}
	@Override
	public void callCourseInfoTaxonomy(){
		String courseId=AppClientFactory.getPlaceManager().getRequestParameter(O1_LEVEL,null);
		String unitId=AppClientFactory.getPlaceManager().getRequestParameter(O2_LEVEL,null);
		AppClientFactory.getInjector().getfolderService().getCourseDetails(courseId, unitId, null, new SimpleAsyncCallback<FolderDo>() {
			@Override
			public void onSuccess(FolderDo result) {
				if(result.getSubdomain()!=null && result.getSubdomain().size()>0){
					CourseSubjectDo courseSubjectObj=result.getSubdomain().get(0);
					callTaxonomyService(courseSubjectObj.getId());
				}
			}
		});
	}
	public void addTaxonomyData(UlPanel selectedUlContainer) { 
		getView().addTaxonomyData(selectedUlContainer);
	}
}
