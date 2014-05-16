package org.ednovo.gooru.client.mvp.profilepage;

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

public class ProfilePageView_ProfilePageViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.profilepage.ProfilePageView>, org.ednovo.gooru.client.mvp.profilepage.ProfilePageView.ProfilePageViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span>")
    SafeHtml html1(String arg0);
     
    @Template("")
    SafeHtml html2();
     
    @Template("")
    SafeHtml html3();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html4(String arg0, String arg1, String arg2, String arg3);
     
    @Template("")
    SafeHtml html5();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html6(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html7(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html8(String arg0, String arg1, String arg2, String arg3);
     
    @Template("")
    SafeHtml html9();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html10(String arg0);
     
    @Template("")
    SafeHtml html11();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html12(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html13(String arg0, String arg1, String arg2, String arg3);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>  <span id='{2}'></span>")
    SafeHtml html14(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html15(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html16(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html17(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html18(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>  <span id='{1}'></span>")
    SafeHtml html19(String arg0, String arg1);
     
    @Template("")
    SafeHtml html20();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html21(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html22(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html23(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span>  <span id='{1}'></span>")
    SafeHtml html24(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html25(String arg0);
     
    @Template("")
    SafeHtml html26();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html27(String arg0);
     
    @Template("")
    SafeHtml html28();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html29(String arg0, String arg1);
     
    @Template("")
    SafeHtml html30();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html31(String arg0, String arg1, String arg2, String arg3);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html32(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html33(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html34(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html35(String arg0, String arg1);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.profilepage.ProfilePageView owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.profilepage.ProfilePageView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickOffButton(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onContentTabVc(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.OnClickAddBioButton(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.OnClickGradeEditButton(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.OnCancelGradeEditButton(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.OnClickbiographySaveButton(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.OnClickBiographyCancelButton(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onAddCourseClick(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.profilepage.ProfilePageView owner) {
      this.owner = owner;
      build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();  // more than one getter call detected. Type: GENERATED_BUNDLE, precedence: 1
      build_ProfilePageStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_settingsStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_ccb();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_domId25();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 10
      build_domId28();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 10
      build_domId29();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 10
      build_domId24();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId26();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId27();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId30();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId36();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId37();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId15();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId16();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId17();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId21();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId22();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId23();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId34();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId35();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId41();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId43();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId14();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId19();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId20();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId32();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId33();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId39();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId40();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId42();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId50();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId18();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId31();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId38();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId46();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId49();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId51();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId45();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId47();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId48();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId52();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId44();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId54();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId53();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId25Element();  // more than one getter call detected. Type: DEFAULT, precedence: 10
      build_domId28Element();  // more than one getter call detected. Type: DEFAULT, precedence: 10
      build_domId29Element();  // more than one getter call detected. Type: DEFAULT, precedence: 10
      build_domId24Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId26Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId27Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId30Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId36Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId37Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId15Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId16Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId17Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId21Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId22Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId23Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId34Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId35Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId41Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId43Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId14Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId19Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId20Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId32Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId33Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId39Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId40Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId42Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId50Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId18Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId31Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId38Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId46Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId49Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId51Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId45Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId47Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId48Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId52Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId44Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId54Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId53Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1(get_domId3());
    }
    SafeHtml template_html2() {
      return template.html2();
    }
    SafeHtml template_html3() {
      return template.html3();
    }
    SafeHtml template_html4() {
      return template.html4(get_domId8(), get_domId9(), get_domId10(), get_domId11());
    }
    SafeHtml template_html5() {
      return template.html5();
    }
    SafeHtml template_html6() {
      return template.html6(get_domId13());
    }
    SafeHtml template_html7() {
      return template.html7(get_domId15(), get_domId16(), get_domId17());
    }
    SafeHtml template_html8() {
      return template.html8(get_domId6(), get_domId7(), get_domId12(), get_domId14());
    }
    SafeHtml template_html9() {
      return template.html9();
    }
    SafeHtml template_html10() {
      return template.html10(get_domId25());
    }
    SafeHtml template_html11() {
      return template.html11();
    }
    SafeHtml template_html12() {
      return template.html12(get_domId28(), get_domId29());
    }
    SafeHtml template_html13() {
      return template.html13(get_domId24(), get_domId26(), get_domId27(), get_domId30());
    }
    SafeHtml template_html14() {
      return template.html14(get_domId21(), get_domId22(), get_domId23());
    }
    SafeHtml template_html15() {
      return template.html15(get_domId19(), get_domId20());
    }
    SafeHtml template_html16() {
      return template.html16(get_domId4(), get_domId5(), get_domId18());
    }
    SafeHtml template_html17() {
      return template.html17(get_domId36(), get_domId37());
    }
    SafeHtml template_html18() {
      return template.html18(get_domId34(), get_domId35());
    }
    SafeHtml template_html19() {
      return template.html19(get_domId32(), get_domId33());
    }
    SafeHtml template_html20() {
      return template.html20();
    }
    SafeHtml template_html21() {
      return template.html21(get_domId41());
    }
    SafeHtml template_html22() {
      return template.html22(get_domId43());
    }
    SafeHtml template_html23() {
      return template.html23(get_domId39(), get_domId40(), get_domId42());
    }
    SafeHtml template_html24() {
      return template.html24(get_domId31(), get_domId38());
    }
    SafeHtml template_html25() {
      return template.html25(get_domId46());
    }
    SafeHtml template_html26() {
      return template.html26();
    }
    SafeHtml template_html27() {
      return template.html27(get_domId50());
    }
    SafeHtml template_html28() {
      return template.html28();
    }
    SafeHtml template_html29() {
      return template.html29(get_domId49(), get_domId51());
    }
    SafeHtml template_html30() {
      return template.html30();
    }
    SafeHtml template_html31() {
      return template.html31(get_domId45(), get_domId47(), get_domId48(), get_domId52());
    }
    SafeHtml template_html32() {
      return template.html32(get_domId2(), get_domId44());
    }
    SafeHtml template_html33() {
      return template.html33(get_domId1());
    }
    SafeHtml template_html34() {
      return template.html34(get_domId54());
    }
    SafeHtml template_html35() {
      return template.html35(get_domId0(), get_domId53());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 2 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.profilepage.ProfilePageView_ProfilePageViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    private org.ednovo.gooru.client.mvp.profilepage.ProfilePageView_ProfilePageViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }
    private org.ednovo.gooru.client.mvp.profilepage.ProfilePageView_ProfilePageViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.profilepage.ProfilePageView_ProfilePageViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.profilepage.ProfilePageView_ProfilePageViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for ProfilePageStyle called 51 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.profilepage.ProfilePageView_ProfilePageViewUiBinderImpl_GenCss_ProfilePageStyle ProfilePageStyle;
    private org.ednovo.gooru.client.mvp.profilepage.ProfilePageView_ProfilePageViewUiBinderImpl_GenCss_ProfilePageStyle get_ProfilePageStyle() {
      return ProfilePageStyle;
    }
    private org.ednovo.gooru.client.mvp.profilepage.ProfilePageView_ProfilePageViewUiBinderImpl_GenCss_ProfilePageStyle build_ProfilePageStyle() {
      // Creation section.
      ProfilePageStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().ProfilePageStyle();
      // Setup section.
      ProfilePageStyle.ensureInjected();


      return ProfilePageStyle;
    }

    /**
     * Getter for res called 1 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.ShelfCBundle get_res() {
      return build_res();
    }
    private org.ednovo.gooru.client.mvp.shelf.ShelfCBundle build_res() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.ShelfCBundle res = owner.res;
      assert res != null : "UiField res with 'provided = true' was null";
      // Setup section.


      return res;
    }

    /**
     * Getter for ccb called 5 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle ccb;
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle get_ccb() {
      return ccb;
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle build_ccb() {
      // Creation section.
      ccb = owner.ccb;
      assert ccb != null : "UiField ccb with 'provided = true' was null";
      // Setup section.


      return ccb;
    }

    /**
     * Getter for settingsStyle called 12 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.profilepage.ProfilePageView_ProfilePageViewUiBinderImpl_GenCss_settingsStyle settingsStyle;
    private org.ednovo.gooru.client.mvp.profilepage.ProfilePageView_ProfilePageViewUiBinderImpl_GenCss_settingsStyle get_settingsStyle() {
      return settingsStyle;
    }
    private org.ednovo.gooru.client.mvp.profilepage.ProfilePageView_ProfilePageViewUiBinderImpl_GenCss_settingsStyle build_settingsStyle() {
      // Creation section.
      settingsStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().settingsStyle();
      // Setup section.
      settingsStyle.ensureInjected();


      owner.settingsStyle = settingsStyle;

      return settingsStyle;
    }

    /**
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html35().asString());
      // Setup section.
      f_HTMLPanel1.setStyleName("" + get_ProfilePageStyle().profileMainContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1226 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId0Element().get();
      get_domId53Element().get();

      // Detach section.
      attachRecord1226.detach();
      f_HTMLPanel1.addAndReplaceElement(get_profileOnContainerPanel(), get_domId0Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_profileOffContainerPanel(), get_domId53Element().get());

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
     * Getter for profileOnContainerPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_profileOnContainerPanel() {
      return build_profileOnContainerPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_profileOnContainerPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel profileOnContainerPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html33().asString());
      // Setup section.
      profileOnContainerPanel.setStyleName("" + get_ProfilePageStyle().profileContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1227 = UiBinderUtil.attachToDom(profileOnContainerPanel.getElement());
      get_domId1Element().get();

      // Detach section.
      attachRecord1227.detach();
      profileOnContainerPanel.addAndReplaceElement(get_f_HTMLPanel2(), get_domId1Element().get());

      owner.profileOnContainerPanel = profileOnContainerPanel;

      return profileOnContainerPanel;
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
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html32().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_ProfilePageStyle().userInfo() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1228 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_domId2Element().get();
      get_domId44Element().get();

      // Detach section.
      attachRecord1228.detach();
      f_HTMLPanel2.addAndReplaceElement(get_f_FlowPanel3(), get_domId2Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_f_HTMLPanel20(), get_domId44Element().get());

      return f_HTMLPanel2;
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
     * Getter for f_FlowPanel3 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel3() {
      return build_f_FlowPanel3();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel3 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel3.add(get_profileImageContainer());
      f_FlowPanel3.add(get_f_HTMLPanel4());
      f_FlowPanel3.add(get_f_HTMLPanel15());
      f_FlowPanel3.setStyleName("" + get_ProfilePageStyle().userMetaDataContainer() + "");


      return f_FlowPanel3;
    }

    /**
     * Getter for profileImageContainer called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_profileImageContainer() {
      return build_profileImageContainer();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_profileImageContainer() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel profileImageContainer = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html1().asString());
      // Setup section.
      profileImageContainer.setStyleName("" + get_ProfilePageStyle().avatar() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1229 = UiBinderUtil.attachToDom(profileImageContainer.getElement());
      get_domId3Element().get();

      // Detach section.
      attachRecord1229.detach();
      profileImageContainer.addAndReplaceElement(get_userProfilePic(), get_domId3Element().get());

      owner.profileImageContainer = profileImageContainer;

      return profileImageContainer;
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
     * Getter for userProfilePic called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Image get_userProfilePic() {
      return build_userProfilePic();
    }
    private com.google.gwt.user.client.ui.Image build_userProfilePic() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image userProfilePic = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.


      owner.userProfilePic = userProfilePic;

      return userProfilePic;
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
     * Getter for f_HTMLPanel4 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel4() {
      return build_f_HTMLPanel4();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel4 = new com.google.gwt.user.client.ui.HTMLPanel(template_html16().asString());
      // Setup section.
      f_HTMLPanel4.setStyleName("" + get_ProfilePageStyle().aboutUserText() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1230 = UiBinderUtil.attachToDom(f_HTMLPanel4.getElement());
      get_domId4Element().get();
      get_domId5Element().get();
      get_domId18Element().get();

      // Detach section.
      attachRecord1230.detach();
      f_HTMLPanel4.addAndReplaceElement(get_userName(), get_domId4Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_userMetadata(), get_domId5Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_bioMainContainer(), get_domId18Element().get());

      return f_HTMLPanel4;
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
     * Getter for userName called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_userName() {
      return build_userName();
    }
    private com.google.gwt.user.client.ui.Label build_userName() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label userName = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      userName.setStyleName("" + get_ProfilePageStyle().userName() + "");


      owner.userName = userName;

      return userName;
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
     * Getter for userMetadata called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_userMetadata() {
      return build_userMetadata();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_userMetadata() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel userMetadata = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html8().asString());
      // Setup section.
      userMetadata.setStyleName("" + get_ProfilePageStyle().userMetadata() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1231 = UiBinderUtil.attachToDom(userMetadata.getElement());
      get_domId6Element().get();
      get_domId7Element().get();
      get_domId12Element().get();
      get_domId14Element().get();

      // Detach section.
      attachRecord1231.detach();
      userMetadata.addAndReplaceElement(get_mySubjectsText(), get_domId6Element().get());
      userMetadata.addAndReplaceElement(get_metaDataContainer(), get_domId7Element().get());
      userMetadata.addAndReplaceElement(get_f_HTMLPanel5(), get_domId12Element().get());
      userMetadata.addAndReplaceElement(get_userCoursePopup(), get_domId14Element().get());

      owner.userMetadata = userMetadata;

      return userMetadata;
    }

    /**
     * Getter for domId6 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for mySubjectsText called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_mySubjectsText() {
      return build_mySubjectsText();
    }
    private com.google.gwt.user.client.ui.Label build_mySubjectsText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label mySubjectsText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      mySubjectsText.setStyleName("" + get_ProfilePageStyle().userDesc() + "");


      owner.mySubjectsText = mySubjectsText;

      return mySubjectsText;
    }

    /**
     * Getter for domId6Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId7 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for metaDataContainer called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_metaDataContainer() {
      return build_metaDataContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_metaDataContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel metaDataContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      metaDataContainer.setStyleName("" + get_ProfilePageStyle().metaDataContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1232 = UiBinderUtil.attachToDom(metaDataContainer.getElement());
      get_domId8Element().get();
      get_domId9Element().get();
      get_domId10Element().get();
      get_domId11Element().get();

      // Detach section.
      attachRecord1232.detach();
      metaDataContainer.addAndReplaceElement(get_addCourseGradeBtn(), get_domId8Element().get());
      metaDataContainer.addAndReplaceElement(get_userGradeList(), get_domId9Element().get());
      metaDataContainer.addAndReplaceElement(get_userCourseList(), get_domId10Element().get());
      metaDataContainer.addAndReplaceElement(get_moreGradeCourseLbl(), get_domId11Element().get());

      owner.metaDataContainer = metaDataContainer;

      return metaDataContainer;
    }

    /**
     * Getter for domId8 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for addCourseGradeBtn called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Button get_addCourseGradeBtn() {
      return build_addCourseGradeBtn();
    }
    private com.google.gwt.user.client.ui.Button build_addCourseGradeBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button addCourseGradeBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      addCourseGradeBtn.setStyleName("" + get_ProfilePageStyle().editButton() + "");
      addCourseGradeBtn.setVisible(false);


      owner.addCourseGradeBtn = addCourseGradeBtn;

      return addCourseGradeBtn;
    }

    /**
     * Getter for domId8Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId9 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for userGradeList called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_userGradeList() {
      return build_userGradeList();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_userGradeList() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel userGradeList = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      userGradeList.setStyleName("" + get_ProfilePageStyle().userCount() + "");


      owner.userGradeList = userGradeList;

      return userGradeList;
    }

    /**
     * Getter for domId9Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId10 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for userCourseList called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_userCourseList() {
      return build_userCourseList();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_userCourseList() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel userCourseList = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      userCourseList.setStyleName("" + get_ProfilePageStyle().userCourse() + "");


      owner.userCourseList = userCourseList;

      return userCourseList;
    }

    /**
     * Getter for domId10Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId11 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for moreGradeCourseLbl called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_moreGradeCourseLbl() {
      return build_moreGradeCourseLbl();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_moreGradeCourseLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel moreGradeCourseLbl = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      moreGradeCourseLbl.setStyleName("" + get_ProfilePageStyle().moreGradeCourseLbl() + "");


      owner.moreGradeCourseLbl = moreGradeCourseLbl;

      return moreGradeCourseLbl;
    }

    /**
     * Getter for domId11Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId7Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId12 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for f_HTMLPanel5 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel5() {
      return build_f_HTMLPanel5();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel5 = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.
      f_HTMLPanel5.setStyleName("" + get_ProfilePageStyle().gradeCourseEditBtnContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1233 = UiBinderUtil.attachToDom(f_HTMLPanel5.getElement());
      get_domId13Element().get();

      // Detach section.
      attachRecord1233.detach();
      f_HTMLPanel5.addAndReplaceElement(get_editPencil(), get_domId13Element().get());

      return f_HTMLPanel5;
    }

    /**
     * Getter for domId13 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for editPencil called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_editPencil() {
      return build_editPencil();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_editPencil() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel editPencil = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html5().asString());
      // Setup section.
      editPencil.setStyleName("" + get_ProfilePageStyle().editButton() + "");


      owner.editPencil = editPencil;

      return editPencil;
    }

    /**
     * Getter for domId13Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId12Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId14 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for userCoursePopup called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_userCoursePopup() {
      return build_userCoursePopup();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_userCoursePopup() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel userCoursePopup = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html7().asString());
      // Setup section.
      userCoursePopup.setStyleName("" + get_ProfilePageStyle().userCoursePopup() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1234 = UiBinderUtil.attachToDom(userCoursePopup.getElement());
      get_domId15Element().get();
      get_domId16Element().get();
      get_domId17Element().get();

      // Detach section.
      attachRecord1234.detach();
      userCoursePopup.addAndReplaceElement(get_f_FlowPanel6(), get_domId15Element().get());
      userCoursePopup.addAndReplaceElement(get_f_FlowPanel10(), get_domId16Element().get());
      userCoursePopup.addAndReplaceElement(get_f_FlowPanel12(), get_domId17Element().get());

      owner.userCoursePopup = userCoursePopup;

      return userCoursePopup;
    }

    /**
     * Getter for domId15 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for f_FlowPanel6 called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel6() {
      return build_f_FlowPanel6();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel6() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel6 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel6.add(get_f_FlowPanel7());
      f_FlowPanel6.add(get_f_FlowPanel8());
      f_FlowPanel6.setStyleName("" + get_ProfilePageStyle().profileGradeInfoContainer() + "");


      return f_FlowPanel6;
    }

    /**
     * Getter for f_FlowPanel7 called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel7() {
      return build_f_FlowPanel7();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel7() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel7 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel7.add(get_gradeText());
      f_FlowPanel7.setStyleName("" + get_ProfilePageStyle().profileGradeInfoTitleContainer() + "");


      return f_FlowPanel7;
    }

    /**
     * Getter for gradeText called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.Label get_gradeText() {
      return build_gradeText();
    }
    private com.google.gwt.user.client.ui.Label build_gradeText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label gradeText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      gradeText.setStyleName("" + get_ProfilePageStyle().profileGradeInfoTitle() + "");


      owner.gradeText = gradeText;

      return gradeText;
    }

    /**
     * Getter for f_FlowPanel8 called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel8() {
      return build_f_FlowPanel8();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel8() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel8 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel8.add(get_KinderGarten());
      f_FlowPanel8.add(get_f_FlowPanel9());
      f_FlowPanel8.add(get_higherEducation());
      f_FlowPanel8.setStyleName("" + get_ProfilePageStyle().profileGradeContentContainer() + "");


      return f_FlowPanel8;
    }

    /**
     * Getter for KinderGarten called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_KinderGarten() {
      return build_KinderGarten();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_KinderGarten() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel KinderGarten = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      KinderGarten.setStyleName("" + get_ProfilePageStyle().profileGradeGartenContainer() + "");


      owner.KinderGarten = KinderGarten;

      return KinderGarten;
    }

    /**
     * Getter for f_FlowPanel9 called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel9() {
      return build_f_FlowPanel9();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel9() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel9 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel9.add(get_gradeTopList());
      f_FlowPanel9.add(get_gradeMiddleList());
      f_FlowPanel9.setStyleName("" + get_ccb().css().gradeListCont() + "");


      return f_FlowPanel9;
    }

    /**
     * Getter for gradeTopList called 1 times. Type: DEFAULT. Build precedence: 11.
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
     * Getter for gradeMiddleList called 1 times. Type: DEFAULT. Build precedence: 11.
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
     * Getter for higherEducation called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_higherEducation() {
      return build_higherEducation();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_higherEducation() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel higherEducation = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      higherEducation.setStyleName("" + get_ProfilePageStyle().profileGradeGartenContainer() + "");


      owner.higherEducation = higherEducation;

      return higherEducation;
    }

    /**
     * Getter for domId15Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId16 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for f_FlowPanel10 called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel10() {
      return build_f_FlowPanel10();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel10() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel10 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel10.add(get_f_FlowPanel11());
      f_FlowPanel10.add(get_courseData());
      f_FlowPanel10.add(get_coursesPanel());
      f_FlowPanel10.setStyleName("" + get_ProfilePageStyle().profileGradeInfoContainer() + "");


      return f_FlowPanel10;
    }

    /**
     * Getter for f_FlowPanel11 called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel11() {
      return build_f_FlowPanel11();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel11() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel11 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel11.add(get_courseLabel());
      f_FlowPanel11.setStyleName("" + get_ProfilePageStyle().profileGradeInfoTitleContainer() + "");


      return f_FlowPanel11;
    }

    /**
     * Getter for courseLabel called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.Label get_courseLabel() {
      return build_courseLabel();
    }
    private com.google.gwt.user.client.ui.Label build_courseLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label courseLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      courseLabel.setStyleName("" + get_ProfilePageStyle().profileCourseInfoTitle() + "");


      owner.courseLabel = courseLabel;

      return courseLabel;
    }

    /**
     * Getter for courseData called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_courseData() {
      return build_courseData();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_courseData() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel courseData = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      courseData.add(get_collectionCourseLstPanel());
      courseData.add(get_addCourseBtn());
      courseData.add(get_courseMaxMsg());
      courseData.setStyleName("" + get_ProfilePageStyle().floatLeftCollectionInputBox() + "");


      owner.courseData = courseData;

      return courseData;
    }

    /**
     * Getter for collectionCourseLstPanel called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_collectionCourseLstPanel() {
      return build_collectionCourseLstPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_collectionCourseLstPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel collectionCourseLstPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      collectionCourseLstPanel.setStyleName("" + get_ccb().css().collectionCourseLstPanel() + "");


      owner.collectionCourseLstPanel = collectionCourseLstPanel;

      return collectionCourseLstPanel;
    }

    /**
     * Getter for addCourseBtn called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.Button get_addCourseBtn() {
      return build_addCourseBtn();
    }
    private com.google.gwt.user.client.ui.Button build_addCourseBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button addCourseBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      addCourseBtn.setStyleName("" + get_ccb().css().infoAddButton() + "");
      addCourseBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8);


      owner.addCourseBtn = addCourseBtn;

      return addCourseBtn;
    }

    /**
     * Getter for courseMaxMsg called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.Label get_courseMaxMsg() {
      return build_courseMaxMsg();
    }
    private com.google.gwt.user.client.ui.Label build_courseMaxMsg() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label courseMaxMsg = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      courseMaxMsg.setStyleName("" + get_ccb().css().courseMaxMsg() + "");


      owner.courseMaxMsg = courseMaxMsg;

      return courseMaxMsg;
    }

    /**
     * Getter for coursesPanel called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_coursesPanel() {
      return build_coursesPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_coursesPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel coursesPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      coursesPanel.setStyleName("" + get_ProfilePageStyle().addedCoursesList() + "");


      owner.coursesPanel = coursesPanel;

      return coursesPanel;
    }

    /**
     * Getter for domId16Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId17 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for f_FlowPanel12 called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel12() {
      return build_f_FlowPanel12();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel12() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel12 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel12.add(get_saveBtn());
      f_FlowPanel12.add(get_cancelBtn());
      f_FlowPanel12.setStyleName("" + get_ProfilePageStyle().coursePoupSaveBtnContainer() + "");


      return f_FlowPanel12;
    }

    /**
     * Getter for saveBtn called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.Button get_saveBtn() {
      return build_saveBtn();
    }
    private com.google.gwt.user.client.ui.Button build_saveBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button saveBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      saveBtn.setStyleName("" + get_ccb().css().infoAddButton() + "");
      saveBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);


      owner.saveBtn = saveBtn;

      return saveBtn;
    }

    /**
     * Getter for cancelBtn called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.Label get_cancelBtn() {
      return build_cancelBtn();
    }
    private com.google.gwt.user.client.ui.Label build_cancelBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label cancelBtn = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      cancelBtn.setStyleName("" + get_ProfilePageStyle().coursePopupCancelLbl() + "");
      cancelBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5);


      owner.cancelBtn = cancelBtn;

      return cancelBtn;
    }

    /**
     * Getter for domId17Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId14Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId18 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for bioMainContainer called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_bioMainContainer() {
      return build_bioMainContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_bioMainContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel bioMainContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html15().asString());
      // Setup section.
      bioMainContainer.setStyleName("" + get_ProfilePageStyle().bioMainContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1235 = UiBinderUtil.attachToDom(bioMainContainer.getElement());
      get_domId19Element().get();
      get_domId20Element().get();

      // Detach section.
      attachRecord1235.detach();
      bioMainContainer.addAndReplaceElement(get_aboutMeTextContainer(), get_domId19Element().get());
      bioMainContainer.addAndReplaceElement(get_f_HTMLPanel13(), get_domId20Element().get());

      owner.bioMainContainer = bioMainContainer;

      return bioMainContainer;
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
     * Getter for aboutMeTextContainer called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_aboutMeTextContainer() {
      return build_aboutMeTextContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_aboutMeTextContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel aboutMeTextContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      aboutMeTextContainer.setStyleName("" + get_ProfilePageStyle().bioLeftContainer() + "");


      owner.aboutMeTextContainer = aboutMeTextContainer;

      return aboutMeTextContainer;
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
     * Getter for domId20 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for f_HTMLPanel13 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel13() {
      return build_f_HTMLPanel13();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel13() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel13 = new com.google.gwt.user.client.ui.HTMLPanel(template_html14().asString());
      // Setup section.
      f_HTMLPanel13.setStyleName("" + get_ProfilePageStyle().bioRightContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1236 = UiBinderUtil.attachToDom(f_HTMLPanel13.getElement());
      get_domId21Element().get();
      get_domId22Element().get();
      get_domId23Element().get();

      // Detach section.
      attachRecord1236.detach();
      f_HTMLPanel13.addAndReplaceElement(get_addBioBtn(), get_domId21Element().get());
      f_HTMLPanel13.addAndReplaceElement(get_userBio(), get_domId22Element().get());
      f_HTMLPanel13.addAndReplaceElement(get_profilePageEditBioPanel(), get_domId23Element().get());

      return f_HTMLPanel13;
    }

    /**
     * Getter for domId21 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for addBioBtn called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Button get_addBioBtn() {
      return build_addBioBtn();
    }
    private com.google.gwt.user.client.ui.Button build_addBioBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button addBioBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      addBioBtn.setStyleName("" + get_ProfilePageStyle().editButton() + "");
      addBioBtn.setVisible(false);
      addBioBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);


      owner.addBioBtn = addBioBtn;

      return addBioBtn;
    }

    /**
     * Getter for domId21Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for userBio called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Label get_userBio() {
      return build_userBio();
    }
    private com.google.gwt.user.client.ui.Label build_userBio() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label userBio = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      userBio.setStyleName("" + get_ProfilePageStyle().userBio() + "");


      owner.userBio = userBio;

      return userBio;
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
     * Getter for domId23 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for profilePageEditBioPanel called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_profilePageEditBioPanel() {
      return build_profilePageEditBioPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_profilePageEditBioPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel profilePageEditBioPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html13().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1237 = UiBinderUtil.attachToDom(profilePageEditBioPanel.getElement());
      get_domId24Element().get();
      get_domId26Element().get();
      get_domId27Element().get();
      get_domId30Element().get();

      // Detach section.
      attachRecord1237.detach();
      profilePageEditBioPanel.addAndReplaceElement(get_profileDescriptionlabel(), get_domId24Element().get());
      profilePageEditBioPanel.addAndReplaceElement(get_noAboutUsContainer(), get_domId26Element().get());
      profilePageEditBioPanel.addAndReplaceElement(get_f_HTMLPanel14(), get_domId27Element().get());
      profilePageEditBioPanel.addAndReplaceElement(get_aboutUsCharacterValidation(), get_domId30Element().get());

      owner.profilePageEditBioPanel = profilePageEditBioPanel;

      return profilePageEditBioPanel;
    }

    /**
     * Getter for domId24 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for profileDescriptionlabel called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_profileDescriptionlabel() {
      return build_profileDescriptionlabel();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_profileDescriptionlabel() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel profileDescriptionlabel = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html10().asString());
      // Setup section.
      profileDescriptionlabel.setStyleName("" + get_ProfilePageStyle().bioTextAreaContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1238 = UiBinderUtil.attachToDom(profileDescriptionlabel.getElement());
      get_domId25Element().get();

      // Detach section.
      attachRecord1238.detach();
      profileDescriptionlabel.addAndReplaceElement(get_profileTextArea(), get_domId25Element().get());

      owner.profileDescriptionlabel = profileDescriptionlabel;

      return profileDescriptionlabel;
    }

    /**
     * Getter for domId25 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 10.
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
     * Getter for profileTextArea called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private org.ednovo.gooru.client.uc.ProfilePageDescriptionEditUc get_profileTextArea() {
      return build_profileTextArea();
    }
    private org.ednovo.gooru.client.uc.ProfilePageDescriptionEditUc build_profileTextArea() {
      // Creation section.
      final org.ednovo.gooru.client.uc.ProfilePageDescriptionEditUc profileTextArea = owner.profileTextArea;
      assert profileTextArea != null : "UiField profileTextArea with 'provided = true' was null";
      // Setup section.
      profileTextArea.setStyleName("" + get_settingsStyle().profileDescription() + "");


      return profileTextArea;
    }

    /**
     * Getter for domId25Element called 2 times. Type: DEFAULT. Build precedence: 10.
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
     * Getter for domId24Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId26 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for noAboutUsContainer called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.FocusPanel get_noAboutUsContainer() {
      return build_noAboutUsContainer();
    }
    private com.google.gwt.user.client.ui.FocusPanel build_noAboutUsContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FocusPanel noAboutUsContainer = (com.google.gwt.user.client.ui.FocusPanel) GWT.create(com.google.gwt.user.client.ui.FocusPanel.class);
      // Setup section.
      noAboutUsContainer.add(get_pencilTextAreaImage());
      noAboutUsContainer.setStyleName("" + get_settingsStyle().publicProfileTextarea() + "");


      owner.noAboutUsContainer = noAboutUsContainer;

      return noAboutUsContainer;
    }

    /**
     * Getter for pencilTextAreaImage called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_pencilTextAreaImage() {
      return build_pencilTextAreaImage();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_pencilTextAreaImage() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel pencilTextAreaImage = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html11().asString());
      // Setup section.
      pencilTextAreaImage.setStyleName("" + get_settingsStyle().publicProfilePencilIconNew() + "");


      owner.pencilTextAreaImage = pencilTextAreaImage;

      return pencilTextAreaImage;
    }

    /**
     * Getter for domId26Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId27 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for f_HTMLPanel14 called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel14() {
      return build_f_HTMLPanel14();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel14() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel14 = new com.google.gwt.user.client.ui.HTMLPanel(template_html12().asString());
      // Setup section.
      f_HTMLPanel14.setStyleName("" + get_settingsStyle().publicProfileSaveButtonContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1239 = UiBinderUtil.attachToDom(f_HTMLPanel14.getElement());
      get_domId28Element().get();
      get_domId29Element().get();

      // Detach section.
      attachRecord1239.detach();
      f_HTMLPanel14.addAndReplaceElement(get_btnSave(), get_domId28Element().get());
      f_HTMLPanel14.addAndReplaceElement(get_biographyCancelButton(), get_domId29Element().get());

      return f_HTMLPanel14;
    }

    /**
     * Getter for domId28 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 10.
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
     * Getter for btnSave called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.Button get_btnSave() {
      return build_btnSave();
    }
    private com.google.gwt.user.client.ui.Button build_btnSave() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button btnSave = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      btnSave.setStyleName("" + get_settingsStyle().publicProfileSaveButtonText() + " " + get_settingsStyle().publicProfileSaveButtonBg() + "");
      btnSave.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6);


      owner.btnSave = btnSave;

      return btnSave;
    }

    /**
     * Getter for domId28Element called 2 times. Type: DEFAULT. Build precedence: 10.
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
     * Getter for domId29 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 10.
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
     * Getter for biographyCancelButton called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.Button get_biographyCancelButton() {
      return build_biographyCancelButton();
    }
    private com.google.gwt.user.client.ui.Button build_biographyCancelButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button biographyCancelButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      biographyCancelButton.setStyleName("" + get_settingsStyle().publicProfileCancelText() + "");
      biographyCancelButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7);


      owner.biographyCancelButton = biographyCancelButton;

      return biographyCancelButton;
    }

    /**
     * Getter for domId29Element called 2 times. Type: DEFAULT. Build precedence: 10.
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
     * Getter for domId27Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId30 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for aboutUsCharacterValidation called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.Label get_aboutUsCharacterValidation() {
      return build_aboutUsCharacterValidation();
    }
    private com.google.gwt.user.client.ui.Label build_aboutUsCharacterValidation() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label aboutUsCharacterValidation = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      aboutUsCharacterValidation.setStyleName("" + get_settingsStyle().mandatoryAboutUsLabel() + "");


      owner.aboutUsCharacterValidation = aboutUsCharacterValidation;

      return aboutUsCharacterValidation;
    }

    /**
     * Getter for domId30Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId23Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId20Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId18Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for f_HTMLPanel15 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel15() {
      return build_f_HTMLPanel15();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel15() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel15 = new com.google.gwt.user.client.ui.HTMLPanel(template_html24().asString());
      // Setup section.
      f_HTMLPanel15.setStyleName("" + get_ProfilePageStyle().aboutUserTextRight() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1240 = UiBinderUtil.attachToDom(f_HTMLPanel15.getElement());
      get_domId31Element().get();
      get_domId38Element().get();

      // Detach section.
      attachRecord1240.detach();
      f_HTMLPanel15.addAndReplaceElement(get_f_HTMLPanel16(), get_domId31Element().get());
      f_HTMLPanel15.addAndReplaceElement(get_gooruSocialButtonsContainer(), get_domId38Element().get());

      return f_HTMLPanel15;
    }

    /**
     * Getter for domId31 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for f_HTMLPanel16 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel16() {
      return build_f_HTMLPanel16();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel16() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel16 = new com.google.gwt.user.client.ui.HTMLPanel(template_html19().asString());
      // Setup section.
      f_HTMLPanel16.setStyleName("" + get_ProfilePageStyle().hoverButtons() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1241 = UiBinderUtil.attachToDom(f_HTMLPanel16.getElement());
      get_domId32Element().get();
      get_domId33Element().get();

      // Detach section.
      attachRecord1241.detach();
      f_HTMLPanel16.addAndReplaceElement(get_profilePageViewMsg(), get_domId32Element().get());
      f_HTMLPanel16.addAndReplaceElement(get_gooruProfileOnOffContainer(), get_domId33Element().get());

      return f_HTMLPanel16;
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
     * Getter for profilePageViewMsg called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_profilePageViewMsg() {
      return build_profilePageViewMsg();
    }
    private com.google.gwt.user.client.ui.Label build_profilePageViewMsg() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label profilePageViewMsg = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      profilePageViewMsg.setVisible(false);


      owner.profilePageViewMsg = profilePageViewMsg;

      return profilePageViewMsg;
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
     * Getter for gooruProfileOnOffContainer called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_gooruProfileOnOffContainer() {
      return build_gooruProfileOnOffContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_gooruProfileOnOffContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel gooruProfileOnOffContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html18().asString());
      // Setup section.
      gooruProfileOnOffContainer.setStyleName("" + get_ProfilePageStyle().gooruProfileOnOffContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1242 = UiBinderUtil.attachToDom(gooruProfileOnOffContainer.getElement());
      get_domId34Element().get();
      get_domId35Element().get();

      // Detach section.
      attachRecord1242.detach();
      gooruProfileOnOffContainer.addAndReplaceElement(get_profilePageText(), get_domId34Element().get());
      gooruProfileOnOffContainer.addAndReplaceElement(get_f_HTMLPanel17(), get_domId35Element().get());

      owner.gooruProfileOnOffContainer = gooruProfileOnOffContainer;

      return gooruProfileOnOffContainer;
    }

    /**
     * Getter for domId34 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for profilePageText called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Label get_profilePageText() {
      return build_profilePageText();
    }
    private com.google.gwt.user.client.ui.Label build_profilePageText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label profilePageText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      profilePageText.setStyleName("" + get_settingsStyle().publicProfileTitle() + "");


      owner.profilePageText = profilePageText;

      return profilePageText;
    }

    /**
     * Getter for domId34Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for f_HTMLPanel17 called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel17() {
      return build_f_HTMLPanel17();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel17() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel17 = new com.google.gwt.user.client.ui.HTMLPanel(template_html17().asString());
      // Setup section.
      f_HTMLPanel17.setStyleName("" + get_settingsStyle().publicProfileOnButtonContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1243 = UiBinderUtil.attachToDom(f_HTMLPanel17.getElement());
      get_domId36Element().get();
      get_domId37Element().get();

      // Detach section.
      attachRecord1243.detach();
      f_HTMLPanel17.addAndReplaceElement(get_profileOnButton(), get_domId36Element().get());
      f_HTMLPanel17.addAndReplaceElement(get_profileOffButton(), get_domId37Element().get());

      return f_HTMLPanel17;
    }

    /**
     * Getter for domId36 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for profileOnButton called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.Button get_profileOnButton() {
      return build_profileOnButton();
    }
    private com.google.gwt.user.client.ui.Button build_profileOnButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button profileOnButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      profileOnButton.setStyleName("" + get_settingsStyle().publicProfileOnButtonActive() + "");


      owner.profileOnButton = profileOnButton;

      return profileOnButton;
    }

    /**
     * Getter for domId36Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId37 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for profileOffButton called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.Button get_profileOffButton() {
      return build_profileOffButton();
    }
    private com.google.gwt.user.client.ui.Button build_profileOffButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button profileOffButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      profileOffButton.setStyleName("" + get_settingsStyle().publicProfileOffButtonsDeActive() + "");
      profileOffButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.profileOffButton = profileOffButton;

      return profileOffButton;
    }

    /**
     * Getter for domId37Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId31Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId38 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for gooruSocialButtonsContainer called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_gooruSocialButtonsContainer() {
      return build_gooruSocialButtonsContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_gooruSocialButtonsContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel gooruSocialButtonsContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html23().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1244 = UiBinderUtil.attachToDom(gooruSocialButtonsContainer.getElement());
      get_domId39Element().get();
      get_domId40Element().get();
      get_domId42Element().get();

      // Detach section.
      attachRecord1244.detach();
      gooruSocialButtonsContainer.addAndReplaceElement(get_shareWithOthersText(), get_domId39Element().get());
      gooruSocialButtonsContainer.addAndReplaceElement(get_f_HTMLPanel18(), get_domId40Element().get());
      gooruSocialButtonsContainer.addAndReplaceElement(get_f_HTMLPanel19(), get_domId42Element().get());

      owner.gooruSocialButtonsContainer = gooruSocialButtonsContainer;

      return gooruSocialButtonsContainer;
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
     * Getter for shareWithOthersText called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_shareWithOthersText() {
      return build_shareWithOthersText();
    }
    private com.google.gwt.user.client.ui.Label build_shareWithOthersText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label shareWithOthersText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      shareWithOthersText.setStyleName("" + get_ProfilePageStyle().shareRightDesc() + "");


      owner.shareWithOthersText = shareWithOthersText;

      return shareWithOthersText;
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
     * Getter for domId40 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for f_HTMLPanel18 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel18() {
      return build_f_HTMLPanel18();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel18() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel18 = new com.google.gwt.user.client.ui.HTMLPanel(template_html21().asString());
      // Setup section.
      f_HTMLPanel18.setStyleName("" + get_ProfilePageStyle().gooruSocialButtons() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1245 = UiBinderUtil.attachToDom(f_HTMLPanel18.getElement());
      get_domId41Element().get();

      // Detach section.
      attachRecord1245.detach();
      f_HTMLPanel18.addAndReplaceElement(get_socialButtonContainer(), get_domId41Element().get());

      return f_HTMLPanel18;
    }

    /**
     * Getter for domId41 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for socialButtonContainer called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_socialButtonContainer() {
      return build_socialButtonContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_socialButtonContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel socialButtonContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html20().asString());
      // Setup section.


      owner.socialButtonContainer = socialButtonContainer;

      return socialButtonContainer;
    }

    /**
     * Getter for domId41Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId40Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId42 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for f_HTMLPanel19 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel19() {
      return build_f_HTMLPanel19();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel19() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel19 = new com.google.gwt.user.client.ui.HTMLPanel(template_html22().asString());
      // Setup section.
      f_HTMLPanel19.setStyleName("" + get_ProfilePageStyle().gooruSocialInput() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1246 = UiBinderUtil.attachToDom(f_HTMLPanel19.getElement());
      get_domId43Element().get();

      // Detach section.
      attachRecord1246.detach();
      f_HTMLPanel19.addAndReplaceElement(get_bitlyLink(), get_domId43Element().get());

      return f_HTMLPanel19;
    }

    /**
     * Getter for domId43 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for bitlyLink called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.TextBox get_bitlyLink() {
      return build_bitlyLink();
    }
    private com.google.gwt.user.client.ui.TextBox build_bitlyLink() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox bitlyLink = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.
      bitlyLink.setStyleName("" + get_ProfilePageStyle().gooruSocialUrl() + "");
      bitlyLink.setReadOnly(true);


      owner.bitlyLink = bitlyLink;

      return bitlyLink;
    }

    /**
     * Getter for domId43Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId42Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId38Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId44 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for f_HTMLPanel20 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel20() {
      return build_f_HTMLPanel20();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel20() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel20 = new com.google.gwt.user.client.ui.HTMLPanel(template_html31().asString());
      // Setup section.
      f_HTMLPanel20.setStyleName("" + get_ProfilePageStyle().userContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1247 = UiBinderUtil.attachToDom(f_HTMLPanel20.getElement());
      get_domId45Element().get();
      get_domId47Element().get();
      get_domId48Element().get();
      get_domId52Element().get();

      // Detach section.
      attachRecord1247.detach();
      f_HTMLPanel20.addAndReplaceElement(get_f_HTMLPanel21(), get_domId45Element().get());
      f_HTMLPanel20.addAndReplaceElement(get_loadingPanel(), get_domId47Element().get());
      f_HTMLPanel20.addAndReplaceElement(get_contentview(), get_domId48Element().get());
      f_HTMLPanel20.addAndReplaceElement(get_shareLinkFloPanel(), get_domId52Element().get());

      return f_HTMLPanel20;
    }

    /**
     * Getter for domId45 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel21 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel21() {
      return build_f_HTMLPanel21();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel21() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel21 = new com.google.gwt.user.client.ui.HTMLPanel(template_html25().asString());
      // Setup section.
      f_HTMLPanel21.setStyleName("" + get_ProfilePageStyle().tabs() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1248 = UiBinderUtil.attachToDom(f_HTMLPanel21.getElement());
      get_domId46Element().get();

      // Detach section.
      attachRecord1248.detach();
      f_HTMLPanel21.addAndReplaceElement(get_contentTabVc(), get_domId46Element().get());

      return f_HTMLPanel21;
    }

    /**
     * Getter for domId46 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for contentTabVc called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Anchor get_contentTabVc() {
      return build_contentTabVc();
    }
    private com.google.gwt.user.client.ui.Anchor build_contentTabVc() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor contentTabVc = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      contentTabVc.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.contentTabVc = contentTabVc;

      return contentTabVc;
    }

    /**
     * Getter for domId46Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId45Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId47 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for loadingPanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_loadingPanel() {
      return build_loadingPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_loadingPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel loadingPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html26().asString());
      // Setup section.
      loadingPanel.setStyleName("" + get_ProfilePageStyle().loadingImage() + "");


      owner.loadingPanel = loadingPanel;

      return loadingPanel;
    }

    /**
     * Getter for domId47Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId48 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for contentview called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_contentview() {
      return build_contentview();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_contentview() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel contentview = new com.google.gwt.user.client.ui.HTMLPanel(template_html29().asString());
      // Setup section.
      contentview.setStyleName("" + get_ProfilePageStyle().contentView() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1249 = UiBinderUtil.attachToDom(contentview.getElement());
      get_domId49Element().get();
      get_domId51Element().get();

      // Detach section.
      attachRecord1249.detach();
      contentview.addAndReplaceElement(get_contentNavigationPanel(), get_domId49Element().get());
      contentview.addAndReplaceElement(get_publicPPRightContainer(), get_domId51Element().get());

      owner.contentview = contentview;

      return contentview;
    }

    /**
     * Getter for domId49 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for contentNavigationPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_contentNavigationPanel() {
      return build_contentNavigationPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_contentNavigationPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel contentNavigationPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html27().asString());
      // Setup section.
      contentNavigationPanel.setStyleName("" + get_ProfilePageStyle().contentNavigationPanel() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1250 = UiBinderUtil.attachToDom(contentNavigationPanel.getElement());
      get_domId50Element().get();

      // Detach section.
      attachRecord1250.detach();
      contentNavigationPanel.addAndReplaceElement(get_shelfTabSimPanel(), get_domId50Element().get());

      owner.contentNavigationPanel = contentNavigationPanel;

      return contentNavigationPanel;
    }

    /**
     * Getter for domId50 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for shelfTabSimPanel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_shelfTabSimPanel() {
      return build_shelfTabSimPanel();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_shelfTabSimPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel shelfTabSimPanel = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.
      shelfTabSimPanel.setStyleName("" + get_ProfilePageStyle().folders() + "");


      owner.shelfTabSimPanel = shelfTabSimPanel;

      return shelfTabSimPanel;
    }

    /**
     * Getter for domId50Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId49Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId51 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for publicPPRightContainer called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_publicPPRightContainer() {
      return build_publicPPRightContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_publicPPRightContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel publicPPRightContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html28().asString());
      // Setup section.
      publicPPRightContainer.setStyleName("" + get_ProfilePageStyle().contentVisualView() + "");


      owner.publicPPRightContainer = publicPPRightContainer;

      return publicPPRightContainer;
    }

    /**
     * Getter for domId51Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId48Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId52 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for shareLinkFloPanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_shareLinkFloPanel() {
      return build_shareLinkFloPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_shareLinkFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel shareLinkFloPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html30().asString());
      // Setup section.
      shareLinkFloPanel.setStyleName("" + get_res().css().shareLinkFlowPanel() + "");


      owner.shareLinkFloPanel = shareLinkFloPanel;

      return shareLinkFloPanel;
    }

    /**
     * Getter for domId52Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId44Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId53 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for profileOffContainerPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_profileOffContainerPanel() {
      return build_profileOffContainerPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_profileOffContainerPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel profileOffContainerPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html34().asString());
      // Setup section.
      profileOffContainerPanel.setStyleName("" + get_ProfilePageStyle().profileOffConatinerStyle() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1251 = UiBinderUtil.attachToDom(profileOffContainerPanel.getElement());
      get_domId54Element().get();

      // Detach section.
      attachRecord1251.detach();
      profileOffContainerPanel.addAndReplaceElement(get_errorImage(), get_domId54Element().get());

      owner.profileOffContainerPanel = profileOffContainerPanel;

      return profileOffContainerPanel;
    }

    /**
     * Getter for domId54 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for errorImage called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Image get_errorImage() {
      return build_errorImage();
    }
    private com.google.gwt.user.client.ui.Image build_errorImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image errorImage = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.


      owner.errorImage = errorImage;

      return errorImage;
    }

    /**
     * Getter for domId54Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId53Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
  }
}
