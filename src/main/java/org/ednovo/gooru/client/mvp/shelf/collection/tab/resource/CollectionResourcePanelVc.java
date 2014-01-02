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
package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource;

import org.ednovo.gooru.client.mvp.dnd.AppRepositionDragContainer;
import org.ednovo.gooru.client.mvp.dnd.AppVerticalPanelDropController;
import org.ednovo.gooru.client.mvp.dnd.Draggable;
import org.ednovo.gooru.client.mvp.resource.dnd.ResourceDragController;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.ShelfCollectionResourceChildView;

import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : CollectionResourcePanelVc.java
 *
 * @description : This class is used as resource panel in the collections.
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class CollectionResourcePanelVc extends AppRepositionDragContainer {

	private AppVerticalPanelDropController widgetDropController;

	private ResourceDragController dragController;

	/**
	 * Class constructor create new instance of  {@link ResourceDragController} and {@link ShelfCollectionResourceDropController}
	 */
	public CollectionResourcePanelVc() {
		super();
		dragController = new ResourceDragController(RootPanel.get(), false, false);
		widgetDropController = new ShelfCollectionResourceDropController(this);
		dragController.registerDropController(widgetDropController);
		setDragController(dragController);
	}
	/**
	 * This method will hit when element/widget dropped.
	 */
	@Override
	public void onDrop(Draggable draggable) {
		ShelfCollectionResourceChildView resourceVc = (ShelfCollectionResourceChildView) draggable.getDraggableUc();
		resourceVc.reorderCollectionItem(getWidgetIndex(draggable));
	}
	/**
	 * This method will hit on the drag over of element/widget.
	 */
	@Override
	public void onDragOver(Draggable draggable) {

	}
	/**
	 * This method will hit on the drag out of element/widget.
	 */
	@Override
	public void onDragOut(Draggable draggable) {
	}
	/**
	 * This method will return the drop target.
	 */
	@Override
	public Widget getDropTarget() {
		return null;
	}
	/**
	 * This method will register the drop controller.
	 */
	@Override
	public void registerDropController() {
		dragController.registerDropController(widgetDropController);
	}/**
	 * This method will unregister the drop controller.
	 */
	@Override
	public void unregisterDropController() {
		dragController.unregisterDropController(widgetDropController);
	}
	/**
	 * This method will call on loading.
	 */
	@Override
	public void onLoad() {
		super.onLoad();
		registerDropController();
	}
	/**
	 * This method will call on unloading.
	 */
	@Override
	public void onUnload() {
		super.onUnload();
		unregisterDropController();
	}

	@Override
	public void reregisterDropController() {
		// Not necessary
	}
}
