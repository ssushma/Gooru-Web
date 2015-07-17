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
package org.ednovo.gooru.client.mvp.gshelf.coursedetails;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.SimpleAsyncCallback;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.service.TaxonomyServiceAsync;
import org.ednovo.gooru.application.shared.model.code.CourseSubjectDo;
import org.ednovo.gooru.application.shared.model.content.ListValuesDo;
import org.ednovo.gooru.application.shared.model.folder.CreateDo;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.client.mvp.gshelf.righttabs.MyCollectionsRightClusterPresenter;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.Proxy;

/**
 * @author Search Team
 *
 */
public class CourseInfoPresenter extends PresenterWidget<IsCourseInfoView> implements CourseInfoUiHandlers {

	@Inject
	private TaxonomyServiceAsync taxonomyService;

	MyCollectionsRightClusterPresenter myCollectionsRightClusterPresenter;
	
	final String SUBJECT="subject";
	
	final String COURSE="Course";
	
	private String UNIT = "UNIT";
	
	Map<String, String> params= new HashMap<String, String>();
	
	/**
	 * Class constructor
	 * @param view {@link View}
	 * @param proxy {@link Proxy}
	 */
	@Inject
	public CourseInfoPresenter( EventBus eventBus,IsCourseInfoView view) {
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
		setAudienceDetails();
	}
	public TaxonomyServiceAsync getTaxonomyService() {
		return taxonomyService;
	}

	public void setTaxonomyService(TaxonomyServiceAsync taxonomyService) {
		this.taxonomyService = taxonomyService;
	}
	@Override
	public void callTaxonomyService(int classifierId) {
		getTaxonomyService().getSubjectsList(classifierId, SUBJECT, 0, 0, new SimpleAsyncCallback<List<CourseSubjectDo>>() {
			@Override
			public void onSuccess(List<CourseSubjectDo> result) {
				getView().setCourseList(result);
				if(result.size()>0){
					callCourseBasedOnSubject(result.get(0).getSubjectId(),result.get(0).getSubjectId());
				}
			}
		});
	}
	@Override
	public void callCourseBasedOnSubject(int subjectId,final int selectedId) {
		getTaxonomyService().getSubjectsList(subjectId, COURSE, 0, 0, new SimpleAsyncCallback<List<CourseSubjectDo>>() {
			@Override
			public void onSuccess(List<CourseSubjectDo> result) {
				if(result.size()>0){
					getView().showCourseDetailsBasedOnSubjectd(result,selectedId);
				}
			}
		});
	}

	@Override
	public void createAndSaveCourseDetails(final CreateDo createObj,final boolean isCreateUnit,final FolderDo folderDo) {
		AppClientFactory.getInjector().getfolderService().createCourse(createObj, true,null,null,null, new SimpleAsyncCallback<FolderDo>() {
			@Override
			public void onSuccess(FolderDo result) {
				params.put("o1", result.getGooruOid());
				params.put("view", COURSE);
				myCollectionsRightClusterPresenter.getShelfMainPresenter().updateTitleOfTreeWidget(result,isCreateUnit);
				myCollectionsRightClusterPresenter.updateBreadCrumbsTitle(result,COURSE); 
				myCollectionsRightClusterPresenter.getShelfMainPresenter().enableCreateCourseButton(true); // To enable Create course button passing true value.
				AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.MYCONTENT, params);
				if(isCreateUnit){
					myCollectionsRightClusterPresenter.setTabItems(1, COURSE, result);
					myCollectionsRightClusterPresenter.setTabItems(1,UNIT , null);
					myCollectionsRightClusterPresenter.setUnitTemplate(UNIT);
				}else{
					myCollectionsRightClusterPresenter.setTabItems(2, COURSE, result);
				}
			}
		});
	}
	public void setMyCollectionRightClusterPresenter(
			MyCollectionsRightClusterPresenter myCollectionsRightClusterPresenter) {
		this.myCollectionsRightClusterPresenter=myCollectionsRightClusterPresenter;
	}
	public void setData(FolderDo folderObj) {
		getView().setCouseData(folderObj);
		callTaxonomyService(1);
	}

	@Override
	public void updateCourseDetails(final CreateDo createObj, final String id,final boolean isCreateUnit,final FolderDo folderDo) {
		createObj.setAudienceIds(StringUtil.getKeys(getView().getAudienceContainer().getSelectedValues().keySet()));
		AppClientFactory.getInjector().getfolderService().updateCourse(id,null,null,null,createObj, new SimpleAsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				folderDo.setTitle(createObj.getTitle());
				folderDo.setType(COURSE);
				folderDo.setAudience(StringUtil.getCheckBoxSelectedDo(getView().getAudienceContainer().getSelectedValues()));
				myCollectionsRightClusterPresenter.getShelfMainPresenter().updateTitleOfTreeWidget(folderDo,isCreateUnit);
				if(isCreateUnit){
					myCollectionsRightClusterPresenter.setTabItems(1, COURSE, folderDo);
					myCollectionsRightClusterPresenter.setTabItems(1, UNIT, null);
					myCollectionsRightClusterPresenter.setUnitTemplate("Unit");
				}else{
					myCollectionsRightClusterPresenter.setTabItems(2, COURSE, folderDo);
				}
			}
		});
	}
	@Override
	public void checkProfanity(String textValue,final boolean isCreate){
		final Map<String, String> parms = new HashMap<String, String>();
		parms.put("text",textValue);
		AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {
			@Override
			public void onSuccess(Boolean value) {
				getView().callCreateAndUpdate(isCreate,value);
			}
		});
	}
	
	public void setAudienceDetails(){
		AppClientFactory.getInjector().getfolderService().getAudienceList(new AsyncCallback<List<ListValuesDo>>() {
			@Override
			public void onSuccess(List<ListValuesDo> result) {
				getView().getAudienceContainer().init(result);
				getView().getAudienceContainer().setFolderDetails(getView().getCourseDetails());
			}
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}
}
