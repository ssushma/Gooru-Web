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

public class AddQuestionResourceView_AddQuestionResourceViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionResourceView>, org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionResourceView.AddQuestionResourceViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html2(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html3(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html4(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html5(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html6(String arg0);
     
    @Template("")
    SafeHtml html7();
     
    @Template("")
    SafeHtml html8();
     
    @Template("")
    SafeHtml html9();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html10(String arg0, String arg1);
     
    @Template("")
    SafeHtml html11();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html12(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html13(String arg0, String arg1);
     
    @Template("")
    SafeHtml html14();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html15(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html16(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html17(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html18(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html19(String arg0, String arg1, String arg2, String arg3);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span> <span id='{5}'></span> <span id='{6}'></span> <span id='{7}'></span> <span id='{8}'></span> <span id='{9}'></span> <span id='{10}'></span> <span id='{11}'></span> <span id='{12}'></span> <span id='{13}'></span>  <span id='{14}'></span>    <span id='{15}'></span>")
    SafeHtml html20(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15);
     
    @Template("")
    SafeHtml html21();
     
    @Template("")
    SafeHtml html22();
     
    @Template("")
    SafeHtml html23();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>,<span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span> <span id='{5}'></span> <span id='{6}'></span>")
    SafeHtml html24(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html25(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html26(String arg0, String arg1, String arg2, String arg3);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html27(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html28(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html29(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html30(String arg0, String arg1);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionResourceView owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionResourceView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickedOnCancelButton(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickedOnAddChoiceButton(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickOnHintsLabel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickedOnAddQuestionButton(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickOnAddQuestImg(event);
      }
    };

    final com.google.gwt.event.dom.client.MouseOverHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6 = new com.google.gwt.event.dom.client.MouseOverHandler() {
      public void onMouseOver(com.google.gwt.event.dom.client.MouseOverEvent event) {
        owner.onMouseOver(event);
      }
    };

    final com.google.gwt.event.dom.client.MouseOutHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7 = new com.google.gwt.event.dom.client.MouseOutHandler() {
      public void onMouseOut(com.google.gwt.event.dom.client.MouseOutEvent event) {
        owner.onMouseOut(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickTrems(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames9 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickPrivacy(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames10 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickCopyright(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames11 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickCommunityGuide(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionResourceView owner) {
      this.owner = owner;
      build_addWebResourceStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_res1();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_domId29();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId31();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId33();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId35();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId46();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId47();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId48();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId49();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId50();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId51();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId52();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId28();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId30();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId32();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId34();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId45();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId21();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId22();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId41();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId42();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId43();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId44();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId14();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId18();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId19();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId40();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId55();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId15();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId16();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId17();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId20();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId23();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId24();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId25();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId26();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId27();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId36();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId37();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId38();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId39();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId53();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId54();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId29Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId31Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId33Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId35Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId46Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId47Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId48Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId49Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId50Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId51Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId52Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId28Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId30Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId32Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId34Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId45Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId21Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId22Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId41Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId42Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId43Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId44Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId14Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId18Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId19Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId40Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId55Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId15Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId16Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId17Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId20Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId23Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId24Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId25Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId26Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId27Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId36Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId37Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId38Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId39Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId53Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId54Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2(get_domId2());
    }
    SafeHtml template_html3() {
      return template.html3(get_domId4(), get_domId5());
    }
    SafeHtml template_html4() {
      return template.html4(get_domId1(), get_domId3());
    }
    SafeHtml template_html5() {
      return template.html5(get_domId7());
    }
    SafeHtml template_html6() {
      return template.html6(get_domId9());
    }
    SafeHtml template_html7() {
      return template.html7();
    }
    SafeHtml template_html8() {
      return template.html8();
    }
    SafeHtml template_html9() {
      return template.html9();
    }
    SafeHtml template_html10() {
      return template.html10(get_domId13(), get_domId14());
    }
    SafeHtml template_html11() {
      return template.html11();
    }
    SafeHtml template_html12() {
      return template.html12(get_domId18(), get_domId19());
    }
    SafeHtml template_html13() {
      return template.html13(get_domId21(), get_domId22());
    }
    SafeHtml template_html14() {
      return template.html14();
    }
    SafeHtml template_html15() {
      return template.html15(get_domId29());
    }
    SafeHtml template_html16() {
      return template.html16(get_domId31());
    }
    SafeHtml template_html17() {
      return template.html17(get_domId33());
    }
    SafeHtml template_html18() {
      return template.html18(get_domId35());
    }
    SafeHtml template_html19() {
      return template.html19(get_domId28(), get_domId30(), get_domId32(), get_domId34());
    }
    SafeHtml template_html20() {
      return template.html20(get_domId0(), get_domId6(), get_domId8(), get_domId10(), get_domId11(), get_domId12(), get_domId15(), get_domId16(), get_domId17(), get_domId20(), get_domId23(), get_domId24(), get_domId25(), get_domId26(), get_domId27(), get_domId36());
    }
    SafeHtml template_html21() {
      return template.html21();
    }
    SafeHtml template_html22() {
      return template.html22();
    }
    SafeHtml template_html23() {
      return template.html23();
    }
    SafeHtml template_html24() {
      return template.html24(get_domId46(), get_domId47(), get_domId48(), get_domId49(), get_domId50(), get_domId51(), get_domId52());
    }
    SafeHtml template_html25() {
      return template.html25(get_domId45());
    }
    SafeHtml template_html26() {
      return template.html26(get_domId41(), get_domId42(), get_domId43(), get_domId44());
    }
    SafeHtml template_html27() {
      return template.html27(get_domId40());
    }
    SafeHtml template_html28() {
      return template.html28(get_domId37(), get_domId38(), get_domId39());
    }
    SafeHtml template_html29() {
      return template.html29(get_domId55());
    }
    SafeHtml template_html30() {
      return template.html30(get_domId53(), get_domId54());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionResourceView_AddQuestionResourceViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionResourceView_AddQuestionResourceViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionResourceView_AddQuestionResourceViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionResourceView_AddQuestionResourceViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionResourceView_AddQuestionResourceViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for addWebResourceStyle called 38 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionResourceView_AddQuestionResourceViewUiBinderImpl_GenCss_addWebResourceStyle addWebResourceStyle;
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionResourceView_AddQuestionResourceViewUiBinderImpl_GenCss_addWebResourceStyle get_addWebResourceStyle() {
      return addWebResourceStyle;
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionResourceView_AddQuestionResourceViewUiBinderImpl_GenCss_addWebResourceStyle build_addWebResourceStyle() {
      // Creation section.
      addWebResourceStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().addWebResourceStyle();
      // Setup section.
      addWebResourceStyle.ensureInjected();


      owner.addWebResourceStyle = addWebResourceStyle;

      return addWebResourceStyle;
    }

    /**
     * Getter for res called 12 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.CollectionEditResourceCBundle res;
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.CollectionEditResourceCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.CollectionEditResourceCBundle build_res() {
      // Creation section.
      res = (org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.CollectionEditResourceCBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.CollectionEditResourceCBundle.class);
      // Setup section.


      return res;
    }

    /**
     * Getter for res1 called 20 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle res1;
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle get_res1() {
      return res1;
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle build_res1() {
      // Creation section.
      res1 = (org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle.class);
      // Setup section.


      return res1;
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
      f_FlowPanel1.setStyleName("" + get_addWebResourceStyle().addResourceFormRightOuterDiv() + "");


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
      f_FlowPanel2.add(get_questionTypeHeader());
      f_FlowPanel2.add(get_questionTypeText());
      f_FlowPanel2.add(get_f_HTMLPanel3());
      f_FlowPanel2.add(get_f_HTMLPanel28());
      f_FlowPanel2.add(get_buttonContainer());
      f_FlowPanel2.add(get_loadingTextLbl());
      f_FlowPanel2.setStyleName("" + get_addWebResourceStyle().addResourceFormRightInnerMainDiv() + "");


      return f_FlowPanel2;
    }

    /**
     * Getter for questionTypeHeader called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_questionTypeHeader() {
      return build_questionTypeHeader();
    }
    private com.google.gwt.user.client.ui.Label build_questionTypeHeader() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label questionTypeHeader = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      questionTypeHeader.setStyleName("" + get_addWebResourceStyle().questionTypeHeaderStyle() + "");


      owner.questionTypeHeader = questionTypeHeader;

      return questionTypeHeader;
    }

    /**
     * Getter for questionTypeText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_questionTypeText() {
      return build_questionTypeText();
    }
    private com.google.gwt.user.client.ui.Label build_questionTypeText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label questionTypeText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      questionTypeText.setStyleName("" + get_addWebResourceStyle().questionTypeTextStyle() + "");


      owner.questionTypeText = questionTypeText;

      return questionTypeText;
    }

    /**
     * Getter for f_HTMLPanel3 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel3() {
      return build_f_HTMLPanel3();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template_html20().asString());
      // Setup section.
      f_HTMLPanel3.setStyleName("" + get_addWebResourceStyle().addResourceFormContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord373 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
      get_domId0Element().get();
      get_domId6Element().get();
      get_domId8Element().get();
      get_domId10Element().get();
      get_domId11Element().get();
      get_domId12Element().get();
      get_domId15Element().get();
      get_domId16Element().get();
      get_domId17Element().get();
      get_domId20Element().get();
      get_domId23Element().get();
      get_domId24Element().get();
      get_domId25Element().get();
      get_domId26Element().get();
      get_domId27Element().get();
      get_domId36Element().get();

      // Detach section.
      attachRecord373.detach();
      f_HTMLPanel3.addAndReplaceElement(get_f_HTMLPanel4(), get_domId0Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_f_HTMLPanel7(), get_domId6Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_f_HTMLPanel8(), get_domId8Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_addQuestImgContainer(), get_domId10Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_answerchoiceTitleContainer(), get_domId11Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_questionAnswerChoiceContainer(), get_domId12Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_questionTrueOrFalseAnswerChoiceContainer(), get_domId15Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_addAnswerChoice(), get_domId16Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_f_HTMLPanel9(), get_domId17Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_f_FlowPanel10(), get_domId20Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_errorMessageForExplanation(), get_domId23Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_hintsContainer(), get_domId24Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_addHintsLabel(), get_domId25Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_errorMessageForHintsCheck(), get_domId26Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_f_FlowPanel12(), get_domId27Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_standardContainer(), get_domId36Element().get());

      return f_HTMLPanel3;
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
     * Getter for f_HTMLPanel4 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel4() {
      return build_f_HTMLPanel4();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel4 = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      f_HTMLPanel4.setStyleName("" + get_addWebResourceStyle().addResourceFormContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord374 = UiBinderUtil.attachToDom(f_HTMLPanel4.getElement());
      get_domId1Element().get();
      get_domId3Element().get();

      // Detach section.
      attachRecord374.detach();
      f_HTMLPanel4.addAndReplaceElement(get_f_HTMLPanel5(), get_domId1Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_f_HTMLPanel6(), get_domId3Element().get());

      return f_HTMLPanel4;
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
     * Getter for f_HTMLPanel5 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel5() {
      return build_f_HTMLPanel5();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel5 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      f_HTMLPanel5.setStyleName("" + get_addWebResourceStyle().questionTextContainerStyle() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord375 = UiBinderUtil.attachToDom(f_HTMLPanel5.getElement());
      get_domId2Element().get();

      // Detach section.
      attachRecord375.detach();
      f_HTMLPanel5.addAndReplaceElement(get_questionText(), get_domId2Element().get());

      return f_HTMLPanel5;
    }

    /**
     * Getter for domId2 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for questionText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_questionText() {
      return build_questionText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_questionText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel questionText = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      questionText.setStyleName("" + get_addWebResourceStyle().addResourceFormTitle() + "");


      owner.questionText = questionText;

      return questionText;
    }

    /**
     * Getter for domId2Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for f_HTMLPanel6 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel6() {
      return build_f_HTMLPanel6();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel6() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel6 = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      f_HTMLPanel6.setStyleName("" + get_addWebResourceStyle().addResourceFormInputControl() + " questionTextcontainer");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord376 = UiBinderUtil.attachToDom(f_HTMLPanel6.getElement());
      get_domId4Element().get();
      get_domId5Element().get();

      // Detach section.
      attachRecord376.detach();
      f_HTMLPanel6.addAndReplaceElement(get_questionNameTextArea(), get_domId4Element().get());
      f_HTMLPanel6.addAndReplaceElement(get_questionNameErrorLbl(), get_domId5Element().get());

      return f_HTMLPanel6;
    }

    /**
     * Getter for domId4 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for questionNameTextArea called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.ui.TinyMCE get_questionNameTextArea() {
      return build_questionNameTextArea();
    }
    private org.ednovo.gooru.client.ui.TinyMCE build_questionNameTextArea() {
      // Creation section.
      final org.ednovo.gooru.client.ui.TinyMCE questionNameTextArea = new org.ednovo.gooru.client.ui.TinyMCE(500);
      // Setup section.
      questionNameTextArea.setHeight("1");
      questionNameTextArea.setWidth("1");


      owner.questionNameTextArea = questionNameTextArea;

      return questionNameTextArea;
    }

    /**
     * Getter for domId4Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId5 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for questionNameErrorLbl called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_questionNameErrorLbl() {
      return build_questionNameErrorLbl();
    }
    private com.google.gwt.user.client.ui.Label build_questionNameErrorLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label questionNameErrorLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.questionNameErrorLbl = questionNameErrorLbl;

      return questionNameErrorLbl;
    }

    /**
     * Getter for domId5Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for f_HTMLPanel7 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel7() {
      return build_f_HTMLPanel7();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel7() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel7 = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.
      f_HTMLPanel7.setStyleName("" + get_addWebResourceStyle().addQuestionImageButtonContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord377 = UiBinderUtil.attachToDom(f_HTMLPanel7.getElement());
      get_domId7Element().get();

      // Detach section.
      attachRecord377.detach();
      f_HTMLPanel7.addAndReplaceElement(get_addQuestionImg(), get_domId7Element().get());

      return f_HTMLPanel7;
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
     * Getter for addQuestionImg called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Anchor get_addQuestionImg() {
      return build_addQuestionImg();
    }
    private com.google.gwt.user.client.ui.Anchor build_addQuestionImg() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor addQuestionImg = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      addQuestionImg.setStyleName("" + get_addWebResourceStyle().addResourceBottmTitle() + " " + get_addWebResourceStyle().addResourceBottmTitleAlign() + "");
      addQuestionImg.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5);


      owner.addQuestionImg = addQuestionImg;

      return addQuestionImg;
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
     * Getter for f_HTMLPanel8 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel8() {
      return build_f_HTMLPanel8();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel8() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel8 = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.
      f_HTMLPanel8.setStyleName("" + get_addWebResourceStyle().addResourceFormInputBottomTextOuterdiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord378 = UiBinderUtil.attachToDom(f_HTMLPanel8.getElement());
      get_domId9Element().get();

      // Detach section.
      attachRecord378.detach();
      f_HTMLPanel8.addAndReplaceElement(get_errorMessageForQuestion(), get_domId9Element().get());

      return f_HTMLPanel8;
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
     * Getter for errorMessageForQuestion called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_errorMessageForQuestion() {
      return build_errorMessageForQuestion();
    }
    private com.google.gwt.user.client.ui.Label build_errorMessageForQuestion() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label errorMessageForQuestion = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      errorMessageForQuestion.setStyleName("" + get_addWebResourceStyle().addResourceFormInputBottomText() + "");


      owner.errorMessageForQuestion = errorMessageForQuestion;

      return errorMessageForQuestion;
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
     * Getter for addQuestImgContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_addQuestImgContainer() {
      return build_addQuestImgContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_addQuestImgContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel addQuestImgContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.


      owner.addQuestImgContainer = addQuestImgContainer;

      return addQuestImgContainer;
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
     * Getter for answerchoiceTitleContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_answerchoiceTitleContainer() {
      return build_answerchoiceTitleContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_answerchoiceTitleContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel answerchoiceTitleContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      answerchoiceTitleContainer.add(get_addResourceFormTitleChoice());
      answerchoiceTitleContainer.add(get_correctText());
      answerchoiceTitleContainer.add(get_noLabelText());
      answerchoiceTitleContainer.setStyleName("" + get_addWebResourceStyle().addResourceFormTitleChoiceContainer() + "");


      owner.answerchoiceTitleContainer = answerchoiceTitleContainer;

      return answerchoiceTitleContainer;
    }

    /**
     * Getter for addResourceFormTitleChoice called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_addResourceFormTitleChoice() {
      return build_addResourceFormTitleChoice();
    }
    private com.google.gwt.user.client.ui.Label build_addResourceFormTitleChoice() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label addResourceFormTitleChoice = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      addResourceFormTitleChoice.setStyleName("" + get_addWebResourceStyle().addResourceFormTitleChoice() + "");


      owner.addResourceFormTitleChoice = addResourceFormTitleChoice;

      return addResourceFormTitleChoice;
    }

    /**
     * Getter for correctText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_correctText() {
      return build_correctText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_correctText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel correctText = new com.google.gwt.user.client.ui.HTMLPanel(template_html8().asString());
      // Setup section.
      correctText.setStyleName("" + get_addWebResourceStyle().addResourceFormTitleChoiceAlign() + "");


      owner.correctText = correctText;

      return correctText;
    }

    /**
     * Getter for noLabelText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_noLabelText() {
      return build_noLabelText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_noLabelText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel noLabelText = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      noLabelText.setStyleName("" + get_addWebResourceStyle().addResourceFormTitleChoiceAlign() + "");


      owner.noLabelText = noLabelText;

      return noLabelText;
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
     * Getter for questionAnswerChoiceContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_questionAnswerChoiceContainer() {
      return build_questionAnswerChoiceContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_questionAnswerChoiceContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel questionAnswerChoiceContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html10().asString());
      // Setup section.
      questionAnswerChoiceContainer.setStyleName("" + get_addWebResourceStyle().addResourceFormContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord379 = UiBinderUtil.attachToDom(questionAnswerChoiceContainer.getElement());
      get_domId13Element().get();
      get_domId14Element().get();

      // Detach section.
      attachRecord379.detach();
      questionAnswerChoiceContainer.addAndReplaceElement(get_alphaLetterA(), get_domId13Element().get());
      questionAnswerChoiceContainer.addAndReplaceElement(get_alphaLetterB(), get_domId14Element().get());

      owner.questionAnswerChoiceContainer = questionAnswerChoiceContainer;

      return questionAnswerChoiceContainer;
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
     * Getter for alphaLetterA called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionAnswerChoice get_alphaLetterA() {
      return build_alphaLetterA();
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionAnswerChoice build_alphaLetterA() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionAnswerChoice alphaLetterA = (org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionAnswerChoice) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionAnswerChoice.class);
      // Setup section.


      owner.alphaLetterA = alphaLetterA;

      return alphaLetterA;
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
     * Getter for alphaLetterB called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionAnswerChoice get_alphaLetterB() {
      return build_alphaLetterB();
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionAnswerChoice build_alphaLetterB() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionAnswerChoice alphaLetterB = (org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionAnswerChoice) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionAnswerChoice.class);
      // Setup section.


      owner.alphaLetterB = alphaLetterB;

      return alphaLetterB;
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
     * Getter for questionTrueOrFalseAnswerChoiceContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_questionTrueOrFalseAnswerChoiceContainer() {
      return build_questionTrueOrFalseAnswerChoiceContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_questionTrueOrFalseAnswerChoiceContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel questionTrueOrFalseAnswerChoiceContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html11().asString());
      // Setup section.
      questionTrueOrFalseAnswerChoiceContainer.setStyleName("" + get_addWebResourceStyle().addResourceFormContent() + "");


      owner.questionTrueOrFalseAnswerChoiceContainer = questionTrueOrFalseAnswerChoiceContainer;

      return questionTrueOrFalseAnswerChoiceContainer;
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
     * Getter for addAnswerChoice called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Anchor get_addAnswerChoice() {
      return build_addAnswerChoice();
    }
    private com.google.gwt.user.client.ui.Anchor build_addAnswerChoice() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor addAnswerChoice = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      addAnswerChoice.setStyleName("" + get_addWebResourceStyle().addResourceBottmTitle() + "");
      addAnswerChoice.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.addAnswerChoice = addAnswerChoice;

      return addAnswerChoice;
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
     * Getter for f_HTMLPanel9 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel9() {
      return build_f_HTMLPanel9();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel9() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel9 = new com.google.gwt.user.client.ui.HTMLPanel(template_html12().asString());
      // Setup section.
      f_HTMLPanel9.setStyleName("" + get_addWebResourceStyle().addResourceFormInputBottomTextOuterdiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord380 = UiBinderUtil.attachToDom(f_HTMLPanel9.getElement());
      get_domId18Element().get();
      get_domId19Element().get();

      // Detach section.
      attachRecord380.detach();
      f_HTMLPanel9.addAndReplaceElement(get_errorMessageForAnsCheck(), get_domId18Element().get());
      f_HTMLPanel9.addAndReplaceElement(get_ansChoiceErrMsg(), get_domId19Element().get());

      return f_HTMLPanel9;
    }

    /**
     * Getter for domId18 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for errorMessageForAnsCheck called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_errorMessageForAnsCheck() {
      return build_errorMessageForAnsCheck();
    }
    private com.google.gwt.user.client.ui.Label build_errorMessageForAnsCheck() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label errorMessageForAnsCheck = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      errorMessageForAnsCheck.setStyleName("" + get_addWebResourceStyle().addResourceFormInputBottomText() + "");
      errorMessageForAnsCheck.setText("");


      owner.errorMessageForAnsCheck = errorMessageForAnsCheck;

      return errorMessageForAnsCheck;
    }

    /**
     * Getter for domId18Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId19 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for ansChoiceErrMsg called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_ansChoiceErrMsg() {
      return build_ansChoiceErrMsg();
    }
    private com.google.gwt.user.client.ui.Label build_ansChoiceErrMsg() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label ansChoiceErrMsg = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      ansChoiceErrMsg.setStyleName("" + get_addWebResourceStyle().addResourceFormInputBottomText() + "");
      ansChoiceErrMsg.setText("");


      owner.ansChoiceErrMsg = ansChoiceErrMsg;

      return ansChoiceErrMsg;
    }

    /**
     * Getter for domId19Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for f_FlowPanel10 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel10() {
      return build_f_FlowPanel10();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel10() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel10 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel10.add(get_explanationLabel());
      f_FlowPanel10.add(get_f_HTMLPanel11());
      f_FlowPanel10.setStyleName("" + get_addWebResourceStyle().addResourceFormContent() + "");


      return f_FlowPanel10;
    }

    /**
     * Getter for explanationLabel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_explanationLabel() {
      return build_explanationLabel();
    }
    private com.google.gwt.user.client.ui.Label build_explanationLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label explanationLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      explanationLabel.setStyleName("" + get_addWebResourceStyle().addResourceFormTitle() + "");


      owner.explanationLabel = explanationLabel;

      return explanationLabel;
    }

    /**
     * Getter for f_HTMLPanel11 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel11() {
      return build_f_HTMLPanel11();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel11() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel11 = new com.google.gwt.user.client.ui.HTMLPanel(template_html13().asString());
      // Setup section.
      f_HTMLPanel11.setStyleName("" + get_addWebResourceStyle().addResourceFormInputControl() + " questionTextcontainer");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord381 = UiBinderUtil.attachToDom(f_HTMLPanel11.getElement());
      get_domId21Element().get();
      get_domId22Element().get();

      // Detach section.
      attachRecord381.detach();
      f_HTMLPanel11.addAndReplaceElement(get_explainationTextArea(), get_domId21Element().get());
      f_HTMLPanel11.addAndReplaceElement(get_explainationErrorLbl(), get_domId22Element().get());

      return f_HTMLPanel11;
    }

    /**
     * Getter for domId21 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for explainationTextArea called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.ui.TinyMCE get_explainationTextArea() {
      return build_explainationTextArea();
    }
    private org.ednovo.gooru.client.ui.TinyMCE build_explainationTextArea() {
      // Creation section.
      final org.ednovo.gooru.client.ui.TinyMCE explainationTextArea = new org.ednovo.gooru.client.ui.TinyMCE(400);
      // Setup section.


      owner.explainationTextArea = explainationTextArea;

      return explainationTextArea;
    }

    /**
     * Getter for domId21Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId22 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for explainationErrorLbl called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_explainationErrorLbl() {
      return build_explainationErrorLbl();
    }
    private com.google.gwt.user.client.ui.Label build_explainationErrorLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label explainationErrorLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.explainationErrorLbl = explainationErrorLbl;

      return explainationErrorLbl;
    }

    /**
     * Getter for domId22Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for errorMessageForExplanation called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_errorMessageForExplanation() {
      return build_errorMessageForExplanation();
    }
    private com.google.gwt.user.client.ui.Label build_errorMessageForExplanation() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label errorMessageForExplanation = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      errorMessageForExplanation.setStyleName("" + get_addWebResourceStyle().addResourceFormInputBottomText() + "");


      owner.errorMessageForExplanation = errorMessageForExplanation;

      return errorMessageForExplanation;
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
     * Getter for hintsContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_hintsContainer() {
      return build_hintsContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_hintsContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel hintsContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html14().asString());
      // Setup section.


      owner.hintsContainer = hintsContainer;

      return hintsContainer;
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
     * Getter for addHintsLabel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Anchor get_addHintsLabel() {
      return build_addHintsLabel();
    }
    private com.google.gwt.user.client.ui.Anchor build_addHintsLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor addHintsLabel = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      addHintsLabel.setStyleName("" + get_addWebResourceStyle().addResourceBottmTitle() + "");
      addHintsLabel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);


      owner.addHintsLabel = addHintsLabel;

      return addHintsLabel;
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
     * Getter for errorMessageForHintsCheck called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_errorMessageForHintsCheck() {
      return build_errorMessageForHintsCheck();
    }
    private com.google.gwt.user.client.ui.Label build_errorMessageForHintsCheck() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label errorMessageForHintsCheck = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      errorMessageForHintsCheck.setStyleName("" + get_addWebResourceStyle().addResourceFormInputBottomText() + "");


      owner.errorMessageForHintsCheck = errorMessageForHintsCheck;

      return errorMessageForHintsCheck;
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
     * Getter for f_FlowPanel12 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel12() {
      return build_f_FlowPanel12();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel12() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel12 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel12.add(get_f_FlowPanel13());
      f_FlowPanel12.add(get_depthOfKnowledgeTitle());
      f_FlowPanel12.add(get_f_FlowPanel14());
      f_FlowPanel12.add(get_f_FlowPanel20());
      f_FlowPanel12.add(get_f_FlowPanel24());
      f_FlowPanel12.setStyleName("" + get_res1().css().depthOfKnowledgeContainer() + "");


      return f_FlowPanel12;
    }

    /**
     * Getter for f_FlowPanel13 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel13() {
      return build_f_FlowPanel13();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel13() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel13 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel13.add(get_depthOfKnowledgeHeader());
      f_FlowPanel13.add(get_depthOfKnoweldgeToolTip());
      f_FlowPanel13.setStyleName("" + get_res1().css().depthOfKnowledgeSubContainer() + "");


      return f_FlowPanel13;
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
      depthOfKnowledgeHeader.setStyleName("" + get_addWebResourceStyle().addResourceDepthOfKnoweldgeFormTitle() + "");


      owner.depthOfKnowledgeHeader = depthOfKnowledgeHeader;

      return depthOfKnowledgeHeader;
    }

    /**
     * Getter for depthOfKnoweldgeToolTip called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Image get_depthOfKnoweldgeToolTip() {
      return build_depthOfKnoweldgeToolTip();
    }
    private com.google.gwt.user.client.ui.Image build_depthOfKnoweldgeToolTip() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image depthOfKnoweldgeToolTip = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      depthOfKnoweldgeToolTip.setStyleName("friendlyQuestionMark");
      depthOfKnoweldgeToolTip.setAltText("Question Mark");


      owner.depthOfKnoweldgeToolTip = depthOfKnoweldgeToolTip;

      return depthOfKnoweldgeToolTip;
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
      depthOfKnowledgeTitle.setStyleName("" + get_addWebResourceStyle().addResourceFormTitle() + "");


      return depthOfKnowledgeTitle;
    }

    /**
     * Getter for f_FlowPanel14 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel14() {
      return build_f_FlowPanel14();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel14() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel14 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel14.add(get_f_HTMLPanel15());
      f_FlowPanel14.setStyleName("" + get_res1().css().questionDepthOfKnoweldgeContainer() + "");


      return f_FlowPanel14;
    }

    /**
     * Getter for f_HTMLPanel15 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel15() {
      return build_f_HTMLPanel15();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel15() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel15 = new com.google.gwt.user.client.ui.HTMLPanel(template_html19().asString());
      // Setup section.
      f_HTMLPanel15.setStyleName("" + get_res1().css().checkBoxOuterContiner() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord382 = UiBinderUtil.attachToDom(f_HTMLPanel15.getElement());
      get_domId28Element().get();
      get_domId30Element().get();
      get_domId32Element().get();
      get_domId34Element().get();

      // Detach section.
      attachRecord382.detach();
      f_HTMLPanel15.addAndReplaceElement(get_f_HTMLPanel16(), get_domId28Element().get());
      f_HTMLPanel15.addAndReplaceElement(get_f_HTMLPanel17(), get_domId30Element().get());
      f_HTMLPanel15.addAndReplaceElement(get_f_HTMLPanel18(), get_domId32Element().get());
      f_HTMLPanel15.addAndReplaceElement(get_f_HTMLPanel19(), get_domId34Element().get());

      return f_HTMLPanel15;
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
     * Getter for f_HTMLPanel16 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel16() {
      return build_f_HTMLPanel16();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel16() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel16 = new com.google.gwt.user.client.ui.HTMLPanel(template_html15().asString());
      // Setup section.
      f_HTMLPanel16.setStyleName("" + get_res1().css().checkBoxinnerContinerForQuestion() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord383 = UiBinderUtil.attachToDom(f_HTMLPanel16.getElement());
      get_domId29Element().get();

      // Detach section.
      attachRecord383.detach();
      f_HTMLPanel16.addAndReplaceElement(get_chkLevelRecall(), get_domId29Element().get());

      return f_HTMLPanel16;
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
     * Getter for chkLevelRecall called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.CheckBox get_chkLevelRecall() {
      return build_chkLevelRecall();
    }
    private com.google.gwt.user.client.ui.CheckBox build_chkLevelRecall() {
      // Creation section.
      final com.google.gwt.user.client.ui.CheckBox chkLevelRecall = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
      // Setup section.
      chkLevelRecall.setStyleName("" + get_res1().css().checkBoxlevels() + "");


      owner.chkLevelRecall = chkLevelRecall;

      return chkLevelRecall;
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
     * Getter for f_HTMLPanel17 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel17() {
      return build_f_HTMLPanel17();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel17() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel17 = new com.google.gwt.user.client.ui.HTMLPanel(template_html16().asString());
      // Setup section.
      f_HTMLPanel17.setStyleName("" + get_res1().css().checkBoxinnerContinerForQuestion() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord384 = UiBinderUtil.attachToDom(f_HTMLPanel17.getElement());
      get_domId31Element().get();

      // Detach section.
      attachRecord384.detach();
      f_HTMLPanel17.addAndReplaceElement(get_chkLevelSkillConcept(), get_domId31Element().get());

      return f_HTMLPanel17;
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
     * Getter for chkLevelSkillConcept called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.CheckBox get_chkLevelSkillConcept() {
      return build_chkLevelSkillConcept();
    }
    private com.google.gwt.user.client.ui.CheckBox build_chkLevelSkillConcept() {
      // Creation section.
      final com.google.gwt.user.client.ui.CheckBox chkLevelSkillConcept = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
      // Setup section.
      chkLevelSkillConcept.setStyleName("" + get_res1().css().checkBoxlevels() + "");


      owner.chkLevelSkillConcept = chkLevelSkillConcept;

      return chkLevelSkillConcept;
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
     * Getter for domId32 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for f_HTMLPanel18 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel18() {
      return build_f_HTMLPanel18();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel18() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel18 = new com.google.gwt.user.client.ui.HTMLPanel(template_html17().asString());
      // Setup section.
      f_HTMLPanel18.setStyleName("" + get_res1().css().checkBoxinnerContinerForQuestion() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord385 = UiBinderUtil.attachToDom(f_HTMLPanel18.getElement());
      get_domId33Element().get();

      // Detach section.
      attachRecord385.detach();
      f_HTMLPanel18.addAndReplaceElement(get_chkLevelStrategicThinking(), get_domId33Element().get());

      return f_HTMLPanel18;
    }

    /**
     * Getter for domId33 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for chkLevelStrategicThinking called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.CheckBox get_chkLevelStrategicThinking() {
      return build_chkLevelStrategicThinking();
    }
    private com.google.gwt.user.client.ui.CheckBox build_chkLevelStrategicThinking() {
      // Creation section.
      final com.google.gwt.user.client.ui.CheckBox chkLevelStrategicThinking = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
      // Setup section.
      chkLevelStrategicThinking.setStyleName("" + get_res1().css().checkBoxlevels() + "");


      owner.chkLevelStrategicThinking = chkLevelStrategicThinking;

      return chkLevelStrategicThinking;
    }

    /**
     * Getter for domId33Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId32Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for f_HTMLPanel19 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel19() {
      return build_f_HTMLPanel19();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel19() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel19 = new com.google.gwt.user.client.ui.HTMLPanel(template_html18().asString());
      // Setup section.
      f_HTMLPanel19.setStyleName("" + get_res1().css().checkBoxinnerContinerForQuestion() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord386 = UiBinderUtil.attachToDom(f_HTMLPanel19.getElement());
      get_domId35Element().get();

      // Detach section.
      attachRecord386.detach();
      f_HTMLPanel19.addAndReplaceElement(get_chkLevelExtendedThinking(), get_domId35Element().get());

      return f_HTMLPanel19;
    }

    /**
     * Getter for domId35 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for chkLevelExtendedThinking called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.CheckBox get_chkLevelExtendedThinking() {
      return build_chkLevelExtendedThinking();
    }
    private com.google.gwt.user.client.ui.CheckBox build_chkLevelExtendedThinking() {
      // Creation section.
      final com.google.gwt.user.client.ui.CheckBox chkLevelExtendedThinking = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
      // Setup section.
      chkLevelExtendedThinking.setStyleName("" + get_res1().css().checkBoxlevels() + "");


      owner.chkLevelExtendedThinking = chkLevelExtendedThinking;

      return chkLevelExtendedThinking;
    }

    /**
     * Getter for domId35Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for f_FlowPanel20 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel20() {
      return build_f_FlowPanel20();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel20() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel20 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel20.add(get_f_FlowPanel21());
      f_FlowPanel20.add(get_f_FlowPanel22());
      f_FlowPanel20.add(get_f_FlowPanel23());
      f_FlowPanel20.setStyleName("" + get_res1().css().gradeListCont() + "");


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
     * Getter for f_FlowPanel22 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel22() {
      return build_f_FlowPanel22();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel22() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel22 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      return f_FlowPanel22;
    }

    /**
     * Getter for f_FlowPanel23 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel23() {
      return build_f_FlowPanel23();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel23() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel23 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


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
      f_FlowPanel24.setStyleName("" + get_res1().css().shelfGradeInfogardenContainer() + "");


      return f_FlowPanel24;
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
     * Getter for standardContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_standardContainer() {
      return build_standardContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_standardContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel standardContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      standardContainer.add(get_standardsDefaultText());
      standardContainer.add(get_f_FlowPanel25());


      owner.standardContainer = standardContainer;

      return standardContainer;
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
      standardsDefaultText.setStyleName("" + get_res1().css().addQuestionStandard() + "");


      owner.standardsDefaultText = standardsDefaultText;

      return standardsDefaultText;
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
      f_FlowPanel25.add(get_f_FlowPanel26());
      f_FlowPanel25.setStyleName("" + get_res1().css().shelfCourseSubject() + "");


      return f_FlowPanel25;
    }

    /**
     * Getter for f_FlowPanel26 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel26() {
      return build_f_FlowPanel26();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel26() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel26 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel26.add(get_f_FlowPanel27());
      f_FlowPanel26.setStyleName("" + get_res1().css().addResourceSuggestedBoxForQuestion() + "");


      return f_FlowPanel26;
    }

    /**
     * Getter for f_FlowPanel27 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel27() {
      return build_f_FlowPanel27();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel27() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel27 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel27.add(get_standardSgstBox());
      f_FlowPanel27.add(get_standardMaxMsg());
      f_FlowPanel27.add(get_standardsPanel());
      f_FlowPanel27.setStyleName("" + get_res1().css().standardsCont() + "");


      return f_FlowPanel27;
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
      standardSgstBox.setWidth("271px");


      return standardSgstBox;
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
      standardMaxMsg.setStyleName("" + get_res1().css().standardMaxHide() + "");


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
      standardsPanel.setStyleName("" + get_res1().css().collectionStandardsMargin() + "");


      owner.standardsPanel = standardsPanel;

      return standardsPanel;
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
     * Getter for f_HTMLPanel28 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel28() {
      return build_f_HTMLPanel28();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel28() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel28 = new com.google.gwt.user.client.ui.HTMLPanel(template_html28().asString());
      // Setup section.
      f_HTMLPanel28.setStyleName("" + get_addWebResourceStyle().resourceRightsContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord387 = UiBinderUtil.attachToDom(f_HTMLPanel28.getElement());
      get_domId37Element().get();
      get_domId38Element().get();
      get_domId39Element().get();

      // Detach section.
      attachRecord387.detach();
      f_HTMLPanel28.addAndReplaceElement(get_rightsChkBox(), get_domId37Element().get());
      f_HTMLPanel28.addAndReplaceElement(get_rightsLbl(), get_domId38Element().get());
      f_HTMLPanel28.addAndReplaceElement(get_lblContentRights(), get_domId39Element().get());

      return f_HTMLPanel28;
    }

    /**
     * Getter for domId37 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for rightsChkBox called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.CheckBox get_rightsChkBox() {
      return build_rightsChkBox();
    }
    private com.google.gwt.user.client.ui.CheckBox build_rightsChkBox() {
      // Creation section.
      final com.google.gwt.user.client.ui.CheckBox rightsChkBox = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
      // Setup section.
      rightsChkBox.setStyleName("" + get_addWebResourceStyle().resourceRightsCheckBox() + "");
      rightsChkBox.setChecked(true);


      owner.rightsChkBox = rightsChkBox;

      return rightsChkBox;
    }

    /**
     * Getter for domId37Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId38 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for rightsLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_rightsLbl() {
      return build_rightsLbl();
    }
    private com.google.gwt.user.client.ui.Label build_rightsLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label rightsLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      rightsLbl.setStyleName("" + get_addWebResourceStyle().ownResourceFormDeclarationText() + "");


      owner.rightsLbl = rightsLbl;

      return rightsLbl;
    }

    /**
     * Getter for domId38Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId39 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for lblContentRights called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_lblContentRights() {
      return build_lblContentRights();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_lblContentRights() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel lblContentRights = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html27().asString());
      // Setup section.
      lblContentRights.setStyleName("" + get_res().css().ownResourceFormRightsContent() + "");
      lblContentRights.addMouseOverHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6);
      lblContentRights.addMouseOutHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord388 = UiBinderUtil.attachToDom(lblContentRights.getElement());
      get_domId40Element().get();

      // Detach section.
      attachRecord388.detach();
      lblContentRights.addAndReplaceElement(get_panelContentRights(), get_domId40Element().get());

      owner.lblContentRights = lblContentRights;

      return lblContentRights;
    }

    /**
     * Getter for domId40 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId40;
    private java.lang.String get_domId40() {
      return domId40;
    }
    private java.lang.String build_domId40() {
      // Creation section.
      domId40 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId40;
    }

    /**
     * Getter for panelContentRights called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelContentRights() {
      return build_panelContentRights();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelContentRights() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelContentRights = new com.google.gwt.user.client.ui.HTMLPanel(template_html26().asString());
      // Setup section.
      panelContentRights.setStyleName("" + get_res().css().resourceRightsPopupContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord389 = UiBinderUtil.attachToDom(panelContentRights.getElement());
      get_domId41Element().get();
      get_domId42Element().get();
      get_domId43Element().get();
      get_domId44Element().get();

      // Detach section.
      attachRecord389.detach();
      panelContentRights.addAndReplaceElement(get_f_HTMLPanel29(), get_domId41Element().get());
      panelContentRights.addAndReplaceElement(get_f_HTMLPanel30(), get_domId42Element().get());
      panelContentRights.addAndReplaceElement(get_f_HTMLPanel31(), get_domId43Element().get());
      panelContentRights.addAndReplaceElement(get_f_HTMLPanel32(), get_domId44Element().get());

      owner.panelContentRights = panelContentRights;

      return panelContentRights;
    }

    /**
     * Getter for domId41 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId41;
    private java.lang.String get_domId41() {
      return domId41;
    }
    private java.lang.String build_domId41() {
      // Creation section.
      domId41 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId41;
    }

    /**
     * Getter for f_HTMLPanel29 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel29() {
      return build_f_HTMLPanel29();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel29() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel29 = new com.google.gwt.user.client.ui.HTMLPanel(template_html21().asString());
      // Setup section.
      f_HTMLPanel29.setStyleName("" + get_res().css().arrowShadow() + "");


      return f_HTMLPanel29;
    }

    /**
     * Getter for domId41Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId41Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId41Element() {
      return domId41Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId41Element() {
      // Creation section.
      domId41Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId41());
      // Setup section.


      return domId41Element;
    }

    /**
     * Getter for domId42 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId42;
    private java.lang.String get_domId42() {
      return domId42;
    }
    private java.lang.String build_domId42() {
      // Creation section.
      domId42 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId42;
    }

    /**
     * Getter for f_HTMLPanel30 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel30() {
      return build_f_HTMLPanel30();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel30() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel30 = new com.google.gwt.user.client.ui.HTMLPanel(template_html22().asString());
      // Setup section.
      f_HTMLPanel30.setStyleName("" + get_res().css().arrowBorder() + "");


      return f_HTMLPanel30;
    }

    /**
     * Getter for domId42Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId42Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId42Element() {
      return domId42Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId42Element() {
      // Creation section.
      domId42Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId42());
      // Setup section.


      return domId42Element;
    }

    /**
     * Getter for domId43 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId43;
    private java.lang.String get_domId43() {
      return domId43;
    }
    private java.lang.String build_domId43() {
      // Creation section.
      domId43 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId43;
    }

    /**
     * Getter for f_HTMLPanel31 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel31() {
      return build_f_HTMLPanel31();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel31() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel31 = new com.google.gwt.user.client.ui.HTMLPanel(template_html23().asString());
      // Setup section.
      f_HTMLPanel31.setStyleName("" + get_res().css().arrow() + "");


      return f_HTMLPanel31;
    }

    /**
     * Getter for domId43Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId43Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId43Element() {
      return domId43Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId43Element() {
      // Creation section.
      domId43Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId43());
      // Setup section.


      return domId43Element;
    }

    /**
     * Getter for domId44 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId44;
    private java.lang.String get_domId44() {
      return domId44;
    }
    private java.lang.String build_domId44() {
      // Creation section.
      domId44 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId44;
    }

    /**
     * Getter for f_HTMLPanel32 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel32() {
      return build_f_HTMLPanel32();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel32() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel32 = new com.google.gwt.user.client.ui.HTMLPanel(template_html25().asString());
      // Setup section.
      f_HTMLPanel32.setStyleName("" + get_res().css().resourceRightsInnerPopup() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord390 = UiBinderUtil.attachToDom(f_HTMLPanel32.getElement());
      get_domId45Element().get();

      // Detach section.
      attachRecord390.detach();
      f_HTMLPanel32.addAndReplaceElement(get_rightsContent(), get_domId45Element().get());

      return f_HTMLPanel32;
    }

    /**
     * Getter for domId45 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId45;
    private java.lang.String get_domId45() {
      return domId45;
    }
    private java.lang.String build_domId45() {
      // Creation section.
      domId45 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId45;
    }

    /**
     * Getter for rightsContent called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_rightsContent() {
      return build_rightsContent();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_rightsContent() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel rightsContent = new com.google.gwt.user.client.ui.HTMLPanel(template_html24().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord391 = UiBinderUtil.attachToDom(rightsContent.getElement());
      get_domId46Element().get();
      get_domId47Element().get();
      get_domId48Element().get();
      get_domId49Element().get();
      get_domId50Element().get();
      get_domId51Element().get();
      get_domId52Element().get();

      // Detach section.
      attachRecord391.detach();
      rightsContent.addAndReplaceElement(get_agreeText(), get_domId46Element().get());
      rightsContent.addAndReplaceElement(get_commuGuideLinesAnr(), get_domId47Element().get());
      rightsContent.addAndReplaceElement(get_termsAndPolicyAnr(), get_domId48Element().get());
      rightsContent.addAndReplaceElement(get_privacyAnr(), get_domId49Element().get());
      rightsContent.addAndReplaceElement(get_andText(), get_domId50Element().get());
      rightsContent.addAndReplaceElement(get_copyRightAnr(), get_domId51Element().get());
      rightsContent.addAndReplaceElement(get_additionalText(), get_domId52Element().get());

      owner.rightsContent = rightsContent;

      return rightsContent;
    }

    /**
     * Getter for domId46 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
     */
    private java.lang.String domId46;
    private java.lang.String get_domId46() {
      return domId46;
    }
    private java.lang.String build_domId46() {
      // Creation section.
      domId46 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId46;
    }

    /**
     * Getter for agreeText called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Label get_agreeText() {
      return build_agreeText();
    }
    private com.google.gwt.user.client.ui.Label build_agreeText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label agreeText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.agreeText = agreeText;

      return agreeText;
    }

    /**
     * Getter for domId46Element called 2 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId46Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId46Element() {
      return domId46Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId46Element() {
      // Creation section.
      domId46Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId46());
      // Setup section.


      return domId46Element;
    }

    /**
     * Getter for domId47 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
     */
    private java.lang.String domId47;
    private java.lang.String get_domId47() {
      return domId47;
    }
    private java.lang.String build_domId47() {
      // Creation section.
      domId47 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId47;
    }

    /**
     * Getter for commuGuideLinesAnr called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Anchor get_commuGuideLinesAnr() {
      return build_commuGuideLinesAnr();
    }
    private com.google.gwt.user.client.ui.Anchor build_commuGuideLinesAnr() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor commuGuideLinesAnr = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      commuGuideLinesAnr.setStyleName("" + get_res().css().anchorText() + "");
      commuGuideLinesAnr.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames11);


      owner.commuGuideLinesAnr = commuGuideLinesAnr;

      return commuGuideLinesAnr;
    }

    /**
     * Getter for domId47Element called 2 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId47Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId47Element() {
      return domId47Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId47Element() {
      // Creation section.
      domId47Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId47());
      // Setup section.


      return domId47Element;
    }

    /**
     * Getter for domId48 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
     */
    private java.lang.String domId48;
    private java.lang.String get_domId48() {
      return domId48;
    }
    private java.lang.String build_domId48() {
      // Creation section.
      domId48 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId48;
    }

    /**
     * Getter for termsAndPolicyAnr called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Anchor get_termsAndPolicyAnr() {
      return build_termsAndPolicyAnr();
    }
    private com.google.gwt.user.client.ui.Anchor build_termsAndPolicyAnr() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor termsAndPolicyAnr = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      termsAndPolicyAnr.setStyleName("" + get_res().css().customAnchorText() + "");
      termsAndPolicyAnr.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8);


      owner.termsAndPolicyAnr = termsAndPolicyAnr;

      return termsAndPolicyAnr;
    }

    /**
     * Getter for domId48Element called 2 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId48Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId48Element() {
      return domId48Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId48Element() {
      // Creation section.
      domId48Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId48());
      // Setup section.


      return domId48Element;
    }

    /**
     * Getter for domId49 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
     */
    private java.lang.String domId49;
    private java.lang.String get_domId49() {
      return domId49;
    }
    private java.lang.String build_domId49() {
      // Creation section.
      domId49 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId49;
    }

    /**
     * Getter for privacyAnr called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Anchor get_privacyAnr() {
      return build_privacyAnr();
    }
    private com.google.gwt.user.client.ui.Anchor build_privacyAnr() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor privacyAnr = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      privacyAnr.setStyleName("" + get_res().css().customAnchorText() + "");
      privacyAnr.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames9);


      owner.privacyAnr = privacyAnr;

      return privacyAnr;
    }

    /**
     * Getter for domId49Element called 2 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId49Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId49Element() {
      return domId49Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId49Element() {
      // Creation section.
      domId49Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId49());
      // Setup section.


      return domId49Element;
    }

    /**
     * Getter for domId50 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
     */
    private java.lang.String domId50;
    private java.lang.String get_domId50() {
      return domId50;
    }
    private java.lang.String build_domId50() {
      // Creation section.
      domId50 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId50;
    }

    /**
     * Getter for andText called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Label get_andText() {
      return build_andText();
    }
    private com.google.gwt.user.client.ui.Label build_andText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label andText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      andText.setStyleName("" + get_res().css().andText() + "");


      owner.andText = andText;

      return andText;
    }

    /**
     * Getter for domId50Element called 2 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId50Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId50Element() {
      return domId50Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId50Element() {
      // Creation section.
      domId50Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId50());
      // Setup section.


      return domId50Element;
    }

    /**
     * Getter for domId51 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
     */
    private java.lang.String domId51;
    private java.lang.String get_domId51() {
      return domId51;
    }
    private java.lang.String build_domId51() {
      // Creation section.
      domId51 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId51;
    }

    /**
     * Getter for copyRightAnr called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Anchor get_copyRightAnr() {
      return build_copyRightAnr();
    }
    private com.google.gwt.user.client.ui.Anchor build_copyRightAnr() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor copyRightAnr = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      copyRightAnr.setStyleName("" + get_res().css().anchorText() + "");
      copyRightAnr.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames10);


      owner.copyRightAnr = copyRightAnr;

      return copyRightAnr;
    }

    /**
     * Getter for domId51Element called 2 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId51Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId51Element() {
      return domId51Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId51Element() {
      // Creation section.
      domId51Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId51());
      // Setup section.


      return domId51Element;
    }

    /**
     * Getter for domId52 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
     */
    private java.lang.String domId52;
    private java.lang.String get_domId52() {
      return domId52;
    }
    private java.lang.String build_domId52() {
      // Creation section.
      domId52 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId52;
    }

    /**
     * Getter for additionalText called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Label get_additionalText() {
      return build_additionalText();
    }
    private com.google.gwt.user.client.ui.Label build_additionalText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label additionalText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      additionalText.setStyleName("" + get_res().css().additionalText() + "");


      owner.additionalText = additionalText;

      return additionalText;
    }

    /**
     * Getter for domId52Element called 2 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId52Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId52Element() {
      return domId52Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId52Element() {
      // Creation section.
      domId52Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId52());
      // Setup section.


      return domId52Element;
    }

    /**
     * Getter for domId45Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId45Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId45Element() {
      return domId45Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId45Element() {
      // Creation section.
      domId45Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId45());
      // Setup section.


      return domId45Element;
    }

    /**
     * Getter for domId44Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId44Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId44Element() {
      return domId44Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId44Element() {
      // Creation section.
      domId44Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId44());
      // Setup section.


      return domId44Element;
    }

    /**
     * Getter for domId40Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId40Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId40Element() {
      return domId40Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId40Element() {
      // Creation section.
      domId40Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId40());
      // Setup section.


      return domId40Element;
    }

    /**
     * Getter for domId39Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for buttonContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_buttonContainer() {
      return build_buttonContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_buttonContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel buttonContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html30().asString());
      // Setup section.
      buttonContainer.setStyleName("" + get_addWebResourceStyle().addResourceButtonContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord392 = UiBinderUtil.attachToDom(buttonContainer.getElement());
      get_domId53Element().get();
      get_domId54Element().get();

      // Detach section.
      attachRecord392.detach();
      buttonContainer.addAndReplaceElement(get_cancelButton(), get_domId53Element().get());
      buttonContainer.addAndReplaceElement(get_addQuestionResourceButton(), get_domId54Element().get());

      owner.buttonContainer = buttonContainer;

      return buttonContainer;
    }

    /**
     * Getter for domId53 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId53;
    private java.lang.String get_domId53() {
      return domId53;
    }
    private java.lang.String build_domId53() {
      // Creation section.
      domId53 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId53;
    }

    /**
     * Getter for cancelButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Button get_cancelButton() {
      return build_cancelButton();
    }
    private com.google.gwt.user.client.ui.Button build_cancelButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button cancelButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      cancelButton.setStyleName("grayPrimaryButton");
      cancelButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.cancelButton = cancelButton;

      return cancelButton;
    }

    /**
     * Getter for domId53Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId53Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId53Element() {
      return domId53Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId53Element() {
      // Creation section.
      domId53Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId53());
      // Setup section.


      return domId53Element;
    }

    /**
     * Getter for domId54 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId54;
    private java.lang.String get_domId54() {
      return domId54;
    }
    private java.lang.String build_domId54() {
      // Creation section.
      domId54 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId54;
    }

    /**
     * Getter for addQuestionResourceButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_addQuestionResourceButton() {
      return build_addQuestionResourceButton();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_addQuestionResourceButton() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel addQuestionResourceButton = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html29().asString());
      // Setup section.
      addQuestionResourceButton.setStyleName("" + get_addWebResourceStyle().addResourceOk() + "");
      addQuestionResourceButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord393 = UiBinderUtil.attachToDom(addQuestionResourceButton.getElement());
      get_domId55Element().get();

      // Detach section.
      attachRecord393.detach();
      addQuestionResourceButton.addAndReplaceElement(get_addbutton(), get_domId55Element().get());

      owner.addQuestionResourceButton = addQuestionResourceButton;

      return addQuestionResourceButton;
    }

    /**
     * Getter for domId55 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId55;
    private java.lang.String get_domId55() {
      return domId55;
    }
    private java.lang.String build_domId55() {
      // Creation section.
      domId55 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId55;
    }

    /**
     * Getter for addbutton called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private org.ednovo.gooru.client.uc.BlueButtonUc get_addbutton() {
      return build_addbutton();
    }
    private org.ednovo.gooru.client.uc.BlueButtonUc build_addbutton() {
      // Creation section.
      final org.ednovo.gooru.client.uc.BlueButtonUc addbutton = (org.ednovo.gooru.client.uc.BlueButtonUc) GWT.create(org.ednovo.gooru.client.uc.BlueButtonUc.class);
      // Setup section.
      addbutton.setStyleName("primary");


      owner.addbutton = addbutton;

      return addbutton;
    }

    /**
     * Getter for domId55Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId55Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId55Element() {
      return domId55Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId55Element() {
      // Creation section.
      domId55Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId55());
      // Setup section.


      return domId55Element;
    }

    /**
     * Getter for domId54Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId54Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId54Element() {
      return domId54Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId54Element() {
      // Creation section.
      domId54Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId54());
      // Setup section.


      return domId54Element;
    }

    /**
     * Getter for loadingTextLbl called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_loadingTextLbl() {
      return build_loadingTextLbl();
    }
    private com.google.gwt.user.client.ui.Label build_loadingTextLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label loadingTextLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      loadingTextLbl.setStyleName("" + get_addWebResourceStyle().addResourceButtonContainer() + "");


      owner.loadingTextLbl = loadingTextLbl;

      return loadingTextLbl;
    }
  }
}
