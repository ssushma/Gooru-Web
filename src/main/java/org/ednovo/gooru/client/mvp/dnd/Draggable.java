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

import org.ednovo.gooru.client.mvp.dnd.IsDraggable.DRAG_TYPE;

import com.allen_sauer.gwt.dnd.client.HasDragHandle;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 * 
 */
public class Draggable extends FocusPanel implements HasDragHandle {

	protected IsDraggable draggableUc;

	private IsDraggableMirage draggableMirageUc;

	private String dragId;

	private DRAG_TYPE type;

	/**
	 * Class constructor
	 */
	public Draggable(IsDraggable draggableUc) {
		setDraggableMiriage(draggableUc);
		setWidget(draggableUc);
	}

	public void setDragMode(boolean draggable) {
		if (draggable) {
			setDragId(draggableUc.getDragId());
			setType(getDraggableUc().getDragType());
			setWidget(getDraggableMirageUc());
		} else {
			setWidget(draggableUc);
			draggableUc.onDragBlur();
		}
	}

	public IsDraggableMirage getDraggableMirageUc() {
		if (draggableMirageUc == null) {
			draggableMirageUc = draggableUc.initDraggableMirage();
		}
		return draggableMirageUc;
	}

	public IsDraggable getDraggableUc() {
		return draggableUc;
	}

	public void setDraggableMiriage(IsDraggable draggableMiriage) {
		this.draggableUc = draggableMiriage;
	}

	public Draggable cloneDraggable() {
		return new Draggable(getDraggableUc());
	}

	@Override
	public Widget getDragHandle() {
		return getDraggableUc().getDragHandle() != null ? getDraggableUc().getDragHandle() : this;
	}

	public String getDragId() {
		return dragId;
	}

	public void setDragId(String dragId) {
		this.dragId = dragId;
	}

	public DRAG_TYPE getType() {
		return type;
	}

	public void setType(DRAG_TYPE type) {
		this.type = type;
	}

}
