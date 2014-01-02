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

import java.util.Date;

import org.ednovo.gooru.client.mvp.home.register.RegisterCBundle;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DatePicker;
/**
 * @fileName : TextWithImageUc.java
 *
 * @description : This class is used to display text with image.
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class TextWithImageUc extends FlowPanel{
	
	private TextBox showDate;
	
	private Image datePickerHandler;
	
	private FlowPanel datePickerContainer;
	
	private DatePicker dateBox;
	
	/**
	 * Class constructor
	 */
	public TextWithImageUc(){
		super();
		RegisterCBundle.INSTANCE.css().ensureInjected();
		showDate = new TextBox();
		datePickerHandler = new Image("/images/calendaricon.png");
		dateBox = new DatePicker();
		datePickerContainer = new FlowPanel();
		datePickerContainer.add(dateBox);
		dateBox.setStyleName("dateStyle");
		showDate.setStyleName("dateBox");
		datePickerHandler.setStyleName("calendarImageStyle");
		
		this.setStyleName("gooruDateBox");
		this.add(showDate);
		this.add(datePickerHandler);
		this.add(datePickerContainer);
		datePickerContainer.setVisible(false);
		dateBox.addValueChangeHandler(new ValueChangeHandler<Date>() {
			@Override
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date date = event.getValue();
				String dateStr = DateTimeFormat.getFormat("MM/dd/yy").format(date);
	            showDate.setText(dateStr);
	            datePickerContainer.setVisible(false);
	        }
	    });
	    datePickerHandler.addClickHandler(new OnCalendarClick());
	}	
	private class OnCalendarClick implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			datePickerContainer.setVisible(true);
		}
		
	}

}
