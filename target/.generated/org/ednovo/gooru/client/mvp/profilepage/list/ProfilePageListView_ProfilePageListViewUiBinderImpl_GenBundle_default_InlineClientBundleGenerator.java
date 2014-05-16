package org.ednovo.gooru.client.mvp.profilepage.list;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class ProfilePageListView_ProfilePageListViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListView_ProfilePageListViewUiBinderImpl_GenBundle {
  private static ProfilePageListView_ProfilePageListViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new ProfilePageListView_ProfilePageListViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListView_ProfilePageListViewUiBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-mvp-profilepage-list-ProfilePageListView_ProfilePageListViewUiBinderImpl_GenCss_style-shelfPanel {\n  float : " + ("left")  + ";\n  height : " + ("97%")  + ";\n  margin-bottom : " + ("-143px")  + ";\n  min-height : " + ("759px")  + ";\n  position : " + ("fixed")  + ";\n  left : " + ("0")  + ";\n  top : " + ("51px")  + ";\n  width : " + ("311px")  + ";\n}\n.org-ednovo-gooru-client-mvp-profilepage-list-ProfilePageListView_ProfilePageListViewUiBinderImpl_GenCss_style-shelfPanelForWorkspace {\n  height : " + ("97%")  + ";\n  margin-bottom : " + ("-143px")  + ";\n  min-height : ") + (("759px")  + ";\n  position : " + ("fixed")  + ";\n  right : " + ("62px")  + ";\n  top : " + ("173px")  + ";\n  width : " + ("311px")  + ";\n}\n.org-ednovo-gooru-client-mvp-profilepage-list-ProfilePageListView_ProfilePageListViewUiBinderImpl_GenCss_style-shelfHeader {\n  margin : " + ("0"+ " " +"0"+ " " +"0")  + ";\n  float : " + ("right")  + ";\n}\n.org-ednovo-gooru-client-mvp-profilepage-list-ProfilePageListView_ProfilePageListViewUiBinderImpl_GenCss_style-collectionScrlPanel {\n  overflow-y : " + ("hidden")  + " !important;\n  overflow-x : " + ("hidden")  + " !important;\n}\n")) : ((".org-ednovo-gooru-client-mvp-profilepage-list-ProfilePageListView_ProfilePageListViewUiBinderImpl_GenCss_style-shelfPanel {\n  float : " + ("right")  + ";\n  height : " + ("97%")  + ";\n  margin-bottom : " + ("-143px")  + ";\n  min-height : " + ("759px")  + ";\n  position : " + ("fixed")  + ";\n  right : " + ("0")  + ";\n  top : " + ("51px")  + ";\n  width : " + ("311px")  + ";\n}\n.org-ednovo-gooru-client-mvp-profilepage-list-ProfilePageListView_ProfilePageListViewUiBinderImpl_GenCss_style-shelfPanelForWorkspace {\n  height : " + ("97%")  + ";\n  margin-bottom : " + ("-143px")  + ";\n  min-height : ") + (("759px")  + ";\n  position : " + ("fixed")  + ";\n  left : " + ("62px")  + ";\n  top : " + ("173px")  + ";\n  width : " + ("311px")  + ";\n}\n.org-ednovo-gooru-client-mvp-profilepage-list-ProfilePageListView_ProfilePageListViewUiBinderImpl_GenCss_style-shelfHeader {\n  margin : " + ("0"+ " " +"0"+ " " +"0")  + ";\n  float : " + ("left")  + ";\n}\n.org-ednovo-gooru-client-mvp-profilepage-list-ProfilePageListView_ProfilePageListViewUiBinderImpl_GenCss_style-collectionScrlPanel {\n  overflow-y : " + ("hidden")  + " !important;\n  overflow-x : " + ("hidden")  + " !important;\n}\n"));
      }
      public java.lang.String collectionScrlPanel(){
        return "org-ednovo-gooru-client-mvp-profilepage-list-ProfilePageListView_ProfilePageListViewUiBinderImpl_GenCss_style-collectionScrlPanel";
      }
      public java.lang.String shelfHeader(){
        return "org-ednovo-gooru-client-mvp-profilepage-list-ProfilePageListView_ProfilePageListViewUiBinderImpl_GenCss_style-shelfHeader";
      }
      public java.lang.String shelfPanel(){
        return "org-ednovo-gooru-client-mvp-profilepage-list-ProfilePageListView_ProfilePageListViewUiBinderImpl_GenCss_style-shelfPanel";
      }
      public java.lang.String shelfPanelForWorkspace(){
        return "org-ednovo-gooru-client-mvp-profilepage-list-ProfilePageListView_ProfilePageListViewUiBinderImpl_GenCss_style-shelfPanelForWorkspace";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListView_ProfilePageListViewUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListView_ProfilePageListViewUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListView_ProfilePageListViewUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListView_ProfilePageListViewUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
