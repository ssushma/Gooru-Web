package org.ednovo.gooru.client.mvp.classpages.assignments;

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

public class SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.classpages.assignments.SuccessMessagePopupView>, org.ednovo.gooru.client.mvp.classpages.assignments.SuccessMessagePopupView.SuccessMessagePopupViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span>")
    SafeHtml html1(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html2(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html3(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html4(String arg0, String arg1);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.classpages.assignments.SuccessMessagePopupView owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.classpages.assignments.SuccessMessagePopupView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.closePopupEvent(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.classpages.assignments.SuccessMessagePopupView owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
    }

    SafeHtml template_html1() {
      return template.html1(get_domId0());
    }
    SafeHtml template_html2() {
      return template.html2(get_domId2(), get_domId3());
    }
    SafeHtml template_html3() {
      return template.html3(get_domId5());
    }
    SafeHtml template_html4() {
      return template.html4(get_domId1(), get_domId4());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.classpages.assignments.SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.classpages.assignments.SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.classpages.assignments.SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.classpages.assignments.SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.classpages.assignments.SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for style called 8 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.classpages.assignments.SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style style;
    private org.ednovo.gooru.client.mvp.classpages.assignments.SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style get_style() {
      return style;
    }
    private org.ednovo.gooru.client.mvp.classpages.assignments.SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style build_style() {
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
      f_FlowPanel1.add(get_f_HTMLPanel2());
      f_FlowPanel1.add(get_f_HTMLPanel3());
      f_FlowPanel1.setStyleName("" + get_style().popupContent() + "");


      return f_FlowPanel1;
    }

    /**
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_style().popupHeader() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1318 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_domId0Element().get();

      // Detach section.
      attachRecord1318.detach();
      f_HTMLPanel2.addAndReplaceElement(get_successPopupHeader(), get_domId0Element().get());

      return f_HTMLPanel2;
    }

    /**
     * Getter for domId0 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for successPopupHeader called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_successPopupHeader() {
      return build_successPopupHeader();
    }
    private com.google.gwt.user.client.ui.Label build_successPopupHeader() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label successPopupHeader = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      successPopupHeader.setStyleName("" + get_style().popupHeaderText() + "");


      owner.successPopupHeader = successPopupHeader;

      return successPopupHeader;
    }

    /**
     * Getter for domId0Element called 2 times. Type: DEFAULT. Build precedence: 3.
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

    /**
     * Getter for f_HTMLPanel3 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel3() {
      return build_f_HTMLPanel3();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      f_HTMLPanel3.setStyleName("" + get_style().assignmentSuccessMainContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1319 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
      get_domId1Element().get();
      get_domId4Element().get();

      // Detach section.
      attachRecord1319.detach();
      f_HTMLPanel3.addAndReplaceElement(get_f_HTMLPanel4(), get_domId1Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_f_HTMLPanel6(), get_domId4Element().get());

      return f_HTMLPanel3;
    }

    /**
     * Getter for domId1 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId1;
    private java.lang.String get_domId1() {
      return domId1;
    }
    private java.lang.String build_domId1() {
      // Creation section.
      domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId1;
    }

    /**
     * Getter for f_HTMLPanel4 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel4() {
      return build_f_HTMLPanel4();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel4 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      f_HTMLPanel4.setStyleName("" + get_style().assignmentContentContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1320 = UiBinderUtil.attachToDom(f_HTMLPanel4.getElement());
      get_domId2Element().get();
      get_domId3Element().get();

      // Detach section.
      attachRecord1320.detach();
      f_HTMLPanel4.addAndReplaceElement(get_f_Label5(), get_domId2Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_successPopupBodyText(), get_domId3Element().get());

      return f_HTMLPanel4;
    }

    /**
     * Getter for domId2 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId2;
    private java.lang.String get_domId2() {
      return domId2;
    }
    private java.lang.String build_domId2() {
      // Creation section.
      domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId2;
    }

    /**
     * Getter for f_Label5 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label5() {
      return build_f_Label5();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label5() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label5 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label5.setStyleName("" + get_style().successImage() + "");


      return f_Label5;
    }

    /**
     * Getter for domId2Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId2Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId2Element() {
      return domId2Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId2Element() {
      // Creation section.
      domId2Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId2());
      // Setup section.


      return domId2Element;
    }

    /**
     * Getter for domId3 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId3;
    private java.lang.String get_domId3() {
      return domId3;
    }
    private java.lang.String build_domId3() {
      // Creation section.
      domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId3;
    }

    /**
     * Getter for successPopupBodyText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTML get_successPopupBodyText() {
      return build_successPopupBodyText();
    }
    private com.google.gwt.user.client.ui.HTML build_successPopupBodyText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML successPopupBodyText = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      successPopupBodyText.setStyleName("" + get_style().successText() + "");


      owner.successPopupBodyText = successPopupBodyText;

      return successPopupBodyText;
    }

    /**
     * Getter for domId3Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId3Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId3Element() {
      return domId3Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId3Element() {
      // Creation section.
      domId3Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId3());
      // Setup section.


      return domId3Element;
    }

    /**
     * Getter for domId1Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId1Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId1Element() {
      return domId1Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId1Element() {
      // Creation section.
      domId1Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId1());
      // Setup section.


      return domId1Element;
    }

    /**
     * Getter for domId4 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId4;
    private java.lang.String get_domId4() {
      return domId4;
    }
    private java.lang.String build_domId4() {
      // Creation section.
      domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId4;
    }

    /**
     * Getter for f_HTMLPanel6 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel6() {
      return build_f_HTMLPanel6();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel6() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel6 = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      f_HTMLPanel6.setStyleName("" + get_style().assignmentButtonsContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1321 = UiBinderUtil.attachToDom(f_HTMLPanel6.getElement());
      get_domId5Element().get();

      // Detach section.
      attachRecord1321.detach();
      f_HTMLPanel6.addAndReplaceElement(get_okayButton(), get_domId5Element().get());

      return f_HTMLPanel6;
    }

    /**
     * Getter for domId5 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId5;
    private java.lang.String get_domId5() {
      return domId5;
    }
    private java.lang.String build_domId5() {
      // Creation section.
      domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId5;
    }

    /**
     * Getter for okayButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Button get_okayButton() {
      return build_okayButton();
    }
    private com.google.gwt.user.client.ui.Button build_okayButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button okayButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      okayButton.setStyleName("primary");
      okayButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.okayButton = okayButton;

      return okayButton;
    }

    /**
     * Getter for domId5Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId5Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId5Element() {
      return domId5Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId5Element() {
      // Creation section.
      domId5Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId5());
      // Setup section.


      return domId5Element;
    }

    /**
     * Getter for domId4Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId4Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId4Element() {
      return domId4Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId4Element() {
      // Creation section.
      domId4Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId4());
      // Setup section.


      return domId4Element;
    }
  }
}
