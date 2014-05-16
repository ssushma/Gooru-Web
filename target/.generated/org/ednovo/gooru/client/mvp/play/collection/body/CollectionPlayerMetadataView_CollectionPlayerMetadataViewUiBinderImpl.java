package org.ednovo.gooru.client.mvp.play.collection.body;

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

public class CollectionPlayerMetadataView_CollectionPlayerMetadataViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.play.collection.body.CollectionPlayerMetadataView>, org.ednovo.gooru.client.mvp.play.collection.body.CollectionPlayerMetadataView.CollectionPlayerMetadataViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span>")
    SafeHtml html1(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html2(String arg0, String arg1);
     
    @Template("")
    SafeHtml html3();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html4(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html5(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html6(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span>")
    SafeHtml html7(String arg0, String arg1, String arg2, String arg3, String arg4);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html8(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html9(String arg0, String arg1, String arg2, String arg3);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html10(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html11(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html12(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html13(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html14(String arg0);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.play.collection.body.CollectionPlayerMetadataView owner) {


    return new Widgets(owner).get_studyMainContianer();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.play.collection.body.CollectionPlayerMetadataView owner;


    final com.google.gwt.event.dom.client.ErrorHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ErrorHandler() {
      public void onError(com.google.gwt.event.dom.client.ErrorEvent event) {
        owner.setDefaultProfileImage(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickOnpreviewFlagButton(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickSeeAll(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.play.collection.body.CollectionPlayerMetadataView owner) {
      this.owner = owner;
      build_playerStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId14();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId17();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId15();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId16();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId18();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId19();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId20();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId21();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId22();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId23();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId24();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId25();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId26();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId27();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId28();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId14Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId17Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId15Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId16Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId18Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId19Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId20Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId21Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId22Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId23Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId24Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId25Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId26Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId27Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId28Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
    }

    SafeHtml template_html1() {
      return template.html1(get_domId1());
    }
    SafeHtml template_html2() {
      return template.html2(get_domId3(), get_domId4());
    }
    SafeHtml template_html3() {
      return template.html3();
    }
    SafeHtml template_html4() {
      return template.html4(get_domId6(), get_domId7(), get_domId8());
    }
    SafeHtml template_html5() {
      return template.html5(get_domId10(), get_domId11());
    }
    SafeHtml template_html6() {
      return template.html6(get_domId13(), get_domId14());
    }
    SafeHtml template_html7() {
      return template.html7(get_domId0(), get_domId2(), get_domId5(), get_domId9(), get_domId12());
    }
    SafeHtml template_html8() {
      return template.html8(get_domId17());
    }
    SafeHtml template_html9() {
      return template.html9(get_domId15(), get_domId16(), get_domId18(), get_domId19());
    }
    SafeHtml template_html10() {
      return template.html10(get_domId20(), get_domId21());
    }
    SafeHtml template_html11() {
      return template.html11(get_domId22(), get_domId23());
    }
    SafeHtml template_html12() {
      return template.html12(get_domId24());
    }
    SafeHtml template_html13() {
      return template.html13(get_domId25(), get_domId26(), get_domId27());
    }
    SafeHtml template_html14() {
      return template.html14(get_domId28());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.collection.body.CollectionPlayerMetadataView_CollectionPlayerMetadataViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.play.collection.body.CollectionPlayerMetadataView_CollectionPlayerMetadataViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.play.collection.body.CollectionPlayerMetadataView_CollectionPlayerMetadataViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.play.collection.body.CollectionPlayerMetadataView_CollectionPlayerMetadataViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.play.collection.body.CollectionPlayerMetadataView_CollectionPlayerMetadataViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for playerStyle called 40 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.collection.body.CollectionPlayerMetadataView_CollectionPlayerMetadataViewUiBinderImpl_GenCss_playerStyle playerStyle;
    private org.ednovo.gooru.client.mvp.play.collection.body.CollectionPlayerMetadataView_CollectionPlayerMetadataViewUiBinderImpl_GenCss_playerStyle get_playerStyle() {
      return playerStyle;
    }
    private org.ednovo.gooru.client.mvp.play.collection.body.CollectionPlayerMetadataView_CollectionPlayerMetadataViewUiBinderImpl_GenCss_playerStyle build_playerStyle() {
      // Creation section.
      playerStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().playerStyle();
      // Setup section.
      playerStyle.ensureInjected();


      owner.playerStyle = playerStyle;

      return playerStyle;
    }

    /**
     * Getter for studyMainContianer called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_studyMainContianer() {
      return build_studyMainContianer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_studyMainContianer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel studyMainContianer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      studyMainContianer.add(get_f_FlowPanel1());
      studyMainContianer.add(get_f_FlowPanel2());
      studyMainContianer.add(get_dataInsightsPanel());
      studyMainContianer.setStyleName("" + get_playerStyle().container() + " " + get_playerStyle().clearfix() + "");


      owner.studyMainContianer = studyMainContianer;

      return studyMainContianer;
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
      f_FlowPanel1.add(get_metadataContainer());
      f_FlowPanel1.setStyleName("" + get_playerStyle().leftPanel() + "");


      return f_FlowPanel1;
    }

    /**
     * Getter for metadataContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_metadataContainer() {
      return build_metadataContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_metadataContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel metadataContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      owner.metadataContainer = metadataContainer;

      return metadataContainer;
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
      f_FlowPanel2.add(get_teacherContainer());
      f_FlowPanel2.add(get_authorPanel());
      f_FlowPanel2.add(get_courseSection());
      f_FlowPanel2.add(get_standardSection());
      f_FlowPanel2.add(get_viewSection());
      f_FlowPanel2.add(get_languageObjectiveContainer());
      f_FlowPanel2.add(get_f_HTMLPanel5());
      f_FlowPanel2.setStyleName("" + get_playerStyle().rightPanel() + "");


      return f_FlowPanel2;
    }

    /**
     * Getter for teacherContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_teacherContainer() {
      return build_teacherContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_teacherContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel teacherContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.
      teacherContainer.setStyleName("" + get_playerStyle().classInfo() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord803 = UiBinderUtil.attachToDom(teacherContainer.getElement());
      get_domId0Element().get();
      get_domId2Element().get();
      get_domId5Element().get();
      get_domId9Element().get();
      get_domId12Element().get();

      // Detach section.
      attachRecord803.detach();
      teacherContainer.addAndReplaceElement(get_classInfoPanel(), get_domId0Element().get());
      teacherContainer.addAndReplaceElement(get_f_HTMLPanel3(), get_domId2Element().get());
      teacherContainer.addAndReplaceElement(get_teacherPanel(), get_domId5Element().get());
      teacherContainer.addAndReplaceElement(get_dueDateSection(), get_domId9Element().get());
      teacherContainer.addAndReplaceElement(get_directionSection(), get_domId12Element().get());

      owner.teacherContainer = teacherContainer;

      return teacherContainer;
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
     * Getter for classInfoPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_classInfoPanel() {
      return build_classInfoPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_classInfoPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel classInfoPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      classInfoPanel.setStyleName("" + get_playerStyle().classInfoRibbon() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord804 = UiBinderUtil.attachToDom(classInfoPanel.getElement());
      get_domId1Element().get();

      // Detach section.
      attachRecord804.detach();
      classInfoPanel.addAndReplaceElement(get_lblClassInfo(), get_domId1Element().get());

      return classInfoPanel;
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
     * Getter for lblClassInfo called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_lblClassInfo() {
      return build_lblClassInfo();
    }
    private com.google.gwt.user.client.ui.Label build_lblClassInfo() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblClassInfo = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblClassInfo.setStyleName("" + get_playerStyle().h2() + "");


      owner.lblClassInfo = lblClassInfo;

      return lblClassInfo;
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
     * Getter for domId2 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for f_HTMLPanel3 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel3() {
      return build_f_HTMLPanel3();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      f_HTMLPanel3.setStyleName("" + get_playerStyle().infoSection() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord805 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
      get_domId3Element().get();
      get_domId4Element().get();

      // Detach section.
      attachRecord805.detach();
      f_HTMLPanel3.addAndReplaceElement(get_lblclassTitle(), get_domId3Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_classTitleValue(), get_domId4Element().get());

      return f_HTMLPanel3;
    }

    /**
     * Getter for domId3 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for lblclassTitle called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_lblclassTitle() {
      return build_lblclassTitle();
    }
    private com.google.gwt.user.client.ui.Label build_lblclassTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblclassTitle = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblclassTitle.setStyleName("h6 " + get_playerStyle().marginBotton10Px() + "");


      owner.lblclassTitle = lblclassTitle;

      return lblclassTitle;
    }

    /**
     * Getter for domId3Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for classTitleValue called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_classTitleValue() {
      return build_classTitleValue();
    }
    private com.google.gwt.user.client.ui.Label build_classTitleValue() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label classTitleValue = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      classTitleValue.setStyleName("" + get_playerStyle().courseTitle() + "");


      owner.classTitleValue = classTitleValue;

      return classTitleValue;
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
     * Getter for domId2Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for teacherPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_teacherPanel() {
      return build_teacherPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_teacherPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel teacherPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      teacherPanel.setStyleName("" + get_playerStyle().infoSection() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord806 = UiBinderUtil.attachToDom(teacherPanel.getElement());
      get_domId6Element().get();
      get_domId7Element().get();
      get_domId8Element().get();

      // Detach section.
      attachRecord806.detach();
      teacherPanel.addAndReplaceElement(get_lblTeacher(), get_domId6Element().get());
      teacherPanel.addAndReplaceElement(get_teacherProfileContainer(), get_domId7Element().get());
      teacherPanel.addAndReplaceElement(get_teacherNameLabel(), get_domId8Element().get());

      return teacherPanel;
    }

    /**
     * Getter for domId6 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for lblTeacher called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_lblTeacher() {
      return build_lblTeacher();
    }
    private com.google.gwt.user.client.ui.Label build_lblTeacher() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblTeacher = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblTeacher.setStyleName("h6 " + get_playerStyle().marginBotton10Px() + "");


      owner.lblTeacher = lblTeacher;

      return lblTeacher;
    }

    /**
     * Getter for domId6Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId7 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for teacherProfileContainer called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_teacherProfileContainer() {
      return build_teacherProfileContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_teacherProfileContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel teacherProfileContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      teacherProfileContainer.setStyleName("" + get_playerStyle().userImageContainer() + "");


      owner.teacherProfileContainer = teacherProfileContainer;

      return teacherProfileContainer;
    }

    /**
     * Getter for domId7Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for teacherNameLabel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_teacherNameLabel() {
      return build_teacherNameLabel();
    }
    private com.google.gwt.user.client.ui.Label build_teacherNameLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label teacherNameLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      teacherNameLabel.setStyleName("" + get_playerStyle().username() + "");


      owner.teacherNameLabel = teacherNameLabel;

      return teacherNameLabel;
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
     * Getter for dueDateSection called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_dueDateSection() {
      return build_dueDateSection();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_dueDateSection() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel dueDateSection = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.
      dueDateSection.setStyleName("" + get_playerStyle().infoSection() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord807 = UiBinderUtil.attachToDom(dueDateSection.getElement());
      get_domId10Element().get();
      get_domId11Element().get();

      // Detach section.
      attachRecord807.detach();
      dueDateSection.addAndReplaceElement(get_lbldueDate(), get_domId10Element().get());
      dueDateSection.addAndReplaceElement(get_dueDate(), get_domId11Element().get());

      owner.dueDateSection = dueDateSection;

      return dueDateSection;
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
     * Getter for lbldueDate called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_lbldueDate() {
      return build_lbldueDate();
    }
    private com.google.gwt.user.client.ui.Label build_lbldueDate() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lbldueDate = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lbldueDate.setStyleName("h6 " + get_playerStyle().marginBotton10Px() + "");


      owner.lbldueDate = lbldueDate;

      return lbldueDate;
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
     * Getter for dueDate called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_dueDate() {
      return build_dueDate();
    }
    private com.google.gwt.user.client.ui.Label build_dueDate() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label dueDate = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.dueDate = dueDate;

      return dueDate;
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
     * Getter for domId12 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for directionSection called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_directionSection() {
      return build_directionSection();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_directionSection() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel directionSection = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.
      directionSection.setStyleName("" + get_playerStyle().infoSection() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord808 = UiBinderUtil.attachToDom(directionSection.getElement());
      get_domId13Element().get();
      get_domId14Element().get();

      // Detach section.
      attachRecord808.detach();
      directionSection.addAndReplaceElement(get_lblDirections(), get_domId13Element().get());
      directionSection.addAndReplaceElement(get_lblDirectionsDesc(), get_domId14Element().get());

      owner.directionSection = directionSection;

      return directionSection;
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
     * Getter for lblDirections called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_lblDirections() {
      return build_lblDirections();
    }
    private com.google.gwt.user.client.ui.Label build_lblDirections() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblDirections = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblDirections.setStyleName("h6 " + get_playerStyle().marginBotton10Px() + "");


      owner.lblDirections = lblDirections;

      return lblDirections;
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
     * Getter for lblDirectionsDesc called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_lblDirectionsDesc() {
      return build_lblDirectionsDesc();
    }
    private com.google.gwt.user.client.ui.Label build_lblDirectionsDesc() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblDirectionsDesc = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.lblDirectionsDesc = lblDirectionsDesc;

      return lblDirectionsDesc;
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
     * Getter for domId12Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for authorPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_authorPanel() {
      return build_authorPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_authorPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel authorPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      authorPanel.setStyleName("" + get_playerStyle().infoSection() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord809 = UiBinderUtil.attachToDom(authorPanel.getElement());
      get_domId15Element().get();
      get_domId16Element().get();
      get_domId18Element().get();
      get_domId19Element().get();

      // Detach section.
      attachRecord809.detach();
      authorPanel.addAndReplaceElement(get_lblAuthor(), get_domId15Element().get());
      authorPanel.addAndReplaceElement(get_f_HTMLPanel4(), get_domId16Element().get());
      authorPanel.addAndReplaceElement(get_userNameLabel(), get_domId18Element().get());
      authorPanel.addAndReplaceElement(get_teamContainer(), get_domId19Element().get());

      owner.authorPanel = authorPanel;

      return authorPanel;
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
     * Getter for lblAuthor called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_lblAuthor() {
      return build_lblAuthor();
    }
    private com.google.gwt.user.client.ui.Label build_lblAuthor() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblAuthor = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblAuthor.setStyleName("h6 " + get_playerStyle().marginBotton10Px() + "");


      owner.lblAuthor = lblAuthor;

      return lblAuthor;
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
     * Getter for f_HTMLPanel4 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel4() {
      return build_f_HTMLPanel4();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel4 = new com.google.gwt.user.client.ui.HTMLPanel(template_html8().asString());
      // Setup section.
      f_HTMLPanel4.setStyleName("" + get_playerStyle().userImageContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord810 = UiBinderUtil.attachToDom(f_HTMLPanel4.getElement());
      get_domId17Element().get();

      // Detach section.
      attachRecord810.detach();
      f_HTMLPanel4.addAndReplaceElement(get_profileThumbnailImage(), get_domId17Element().get());

      return f_HTMLPanel4;
    }

    /**
     * Getter for domId17 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for profileThumbnailImage called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Image get_profileThumbnailImage() {
      return build_profileThumbnailImage();
    }
    private com.google.gwt.user.client.ui.Image build_profileThumbnailImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image profileThumbnailImage = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      profileThumbnailImage.setStyleName("" + get_playerStyle().userImage() + "");
      profileThumbnailImage.addErrorHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.profileThumbnailImage = profileThumbnailImage;

      return profileThumbnailImage;
    }

    /**
     * Getter for domId17Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for userNameLabel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_userNameLabel() {
      return build_userNameLabel();
    }
    private com.google.gwt.user.client.ui.Label build_userNameLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label userNameLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      userNameLabel.setStyleName("" + get_playerStyle().username() + "");


      owner.userNameLabel = userNameLabel;

      return userNameLabel;
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
     * Getter for domId19 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for teamContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_teamContainer() {
      return build_teamContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_teamContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel teamContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      teamContainer.setStyleName("" + get_playerStyle().username() + "");


      owner.teamContainer = teamContainer;

      return teamContainer;
    }

    /**
     * Getter for domId19Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for courseSection called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_courseSection() {
      return build_courseSection();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_courseSection() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel courseSection = new com.google.gwt.user.client.ui.HTMLPanel(template_html10().asString());
      // Setup section.
      courseSection.setStyleName("" + get_playerStyle().infoSection() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord811 = UiBinderUtil.attachToDom(courseSection.getElement());
      get_domId20Element().get();
      get_domId21Element().get();

      // Detach section.
      attachRecord811.detach();
      courseSection.addAndReplaceElement(get_lblCourse(), get_domId20Element().get());
      courseSection.addAndReplaceElement(get_courseTitle(), get_domId21Element().get());

      owner.courseSection = courseSection;

      return courseSection;
    }

    /**
     * Getter for domId20 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId20;
    private java.lang.String get_domId20() {
      return domId20;
    }
    private java.lang.String build_domId20() {
      // Creation section.
      domId20 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId20;
    }

    /**
     * Getter for lblCourse called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_lblCourse() {
      return build_lblCourse();
    }
    private com.google.gwt.user.client.ui.Label build_lblCourse() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblCourse = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblCourse.setStyleName("h6 " + get_playerStyle().marginBotton10Px() + "");


      owner.lblCourse = lblCourse;

      return lblCourse;
    }

    /**
     * Getter for domId20Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId20Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId20Element() {
      return domId20Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId20Element() {
      // Creation section.
      domId20Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId20());
      // Setup section.


      return domId20Element;
    }

    /**
     * Getter for domId21 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId21;
    private java.lang.String get_domId21() {
      return domId21;
    }
    private java.lang.String build_domId21() {
      // Creation section.
      domId21 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId21;
    }

    /**
     * Getter for courseTitle called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_courseTitle() {
      return build_courseTitle();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_courseTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel courseTitle = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      courseTitle.setStyleName("" + get_playerStyle().courseTitle() + "");


      owner.courseTitle = courseTitle;

      return courseTitle;
    }

    /**
     * Getter for domId21Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId21Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId21Element() {
      return domId21Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId21Element() {
      // Creation section.
      domId21Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId21());
      // Setup section.


      return domId21Element;
    }

    /**
     * Getter for standardSection called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_standardSection() {
      return build_standardSection();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_standardSection() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel standardSection = new com.google.gwt.user.client.ui.HTMLPanel(template_html11().asString());
      // Setup section.
      standardSection.setStyleName("" + get_playerStyle().infoSection() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord812 = UiBinderUtil.attachToDom(standardSection.getElement());
      get_domId22Element().get();
      get_domId23Element().get();

      // Detach section.
      attachRecord812.detach();
      standardSection.addAndReplaceElement(get_lblStandards(), get_domId22Element().get());
      standardSection.addAndReplaceElement(get_standardsContainer(), get_domId23Element().get());

      owner.standardSection = standardSection;

      return standardSection;
    }

    /**
     * Getter for domId22 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId22;
    private java.lang.String get_domId22() {
      return domId22;
    }
    private java.lang.String build_domId22() {
      // Creation section.
      domId22 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId22;
    }

    /**
     * Getter for lblStandards called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_lblStandards() {
      return build_lblStandards();
    }
    private com.google.gwt.user.client.ui.Label build_lblStandards() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblStandards = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblStandards.setStyleName("h6 " + get_playerStyle().marginBotton10Px() + "");


      owner.lblStandards = lblStandards;

      return lblStandards;
    }

    /**
     * Getter for domId22Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId22Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId22Element() {
      return domId22Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId22Element() {
      // Creation section.
      domId22Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId22());
      // Setup section.


      return domId22Element;
    }

    /**
     * Getter for domId23 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId23;
    private java.lang.String get_domId23() {
      return domId23;
    }
    private java.lang.String build_domId23() {
      // Creation section.
      domId23 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId23;
    }

    /**
     * Getter for standardsContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_standardsContainer() {
      return build_standardsContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_standardsContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel standardsContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      standardsContainer.setStyleName("" + get_playerStyle().standard_section() + "");


      owner.standardsContainer = standardsContainer;

      return standardsContainer;
    }

    /**
     * Getter for domId23Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId23Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId23Element() {
      return domId23Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId23Element() {
      // Creation section.
      domId23Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId23());
      // Setup section.


      return domId23Element;
    }

    /**
     * Getter for viewSection called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_viewSection() {
      return build_viewSection();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_viewSection() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel viewSection = new com.google.gwt.user.client.ui.HTMLPanel(template_html12().asString());
      // Setup section.
      viewSection.setStyleName("" + get_playerStyle().infoSection() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord813 = UiBinderUtil.attachToDom(viewSection.getElement());
      get_domId24Element().get();

      // Detach section.
      attachRecord813.detach();
      viewSection.addAndReplaceElement(get_viewsCountLabel(), get_domId24Element().get());

      owner.viewSection = viewSection;

      return viewSection;
    }

    /**
     * Getter for domId24 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId24;
    private java.lang.String get_domId24() {
      return domId24;
    }
    private java.lang.String build_domId24() {
      // Creation section.
      domId24 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId24;
    }

    /**
     * Getter for viewsCountLabel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_viewsCountLabel() {
      return build_viewsCountLabel();
    }
    private com.google.gwt.user.client.ui.Label build_viewsCountLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label viewsCountLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      viewsCountLabel.setStyleName("" + get_playerStyle().views() + "");


      owner.viewsCountLabel = viewsCountLabel;

      return viewsCountLabel;
    }

    /**
     * Getter for domId24Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId24Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId24Element() {
      return domId24Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId24Element() {
      // Creation section.
      domId24Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId24());
      // Setup section.


      return domId24Element;
    }

    /**
     * Getter for languageObjectiveContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_languageObjectiveContainer() {
      return build_languageObjectiveContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_languageObjectiveContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel languageObjectiveContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html13().asString());
      // Setup section.
      languageObjectiveContainer.setStyleName("" + get_playerStyle().infoSection() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord814 = UiBinderUtil.attachToDom(languageObjectiveContainer.getElement());
      get_domId25Element().get();
      get_domId26Element().get();
      get_domId27Element().get();

      // Detach section.
      attachRecord814.detach();
      languageObjectiveContainer.addAndReplaceElement(get_lbllanguageObjectiveText(), get_domId25Element().get());
      languageObjectiveContainer.addAndReplaceElement(get_lbllanguageObjective(), get_domId26Element().get());
      languageObjectiveContainer.addAndReplaceElement(get_seeMoreAnchor(), get_domId27Element().get());

      owner.languageObjectiveContainer = languageObjectiveContainer;

      return languageObjectiveContainer;
    }

    /**
     * Getter for domId25 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId25;
    private java.lang.String get_domId25() {
      return domId25;
    }
    private java.lang.String build_domId25() {
      // Creation section.
      domId25 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId25;
    }

    /**
     * Getter for lbllanguageObjectiveText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_lbllanguageObjectiveText() {
      return build_lbllanguageObjectiveText();
    }
    private com.google.gwt.user.client.ui.Label build_lbllanguageObjectiveText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lbllanguageObjectiveText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lbllanguageObjectiveText.setStyleName("h6 " + get_playerStyle().marginBotton10Px() + "");


      owner.lbllanguageObjectiveText = lbllanguageObjectiveText;

      return lbllanguageObjectiveText;
    }

    /**
     * Getter for domId25Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId25Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId25Element() {
      return domId25Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId25Element() {
      // Creation section.
      domId25Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId25());
      // Setup section.


      return domId25Element;
    }

    /**
     * Getter for domId26 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId26;
    private java.lang.String get_domId26() {
      return domId26;
    }
    private java.lang.String build_domId26() {
      // Creation section.
      domId26 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId26;
    }

    /**
     * Getter for lbllanguageObjective called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_lbllanguageObjective() {
      return build_lbllanguageObjective();
    }
    private com.google.gwt.user.client.ui.Label build_lbllanguageObjective() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lbllanguageObjective = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.lbllanguageObjective = lbllanguageObjective;

      return lbllanguageObjective;
    }

    /**
     * Getter for domId26Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId26Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId26Element() {
      return domId26Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId26Element() {
      // Creation section.
      domId26Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId26());
      // Setup section.


      return domId26Element;
    }

    /**
     * Getter for domId27 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId27;
    private java.lang.String get_domId27() {
      return domId27;
    }
    private java.lang.String build_domId27() {
      // Creation section.
      domId27 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId27;
    }

    /**
     * Getter for seeMoreAnchor called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Anchor get_seeMoreAnchor() {
      return build_seeMoreAnchor();
    }
    private com.google.gwt.user.client.ui.Anchor build_seeMoreAnchor() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor seeMoreAnchor = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      seeMoreAnchor.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);


      owner.seeMoreAnchor = seeMoreAnchor;

      return seeMoreAnchor;
    }

    /**
     * Getter for domId27Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId27Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId27Element() {
      return domId27Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId27Element() {
      // Creation section.
      domId27Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId27());
      // Setup section.


      return domId27Element;
    }

    /**
     * Getter for f_HTMLPanel5 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel5() {
      return build_f_HTMLPanel5();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel5 = new com.google.gwt.user.client.ui.HTMLPanel(template_html14().asString());
      // Setup section.
      f_HTMLPanel5.setStyleName("" + get_playerStyle().infoSection() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord815 = UiBinderUtil.attachToDom(f_HTMLPanel5.getElement());
      get_domId28Element().get();

      // Detach section.
      attachRecord815.detach();
      f_HTMLPanel5.addAndReplaceElement(get_previewFlagButton(), get_domId28Element().get());

      return f_HTMLPanel5;
    }

    /**
     * Getter for domId28 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId28;
    private java.lang.String get_domId28() {
      return domId28;
    }
    private java.lang.String build_domId28() {
      // Creation section.
      domId28 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId28;
    }

    /**
     * Getter for previewFlagButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Anchor get_previewFlagButton() {
      return build_previewFlagButton();
    }
    private com.google.gwt.user.client.ui.Anchor build_previewFlagButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor previewFlagButton = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      previewFlagButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.previewFlagButton = previewFlagButton;

      return previewFlagButton;
    }

    /**
     * Getter for domId28Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId28Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId28Element() {
      return domId28Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId28Element() {
      // Creation section.
      domId28Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId28());
      // Setup section.


      return domId28Element;
    }

    /**
     * Getter for dataInsightsPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_dataInsightsPanel() {
      return build_dataInsightsPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_dataInsightsPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel dataInsightsPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      dataInsightsPanel.add(get_frameContainer());
      dataInsightsPanel.add(get_messageContainer());
      dataInsightsPanel.setStyleName("" + get_playerStyle().insightsFrame() + "");


      return dataInsightsPanel;
    }

    /**
     * Getter for frameContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_frameContainer() {
      return build_frameContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_frameContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel frameContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      frameContainer.setStyleName("" + get_playerStyle().insightsFrameContainer() + "");


      owner.frameContainer = frameContainer;

      return frameContainer;
    }

    /**
     * Getter for messageContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_messageContainer() {
      return build_messageContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_messageContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel messageContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      messageContainer.add(get_insightsHeaderText());
      messageContainer.add(get_insightsContentText());
      messageContainer.setStyleName("" + get_playerStyle().messageContainer() + "");


      owner.messageContainer = messageContainer;

      return messageContainer;
    }

    /**
     * Getter for insightsHeaderText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_insightsHeaderText() {
      return build_insightsHeaderText();
    }
    private com.google.gwt.user.client.ui.Label build_insightsHeaderText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label insightsHeaderText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      insightsHeaderText.setStyleName("" + get_playerStyle().messageTextHeader() + "");


      owner.insightsHeaderText = insightsHeaderText;

      return insightsHeaderText;
    }

    /**
     * Getter for insightsContentText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_insightsContentText() {
      return build_insightsContentText();
    }
    private com.google.gwt.user.client.ui.Label build_insightsContentText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label insightsContentText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      insightsContentText.setStyleName("" + get_playerStyle().messagecontentText() + "");


      owner.insightsContentText = insightsContentText;

      return insightsContentText;
    }
  }
}
