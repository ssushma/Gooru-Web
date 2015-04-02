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
package org.ednovo.gooru.client.mvp.devicesupport;

import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

/**
 * 
 * @fileName : DeviceSupportView.java
 * 
 * @description :
 * 
 * 
 * @version : 1.0
 * 
 * @date: Jul 16, 2013
 * 
 * @Author Gooru Team
 * 
 * @Reviewer:
 */
public class DeviceSupportView extends ViewImpl implements IsDeviceSupportView{
	Widget widget = null;

	private String device;
	private String size;
	
	@UiField Image deviceSupportLbl;

	@UiTemplate("DeviceSupportView.ui.xml")
	interface Binder extends UiBinder<Widget, DeviceSupportView> {

	}

	private static final Binder binder = GWT.create(Binder.class);
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);

	/**
	 * Class constructor
	 */
	@Inject
	public DeviceSupportView() {
		binder.createAndBindUi(this);
		deviceSupportLbl.setTitle(i18n.GL1361());
		deviceSupportLbl.setAltText(i18n.GL1361());
		deviceSupportLbl.setUrl("images/DeviceSupport/tech-saavy.png");
		deviceSupportLbl.getElement().setId("imgDeviceSupport");
		
	}

	@Override
	public void reset() {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void onLoad() {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void onUnload() {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public Widget asWidget() {

		try {
			Document doc = Document.get();
			doc.getElementById("uvTab").getStyle()
					.setVisibility(Visibility.HIDDEN);
			doc.getElementById("__printingFrame").getStyle()
					.setDisplay(Display.NONE);

		} catch (Exception e) {
		}
		widget= binder.createAndBindUi(this);
//		widget = new HTML(
//				"<div><div class=\"container\"><div class=\"deviceHeader\"><div class=\"gooruLogo\"></div></div><div class=\"push\"></div></div><div class=\"imageContainer\"><img src=\"images/DeviceSupport/tech-saavy.png\" class=\"mainImg\" /></div></div>");

		return widget;
	}

	/**
	 * This method is to get the device
	 */
	public String getDevice() {
		return device;
	}

	/**
	 * This method is to set the device
	 */
	public void setDevice(String device) {
		this.device = device;
	}

	/**
	 * This method is to get the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * This method is to set the size
	 */
	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public void writeToConsole(String msg) {
	}
}
