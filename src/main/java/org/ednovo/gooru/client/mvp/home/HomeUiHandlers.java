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
package org.ednovo.gooru.client.mvp.home;

import java.util.Map;


import org.ednovo.gooru.client.gin.BaseUiHandlers;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.search.AutoSuggestKeywordSearchDo;
import org.ednovo.gooru.shared.model.search.SearchDo;
import org.ednovo.gooru.shared.model.user.UserDo;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;

/**
 * @author Search Team
 * 
 */
public interface HomeUiHandlers extends BaseUiHandlers {
		
	/**
	 * Set home search view
	 * @param params search results 
	 */
	void homeSearch(Map<String, String> params);
	
	/**
	 * @param user instance of {@link UserDo} which has information  for registration
	 */
	void initilazeRegistrationView(UserDo user);

	/**
	 * Set text entered by user to the standards
	 * @param standards instance of {@link SearchDo<CodeDo>} which has information standard codes and description
	 */
	void requestStandardsSuggestion(SearchDo<CodeDo> searchDo);
	
	void requestAutoSuggestKeyword(SearchDo<AutoSuggestKeywordSearchDo> searchDo);

	/**
	 * @function getContributorsSlot 
	 * 
	 * @created_date : Jul 28, 2014
	 * 
	 * @description
	 * 
	 * 
	 * @return
	 * 
	 * @return : Object
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 * 
	*/
	
	Object getContributorsSlot();
}
