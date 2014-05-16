package org.ednovo.gooru.client.mvp.search;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class SearchResultWrapperVc_SearchResultWrapperVcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.search.SearchResultWrapperVc<?, ?>>, org.ednovo.gooru.client.mvp.search.SearchResultWrapperVc.SearchResultWrapperVcUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.search.SearchResultWrapperVc<?, ?> owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.search.SearchResultWrapperVc<?, ?> owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onMoreInfoLinkClicked(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onShareShortenUrlLink(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.search.SearchResultWrapperVc<?, ?> owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.search.SearchResultWrapperVc_SearchResultWrapperVcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.search.SearchResultWrapperVc_SearchResultWrapperVcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.search.SearchResultWrapperVc_SearchResultWrapperVcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.search.SearchResultWrapperVc_SearchResultWrapperVcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.search.SearchResultWrapperVc_SearchResultWrapperVcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 9 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.search.SearchResultWrapperCBundle res;
    private org.ednovo.gooru.client.mvp.search.SearchResultWrapperCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.mvp.search.SearchResultWrapperCBundle build_res() {
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
      f_FlowPanel1.add(get_dragHandleFocPanel());
      f_FlowPanel1.add(get_resourcePlayerClickPanel());
      f_FlowPanel1.add(get_f_FlowPanel3());
      f_FlowPanel1.add(get_disclosureDisPanel());


      return f_FlowPanel1;
    }

    /**
     * Getter for dragHandleFocPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FocusPanel get_dragHandleFocPanel() {
      return build_dragHandleFocPanel();
    }
    private com.google.gwt.user.client.ui.FocusPanel build_dragHandleFocPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FocusPanel dragHandleFocPanel = (com.google.gwt.user.client.ui.FocusPanel) GWT.create(com.google.gwt.user.client.ui.FocusPanel.class);
      // Setup section.
      dragHandleFocPanel.add(get_f_FlowPanel2());
      dragHandleFocPanel.setStyleName("" + get_res().css().searchResultWrapper() + "");


      owner.dragHandleFocPanel = dragHandleFocPanel;

      return dragHandleFocPanel;
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
      f_FlowPanel2.add(get_contentSimPanel());
      f_FlowPanel2.add(get_addedStatusLbl());


      return f_FlowPanel2;
    }

    /**
     * Getter for contentSimPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_contentSimPanel() {
      return build_contentSimPanel();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_contentSimPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel contentSimPanel = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.
      contentSimPanel.setStyleName("" + get_res().css().contentPanel() + "");


      owner.contentSimPanel = contentSimPanel;

      return contentSimPanel;
    }

    /**
     * Getter for addedStatusLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_addedStatusLbl() {
      return build_addedStatusLbl();
    }
    private com.google.gwt.user.client.ui.Label build_addedStatusLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label addedStatusLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      addedStatusLbl.setStyleName("" + get_res().css().statusLbl() + "");


      owner.addedStatusLbl = addedStatusLbl;

      return addedStatusLbl;
    }

    /**
     * Getter for resourcePlayerClickPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_resourcePlayerClickPanel() {
      return build_resourcePlayerClickPanel();
    }
    private com.google.gwt.user.client.ui.Label build_resourcePlayerClickPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label resourcePlayerClickPanel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.resourcePlayerClickPanel = resourcePlayerClickPanel;

      return resourcePlayerClickPanel;
    }

    /**
     * Getter for f_FlowPanel3 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel3() {
      return build_f_FlowPanel3();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel3 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel3.add(get_disclosureHeaderFloPanel());
      f_FlowPanel3.setStyleName("" + get_res().css().disclosureMainHeader() + "");


      return f_FlowPanel3;
    }

    /**
     * Getter for disclosureHeaderFloPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_disclosureHeaderFloPanel() {
      return build_disclosureHeaderFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_disclosureHeaderFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel disclosureHeaderFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      disclosureHeaderFloPanel.add(get_moreInfoLinkFocPanel());
      disclosureHeaderFloPanel.add(get_shareLinkFocPanel());
      disclosureHeaderFloPanel.setStyleName("" + get_res().css().disclosureHeader() + "");


      owner.disclosureHeaderFloPanel = disclosureHeaderFloPanel;

      return disclosureHeaderFloPanel;
    }

    /**
     * Getter for moreInfoLinkFocPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FocusPanel get_moreInfoLinkFocPanel() {
      return build_moreInfoLinkFocPanel();
    }
    private com.google.gwt.user.client.ui.FocusPanel build_moreInfoLinkFocPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FocusPanel moreInfoLinkFocPanel = (com.google.gwt.user.client.ui.FocusPanel) GWT.create(com.google.gwt.user.client.ui.FocusPanel.class);
      // Setup section.
      moreInfoLinkFocPanel.add(get_moreInfoLbl());
      moreInfoLinkFocPanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.moreInfoLinkFocPanel = moreInfoLinkFocPanel;

      return moreInfoLinkFocPanel;
    }

    /**
     * Getter for moreInfoLbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_moreInfoLbl() {
      return build_moreInfoLbl();
    }
    private com.google.gwt.user.client.ui.Label build_moreInfoLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label moreInfoLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      moreInfoLbl.setStyleName("" + get_res().css().moreInfo() + "");


      owner.moreInfoLbl = moreInfoLbl;

      return moreInfoLbl;
    }

    /**
     * Getter for shareLinkFocPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FocusPanel get_shareLinkFocPanel() {
      return build_shareLinkFocPanel();
    }
    private com.google.gwt.user.client.ui.FocusPanel build_shareLinkFocPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FocusPanel shareLinkFocPanel = (com.google.gwt.user.client.ui.FocusPanel) GWT.create(com.google.gwt.user.client.ui.FocusPanel.class);
      // Setup section.
      shareLinkFocPanel.add(get_shareLbl());
      shareLinkFocPanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.shareLinkFocPanel = shareLinkFocPanel;

      return shareLinkFocPanel;
    }

    /**
     * Getter for shareLbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_shareLbl() {
      return build_shareLbl();
    }
    private com.google.gwt.user.client.ui.Label build_shareLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label shareLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      shareLbl.setStyleName("" + get_res().css().share() + "");


      owner.shareLbl = shareLbl;

      return shareLbl;
    }

    /**
     * Getter for disclosureDisPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.DisclosurePanel get_disclosureDisPanel() {
      return build_disclosureDisPanel();
    }
    private com.google.gwt.user.client.ui.DisclosurePanel build_disclosureDisPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.DisclosurePanel disclosureDisPanel = (com.google.gwt.user.client.ui.DisclosurePanel) GWT.create(com.google.gwt.user.client.ui.DisclosurePanel.class);
      // Setup section.
      disclosureDisPanel.add(get_disclosureContentSimPanel());
      disclosureDisPanel.setHeader(get_f_SimplePanel4());
      disclosureDisPanel.setStyleName("" + get_res().css().disclosurePanel() + "");
      disclosureDisPanel.setAnimationEnabled(true);


      owner.disclosureDisPanel = disclosureDisPanel;

      return disclosureDisPanel;
    }

    /**
     * Getter for disclosureContentSimPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_disclosureContentSimPanel() {
      return build_disclosureContentSimPanel();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_disclosureContentSimPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel disclosureContentSimPanel = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.
      disclosureContentSimPanel.setStyleName("" + get_res().css().disclosureContentPanel() + "");


      owner.disclosureContentSimPanel = disclosureContentSimPanel;

      return disclosureContentSimPanel;
    }

    /**
     * Getter for f_SimplePanel4 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_f_SimplePanel4() {
      return build_f_SimplePanel4();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_f_SimplePanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel f_SimplePanel4 = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.


      return f_SimplePanel4;
    }
  }
}
