package org.ednovo.gooru.client.mvp.play.collection.info;

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

public class ResourceInfoView_ResourceInfoViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoView>, org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoView.ResourceInfoViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span> <span id='{5}'></span> <span id='{6}'></span>")
    SafeHtml html2(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html3(String arg0);
     
    @Template("")
    SafeHtml html4();
     
    @Template("")
    SafeHtml html5();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html6(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html7(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html8(String arg0, String arg1);
     
    @Template("")
    SafeHtml html9();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html10(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html11(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html12(String arg0);
     
    @Template("")
    SafeHtml html13();
     
    @Template("")
    SafeHtml html14();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html15(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html16(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html17(String arg0, String arg1);
     
    @Template("")
    SafeHtml html18();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html19(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html20(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html21(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html22(String arg0, String arg1);
     
    @Template("")
    SafeHtml html23();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html24(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html25(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html26(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html27(String arg0, String arg1);
     
    @Template("")
    SafeHtml html28();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html29(String arg0, String arg1);
     
    @Template("")
    SafeHtml html30();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html31(String arg0, String arg1);
     
    @Template("")
    SafeHtml html32();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html33(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html34(String arg0, String arg1);
     
    @Template("")
    SafeHtml html35();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html36(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html37(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html38(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html39(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html40(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html41(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html42(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html43(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html44(String arg0, String arg1);
     
    @Template("")
    SafeHtml html45();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html46(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html47(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html48(String arg0, String arg1);
     
    @Template("")
    SafeHtml html49();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html50(String arg0, String arg1);
     
    @Template("")
    SafeHtml html51();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html52(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html53(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html54(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html55(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html56(String arg0, String arg1);
     
    @Template("")
    SafeHtml html57();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html58(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span> <span id='{5}'></span> <span id='{6}'></span> <span id='{7}'></span> <span id='{8}'></span> <span id='{9}'></span> <span id='{10}'></span> <span id='{11}'></span> <span id='{12}'></span> <span id='{13}'></span> <span id='{14}'></span> <span id='{15}'></span> <span id='{16}'></span> <span id='{17}'></span> <span id='{18}'></span> <span id='{19}'></span> <span id='{20}'></span> <span id='{21}'></span>  <span id='{22}'></span> <span id='{23}'></span> <span id='{24}'></span> <span id='{25}'></span> <span id='{26}'></span> <span id='{27}'></span> <span id='{28}'></span> <span id='{29}'></span> <span id='{30}'></span> <span id='{31}'></span> <span id='{32}'></span> <span id='{33}'></span> <span id='{34}'></span> <span id='{35}'></span> <span id='{36}'></span> <span id='{37}'></span> <span id='{38}'></span> <span id='{39}'></span> <span id='{40}'></span> <span id='{41}'></span> <span id='{42}'></span> <span id='{43}'></span> <span id='{44}'></span> <span id='{45}'></span>")
    SafeHtml html59(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15, String arg16, String arg17, String arg18, String arg19, String arg20, String arg21, String arg22, String arg23, String arg24, String arg25, String arg26, String arg27, String arg28, String arg29, String arg30, String arg31, String arg32, String arg33, String arg34, String arg35, String arg36, String arg37, String arg38, String arg39, String arg40, String arg41, String arg42, String arg43, String arg44, String arg45);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html60(String arg0);
     
    @Template("")
    SafeHtml html61();
     
    @Template("")
    SafeHtml html62();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html63(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html64(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html65(String arg0, String arg1, String arg2);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoView owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoView owner;


    final com.google.gwt.event.dom.client.ScrollHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ScrollHandler() {
      public void onScroll(com.google.gwt.event.dom.client.ScrollEvent event) {
        owner.onScrollReosourceReleatedCollections(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onhideBtnClicked(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoView owner) {
      this.owner = owner;
      build_playerStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId43();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId44();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId14();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId16();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId17();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId19();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId21();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId22();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId24();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId25();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId27();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId28();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId31();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId34();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId35();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId37();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId38();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId40();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId41();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId46();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId47();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId49();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId51();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId52();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId54();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId55();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId57();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId58();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId60();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId61();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId63();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId64();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId66();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId67();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId69();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId70();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId72();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId73();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId75();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId76();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId78();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId79();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId81();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId83();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId84();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId86();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId87();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId89();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId90();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId92();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId93();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId95();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId96();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId98();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId99();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId101();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId102();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId104();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId105();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId107();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId109();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId110();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId112();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId113();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId115();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId116();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId118();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId119();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId121();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId122();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId124();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId125();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId127();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId128();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId130();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId131();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId15();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId18();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId20();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId23();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId26();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId29();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId30();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId32();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId33();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId36();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId39();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId42();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId45();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId48();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId50();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId53();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId56();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId59();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId62();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId65();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId68();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId71();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId74();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId77();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId80();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId82();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId85();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId88();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId91();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId94();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId97();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId100();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId103();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId106();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId108();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId111();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId114();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId117();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId120();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId123();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId126();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId129();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId132();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId133();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId134();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId136();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId137();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId135();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId43Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId44Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId14Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId16Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId17Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId19Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId21Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId22Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId24Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId25Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId27Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId28Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId31Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId34Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId35Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId37Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId38Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId40Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId41Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId46Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId47Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId49Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId51Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId52Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId54Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId55Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId57Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId58Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId60Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId61Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId63Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId64Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId66Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId67Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId69Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId70Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId72Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId73Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId75Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId76Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId78Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId79Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId81Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId83Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId84Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId86Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId87Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId89Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId90Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId92Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId93Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId95Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId96Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId98Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId99Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId101Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId102Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId104Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId105Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId107Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId109Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId110Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId112Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId113Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId115Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId116Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId118Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId119Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId121Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId122Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId124Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId125Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId127Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId128Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId130Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId131Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId15Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId18Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId20Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId23Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId26Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId29Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId30Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId32Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId33Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId36Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId39Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId42Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId45Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId48Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId50Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId53Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId56Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId59Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId62Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId65Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId68Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId71Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId74Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId77Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId80Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId82Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId85Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId88Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId91Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId94Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId97Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId100Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId103Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId106Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId108Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId111Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId114Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId117Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId120Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId123Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId126Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId129Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId132Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId133Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId134Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId136Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId137Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId135Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2(get_domId6(), get_domId7(), get_domId8(), get_domId9(), get_domId10(), get_domId11(), get_domId12());
    }
    SafeHtml template_html3() {
      return template.html3(get_domId14());
    }
    SafeHtml template_html4() {
      return template.html4();
    }
    SafeHtml template_html5() {
      return template.html5();
    }
    SafeHtml template_html6() {
      return template.html6(get_domId16(), get_domId17());
    }
    SafeHtml template_html7() {
      return template.html7(get_domId19());
    }
    SafeHtml template_html8() {
      return template.html8(get_domId21(), get_domId22());
    }
    SafeHtml template_html9() {
      return template.html9();
    }
    SafeHtml template_html10() {
      return template.html10(get_domId24(), get_domId25());
    }
    SafeHtml template_html11() {
      return template.html11(get_domId27(), get_domId28());
    }
    SafeHtml template_html12() {
      return template.html12(get_domId31());
    }
    SafeHtml template_html13() {
      return template.html13();
    }
    SafeHtml template_html14() {
      return template.html14();
    }
    SafeHtml template_html15() {
      return template.html15(get_domId34(), get_domId35());
    }
    SafeHtml template_html16() {
      return template.html16(get_domId37(), get_domId38());
    }
    SafeHtml template_html17() {
      return template.html17(get_domId40(), get_domId41());
    }
    SafeHtml template_html18() {
      return template.html18();
    }
    SafeHtml template_html19() {
      return template.html19(get_domId43(), get_domId44());
    }
    SafeHtml template_html20() {
      return template.html20(get_domId46(), get_domId47());
    }
    SafeHtml template_html21() {
      return template.html21(get_domId49());
    }
    SafeHtml template_html22() {
      return template.html22(get_domId51(), get_domId52());
    }
    SafeHtml template_html23() {
      return template.html23();
    }
    SafeHtml template_html24() {
      return template.html24(get_domId54(), get_domId55());
    }
    SafeHtml template_html25() {
      return template.html25(get_domId57(), get_domId58());
    }
    SafeHtml template_html26() {
      return template.html26(get_domId60(), get_domId61());
    }
    SafeHtml template_html27() {
      return template.html27(get_domId63(), get_domId64());
    }
    SafeHtml template_html28() {
      return template.html28();
    }
    SafeHtml template_html29() {
      return template.html29(get_domId66(), get_domId67());
    }
    SafeHtml template_html30() {
      return template.html30();
    }
    SafeHtml template_html31() {
      return template.html31(get_domId69(), get_domId70());
    }
    SafeHtml template_html32() {
      return template.html32();
    }
    SafeHtml template_html33() {
      return template.html33(get_domId72(), get_domId73());
    }
    SafeHtml template_html34() {
      return template.html34(get_domId75(), get_domId76());
    }
    SafeHtml template_html35() {
      return template.html35();
    }
    SafeHtml template_html36() {
      return template.html36(get_domId78(), get_domId79());
    }
    SafeHtml template_html37() {
      return template.html37(get_domId81());
    }
    SafeHtml template_html38() {
      return template.html38(get_domId83(), get_domId84());
    }
    SafeHtml template_html39() {
      return template.html39(get_domId86(), get_domId87());
    }
    SafeHtml template_html40() {
      return template.html40(get_domId89(), get_domId90());
    }
    SafeHtml template_html41() {
      return template.html41(get_domId92(), get_domId93());
    }
    SafeHtml template_html42() {
      return template.html42(get_domId95(), get_domId96());
    }
    SafeHtml template_html43() {
      return template.html43(get_domId98(), get_domId99());
    }
    SafeHtml template_html44() {
      return template.html44(get_domId101(), get_domId102());
    }
    SafeHtml template_html45() {
      return template.html45();
    }
    SafeHtml template_html46() {
      return template.html46(get_domId104(), get_domId105());
    }
    SafeHtml template_html47() {
      return template.html47(get_domId107());
    }
    SafeHtml template_html48() {
      return template.html48(get_domId109(), get_domId110());
    }
    SafeHtml template_html49() {
      return template.html49();
    }
    SafeHtml template_html50() {
      return template.html50(get_domId112(), get_domId113());
    }
    SafeHtml template_html51() {
      return template.html51();
    }
    SafeHtml template_html52() {
      return template.html52(get_domId115(), get_domId116());
    }
    SafeHtml template_html53() {
      return template.html53(get_domId118(), get_domId119());
    }
    SafeHtml template_html54() {
      return template.html54(get_domId121(), get_domId122());
    }
    SafeHtml template_html55() {
      return template.html55(get_domId124(), get_domId125());
    }
    SafeHtml template_html56() {
      return template.html56(get_domId127(), get_domId128());
    }
    SafeHtml template_html57() {
      return template.html57();
    }
    SafeHtml template_html58() {
      return template.html58(get_domId130(), get_domId131());
    }
    SafeHtml template_html59() {
      return template.html59(get_domId3(), get_domId4(), get_domId5(), get_domId13(), get_domId15(), get_domId18(), get_domId20(), get_domId23(), get_domId26(), get_domId29(), get_domId30(), get_domId32(), get_domId33(), get_domId36(), get_domId39(), get_domId42(), get_domId45(), get_domId48(), get_domId50(), get_domId53(), get_domId56(), get_domId59(), get_domId62(), get_domId65(), get_domId68(), get_domId71(), get_domId74(), get_domId77(), get_domId80(), get_domId82(), get_domId85(), get_domId88(), get_domId91(), get_domId94(), get_domId97(), get_domId100(), get_domId103(), get_domId106(), get_domId108(), get_domId111(), get_domId114(), get_domId117(), get_domId120(), get_domId123(), get_domId126(), get_domId129());
    }
    SafeHtml template_html60() {
      return template.html60(get_domId2());
    }
    SafeHtml template_html61() {
      return template.html61();
    }
    SafeHtml template_html62() {
      return template.html62();
    }
    SafeHtml template_html63() {
      return template.html63(get_domId132(), get_domId133(), get_domId134());
    }
    SafeHtml template_html64() {
      return template.html64(get_domId136(), get_domId137());
    }
    SafeHtml template_html65() {
      return template.html65(get_domId0(), get_domId1(), get_domId135());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoView_ResourceInfoViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoView_ResourceInfoViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoView_ResourceInfoViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoView_ResourceInfoViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoView_ResourceInfoViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for playerStyle called 139 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoView_ResourceInfoViewUiBinderImpl_GenCss_playerStyle playerStyle;
    private org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoView_ResourceInfoViewUiBinderImpl_GenCss_playerStyle get_playerStyle() {
      return playerStyle;
    }
    private org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoView_ResourceInfoViewUiBinderImpl_GenCss_playerStyle build_playerStyle() {
      // Creation section.
      playerStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().playerStyle();
      // Setup section.
      playerStyle.ensureInjected();


      return playerStyle;
    }

    /**
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html65().asString());
      // Setup section.
      f_HTMLPanel1.setStyleName("" + get_playerStyle().resourceInfoBackgroundContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1522 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId0Element().get();
      get_domId1Element().get();
      get_domId135Element().get();

      // Detach section.
      attachRecord1522.detach();
      f_HTMLPanel1.addAndReplaceElement(get_resourceInfoText(), get_domId0Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_resourceInfoContainerPanel(), get_domId1Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_hideButton(), get_domId135Element().get());

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
     * Getter for resourceInfoText called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_resourceInfoText() {
      return build_resourceInfoText();
    }
    private com.google.gwt.user.client.ui.Label build_resourceInfoText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label resourceInfoText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      resourceInfoText.setStyleName("" + get_playerStyle().resourceInfoName() + "");


      owner.resourceInfoText = resourceInfoText;

      return resourceInfoText;
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
     * Getter for resourceInfoContainerPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_resourceInfoContainerPanel() {
      return build_resourceInfoContainerPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_resourceInfoContainerPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel resourceInfoContainerPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      resourceInfoContainerPanel.add(get_f_FlowPanel2());
      resourceInfoContainerPanel.setStyleName("" + get_playerStyle().resourceInfoContainer() + "");


      return resourceInfoContainerPanel;
    }

    /**
     * Getter for f_FlowPanel2 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel2() {
      return build_f_FlowPanel2();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel2 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel2.add(get_f_HTMLPanel3());
      f_FlowPanel2.add(get_f_HTMLPanel13());
      f_FlowPanel2.setStyleName("" + get_playerStyle().resourceInfoWrapper() + "");


      return f_FlowPanel2;
    }

    /**
     * Getter for f_HTMLPanel3 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel3() {
      return build_f_HTMLPanel3();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template_html60().asString());
      // Setup section.
      f_HTMLPanel3.setStyleName("" + get_playerStyle().resourceInfoMetadataWrapper() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1523 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
      get_domId2Element().get();

      // Detach section.
      attachRecord1523.detach();
      f_HTMLPanel3.addAndReplaceElement(get_f_HTMLPanel4(), get_domId2Element().get());

      return f_HTMLPanel3;
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
     * Getter for f_HTMLPanel4 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel4() {
      return build_f_HTMLPanel4();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel4 = new com.google.gwt.user.client.ui.HTMLPanel(template_html59().asString());
      // Setup section.
      f_HTMLPanel4.setStyleName("" + get_playerStyle().resourceInfoMetadataInnerwrapper() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1524 = UiBinderUtil.attachToDom(f_HTMLPanel4.getElement());
      get_domId3Element().get();
      get_domId4Element().get();
      get_domId5Element().get();
      get_domId13Element().get();
      get_domId15Element().get();
      get_domId18Element().get();
      get_domId20Element().get();
      get_domId23Element().get();
      get_domId26Element().get();
      get_domId29Element().get();
      get_domId30Element().get();
      get_domId32Element().get();
      get_domId33Element().get();
      get_domId36Element().get();
      get_domId39Element().get();
      get_domId42Element().get();
      get_domId45Element().get();
      get_domId48Element().get();
      get_domId50Element().get();
      get_domId53Element().get();
      get_domId56Element().get();
      get_domId59Element().get();
      get_domId62Element().get();
      get_domId65Element().get();
      get_domId68Element().get();
      get_domId71Element().get();
      get_domId74Element().get();
      get_domId77Element().get();
      get_domId80Element().get();
      get_domId82Element().get();
      get_domId85Element().get();
      get_domId88Element().get();
      get_domId91Element().get();
      get_domId94Element().get();
      get_domId97Element().get();
      get_domId100Element().get();
      get_domId103Element().get();
      get_domId106Element().get();
      get_domId108Element().get();
      get_domId111Element().get();
      get_domId114Element().get();
      get_domId117Element().get();
      get_domId120Element().get();
      get_domId123Element().get();
      get_domId126Element().get();
      get_domId129Element().get();

      // Detach section.
      attachRecord1524.detach();
      f_HTMLPanel4.addAndReplaceElement(get_resourceTypeImage(), get_domId3Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_lblcollectionName(), get_domId4Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_f_HTMLPanel5(), get_domId5Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_f_HTMLPanel6(), get_domId13Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_f_HTMLPanel7(), get_domId15Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_f_HTMLPanel8(), get_domId18Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_gradesPanel(), get_domId20Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_coursePanel(), get_domId23Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_standardsContentContainer(), get_domId26Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_standardsInfoConatiner(), get_domId29Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_f_HTMLPanel9(), get_domId30Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_originalUrlText(), get_domId32Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_thumbnailPanel(), get_domId33Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_publisherPanel(), get_domId36Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_hostPanel(), get_domId39Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_licenceContainer(), get_domId42Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_licenceCodePanel(), get_domId45Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_f_HTMLPanel11(), get_domId48Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_eduAllignPanel(), get_domId50Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_eduUsePanel(), get_domId53Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_eduRolePanel(), get_domId56Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_interactivityTypePanel(), get_domId59Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_ageRangePanel(), get_domId62Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_dKnowledgePanel(), get_domId65Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_momentsoflearningPanel(), get_domId68Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_readingLevelPanel(), get_domId71Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_gooruSubjectPanel(), get_domId74Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_gooruCoursePanel(), get_domId77Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_f_HTMLPanel12(), get_domId80Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_dateCreatedPanel(), get_domId82Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_countryCodePanel(), get_domId85Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_languagePanel(), get_domId88Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_DataTypePanel(), get_domId91Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_authorPanel(), get_domId94Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_copyRightPanel(), get_domId97Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_contributorPanel(), get_domId100Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_keyWordsPanel(), get_domId103Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_accessibilityPanel(), get_domId106Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_mobileFriendlyPanel(), get_domId108Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_accessModePanel(), get_domId111Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_mediaFeaturePanel(), get_domId114Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_controlPanel(), get_domId117Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_accessHazardPanel(), get_domId120Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_hasAdaptationPanel(), get_domId123Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_isAdaptationPanel(), get_domId126Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_accessibilityAPIPanel(), get_domId129Element().get());

      return f_HTMLPanel4;
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
     * Getter for resourceTypeImage called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_resourceTypeImage() {
      return build_resourceTypeImage();
    }
    private com.google.gwt.user.client.ui.Label build_resourceTypeImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label resourceTypeImage = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      resourceTypeImage.setStyleName("" + get_playerStyle().resourceImage() + "");


      owner.resourceTypeImage = resourceTypeImage;

      return resourceTypeImage;
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
     * Getter for lblcollectionName called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTML get_lblcollectionName() {
      return build_lblcollectionName();
    }
    private com.google.gwt.user.client.ui.HTML build_lblcollectionName() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML lblcollectionName = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.


      owner.lblcollectionName = lblcollectionName;

      return lblcollectionName;
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
     * Getter for f_HTMLPanel5 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel5() {
      return build_f_HTMLPanel5();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel5 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      f_HTMLPanel5.setStyleName("" + get_playerStyle().resourceInfoTypeImage() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1525 = UiBinderUtil.attachToDom(f_HTMLPanel5.getElement());
      get_domId6Element().get();
      get_domId7Element().get();
      get_domId8Element().get();
      get_domId9Element().get();
      get_domId10Element().get();
      get_domId11Element().get();
      get_domId12Element().get();

      // Detach section.
      attachRecord1525.detach();
      f_HTMLPanel5.addAndReplaceElement(get_mobileFriendly(), get_domId6Element().get());
      f_HTMLPanel5.addAndReplaceElement(get_lblresourceType(), get_domId7Element().get());
      f_HTMLPanel5.addAndReplaceElement(get_resourceInfoSeparator(), get_domId8Element().get());
      f_HTMLPanel5.addAndReplaceElement(get_resourceView(), get_domId9Element().get());
      f_HTMLPanel5.addAndReplaceElement(get_resourcetypeSeparator(), get_domId10Element().get());
      f_HTMLPanel5.addAndReplaceElement(get_timeRequiredLabel(), get_domId11Element().get());
      f_HTMLPanel5.addAndReplaceElement(get_timeRequiredvalue(), get_domId12Element().get());

      return f_HTMLPanel5;
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
     * Getter for mobileFriendly called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_mobileFriendly() {
      return build_mobileFriendly();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_mobileFriendly() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel mobileFriendly = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      mobileFriendly.setStyleName("" + get_playerStyle().ipadFriendlyIconNone() + "");


      owner.mobileFriendly = mobileFriendly;

      return mobileFriendly;
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
     * Getter for lblresourceType called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_lblresourceType() {
      return build_lblresourceType();
    }
    private com.google.gwt.user.client.ui.Label build_lblresourceType() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblresourceType = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblresourceType.setStyleName("" + get_playerStyle().resourceInfoTitleViewTitle2() + "");


      owner.lblresourceType = lblresourceType;

      return lblresourceType;
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
     * Getter for domId8 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for resourceInfoSeparator called 1 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId8Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId9 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for resourceView called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_resourceView() {
      return build_resourceView();
    }
    private com.google.gwt.user.client.ui.Label build_resourceView() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label resourceView = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      resourceView.setStyleName("" + get_playerStyle().resourceInfoTitleViewTitle() + "");


      owner.resourceView = resourceView;

      return resourceView;
    }

    /**
     * Getter for domId9Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId10 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for resourcetypeSeparator called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTML get_resourcetypeSeparator() {
      return build_resourcetypeSeparator();
    }
    private com.google.gwt.user.client.ui.HTML build_resourcetypeSeparator() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML resourcetypeSeparator = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.


      owner.resourcetypeSeparator = resourcetypeSeparator;

      return resourcetypeSeparator;
    }

    /**
     * Getter for domId10Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId11 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for timeRequiredLabel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_timeRequiredLabel() {
      return build_timeRequiredLabel();
    }
    private com.google.gwt.user.client.ui.Label build_timeRequiredLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label timeRequiredLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      timeRequiredLabel.setStyleName("" + get_playerStyle().resourceInfoTitleViewTitle1() + "");


      owner.timeRequiredLabel = timeRequiredLabel;

      return timeRequiredLabel;
    }

    /**
     * Getter for domId11Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for timeRequiredvalue called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_timeRequiredvalue() {
      return build_timeRequiredvalue();
    }
    private com.google.gwt.user.client.ui.Label build_timeRequiredvalue() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label timeRequiredvalue = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      timeRequiredvalue.setStyleName("" + get_playerStyle().resourceInfoTitleView() + "");


      owner.timeRequiredvalue = timeRequiredvalue;

      return timeRequiredvalue;
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
     * Getter for domId13 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for f_HTMLPanel6 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel6() {
      return build_f_HTMLPanel6();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel6() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel6 = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      f_HTMLPanel6.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1526 = UiBinderUtil.attachToDom(f_HTMLPanel6.getElement());
      get_domId14Element().get();

      // Detach section.
      attachRecord1526.detach();
      f_HTMLPanel6.addAndReplaceElement(get_learningobjectiveText(), get_domId14Element().get());

      return f_HTMLPanel6;
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
     * Getter for learningobjectiveText called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_learningobjectiveText() {
      return build_learningobjectiveText();
    }
    private com.google.gwt.user.client.ui.Label build_learningobjectiveText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label learningobjectiveText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      learningobjectiveText.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.learningobjectiveText = learningobjectiveText;

      return learningobjectiveText;
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
     * Getter for domId13Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId15 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for f_HTMLPanel7 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel7() {
      return build_f_HTMLPanel7();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel7() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel7 = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.
      f_HTMLPanel7.setStyleName("" + get_playerStyle().resourceInfoDescription() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1527 = UiBinderUtil.attachToDom(f_HTMLPanel7.getElement());
      get_domId16Element().get();
      get_domId17Element().get();

      // Detach section.
      attachRecord1527.detach();
      f_HTMLPanel7.addAndReplaceElement(get_resourceDescriptionTitle(), get_domId16Element().get());
      f_HTMLPanel7.addAndReplaceElement(get_resourceDescription(), get_domId17Element().get());

      return f_HTMLPanel7;
    }

    /**
     * Getter for domId16 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for resourceDescriptionTitle called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_resourceDescriptionTitle() {
      return build_resourceDescriptionTitle();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_resourceDescriptionTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel resourceDescriptionTitle = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      resourceDescriptionTitle.setStyleName("" + get_playerStyle().resourceInfoMoreTitleDesc() + "");


      owner.resourceDescriptionTitle = resourceDescriptionTitle;

      return resourceDescriptionTitle;
    }

    /**
     * Getter for domId16Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for resourceDescription called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_resourceDescription() {
      return build_resourceDescription();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_resourceDescription() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel resourceDescription = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.
      resourceDescription.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.resourceDescription = resourceDescription;

      return resourceDescription;
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
     * Getter for domId15Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for f_HTMLPanel8 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel8() {
      return build_f_HTMLPanel8();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel8() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel8 = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.
      f_HTMLPanel8.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1528 = UiBinderUtil.attachToDom(f_HTMLPanel8.getElement());
      get_domId19Element().get();

      // Detach section.
      attachRecord1528.detach();
      f_HTMLPanel8.addAndReplaceElement(get_generalLbl(), get_domId19Element().get());

      return f_HTMLPanel8;
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
     * Getter for generalLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_generalLbl() {
      return build_generalLbl();
    }
    private com.google.gwt.user.client.ui.Label build_generalLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label generalLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      generalLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitleboarder() + "");


      owner.generalLbl = generalLbl;

      return generalLbl;
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
     * Getter for domId20 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for gradesPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_gradesPanel() {
      return build_gradesPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_gradesPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel gradesPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html8().asString());
      // Setup section.
      gradesPanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1529 = UiBinderUtil.attachToDom(gradesPanel.getElement());
      get_domId21Element().get();
      get_domId22Element().get();

      // Detach section.
      attachRecord1529.detach();
      gradesPanel.addAndReplaceElement(get_gradeTitle(), get_domId21Element().get());
      gradesPanel.addAndReplaceElement(get_gradesText(), get_domId22Element().get());

      owner.gradesPanel = gradesPanel;

      return gradesPanel;
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
     * Getter for gradeTitle called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_gradeTitle() {
      return build_gradeTitle();
    }
    private com.google.gwt.user.client.ui.Label build_gradeTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label gradeTitle = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      gradeTitle.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.gradeTitle = gradeTitle;

      return gradeTitle;
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
     * Getter for domId22 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for gradesText called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_gradesText() {
      return build_gradesText();
    }
    private com.google.gwt.user.client.ui.Label build_gradesText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label gradesText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      gradesText.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.gradesText = gradesText;

      return gradesText;
    }

    /**
     * Getter for domId22Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId20Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId23 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for coursePanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_coursePanel() {
      return build_coursePanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_coursePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel coursePanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html10().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1530 = UiBinderUtil.attachToDom(coursePanel.getElement());
      get_domId24Element().get();
      get_domId25Element().get();

      // Detach section.
      attachRecord1530.detach();
      coursePanel.addAndReplaceElement(get_courseText(), get_domId24Element().get());
      coursePanel.addAndReplaceElement(get_courseInfo(), get_domId25Element().get());

      owner.coursePanel = coursePanel;

      return coursePanel;
    }

    /**
     * Getter for domId24 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for courseText called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_courseText() {
      return build_courseText();
    }
    private com.google.gwt.user.client.ui.Label build_courseText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label courseText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      courseText.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.courseText = courseText;

      return courseText;
    }

    /**
     * Getter for domId24Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId25 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for courseInfo called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_courseInfo() {
      return build_courseInfo();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_courseInfo() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel courseInfo = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      courseInfo.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.courseInfo = courseInfo;

      return courseInfo;
    }

    /**
     * Getter for domId25Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId23Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for standardsContentContainer called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_standardsContentContainer() {
      return build_standardsContentContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_standardsContentContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel standardsContentContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html11().asString());
      // Setup section.
      standardsContentContainer.setStyleName("" + get_playerStyle().resourceInfoStandContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1531 = UiBinderUtil.attachToDom(standardsContentContainer.getElement());
      get_domId27Element().get();
      get_domId28Element().get();

      // Detach section.
      attachRecord1531.detach();
      standardsContentContainer.addAndReplaceElement(get_standardsText(), get_domId27Element().get());
      standardsContentContainer.addAndReplaceElement(get_standaInfo(), get_domId28Element().get());

      owner.standardsContentContainer = standardsContentContainer;

      return standardsContentContainer;
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
     * Getter for standardsText called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_standardsText() {
      return build_standardsText();
    }
    private com.google.gwt.user.client.ui.Label build_standardsText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label standardsText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      standardsText.setStyleName("" + get_playerStyle().resourceInfoStandText() + "");


      owner.standardsText = standardsText;

      return standardsText;
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
     * Getter for standaInfo called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_standaInfo() {
      return build_standaInfo();
    }
    private com.google.gwt.user.client.ui.Label build_standaInfo() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label standaInfo = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      standaInfo.setStyleName("" + get_playerStyle().resourceInfoStandTitle() + "");


      owner.standaInfo = standaInfo;

      return standaInfo;
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
     * Getter for domId29 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for standardsInfoConatiner called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_standardsInfoConatiner() {
      return build_standardsInfoConatiner();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_standardsInfoConatiner() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel standardsInfoConatiner = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      standardsInfoConatiner.setStyleName("" + get_playerStyle().resourceInfoStandWrapper() + "");


      owner.standardsInfoConatiner = standardsInfoConatiner;

      return standardsInfoConatiner;
    }

    /**
     * Getter for domId29Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId30 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for f_HTMLPanel9 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel9() {
      return build_f_HTMLPanel9();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel9() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel9 = new com.google.gwt.user.client.ui.HTMLPanel(template_html12().asString());
      // Setup section.
      f_HTMLPanel9.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1532 = UiBinderUtil.attachToDom(f_HTMLPanel9.getElement());
      get_domId31Element().get();

      // Detach section.
      attachRecord1532.detach();
      f_HTMLPanel9.addAndReplaceElement(get_originalUrlTitle(), get_domId31Element().get());

      return f_HTMLPanel9;
    }

    /**
     * Getter for domId31 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for originalUrlTitle called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_originalUrlTitle() {
      return build_originalUrlTitle();
    }
    private com.google.gwt.user.client.ui.Label build_originalUrlTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label originalUrlTitle = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      originalUrlTitle.setStyleName("" + get_playerStyle().resourceInfoStandText() + "");


      owner.originalUrlTitle = originalUrlTitle;

      return originalUrlTitle;
    }

    /**
     * Getter for domId31Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId30Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId32 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for originalUrlText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_originalUrlText() {
      return build_originalUrlText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_originalUrlText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel originalUrlText = new com.google.gwt.user.client.ui.HTMLPanel(template_html13().asString());
      // Setup section.
      originalUrlText.setStyleName("" + get_playerStyle().resourceInfoDescription() + "");


      owner.originalUrlText = originalUrlText;

      return originalUrlText;
    }

    /**
     * Getter for domId32Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId33 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for thumbnailPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_thumbnailPanel() {
      return build_thumbnailPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_thumbnailPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel thumbnailPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html15().asString());
      // Setup section.
      thumbnailPanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1533 = UiBinderUtil.attachToDom(thumbnailPanel.getElement());
      get_domId34Element().get();
      get_domId35Element().get();

      // Detach section.
      attachRecord1533.detach();
      thumbnailPanel.addAndReplaceElement(get_thumbnailText(), get_domId34Element().get());
      thumbnailPanel.addAndReplaceElement(get_thumbnailurlValue(), get_domId35Element().get());

      owner.thumbnailPanel = thumbnailPanel;

      return thumbnailPanel;
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
     * Getter for thumbnailText called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_thumbnailText() {
      return build_thumbnailText();
    }
    private com.google.gwt.user.client.ui.Label build_thumbnailText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label thumbnailText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      thumbnailText.setStyleName("" + get_playerStyle().resourceInfoStandText() + "");


      owner.thumbnailText = thumbnailText;

      return thumbnailText;
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
     * Getter for thumbnailurlValue called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_thumbnailurlValue() {
      return build_thumbnailurlValue();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_thumbnailurlValue() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel thumbnailurlValue = new com.google.gwt.user.client.ui.HTMLPanel(template_html14().asString());
      // Setup section.
      thumbnailurlValue.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.thumbnailurlValue = thumbnailurlValue;

      return thumbnailurlValue;
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
     * Getter for domId33Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for publisherPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_publisherPanel() {
      return build_publisherPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_publisherPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel publisherPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html16().asString());
      // Setup section.
      publisherPanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1534 = UiBinderUtil.attachToDom(publisherPanel.getElement());
      get_domId37Element().get();
      get_domId38Element().get();

      // Detach section.
      attachRecord1534.detach();
      publisherPanel.addAndReplaceElement(get_publisherText(), get_domId37Element().get());
      publisherPanel.addAndReplaceElement(get_lblPublisher(), get_domId38Element().get());

      owner.publisherPanel = publisherPanel;

      return publisherPanel;
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
     * Getter for publisherText called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_publisherText() {
      return build_publisherText();
    }
    private com.google.gwt.user.client.ui.Label build_publisherText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label publisherText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      publisherText.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.publisherText = publisherText;

      return publisherText;
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
     * Getter for lblPublisher called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_lblPublisher() {
      return build_lblPublisher();
    }
    private com.google.gwt.user.client.ui.Label build_lblPublisher() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblPublisher = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblPublisher.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.lblPublisher = lblPublisher;

      return lblPublisher;
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
     * Getter for domId39 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for hostPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_hostPanel() {
      return build_hostPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_hostPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel hostPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html17().asString());
      // Setup section.
      hostPanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1535 = UiBinderUtil.attachToDom(hostPanel.getElement());
      get_domId40Element().get();
      get_domId41Element().get();

      // Detach section.
      attachRecord1535.detach();
      hostPanel.addAndReplaceElement(get_hostLbl(), get_domId40Element().get());
      hostPanel.addAndReplaceElement(get_hostType(), get_domId41Element().get());

      owner.hostPanel = hostPanel;

      return hostPanel;
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
     * Getter for hostLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_hostLbl() {
      return build_hostLbl();
    }
    private com.google.gwt.user.client.ui.Label build_hostLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label hostLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      hostLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.hostLbl = hostLbl;

      return hostLbl;
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
     * Getter for domId41 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for hostType called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_hostType() {
      return build_hostType();
    }
    private com.google.gwt.user.client.ui.Label build_hostType() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label hostType = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      hostType.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.hostType = hostType;

      return hostType;
    }

    /**
     * Getter for domId41Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId39Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for licenceContainer called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_licenceContainer() {
      return build_licenceContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_licenceContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel licenceContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      licenceContainer.add(get_f_HTMLPanel10());
      licenceContainer.setStyleName("" + get_playerStyle().resourceInfoMoreLeftWrapper() + "");


      owner.licenceContainer = licenceContainer;

      return licenceContainer;
    }

    /**
     * Getter for f_HTMLPanel10 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel10() {
      return build_f_HTMLPanel10();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel10() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel10 = new com.google.gwt.user.client.ui.HTMLPanel(template_html19().asString());
      // Setup section.
      f_HTMLPanel10.setStyleName("" + get_playerStyle().resourceInfoRightsWrapper() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1536 = UiBinderUtil.attachToDom(f_HTMLPanel10.getElement());
      get_domId43Element().get();
      get_domId44Element().get();

      // Detach section.
      attachRecord1536.detach();
      f_HTMLPanel10.addAndReplaceElement(get_legalText(), get_domId43Element().get());
      f_HTMLPanel10.addAndReplaceElement(get_rightsLogoContainer(), get_domId44Element().get());

      return f_HTMLPanel10;
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
     * Getter for legalText called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Label get_legalText() {
      return build_legalText();
    }
    private com.google.gwt.user.client.ui.Label build_legalText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label legalText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      legalText.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.legalText = legalText;

      return legalText;
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
     * Getter for domId44 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for rightsLogoContainer called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_rightsLogoContainer() {
      return build_rightsLogoContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_rightsLogoContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel rightsLogoContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html18().asString());
      // Setup section.
      rightsLogoContainer.setStyleName("" + get_playerStyle().resourceInfoRightsText() + "");


      owner.rightsLogoContainer = rightsLogoContainer;

      return rightsLogoContainer;
    }

    /**
     * Getter for domId44Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId45 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for licenceCodePanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_licenceCodePanel() {
      return build_licenceCodePanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_licenceCodePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel licenceCodePanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html20().asString());
      // Setup section.
      licenceCodePanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1537 = UiBinderUtil.attachToDom(licenceCodePanel.getElement());
      get_domId46Element().get();
      get_domId47Element().get();

      // Detach section.
      attachRecord1537.detach();
      licenceCodePanel.addAndReplaceElement(get_licenceCodeLbl(), get_domId46Element().get());
      licenceCodePanel.addAndReplaceElement(get_licenceCodeType(), get_domId47Element().get());

      owner.licenceCodePanel = licenceCodePanel;

      return licenceCodePanel;
    }

    /**
     * Getter for domId46 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for licenceCodeLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_licenceCodeLbl() {
      return build_licenceCodeLbl();
    }
    private com.google.gwt.user.client.ui.Label build_licenceCodeLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label licenceCodeLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      licenceCodeLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.licenceCodeLbl = licenceCodeLbl;

      return licenceCodeLbl;
    }

    /**
     * Getter for domId46Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId47 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for licenceCodeType called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_licenceCodeType() {
      return build_licenceCodeType();
    }
    private com.google.gwt.user.client.ui.Label build_licenceCodeType() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label licenceCodeType = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      licenceCodeType.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.licenceCodeType = licenceCodeType;

      return licenceCodeType;
    }

    /**
     * Getter for domId47Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId45Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId48 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for f_HTMLPanel11 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel11() {
      return build_f_HTMLPanel11();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel11() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel11 = new com.google.gwt.user.client.ui.HTMLPanel(template_html21().asString());
      // Setup section.
      f_HTMLPanel11.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1538 = UiBinderUtil.attachToDom(f_HTMLPanel11.getElement());
      get_domId49Element().get();

      // Detach section.
      attachRecord1538.detach();
      f_HTMLPanel11.addAndReplaceElement(get_educationallLbl(), get_domId49Element().get());

      return f_HTMLPanel11;
    }

    /**
     * Getter for domId49 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for educationallLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_educationallLbl() {
      return build_educationallLbl();
    }
    private com.google.gwt.user.client.ui.Label build_educationallLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label educationallLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      educationallLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitleboarder() + "");


      owner.educationallLbl = educationallLbl;

      return educationallLbl;
    }

    /**
     * Getter for domId49Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId48Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId50 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for eduAllignPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_eduAllignPanel() {
      return build_eduAllignPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_eduAllignPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel eduAllignPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html22().asString());
      // Setup section.
      eduAllignPanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1539 = UiBinderUtil.attachToDom(eduAllignPanel.getElement());
      get_domId51Element().get();
      get_domId52Element().get();

      // Detach section.
      attachRecord1539.detach();
      eduAllignPanel.addAndReplaceElement(get_eduAllignLbl(), get_domId51Element().get());
      eduAllignPanel.addAndReplaceElement(get_eduAllignType(), get_domId52Element().get());

      owner.eduAllignPanel = eduAllignPanel;

      return eduAllignPanel;
    }

    /**
     * Getter for domId51 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for eduAllignLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_eduAllignLbl() {
      return build_eduAllignLbl();
    }
    private com.google.gwt.user.client.ui.Label build_eduAllignLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label eduAllignLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      eduAllignLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.eduAllignLbl = eduAllignLbl;

      return eduAllignLbl;
    }

    /**
     * Getter for domId51Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId52 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for eduAllignType called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_eduAllignType() {
      return build_eduAllignType();
    }
    private com.google.gwt.user.client.ui.Label build_eduAllignType() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label eduAllignType = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      eduAllignType.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.eduAllignType = eduAllignType;

      return eduAllignType;
    }

    /**
     * Getter for domId52Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId50Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId53 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for eduUsePanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_eduUsePanel() {
      return build_eduUsePanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_eduUsePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel eduUsePanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html24().asString());
      // Setup section.
      eduUsePanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1540 = UiBinderUtil.attachToDom(eduUsePanel.getElement());
      get_domId54Element().get();
      get_domId55Element().get();

      // Detach section.
      attachRecord1540.detach();
      eduUsePanel.addAndReplaceElement(get_eduUseLbl(), get_domId54Element().get());
      eduUsePanel.addAndReplaceElement(get_eduUseType(), get_domId55Element().get());

      owner.eduUsePanel = eduUsePanel;

      return eduUsePanel;
    }

    /**
     * Getter for domId54 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for eduUseLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_eduUseLbl() {
      return build_eduUseLbl();
    }
    private com.google.gwt.user.client.ui.Label build_eduUseLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label eduUseLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      eduUseLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.eduUseLbl = eduUseLbl;

      return eduUseLbl;
    }

    /**
     * Getter for domId54Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId55 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for eduUseType called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_eduUseType() {
      return build_eduUseType();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_eduUseType() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel eduUseType = new com.google.gwt.user.client.ui.HTMLPanel(template_html23().asString());
      // Setup section.
      eduUseType.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.eduUseType = eduUseType;

      return eduUseType;
    }

    /**
     * Getter for domId55Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId53Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId56 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for eduRolePanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_eduRolePanel() {
      return build_eduRolePanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_eduRolePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel eduRolePanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html25().asString());
      // Setup section.
      eduRolePanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1541 = UiBinderUtil.attachToDom(eduRolePanel.getElement());
      get_domId57Element().get();
      get_domId58Element().get();

      // Detach section.
      attachRecord1541.detach();
      eduRolePanel.addAndReplaceElement(get_eduRoleLbl(), get_domId57Element().get());
      eduRolePanel.addAndReplaceElement(get_eduRoleType(), get_domId58Element().get());

      owner.eduRolePanel = eduRolePanel;

      return eduRolePanel;
    }

    /**
     * Getter for domId57 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for eduRoleLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_eduRoleLbl() {
      return build_eduRoleLbl();
    }
    private com.google.gwt.user.client.ui.Label build_eduRoleLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label eduRoleLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      eduRoleLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.eduRoleLbl = eduRoleLbl;

      return eduRoleLbl;
    }

    /**
     * Getter for domId57Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId58 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for eduRoleType called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_eduRoleType() {
      return build_eduRoleType();
    }
    private com.google.gwt.user.client.ui.Label build_eduRoleType() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label eduRoleType = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      eduRoleType.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.eduRoleType = eduRoleType;

      return eduRoleType;
    }

    /**
     * Getter for domId58Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId56Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId59 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for interactivityTypePanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_interactivityTypePanel() {
      return build_interactivityTypePanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_interactivityTypePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel interactivityTypePanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html26().asString());
      // Setup section.
      interactivityTypePanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1542 = UiBinderUtil.attachToDom(interactivityTypePanel.getElement());
      get_domId60Element().get();
      get_domId61Element().get();

      // Detach section.
      attachRecord1542.detach();
      interactivityTypePanel.addAndReplaceElement(get_interactiveLbl(), get_domId60Element().get());
      interactivityTypePanel.addAndReplaceElement(get_interactiveType(), get_domId61Element().get());

      owner.interactivityTypePanel = interactivityTypePanel;

      return interactivityTypePanel;
    }

    /**
     * Getter for domId60 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for interactiveLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_interactiveLbl() {
      return build_interactiveLbl();
    }
    private com.google.gwt.user.client.ui.Label build_interactiveLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label interactiveLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      interactiveLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.interactiveLbl = interactiveLbl;

      return interactiveLbl;
    }

    /**
     * Getter for domId60Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId61 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for interactiveType called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_interactiveType() {
      return build_interactiveType();
    }
    private com.google.gwt.user.client.ui.Label build_interactiveType() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label interactiveType = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      interactiveType.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.interactiveType = interactiveType;

      return interactiveType;
    }

    /**
     * Getter for domId61Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId59Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId62 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId62;
    private java.lang.String get_domId62() {
      return domId62;
    }
    private java.lang.String build_domId62() {
      // Creation section.
      domId62 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId62;
    }

    /**
     * Getter for ageRangePanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_ageRangePanel() {
      return build_ageRangePanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_ageRangePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel ageRangePanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html27().asString());
      // Setup section.
      ageRangePanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1543 = UiBinderUtil.attachToDom(ageRangePanel.getElement());
      get_domId63Element().get();
      get_domId64Element().get();

      // Detach section.
      attachRecord1543.detach();
      ageRangePanel.addAndReplaceElement(get_ageRangeLbl(), get_domId63Element().get());
      ageRangePanel.addAndReplaceElement(get_ageRangeType(), get_domId64Element().get());

      owner.ageRangePanel = ageRangePanel;

      return ageRangePanel;
    }

    /**
     * Getter for domId63 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId63;
    private java.lang.String get_domId63() {
      return domId63;
    }
    private java.lang.String build_domId63() {
      // Creation section.
      domId63 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId63;
    }

    /**
     * Getter for ageRangeLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_ageRangeLbl() {
      return build_ageRangeLbl();
    }
    private com.google.gwt.user.client.ui.Label build_ageRangeLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label ageRangeLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      ageRangeLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.ageRangeLbl = ageRangeLbl;

      return ageRangeLbl;
    }

    /**
     * Getter for domId63Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId63Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId63Element() {
      return domId63Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId63Element() {
      // Creation section.
      domId63Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId63());
      // Setup section.


      return domId63Element;
    }

    /**
     * Getter for domId64 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId64;
    private java.lang.String get_domId64() {
      return domId64;
    }
    private java.lang.String build_domId64() {
      // Creation section.
      domId64 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId64;
    }

    /**
     * Getter for ageRangeType called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_ageRangeType() {
      return build_ageRangeType();
    }
    private com.google.gwt.user.client.ui.Label build_ageRangeType() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label ageRangeType = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      ageRangeType.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.ageRangeType = ageRangeType;

      return ageRangeType;
    }

    /**
     * Getter for domId64Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId64Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId64Element() {
      return domId64Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId64Element() {
      // Creation section.
      domId64Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId64());
      // Setup section.


      return domId64Element;
    }

    /**
     * Getter for domId62Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId62Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId62Element() {
      return domId62Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId62Element() {
      // Creation section.
      domId62Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId62());
      // Setup section.


      return domId62Element;
    }

    /**
     * Getter for domId65 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId65;
    private java.lang.String get_domId65() {
      return domId65;
    }
    private java.lang.String build_domId65() {
      // Creation section.
      domId65 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId65;
    }

    /**
     * Getter for dKnowledgePanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_dKnowledgePanel() {
      return build_dKnowledgePanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_dKnowledgePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel dKnowledgePanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html29().asString());
      // Setup section.
      dKnowledgePanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1544 = UiBinderUtil.attachToDom(dKnowledgePanel.getElement());
      get_domId66Element().get();
      get_domId67Element().get();

      // Detach section.
      attachRecord1544.detach();
      dKnowledgePanel.addAndReplaceElement(get_dKnowledgeLbl(), get_domId66Element().get());
      dKnowledgePanel.addAndReplaceElement(get_dKnowledgeType(), get_domId67Element().get());

      owner.dKnowledgePanel = dKnowledgePanel;

      return dKnowledgePanel;
    }

    /**
     * Getter for domId66 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId66;
    private java.lang.String get_domId66() {
      return domId66;
    }
    private java.lang.String build_domId66() {
      // Creation section.
      domId66 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId66;
    }

    /**
     * Getter for dKnowledgeLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_dKnowledgeLbl() {
      return build_dKnowledgeLbl();
    }
    private com.google.gwt.user.client.ui.Label build_dKnowledgeLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label dKnowledgeLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      dKnowledgeLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.dKnowledgeLbl = dKnowledgeLbl;

      return dKnowledgeLbl;
    }

    /**
     * Getter for domId66Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId66Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId66Element() {
      return domId66Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId66Element() {
      // Creation section.
      domId66Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId66());
      // Setup section.


      return domId66Element;
    }

    /**
     * Getter for domId67 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId67;
    private java.lang.String get_domId67() {
      return domId67;
    }
    private java.lang.String build_domId67() {
      // Creation section.
      domId67 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId67;
    }

    /**
     * Getter for dKnowledgeType called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_dKnowledgeType() {
      return build_dKnowledgeType();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_dKnowledgeType() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel dKnowledgeType = new com.google.gwt.user.client.ui.HTMLPanel(template_html28().asString());
      // Setup section.
      dKnowledgeType.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.dKnowledgeType = dKnowledgeType;

      return dKnowledgeType;
    }

    /**
     * Getter for domId67Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId67Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId67Element() {
      return domId67Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId67Element() {
      // Creation section.
      domId67Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId67());
      // Setup section.


      return domId67Element;
    }

    /**
     * Getter for domId65Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId65Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId65Element() {
      return domId65Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId65Element() {
      // Creation section.
      domId65Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId65());
      // Setup section.


      return domId65Element;
    }

    /**
     * Getter for domId68 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId68;
    private java.lang.String get_domId68() {
      return domId68;
    }
    private java.lang.String build_domId68() {
      // Creation section.
      domId68 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId68;
    }

    /**
     * Getter for momentsoflearningPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_momentsoflearningPanel() {
      return build_momentsoflearningPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_momentsoflearningPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel momentsoflearningPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html31().asString());
      // Setup section.
      momentsoflearningPanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1545 = UiBinderUtil.attachToDom(momentsoflearningPanel.getElement());
      get_domId69Element().get();
      get_domId70Element().get();

      // Detach section.
      attachRecord1545.detach();
      momentsoflearningPanel.addAndReplaceElement(get_momentsoflearningLbl(), get_domId69Element().get());
      momentsoflearningPanel.addAndReplaceElement(get_momentsoflearningType(), get_domId70Element().get());

      owner.momentsoflearningPanel = momentsoflearningPanel;

      return momentsoflearningPanel;
    }

    /**
     * Getter for domId69 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId69;
    private java.lang.String get_domId69() {
      return domId69;
    }
    private java.lang.String build_domId69() {
      // Creation section.
      domId69 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId69;
    }

    /**
     * Getter for momentsoflearningLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_momentsoflearningLbl() {
      return build_momentsoflearningLbl();
    }
    private com.google.gwt.user.client.ui.Label build_momentsoflearningLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label momentsoflearningLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      momentsoflearningLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.momentsoflearningLbl = momentsoflearningLbl;

      return momentsoflearningLbl;
    }

    /**
     * Getter for domId69Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId69Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId69Element() {
      return domId69Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId69Element() {
      // Creation section.
      domId69Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId69());
      // Setup section.


      return domId69Element;
    }

    /**
     * Getter for domId70 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId70;
    private java.lang.String get_domId70() {
      return domId70;
    }
    private java.lang.String build_domId70() {
      // Creation section.
      domId70 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId70;
    }

    /**
     * Getter for momentsoflearningType called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_momentsoflearningType() {
      return build_momentsoflearningType();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_momentsoflearningType() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel momentsoflearningType = new com.google.gwt.user.client.ui.HTMLPanel(template_html30().asString());
      // Setup section.
      momentsoflearningType.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.momentsoflearningType = momentsoflearningType;

      return momentsoflearningType;
    }

    /**
     * Getter for domId70Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId70Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId70Element() {
      return domId70Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId70Element() {
      // Creation section.
      domId70Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId70());
      // Setup section.


      return domId70Element;
    }

    /**
     * Getter for domId68Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId68Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId68Element() {
      return domId68Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId68Element() {
      // Creation section.
      domId68Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId68());
      // Setup section.


      return domId68Element;
    }

    /**
     * Getter for domId71 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId71;
    private java.lang.String get_domId71() {
      return domId71;
    }
    private java.lang.String build_domId71() {
      // Creation section.
      domId71 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId71;
    }

    /**
     * Getter for readingLevelPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_readingLevelPanel() {
      return build_readingLevelPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_readingLevelPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel readingLevelPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html33().asString());
      // Setup section.
      readingLevelPanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1546 = UiBinderUtil.attachToDom(readingLevelPanel.getElement());
      get_domId72Element().get();
      get_domId73Element().get();

      // Detach section.
      attachRecord1546.detach();
      readingLevelPanel.addAndReplaceElement(get_readingLevelLbl(), get_domId72Element().get());
      readingLevelPanel.addAndReplaceElement(get_readingLevelType(), get_domId73Element().get());

      owner.readingLevelPanel = readingLevelPanel;

      return readingLevelPanel;
    }

    /**
     * Getter for domId72 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId72;
    private java.lang.String get_domId72() {
      return domId72;
    }
    private java.lang.String build_domId72() {
      // Creation section.
      domId72 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId72;
    }

    /**
     * Getter for readingLevelLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_readingLevelLbl() {
      return build_readingLevelLbl();
    }
    private com.google.gwt.user.client.ui.Label build_readingLevelLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label readingLevelLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      readingLevelLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.readingLevelLbl = readingLevelLbl;

      return readingLevelLbl;
    }

    /**
     * Getter for domId72Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId72Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId72Element() {
      return domId72Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId72Element() {
      // Creation section.
      domId72Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId72());
      // Setup section.


      return domId72Element;
    }

    /**
     * Getter for domId73 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId73;
    private java.lang.String get_domId73() {
      return domId73;
    }
    private java.lang.String build_domId73() {
      // Creation section.
      domId73 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId73;
    }

    /**
     * Getter for readingLevelType called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_readingLevelType() {
      return build_readingLevelType();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_readingLevelType() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel readingLevelType = new com.google.gwt.user.client.ui.HTMLPanel(template_html32().asString());
      // Setup section.
      readingLevelType.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.readingLevelType = readingLevelType;

      return readingLevelType;
    }

    /**
     * Getter for domId73Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId73Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId73Element() {
      return domId73Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId73Element() {
      // Creation section.
      domId73Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId73());
      // Setup section.


      return domId73Element;
    }

    /**
     * Getter for domId71Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId71Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId71Element() {
      return domId71Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId71Element() {
      // Creation section.
      domId71Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId71());
      // Setup section.


      return domId71Element;
    }

    /**
     * Getter for domId74 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId74;
    private java.lang.String get_domId74() {
      return domId74;
    }
    private java.lang.String build_domId74() {
      // Creation section.
      domId74 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId74;
    }

    /**
     * Getter for gooruSubjectPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_gooruSubjectPanel() {
      return build_gooruSubjectPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_gooruSubjectPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel gooruSubjectPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html34().asString());
      // Setup section.
      gooruSubjectPanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1547 = UiBinderUtil.attachToDom(gooruSubjectPanel.getElement());
      get_domId75Element().get();
      get_domId76Element().get();

      // Detach section.
      attachRecord1547.detach();
      gooruSubjectPanel.addAndReplaceElement(get_gooruSubjectLbl(), get_domId75Element().get());
      gooruSubjectPanel.addAndReplaceElement(get_gooruSubjectInfo(), get_domId76Element().get());

      owner.gooruSubjectPanel = gooruSubjectPanel;

      return gooruSubjectPanel;
    }

    /**
     * Getter for domId75 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId75;
    private java.lang.String get_domId75() {
      return domId75;
    }
    private java.lang.String build_domId75() {
      // Creation section.
      domId75 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId75;
    }

    /**
     * Getter for gooruSubjectLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_gooruSubjectLbl() {
      return build_gooruSubjectLbl();
    }
    private com.google.gwt.user.client.ui.Label build_gooruSubjectLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label gooruSubjectLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      gooruSubjectLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.gooruSubjectLbl = gooruSubjectLbl;

      return gooruSubjectLbl;
    }

    /**
     * Getter for domId75Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId75Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId75Element() {
      return domId75Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId75Element() {
      // Creation section.
      domId75Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId75());
      // Setup section.


      return domId75Element;
    }

    /**
     * Getter for domId76 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId76;
    private java.lang.String get_domId76() {
      return domId76;
    }
    private java.lang.String build_domId76() {
      // Creation section.
      domId76 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId76;
    }

    /**
     * Getter for gooruSubjectInfo called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_gooruSubjectInfo() {
      return build_gooruSubjectInfo();
    }
    private com.google.gwt.user.client.ui.Label build_gooruSubjectInfo() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label gooruSubjectInfo = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      gooruSubjectInfo.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.gooruSubjectInfo = gooruSubjectInfo;

      return gooruSubjectInfo;
    }

    /**
     * Getter for domId76Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId76Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId76Element() {
      return domId76Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId76Element() {
      // Creation section.
      domId76Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId76());
      // Setup section.


      return domId76Element;
    }

    /**
     * Getter for domId74Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId74Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId74Element() {
      return domId74Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId74Element() {
      // Creation section.
      domId74Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId74());
      // Setup section.


      return domId74Element;
    }

    /**
     * Getter for domId77 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId77;
    private java.lang.String get_domId77() {
      return domId77;
    }
    private java.lang.String build_domId77() {
      // Creation section.
      domId77 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId77;
    }

    /**
     * Getter for gooruCoursePanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_gooruCoursePanel() {
      return build_gooruCoursePanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_gooruCoursePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel gooruCoursePanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html36().asString());
      // Setup section.
      gooruCoursePanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1548 = UiBinderUtil.attachToDom(gooruCoursePanel.getElement());
      get_domId78Element().get();
      get_domId79Element().get();

      // Detach section.
      attachRecord1548.detach();
      gooruCoursePanel.addAndReplaceElement(get_gooruCourseLbl(), get_domId78Element().get());
      gooruCoursePanel.addAndReplaceElement(get_gooruCourseInfo(), get_domId79Element().get());

      owner.gooruCoursePanel = gooruCoursePanel;

      return gooruCoursePanel;
    }

    /**
     * Getter for domId78 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId78;
    private java.lang.String get_domId78() {
      return domId78;
    }
    private java.lang.String build_domId78() {
      // Creation section.
      domId78 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId78;
    }

    /**
     * Getter for gooruCourseLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_gooruCourseLbl() {
      return build_gooruCourseLbl();
    }
    private com.google.gwt.user.client.ui.Label build_gooruCourseLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label gooruCourseLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      gooruCourseLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.gooruCourseLbl = gooruCourseLbl;

      return gooruCourseLbl;
    }

    /**
     * Getter for domId78Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId78Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId78Element() {
      return domId78Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId78Element() {
      // Creation section.
      domId78Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId78());
      // Setup section.


      return domId78Element;
    }

    /**
     * Getter for domId79 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId79;
    private java.lang.String get_domId79() {
      return domId79;
    }
    private java.lang.String build_domId79() {
      // Creation section.
      domId79 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId79;
    }

    /**
     * Getter for gooruCourseInfo called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_gooruCourseInfo() {
      return build_gooruCourseInfo();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_gooruCourseInfo() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel gooruCourseInfo = new com.google.gwt.user.client.ui.HTMLPanel(template_html35().asString());
      // Setup section.
      gooruCourseInfo.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.gooruCourseInfo = gooruCourseInfo;

      return gooruCourseInfo;
    }

    /**
     * Getter for domId79Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId79Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId79Element() {
      return domId79Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId79Element() {
      // Creation section.
      domId79Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId79());
      // Setup section.


      return domId79Element;
    }

    /**
     * Getter for domId77Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId77Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId77Element() {
      return domId77Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId77Element() {
      // Creation section.
      domId77Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId77());
      // Setup section.


      return domId77Element;
    }

    /**
     * Getter for domId80 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId80;
    private java.lang.String get_domId80() {
      return domId80;
    }
    private java.lang.String build_domId80() {
      // Creation section.
      domId80 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId80;
    }

    /**
     * Getter for f_HTMLPanel12 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel12() {
      return build_f_HTMLPanel12();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel12() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel12 = new com.google.gwt.user.client.ui.HTMLPanel(template_html37().asString());
      // Setup section.
      f_HTMLPanel12.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1549 = UiBinderUtil.attachToDom(f_HTMLPanel12.getElement());
      get_domId81Element().get();

      // Detach section.
      attachRecord1549.detach();
      f_HTMLPanel12.addAndReplaceElement(get_resourceInfoLbl(), get_domId81Element().get());

      return f_HTMLPanel12;
    }

    /**
     * Getter for domId81 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId81;
    private java.lang.String get_domId81() {
      return domId81;
    }
    private java.lang.String build_domId81() {
      // Creation section.
      domId81 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId81;
    }

    /**
     * Getter for resourceInfoLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_resourceInfoLbl() {
      return build_resourceInfoLbl();
    }
    private com.google.gwt.user.client.ui.Label build_resourceInfoLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label resourceInfoLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      resourceInfoLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitleboarder() + "");


      owner.resourceInfoLbl = resourceInfoLbl;

      return resourceInfoLbl;
    }

    /**
     * Getter for domId81Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId81Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId81Element() {
      return domId81Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId81Element() {
      // Creation section.
      domId81Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId81());
      // Setup section.


      return domId81Element;
    }

    /**
     * Getter for domId80Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId80Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId80Element() {
      return domId80Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId80Element() {
      // Creation section.
      domId80Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId80());
      // Setup section.


      return domId80Element;
    }

    /**
     * Getter for domId82 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId82;
    private java.lang.String get_domId82() {
      return domId82;
    }
    private java.lang.String build_domId82() {
      // Creation section.
      domId82 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId82;
    }

    /**
     * Getter for dateCreatedPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_dateCreatedPanel() {
      return build_dateCreatedPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_dateCreatedPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel dateCreatedPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html38().asString());
      // Setup section.
      dateCreatedPanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1550 = UiBinderUtil.attachToDom(dateCreatedPanel.getElement());
      get_domId83Element().get();
      get_domId84Element().get();

      // Detach section.
      attachRecord1550.detach();
      dateCreatedPanel.addAndReplaceElement(get_dateCreatedLbl(), get_domId83Element().get());
      dateCreatedPanel.addAndReplaceElement(get_createdDateInfo(), get_domId84Element().get());

      owner.dateCreatedPanel = dateCreatedPanel;

      return dateCreatedPanel;
    }

    /**
     * Getter for domId83 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId83;
    private java.lang.String get_domId83() {
      return domId83;
    }
    private java.lang.String build_domId83() {
      // Creation section.
      domId83 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId83;
    }

    /**
     * Getter for dateCreatedLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_dateCreatedLbl() {
      return build_dateCreatedLbl();
    }
    private com.google.gwt.user.client.ui.Label build_dateCreatedLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label dateCreatedLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      dateCreatedLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.dateCreatedLbl = dateCreatedLbl;

      return dateCreatedLbl;
    }

    /**
     * Getter for domId83Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId83Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId83Element() {
      return domId83Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId83Element() {
      // Creation section.
      domId83Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId83());
      // Setup section.


      return domId83Element;
    }

    /**
     * Getter for domId84 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId84;
    private java.lang.String get_domId84() {
      return domId84;
    }
    private java.lang.String build_domId84() {
      // Creation section.
      domId84 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId84;
    }

    /**
     * Getter for createdDateInfo called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_createdDateInfo() {
      return build_createdDateInfo();
    }
    private com.google.gwt.user.client.ui.Label build_createdDateInfo() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label createdDateInfo = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      createdDateInfo.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.createdDateInfo = createdDateInfo;

      return createdDateInfo;
    }

    /**
     * Getter for domId84Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId84Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId84Element() {
      return domId84Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId84Element() {
      // Creation section.
      domId84Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId84());
      // Setup section.


      return domId84Element;
    }

    /**
     * Getter for domId82Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId82Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId82Element() {
      return domId82Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId82Element() {
      // Creation section.
      domId82Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId82());
      // Setup section.


      return domId82Element;
    }

    /**
     * Getter for domId85 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId85;
    private java.lang.String get_domId85() {
      return domId85;
    }
    private java.lang.String build_domId85() {
      // Creation section.
      domId85 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId85;
    }

    /**
     * Getter for countryCodePanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_countryCodePanel() {
      return build_countryCodePanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_countryCodePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel countryCodePanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html39().asString());
      // Setup section.
      countryCodePanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1551 = UiBinderUtil.attachToDom(countryCodePanel.getElement());
      get_domId86Element().get();
      get_domId87Element().get();

      // Detach section.
      attachRecord1551.detach();
      countryCodePanel.addAndReplaceElement(get_countryCodeLbl(), get_domId86Element().get());
      countryCodePanel.addAndReplaceElement(get_countryCodeType(), get_domId87Element().get());

      owner.countryCodePanel = countryCodePanel;

      return countryCodePanel;
    }

    /**
     * Getter for domId86 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId86;
    private java.lang.String get_domId86() {
      return domId86;
    }
    private java.lang.String build_domId86() {
      // Creation section.
      domId86 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId86;
    }

    /**
     * Getter for countryCodeLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_countryCodeLbl() {
      return build_countryCodeLbl();
    }
    private com.google.gwt.user.client.ui.Label build_countryCodeLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label countryCodeLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      countryCodeLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.countryCodeLbl = countryCodeLbl;

      return countryCodeLbl;
    }

    /**
     * Getter for domId86Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId86Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId86Element() {
      return domId86Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId86Element() {
      // Creation section.
      domId86Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId86());
      // Setup section.


      return domId86Element;
    }

    /**
     * Getter for domId87 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId87;
    private java.lang.String get_domId87() {
      return domId87;
    }
    private java.lang.String build_domId87() {
      // Creation section.
      domId87 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId87;
    }

    /**
     * Getter for countryCodeType called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_countryCodeType() {
      return build_countryCodeType();
    }
    private com.google.gwt.user.client.ui.Label build_countryCodeType() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label countryCodeType = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      countryCodeType.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.countryCodeType = countryCodeType;

      return countryCodeType;
    }

    /**
     * Getter for domId87Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId87Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId87Element() {
      return domId87Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId87Element() {
      // Creation section.
      domId87Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId87());
      // Setup section.


      return domId87Element;
    }

    /**
     * Getter for domId85Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId85Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId85Element() {
      return domId85Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId85Element() {
      // Creation section.
      domId85Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId85());
      // Setup section.


      return domId85Element;
    }

    /**
     * Getter for domId88 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId88;
    private java.lang.String get_domId88() {
      return domId88;
    }
    private java.lang.String build_domId88() {
      // Creation section.
      domId88 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId88;
    }

    /**
     * Getter for languagePanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_languagePanel() {
      return build_languagePanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_languagePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel languagePanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html40().asString());
      // Setup section.
      languagePanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1552 = UiBinderUtil.attachToDom(languagePanel.getElement());
      get_domId89Element().get();
      get_domId90Element().get();

      // Detach section.
      attachRecord1552.detach();
      languagePanel.addAndReplaceElement(get_languageLbl(), get_domId89Element().get());
      languagePanel.addAndReplaceElement(get_languageType(), get_domId90Element().get());

      owner.languagePanel = languagePanel;

      return languagePanel;
    }

    /**
     * Getter for domId89 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId89;
    private java.lang.String get_domId89() {
      return domId89;
    }
    private java.lang.String build_domId89() {
      // Creation section.
      domId89 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId89;
    }

    /**
     * Getter for languageLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_languageLbl() {
      return build_languageLbl();
    }
    private com.google.gwt.user.client.ui.Label build_languageLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label languageLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      languageLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.languageLbl = languageLbl;

      return languageLbl;
    }

    /**
     * Getter for domId89Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId89Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId89Element() {
      return domId89Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId89Element() {
      // Creation section.
      domId89Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId89());
      // Setup section.


      return domId89Element;
    }

    /**
     * Getter for domId90 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId90;
    private java.lang.String get_domId90() {
      return domId90;
    }
    private java.lang.String build_domId90() {
      // Creation section.
      domId90 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId90;
    }

    /**
     * Getter for languageType called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_languageType() {
      return build_languageType();
    }
    private com.google.gwt.user.client.ui.Label build_languageType() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label languageType = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      languageType.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.languageType = languageType;

      return languageType;
    }

    /**
     * Getter for domId90Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId90Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId90Element() {
      return domId90Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId90Element() {
      // Creation section.
      domId90Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId90());
      // Setup section.


      return domId90Element;
    }

    /**
     * Getter for domId88Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId88Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId88Element() {
      return domId88Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId88Element() {
      // Creation section.
      domId88Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId88());
      // Setup section.


      return domId88Element;
    }

    /**
     * Getter for domId91 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId91;
    private java.lang.String get_domId91() {
      return domId91;
    }
    private java.lang.String build_domId91() {
      // Creation section.
      domId91 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId91;
    }

    /**
     * Getter for DataTypePanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_DataTypePanel() {
      return build_DataTypePanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_DataTypePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel DataTypePanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html41().asString());
      // Setup section.
      DataTypePanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1553 = UiBinderUtil.attachToDom(DataTypePanel.getElement());
      get_domId92Element().get();
      get_domId93Element().get();

      // Detach section.
      attachRecord1553.detach();
      DataTypePanel.addAndReplaceElement(get_dataTypeLbl(), get_domId92Element().get());
      DataTypePanel.addAndReplaceElement(get_dataTypeFormat(), get_domId93Element().get());

      owner.DataTypePanel = DataTypePanel;

      return DataTypePanel;
    }

    /**
     * Getter for domId92 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId92;
    private java.lang.String get_domId92() {
      return domId92;
    }
    private java.lang.String build_domId92() {
      // Creation section.
      domId92 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId92;
    }

    /**
     * Getter for dataTypeLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_dataTypeLbl() {
      return build_dataTypeLbl();
    }
    private com.google.gwt.user.client.ui.Label build_dataTypeLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label dataTypeLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      dataTypeLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.dataTypeLbl = dataTypeLbl;

      return dataTypeLbl;
    }

    /**
     * Getter for domId92Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId92Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId92Element() {
      return domId92Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId92Element() {
      // Creation section.
      domId92Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId92());
      // Setup section.


      return domId92Element;
    }

    /**
     * Getter for domId93 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId93;
    private java.lang.String get_domId93() {
      return domId93;
    }
    private java.lang.String build_domId93() {
      // Creation section.
      domId93 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId93;
    }

    /**
     * Getter for dataTypeFormat called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_dataTypeFormat() {
      return build_dataTypeFormat();
    }
    private com.google.gwt.user.client.ui.Label build_dataTypeFormat() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label dataTypeFormat = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      dataTypeFormat.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.dataTypeFormat = dataTypeFormat;

      return dataTypeFormat;
    }

    /**
     * Getter for domId93Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId93Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId93Element() {
      return domId93Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId93Element() {
      // Creation section.
      domId93Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId93());
      // Setup section.


      return domId93Element;
    }

    /**
     * Getter for domId91Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId91Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId91Element() {
      return domId91Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId91Element() {
      // Creation section.
      domId91Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId91());
      // Setup section.


      return domId91Element;
    }

    /**
     * Getter for domId94 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId94;
    private java.lang.String get_domId94() {
      return domId94;
    }
    private java.lang.String build_domId94() {
      // Creation section.
      domId94 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId94;
    }

    /**
     * Getter for authorPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_authorPanel() {
      return build_authorPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_authorPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel authorPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html42().asString());
      // Setup section.
      authorPanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1554 = UiBinderUtil.attachToDom(authorPanel.getElement());
      get_domId95Element().get();
      get_domId96Element().get();

      // Detach section.
      attachRecord1554.detach();
      authorPanel.addAndReplaceElement(get_authorLbl(), get_domId95Element().get());
      authorPanel.addAndReplaceElement(get_authorName(), get_domId96Element().get());

      owner.authorPanel = authorPanel;

      return authorPanel;
    }

    /**
     * Getter for domId95 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId95;
    private java.lang.String get_domId95() {
      return domId95;
    }
    private java.lang.String build_domId95() {
      // Creation section.
      domId95 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId95;
    }

    /**
     * Getter for authorLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_authorLbl() {
      return build_authorLbl();
    }
    private com.google.gwt.user.client.ui.Label build_authorLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label authorLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      authorLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.authorLbl = authorLbl;

      return authorLbl;
    }

    /**
     * Getter for domId95Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId95Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId95Element() {
      return domId95Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId95Element() {
      // Creation section.
      domId95Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId95());
      // Setup section.


      return domId95Element;
    }

    /**
     * Getter for domId96 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId96;
    private java.lang.String get_domId96() {
      return domId96;
    }
    private java.lang.String build_domId96() {
      // Creation section.
      domId96 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId96;
    }

    /**
     * Getter for authorName called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_authorName() {
      return build_authorName();
    }
    private com.google.gwt.user.client.ui.Label build_authorName() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label authorName = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      authorName.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.authorName = authorName;

      return authorName;
    }

    /**
     * Getter for domId96Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId96Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId96Element() {
      return domId96Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId96Element() {
      // Creation section.
      domId96Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId96());
      // Setup section.


      return domId96Element;
    }

    /**
     * Getter for domId94Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId94Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId94Element() {
      return domId94Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId94Element() {
      // Creation section.
      domId94Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId94());
      // Setup section.


      return domId94Element;
    }

    /**
     * Getter for domId97 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId97;
    private java.lang.String get_domId97() {
      return domId97;
    }
    private java.lang.String build_domId97() {
      // Creation section.
      domId97 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId97;
    }

    /**
     * Getter for copyRightPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_copyRightPanel() {
      return build_copyRightPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_copyRightPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel copyRightPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html43().asString());
      // Setup section.
      copyRightPanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1555 = UiBinderUtil.attachToDom(copyRightPanel.getElement());
      get_domId98Element().get();
      get_domId99Element().get();

      // Detach section.
      attachRecord1555.detach();
      copyRightPanel.addAndReplaceElement(get_copyRightLbl(), get_domId98Element().get());
      copyRightPanel.addAndReplaceElement(get_copyRightType(), get_domId99Element().get());

      owner.copyRightPanel = copyRightPanel;

      return copyRightPanel;
    }

    /**
     * Getter for domId98 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId98;
    private java.lang.String get_domId98() {
      return domId98;
    }
    private java.lang.String build_domId98() {
      // Creation section.
      domId98 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId98;
    }

    /**
     * Getter for copyRightLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_copyRightLbl() {
      return build_copyRightLbl();
    }
    private com.google.gwt.user.client.ui.Label build_copyRightLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label copyRightLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      copyRightLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.copyRightLbl = copyRightLbl;

      return copyRightLbl;
    }

    /**
     * Getter for domId98Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId98Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId98Element() {
      return domId98Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId98Element() {
      // Creation section.
      domId98Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId98());
      // Setup section.


      return domId98Element;
    }

    /**
     * Getter for domId99 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId99;
    private java.lang.String get_domId99() {
      return domId99;
    }
    private java.lang.String build_domId99() {
      // Creation section.
      domId99 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId99;
    }

    /**
     * Getter for copyRightType called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_copyRightType() {
      return build_copyRightType();
    }
    private com.google.gwt.user.client.ui.Label build_copyRightType() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label copyRightType = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      copyRightType.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.copyRightType = copyRightType;

      return copyRightType;
    }

    /**
     * Getter for domId99Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId99Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId99Element() {
      return domId99Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId99Element() {
      // Creation section.
      domId99Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId99());
      // Setup section.


      return domId99Element;
    }

    /**
     * Getter for domId97Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId97Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId97Element() {
      return domId97Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId97Element() {
      // Creation section.
      domId97Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId97());
      // Setup section.


      return domId97Element;
    }

    /**
     * Getter for domId100 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId100;
    private java.lang.String get_domId100() {
      return domId100;
    }
    private java.lang.String build_domId100() {
      // Creation section.
      domId100 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId100;
    }

    /**
     * Getter for contributorPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_contributorPanel() {
      return build_contributorPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_contributorPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel contributorPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html44().asString());
      // Setup section.
      contributorPanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1556 = UiBinderUtil.attachToDom(contributorPanel.getElement());
      get_domId101Element().get();
      get_domId102Element().get();

      // Detach section.
      attachRecord1556.detach();
      contributorPanel.addAndReplaceElement(get_contributorTitle(), get_domId101Element().get());
      contributorPanel.addAndReplaceElement(get_contributorName(), get_domId102Element().get());

      owner.contributorPanel = contributorPanel;

      return contributorPanel;
    }

    /**
     * Getter for domId101 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId101;
    private java.lang.String get_domId101() {
      return domId101;
    }
    private java.lang.String build_domId101() {
      // Creation section.
      domId101 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId101;
    }

    /**
     * Getter for contributorTitle called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_contributorTitle() {
      return build_contributorTitle();
    }
    private com.google.gwt.user.client.ui.Label build_contributorTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label contributorTitle = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      contributorTitle.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.contributorTitle = contributorTitle;

      return contributorTitle;
    }

    /**
     * Getter for domId101Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId101Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId101Element() {
      return domId101Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId101Element() {
      // Creation section.
      domId101Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId101());
      // Setup section.


      return domId101Element;
    }

    /**
     * Getter for domId102 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId102;
    private java.lang.String get_domId102() {
      return domId102;
    }
    private java.lang.String build_domId102() {
      // Creation section.
      domId102 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId102;
    }

    /**
     * Getter for contributorName called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_contributorName() {
      return build_contributorName();
    }
    private com.google.gwt.user.client.ui.Label build_contributorName() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label contributorName = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      contributorName.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.contributorName = contributorName;

      return contributorName;
    }

    /**
     * Getter for domId102Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId102Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId102Element() {
      return domId102Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId102Element() {
      // Creation section.
      domId102Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId102());
      // Setup section.


      return domId102Element;
    }

    /**
     * Getter for domId100Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId100Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId100Element() {
      return domId100Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId100Element() {
      // Creation section.
      domId100Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId100());
      // Setup section.


      return domId100Element;
    }

    /**
     * Getter for domId103 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId103;
    private java.lang.String get_domId103() {
      return domId103;
    }
    private java.lang.String build_domId103() {
      // Creation section.
      domId103 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId103;
    }

    /**
     * Getter for keyWordsPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_keyWordsPanel() {
      return build_keyWordsPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_keyWordsPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel keyWordsPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html46().asString());
      // Setup section.
      keyWordsPanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1557 = UiBinderUtil.attachToDom(keyWordsPanel.getElement());
      get_domId104Element().get();
      get_domId105Element().get();

      // Detach section.
      attachRecord1557.detach();
      keyWordsPanel.addAndReplaceElement(get_keywordsTitle(), get_domId104Element().get());
      keyWordsPanel.addAndReplaceElement(get_keywordsInfo(), get_domId105Element().get());

      owner.keyWordsPanel = keyWordsPanel;

      return keyWordsPanel;
    }

    /**
     * Getter for domId104 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId104;
    private java.lang.String get_domId104() {
      return domId104;
    }
    private java.lang.String build_domId104() {
      // Creation section.
      domId104 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId104;
    }

    /**
     * Getter for keywordsTitle called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_keywordsTitle() {
      return build_keywordsTitle();
    }
    private com.google.gwt.user.client.ui.Label build_keywordsTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label keywordsTitle = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      keywordsTitle.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.keywordsTitle = keywordsTitle;

      return keywordsTitle;
    }

    /**
     * Getter for domId104Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId104Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId104Element() {
      return domId104Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId104Element() {
      // Creation section.
      domId104Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId104());
      // Setup section.


      return domId104Element;
    }

    /**
     * Getter for domId105 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId105;
    private java.lang.String get_domId105() {
      return domId105;
    }
    private java.lang.String build_domId105() {
      // Creation section.
      domId105 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId105;
    }

    /**
     * Getter for keywordsInfo called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_keywordsInfo() {
      return build_keywordsInfo();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_keywordsInfo() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel keywordsInfo = new com.google.gwt.user.client.ui.HTMLPanel(template_html45().asString());
      // Setup section.
      keywordsInfo.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.keywordsInfo = keywordsInfo;

      return keywordsInfo;
    }

    /**
     * Getter for domId105Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId105Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId105Element() {
      return domId105Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId105Element() {
      // Creation section.
      domId105Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId105());
      // Setup section.


      return domId105Element;
    }

    /**
     * Getter for domId103Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId103Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId103Element() {
      return domId103Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId103Element() {
      // Creation section.
      domId103Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId103());
      // Setup section.


      return domId103Element;
    }

    /**
     * Getter for domId106 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId106;
    private java.lang.String get_domId106() {
      return domId106;
    }
    private java.lang.String build_domId106() {
      // Creation section.
      domId106 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId106;
    }

    /**
     * Getter for accessibilityPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_accessibilityPanel() {
      return build_accessibilityPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_accessibilityPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel accessibilityPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html47().asString());
      // Setup section.
      accessibilityPanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1558 = UiBinderUtil.attachToDom(accessibilityPanel.getElement());
      get_domId107Element().get();

      // Detach section.
      attachRecord1558.detach();
      accessibilityPanel.addAndReplaceElement(get_accesibilityLbl(), get_domId107Element().get());

      owner.accessibilityPanel = accessibilityPanel;

      return accessibilityPanel;
    }

    /**
     * Getter for domId107 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId107;
    private java.lang.String get_domId107() {
      return domId107;
    }
    private java.lang.String build_domId107() {
      // Creation section.
      domId107 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId107;
    }

    /**
     * Getter for accesibilityLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_accesibilityLbl() {
      return build_accesibilityLbl();
    }
    private com.google.gwt.user.client.ui.Label build_accesibilityLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label accesibilityLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      accesibilityLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitleboarder() + "");


      owner.accesibilityLbl = accesibilityLbl;

      return accesibilityLbl;
    }

    /**
     * Getter for domId107Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId107Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId107Element() {
      return domId107Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId107Element() {
      // Creation section.
      domId107Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId107());
      // Setup section.


      return domId107Element;
    }

    /**
     * Getter for domId106Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId106Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId106Element() {
      return domId106Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId106Element() {
      // Creation section.
      domId106Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId106());
      // Setup section.


      return domId106Element;
    }

    /**
     * Getter for domId108 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId108;
    private java.lang.String get_domId108() {
      return domId108;
    }
    private java.lang.String build_domId108() {
      // Creation section.
      domId108 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId108;
    }

    /**
     * Getter for mobileFriendlyPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_mobileFriendlyPanel() {
      return build_mobileFriendlyPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_mobileFriendlyPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel mobileFriendlyPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html48().asString());
      // Setup section.
      mobileFriendlyPanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1559 = UiBinderUtil.attachToDom(mobileFriendlyPanel.getElement());
      get_domId109Element().get();
      get_domId110Element().get();

      // Detach section.
      attachRecord1559.detach();
      mobileFriendlyPanel.addAndReplaceElement(get_mbFriendlyLbl(), get_domId109Element().get());
      mobileFriendlyPanel.addAndReplaceElement(get_mbFriendlyText(), get_domId110Element().get());

      owner.mobileFriendlyPanel = mobileFriendlyPanel;

      return mobileFriendlyPanel;
    }

    /**
     * Getter for domId109 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId109;
    private java.lang.String get_domId109() {
      return domId109;
    }
    private java.lang.String build_domId109() {
      // Creation section.
      domId109 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId109;
    }

    /**
     * Getter for mbFriendlyLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_mbFriendlyLbl() {
      return build_mbFriendlyLbl();
    }
    private com.google.gwt.user.client.ui.Label build_mbFriendlyLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label mbFriendlyLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      mbFriendlyLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.mbFriendlyLbl = mbFriendlyLbl;

      return mbFriendlyLbl;
    }

    /**
     * Getter for domId109Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId109Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId109Element() {
      return domId109Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId109Element() {
      // Creation section.
      domId109Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId109());
      // Setup section.


      return domId109Element;
    }

    /**
     * Getter for domId110 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId110;
    private java.lang.String get_domId110() {
      return domId110;
    }
    private java.lang.String build_domId110() {
      // Creation section.
      domId110 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId110;
    }

    /**
     * Getter for mbFriendlyText called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_mbFriendlyText() {
      return build_mbFriendlyText();
    }
    private com.google.gwt.user.client.ui.Label build_mbFriendlyText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label mbFriendlyText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      mbFriendlyText.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.mbFriendlyText = mbFriendlyText;

      return mbFriendlyText;
    }

    /**
     * Getter for domId110Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId110Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId110Element() {
      return domId110Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId110Element() {
      // Creation section.
      domId110Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId110());
      // Setup section.


      return domId110Element;
    }

    /**
     * Getter for domId108Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId108Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId108Element() {
      return domId108Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId108Element() {
      // Creation section.
      domId108Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId108());
      // Setup section.


      return domId108Element;
    }

    /**
     * Getter for domId111 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId111;
    private java.lang.String get_domId111() {
      return domId111;
    }
    private java.lang.String build_domId111() {
      // Creation section.
      domId111 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId111;
    }

    /**
     * Getter for accessModePanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_accessModePanel() {
      return build_accessModePanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_accessModePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel accessModePanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html50().asString());
      // Setup section.
      accessModePanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1560 = UiBinderUtil.attachToDom(accessModePanel.getElement());
      get_domId112Element().get();
      get_domId113Element().get();

      // Detach section.
      attachRecord1560.detach();
      accessModePanel.addAndReplaceElement(get_accessModelLbl(), get_domId112Element().get());
      accessModePanel.addAndReplaceElement(get_accessModeType(), get_domId113Element().get());

      owner.accessModePanel = accessModePanel;

      return accessModePanel;
    }

    /**
     * Getter for domId112 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId112;
    private java.lang.String get_domId112() {
      return domId112;
    }
    private java.lang.String build_domId112() {
      // Creation section.
      domId112 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId112;
    }

    /**
     * Getter for accessModelLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_accessModelLbl() {
      return build_accessModelLbl();
    }
    private com.google.gwt.user.client.ui.Label build_accessModelLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label accessModelLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      accessModelLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.accessModelLbl = accessModelLbl;

      return accessModelLbl;
    }

    /**
     * Getter for domId112Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId112Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId112Element() {
      return domId112Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId112Element() {
      // Creation section.
      domId112Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId112());
      // Setup section.


      return domId112Element;
    }

    /**
     * Getter for domId113 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId113;
    private java.lang.String get_domId113() {
      return domId113;
    }
    private java.lang.String build_domId113() {
      // Creation section.
      domId113 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId113;
    }

    /**
     * Getter for accessModeType called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_accessModeType() {
      return build_accessModeType();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_accessModeType() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel accessModeType = new com.google.gwt.user.client.ui.HTMLPanel(template_html49().asString());
      // Setup section.
      accessModeType.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.accessModeType = accessModeType;

      return accessModeType;
    }

    /**
     * Getter for domId113Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId113Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId113Element() {
      return domId113Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId113Element() {
      // Creation section.
      domId113Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId113());
      // Setup section.


      return domId113Element;
    }

    /**
     * Getter for domId111Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId111Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId111Element() {
      return domId111Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId111Element() {
      // Creation section.
      domId111Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId111());
      // Setup section.


      return domId111Element;
    }

    /**
     * Getter for domId114 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId114;
    private java.lang.String get_domId114() {
      return domId114;
    }
    private java.lang.String build_domId114() {
      // Creation section.
      domId114 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId114;
    }

    /**
     * Getter for mediaFeaturePanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_mediaFeaturePanel() {
      return build_mediaFeaturePanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_mediaFeaturePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel mediaFeaturePanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html52().asString());
      // Setup section.
      mediaFeaturePanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1561 = UiBinderUtil.attachToDom(mediaFeaturePanel.getElement());
      get_domId115Element().get();
      get_domId116Element().get();

      // Detach section.
      attachRecord1561.detach();
      mediaFeaturePanel.addAndReplaceElement(get_mediaFeatureLbl(), get_domId115Element().get());
      mediaFeaturePanel.addAndReplaceElement(get_mediaFeatureType(), get_domId116Element().get());

      owner.mediaFeaturePanel = mediaFeaturePanel;

      return mediaFeaturePanel;
    }

    /**
     * Getter for domId115 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId115;
    private java.lang.String get_domId115() {
      return domId115;
    }
    private java.lang.String build_domId115() {
      // Creation section.
      domId115 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId115;
    }

    /**
     * Getter for mediaFeatureLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_mediaFeatureLbl() {
      return build_mediaFeatureLbl();
    }
    private com.google.gwt.user.client.ui.Label build_mediaFeatureLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label mediaFeatureLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      mediaFeatureLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.mediaFeatureLbl = mediaFeatureLbl;

      return mediaFeatureLbl;
    }

    /**
     * Getter for domId115Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId115Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId115Element() {
      return domId115Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId115Element() {
      // Creation section.
      domId115Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId115());
      // Setup section.


      return domId115Element;
    }

    /**
     * Getter for domId116 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId116;
    private java.lang.String get_domId116() {
      return domId116;
    }
    private java.lang.String build_domId116() {
      // Creation section.
      domId116 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId116;
    }

    /**
     * Getter for mediaFeatureType called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_mediaFeatureType() {
      return build_mediaFeatureType();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_mediaFeatureType() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel mediaFeatureType = new com.google.gwt.user.client.ui.HTMLPanel(template_html51().asString());
      // Setup section.
      mediaFeatureType.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.mediaFeatureType = mediaFeatureType;

      return mediaFeatureType;
    }

    /**
     * Getter for domId116Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId116Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId116Element() {
      return domId116Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId116Element() {
      // Creation section.
      domId116Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId116());
      // Setup section.


      return domId116Element;
    }

    /**
     * Getter for domId114Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId114Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId114Element() {
      return domId114Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId114Element() {
      // Creation section.
      domId114Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId114());
      // Setup section.


      return domId114Element;
    }

    /**
     * Getter for domId117 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId117;
    private java.lang.String get_domId117() {
      return domId117;
    }
    private java.lang.String build_domId117() {
      // Creation section.
      domId117 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId117;
    }

    /**
     * Getter for controlPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_controlPanel() {
      return build_controlPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_controlPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel controlPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html53().asString());
      // Setup section.
      controlPanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1562 = UiBinderUtil.attachToDom(controlPanel.getElement());
      get_domId118Element().get();
      get_domId119Element().get();

      // Detach section.
      attachRecord1562.detach();
      controlPanel.addAndReplaceElement(get_controlLbl(), get_domId118Element().get());
      controlPanel.addAndReplaceElement(get_controlType(), get_domId119Element().get());

      owner.controlPanel = controlPanel;

      return controlPanel;
    }

    /**
     * Getter for domId118 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId118;
    private java.lang.String get_domId118() {
      return domId118;
    }
    private java.lang.String build_domId118() {
      // Creation section.
      domId118 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId118;
    }

    /**
     * Getter for controlLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_controlLbl() {
      return build_controlLbl();
    }
    private com.google.gwt.user.client.ui.Label build_controlLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label controlLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      controlLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.controlLbl = controlLbl;

      return controlLbl;
    }

    /**
     * Getter for domId118Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId118Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId118Element() {
      return domId118Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId118Element() {
      // Creation section.
      domId118Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId118());
      // Setup section.


      return domId118Element;
    }

    /**
     * Getter for domId119 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId119;
    private java.lang.String get_domId119() {
      return domId119;
    }
    private java.lang.String build_domId119() {
      // Creation section.
      domId119 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId119;
    }

    /**
     * Getter for controlType called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_controlType() {
      return build_controlType();
    }
    private com.google.gwt.user.client.ui.Label build_controlType() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label controlType = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      controlType.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.controlType = controlType;

      return controlType;
    }

    /**
     * Getter for domId119Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId119Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId119Element() {
      return domId119Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId119Element() {
      // Creation section.
      domId119Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId119());
      // Setup section.


      return domId119Element;
    }

    /**
     * Getter for domId117Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId117Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId117Element() {
      return domId117Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId117Element() {
      // Creation section.
      domId117Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId117());
      // Setup section.


      return domId117Element;
    }

    /**
     * Getter for domId120 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId120;
    private java.lang.String get_domId120() {
      return domId120;
    }
    private java.lang.String build_domId120() {
      // Creation section.
      domId120 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId120;
    }

    /**
     * Getter for accessHazardPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_accessHazardPanel() {
      return build_accessHazardPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_accessHazardPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel accessHazardPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html54().asString());
      // Setup section.
      accessHazardPanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1563 = UiBinderUtil.attachToDom(accessHazardPanel.getElement());
      get_domId121Element().get();
      get_domId122Element().get();

      // Detach section.
      attachRecord1563.detach();
      accessHazardPanel.addAndReplaceElement(get_acessHazardlLbl(), get_domId121Element().get());
      accessHazardPanel.addAndReplaceElement(get_acessHazardType(), get_domId122Element().get());

      owner.accessHazardPanel = accessHazardPanel;

      return accessHazardPanel;
    }

    /**
     * Getter for domId121 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId121;
    private java.lang.String get_domId121() {
      return domId121;
    }
    private java.lang.String build_domId121() {
      // Creation section.
      domId121 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId121;
    }

    /**
     * Getter for acessHazardlLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_acessHazardlLbl() {
      return build_acessHazardlLbl();
    }
    private com.google.gwt.user.client.ui.Label build_acessHazardlLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label acessHazardlLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      acessHazardlLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.acessHazardlLbl = acessHazardlLbl;

      return acessHazardlLbl;
    }

    /**
     * Getter for domId121Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId121Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId121Element() {
      return domId121Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId121Element() {
      // Creation section.
      domId121Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId121());
      // Setup section.


      return domId121Element;
    }

    /**
     * Getter for domId122 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId122;
    private java.lang.String get_domId122() {
      return domId122;
    }
    private java.lang.String build_domId122() {
      // Creation section.
      domId122 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId122;
    }

    /**
     * Getter for acessHazardType called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_acessHazardType() {
      return build_acessHazardType();
    }
    private com.google.gwt.user.client.ui.Label build_acessHazardType() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label acessHazardType = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      acessHazardType.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.acessHazardType = acessHazardType;

      return acessHazardType;
    }

    /**
     * Getter for domId122Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId122Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId122Element() {
      return domId122Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId122Element() {
      // Creation section.
      domId122Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId122());
      // Setup section.


      return domId122Element;
    }

    /**
     * Getter for domId120Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId120Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId120Element() {
      return domId120Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId120Element() {
      // Creation section.
      domId120Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId120());
      // Setup section.


      return domId120Element;
    }

    /**
     * Getter for domId123 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId123;
    private java.lang.String get_domId123() {
      return domId123;
    }
    private java.lang.String build_domId123() {
      // Creation section.
      domId123 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId123;
    }

    /**
     * Getter for hasAdaptationPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_hasAdaptationPanel() {
      return build_hasAdaptationPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_hasAdaptationPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel hasAdaptationPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html55().asString());
      // Setup section.
      hasAdaptationPanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1564 = UiBinderUtil.attachToDom(hasAdaptationPanel.getElement());
      get_domId124Element().get();
      get_domId125Element().get();

      // Detach section.
      attachRecord1564.detach();
      hasAdaptationPanel.addAndReplaceElement(get_hasAdaptationLbl(), get_domId124Element().get());
      hasAdaptationPanel.addAndReplaceElement(get_hasAdaptationType(), get_domId125Element().get());

      owner.hasAdaptationPanel = hasAdaptationPanel;

      return hasAdaptationPanel;
    }

    /**
     * Getter for domId124 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId124;
    private java.lang.String get_domId124() {
      return domId124;
    }
    private java.lang.String build_domId124() {
      // Creation section.
      domId124 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId124;
    }

    /**
     * Getter for hasAdaptationLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_hasAdaptationLbl() {
      return build_hasAdaptationLbl();
    }
    private com.google.gwt.user.client.ui.Label build_hasAdaptationLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label hasAdaptationLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      hasAdaptationLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.hasAdaptationLbl = hasAdaptationLbl;

      return hasAdaptationLbl;
    }

    /**
     * Getter for domId124Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId124Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId124Element() {
      return domId124Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId124Element() {
      // Creation section.
      domId124Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId124());
      // Setup section.


      return domId124Element;
    }

    /**
     * Getter for domId125 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId125;
    private java.lang.String get_domId125() {
      return domId125;
    }
    private java.lang.String build_domId125() {
      // Creation section.
      domId125 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId125;
    }

    /**
     * Getter for hasAdaptationType called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_hasAdaptationType() {
      return build_hasAdaptationType();
    }
    private com.google.gwt.user.client.ui.Label build_hasAdaptationType() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label hasAdaptationType = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      hasAdaptationType.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.hasAdaptationType = hasAdaptationType;

      return hasAdaptationType;
    }

    /**
     * Getter for domId125Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId125Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId125Element() {
      return domId125Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId125Element() {
      // Creation section.
      domId125Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId125());
      // Setup section.


      return domId125Element;
    }

    /**
     * Getter for domId123Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId123Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId123Element() {
      return domId123Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId123Element() {
      // Creation section.
      domId123Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId123());
      // Setup section.


      return domId123Element;
    }

    /**
     * Getter for domId126 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId126;
    private java.lang.String get_domId126() {
      return domId126;
    }
    private java.lang.String build_domId126() {
      // Creation section.
      domId126 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId126;
    }

    /**
     * Getter for isAdaptationPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_isAdaptationPanel() {
      return build_isAdaptationPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_isAdaptationPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel isAdaptationPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html56().asString());
      // Setup section.
      isAdaptationPanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1565 = UiBinderUtil.attachToDom(isAdaptationPanel.getElement());
      get_domId127Element().get();
      get_domId128Element().get();

      // Detach section.
      attachRecord1565.detach();
      isAdaptationPanel.addAndReplaceElement(get_isAdaptationLbl(), get_domId127Element().get());
      isAdaptationPanel.addAndReplaceElement(get_isAdaptationType(), get_domId128Element().get());

      owner.isAdaptationPanel = isAdaptationPanel;

      return isAdaptationPanel;
    }

    /**
     * Getter for domId127 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId127;
    private java.lang.String get_domId127() {
      return domId127;
    }
    private java.lang.String build_domId127() {
      // Creation section.
      domId127 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId127;
    }

    /**
     * Getter for isAdaptationLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_isAdaptationLbl() {
      return build_isAdaptationLbl();
    }
    private com.google.gwt.user.client.ui.Label build_isAdaptationLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label isAdaptationLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      isAdaptationLbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.isAdaptationLbl = isAdaptationLbl;

      return isAdaptationLbl;
    }

    /**
     * Getter for domId127Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId127Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId127Element() {
      return domId127Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId127Element() {
      // Creation section.
      domId127Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId127());
      // Setup section.


      return domId127Element;
    }

    /**
     * Getter for domId128 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId128;
    private java.lang.String get_domId128() {
      return domId128;
    }
    private java.lang.String build_domId128() {
      // Creation section.
      domId128 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId128;
    }

    /**
     * Getter for isAdaptationType called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_isAdaptationType() {
      return build_isAdaptationType();
    }
    private com.google.gwt.user.client.ui.Label build_isAdaptationType() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label isAdaptationType = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      isAdaptationType.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.isAdaptationType = isAdaptationType;

      return isAdaptationType;
    }

    /**
     * Getter for domId128Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId128Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId128Element() {
      return domId128Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId128Element() {
      // Creation section.
      domId128Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId128());
      // Setup section.


      return domId128Element;
    }

    /**
     * Getter for domId126Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId126Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId126Element() {
      return domId126Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId126Element() {
      // Creation section.
      domId126Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId126());
      // Setup section.


      return domId126Element;
    }

    /**
     * Getter for domId129 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId129;
    private java.lang.String get_domId129() {
      return domId129;
    }
    private java.lang.String build_domId129() {
      // Creation section.
      domId129 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId129;
    }

    /**
     * Getter for accessibilityAPIPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_accessibilityAPIPanel() {
      return build_accessibilityAPIPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_accessibilityAPIPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel accessibilityAPIPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html58().asString());
      // Setup section.
      accessibilityAPIPanel.setStyleName("" + get_playerStyle().resourceInfoPublishContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1566 = UiBinderUtil.attachToDom(accessibilityAPIPanel.getElement());
      get_domId130Element().get();
      get_domId131Element().get();

      // Detach section.
      attachRecord1566.detach();
      accessibilityAPIPanel.addAndReplaceElement(get_accessibilityAPILbl(), get_domId130Element().get());
      accessibilityAPIPanel.addAndReplaceElement(get_accessibilityAPIType(), get_domId131Element().get());

      owner.accessibilityAPIPanel = accessibilityAPIPanel;

      return accessibilityAPIPanel;
    }

    /**
     * Getter for domId130 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId130;
    private java.lang.String get_domId130() {
      return domId130;
    }
    private java.lang.String build_domId130() {
      // Creation section.
      domId130 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId130;
    }

    /**
     * Getter for accessibilityAPILbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_accessibilityAPILbl() {
      return build_accessibilityAPILbl();
    }
    private com.google.gwt.user.client.ui.Label build_accessibilityAPILbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label accessibilityAPILbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      accessibilityAPILbl.setStyleName("" + get_playerStyle().resourceInfoMoreTitle() + "");


      owner.accessibilityAPILbl = accessibilityAPILbl;

      return accessibilityAPILbl;
    }

    /**
     * Getter for domId130Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId130Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId130Element() {
      return domId130Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId130Element() {
      // Creation section.
      domId130Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId130());
      // Setup section.


      return domId130Element;
    }

    /**
     * Getter for domId131 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId131;
    private java.lang.String get_domId131() {
      return domId131;
    }
    private java.lang.String build_domId131() {
      // Creation section.
      domId131 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId131;
    }

    /**
     * Getter for accessibilityAPIType called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_accessibilityAPIType() {
      return build_accessibilityAPIType();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_accessibilityAPIType() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel accessibilityAPIType = new com.google.gwt.user.client.ui.HTMLPanel(template_html57().asString());
      // Setup section.
      accessibilityAPIType.setStyleName("" + get_playerStyle().resourceInfoTitle() + "");


      owner.accessibilityAPIType = accessibilityAPIType;

      return accessibilityAPIType;
    }

    /**
     * Getter for domId131Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId131Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId131Element() {
      return domId131Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId131Element() {
      // Creation section.
      domId131Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId131());
      // Setup section.


      return domId131Element;
    }

    /**
     * Getter for domId129Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId129Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId129Element() {
      return domId129Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId129Element() {
      // Creation section.
      domId129Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId129());
      // Setup section.


      return domId129Element;
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
     * Getter for f_HTMLPanel13 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel13() {
      return build_f_HTMLPanel13();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel13() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel13 = new com.google.gwt.user.client.ui.HTMLPanel(template_html63().asString());
      // Setup section.
      f_HTMLPanel13.setStyleName("" + get_playerStyle().resourceInfoCollectionsWrapper() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1567 = UiBinderUtil.attachToDom(f_HTMLPanel13.getElement());
      get_domId132Element().get();
      get_domId133Element().get();
      get_domId134Element().get();

      // Detach section.
      attachRecord1567.detach();
      f_HTMLPanel13.addAndReplaceElement(get_collectionsText(), get_domId132Element().get());
      f_HTMLPanel13.addAndReplaceElement(get_collectionsCount(), get_domId133Element().get());
      f_HTMLPanel13.addAndReplaceElement(get_scrollPanel(), get_domId134Element().get());

      return f_HTMLPanel13;
    }

    /**
     * Getter for domId132 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId132;
    private java.lang.String get_domId132() {
      return domId132;
    }
    private java.lang.String build_domId132() {
      // Creation section.
      domId132 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId132;
    }

    /**
     * Getter for collectionsText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_collectionsText() {
      return build_collectionsText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_collectionsText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel collectionsText = new com.google.gwt.user.client.ui.HTMLPanel(template_html61().asString());
      // Setup section.
      collectionsText.setStyleName("" + get_playerStyle().resourceInfoCollectionsCount() + "");


      owner.collectionsText = collectionsText;

      return collectionsText;
    }

    /**
     * Getter for domId132Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId132Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId132Element() {
      return domId132Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId132Element() {
      // Creation section.
      domId132Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId132());
      // Setup section.


      return domId132Element;
    }

    /**
     * Getter for domId133 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId133;
    private java.lang.String get_domId133() {
      return domId133;
    }
    private java.lang.String build_domId133() {
      // Creation section.
      domId133 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId133;
    }

    /**
     * Getter for collectionsCount called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_collectionsCount() {
      return build_collectionsCount();
    }
    private com.google.gwt.user.client.ui.Label build_collectionsCount() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label collectionsCount = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      collectionsCount.setStyleName("" + get_playerStyle().resourceInfoCollectionsCount() + "");


      owner.collectionsCount = collectionsCount;

      return collectionsCount;
    }

    /**
     * Getter for domId133Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId133Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId133Element() {
      return domId133Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId133Element() {
      // Creation section.
      domId133Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId133());
      // Setup section.


      return domId133Element;
    }

    /**
     * Getter for domId134 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId134;
    private java.lang.String get_domId134() {
      return domId134;
    }
    private java.lang.String build_domId134() {
      // Creation section.
      domId134 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId134;
    }

    /**
     * Getter for scrollPanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.ScrollPanel get_scrollPanel() {
      return build_scrollPanel();
    }
    private com.google.gwt.user.client.ui.ScrollPanel build_scrollPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.ScrollPanel scrollPanel = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
      // Setup section.
      scrollPanel.add(get_reosourceReleatedCollections());
      scrollPanel.setStyleName("" + get_playerStyle().playerResourcesRightSection() + "");
      scrollPanel.addScrollHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.scrollPanel = scrollPanel;

      return scrollPanel;
    }

    /**
     * Getter for reosourceReleatedCollections called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_reosourceReleatedCollections() {
      return build_reosourceReleatedCollections();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_reosourceReleatedCollections() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel reosourceReleatedCollections = new com.google.gwt.user.client.ui.HTMLPanel(template_html62().asString());
      // Setup section.


      owner.reosourceReleatedCollections = reosourceReleatedCollections;

      return reosourceReleatedCollections;
    }

    /**
     * Getter for domId134Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId134Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId134Element() {
      return domId134Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId134Element() {
      // Creation section.
      domId134Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId134());
      // Setup section.


      return domId134Element;
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
     * Getter for domId135 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
     */
    private java.lang.String domId135;
    private java.lang.String get_domId135() {
      return domId135;
    }
    private java.lang.String build_domId135() {
      // Creation section.
      domId135 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId135;
    }

    /**
     * Getter for hideButton called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_hideButton() {
      return build_hideButton();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_hideButton() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel hideButton = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html64().asString());
      // Setup section.
      hideButton.setStyleName("" + get_playerStyle().resourceInfoBottomImageContainer() + "");
      hideButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1568 = UiBinderUtil.attachToDom(hideButton.getElement());
      get_domId136Element().get();
      get_domId137Element().get();

      // Detach section.
      attachRecord1568.detach();
      hideButton.addAndReplaceElement(get_f_Label14(), get_domId136Element().get());
      hideButton.addAndReplaceElement(get_hideText(), get_domId137Element().get());

      owner.hideButton = hideButton;

      return hideButton;
    }

    /**
     * Getter for domId136 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId136;
    private java.lang.String get_domId136() {
      return domId136;
    }
    private java.lang.String build_domId136() {
      // Creation section.
      domId136 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId136;
    }

    /**
     * Getter for f_Label14 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label14() {
      return build_f_Label14();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label14() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label14 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label14.setStyleName("" + get_playerStyle().resourceInfoHideImage() + "");


      return f_Label14;
    }

    /**
     * Getter for domId136Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId136Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId136Element() {
      return domId136Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId136Element() {
      // Creation section.
      domId136Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId136());
      // Setup section.


      return domId136Element;
    }

    /**
     * Getter for domId137 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId137;
    private java.lang.String get_domId137() {
      return domId137;
    }
    private java.lang.String build_domId137() {
      // Creation section.
      domId137 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId137;
    }

    /**
     * Getter for hideText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_hideText() {
      return build_hideText();
    }
    private com.google.gwt.user.client.ui.Label build_hideText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label hideText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      hideText.setStyleName("" + get_playerStyle().resourceInfoHideText() + "");


      owner.hideText = hideText;

      return hideText;
    }

    /**
     * Getter for domId137Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId137Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId137Element() {
      return domId137Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId137Element() {
      // Creation section.
      domId137Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId137());
      // Setup section.


      return domId137Element;
    }

    /**
     * Getter for domId135Element called 2 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId135Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId135Element() {
      return domId135Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId135Element() {
      // Creation section.
      domId135Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId135());
      // Setup section.


      return domId135Element;
    }
  }
}
