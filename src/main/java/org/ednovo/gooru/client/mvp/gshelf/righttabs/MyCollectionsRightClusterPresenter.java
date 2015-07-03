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
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.client.mvp.gshelf.ShelfMainPresenter;
import org.ednovo.gooru.client.mvp.gshelf.collectioncontent.CollectionContentPresenter;
import org.ednovo.gooru.client.mvp.gshelf.coursedetails.CourseInfoPresenter;
import org.ednovo.gooru.client.mvp.gshelf.courselist.MyCollectionsListPresenter;
import org.ednovo.gooru.client.mvp.gshelf.lessondetails.LessonInfoPresenter;
import org.ednovo.gooru.client.mvp.gshelf.unitdetails.UnitInfoPresenter;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
public class MyCollectionsRightClusterPresenter extends PresenterWidget<IsMyCollectionsRightClusterView> implements MyCollectionsRightClusterUiHandlers{
	
	public static final  Object INNER_SLOT = new Object();
	
	CourseInfoPresenter courseInfoPresenter;
	
	LessonInfoPresenter lessonInfoPresenter;
	
	UnitInfoPresenter unitInfoPresenter;
	
	ShelfMainPresenter shelfMainPresenter;
	
	FolderDo folderObj;
	
	CollectionContentPresenter collectionContentPresenter;
	
	final String COLLECTION="Collection";
	private static final String O1_LEVEL = "o1";
	private static final String O2_LEVEL = "o2";
	/**
	 * Constructor
	 * @param eventBus
	 * @param view
	 */
	@Inject
	public MyCollectionsRightClusterPresenter(EventBus eventBus, IsMyCollectionsRightClusterView view,CollectionContentPresenter collectionContentPresenter,CourseInfoPresenter courseInfoPresenter,LessonInfoPresenter lessonInfoPresenter,UnitInfoPresenter unitInfoPresenter) {
		super(eventBus, view);
		this.courseInfoPresenter=courseInfoPresenter;
		this.lessonInfoPresenter=lessonInfoPresenter;
		this.unitInfoPresenter=unitInfoPresenter;
		this.collectionContentPresenter=collectionContentPresenter;
		AppClientFactory.printInfoLogger("mycollerightclusterpresenter");
		courseInfoPresenter.setMyCollectionRightClusterPresenter(this);
		unitInfoPresenter.setMyCollectionRightClusterPresenter(this);
		getView().setUiHandlers(this);
	}
	@Override
	public void setTabItems(int index,String type,FolderDo folderObj) {
		if(folderObj!=null){
			this.folderObj=folderObj;
		}
	    AppClientFactory.printInfoLogger("setTabItems");
		clearSlot(INNER_SLOT);
		getView().setSlotPanel(folderObj);
		getView().setDefaultActiveTab(index);
		String o1=AppClientFactory.getPlaceManager().getRequestParameter(O1_LEVEL,null);
		String o2=AppClientFactory.getPlaceManager().getRequestParameter(O2_LEVEL,null);
		if(index==1){
			if(folderObj.getGooruOid()==null){
				//For displaying template
				if(o1==null){
					courseInfoPresenter.callTaxonomyService();
					courseInfoPresenter.setData(folderObj);
					setInSlot(INNER_SLOT, courseInfoPresenter);
				}else if(o1!=null && o2==null){
					unitInfoPresenter.callTaxonomyService();
					unitInfoPresenter.setData(folderObj);
					setInSlot(INNER_SLOT, unitInfoPresenter);
				}else{
					setInSlot(INNER_SLOT, lessonInfoPresenter);
				}
			}else{
				//For displaying original data
				if(o1!=null && o2==null){
					courseInfoPresenter.callTaxonomyService();
					courseInfoPresenter.setData(folderObj);
					setInSlot(INNER_SLOT, courseInfoPresenter);
				}else if(o1!=null && o2!=null){
					unitInfoPresenter.callTaxonomyService();
					unitInfoPresenter.setData(folderObj);
					setInSlot(INNER_SLOT, unitInfoPresenter);
				}else{
					setInSlot(INNER_SLOT, lessonInfoPresenter);
				}
			}
		}else if(index==2){
			if(COLLECTION.equalsIgnoreCase(folderObj.getType())){
				collectionContentPresenter.setData(folderObj);
				setInSlot(INNER_SLOT, collectionContentPresenter);
			}else{
				MyCollectionsListPresenter myCollectionsListPresenter=AppClientFactory.getInjector().getMyCollectionsListPresenter();
				myCollectionsListPresenter.setDataInContentSlot(type,folderObj.getGooruOid(),false);
				setInSlot(INNER_SLOT, myCollectionsListPresenter);
			}
		}else if(index==3){
			
		}
	}
	//This method is not using present
	@Override
	public void setDefaultActiveTab(){
		getView().resetHilightStyles();
		//getView().setDefaultActiveTab();
	}

	@Override
	public void setUnitTemplate(){
		shelfMainPresenter.createNewUnitItem();
		setInSlot(INNER_SLOT, unitInfoPresenter);
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
}
