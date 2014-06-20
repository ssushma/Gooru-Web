package org.ednovo.gooru.client.mvp.library.sausd;

import org.ednovo.gooru.client.AppPlaceKeeper;
import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BasePlacePresenter;
import org.ednovo.gooru.client.service.LibraryServiceAsync;
import org.ednovo.gooru.shared.model.library.ProfileLibraryListDo;

import com.google.inject.Inject;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class SausdPresenter extends BasePlacePresenter<IsSausdView, SausdPresenter.IsSausdProxy> implements SausdUiHandlers {

	@Inject
	private LibraryServiceAsync libraryService;
	
	private SimpleAsyncCallback<ProfileLibraryListDo> profileLibraryListAsyncCallback;
	
	private static final String LIBRARY_PAGE = "page";
	
	@ProxyCodeSplit
	@NameToken(PlaceTokens.SAUSD_LIBRARY)
	@UseGatekeeper(AppPlaceKeeper.class)
	public interface IsSausdProxy extends ProxyPlace<SausdPresenter> {
	}
	
	@Inject
	public SausdPresenter(IsSausdView view, IsSausdProxy proxy) {
		super(view, proxy);
		getView().setUiHandlers(this);
	}
	
	@Override
	public void onBind() {
		super.onBind();
		setProfileLibraryListAsyncCallback(new SimpleAsyncCallback<ProfileLibraryListDo>() {
			@Override
			public void onSuccess(ProfileLibraryListDo profileLibraryListDo) {
				getView().loadFeaturedContributors("featured-course",getViewToken(),profileLibraryListDo);
			}
		});
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
	
	private void getIntoLibrarypage() {
		if (getPlaceManager().getRequestParameter(LIBRARY_PAGE) != null && getPlaceManager().getRequestParameter(LIBRARY_PAGE).equalsIgnoreCase("course-page")) {
			//getView().loadFeaturedContributors("course-page",getViewToken());
		} else if (getPlaceManager().getRequestParameter(LIBRARY_PAGE) != null && getPlaceManager().getRequestParameter(LIBRARY_PAGE).equalsIgnoreCase("featured-course")) {
			getLibraryService().getLibraryWorkspace("sausd", 20, "", "", 0, getProfileLibraryListAsyncCallback());
		} else if (getPlaceManager().getRequestParameter(LIBRARY_PAGE) == null) {
			getLibraryService().getLibraryWorkspace("sausd", 20, "", "", 0, getProfileLibraryListAsyncCallback());
		}
	}
	
	public LibraryServiceAsync getLibraryService() {
		return libraryService;
	}
	
	/**
	 * @return the profileLibraryListAsyncCallback
	 */
	public SimpleAsyncCallback<ProfileLibraryListDo> getProfileLibraryListAsyncCallback() {
		return profileLibraryListAsyncCallback;
	}

	/**
	 * @param profileLibraryListAsyncCallback the profileLibraryListAsyncCallback to set
	 */
	public void setProfileLibraryListAsyncCallback(SimpleAsyncCallback<ProfileLibraryListDo> profileLibraryListAsyncCallback) {
		this.profileLibraryListAsyncCallback = profileLibraryListAsyncCallback;
	}

	@Override
	public String getViewToken() {
		return PlaceTokens.SAUSD_LIBRARY;
	}

}