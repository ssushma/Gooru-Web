package org.ednovo.gooru.client.uc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class CollectionImageUc_CollectionImageUcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.uc.CollectionImageUc>, org.ednovo.gooru.client.uc.CollectionImageUc.CollectionImageUcUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.uc.CollectionImageUc owner) {


    return new Widgets(owner).get_collectionThumbnail();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.uc.CollectionImageUc owner;


    public Widgets(final org.ednovo.gooru.client.uc.CollectionImageUc owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.CollectionImageUc_CollectionImageUcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.uc.CollectionImageUc_CollectionImageUcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.uc.CollectionImageUc_CollectionImageUcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.uc.CollectionImageUc_CollectionImageUcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.uc.CollectionImageUc_CollectionImageUcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 2 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.UcCBundle res;
    private org.ednovo.gooru.client.uc.UcCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.uc.UcCBundle build_res() {
      // Creation section.
      res = owner.res;
      assert res != null : "UiField res with 'provided = true' was null";
      // Setup section.


      return res;
    }

    /**
     * Getter for collectionThumbnail called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_collectionThumbnail() {
      return build_collectionThumbnail();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_collectionThumbnail() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel collectionThumbnail = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      collectionThumbnail.add(get_image());
      collectionThumbnail.add(get_collectionGooruOid());
      collectionThumbnail.setStyleName("" + get_res().css().collectionThumbnail() + "");


      owner.collectionThumbnail = collectionThumbnail;

      return collectionThumbnail;
    }

    /**
     * Getter for image called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Image get_image() {
      return build_image();
    }
    private com.google.gwt.user.client.ui.Image build_image() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image image = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      image.setStyleName("" + get_res().css().collectionThumbnails() + "");


      owner.image = image;

      return image;
    }

    /**
     * Getter for collectionGooruOid called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Hidden get_collectionGooruOid() {
      return build_collectionGooruOid();
    }
    private com.google.gwt.user.client.ui.Hidden build_collectionGooruOid() {
      // Creation section.
      final com.google.gwt.user.client.ui.Hidden collectionGooruOid = (com.google.gwt.user.client.ui.Hidden) GWT.create(com.google.gwt.user.client.ui.Hidden.class);
      // Setup section.


      owner.collectionGooruOid = collectionGooruOid;

      return collectionGooruOid;
    }
  }
}
