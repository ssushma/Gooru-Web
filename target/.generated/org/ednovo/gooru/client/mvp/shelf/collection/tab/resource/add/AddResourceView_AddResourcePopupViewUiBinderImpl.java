package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add;

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

public class AddResourceView_AddResourcePopupViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddResourceView>, org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddResourceView.AddResourcePopupViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span>")
    SafeHtml html1(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html2(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html3(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html4(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html5(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html6(String arg0, String arg1);
     
    @Template("Multiple Answer")
    SafeHtml html7();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html8(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html9(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html10(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html11(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>  <span id='{3}'></span> <span id='{4}'></span> <span id='{5}'></span> <span id='{6}'></span> <span id='{7}'></span>")
    SafeHtml html12(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7);
     
    @Template("")
    SafeHtml html13();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html14(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html15(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html16(String arg0);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddResourceView owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddResourceView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.closePopup(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddResourceView owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId14();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId15();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId17();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId18();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId20();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId21();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId23();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId24();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId26();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId27();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId16();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId19();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId22();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId25();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId28();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId14Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId15Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId17Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId18Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId20Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId21Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId23Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId24Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId26Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId27Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId16Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId19Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId22Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId25Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId28Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
    }

    SafeHtml template_html1() {
      return template.html1(get_domId5());
    }
    SafeHtml template_html2() {
      return template.html2(get_domId3(), get_domId4());
    }
    SafeHtml template_html3() {
      return template.html3(get_domId8());
    }
    SafeHtml template_html4() {
      return template.html4(get_domId10());
    }
    SafeHtml template_html5() {
      return template.html5(get_domId12());
    }
    SafeHtml template_html6() {
      return template.html6(get_domId14(), get_domId15());
    }
    SafeHtml template_html7() {
      return template.html7();
    }
    SafeHtml template_html8() {
      return template.html8(get_domId17(), get_domId18());
    }
    SafeHtml template_html9() {
      return template.html9(get_domId20(), get_domId21());
    }
    SafeHtml template_html10() {
      return template.html10(get_domId23(), get_domId24());
    }
    SafeHtml template_html11() {
      return template.html11(get_domId26(), get_domId27());
    }
    SafeHtml template_html12() {
      return template.html12(get_domId7(), get_domId9(), get_domId11(), get_domId13(), get_domId16(), get_domId19(), get_domId22(), get_domId25());
    }
    SafeHtml template_html13() {
      return template.html13();
    }
    SafeHtml template_html14() {
      return template.html14(get_domId2(), get_domId6(), get_domId28());
    }
    SafeHtml template_html15() {
      return template.html15(get_domId1());
    }
    SafeHtml template_html16() {
      return template.html16(get_domId0());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddResourceView_AddResourcePopupViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddResourceView_AddResourcePopupViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddResourceView_AddResourcePopupViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddResourceView_AddResourcePopupViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddResourceView_AddResourcePopupViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 29 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.CollectionEditResourceCBundle res;
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.CollectionEditResourceCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.CollectionEditResourceCBundle build_res() {
      // Creation section.
      res = (org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.CollectionEditResourceCBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.CollectionEditResourceCBundle.class);
      // Setup section.


      owner.res = res;

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
      f_FlowPanel1.add(get_f_HTMLPanel2());


      return f_FlowPanel1;
    }

    /**
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html16().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_res().css().myFolderCollectionPopupOuterdiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1946 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_domId0Element().get();

      // Detach section.
      attachRecord1946.detach();
      f_HTMLPanel2.addAndReplaceElement(get_f_HTMLPanel3(), get_domId0Element().get());

      return f_HTMLPanel2;
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
     * Getter for f_HTMLPanel3 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel3() {
      return build_f_HTMLPanel3();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template_html15().asString());
      // Setup section.
      f_HTMLPanel3.setStyleName("" + get_res().css().myFolderCollectionPopupContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1947 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
      get_domId1Element().get();

      // Detach section.
      attachRecord1947.detach();
      f_HTMLPanel3.addAndReplaceElement(get_f_HTMLPanel4(), get_domId1Element().get());

      return f_HTMLPanel3;
    }

    /**
     * Getter for domId1 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for f_HTMLPanel4 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel4() {
      return build_f_HTMLPanel4();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel4 = new com.google.gwt.user.client.ui.HTMLPanel(template_html14().asString());
      // Setup section.
      f_HTMLPanel4.setStyleName("" + get_res().css().myFolderCollectionPopup() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1948 = UiBinderUtil.attachToDom(f_HTMLPanel4.getElement());
      get_domId2Element().get();
      get_domId6Element().get();
      get_domId28Element().get();

      // Detach section.
      attachRecord1948.detach();
      f_HTMLPanel4.addAndReplaceElement(get_f_HTMLPanel5(), get_domId2Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_addResourceTabContainer(), get_domId6Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_tabViewContainer(), get_domId28Element().get());

      return f_HTMLPanel4;
    }

    /**
     * Getter for domId2 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel5 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel5() {
      return build_f_HTMLPanel5();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel5 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      f_HTMLPanel5.setStyleName("" + get_res().css().myFolderCollectionBlackBg() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1949 = UiBinderUtil.attachToDom(f_HTMLPanel5.getElement());
      get_domId3Element().get();
      get_domId4Element().get();

      // Detach section.
      attachRecord1949.detach();
      f_HTMLPanel5.addAndReplaceElement(get_titleLbl(), get_domId3Element().get());
      f_HTMLPanel5.addAndReplaceElement(get_f_HTMLPanel6(), get_domId4Element().get());

      return f_HTMLPanel5;
    }

    /**
     * Getter for domId3 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for titleLbl called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_titleLbl() {
      return build_titleLbl();
    }
    private com.google.gwt.user.client.ui.Label build_titleLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label titleLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      titleLbl.setStyleName("" + get_res().css().myFolderCollectionTitle() + "");


      owner.titleLbl = titleLbl;

      return titleLbl;
    }

    /**
     * Getter for domId3Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for f_HTMLPanel6 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel6() {
      return build_f_HTMLPanel6();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel6() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel6 = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      f_HTMLPanel6.setStyleName("" + get_res().css().addResourceCloseButtonContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1950 = UiBinderUtil.attachToDom(f_HTMLPanel6.getElement());
      get_domId5Element().get();

      // Detach section.
      attachRecord1950.detach();
      f_HTMLPanel6.addAndReplaceElement(get_addResourceCloseButton(), get_domId5Element().get());

      return f_HTMLPanel6;
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
     * Getter for addResourceCloseButton called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_addResourceCloseButton() {
      return build_addResourceCloseButton();
    }
    private com.google.gwt.user.client.ui.Label build_addResourceCloseButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label addResourceCloseButton = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      addResourceCloseButton.setStyleName("" + get_res().css().addResourceCloseButton() + "");
      addResourceCloseButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.addResourceCloseButton = addResourceCloseButton;

      return addResourceCloseButton;
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
     * Getter for domId2Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for addResourceTabContainer called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_addResourceTabContainer() {
      return build_addResourceTabContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_addResourceTabContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel addResourceTabContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html12().asString());
      // Setup section.
      addResourceTabContainer.setStyleName("" + get_res().css().myFolderCollectionUrlContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1951 = UiBinderUtil.attachToDom(addResourceTabContainer.getElement());
      get_domId7Element().get();
      get_domId9Element().get();
      get_domId11Element().get();
      get_domId13Element().get();
      get_domId16Element().get();
      get_domId19Element().get();
      get_domId22Element().get();
      get_domId25Element().get();

      // Detach section.
      attachRecord1951.detach();
      addResourceTabContainer.addAndReplaceElement(get_urlTabButton(), get_domId7Element().get());
      addResourceTabContainer.addAndReplaceElement(get_myComputerTabButton(), get_domId9Element().get());
      addResourceTabContainer.addAndReplaceElement(get_searchTabButton(), get_domId11Element().get());
      addResourceTabContainer.addAndReplaceElement(get_questionTabButton(), get_domId13Element().get());
      addResourceTabContainer.addAndReplaceElement(get_multipleAnswerTabButton(), get_domId16Element().get());
      addResourceTabContainer.addAndReplaceElement(get_trueOrFlaseButton(), get_domId19Element().get());
      addResourceTabContainer.addAndReplaceElement(get_fillInTheBlankTabButton(), get_domId22Element().get());
      addResourceTabContainer.addAndReplaceElement(get_openEndedButton(), get_domId25Element().get());

      owner.addResourceTabContainer = addResourceTabContainer;

      return addResourceTabContainer;
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
     * Getter for urlTabButton called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_urlTabButton() {
      return build_urlTabButton();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_urlTabButton() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel urlTabButton = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html3().asString());
      // Setup section.
      urlTabButton.setStyleName("" + get_res().css().buttonDeSelected() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1952 = UiBinderUtil.attachToDom(urlTabButton.getElement());
      get_domId8Element().get();

      // Detach section.
      attachRecord1952.detach();
      urlTabButton.addAndReplaceElement(get_fromweb(), get_domId8Element().get());

      owner.urlTabButton = urlTabButton;

      return urlTabButton;
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
     * Getter for fromweb called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Anchor get_fromweb() {
      return build_fromweb();
    }
    private com.google.gwt.user.client.ui.Anchor build_fromweb() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor fromweb = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      fromweb.setStyleName("" + get_res().css().myFolderCollectionUrlbgTitle() + "");


      owner.fromweb = fromweb;

      return fromweb;
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
     * Getter for myComputerTabButton called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_myComputerTabButton() {
      return build_myComputerTabButton();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_myComputerTabButton() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel myComputerTabButton = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html4().asString());
      // Setup section.
      myComputerTabButton.setStyleName("" + get_res().css().buttonDeSelected() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1953 = UiBinderUtil.attachToDom(myComputerTabButton.getElement());
      get_domId10Element().get();

      // Detach section.
      attachRecord1953.detach();
      myComputerTabButton.addAndReplaceElement(get_fromfile(), get_domId10Element().get());

      owner.myComputerTabButton = myComputerTabButton;

      return myComputerTabButton;
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
     * Getter for fromfile called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Anchor get_fromfile() {
      return build_fromfile();
    }
    private com.google.gwt.user.client.ui.Anchor build_fromfile() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor fromfile = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      fromfile.setStyleName("" + get_res().css().myFolderCollectionUrlbgTitle() + "");


      owner.fromfile = fromfile;

      return fromfile;
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
     * Getter for searchTabButton called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_searchTabButton() {
      return build_searchTabButton();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_searchTabButton() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel searchTabButton = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html5().asString());
      // Setup section.
      searchTabButton.setStyleName("" + get_res().css().buttonDeSelected() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1954 = UiBinderUtil.attachToDom(searchTabButton.getElement());
      get_domId12Element().get();

      // Detach section.
      attachRecord1954.detach();
      searchTabButton.addAndReplaceElement(get_fromwsearch(), get_domId12Element().get());

      owner.searchTabButton = searchTabButton;

      return searchTabButton;
    }

    /**
     * Getter for domId12 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for fromwsearch called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Anchor get_fromwsearch() {
      return build_fromwsearch();
    }
    private com.google.gwt.user.client.ui.Anchor build_fromwsearch() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor fromwsearch = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      fromwsearch.setStyleName("" + get_res().css().myFolderCollectionUrlbgTitle() + "");


      owner.fromwsearch = fromwsearch;

      return fromwsearch;
    }

    /**
     * Getter for domId12Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for questionTabButton called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_questionTabButton() {
      return build_questionTabButton();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_questionTabButton() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel questionTabButton = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html6().asString());
      // Setup section.
      questionTabButton.setStyleName("" + get_res().css().buttonDeSelected() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1955 = UiBinderUtil.attachToDom(questionTabButton.getElement());
      get_domId14Element().get();
      get_domId15Element().get();

      // Detach section.
      attachRecord1955.detach();
      questionTabButton.addAndReplaceElement(get_multipleChoiceRadioButton(), get_domId14Element().get());
      questionTabButton.addAndReplaceElement(get_multiplechoice(), get_domId15Element().get());

      owner.questionTabButton = questionTabButton;

      return questionTabButton;
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
     * Getter for multipleChoiceRadioButton called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.RadioButton get_multipleChoiceRadioButton() {
      return build_multipleChoiceRadioButton();
    }
    private com.google.gwt.user.client.ui.RadioButton build_multipleChoiceRadioButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.RadioButton multipleChoiceRadioButton = new com.google.gwt.user.client.ui.RadioButton("questionTypeGrouop");
      // Setup section.
      multipleChoiceRadioButton.setStyleName("" + get_res().css().questionRadioButtonStyle() + "");
      multipleChoiceRadioButton.setChecked(true);


      owner.multipleChoiceRadioButton = multipleChoiceRadioButton;

      return multipleChoiceRadioButton;
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
     * Getter for multiplechoice called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Anchor get_multiplechoice() {
      return build_multiplechoice();
    }
    private com.google.gwt.user.client.ui.Anchor build_multiplechoice() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor multiplechoice = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      multiplechoice.setStyleName("" + get_res().css().myFolderCollectionUrlbgTitle() + "");


      owner.multiplechoice = multiplechoice;

      return multiplechoice;
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
     * Getter for multipleAnswerTabButton called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_multipleAnswerTabButton() {
      return build_multipleAnswerTabButton();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_multipleAnswerTabButton() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel multipleAnswerTabButton = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html8().asString());
      // Setup section.
      multipleAnswerTabButton.setStyleName("" + get_res().css().buttonDeSelected() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1956 = UiBinderUtil.attachToDom(multipleAnswerTabButton.getElement());
      get_domId17Element().get();
      get_domId18Element().get();

      // Detach section.
      attachRecord1956.detach();
      multipleAnswerTabButton.addAndReplaceElement(get_multipleAnswerRadioButton(), get_domId17Element().get());
      multipleAnswerTabButton.addAndReplaceElement(get_f_Anchor7(), get_domId18Element().get());

      owner.multipleAnswerTabButton = multipleAnswerTabButton;

      return multipleAnswerTabButton;
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
     * Getter for multipleAnswerRadioButton called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.RadioButton get_multipleAnswerRadioButton() {
      return build_multipleAnswerRadioButton();
    }
    private com.google.gwt.user.client.ui.RadioButton build_multipleAnswerRadioButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.RadioButton multipleAnswerRadioButton = new com.google.gwt.user.client.ui.RadioButton("questionTypeGrouop");
      // Setup section.
      multipleAnswerRadioButton.setStyleName("" + get_res().css().questionRadioButtonStyle() + "");


      owner.multipleAnswerRadioButton = multipleAnswerRadioButton;

      return multipleAnswerRadioButton;
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
     * Getter for domId18 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for f_Anchor7 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Anchor get_f_Anchor7() {
      return build_f_Anchor7();
    }
    private com.google.gwt.user.client.ui.Anchor build_f_Anchor7() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor f_Anchor7 = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      f_Anchor7.setHTML(template_html7().asString());
      f_Anchor7.setStyleName("" + get_res().css().myFolderCollectionUrlbgTitle() + "");


      return f_Anchor7;
    }

    /**
     * Getter for domId18Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId19 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for trueOrFlaseButton called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_trueOrFlaseButton() {
      return build_trueOrFlaseButton();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_trueOrFlaseButton() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel trueOrFlaseButton = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html9().asString());
      // Setup section.
      trueOrFlaseButton.setStyleName("" + get_res().css().buttonDeSelected() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1957 = UiBinderUtil.attachToDom(trueOrFlaseButton.getElement());
      get_domId20Element().get();
      get_domId21Element().get();

      // Detach section.
      attachRecord1957.detach();
      trueOrFlaseButton.addAndReplaceElement(get_trueOrFalseRadioButton(), get_domId20Element().get());
      trueOrFlaseButton.addAndReplaceElement(get_truefalase(), get_domId21Element().get());

      owner.trueOrFlaseButton = trueOrFlaseButton;

      return trueOrFlaseButton;
    }

    /**
     * Getter for domId20 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for trueOrFalseRadioButton called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.RadioButton get_trueOrFalseRadioButton() {
      return build_trueOrFalseRadioButton();
    }
    private com.google.gwt.user.client.ui.RadioButton build_trueOrFalseRadioButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.RadioButton trueOrFalseRadioButton = new com.google.gwt.user.client.ui.RadioButton("questionTypeGrouop");
      // Setup section.
      trueOrFalseRadioButton.setStyleName("" + get_res().css().questionRadioButtonStyle() + "");


      owner.trueOrFalseRadioButton = trueOrFalseRadioButton;

      return trueOrFalseRadioButton;
    }

    /**
     * Getter for domId20Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for truefalase called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Anchor get_truefalase() {
      return build_truefalase();
    }
    private com.google.gwt.user.client.ui.Anchor build_truefalase() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor truefalase = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      truefalase.setStyleName("" + get_res().css().myFolderCollectionUrlbgTitle() + "");


      owner.truefalase = truefalase;

      return truefalase;
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
     * Getter for domId19Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for fillInTheBlankTabButton called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_fillInTheBlankTabButton() {
      return build_fillInTheBlankTabButton();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_fillInTheBlankTabButton() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel fillInTheBlankTabButton = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html10().asString());
      // Setup section.
      fillInTheBlankTabButton.setStyleName("" + get_res().css().buttonDeSelected() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1958 = UiBinderUtil.attachToDom(fillInTheBlankTabButton.getElement());
      get_domId23Element().get();
      get_domId24Element().get();

      // Detach section.
      attachRecord1958.detach();
      fillInTheBlankTabButton.addAndReplaceElement(get_fillInTheBlankRadioButton(), get_domId23Element().get());
      fillInTheBlankTabButton.addAndReplaceElement(get_truefalseText(), get_domId24Element().get());

      owner.fillInTheBlankTabButton = fillInTheBlankTabButton;

      return fillInTheBlankTabButton;
    }

    /**
     * Getter for domId23 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for fillInTheBlankRadioButton called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.RadioButton get_fillInTheBlankRadioButton() {
      return build_fillInTheBlankRadioButton();
    }
    private com.google.gwt.user.client.ui.RadioButton build_fillInTheBlankRadioButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.RadioButton fillInTheBlankRadioButton = new com.google.gwt.user.client.ui.RadioButton("questionTypeGrouop");
      // Setup section.
      fillInTheBlankRadioButton.setStyleName("" + get_res().css().questionRadioButtonStyle() + "");


      owner.fillInTheBlankRadioButton = fillInTheBlankRadioButton;

      return fillInTheBlankRadioButton;
    }

    /**
     * Getter for domId23Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId24 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for truefalseText called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Anchor get_truefalseText() {
      return build_truefalseText();
    }
    private com.google.gwt.user.client.ui.Anchor build_truefalseText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor truefalseText = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      truefalseText.setStyleName("" + get_res().css().myFolderCollectionUrlbgTitle() + "");


      owner.truefalseText = truefalseText;

      return truefalseText;
    }

    /**
     * Getter for domId24Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for openEndedButton called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_openEndedButton() {
      return build_openEndedButton();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_openEndedButton() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel openEndedButton = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html11().asString());
      // Setup section.
      openEndedButton.setStyleName("" + get_res().css().buttonDeSelected() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1959 = UiBinderUtil.attachToDom(openEndedButton.getElement());
      get_domId26Element().get();
      get_domId27Element().get();

      // Detach section.
      attachRecord1959.detach();
      openEndedButton.addAndReplaceElement(get_openEndedRadioButton(), get_domId26Element().get());
      openEndedButton.addAndReplaceElement(get_openended(), get_domId27Element().get());

      owner.openEndedButton = openEndedButton;

      return openEndedButton;
    }

    /**
     * Getter for domId26 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for openEndedRadioButton called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.RadioButton get_openEndedRadioButton() {
      return build_openEndedRadioButton();
    }
    private com.google.gwt.user.client.ui.RadioButton build_openEndedRadioButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.RadioButton openEndedRadioButton = new com.google.gwt.user.client.ui.RadioButton("questionTypeGrouop");
      // Setup section.
      openEndedRadioButton.setStyleName("" + get_res().css().questionRadioButtonStyle() + "");


      owner.openEndedRadioButton = openEndedRadioButton;

      return openEndedRadioButton;
    }

    /**
     * Getter for domId26Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId27 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for openended called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Anchor get_openended() {
      return build_openended();
    }
    private com.google.gwt.user.client.ui.Anchor build_openended() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor openended = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      openended.setStyleName("" + get_res().css().myFolderCollectionUrlbgTitle() + "");


      owner.openended = openended;

      return openended;
    }

    /**
     * Getter for domId27Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for tabViewContainer called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_tabViewContainer() {
      return build_tabViewContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_tabViewContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel tabViewContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html13().asString());
      // Setup section.


      owner.tabViewContainer = tabViewContainer;

      return tabViewContainer;
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
     * Getter for domId1Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
  }
}
