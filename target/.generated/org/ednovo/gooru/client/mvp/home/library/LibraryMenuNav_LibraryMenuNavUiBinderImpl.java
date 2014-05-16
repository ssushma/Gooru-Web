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

public class LibraryMenuNav_LibraryMenuNavUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.home.library.LibraryMenuNav>, org.ednovo.gooru.client.mvp.home.library.LibraryMenuNav.LibraryMenuNavUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html2(String arg0, String arg1);
     
    @Template("")
    SafeHtml html3();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html4(String arg0, String arg1);
     
    @Template("")
    SafeHtml html5();
     
    @Template("<span id='{0}'></span>  <span id='{1}'></span>")
    SafeHtml html6(String arg0, String arg1);
     
    @Template("")
    SafeHtml html7();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html8(String arg0, String arg1);
     
    @Template("")
    SafeHtml html9();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html10(String arg0, String arg1);
     
    @Template("")
    SafeHtml html11();
     
    @Template("<span id='{0}'></span>  <span id='{1}'></span>")
    SafeHtml html12(String arg0, String arg1);
     
    @Template("")
    SafeHtml html13();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span> <span id='{5}'></span> <span id='{6}'></span> <span id='{7}'></span> <span id='{8}'></span>")
    SafeHtml html14(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.home.library.LibraryMenuNav owner) {


    return new Widgets(owner).get_tabsInner();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.home.library.LibraryMenuNav owner;


    public Widgets(final org.ednovo.gooru.client.mvp.home.library.LibraryMenuNav owner) {
      this.owner = owner;
      build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();  // more than one getter call detected. Type: GENERATED_BUNDLE, precedence: 1
      build_libraryStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_libraryStyleUc();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId14();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId15();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId17();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId18();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId16();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId19();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId20();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId14Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId15Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId17Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId18Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId16Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId19Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId20Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2(get_domId2(), get_domId3());
    }
    SafeHtml template_html3() {
      return template.html3();
    }
    SafeHtml template_html4() {
      return template.html4(get_domId5(), get_domId6());
    }
    SafeHtml template_html5() {
      return template.html5();
    }
    SafeHtml template_html6() {
      return template.html6(get_domId8(), get_domId9());
    }
    SafeHtml template_html7() {
      return template.html7();
    }
    SafeHtml template_html8() {
      return template.html8(get_domId11(), get_domId12());
    }
    SafeHtml template_html9() {
      return template.html9();
    }
    SafeHtml template_html10() {
      return template.html10(get_domId14(), get_domId15());
    }
    SafeHtml template_html11() {
      return template.html11();
    }
    SafeHtml template_html12() {
      return template.html12(get_domId17(), get_domId18());
    }
    SafeHtml template_html13() {
      return template.html13();
    }
    SafeHtml template_html14() {
      return template.html14(get_domId0(), get_domId1(), get_domId4(), get_domId7(), get_domId10(), get_domId13(), get_domId16(), get_domId19(), get_domId20());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 2 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.library.LibraryMenuNav_LibraryMenuNavUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    private org.ednovo.gooru.client.mvp.home.library.LibraryMenuNav_LibraryMenuNavUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }
    private org.ednovo.gooru.client.mvp.home.library.LibraryMenuNav_LibraryMenuNavUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.home.library.LibraryMenuNav_LibraryMenuNavUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.home.library.LibraryMenuNav_LibraryMenuNavUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for libraryStyle called 20 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.library.LibraryMenuNav_LibraryMenuNavUiBinderImpl_GenCss_libraryStyle libraryStyle;
    private org.ednovo.gooru.client.mvp.home.library.LibraryMenuNav_LibraryMenuNavUiBinderImpl_GenCss_libraryStyle get_libraryStyle() {
      return libraryStyle;
    }
    private org.ednovo.gooru.client.mvp.home.library.LibraryMenuNav_LibraryMenuNavUiBinderImpl_GenCss_libraryStyle build_libraryStyle() {
      // Creation section.
      libraryStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().libraryStyle();
      // Setup section.
      libraryStyle.ensureInjected();


      return libraryStyle;
    }

    /**
     * Getter for libraryStyleUc called 0 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.library.LibraryMenuNav_LibraryMenuNavUiBinderImpl_GenCss_libraryStyleUc get_libraryStyleUc() {
      return build_libraryStyleUc();
    }
    private org.ednovo.gooru.client.mvp.home.library.LibraryMenuNav_LibraryMenuNavUiBinderImpl_GenCss_libraryStyleUc build_libraryStyleUc() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.home.library.LibraryMenuNav_LibraryMenuNavUiBinderImpl_GenCss_libraryStyleUc libraryStyleUc = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().libraryStyleUc();
      // Setup section.
      libraryStyleUc.ensureInjected();


      owner.libraryStyleUc = libraryStyleUc;

      return libraryStyleUc;
    }

    /**
     * Getter for tabsInner called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_tabsInner() {
      return build_tabsInner();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_tabsInner() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel tabsInner = new com.google.gwt.user.client.ui.HTMLPanel(template_html14().asString());
      // Setup section.
      tabsInner.setStyleName("" + get_libraryStyle().tabsInner() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1980 = UiBinderUtil.attachToDom(tabsInner.getElement());
      get_domId0Element().get();
      get_domId1Element().get();
      get_domId4Element().get();
      get_domId7Element().get();
      get_domId10Element().get();
      get_domId13Element().get();
      get_domId16Element().get();
      get_domId19Element().get();
      get_domId20Element().get();

      // Detach section.
      attachRecord1980.detach();
      tabsInner.addAndReplaceElement(get_featuredCourses(), get_domId0Element().get());
      tabsInner.addAndReplaceElement(get_sciencePanel(), get_domId1Element().get());
      tabsInner.addAndReplaceElement(get_mathPanel(), get_domId4Element().get());
      tabsInner.addAndReplaceElement(get_socialPanel(), get_domId7Element().get());
      tabsInner.addAndReplaceElement(get_elaPanel(), get_domId10Element().get());
      tabsInner.addAndReplaceElement(get_standardPanel(), get_domId13Element().get());
      tabsInner.addAndReplaceElement(get_partnerPanel(), get_domId16Element().get());
      tabsInner.addAndReplaceElement(get_aboutGooruAnr(), get_domId19Element().get());
      tabsInner.addAndReplaceElement(get_dynamicContainer(), get_domId20Element().get());

      owner.tabsInner = tabsInner;

      return tabsInner;
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
     * Getter for featuredCourses called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_featuredCourses() {
      return build_featuredCourses();
    }
    private com.google.gwt.user.client.ui.Label build_featuredCourses() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label featuredCourses = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      featuredCourses.setStyleName("" + get_libraryStyle().tabsLi() + " tabsLi " + get_libraryStyle().singleLink() + " " + get_libraryStyle().active() + "");


      owner.featuredCourses = featuredCourses;

      return featuredCourses;
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
     * Getter for sciencePanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_sciencePanel() {
      return build_sciencePanel();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_sciencePanel() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel sciencePanel = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html2().asString());
      // Setup section.
      sciencePanel.setStyleName("" + get_libraryStyle().tabsLi() + " tabsLi");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1981 = UiBinderUtil.attachToDom(sciencePanel.getElement());
      get_domId2Element().get();
      get_domId3Element().get();

      // Detach section.
      attachRecord1981.detach();
      sciencePanel.addAndReplaceElement(get_scienceText(), get_domId2Element().get());
      sciencePanel.addAndReplaceElement(get_scienceCourses(), get_domId3Element().get());

      owner.sciencePanel = sciencePanel;

      return sciencePanel;
    }

    /**
     * Getter for domId2 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for scienceText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_scienceText() {
      return build_scienceText();
    }
    private com.google.gwt.user.client.ui.Label build_scienceText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label scienceText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.scienceText = scienceText;

      return scienceText;
    }

    /**
     * Getter for domId2Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for scienceCourses called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_scienceCourses() {
      return build_scienceCourses();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_scienceCourses() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel scienceCourses = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      scienceCourses.setStyleName("" + get_libraryStyle().dropdown() + "");


      owner.scienceCourses = scienceCourses;

      return scienceCourses;
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
     * Getter for domId4 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for mathPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_mathPanel() {
      return build_mathPanel();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_mathPanel() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel mathPanel = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html4().asString());
      // Setup section.
      mathPanel.setStyleName("" + get_libraryStyle().tabsLi() + " tabsLi " + get_libraryStyle().math() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1982 = UiBinderUtil.attachToDom(mathPanel.getElement());
      get_domId5Element().get();
      get_domId6Element().get();

      // Detach section.
      attachRecord1982.detach();
      mathPanel.addAndReplaceElement(get_mathText(), get_domId5Element().get());
      mathPanel.addAndReplaceElement(get_mathCourses(), get_domId6Element().get());

      owner.mathPanel = mathPanel;

      return mathPanel;
    }

    /**
     * Getter for domId5 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for mathText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_mathText() {
      return build_mathText();
    }
    private com.google.gwt.user.client.ui.Label build_mathText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label mathText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.mathText = mathText;

      return mathText;
    }

    /**
     * Getter for domId5Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for mathCourses called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_mathCourses() {
      return build_mathCourses();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_mathCourses() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel mathCourses = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      mathCourses.setStyleName("" + get_libraryStyle().dropdown() + "");


      owner.mathCourses = mathCourses;

      return mathCourses;
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
     * Getter for domId4Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
     * Getter for domId7 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for socialPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_socialPanel() {
      return build_socialPanel();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_socialPanel() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel socialPanel = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html6().asString());
      // Setup section.
      socialPanel.setStyleName("" + get_libraryStyle().tabsLi() + " tabsLi");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1983 = UiBinderUtil.attachToDom(socialPanel.getElement());
      get_domId8Element().get();
      get_domId9Element().get();

      // Detach section.
      attachRecord1983.detach();
      socialPanel.addAndReplaceElement(get_socialSciencesText(), get_domId8Element().get());
      socialPanel.addAndReplaceElement(get_socialCourses(), get_domId9Element().get());

      owner.socialPanel = socialPanel;

      return socialPanel;
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
     * Getter for socialSciencesText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_socialSciencesText() {
      return build_socialSciencesText();
    }
    private com.google.gwt.user.client.ui.Label build_socialSciencesText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label socialSciencesText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.socialSciencesText = socialSciencesText;

      return socialSciencesText;
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
     * Getter for domId9 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for socialCourses called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_socialCourses() {
      return build_socialCourses();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_socialCourses() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel socialCourses = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.
      socialCourses.setStyleName("" + get_libraryStyle().dropdown() + "");


      owner.socialCourses = socialCourses;

      return socialCourses;
    }

    /**
     * Getter for domId9Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId7Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
     * Getter for domId10 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for elaPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_elaPanel() {
      return build_elaPanel();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_elaPanel() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel elaPanel = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html8().asString());
      // Setup section.
      elaPanel.setStyleName("" + get_libraryStyle().tabsLi() + " tabsLi");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1984 = UiBinderUtil.attachToDom(elaPanel.getElement());
      get_domId11Element().get();
      get_domId12Element().get();

      // Detach section.
      attachRecord1984.detach();
      elaPanel.addAndReplaceElement(get_languageArtsText(), get_domId11Element().get());
      elaPanel.addAndReplaceElement(get_elaCourses(), get_domId12Element().get());

      owner.elaPanel = elaPanel;

      return elaPanel;
    }

    /**
     * Getter for domId11 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for languageArtsText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_languageArtsText() {
      return build_languageArtsText();
    }
    private com.google.gwt.user.client.ui.Label build_languageArtsText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label languageArtsText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.languageArtsText = languageArtsText;

      return languageArtsText;
    }

    /**
     * Getter for domId11Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for elaCourses called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_elaCourses() {
      return build_elaCourses();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_elaCourses() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel elaCourses = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.
      elaCourses.setStyleName("" + get_libraryStyle().dropdown() + "");


      owner.elaCourses = elaCourses;

      return elaCourses;
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
     * Getter for domId10Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
     * Getter for domId13 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for standardPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_standardPanel() {
      return build_standardPanel();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_standardPanel() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel standardPanel = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html10().asString());
      // Setup section.
      standardPanel.setStyleName("" + get_libraryStyle().tabsLi() + " tabsLi");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1985 = UiBinderUtil.attachToDom(standardPanel.getElement());
      get_domId14Element().get();
      get_domId15Element().get();

      // Detach section.
      attachRecord1985.detach();
      standardPanel.addAndReplaceElement(get_standardsText(), get_domId14Element().get());
      standardPanel.addAndReplaceElement(get_standardData(), get_domId15Element().get());

      owner.standardPanel = standardPanel;

      return standardPanel;
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
     * Getter for standardsText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_standardsText() {
      return build_standardsText();
    }
    private com.google.gwt.user.client.ui.Label build_standardsText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label standardsText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.standardsText = standardsText;

      return standardsText;
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
     * Getter for standardData called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_standardData() {
      return build_standardData();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_standardData() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel standardData = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      standardData.setStyleName("" + get_libraryStyle().dropdown() + "");


      owner.standardData = standardData;

      return standardData;
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
     * Getter for domId13Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
     * Getter for domId16 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for partnerPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_partnerPanel() {
      return build_partnerPanel();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_partnerPanel() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel partnerPanel = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html12().asString());
      // Setup section.
      partnerPanel.setStyleName("" + get_libraryStyle().tabsLi() + " tabsLi");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1986 = UiBinderUtil.attachToDom(partnerPanel.getElement());
      get_domId17Element().get();
      get_domId18Element().get();

      // Detach section.
      attachRecord1986.detach();
      partnerPanel.addAndReplaceElement(get_partnerText(), get_domId17Element().get());
      partnerPanel.addAndReplaceElement(get_partnerLibraries(), get_domId18Element().get());

      owner.partnerPanel = partnerPanel;

      return partnerPanel;
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
     * Getter for partnerText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_partnerText() {
      return build_partnerText();
    }
    private com.google.gwt.user.client.ui.Label build_partnerText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label partnerText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.partnerText = partnerText;

      return partnerText;
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
     * Getter for domId18 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for partnerLibraries called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_partnerLibraries() {
      return build_partnerLibraries();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_partnerLibraries() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel partnerLibraries = new com.google.gwt.user.client.ui.HTMLPanel(template_html11().asString());
      // Setup section.
      partnerLibraries.setStyleName("" + get_libraryStyle().dropdown() + "");


      owner.partnerLibraries = partnerLibraries;

      return partnerLibraries;
    }

    /**
     * Getter for domId18Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId16Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
     * Getter for aboutGooruAnr called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Anchor get_aboutGooruAnr() {
      return build_aboutGooruAnr();
    }
    private com.google.gwt.user.client.ui.Anchor build_aboutGooruAnr() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor aboutGooruAnr = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      aboutGooruAnr.setStyleName("" + get_libraryStyle().tabsLi() + " tabsLi " + get_libraryStyle().singleLink() + " " + get_libraryStyle().last() + "");


      owner.aboutGooruAnr = aboutGooruAnr;

      return aboutGooruAnr;
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

    /**
     * Getter for domId20 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for dynamicContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_dynamicContainer() {
      return build_dynamicContainer();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_dynamicContainer() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel dynamicContainer = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html13().asString());
      // Setup section.


      owner.dynamicContainer = dynamicContainer;

      return dynamicContainer;
    }

    /**
     * Getter for domId20Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
  }
}
