package org.ednovo.gooru.client.mvp.shelf;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class ErrorPopUpCBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.mvp.shelf.ErrorPopUpCBundle {
  private static ErrorPopUpCBundle_default_InlineClientBundleGenerator _instance0 = new ErrorPopUpCBundle_default_InlineClientBundleGenerator();
  private void cssInitializer() {
    css = new org.ednovo.gooru.client.mvp.shelf.ErrorPopUpCBundle.ForgetPopUpCss() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupInnerdiv {\n  background-color : " + ("#fff")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  border-color : " + ("#ddd")  + ";\n  border-width : " + ("1px")  + ";\n  -moz-border-radius : " + ("1px")  + ";\n  -webkit-border-radius : " + ("1px")  + ";\n  border-radius : " + ("1px")  + ";\n  border-style : " + ("solid")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupHeaderBg {\n  width : " + ("100%")  + ";\n  height : " + ("39px")  + ";\n  background-color : ") + (("#515151")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupHeaderTitle {\n  float : " + ("right")  + ";\n  font-family : " + ("Arial"+ ","+ " " +"Helvetica"+ ","+ " " +"sans-serif")  + ";\n  font-size : " + ("16px")  + ";\n  line-height : " + ("120%")  + ";\n  color : " + ("#fff")  + ";\n  padding : " + ("10px"+ " " +"15px"+ " " +"5px"+ " " +"5px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupCloseBtnContainer {\n  float : " + ("left")  + ";\n  padding : " + ("10px"+ " " +"0"+ " " +"0"+ " " +"10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupCloseBtnContainer:hover {\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupBtnSprite {\n  background : " + ("url(images/sprites-login.png)"+ " " +"no-repeat") ) + (";\n}\n.org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupCloseBtn {\n  background-position : " + ("-52px"+ " " +"-116px")  + ";\n  width : " + ("18px")  + ";\n  height : " + ("19px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupCheckBoxContainer {\n  text-align : " + ("center")  + ";\n  margin-bottom : " + ("15px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupCheckBoxControl {\n  float : " + ("right")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupCheckBoxDescText {\n  margin-top : " + ("2px")  + ";\n  margin-right : " + ("159px")  + ";\n  font-size : " + ("12px")  + ";\n  float : " + ("right")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-clear {\n  clear : ") + (("both")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-loginPopupErrorMsg {\n  padding : " + ("52px")  + ";\n  font-weight : " + ("normal")  + ";\n  font-size : " + ("16px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-supportMailID {\n  float : " + ("right")  + ";\n  padding-right : " + ("3px")  + ";\n  padding-top : " + ("2px")  + ";\n  font-size : " + ("12px")  + ";\n  color : " + ("#1076ba")  + ";\n}\n")) : ((".org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupInnerdiv {\n  background-color : " + ("#fff")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  border-color : " + ("#ddd")  + ";\n  border-width : " + ("1px")  + ";\n  -moz-border-radius : " + ("1px")  + ";\n  -webkit-border-radius : " + ("1px")  + ";\n  border-radius : " + ("1px")  + ";\n  border-style : " + ("solid")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupHeaderBg {\n  width : " + ("100%")  + ";\n  height : " + ("39px")  + ";\n  background-color : ") + (("#515151")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupHeaderTitle {\n  float : " + ("left")  + ";\n  font-family : " + ("Arial"+ ","+ " " +"Helvetica"+ ","+ " " +"sans-serif")  + ";\n  font-size : " + ("16px")  + ";\n  line-height : " + ("120%")  + ";\n  color : " + ("#fff")  + ";\n  padding : " + ("10px"+ " " +"5px"+ " " +"5px"+ " " +"15px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupCloseBtnContainer {\n  float : " + ("right")  + ";\n  padding : " + ("10px"+ " " +"10px"+ " " +"0"+ " " +"0")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupCloseBtnContainer:hover {\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupBtnSprite {\n  background : " + ("url(images/sprites-login.png)"+ " " +"no-repeat") ) + (";\n}\n.org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupCloseBtn {\n  background-position : " + ("-52px"+ " " +"-116px")  + ";\n  width : " + ("18px")  + ";\n  height : " + ("19px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupCheckBoxContainer {\n  text-align : " + ("center")  + ";\n  margin-bottom : " + ("15px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupCheckBoxControl {\n  float : " + ("left")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupCheckBoxDescText {\n  margin-top : " + ("2px")  + ";\n  margin-left : " + ("159px")  + ";\n  font-size : " + ("12px")  + ";\n  float : " + ("left")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-clear {\n  clear : ") + (("both")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-loginPopupErrorMsg {\n  padding : " + ("52px")  + ";\n  font-weight : " + ("normal")  + ";\n  font-size : " + ("16px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-supportMailID {\n  float : " + ("left")  + ";\n  padding-left : " + ("3px")  + ";\n  padding-top : " + ("2px")  + ";\n  font-size : " + ("12px")  + ";\n  color : " + ("#1076ba")  + ";\n}\n"));
      }
      public java.lang.String clear(){
        return "org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-clear";
      }
      public java.lang.String errorPopupBtnSprite(){
        return "org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupBtnSprite";
      }
      public java.lang.String errorPopupCheckBoxContainer(){
        return "org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupCheckBoxContainer";
      }
      public java.lang.String errorPopupCheckBoxControl(){
        return "org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupCheckBoxControl";
      }
      public java.lang.String errorPopupCheckBoxDescText(){
        return "org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupCheckBoxDescText";
      }
      public java.lang.String errorPopupCloseBtn(){
        return "org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupCloseBtn";
      }
      public java.lang.String errorPopupCloseBtnContainer(){
        return "org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupCloseBtnContainer";
      }
      public java.lang.String errorPopupHeaderBg(){
        return "org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupHeaderBg";
      }
      public java.lang.String errorPopupHeaderTitle(){
        return "org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupHeaderTitle";
      }
      public java.lang.String errorPopupInnerdiv(){
        return "org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-errorPopupInnerdiv";
      }
      public java.lang.String loginPopupErrorMsg(){
        return "org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-loginPopupErrorMsg";
      }
      public java.lang.String supportMailID(){
        return "org-ednovo-gooru-client-mvp-shelf-ErrorPopUpCBundle-ForgetPopUpCss-supportMailID";
      }
    }
    ;
  }
  private static class cssInitializer {
    static {
      _instance0.cssInitializer();
    }
    static org.ednovo.gooru.client.mvp.shelf.ErrorPopUpCBundle.ForgetPopUpCss get() {
      return css;
    }
  }
  public org.ednovo.gooru.client.mvp.shelf.ErrorPopUpCBundle.ForgetPopUpCss css() {
    return cssInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.mvp.shelf.ErrorPopUpCBundle.ForgetPopUpCss css;
  
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
      case 'css': return this.@org.ednovo.gooru.client.mvp.shelf.ErrorPopUpCBundle::css()();
    }
    return null;
  }-*/;
}
