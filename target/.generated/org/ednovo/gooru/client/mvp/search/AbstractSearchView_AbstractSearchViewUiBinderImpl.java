package org.ednovo.gooru.client.mvp.search;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class AbstractSearchView_AbstractSearchViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.search.AbstractSearchView<?>>, org.ednovo.gooru.client.mvp.search.AbstractSearchView.AbstractSearchViewUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.search.AbstractSearchView<?> owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.search.AbstractSearchView<?> owner;


    public Widgets(final org.ednovo.gooru.client.mvp.search.AbstractSearchView<?> owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.search.AbstractSearchView_AbstractSearchViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.search.AbstractSearchView_AbstractSearchViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.search.AbstractSearchView_AbstractSearchViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.search.AbstractSearchView_AbstractSearchViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.search.AbstractSearchView_AbstractSearchViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for style called 3 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.search.AbstractSearchView_AbstractSearchViewUiBinderImpl_GenCss_style style;
    private org.ednovo.gooru.client.mvp.search.AbstractSearchView_AbstractSearchViewUiBinderImpl_GenCss_style get_style() {
      return style;
    }
    private org.ednovo.gooru.client.mvp.search.AbstractSearchView_AbstractSearchViewUiBinderImpl_GenCss_style build_style() {
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
      f_FlowPanel1.add(get_searchFilterPanel());
      f_FlowPanel1.add(get_f_FlowPanel2());


      return f_FlowPanel1;
    }

    /**
     * Getter for searchFilterPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.ScrollPanel get_searchFilterPanel() {
      return build_searchFilterPanel();
    }
    private com.google.gwt.user.client.ui.ScrollPanel build_searchFilterPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.ScrollPanel searchFilterPanel = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
      // Setup section.
      searchFilterPanel.add(get_searchFilterVc());
      searchFilterPanel.setStyleName("" + get_style().searchFilter() + "");


      owner.searchFilterPanel = searchFilterPanel;

      return searchFilterPanel;
    }

    /**
     * Getter for searchFilterVc called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.mvp.search.SearchFilterVc get_searchFilterVc() {
      return build_searchFilterVc();
    }
    private org.ednovo.gooru.client.mvp.search.SearchFilterVc build_searchFilterVc() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.search.SearchFilterVc searchFilterVc = owner.searchFilterVc;
      assert searchFilterVc != null : "UiField searchFilterVc with 'provided = true' was null";
      // Setup section.


      return searchFilterVc;
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
      f_FlowPanel2.add(get_searchResultPanel());
      f_FlowPanel2.add(get_paginationFocPanel());
      f_FlowPanel2.setStyleName("" + get_style().searchResultContainer() + "");


      return f_FlowPanel2;
    }

    /**
     * Getter for searchResultPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.mvp.dnd.AppMirageDragContainer get_searchResultPanel() {
      return build_searchResultPanel();
    }
    private org.ednovo.gooru.client.mvp.dnd.AppMirageDragContainer build_searchResultPanel() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.dnd.AppMirageDragContainer searchResultPanel = owner.searchResultPanel;
      assert searchResultPanel != null : "UiField searchResultPanel with 'provided = true' was null";
      // Setup section.


      return searchResultPanel;
    }

    /**
     * Getter for paginationFocPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_paginationFocPanel() {
      return build_paginationFocPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_paginationFocPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel paginationFocPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      paginationFocPanel.setStyleName("" + get_style().paginationPanel() + "");


      owner.paginationFocPanel = paginationFocPanel;

      return paginationFocPanel;
    }
  }
}
