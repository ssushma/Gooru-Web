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
package org.ednovo.gooru.client.mvp.folders.edit.tab.content;

import org.ednovo.gooru.client.mvp.dnd.AppRepositionDragContainer;
import org.ednovo.gooru.client.mvp.dnd.AppVerticalPanelDropController;
import org.ednovo.gooru.client.mvp.dnd.Draggable;
import org.ednovo.gooru.client.mvp.folders.item.FolderItemChildView;
import org.ednovo.gooru.client.mvp.resource.dnd.ResourceDragController;

import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * 
 * @fileName : SecondThirdLevelFoldersPanelVc.java
 *
 * @description : This file is used to reposition the folders drop controller.
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
public class SecondThirdLevelFoldersPanelVc extends AppRepositionDragContainer {
	
	private AppVerticalPanelDropController widgetDropController;
	
	private ResourceDragController dragController;
	/**
	 * Constructor.
	 */
	public SecondThirdLevelFoldersPanelVc(){
		super();
		dragController = new ResourceDragController(RootPanel.get(), false, false);
		widgetDropController = new SecondThirdLevelFoldersDropController(this);
		dragController.registerDropController(widgetDropController);
		setDragController(dragController);
	}
	/**
	 * This is used to reorder the folder item by getting the widget index.
	 */
	@Override
	public void onDrop(Draggable draggable) {
		FolderItemChildView folderVc = (FolderItemChildView) draggable.getDraggableUc();
		folderVc.reorderFolderItem(getWidgetIndex(draggable));
	}
	/**
	 * This is the DragOver event.
	 */
	@Override
	public void onDragOver(Draggable draggable) {
		
	}
	/**
	 * This is the onDragOut event.
	 */

	@Override
	public void onDragOut(Draggable draggable) {
		
	}
	/**
	 * This is use dto get DropTarget.
	 */

	@Override
	public Widget getDropTarget() {
		return null;
	}
	/**
	 * This is used to register the DropController.
	 */
	@Override
	public void registerDropController() {
		dragController.registerDropController(widgetDropController);
	}
	/**
	 * This is used to unregister the DropController.
	 */
	@Override
	public void unregisterDropController() {
		dragController.unregisterDropController(widgetDropController);
	}
	/**
	 * This is used to re register the DropController.
	 */
	@Override
	public void reregisterDropController() {
		
	}
	/**
	 * This method is used to register the drop controller on Load event.
	 */
	@Override
	public void onLoad() {
		super.onLoad();
		registerDropController();
	}
	/**
	 * This method is used to unregister the drop controller on UnLoad event.
	 */
	@Override
	public void onUnload() {
		super.onUnload();
		unregisterDropController();
	}

}
