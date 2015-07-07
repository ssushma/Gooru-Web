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
package org.ednovo.gooru.client.mvp.gshelf.righttabs;
import java.util.HashMap;
import java.util.List;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.mvp.gshelf.ShelfMainPresenter;
import org.ednovo.gooru.client.mvp.gshelf.collectioncontent.CollectionContentPresenter;
import org.ednovo.gooru.client.mvp.gshelf.collectiondetails.CollectionInfoPresenter;
import org.ednovo.gooru.client.mvp.gshelf.collectiondetails.CollectionShareTabPresenter;
import org.ednovo.gooru.client.mvp.gshelf.collectiondetails.ExternalAssessmentInfoPresenter;
import org.ednovo.gooru.client.mvp.gshelf.coursedetails.CourseInfoPresenter;
import org.ednovo.gooru.client.mvp.gshelf.lessondetails.LessonInfoPresenter;
import org.ednovo.gooru.client.mvp.gshelf.unitdetails.UnitInfoPresenter;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
public class MyCollectionsRightClusterPresenter extends PresenterWidget<IsMyCollectionsRightClusterView> implements MyCollectionsRightClusterUiHandlers{

	public static final  Object INNER_SLOT = new Object();

	CourseInfoPresenter courseInfoPresenter;

	LessonInfoPresenter lessonInfoPresenter;
	
	CollectionInfoPresenter collectionInfoPresenter;

	UnitInfoPresenter unitInfoPresenter;

	ShelfMainPresenter shelfMainPresenter;
	
	ExternalAssessmentInfoPresenter externalAssessmentInfoPresenter;
	
	private HashMap<String, String> selectedWidgetsTitleType;

	CollectionContentPresenter collectionContentPresenter;
	
	CollectionShareTabPresenter collectionShareTabPresenter = null;
	
	List<FolderDo> folderListDoChild;

	final String COLLECTION="Collection";
	private static final String O1_LEVEL = "o1";
	private static final String O2_LEVEL = "o2";
	
	private static final String COURSE = "Course";
	private static final String UNIT = "Unit";
	private static final String LESSON = "Lesson";
	/**
	 * Constructor
	 * @param eventBus
	 * @param view
	 */
	@Inject
	public MyCollectionsRightClusterPresenter(EventBus eventBus, IsMyCollectionsRightClusterView view,CollectionContentPresenter collectionContentPresenter,CourseInfoPresenter courseInfoPresenter,LessonInfoPresenter lessonInfoPresenter,ExternalAssessmentInfoPresenter externalAssessmentInfoPresenter,UnitInfoPresenter unitInfoPresenter,CollectionInfoPresenter collectionInfoPresenter,CollectionShareTabPresenter collectionShareTabPresenter) {
		super(eventBus, view);
		this.courseInfoPresenter=courseInfoPresenter;
		this.lessonInfoPresenter=lessonInfoPresenter;
		this.unitInfoPresenter=unitInfoPresenter;
		this.collectionInfoPresenter=collectionInfoPresenter;
		this.collectionContentPresenter=collectionContentPresenter;
		this.externalAssessmentInfoPresenter=externalAssessmentInfoPresenter;
		this.collectionShareTabPresenter=collectionShareTabPresenter;

		courseInfoPresenter.setMyCollectionRightClusterPresenter(this);
		collectionInfoPresenter.setMyCollectionRightClusterPresenter(this);
		unitInfoPresenter.setMyCollectionRightClusterPresenter(this);
		lessonInfoPresenter.setMyCollectionRightClusterPresenter(this);
		getView().setUiHandlers(this);
	}
	@Override
	public void setTabItems(int index,String type,FolderDo folderObj) {
		clearSlot(INNER_SLOT);
		if(folderObj==null){
			selectedWidgetsTitleType = null;
		}
		getView().setBreadCrumbSlot(folderObj,type,selectedWidgetsTitleType);
		getView().setDefaultActiveTab(index);
		getView().setCurrentTypeView(type);
		if(index==1){
				//For displaying template
				if(COURSE.equalsIgnoreCase(type)){ 
					courseInfoPresenter.callTaxonomyService();
					courseInfoPresenter.setData(folderObj);
					setInSlot(INNER_SLOT, courseInfoPresenter);
				}else if("Unit".equalsIgnoreCase(type)){ 
					unitInfoPresenter.callTaxonomyService();
					unitInfoPresenter.setData(folderObj);
					setInSlot(INNER_SLOT, unitInfoPresenter);
				}else if("Lesson".equalsIgnoreCase(type)){
					lessonInfoPresenter.setLessonData(folderObj); 
					setInSlot(INNER_SLOT, lessonInfoPresenter);
				}else if("Assessment".equalsIgnoreCase(type) || "Collection".equalsIgnoreCase(type)){
					collectionInfoPresenter.setCollectionType(type);
					setInSlot(INNER_SLOT, collectionInfoPresenter);
				}else{
					setInSlot(INNER_SLOT, externalAssessmentInfoPresenter);
				}
		}else if(index==2){
			if(COLLECTION.equalsIgnoreCase(folderObj.getType())){
				collectionContentPresenter.setData(folderObj);
				setInSlot(INNER_SLOT, collectionContentPresenter);
			}else{
				shelfMainPresenter.getMyCollectionsListPresenter().setData(type, folderListDoChild, true, true, null);
				setInSlot(INNER_SLOT, shelfMainPresenter.getMyCollectionsListPresenter());
			}
		}else if(index==3){
			if(COLLECTION.equalsIgnoreCase(folderObj.getType())){
				//CollectionShareTabPresenter.setData(folderObj);
				setInSlot(INNER_SLOT, collectionShareTabPresenter);
			}
		}
	}
	//This method is not using present
	@Override
	public void setDefaultActiveTab(){
		getView().resetHilightStyles();
		//getView().setDefaultActiveTab();
	}

