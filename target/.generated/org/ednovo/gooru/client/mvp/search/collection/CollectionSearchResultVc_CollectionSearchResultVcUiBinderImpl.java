package org.ednovo.gooru.client.mvp.search.collection;

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

public class CollectionSearchResultVc_CollectionSearchResultVcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.search.collection.CollectionSearchResultVc>, org.ednovo.gooru.client.mvp.search.collection.CollectionSearchResultVc.CollectionSearchResultVcUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html2(String arg0, String arg1, String arg2, String arg3);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.search.collection.CollectionSearchResultVc owner) {


    return new Widgets(owner).get_wrapperVc();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.search.collection.CollectionSearchResultVc owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickCollectionTitle(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.search.collection.CollectionSearchResultVc owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2(get_domId0(), get_domId1(), get_domId2(), get_domId3());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.search.collection.CollectionSearchResultVc_CollectionSearchResultVcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.search.collection.CollectionSearchResultVc_CollectionSearchResultVcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.search.collection.CollectionSearchResultVc_CollectionSearchResultVcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.search.collection.CollectionSearchResultVc_CollectionSearchResultVcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.search.collection.CollectionSearchResultVc_CollectionSearchResultVcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 12 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.search.collection.CollectionSearchResultCBundle res;
    private org.ednovo.gooru.client.mvp.search.collection.CollectionSearchResultCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.mvp.search.collection.CollectionSearchResultCBundle build_res() {
      // Creation section.
      res = owner.res;
      assert res != null : "UiField res with 'provided = true' was null";
      // Setup section.


      return res;
    }

    /**
     * Getter for wrapperVc called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.search.collection.CollectionSearchResultWrapperVc get_wrapperVc() {
      return build_wrapperVc();
    }
    private org.ednovo.gooru.client.mvp.search.collection.CollectionSearchResultWrapperVc build_wrapperVc() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.search.collection.CollectionSearchResultWrapperVc wrapperVc = owner.wrapperVc;
      assert wrapperVc != null : "UiField wrapperVc with 'provided = true' was null";
      // Setup section.
      wrapperVc.setContent(get_f_FlowPanel1());


      return wrapperVc;
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
      f_FlowPanel1.add(get_f_FlowPanel2());
      f_FlowPanel1.add(get_collectionDescriptionHtml());
      f_FlowPanel1.setStyleName("" + get_res().css().collectionPanel() + "");


      return f_FlowPanel1;
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
      f_FlowPanel2.add(get_collectionImageUc());
      f_FlowPanel2.add(get_collectionTitlePanel());
      f_FlowPanel2.setStyleName("" + get_res().css().collectionHeaderPanel() + "");


      return f_FlowPanel2;
    }

    /**
     * Getter for collectionImageUc called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.CollectionImageUc get_collectionImageUc() {
      return build_collectionImageUc();
    }
    private org.ednovo.gooru.client.uc.CollectionImageUc build_collectionImageUc() {
      // Creation section.
      final org.ednovo.gooru.client.uc.CollectionImageUc collectionImageUc = (org.ednovo.gooru.client.uc.CollectionImageUc) GWT.create(org.ednovo.gooru.client.uc.CollectionImageUc.class);
      // Setup section.


      owner.collectionImageUc = collectionImageUc;

      return collectionImageUc;
    }

    /**
     * Getter for collectionTitlePanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_collectionTitlePanel() {
      return build_collectionTitlePanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_collectionTitlePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel collectionTitlePanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      collectionTitlePanel.add(get_collectionTitleLbl());
      collectionTitlePanel.add(get_f_HTMLPanel3());
      collectionTitlePanel.add(get_f_FlowPanel4());
      collectionTitlePanel.add(get_standardsFloPanel());
      collectionTitlePanel.setStyleName("" + get_res().css().collectionHeaderTextPanel() + "");


      return collectionTitlePanel;
    }

    /**
     * Getter for collectionTitleLbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTML get_collectionTitleLbl() {
      return build_collectionTitleLbl();
    }
    private com.google.gwt.user.client.ui.HTML build_collectionTitleLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML collectionTitleLbl = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      collectionTitleLbl.setStyleName("" + get_res().css().collectionTitle() + "");
      collectionTitleLbl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.collectionTitleLbl = collectionTitleLbl;

      return collectionTitleLbl;
    }

    /**
     * Getter for f_HTMLPanel3 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel3() {
      return build_f_HTMLPanel3();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      f_HTMLPanel3.setStyleName("" + get_res().css().authorContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord861 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
      get_domId0Element().get();
      get_domId1Element().get();
      get_domId2Element().get();
      get_domId3Element().get();

      // Detach section.
      attachRecord861.detach();
      f_HTMLPanel3.addAndReplaceElement(get_creatorNameLbl(), get_domId0Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_creatorNameLblValue(), get_domId1Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_teamFlowPanel(), get_domId2Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_containerPanel(), get_domId3Element().get());

      return f_HTMLPanel3;
    }

    /**
     * Getter for domId0 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId0;
    private java.lang.String get_domId0() {
      return domId0;
    }
    private java.lang.String build_domId0() {
      // Creation section.
      domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId0;
    }

    /**
     * Getter for creatorNameLbl called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_creatorNameLbl() {
      return build_creatorNameLbl();
    }
    private com.google.gwt.user.client.ui.Label build_creatorNameLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label creatorNameLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      creatorNameLbl.setStyleName("" + get_res().css().author() + "");


      owner.creatorNameLbl = creatorNameLbl;

      return creatorNameLbl;
    }

    /**
     * Getter for domId0Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId0Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId0Element() {
      return domId0Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId0Element() {
      // Creation section.
      domId0Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId0());
      // Setup section.


      return domId0Element;
    }

    /**
     * Getter for domId1 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId1;
    private java.lang.String get_domId1() {
      return domId1;
    }
    private java.lang.String build_domId1() {
      // Creation section.
      domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId1;
    }

    /**
     * Getter for creatorNameLblValue called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_creatorNameLblValue() {
      return build_creatorNameLblValue();
    }
    private com.google.gwt.user.client.ui.Label build_creatorNameLblValue() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label creatorNameLblValue = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      creatorNameLblValue.setStyleName("" + get_res().css().authorName() + "");


      owner.creatorNameLblValue = creatorNameLblValue;

      return creatorNameLblValue;
    }

    /**
     * Getter for domId1Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId1Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId1Element() {
      return domId1Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId1Element() {
      // Creation section.
      domId1Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId1());
      // Setup section.


      return domId1Element;
    }

    /**
     * Getter for domId2 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId2;
    private java.lang.String get_domId2() {
      return domId2;
    }
    private java.lang.String build_domId2() {
      // Creation section.
      domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId2;
    }

    /**
     * Getter for teamFlowPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_teamFlowPanel() {
      return build_teamFlowPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_teamFlowPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel teamFlowPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      teamFlowPanel.setStyleName("" + get_res().css().collaboratorStyle() + "");


      owner.teamFlowPanel = teamFlowPanel;

      return teamFlowPanel;
    }

    /**
     * Getter for domId2Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId2Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId2Element() {
      return domId2Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId2Element() {
      // Creation section.
      domId2Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId2());
      // Setup section.


      return domId2Element;
    }

    /**
     * Getter for domId3 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId3;
    private java.lang.String get_domId3() {
      return domId3;
    }
    private java.lang.String build_domId3() {
      // Creation section.
      domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId3;
    }

    /**
     * Getter for containerPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_containerPanel() {
      return build_containerPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_containerPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel containerPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.


      owner.containerPanel = containerPanel;

      return containerPanel;
    }

    /**
     * Getter for domId3Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId3Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId3Element() {
      return domId3Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId3Element() {
      // Creation section.
      domId3Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId3());
      // Setup section.


      return domId3Element;
    }

    /**
     * Getter for f_FlowPanel4 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel4() {
      return build_f_FlowPanel4();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel4 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel4.add(get_metaDataPanelFloPanel());
      f_FlowPanel4.add(get_resourceCountLbl());
      f_FlowPanel4.setStyleName("" + get_res().css().metaDataPanel() + "");


      return f_FlowPanel4;
    }

    /**
     * Getter for metaDataPanelFloPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_metaDataPanelFloPanel() {
      return build_metaDataPanelFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_metaDataPanelFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel metaDataPanelFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      owner.metaDataPanelFloPanel = metaDataPanelFloPanel;

      return metaDataPanelFloPanel;
    }

    /**
     * Getter for resourceCountLbl called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_resourceCountLbl() {
      return build_resourceCountLbl();
    }
    private com.google.gwt.user.client.ui.Label build_resourceCountLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label resourceCountLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      resourceCountLbl.setStyleName("" + get_res().css().resourceCount() + "");


      owner.resourceCountLbl = resourceCountLbl;

      return resourceCountLbl;
    }

    /**
     * Getter for standardsFloPanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_standardsFloPanel() {
      return build_standardsFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_standardsFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel standardsFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      standardsFloPanel.setStyleName("" + get_res().css().standards() + "");


      owner.standardsFloPanel = standardsFloPanel;

      return standardsFloPanel;
    }

    /**
     * Getter for collectionDescriptionHtml called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTML get_collectionDescriptionHtml() {
      return build_collectionDescriptionHtml();
    }
    private com.google.gwt.user.client.ui.HTML build_collectionDescriptionHtml() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML collectionDescriptionHtml = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      collectionDescriptionHtml.setStyleName("" + get_res().css().collectionDescription() + "");


      owner.collectionDescriptionHtml = collectionDescriptionHtml;

      return collectionDescriptionHtml;
    }
  }
}
