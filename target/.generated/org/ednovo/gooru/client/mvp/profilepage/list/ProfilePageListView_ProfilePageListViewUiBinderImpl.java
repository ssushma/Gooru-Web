package org.ednovo.gooru.client.mvp.profilepage.list;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class ProfilePageListView_ProfilePageListViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListView>, org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListView.ProfilePageListViewUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListView owner) {


    return new Widgets(owner).get_collectionListScrollpanel();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListView owner;


    public Widgets(final org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListView owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_res();  // no getter call detected but must bind to ui:field. Type: IMPORTED, precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListView_ProfilePageListViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListView_ProfilePageListViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListView_ProfilePageListViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListView_ProfilePageListViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListView_ProfilePageListViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 0 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.profilepage.list.ShelfListCBundle get_res() {
      return build_res();
    }
    private org.ednovo.gooru.client.mvp.profilepage.list.ShelfListCBundle build_res() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.profilepage.list.ShelfListCBundle res = owner.res;
      assert res != null : "UiField res with 'provided = true' was null";
      // Setup section.


      return res;
    }

    /**
     * Getter for style called 1 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListView_ProfilePageListViewUiBinderImpl_GenCss_style get_style() {
      return build_style();
    }
    private org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListView_ProfilePageListViewUiBinderImpl_GenCss_style build_style() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListView_ProfilePageListViewUiBinderImpl_GenCss_style style = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().style();
      // Setup section.
      style.ensureInjected();


      return style;
    }

    /**
     * Getter for collectionListScrollpanel called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.ScrollPanel get_collectionListScrollpanel() {
      return build_collectionListScrollpanel();
    }
    private com.google.gwt.user.client.ui.ScrollPanel build_collectionListScrollpanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.ScrollPanel collectionListScrollpanel = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
      // Setup section.
      collectionListScrollpanel.add(get_myShelfVerPanel());
      collectionListScrollpanel.setStyleName("" + get_style().collectionScrlPanel() + "");


      owner.collectionListScrollpanel = collectionListScrollpanel;

      return collectionListScrollpanel;
    }

    /**
     * Getter for myShelfVerPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.VerticalPanel get_myShelfVerPanel() {
      return build_myShelfVerPanel();
    }
    private com.google.gwt.user.client.ui.VerticalPanel build_myShelfVerPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.VerticalPanel myShelfVerPanel = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
      // Setup section.


      owner.myShelfVerPanel = myShelfVerPanel;

      return myShelfVerPanel;
    }
  }
}
