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
		cancelButton.getElement().setId("btnCancel");
		cancelButton.getElement().setAttribute("alt",GL0142);
		cancelButton.getElement().setAttribute("title",GL0142);
		
		saveButton.setText(GL0141);
		saveButton.getElement().setId("btnSave");
		saveButton.getElement().setAttribute("alt",GL0141);
		saveButton.getElement().setAttribute("title",GL0141);
		
		savingText.setText(GL0808);
		savingText.getElement().setId("lblSaving");
		savingText.getElement().setAttribute("alt",GL0808);
		savingText.getElement().setAttribute("title",GL0808);
		dueDatePanel.getElement().setId("pnlDueDatePanel");
		dueDateText.getElement().setId("pnlDueDate");
	}
}
