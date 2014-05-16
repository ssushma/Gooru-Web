package org.ednovo.gooru.client.mvp.play.collection.header;

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

public class StudyPlayerHeaderView_CollectionPlayerHeaderViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.play.collection.header.StudyPlayerHeaderView>, org.ednovo.gooru.client.mvp.play.collection.header.StudyPlayerHeaderView.CollectionPlayerHeaderViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span>")
    SafeHtml html1(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html2(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span>")
    SafeHtml html3(String arg0, String arg1, String arg2, String arg3, String arg4);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.play.collection.header.StudyPlayerHeaderView owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.play.collection.header.StudyPlayerHeaderView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.collectionPlay(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.play.collection.header.StudyPlayerHeaderView owner) {
      this.owner = owner;
      build_headerStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_palyerBundle();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
    }

    SafeHtml template_html1() {
      return template.html1(get_domId3());
    }
    SafeHtml template_html2() {
      return template.html2(get_domId1(), get_domId2(), get_domId4());
    }
    SafeHtml template_html3() {
      return template.html3(get_domId0(), get_domId5(), get_domId6(), get_domId7(), get_domId8());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.collection.header.StudyPlayerHeaderView_CollectionPlayerHeaderViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.play.collection.header.StudyPlayerHeaderView_CollectionPlayerHeaderViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.play.collection.header.StudyPlayerHeaderView_CollectionPlayerHeaderViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.play.collection.header.StudyPlayerHeaderView_CollectionPlayerHeaderViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.play.collection.header.StudyPlayerHeaderView_CollectionPlayerHeaderViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for headerStyle called 18 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.collection.header.StudyPlayerHeaderView_CollectionPlayerHeaderViewUiBinderImpl_GenCss_headerStyle headerStyle;
    private org.ednovo.gooru.client.mvp.play.collection.header.StudyPlayerHeaderView_CollectionPlayerHeaderViewUiBinderImpl_GenCss_headerStyle get_headerStyle() {
      return headerStyle;
    }
    private org.ednovo.gooru.client.mvp.play.collection.header.StudyPlayerHeaderView_CollectionPlayerHeaderViewUiBinderImpl_GenCss_headerStyle build_headerStyle() {
      // Creation section.
      headerStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().headerStyle();
      // Setup section.
      headerStyle.ensureInjected();


      owner.headerStyle = headerStyle;

      return headerStyle;
    }

    /**
     * Getter for palyerBundle called 7 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.PlayerBundle palyerBundle;
    private org.ednovo.gooru.client.uc.PlayerBundle get_palyerBundle() {
      return palyerBundle;
    }
    private org.ednovo.gooru.client.uc.PlayerBundle build_palyerBundle() {
      // Creation section.
      palyerBundle = (org.ednovo.gooru.client.uc.PlayerBundle) GWT.create(org.ednovo.gooru.client.uc.PlayerBundle.class);
      // Setup section.


      return palyerBundle;
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
      f_FlowPanel1.add(get_f_FlowPanel2());
      f_FlowPanel1.add(get_closeButtonForCollection());
      f_FlowPanel1.setStyleName("" + get_headerStyle().headerbar() + " " + get_headerStyle().studyPlayer() + " " + get_palyerBundle().getPlayerStyle().studyPlayer() + "");


      return f_FlowPanel1;
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
      f_FlowPanel2.add(get_resourceTitle());
      f_FlowPanel2.add(get_authorContainer());
      f_FlowPanel2.add(get_f_FlowPanel9());
      f_FlowPanel2.setStyleName("" + get_headerStyle().headerInner() + "");


      return f_FlowPanel2;
    }

    /**
     * Getter for resourceTitle called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTML get_resourceTitle() {
      return build_resourceTitle();
    }
    private com.google.gwt.user.client.ui.HTML build_resourceTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML resourceTitle = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      resourceTitle.setStyleName("" + get_headerStyle().playerResourceTitle() + "");


      owner.resourceTitle = resourceTitle;

      return resourceTitle;
    }

    /**
     * Getter for authorContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_authorContainer() {
      return build_authorContainer();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_authorContainer() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel authorContainer = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html3().asString());
      // Setup section.
      authorContainer.setStyleName("" + get_headerStyle().loginStatus() + " " + get_headerStyle().loggedIn() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord931 = UiBinderUtil.attachToDom(authorContainer.getElement());
      get_domId0Element().get();
      get_domId5Element().get();
      get_domId6Element().get();
      get_domId7Element().get();
      get_domId8Element().get();

      // Detach section.
      attachRecord931.detach();
      authorContainer.addAndReplaceElement(get_f_HTMLPanel3(), get_domId0Element().get());
      authorContainer.addAndReplaceElement(get_wishLabel(), get_domId5Element().get());
      authorContainer.addAndReplaceElement(get_loginUserName(), get_domId6Element().get());
      authorContainer.addAndReplaceElement(get_wishingText(), get_domId7Element().get());
      authorContainer.addAndReplaceElement(get_f_FlowPanel8(), get_domId8Element().get());

      owner.authorContainer = authorContainer;

      return authorContainer;
    }

    /**
     * Getter for domId0 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for f_HTMLPanel3 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel3() {
      return build_f_HTMLPanel3();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      f_HTMLPanel3.setStyleName("" + get_headerStyle().loggingIcon() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord932 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
      get_domId1Element().get();
      get_domId2Element().get();
      get_domId4Element().get();

      // Detach section.
      attachRecord932.detach();
      f_HTMLPanel3.addAndReplaceElement(get_f_Label4(), get_domId1Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_f_HTMLPanel5(), get_domId2Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_f_Label7(), get_domId4Element().get());

      return f_HTMLPanel3;
    }

    /**
     * Getter for domId1 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_Label4 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label4() {
      return build_f_Label4();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label4() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label4 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label4.setStyleName("" + get_headerStyle().progress() + "");


      return f_Label4;
    }

    /**
     * Getter for domId1Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId2 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel5 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel5() {
      return build_f_HTMLPanel5();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel5 = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      f_HTMLPanel5.setStyleName("" + get_headerStyle().remainingTrack() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord933 = UiBinderUtil.attachToDom(f_HTMLPanel5.getElement());
      get_domId3Element().get();

      // Detach section.
      attachRecord933.detach();
      f_HTMLPanel5.addAndReplaceElement(get_f_Label6(), get_domId3Element().get());

      return f_HTMLPanel5;
    }

    /**
     * Getter for domId3 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for f_Label6 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label6() {
      return build_f_Label6();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label6() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label6 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label6.setStyleName("" + get_headerStyle().trackInner() + "");


      return f_Label6;
    }

    /**
     * Getter for domId3Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId2Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId4 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_Label7 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label7() {
      return build_f_Label7();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label7() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label7 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label7.setStyleName("" + get_headerStyle().innerDot() + "");


      return f_Label7;
    }

    /**
     * Getter for domId4Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId0Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for wishLabel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.InlineLabel get_wishLabel() {
      return build_wishLabel();
    }
    private com.google.gwt.user.client.ui.InlineLabel build_wishLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.InlineLabel wishLabel = (com.google.gwt.user.client.ui.InlineLabel) GWT.create(com.google.gwt.user.client.ui.InlineLabel.class);
      // Setup section.
      wishLabel.setStyleName("");


      owner.wishLabel = wishLabel;

      return wishLabel;
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
     * Getter for domId6 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for loginUserName called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.InlineLabel get_loginUserName() {
      return build_loginUserName();
    }
    private com.google.gwt.user.client.ui.InlineLabel build_loginUserName() {
      // Creation section.
      final com.google.gwt.user.client.ui.InlineLabel loginUserName = (com.google.gwt.user.client.ui.InlineLabel) GWT.create(com.google.gwt.user.client.ui.InlineLabel.class);
      // Setup section.
      loginUserName.setStyleName("" + get_headerStyle().username() + "");


      owner.loginUserName = loginUserName;

      return loginUserName;
    }

    /**
     * Getter for domId6Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId7 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for wishingText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.InlineLabel get_wishingText() {
      return build_wishingText();
    }
    private com.google.gwt.user.client.ui.InlineLabel build_wishingText() {
      // Creation section.
      final com.google.gwt.user.client.ui.InlineLabel wishingText = (com.google.gwt.user.client.ui.InlineLabel) GWT.create(com.google.gwt.user.client.ui.InlineLabel.class);
      // Setup section.
      wishingText.setStyleName("");


      owner.wishingText = wishingText;

      return wishingText;
    }

    /**
     * Getter for domId7Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId8 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for f_FlowPanel8 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel8() {
      return build_f_FlowPanel8();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel8() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel8 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel8.add(get_loginMessageText());
      f_FlowPanel8.setStyleName("" + get_headerStyle().toolTip() + "");


      return f_FlowPanel8;
    }

    /**
     * Getter for loginMessageText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_loginMessageText() {
      return build_loginMessageText();
    }
    private com.google.gwt.user.client.ui.Label build_loginMessageText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label loginMessageText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      loginMessageText.setStyleName("" + get_headerStyle().tooltipText() + "");


      owner.loginMessageText = loginMessageText;

      return loginMessageText;
    }

    /**
     * Getter for domId8Element called 2 times. Type: DEFAULT. Build precedence: 4.
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

    /**
     * Getter for f_FlowPanel9 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel9() {
      return build_f_FlowPanel9();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel9() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel9 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel9.add(get_flagButton());
      f_FlowPanel9.add(get_addButton());
      f_FlowPanel9.add(get_infoButton());
      f_FlowPanel9.add(get_shareButton());
      f_FlowPanel9.add(get_narrationButton());
      f_FlowPanel9.add(get_navigationButton());
      f_FlowPanel9.add(get_studentViewButton());
      f_FlowPanel9.setStyleName("" + get_headerStyle().tabs() + " " + get_headerStyle().player_buttons() + "");


      return f_FlowPanel9;
    }

    /**
     * Getter for flagButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Button get_flagButton() {
      return build_flagButton();
    }
    private com.google.gwt.user.client.ui.Button build_flagButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button flagButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      flagButton.setStyleName("" + get_palyerBundle().getPlayerStyle().flagButtonDisable() + "");


      owner.flagButton = flagButton;

      return flagButton;
    }

    /**
     * Getter for addButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Button get_addButton() {
      return build_addButton();
    }
    private com.google.gwt.user.client.ui.Button build_addButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button addButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      addButton.setStyleName("" + get_palyerBundle().getPlayerStyle().addButtonDisabled() + "");


      owner.addButton = addButton;

      return addButton;
    }

    /**
     * Getter for infoButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Button get_infoButton() {
      return build_infoButton();
    }
    private com.google.gwt.user.client.ui.Button build_infoButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button infoButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      infoButton.setStyleName("" + get_palyerBundle().getPlayerStyle().infoButtonDisabled() + "");


      owner.infoButton = infoButton;

      return infoButton;
    }

    /**
     * Getter for shareButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Button get_shareButton() {
      return build_shareButton();
    }
    private com.google.gwt.user.client.ui.Button build_shareButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button shareButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      shareButton.setStyleName("" + get_palyerBundle().getPlayerStyle().shareButtonDisabled() + "");


      owner.shareButton = shareButton;

      return shareButton;
    }

    /**
     * Getter for narrationButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Button get_narrationButton() {
      return build_narrationButton();
    }
    private com.google.gwt.user.client.ui.Button build_narrationButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button narrationButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      narrationButton.setStyleName("" + get_palyerBundle().getPlayerStyle().narrationButtonDisabled() + "");


      owner.narrationButton = narrationButton;

      return narrationButton;
    }

    /**
     * Getter for navigationButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Button get_navigationButton() {
      return build_navigationButton();
    }
    private com.google.gwt.user.client.ui.Button build_navigationButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button navigationButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      navigationButton.setStyleName("" + get_palyerBundle().getPlayerStyle().navigationButtonDisabled() + "");


      owner.navigationButton = navigationButton;

      return navigationButton;
    }

    /**
     * Getter for studentViewButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Anchor get_studentViewButton() {
      return build_studentViewButton();
    }
    private com.google.gwt.user.client.ui.Anchor build_studentViewButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor studentViewButton = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      studentViewButton.setStyleName("" + get_headerStyle().playerStudentviewButton() + "");
      studentViewButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.studentViewButton = studentViewButton;

      return studentViewButton;
    }

    /**
     * Getter for closeButtonForCollection called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_closeButtonForCollection() {
      return build_closeButtonForCollection();
    }
    private com.google.gwt.user.client.ui.Label build_closeButtonForCollection() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label closeButtonForCollection = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      closeButtonForCollection.setStyleName("" + get_headerStyle().closeButton() + "");


      owner.closeButtonForCollection = closeButtonForCollection;

      return closeButtonForCollection;
    }
  }
}
