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

public class SocialShareView_SocialShareViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.socialshare.SocialShareView>, org.ednovo.gooru.client.mvp.socialshare.SocialShareView.SocialShareViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html2(String arg0);
     
    @Template("")
    SafeHtml html3();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html4(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html5(String arg0);
     
    @Template("")
    SafeHtml html6();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html7(String arg0);
     
    @Template("")
    SafeHtml html8();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html9(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html10(String arg0);
     
    @Template("")
    SafeHtml html11();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html12(String arg0);
     
    @Template("")
    SafeHtml html13();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html14(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html15(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html16(String arg0, String arg1, String arg2);
     
    @Template("")
    SafeHtml html17();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html18(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html19(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html20(String arg0);
     
    @Template("")
    SafeHtml html21();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html22(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html23(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html24(String arg0);
     
    @Template("")
    SafeHtml html25();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html26(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html27(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html28(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html29(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html30(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html31(String arg0);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.socialshare.SocialShareView owner) {


    return new Widgets(owner).get_socialShareContainer();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.socialshare.SocialShareView owner;


    final com.google.gwt.event.dom.client.ErrorHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ErrorHandler() {
      public void onError(com.google.gwt.event.dom.client.ErrorEvent event) {
        owner.setDefaultImage(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onFbClickEvent(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onFbIconClickEvent(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onEmailClickEvent(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onEmailIconClickEvent(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onTwitterClickEvent(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onTwitterIconClickEvent(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.socialshare.SocialShareView owner) {
      this.owner = owner;
      build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();  // more than one getter call detected. Type: GENERATED_BUNDLE, precedence: 1
      build_SocialShare();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_socialShareStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId15();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId21();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId25();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId29();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId14();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId16();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId20();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId24();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId28();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId19();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId23();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId27();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId18();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId22();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId26();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId17();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId30();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId15Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId21Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId25Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId29Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId14Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId16Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId20Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId24Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId28Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId19Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId23Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId27Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId18Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId22Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId26Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId17Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId30Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2(get_domId5());
    }
    SafeHtml template_html3() {
      return template.html3();
    }
    SafeHtml template_html4() {
      return template.html4(get_domId4(), get_domId6());
    }
    SafeHtml template_html5() {
      return template.html5(get_domId3());
    }
    SafeHtml template_html6() {
      return template.html6();
    }
    SafeHtml template_html7() {
      return template.html7(get_domId10());
    }
    SafeHtml template_html8() {
      return template.html8();
    }
    SafeHtml template_html9() {
      return template.html9(get_domId9(), get_domId11());
    }
    SafeHtml template_html10() {
      return template.html10(get_domId8());
    }
    SafeHtml template_html11() {
      return template.html11();
    }
    SafeHtml template_html12() {
      return template.html12(get_domId15());
    }
    SafeHtml template_html13() {
      return template.html13();
    }
    SafeHtml template_html14() {
      return template.html14(get_domId14(), get_domId16());
    }
    SafeHtml template_html15() {
      return template.html15(get_domId13());
    }
    SafeHtml template_html16() {
      return template.html16(get_domId2(), get_domId7(), get_domId12());
    }
    SafeHtml template_html17() {
      return template.html17();
    }
    SafeHtml template_html18() {
      return template.html18(get_domId21());
    }
    SafeHtml template_html19() {
      return template.html19(get_domId20());
    }
    SafeHtml template_html20() {
      return template.html20(get_domId19());
    }
    SafeHtml template_html21() {
      return template.html21();
    }
    SafeHtml template_html22() {
      return template.html22(get_domId25());
    }
    SafeHtml template_html23() {
      return template.html23(get_domId24());
    }
    SafeHtml template_html24() {
      return template.html24(get_domId23());
    }
    SafeHtml template_html25() {
      return template.html25();
    }
    SafeHtml template_html26() {
      return template.html26(get_domId29());
    }
    SafeHtml template_html27() {
      return template.html27(get_domId28());
    }
    SafeHtml template_html28() {
      return template.html28(get_domId27());
    }
    SafeHtml template_html29() {
      return template.html29(get_domId18(), get_domId22(), get_domId26());
    }
    SafeHtml template_html30() {
      return template.html30(get_domId1(), get_domId17(), get_domId30());
    }
    SafeHtml template_html31() {
      return template.html31(get_domId0());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 2 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.socialshare.SocialShareView_SocialShareViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    private org.ednovo.gooru.client.mvp.socialshare.SocialShareView_SocialShareViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }
    private org.ednovo.gooru.client.mvp.socialshare.SocialShareView_SocialShareViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.socialshare.SocialShareView_SocialShareViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.socialshare.SocialShareView_SocialShareViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for SocialShare called 40 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.socialshare.SocialShareView_SocialShareViewUiBinderImpl_GenCss_SocialShare SocialShare;
    private org.ednovo.gooru.client.mvp.socialshare.SocialShareView_SocialShareViewUiBinderImpl_GenCss_SocialShare get_SocialShare() {
      return SocialShare;
    }
    private org.ednovo.gooru.client.mvp.socialshare.SocialShareView_SocialShareViewUiBinderImpl_GenCss_SocialShare build_SocialShare() {
      // Creation section.
      SocialShare = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().SocialShare();
      // Setup section.
      SocialShare.ensureInjected();


      return SocialShare;
    }

    /**
     * Getter for socialShareStyle called 0 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.socialshare.SocialShareView_SocialShareViewUiBinderImpl_GenCss_socialShareStyle get_socialShareStyle() {
      return build_socialShareStyle();
    }
    private org.ednovo.gooru.client.mvp.socialshare.SocialShareView_SocialShareViewUiBinderImpl_GenCss_socialShareStyle build_socialShareStyle() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.socialshare.SocialShareView_SocialShareViewUiBinderImpl_GenCss_socialShareStyle socialShareStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().socialShareStyle();
      // Setup section.
      socialShareStyle.ensureInjected();


      owner.socialShareStyle = socialShareStyle;

      return socialShareStyle;
    }

    /**
     * Getter for res called 0 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.classpages.studentView.AssignmentsViewCBundle get_res() {
      return build_res();
    }
    private org.ednovo.gooru.client.mvp.classpages.studentView.AssignmentsViewCBundle build_res() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.classpages.studentView.AssignmentsViewCBundle res = (org.ednovo.gooru.client.mvp.classpages.studentView.AssignmentsViewCBundle) GWT.create(org.ednovo.gooru.client.mvp.classpages.studentView.AssignmentsViewCBundle.class);
      // Setup section.


      return res;
    }

    /**
     * Getter for socialShareContainer called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_socialShareContainer() {
      return build_socialShareContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_socialShareContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel socialShareContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html31().asString());
      // Setup section.
      socialShareContainer.setStyleName("" + get_SocialShare().classPageShareContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1253 = UiBinderUtil.attachToDom(socialShareContainer.getElement());
      get_domId0Element().get();

      // Detach section.
      attachRecord1253.detach();
      socialShareContainer.addAndReplaceElement(get_f_HTMLPanel1(), get_domId0Element().get());

      owner.socialShareContainer = socialShareContainer;

      return socialShareContainer;
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
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html30().asString());
      // Setup section.
      f_HTMLPanel1.setStyleName("" + get_SocialShare().classPageShareButtonsContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1254 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId1Element().get();
      get_domId17Element().get();
      get_domId30Element().get();

      // Detach section.
      attachRecord1254.detach();
      f_HTMLPanel1.addAndReplaceElement(get_shareTextPanel(), get_domId1Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_shareIconPanel(), get_domId17Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_categoryImage(), get_domId30Element().get());

      return f_HTMLPanel1;
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
     * Getter for shareTextPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_shareTextPanel() {
      return build_shareTextPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_shareTextPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel shareTextPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html16().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1255 = UiBinderUtil.attachToDom(shareTextPanel.getElement());
      get_domId2Element().get();
      get_domId7Element().get();
      get_domId12Element().get();

      // Detach section.
      attachRecord1255.detach();
      shareTextPanel.addAndReplaceElement(get_f_HTMLPanel2(), get_domId2Element().get());
      shareTextPanel.addAndReplaceElement(get_twitterPanel(), get_domId7Element().get());
      shareTextPanel.addAndReplaceElement(get_emailPanel(), get_domId12Element().get());

      owner.shareTextPanel = shareTextPanel;

      return shareTextPanel;
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
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_SocialShare().classPageShareButtonsOuterDiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1256 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_domId3Element().get();

      // Detach section.
      attachRecord1256.detach();
      f_HTMLPanel2.addAndReplaceElement(get_fbPanel(), get_domId3Element().get());

      return f_HTMLPanel2;
    }

    /**
     * Getter for domId3 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for fbPanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_fbPanel() {
      return build_fbPanel();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_fbPanel() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel fbPanel = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html4().asString());
      // Setup section.
      fbPanel.setStyleName("" + get_SocialShare().fbPageShareButtonsBg() + "");
      fbPanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1257 = UiBinderUtil.attachToDom(fbPanel.getElement());
      get_domId4Element().get();
      get_domId6Element().get();

      // Detach section.
      attachRecord1257.detach();
      fbPanel.addAndReplaceElement(get_f_HTMLPanel3(), get_domId4Element().get());
      fbPanel.addAndReplaceElement(get_facbookText(), get_domId6Element().get());

      owner.fbPanel = fbPanel;

      return fbPanel;
    }

    /**
     * Getter for domId4 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for f_HTMLPanel3 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel3() {
      return build_f_HTMLPanel3();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      f_HTMLPanel3.setStyleName("" + get_SocialShare().classPageShareButtonSpriteOuterDiv() + " " + get_SocialShare().classPageShareButtonSpriteAlign() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1258 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
      get_domId5Element().get();

      // Detach section.
      attachRecord1258.detach();
      f_HTMLPanel3.addAndReplaceElement(get_f_HTMLPanel4(), get_domId5Element().get());

      return f_HTMLPanel3;
    }

    /**
     * Getter for domId5 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for f_HTMLPanel4 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel4() {
      return build_f_HTMLPanel4();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel4 = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      f_HTMLPanel4.setStyleName("" + get_SocialShare().classPageShareButtonsSprite() + " " + get_SocialShare().classPageShareButtonSpriteFacebook() + "");


      return f_HTMLPanel4;
    }

    /**
     * Getter for domId5Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId4Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId6 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for facbookText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_facbookText() {
      return build_facbookText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_facbookText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel facbookText = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      facbookText.setStyleName("" + get_SocialShare().classPageShareButtonsBgDesc() + "");


      owner.facbookText = facbookText;

      return facbookText;
    }

    /**
     * Getter for domId6Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId3Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for twitterPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_twitterPanel() {
      return build_twitterPanel();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_twitterPanel() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel twitterPanel = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html10().asString());
      // Setup section.
      twitterPanel.setStyleName("" + get_SocialShare().classPageShareButtonsOuterDiv() + "");
      twitterPanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1259 = UiBinderUtil.attachToDom(twitterPanel.getElement());
      get_domId8Element().get();

      // Detach section.
      attachRecord1259.detach();
      twitterPanel.addAndReplaceElement(get_panelTwitter(), get_domId8Element().get());

      owner.twitterPanel = twitterPanel;

      return twitterPanel;
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
     * Getter for panelTwitter called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelTwitter() {
      return build_panelTwitter();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelTwitter() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelTwitter = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      panelTwitter.setStyleName("" + get_SocialShare().twitterPageShareButtonsBg() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1260 = UiBinderUtil.attachToDom(panelTwitter.getElement());
      get_domId9Element().get();
      get_domId11Element().get();

      // Detach section.
      attachRecord1260.detach();
      panelTwitter.addAndReplaceElement(get_f_HTMLPanel5(), get_domId9Element().get());
      panelTwitter.addAndReplaceElement(get_twitterText(), get_domId11Element().get());

      owner.panelTwitter = panelTwitter;

      return panelTwitter;
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
     * Getter for f_HTMLPanel5 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel5() {
      return build_f_HTMLPanel5();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel5 = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.
      f_HTMLPanel5.setStyleName("" + get_SocialShare().classPageShareButtonSpriteOuterDiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1261 = UiBinderUtil.attachToDom(f_HTMLPanel5.getElement());
      get_domId10Element().get();

      // Detach section.
      attachRecord1261.detach();
      f_HTMLPanel5.addAndReplaceElement(get_f_HTMLPanel6(), get_domId10Element().get());

      return f_HTMLPanel5;
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
     * Getter for f_HTMLPanel6 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel6() {
      return build_f_HTMLPanel6();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel6() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel6 = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.
      f_HTMLPanel6.setStyleName("" + get_SocialShare().classPageShareButtonsSprite() + " " + get_SocialShare().classPageShareButtonSpriteTwitter() + "");


      return f_HTMLPanel6;
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
     * Getter for domId11 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for twitterText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_twitterText() {
      return build_twitterText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_twitterText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel twitterText = new com.google.gwt.user.client.ui.HTMLPanel(template_html8().asString());
      // Setup section.
      twitterText.setStyleName("" + get_SocialShare().classPageShareButtonsBgDesc() + "");


      owner.twitterText = twitterText;

      return twitterText;
    }

    /**
     * Getter for domId11Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId12 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId12;
    private java.lang.String get_domId12() {
      return domId12;
    }
    private java.lang.String build_domId12() {
      // Creation section.
      domId12 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId12;
    }

    /**
     * Getter for emailPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_emailPanel() {
      return build_emailPanel();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_emailPanel() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel emailPanel = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html15().asString());
      // Setup section.
      emailPanel.setStyleName("" + get_SocialShare().classPageShareButtonsOuterDiv() + "");
      emailPanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1262 = UiBinderUtil.attachToDom(emailPanel.getElement());
      get_domId13Element().get();

      // Detach section.
      attachRecord1262.detach();
      emailPanel.addAndReplaceElement(get_panelEmail(), get_domId13Element().get());

      owner.emailPanel = emailPanel;

      return emailPanel;
    }

    /**
     * Getter for domId13 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId13;
    private java.lang.String get_domId13() {
      return domId13;
    }
    private java.lang.String build_domId13() {
      // Creation section.
      domId13 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId13;
    }

    /**
     * Getter for panelEmail called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelEmail() {
      return build_panelEmail();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelEmail() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelEmail = new com.google.gwt.user.client.ui.HTMLPanel(template_html14().asString());
      // Setup section.
      panelEmail.setStyleName("" + get_SocialShare().classPageShareButtonsBg() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1263 = UiBinderUtil.attachToDom(panelEmail.getElement());
      get_domId14Element().get();
      get_domId16Element().get();

      // Detach section.
      attachRecord1263.detach();
      panelEmail.addAndReplaceElement(get_f_HTMLPanel7(), get_domId14Element().get());
      panelEmail.addAndReplaceElement(get_emailText(), get_domId16Element().get());

      owner.panelEmail = panelEmail;

      return panelEmail;
    }

    /**
     * Getter for domId14 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId14;
    private java.lang.String get_domId14() {
      return domId14;
    }
    private java.lang.String build_domId14() {
      // Creation section.
      domId14 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId14;
    }

    /**
     * Getter for f_HTMLPanel7 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel7() {
      return build_f_HTMLPanel7();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel7() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel7 = new com.google.gwt.user.client.ui.HTMLPanel(template_html12().asString());
      // Setup section.
      f_HTMLPanel7.setStyleName("" + get_SocialShare().classPageShareButtonSpriteOuterDiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1264 = UiBinderUtil.attachToDom(f_HTMLPanel7.getElement());
      get_domId15Element().get();

      // Detach section.
      attachRecord1264.detach();
      f_HTMLPanel7.addAndReplaceElement(get_f_HTMLPanel8(), get_domId15Element().get());

      return f_HTMLPanel7;
    }

    /**
     * Getter for domId15 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId15;
    private java.lang.String get_domId15() {
      return domId15;
    }
    private java.lang.String build_domId15() {
      // Creation section.
      domId15 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId15;
    }

    /**
     * Getter for f_HTMLPanel8 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel8() {
      return build_f_HTMLPanel8();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel8() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel8 = new com.google.gwt.user.client.ui.HTMLPanel(template_html11().asString());
      // Setup section.
      f_HTMLPanel8.setStyleName("" + get_SocialShare().classPageShareButtonsSprite() + " " + get_SocialShare().classPageShareButtonSpriteEmail() + "");


      return f_HTMLPanel8;
    }

    /**
     * Getter for domId15Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId15Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId15Element() {
      return domId15Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId15Element() {
      // Creation section.
      domId15Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId15());
      // Setup section.


      return domId15Element;
    }

    /**
     * Getter for domId14Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId14Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId14Element() {
      return domId14Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId14Element() {
      // Creation section.
      domId14Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId14());
      // Setup section.


      return domId14Element;
    }

    /**
     * Getter for domId16 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId16;
    private java.lang.String get_domId16() {
      return domId16;
    }
    private java.lang.String build_domId16() {
      // Creation section.
      domId16 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId16;
    }

    /**
     * Getter for emailText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_emailText() {
      return build_emailText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_emailText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel emailText = new com.google.gwt.user.client.ui.HTMLPanel(template_html13().asString());
      // Setup section.
      emailText.setStyleName("" + get_SocialShare().classPageShareButtonsBgDesc() + "");


      owner.emailText = emailText;

      return emailText;
    }

    /**
     * Getter for domId16Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId16Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId16Element() {
      return domId16Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId16Element() {
      // Creation section.
      domId16Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId16());
      // Setup section.


      return domId16Element;
    }

    /**
     * Getter for domId13Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId13Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId13Element() {
      return domId13Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId13Element() {
      // Creation section.
      domId13Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId13());
      // Setup section.


      return domId13Element;
    }

    /**
     * Getter for domId12Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId12Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId12Element() {
      return domId12Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId12Element() {
      // Creation section.
      domId12Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId12());
      // Setup section.


      return domId12Element;
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
     * Getter for domId17 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId17;
    private java.lang.String get_domId17() {
      return domId17;
    }
    private java.lang.String build_domId17() {
      // Creation section.
      domId17 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId17;
    }

    /**
     * Getter for shareIconPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_shareIconPanel() {
      return build_shareIconPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_shareIconPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel shareIconPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html29().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1265 = UiBinderUtil.attachToDom(shareIconPanel.getElement());
      get_domId18Element().get();
      get_domId22Element().get();
      get_domId26Element().get();

      // Detach section.
      attachRecord1265.detach();
      shareIconPanel.addAndReplaceElement(get_fbIconPanel(), get_domId18Element().get());
      shareIconPanel.addAndReplaceElement(get_twIconPanel(), get_domId22Element().get());
      shareIconPanel.addAndReplaceElement(get_emailIconPanel(), get_domId26Element().get());

      owner.shareIconPanel = shareIconPanel;

      return shareIconPanel;
    }

    /**
     * Getter for domId18 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId18;
    private java.lang.String get_domId18() {
      return domId18;
    }
    private java.lang.String build_domId18() {
      // Creation section.
      domId18 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId18;
    }

    /**
     * Getter for fbIconPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_fbIconPanel() {
      return build_fbIconPanel();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_fbIconPanel() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel fbIconPanel = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html20().asString());
      // Setup section.
      fbIconPanel.setStyleName("" + get_SocialShare().classPageShareButtonsOuterDiv() + "");
      fbIconPanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1266 = UiBinderUtil.attachToDom(fbIconPanel.getElement());
      get_domId19Element().get();

      // Detach section.
      attachRecord1266.detach();
      fbIconPanel.addAndReplaceElement(get_panelfbIcon(), get_domId19Element().get());

      owner.fbIconPanel = fbIconPanel;

      return fbIconPanel;
    }

    /**
     * Getter for domId19 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId19;
    private java.lang.String get_domId19() {
      return domId19;
    }
    private java.lang.String build_domId19() {
      // Creation section.
      domId19 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId19;
    }

    /**
     * Getter for panelfbIcon called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelfbIcon() {
      return build_panelfbIcon();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelfbIcon() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelfbIcon = new com.google.gwt.user.client.ui.HTMLPanel(template_html19().asString());
      // Setup section.
      panelfbIcon.setStyleName("" + get_SocialShare().fbPageShareIconButtonsBg() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1267 = UiBinderUtil.attachToDom(panelfbIcon.getElement());
      get_domId20Element().get();

      // Detach section.
      attachRecord1267.detach();
      panelfbIcon.addAndReplaceElement(get_f_HTMLPanel9(), get_domId20Element().get());

      owner.panelfbIcon = panelfbIcon;

      return panelfbIcon;
    }

    /**
     * Getter for domId20 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId20;
    private java.lang.String get_domId20() {
      return domId20;
    }
    private java.lang.String build_domId20() {
      // Creation section.
      domId20 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId20;
    }

    /**
     * Getter for f_HTMLPanel9 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel9() {
      return build_f_HTMLPanel9();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel9() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel9 = new com.google.gwt.user.client.ui.HTMLPanel(template_html18().asString());
      // Setup section.
      f_HTMLPanel9.setStyleName("" + get_SocialShare().classPageShareButtonSpriteOuterDiv() + " " + get_SocialShare().classPageShareButtonSpriteAlign() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1268 = UiBinderUtil.attachToDom(f_HTMLPanel9.getElement());
      get_domId21Element().get();

      // Detach section.
      attachRecord1268.detach();
      f_HTMLPanel9.addAndReplaceElement(get_f_HTMLPanel10(), get_domId21Element().get());

      return f_HTMLPanel9;
    }

    /**
     * Getter for domId21 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId21;
    private java.lang.String get_domId21() {
      return domId21;
    }
    private java.lang.String build_domId21() {
      // Creation section.
      domId21 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId21;
    }

    /**
     * Getter for f_HTMLPanel10 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel10() {
      return build_f_HTMLPanel10();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel10() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel10 = new com.google.gwt.user.client.ui.HTMLPanel(template_html17().asString());
      // Setup section.
      f_HTMLPanel10.setStyleName("" + get_SocialShare().classPageShareButtonsSprite() + " " + get_SocialShare().classPageShareButtonSpriteFacebook() + "");


      return f_HTMLPanel10;
    }

    /**
     * Getter for domId21Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId21Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId21Element() {
      return domId21Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId21Element() {
      // Creation section.
      domId21Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId21());
      // Setup section.


      return domId21Element;
    }

    /**
     * Getter for domId20Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId20Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId20Element() {
      return domId20Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId20Element() {
      // Creation section.
      domId20Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId20());
      // Setup section.


      return domId20Element;
    }

    /**
     * Getter for domId19Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId19Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId19Element() {
      return domId19Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId19Element() {
      // Creation section.
      domId19Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId19());
      // Setup section.


      return domId19Element;
    }

    /**
     * Getter for domId18Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId18Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId18Element() {
      return domId18Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId18Element() {
      // Creation section.
      domId18Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId18());
      // Setup section.


      return domId18Element;
    }

    /**
     * Getter for domId22 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId22;
    private java.lang.String get_domId22() {
      return domId22;
    }
    private java.lang.String build_domId22() {
      // Creation section.
      domId22 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId22;
    }

    /**
     * Getter for twIconPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_twIconPanel() {
      return build_twIconPanel();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_twIconPanel() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel twIconPanel = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html24().asString());
      // Setup section.
      twIconPanel.setStyleName("" + get_SocialShare().classPageShareButtonsOuterDiv() + "");
      twIconPanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1269 = UiBinderUtil.attachToDom(twIconPanel.getElement());
      get_domId23Element().get();

      // Detach section.
      attachRecord1269.detach();
      twIconPanel.addAndReplaceElement(get_panelTwIcon(), get_domId23Element().get());

      owner.twIconPanel = twIconPanel;

      return twIconPanel;
    }

    /**
     * Getter for domId23 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId23;
    private java.lang.String get_domId23() {
      return domId23;
    }
    private java.lang.String build_domId23() {
      // Creation section.
      domId23 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId23;
    }

    /**
     * Getter for panelTwIcon called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelTwIcon() {
      return build_panelTwIcon();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelTwIcon() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelTwIcon = new com.google.gwt.user.client.ui.HTMLPanel(template_html23().asString());
      // Setup section.
      panelTwIcon.setStyleName("" + get_SocialShare().twitterPageShareIconButtonsBg() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1270 = UiBinderUtil.attachToDom(panelTwIcon.getElement());
      get_domId24Element().get();

      // Detach section.
      attachRecord1270.detach();
      panelTwIcon.addAndReplaceElement(get_f_HTMLPanel11(), get_domId24Element().get());

      owner.panelTwIcon = panelTwIcon;

      return panelTwIcon;
    }

    /**
     * Getter for domId24 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId24;
    private java.lang.String get_domId24() {
      return domId24;
    }
    private java.lang.String build_domId24() {
      // Creation section.
      domId24 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId24;
    }

    /**
     * Getter for f_HTMLPanel11 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel11() {
      return build_f_HTMLPanel11();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel11() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel11 = new com.google.gwt.user.client.ui.HTMLPanel(template_html22().asString());
      // Setup section.
      f_HTMLPanel11.setStyleName("" + get_SocialShare().classPageShareButtonSpriteOuterDiv() + " " + get_SocialShare().classPageShareButtonSpriteTAlign() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1271 = UiBinderUtil.attachToDom(f_HTMLPanel11.getElement());
      get_domId25Element().get();

      // Detach section.
      attachRecord1271.detach();
      f_HTMLPanel11.addAndReplaceElement(get_f_HTMLPanel12(), get_domId25Element().get());

      return f_HTMLPanel11;
    }

    /**
     * Getter for domId25 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId25;
    private java.lang.String get_domId25() {
      return domId25;
    }
    private java.lang.String build_domId25() {
      // Creation section.
      domId25 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId25;
    }

    /**
     * Getter for f_HTMLPanel12 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel12() {
      return build_f_HTMLPanel12();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel12() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel12 = new com.google.gwt.user.client.ui.HTMLPanel(template_html21().asString());
      // Setup section.
      f_HTMLPanel12.setStyleName("" + get_SocialShare().classPageShareButtonsSprite() + " " + get_SocialShare().classPageShareButtonSpriteTwitter() + "");


      return f_HTMLPanel12;
    }

    /**
     * Getter for domId25Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId25Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId25Element() {
      return domId25Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId25Element() {
      // Creation section.
      domId25Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId25());
      // Setup section.


      return domId25Element;
    }

    /**
     * Getter for domId24Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId24Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId24Element() {
      return domId24Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId24Element() {
      // Creation section.
      domId24Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId24());
      // Setup section.


      return domId24Element;
    }

    /**
     * Getter for domId23Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId23Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId23Element() {
      return domId23Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId23Element() {
      // Creation section.
      domId23Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId23());
      // Setup section.


      return domId23Element;
    }

    /**
     * Getter for domId22Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId22Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId22Element() {
      return domId22Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId22Element() {
      // Creation section.
      domId22Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId22());
      // Setup section.


      return domId22Element;
    }

    /**
     * Getter for domId26 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId26;
    private java.lang.String get_domId26() {
      return domId26;
    }
    private java.lang.String build_domId26() {
      // Creation section.
      domId26 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId26;
    }

    /**
     * Getter for emailIconPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_emailIconPanel() {
      return build_emailIconPanel();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_emailIconPanel() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel emailIconPanel = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html28().asString());
      // Setup section.
      emailIconPanel.setStyleName("" + get_SocialShare().classPageShareButtonsOuterDiv() + "");
      emailIconPanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1272 = UiBinderUtil.attachToDom(emailIconPanel.getElement());
      get_domId27Element().get();

      // Detach section.
      attachRecord1272.detach();
      emailIconPanel.addAndReplaceElement(get_panelEmailIcon(), get_domId27Element().get());

      owner.emailIconPanel = emailIconPanel;

      return emailIconPanel;
    }

    /**
     * Getter for domId27 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId27;
    private java.lang.String get_domId27() {
      return domId27;
    }
    private java.lang.String build_domId27() {
      // Creation section.
      domId27 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId27;
    }

    /**
     * Getter for panelEmailIcon called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelEmailIcon() {
      return build_panelEmailIcon();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelEmailIcon() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelEmailIcon = new com.google.gwt.user.client.ui.HTMLPanel(template_html27().asString());
      // Setup section.
      panelEmailIcon.setStyleName("" + get_SocialShare().classPageShareButtonsFTEBg() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1273 = UiBinderUtil.attachToDom(panelEmailIcon.getElement());
      get_domId28Element().get();

      // Detach section.
      attachRecord1273.detach();
      panelEmailIcon.addAndReplaceElement(get_f_HTMLPanel13(), get_domId28Element().get());

      owner.panelEmailIcon = panelEmailIcon;

      return panelEmailIcon;
    }

    /**
     * Getter for domId28 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId28;
    private java.lang.String get_domId28() {
      return domId28;
    }
    private java.lang.String build_domId28() {
      // Creation section.
      domId28 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId28;
    }

    /**
     * Getter for f_HTMLPanel13 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel13() {
      return build_f_HTMLPanel13();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel13() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel13 = new com.google.gwt.user.client.ui.HTMLPanel(template_html26().asString());
      // Setup section.
      f_HTMLPanel13.setStyleName("" + get_SocialShare().classPageShareButtonSpriteOuterDiv() + " " + get_SocialShare().classPageShareButtonSpriteEAlign() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1274 = UiBinderUtil.attachToDom(f_HTMLPanel13.getElement());
      get_domId29Element().get();

      // Detach section.
      attachRecord1274.detach();
      f_HTMLPanel13.addAndReplaceElement(get_f_HTMLPanel14(), get_domId29Element().get());

      return f_HTMLPanel13;
    }

    /**
     * Getter for domId29 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId29;
    private java.lang.String get_domId29() {
      return domId29;
    }
    private java.lang.String build_domId29() {
      // Creation section.
      domId29 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId29;
    }

    /**
     * Getter for f_HTMLPanel14 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel14() {
      return build_f_HTMLPanel14();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel14() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel14 = new com.google.gwt.user.client.ui.HTMLPanel(template_html25().asString());
      // Setup section.
      f_HTMLPanel14.setStyleName("" + get_SocialShare().classPageShareButtonsSprite() + " " + get_SocialShare().classPageShareButtonSpriteEmail() + "");


      return f_HTMLPanel14;
    }

    /**
     * Getter for domId29Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId29Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId29Element() {
      return domId29Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId29Element() {
      // Creation section.
      domId29Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId29());
      // Setup section.


      return domId29Element;
    }

    /**
     * Getter for domId28Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId28Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId28Element() {
      return domId28Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId28Element() {
      // Creation section.
      domId28Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId28());
      // Setup section.


      return domId28Element;
    }

    /**
     * Getter for domId27Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId27Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId27Element() {
      return domId27Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId27Element() {
      // Creation section.
      domId27Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId27());
      // Setup section.


      return domId27Element;
    }

    /**
     * Getter for domId26Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId26Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId26Element() {
      return domId26Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId26Element() {
      // Creation section.
      domId26Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId26());
      // Setup section.


      return domId26Element;
    }

    /**
     * Getter for domId17Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId17Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId17Element() {
      return domId17Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId17Element() {
      // Creation section.
      domId17Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId17());
      // Setup section.


      return domId17Element;
    }

    /**
     * Getter for domId30 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId30;
    private java.lang.String get_domId30() {
      return domId30;
    }
    private java.lang.String build_domId30() {
      // Creation section.
      domId30 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId30;
    }

    /**
     * Getter for categoryImage called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Image get_categoryImage() {
      return build_categoryImage();
    }
    private com.google.gwt.user.client.ui.Image build_categoryImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image categoryImage = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      categoryImage.setStyleName("" + get_SocialShare().displayNone() + "");
      categoryImage.addErrorHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.categoryImage = categoryImage;

      return categoryImage;
    }

    /**
     * Getter for domId30Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId30Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId30Element() {
      return domId30Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId30Element() {
      // Creation section.
      domId30Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId30());
      // Setup section.


      return domId30Element;
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
