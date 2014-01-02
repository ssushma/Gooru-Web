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

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : AppRepositionDragContainer.java
 *
 * @description : This class will handle the Drag container. 
 *
 * @version : 1.0
 *
 * @date: 27-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public abstract class AppRepositionDragContainer extends VerticalPanel implements DropBox {

	private AppPickupDragController dragController;
	/**
	 * Class constructor.
	 */
	public AppRepositionDragContainer() {
		super();
		// Add an emtpy widget for repositioning
	}

	public void superAdd(Widget w) {
		super.add(w);
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
		super.insert(w, getWidgetCount() - 1);
	}
	/**
	 * This method will insert the widget before the given index.
	 */
	@Override
	public void insert(Widget w, int beforeIndex) {
		if (beforeIndex >= getWidgetCount()) {
			beforeIndex = getWidgetCount() - 1;
		}
		super.insert(w, beforeIndex);
	}

	/**
	 * Overloaded method that makes widgets draggable.
	 * 
	 * @param w
	 *            the widget to be added are made draggable
	 */
	public void addDraggable(IsDraggable w) {
		Draggable draggable = createDraggable(w);
		dragController.makeDraggable(draggable);
		super.insert(draggable, getWidgetCount() - 1);
	}
	/**
	 * @function addDraggable 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This method will make draggable to the widget and wiln insert the widget before the given index.
	 * 
	 * @parm(s) : @param w
	 * @parm(s) : @param beforeIndex
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void addDraggable(IsDraggable w, int beforeIndex) {
		Draggable draggable = createDraggable(w);
		dragController.makeDraggable(draggable);
		insert(draggable, beforeIndex);
	}
	/**
	 * @function makeChildrenDraggable 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This method will make the child widget's as draggable.
	 * 
	 * @parm(s) : @param draggable
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void makeChildrenDraggable(boolean draggable) {
		for (Widget widget : this) {
			if (widget instanceof Draggable) {
				if (draggable) {
					dragController.makeDraggable(widget);
				} else {
					dragController.makeNotDraggable(widget);
				}
			}
		}
	}
	/**
	 * @function createDraggable 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This method will add draggable to the widget.
	 * 
	 * @parm(s) : @param isDraggable
	 * @parm(s) : @return
	 * 
	 * @return : Draggable
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public Draggable createDraggable(IsDraggable isDraggable) {
		return new Draggable(isDraggable);
	}

	/**
	 * @return the {@link AppPickupDragController}
	 */
	public AppPickupDragController getDragController() {
		return dragController;
	}

	/**
	 * @param dragController
	 *            the dragController to set
	 */
	public void setDragController(AppPickupDragController dragController) {
		this.dragController = dragController;
	}

}
