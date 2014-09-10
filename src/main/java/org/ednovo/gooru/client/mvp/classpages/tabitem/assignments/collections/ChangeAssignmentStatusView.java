package org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections;

import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
public class ChangeAssignmentStatusView extends Composite{
	
	HTMLPanel htmlPanel=null;
	private static ChangeAssignmentStatusUiBinder uiBinder = GWT.create(ChangeAssignmentStatusUiBinder.class);
	
	MessageProperties i18n = GWT.create(MessageProperties.class);
	
	public interface ChangeAssignmentStatusUiBinder extends UiBinder<Widget, ChangeAssignmentStatusView> {}
	
	public ChangeAssignmentStatusView(){
		initWidget(uiBinder.createAndBindUi(this));
	}
	
}
