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
package org.ednovo.gooru.client.mvp.classpages.unitSetup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.client.uc.PPanel;
import org.ednovo.gooru.client.uc.PaginationButtonUc;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.ClassDo;
import org.ednovo.gooru.shared.model.content.ClassUnitsListDo;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;
import org.ednovo.gooru.shared.model.content.UnitAssignmentsDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
public class UnitSetupView extends BaseViewWithHandlers<UnitSetupUiHandlers> implements IsUnitSetupView, ClickHandler{


	private static UnitSetupViewUiBinder uiBinder = GWT.create(UnitSetupViewUiBinder.class);

	interface UnitSetupViewUiBinder extends UiBinder<Widget, UnitSetupView> {
		
	}
	
	private static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	@UiField PPanel subHeading;
	@UiField VerticalPanel unitAssignmentWidgetContainer;
	
	@UiField Anchor classSetupAnchor,unitDetailsAnchor;
	
	@UiField HTMLEventPanel paginationPanel;
	
	@UiField HTMLPanel clearfix,loadingImageLabel;
	
	ClasspageListDo classpageListDo;
	
	private static final String NEXT = i18n.GL1463().toUpperCase();
	
	private static final String PREVIOUS = i18n.GL1462().toUpperCase();
	
	private UnitsAssignmentWidgetView unitsAssignmentWidgetView;
	
	private int totalCount = 0;
	private int limit = 5;
	private int offSet = 0;
	int pageNumber = 0;
	
	@Inject
	public UnitSetupView(){
		setWidget(uiBinder.createAndBindUi(this));	
		classSetupAnchor.addClickHandler(new ClassSetupEvents());
		unitDetailsAnchor.addClickHandler(new UnitDetailsEvent());
		setIdAndText();
	}

