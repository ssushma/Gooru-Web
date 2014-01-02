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
package org.ednovo.gooru.client.mvp.dnd;


import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : DropBox.java
 *
 * @description : This class will be the drop box container.
 *
 * @version : 1.0
 *
 * @date: 27-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public interface DropBox extends IsWidget {
	
	/**
	 * While drag event
	 * @param draggable instance of {@link Draggable}
	 */
	void onDrop(Draggable draggable);
	
	/**
	 * While drag over 
	 * @param draggable instance of {@link Draggable}
	 */
	void onDragOver(Draggable draggable);
	
	/**
	 * Create events on drag out
	 * @param draggable instance of {@link Draggable}
	 */
	void onDragOut(Draggable draggable);
	
	/**
	 * @return instance of {@link Widget}
	 */
	Widget getDropTarget();
	
	/**
	 * Register while drop resource if anonymous user is logged in
	 */
	void registerDropController();
	
	/**
	 * drop event while register
	 */
	void unregisterDropController();
	
	/**
	 * Re-registration while drop resources    
	 */
	void reregisterDropController();

}
