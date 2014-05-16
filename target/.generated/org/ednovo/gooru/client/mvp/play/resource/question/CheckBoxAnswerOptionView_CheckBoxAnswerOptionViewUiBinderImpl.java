package org.ednovo.gooru.client.mvp.play.resource.question;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class CheckBoxAnswerOptionView_CheckBoxAnswerOptionViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.play.resource.question.CheckBoxAnswerOptionView>, org.ednovo.gooru.client.mvp.play.resource.question.CheckBoxAnswerOptionView.CheckBoxAnswerOptionViewUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.play.resource.question.CheckBoxAnswerOptionView owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.play.resource.question.CheckBoxAnswerOptionView owner;


    public Widgets(final org.ednovo.gooru.client.mvp.play.resource.question.CheckBoxAnswerOptionView owner) {
      this.owner = owner;
      build_oeStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.resource.question.CheckBoxAnswerOptionView_CheckBoxAnswerOptionViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.play.resource.question.CheckBoxAnswerOptionView_CheckBoxAnswerOptionViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.play.resource.question.CheckBoxAnswerOptionView_CheckBoxAnswerOptionViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.play.resource.question.CheckBoxAnswerOptionView_CheckBoxAnswerOptionViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.play.resource.question.CheckBoxAnswerOptionView_CheckBoxAnswerOptionViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for oeStyle called 5 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.resource.question.CheckBoxAnswerOptionView_CheckBoxAnswerOptionViewUiBinderImpl_GenCss_oeStyle oeStyle;
    private org.ednovo.gooru.client.mvp.play.resource.question.CheckBoxAnswerOptionView_CheckBoxAnswerOptionViewUiBinderImpl_GenCss_oeStyle get_oeStyle() {
      return oeStyle;
    }
    private org.ednovo.gooru.client.mvp.play.resource.question.CheckBoxAnswerOptionView_CheckBoxAnswerOptionViewUiBinderImpl_GenCss_oeStyle build_oeStyle() {
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
      f_FlowPanel1.add(get_radioYesButton());
      f_FlowPanel1.add(get_radioNoButton());
      f_FlowPanel1.add(get_answerOptionText());
      f_FlowPanel1.add(get_answerOptionYesRadioButton());
      f_FlowPanel1.add(get_answerOptionNoRadioButton());
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
     * Getter for radioYesButton called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_radioYesButton() {
      return build_radioYesButton();
    }
    private com.google.gwt.user.client.ui.Label build_radioYesButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label radioYesButton = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.radioYesButton = radioYesButton;

      return radioYesButton;
    }

    /**
     * Getter for radioNoButton called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_radioNoButton() {
      return build_radioNoButton();
    }
    private com.google.gwt.user.client.ui.Label build_radioNoButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label radioNoButton = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.radioNoButton = radioNoButton;

      return radioNoButton;
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
     * Getter for answerOptionYesRadioButton called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.RadioButton get_answerOptionYesRadioButton() {
      return build_answerOptionYesRadioButton();
    }
    private com.google.gwt.user.client.ui.RadioButton build_answerOptionYesRadioButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.RadioButton answerOptionYesRadioButton = new com.google.gwt.user.client.ui.RadioButton("maRadioButton");
      // Setup section.
      answerOptionYesRadioButton.setStyleName("" + get_oeStyle().hideButton() + "");


      owner.answerOptionYesRadioButton = answerOptionYesRadioButton;

      return answerOptionYesRadioButton;
    }

    /**
     * Getter for answerOptionNoRadioButton called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.RadioButton get_answerOptionNoRadioButton() {
      return build_answerOptionNoRadioButton();
    }
    private com.google.gwt.user.client.ui.RadioButton build_answerOptionNoRadioButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.RadioButton answerOptionNoRadioButton = new com.google.gwt.user.client.ui.RadioButton("maRadioButton");
      // Setup section.
      answerOptionNoRadioButton.setStyleName("" + get_oeStyle().hideButton() + "");


      owner.answerOptionNoRadioButton = answerOptionNoRadioButton;

      return answerOptionNoRadioButton;
    }
  }
}
