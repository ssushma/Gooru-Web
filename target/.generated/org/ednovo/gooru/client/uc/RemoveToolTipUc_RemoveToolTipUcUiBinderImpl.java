package org.ednovo.gooru.client.uc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class RemoveToolTipUc_RemoveToolTipUcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.uc.RemoveToolTipUc>, org.ednovo.gooru.client.uc.RemoveToolTipUc.RemoveToolTipUcUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.uc.RemoveToolTipUc owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.uc.RemoveToolTipUc owner;


    public Widgets(final org.ednovo.gooru.client.uc.RemoveToolTipUc owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.RemoveToolTipUc_RemoveToolTipUcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.uc.RemoveToolTipUc_RemoveToolTipUcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.uc.RemoveToolTipUc_RemoveToolTipUcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.uc.RemoveToolTipUc_RemoveToolTipUcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.uc.RemoveToolTipUc_RemoveToolTipUcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 3 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.UcCBundle res;
    private org.ednovo.gooru.client.uc.UcCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.uc.UcCBundle build_res() {
      // Creation section.
      res = (org.ednovo.gooru.client.uc.UcCBundle) GWT.create(org.ednovo.gooru.client.uc.UcCBundle.class);
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
      f_FlowPanel1.add(get_f_SimplePanel2());
      f_FlowPanel1.add(get_contentPanel());
      f_FlowPanel1.setStyleName("" + get_res().css().removeToolTipConatainer() + "");


      return f_FlowPanel1;
    }

    /**
     * Getter for f_SimplePanel2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_f_SimplePanel2() {
      return build_f_SimplePanel2();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_f_SimplePanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel f_SimplePanel2 = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.
      f_SimplePanel2.setStyleName("" + get_res().css().removeTollTipTopImage() + "");


      return f_SimplePanel2;
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
      contentPanel.add(get_removeText());
      contentPanel.setStyleName("" + get_res().css().removeToolTipContentContainer() + "");


      return contentPanel;
    }

    /**
     * Getter for removeText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_removeText() {
      return build_removeText();
    }
    private com.google.gwt.user.client.ui.Label build_removeText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label removeText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      removeText.setStyleName("");


      owner.removeText = removeText;

      return removeText;
    }
  }
}
