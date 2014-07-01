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

/**
 * @fileName : ImprovedGooruPopUpView.java
 *
 * @description : This file is a UiBinder for ImprovedGooruPopUpView.ui.xml and updates the GWT view components. 
 *   After every new release old user should get this popup for first time login after release.
 * 
 * 
 * @version : 1.0
 *
 * @date: 
 *
 * @Author: Gooru Team
 * 
 * @Reviewer: Gooru Team
 */

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.faq.TermsAndPolicyVc;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.user.UserDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class ImprovedGooruPopUpView extends PopupPanel implements
		MessageProperties {
	private static ImprovedGooruPopUpViewUiBinder uiBinder = GWT
			.create(ImprovedGooruPopUpViewUiBinder.class);

	interface ImprovedGooruPopUpViewUiBinder extends
			UiBinder<Widget, ImprovedGooruPopUpView> {
	}

	@UiField
	HTMLEventPanel closeButton;

	@UiField
	Anchor lblSupportLink,  descLinkFive,descLinkSix,descLinkSeven,descLinkEight,descLinkNavigation;

	@UiField
	InlineLabel    aboutFive,aboutSix,aboutSeven,aboutEight,aboutNavigation;

	@UiField
	HTMLPanel GooruLinkOutercontainer;
	@UiField
	Label headertext, subtext, goorutext, headersubtext,
			   lblTitleFive,lblTitleSix,lblTitleSeven,lblTitleEight,lblnavigation;

	@UiField
	HTML questiontxt;
	// @UiField InlineLabel /*,contenttextlbl1*/;
	// @UiField Image mIcon;

	private TermsAndPolicyVc termsAndPolicyVc;
	
	String version = "6.0";

	public ImprovedGooruPopUpView() {
		super(false);
		setWidget(uiBinder.createAndBindUi(this));
		// this.setSize("704px", " ");
		this.setStyleName(HomeCBundle.INSTANCE.css().setAsCenterPopup());
		this.setGlassEnabled(true);
		this.show();
		this.center();
		Window.enableScrolling(false);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
//		MixpanelUtil.New_in_Gooru_5_10_Views();
		
		MixpanelUtil.mixpanelEvent("New_In_Gooru_"+version);

		lblSupportLink.getElement().getStyle().setColor("#4d9645");
		headertext.setText(GL0285);
		headertext.getElement().setId("lblHeadertext");
		headertext.getElement().setAttribute("alt",GL0285);
		headertext.getElement().setAttribute("title",GL0285);
		
		goorutext.setText(GL0287);
		goorutext.getElement().setId("lblGoorutext");
		goorutext.getElement().setAttribute("alt",GL0287);
		goorutext.getElement().setAttribute("title",GL0287);
		
		headersubtext.setText(GL0288);
		headersubtext.getElement().setId("lblHeadersSubText");
		headersubtext.getElement().setAttribute("alt",GL0288);
		headersubtext.getElement().setAttribute("title",GL0288);

		/*contenttext.setText(GL0292);
		contenttextlbl.setText(GL0293);
		
		mobileLearnMore.setText(GL1239);
		mobileLearnMore.getElement().setId("lnkContent");
		mobileLearnMore.setHref("http://support.goorulearning.org/hc/en-us/articles/201896353");
		
		
		
		termsofuselbl.setText(GL0295);
		termsofusetxt.setText(GL0296);
		termsofuselearnmore.setText(GL1239);
		termsofuselearnmore.getElement().setId("lnkLearnMore");
		termsofuselearnmore.setHref("http://support.goorulearning.org/hc/en-us/articles/201480617");
		
		
		
		lblTitleThree.setText(GL0629);
		aboutThree.setText(GL0625);
		descLinkThree.setText(GL1239);
		descLinkThree.setHref("http://support.goorulearning.org/hc/en-us/articles/201897547");
		
		
		lblTitleFour.setText(GL0630);
		aboutFour.setText(GL0627);*/
		
		lblTitleSix.setText(GL1880);
		lblTitleSix.getElement().setId("lblTitleSix");
		lblTitleSix.getElement().setAttribute("alt",GL1880);
		lblTitleSix.getElement().setAttribute("title",GL1880);
		
		lblnavigation.setText(GL1890);
		lblnavigation.getElement().setId("lblnavigation");
		lblnavigation.getElement().setAttribute("alt",GL1890);
		lblnavigation.getElement().setAttribute("title",GL1890);
		
		aboutSix.setText(GL1881);
		aboutSix.getElement().setId("spnAboutSix");
		aboutSix.getElement().setAttribute("alt",GL1881);
		aboutSix.getElement().setAttribute("title",GL1881);
		
		aboutNavigation.setText(GL1891);
		aboutNavigation.getElement().setId("spnAboutNavigation");
		aboutNavigation.getElement().setAttribute("alt",GL1891);
		aboutNavigation.getElement().setAttribute("title",GL1891);
		
		descLinkNavigation.setText(GL1239);
		descLinkNavigation.getElement().setId("lnkDescLinkNavigation");
		descLinkNavigation.getElement().setAttribute("alt",GL1239);
		descLinkNavigation.getElement().setAttribute("title",GL1239);
		descLinkNavigation.setHref("http://support.goorulearning.org/hc/en-us/articles/202952598");
	
		descLinkSix.setText(GL1239);
		descLinkSix.getElement().setId("lnkDescLinkSix");
		descLinkSix.getElement().setAttribute("alt",GL1239);
		descLinkSix.getElement().setAttribute("title",GL1239);
		descLinkSix.setHref("http://support.goorulearning.org/hc/en-us/articles/202952638");
		
		lblTitleSeven.setText(GL1882);
		lblTitleSeven.getElement().setId("lblTitleSeven");
		lblTitleSeven.getElement().setAttribute("alt",GL1882);
		lblTitleSeven.getElement().setAttribute("title",GL1882);
		
		aboutSeven.setText(GL1883);
		aboutSeven.getElement().setId("spnAboutSeven");
		aboutSeven.getElement().setAttribute("alt",GL1883);
		aboutSeven.getElement().setAttribute("title",GL1883);
		
		lblTitleEight.setText(GL1884);
		lblTitleEight.getElement().setId("lblTitleEight");
		lblTitleEight.getElement().setAttribute("alt",GL1884);
		lblTitleEight.getElement().setAttribute("title",GL1884);
		
		aboutEight.setText(GL1885);
		aboutEight.getElement().setId("spnAboutEight");
		aboutEight.getElement().setAttribute("alt",GL1885);
		aboutEight.getElement().setAttribute("title",GL1885);
		
//		lblTitleFive.setText(GL0630_1);
//		lblTitleFive.getElement().setId("lblTitleFive");
//		lblTitleFive.getElement().setAttribute("alt",GL0630_1);
//		lblTitleFive.getElement().setAttribute("title",GL0630_1);
//		aboutFive.setText(GL0627_1);
//		descLinkFive.setText(GL1239);
//		descLinkFive.setHref("http://support.goorulearning.org/hc/en-us/articles/200688096");
		
		questiontxt.setHTML(GL0298);
		questiontxt.getElement().setId("htmlQuestionTxt");
		questiontxt.getElement().setAttribute("alt",GL0298);
		questiontxt.getElement().setAttribute("title",GL0298);
		
		lblSupportLink.setText(GL0299);
		lblSupportLink.getElement().setAttribute("alt",GL0299);
		lblSupportLink.getElement().setAttribute("title",GL0299);
		lblSupportLink.getElement().setId("lnkSupports");
		lblSupportLink.setHref("mailto:support@goorulearning.org");
		
		closeButton.getElement().setId("btnCloseButton");
		subtext.getElement().setId("lblSubText");
		GooruLinkOutercontainer.getElement().setId("pnlGooruLinkOutercontainer");
	}

	@UiHandler("closeButton")
	public void oncloseButton(ClickEvent clickEvent) {
		MixpanelUtil.New_in_Gooru_x();
		AppClientFactory.getInjector().getUserService().updateUserViewFlag(AppClientFactory.getLoggedInUser().getGooruUId(), 11, new SimpleAsyncCallback<UserDo>() {
			@Override
			public void onSuccess(UserDo newUser) {
				UserDo user = AppClientFactory.getLoggedInUser();
				user.setViewFlag(newUser.getViewFlag());
				AppClientFactory.setLoggedInUser(user);
			}
		});
		
		this.removeFromParent();
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
	}
}
