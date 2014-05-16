package org.ednovo.gooru.client.uc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class StandardSgItemVc_StandardSgItemVcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.uc.StandardSgItemVc>, org.ednovo.gooru.client.uc.StandardSgItemVc.StandardSgItemVcUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.uc.StandardSgItemVc owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.uc.StandardSgItemVc owner;


    public Widgets(final org.ednovo.gooru.client.uc.StandardSgItemVc owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.StandardSgItemVc_StandardSgItemVcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.uc.StandardSgItemVc_StandardSgItemVcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.uc.StandardSgItemVc_StandardSgItemVcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.uc.StandardSgItemVc_StandardSgItemVcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.uc.StandardSgItemVc_StandardSgItemVcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 2 times. Type: IMPORTED. Build precedence: 1.
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
     * Getter for f_FlowPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel1() {
      return build_f_FlowPanel1();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel1 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel1.add(get_standardsTitle());
      f_FlowPanel1.add(get_standardsDesc());


      return f_FlowPanel1;
    }

    /**
     * Getter for standardsTitle called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTML get_standardsTitle() {
      return build_standardsTitle();
    }
    private com.google.gwt.user.client.ui.HTML build_standardsTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML standardsTitle = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      standardsTitle.setStyleName("" + get_res().css().standards() + "");


      owner.standardsTitle = standardsTitle;

      return standardsTitle;
    }

    /**
     * Getter for standardsDesc called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTML get_standardsDesc() {
      return build_standardsDesc();
    }
    private com.google.gwt.user.client.ui.HTML build_standardsDesc() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML standardsDesc = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      standardsDesc.setStyleName("" + get_res().css().descStandards() + "");


      owner.standardsDesc = standardsDesc;

      return standardsDesc;
    }
  }
}
