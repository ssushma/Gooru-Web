package org.ednovo.gooru.client.mvp.landingpage;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.home.library.LibraryView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
` * 
 */
public class LandingPageView extends BaseViewWithHandlers<LandingPageUiHandlers> implements IsLandingPageView {

	@UiField HTMLPanel landingpagePanel;
	
	LibraryView libraryView = null;
	
	
	private static LandingPageViewUiBinder uiBinder = GWT.create(LandingPageViewUiBinder.class);

	interface LandingPageViewUiBinder extends UiBinder<Widget, LandingPageView> {
	}

	/**
	 * Class constructor
	 */
	public LandingPageView() {		
		setWidget(uiBinder.createAndBindUi(this));
		libraryView = new LibraryView(PlaceTokens.COMMUNITY);
		libraryView.getCourseTabs().setVisible(false);
		landingpagePanel.add(libraryView);
		landingpagePanel.getElement().setId("pnlPartnerPanel");
	}

	@Override
	public void loadFeaturedContributors(String callBack, String placeToken) {
		libraryView.loadContributorsPage(callBack,placeToken);
	}
}
