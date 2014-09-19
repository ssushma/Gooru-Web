package org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections;

import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.Widget;
public class ChangeAssignmentStatusView extends Composite{
	
	@UiField SimpleCheckBox changeAssignmentStatusButton;
	
	@UiField InlineLabel requiredLabel,optionalLabel,sequenceNumberLabel;
	
	@UiField HTMLPanel switchContainer;
	
	private static ChangeAssignmentStatusUiBinder uiBinder = GWT.create(ChangeAssignmentStatusUiBinder.class);
	
	MessageProperties i18n = GWT.create(MessageProperties.class);
	
	public interface ChangeAssignmentStatusUiBinder extends UiBinder<Widget, ChangeAssignmentStatusView> {}
	
	public ChangeAssignmentStatusView(){
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public void setLabelDisplayOption(boolean stauts){
		requiredLabel.removeFromParent();
		optionalLabel.removeFromParent();
	}
	public SimpleCheckBox getChangeAssignmentStatusButton(){
		return changeAssignmentStatusButton;
	}
	
	public void setSequenceNumber(int sequenceNumber){
		sequenceNumberLabel.setText(""+sequenceNumber);
	}
	
	public void setSwitchStyleName(String styleName){
		switchContainer.setStyleName(styleName);
	}
	public void changeLabelStyle(String enableStyle,String disableStyle){
		if(changeAssignmentStatusButton.getValue()){
			requiredLabel.setStyleName(enableStyle);
			optionalLabel.setStyleName(disableStyle);
		}else{
			requiredLabel.setStyleName(disableStyle);
			optionalLabel.setStyleName(enableStyle);
		}
	}
}
