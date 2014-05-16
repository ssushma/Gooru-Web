package org.ednovo.gooru.client.mvp.profilepage.tab.content.item;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class ProfilePageItemChildView_ProfilePageItemChildViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.profilepage.tab.content.item.ProfilePageItemChildView>, org.ednovo.gooru.client.mvp.profilepage.tab.content.item.ProfilePageItemChildView.ProfilePageItemChildViewUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.profilepage.tab.content.item.ProfilePageItemChildView owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.profilepage.tab.content.item.ProfilePageItemChildView owner;


    public Widgets(final org.ednovo.gooru.client.mvp.profilepage.tab.content.item.ProfilePageItemChildView owner) {
      this.owner = owner;
      build_ProfilePageItemStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.profilepage.tab.content.item.ProfilePageItemChildView_ProfilePageItemChildViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.profilepage.tab.content.item.ProfilePageItemChildView_ProfilePageItemChildViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.profilepage.tab.content.item.ProfilePageItemChildView_ProfilePageItemChildViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.profilepage.tab.content.item.ProfilePageItemChildView_ProfilePageItemChildViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.profilepage.tab.content.item.ProfilePageItemChildView_ProfilePageItemChildViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for ProfilePageItemStyle called 7 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.profilepage.tab.content.item.ProfilePageItemChildView_ProfilePageItemChildViewUiBinderImpl_GenCss_ProfilePageItemStyle ProfilePageItemStyle;
    private org.ednovo.gooru.client.mvp.profilepage.tab.content.item.ProfilePageItemChildView_ProfilePageItemChildViewUiBinderImpl_GenCss_ProfilePageItemStyle get_ProfilePageItemStyle() {
      return ProfilePageItemStyle;
    }
    private org.ednovo.gooru.client.mvp.profilepage.tab.content.item.ProfilePageItemChildView_ProfilePageItemChildViewUiBinderImpl_GenCss_ProfilePageItemStyle build_ProfilePageItemStyle() {
      // Creation section.
      ProfilePageItemStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().ProfilePageItemStyle();
      // Setup section.
      ProfilePageItemStyle.ensureInjected();


      return ProfilePageItemStyle;
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
      f_FlowPanel1.add(get_childItemFolderIcon());
      f_FlowPanel1.add(get_f_FlowPanel2());
      f_FlowPanel1.add(get_actionVerPanel());
      f_FlowPanel1.setStyleName("" + get_ProfilePageItemStyle().folderBlock() + "");


      return f_FlowPanel1;
    }

    /**
     * Getter for childItemFolderIcon called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_childItemFolderIcon() {
      return build_childItemFolderIcon();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_childItemFolderIcon() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel childItemFolderIcon = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      childItemFolderIcon.setStyleName("" + get_ProfilePageItemStyle().folderIcon() + "");


      owner.childItemFolderIcon = childItemFolderIcon;

      return childItemFolderIcon;
    }

    /**
     * Getter for f_FlowPanel2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel2() {
      return build_f_FlowPanel2();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel2 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel2.add(get_lblChildItemTitle());
      f_FlowPanel2.add(get_lblChildItemDescription());
      f_FlowPanel2.setStyleName("" + get_ProfilePageItemStyle().folderInfo() + "");


      return f_FlowPanel2;
    }

    /**
     * Getter for lblChildItemTitle called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_lblChildItemTitle() {
      return build_lblChildItemTitle();
    }
    private com.google.gwt.user.client.ui.Label build_lblChildItemTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblChildItemTitle = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblChildItemTitle.setStyleName("" + get_ProfilePageItemStyle().folderTitle() + "");


      owner.lblChildItemTitle = lblChildItemTitle;

      return lblChildItemTitle;
    }

    /**
     * Getter for lblChildItemDescription called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_lblChildItemDescription() {
      return build_lblChildItemDescription();
    }
    private com.google.gwt.user.client.ui.Label build_lblChildItemDescription() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblChildItemDescription = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblChildItemDescription.setStyleName("" + get_ProfilePageItemStyle().folderDescription() + "");


      owner.lblChildItemDescription = lblChildItemDescription;

      return lblChildItemDescription;
    }

    /**
     * Getter for actionVerPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_actionVerPanel() {
      return build_actionVerPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_actionVerPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel actionVerPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      actionVerPanel.add(get_childItemOpenBtn());
      actionVerPanel.setStyleName("" + get_ProfilePageItemStyle().blockHoverButtons() + "");


      owner.actionVerPanel = actionVerPanel;

      return actionVerPanel;
    }

    /**
     * Getter for childItemOpenBtn called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_childItemOpenBtn() {
      return build_childItemOpenBtn();
    }
    private com.google.gwt.user.client.ui.Button build_childItemOpenBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button childItemOpenBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      childItemOpenBtn.setStyleName("" + get_ProfilePageItemStyle().gooruButton() + "");


      owner.childItemOpenBtn = childItemOpenBtn;

      return childItemOpenBtn;
    }
  }
}
