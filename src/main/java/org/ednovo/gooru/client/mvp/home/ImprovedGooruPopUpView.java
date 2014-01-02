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


import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.faq.TermsAndPolicyVc;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
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
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * 
 * @fileName : ImprovedGooruPopUpView.java
 *
 * @description : This file is a UiBinder for ImprovedGooruPopUpView.ui.xml and updates the GWT view components. 
 *   After every new release old user should get this popup for first time login after release.
 *
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
    public class ImprovedGooruPopUpView extends PopupPanel {
	private static ImprovedGooruPopUpViewUiBinder uiBinder = GWT
			.create(ImprovedGooruPopUpViewUiBinder.class);

	interface ImprovedGooruPopUpViewUiBinder extends
			UiBinder<Widget, ImprovedGooruPopUpView> {
	}

	@UiField
	HTMLEventPanel closeButton;

	@UiField
	Anchor lblSupportLink,mobileLearnMore,termsofuselearnmore;
	
	@UiField
	HTMLPanel GooruLinkOutercontainer;
	@UiField 
	Label headertext,subtext,goorutext,headersubtext,contenttext,termsofuselbl;
	
	@UiField HTML questiontxt,termsofusetxt; 
	@UiField InlineLabel contenttextlbl,contenttextlbl1;
	@UiField Image mIcon;
	
	private TermsAndPolicyVc termsAndPolicyVc;
	/**
	 * 	Constructor.
	 */
	public ImprovedGooruPopUpView() {
		super(false);
        setWidget(uiBinder.createAndBindUi(this));
        this.setSize("690px", "347px");
		this.setGlassEnabled(true);
	    this.show();
	    this.center();
	    Window.enableScrolling(false);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, false));
        MixpanelUtil.New_in_Gooru_5_10_Views();
//        lblSupportLink.setHref("http://support.goorulearning.org/anonymous_requests/new");
        lblSupportLink.getElement().getStyle().setColor("#4d9645");
        headertext.setText(MessageProperties.GL0285);
        //subtext.setText(MessageProperties.GL0286);
        goorutext.setText(MessageProperties.GL0287);
        headersubtext.setText(MessageProperties.GL0288);
        //questiontypetext.setText(MessageProperties.GL0289);
        //questiontypetextdesc.setHTML(MessageProperties.GL0290);
        //questiontypelearnmore.setText(MessageProperties.GL0291);
        contenttext.setText(MessageProperties.GL0292);
        contenttextlbl.setText(MessageProperties.GL0293);
        mobileLearnMore.setText(MessageProperties.GL0294);
        questiontxt.setHTML(MessageProperties.GL0298);
        lblSupportLink.setText(MessageProperties.GL0299);
        termsofuselbl.setText(MessageProperties.GL0295);
        termsofusetxt.setText(MessageProperties.GL0296);
        termsofuselearnmore.setText(MessageProperties.GL0294);
        termsofuselearnmore.getElement().setId("lnkLearnMore");
        lblSupportLink.getElement().setId("lnkSupports");
        mobileLearnMore.getElement().setId("lnkContent");
        mIcon.setUrl("images/mos/ipadFriendly.png");
        contenttextlbl1.setText(MessageProperties.GL0293_1);
        
        AppClientFactory.getInjector().getHomeService().whatsNewFibLink(new SimpleAsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {
				termsofuselearnmore.setHref(result);
			}
		});
        
        AppClientFactory.getInjector().getHomeService().whatsNewMosLink(new SimpleAsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {
				mobileLearnMore.setHref(result);
			}
		});
	}
	/**
	 * 
	 * @function oncloseButton 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : UIHandler for closeButton.
	 * 
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("closeButton")
	public void oncloseButton(ClickEvent clickEvent) {
		MixpanelUtil.New_in_Gooru_x();
		this.removeFromParent();
		Window.enableScrolling(true);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
	}
	/**
	 * 
	 * @function ontermsofuselearnmore 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :termsofuselearnmore UIHandlers.
	 * 
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("termsofuselearnmore")
	public void ontermsofuselearnmore(ClickEvent clickEvent) {
		MixpanelUtil.New_in_Gooru_FIB_link();
	}
	/**
	 * 
	 * @function oncontentlearnmore 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :mobileLearnMore UIHandler.
	 * 
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("mobileLearnMore")
	public void oncontentlearnmore(ClickEvent clickEvent) {
		MixpanelUtil.New_in_Gooru_MOS_link();
	}
}

