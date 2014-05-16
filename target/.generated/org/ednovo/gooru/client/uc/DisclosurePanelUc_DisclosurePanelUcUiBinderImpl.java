package org.ednovo.gooru.client.uc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class DisclosurePanelUc_DisclosurePanelUcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.uc.DisclosurePanelUc>, org.ednovo.gooru.client.uc.DisclosurePanelUc.DisclosurePanelUcUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.uc.DisclosurePanelUc owner) {


    return new Widgets(owner).get_filterPanel();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.uc.DisclosurePanelUc owner;


    public Widgets(final org.ednovo.gooru.client.uc.DisclosurePanelUc owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.DisclosurePanelUc_DisclosurePanelUcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.uc.DisclosurePanelUc_DisclosurePanelUcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.uc.DisclosurePanelUc_DisclosurePanelUcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.uc.DisclosurePanelUc_DisclosurePanelUcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.uc.DisclosurePanelUc_DisclosurePanelUcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 4 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.UcCBundle res;
    private org.ednovo.gooru.client.uc.UcCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.uc.UcCBundle build_res() {
      // Creation section.
      res = owner.res;
      assert res != null : "UiField res with 'provided = true' was null";
      // Setup section.


      return res;
    }

    /**
     * Getter for filterPanel called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.DisclosurePanel get_filterPanel() {
      return build_filterPanel();
    }
    private com.google.gwt.user.client.ui.DisclosurePanel build_filterPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.DisclosurePanel filterPanel = (com.google.gwt.user.client.ui.DisclosurePanel) GWT.create(com.google.gwt.user.client.ui.DisclosurePanel.class);
      // Setup section.
      filterPanel.add(get_contentPanel());
      filterPanel.setHeader(get_headerPanel());
      filterPanel.setStyleName("" + get_res().css().disclosurePanelUc() + "");
      filterPanel.setOpen(true);
      filterPanel.setAnimationEnabled(true);


      owner.filterPanel = filterPanel;

      return filterPanel;
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


      owner.contentPanel = contentPanel;

      return contentPanel;
    }

    /**
     * Getter for headerPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FocusPanel get_headerPanel() {
      return build_headerPanel();
    }
    private com.google.gwt.user.client.ui.FocusPanel build_headerPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FocusPanel headerPanel = (com.google.gwt.user.client.ui.FocusPanel) GWT.create(com.google.gwt.user.client.ui.FocusPanel.class);
      // Setup section.
      headerPanel.add(get_f_FlowPanel1());


      owner.headerPanel = headerPanel;

      return headerPanel;
    }

    /**
     * Getter for f_FlowPanel1 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel1() {
      return build_f_FlowPanel1();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel1 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel1.add(get_imagePanel());
      f_FlowPanel1.add(get_titleLbl());
      f_FlowPanel1.setStyleName("" + get_res().css().disclosurePanelUcHeader() + "");


      return f_FlowPanel1;
    }

    /**
     * Getter for imagePanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_imagePanel() {
      return build_imagePanel();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_imagePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel imagePanel = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.
      imagePanel.add(get_titleImg());
      imagePanel.setStyleName("floatLeft");
      imagePanel.setWidth("10px");


      owner.imagePanel = imagePanel;

      return imagePanel;
    }

    /**
     * Getter for titleImg called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Image get_titleImg() {
      return build_titleImg();
    }
    private com.google.gwt.user.client.ui.Image build_titleImg() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image titleImg = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      titleImg.setStyleName("" + get_res().css().disclosurePanelUcHeaderImgOpen() + "");


      owner.titleImg = titleImg;

      return titleImg;
    }

    /**
     * Getter for titleLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_titleLbl() {
      return build_titleLbl();
    }
    private com.google.gwt.user.client.ui.Label build_titleLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label titleLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      titleLbl.setStyleName("" + get_res().css().disclosurePanelUcHeaderText() + "");


      owner.titleLbl = titleLbl;

      return titleLbl;
    }
  }
}
