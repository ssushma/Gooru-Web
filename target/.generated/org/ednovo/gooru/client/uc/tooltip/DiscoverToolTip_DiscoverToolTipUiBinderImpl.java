package org.ednovo.gooru.client.uc.tooltip;

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

public class DiscoverToolTip_DiscoverToolTipUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.uc.tooltip.DiscoverToolTip>, org.ednovo.gooru.client.uc.tooltip.DiscoverToolTip.DiscoverToolTipUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html1(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html2(String arg0);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.uc.tooltip.DiscoverToolTip owner) {


    return new Widgets(owner).get_panelCode();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.uc.tooltip.DiscoverToolTip owner;


    public Widgets(final org.ednovo.gooru.client.uc.tooltip.DiscoverToolTip owner) {
      this.owner = owner;
      build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();  // more than one getter call detected. Type: GENERATED_BUNDLE, precedence: 1
      build_toolTip();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1(get_domId1(), get_domId2());
    }
    SafeHtml template_html2() {
      return template.html2(get_domId0());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 2 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.tooltip.DiscoverToolTip_DiscoverToolTipUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    private org.ednovo.gooru.client.uc.tooltip.DiscoverToolTip_DiscoverToolTipUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }
    private org.ednovo.gooru.client.uc.tooltip.DiscoverToolTip_DiscoverToolTipUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.uc.tooltip.DiscoverToolTip_DiscoverToolTipUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.uc.tooltip.DiscoverToolTip_DiscoverToolTipUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for toolTip called 4 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.tooltip.DiscoverToolTip_DiscoverToolTipUiBinderImpl_GenCss_toolTip toolTip;
    private org.ednovo.gooru.client.uc.tooltip.DiscoverToolTip_DiscoverToolTipUiBinderImpl_GenCss_toolTip get_toolTip() {
      return toolTip;
    }
    private org.ednovo.gooru.client.uc.tooltip.DiscoverToolTip_DiscoverToolTipUiBinderImpl_GenCss_toolTip build_toolTip() {
      // Creation section.
      toolTip = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().toolTip();
      // Setup section.
      toolTip.ensureInjected();


      return toolTip;
    }

    /**
     * Getter for style called 0 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.tooltip.DiscoverToolTip_DiscoverToolTipUiBinderImpl_GenCss_style get_style() {
      return build_style();
    }
    private org.ednovo.gooru.client.uc.tooltip.DiscoverToolTip_DiscoverToolTipUiBinderImpl_GenCss_style build_style() {
      // Creation section.
      final org.ednovo.gooru.client.uc.tooltip.DiscoverToolTip_DiscoverToolTipUiBinderImpl_GenCss_style style = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().style();
      // Setup section.
      style.ensureInjected();


      return style;
    }

    /**
     * Getter for panelCode called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelCode() {
      return build_panelCode();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelCode() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelCode = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      panelCode.setStyleName("" + get_toolTip().tooltipContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2005 = UiBinderUtil.attachToDom(panelCode.getElement());
      get_domId0Element().get();

      // Detach section.
      attachRecord2005.detach();
      panelCode.addAndReplaceElement(get_tooltipPanel(), get_domId0Element().get());

      owner.panelCode = panelCode;

      return panelCode;
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
     * Getter for tooltipPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_tooltipPanel() {
      return build_tooltipPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_tooltipPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel tooltipPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      tooltipPanel.setStyleName("" + get_toolTip().discoverTooltipContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2006 = UiBinderUtil.attachToDom(tooltipPanel.getElement());
      get_domId1Element().get();
      get_domId2Element().get();

      // Detach section.
      attachRecord2006.detach();
      tooltipPanel.addAndReplaceElement(get_lblGooruLibrary(), get_domId1Element().get());
      tooltipPanel.addAndReplaceElement(get_lblRusdLibrary(), get_domId2Element().get());

      return tooltipPanel;
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
     * Getter for lblGooruLibrary called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_lblGooruLibrary() {
      return build_lblGooruLibrary();
    }
    private com.google.gwt.user.client.ui.Label build_lblGooruLibrary() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblGooruLibrary = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblGooruLibrary.setStyleName("" + get_toolTip().discoverTooltipLabel() + "");


      owner.lblGooruLibrary = lblGooruLibrary;

      return lblGooruLibrary;
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
     * Getter for lblRusdLibrary called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_lblRusdLibrary() {
      return build_lblRusdLibrary();
    }
    private com.google.gwt.user.client.ui.Label build_lblRusdLibrary() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblRusdLibrary = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblRusdLibrary.setStyleName("" + get_toolTip().discoverTooltipLabel() + "");


      owner.lblRusdLibrary = lblRusdLibrary;

      return lblRusdLibrary;
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
