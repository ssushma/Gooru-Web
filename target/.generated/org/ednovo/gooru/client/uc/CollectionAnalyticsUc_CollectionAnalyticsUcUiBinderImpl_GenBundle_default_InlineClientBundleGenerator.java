package org.ednovo.gooru.client.uc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.uc.CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenBundle {
  private static CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new org.ednovo.gooru.client.uc.CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-uc-CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenCss_style-title {\n  background : " + ("none"+ " " +"repeat"+ " " +"scroll"+ " " +"0"+ " " +"0"+ " " +"#515151")  + ";\n  color : " + ("#fff")  + ";\n  height : " + ("30px")  + ";\n  padding-right : " + ("110px")  + ";\n  font-size : " + ("16px")  + ";\n  padding-top : " + ("10px")  + ";\n  text-align : " + ("right")  + ";\n  background : " + ("-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#515151" + ")"+ ","+ " " +"to(" + "#333" + ")" + ")")  + ";\n  background : " + ("-webkit-linear-gradient(" + "top"+ ","+ " " +"#515151"+ ","+ " " +"#333" + ")")  + ";\n  background : " + ("-moz-linear-gradient(" + "top"+ ","+ " " +"#515151"+ ","+ " " +"#333" + ")")  + ";\n  background : ") + (("-ms-linear-gradient(" + "top"+ ","+ " " +"#515151"+ ","+ " " +"#333" + ")")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#515151"+ ","+ " " +"#333" + ")")  + ";\n  -moz-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.3" + ")")  + ";\n  -webkit-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.3" + ")")  + ";\n  box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.3" + ")")  + ";\n}\n.org-ednovo-gooru-client-uc-CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenCss_style-contentStyle {\n  word-wrap : " + ("break-word")  + ";\n}\n.org-ednovo-gooru-client-uc-CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenCss_style-forgetPopupCloseBtnContainer {\n  float : " + ("left")  + ";\n  padding : " + ("0"+ " " +"0"+ " " +"0"+ " " +"10px")  + ";\n  margin-top : " + ("-17px")  + ";\n}\n.org-ednovo-gooru-client-uc-CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenCss_style-forgetPopupCloseBtnContainer:hover {\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-uc-CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenCss_style-forgetPopupBtnSprite {\n  background : " + ("url(images/sprites-login.png)"+ " " +"no-repeat") ) + (";\n}\n.org-ednovo-gooru-client-uc-CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenCss_style-forgetPopupCloseBtn {\n  background-position : " + ("-52px"+ " " +"-116px")  + ";\n  width : " + ("18px")  + ";\n  height : " + ("19px")  + ";\n}\n")) : ((".org-ednovo-gooru-client-uc-CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenCss_style-title {\n  background : " + ("none"+ " " +"repeat"+ " " +"scroll"+ " " +"0"+ " " +"0"+ " " +"#515151")  + ";\n  color : " + ("#fff")  + ";\n  height : " + ("30px")  + ";\n  padding-left : " + ("110px")  + ";\n  font-size : " + ("16px")  + ";\n  padding-top : " + ("10px")  + ";\n  text-align : " + ("left")  + ";\n  background : " + ("-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#515151" + ")"+ ","+ " " +"to(" + "#333" + ")" + ")")  + ";\n  background : " + ("-webkit-linear-gradient(" + "top"+ ","+ " " +"#515151"+ ","+ " " +"#333" + ")")  + ";\n  background : " + ("-moz-linear-gradient(" + "top"+ ","+ " " +"#515151"+ ","+ " " +"#333" + ")")  + ";\n  background : ") + (("-ms-linear-gradient(" + "top"+ ","+ " " +"#515151"+ ","+ " " +"#333" + ")")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#515151"+ ","+ " " +"#333" + ")")  + ";\n  -moz-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.3" + ")")  + ";\n  -webkit-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.3" + ")")  + ";\n  box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.3" + ")")  + ";\n}\n.org-ednovo-gooru-client-uc-CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenCss_style-contentStyle {\n  word-wrap : " + ("break-word")  + ";\n}\n.org-ednovo-gooru-client-uc-CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenCss_style-forgetPopupCloseBtnContainer {\n  float : " + ("right")  + ";\n  padding : " + ("0"+ " " +"10px"+ " " +"0"+ " " +"0")  + ";\n  margin-top : " + ("-17px")  + ";\n}\n.org-ednovo-gooru-client-uc-CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenCss_style-forgetPopupCloseBtnContainer:hover {\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-uc-CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenCss_style-forgetPopupBtnSprite {\n  background : " + ("url(images/sprites-login.png)"+ " " +"no-repeat") ) + (";\n}\n.org-ednovo-gooru-client-uc-CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenCss_style-forgetPopupCloseBtn {\n  background-position : " + ("-52px"+ " " +"-116px")  + ";\n  width : " + ("18px")  + ";\n  height : " + ("19px")  + ";\n}\n"));
      }
      public java.lang.String content(){
        return "org-ednovo-gooru-client-uc-CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenCss_style-content";
      }
      public java.lang.String contentStyle(){
        return "org-ednovo-gooru-client-uc-CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenCss_style-contentStyle";
      }
      public java.lang.String forgetPopupBtnSprite(){
        return "org-ednovo-gooru-client-uc-CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenCss_style-forgetPopupBtnSprite";
      }
      public java.lang.String forgetPopupCloseBtn(){
        return "org-ednovo-gooru-client-uc-CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenCss_style-forgetPopupCloseBtn";
      }
      public java.lang.String forgetPopupCloseBtnContainer(){
        return "org-ednovo-gooru-client-uc-CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenCss_style-forgetPopupCloseBtnContainer";
      }
      public java.lang.String title(){
        return "org-ednovo-gooru-client-uc-CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenCss_style-title";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static org.ednovo.gooru.client.uc.CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public org.ednovo.gooru.client.uc.CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.uc.CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@org.ednovo.gooru.client.uc.CollectionAnalyticsUc_CollectionAnalyticsUcUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
