/*******************************************************************************
 * Copyright 2013 Ednovo d/b/a Gooru. All rights reserved.
 * 
 *  http://www.goorulearning.org/
 * 
 *  Permission is hereby granted, free of charge, to any person obtaining
 *  a copy of this software and associated documentation files (the
 *  "Software"), to deal in the Software without restriction, including
 *  without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to
 *  permit persons to whom the Software is furnished to do so, subject to
 *  the following conditions:
 * 
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 * 
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 *  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 *  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 *  WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
package org.ednovo.gooru.client.gin;

import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.TokenFormatter;
/**
 * 
 * @fileName : AppPlaceManager.java
 *
 * @description :  This is the default implementation of the {@link PlaceManager}.
 *
 *
 * @version : 1.0
 *
 * @date: 26-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
@Singleton
public class AppPlaceManager extends GooruPlaceManagerImpl implements IsPlaceManager {

	private PlaceRequest defaultPlaceRequest;

	private PlaceRequest errorPlaceRequest;

	private PlaceRequest previousRequest = null;
	
	private PlaceRequest playerBackRequest=null;

	private boolean refreshPlace = true;

	@Inject
	public AppPlaceManager(EventBus eventBus, TokenFormatter tokenFormatter, @AppDefaultPlace String place) {
		super(eventBus, tokenFormatter);
		this.defaultPlaceRequest = new PlaceRequest(place);
		this.errorPlaceRequest = new PlaceRequest(PlaceTokens.ERROR);
	}

	@Override
	public void revealPlace(PlaceRequest place) {
		revealPlace(true, place);
	}

	@Override
	public void revealPlace(boolean refresh, PlaceRequest place) {
		if (previousRequest == null || !previousRequest.equals(place)) {
			previousRequest = getCurrentPlaceRequest();
			playerBackRequest=previousRequest;
		}
		setRefreshPlace(refresh);
		super.revealPlace(place);
	}
	
	@Override
	public void revealPlace(boolean refresh, PlaceRequest place,boolean isPlayerRequest) {
		if (previousRequest != null || !previousRequest.equals(place)) {
			playerBackRequest=previousRequest;
		}
		setRefreshPlace(refresh);
		super.revealPlace(place);
	}

	@Override
	public void revealDefaultPlace() {
		revealPlace(defaultPlaceRequest);
	}

	@Override
	public void revealErrorPlace(String invalidHistoryToken) {
		revealPlace(errorPlaceRequest, false);
	}

	@Override
	public void revealPlace(String viewToken) {
		PlaceRequest placeRequest = new PlaceRequest(viewToken);
		revealPlace(placeRequest);
	}

	@Override
	public void revealPlace(String viewToken, String[]... params) {
		PlaceRequest placeRequest = new PlaceRequest(viewToken);
		if (params != null) {
			for (String[] param : params) {
				if (param != null && param.length == 2) {
					placeRequest = placeRequest.with(param[0], param[1]);
				}
			}
		}
		revealPlace(placeRequest);
	}

	@Override
	public void revealPlace(String viewToken, Map<String, String> params) {
		revealPlace(viewToken, params, false);
	}

	@Override
	public void revealPlace(String viewToken, Map<String, String> params, boolean onlyIfNew) {
		PlaceRequest placeRequest = new PlaceRequest(viewToken); 
		if (params != null) {
			for (String key : params.keySet()) {
				placeRequest = placeRequest.with(key, params.get(key));
			}
		}
		
		/*if (onlyIfNew && placeRequest.equals(AppClientFactory.getPlaceManager().getCurrentPlaceRequest())) {
			
			return;
		}*/
		revealPlace(placeRequest);
	}

	@Override
	public void revealPlace(PlaceRequest placeRequest, Map<String, String> params) {
		if (params != null) {
			for (String key : params.keySet()) {
				placeRequest = placeRequest.with(key, params.get(key));
			}
		}
		revealPlace(placeRequest);
	}

	@Override
	public String getRequestParameter(String key) {
		if (getCurrentPlaceRequest() != null) {
			return getCurrentPlaceRequest().getParameter(key, null);
		}
		return null;
	}

	@Override
	public String getRequestParameter(String key, String defaultValue) {
		if (getCurrentPlaceRequest() != null) {
			return getCurrentPlaceRequest().getParameter(key, defaultValue);
		}
		return null;
	}

	@Override
	public Integer getRequestParameterAsInt(String key) {
		String param = getRequestParameter(key);
		return (param != null) ? Integer.parseInt(param) : null;
	}

	@Override
	public Integer getRequestParameterAsInt(String key, String defaultValue) {
		String param = getRequestParameter(key, defaultValue);
		return (param != null) ? Integer.parseInt(param) : null;
	}

	@Override
	public boolean refreshPlace() {
		return refreshPlace;
	}

	protected void setRefreshPlace(boolean refreshPlace) {
		this.refreshPlace = refreshPlace;
	}

	/**
	 * @return the previousRequest
	 */
	public PlaceRequest getPreviousRequest() {
		return previousRequest;
	}

	/**
	 * @return the previousRequest
	 */
	public PlaceRequest getPlayerPreviousRequest() {
		return playerBackRequest;
	}
	/**
	 * @param previousRequest
	 *            the previousRequest to set
	 */
	public void setPreviousRequest(PlaceRequest previousRequest) {
		this.previousRequest = previousRequest;
	}

	@Override
	public void revealPreviousPlace(boolean refresh, String defaultViewToken) {
		if (previousRequest != null) {
			revealPlace(refresh, previousRequest);
		} else {
			revealPlace(defaultViewToken);
		}
	}
	
	@Override
	public void revealPlayerPreviousPlace(boolean refresh, String defaultViewToken) {
		if (playerBackRequest != null) {
			revealPlace(refresh, playerBackRequest);
		} else {
			revealPlace(defaultViewToken);
		}
	}

	@Override
	public void redirectPlace(String viewToken) {
		setRefreshPlace(true);
		super.revealPlace(new PlaceRequest(viewToken));
	}

}
