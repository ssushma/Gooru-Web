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
package org.ednovo.gooru.client.mvp.classpages.classsetup;
import java.util.HashMap;
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

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
public class ClassSetupView extends BaseViewWithHandlers<ClassSetupUiHandlers> implements IsClassSetupView, ClickHandler{

	@UiField VerticalPanel unitwidget;
	@UiField Button addUnitBtn;
	@UiField PPanel unitSetupContainer;
	@UiField Label unitSetupButton;
	@UiField HTMLEventPanel paginationPanel;
	@UiField HTMLPanel unitSetupLabel,loadingImageLabel;
	

	private HandlerRegistration addUnitClickHandler;
	
	private static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	private static final String PREVIOUS = i18n.GL1462().toUpperCase();

	private static final String NEXT = i18n.GL1463().toUpperCase();
	
	int pageNumber = 0;
	
	int limit = 5;
	
	int totalHitCounter = 0;
	
	private static ClassSetupViewUiBinder uiBinder = GWT.create(ClassSetupViewUiBinder.class);

	interface ClassSetupViewUiBinder extends UiBinder<Widget, ClassSetupView> {
		
	}
	


	@Inject
	public ClassSetupView(){
		setWidget(uiBinder.createAndBindUi(this));		
		
		paginationPanel.setVisible(false);
		unitSetupContainer.setVisible(false);
		unitSetupLabel.getElement().getStyle().setWidth(99, Unit.PCT);
		loadingImageLabel.setVisible(false);
		if(addUnitClickHandler!=null) {
			addUnitClickHandler.removeHandler();
		}
		addUnitClickHandler=addUnitBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addUnitBtn.setEnabled(false);
				
				unitSetupContainer.setVisible(true);

				String pageNumVal=AppClientFactory.getPlaceManager().getRequestParameter("pageNum", null);
				int pageIntVal = 0;
				if(pageNumVal != null)
				{
					pageIntVal = Integer.parseInt(pageNumVal);
					pageIntVal = pageIntVal-1;
				}
	
				getUiHandlers().createPathway("Unitname",(pageIntVal)*limit);
			}
		});
		
		unitSetupButton.addClickHandler(new UnitSetupEvent());
	}

	public VerticalPanel getUnitwidget() {
		return unitwidget;
	}

	public void setUnitwidget(VerticalPanel unitwidget) {
		this.unitwidget = unitwidget;
	}
	
	@Override
	public void clearPanel() {
		getUnitwidget().clear();
	}
	
	@Override

	public void setContent(String unitName, String pathwayId, String collectionItemid) {
		
		unitSetupContainer.setVisible(true);
		String pageNumVal=AppClientFactory.getPlaceManager().getRequestParameter("pageNum", null);
		int pageIntVal = 0;
		if(pageNumVal != null)
		{
			pageIntVal = Integer.parseInt(pageNumVal);
			if(pageIntVal!=0)
			{
			pageIntVal = pageIntVal-1;
			}
		}
		int sequenceNum = getUnitwidget().getWidgetCount();
		sequenceNum = (pageIntVal * 5)+sequenceNum;
		sequenceNum = sequenceNum + 1;
		 ClassSetupUnitView classSetupUnitView = new ClassSetupUnitView(sequenceNum,unitName,pathwayId,totalHitCounter,collectionItemid) {
			@Override
			public void deleteItem(int sequenceNum, final String pathwayId) {
				try{
					
					String pageNumVal=AppClientFactory.getPlaceManager().getRequestParameter("pageNum", null);
					int pageIntVal = 0;
					if(pageNumVal != null)
					{
						pageIntVal = Integer.parseInt(pageNumVal);
						pageIntVal = pageIntVal-1;
					}
					getUiHandlers().deletePathway(pathwayId,(pageIntVal)*limit);
					getUnitwidget().remove(getUnitwidget().getWidgetIndex(this));
					
					
				
					
				}
				catch(Exception ex){
				}
			}
			@Override
			public void saveItem(String pathwayTitle, String pathwayId) {
				getUiHandlers().updatePathway(pathwayId, pathwayTitle);
			}
		};
		 getUnitwidget().add(classSetupUnitView);
	}
	
	private class UnitSetupEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			Map<String,String> params = new HashMap<String,String>();
			String pageSize=AppClientFactory.getPlaceManager().getRequestParameter("pageSize", null);
			String classpageid=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
			String pageNum=AppClientFactory.getPlaceManager().getRequestParameter("pageNum", null);
			String pos=AppClientFactory.getPlaceManager().getRequestParameter("pos", null);
			params.put("pageSize", pageSize);
			params.put("classpageid", classpageid);
			params.put("pageNum", pageNum);
			params.put("pos", pos);
			params.put("tab", "unitsetup");
			PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.EDIT_CLASSPAGE, params);
			AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
		}
	}
	
	 private class ShowAssignPopupEvent implements ClickHandler{

		 String pathwayIdVal = "";
		 public ShowAssignPopupEvent(String pathwayId) {
			 pathwayIdVal = pathwayId;
			// TODO Auto-generated constructor stub
		}

		@Override
		 public void onClick(ClickEvent event) {
			if(!pathwayIdVal.isEmpty())
			{
				getUiHandlers().addAssignmentsContainerPopup(pathwayIdVal);
			}
		 }
	 }
	 
		@Override
		public void setPagination(int totalCount, int pagenumVal) {
			totalHitCounter = totalCount;
			paginationPanel.getElement().setInnerHTML("");
			paginationPanel.setVisible(true);
			if(totalCount>5)
			{
			int totalPages = (totalCount / 5)
					+ ((totalCount % 5) > 0 ? 1 : 0);
			if (totalPages > 1) {
				if (pagenumVal > 1) {
					paginationPanel.add(new PaginationButtonUc(pagenumVal - 1, PREVIOUS, this));
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
			
		}


		@Override
		public void onClick(ClickEvent event) {
			clearPanel();
			if (event.getSource() instanceof PaginationButtonUc) {
				int pagenumber = ((PaginationButtonUc) event.getSource()).getPage();
				pageNumber = pagenumber;
				Map<String,String> params = new HashMap<String,String>();
				String pageSize=AppClientFactory.getPlaceManager().getRequestParameter("pageSize", null);
				String classpageid=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
				String pageNum=AppClientFactory.getPlaceManager().getRequestParameter("pageNum", null);
				String pos=AppClientFactory.getPlaceManager().getRequestParameter("pos", null);
				params.put("pageSize", pageSize);
				params.put("classpageid", classpageid);
				params.put("pageNum", pageNumber+"");
				params.put("pos", pos);
				PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.EDIT_CLASSPAGE, params);
				AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
				getUiHandlers().getPaginatedPathways((pagenumber-1)*limit);
			}

		}

		@Override
		public void zeroResults() {
			
			paginationPanel.setVisible(false);
			unitSetupContainer.setVisible(false);
			
		}
		
		@Override
		public void setLoadingIcon(boolean isVisible) {
			if(!isVisible)
			{
				addUnitBtn.setEnabled(true);
			}
			loadingImageLabel.setVisible(isVisible);
		}
		
		@Override
		public void clearPaginationPanel() {
			paginationPanel.setVisible(false);
		}

		
	
	
}
