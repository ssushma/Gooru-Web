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

public class StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.uc.StandardPreferenceTooltip>, org.ednovo.gooru.client.uc.StandardPreferenceTooltip.StandardPreferenceTooltipUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html2(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html3(String arg0);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.uc.StandardPreferenceTooltip owner) {


    return new Widgets(owner).get_panelCode();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.uc.StandardPreferenceTooltip owner;


    public Widgets(final org.ednovo.gooru.client.uc.StandardPreferenceTooltip owner) {
      this.owner = owner;
      build_toolTip();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2(get_domId1());
    }
    SafeHtml template_html3() {
      return template.html3(get_domId0());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.uc.StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.uc.StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.uc.StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.uc.StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for toolTip called 3 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip toolTip;
    private org.ednovo.gooru.client.uc.StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip get_toolTip() {
      return toolTip;
    }
    private org.ednovo.gooru.client.uc.StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip build_toolTip() {
      // Creation section.
      toolTip = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().toolTip();
      // Setup section.
      toolTip.ensureInjected();


      return toolTip;
    }

    /**
     * Getter for panelCode called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelCode() {
      return build_panelCode();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelCode() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelCode = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      panelCode.setStyleName("" + get_toolTip().tooltipContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord857 = UiBinderUtil.attachToDom(panelCode.getElement());
      get_domId0Element().get();

      // Detach section.
      attachRecord857.detach();
      panelCode.addAndReplaceElement(get_f_HTMLPanel1(), get_domId0Element().get());

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
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      f_HTMLPanel1.setStyleName("" + get_toolTip().tooltipContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord858 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId1Element().get();

      // Detach section.
      attachRecord858.detach();
      f_HTMLPanel1.addAndReplaceElement(get_lblTitle(), get_domId1Element().get());

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
     * Getter for lblTitle called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_lblTitle() {
      return build_lblTitle();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_lblTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel lblTitle = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      lblTitle.setStyleName("" + get_toolTip().tooltipContentTitle() + "");


      owner.lblTitle = lblTitle;

      return lblTitle;
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
