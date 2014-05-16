package org.ednovo.gooru.client.mvp.settings;

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

public class UserSettingsView_UserSettingsViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.settings.UserSettingsView>, org.ednovo.gooru.client.mvp.settings.UserSettingsView.UserSettingsViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html2(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html3(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html4(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html5(String arg0, String arg1, String arg2);
     
    @Template("")
    SafeHtml html6();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html7(String arg0, String arg1);
     
    @Template("")
    SafeHtml html8();
     
    @Template("")
    SafeHtml html9();
     
    @Template("")
    SafeHtml html10();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html11(String arg0);
     
    @Template("")
    SafeHtml html12();
     
    @Template("")
    SafeHtml html13();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html14(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html15(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span> <span id='{5}'></span> <span id='{6}'></span> <span id='{7}'></span> <span id='{8}'></span> <span id='{9}'></span>")
    SafeHtml html16(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9);
     
    @Template("<span id='{0}'></span>  <span id='{1}'></span>")
    SafeHtml html17(String arg0, String arg1);
     
    @Template("")
    SafeHtml html18();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html19(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html20(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html21(String arg0, String arg1, String arg2);
     
    @Template("")
    SafeHtml html22();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>  <span id='{2}'></span>")
    SafeHtml html23(String arg0, String arg1, String arg2);
     
    @Template("")
    SafeHtml html24();
     
    @Template("?")
    SafeHtml html25();
     
    @Template("")
    SafeHtml html26();
     
    @Template("")
    SafeHtml html27();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html28(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html29(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html30(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>  <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html31(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html32(String arg0, String arg1);
     
    @Template("")
    SafeHtml html33();
     
    @Template("<span id='{0}'></span>  <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html34(String arg0, String arg1, String arg2);
     
    @Template("")
    SafeHtml html35();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html36(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html37(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html38(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html39(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html40(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html41(String arg0, String arg1, String arg2, String arg3);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html42(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span>")
    SafeHtml html43(String arg0, String arg1, String arg2, String arg3, String arg4);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html44(String arg0, String arg1);
     
    @Template("")
    SafeHtml html45();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html46(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html47(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html48(String arg0, String arg1, String arg2);
     
    @Template("")
    SafeHtml html49();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>  <span id='{2}'></span>")
    SafeHtml html50(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html51(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html52(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html53(String arg0, String arg1);
     
    @Template("")
    SafeHtml html54();
     
    @Template("")
    SafeHtml html55();
     
    @Template("<span id='{0}'></span>   <span id='{1}'></span>")
    SafeHtml html56(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html57(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html58(String arg0, String arg1);
     
    @Template("")
    SafeHtml html59();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html60(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html61(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html62(String arg0, String arg1, String arg2);
     
    @Template("")
    SafeHtml html63();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>  <span id='{2}'></span>")
    SafeHtml html64(String arg0, String arg1, String arg2);
     
    @Template("")
    SafeHtml html65();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html66(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html67(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html68(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html69(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html70(String arg0, String arg1);
     
    @Template("")
    SafeHtml html71();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html72(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html73(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html74(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html75(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>  <span id='{3}'></span>")
    SafeHtml html76(String arg0, String arg1, String arg2, String arg3);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html77(String arg0);
     
    @Template("")
    SafeHtml html78();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html79(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html80(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>  <span id='{4}'></span>")
    SafeHtml html81(String arg0, String arg1, String arg2, String arg3, String arg4);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html82(String arg0);
     
    @Template("<span id='{0}'></span>  <span id='{1}'></span>")
    SafeHtml html83(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html84(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html85(String arg0, String arg1);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.settings.UserSettingsView owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.settings.UserSettingsView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.OnClickSaveButton(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.OnClickCancelSettingpage(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickEmailSaveButton(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickEmailCancelButton(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickEduInfoSaveButton(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickEduInfoCancelButton(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onForgotPwdClicked(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickOfstandardsEditButton(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames9 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickOfstandardsSaveButton(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames10 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickOfstandardsCancelButton(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.settings.UserSettingsView owner) {
      this.owner = owner;
      build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();  // more than one getter call detected. Type: GENERATED_BUNDLE, precedence: 1
      build_RightPanel();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_Settings();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_ccb();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_domId54();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 13
      build_domId51();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 12
      build_domId52();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 12
      build_domId53();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 12
      build_domId39();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 11
      build_domId40();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 11
      build_domId49();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 11
      build_domId50();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 11
      build_domId67();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 11
      build_domId68();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 11
      build_domId70();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 11
      build_domId71();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 11
      build_domId73();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 11
      build_domId74();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 11
      build_domId76();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 11
      build_domId77();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 11
      build_domId86();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 11
      build_domId87();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 11
      build_domId110();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 11
      build_domId111();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 11
      build_domId118();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 11
      build_domId119();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 11
      build_domId121();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 11
      build_domId122();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 11
      build_domId123();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 11
      build_domId132();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 11
      build_domId133();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 11
      build_domId38();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 10
      build_domId46();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 10
      build_domId47();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 10
      build_domId48();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 10
      build_domId64();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 10
      build_domId66();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 10
      build_domId69();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 10
      build_domId72();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 10
      build_domId75();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 10
      build_domId85();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 10
      build_domId109();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 10
      build_domId131();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 10
      build_domId35();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId36();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId37();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId44();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId45();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId57();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId58();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId59();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId62();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId63();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId65();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId82();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId83();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId84();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId91();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId92();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId93();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId106();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId107();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId108();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId117();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId120();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId128();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId129();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId130();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId136();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId137();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId138();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId139();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId33();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId34();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId41();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId43();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId55();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId56();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId60();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId61();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId80();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId81();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId88();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId90();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId96();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId97();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId99();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId100();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId101();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId104();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId105();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId112();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId114();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId115();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId116();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId126();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId127();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId135();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId141();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId142();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId15();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId16();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId21();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId25();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId26();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId28();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId32();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId42();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId79();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId89();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId95();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId98();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId103();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId113();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId125();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId134();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId140();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId14();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId17();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId18();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId19();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId20();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId22();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId23();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId24();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId27();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId31();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId78();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId94();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId102();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId124();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId30();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId29();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId143();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId54Element();  // more than one getter call detected. Type: DEFAULT, precedence: 13
      build_domId51Element();  // more than one getter call detected. Type: DEFAULT, precedence: 12
      build_domId52Element();  // more than one getter call detected. Type: DEFAULT, precedence: 12
      build_domId53Element();  // more than one getter call detected. Type: DEFAULT, precedence: 12
      build_domId39Element();  // more than one getter call detected. Type: DEFAULT, precedence: 11
      build_domId40Element();  // more than one getter call detected. Type: DEFAULT, precedence: 11
      build_domId49Element();  // more than one getter call detected. Type: DEFAULT, precedence: 11
      build_domId50Element();  // more than one getter call detected. Type: DEFAULT, precedence: 11
      build_domId67Element();  // more than one getter call detected. Type: DEFAULT, precedence: 11
      build_domId68Element();  // more than one getter call detected. Type: DEFAULT, precedence: 11
      build_domId70Element();  // more than one getter call detected. Type: DEFAULT, precedence: 11
      build_domId71Element();  // more than one getter call detected. Type: DEFAULT, precedence: 11
      build_domId73Element();  // more than one getter call detected. Type: DEFAULT, precedence: 11
      build_domId74Element();  // more than one getter call detected. Type: DEFAULT, precedence: 11
      build_domId76Element();  // more than one getter call detected. Type: DEFAULT, precedence: 11
      build_domId77Element();  // more than one getter call detected. Type: DEFAULT, precedence: 11
      build_domId86Element();  // more than one getter call detected. Type: DEFAULT, precedence: 11
      build_domId87Element();  // more than one getter call detected. Type: DEFAULT, precedence: 11
      build_domId110Element();  // more than one getter call detected. Type: DEFAULT, precedence: 11
      build_domId111Element();  // more than one getter call detected. Type: DEFAULT, precedence: 11
      build_domId118Element();  // more than one getter call detected. Type: DEFAULT, precedence: 11
      build_domId119Element();  // more than one getter call detected. Type: DEFAULT, precedence: 11
      build_domId121Element();  // more than one getter call detected. Type: DEFAULT, precedence: 11
      build_domId122Element();  // more than one getter call detected. Type: DEFAULT, precedence: 11
      build_domId123Element();  // more than one getter call detected. Type: DEFAULT, precedence: 11
      build_domId132Element();  // more than one getter call detected. Type: DEFAULT, precedence: 11
      build_domId133Element();  // more than one getter call detected. Type: DEFAULT, precedence: 11
      build_domId38Element();  // more than one getter call detected. Type: DEFAULT, precedence: 10
      build_domId46Element();  // more than one getter call detected. Type: DEFAULT, precedence: 10
      build_domId47Element();  // more than one getter call detected. Type: DEFAULT, precedence: 10
      build_domId48Element();  // more than one getter call detected. Type: DEFAULT, precedence: 10
      build_domId64Element();  // more than one getter call detected. Type: DEFAULT, precedence: 10
      build_domId66Element();  // more than one getter call detected. Type: DEFAULT, precedence: 10
      build_domId69Element();  // more than one getter call detected. Type: DEFAULT, precedence: 10
      build_domId72Element();  // more than one getter call detected. Type: DEFAULT, precedence: 10
      build_domId75Element();  // more than one getter call detected. Type: DEFAULT, precedence: 10
      build_domId85Element();  // more than one getter call detected. Type: DEFAULT, precedence: 10
      build_domId109Element();  // more than one getter call detected. Type: DEFAULT, precedence: 10
      build_domId131Element();  // more than one getter call detected. Type: DEFAULT, precedence: 10
      build_domId35Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId36Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId37Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId44Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId45Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId57Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId58Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId59Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId62Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId63Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId65Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId82Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId83Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId84Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId91Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId92Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId93Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId106Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId107Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId108Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId117Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId120Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId128Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId129Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId130Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId136Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId137Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId138Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId139Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId33Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId34Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId41Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId43Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId55Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId56Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId60Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId61Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId80Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId81Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId88Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId90Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId96Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId97Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId99Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId100Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId101Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId104Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId105Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId112Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId114Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId115Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId116Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId126Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId127Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId135Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId141Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId142Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId15Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId16Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId21Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId25Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId26Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId28Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId32Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId42Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId79Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId89Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId95Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId98Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId103Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId113Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId125Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId134Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId140Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId14Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId17Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId18Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId19Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId20Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId22Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId23Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId24Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId27Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId31Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId78Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId94Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId102Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId124Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId30Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId29Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId143Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2(get_domId2());
    }
    SafeHtml template_html3() {
      return template.html3(get_domId7(), get_domId8());
    }
    SafeHtml template_html4() {
      return template.html4(get_domId11());
    }
    SafeHtml template_html5() {
      return template.html5(get_domId6(), get_domId9(), get_domId10());
    }
    SafeHtml template_html6() {
      return template.html6();
    }
    SafeHtml template_html7() {
      return template.html7(get_domId15(), get_domId16());
    }
    SafeHtml template_html8() {
      return template.html8();
    }
    SafeHtml template_html9() {
      return template.html9();
    }
    SafeHtml template_html10() {
      return template.html10();
    }
    SafeHtml template_html11() {
      return template.html11(get_domId21());
    }
    SafeHtml template_html12() {
      return template.html12();
    }
    SafeHtml template_html13() {
      return template.html13();
    }
    SafeHtml template_html14() {
      return template.html14(get_domId25(), get_domId26());
    }
    SafeHtml template_html15() {
      return template.html15(get_domId28());
    }
    SafeHtml template_html16() {
      return template.html16(get_domId13(), get_domId14(), get_domId17(), get_domId18(), get_domId19(), get_domId20(), get_domId22(), get_domId23(), get_domId24(), get_domId27());
    }
    SafeHtml template_html17() {
      return template.html17(get_domId5(), get_domId12());
    }
    SafeHtml template_html18() {
      return template.html18();
    }
    SafeHtml template_html19() {
      return template.html19(get_domId39(), get_domId40());
    }
    SafeHtml template_html20() {
      return template.html20(get_domId38());
    }
    SafeHtml template_html21() {
      return template.html21(get_domId35(), get_domId36(), get_domId37());
    }
    SafeHtml template_html22() {
      return template.html22();
    }
    SafeHtml template_html23() {
      return template.html23(get_domId33(), get_domId34(), get_domId41());
    }
    SafeHtml template_html24() {
      return template.html24();
    }
    SafeHtml template_html25() {
      return template.html25();
    }
    SafeHtml template_html26() {
      return template.html26();
    }
    SafeHtml template_html27() {
      return template.html27();
    }
    SafeHtml template_html28() {
      return template.html28(get_domId54());
    }
    SafeHtml template_html29() {
      return template.html29(get_domId51(), get_domId52(), get_domId53());
    }
    SafeHtml template_html30() {
      return template.html30(get_domId49(), get_domId50());
    }
    SafeHtml template_html31() {
      return template.html31(get_domId46(), get_domId47(), get_domId48());
    }
    SafeHtml template_html32() {
      return template.html32(get_domId44(), get_domId45());
    }
    SafeHtml template_html33() {
      return template.html33();
    }
    SafeHtml template_html34() {
      return template.html34(get_domId57(), get_domId58(), get_domId59());
    }
    SafeHtml template_html35() {
      return template.html35();
    }
    SafeHtml template_html36() {
      return template.html36(get_domId64());
    }
    SafeHtml template_html37() {
      return template.html37(get_domId67(), get_domId68());
    }
    SafeHtml template_html38() {
      return template.html38(get_domId70(), get_domId71());
    }
    SafeHtml template_html39() {
      return template.html39(get_domId73(), get_domId74());
    }
    SafeHtml template_html40() {
      return template.html40(get_domId76(), get_domId77());
    }
    SafeHtml template_html41() {
      return template.html41(get_domId66(), get_domId69(), get_domId72(), get_domId75());
    }
    SafeHtml template_html42() {
      return template.html42(get_domId62(), get_domId63(), get_domId65());
    }
    SafeHtml template_html43() {
      return template.html43(get_domId43(), get_domId55(), get_domId56(), get_domId60(), get_domId61());
    }
    SafeHtml template_html44() {
      return template.html44(get_domId32(), get_domId42());
    }
    SafeHtml template_html45() {
      return template.html45();
    }
    SafeHtml template_html46() {
      return template.html46(get_domId86(), get_domId87());
    }
    SafeHtml template_html47() {
      return template.html47(get_domId85());
    }
    SafeHtml template_html48() {
      return template.html48(get_domId82(), get_domId83(), get_domId84());
    }
    SafeHtml template_html49() {
      return template.html49();
    }
    SafeHtml template_html50() {
      return template.html50(get_domId80(), get_domId81(), get_domId88());
    }
    SafeHtml template_html51() {
      return template.html51(get_domId91(), get_domId92(), get_domId93());
    }
    SafeHtml template_html52() {
      return template.html52(get_domId90());
    }
    SafeHtml template_html53() {
      return template.html53(get_domId79(), get_domId89());
    }
    SafeHtml template_html54() {
      return template.html54();
    }
    SafeHtml template_html55() {
      return template.html55();
    }
    SafeHtml template_html56() {
      return template.html56(get_domId96(), get_domId97());
    }
    SafeHtml template_html57() {
      return template.html57(get_domId99(), get_domId100(), get_domId101());
    }
    SafeHtml template_html58() {
      return template.html58(get_domId95(), get_domId98());
    }
    SafeHtml template_html59() {
      return template.html59();
    }
    SafeHtml template_html60() {
      return template.html60(get_domId110(), get_domId111());
    }
    SafeHtml template_html61() {
      return template.html61(get_domId109());
    }
    SafeHtml template_html62() {
      return template.html62(get_domId106(), get_domId107(), get_domId108());
    }
    SafeHtml template_html63() {
      return template.html63();
    }
    SafeHtml template_html64() {
      return template.html64(get_domId104(), get_domId105(), get_domId112());
    }
    SafeHtml template_html65() {
      return template.html65();
    }
    SafeHtml template_html66() {
      return template.html66(get_domId118(), get_domId119());
    }
    SafeHtml template_html67() {
      return template.html67(get_domId121(), get_domId122(), get_domId123());
    }
    SafeHtml template_html68() {
      return template.html68(get_domId117(), get_domId120());
    }
    SafeHtml template_html69() {
      return template.html69(get_domId114(), get_domId115(), get_domId116());
    }
    SafeHtml template_html70() {
      return template.html70(get_domId103(), get_domId113());
    }
    SafeHtml template_html71() {
      return template.html71();
    }
    SafeHtml template_html72() {
      return template.html72(get_domId132(), get_domId133());
    }
    SafeHtml template_html73() {
      return template.html73(get_domId131());
    }
    SafeHtml template_html74() {
      return template.html74(get_domId128(), get_domId129(), get_domId130());
    }
    SafeHtml template_html75() {
      return template.html75(get_domId126(), get_domId127());
    }
    SafeHtml template_html76() {
      return template.html76(get_domId136(), get_domId137(), get_domId138(), get_domId139());
    }
    SafeHtml template_html77() {
      return template.html77(get_domId135());
    }
    SafeHtml template_html78() {
      return template.html78();
    }
    SafeHtml template_html79() {
      return template.html79(get_domId141(), get_domId142());
    }
    SafeHtml template_html80() {
      return template.html80(get_domId125(), get_domId134(), get_domId140());
    }
    SafeHtml template_html81() {
      return template.html81(get_domId31(), get_domId78(), get_domId94(), get_domId102(), get_domId124());
    }
    SafeHtml template_html82() {
      return template.html82(get_domId30());
    }
    SafeHtml template_html83() {
      return template.html83(get_domId4(), get_domId29());
    }
    SafeHtml template_html84() {
      return template.html84(get_domId1(), get_domId3());
    }
    SafeHtml template_html85() {
      return template.html85(get_domId0(), get_domId143());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 2 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.settings.UserSettingsView_UserSettingsViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    private org.ednovo.gooru.client.mvp.settings.UserSettingsView_UserSettingsViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }
    private org.ednovo.gooru.client.mvp.settings.UserSettingsView_UserSettingsViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.settings.UserSettingsView_UserSettingsViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.settings.UserSettingsView_UserSettingsViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for RightPanel called 1 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.settings.UserSettingsView_UserSettingsViewUiBinderImpl_GenCss_RightPanel get_RightPanel() {
      return build_RightPanel();
    }
    private org.ednovo.gooru.client.mvp.settings.UserSettingsView_UserSettingsViewUiBinderImpl_GenCss_RightPanel build_RightPanel() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.settings.UserSettingsView_UserSettingsViewUiBinderImpl_GenCss_RightPanel RightPanel = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().RightPanel();
      // Setup section.
      RightPanel.ensureInjected();


      return RightPanel;
    }

    /**
     * Getter for Settings called 135 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.settings.UserSettingsView_UserSettingsViewUiBinderImpl_GenCss_Settings Settings;
    private org.ednovo.gooru.client.mvp.settings.UserSettingsView_UserSettingsViewUiBinderImpl_GenCss_Settings get_Settings() {
      return Settings;
    }
    private org.ednovo.gooru.client.mvp.settings.UserSettingsView_UserSettingsViewUiBinderImpl_GenCss_Settings build_Settings() {
      // Creation section.
      Settings = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().Settings();
      // Setup section.
      Settings.ensureInjected();


      owner.Settings = Settings;

      return Settings;
    }

    /**
     * Getter for res called 0 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.ShelfCBundle get_res() {
      return build_res();
    }
    private org.ednovo.gooru.client.mvp.shelf.ShelfCBundle build_res() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.ShelfCBundle res = (org.ednovo.gooru.client.mvp.shelf.ShelfCBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.ShelfCBundle.class);
      // Setup section.


      return res;
    }

    /**
     * Getter for ccb called 4 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle ccb;
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle get_ccb() {
      return ccb;
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle build_ccb() {
      // Creation section.
      ccb = (org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle.class);
      // Setup section.


      return ccb;
    }

    /**
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html85().asString());
      // Setup section.
      f_HTMLPanel1.setStyleName("" + get_Settings().settingWrapper() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1275 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId0Element().get();
      get_domId143Element().get();

      // Detach section.
      attachRecord1275.detach();
      f_HTMLPanel1.addAndReplaceElement(get_f_HTMLPanel2(), get_domId0Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_f_FooterUc40(), get_domId143Element().get());

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
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html84().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_RightPanel().settingContentWrapperNew() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1276 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_domId1Element().get();
      get_domId3Element().get();

      // Detach section.
      attachRecord1276.detach();
      f_HTMLPanel2.addAndReplaceElement(get_f_HTMLPanel3(), get_domId1Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_f_HTMLPanel4(), get_domId3Element().get());

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
      f_HTMLPanel3.setStyleName("" + get_Settings().settingHeaderInfo() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1277 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
      get_domId2Element().get();

      // Detach section.
      attachRecord1277.detach();
      f_HTMLPanel3.addAndReplaceElement(get_settingsText(), get_domId2Element().get());

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
     * Getter for settingsText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_settingsText() {
      return build_settingsText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_settingsText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel settingsText = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      settingsText.setStyleName("" + get_Settings().settingPageMainTitle() + "");


      owner.settingsText = settingsText;

      return settingsText;
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
     * Getter for f_HTMLPanel4 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel4() {
      return build_f_HTMLPanel4();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel4 = new com.google.gwt.user.client.ui.HTMLPanel(template_html83().asString());
      // Setup section.
      f_HTMLPanel4.setStyleName("" + get_Settings().settingPageCenterWrapper() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1278 = UiBinderUtil.attachToDom(f_HTMLPanel4.getElement());
      get_domId4Element().get();
      get_domId29Element().get();

      // Detach section.
      attachRecord1278.detach();
      f_HTMLPanel4.addAndReplaceElement(get_f_HTMLPanel5(), get_domId4Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_f_HTMLPanel12(), get_domId29Element().get());

      return f_HTMLPanel4;
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
     * Getter for f_HTMLPanel5 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel5() {
      return build_f_HTMLPanel5();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel5 = new com.google.gwt.user.client.ui.HTMLPanel(template_html17().asString());
      // Setup section.
      f_HTMLPanel5.setStyleName("" + get_Settings().settingPageUserImageContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1279 = UiBinderUtil.attachToDom(f_HTMLPanel5.getElement());
      get_domId5Element().get();
      get_domId12Element().get();

      // Detach section.
      attachRecord1279.detach();
      f_HTMLPanel5.addAndReplaceElement(get_f_HTMLPanel6(), get_domId5Element().get());
      f_HTMLPanel5.addAndReplaceElement(get_aboutUsContainer(), get_domId12Element().get());

      return f_HTMLPanel5;
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
     * Getter for f_HTMLPanel6 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel6() {
      return build_f_HTMLPanel6();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel6() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel6 = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.
      f_HTMLPanel6.setStyleName("" + get_Settings().settingPageUserImageHolder() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1280 = UiBinderUtil.attachToDom(f_HTMLPanel6.getElement());
      get_domId6Element().get();
      get_domId9Element().get();
      get_domId10Element().get();

      // Detach section.
      attachRecord1280.detach();
      f_HTMLPanel6.addAndReplaceElement(get_profileImageContainer(), get_domId6Element().get());
      f_HTMLPanel6.addAndReplaceElement(get_lbName(), get_domId9Element().get());
      f_HTMLPanel6.addAndReplaceElement(get_f_HTMLPanel7(), get_domId10Element().get());

      return f_HTMLPanel6;
    }

    /**
     * Getter for domId6 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for profileImageContainer called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_profileImageContainer() {
      return build_profileImageContainer();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_profileImageContainer() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel profileImageContainer = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html3().asString());
      // Setup section.
      profileImageContainer.setStyleName("" + get_Settings().settingPageUserImage() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1281 = UiBinderUtil.attachToDom(profileImageContainer.getElement());
      get_domId7Element().get();
      get_domId8Element().get();

      // Detach section.
      attachRecord1281.detach();
      profileImageContainer.addAndReplaceElement(get_uploadProfileImage(), get_domId7Element().get());
      profileImageContainer.addAndReplaceElement(get_uploadProfilImageButton(), get_domId8Element().get());

      owner.profileImageContainer = profileImageContainer;

      return profileImageContainer;
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
     * Getter for uploadProfileImage called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Image get_uploadProfileImage() {
      return build_uploadProfileImage();
    }
    private com.google.gwt.user.client.ui.Image build_uploadProfileImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image uploadProfileImage = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      uploadProfileImage.setStyleName("" + get_Settings().uploadProfileImageHolder() + "");
      uploadProfileImage.setHeight("225");
      uploadProfileImage.setWidth("201");


      owner.uploadProfileImage = uploadProfileImage;

      return uploadProfileImage;
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
     * Getter for uploadProfilImageButton called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_uploadProfilImageButton() {
      return build_uploadProfilImageButton();
    }
    private com.google.gwt.user.client.ui.Label build_uploadProfilImageButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label uploadProfilImageButton = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      uploadProfilImageButton.setStyleName("" + get_Settings().uploadProfileImageButton() + "");


      owner.uploadProfilImageButton = uploadProfilImageButton;

      return uploadProfilImageButton;
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
     * Getter for domId6Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId9 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for lbName called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_lbName() {
      return build_lbName();
    }
    private com.google.gwt.user.client.ui.Label build_lbName() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lbName = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lbName.setStyleName("" + get_Settings().settingPageUserImageUserName() + "");


      owner.lbName = lbName;

      return lbName;
    }

    /**
     * Getter for domId9Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId10 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for f_HTMLPanel7 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel7() {
      return build_f_HTMLPanel7();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel7() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel7 = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      f_HTMLPanel7.setStyleName("" + get_Settings().settingPageUserImageUserNameHint() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1282 = UiBinderUtil.attachToDom(f_HTMLPanel7.getElement());
      get_domId11Element().get();

      // Detach section.
      attachRecord1282.detach();
      f_HTMLPanel7.addAndReplaceElement(get_lbUserName(), get_domId11Element().get());

      return f_HTMLPanel7;
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
     * Getter for lbUserName called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_lbUserName() {
      return build_lbUserName();
    }
    private com.google.gwt.user.client.ui.Label build_lbUserName() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lbUserName = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.lbUserName = lbUserName;

      return lbUserName;
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
     * Getter for domId10Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for aboutUsContainer called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_aboutUsContainer() {
      return build_aboutUsContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_aboutUsContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel aboutUsContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html16().asString());
      // Setup section.
      aboutUsContainer.setStyleName("" + get_Settings().publicProfileContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1283 = UiBinderUtil.attachToDom(aboutUsContainer.getElement());
      get_domId13Element().get();
      get_domId14Element().get();
      get_domId17Element().get();
      get_domId18Element().get();
      get_domId19Element().get();
      get_domId20Element().get();
      get_domId22Element().get();
      get_domId23Element().get();
      get_domId24Element().get();
      get_domId27Element().get();

      // Detach section.
      attachRecord1283.detach();
      aboutUsContainer.addAndReplaceElement(get_profilePageText(), get_domId13Element().get());
      aboutUsContainer.addAndReplaceElement(get_f_HTMLPanel8(), get_domId14Element().get());
      aboutUsContainer.addAndReplaceElement(get_f_HTMLPanel9(), get_domId17Element().get());
      aboutUsContainer.addAndReplaceElement(get_aboutUsText(), get_domId18Element().get());
      aboutUsContainer.addAndReplaceElement(get_appearText(), get_domId19Element().get());
      aboutUsContainer.addAndReplaceElement(get_profileDescriptionlabel(), get_domId20Element().get());
      aboutUsContainer.addAndReplaceElement(get_noAboutUsContainer(), get_domId22Element().get());
      aboutUsContainer.addAndReplaceElement(get_aboutUsCharacterValidation(), get_domId23Element().get());
      aboutUsContainer.addAndReplaceElement(get_f_HTMLPanel10(), get_domId24Element().get());
      aboutUsContainer.addAndReplaceElement(get_f_HTMLPanel11(), get_domId27Element().get());

      owner.aboutUsContainer = aboutUsContainer;

      return aboutUsContainer;
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
     * Getter for profilePageText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_profilePageText() {
      return build_profilePageText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_profilePageText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel profilePageText = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.
      profilePageText.setStyleName("" + get_Settings().publicProfileTitle() + "");


      owner.profilePageText = profilePageText;

      return profilePageText;
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
     * Getter for domId14 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for f_HTMLPanel8 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel8() {
      return build_f_HTMLPanel8();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel8() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel8 = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.
      f_HTMLPanel8.setStyleName("" + get_Settings().publicProfileOnButtonContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1284 = UiBinderUtil.attachToDom(f_HTMLPanel8.getElement());
      get_domId15Element().get();
      get_domId16Element().get();

      // Detach section.
      attachRecord1284.detach();
      f_HTMLPanel8.addAndReplaceElement(get_profileOnButton(), get_domId15Element().get());
      f_HTMLPanel8.addAndReplaceElement(get_profileOffButton(), get_domId16Element().get());

      return f_HTMLPanel8;
    }

    /**
     * Getter for domId15 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for profileOnButton called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Button get_profileOnButton() {
      return build_profileOnButton();
    }
    private com.google.gwt.user.client.ui.Button build_profileOnButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button profileOnButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      profileOnButton.setStyleName("" + get_Settings().publicProfileOnButtonActive() + "");


      owner.profileOnButton = profileOnButton;

      return profileOnButton;
    }

    /**
     * Getter for domId15Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for profileOffButton called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Button get_profileOffButton() {
      return build_profileOffButton();
    }
    private com.google.gwt.user.client.ui.Button build_profileOffButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button profileOffButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      profileOffButton.setStyleName("" + get_Settings().publicProfileOffButtonsDeActive() + "");


      owner.profileOffButton = profileOffButton;

      return profileOffButton;
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
     * Getter for domId14Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId17 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for f_HTMLPanel9 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel9() {
      return build_f_HTMLPanel9();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel9() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel9 = new com.google.gwt.user.client.ui.HTMLPanel(template_html8().asString());
      // Setup section.
      f_HTMLPanel9.setStyleName("" + get_Settings().clearContent() + "");


      return f_HTMLPanel9;
    }

    /**
     * Getter for domId17Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for aboutUsText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_aboutUsText() {
      return build_aboutUsText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_aboutUsText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel aboutUsText = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      aboutUsText.setStyleName("" + get_Settings().publicProfileTitle() + "");


      owner.aboutUsText = aboutUsText;

      return aboutUsText;
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
     * Getter for domId19 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for appearText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_appearText() {
      return build_appearText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_appearText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel appearText = new com.google.gwt.user.client.ui.HTMLPanel(template_html10().asString());
      // Setup section.
      appearText.setStyleName("" + get_Settings().publicProfileDescription() + "");


      owner.appearText = appearText;

      return appearText;
    }

    /**
     * Getter for domId19Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for profileDescriptionlabel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_profileDescriptionlabel() {
      return build_profileDescriptionlabel();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_profileDescriptionlabel() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel profileDescriptionlabel = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html11().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1285 = UiBinderUtil.attachToDom(profileDescriptionlabel.getElement());
      get_domId21Element().get();

      // Detach section.
      attachRecord1285.detach();
      profileDescriptionlabel.addAndReplaceElement(get_profileTextArea(), get_domId21Element().get());

      owner.profileDescriptionlabel = profileDescriptionlabel;

      return profileDescriptionlabel;
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
     * Getter for profileTextArea called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private org.ednovo.gooru.client.uc.ProfileBiographyEditUC get_profileTextArea() {
      return build_profileTextArea();
    }
    private org.ednovo.gooru.client.uc.ProfileBiographyEditUC build_profileTextArea() {
      // Creation section.
      final org.ednovo.gooru.client.uc.ProfileBiographyEditUC profileTextArea = (org.ednovo.gooru.client.uc.ProfileBiographyEditUC) GWT.create(org.ednovo.gooru.client.uc.ProfileBiographyEditUC.class);
      // Setup section.
      profileTextArea.setStyleName("" + get_Settings().profileDescription() + "");


      owner.profileTextArea = profileTextArea;

      return profileTextArea;
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
     * Getter for noAboutUsContainer called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FocusPanel get_noAboutUsContainer() {
      return build_noAboutUsContainer();
    }
    private com.google.gwt.user.client.ui.FocusPanel build_noAboutUsContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FocusPanel noAboutUsContainer = (com.google.gwt.user.client.ui.FocusPanel) GWT.create(com.google.gwt.user.client.ui.FocusPanel.class);
      // Setup section.
      noAboutUsContainer.add(get_pencilTextAreaImage());
      noAboutUsContainer.setStyleName("" + get_Settings().publicProfileTextarea() + "");


      owner.noAboutUsContainer = noAboutUsContainer;

      return noAboutUsContainer;
    }

    /**
     * Getter for pencilTextAreaImage called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_pencilTextAreaImage() {
      return build_pencilTextAreaImage();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_pencilTextAreaImage() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel pencilTextAreaImage = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html12().asString());
      // Setup section.
      pencilTextAreaImage.setStyleName("" + get_Settings().publicProfilePencilIconNew() + "");


      owner.pencilTextAreaImage = pencilTextAreaImage;

      return pencilTextAreaImage;
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
     * Getter for aboutUsCharacterValidation called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_aboutUsCharacterValidation() {
      return build_aboutUsCharacterValidation();
    }
    private com.google.gwt.user.client.ui.Label build_aboutUsCharacterValidation() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label aboutUsCharacterValidation = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      aboutUsCharacterValidation.setStyleName("" + get_Settings().mandatoryAboutUsLabel() + "");


      owner.aboutUsCharacterValidation = aboutUsCharacterValidation;

      return aboutUsCharacterValidation;
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
     * Getter for domId24 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for f_HTMLPanel10 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel10() {
      return build_f_HTMLPanel10();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel10() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel10 = new com.google.gwt.user.client.ui.HTMLPanel(template_html14().asString());
      // Setup section.
      f_HTMLPanel10.setStyleName("" + get_Settings().publicProfileSaveButtonContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1286 = UiBinderUtil.attachToDom(f_HTMLPanel10.getElement());
      get_domId25Element().get();
      get_domId26Element().get();

      // Detach section.
      attachRecord1286.detach();
      f_HTMLPanel10.addAndReplaceElement(get_btnSave(), get_domId25Element().get());
      f_HTMLPanel10.addAndReplaceElement(get_biographyCancelButton(), get_domId26Element().get());

      return f_HTMLPanel10;
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
     * Getter for btnSave called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Button get_btnSave() {
      return build_btnSave();
    }
    private com.google.gwt.user.client.ui.Button build_btnSave() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button btnSave = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      btnSave.setStyleName("" + get_Settings().publicProfileSaveButtonText() + " " + get_Settings().publicProfileSaveButtonBg() + "");


      owner.btnSave = btnSave;

      return btnSave;
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
     * Getter for biographyCancelButton called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_biographyCancelButton() {
      return build_biographyCancelButton();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_biographyCancelButton() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel biographyCancelButton = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html13().asString());
      // Setup section.
      biographyCancelButton.setStyleName("" + get_Settings().publicProfileCancelText() + "");


      owner.biographyCancelButton = biographyCancelButton;

      return biographyCancelButton;
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
     * Getter for domId24Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId27 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for f_HTMLPanel11 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel11() {
      return build_f_HTMLPanel11();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel11() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel11 = new com.google.gwt.user.client.ui.HTMLPanel(template_html15().asString());
      // Setup section.
      f_HTMLPanel11.setStyleName("" + get_Settings().publicProfileHoverButtons() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1287 = UiBinderUtil.attachToDom(f_HTMLPanel11.getElement());
      get_domId28Element().get();

      // Detach section.
      attachRecord1287.detach();
      f_HTMLPanel11.addAndReplaceElement(get_btnSeeMyProfile(), get_domId28Element().get());

      return f_HTMLPanel11;
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
     * Getter for btnSeeMyProfile called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Button get_btnSeeMyProfile() {
      return build_btnSeeMyProfile();
    }
    private com.google.gwt.user.client.ui.Button build_btnSeeMyProfile() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button btnSeeMyProfile = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      btnSeeMyProfile.setStyleName("" + get_Settings().publicProfileSeePageButtonBg() + "");


      owner.btnSeeMyProfile = btnSeeMyProfile;

      return btnSeeMyProfile;
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
     * Getter for domId27Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId29 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for f_HTMLPanel12 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel12() {
      return build_f_HTMLPanel12();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel12() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel12 = new com.google.gwt.user.client.ui.HTMLPanel(template_html82().asString());
      // Setup section.
      f_HTMLPanel12.setStyleName("" + get_Settings().settingPageInfoContainerWrapper() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1288 = UiBinderUtil.attachToDom(f_HTMLPanel12.getElement());
      get_domId30Element().get();

      // Detach section.
      attachRecord1288.detach();
      f_HTMLPanel12.addAndReplaceElement(get_f_HTMLPanel13(), get_domId30Element().get());

      return f_HTMLPanel12;
    }

    /**
     * Getter for domId30 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel13 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel13() {
      return build_f_HTMLPanel13();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel13() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel13 = new com.google.gwt.user.client.ui.HTMLPanel(template_html81().asString());
      // Setup section.
      f_HTMLPanel13.setStyleName("" + get_Settings().settingInfoContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1289 = UiBinderUtil.attachToDom(f_HTMLPanel13.getElement());
      get_domId31Element().get();
      get_domId78Element().get();
      get_domId94Element().get();
      get_domId102Element().get();
      get_domId124Element().get();

      // Detach section.
      attachRecord1289.detach();
      f_HTMLPanel13.addAndReplaceElement(get_f_HTMLPanel14(), get_domId31Element().get());
      f_HTMLPanel13.addAndReplaceElement(get_emailPanel(), get_domId78Element().get());
      f_HTMLPanel13.addAndReplaceElement(get_f_HTMLPanel29(), get_domId94Element().get());
      f_HTMLPanel13.addAndReplaceElement(get_f_HTMLPanel30(), get_domId102Element().get());
      f_HTMLPanel13.addAndReplaceElement(get_f_HTMLPanel38(), get_domId124Element().get());

      return f_HTMLPanel13;
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
     * Getter for f_HTMLPanel14 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel14() {
      return build_f_HTMLPanel14();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel14() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel14 = new com.google.gwt.user.client.ui.HTMLPanel(template_html44().asString());
      // Setup section.
      f_HTMLPanel14.setStyleName("" + get_Settings().settingInfoTitleContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1290 = UiBinderUtil.attachToDom(f_HTMLPanel14.getElement());
      get_domId32Element().get();
      get_domId42Element().get();

      // Detach section.
      attachRecord1290.detach();
      f_HTMLPanel14.addAndReplaceElement(get_plAccount(), get_domId32Element().get());
      f_HTMLPanel14.addAndReplaceElement(get_userAccount(), get_domId42Element().get());

      return f_HTMLPanel14;
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
     * Getter for plAccount called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_plAccount() {
      return build_plAccount();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_plAccount() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel plAccount = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html23().asString());
      // Setup section.
      plAccount.setStyleName("" + get_Settings().settingInfoTitleContainerTwo() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1291 = UiBinderUtil.attachToDom(plAccount.getElement());
      get_domId33Element().get();
      get_domId34Element().get();
      get_domId41Element().get();

      // Detach section.
      attachRecord1291.detach();
      plAccount.addAndReplaceElement(get_accountText(), get_domId33Element().get());
      plAccount.addAndReplaceElement(get_editButtonContainerAccount(), get_domId34Element().get());
      plAccount.addAndReplaceElement(get_accountMiniusArrow(), get_domId41Element().get());

      owner.plAccount = plAccount;

      return plAccount;
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
     * Getter for accountText called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_accountText() {
      return build_accountText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_accountText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel accountText = new com.google.gwt.user.client.ui.HTMLPanel(template_html18().asString());
      // Setup section.
      accountText.setStyleName("" + get_Settings().settingInfoTitle() + "");


      owner.accountText = accountText;

      return accountText;
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
     * Getter for editButtonContainerAccount called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_editButtonContainerAccount() {
      return build_editButtonContainerAccount();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_editButtonContainerAccount() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel editButtonContainerAccount = new com.google.gwt.user.client.ui.HTMLPanel(template_html21().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1292 = UiBinderUtil.attachToDom(editButtonContainerAccount.getElement());
      get_domId35Element().get();
      get_domId36Element().get();
      get_domId37Element().get();

      // Detach section.
      attachRecord1292.detach();
      editButtonContainerAccount.addAndReplaceElement(get_accountSavingTextLabel(), get_domId35Element().get());
      editButtonContainerAccount.addAndReplaceElement(get_editButtonAccount(), get_domId36Element().get());
      editButtonContainerAccount.addAndReplaceElement(get_buttonContainer(), get_domId37Element().get());

      owner.editButtonContainerAccount = editButtonContainerAccount;

      return editButtonContainerAccount;
    }

    /**
     * Getter for domId35 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for accountSavingTextLabel called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.Label get_accountSavingTextLabel() {
      return build_accountSavingTextLabel();
    }
    private com.google.gwt.user.client.ui.Label build_accountSavingTextLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label accountSavingTextLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      accountSavingTextLabel.setStyleName("" + get_Settings().settingInfoText() + "");


      owner.accountSavingTextLabel = accountSavingTextLabel;

      return accountSavingTextLabel;
    }

    /**
     * Getter for domId35Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for editButtonAccount called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.Button get_editButtonAccount() {
      return build_editButtonAccount();
    }
    private com.google.gwt.user.client.ui.Button build_editButtonAccount() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button editButtonAccount = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      editButtonAccount.setStyleName("" + get_Settings().settingEditButton() + "");


      owner.editButtonAccount = editButtonAccount;

      return editButtonAccount;
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
     * Getter for buttonContainer called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_buttonContainer() {
      return build_buttonContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_buttonContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel buttonContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html20().asString());
      // Setup section.
      buttonContainer.setStyleName("" + get_Settings().settingsPageSaveButtonContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1293 = UiBinderUtil.attachToDom(buttonContainer.getElement());
      get_domId38Element().get();

      // Detach section.
      attachRecord1293.detach();
      buttonContainer.addAndReplaceElement(get_f_HTMLPanel15(), get_domId38Element().get());

      owner.buttonContainer = buttonContainer;

      return buttonContainer;
    }

    /**
     * Getter for domId38 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 10.
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
     * Getter for f_HTMLPanel15 called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel15() {
      return build_f_HTMLPanel15();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel15() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel15 = new com.google.gwt.user.client.ui.HTMLPanel(template_html19().asString());
      // Setup section.
      f_HTMLPanel15.setStyleName("" + get_Settings().settingsPageSaveProfileButtonCenter() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1294 = UiBinderUtil.attachToDom(f_HTMLPanel15.getElement());
      get_domId39Element().get();
      get_domId40Element().get();

      // Detach section.
      attachRecord1294.detach();
      f_HTMLPanel15.addAndReplaceElement(get_settingCancelButton(), get_domId39Element().get());
      f_HTMLPanel15.addAndReplaceElement(get_settingsSaveButton(), get_domId40Element().get());

      return f_HTMLPanel15;
    }

    /**
     * Getter for domId39 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 11.
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
     * Getter for settingCancelButton called 1 times. Type: DEFAULT. Build precedence: 11.
     */
    private com.google.gwt.user.client.ui.Button get_settingCancelButton() {
      return build_settingCancelButton();
    }
    private com.google.gwt.user.client.ui.Button build_settingCancelButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button settingCancelButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      settingCancelButton.setStyleName("" + get_Settings().settingCancelButton() + "");
      settingCancelButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.settingCancelButton = settingCancelButton;

      return settingCancelButton;
    }

    /**
     * Getter for domId39Element called 2 times. Type: DEFAULT. Build precedence: 11.
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
     * Getter for domId40 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 11.
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
     * Getter for settingsSaveButton called 1 times. Type: DEFAULT. Build precedence: 11.
     */
    private com.google.gwt.user.client.ui.Button get_settingsSaveButton() {
      return build_settingsSaveButton();
    }
    private com.google.gwt.user.client.ui.Button build_settingsSaveButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button settingsSaveButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      settingsSaveButton.setStyleName("primary");
      settingsSaveButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.settingsSaveButton = settingsSaveButton;

      return settingsSaveButton;
    }

    /**
     * Getter for domId40Element called 2 times. Type: DEFAULT. Build precedence: 11.
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
     * Getter for domId38Element called 2 times. Type: DEFAULT. Build precedence: 10.
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
     * Getter for accountMiniusArrow called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_accountMiniusArrow() {
      return build_accountMiniusArrow();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_accountMiniusArrow() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel accountMiniusArrow = new com.google.gwt.user.client.ui.HTMLPanel(template_html22().asString());
      // Setup section.
      accountMiniusArrow.setStyleName("" + get_Settings().settingInfoMimiusArrow() + "");
      accountMiniusArrow.setVisible(false);


      owner.accountMiniusArrow = accountMiniusArrow;

      return accountMiniusArrow;
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
     * Getter for userAccount called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_userAccount() {
      return build_userAccount();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_userAccount() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel userAccount = new com.google.gwt.user.client.ui.HTMLPanel(template_html43().asString());
      // Setup section.
      userAccount.setStyleName("" + get_Settings().settingHtmlPanel() + "");
      userAccount.setVisible(false);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1295 = UiBinderUtil.attachToDom(userAccount.getElement());
      get_domId43Element().get();
      get_domId55Element().get();
      get_domId56Element().get();
      get_domId60Element().get();
      get_domId61Element().get();

      // Detach section.
      attachRecord1295.detach();
      userAccount.addAndReplaceElement(get_f_HTMLPanel16(), get_domId43Element().get());
      userAccount.addAndReplaceElement(get_userNameValidationUc(), get_domId55Element().get());
      userAccount.addAndReplaceElement(get_f_HTMLPanel20(), get_domId56Element().get());
      userAccount.addAndReplaceElement(get_charLimitFNameLbl(), get_domId60Element().get());
      userAccount.addAndReplaceElement(get_f_HTMLPanel21(), get_domId61Element().get());

      owner.userAccount = userAccount;

      return userAccount;
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
     * Getter for f_HTMLPanel16 called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel16() {
      return build_f_HTMLPanel16();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel16() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel16 = new com.google.gwt.user.client.ui.HTMLPanel(template_html32().asString());
      // Setup section.
      f_HTMLPanel16.setStyleName("" + get_Settings().settingOneSetOfInputContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1296 = UiBinderUtil.attachToDom(f_HTMLPanel16.getElement());
      get_domId44Element().get();
      get_domId45Element().get();

      // Detach section.
      attachRecord1296.detach();
      f_HTMLPanel16.addAndReplaceElement(get_usernameText(), get_domId44Element().get());
      f_HTMLPanel16.addAndReplaceElement(get_panelUserNameLabelContainer(), get_domId45Element().get());

      return f_HTMLPanel16;
    }

    /**
     * Getter for domId44 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for usernameText called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_usernameText() {
      return build_usernameText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_usernameText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel usernameText = new com.google.gwt.user.client.ui.HTMLPanel(template_html24().asString());
      // Setup section.
      usernameText.setStyleName("" + get_Settings().settingInfoNameText() + "");


      owner.usernameText = usernameText;

      return usernameText;
    }

    /**
     * Getter for domId44Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId45 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for panelUserNameLabelContainer called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelUserNameLabelContainer() {
      return build_panelUserNameLabelContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelUserNameLabelContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelUserNameLabelContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html31().asString());
      // Setup section.
      panelUserNameLabelContainer.setStyleName("" + get_Settings().settingOneSetOfLabelontainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1297 = UiBinderUtil.attachToDom(panelUserNameLabelContainer.getElement());
      get_domId46Element().get();
      get_domId47Element().get();
      get_domId48Element().get();

      // Detach section.
      attachRecord1297.detach();
      panelUserNameLabelContainer.addAndReplaceElement(get_lbUName(), get_domId46Element().get());
      panelUserNameLabelContainer.addAndReplaceElement(get_txtUserName(), get_domId47Element().get());
      panelUserNameLabelContainer.addAndReplaceElement(get_panelHelp(), get_domId48Element().get());

      return panelUserNameLabelContainer;
    }

    /**
     * Getter for domId46 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 10.
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
     * Getter for lbUName called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.Label get_lbUName() {
      return build_lbUName();
    }
    private com.google.gwt.user.client.ui.Label build_lbUName() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lbUName = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lbUName.setStyleName("" + get_Settings().settingPageUserNameColor() + "");


      owner.lbUName = lbUName;

      return lbUName;
    }

    /**
     * Getter for domId46Element called 2 times. Type: DEFAULT. Build precedence: 10.
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
     * Getter for domId47 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 10.
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
     * Getter for txtUserName called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.TextBox get_txtUserName() {
      return build_txtUserName();
    }
    private com.google.gwt.user.client.ui.TextBox build_txtUserName() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox txtUserName = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.
      txtUserName.setStyleName("SettingEditName");


      owner.txtUserName = txtUserName;

      return txtUserName;
    }

    /**
     * Getter for domId47Element called 2 times. Type: DEFAULT. Build precedence: 10.
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
     * Getter for domId48 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 10.
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
     * Getter for panelHelp called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelHelp() {
      return build_panelHelp();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelHelp() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelHelp = new com.google.gwt.user.client.ui.HTMLPanel(template_html30().asString());
      // Setup section.
      panelHelp.setStyleName("questionHoverContainer");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1298 = UiBinderUtil.attachToDom(panelHelp.getElement());
      get_domId49Element().get();
      get_domId50Element().get();

      // Detach section.
      attachRecord1298.detach();
      panelHelp.addAndReplaceElement(get_f_HTMLPanel17(), get_domId49Element().get());
      panelHelp.addAndReplaceElement(get_panelTooltipContainer(), get_domId50Element().get());

      owner.panelHelp = panelHelp;

      return panelHelp;
    }

    /**
     * Getter for domId49 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 11.
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
     * Getter for f_HTMLPanel17 called 1 times. Type: DEFAULT. Build precedence: 11.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel17() {
      return build_f_HTMLPanel17();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel17() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel17 = new com.google.gwt.user.client.ui.HTMLPanel(template_html25().asString());
      // Setup section.
      f_HTMLPanel17.setStyleName("questionHover");


      return f_HTMLPanel17;
    }

    /**
     * Getter for domId49Element called 2 times. Type: DEFAULT. Build precedence: 11.
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
     * Getter for domId50 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 11.
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
     * Getter for panelTooltipContainer called 1 times. Type: DEFAULT. Build precedence: 11.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelTooltipContainer() {
      return build_panelTooltipContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelTooltipContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelTooltipContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html29().asString());
      // Setup section.
      panelTooltipContainer.setStyleName("tooltipContainer");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1299 = UiBinderUtil.attachToDom(panelTooltipContainer.getElement());
      get_domId51Element().get();
      get_domId52Element().get();
      get_domId53Element().get();

      // Detach section.
      attachRecord1299.detach();
      panelTooltipContainer.addAndReplaceElement(get_f_HTMLPanel18(), get_domId51Element().get());
      panelTooltipContainer.addAndReplaceElement(get_f_HTMLPanel19(), get_domId52Element().get());
      panelTooltipContainer.addAndReplaceElement(get_panelToolTipContent(), get_domId53Element().get());

      owner.panelTooltipContainer = panelTooltipContainer;

      return panelTooltipContainer;
    }

    /**
     * Getter for domId51 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 12.
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
     * Getter for f_HTMLPanel18 called 1 times. Type: DEFAULT. Build precedence: 12.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel18() {
      return build_f_HTMLPanel18();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel18() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel18 = new com.google.gwt.user.client.ui.HTMLPanel(template_html26().asString());
      // Setup section.
      f_HTMLPanel18.setStyleName("arrowBorder");


      return f_HTMLPanel18;
    }

    /**
     * Getter for domId51Element called 2 times. Type: DEFAULT. Build precedence: 12.
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
     * Getter for domId52 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 12.
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
     * Getter for f_HTMLPanel19 called 1 times. Type: DEFAULT. Build precedence: 12.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel19() {
      return build_f_HTMLPanel19();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel19() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel19 = new com.google.gwt.user.client.ui.HTMLPanel(template_html27().asString());
      // Setup section.
      f_HTMLPanel19.setStyleName("arrow");


      return f_HTMLPanel19;
    }

    /**
     * Getter for domId52Element called 2 times. Type: DEFAULT. Build precedence: 12.
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
     * Getter for domId53 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 12.
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
     * Getter for panelToolTipContent called 1 times. Type: DEFAULT. Build precedence: 12.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelToolTipContent() {
      return build_panelToolTipContent();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelToolTipContent() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelToolTipContent = new com.google.gwt.user.client.ui.HTMLPanel(template_html28().asString());
      // Setup section.
      panelToolTipContent.setStyleName("tooltipContent");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1300 = UiBinderUtil.attachToDom(panelToolTipContent.getElement());
      get_domId54Element().get();

      // Detach section.
      attachRecord1300.detach();
      panelToolTipContent.addAndReplaceElement(get_htmlToolTipDesc(), get_domId54Element().get());

      owner.panelToolTipContent = panelToolTipContent;

      return panelToolTipContent;
    }

    /**
     * Getter for domId54 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 13.
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
     * Getter for htmlToolTipDesc called 1 times. Type: DEFAULT. Build precedence: 13.
     */
    private com.google.gwt.user.client.ui.HTML get_htmlToolTipDesc() {
      return build_htmlToolTipDesc();
    }
    private com.google.gwt.user.client.ui.HTML build_htmlToolTipDesc() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML htmlToolTipDesc = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      htmlToolTipDesc.setStyleName("");


      owner.htmlToolTipDesc = htmlToolTipDesc;

      return htmlToolTipDesc;
    }

    /**
     * Getter for domId54Element called 2 times. Type: DEFAULT. Build precedence: 13.
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
     * Getter for domId53Element called 2 times. Type: DEFAULT. Build precedence: 12.
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
     * Getter for domId50Element called 2 times. Type: DEFAULT. Build precedence: 11.
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
     * Getter for domId48Element called 2 times. Type: DEFAULT. Build precedence: 10.
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
     * Getter for domId45Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId55 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for userNameValidationUc called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private org.ednovo.gooru.client.uc.ErrorLabelUc get_userNameValidationUc() {
      return build_userNameValidationUc();
    }
    private org.ednovo.gooru.client.uc.ErrorLabelUc build_userNameValidationUc() {
      // Creation section.
      final org.ednovo.gooru.client.uc.ErrorLabelUc userNameValidationUc = (org.ednovo.gooru.client.uc.ErrorLabelUc) GWT.create(org.ednovo.gooru.client.uc.ErrorLabelUc.class);
      // Setup section.


      owner.userNameValidationUc = userNameValidationUc;

      return userNameValidationUc;
    }

    /**
     * Getter for domId55Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId56 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for f_HTMLPanel20 called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel20() {
      return build_f_HTMLPanel20();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel20() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel20 = new com.google.gwt.user.client.ui.HTMLPanel(template_html34().asString());
      // Setup section.
      f_HTMLPanel20.setStyleName("" + get_Settings().settingOneSetOfInputContainerName() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1301 = UiBinderUtil.attachToDom(f_HTMLPanel20.getElement());
      get_domId57Element().get();
      get_domId58Element().get();
      get_domId59Element().get();

      // Detach section.
      attachRecord1301.detach();
      f_HTMLPanel20.addAndReplaceElement(get_nametext(), get_domId57Element().get());
      f_HTMLPanel20.addAndReplaceElement(get_tbFirstNameUcLabel(), get_domId58Element().get());
      f_HTMLPanel20.addAndReplaceElement(get_tbLastNameUcLabel(), get_domId59Element().get());

      return f_HTMLPanel20;
    }

    /**
     * Getter for domId57 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for nametext called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_nametext() {
      return build_nametext();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_nametext() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel nametext = new com.google.gwt.user.client.ui.HTMLPanel(template_html33().asString());
      // Setup section.
      nametext.setStyleName("" + get_Settings().settingInfoNameTextContent() + "");


      owner.nametext = nametext;

      return nametext;
    }

    /**
     * Getter for domId57Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId58 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for tbFirstNameUcLabel called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private org.ednovo.gooru.client.uc.SettingEditLabelUc get_tbFirstNameUcLabel() {
      return build_tbFirstNameUcLabel();
    }
    private org.ednovo.gooru.client.uc.SettingEditLabelUc build_tbFirstNameUcLabel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.SettingEditLabelUc tbFirstNameUcLabel = owner.tbFirstNameUcLabel;
      assert tbFirstNameUcLabel != null : "UiField tbFirstNameUcLabel with 'provided = true' was null";
      // Setup section.
      tbFirstNameUcLabel.setStyleName("" + get_Settings().settingPageUserNameColorfirstName() + "");


      return tbFirstNameUcLabel;
    }

    /**
     * Getter for domId58Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId59 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for tbLastNameUcLabel called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private org.ednovo.gooru.client.uc.SettingLastNameEditLabelUC get_tbLastNameUcLabel() {
      return build_tbLastNameUcLabel();
    }
    private org.ednovo.gooru.client.uc.SettingLastNameEditLabelUC build_tbLastNameUcLabel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.SettingLastNameEditLabelUC tbLastNameUcLabel = owner.tbLastNameUcLabel;
      assert tbLastNameUcLabel != null : "UiField tbLastNameUcLabel with 'provided = true' was null";
      // Setup section.
      tbLastNameUcLabel.setStyleName("" + get_Settings().settingOneSetOfInputContainerLastNameNew() + "");


      return tbLastNameUcLabel;
    }

    /**
     * Getter for domId59Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId56Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId60 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for charLimitFNameLbl called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Label get_charLimitFNameLbl() {
      return build_charLimitFNameLbl();
    }
    private com.google.gwt.user.client.ui.Label build_charLimitFNameLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label charLimitFNameLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      charLimitFNameLbl.setStyleName("" + get_Settings().mandatoryNameLabel() + "");


      owner.charLimitFNameLbl = charLimitFNameLbl;

      return charLimitFNameLbl;
    }

    /**
     * Getter for domId60Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId61 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for f_HTMLPanel21 called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel21() {
      return build_f_HTMLPanel21();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel21() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel21 = new com.google.gwt.user.client.ui.HTMLPanel(template_html42().asString());
      // Setup section.
      f_HTMLPanel21.setStyleName("" + get_Settings().settingInfoTitleContainerTwo() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1302 = UiBinderUtil.attachToDom(f_HTMLPanel21.getElement());
      get_domId62Element().get();
      get_domId63Element().get();
      get_domId65Element().get();

      // Detach section.
      attachRecord1302.detach();
      f_HTMLPanel21.addAndReplaceElement(get_genderText(), get_domId62Element().get());
      f_HTMLPanel21.addAndReplaceElement(get_f_HTMLPanel22(), get_domId63Element().get());
      f_HTMLPanel21.addAndReplaceElement(get_radioButtonContainer(), get_domId65Element().get());

      return f_HTMLPanel21;
    }

    /**
     * Getter for domId62 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for genderText called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_genderText() {
      return build_genderText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_genderText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel genderText = new com.google.gwt.user.client.ui.HTMLPanel(template_html35().asString());
      // Setup section.
      genderText.setStyleName("" + get_Settings().settingInfoNameText() + "");


      owner.genderText = genderText;

      return genderText;
    }

    /**
     * Getter for domId62Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId63 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for f_HTMLPanel22 called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel22() {
      return build_f_HTMLPanel22();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel22() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel22 = new com.google.gwt.user.client.ui.HTMLPanel(template_html36().asString());
      // Setup section.
      f_HTMLPanel22.setStyleName("" + get_Settings().settingOneSetOfLabelontainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1303 = UiBinderUtil.attachToDom(f_HTMLPanel22.getElement());
      get_domId64Element().get();

      // Detach section.
      attachRecord1303.detach();
      f_HTMLPanel22.addAndReplaceElement(get_lblgender(), get_domId64Element().get());

      return f_HTMLPanel22;
    }

    /**
     * Getter for domId64 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 10.
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
     * Getter for lblgender called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.Label get_lblgender() {
      return build_lblgender();
    }
    private com.google.gwt.user.client.ui.Label build_lblgender() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblgender = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblgender.setStyleName("" + get_Settings().settingPageUserNameColorGender() + "");


      owner.lblgender = lblgender;

      return lblgender;
    }

    /**
     * Getter for domId64Element called 2 times. Type: DEFAULT. Build precedence: 10.
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
     * Getter for domId63Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId65 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for radioButtonContainer called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_radioButtonContainer() {
      return build_radioButtonContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_radioButtonContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel radioButtonContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html41().asString());
      // Setup section.
      radioButtonContainer.setStyleName("" + get_Settings().settingPageRadioButtonContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1304 = UiBinderUtil.attachToDom(radioButtonContainer.getElement());
      get_domId66Element().get();
      get_domId69Element().get();
      get_domId72Element().get();
      get_domId75Element().get();

      // Detach section.
      attachRecord1304.detach();
      radioButtonContainer.addAndReplaceElement(get_f_HTMLPanel23(), get_domId66Element().get());
      radioButtonContainer.addAndReplaceElement(get_f_HTMLPanel24(), get_domId69Element().get());
      radioButtonContainer.addAndReplaceElement(get_f_HTMLPanel25(), get_domId72Element().get());
      radioButtonContainer.addAndReplaceElement(get_f_HTMLPanel26(), get_domId75Element().get());

      owner.radioButtonContainer = radioButtonContainer;

      return radioButtonContainer;
    }

    /**
     * Getter for domId66 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 10.
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
     * Getter for f_HTMLPanel23 called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel23() {
      return build_f_HTMLPanel23();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel23() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel23 = new com.google.gwt.user.client.ui.HTMLPanel(template_html37().asString());
      // Setup section.
      f_HTMLPanel23.setStyleName("" + get_Settings().settingPageRadioButtonHolder() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1305 = UiBinderUtil.attachToDom(f_HTMLPanel23.getElement());
      get_domId67Element().get();
      get_domId68Element().get();

      // Detach section.
      attachRecord1305.detach();
      f_HTMLPanel23.addAndReplaceElement(get_lbMale(), get_domId67Element().get());
      f_HTMLPanel23.addAndReplaceElement(get_lbMaleText(), get_domId68Element().get());

      return f_HTMLPanel23;
    }

    /**
     * Getter for domId67 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 11.
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
     * Getter for lbMale called 1 times. Type: DEFAULT. Build precedence: 11.
     */
    private com.google.gwt.user.client.ui.Label get_lbMale() {
      return build_lbMale();
    }
    private com.google.gwt.user.client.ui.Label build_lbMale() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lbMale = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lbMale.setStyleName("" + get_Settings().radio() + "");


      owner.lbMale = lbMale;

      return lbMale;
    }

    /**
     * Getter for domId67Element called 2 times. Type: DEFAULT. Build precedence: 11.
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
     * Getter for domId68 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 11.
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
     * Getter for lbMaleText called 1 times. Type: DEFAULT. Build precedence: 11.
     */
    private com.google.gwt.user.client.ui.Label get_lbMaleText() {
      return build_lbMaleText();
    }
    private com.google.gwt.user.client.ui.Label build_lbMaleText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lbMaleText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lbMaleText.setStyleName("" + get_Settings().radioTextGeneral() + "");


      owner.lbMaleText = lbMaleText;

      return lbMaleText;
    }

    /**
     * Getter for domId68Element called 2 times. Type: DEFAULT. Build precedence: 11.
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
     * Getter for domId66Element called 2 times. Type: DEFAULT. Build precedence: 10.
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
     * Getter for domId69 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 10.
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
     * Getter for f_HTMLPanel24 called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel24() {
      return build_f_HTMLPanel24();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel24() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel24 = new com.google.gwt.user.client.ui.HTMLPanel(template_html38().asString());
      // Setup section.
      f_HTMLPanel24.setStyleName("" + get_Settings().settingPageRadioButtonHolder() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1306 = UiBinderUtil.attachToDom(f_HTMLPanel24.getElement());
      get_domId70Element().get();
      get_domId71Element().get();

      // Detach section.
      attachRecord1306.detach();
      f_HTMLPanel24.addAndReplaceElement(get_lbFemale(), get_domId70Element().get());
      f_HTMLPanel24.addAndReplaceElement(get_lbFemaleText(), get_domId71Element().get());

      return f_HTMLPanel24;
    }

    /**
     * Getter for domId70 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 11.
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
     * Getter for lbFemale called 1 times. Type: DEFAULT. Build precedence: 11.
     */
    private com.google.gwt.user.client.ui.Label get_lbFemale() {
      return build_lbFemale();
    }
    private com.google.gwt.user.client.ui.Label build_lbFemale() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lbFemale = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lbFemale.setStyleName("" + get_Settings().radio() + "");


      owner.lbFemale = lbFemale;

      return lbFemale;
    }

    /**
     * Getter for domId70Element called 2 times. Type: DEFAULT. Build precedence: 11.
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
     * Getter for domId71 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 11.
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
     * Getter for lbFemaleText called 1 times. Type: DEFAULT. Build precedence: 11.
     */
    private com.google.gwt.user.client.ui.Label get_lbFemaleText() {
      return build_lbFemaleText();
    }
    private com.google.gwt.user.client.ui.Label build_lbFemaleText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lbFemaleText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lbFemaleText.setStyleName("" + get_Settings().radioTextGeneral() + "");


      owner.lbFemaleText = lbFemaleText;

      return lbFemaleText;
    }

    /**
     * Getter for domId71Element called 2 times. Type: DEFAULT. Build precedence: 11.
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
     * Getter for domId69Element called 2 times. Type: DEFAULT. Build precedence: 10.
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
     * Getter for domId72 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 10.
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
     * Getter for f_HTMLPanel25 called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel25() {
      return build_f_HTMLPanel25();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel25() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel25 = new com.google.gwt.user.client.ui.HTMLPanel(template_html39().asString());
      // Setup section.
      f_HTMLPanel25.setStyleName("" + get_Settings().settingPageRadioButtonHolder() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1307 = UiBinderUtil.attachToDom(f_HTMLPanel25.getElement());
      get_domId73Element().get();
      get_domId74Element().get();

      // Detach section.
      attachRecord1307.detach();
      f_HTMLPanel25.addAndReplaceElement(get_lbOther(), get_domId73Element().get());
      f_HTMLPanel25.addAndReplaceElement(get_lbOtherText(), get_domId74Element().get());

      return f_HTMLPanel25;
    }

    /**
     * Getter for domId73 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 11.
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
     * Getter for lbOther called 1 times. Type: DEFAULT. Build precedence: 11.
     */
    private com.google.gwt.user.client.ui.Label get_lbOther() {
      return build_lbOther();
    }
    private com.google.gwt.user.client.ui.Label build_lbOther() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lbOther = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lbOther.setStyleName("" + get_Settings().radio() + "");


      owner.lbOther = lbOther;

      return lbOther;
    }

    /**
     * Getter for domId73Element called 2 times. Type: DEFAULT. Build precedence: 11.
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
     * Getter for domId74 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 11.
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
     * Getter for lbOtherText called 1 times. Type: DEFAULT. Build precedence: 11.
     */
    private com.google.gwt.user.client.ui.Label get_lbOtherText() {
      return build_lbOtherText();
    }
    private com.google.gwt.user.client.ui.Label build_lbOtherText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lbOtherText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lbOtherText.setStyleName("" + get_Settings().radioTextGeneral() + "");


      owner.lbOtherText = lbOtherText;

      return lbOtherText;
    }

    /**
     * Getter for domId74Element called 2 times. Type: DEFAULT. Build precedence: 11.
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
     * Getter for domId72Element called 2 times. Type: DEFAULT. Build precedence: 10.
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
     * Getter for domId75 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 10.
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
     * Getter for f_HTMLPanel26 called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel26() {
      return build_f_HTMLPanel26();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel26() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel26 = new com.google.gwt.user.client.ui.HTMLPanel(template_html40().asString());
      // Setup section.
      f_HTMLPanel26.setStyleName("" + get_Settings().settingPageRadioButtonHolder() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1308 = UiBinderUtil.attachToDom(f_HTMLPanel26.getElement());
      get_domId76Element().get();
      get_domId77Element().get();

      // Detach section.
      attachRecord1308.detach();
      f_HTMLPanel26.addAndReplaceElement(get_lbShare(), get_domId76Element().get());
      f_HTMLPanel26.addAndReplaceElement(get_notToShareText(), get_domId77Element().get());

      return f_HTMLPanel26;
    }

    /**
     * Getter for domId76 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 11.
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
     * Getter for lbShare called 1 times. Type: DEFAULT. Build precedence: 11.
     */
    private com.google.gwt.user.client.ui.Label get_lbShare() {
      return build_lbShare();
    }
    private com.google.gwt.user.client.ui.Label build_lbShare() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lbShare = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lbShare.setStyleName("" + get_Settings().radio() + "");


      owner.lbShare = lbShare;

      return lbShare;
    }

    /**
     * Getter for domId76Element called 2 times. Type: DEFAULT. Build precedence: 11.
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
     * Getter for domId77 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 11.
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
     * Getter for notToShareText called 1 times. Type: DEFAULT. Build precedence: 11.
     */
    private com.google.gwt.user.client.ui.Label get_notToShareText() {
      return build_notToShareText();
    }
    private com.google.gwt.user.client.ui.Label build_notToShareText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label notToShareText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      notToShareText.setStyleName("" + get_Settings().radioTextGeneral() + "");


      owner.notToShareText = notToShareText;

      return notToShareText;
    }

    /**
     * Getter for domId77Element called 2 times. Type: DEFAULT. Build precedence: 11.
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
     * Getter for domId75Element called 2 times. Type: DEFAULT. Build precedence: 10.
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
     * Getter for domId65Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId61Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId78 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for emailPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_emailPanel() {
      return build_emailPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_emailPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel emailPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html53().asString());
      // Setup section.
      emailPanel.setStyleName("" + get_Settings().settingInfoTitleOneContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1309 = UiBinderUtil.attachToDom(emailPanel.getElement());
      get_domId79Element().get();
      get_domId89Element().get();

      // Detach section.
      attachRecord1309.detach();
      emailPanel.addAndReplaceElement(get_plContact(), get_domId79Element().get());
      emailPanel.addAndReplaceElement(get_userContact(), get_domId89Element().get());

      owner.emailPanel = emailPanel;

      return emailPanel;
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
     * Getter for plContact called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_plContact() {
      return build_plContact();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_plContact() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel plContact = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html50().asString());
      // Setup section.
      plContact.setStyleName("" + get_Settings().settingInfoTitleContainerTwo() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1310 = UiBinderUtil.attachToDom(plContact.getElement());
      get_domId80Element().get();
      get_domId81Element().get();
      get_domId88Element().get();

      // Detach section.
      attachRecord1310.detach();
      plContact.addAndReplaceElement(get_emailtext(), get_domId80Element().get());
      plContact.addAndReplaceElement(get_editButtonContainerContact(), get_domId81Element().get());
      plContact.addAndReplaceElement(get_contactMiniusArrow(), get_domId88Element().get());

      owner.plContact = plContact;

      return plContact;
    }

    /**
     * Getter for domId80 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for emailtext called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_emailtext() {
      return build_emailtext();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_emailtext() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel emailtext = new com.google.gwt.user.client.ui.HTMLPanel(template_html45().asString());
      // Setup section.
      emailtext.setStyleName("" + get_Settings().settingInfoTitle() + "");


      owner.emailtext = emailtext;

      return emailtext;
    }

    /**
     * Getter for domId80Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId81 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for editButtonContainerContact called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_editButtonContainerContact() {
      return build_editButtonContainerContact();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_editButtonContainerContact() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel editButtonContainerContact = new com.google.gwt.user.client.ui.HTMLPanel(template_html48().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1311 = UiBinderUtil.attachToDom(editButtonContainerContact.getElement());
      get_domId82Element().get();
      get_domId83Element().get();
      get_domId84Element().get();

      // Detach section.
      attachRecord1311.detach();
      editButtonContainerContact.addAndReplaceElement(get_SavingTextLabel(), get_domId82Element().get());
      editButtonContainerContact.addAndReplaceElement(get_editButtonContact(), get_domId83Element().get());
      editButtonContainerContact.addAndReplaceElement(get_emailbuttonContainer(), get_domId84Element().get());

      owner.editButtonContainerContact = editButtonContainerContact;

      return editButtonContainerContact;
    }

    /**
     * Getter for domId82 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for SavingTextLabel called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.Label get_SavingTextLabel() {
      return build_SavingTextLabel();
    }
    private com.google.gwt.user.client.ui.Label build_SavingTextLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label SavingTextLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      SavingTextLabel.setStyleName("" + get_Settings().settingInfoText() + "");


      owner.SavingTextLabel = SavingTextLabel;

      return SavingTextLabel;
    }

    /**
     * Getter for domId82Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId83 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for editButtonContact called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.Button get_editButtonContact() {
      return build_editButtonContact();
    }
    private com.google.gwt.user.client.ui.Button build_editButtonContact() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button editButtonContact = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      editButtonContact.setStyleName("" + get_Settings().settingEditButton() + "");


      owner.editButtonContact = editButtonContact;

      return editButtonContact;
    }

    /**
     * Getter for domId83Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId84 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for emailbuttonContainer called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_emailbuttonContainer() {
      return build_emailbuttonContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_emailbuttonContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel emailbuttonContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html47().asString());
      // Setup section.
      emailbuttonContainer.setStyleName("" + get_Settings().settingsPageSaveButtonContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1312 = UiBinderUtil.attachToDom(emailbuttonContainer.getElement());
      get_domId85Element().get();

      // Detach section.
      attachRecord1312.detach();
      emailbuttonContainer.addAndReplaceElement(get_f_HTMLPanel27(), get_domId85Element().get());

      owner.emailbuttonContainer = emailbuttonContainer;

      return emailbuttonContainer;
    }

    /**
     * Getter for domId85 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 10.
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
     * Getter for f_HTMLPanel27 called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel27() {
      return build_f_HTMLPanel27();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel27() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel27 = new com.google.gwt.user.client.ui.HTMLPanel(template_html46().asString());
      // Setup section.
      f_HTMLPanel27.setStyleName("" + get_Settings().settingsPageSaveProfileButtonCenter() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1313 = UiBinderUtil.attachToDom(f_HTMLPanel27.getElement());
      get_domId86Element().get();
      get_domId87Element().get();

      // Detach section.
      attachRecord1313.detach();
      f_HTMLPanel27.addAndReplaceElement(get_emailCancelButton(), get_domId86Element().get());
      f_HTMLPanel27.addAndReplaceElement(get_emailSaveButton(), get_domId87Element().get());

      return f_HTMLPanel27;
    }

    /**
     * Getter for domId86 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 11.
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
     * Getter for emailCancelButton called 1 times. Type: DEFAULT. Build precedence: 11.
     */
    private com.google.gwt.user.client.ui.Button get_emailCancelButton() {
      return build_emailCancelButton();
    }
    private com.google.gwt.user.client.ui.Button build_emailCancelButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button emailCancelButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      emailCancelButton.setStyleName("" + get_Settings().settingCancelButton() + "");
      emailCancelButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);


      owner.emailCancelButton = emailCancelButton;

      return emailCancelButton;
    }

    /**
     * Getter for domId86Element called 2 times. Type: DEFAULT. Build precedence: 11.
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
     * Getter for domId87 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 11.
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
     * Getter for emailSaveButton called 1 times. Type: DEFAULT. Build precedence: 11.
     */
    private com.google.gwt.user.client.ui.Button get_emailSaveButton() {
      return build_emailSaveButton();
    }
    private com.google.gwt.user.client.ui.Button build_emailSaveButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button emailSaveButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      emailSaveButton.setStyleName("" + get_Settings().settingsPageSaveProfileButton() + "");
      emailSaveButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);


      owner.emailSaveButton = emailSaveButton;

      return emailSaveButton;
    }

    /**
     * Getter for domId87Element called 2 times. Type: DEFAULT. Build precedence: 11.
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
     * Getter for domId85Element called 2 times. Type: DEFAULT. Build precedence: 10.
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
     * Getter for domId84Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId81Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId88 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for contactMiniusArrow called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_contactMiniusArrow() {
      return build_contactMiniusArrow();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_contactMiniusArrow() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel contactMiniusArrow = new com.google.gwt.user.client.ui.HTMLPanel(template_html49().asString());
      // Setup section.
      contactMiniusArrow.setStyleName("" + get_Settings().settingInfoMimiusArrow() + "");
      contactMiniusArrow.setVisible(false);


      owner.contactMiniusArrow = contactMiniusArrow;

      return contactMiniusArrow;
    }

    /**
     * Getter for domId88Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for userContact called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_userContact() {
      return build_userContact();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_userContact() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel userContact = new com.google.gwt.user.client.ui.HTMLPanel(template_html52().asString());
      // Setup section.
      userContact.setStyleName("" + get_Settings().settingHtmlPanel() + "");
      userContact.setVisible(false);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1314 = UiBinderUtil.attachToDom(userContact.getElement());
      get_domId90Element().get();

      // Detach section.
      attachRecord1314.detach();
      userContact.addAndReplaceElement(get_f_HTMLPanel28(), get_domId90Element().get());

      owner.userContact = userContact;

      return userContact;
    }

    /**
     * Getter for domId90 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for f_HTMLPanel28 called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel28() {
      return build_f_HTMLPanel28();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel28() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel28 = new com.google.gwt.user.client.ui.HTMLPanel(template_html51().asString());
      // Setup section.
      f_HTMLPanel28.setStyleName("" + get_Settings().settingOneSetOfContactInputContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1315 = UiBinderUtil.attachToDom(f_HTMLPanel28.getElement());
      get_domId91Element().get();
      get_domId92Element().get();
      get_domId93Element().get();

      // Detach section.
      attachRecord1315.detach();
      f_HTMLPanel28.addAndReplaceElement(get_email(), get_domId91Element().get());
      f_HTMLPanel28.addAndReplaceElement(get_lbEmail(), get_domId92Element().get());
      f_HTMLPanel28.addAndReplaceElement(get_emailTextConfirmation(), get_domId93Element().get());

      return f_HTMLPanel28;
    }

    /**
     * Getter for domId91 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for email called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.Label get_email() {
      return build_email();
    }
    private com.google.gwt.user.client.ui.Label build_email() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label email = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      email.setStyleName("" + get_Settings().settingInfoEmailText() + "");


      owner.email = email;

      return email;
    }

    /**
     * Getter for domId91Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId92 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for lbEmail called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private org.ednovo.gooru.client.uc.SettingEmailEditLabelUc get_lbEmail() {
      return build_lbEmail();
    }
    private org.ednovo.gooru.client.uc.SettingEmailEditLabelUc build_lbEmail() {
      // Creation section.
      final org.ednovo.gooru.client.uc.SettingEmailEditLabelUc lbEmail = owner.lbEmail;
      assert lbEmail != null : "UiField lbEmail with 'provided = true' was null";
      // Setup section.
      lbEmail.setStyleName("" + get_Settings().settingOneSetOfLableEmail() + "");


      return lbEmail;
    }

    /**
     * Getter for domId92Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId93 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for emailTextConfirmation called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.Label get_emailTextConfirmation() {
      return build_emailTextConfirmation();
    }
    private com.google.gwt.user.client.ui.Label build_emailTextConfirmation() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label emailTextConfirmation = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      emailTextConfirmation.setStyleName("" + get_Settings().emailSecurityText() + "");


      owner.emailTextConfirmation = emailTextConfirmation;

      return emailTextConfirmation;
    }

    /**
     * Getter for domId93Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId90Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId78Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for f_HTMLPanel29 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel29() {
      return build_f_HTMLPanel29();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel29() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel29 = new com.google.gwt.user.client.ui.HTMLPanel(template_html58().asString());
      // Setup section.
      f_HTMLPanel29.setStyleName("" + get_Settings().settingInfoTitleContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1316 = UiBinderUtil.attachToDom(f_HTMLPanel29.getElement());
      get_domId95Element().get();
      get_domId98Element().get();

      // Detach section.
      attachRecord1316.detach();
      f_HTMLPanel29.addAndReplaceElement(get_plSecurity(), get_domId95Element().get());
      f_HTMLPanel29.addAndReplaceElement(get_userSecurity(), get_domId98Element().get());

      return f_HTMLPanel29;
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
     * Getter for plSecurity called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_plSecurity() {
      return build_plSecurity();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_plSecurity() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel plSecurity = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html56().asString());
      // Setup section.
      plSecurity.setStyleName("" + get_Settings().settingInfoTitleContainerTwo() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1317 = UiBinderUtil.attachToDom(plSecurity.getElement());
      get_domId96Element().get();
      get_domId97Element().get();

      // Detach section.
      attachRecord1317.detach();
      plSecurity.addAndReplaceElement(get_securityText(), get_domId96Element().get());
      plSecurity.addAndReplaceElement(get_securityMiniusArrow(), get_domId97Element().get());

      owner.plSecurity = plSecurity;

      return plSecurity;
    }

    /**
     * Getter for domId96 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for securityText called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_securityText() {
      return build_securityText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_securityText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel securityText = new com.google.gwt.user.client.ui.HTMLPanel(template_html54().asString());
      // Setup section.
      securityText.setStyleName("" + get_Settings().settingInfoTitle() + "");


      owner.securityText = securityText;

      return securityText;
    }

    /**
     * Getter for domId96Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId97 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for securityMiniusArrow called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_securityMiniusArrow() {
      return build_securityMiniusArrow();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_securityMiniusArrow() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel securityMiniusArrow = new com.google.gwt.user.client.ui.HTMLPanel(template_html55().asString());
      // Setup section.
      securityMiniusArrow.setStyleName("" + get_Settings().settingInfoMimiusArrow() + "");
      securityMiniusArrow.setVisible(false);


      owner.securityMiniusArrow = securityMiniusArrow;

      return securityMiniusArrow;
    }

    /**
     * Getter for domId97Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for userSecurity called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_userSecurity() {
      return build_userSecurity();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_userSecurity() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel userSecurity = new com.google.gwt.user.client.ui.HTMLPanel(template_html57().asString());
      // Setup section.
      userSecurity.setStyleName("" + get_Settings().settingHtmlPanel() + "");
      userSecurity.setVisible(false);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1318 = UiBinderUtil.attachToDom(userSecurity.getElement());
      get_domId99Element().get();
      get_domId100Element().get();
      get_domId101Element().get();

      // Detach section.
      attachRecord1318.detach();
      userSecurity.addAndReplaceElement(get_forgetPasswordMsg(), get_domId99Element().get());
      userSecurity.addAndReplaceElement(get_forgetPassword(), get_domId100Element().get());
      userSecurity.addAndReplaceElement(get_lblPleaseWait(), get_domId101Element().get());

      owner.userSecurity = userSecurity;

      return userSecurity;
    }

    /**
     * Getter for domId99 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for forgetPasswordMsg called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Label get_forgetPasswordMsg() {
      return build_forgetPasswordMsg();
    }
    private com.google.gwt.user.client.ui.Label build_forgetPasswordMsg() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label forgetPasswordMsg = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      forgetPasswordMsg.setStyleName("" + get_Settings().settingInfoNameGoogleTextOne() + "");


      owner.forgetPasswordMsg = forgetPasswordMsg;

      return forgetPasswordMsg;
    }

    /**
     * Getter for domId99Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId100 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for forgetPassword called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Label get_forgetPassword() {
      return build_forgetPassword();
    }
    private com.google.gwt.user.client.ui.Label build_forgetPassword() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label forgetPassword = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      forgetPassword.setStyleName("" + get_Settings().settingInfoForgotPassword() + "");
      forgetPassword.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7);


      owner.forgetPassword = forgetPassword;

      return forgetPassword;
    }

    /**
     * Getter for domId100Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId101 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for lblPleaseWait called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Label get_lblPleaseWait() {
      return build_lblPleaseWait();
    }
    private com.google.gwt.user.client.ui.Label build_lblPleaseWait() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblPleaseWait = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblPleaseWait.setStyleName("" + get_Settings().pleaseWait() + "");


      owner.lblPleaseWait = lblPleaseWait;

      return lblPleaseWait;
    }

    /**
     * Getter for domId101Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId102 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for f_HTMLPanel30 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel30() {
      return build_f_HTMLPanel30();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel30() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel30 = new com.google.gwt.user.client.ui.HTMLPanel(template_html70().asString());
      // Setup section.
      f_HTMLPanel30.setStyleName("" + get_Settings().settingInfoTitleContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1319 = UiBinderUtil.attachToDom(f_HTMLPanel30.getElement());
      get_domId103Element().get();
      get_domId113Element().get();

      // Detach section.
      attachRecord1319.detach();
      f_HTMLPanel30.addAndReplaceElement(get_plEducation(), get_domId103Element().get());
      f_HTMLPanel30.addAndReplaceElement(get_userEducation(), get_domId113Element().get());

      return f_HTMLPanel30;
    }

    /**
     * Getter for domId103 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for plEducation called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_plEducation() {
      return build_plEducation();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_plEducation() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel plEducation = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html64().asString());
      // Setup section.
      plEducation.setStyleName("" + get_Settings().settingInfoTitleContainerTwo() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1320 = UiBinderUtil.attachToDom(plEducation.getElement());
      get_domId104Element().get();
      get_domId105Element().get();
      get_domId112Element().get();

      // Detach section.
      attachRecord1320.detach();
      plEducation.addAndReplaceElement(get_settingsinfoText(), get_domId104Element().get());
      plEducation.addAndReplaceElement(get_editButtonContainerEdu(), get_domId105Element().get());
      plEducation.addAndReplaceElement(get_educationalMiniusArrow(), get_domId112Element().get());

      owner.plEducation = plEducation;

      return plEducation;
    }

    /**
     * Getter for domId104 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for settingsinfoText called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_settingsinfoText() {
      return build_settingsinfoText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_settingsinfoText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel settingsinfoText = new com.google.gwt.user.client.ui.HTMLPanel(template_html59().asString());
      // Setup section.
      settingsinfoText.setStyleName("" + get_Settings().settingInfoTitle() + "");


      owner.settingsinfoText = settingsinfoText;

      return settingsinfoText;
    }

    /**
     * Getter for domId104Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId105 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for editButtonContainerEdu called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_editButtonContainerEdu() {
      return build_editButtonContainerEdu();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_editButtonContainerEdu() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel editButtonContainerEdu = new com.google.gwt.user.client.ui.HTMLPanel(template_html62().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1321 = UiBinderUtil.attachToDom(editButtonContainerEdu.getElement());
      get_domId106Element().get();
      get_domId107Element().get();
      get_domId108Element().get();

      // Detach section.
      attachRecord1321.detach();
      editButtonContainerEdu.addAndReplaceElement(get_EduSavingTextLabel(), get_domId106Element().get());
      editButtonContainerEdu.addAndReplaceElement(get_editButtonEdu(), get_domId107Element().get());
      editButtonContainerEdu.addAndReplaceElement(get_EduInfoButtonContainer(), get_domId108Element().get());

      owner.editButtonContainerEdu = editButtonContainerEdu;

      return editButtonContainerEdu;
    }

    /**
     * Getter for domId106 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for EduSavingTextLabel called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.Label get_EduSavingTextLabel() {
      return build_EduSavingTextLabel();
    }
    private com.google.gwt.user.client.ui.Label build_EduSavingTextLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label EduSavingTextLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      EduSavingTextLabel.setStyleName("" + get_Settings().settingInfoText() + "");


      owner.EduSavingTextLabel = EduSavingTextLabel;

      return EduSavingTextLabel;
    }

    /**
     * Getter for domId106Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId107 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for editButtonEdu called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.Button get_editButtonEdu() {
      return build_editButtonEdu();
    }
    private com.google.gwt.user.client.ui.Button build_editButtonEdu() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button editButtonEdu = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      editButtonEdu.setStyleName("" + get_Settings().settingEditButton() + "");


      owner.editButtonEdu = editButtonEdu;

      return editButtonEdu;
    }

    /**
     * Getter for domId107Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId108 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for EduInfoButtonContainer called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_EduInfoButtonContainer() {
      return build_EduInfoButtonContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_EduInfoButtonContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel EduInfoButtonContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html61().asString());
      // Setup section.
      EduInfoButtonContainer.setStyleName("" + get_Settings().settingsPageSaveButtonContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1322 = UiBinderUtil.attachToDom(EduInfoButtonContainer.getElement());
      get_domId109Element().get();

      // Detach section.
      attachRecord1322.detach();
      EduInfoButtonContainer.addAndReplaceElement(get_f_HTMLPanel31(), get_domId109Element().get());

      owner.EduInfoButtonContainer = EduInfoButtonContainer;

      return EduInfoButtonContainer;
    }

    /**
     * Getter for domId109 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 10.
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
     * Getter for f_HTMLPanel31 called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel31() {
      return build_f_HTMLPanel31();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel31() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel31 = new com.google.gwt.user.client.ui.HTMLPanel(template_html60().asString());
      // Setup section.
      f_HTMLPanel31.setStyleName("" + get_Settings().settingsPageSaveProfileButtonCenter() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1323 = UiBinderUtil.attachToDom(f_HTMLPanel31.getElement());
      get_domId110Element().get();
      get_domId111Element().get();

      // Detach section.
      attachRecord1323.detach();
      f_HTMLPanel31.addAndReplaceElement(get_eduInfoCancelButton(), get_domId110Element().get());
      f_HTMLPanel31.addAndReplaceElement(get_eduInfoSaveButton(), get_domId111Element().get());

      return f_HTMLPanel31;
    }

    /**
     * Getter for domId110 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 11.
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
     * Getter for eduInfoCancelButton called 1 times. Type: DEFAULT. Build precedence: 11.
     */
    private com.google.gwt.user.client.ui.Button get_eduInfoCancelButton() {
      return build_eduInfoCancelButton();
    }
    private com.google.gwt.user.client.ui.Button build_eduInfoCancelButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button eduInfoCancelButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      eduInfoCancelButton.setStyleName("" + get_Settings().settingCancelButton() + "");
      eduInfoCancelButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6);


      owner.eduInfoCancelButton = eduInfoCancelButton;

      return eduInfoCancelButton;
    }

    /**
     * Getter for domId110Element called 2 times. Type: DEFAULT. Build precedence: 11.
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
     * Getter for domId111 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 11.
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
     * Getter for eduInfoSaveButton called 1 times. Type: DEFAULT. Build precedence: 11.
     */
    private com.google.gwt.user.client.ui.Button get_eduInfoSaveButton() {
      return build_eduInfoSaveButton();
    }
    private com.google.gwt.user.client.ui.Button build_eduInfoSaveButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button eduInfoSaveButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      eduInfoSaveButton.setStyleName("" + get_Settings().settingsPageSaveProfileButton() + "");
      eduInfoSaveButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5);


      owner.eduInfoSaveButton = eduInfoSaveButton;

      return eduInfoSaveButton;
    }

    /**
     * Getter for domId111Element called 2 times. Type: DEFAULT. Build precedence: 11.
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
     * Getter for domId109Element called 2 times. Type: DEFAULT. Build precedence: 10.
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
     * Getter for domId108Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId105Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId112 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for educationalMiniusArrow called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_educationalMiniusArrow() {
      return build_educationalMiniusArrow();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_educationalMiniusArrow() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel educationalMiniusArrow = new com.google.gwt.user.client.ui.HTMLPanel(template_html63().asString());
      // Setup section.
      educationalMiniusArrow.setStyleName("" + get_Settings().settingInfoMimiusArrow() + "");
      educationalMiniusArrow.setVisible(false);


      owner.educationalMiniusArrow = educationalMiniusArrow;

      return educationalMiniusArrow;
    }

    /**
     * Getter for domId112Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId103Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for userEducation called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_userEducation() {
      return build_userEducation();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_userEducation() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel userEducation = new com.google.gwt.user.client.ui.HTMLPanel(template_html69().asString());
      // Setup section.
      userEducation.setStyleName("" + get_Settings().settingHtmlPanel() + "");
      userEducation.setVisible(false);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1324 = UiBinderUtil.attachToDom(userEducation.getElement());
      get_domId114Element().get();
      get_domId115Element().get();
      get_domId116Element().get();

      // Detach section.
      attachRecord1324.detach();
      userEducation.addAndReplaceElement(get_roleText(), get_domId114Element().get());
      userEducation.addAndReplaceElement(get_lbRole(), get_domId115Element().get());
      userEducation.addAndReplaceElement(get_userCoursePopup(), get_domId116Element().get());

      owner.userEducation = userEducation;

      return userEducation;
    }

    /**
     * Getter for domId114 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for roleText called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Label get_roleText() {
      return build_roleText();
    }
    private com.google.gwt.user.client.ui.Label build_roleText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label roleText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      roleText.setStyleName("" + get_Settings().settingInfoRoleText() + "");


      owner.roleText = roleText;

      return roleText;
    }

    /**
     * Getter for domId114Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId115 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for lbRole called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Label get_lbRole() {
      return build_lbRole();
    }
    private com.google.gwt.user.client.ui.Label build_lbRole() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lbRole = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lbRole.setStyleName("" + get_Settings().settingInfoRoleText() + "");


      owner.lbRole = lbRole;

      return lbRole;
    }

    /**
     * Getter for domId115Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId116 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for userCoursePopup called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_userCoursePopup() {
      return build_userCoursePopup();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_userCoursePopup() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel userCoursePopup = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html68().asString());
      // Setup section.
      userCoursePopup.setStyleName("" + get_Settings().userCoursePopup() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1325 = UiBinderUtil.attachToDom(userCoursePopup.getElement());
      get_domId117Element().get();
      get_domId120Element().get();

      // Detach section.
      attachRecord1325.detach();
      userCoursePopup.addAndReplaceElement(get_f_FlowPanel32(), get_domId117Element().get());
      userCoursePopup.addAndReplaceElement(get_f_FlowPanel36(), get_domId120Element().get());

      owner.userCoursePopup = userCoursePopup;

      return userCoursePopup;
    }

    /**
     * Getter for domId117 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for f_FlowPanel32 called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel32() {
      return build_f_FlowPanel32();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel32() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel32 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel32.add(get_f_FlowPanel33());
      f_FlowPanel32.add(get_DefaultGardeContainer());
      f_FlowPanel32.add(get_gradeContainer());
      f_FlowPanel32.setStyleName("" + get_Settings().settingGradeInfoContainer() + "");


      return f_FlowPanel32;
    }

    /**
     * Getter for f_FlowPanel33 called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel33() {
      return build_f_FlowPanel33();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel33() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel33 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel33.add(get_gradeText());
      f_FlowPanel33.setStyleName("" + get_Settings().settingGradeInfoTitleContainer() + "");


      return f_FlowPanel33;
    }

    /**
     * Getter for gradeText called 1 times. Type: DEFAULT. Build precedence: 11.
     */
    private com.google.gwt.user.client.ui.Label get_gradeText() {
      return build_gradeText();
    }
    private com.google.gwt.user.client.ui.Label build_gradeText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label gradeText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      gradeText.setStyleName("" + get_Settings().settingGradeInfoTitle() + "");


      owner.gradeText = gradeText;

      return gradeText;
    }

    /**
     * Getter for DefaultGardeContainer called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_DefaultGardeContainer() {
      return build_DefaultGardeContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_DefaultGardeContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel DefaultGardeContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html65().asString());
      // Setup section.
      DefaultGardeContainer.setStyleName("" + get_Settings().settingGradeContentContainer() + "");


      owner.DefaultGardeContainer = DefaultGardeContainer;

      return DefaultGardeContainer;
    }

    /**
     * Getter for gradeContainer called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_gradeContainer() {
      return build_gradeContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_gradeContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel gradeContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html66().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1326 = UiBinderUtil.attachToDom(gradeContainer.getElement());
      get_domId118Element().get();
      get_domId119Element().get();

      // Detach section.
      attachRecord1326.detach();
      gradeContainer.addAndReplaceElement(get_gradeLbl(), get_domId118Element().get());
      gradeContainer.addAndReplaceElement(get_f_FlowPanel34(), get_domId119Element().get());

      owner.gradeContainer = gradeContainer;

      return gradeContainer;
    }

    /**
     * Getter for domId118 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 11.
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
     * Getter for gradeLbl called 1 times. Type: DEFAULT. Build precedence: 11.
     */
    private com.google.gwt.user.client.ui.Label get_gradeLbl() {
      return build_gradeLbl();
    }
    private com.google.gwt.user.client.ui.Label build_gradeLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label gradeLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      gradeLbl.setStyleName("" + get_Settings().settingGradeTitleLabel() + "");


      owner.gradeLbl = gradeLbl;

      return gradeLbl;
    }

    /**
     * Getter for domId118Element called 2 times. Type: DEFAULT. Build precedence: 11.
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
     * Getter for domId119 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 11.
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
     * Getter for f_FlowPanel34 called 1 times. Type: DEFAULT. Build precedence: 11.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel34() {
      return build_f_FlowPanel34();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel34() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel34 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel34.add(get_KinderGarten());
      f_FlowPanel34.add(get_f_FlowPanel35());
      f_FlowPanel34.add(get_higherEducation());
      f_FlowPanel34.setStyleName("" + get_Settings().settingGradeContentContainer() + "");


      return f_FlowPanel34;
    }

    /**
     * Getter for KinderGarten called 1 times. Type: DEFAULT. Build precedence: 12.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_KinderGarten() {
      return build_KinderGarten();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_KinderGarten() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel KinderGarten = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      KinderGarten.setStyleName("" + get_Settings().settingGradeGartenContainer() + "");


      owner.KinderGarten = KinderGarten;

      return KinderGarten;
    }

    /**
     * Getter for f_FlowPanel35 called 1 times. Type: DEFAULT. Build precedence: 12.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel35() {
      return build_f_FlowPanel35();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel35() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel35 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel35.add(get_gradeTopList());
      f_FlowPanel35.add(get_gradeMiddleList());
      f_FlowPanel35.setStyleName("" + get_ccb().css().gradeListCont() + "");


      return f_FlowPanel35;
    }

    /**
     * Getter for gradeTopList called 1 times. Type: DEFAULT. Build precedence: 13.
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
     * Getter for gradeMiddleList called 1 times. Type: DEFAULT. Build precedence: 13.
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
     * Getter for higherEducation called 1 times. Type: DEFAULT. Build precedence: 12.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_higherEducation() {
      return build_higherEducation();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_higherEducation() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel higherEducation = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      higherEducation.setStyleName("" + get_Settings().settingGradeGartenContainer() + "");


      owner.higherEducation = higherEducation;

      return higherEducation;
    }

    /**
     * Getter for domId119Element called 2 times. Type: DEFAULT. Build precedence: 11.
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
     * Getter for domId117Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId120 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for f_FlowPanel36 called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel36() {
      return build_f_FlowPanel36();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel36() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel36 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel36.add(get_f_FlowPanel37());
      f_FlowPanel36.add(get_collectionCourseDefaultLstPanel());
      f_FlowPanel36.add(get_courseContainer());
      f_FlowPanel36.setStyleName("" + get_Settings().settingGradeInfoContainer() + "");


      return f_FlowPanel36;
    }

    /**
     * Getter for f_FlowPanel37 called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel37() {
      return build_f_FlowPanel37();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel37() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel37 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel37.add(get_courseLabel());
      f_FlowPanel37.setStyleName("" + get_Settings().settingCourseInfoTitleContainer() + "");


      return f_FlowPanel37;
    }

    /**
     * Getter for courseLabel called 1 times. Type: DEFAULT. Build precedence: 11.
     */
    private com.google.gwt.user.client.ui.Label get_courseLabel() {
      return build_courseLabel();
    }
    private com.google.gwt.user.client.ui.Label build_courseLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label courseLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      courseLabel.setStyleName("" + get_Settings().settingCourseInfoTitle() + "");


      owner.courseLabel = courseLabel;

      return courseLabel;
    }

    /**
     * Getter for collectionCourseDefaultLstPanel called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_collectionCourseDefaultLstPanel() {
      return build_collectionCourseDefaultLstPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_collectionCourseDefaultLstPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel collectionCourseDefaultLstPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      collectionCourseDefaultLstPanel.setStyleName("" + get_Settings().addedCoursesList() + "");


      owner.collectionCourseDefaultLstPanel = collectionCourseDefaultLstPanel;

      return collectionCourseDefaultLstPanel;
    }

    /**
     * Getter for courseContainer called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_courseContainer() {
      return build_courseContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_courseContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel courseContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html67().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1327 = UiBinderUtil.attachToDom(courseContainer.getElement());
      get_domId121Element().get();
      get_domId122Element().get();
      get_domId123Element().get();

      // Detach section.
      attachRecord1327.detach();
      courseContainer.addAndReplaceElement(get_courseLbl(), get_domId121Element().get());
      courseContainer.addAndReplaceElement(get_courseData(), get_domId122Element().get());
      courseContainer.addAndReplaceElement(get_coursesPanel(), get_domId123Element().get());

      owner.courseContainer = courseContainer;

      return courseContainer;
    }

    /**
     * Getter for domId121 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 11.
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
     * Getter for courseLbl called 1 times. Type: DEFAULT. Build precedence: 11.
     */
    private com.google.gwt.user.client.ui.Label get_courseLbl() {
      return build_courseLbl();
    }
    private com.google.gwt.user.client.ui.Label build_courseLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label courseLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      courseLbl.setStyleName("" + get_Settings().settingCourseTitleLabel() + "");


      owner.courseLbl = courseLbl;

      return courseLbl;
    }

    /**
     * Getter for domId121Element called 2 times. Type: DEFAULT. Build precedence: 11.
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
     * Getter for domId122 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 11.
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
     * Getter for courseData called 1 times. Type: DEFAULT. Build precedence: 11.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_courseData() {
      return build_courseData();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_courseData() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel courseData = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      courseData.add(get_collectionCourseLstPanel());
      courseData.add(get_courseMaxMsg());
      courseData.setStyleName("" + get_ccb().css().floatLeftCollectionInputBox() + "");


      owner.courseData = courseData;

      return courseData;
    }

    /**
     * Getter for collectionCourseLstPanel called 1 times. Type: DEFAULT. Build precedence: 12.
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
     * Getter for courseMaxMsg called 1 times. Type: DEFAULT. Build precedence: 12.
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
     * Getter for domId122Element called 2 times. Type: DEFAULT. Build precedence: 11.
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
     * Getter for domId123 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 11.
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
     * Getter for coursesPanel called 1 times. Type: DEFAULT. Build precedence: 11.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_coursesPanel() {
      return build_coursesPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_coursesPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel coursesPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      coursesPanel.setStyleName("" + get_Settings().addedCoursesList() + "");


      owner.coursesPanel = coursesPanel;

      return coursesPanel;
    }

    /**
     * Getter for domId123Element called 2 times. Type: DEFAULT. Build precedence: 11.
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
     * Getter for domId120Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId116Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId102Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId124 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for f_HTMLPanel38 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel38() {
      return build_f_HTMLPanel38();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel38() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel38 = new com.google.gwt.user.client.ui.HTMLPanel(template_html80().asString());
      // Setup section.
      f_HTMLPanel38.setStyleName("" + get_Settings().settingInfoTitleOneContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1328 = UiBinderUtil.attachToDom(f_HTMLPanel38.getElement());
      get_domId125Element().get();
      get_domId134Element().get();
      get_domId140Element().get();

      // Detach section.
      attachRecord1328.detach();
      f_HTMLPanel38.addAndReplaceElement(get_panelStandards(), get_domId125Element().get());
      f_HTMLPanel38.addAndReplaceElement(get_userStandardDefaultView(), get_domId134Element().get());
      f_HTMLPanel38.addAndReplaceElement(get_userStandardEditView(), get_domId140Element().get());

      return f_HTMLPanel38;
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
     * Getter for panelStandards called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_panelStandards() {
      return build_panelStandards();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_panelStandards() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel panelStandards = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html75().asString());
      // Setup section.
      panelStandards.setStyleName("" + get_Settings().settingInfoTitleContainerTwo() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1329 = UiBinderUtil.attachToDom(panelStandards.getElement());
      get_domId126Element().get();
      get_domId127Element().get();

      // Detach section.
      attachRecord1329.detach();
      panelStandards.addAndReplaceElement(get_standardsText(), get_domId126Element().get());
      panelStandards.addAndReplaceElement(get_standardsEditButtonContainer(), get_domId127Element().get());

      owner.panelStandards = panelStandards;

      return panelStandards;
    }

    /**
     * Getter for domId126 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for standardsText called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_standardsText() {
      return build_standardsText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_standardsText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel standardsText = new com.google.gwt.user.client.ui.HTMLPanel(template_html71().asString());
      // Setup section.
      standardsText.setStyleName("" + get_Settings().settingInfoTitle() + "");


      owner.standardsText = standardsText;

      return standardsText;
    }

    /**
     * Getter for domId126Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId127 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for standardsEditButtonContainer called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_standardsEditButtonContainer() {
      return build_standardsEditButtonContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_standardsEditButtonContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel standardsEditButtonContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html74().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1330 = UiBinderUtil.attachToDom(standardsEditButtonContainer.getElement());
      get_domId128Element().get();
      get_domId129Element().get();
      get_domId130Element().get();

      // Detach section.
      attachRecord1330.detach();
      standardsEditButtonContainer.addAndReplaceElement(get_standardsEditButton(), get_domId128Element().get());
      standardsEditButtonContainer.addAndReplaceElement(get_standardSavingTextLabel(), get_domId129Element().get());
      standardsEditButtonContainer.addAndReplaceElement(get_standardsButtonContainer(), get_domId130Element().get());

      return standardsEditButtonContainer;
    }

    /**
     * Getter for domId128 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for standardsEditButton called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.Button get_standardsEditButton() {
      return build_standardsEditButton();
    }
    private com.google.gwt.user.client.ui.Button build_standardsEditButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button standardsEditButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      standardsEditButton.setStyleName("" + get_Settings().settingEditButton() + "");
      standardsEditButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8);


      owner.standardsEditButton = standardsEditButton;

      return standardsEditButton;
    }

    /**
     * Getter for domId128Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId129 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for standardSavingTextLabel called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.Label get_standardSavingTextLabel() {
      return build_standardSavingTextLabel();
    }
    private com.google.gwt.user.client.ui.Label build_standardSavingTextLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label standardSavingTextLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      standardSavingTextLabel.setStyleName("" + get_Settings().settingInfoText() + "");


      owner.standardSavingTextLabel = standardSavingTextLabel;

      return standardSavingTextLabel;
    }

    /**
     * Getter for domId129Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId130 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for standardsButtonContainer called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_standardsButtonContainer() {
      return build_standardsButtonContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_standardsButtonContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel standardsButtonContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html73().asString());
      // Setup section.
      standardsButtonContainer.setStyleName("" + get_Settings().settingsPageSaveButtonContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1331 = UiBinderUtil.attachToDom(standardsButtonContainer.getElement());
      get_domId131Element().get();

      // Detach section.
      attachRecord1331.detach();
      standardsButtonContainer.addAndReplaceElement(get_standardsSaveCancelButtonContainer(), get_domId131Element().get());

      return standardsButtonContainer;
    }

    /**
     * Getter for domId131 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 10.
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
     * Getter for standardsSaveCancelButtonContainer called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_standardsSaveCancelButtonContainer() {
      return build_standardsSaveCancelButtonContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_standardsSaveCancelButtonContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel standardsSaveCancelButtonContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html72().asString());
      // Setup section.
      standardsSaveCancelButtonContainer.setStyleName("" + get_Settings().settingsPageSaveProfileButtonCenter() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1332 = UiBinderUtil.attachToDom(standardsSaveCancelButtonContainer.getElement());
      get_domId132Element().get();
      get_domId133Element().get();

      // Detach section.
      attachRecord1332.detach();
      standardsSaveCancelButtonContainer.addAndReplaceElement(get_standardsCancelButton(), get_domId132Element().get());
      standardsSaveCancelButtonContainer.addAndReplaceElement(get_standardsSaveButton(), get_domId133Element().get());

      owner.standardsSaveCancelButtonContainer = standardsSaveCancelButtonContainer;

      return standardsSaveCancelButtonContainer;
    }

    /**
     * Getter for domId132 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 11.
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
     * Getter for standardsCancelButton called 1 times. Type: DEFAULT. Build precedence: 11.
     */
    private com.google.gwt.user.client.ui.Button get_standardsCancelButton() {
      return build_standardsCancelButton();
    }
    private com.google.gwt.user.client.ui.Button build_standardsCancelButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button standardsCancelButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      standardsCancelButton.setStyleName("" + get_Settings().settingCancelButton() + "");
      standardsCancelButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames10);


      owner.standardsCancelButton = standardsCancelButton;

      return standardsCancelButton;
    }

    /**
     * Getter for domId132Element called 2 times. Type: DEFAULT. Build precedence: 11.
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
     * Getter for domId133 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 11.
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
     * Getter for standardsSaveButton called 1 times. Type: DEFAULT. Build precedence: 11.
     */
    private com.google.gwt.user.client.ui.Button get_standardsSaveButton() {
      return build_standardsSaveButton();
    }
    private com.google.gwt.user.client.ui.Button build_standardsSaveButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button standardsSaveButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      standardsSaveButton.setStyleName("primary");
      standardsSaveButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames9);


      owner.standardsSaveButton = standardsSaveButton;

      return standardsSaveButton;
    }

    /**
     * Getter for domId133Element called 2 times. Type: DEFAULT. Build precedence: 11.
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
     * Getter for domId131Element called 2 times. Type: DEFAULT. Build precedence: 10.
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
     * Getter for domId130Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId127Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId134 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for userStandardDefaultView called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_userStandardDefaultView() {
      return build_userStandardDefaultView();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_userStandardDefaultView() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel userStandardDefaultView = new com.google.gwt.user.client.ui.HTMLPanel(template_html77().asString());
      // Setup section.
      userStandardDefaultView.setStyleName("" + get_Settings().settingHtmlPanel() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1333 = UiBinderUtil.attachToDom(userStandardDefaultView.getElement());
      get_domId135Element().get();

      // Detach section.
      attachRecord1333.detach();
      userStandardDefaultView.addAndReplaceElement(get_f_HTMLPanel39(), get_domId135Element().get());

      owner.userStandardDefaultView = userStandardDefaultView;

      return userStandardDefaultView;
    }

    /**
     * Getter for domId135 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for f_HTMLPanel39 called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel39() {
      return build_f_HTMLPanel39();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel39() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel39 = new com.google.gwt.user.client.ui.HTMLPanel(template_html76().asString());
      // Setup section.
      f_HTMLPanel39.setStyleName("" + get_Settings().settingOneSetOfStandardInputContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1334 = UiBinderUtil.attachToDom(f_HTMLPanel39.getElement());
      get_domId136Element().get();
      get_domId137Element().get();
      get_domId138Element().get();
      get_domId139Element().get();

      // Detach section.
      attachRecord1334.detach();
      f_HTMLPanel39.addAndReplaceElement(get_lblCommonCore(), get_domId136Element().get());
      f_HTMLPanel39.addAndReplaceElement(get_lblCaliforniaScience(), get_domId137Element().get());
      f_HTMLPanel39.addAndReplaceElement(get_lblTexas(), get_domId138Element().get());
      f_HTMLPanel39.addAndReplaceElement(get_lblUserMessage(), get_domId139Element().get());

      return f_HTMLPanel39;
    }

    /**
     * Getter for domId136 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for lblCommonCore called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.Label get_lblCommonCore() {
      return build_lblCommonCore();
    }
    private com.google.gwt.user.client.ui.Label build_lblCommonCore() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblCommonCore = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblCommonCore.setStyleName("" + get_Settings().standardsText() + "");


      owner.lblCommonCore = lblCommonCore;

      return lblCommonCore;
    }

    /**
     * Getter for domId136Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId137 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for lblCaliforniaScience called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.Label get_lblCaliforniaScience() {
      return build_lblCaliforniaScience();
    }
    private com.google.gwt.user.client.ui.Label build_lblCaliforniaScience() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblCaliforniaScience = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblCaliforniaScience.setStyleName("" + get_Settings().standardsText() + "");


      owner.lblCaliforniaScience = lblCaliforniaScience;

      return lblCaliforniaScience;
    }

    /**
     * Getter for domId137Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId138 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
     */
    private java.lang.String domId138;
    private java.lang.String get_domId138() {
      return domId138;
    }
    private java.lang.String build_domId138() {
      // Creation section.
      domId138 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId138;
    }

    /**
     * Getter for lblTexas called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.Label get_lblTexas() {
      return build_lblTexas();
    }
    private com.google.gwt.user.client.ui.Label build_lblTexas() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblTexas = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblTexas.setStyleName("" + get_Settings().standardsText() + "");


      owner.lblTexas = lblTexas;

      return lblTexas;
    }

    /**
     * Getter for domId138Element called 2 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId138Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId138Element() {
      return domId138Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId138Element() {
      // Creation section.
      domId138Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId138());
      // Setup section.


      return domId138Element;
    }

    /**
     * Getter for domId139 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
     */
    private java.lang.String domId139;
    private java.lang.String get_domId139() {
      return domId139;
    }
    private java.lang.String build_domId139() {
      // Creation section.
      domId139 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId139;
    }

    /**
     * Getter for lblUserMessage called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.Label get_lblUserMessage() {
      return build_lblUserMessage();
    }
    private com.google.gwt.user.client.ui.Label build_lblUserMessage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblUserMessage = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblUserMessage.setStyleName("" + get_Settings().defaultTextcss() + "");


      owner.lblUserMessage = lblUserMessage;

      return lblUserMessage;
    }

    /**
     * Getter for domId139Element called 2 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId139Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId139Element() {
      return domId139Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId139Element() {
      // Creation section.
      domId139Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId139());
      // Setup section.


      return domId139Element;
    }

    /**
     * Getter for domId135Element called 2 times. Type: DEFAULT. Build precedence: 8.
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

    /**
     * Getter for domId134Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId140 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId140;
    private java.lang.String get_domId140() {
      return domId140;
    }
    private java.lang.String build_domId140() {
      // Creation section.
      domId140 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId140;
    }

    /**
     * Getter for userStandardEditView called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_userStandardEditView() {
      return build_userStandardEditView();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_userStandardEditView() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel userStandardEditView = new com.google.gwt.user.client.ui.HTMLPanel(template_html79().asString());
      // Setup section.
      userStandardEditView.setStyleName("" + get_Settings().settingHtmlPanel() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1335 = UiBinderUtil.attachToDom(userStandardEditView.getElement());
      get_domId141Element().get();
      get_domId142Element().get();

      // Detach section.
      attachRecord1335.detach();
      userStandardEditView.addAndReplaceElement(get_description(), get_domId141Element().get());
      userStandardEditView.addAndReplaceElement(get_userStandardTextPanel(), get_domId142Element().get());

      owner.userStandardEditView = userStandardEditView;

      return userStandardEditView;
    }

    /**
     * Getter for domId141 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
     */
    private java.lang.String domId141;
    private java.lang.String get_domId141() {
      return domId141;
    }
    private java.lang.String build_domId141() {
      // Creation section.
      domId141 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId141;
    }

    /**
     * Getter for description called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Label get_description() {
      return build_description();
    }
    private com.google.gwt.user.client.ui.Label build_description() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label description = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      description.setStyleName("" + get_Settings().standardsTextDescription() + "");


      owner.description = description;

      return description;
    }

    /**
     * Getter for domId141Element called 2 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId141Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId141Element() {
      return domId141Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId141Element() {
      // Creation section.
      domId141Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId141());
      // Setup section.


      return domId141Element;
    }

    /**
     * Getter for domId142 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
     */
    private java.lang.String domId142;
    private java.lang.String get_domId142() {
      return domId142;
    }
    private java.lang.String build_domId142() {
      // Creation section.
      domId142 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId142;
    }

    /**
     * Getter for userStandardTextPanel called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_userStandardTextPanel() {
      return build_userStandardTextPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_userStandardTextPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel userStandardTextPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html78().asString());
      // Setup section.
      userStandardTextPanel.setStyleName("" + get_Settings().settingOneSetOfStandardInputContainer() + "");


      owner.userStandardTextPanel = userStandardTextPanel;

      return userStandardTextPanel;
    }

    /**
     * Getter for domId142Element called 2 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId142Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId142Element() {
      return domId142Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId142Element() {
      // Creation section.
      domId142Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId142());
      // Setup section.


      return domId142Element;
    }

    /**
     * Getter for domId140Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId140Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId140Element() {
      return domId140Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId140Element() {
      // Creation section.
      domId140Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId140());
      // Setup section.


      return domId140Element;
    }

    /**
     * Getter for domId124Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId30Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId29Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId143 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
     */
    private java.lang.String domId143;
    private java.lang.String get_domId143() {
      return domId143;
    }
    private java.lang.String build_domId143() {
      // Creation section.
      domId143 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId143;
    }

    /**
     * Getter for f_FooterUc40 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.mvp.home.FooterUc get_f_FooterUc40() {
      return build_f_FooterUc40();
    }
    private org.ednovo.gooru.client.mvp.home.FooterUc build_f_FooterUc40() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.home.FooterUc f_FooterUc40 = (org.ednovo.gooru.client.mvp.home.FooterUc) GWT.create(org.ednovo.gooru.client.mvp.home.FooterUc.class);
      // Setup section.


      return f_FooterUc40;
    }

    /**
     * Getter for domId143Element called 2 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId143Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId143Element() {
      return domId143Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId143Element() {
      // Creation section.
      domId143Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId143());
      // Setup section.


      return domId143Element;
    }
  }
}
