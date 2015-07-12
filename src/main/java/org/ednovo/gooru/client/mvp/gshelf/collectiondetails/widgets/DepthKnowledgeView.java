package org.ednovo.gooru.client.mvp.gshelf.collectiondetails.widgets;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.content.ListValuesDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class DepthKnowledgeView extends Composite {
	
	
	@UiField HTMLPanel detailsContainer,mainContainer;

	Map<String,String> selectedValues=new HashMap<String, String>();
	
	private static DepthKnowledgeViewUiBinder uiBinder = GWT.create(DepthKnowledgeViewUiBinder.class);

	interface DepthKnowledgeViewUiBinder extends UiBinder<Widget, DepthKnowledgeView> {
	}

	static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	
	public DepthKnowledgeView() {
		initWidget(uiBinder.createAndBindUi(this));
		
		mainContainer.getElement().setId("dokwidget");
	}
	public void init(List<ListValuesDo> listValuesDos){
		detailsContainer.clear();
		for(ListValuesDo listValuesDo:listValuesDos){
			CheckBox checkBox=new CheckBox();
			checkBox.getElement().setId(listValuesDo.getId()+"");
			checkBox.setText(listValuesDo.getName());
			checkBox.setStyleName("checkbox-inline");
			detailsContainer.add(checkBox);
		}
	}
	
	public Map<String, String> getSelectedValue(){
	
		int count=detailsContainer.getWidgetCount();
		for(int i=0;i<count;i++){
			Widget widget=detailsContainer.getWidget(i);
			if(widget instanceof CheckBox){
				CheckBox checkBox=(CheckBox)widget;
				if(checkBox.getValue()){
					selectedValues.put(checkBox.getElement().getId(),checkBox.getText());	
				}
				
			}
		
		}
		return selectedValues;
	}
	
	
}
