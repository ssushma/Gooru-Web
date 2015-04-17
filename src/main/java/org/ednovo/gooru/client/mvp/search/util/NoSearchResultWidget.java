package org.ednovo.gooru.client.mvp.search.util;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class NoSearchResultWidget extends Composite {

	private static NoSearchResultWidgetUiBinder uiBinder = GWT
			.create(NoSearchResultWidgetUiBinder.class);

	interface NoSearchResultWidgetUiBinder extends
			UiBinder<Widget, NoSearchResultWidget> {
	}
	final static NoSearchResultWidget searchResult=new NoSearchResultWidget();
	
	@UiField HTMLPanel pnlNoSearchResults;
	
	private NoSearchResultWidget() {
		initWidget(uiBinder.createAndBindUi(this));
		pnlNoSearchResults.getElement().setId("pnlNoSearchResults");
	}
	public static NoSearchResultWidget getInstance(){
		return searchResult;
	}
}
