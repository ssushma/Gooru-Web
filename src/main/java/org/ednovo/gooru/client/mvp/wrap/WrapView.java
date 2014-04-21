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
package org.ednovo.gooru.client.mvp.wrap;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseView;
import org.ednovo.gooru.client.mvp.home.HeaderUc;
import org.ednovo.gooru.client.mvp.home.event.HeaderTabType;
import org.ednovo.gooru.shared.model.user.UserDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 * 
 */
public class WrapView extends BaseView implements IsWrapView {

	private static WrapViewUiBinder uiBinder = GWT.create(WrapViewUiBinder.class);

	interface WrapViewUiBinder extends UiBinder<Widget, WrapView> {
	}

	@UiField
	SimplePanel wrapperPanel;

	@UiField
	HeaderUc headerUc;

	@UiField HTMLPanel panelWrapper;
	
	/**
	 * Class constructor 
	 */
	public WrapView() {
		setWidget(uiBinder.createAndBindUi(this));
		
		panelWrapper.getElement().setId("wrapper");
	}

	@Override
	public void setInSlot(Object slot, Widget content) {
		if (AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equals(PlaceTokens.RESOURCE_SEARCH)){
			if(AppClientFactory.getPlaceManager().getRequestParameter("query")!=null)
				headerUc.editSearchTxtBox.setText(AppClientFactory.getPlaceManager().getRequestParameter("query"));
		}
		activateSearchBar(true);
		activateClassicButton(false);
		if (slot == WrapPresenter.TYPE_VIEW) {
			if (content != null) {
				wrapperPanel.setWidget(content);
			}
		}
	}

	@Override
	public void activateClassicButton(boolean activate) {
		headerUc.setClassicButtonEnabled(activate);
	}

	@Override
	public void invokeLogin() {
		headerUc.onLinkPopupClicked(null);
	}

	@Override
	public void setLoginData(UserDo user) {
		headerUc.setLoggedInUser(user);
	}

	@Override
	public void invokeRegister() {
		headerUc.onRegisterPopupClicked(null);
	}

	@Override
	public void activateSearchBar(boolean activate) {
		headerUc.setSearchBarEnabled(activate);
	}

	@Override
	public void invokeGooruGuideBubble() {
		/*GooruGuideInfoVc gooruGuideInfo = new GooruGuideInfoVc();
		int left = headerUc.getGooruGuideIconLeft() - 195;
		int top = headerUc.getGooruGuideIconTop() + 40;
		gooruGuideInfo.setWidth("224px");
		gooruGuideInfo.setStyleName(GooruCBundle.INSTANCE.css().logoutPopup());
		gooruGuideInfo.setGlassEnabled(true);
		gooruGuideInfo.setPopupPosition(left, top);
		gooruGuideInfo.show();*/
	}

	public void setDotsPanelSelection(HeaderTabType tabType){

		headerUc.manageDotsMenuSelectionFromEvent(tabType);
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.wrap.IsWrapView#setDiscoverLinkFromLibrary(java.lang.String)
	 */
	@Override
	public void setDiscoverLinkFromLibrary(String discoverLink) {
		headerUc.setDiscoverLinkFromLibrary(discoverLink);
	}

}
