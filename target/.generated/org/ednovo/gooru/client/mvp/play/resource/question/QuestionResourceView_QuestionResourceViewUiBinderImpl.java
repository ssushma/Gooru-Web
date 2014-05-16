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

public class QuestionResourceView_QuestionResourceViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourceView>, org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourceView.QuestionResourceViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("")
    SafeHtml html2();
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourceView owner) {


    return new Widgets(owner).get_questionContainer();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourceView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.ClickOnHintButton(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.ClickOnExplanationButton(event);
      }
    };

    final com.google.gwt.event.dom.client.ErrorHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ErrorHandler() {
      public void onError(com.google.gwt.event.dom.client.ErrorEvent event) {
        owner.defaultQuesoinImage(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourceView owner) {
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
    private org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourceView_QuestionResourceViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourceView_QuestionResourceViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourceView_QuestionResourceViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourceView_QuestionResourceViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourceView_QuestionResourceViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for oeStyle called 10 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourceView_QuestionResourceViewUiBinderImpl_GenCss_oeStyle oeStyle;
    private org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourceView_QuestionResourceViewUiBinderImpl_GenCss_oeStyle get_oeStyle() {
      return oeStyle;
    }
    private org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourceView_QuestionResourceViewUiBinderImpl_GenCss_oeStyle build_oeStyle() {
      // Creation section.
      oeStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().oeStyle();
      // Setup section.
      oeStyle.ensureInjected();


      owner.oeStyle = oeStyle;

      return oeStyle;
    }

    /**
     * Getter for questionContainer called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_questionContainer() {
      return build_questionContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_questionContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel questionContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      questionContainer.add(get_f_FlowPanel1());
      questionContainer.setStyleName("" + get_oeStyle().openEndedQuestionTotalContainer() + "");


      owner.questionContainer = questionContainer;

      return questionContainer;
    }

    /**
     * Getter for f_FlowPanel1 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel1() {
      return build_f_FlowPanel1();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel1 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel1.add(get_questiontext());
      f_FlowPanel1.add(get_openEndedQuestionText());
      f_FlowPanel1.add(get_openEndedQuestionImage());
      f_FlowPanel1.add(get_hintsButton());
      f_FlowPanel1.add(get_explanaionButton());
      f_FlowPanel1.add(get_hintsContainer());
      f_FlowPanel1.add(get_explanationContainer());
      f_FlowPanel1.setStyleName("" + get_oeStyle().openEndedQuestionContainer() + "");


      return f_FlowPanel1;
    }

    /**
     * Getter for questiontext called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_questiontext() {
      return build_questiontext();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_questiontext() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel questiontext = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      questiontext.setStyleName("" + get_oeStyle().openendedQuestionTitle() + "");


      owner.questiontext = questiontext;

      return questiontext;
    }

    /**
     * Getter for openEndedQuestionText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTML get_openEndedQuestionText() {
      return build_openEndedQuestionText();
    }
    private com.google.gwt.user.client.ui.HTML build_openEndedQuestionText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML openEndedQuestionText = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      openEndedQuestionText.setStyleName("" + get_oeStyle().openEndedQuestionFull() + "");


      owner.openEndedQuestionText = openEndedQuestionText;

      return openEndedQuestionText;
    }

    /**
     * Getter for openEndedQuestionImage called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Image get_openEndedQuestionImage() {
      return build_openEndedQuestionImage();
    }
    private com.google.gwt.user.client.ui.Image build_openEndedQuestionImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image openEndedQuestionImage = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      openEndedQuestionImage.setStyleName("" + get_oeStyle().openEndedQuestionImageContainer() + " " + get_oeStyle().openEndedQuestionImage() + "");
      openEndedQuestionImage.addErrorHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);


      owner.openEndedQuestionImage = openEndedQuestionImage;

      return openEndedQuestionImage;
    }

    /**
     * Getter for hintsButton called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_hintsButton() {
      return build_hintsButton();
    }
    private com.google.gwt.user.client.ui.Button build_hintsButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button hintsButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      hintsButton.setStyleName("" + get_oeStyle().hintsActiveButton() + "");
      hintsButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.hintsButton = hintsButton;

      return hintsButton;
    }

    /**
     * Getter for explanaionButton called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_explanaionButton() {
      return build_explanaionButton();
    }
    private com.google.gwt.user.client.ui.Button build_explanaionButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button explanaionButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      explanaionButton.setStyleName("" + get_oeStyle().hintsActiveButton() + "");
      explanaionButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.explanaionButton = explanaionButton;

      return explanaionButton;
    }

    /**
     * Getter for hintsContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_hintsContainer() {
      return build_hintsContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_hintsContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel hintsContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      hintsContainer.setStyleName("" + get_oeStyle().hintsHoldingContainer() + "");


      owner.hintsContainer = hintsContainer;

      return hintsContainer;
    }

    /**
     * Getter for explanationContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_explanationContainer() {
      return build_explanationContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_explanationContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel explanationContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      explanationContainer.setStyleName("" + get_oeStyle().explanationText() + "");


      owner.explanationContainer = explanationContainer;

      return explanationContainer;
    }
  }
}
