package org.ednovo.gooru.client.mvp.search.resource;

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

public class ResourceSearchResultVc_ResourceSearchResultVcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.search.resource.ResourceSearchResultVc>, org.ednovo.gooru.client.mvp.search.resource.ResourceSearchResultVc.ResourceSearchResultVcUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html1(String arg0, String arg1);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.search.resource.ResourceSearchResultVc owner) {


    return new Widgets(owner).get_wrapperVcr();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.search.resource.ResourceSearchResultVc owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickResourceTitle(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.search.resource.ResourceSearchResultVc owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
    }

    SafeHtml template_html1() {
      return template.html1(get_domId0(), get_domId1());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.search.resource.ResourceSearchResultVc_ResourceSearchResultVcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.search.resource.ResourceSearchResultVc_ResourceSearchResultVcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.search.resource.ResourceSearchResultVc_ResourceSearchResultVcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.search.resource.ResourceSearchResultVc_ResourceSearchResultVcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.search.resource.ResourceSearchResultVc_ResourceSearchResultVcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 8 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.search.resource.ResourceSearchResultCBundle res;
    private org.ednovo.gooru.client.mvp.search.resource.ResourceSearchResultCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.mvp.search.resource.ResourceSearchResultCBundle build_res() {
      // Creation section.
      res = owner.res;
      assert res != null : "UiField res with 'provided = true' was null";
      // Setup section.


      return res;
    }

    /**
     * Getter for wrapperVcr called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.search.resource.ResourceSearchResultWrapperVc get_wrapperVcr() {
      return build_wrapperVcr();
    }
    private org.ednovo.gooru.client.mvp.search.resource.ResourceSearchResultWrapperVc build_wrapperVcr() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.search.resource.ResourceSearchResultWrapperVc wrapperVcr = owner.wrapperVcr;
      assert wrapperVcr != null : "UiField wrapperVcr with 'provided = true' was null";
      // Setup section.
      wrapperVcr.setContent(get_f_FlowPanel1());


      return wrapperVcr;
    }

    /**
     * Getter for f_FlowPanel1 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel1() {
      return build_f_FlowPanel1();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel1 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel1.add(get_f_FlowPanel2());
      f_FlowPanel1.add(get_resourceDescriptionHtml());
      f_FlowPanel1.setStyleName("" + get_res().css().resourcePanel() + "");


      return f_FlowPanel1;
    }

    /**
     * Getter for f_FlowPanel2 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel2() {
      return build_f_FlowPanel2();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel2 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel2.add(get_resourceImageUc());
      f_FlowPanel2.add(get_resourceTitlePanel());
      f_FlowPanel2.setStyleName("" + get_res().css().resourceHeaderPanel() + "");


      return f_FlowPanel2;
    }

    /**
     * Getter for resourceImageUc called 1 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for resourceTitlePanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_resourceTitlePanel() {
      return build_resourceTitlePanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_resourceTitlePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel resourceTitlePanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      resourceTitlePanel.add(get_resourceTitleContainer());
      resourceTitlePanel.add(get_metaDataFloPanel());
      resourceTitlePanel.add(get_standardsFloPanel());
      resourceTitlePanel.setStyleName("" + get_res().css().resourceHeaderTextPanel() + "");


      return resourceTitlePanel;
    }

    /**
     * Getter for resourceTitleContainer called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_resourceTitleContainer() {
      return build_resourceTitleContainer();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_resourceTitleContainer() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel resourceTitleContainer = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html1().asString());
      // Setup section.
      resourceTitleContainer.setStyleName("resourceSearchTitle");
      resourceTitleContainer.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord860 = UiBinderUtil.attachToDom(resourceTitleContainer.getElement());
      get_domId0Element().get();
      get_domId1Element().get();

      // Detach section.
      attachRecord860.detach();
      resourceTitleContainer.addAndReplaceElement(get_lblResourceTitle(), get_domId0Element().get());
      resourceTitleContainer.addAndReplaceElement(get_imgNotFriendly(), get_domId1Element().get());

      owner.resourceTitleContainer = resourceTitleContainer;

      return resourceTitleContainer;
    }

    /**
     * Getter for domId0 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for lblResourceTitle called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTML get_lblResourceTitle() {
      return build_lblResourceTitle();
    }
    private com.google.gwt.user.client.ui.HTML build_lblResourceTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML lblResourceTitle = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      lblResourceTitle.setStyleName("" + get_res().css().resourceTitle() + "");


      owner.lblResourceTitle = lblResourceTitle;

      return lblResourceTitle;
    }

    /**
     * Getter for domId0Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId1 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for imgNotFriendly called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Image get_imgNotFriendly() {
      return build_imgNotFriendly();
    }
    private com.google.gwt.user.client.ui.Image build_imgNotFriendly() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image imgNotFriendly = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      imgNotFriendly.setStyleName("" + get_res().css().imgHeight() + "");


      owner.imgNotFriendly = imgNotFriendly;

      return imgNotFriendly;
    }

    /**
     * Getter for domId1Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for metaDataFloPanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_metaDataFloPanel() {
      return build_metaDataFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_metaDataFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel metaDataFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      metaDataFloPanel.setStyleName("" + get_res().css().metaDataPanel() + "");


      owner.metaDataFloPanel = metaDataFloPanel;

      return metaDataFloPanel;
    }

    /**
     * Getter for standardsFloPanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_standardsFloPanel() {
      return build_standardsFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_standardsFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel standardsFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      standardsFloPanel.setStyleName("" + get_res().css().standards() + "");


      owner.standardsFloPanel = standardsFloPanel;

      return standardsFloPanel;
    }

    /**
     * Getter for resourceDescriptionHtml called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTML get_resourceDescriptionHtml() {
      return build_resourceDescriptionHtml();
    }
    private com.google.gwt.user.client.ui.HTML build_resourceDescriptionHtml() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML resourceDescriptionHtml = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      resourceDescriptionHtml.setStyleName("" + get_res().css().resourceDescription() + "");


      owner.resourceDescriptionHtml = resourceDescriptionHtml;

      return resourceDescriptionHtml;
    }
  }
}
