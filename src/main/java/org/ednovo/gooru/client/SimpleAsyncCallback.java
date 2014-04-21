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

import java.io.IOException;

import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.shared.exception.GwtException;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public abstract class SimpleAsyncCallback<T> implements AsyncCallback<T>,MessageProperties {

	@Override
	public void onFailure(Throwable caught) {
		String message = "";
		if (caught instanceof IOException) {
			Window.Location.reload();
			GWT.log(caught.getMessage());
		} else {
			if (caught instanceof GwtException && ((GwtException) caught).getErrors().size() > 0) {
				message = ((GwtException) caught).getMessage();
			} else if (caught.getMessage() != null) {
				if (caught.getMessage().contains("Login")) {
					message = GL1096;
				}
				if (caught.getMessage().contains("403")) {
					message = GL1095;
				} else if (caught.getMessage().contains("CODE_502")) {
					message = GL0695;
				} else {
					message = caught.getMessage();
				}
			} else {
				message = GL0839;
			}
			if (message.trim().toString().equalsIgnoreCase("0")){
				
			}else{
				new AlertContentUc(GL0844, message);
			}
		}
	}

}
