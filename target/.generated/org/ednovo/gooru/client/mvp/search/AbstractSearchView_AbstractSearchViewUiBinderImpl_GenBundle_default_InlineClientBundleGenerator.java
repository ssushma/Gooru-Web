package org.ednovo.gooru.client.mvp.search;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class AbstractSearchView_AbstractSearchViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.mvp.search.AbstractSearchView_AbstractSearchViewUiBinderImpl_GenBundle {
  private static AbstractSearchView_AbstractSearchViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new AbstractSearchView_AbstractSearchViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new org.ednovo.gooru.client.mvp.search.AbstractSearchView_AbstractSearchViewUiBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-mvp-search-AbstractSearchView_AbstractSearchViewUiBinderImpl_GenCss_style-searchFilter {\n  float : " + ("right")  + ";\n  clear : " + ("both")  + ";\n  min-height : " + ("450px")  + ";\n  width : " + ("160px")  + ";\n  margin-bottom : " + ("30px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-AbstractSearchView_AbstractSearchViewUiBinderImpl_GenCss_style-searchResultContainer {\n  width : " + ("600px")  + ";\n  float : " + ("right")  + ";\n  margin-right : " + ("14px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-AbstractSearchView_AbstractSearchViewUiBinderImpl_GenCss_style-paginationPanel {\n  clear : " + ("both")  + ";\n  margin-right : " + ("14px")  + ";\n  margin-bottom : ") + (("46px")  + ";\n  padding : " + ("30px"+ " " +"0")  + ";\n  text-align : " + ("right")  + ";\n}\n")) : ((".org-ednovo-gooru-client-mvp-search-AbstractSearchView_AbstractSearchViewUiBinderImpl_GenCss_style-searchFilter {\n  float : " + ("left")  + ";\n  clear : " + ("both")  + ";\n  min-height : " + ("450px")  + ";\n  width : " + ("160px")  + ";\n  margin-bottom : " + ("30px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-AbstractSearchView_AbstractSearchViewUiBinderImpl_GenCss_style-searchResultContainer {\n  width : " + ("600px")  + ";\n  float : " + ("left")  + ";\n  margin-left : " + ("14px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-AbstractSearchView_AbstractSearchViewUiBinderImpl_GenCss_style-paginationPanel {\n  clear : " + ("both")  + ";\n  margin-left : " + ("14px")  + ";\n  margin-bottom : ") + (("46px")  + ";\n  padding : " + ("30px"+ " " +"0")  + ";\n  text-align : " + ("left")  + ";\n}\n"));
      }
      public java.lang.String paginationPanel(){
        return "org-ednovo-gooru-client-mvp-search-AbstractSearchView_AbstractSearchViewUiBinderImpl_GenCss_style-paginationPanel";
      }
      public java.lang.String searchFilter(){
        return "org-ednovo-gooru-client-mvp-search-AbstractSearchView_AbstractSearchViewUiBinderImpl_GenCss_style-searchFilter";
      }
      public java.lang.String searchResultContainer(){
        return "org-ednovo-gooru-client-mvp-search-AbstractSearchView_AbstractSearchViewUiBinderImpl_GenCss_style-searchResultContainer";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static org.ednovo.gooru.client.mvp.search.AbstractSearchView_AbstractSearchViewUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public org.ednovo.gooru.client.mvp.search.AbstractSearchView_AbstractSearchViewUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.mvp.search.AbstractSearchView_AbstractSearchViewUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@org.ednovo.gooru.client.mvp.search.AbstractSearchView_AbstractSearchViewUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
