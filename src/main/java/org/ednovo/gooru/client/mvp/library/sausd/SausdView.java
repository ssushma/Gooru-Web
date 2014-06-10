package org.ednovo.gooru.client.mvp.library.sausd;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.home.library.LibraryView;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
` * 
 */
public class SausdView extends BaseViewWithHandlers<SausdUiHandlers> implements IsSausdView, MessageProperties {

	@UiField HTMLPanel rusdPanel;
	
	LibraryView libraryView = null;
	
	
	private static RusdViewUiBinder uiBinder = GWT.create(RusdViewUiBinder.class);

	interface RusdViewUiBinder extends UiBinder<Widget, SausdView> {
	}

	/**
	 * Class constructor
	 */
	public SausdView() {		
		setWidget(uiBinder.createAndBindUi(this));
		libraryView = new LibraryView(PlaceTokens.SAUSD_LIBRARY);
		rusdPanel.add(libraryView);
	}

	@Override
	public void loadFeaturedContributors(String callBack, String placeToken) {
		libraryView.loadContributorsPage(callBack,placeToken);
	}
}
