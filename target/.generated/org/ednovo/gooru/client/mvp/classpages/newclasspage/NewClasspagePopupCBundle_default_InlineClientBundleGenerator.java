package org.ednovo.gooru.client.mvp.classpages.newclasspage;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class NewClasspagePopupCBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.mvp.classpages.newclasspage.NewClasspagePopupCBundle {
  private static NewClasspagePopupCBundle_default_InlineClientBundleGenerator _instance0 = new NewClasspagePopupCBundle_default_InlineClientBundleGenerator();
  private void cssInitializer() {
    css = new org.ednovo.gooru.client.mvp.classpages.newclasspage.NewClasspagePopupCBundle.NewClasspagePopupCss() {
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
        return "css";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popup {\n  width : " + ("450px")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  padding : " + ("3px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupOuter {\n  border : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  float : " + ("right")  + ";\n  width : " + ("450px")  + ";\n  background-color : " + ("white")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupInner {\n  border : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  float : " + ("right")  + ";\n  width : " + ("442px")  + ";\n  background-color : ") + (("white")  + ";\n  margin : " + ("3px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupHeader {\n  font-family : " + ("Arial"+ ","+ " " +"Helvetica"+ ","+ " " +"sans-serif")  + ";\n  line-height : " + ("120%")  + ";\n  text-align : " + ("right")  + ";\n  padding : " + ("10px"+ " " +"15px")  + ";\n  color : " + ("white")  + ";\n  background-color : " + ("#515151")  + ";\n  font-size : " + ("16px")  + ";\n  background : " + ("-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#666" + ")"+ ","+ " " +"to(" + "#515151" + ")" + ")")  + ";\n  background : " + ("-webkit-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")") ) + (";\n  background : " + ("-moz-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  background : " + ("-ms-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupContent {\n  padding : " + ("15px")  + ";\n  float : " + ("right")  + ";\n  width : " + ("420px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupButtinContainer {\n  width : " + ("100%")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  text-align : " + ("center")  + ";\n  padding-bottom : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupOkButton {\n  color : ") + (("white")  + ";\n  background-color : " + ("#1076bb")  + ";\n  border-radius : " + ("4px")  + ";\n  padding : " + ("8px"+ " " +"9px")  + ";\n  border : " + ("none")  + ";\n  font-weight : " + ("bold")  + ";\n  margin : " + ("10px"+ " " +"0")  + ";\n  font-family : " + ("Arial"+ ","+ " " +"sans-serif")  + ";\n  display : " + ("inline-block")  + ";\n  margin : " + ("10px")  + ";\n  background : " + ("-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#4c98cc" + ")"+ ","+ " " +"to(" + "#1076bb" + ")" + ")") ) + (";\n  background : " + ("-webkit-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("-moz-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("-ms-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  float : " + ("right")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupOkButton:hover {\n  color : " + ("white")  + ";\n  background-color : " + ("#1076bb")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupOkCancel {\n  color : " + ("#1076bb")  + ";\n  float : " + ("right")  + ";\n  margin-top : ") + (("18px")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupTitle {\n  float : " + ("right")  + ";\n  margin-right : " + ("15%")  + ";\n  width : " + ("360px")  + ";\n  margin-bottom : " + ("8px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupInputBoxContainer {\n  float : " + ("right")  + ";\n  margin-right : " + ("15%")  + ";\n  width : " + ("300px")  + ";\n  height : " + ("30px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupMandatoryContainer {\n  float : " + ("right") ) + (";\n  margin-right : " + ("15%")  + ";\n  width : " + ("300px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupInputBox {\n  float : " + ("right")  + ";\n  width : " + ("300px")  + ";\n  height : " + ("28px")  + ";\n  color : " + ("#999")  + ";\n  border-color : " + ("#ddd")  + ";\n  border-width : " + ("1px")  + ";\n  -moz-border-radius : " + ("1px")  + ";\n  -webkit-border-radius : " + ("1px")  + ";\n  border-radius : ") + (("1px")  + ";\n  border-style : " + ("solid")  + ";\n  font-family : " + ("Arial"+ ","+ " " +"Helvetica"+ ","+ " " +"sans-serif")  + ";\n  font-size : " + ("12px")  + ";\n  padding-right : " + ("5px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupMandatoryTitleText {\n  font-family : " + ("Arial"+ ","+ " " +"Helvetica"+ ","+ " " +"sans-serif")  + ";\n  font-size : " + ("12px")  + ";\n  line-height : " + ("30%")  + ";\n  color : " + ("#fab03a")  + ";\n  text-align : " + ("left")  + ";\n  position : " + ("relative") ) + (";\n  margin : " + ("9px"+ " " +"0"+ " " +"0"+ " " +"0")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-creating {\n  text-align : " + ("center")  + ";\n  width : " + ("100%")  + ";\n  margin : " + ("auto")  + ";\n  margin-top : " + ("13px")  + ";\n  margin-bottom : " + ("24px")  + ";\n  float : " + ("right")  + ";\n  font-style : " + ("italic")  + ";\n  color : " + ("#999")  + ";\n}\n#btnAdd {\n  margin-right : " + ("10px")  + ";\n}\n")) : ((".org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popup {\n  width : " + ("450px")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  padding : " + ("3px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupOuter {\n  border : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  float : " + ("left")  + ";\n  width : " + ("450px")  + ";\n  background-color : " + ("white")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupInner {\n  border : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  float : " + ("left")  + ";\n  width : " + ("442px")  + ";\n  background-color : ") + (("white")  + ";\n  margin : " + ("3px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupHeader {\n  font-family : " + ("Arial"+ ","+ " " +"Helvetica"+ ","+ " " +"sans-serif")  + ";\n  line-height : " + ("120%")  + ";\n  text-align : " + ("left")  + ";\n  padding : " + ("10px"+ " " +"15px")  + ";\n  color : " + ("white")  + ";\n  background-color : " + ("#515151")  + ";\n  font-size : " + ("16px")  + ";\n  background : " + ("-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#666" + ")"+ ","+ " " +"to(" + "#515151" + ")" + ")")  + ";\n  background : " + ("-webkit-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")") ) + (";\n  background : " + ("-moz-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  background : " + ("-ms-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupContent {\n  padding : " + ("15px")  + ";\n  float : " + ("left")  + ";\n  width : " + ("420px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupButtinContainer {\n  width : " + ("100%")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  text-align : " + ("center")  + ";\n  padding-bottom : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupOkButton {\n  color : ") + (("white")  + ";\n  background-color : " + ("#1076bb")  + ";\n  border-radius : " + ("4px")  + ";\n  padding : " + ("8px"+ " " +"9px")  + ";\n  border : " + ("none")  + ";\n  font-weight : " + ("bold")  + ";\n  margin : " + ("10px"+ " " +"0")  + ";\n  font-family : " + ("Arial"+ ","+ " " +"sans-serif")  + ";\n  display : " + ("inline-block")  + ";\n  margin : " + ("10px")  + ";\n  background : " + ("-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#4c98cc" + ")"+ ","+ " " +"to(" + "#1076bb" + ")" + ")") ) + (";\n  background : " + ("-webkit-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("-moz-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("-ms-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  float : " + ("left")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupOkButton:hover {\n  color : " + ("white")  + ";\n  background-color : " + ("#1076bb")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupOkCancel {\n  color : " + ("#1076bb")  + ";\n  float : " + ("left")  + ";\n  margin-top : ") + (("18px")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupTitle {\n  float : " + ("left")  + ";\n  margin-left : " + ("15%")  + ";\n  width : " + ("360px")  + ";\n  margin-bottom : " + ("8px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupInputBoxContainer {\n  float : " + ("left")  + ";\n  margin-left : " + ("15%")  + ";\n  width : " + ("300px")  + ";\n  height : " + ("30px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupMandatoryContainer {\n  float : " + ("left") ) + (";\n  margin-left : " + ("15%")  + ";\n  width : " + ("300px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupInputBox {\n  float : " + ("left")  + ";\n  width : " + ("300px")  + ";\n  height : " + ("28px")  + ";\n  color : " + ("#999")  + ";\n  border-color : " + ("#ddd")  + ";\n  border-width : " + ("1px")  + ";\n  -moz-border-radius : " + ("1px")  + ";\n  -webkit-border-radius : " + ("1px")  + ";\n  border-radius : ") + (("1px")  + ";\n  border-style : " + ("solid")  + ";\n  font-family : " + ("Arial"+ ","+ " " +"Helvetica"+ ","+ " " +"sans-serif")  + ";\n  font-size : " + ("12px")  + ";\n  padding-left : " + ("5px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupMandatoryTitleText {\n  font-family : " + ("Arial"+ ","+ " " +"Helvetica"+ ","+ " " +"sans-serif")  + ";\n  font-size : " + ("12px")  + ";\n  line-height : " + ("30%")  + ";\n  color : " + ("#fab03a")  + ";\n  text-align : " + ("right")  + ";\n  position : " + ("relative") ) + (";\n  margin : " + ("9px"+ " " +"0"+ " " +"0"+ " " +"0")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-creating {\n  text-align : " + ("center")  + ";\n  width : " + ("100%")  + ";\n  margin : " + ("auto")  + ";\n  margin-top : " + ("13px")  + ";\n  margin-bottom : " + ("24px")  + ";\n  float : " + ("left")  + ";\n  font-style : " + ("italic")  + ";\n  color : " + ("#999")  + ";\n}\n#btnAdd {\n  margin-left : " + ("10px")  + ";\n}\n"));
      }
      public java.lang.String creating(){
        return "org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-creating";
      }
      public java.lang.String popup(){
        return "org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popup";
      }
      public java.lang.String popupButtinContainer(){
        return "org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupButtinContainer";
      }
      public java.lang.String popupContent(){
        return "org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupContent";
      }
      public java.lang.String popupHeader(){
        return "org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupHeader";
      }
      public java.lang.String popupInner(){
        return "org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupInner";
      }
      public java.lang.String popupInputBox(){
        return "org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupInputBox";
      }
      public java.lang.String popupInputBoxContainer(){
        return "org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupInputBoxContainer";
      }
      public java.lang.String popupMandatoryContainer(){
        return "org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupMandatoryContainer";
      }
      public java.lang.String popupMandatoryTitleText(){
        return "org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupMandatoryTitleText";
      }
      public java.lang.String popupOkButton(){
        return "org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupOkButton";
      }
      public java.lang.String popupOkCancel(){
        return "org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupOkCancel";
      }
      public java.lang.String popupOuter(){
        return "org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupOuter";
      }
      public java.lang.String popupTitle(){
        return "org-ednovo-gooru-client-mvp-classpages-newclasspage-NewClasspagePopupCBundle-NewClasspagePopupCss-popupTitle";
      }
    }
    ;
  }
  private static class cssInitializer {
    static {
      _instance0.cssInitializer();
    }
    static org.ednovo.gooru.client.mvp.classpages.newclasspage.NewClasspagePopupCBundle.NewClasspagePopupCss get() {
      return css;
    }
  }
  public org.ednovo.gooru.client.mvp.classpages.newclasspage.NewClasspagePopupCBundle.NewClasspagePopupCss css() {
    return cssInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.mvp.classpages.newclasspage.NewClasspagePopupCBundle.NewClasspagePopupCss css;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      css(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("css", css());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'css': return this.@org.ednovo.gooru.client.mvp.classpages.newclasspage.NewClasspagePopupCBundle::css()();
    }
    return null;
  }-*/;
}
