package org.ednovo.gooru.client.mvp.search;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.mvp.search.SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenBundle {
  private static SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new org.ednovo.gooru.client.mvp.search.SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-mvp-search-SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style-metaDataPanel {\n  font-size : " + ("12px")  + ";\n  font-weight : " + ("normal")  + ";\n  color : " + ("#999")  + ";\n  margin-top : " + ("0")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style-resourceThumbnailPanel {\n  clear : " + ("both")  + ";\n  height : " + ("56px")  + ";\n  padding-top : " + ("14px")  + ";\n  width : " + ("345px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style-resourceTitlePanel {\n  float : " + ("right")  + ";\n  height : " + ("60px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style-resourceTitle {\n  font-size : ") + (("12px")  + ";\n  font-weight : " + ("bold")  + ";\n  color : " + ("#515151")  + ";\n  height : " + ("20px")  + ";\n  overflow : " + ("hidden")  + ";\n  text-overflow : " + ("ellipsis")  + ";\n  white-space : " + ("nowrap")  + ";\n  cursor : " + ("pointer")  + ";\n  float : " + ("right")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style-resourceThumbnail {\n  width : " + ("81px")  + ";\n  height : " + ("61px") ) + (";\n  float : " + ("right")  + ";\n  margin : " + ("0"+ " " +"0"+ " " +"0"+ " " +"10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style-resourceThumbnails {\n  width : " + ("81px")  + ";\n  height : " + ("61px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style-resourceName {\n  font-size : " + ("12px")  + ";\n  position : " + ("relative")  + ";\n  top : " + ("-17px")  + ";\n  background-color : " + ("#4e9746")  + ";\n  text-align : " + ("center")  + ";\n  color : " + ("#fff")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style-resourceOrder {\n  color : ") + (("#515151")  + ";\n  float : " + ("right")  + ";\n  font-size : " + ("20px")  + ";\n  padding-left : " + ("8px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style-imgHeight {\n  height : " + ("16px")  + ";\n  margin-right : " + ("5px")  + ";\n  float : " + ("right")  + ";\n  cursor : " + ("pointer")  + ";\n}\n")) : ((".org-ednovo-gooru-client-mvp-search-SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style-metaDataPanel {\n  font-size : " + ("12px")  + ";\n  font-weight : " + ("normal")  + ";\n  color : " + ("#999")  + ";\n  margin-top : " + ("0")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style-resourceThumbnailPanel {\n  clear : " + ("both")  + ";\n  height : " + ("56px")  + ";\n  padding-top : " + ("14px")  + ";\n  width : " + ("345px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style-resourceTitlePanel {\n  float : " + ("left")  + ";\n  height : " + ("60px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style-resourceTitle {\n  font-size : ") + (("12px")  + ";\n  font-weight : " + ("bold")  + ";\n  color : " + ("#515151")  + ";\n  height : " + ("20px")  + ";\n  overflow : " + ("hidden")  + ";\n  text-overflow : " + ("ellipsis")  + ";\n  white-space : " + ("nowrap")  + ";\n  cursor : " + ("pointer")  + ";\n  float : " + ("left")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style-resourceThumbnail {\n  width : " + ("81px")  + ";\n  height : " + ("61px") ) + (";\n  float : " + ("left")  + ";\n  margin : " + ("0"+ " " +"10px"+ " " +"0"+ " " +"0")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style-resourceThumbnails {\n  width : " + ("81px")  + ";\n  height : " + ("61px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style-resourceName {\n  font-size : " + ("12px")  + ";\n  position : " + ("relative")  + ";\n  top : " + ("-17px")  + ";\n  background-color : " + ("#4e9746")  + ";\n  text-align : " + ("center")  + ";\n  color : " + ("#fff")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style-resourceOrder {\n  color : ") + (("#515151")  + ";\n  float : " + ("left")  + ";\n  font-size : " + ("20px")  + ";\n  padding-right : " + ("8px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style-imgHeight {\n  height : " + ("16px")  + ";\n  margin-left : " + ("5px")  + ";\n  float : " + ("left")  + ";\n  cursor : " + ("pointer")  + ";\n}\n"));
      }
      public java.lang.String imgHeight(){
        return "org-ednovo-gooru-client-mvp-search-SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style-imgHeight";
      }
      public java.lang.String metaDataPanel(){
        return "org-ednovo-gooru-client-mvp-search-SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style-metaDataPanel";
      }
      public java.lang.String resourceName(){
        return "org-ednovo-gooru-client-mvp-search-SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style-resourceName";
      }
      public java.lang.String resourceOrder(){
        return "org-ednovo-gooru-client-mvp-search-SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style-resourceOrder";
      }
      public java.lang.String resourceThumbnail(){
        return "org-ednovo-gooru-client-mvp-search-SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style-resourceThumbnail";
      }
      public java.lang.String resourceThumbnailPanel(){
        return "org-ednovo-gooru-client-mvp-search-SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style-resourceThumbnailPanel";
      }
      public java.lang.String resourceThumbnails(){
        return "org-ednovo-gooru-client-mvp-search-SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style-resourceThumbnails";
      }
      public java.lang.String resourceTitle(){
        return "org-ednovo-gooru-client-mvp-search-SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style-resourceTitle";
      }
      public java.lang.String resourceTitlePanel(){
        return "org-ednovo-gooru-client-mvp-search-SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style-resourceTitlePanel";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static org.ednovo.gooru.client.mvp.search.SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public org.ednovo.gooru.client.mvp.search.SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.mvp.search.SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@org.ednovo.gooru.client.mvp.search.SimpleResourceVc_SimpleResourceVcUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
