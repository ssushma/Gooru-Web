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
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections.CollectionsView;
import org.ednovo.gooru.client.mvp.shelf.ShelfUiHandlers;
import org.ednovo.gooru.client.uc.PPanel;
import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
public class ClassSetupView extends BaseViewWithHandlers<ClassSetupUiHandlers> implements IsClassSetupView{

	@UiField VerticalPanel unitwidget;
	@UiField Button addUnitBtn;
	@UiField PPanel unitSetupContainer;
	@UiField Label unitSetupButton;
	
	private HandlerRegistration addUnitClickHandler;
	
	private static ClassSetupViewUiBinder uiBinder = GWT.create(ClassSetupViewUiBinder.class);

	interface ClassSetupViewUiBinder extends UiBinder<Widget, ClassSetupView> {
		
	}
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);

	@Inject
	public ClassSetupView(){
		setWidget(uiBinder.createAndBindUi(this));		
		
		if(addUnitClickHandler!=null) {
			addUnitClickHandler.removeHandler();
		}
		addUnitClickHandler=addUnitBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
			getUiHandlers().createPathway("Unitname");
				
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
	public void setContent(String unitName, String pathwayId) {
	//Window.alert("getUnitwidget().getWidgetCount()::"+getUnitwidget().getWidgetCount());
		 final ClassSetupUnitView classSetupUnitView = new ClassSetupUnitView(getUnitwidget().getWidgetCount(),unitName,pathwayId) {
			
			@Override
			public void deleteItem(int sequenceNum, String pathwayId) {
				try{
					getUiHandlers().deletePathway(pathwayId);
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
		classSetupUnitView.btnAssignment.addClickHandler(new ShowAssignPopupEvent(pathwayId));
		classSetupUnitView.btnReorder.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				classSetupUnitView.moveAssignmentPopup.setVisible(true);
				System.out.println("getUnitwidget().getWidgetCount()::::::"+getUnitwidget().getWidgetCount());
				
				/*for(int i=0; i<getUnitwidget().getWidgetCount(); i++){
					classSetupUnitView.resourceTypePanel.add(classSetupUnitView.createLabel(""+(i+1)));
				}*/
			}
		});
		//classSetupUnitView.btnReorder.addClickHandler(new ShowReorderPathwaysEvent());
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
	
	
	
}
