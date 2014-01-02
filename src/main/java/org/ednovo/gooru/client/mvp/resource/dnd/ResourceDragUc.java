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
package org.ednovo.gooru.client.mvp.resource.dnd;

import org.ednovo.gooru.client.mvp.dnd.IsDraggableMirage;
import org.ednovo.gooru.client.mvp.shelf.ShelfCBundle;
import org.ednovo.gooru.client.uc.UcCBundle;
import org.ednovo.gooru.client.util.ImageUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : ResourceDragUc.java
 *
 * @description : This file is used to call setdata method to set resource title and image and to add and remove styles to RootPanel
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
public class ResourceDragUc extends FocusPanel implements IsDraggableMirage {

	private static ResourceDragUcUiBinder uiBinder = GWT.create(ResourceDragUcUiBinder.class);

	interface ResourceDragUcUiBinder extends UiBinder<Widget, ResourceDragUc> {
	}

	@UiField
	Label dragResourceImage;

	@UiField
	HTML dragresourceTitle;

	@UiField
	AbsolutePanel container;
	
	@UiField
	FlowPanel labelPanel;

	@UiField(provided = true)
	ShelfCBundle res;

	/**
	 * Class constructor , call setaData method 
	 * @param category of the resource which is being dragged 
	 * @param title of the resource which is being dragged
	 */
	public ResourceDragUc(String category, String title) {
		this.res = ShelfCBundle.INSTANCE;
		res.css().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));
		container.setWidgetPosition(labelPanel, 0, 0);
		onDroppable(false);
		setData(category, title);
	}

	/**
	 * Set resource title and image 
	 * @param category of the resource
	 * @param title of the resource
	 */
	public void setData(String category, String title) {
	  //dragresourceTitle.setText(StringUtil.truncateText(title, 25));
		dragresourceTitle.setHTML(title);
		ImageUtil.renderResourceImage(dragResourceImage, category);
	}
	/**
	 * method onDroppable()
	 */
	public void onDroppable(Boolean droppable) {
	}
	/**
	 * To add styles to RootPanel
	 */
	@Override
	public void onStart() {
		RootPanel.get().addStyleName(UcCBundle.INSTANCE.css().userMoveSelectDisable());
	}
	/**
	 * To remove styles from RootPanel
	 */
	@Override
	public void onEnd() {
		RootPanel.get().removeStyleName(UcCBundle.INSTANCE.css().userMoveSelectDisable());
	}

}
