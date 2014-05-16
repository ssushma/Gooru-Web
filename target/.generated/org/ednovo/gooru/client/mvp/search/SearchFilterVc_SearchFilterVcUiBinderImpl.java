package org.ednovo.gooru.client.mvp.search;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.safehtml.shared.UriUtils;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class SearchFilterVc_SearchFilterVcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.search.SearchFilterVc>, org.ednovo.gooru.client.mvp.search.SearchFilterVc.SearchFilterVcUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("")
    SafeHtml html2();
     
    @Template("")
    SafeHtml html3();
     
    @Template("")
    SafeHtml html4();
     
    @Template("")
    SafeHtml html5();
     
    @Template("")
    SafeHtml html6();
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.search.SearchFilterVc owner) {


    return new Widgets(owner).get_myCollectionSearch();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.search.SearchFilterVc owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onResourceLinkLblClicked(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onCollectionLinkLblClicked(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onSourceHelpIconClicked(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onStandardHelpiconClicked(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onAggregatorHelpiconClicked(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClearFilter(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.search.SearchFilterVc owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2();
    }
    SafeHtml template_html3() {
      return template.html3();
    }
    SafeHtml template_html4() {
      return template.html4();
    }
    SafeHtml template_html5() {
      return template.html5();
    }
    SafeHtml template_html6() {
      return template.html6();
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.search.SearchFilterVc_SearchFilterVcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.search.SearchFilterVc_SearchFilterVcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.search.SearchFilterVc_SearchFilterVcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.search.SearchFilterVc_SearchFilterVcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.search.SearchFilterVc_SearchFilterVcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for style called 17 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.search.SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style style;
    private org.ednovo.gooru.client.mvp.search.SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style get_style() {
      return style;
    }
    private org.ednovo.gooru.client.mvp.search.SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style build_style() {
      // Creation section.
      style = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().style();
      // Setup section.
      style.ensureInjected();


      owner.style = style;

      return style;
    }

    /**
     * Getter for myCollectionSearch called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_myCollectionSearch() {
      return build_myCollectionSearch();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_myCollectionSearch() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel myCollectionSearch = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      myCollectionSearch.add(get_f_FlowPanel1());
      myCollectionSearch.add(get_flowpanel());
      myCollectionSearch.add(get_panelNotMobileFriendly());
      myCollectionSearch.add(get_categoryPanelUc());
      myCollectionSearch.add(get_sourcePanelUc());
      myCollectionSearch.add(get_aggregatorPanelUc());
      myCollectionSearch.add(get_authorPanelUc());
      myCollectionSearch.add(get_standardPanelUc());
      myCollectionSearch.add(get_subjectPanelUc());
      myCollectionSearch.add(get_gradePanelUc());
      myCollectionSearch.add(get_oerPanel());
      myCollectionSearch.add(get_f_FlowPanel2());
      myCollectionSearch.setStyleName("" + get_style().searchFilterVcContainer() + "");


      return myCollectionSearch;
    }

    /**
     * Getter for f_FlowPanel1 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel1() {
      return build_f_FlowPanel1();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel1 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel1.add(get_filtersText());


      return f_FlowPanel1;
    }

    /**
     * Getter for filtersText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_filtersText() {
      return build_filtersText();
    }
    private com.google.gwt.user.client.ui.Label build_filtersText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label filtersText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      filtersText.setStyleName("" + get_style().titleText() + "");


      owner.filtersText = filtersText;

      return filtersText;
    }

    /**
     * Getter for flowpanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_flowpanel() {
      return build_flowpanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_flowpanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel flowpanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      flowpanel.add(get_contentpanel());
      flowpanel.add(get_resourceLinkLbl());
      flowpanel.add(get_notifyText());
      flowpanel.add(get_collectionLinkLbl());
      flowpanel.setStyleName("" + get_style().PageNotify() + "");


      return flowpanel;
    }

    /**
     * Getter for contentpanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_contentpanel() {
      return build_contentpanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_contentpanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel contentpanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.


      return contentpanel;
    }

    /**
     * Getter for resourceLinkLbl called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Anchor get_resourceLinkLbl() {
      return build_resourceLinkLbl();
    }
    private com.google.gwt.user.client.ui.Anchor build_resourceLinkLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor resourceLinkLbl = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      resourceLinkLbl.setStyleName("" + get_style().notifyLink() + "");
      resourceLinkLbl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.resourceLinkLbl = resourceLinkLbl;

      return resourceLinkLbl;
    }

    /**
     * Getter for notifyText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_notifyText() {
      return build_notifyText();
    }
    private com.google.gwt.user.client.ui.Label build_notifyText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label notifyText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      notifyText.setStyleName("" + get_style().notifyLinks() + "");


      owner.notifyText = notifyText;

      return notifyText;
    }

    /**
     * Getter for collectionLinkLbl called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Anchor get_collectionLinkLbl() {
      return build_collectionLinkLbl();
    }
    private com.google.gwt.user.client.ui.Anchor build_collectionLinkLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor collectionLinkLbl = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      collectionLinkLbl.setStyleName("" + get_style().notifyLink() + "");
      collectionLinkLbl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.collectionLinkLbl = collectionLinkLbl;

      return collectionLinkLbl;
    }

    /**
     * Getter for panelNotMobileFriendly called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelNotMobileFriendly() {
      return build_panelNotMobileFriendly();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelNotMobileFriendly() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelNotMobileFriendly = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.


      owner.panelNotMobileFriendly = panelNotMobileFriendly;

      return panelNotMobileFriendly;
    }

    /**
     * Getter for categoryPanelUc called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.uc.DisclosurePanelUc get_categoryPanelUc() {
      return build_categoryPanelUc();
    }
    private org.ednovo.gooru.client.uc.DisclosurePanelUc build_categoryPanelUc() {
      // Creation section.
      final org.ednovo.gooru.client.uc.DisclosurePanelUc categoryPanelUc = (org.ednovo.gooru.client.uc.DisclosurePanelUc) GWT.create(org.ednovo.gooru.client.uc.DisclosurePanelUc.class);
      // Setup section.


      owner.categoryPanelUc = categoryPanelUc;

      return categoryPanelUc;
    }

    /**
     * Getter for sourcePanelUc called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.uc.DisclosurePanelUc get_sourcePanelUc() {
      return build_sourcePanelUc();
    }
    private org.ednovo.gooru.client.uc.DisclosurePanelUc build_sourcePanelUc() {
      // Creation section.
      final org.ednovo.gooru.client.uc.DisclosurePanelUc sourcePanelUc = (org.ednovo.gooru.client.uc.DisclosurePanelUc) GWT.create(org.ednovo.gooru.client.uc.DisclosurePanelUc.class);
      // Setup section.
      sourcePanelUc.addWidget(get_sourceSgstBox());
      sourcePanelUc.addWidget(get_sourceHelpicon());
      sourcePanelUc.addWidget(get_sourceToolTip());
      sourcePanelUc.addWidget(get_sourcesNotFoundLbl());
      sourcePanelUc.addWidget(get_sourceContainerFloPanel());
      sourcePanelUc.setVisible(false);


      owner.sourcePanelUc = sourcePanelUc;

      return sourcePanelUc;
    }

    /**
     * Getter for sourceSgstBox called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.uc.AppSuggestBox get_sourceSgstBox() {
      return build_sourceSgstBox();
    }
    private org.ednovo.gooru.client.uc.AppSuggestBox build_sourceSgstBox() {
      // Creation section.
      final org.ednovo.gooru.client.uc.AppSuggestBox sourceSgstBox = owner.sourceSgstBox;
      assert sourceSgstBox != null : "UiField sourceSgstBox with 'provided = true' was null";
      // Setup section.
      sourceSgstBox.setWidth("130px");


      return sourceSgstBox;
    }

    /**
     * Getter for sourceHelpicon called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_sourceHelpicon() {
      return build_sourceHelpicon();
    }
    private com.google.gwt.user.client.ui.Label build_sourceHelpicon() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label sourceHelpicon = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      sourceHelpicon.setStyleName("" + get_style().helpIconBtn() + "");
      sourceHelpicon.setVisible(false);
      sourceHelpicon.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);


      owner.sourceHelpicon = sourceHelpicon;

      return sourceHelpicon;
    }

    /**
     * Getter for sourceToolTip called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_sourceToolTip() {
      return build_sourceToolTip();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_sourceToolTip() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel sourceToolTip = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html3().asString());
      // Setup section.
      sourceToolTip.setStyleName("" + get_style().sourceToolTip() + "");
      sourceToolTip.setVisible(false);


      owner.sourceToolTip = sourceToolTip;

      return sourceToolTip;
    }

    /**
     * Getter for sourcesNotFoundLbl called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_sourcesNotFoundLbl() {
      return build_sourcesNotFoundLbl();
    }
    private com.google.gwt.user.client.ui.Label build_sourcesNotFoundLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label sourcesNotFoundLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      sourcesNotFoundLbl.setStyleName("" + get_style().notFound() + "");


      owner.sourcesNotFoundLbl = sourcesNotFoundLbl;

      return sourcesNotFoundLbl;
    }

    /**
     * Getter for sourceContainerFloPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_sourceContainerFloPanel() {
      return build_sourceContainerFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_sourceContainerFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel sourceContainerFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      owner.sourceContainerFloPanel = sourceContainerFloPanel;

      return sourceContainerFloPanel;
    }

    /**
     * Getter for aggregatorPanelUc called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.uc.DisclosurePanelUc get_aggregatorPanelUc() {
      return build_aggregatorPanelUc();
    }
    private org.ednovo.gooru.client.uc.DisclosurePanelUc build_aggregatorPanelUc() {
      // Creation section.
      final org.ednovo.gooru.client.uc.DisclosurePanelUc aggregatorPanelUc = (org.ednovo.gooru.client.uc.DisclosurePanelUc) GWT.create(org.ednovo.gooru.client.uc.DisclosurePanelUc.class);
      // Setup section.
      aggregatorPanelUc.addWidget(get_aggregatorSgstBox());
      aggregatorPanelUc.addWidget(get_aggregatorHelpicon());
      aggregatorPanelUc.addWidget(get_aggregatorToolTip());
      aggregatorPanelUc.addWidget(get_aggregatorNotFoundLbl());
      aggregatorPanelUc.addWidget(get_aggregatorContainerFloPanel());
      aggregatorPanelUc.setVisible(false);


      owner.aggregatorPanelUc = aggregatorPanelUc;

      return aggregatorPanelUc;
    }

    /**
     * Getter for aggregatorSgstBox called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.uc.AppSuggestBox get_aggregatorSgstBox() {
      return build_aggregatorSgstBox();
    }
    private org.ednovo.gooru.client.uc.AppSuggestBox build_aggregatorSgstBox() {
      // Creation section.
      final org.ednovo.gooru.client.uc.AppSuggestBox aggregatorSgstBox = owner.aggregatorSgstBox;
      assert aggregatorSgstBox != null : "UiField aggregatorSgstBox with 'provided = true' was null";
      // Setup section.
      aggregatorSgstBox.setWidth("130px");


      return aggregatorSgstBox;
    }

    /**
     * Getter for aggregatorHelpicon called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_aggregatorHelpicon() {
      return build_aggregatorHelpicon();
    }
    private com.google.gwt.user.client.ui.Label build_aggregatorHelpicon() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label aggregatorHelpicon = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      aggregatorHelpicon.setStyleName("" + get_style().helpIconBtn() + "");
      aggregatorHelpicon.setVisible(false);
      aggregatorHelpicon.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5);


      owner.aggregatorHelpicon = aggregatorHelpicon;

      return aggregatorHelpicon;
    }

    /**
     * Getter for aggregatorToolTip called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_aggregatorToolTip() {
      return build_aggregatorToolTip();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_aggregatorToolTip() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel aggregatorToolTip = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html4().asString());
      // Setup section.
      aggregatorToolTip.setStyleName("" + get_style().sourceToolTip() + "");
      aggregatorToolTip.setVisible(false);


      owner.aggregatorToolTip = aggregatorToolTip;

      return aggregatorToolTip;
    }

    /**
     * Getter for aggregatorNotFoundLbl called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_aggregatorNotFoundLbl() {
      return build_aggregatorNotFoundLbl();
    }
    private com.google.gwt.user.client.ui.Label build_aggregatorNotFoundLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label aggregatorNotFoundLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      aggregatorNotFoundLbl.setStyleName("" + get_style().notFound() + "");


      owner.aggregatorNotFoundLbl = aggregatorNotFoundLbl;

      return aggregatorNotFoundLbl;
    }

    /**
     * Getter for aggregatorContainerFloPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_aggregatorContainerFloPanel() {
      return build_aggregatorContainerFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_aggregatorContainerFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel aggregatorContainerFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      owner.aggregatorContainerFloPanel = aggregatorContainerFloPanel;

      return aggregatorContainerFloPanel;
    }

    /**
     * Getter for authorPanelUc called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.uc.DisclosurePanelUc get_authorPanelUc() {
      return build_authorPanelUc();
    }
    private org.ednovo.gooru.client.uc.DisclosurePanelUc build_authorPanelUc() {
      // Creation section.
      final org.ednovo.gooru.client.uc.DisclosurePanelUc authorPanelUc = (org.ednovo.gooru.client.uc.DisclosurePanelUc) GWT.create(org.ednovo.gooru.client.uc.DisclosurePanelUc.class);
      // Setup section.
      authorPanelUc.addWidget(get_authorTxtBox());
      authorPanelUc.addWidget(get_authorContainerFloPanel());
      authorPanelUc.setVisible(false);


      owner.authorPanelUc = authorPanelUc;

      return authorPanelUc;
    }

    /**
     * Getter for authorTxtBox called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.TextBox get_authorTxtBox() {
      return build_authorTxtBox();
    }
    private com.google.gwt.user.client.ui.TextBox build_authorTxtBox() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox authorTxtBox = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.
      authorTxtBox.setWidth("130px");


      owner.authorTxtBox = authorTxtBox;

      return authorTxtBox;
    }

    /**
     * Getter for authorContainerFloPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_authorContainerFloPanel() {
      return build_authorContainerFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_authorContainerFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel authorContainerFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      owner.authorContainerFloPanel = authorContainerFloPanel;

      return authorContainerFloPanel;
    }

    /**
     * Getter for standardPanelUc called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.uc.DisclosurePanelUc get_standardPanelUc() {
      return build_standardPanelUc();
    }
    private org.ednovo.gooru.client.uc.DisclosurePanelUc build_standardPanelUc() {
      // Creation section.
      final org.ednovo.gooru.client.uc.DisclosurePanelUc standardPanelUc = (org.ednovo.gooru.client.uc.DisclosurePanelUc) GWT.create(org.ednovo.gooru.client.uc.DisclosurePanelUc.class);
      // Setup section.
      standardPanelUc.addWidget(get_standardSgstBox());
      standardPanelUc.addWidget(get_standardHelpicon());
      standardPanelUc.addWidget(get_standardToolTip());
      standardPanelUc.addWidget(get_standardsNotFoundLbl());
      standardPanelUc.addWidget(get_standardContainerFloPanel());


      owner.standardPanelUc = standardPanelUc;

      return standardPanelUc;
    }

    /**
     * Getter for standardSgstBox called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.uc.AppSuggestBox get_standardSgstBox() {
      return build_standardSgstBox();
    }
    private org.ednovo.gooru.client.uc.AppSuggestBox build_standardSgstBox() {
      // Creation section.
      final org.ednovo.gooru.client.uc.AppSuggestBox standardSgstBox = owner.standardSgstBox;
      assert standardSgstBox != null : "UiField standardSgstBox with 'provided = true' was null";
      // Setup section.
      standardSgstBox.setWidth("130px");


      return standardSgstBox;
    }

    /**
     * Getter for standardHelpicon called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_standardHelpicon() {
      return build_standardHelpicon();
    }
    private com.google.gwt.user.client.ui.Label build_standardHelpicon() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label standardHelpicon = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      standardHelpicon.setStyleName("" + get_style().helpIconBtn() + "");
      standardHelpicon.setVisible(false);
      standardHelpicon.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);


      owner.standardHelpicon = standardHelpicon;

      return standardHelpicon;
    }

    /**
     * Getter for standardToolTip called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_standardToolTip() {
      return build_standardToolTip();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_standardToolTip() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel standardToolTip = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html5().asString());
      // Setup section.
      standardToolTip.setStyleName("" + get_style().sourceToolTip() + "");
      standardToolTip.setVisible(false);


      owner.standardToolTip = standardToolTip;

      return standardToolTip;
    }

    /**
     * Getter for standardsNotFoundLbl called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_standardsNotFoundLbl() {
      return build_standardsNotFoundLbl();
    }
    private com.google.gwt.user.client.ui.Label build_standardsNotFoundLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label standardsNotFoundLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      standardsNotFoundLbl.setStyleName("" + get_style().notFound() + "");


      owner.standardsNotFoundLbl = standardsNotFoundLbl;

      return standardsNotFoundLbl;
    }

    /**
     * Getter for standardContainerFloPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_standardContainerFloPanel() {
      return build_standardContainerFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_standardContainerFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel standardContainerFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      owner.standardContainerFloPanel = standardContainerFloPanel;

      return standardContainerFloPanel;
    }

    /**
     * Getter for subjectPanelUc called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.uc.DisclosurePanelUc get_subjectPanelUc() {
      return build_subjectPanelUc();
    }
    private org.ednovo.gooru.client.uc.DisclosurePanelUc build_subjectPanelUc() {
      // Creation section.
      final org.ednovo.gooru.client.uc.DisclosurePanelUc subjectPanelUc = (org.ednovo.gooru.client.uc.DisclosurePanelUc) GWT.create(org.ednovo.gooru.client.uc.DisclosurePanelUc.class);
      // Setup section.


      owner.subjectPanelUc = subjectPanelUc;

      return subjectPanelUc;
    }

    /**
     * Getter for gradePanelUc called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.uc.DisclosurePanelUc get_gradePanelUc() {
      return build_gradePanelUc();
    }
    private org.ednovo.gooru.client.uc.DisclosurePanelUc build_gradePanelUc() {
      // Creation section.
      final org.ednovo.gooru.client.uc.DisclosurePanelUc gradePanelUc = (org.ednovo.gooru.client.uc.DisclosurePanelUc) GWT.create(org.ednovo.gooru.client.uc.DisclosurePanelUc.class);
      // Setup section.


      owner.gradePanelUc = gradePanelUc;

      return gradePanelUc;
    }

    /**
     * Getter for oerPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_oerPanel() {
      return build_oerPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_oerPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel oerPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.
      oerPanel.setStyleName("" + get_style().oer() + "");


      owner.oerPanel = oerPanel;

      return oerPanel;
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
      f_FlowPanel2.add(get_clearAll());


      return f_FlowPanel2;
    }

    /**
     * Getter for clearAll called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_clearAll() {
      return build_clearAll();
    }
    private com.google.gwt.user.client.ui.Label build_clearAll() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label clearAll = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      clearAll.setStyleName("" + get_style().clearAll() + "");
      clearAll.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6);


      owner.clearAll = clearAll;

      return clearAll;
    }
  }
}
