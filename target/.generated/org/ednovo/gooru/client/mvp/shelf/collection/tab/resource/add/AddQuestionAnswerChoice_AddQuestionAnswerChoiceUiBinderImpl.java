package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add;

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

public class AddQuestionAnswerChoice_AddQuestionAnswerChoiceUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionAnswerChoice>, org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionAnswerChoice.AddQuestionAnswerChoiceUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html2(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html3(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html4(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span>")
    SafeHtml html5(String arg0, String arg1, String arg2, String arg3, String arg4);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionAnswerChoice owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionAnswerChoice owner;


    public Widgets(final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionAnswerChoice owner) {
      this.owner = owner;
      build_addWebResourceStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2(get_domId2(), get_domId3());
    }
    SafeHtml template_html3() {
      return template.html3(get_domId5());
    }
    SafeHtml template_html4() {
      return template.html4(get_domId7());
    }
    SafeHtml template_html5() {
      return template.html5(get_domId0(), get_domId1(), get_domId4(), get_domId6(), get_domId8());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionAnswerChoice_AddQuestionAnswerChoiceUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionAnswerChoice_AddQuestionAnswerChoiceUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionAnswerChoice_AddQuestionAnswerChoiceUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionAnswerChoice_AddQuestionAnswerChoiceUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionAnswerChoice_AddQuestionAnswerChoiceUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for addWebResourceStyle called 9 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionAnswerChoice_AddQuestionAnswerChoiceUiBinderImpl_GenCss_addWebResourceStyle addWebResourceStyle;
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionAnswerChoice_AddQuestionAnswerChoiceUiBinderImpl_GenCss_addWebResourceStyle get_addWebResourceStyle() {
      return addWebResourceStyle;
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionAnswerChoice_AddQuestionAnswerChoiceUiBinderImpl_GenCss_addWebResourceStyle build_addWebResourceStyle() {
      // Creation section.
      addWebResourceStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().addWebResourceStyle();
      // Setup section.
      addWebResourceStyle.ensureInjected();


      owner.addWebResourceStyle = addWebResourceStyle;

      return addWebResourceStyle;
    }

    /**
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.
      f_HTMLPanel1.setStyleName("" + get_addWebResourceStyle().addResourceFormAnswerContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord394 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId0Element().get();
      get_domId1Element().get();
      get_domId4Element().get();
      get_domId6Element().get();
      get_domId8Element().get();

      // Detach section.
      attachRecord394.detach();
      f_HTMLPanel1.addAndReplaceElement(get_labelChoice(), get_domId0Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_tinyOrTextBoxConatiner(), get_domId1Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_optionNoButtonContainer(), get_domId4Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_f_HTMLPanel2(), get_domId6Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_errorMessageforAnswerChoice(), get_domId8Element().get());

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
     * Getter for labelChoice called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_labelChoice() {
      return build_labelChoice();
    }
    private com.google.gwt.user.client.ui.Label build_labelChoice() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label labelChoice = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      labelChoice.setStyleName("" + get_addWebResourceStyle().addResourceFormAlphaText() + "");


      owner.labelChoice = labelChoice;

      return labelChoice;
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

    /**
     * Getter for domId1 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for tinyOrTextBoxConatiner called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_tinyOrTextBoxConatiner() {
      return build_tinyOrTextBoxConatiner();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_tinyOrTextBoxConatiner() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel tinyOrTextBoxConatiner = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      tinyOrTextBoxConatiner.setStyleName("" + get_addWebResourceStyle().addResourceFormAnswerInputControl() + " answerChoiceAndHintsTextcontainer");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord395 = UiBinderUtil.attachToDom(tinyOrTextBoxConatiner.getElement());
      get_domId2Element().get();
      get_domId3Element().get();

      // Detach section.
      attachRecord395.detach();
      tinyOrTextBoxConatiner.addAndReplaceElement(get_answerTextBox(), get_domId2Element().get());
      tinyOrTextBoxConatiner.addAndReplaceElement(get_deleteButtonContainer(), get_domId3Element().get());

      owner.tinyOrTextBoxConatiner = tinyOrTextBoxConatiner;

      return tinyOrTextBoxConatiner;
    }

    /**
     * Getter for domId2 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for answerTextBox called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.ui.TinyMCE get_answerTextBox() {
      return build_answerTextBox();
    }
    private org.ednovo.gooru.client.ui.TinyMCE build_answerTextBox() {
      // Creation section.
      final org.ednovo.gooru.client.ui.TinyMCE answerTextBox = new org.ednovo.gooru.client.ui.TinyMCE(150);
      // Setup section.


      owner.answerTextBox = answerTextBox;

      return answerTextBox;
    }

    /**
     * Getter for domId2Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId3 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for deleteButtonContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_deleteButtonContainer() {
      return build_deleteButtonContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_deleteButtonContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel deleteButtonContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      deleteButtonContainer.setStyleName("" + get_addWebResourceStyle().addResourceFormAnswerDeletebg() + "");


      owner.deleteButtonContainer = deleteButtonContainer;

      return deleteButtonContainer;
    }

    /**
     * Getter for domId3Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId1Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
     * Getter for domId4 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for optionNoButtonContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_optionNoButtonContainer() {
      return build_optionNoButtonContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_optionNoButtonContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel optionNoButtonContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      optionNoButtonContainer.setStyleName("" + get_addWebResourceStyle().addResourceFormAnswerMarkbg() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord396 = UiBinderUtil.attachToDom(optionNoButtonContainer.getElement());
      get_domId5Element().get();

      // Detach section.
      attachRecord396.detach();
      optionNoButtonContainer.addAndReplaceElement(get_optionNoButton(), get_domId5Element().get());

      owner.optionNoButtonContainer = optionNoButtonContainer;

      return optionNoButtonContainer;
    }

    /**
     * Getter for domId5 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for optionNoButton called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_optionNoButton() {
      return build_optionNoButton();
    }
    private com.google.gwt.user.client.ui.Label build_optionNoButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label optionNoButton = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      optionNoButton.setStyleName("" + get_addWebResourceStyle().answerDeselected() + "");


      owner.optionNoButton = optionNoButton;

      return optionNoButton;
    }

    /**
     * Getter for domId5Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId4Element called 2 times. Type: DEFAULT. Build precedence: 2.
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

    /**
     * Getter for domId6 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
     */
    private java.lang.String domId6;
    private java.lang.String get_domId6() {
      return domId6;
    }
    private java.lang.String build_domId6() {
      // Creation section.
      domId6 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId6;
    }

    /**
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_addWebResourceStyle().addResourceFormAnswerMarkbg() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord397 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_domId7Element().get();

      // Detach section.
      attachRecord397.detach();
      f_HTMLPanel2.addAndReplaceElement(get_optionSelectedButton(), get_domId7Element().get());

      return f_HTMLPanel2;
    }

    /**
     * Getter for domId7 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId7;
    private java.lang.String get_domId7() {
      return domId7;
    }
    private java.lang.String build_domId7() {
      // Creation section.
      domId7 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId7;
    }

    /**
     * Getter for optionSelectedButton called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_optionSelectedButton() {
      return build_optionSelectedButton();
    }
    private com.google.gwt.user.client.ui.Label build_optionSelectedButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label optionSelectedButton = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      optionSelectedButton.setStyleName("" + get_addWebResourceStyle().answerDeselected() + "");


      owner.optionSelectedButton = optionSelectedButton;

      return optionSelectedButton;
    }

    /**
     * Getter for domId7Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId7Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId7Element() {
      return domId7Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId7Element() {
      // Creation section.
      domId7Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId7());
      // Setup section.


      return domId7Element;
    }

    /**
     * Getter for domId6Element called 2 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId6Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId6Element() {
      return domId6Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId6Element() {
      // Creation section.
      domId6Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId6());
      // Setup section.


      return domId6Element;
    }

    /**
     * Getter for domId8 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
     */
    private java.lang.String domId8;
    private java.lang.String get_domId8() {
      return domId8;
    }
    private java.lang.String build_domId8() {
      // Creation section.
      domId8 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId8;
    }

    /**
     * Getter for errorMessageforAnswerChoice called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_errorMessageforAnswerChoice() {
      return build_errorMessageforAnswerChoice();
    }
    private com.google.gwt.user.client.ui.Label build_errorMessageforAnswerChoice() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label errorMessageforAnswerChoice = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      errorMessageforAnswerChoice.setStyleName("" + get_addWebResourceStyle().addResourceFormInputBottomText() + "");
      errorMessageforAnswerChoice.setText("");


      owner.errorMessageforAnswerChoice = errorMessageforAnswerChoice;

      return errorMessageforAnswerChoice;
    }

    /**
     * Getter for domId8Element called 2 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId8Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId8Element() {
      return domId8Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId8Element() {
      // Creation section.
      domId8Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId8());
      // Setup section.


      return domId8Element;
    }
  }
}
