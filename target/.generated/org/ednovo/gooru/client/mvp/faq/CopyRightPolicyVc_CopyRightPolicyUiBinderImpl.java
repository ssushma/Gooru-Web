package org.ednovo.gooru.client.mvp.faq;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.safehtml.shared.UriUtils;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class CopyRightPolicyVc_CopyRightPolicyUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.faq.CopyRightPolicyVc>, org.ednovo.gooru.client.mvp.faq.CopyRightPolicyVc.CopyRightPolicyUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<div class='{0}'> <div class='{1}'> <div class='{2}'> <span class='{3}'>Copyright Policy</span> </div> <div class='{4}'> <div class='{5}'> <span class='{6}'> CLIENT COPYRIGHT &amp; INTELLECTUAL PROPERTY POLICY </span> </div> <div class='{7}'>Notification of Copyright Infringement:</div> <div class='{8}'> <span class='{9}'> Ednovo, Inc., hereafter referred to as EDNOVO (“ <i>EDNOVO</i> ”) respects the intellectual property rights of others and expects its users to do the same. </span> <span class='{10}'>It is Ednovo’s policy, in appropriate circumstances and at its discretion, to disable and/or terminate the accounts of users who repeatedly infringe or are repeatedly charged with infringing the copyrights or other intellectual property rights of others. User accounts that accrue three Qualifying Infringements will be subject to termination. A “Qualifying Infringement” is defined as (i) receipt of a valid infringement notice that results in the removal of the user’s material or reference or link to material from the Site where no valid counter notice is received or (ii) removal of a user’s material or reference or link to material from the Site, in the absence of a “take-down” notice, because we obtain actual knowledge that the material is infringing or we become aware of facts or circumstances from which the infringing nature of the material is apparent.</span>  <span class='{11}'> In accordance with the Digital Millennium Copyright Act of 1998, the text of which may be found on the U.S. Copyright Office website at http://www.copyright.gov/legislation/dmca.pdf, Ednovo will respond expeditiously to claims of copyright infringement committed using the Ednovo website or application (the “ <i>Sites</i> ”) that are reported to Ednovo’s Designated Copyright Agent, identified in the sample notice below. </span> <span class='{12}'>If you are a copyright owner, or are authorized to act on behalf of one, or authorized to act under any exclusive right under copyright, please report alleged copyright infringements taking place on or through the Sites by completing the following DMCA Notice of Alleged Infringement and delivering it to Ednovo’s Designated Copyright Agent. Upon receipt of the Notice as described below, Ednovo will take whatever action, in its sole discretion, it deems appropriate, including removal of the challenged material from the Sites.</span> <h2 align='JUSTIFY'> <a name='_DV_C19'></a> <i>DMCA Notice of Alleged Infringement (“Notice”)</i> </h2> <span class='{13}'> <i> 1. Identify the copyrighted work that you claim has been infringed, or - if multiple copyrighted works are covered by this Notice - you may provide a representative list of the copyrighted works that you claim have been infringed.</i> </span> <span class='{14}'> <i> 2. Identify the material that you claim is infringing (or to be the subject of infringing activity) and that is to be removed or access to which is to be disabled, and information reasonably sufficient to permit us to locate the material, including at a minimum, if applicable, the URL of the link shown on the Site(s) where such material may be found.</i> </span> <span class='{15}'> <i> 3. Provide your mailing address, telephone number, and, if available, email address.</i> </span> <span class='{16}'> <i> 4. Include both of the following statements in the body of the Notice:</i> </span> <ul> <li> <span class='{17}'> “ <i>I hereby state that I have a good faith belief that the disputed use of the copyrighted material is not authorized by the copyright owner, its agent, or the law (e.g., as a fair use).”</i> </span> </li> <li> <span class='{18}'> “ <i>I hereby state that the information in this Notice is accurate and, under penalty of perjury, that I am the owner, or authorized to act on behalf of the owner, of the copyright or of an exclusive right under the copyright that is allegedly infringed.”</i> </span> </li> </ul> <span class='{19}'> <a name='_DV_C28'></a> <i> 5. Provide your full legal name and your electronic or physical signature.</i> </span> <span class='{20}'> <a name='_DV_C29'></a> <i> Deliver this Notice, with all items completed, to Ednovo’s Designated Copyright Agent:</i> </span> <span class='{21}'> <a name='_DV_C30'></a> Copyright Agent <br> c/o Ednovo <br> Saket Munshaw <br> c/o Ednovo <br> 1032 Elwell Court <br> Palo Alto, CA 94303 <br> dmca@goorulearning.org <br> (650) 331-0219 <br> </span> <span class='{22}'>Notification of Other Intellectual Property (“IP”) Infringement:</span> <span class='{23}'>If you believe that some other IP right of yours is being infringed by a user, please provide Ednovo’s Designated Copyright Agent (specified above) with the following information:</span> <span class='{24}'>1. Your full legal name and your electronic or physical signature.</span> <span class='{25}'>2. Information reasonably sufficient to permit Ednovo to contact you or your authorized agent, including a name, mailing address, telephone number and, if available, an email address. </span> <span class='{26}'> 3. Identification of the IP alleged to have been infringed, including (i) a complete description or explanation of the nature of the IP, (ii) evidence that you own the IP in the relevant jurisdiction, including copies of relevant patents, registrations, certifications or other documentary evidence of your ownership, and (iii) a showing sufficient for Ednovo to determine without unreasonable effort that the IP has been infringed <strike>;</strike> . </span> <span class='{27}'>4. Information reasonably sufficient to permit Ednovo to identify the use being challenged. </span> <span class='{28}'> 5. <i>Include both of the following statements in the body of the Notice:</i> </span> <ul> <li> <span class='{29}'> <a name='_DV_C132'></a> <a name='_DV_M53'></a> <a name='_DV_C134'></a> <a name='_DV_M54'></a> <a name='_DV_C136'></a> <a name='_DV_M55'></a> <a name='_DV_C137'></a> <a name='_DV_M56'></a> <a name='_DV_C139'></a> “ <i>I hereby state</i> that <i>I</i> have not authorized the challenged use, and <i>I</i> have a good <i> <strike>-</strike> </i> faith belief that the challenged use is not authorized by law <i>.” </i> </span> </li> <li> <span class='{30}'> <a name='_DV_C141'></a> <a name='_DV_M57'></a> <a name='_DV_M58'></a> <a name='_DV_C144'></a> <a name='_DV_M59'></a> <a name='_DV_M60'></a> <a name='_DV_M61'></a> <a name='_DV_M62'></a> <a name='_DV_C149'></a> <a name='_DV_M63'></a> “ <i>I hereby state</i> under penalty of perjury that all of the information in the notification is accurate and that <i>I am the owner of</i> the IP, or authorized to act on behalf of the owner <i>of the IP.”</i> </span> </li> </ul> <span class='{31}'> <a name='_DV_M64'></a> Upon receipt of notice as described above, Ednovo will seek to confirm the existence of the IP on the Sites, notify the user who posted the content including the IP, and take whatever action, in its sole discretion, it deems appropriate, including temporary or permanent removal of the IP from the Sites. </span> </div> </div> </div> </div>")
    SafeHtml html1(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15, String arg16, String arg17, String arg18, String arg19, String arg20, String arg21, String arg22, String arg23, String arg24, String arg25, String arg26, String arg27, String arg28, String arg29, String arg30, String arg31);
     
    @Template("OK")
    SafeHtml html2();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html3(String arg0, String arg1);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.faq.CopyRightPolicyVc owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.faq.CopyRightPolicyVc owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.privacyCloseButtonClick(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.faq.CopyRightPolicyVc owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1("" + get_style().termsOfUse() + "", "" + get_style().termsOfUserContainer() + "", "" + get_style().termsOfHeaderTitleDiv() + "", "" + get_style().termsOfUserHeaderText() + "", "" + get_style().termsBodyContainerDiv() + "", "" + get_style().termsOfUserMessageDiv() + "", "" + get_style().termsOfUserMessageText() + "", "" + get_style().termsSubTitle() + "", "" + get_style().termsContentDiv() + "", "" + get_style().termsTextLine() + "", "" + get_style().termsTextLine() + "", "" + get_style().termsTextLine() + "", "" + get_style().termsTextLine() + "", "" + get_style().termsTextLine() + "", "" + get_style().termsTextLine() + "", "" + get_style().termsTextLine() + "", "" + get_style().termsTextLine() + "", "" + get_style().termsTextLine() + "", "" + get_style().termsTextLine() + "", "" + get_style().termsTextLine() + "", "" + get_style().termsTextLine() + "", "" + get_style().termsTextLine() + "", "" + get_style().termsSubTitle() + "", "" + get_style().termsTextLine() + "", "" + get_style().termsTextLine() + "", "" + get_style().termsTextLine() + "", "" + get_style().termsTextLine() + "", "" + get_style().termsTextLine() + "", "" + get_style().termsTextLine() + "", "" + get_style().termsTextLine() + "", "" + get_style().termsTextLine() + "", "" + get_style().termsTextLine() + "");
    }
    SafeHtml template_html2() {
      return template.html2();
    }
    SafeHtml template_html3() {
      return template.html3(get_domId0(), get_domId1());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.faq.CopyRightPolicyVc_CopyRightPolicyUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.faq.CopyRightPolicyVc_CopyRightPolicyUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.faq.CopyRightPolicyVc_CopyRightPolicyUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.faq.CopyRightPolicyVc_CopyRightPolicyUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.faq.CopyRightPolicyVc_CopyRightPolicyUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for style called 35 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.faq.CopyRightPolicyVc_CopyRightPolicyUiBinderImpl_GenCss_style style;
    private org.ednovo.gooru.client.mvp.faq.CopyRightPolicyVc_CopyRightPolicyUiBinderImpl_GenCss_style get_style() {
      return style;
    }
    private org.ednovo.gooru.client.mvp.faq.CopyRightPolicyVc_CopyRightPolicyUiBinderImpl_GenCss_style build_style() {
      // Creation section.
      style = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().style();
      // Setup section.
      style.ensureInjected();


      return style;
    }

    /**
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1903 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId0Element().get();
      get_domId1Element().get();

      // Detach section.
      attachRecord1903.detach();
      f_HTMLPanel1.addAndReplaceElement(get_f_HTML2(), get_domId0Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_f_FlowPanel3(), get_domId1Element().get());

      return f_HTMLPanel1;
    }

    /**
     * Getter for domId0 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
     */
    private java.lang.String domId0;
    private java.lang.String get_domId0() {
      return domId0;
    }
    private java.lang.String build_domId0() {
      // Creation section.
      domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId0;
    }

    /**
     * Getter for f_HTML2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTML get_f_HTML2() {
      return build_f_HTML2();
    }
    private com.google.gwt.user.client.ui.HTML build_f_HTML2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML f_HTML2 = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      f_HTML2.setHTML(template_html1().asString());


      return f_HTML2;
    }

    /**
     * Getter for domId0Element called 2 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId0Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId0Element() {
      return domId0Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId0Element() {
      // Creation section.
      domId0Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId0());
      // Setup section.


      return domId0Element;
    }

    /**
     * Getter for domId1 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
     */
    private java.lang.String domId1;
    private java.lang.String get_domId1() {
      return domId1;
    }
    private java.lang.String build_domId1() {
      // Creation section.
      domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId1;
    }

    /**
     * Getter for f_FlowPanel3 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel3() {
      return build_f_FlowPanel3();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel3 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel3.add(get_termsCloseBtn());
      f_FlowPanel3.setStyleName("" + get_style().termsButtonDiv() + "");


      return f_FlowPanel3;
    }

    /**
     * Getter for termsCloseBtn called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_termsCloseBtn() {
      return build_termsCloseBtn();
    }
    private com.google.gwt.user.client.ui.Button build_termsCloseBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button termsCloseBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      termsCloseBtn.setHTML(template_html2().asString());
      termsCloseBtn.setStyleName("" + get_style().termsCloseButton() + " " + get_style().termsButtonText() + "");
      termsCloseBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.termsCloseBtn = termsCloseBtn;

      return termsCloseBtn;
    }

    /**
     * Getter for domId1Element called 2 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId1Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId1Element() {
      return domId1Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId1Element() {
      // Creation section.
      domId1Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId1());
      // Setup section.


      return domId1Element;
    }
  }
}
