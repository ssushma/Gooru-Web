/**
 *
 */
package org.ednovo.gooru.client.mvp.test;

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 *
 * @fileName : TestView.java
 *
 * @description :
 *
 *
 * @version : 1.0
 *
 * @date: 26-May-2015
 *
 * @Author tumbalam
 *
 * @Reviewer:
 */
public class TestView extends
		BaseViewWithHandlers<TestUiHandlers> implements
		IsTestView, ClickHandler{

	private static TextViewUiBinder uiBinder = GWT
			.create(TextViewUiBinder.class);

	interface TextViewUiBinder extends
			UiBinder<Widget, TestView> {

	}

	@Inject
	public TestView() {
		setWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void onClick(ClickEvent event) {
		throw new RuntimeException("Not implemented");
	}
}

