package org.ednovo.gooru.client.mvp.search;

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

public class SimpleResourceVc_SimpleResourceVcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.search.SimpleResourceVc>, org.ednovo.gooru.client.mvp.search.SimpleResourceVc.SimpleResourceVcUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span>")
    SafeHtml html1(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html2(String arg0);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.search.SimpleResourceVc owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.search.SimpleResourceVc owner;


    public Widgets(final org.ednovo.gooru.client.mvp.search.SimpleResourceVc owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1(get_domId1());
    }
    SafeHtml template_html2() {
      return template.html2(get_domId0());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.search.SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.search.SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.search.SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.search.SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.search.SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for style called 7 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.search.SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style style;
    private org.ednovo.gooru.client.mvp.search.SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style get_style() {
      return style;
    }
    private org.ednovo.gooru.client.mvp.search.SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style build_style() {
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
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord306 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId0Element().get();

      // Detach section.
      attachRecord306.detach();
      f_HTMLPanel1.addAndReplaceElement(get_internalPanel1(), get_domId0Element().get());

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
     * Getter for internalPanel1 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_internalPanel1() {
      return build_internalPanel1();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_internalPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel internalPanel1 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      internalPanel1.add(get_resourceImageUc());
      internalPanel1.add(get_positionLbl());
      internalPanel1.add(get_resourceTitlePanel());
      internalPanel1.setStyleName("" + get_style().resourceThumbnailPanel() + "");


      return internalPanel1;
    }

    /**
     * Getter for resourceImageUc called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.uc.ResourceImageUc get_resourceImageUc() {
      return build_resourceImageUc();
    }
    private org.ednovo.gooru.client.uc.ResourceImageUc build_resourceImageUc() {
      // Creation section.
      final org.ednovo.gooru.client.uc.ResourceImageUc resourceImageUc = (org.ednovo.gooru.client.uc.ResourceImageUc) GWT.create(org.ednovo.gooru.client.uc.ResourceImageUc.class);
      // Setup section.


      owner.resourceImageUc = resourceImageUc;

      return resourceImageUc;
    }

    /**
     * Getter for positionLbl called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_positionLbl() {
      return build_positionLbl();
    }
    private com.google.gwt.user.client.ui.Label build_positionLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label positionLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      positionLbl.setStyleName("" + get_style().resourceOrder() + "");


      owner.positionLbl = positionLbl;

      return positionLbl;
    }

    /**
     * Getter for resourceTitlePanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_resourceTitlePanel() {
      return build_resourceTitlePanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_resourceTitlePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel resourceTitlePanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      resourceTitlePanel.add(get_resourceTitleContainer());
      resourceTitlePanel.add(get_imgNotFriendly());
      resourceTitlePanel.add(get_metaDataFloPanel());
      resourceTitlePanel.setStyleName("" + get_style().resourceTitlePanel() + "");


      return resourceTitlePanel;
    }

    /**
     * Getter for resourceTitleContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_resourceTitleContainer() {
      return build_resourceTitleContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_resourceTitleContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel resourceTitleContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      resourceTitleContainer.setStyleName("" + get_style().resourceTitle() + " collectionSearchResource");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord307 = UiBinderUtil.attachToDom(resourceTitleContainer.getElement());
      get_domId1Element().get();

      // Detach section.
      attachRecord307.detach();
      resourceTitleContainer.addAndReplaceElement(get_resourceTitleLbl(), get_domId1Element().get());

      owner.resourceTitleContainer = resourceTitleContainer;

      return resourceTitleContainer;
    }

    /**
     * Getter for domId1 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for resourceTitleLbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTML get_resourceTitleLbl() {
      return build_resourceTitleLbl();
    }
    private com.google.gwt.user.client.ui.HTML build_resourceTitleLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML resourceTitleLbl = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      resourceTitleLbl.setStyleName("" + get_style().resourceTitle() + " collectionSearchResource");


      owner.resourceTitleLbl = resourceTitleLbl;

      return resourceTitleLbl;
    }

    /**
     * Getter for domId1Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for imgNotFriendly called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Image get_imgNotFriendly() {
      return build_imgNotFriendly();
    }
    private com.google.gwt.user.client.ui.Image build_imgNotFriendly() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image imgNotFriendly = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      imgNotFriendly.setStyleName("" + get_style().imgHeight() + "");


      owner.imgNotFriendly = imgNotFriendly;

      return imgNotFriendly;
    }

    /**
     * Getter for metaDataFloPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_metaDataFloPanel() {
      return build_metaDataFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_metaDataFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel metaDataFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      metaDataFloPanel.setStyleName("" + get_style().metaDataPanel() + "");


      owner.metaDataFloPanel = metaDataFloPanel;

      return metaDataFloPanel;
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
