package org.ednovo.gooru.client.mvp.play.resource;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class ResourcePlayerView_CollectionPlayerViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.play.resource.ResourcePlayerView>, org.ednovo.gooru.client.mvp.play.resource.ResourcePlayerView.CollectionPlayerViewUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.play.resource.ResourcePlayerView owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.play.resource.ResourcePlayerView owner;


    public Widgets(final org.ednovo.gooru.client.mvp.play.resource.ResourcePlayerView owner) {
      this.owner = owner;
      build_playerStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.resource.ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.play.resource.ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.play.resource.ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.play.resource.ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.play.resource.ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for playerStyle called 0 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.resource.ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle get_playerStyle() {
      return build_playerStyle();
    }
    private org.ednovo.gooru.client.mvp.play.resource.ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle build_playerStyle() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.play.resource.ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle playerStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().playerStyle();
      // Setup section.
      playerStyle.ensureInjected();


      return playerStyle;
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
      f_FlowPanel1.add(get_f_FlowPanel2());
      f_FlowPanel1.add(get_navigationContainer());
      f_FlowPanel1.add(get_playerBodyContainer());


      return f_FlowPanel1;
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
      f_FlowPanel2.add(get_headerView());


      return f_FlowPanel2;
    }

    /**
     * Getter for headerView called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.mvp.play.collection.header.ResourcePlayerHeaderView get_headerView() {
      return build_headerView();
    }
    private org.ednovo.gooru.client.mvp.play.collection.header.ResourcePlayerHeaderView build_headerView() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.play.collection.header.ResourcePlayerHeaderView headerView = (org.ednovo.gooru.client.mvp.play.collection.header.ResourcePlayerHeaderView) GWT.create(org.ednovo.gooru.client.mvp.play.collection.header.ResourcePlayerHeaderView.class);
      // Setup section.


      owner.headerView = headerView;

      return headerView;
    }

    /**
     * Getter for navigationContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_navigationContainer() {
      return build_navigationContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_navigationContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel navigationContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      owner.navigationContainer = navigationContainer;

      return navigationContainer;
    }

    /**
     * Getter for playerBodyContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_playerBodyContainer() {
      return build_playerBodyContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_playerBodyContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel playerBodyContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      owner.playerBodyContainer = playerBodyContainer;

      return playerBodyContainer;
    }
  }
}
