package org.ednovo.gooru.client.mvp.home;

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

public class LogoutPopupVc_LogoutPopupVcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.home.LogoutPopupVc>, org.ednovo.gooru.client.mvp.home.LogoutPopupVc.LogoutPopupVcUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span>")
    SafeHtml html1(String arg0);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.home.LogoutPopupVc owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.home.LogoutPopupVc owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onCancelClick(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.userLogout(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.home.LogoutPopupVc owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1(get_domId0());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.LogoutPopupVc_LogoutPopupVcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.home.LogoutPopupVc_LogoutPopupVcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.home.LogoutPopupVc_LogoutPopupVcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.home.LogoutPopupVc_LogoutPopupVcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.home.LogoutPopupVc_LogoutPopupVcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 3 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.HomeCBundle res;
    private org.ednovo.gooru.client.mvp.home.HomeCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.mvp.home.HomeCBundle build_res() {
      // Creation section.
      res = (org.ednovo.gooru.client.mvp.home.HomeCBundle) GWT.create(org.ednovo.gooru.client.mvp.home.HomeCBundle.class);
      // Setup section.


      return res;
    }

    /**
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord514 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId0Element().get();

      // Detach section.
      attachRecord514.detach();
      f_HTMLPanel1.addAndReplaceElement(get_f_FlowPanel2(), get_domId0Element().get());

      return f_HTMLPanel1;
    }

    /**
     * Getter for domId0 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
     */
    private java.lang.String domId0;
    private java.lang.String get_domId0() {
      return domId0;
    }
    private java.lang.String build_domId0() {
      // Creation section.
      domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId0;
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
      f_FlowPanel2.add(get_f_FlowPanel3());
      f_FlowPanel2.add(get_buttonContainer());
      f_FlowPanel2.setStyleName("" + get_res().css().removePopupContainer() + "");
      f_FlowPanel2.setHeight("100px");


      return f_FlowPanel2;
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
      f_FlowPanel3.add(get_lblClassDismissed());
      f_FlowPanel3.setStyleName("" + get_res().css().removeText() + "");


      return f_FlowPanel3;
    }

    /**
     * Getter for lblClassDismissed called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_lblClassDismissed() {
      return build_lblClassDismissed();
    }
    private com.google.gwt.user.client.ui.Label build_lblClassDismissed() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblClassDismissed = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.lblClassDismissed = lblClassDismissed;

      return lblClassDismissed;
    }

    /**
     * Getter for buttonContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_buttonContainer() {
      return build_buttonContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_buttonContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel buttonContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      buttonContainer.add(get_okBtnUc());
      buttonContainer.add(get_cancelAnr());
      buttonContainer.setStyleName("" + get_res().css().actionField() + "");


      return buttonContainer;
    }

    /**
     * Getter for okBtnUc called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.BlueButtonUc get_okBtnUc() {
      return build_okBtnUc();
    }
    private org.ednovo.gooru.client.uc.BlueButtonUc build_okBtnUc() {
      // Creation section.
      final org.ednovo.gooru.client.uc.BlueButtonUc okBtnUc = (org.ednovo.gooru.client.uc.BlueButtonUc) GWT.create(org.ednovo.gooru.client.uc.BlueButtonUc.class);
      // Setup section.
      okBtnUc.setStyleName("overRideBlueButton");
      okBtnUc.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.okBtnUc = okBtnUc;

      return okBtnUc;
    }

    /**
     * Getter for cancelAnr called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Anchor get_cancelAnr() {
      return build_cancelAnr();
    }
    private com.google.gwt.user.client.ui.Anchor build_cancelAnr() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor cancelAnr = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      cancelAnr.setStyleName("collectionFormCancelButton");
      cancelAnr.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.cancelAnr = cancelAnr;

      return cancelAnr;
    }

    /**
     * Getter for domId0Element called 2 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId0Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId0Element() {
      return domId0Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId0Element() {
      // Creation section.
      domId0Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId0());
      // Setup section.


      return domId0Element;
    }
  }
}
