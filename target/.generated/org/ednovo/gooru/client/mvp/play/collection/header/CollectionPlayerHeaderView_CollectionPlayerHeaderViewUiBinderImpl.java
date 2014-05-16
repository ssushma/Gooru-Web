package org.ednovo.gooru.client.mvp.play.collection.header;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class CollectionPlayerHeaderView_CollectionPlayerHeaderViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.play.collection.header.CollectionPlayerHeaderView>, org.ednovo.gooru.client.mvp.play.collection.header.CollectionPlayerHeaderView.CollectionPlayerHeaderViewUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.play.collection.header.CollectionPlayerHeaderView owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.play.collection.header.CollectionPlayerHeaderView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.collectionPlay(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.play.collection.header.CollectionPlayerHeaderView owner) {
      this.owner = owner;
      build_headerStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_palyerBundle();  // more than one getter call detected. Type: IMPORTED, precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.collection.header.CollectionPlayerHeaderView_CollectionPlayerHeaderViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.play.collection.header.CollectionPlayerHeaderView_CollectionPlayerHeaderViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.play.collection.header.CollectionPlayerHeaderView_CollectionPlayerHeaderViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.play.collection.header.CollectionPlayerHeaderView_CollectionPlayerHeaderViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.play.collection.header.CollectionPlayerHeaderView_CollectionPlayerHeaderViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for headerStyle called 13 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.collection.header.CollectionPlayerHeaderView_CollectionPlayerHeaderViewUiBinderImpl_GenCss_headerStyle headerStyle;
    private org.ednovo.gooru.client.mvp.play.collection.header.CollectionPlayerHeaderView_CollectionPlayerHeaderViewUiBinderImpl_GenCss_headerStyle get_headerStyle() {
      return headerStyle;
    }
    private org.ednovo.gooru.client.mvp.play.collection.header.CollectionPlayerHeaderView_CollectionPlayerHeaderViewUiBinderImpl_GenCss_headerStyle build_headerStyle() {
      // Creation section.
      headerStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().headerStyle();
      // Setup section.
      headerStyle.ensureInjected();


      return headerStyle;
    }

    /**
     * Getter for palyerBundle called 6 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.PlayerBundle palyerBundle;
    private org.ednovo.gooru.client.uc.PlayerBundle get_palyerBundle() {
      return palyerBundle;
    }
    private org.ednovo.gooru.client.uc.PlayerBundle build_palyerBundle() {
      // Creation section.
      palyerBundle = (org.ednovo.gooru.client.uc.PlayerBundle) GWT.create(org.ednovo.gooru.client.uc.PlayerBundle.class);
      // Setup section.


      return palyerBundle;
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
      f_FlowPanel1.add(get_closeButtonForCollection());
      f_FlowPanel1.setStyleName("" + get_headerStyle().header() + "");


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
      f_FlowPanel2.add(get_resourceTitle());
      f_FlowPanel2.add(get_f_FlowPanel3());
      f_FlowPanel2.setStyleName("" + get_headerStyle().headerInner() + "");


      return f_FlowPanel2;
    }

    /**
     * Getter for resourceTitle called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTML get_resourceTitle() {
      return build_resourceTitle();
    }
    private com.google.gwt.user.client.ui.HTML build_resourceTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML resourceTitle = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      resourceTitle.setStyleName("" + get_headerStyle().playerResourceTitle() + "");


      owner.resourceTitle = resourceTitle;

      return resourceTitle;
    }

    /**
     * Getter for f_FlowPanel3 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel3() {
      return build_f_FlowPanel3();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel3 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel3.add(get_flagButton());
      f_FlowPanel3.add(get_addButton());
      f_FlowPanel3.add(get_infoButton());
      f_FlowPanel3.add(get_shareButton());
      f_FlowPanel3.add(get_narrationButton());
      f_FlowPanel3.add(get_navigationButton());
      f_FlowPanel3.add(get_studentViewButton());
      f_FlowPanel3.setStyleName("" + get_headerStyle().tabs() + " " + get_headerStyle().player_buttons() + "");


      return f_FlowPanel3;
    }

    /**
     * Getter for flagButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Button get_flagButton() {
      return build_flagButton();
    }
    private com.google.gwt.user.client.ui.Button build_flagButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button flagButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      flagButton.setStyleName("" + get_palyerBundle().getPlayerStyle().flagButtonDisable() + " " + get_headerStyle().tabs() + "");


      owner.flagButton = flagButton;

      return flagButton;
    }

    /**
     * Getter for addButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Button get_addButton() {
      return build_addButton();
    }
    private com.google.gwt.user.client.ui.Button build_addButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button addButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      addButton.setStyleName("" + get_palyerBundle().getPlayerStyle().addButtonDisabled() + " " + get_headerStyle().tabs() + "");


      owner.addButton = addButton;

      return addButton;
    }

    /**
     * Getter for infoButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Button get_infoButton() {
      return build_infoButton();
    }
    private com.google.gwt.user.client.ui.Button build_infoButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button infoButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      infoButton.setStyleName("" + get_palyerBundle().getPlayerStyle().infoButtonDisabled() + " " + get_headerStyle().tabs() + "");


      owner.infoButton = infoButton;

      return infoButton;
    }

    /**
     * Getter for shareButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Button get_shareButton() {
      return build_shareButton();
    }
    private com.google.gwt.user.client.ui.Button build_shareButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button shareButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      shareButton.setStyleName("" + get_palyerBundle().getPlayerStyle().shareButtonDisabled() + " " + get_headerStyle().tabs() + "");


      owner.shareButton = shareButton;

      return shareButton;
    }

    /**
     * Getter for narrationButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Button get_narrationButton() {
      return build_narrationButton();
    }
    private com.google.gwt.user.client.ui.Button build_narrationButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button narrationButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      narrationButton.setStyleName("" + get_palyerBundle().getPlayerStyle().narrationButtonDisabled() + " " + get_headerStyle().tabs() + "");


      owner.narrationButton = narrationButton;

      return narrationButton;
    }

    /**
     * Getter for navigationButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Button get_navigationButton() {
      return build_navigationButton();
    }
    private com.google.gwt.user.client.ui.Button build_navigationButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button navigationButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      navigationButton.setStyleName("" + get_palyerBundle().getPlayerStyle().navigationButtonDisabled() + " " + get_headerStyle().tabs() + "");


      owner.navigationButton = navigationButton;

      return navigationButton;
    }

    /**
     * Getter for studentViewButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Anchor get_studentViewButton() {
      return build_studentViewButton();
    }
    private com.google.gwt.user.client.ui.Anchor build_studentViewButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor studentViewButton = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      studentViewButton.setStyleName("" + get_headerStyle().playerStudentviewButton() + "");
      studentViewButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.studentViewButton = studentViewButton;

      return studentViewButton;
    }

    /**
     * Getter for closeButtonForCollection called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_closeButtonForCollection() {
      return build_closeButtonForCollection();
    }
    private com.google.gwt.user.client.ui.Label build_closeButtonForCollection() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label closeButtonForCollection = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      closeButtonForCollection.setStyleName("" + get_headerStyle().closeButton() + "");


      owner.closeButtonForCollection = closeButtonForCollection;

      return closeButtonForCollection;
    }
  }
}
