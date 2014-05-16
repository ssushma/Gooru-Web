package org.ednovo.gooru.client.mvp.search;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class SearchFilterVc_SearchFilterVcUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.mvp.search.SearchFilterVc_SearchFilterVcUiBinderImpl_GenBundle {
  private static SearchFilterVc_SearchFilterVcUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new SearchFilterVc_SearchFilterVcUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new org.ednovo.gooru.client.mvp.search.SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-searchFilterVcContainer {\n  float : " + ("right")  + ";\n  clear : " + ("both")  + ";\n  min-height : " + ("450px")  + ";\n  width : " + ("160px")  + ";\n  margin-left : " + ("10px")  + ";\n  overflow-x : " + ("hidden")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-active {\n  border-bottom : " + ("2px"+ " " +"solid"+ " " +"#4e9746")  + " !important;\n  font-weight : " + ("bold")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-titleText {\n  padding-bottom : " + ("2px")  + ";\n  margin-top : " + ("20px")  + ";\n  border-bottom : ") + (("1px"+ " " +"#ddd"+ " " +"solid")  + ";\n  font-size : " + ("16px")  + " !important;\n}\n.org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-notFound {\n  clear : " + ("both")  + ";\n  float : " + ("right")  + ";\n  color : " + ("orange")  + ";\n  display : " + ("none")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-clearAll {\n  color : " + ("#4e9746")  + ";\n  float : " + ("left")  + ";\n  width : " + ("50px")  + ";\n  cursor : " + ("pointer")  + ";\n  margin-top : " + ("15px") ) + (";\n}\n.org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-clearAll:HOVER {\n  color : " + ("#a6caa2")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-helpIconBtn {\n  position : " + ("absolute")  + ";\n  left : " + ("0")  + ";\n  margin-top : " + ("-20px")  + ";\n  margin-left : " + ("10px")  + ";\n  color : " + ("#0f76bb")  + ";\n  cursor : " + ("pointer")  + ";\n  font-size : " + ("11px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-sourceToolTip {\n  position : " + ("absolute")  + ";\n  margin-top : " + ("-10px")  + ";\n  width : ") + (("140px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-notifyLink {\n  color : " + ("#4e9746")  + ";\n  cursor : " + ("pointer")  + ";\n  float : " + ("right")  + ";\n  margin : " + ("0"+ " " +"2px")  + ";\n  padding-bottom : " + ("2px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-notifyLink:HOVER {\n  border-bottom : " + ("2px"+ " " +"solid"+ " " +"#a6caa2")  + ";\n  cursor : " + ("pointer")  + ";\n  padding-bottom : " + ("2px")  + ";\n  color : " + ("#4e9746")  + ";\n  text-decoration : " + ("none") ) + (";\n}\n.org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-notifyLinks {\n  color : " + ("#4e9746")  + " !important;\n  cursor : " + ("default")  + ";\n  float : " + ("right")  + ";\n  font-size : " + ("15px")  + ";\n  font-weight : " + ("bold")  + ";\n  margin : " + ("-3px"+ " " +"6px"+ " " +"0"+ " " +"5px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-PageNotify {\n  margin : " + ("17px"+ " " +"auto"+ " " +"0")  + ";\n  width : " + ("596px")  + ";\n  display : " + ("inline-block")  + ";\n  vertical-align : " + ("top")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-oer {\n  margin : ") + (("20px"+ " " +"auto"+ " " +"0")  + ";\n}\n")) : ((".org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-searchFilterVcContainer {\n  float : " + ("left")  + ";\n  clear : " + ("both")  + ";\n  min-height : " + ("450px")  + ";\n  width : " + ("160px")  + ";\n  margin-right : " + ("10px")  + ";\n  overflow-x : " + ("hidden")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-active {\n  border-bottom : " + ("2px"+ " " +"solid"+ " " +"#4e9746")  + " !important;\n  font-weight : " + ("bold")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-titleText {\n  padding-bottom : " + ("2px")  + ";\n  margin-top : " + ("20px")  + ";\n  border-bottom : ") + (("1px"+ " " +"#ddd"+ " " +"solid")  + ";\n  font-size : " + ("16px")  + " !important;\n}\n.org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-notFound {\n  clear : " + ("both")  + ";\n  float : " + ("left")  + ";\n  color : " + ("orange")  + ";\n  display : " + ("none")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-clearAll {\n  color : " + ("#4e9746")  + ";\n  float : " + ("right")  + ";\n  width : " + ("50px")  + ";\n  cursor : " + ("pointer")  + ";\n  margin-top : " + ("15px") ) + (";\n}\n.org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-clearAll:HOVER {\n  color : " + ("#a6caa2")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-helpIconBtn {\n  position : " + ("absolute")  + ";\n  right : " + ("0")  + ";\n  margin-top : " + ("-20px")  + ";\n  margin-right : " + ("10px")  + ";\n  color : " + ("#0f76bb")  + ";\n  cursor : " + ("pointer")  + ";\n  font-size : " + ("11px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-sourceToolTip {\n  position : " + ("absolute")  + ";\n  margin-top : " + ("-10px")  + ";\n  width : ") + (("140px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-notifyLink {\n  color : " + ("#4e9746")  + ";\n  cursor : " + ("pointer")  + ";\n  float : " + ("left")  + ";\n  margin : " + ("0"+ " " +"2px")  + ";\n  padding-bottom : " + ("2px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-notifyLink:HOVER {\n  border-bottom : " + ("2px"+ " " +"solid"+ " " +"#a6caa2")  + ";\n  cursor : " + ("pointer")  + ";\n  padding-bottom : " + ("2px")  + ";\n  color : " + ("#4e9746")  + ";\n  text-decoration : " + ("none") ) + (";\n}\n.org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-notifyLinks {\n  color : " + ("#4e9746")  + " !important;\n  cursor : " + ("default")  + ";\n  float : " + ("left")  + ";\n  font-size : " + ("15px")  + ";\n  font-weight : " + ("bold")  + ";\n  margin : " + ("-3px"+ " " +"5px"+ " " +"0"+ " " +"6px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-PageNotify {\n  margin : " + ("17px"+ " " +"auto"+ " " +"0")  + ";\n  width : " + ("596px")  + ";\n  display : " + ("inline-block")  + ";\n  vertical-align : " + ("top")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-oer {\n  margin : ") + (("20px"+ " " +"auto"+ " " +"0")  + ";\n}\n"));
      }
      public java.lang.String PageNotify(){
        return "org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-PageNotify";
      }
      public java.lang.String active(){
        return "org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-active";
      }
      public java.lang.String clearAll(){
        return "org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-clearAll";
      }
      public java.lang.String helpIconBtn(){
        return "org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-helpIconBtn";
      }
      public java.lang.String notFound(){
        return "org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-notFound";
      }
      public java.lang.String notifyLink(){
        return "org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-notifyLink";
      }
      public java.lang.String notifyLinks(){
        return "org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-notifyLinks";
      }
      public java.lang.String oer(){
        return "org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-oer";
      }
      public java.lang.String searchFilterVcContainer(){
        return "org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-searchFilterVcContainer";
      }
      public java.lang.String sourceToolTip(){
        return "org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-sourceToolTip";
      }
      public java.lang.String titleText(){
        return "org-ednovo-gooru-client-mvp-search-SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style-titleText";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static org.ednovo.gooru.client.mvp.search.SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public org.ednovo.gooru.client.mvp.search.SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.mvp.search.SearchFilterVc_SearchFilterVcUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@org.ednovo.gooru.client.mvp.search.SearchFilterVc_SearchFilterVcUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
