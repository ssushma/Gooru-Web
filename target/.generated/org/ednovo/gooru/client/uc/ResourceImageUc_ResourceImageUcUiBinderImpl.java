package org.ednovo.gooru.client.uc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class ResourceImageUc_ResourceImageUcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.uc.ResourceImageUc>, org.ednovo.gooru.client.uc.ResourceImageUc.ResourceImageUcUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.uc.ResourceImageUc owner) {


    return new Widgets(owner).get_resourceThumbnail();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.uc.ResourceImageUc owner;


    public Widgets(final org.ednovo.gooru.client.uc.ResourceImageUc owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.ResourceImageUc_ResourceImageUcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.uc.ResourceImageUc_ResourceImageUcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.uc.ResourceImageUc_ResourceImageUcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.uc.ResourceImageUc_ResourceImageUcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.uc.ResourceImageUc_ResourceImageUcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 3 times. Type: IMPORTED. Build precedence: 1.
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
     * Getter for resourceThumbnail called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_resourceThumbnail() {
      return build_resourceThumbnail();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_resourceThumbnail() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel resourceThumbnail = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      resourceThumbnail.add(get_image());
      resourceThumbnail.add(get_resourceType());
      resourceThumbnail.setStyleName("" + get_res().css().resourceThumbnail() + "");


      owner.resourceThumbnail = resourceThumbnail;

      return resourceThumbnail;
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
      image.setStyleName("" + get_res().css().resourceThumbnails() + "");


      owner.image = image;

      return image;
    }

    /**
     * Getter for resourceType called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_resourceType() {
      return build_resourceType();
    }
    private com.google.gwt.user.client.ui.Label build_resourceType() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label resourceType = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      resourceType.setStyleName("" + get_res().css().resourceName() + "");


      owner.resourceType = resourceType;

      return resourceType;
    }
  }
}
