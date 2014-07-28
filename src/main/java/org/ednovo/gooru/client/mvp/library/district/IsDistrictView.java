/**
 * 
 */
package org.ednovo.gooru.client.mvp.library.district;

import org.ednovo.gooru.client.gin.IsViewWithHandlers;
import org.ednovo.gooru.client.mvp.home.library.contributors.LibraryContributorsView;
import org.ednovo.gooru.shared.model.library.ProfileLibraryListDo;

/**
 * @author Search Team
 * 
 */
public interface IsDistrictView extends IsViewWithHandlers<DistrictUiHandlers> {
	/**
	 * Load featured contributors {@link LibraryContributorsView}
	 * @param callBack
	 */
	void loadFeaturedContributors(String callBack, String placeToken,ProfileLibraryListDo profileLibraryListDo);

}
