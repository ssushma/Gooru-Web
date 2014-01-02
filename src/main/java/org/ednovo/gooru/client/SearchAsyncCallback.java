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
package org.ednovo.gooru.client;

import java.util.Date;

import org.ednovo.gooru.shared.model.search.AbstractSearchDo;

import com.google.gwt.user.client.rpc.AsyncCallback;
/**
 * 
 * @fileName : SearchAsyncCallback.java
 *
 * @description :  This class requests GWT async API calls.
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
public abstract class SearchAsyncCallback<T extends AbstractSearchDo<?>> implements AsyncCallback<T> {

	private long version = 0;

	@Override
	public void onFailure(Throwable caught) {
		// Ignore Search Errors
	}
	/**
	 * On API call success sets respective error message.
	 */
	@Override
	public final void onSuccess(T result) {
		if (version == result.getVersion()) {
			onCallSuccess(result);
		}
	}
	/**
	 * 
	 * @function execute 
	 * 
	 * @created_date : 26-Dec-2013
	 * 
	 * @description : This method will execute automatically.
	 * 
	 * @parm(s) : @param searchDo
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 *
	 */
	public final void execute(T searchDo) {
		searchDo.setVersion(new Date().getTime());
		version = searchDo.getVersion();
		run(searchDo);
	}

	protected abstract void run(T searchDo);

	public abstract void onCallSuccess(T result);

}
