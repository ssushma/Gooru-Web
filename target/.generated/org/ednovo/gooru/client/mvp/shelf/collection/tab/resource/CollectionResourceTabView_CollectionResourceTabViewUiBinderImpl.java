package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource;

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

public class CollectionResourceTabView_CollectionResourceTabViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabView>, org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabView.CollectionResourceTabViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html1(String arg0, String arg1, String arg2, String arg3);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html2(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span>")
    SafeHtml html3(String arg0, String arg1, String arg2, String arg3, String arg4);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html4(String arg0, String arg1, String arg2);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabView owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabView owner;


    public Widgets(final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabView owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_res1();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
    }

    SafeHtml template_html1() {
      return template.html1(get_domId0(), get_domId1(), get_domId2(), get_domId3());
    }
    SafeHtml template_html2() {
      return template.html2(get_domId4());
    }
    SafeHtml template_html3() {
      return template.html3(get_domId8(), get_domId9(), get_domId10(), get_domId11(), get_domId12());
    }
    SafeHtml template_html4() {
      return template.html4(get_domId5(), get_domId6(), get_domId7());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabView_CollectionResourceTabViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabView_CollectionResourceTabViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabView_CollectionResourceTabViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabView_CollectionResourceTabViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabView_CollectionResourceTabViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 18 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.CollectionEditResourceCBundle res;
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.CollectionEditResourceCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.CollectionEditResourceCBundle build_res() {
      // Creation section.
      res = (org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.CollectionEditResourceCBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.CollectionEditResourceCBundle.class);
      // Setup section.


      return res;
    }

    /**
     * Getter for res1 called 2 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.ShelfCBundle res1;
    private org.ednovo.gooru.client.mvp.shelf.ShelfCBundle get_res1() {
      return res1;
    }
    private org.ednovo.gooru.client.mvp.shelf.ShelfCBundle build_res1() {
      // Creation section.
      res1 = (org.ednovo.gooru.client.mvp.shelf.ShelfCBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.ShelfCBundle.class);
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
      f_FlowPanel1.add(get_f_HTMLPanel2());
      f_FlowPanel1.add(get_dragAndDropLabel());
      f_FlowPanel1.add(get_panelLoading());
      f_FlowPanel1.add(get_contentPanel());


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
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_res().css().contentCollectionEdit() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2014 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_domId0Element().get();
      get_domId1Element().get();
      get_domId2Element().get();
      get_domId3Element().get();

      // Detach section.
      attachRecord2014.detach();
      f_HTMLPanel2.addAndReplaceElement(get_buttonContainer(), get_domId0Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_buttonContainerAddGray(), get_domId1Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_buttonContainerForQuestion(), get_domId2Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_buttonContainerForQuestionGreay(), get_domId3Element().get());

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
     * Getter for buttonContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_buttonContainer() {
      return build_buttonContainer();
    }
    private com.google.gwt.user.client.ui.Button build_buttonContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button buttonContainer = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      buttonContainer.setStyleName("plusButton " + get_res().css().addResource() + "");


      owner.buttonContainer = buttonContainer;

      return buttonContainer;
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
     * Getter for buttonContainerAddGray called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_buttonContainerAddGray() {
      return build_buttonContainerAddGray();
    }
    private com.google.gwt.user.client.ui.Button build_buttonContainerAddGray() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button buttonContainerAddGray = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      buttonContainerAddGray.setStyleName("plusButton disabled " + get_res().css().addResourceDisable() + "");


      owner.buttonContainerAddGray = buttonContainerAddGray;

      return buttonContainerAddGray;
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
     * Getter for buttonContainerForQuestion called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_buttonContainerForQuestion() {
      return build_buttonContainerForQuestion();
    }
    private com.google.gwt.user.client.ui.Button build_buttonContainerForQuestion() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button buttonContainerForQuestion = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      buttonContainerForQuestion.setStyleName("plusButton " + get_res().css().addResource() + "");


      owner.buttonContainerForQuestion = buttonContainerForQuestion;

      return buttonContainerForQuestion;
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
     * Getter for buttonContainerForQuestionGreay called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_buttonContainerForQuestionGreay() {
      return build_buttonContainerForQuestionGreay();
    }
    private com.google.gwt.user.client.ui.Button build_buttonContainerForQuestionGreay() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button buttonContainerForQuestionGreay = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      buttonContainerForQuestionGreay.setStyleName("plusButton disabled {res.css.addResourceDisable");


      owner.buttonContainerForQuestionGreay = buttonContainerForQuestionGreay;

      return buttonContainerForQuestionGreay;
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
     * Getter for dragAndDropLabel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_dragAndDropLabel() {
      return build_dragAndDropLabel();
    }
    private com.google.gwt.user.client.ui.Label build_dragAndDropLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label dragAndDropLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      dragAndDropLabel.setStyleName("" + get_res().css().reorderLabel() + "");


      owner.dragAndDropLabel = dragAndDropLabel;

      return dragAndDropLabel;
    }

    /**
     * Getter for panelLoading called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelLoading() {
      return build_panelLoading();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelLoading() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelLoading = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      panelLoading.setStyleName("" + get_res1().css().loadingImageMainDivShare() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2015 = UiBinderUtil.attachToDom(panelLoading.getElement());
      get_domId4Element().get();

      // Detach section.
      attachRecord2015.detach();
      panelLoading.addAndReplaceElement(get_f_Label3(), get_domId4Element().get());

      owner.panelLoading = panelLoading;

      return panelLoading;
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
     * Getter for f_Label3 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label3() {
      return build_f_Label3();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label3() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label3 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label3.setStyleName("" + get_res1().css().loadingImageForShare() + "");


      return f_Label3;
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
     * Getter for contentPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_contentPanel() {
      return build_contentPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_contentPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel contentPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2016 = UiBinderUtil.attachToDom(contentPanel.getElement());
      get_domId5Element().get();
      get_domId6Element().get();
      get_domId7Element().get();

      // Detach section.
      attachRecord2016.detach();
      contentPanel.addAndReplaceElement(get_f_HorizontalPanel4(), get_domId5Element().get());
      contentPanel.addAndReplaceElement(get_noResourceLineOneLabel(), get_domId6Element().get());
      contentPanel.addAndReplaceElement(get_panelNoResourceContainer(), get_domId7Element().get());

      owner.contentPanel = contentPanel;

      return contentPanel;
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
     * Getter for f_HorizontalPanel4 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HorizontalPanel get_f_HorizontalPanel4() {
      return build_f_HorizontalPanel4();
    }
    private com.google.gwt.user.client.ui.HorizontalPanel build_f_HorizontalPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel4 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
      // Setup section.
      f_HorizontalPanel4.add(get_sequenceVerPanel());
      f_HorizontalPanel4.add(get_collectionResourcePanelVc());
      f_HorizontalPanel4.setStyleName("" + get_res().css().reorderLabelContainer() + "");


      return f_HorizontalPanel4;
    }

    /**
     * Getter for sequenceVerPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.VerticalPanel get_sequenceVerPanel() {
      return build_sequenceVerPanel();
    }
    private com.google.gwt.user.client.ui.VerticalPanel build_sequenceVerPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.VerticalPanel sequenceVerPanel = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
      // Setup section.
      sequenceVerPanel.setStyleName("" + get_res().css().shelfResourceSequencePanel() + "");


      owner.sequenceVerPanel = sequenceVerPanel;

      return sequenceVerPanel;
    }

    /**
     * Getter for collectionResourcePanelVc called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourcePanelVc get_collectionResourcePanelVc() {
      return build_collectionResourcePanelVc();
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourcePanelVc build_collectionResourcePanelVc() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourcePanelVc collectionResourcePanelVc = (org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourcePanelVc) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourcePanelVc.class);
      // Setup section.


      owner.collectionResourcePanelVc = collectionResourcePanelVc;

      return collectionResourcePanelVc;
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
     * Getter for noResourceLineOneLabel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_noResourceLineOneLabel() {
      return build_noResourceLineOneLabel();
    }
    private com.google.gwt.user.client.ui.Label build_noResourceLineOneLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label noResourceLineOneLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      noResourceLineOneLabel.setStyleName("" + get_res().css().noResourceLabel() + "");


      owner.noResourceLineOneLabel = noResourceLineOneLabel;

      return noResourceLineOneLabel;
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
     * Getter for panelNoResourceContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelNoResourceContainer() {
      return build_panelNoResourceContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelNoResourceContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelNoResourceContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      panelNoResourceContainer.setStyleName("" + get_res().css().noResourceContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2017 = UiBinderUtil.attachToDom(panelNoResourceContainer.getElement());
      get_domId8Element().get();
      get_domId9Element().get();
      get_domId10Element().get();
      get_domId11Element().get();
      get_domId12Element().get();

      // Detach section.
      attachRecord2017.detach();
      panelNoResourceContainer.addAndReplaceElement(get_noResourceLineTwoLabel(), get_domId8Element().get());
      panelNoResourceContainer.addAndReplaceElement(get_noResourceLineThreeLabel(), get_domId9Element().get());
      panelNoResourceContainer.addAndReplaceElement(get_noResourceLineSixLabel(), get_domId10Element().get());
      panelNoResourceContainer.addAndReplaceElement(get_noResourceLineFiveLabel(), get_domId11Element().get());
      panelNoResourceContainer.addAndReplaceElement(get_noResourceLineFourLabel(), get_domId12Element().get());

      owner.panelNoResourceContainer = panelNoResourceContainer;

      return panelNoResourceContainer;
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
     * Getter for noResourceLineTwoLabel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.InlineLabel get_noResourceLineTwoLabel() {
      return build_noResourceLineTwoLabel();
    }
    private com.google.gwt.user.client.ui.InlineLabel build_noResourceLineTwoLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.InlineLabel noResourceLineTwoLabel = (com.google.gwt.user.client.ui.InlineLabel) GWT.create(com.google.gwt.user.client.ui.InlineLabel.class);
      // Setup section.
      noResourceLineTwoLabel.setStyleName("" + get_res().css().noResourceLabel() + "");


      owner.noResourceLineTwoLabel = noResourceLineTwoLabel;

      return noResourceLineTwoLabel;
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
     * Getter for noResourceLineThreeLabel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.InlineLabel get_noResourceLineThreeLabel() {
      return build_noResourceLineThreeLabel();
    }
    private com.google.gwt.user.client.ui.InlineLabel build_noResourceLineThreeLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.InlineLabel noResourceLineThreeLabel = (com.google.gwt.user.client.ui.InlineLabel) GWT.create(com.google.gwt.user.client.ui.InlineLabel.class);
      // Setup section.
      noResourceLineThreeLabel.setStyleName("" + get_res().css().newResourceMessageLabel() + " " + get_res().css().newResourceLabelColor() + " " + get_res().css().newResourceLabelNoHover() + "");


      owner.noResourceLineThreeLabel = noResourceLineThreeLabel;

      return noResourceLineThreeLabel;
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
     * Getter for noResourceLineSixLabel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.InlineLabel get_noResourceLineSixLabel() {
      return build_noResourceLineSixLabel();
    }
    private com.google.gwt.user.client.ui.InlineLabel build_noResourceLineSixLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.InlineLabel noResourceLineSixLabel = (com.google.gwt.user.client.ui.InlineLabel) GWT.create(com.google.gwt.user.client.ui.InlineLabel.class);
      // Setup section.
      noResourceLineSixLabel.setStyleName("" + get_res().css().noResourceLabel() + "");


      owner.noResourceLineSixLabel = noResourceLineSixLabel;

      return noResourceLineSixLabel;
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
     * Getter for noResourceLineFiveLabel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.InlineLabel get_noResourceLineFiveLabel() {
      return build_noResourceLineFiveLabel();
    }
    private com.google.gwt.user.client.ui.InlineLabel build_noResourceLineFiveLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.InlineLabel noResourceLineFiveLabel = (com.google.gwt.user.client.ui.InlineLabel) GWT.create(com.google.gwt.user.client.ui.InlineLabel.class);
      // Setup section.
      noResourceLineFiveLabel.setStyleName("" + get_res().css().newResourceMessageLabel() + " " + get_res().css().newResourceLabelColor() + " " + get_res().css().newResourceLabelNoHover() + "");


      owner.noResourceLineFiveLabel = noResourceLineFiveLabel;

      return noResourceLineFiveLabel;
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
     * Getter for noResourceLineFourLabel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.InlineLabel get_noResourceLineFourLabel() {
      return build_noResourceLineFourLabel();
    }
    private com.google.gwt.user.client.ui.InlineLabel build_noResourceLineFourLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.InlineLabel noResourceLineFourLabel = (com.google.gwt.user.client.ui.InlineLabel) GWT.create(com.google.gwt.user.client.ui.InlineLabel.class);
      // Setup section.
      noResourceLineFourLabel.setStyleName("" + get_res().css().noResourceLabel() + "");


      owner.noResourceLineFourLabel = noResourceLineFourLabel;

      return noResourceLineFourLabel;
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
  }
}
