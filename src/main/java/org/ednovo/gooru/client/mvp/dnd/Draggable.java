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
 * @fileName : Draggable.java
 *
 * @description : This is the class used for to make widget draggable.
 *
 * @version : 1.0
 *
 * @date: 27-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
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
	/**
	 * This method is used to set the drag mode.
	 */
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
	/**
	 * @function getDraggableMirageUc 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This method will check whether the widget is draggable or not.
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : IsDraggableMirage
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public IsDraggableMirage getDraggableMirageUc() {
		if (draggableMirageUc == null) {
			draggableMirageUc = draggableUc.initDraggableMirage();
		}
		return draggableMirageUc;
	}
	/**
	 * @function getDraggableUc 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This method will check whether the widget is draggable or not.
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : IsDraggable
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public IsDraggable getDraggableUc() {
		return draggableUc;
	}
	/**
	 * @function getDraggableUc 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This method will set the draggable miriage.
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : IsDraggable
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setDraggableMiriage(IsDraggable draggableMiriage) {
		this.draggableUc = draggableMiriage;
	}
	/**
	 * @function cloneDraggable 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : It will clone the draggable widget.
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : Draggable
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public Draggable cloneDraggable() {
		return new Draggable(getDraggableUc());
	}
	/**
	 * This will handle the drag handler.
	 */
	@Override
	public Widget getDragHandle() {
		return getDraggableUc().getDragHandle() != null ? getDraggableUc().getDragHandle() : this;
	}
	/**
	 * @function getDragId 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This method will return the drag id.
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public String getDragId() {
		return dragId;
	}
	/**
	 * @function setDragId 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This method will set the drag id.
	 * 
	 * @parm(s) : @param dragId
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setDragId(String dragId) {
		this.dragId = dragId;
	}
	/**
	 * @function getType 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This method will return the drag type.
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : DRAG_TYPE
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public DRAG_TYPE getType() {
		return type;
	}
	/**
	 * @function setType 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This method will set the type of the Drag type.
	 * 
	 * @parm(s) : @param type
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setType(DRAG_TYPE type) {
		this.type = type;
	}

}
