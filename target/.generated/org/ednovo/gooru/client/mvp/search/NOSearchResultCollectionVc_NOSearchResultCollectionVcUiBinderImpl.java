package org.ednovo.gooru.client.mvp.search;

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

public class NOSearchResultCollectionVc_NOSearchResultCollectionVcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.search.NOSearchResultCollectionVc>, org.ednovo.gooru.client.mvp.search.NOSearchResultCollectionVc.NOSearchResultCollectionVcUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html1(String arg0, String arg1);
     
    @Template("<div class='{0}'> <div class='{1}'> <div class='{2}'> <span id='{3}'></span> <span id='{4}'></span> <div class='{5}'> <div class='{6}'></div> <span id='{7}'></span> </div> <span id='{8}'></span> <div> <div class='{9}'> <div class='{10}'> <div class='{11}'></div> <span id='{12}'></span> </div> <div class='{13}'> <div class='{14}'></div> <span id='{15}'></span> </div> <div class='{16}'> <div class='{17}'></div> <span id='{18}'></span> </div> <div class='{19}'> <div class='{20}'></div> <span id='{21}'></span> </div> </div> <div class='{22}'></div> </div> </div> <span id='{23}'></span> </div> </div>")
    SafeHtml html2(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15, String arg16, String arg17, String arg18, String arg19, String arg20, String arg21, String arg22, String arg23);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.search.NOSearchResultCollectionVc owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.search.NOSearchResultCollectionVc owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickOnLibrary(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.search.NOSearchResultCollectionVc owner) {
      this.owner = owner;
      build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();  // more than one getter call detected. Type: GENERATED_BUNDLE, precedence: 1
      build_noResultStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1(get_domId9(), get_domId10());
    }
    SafeHtml template_html2() {
      return template.html2("" + get_noResultStyle().noResultsBox() + "", "" + get_noResultStyle().container() + "", "" + get_noResultStyle().noResults() + "", get_domId0(), get_domId1(), "" + get_style().oRLableStyle() + "", "" + get_style().borderLableStyle() + "", get_domId2(), get_domId3(), "" + get_noResultStyle().leftColumn() + "", "" + get_noResultStyle().liPosition() + "", "" + get_noResultStyle().orange() + "", get_domId4(), "" + get_noResultStyle().liPosition() + "", "" + get_noResultStyle().green() + "", get_domId5(), "" + get_noResultStyle().liPosition() + "", "" + get_noResultStyle().lightBlue() + "", get_domId6(), "" + get_noResultStyle().liPosition() + "", "" + get_noResultStyle().blue() + "", get_domId7(), "" + get_noResultStyle().rightColumn() + "", get_domId8());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 2 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.search.NOSearchResultCollectionVc_NOSearchResultCollectionVcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    private org.ednovo.gooru.client.mvp.search.NOSearchResultCollectionVc_NOSearchResultCollectionVcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }
    private org.ednovo.gooru.client.mvp.search.NOSearchResultCollectionVc_NOSearchResultCollectionVcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.search.NOSearchResultCollectionVc_NOSearchResultCollectionVcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.search.NOSearchResultCollectionVc_NOSearchResultCollectionVcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for noResultStyle called 20 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.search.NOSearchResultCollectionVc_NOSearchResultCollectionVcUiBinderImpl_GenCss_noResultStyle noResultStyle;
    private org.ednovo.gooru.client.mvp.search.NOSearchResultCollectionVc_NOSearchResultCollectionVcUiBinderImpl_GenCss_noResultStyle get_noResultStyle() {
      return noResultStyle;
    }
    private org.ednovo.gooru.client.mvp.search.NOSearchResultCollectionVc_NOSearchResultCollectionVcUiBinderImpl_GenCss_noResultStyle build_noResultStyle() {
      // Creation section.
      noResultStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().noResultStyle();
      // Setup section.
      noResultStyle.ensureInjected();


      owner.noResultStyle = noResultStyle;

      return noResultStyle;
    }

    /**
     * Getter for style called 5 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.search.NOSearchResultCollectionVc_NOSearchResultCollectionVcUiBinderImpl_GenCss_style style;
    private org.ednovo.gooru.client.mvp.search.NOSearchResultCollectionVc_NOSearchResultCollectionVcUiBinderImpl_GenCss_style get_style() {
      return style;
    }
    private org.ednovo.gooru.client.mvp.search.NOSearchResultCollectionVc_NOSearchResultCollectionVcUiBinderImpl_GenCss_style build_style() {
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
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord3106 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId0Element().get();
      get_domId1Element().get();
      get_domId2Element().get();
      get_domId3Element().get();
      get_domId4Element().get();
      get_domId5Element().get();
      get_domId6Element().get();
      get_domId7Element().get();
      get_domId8Element().get();

      // Detach section.
      attachRecord3106.detach();
      f_HTMLPanel1.addAndReplaceElement(get_didnotFindText(), get_domId0Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_btnLibrary(), get_domId1Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_orText(), get_domId2Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_tryTipsText(), get_domId3Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_removeFiltersText(), get_domId4Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_checkSpellingText(), get_domId5Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_differentKeywordText(), get_domId6Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_changeToggleText(), get_domId7Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_suggestedCollectionContainer(), get_domId8Element().get());

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
     * Getter for didnotFindText called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_didnotFindText() {
      return build_didnotFindText();
    }
    private com.google.gwt.user.client.ui.Label build_didnotFindText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label didnotFindText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      didnotFindText.setStyleName("" + get_style().header() + "");


      owner.didnotFindText = didnotFindText;

      return didnotFindText;
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
     * Getter for btnLibrary called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Button get_btnLibrary() {
      return build_btnLibrary();
    }
    private com.google.gwt.user.client.ui.Button build_btnLibrary() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button btnLibrary = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      btnLibrary.setStyleName("primary");
      btnLibrary.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.btnLibrary = btnLibrary;

      return btnLibrary;
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
     * Getter for orText called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_orText() {
      return build_orText();
    }
    private com.google.gwt.user.client.ui.Label build_orText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label orText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      orText.setStyleName("" + get_style().borderOrLabel() + "");


      owner.orText = orText;

      return orText;
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
     * Getter for tryTipsText called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_tryTipsText() {
      return build_tryTipsText();
    }
    private com.google.gwt.user.client.ui.Label build_tryTipsText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label tryTipsText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      tryTipsText.setStyleName("" + get_style().tipTextLabel() + "");


      owner.tryTipsText = tryTipsText;

      return tryTipsText;
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
     * Getter for removeFiltersText called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_removeFiltersText() {
      return build_removeFiltersText();
    }
    private com.google.gwt.user.client.ui.Label build_removeFiltersText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label removeFiltersText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      removeFiltersText.setStyleName("" + get_noResultStyle().liContent() + "");


      owner.removeFiltersText = removeFiltersText;

      return removeFiltersText;
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
     * Getter for domId5 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for checkSpellingText called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_checkSpellingText() {
      return build_checkSpellingText();
    }
    private com.google.gwt.user.client.ui.Label build_checkSpellingText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label checkSpellingText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      checkSpellingText.setStyleName("" + get_noResultStyle().liContent() + "");


      owner.checkSpellingText = checkSpellingText;

      return checkSpellingText;
    }

    /**
     * Getter for domId5Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
     * Getter for domId6 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for differentKeywordText called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_differentKeywordText() {
      return build_differentKeywordText();
    }
    private com.google.gwt.user.client.ui.Label build_differentKeywordText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label differentKeywordText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      differentKeywordText.setStyleName("" + get_noResultStyle().liContent() + "");


      owner.differentKeywordText = differentKeywordText;

      return differentKeywordText;
    }

    /**
     * Getter for domId6Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
     * Getter for changeToggleText called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_changeToggleText() {
      return build_changeToggleText();
    }
    private com.google.gwt.user.client.ui.Label build_changeToggleText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label changeToggleText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      changeToggleText.setStyleName("" + get_noResultStyle().liContent() + "");


      owner.changeToggleText = changeToggleText;

      return changeToggleText;
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
     * Getter for domId8 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for suggestedCollectionContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_suggestedCollectionContainer() {
      return build_suggestedCollectionContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_suggestedCollectionContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel suggestedCollectionContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      suggestedCollectionContainer.setStyleName("" + get_noResultStyle().suggestedResources() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord3107 = UiBinderUtil.attachToDom(suggestedCollectionContainer.getElement());
      get_domId9Element().get();
      get_domId10Element().get();

      // Detach section.
      attachRecord3107.detach();
      suggestedCollectionContainer.addAndReplaceElement(get_suggestedCollectionsText(), get_domId9Element().get());
      suggestedCollectionContainer.addAndReplaceElement(get_suggestedCollectionCountLbl(), get_domId10Element().get());

      owner.suggestedCollectionContainer = suggestedCollectionContainer;

      return suggestedCollectionContainer;
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
     * Getter for suggestedCollectionsText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_suggestedCollectionsText() {
      return build_suggestedCollectionsText();
    }
    private com.google.gwt.user.client.ui.Label build_suggestedCollectionsText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label suggestedCollectionsText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      suggestedCollectionsText.setStyleName("" + get_noResultStyle().header() + "");


      owner.suggestedCollectionsText = suggestedCollectionsText;

      return suggestedCollectionsText;
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
     * Getter for suggestedCollectionCountLbl called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_suggestedCollectionCountLbl() {
      return build_suggestedCollectionCountLbl();
    }
    private com.google.gwt.user.client.ui.Label build_suggestedCollectionCountLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label suggestedCollectionCountLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      suggestedCollectionCountLbl.setStyleName("" + get_noResultStyle().suggestedCollectionCount() + "");


      owner.suggestedCollectionCountLbl = suggestedCollectionCountLbl;

      return suggestedCollectionCountLbl;
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
     * Getter for domId8Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
  }
}
