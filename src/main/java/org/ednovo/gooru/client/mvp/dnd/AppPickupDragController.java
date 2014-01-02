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

import com.allen_sauer.gwt.dnd.client.VetoDragException;
import com.allen_sauer.gwt.dnd.client.util.DragClientBundle;
import com.google.gwt.user.client.ui.AbsolutePanel;
/**
 * @fileName : AppPickupDragController.java
 *
 * @description : This class will handle the pick drag controller.
 *
 * @version : 1.0
 *
 * @date: 27-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class AppPickupDragController extends PickupDragController {

	/**
	 * @param boundaryPanel instance of {@link AbsolutePanel}
	 * @param allowDroppingOnBoundaryPanel whether or not boundary panel should allow dropping
	 */
	public AppPickupDragController(AbsolutePanel boundaryPanel, boolean allowDroppingOnBoundaryPanel) {
		super(boundaryPanel, allowDroppingOnBoundaryPanel);
	}
	/**
	 * This method will hit when the drag event is fired.
	 */
	@Override
	public void dragStart() {
		super.dragStart();
		context.draggable.removeStyleName(DragClientBundle.INSTANCE.css().dragging());
	}
	/**
	 * This method will give the preview of the drag.
	 */
	@Override
	public void previewDragStart() throws VetoDragException {
		super.previewDragStart();
	}
	/**
	 * This method will fire when the drag ended.
	 */
	@Override
	public void dragEnd() {
		super.dragEnd();
	}

}
