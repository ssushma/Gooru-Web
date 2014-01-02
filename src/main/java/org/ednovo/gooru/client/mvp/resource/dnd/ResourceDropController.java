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
package org.ednovo.gooru.client.mvp.resource.dnd;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.dnd.AppSimpleDropController;
import org.ednovo.gooru.client.mvp.dnd.Draggable;
import org.ednovo.gooru.client.mvp.dnd.DropBox;
import org.ednovo.gooru.client.mvp.home.LoginPopupUc;
import org.ednovo.gooru.client.util.MixpanelUtil;

import com.allen_sauer.gwt.dnd.client.DragContext;
import com.allen_sauer.gwt.dnd.client.VetoDragException;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : ResourceDropController.java
 *
 * @description : Create a DropController for each drop target on which draggable widgets can be dropped. Do not forget to register each DropController with a DragController.
 *
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class ResourceDropController extends AppSimpleDropController {

	private DropBox resourceDropBox;
	
	private boolean dropActive;

	/**
	 * Class constructor , assign dropBox object
	 * @param dropBox instance of {@link DropBox}
	 */
	public ResourceDropController(DropBox dropBox) {
		super(dropBox.asWidget());
		this.resourceDropBox = dropBox;
	}
	/**
	 *  This method is Called when the draggable widget or its proxy is dropped on our drop target.
	 */
	@Override
	public void onDrop(DragContext context) {
		setDropActive(false);
		if (AppClientFactory.getLoggedInUser().getUserUid().equals(AppClientFactory.GOORU_ANONYMOUS)) {
			//AppClientFactory.fireEvent(new InvokeLoginEvent());
			LoginPopupUc loginPopupUc=new LoginPopupUc(); 
			if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.RESOURCE_SEARCH)){
				MixpanelUtil.sign_up_from_dragging_resource();
				loginPopupUc.setMixPanelEvent("dragresource");
			}else if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.COLLECTION_SEARCH)){
				MixpanelUtil.sign_up_from_saving_a_collection();
				loginPopupUc.setMixPanelEvent("savecollection");
			}
		} else {
			for (Widget widget : context.selectedWidgets) {
				if (widget instanceof Draggable) {
					resourceDropBox.onDrop((Draggable) widget);
				}
			}
		}
		super.onDrop(context);
	}
	/**
	 *This method is Called when the draggable widget or its proxy engages our drop target.
	 */
	@Override
	public void onEnter(DragContext context) {
		setDropActive(true);
		super.onEnter(context);
		for (Widget widget : context.selectedWidgets) {
			if (widget instanceof Draggable) {
				resourceDropBox.onDragOver((Draggable) widget);
			}
		}
	}
	/**
	 * Called when the reference widget stops engaging our drop target by leaving the area of the page occupied by our drop target, or after onDrop(DragContext) to allow for any cleanup.
	 */
	@Override
	public void onLeave(DragContext context) {
		setDropActive(false);
		for (Widget widget : context.selectedWidgets) {
			if (widget instanceof Draggable) {
				resourceDropBox.onDragOut((Draggable) widget);
			}
		}
		super.onLeave(context);
	}
	/**
	 *  Called just prior to onDrop(DragContext) to allow the drop operation to be cancelled by throwing a VetoDragException.
	 */
	@Override
	public void onPreviewDrop(DragContext context) throws VetoDragException {
		super.onPreviewDrop(context);
	}
	/**
	 * 
	 * @function getResourceDropBox 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :returns resourceDropBox.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : DropBox
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public DropBox getResourceDropBox() {
		return resourceDropBox;
	}
	/**
	 * 
	 * @function isDropActive 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :returns dropActive.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : boolean
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public boolean isDropActive() {
		return dropActive;
	}
	/**
	 * 
	 * @function setDropActive 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :Toset drop active.
	 * 
	 * 
	 * @parm(s) : @param dropActive
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setDropActive(boolean dropActive) {
		this.dropActive = dropActive;
	}
}
