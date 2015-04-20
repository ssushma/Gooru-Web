package org.ednovo.gooru.client.mvp.search.util;

import java.util.List;
import java.util.Map;

import org.ednovo.gooru.shared.i18n.MessageProperties;

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
	
	private static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	@UiField HTMLPanel pnlNoSearchResults,libraryWidgetsContainer;
	
	private NoSearchResultWidget() {
		initWidget(uiBinder.createAndBindUi(this));
		pnlNoSearchResults.getElement().setId("pnlNoSearchResults");
		for (Map.Entry<String,List<String>> entry : LibraryImagesMap.getInstance().getLibraryMap().entrySet()){
		   libraryWidgetsContainer.add(new NoResultsLibraryWidget(entry.getValue().get(0),entry.getValue().get(1)));
		}
	}
	public static NoSearchResultWidget getInstance(){
		return searchResult;
	}
}
