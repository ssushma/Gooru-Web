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

public class CollectionShareTabVc_CollectionShareTabVcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareTabVc>, org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareTabVc.CollectionShareTabVcUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span>")
    SafeHtml html1(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html2(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html3(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html4(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html5(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html6(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html7(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html8(String arg0, String arg1, String arg2);
     
    @Template("")
    SafeHtml html9();
     
    @Template("")
    SafeHtml html10();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html11(String arg0, String arg1);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareTabVc owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareTabVc owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickAddTeacherTip(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickcancelTeacherTip(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareTabVc owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_res1();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
    }

    SafeHtml template_html1() {
      return template.html1(get_domId0());
    }
    SafeHtml template_html2() {
      return template.html2(get_domId1());
    }
    SafeHtml template_html3() {
      return template.html3(get_domId2());
    }
    SafeHtml template_html4() {
      return template.html4(get_domId3());
    }
    SafeHtml template_html5() {
      return template.html5(get_domId6());
    }
    SafeHtml template_html6() {
      return template.html6(get_domId4(), get_domId5());
    }
    SafeHtml template_html7() {
      return template.html7(get_domId10(), get_domId11());
    }
    SafeHtml template_html8() {
      return template.html8(get_domId7(), get_domId8(), get_domId9());
    }
    SafeHtml template_html9() {
      return template.html9();
    }
    SafeHtml template_html10() {
      return template.html10();
    }
    SafeHtml template_html11() {
      return template.html11(get_domId12(), get_domId13());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareTabVc_CollectionShareTabVcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareTabVc_CollectionShareTabVcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareTabVc_CollectionShareTabVcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareTabVc_CollectionShareTabVcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareTabVc_CollectionShareTabVcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 27 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.ShelfCBundle res;
    private org.ednovo.gooru.client.mvp.shelf.ShelfCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.mvp.shelf.ShelfCBundle build_res() {
      // Creation section.
      res = (org.ednovo.gooru.client.mvp.shelf.ShelfCBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.ShelfCBundle.class);
      // Setup section.


      return res;
    }

    /**
     * Getter for res1 called 7 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle res1;
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle get_res1() {
      return res1;
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle build_res1() {
      // Creation section.
      res1 = (org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle.class);
      // Setup section.


      return res1;
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
      f_FlowPanel1.add(get_loadingImageLabel());
      f_FlowPanel1.add(get_mainShareContainer());


      return f_FlowPanel1;
    }

    /**
     * Getter for loadingImageLabel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_loadingImageLabel() {
      return build_loadingImageLabel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_loadingImageLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel loadingImageLabel = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      loadingImageLabel.setStyleName("" + get_res().css().loadingImageMainDivShare() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord348 = UiBinderUtil.attachToDom(loadingImageLabel.getElement());
      get_domId0Element().get();

      // Detach section.
      attachRecord348.detach();
      loadingImageLabel.addAndReplaceElement(get_f_Label2(), get_domId0Element().get());

      owner.loadingImageLabel = loadingImageLabel;

      return loadingImageLabel;
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
      f_Label2.setStyleName("" + get_res().css().loadingImageForShare() + "");


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
     * Getter for mainShareContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_mainShareContainer() {
      return build_mainShareContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_mainShareContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel mainShareContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      mainShareContainer.add(get_f_FlowPanel3());
      mainShareContainer.add(get_publicShareFloPanel());
      mainShareContainer.add(get_linkShareFloPanel());
      mainShareContainer.add(get_privateShareFloPanel());
      mainShareContainer.add(get_f_FlowPanel8());
      mainShareContainer.add(get_finalTeacherTipLabelContainer());
      mainShareContainer.add(get_textAreaContianer());
      mainShareContainer.add(get_f_FlowPanel12());
      mainShareContainer.add(get_shareLinkFloPanel());


      owner.mainShareContainer = mainShareContainer;

      return mainShareContainer;
    }

    /**
     * Getter for f_FlowPanel3 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel3() {
      return build_f_FlowPanel3();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel3 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel3.add(get_visibilityText());
      f_FlowPanel3.add(get_f_FlowPanel4());
      f_FlowPanel3.add(get_visibilityOptiontext());
      f_FlowPanel3.setStyleName("" + get_res().css().collectionVisibilityMainDiv() + "");


      return f_FlowPanel3;
    }

    /**
     * Getter for visibilityText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_visibilityText() {
      return build_visibilityText();
    }
    private com.google.gwt.user.client.ui.Label build_visibilityText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label visibilityText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      visibilityText.setStyleName("" + get_res().css().collectionVisibilityMain() + "");


      owner.visibilityText = visibilityText;

      return visibilityText;
    }

    /**
     * Getter for f_FlowPanel4 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel4() {
      return build_f_FlowPanel4();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel4 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel4.setStyleName("" + get_res().css().collectionVisibleShareLineSeparator() + "");


      return f_FlowPanel4;
    }

    /**
     * Getter for visibilityOptiontext called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_visibilityOptiontext() {
      return build_visibilityOptiontext();
    }
    private com.google.gwt.user.client.ui.Label build_visibilityOptiontext() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label visibilityOptiontext = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      visibilityOptiontext.setStyleName("" + get_res().css().collectionVisibility() + "");


      owner.visibilityOptiontext = visibilityOptiontext;

      return visibilityOptiontext;
    }

    /**
     * Getter for publicShareFloPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_publicShareFloPanel() {
      return build_publicShareFloPanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_publicShareFloPanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel publicShareFloPanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html2().asString());
      // Setup section.
      publicShareFloPanel.setStyleName("" + get_res().css().showShareInnerDiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord349 = UiBinderUtil.attachToDom(publicShareFloPanel.getElement());
      get_domId1Element().get();

      // Detach section.
      attachRecord349.detach();
      publicShareFloPanel.addAndReplaceElement(get_f_Label5(), get_domId1Element().get());

      owner.publicShareFloPanel = publicShareFloPanel;

      return publicShareFloPanel;
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
     * Getter for f_Label5 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label5() {
      return build_f_Label5();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label5() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label5 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label5.setStyleName("" + get_res().css().publicVisibleIcon() + " " + get_res().css().publicVisibleIconBottom() + "");


      return f_Label5;
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
     * Getter for linkShareFloPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_linkShareFloPanel() {
      return build_linkShareFloPanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_linkShareFloPanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel linkShareFloPanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html3().asString());
      // Setup section.
      linkShareFloPanel.setStyleName("" + get_res().css().showShareInnerDiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord350 = UiBinderUtil.attachToDom(linkShareFloPanel.getElement());
      get_domId2Element().get();

      // Detach section.
      attachRecord350.detach();
      linkShareFloPanel.addAndReplaceElement(get_f_Label6(), get_domId2Element().get());

      owner.linkShareFloPanel = linkShareFloPanel;

      return linkShareFloPanel;
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
     * Getter for f_Label6 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label6() {
      return build_f_Label6();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label6() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label6 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label6.setStyleName("" + get_res().css().linkVisibleIcon() + " " + get_res().css().shareableVisibleIconBottom() + "");


      return f_Label6;
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
     * Getter for privateShareFloPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_privateShareFloPanel() {
      return build_privateShareFloPanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_privateShareFloPanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel privateShareFloPanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html4().asString());
      // Setup section.
      privateShareFloPanel.setStyleName("" + get_res().css().showShareInnerDiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord351 = UiBinderUtil.attachToDom(privateShareFloPanel.getElement());
      get_domId3Element().get();

      // Detach section.
      attachRecord351.detach();
      privateShareFloPanel.addAndReplaceElement(get_f_Label7(), get_domId3Element().get());

      owner.privateShareFloPanel = privateShareFloPanel;

      return privateShareFloPanel;
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
     * Getter for f_Label7 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label7() {
      return build_f_Label7();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label7() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label7 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label7.setStyleName("" + get_res().css().privateVisibleIcon() + " " + get_res().css().privateVisibleIconBottom() + "");


      return f_Label7;
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
     * Getter for f_FlowPanel8 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel8() {
      return build_f_FlowPanel8();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel8() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel8 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel8.add(get_visibilityTextTeacherTip());
      f_FlowPanel8.add(get_f_FlowPanel9());
      f_FlowPanel8.add(get_visibilityOptiontextTeacherTip());
      f_FlowPanel8.setStyleName("" + get_res().css().collectionVisibilityMainDiv() + "");


      return f_FlowPanel8;
    }

    /**
     * Getter for visibilityTextTeacherTip called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_visibilityTextTeacherTip() {
      return build_visibilityTextTeacherTip();
    }
    private com.google.gwt.user.client.ui.Label build_visibilityTextTeacherTip() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label visibilityTextTeacherTip = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      visibilityTextTeacherTip.setStyleName("" + get_res().css().collectionVisibilityMain() + "");


      owner.visibilityTextTeacherTip = visibilityTextTeacherTip;

      return visibilityTextTeacherTip;
    }

    /**
     * Getter for f_FlowPanel9 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel9() {
      return build_f_FlowPanel9();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel9() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel9 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel9.setStyleName("" + get_res().css().collectionVisibleShareLineSeparator() + "");


      return f_FlowPanel9;
    }

    /**
     * Getter for visibilityOptiontextTeacherTip called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_visibilityOptiontextTeacherTip() {
      return build_visibilityOptiontextTeacherTip();
    }
    private com.google.gwt.user.client.ui.Label build_visibilityOptiontextTeacherTip() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label visibilityOptiontextTeacherTip = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      visibilityOptiontextTeacherTip.setStyleName("" + get_res().css().collectionVisibility() + "");


      owner.visibilityOptiontextTeacherTip = visibilityOptiontextTeacherTip;

      return visibilityOptiontextTeacherTip;
    }

    /**
     * Getter for finalTeacherTipLabelContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_finalTeacherTipLabelContainer() {
      return build_finalTeacherTipLabelContainer();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_finalTeacherTipLabelContainer() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel finalTeacherTipLabelContainer = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html6().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord352 = UiBinderUtil.attachToDom(finalTeacherTipLabelContainer.getElement());
      get_domId4Element().get();
      get_domId5Element().get();

      // Detach section.
      attachRecord352.detach();
      finalTeacherTipLabelContainer.addAndReplaceElement(get_userTeacherTipText(), get_domId4Element().get());
      finalTeacherTipLabelContainer.addAndReplaceElement(get_f_HTMLPanel10(), get_domId5Element().get());

      owner.finalTeacherTipLabelContainer = finalTeacherTipLabelContainer;

      return finalTeacherTipLabelContainer;
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
     * Getter for userTeacherTipText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_userTeacherTipText() {
      return build_userTeacherTipText();
    }
    private com.google.gwt.user.client.ui.Label build_userTeacherTipText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label userTeacherTipText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      userTeacherTipText.setStyleName("" + get_res1().css().teacherTipLabel() + "");


      owner.userTeacherTipText = userTeacherTipText;

      return userTeacherTipText;
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
     * Getter for f_HTMLPanel10 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel10() {
      return build_f_HTMLPanel10();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel10() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel10 = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.
      f_HTMLPanel10.setStyleName("" + get_res1().css().teacherTipPencilHolder() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord353 = UiBinderUtil.attachToDom(f_HTMLPanel10.getElement());
      get_domId6Element().get();

      // Detach section.
      attachRecord353.detach();
      f_HTMLPanel10.addAndReplaceElement(get_simplePencilPanel(), get_domId6Element().get());

      return f_HTMLPanel10;
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
     * Getter for simplePencilPanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_simplePencilPanel() {
      return build_simplePencilPanel();
    }
    private com.google.gwt.user.client.ui.Label build_simplePencilPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label simplePencilPanel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      simplePencilPanel.setStyleName("" + get_res().css().collectionEditImageTeacherTip() + "");


      owner.simplePencilPanel = simplePencilPanel;

      return simplePencilPanel;
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
     * Getter for textAreaContianer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_textAreaContianer() {
      return build_textAreaContianer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_textAreaContianer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel textAreaContianer = new com.google.gwt.user.client.ui.HTMLPanel(template_html8().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord354 = UiBinderUtil.attachToDom(textAreaContianer.getElement());
      get_domId7Element().get();
      get_domId8Element().get();
      get_domId9Element().get();

      // Detach section.
      attachRecord354.detach();
      textAreaContianer.addAndReplaceElement(get_teacherTipTextarea(), get_domId7Element().get());
      textAreaContianer.addAndReplaceElement(get_errorLabelForTeacherTip(), get_domId8Element().get());
      textAreaContianer.addAndReplaceElement(get_f_HTMLPanel11(), get_domId9Element().get());

      owner.textAreaContianer = textAreaContianer;

      return textAreaContianer;
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
     * Getter for teacherTipTextarea called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.TextArea get_teacherTipTextarea() {
      return build_teacherTipTextarea();
    }
    private com.google.gwt.user.client.ui.TextArea build_teacherTipTextarea() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextArea teacherTipTextarea = (com.google.gwt.user.client.ui.TextArea) GWT.create(com.google.gwt.user.client.ui.TextArea.class);
      // Setup section.
      teacherTipTextarea.setStyleName("" + get_res1().css().shelfGradeTeacherTipTextbox() + "");


      owner.teacherTipTextarea = teacherTipTextarea;

      return teacherTipTextarea;
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
     * Getter for errorLabelForTeacherTip called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_errorLabelForTeacherTip() {
      return build_errorLabelForTeacherTip();
    }
    private com.google.gwt.user.client.ui.Label build_errorLabelForTeacherTip() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label errorLabelForTeacherTip = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      errorLabelForTeacherTip.setStyleName("errorMessage " + get_res1().css().shelfGradeTeacherTipError() + "");


      owner.errorLabelForTeacherTip = errorLabelForTeacherTip;

      return errorLabelForTeacherTip;
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
     * Getter for f_HTMLPanel11 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel11() {
      return build_f_HTMLPanel11();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel11() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel11 = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.
      f_HTMLPanel11.setStyleName("" + get_res1().css().shelfGradeTeacherTipButtonsContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord355 = UiBinderUtil.attachToDom(f_HTMLPanel11.getElement());
      get_domId10Element().get();
      get_domId11Element().get();

      // Detach section.
      attachRecord355.detach();
      f_HTMLPanel11.addAndReplaceElement(get_addTeacherTip(), get_domId10Element().get());
      f_HTMLPanel11.addAndReplaceElement(get_cancelTeacherTip(), get_domId11Element().get());

      return f_HTMLPanel11;
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
     * Getter for addTeacherTip called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Button get_addTeacherTip() {
      return build_addTeacherTip();
    }
    private com.google.gwt.user.client.ui.Button build_addTeacherTip() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button addTeacherTip = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      addTeacherTip.setStyleName("primary " + get_res1().css().shelfTeacherTipButtons() + "");
      addTeacherTip.setText("Save");
      addTeacherTip.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.addTeacherTip = addTeacherTip;

      return addTeacherTip;
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
     * Getter for cancelTeacherTip called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Button get_cancelTeacherTip() {
      return build_cancelTeacherTip();
    }
    private com.google.gwt.user.client.ui.Button build_cancelTeacherTip() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button cancelTeacherTip = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      cancelTeacherTip.setStyleName("secondary " + get_res1().css().shelfTeacherTipButtonsCancel() + "");
      cancelTeacherTip.setText("Cancel");
      cancelTeacherTip.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.cancelTeacherTip = cancelTeacherTip;

      return cancelTeacherTip;
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
     * Getter for f_FlowPanel12 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel12() {
      return build_f_FlowPanel12();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel12() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel12 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel12.add(get_shareCollectiontext());
      f_FlowPanel12.add(get_f_FlowPanel13());
      f_FlowPanel12.add(get_f_Label14());
      f_FlowPanel12.setStyleName("" + get_res().css().collectionVisibilityMainDiv() + "");


      return f_FlowPanel12;
    }

    /**
     * Getter for shareCollectiontext called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_shareCollectiontext() {
      return build_shareCollectiontext();
    }
    private com.google.gwt.user.client.ui.Label build_shareCollectiontext() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label shareCollectiontext = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      shareCollectiontext.setStyleName("" + get_res().css().collectionVisibilityMain() + "");


      owner.shareCollectiontext = shareCollectiontext;

      return shareCollectiontext;
    }

    /**
     * Getter for f_FlowPanel13 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel13() {
      return build_f_FlowPanel13();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel13() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel13 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel13.setStyleName("" + get_res().css().collectionVisibleShareLineSeparator() + "");


      return f_FlowPanel13;
    }

    /**
     * Getter for f_Label14 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label14() {
      return build_f_Label14();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label14() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label14 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label14.setStyleName("" + get_res().css().collectionVisibility() + "");


      return f_Label14;
    }

    /**
     * Getter for shareLinkFloPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_shareLinkFloPanel() {
      return build_shareLinkFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_shareLinkFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel shareLinkFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      shareLinkFloPanel.add(get_f_HTMLPanel15());
      shareLinkFloPanel.add(get_socialShareLinksViewContainer());
      shareLinkFloPanel.setStyleName("" + get_res().css().shareLinkContainer() + "");


      owner.shareLinkFloPanel = shareLinkFloPanel;

      return shareLinkFloPanel;
    }

    /**
     * Getter for f_HTMLPanel15 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel15() {
      return build_f_HTMLPanel15();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel15() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel15 = new com.google.gwt.user.client.ui.HTMLPanel(template_html11().asString());
      // Setup section.
      f_HTMLPanel15.setStyleName("" + get_res().css().shareLink() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord356 = UiBinderUtil.attachToDom(f_HTMLPanel15.getElement());
      get_domId12Element().get();
      get_domId13Element().get();

      // Detach section.
      attachRecord356.detach();
      f_HTMLPanel15.addAndReplaceElement(get_shareViaText(), get_domId12Element().get());
      f_HTMLPanel15.addAndReplaceElement(get_contentpanel(), get_domId13Element().get());

      return f_HTMLPanel15;
    }

    /**
     * Getter for domId12 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for shareViaText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_shareViaText() {
      return build_shareViaText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_shareViaText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel shareViaText = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      shareViaText.setStyleName("" + get_res().css().CollectionshareThisLinkVia() + "");


      return shareViaText;
    }

    /**
     * Getter for domId12Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for contentpanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_contentpanel() {
      return build_contentpanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_contentpanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel contentpanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html10().asString());
      // Setup section.


      owner.contentpanel = contentpanel;

      return contentpanel;
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
     * Getter for socialShareLinksViewContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_socialShareLinksViewContainer() {
      return build_socialShareLinksViewContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_socialShareLinksViewContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel socialShareLinksViewContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      owner.socialShareLinksViewContainer = socialShareLinksViewContainer;

      return socialShareLinksViewContainer;
    }
  }
}
