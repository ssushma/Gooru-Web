/**
 * 
 */
package org.ednovo.gooru.client.mvp.landingpage;

import org.ednovo.gooru.client.gin.IsViewWithHandlers;
import org.ednovo.gooru.client.mvp.home.library.contributors.LibraryContributorsView;

/**
 * @author Search Team
 * 
 */
public interface IsLandingPageView extends IsViewWithHandlers<LandingPageUiHandlers> {
	/**
	 * Load featured contributors {@link LibraryContributorsView}
	 * @param callBack
	 */
	void loadFeaturedContributors(String callBack, String placeToken);

}
