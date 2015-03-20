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
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.user.UserDo;

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

public class ImprovedGooruPopUpView extends PopupPanel{
	private static ImprovedGooruPopUpViewUiBinder uiBinder = GWT
			.create(ImprovedGooruPopUpViewUiBinder.class);

	interface ImprovedGooruPopUpViewUiBinder extends
			UiBinder<Widget, ImprovedGooruPopUpView> {
	}
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);

	@UiField
	HTMLEventPanel closeButton;

	@UiField
	Anchor lblSupportLink,  descLinkFive,descLinkSix,descLinkSeven,descLinkNavigation;//descLinkEight

	@UiField
	InlineLabel    aboutFive,aboutSix,aboutSeven,aboutNavigation;//aboutEight

	@UiField
	HTMLPanel GooruLinkOutercontainer;
	@UiField
	Label headertext, subtext, goorutext, headersubtext,
			   lblTitleFive,lblTitleSix,lblTitleSeven,lblnavigation;//lblTitleEight

	@UiField
	InlineLabel questiontxt;
	// @UiField InlineLabel /*,contenttextlbl1*/;
	// @UiField Image mIcon;

	private TermsAndPolicyVc termsAndPolicyVc;
	
	String version = "6.0";

	public ImprovedGooruPopUpView() {
		super(false);
		setWidget(uiBinder.createAndBindUi(this));
		// this.setSize("704px", " ");
		/*this.setStyleName(HomeCBundle.INSTANCE.css().setMarketingPopUpCenter());*/
		this.setGlassEnabled(true);
		this.show();
		this.center();
		Window.enableScrolling(false);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
//		MixpanelUtil.New_in_Gooru_5_10_Views();
		
		MixpanelUtil.mixpanelEvent("New_In_Gooru_"+version);

		lblSupportLink.getElement().getStyle().setColor("#4d9645");
		headertext.setText(i18n.GL0285());
		headertext.getElement().setId("lblHeadertext");
		headertext.getElement().setAttribute("alt",i18n.GL0285());
		headertext.getElement().setAttribute("title",i18n.GL0285());
		
		goorutext.setText(i18n.GL0287());
		goorutext.getElement().setId("lblGoorutext");
		goorutext.getElement().setAttribute("alt",i18n.GL0287());
		goorutext.getElement().setAttribute("title",i18n.GL0287());
		
		headersubtext.setText(i18n.GL0288());
		headersubtext.getElement().setId("lblHeadersSubText");
		headersubtext.getElement().setAttribute("alt",i18n.GL0288());
		headersubtext.getElement().setAttribute("title",i18n.GL0288());
		
		
		///First
		lblTitleFive.setText(i18n.GL_WHATS_NEW_TITLE_1());
		lblTitleFive.getElement().setId("lblTitleFive");
		lblTitleFive.getElement().setAttribute("alt",i18n.GL_WHATS_NEW_TITLE_1());
		lblTitleFive.getElement().setAttribute("title",i18n.GL_WHATS_NEW_TITLE_1());
		aboutFive.setText(i18n.GL_WHATS_NEW_DESC_1());
		descLinkFive.setText(i18n.GL1239());
		descLinkFive.setVisible(false);
//		descLinkFive.setHref("http://support.goorulearning.org/hc/en-us/articles/200688096");
		
		//Second
		lblnavigation.setText(i18n.GL_WHATS_NEW_TITLE_2());
		lblnavigation.getElement().setId("lblnavigation");
		lblnavigation.getElement().setAttribute("alt",i18n.GL_WHATS_NEW_TITLE_2());
		lblnavigation.getElement().setAttribute("title",i18n.GL_WHATS_NEW_TITLE_2());
		aboutNavigation.setText(i18n.GL_WHATS_NEW_DESC_2());
		aboutNavigation.getElement().setId("spnAboutNavigation");
		aboutNavigation.getElement().setAttribute("alt",i18n.GL_WHATS_NEW_DESC_2());
		aboutNavigation.getElement().setAttribute("title",i18n.GL_WHATS_NEW_DESC_2());
		
		descLinkNavigation.setText(i18n.GL1239());
		descLinkNavigation.getElement().setId("lnkDescLinkNavigation");
		descLinkNavigation.getElement().setAttribute("alt",i18n.GL1239());
		descLinkNavigation.getElement().setAttribute("title",i18n.GL1239());
		descLinkNavigation.setHref(i18n.GL_WHATS_NEW_LINK_2());
		
		
		
		//third..
		lblTitleSix.setText(i18n.GL_WHATS_NEW_TITLE_3());
		lblTitleSix.getElement().setId("lblTitleSix");
		lblTitleSix.getElement().setAttribute("alt",i18n.GL_WHATS_NEW_TITLE_3());
		lblTitleSix.getElement().setAttribute("title",i18n.GL_WHATS_NEW_TITLE_3());
		
		aboutSix.setText(i18n.GL_WHATS_NEW_DESC_3());
		aboutSix.getElement().setId("spnAboutSix");
		aboutSix.getElement().setAttribute("alt",i18n.GL_WHATS_NEW_DESC_3());
		aboutSix.getElement().setAttribute("title",i18n.GL_WHATS_NEW_DESC_3());		
	
//		descLinkSix.setText(i18n.GL1239());
//		descLinkSix.getElement().setId("lnkDescLinkSix");
//		descLinkSix.getElement().setAttribute("alt",i18n.GL1239());
//		descLinkSix.getElement().setAttribute("title",i18n.GL1239());
		descLinkSix.setVisible(false);
//		descLinkSix.setHref(i18n.GL_WHATS_NEW_LINK_2());	
		
		lblTitleSeven.setText(i18n.GL_WHATS_NEW_TITLE_4());
		lblTitleSeven.getElement().setId("lblTitleSeven");
		lblTitleSeven.getElement().setAttribute("alt",i18n.GL_WHATS_NEW_TITLE_4());
		lblTitleSeven.getElement().setAttribute("title",i18n.GL_WHATS_NEW_TITLE_4());
		
		aboutSeven.setText(i18n.GL_WHATS_NEW_DESC_4());
		aboutSeven.getElement().setId("spnAboutSeven");
		aboutSeven.getElement().setAttribute("alt",i18n.GL_WHATS_NEW_DESC_4());
		aboutSeven.getElement().setAttribute("title",i18n.GL_WHATS_NEW_DESC_4());
		
		descLinkSeven.setText(i18n.GL1239());
		descLinkSeven.getElement().setId("descLinkSeven");
		descLinkSeven.getElement().setAttribute("alt",i18n.GL1239());
		descLinkSeven.getElement().setAttribute("title",i18n.GL1239());
		descLinkSeven.setHref(i18n.GL_WHATS_NEW_LINK_4());
		descLinkSeven.setVisible(true);
		
		
		questiontxt.setText(i18n.GL0298());
		questiontxt.getElement().setId("htmlQuestionTxt");
		questiontxt.getElement().setAttribute("alt",i18n.GL0298());
		questiontxt.getElement().setAttribute("title",i18n.GL0298());
		
		lblSupportLink.setText(i18n.GL0299());
		lblSupportLink.getElement().setAttribute("alt",i18n.GL0299());
		lblSupportLink.getElement().setAttribute("title",i18n.GL0299());
		lblSupportLink.getElement().setId("lnkSupports");
		lblSupportLink.setHref("mailto:support@goorulearning.org");
		
		closeButton.getElement().setId("btnCloseButton");
		subtext.getElement().setId("lblSubText");
		GooruLinkOutercontainer.getElement().setId("pnlGooruLinkOutercontainer");
	}

	@UiHandler("closeButton")
	public void oncloseButton(ClickEvent clickEvent) {
		MixpanelUtil.New_in_Gooru_x();
		AppClientFactory.getInjector().getUserService().updateUserViewFlag(AppClientFactory.getLoggedInUser().getGooruUId(), 12, new SimpleAsyncCallback<UserDo>() {
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
