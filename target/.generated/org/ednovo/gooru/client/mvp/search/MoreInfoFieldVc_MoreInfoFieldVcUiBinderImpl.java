package org.ednovo.gooru.client.mvp.search;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class MoreInfoFieldVc_MoreInfoFieldVcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc>, org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc.MoreInfoFieldVcUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc owner;


    public Widgets(final org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc_MoreInfoFieldVcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc_MoreInfoFieldVcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc_MoreInfoFieldVcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc_MoreInfoFieldVcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc_MoreInfoFieldVcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 4 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.search.SearchMoreInfoVcCBundle res;
    private org.ednovo.gooru.client.mvp.search.SearchMoreInfoVcCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.mvp.search.SearchMoreInfoVcCBundle build_res() {
      // Creation section.
      res = (org.ednovo.gooru.client.mvp.search.SearchMoreInfoVcCBundle) GWT.create(org.ednovo.gooru.client.mvp.search.SearchMoreInfoVcCBundle.class);
      // Setup section.


      return res;
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
      f_FlowPanel1.add(get_f_LeftToolTipWidgetUc2());
      f_FlowPanel1.add(get_contentFloPanel());
      f_FlowPanel1.add(get_clearSimplePanel());


      return f_FlowPanel1;
    }

    /**
     * Getter for f_LeftToolTipWidgetUc2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.uc.LeftToolTipWidgetUc get_f_LeftToolTipWidgetUc2() {
      return build_f_LeftToolTipWidgetUc2();
    }
    private org.ednovo.gooru.client.uc.LeftToolTipWidgetUc build_f_LeftToolTipWidgetUc2() {
      // Creation section.
      final org.ednovo.gooru.client.uc.LeftToolTipWidgetUc f_LeftToolTipWidgetUc2 = (org.ednovo.gooru.client.uc.LeftToolTipWidgetUc) GWT.create(org.ednovo.gooru.client.uc.LeftToolTipWidgetUc.class);
      // Setup section.
      f_LeftToolTipWidgetUc2.setWidget(get_imageIconSimPanel());
      f_LeftToolTipWidgetUc2.setToolTipWidget(get_toolTipHtml());


      return f_LeftToolTipWidgetUc2;
    }

    /**
     * Getter for imageIconSimPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_imageIconSimPanel() {
      return build_imageIconSimPanel();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_imageIconSimPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel imageIconSimPanel = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.
      imageIconSimPanel.setStyleName("" + get_res().css().imageIcon() + "");


      owner.imageIconSimPanel = imageIconSimPanel;

      return imageIconSimPanel;
    }

    /**
     * Getter for toolTipHtml called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTML get_toolTipHtml() {
      return build_toolTipHtml();
    }
    private com.google.gwt.user.client.ui.HTML build_toolTipHtml() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML toolTipHtml = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      toolTipHtml.setStyleName("" + get_res().css().htmlTxt() + "");


      owner.toolTipHtml = toolTipHtml;

      return toolTipHtml;
    }

    /**
     * Getter for contentFloPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_contentFloPanel() {
      return build_contentFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_contentFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel contentFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      contentFloPanel.setStyleName("" + get_res().css().htmlTxt() + "");


      owner.contentFloPanel = contentFloPanel;

      return contentFloPanel;
    }

    /**
     * Getter for clearSimplePanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_clearSimplePanel() {
      return build_clearSimplePanel();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_clearSimplePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel clearSimplePanel = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.
      clearSimplePanel.setStyleName("" + get_res().css().clear() + "");


      owner.clearSimplePanel = clearSimplePanel;

      return clearSimplePanel;
    }
  }
}
