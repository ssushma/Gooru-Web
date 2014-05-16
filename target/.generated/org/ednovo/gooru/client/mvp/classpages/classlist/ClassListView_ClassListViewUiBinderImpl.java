package org.ednovo.gooru.client.mvp.classpages.classlist;

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

public class ClassListView_ClassListViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.classpages.classlist.ClassListView>, org.ednovo.gooru.client.mvp.classpages.classlist.ClassListView.ClassListViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html2(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html3(String arg0, String arg1, String arg2);
     
    @Template("")
    SafeHtml html4();
     
    @Template("")
    SafeHtml html5();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span>")
    SafeHtml html6(String arg0, String arg1, String arg2, String arg3, String arg4);
     
    @Template("")
    SafeHtml html7();
     
    @Template("")
    SafeHtml html8();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html9(String arg0, String arg1, String arg2, String arg3);
     
    @Template("")
    SafeHtml html10();
     
    @Template("")
    SafeHtml html11();
     
    @Template("")
    SafeHtml html12();
     
    @Template("")
    SafeHtml html13();
     
    @Template("")
    SafeHtml html14();
     
    @Template("")
    SafeHtml html15();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html16(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span>  <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html17(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html18(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html19(String arg0, String arg1, String arg2, String arg3);
     
    @Template("")
    SafeHtml html20();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html21(String arg0, String arg1, String arg2);
     
    @Template("")
    SafeHtml html22();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html23(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html24(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html25(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>  <span id='{4}'></span>")
    SafeHtml html26(String arg0, String arg1, String arg2, String arg3, String arg4);
     
    @Template("")
    SafeHtml html27();
     
    @Template("")
    SafeHtml html28();
     
    @Template("")
    SafeHtml html29();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html30(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html31(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html32(String arg0, String arg1, String arg2, String arg3);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span>")
    SafeHtml html33(String arg0, String arg1, String arg2, String arg3, String arg4);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html34(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span>  <span id='{5}'></span>  <span id='{6}'></span>")
    SafeHtml html35(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.classpages.classlist.ClassListView owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.classpages.classlist.ClassListView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickPendingListSeeMore(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickActiveListSeeMore(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onCheckBoxClicked(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onInviteOnlytextclicked(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onOpentextclicked(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.OnClickInvite(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.classpages.classlist.ClassListView owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_domId29();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId30();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId31();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId27();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId28();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId32();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId25();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId26();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId36();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId37();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId38();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId40();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId41();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId42();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId22();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId23();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId24();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId33();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId35();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId39();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId44();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId48();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId49();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId52();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId53();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId54();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId55();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId57();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId58();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId59();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId60();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId61();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId14();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId15();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId16();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId17();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId19();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId20();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId21();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId34();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId43();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId46();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId47();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId51();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId56();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId18();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId45();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId50();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId29Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId30Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId31Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId27Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId28Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId32Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId25Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId26Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId36Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId37Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId38Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId40Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId41Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId42Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId22Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId23Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId24Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId33Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId35Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId39Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId44Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId48Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId49Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId52Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId53Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId54Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId55Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId57Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId58Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId59Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId60Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId61Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId14Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId15Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId16Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId17Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId19Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId20Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId21Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId34Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId43Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId46Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId47Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId51Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId56Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId18Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId45Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId50Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2(get_domId4(), get_domId5());
    }
    SafeHtml template_html3() {
      return template.html3(get_domId2(), get_domId3(), get_domId6());
    }
    SafeHtml template_html4() {
      return template.html4();
    }
    SafeHtml template_html5() {
      return template.html5();
    }
    SafeHtml template_html6() {
      return template.html6(get_domId8(), get_domId9(), get_domId10(), get_domId11(), get_domId12());
    }
    SafeHtml template_html7() {
      return template.html7();
    }
    SafeHtml template_html8() {
      return template.html8();
    }
    SafeHtml template_html9() {
      return template.html9(get_domId14(), get_domId15(), get_domId16(), get_domId17());
    }
    SafeHtml template_html10() {
      return template.html10();
    }
    SafeHtml template_html11() {
      return template.html11();
    }
    SafeHtml template_html12() {
      return template.html12();
    }
    SafeHtml template_html13() {
      return template.html13();
    }
    SafeHtml template_html14() {
      return template.html14();
    }
    SafeHtml template_html15() {
      return template.html15();
    }
    SafeHtml template_html16() {
      return template.html16(get_domId29(), get_domId30(), get_domId31());
    }
    SafeHtml template_html17() {
      return template.html17(get_domId27(), get_domId28(), get_domId32());
    }
    SafeHtml template_html18() {
      return template.html18(get_domId25(), get_domId26());
    }
    SafeHtml template_html19() {
      return template.html19(get_domId22(), get_domId23(), get_domId24(), get_domId33());
    }
    SafeHtml template_html20() {
      return template.html20();
    }
    SafeHtml template_html21() {
      return template.html21(get_domId36(), get_domId37(), get_domId38());
    }
    SafeHtml template_html22() {
      return template.html22();
    }
    SafeHtml template_html23() {
      return template.html23(get_domId40(), get_domId41(), get_domId42());
    }
    SafeHtml template_html24() {
      return template.html24(get_domId35(), get_domId39());
    }
    SafeHtml template_html25() {
      return template.html25(get_domId44());
    }
    SafeHtml template_html26() {
      return template.html26(get_domId19(), get_domId20(), get_domId21(), get_domId34(), get_domId43());
    }
    SafeHtml template_html27() {
      return template.html27();
    }
    SafeHtml template_html28() {
      return template.html28();
    }
    SafeHtml template_html29() {
      return template.html29();
    }
    SafeHtml template_html30() {
      return template.html30(get_domId48(), get_domId49());
    }
    SafeHtml template_html31() {
      return template.html31(get_domId46(), get_domId47());
    }
    SafeHtml template_html32() {
      return template.html32(get_domId52(), get_domId53(), get_domId54(), get_domId55());
    }
    SafeHtml template_html33() {
      return template.html33(get_domId57(), get_domId58(), get_domId59(), get_domId60(), get_domId61());
    }
    SafeHtml template_html34() {
      return template.html34(get_domId51(), get_domId56());
    }
    SafeHtml template_html35() {
      return template.html35(get_domId0(), get_domId1(), get_domId7(), get_domId13(), get_domId18(), get_domId45(), get_domId50());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.classpages.classlist.ClassListView_ClassListViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.classpages.classlist.ClassListView_ClassListViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.classpages.classlist.ClassListView_ClassListViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.classpages.classlist.ClassListView_ClassListViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.classpages.classlist.ClassListView_ClassListViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 49 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.classpages.classlist.ClasslistpageCBundle res;
    private org.ednovo.gooru.client.mvp.classpages.classlist.ClasslistpageCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.mvp.classpages.classlist.ClasslistpageCBundle build_res() {
      // Creation section.
      res = owner.res;
      assert res != null : "UiField res with 'provided = true' was null";
      // Setup section.


      return res;
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
      f_FlowPanel1.add(get_f_HTMLPanel2());
      f_FlowPanel1.setStyleName("" + get_res().css().teachContainer() + "");


      return f_FlowPanel1;
    }

    /**
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html35().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_res().css().teachContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2127 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_domId0Element().get();
      get_domId1Element().get();
      get_domId7Element().get();
      get_domId13Element().get();
      get_domId18Element().get();
      get_domId45Element().get();
      get_domId50Element().get();

      // Detach section.
      attachRecord2127.detach();
      f_HTMLPanel2.addAndReplaceElement(get_assignHeader(), get_domId0Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_f_HTMLPanel3(), get_domId1Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_privateMsgPanel(), get_domId7Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_publicMsgPanel(), get_domId13Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_f_HTMLPanel6(), get_domId18Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_panelNoMembers(), get_domId45Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_panelMembersList(), get_domId50Element().get());

      return f_HTMLPanel2;
    }

    /**
     * Getter for domId0 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for assignHeader called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_assignHeader() {
      return build_assignHeader();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_assignHeader() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel assignHeader = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      assignHeader.setStyleName("" + get_res().css().teachTitle() + "");


      owner.assignHeader = assignHeader;

      return assignHeader;
    }

    /**
     * Getter for domId0Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      f_HTMLPanel3.setStyleName("toggle " + get_res().css().publicPrivate() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2128 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
      get_domId2Element().get();
      get_domId3Element().get();
      get_domId6Element().get();

      // Detach section.
      attachRecord2128.detach();
      f_HTMLPanel3.addAndReplaceElement(get_checkbox(), get_domId2Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_f_HTMLPanel4(), get_domId3Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_f_Anchor5(), get_domId6Element().get());

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
     * Getter for checkbox called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.SimpleCheckBox get_checkbox() {
      return build_checkbox();
    }
    private com.google.gwt.user.client.ui.SimpleCheckBox build_checkbox() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimpleCheckBox checkbox = (com.google.gwt.user.client.ui.SimpleCheckBox) GWT.create(com.google.gwt.user.client.ui.SimpleCheckBox.class);
      // Setup section.
      checkbox.setStyleName("" + get_res().css().checkboxStyle() + "");
      checkbox.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);


      owner.checkbox = checkbox;

      return checkbox;
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
     * Getter for f_HTMLPanel4 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel4() {
      return build_f_HTMLPanel4();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel4 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      f_HTMLPanel4.setStyleName("toggleSpanMainDiv");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2129 = UiBinderUtil.attachToDom(f_HTMLPanel4.getElement());
      get_domId4Element().get();
      get_domId5Element().get();

      // Detach section.
      attachRecord2129.detach();
      f_HTMLPanel4.addAndReplaceElement(get_inviteOnlyTxt(), get_domId4Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_publicTitleTxt(), get_domId5Element().get());

      return f_HTMLPanel4;
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
     * Getter for inviteOnlyTxt called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_inviteOnlyTxt() {
      return build_inviteOnlyTxt();
    }
    private com.google.gwt.user.client.ui.Label build_inviteOnlyTxt() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label inviteOnlyTxt = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      inviteOnlyTxt.setStyleName("");
      inviteOnlyTxt.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);


      owner.inviteOnlyTxt = inviteOnlyTxt;

      return inviteOnlyTxt;
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
     * Getter for domId5 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for publicTitleTxt called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_publicTitleTxt() {
      return build_publicTitleTxt();
    }
    private com.google.gwt.user.client.ui.Label build_publicTitleTxt() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label publicTitleTxt = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      publicTitleTxt.setStyleName("");
      publicTitleTxt.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5);


      owner.publicTitleTxt = publicTitleTxt;

      return publicTitleTxt;
    }

    /**
     * Getter for domId5Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for f_Anchor5 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Anchor get_f_Anchor5() {
      return build_f_Anchor5();
    }
    private com.google.gwt.user.client.ui.Anchor build_f_Anchor5() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor f_Anchor5 = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.


      return f_Anchor5;
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
     * Getter for domId7 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for privateMsgPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_privateMsgPanel() {
      return build_privateMsgPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_privateMsgPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel privateMsgPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.
      privateMsgPanel.setStyleName("" + get_res().css().teachDesc() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2130 = UiBinderUtil.attachToDom(privateMsgPanel.getElement());
      get_domId8Element().get();
      get_domId9Element().get();
      get_domId10Element().get();
      get_domId11Element().get();
      get_domId12Element().get();

      // Detach section.
      attachRecord2130.detach();
      privateMsgPanel.addAndReplaceElement(get_privateMsgDesc(), get_domId8Element().get());
      privateMsgPanel.addAndReplaceElement(get_invite(), get_domId9Element().get());
      privateMsgPanel.addAndReplaceElement(get_inviteTextDesc(), get_domId10Element().get());
      privateMsgPanel.addAndReplaceElement(get_publicClassTxt(), get_domId11Element().get());
      privateMsgPanel.addAndReplaceElement(get_publicDescTxt(), get_domId12Element().get());

      owner.privateMsgPanel = privateMsgPanel;

      return privateMsgPanel;
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
     * Getter for privateMsgDesc called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.InlineHTML get_privateMsgDesc() {
      return build_privateMsgDesc();
    }
    private com.google.gwt.user.client.ui.InlineHTML build_privateMsgDesc() {
      // Creation section.
      final com.google.gwt.user.client.ui.InlineHTML privateMsgDesc = (com.google.gwt.user.client.ui.InlineHTML) GWT.create(com.google.gwt.user.client.ui.InlineHTML.class);
      // Setup section.


      owner.privateMsgDesc = privateMsgDesc;

      return privateMsgDesc;
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
     * Getter for invite called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_invite() {
      return build_invite();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_invite() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel invite = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      invite.setStyleName("" + get_res().css().teachItalic() + "");


      owner.invite = invite;

      return invite;
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
     * Getter for inviteTextDesc called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.InlineHTML get_inviteTextDesc() {
      return build_inviteTextDesc();
    }
    private com.google.gwt.user.client.ui.InlineHTML build_inviteTextDesc() {
      // Creation section.
      final com.google.gwt.user.client.ui.InlineHTML inviteTextDesc = (com.google.gwt.user.client.ui.InlineHTML) GWT.create(com.google.gwt.user.client.ui.InlineHTML.class);
      // Setup section.


      owner.inviteTextDesc = inviteTextDesc;

      return inviteTextDesc;
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
     * Getter for publicClassTxt called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_publicClassTxt() {
      return build_publicClassTxt();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_publicClassTxt() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel publicClassTxt = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.
      publicClassTxt.setStyleName("" + get_res().css().teachBold() + "");


      owner.publicClassTxt = publicClassTxt;

      return publicClassTxt;
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
     * Getter for publicDescTxt called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.InlineHTML get_publicDescTxt() {
      return build_publicDescTxt();
    }
    private com.google.gwt.user.client.ui.InlineHTML build_publicDescTxt() {
      // Creation section.
      final com.google.gwt.user.client.ui.InlineHTML publicDescTxt = (com.google.gwt.user.client.ui.InlineHTML) GWT.create(com.google.gwt.user.client.ui.InlineHTML.class);
      // Setup section.


      owner.publicDescTxt = publicDescTxt;

      return publicDescTxt;
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
     * Getter for domId7Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for publicMsgPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_publicMsgPanel() {
      return build_publicMsgPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_publicMsgPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel publicMsgPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      publicMsgPanel.setStyleName("" + get_res().css().teachDesc() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2131 = UiBinderUtil.attachToDom(publicMsgPanel.getElement());
      get_domId14Element().get();
      get_domId15Element().get();
      get_domId16Element().get();
      get_domId17Element().get();

      // Detach section.
      attachRecord2131.detach();
      publicMsgPanel.addAndReplaceElement(get_publicTxtDesc(), get_domId14Element().get());
      publicMsgPanel.addAndReplaceElement(get_publicTxt(), get_domId15Element().get());
      publicMsgPanel.addAndReplaceElement(get_inviteTxt(), get_domId16Element().get());
      publicMsgPanel.addAndReplaceElement(get_inviteDesc(), get_domId17Element().get());

      owner.publicMsgPanel = publicMsgPanel;

      return publicMsgPanel;
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
     * Getter for publicTxtDesc called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.InlineHTML get_publicTxtDesc() {
      return build_publicTxtDesc();
    }
    private com.google.gwt.user.client.ui.InlineHTML build_publicTxtDesc() {
      // Creation section.
      final com.google.gwt.user.client.ui.InlineHTML publicTxtDesc = (com.google.gwt.user.client.ui.InlineHTML) GWT.create(com.google.gwt.user.client.ui.InlineHTML.class);
      // Setup section.


      owner.publicTxtDesc = publicTxtDesc;

      return publicTxtDesc;
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
     * Getter for publicTxt called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_publicTxt() {
      return build_publicTxt();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_publicTxt() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel publicTxt = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.
      publicTxt.setStyleName("" + get_res().css().teachBold() + "");


      owner.publicTxt = publicTxt;

      return publicTxt;
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
     * Getter for inviteTxt called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_inviteTxt() {
      return build_inviteTxt();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_inviteTxt() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel inviteTxt = new com.google.gwt.user.client.ui.HTMLPanel(template_html8().asString());
      // Setup section.
      inviteTxt.setStyleName("" + get_res().css().teachItalic() + "");


      owner.inviteTxt = inviteTxt;

      return inviteTxt;
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
     * Getter for inviteDesc called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.InlineHTML get_inviteDesc() {
      return build_inviteDesc();
    }
    private com.google.gwt.user.client.ui.InlineHTML build_inviteDesc() {
      // Creation section.
      final com.google.gwt.user.client.ui.InlineHTML inviteDesc = (com.google.gwt.user.client.ui.InlineHTML) GWT.create(com.google.gwt.user.client.ui.InlineHTML.class);
      // Setup section.


      owner.inviteDesc = inviteDesc;

      return inviteDesc;
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
     * Getter for f_HTMLPanel6 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel6() {
      return build_f_HTMLPanel6();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel6() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel6 = new com.google.gwt.user.client.ui.HTMLPanel(template_html26().asString());
      // Setup section.
      f_HTMLPanel6.setStyleName("" + get_res().css().assignDiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2132 = UiBinderUtil.attachToDom(f_HTMLPanel6.getElement());
      get_domId19Element().get();
      get_domId20Element().get();
      get_domId21Element().get();
      get_domId34Element().get();
      get_domId43Element().get();

      // Detach section.
      attachRecord2132.detach();
      f_HTMLPanel6.addAndReplaceElement(get_emailShareBtn(), get_domId19Element().get());
      f_HTMLPanel6.addAndReplaceElement(get_assignSubHeader(), get_domId20Element().get());
      f_HTMLPanel6.addAndReplaceElement(get_privateAssignContainer(), get_domId21Element().get());
      f_HTMLPanel6.addAndReplaceElement(get_publicAssignContainer(), get_domId34Element().get());
      f_HTMLPanel6.addAndReplaceElement(get_panelLoading(), get_domId43Element().get());

      return f_HTMLPanel6;
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
     * Getter for emailShareBtn called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Button get_emailShareBtn() {
      return build_emailShareBtn();
    }
    private com.google.gwt.user.client.ui.Button build_emailShareBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button emailShareBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      emailShareBtn.setStyleName("" + get_res().css().emailButton() + " " + get_res().css().emailStyle() + "");


      owner.emailShareBtn = emailShareBtn;

      return emailShareBtn;
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
     * Getter for assignSubHeader called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_assignSubHeader() {
      return build_assignSubHeader();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_assignSubHeader() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel assignSubHeader = new com.google.gwt.user.client.ui.HTMLPanel(template_html10().asString());
      // Setup section.
      assignSubHeader.setStyleName("" + get_res().css().assignTitle() + "");


      owner.assignSubHeader = assignSubHeader;

      return assignSubHeader;
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
     * Getter for privateAssignContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_privateAssignContainer() {
      return build_privateAssignContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_privateAssignContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel privateAssignContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html19().asString());
      // Setup section.
      privateAssignContainer.setStyleName("" + get_res().css().subBody() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2133 = UiBinderUtil.attachToDom(privateAssignContainer.getElement());
      get_domId22Element().get();
      get_domId23Element().get();
      get_domId24Element().get();
      get_domId33Element().get();

      // Detach section.
      attachRecord2133.detach();
      privateAssignContainer.addAndReplaceElement(get_titleTxt(), get_domId22Element().get());
      privateAssignContainer.addAndReplaceElement(get_emailTxt(), get_domId23Element().get());
      privateAssignContainer.addAndReplaceElement(get_f_HTMLPanel7(), get_domId24Element().get());
      privateAssignContainer.addAndReplaceElement(get_lblErrorMessage(), get_domId33Element().get());

      owner.privateAssignContainer = privateAssignContainer;

      return privateAssignContainer;
    }

    /**
     * Getter for domId22 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for titleTxt called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_titleTxt() {
      return build_titleTxt();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_titleTxt() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel titleTxt = new com.google.gwt.user.client.ui.HTMLPanel(template_html11().asString());
      // Setup section.
      titleTxt.setStyleName("" + get_res().css().subTitle() + "");


      owner.titleTxt = titleTxt;

      return titleTxt;
    }

    /**
     * Getter for domId22Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId23 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for emailTxt called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_emailTxt() {
      return build_emailTxt();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_emailTxt() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel emailTxt = new com.google.gwt.user.client.ui.HTMLPanel(template_html12().asString());
      // Setup section.
      emailTxt.setStyleName("" + get_res().css().titleBold() + "");


      owner.emailTxt = emailTxt;

      return emailTxt;
    }

    /**
     * Getter for domId23Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId24 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel7 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel7() {
      return build_f_HTMLPanel7();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel7() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel7 = new com.google.gwt.user.client.ui.HTMLPanel(template_html18().asString());
      // Setup section.
      f_HTMLPanel7.setStyleName("" + get_res().css().buttonContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2134 = UiBinderUtil.attachToDom(f_HTMLPanel7.getElement());
      get_domId25Element().get();
      get_domId26Element().get();

      // Detach section.
      attachRecord2134.detach();
      f_HTMLPanel7.addAndReplaceElement(get_panelSuggestBox(), get_domId25Element().get());
      f_HTMLPanel7.addAndReplaceElement(get_panelActions(), get_domId26Element().get());

      return f_HTMLPanel7;
    }

    /**
     * Getter for domId25 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for panelSuggestBox called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelSuggestBox() {
      return build_panelSuggestBox();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelSuggestBox() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelSuggestBox = new com.google.gwt.user.client.ui.HTMLPanel(template_html13().asString());
      // Setup section.


      owner.panelSuggestBox = panelSuggestBox;

      return panelSuggestBox;
    }

    /**
     * Getter for domId25Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId26 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for panelActions called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelActions() {
      return build_panelActions();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelActions() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelActions = new com.google.gwt.user.client.ui.HTMLPanel(template_html17().asString());
      // Setup section.
      panelActions.setStyleName("");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2135 = UiBinderUtil.attachToDom(panelActions.getElement());
      get_domId27Element().get();
      get_domId28Element().get();
      get_domId32Element().get();

      // Detach section.
      attachRecord2135.detach();
      panelActions.addAndReplaceElement(get_btnInvite(), get_domId27Element().get());
      panelActions.addAndReplaceElement(get_panelCode(), get_domId28Element().get());
      panelActions.addAndReplaceElement(get_lblPleaseWait(), get_domId32Element().get());

      owner.panelActions = panelActions;

      return panelActions;
    }

    /**
     * Getter for domId27 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for btnInvite called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Button get_btnInvite() {
      return build_btnInvite();
    }
    private com.google.gwt.user.client.ui.Button build_btnInvite() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button btnInvite = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      btnInvite.setStyleName("primary");
      btnInvite.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6);


      owner.btnInvite = btnInvite;

      return btnInvite;
    }

    /**
     * Getter for domId27Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for panelCode called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelCode() {
      return build_panelCode();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelCode() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelCode = new com.google.gwt.user.client.ui.HTMLPanel(template_html16().asString());
      // Setup section.
      panelCode.setStyleName("" + get_res().css().tooltipContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2136 = UiBinderUtil.attachToDom(panelCode.getElement());
      get_domId29Element().get();
      get_domId30Element().get();
      get_domId31Element().get();

      // Detach section.
      attachRecord2136.detach();
      panelCode.addAndReplaceElement(get_f_HTMLPanel8(), get_domId29Element().get());
      panelCode.addAndReplaceElement(get_f_HTMLPanel9(), get_domId30Element().get());
      panelCode.addAndReplaceElement(get_lblText(), get_domId31Element().get());

      return panelCode;
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
     * Getter for f_HTMLPanel8 called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel8() {
      return build_f_HTMLPanel8();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel8() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel8 = new com.google.gwt.user.client.ui.HTMLPanel(template_html14().asString());
      // Setup section.
      f_HTMLPanel8.setStyleName("" + get_res().css().arrowBorder() + "");


      return f_HTMLPanel8;
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
     * Getter for domId30 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for f_HTMLPanel9 called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel9() {
      return build_f_HTMLPanel9();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel9() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel9 = new com.google.gwt.user.client.ui.HTMLPanel(template_html15().asString());
      // Setup section.
      f_HTMLPanel9.setStyleName("" + get_res().css().arrow() + "");


      return f_HTMLPanel9;
    }

    /**
     * Getter for domId30Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for lblText called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Label get_lblText() {
      return build_lblText();
    }
    private com.google.gwt.user.client.ui.Label build_lblText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblText.setStyleName("" + get_res().css().tooltipContent() + "");


      owner.lblText = lblText;

      return lblText;
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
     * Getter for lblPleaseWait called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_lblPleaseWait() {
      return build_lblPleaseWait();
    }
    private com.google.gwt.user.client.ui.Label build_lblPleaseWait() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblPleaseWait = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblPleaseWait.setStyleName("" + get_res().css().pleaseWait() + "");


      owner.lblPleaseWait = lblPleaseWait;

      return lblPleaseWait;
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
     * Getter for domId26Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId24Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId33 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for lblErrorMessage called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_lblErrorMessage() {
      return build_lblErrorMessage();
    }
    private com.google.gwt.user.client.ui.Label build_lblErrorMessage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblErrorMessage = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblErrorMessage.setStyleName("errorMessage " + get_res().css().error() + "");


      owner.lblErrorMessage = lblErrorMessage;

      return lblErrorMessage;
    }

    /**
     * Getter for domId33Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId34 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for publicAssignContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_publicAssignContainer() {
      return build_publicAssignContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_publicAssignContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel publicAssignContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html24().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2137 = UiBinderUtil.attachToDom(publicAssignContainer.getElement());
      get_domId35Element().get();
      get_domId39Element().get();

      // Detach section.
      attachRecord2137.detach();
      publicAssignContainer.addAndReplaceElement(get_f_HTMLPanel10(), get_domId35Element().get());
      publicAssignContainer.addAndReplaceElement(get_f_HTMLPanel11(), get_domId39Element().get());

      owner.publicAssignContainer = publicAssignContainer;

      return publicAssignContainer;
    }

    /**
     * Getter for domId35 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel10 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel10() {
      return build_f_HTMLPanel10();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel10() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel10 = new com.google.gwt.user.client.ui.HTMLPanel(template_html21().asString());
      // Setup section.
      f_HTMLPanel10.setStyleName("" + get_res().css().assignSec() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2138 = UiBinderUtil.attachToDom(f_HTMLPanel10.getElement());
      get_domId36Element().get();
      get_domId37Element().get();
      get_domId38Element().get();

      // Detach section.
      attachRecord2138.detach();
      f_HTMLPanel10.addAndReplaceElement(get_shareTxt(), get_domId36Element().get());
      f_HTMLPanel10.addAndReplaceElement(get_shareTxtDesc(), get_domId37Element().get());
      f_HTMLPanel10.addAndReplaceElement(get_txtClasspageCodeShare(), get_domId38Element().get());

      return f_HTMLPanel10;
    }

    /**
     * Getter for domId36 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for shareTxt called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_shareTxt() {
      return build_shareTxt();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_shareTxt() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel shareTxt = new com.google.gwt.user.client.ui.HTMLPanel(template_html20().asString());
      // Setup section.
      shareTxt.setStyleName("" + get_res().css().assignSecTitle() + "");


      owner.shareTxt = shareTxt;

      return shareTxt;
    }

    /**
     * Getter for domId36Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId37 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for shareTxtDesc called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.InlineHTML get_shareTxtDesc() {
      return build_shareTxtDesc();
    }
    private com.google.gwt.user.client.ui.InlineHTML build_shareTxtDesc() {
      // Creation section.
      final com.google.gwt.user.client.ui.InlineHTML shareTxtDesc = (com.google.gwt.user.client.ui.InlineHTML) GWT.create(com.google.gwt.user.client.ui.InlineHTML.class);
      // Setup section.


      owner.shareTxtDesc = shareTxtDesc;

      return shareTxtDesc;
    }

    /**
     * Getter for domId37Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for txtClasspageCodeShare called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.TextBox get_txtClasspageCodeShare() {
      return build_txtClasspageCodeShare();
    }
    private com.google.gwt.user.client.ui.TextBox build_txtClasspageCodeShare() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox txtClasspageCodeShare = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.
      txtClasspageCodeShare.setStyleName("" + get_res().css().input1() + " " + get_res().css().shareTextboxLink() + "");


      owner.txtClasspageCodeShare = txtClasspageCodeShare;

      return txtClasspageCodeShare;
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
     * Getter for domId35Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId39 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel11 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel11() {
      return build_f_HTMLPanel11();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel11() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel11 = new com.google.gwt.user.client.ui.HTMLPanel(template_html23().asString());
      // Setup section.
      f_HTMLPanel11.setStyleName("" + get_res().css().assignSec() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2139 = UiBinderUtil.attachToDom(f_HTMLPanel11.getElement());
      get_domId40Element().get();
      get_domId41Element().get();
      get_domId42Element().get();

      // Detach section.
      attachRecord2139.detach();
      f_HTMLPanel11.addAndReplaceElement(get_shareTitle(), get_domId40Element().get());
      f_HTMLPanel11.addAndReplaceElement(get_shareDesc(), get_domId41Element().get());
      f_HTMLPanel11.addAndReplaceElement(get_txtClasspageLinkShare(), get_domId42Element().get());

      return f_HTMLPanel11;
    }

    /**
     * Getter for domId40 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for shareTitle called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_shareTitle() {
      return build_shareTitle();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_shareTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel shareTitle = new com.google.gwt.user.client.ui.HTMLPanel(template_html22().asString());
      // Setup section.
      shareTitle.setStyleName("" + get_res().css().assignSecTitle() + "");


      owner.shareTitle = shareTitle;

      return shareTitle;
    }

    /**
     * Getter for domId40Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for shareDesc called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.InlineHTML get_shareDesc() {
      return build_shareDesc();
    }
    private com.google.gwt.user.client.ui.InlineHTML build_shareDesc() {
      // Creation section.
      final com.google.gwt.user.client.ui.InlineHTML shareDesc = (com.google.gwt.user.client.ui.InlineHTML) GWT.create(com.google.gwt.user.client.ui.InlineHTML.class);
      // Setup section.


      owner.shareDesc = shareDesc;

      return shareDesc;
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
     * Getter for txtClasspageLinkShare called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.TextBox get_txtClasspageLinkShare() {
      return build_txtClasspageLinkShare();
    }
    private com.google.gwt.user.client.ui.TextBox build_txtClasspageLinkShare() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox txtClasspageLinkShare = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.
      txtClasspageLinkShare.setStyleName("" + get_res().css().input1() + " " + get_res().css().inputWidth() + " " + get_res().css().shareTextboxLink() + "");


      owner.txtClasspageLinkShare = txtClasspageLinkShare;

      return txtClasspageLinkShare;
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
     * Getter for domId39Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId34Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId43 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for panelLoading called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelLoading() {
      return build_panelLoading();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelLoading() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelLoading = new com.google.gwt.user.client.ui.HTMLPanel(template_html25().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2140 = UiBinderUtil.attachToDom(panelLoading.getElement());
      get_domId44Element().get();

      // Detach section.
      attachRecord2140.detach();
      panelLoading.addAndReplaceElement(get_f_Label12(), get_domId44Element().get());

      owner.panelLoading = panelLoading;

      return panelLoading;
    }

    /**
     * Getter for domId44 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_Label12 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label12() {
      return build_f_Label12();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label12() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label12 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label12.setStyleName("loadingpanelImage");


      return f_Label12;
    }

    /**
     * Getter for domId44Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId43Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId45 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for panelNoMembers called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelNoMembers() {
      return build_panelNoMembers();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelNoMembers() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelNoMembers = new com.google.gwt.user.client.ui.HTMLPanel(template_html31().asString());
      // Setup section.
      panelNoMembers.setStyleName("" + get_res().css().teachContentView() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2141 = UiBinderUtil.attachToDom(panelNoMembers.getElement());
      get_domId46Element().get();
      get_domId47Element().get();

      // Detach section.
      attachRecord2141.detach();
      panelNoMembers.addAndReplaceElement(get_joinTxt(), get_domId46Element().get());
      panelNoMembers.addAndReplaceElement(get_f_HTMLPanel13(), get_domId47Element().get());

      owner.panelNoMembers = panelNoMembers;

      return panelNoMembers;
    }

    /**
     * Getter for domId46 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for joinTxt called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_joinTxt() {
      return build_joinTxt();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_joinTxt() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel joinTxt = new com.google.gwt.user.client.ui.HTMLPanel(template_html27().asString());
      // Setup section.
      joinTxt.setStyleName("" + get_res().css().title() + "");


      owner.joinTxt = joinTxt;

      return joinTxt;
    }

    /**
     * Getter for domId46Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId47 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for f_HTMLPanel13 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel13() {
      return build_f_HTMLPanel13();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel13() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel13 = new com.google.gwt.user.client.ui.HTMLPanel(template_html30().asString());
      // Setup section.
      f_HTMLPanel13.setStyleName("" + get_res().css().twoActions() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2142 = UiBinderUtil.attachToDom(f_HTMLPanel13.getElement());
      get_domId48Element().get();
      get_domId49Element().get();

      // Detach section.
      attachRecord2142.detach();
      f_HTMLPanel13.addAndReplaceElement(get_manageTxt(), get_domId48Element().get());
      f_HTMLPanel13.addAndReplaceElement(get_trackTxt(), get_domId49Element().get());

      return f_HTMLPanel13;
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
     * Getter for manageTxt called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_manageTxt() {
      return build_manageTxt();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_manageTxt() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel manageTxt = new com.google.gwt.user.client.ui.HTMLPanel(template_html28().asString());
      // Setup section.
      manageTxt.setStyleName("" + get_res().css().manage() + "");


      owner.manageTxt = manageTxt;

      return manageTxt;
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
     * Getter for domId49 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for trackTxt called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_trackTxt() {
      return build_trackTxt();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_trackTxt() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel trackTxt = new com.google.gwt.user.client.ui.HTMLPanel(template_html29().asString());
      // Setup section.
      trackTxt.setStyleName("" + get_res().css().progress() + "");


      owner.trackTxt = trackTxt;

      return trackTxt;
    }

    /**
     * Getter for domId49Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId47Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId45Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId50 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for panelMembersList called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelMembersList() {
      return build_panelMembersList();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelMembersList() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelMembersList = new com.google.gwt.user.client.ui.HTMLPanel(template_html34().asString());
      // Setup section.
      panelMembersList.setStyleName("" + get_res().css().membersList() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2143 = UiBinderUtil.attachToDom(panelMembersList.getElement());
      get_domId51Element().get();
      get_domId56Element().get();

      // Detach section.
      attachRecord2143.detach();
      panelMembersList.addAndReplaceElement(get_panelPendingMembersContainer(), get_domId51Element().get());
      panelMembersList.addAndReplaceElement(get_panelActiveMembersContainter(), get_domId56Element().get());

      owner.panelMembersList = panelMembersList;

      return panelMembersList;
    }

    /**
     * Getter for domId51 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for panelPendingMembersContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelPendingMembersContainer() {
      return build_panelPendingMembersContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelPendingMembersContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelPendingMembersContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html32().asString());
      // Setup section.
      panelPendingMembersContainer.setStyleName("" + get_res().css().pendingContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2144 = UiBinderUtil.attachToDom(panelPendingMembersContainer.getElement());
      get_domId52Element().get();
      get_domId53Element().get();
      get_domId54Element().get();
      get_domId55Element().get();

      // Detach section.
      attachRecord2144.detach();
      panelPendingMembersContainer.addAndReplaceElement(get_lblPendingMembers(), get_domId52Element().get());
      panelPendingMembersContainer.addAndReplaceElement(get_panelPendingMembersList(), get_domId53Element().get());
      panelPendingMembersContainer.addAndReplaceElement(get_ancPendingListSeeMore(), get_domId54Element().get());
      panelPendingMembersContainer.addAndReplaceElement(get_lblPendingPleaseWait(), get_domId55Element().get());

      owner.panelPendingMembersContainer = panelPendingMembersContainer;

      return panelPendingMembersContainer;
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
     * Getter for lblPendingMembers called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_lblPendingMembers() {
      return build_lblPendingMembers();
    }
    private com.google.gwt.user.client.ui.Label build_lblPendingMembers() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblPendingMembers = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblPendingMembers.setStyleName("" + get_res().css().pendingMembers() + "");


      owner.lblPendingMembers = lblPendingMembers;

      return lblPendingMembers;
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
     * Getter for domId53 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for panelPendingMembersList called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.VerticalPanel get_panelPendingMembersList() {
      return build_panelPendingMembersList();
    }
    private com.google.gwt.user.client.ui.VerticalPanel build_panelPendingMembersList() {
      // Creation section.
      final com.google.gwt.user.client.ui.VerticalPanel panelPendingMembersList = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
      // Setup section.
      panelPendingMembersList.setStyleName("");


      owner.panelPendingMembersList = panelPendingMembersList;

      return panelPendingMembersList;
    }

    /**
     * Getter for domId53Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId54 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for ancPendingListSeeMore called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Anchor get_ancPendingListSeeMore() {
      return build_ancPendingListSeeMore();
    }
    private com.google.gwt.user.client.ui.Anchor build_ancPendingListSeeMore() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor ancPendingListSeeMore = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      ancPendingListSeeMore.setStyleName("" + get_res().css().seeMorePending() + "");
      ancPendingListSeeMore.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.ancPendingListSeeMore = ancPendingListSeeMore;

      return ancPendingListSeeMore;
    }

    /**
     * Getter for domId54Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for lblPendingPleaseWait called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_lblPendingPleaseWait() {
      return build_lblPendingPleaseWait();
    }
    private com.google.gwt.user.client.ui.Label build_lblPendingPleaseWait() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblPendingPleaseWait = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblPendingPleaseWait.setStyleName("systemMessage " + get_res().css().pleaseWait() + "");


      owner.lblPendingPleaseWait = lblPendingPleaseWait;

      return lblPendingPleaseWait;
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
     * Getter for domId51Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId56 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId56;
    private java.lang.String get_domId56() {
      return domId56;
    }
    private java.lang.String build_domId56() {
      // Creation section.
      domId56 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId56;
    }

    /**
     * Getter for panelActiveMembersContainter called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelActiveMembersContainter() {
      return build_panelActiveMembersContainter();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelActiveMembersContainter() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelActiveMembersContainter = new com.google.gwt.user.client.ui.HTMLPanel(template_html33().asString());
      // Setup section.
      panelActiveMembersContainter.setStyleName("" + get_res().css().activeContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2145 = UiBinderUtil.attachToDom(panelActiveMembersContainter.getElement());
      get_domId57Element().get();
      get_domId58Element().get();
      get_domId59Element().get();
      get_domId60Element().get();
      get_domId61Element().get();

      // Detach section.
      attachRecord2145.detach();
      panelActiveMembersContainter.addAndReplaceElement(get_lblActiveMembers(), get_domId57Element().get());
      panelActiveMembersContainter.addAndReplaceElement(get_lblActiveMembersDesc(), get_domId58Element().get());
      panelActiveMembersContainter.addAndReplaceElement(get_panelActiveMembersList(), get_domId59Element().get());
      panelActiveMembersContainter.addAndReplaceElement(get_ancActiveListSeeMore(), get_domId60Element().get());
      panelActiveMembersContainter.addAndReplaceElement(get_lblActivePleaseWait(), get_domId61Element().get());

      owner.panelActiveMembersContainter = panelActiveMembersContainter;

      return panelActiveMembersContainter;
    }

    /**
     * Getter for domId57 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId57;
    private java.lang.String get_domId57() {
      return domId57;
    }
    private java.lang.String build_domId57() {
      // Creation section.
      domId57 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId57;
    }

    /**
     * Getter for lblActiveMembers called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_lblActiveMembers() {
      return build_lblActiveMembers();
    }
    private com.google.gwt.user.client.ui.Label build_lblActiveMembers() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblActiveMembers = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblActiveMembers.setStyleName("" + get_res().css().activeMembers() + "");


      owner.lblActiveMembers = lblActiveMembers;

      return lblActiveMembers;
    }

    /**
     * Getter for domId57Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId57Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId57Element() {
      return domId57Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId57Element() {
      // Creation section.
      domId57Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId57());
      // Setup section.


      return domId57Element;
    }

    /**
     * Getter for domId58 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId58;
    private java.lang.String get_domId58() {
      return domId58;
    }
    private java.lang.String build_domId58() {
      // Creation section.
      domId58 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId58;
    }

    /**
     * Getter for lblActiveMembersDesc called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_lblActiveMembersDesc() {
      return build_lblActiveMembersDesc();
    }
    private com.google.gwt.user.client.ui.Label build_lblActiveMembersDesc() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblActiveMembersDesc = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblActiveMembersDesc.setStyleName("" + get_res().css().activeMembersDesc() + "");


      owner.lblActiveMembersDesc = lblActiveMembersDesc;

      return lblActiveMembersDesc;
    }

    /**
     * Getter for domId58Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId58Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId58Element() {
      return domId58Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId58Element() {
      // Creation section.
      domId58Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId58());
      // Setup section.


      return domId58Element;
    }

    /**
     * Getter for domId59 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId59;
    private java.lang.String get_domId59() {
      return domId59;
    }
    private java.lang.String build_domId59() {
      // Creation section.
      domId59 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId59;
    }

    /**
     * Getter for panelActiveMembersList called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.VerticalPanel get_panelActiveMembersList() {
      return build_panelActiveMembersList();
    }
    private com.google.gwt.user.client.ui.VerticalPanel build_panelActiveMembersList() {
      // Creation section.
      final com.google.gwt.user.client.ui.VerticalPanel panelActiveMembersList = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
      // Setup section.
      panelActiveMembersList.setStyleName("");


      owner.panelActiveMembersList = panelActiveMembersList;

      return panelActiveMembersList;
    }

    /**
     * Getter for domId59Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId59Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId59Element() {
      return domId59Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId59Element() {
      // Creation section.
      domId59Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId59());
      // Setup section.


      return domId59Element;
    }

    /**
     * Getter for domId60 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId60;
    private java.lang.String get_domId60() {
      return domId60;
    }
    private java.lang.String build_domId60() {
      // Creation section.
      domId60 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId60;
    }

    /**
     * Getter for ancActiveListSeeMore called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Anchor get_ancActiveListSeeMore() {
      return build_ancActiveListSeeMore();
    }
    private com.google.gwt.user.client.ui.Anchor build_ancActiveListSeeMore() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor ancActiveListSeeMore = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      ancActiveListSeeMore.setStyleName("" + get_res().css().seeMoreActive() + "");
      ancActiveListSeeMore.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.ancActiveListSeeMore = ancActiveListSeeMore;

      return ancActiveListSeeMore;
    }

    /**
     * Getter for domId60Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId60Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId60Element() {
      return domId60Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId60Element() {
      // Creation section.
      domId60Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId60());
      // Setup section.


      return domId60Element;
    }

    /**
     * Getter for domId61 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId61;
    private java.lang.String get_domId61() {
      return domId61;
    }
    private java.lang.String build_domId61() {
      // Creation section.
      domId61 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId61;
    }

    /**
     * Getter for lblActivePleaseWait called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_lblActivePleaseWait() {
      return build_lblActivePleaseWait();
    }
    private com.google.gwt.user.client.ui.Label build_lblActivePleaseWait() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblActivePleaseWait = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblActivePleaseWait.setStyleName("systemMessage " + get_res().css().pleaseWait() + "");


      owner.lblActivePleaseWait = lblActivePleaseWait;

      return lblActivePleaseWait;
    }

    /**
     * Getter for domId61Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId61Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId61Element() {
      return domId61Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId61Element() {
      // Creation section.
      domId61Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId61());
      // Setup section.


      return domId61Element;
    }

    /**
     * Getter for domId56Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId56Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId56Element() {
      return domId56Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId56Element() {
      // Creation section.
      domId56Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId56());
      // Setup section.


      return domId56Element;
    }

    /**
     * Getter for domId50Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
  }
}
