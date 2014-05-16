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

public class CollectionFormInPlayView_CollectionFormViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.shelf.collection.CollectionFormInPlayView>, org.ednovo.gooru.client.mvp.shelf.collection.CollectionFormInPlayView.CollectionFormViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html1(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html2(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html3(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <div styleName='{1}'> <span id='{2}'></span> </div>")
    SafeHtml html4(String arg0, String arg1, String arg2);
     
    @Template("")
    SafeHtml html5();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html6(String arg0, String arg1, String arg2, String arg3);
     
    @Template("")
    SafeHtml html7();
     
    @Template("")
    SafeHtml html8();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html9(String arg0, String arg1, String arg2);
     
    @Template("")
    SafeHtml html10();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html11(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span> <span id='{5}'></span> <span id='{6}'></span> <span id='{7}'></span>")
    SafeHtml html12(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html13(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html14(String arg0);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.shelf.collection.CollectionFormInPlayView owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.shelf.collection.CollectionFormInPlayView owner;


    public Widgets(final org.ednovo.gooru.client.mvp.shelf.collection.CollectionFormInPlayView owner) {
      this.owner = owner;
      build_createCollectionStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId17();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId18();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId19();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId20();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId16();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId21();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId22();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId14();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId24();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId25();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId15();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId23();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId26();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId17Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId18Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId19Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId20Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId16Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId21Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId22Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId14Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId24Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId25Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId15Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId23Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId26Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1(get_domId7(), get_domId8());
    }
    SafeHtml template_html2() {
      return template.html2(get_domId5(), get_domId6());
    }
    SafeHtml template_html3() {
      return template.html3(get_domId10(), get_domId11());
    }
    SafeHtml template_html4() {
      return template.html4(get_domId13(), "" + get_createCollectionStyle().formContainerinput() + "", get_domId14());
    }
    SafeHtml template_html5() {
      return template.html5();
    }
    SafeHtml template_html6() {
      return template.html6(get_domId17(), get_domId18(), get_domId19(), get_domId20());
    }
    SafeHtml template_html7() {
      return template.html7();
    }
    SafeHtml template_html8() {
      return template.html8();
    }
    SafeHtml template_html9() {
      return template.html9(get_domId16(), get_domId21(), get_domId22());
    }
    SafeHtml template_html10() {
      return template.html10();
    }
    SafeHtml template_html11() {
      return template.html11(get_domId24(), get_domId25());
    }
    SafeHtml template_html12() {
      return template.html12(get_domId2(), get_domId3(), get_domId4(), get_domId9(), get_domId12(), get_domId15(), get_domId23(), get_domId26());
    }
    SafeHtml template_html13() {
      return template.html13(get_domId1());
    }
    SafeHtml template_html14() {
      return template.html14(get_domId0());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionFormInPlayView_CollectionFormViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionFormInPlayView_CollectionFormViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.collection.CollectionFormInPlayView_CollectionFormViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.shelf.collection.CollectionFormInPlayView_CollectionFormViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.CollectionFormInPlayView_CollectionFormViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for createCollectionStyle called 38 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionFormInPlayView_CollectionFormViewUiBinderImpl_GenCss_createCollectionStyle createCollectionStyle;
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionFormInPlayView_CollectionFormViewUiBinderImpl_GenCss_createCollectionStyle get_createCollectionStyle() {
      return createCollectionStyle;
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionFormInPlayView_CollectionFormViewUiBinderImpl_GenCss_createCollectionStyle build_createCollectionStyle() {
      // Creation section.
      createCollectionStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().createCollectionStyle();
      // Setup section.
      createCollectionStyle.ensureInjected();


      return createCollectionStyle;
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
      f_HTMLPanel1.setStyleName("" + get_createCollectionStyle().UrlPopUp() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1606 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId0Element().get();

      // Detach section.
      attachRecord1606.detach();
      f_HTMLPanel1.addAndReplaceElement(get_shelfItemContent(), get_domId0Element().get());

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
     * Getter for shelfItemContent called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_shelfItemContent() {
      return build_shelfItemContent();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_shelfItemContent() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel shelfItemContent = new com.google.gwt.user.client.ui.HTMLPanel(template_html13().asString());
      // Setup section.
      shelfItemContent.setStyleName("" + get_createCollectionStyle().shelfItemContentDiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1607 = UiBinderUtil.attachToDom(shelfItemContent.getElement());
      get_domId1Element().get();

      // Detach section.
      attachRecord1607.detach();
      shelfItemContent.addAndReplaceElement(get_f_HTMLPanel2(), get_domId1Element().get());

      return shelfItemContent;
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
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html12().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_createCollectionStyle().shelfItemContentInnerDiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1608 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_domId2Element().get();
      get_domId3Element().get();
      get_domId4Element().get();
      get_domId9Element().get();
      get_domId12Element().get();
      get_domId15Element().get();
      get_domId23Element().get();
      get_domId26Element().get();

      // Detach section.
      attachRecord1608.detach();
      f_HTMLPanel2.addAndReplaceElement(get_collPopUpMainheading(), get_domId2Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_collPopUpSubheading(), get_domId3Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_f_HTMLPanel3(), get_domId4Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_gradeContainer(), get_domId9Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_courseContainer(), get_domId12Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_buttonFloPanel(), get_domId15Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_buttonMainContainer(), get_domId23Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_loadingTextLbl(), get_domId26Element().get());

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
     * Getter for collPopUpMainheading called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_collPopUpMainheading() {
      return build_collPopUpMainheading();
    }
    private com.google.gwt.user.client.ui.Label build_collPopUpMainheading() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label collPopUpMainheading = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      collPopUpMainheading.setStyleName("" + get_createCollectionStyle().dontWorrkText() + "");


      owner.collPopUpMainheading = collPopUpMainheading;

      return collPopUpMainheading;
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
     * Getter for collPopUpSubheading called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_collPopUpSubheading() {
      return build_collPopUpSubheading();
    }
    private com.google.gwt.user.client.ui.Label build_collPopUpSubheading() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label collPopUpSubheading = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      collPopUpSubheading.setStyleName("" + get_createCollectionStyle().contentDesc() + "");


      owner.collPopUpSubheading = collPopUpSubheading;

      return collPopUpSubheading;
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
     * Getter for f_HTMLPanel3 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel3() {
      return build_f_HTMLPanel3();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      f_HTMLPanel3.setStyleName("" + get_createCollectionStyle().formContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1609 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
      get_domId5Element().get();
      get_domId6Element().get();

      // Detach section.
      attachRecord1609.detach();
      f_HTMLPanel3.addAndReplaceElement(get_collTitleLbl(), get_domId5Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_f_HTMLPanel4(), get_domId6Element().get());

      return f_HTMLPanel3;
    }

    /**
     * Getter for domId5 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for collTitleLbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_collTitleLbl() {
      return build_collTitleLbl();
    }
    private com.google.gwt.user.client.ui.Label build_collTitleLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label collTitleLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      collTitleLbl.setStyleName("" + get_createCollectionStyle().formContainerLabel() + "");


      owner.collTitleLbl = collTitleLbl;

      return collTitleLbl;
    }

    /**
     * Getter for domId5Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for f_HTMLPanel4 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel4() {
      return build_f_HTMLPanel4();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel4 = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      f_HTMLPanel4.setStyleName("" + get_createCollectionStyle().formContainerinput() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1610 = UiBinderUtil.attachToDom(f_HTMLPanel4.getElement());
      get_domId7Element().get();
      get_domId8Element().get();

      // Detach section.
      attachRecord1610.detach();
      f_HTMLPanel4.addAndReplaceElement(get_collectionTitleTxtBox(), get_domId7Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_mandatoryErrorLbl(), get_domId8Element().get());

      return f_HTMLPanel4;
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
     * Getter for collectionTitleTxtBox called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.uc.TextBoxWithPlaceholder get_collectionTitleTxtBox() {
      return build_collectionTitleTxtBox();
    }
    private org.ednovo.gooru.client.uc.TextBoxWithPlaceholder build_collectionTitleTxtBox() {
      // Creation section.
      final org.ednovo.gooru.client.uc.TextBoxWithPlaceholder collectionTitleTxtBox = (org.ednovo.gooru.client.uc.TextBoxWithPlaceholder) GWT.create(org.ednovo.gooru.client.uc.TextBoxWithPlaceholder.class);
      // Setup section.
      collectionTitleTxtBox.setStyleName("" + get_createCollectionStyle().textBoxWithPlaceholderText() + "");


      owner.collectionTitleTxtBox = collectionTitleTxtBox;

      return collectionTitleTxtBox;
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
     * Getter for domId8 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for mandatoryErrorLbl called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_mandatoryErrorLbl() {
      return build_mandatoryErrorLbl();
    }
    private com.google.gwt.user.client.ui.Label build_mandatoryErrorLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label mandatoryErrorLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      mandatoryErrorLbl.setStyleName("" + get_createCollectionStyle().mandatoryLabel() + "");


      owner.mandatoryErrorLbl = mandatoryErrorLbl;

      return mandatoryErrorLbl;
    }

    /**
     * Getter for domId8Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for gradeContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_gradeContainer() {
      return build_gradeContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_gradeContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel gradeContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      gradeContainer.setStyleName("" + get_createCollectionStyle().formContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1611 = UiBinderUtil.attachToDom(gradeContainer.getElement());
      get_domId10Element().get();
      get_domId11Element().get();

      // Detach section.
      attachRecord1611.detach();
      gradeContainer.addAndReplaceElement(get_gradeLbl(), get_domId10Element().get());
      gradeContainer.addAndReplaceElement(get_collectionGradeTxtBox(), get_domId11Element().get());

      return gradeContainer;
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
     * Getter for gradeLbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_gradeLbl() {
      return build_gradeLbl();
    }
    private com.google.gwt.user.client.ui.Label build_gradeLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label gradeLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      gradeLbl.setStyleName("" + get_createCollectionStyle().formContainerLabel() + "");


      owner.gradeLbl = gradeLbl;

      return gradeLbl;
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
     * Getter for collectionGradeTxtBox called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_collectionGradeTxtBox() {
      return build_collectionGradeTxtBox();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_collectionGradeTxtBox() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel collectionGradeTxtBox = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.
      collectionGradeTxtBox.setStyleName("" + get_createCollectionStyle().formContainerinput() + "");


      owner.collectionGradeTxtBox = collectionGradeTxtBox;

      return collectionGradeTxtBox;
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
     * Getter for courseContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_courseContainer() {
      return build_courseContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_courseContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel courseContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      courseContainer.setStyleName("" + get_createCollectionStyle().formContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1612 = UiBinderUtil.attachToDom(courseContainer.getElement());
      get_domId13Element().get();
      get_domId14Element().get();

      // Detach section.
      attachRecord1612.detach();
      courseContainer.addAndReplaceElement(get_courseLbl(), get_domId13Element().get());
      courseContainer.addAndReplaceElement(get_groupSimPanel(), get_domId14Element().get());

      return courseContainer;
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
     * Getter for courseLbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_courseLbl() {
      return build_courseLbl();
    }
    private com.google.gwt.user.client.ui.Label build_courseLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label courseLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      courseLbl.setStyleName("" + get_createCollectionStyle().formContainerLabel() + "");


      owner.courseLbl = courseLbl;

      return courseLbl;
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
     * Getter for groupSimPanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_groupSimPanel() {
      return build_groupSimPanel();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_groupSimPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel groupSimPanel = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.


      owner.groupSimPanel = groupSimPanel;

      return groupSimPanel;
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
     * Getter for buttonFloPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_buttonFloPanel() {
      return build_buttonFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_buttonFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel buttonFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      buttonFloPanel.add(get_lblVisibility());
      buttonFloPanel.add(get_visibilitySection());
      buttonFloPanel.add(get_f_HTMLPanel7());
      buttonFloPanel.setStyleName("" + get_createCollectionStyle().contentAlign() + " " + get_createCollectionStyle().actionField() + "");


      owner.buttonFloPanel = buttonFloPanel;

      return buttonFloPanel;
    }

    /**
     * Getter for lblVisibility called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_lblVisibility() {
      return build_lblVisibility();
    }
    private com.google.gwt.user.client.ui.Label build_lblVisibility() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblVisibility = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblVisibility.setStyleName("" + get_createCollectionStyle().visibilityMainTitle() + "");


      owner.lblVisibility = lblVisibility;

      return lblVisibility;
    }

    /**
     * Getter for visibilitySection called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_visibilitySection() {
      return build_visibilitySection();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_visibilitySection() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel visibilitySection = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      visibilitySection.setStyleName("" + get_createCollectionStyle().visibilitySection() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1613 = UiBinderUtil.attachToDom(visibilitySection.getElement());
      get_domId16Element().get();
      get_domId21Element().get();
      get_domId22Element().get();

      // Detach section.
      attachRecord1613.detach();
      visibilitySection.addAndReplaceElement(get_publicShareFloPanel(), get_domId16Element().get());
      visibilitySection.addAndReplaceElement(get_linkShareFloPanel(), get_domId21Element().get());
      visibilitySection.addAndReplaceElement(get_privateShareFloPanel(), get_domId22Element().get());

      return visibilitySection;
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
     * Getter for publicShareFloPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_publicShareFloPanel() {
      return build_publicShareFloPanel();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_publicShareFloPanel() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel publicShareFloPanel = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html6().asString());
      // Setup section.
      publicShareFloPanel.setStyleName("" + get_createCollectionStyle().showShareInnerDiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1614 = UiBinderUtil.attachToDom(publicShareFloPanel.getElement());
      get_domId17Element().get();
      get_domId18Element().get();
      get_domId19Element().get();
      get_domId20Element().get();

      // Detach section.
      attachRecord1614.detach();
      publicShareFloPanel.addAndReplaceElement(get_publicRadioButtonPanel(), get_domId17Element().get());
      publicShareFloPanel.addAndReplaceElement(get_publicLbl(), get_domId18Element().get());
      publicShareFloPanel.addAndReplaceElement(get_lblPublic(), get_domId19Element().get());
      publicShareFloPanel.addAndReplaceElement(get_lblAllow(), get_domId20Element().get());

      owner.publicShareFloPanel = publicShareFloPanel;

      return publicShareFloPanel;
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
     * Getter for publicRadioButtonPanel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_publicRadioButtonPanel() {
      return build_publicRadioButtonPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_publicRadioButtonPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel publicRadioButtonPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.
      publicRadioButtonPanel.setStyleName("" + get_createCollectionStyle().radioButtonPanel() + "");


      owner.publicRadioButtonPanel = publicRadioButtonPanel;

      return publicRadioButtonPanel;
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
     * Getter for publicLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_publicLbl() {
      return build_publicLbl();
    }
    private com.google.gwt.user.client.ui.Label build_publicLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label publicLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      publicLbl.setStyleName("" + get_createCollectionStyle().publicImage() + "");


      return publicLbl;
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
     * Getter for lblPublic called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_lblPublic() {
      return build_lblPublic();
    }
    private com.google.gwt.user.client.ui.Label build_lblPublic() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblPublic = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblPublic.setStyleName("" + get_createCollectionStyle().publicText() + "");


      owner.lblPublic = lblPublic;

      return lblPublic;
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
     * Getter for lblAllow called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_lblAllow() {
      return build_lblAllow();
    }
    private com.google.gwt.user.client.ui.Label build_lblAllow() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblAllow = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblAllow.setStyleName("" + get_createCollectionStyle().visibilityText() + "");


      owner.lblAllow = lblAllow;

      return lblAllow;
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
     * Getter for domId21 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for linkShareFloPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_linkShareFloPanel() {
      return build_linkShareFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_linkShareFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel linkShareFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      linkShareFloPanel.add(get_shareRadioButtonPanel());
      linkShareFloPanel.add(get_f_Label5());
      linkShareFloPanel.add(get_lblShareable());
      linkShareFloPanel.add(get_lblShareableDesc());
      linkShareFloPanel.setStyleName("" + get_createCollectionStyle().showShareInnerDiv() + "");


      return linkShareFloPanel;
    }

    /**
     * Getter for shareRadioButtonPanel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_shareRadioButtonPanel() {
      return build_shareRadioButtonPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_shareRadioButtonPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel shareRadioButtonPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.
      shareRadioButtonPanel.setStyleName("" + get_createCollectionStyle().radioButtonPanel() + "");


      owner.shareRadioButtonPanel = shareRadioButtonPanel;

      return shareRadioButtonPanel;
    }

    /**
     * Getter for f_Label5 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label5() {
      return build_f_Label5();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label5() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label5 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label5.setStyleName("" + get_createCollectionStyle().linkImage() + "");


      return f_Label5;
    }

    /**
     * Getter for lblShareable called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_lblShareable() {
      return build_lblShareable();
    }
    private com.google.gwt.user.client.ui.Label build_lblShareable() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblShareable = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblShareable.setStyleName("" + get_createCollectionStyle().publicText() + "");


      owner.lblShareable = lblShareable;

      return lblShareable;
    }

    /**
     * Getter for lblShareableDesc called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_lblShareableDesc() {
      return build_lblShareableDesc();
    }
    private com.google.gwt.user.client.ui.Label build_lblShareableDesc() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblShareableDesc = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblShareableDesc.setStyleName("" + get_createCollectionStyle().visibilityText() + "");


      owner.lblShareableDesc = lblShareableDesc;

      return lblShareableDesc;
    }

    /**
     * Getter for domId21Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for privateShareFloPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_privateShareFloPanel() {
      return build_privateShareFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_privateShareFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel privateShareFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      privateShareFloPanel.add(get_privateRadioButtonPanel());
      privateShareFloPanel.add(get_f_Label6());
      privateShareFloPanel.add(get_lblPrivate());
      privateShareFloPanel.add(get_lblPrivateDesc());
      privateShareFloPanel.setStyleName("" + get_createCollectionStyle().showShareInnerDiv() + "");


      return privateShareFloPanel;
    }

    /**
     * Getter for privateRadioButtonPanel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_privateRadioButtonPanel() {
      return build_privateRadioButtonPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_privateRadioButtonPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel privateRadioButtonPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html8().asString());
      // Setup section.
      privateRadioButtonPanel.setStyleName("" + get_createCollectionStyle().radioButtonPanel() + "");


      owner.privateRadioButtonPanel = privateRadioButtonPanel;

      return privateRadioButtonPanel;
    }

    /**
     * Getter for f_Label6 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label6() {
      return build_f_Label6();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label6() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label6 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label6.setStyleName("" + get_createCollectionStyle().privateImage() + "");


      return f_Label6;
    }

    /**
     * Getter for lblPrivate called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_lblPrivate() {
      return build_lblPrivate();
    }
    private com.google.gwt.user.client.ui.Label build_lblPrivate() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblPrivate = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblPrivate.setStyleName("" + get_createCollectionStyle().publicText() + "");


      owner.lblPrivate = lblPrivate;

      return lblPrivate;
    }

    /**
     * Getter for lblPrivateDesc called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_lblPrivateDesc() {
      return build_lblPrivateDesc();
    }
    private com.google.gwt.user.client.ui.Label build_lblPrivateDesc() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblPrivateDesc = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblPrivateDesc.setStyleName("" + get_createCollectionStyle().visibilityText() + "");


      owner.lblPrivateDesc = lblPrivateDesc;

      return lblPrivateDesc;
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
     * Getter for f_HTMLPanel7 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel7() {
      return build_f_HTMLPanel7();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel7() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel7 = new com.google.gwt.user.client.ui.HTMLPanel(template_html10().asString());
      // Setup section.
      f_HTMLPanel7.setStyleName("" + get_createCollectionStyle().clearStyle() + "");


      return f_HTMLPanel7;
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
     * Getter for buttonMainContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_buttonMainContainer() {
      return build_buttonMainContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_buttonMainContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel buttonMainContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html11().asString());
      // Setup section.
      buttonMainContainer.setStyleName("" + get_createCollectionStyle().formViewButtonContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1615 = UiBinderUtil.attachToDom(buttonMainContainer.getElement());
      get_domId24Element().get();
      get_domId25Element().get();

      // Detach section.
      attachRecord1615.detach();
      buttonMainContainer.addAndReplaceElement(get_cancelAnr(), get_domId24Element().get());
      buttonMainContainer.addAndReplaceElement(get_btnOk(), get_domId25Element().get());

      owner.buttonMainContainer = buttonMainContainer;

      return buttonMainContainer;
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
     * Getter for cancelAnr called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Button get_cancelAnr() {
      return build_cancelAnr();
    }
    private com.google.gwt.user.client.ui.Button build_cancelAnr() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button cancelAnr = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      cancelAnr.setStyleName("secondary");


      owner.cancelAnr = cancelAnr;

      return cancelAnr;
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
     * Getter for domId25 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for btnOk called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Button get_btnOk() {
      return build_btnOk();
    }
    private com.google.gwt.user.client.ui.Button build_btnOk() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button btnOk = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      btnOk.setStyleName("primary");


      owner.btnOk = btnOk;

      return btnOk;
    }

    /**
     * Getter for domId25Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for loadingTextLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_loadingTextLbl() {
      return build_loadingTextLbl();
    }
    private com.google.gwt.user.client.ui.Label build_loadingTextLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label loadingTextLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      loadingTextLbl.setStyleName("" + get_createCollectionStyle().formViewButtonContainer() + "");


      owner.loadingTextLbl = loadingTextLbl;

      return loadingTextLbl;
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
  }
}
