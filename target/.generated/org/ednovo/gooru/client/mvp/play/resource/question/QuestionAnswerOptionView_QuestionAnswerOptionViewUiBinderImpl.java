package org.ednovo.gooru.client.mvp.play.resource.question;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class QuestionAnswerOptionView_QuestionAnswerOptionViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.play.resource.question.QuestionAnswerOptionView>, org.ednovo.gooru.client.mvp.play.resource.question.QuestionAnswerOptionView.QuestionAnswerOptionViewUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.play.resource.question.QuestionAnswerOptionView owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.play.resource.question.QuestionAnswerOptionView owner;


    public Widgets(final org.ednovo.gooru.client.mvp.play.resource.question.QuestionAnswerOptionView owner) {
      this.owner = owner;
      build_oeStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.resource.question.QuestionAnswerOptionView_QuestionAnswerOptionViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.play.resource.question.QuestionAnswerOptionView_QuestionAnswerOptionViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.play.resource.question.QuestionAnswerOptionView_QuestionAnswerOptionViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.play.resource.question.QuestionAnswerOptionView_QuestionAnswerOptionViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.play.resource.question.QuestionAnswerOptionView_QuestionAnswerOptionViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for oeStyle called 4 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.resource.question.QuestionAnswerOptionView_QuestionAnswerOptionViewUiBinderImpl_GenCss_oeStyle oeStyle;
    private org.ednovo.gooru.client.mvp.play.resource.question.QuestionAnswerOptionView_QuestionAnswerOptionViewUiBinderImpl_GenCss_oeStyle get_oeStyle() {
      return oeStyle;
    }
    private org.ednovo.gooru.client.mvp.play.resource.question.QuestionAnswerOptionView_QuestionAnswerOptionViewUiBinderImpl_GenCss_oeStyle build_oeStyle() {
      // Creation section.
      oeStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().oeStyle();
      // Setup section.
      oeStyle.ensureInjected();


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
      f_FlowPanel1.add(get_answerChoiceResult());
      f_FlowPanel1.add(get_radioButton());
      f_FlowPanel1.add(get_answerOptionText());
      f_FlowPanel1.add(get_answerOptionRadioButton());
      f_FlowPanel1.setStyleName("" + get_oeStyle().resourcesQuizzessAnswersOptionsContainer() + "");


      return f_FlowPanel1;
    }

    /**
     * Getter for answerChoiceResult called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_answerChoiceResult() {
      return build_answerChoiceResult();
    }
    private com.google.gwt.user.client.ui.Label build_answerChoiceResult() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label answerChoiceResult = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      answerChoiceResult.setStyleName("" + get_oeStyle().quizAnswerChoiceOption() + "");


      owner.answerChoiceResult = answerChoiceResult;

      return answerChoiceResult;
    }

    /**
     * Getter for radioButton called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_radioButton() {
      return build_radioButton();
    }
    private com.google.gwt.user.client.ui.Label build_radioButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label radioButton = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.radioButton = radioButton;

      return radioButton;
    }

    /**
     * Getter for answerOptionText called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTML get_answerOptionText() {
      return build_answerOptionText();
    }
    private com.google.gwt.user.client.ui.HTML build_answerOptionText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML answerOptionText = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      answerOptionText.setStyleName("" + get_oeStyle().answerOptionContent() + "");


      owner.answerOptionText = answerOptionText;

      return answerOptionText;
    }

    /**
     * Getter for answerOptionRadioButton called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.RadioButton get_answerOptionRadioButton() {
      return build_answerOptionRadioButton();
    }
    private com.google.gwt.user.client.ui.RadioButton build_answerOptionRadioButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.RadioButton answerOptionRadioButton = new com.google.gwt.user.client.ui.RadioButton("answerOptions");
      // Setup section.
      answerOptionRadioButton.setStyleName("" + get_oeStyle().hideButton() + "");


      owner.answerOptionRadioButton = answerOptionRadioButton;

      return answerOptionRadioButton;
    }
  }
}
