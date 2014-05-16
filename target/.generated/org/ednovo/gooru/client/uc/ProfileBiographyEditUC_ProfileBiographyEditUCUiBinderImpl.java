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

public class ProfileBiographyEditUC_ProfileBiographyEditUCUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.uc.ProfileBiographyEditUC>, org.ednovo.gooru.client.uc.ProfileBiographyEditUC.ProfileBiographyEditUCUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.uc.ProfileBiographyEditUC owner) {


    return new Widgets(owner).get_focusPanel();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.uc.ProfileBiographyEditUC owner;


    public Widgets(final org.ednovo.gooru.client.uc.ProfileBiographyEditUC owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
    }

    SafeHtml template_html1() {
      return template.html1();
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.ProfileBiographyEditUC_ProfileBiographyEditUCUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.uc.ProfileBiographyEditUC_ProfileBiographyEditUCUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.uc.ProfileBiographyEditUC_ProfileBiographyEditUCUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.uc.ProfileBiographyEditUC_ProfileBiographyEditUCUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.uc.ProfileBiographyEditUC_ProfileBiographyEditUCUiBinderImpl_GenBundle.class);
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
     * Getter for focusPanel called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FocusPanel get_focusPanel() {
      return build_focusPanel();
    }
    private com.google.gwt.user.client.ui.FocusPanel build_focusPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FocusPanel focusPanel = (com.google.gwt.user.client.ui.FocusPanel) GWT.create(com.google.gwt.user.client.ui.FocusPanel.class);
      // Setup section.
      focusPanel.add(get_deckPanel());
      focusPanel.setStyleName("{res.css.editableFieldProfile");


      owner.focusPanel = focusPanel;

      return focusPanel;
    }

    /**
     * Getter for deckPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.DeckPanel get_deckPanel() {
      return build_deckPanel();
    }
    private com.google.gwt.user.client.ui.DeckPanel build_deckPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.DeckPanel deckPanel = (com.google.gwt.user.client.ui.DeckPanel) GWT.create(com.google.gwt.user.client.ui.DeckPanel.class);
      // Setup section.
      deckPanel.add(get_editLabel());
      deckPanel.add(get_editTextBox());


      owner.deckPanel = deckPanel;

      return deckPanel;
    }

    /**
     * Getter for editLabel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_editLabel() {
      return build_editLabel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_editLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel editLabel = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      editLabel.setStyleName("" + get_res().css().editableFieldProfile() + "");


      owner.editLabel = editLabel;

      return editLabel;
    }

    /**
     * Getter for editTextBox called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.TextArea get_editTextBox() {
      return build_editTextBox();
    }
    private com.google.gwt.user.client.ui.TextArea build_editTextBox() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextArea editTextBox = (com.google.gwt.user.client.ui.TextArea) GWT.create(com.google.gwt.user.client.ui.TextArea.class);
      // Setup section.
      editTextBox.setStyleName("" + get_res().css().publicProfileTextarea() + "");


      owner.editTextBox = editTextBox;

      return editTextBox;
    }
  }
}
