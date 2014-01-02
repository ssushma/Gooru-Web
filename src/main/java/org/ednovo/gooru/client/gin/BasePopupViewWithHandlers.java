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
/**
 * 
 */
package org.ednovo.gooru.client.gin;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.shared.model.user.FilterSettings;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;
/**
 * 
 * @fileName : BasePopupViewWithHandlers.java
 *
 * @description : Base class for a popup that implements the {@link BaseUiHandlers}  interface.
 *
 * @version : 1.0
 *
 * @date: 26-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public abstract class BasePopupViewWithHandlers<H extends BaseUiHandlers> extends PopupViewWithUiHandlers<H> implements IsViewWithHandlers<H> {

	/**
	 * Class constructor
	 * 
	 * @param eventBus instance of {@link com.google.gwt.event.shared.EventBus}
	 */
	protected BasePopupViewWithHandlers(EventBus eventBus) {
		super(eventBus);
	}
	
	private boolean isHideFromCloseButton=false;
	/**
	 * This method is used to display the popup
	 */
	@Override
	public void show() {
		Window.enableScrolling(false);
		super.show();
		super.center();
	}
	/**
	 * This method is used to hide the popup
	 */
	@Override
	public void hide() {
		super.hide();
		String count = Cookies.getCookie("MyCookie");
		if(count!= null && Integer.parseInt(count)==7){
			
		}
		else{
			Document.get().getDocumentElement().getStyle().setProperty("overflow", "");
		}
		
	}
	/**
	 * This method is used to set the boolean value, is popup closed by closing icon or not.
	 */
	public void hideFromPopup(boolean isHideFromCloseButton){
		this.isHideFromCloseButton=isHideFromCloseButton;
	}

	@Override
	public void reset() {
		
	}
	/**
	 * This method is called on the on unload.
	 */
	@Override
	public void onUnload() {
		if(isHideFromCloseButton){
			if(!AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.HOME)){
				AppClientFactory.getPlaceManager().revealPlayerPreviousPlace(false, getDefaultView());
			}
		}
	}

	@Override
	public void onLoad() {
	}

	protected abstract String getDefaultView();
	/**
	 * 
	 * @function getSettings 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description : This method will check the is the user logged in or not.
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : FilterSettings
	 *
	 * @throws : <Mentioned if any exceptions>
	 */
	protected FilterSettings getSettings() {
		return AppClientFactory.getLoggedInUser() != null ? AppClientFactory.getLoggedInUser().getSettings() : null;
	}

}
