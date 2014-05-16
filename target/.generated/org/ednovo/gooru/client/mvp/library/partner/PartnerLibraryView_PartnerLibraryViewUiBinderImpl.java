package org.ednovo.gooru.client.mvp.library.partner;

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

public class PartnerLibraryView_PartnerLibraryViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryView>, org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryView.PartnerLibraryViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryView owner) {


    return new Widgets(owner).get_partnerPanel();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryView owner;


    public Widgets(final org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryView owner) {
      this.owner = owner;
      build_libraryStyleUc();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
    }

    SafeHtml template_html1() {
      return template.html1();
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryView_PartnerLibraryViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryView_PartnerLibraryViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryView_PartnerLibraryViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryView_PartnerLibraryViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryView_PartnerLibraryViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for libraryStyleUc called 0 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryView_PartnerLibraryViewUiBinderImpl_GenCss_libraryStyleUc get_libraryStyleUc() {
      return build_libraryStyleUc();
    }
    private org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryView_PartnerLibraryViewUiBinderImpl_GenCss_libraryStyleUc build_libraryStyleUc() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryView_PartnerLibraryViewUiBinderImpl_GenCss_libraryStyleUc libraryStyleUc = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().libraryStyleUc();
      // Setup section.
      libraryStyleUc.ensureInjected();


      owner.libraryStyleUc = libraryStyleUc;

      return libraryStyleUc;
    }

    /**
     * Getter for partnerPanel called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_partnerPanel() {
      return build_partnerPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_partnerPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel partnerPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.


      owner.partnerPanel = partnerPanel;

      return partnerPanel;
    }
  }
}
