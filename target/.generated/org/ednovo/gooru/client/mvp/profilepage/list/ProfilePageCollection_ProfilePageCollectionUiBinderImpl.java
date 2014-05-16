package org.ednovo.gooru.client.mvp.profilepage.list;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class ProfilePageCollection_ProfilePageCollectionUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageCollection>, org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageCollection.ProfilePageCollectionUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageCollection owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageCollection owner;


    public Widgets(final org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageCollection owner) {
      this.owner = owner;
      build_ProfilePageStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageCollection_ProfilePageCollectionUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageCollection_ProfilePageCollectionUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageCollection_ProfilePageCollectionUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageCollection_ProfilePageCollectionUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageCollection_ProfilePageCollectionUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 2 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.profilepage.list.ShelfListCBundle res;
    private org.ednovo.gooru.client.mvp.profilepage.list.ShelfListCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.mvp.profilepage.list.ShelfListCBundle build_res() {
      // Creation section.
      res = owner.res;
      assert res != null : "UiField res with 'provided = true' was null";
      // Setup section.


      return res;
    }

    /**
     * Getter for ProfilePageStyle called 3 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageCollection_ProfilePageCollectionUiBinderImpl_GenCss_ProfilePageStyle ProfilePageStyle;
    private org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageCollection_ProfilePageCollectionUiBinderImpl_GenCss_ProfilePageStyle get_ProfilePageStyle() {
      return ProfilePageStyle;
    }
    private org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageCollection_ProfilePageCollectionUiBinderImpl_GenCss_ProfilePageStyle build_ProfilePageStyle() {
      // Creation section.
      ProfilePageStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().ProfilePageStyle();
      // Setup section.
      ProfilePageStyle.ensureInjected();


      return ProfilePageStyle;
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
      f_FlowPanel1.add(get_titleFocPanel());
      f_FlowPanel1.add(get_disPanel());


      return f_FlowPanel1;
    }

    /**
     * Getter for titleFocPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FocusPanel get_titleFocPanel() {
      return build_titleFocPanel();
    }
    private com.google.gwt.user.client.ui.FocusPanel build_titleFocPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FocusPanel titleFocPanel = (com.google.gwt.user.client.ui.FocusPanel) GWT.create(com.google.gwt.user.client.ui.FocusPanel.class);
      // Setup section.
      titleFocPanel.add(get_f_FlowPanel2());


      owner.titleFocPanel = titleFocPanel;

      return titleFocPanel;
    }

    /**
     * Getter for f_FlowPanel2 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel2() {
      return build_f_FlowPanel2();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel2 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel2.add(get_folderIcon());
      f_FlowPanel2.add(get_collectionIcon());
      f_FlowPanel2.add(get_titleLbl());


      return f_FlowPanel2;
    }

    /**
     * Getter for folderIcon called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_folderIcon() {
      return build_folderIcon();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_folderIcon() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel folderIcon = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      folderIcon.setStyleName("" + get_ProfilePageStyle().folderlimarker() + "");


      owner.folderIcon = folderIcon;

      return folderIcon;
    }

    /**
     * Getter for collectionIcon called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_collectionIcon() {
      return build_collectionIcon();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_collectionIcon() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel collectionIcon = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      collectionIcon.setStyleName("" + get_ProfilePageStyle().collectionlimarker() + "");


      owner.collectionIcon = collectionIcon;

      return collectionIcon;
    }

    /**
     * Getter for titleLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTML get_titleLbl() {
      return build_titleLbl();
    }
    private com.google.gwt.user.client.ui.HTML build_titleLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML titleLbl = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      titleLbl.setStyleName("" + get_ProfilePageStyle().folderLiTitle() + "");


      owner.titleLbl = titleLbl;

      return titleLbl;
    }

    /**
     * Getter for disPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.DisclosurePanel get_disPanel() {
      return build_disPanel();
    }
    private com.google.gwt.user.client.ui.DisclosurePanel build_disPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.DisclosurePanel disPanel = (com.google.gwt.user.client.ui.DisclosurePanel) GWT.create(com.google.gwt.user.client.ui.DisclosurePanel.class);
      // Setup section.
      disPanel.add(get_wrapperFocPanel());
      disPanel.setHeader(get_f_SimplePanel3());
      disPanel.setStyleName("" + get_res().css().shelfCollection() + "");
      disPanel.setAnimationEnabled(true);


      owner.disPanel = disPanel;

      return disPanel;
    }

    /**
     * Getter for wrapperFocPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FocusPanel get_wrapperFocPanel() {
      return build_wrapperFocPanel();
    }
    private com.google.gwt.user.client.ui.FocusPanel build_wrapperFocPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FocusPanel wrapperFocPanel = (com.google.gwt.user.client.ui.FocusPanel) GWT.create(com.google.gwt.user.client.ui.FocusPanel.class);
      // Setup section.
      wrapperFocPanel.add(get_contentVerPanel());
      wrapperFocPanel.setStyleName("" + get_res().css().shelfContentWrapperPanelForFolders() + "");


      owner.wrapperFocPanel = wrapperFocPanel;

      return wrapperFocPanel;
    }

    /**
     * Getter for contentVerPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.VerticalPanel get_contentVerPanel() {
      return build_contentVerPanel();
    }
    private com.google.gwt.user.client.ui.VerticalPanel build_contentVerPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.VerticalPanel contentVerPanel = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
      // Setup section.


      owner.contentVerPanel = contentVerPanel;

      return contentVerPanel;
    }

    /**
     * Getter for f_SimplePanel3 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_f_SimplePanel3() {
      return build_f_SimplePanel3();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_f_SimplePanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel f_SimplePanel3 = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.


      return f_SimplePanel3;
    }
  }
}
