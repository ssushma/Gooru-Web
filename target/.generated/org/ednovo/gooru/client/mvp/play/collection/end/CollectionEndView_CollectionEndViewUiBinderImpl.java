package org.ednovo.gooru.client.mvp.play.collection.end;

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

public class CollectionEndView_CollectionEndViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndView>, org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndView.CollectionEndViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<div class='{0}'> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> </div>")
    SafeHtml html1(String arg0, String arg1, String arg2, String arg3);
     
    @Template("")
    SafeHtml html2();
     
    @Template("<span id='{0}'></span> <div class='{1}'> <span id='{2}'></span> <span id='{3}'></span> </div> <div class='{4}'></div> <span id='{5}'></span>")
    SafeHtml html3(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html4(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html5(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span>")
    SafeHtml html6(String arg0, String arg1, String arg2, String arg3, String arg4);
     
    @Template("")
    SafeHtml html7();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html8(String arg0, String arg1);
     
    @Template("<div class='{0}'> <div class='{1}'> <span id='{2}'></span> </div> <span id='{3}'></span> </div> <span id='{4}'></span>  <span id='{5}'></span>")
    SafeHtml html9(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndView owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickReplay(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickEmailButton(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.printSummaryPage(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickFlagButton(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndView owner) {
      this.owner = owner;
      build_collectionSummaryPageStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId14();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId15();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId16();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId17();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId18();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId19();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId14Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId15Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId16Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId17Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId18Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId19Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1("" + get_collectionSummaryPageStyle().collectionxPlayerRefreshImage() + "", get_domId2(), get_domId3(), get_domId4());
    }
    SafeHtml template_html2() {
      return template.html2();
    }
    SafeHtml template_html3() {
      return template.html3(get_domId8(), "" + get_collectionSummaryPageStyle().collectionPlayerSumShareContainer() + "", get_domId9(), get_domId10(), "" + get_collectionSummaryPageStyle().collectionPlayerInputSeparatorLine() + "", get_domId11());
    }
    SafeHtml template_html4() {
      return template.html4(get_domId7());
    }
    SafeHtml template_html5() {
      return template.html5(get_domId6());
    }
    SafeHtml template_html6() {
      return template.html6(get_domId14(), get_domId15(), get_domId16(), get_domId17(), get_domId18());
    }
    SafeHtml template_html7() {
      return template.html7();
    }
    SafeHtml template_html8() {
      return template.html8(get_domId13(), get_domId19());
    }
    SafeHtml template_html9() {
      return template.html9("" + get_collectionSummaryPageStyle().collectionPlayerReplayContainer() + "", "" + get_collectionSummaryPageStyle().collectionxPlayerSummaryTitle() + "", get_domId0(), get_domId1(), get_domId5(), get_domId12());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndView_CollectionEndViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndView_CollectionEndViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndView_CollectionEndViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndView_CollectionEndViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndView_CollectionEndViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for collectionSummaryPageStyle called 21 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndView_CollectionEndViewUiBinderImpl_GenCss_collectionSummaryPageStyle collectionSummaryPageStyle;
    private org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndView_CollectionEndViewUiBinderImpl_GenCss_collectionSummaryPageStyle get_collectionSummaryPageStyle() {
      return collectionSummaryPageStyle;
    }
    private org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndView_CollectionEndViewUiBinderImpl_GenCss_collectionSummaryPageStyle build_collectionSummaryPageStyle() {
      // Creation section.
      collectionSummaryPageStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().collectionSummaryPageStyle();
      // Setup section.
      collectionSummaryPageStyle.ensureInjected();


      return collectionSummaryPageStyle;
    }

    /**
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      f_HTMLPanel1.setStyleName("" + get_collectionSummaryPageStyle().collectionxPlayerSummaryWrapper() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1510 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId0Element().get();
      get_domId1Element().get();
      get_domId5Element().get();
      get_domId12Element().get();

      // Detach section.
      attachRecord1510.detach();
      f_HTMLPanel1.addAndReplaceElement(get_endLabelText(), get_domId0Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_collectionReplayButtonImage(), get_domId1Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_f_HTMLPanel4(), get_domId5Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_printElementContainer(), get_domId12Element().get());

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
     * Getter for endLabelText called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_endLabelText() {
      return build_endLabelText();
    }
    private com.google.gwt.user.client.ui.Label build_endLabelText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label endLabelText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      endLabelText.setStyleName("" + get_collectionSummaryPageStyle().collectionxPlayerSummaryTitleText() + "");


      owner.endLabelText = endLabelText;

      return endLabelText;
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
     * Getter for collectionReplayButtonImage called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_collectionReplayButtonImage() {
      return build_collectionReplayButtonImage();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_collectionReplayButtonImage() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel collectionReplayButtonImage = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html1().asString());
      // Setup section.
      collectionReplayButtonImage.setStyleName("" + get_collectionSummaryPageStyle().collectionxPlayerRefreshContainer() + "");
      collectionReplayButtonImage.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1511 = UiBinderUtil.attachToDom(collectionReplayButtonImage.getElement());
      get_domId2Element().get();
      get_domId3Element().get();
      get_domId4Element().get();

      // Detach section.
      attachRecord1511.detach();
      collectionReplayButtonImage.addAndReplaceElement(get_replayText(), get_domId2Element().get());
      collectionReplayButtonImage.addAndReplaceElement(get_f_Label2(), get_domId3Element().get());
      collectionReplayButtonImage.addAndReplaceElement(get_f_Label3(), get_domId4Element().get());

      owner.collectionReplayButtonImage = collectionReplayButtonImage;

      return collectionReplayButtonImage;
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
     * Getter for replayText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_replayText() {
      return build_replayText();
    }
    private com.google.gwt.user.client.ui.Label build_replayText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label replayText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      replayText.setStyleName("" + get_collectionSummaryPageStyle().collectionxPlayerRefreshText() + "");


      owner.replayText = replayText;

      return replayText;
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
     * Getter for f_Label2 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label2() {
      return build_f_Label2();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label2() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label2 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      return f_Label2;
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
     * Getter for f_Label3 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label3() {
      return build_f_Label3();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label3() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label3 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label3.setStyleName("" + get_collectionSummaryPageStyle().replayButtonNormal() + "");


      return f_Label3;
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
     * Getter for f_HTMLPanel4 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel4() {
      return build_f_HTMLPanel4();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel4 = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.
      f_HTMLPanel4.setStyleName("" + get_collectionSummaryPageStyle().collectionxPlayerShareContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1512 = UiBinderUtil.attachToDom(f_HTMLPanel4.getElement());
      get_domId6Element().get();

      // Detach section.
      attachRecord1512.detach();
      f_HTMLPanel4.addAndReplaceElement(get_f_HTMLPanel5(), get_domId6Element().get());

      return f_HTMLPanel4;
    }

    /**
     * Getter for domId6 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for f_HTMLPanel5 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel5() {
      return build_f_HTMLPanel5();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel5 = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      f_HTMLPanel5.setStyleName("" + get_collectionSummaryPageStyle().collectionPlayerSummaryShareContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1513 = UiBinderUtil.attachToDom(f_HTMLPanel5.getElement());
      get_domId7Element().get();

      // Detach section.
      attachRecord1513.detach();
      f_HTMLPanel5.addAndReplaceElement(get_collectionSummaryShareButtonImage(), get_domId7Element().get());

      return f_HTMLPanel5;
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
     * Getter for collectionSummaryShareButtonImage called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_collectionSummaryShareButtonImage() {
      return build_collectionSummaryShareButtonImage();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_collectionSummaryShareButtonImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel collectionSummaryShareButtonImage = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1514 = UiBinderUtil.attachToDom(collectionSummaryShareButtonImage.getElement());
      get_domId8Element().get();
      get_domId9Element().get();
      get_domId10Element().get();
      get_domId11Element().get();

      // Detach section.
      attachRecord1514.detach();
      collectionSummaryShareButtonImage.addAndReplaceElement(get_shareCollectionText(), get_domId8Element().get());
      collectionSummaryShareButtonImage.addAndReplaceElement(get_f_Label6(), get_domId9Element().get());
      collectionSummaryShareButtonImage.addAndReplaceElement(get_collectionPlayerSummaryShareTextBox(), get_domId10Element().get());
      collectionSummaryShareButtonImage.addAndReplaceElement(get_ftmSummaryPageContainer(), get_domId11Element().get());

      return collectionSummaryShareButtonImage;
    }

    /**
     * Getter for domId8 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for shareCollectionText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_shareCollectionText() {
      return build_shareCollectionText();
    }
    private com.google.gwt.user.client.ui.Label build_shareCollectionText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label shareCollectionText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      shareCollectionText.setStyleName("" + get_collectionSummaryPageStyle().collectionShareViewText() + "");


      owner.shareCollectionText = shareCollectionText;

      return shareCollectionText;
    }

    /**
     * Getter for domId8Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId9 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId9;
    private java.lang.String get_domId9() {
      return domId9;
    }
    private java.lang.String build_domId9() {
      // Creation section.
      domId9 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId9;
    }

    /**
     * Getter for f_Label6 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label6() {
      return build_f_Label6();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label6() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label6 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label6.setStyleName("" + get_collectionSummaryPageStyle().collectionxPlayerShareText() + "");


      return f_Label6;
    }

    /**
     * Getter for domId9Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId9Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId9Element() {
      return domId9Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId9Element() {
      // Creation section.
      domId9Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId9());
      // Setup section.


      return domId9Element;
    }

    /**
     * Getter for domId10 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId10;
    private java.lang.String get_domId10() {
      return domId10;
    }
    private java.lang.String build_domId10() {
      // Creation section.
      domId10 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId10;
    }

    /**
     * Getter for collectionPlayerSummaryShareTextBox called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.TextBox get_collectionPlayerSummaryShareTextBox() {
      return build_collectionPlayerSummaryShareTextBox();
    }
    private com.google.gwt.user.client.ui.TextBox build_collectionPlayerSummaryShareTextBox() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox collectionPlayerSummaryShareTextBox = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.
      collectionPlayerSummaryShareTextBox.setStyleName("" + get_collectionSummaryPageStyle().collectionPlayerSummaryShareTextBox() + "");


      owner.collectionPlayerSummaryShareTextBox = collectionPlayerSummaryShareTextBox;

      return collectionPlayerSummaryShareTextBox;
    }

    /**
     * Getter for domId10Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId10Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId10Element() {
      return domId10Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId10Element() {
      // Creation section.
      domId10Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId10());
      // Setup section.


      return domId10Element;
    }

    /**
     * Getter for domId11 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId11;
    private java.lang.String get_domId11() {
      return domId11;
    }
    private java.lang.String build_domId11() {
      // Creation section.
      domId11 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId11;
    }

    /**
     * Getter for ftmSummaryPageContainer called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_ftmSummaryPageContainer() {
      return build_ftmSummaryPageContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_ftmSummaryPageContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel ftmSummaryPageContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      ftmSummaryPageContainer.setStyleName("" + get_collectionSummaryPageStyle().ftmSummaryPageContainer() + "");


      owner.ftmSummaryPageContainer = ftmSummaryPageContainer;

      return ftmSummaryPageContainer;
    }

    /**
     * Getter for domId11Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId11Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId11Element() {
      return domId11Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId11Element() {
      // Creation section.
      domId11Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId11());
      // Setup section.


      return domId11Element;
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
     * Getter for domId6Element called 2 times. Type: DEFAULT. Build precedence: 3.
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

    /**
     * Getter for domId12 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
     */
    private java.lang.String domId12;
    private java.lang.String get_domId12() {
      return domId12;
    }
    private java.lang.String build_domId12() {
      // Creation section.
      domId12 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId12;
    }

    /**
     * Getter for printElementContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_printElementContainer() {
      return build_printElementContainer();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_printElementContainer() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel printElementContainer = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html8().asString());
      // Setup section.
      printElementContainer.setStyleName("" + get_collectionSummaryPageStyle().printElementContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1515 = UiBinderUtil.attachToDom(printElementContainer.getElement());
      get_domId13Element().get();
      get_domId19Element().get();

      // Detach section.
      attachRecord1515.detach();
      printElementContainer.addAndReplaceElement(get_f_HTMLPanel7(), get_domId13Element().get());
      printElementContainer.addAndReplaceElement(get_summaryQuestionsContainer(), get_domId19Element().get());

      owner.printElementContainer = printElementContainer;

      return printElementContainer;
    }

    /**
     * Getter for domId13 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId13;
    private java.lang.String get_domId13() {
      return domId13;
    }
    private java.lang.String build_domId13() {
      // Creation section.
      domId13 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId13;
    }

    /**
     * Getter for f_HTMLPanel7 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel7() {
      return build_f_HTMLPanel7();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel7() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel7 = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.
      f_HTMLPanel7.setStyleName("" + get_collectionSummaryPageStyle().cpIconsContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1516 = UiBinderUtil.attachToDom(f_HTMLPanel7.getElement());
      get_domId14Element().get();
      get_domId15Element().get();
      get_domId16Element().get();
      get_domId17Element().get();
      get_domId18Element().get();

      // Detach section.
      attachRecord1516.detach();
      f_HTMLPanel7.addAndReplaceElement(get_saveSummaryText(), get_domId14Element().get());
      f_HTMLPanel7.addAndReplaceElement(get_emailButton(), get_domId15Element().get());
      f_HTMLPanel7.addAndReplaceElement(get_printButton(), get_domId16Element().get());
      f_HTMLPanel7.addAndReplaceElement(get_resourceInfoSeparator(), get_domId17Element().get());
      f_HTMLPanel7.addAndReplaceElement(get_flagButton(), get_domId18Element().get());

      return f_HTMLPanel7;
    }

    /**
     * Getter for domId14 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId14;
    private java.lang.String get_domId14() {
      return domId14;
    }
    private java.lang.String build_domId14() {
      // Creation section.
      domId14 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId14;
    }

    /**
     * Getter for saveSummaryText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_saveSummaryText() {
      return build_saveSummaryText();
    }
    private com.google.gwt.user.client.ui.Label build_saveSummaryText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label saveSummaryText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      saveSummaryText.setStyleName("" + get_collectionSummaryPageStyle().cpSummaryText() + "");


      owner.saveSummaryText = saveSummaryText;

      return saveSummaryText;
    }

    /**
     * Getter for domId14Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId14Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId14Element() {
      return domId14Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId14Element() {
      // Creation section.
      domId14Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId14());
      // Setup section.


      return domId14Element;
    }

    /**
     * Getter for domId15 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId15;
    private java.lang.String get_domId15() {
      return domId15;
    }
    private java.lang.String build_domId15() {
      // Creation section.
      domId15 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId15;
    }

    /**
     * Getter for emailButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_emailButton() {
      return build_emailButton();
    }
    private com.google.gwt.user.client.ui.Label build_emailButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label emailButton = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      emailButton.setStyleName("" + get_collectionSummaryPageStyle().collectionEmailIcon() + "");
      emailButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.emailButton = emailButton;

      return emailButton;
    }

    /**
     * Getter for domId15Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId15Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId15Element() {
      return domId15Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId15Element() {
      // Creation section.
      domId15Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId15());
      // Setup section.


      return domId15Element;
    }

    /**
     * Getter for domId16 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId16;
    private java.lang.String get_domId16() {
      return domId16;
    }
    private java.lang.String build_domId16() {
      // Creation section.
      domId16 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId16;
    }

    /**
     * Getter for printButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_printButton() {
      return build_printButton();
    }
    private com.google.gwt.user.client.ui.Label build_printButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label printButton = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      printButton.setStyleName("" + get_collectionSummaryPageStyle().collectionPrintIcon() + "");
      printButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);


      owner.printButton = printButton;

      return printButton;
    }

    /**
     * Getter for domId16Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId16Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId16Element() {
      return domId16Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId16Element() {
      // Creation section.
      domId16Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId16());
      // Setup section.


      return domId16Element;
    }

    /**
     * Getter for domId17 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId17;
    private java.lang.String get_domId17() {
      return domId17;
    }
    private java.lang.String build_domId17() {
      // Creation section.
      domId17 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId17;
    }

    /**
     * Getter for resourceInfoSeparator called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTML get_resourceInfoSeparator() {
      return build_resourceInfoSeparator();
    }
    private com.google.gwt.user.client.ui.HTML build_resourceInfoSeparator() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML resourceInfoSeparator = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.


      owner.resourceInfoSeparator = resourceInfoSeparator;

      return resourceInfoSeparator;
    }

    /**
     * Getter for domId17Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId17Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId17Element() {
      return domId17Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId17Element() {
      // Creation section.
      domId17Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId17());
      // Setup section.


      return domId17Element;
    }

    /**
     * Getter for domId18 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId18;
    private java.lang.String get_domId18() {
      return domId18;
    }
    private java.lang.String build_domId18() {
      // Creation section.
      domId18 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId18;
    }

    /**
     * Getter for flagButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_flagButton() {
      return build_flagButton();
    }
    private com.google.gwt.user.client.ui.Label build_flagButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label flagButton = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      flagButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);


      owner.flagButton = flagButton;

      return flagButton;
    }

    /**
     * Getter for domId18Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId18Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId18Element() {
      return domId18Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId18Element() {
      // Creation section.
      domId18Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId18());
      // Setup section.


      return domId18Element;
    }

    /**
     * Getter for domId13Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId13Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId13Element() {
      return domId13Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId13Element() {
      // Creation section.
      domId13Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId13());
      // Setup section.


      return domId13Element;
    }

    /**
     * Getter for domId19 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId19;
    private java.lang.String get_domId19() {
      return domId19;
    }
    private java.lang.String build_domId19() {
      // Creation section.
      domId19 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId19;
    }

    /**
     * Getter for summaryQuestionsContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_summaryQuestionsContainer() {
      return build_summaryQuestionsContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_summaryQuestionsContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel summaryQuestionsContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.


      owner.summaryQuestionsContainer = summaryQuestionsContainer;

      return summaryQuestionsContainer;
    }

    /**
     * Getter for domId19Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId19Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId19Element() {
      return domId19Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId19Element() {
      // Creation section.
      domId19Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId19());
      // Setup section.


      return domId19Element;
    }

    /**
     * Getter for domId12Element called 2 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId12Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId12Element() {
      return domId12Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId12Element() {
      // Creation section.
      domId12Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId12());
      // Setup section.


      return domId12Element;
    }
  }
}
