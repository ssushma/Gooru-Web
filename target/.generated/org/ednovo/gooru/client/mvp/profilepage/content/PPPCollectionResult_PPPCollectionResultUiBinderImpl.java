package org.ednovo.gooru.client.mvp.profilepage.content;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class PPPCollectionResult_PPPCollectionResultUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.profilepage.content.PPPCollectionResult>, org.ednovo.gooru.client.mvp.profilepage.content.PPPCollectionResult.PPPCollectionResultUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.profilepage.content.PPPCollectionResult owner) {


    return new Widgets(owner).get_wrapperVc();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.profilepage.content.PPPCollectionResult owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickCollectionTitle(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.profilepage.content.PPPCollectionResult owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.profilepage.content.PPPCollectionResult_PPPCollectionResultUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.profilepage.content.PPPCollectionResult_PPPCollectionResultUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.profilepage.content.PPPCollectionResult_PPPCollectionResultUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.profilepage.content.PPPCollectionResult_PPPCollectionResultUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.profilepage.content.PPPCollectionResult_PPPCollectionResultUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 8 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.profilepage.content.PPPCollectionResultCBundle res;
    private org.ednovo.gooru.client.mvp.profilepage.content.PPPCollectionResultCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.mvp.profilepage.content.PPPCollectionResultCBundle build_res() {
      // Creation section.
      res = owner.res;
      assert res != null : "UiField res with 'provided = true' was null";
      // Setup section.


      return res;
    }

    /**
     * Getter for wrapperVc called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.profilepage.content.PPPCollectionSearchResultWrapperVc get_wrapperVc() {
      return build_wrapperVc();
    }
    private org.ednovo.gooru.client.mvp.profilepage.content.PPPCollectionSearchResultWrapperVc build_wrapperVc() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.profilepage.content.PPPCollectionSearchResultWrapperVc wrapperVc = owner.wrapperVc;
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
      collectionTitlePanel.add(get_f_FlowPanel3());
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
     * Getter for f_FlowPanel3 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel3() {
      return build_f_FlowPanel3();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel3 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel3.add(get_metaDataPanelFloPanel());
      f_FlowPanel3.add(get_resourceCountLbl());
      f_FlowPanel3.setStyleName("" + get_res().css().metaDataPanel() + "");


      return f_FlowPanel3;
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
