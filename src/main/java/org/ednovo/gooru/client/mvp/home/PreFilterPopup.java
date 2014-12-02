/**
 * 
 */
package org.ednovo.gooru.client.mvp.home;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.CssTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.IsSearchView;
import org.ednovo.gooru.client.mvp.search.event.GetSearchKeyWordEvent;
import org.ednovo.gooru.client.uc.DisclosurePanelUc;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author janamitra
 *
 */
public class PreFilterPopup extends PopupPanel {

	private static PreFilterPopupUiBinder uiBinder = GWT
			.create(PreFilterPopupUiBinder.class);
	
	private static MessageProperties i18n = GWT.create(MessageProperties.class);

	interface PreFilterPopupUiBinder extends UiBinder<Widget, PreFilterPopup> {
	}
	
	@UiField HTMLPanel eleGradePanelUc,middleGradePanelUc,highrGradePanelUc,subjectPanelUc;
	
	CheckBox gradeCheckBox;
	
	private static final String COMMA_SEPARATOR = i18n.GL_GRR_COMMA();
	
	String[] elementaryGrades = new String[]{"pre-k","k","1","2","3"};
	String[] middleGrades = new String[]{"4","5","6","7","8"};
	String[] higherGrades = new String[]{"9","10","11","12","13+"};
	String[] subjects = new String[]{"Science","Math","Social Sciences","Language Arts","Arts & Humanities","Tech & Engineering"};

	/**
	 * Because this class has a default constructor, it can
	 * be used as a binder template. In other words, it can be used in other
	 * *.ui.xml files as follows:
	 * <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
	 *   xmlns:g="urn:import:**user's package**">
	 *  <g:**UserClassName**>Hello!</g:**UserClassName>
	 * </ui:UiBinder>
	 * Note that depending on the widget that is used, it may be necessary to
	 * implement HasHTML instead of HasText.
	 */
	public PreFilterPopup() {
		setWidget(uiBinder.createAndBindUi(this));
		show();
		renderCheckBoxs(eleGradePanelUc, elementaryGrades);
		renderCheckBoxs(middleGradePanelUc, middleGrades);
		renderCheckBoxs(highrGradePanelUc, higherGrades);
		renderCheckBoxs(subjectPanelUc, subjects);
		clearAllFields();
	}

