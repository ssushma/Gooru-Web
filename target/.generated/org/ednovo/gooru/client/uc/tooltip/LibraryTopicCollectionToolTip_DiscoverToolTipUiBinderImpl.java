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

public class LibraryTopicCollectionToolTip_DiscoverToolTipUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.uc.tooltip.LibraryTopicCollectionToolTip>, org.ednovo.gooru.client.uc.tooltip.LibraryTopicCollectionToolTip.DiscoverToolTipUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("<br>")
    SafeHtml html2();
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.uc.tooltip.LibraryTopicCollectionToolTip owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.uc.tooltip.LibraryTopicCollectionToolTip owner;


    public Widgets(final org.ednovo.gooru.client.uc.tooltip.LibraryTopicCollectionToolTip owner) {
      this.owner = owner;
      build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();  // more than one getter call detected. Type: GENERATED_BUNDLE, precedence: 1
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_toolTip();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2();
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 2 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.tooltip.LibraryTopicCollectionToolTip_DiscoverToolTipUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    private org.ednovo.gooru.client.uc.tooltip.LibraryTopicCollectionToolTip_DiscoverToolTipUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }
    private org.ednovo.gooru.client.uc.tooltip.LibraryTopicCollectionToolTip_DiscoverToolTipUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.uc.tooltip.LibraryTopicCollectionToolTip_DiscoverToolTipUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.uc.tooltip.LibraryTopicCollectionToolTip_DiscoverToolTipUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for style called 5 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.tooltip.LibraryTopicCollectionToolTip_DiscoverToolTipUiBinderImpl_GenCss_style style;
    private org.ednovo.gooru.client.uc.tooltip.LibraryTopicCollectionToolTip_DiscoverToolTipUiBinderImpl_GenCss_style get_style() {
      return style;
    }
    private org.ednovo.gooru.client.uc.tooltip.LibraryTopicCollectionToolTip_DiscoverToolTipUiBinderImpl_GenCss_style build_style() {
      // Creation section.
      style = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().style();
      // Setup section.
      style.ensureInjected();


      return style;
    }

    /**
     * Getter for toolTip called 2 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.tooltip.LibraryTopicCollectionToolTip_DiscoverToolTipUiBinderImpl_GenCss_toolTip toolTip;
    private org.ednovo.gooru.client.uc.tooltip.LibraryTopicCollectionToolTip_DiscoverToolTipUiBinderImpl_GenCss_toolTip get_toolTip() {
      return toolTip;
    }
    private org.ednovo.gooru.client.uc.tooltip.LibraryTopicCollectionToolTip_DiscoverToolTipUiBinderImpl_GenCss_toolTip build_toolTip() {
      // Creation section.
      toolTip = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().toolTip();
      // Setup section.
      toolTip.ensureInjected();


      return toolTip;
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
      f_FlowPanel1.add(get_arowPanel());
      f_FlowPanel1.add(get_organizePopupTextContainer());
      f_FlowPanel1.setStyleName("" + get_toolTip().organizeContainer() + "");


      return f_FlowPanel1;
    }

    /**
     * Getter for arowPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_arowPanel() {
      return build_arowPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_arowPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel arowPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      arowPanel.setStyleName("" + get_style().hoverPopupArrow() + "");


      owner.arowPanel = arowPanel;

      return arowPanel;
    }

    /**
     * Getter for organizePopupTextContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_organizePopupTextContainer() {
      return build_organizePopupTextContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_organizePopupTextContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel organizePopupTextContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      organizePopupTextContainer.add(get_textFlowPanel());
      organizePopupTextContainer.setStyleName("" + get_toolTip().organizePopupTextContainer() + "");


      owner.organizePopupTextContainer = organizePopupTextContainer;

      return organizePopupTextContainer;
    }

    /**
     * Getter for textFlowPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_textFlowPanel() {
      return build_textFlowPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_textFlowPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel textFlowPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      textFlowPanel.add(get_descPanel());
      textFlowPanel.add(get_categoryLbl());
      textFlowPanel.add(get_sourceLbl());
      textFlowPanel.setStyleName("" + get_style().organizeTextContainer() + "");


      owner.textFlowPanel = textFlowPanel;

      return textFlowPanel;
    }

    /**
     * Getter for descPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTML get_descPanel() {
      return build_descPanel();
    }
    private com.google.gwt.user.client.ui.HTML build_descPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML descPanel = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      descPanel.setHTML(template_html2().asString());
      descPanel.setStyleName("" + get_style().organizeRemainigText() + "");


      owner.descPanel = descPanel;

      return descPanel;
    }

    /**
     * Getter for categoryLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTML get_categoryLbl() {
      return build_categoryLbl();
    }
    private com.google.gwt.user.client.ui.HTML build_categoryLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML categoryLbl = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      categoryLbl.setStyleName("" + get_style().categoryLbl() + "");


      owner.categoryLbl = categoryLbl;

      return categoryLbl;
    }

    /**
     * Getter for sourceLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_sourceLbl() {
      return build_sourceLbl();
    }
    private com.google.gwt.user.client.ui.Label build_sourceLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label sourceLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      sourceLbl.setStyleName("" + get_style().sourceLbl() + "");


      owner.sourceLbl = sourceLbl;

      return sourceLbl;
    }
  }
}
