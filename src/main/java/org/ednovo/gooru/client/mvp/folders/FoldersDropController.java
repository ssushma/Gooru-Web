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
package org.ednovo.gooru.client.mvp.folders;

import org.ednovo.gooru.client.mvp.dnd.AppVerticalPanelDropController;
import org.ednovo.gooru.client.mvp.folders.item.FolderItemCBundle;

import com.allen_sauer.gwt.dnd.client.DragContext;
import com.allen_sauer.gwt.dnd.client.util.Area;
import com.allen_sauer.gwt.dnd.client.util.CoordinateLocation;
import com.allen_sauer.gwt.dnd.client.util.DOMUtil;
import com.allen_sauer.gwt.dnd.client.util.DragClientBundle;
import com.allen_sauer.gwt.dnd.client.util.Location;
import com.allen_sauer.gwt.dnd.client.util.LocationWidgetComparator;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * 
 * @fileName : FoldersDropController.java
 *
 * @description : This is the DropController for folders.
 *
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class FoldersDropController extends AppVerticalPanelDropController {

	private Widget positioner;
	
	public FoldersDropController(VerticalPanel dropTarget) {
		super(dropTarget);
	}
	/**
	 * This method is used to set new position.
	 */
	@Override
	protected Widget newPositioner(DragContext context) {
		Widget widget = super.newPositioner(context);
		widget.removeStyleName(DragClientBundle.INSTANCE.css().positioner());
		widget.addStyleName(FolderItemCBundle.INSTANCE.css().myFolderDragdropPositioner());
		positioner = widget;
		return widget;
	}
	/**
	 * This method is used to get the widget location.
	 */
	@Override
	protected LocationWidgetComparator getLocationWidgetComparator() {
		return new LocationWidgetComparator() {

			@Override
			public boolean locationIndicatesIndexFollowingWidget(Area widgetArea, Location location) {
				return location.getTop() > widgetArea.getTop() + widgetArea.getHeight();
			}
		};
	}
	
	/**
	 * @return drag and drop widget comparator
	 */
	protected LocationWidgetComparator getMoveLocationWidgetComparator() {
		return new LocationWidgetComparator() {

			@Override
			public boolean locationIndicatesIndexFollowingWidget(Area widgetArea, Location location) {
				return location.getTop() > widgetArea.getTop() + widgetArea.getHeight() / 2;
			}
		};
	}
	/**
	 * This will set the positioner to 2 if the positionerIndex is 0.
	 */
	@Override
	public void onEnter(DragContext context) {
		super.onEnter(context);
		int positionerIndex = dropTarget.getWidgetIndex(positioner);
		GWT.log("postionIndex: " + positionerIndex );
		if (positionerIndex == 0) {
			dropTarget.insert(positioner, 2);
		}
	}
	/**
	 * This will check weather the positioner not already in the correct location and it will not do anything if the positioner is the only widget. If it is outside the drop target,it will remove the  positioner to indicate a drop else it will set the target index to drop target. 
	 */
	@Override
	public void onMove(DragContext context) {
		int targetIndex = DOMUtil.findIntersect(dropTarget, new CoordinateLocation(context.mouseX, context.mouseY), getMoveLocationWidgetComparator());

		// check that positioner not already in the correct location
		int positionerIndex = dropTarget.getWidgetIndex(positioner);

		if (positionerIndex != targetIndex && (positionerIndex != targetIndex - 1 && targetIndex != 0)) {
			if (positionerIndex == 0 && dropTarget.getWidgetCount() == 1) {
				// do nothing, the positioner is the only widget
			} else if (targetIndex == -1) {
				// outside drop target, so remove positioner to indicate a drop
				positioner.removeFromParent();
			} else {
				dropTarget.insert(positioner, targetIndex);
			}
		}
	}
	/**
	 * This will add the drag context.
	 */
	@Override
	public void onLeave(DragContext context) {
		positioner.removeFromParent();
		positioner = null;
		super.onLeave(context);
	}

}
