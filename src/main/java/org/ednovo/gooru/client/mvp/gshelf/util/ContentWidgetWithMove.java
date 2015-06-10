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
package org.ednovo.gooru.client.mvp.gshelf.util;

import org.ednovo.gooru.client.SimpleRunAsyncCallback;
import org.ednovo.gooru.client.uc.H3Panel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public abstract class ContentWidgetWithMove extends Composite {

	private static ContentWidgetWithMoveUiBinder uiBinder = GWT
			.create(ContentWidgetWithMoveUiBinder.class);

	interface ContentWidgetWithMoveUiBinder extends
			UiBinder<Widget, ContentWidgetWithMove> {
	}

	@UiField Label lblTopArrow,lblDownArrow;
	@UiField TextBox txtMoveTextBox;
	@UiField H3Panel h3CourseTitle;
	
	public ContentWidgetWithMove(int index) {
		initWidget(uiBinder.createAndBindUi(this));
		lblTopArrow.addClickHandler(new ArrowClickHandler(false));
		lblDownArrow.addClickHandler(new ArrowClickHandler(true));
		h3CourseTitle.setText("Course "+(index+1));
		txtMoveTextBox.getElement().setAttribute("index",index+"");
	}
	class ArrowClickHandler implements ClickHandler{
		boolean isDownArrow;
		ArrowClickHandler(boolean isDownArrow){
			this.isDownArrow=isDownArrow;
		}
		@Override
		public void onClick(ClickEvent event) {
			GWT.runAsync(new SimpleRunAsyncCallback() {
				@Override
				public void onSuccess() {
					String movingPosition=txtMoveTextBox.getText().toString().trim();
					String currentWidgetPosition=txtMoveTextBox.getElement().getAttribute("index");
					if(!movingPosition.isEmpty()){
						moveWidgetToPosition(movingPosition,currentWidgetPosition,isDownArrow);
					}
				}
			});
		}
	}
	
	public H3Panel getH3Panel(){
		return h3CourseTitle;
	}
	public TextBox getTextBox(){
		return txtMoveTextBox;
	}
	
	public abstract void moveWidgetToPosition(String movingPosition,String currentWidgetPosition,boolean isDownArrow);
}
