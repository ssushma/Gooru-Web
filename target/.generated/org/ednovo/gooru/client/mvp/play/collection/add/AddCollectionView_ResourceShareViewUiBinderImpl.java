package org.ednovo.gooru.client.mvp.play.collection.add;

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

public class AddCollectionView_ResourceShareViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.play.collection.add.AddCollectionView>, org.ednovo.gooru.client.mvp.play.collection.add.AddCollectionView.ResourceShareViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html2(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html3(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html4(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html5(String arg0);
     
    @Template("")
    SafeHtml html6();
     
    @Template("<div class='{0}'> <span id='{1}'></span> <div class='{2}'> <span id='{3}'></span> </div> <span id='{4}'></span> <span id='{5}'></span> </div> <span id='{6}'></span>")
    SafeHtml html7(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html8(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html9(String arg0, String arg1, String arg2, String arg3);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.play.collection.add.AddCollectionView owner) {


    return new Widgets(owner).get_addToCollectionWidgetContainer();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.play.collection.add.AddCollectionView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.workspaceLinkClickEvent(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onhideBtnClicked(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.play.collection.add.AddCollectionView owner) {
      this.owner = owner;
      build_addToCollectionStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId14();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId15();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId14Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId15Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2(get_domId2());
    }
    SafeHtml template_html3() {
      return template.html3(get_domId4());
    }
    SafeHtml template_html4() {
      return template.html4(get_domId1(), get_domId3());
    }
    SafeHtml template_html5() {
      return template.html5(get_domId6());
    }
    SafeHtml template_html6() {
      return template.html6();
    }
    SafeHtml template_html7() {
      return template.html7("" + get_addToCollectionStyle().collectionPlayerExistingCollectionContent() + "", get_domId8(), "" + get_addToCollectionStyle().collectionPlayerExistingCollectionInputContainer() + "", get_domId9(), get_domId10(), get_domId11(), get_domId12());
    }
    SafeHtml template_html8() {
      return template.html8(get_domId14(), get_domId15());
    }
    SafeHtml template_html9() {
      return template.html9(get_domId0(), get_domId5(), get_domId7(), get_domId13());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.collection.add.AddCollectionView_ResourceShareViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.play.collection.add.AddCollectionView_ResourceShareViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.play.collection.add.AddCollectionView_ResourceShareViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.play.collection.add.AddCollectionView_ResourceShareViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.play.collection.add.AddCollectionView_ResourceShareViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for addToCollectionStyle called 22 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.collection.add.AddCollectionView_ResourceShareViewUiBinderImpl_GenCss_addToCollectionStyle addToCollectionStyle;
    private org.ednovo.gooru.client.mvp.play.collection.add.AddCollectionView_ResourceShareViewUiBinderImpl_GenCss_addToCollectionStyle get_addToCollectionStyle() {
      return addToCollectionStyle;
    }
    private org.ednovo.gooru.client.mvp.play.collection.add.AddCollectionView_ResourceShareViewUiBinderImpl_GenCss_addToCollectionStyle build_addToCollectionStyle() {
      // Creation section.
      addToCollectionStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().addToCollectionStyle();
      // Setup section.
      addToCollectionStyle.ensureInjected();


      return addToCollectionStyle;
    }

    /**
     * Getter for addToCollectionWidgetContainer called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_addToCollectionWidgetContainer() {
      return build_addToCollectionWidgetContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_addToCollectionWidgetContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel addToCollectionWidgetContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      addToCollectionWidgetContainer.setStyleName("" + get_addToCollectionStyle().collectionPlayerAddResourcesContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1599 = UiBinderUtil.attachToDom(addToCollectionWidgetContainer.getElement());
      get_domId0Element().get();
      get_domId5Element().get();
      get_domId7Element().get();
      get_domId13Element().get();

      // Detach section.
      attachRecord1599.detach();
      addToCollectionWidgetContainer.addAndReplaceElement(get_collectionAddImageContainer(), get_domId0Element().get());
      addToCollectionWidgetContainer.addAndReplaceElement(get_collectionAddedSuccessMessageContainer(), get_domId5Element().get());
      addToCollectionWidgetContainer.addAndReplaceElement(get_f_HTMLPanel3(), get_domId7Element().get());
      addToCollectionWidgetContainer.addAndReplaceElement(get_hideButton(), get_domId13Element().get());

      owner.addToCollectionWidgetContainer = addToCollectionWidgetContainer;

      return addToCollectionWidgetContainer;
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
     * Getter for collectionAddImageContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_collectionAddImageContainer() {
      return build_collectionAddImageContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_collectionAddImageContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel collectionAddImageContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      collectionAddImageContainer.setStyleName("" + get_addToCollectionStyle().collectionPlayerAddResourcesContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1600 = UiBinderUtil.attachToDom(collectionAddImageContainer.getElement());
      get_domId1Element().get();
      get_domId3Element().get();

      // Detach section.
      attachRecord1600.detach();
      collectionAddImageContainer.addAndReplaceElement(get_f_HTMLPanel1(), get_domId1Element().get());
      collectionAddImageContainer.addAndReplaceElement(get_addResourceInsteadLabelContainerInCollectionImage(), get_domId3Element().get());

      owner.collectionAddImageContainer = collectionAddImageContainer;

      return collectionAddImageContainer;
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
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      f_HTMLPanel1.setStyleName("" + get_addToCollectionStyle().collectionPlayerAddResourcesIconContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1601 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId2Element().get();

      // Detach section.
      attachRecord1601.detach();
      f_HTMLPanel1.addAndReplaceElement(get_addcollectionText(), get_domId2Element().get());

      return f_HTMLPanel1;
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
     * Getter for addcollectionText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_addcollectionText() {
      return build_addcollectionText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_addcollectionText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel addcollectionText = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      addcollectionText.setStyleName("" + get_addToCollectionStyle().collectionPlayerAddResourcesText() + "");


      owner.addcollectionText = addcollectionText;

      return addcollectionText;
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
     * Getter for addResourceInsteadLabelContainerInCollectionImage called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_addResourceInsteadLabelContainerInCollectionImage() {
      return build_addResourceInsteadLabelContainerInCollectionImage();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_addResourceInsteadLabelContainerInCollectionImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel addResourceInsteadLabelContainerInCollectionImage = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      addResourceInsteadLabelContainerInCollectionImage.setStyleName("" + get_addToCollectionStyle().addResourceInsteadContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1602 = UiBinderUtil.attachToDom(addResourceInsteadLabelContainerInCollectionImage.getElement());
      get_domId4Element().get();

      // Detach section.
      attachRecord1602.detach();
      addResourceInsteadLabelContainerInCollectionImage.addAndReplaceElement(get_addResourceInsteadLabel(), get_domId4Element().get());

      owner.addResourceInsteadLabelContainerInCollectionImage = addResourceInsteadLabelContainerInCollectionImage;

      return addResourceInsteadLabelContainerInCollectionImage;
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
     * Getter for addResourceInsteadLabel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_addResourceInsteadLabel() {
      return build_addResourceInsteadLabel();
    }
    private com.google.gwt.user.client.ui.Label build_addResourceInsteadLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label addResourceInsteadLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      addResourceInsteadLabel.setStyleName("" + get_addToCollectionStyle().collectionPlayerAddResourcesInstead() + "");


      owner.addResourceInsteadLabel = addResourceInsteadLabel;

      return addResourceInsteadLabel;
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
     * Getter for collectionAddedSuccessMessageContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_collectionAddedSuccessMessageContainer() {
      return build_collectionAddedSuccessMessageContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_collectionAddedSuccessMessageContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel collectionAddedSuccessMessageContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      collectionAddedSuccessMessageContainer.add(get_successMessageLabelText());
      collectionAddedSuccessMessageContainer.add(get_f_HTMLPanel2());
      collectionAddedSuccessMessageContainer.add(get_addCollectionInsteadLabelContainer());
      collectionAddedSuccessMessageContainer.setStyleName("" + get_addToCollectionStyle().successMessageContainer() + "");


      owner.collectionAddedSuccessMessageContainer = collectionAddedSuccessMessageContainer;

      return collectionAddedSuccessMessageContainer;
    }

    /**
     * Getter for successMessageLabelText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_successMessageLabelText() {
      return build_successMessageLabelText();
    }
    private com.google.gwt.user.client.ui.Label build_successMessageLabelText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label successMessageLabelText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      successMessageLabelText.setStyleName("" + get_addToCollectionStyle().successMessageLabelText() + "");


      owner.successMessageLabelText = successMessageLabelText;

      return successMessageLabelText;
    }

    /**
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_addToCollectionStyle().workSpaceLinkContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1603 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_domId6Element().get();

      // Detach section.
      attachRecord1603.detach();
      f_HTMLPanel2.addAndReplaceElement(get_workSpaceLink(), get_domId6Element().get());

      return f_HTMLPanel2;
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
     * Getter for workSpaceLink called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Anchor get_workSpaceLink() {
      return build_workSpaceLink();
    }
    private com.google.gwt.user.client.ui.Anchor build_workSpaceLink() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor workSpaceLink = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      workSpaceLink.setStyleName("" + get_addToCollectionStyle().workSpaceLinkText() + "");
      workSpaceLink.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.workSpaceLink = workSpaceLink;

      return workSpaceLink;
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
     * Getter for addCollectionInsteadLabelContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_addCollectionInsteadLabelContainer() {
      return build_addCollectionInsteadLabelContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_addCollectionInsteadLabelContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel addCollectionInsteadLabelContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.
      addCollectionInsteadLabelContainer.setStyleName("" + get_addToCollectionStyle().addCollectionInsteadLabelContainer() + "");


      owner.addCollectionInsteadLabelContainer = addCollectionInsteadLabelContainer;

      return addCollectionInsteadLabelContainer;
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
     * Getter for f_HTMLPanel3 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel3() {
      return build_f_HTMLPanel3();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.
      f_HTMLPanel3.setStyleName("" + get_addToCollectionStyle().collectionPlayerExistingCollectionContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1604 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
      get_domId8Element().get();
      get_domId9Element().get();
      get_domId10Element().get();
      get_domId11Element().get();
      get_domId12Element().get();

      // Detach section.
      attachRecord1604.detach();
      f_HTMLPanel3.addAndReplaceElement(get_renameText(), get_domId8Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_collectionTitleInCoverPage(), get_domId9Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_addToShelfCollectionButton(), get_domId10Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_addingLabel(), get_domId11Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_addErrorLabel(), get_domId12Element().get());

      return f_HTMLPanel3;
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
     * Getter for renameText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_renameText() {
      return build_renameText();
    }
    private com.google.gwt.user.client.ui.Label build_renameText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label renameText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      renameText.setStyleName("" + get_addToCollectionStyle().collectionPlayerExistingCollectionText() + "");


      owner.renameText = renameText;

      return renameText;
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
     * Getter for collectionTitleInCoverPage called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.TextBox get_collectionTitleInCoverPage() {
      return build_collectionTitleInCoverPage();
    }
    private com.google.gwt.user.client.ui.TextBox build_collectionTitleInCoverPage() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox collectionTitleInCoverPage = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.
      collectionTitleInCoverPage.setStyleName("" + get_addToCollectionStyle().inputTextBoxSyle() + "");


      owner.collectionTitleInCoverPage = collectionTitleInCoverPage;

      return collectionTitleInCoverPage;
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
     * Getter for addToShelfCollectionButton called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_addToShelfCollectionButton() {
      return build_addToShelfCollectionButton();
    }
    private com.google.gwt.user.client.ui.Button build_addToShelfCollectionButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button addToShelfCollectionButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      addToShelfCollectionButton.setStyleName("" + get_addToCollectionStyle().collectionPlayerExistingAddButtonText() + "");


      owner.addToShelfCollectionButton = addToShelfCollectionButton;

      return addToShelfCollectionButton;
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
     * Getter for addingLabel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_addingLabel() {
      return build_addingLabel();
    }
    private com.google.gwt.user.client.ui.Label build_addingLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label addingLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      addingLabel.setStyleName("" + get_addToCollectionStyle().collectionAddingStyles() + "");


      owner.addingLabel = addingLabel;

      return addingLabel;
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
     * Getter for addErrorLabel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_addErrorLabel() {
      return build_addErrorLabel();
    }
    private com.google.gwt.user.client.ui.Label build_addErrorLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label addErrorLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      addErrorLabel.setStyleName("" + get_addToCollectionStyle().collectionErrorStyles() + "");


      owner.addErrorLabel = addErrorLabel;

      return addErrorLabel;
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
     * Getter for hideButton called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_hideButton() {
      return build_hideButton();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_hideButton() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel hideButton = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html8().asString());
      // Setup section.
      hideButton.setStyleName("" + get_addToCollectionStyle().resourceInfoBottomImageContainer() + "");
      hideButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1605 = UiBinderUtil.attachToDom(hideButton.getElement());
      get_domId14Element().get();
      get_domId15Element().get();

      // Detach section.
      attachRecord1605.detach();
      hideButton.addAndReplaceElement(get_f_Label4(), get_domId14Element().get());
      hideButton.addAndReplaceElement(get_hideText(), get_domId15Element().get());

      return hideButton;
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
     * Getter for f_Label4 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label4() {
      return build_f_Label4();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label4() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label4 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label4.setStyleName("" + get_addToCollectionStyle().resourceInfoHideImage() + "");


      return f_Label4;
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
     * Getter for hideText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_hideText() {
      return build_hideText();
    }
    private com.google.gwt.user.client.ui.Label build_hideText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label hideText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      hideText.setStyleName("" + get_addToCollectionStyle().resourceInfoHideText() + "");


      owner.hideText = hideText;

      return hideText;
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
  }
}
