package org.ednovo.gooru.client.mvp.home;

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

public class HeaderUc_HeaderUcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.home.HeaderUc>, org.ednovo.gooru.client.mvp.home.HeaderUc.HeaderUcUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html2(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html3(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html4(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html5(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html6(String arg0);
     
    @Template("")
    SafeHtml html7();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html8(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span> <span id='{5}'></span>")
    SafeHtml html9(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html10(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html11(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html12(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html13(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html14(String arg0);
     
    @Template("<a id='{0}'> <div class='{1}'></div> <span id='{2}'></span> </a> <span id='{3}'></span> <span id='{4}'></span> <span id='{5}'></span>")
    SafeHtml html15(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html16(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html17(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html18(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html19(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html20(String arg0);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.home.HeaderUc owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.home.HeaderUc owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onLinkPopupClicked(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onRegisterPopupClicked(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.logoutPanel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.signoutPanel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.OnSearchClick(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.home.HeaderUc owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId14();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId16();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId18();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId20();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId15();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId17();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId19();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId22();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId24();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId25();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId26();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId30();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId31();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId32();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId21();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId29();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId23();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId28();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId27();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId14Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId16Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId18Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId20Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId15Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId17Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId19Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId22Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId24Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId25Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId26Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId30Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId31Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId32Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId21Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId29Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId23Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId28Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId27Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2(get_domId9(), get_domId10());
    }
    SafeHtml template_html3() {
      return template.html3(get_domId12());
    }
    SafeHtml template_html4() {
      return template.html4(get_domId14());
    }
    SafeHtml template_html5() {
      return template.html5(get_domId16());
    }
    SafeHtml template_html6() {
      return template.html6(get_domId18());
    }
    SafeHtml template_html7() {
      return template.html7();
    }
    SafeHtml template_html8() {
      return template.html8(get_domId20());
    }
    SafeHtml template_html9() {
      return template.html9(get_domId8(), get_domId11(), get_domId13(), get_domId15(), get_domId17(), get_domId19());
    }
    SafeHtml template_html10() {
      return template.html10(get_domId7());
    }
    SafeHtml template_html11() {
      return template.html11(get_domId22());
    }
    SafeHtml template_html12() {
      return template.html12(get_domId6(), get_domId21());
    }
    SafeHtml template_html13() {
      return template.html13(get_domId24(), get_domId25());
    }
    SafeHtml template_html14() {
      return template.html14(get_domId26());
    }
    SafeHtml template_html15() {
      return template.html15(get_domId2(), "" + get_res().css().gooruLearningIcon() + "", get_domId3(), get_domId4(), get_domId5(), get_domId23());
    }
    SafeHtml template_html16() {
      return template.html16(get_domId30(), get_domId31(), get_domId32());
    }
    SafeHtml template_html17() {
      return template.html17(get_domId29());
    }
    SafeHtml template_html18() {
      return template.html18(get_domId28());
    }
    SafeHtml template_html19() {
      return template.html19(get_domId1(), get_domId27());
    }
    SafeHtml template_html20() {
      return template.html20(get_domId0());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.HeaderUc_HeaderUcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.home.HeaderUc_HeaderUcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.home.HeaderUc_HeaderUcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.home.HeaderUc_HeaderUcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.home.HeaderUc_HeaderUcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 9 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.GooruCBundle res;
    private org.ednovo.gooru.client.GooruCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.GooruCBundle build_res() {
      // Creation section.
      res = owner.res;
      assert res != null : "UiField res with 'provided = true' was null";
      // Setup section.


      return res;
    }

    /**
     * Getter for style called 21 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.HeaderUc_HeaderUcUiBinderImpl_GenCss_style style;
    private org.ednovo.gooru.client.mvp.home.HeaderUc_HeaderUcUiBinderImpl_GenCss_style get_style() {
      return style;
    }
    private org.ednovo.gooru.client.mvp.home.HeaderUc_HeaderUcUiBinderImpl_GenCss_style build_style() {
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
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html20().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1882 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId0Element().get();

      // Detach section.
      attachRecord1882.detach();
      f_HTMLPanel1.addAndReplaceElement(get_headerMainPanel(), get_domId0Element().get());

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
     * Getter for headerMainPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_headerMainPanel() {
      return build_headerMainPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_headerMainPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel headerMainPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html19().asString());
      // Setup section.
      headerMainPanel.setStyleName("" + get_style().header() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1883 = UiBinderUtil.attachToDom(headerMainPanel.getElement());
      get_domId1Element().get();
      get_domId27Element().get();

      // Detach section.
      attachRecord1883.detach();
      headerMainPanel.addAndReplaceElement(get_f_HTMLPanel2(), get_domId1Element().get());
      headerMainPanel.addAndReplaceElement(get_acctActivationPl(), get_domId27Element().get());

      owner.headerMainPanel = headerMainPanel;

      return headerMainPanel;
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
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html15().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_style().headerInner() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1884 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_gooruLearning();
      get_domId3Element().get();
      get_domId4Element().get();
      get_domId5Element().get();
      get_domId23Element().get();

      // Detach section.
      attachRecord1884.detach();
      f_HTMLPanel2.addAndReplaceElement(get_lblBeta(), get_domId3Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_editSearchInputFloPanel(), get_domId4Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_mainDotsPanel(), get_domId5Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_logInfoFloPanel(), get_domId23Element().get());

      return f_HTMLPanel2;
    }

    /**
     * Getter for gooruLearning called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.dom.client.AnchorElement get_gooruLearning() {
      return build_gooruLearning();
    }
    private com.google.gwt.dom.client.AnchorElement build_gooruLearning() {
      // Creation section.
      final com.google.gwt.dom.client.AnchorElement gooruLearning = new com.google.gwt.uibinder.client.LazyDomElement(get_domId2()).get().cast();
      // Setup section.


      owner.gooruLearning = gooruLearning;

      return gooruLearning;
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
     * Getter for domId3 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for lblBeta called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_lblBeta() {
      return build_lblBeta();
    }
    private com.google.gwt.user.client.ui.Label build_lblBeta() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblBeta = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblBeta.setStyleName("" + get_style().gooruLearningCaption() + "");


      owner.lblBeta = lblBeta;

      return lblBeta;
    }

    /**
     * Getter for domId3Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for editSearchInputFloPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_editSearchInputFloPanel() {
      return build_editSearchInputFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_editSearchInputFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel editSearchInputFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      editSearchInputFloPanel.add(get_headerSearchBarVerPanel());
      editSearchInputFloPanel.setStyleName("" + get_res().css().editSearchInputBoxDiv() + "");


      owner.editSearchInputFloPanel = editSearchInputFloPanel;

      return editSearchInputFloPanel;
    }

    /**
     * Getter for headerSearchBarVerPanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.VerticalPanel get_headerSearchBarVerPanel() {
      return build_headerSearchBarVerPanel();
    }
    private com.google.gwt.user.client.ui.VerticalPanel build_headerSearchBarVerPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.VerticalPanel headerSearchBarVerPanel = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
      // Setup section.
      headerSearchBarVerPanel.add(get_headerSearchBarFloPanel());
      headerSearchBarVerPanel.setHeight("100%");
      headerSearchBarVerPanel.setWidth("100%");


      owner.headerSearchBarVerPanel = headerSearchBarVerPanel;

      return headerSearchBarVerPanel;
    }

    /**
     * Getter for headerSearchBarFloPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_headerSearchBarFloPanel() {
      return build_headerSearchBarFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_headerSearchBarFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel headerSearchBarFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      headerSearchBarFloPanel.add(get_editSearchTxtBox());
      headerSearchBarFloPanel.add(get_editSearchBtn());


      owner.headerSearchBarFloPanel = headerSearchBarFloPanel;

      return headerSearchBarFloPanel;
    }

    /**
     * Getter for editSearchTxtBox called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private org.ednovo.gooru.client.uc.AppSuggestBox get_editSearchTxtBox() {
      return build_editSearchTxtBox();
    }
    private org.ednovo.gooru.client.uc.AppSuggestBox build_editSearchTxtBox() {
      // Creation section.
      final org.ednovo.gooru.client.uc.AppSuggestBox editSearchTxtBox = owner.editSearchTxtBox;
      assert editSearchTxtBox != null : "UiField editSearchTxtBox with 'provided = true' was null";
      // Setup section.
      editSearchTxtBox.setStyleName("" + get_res().css().editInputBox() + "");


      return editSearchTxtBox;
    }

    /**
     * Getter for editSearchBtn called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Button get_editSearchBtn() {
      return build_editSearchBtn();
    }
    private com.google.gwt.user.client.ui.Button build_editSearchBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button editSearchBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      editSearchBtn.setStyleName("primary");
      editSearchBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5);


      owner.editSearchBtn = editSearchBtn;

      return editSearchBtn;
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
     * Getter for mainDotsPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_mainDotsPanel() {
      return build_mainDotsPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_mainDotsPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel mainDotsPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html12().asString());
      // Setup section.
      mainDotsPanel.setStyleName("" + get_style().teachUserNameContainerHoverAddAssignment() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1885 = UiBinderUtil.attachToDom(mainDotsPanel.getElement());
      get_domId6Element().get();
      get_domId21Element().get();

      // Detach section.
      attachRecord1885.detach();
      mainDotsPanel.addAndReplaceElement(get_f_HTMLPanel3(), get_domId6Element().get());
      mainDotsPanel.addAndReplaceElement(get_f_HTMLPanel6(), get_domId21Element().get());

      owner.mainDotsPanel = mainDotsPanel;

      return mainDotsPanel;
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
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template_html10().asString());
      // Setup section.
      f_HTMLPanel3.setStyleName("" + get_style().teachUserNameTextContainerAddAssignmentRight() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1886 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
      get_domId7Element().get();

      // Detach section.
      attachRecord1886.detach();
      f_HTMLPanel3.addAndReplaceElement(get_dotsPanel(), get_domId7Element().get());

      return f_HTMLPanel3;
    }

    /**
     * Getter for domId7 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for dotsPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_dotsPanel() {
      return build_dotsPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_dotsPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel dotsPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      dotsPanel.setStyleName("" + get_style().teachUserNameTextContainerAddAssignment() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1887 = UiBinderUtil.attachToDom(dotsPanel.getElement());
      get_domId8Element().get();
      get_domId11Element().get();
      get_domId13Element().get();
      get_domId15Element().get();
      get_domId17Element().get();
      get_domId19Element().get();

      // Detach section.
      attachRecord1887.detach();
      dotsPanel.addAndReplaceElement(get_discoverLinkContainer(), get_domId8Element().get());
      dotsPanel.addAndReplaceElement(get_organizeLinkContainer(), get_domId11Element().get());
      dotsPanel.addAndReplaceElement(get_teachLinkContainer(), get_domId13Element().get());
      dotsPanel.addAndReplaceElement(get_studyLinkContainer(), get_domId15Element().get());
      dotsPanel.addAndReplaceElement(get_LoginLinkContainer(), get_domId17Element().get());
      dotsPanel.addAndReplaceElement(get_f_HTMLPanel4(), get_domId19Element().get());

      owner.dotsPanel = dotsPanel;

      return dotsPanel;
    }

    /**
     * Getter for domId8 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for discoverLinkContainer called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_discoverLinkContainer() {
      return build_discoverLinkContainer();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_discoverLinkContainer() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel discoverLinkContainer = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html2().asString());
      // Setup section.
      discoverLinkContainer.setStyleName("" + get_style().menu() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1888 = UiBinderUtil.attachToDom(discoverLinkContainer.getElement());
      get_domId9Element().get();
      get_domId10Element().get();

      // Detach section.
      attachRecord1888.detach();
      discoverLinkContainer.addAndReplaceElement(get_discoverLink(), get_domId9Element().get());
      discoverLinkContainer.addAndReplaceElement(get_dropDownImg(), get_domId10Element().get());

      owner.discoverLinkContainer = discoverLinkContainer;

      return discoverLinkContainer;
    }

    /**
     * Getter for domId9 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for discoverLink called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Label get_discoverLink() {
      return build_discoverLink();
    }
    private com.google.gwt.user.client.ui.Label build_discoverLink() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label discoverLink = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      discoverLink.setStyleName("" + get_res().css().discoverTextStyle() + "");


      owner.discoverLink = discoverLink;

      return discoverLink;
    }

    /**
     * Getter for domId9Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId10 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for dropDownImg called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_dropDownImg() {
      return build_dropDownImg();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_dropDownImg() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel dropDownImg = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      dropDownImg.setStyleName("" + get_res().css().discoverDropDown() + "");


      return dropDownImg;
    }

    /**
     * Getter for domId10Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId8Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId11 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for organizeLinkContainer called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_organizeLinkContainer() {
      return build_organizeLinkContainer();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_organizeLinkContainer() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel organizeLinkContainer = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html3().asString());
      // Setup section.
      organizeLinkContainer.setStyleName("" + get_style().menu() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1889 = UiBinderUtil.attachToDom(organizeLinkContainer.getElement());
      get_domId12Element().get();

      // Detach section.
      attachRecord1889.detach();
      organizeLinkContainer.addAndReplaceElement(get_organizeLink(), get_domId12Element().get());

      owner.organizeLinkContainer = organizeLinkContainer;

      return organizeLinkContainer;
    }

    /**
     * Getter for domId12 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for organizeLink called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Label get_organizeLink() {
      return build_organizeLink();
    }
    private com.google.gwt.user.client.ui.Label build_organizeLink() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label organizeLink = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.organizeLink = organizeLink;

      return organizeLink;
    }

    /**
     * Getter for domId12Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId11Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId13 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for teachLinkContainer called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_teachLinkContainer() {
      return build_teachLinkContainer();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_teachLinkContainer() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel teachLinkContainer = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html4().asString());
      // Setup section.
      teachLinkContainer.setStyleName("" + get_style().teachUserNameTextBlack() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1890 = UiBinderUtil.attachToDom(teachLinkContainer.getElement());
      get_domId14Element().get();

      // Detach section.
      attachRecord1890.detach();
      teachLinkContainer.addAndReplaceElement(get_teachLink(), get_domId14Element().get());

      owner.teachLinkContainer = teachLinkContainer;

      return teachLinkContainer;
    }

    /**
     * Getter for domId14 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for teachLink called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Label get_teachLink() {
      return build_teachLink();
    }
    private com.google.gwt.user.client.ui.Label build_teachLink() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label teachLink = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.teachLink = teachLink;

      return teachLink;
    }

    /**
     * Getter for domId14Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId13Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for studyLinkContainer called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_studyLinkContainer() {
      return build_studyLinkContainer();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_studyLinkContainer() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel studyLinkContainer = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html5().asString());
      // Setup section.
      studyLinkContainer.setStyleName("" + get_style().teachUserNameTextBlack() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1891 = UiBinderUtil.attachToDom(studyLinkContainer.getElement());
      get_domId16Element().get();

      // Detach section.
      attachRecord1891.detach();
      studyLinkContainer.addAndReplaceElement(get_studyLink(), get_domId16Element().get());

      owner.studyLinkContainer = studyLinkContainer;

      return studyLinkContainer;
    }

    /**
     * Getter for domId16 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for studyLink called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Label get_studyLink() {
      return build_studyLink();
    }
    private com.google.gwt.user.client.ui.Label build_studyLink() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label studyLink = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.studyLink = studyLink;

      return studyLink;
    }

    /**
     * Getter for domId16Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId17 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for LoginLinkContainer called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_LoginLinkContainer() {
      return build_LoginLinkContainer();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_LoginLinkContainer() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel LoginLinkContainer = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html6().asString());
      // Setup section.
      LoginLinkContainer.setStyleName("" + get_style().menu() + "");
      LoginLinkContainer.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1892 = UiBinderUtil.attachToDom(LoginLinkContainer.getElement());
      get_domId18Element().get();

      // Detach section.
      attachRecord1892.detach();
      LoginLinkContainer.addAndReplaceElement(get_loggedInfoLbl(), get_domId18Element().get());

      owner.LoginLinkContainer = LoginLinkContainer;

      return LoginLinkContainer;
    }

    /**
     * Getter for domId18 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for loggedInfoLbl called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Label get_loggedInfoLbl() {
      return build_loggedInfoLbl();
    }
    private com.google.gwt.user.client.ui.Label build_loggedInfoLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label loggedInfoLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      loggedInfoLbl.setStyleName("" + get_style().username() + "");


      owner.loggedInfoLbl = loggedInfoLbl;

      return loggedInfoLbl;
    }

    /**
     * Getter for domId18Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId17Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId19 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for f_HTMLPanel4 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel4() {
      return build_f_HTMLPanel4();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel4 = new com.google.gwt.user.client.ui.HTMLPanel(template_html8().asString());
      // Setup section.
      f_HTMLPanel4.setStyleName("" + get_style().teachUserNameArrowContainerNew() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1893 = UiBinderUtil.attachToDom(f_HTMLPanel4.getElement());
      get_domId20Element().get();

      // Detach section.
      attachRecord1893.detach();
      f_HTMLPanel4.addAndReplaceElement(get_f_HTMLPanel5(), get_domId20Element().get());

      return f_HTMLPanel4;
    }

    /**
     * Getter for domId20 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for f_HTMLPanel5 called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel5() {
      return build_f_HTMLPanel5();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel5 = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.
      f_HTMLPanel5.setStyleName("" + get_style().downArrow() + "");


      return f_HTMLPanel5;
    }

    /**
     * Getter for domId20Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId19Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId7Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId21 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel6 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel6() {
      return build_f_HTMLPanel6();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel6() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel6 = new com.google.gwt.user.client.ui.HTMLPanel(template_html11().asString());
      // Setup section.
      f_HTMLPanel6.setStyleName("" + get_style().helpAndSettingsContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1894 = UiBinderUtil.attachToDom(f_HTMLPanel6.getElement());
      get_domId22Element().get();

      // Detach section.
      attachRecord1894.detach();
      f_HTMLPanel6.addAndReplaceElement(get_signUpInfo(), get_domId22Element().get());

      return f_HTMLPanel6;
    }

    /**
     * Getter for domId22 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for signUpInfo called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_signUpInfo() {
      return build_signUpInfo();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_signUpInfo() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel signUpInfo = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      signUpInfo.add(get_logoutDownArrowLbl());
      signUpInfo.setStyleName("" + get_res().css().loginUserNameContainer() + "");


      return signUpInfo;
    }

    /**
     * Getter for logoutDownArrowLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_logoutDownArrowLbl() {
      return build_logoutDownArrowLbl();
    }
    private com.google.gwt.user.client.ui.Label build_logoutDownArrowLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label logoutDownArrowLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      logoutDownArrowLbl.setStyleName("" + get_res().css().logoutDownArrow() + "");
      logoutDownArrowLbl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);


      owner.logoutDownArrowLbl = logoutDownArrowLbl;

      return logoutDownArrowLbl;
    }

    /**
     * Getter for domId22Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId21Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId23 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for logInfoFloPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_logInfoFloPanel() {
      return build_logInfoFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_logInfoFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel logInfoFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      logInfoFloPanel.add(get_f_HTMLPanel7());
      logInfoFloPanel.add(get_f_HTMLPanel8());
      logInfoFloPanel.setStyleName("" + get_style().loginInfo() + "");


      owner.logInfoFloPanel = logInfoFloPanel;

      return logInfoFloPanel;
    }

    /**
     * Getter for f_HTMLPanel7 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel7() {
      return build_f_HTMLPanel7();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel7() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel7 = new com.google.gwt.user.client.ui.HTMLPanel(template_html13().asString());
      // Setup section.
      f_HTMLPanel7.setStyleName("" + get_style().login() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1895 = UiBinderUtil.attachToDom(f_HTMLPanel7.getElement());
      get_domId24Element().get();
      get_domId25Element().get();

      // Detach section.
      attachRecord1895.detach();
      f_HTMLPanel7.addAndReplaceElement(get_registerLinkLbl(), get_domId24Element().get());
      f_HTMLPanel7.addAndReplaceElement(get_loginLink(), get_domId25Element().get());

      return f_HTMLPanel7;
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
     * Getter for registerLinkLbl called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_registerLinkLbl() {
      return build_registerLinkLbl();
    }
    private com.google.gwt.user.client.ui.Label build_registerLinkLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label registerLinkLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      registerLinkLbl.setStyleName("" + get_res().css().loggedInfo() + "");
      registerLinkLbl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.registerLinkLbl = registerLinkLbl;

      return registerLinkLbl;
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
     * Getter for domId25 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for loginLink called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_loginLink() {
      return build_loginLink();
    }
    private com.google.gwt.user.client.ui.Label build_loginLink() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label loginLink = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      loginLink.setStyleName("" + get_res().css().loggedInfo() + "");
      loginLink.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.loginLink = loginLink;

      return loginLink;
    }

    /**
     * Getter for domId25Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for f_HTMLPanel8 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel8() {
      return build_f_HTMLPanel8();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel8() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel8 = new com.google.gwt.user.client.ui.HTMLPanel(template_html14().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1896 = UiBinderUtil.attachToDom(f_HTMLPanel8.getElement());
      get_domId26Element().get();

      // Detach section.
      attachRecord1896.detach();
      f_HTMLPanel8.addAndReplaceElement(get_StudyLbl(), get_domId26Element().get());

      return f_HTMLPanel8;
    }

    /**
     * Getter for domId26 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for StudyLbl called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Button get_StudyLbl() {
      return build_StudyLbl();
    }
    private com.google.gwt.user.client.ui.Button build_StudyLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button StudyLbl = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      StudyLbl.setStyleName("" + get_style().signUpButton() + " primary");


      owner.StudyLbl = StudyLbl;

      return StudyLbl;
    }

    /**
     * Getter for domId26Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId23Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId27 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for acctActivationPl called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_acctActivationPl() {
      return build_acctActivationPl();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_acctActivationPl() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel acctActivationPl = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html18().asString());
      // Setup section.
      acctActivationPl.setStyleName("" + get_style().resourceRightsPopupContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1897 = UiBinderUtil.attachToDom(acctActivationPl.getElement());
      get_domId28Element().get();

      // Detach section.
      attachRecord1897.detach();
      acctActivationPl.addAndReplaceElement(get_f_HTMLPanel9(), get_domId28Element().get());

      owner.acctActivationPl = acctActivationPl;

      return acctActivationPl;
    }

    /**
     * Getter for domId28 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for f_HTMLPanel9 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel9() {
      return build_f_HTMLPanel9();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel9() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel9 = new com.google.gwt.user.client.ui.HTMLPanel(template_html17().asString());
      // Setup section.
      f_HTMLPanel9.setStyleName("" + get_style().resourceRightsInnerPopup() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1898 = UiBinderUtil.attachToDom(f_HTMLPanel9.getElement());
      get_domId29Element().get();

      // Detach section.
      attachRecord1898.detach();
      f_HTMLPanel9.addAndReplaceElement(get_f_HTMLPanel10(), get_domId29Element().get());

      return f_HTMLPanel9;
    }

    /**
     * Getter for domId29 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel10 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel10() {
      return build_f_HTMLPanel10();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel10() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel10 = new com.google.gwt.user.client.ui.HTMLPanel(template_html16().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1899 = UiBinderUtil.attachToDom(f_HTMLPanel10.getElement());
      get_domId30Element().get();
      get_domId31Element().get();
      get_domId32Element().get();

      // Detach section.
      attachRecord1899.detach();
      f_HTMLPanel10.addAndReplaceElement(get_confirmEmailText(), get_domId30Element().get());
      f_HTMLPanel10.addAndReplaceElement(get_resendEmailAncr(), get_domId31Element().get());
      f_HTMLPanel10.addAndReplaceElement(get_thanksLbl(), get_domId32Element().get());

      return f_HTMLPanel10;
    }

    /**
     * Getter for domId30 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for confirmEmailText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_confirmEmailText() {
      return build_confirmEmailText();
    }
    private com.google.gwt.user.client.ui.Label build_confirmEmailText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label confirmEmailText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.confirmEmailText = confirmEmailText;

      return confirmEmailText;
    }

    /**
     * Getter for domId30Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId31 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId31;
    private java.lang.String get_domId31() {
      return domId31;
    }
    private java.lang.String build_domId31() {
      // Creation section.
      domId31 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId31;
    }

    /**
     * Getter for resendEmailAncr called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Anchor get_resendEmailAncr() {
      return build_resendEmailAncr();
    }
    private com.google.gwt.user.client.ui.Anchor build_resendEmailAncr() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor resendEmailAncr = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      resendEmailAncr.setStyleName("" + get_style().anchorText() + "");


      owner.resendEmailAncr = resendEmailAncr;

      return resendEmailAncr;
    }

    /**
     * Getter for domId31Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId31Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId31Element() {
      return domId31Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId31Element() {
      // Creation section.
      domId31Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId31());
      // Setup section.


      return domId31Element;
    }

    /**
     * Getter for domId32 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId32;
    private java.lang.String get_domId32() {
      return domId32;
    }
    private java.lang.String build_domId32() {
      // Creation section.
      domId32 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId32;
    }

    /**
     * Getter for thanksLbl called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_thanksLbl() {
      return build_thanksLbl();
    }
    private com.google.gwt.user.client.ui.Label build_thanksLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label thanksLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.thanksLbl = thanksLbl;

      return thanksLbl;
    }

    /**
     * Getter for domId32Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId32Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId32Element() {
      return domId32Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId32Element() {
      // Creation section.
      domId32Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId32());
      // Setup section.


      return domId32Element;
    }

    /**
     * Getter for domId29Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId28Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId27Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
