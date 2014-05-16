package org.ednovo.gooru.client.uc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class PreviewResourceView_TocResourceViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.uc.PreviewResourceView>, org.ednovo.gooru.client.uc.PreviewResourceView.TocResourceViewUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.uc.PreviewResourceView owner) {


    return new Widgets(owner).get_resourceThumbContainer();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.uc.PreviewResourceView owner;


    final com.google.gwt.event.dom.client.ErrorHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ErrorHandler() {
      public void onError(com.google.gwt.event.dom.client.ErrorEvent event) {
        owner.onErrorResourceImage(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.uc.PreviewResourceView owner) {
      this.owner = owner;
      build_playerStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.PreviewResourceView_TocResourceViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.uc.PreviewResourceView_TocResourceViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.uc.PreviewResourceView_TocResourceViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.uc.PreviewResourceView_TocResourceViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.uc.PreviewResourceView_TocResourceViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for playerStyle called 13 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle playerStyle;
    private org.ednovo.gooru.client.uc.PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle get_playerStyle() {
      return playerStyle;
    }
    private org.ednovo.gooru.client.uc.PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle build_playerStyle() {
      // Creation section.
      playerStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().playerStyle();
      // Setup section.
      playerStyle.ensureInjected();


      return playerStyle;
    }

    /**
     * Getter for resourceThumbContainer called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_resourceThumbContainer() {
      return build_resourceThumbContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_resourceThumbContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel resourceThumbContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      resourceThumbContainer.add(get_resourceImageContainer());
      resourceThumbContainer.add(get_f_FlowPanel2());
      resourceThumbContainer.setStyleName("" + get_playerStyle().resourceContainer() + "");


      owner.resourceThumbContainer = resourceThumbContainer;

      return resourceThumbContainer;
    }

    /**
     * Getter for resourceImageContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_resourceImageContainer() {
      return build_resourceImageContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_resourceImageContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel resourceImageContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      resourceImageContainer.add(get_f_FlowPanel1());
      resourceImageContainer.add(get_resourceNumber());
      resourceImageContainer.add(get_resourceTitle());
      resourceImageContainer.setStyleName("" + get_playerStyle().resourceBlock() + "");


      owner.resourceImageContainer = resourceImageContainer;

      return resourceImageContainer;
    }

    /**
     * Getter for f_FlowPanel1 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel1() {
      return build_f_FlowPanel1();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel1 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel1.add(get_resourceThumbnail());
      f_FlowPanel1.add(get_resourceTypeImage());
      f_FlowPanel1.setStyleName("" + get_playerStyle().resourceThumbnail() + "");


      return f_FlowPanel1;
    }

    /**
     * Getter for resourceThumbnail called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Image get_resourceThumbnail() {
      return build_resourceThumbnail();
    }
    private com.google.gwt.user.client.ui.Image build_resourceThumbnail() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image resourceThumbnail = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      resourceThumbnail.setStyleName("" + get_playerStyle().resourceImage() + "");
      resourceThumbnail.addErrorHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.resourceThumbnail = resourceThumbnail;

      return resourceThumbnail;
    }

    /**
     * Getter for resourceTypeImage called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_resourceTypeImage() {
      return build_resourceTypeImage();
    }
    private com.google.gwt.user.client.ui.Label build_resourceTypeImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label resourceTypeImage = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      resourceTypeImage.setStyleName("" + get_playerStyle().resourceType() + "");


      owner.resourceTypeImage = resourceTypeImage;

      return resourceTypeImage;
    }

    /**
     * Getter for resourceNumber called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_resourceNumber() {
      return build_resourceNumber();
    }
    private com.google.gwt.user.client.ui.Label build_resourceNumber() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label resourceNumber = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      resourceNumber.setStyleName("" + get_playerStyle().number() + "");


      owner.resourceNumber = resourceNumber;

      return resourceNumber;
    }

    /**
     * Getter for resourceTitle called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTML get_resourceTitle() {
      return build_resourceTitle();
    }
    private com.google.gwt.user.client.ui.HTML build_resourceTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML resourceTitle = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      resourceTitle.setStyleName("" + get_playerStyle().restitle() + " navigationText");


      owner.resourceTitle = resourceTitle;

      return resourceTitle;
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
      f_FlowPanel2.add(get_resourceIndex());
      f_FlowPanel2.add(get_f_FlowPanel3());
      f_FlowPanel2.setStyleName("" + get_playerStyle().toolTip() + "");


      return f_FlowPanel2;
    }

    /**
     * Getter for resourceIndex called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_resourceIndex() {
      return build_resourceIndex();
    }
    private com.google.gwt.user.client.ui.Label build_resourceIndex() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label resourceIndex = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      resourceIndex.setStyleName("" + get_playerStyle().resourceNumber() + "");


      owner.resourceIndex = resourceIndex;

      return resourceIndex;
    }

    /**
     * Getter for f_FlowPanel3 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel3() {
      return build_f_FlowPanel3();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel3 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel3.add(get_resourceHoverTitle());
      f_FlowPanel3.add(get_resourceCategory());
      f_FlowPanel3.add(get_resourceSourceName());
      f_FlowPanel3.setStyleName("" + get_playerStyle().resourceInfo() + "");


      return f_FlowPanel3;
    }

    /**
     * Getter for resourceHoverTitle called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTML get_resourceHoverTitle() {
      return build_resourceHoverTitle();
    }
    private com.google.gwt.user.client.ui.HTML build_resourceHoverTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML resourceHoverTitle = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      resourceHoverTitle.setStyleName("" + get_playerStyle().title() + " navigationText");


      owner.resourceHoverTitle = resourceHoverTitle;

      return resourceHoverTitle;
    }

    /**
     * Getter for resourceCategory called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_resourceCategory() {
      return build_resourceCategory();
    }
    private com.google.gwt.user.client.ui.Label build_resourceCategory() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label resourceCategory = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      resourceCategory.setStyleName("" + get_playerStyle().type() + "");


      owner.resourceCategory = resourceCategory;

      return resourceCategory;
    }

    /**
     * Getter for resourceSourceName called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_resourceSourceName() {
      return build_resourceSourceName();
    }
    private com.google.gwt.user.client.ui.Label build_resourceSourceName() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label resourceSourceName = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      resourceSourceName.setStyleName("" + get_playerStyle().source() + "");


      owner.resourceSourceName = resourceSourceName;

      return resourceSourceName;
    }
  }
}
