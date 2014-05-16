package org.ednovo.gooru.client.mvp.search;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class SearchRootView_SearchRootViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.mvp.search.SearchRootView_SearchRootViewUiBinderImpl_GenBundle {
  private static SearchRootView_SearchRootViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new SearchRootView_SearchRootViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new org.ednovo.gooru.client.mvp.search.SearchRootView_SearchRootViewUiBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-searchWrapper {\n  margin : " + ("0"+ " " +"auto")  + ";\n  width : " + ("960px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-searchTotalContainer {\n  height : " + ("auto")  + " !important;\n  margin-top : " + ("20px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-contentDiv {\n  margin : " + ("2px"+ " " +"auto"+ " " +"0")  + ";\n  width : " + ("723px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-PageNotify {\n  margin : " + ("17px"+ " " +"auto"+ " " +"0")  + ";\n  width : " + ("596px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-notifyLink {\n  color : " + ("#4e9746")  + ";\n  cursor : " + ("pointer")  + ";\n  float : ") + (("right")  + ";\n  margin : " + ("0"+ " " +"2px")  + ";\n  padding-bottom : " + ("2px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-notifyLink:HOVER {\n  border-bottom : " + ("2px"+ " " +"solid"+ " " +"#a6caa2")  + ";\n  cursor : " + ("pointer")  + ";\n  padding-bottom : " + ("2px")  + ";\n  color : " + ("#4e9746")  + ";\n  text-decoration : " + ("none")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-notifyLinks {\n  color : " + ("#4e9746")  + " !important;\n  cursor : " + ("default")  + ";\n  float : " + ("right") ) + (";\n  font-size : " + ("15px")  + ";\n  font-weight : " + ("bold")  + ";\n  margin : " + ("-3px"+ " " +"6px"+ " " +"0"+ " " +"5px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-active {\n  border-bottom : " + ("2px"+ " " +"solid"+ " " +"#4e9746")  + " !important;\n  font-weight : " + ("bold")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-bodyHeight {\n  height : " + ("auto")  + " !important;\n}\n.org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-searchResultPanel {\n  clear : " + ("both")  + ";\n  height : " + ("34px")  + ";\n  margin : " + ("20px"+ " " +"auto"+ " " +"0")  + ";\n  width : " + ("968px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-searchResult {\n  color : ") + (("#515151")  + ";\n  float : " + ("right")  + ";\n  margin : " + ("48px"+ " " +"187px"+ " " +"0"+ " " +"0")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-notifyColorLink {\n  color : " + ("#222")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-loadingImageContainer {\n  background : " + ("url(images/core/search.gif)")  + ";\n  width : " + ("130px")  + ";\n  height : " + ("100px")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  margin-top : " + ("110px")  + ";\n}\n")) : ((".org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-searchWrapper {\n  margin : " + ("0"+ " " +"auto")  + ";\n  width : " + ("960px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-searchTotalContainer {\n  height : " + ("auto")  + " !important;\n  margin-top : " + ("20px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-contentDiv {\n  margin : " + ("2px"+ " " +"auto"+ " " +"0")  + ";\n  width : " + ("723px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-PageNotify {\n  margin : " + ("17px"+ " " +"auto"+ " " +"0")  + ";\n  width : " + ("596px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-notifyLink {\n  color : " + ("#4e9746")  + ";\n  cursor : " + ("pointer")  + ";\n  float : ") + (("left")  + ";\n  margin : " + ("0"+ " " +"2px")  + ";\n  padding-bottom : " + ("2px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-notifyLink:HOVER {\n  border-bottom : " + ("2px"+ " " +"solid"+ " " +"#a6caa2")  + ";\n  cursor : " + ("pointer")  + ";\n  padding-bottom : " + ("2px")  + ";\n  color : " + ("#4e9746")  + ";\n  text-decoration : " + ("none")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-notifyLinks {\n  color : " + ("#4e9746")  + " !important;\n  cursor : " + ("default")  + ";\n  float : " + ("left") ) + (";\n  font-size : " + ("15px")  + ";\n  font-weight : " + ("bold")  + ";\n  margin : " + ("-3px"+ " " +"5px"+ " " +"0"+ " " +"6px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-active {\n  border-bottom : " + ("2px"+ " " +"solid"+ " " +"#4e9746")  + " !important;\n  font-weight : " + ("bold")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-bodyHeight {\n  height : " + ("auto")  + " !important;\n}\n.org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-searchResultPanel {\n  clear : " + ("both")  + ";\n  height : " + ("34px")  + ";\n  margin : " + ("20px"+ " " +"auto"+ " " +"0")  + ";\n  width : " + ("968px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-searchResult {\n  color : ") + (("#515151")  + ";\n  float : " + ("left")  + ";\n  margin : " + ("48px"+ " " +"0"+ " " +"0"+ " " +"187px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-notifyColorLink {\n  color : " + ("#222")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-loadingImageContainer {\n  background : " + ("url(images/core/search.gif)")  + ";\n  width : " + ("130px")  + ";\n  height : " + ("100px")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  margin-top : " + ("110px")  + ";\n}\n"));
      }
      public java.lang.String PageNotify(){
        return "org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-PageNotify";
      }
      public java.lang.String active(){
        return "org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-active";
      }
      public java.lang.String bodyHeight(){
        return "org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-bodyHeight";
      }
      public java.lang.String contentDiv(){
        return "org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-contentDiv";
      }
      public java.lang.String loadingImageContainer(){
        return "org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-loadingImageContainer";
      }
      public java.lang.String notifyColorLink(){
        return "org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-notifyColorLink";
      }
      public java.lang.String notifyLink(){
        return "org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-notifyLink";
      }
      public java.lang.String notifyLinks(){
        return "org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-notifyLinks";
      }
      public java.lang.String searchResult(){
        return "org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-searchResult";
      }
      public java.lang.String searchResultPanel(){
        return "org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-searchResultPanel";
      }
      public java.lang.String searchTotalContainer(){
        return "org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-searchTotalContainer";
      }
      public java.lang.String searchWrapper(){
        return "org-ednovo-gooru-client-mvp-search-SearchRootView_SearchRootViewUiBinderImpl_GenCss_style-searchWrapper";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static org.ednovo.gooru.client.mvp.search.SearchRootView_SearchRootViewUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public org.ednovo.gooru.client.mvp.search.SearchRootView_SearchRootViewUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.mvp.search.SearchRootView_SearchRootViewUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@org.ednovo.gooru.client.mvp.search.SearchRootView_SearchRootViewUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
