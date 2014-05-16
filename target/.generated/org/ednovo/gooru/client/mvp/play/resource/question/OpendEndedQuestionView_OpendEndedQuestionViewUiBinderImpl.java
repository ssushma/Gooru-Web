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

public class OpendEndedQuestionView_OpendEndedQuestionViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.play.resource.question.OpendEndedQuestionView>, org.ednovo.gooru.client.mvp.play.resource.question.OpendEndedQuestionView.OpendEndedQuestionViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("")
    SafeHtml html2();
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.play.resource.question.OpendEndedQuestionView owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.play.resource.question.OpendEndedQuestionView owner;


    final com.google.gwt.event.dom.client.KeyUpHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.KeyUpHandler() {
      public void onKeyUp(com.google.gwt.event.dom.client.KeyUpEvent event) {
        owner.onKeypressTextArea(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickOnSubmitButton(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.play.resource.question.OpendEndedQuestionView owner) {
      this.owner = owner;
      build_oeStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2();
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.resource.question.OpendEndedQuestionView_OpendEndedQuestionViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.play.resource.question.OpendEndedQuestionView_OpendEndedQuestionViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.play.resource.question.OpendEndedQuestionView_OpendEndedQuestionViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.play.resource.question.OpendEndedQuestionView_OpendEndedQuestionViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.play.resource.question.OpendEndedQuestionView_OpendEndedQuestionViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for oeStyle called 9 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.resource.question.OpendEndedQuestionView_OpendEndedQuestionViewUiBinderImpl_GenCss_oeStyle oeStyle;
    private org.ednovo.gooru.client.mvp.play.resource.question.OpendEndedQuestionView_OpendEndedQuestionViewUiBinderImpl_GenCss_oeStyle get_oeStyle() {
      return oeStyle;
    }
    private org.ednovo.gooru.client.mvp.play.resource.question.OpendEndedQuestionView_OpendEndedQuestionViewUiBinderImpl_GenCss_oeStyle build_oeStyle() {
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
      f_FlowPanel1.add(get_answertext());
      f_FlowPanel1.add(get_messageBodyText());
      f_FlowPanel1.add(get_openEndedAnswerTextArea());
      f_FlowPanel1.add(get_errorMessageText());
      f_FlowPanel1.add(get_submitButton());
      f_FlowPanel1.add(get_answetTextAfterSubmission());
      f_FlowPanel1.add(get_submittedText());
      f_FlowPanel1.setStyleName("" + get_oeStyle().openEndedQuestionAnswerContainer() + "");


      return f_FlowPanel1;
    }

    /**
     * Getter for answertext called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_answertext() {
      return build_answertext();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_answertext() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel answertext = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      answertext.setStyleName("" + get_oeStyle().openEndedQuestionAnswerTitle() + "");


      owner.answertext = answertext;

      return answertext;
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
     * Getter for openEndedAnswerTextArea called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.TextArea get_openEndedAnswerTextArea() {
      return build_openEndedAnswerTextArea();
    }
    private com.google.gwt.user.client.ui.TextArea build_openEndedAnswerTextArea() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextArea openEndedAnswerTextArea = (com.google.gwt.user.client.ui.TextArea) GWT.create(com.google.gwt.user.client.ui.TextArea.class);
      // Setup section.
      openEndedAnswerTextArea.setStyleName("" + get_oeStyle().openEndedQuestionAnswer() + "");
      openEndedAnswerTextArea.addKeyUpHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.openEndedAnswerTextArea = openEndedAnswerTextArea;

      return openEndedAnswerTextArea;
    }

    /**
     * Getter for errorMessageText called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_errorMessageText() {
      return build_errorMessageText();
    }
    private com.google.gwt.user.client.ui.Label build_errorMessageText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label errorMessageText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      errorMessageText.setStyleName("" + get_oeStyle().errorMessageStyle() + "");


      owner.errorMessageText = errorMessageText;

      return errorMessageText;
    }

    /**
     * Getter for submitButton called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Button get_submitButton() {
      return build_submitButton();
    }
    private com.google.gwt.user.client.ui.Button build_submitButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button submitButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      submitButton.setStyleName("" + get_oeStyle().openEndedQuestionSubmitButton() + " " + get_oeStyle().addjustSubmitButton() + "");
      submitButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.submitButton = submitButton;

      return submitButton;
    }

    /**
     * Getter for answetTextAfterSubmission called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_answetTextAfterSubmission() {
      return build_answetTextAfterSubmission();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_answetTextAfterSubmission() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel answetTextAfterSubmission = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      answetTextAfterSubmission.setStyleName("" + get_oeStyle().openEndedQuestionAnswerHolder() + "");


      owner.answetTextAfterSubmission = answetTextAfterSubmission;

      return answetTextAfterSubmission;
    }

    /**
     * Getter for submittedText called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_submittedText() {
      return build_submittedText();
    }
    private com.google.gwt.user.client.ui.Label build_submittedText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label submittedText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      submittedText.setStyleName("" + get_oeStyle().openEndedQuestionAnswerText() + "");


      owner.submittedText = submittedText;

      return submittedText;
    }
  }
}
