package org.ednovo.gooru.client.mvp.analytics;

import java.util.Iterator;

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.classpages.unitdetails.UnitWidget;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class AnalyticsView extends BaseViewWithHandlers<AnalyticsUiHandlers> implements IsAnalyticsView {

	private static AnalyticsViewUiBinder uiBinder = GWT
			.create(AnalyticsViewUiBinder.class);

	interface AnalyticsViewUiBinder extends UiBinder<Widget, AnalyticsView> {
	}

	AnalyticsCssBundle res;
	
	@UiField VerticalPanel unitPanel;
	
	@UiField Label lblMoreUnits;
	
	@UiField HTMLPanel graphWidget,slotWidget;
	
	@UiField Button btnCollectionSummary,btnCollectionProgress;
	
	@UiField ListBox loadCollections;
	
	ClasspageListDo classpageListDo;
	
	boolean isSummayClicked=false,isProgressClicked=false;
	
	final String SUMMARY="Summary",PROGRESS="Progress";
	
	private int limit = 5;
	private int offSet = 0;
	
	public AnalyticsView() {
		this.res = AnalyticsCssBundle.INSTANCE;
		res.unitAssignment().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));	
		graphWidget.add(new HCBarChart().createLineChart());
		btnCollectionSummary.addClickHandler(new ViewAssignmentClickEvent("Summary"));
		btnCollectionProgress.addClickHandler(new ViewAssignmentClickEvent("Progress"));
	}

	@Override
	public void showUnitNames(ClasspageListDo classpageListDo) {
		this.classpageListDo=classpageListDo;
		for(int i=0; i<limit; i++){
					String unitName=classpageListDo.getSearchResults().get(i).getResource().getTitle();
					int number=classpageListDo.getSearchResults().get(i).getItemSequence();
					String sequenceNumber=Integer.toString(number);
					UnitWidget unitsWidget=new UnitWidget(sequenceNumber, unitName);
					unitsWidget.addClickHandler(new UnitChangeEvent(unitsWidget));
					unitsWidget.getElement().setId(sequenceNumber);
					unitPanel.add(unitsWidget);
		}
	}
	public class UnitChangeEvent implements ClickHandler{
		private UnitWidget unitsWidget;
		public UnitChangeEvent(UnitWidget unitsWidget){
			this.unitsWidget=unitsWidget;
		}
		@Override
		public void onClick(ClickEvent event) {
			removeUnitSelectedStyle();
			addUnitSelectStyle(unitsWidget);
		}
	}
	public class ViewAssignmentClickEvent implements ClickHandler{
		private String clicked;
		public ViewAssignmentClickEvent(String clicked){
			this.clicked=clicked;
		}
		@Override
		public void onClick(ClickEvent event) {
			if(clicked.equalsIgnoreCase(PROGRESS)){
				isSummayClicked=false;
				if(isProgressClicked){
					isProgressClicked=false;
					getUiHandlers().setClickedTabPresenter(null);
				}else{
					isProgressClicked=true;
					getUiHandlers().setClickedTabPresenter(PROGRESS);
				}
			}else if(clicked.equalsIgnoreCase(SUMMARY)){
				isProgressClicked=false;
				if(isSummayClicked){
					isSummayClicked=false;
					getUiHandlers().setClickedTabPresenter(null);
				}else{
					isSummayClicked=true;
					getUiHandlers().setClickedTabPresenter(SUMMARY);
				}
			}else{
				
			}
		}
	}
	public void removeUnitSelectedStyle(){
		Iterator<Widget> widgets = unitPanel.iterator();
		while (widgets.hasNext()) {
			 Widget widget = widgets.next();
			if (widget instanceof UnitWidget) {
				UnitWidget unitsWidget=(UnitWidget)widget;
				unitsWidget.getUnitNameContainer().removeStyleName(res.unitAssignment().unitMenuActive());
			}
		}		
		
	}
	
	public void addUnitSelectStyle(UnitWidget unitsWidget){
		unitsWidget.getUnitNameContainer().addStyleName(res.unitAssignment().unitMenuActive());
	}
	@UiHandler("lblMoreUnits")
	public void clickOnMoreUnits(ClickEvent event){
		offSet=offSet+5;
		getUiHandlers().getPathwayUnits(limit, offSet);
	}
	@Override
	public void hideMoreUnitsLink() {
		
		
	}
	@Override
	public void setInSlot(Object slot, Widget content) {
		slotWidget.clear();
		if (content != null) {
			 if(slot==AnalyticsPresenter.COLLECTION_PROGRESS_SLOT){
				 slotWidget.setVisible(true);
				 slotWidget.add(content);
			}else{
				slotWidget.setVisible(false);
			}
		}else{
			slotWidget.setVisible(false);
		}
	}

}
