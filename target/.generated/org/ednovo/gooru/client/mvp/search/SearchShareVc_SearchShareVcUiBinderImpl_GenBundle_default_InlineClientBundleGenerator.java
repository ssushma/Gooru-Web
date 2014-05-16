package org.ednovo.gooru.client.mvp.search;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class SearchShareVc_SearchShareVcUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.mvp.search.SearchShareVc_SearchShareVcUiBinderImpl_GenBundle {
  private static SearchShareVc_SearchShareVcUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new SearchShareVc_SearchShareVcUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new org.ednovo.gooru.client.mvp.search.SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-shareShortenUrl {\n  border : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  color : " + ("#1076bb")  + ";\n  font-size : " + ("12px")  + ";\n  height : " + ("18px")  + ";\n  width : " + ("95%")  + ";\n  margin : " + ("5px"+ " " +"0"+ " " +"0"+ " " +"0")  + ";\n  padding : " + ("6px"+ " " +"5px"+ " " +"6px"+ " " +"0")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-shareShortenUrlContainer {\n  height : " + ("52px")  + ";\n  width : " + ("713px")  + ";\n  margin-right : " + ("12px")  + ";\n  padding-right : ") + (("3px")  + ";\n  margin : " + ("5px"+ " " +"10px")  + ";\n  cursor : " + ("text")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-shareShortenUrlContainerInputContainer {\n  float : " + ("right")  + ";\n  width : " + ("332px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-shareSeparatorLine {\n  float : " + ("right")  + ";\n  width : " + ("1px")  + ";\n  height : " + ("130px")  + ";\n  background-color : " + ("#ccc")  + ";\n  margin-right : " + ("10px")  + ";\n  margin-left : " + ("10px") ) + (";\n}\n.org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-shareLineInSocialMediaPartContainer {\n  float : " + ("right")  + ";\n  width : " + ("130px")  + ";\n  margin-right : " + ("20px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-shareLineInSocialMediaText {\n  float : " + ("right")  + ";\n  font-family : " + ("arial")  + ";\n  font-size : " + ("12px")  + ";\n  color : " + ("#515151")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-shareSocialMediaIconContainer {\n  float : " + ("right")  + ";\n  width : " + ("107px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-shareSocialMediaIcon {\n  float : " + ("right")  + ";\n  width : ") + (("29px")  + ";\n  height : " + ("28px")  + ";\n  margin-left : " + ("13px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-shareLineInSocialMedia {\n  width : " + ("154px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-embedContainer {\n  float : " + ("right")  + ";\n}\n")) : ((".org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-shareShortenUrl {\n  border : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  color : " + ("#1076bb")  + ";\n  font-size : " + ("12px")  + ";\n  height : " + ("18px")  + ";\n  width : " + ("95%")  + ";\n  margin : " + ("5px"+ " " +"0"+ " " +"0"+ " " +"0")  + ";\n  padding : " + ("6px"+ " " +"0"+ " " +"6px"+ " " +"5px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-shareShortenUrlContainer {\n  height : " + ("52px")  + ";\n  width : " + ("713px")  + ";\n  margin-left : " + ("12px")  + ";\n  padding-left : ") + (("3px")  + ";\n  margin : " + ("5px"+ " " +"10px")  + ";\n  cursor : " + ("text")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-shareShortenUrlContainerInputContainer {\n  float : " + ("left")  + ";\n  width : " + ("332px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-shareSeparatorLine {\n  float : " + ("left")  + ";\n  width : " + ("1px")  + ";\n  height : " + ("130px")  + ";\n  background-color : " + ("#ccc")  + ";\n  margin-left : " + ("10px")  + ";\n  margin-right : " + ("10px") ) + (";\n}\n.org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-shareLineInSocialMediaPartContainer {\n  float : " + ("left")  + ";\n  width : " + ("130px")  + ";\n  margin-left : " + ("20px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-shareLineInSocialMediaText {\n  float : " + ("left")  + ";\n  font-family : " + ("arial")  + ";\n  font-size : " + ("12px")  + ";\n  color : " + ("#515151")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-shareSocialMediaIconContainer {\n  float : " + ("left")  + ";\n  width : " + ("107px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-shareSocialMediaIcon {\n  float : " + ("left")  + ";\n  width : ") + (("29px")  + ";\n  height : " + ("28px")  + ";\n  margin-right : " + ("13px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-shareLineInSocialMedia {\n  width : " + ("154px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-embedContainer {\n  float : " + ("left")  + ";\n}\n"));
      }
      public java.lang.String embedContainer(){
        return "org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-embedContainer";
      }
      public java.lang.String shareLineInSocialMedia(){
        return "org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-shareLineInSocialMedia";
      }
      public java.lang.String shareLineInSocialMediaPartContainer(){
        return "org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-shareLineInSocialMediaPartContainer";
      }
      public java.lang.String shareLineInSocialMediaText(){
        return "org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-shareLineInSocialMediaText";
      }
      public java.lang.String shareSeparatorLine(){
        return "org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-shareSeparatorLine";
      }
      public java.lang.String shareShortenUrl(){
        return "org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-shareShortenUrl";
      }
      public java.lang.String shareShortenUrlContainer(){
        return "org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-shareShortenUrlContainer";
      }
      public java.lang.String shareShortenUrlContainerInputContainer(){
        return "org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-shareShortenUrlContainerInputContainer";
      }
      public java.lang.String shareSocialMediaIcon(){
        return "org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-shareSocialMediaIcon";
      }
      public java.lang.String shareSocialMediaIconContainer(){
        return "org-ednovo-gooru-client-mvp-search-SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style-shareSocialMediaIconContainer";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static org.ednovo.gooru.client.mvp.search.SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public org.ednovo.gooru.client.mvp.search.SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.mvp.search.SearchShareVc_SearchShareVcUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@org.ednovo.gooru.client.mvp.search.SearchShareVc_SearchShareVcUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
