package org.ednovo.gooru.client.mvp.home.library;

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

public class LibraryBannerView_LibraryBannerViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.home.library.LibraryBannerView>, org.ednovo.gooru.client.mvp.home.library.LibraryBannerView.LibraryBannerViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("")
    SafeHtml html2();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html3(String arg0);
     
    @Template("")
    SafeHtml html4();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html5(String arg0, String arg1);
     
    @Template("")
    SafeHtml html6();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html7(String arg0);
     
    @Template("")
    SafeHtml html8();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html9(String arg0, String arg1);
     
    @Template("")
    SafeHtml html10();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html11(String arg0);
     
    @Template("")
    SafeHtml html12();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html13(String arg0, String arg1);
     
    @Template("")
    SafeHtml html14();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html15(String arg0);
     
    @Template("")
    SafeHtml html16();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html17(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html18(String arg0, String arg1, String arg2, String arg3);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html19(String arg0, String arg1, String arg2, String arg3);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.home.library.LibraryBannerView owner) {


    return new Widgets(owner).get_landingBannerInner();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.home.library.LibraryBannerView owner;


    public Widgets(final org.ednovo.gooru.client.mvp.home.library.LibraryBannerView owner) {
      this.owner = owner;
      build_libraryStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId14();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId18();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId15();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId17();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId19();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId16();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId14Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId18Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId15Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId17Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId19Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId16Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2();
    }
    SafeHtml template_html3() {
      return template.html3(get_domId6());
    }
    SafeHtml template_html4() {
      return template.html4();
    }
    SafeHtml template_html5() {
      return template.html5(get_domId5(), get_domId7());
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
      return template.html10();
    }
    SafeHtml template_html11() {
      return template.html11(get_domId14());
    }
    SafeHtml template_html12() {
      return template.html12();
    }
    SafeHtml template_html13() {
      return template.html13(get_domId13(), get_domId15());
    }
    SafeHtml template_html14() {
      return template.html14();
    }
    SafeHtml template_html15() {
      return template.html15(get_domId18());
    }
    SafeHtml template_html16() {
      return template.html16();
    }
    SafeHtml template_html17() {
      return template.html17(get_domId17(), get_domId19());
    }
    SafeHtml template_html18() {
      return template.html18(get_domId4(), get_domId8(), get_domId12(), get_domId16());
    }
    SafeHtml template_html19() {
      return template.html19(get_domId0(), get_domId1(), get_domId2(), get_domId3());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.library.LibraryBannerView_LibraryBannerViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.home.library.LibraryBannerView_LibraryBannerViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.home.library.LibraryBannerView_LibraryBannerViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.home.library.LibraryBannerView_LibraryBannerViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.home.library.LibraryBannerView_LibraryBannerViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for libraryStyle called 21 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.library.LibraryBannerView_LibraryBannerViewUiBinderImpl_GenCss_libraryStyle libraryStyle;
    private org.ednovo.gooru.client.mvp.home.library.LibraryBannerView_LibraryBannerViewUiBinderImpl_GenCss_libraryStyle get_libraryStyle() {
      return libraryStyle;
    }
    private org.ednovo.gooru.client.mvp.home.library.LibraryBannerView_LibraryBannerViewUiBinderImpl_GenCss_libraryStyle build_libraryStyle() {
      // Creation section.
      libraryStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().libraryStyle();
      // Setup section.
      libraryStyle.ensureInjected();


      owner.libraryStyle = libraryStyle;

      return libraryStyle;
    }

    /**
     * Getter for landingBannerInner called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_landingBannerInner() {
      return build_landingBannerInner();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_landingBannerInner() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel landingBannerInner = new com.google.gwt.user.client.ui.HTMLPanel(template_html19().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1987 = UiBinderUtil.attachToDom(landingBannerInner.getElement());
      get_domId0Element().get();
      get_domId1Element().get();
      get_domId2Element().get();
      get_domId3Element().get();

      // Detach section.
      attachRecord1987.detach();
      landingBannerInner.addAndReplaceElement(get_partnerLogo(), get_domId0Element().get());
      landingBannerInner.addAndReplaceElement(get_headerTag(), get_domId1Element().get());
      landingBannerInner.addAndReplaceElement(get_subHeaderTag(), get_domId2Element().get());
      landingBannerInner.addAndReplaceElement(get_fourSteps(), get_domId3Element().get());

      owner.landingBannerInner = landingBannerInner;

      return landingBannerInner;
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
     * Getter for partnerLogo called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_partnerLogo() {
      return build_partnerLogo();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_partnerLogo() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel partnerLogo = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      partnerLogo.setStyleName("" + get_libraryStyle().partnerLogo() + "");


      owner.partnerLogo = partnerLogo;

      return partnerLogo;
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
     * Getter for headerTag called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_headerTag() {
      return build_headerTag();
    }
    private com.google.gwt.user.client.ui.Label build_headerTag() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label headerTag = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      headerTag.setStyleName("" + get_libraryStyle().header() + "");


      owner.headerTag = headerTag;

      return headerTag;
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

    /**
     * Getter for domId2 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for subHeaderTag called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_subHeaderTag() {
      return build_subHeaderTag();
    }
    private com.google.gwt.user.client.ui.Label build_subHeaderTag() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label subHeaderTag = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      subHeaderTag.setStyleName("" + get_libraryStyle().subheader() + "");


      owner.subHeaderTag = subHeaderTag;

      return subHeaderTag;
    }

    /**
     * Getter for domId2Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
     * Getter for domId3 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for fourSteps called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_fourSteps() {
      return build_fourSteps();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_fourSteps() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel fourSteps = new com.google.gwt.user.client.ui.HTMLPanel(template_html18().asString());
      // Setup section.
      fourSteps.setStyleName("" + get_libraryStyle().fourSteps() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1988 = UiBinderUtil.attachToDom(fourSteps.getElement());
      get_domId4Element().get();
      get_domId8Element().get();
      get_domId12Element().get();
      get_domId16Element().get();

      // Detach section.
      attachRecord1988.detach();
      fourSteps.addAndReplaceElement(get_f_HTMLPanel1(), get_domId4Element().get());
      fourSteps.addAndReplaceElement(get_f_HTMLPanel4(), get_domId8Element().get());
      fourSteps.addAndReplaceElement(get_f_HTMLPanel7(), get_domId12Element().get());
      fourSteps.addAndReplaceElement(get_f_HTMLPanel10(), get_domId16Element().get());

      owner.fourSteps = fourSteps;

      return fourSteps;
    }

    /**
     * Getter for domId4 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.
      f_HTMLPanel1.setStyleName("" + get_libraryStyle().step() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1989 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId5Element().get();
      get_domId7Element().get();

      // Detach section.
      attachRecord1989.detach();
      f_HTMLPanel1.addAndReplaceElement(get_f_HTMLPanel2(), get_domId5Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_findLbl(), get_domId7Element().get());

      return f_HTMLPanel1;
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
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_libraryStyle().libraryBannerImage() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1990 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_domId6Element().get();

      // Detach section.
      attachRecord1990.detach();
      f_HTMLPanel2.addAndReplaceElement(get_f_HTMLPanel3(), get_domId6Element().get());

      return f_HTMLPanel2;
    }

    /**
     * Getter for domId6 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel3 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel3() {
      return build_f_HTMLPanel3();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      f_HTMLPanel3.setStyleName("" + get_libraryStyle().find() + "");


      return f_HTMLPanel3;
    }

    /**
     * Getter for domId6Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for findLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_findLbl() {
      return build_findLbl();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_findLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel findLbl = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      findLbl.setStyleName("" + get_libraryStyle().libraryBannerImageData() + "");


      owner.findLbl = findLbl;

      return findLbl;
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
     * Getter for domId4Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId8 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for f_HTMLPanel4 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel4() {
      return build_f_HTMLPanel4();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel4 = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      f_HTMLPanel4.setStyleName("" + get_libraryStyle().step() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1991 = UiBinderUtil.attachToDom(f_HTMLPanel4.getElement());
      get_domId9Element().get();
      get_domId11Element().get();

      // Detach section.
      attachRecord1991.detach();
      f_HTMLPanel4.addAndReplaceElement(get_f_HTMLPanel5(), get_domId9Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_shareLbl(), get_domId11Element().get());

      return f_HTMLPanel4;
    }

    /**
     * Getter for domId9 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for f_HTMLPanel5 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel5() {
      return build_f_HTMLPanel5();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel5 = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.
      f_HTMLPanel5.setStyleName("" + get_libraryStyle().libraryBannerImage() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1992 = UiBinderUtil.attachToDom(f_HTMLPanel5.getElement());
      get_domId10Element().get();

      // Detach section.
      attachRecord1992.detach();
      f_HTMLPanel5.addAndReplaceElement(get_f_HTMLPanel6(), get_domId10Element().get());

      return f_HTMLPanel5;
    }

    /**
     * Getter for domId10 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel6 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel6() {
      return build_f_HTMLPanel6();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel6() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel6 = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.
      f_HTMLPanel6.setStyleName("" + get_libraryStyle().share() + "");


      return f_HTMLPanel6;
    }

    /**
     * Getter for domId10Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId9Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId11 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for shareLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_shareLbl() {
      return build_shareLbl();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_shareLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel shareLbl = new com.google.gwt.user.client.ui.HTMLPanel(template_html8().asString());
      // Setup section.
      shareLbl.setStyleName("" + get_libraryStyle().libraryBannerImageData() + "");


      owner.shareLbl = shareLbl;

      return shareLbl;
    }

    /**
     * Getter for domId11Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId8Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId12 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for f_HTMLPanel7 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel7() {
      return build_f_HTMLPanel7();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel7() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel7 = new com.google.gwt.user.client.ui.HTMLPanel(template_html13().asString());
      // Setup section.
      f_HTMLPanel7.setStyleName("" + get_libraryStyle().step() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1993 = UiBinderUtil.attachToDom(f_HTMLPanel7.getElement());
      get_domId13Element().get();
      get_domId15Element().get();

      // Detach section.
      attachRecord1993.detach();
      f_HTMLPanel7.addAndReplaceElement(get_f_HTMLPanel8(), get_domId13Element().get());
      f_HTMLPanel7.addAndReplaceElement(get_measureLbl(), get_domId15Element().get());

      return f_HTMLPanel7;
    }

    /**
     * Getter for domId13 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for f_HTMLPanel8 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel8() {
      return build_f_HTMLPanel8();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel8() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel8 = new com.google.gwt.user.client.ui.HTMLPanel(template_html11().asString());
      // Setup section.
      f_HTMLPanel8.setStyleName("" + get_libraryStyle().libraryBannerImage() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1994 = UiBinderUtil.attachToDom(f_HTMLPanel8.getElement());
      get_domId14Element().get();

      // Detach section.
      attachRecord1994.detach();
      f_HTMLPanel8.addAndReplaceElement(get_f_HTMLPanel9(), get_domId14Element().get());

      return f_HTMLPanel8;
    }

    /**
     * Getter for domId14 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel9 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel9() {
      return build_f_HTMLPanel9();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel9() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel9 = new com.google.gwt.user.client.ui.HTMLPanel(template_html10().asString());
      // Setup section.
      f_HTMLPanel9.setStyleName("" + get_libraryStyle().measure() + "");


      return f_HTMLPanel9;
    }

    /**
     * Getter for domId14Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId13Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId15 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for measureLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_measureLbl() {
      return build_measureLbl();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_measureLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel measureLbl = new com.google.gwt.user.client.ui.HTMLPanel(template_html12().asString());
      // Setup section.
      measureLbl.setStyleName("" + get_libraryStyle().libraryBannerImageData() + "");


      owner.measureLbl = measureLbl;

      return measureLbl;
    }

    /**
     * Getter for domId15Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId12Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId16 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for f_HTMLPanel10 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel10() {
      return build_f_HTMLPanel10();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel10() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel10 = new com.google.gwt.user.client.ui.HTMLPanel(template_html17().asString());
      // Setup section.
      f_HTMLPanel10.setStyleName("" + get_libraryStyle().last() + " " + get_libraryStyle().step() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1995 = UiBinderUtil.attachToDom(f_HTMLPanel10.getElement());
      get_domId17Element().get();
      get_domId19Element().get();

      // Detach section.
      attachRecord1995.detach();
      f_HTMLPanel10.addAndReplaceElement(get_f_HTMLPanel11(), get_domId17Element().get());
      f_HTMLPanel10.addAndReplaceElement(get_contributeLbl(), get_domId19Element().get());

      return f_HTMLPanel10;
    }

    /**
     * Getter for domId17 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for f_HTMLPanel11 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel11() {
      return build_f_HTMLPanel11();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel11() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel11 = new com.google.gwt.user.client.ui.HTMLPanel(template_html15().asString());
      // Setup section.
      f_HTMLPanel11.setStyleName("" + get_libraryStyle().libraryBannerImage() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1996 = UiBinderUtil.attachToDom(f_HTMLPanel11.getElement());
      get_domId18Element().get();

      // Detach section.
      attachRecord1996.detach();
      f_HTMLPanel11.addAndReplaceElement(get_f_HTMLPanel12(), get_domId18Element().get());

      return f_HTMLPanel11;
    }

    /**
     * Getter for domId18 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel12 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel12() {
      return build_f_HTMLPanel12();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel12() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel12 = new com.google.gwt.user.client.ui.HTMLPanel(template_html14().asString());
      // Setup section.
      f_HTMLPanel12.setStyleName("" + get_libraryStyle().contribute() + "");


      return f_HTMLPanel12;
    }

    /**
     * Getter for domId18Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId17Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId19 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for contributeLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_contributeLbl() {
      return build_contributeLbl();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_contributeLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel contributeLbl = new com.google.gwt.user.client.ui.HTMLPanel(template_html16().asString());
      // Setup section.
      contributeLbl.setStyleName("" + get_libraryStyle().libraryBannerImageData() + "");


      owner.contributeLbl = contributeLbl;

      return contributeLbl;
    }

    /**
     * Getter for domId19Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId16Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId3Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
  }
}
