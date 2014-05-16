package org.ednovo.gooru.client.mvp.classpages.studentView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.mvp.classpages.studentView.StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenBundle {
  private static StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new org.ednovo.gooru.client.mvp.classpages.studentView.StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style() {
      private boolean injected;
      public boolean ensureInjected() {
        if (!injected) {
          injected = true;
          com.google.gwt.dom.client.StyleInjector.inject(getText());
          return true;
        }
        return false;
      }
      public String getName() {
        return "style";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-popupGlass {\n  width : " + ("100%")  + ";\n  position : " + ("absolute")  + ";\n  top : " + ("0")  + ";\n  right : " + ("0")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-popup {\n  background-color : " + ("white")  + ";\n  padding : " + ("3px")  + ";\n  width : " + ("500px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-popupInner {\n  border : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  position : " + ("relative")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-popupHeader {\n  padding : " + ("10px"+ " " +"15px")  + ";\n  color : ") + (("white")  + ";\n  background-color : " + ("#4e9746")  + ";\n  font-size : " + ("16px")  + ";\n  background : " + ("-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#7ab075" + ")"+ ","+ " " +"to(" + "#4e9746" + ")" + ")")  + ";\n  background : " + ("-webkit-linear-gradient(" + "top"+ ","+ " " +"#7ab075"+ ","+ " " +"#4e9746" + ")")  + ";\n  background : " + ("-moz-linear-gradient(" + "top"+ ","+ " " +"#7ab075"+ ","+ " " +"#4e9746" + ")")  + ";\n  background : " + ("-ms-linear-gradient(" + "top"+ ","+ " " +"#7ab075"+ ","+ " " +"#4e9746" + ")")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#7ab075"+ ","+ " " +"#4e9746" + ")")  + ";\n  filter : " + ("progid")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-popup .org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-closeButton {\n  width : " + ("17px")  + ";\n  height : " + ("17px") ) + (";\n  background : " + ("url(images/Classpage/student/close-button.png)"+ " " +"no-repeat")  + ";\n  position : " + ("absolute")  + ";\n  top : " + ("10px")  + ";\n  left : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-popup .org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-closeButton:hover {\n  opacity : " + ("0.6")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-popupContent {\n  padding : " + ("30px"+ " " +"75px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-popup.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-imgBG {\n  background : " + ("white"+ " " +"url(images/Classpage/student/registration-bg.png)"+ " " +"no-repeat")  + ";\n  background-position : " + ("-50px"+ " " +"30px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-h1, .org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-h2 {\n  color : " + ("#4c9746")  + ";\n  font-size : ") + (("20px")  + ";\n  text-align : " + ("center")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-signInContainer {\n  text-align : " + ("center")  + ";\n  margin-top : " + ("20px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-desc {\n  color : " + ("#515151")  + ";\n  font-size : " + ("12px")  + ";\n  text-align : " + ("right")  + ";\n  line-height : " + ("125%")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-headerdesc {\n  color : " + ("#515151")  + ";\n  font-size : " + ("14px")  + ";\n  text-align : " + ("center") ) + (";\n  line-height : " + ("125%")  + ";\n  margin-top : " + ("10px")  + ";\n  margin-bottom : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-descInformation {\n  color : " + ("#515151")  + ";\n  font-size : " + ("12px")  + ";\n  text-align : " + ("right")  + ";\n  line-height : " + ("125%")  + ";\n  margin-top : " + ("20px")  + ";\n  width : " + ("400px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-middleBg {\n  margin : " + ("15px"+ " " +"0")  + ";\n  min-height : ") + (("240px")  + ";\n  background-color : " + ("#999")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-privacyTxt {\n  color : " + ("#515151")  + ";\n  height : " + ("240px")  + ";\n  line-height : " + ("240px")  + ";\n  font-weight : " + ("bold")  + ";\n  text-align : " + ("center")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-btnJoin {\n  font-weight : " + ("bold")  + ";\n  padding : " + ("10px"+ " " +"20px")  + " !important;\n}\n")) : ((".org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-popupGlass {\n  width : " + ("100%")  + ";\n  position : " + ("absolute")  + ";\n  top : " + ("0")  + ";\n  left : " + ("0")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-popup {\n  background-color : " + ("white")  + ";\n  padding : " + ("3px")  + ";\n  width : " + ("500px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-popupInner {\n  border : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  position : " + ("relative")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-popupHeader {\n  padding : " + ("10px"+ " " +"15px")  + ";\n  color : ") + (("white")  + ";\n  background-color : " + ("#4e9746")  + ";\n  font-size : " + ("16px")  + ";\n  background : " + ("-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#7ab075" + ")"+ ","+ " " +"to(" + "#4e9746" + ")" + ")")  + ";\n  background : " + ("-webkit-linear-gradient(" + "top"+ ","+ " " +"#7ab075"+ ","+ " " +"#4e9746" + ")")  + ";\n  background : " + ("-moz-linear-gradient(" + "top"+ ","+ " " +"#7ab075"+ ","+ " " +"#4e9746" + ")")  + ";\n  background : " + ("-ms-linear-gradient(" + "top"+ ","+ " " +"#7ab075"+ ","+ " " +"#4e9746" + ")")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#7ab075"+ ","+ " " +"#4e9746" + ")")  + ";\n  filter : " + ("progid")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-popup .org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-closeButton {\n  width : " + ("17px")  + ";\n  height : " + ("17px") ) + (";\n  background : " + ("url(images/Classpage/student/close-button.png)"+ " " +"no-repeat")  + ";\n  position : " + ("absolute")  + ";\n  top : " + ("10px")  + ";\n  right : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-popup .org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-closeButton:hover {\n  opacity : " + ("0.6")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-popupContent {\n  padding : " + ("30px"+ " " +"75px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-popup.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-imgBG {\n  background : " + ("white"+ " " +"url(images/Classpage/student/registration-bg.png)"+ " " +"no-repeat")  + ";\n  background-position : " + ("-50px"+ " " +"30px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-h1, .org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-h2 {\n  color : " + ("#4c9746")  + ";\n  font-size : ") + (("20px")  + ";\n  text-align : " + ("center")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-signInContainer {\n  text-align : " + ("center")  + ";\n  margin-top : " + ("20px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-desc {\n  color : " + ("#515151")  + ";\n  font-size : " + ("12px")  + ";\n  text-align : " + ("left")  + ";\n  line-height : " + ("125%")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-headerdesc {\n  color : " + ("#515151")  + ";\n  font-size : " + ("14px")  + ";\n  text-align : " + ("center") ) + (";\n  line-height : " + ("125%")  + ";\n  margin-top : " + ("10px")  + ";\n  margin-bottom : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-descInformation {\n  color : " + ("#515151")  + ";\n  font-size : " + ("12px")  + ";\n  text-align : " + ("left")  + ";\n  line-height : " + ("125%")  + ";\n  margin-top : " + ("20px")  + ";\n  width : " + ("400px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-middleBg {\n  margin : " + ("15px"+ " " +"0")  + ";\n  min-height : ") + (("240px")  + ";\n  background-color : " + ("#999")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-privacyTxt {\n  color : " + ("#515151")  + ";\n  height : " + ("240px")  + ";\n  line-height : " + ("240px")  + ";\n  font-weight : " + ("bold")  + ";\n  text-align : " + ("center")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-btnJoin {\n  font-weight : " + ("bold")  + ";\n  padding : " + ("10px"+ " " +"20px")  + " !important;\n}\n"));
      }
      public java.lang.String btnJoin(){
        return "org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-btnJoin";
      }
      public java.lang.String closeButton(){
        return "org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-closeButton";
      }
      public java.lang.String desc(){
        return "org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-desc";
      }
      public java.lang.String descInformation(){
        return "org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-descInformation";
      }
      public java.lang.String h1(){
        return "org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-h1";
      }
      public java.lang.String h2(){
        return "org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-h2";
      }
      public java.lang.String headerdesc(){
        return "org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-headerdesc";
      }
      public java.lang.String imgBG(){
        return "org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-imgBG";
      }
      public java.lang.String middleBg(){
        return "org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-middleBg";
      }
      public java.lang.String popup(){
        return "org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-popup";
      }
      public java.lang.String popupContent(){
        return "org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-popupContent";
      }
      public java.lang.String popupGlass(){
        return "org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-popupGlass";
      }
      public java.lang.String popupHeader(){
        return "org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-popupHeader";
      }
      public java.lang.String popupInner(){
        return "org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-popupInner";
      }
      public java.lang.String privacyTxt(){
        return "org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-privacyTxt";
      }
      public java.lang.String signInContainer(){
        return "org-ednovo-gooru-client-mvp-classpages-studentView-StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style-signInContainer";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static org.ednovo.gooru.client.mvp.classpages.studentView.StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public org.ednovo.gooru.client.mvp.classpages.studentView.StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.mvp.classpages.studentView.StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenCss_style style;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      style(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("style", style());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'style': return this.@org.ednovo.gooru.client.mvp.classpages.studentView.StudentJoinClassPopup_StudentJoinClassPopupUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
