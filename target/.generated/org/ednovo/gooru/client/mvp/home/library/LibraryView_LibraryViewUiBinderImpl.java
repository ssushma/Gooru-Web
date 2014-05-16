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

public class LibraryView_LibraryViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.home.library.LibraryView>, org.ednovo.gooru.client.mvp.home.library.LibraryView.LibraryViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("")
    SafeHtml html2();
     
    @Template("")
    SafeHtml html3();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html4(String arg0);
     
    @Template("")
    SafeHtml html5();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html6(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html7(String arg0, String arg1, String arg2);
     
    @Template("")
    SafeHtml html8();
     
    @Template("")
    SafeHtml html9();
     
    @Template("")
    SafeHtml html10();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html11(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span> <span id='{5}'></span>")
    SafeHtml html12(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5);
     
    @Template("")
    SafeHtml html13();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span>")
    SafeHtml html14(String arg0, String arg1, String arg2, String arg3, String arg4);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.home.library.LibraryView owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.home.library.LibraryView owner;


    public Widgets(final org.ednovo.gooru.client.mvp.home.library.LibraryView owner) {
      this.owner = owner;
      build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();  // more than one getter call detected. Type: GENERATED_BUNDLE, precedence: 1
      build_libraryStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_libraryStyleUc();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId16();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId17();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId14();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId15();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId18();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId19();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId16Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId17Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId14Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId15Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId18Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId19Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2();
    }
    SafeHtml template_html3() {
      return template.html3();
    }
    SafeHtml template_html4() {
      return template.html4(get_domId5());
    }
    SafeHtml template_html5() {
      return template.html5();
    }
    SafeHtml template_html6() {
      return template.html6(get_domId7(), get_domId8(), get_domId9());
    }
    SafeHtml template_html7() {
      return template.html7(get_domId11(), get_domId12(), get_domId13());
    }
    SafeHtml template_html8() {
      return template.html8();
    }
    SafeHtml template_html9() {
      return template.html9();
    }
    SafeHtml template_html10() {
      return template.html10();
    }
    SafeHtml template_html11() {
      return template.html11(get_domId16(), get_domId17());
    }
    SafeHtml template_html12() {
      return template.html12(get_domId3(), get_domId4(), get_domId6(), get_domId10(), get_domId14(), get_domId15());
    }
    SafeHtml template_html13() {
      return template.html13();
    }
    SafeHtml template_html14() {
      return template.html14(get_domId0(), get_domId1(), get_domId2(), get_domId18(), get_domId19());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 2 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.library.LibraryView_LibraryViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    private org.ednovo.gooru.client.mvp.home.library.LibraryView_LibraryViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }
    private org.ednovo.gooru.client.mvp.home.library.LibraryView_LibraryViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.home.library.LibraryView_LibraryViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.home.library.LibraryView_LibraryViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for libraryStyle called 10 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.library.LibraryView_LibraryViewUiBinderImpl_GenCss_libraryStyle libraryStyle;
    private org.ednovo.gooru.client.mvp.home.library.LibraryView_LibraryViewUiBinderImpl_GenCss_libraryStyle get_libraryStyle() {
      return libraryStyle;
    }
    private org.ednovo.gooru.client.mvp.home.library.LibraryView_LibraryViewUiBinderImpl_GenCss_libraryStyle build_libraryStyle() {
      // Creation section.
      libraryStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().libraryStyle();
      // Setup section.
      libraryStyle.ensureInjected();


      return libraryStyle;
    }

    /**
     * Getter for libraryStyleUc called 0 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.library.LibraryView_LibraryViewUiBinderImpl_GenCss_libraryStyleUc get_libraryStyleUc() {
      return build_libraryStyleUc();
    }
    private org.ednovo.gooru.client.mvp.home.library.LibraryView_LibraryViewUiBinderImpl_GenCss_libraryStyleUc build_libraryStyleUc() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.home.library.LibraryView_LibraryViewUiBinderImpl_GenCss_libraryStyleUc libraryStyleUc = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().libraryStyleUc();
      // Setup section.
      libraryStyleUc.ensureInjected();


      owner.libraryStyleUc = libraryStyleUc;

      return libraryStyleUc;
    }

    /**
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html14().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1972 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId0Element().get();
      get_domId1Element().get();
      get_domId2Element().get();
      get_domId18Element().get();
      get_domId19Element().get();

      // Detach section.
      attachRecord1972.detach();
      f_HTMLPanel1.addAndReplaceElement(get_courseTabs(), get_domId0Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_landingBanner(), get_domId1Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_container(), get_domId2Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_contributorsContainer(), get_domId18Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_f_FooterUc2(), get_domId19Element().get());

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
     * Getter for courseTabs called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_courseTabs() {
      return build_courseTabs();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_courseTabs() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel courseTabs = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      courseTabs.setStyleName("tabs");


      owner.courseTabs = courseTabs;

      return courseTabs;
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
     * Getter for landingBanner called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_landingBanner() {
      return build_landingBanner();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_landingBanner() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel landingBanner = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.


      owner.landingBanner = landingBanner;

      return landingBanner;
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
     * Getter for container called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_container() {
      return build_container();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_container() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel container = new com.google.gwt.user.client.ui.HTMLPanel(template_html12().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1973 = UiBinderUtil.attachToDom(container.getElement());
      get_domId3Element().get();
      get_domId4Element().get();
      get_domId6Element().get();
      get_domId10Element().get();
      get_domId14Element().get();
      get_domId15Element().get();

      // Detach section.
      attachRecord1973.detach();
      container.addAndReplaceElement(get_featuredCousesLbl(), get_domId3Element().get());
      container.addAndReplaceElement(get_featuredCourseTabs(), get_domId4Element().get());
      container.addAndReplaceElement(get_courseBanner(), get_domId6Element().get());
      container.addAndReplaceElement(get_featuredEducator(), get_domId10Element().get());
      container.addAndReplaceElement(get_leftNav(), get_domId14Element().get());
      container.addAndReplaceElement(get_scrollPanel(), get_domId15Element().get());

      owner.container = container;

      return container;
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
     * Getter for featuredCousesLbl called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_featuredCousesLbl() {
      return build_featuredCousesLbl();
    }
    private com.google.gwt.user.client.ui.Label build_featuredCousesLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label featuredCousesLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      featuredCousesLbl.setStyleName("" + get_libraryStyle().pageTitle() + " " + get_libraryStyle().h2() + "");


      owner.featuredCousesLbl = featuredCousesLbl;

      return featuredCousesLbl;
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
     * Getter for featuredCourseTabs called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_featuredCourseTabs() {
      return build_featuredCourseTabs();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_featuredCourseTabs() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel featuredCourseTabs = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      featuredCourseTabs.setStyleName("tabs");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1974 = UiBinderUtil.attachToDom(featuredCourseTabs.getElement());
      get_domId5Element().get();

      // Detach section.
      attachRecord1974.detach();
      featuredCourseTabs.addAndReplaceElement(get_featuredCourses(), get_domId5Element().get());

      owner.featuredCourseTabs = featuredCourseTabs;

      return featuredCourseTabs;
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
     * Getter for featuredCourses called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_featuredCourses() {
      return build_featuredCourses();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_featuredCourses() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel featuredCourses = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.


      owner.featuredCourses = featuredCourses;

      return featuredCourses;
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
     * Getter for domId6 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for courseBanner called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_courseBanner() {
      return build_courseBanner();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_courseBanner() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel courseBanner = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1975 = UiBinderUtil.attachToDom(courseBanner.getElement());
      get_domId7Element().get();
      get_domId8Element().get();
      get_domId9Element().get();

      // Detach section.
      attachRecord1975.detach();
      courseBanner.addAndReplaceElement(get_partnerLogo(), get_domId7Element().get());
      courseBanner.addAndReplaceElement(get_courseImage(), get_domId8Element().get());
      courseBanner.addAndReplaceElement(get_courseTitle(), get_domId9Element().get());

      owner.courseBanner = courseBanner;

      return courseBanner;
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
     * Getter for partnerLogo called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_partnerLogo() {
      return build_partnerLogo();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_partnerLogo() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel partnerLogo = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.
      partnerLogo.setStyleName("" + get_libraryStyle().partnerLogo() + "");


      owner.partnerLogo = partnerLogo;

      return partnerLogo;
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
     * Getter for domId8 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for courseImage called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Image get_courseImage() {
      return build_courseImage();
    }
    private com.google.gwt.user.client.ui.Image build_courseImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image courseImage = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.


      owner.courseImage = courseImage;

      return courseImage;
    }

    /**
     * Getter for domId8Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for courseTitle called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_courseTitle() {
      return build_courseTitle();
    }
    private com.google.gwt.user.client.ui.Label build_courseTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label courseTitle = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      courseTitle.setStyleName("" + get_libraryStyle().courseTitle() + "");


      owner.courseTitle = courseTitle;

      return courseTitle;
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
     * Getter for domId6Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId10 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for featuredEducator called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_featuredEducator() {
      return build_featuredEducator();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_featuredEducator() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel featuredEducator = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1976 = UiBinderUtil.attachToDom(featuredEducator.getElement());
      get_domId11Element().get();
      get_domId12Element().get();
      get_domId13Element().get();

      // Detach section.
      attachRecord1976.detach();
      featuredEducator.addAndReplaceElement(get_educatorPhoto(), get_domId11Element().get());
      featuredEducator.addAndReplaceElement(get_featuredContributor(), get_domId12Element().get());
      featuredEducator.addAndReplaceElement(get_featuredContributorsLink(), get_domId13Element().get());

      owner.featuredEducator = featuredEducator;

      return featuredEducator;
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
     * Getter for educatorPhoto called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Image get_educatorPhoto() {
      return build_educatorPhoto();
    }
    private com.google.gwt.user.client.ui.Image build_educatorPhoto() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image educatorPhoto = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      educatorPhoto.setStyleName("" + get_libraryStyle().educatorPhoto() + " " + get_libraryStyle().courseContributorAlign() + "");


      owner.educatorPhoto = educatorPhoto;

      return educatorPhoto;
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
     * Getter for featuredContributor called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_featuredContributor() {
      return build_featuredContributor();
    }
    private com.google.gwt.user.client.ui.Label build_featuredContributor() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label featuredContributor = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      featuredContributor.setStyleName("" + get_libraryStyle().courseContributorAlign() + "");


      owner.featuredContributor = featuredContributor;

      return featuredContributor;
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
     * Getter for featuredContributorsLink called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Anchor get_featuredContributorsLink() {
      return build_featuredContributorsLink();
    }
    private com.google.gwt.user.client.ui.Anchor build_featuredContributorsLink() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor featuredContributorsLink = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      featuredContributorsLink.setStyleName("" + get_libraryStyle().courseContributorAlign() + "");


      owner.featuredContributorsLink = featuredContributorsLink;

      return featuredContributorsLink;
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
     * Getter for domId10Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId14 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for leftNav called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_leftNav() {
      return build_leftNav();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_leftNav() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel leftNav = new com.google.gwt.user.client.ui.HTMLPanel(template_html8().asString());
      // Setup section.


      owner.leftNav = leftNav;

      return leftNav;
    }

    /**
     * Getter for domId14Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId15 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for scrollPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_scrollPanel() {
      return build_scrollPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_scrollPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel scrollPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html11().asString());
      // Setup section.
      scrollPanel.setStyleName("" + get_libraryStyle().scrollPanel() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1977 = UiBinderUtil.attachToDom(scrollPanel.getElement());
      get_domId16Element().get();
      get_domId17Element().get();

      // Detach section.
      attachRecord1977.detach();
      scrollPanel.addAndReplaceElement(get_loadingIconPanel(), get_domId16Element().get());
      scrollPanel.addAndReplaceElement(get_contentScroll(), get_domId17Element().get());

      owner.scrollPanel = scrollPanel;

      return scrollPanel;
    }

    /**
     * Getter for domId16 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for loadingIconPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_loadingIconPanel() {
      return build_loadingIconPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_loadingIconPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel loadingIconPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      loadingIconPanel.setStyleName("loadingImage " + get_libraryStyle().loadingIconTopic() + "");


      owner.loadingIconPanel = loadingIconPanel;

      return loadingIconPanel;
    }

    /**
     * Getter for domId16Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for contentScroll called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_contentScroll() {
      return build_contentScroll();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_contentScroll() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel contentScroll = new com.google.gwt.user.client.ui.HTMLPanel(template_html10().asString());
      // Setup section.


      owner.contentScroll = contentScroll;

      return contentScroll;
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
     * Getter for domId15Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId18 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for contributorsContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_contributorsContainer() {
      return build_contributorsContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_contributorsContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel contributorsContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html13().asString());
      // Setup section.


      owner.contributorsContainer = contributorsContainer;

      return contributorsContainer;
    }

    /**
     * Getter for domId18Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
     * Getter for domId19 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for f_FooterUc2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.mvp.home.FooterUc get_f_FooterUc2() {
      return build_f_FooterUc2();
    }
    private org.ednovo.gooru.client.mvp.home.FooterUc build_f_FooterUc2() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.home.FooterUc f_FooterUc2 = (org.ednovo.gooru.client.mvp.home.FooterUc) GWT.create(org.ednovo.gooru.client.mvp.home.FooterUc.class);
      // Setup section.


      return f_FooterUc2;
    }

    /**
     * Getter for domId19Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
  }
}
