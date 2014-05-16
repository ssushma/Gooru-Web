package org.ednovo.gooru.client.mvp.socialshare;

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

public class SentEmailSuccessVc_SentEmailSuccessVcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.socialshare.SentEmailSuccessVc>, org.ednovo.gooru.client.mvp.socialshare.SentEmailSuccessVc.SentEmailSuccessVcUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html2(String arg0);
     
    @Template("")
    SafeHtml html3();
     
    @Template("")
    SafeHtml html4();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html5(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html6(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html7(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html8(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html9(String arg0, String arg1, String arg2, String arg3);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html10(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html11(String arg0);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.socialshare.SentEmailSuccessVc owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.socialshare.SentEmailSuccessVc owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onBtnClick(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.socialshare.SentEmailSuccessVc owner) {
      this.owner = owner;
      build_SocialShare();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2(get_domId2());
    }
    SafeHtml template_html3() {
      return template.html3();
    }
    SafeHtml template_html4() {
      return template.html4();
    }
    SafeHtml template_html5() {
      return template.html5(get_domId11());
    }
    SafeHtml template_html6() {
      return template.html6(get_domId10());
    }
    SafeHtml template_html7() {
      return template.html7(get_domId9());
    }
    SafeHtml template_html8() {
      return template.html8(get_domId8());
    }
    SafeHtml template_html9() {
      return template.html9(get_domId4(), get_domId5(), get_domId6(), get_domId7());
    }
    SafeHtml template_html10() {
      return template.html10(get_domId1(), get_domId3());
    }
    SafeHtml template_html11() {
      return template.html11(get_domId0());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.socialshare.SentEmailSuccessVc_SentEmailSuccessVcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.socialshare.SentEmailSuccessVc_SentEmailSuccessVcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.socialshare.SentEmailSuccessVc_SentEmailSuccessVcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.socialshare.SentEmailSuccessVc_SentEmailSuccessVcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.socialshare.SentEmailSuccessVc_SentEmailSuccessVcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for SocialShare called 12 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.socialshare.SentEmailSuccessVc_SentEmailSuccessVcUiBinderImpl_GenCss_SocialShare SocialShare;
    private org.ednovo.gooru.client.mvp.socialshare.SentEmailSuccessVc_SentEmailSuccessVcUiBinderImpl_GenCss_SocialShare get_SocialShare() {
      return SocialShare;
    }
    private org.ednovo.gooru.client.mvp.socialshare.SentEmailSuccessVc_SentEmailSuccessVcUiBinderImpl_GenCss_SocialShare build_SocialShare() {
      // Creation section.
      SocialShare = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().SocialShare();
      // Setup section.
      SocialShare.ensureInjected();


      return SocialShare;
    }

    /**
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html11().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1442 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId0Element().get();

      // Detach section.
      attachRecord1442.detach();
      f_HTMLPanel1.addAndReplaceElement(get_f_HTMLPanel2(), get_domId0Element().get());

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
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html10().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_SocialShare().classPageEmailPopupContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1443 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_domId1Element().get();
      get_domId3Element().get();

      // Detach section.
      attachRecord1443.detach();
      f_HTMLPanel2.addAndReplaceElement(get_f_HTMLPanel3(), get_domId1Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_f_HTMLPanel4(), get_domId3Element().get());

      return f_HTMLPanel2;
    }

    /**
     * Getter for domId1 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for f_HTMLPanel3 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel3() {
      return build_f_HTMLPanel3();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      f_HTMLPanel3.setStyleName("" + get_SocialShare().classPageEmailHeaderContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1444 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
      get_domId2Element().get();

      // Detach section.
      attachRecord1444.detach();
      f_HTMLPanel3.addAndReplaceElement(get_emailToFriendText(), get_domId2Element().get());

      return f_HTMLPanel3;
    }

    /**
     * Getter for domId2 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId2;
    private java.lang.String get_domId2() {
      return domId2;
    }
    private java.lang.String build_domId2() {
      // Creation section.
      domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId2;
    }

    /**
     * Getter for emailToFriendText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_emailToFriendText() {
      return build_emailToFriendText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_emailToFriendText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel emailToFriendText = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      emailToFriendText.setStyleName("" + get_SocialShare().classPageEmailHeaderDesc() + "");


      owner.emailToFriendText = emailToFriendText;

      return emailToFriendText;
    }

    /**
     * Getter for domId2Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId2Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId2Element() {
      return domId2Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId2Element() {
      // Creation section.
      domId2Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId2());
      // Setup section.


      return domId2Element;
    }

    /**
     * Getter for domId1Element called 2 times. Type: DEFAULT. Build precedence: 3.
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

    /**
     * Getter for domId3 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId3;
    private java.lang.String get_domId3() {
      return domId3;
    }
    private java.lang.String build_domId3() {
      // Creation section.
      domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId3;
    }

    /**
     * Getter for f_HTMLPanel4 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel4() {
      return build_f_HTMLPanel4();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel4 = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      f_HTMLPanel4.setStyleName("" + get_SocialShare().classPageEmailMainContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1445 = UiBinderUtil.attachToDom(f_HTMLPanel4.getElement());
      get_domId4Element().get();
      get_domId5Element().get();
      get_domId6Element().get();
      get_domId7Element().get();

      // Detach section.
      attachRecord1445.detach();
      f_HTMLPanel4.addAndReplaceElement(get_emailSentText(), get_domId4Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_toEmailLbl(), get_domId5Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_f_HTMLPanel5(), get_domId6Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_f_HTMLPanel6(), get_domId7Element().get());

      return f_HTMLPanel4;
    }

    /**
     * Getter for domId4 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId4;
    private java.lang.String get_domId4() {
      return domId4;
    }
    private java.lang.String build_domId4() {
      // Creation section.
      domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId4;
    }

    /**
     * Getter for emailSentText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_emailSentText() {
      return build_emailSentText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_emailSentText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel emailSentText = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      emailSentText.setStyleName("" + get_SocialShare().classPageEmailBlueText() + "");


      owner.emailSentText = emailSentText;

      return emailSentText;
    }

    /**
     * Getter for domId4Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId4Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId4Element() {
      return domId4Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId4Element() {
      // Creation section.
      domId4Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId4());
      // Setup section.


      return domId4Element;
    }

    /**
     * Getter for domId5 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId5;
    private java.lang.String get_domId5() {
      return domId5;
    }
    private java.lang.String build_domId5() {
      // Creation section.
      domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId5;
    }

    /**
     * Getter for toEmailLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_toEmailLbl() {
      return build_toEmailLbl();
    }
    private com.google.gwt.user.client.ui.Label build_toEmailLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label toEmailLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      toEmailLbl.setStyleName("" + get_SocialShare().classPageEmailDescText() + "");


      owner.toEmailLbl = toEmailLbl;

      return toEmailLbl;
    }

    /**
     * Getter for domId5Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId5Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId5Element() {
      return domId5Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId5Element() {
      // Creation section.
      domId5Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId5());
      // Setup section.


      return domId5Element;
    }

    /**
     * Getter for domId6 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId6;
    private java.lang.String get_domId6() {
      return domId6;
    }
    private java.lang.String build_domId6() {
      // Creation section.
      domId6 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId6;
    }

    /**
     * Getter for f_HTMLPanel5 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel5() {
      return build_f_HTMLPanel5();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel5 = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      f_HTMLPanel5.setStyleName("" + get_SocialShare().clear() + "");


      return f_HTMLPanel5;
    }

    /**
     * Getter for domId6Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId6Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId6Element() {
      return domId6Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId6Element() {
      // Creation section.
      domId6Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId6());
      // Setup section.


      return domId6Element;
    }

    /**
     * Getter for domId7 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId7;
    private java.lang.String get_domId7() {
      return domId7;
    }
    private java.lang.String build_domId7() {
      // Creation section.
      domId7 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId7;
    }

    /**
     * Getter for f_HTMLPanel6 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel6() {
      return build_f_HTMLPanel6();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel6() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel6 = new com.google.gwt.user.client.ui.HTMLPanel(template_html8().asString());
      // Setup section.
      f_HTMLPanel6.setStyleName("" + get_SocialShare().classPageEmailButtonOuterDiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1446 = UiBinderUtil.attachToDom(f_HTMLPanel6.getElement());
      get_domId8Element().get();

      // Detach section.
      attachRecord1446.detach();
      f_HTMLPanel6.addAndReplaceElement(get_f_HTMLPanel7(), get_domId8Element().get());

      return f_HTMLPanel6;
    }

    /**
     * Getter for domId8 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId8;
    private java.lang.String get_domId8() {
      return domId8;
    }
    private java.lang.String build_domId8() {
      // Creation section.
      domId8 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId8;
    }

    /**
     * Getter for f_HTMLPanel7 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel7() {
      return build_f_HTMLPanel7();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel7() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel7 = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.
      f_HTMLPanel7.setStyleName("" + get_SocialShare().classPageEmailButtonContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1447 = UiBinderUtil.attachToDom(f_HTMLPanel7.getElement());
      get_domId9Element().get();

      // Detach section.
      attachRecord1447.detach();
      f_HTMLPanel7.addAndReplaceElement(get_f_HTMLPanel8(), get_domId9Element().get());

      return f_HTMLPanel7;
    }

    /**
     * Getter for domId9 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId9;
    private java.lang.String get_domId9() {
      return domId9;
    }
    private java.lang.String build_domId9() {
      // Creation section.
      domId9 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId9;
    }

    /**
     * Getter for f_HTMLPanel8 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel8() {
      return build_f_HTMLPanel8();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel8() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel8 = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.
      f_HTMLPanel8.setStyleName("" + get_SocialShare().classPageEmailButtonBg() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1448 = UiBinderUtil.attachToDom(f_HTMLPanel8.getElement());
      get_domId10Element().get();

      // Detach section.
      attachRecord1448.detach();
      f_HTMLPanel8.addAndReplaceElement(get_f_HTMLPanel9(), get_domId10Element().get());

      return f_HTMLPanel8;
    }

    /**
     * Getter for domId10 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId10;
    private java.lang.String get_domId10() {
      return domId10;
    }
    private java.lang.String build_domId10() {
      // Creation section.
      domId10 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId10;
    }

    /**
     * Getter for f_HTMLPanel9 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel9() {
      return build_f_HTMLPanel9();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel9() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel9 = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.
      f_HTMLPanel9.setStyleName("" + get_SocialShare().classPageEmailButtonTitle() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1449 = UiBinderUtil.attachToDom(f_HTMLPanel9.getElement());
      get_domId11Element().get();

      // Detach section.
      attachRecord1449.detach();
      f_HTMLPanel9.addAndReplaceElement(get_okLbl(), get_domId11Element().get());

      return f_HTMLPanel9;
    }

    /**
     * Getter for domId11 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
     */
    private java.lang.String domId11;
    private java.lang.String get_domId11() {
      return domId11;
    }
    private java.lang.String build_domId11() {
      // Creation section.
      domId11 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId11;
    }

    /**
     * Getter for okLbl called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Label get_okLbl() {
      return build_okLbl();
    }
    private com.google.gwt.user.client.ui.Label build_okLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label okLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      okLbl.setStyleName("" + get_SocialShare().classPageEmailOktext() + "");
      okLbl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.okLbl = okLbl;

      return okLbl;
    }

    /**
     * Getter for domId11Element called 2 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId11Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId11Element() {
      return domId11Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId11Element() {
      // Creation section.
      domId11Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId11());
      // Setup section.


      return domId11Element;
    }

    /**
     * Getter for domId10Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId10Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId10Element() {
      return domId10Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId10Element() {
      // Creation section.
      domId10Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId10());
      // Setup section.


      return domId10Element;
    }

    /**
     * Getter for domId9Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId9Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId9Element() {
      return domId9Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId9Element() {
      // Creation section.
      domId9Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId9());
      // Setup section.


      return domId9Element;
    }

    /**
     * Getter for domId8Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId8Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId8Element() {
      return domId8Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId8Element() {
      // Creation section.
      domId8Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId8());
      // Setup section.


      return domId8Element;
    }

    /**
     * Getter for domId7Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId7Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId7Element() {
      return domId7Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId7Element() {
      // Creation section.
      domId7Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId7());
      // Setup section.


      return domId7Element;
    }

    /**
     * Getter for domId3Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId3Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId3Element() {
      return domId3Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId3Element() {
      // Creation section.
      domId3Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId3());
      // Setup section.


      return domId3Element;
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
  }
}
