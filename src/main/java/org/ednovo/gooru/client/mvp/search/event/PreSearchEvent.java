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
package org.ednovo.gooru.client.mvp.search.event;

import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;
import org.ednovo.gooru.shared.model.search.SearchDo;

import com.google.gwt.event.shared.GwtEvent;

/**
 * 
 * @fileName : PreSearchEvent.java
 *
 * @description : Event handler for PreSearch.
 *
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class PreSearchEvent extends GwtEvent<PreSearchHandler> {

	public static final Type<PreSearchHandler> TYPE = new Type<PreSearchHandler>();

	private SearchDo<? extends ResourceSearchResultDo> searchDo;

	/**
	 * Class constructor
	 */
	public PreSearchEvent(SearchDo<? extends ResourceSearchResultDo> searchDo) {
		setSearchDo(searchDo);
	}
	/**
	 * Returns the Event.Type used to register this event, allowing an EventBus to find handlers of the appropriate class.
	 */
	@Override
	public Type<PreSearchHandler> getAssociatedType() {
		return TYPE;
	}
	/**
	 * This method will be  called by HandlerManager and it will be used to invoke register original handler event.
	 */
	@Override
	protected void dispatch(PreSearchHandler handler) {
		handler.preSearch(getSearchDo());
	}
	/**
	 * 
	 * @function getSearchDo 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :returns searchDo.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : SearchDo<? extends ResourceSearchResultDo>
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public SearchDo<? extends ResourceSearchResultDo> getSearchDo() {
		return searchDo;
	}
	/**
	 * 
	 * @function setSearchDo 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : To initialize searchDo.
	 * 
	 * 
	 * @parm(s) : @param searchDo
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setSearchDo(SearchDo<? extends ResourceSearchResultDo> searchDo) {
		this.searchDo = searchDo;
	}

}
