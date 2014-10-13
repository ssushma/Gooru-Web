package org.ednovo.gooru.client.mvp.analytics.unitAssignments;

import java.util.List;

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.classpages.unitdetails.UnitCricleView;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.InsightsUserDataDo;
import org.ednovo.gooru.shared.model.content.UnitAssignmentsDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class AnalyticsUnitAssignmentsView extends BaseViewWithHandlers<AnalyticsUnitAssignmentsUiHandlers> implements IsAnalyticsUnitAssignmentsView{

	private static AnalyticsUnitAssignmentsViewUiBinder uiBinder = GWT
			.create(AnalyticsUnitAssignmentsViewUiBinder.class);

	interface AnalyticsUnitAssignmentsViewUiBinder extends
			UiBinder<Widget, AnalyticsUnitAssignmentsView> {
	}
	private static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	AnalyticsUnitAssignmentsCssBundle res;
	
	@UiField HTMLPanel circleContainerPanel;
	
	private int totalAssignmentHitcount;
	UnitCricleView unitCricleViewObj;
	
	private HandlerRegistration leftHandler;
	private HandlerRegistration rightHandler;
	
	Image leftArrow = new Image();
	Image rightArrow = new Image();
	
	private int assignmentOffset=0;
	private int assignmentLimit=10;
	
	private static final String NEXT=i18n.GL1463();
	private static final String PREVIOUS= i18n.GL1462();
	
	Label requiredText =new Label();
	
	private List<InsightsUserDataDo> insightsUserList;
	
	public AnalyticsUnitAssignmentsView() {
		setWidget(uiBinder.createAndBindUi(this));
		this.res = AnalyticsUnitAssignmentsCssBundle.INSTANCE;
		res.unitAssignment().ensureInjected();
	}

	@Override
	public void setAssignmentsData(UnitAssignmentsDo unitAssignmentsDo,boolean isNextOrPrevious) {
		if(!isNextOrPrevious){
			if(unitAssignmentsDo.getTotalHitCount() != null){
				totalAssignmentHitcount = unitAssignmentsDo.getTotalHitCount();
			}else{
				totalAssignmentHitcount = 0;
			}
			assignmentOffset=0;
		}
		if(unitAssignmentsDo!=null){
			if(unitAssignmentsDo.getSearchResults()!=null){
				if(unitAssignmentsDo.getSearchResults().size()!=0){
					try{
						if(leftHandler!=null) {
							leftHandler.removeHandler();
						}
						if(rightHandler!=null) {
							rightHandler.removeHandler();
						}
					}catch (AssertionError ae) { }
					
					leftHandler=leftArrow.addClickHandler(new cleckOnNext("left"));
					rightHandler=rightArrow.addClickHandler(new cleckOnNext("right"));
					circleContainerPanel.clear();
					circleContainerPanel.add(requiredText);
					leftArrow.setUrl("images/leftSmallarrow.png");
					leftArrow.getElement().setAttribute("style","margin-left: 10px;cursor: pointer;");
					circleContainerPanel.add(leftArrow);
					for(int i=0;i<unitAssignmentsDo.getSearchResults().size();i++){
						if(insightsUserList!=null){
							unitCricleViewObj =new UnitCricleView(unitAssignmentsDo.getSearchResults().get(i),insightsUserList.get(i));
						}else{
							unitCricleViewObj =new UnitCricleView(unitAssignmentsDo.getSearchResults().get(i), null);
						}
						unitCricleViewObj.getElement().setId(unitAssignmentsDo.getSearchResults().get(i).getCollectionItemId());	
						circleContainerPanel.add(unitCricleViewObj);
					}
					rightArrow.setUrl("images/rightSmallarrow.png");
					circleContainerPanel.add(rightArrow);
				}
			}
		}
		if(totalAssignmentHitcount==0){
			Label noAssignmentlabel = new Label(i18n.GL2202());
			circleContainerPanel.clear();
			circleContainerPanel.add(noAssignmentlabel);
		}
		
		showAndHideAssignmentArrows(unitAssignmentsDo);
	}
	public class cleckOnNext implements ClickHandler{
		String value;
		
		private cleckOnNext(String value){
			this.value = value;
		}
		@Override
		public void onClick(ClickEvent event) {
			int offsetValue = 0;
			if(value=="right"){
				offsetValue = getAssignmentOffsetValue(NEXT);
				getUiHandlers().getPathwayItems("sequence",assignmentLimit, offsetValue);
			}else{
				offsetValue = getAssignmentOffsetValue(PREVIOUS);
				getUiHandlers().getPathwayItems("sequence", assignmentLimit, offsetValue);
			}
		}
	}
	private int getAssignmentOffsetValue(String direction) {
		if(direction.equals(NEXT)){
				assignmentOffset = assignmentOffset+assignmentLimit;
			}else{
				assignmentOffset = Math.abs(assignmentOffset-assignmentLimit);
			}
		
		return assignmentOffset;
	}
	private void showAndHideAssignmentArrows(UnitAssignmentsDo unitAssignmentsDo) {
		int totalAssignments=0;
		if(unitAssignmentsDo.getTotalHitCount() != null){
			totalAssignments = unitAssignmentsDo.getTotalHitCount();
		}
		if(Math.abs(totalAssignments-assignmentOffset)>assignmentLimit){
			if(Math.abs(totalAssignments-assignmentOffset)==totalAssignments){
				leftArrow.getElement().getStyle().setVisibility(Visibility.HIDDEN);
				rightArrow.getElement().getStyle().setVisibility(Visibility.VISIBLE);
			}else{
				leftArrow.getElement().getStyle().setVisibility(Visibility.VISIBLE);
				rightArrow.getElement().getStyle().setVisibility(Visibility.VISIBLE);
			}
		}else{
			leftArrow.getElement().getStyle().setVisibility(Visibility.VISIBLE);
			rightArrow.getElement().getStyle().setVisibility(Visibility.HIDDEN);
		}
		if(totalAssignments<=10){
			leftArrow.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			rightArrow.getElement().getStyle().setVisibility(Visibility.HIDDEN);
		}
	}
}
