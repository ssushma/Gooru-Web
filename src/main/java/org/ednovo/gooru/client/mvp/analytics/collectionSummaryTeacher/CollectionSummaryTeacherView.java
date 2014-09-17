package org.ednovo.gooru.client.mvp.analytics.collectionSummaryTeacher;


import java.util.ArrayList;

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.Analytics.util.AnalyticsTabContainer;
import org.ednovo.gooru.client.mvp.Analytics.util.SortTable;
import org.ednovo.gooru.client.mvp.analytics.HCBarChart;
import org.ednovo.gooru.shared.model.analytics.UserDataDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
//newly added 
public class CollectionSummaryTeacherView  extends BaseViewWithHandlers<CollectionSummaryTeacherUiHandlers> implements IsCollectionSummaryTeacherView  {

	private static CollectionSummaryTeacherViewUiBinder uiBinder = GWT
			.create(CollectionSummaryTeacherViewUiBinder.class);

	interface CollectionSummaryTeacherViewUiBinder extends
			UiBinder<Widget, CollectionSummaryTeacherView> {
	}

	@UiField HTMLPanel hiddenChartPnl,tabContainer,teacherScoredData,teacherOpenendedData,teacherResourceBreakdownData;
	
	AnalyticsTabContainer teacherTabContainer;
	
	ArrayList<UserDataDo> questionsData=new ArrayList<UserDataDo>();
	ArrayList<UserDataDo> openendedData=new ArrayList<UserDataDo>();
	ArrayList<UserDataDo> resourceBreakdown=new ArrayList<UserDataDo>();
	
	public CollectionSummaryTeacherView() {
		setWidget(uiBinder.createAndBindUi(this));
		setData();
	}
	void setData(){
		teacherTabContainer=new AnalyticsTabContainer() {
			@Override
			public void onTabClick(String tabClicked) {
				Window.alert(tabClicked);
			}
		};
		tabContainer.add(teacherTabContainer);
	}
	@Override
	public void setTeacherResourceData(ArrayList<UserDataDo> resourcesData) {
	        //This is used for segrate data based on the category
	        for (UserDataDo userDataDo : resourcesData) {
				if(userDataDo.getCategory().equalsIgnoreCase("question")){
					if(userDataDo.getType().equalsIgnoreCase("OE")){
							openendedData.add(userDataDo);
					}else{
						questionsData.add(userDataDo);
					}
				}else{
					resourceBreakdown.add(userDataDo);
				}
	        }
	    	setScoredQuestionsData(questionsData);
	}
	void setScoredQuestionsData(final ArrayList<UserDataDo> scoredQuestionsData){

		teacherScoredData.clear();
		
		FlexTable t=new FlexTable();
		t.setHTML(0, 0, "No.");
		t.setHTML(0, 1, "Widget");
		t.setHTML(0, 2, "name");
		
		t.setHTML(1, 0, "Text");
		t.setWidget(1, 1, new HCBarChart().createPieChart());
		t.setHTML(1, 2, "Text");
		
		t.setHTML(2, 0, "Surya");
		t.setHTML(2, 1,"NO");
		t.setHTML(2, 2, "Text");
		
		t.setHTML(3, 0, "arch");
		t.setWidget(3, 1, new HCBarChart().createPieChart());
		t.setHTML(3, 2, "Text");
		
        final SortTable sortableTable = new SortTable();
        
        sortableTable.setWidth(500 + "px");
        sortableTable.setStyleName("sortable");
        sortableTable.getElement().setId("results");
        sortableTable.setBorderWidth(1);
        sortableTable.setCellPadding(4);
        sortableTable.setCellSpacing(1);

        sortableTable.addColumnHeader("Employee",  0);
        sortableTable.addColumnHeader("Days", 1);
        sortableTable.addColumnHeader("Hire Date", 2);
        sortableTable.addColumnHeader("Bonus", 3);
        
      // The rowIndex should begin with 1 as rowIndex 0 is for the Header
      // Any row with index == 0 will not be displayed.
        sortableTable.setValue(1, 0, "Parvinder Thapar");
        sortableTable.setValue(1, 1, new Integer(28));
        sortableTable.setWidget(1, 2, new HCBarChart().createPieChart());
        sortableTable.setValue(1, 3, new Float("125.27"));

        sortableTable.setValue(2, 0, "David Brooks");
        sortableTable.setValue(2, 1, new Integer(32));
        sortableTable.setWidget(2, 2, new HCBarChart().createPieChart());
        sortableTable.setValue(2, 3, new Float("105.78"));

        sortableTable.setValue(3, 0, "Raj Rajendran");
        sortableTable.setValue(3, 1, new Integer(30));
        sortableTable.setWidget(3, 2, new HCBarChart().createPieChart());
        sortableTable.setValue(3, 3, new Float("236.82"));

        sortableTable.setValue(4, 0, "Brian Foley");
        sortableTable.setValue(4, 1, new Integer(38));
        sortableTable.setValue(4, 3, new Float("489.29"));
        
	    teacherScoredData.add(t);
	    sortTable();
	}
	
	public static native void sortTable() /*-{

	}-*/;
}
