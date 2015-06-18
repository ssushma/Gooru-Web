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
package org.ednovo.gooru.client.uc;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;

/**
 * @author Search Team
 *
 */
public class ImageMultiWordSuggestOracle extends MultiWordSuggestOracle {
	


	private List<String> list = new ArrayList<String>();

	private boolean showAllSuggestions = false;

	/**
	 * Class constructor
	 */
	public ImageMultiWordSuggestOracle() {
		super();
	}

	/**
	 * Class constructor with one parameter
	 * @param showAllSuggestions 
	 */
	public ImageMultiWordSuggestOracle(boolean showAllSuggestions) {
		super();
		setShowAllSuggestions(showAllSuggestions);
	}

	public void add(String suggestion) {
		this.list.add(suggestion);
		super.add(suggestion);
	}

	public void addAll(List<String> suggestions) {
		super.addAll(suggestions);
	}

	/**
	 * Set all suggestion to widget
	 * @param suggestions result
	 */
	public void setAll(List<String> suggestions ) {
		list.clear();
		super.clear();
		//super.addAll(suggestions);
		addAllSuggestions(suggestions);
	}
	
	private void addAllSuggestions(List<String> suggestions) {
		for (String suggestion : suggestions) {
		      add("<img src='images/buttons/plus-blue.png'/>"+suggestion);
	    }
	}

	public void clear() {
		this.list.clear();
		super.clear();
	}
	/**
	 * Remove suggestion result from widget
	 * @param suggestion result
	 */
	/*public void removeSuggestion(String suggestion) {
		this.list.remove(suggestion);
		this.clear();
		super.addAll(list);
	}*/

	public List<String> getList() {
		return list;
	}

	public boolean isEmpty() {
		return list == null || list.size() == 0;
	}

	@Override
	public void requestSuggestions(Request request, Callback callback) {
		if (showAllSuggestions) {
			int limit = request.getLimit();

			// Get candidates from search words.
			List<String> candidates = getList();

			// Respect limit for number of choices.
			int numberTruncated = Math.max(0, candidates.size() - limit);
			for (int i = candidates.size() - 1; i > limit; i--) {
				candidates.remove(i);
			}

			// Convert candidates to suggestions.
			List<MultiWordSuggestion> suggestions = convertToFormattedAllSuggestions(request.getQuery(), candidates);

			Response response = new Response(suggestions);
			response.setMoreSuggestionsCount(numberTruncated);

			callback.onSuggestionsReady(request, response);
		} else {
			super.requestSuggestions(request, callback);
		}
	}

	/**
	 * Returns real suggestions with the given query in <code>strong</code> html
	 * font.
	 * 
	 * @param query
	 *            query string
	 * @param candidates
	 *            candidates
	 * @return real suggestions
	 */
	private List<MultiWordSuggestion> convertToFormattedAllSuggestions(String query, List<String> candidates) {
		List<MultiWordSuggestion> suggestions = new ArrayList<MultiWordSuggestion>();
		for (String candidate : candidates) {
			MultiWordSuggestion suggestion = createSuggestion(candidate, candidate);
			suggestions.add(suggestion);
		}
		return suggestions;
	}

	public boolean isShowAllSuggestions() {
		return showAllSuggestions;
	}

	public void setShowAllSuggestions(boolean showAllSuggestions) {
		this.showAllSuggestions = showAllSuggestions;
	}

	
}
