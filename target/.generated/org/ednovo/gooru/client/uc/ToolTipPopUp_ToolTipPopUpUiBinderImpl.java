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

public class ToolTipPopUp_ToolTipPopUpUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.uc.ToolTipPopUp>, org.ednovo.gooru.client.uc.ToolTipPopUp.ToolTipPopUpUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("")
    SafeHtml html2();
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.uc.ToolTipPopUp owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.uc.ToolTipPopUp owner;


    public Widgets(final org.ednovo.gooru.client.uc.ToolTipPopUp owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2();
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.ToolTipPopUp_ToolTipPopUpUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.uc.ToolTipPopUp_ToolTipPopUpUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.uc.ToolTipPopUp_ToolTipPopUpUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.uc.ToolTipPopUp_ToolTipPopUpUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.uc.ToolTipPopUp_ToolTipPopUpUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for style called 3 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.ToolTipPopUp_ToolTipPopUpUiBinderImpl_GenCss_style style;
    private org.ednovo.gooru.client.uc.ToolTipPopUp_ToolTipPopUpUiBinderImpl_GenCss_style get_style() {
      return style;
    }
    private org.ednovo.gooru.client.uc.ToolTipPopUp_ToolTipPopUpUiBinderImpl_GenCss_style build_style() {
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
      f_FlowPanel1.add(get_popupArrow());
      f_FlowPanel1.add(get_contentPanel());
      f_FlowPanel1.add(get_downPopupArrow());
      f_FlowPanel1.setStyleName("" + get_style().organizeContainer() + "");


      return f_FlowPanel1;
    }

    /**
     * Getter for popupArrow called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_popupArrow() {
      return build_popupArrow();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_popupArrow() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel popupArrow = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      popupArrow.setStyleName("" + get_style().PopupArrow() + "");


      owner.popupArrow = popupArrow;

      return popupArrow;
    }

    /**
     * Getter for contentPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_contentPanel() {
      return build_contentPanel();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_contentPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel contentPanel = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.
      contentPanel.setStyleName("" + get_style().content() + "");


      owner.contentPanel = contentPanel;

      return contentPanel;
    }

    /**
     * Getter for downPopupArrow called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_downPopupArrow() {
      return build_downPopupArrow();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_downPopupArrow() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel downPopupArrow = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.


      owner.downPopupArrow = downPopupArrow;

      return downPopupArrow;
    }
  }
}