	/**
	 * 
	 */
	private void renderCheckBoxs(HTMLPanel htmlPanel, String[] stringArray) {
		// TODO Auto-generated method stub
		for(int i=0;i<stringArray.length;i++){
			gradeCheckBox= new CheckBox();
			if(stringArray.equals(elementaryGrades)){
				gradeCheckBox.setName("K");
			}
			gradeCheckBox.setName(stringArray[i]);
			gradeCheckBox.setText(stringArray[i]);
			gradeCheckBox.setStyleName(CssTokens.FILTER_CHECKBOX);
			htmlPanel.add(gradeCheckBox);
			gradeCheckBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

				@Override
				public void onValueChange(ValueChangeEvent<Boolean> event) {
					if (gradeCheckBox.getValue()){
							MixpanelUtil.MOS_Filter("Selected");
					}else{
							MixpanelUtil.MOS_Filter("Unselected");
					}
//					AppClientFactory.fireEvent(new GetSearchKeyWordEvent());
				}
			});
			
		}
	}
	
	
	/**
	 * Get search filter such as grade, subject etc..
	 * @return search filter as Map value
	 */
	protected Map<String, String> getFilter() {
		Map<String, String> filterMap = new HashMap<String, String>();
		filterMap.clear();
		String filterGrade = "";
		
		String eleGrade = getSelectedFilter(eleGradePanelUc);
		if (!eleGrade.isEmpty()) {
			eleGrade="K-4";
			filterGrade+=eleGrade;
		}
		String midGrade = getSelectedFilter(middleGradePanelUc);
		System.out.println("selected grade:"+midGrade);
		if (!midGrade.isEmpty()) {
			if(midGrade.contains("4")){
				eleGrade="K-4";
			}else{
				midGrade="5-8";
			}
			if(midGrade.contains("4")&&(midGrade.contains("5") || midGrade.contains("6") || midGrade.contains("7") || midGrade.contains("8"))){
				midGrade="5-8";
			}
			if(filterGrade.equals("")){
				if(eleGrade.isEmpty()){
					filterGrade+=midGrade;
				}else if(midGrade.equals("5-8")){
					filterGrade+=eleGrade+","+midGrade;
				}else{
					filterGrade+=eleGrade;
				}
				
			}else{
				filterGrade+=","+midGrade;
			}
		}
		String highGrade = getSelectedFilter(highrGradePanelUc);
		System.out.println("selected grade:"+highGrade);
		if (!highGrade.isEmpty()) {
			String higher="";
			if(highGrade.contains("13+")){
				higher="H";
			}else{
				highGrade="9-12";
			}
			if(highGrade.contains("13+")&&(highGrade.contains("9") || highGrade.contains("10") || highGrade.contains("11") || highGrade.contains("12"))){
				highGrade="9-12";
			}
			
			if(filterGrade.equals("")){
				if(higher.equals("")){
					filterGrade+=highGrade;
				}else if(highGrade.equals("9-12")){
					filterGrade+=highGrade+","+higher;
				}else{
					filterGrade+=higher;
				}
			}else{
				filterGrade+=","+highGrade;
			}
		}
		if(filterGrade!=null && !filterGrade.equals("")){
			System.out.println("INININ:"+filterGrade);
			filterMap.put(IsSearchView.GRADE_FLT, filterGrade);
		}
		String selectedSubject = getSelectedFilter(subjectPanelUc, "~~");
		System.out.println("selected subjects:"+selectedSubject);
		if (!selectedSubject.isEmpty()) {
			filterMap.put(IsSearchView.SUBJECT_FLT, selectedSubject);
		}
		
		return filterMap;
		
	}
	
	/**
	 * Clear all selected filter values
	 * @param gradePanelUc instance {@link DisclosurePanelUc} which has selected filter values
	 */
	public void clearFilter(HTMLPanel gradePanelUc) {
		
	//	if(resourceSearch){
		for(int i=0;i<gradePanelUc.getWidgetCount();i++){
			Widget filterWidget = gradePanelUc.getWidget(i);
			if (filterWidget instanceof CheckBox) {
				((CheckBox) filterWidget).setValue(false);
			}
		}
	}
	
	/**
	 * @param categoryPanelUc2 instance of {@link DisclosurePanelUc}
	 * @return selected filterHTMLPanelUc name
	 */
	private String getSelectedFilter(HTMLPanel categoryPanelUc2) {
		return getSelectedFilter(categoryPanelUc2, COMMA_SEPARATOR);
	}
	
	/**
	 * Get filters for search
	 * @param categoryPanelUc2 instance of {@link DisclosurePanelUc} which has filters widget
	 * @param separator concatenation of the filters with separator
	 * @return concatenation of selected filters
	 */
	private String getSelectedFilter(HTMLPanel categoryPanelUc2, String separator) {
		String selectedFilter = "";
		for(int i =0;i<categoryPanelUc2.getWidgetCount();i++){
			Widget filterWidget = categoryPanelUc2.getWidget(i);
			if (filterWidget instanceof CheckBox) {
				CheckBox filterCheckBox = (CheckBox) filterWidget;
				if (filterCheckBox != null && filterCheckBox.getValue()) {
					if (!selectedFilter.isEmpty()) {
						selectedFilter += separator;
					}
					selectedFilter += filterCheckBox.getName();
					MixpanelUtil.mixpanelEvent("search_"+selectedFilter+"_filter_selected");
				}
			}
		}
		return selectedFilter;
	}
		
	public void clearAllFields(){
		clearFilter(eleGradePanelUc);
		clearFilter(middleGradePanelUc);
		clearFilter(highrGradePanelUc);
		clearFilter(subjectPanelUc);
	}
	

}
