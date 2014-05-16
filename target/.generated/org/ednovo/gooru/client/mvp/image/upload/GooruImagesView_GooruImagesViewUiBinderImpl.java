package org.ednovo.gooru.client.mvp.image.upload;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class GooruImagesView_GooruImagesViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.image.upload.GooruImagesView>, org.ednovo.gooru.client.mvp.image.upload.GooruImagesView.GooruImagesViewUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.image.upload.GooruImagesView owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.image.upload.GooruImagesView owner;


    public Widgets(final org.ednovo.gooru.client.mvp.image.upload.GooruImagesView owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.image.upload.GooruImagesView_GooruImagesViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.image.upload.GooruImagesView_GooruImagesViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.image.upload.GooruImagesView_GooruImagesViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.image.upload.GooruImagesView_GooruImagesViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.image.upload.GooruImagesView_GooruImagesViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for style called 4 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.image.upload.GooruImagesView_GooruImagesViewUiBinderImpl_GenCss_style style;
    private org.ednovo.gooru.client.mvp.image.upload.GooruImagesView_GooruImagesViewUiBinderImpl_GenCss_style get_style() {
      return style;
    }
    private org.ednovo.gooru.client.mvp.image.upload.GooruImagesView_GooruImagesViewUiBinderImpl_GenCss_style build_style() {
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
      f_FlowPanel1.add(get_profileGooruDefaultImage());
      f_FlowPanel1.setStyleName("" + get_style().imageMainContainer() + "");


      return f_FlowPanel1;
    }

    /**
     * Getter for profileGooruDefaultImage called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_profileGooruDefaultImage() {
      return build_profileGooruDefaultImage();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_profileGooruDefaultImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel profileGooruDefaultImage = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      profileGooruDefaultImage.add(get_f_FlowPanel2());
      profileGooruDefaultImage.setStyleName("" + get_style().imageContainer() + "");


      owner.profileGooruDefaultImage = profileGooruDefaultImage;

      return profileGooruDefaultImage;
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
      f_FlowPanel2.add(get_gooruDefaultImage());
      f_FlowPanel2.setStyleName("" + get_style().chooseImage() + "");


      return f_FlowPanel2;
    }

    /**
     * Getter for gooruDefaultImage called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Image get_gooruDefaultImage() {
      return build_gooruDefaultImage();
    }
    private com.google.gwt.user.client.ui.Image build_gooruDefaultImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image gooruDefaultImage = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      gooruDefaultImage.setStyleName("" + get_style().imageHolder() + "");


      owner.gooruDefaultImage = gooruDefaultImage;

      return gooruDefaultImage;
    }
  }
}
