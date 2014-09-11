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
import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.uc.PPanel;
import org.ednovo.gooru.client.uc.PaginationButtonUc;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
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
	
	@UiField FlowPanel paginationFocPanel;
	
	ClasspageListDo classpageListDo;
	
	private static final String NEXT = i18n.GL1463().toUpperCase();
	
	private int totalCount;
	private int limit = 5;
	private int offSet = 0;
	
	@Inject
	public UnitSetupView(){
		setWidget(uiBinder.createAndBindUi(this));	
		classSetupAnchor.addClickHandler(new ClassSetupEvents());
		unitDetailsAnchor.addClickHandler(new UnitDetailsEvent());
		setIdAndText();
	}

	private void setIdAndText() {
		subHeading.getElement().setInnerText("Setup your units by adding assignments");
		
	}
	private class UnitDetailsEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			revealPlace("unitdetails");
		}
	}
	
	 private class ClassSetupEvents implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			revealPlace(null);
		}
	}
	 public void revealPlace(String tabName){
			Map<String,String> params = new HashMap<String,String>();
			String pageSize=AppClientFactory.getPlaceManager().getRequestParameter("pageSize", null);
			String classpageid=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
			String pageNum=AppClientFactory.getPlaceManager().getRequestParameter("pageNum", null);
			String pos=AppClientFactory.getPlaceManager().getRequestParameter("pos", null);
			params.put("pageSize", pageSize);
			params.put("classpageid", classpageid);
			params.put("pageNum", pageNum);
			params.put("pos", pos);
			if(tabName!=null){
				params.put("tab", tabName);
			}
			PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.EDIT_CLASSPAGE, params);
			AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
	 }

	@Override
	public void showUnitDetails(ClasspageListDo classpageListDo) {
		this.classpageListDo=classpageListDo;
	    totalCount = classpageListDo.getTotalHitCount();
	    int unitSize =classpageListDo.getSearchResults().size() ;
	    System.out.println("totalCount::"+totalCount+"::unitSize::"+unitSize);
	    setPagination();
	    unitAssignmentWidgetContainer.clear();
	    for(int i=0; i<unitSize; i++){
	    	unitAssignmentWidgetContainer.add(new UnitsAssignmentWidgetView(classpageListDo.getSearchResults().get(i))); 
	    }
		
	}

	private void setPagination() {
		
		int page=1;
		int pageCount=totalCount%5;
		System.out.println("pagecount:"+pageCount);
		if(page < pageCount+1){
			for (int count = 1; count < pageCount+1 && page <= pageCount+1; page++, ++count) {
				paginationFocPanel.add(new PaginationButtonUc(page, page == count, this));
			}
		}
	}

	@Override
	public void onClick(ClickEvent event) {
		// TODO Auto-generated method stub
		System.out.println("ininin");
		offSet=offSet+limit;
		getUiHandlers().getPathwayCompleteDetails(limit,offSet);
	}
	 
	 
	
}
