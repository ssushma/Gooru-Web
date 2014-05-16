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

public class AddHintsView_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddHintsView>, org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddHintsView.Binder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("<span id='{0}'></span>  <span id='{1}'></span>")
    SafeHtml html2(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html3(String arg0, String arg1, String arg2, String arg3);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddHintsView owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddHintsView owner;


    public Widgets(final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddHintsView owner) {
      this.owner = owner;
      build_addWebResourceStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2(get_domId3(), get_domId4());
    }
    SafeHtml template_html3() {
      return template.html3(get_domId0(), get_domId1(), get_domId2(), get_domId5());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddHintsView_BinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddHintsView_BinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddHintsView_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddHintsView_BinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddHintsView_BinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for addWebResourceStyle called 6 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddHintsView_BinderImpl_GenCss_addWebResourceStyle addWebResourceStyle;
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddHintsView_BinderImpl_GenCss_addWebResourceStyle get_addWebResourceStyle() {
      return addWebResourceStyle;
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddHintsView_BinderImpl_GenCss_addWebResourceStyle build_addWebResourceStyle() {
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
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      f_HTMLPanel1.setStyleName("" + get_addWebResourceStyle().addResourceFormAnswerContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord401 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId0Element().get();
      get_domId1Element().get();
      get_domId2Element().get();
      get_domId5Element().get();

      // Detach section.
      attachRecord401.detach();
      f_HTMLPanel1.addAndReplaceElement(get_hintsTextLblVal(), get_domId0Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_hintNumLbl(), get_domId1Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_f_HTMLPanel2(), get_domId2Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_errorMessageforHints(), get_domId5Element().get());

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
     * Getter for hintsTextLblVal called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_hintsTextLblVal() {
      return build_hintsTextLblVal();
    }
    private com.google.gwt.user.client.ui.Label build_hintsTextLblVal() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label hintsTextLblVal = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      hintsTextLblVal.setStyleName("" + get_addWebResourceStyle().addResourceFormTitle() + "");


      owner.hintsTextLblVal = hintsTextLblVal;

      return hintsTextLblVal;
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
     * Getter for hintNumLbl called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_hintNumLbl() {
      return build_hintNumLbl();
    }
    private com.google.gwt.user.client.ui.Label build_hintNumLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label hintNumLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      hintNumLbl.setStyleName("" + get_addWebResourceStyle().addResourceFormAlphaText() + "");


      owner.hintNumLbl = hintNumLbl;

      return hintNumLbl;
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
     * Getter for domId2 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_addWebResourceStyle().addResourceFormAnswerInputControl() + " answerChoiceAndHintsTextcontainer");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord402 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_domId3Element().get();
      get_domId4Element().get();

      // Detach section.
      attachRecord402.detach();
      f_HTMLPanel2.addAndReplaceElement(get_hintTextBox(), get_domId3Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_deleteButtonContainer(), get_domId4Element().get());

      return f_HTMLPanel2;
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
     * Getter for hintTextBox called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.ui.TinyMCE get_hintTextBox() {
      return build_hintTextBox();
    }
    private org.ednovo.gooru.client.ui.TinyMCE build_hintTextBox() {
      // Creation section.
      final org.ednovo.gooru.client.ui.TinyMCE hintTextBox = new org.ednovo.gooru.client.ui.TinyMCE(150);
      // Setup section.


      owner.hintTextBox = hintTextBox;

      return hintTextBox;
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

    /**
     * Getter for domId2Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
     * Getter for domId5 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for errorMessageforHints called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_errorMessageforHints() {
      return build_errorMessageforHints();
    }
    private com.google.gwt.user.client.ui.Label build_errorMessageforHints() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label errorMessageforHints = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      errorMessageforHints.setStyleName("" + get_addWebResourceStyle().addResourceFormInputBottomText() + "");
      errorMessageforHints.setText("");


      owner.errorMessageforHints = errorMessageforHints;

      return errorMessageforHints;
    }

    /**
     * Getter for domId5Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
  }
}
