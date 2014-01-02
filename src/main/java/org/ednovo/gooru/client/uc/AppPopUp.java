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
package org.ednovo.gooru.client.uc;

import org.ednovo.gooru.client.mvp.shelf.ShelfCBundle;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : AppPopUp.java
 *
 * @description : This is the top-level popup panel.
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class AppPopUp extends PopupPanel {

	private FlowPanel headerPanel;
	private FlowPanel content;
	private Label labletitle;

	/**
	 * Class constructor 
	 */
	public AppPopUp() {
		super(false);
		ShelfCBundle.INSTANCE.css().ensureInjected();
		this.setStyleName(ShelfCBundle.INSTANCE.css().shelfItemPopUp());
		this.setStyleName(ShelfCBundle.INSTANCE.css().shelfItemShortenUrlPopUp());
		headerPanel = new FlowPanel();
		content = new FlowPanel();
		headerPanel.setStyleName(ShelfCBundle.INSTANCE.css().shelfItemPopUpOuterDiv());
		labletitle = new Label();
		labletitle.setStyleName(ShelfCBundle.INSTANCE.css().shelfItemHeaderText());
		headerPanel.add(labletitle);
		content.add(headerPanel);
		this.setWidget(content);
		setGlassEnabled(true);
		setAutoHideOnHistoryEventsEnabled(true);
		getElement().getStyle().setZIndex(200);
	}
	public void setGlassZindex(int index){
		getGlassElement().getStyle().setZIndex(index);
	}
	public void setPopupZindex(int index){
		getElement().getStyle().setZIndex(index);
	}
	/**
	 * Class constructor with one parameter
	 * @param type 
	 */
	public AppPopUp(String type){
		super(false);
		ShelfCBundle.INSTANCE.css().ensureInjected();
		this.setStyleName(ShelfCBundle.INSTANCE.css().shelfItemPopUp());
		content = new FlowPanel();
		this.setWidget(content);
		setGlassEnabled(true);
	}
	/**
	 * Class constructor with two parameter
	 * @param title of  AppPopUp
	 * @param widget instance of {@link Widget} 
	 */
	/*public AppPopUp(String title, Widget widget) {
		this();
		setContent(title, widget);
	}*/

	/**
	 * Set appPopUp content
	 * @param title for appPopUp
	 * @param widget instance of {@link Widget}
	 */
	public void setContent(String title, Widget widget) {
		content.add(widget);
		setViewTitle(title);
	}
	/**
	 * This will return the header panel.
	 */
	public FlowPanel getHeaderPanel() {
		return headerPanel;
	}
	/**
	 * This will set the header panel.
	 */
	public void setHeaderPanel(FlowPanel headerPanel) {
		this.headerPanel = headerPanel;
	}
	/**
	 * This will set the content.
	 */
	public void setContent(Widget content) {
		this.content.add(content);
	}
	/**
	 * This will set the title.
	 */
	public void setViewTitle(String title) {
		labletitle.setText(title);
	}
	
}
