package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item;

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

public class EditResourcePopupVc_EditResourcePopupVcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.EditResourcePopupVc>, org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.EditResourcePopupVc.EditResourcePopupVcUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html2(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html3(String arg0, String arg1, String arg2);
     
    @Template("")
    SafeHtml html4();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html5(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html6(String arg0, String arg1, String arg2, String arg3);
     
    @Template("")
    SafeHtml html7();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html8(String arg0);
     
    @Template("")
    SafeHtml html9();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html10(String arg0, String arg1, String arg2, String arg3);
     
    @Template("")
    SafeHtml html11();
     
    @Template("")
    SafeHtml html12();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html13(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html14(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html15(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html16(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html17(String arg0, String arg1);
     
    @Template("")
    SafeHtml html18();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html19(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html20(String arg0);
     
    @Template("")
    SafeHtml html21();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html22(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html23(String arg0);
     
    @Template("")
    SafeHtml html24();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html25(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html26(String arg0);
     
    @Template("")
    SafeHtml html27();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html28(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html29(String arg0);
     
    @Template("")
    SafeHtml html30();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html31(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html32(String arg0);
     
    @Template("")
    SafeHtml html33();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html34(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html35(String arg0);
     
    @Template("")
    SafeHtml html36();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html37(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html38(String arg0);
     
    @Template("")
    SafeHtml html39();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html40(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html41(String arg0);
     
    @Template("")
    SafeHtml html42();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html43(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html44(String arg0);
     
    @Template("")
    SafeHtml html45();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html46(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html47(String arg0);
     
    @Template("")
    SafeHtml html48();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html49(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html50(String arg0);
     
    @Template("")
    SafeHtml html51();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html52(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html53(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span> <span id='{5}'></span>")
    SafeHtml html54(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html55(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html56(String arg0, String arg1, String arg2);
     
    @Template("")
    SafeHtml html57();
     
    @Template("")
    SafeHtml html58();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html59(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html60(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html61(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html62(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html63(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html64(String arg0, String arg1);
     
    @Template("")
    SafeHtml html65();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html66(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html67(String arg0);
     
    @Template("")
    SafeHtml html68();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html69(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html70(String arg0);
     
    @Template("")
    SafeHtml html71();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html72(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html73(String arg0);
     
    @Template("")
    SafeHtml html74();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html75(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html76(String arg0);
     
    @Template("")
    SafeHtml html77();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html78(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html79(String arg0);
     
    @Template("")
    SafeHtml html80();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html81(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html82(String arg0);
     
    @Template("")
    SafeHtml html83();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html84(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html85(String arg0);
     
    @Template("")
    SafeHtml html86();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html87(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html88(String arg0);
     
    @Template("")
    SafeHtml html89();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html90(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html91(String arg0);
     
    @Template("")
    SafeHtml html92();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html93(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html94(String arg0);
     
    @Template("")
    SafeHtml html95();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html96(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html97(String arg0);
     
    @Template("")
    SafeHtml html98();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html99(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html100(String arg0);
     
    @Template("")
    SafeHtml html101();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html102(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html103(String arg0);
     
    @Template("")
    SafeHtml html104();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html105(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html106(String arg0);
     
    @Template("")
    SafeHtml html107();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html108(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html109(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span> <span id='{5}'></span> <span id='{6}'></span> <span id='{7}'></span> <span id='{8}'></span> <span id='{9}'></span> <span id='{10}'></span> <span id='{11}'></span> <span id='{12}'></span> <span id='{13}'></span> <span id='{14}'></span>")
    SafeHtml html110(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html111(String arg0);
     
    @Template("")
    SafeHtml html112();
     
    @Template("")
    SafeHtml html113();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html114(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html115(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html116(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html117(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html118(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html119(String arg0, String arg1);
     
    @Template("")
    SafeHtml html120();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html121(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html122(String arg0);
     
    @Template("")
    SafeHtml html123();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html124(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html125(String arg0);
     
    @Template("")
    SafeHtml html126();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html127(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html128(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html129(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html130(String arg0);
     
    @Template("")
    SafeHtml html131();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html132(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html133(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html134(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html135(String arg0, String arg1, String arg2);
     
    @Template("")
    SafeHtml html136();
     
    @Template("")
    SafeHtml html137();
     
    @Template("")
    SafeHtml html138();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html139(String arg0);
     
    @Template("")
    SafeHtml html140();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html141(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html142(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span> <span id='{5}'></span> <span id='{6}'></span>")
    SafeHtml html143(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6);
     
    @Template("")
    SafeHtml html144();
     
    @Template("")
    SafeHtml html145();
     
    @Template("")
    SafeHtml html146();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>,<span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span> <span id='{5}'></span> <span id='{6}'></span>")
    SafeHtml html147(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html148(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html149(String arg0, String arg1, String arg2, String arg3);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html150(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html151(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html152(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>  <span id='{4}'></span> <span id='{5}'></span>   <span id='{6}'></span> <span id='{7}'></span>   <span id='{8}'></span>  <span id='{9}'></span> <span id='{10}'></span>  <span id='{11}'></span> <span id='{12}'></span>")
    SafeHtml html153(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.EditResourcePopupVc owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.EditResourcePopupVc owner;


    final com.google.gwt.event.dom.client.MouseOverHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.MouseOverHandler() {
      public void onMouseOver(com.google.gwt.event.dom.client.MouseOverEvent event) {
        owner.onMouseOver(event);
      }
    };

    final com.google.gwt.event.dom.client.MouseOutHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.MouseOutHandler() {
      public void onMouseOut(com.google.gwt.event.dom.client.MouseOutEvent event) {
        owner.onMouseOut(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.cancelPopUp(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.leftArrowClick(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.rightArrowClick(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.videoResourcePanel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.interactiveResourcePanel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.websiteResourcePanel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames9 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.slideResourcePanel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames10 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.handoutResourcePanel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames11 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.textbookResourcePanel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames12 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.dropDownClick(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames13 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.refreshClick(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames14 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.activityPanel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames15 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.handoutPanel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames16 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.homeworkPanel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames17 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.gamePanel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames18 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.presentationPanel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames19 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.referenceMaterialPanel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames20 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.quizPanel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames21 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.curriculumPlanPanel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames22 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.lessonPlanPanel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames23 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.unitPlanPanel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames24 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.projectPlanPanel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames25 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.readingPanel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames26 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.textbookPanel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames27 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.articlePanel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames28 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.bookPanel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames29 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.educationalDropDownClick(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames30 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.preparingTheLearningPanel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames31 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.interactingWithTheTextPanel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames32 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.extendingUnderstandingPanel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames33 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.momentsOfLearningDropDownClick(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.EditResourcePopupVc owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_res1();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_domId34();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId40();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId46();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId52();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId58();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId64();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 9
      build_domId33();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId39();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId45();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId51();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId57();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId63();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId23();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId24();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId32();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId35();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId38();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId41();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId44();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId47();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId50();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId53();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId56();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId59();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId62();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId65();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId72();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId73();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId130();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId131();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId176();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId177();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId178();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId179();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId180();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId181();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId182();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId22();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId26();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId31();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId37();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId43();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId49();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId55();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId61();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId71();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId75();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId81();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId84();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId87();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId90();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId93();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId96();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId99();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId102();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId105();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId108();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId111();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId114();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId117();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId120();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId123();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId129();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId133();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId139();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId142();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId145();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId164();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId175();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId21();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId25();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId30();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId36();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId42();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId48();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId54();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId60();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId70();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId74();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId80();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId83();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId86();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId89();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId92();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId95();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId98();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId101();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId104();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId107();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId110();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId113();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId116();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId119();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId122();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId128();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId132();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId138();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId141();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId144();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId151();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId153();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId155();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId156();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId163();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId165();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId171();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId172();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId173();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId174();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId14();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId20();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId27();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId29();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId69();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId76();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId79();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId82();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId85();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId88();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId91();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId94();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId97();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId100();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId103();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId106();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId109();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId112();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId115();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId118();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId121();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId127();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId134();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId137();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId140();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId143();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId150();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId152();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId154();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId162();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId170();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId15();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId16();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId18();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId19();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId28();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId67();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId68();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId78();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId125();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId126();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId136();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId148();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId149();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId157();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId158();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId159();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId160();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId161();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId167();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId168();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId169();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId184();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId185();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId17();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId66();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId77();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId124();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId135();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId146();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId147();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId166();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId183();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId186();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId34Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId40Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId46Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId52Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId58Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId64Element();  // more than one getter call detected. Type: DEFAULT, precedence: 9
      build_domId33Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId39Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId45Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId51Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId57Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId63Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId23Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId24Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId32Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId35Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId38Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId41Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId44Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId47Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId50Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId53Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId56Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId59Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId62Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId65Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId72Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId73Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId130Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId131Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId176Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId177Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId178Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId179Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId180Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId181Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId182Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId22Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId26Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId31Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId37Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId43Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId49Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId55Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId61Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId71Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId75Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId81Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId84Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId87Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId90Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId93Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId96Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId99Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId102Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId105Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId108Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId111Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId114Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId117Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId120Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId123Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId129Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId133Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId139Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId142Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId145Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId164Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId175Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId21Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId25Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId30Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId36Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId42Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId48Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId54Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId60Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId70Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId74Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId80Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId83Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId86Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId89Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId92Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId95Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId98Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId101Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId104Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId107Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId110Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId113Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId116Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId119Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId122Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId128Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId132Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId138Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId141Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId144Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId151Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId153Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId155Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId156Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId163Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId165Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId171Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId172Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId173Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId174Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId14Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId20Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId27Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId29Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId69Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId76Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId79Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId82Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId85Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId88Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId91Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId94Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId97Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId100Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId103Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId106Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId109Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId112Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId115Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId118Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId121Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId127Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId134Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId137Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId140Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId143Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId150Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId152Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId154Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId162Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId170Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId15Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId16Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId18Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId19Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId28Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId67Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId68Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId78Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId125Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId126Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId136Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId148Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId149Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId157Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId158Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId159Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId160Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId161Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId167Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId168Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId169Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId184Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId185Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId17Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId66Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId77Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId124Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId135Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId146Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId147Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId166Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId183Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId186Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2(get_domId3());
    }
    SafeHtml template_html3() {
      return template.html3(get_domId1(), get_domId2(), get_domId4());
    }
    SafeHtml template_html4() {
      return template.html4();
    }
    SafeHtml template_html5() {
      return template.html5(get_domId8());
    }
    SafeHtml template_html6() {
      return template.html6(get_domId6(), get_domId7(), get_domId9(), get_domId10());
    }
    SafeHtml template_html7() {
      return template.html7();
    }
    SafeHtml template_html8() {
      return template.html8(get_domId14());
    }
    SafeHtml template_html9() {
      return template.html9();
    }
    SafeHtml template_html10() {
      return template.html10(get_domId12(), get_domId13(), get_domId15(), get_domId16());
    }
    SafeHtml template_html11() {
      return template.html11();
    }
    SafeHtml template_html12() {
      return template.html12();
    }
    SafeHtml template_html13() {
      return template.html13(get_domId23(), get_domId24());
    }
    SafeHtml template_html14() {
      return template.html14(get_domId22());
    }
    SafeHtml template_html15() {
      return template.html15(get_domId26());
    }
    SafeHtml template_html16() {
      return template.html16(get_domId21(), get_domId25());
    }
    SafeHtml template_html17() {
      return template.html17(get_domId20(), get_domId27());
    }
    SafeHtml template_html18() {
      return template.html18();
    }
    SafeHtml template_html19() {
      return template.html19(get_domId34());
    }
    SafeHtml template_html20() {
      return template.html20(get_domId33());
    }
    SafeHtml template_html21() {
      return template.html21();
    }
    SafeHtml template_html22() {
      return template.html22(get_domId32(), get_domId35());
    }
    SafeHtml template_html23() {
      return template.html23(get_domId31());
    }
    SafeHtml template_html24() {
      return template.html24();
    }
    SafeHtml template_html25() {
      return template.html25(get_domId40());
    }
    SafeHtml template_html26() {
      return template.html26(get_domId39());
    }
    SafeHtml template_html27() {
      return template.html27();
    }
    SafeHtml template_html28() {
      return template.html28(get_domId38(), get_domId41());
    }
    SafeHtml template_html29() {
      return template.html29(get_domId37());
    }
    SafeHtml template_html30() {
      return template.html30();
    }
    SafeHtml template_html31() {
      return template.html31(get_domId46());
    }
    SafeHtml template_html32() {
      return template.html32(get_domId45());
    }
    SafeHtml template_html33() {
      return template.html33();
    }
    SafeHtml template_html34() {
      return template.html34(get_domId44(), get_domId47());
    }
    SafeHtml template_html35() {
      return template.html35(get_domId43());
    }
    SafeHtml template_html36() {
      return template.html36();
    }
    SafeHtml template_html37() {
      return template.html37(get_domId52());
    }
    SafeHtml template_html38() {
      return template.html38(get_domId51());
    }
    SafeHtml template_html39() {
      return template.html39();
    }
    SafeHtml template_html40() {
      return template.html40(get_domId50(), get_domId53());
    }
    SafeHtml template_html41() {
      return template.html41(get_domId49());
    }
    SafeHtml template_html42() {
      return template.html42();
    }
    SafeHtml template_html43() {
      return template.html43(get_domId58());
    }
    SafeHtml template_html44() {
      return template.html44(get_domId57());
    }
    SafeHtml template_html45() {
      return template.html45();
    }
    SafeHtml template_html46() {
      return template.html46(get_domId56(), get_domId59());
    }
    SafeHtml template_html47() {
      return template.html47(get_domId55());
    }
    SafeHtml template_html48() {
      return template.html48();
    }
    SafeHtml template_html49() {
      return template.html49(get_domId64());
    }
    SafeHtml template_html50() {
      return template.html50(get_domId63());
    }
    SafeHtml template_html51() {
      return template.html51();
    }
    SafeHtml template_html52() {
      return template.html52(get_domId62(), get_domId65());
    }
    SafeHtml template_html53() {
      return template.html53(get_domId61());
    }
    SafeHtml template_html54() {
      return template.html54(get_domId30(), get_domId36(), get_domId42(), get_domId48(), get_domId54(), get_domId60());
    }
    SafeHtml template_html55() {
      return template.html55(get_domId29());
    }
    SafeHtml template_html56() {
      return template.html56(get_domId18(), get_domId19(), get_domId28());
    }
    SafeHtml template_html57() {
      return template.html57();
    }
    SafeHtml template_html58() {
      return template.html58();
    }
    SafeHtml template_html59() {
      return template.html59(get_domId72(), get_domId73());
    }
    SafeHtml template_html60() {
      return template.html60(get_domId71());
    }
    SafeHtml template_html61() {
      return template.html61(get_domId75());
    }
    SafeHtml template_html62() {
      return template.html62(get_domId70(), get_domId74());
    }
    SafeHtml template_html63() {
      return template.html63(get_domId69(), get_domId76());
    }
    SafeHtml template_html64() {
      return template.html64(get_domId67(), get_domId68());
    }
    SafeHtml template_html65() {
      return template.html65();
    }
    SafeHtml template_html66() {
      return template.html66(get_domId81());
    }
    SafeHtml template_html67() {
      return template.html67(get_domId80());
    }
    SafeHtml template_html68() {
      return template.html68();
    }
    SafeHtml template_html69() {
      return template.html69(get_domId84());
    }
    SafeHtml template_html70() {
      return template.html70(get_domId83());
    }
    SafeHtml template_html71() {
      return template.html71();
    }
    SafeHtml template_html72() {
      return template.html72(get_domId87());
    }
    SafeHtml template_html73() {
      return template.html73(get_domId86());
    }
    SafeHtml template_html74() {
      return template.html74();
    }
    SafeHtml template_html75() {
      return template.html75(get_domId90());
    }
    SafeHtml template_html76() {
      return template.html76(get_domId89());
    }
    SafeHtml template_html77() {
      return template.html77();
    }
    SafeHtml template_html78() {
      return template.html78(get_domId93());
    }
    SafeHtml template_html79() {
      return template.html79(get_domId92());
    }
    SafeHtml template_html80() {
      return template.html80();
    }
    SafeHtml template_html81() {
      return template.html81(get_domId96());
    }
    SafeHtml template_html82() {
      return template.html82(get_domId95());
    }
    SafeHtml template_html83() {
      return template.html83();
    }
    SafeHtml template_html84() {
      return template.html84(get_domId99());
    }
    SafeHtml template_html85() {
      return template.html85(get_domId98());
    }
    SafeHtml template_html86() {
      return template.html86();
    }
    SafeHtml template_html87() {
      return template.html87(get_domId102());
    }
    SafeHtml template_html88() {
      return template.html88(get_domId101());
    }
    SafeHtml template_html89() {
      return template.html89();
    }
    SafeHtml template_html90() {
      return template.html90(get_domId105());
    }
    SafeHtml template_html91() {
      return template.html91(get_domId104());
    }
    SafeHtml template_html92() {
      return template.html92();
    }
    SafeHtml template_html93() {
      return template.html93(get_domId108());
    }
    SafeHtml template_html94() {
      return template.html94(get_domId107());
    }
    SafeHtml template_html95() {
      return template.html95();
    }
    SafeHtml template_html96() {
      return template.html96(get_domId111());
    }
    SafeHtml template_html97() {
      return template.html97(get_domId110());
    }
    SafeHtml template_html98() {
      return template.html98();
    }
    SafeHtml template_html99() {
      return template.html99(get_domId114());
    }
    SafeHtml template_html100() {
      return template.html100(get_domId113());
    }
    SafeHtml template_html101() {
      return template.html101();
    }
    SafeHtml template_html102() {
      return template.html102(get_domId117());
    }
    SafeHtml template_html103() {
      return template.html103(get_domId116());
    }
    SafeHtml template_html104() {
      return template.html104();
    }
    SafeHtml template_html105() {
      return template.html105(get_domId120());
    }
    SafeHtml template_html106() {
      return template.html106(get_domId119());
    }
    SafeHtml template_html107() {
      return template.html107();
    }
    SafeHtml template_html108() {
      return template.html108(get_domId123());
    }
    SafeHtml template_html109() {
      return template.html109(get_domId122());
    }
    SafeHtml template_html110() {
      return template.html110(get_domId79(), get_domId82(), get_domId85(), get_domId88(), get_domId91(), get_domId94(), get_domId97(), get_domId100(), get_domId103(), get_domId106(), get_domId109(), get_domId112(), get_domId115(), get_domId118(), get_domId121());
    }
    SafeHtml template_html111() {
      return template.html111(get_domId78());
    }
    SafeHtml template_html112() {
      return template.html112();
    }
    SafeHtml template_html113() {
      return template.html113();
    }
    SafeHtml template_html114() {
      return template.html114(get_domId130(), get_domId131());
    }
    SafeHtml template_html115() {
      return template.html115(get_domId129());
    }
    SafeHtml template_html116() {
      return template.html116(get_domId133());
    }
    SafeHtml template_html117() {
      return template.html117(get_domId128(), get_domId132());
    }
    SafeHtml template_html118() {
      return template.html118(get_domId127(), get_domId134());
    }
    SafeHtml template_html119() {
      return template.html119(get_domId125(), get_domId126());
    }
    SafeHtml template_html120() {
      return template.html120();
    }
    SafeHtml template_html121() {
      return template.html121(get_domId139());
    }
    SafeHtml template_html122() {
      return template.html122(get_domId138());
    }
    SafeHtml template_html123() {
      return template.html123();
    }
    SafeHtml template_html124() {
      return template.html124(get_domId142());
    }
    SafeHtml template_html125() {
      return template.html125(get_domId141());
    }
    SafeHtml template_html126() {
      return template.html126();
    }
    SafeHtml template_html127() {
      return template.html127(get_domId145());
    }
    SafeHtml template_html128() {
      return template.html128(get_domId144());
    }
    SafeHtml template_html129() {
      return template.html129(get_domId137(), get_domId140(), get_domId143());
    }
    SafeHtml template_html130() {
      return template.html130(get_domId136());
    }
    SafeHtml template_html131() {
      return template.html131();
    }
    SafeHtml template_html132() {
      return template.html132(get_domId151());
    }
    SafeHtml template_html133() {
      return template.html133(get_domId153());
    }
    SafeHtml template_html134() {
      return template.html134(get_domId155(), get_domId156());
    }
    SafeHtml template_html135() {
      return template.html135(get_domId150(), get_domId152(), get_domId154());
    }
    SafeHtml template_html136() {
      return template.html136();
    }
    SafeHtml template_html137() {
      return template.html137();
    }
    SafeHtml template_html138() {
      return template.html138();
    }
    SafeHtml template_html139() {
      return template.html139(get_domId164());
    }
    SafeHtml template_html140() {
      return template.html140();
    }
    SafeHtml template_html141() {
      return template.html141(get_domId163(), get_domId165());
    }
    SafeHtml template_html142() {
      return template.html142(get_domId162());
    }
    SafeHtml template_html143() {
      return template.html143(get_domId148(), get_domId149(), get_domId157(), get_domId158(), get_domId159(), get_domId160(), get_domId161());
    }
    SafeHtml template_html144() {
      return template.html144();
    }
    SafeHtml template_html145() {
      return template.html145();
    }
    SafeHtml template_html146() {
      return template.html146();
    }
    SafeHtml template_html147() {
      return template.html147(get_domId176(), get_domId177(), get_domId178(), get_domId179(), get_domId180(), get_domId181(), get_domId182());
    }
    SafeHtml template_html148() {
      return template.html148(get_domId175());
    }
    SafeHtml template_html149() {
      return template.html149(get_domId171(), get_domId172(), get_domId173(), get_domId174());
    }
    SafeHtml template_html150() {
      return template.html150(get_domId170());
    }
    SafeHtml template_html151() {
      return template.html151(get_domId167(), get_domId168(), get_domId169());
    }
    SafeHtml template_html152() {
      return template.html152(get_domId184(), get_domId185());
    }
    SafeHtml template_html153() {
      return template.html153(get_domId0(), get_domId5(), get_domId11(), get_domId17(), get_domId66(), get_domId77(), get_domId124(), get_domId135(), get_domId146(), get_domId147(), get_domId166(), get_domId183(), get_domId186());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.EditResourcePopupVc_EditResourcePopupVcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.EditResourcePopupVc_EditResourcePopupVcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.EditResourcePopupVc_EditResourcePopupVcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.EditResourcePopupVc_EditResourcePopupVcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.EditResourcePopupVc_EditResourcePopupVcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 187 times. Type: IMPORTED. Build precedence: 1.
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
     * Getter for res1 called 6 times. Type: IMPORTED. Build precedence: 1.
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
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html153().asString());
      // Setup section.
      f_HTMLPanel1.setStyleName("" + get_res().css().myWebResourceContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4215 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId0Element().get();
      get_domId5Element().get();
      get_domId11Element().get();
      get_domId17Element().get();
      get_domId66Element().get();
      get_domId77Element().get();
      get_domId124Element().get();
      get_domId135Element().get();
      get_domId146Element().get();
      get_domId147Element().get();
      get_domId166Element().get();
      get_domId183Element().get();
      get_domId186Element().get();

      // Detach section.
      attachRecord4215.detach();
      f_HTMLPanel1.addAndReplaceElement(get_f_HTMLPanel2(), get_domId0Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_f_HTMLPanel4(), get_domId5Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_f_HTMLPanel6(), get_domId11Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_f_HTMLPanel8(), get_domId17Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_f_HTMLPanel33(), get_domId66Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_educationalUsePanel(), get_domId77Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_f_HTMLPanel55(), get_domId124Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_momentsOfLearningPanel(), get_domId135Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_standardContainer(), get_domId146Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_f_HTMLPanel68(), get_domId147Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_rightsContainer(), get_domId166Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_saveButtonContainer(), get_domId183Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_loadingTextLbl(), get_domId186Element().get());

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
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_res().css().myFolderCollectionFormContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4216 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_domId1Element().get();
      get_domId2Element().get();
      get_domId4Element().get();

      // Detach section.
      attachRecord4216.detach();
      f_HTMLPanel2.addAndReplaceElement(get_urlTextPanel(), get_domId1Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_f_HTMLPanel3(), get_domId2Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_mandatoryUrlLbl(), get_domId4Element().get());

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
     * Getter for urlTextPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_urlTextPanel() {
      return build_urlTextPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_urlTextPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel urlTextPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      urlTextPanel.setStyleName("" + get_res().css().myFolderCollectionFormTitle() + "");


      owner.urlTextPanel = urlTextPanel;

      return urlTextPanel;
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
     * Getter for f_HTMLPanel3 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel3() {
      return build_f_HTMLPanel3();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4217 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
      get_domId3Element().get();

      // Detach section.
      attachRecord4217.detach();
      f_HTMLPanel3.addAndReplaceElement(get_urlTextLbl(), get_domId3Element().get());

      return f_HTMLPanel3;
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
     * Getter for urlTextLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_urlTextLbl() {
      return build_urlTextLbl();
    }
    private com.google.gwt.user.client.ui.Label build_urlTextLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label urlTextLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      urlTextLbl.setStyleName("" + get_res().css().inputTextBox() + "");


      owner.urlTextLbl = urlTextLbl;

      return urlTextLbl;
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
     * Getter for mandatoryUrlLbl called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_mandatoryUrlLbl() {
      return build_mandatoryUrlLbl();
    }
    private com.google.gwt.user.client.ui.Label build_mandatoryUrlLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label mandatoryUrlLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      mandatoryUrlLbl.setStyleName("" + get_res().css().myFolderCollectionFormInputBottomText() + "");


      owner.mandatoryUrlLbl = mandatoryUrlLbl;

      return mandatoryUrlLbl;
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
     * Getter for f_HTMLPanel4 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel4() {
      return build_f_HTMLPanel4();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel4 = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.
      f_HTMLPanel4.setStyleName("" + get_res().css().myFolderCollectionFormContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4218 = UiBinderUtil.attachToDom(f_HTMLPanel4.getElement());
      get_domId6Element().get();
      get_domId7Element().get();
      get_domId9Element().get();
      get_domId10Element().get();

      // Detach section.
      attachRecord4218.detach();
      f_HTMLPanel4.addAndReplaceElement(get_titleTextPanel(), get_domId6Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_f_HTMLPanel5(), get_domId7Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_mandatoryTitleLblForSwareWords(), get_domId9Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_mandatoryTitleLbl(), get_domId10Element().get());

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
     * Getter for titleTextPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_titleTextPanel() {
      return build_titleTextPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_titleTextPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel titleTextPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      titleTextPanel.setStyleName("" + get_res().css().myFolderCollectionFormTitle() + "");


      owner.titleTextPanel = titleTextPanel;

      return titleTextPanel;
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
     * Getter for f_HTMLPanel5 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel5() {
      return build_f_HTMLPanel5();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel5 = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.
      f_HTMLPanel5.setStyleName("" + get_res().css().myFolderCollectionFormInputControl() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4219 = UiBinderUtil.attachToDom(f_HTMLPanel5.getElement());
      get_domId8Element().get();

      // Detach section.
      attachRecord4219.detach();
      f_HTMLPanel5.addAndReplaceElement(get_titleTextBox(), get_domId8Element().get());

      return f_HTMLPanel5;
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
     * Getter for titleTextBox called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.TextBox get_titleTextBox() {
      return build_titleTextBox();
    }
    private com.google.gwt.user.client.ui.TextBox build_titleTextBox() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox titleTextBox = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.
      titleTextBox.setStyleName("" + get_res().css().inputTextBox() + "");


      owner.titleTextBox = titleTextBox;

      return titleTextBox;
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
     * Getter for domId9 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for mandatoryTitleLblForSwareWords called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_mandatoryTitleLblForSwareWords() {
      return build_mandatoryTitleLblForSwareWords();
    }
    private com.google.gwt.user.client.ui.Label build_mandatoryTitleLblForSwareWords() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label mandatoryTitleLblForSwareWords = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.mandatoryTitleLblForSwareWords = mandatoryTitleLblForSwareWords;

      return mandatoryTitleLblForSwareWords;
    }

    /**
     * Getter for domId9Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId10 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for mandatoryTitleLbl called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_mandatoryTitleLbl() {
      return build_mandatoryTitleLbl();
    }
    private com.google.gwt.user.client.ui.Label build_mandatoryTitleLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label mandatoryTitleLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      mandatoryTitleLbl.setStyleName("" + get_res().css().myFolderCollectionFormInputBottomText() + "");


      owner.mandatoryTitleLbl = mandatoryTitleLbl;

      return mandatoryTitleLbl;
    }

    /**
     * Getter for domId10Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId11 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for f_HTMLPanel6 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel6() {
      return build_f_HTMLPanel6();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel6() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel6 = new com.google.gwt.user.client.ui.HTMLPanel(template_html10().asString());
      // Setup section.
      f_HTMLPanel6.setStyleName("" + get_res().css().myFolderCollectionFormContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4220 = UiBinderUtil.attachToDom(f_HTMLPanel6.getElement());
      get_domId12Element().get();
      get_domId13Element().get();
      get_domId15Element().get();
      get_domId16Element().get();

      // Detach section.
      attachRecord4220.detach();
      f_HTMLPanel6.addAndReplaceElement(get_resDescription(), get_domId12Element().get());
      f_HTMLPanel6.addAndReplaceElement(get_f_HTMLPanel7(), get_domId13Element().get());
      f_HTMLPanel6.addAndReplaceElement(get_mandatoryDescLblForSwareWords(), get_domId15Element().get());
      f_HTMLPanel6.addAndReplaceElement(get_descCharcterLimit(), get_domId16Element().get());

      return f_HTMLPanel6;
    }

    /**
     * Getter for domId12 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for resDescription called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_resDescription() {
      return build_resDescription();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_resDescription() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel resDescription = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.
      resDescription.setStyleName("" + get_res().css().myFolderCollectionFormTitle() + "");


      owner.resDescription = resDescription;

      return resDescription;
    }

    /**
     * Getter for domId12Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel7 = new com.google.gwt.user.client.ui.HTMLPanel(template_html8().asString());
      // Setup section.
      f_HTMLPanel7.setStyleName("" + get_res().css().myFolderCollectionFormInputControl() + " " + get_res().css().myFolderCollectionFormTextarea() + " editResourceDescriptionContainer");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4221 = UiBinderUtil.attachToDom(f_HTMLPanel7.getElement());
      get_domId14Element().get();

      // Detach section.
      attachRecord4221.detach();
      f_HTMLPanel7.addAndReplaceElement(get_descriptionTxtAera(), get_domId14Element().get());

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
     * Getter for descriptionTxtAera called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.TextArea get_descriptionTxtAera() {
      return build_descriptionTxtAera();
    }
    private com.google.gwt.user.client.ui.TextArea build_descriptionTxtAera() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextArea descriptionTxtAera = (com.google.gwt.user.client.ui.TextArea) GWT.create(com.google.gwt.user.client.ui.TextArea.class);
      // Setup section.
      descriptionTxtAera.setStyleName("" + get_res().css().inputTextBox() + " " + get_res().css().newPopupTextAreaEdit() + "");


      owner.descriptionTxtAera = descriptionTxtAera;

      return descriptionTxtAera;
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
     * Getter for domId15 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for mandatoryDescLblForSwareWords called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_mandatoryDescLblForSwareWords() {
      return build_mandatoryDescLblForSwareWords();
    }
    private com.google.gwt.user.client.ui.Label build_mandatoryDescLblForSwareWords() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label mandatoryDescLblForSwareWords = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.mandatoryDescLblForSwareWords = mandatoryDescLblForSwareWords;

      return mandatoryDescLblForSwareWords;
    }

    /**
     * Getter for domId15Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId16 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for descCharcterLimit called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_descCharcterLimit() {
      return build_descCharcterLimit();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_descCharcterLimit() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel descCharcterLimit = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      descCharcterLimit.setStyleName("" + get_res().css().myFolderCollectionFormInputBottomText() + "");


      owner.descCharcterLimit = descCharcterLimit;

      return descCharcterLimit;
    }

    /**
     * Getter for domId16Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId11Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
     * Getter for domId17 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for f_HTMLPanel8 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel8() {
      return build_f_HTMLPanel8();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel8() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel8 = new com.google.gwt.user.client.ui.HTMLPanel(template_html56().asString());
      // Setup section.
      f_HTMLPanel8.setStyleName("" + get_res().css().myFolderCollectionFormContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4222 = UiBinderUtil.attachToDom(f_HTMLPanel8.getElement());
      get_domId18Element().get();
      get_domId19Element().get();
      get_domId28Element().get();

      // Detach section.
      attachRecord4222.detach();
      f_HTMLPanel8.addAndReplaceElement(get_resourceFormat(), get_domId18Element().get());
      f_HTMLPanel8.addAndReplaceElement(get_f_HTMLPanel9(), get_domId19Element().get());
      f_HTMLPanel8.addAndReplaceElement(get_resourceTypePanel(), get_domId28Element().get());

      return f_HTMLPanel8;
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
     * Getter for resourceFormat called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_resourceFormat() {
      return build_resourceFormat();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_resourceFormat() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel resourceFormat = new com.google.gwt.user.client.ui.HTMLPanel(template_html11().asString());
      // Setup section.
      resourceFormat.setStyleName("" + get_res().css().myFolderCollectionFormTitle() + "");


      owner.resourceFormat = resourceFormat;

      return resourceFormat;
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
     * Getter for f_HTMLPanel9 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel9() {
      return build_f_HTMLPanel9();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel9() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel9 = new com.google.gwt.user.client.ui.HTMLPanel(template_html17().asString());
      // Setup section.
      f_HTMLPanel9.setStyleName("" + get_res().css().myFolderCollectionCategoryDiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4223 = UiBinderUtil.attachToDom(f_HTMLPanel9.getElement());
      get_domId20Element().get();
      get_domId27Element().get();

      // Detach section.
      attachRecord4223.detach();
      f_HTMLPanel9.addAndReplaceElement(get_f_HTMLPanel10(), get_domId20Element().get());
      f_HTMLPanel9.addAndReplaceElement(get_mandatoryCategoryLbl(), get_domId27Element().get());

      return f_HTMLPanel9;
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
     * Getter for f_HTMLPanel10 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel10() {
      return build_f_HTMLPanel10();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel10() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel10 = new com.google.gwt.user.client.ui.HTMLPanel(template_html16().asString());
      // Setup section.
      f_HTMLPanel10.setStyleName("" + get_res().css().myFolderCollectionCategoryInputDiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4224 = UiBinderUtil.attachToDom(f_HTMLPanel10.getElement());
      get_domId21Element().get();
      get_domId25Element().get();

      // Detach section.
      attachRecord4224.detach();
      f_HTMLPanel10.addAndReplaceElement(get_f_HTMLPanel11(), get_domId21Element().get());
      f_HTMLPanel10.addAndReplaceElement(get_f_HTMLPanel13(), get_domId25Element().get());

      return f_HTMLPanel10;
    }

    /**
     * Getter for domId21 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel11 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel11() {
      return build_f_HTMLPanel11();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel11() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel11 = new com.google.gwt.user.client.ui.HTMLPanel(template_html14().asString());
      // Setup section.
      f_HTMLPanel11.setStyleName("" + get_res().css().myFolderCollectionCategoryDivText() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4225 = UiBinderUtil.attachToDom(f_HTMLPanel11.getElement());
      get_domId22Element().get();

      // Detach section.
      attachRecord4225.detach();
      f_HTMLPanel11.addAndReplaceElement(get_f_HTMLPanel12(), get_domId22Element().get());

      return f_HTMLPanel11;
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
     * Getter for f_HTMLPanel12 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel12() {
      return build_f_HTMLPanel12();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel12() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel12 = new com.google.gwt.user.client.ui.HTMLPanel(template_html13().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4226 = UiBinderUtil.attachToDom(f_HTMLPanel12.getElement());
      get_domId23Element().get();
      get_domId24Element().get();

      // Detach section.
      attachRecord4226.detach();
      f_HTMLPanel12.addAndReplaceElement(get_categorypanel(), get_domId23Element().get());
      f_HTMLPanel12.addAndReplaceElement(get_resourceCategoryLabel(), get_domId24Element().get());

      return f_HTMLPanel12;
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
     * Getter for categorypanel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_categorypanel() {
      return build_categorypanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_categorypanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel categorypanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html12().asString());
      // Setup section.
      categorypanel.setStyleName("");


      owner.categorypanel = categorypanel;

      return categorypanel;
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
     * Getter for resourceCategoryLabel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_resourceCategoryLabel() {
      return build_resourceCategoryLabel();
    }
    private com.google.gwt.user.client.ui.Label build_resourceCategoryLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label resourceCategoryLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      resourceCategoryLabel.setStyleName("" + get_res().css().resourceCategoryLabel() + "");


      owner.resourceCategoryLabel = resourceCategoryLabel;

      return resourceCategoryLabel;
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
     * Getter for domId21Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId25 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel13 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel13() {
      return build_f_HTMLPanel13();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel13() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel13 = new com.google.gwt.user.client.ui.HTMLPanel(template_html15().asString());
      // Setup section.
      f_HTMLPanel13.setStyleName("" + get_res().css().myFolderCollectionArrowleftContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4227 = UiBinderUtil.attachToDom(f_HTMLPanel13.getElement());
      get_domId26Element().get();

      // Detach section.
      attachRecord4227.detach();
      f_HTMLPanel13.addAndReplaceElement(get_resoureDropDownLbl(), get_domId26Element().get());

      return f_HTMLPanel13;
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
     * Getter for resoureDropDownLbl called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_resoureDropDownLbl() {
      return build_resoureDropDownLbl();
    }
    private com.google.gwt.user.client.ui.Label build_resoureDropDownLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label resoureDropDownLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      resoureDropDownLbl.setStyleName("" + get_res().css().myFolderCollectionPopupSprite() + " " + get_res().css().myFolderCollectionArrowleft() + "");
      resoureDropDownLbl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames12);


      return resoureDropDownLbl;
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
     * Getter for domId25Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for mandatoryCategoryLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_mandatoryCategoryLbl() {
      return build_mandatoryCategoryLbl();
    }
    private com.google.gwt.user.client.ui.Label build_mandatoryCategoryLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label mandatoryCategoryLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      mandatoryCategoryLbl.setStyleName("" + get_res().css().addNewResourceMandatoryCategory() + "");


      owner.mandatoryCategoryLbl = mandatoryCategoryLbl;

      return mandatoryCategoryLbl;
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
     * Getter for domId28 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for resourceTypePanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_resourceTypePanel() {
      return build_resourceTypePanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_resourceTypePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel resourceTypePanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html55().asString());
      // Setup section.
      resourceTypePanel.setStyleName("");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4228 = UiBinderUtil.attachToDom(resourceTypePanel.getElement());
      get_domId29Element().get();

      // Detach section.
      attachRecord4228.detach();
      resourceTypePanel.addAndReplaceElement(get_f_HTMLPanel14(), get_domId29Element().get());

      owner.resourceTypePanel = resourceTypePanel;

      return resourceTypePanel;
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
     * Getter for f_HTMLPanel14 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel14() {
      return build_f_HTMLPanel14();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel14() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel14 = new com.google.gwt.user.client.ui.HTMLPanel(template_html54().asString());
      // Setup section.
      f_HTMLPanel14.setStyleName("" + get_res().css().myFolderCollectionFolderUpdateDropdown() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4229 = UiBinderUtil.attachToDom(f_HTMLPanel14.getElement());
      get_domId30Element().get();
      get_domId36Element().get();
      get_domId42Element().get();
      get_domId48Element().get();
      get_domId54Element().get();
      get_domId60Element().get();

      // Detach section.
      attachRecord4229.detach();
      f_HTMLPanel14.addAndReplaceElement(get_videoResourcePanel(), get_domId30Element().get());
      f_HTMLPanel14.addAndReplaceElement(get_interactiveResourcePanel(), get_domId36Element().get());
      f_HTMLPanel14.addAndReplaceElement(get_websiteResourcePanel(), get_domId42Element().get());
      f_HTMLPanel14.addAndReplaceElement(get_imageResourcePanel(), get_domId48Element().get());
      f_HTMLPanel14.addAndReplaceElement(get_textResourcePanel(), get_domId54Element().get());
      f_HTMLPanel14.addAndReplaceElement(get_audioResourcePanel(), get_domId60Element().get());

      return f_HTMLPanel14;
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
     * Getter for videoResourcePanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_videoResourcePanel() {
      return build_videoResourcePanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_videoResourcePanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel videoResourcePanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html23().asString());
      // Setup section.
      videoResourcePanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoOuterContainer() + "");
      videoResourcePanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4230 = UiBinderUtil.attachToDom(videoResourcePanel.getElement());
      get_domId31Element().get();

      // Detach section.
      attachRecord4230.detach();
      videoResourcePanel.addAndReplaceElement(get_f_HTMLPanel15(), get_domId31Element().get());

      owner.videoResourcePanel = videoResourcePanel;

      return videoResourcePanel;
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
     * Getter for f_HTMLPanel15 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel15() {
      return build_f_HTMLPanel15();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel15() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel15 = new com.google.gwt.user.client.ui.HTMLPanel(template_html22().asString());
      // Setup section.
      f_HTMLPanel15.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4231 = UiBinderUtil.attachToDom(f_HTMLPanel15.getElement());
      get_domId32Element().get();
      get_domId35Element().get();

      // Detach section.
      attachRecord4231.detach();
      f_HTMLPanel15.addAndReplaceElement(get_f_HTMLPanel16(), get_domId32Element().get());
      f_HTMLPanel15.addAndReplaceElement(get_videoPanel(), get_domId35Element().get());

      return f_HTMLPanel15;
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
     * Getter for f_HTMLPanel16 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel16() {
      return build_f_HTMLPanel16();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel16() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel16 = new com.google.gwt.user.client.ui.HTMLPanel(template_html20().asString());
      // Setup section.
      f_HTMLPanel16.setStyleName("" + get_res().css().myFolderCollectionFolderVideoInnerdiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4232 = UiBinderUtil.attachToDom(f_HTMLPanel16.getElement());
      get_domId33Element().get();

      // Detach section.
      attachRecord4232.detach();
      f_HTMLPanel16.addAndReplaceElement(get_f_HTMLPanel17(), get_domId33Element().get());

      return f_HTMLPanel16;
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
     * Getter for f_HTMLPanel17 called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel17() {
      return build_f_HTMLPanel17();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel17() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel17 = new com.google.gwt.user.client.ui.HTMLPanel(template_html19().asString());
      // Setup section.
      f_HTMLPanel17.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4233 = UiBinderUtil.attachToDom(f_HTMLPanel17.getElement());
      get_domId34Element().get();

      // Detach section.
      attachRecord4233.detach();
      f_HTMLPanel17.addAndReplaceElement(get_video(), get_domId34Element().get());

      return f_HTMLPanel17;
    }

    /**
     * Getter for domId34 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for video called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_video() {
      return build_video();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_video() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel video = new com.google.gwt.user.client.ui.HTMLPanel(template_html18().asString());
      // Setup section.
      video.setStyleName("" + get_res().css().myFolderCollectionFolderspriteNew() + " " + get_res().css().myFolderCollectionFolderspriteVideo() + "");


      owner.video = video;

      return video;
    }

    /**
     * Getter for domId34Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for videoPanel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_videoPanel() {
      return build_videoPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_videoPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel videoPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html21().asString());
      // Setup section.
      videoPanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoTitle() + "");


      owner.videoPanel = videoPanel;

      return videoPanel;
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
     * Getter for domId36 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for interactiveResourcePanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_interactiveResourcePanel() {
      return build_interactiveResourcePanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_interactiveResourcePanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel interactiveResourcePanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html29().asString());
      // Setup section.
      interactiveResourcePanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoOuterContainer() + "");
      interactiveResourcePanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4234 = UiBinderUtil.attachToDom(interactiveResourcePanel.getElement());
      get_domId37Element().get();

      // Detach section.
      attachRecord4234.detach();
      interactiveResourcePanel.addAndReplaceElement(get_f_HTMLPanel18(), get_domId37Element().get());

      return interactiveResourcePanel;
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
     * Getter for f_HTMLPanel18 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel18() {
      return build_f_HTMLPanel18();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel18() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel18 = new com.google.gwt.user.client.ui.HTMLPanel(template_html28().asString());
      // Setup section.
      f_HTMLPanel18.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4235 = UiBinderUtil.attachToDom(f_HTMLPanel18.getElement());
      get_domId38Element().get();
      get_domId41Element().get();

      // Detach section.
      attachRecord4235.detach();
      f_HTMLPanel18.addAndReplaceElement(get_f_HTMLPanel19(), get_domId38Element().get());
      f_HTMLPanel18.addAndReplaceElement(get_interactivePanel(), get_domId41Element().get());

      return f_HTMLPanel18;
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
     * Getter for f_HTMLPanel19 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel19() {
      return build_f_HTMLPanel19();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel19() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel19 = new com.google.gwt.user.client.ui.HTMLPanel(template_html26().asString());
      // Setup section.
      f_HTMLPanel19.setStyleName("" + get_res().css().myFolderCollectionFolderVideoInnerdiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4236 = UiBinderUtil.attachToDom(f_HTMLPanel19.getElement());
      get_domId39Element().get();

      // Detach section.
      attachRecord4236.detach();
      f_HTMLPanel19.addAndReplaceElement(get_f_HTMLPanel20(), get_domId39Element().get());

      return f_HTMLPanel19;
    }

    /**
     * Getter for domId39 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for f_HTMLPanel20 called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel20() {
      return build_f_HTMLPanel20();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel20() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel20 = new com.google.gwt.user.client.ui.HTMLPanel(template_html25().asString());
      // Setup section.
      f_HTMLPanel20.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4237 = UiBinderUtil.attachToDom(f_HTMLPanel20.getElement());
      get_domId40Element().get();

      // Detach section.
      attachRecord4237.detach();
      f_HTMLPanel20.addAndReplaceElement(get_interactive(), get_domId40Element().get());

      return f_HTMLPanel20;
    }

    /**
     * Getter for domId40 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for interactive called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_interactive() {
      return build_interactive();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_interactive() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel interactive = new com.google.gwt.user.client.ui.HTMLPanel(template_html24().asString());
      // Setup section.
      interactive.setStyleName("" + get_res().css().myFolderCollectionFolderspriteNew() + " " + get_res().css().myFolderCollectionFolderspriteInteractive() + "");


      owner.interactive = interactive;

      return interactive;
    }

    /**
     * Getter for domId40Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId39Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for interactivePanel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_interactivePanel() {
      return build_interactivePanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_interactivePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel interactivePanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html27().asString());
      // Setup section.
      interactivePanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoTitle() + "");


      owner.interactivePanel = interactivePanel;

      return interactivePanel;
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
     * Getter for domId36Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId42 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for websiteResourcePanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_websiteResourcePanel() {
      return build_websiteResourcePanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_websiteResourcePanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel websiteResourcePanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html35().asString());
      // Setup section.
      websiteResourcePanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoOuterContainer() + "");
      websiteResourcePanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4238 = UiBinderUtil.attachToDom(websiteResourcePanel.getElement());
      get_domId43Element().get();

      // Detach section.
      attachRecord4238.detach();
      websiteResourcePanel.addAndReplaceElement(get_f_HTMLPanel21(), get_domId43Element().get());

      return websiteResourcePanel;
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
     * Getter for f_HTMLPanel21 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel21() {
      return build_f_HTMLPanel21();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel21() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel21 = new com.google.gwt.user.client.ui.HTMLPanel(template_html34().asString());
      // Setup section.
      f_HTMLPanel21.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4239 = UiBinderUtil.attachToDom(f_HTMLPanel21.getElement());
      get_domId44Element().get();
      get_domId47Element().get();

      // Detach section.
      attachRecord4239.detach();
      f_HTMLPanel21.addAndReplaceElement(get_f_HTMLPanel22(), get_domId44Element().get());
      f_HTMLPanel21.addAndReplaceElement(get_websitePanel(), get_domId47Element().get());

      return f_HTMLPanel21;
    }

    /**
     * Getter for domId44 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for f_HTMLPanel22 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel22() {
      return build_f_HTMLPanel22();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel22() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel22 = new com.google.gwt.user.client.ui.HTMLPanel(template_html32().asString());
      // Setup section.
      f_HTMLPanel22.setStyleName("" + get_res().css().myFolderCollectionFolderVideoInnerdiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4240 = UiBinderUtil.attachToDom(f_HTMLPanel22.getElement());
      get_domId45Element().get();

      // Detach section.
      attachRecord4240.detach();
      f_HTMLPanel22.addAndReplaceElement(get_f_HTMLPanel23(), get_domId45Element().get());

      return f_HTMLPanel22;
    }

    /**
     * Getter for domId45 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for f_HTMLPanel23 called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel23() {
      return build_f_HTMLPanel23();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel23() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel23 = new com.google.gwt.user.client.ui.HTMLPanel(template_html31().asString());
      // Setup section.
      f_HTMLPanel23.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4241 = UiBinderUtil.attachToDom(f_HTMLPanel23.getElement());
      get_domId46Element().get();

      // Detach section.
      attachRecord4241.detach();
      f_HTMLPanel23.addAndReplaceElement(get_website(), get_domId46Element().get());

      return f_HTMLPanel23;
    }

    /**
     * Getter for domId46 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for website called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_website() {
      return build_website();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_website() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel website = new com.google.gwt.user.client.ui.HTMLPanel(template_html30().asString());
      // Setup section.
      website.setStyleName("" + get_res().css().myFolderCollectionFolderspriteNew() + " " + get_res().css().myFolderCollectionFolderspriteWebsite() + "");


      owner.website = website;

      return website;
    }

    /**
     * Getter for domId46Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId45Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId44Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for websitePanel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_websitePanel() {
      return build_websitePanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_websitePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel websitePanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html33().asString());
      // Setup section.
      websitePanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoTitle() + "");


      owner.websitePanel = websitePanel;

      return websitePanel;
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
     * Getter for domId42Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for imageResourcePanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_imageResourcePanel() {
      return build_imageResourcePanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_imageResourcePanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel imageResourcePanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html41().asString());
      // Setup section.
      imageResourcePanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoOuterContainer() + "");
      imageResourcePanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames9);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4242 = UiBinderUtil.attachToDom(imageResourcePanel.getElement());
      get_domId49Element().get();

      // Detach section.
      attachRecord4242.detach();
      imageResourcePanel.addAndReplaceElement(get_f_HTMLPanel24(), get_domId49Element().get());

      return imageResourcePanel;
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
     * Getter for f_HTMLPanel24 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel24() {
      return build_f_HTMLPanel24();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel24() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel24 = new com.google.gwt.user.client.ui.HTMLPanel(template_html40().asString());
      // Setup section.
      f_HTMLPanel24.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4243 = UiBinderUtil.attachToDom(f_HTMLPanel24.getElement());
      get_domId50Element().get();
      get_domId53Element().get();

      // Detach section.
      attachRecord4243.detach();
      f_HTMLPanel24.addAndReplaceElement(get_f_HTMLPanel25(), get_domId50Element().get());
      f_HTMLPanel24.addAndReplaceElement(get_imagePanel(), get_domId53Element().get());

      return f_HTMLPanel24;
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
     * Getter for f_HTMLPanel25 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel25() {
      return build_f_HTMLPanel25();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel25() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel25 = new com.google.gwt.user.client.ui.HTMLPanel(template_html38().asString());
      // Setup section.
      f_HTMLPanel25.setStyleName("" + get_res().css().myFolderCollectionFolderVideoInnerdiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4244 = UiBinderUtil.attachToDom(f_HTMLPanel25.getElement());
      get_domId51Element().get();

      // Detach section.
      attachRecord4244.detach();
      f_HTMLPanel25.addAndReplaceElement(get_f_HTMLPanel26(), get_domId51Element().get());

      return f_HTMLPanel25;
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
     * Getter for f_HTMLPanel26 called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel26() {
      return build_f_HTMLPanel26();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel26() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel26 = new com.google.gwt.user.client.ui.HTMLPanel(template_html37().asString());
      // Setup section.
      f_HTMLPanel26.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4245 = UiBinderUtil.attachToDom(f_HTMLPanel26.getElement());
      get_domId52Element().get();

      // Detach section.
      attachRecord4245.detach();
      f_HTMLPanel26.addAndReplaceElement(get_image(), get_domId52Element().get());

      return f_HTMLPanel26;
    }

    /**
     * Getter for domId52 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for image called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_image() {
      return build_image();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_image() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel image = new com.google.gwt.user.client.ui.HTMLPanel(template_html36().asString());
      // Setup section.
      image.setStyleName("" + get_res().css().myFolderCollectionFolderspriteNew() + " " + get_res().css().myFolderCollectionFolderspriteImage() + "");


      owner.image = image;

      return image;
    }

    /**
     * Getter for domId52Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId53 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for imagePanel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_imagePanel() {
      return build_imagePanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_imagePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel imagePanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html39().asString());
      // Setup section.
      imagePanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoTitle() + "");


      owner.imagePanel = imagePanel;

      return imagePanel;
    }

    /**
     * Getter for domId53Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for textResourcePanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_textResourcePanel() {
      return build_textResourcePanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_textResourcePanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel textResourcePanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html47().asString());
      // Setup section.
      textResourcePanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoOuterContainer() + "");
      textResourcePanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames10);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4246 = UiBinderUtil.attachToDom(textResourcePanel.getElement());
      get_domId55Element().get();

      // Detach section.
      attachRecord4246.detach();
      textResourcePanel.addAndReplaceElement(get_f_HTMLPanel27(), get_domId55Element().get());

      return textResourcePanel;
    }

    /**
     * Getter for domId55 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for f_HTMLPanel27 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel27() {
      return build_f_HTMLPanel27();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel27() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel27 = new com.google.gwt.user.client.ui.HTMLPanel(template_html46().asString());
      // Setup section.
      f_HTMLPanel27.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4247 = UiBinderUtil.attachToDom(f_HTMLPanel27.getElement());
      get_domId56Element().get();
      get_domId59Element().get();

      // Detach section.
      attachRecord4247.detach();
      f_HTMLPanel27.addAndReplaceElement(get_f_HTMLPanel28(), get_domId56Element().get());
      f_HTMLPanel27.addAndReplaceElement(get_textsPanel(), get_domId59Element().get());

      return f_HTMLPanel27;
    }

    /**
     * Getter for domId56 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for f_HTMLPanel28 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel28() {
      return build_f_HTMLPanel28();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel28() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel28 = new com.google.gwt.user.client.ui.HTMLPanel(template_html44().asString());
      // Setup section.
      f_HTMLPanel28.setStyleName("" + get_res().css().myFolderCollectionFolderVideoInnerdiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4248 = UiBinderUtil.attachToDom(f_HTMLPanel28.getElement());
      get_domId57Element().get();

      // Detach section.
      attachRecord4248.detach();
      f_HTMLPanel28.addAndReplaceElement(get_f_HTMLPanel29(), get_domId57Element().get());

      return f_HTMLPanel28;
    }

    /**
     * Getter for domId57 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for f_HTMLPanel29 called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel29() {
      return build_f_HTMLPanel29();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel29() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel29 = new com.google.gwt.user.client.ui.HTMLPanel(template_html43().asString());
      // Setup section.
      f_HTMLPanel29.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4249 = UiBinderUtil.attachToDom(f_HTMLPanel29.getElement());
      get_domId58Element().get();

      // Detach section.
      attachRecord4249.detach();
      f_HTMLPanel29.addAndReplaceElement(get_texts(), get_domId58Element().get());

      return f_HTMLPanel29;
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
     * Getter for texts called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_texts() {
      return build_texts();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_texts() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel texts = new com.google.gwt.user.client.ui.HTMLPanel(template_html42().asString());
      // Setup section.
      texts.setStyleName("" + get_res().css().myFolderCollectionFolderspriteNew() + " " + get_res().css().myFolderCollectionFolderspriteText() + "");


      owner.texts = texts;

      return texts;
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
     * Getter for domId57Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId56Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId59 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for textsPanel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_textsPanel() {
      return build_textsPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_textsPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel textsPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html45().asString());
      // Setup section.
      textsPanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoTitle() + "");


      owner.textsPanel = textsPanel;

      return textsPanel;
    }

    /**
     * Getter for domId59Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId55Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for audioResourcePanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_audioResourcePanel() {
      return build_audioResourcePanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_audioResourcePanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel audioResourcePanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html53().asString());
      // Setup section.
      audioResourcePanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoOuterContainer() + "");
      audioResourcePanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames11);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4250 = UiBinderUtil.attachToDom(audioResourcePanel.getElement());
      get_domId61Element().get();

      // Detach section.
      attachRecord4250.detach();
      audioResourcePanel.addAndReplaceElement(get_f_HTMLPanel30(), get_domId61Element().get());

      return audioResourcePanel;
    }

    /**
     * Getter for domId61 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for f_HTMLPanel30 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel30() {
      return build_f_HTMLPanel30();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel30() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel30 = new com.google.gwt.user.client.ui.HTMLPanel(template_html52().asString());
      // Setup section.
      f_HTMLPanel30.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4251 = UiBinderUtil.attachToDom(f_HTMLPanel30.getElement());
      get_domId62Element().get();
      get_domId65Element().get();

      // Detach section.
      attachRecord4251.detach();
      f_HTMLPanel30.addAndReplaceElement(get_f_HTMLPanel31(), get_domId62Element().get());
      f_HTMLPanel30.addAndReplaceElement(get_audioPanel(), get_domId65Element().get());

      return f_HTMLPanel30;
    }

    /**
     * Getter for domId62 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for f_HTMLPanel31 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel31() {
      return build_f_HTMLPanel31();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel31() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel31 = new com.google.gwt.user.client.ui.HTMLPanel(template_html50().asString());
      // Setup section.
      f_HTMLPanel31.setStyleName("" + get_res().css().myFolderCollectionFolderVideoInnerdiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4252 = UiBinderUtil.attachToDom(f_HTMLPanel31.getElement());
      get_domId63Element().get();

      // Detach section.
      attachRecord4252.detach();
      f_HTMLPanel31.addAndReplaceElement(get_f_HTMLPanel32(), get_domId63Element().get());

      return f_HTMLPanel31;
    }

    /**
     * Getter for domId63 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for f_HTMLPanel32 called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel32() {
      return build_f_HTMLPanel32();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel32() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel32 = new com.google.gwt.user.client.ui.HTMLPanel(template_html49().asString());
      // Setup section.
      f_HTMLPanel32.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4253 = UiBinderUtil.attachToDom(f_HTMLPanel32.getElement());
      get_domId64Element().get();

      // Detach section.
      attachRecord4253.detach();
      f_HTMLPanel32.addAndReplaceElement(get_audio(), get_domId64Element().get());

      return f_HTMLPanel32;
    }

    /**
     * Getter for domId64 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 9.
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
     * Getter for audio called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_audio() {
      return build_audio();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_audio() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel audio = new com.google.gwt.user.client.ui.HTMLPanel(template_html48().asString());
      // Setup section.
      audio.setStyleName("" + get_res().css().myFolderCollectionFolderspriteNew() + " " + get_res().css().myFolderCollectionFolderspriteAudio() + "");


      owner.audio = audio;

      return audio;
    }

    /**
     * Getter for domId64Element called 2 times. Type: DEFAULT. Build precedence: 9.
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
     * Getter for domId63Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId62Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId65 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for audioPanel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_audioPanel() {
      return build_audioPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_audioPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel audioPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html51().asString());
      // Setup section.
      audioPanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoTitle() + "");


      owner.audioPanel = audioPanel;

      return audioPanel;
    }

    /**
     * Getter for domId65Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId61Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId28Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId17Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
     * Getter for domId66 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for f_HTMLPanel33 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel33() {
      return build_f_HTMLPanel33();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel33() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel33 = new com.google.gwt.user.client.ui.HTMLPanel(template_html64().asString());
      // Setup section.
      f_HTMLPanel33.setStyleName("" + get_res().css().myEducationalFormContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4254 = UiBinderUtil.attachToDom(f_HTMLPanel33.getElement());
      get_domId67Element().get();
      get_domId68Element().get();

      // Detach section.
      attachRecord4254.detach();
      f_HTMLPanel33.addAndReplaceElement(get_educationalTitle(), get_domId67Element().get());
      f_HTMLPanel33.addAndReplaceElement(get_f_HTMLPanel34(), get_domId68Element().get());

      return f_HTMLPanel33;
    }

    /**
     * Getter for domId67 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for educationalTitle called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_educationalTitle() {
      return build_educationalTitle();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_educationalTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel educationalTitle = new com.google.gwt.user.client.ui.HTMLPanel(template_html57().asString());
      // Setup section.
      educationalTitle.setStyleName("" + get_res().css().myFolderCollectionFormTitle() + "");


      owner.educationalTitle = educationalTitle;

      return educationalTitle;
    }

    /**
     * Getter for domId67Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId68 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for f_HTMLPanel34 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel34() {
      return build_f_HTMLPanel34();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel34() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel34 = new com.google.gwt.user.client.ui.HTMLPanel(template_html63().asString());
      // Setup section.
      f_HTMLPanel34.setStyleName("" + get_res().css().myFolderCollectionCategoryDiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4255 = UiBinderUtil.attachToDom(f_HTMLPanel34.getElement());
      get_domId69Element().get();
      get_domId76Element().get();

      // Detach section.
      attachRecord4255.detach();
      f_HTMLPanel34.addAndReplaceElement(get_f_HTMLPanel35(), get_domId69Element().get());
      f_HTMLPanel34.addAndReplaceElement(get_mandatoryEducationalLbl(), get_domId76Element().get());

      return f_HTMLPanel34;
    }

    /**
     * Getter for domId69 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for f_HTMLPanel35 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel35() {
      return build_f_HTMLPanel35();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel35() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel35 = new com.google.gwt.user.client.ui.HTMLPanel(template_html62().asString());
      // Setup section.
      f_HTMLPanel35.setStyleName("" + get_res().css().myEducationPanelInputDiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4256 = UiBinderUtil.attachToDom(f_HTMLPanel35.getElement());
      get_domId70Element().get();
      get_domId74Element().get();

      // Detach section.
      attachRecord4256.detach();
      f_HTMLPanel35.addAndReplaceElement(get_f_HTMLPanel36(), get_domId70Element().get());
      f_HTMLPanel35.addAndReplaceElement(get_f_HTMLPanel38(), get_domId74Element().get());

      return f_HTMLPanel35;
    }

    /**
     * Getter for domId70 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel36 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel36() {
      return build_f_HTMLPanel36();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel36() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel36 = new com.google.gwt.user.client.ui.HTMLPanel(template_html60().asString());
      // Setup section.
      f_HTMLPanel36.setStyleName("" + get_res().css().myFolderCollectionCategoryDivText() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4257 = UiBinderUtil.attachToDom(f_HTMLPanel36.getElement());
      get_domId71Element().get();

      // Detach section.
      attachRecord4257.detach();
      f_HTMLPanel36.addAndReplaceElement(get_f_HTMLPanel37(), get_domId71Element().get());

      return f_HTMLPanel36;
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
     * Getter for f_HTMLPanel37 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel37() {
      return build_f_HTMLPanel37();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel37() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel37 = new com.google.gwt.user.client.ui.HTMLPanel(template_html59().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4258 = UiBinderUtil.attachToDom(f_HTMLPanel37.getElement());
      get_domId72Element().get();
      get_domId73Element().get();

      // Detach section.
      attachRecord4258.detach();
      f_HTMLPanel37.addAndReplaceElement(get_educationalpanel(), get_domId72Element().get());
      f_HTMLPanel37.addAndReplaceElement(get_resourceEducationalLabel(), get_domId73Element().get());

      return f_HTMLPanel37;
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
     * Getter for educationalpanel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_educationalpanel() {
      return build_educationalpanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_educationalpanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel educationalpanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html58().asString());
      // Setup section.
      educationalpanel.setStyleName("");


      return educationalpanel;
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
     * Getter for resourceEducationalLabel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_resourceEducationalLabel() {
      return build_resourceEducationalLabel();
    }
    private com.google.gwt.user.client.ui.Label build_resourceEducationalLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label resourceEducationalLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      resourceEducationalLabel.setStyleName("" + get_res().css().resourceCategoryLabel() + "");


      owner.resourceEducationalLabel = resourceEducationalLabel;

      return resourceEducationalLabel;
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
     * Getter for domId70Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId74 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel38 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel38() {
      return build_f_HTMLPanel38();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel38() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel38 = new com.google.gwt.user.client.ui.HTMLPanel(template_html61().asString());
      // Setup section.
      f_HTMLPanel38.setStyleName("" + get_res().css().myEducationArrowleftContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4259 = UiBinderUtil.attachToDom(f_HTMLPanel38.getElement());
      get_domId75Element().get();

      // Detach section.
      attachRecord4259.detach();
      f_HTMLPanel38.addAndReplaceElement(get_educationalDropDownLbl(), get_domId75Element().get());

      return f_HTMLPanel38;
    }

    /**
     * Getter for domId75 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for educationalDropDownLbl called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_educationalDropDownLbl() {
      return build_educationalDropDownLbl();
    }
    private com.google.gwt.user.client.ui.Label build_educationalDropDownLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label educationalDropDownLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      educationalDropDownLbl.setStyleName("" + get_res().css().myFolderCollectionPopupSprite() + " " + get_res().css().myFolderCollectionArrowleft() + "");
      educationalDropDownLbl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames29);


      return educationalDropDownLbl;
    }

    /**
     * Getter for domId75Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId74Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId69Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId76 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for mandatoryEducationalLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_mandatoryEducationalLbl() {
      return build_mandatoryEducationalLbl();
    }
    private com.google.gwt.user.client.ui.Label build_mandatoryEducationalLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label mandatoryEducationalLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      mandatoryEducationalLbl.setStyleName("" + get_res().css().addNewResourceMandatoryCategory() + "");


      owner.mandatoryEducationalLbl = mandatoryEducationalLbl;

      return mandatoryEducationalLbl;
    }

    /**
     * Getter for domId76Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId68Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId66Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
     * Getter for domId77 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for educationalUsePanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_educationalUsePanel() {
      return build_educationalUsePanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_educationalUsePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel educationalUsePanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html111().asString());
      // Setup section.
      educationalUsePanel.setStyleName("" + get_res().css().reorderLabelContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4260 = UiBinderUtil.attachToDom(educationalUsePanel.getElement());
      get_domId78Element().get();

      // Detach section.
      attachRecord4260.detach();
      educationalUsePanel.addAndReplaceElement(get_f_HTMLPanel39(), get_domId78Element().get());

      owner.educationalUsePanel = educationalUsePanel;

      return educationalUsePanel;
    }

    /**
     * Getter for domId78 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for f_HTMLPanel39 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel39() {
      return build_f_HTMLPanel39();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel39() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel39 = new com.google.gwt.user.client.ui.HTMLPanel(template_html110().asString());
      // Setup section.
      f_HTMLPanel39.setStyleName("" + get_res().css().myEducationEditDropdown() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4261 = UiBinderUtil.attachToDom(f_HTMLPanel39.getElement());
      get_domId79Element().get();
      get_domId82Element().get();
      get_domId85Element().get();
      get_domId88Element().get();
      get_domId91Element().get();
      get_domId94Element().get();
      get_domId97Element().get();
      get_domId100Element().get();
      get_domId103Element().get();
      get_domId106Element().get();
      get_domId109Element().get();
      get_domId112Element().get();
      get_domId115Element().get();
      get_domId118Element().get();
      get_domId121Element().get();

      // Detach section.
      attachRecord4261.detach();
      f_HTMLPanel39.addAndReplaceElement(get_activityPanel(), get_domId79Element().get());
      f_HTMLPanel39.addAndReplaceElement(get_handoutPanel(), get_domId82Element().get());
      f_HTMLPanel39.addAndReplaceElement(get_homeworkPanel(), get_domId85Element().get());
      f_HTMLPanel39.addAndReplaceElement(get_gamePanel(), get_domId88Element().get());
      f_HTMLPanel39.addAndReplaceElement(get_presentationPanel(), get_domId91Element().get());
      f_HTMLPanel39.addAndReplaceElement(get_referenceMaterialPanel(), get_domId94Element().get());
      f_HTMLPanel39.addAndReplaceElement(get_quizPanel(), get_domId97Element().get());
      f_HTMLPanel39.addAndReplaceElement(get_curriculumPlanPanel(), get_domId100Element().get());
      f_HTMLPanel39.addAndReplaceElement(get_lessonPlanPanel(), get_domId103Element().get());
      f_HTMLPanel39.addAndReplaceElement(get_unitPlanPanel(), get_domId106Element().get());
      f_HTMLPanel39.addAndReplaceElement(get_projectPlanPanel(), get_domId109Element().get());
      f_HTMLPanel39.addAndReplaceElement(get_readingPanel(), get_domId112Element().get());
      f_HTMLPanel39.addAndReplaceElement(get_textbookPanel(), get_domId115Element().get());
      f_HTMLPanel39.addAndReplaceElement(get_articlePanel(), get_domId118Element().get());
      f_HTMLPanel39.addAndReplaceElement(get_bookPanel(), get_domId121Element().get());

      return f_HTMLPanel39;
    }

    /**
     * Getter for domId79 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for activityPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_activityPanel() {
      return build_activityPanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_activityPanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel activityPanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html67().asString());
      // Setup section.
      activityPanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoOuterContainer() + "");
      activityPanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames14);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4262 = UiBinderUtil.attachToDom(activityPanel.getElement());
      get_domId80Element().get();

      // Detach section.
      attachRecord4262.detach();
      activityPanel.addAndReplaceElement(get_f_HTMLPanel40(), get_domId80Element().get());

      return activityPanel;
    }

    /**
     * Getter for domId80 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel40 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel40() {
      return build_f_HTMLPanel40();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel40() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel40 = new com.google.gwt.user.client.ui.HTMLPanel(template_html66().asString());
      // Setup section.
      f_HTMLPanel40.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4263 = UiBinderUtil.attachToDom(f_HTMLPanel40.getElement());
      get_domId81Element().get();

      // Detach section.
      attachRecord4263.detach();
      f_HTMLPanel40.addAndReplaceElement(get_activityText(), get_domId81Element().get());

      return f_HTMLPanel40;
    }

    /**
     * Getter for domId81 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for activityText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_activityText() {
      return build_activityText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_activityText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel activityText = new com.google.gwt.user.client.ui.HTMLPanel(template_html65().asString());
      // Setup section.
      activityText.setStyleName("" + get_res().css().myEducationalPanelSubTitles() + "");


      owner.activityText = activityText;

      return activityText;
    }

    /**
     * Getter for domId81Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId80Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId79Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId82 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for handoutPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_handoutPanel() {
      return build_handoutPanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_handoutPanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel handoutPanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html70().asString());
      // Setup section.
      handoutPanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoOuterContainer() + "");
      handoutPanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames15);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4264 = UiBinderUtil.attachToDom(handoutPanel.getElement());
      get_domId83Element().get();

      // Detach section.
      attachRecord4264.detach();
      handoutPanel.addAndReplaceElement(get_f_HTMLPanel41(), get_domId83Element().get());

      return handoutPanel;
    }

    /**
     * Getter for domId83 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel41 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel41() {
      return build_f_HTMLPanel41();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel41() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel41 = new com.google.gwt.user.client.ui.HTMLPanel(template_html69().asString());
      // Setup section.
      f_HTMLPanel41.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4265 = UiBinderUtil.attachToDom(f_HTMLPanel41.getElement());
      get_domId84Element().get();

      // Detach section.
      attachRecord4265.detach();
      f_HTMLPanel41.addAndReplaceElement(get_handoutText(), get_domId84Element().get());

      return f_HTMLPanel41;
    }

    /**
     * Getter for domId84 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for handoutText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_handoutText() {
      return build_handoutText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_handoutText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel handoutText = new com.google.gwt.user.client.ui.HTMLPanel(template_html68().asString());
      // Setup section.
      handoutText.setStyleName("" + get_res().css().myEducationalPanelSubTitles() + "");


      owner.handoutText = handoutText;

      return handoutText;
    }

    /**
     * Getter for domId84Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId83Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId82Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId85 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for homeworkPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_homeworkPanel() {
      return build_homeworkPanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_homeworkPanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel homeworkPanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html73().asString());
      // Setup section.
      homeworkPanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoOuterContainer() + "");
      homeworkPanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames16);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4266 = UiBinderUtil.attachToDom(homeworkPanel.getElement());
      get_domId86Element().get();

      // Detach section.
      attachRecord4266.detach();
      homeworkPanel.addAndReplaceElement(get_f_HTMLPanel42(), get_domId86Element().get());

      return homeworkPanel;
    }

    /**
     * Getter for domId86 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel42 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel42() {
      return build_f_HTMLPanel42();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel42() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel42 = new com.google.gwt.user.client.ui.HTMLPanel(template_html72().asString());
      // Setup section.
      f_HTMLPanel42.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4267 = UiBinderUtil.attachToDom(f_HTMLPanel42.getElement());
      get_domId87Element().get();

      // Detach section.
      attachRecord4267.detach();
      f_HTMLPanel42.addAndReplaceElement(get_homeworkText(), get_domId87Element().get());

      return f_HTMLPanel42;
    }

    /**
     * Getter for domId87 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for homeworkText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_homeworkText() {
      return build_homeworkText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_homeworkText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel homeworkText = new com.google.gwt.user.client.ui.HTMLPanel(template_html71().asString());
      // Setup section.
      homeworkText.setStyleName("" + get_res().css().myEducationalPanelSubTitles() + "");


      owner.homeworkText = homeworkText;

      return homeworkText;
    }

    /**
     * Getter for domId87Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId86Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId85Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId88 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for gamePanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_gamePanel() {
      return build_gamePanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_gamePanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel gamePanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html76().asString());
      // Setup section.
      gamePanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoOuterContainer() + "");
      gamePanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames17);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4268 = UiBinderUtil.attachToDom(gamePanel.getElement());
      get_domId89Element().get();

      // Detach section.
      attachRecord4268.detach();
      gamePanel.addAndReplaceElement(get_f_HTMLPanel43(), get_domId89Element().get());

      return gamePanel;
    }

    /**
     * Getter for domId89 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel43 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel43() {
      return build_f_HTMLPanel43();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel43() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel43 = new com.google.gwt.user.client.ui.HTMLPanel(template_html75().asString());
      // Setup section.
      f_HTMLPanel43.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4269 = UiBinderUtil.attachToDom(f_HTMLPanel43.getElement());
      get_domId90Element().get();

      // Detach section.
      attachRecord4269.detach();
      f_HTMLPanel43.addAndReplaceElement(get_gameText(), get_domId90Element().get());

      return f_HTMLPanel43;
    }

    /**
     * Getter for domId90 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for gameText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_gameText() {
      return build_gameText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_gameText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel gameText = new com.google.gwt.user.client.ui.HTMLPanel(template_html74().asString());
      // Setup section.
      gameText.setStyleName("" + get_res().css().myEducationalPanelSubTitles() + "");


      owner.gameText = gameText;

      return gameText;
    }

    /**
     * Getter for domId90Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId89Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId88Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId91 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for presentationPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_presentationPanel() {
      return build_presentationPanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_presentationPanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel presentationPanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html79().asString());
      // Setup section.
      presentationPanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoOuterContainer() + "");
      presentationPanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames18);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4270 = UiBinderUtil.attachToDom(presentationPanel.getElement());
      get_domId92Element().get();

      // Detach section.
      attachRecord4270.detach();
      presentationPanel.addAndReplaceElement(get_f_HTMLPanel44(), get_domId92Element().get());

      return presentationPanel;
    }

    /**
     * Getter for domId92 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel44 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel44() {
      return build_f_HTMLPanel44();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel44() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel44 = new com.google.gwt.user.client.ui.HTMLPanel(template_html78().asString());
      // Setup section.
      f_HTMLPanel44.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4271 = UiBinderUtil.attachToDom(f_HTMLPanel44.getElement());
      get_domId93Element().get();

      // Detach section.
      attachRecord4271.detach();
      f_HTMLPanel44.addAndReplaceElement(get_presentationText(), get_domId93Element().get());

      return f_HTMLPanel44;
    }

    /**
     * Getter for domId93 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for presentationText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_presentationText() {
      return build_presentationText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_presentationText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel presentationText = new com.google.gwt.user.client.ui.HTMLPanel(template_html77().asString());
      // Setup section.
      presentationText.setStyleName("" + get_res().css().myEducationalPanelSubTitles() + "");


      owner.presentationText = presentationText;

      return presentationText;
    }

    /**
     * Getter for domId93Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId92Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId91Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId94 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for referenceMaterialPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_referenceMaterialPanel() {
      return build_referenceMaterialPanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_referenceMaterialPanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel referenceMaterialPanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html82().asString());
      // Setup section.
      referenceMaterialPanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoOuterContainer() + "");
      referenceMaterialPanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames19);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4272 = UiBinderUtil.attachToDom(referenceMaterialPanel.getElement());
      get_domId95Element().get();

      // Detach section.
      attachRecord4272.detach();
      referenceMaterialPanel.addAndReplaceElement(get_f_HTMLPanel45(), get_domId95Element().get());

      return referenceMaterialPanel;
    }

    /**
     * Getter for domId95 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel45 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel45() {
      return build_f_HTMLPanel45();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel45() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel45 = new com.google.gwt.user.client.ui.HTMLPanel(template_html81().asString());
      // Setup section.
      f_HTMLPanel45.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4273 = UiBinderUtil.attachToDom(f_HTMLPanel45.getElement());
      get_domId96Element().get();

      // Detach section.
      attachRecord4273.detach();
      f_HTMLPanel45.addAndReplaceElement(get_referenceMaterialText(), get_domId96Element().get());

      return f_HTMLPanel45;
    }

    /**
     * Getter for domId96 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for referenceMaterialText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_referenceMaterialText() {
      return build_referenceMaterialText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_referenceMaterialText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel referenceMaterialText = new com.google.gwt.user.client.ui.HTMLPanel(template_html80().asString());
      // Setup section.
      referenceMaterialText.setStyleName("" + get_res().css().myEducationalPanelSubTitles() + "");


      owner.referenceMaterialText = referenceMaterialText;

      return referenceMaterialText;
    }

    /**
     * Getter for domId96Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId95Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId94Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId97 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for quizPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_quizPanel() {
      return build_quizPanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_quizPanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel quizPanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html85().asString());
      // Setup section.
      quizPanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoOuterContainer() + "");
      quizPanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames20);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4274 = UiBinderUtil.attachToDom(quizPanel.getElement());
      get_domId98Element().get();

      // Detach section.
      attachRecord4274.detach();
      quizPanel.addAndReplaceElement(get_f_HTMLPanel46(), get_domId98Element().get());

      return quizPanel;
    }

    /**
     * Getter for domId98 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel46 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel46() {
      return build_f_HTMLPanel46();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel46() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel46 = new com.google.gwt.user.client.ui.HTMLPanel(template_html84().asString());
      // Setup section.
      f_HTMLPanel46.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4275 = UiBinderUtil.attachToDom(f_HTMLPanel46.getElement());
      get_domId99Element().get();

      // Detach section.
      attachRecord4275.detach();
      f_HTMLPanel46.addAndReplaceElement(get_quizText(), get_domId99Element().get());

      return f_HTMLPanel46;
    }

    /**
     * Getter for domId99 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for quizText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_quizText() {
      return build_quizText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_quizText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel quizText = new com.google.gwt.user.client.ui.HTMLPanel(template_html83().asString());
      // Setup section.
      quizText.setStyleName("" + get_res().css().myEducationalPanelSubTitles() + "");


      owner.quizText = quizText;

      return quizText;
    }

    /**
     * Getter for domId99Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId98Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId97Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId100 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for curriculumPlanPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_curriculumPlanPanel() {
      return build_curriculumPlanPanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_curriculumPlanPanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel curriculumPlanPanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html88().asString());
      // Setup section.
      curriculumPlanPanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoOuterContainer() + "");
      curriculumPlanPanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames21);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4276 = UiBinderUtil.attachToDom(curriculumPlanPanel.getElement());
      get_domId101Element().get();

      // Detach section.
      attachRecord4276.detach();
      curriculumPlanPanel.addAndReplaceElement(get_f_HTMLPanel47(), get_domId101Element().get());

      return curriculumPlanPanel;
    }

    /**
     * Getter for domId101 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel47 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel47() {
      return build_f_HTMLPanel47();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel47() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel47 = new com.google.gwt.user.client.ui.HTMLPanel(template_html87().asString());
      // Setup section.
      f_HTMLPanel47.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4277 = UiBinderUtil.attachToDom(f_HTMLPanel47.getElement());
      get_domId102Element().get();

      // Detach section.
      attachRecord4277.detach();
      f_HTMLPanel47.addAndReplaceElement(get_curriculumPlanText(), get_domId102Element().get());

      return f_HTMLPanel47;
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
     * Getter for curriculumPlanText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_curriculumPlanText() {
      return build_curriculumPlanText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_curriculumPlanText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel curriculumPlanText = new com.google.gwt.user.client.ui.HTMLPanel(template_html86().asString());
      // Setup section.
      curriculumPlanText.setStyleName("" + get_res().css().myEducationalPanelSubTitles() + "");


      owner.curriculumPlanText = curriculumPlanText;

      return curriculumPlanText;
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
     * Getter for domId101Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId100Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId103 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for lessonPlanPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_lessonPlanPanel() {
      return build_lessonPlanPanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_lessonPlanPanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel lessonPlanPanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html91().asString());
      // Setup section.
      lessonPlanPanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoOuterContainer() + "");
      lessonPlanPanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames22);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4278 = UiBinderUtil.attachToDom(lessonPlanPanel.getElement());
      get_domId104Element().get();

      // Detach section.
      attachRecord4278.detach();
      lessonPlanPanel.addAndReplaceElement(get_f_HTMLPanel48(), get_domId104Element().get());

      return lessonPlanPanel;
    }

    /**
     * Getter for domId104 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel48 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel48() {
      return build_f_HTMLPanel48();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel48() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel48 = new com.google.gwt.user.client.ui.HTMLPanel(template_html90().asString());
      // Setup section.
      f_HTMLPanel48.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4279 = UiBinderUtil.attachToDom(f_HTMLPanel48.getElement());
      get_domId105Element().get();

      // Detach section.
      attachRecord4279.detach();
      f_HTMLPanel48.addAndReplaceElement(get_lessonPlanText(), get_domId105Element().get());

      return f_HTMLPanel48;
    }

    /**
     * Getter for domId105 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for lessonPlanText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_lessonPlanText() {
      return build_lessonPlanText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_lessonPlanText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel lessonPlanText = new com.google.gwt.user.client.ui.HTMLPanel(template_html89().asString());
      // Setup section.
      lessonPlanText.setStyleName("" + get_res().css().myEducationalPanelSubTitles() + "");


      owner.lessonPlanText = lessonPlanText;

      return lessonPlanText;
    }

    /**
     * Getter for domId105Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId104Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId103Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId106 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for unitPlanPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_unitPlanPanel() {
      return build_unitPlanPanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_unitPlanPanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel unitPlanPanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html94().asString());
      // Setup section.
      unitPlanPanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoOuterContainer() + "");
      unitPlanPanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames23);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4280 = UiBinderUtil.attachToDom(unitPlanPanel.getElement());
      get_domId107Element().get();

      // Detach section.
      attachRecord4280.detach();
      unitPlanPanel.addAndReplaceElement(get_f_HTMLPanel49(), get_domId107Element().get());

      return unitPlanPanel;
    }

    /**
     * Getter for domId107 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel49 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel49() {
      return build_f_HTMLPanel49();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel49() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel49 = new com.google.gwt.user.client.ui.HTMLPanel(template_html93().asString());
      // Setup section.
      f_HTMLPanel49.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4281 = UiBinderUtil.attachToDom(f_HTMLPanel49.getElement());
      get_domId108Element().get();

      // Detach section.
      attachRecord4281.detach();
      f_HTMLPanel49.addAndReplaceElement(get_unitPlanText(), get_domId108Element().get());

      return f_HTMLPanel49;
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
     * Getter for unitPlanText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_unitPlanText() {
      return build_unitPlanText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_unitPlanText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel unitPlanText = new com.google.gwt.user.client.ui.HTMLPanel(template_html92().asString());
      // Setup section.
      unitPlanText.setStyleName("" + get_res().css().myEducationalPanelSubTitles() + "");


      owner.unitPlanText = unitPlanText;

      return unitPlanText;
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
     * Getter for domId107Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId106Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId109 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for projectPlanPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_projectPlanPanel() {
      return build_projectPlanPanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_projectPlanPanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel projectPlanPanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html97().asString());
      // Setup section.
      projectPlanPanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoOuterContainer() + "");
      projectPlanPanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames24);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4282 = UiBinderUtil.attachToDom(projectPlanPanel.getElement());
      get_domId110Element().get();

      // Detach section.
      attachRecord4282.detach();
      projectPlanPanel.addAndReplaceElement(get_f_HTMLPanel50(), get_domId110Element().get());

      return projectPlanPanel;
    }

    /**
     * Getter for domId110 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel50 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel50() {
      return build_f_HTMLPanel50();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel50() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel50 = new com.google.gwt.user.client.ui.HTMLPanel(template_html96().asString());
      // Setup section.
      f_HTMLPanel50.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4283 = UiBinderUtil.attachToDom(f_HTMLPanel50.getElement());
      get_domId111Element().get();

      // Detach section.
      attachRecord4283.detach();
      f_HTMLPanel50.addAndReplaceElement(get_projectPlanText(), get_domId111Element().get());

      return f_HTMLPanel50;
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
     * Getter for projectPlanText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_projectPlanText() {
      return build_projectPlanText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_projectPlanText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel projectPlanText = new com.google.gwt.user.client.ui.HTMLPanel(template_html95().asString());
      // Setup section.
      projectPlanText.setStyleName("" + get_res().css().myEducationalPanelSubTitles() + "");


      owner.projectPlanText = projectPlanText;

      return projectPlanText;
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
     * Getter for domId110Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId109Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId112 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for readingPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_readingPanel() {
      return build_readingPanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_readingPanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel readingPanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html100().asString());
      // Setup section.
      readingPanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoOuterContainer() + "");
      readingPanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames25);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4284 = UiBinderUtil.attachToDom(readingPanel.getElement());
      get_domId113Element().get();

      // Detach section.
      attachRecord4284.detach();
      readingPanel.addAndReplaceElement(get_f_HTMLPanel51(), get_domId113Element().get());

      return readingPanel;
    }

    /**
     * Getter for domId113 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel51 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel51() {
      return build_f_HTMLPanel51();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel51() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel51 = new com.google.gwt.user.client.ui.HTMLPanel(template_html99().asString());
      // Setup section.
      f_HTMLPanel51.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4285 = UiBinderUtil.attachToDom(f_HTMLPanel51.getElement());
      get_domId114Element().get();

      // Detach section.
      attachRecord4285.detach();
      f_HTMLPanel51.addAndReplaceElement(get_readingText(), get_domId114Element().get());

      return f_HTMLPanel51;
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
     * Getter for readingText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_readingText() {
      return build_readingText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_readingText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel readingText = new com.google.gwt.user.client.ui.HTMLPanel(template_html98().asString());
      // Setup section.
      readingText.setStyleName("" + get_res().css().myEducationalPanelSubTitles() + "");


      owner.readingText = readingText;

      return readingText;
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
     * Getter for domId113Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId112Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId115 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for textbookPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_textbookPanel() {
      return build_textbookPanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_textbookPanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel textbookPanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html103().asString());
      // Setup section.
      textbookPanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoOuterContainer() + "");
      textbookPanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames26);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4286 = UiBinderUtil.attachToDom(textbookPanel.getElement());
      get_domId116Element().get();

      // Detach section.
      attachRecord4286.detach();
      textbookPanel.addAndReplaceElement(get_f_HTMLPanel52(), get_domId116Element().get());

      return textbookPanel;
    }

    /**
     * Getter for domId116 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel52 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel52() {
      return build_f_HTMLPanel52();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel52() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel52 = new com.google.gwt.user.client.ui.HTMLPanel(template_html102().asString());
      // Setup section.
      f_HTMLPanel52.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4287 = UiBinderUtil.attachToDom(f_HTMLPanel52.getElement());
      get_domId117Element().get();

      // Detach section.
      attachRecord4287.detach();
      f_HTMLPanel52.addAndReplaceElement(get_textbookText(), get_domId117Element().get());

      return f_HTMLPanel52;
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
     * Getter for textbookText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_textbookText() {
      return build_textbookText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_textbookText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel textbookText = new com.google.gwt.user.client.ui.HTMLPanel(template_html101().asString());
      // Setup section.
      textbookText.setStyleName("" + get_res().css().myEducationalPanelSubTitles() + "");


      owner.textbookText = textbookText;

      return textbookText;
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
     * Getter for domId116Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId115Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId118 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for articlePanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_articlePanel() {
      return build_articlePanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_articlePanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel articlePanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html106().asString());
      // Setup section.
      articlePanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoOuterContainer() + "");
      articlePanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames27);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4288 = UiBinderUtil.attachToDom(articlePanel.getElement());
      get_domId119Element().get();

      // Detach section.
      attachRecord4288.detach();
      articlePanel.addAndReplaceElement(get_f_HTMLPanel53(), get_domId119Element().get());

      return articlePanel;
    }

    /**
     * Getter for domId119 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel53 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel53() {
      return build_f_HTMLPanel53();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel53() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel53 = new com.google.gwt.user.client.ui.HTMLPanel(template_html105().asString());
      // Setup section.
      f_HTMLPanel53.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4289 = UiBinderUtil.attachToDom(f_HTMLPanel53.getElement());
      get_domId120Element().get();

      // Detach section.
      attachRecord4289.detach();
      f_HTMLPanel53.addAndReplaceElement(get_articleText(), get_domId120Element().get());

      return f_HTMLPanel53;
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
     * Getter for articleText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_articleText() {
      return build_articleText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_articleText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel articleText = new com.google.gwt.user.client.ui.HTMLPanel(template_html104().asString());
      // Setup section.
      articleText.setStyleName("" + get_res().css().myEducationalPanelSubTitles() + "");


      owner.articleText = articleText;

      return articleText;
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
     * Getter for domId119Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId118Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId121 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for bookPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_bookPanel() {
      return build_bookPanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_bookPanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel bookPanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html109().asString());
      // Setup section.
      bookPanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoOuterContainer() + "");
      bookPanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames28);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4290 = UiBinderUtil.attachToDom(bookPanel.getElement());
      get_domId122Element().get();

      // Detach section.
      attachRecord4290.detach();
      bookPanel.addAndReplaceElement(get_f_HTMLPanel54(), get_domId122Element().get());

      return bookPanel;
    }

    /**
     * Getter for domId122 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel54 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel54() {
      return build_f_HTMLPanel54();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel54() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel54 = new com.google.gwt.user.client.ui.HTMLPanel(template_html108().asString());
      // Setup section.
      f_HTMLPanel54.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4291 = UiBinderUtil.attachToDom(f_HTMLPanel54.getElement());
      get_domId123Element().get();

      // Detach section.
      attachRecord4291.detach();
      f_HTMLPanel54.addAndReplaceElement(get_bookText(), get_domId123Element().get());

      return f_HTMLPanel54;
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
     * Getter for bookText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_bookText() {
      return build_bookText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_bookText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel bookText = new com.google.gwt.user.client.ui.HTMLPanel(template_html107().asString());
      // Setup section.
      bookText.setStyleName("" + get_res().css().myEducationalPanelSubTitles() + "");


      owner.bookText = bookText;

      return bookText;
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
     * Getter for domId122Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId121Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId78Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId77Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
     * Getter for domId124 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for f_HTMLPanel55 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel55() {
      return build_f_HTMLPanel55();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel55() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel55 = new com.google.gwt.user.client.ui.HTMLPanel(template_html119().asString());
      // Setup section.
      f_HTMLPanel55.setStyleName("" + get_res().css().myEducationalFormContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4292 = UiBinderUtil.attachToDom(f_HTMLPanel55.getElement());
      get_domId125Element().get();
      get_domId126Element().get();

      // Detach section.
      attachRecord4292.detach();
      f_HTMLPanel55.addAndReplaceElement(get_momentsOfLearningTitle(), get_domId125Element().get());
      f_HTMLPanel55.addAndReplaceElement(get_f_HTMLPanel56(), get_domId126Element().get());

      return f_HTMLPanel55;
    }

    /**
     * Getter for domId125 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for momentsOfLearningTitle called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_momentsOfLearningTitle() {
      return build_momentsOfLearningTitle();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_momentsOfLearningTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel momentsOfLearningTitle = new com.google.gwt.user.client.ui.HTMLPanel(template_html112().asString());
      // Setup section.
      momentsOfLearningTitle.setStyleName("" + get_res().css().myFolderCollectionFormTitle() + "");


      owner.momentsOfLearningTitle = momentsOfLearningTitle;

      return momentsOfLearningTitle;
    }

    /**
     * Getter for domId125Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId126 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for f_HTMLPanel56 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel56() {
      return build_f_HTMLPanel56();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel56() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel56 = new com.google.gwt.user.client.ui.HTMLPanel(template_html118().asString());
      // Setup section.
      f_HTMLPanel56.setStyleName("" + get_res().css().myFolderCollectionCategoryDiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4293 = UiBinderUtil.attachToDom(f_HTMLPanel56.getElement());
      get_domId127Element().get();
      get_domId134Element().get();

      // Detach section.
      attachRecord4293.detach();
      f_HTMLPanel56.addAndReplaceElement(get_f_HTMLPanel57(), get_domId127Element().get());
      f_HTMLPanel56.addAndReplaceElement(get_mandatorymomentsOfLearninglLbl(), get_domId134Element().get());

      return f_HTMLPanel56;
    }

    /**
     * Getter for domId127 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for f_HTMLPanel57 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel57() {
      return build_f_HTMLPanel57();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel57() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel57 = new com.google.gwt.user.client.ui.HTMLPanel(template_html117().asString());
      // Setup section.
      f_HTMLPanel57.setStyleName("" + get_res().css().myEducationPanelInputDiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4294 = UiBinderUtil.attachToDom(f_HTMLPanel57.getElement());
      get_domId128Element().get();
      get_domId132Element().get();

      // Detach section.
      attachRecord4294.detach();
      f_HTMLPanel57.addAndReplaceElement(get_f_HTMLPanel58(), get_domId128Element().get());
      f_HTMLPanel57.addAndReplaceElement(get_f_HTMLPanel60(), get_domId132Element().get());

      return f_HTMLPanel57;
    }

    /**
     * Getter for domId128 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel58 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel58() {
      return build_f_HTMLPanel58();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel58() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel58 = new com.google.gwt.user.client.ui.HTMLPanel(template_html115().asString());
      // Setup section.
      f_HTMLPanel58.setStyleName("" + get_res().css().myFolderCollectionCategoryDivText() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4295 = UiBinderUtil.attachToDom(f_HTMLPanel58.getElement());
      get_domId129Element().get();

      // Detach section.
      attachRecord4295.detach();
      f_HTMLPanel58.addAndReplaceElement(get_f_HTMLPanel59(), get_domId129Element().get());

      return f_HTMLPanel58;
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
     * Getter for f_HTMLPanel59 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel59() {
      return build_f_HTMLPanel59();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel59() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel59 = new com.google.gwt.user.client.ui.HTMLPanel(template_html114().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4296 = UiBinderUtil.attachToDom(f_HTMLPanel59.getElement());
      get_domId130Element().get();
      get_domId131Element().get();

      // Detach section.
      attachRecord4296.detach();
      f_HTMLPanel59.addAndReplaceElement(get_momentsOfLearningpanel(), get_domId130Element().get());
      f_HTMLPanel59.addAndReplaceElement(get_resourcemomentsOfLearningLabel(), get_domId131Element().get());

      return f_HTMLPanel59;
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
     * Getter for momentsOfLearningpanel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_momentsOfLearningpanel() {
      return build_momentsOfLearningpanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_momentsOfLearningpanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel momentsOfLearningpanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html113().asString());
      // Setup section.
      momentsOfLearningpanel.setStyleName("");


      return momentsOfLearningpanel;
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
     * Getter for resourcemomentsOfLearningLabel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_resourcemomentsOfLearningLabel() {
      return build_resourcemomentsOfLearningLabel();
    }
    private com.google.gwt.user.client.ui.Label build_resourcemomentsOfLearningLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label resourcemomentsOfLearningLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      resourcemomentsOfLearningLabel.setStyleName("" + get_res().css().resourceCategoryLabel() + "");


      owner.resourcemomentsOfLearningLabel = resourcemomentsOfLearningLabel;

      return resourcemomentsOfLearningLabel;
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
     * Getter for domId128Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for f_HTMLPanel60 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel60() {
      return build_f_HTMLPanel60();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel60() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel60 = new com.google.gwt.user.client.ui.HTMLPanel(template_html116().asString());
      // Setup section.
      f_HTMLPanel60.setStyleName("" + get_res().css().myEducationArrowleftContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4297 = UiBinderUtil.attachToDom(f_HTMLPanel60.getElement());
      get_domId133Element().get();

      // Detach section.
      attachRecord4297.detach();
      f_HTMLPanel60.addAndReplaceElement(get_momentsOfLearningDropDownLbl(), get_domId133Element().get());

      return f_HTMLPanel60;
    }

    /**
     * Getter for domId133 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for momentsOfLearningDropDownLbl called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_momentsOfLearningDropDownLbl() {
      return build_momentsOfLearningDropDownLbl();
    }
    private com.google.gwt.user.client.ui.Label build_momentsOfLearningDropDownLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label momentsOfLearningDropDownLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      momentsOfLearningDropDownLbl.setStyleName("" + get_res().css().myFolderCollectionPopupSprite() + " " + get_res().css().myFolderCollectionArrowleft() + "");
      momentsOfLearningDropDownLbl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames33);


      return momentsOfLearningDropDownLbl;
    }

    /**
     * Getter for domId133Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId127Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId134 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for mandatorymomentsOfLearninglLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_mandatorymomentsOfLearninglLbl() {
      return build_mandatorymomentsOfLearninglLbl();
    }
    private com.google.gwt.user.client.ui.Label build_mandatorymomentsOfLearninglLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label mandatorymomentsOfLearninglLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      mandatorymomentsOfLearninglLbl.setStyleName("" + get_res().css().addNewResourceMandatoryCategory() + "");


      owner.mandatorymomentsOfLearninglLbl = mandatorymomentsOfLearninglLbl;

      return mandatorymomentsOfLearninglLbl;
    }

    /**
     * Getter for domId134Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId126Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId124Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
     * Getter for momentsOfLearningPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_momentsOfLearningPanel() {
      return build_momentsOfLearningPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_momentsOfLearningPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel momentsOfLearningPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html130().asString());
      // Setup section.
      momentsOfLearningPanel.setStyleName("" + get_res().css().reorderLabelContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4298 = UiBinderUtil.attachToDom(momentsOfLearningPanel.getElement());
      get_domId136Element().get();

      // Detach section.
      attachRecord4298.detach();
      momentsOfLearningPanel.addAndReplaceElement(get_f_HTMLPanel61(), get_domId136Element().get());

      owner.momentsOfLearningPanel = momentsOfLearningPanel;

      return momentsOfLearningPanel;
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
     * Getter for f_HTMLPanel61 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel61() {
      return build_f_HTMLPanel61();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel61() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel61 = new com.google.gwt.user.client.ui.HTMLPanel(template_html129().asString());
      // Setup section.
      f_HTMLPanel61.setStyleName("" + get_res().css().myEducationEditDropdown() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4299 = UiBinderUtil.attachToDom(f_HTMLPanel61.getElement());
      get_domId137Element().get();
      get_domId140Element().get();
      get_domId143Element().get();

      // Detach section.
      attachRecord4299.detach();
      f_HTMLPanel61.addAndReplaceElement(get_preparingTheLearningPanel(), get_domId137Element().get());
      f_HTMLPanel61.addAndReplaceElement(get_interactingWithTheTextPanel(), get_domId140Element().get());
      f_HTMLPanel61.addAndReplaceElement(get_extendingUnderstandingPanel(), get_domId143Element().get());

      return f_HTMLPanel61;
    }

    /**
     * Getter for domId137 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for preparingTheLearningPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_preparingTheLearningPanel() {
      return build_preparingTheLearningPanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_preparingTheLearningPanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel preparingTheLearningPanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html122().asString());
      // Setup section.
      preparingTheLearningPanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoOuterContainer() + "");
      preparingTheLearningPanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames30);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4300 = UiBinderUtil.attachToDom(preparingTheLearningPanel.getElement());
      get_domId138Element().get();

      // Detach section.
      attachRecord4300.detach();
      preparingTheLearningPanel.addAndReplaceElement(get_f_HTMLPanel62(), get_domId138Element().get());

      return preparingTheLearningPanel;
    }

    /**
     * Getter for domId138 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel62 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel62() {
      return build_f_HTMLPanel62();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel62() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel62 = new com.google.gwt.user.client.ui.HTMLPanel(template_html121().asString());
      // Setup section.
      f_HTMLPanel62.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4301 = UiBinderUtil.attachToDom(f_HTMLPanel62.getElement());
      get_domId139Element().get();

      // Detach section.
      attachRecord4301.detach();
      f_HTMLPanel62.addAndReplaceElement(get_preparingTheLearningText(), get_domId139Element().get());

      return f_HTMLPanel62;
    }

    /**
     * Getter for domId139 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for preparingTheLearningText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_preparingTheLearningText() {
      return build_preparingTheLearningText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_preparingTheLearningText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel preparingTheLearningText = new com.google.gwt.user.client.ui.HTMLPanel(template_html120().asString());
      // Setup section.
      preparingTheLearningText.setStyleName("" + get_res().css().myEducationalPanelSubTitles() + "");


      owner.preparingTheLearningText = preparingTheLearningText;

      return preparingTheLearningText;
    }

    /**
     * Getter for domId139Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId138Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId137Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId140 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for interactingWithTheTextPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_interactingWithTheTextPanel() {
      return build_interactingWithTheTextPanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_interactingWithTheTextPanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel interactingWithTheTextPanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html125().asString());
      // Setup section.
      interactingWithTheTextPanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoOuterContainer() + "");
      interactingWithTheTextPanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames31);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4302 = UiBinderUtil.attachToDom(interactingWithTheTextPanel.getElement());
      get_domId141Element().get();

      // Detach section.
      attachRecord4302.detach();
      interactingWithTheTextPanel.addAndReplaceElement(get_f_HTMLPanel63(), get_domId141Element().get());

      return interactingWithTheTextPanel;
    }

    /**
     * Getter for domId141 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel63 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel63() {
      return build_f_HTMLPanel63();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel63() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel63 = new com.google.gwt.user.client.ui.HTMLPanel(template_html124().asString());
      // Setup section.
      f_HTMLPanel63.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4303 = UiBinderUtil.attachToDom(f_HTMLPanel63.getElement());
      get_domId142Element().get();

      // Detach section.
      attachRecord4303.detach();
      f_HTMLPanel63.addAndReplaceElement(get_interactingWithTheTextText(), get_domId142Element().get());

      return f_HTMLPanel63;
    }

    /**
     * Getter for domId142 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for interactingWithTheTextText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_interactingWithTheTextText() {
      return build_interactingWithTheTextText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_interactingWithTheTextText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel interactingWithTheTextText = new com.google.gwt.user.client.ui.HTMLPanel(template_html123().asString());
      // Setup section.
      interactingWithTheTextText.setStyleName("" + get_res().css().myEducationalPanelSubTitles() + "");


      owner.interactingWithTheTextText = interactingWithTheTextText;

      return interactingWithTheTextText;
    }

    /**
     * Getter for domId142Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId141Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId140Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId143 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for extendingUnderstandingPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_extendingUnderstandingPanel() {
      return build_extendingUnderstandingPanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_extendingUnderstandingPanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel extendingUnderstandingPanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html128().asString());
      // Setup section.
      extendingUnderstandingPanel.setStyleName("" + get_res().css().myFolderCollectionFolderVideoOuterContainer() + "");
      extendingUnderstandingPanel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames32);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4304 = UiBinderUtil.attachToDom(extendingUnderstandingPanel.getElement());
      get_domId144Element().get();

      // Detach section.
      attachRecord4304.detach();
      extendingUnderstandingPanel.addAndReplaceElement(get_f_HTMLPanel64(), get_domId144Element().get());

      return extendingUnderstandingPanel;
    }

    /**
     * Getter for domId144 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId144;
    private java.lang.String get_domId144() {
      return domId144;
    }
    private java.lang.String build_domId144() {
      // Creation section.
      domId144 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId144;
    }

    /**
     * Getter for f_HTMLPanel64 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel64() {
      return build_f_HTMLPanel64();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel64() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel64 = new com.google.gwt.user.client.ui.HTMLPanel(template_html127().asString());
      // Setup section.
      f_HTMLPanel64.setStyleName("" + get_res().css().myFolderCollectionFolderVideoContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4305 = UiBinderUtil.attachToDom(f_HTMLPanel64.getElement());
      get_domId145Element().get();

      // Detach section.
      attachRecord4305.detach();
      f_HTMLPanel64.addAndReplaceElement(get_extendingUnderstandingText(), get_domId145Element().get());

      return f_HTMLPanel64;
    }

    /**
     * Getter for domId145 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId145;
    private java.lang.String get_domId145() {
      return domId145;
    }
    private java.lang.String build_domId145() {
      // Creation section.
      domId145 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId145;
    }

    /**
     * Getter for extendingUnderstandingText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_extendingUnderstandingText() {
      return build_extendingUnderstandingText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_extendingUnderstandingText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel extendingUnderstandingText = new com.google.gwt.user.client.ui.HTMLPanel(template_html126().asString());
      // Setup section.
      extendingUnderstandingText.setStyleName("" + get_res().css().myEducationalPanelSubTitles() + "");


      owner.extendingUnderstandingText = extendingUnderstandingText;

      return extendingUnderstandingText;
    }

    /**
     * Getter for domId145Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId145Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId145Element() {
      return domId145Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId145Element() {
      // Creation section.
      domId145Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId145());
      // Setup section.


      return domId145Element;
    }

    /**
     * Getter for domId144Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId144Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId144Element() {
      return domId144Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId144Element() {
      // Creation section.
      domId144Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId144());
      // Setup section.


      return domId144Element;
    }

    /**
     * Getter for domId143Element called 2 times. Type: DEFAULT. Build precedence: 4.
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

    /**
     * Getter for domId146 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
     */
    private java.lang.String domId146;
    private java.lang.String get_domId146() {
      return domId146;
    }
    private java.lang.String build_domId146() {
      // Creation section.
      domId146 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId146;
    }

    /**
     * Getter for standardContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_standardContainer() {
      return build_standardContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_standardContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel standardContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      standardContainer.add(get_standardsDefaultText());
      standardContainer.add(get_f_FlowPanel65());


      owner.standardContainer = standardContainer;

      return standardContainer;
    }

    /**
     * Getter for standardsDefaultText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_standardsDefaultText() {
      return build_standardsDefaultText();
    }
    private com.google.gwt.user.client.ui.Label build_standardsDefaultText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label standardsDefaultText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      standardsDefaultText.setStyleName("" + get_res1().css().shelfGradeInfoBottom() + "");


      owner.standardsDefaultText = standardsDefaultText;

      return standardsDefaultText;
    }

    /**
     * Getter for f_FlowPanel65 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel65() {
      return build_f_FlowPanel65();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel65() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel65 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel65.add(get_f_FlowPanel66());
      f_FlowPanel65.setStyleName("" + get_res1().css().shelfCourseSubject() + "");


      return f_FlowPanel65;
    }

    /**
     * Getter for f_FlowPanel66 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel66() {
      return build_f_FlowPanel66();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel66() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel66 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel66.add(get_f_FlowPanel67());
      f_FlowPanel66.setStyleName("" + get_res1().css().addResourceSuggestedBox() + "");


      return f_FlowPanel66;
    }

    /**
     * Getter for f_FlowPanel67 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel67() {
      return build_f_FlowPanel67();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel67() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel67 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel67.add(get_standardSgstBox());
      f_FlowPanel67.add(get_standardMaxMsg());
      f_FlowPanel67.add(get_standardsPanel());
      f_FlowPanel67.setStyleName("" + get_res1().css().standardsCont() + "");


      return f_FlowPanel67;
    }

    /**
     * Getter for standardSgstBox called 1 times. Type: DEFAULT. Build precedence: 6.
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
      standardSgstBox.setWidth("255px");


      return standardSgstBox;
    }

    /**
     * Getter for standardMaxMsg called 1 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for standardsPanel called 1 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId146Element called 2 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId146Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId146Element() {
      return domId146Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId146Element() {
      // Creation section.
      domId146Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId146());
      // Setup section.


      return domId146Element;
    }

    /**
     * Getter for domId147 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
     */
    private java.lang.String domId147;
    private java.lang.String get_domId147() {
      return domId147;
    }
    private java.lang.String build_domId147() {
      // Creation section.
      domId147 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId147;
    }

    /**
     * Getter for f_HTMLPanel68 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel68() {
      return build_f_HTMLPanel68();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel68() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel68 = new com.google.gwt.user.client.ui.HTMLPanel(template_html143().asString());
      // Setup section.
      f_HTMLPanel68.setStyleName("" + get_res().css().standardsInEditResource() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4306 = UiBinderUtil.attachToDom(f_HTMLPanel68.getElement());
      get_domId148Element().get();
      get_domId149Element().get();
      get_domId157Element().get();
      get_domId158Element().get();
      get_domId159Element().get();
      get_domId160Element().get();
      get_domId161Element().get();

      // Detach section.
      attachRecord4306.detach();
      f_HTMLPanel68.addAndReplaceElement(get_thumbnailLbl(), get_domId148Element().get());
      f_HTMLPanel68.addAndReplaceElement(get_f_HTMLPanel69(), get_domId149Element().get());
      f_HTMLPanel68.addAndReplaceElement(get_orLbl(), get_domId157Element().get());
      f_HTMLPanel68.addAndReplaceElement(get_uploadImageLbl(), get_domId158Element().get());
      f_HTMLPanel68.addAndReplaceElement(get_f_HTMLPanel73(), get_domId159Element().get());
      f_HTMLPanel68.addAndReplaceElement(get_f_HTMLPanel74(), get_domId160Element().get());
      f_HTMLPanel68.addAndReplaceElement(get_f_HTMLPanel75(), get_domId161Element().get());

      return f_HTMLPanel68;
    }

    /**
     * Getter for domId148 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId148;
    private java.lang.String get_domId148() {
      return domId148;
    }
    private java.lang.String build_domId148() {
      // Creation section.
      domId148 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId148;
    }

    /**
     * Getter for thumbnailLbl called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_thumbnailLbl() {
      return build_thumbnailLbl();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_thumbnailLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel thumbnailLbl = new com.google.gwt.user.client.ui.HTMLPanel(template_html131().asString());
      // Setup section.
      thumbnailLbl.setStyleName("" + get_res().css().myFolderCollectionThumbImageDesc() + "");


      owner.thumbnailLbl = thumbnailLbl;

      return thumbnailLbl;
    }

    /**
     * Getter for domId148Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId148Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId148Element() {
      return domId148Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId148Element() {
      // Creation section.
      domId148Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId148());
      // Setup section.


      return domId148Element;
    }

    /**
     * Getter for domId149 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId149;
    private java.lang.String get_domId149() {
      return domId149;
    }
    private java.lang.String build_domId149() {
      // Creation section.
      domId149 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId149;
    }

    /**
     * Getter for f_HTMLPanel69 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel69() {
      return build_f_HTMLPanel69();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel69() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel69 = new com.google.gwt.user.client.ui.HTMLPanel(template_html135().asString());
      // Setup section.
      f_HTMLPanel69.setStyleName("" + get_res().css().myFolderCollectionThumbRect() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4307 = UiBinderUtil.attachToDom(f_HTMLPanel69.getElement());
      get_domId150Element().get();
      get_domId152Element().get();
      get_domId154Element().get();

      // Detach section.
      attachRecord4307.detach();
      f_HTMLPanel69.addAndReplaceElement(get_f_HTMLPanel70(), get_domId150Element().get());
      f_HTMLPanel69.addAndReplaceElement(get_f_HTMLPanel71(), get_domId152Element().get());
      f_HTMLPanel69.addAndReplaceElement(get_f_HTMLPanel72(), get_domId154Element().get());

      return f_HTMLPanel69;
    }

    /**
     * Getter for domId150 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId150;
    private java.lang.String get_domId150() {
      return domId150;
    }
    private java.lang.String build_domId150() {
      // Creation section.
      domId150 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId150;
    }

    /**
     * Getter for f_HTMLPanel70 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel70() {
      return build_f_HTMLPanel70();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel70() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel70 = new com.google.gwt.user.client.ui.HTMLPanel(template_html132().asString());
      // Setup section.
      f_HTMLPanel70.setStyleName("" + get_res().css().myFolderCollectionThumbArrLContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4308 = UiBinderUtil.attachToDom(f_HTMLPanel70.getElement());
      get_domId151Element().get();

      // Detach section.
      attachRecord4308.detach();
      f_HTMLPanel70.addAndReplaceElement(get_leftArrowLbl(), get_domId151Element().get());

      return f_HTMLPanel70;
    }

    /**
     * Getter for domId151 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId151;
    private java.lang.String get_domId151() {
      return domId151;
    }
    private java.lang.String build_domId151() {
      // Creation section.
      domId151 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId151;
    }

    /**
     * Getter for leftArrowLbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_leftArrowLbl() {
      return build_leftArrowLbl();
    }
    private com.google.gwt.user.client.ui.Label build_leftArrowLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label leftArrowLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      leftArrowLbl.setStyleName("" + get_res().css().myFolderCollectionPopupSprite() + " " + get_res().css().myFolderCollectionThumbArrLeftIcon() + "");
      leftArrowLbl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);


      owner.leftArrowLbl = leftArrowLbl;

      return leftArrowLbl;
    }

    /**
     * Getter for domId151Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId151Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId151Element() {
      return domId151Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId151Element() {
      // Creation section.
      domId151Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId151());
      // Setup section.


      return domId151Element;
    }

    /**
     * Getter for domId150Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId150Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId150Element() {
      return domId150Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId150Element() {
      // Creation section.
      domId150Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId150());
      // Setup section.


      return domId150Element;
    }

    /**
     * Getter for domId152 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId152;
    private java.lang.String get_domId152() {
      return domId152;
    }
    private java.lang.String build_domId152() {
      // Creation section.
      domId152 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId152;
    }

    /**
     * Getter for f_HTMLPanel71 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel71() {
      return build_f_HTMLPanel71();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel71() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel71 = new com.google.gwt.user.client.ui.HTMLPanel(template_html133().asString());
      // Setup section.
      f_HTMLPanel71.setStyleName("" + get_res().css().myFolderCollectionThumbArrRContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4309 = UiBinderUtil.attachToDom(f_HTMLPanel71.getElement());
      get_domId153Element().get();

      // Detach section.
      attachRecord4309.detach();
      f_HTMLPanel71.addAndReplaceElement(get_rightArrowLbl(), get_domId153Element().get());

      return f_HTMLPanel71;
    }

    /**
     * Getter for domId153 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId153;
    private java.lang.String get_domId153() {
      return domId153;
    }
    private java.lang.String build_domId153() {
      // Creation section.
      domId153 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId153;
    }

    /**
     * Getter for rightArrowLbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_rightArrowLbl() {
      return build_rightArrowLbl();
    }
    private com.google.gwt.user.client.ui.Label build_rightArrowLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label rightArrowLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      rightArrowLbl.setStyleName("" + get_res().css().myFolderCollectionPopupSprite() + " " + get_res().css().myFolderCollectionThumbArrRightIcon() + "");
      rightArrowLbl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5);


      owner.rightArrowLbl = rightArrowLbl;

      return rightArrowLbl;
    }

    /**
     * Getter for domId153Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId153Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId153Element() {
      return domId153Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId153Element() {
      // Creation section.
      domId153Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId153());
      // Setup section.


      return domId153Element;
    }

    /**
     * Getter for domId152Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId152Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId152Element() {
      return domId152Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId152Element() {
      // Creation section.
      domId152Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId152());
      // Setup section.


      return domId152Element;
    }

    /**
     * Getter for domId154 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId154;
    private java.lang.String get_domId154() {
      return domId154;
    }
    private java.lang.String build_domId154() {
      // Creation section.
      domId154 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId154;
    }

    /**
     * Getter for f_HTMLPanel72 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel72() {
      return build_f_HTMLPanel72();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel72() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel72 = new com.google.gwt.user.client.ui.HTMLPanel(template_html134().asString());
      // Setup section.
      f_HTMLPanel72.setStyleName("" + get_res().css().myFolderCollectionThumbRectDesc() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4310 = UiBinderUtil.attachToDom(f_HTMLPanel72.getElement());
      get_domId155Element().get();
      get_domId156Element().get();

      // Detach section.
      attachRecord4310.detach();
      f_HTMLPanel72.addAndReplaceElement(get_generateImageLbl(), get_domId155Element().get());
      f_HTMLPanel72.addAndReplaceElement(get_setThumbnailImage(), get_domId156Element().get());

      return f_HTMLPanel72;
    }

    /**
     * Getter for domId155 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId155;
    private java.lang.String get_domId155() {
      return domId155;
    }
    private java.lang.String build_domId155() {
      // Creation section.
      domId155 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId155;
    }

    /**
     * Getter for generateImageLbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_generateImageLbl() {
      return build_generateImageLbl();
    }
    private com.google.gwt.user.client.ui.Label build_generateImageLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label generateImageLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      generateImageLbl.setStyleName("");


      owner.generateImageLbl = generateImageLbl;

      return generateImageLbl;
    }

    /**
     * Getter for domId155Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId155Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId155Element() {
      return domId155Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId155Element() {
      // Creation section.
      domId155Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId155());
      // Setup section.


      return domId155Element;
    }

    /**
     * Getter for domId156 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId156;
    private java.lang.String get_domId156() {
      return domId156;
    }
    private java.lang.String build_domId156() {
      // Creation section.
      domId156 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId156;
    }

    /**
     * Getter for setThumbnailImage called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Image get_setThumbnailImage() {
      return build_setThumbnailImage();
    }
    private com.google.gwt.user.client.ui.Image build_setThumbnailImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image setThumbnailImage = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      setThumbnailImage.setStyleName("" + get_res().css().resourceThumbnailImage() + "");
      setThumbnailImage.setUrl("");


      owner.setThumbnailImage = setThumbnailImage;

      return setThumbnailImage;
    }

    /**
     * Getter for domId156Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId156Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId156Element() {
      return domId156Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId156Element() {
      // Creation section.
      domId156Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId156());
      // Setup section.


      return domId156Element;
    }

    /**
     * Getter for domId154Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId154Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId154Element() {
      return domId154Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId154Element() {
      // Creation section.
      domId154Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId154());
      // Setup section.


      return domId154Element;
    }

    /**
     * Getter for domId149Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId149Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId149Element() {
      return domId149Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId149Element() {
      // Creation section.
      domId149Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId149());
      // Setup section.


      return domId149Element;
    }

    /**
     * Getter for domId157 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId157;
    private java.lang.String get_domId157() {
      return domId157;
    }
    private java.lang.String build_domId157() {
      // Creation section.
      domId157 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId157;
    }

    /**
     * Getter for orLbl called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_orLbl() {
      return build_orLbl();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_orLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel orLbl = new com.google.gwt.user.client.ui.HTMLPanel(template_html136().asString());
      // Setup section.
      orLbl.setStyleName("" + get_res().css().myFolderCollectionThumbOrtext() + "");


      owner.orLbl = orLbl;

      return orLbl;
    }

    /**
     * Getter for domId157Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId157Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId157Element() {
      return domId157Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId157Element() {
      // Creation section.
      domId157Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId157());
      // Setup section.


      return domId157Element;
    }

    /**
     * Getter for domId158 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId158;
    private java.lang.String get_domId158() {
      return domId158;
    }
    private java.lang.String build_domId158() {
      // Creation section.
      domId158 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId158;
    }

    /**
     * Getter for uploadImageLbl called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_uploadImageLbl() {
      return build_uploadImageLbl();
    }
    private com.google.gwt.user.client.ui.Label build_uploadImageLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label uploadImageLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      uploadImageLbl.setStyleName("" + get_res().css().myFolderCollectionThumbUploadImagetext() + "");


      owner.uploadImageLbl = uploadImageLbl;

      return uploadImageLbl;
    }

    /**
     * Getter for domId158Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId158Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId158Element() {
      return domId158Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId158Element() {
      // Creation section.
      domId158Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId158());
      // Setup section.


      return domId158Element;
    }

    /**
     * Getter for domId159 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId159;
    private java.lang.String get_domId159() {
      return domId159;
    }
    private java.lang.String build_domId159() {
      // Creation section.
      domId159 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId159;
    }

    /**
     * Getter for f_HTMLPanel73 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel73() {
      return build_f_HTMLPanel73();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel73() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel73 = new com.google.gwt.user.client.ui.HTMLPanel(template_html137().asString());
      // Setup section.
      f_HTMLPanel73.setStyleName("" + get_res().css().myFolderCollectionRefresh() + "");


      return f_HTMLPanel73;
    }

    /**
     * Getter for domId159Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId159Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId159Element() {
      return domId159Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId159Element() {
      // Creation section.
      domId159Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId159());
      // Setup section.


      return domId159Element;
    }

    /**
     * Getter for domId160 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId160;
    private java.lang.String get_domId160() {
      return domId160;
    }
    private java.lang.String build_domId160() {
      // Creation section.
      domId160 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId160;
    }

    /**
     * Getter for f_HTMLPanel74 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel74() {
      return build_f_HTMLPanel74();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel74() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel74 = new com.google.gwt.user.client.ui.HTMLPanel(template_html138().asString());
      // Setup section.
      f_HTMLPanel74.setStyleName("" + get_res().css().clear() + "");


      return f_HTMLPanel74;
    }

    /**
     * Getter for domId160Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId160Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId160Element() {
      return domId160Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId160Element() {
      // Creation section.
      domId160Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId160());
      // Setup section.


      return domId160Element;
    }

    /**
     * Getter for domId161 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId161;
    private java.lang.String get_domId161() {
      return domId161;
    }
    private java.lang.String build_domId161() {
      // Creation section.
      domId161 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId161;
    }

    /**
     * Getter for f_HTMLPanel75 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel75() {
      return build_f_HTMLPanel75();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel75() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel75 = new com.google.gwt.user.client.ui.HTMLPanel(template_html142().asString());
      // Setup section.
      f_HTMLPanel75.setStyleName("" + get_res().css().myFolderCollectionRefreshMainContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4311 = UiBinderUtil.attachToDom(f_HTMLPanel75.getElement());
      get_domId162Element().get();

      // Detach section.
      attachRecord4311.detach();
      f_HTMLPanel75.addAndReplaceElement(get_f_HTMLPanel76(), get_domId162Element().get());

      return f_HTMLPanel75;
    }

    /**
     * Getter for domId162 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId162;
    private java.lang.String get_domId162() {
      return domId162;
    }
    private java.lang.String build_domId162() {
      // Creation section.
      domId162 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId162;
    }

    /**
     * Getter for f_HTMLPanel76 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel76() {
      return build_f_HTMLPanel76();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel76() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel76 = new com.google.gwt.user.client.ui.HTMLPanel(template_html141().asString());
      // Setup section.
      f_HTMLPanel76.setStyleName("" + get_res().css().myFolderCollectionRefreshContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4312 = UiBinderUtil.attachToDom(f_HTMLPanel76.getElement());
      get_domId163Element().get();
      get_domId165Element().get();

      // Detach section.
      attachRecord4312.detach();
      f_HTMLPanel76.addAndReplaceElement(get_f_HTMLPanel77(), get_domId163Element().get());
      f_HTMLPanel76.addAndReplaceElement(get_refreshLblPanel(), get_domId165Element().get());

      return f_HTMLPanel76;
    }

    /**
     * Getter for domId163 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId163;
    private java.lang.String get_domId163() {
      return domId163;
    }
    private java.lang.String build_domId163() {
      // Creation section.
      domId163 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId163;
    }

    /**
     * Getter for f_HTMLPanel77 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel77() {
      return build_f_HTMLPanel77();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel77() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel77 = new com.google.gwt.user.client.ui.HTMLPanel(template_html139().asString());
      // Setup section.
      f_HTMLPanel77.setStyleName("" + get_res().css().myFolderCollectionRefreshInnerContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4313 = UiBinderUtil.attachToDom(f_HTMLPanel77.getElement());
      get_domId164Element().get();

      // Detach section.
      attachRecord4313.detach();
      f_HTMLPanel77.addAndReplaceElement(get_refreshLbl(), get_domId164Element().get());

      return f_HTMLPanel77;
    }

    /**
     * Getter for domId164 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId164;
    private java.lang.String get_domId164() {
      return domId164;
    }
    private java.lang.String build_domId164() {
      // Creation section.
      domId164 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId164;
    }

    /**
     * Getter for refreshLbl called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_refreshLbl() {
      return build_refreshLbl();
    }
    private com.google.gwt.user.client.ui.Label build_refreshLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label refreshLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      refreshLbl.setStyleName("" + get_res().css().myFolderCollectionPopupSprite() + " " + get_res().css().myFolderCollectionRefreshIcon() + "");
      refreshLbl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames13);


      return refreshLbl;
    }

    /**
     * Getter for domId164Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId164Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId164Element() {
      return domId164Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId164Element() {
      // Creation section.
      domId164Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId164());
      // Setup section.


      return domId164Element;
    }

    /**
     * Getter for domId163Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId163Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId163Element() {
      return domId163Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId163Element() {
      // Creation section.
      domId163Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId163());
      // Setup section.


      return domId163Element;
    }

    /**
     * Getter for domId165 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId165;
    private java.lang.String get_domId165() {
      return domId165;
    }
    private java.lang.String build_domId165() {
      // Creation section.
      domId165 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId165;
    }

    /**
     * Getter for refreshLblPanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_refreshLblPanel() {
      return build_refreshLblPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_refreshLblPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel refreshLblPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html140().asString());
      // Setup section.
      refreshLblPanel.setStyleName("" + get_res().css().myFolderCollectionRefreshText() + "");


      owner.refreshLblPanel = refreshLblPanel;

      return refreshLblPanel;
    }

    /**
     * Getter for domId165Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId165Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId165Element() {
      return domId165Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId165Element() {
      // Creation section.
      domId165Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId165());
      // Setup section.


      return domId165Element;
    }

    /**
     * Getter for domId162Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId162Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId162Element() {
      return domId162Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId162Element() {
      // Creation section.
      domId162Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId162());
      // Setup section.


      return domId162Element;
    }

    /**
     * Getter for domId161Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId161Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId161Element() {
      return domId161Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId161Element() {
      // Creation section.
      domId161Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId161());
      // Setup section.


      return domId161Element;
    }

    /**
     * Getter for domId147Element called 2 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId147Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId147Element() {
      return domId147Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId147Element() {
      // Creation section.
      domId147Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId147());
      // Setup section.


      return domId147Element;
    }

    /**
     * Getter for domId166 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
     */
    private java.lang.String domId166;
    private java.lang.String get_domId166() {
      return domId166;
    }
    private java.lang.String build_domId166() {
      // Creation section.
      domId166 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId166;
    }

    /**
     * Getter for rightsContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_rightsContainer() {
      return build_rightsContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_rightsContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel rightsContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html151().asString());
      // Setup section.
      rightsContainer.setStyleName("" + get_res().css().resourceRightsContainerPdf() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4314 = UiBinderUtil.attachToDom(rightsContainer.getElement());
      get_domId167Element().get();
      get_domId168Element().get();
      get_domId169Element().get();

      // Detach section.
      attachRecord4314.detach();
      rightsContainer.addAndReplaceElement(get_rightsChkBox(), get_domId167Element().get());
      rightsContainer.addAndReplaceElement(get_rightsLbl(), get_domId168Element().get());
      rightsContainer.addAndReplaceElement(get_lblContentRights(), get_domId169Element().get());

      owner.rightsContainer = rightsContainer;

      return rightsContainer;
    }

    /**
     * Getter for domId167 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId167;
    private java.lang.String get_domId167() {
      return domId167;
    }
    private java.lang.String build_domId167() {
      // Creation section.
      domId167 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId167;
    }

    /**
     * Getter for rightsChkBox called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.CheckBox get_rightsChkBox() {
      return build_rightsChkBox();
    }
    private com.google.gwt.user.client.ui.CheckBox build_rightsChkBox() {
      // Creation section.
      final com.google.gwt.user.client.ui.CheckBox rightsChkBox = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
      // Setup section.
      rightsChkBox.setStyleName("" + get_res().css().resourceRightsCheckBox() + "");
      rightsChkBox.setChecked(true);


      owner.rightsChkBox = rightsChkBox;

      return rightsChkBox;
    }

    /**
     * Getter for domId167Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId167Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId167Element() {
      return domId167Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId167Element() {
      // Creation section.
      domId167Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId167());
      // Setup section.


      return domId167Element;
    }

    /**
     * Getter for domId168 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId168;
    private java.lang.String get_domId168() {
      return domId168;
    }
    private java.lang.String build_domId168() {
      // Creation section.
      domId168 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId168;
    }

    /**
     * Getter for rightsLbl called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_rightsLbl() {
      return build_rightsLbl();
    }
    private com.google.gwt.user.client.ui.Label build_rightsLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label rightsLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      rightsLbl.setStyleName("" + get_res().css().ownResourceFormDeclarationText() + "");


      owner.rightsLbl = rightsLbl;

      return rightsLbl;
    }

    /**
     * Getter for domId168Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId168Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId168Element() {
      return domId168Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId168Element() {
      // Creation section.
      domId168Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId168());
      // Setup section.


      return domId168Element;
    }

    /**
     * Getter for domId169 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId169;
    private java.lang.String get_domId169() {
      return domId169;
    }
    private java.lang.String build_domId169() {
      // Creation section.
      domId169 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId169;
    }

    /**
     * Getter for lblContentRights called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_lblContentRights() {
      return build_lblContentRights();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_lblContentRights() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel lblContentRights = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html150().asString());
      // Setup section.
      lblContentRights.setStyleName("" + get_res().css().ownResourceFormRightsContent() + "");
      lblContentRights.addMouseOverHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);
      lblContentRights.addMouseOutHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4315 = UiBinderUtil.attachToDom(lblContentRights.getElement());
      get_domId170Element().get();

      // Detach section.
      attachRecord4315.detach();
      lblContentRights.addAndReplaceElement(get_panelContentRights(), get_domId170Element().get());

      owner.lblContentRights = lblContentRights;

      return lblContentRights;
    }

    /**
     * Getter for domId170 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId170;
    private java.lang.String get_domId170() {
      return domId170;
    }
    private java.lang.String build_domId170() {
      // Creation section.
      domId170 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId170;
    }

    /**
     * Getter for panelContentRights called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelContentRights() {
      return build_panelContentRights();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelContentRights() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelContentRights = new com.google.gwt.user.client.ui.HTMLPanel(template_html149().asString());
      // Setup section.
      panelContentRights.setStyleName("" + get_res().css().resourceRightsPopupContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4316 = UiBinderUtil.attachToDom(panelContentRights.getElement());
      get_domId171Element().get();
      get_domId172Element().get();
      get_domId173Element().get();
      get_domId174Element().get();

      // Detach section.
      attachRecord4316.detach();
      panelContentRights.addAndReplaceElement(get_f_HTMLPanel78(), get_domId171Element().get());
      panelContentRights.addAndReplaceElement(get_f_HTMLPanel79(), get_domId172Element().get());
      panelContentRights.addAndReplaceElement(get_f_HTMLPanel80(), get_domId173Element().get());
      panelContentRights.addAndReplaceElement(get_f_HTMLPanel81(), get_domId174Element().get());

      owner.panelContentRights = panelContentRights;

      return panelContentRights;
    }

    /**
     * Getter for domId171 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId171;
    private java.lang.String get_domId171() {
      return domId171;
    }
    private java.lang.String build_domId171() {
      // Creation section.
      domId171 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId171;
    }

    /**
     * Getter for f_HTMLPanel78 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel78() {
      return build_f_HTMLPanel78();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel78() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel78 = new com.google.gwt.user.client.ui.HTMLPanel(template_html144().asString());
      // Setup section.
      f_HTMLPanel78.setStyleName("" + get_res().css().arrowShadow() + "");


      return f_HTMLPanel78;
    }

    /**
     * Getter for domId171Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId171Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId171Element() {
      return domId171Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId171Element() {
      // Creation section.
      domId171Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId171());
      // Setup section.


      return domId171Element;
    }

    /**
     * Getter for domId172 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId172;
    private java.lang.String get_domId172() {
      return domId172;
    }
    private java.lang.String build_domId172() {
      // Creation section.
      domId172 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId172;
    }

    /**
     * Getter for f_HTMLPanel79 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel79() {
      return build_f_HTMLPanel79();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel79() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel79 = new com.google.gwt.user.client.ui.HTMLPanel(template_html145().asString());
      // Setup section.
      f_HTMLPanel79.setStyleName("" + get_res().css().arrowBorder() + "");


      return f_HTMLPanel79;
    }

    /**
     * Getter for domId172Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId172Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId172Element() {
      return domId172Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId172Element() {
      // Creation section.
      domId172Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId172());
      // Setup section.


      return domId172Element;
    }

    /**
     * Getter for domId173 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId173;
    private java.lang.String get_domId173() {
      return domId173;
    }
    private java.lang.String build_domId173() {
      // Creation section.
      domId173 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId173;
    }

    /**
     * Getter for f_HTMLPanel80 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel80() {
      return build_f_HTMLPanel80();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel80() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel80 = new com.google.gwt.user.client.ui.HTMLPanel(template_html146().asString());
      // Setup section.
      f_HTMLPanel80.setStyleName("" + get_res().css().arrow() + "");


      return f_HTMLPanel80;
    }

    /**
     * Getter for domId173Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId173Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId173Element() {
      return domId173Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId173Element() {
      // Creation section.
      domId173Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId173());
      // Setup section.


      return domId173Element;
    }

    /**
     * Getter for domId174 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId174;
    private java.lang.String get_domId174() {
      return domId174;
    }
    private java.lang.String build_domId174() {
      // Creation section.
      domId174 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId174;
    }

    /**
     * Getter for f_HTMLPanel81 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel81() {
      return build_f_HTMLPanel81();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel81() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel81 = new com.google.gwt.user.client.ui.HTMLPanel(template_html148().asString());
      // Setup section.
      f_HTMLPanel81.setStyleName("" + get_res().css().resourceRightsInnerPopup() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4317 = UiBinderUtil.attachToDom(f_HTMLPanel81.getElement());
      get_domId175Element().get();

      // Detach section.
      attachRecord4317.detach();
      f_HTMLPanel81.addAndReplaceElement(get_rightsContent(), get_domId175Element().get());

      return f_HTMLPanel81;
    }

    /**
     * Getter for domId175 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId175;
    private java.lang.String get_domId175() {
      return domId175;
    }
    private java.lang.String build_domId175() {
      // Creation section.
      domId175 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId175;
    }

    /**
     * Getter for rightsContent called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_rightsContent() {
      return build_rightsContent();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_rightsContent() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel rightsContent = new com.google.gwt.user.client.ui.HTMLPanel(template_html147().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4318 = UiBinderUtil.attachToDom(rightsContent.getElement());
      get_domId176Element().get();
      get_domId177Element().get();
      get_domId178Element().get();
      get_domId179Element().get();
      get_domId180Element().get();
      get_domId181Element().get();
      get_domId182Element().get();

      // Detach section.
      attachRecord4318.detach();
      rightsContent.addAndReplaceElement(get_agreeText(), get_domId176Element().get());
      rightsContent.addAndReplaceElement(get_commuGuideLinesAnr(), get_domId177Element().get());
      rightsContent.addAndReplaceElement(get_termsAndPolicyAnr(), get_domId178Element().get());
      rightsContent.addAndReplaceElement(get_privacyAnr(), get_domId179Element().get());
      rightsContent.addAndReplaceElement(get_andText(), get_domId180Element().get());
      rightsContent.addAndReplaceElement(get_copyRightAnr(), get_domId181Element().get());
      rightsContent.addAndReplaceElement(get_additionalText(), get_domId182Element().get());

      return rightsContent;
    }

    /**
     * Getter for domId176 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId176;
    private java.lang.String get_domId176() {
      return domId176;
    }
    private java.lang.String build_domId176() {
      // Creation section.
      domId176 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId176;
    }

    /**
     * Getter for agreeText called 1 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId176Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId176Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId176Element() {
      return domId176Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId176Element() {
      // Creation section.
      domId176Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId176());
      // Setup section.


      return domId176Element;
    }

    /**
     * Getter for domId177 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId177;
    private java.lang.String get_domId177() {
      return domId177;
    }
    private java.lang.String build_domId177() {
      // Creation section.
      domId177 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId177;
    }

    /**
     * Getter for commuGuideLinesAnr called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Anchor get_commuGuideLinesAnr() {
      return build_commuGuideLinesAnr();
    }
    private com.google.gwt.user.client.ui.Anchor build_commuGuideLinesAnr() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor commuGuideLinesAnr = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      commuGuideLinesAnr.setStyleName("" + get_res().css().anchorText() + "");


      owner.commuGuideLinesAnr = commuGuideLinesAnr;

      return commuGuideLinesAnr;
    }

    /**
     * Getter for domId177Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId177Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId177Element() {
      return domId177Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId177Element() {
      // Creation section.
      domId177Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId177());
      // Setup section.


      return domId177Element;
    }

    /**
     * Getter for domId178 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId178;
    private java.lang.String get_domId178() {
      return domId178;
    }
    private java.lang.String build_domId178() {
      // Creation section.
      domId178 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId178;
    }

    /**
     * Getter for termsAndPolicyAnr called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Anchor get_termsAndPolicyAnr() {
      return build_termsAndPolicyAnr();
    }
    private com.google.gwt.user.client.ui.Anchor build_termsAndPolicyAnr() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor termsAndPolicyAnr = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      termsAndPolicyAnr.setStyleName("" + get_res().css().customAnchorText() + "");


      owner.termsAndPolicyAnr = termsAndPolicyAnr;

      return termsAndPolicyAnr;
    }

    /**
     * Getter for domId178Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId178Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId178Element() {
      return domId178Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId178Element() {
      // Creation section.
      domId178Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId178());
      // Setup section.


      return domId178Element;
    }

    /**
     * Getter for domId179 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId179;
    private java.lang.String get_domId179() {
      return domId179;
    }
    private java.lang.String build_domId179() {
      // Creation section.
      domId179 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId179;
    }

    /**
     * Getter for privacyAnr called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Anchor get_privacyAnr() {
      return build_privacyAnr();
    }
    private com.google.gwt.user.client.ui.Anchor build_privacyAnr() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor privacyAnr = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      privacyAnr.setStyleName("" + get_res().css().customAnchorText() + "");


      owner.privacyAnr = privacyAnr;

      return privacyAnr;
    }

    /**
     * Getter for domId179Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId179Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId179Element() {
      return domId179Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId179Element() {
      // Creation section.
      domId179Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId179());
      // Setup section.


      return domId179Element;
    }

    /**
     * Getter for domId180 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId180;
    private java.lang.String get_domId180() {
      return domId180;
    }
    private java.lang.String build_domId180() {
      // Creation section.
      domId180 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId180;
    }

    /**
     * Getter for andText called 1 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId180Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId180Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId180Element() {
      return domId180Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId180Element() {
      // Creation section.
      domId180Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId180());
      // Setup section.


      return domId180Element;
    }

    /**
     * Getter for domId181 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId181;
    private java.lang.String get_domId181() {
      return domId181;
    }
    private java.lang.String build_domId181() {
      // Creation section.
      domId181 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId181;
    }

    /**
     * Getter for copyRightAnr called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Anchor get_copyRightAnr() {
      return build_copyRightAnr();
    }
    private com.google.gwt.user.client.ui.Anchor build_copyRightAnr() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor copyRightAnr = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      copyRightAnr.setStyleName("" + get_res().css().anchorText() + "");


      owner.copyRightAnr = copyRightAnr;

      return copyRightAnr;
    }

    /**
     * Getter for domId181Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId181Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId181Element() {
      return domId181Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId181Element() {
      // Creation section.
      domId181Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId181());
      // Setup section.


      return domId181Element;
    }

    /**
     * Getter for domId182 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId182;
    private java.lang.String get_domId182() {
      return domId182;
    }
    private java.lang.String build_domId182() {
      // Creation section.
      domId182 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId182;
    }

    /**
     * Getter for additionalText called 1 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId182Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId182Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId182Element() {
      return domId182Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId182Element() {
      // Creation section.
      domId182Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId182());
      // Setup section.


      return domId182Element;
    }

    /**
     * Getter for domId175Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId175Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId175Element() {
      return domId175Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId175Element() {
      // Creation section.
      domId175Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId175());
      // Setup section.


      return domId175Element;
    }

    /**
     * Getter for domId174Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId174Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId174Element() {
      return domId174Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId174Element() {
      // Creation section.
      domId174Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId174());
      // Setup section.


      return domId174Element;
    }

    /**
     * Getter for domId170Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId170Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId170Element() {
      return domId170Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId170Element() {
      // Creation section.
      domId170Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId170());
      // Setup section.


      return domId170Element;
    }

    /**
     * Getter for domId169Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId169Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId169Element() {
      return domId169Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId169Element() {
      // Creation section.
      domId169Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId169());
      // Setup section.


      return domId169Element;
    }

    /**
     * Getter for domId166Element called 2 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId166Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId166Element() {
      return domId166Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId166Element() {
      // Creation section.
      domId166Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId166());
      // Setup section.


      return domId166Element;
    }

    /**
     * Getter for domId183 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
     */
    private java.lang.String domId183;
    private java.lang.String get_domId183() {
      return domId183;
    }
    private java.lang.String build_domId183() {
      // Creation section.
      domId183 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId183;
    }

    /**
     * Getter for saveButtonContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_saveButtonContainer() {
      return build_saveButtonContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_saveButtonContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel saveButtonContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html152().asString());
      // Setup section.
      saveButtonContainer.setStyleName("" + get_res().css().myFolderEditButtonContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord4319 = UiBinderUtil.attachToDom(saveButtonContainer.getElement());
      get_domId184Element().get();
      get_domId185Element().get();

      // Detach section.
      attachRecord4319.detach();
      saveButtonContainer.addAndReplaceElement(get_addResourceBtn(), get_domId184Element().get());
      saveButtonContainer.addAndReplaceElement(get_cancelResourcePopupBtnLbl(), get_domId185Element().get());

      owner.saveButtonContainer = saveButtonContainer;

      return saveButtonContainer;
    }

    /**
     * Getter for domId184 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId184;
    private java.lang.String get_domId184() {
      return domId184;
    }
    private java.lang.String build_domId184() {
      // Creation section.
      domId184 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId184;
    }

    /**
     * Getter for addResourceBtn called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_addResourceBtn() {
      return build_addResourceBtn();
    }
    private com.google.gwt.user.client.ui.Button build_addResourceBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button addResourceBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      addResourceBtn.setStyleName("primary");


      owner.addResourceBtn = addResourceBtn;

      return addResourceBtn;
    }

    /**
     * Getter for domId184Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId184Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId184Element() {
      return domId184Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId184Element() {
      // Creation section.
      domId184Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId184());
      // Setup section.


      return domId184Element;
    }

    /**
     * Getter for domId185 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId185;
    private java.lang.String get_domId185() {
      return domId185;
    }
    private java.lang.String build_domId185() {
      // Creation section.
      domId185 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId185;
    }

    /**
     * Getter for cancelResourcePopupBtnLbl called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Anchor get_cancelResourcePopupBtnLbl() {
      return build_cancelResourcePopupBtnLbl();
    }
    private com.google.gwt.user.client.ui.Anchor build_cancelResourcePopupBtnLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor cancelResourcePopupBtnLbl = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      cancelResourcePopupBtnLbl.setStyleName("" + get_res().css().myFolderCollectionCancel() + "");
      cancelResourcePopupBtnLbl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);


      owner.cancelResourcePopupBtnLbl = cancelResourcePopupBtnLbl;

      return cancelResourcePopupBtnLbl;
    }

    /**
     * Getter for domId185Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId185Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId185Element() {
      return domId185Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId185Element() {
      // Creation section.
      domId185Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId185());
      // Setup section.


      return domId185Element;
    }

    /**
     * Getter for domId183Element called 2 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId183Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId183Element() {
      return domId183Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId183Element() {
      // Creation section.
      domId183Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId183());
      // Setup section.


      return domId183Element;
    }

    /**
     * Getter for domId186 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
     */
    private java.lang.String domId186;
    private java.lang.String get_domId186() {
      return domId186;
    }
    private java.lang.String build_domId186() {
      // Creation section.
      domId186 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId186;
    }

    /**
     * Getter for loadingTextLbl called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_loadingTextLbl() {
      return build_loadingTextLbl();
    }
    private com.google.gwt.user.client.ui.Label build_loadingTextLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label loadingTextLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      loadingTextLbl.setStyleName("" + get_res().css().myFolderEditButtonContainer() + "");


      owner.loadingTextLbl = loadingTextLbl;

      return loadingTextLbl;
    }

    /**
     * Getter for domId186Element called 2 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId186Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId186Element() {
      return domId186Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId186Element() {
      // Creation section.
      domId186Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId186());
      // Setup section.


      return domId186Element;
    }
  }
}
