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

public class MultipleChoicesQuestionView_MultipleChoicesQuestionViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.play.resource.question.MultipleChoicesQuestionView>, org.ednovo.gooru.client.mvp.play.resource.question.MultipleChoicesQuestionView.MultipleChoicesQuestionViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.play.resource.question.MultipleChoicesQuestionView owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.play.resource.question.MultipleChoicesQuestionView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.checkButtonClickEvent(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.play.resource.question.MultipleChoicesQuestionView owner) {
      this.owner = owner;
      build_oeStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
    }

    SafeHtml template_html1() {
      return template.html1();
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.resource.question.MultipleChoicesQuestionView_MultipleChoicesQuestionViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.play.resource.question.MultipleChoicesQuestionView_MultipleChoicesQuestionViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.play.resource.question.MultipleChoicesQuestionView_MultipleChoicesQuestionViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.play.resource.question.MultipleChoicesQuestionView_MultipleChoicesQuestionViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.play.resource.question.MultipleChoicesQuestionView_MultipleChoicesQuestionViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for oeStyle called 5 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.resource.question.MultipleChoicesQuestionView_MultipleChoicesQuestionViewUiBinderImpl_GenCss_oeStyle oeStyle;
    private org.ednovo.gooru.client.mvp.play.resource.question.MultipleChoicesQuestionView_MultipleChoicesQuestionViewUiBinderImpl_GenCss_oeStyle get_oeStyle() {
      return oeStyle;
    }
    private org.ednovo.gooru.client.mvp.play.resource.question.MultipleChoicesQuestionView_MultipleChoicesQuestionViewUiBinderImpl_GenCss_oeStyle build_oeStyle() {
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
