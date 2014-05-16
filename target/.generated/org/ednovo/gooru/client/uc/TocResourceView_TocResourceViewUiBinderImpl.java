package org.ednovo.gooru.client.uc;

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

public class TocResourceView_TocResourceViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.uc.TocResourceView>, org.ednovo.gooru.client.uc.TocResourceView.TocResourceViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.uc.TocResourceView owner) {


    return new Widgets(owner).get_tocResourceContainer();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.uc.TocResourceView owner;


    final com.google.gwt.event.dom.client.ErrorHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ErrorHandler() {
      public void onError(com.google.gwt.event.dom.client.ErrorEvent event) {
        owner.onErrorResourceImage(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.uc.TocResourceView owner) {
      this.owner = owner;
      build_playerStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
    }

    SafeHtml template_html1() {
      return template.html1();
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.TocResourceView_TocResourceViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.uc.TocResourceView_TocResourceViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.uc.TocResourceView_TocResourceViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.uc.TocResourceView_TocResourceViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.uc.TocResourceView_TocResourceViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for playerStyle called 5 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.TocResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle playerStyle;
    private org.ednovo.gooru.client.uc.TocResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle get_playerStyle() {
      return playerStyle;
    }
    private org.ednovo.gooru.client.uc.TocResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle build_playerStyle() {
      // Creation section.
      playerStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().playerStyle();
      // Setup section.
      playerStyle.ensureInjected();


      return playerStyle;
    }

    /**
     * Getter for tocResourceContainer called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_tocResourceContainer() {
      return build_tocResourceContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_tocResourceContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel tocResourceContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      tocResourceContainer.add(get_tocResourceImageContainer());
      tocResourceContainer.setStyleName("" + get_playerStyle().resourceContainer() + "");


      owner.tocResourceContainer = tocResourceContainer;

      return tocResourceContainer;
    }

    /**
     * Getter for tocResourceImageContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_tocResourceImageContainer() {
      return build_tocResourceImageContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_tocResourceImageContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel tocResourceImageContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      tocResourceImageContainer.add(get_f_FlowPanel1());
      tocResourceImageContainer.add(get_resourceTitle());


      owner.tocResourceImageContainer = tocResourceImageContainer;

      return tocResourceImageContainer;
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
     * Getter for resourceTitle called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_resourceTitle() {
      return build_resourceTitle();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_resourceTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel resourceTitle = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      resourceTitle.setStyleName("" + get_playerStyle().navResourceTitle() + "");


      owner.resourceTitle = resourceTitle;

      return resourceTitle;
    }
  }
}
