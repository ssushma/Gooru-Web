package org.ednovo.gooru.client.mvp.home.library;

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

public class LibraryTopicListView_LibraryTopicViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.home.library.LibraryTopicListView>, org.ednovo.gooru.client.mvp.home.library.LibraryTopicListView.LibraryTopicViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("")
    SafeHtml html2();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html3(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html4(String arg0, String arg1);
     
    @Template("")
    SafeHtml html5();
     
    @Template("")
    SafeHtml html6();
     
    @Template("")
    SafeHtml html7();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span>")
    SafeHtml html8(String arg0, String arg1, String arg2, String arg3, String arg4);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html9(String arg0, String arg1, String arg2);
     
    @Template("")
    SafeHtml html10();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html11(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html12(String arg0, String arg1, String arg2, String arg3);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.home.library.LibraryTopicListView owner) {


    return new Widgets(owner).get_topicBlock();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.home.library.LibraryTopicListView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onassignCollectionBtnClicked(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.oncustomizeCollectionBtnClicked(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.home.library.LibraryTopicListView owner) {
      this.owner = owner;
      build_libraryStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId14();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId15();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId16();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId17();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId18();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId14Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId15Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId16Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId17Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId18Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2();
    }
    SafeHtml template_html3() {
      return template.html3(get_domId3(), get_domId4());
    }
    SafeHtml template_html4() {
      return template.html4(get_domId1(), get_domId2());
    }
    SafeHtml template_html5() {
      return template.html5();
    }
    SafeHtml template_html6() {
      return template.html6();
    }
    SafeHtml template_html7() {
      return template.html7();
    }
    SafeHtml template_html8() {
      return template.html8(get_domId12(), get_domId13(), get_domId14(), get_domId15(), get_domId16());
    }
    SafeHtml template_html9() {
      return template.html9(get_domId9(), get_domId10(), get_domId11());
    }
    SafeHtml template_html10() {
      return template.html10();
    }
    SafeHtml template_html11() {
      return template.html11(get_domId8(), get_domId17(), get_domId18());
    }
    SafeHtml template_html12() {
      return template.html12(get_domId0(), get_domId5(), get_domId6(), get_domId7());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.library.LibraryTopicListView_LibraryTopicViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.home.library.LibraryTopicListView_LibraryTopicViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.home.library.LibraryTopicListView_LibraryTopicViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.home.library.LibraryTopicListView_LibraryTopicViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.home.library.LibraryTopicListView_LibraryTopicViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for libraryStyle called 18 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.library.LibraryTopicListView_LibraryTopicViewUiBinderImpl_GenCss_libraryStyle libraryStyle;
    private org.ednovo.gooru.client.mvp.home.library.LibraryTopicListView_LibraryTopicViewUiBinderImpl_GenCss_libraryStyle get_libraryStyle() {
      return libraryStyle;
    }
    private org.ednovo.gooru.client.mvp.home.library.LibraryTopicListView_LibraryTopicViewUiBinderImpl_GenCss_libraryStyle build_libraryStyle() {
      // Creation section.
      libraryStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().libraryStyle();
      // Setup section.
      libraryStyle.ensureInjected();


      owner.libraryStyle = libraryStyle;

      return libraryStyle;
    }

    /**
     * Getter for topicBlock called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_topicBlock() {
      return build_topicBlock();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_topicBlock() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel topicBlock = new com.google.gwt.user.client.ui.HTMLPanel(template_html12().asString());
      // Setup section.
      topicBlock.setStyleName("" + get_libraryStyle().topicBlock() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1999 = UiBinderUtil.attachToDom(topicBlock.getElement());
      get_domId0Element().get();
      get_domId5Element().get();
      get_domId6Element().get();
      get_domId7Element().get();

      // Detach section.
      attachRecord1999.detach();
      topicBlock.addAndReplaceElement(get_f_HTMLPanel1(), get_domId0Element().get());
      topicBlock.addAndReplaceElement(get_lessonScrollPanel(), get_domId5Element().get());
      topicBlock.addAndReplaceElement(get_loadingImage(), get_domId6Element().get());
      topicBlock.addAndReplaceElement(get_collectionViewer(), get_domId7Element().get());

      owner.topicBlock = topicBlock;

      return topicBlock;
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
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      f_HTMLPanel1.setStyleName("" + get_libraryStyle().topicTitle() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2000 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId1Element().get();
      get_domId2Element().get();

      // Detach section.
      attachRecord2000.detach();
      f_HTMLPanel1.addAndReplaceElement(get_topicTitleLbl(), get_domId1Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_searchLink(), get_domId2Element().get());

      return f_HTMLPanel1;
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
     * Getter for topicTitleLbl called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_topicTitleLbl() {
      return build_topicTitleLbl();
    }
    private com.google.gwt.user.client.ui.Label build_topicTitleLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label topicTitleLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      topicTitleLbl.setStyleName("" + get_libraryStyle().topicListEllipsis() + "");


      owner.topicTitleLbl = topicTitleLbl;

      return topicTitleLbl;
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
     * Getter for searchLink called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_searchLink() {
      return build_searchLink();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_searchLink() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel searchLink = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html3().asString());
      // Setup section.
      searchLink.setStyleName("" + get_libraryStyle().searchLink() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2001 = UiBinderUtil.attachToDom(searchLink.getElement());
      get_domId3Element().get();
      get_domId4Element().get();

      // Detach section.
      attachRecord2001.detach();
      searchLink.addAndReplaceElement(get_moreOnTopicText(), get_domId3Element().get());
      searchLink.addAndReplaceElement(get_f_HTMLPanel2(), get_domId4Element().get());

      owner.searchLink = searchLink;

      return searchLink;
    }

    /**
     * Getter for domId3 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for moreOnTopicText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_moreOnTopicText() {
      return build_moreOnTopicText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_moreOnTopicText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel moreOnTopicText = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      moreOnTopicText.setStyleName("" + get_libraryStyle().hoverText() + "");


      owner.moreOnTopicText = moreOnTopicText;

      return moreOnTopicText;
    }

    /**
     * Getter for domId3Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId4 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_libraryStyle().searchMagnify() + "");


      return f_HTMLPanel2;
    }

    /**
     * Getter for domId4Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for lessonScrollPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.ScrollPanel get_lessonScrollPanel() {
      return build_lessonScrollPanel();
    }
    private com.google.gwt.user.client.ui.ScrollPanel build_lessonScrollPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.ScrollPanel lessonScrollPanel = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
      // Setup section.
      lessonScrollPanel.add(get_conceptList());
      lessonScrollPanel.setStyleName("" + get_libraryStyle().conceptList() + "");


      owner.lessonScrollPanel = lessonScrollPanel;

      return lessonScrollPanel;
    }

    /**
     * Getter for conceptList called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_conceptList() {
      return build_conceptList();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_conceptList() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel conceptList = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.


      owner.conceptList = conceptList;

      return conceptList;
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
     * Getter for loadingImage called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_loadingImage() {
      return build_loadingImage();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_loadingImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel loadingImage = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.
      loadingImage.setStyleName("loadingImage " + get_libraryStyle().loadingIcon() + "");


      owner.loadingImage = loadingImage;

      return loadingImage;
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
     * Getter for domId7 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for collectionViewer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_collectionViewer() {
      return build_collectionViewer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_collectionViewer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel collectionViewer = new com.google.gwt.user.client.ui.HTMLPanel(template_html11().asString());
      // Setup section.
      collectionViewer.setStyleName("" + get_libraryStyle().collectionViewer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2002 = UiBinderUtil.attachToDom(collectionViewer.getElement());
      get_domId8Element().get();
      get_domId17Element().get();
      get_domId18Element().get();

      // Detach section.
      attachRecord2002.detach();
      collectionViewer.addAndReplaceElement(get_collectionInfo(), get_domId8Element().get());
      collectionViewer.addAndReplaceElement(get_resourcesInside(), get_domId17Element().get());
      collectionViewer.addAndReplaceElement(get_noCollectionLbl(), get_domId18Element().get());

      owner.collectionViewer = collectionViewer;

      return collectionViewer;
    }

    /**
     * Getter for domId8 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for collectionInfo called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_collectionInfo() {
      return build_collectionInfo();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_collectionInfo() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel collectionInfo = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      collectionInfo.setStyleName("" + get_libraryStyle().collectionInfo() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2003 = UiBinderUtil.attachToDom(collectionInfo.getElement());
      get_domId9Element().get();
      get_domId10Element().get();
      get_domId11Element().get();

      // Detach section.
      attachRecord2003.detach();
      collectionInfo.addAndReplaceElement(get_standardsDescription(), get_domId9Element().get());
      collectionInfo.addAndReplaceElement(get_collectionImage(), get_domId10Element().get());
      collectionInfo.addAndReplaceElement(get_f_HTMLPanel3(), get_domId11Element().get());

      owner.collectionInfo = collectionInfo;

      return collectionInfo;
    }

    /**
     * Getter for domId9 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for standardsDescription called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_standardsDescription() {
      return build_standardsDescription();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_standardsDescription() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel standardsDescription = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.
      standardsDescription.setStyleName("" + get_libraryStyle().standardsDescription() + "");


      owner.standardsDescription = standardsDescription;

      return standardsDescription;
    }

    /**
     * Getter for domId9Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId10 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for collectionImage called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Image get_collectionImage() {
      return build_collectionImage();
    }
    private com.google.gwt.user.client.ui.Image build_collectionImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image collectionImage = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      collectionImage.setStyleName("" + get_libraryStyle().collectionImage() + "");


      owner.collectionImage = collectionImage;

      return collectionImage;
    }

    /**
     * Getter for domId10Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId11 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for f_HTMLPanel3 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel3() {
      return build_f_HTMLPanel3();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template_html8().asString());
      // Setup section.
      f_HTMLPanel3.setStyleName("" + get_libraryStyle().collectionMetaData() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2004 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
      get_domId12Element().get();
      get_domId13Element().get();
      get_domId14Element().get();
      get_domId15Element().get();
      get_domId16Element().get();

      // Detach section.
      attachRecord2004.detach();
      f_HTMLPanel3.addAndReplaceElement(get_collectionTitleLbl(), get_domId12Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_collectionDescriptionLbl(), get_domId13Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_standardsFloPanel(), get_domId14Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_assignCollectionBtn(), get_domId15Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_customizeCollectionBtn(), get_domId16Element().get());

      return f_HTMLPanel3;
    }

    /**
     * Getter for domId12 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for collectionTitleLbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTML get_collectionTitleLbl() {
      return build_collectionTitleLbl();
    }
    private com.google.gwt.user.client.ui.HTML build_collectionTitleLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML collectionTitleLbl = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      collectionTitleLbl.setStyleName("" + get_libraryStyle().collectionTitle() + "");


      owner.collectionTitleLbl = collectionTitleLbl;

      return collectionTitleLbl;
    }

    /**
     * Getter for domId12Element called 2 times. Type: DEFAULT. Build precedence: 5.
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

    /**
     * Getter for domId13 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for collectionDescriptionLbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTML get_collectionDescriptionLbl() {
      return build_collectionDescriptionLbl();
    }
    private com.google.gwt.user.client.ui.HTML build_collectionDescriptionLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML collectionDescriptionLbl = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      collectionDescriptionLbl.setStyleName("" + get_libraryStyle().collectionDescription() + "");


      owner.collectionDescriptionLbl = collectionDescriptionLbl;

      return collectionDescriptionLbl;
    }

    /**
     * Getter for domId13Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId14 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for standardsFloPanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_standardsFloPanel() {
      return build_standardsFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_standardsFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel standardsFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      standardsFloPanel.setStyleName("" + get_libraryStyle().standards() + "");


      owner.standardsFloPanel = standardsFloPanel;

      return standardsFloPanel;
    }

    /**
     * Getter for domId14Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId15 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for assignCollectionBtn called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Button get_assignCollectionBtn() {
      return build_assignCollectionBtn();
    }
    private com.google.gwt.user.client.ui.Button build_assignCollectionBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button assignCollectionBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      assignCollectionBtn.setStyleName("secondary");
      assignCollectionBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.assignCollectionBtn = assignCollectionBtn;

      return assignCollectionBtn;
    }

    /**
     * Getter for domId15Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId16 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for customizeCollectionBtn called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Button get_customizeCollectionBtn() {
      return build_customizeCollectionBtn();
    }
    private com.google.gwt.user.client.ui.Button build_customizeCollectionBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button customizeCollectionBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      customizeCollectionBtn.setStyleName("secondary");
      customizeCollectionBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.customizeCollectionBtn = customizeCollectionBtn;

      return customizeCollectionBtn;
    }

    /**
     * Getter for domId16Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId11Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId8Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId17 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for resourcesInside called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_resourcesInside() {
      return build_resourcesInside();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_resourcesInside() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel resourcesInside = new com.google.gwt.user.client.ui.HTMLPanel(template_html10().asString());
      // Setup section.
      resourcesInside.setStyleName("" + get_libraryStyle().resourcesInside() + "");


      owner.resourcesInside = resourcesInside;

      return resourcesInside;
    }

    /**
     * Getter for domId17Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId18 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for noCollectionLbl called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_noCollectionLbl() {
      return build_noCollectionLbl();
    }
    private com.google.gwt.user.client.ui.Label build_noCollectionLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label noCollectionLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      noCollectionLbl.setStyleName("" + get_libraryStyle().noCollectionLbl() + "");


      owner.noCollectionLbl = noCollectionLbl;

      return noCollectionLbl;
    }

    /**
     * Getter for domId18Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId7Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
  }
}
