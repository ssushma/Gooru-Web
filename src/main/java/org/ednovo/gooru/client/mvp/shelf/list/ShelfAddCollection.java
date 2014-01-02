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
package org.ednovo.gooru.client.mvp.shelf.list;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.dnd.Draggable;
import org.ednovo.gooru.client.mvp.dnd.DropBox;
import org.ednovo.gooru.client.mvp.dnd.IsDraggable.DRAG_TYPE;
import org.ednovo.gooru.client.mvp.resource.dnd.ResourceDropController;
import org.ednovo.gooru.client.mvp.search.event.RegisterSearchDropEvent;
import org.ednovo.gooru.client.mvp.search.event.UnregisterSearchDropEvent;
import org.ednovo.gooru.client.mvp.shelf.event.CopyCollectionEvent;
import org.ednovo.gooru.client.mvp.shelf.event.CreateCollectionAndItemEvent;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.player.resource.client.view.resourceplayer.CustomAnimation;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : ShelfAddCollection.java
 *
 * @description : This is used to add collection to the shelf
 *
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class ShelfAddCollection extends FocusPanel implements DropBox {

	private ResourceDropController dropController;

	private Label lbl;
	
	private Label blueLbl;
	
	private FlowPanel gradientContFloPanel;

	/**
	 * Class constructor
	 */
	public ShelfAddCollection() {
		super();
		dropController = new ResourceDropController(this);
		this.setStyleName(ShelfListCBundle.INSTANCE.css().shelfNewCollection());
	}

	/**
	 * Create new instance for {@link Label} and set label name 
	 * @param label name of the {@link Label}
	 */
	public void setLabel(String label) {
		gradientContFloPanel = new FlowPanel();
		lbl = new Label(label);
		gradientContFloPanel.add(lbl);
		lbl.setStyleName(ShelfListCBundle.INSTANCE.css().shelfNewCollectionText());
		this.setWidget(gradientContFloPanel);
	}
	/**
	 * 
	 * @function getLabel 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :Widget contains arbitary text no interpreted as HTML.It uses <div> tag causing  to be displayed with block layout
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : Label
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public Label getLabel() {
		return lbl;
	}
/**
 * @description: This is used to drop after dragging the section .
 */
	@Override
	public void onDrop(Draggable draggable) {
		if (draggable.getType().equals(DRAG_TYPE.COLLECTION)) { 
			MixpanelUtil.Drag_Collection();
			new CustomAnimation(draggable).run(50);
			this.setLabel("Adding...");
			AppClientFactory.fireEvent(new CopyCollectionEvent(draggable.getDragId()));
		} else if (draggable.getType().equals(DRAG_TYPE.RESOURCE)) {
			new CustomAnimation(draggable).run(50);
			MixpanelUtil.Drag_Resource();
			AppClientFactory.fireEvent(new CreateCollectionAndItemEvent(draggable.getDragId()));
		}
	}
/**
 * @description: this Fires on the target element continuously while the user drags the object over a valid drop target.
 */
	@Override
	public void onDragOver(Draggable draggable) {
		if (draggable.getType().equals(DRAG_TYPE.RESOURCE) || draggable.getType().equals(DRAG_TYPE.COLLECTION)) {
			draggable.getDraggableMirageUc().onDroppable(true);
			this.addStyleName(ShelfListCBundle.INSTANCE.css().blueBorder());
		}
	}
	/**
	 * @description: This is used to  drag  moved out of a drop point
	 */
	@Override
	public void onDragOut(Draggable draggable) {
		if (draggable.getType().equals(DRAG_TYPE.RESOURCE) || draggable.getType().equals(DRAG_TYPE.COLLECTION)) {
			draggable.getDraggableMirageUc().onDroppable(false);
			this.removeStyleName(ShelfListCBundle.INSTANCE.css().blueBorder());
		}

	}
/**
 * @description: this widget gives support for receiving events from browser and add directly to the panels
 */
	@Override
	public Widget getDropTarget() {
		return this;
	}
/**
 * @description: This method calls  when a widget is attached to the browser document
 */
	@Override
	protected void onLoad() {
		super.onLoad();
		registerDropController();
	}
	/**
	  * @description: This method calls  when a widget is detached from the browser document

	 */

	@Override
	protected void onUnload() {
		super.onUnload();
		unregisterDropController();
	}
/**
 * @description: This is used to register when an anonymous user is logged in
 */
	@Override
	public void registerDropController() {
		AppClientFactory.fireEvent(new RegisterSearchDropEvent(dropController, RegisterSearchDropEvent.DROP_AREA.SHELF_ADD_COLLECTION));
	}
/**
  * @description: This is used to unregister 

 */
	@Override
	public void unregisterDropController() {
		AppClientFactory.fireEvent(new UnregisterSearchDropEvent(dropController, RegisterSearchDropEvent.DROP_AREA.SHELF_ADD_COLLECTION));
	}
/**
 * @description: This is used to register  again
 */
	@Override
	public void reregisterDropController() {
		unregisterDropController();
		registerDropController();
	}
}
