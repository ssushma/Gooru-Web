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
package org.ednovo.gooru.client.mvp.authentication.uc;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.authentication.SignUpCBundle;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.util.MessageProperties;


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class ThankPopUpForUpdateProfile extends PopupPanel implements MessageProperties {

	private static ThankPopUpForUpdateProfileUiBinder uiBinder = GWT
			.create(ThankPopUpForUpdateProfileUiBinder.class);

	interface ThankPopUpForUpdateProfileUiBinder extends
			UiBinder<Widget, ThankPopUpForUpdateProfile> {
	}
	@UiField(provided = true)
	SignUpCBundle res;
	@UiField
	Label lblCancel, lblTitle, lblHeading, lblSubHeading,queriesText;
	@UiField
	Button btnOk;
	@UiField InlineLabel contactText;
	@UiField Anchor supportLink;
	public ThankPopUpForUpdateProfile() {
		super(false);
		this.res = SignUpCBundle.INSTANCE;
		res.css().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));
		this.setGlassEnabled(true);
		this.center();
		this.setSize("502px", "352px");
		Window.enableScrolling(false);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
		this.addStyleName(SignUpCBundle.INSTANCE.css().popupBackground());
		this.setGlassStyleName(SignUpCBundle.INSTANCE.css().signUpPopUpGlassCss());
		//this.getElement().getStyle().setBackgroundColor("transparent");
		setUiAndIds();
	}
	public void setUiAndIds() {
		lblTitle.setText(GL0481
				+GL_SPL_EXCLAMATION);
		lblTitle.getElement().setId("lblTitle");
		lblTitle.getElement().setAttribute("alt",GL0481);
		lblTitle.getElement().setAttribute("title",GL0481);
		
		lblCancel.getElement().setId("lblCancel");
		
		lblHeading.setText(GL0498+GL_SPL_EXCLAMATION);
		lblHeading.getElement().setId("lblHeading");
		lblHeading.getElement().setAttribute("alt",GL0498);
		lblHeading.getElement().setAttribute("title",GL0498);
		lblHeading.getElement().setAttribute("style", "margin-bottom:0px");
		
		lblSubHeading.setText(GL0499);
		lblSubHeading.getElement().setId("lblSubHeading");
		lblSubHeading.getElement().setAttribute("alt",GL0499);
		lblSubHeading.getElement().setAttribute("title",GL0499);
		
		btnOk.getElement().setId("btnOk");
		btnOk.setText(GL0190);
		btnOk.getElement().setAttribute("alt",GL0190);
		btnOk.getElement().setAttribute("title",GL0190);
		
		queriesText.setText(GL1139+GL_GRR_COMMA+" ");
		queriesText.getElement().setId("lblQuriesText");
		queriesText.getElement().setAttribute("alt",GL1139);
		queriesText.getElement().setAttribute("title",GL1139);
		
		contactText.setText(GL1145);
		contactText.getElement().setId("spnContactText");
		contactText.getElement().setAttribute("alt",GL1145);
		contactText.getElement().setAttribute("title",GL1145);
		
		supportLink.setText(GL0299);
		supportLink.getElement().setId("lnkSupportLink");
		supportLink.getElement().setAttribute("alt",GL0299);
		supportLink.getElement().setAttribute("title",GL0299);
		supportLink.setHref(GL1055);		
	}

	@UiHandler("lblCancel")
	public void onClickLblCancel(ClickEvent event) {
		MixpanelUtil.close_signUp();
		if (AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equalsIgnoreCase(PlaceTokens.PREVIEW_PLAY)){
			
		}else{
			Window.enableScrolling(true);
			AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		}
		this.hide();
	}

	@UiHandler("btnOk")
	public void onClickButtonLeave(ClickEvent event) {
		MixpanelUtil.close_signUp();
		this.hide();
		if (AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equalsIgnoreCase(PlaceTokens.PREVIEW_PLAY)){
			
		}else{
			Window.enableScrolling(true);
			AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		}

	}

}
