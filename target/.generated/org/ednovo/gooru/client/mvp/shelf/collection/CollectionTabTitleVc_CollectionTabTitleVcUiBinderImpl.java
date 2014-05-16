package org.ednovo.gooru.client.mvp.shelf.collection;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class CollectionTabTitleVc_CollectionTabTitleVcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc>, org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc.CollectionTabTitleVcUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc owner) {


    return new Widgets(owner).get_wrapperFloPanel();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc owner;


    public Widgets(final org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc_CollectionTabTitleVcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc_CollectionTabTitleVcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc_CollectionTabTitleVcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc_CollectionTabTitleVcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc_CollectionTabTitleVcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 3 times. Type: IMPORTED. Build precedence: 1.
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
     * Getter for wrapperFloPanel called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_wrapperFloPanel() {
      return build_wrapperFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_wrapperFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel wrapperFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      wrapperFloPanel.add(get_imageSimPanel());
      wrapperFloPanel.add(get_labelLbl());
      wrapperFloPanel.setStyleName("" + get_res().css().collectionMetaDataTabTitle() + "");


      owner.wrapperFloPanel = wrapperFloPanel;

      return wrapperFloPanel;
    }

    /**
     * Getter for imageSimPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_imageSimPanel() {
      return build_imageSimPanel();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_imageSimPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel imageSimPanel = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.
      imageSimPanel.setStyleName("" + get_res().css().userCollectionMetaAssignImage() + "");


      owner.imageSimPanel = imageSimPanel;

      return imageSimPanel;
    }

    /**
     * Getter for labelLbl called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_labelLbl() {
      return build_labelLbl();
    }
    private com.google.gwt.user.client.ui.Label build_labelLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label labelLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      labelLbl.setStyleName("" + get_res().css().userCollectionMetaShelfFtLft() + "");


      owner.labelLbl = labelLbl;

      return labelLbl;
    }
  }
}
