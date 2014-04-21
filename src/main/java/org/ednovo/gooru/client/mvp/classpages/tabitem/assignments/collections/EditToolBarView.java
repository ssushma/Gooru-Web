package org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections;

import org.ednovo.gooru.client.uc.DateBoxUc;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
public class EditToolBarView extends Composite implements MessageProperties{
	
	@UiField Button saveButton,cancelButton;
	
	@UiField HTMLPanel dueDatePanel,dueDateText;
	
	@UiField Label savingText;
	
	public DateBoxUc dateBoxUc;
	
	private static EditToolBarViewUiBinder uiBinder = GWT.create(EditToolBarViewUiBinder.class);
	public interface EditToolBarViewUiBinder extends UiBinder<Widget, EditToolBarView> {}
	
	public EditToolBarView(boolean isDuedateEdited){
		initWidget(uiBinder.createAndBindUi(this));
		setStaticTexts();
		savingText.setVisible(false);
		if(isDuedateEdited){
			dueDatePanel.clear();
			dateBoxUc = new DateBoxUc(false, false,false);
			dueDatePanel.add(dateBoxUc);
		}
	}
	public void setStaticTexts(){
		cancelButton.setText(GL0142);
		saveButton.setText(GL0141);
		savingText.setText(GL0808);
	}
}
