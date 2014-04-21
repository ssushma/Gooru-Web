package org.ednovo.gooru.client.mvp.library.rusd;

import org.ednovo.gooru.client.AppPlaceKeeper;
import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BasePlacePresenter;
import org.ednovo.gooru.client.mvp.home.register.UserRegistrationPresenter;

import com.google.inject.Inject;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class RusdPresenter extends BasePlacePresenter<IsRusdView, RusdPresenter.IsRusdProxy> implements RusdUiHandlers {

	private static final String LIBRARY_PAGE = "page";
	
	private int rusdLoader = 1;
	
	@ProxyCodeSplit
	@NameToken(PlaceTokens.RUSD_LIBRARY)
	@UseGatekeeper(AppPlaceKeeper.class)
	public interface IsRusdProxy extends ProxyPlace<RusdPresenter> {
	}

	/**
	 * Class constructor
	 * @param userRegistrationPresenter instance of {@link UserRegistrationPresenter}
	 * @param view {@link View}
	 * @param proxy {@link Proxy}
	 */
	@Inject
	public RusdPresenter(IsRusdView view, IsRusdProxy proxy) {
		super(view, proxy);
		getView().setUiHandlers(this);
	}
	
	@Override
	public void onBind() {
		super.onBind();
	}
	
	@Override
	public void onReveal() {
		super.onReveal();
	}
	
	@Override
	public void onReset() {
		super.onReset();
	}
	
	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		if(AppClientFactory.getLoggedInUser()!=null) {
			getIntoLibrarypage();
		} else {
			AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.ERROR);
		}
	}
	
	/**
	 * 
	 * @function getIntoLibrarypage 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private void getIntoLibrarypage() {
		if (getPlaceManager().getRequestParameter(LIBRARY_PAGE) != null && getPlaceManager().getRequestParameter(LIBRARY_PAGE).equalsIgnoreCase("featured-contributors")) {
			getView().loadFeaturedContributors("featured-contributors",getViewToken());
		} else if (getPlaceManager().getRequestParameter(LIBRARY_PAGE) != null && getPlaceManager().getRequestParameter(LIBRARY_PAGE).equalsIgnoreCase("course-page")) {
			getView().loadFeaturedContributors("course-page",getViewToken());
		} else if (getPlaceManager().getRequestParameter(LIBRARY_PAGE) != null && getPlaceManager().getRequestParameter(LIBRARY_PAGE).equalsIgnoreCase("featured-course")) {
			getView().loadFeaturedContributors("featured-course",getViewToken());
		} else if (getPlaceManager().getRequestParameter(LIBRARY_PAGE) == null) {
			getView().loadFeaturedContributors("featured-course",getViewToken());
		}
	}

	@Override
	public String getViewToken() {
		return PlaceTokens.RUSD_LIBRARY;
	}

}