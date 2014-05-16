package org.ednovo.gooru.client.mvp.shelf.list;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class NoResourceInShelfListView_NoResourceInShelfListViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.shelf.list.NoResourceInShelfListView>, org.ednovo.gooru.client.mvp.shelf.list.NoResourceInShelfListView.NoResourceInShelfListViewUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.shelf.list.NoResourceInShelfListView owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.shelf.list.NoResourceInShelfListView owner;


    public Widgets(final org.ednovo.gooru.client.mvp.shelf.list.NoResourceInShelfListView owner) {
      this.owner = owner;
      build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();  // more than one getter call detected. Type: GENERATED_BUNDLE, precedence: 1
      build_folderStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 2 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.list.NoResourceInShelfListView_NoResourceInShelfListViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    private org.ednovo.gooru.client.mvp.shelf.list.NoResourceInShelfListView_NoResourceInShelfListViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }
    private org.ednovo.gooru.client.mvp.shelf.list.NoResourceInShelfListView_NoResourceInShelfListViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.shelf.list.NoResourceInShelfListView_NoResourceInShelfListViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.list.NoResourceInShelfListView_NoResourceInShelfListViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for folderStyle called 0 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.list.NoResourceInShelfListView_NoResourceInShelfListViewUiBinderImpl_GenCss_folderStyle get_folderStyle() {
      return build_folderStyle();
    }
    private org.ednovo.gooru.client.mvp.shelf.list.NoResourceInShelfListView_NoResourceInShelfListViewUiBinderImpl_GenCss_folderStyle build_folderStyle() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.list.NoResourceInShelfListView_NoResourceInShelfListViewUiBinderImpl_GenCss_folderStyle folderStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().folderStyle();
      // Setup section.
      folderStyle.ensureInjected();


      owner.folderStyle = folderStyle;

      return folderStyle;
    }

    /**
     * Getter for style called 9 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.list.NoResourceInShelfListView_NoResourceInShelfListViewUiBinderImpl_GenCss_style style;
    private org.ednovo.gooru.client.mvp.shelf.list.NoResourceInShelfListView_NoResourceInShelfListViewUiBinderImpl_GenCss_style get_style() {
      return style;
    }
    private org.ednovo.gooru.client.mvp.shelf.list.NoResourceInShelfListView_NoResourceInShelfListViewUiBinderImpl_GenCss_style build_style() {
      // Creation section.
      style = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().style();
      // Setup section.
      style.ensureInjected();


      return style;
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
      f_FlowPanel1.add(get_resourceUgArrowImg());
      f_FlowPanel1.add(get_emptyCollMsg_1());
      f_FlowPanel1.add(get_emptyCollMsg_2());
      f_FlowPanel1.add(get_resourceImageOneImg());
      f_FlowPanel1.add(get_resourceImageTwoImg());
      f_FlowPanel1.add(get_resourceImageThreeImg());
      f_FlowPanel1.add(get_userInfoMsg_1());
      f_FlowPanel1.add(get_userInfoMsg_2());
      f_FlowPanel1.setStyleName("" + get_style().draggingImages() + "");


      return f_FlowPanel1;
    }

    /**
     * Getter for resourceUgArrowImg called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_resourceUgArrowImg() {
      return build_resourceUgArrowImg();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_resourceUgArrowImg() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel resourceUgArrowImg = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.
      resourceUgArrowImg.setStyleName("" + get_style().resourceUpArrow() + "");


      owner.resourceUgArrowImg = resourceUgArrowImg;

      return resourceUgArrowImg;
    }

    /**
     * Getter for emptyCollMsg_1 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_emptyCollMsg_1() {
      return build_emptyCollMsg_1();
    }
    private com.google.gwt.user.client.ui.Label build_emptyCollMsg_1() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label emptyCollMsg_1 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      emptyCollMsg_1.setStyleName("" + get_style().emptyCollMsgHeading() + "");
      emptyCollMsg_1.setText("");


      owner.emptyCollMsg_1 = emptyCollMsg_1;

      return emptyCollMsg_1;
    }

    /**
     * Getter for emptyCollMsg_2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_emptyCollMsg_2() {
      return build_emptyCollMsg_2();
    }
    private com.google.gwt.user.client.ui.Label build_emptyCollMsg_2() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label emptyCollMsg_2 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      emptyCollMsg_2.setStyleName("" + get_style().emptyCollMsgSubHeading() + "");
      emptyCollMsg_2.setText("");


      owner.emptyCollMsg_2 = emptyCollMsg_2;

      return emptyCollMsg_2;
    }

    /**
     * Getter for resourceImageOneImg called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_resourceImageOneImg() {
      return build_resourceImageOneImg();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_resourceImageOneImg() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel resourceImageOneImg = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.
      resourceImageOneImg.setStyleName("" + get_style().resourceImageOne() + "");


      owner.resourceImageOneImg = resourceImageOneImg;

      return resourceImageOneImg;
    }

    /**
     * Getter for resourceImageTwoImg called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_resourceImageTwoImg() {
      return build_resourceImageTwoImg();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_resourceImageTwoImg() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel resourceImageTwoImg = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.
      resourceImageTwoImg.setStyleName("" + get_style().resourceImageTwo() + "");


      owner.resourceImageTwoImg = resourceImageTwoImg;

      return resourceImageTwoImg;
    }

    /**
     * Getter for resourceImageThreeImg called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_resourceImageThreeImg() {
      return build_resourceImageThreeImg();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_resourceImageThreeImg() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel resourceImageThreeImg = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.
      resourceImageThreeImg.setStyleName("" + get_style().resourceImageThree() + "");


      owner.resourceImageThreeImg = resourceImageThreeImg;

      return resourceImageThreeImg;
    }

    /**
     * Getter for userInfoMsg_1 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_userInfoMsg_1() {
      return build_userInfoMsg_1();
    }
    private com.google.gwt.user.client.ui.Label build_userInfoMsg_1() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label userInfoMsg_1 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      userInfoMsg_1.setStyleName("" + get_style().dragHere() + "");
      userInfoMsg_1.setText("");


      owner.userInfoMsg_1 = userInfoMsg_1;

      return userInfoMsg_1;
    }

    /**
     * Getter for userInfoMsg_2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_userInfoMsg_2() {
      return build_userInfoMsg_2();
    }
    private com.google.gwt.user.client.ui.Label build_userInfoMsg_2() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label userInfoMsg_2 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      userInfoMsg_2.setStyleName("" + get_style().saveThem() + "");
      userInfoMsg_2.setText("");


      owner.userInfoMsg_2 = userInfoMsg_2;

      return userInfoMsg_2;
    }
  }
}
