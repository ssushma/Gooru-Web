package org.ednovo.gooru.client.mvp.play.resource.question;

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

public class MultipleAnswersQuestionView_MultipleAnswerQuestionViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.play.resource.question.MultipleAnswersQuestionView>, org.ednovo.gooru.client.mvp.play.resource.question.MultipleAnswersQuestionView.MultipleAnswerQuestionViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html2(String arg0, String arg1);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.play.resource.question.MultipleAnswersQuestionView owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.play.resource.question.MultipleAnswersQuestionView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.checkButtonClickEvent(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.play.resource.question.MultipleAnswersQuestionView owner) {
      this.owner = owner;
      build_oeStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2(get_domId0(), get_domId1());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.resource.question.MultipleAnswersQuestionView_MultipleAnswerQuestionViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.play.resource.question.MultipleAnswersQuestionView_MultipleAnswerQuestionViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.play.resource.question.MultipleAnswersQuestionView_MultipleAnswerQuestionViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.play.resource.question.MultipleAnswersQuestionView_MultipleAnswerQuestionViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.play.resource.question.MultipleAnswersQuestionView_MultipleAnswerQuestionViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for oeStyle called 8 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.resource.question.MultipleAnswersQuestionView_MultipleAnswerQuestionViewUiBinderImpl_GenCss_oeStyle oeStyle;
    private org.ednovo.gooru.client.mvp.play.resource.question.MultipleAnswersQuestionView_MultipleAnswerQuestionViewUiBinderImpl_GenCss_oeStyle get_oeStyle() {
      return oeStyle;
    }
    private org.ednovo.gooru.client.mvp.play.resource.question.MultipleAnswersQuestionView_MultipleAnswerQuestionViewUiBinderImpl_GenCss_oeStyle build_oeStyle() {
      // Creation section.
      oeStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().oeStyle();
      // Setup section.
      oeStyle.ensureInjected();


      owner.oeStyle = oeStyle;

      return oeStyle;
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
      f_FlowPanel1.add(get_answerText());
      f_FlowPanel1.add(get_messageBodyText());
      f_FlowPanel1.add(get_f_HTMLPanel2());
      f_FlowPanel1.add(get_optionsContainer());
      f_FlowPanel1.add(get_checkAnswer());
      f_FlowPanel1.setStyleName("" + get_oeStyle().openEndedQuestionAnswerContainer() + "");


      return f_FlowPanel1;
    }

    /**
     * Getter for answerText called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_answerText() {
      return build_answerText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_answerText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel answerText = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      answerText.setStyleName("" + get_oeStyle().openEndedQuestionAnswerTitle() + "");


      owner.answerText = answerText;

      return answerText;
    }

    /**
     * Getter for messageBodyText called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_messageBodyText() {
      return build_messageBodyText();
    }
    private com.google.gwt.user.client.ui.Label build_messageBodyText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label messageBodyText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      messageBodyText.setStyleName("" + get_oeStyle().systemMessageStyle() + "");


      owner.messageBodyText = messageBodyText;

      return messageBodyText;
    }

    /**
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_oeStyle().yesnotextContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord392 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_domId0Element().get();
      get_domId1Element().get();

      // Detach section.
      attachRecord392.detach();
      f_HTMLPanel2.addAndReplaceElement(get_f_InlineLabel3(), get_domId0Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_f_InlineLabel4(), get_domId1Element().get());

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
     * Getter for f_InlineLabel3 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.InlineLabel get_f_InlineLabel3() {
      return build_f_InlineLabel3();
    }
    private com.google.gwt.user.client.ui.InlineLabel build_f_InlineLabel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.InlineLabel f_InlineLabel3 = (com.google.gwt.user.client.ui.InlineLabel) GWT.create(com.google.gwt.user.client.ui.InlineLabel.class);
      // Setup section.
      f_InlineLabel3.setText("Yes");
      f_InlineLabel3.setStyleName("" + get_oeStyle().yesText() + "");


      return f_InlineLabel3;
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
     * Getter for f_InlineLabel4 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.InlineLabel get_f_InlineLabel4() {
      return build_f_InlineLabel4();
    }
    private com.google.gwt.user.client.ui.InlineLabel build_f_InlineLabel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.InlineLabel f_InlineLabel4 = (com.google.gwt.user.client.ui.InlineLabel) GWT.create(com.google.gwt.user.client.ui.InlineLabel.class);
      // Setup section.
      f_InlineLabel4.setText("No");
      f_InlineLabel4.setStyleName("" + get_oeStyle().noText() + "");


      return f_InlineLabel4;
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
     * Getter for optionsContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_optionsContainer() {
      return build_optionsContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_optionsContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel optionsContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      owner.optionsContainer = optionsContainer;

      return optionsContainer;
    }

    /**
     * Getter for checkAnswer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Button get_checkAnswer() {
      return build_checkAnswer();
    }
    private com.google.gwt.user.client.ui.Button build_checkAnswer() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button checkAnswer = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      checkAnswer.setStyleName("" + get_oeStyle().hintsInActiveButton() + " " + get_oeStyle().adjustCheckAnswerButton() + "");
      checkAnswer.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.checkAnswer = checkAnswer;

      return checkAnswer;
    }
  }
}
