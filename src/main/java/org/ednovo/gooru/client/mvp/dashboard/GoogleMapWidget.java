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
package org.ednovo.gooru.client.mvp.dashboard;
/**


*
* @description : 
*
* @version :1.0
*
* @date: APR 19 2013
   	
* @Author Gooru Team
*
* Reviewer Gooru Team
*
*/


import org.ednovo.gooru.client.util.HeatMapLayerWidget;
import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class GoogleMapWidget extends Composite{
	private static GoogleMapWidgetUiBinder uiBinder = GWT
			.create(GoogleMapWidgetUiBinder.class);
	
	@UiField Label collectionCountNum,collectionCountText,cityNameLblLeft,cityNameLblRight;
	@UiField InlineLabel percentageLblLeft,percentageLblRight;
	@UiField  HTMLPanel graphContainer;

	interface GoogleMapWidgetUiBinder extends
			UiBinder<Widget, GoogleMapWidget> {

	}
	
	public MessageProperties i18n = GWT.create(MessageProperties.class);
	
	public interface Binder extends UiBinder<Widget, GoogleMapWidget> {
	}

	@Inject
	public GoogleMapWidget() {
		initWidget(uiBinder.createAndBindUi(this));
		collectionCountNum.setText("1,432");
		collectionCountText.setText("Collections Published");
		cityNameLblLeft.setText("California");
		percentageLblLeft.setText("40%");
		cityNameLblRight.setText("Arizona");
		percentageLblRight.setText("20%");
		//graphContainer.add(new HeatMapLayerWidget());
	}
	
}