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
import com.google.gwt.user.client.ui.Image;
/**
 * @fileName : StatisticsItemUc.java
 *
 * @description : This class is used to show the statistics items.
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
public class StatisticsItemUc  extends FlowPanel{
	
	private Image itemImage;
	private LabelUc itemText;
	private LabelUc itemValue;
	private FlowPanel imagePanel;
	private FlowPanel itemPanel;

	/**
	 * Class constructor
	 * @param imageStyleName style name for image
	 * @param itemLabel label name
	 * @param itemContent value of the label
	 */
	public StatisticsItemUc(String imageStyleName, String itemLabel, String itemContent){
		
		itemImage= new Image();
		itemText= new LabelUc();
		itemValue=new LabelUc();		
		imagePanel=new FlowPanel();
		itemPanel=new FlowPanel();
		setComponent(imageStyleName,itemLabel,itemContent);
		itemText.setStyleName(ShelfCBundle.INSTANCE.css().itemTextStyle());
		itemValue.setStyleName(ShelfCBundle.INSTANCE.css().itemValueStyle());
		imagePanel.setStyleName(ShelfCBundle.INSTANCE.css().imagePanel());
		itemPanel.setStyleName(ShelfCBundle.INSTANCE.css().itemPanel());
		this.setStyleName(ShelfCBundle.INSTANCE.css().outerPanel());
	}

	private void setComponent(String imageStyleName, String itemLabel, String itemContent) {
		itemImage.setStyleName(imageStyleName);
		itemText.setText(itemLabel);
		itemValue.setText(itemContent);
		imagePanel.add(itemImage);
		itemPanel.add(itemValue);
		itemPanel.add(itemText);
		this.add(imagePanel);
		this.add(itemPanel);
		}
}
