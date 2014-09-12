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
package org.ednovo.gooru.client.mvp.classpages.unitdetails;
import java.util.ArrayList;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.classpages.unitdetails.personalize.PersonalizeUnitPresenter;
import org.ednovo.gooru.shared.model.content.ClasspageDo;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
public class UnitAssignmentPresenter extends PresenterWidget<IsUnitAssignmentView> implements UnitAssignmentUiHandlers{

	
	
	public static final  Object _SLOT = new Object();
	
	private PersonalizeUnitPresenter studentPersonalizePresenter = null;
	
	private int limit = 5;
	private int offSet = 0;
	private int assignmentOffset=0;
	private int assignmentLimit=5;
	
	@Inject
	public UnitAssignmentPresenter(EventBus eventBus, IsUnitAssignmentView view, PersonalizeUnitPresenter studentPersonalizePresenter) {
		super(eventBus, view);
		getView().setUiHandlers(this);
		this.studentPersonalizePresenter = studentPersonalizePresenter;
	}
	
	public void getClassUnits(String classId){
		if(getView().getUnitPanel().getWidgetCount()<=0){
			getPathwayUnits(classId,limit,offSet,true);
		}
		String unitId=AppClientFactory.getPlaceManager().getRequestParameter("uid", null);
		String assignmentId=AppClientFactory.getPlaceManager().getRequestParameter("aid", null);
		if(unitId!=null&&getView().getCircleContainerPanel().getWidgetCount()<=0){
			getPathwayItems(classId,unitId,"",assignmentOffset,assignmentLimit);
		}
		if(assignmentId!=null){
			//TODO need to implement assignment API:
		}
	}
	
	
	
	@Override
	public void setClasspageData(ClasspageDo classpageDo){
		studentPersonalizePresenter.setClasspageData(classpageDo);
		setInSlot(_SLOT, studentPersonalizePresenter,false);
	}

	@Override
	public void getPathwayItems(String classpageId, String pathwayGooruOid,String sequence,int limit,int offSet) {
		AppClientFactory.getInjector().getClasspageService().v2GetPathwayItems(classpageId, pathwayGooruOid, sequence, limit, offSet, new SimpleAsyncCallback<ArrayList<CollectionItemDo>>() {
			@Override
			public void onSuccess(ArrayList<CollectionItemDo> result) {
				getView().getSequence(result);
			}

		});
	}
	
	public void getPathwayUnits(final String classId,int limit, int offset,final boolean clearPanel) {
		AppClientFactory.getInjector().getClasspageService().v2GetPathwaysOptimized(classId, Integer.toString(limit),  Integer.toString(offset), new SimpleAsyncCallback<ClasspageListDo>() {
			@Override
			public void onSuccess(ClasspageListDo classpageListDo) {
				getView().showUnitNames(classpageListDo,clearPanel);
				if(classpageListDo!=null&&classpageListDo.getSearchResults()!=null&&classpageListDo.getSearchResults().size()>0){
					String unitId=AppClientFactory.getPlaceManager().getRequestParameter("uid", null);
					if(unitId==null){
						getPathwayItems(classId,classpageListDo.getSearchResults().get(0).getGooruOid(),"",assignmentOffset,assignmentLimit);
					}
				}
			}
		});
	}
}
