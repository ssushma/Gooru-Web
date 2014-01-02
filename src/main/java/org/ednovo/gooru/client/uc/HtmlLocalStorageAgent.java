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
 * @fileName : HtmlLocalStorageAgent.java
 *
 * @description : 
 *
 * @version : 1.0
 *
 * @date: 10-Dec-2013
 *
 * @Author Chandra Veluru
 *
 * @Reviewer: 
 */
package org.ednovo.gooru.client.uc;

import java.util.ArrayList;
import java.util.HashMap;

import org.ednovo.gooru.shared.model.library.CourseDo;

import com.seanchenxi.gwt.storage.client.StorageExt;
import com.seanchenxi.gwt.storage.client.StorageKey;
import com.seanchenxi.gwt.storage.client.StorageKeyFactory;
/**
 * @fileName : HtmlLocalStorageAgent.java
 *
 * @description : This class is used to html5 local storage.
 *
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class HtmlLocalStorageAgent {
    StorageExt localStorage = StorageExt.getLocalStorage();
    StorageKey<HashMap<String, ArrayList<CourseDo>>> libraryStorageObject = StorageKeyFactory.objectKey("libraryStorageObject");
    
    public static boolean getLocalStorage() {
    	
    	return false;
    }
    
    
}
