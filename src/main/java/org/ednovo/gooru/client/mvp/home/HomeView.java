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
package org.ednovo.gooru.client.mvp.home;


import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.home.library.LibraryView;
import org.ednovo.gooru.client.mvp.home.register.RegisterVc;
import org.ednovo.gooru.shared.i18n.CopyOfMessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;


/**
 * @author Search Team
` * 
 */
public class HomeView extends BaseViewWithHandlers<HomeUiHandlers> implements IsHomeView {

	@UiField HTMLPanel gooruPanel;
	
	LibraryView libraryView = null;
	
	private static HomeViewUiBinder uiBinder = GWT.create(HomeViewUiBinder.class);

	interface HomeViewUiBinder extends UiBinder<Widget, HomeView> {
	}
	
	private CopyOfMessageProperties i18n = GWT.create(CopyOfMessageProperties.class);

	/**
	 * Class constructor
	 */
	public HomeView() {		
		setWidget(uiBinder.createAndBindUi(this));
		libraryView = new LibraryView(PlaceTokens.HOME);
		gooruPanel.getElement().setId("gooruPanel");
		gooruPanel.add(libraryView);
		

	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.gin.BaseViewWithHandlers#onLoad()
	 */
	@Override
	public void onLoad() {
				
	}
	
	@Override
	public void resetPassword(String resetToken) {
		new ResetPasswordVc(resetToken);
		
	}
	
	@Override
	public void registerPopup() {
		RegisterVc registerVc = new RegisterVc();
		registerVc.show();
		registerVc.center();
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.home.IsHomeView#loadFeaturedContributors()
	 */
	@Override
	public void loadFeaturedContributors(String callBack, String placeToken) {
		libraryView.loadContributorsPage(callBack,placeToken);
	}

}
