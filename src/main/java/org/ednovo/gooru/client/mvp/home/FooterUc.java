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

import org.ednovo.gooru.client.GooruCBundle;
import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.faq.CopyRightPolicyVc;
import org.ednovo.gooru.client.mvp.faq.TermsAndPolicyVc;
import org.ednovo.gooru.client.mvp.faq.TermsOfUse;
import org.ednovo.gooru.client.mvp.search.event.SetFooterEvent;
import org.ednovo.gooru.client.mvp.search.event.SetFooterHandler;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : FooterUc.java
 *
 * @description : This file deals with footer.
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
public class FooterUc extends Composite {

	private static FooterUcUiBinder uiBinder = GWT.create(FooterUcUiBinder.class);

	interface FooterUcUiBinder extends UiBinder<Widget, FooterUc> {
	}

	SetFooterHandler setFooter=new SetFooterHandler(){

		@Override
		public void setFooterEvent(String placeName) {
			setMargins(placeName);
		}

		
	};
	
	@UiField(provided = true)
	GooruCBundle res;
	
	@UiField
	Anchor aboutGooruAnr;

	/*@UiField
	Anchor featuresAnr;*/

	@UiField
	Anchor communityAnr;

	@UiField
	Anchor supportAnr;

	@UiField(provided = true)
	Anchor termsAndPolicyAnr;
	
	@UiField(provided = true)
	Anchor privacyAndPolicyAnr;
	
	@UiField(provided = true)
	Anchor copyRightAnr;

	@UiField
	Anchor careersAnr,mixpanelLink;

	@UiField
	Anchor contactUsAnr;
	
	private TermsAndPolicyVc termsAndPolicyVc;
	
	private CopyRightPolicyVc copyRightPolicy;
	
	private TermsOfUse termsOfUse;
	
	
	@UiField
	FlowPanel goorulandingFooterContainer, innerFooterDiv;
	
	
	/**
	 * Class constructor 
	 */
	public FooterUc() {
		this.res = GooruCBundle.INSTANCE;
		res.css().ensureInjected();
		termsAndPolicyVc = new TermsAndPolicyVc(false) {
			
			@Override
			public void openParentPopup() {
				
			}
		};
		termsAndPolicyAnr = new Anchor();
		copyRightAnr = new Anchor();
		privacyAndPolicyAnr=new Anchor();
		copyRightPolicy = new CopyRightPolicyVc() {
			
			@Override
			public void openParentPopup() {
				//No need to set.
			}
		};
		termsOfUse=new TermsOfUse(){

			@Override
			public void openParentPopup() {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		
		/**
		 * Added click handler for showing Privacy Policy popup in footer 
		 **/
		privacyAndPolicyAnr.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.enableScrolling(false);
				AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, false));	
				termsAndPolicyVc.show();
				termsAndPolicyVc.setSize("902px", "300px");
				termsAndPolicyVc.center();
			}
		});
		/**
		 * Added click handler for showing Terms and Conditions popup in footer 
		 **/

		termsAndPolicyAnr.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.enableScrolling(false);
				AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, false));	
				termsOfUse.show();
				termsOfUse.setSize("902px", "300px");
				termsOfUse.center();
			}
		});
		
		/**
		 * Added click handler for showing copy right popup in footer 
		 **/
		copyRightAnr.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Window.enableScrolling(false);
				AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, false));	
				copyRightPolicy.show();
				copyRightPolicy.setSize("902px", "300px");
				copyRightPolicy.center();				
			}
		});

		initWidget(uiBinder.createAndBindUi(this));
		mixpanelLink.setTarget("_blank");
		mixpanelLink.setHref("https://mixpanel.com/f/partner");
	
		aboutGooruAnr.setHref("http://about.goorulearning.org/");
		aboutGooruAnr.setTarget("_blank");
		//featuresAnr.setHref("http://about.goorulearning.org/product/overview/");
		//featuresAnr.setTarget("_blank");
		communityAnr.setHref("http://about.goorulearning.org/community/");
		communityAnr.setTarget("_blank");
		supportAnr.setHref("http://support.goorulearning.org/home");
		supportAnr.setTarget("_blank");
		careersAnr.setHref("http://about.goorulearning.org/about/careers/");
		careersAnr.setTarget("_blank");
		contactUsAnr.setHref("http://about.goorulearning.org/contact/");
		contactUsAnr.setTarget("_blank");
		aboutGooruAnr.getElement().setId("lnkAboutGooru");
		communityAnr.getElement().setId("lnkCommunity");
		supportAnr.getElement().setId("lnkSupport");
		termsAndPolicyAnr.getElement().setId("lnkTermsAndPolicy");
		copyRightAnr.getElement().setId("lnkCopyRight");
		careersAnr.getElement().setId("lnkCareers");
		contactUsAnr.getElement().setId("lnkcontactUs");
		AppClientFactory.getEventBus().addHandler(SetFooterEvent.TYPE,setFooter);
	}
	/**
	 * 
	 * @function setMargins 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : This method is used to set Margins.
	 * 
	 * 
	 * @parm(s) : @param placeName
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setMargins(String placeName){
		goorulandingFooterContainer.getElement().getStyle().clearMargin();
		goorulandingFooterContainer.getElement().getStyle().clearTop();
		goorulandingFooterContainer.getElement().getStyle().clearPosition();
		goorulandingFooterContainer.getElement().getStyle().setDisplay(Display.BLOCK);
		if (placeName.equals(PlaceTokens.FOLDERS) || placeName.equals(PlaceTokens.EDIT_FOLDERS) || placeName.equals(PlaceTokens.SHELF)){
			goorulandingFooterContainer.getElement().getStyle().setMargin(304, Unit.PX);
			goorulandingFooterContainer.getElement().getStyle().setTop(75, Unit.PX);
			goorulandingFooterContainer.getElement().getStyle().setPosition(Position.RELATIVE);
		}else if(placeName.equals(PlaceTokens.TEACH)){
			goorulandingFooterContainer.getElement().getStyle().setMarginTop(220, Unit.PX);
		} else if(placeName.equals(PlaceTokens.PROFILE_PAGE)) {
			goorulandingFooterContainer.getElement().getStyle().setDisplay(Display.NONE);
		}
	}
	
	//For setting the width of the footer from PPP page
	public void setFooterWidth() {
		innerFooterDiv.setWidth("860px");
	}
}
