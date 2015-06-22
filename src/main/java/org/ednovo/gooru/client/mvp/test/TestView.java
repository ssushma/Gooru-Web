/**
 *
 */
package org.ednovo.gooru.client.mvp.test;

import java.util.Map;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.SimpleRunAsyncCallback;
import org.ednovo.gooru.client.mvp.home.ResetPasswordVc;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.SimplePanel;
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

	@UiField SimplePanel panelBannerImage, panelPreSearch;


	@Inject
	public TestView() {
		setWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void onClick(ClickEvent event) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void setInSlot(Object slot, Widget content) {
		if (slot  == TestPresenter.BANNER_SLOT){
			panelBannerImage.add(content);
		}else if (slot == TestPresenter.PRESEARCH_SLOT){
			panelPreSearch.add(content);
		}
	}

	@Override
	public void resetPassword(final String resetToken) {
		new ResetPasswordVc(resetToken);
	}

	/* UI Handlers */

}

