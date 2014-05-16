package org.ednovo.gooru.client.uc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class AlertContentUc_AlertContentUcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.uc.AlertContentUc>, org.ednovo.gooru.client.uc.AlertContentUc.AlertContentUcUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.uc.AlertContentUc owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.uc.AlertContentUc owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onOkClick(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.uc.AlertContentUc owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.AlertContentUc_AlertContentUcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.uc.AlertContentUc_AlertContentUcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.uc.AlertContentUc_AlertContentUcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.uc.AlertContentUc_AlertContentUcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.uc.AlertContentUc_AlertContentUcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for style called 4 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.AlertContentUc_AlertContentUcUiBinderImpl_GenCss_style style;
    private org.ednovo.gooru.client.uc.AlertContentUc_AlertContentUcUiBinderImpl_GenCss_style get_style() {
      return style;
    }
    private org.ednovo.gooru.client.uc.AlertContentUc_AlertContentUcUiBinderImpl_GenCss_style build_style() {
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
      f_FlowPanel1.add(get_headerPanel());
      f_FlowPanel1.add(get_contentPanel());


      return f_FlowPanel1;
    }

    /**
     * Getter for headerPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_headerPanel() {
      return build_headerPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_headerPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel headerPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      headerPanel.add(get_alertMessageHeaderField());
      headerPanel.setStyleName("" + get_style().title() + "");


      return headerPanel;
    }

    /**
     * Getter for alertMessageHeaderField called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_alertMessageHeaderField() {
      return build_alertMessageHeaderField();
    }
    private com.google.gwt.user.client.ui.Label build_alertMessageHeaderField() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label alertMessageHeaderField = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.alertMessageHeaderField = alertMessageHeaderField;

      return alertMessageHeaderField;
    }

    /**
     * Getter for contentPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_contentPanel() {
      return build_contentPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_contentPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel contentPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      contentPanel.add(get_alertMessageField());
      contentPanel.add(get_f_FlowPanel2());
      contentPanel.setStyleName("" + get_style().content() + "");


      return contentPanel;
    }

    /**
     * Getter for alertMessageField called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_alertMessageField() {
      return build_alertMessageField();
    }
    private com.google.gwt.user.client.ui.Label build_alertMessageField() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label alertMessageField = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      alertMessageField.setStyleName("" + get_style().contentStyle() + "");


      owner.alertMessageField = alertMessageField;

      return alertMessageField;
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
      f_FlowPanel2.add(get_okButton());
      f_FlowPanel2.setStyleName("" + get_style().okButton() + "");


      return f_FlowPanel2;
    }

    /**
     * Getter for okButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Button get_okButton() {
      return build_okButton();
    }
    private com.google.gwt.user.client.ui.Button build_okButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button okButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      okButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.okButton = okButton;

      return okButton;
    }
  }
}
