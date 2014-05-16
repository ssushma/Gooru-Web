package org.ednovo.gooru.client.mvp.socialshare;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class SocialShareLinksView_SocialShareLinksViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.socialshare.SocialShareLinksView>, org.ednovo.gooru.client.mvp.socialshare.SocialShareLinksView.SocialShareLinksViewUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.socialshare.SocialShareLinksView owner) {


    return new Widgets(owner).get_shareLinkFlwPl();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.socialshare.SocialShareLinksView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickSwithUrl(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickSwithToEmbed(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.socialshare.SocialShareLinksView owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.socialshare.SocialShareLinksView_SocialShareLinksViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.socialshare.SocialShareLinksView_SocialShareLinksViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.socialshare.SocialShareLinksView_SocialShareLinksViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.socialshare.SocialShareLinksView_SocialShareLinksViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.socialshare.SocialShareLinksView_SocialShareLinksViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 5 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.ShelfCBundle res;
    private org.ednovo.gooru.client.mvp.shelf.ShelfCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.mvp.shelf.ShelfCBundle build_res() {
      // Creation section.
      res = (org.ednovo.gooru.client.mvp.shelf.ShelfCBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.ShelfCBundle.class);
      // Setup section.


      return res;
    }

    /**
     * Getter for shareLinkFlwPl called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_shareLinkFlwPl() {
      return build_shareLinkFlwPl();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_shareLinkFlwPl() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel shareLinkFlwPl = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      shareLinkFlwPl.add(get_shareLbl());
      shareLinkFlwPl.add(get_shareLinkContainer());
      shareLinkFlwPl.add(get_swithUrlLbl());
      shareLinkFlwPl.add(get_swithToEmbedLbl());
      shareLinkFlwPl.setStyleName("" + get_res().css().shareLink2() + "");


      owner.shareLinkFlwPl = shareLinkFlwPl;

      return shareLinkFlwPl;
    }

    /**
     * Getter for shareLbl called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_shareLbl() {
      return build_shareLbl();
    }
    private com.google.gwt.user.client.ui.Label build_shareLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label shareLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.shareLbl = shareLbl;

      return shareLbl;
    }

    /**
     * Getter for shareLinkContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_shareLinkContainer() {
      return build_shareLinkContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_shareLinkContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel shareLinkContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      shareLinkContainer.add(get_shareLinkTxtBox());
      shareLinkContainer.setStyleName("" + get_res().css().shareLinkBoxContainer() + "");


      owner.shareLinkContainer = shareLinkContainer;

      return shareLinkContainer;
    }

    /**
     * Getter for shareLinkTxtBox called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.TextArea get_shareLinkTxtBox() {
      return build_shareLinkTxtBox();
    }
    private com.google.gwt.user.client.ui.TextArea build_shareLinkTxtBox() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextArea shareLinkTxtBox = (com.google.gwt.user.client.ui.TextArea) GWT.create(com.google.gwt.user.client.ui.TextArea.class);
      // Setup section.
      shareLinkTxtBox.setStyleName("" + get_res().css().shareLinkBox() + "");


      owner.shareLinkTxtBox = shareLinkTxtBox;

      return shareLinkTxtBox;
    }

    /**
     * Getter for swithUrlLbl called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_swithUrlLbl() {
      return build_swithUrlLbl();
    }
    private com.google.gwt.user.client.ui.Label build_swithUrlLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label swithUrlLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      swithUrlLbl.setStyleName("" + get_res().css().shareLinkSwitchUrl() + "");
      swithUrlLbl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.swithUrlLbl = swithUrlLbl;

      return swithUrlLbl;
    }

    /**
     * Getter for swithToEmbedLbl called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_swithToEmbedLbl() {
      return build_swithToEmbedLbl();
    }
    private com.google.gwt.user.client.ui.Label build_swithToEmbedLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label swithToEmbedLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      swithToEmbedLbl.setStyleName("" + get_res().css().shareLinkSwitchEmbed() + "");
      swithToEmbedLbl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.swithToEmbedLbl = swithToEmbedLbl;

      return swithToEmbedLbl;
    }
  }
}
