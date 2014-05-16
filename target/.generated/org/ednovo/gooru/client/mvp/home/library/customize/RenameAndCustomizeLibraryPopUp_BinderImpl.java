package org.ednovo.gooru.client.mvp.home.library.customize;

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

public class RenameAndCustomizeLibraryPopUp_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.home.library.customize.RenameAndCustomizeLibraryPopUp>, org.ednovo.gooru.client.mvp.home.library.customize.RenameAndCustomizeLibraryPopUp.Binder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html2(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html3(String arg0);
     
    @Template("")
    SafeHtml html4();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html5(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html6(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html7(String arg0, String arg1, String arg2, String arg3);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html8(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html9(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html10(String arg0);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.home.library.customize.RenameAndCustomizeLibraryPopUp owner) {


    return new Widgets(owner).get_panelAssign();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.home.library.customize.RenameAndCustomizeLibraryPopUp owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onCancelClicked(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onbacktoLibrarybuttonClicked(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onEditcollectionbuttonClicked(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.home.library.customize.RenameAndCustomizeLibraryPopUp owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId14();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId16();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId17();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId15();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId14Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId16Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId17Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId15Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2(get_domId2(), get_domId3());
    }
    SafeHtml template_html3() {
      return template.html3(get_domId5());
    }
    SafeHtml template_html4() {
      return template.html4();
    }
    SafeHtml template_html5() {
      return template.html5(get_domId12(), get_domId13(), get_domId14());
    }
    SafeHtml template_html6() {
      return template.html6(get_domId16(), get_domId17());
    }
    SafeHtml template_html7() {
      return template.html7(get_domId9(), get_domId10(), get_domId11(), get_domId15());
    }
    SafeHtml template_html8() {
      return template.html8(get_domId7(), get_domId8());
    }
    SafeHtml template_html9() {
      return template.html9(get_domId1(), get_domId4(), get_domId6());
    }
    SafeHtml template_html10() {
      return template.html10(get_domId0());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.library.customize.RenameAndCustomizeLibraryPopUp_BinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.home.library.customize.RenameAndCustomizeLibraryPopUp_BinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.home.library.customize.RenameAndCustomizeLibraryPopUp_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.home.library.customize.RenameAndCustomizeLibraryPopUp_BinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.home.library.customize.RenameAndCustomizeLibraryPopUp_BinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 18 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.collection.preview.home.assign.AssignPopUpCBundle res;
    private org.ednovo.gooru.client.mvp.play.collection.preview.home.assign.AssignPopUpCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.mvp.play.collection.preview.home.assign.AssignPopUpCBundle build_res() {
      // Creation section.
      res = owner.res;
      assert res != null : "UiField res with 'provided = true' was null";
      // Setup section.


      return res;
    }

    /**
     * Getter for panelAssign called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelAssign() {
      return build_panelAssign();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelAssign() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelAssign = new com.google.gwt.user.client.ui.HTMLPanel(template_html10().asString());
      // Setup section.
      panelAssign.setStyleName("" + get_res().css().assign() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord373 = UiBinderUtil.attachToDom(panelAssign.getElement());
      get_domId0Element().get();

      // Detach section.
      attachRecord373.detach();
      panelAssign.addAndReplaceElement(get_f_HTMLPanel1(), get_domId0Element().get());

      owner.panelAssign = panelAssign;

      return panelAssign;
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
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      f_HTMLPanel1.setStyleName("" + get_res().css().assignContentLoginCustomize() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord374 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId1Element().get();
      get_domId4Element().get();
      get_domId6Element().get();

      // Detach section.
      attachRecord374.detach();
      f_HTMLPanel1.addAndReplaceElement(get_f_HTMLPanel2(), get_domId1Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_loadingImageLabel(), get_domId4Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_popupcontentCustomize(), get_domId6Element().get());

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
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_res().css().assignHeader() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord375 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_domId2Element().get();
      get_domId3Element().get();

      // Detach section.
      attachRecord375.detach();
      f_HTMLPanel2.addAndReplaceElement(get_customizeText(), get_domId2Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_cancelButton(), get_domId3Element().get());

      return f_HTMLPanel2;
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
     * Getter for customizeText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_customizeText() {
      return build_customizeText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_customizeText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel customizeText = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      customizeText.setStyleName("" + get_res().css().assignTitle() + "");


      owner.customizeText = customizeText;

      return customizeText;
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
     * Getter for cancelButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_cancelButton() {
      return build_cancelButton();
    }
    private com.google.gwt.user.client.ui.Label build_cancelButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label cancelButton = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      cancelButton.setStyleName("" + get_res().css().assignCloseMarker() + " " + get_res().css().assignSprite() + " " + get_res().css().assignCloseMark() + "");
      cancelButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.cancelButton = cancelButton;

      return cancelButton;
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
     * Getter for loadingImageLabel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_loadingImageLabel() {
      return build_loadingImageLabel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_loadingImageLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel loadingImageLabel = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      loadingImageLabel.setStyleName("" + get_res().css().loadingImageMainDiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord376 = UiBinderUtil.attachToDom(loadingImageLabel.getElement());
      get_domId5Element().get();

      // Detach section.
      attachRecord376.detach();
      loadingImageLabel.addAndReplaceElement(get_f_Label3(), get_domId5Element().get());

      owner.loadingImageLabel = loadingImageLabel;

      return loadingImageLabel;
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
     * Getter for f_Label3 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label3() {
      return build_f_Label3();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label3() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label3 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label3.setStyleName("" + get_res().css().loadingImageForSelfEditCustomize() + "");


      return f_Label3;
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
     * Getter for popupcontentCustomize called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_popupcontentCustomize() {
      return build_popupcontentCustomize();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_popupcontentCustomize() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel popupcontentCustomize = new com.google.gwt.user.client.ui.HTMLPanel(template_html8().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord377 = UiBinderUtil.attachToDom(popupcontentCustomize.getElement());
      get_domId7Element().get();
      get_domId8Element().get();

      // Detach section.
      attachRecord377.detach();
      popupcontentCustomize.addAndReplaceElement(get_loginCustom(), get_domId7Element().get());
      popupcontentCustomize.addAndReplaceElement(get_copyCollectionSuccess(), get_domId8Element().get());

      owner.popupcontentCustomize = popupcontentCustomize;

      return popupcontentCustomize;
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
     * Getter for loginCustom called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_loginCustom() {
      return build_loginCustom();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_loginCustom() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel loginCustom = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      loginCustom.setStyleName("" + get_res().css().conentLoginPop() + "");


      owner.loginCustom = loginCustom;

      return loginCustom;
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
     * Getter for copyCollectionSuccess called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_copyCollectionSuccess() {
      return build_copyCollectionSuccess();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_copyCollectionSuccess() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel copyCollectionSuccess = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.
      copyCollectionSuccess.setStyleName("" + get_res().css().popupContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord378 = UiBinderUtil.attachToDom(copyCollectionSuccess.getElement());
      get_domId9Element().get();
      get_domId10Element().get();
      get_domId11Element().get();
      get_domId15Element().get();

      // Detach section.
      attachRecord378.detach();
      copyCollectionSuccess.addAndReplaceElement(get_lblpopupTitle(), get_domId9Element().get());
      copyCollectionSuccess.addAndReplaceElement(get_assignDes(), get_domId10Element().get());
      copyCollectionSuccess.addAndReplaceElement(get_popupContentAssign(), get_domId11Element().get());
      copyCollectionSuccess.addAndReplaceElement(get_f_HTMLPanel4(), get_domId15Element().get());

      owner.copyCollectionSuccess = copyCollectionSuccess;

      return copyCollectionSuccess;
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
     * Getter for lblpopupTitle called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_lblpopupTitle() {
      return build_lblpopupTitle();
    }
    private com.google.gwt.user.client.ui.Label build_lblpopupTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblpopupTitle = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblpopupTitle.setStyleName("" + get_res().css().popupTitle() + "");


      owner.lblpopupTitle = lblpopupTitle;

      return lblpopupTitle;
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
     * Getter for assignDes called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_assignDes() {
      return build_assignDes();
    }
    private com.google.gwt.user.client.ui.Label build_assignDes() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label assignDes = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      assignDes.setStyleName("" + get_res().css().popupDesc() + "");


      owner.assignDes = assignDes;

      return assignDes;
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
     * Getter for popupContentAssign called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_popupContentAssign() {
      return build_popupContentAssign();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_popupContentAssign() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel popupContentAssign = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.
      popupContentAssign.setStyleName("" + get_res().css().popupTextbox() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord379 = UiBinderUtil.attachToDom(popupContentAssign.getElement());
      get_domId12Element().get();
      get_domId13Element().get();
      get_domId14Element().get();

      // Detach section.
      attachRecord379.detach();
      popupContentAssign.addAndReplaceElement(get_lbltxtBoxTitle(), get_domId12Element().get());
      popupContentAssign.addAndReplaceElement(get_copycollectionTextbox(), get_domId13Element().get());
      popupContentAssign.addAndReplaceElement(get_errorLabel(), get_domId14Element().get());

      return popupContentAssign;
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
     * Getter for lbltxtBoxTitle called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_lbltxtBoxTitle() {
      return build_lbltxtBoxTitle();
    }
    private com.google.gwt.user.client.ui.Label build_lbltxtBoxTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lbltxtBoxTitle = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lbltxtBoxTitle.setStyleName("" + get_res().css().txtboxDesc() + "");


      owner.lbltxtBoxTitle = lbltxtBoxTitle;

      return lbltxtBoxTitle;
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
     * Getter for copycollectionTextbox called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.TextBox get_copycollectionTextbox() {
      return build_copycollectionTextbox();
    }
    private com.google.gwt.user.client.ui.TextBox build_copycollectionTextbox() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox copycollectionTextbox = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.
      copycollectionTextbox.setStyleName("" + get_res().css().inputTextBoxSyle() + "");


      owner.copycollectionTextbox = copycollectionTextbox;

      return copycollectionTextbox;
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
     * Getter for errorLabel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_errorLabel() {
      return build_errorLabel();
    }
    private com.google.gwt.user.client.ui.Label build_errorLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label errorLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      errorLabel.setStyleName("" + get_res().css().txtboxerrorColor() + "");


      owner.errorLabel = errorLabel;

      return errorLabel;
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
     * Getter for domId15 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel4 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel4() {
      return build_f_HTMLPanel4();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel4 = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.
      f_HTMLPanel4.setStyleName("" + get_res().css().popupButtons() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord380 = UiBinderUtil.attachToDom(f_HTMLPanel4.getElement());
      get_domId16Element().get();
      get_domId17Element().get();

      // Detach section.
      attachRecord380.detach();
      f_HTMLPanel4.addAndReplaceElement(get_backtoLibrary(), get_domId16Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_editCollection(), get_domId17Element().get());

      return f_HTMLPanel4;
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
     * Getter for backtoLibrary called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Button get_backtoLibrary() {
      return build_backtoLibrary();
    }
    private com.google.gwt.user.client.ui.Button build_backtoLibrary() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button backtoLibrary = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      backtoLibrary.setStyleName("secondary");
      backtoLibrary.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.backtoLibrary = backtoLibrary;

      return backtoLibrary;
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
     * Getter for domId17 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for editCollection called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Button get_editCollection() {
      return build_editCollection();
    }
    private com.google.gwt.user.client.ui.Button build_editCollection() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button editCollection = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      editCollection.setStyleName("primary");
      editCollection.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);


      owner.editCollection = editCollection;

      return editCollection;
    }

    /**
     * Getter for domId17Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId15Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
