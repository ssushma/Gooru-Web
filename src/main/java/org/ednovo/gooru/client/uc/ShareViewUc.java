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

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;
/**
 * @fileName : ShareViewUc.java
 *
 * @description : This class is used to set the share view.
 *
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class ShareViewUc extends FlowPanel {
	
	private Label collectionTitle;
	
	private Label collectionSubTitle;
	
	public FocusPanel collectionShareTooltip;
	
	/**
	 * Class constructor
	 * @param ImageTypeTitle collection title on the image
	 * @param ImageSubTitle collection subtitle
	 */
	public ShareViewUc(String ImageTypeTitle, String ImageSubTitle){
	/*	showShareCointainer.setStyleName(ShelfCBundle.INSTANCE.css().showShareInnerDiv());*/
		collectionTitle = new Label();
		collectionSubTitle = new Label();
		collectionSubTitle.setStyleName(ShelfCBundle.INSTANCE.css().showShareSubTitles());
		collectionTitle.setText(ImageTypeTitle);
		collectionSubTitle.setText(ImageSubTitle);
		collectionShareTooltip = new FocusPanel();
		collectionShareTooltip.setStyleName(ShelfCBundle.INSTANCE.css().collectionShareTooltip());
		collectionShareTooltip.add(collectionTitle);
		this.add(collectionShareTooltip);
		this.add(collectionSubTitle);
	}
	/**
	 * 
	 * @function setTitleDescriptionStyle 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This will set the styles for title and description.
	 * 
	 * 
	 * @parm(s) : @param paddingLeft
	 * @parm(s) : @param marginLeft
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setTitleDescriptionStyle(int paddingLeft, int marginLeft) {
		collectionShareTooltip.getElement().getStyle().setPaddingLeft(paddingLeft, Unit.PX);
		collectionSubTitle.getElement().getStyle().setMarginLeft(marginLeft, Unit.PX);
	}
	
}
