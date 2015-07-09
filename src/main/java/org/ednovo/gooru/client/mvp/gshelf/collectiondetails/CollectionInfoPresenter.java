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
package org.ednovo.gooru.client.mvp.gshelf.collectiondetails;

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
import org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter;
import org.ednovo.gooru.client.mvp.standards.StandardsPopupPresenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.Proxy;

/**
 * @author Search Team
 *
 */
public class CollectionInfoPresenter extends PresenterWidget<IsCollectionInfoView> implements CollectionInfoUiHandlers {

	@Inject
	private TaxonomyServiceAsync taxonomyService;

	MyCollectionsRightClusterPresenter myCollectionsRightClusterPresenter;
	
	StandardsPopupPresenter standardsPopupPresenter;
	
	final String SUBJECT="subject";
	
	final String COURSE="Course";
	
	private String UNIT = "Unit";
	
	private String COLLECTION = "Collection";
	
	private String type;
	
	private static final String O1_LEVEL = "o1";
	private static final String O2_LEVEL = "o2";
	private static final String O3_LEVEL = "o3";
	
	ImageUploadPresenter imgUploadPresenter=null;
	
	
	/**
	 * Class constructor
	 * @param view {@link View}
	 * @param proxy {@link Proxy}
	 */
	@Inject
	public CollectionInfoPresenter( EventBus eventBus,IsCollectionInfoView view,ImageUploadPresenter imgUploadPresenter,StandardsPopupPresenter standardsPopupPresenter) {
		super(eventBus,view);
		getView().setUiHandlers(this);
		this.imgUploadPresenter = imgUploadPresenter;
		this.standardsPopupPresenter=standardsPopupPresenter;
	}

	@Override
	public void onBind() {
		super.onBind();
		Window.enableScrolling(true);
	}

	@Override
	protected void onReveal(){
		super.onReveal();
		Window.enableScrolling(true);
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
			//	getView().setCourseList(result);
				if(result.size()>0){
					callCourseBasedOnSubject(result.get(0).getSubjectId(),result.get(0).getName());
				}
			}
		});
	}
	@Override
	public void callCourseBasedOnSubject(int subjectId,final String selectedText) {
		getTaxonomyService().getSubjectsList(subjectId, COURSE, 0, 10, new SimpleAsyncCallback<List<CourseSubjectDo>>() {
			@Override
			public void onSuccess(List<CourseSubjectDo> result) {
				if(result.size()>0){
					//getView().showCourseDetailsBasedOnSubjectd(result,selectedText);
				}
			}
		});
	}
	
	@Override
	public void setCollectionType(String templateType) {
		getView().setCollectionType(templateType);
	}
	
	@Override
	public void createAndSaveCourseDetails(CreateDo createObj,final boolean isCreateUnit) {
		final String o1=AppClientFactory.getPlaceManager().getRequestParameter(O1_LEVEL,null);
		final String o2=AppClientFactory.getPlaceManager().getRequestParameter(O2_LEVEL,null);
		final String o3=AppClientFactory.getPlaceManager().getRequestParameter(O3_LEVEL,null);		
		AppClientFactory.getInjector().getfolderService().createCourse(createObj, true,o1,o2,o3, new SimpleAsyncCallback<FolderDo>() {
			@Override
			public void onSuccess(FolderDo result) {				
				String[] uri=result.getUri().split("/");
				Map<String, String> params= new HashMap<String, String>();
				params.put(O1_LEVEL, o1);
				params.put(O2_LEVEL, o2);
				params.put(O3_LEVEL, o3);
				params.put("id", uri[uri.length-1]);
				params.put("view", "course");
				result.setGooruOid(uri[uri.length-1]);
				myCollectionsRightClusterPresenter.getShelfMainPresenter().updateTitleOfTreeWidget(result, true);
				myCollectionsRightClusterPresenter.updateBreadCrumbsTitle(result,COLLECTION); 
				myCollectionsRightClusterPresenter.getShelfMainPresenter().enableCreateCourseButton(true); // To enable Create course button passing true value.
				myCollectionsRightClusterPresenter.setTabItems(2, COLLECTION, result);
				AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.MYCONTENT, params);
			}
		});
	}

	public void setMyCollectionRightClusterPresenter(
			MyCollectionsRightClusterPresenter myCollectionsRightClusterPresenter) {
		this.myCollectionsRightClusterPresenter=myCollectionsRightClusterPresenter;
	}

	public void setData(FolderDo folderObj) {
		getView().setCouseData(folderObj);
	}
	
	@Override
	public void showStandardsPopup(String standardVal) {
		standardsPopupPresenter.callStandardsBasedonTypeService(standardVal);
		addToPopupSlot(standardsPopupPresenter);
	}

	@Override
	public void updateCourseDetails(final CreateDo createDo, final String id,final boolean isCreateUnit) {
		String o1= AppClientFactory.getPlaceManager().getRequestParameter("o1",null);
		String o2= AppClientFactory.getPlaceManager().getRequestParameter("o2",null);
		String o3= AppClientFactory.getPlaceManager().getRequestParameter("o3",null);
		String o4= AppClientFactory.getPlaceManager().getRequestParameter("id",null);
		AppClientFactory.getInjector().getfolderService().updateCourse(o1,o2,o3,o4,createDo, new SimpleAsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				FolderDo folderDo = new FolderDo();
				folderDo.setTitle(createDo.getTitle());
				folderDo.setCollectionType(COLLECTION);
				//folderDo.setGooruOid(id);
				myCollectionsRightClusterPresenter.setTabItems(1, COLLECTION, folderDo);
				myCollectionsRightClusterPresenter.getShelfMainPresenter().updateTitleOfTreeWidget(folderDo,true);
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
	public void uploadCollectionImage(CreateDo createDoObj) {
		addToPopupSlot(imgUploadPresenter);
		CreateDo createOrUpDate=new CreateDo();
		createOrUpDate.setTitle(createDoObj.getTitle());
		createOrUpDate.setDescription(createDoObj.getDescription());
		createOrUpDate.setCollectionType(COLLECTION);
		imgUploadPresenter.setCollectionData(createDoObj);
        imgUploadPresenter.setCollectionImage(true);
        imgUploadPresenter.setClassPageImage(false);
        imgUploadPresenter.setUpdateQuestionImage(false);
        imgUploadPresenter.setEditResourceImage(false);
		
	}

	
}