	@Override
	public void setUnitTemplate(String type){	
		//shelfMainPresenter.getMyCollectionsListPresenter().setData(type, null, true, true, null);
		//setInSlot(INNER_SLOT, shelfMainPresenter.getMyCollectionsListPresenter());
		shelfMainPresenter.createNewUnitItem(type);
		folderListDoChild=null;
	}

	/**
	 * To set the shelfMainPresenter obj
	 * @param shelfMainPresenter
	 */
	public void setShelfMainPresenter(ShelfMainPresenter shelfMainPresenter) {
		this.shelfMainPresenter=shelfMainPresenter;
	}

	/**
	 * To set the shelfMainPresenter obj
	 * @param shelfMainPresenter
	 */
	public ShelfMainPresenter getShelfMainPresenter() {
		return shelfMainPresenter;
	}
	public List<FolderDo> getFolderListDoChild() {
		return folderListDoChild;
	}
	public void setFolderListDoChild(List<FolderDo> folderListDoChild) {
		this.folderListDoChild = folderListDoChild;
	}
	public void updateBreadCrumbsTitle(FolderDo folderObj, String type) { 
		getView().setBreadCrumbSlot(folderObj, type,null);
	}
	
	
	public void setMycontentBreadcrumbs(HashMap<String, String> selectedWidgetsTitleType) {
		this.selectedWidgetsTitleType = selectedWidgetsTitleType;
	}
	/**
	 * To add new course/unit/lesson
	 * @param type
	 */
	public void addNewContent(String type) {
		if(type!=null){
			if(type.contains(COURSE)){
			    setTabItems(1,COURSE , null);
				setUnitTemplate(COURSE);
				//courseInfoPresenter.createAndSaveCourseDetails(courseInfoPresenter.getView().getCourseTitle(), false);
			}else if(type.contains(UNIT)){	
			    setTabItems(1, UNIT, null);
				setUnitTemplate(UNIT);
				//courseInfoPresenter.createAndSaveCourseDetails(courseInfoPresenter.getView().getCourseTitle(), false);
			}else{
				setTabItems(1, LESSON, null);
				setUnitTemplate(LESSON);
			}
		}
	}
	
	/**
	 * calls API to delete cousrse.
	 */
	@Override
	public void deleteCourseContent(final String o1CourseId) {
		AppClientFactory.getInjector().getfolderService().deleteCourse(o1CourseId, new SimpleAsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {
				getView().onDeleteCourseSuccess(o1CourseId);
			}
		});
	}
	@Override
	public void setRightClusterContent(String o1CourseId) {
		shelfMainPresenter.setUserAllCourses(o1CourseId);
	}
	
}
