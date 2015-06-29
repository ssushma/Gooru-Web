
/**
 * 
*/
package org.ednovo.gooru.client.mvp.classpage.teach;

import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.client.uc.H2Panel;
import org.ednovo.gooru.client.uc.SpanPanel;
import org.ednovo.gooru.client.ui.HTMLEventPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;


/**
 * @fileName : TeachClassView.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 26-Jun-2015
 *
 * @Author tumbalam
 *
 * @Reviewer: 
 */
public class TeachClassView extends BaseViewWithHandlers<TeachClassViewUiHandlers> implements IsTeachClassView {

	
	@UiField HTMLPanel startContainer;
	
	@UiField SimplePanel bodyMenu;
	
	@UiField H2Panel titlePanel;
	
	@UiField InlineLabel settingsLbl,contentLbl,studentLbl;
	
	@UiField HTMLEventPanel classSettingsAnr,studentAnr,classContent;
	
	@UiField SpanPanel classCodePanel;
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	private static TeachClassViewUiBinder uiBinder = GWT.create(TeachClassViewUiBinder.class);

	interface TeachClassViewUiBinder extends UiBinder<Widget, TeachClassView> {
	}

	
	public TeachClassView() {
		setWidget(uiBinder.createAndBindUi(this));
		setIds();
	}


	/**
	 * @function setIds 
	 * 
	 * @created_date : 26-Jun-2015
	 * 
	 * @description
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 * 
	*/
	
	private void setIds() {
		startContainer.getElement().setId("getStartedContainer");
		
		studentLbl.getElement().setId("studentLblId");
		studentLbl.setText(i18n.GL3343() +"(0)");
		studentLbl.getElement().setAttribute("alt",i18n.GL3343());
		studentLbl.getElement().setAttribute("title",i18n.GL3343());
		
		settingsLbl.getElement().setId("settingsLblId");
		settingsLbl.setText(i18n.GL3344());
		settingsLbl.getElement().setAttribute("alt",i18n.GL3344());
		settingsLbl.getElement().setAttribute("title",i18n.GL3344());
		
		contentLbl.getElement().setId("contentLblId");
		contentLbl.setText(i18n.GL3345());
		contentLbl.getElement().setAttribute("alt",i18n.GL3345());
		contentLbl.getElement().setAttribute("title",i18n.GL3345());
		
		classCodePanel.setText("XYPRSZ");
		
		//startContainer.getElement().setAttribute("alt","startContainer);
		//startContainer.getElement().setAttribute("title",i18n.GL0747());
		titlePanel.setText("My First Class");
	}
	
	@Override
	public void setInSlot(Object slot, Widget content) {
		super.setInSlot(slot, content);
		if (slot == TeachClassViewUiHandlers.SLOT_BODYMENU) {
			bodyMenu.setWidget(content);
		}
	}


	

}
