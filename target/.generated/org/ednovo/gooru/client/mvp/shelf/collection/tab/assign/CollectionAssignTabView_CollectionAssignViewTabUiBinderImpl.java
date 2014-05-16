package org.ednovo.gooru.client.mvp.shelf.collection.tab.assign;

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

public class CollectionAssignTabView_CollectionAssignViewTabUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabView>, org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabView.CollectionAssignViewTabUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span>")
    SafeHtml html1(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html2(String arg0, String arg1, String arg2, String arg3);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html3(String arg0, String arg1);
     
    @Template("")
    SafeHtml html4();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html5(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html6(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html7(String arg0);
     
    @Template("")
    SafeHtml html8();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html9(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>  <span id='{1}'></span>")
    SafeHtml html10(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html11(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html12(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span>")
    SafeHtml html13(String arg0, String arg1, String arg2, String arg3, String arg4);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>  <span id='{2}'></span>")
    SafeHtml html14(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html15(String arg0, String arg1);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabView owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.OnClickClasspagePlaceHolder(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.OnClickClasspageArrow(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.OnClickAssign(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.OnClickEventPanel(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabView owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_domId14();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId15();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId16();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId19();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId18();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId20();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId23();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId25();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId17();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId22();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId24();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId26();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId27();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId28();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId21();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId14Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId15Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId16Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId19Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId18Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId20Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId23Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId25Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId17Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId22Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId24Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId26Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId27Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId28Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId21Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
    }

    SafeHtml template_html1() {
      return template.html1(get_domId0());
    }
    SafeHtml template_html2() {
      return template.html2(get_domId2(), get_domId3(), get_domId4(), get_domId5());
    }
    SafeHtml template_html3() {
      return template.html3(get_domId8(), get_domId9());
    }
    SafeHtml template_html4() {
      return template.html4();
    }
    SafeHtml template_html5() {
      return template.html5(get_domId14(), get_domId15(), get_domId16());
    }
    SafeHtml template_html6() {
      return template.html6(get_domId12(), get_domId13());
    }
    SafeHtml template_html7() {
      return template.html7(get_domId19());
    }
    SafeHtml template_html8() {
      return template.html8();
    }
    SafeHtml template_html9() {
      return template.html9(get_domId18(), get_domId20());
    }
    SafeHtml template_html10() {
      return template.html10(get_domId11(), get_domId17());
    }
    SafeHtml template_html11() {
      return template.html11(get_domId23());
    }
    SafeHtml template_html12() {
      return template.html12(get_domId25());
    }
    SafeHtml template_html13() {
      return template.html13(get_domId22(), get_domId24(), get_domId26(), get_domId27(), get_domId28());
    }
    SafeHtml template_html14() {
      return template.html14(get_domId7(), get_domId10(), get_domId21());
    }
    SafeHtml template_html15() {
      return template.html15(get_domId1(), get_domId6());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabView_CollectionAssignViewTabUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabView_CollectionAssignViewTabUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabView_CollectionAssignViewTabUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabView_CollectionAssignViewTabUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabView_CollectionAssignViewTabUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 22 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignCBundle res;
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignCBundle build_res() {
      // Creation section.
      res = owner.res;
      assert res != null : "UiField res with 'provided = true' was null";
      // Setup section.


      return res;
    }

    /**
     * Getter for f_FlowPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel1() {
      return build_f_FlowPanel1();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel1 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel1.add(get_panelLoading());
      f_FlowPanel1.add(get_f_HTMLPanel3());
      f_FlowPanel1.setStyleName("" + get_res().css().mainContainer() + "");


      return f_FlowPanel1;
    }

    /**
     * Getter for panelLoading called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelLoading() {
      return build_panelLoading();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelLoading() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelLoading = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2039 = UiBinderUtil.attachToDom(panelLoading.getElement());
      get_domId0Element().get();

      // Detach section.
      attachRecord2039.detach();
      panelLoading.addAndReplaceElement(get_f_Label2(), get_domId0Element().get());

      owner.panelLoading = panelLoading;

      return panelLoading;
    }

    /**
     * Getter for domId0 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for f_Label2 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label2() {
      return build_f_Label2();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label2() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label2 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label2.setStyleName("" + get_res().css().loadingpanelImage() + "");


      return f_Label2;
    }

    /**
     * Getter for domId0Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for f_HTMLPanel3 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel3() {
      return build_f_HTMLPanel3();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template_html15().asString());
      // Setup section.
      f_HTMLPanel3.setStyleName("" + get_res().css().container() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2040 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
      get_domId1Element().get();
      get_domId6Element().get();

      // Detach section.
      attachRecord2040.detach();
      f_HTMLPanel3.addAndReplaceElement(get_panelNoClasspages(), get_domId1Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_htmlEvenPanelContainer(), get_domId6Element().get());

      return f_HTMLPanel3;
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
     * Getter for panelNoClasspages called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelNoClasspages() {
      return build_panelNoClasspages();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelNoClasspages() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelNoClasspages = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      panelNoClasspages.setStyleName("" + get_res().css().noClasspageContianer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2041 = UiBinderUtil.attachToDom(panelNoClasspages.getElement());
      get_domId2Element().get();
      get_domId3Element().get();
      get_domId4Element().get();
      get_domId5Element().get();

      // Detach section.
      attachRecord2041.detach();
      panelNoClasspages.addAndReplaceElement(get_lblNoClasspages(), get_domId2Element().get());
      panelNoClasspages.addAndReplaceElement(get_htmlGoto(), get_domId3Element().get());
      panelNoClasspages.addAndReplaceElement(get_ancTeach(), get_domId4Element().get());
      panelNoClasspages.addAndReplaceElement(get_htmlTab(), get_domId5Element().get());

      owner.panelNoClasspages = panelNoClasspages;

      return panelNoClasspages;
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
     * Getter for lblNoClasspages called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_lblNoClasspages() {
      return build_lblNoClasspages();
    }
    private com.google.gwt.user.client.ui.Label build_lblNoClasspages() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblNoClasspages = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblNoClasspages.setStyleName("" + get_res().css().labelNoClasspageText() + "");


      owner.lblNoClasspages = lblNoClasspages;

      return lblNoClasspages;
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
     * Getter for htmlGoto called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTML get_htmlGoto() {
      return build_htmlGoto();
    }
    private com.google.gwt.user.client.ui.HTML build_htmlGoto() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML htmlGoto = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      htmlGoto.setStyleName("" + get_res().css().labelNoClasspageText() + "");


      owner.htmlGoto = htmlGoto;

      return htmlGoto;
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
     * Getter for ancTeach called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTML get_ancTeach() {
      return build_ancTeach();
    }
    private com.google.gwt.user.client.ui.HTML build_ancTeach() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML ancTeach = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      ancTeach.setStyleName("" + get_res().css().labelTeachLink() + "");


      owner.ancTeach = ancTeach;

      return ancTeach;
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
     * Getter for htmlTab called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTML get_htmlTab() {
      return build_htmlTab();
    }
    private com.google.gwt.user.client.ui.HTML build_htmlTab() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML htmlTab = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      htmlTab.setStyleName("" + get_res().css().labelNoClasspageText() + "");


      owner.htmlTab = htmlTab;

      return htmlTab;
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
     * Getter for htmlEvenPanelContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_htmlEvenPanelContainer() {
      return build_htmlEvenPanelContainer();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_htmlEvenPanelContainer() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel htmlEvenPanelContainer = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html14().asString());
      // Setup section.
      htmlEvenPanelContainer.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2042 = UiBinderUtil.attachToDom(htmlEvenPanelContainer.getElement());
      get_domId7Element().get();
      get_domId10Element().get();
      get_domId21Element().get();

      // Detach section.
      attachRecord2042.detach();
      htmlEvenPanelContainer.addAndReplaceElement(get_f_HTMLPanel4(), get_domId7Element().get());
      htmlEvenPanelContainer.addAndReplaceElement(get_f_HTMLPanel5(), get_domId10Element().get());
      htmlEvenPanelContainer.addAndReplaceElement(get_f_HTMLPanel10(), get_domId21Element().get());

      owner.htmlEvenPanelContainer = htmlEvenPanelContainer;

      return htmlEvenPanelContainer;
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
     * Getter for f_HTMLPanel4 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel4() {
      return build_f_HTMLPanel4();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel4 = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2043 = UiBinderUtil.attachToDom(f_HTMLPanel4.getElement());
      get_domId8Element().get();
      get_domId9Element().get();

      // Detach section.
      attachRecord2043.detach();
      f_HTMLPanel4.addAndReplaceElement(get_lblAssignCollectionTitle(), get_domId8Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_lblAssignCollectionPrivate(), get_domId9Element().get());

      return f_HTMLPanel4;
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
     * Getter for lblAssignCollectionTitle called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_lblAssignCollectionTitle() {
      return build_lblAssignCollectionTitle();
    }
    private com.google.gwt.user.client.ui.Label build_lblAssignCollectionTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblAssignCollectionTitle = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblAssignCollectionTitle.setStyleName("" + get_res().css().labelTitleText() + "");


      owner.lblAssignCollectionTitle = lblAssignCollectionTitle;

      return lblAssignCollectionTitle;
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
     * Getter for domId9 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for lblAssignCollectionPrivate called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_lblAssignCollectionPrivate() {
      return build_lblAssignCollectionPrivate();
    }
    private com.google.gwt.user.client.ui.Label build_lblAssignCollectionPrivate() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblAssignCollectionPrivate = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblAssignCollectionPrivate.setStyleName("" + get_res().css().labelTitlePrivateText() + "");


      owner.lblAssignCollectionPrivate = lblAssignCollectionPrivate;

      return lblAssignCollectionPrivate;
    }

    /**
     * Getter for domId9Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId10 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for f_HTMLPanel5 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel5() {
      return build_f_HTMLPanel5();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel5 = new com.google.gwt.user.client.ui.HTMLPanel(template_html10().asString());
      // Setup section.
      f_HTMLPanel5.setStyleName("" + get_res().css().controlsContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2044 = UiBinderUtil.attachToDom(f_HTMLPanel5.getElement());
      get_domId11Element().get();
      get_domId17Element().get();

      // Detach section.
      attachRecord2044.detach();
      f_HTMLPanel5.addAndReplaceElement(get_f_HTMLPanel6(), get_domId11Element().get());
      f_HTMLPanel5.addAndReplaceElement(get_f_HTMLPanel8(), get_domId17Element().get());

      return f_HTMLPanel5;
    }

    /**
     * Getter for domId11 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel6 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel6() {
      return build_f_HTMLPanel6();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel6() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel6 = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2045 = UiBinderUtil.attachToDom(f_HTMLPanel6.getElement());
      get_domId12Element().get();
      get_domId13Element().get();

      // Detach section.
      attachRecord2045.detach();
      f_HTMLPanel6.addAndReplaceElement(get_lblClasspages(), get_domId12Element().get());
      f_HTMLPanel6.addAndReplaceElement(get_f_HTMLPanel7(), get_domId13Element().get());

      return f_HTMLPanel6;
    }

    /**
     * Getter for domId12 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for lblClasspages called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_lblClasspages() {
      return build_lblClasspages();
    }
    private com.google.gwt.user.client.ui.Label build_lblClasspages() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblClasspages = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblClasspages.setStyleName("" + get_res().css().labelText() + "");


      owner.lblClasspages = lblClasspages;

      return lblClasspages;
    }

    /**
     * Getter for domId12Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId13 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for f_HTMLPanel7 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel7() {
      return build_f_HTMLPanel7();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel7() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel7 = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.
      f_HTMLPanel7.setStyleName("" + get_res().css().dropdownContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2046 = UiBinderUtil.attachToDom(f_HTMLPanel7.getElement());
      get_domId14Element().get();
      get_domId15Element().get();
      get_domId16Element().get();

      // Detach section.
      attachRecord2046.detach();
      f_HTMLPanel7.addAndReplaceElement(get_lblClasspagePlaceHolder(), get_domId14Element().get());
      f_HTMLPanel7.addAndReplaceElement(get_lblClasspagesArrow(), get_domId15Element().get());
      f_HTMLPanel7.addAndReplaceElement(get_spanelClasspagesPanel(), get_domId16Element().get());

      return f_HTMLPanel7;
    }

    /**
     * Getter for domId14 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for lblClasspagePlaceHolder called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_lblClasspagePlaceHolder() {
      return build_lblClasspagePlaceHolder();
    }
    private com.google.gwt.user.client.ui.Label build_lblClasspagePlaceHolder() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblClasspagePlaceHolder = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblClasspagePlaceHolder.setStyleName("" + get_res().css().placeHolderText() + "");
      lblClasspagePlaceHolder.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.lblClasspagePlaceHolder = lblClasspagePlaceHolder;

      return lblClasspagePlaceHolder;
    }

    /**
     * Getter for domId14Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for lblClasspagesArrow called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_lblClasspagesArrow() {
      return build_lblClasspagesArrow();
    }
    private com.google.gwt.user.client.ui.Label build_lblClasspagesArrow() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblClasspagesArrow = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblClasspagesArrow.setStyleName("" + get_res().css().arrow() + "");
      lblClasspagesArrow.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.lblClasspagesArrow = lblClasspagesArrow;

      return lblClasspagesArrow;
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
     * Getter for domId16 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for spanelClasspagesPanel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.ScrollPanel get_spanelClasspagesPanel() {
      return build_spanelClasspagesPanel();
    }
    private com.google.gwt.user.client.ui.ScrollPanel build_spanelClasspagesPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.ScrollPanel spanelClasspagesPanel = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
      // Setup section.
      spanelClasspagesPanel.add(get_htmlClasspagesListContainer());
      spanelClasspagesPanel.setStyleName("" + get_res().css().scrollPanelContainer() + "");


      owner.spanelClasspagesPanel = spanelClasspagesPanel;

      return spanelClasspagesPanel;
    }

    /**
     * Getter for htmlClasspagesListContainer called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_htmlClasspagesListContainer() {
      return build_htmlClasspagesListContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_htmlClasspagesListContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel htmlClasspagesListContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      htmlClasspagesListContainer.setStyleName("");


      owner.htmlClasspagesListContainer = htmlClasspagesListContainer;

      return htmlClasspagesListContainer;
    }

    /**
     * Getter for domId16Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId13Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId11Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId17 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel8 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel8() {
      return build_f_HTMLPanel8();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel8() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel8 = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      f_HTMLPanel8.setStyleName("" + get_res().css().duedateContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2047 = UiBinderUtil.attachToDom(f_HTMLPanel8.getElement());
      get_domId18Element().get();
      get_domId20Element().get();

      // Detach section.
      attachRecord2047.detach();
      f_HTMLPanel8.addAndReplaceElement(get_f_HTMLPanel9(), get_domId18Element().get());
      f_HTMLPanel8.addAndReplaceElement(get_duedateContainer(), get_domId20Element().get());

      return f_HTMLPanel8;
    }

    /**
     * Getter for domId18 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for f_HTMLPanel9 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel9() {
      return build_f_HTMLPanel9();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel9() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel9 = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2048 = UiBinderUtil.attachToDom(f_HTMLPanel9.getElement());
      get_domId19Element().get();

      // Detach section.
      attachRecord2048.detach();
      f_HTMLPanel9.addAndReplaceElement(get_lblDuedate(), get_domId19Element().get());

      return f_HTMLPanel9;
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
     * Getter for lblDuedate called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_lblDuedate() {
      return build_lblDuedate();
    }
    private com.google.gwt.user.client.ui.Label build_lblDuedate() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblDuedate = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblDuedate.setStyleName("" + get_res().css().labelText() + "");


      owner.lblDuedate = lblDuedate;

      return lblDuedate;
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
     * Getter for domId18Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for duedateContainer called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_duedateContainer() {
      return build_duedateContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_duedateContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel duedateContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html8().asString());
      // Setup section.


      owner.duedateContainer = duedateContainer;

      return duedateContainer;
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
     * Getter for domId17Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId10Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId21 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for f_HTMLPanel10 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel10() {
      return build_f_HTMLPanel10();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel10() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel10 = new com.google.gwt.user.client.ui.HTMLPanel(template_html13().asString());
      // Setup section.
      f_HTMLPanel10.setStyleName("" + get_res().css().assignmentsContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2049 = UiBinderUtil.attachToDom(f_HTMLPanel10.getElement());
      get_domId22Element().get();
      get_domId24Element().get();
      get_domId26Element().get();
      get_domId27Element().get();
      get_domId28Element().get();

      // Detach section.
      attachRecord2049.detach();
      f_HTMLPanel10.addAndReplaceElement(get_f_HTMLPanel11(), get_domId22Element().get());
      f_HTMLPanel10.addAndReplaceElement(get_f_HTMLPanel12(), get_domId24Element().get());
      f_HTMLPanel10.addAndReplaceElement(get_directionsErrorLength(), get_domId26Element().get());
      f_HTMLPanel10.addAndReplaceElement(get_directionsErrorLbl(), get_domId27Element().get());
      f_HTMLPanel10.addAndReplaceElement(get_btnAssign(), get_domId28Element().get());

      return f_HTMLPanel10;
    }

    /**
     * Getter for domId22 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel11 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel11() {
      return build_f_HTMLPanel11();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel11() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel11 = new com.google.gwt.user.client.ui.HTMLPanel(template_html11().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2050 = UiBinderUtil.attachToDom(f_HTMLPanel11.getElement());
      get_domId23Element().get();

      // Detach section.
      attachRecord2050.detach();
      f_HTMLPanel11.addAndReplaceElement(get_lblDirections(), get_domId23Element().get());

      return f_HTMLPanel11;
    }

    /**
     * Getter for domId23 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for lblDirections called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_lblDirections() {
      return build_lblDirections();
    }
    private com.google.gwt.user.client.ui.Label build_lblDirections() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblDirections = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblDirections.setStyleName("" + get_res().css().labelText() + "");


      owner.lblDirections = lblDirections;

      return lblDirections;
    }

    /**
     * Getter for domId23Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId22Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId24 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel12 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel12() {
      return build_f_HTMLPanel12();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel12() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel12 = new com.google.gwt.user.client.ui.HTMLPanel(template_html12().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2051 = UiBinderUtil.attachToDom(f_HTMLPanel12.getElement());
      get_domId25Element().get();

      // Detach section.
      attachRecord2051.detach();
      f_HTMLPanel12.addAndReplaceElement(get_textAreaVal(), get_domId25Element().get());

      return f_HTMLPanel12;
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
     * Getter for textAreaVal called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.TextArea get_textAreaVal() {
      return build_textAreaVal();
    }
    private com.google.gwt.user.client.ui.TextArea build_textAreaVal() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextArea textAreaVal = (com.google.gwt.user.client.ui.TextArea) GWT.create(com.google.gwt.user.client.ui.TextArea.class);
      // Setup section.
      textAreaVal.setStyleName("" + get_res().css().directionsTextArea() + "");


      owner.textAreaVal = textAreaVal;

      return textAreaVal;
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
     * Getter for domId24Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId26 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for directionsErrorLength called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_directionsErrorLength() {
      return build_directionsErrorLength();
    }
    private com.google.gwt.user.client.ui.Label build_directionsErrorLength() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label directionsErrorLength = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      directionsErrorLength.setStyleName("errorMessage");


      owner.directionsErrorLength = directionsErrorLength;

      return directionsErrorLength;
    }

    /**
     * Getter for domId26Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for directionsErrorLbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_directionsErrorLbl() {
      return build_directionsErrorLbl();
    }
    private com.google.gwt.user.client.ui.Label build_directionsErrorLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label directionsErrorLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      directionsErrorLbl.setStyleName("" + get_res().css().directionsErrorLbl() + "");


      owner.directionsErrorLbl = directionsErrorLbl;

      return directionsErrorLbl;
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
     * Getter for domId28 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for btnAssign called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private org.ednovo.gooru.client.uc.BlueButtonUc get_btnAssign() {
      return build_btnAssign();
    }
    private org.ednovo.gooru.client.uc.BlueButtonUc build_btnAssign() {
      // Creation section.
      final org.ednovo.gooru.client.uc.BlueButtonUc btnAssign = (org.ednovo.gooru.client.uc.BlueButtonUc) GWT.create(org.ednovo.gooru.client.uc.BlueButtonUc.class);
      // Setup section.
      btnAssign.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);


      owner.btnAssign = btnAssign;

      return btnAssign;
    }

    /**
     * Getter for domId28Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId21Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
  }
}
