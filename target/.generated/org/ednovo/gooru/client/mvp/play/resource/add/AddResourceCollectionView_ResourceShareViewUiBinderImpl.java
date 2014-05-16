package org.ednovo.gooru.client.mvp.play.resource.add;

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

public class AddResourceCollectionView_ResourceShareViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.play.resource.add.AddResourceCollectionView>, org.ednovo.gooru.client.mvp.play.resource.add.AddResourceCollectionView.ResourceShareViewUiBinder {

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
     
    @Template("<span id='{0}'></span>")
    SafeHtml html6(String arg0);
     
    @Template("")
    SafeHtml html7();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html8(String arg0);
     
    @Template("<div class='{0}'> <div class='{1}'> <span id='{2}'></span> <span id='{3}'></span> </div> <span id='{4}'></span> <span id='{5}'></span> <span id='{6}'></span> </div> <span id='{7}'></span> <span id='{8}'></span> <span id='{9}'></span>")
    SafeHtml html9(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html10(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html11(String arg0, String arg1, String arg2, String arg3);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.play.resource.add.AddResourceCollectionView owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.play.resource.add.AddResourceCollectionView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.workSpaceBtnClickEvent(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onhideBtnClicked(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.play.resource.add.AddResourceCollectionView owner) {
      this.owner = owner;
      build_addToResourcesOrCollectionStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId15();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId14();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId16();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId17();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId19();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId20();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId18();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId15Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId14Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId16Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId17Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId19Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId20Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId18Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
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
      return template.html6(get_domId7());
    }
    SafeHtml template_html7() {
      return template.html7();
    }
    SafeHtml template_html8() {
      return template.html8(get_domId15());
    }
    SafeHtml template_html9() {
      return template.html9("" + get_addToResourcesOrCollectionStyle().collectionPlayerExistingCollectionContent() + "", "" + get_addToResourcesOrCollectionStyle().collectionPlayerExistingCollectionInputContainer() + "", get_domId9(), get_domId10(), get_domId11(), get_domId12(), get_domId13(), get_domId14(), get_domId16(), get_domId17());
    }
    SafeHtml template_html10() {
      return template.html10(get_domId19(), get_domId20());
    }
    SafeHtml template_html11() {
      return template.html11(get_domId0(), get_domId5(), get_domId8(), get_domId18());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.resource.add.AddResourceCollectionView_ResourceShareViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.play.resource.add.AddResourceCollectionView_ResourceShareViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.play.resource.add.AddResourceCollectionView_ResourceShareViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.play.resource.add.AddResourceCollectionView_ResourceShareViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.play.resource.add.AddResourceCollectionView_ResourceShareViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for addToResourcesOrCollectionStyle called 27 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.resource.add.AddResourceCollectionView_ResourceShareViewUiBinderImpl_GenCss_addToResourcesOrCollectionStyle addToResourcesOrCollectionStyle;
    private org.ednovo.gooru.client.mvp.play.resource.add.AddResourceCollectionView_ResourceShareViewUiBinderImpl_GenCss_addToResourcesOrCollectionStyle get_addToResourcesOrCollectionStyle() {
      return addToResourcesOrCollectionStyle;
    }
    private org.ednovo.gooru.client.mvp.play.resource.add.AddResourceCollectionView_ResourceShareViewUiBinderImpl_GenCss_addToResourcesOrCollectionStyle build_addToResourcesOrCollectionStyle() {
      // Creation section.
      addToResourcesOrCollectionStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().addToResourcesOrCollectionStyle();
      // Setup section.
      addToResourcesOrCollectionStyle.ensureInjected();


      return addToResourcesOrCollectionStyle;
    }

    /**
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html11().asString());
      // Setup section.
      f_HTMLPanel1.setStyleName("" + get_addToResourcesOrCollectionStyle().collectionPlayerAddResourcesContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1590 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId0Element().get();
      get_domId5Element().get();
      get_domId8Element().get();
      get_domId18Element().get();

      // Detach section.
      attachRecord1590.detach();
      f_HTMLPanel1.addAndReplaceElement(get_resourceImageContainerInAddResource(), get_domId0Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_resourceAddedSuccessMessageContainer(), get_domId5Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_existingCollectionContainer(), get_domId8Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_hideButton(), get_domId18Element().get());

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
     * Getter for resourceImageContainerInAddResource called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_resourceImageContainerInAddResource() {
      return build_resourceImageContainerInAddResource();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_resourceImageContainerInAddResource() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel resourceImageContainerInAddResource = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      resourceImageContainerInAddResource.setStyleName("" + get_addToResourcesOrCollectionStyle().collectionPlayerAddResourcesContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1591 = UiBinderUtil.attachToDom(resourceImageContainerInAddResource.getElement());
      get_domId1Element().get();
      get_domId3Element().get();

      // Detach section.
      attachRecord1591.detach();
      resourceImageContainerInAddResource.addAndReplaceElement(get_f_HTMLPanel2(), get_domId1Element().get());
      resourceImageContainerInAddResource.addAndReplaceElement(get_addCollectionContainer(), get_domId3Element().get());

      owner.resourceImageContainerInAddResource = resourceImageContainerInAddResource;

      return resourceImageContainerInAddResource;
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
      f_HTMLPanel2.setStyleName("" + get_addToResourcesOrCollectionStyle().collectionPlayerAddResourcesIconContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1592 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_domId2Element().get();

      // Detach section.
      attachRecord1592.detach();
      f_HTMLPanel2.addAndReplaceElement(get_addresourceText(), get_domId2Element().get());

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
     * Getter for addresourceText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_addresourceText() {
      return build_addresourceText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_addresourceText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel addresourceText = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      addresourceText.setStyleName("" + get_addToResourcesOrCollectionStyle().collectionPlayerAddResourcesText() + "");


      owner.addresourceText = addresourceText;

      return addresourceText;
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
     * Getter for addCollectionContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_addCollectionContainer() {
      return build_addCollectionContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_addCollectionContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel addCollectionContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      addCollectionContainer.setStyleName("" + get_addToResourcesOrCollectionStyle().addCollectionContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1593 = UiBinderUtil.attachToDom(addCollectionContainer.getElement());
      get_domId4Element().get();

      // Detach section.
      attachRecord1593.detach();
      addCollectionContainer.addAndReplaceElement(get_addToExistingColl(), get_domId4Element().get());

      owner.addCollectionContainer = addCollectionContainer;

      return addCollectionContainer;
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
     * Getter for addToExistingColl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_addToExistingColl() {
      return build_addToExistingColl();
    }
    private com.google.gwt.user.client.ui.Label build_addToExistingColl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label addToExistingColl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      addToExistingColl.setStyleName("" + get_addToResourcesOrCollectionStyle().collectionPlayerAddResourcesCollectionInstead() + "");


      owner.addToExistingColl = addToExistingColl;

      return addToExistingColl;
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
     * Getter for resourceAddedSuccessMessageContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_resourceAddedSuccessMessageContainer() {
      return build_resourceAddedSuccessMessageContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_resourceAddedSuccessMessageContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel resourceAddedSuccessMessageContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      resourceAddedSuccessMessageContainer.add(get_successMessageLabelText());
      resourceAddedSuccessMessageContainer.add(get_f_HTMLPanel3());
      resourceAddedSuccessMessageContainer.add(get_addCollectionInsteadLabelContainer());
      resourceAddedSuccessMessageContainer.setStyleName("" + get_addToResourcesOrCollectionStyle().successMessageContainer() + "");


      owner.resourceAddedSuccessMessageContainer = resourceAddedSuccessMessageContainer;

      return resourceAddedSuccessMessageContainer;
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
      successMessageLabelText.setStyleName("" + get_addToResourcesOrCollectionStyle().successMessageLabelText() + "");


      owner.successMessageLabelText = successMessageLabelText;

      return successMessageLabelText;
    }

    /**
     * Getter for f_HTMLPanel3 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel3() {
      return build_f_HTMLPanel3();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.
      f_HTMLPanel3.setStyleName("" + get_addToResourcesOrCollectionStyle().workSpaceLinkContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1594 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
      get_domId6Element().get();

      // Detach section.
      attachRecord1594.detach();
      f_HTMLPanel3.addAndReplaceElement(get_workSpaceBtn(), get_domId6Element().get());

      return f_HTMLPanel3;
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
     * Getter for workSpaceBtn called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Button get_workSpaceBtn() {
      return build_workSpaceBtn();
    }
    private com.google.gwt.user.client.ui.Button build_workSpaceBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button workSpaceBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      workSpaceBtn.setStyleName("secondary");
      workSpaceBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.workSpaceBtn = workSpaceBtn;

      return workSpaceBtn;
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
      addCollectionInsteadLabelContainer.setStyleName("" + get_addToResourcesOrCollectionStyle().addCollectionInsteadLabelContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1595 = UiBinderUtil.attachToDom(addCollectionInsteadLabelContainer.getElement());
      get_domId7Element().get();

      // Detach section.
      attachRecord1595.detach();
      addCollectionInsteadLabelContainer.addAndReplaceElement(get_addCollectionInsteadLabelText(), get_domId7Element().get());

      owner.addCollectionInsteadLabelContainer = addCollectionInsteadLabelContainer;

      return addCollectionInsteadLabelContainer;
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
     * Getter for addCollectionInsteadLabelText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_addCollectionInsteadLabelText() {
      return build_addCollectionInsteadLabelText();
    }
    private com.google.gwt.user.client.ui.Label build_addCollectionInsteadLabelText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label addCollectionInsteadLabelText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      addCollectionInsteadLabelText.setStyleName("" + get_addToResourcesOrCollectionStyle().addCollectionInsteadLabelText() + "");


      owner.addCollectionInsteadLabelText = addCollectionInsteadLabelText;

      return addCollectionInsteadLabelText;
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
     * Getter for existingCollectionContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_existingCollectionContainer() {
      return build_existingCollectionContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_existingCollectionContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel existingCollectionContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      existingCollectionContainer.setStyleName("" + get_addToResourcesOrCollectionStyle().collectionPlayerExistingCollectionContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1596 = UiBinderUtil.attachToDom(existingCollectionContainer.getElement());
      get_domId9Element().get();
      get_domId10Element().get();
      get_domId11Element().get();
      get_domId12Element().get();
      get_domId13Element().get();
      get_domId14Element().get();
      get_domId16Element().get();
      get_domId17Element().get();

      // Detach section.
      attachRecord1596.detach();
      existingCollectionContainer.addAndReplaceElement(get_dropdownListPlaceHolder(), get_domId9Element().get());
      existingCollectionContainer.addAndReplaceElement(get_dropdownListContainerScrollPanel(), get_domId10Element().get());
      existingCollectionContainer.addAndReplaceElement(get_addResourceToCollectionButton(), get_domId11Element().get());
      existingCollectionContainer.addAndReplaceElement(get_addingLabel(), get_domId12Element().get());
      existingCollectionContainer.addAndReplaceElement(get_resourceAdditionErrorStyle(), get_domId13Element().get());
      existingCollectionContainer.addAndReplaceElement(get_createCollectionLabelContainer(), get_domId14Element().get());
      existingCollectionContainer.addAndReplaceElement(get_errorMessage(), get_domId16Element().get());
      existingCollectionContainer.addAndReplaceElement(get_sizeMessage(), get_domId17Element().get());

      owner.existingCollectionContainer = existingCollectionContainer;

      return existingCollectionContainer;
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
     * Getter for dropdownListPlaceHolder called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.InlineLabel get_dropdownListPlaceHolder() {
      return build_dropdownListPlaceHolder();
    }
    private com.google.gwt.user.client.ui.InlineLabel build_dropdownListPlaceHolder() {
      // Creation section.
      final com.google.gwt.user.client.ui.InlineLabel dropdownListPlaceHolder = (com.google.gwt.user.client.ui.InlineLabel) GWT.create(com.google.gwt.user.client.ui.InlineLabel.class);
      // Setup section.
      dropdownListPlaceHolder.setStyleName("" + get_addToResourcesOrCollectionStyle().dropdownListPlaceHolder() + "");


      owner.dropdownListPlaceHolder = dropdownListPlaceHolder;

      return dropdownListPlaceHolder;
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
     * Getter for dropdownListContainerScrollPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.ScrollPanel get_dropdownListContainerScrollPanel() {
      return build_dropdownListContainerScrollPanel();
    }
    private com.google.gwt.user.client.ui.ScrollPanel build_dropdownListContainerScrollPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.ScrollPanel dropdownListContainerScrollPanel = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
      // Setup section.
      dropdownListContainerScrollPanel.add(get_dropdownListContainer());
      dropdownListContainerScrollPanel.setStyleName("" + get_addToResourcesOrCollectionStyle().dropdownListContainerScrollPanel() + "");


      owner.dropdownListContainerScrollPanel = dropdownListContainerScrollPanel;

      return dropdownListContainerScrollPanel;
    }

    /**
     * Getter for dropdownListContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_dropdownListContainer() {
      return build_dropdownListContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_dropdownListContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel dropdownListContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.
      dropdownListContainer.setStyleName("" + get_addToResourcesOrCollectionStyle().dropdownListContainer() + "");


      owner.dropdownListContainer = dropdownListContainer;

      return dropdownListContainer;
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
     * Getter for addResourceToCollectionButton called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_addResourceToCollectionButton() {
      return build_addResourceToCollectionButton();
    }
    private com.google.gwt.user.client.ui.Button build_addResourceToCollectionButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button addResourceToCollectionButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      addResourceToCollectionButton.setStyleName("" + get_addToResourcesOrCollectionStyle().collectionPlayerExistingAddButtonText() + "");


      owner.addResourceToCollectionButton = addResourceToCollectionButton;

      return addResourceToCollectionButton;
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
     * Getter for addingLabel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_addingLabel() {
      return build_addingLabel();
    }
    private com.google.gwt.user.client.ui.Label build_addingLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label addingLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      addingLabel.setStyleName("" + get_addToResourcesOrCollectionStyle().addingLabelText() + "");


      owner.addingLabel = addingLabel;

      return addingLabel;
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
     * Getter for domId13 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for resourceAdditionErrorStyle called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_resourceAdditionErrorStyle() {
      return build_resourceAdditionErrorStyle();
    }
    private com.google.gwt.user.client.ui.Label build_resourceAdditionErrorStyle() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label resourceAdditionErrorStyle = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      resourceAdditionErrorStyle.setStyleName("" + get_addToResourcesOrCollectionStyle().resourceAdditionErrorStyle() + "");


      owner.resourceAdditionErrorStyle = resourceAdditionErrorStyle;

      return resourceAdditionErrorStyle;
    }

    /**
     * Getter for domId13Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for createCollectionLabelContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_createCollectionLabelContainer() {
      return build_createCollectionLabelContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_createCollectionLabelContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel createCollectionLabelContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html8().asString());
      // Setup section.
      createCollectionLabelContainer.setStyleName("" + get_addToResourcesOrCollectionStyle().collectionPlayerNewColletionText() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1597 = UiBinderUtil.attachToDom(createCollectionLabelContainer.getElement());
      get_domId15Element().get();

      // Detach section.
      attachRecord1597.detach();
      createCollectionLabelContainer.addAndReplaceElement(get_addNewCollectionLabel(), get_domId15Element().get());

      owner.createCollectionLabelContainer = createCollectionLabelContainer;

      return createCollectionLabelContainer;
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
     * Getter for addNewCollectionLabel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_addNewCollectionLabel() {
      return build_addNewCollectionLabel();
    }
    private com.google.gwt.user.client.ui.Label build_addNewCollectionLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label addNewCollectionLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      addNewCollectionLabel.setStyleName("" + get_addToResourcesOrCollectionStyle().addNewLabel() + "");


      owner.addNewCollectionLabel = addNewCollectionLabel;

      return addNewCollectionLabel;
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
     * Getter for domId16 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for errorMessage called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_errorMessage() {
      return build_errorMessage();
    }
    private com.google.gwt.user.client.ui.Label build_errorMessage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label errorMessage = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      errorMessage.setStyleName("" + get_addToResourcesOrCollectionStyle().errorLabelText() + "");


      owner.errorMessage = errorMessage;

      return errorMessage;
    }

    /**
     * Getter for domId16Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId17 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for sizeMessage called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_sizeMessage() {
      return build_sizeMessage();
    }
    private com.google.gwt.user.client.ui.Label build_sizeMessage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label sizeMessage = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      sizeMessage.setStyleName("" + get_addToResourcesOrCollectionStyle().errorLabelText() + "");


      owner.sizeMessage = sizeMessage;

      return sizeMessage;
    }

    /**
     * Getter for domId17Element called 2 times. Type: DEFAULT. Build precedence: 3.
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

    /**
     * Getter for domId18 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for hideButton called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_hideButton() {
      return build_hideButton();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_hideButton() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel hideButton = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html10().asString());
      // Setup section.
      hideButton.setStyleName("" + get_addToResourcesOrCollectionStyle().resourceInfoBottomImageContainer() + "");
      hideButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1598 = UiBinderUtil.attachToDom(hideButton.getElement());
      get_domId19Element().get();
      get_domId20Element().get();

      // Detach section.
      attachRecord1598.detach();
      hideButton.addAndReplaceElement(get_f_Label4(), get_domId19Element().get());
      hideButton.addAndReplaceElement(get_hideText(), get_domId20Element().get());

      owner.hideButton = hideButton;

      return hideButton;
    }

    /**
     * Getter for domId19 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for f_Label4 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label4() {
      return build_f_Label4();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label4() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label4 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label4.setStyleName("" + get_addToResourcesOrCollectionStyle().resourceInfoHideImage() + "");


      return f_Label4;
    }

    /**
     * Getter for domId19Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId20 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for hideText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_hideText() {
      return build_hideText();
    }
    private com.google.gwt.user.client.ui.Label build_hideText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label hideText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      hideText.setStyleName("" + get_addToResourcesOrCollectionStyle().resourceInfoHideText() + "");


      owner.hideText = hideText;

      return hideText;
    }

    /**
     * Getter for domId20Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId18Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
  }
}
