package org.ednovo.gooru.client.uc;

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

public class CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.uc.CollectionAnalyticsUc>, org.ednovo.gooru.client.uc.CollectionAnalyticsUc.CollectionAnalyticsUcUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span>")
    SafeHtml html1(String arg0);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.uc.CollectionAnalyticsUc owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.uc.CollectionAnalyticsUc owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickOnCancelLabel(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.uc.CollectionAnalyticsUc owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
    }

    SafeHtml template_html1() {
      return template.html1(get_domId0());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.uc.CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.uc.CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.uc.CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.uc.CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for style called 6 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenCss_style style;
    private org.ednovo.gooru.client.uc.CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenCss_style get_style() {
      return style;
    }
    private org.ednovo.gooru.client.uc.CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenCss_style build_style() {
      // Creation section.
      style = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().style();
      // Setup section.
      style.ensureInjected();


      return style;
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
      f_FlowPanel1.add(get_headerPanel());
      f_FlowPanel1.add(get_contentPanel());


      return f_FlowPanel1;
    }

    /**
     * Getter for headerPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_headerPanel() {
      return build_headerPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_headerPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel headerPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      headerPanel.add(get_analyticsHeaderLbl());
      headerPanel.add(get_f_HTMLPanel2());
      headerPanel.setStyleName("" + get_style().title() + "");


      return headerPanel;
    }

    /**
     * Getter for analyticsHeaderLbl called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_analyticsHeaderLbl() {
      return build_analyticsHeaderLbl();
    }
    private com.google.gwt.user.client.ui.Label build_analyticsHeaderLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label analyticsHeaderLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.analyticsHeaderLbl = analyticsHeaderLbl;

      return analyticsHeaderLbl;
    }

    /**
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_style().forgetPopupCloseBtnContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord274 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_domId0Element().get();

      // Detach section.
      attachRecord274.detach();
      f_HTMLPanel2.addAndReplaceElement(get_closeButton(), get_domId0Element().get());

      return f_HTMLPanel2;
    }

    /**
     * Getter for domId0 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for closeButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_closeButton() {
      return build_closeButton();
    }
    private com.google.gwt.user.client.ui.Label build_closeButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label closeButton = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      closeButton.setStyleName("" + get_style().forgetPopupBtnSprite() + " " + get_style().forgetPopupCloseBtn() + "");
      closeButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.closeButton = closeButton;

      return closeButton;
    }

    /**
     * Getter for domId0Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for contentPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_contentPanel() {
      return build_contentPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_contentPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel contentPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      contentPanel.add(get_analyticsBodyLbl());
      contentPanel.setStyleName("" + get_style().content() + "");


      return contentPanel;
    }

    /**
     * Getter for analyticsBodyLbl called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_analyticsBodyLbl() {
      return build_analyticsBodyLbl();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_analyticsBodyLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel analyticsBodyLbl = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      analyticsBodyLbl.setStyleName("" + get_style().contentStyle() + "");


      owner.analyticsBodyLbl = analyticsBodyLbl;

      return analyticsBodyLbl;
    }
  }
}
