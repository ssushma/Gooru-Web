package org.ednovo.gooru.client.mvp.shelf.collection.tab.info;

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

public class CollectionInfoTabView_CollectionInfoTabViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabView>, org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabView.CollectionInfoTabViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html2(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html3(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>  <span id='{2}'></span>")
    SafeHtml html4(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html5(String arg0, String arg1, String arg2);
     
    @Template("")
    SafeHtml html6();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html7(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html8(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html9(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html10(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html11(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html12(String arg0, String arg1, String arg2, String arg3);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html13(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html14(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html15(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html16(String arg0, String arg1, String arg2);
     
    @Template("")
    SafeHtml html17();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html18(String arg0, String arg1, String arg2);
     
    @Template("")
    SafeHtml html19();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html20(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span>")
    SafeHtml html21(String arg0, String arg1, String arg2, String arg3, String arg4);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html22(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html23(String arg0, String arg1);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabView owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onAddCourseClick(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickRemoveCourseBtn(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickHidePrimaryContainer(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickHideSecondaryContainer(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onAddStandardsClick(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabView owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_domId18();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId20();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId22();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId24();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId27();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId29();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId31();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId17();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId19();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId21();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId23();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId26();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId28();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId30();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId33();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId34();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId35();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId37();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId38();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId39();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId15();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId16();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId25();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId32();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId36();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId14();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId18Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId20Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId22Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId24Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId27Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId29Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId31Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId17Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId19Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId21Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId23Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId26Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId28Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId30Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId33Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId34Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId35Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId37Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId38Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId39Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId15Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId16Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId25Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId32Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId36Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId14Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2(get_domId2(), get_domId3());
    }
    SafeHtml template_html3() {
      return template.html3(get_domId5());
    }
    SafeHtml template_html4() {
      return template.html4(get_domId7(), get_domId8(), get_domId9());
    }
    SafeHtml template_html5() {
      return template.html5(get_domId1(), get_domId4(), get_domId6());
    }
    SafeHtml template_html6() {
      return template.html6();
    }
    SafeHtml template_html7() {
      return template.html7(get_domId12(), get_domId13());
    }
    SafeHtml template_html8() {
      return template.html8(get_domId18());
    }
    SafeHtml template_html9() {
      return template.html9(get_domId20());
    }
    SafeHtml template_html10() {
      return template.html10(get_domId22());
    }
    SafeHtml template_html11() {
      return template.html11(get_domId24());
    }
    SafeHtml template_html12() {
      return template.html12(get_domId17(), get_domId19(), get_domId21(), get_domId23());
    }
    SafeHtml template_html13() {
      return template.html13(get_domId27());
    }
    SafeHtml template_html14() {
      return template.html14(get_domId29());
    }
    SafeHtml template_html15() {
      return template.html15(get_domId31());
    }
    SafeHtml template_html16() {
      return template.html16(get_domId26(), get_domId28(), get_domId30());
    }
    SafeHtml template_html17() {
      return template.html17();
    }
    SafeHtml template_html18() {
      return template.html18(get_domId33(), get_domId34(), get_domId35());
    }
    SafeHtml template_html19() {
      return template.html19();
    }
    SafeHtml template_html20() {
      return template.html20(get_domId37(), get_domId38(), get_domId39());
    }
    SafeHtml template_html21() {
      return template.html21(get_domId15(), get_domId16(), get_domId25(), get_domId32(), get_domId36());
    }
    SafeHtml template_html22() {
      return template.html22(get_domId11(), get_domId14());
    }
    SafeHtml template_html23() {
      return template.html23(get_domId0(), get_domId10());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabView_CollectionInfoTabViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabView_CollectionInfoTabViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabView_CollectionInfoTabViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabView_CollectionInfoTabViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabView_CollectionInfoTabViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 94 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle res;
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle build_res() {
      // Creation section.
      res = owner.res;
      assert res != null : "UiField res with 'provided = true' was null";
      // Setup section.


      return res;
    }

    /**
     * Getter for res1 called 1 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignCBundle get_res1() {
      return build_res1();
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignCBundle build_res1() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignCBundle res1 = (org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignCBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignCBundle.class);
      // Setup section.


      return res1;
    }

    /**
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html23().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2018 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId0Element().get();
      get_domId10Element().get();

      // Detach section.
      attachRecord2018.detach();
      f_HTMLPanel1.addAndReplaceElement(get_f_HTMLPanel2(), get_domId0Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_f_HTMLPanel13(), get_domId10Element().get());

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
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_res().css().infoContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2019 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_domId1Element().get();
      get_domId4Element().get();
      get_domId6Element().get();

      // Detach section.
      attachRecord2019.detach();
      f_HTMLPanel2.addAndReplaceElement(get_f_HTMLPanel3(), get_domId1Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_panelLoading(), get_domId4Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_mainInfoPanel(), get_domId6Element().get());

      return f_HTMLPanel2;
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
     * Getter for f_HTMLPanel3 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel3() {
      return build_f_HTMLPanel3();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      f_HTMLPanel3.setStyleName("" + get_res().css().primaryLabelContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2020 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
      get_domId2Element().get();
      get_domId3Element().get();

      // Detach section.
      attachRecord2020.detach();
      f_HTMLPanel3.addAndReplaceElement(get_primaryLabelTag(), get_domId2Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_toggleArrowButtonPrimary(), get_domId3Element().get());

      return f_HTMLPanel3;
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
     * Getter for primaryLabelTag called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_primaryLabelTag() {
      return build_primaryLabelTag();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_primaryLabelTag() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel primaryLabelTag = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      primaryLabelTag.setStyleName("" + get_res().css().primaryLabel() + "");


      owner.primaryLabelTag = primaryLabelTag;

      return primaryLabelTag;
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
     * Getter for toggleArrowButtonPrimary called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_toggleArrowButtonPrimary() {
      return build_toggleArrowButtonPrimary();
    }
    private com.google.gwt.user.client.ui.Label build_toggleArrowButtonPrimary() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label toggleArrowButtonPrimary = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      toggleArrowButtonPrimary.setStyleName("" + get_res().css().primaryToggleArrowBottom() + "");
      toggleArrowButtonPrimary.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);


      owner.toggleArrowButtonPrimary = toggleArrowButtonPrimary;

      return toggleArrowButtonPrimary;
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
     * Getter for panelLoading called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelLoading() {
      return build_panelLoading();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelLoading() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelLoading = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2021 = UiBinderUtil.attachToDom(panelLoading.getElement());
      get_domId5Element().get();

      // Detach section.
      attachRecord2021.detach();
      panelLoading.addAndReplaceElement(get_f_Label4(), get_domId5Element().get());

      owner.panelLoading = panelLoading;

      return panelLoading;
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
     * Getter for f_Label4 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label4() {
      return build_f_Label4();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label4() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label4 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label4.setStyleName("" + get_res1().css().loadingpanelImage() + "");


      return f_Label4;
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
     * Getter for mainInfoPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_mainInfoPanel() {
      return build_mainInfoPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_mainInfoPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel mainInfoPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      mainInfoPanel.setStyleName("" + get_res().css().infoContainerMargin() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2022 = UiBinderUtil.attachToDom(mainInfoPanel.getElement());
      get_domId7Element().get();
      get_domId8Element().get();
      get_domId9Element().get();

      // Detach section.
      attachRecord2022.detach();
      mainInfoPanel.addAndReplaceElement(get_f_FlowPanel5(), get_domId7Element().get());
      mainInfoPanel.addAndReplaceElement(get_f_FlowPanel8(), get_domId8Element().get());
      mainInfoPanel.addAndReplaceElement(get_standardContainer(), get_domId9Element().get());

      owner.mainInfoPanel = mainInfoPanel;

      return mainInfoPanel;
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
     * Getter for f_FlowPanel5 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel5() {
      return build_f_FlowPanel5();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel5 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel5.add(get_f_FlowPanel6());
      f_FlowPanel5.add(get_selectGradeLbl());
      f_FlowPanel5.add(get_KinderGarten());
      f_FlowPanel5.add(get_f_FlowPanel7());
      f_FlowPanel5.add(get_higherEducation());
      f_FlowPanel5.setStyleName("" + get_res().css().gradeInfoContainer() + "");


      return f_FlowPanel5;
    }

    /**
     * Getter for f_FlowPanel6 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel6() {
      return build_f_FlowPanel6();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel6() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel6 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel6.add(get_gradeLbl());
      f_FlowPanel6.setStyleName("" + get_res().css().gradeInfoTitleContainer() + "");


      return f_FlowPanel6;
    }

    /**
     * Getter for gradeLbl called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_gradeLbl() {
      return build_gradeLbl();
    }
    private com.google.gwt.user.client.ui.Label build_gradeLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label gradeLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      gradeLbl.setStyleName("" + get_res().css().shelfGradeInfoTitle() + "");


      owner.gradeLbl = gradeLbl;

      return gradeLbl;
    }

    /**
     * Getter for selectGradeLbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_selectGradeLbl() {
      return build_selectGradeLbl();
    }
    private com.google.gwt.user.client.ui.Label build_selectGradeLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label selectGradeLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      selectGradeLbl.setStyleName("" + get_res().css().shelfGradeInfoBottom() + "");


      owner.selectGradeLbl = selectGradeLbl;

      return selectGradeLbl;
    }

    /**
     * Getter for KinderGarten called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_KinderGarten() {
      return build_KinderGarten();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_KinderGarten() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel KinderGarten = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      KinderGarten.setStyleName("" + get_res().css().shelfGradeInfogardenContainer() + "");


      owner.KinderGarten = KinderGarten;

      return KinderGarten;
    }

    /**
     * Getter for f_FlowPanel7 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel7() {
      return build_f_FlowPanel7();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel7() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel7 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel7.add(get_gradeTopList());
      f_FlowPanel7.add(get_gradeMiddleList());
      f_FlowPanel7.add(get_gradeBottomList());
      f_FlowPanel7.setStyleName("" + get_res().css().gradeListCont() + "");


      return f_FlowPanel7;
    }

    /**
     * Getter for gradeTopList called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_gradeTopList() {
      return build_gradeTopList();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_gradeTopList() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel gradeTopList = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      owner.gradeTopList = gradeTopList;

      return gradeTopList;
    }

    /**
     * Getter for gradeMiddleList called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_gradeMiddleList() {
      return build_gradeMiddleList();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_gradeMiddleList() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel gradeMiddleList = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      owner.gradeMiddleList = gradeMiddleList;

      return gradeMiddleList;
    }

    /**
     * Getter for gradeBottomList called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_gradeBottomList() {
      return build_gradeBottomList();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_gradeBottomList() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel gradeBottomList = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      owner.gradeBottomList = gradeBottomList;

      return gradeBottomList;
    }

    /**
     * Getter for higherEducation called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_higherEducation() {
      return build_higherEducation();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_higherEducation() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel higherEducation = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      higherEducation.setStyleName("" + get_res().css().shelfGradeInfogardenContainer() + "");


      owner.higherEducation = higherEducation;

      return higherEducation;
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
      f_FlowPanel8.add(get_f_FlowPanel9());
      f_FlowPanel8.add(get_selectCourseLbl());
      f_FlowPanel8.add(get_courseData());
      f_FlowPanel8.add(get_addCourseBtn());
      f_FlowPanel8.add(get_removeCourseBtn());
      f_FlowPanel8.setStyleName("" + get_res().css().gradeInfoContainer() + "");


      return f_FlowPanel8;
    }

    /**
     * Getter for f_FlowPanel9 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel9() {
      return build_f_FlowPanel9();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel9() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel9 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel9.add(get_courseLabel());
      f_FlowPanel9.setStyleName("" + get_res().css().gradeInfoTitleContainer() + "");


      return f_FlowPanel9;
    }

    /**
     * Getter for courseLabel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_courseLabel() {
      return build_courseLabel();
    }
    private com.google.gwt.user.client.ui.Label build_courseLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label courseLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      courseLabel.setStyleName("" + get_res().css().shelfGradeInfoTitle() + "");


      owner.courseLabel = courseLabel;

      return courseLabel;
    }

    /**
     * Getter for selectCourseLbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_selectCourseLbl() {
      return build_selectCourseLbl();
    }
    private com.google.gwt.user.client.ui.Label build_selectCourseLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label selectCourseLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      selectCourseLbl.setStyleName("" + get_res().css().shelfGradeSelectResources() + "");


      owner.selectCourseLbl = selectCourseLbl;

      return selectCourseLbl;
    }

    /**
     * Getter for courseData called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_courseData() {
      return build_courseData();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_courseData() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel courseData = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      courseData.add(get_courseLbl());
      courseData.setStyleName("" + get_res().css().floatLeftCollectionInputBox() + "");


      owner.courseData = courseData;

      return courseData;
    }

    /**
     * Getter for courseLbl called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_courseLbl() {
      return build_courseLbl();
    }
    private com.google.gwt.user.client.ui.Label build_courseLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label courseLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      courseLbl.setStyleName("" + get_res().css().addedCoursesList() + "");


      owner.courseLbl = courseLbl;

      return courseLbl;
    }

    /**
     * Getter for addCourseBtn called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Button get_addCourseBtn() {
      return build_addCourseBtn();
    }
    private com.google.gwt.user.client.ui.Button build_addCourseBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button addCourseBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      addCourseBtn.setStyleName("secondary");
      addCourseBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.addCourseBtn = addCourseBtn;

      return addCourseBtn;
    }

    /**
     * Getter for removeCourseBtn called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Button get_removeCourseBtn() {
      return build_removeCourseBtn();
    }
    private com.google.gwt.user.client.ui.Button build_removeCourseBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button removeCourseBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      removeCourseBtn.setStyleName("secondary");
      removeCourseBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.removeCourseBtn = removeCourseBtn;

      return removeCourseBtn;
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
     * Getter for standardContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_standardContainer() {
      return build_standardContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_standardContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel standardContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      standardContainer.add(get_standardLabel());
      standardContainer.add(get_standardsDefaultText());
      standardContainer.add(get_f_FlowPanel10());


      owner.standardContainer = standardContainer;

      return standardContainer;
    }

    /**
     * Getter for standardLabel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_standardLabel() {
      return build_standardLabel();
    }
    private com.google.gwt.user.client.ui.Label build_standardLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label standardLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      standardLabel.setStyleName("" + get_res().css().shelfVocabularyStandard() + "");


      owner.standardLabel = standardLabel;

      return standardLabel;
    }

    /**
     * Getter for standardsDefaultText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_standardsDefaultText() {
      return build_standardsDefaultText();
    }
    private com.google.gwt.user.client.ui.Label build_standardsDefaultText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label standardsDefaultText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      standardsDefaultText.setStyleName("" + get_res().css().shelfGradeInfoBottom() + "");


      owner.standardsDefaultText = standardsDefaultText;

      return standardsDefaultText;
    }

    /**
     * Getter for f_FlowPanel10 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel10() {
      return build_f_FlowPanel10();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel10() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel10 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel10.add(get_f_FlowPanel11());
      f_FlowPanel10.setStyleName("" + get_res().css().shelfCourseSubject() + "");


      return f_FlowPanel10;
    }

    /**
     * Getter for f_FlowPanel11 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel11() {
      return build_f_FlowPanel11();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel11() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel11 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel11.add(get_f_FlowPanel12());
      f_FlowPanel11.setStyleName("" + get_res().css().shelfNameCourse() + "");


      return f_FlowPanel11;
    }

    /**
     * Getter for f_FlowPanel12 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel12() {
      return build_f_FlowPanel12();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel12() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel12 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel12.add(get_standardSgstBox());
      f_FlowPanel12.add(get_addStandardBtn());
      f_FlowPanel12.add(get_standardMaxMsg());
      f_FlowPanel12.add(get_standardsPanel());
      f_FlowPanel12.setStyleName("" + get_res().css().standardsCont() + "");


      return f_FlowPanel12;
    }

    /**
     * Getter for standardSgstBox called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private org.ednovo.gooru.client.uc.AppSuggestBox get_standardSgstBox() {
      return build_standardSgstBox();
    }
    private org.ednovo.gooru.client.uc.AppSuggestBox build_standardSgstBox() {
      // Creation section.
      final org.ednovo.gooru.client.uc.AppSuggestBox standardSgstBox = owner.standardSgstBox;
      assert standardSgstBox != null : "UiField standardSgstBox with 'provided = true' was null";
      // Setup section.
      standardSgstBox.setHeight("19px");
      standardSgstBox.setWidth("277px");


      return standardSgstBox;
    }

    /**
     * Getter for addStandardBtn called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Button get_addStandardBtn() {
      return build_addStandardBtn();
    }
    private com.google.gwt.user.client.ui.Button build_addStandardBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button addStandardBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      addStandardBtn.setStyleName("" + get_res().css().infoAddButton() + "");
      addStandardBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5);


      owner.addStandardBtn = addStandardBtn;

      return addStandardBtn;
    }

    /**
     * Getter for standardMaxMsg called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Label get_standardMaxMsg() {
      return build_standardMaxMsg();
    }
    private com.google.gwt.user.client.ui.Label build_standardMaxMsg() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label standardMaxMsg = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      standardMaxMsg.setStyleName("" + get_res().css().standardMaxHide() + "");


      owner.standardMaxMsg = standardMaxMsg;

      return standardMaxMsg;
    }

    /**
     * Getter for standardsPanel called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_standardsPanel() {
      return build_standardsPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_standardsPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel standardsPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      standardsPanel.setStyleName("" + get_res().css().collectionStandardsMargin() + "");


      owner.standardsPanel = standardsPanel;

      return standardsPanel;
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
     * Getter for domId10 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for f_HTMLPanel13 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel13() {
      return build_f_HTMLPanel13();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel13() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel13 = new com.google.gwt.user.client.ui.HTMLPanel(template_html22().asString());
      // Setup section.
      f_HTMLPanel13.setStyleName("" + get_res().css().secondaryInformationContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2023 = UiBinderUtil.attachToDom(f_HTMLPanel13.getElement());
      get_domId11Element().get();
      get_domId14Element().get();

      // Detach section.
      attachRecord2023.detach();
      f_HTMLPanel13.addAndReplaceElement(get_f_HTMLPanel14(), get_domId11Element().get());
      f_HTMLPanel13.addAndReplaceElement(get_secondaryContentsContainer(), get_domId14Element().get());

      return f_HTMLPanel13;
    }

    /**
     * Getter for domId11 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for f_HTMLPanel14 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel14() {
      return build_f_HTMLPanel14();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel14() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel14 = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.
      f_HTMLPanel14.setStyleName("" + get_res().css().secondaryLabelContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2024 = UiBinderUtil.attachToDom(f_HTMLPanel14.getElement());
      get_domId12Element().get();
      get_domId13Element().get();

      // Detach section.
      attachRecord2024.detach();
      f_HTMLPanel14.addAndReplaceElement(get_secondaryHeaderLabel(), get_domId12Element().get());
      f_HTMLPanel14.addAndReplaceElement(get_toggleArrowButtonSecondary(), get_domId13Element().get());

      return f_HTMLPanel14;
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
     * Getter for secondaryHeaderLabel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_secondaryHeaderLabel() {
      return build_secondaryHeaderLabel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_secondaryHeaderLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel secondaryHeaderLabel = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.
      secondaryHeaderLabel.setStyleName("" + get_res().css().primaryLabel() + "");


      owner.secondaryHeaderLabel = secondaryHeaderLabel;

      return secondaryHeaderLabel;
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
     * Getter for domId13 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for toggleArrowButtonSecondary called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_toggleArrowButtonSecondary() {
      return build_toggleArrowButtonSecondary();
    }
    private com.google.gwt.user.client.ui.Label build_toggleArrowButtonSecondary() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label toggleArrowButtonSecondary = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      toggleArrowButtonSecondary.setStyleName("" + get_res().css().primaryToggleArrowBottom() + "");
      toggleArrowButtonSecondary.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);


      owner.toggleArrowButtonSecondary = toggleArrowButtonSecondary;

      return toggleArrowButtonSecondary;
    }

    /**
     * Getter for domId13Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId11Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId14 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for secondaryContentsContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_secondaryContentsContainer() {
      return build_secondaryContentsContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_secondaryContentsContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel secondaryContentsContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html21().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2025 = UiBinderUtil.attachToDom(secondaryContentsContainer.getElement());
      get_domId15Element().get();
      get_domId16Element().get();
      get_domId25Element().get();
      get_domId32Element().get();
      get_domId36Element().get();

      // Detach section.
      attachRecord2025.detach();
      secondaryContentsContainer.addAndReplaceElement(get_f_FlowPanel15(), get_domId15Element().get());
      secondaryContentsContainer.addAndReplaceElement(get_f_FlowPanel23(), get_domId16Element().get());
      secondaryContentsContainer.addAndReplaceElement(get_f_FlowPanel36(), get_domId25Element().get());
      secondaryContentsContainer.addAndReplaceElement(get_f_FlowPanel48(), get_domId32Element().get());
      secondaryContentsContainer.addAndReplaceElement(get_f_FlowPanel57(), get_domId36Element().get());

      owner.secondaryContentsContainer = secondaryContentsContainer;

      return secondaryContentsContainer;
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
     * Getter for f_FlowPanel15 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel15() {
      return build_f_FlowPanel15();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel15() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel15 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel15.add(get_f_FlowPanel16());
      f_FlowPanel15.add(get_languageObjectiveTitle());
      f_FlowPanel15.add(get_f_FlowPanel17());
      f_FlowPanel15.add(get_f_FlowPanel18());
      f_FlowPanel15.add(get_f_FlowPanel22());
      f_FlowPanel15.setStyleName("" + get_res().css().languageObjectiveContainer() + "");


      return f_FlowPanel15;
    }

    /**
     * Getter for f_FlowPanel16 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel16() {
      return build_f_FlowPanel16();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel16() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel16 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel16.add(get_languageObjectiveHeader());
      f_FlowPanel16.setStyleName("" + get_res().css().gradeInfoTitleContainer() + " " + get_res().css().languageObjectives() + "");


      return f_FlowPanel16;
    }

    /**
     * Getter for languageObjectiveHeader called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_languageObjectiveHeader() {
      return build_languageObjectiveHeader();
    }
    private com.google.gwt.user.client.ui.Label build_languageObjectiveHeader() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label languageObjectiveHeader = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      languageObjectiveHeader.setStyleName("" + get_res().css().shelfGradeInfoTitle() + "");


      owner.languageObjectiveHeader = languageObjectiveHeader;

      return languageObjectiveHeader;
    }

    /**
     * Getter for languageObjectiveTitle called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_languageObjectiveTitle() {
      return build_languageObjectiveTitle();
    }
    private com.google.gwt.user.client.ui.Label build_languageObjectiveTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label languageObjectiveTitle = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      languageObjectiveTitle.setStyleName("" + get_res().css().shelfGradeInfoBottom() + "");


      return languageObjectiveTitle;
    }

    /**
     * Getter for f_FlowPanel17 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel17() {
      return build_f_FlowPanel17();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel17() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel17 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel17.add(get_textAreaVal());
      f_FlowPanel17.add(get_languageObjectiveerrLabel());
      f_FlowPanel17.setStyleName("" + get_res().css().languageObjectiveInfoContainer() + "");


      return f_FlowPanel17;
    }

    /**
     * Getter for textAreaVal called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.TextArea get_textAreaVal() {
      return build_textAreaVal();
    }
    private com.google.gwt.user.client.ui.TextArea build_textAreaVal() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextArea textAreaVal = (com.google.gwt.user.client.ui.TextArea) GWT.create(com.google.gwt.user.client.ui.TextArea.class);
      // Setup section.
      textAreaVal.setStyleName("" + get_res().css().languageObjectiveTextArea() + "");


      owner.textAreaVal = textAreaVal;

      return textAreaVal;
    }

    /**
     * Getter for languageObjectiveerrLabel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_languageObjectiveerrLabel() {
      return build_languageObjectiveerrLabel();
    }
    private com.google.gwt.user.client.ui.Label build_languageObjectiveerrLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label languageObjectiveerrLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      languageObjectiveerrLabel.setStyleName("" + get_res().css().errorLabelColor() + "");


      owner.languageObjectiveerrLabel = languageObjectiveerrLabel;

      return languageObjectiveerrLabel;
    }

    /**
     * Getter for f_FlowPanel18 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel18() {
      return build_f_FlowPanel18();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel18() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel18 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel18.add(get_f_FlowPanel19());
      f_FlowPanel18.add(get_f_FlowPanel20());
      f_FlowPanel18.add(get_f_FlowPanel21());
      f_FlowPanel18.setStyleName("" + get_res().css().gradeListCont() + "");


      return f_FlowPanel18;
    }

    /**
     * Getter for f_FlowPanel19 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel19() {
      return build_f_FlowPanel19();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel19() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel19 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      return f_FlowPanel19;
    }

    /**
     * Getter for f_FlowPanel20 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel20() {
      return build_f_FlowPanel20();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel20() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel20 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      return f_FlowPanel20;
    }

    /**
     * Getter for f_FlowPanel21 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel21() {
      return build_f_FlowPanel21();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel21() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel21 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      return f_FlowPanel21;
    }

    /**
     * Getter for f_FlowPanel22 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel22() {
      return build_f_FlowPanel22();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel22() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel22 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel22.setStyleName("" + get_res().css().shelfGradeInfogardenContainer() + "");


      return f_FlowPanel22;
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
     * Getter for f_FlowPanel23 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel23() {
      return build_f_FlowPanel23();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel23() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel23 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel23.add(get_f_FlowPanel24());
      f_FlowPanel23.add(get_depthOfKnowledgeTitle());
      f_FlowPanel23.add(get_f_FlowPanel25());
      f_FlowPanel23.add(get_f_FlowPanel31());
      f_FlowPanel23.add(get_f_FlowPanel35());
      f_FlowPanel23.setStyleName("" + get_res().css().depthOfKnowledgeContainer() + "");


      return f_FlowPanel23;
    }

    /**
     * Getter for f_FlowPanel24 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel24() {
      return build_f_FlowPanel24();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel24() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel24 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel24.add(get_depthOfKnowledgeHeader());
      f_FlowPanel24.setStyleName("" + get_res().css().gradeInfoTitleContainer() + " " + get_res().css().deptOfKnowledge() + "");


      return f_FlowPanel24;
    }

    /**
     * Getter for depthOfKnowledgeHeader called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_depthOfKnowledgeHeader() {
      return build_depthOfKnowledgeHeader();
    }
    private com.google.gwt.user.client.ui.Label build_depthOfKnowledgeHeader() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label depthOfKnowledgeHeader = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      depthOfKnowledgeHeader.setStyleName("" + get_res().css().shelfGradeInfoTitle() + "");


      owner.depthOfKnowledgeHeader = depthOfKnowledgeHeader;

      return depthOfKnowledgeHeader;
    }

    /**
     * Getter for depthOfKnowledgeTitle called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_depthOfKnowledgeTitle() {
      return build_depthOfKnowledgeTitle();
    }
    private com.google.gwt.user.client.ui.Label build_depthOfKnowledgeTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label depthOfKnowledgeTitle = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      depthOfKnowledgeTitle.setStyleName("" + get_res().css().shelfGradeInfoBottom() + "");


      owner.depthOfKnowledgeTitle = depthOfKnowledgeTitle;

      return depthOfKnowledgeTitle;
    }

    /**
     * Getter for f_FlowPanel25 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel25() {
      return build_f_FlowPanel25();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel25() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel25 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel25.add(get_f_HTMLPanel26());
      f_FlowPanel25.setStyleName("" + get_res().css().languageObjectiveInfoContainer() + "");


      return f_FlowPanel25;
    }

    /**
     * Getter for f_HTMLPanel26 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel26() {
      return build_f_HTMLPanel26();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel26() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel26 = new com.google.gwt.user.client.ui.HTMLPanel(template_html12().asString());
      // Setup section.
      f_HTMLPanel26.setStyleName("" + get_res().css().checkBoxOuterContiner() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2026 = UiBinderUtil.attachToDom(f_HTMLPanel26.getElement());
      get_domId17Element().get();
      get_domId19Element().get();
      get_domId21Element().get();
      get_domId23Element().get();

      // Detach section.
      attachRecord2026.detach();
      f_HTMLPanel26.addAndReplaceElement(get_f_HTMLPanel27(), get_domId17Element().get());
      f_HTMLPanel26.addAndReplaceElement(get_f_HTMLPanel28(), get_domId19Element().get());
      f_HTMLPanel26.addAndReplaceElement(get_f_HTMLPanel29(), get_domId21Element().get());
      f_HTMLPanel26.addAndReplaceElement(get_f_HTMLPanel30(), get_domId23Element().get());

      return f_HTMLPanel26;
    }

    /**
     * Getter for domId17 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for f_HTMLPanel27 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel27() {
      return build_f_HTMLPanel27();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel27() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel27 = new com.google.gwt.user.client.ui.HTMLPanel(template_html8().asString());
      // Setup section.
      f_HTMLPanel27.setStyleName("" + get_res().css().checkBoxinnerContiner() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2027 = UiBinderUtil.attachToDom(f_HTMLPanel27.getElement());
      get_domId18Element().get();

      // Detach section.
      attachRecord2027.detach();
      f_HTMLPanel27.addAndReplaceElement(get_chkLevelRecall(), get_domId18Element().get());

      return f_HTMLPanel27;
    }

    /**
     * Getter for domId18 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for chkLevelRecall called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.CheckBox get_chkLevelRecall() {
      return build_chkLevelRecall();
    }
    private com.google.gwt.user.client.ui.CheckBox build_chkLevelRecall() {
      // Creation section.
      final com.google.gwt.user.client.ui.CheckBox chkLevelRecall = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
      // Setup section.
      chkLevelRecall.setStyleName("" + get_res().css().checkBoxlevels() + "");


      owner.chkLevelRecall = chkLevelRecall;

      return chkLevelRecall;
    }

    /**
     * Getter for domId18Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId17Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId19 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for f_HTMLPanel28 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel28() {
      return build_f_HTMLPanel28();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel28() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel28 = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      f_HTMLPanel28.setStyleName("" + get_res().css().checkBoxinnerContinerlevel2() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2028 = UiBinderUtil.attachToDom(f_HTMLPanel28.getElement());
      get_domId20Element().get();

      // Detach section.
      attachRecord2028.detach();
      f_HTMLPanel28.addAndReplaceElement(get_chkLevelSkillConcept(), get_domId20Element().get());

      return f_HTMLPanel28;
    }

    /**
     * Getter for domId20 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for chkLevelSkillConcept called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.CheckBox get_chkLevelSkillConcept() {
      return build_chkLevelSkillConcept();
    }
    private com.google.gwt.user.client.ui.CheckBox build_chkLevelSkillConcept() {
      // Creation section.
      final com.google.gwt.user.client.ui.CheckBox chkLevelSkillConcept = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
      // Setup section.
      chkLevelSkillConcept.setStyleName("" + get_res().css().checkBoxlevels() + "");


      owner.chkLevelSkillConcept = chkLevelSkillConcept;

      return chkLevelSkillConcept;
    }

    /**
     * Getter for domId20Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId19Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId21 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for f_HTMLPanel29 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel29() {
      return build_f_HTMLPanel29();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel29() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel29 = new com.google.gwt.user.client.ui.HTMLPanel(template_html10().asString());
      // Setup section.
      f_HTMLPanel29.setStyleName("" + get_res().css().checkBoxinnerContinerlevel3() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2029 = UiBinderUtil.attachToDom(f_HTMLPanel29.getElement());
      get_domId22Element().get();

      // Detach section.
      attachRecord2029.detach();
      f_HTMLPanel29.addAndReplaceElement(get_chkLevelStrategicThinking(), get_domId22Element().get());

      return f_HTMLPanel29;
    }

    /**
     * Getter for domId22 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for chkLevelStrategicThinking called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.CheckBox get_chkLevelStrategicThinking() {
      return build_chkLevelStrategicThinking();
    }
    private com.google.gwt.user.client.ui.CheckBox build_chkLevelStrategicThinking() {
      // Creation section.
      final com.google.gwt.user.client.ui.CheckBox chkLevelStrategicThinking = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
      // Setup section.
      chkLevelStrategicThinking.setStyleName("" + get_res().css().checkBoxlevels() + "");


      owner.chkLevelStrategicThinking = chkLevelStrategicThinking;

      return chkLevelStrategicThinking;
    }

    /**
     * Getter for domId22Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId21Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId23 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for f_HTMLPanel30 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel30() {
      return build_f_HTMLPanel30();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel30() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel30 = new com.google.gwt.user.client.ui.HTMLPanel(template_html11().asString());
      // Setup section.
      f_HTMLPanel30.setStyleName("" + get_res().css().checkBoxinnerContinerlevel4() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2030 = UiBinderUtil.attachToDom(f_HTMLPanel30.getElement());
      get_domId24Element().get();

      // Detach section.
      attachRecord2030.detach();
      f_HTMLPanel30.addAndReplaceElement(get_chkLevelExtendedThinking(), get_domId24Element().get());

      return f_HTMLPanel30;
    }

    /**
     * Getter for domId24 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for chkLevelExtendedThinking called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.CheckBox get_chkLevelExtendedThinking() {
      return build_chkLevelExtendedThinking();
    }
    private com.google.gwt.user.client.ui.CheckBox build_chkLevelExtendedThinking() {
      // Creation section.
      final com.google.gwt.user.client.ui.CheckBox chkLevelExtendedThinking = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
      // Setup section.
      chkLevelExtendedThinking.setStyleName("" + get_res().css().checkBoxlevels() + "");


      owner.chkLevelExtendedThinking = chkLevelExtendedThinking;

      return chkLevelExtendedThinking;
    }

    /**
     * Getter for domId24Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId23Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for f_FlowPanel31 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel31() {
      return build_f_FlowPanel31();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel31() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel31 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel31.add(get_f_FlowPanel32());
      f_FlowPanel31.add(get_f_FlowPanel33());
      f_FlowPanel31.add(get_f_FlowPanel34());
      f_FlowPanel31.setStyleName("" + get_res().css().gradeListCont() + "");


      return f_FlowPanel31;
    }

    /**
     * Getter for f_FlowPanel32 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel32() {
      return build_f_FlowPanel32();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel32() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel32 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      return f_FlowPanel32;
    }

    /**
     * Getter for f_FlowPanel33 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel33() {
      return build_f_FlowPanel33();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel33() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel33 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      return f_FlowPanel33;
    }

    /**
     * Getter for f_FlowPanel34 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel34() {
      return build_f_FlowPanel34();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel34() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel34 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      return f_FlowPanel34;
    }

    /**
     * Getter for f_FlowPanel35 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel35() {
      return build_f_FlowPanel35();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel35() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel35 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel35.setStyleName("" + get_res().css().shelfGradeInfogardenContainer() + "");


      return f_FlowPanel35;
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
     * Getter for f_FlowPanel36 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel36() {
      return build_f_FlowPanel36();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel36() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel36 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel36.add(get_f_FlowPanel37());
      f_FlowPanel36.add(get_learningInnovationTitle());
      f_FlowPanel36.add(get_f_FlowPanel38());
      f_FlowPanel36.add(get_f_FlowPanel43());
      f_FlowPanel36.add(get_f_FlowPanel47());
      f_FlowPanel36.setStyleName("" + get_res().css().depthOfKnowledgeContainer() + "");


      return f_FlowPanel36;
    }

    /**
     * Getter for f_FlowPanel37 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel37() {
      return build_f_FlowPanel37();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel37() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel37 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel37.add(get_learningInnovationHeader());
      f_FlowPanel37.setStyleName("" + get_res().css().gradeInfoTitleContainer() + " " + get_res().css().learningInnovationSkills() + "");


      return f_FlowPanel37;
    }

    /**
     * Getter for learningInnovationHeader called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_learningInnovationHeader() {
      return build_learningInnovationHeader();
    }
    private com.google.gwt.user.client.ui.Label build_learningInnovationHeader() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label learningInnovationHeader = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      learningInnovationHeader.setStyleName("" + get_res().css().shelfGradeInfoTitle() + "");


      owner.learningInnovationHeader = learningInnovationHeader;

      return learningInnovationHeader;
    }

    /**
     * Getter for learningInnovationTitle called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_learningInnovationTitle() {
      return build_learningInnovationTitle();
    }
    private com.google.gwt.user.client.ui.Label build_learningInnovationTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label learningInnovationTitle = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      learningInnovationTitle.setStyleName("" + get_res().css().shelfGradeInfoBottom() + "");


      owner.learningInnovationTitle = learningInnovationTitle;

      return learningInnovationTitle;
    }

    /**
     * Getter for f_FlowPanel38 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel38() {
      return build_f_FlowPanel38();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel38() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel38 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel38.add(get_f_HTMLPanel39());
      f_FlowPanel38.setStyleName("" + get_res().css().languageObjectiveInfoContainer() + "");


      return f_FlowPanel38;
    }

    /**
     * Getter for f_HTMLPanel39 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel39() {
      return build_f_HTMLPanel39();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel39() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel39 = new com.google.gwt.user.client.ui.HTMLPanel(template_html16().asString());
      // Setup section.
      f_HTMLPanel39.setStyleName("" + get_res().css().checkBoxOuterContiner() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2031 = UiBinderUtil.attachToDom(f_HTMLPanel39.getElement());
      get_domId26Element().get();
      get_domId28Element().get();
      get_domId30Element().get();

      // Detach section.
      attachRecord2031.detach();
      f_HTMLPanel39.addAndReplaceElement(get_f_HTMLPanel40(), get_domId26Element().get());
      f_HTMLPanel39.addAndReplaceElement(get_f_HTMLPanel41(), get_domId28Element().get());
      f_HTMLPanel39.addAndReplaceElement(get_f_HTMLPanel42(), get_domId30Element().get());

      return f_HTMLPanel39;
    }

    /**
     * Getter for domId26 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for f_HTMLPanel40 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel40() {
      return build_f_HTMLPanel40();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel40() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel40 = new com.google.gwt.user.client.ui.HTMLPanel(template_html13().asString());
      // Setup section.
      f_HTMLPanel40.setStyleName("" + get_res().css().checkBoxinnerContinerlearning() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2032 = UiBinderUtil.attachToDom(f_HTMLPanel40.getElement());
      get_domId27Element().get();

      // Detach section.
      attachRecord2032.detach();
      f_HTMLPanel40.addAndReplaceElement(get_learninglevel1(), get_domId27Element().get());

      return f_HTMLPanel40;
    }

    /**
     * Getter for domId27 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for learninglevel1 called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.CheckBox get_learninglevel1() {
      return build_learninglevel1();
    }
    private com.google.gwt.user.client.ui.CheckBox build_learninglevel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.CheckBox learninglevel1 = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
      // Setup section.
      learninglevel1.setStyleName("" + get_res().css().checkBoxlevels() + "");


      owner.learninglevel1 = learninglevel1;

      return learninglevel1;
    }

    /**
     * Getter for domId27Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId26Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId28 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for f_HTMLPanel41 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel41() {
      return build_f_HTMLPanel41();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel41() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel41 = new com.google.gwt.user.client.ui.HTMLPanel(template_html14().asString());
      // Setup section.
      f_HTMLPanel41.setStyleName("" + get_res().css().checkBoxinnerContinerlearninglevel2() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2033 = UiBinderUtil.attachToDom(f_HTMLPanel41.getElement());
      get_domId29Element().get();

      // Detach section.
      attachRecord2033.detach();
      f_HTMLPanel41.addAndReplaceElement(get_learninglevel2(), get_domId29Element().get());

      return f_HTMLPanel41;
    }

    /**
     * Getter for domId29 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
     */
    private java.lang.String domId29;
    private java.lang.String get_domId29() {
      return domId29;
    }
    private java.lang.String build_domId29() {
      // Creation section.
      domId29 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId29;
    }

    /**
     * Getter for learninglevel2 called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.CheckBox get_learninglevel2() {
      return build_learninglevel2();
    }
    private com.google.gwt.user.client.ui.CheckBox build_learninglevel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.CheckBox learninglevel2 = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
      // Setup section.
      learninglevel2.setStyleName("" + get_res().css().checkBoxlevels() + "");


      owner.learninglevel2 = learninglevel2;

      return learninglevel2;
    }

    /**
     * Getter for domId29Element called 2 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId29Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId29Element() {
      return domId29Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId29Element() {
      // Creation section.
      domId29Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId29());
      // Setup section.


      return domId29Element;
    }

    /**
     * Getter for domId28Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId30 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId30;
    private java.lang.String get_domId30() {
      return domId30;
    }
    private java.lang.String build_domId30() {
      // Creation section.
      domId30 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId30;
    }

    /**
     * Getter for f_HTMLPanel42 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel42() {
      return build_f_HTMLPanel42();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel42() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel42 = new com.google.gwt.user.client.ui.HTMLPanel(template_html15().asString());
      // Setup section.
      f_HTMLPanel42.setStyleName("" + get_res().css().checkBoxinnerContinerlearninglevel3() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2034 = UiBinderUtil.attachToDom(f_HTMLPanel42.getElement());
      get_domId31Element().get();

      // Detach section.
      attachRecord2034.detach();
      f_HTMLPanel42.addAndReplaceElement(get_learninglevel3(), get_domId31Element().get());

      return f_HTMLPanel42;
    }

    /**
     * Getter for domId31 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
     */
    private java.lang.String domId31;
    private java.lang.String get_domId31() {
      return domId31;
    }
    private java.lang.String build_domId31() {
      // Creation section.
      domId31 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId31;
    }

    /**
     * Getter for learninglevel3 called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.CheckBox get_learninglevel3() {
      return build_learninglevel3();
    }
    private com.google.gwt.user.client.ui.CheckBox build_learninglevel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.CheckBox learninglevel3 = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
      // Setup section.
      learninglevel3.setStyleName("" + get_res().css().checkBoxlevels() + "");


      owner.learninglevel3 = learninglevel3;

      return learninglevel3;
    }

    /**
     * Getter for domId31Element called 2 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId31Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId31Element() {
      return domId31Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId31Element() {
      // Creation section.
      domId31Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId31());
      // Setup section.


      return domId31Element;
    }

    /**
     * Getter for domId30Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId30Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId30Element() {
      return domId30Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId30Element() {
      // Creation section.
      domId30Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId30());
      // Setup section.


      return domId30Element;
    }

    /**
     * Getter for f_FlowPanel43 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel43() {
      return build_f_FlowPanel43();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel43() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel43 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel43.add(get_f_FlowPanel44());
      f_FlowPanel43.add(get_f_FlowPanel45());
      f_FlowPanel43.add(get_f_FlowPanel46());
      f_FlowPanel43.setStyleName("" + get_res().css().gradeListCont() + "");


      return f_FlowPanel43;
    }

    /**
     * Getter for f_FlowPanel44 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel44() {
      return build_f_FlowPanel44();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel44() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel44 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      return f_FlowPanel44;
    }

    /**
     * Getter for f_FlowPanel45 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel45() {
      return build_f_FlowPanel45();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel45() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel45 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      return f_FlowPanel45;
    }

    /**
     * Getter for f_FlowPanel46 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel46() {
      return build_f_FlowPanel46();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel46() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel46 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      return f_FlowPanel46;
    }

    /**
     * Getter for f_FlowPanel47 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel47() {
      return build_f_FlowPanel47();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel47() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel47 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel47.setStyleName("" + get_res().css().shelfGradeInfogardenContainer() + "");


      return f_FlowPanel47;
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
     * Getter for domId32 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId32;
    private java.lang.String get_domId32() {
      return domId32;
    }
    private java.lang.String build_domId32() {
      // Creation section.
      domId32 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId32;
    }

    /**
     * Getter for f_FlowPanel48 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel48() {
      return build_f_FlowPanel48();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel48() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel48 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel48.add(get_f_FlowPanel49());
      f_FlowPanel48.add(get_instructionalTitle());
      f_FlowPanel48.add(get_f_FlowPanel50());
      f_FlowPanel48.add(get_f_FlowPanel52());
      f_FlowPanel48.add(get_f_FlowPanel56());
      f_FlowPanel48.setStyleName("" + get_res().css().secondaryInfoContainer() + "");


      return f_FlowPanel48;
    }

    /**
     * Getter for f_FlowPanel49 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel49() {
      return build_f_FlowPanel49();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel49() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel49 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel49.add(get_instructionalMethod());
      f_FlowPanel49.setStyleName("" + get_res().css().gradeInfoTitleContainer() + "");


      return f_FlowPanel49;
    }

    /**
     * Getter for instructionalMethod called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_instructionalMethod() {
      return build_instructionalMethod();
    }
    private com.google.gwt.user.client.ui.Label build_instructionalMethod() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label instructionalMethod = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      instructionalMethod.setStyleName("" + get_res().css().shelfGradeInfoTitle() + "");


      owner.instructionalMethod = instructionalMethod;

      return instructionalMethod;
    }

    /**
     * Getter for instructionalTitle called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_instructionalTitle() {
      return build_instructionalTitle();
    }
    private com.google.gwt.user.client.ui.Label build_instructionalTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label instructionalTitle = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      instructionalTitle.setStyleName("" + get_res().css().shelfGradeInfoBottom() + "");


      owner.instructionalTitle = instructionalTitle;

      return instructionalTitle;
    }

    /**
     * Getter for f_FlowPanel50 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel50() {
      return build_f_FlowPanel50();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel50() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel50 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel50.add(get_f_HTMLPanel51());
      f_FlowPanel50.setStyleName("" + get_res().css().shelfGradeInfogardenContainer() + "");


      return f_FlowPanel50;
    }

    /**
     * Getter for f_HTMLPanel51 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel51() {
      return build_f_HTMLPanel51();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel51() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel51 = new com.google.gwt.user.client.ui.HTMLPanel(template_html18().asString());
      // Setup section.
      f_HTMLPanel51.setStyleName("" + get_res().css().dropdownContainerInstructional() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2035 = UiBinderUtil.attachToDom(f_HTMLPanel51.getElement());
      get_domId33Element().get();
      get_domId34Element().get();
      get_domId35Element().get();

      // Detach section.
      attachRecord2035.detach();
      f_HTMLPanel51.addAndReplaceElement(get_lblInstructionalPlaceHolder(), get_domId33Element().get());
      f_HTMLPanel51.addAndReplaceElement(get_lblInstructionalArrow(), get_domId34Element().get());
      f_HTMLPanel51.addAndReplaceElement(get_spanelInstructionalPanel(), get_domId35Element().get());

      return f_HTMLPanel51;
    }

    /**
     * Getter for domId33 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId33;
    private java.lang.String get_domId33() {
      return domId33;
    }
    private java.lang.String build_domId33() {
      // Creation section.
      domId33 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId33;
    }

    /**
     * Getter for lblInstructionalPlaceHolder called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_lblInstructionalPlaceHolder() {
      return build_lblInstructionalPlaceHolder();
    }
    private com.google.gwt.user.client.ui.Label build_lblInstructionalPlaceHolder() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblInstructionalPlaceHolder = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblInstructionalPlaceHolder.setStyleName("" + get_res().css().placeHolderText() + "");


      owner.lblInstructionalPlaceHolder = lblInstructionalPlaceHolder;

      return lblInstructionalPlaceHolder;
    }

    /**
     * Getter for domId33Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId33Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId33Element() {
      return domId33Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId33Element() {
      // Creation section.
      domId33Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId33());
      // Setup section.


      return domId33Element;
    }

    /**
     * Getter for domId34 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId34;
    private java.lang.String get_domId34() {
      return domId34;
    }
    private java.lang.String build_domId34() {
      // Creation section.
      domId34 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId34;
    }

    /**
     * Getter for lblInstructionalArrow called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_lblInstructionalArrow() {
      return build_lblInstructionalArrow();
    }
    private com.google.gwt.user.client.ui.Label build_lblInstructionalArrow() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblInstructionalArrow = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblInstructionalArrow.setStyleName("" + get_res().css().arrowInstructional() + "");


      owner.lblInstructionalArrow = lblInstructionalArrow;

      return lblInstructionalArrow;
    }

    /**
     * Getter for domId34Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId34Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId34Element() {
      return domId34Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId34Element() {
      // Creation section.
      domId34Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId34());
      // Setup section.


      return domId34Element;
    }

    /**
     * Getter for domId35 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId35;
    private java.lang.String get_domId35() {
      return domId35;
    }
    private java.lang.String build_domId35() {
      // Creation section.
      domId35 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId35;
    }

    /**
     * Getter for spanelInstructionalPanel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.ScrollPanel get_spanelInstructionalPanel() {
      return build_spanelInstructionalPanel();
    }
    private com.google.gwt.user.client.ui.ScrollPanel build_spanelInstructionalPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.ScrollPanel spanelInstructionalPanel = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
      // Setup section.
      spanelInstructionalPanel.add(get_htmlInstructionalListContainer());
      spanelInstructionalPanel.setStyleName("" + get_res().css().scrollPanelContainerInstructional() + "");


      owner.spanelInstructionalPanel = spanelInstructionalPanel;

      return spanelInstructionalPanel;
    }

    /**
     * Getter for htmlInstructionalListContainer called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_htmlInstructionalListContainer() {
      return build_htmlInstructionalListContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_htmlInstructionalListContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel htmlInstructionalListContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html17().asString());
      // Setup section.
      htmlInstructionalListContainer.setStyleName("");


      owner.htmlInstructionalListContainer = htmlInstructionalListContainer;

      return htmlInstructionalListContainer;
    }

    /**
     * Getter for domId35Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId35Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId35Element() {
      return domId35Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId35Element() {
      // Creation section.
      domId35Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId35());
      // Setup section.


      return domId35Element;
    }

    /**
     * Getter for f_FlowPanel52 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel52() {
      return build_f_FlowPanel52();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel52() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel52 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel52.add(get_f_FlowPanel53());
      f_FlowPanel52.add(get_f_FlowPanel54());
      f_FlowPanel52.add(get_f_FlowPanel55());
      f_FlowPanel52.setStyleName("" + get_res().css().gradeListCont() + "");


      return f_FlowPanel52;
    }

    /**
     * Getter for f_FlowPanel53 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel53() {
      return build_f_FlowPanel53();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel53() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel53 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      return f_FlowPanel53;
    }

    /**
     * Getter for f_FlowPanel54 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel54() {
      return build_f_FlowPanel54();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel54() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel54 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      return f_FlowPanel54;
    }

    /**
     * Getter for f_FlowPanel55 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel55() {
      return build_f_FlowPanel55();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel55() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel55 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      return f_FlowPanel55;
    }

    /**
     * Getter for f_FlowPanel56 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel56() {
      return build_f_FlowPanel56();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel56() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel56 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel56.setStyleName("" + get_res().css().shelfGradeInfogardenContainer() + "");


      return f_FlowPanel56;
    }

    /**
     * Getter for domId32Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId32Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId32Element() {
      return domId32Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId32Element() {
      // Creation section.
      domId32Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId32());
      // Setup section.


      return domId32Element;
    }

    /**
     * Getter for domId36 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId36;
    private java.lang.String get_domId36() {
      return domId36;
    }
    private java.lang.String build_domId36() {
      // Creation section.
      domId36 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId36;
    }

    /**
     * Getter for f_FlowPanel57 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel57() {
      return build_f_FlowPanel57();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel57() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel57 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel57.add(get_f_FlowPanel58());
      f_FlowPanel57.add(get_audienceTitle());
      f_FlowPanel57.add(get_f_FlowPanel59());
      f_FlowPanel57.add(get_f_FlowPanel61());
      f_FlowPanel57.add(get_f_FlowPanel65());
      f_FlowPanel57.setStyleName("" + get_res().css().secondaryInfoContainer() + "");


      return f_FlowPanel57;
    }

    /**
     * Getter for f_FlowPanel58 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel58() {
      return build_f_FlowPanel58();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel58() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel58 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel58.add(get_audienceLabel());
      f_FlowPanel58.setStyleName("" + get_res().css().gradeInfoTitleContainer() + "");


      return f_FlowPanel58;
    }

    /**
     * Getter for audienceLabel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_audienceLabel() {
      return build_audienceLabel();
    }
    private com.google.gwt.user.client.ui.Label build_audienceLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label audienceLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      audienceLabel.setStyleName("" + get_res().css().shelfGradeInfoTitle() + "");


      owner.audienceLabel = audienceLabel;

      return audienceLabel;
    }

    /**
     * Getter for audienceTitle called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_audienceTitle() {
      return build_audienceTitle();
    }
    private com.google.gwt.user.client.ui.Label build_audienceTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label audienceTitle = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      audienceTitle.setStyleName("" + get_res().css().shelfGradeInfoBottom() + "");


      owner.audienceTitle = audienceTitle;

      return audienceTitle;
    }

    /**
     * Getter for f_FlowPanel59 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel59() {
      return build_f_FlowPanel59();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel59() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel59 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel59.add(get_f_HTMLPanel60());
      f_FlowPanel59.setStyleName("" + get_res().css().shelfGradeInfogardenContainer() + "");


      return f_FlowPanel59;
    }

    /**
     * Getter for f_HTMLPanel60 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel60() {
      return build_f_HTMLPanel60();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel60() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel60 = new com.google.gwt.user.client.ui.HTMLPanel(template_html20().asString());
      // Setup section.
      f_HTMLPanel60.setStyleName("" + get_res().css().dropdownContainerInstructional() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2036 = UiBinderUtil.attachToDom(f_HTMLPanel60.getElement());
      get_domId37Element().get();
      get_domId38Element().get();
      get_domId39Element().get();

      // Detach section.
      attachRecord2036.detach();
      f_HTMLPanel60.addAndReplaceElement(get_lblAudiencePlaceHolder(), get_domId37Element().get());
      f_HTMLPanel60.addAndReplaceElement(get_lblAudienceArrow(), get_domId38Element().get());
      f_HTMLPanel60.addAndReplaceElement(get_spanelAudiencePanel(), get_domId39Element().get());

      return f_HTMLPanel60;
    }

    /**
     * Getter for domId37 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId37;
    private java.lang.String get_domId37() {
      return domId37;
    }
    private java.lang.String build_domId37() {
      // Creation section.
      domId37 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId37;
    }

    /**
     * Getter for lblAudiencePlaceHolder called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_lblAudiencePlaceHolder() {
      return build_lblAudiencePlaceHolder();
    }
    private com.google.gwt.user.client.ui.Label build_lblAudiencePlaceHolder() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblAudiencePlaceHolder = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblAudiencePlaceHolder.setStyleName("" + get_res().css().placeHolderText() + "");


      owner.lblAudiencePlaceHolder = lblAudiencePlaceHolder;

      return lblAudiencePlaceHolder;
    }

    /**
     * Getter for domId37Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId37Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId37Element() {
      return domId37Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId37Element() {
      // Creation section.
      domId37Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId37());
      // Setup section.


      return domId37Element;
    }

    /**
     * Getter for domId38 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId38;
    private java.lang.String get_domId38() {
      return domId38;
    }
    private java.lang.String build_domId38() {
      // Creation section.
      domId38 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId38;
    }

    /**
     * Getter for lblAudienceArrow called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_lblAudienceArrow() {
      return build_lblAudienceArrow();
    }
    private com.google.gwt.user.client.ui.Label build_lblAudienceArrow() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblAudienceArrow = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblAudienceArrow.setStyleName("" + get_res().css().arrowInstructional() + "");


      owner.lblAudienceArrow = lblAudienceArrow;

      return lblAudienceArrow;
    }

    /**
     * Getter for domId38Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId38Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId38Element() {
      return domId38Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId38Element() {
      // Creation section.
      domId38Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId38());
      // Setup section.


      return domId38Element;
    }

    /**
     * Getter for domId39 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId39;
    private java.lang.String get_domId39() {
      return domId39;
    }
    private java.lang.String build_domId39() {
      // Creation section.
      domId39 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId39;
    }

    /**
     * Getter for spanelAudiencePanel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.ScrollPanel get_spanelAudiencePanel() {
      return build_spanelAudiencePanel();
    }
    private com.google.gwt.user.client.ui.ScrollPanel build_spanelAudiencePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.ScrollPanel spanelAudiencePanel = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
      // Setup section.
      spanelAudiencePanel.add(get_htmlAudienceListContainer());
      spanelAudiencePanel.setStyleName("" + get_res().css().scrollPanelContainerInstructional() + "");


      owner.spanelAudiencePanel = spanelAudiencePanel;

      return spanelAudiencePanel;
    }

    /**
     * Getter for htmlAudienceListContainer called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_htmlAudienceListContainer() {
      return build_htmlAudienceListContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_htmlAudienceListContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel htmlAudienceListContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html19().asString());
      // Setup section.
      htmlAudienceListContainer.setStyleName("");


      owner.htmlAudienceListContainer = htmlAudienceListContainer;

      return htmlAudienceListContainer;
    }

    /**
     * Getter for domId39Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId39Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId39Element() {
      return domId39Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId39Element() {
      // Creation section.
      domId39Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId39());
      // Setup section.


      return domId39Element;
    }

    /**
     * Getter for f_FlowPanel61 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel61() {
      return build_f_FlowPanel61();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel61() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel61 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel61.add(get_f_FlowPanel62());
      f_FlowPanel61.add(get_f_FlowPanel63());
      f_FlowPanel61.add(get_f_FlowPanel64());
      f_FlowPanel61.setStyleName("" + get_res().css().gradeListCont() + "");


      return f_FlowPanel61;
    }

    /**
     * Getter for f_FlowPanel62 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel62() {
      return build_f_FlowPanel62();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel62() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel62 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      return f_FlowPanel62;
    }

    /**
     * Getter for f_FlowPanel63 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel63() {
      return build_f_FlowPanel63();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel63() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel63 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      return f_FlowPanel63;
    }

    /**
     * Getter for f_FlowPanel64 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel64() {
      return build_f_FlowPanel64();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel64() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel64 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      return f_FlowPanel64;
    }

    /**
     * Getter for f_FlowPanel65 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel65() {
      return build_f_FlowPanel65();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel65() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel65 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel65.setStyleName("" + get_res().css().shelfGradeInfogardenContainer() + "");


      return f_FlowPanel65;
    }

    /**
     * Getter for domId36Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId36Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId36Element() {
      return domId36Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId36Element() {
      // Creation section.
      domId36Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId36());
      // Setup section.


      return domId36Element;
    }

    /**
     * Getter for domId14Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId10Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
  }
}
