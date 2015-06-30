
/**
 * 
*/
package org.ednovo.gooru.client.mvp.classpage.teach.edit;

import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;


/**
 * @fileName : EditClassView.java
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
public class EditClassView extends BaseViewWithHandlers<EditClassViewUiHandlers> implements IsEditClassView {

	private static EditClassViewUiBinder uiBinder = GWT.create(EditClassViewUiBinder.class);

	interface EditClassViewUiBinder extends UiBinder<Widget, EditClassView> {
	}

	public EditClassView() {
		setWidget(uiBinder.createAndBindUi(this));
	}

}
