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
package org.ednovo.gooru.client.mvp.dnd;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : AppMirageDragContainer.java
 *
 * @description : This class will handle the Drag container in the application.
 *
 * @version : 1.0
 *
 * @date: 27-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class AppMirageDragContainer extends VerticalPanel {

	private final AppPickupDragController dragController;

	private boolean clonnable = false;

	public AppMirageDragContainer(AppPickupDragController dragController) {
		this.dragController = dragController;
	}

	/**
	 * Overloaded method that makes widgets draggable.
	 * 
	 * @param w
	 *            the widget to be added are made draggable
	 */
	@Override
	public void add(Widget w) {
		if (w instanceof Draggable) {
			dragController.makeDraggable(w);
		}
		super.add(w);
	}

	/**
	 * Overloaded method that makes widgets draggable.
	 * 
	 * @param w
	 *            the widget to be added are made draggable
	 */
	public <T> void addDraggable(IsDraggable w) {
		Draggable draggable = new Draggable(w);
		dragController.makeDraggable(draggable);
		super.add(draggable);
	}

	/**
	 * Removed widgets
	 * replaced with a cloned copy of the original.
	 * 
	 * @param w
	 *            the widget to remove
	 * @return true if a widget was removed
	 */
	@Override
	public boolean remove(Widget w) {
		int index = getWidgetIndex(w);
		if (index != -1 && w instanceof Draggable) {
			if (isClonnable()) {
				Draggable clone = ((Draggable) w).cloneDraggable();
				dragController.makeDraggable(clone);
				insert(clone, index);
				clone.getDraggableUc().onDragBlur();
			} else {
				dragController.makeNotDraggable(w);
			}
		}
		return super.remove(w);
	}
	/**
	 * @function isClonnable 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This method will return whether is clonnable or not.
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : boolean
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public boolean isClonnable() {
		return clonnable;
	}
	/**
	 * @function setClonnable 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This method set the clonnable.
	 * 
	 * @parm(s) : @param duplicate
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setClonnable(boolean duplicate) {
		this.clonnable = duplicate;
	}

}
