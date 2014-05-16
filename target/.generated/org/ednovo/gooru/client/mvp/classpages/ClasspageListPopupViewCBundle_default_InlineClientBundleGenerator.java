package org.ednovo.gooru.client.mvp.classpages;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class ClasspageListPopupViewCBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.mvp.classpages.ClasspageListPopupViewCBundle {
  private static ClasspageListPopupViewCBundle_default_InlineClientBundleGenerator _instance0 = new ClasspageListPopupViewCBundle_default_InlineClientBundleGenerator();
  private void cssInitializer() {
    css = new org.ednovo.gooru.client.mvp.classpages.ClasspageListPopupViewCBundle.ClasspageListCss() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-classpageListContainer {\n  background-color : " + ("white")  + ";\n  width : " + ("204px")  + " !important;\n  height : " + ("auto")  + ";\n  max-height : " + ("246px")  + " !important;\n  border : " + ("1px"+ " " +"solid"+ " " +"#999")  + ";\n  -moz-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.1" + ")")  + ";\n  -webkit-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.1" + ")")  + ";\n  box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.1" + ")")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-htmlPanelNoClasspageContainer {\n  height : " + ("auto")  + ";\n  padding : " + ("10px")  + ";\n  text-align : ") + (("right")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-htmlPanelContentContainer {\n  max-height : " + ("194px")  + ";\n  height : " + ("auto")  + ";\n  text-align : " + ("center")  + ";\n  clear : " + ("both")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-newClasspageLink {\n  text-align : " + ("right")  + ";\n  float : " + ("right")  + ";\n  text-decoration : " + ("none")  + " !important;\n  padding : " + ("9px"+ " " +"32px"+ " " +"8px"+ " " +"5px")  + ";\n  color : " + ("#515151")  + ";\n  font-size : " + ("12px") ) + (";\n  cursor : " + ("pointer")  + ";\n  width : " + ("82%")  + ";\n  background : " + ("url(images/Classpage/plus.png)"+ " " +"14px"+ " " +"9px"+ " " +"no-repeat")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-newClasspageLink:hover {\n  background-color : " + ("#cfe3f1")  + " !important;\n  color : " + ("#515151")  + ";\n  opacity : " + ("1")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-classpageListTitle {\n  float : " + ("right")  + ";\n  text-decoration : " + ("none")  + ";\n  padding : " + ("10px"+ " " +"16px"+ " " +"10px"+ " " +"10px")  + ";\n  color : " + ("#515151")  + ";\n  font-size : ") + (("12px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-classpageBottomLine {\n  background-color : " + ("#ccc")  + ";\n  width : " + ("100%")  + ";\n  height : " + ("1px")  + ";\n  float : " + ("right")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-loadingText {\n  font-style : " + ("italic")  + ";\n  color : " + ("#999")  + ";\n  text-align : " + ("center")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-htmlPanelClasspageList {\n  text-align : " + ("right")  + ";\n  width : " + ("204px")  + " !important;\n  height : " + ("auto") ) + (";\n  max-height : " + ("205px")  + " !important;\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-scrollPanelClasspageList {\n  text-align : " + ("right")  + ";\n  width : " + ("204px")  + ";\n  height : " + ("auto")  + ";\n  max-height : " + ("194px")  + " !important;\n  overflow-y : " + ("auto")  + " !important;\n  overflow-x : " + ("hidden")  + " !important;\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-plus {\n  font-weight : " + ("bold")  + ";\n  font-size : " + ("18px")  + " !important;\n  vertical-align : " + ("middle")  + ";\n  padding-left : ") + (("3px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-plusImg {\n  background : " + ("url(images/Classpage/plus.png)"+ " " +"no-repeat")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-gooruGuide {\n  text-decoration : " + ("none")  + ";\n  color : " + ("#1076bb")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-gooruGuide:hover {\n  text-decoration : " + ("none")  + ";\n  color : " + ("#87badd")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-noClasspageYet {\n  margin-bottom : " + ("20px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-classpageLoadingOnPagination {\n  font-family : " + ("Arial"+ ","+ " " +"Helvetica"+ ","+ " " +"sans-serif")  + ";\n  color : " + ("#999") ) + (";\n  padding : " + ("5px"+ " " +"15px"+ " " +"5px"+ " " +"5px")  + ";\n  font-style : " + ("italic")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-classpageTitleHeader {\n  font-family : " + ("Arial"+ ","+ " " +"Helvetica"+ ","+ " " +"sans-serif")  + ";\n  color : " + ("#515151")  + ";\n  padding : " + ("5px"+ " " +"15px"+ " " +"5px"+ " " +"5px")  + ";\n  font-size : " + ("12px")  + ";\n  white-space : " + ("nowrap")  + " !important;\n  overflow : " + ("hidden")  + ";\n  text-overflow : " + ("ellipsis")  + ";\n  width : " + ("95%")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-classpageTitleHeaderActive {\n  font-weight : ") + (("bold")  + ";\n  font-family : " + ("Arial"+ ","+ " " +"Helvetica"+ ","+ " " +"sans-serif")  + ";\n  color : " + ("#515151")  + ";\n  padding : " + ("5px"+ " " +"15px"+ " " +"5px"+ " " +"5px")  + ";\n  font-size : " + ("12px")  + ";\n  white-space : " + ("nowrap")  + " !important;\n  overflow : " + ("hidden")  + ";\n  text-overflow : " + ("ellipsis")  + ";\n  width : " + ("95%")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-classpageTitleHeader:hover, .org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-classpageTitleStudyHeader:hover, .org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-classpageTitleHeaderActive:hover {\n  background-color : " + ("#cfe3f1")  + ";\n  cursor : " + ("pointer") ) + (";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-classpageTitleStudyHeader {\n  font-family : " + ("Arial"+ ","+ " " +"Helvetica"+ ","+ " " +"sans-serif")  + ";\n  color : " + ("#515151")  + ";\n  padding : " + ("5px"+ " " +"15px"+ " " +"5px"+ " " +"5px")  + ";\n  font-size : " + ("12px")  + ";\n  white-space : " + ("nowrap")  + " !important;\n  overflow : " + ("hidden")  + ";\n  text-overflow : " + ("ellipsis")  + ";\n  width : " + ("90%")  + ";\n}\n")) : ((".org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-classpageListContainer {\n  background-color : " + ("white")  + ";\n  width : " + ("204px")  + " !important;\n  height : " + ("auto")  + ";\n  max-height : " + ("246px")  + " !important;\n  border : " + ("1px"+ " " +"solid"+ " " +"#999")  + ";\n  -moz-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.1" + ")")  + ";\n  -webkit-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.1" + ")")  + ";\n  box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.1" + ")")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-htmlPanelNoClasspageContainer {\n  height : " + ("auto")  + ";\n  padding : " + ("10px")  + ";\n  text-align : ") + (("left")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-htmlPanelContentContainer {\n  max-height : " + ("194px")  + ";\n  height : " + ("auto")  + ";\n  text-align : " + ("center")  + ";\n  clear : " + ("both")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-newClasspageLink {\n  text-align : " + ("left")  + ";\n  float : " + ("left")  + ";\n  text-decoration : " + ("none")  + " !important;\n  padding : " + ("9px"+ " " +"5px"+ " " +"8px"+ " " +"32px")  + ";\n  color : " + ("#515151")  + ";\n  font-size : " + ("12px") ) + (";\n  cursor : " + ("pointer")  + ";\n  width : " + ("82%")  + ";\n  background : " + ("url(images/Classpage/plus.png)"+ " " +"14px"+ " " +"9px"+ " " +"no-repeat")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-newClasspageLink:hover {\n  background-color : " + ("#cfe3f1")  + " !important;\n  color : " + ("#515151")  + ";\n  opacity : " + ("1")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-classpageListTitle {\n  float : " + ("left")  + ";\n  text-decoration : " + ("none")  + ";\n  padding : " + ("10px"+ " " +"10px"+ " " +"10px"+ " " +"16px")  + ";\n  color : " + ("#515151")  + ";\n  font-size : ") + (("12px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-classpageBottomLine {\n  background-color : " + ("#ccc")  + ";\n  width : " + ("100%")  + ";\n  height : " + ("1px")  + ";\n  float : " + ("left")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-loadingText {\n  font-style : " + ("italic")  + ";\n  color : " + ("#999")  + ";\n  text-align : " + ("center")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-htmlPanelClasspageList {\n  text-align : " + ("left")  + ";\n  width : " + ("204px")  + " !important;\n  height : " + ("auto") ) + (";\n  max-height : " + ("205px")  + " !important;\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-scrollPanelClasspageList {\n  text-align : " + ("left")  + ";\n  width : " + ("204px")  + ";\n  height : " + ("auto")  + ";\n  max-height : " + ("194px")  + " !important;\n  overflow-y : " + ("auto")  + " !important;\n  overflow-x : " + ("hidden")  + " !important;\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-plus {\n  font-weight : " + ("bold")  + ";\n  font-size : " + ("18px")  + " !important;\n  vertical-align : " + ("middle")  + ";\n  padding-right : ") + (("3px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-plusImg {\n  background : " + ("url(images/Classpage/plus.png)"+ " " +"no-repeat")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-gooruGuide {\n  text-decoration : " + ("none")  + ";\n  color : " + ("#1076bb")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-gooruGuide:hover {\n  text-decoration : " + ("none")  + ";\n  color : " + ("#87badd")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-noClasspageYet {\n  margin-bottom : " + ("20px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-classpageLoadingOnPagination {\n  font-family : " + ("Arial"+ ","+ " " +"Helvetica"+ ","+ " " +"sans-serif")  + ";\n  color : " + ("#999") ) + (";\n  padding : " + ("5px"+ " " +"5px"+ " " +"5px"+ " " +"15px")  + ";\n  font-style : " + ("italic")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-classpageTitleHeader {\n  font-family : " + ("Arial"+ ","+ " " +"Helvetica"+ ","+ " " +"sans-serif")  + ";\n  color : " + ("#515151")  + ";\n  padding : " + ("5px"+ " " +"5px"+ " " +"5px"+ " " +"15px")  + ";\n  font-size : " + ("12px")  + ";\n  white-space : " + ("nowrap")  + " !important;\n  overflow : " + ("hidden")  + ";\n  text-overflow : " + ("ellipsis")  + ";\n  width : " + ("95%")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-classpageTitleHeaderActive {\n  font-weight : ") + (("bold")  + ";\n  font-family : " + ("Arial"+ ","+ " " +"Helvetica"+ ","+ " " +"sans-serif")  + ";\n  color : " + ("#515151")  + ";\n  padding : " + ("5px"+ " " +"5px"+ " " +"5px"+ " " +"15px")  + ";\n  font-size : " + ("12px")  + ";\n  white-space : " + ("nowrap")  + " !important;\n  overflow : " + ("hidden")  + ";\n  text-overflow : " + ("ellipsis")  + ";\n  width : " + ("95%")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-classpageTitleHeader:hover, .org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-classpageTitleStudyHeader:hover, .org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-classpageTitleHeaderActive:hover {\n  background-color : " + ("#cfe3f1")  + ";\n  cursor : " + ("pointer") ) + (";\n}\n.org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-classpageTitleStudyHeader {\n  font-family : " + ("Arial"+ ","+ " " +"Helvetica"+ ","+ " " +"sans-serif")  + ";\n  color : " + ("#515151")  + ";\n  padding : " + ("5px"+ " " +"5px"+ " " +"5px"+ " " +"15px")  + ";\n  font-size : " + ("12px")  + ";\n  white-space : " + ("nowrap")  + " !important;\n  overflow : " + ("hidden")  + ";\n  text-overflow : " + ("ellipsis")  + ";\n  width : " + ("90%")  + ";\n}\n"));
      }
      public java.lang.String classpageBottomLine(){
        return "org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-classpageBottomLine";
      }
      public java.lang.String classpageListContainer(){
        return "org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-classpageListContainer";
      }
      public java.lang.String classpageListTitle(){
        return "org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-classpageListTitle";
      }
      public java.lang.String classpageLoadingOnPagination(){
        return "org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-classpageLoadingOnPagination";
      }
      public java.lang.String classpageTitleHeader(){
        return "org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-classpageTitleHeader";
      }
      public java.lang.String classpageTitleHeaderActive(){
        return "org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-classpageTitleHeaderActive";
      }
      public java.lang.String classpageTitleStudyHeader(){
        return "org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-classpageTitleStudyHeader";
      }
      public java.lang.String gooruGuide(){
        return "org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-gooruGuide";
      }
      public java.lang.String htmlPanelClasspageList(){
        return "org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-htmlPanelClasspageList";
      }
      public java.lang.String htmlPanelContentContainer(){
        return "org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-htmlPanelContentContainer";
      }
      public java.lang.String htmlPanelNoClasspageContainer(){
        return "org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-htmlPanelNoClasspageContainer";
      }
      public java.lang.String loadingText(){
        return "org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-loadingText";
      }
      public java.lang.String newClasspageLink(){
        return "org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-newClasspageLink";
      }
      public java.lang.String noClasspageYet(){
        return "org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-noClasspageYet";
      }
      public java.lang.String plus(){
        return "org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-plus";
      }
      public java.lang.String plusImg(){
        return "org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-plusImg";
      }
      public java.lang.String scrollPanelClasspageList(){
        return "org-ednovo-gooru-client-mvp-classpages-ClasspageListPopupViewCBundle-ClasspageListCss-scrollPanelClasspageList";
      }
    }
    ;
  }
  private static class cssInitializer {
    static {
      _instance0.cssInitializer();
    }
    static org.ednovo.gooru.client.mvp.classpages.ClasspageListPopupViewCBundle.ClasspageListCss get() {
      return css;
    }
  }
  public org.ednovo.gooru.client.mvp.classpages.ClasspageListPopupViewCBundle.ClasspageListCss css() {
    return cssInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.mvp.classpages.ClasspageListPopupViewCBundle.ClasspageListCss css;
  
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
      case 'css': return this.@org.ednovo.gooru.client.mvp.classpages.ClasspageListPopupViewCBundle::css()();
    }
    return null;
  }-*/;
}
