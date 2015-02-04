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
package org.ednovo.gooru.client.mvp.home;

import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * 
 * @fileName : SampleReportEndView.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 09-Dec-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
public class SampleReportEndView extends PopupPanel {

	private static SampleReportEndViewUiBinder uiBinder = GWT
			.create(SampleReportEndViewUiBinder.class);

	interface SampleReportEndViewUiBinder extends
			UiBinder<Widget, SampleReportEndView> {
	}

	private MessageProperties i18n = GWT.create(MessageProperties.class);
	@UiField
	HTMLPanel imageContainer;
	@UiField
	Label lblsummaryText, lblCollectionProgress, lblCollectionProgressDetails,
			lblHeading;
	@UiField
	Image leftImage,bgImage;
	@UiField
	HTMLEventPanel cancelButton;

	public SampleReportEndView() {
		setWidget(uiBinder.createAndBindUi(this));
		this.setGlassEnabled(true);
		this.setHeight("584px");
		this.show();
		this.center();
		Window.enableScrolling(false);
		setUiField();
		this.getElement().getStyle().setZIndex(99999);

	}
	
	/**
	 * 
	 * @function setUiField 
	 * 
	 * @created_date : 09-Dec-2014
	 * 
	 * @description
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	private void setUiField() {
		lblsummaryText.setText(i18n.GL3067());
		lblCollectionProgress.setText(i18n.GL1587());
		lblCollectionProgressDetails.setText(i18n.GL3068());
		lblHeading.setText(i18n.GL3069());
		
		
		StringUtil.setAttributes(lblsummaryText.getElement(), "lblsummaryText", i18n.GL3067(), i18n.GL3067());
		StringUtil.setAttributes(lblCollectionProgress.getElement(), "lblCollectionProgress", i18n.GL1587(), i18n.GL1587());
		StringUtil.setAttributes(lblCollectionProgressDetails.getElement(), "lblCollectionProgressDetails", i18n.GL3068(), i18n.GL3068());
		StringUtil.setAttributes(lblHeading.getElement(), "lblHeading", i18n.GL3069(), i18n.GL3069());
		
		
	//	rightImage.setUrl("images/landing-page/nextArrow.png");
		leftImage.setUrl("images/landing-page/previousArrow.png");
		
		bgImage.setUrl("images/landing-page/collectionSummary3.png");
		bgImage.getElement().setAttribute("style", "width:100%");
		
	}

	@UiHandler("leftImage")
	public void rightImageClick(ClickEvent event) {
		this.hide();
		SampleReportNextView sampleReportNextView = new SampleReportNextView();
	}

	@UiHandler("cancelButton")
	public void cancelButtonClick(ClickEvent event) {
		this.hide();
		Window.enableScrolling(true);
	}
}