	private void setIdAndText() {
		subHeading.getElement().setInnerText(i18n.GL2217());
		clearfix.getElement().getStyle().setBackgroundColor("#fafafa");
		clearfix.getElement().getStyle().setWidth(100, Unit.PCT);
	}
	private class UnitDetailsEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			String classpageid=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
			AppClientFactory.getInjector().getClasspageService().v2GetPathwaysOptimized(classpageid, "1", "0", new SimpleAsyncCallback<ClassDo>() {
				@Override
				public void onSuccess(ClassDo classDo) {
					if(classDo!=null&&classDo.getSearchResults().size()>0){
						revealPlace("unitdetails",classDo.getSearchResults().get(0).getResource().getGooruOid());
					}
				}
			});
		}
	}
	
	 private class ClassSetupEvents implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			revealPlace(null,null);
		}
	}
	 
	 public void revealPlace(String tabName,String unitId){
			Map<String,String> params = new HashMap<String,String>();
			String pageSize=AppClientFactory.getPlaceManager().getRequestParameter("pageSize", null);
			String classpageid=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
			String pageNum=AppClientFactory.getPlaceManager().getRequestParameter("pageNum", null);
			String pos=AppClientFactory.getPlaceManager().getRequestParameter("pos", null);
			params.put("pageSize", pageSize);
			params.put("classpageid", classpageid);
			if(unitId!=null){
				params.put("uid", unitId);
			}
			params.put("pageNum", pageNum);
			params.put("pos", pos);
			if(tabName!=null){
				params.put("tab", tabName);
			}
			PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.EDIT_CLASSPAGE, params);
			AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
	 }

	@Override
	public void showUnitDetails(ClassDo classDo) {
		setLoadingIcon(false);
		if (classDo.getTotalHitCount() != null) {
			totalCount = classDo.getTotalHitCount();
		}
		int unitSize = 0;
		if (classDo.getSearchResults() != null) {
			unitSize = classDo.getSearchResults().size();
		}
		unitAssignmentWidgetContainer.clear();
		for (int i = 0; i < unitSize; i++) {
			ClassUnitsListDo classListUnitsListDo = classDo.getSearchResults().get(i);
			String pageNumVal=AppClientFactory.getPlaceManager().getRequestParameter("pageNum", null);
			int pageIntVal = 0;
			if(pageNumVal != null){
				pageIntVal = Integer.parseInt(pageNumVal);
				if(pageIntVal!=0){
					pageIntVal = pageIntVal-1;
				}
			}
			int sequenceNum = unitAssignmentWidgetContainer.getWidgetCount();
			sequenceNum = (pageIntVal * 5)+sequenceNum;
			sequenceNum = sequenceNum + 1;
			unitsAssignmentWidgetView = new UnitsAssignmentWidgetView(sequenceNum,classListUnitsListDo);
//			unitsAssignmentWidgetView.setClassDo(classDo);
			if (classListUnitsListDo.getResource().getItemCount() != null) {
				unitsAssignmentWidgetView.setTotalHitCount(classListUnitsListDo.getResource().getItemCount());
			} else {
				unitsAssignmentWidgetView.setTotalHitCount(0);
			}
			unitsAssignmentWidgetView.setAssignmentsForUnit();
			unitsAssignmentWidgetView.getAddAssignmentButton().addClickHandler(new AddAssignmentToUnit(classListUnitsListDo));
			unitsAssignmentWidgetView.setPathwayId(classListUnitsListDo.getResource().getGooruOid());
			unitAssignmentWidgetContainer.add(unitsAssignmentWidgetView);
		}

	}
	
	public void clearUnitAssignmentWidgetContaner(){
		 unitAssignmentWidgetContainer.clear();
		 paginationPanel.getElement().setInnerHTML("");
		 classpageListDo=null;
	}
	public class AddAssignmentToUnit implements ClickHandler{
		ClassUnitsListDo classListUnitsListDo;
		
		public AddAssignmentToUnit(ClassUnitsListDo classListUnitsListDo){
			this.classListUnitsListDo = classListUnitsListDo;
		}

		@Override
		public void onClick(ClickEvent event) {
			String classPageId= AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
			getUiHandlers().addAssignmentToPathway(classPageId,classListUnitsListDo.getResource().getGooruOid(),"unitSetupMode",classListUnitsListDo.getResource().getTitle());
		}
		
	}

	@Override
	public void setPagination(int totalCount, int pagenumVal) {
		this.totalCount = totalCount;
		paginationPanel.getElement().setInnerHTML("");
		int totalPages = (totalCount / 5)
				+ ((totalCount % 5) > 0 ? 1 : 0);
		if (totalPages > 1) {
			if (pagenumVal > 1) {
				paginationPanel.add(new PaginationButtonUc(pagenumVal - 1, PREVIOUS, this));
				//paginationPanel.add(new PaginationButtonUc(pagenumVal - 1, PREVIOUS, this));
			}
		
			int page = pagenumVal < 5 ? 1 : pagenumVal - 3;
			
			for (int count = 1; count < 5 && page <= totalPages; page++, ++count) 
			{
				paginationPanel.add(new PaginationButtonUc(page, page == pagenumVal, this));
			}
			if (pagenumVal < totalPages) {
				paginationPanel.add(new PaginationButtonUc(pagenumVal + 1, NEXT, this));
			}
		}
	}
	@Override
	public void onClick(ClickEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() instanceof PaginationButtonUc) {
			int pagenumber = ((PaginationButtonUc) event.getSource()).getPage();
			pageNumber = pagenumber;
			Map<String,String> params = new HashMap<String,String>();
			String pageSize=AppClientFactory.getPlaceManager().getRequestParameter("pageSize", null);
			String classpageid=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
			String pageNum=AppClientFactory.getPlaceManager().getRequestParameter("pageNum", null);
			String pos=AppClientFactory.getPlaceManager().getRequestParameter("pos", null);
			String tab=AppClientFactory.getPlaceManager().getRequestParameter("tab", null);
			params.put("pageSize", pageSize);
			params.put("classpageid", classpageid);
			params.put("tab", tab);
			params.put("pageNum", pageNumber+"");
			params.put("pos", pos);
			PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.EDIT_CLASSPAGE, params);
			AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
			getUiHandlers().getPathwayCompleteDetails(limit,(pagenumber-1)*limit);
		}
	}

	@Override
	public void addAssignmentWidget(ArrayList<ClasspageItemDo> classpageItemDo, String pathwayId) {
		getPathwayWidgetToAddAssignment(pathwayId,classpageItemDo);
	}

	private void getPathwayWidgetToAddAssignment(String pathwayId, ArrayList<ClasspageItemDo> classpageItemDo) {  
		Iterator<Widget> pathWayWidget = unitAssignmentWidgetContainer.iterator();
		while(pathWayWidget.hasNext()){
			Widget widget = pathWayWidget.next();
			if(widget instanceof UnitsAssignmentWidgetView){
				if(((UnitsAssignmentWidgetView) widget).getPathwayId().equals(pathwayId)){
					((UnitsAssignmentWidgetView) widget).addAssignment(classpageItemDo);
				}
			}
		}
	}

	@Override
	public void setLoadingIcon(boolean isVisible) {
		loadingImageLabel.setVisible(isVisible);
	}

	@Override
	public void refreshPathwayItems(String classpageId, String pathwayId) {
		if(unitsAssignmentWidgetView!=null){
			getPathwayWidgetToRefresh(classpageId,pathwayId);
		}
	}

	private void getPathwayWidgetToRefresh(String classpageId, String pathwayId) { 
		Iterator<Widget> pathWayWidget = unitAssignmentWidgetContainer.iterator();
		while(pathWayWidget.hasNext()){
			Widget widget = pathWayWidget.next();
			if(widget instanceof UnitsAssignmentWidgetView){
				if(((UnitsAssignmentWidgetView) widget).getPathwayId().equals(pathwayId)){
					((UnitsAssignmentWidgetView) widget).setLoadingIcon(true);
					refreshPathway(classpageId,pathwayId,((UnitsAssignmentWidgetView) widget));
				}
			}
		}
	}

	private void refreshPathway(String classpageId, String pathwayId,final UnitsAssignmentWidgetView unitsAssignmentWidgetView){ 
		AppClientFactory.getInjector().getClasspageService().v2GetPathwayItems(classpageId, pathwayId, "sequence", 10, 0, new SimpleAsyncCallback<UnitAssignmentsDo>() {

			@Override
			public void onSuccess(UnitAssignmentsDo result) {
				unitsAssignmentWidgetView.setTotalHitCount(result.getTotalHitCount());
				unitsAssignmentWidgetView.getClassUnitsDo().getResource().setCollectionItems(new ArrayList<ClasspageItemDo>()); 
				unitsAssignmentWidgetView.getClassUnitsDo().getResource().setCollectionItems(result.getSearchResults());
				if(unitsAssignmentWidgetView.isEditMode()){
					unitsAssignmentWidgetView.setAssignmentsEditView();
				}else{
					unitsAssignmentWidgetView.setAssignmentsForUnit(); 
				}
			}
		});
	}
	 
	 
	
}
