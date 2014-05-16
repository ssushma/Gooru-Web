package org.ednovo.gooru.client.mvp.shelf.collection;

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

public class CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareAlertPopup>, org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareAlertPopup.CollectionShareAlertPopupUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span>")
    SafeHtml html1(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html2(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html3(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html4(String arg0);
     
    @Template("")
    SafeHtml html5();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html6(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span> <span id='{5}'></span>")
    SafeHtml html7(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html8(String arg0, String arg1);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareAlertPopup owner) {


    return new Widgets(owner).get_shareAlertPopup();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareAlertPopup owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickOkBtn(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickGoBackBtn(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareAlertPopup owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1(get_domId1());
    }
    SafeHtml template_html2() {
      return template.html2(get_domId4());
    }
    SafeHtml template_html3() {
      return template.html3(get_domId6());
    }
    SafeHtml template_html4() {
      return template.html4(get_domId8());
    }
    SafeHtml template_html5() {
      return template.html5();
    }
    SafeHtml template_html6() {
      return template.html6(get_domId12(), get_domId13());
    }
    SafeHtml template_html7() {
      return template.html7(get_domId3(), get_domId5(), get_domId7(), get_domId9(), get_domId10(), get_domId11());
    }
    SafeHtml template_html8() {
      return template.html8(get_domId0(), get_domId2());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for style called 14 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style style;
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style get_style() {
      return style;
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style build_style() {
      // Creation section.
      style = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().style();
      // Setup section.
      style.ensureInjected();


      return style;
    }

    /**
     * Getter for shareAlertPopup called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_shareAlertPopup() {
      return build_shareAlertPopup();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_shareAlertPopup() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel shareAlertPopup = new com.google.gwt.user.client.ui.HTMLPanel(template_html8().asString());
      // Setup section.
      shareAlertPopup.setStyleName("" + get_style().shareAlertPopup() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord419 = UiBinderUtil.attachToDom(shareAlertPopup.getElement());
      get_domId0Element().get();
      get_domId2Element().get();

      // Detach section.
      attachRecord419.detach();
      shareAlertPopup.addAndReplaceElement(get_f_HTMLPanel1(), get_domId0Element().get());
      shareAlertPopup.addAndReplaceElement(get_alertBodyStyle(), get_domId2Element().get());

      owner.shareAlertPopup = shareAlertPopup;

      return shareAlertPopup;
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
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      f_HTMLPanel1.setStyleName("" + get_style().alertHeaderStyle() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord420 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId1Element().get();

      // Detach section.
      attachRecord420.detach();
      f_HTMLPanel1.addAndReplaceElement(get_shareMsgTitle(), get_domId1Element().get());

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
     * Getter for shareMsgTitle called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_shareMsgTitle() {
      return build_shareMsgTitle();
    }
    private com.google.gwt.user.client.ui.Label build_shareMsgTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label shareMsgTitle = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      shareMsgTitle.setStyleName("" + get_style().alertHeaderTxtStyle() + "");


      owner.shareMsgTitle = shareMsgTitle;

      return shareMsgTitle;
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
     * Getter for alertBodyStyle called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_alertBodyStyle() {
      return build_alertBodyStyle();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_alertBodyStyle() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel alertBodyStyle = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.
      alertBodyStyle.setStyleName("" + get_style().alertBodyStyle() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord421 = UiBinderUtil.attachToDom(alertBodyStyle.getElement());
      get_domId3Element().get();
      get_domId5Element().get();
      get_domId7Element().get();
      get_domId9Element().get();
      get_domId10Element().get();
      get_domId11Element().get();

      // Detach section.
      attachRecord421.detach();
      alertBodyStyle.addAndReplaceElement(get_f_HTMLPanel2(), get_domId3Element().get());
      alertBodyStyle.addAndReplaceElement(get_alertSuccessTitleTxt(), get_domId5Element().get());
      alertBodyStyle.addAndReplaceElement(get_alertSuccessTxt(), get_domId7Element().get());
      alertBodyStyle.addAndReplaceElement(get_privateResourceLbl(), get_domId9Element().get());
      alertBodyStyle.addAndReplaceElement(get_resourceHeaderPanel(), get_domId10Element().get());
      alertBodyStyle.addAndReplaceElement(get_buttonContainer(), get_domId11Element().get());

      owner.alertBodyStyle = alertBodyStyle;

      return alertBodyStyle;
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
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_style().alertSuccessMsgTxt() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord422 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_domId4Element().get();

      // Detach section.
      attachRecord422.detach();
      f_HTMLPanel2.addAndReplaceElement(get_gooruPublicShare(), get_domId4Element().get());

      return f_HTMLPanel2;
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
     * Getter for gooruPublicShare called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Image get_gooruPublicShare() {
      return build_gooruPublicShare();
    }
    private com.google.gwt.user.client.ui.Image build_gooruPublicShare() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image gooruPublicShare = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      gooruPublicShare.setStyleName("" + get_style().gooruPublicShare() + "");


      owner.gooruPublicShare = gooruPublicShare;

      return gooruPublicShare;
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
     * Getter for alertSuccessTitleTxt called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_alertSuccessTitleTxt() {
      return build_alertSuccessTitleTxt();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_alertSuccessTitleTxt() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel alertSuccessTitleTxt = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      alertSuccessTitleTxt.setStyleName("" + get_style().alertSuccessTitleTxt() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord423 = UiBinderUtil.attachToDom(alertSuccessTitleTxt.getElement());
      get_domId6Element().get();

      // Detach section.
      attachRecord423.detach();
      alertSuccessTitleTxt.addAndReplaceElement(get_shareMsgTxt(), get_domId6Element().get());

      owner.alertSuccessTitleTxt = alertSuccessTitleTxt;

      return alertSuccessTitleTxt;
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
     * Getter for shareMsgTxt called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_shareMsgTxt() {
      return build_shareMsgTxt();
    }
    private com.google.gwt.user.client.ui.Label build_shareMsgTxt() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label shareMsgTxt = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      shareMsgTxt.setStyleName("" + get_style().alertSuccessMsgTxt() + "");


      owner.shareMsgTxt = shareMsgTxt;

      return shareMsgTxt;
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
     * Getter for domId7 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for alertSuccessTxt called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_alertSuccessTxt() {
      return build_alertSuccessTxt();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_alertSuccessTxt() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel alertSuccessTxt = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      alertSuccessTxt.setStyleName("" + get_style().alertSuccessTxt() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord424 = UiBinderUtil.attachToDom(alertSuccessTxt.getElement());
      get_domId8Element().get();

      // Detach section.
      attachRecord424.detach();
      alertSuccessTxt.addAndReplaceElement(get_shareMsgLbl(), get_domId8Element().get());

      owner.alertSuccessTxt = alertSuccessTxt;

      return alertSuccessTxt;
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
     * Getter for shareMsgLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_shareMsgLbl() {
      return build_shareMsgLbl();
    }
    private com.google.gwt.user.client.ui.Label build_shareMsgLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label shareMsgLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      shareMsgLbl.setStyleName("" + get_style().alertSuccessMsgTxt() + "");


      owner.shareMsgLbl = shareMsgLbl;

      return shareMsgLbl;
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
     * Getter for domId7Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for privateResourceLbl called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_privateResourceLbl() {
      return build_privateResourceLbl();
    }
    private com.google.gwt.user.client.ui.Label build_privateResourceLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label privateResourceLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      privateResourceLbl.setStyleName("" + get_style().privateMsgTxt() + "");


      owner.privateResourceLbl = privateResourceLbl;

      return privateResourceLbl;
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
     * Getter for resourceHeaderPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.ScrollPanel get_resourceHeaderPanel() {
      return build_resourceHeaderPanel();
    }
    private com.google.gwt.user.client.ui.ScrollPanel build_resourceHeaderPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.ScrollPanel resourceHeaderPanel = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
      // Setup section.
      resourceHeaderPanel.add(get_privateResourcePanel());
      resourceHeaderPanel.setStyleName("" + get_style().resourceHeaderPanel() + "");


      owner.resourceHeaderPanel = resourceHeaderPanel;

      return resourceHeaderPanel;
    }

    /**
     * Getter for privateResourcePanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_privateResourcePanel() {
      return build_privateResourcePanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_privateResourcePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel privateResourcePanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.


      owner.privateResourcePanel = privateResourcePanel;

      return privateResourcePanel;
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
     * Getter for buttonContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_buttonContainer() {
      return build_buttonContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_buttonContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel buttonContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.
      buttonContainer.setStyleName("" + get_style().okSuccessBtn() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord425 = UiBinderUtil.attachToDom(buttonContainer.getElement());
      get_domId12Element().get();
      get_domId13Element().get();

      // Detach section.
      attachRecord425.detach();
      buttonContainer.addAndReplaceElement(get_goBackBtn(), get_domId12Element().get());
      buttonContainer.addAndReplaceElement(get_okButton(), get_domId13Element().get());

      owner.buttonContainer = buttonContainer;

      return buttonContainer;
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
     * Getter for goBackBtn called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.BlueButtonUc get_goBackBtn() {
      return build_goBackBtn();
    }
    private org.ednovo.gooru.client.uc.BlueButtonUc build_goBackBtn() {
      // Creation section.
      final org.ednovo.gooru.client.uc.BlueButtonUc goBackBtn = (org.ednovo.gooru.client.uc.BlueButtonUc) GWT.create(org.ednovo.gooru.client.uc.BlueButtonUc.class);
      // Setup section.
      goBackBtn.setStyleName("secondary " + get_style().marginRight() + "");
      goBackBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.goBackBtn = goBackBtn;

      return goBackBtn;
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
     * Getter for okButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.BlueButtonUc get_okButton() {
      return build_okButton();
    }
    private org.ednovo.gooru.client.uc.BlueButtonUc build_okButton() {
      // Creation section.
      final org.ednovo.gooru.client.uc.BlueButtonUc okButton = (org.ednovo.gooru.client.uc.BlueButtonUc) GWT.create(org.ednovo.gooru.client.uc.BlueButtonUc.class);
      // Setup section.
      okButton.setStyleName("primary");
      okButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.okButton = okButton;

      return okButton;
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
  }
}
