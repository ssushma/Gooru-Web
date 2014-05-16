package org.ednovo.gooru.client.uc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class AlertContentUc_AlertContentUcUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.uc.AlertContentUc_AlertContentUcUiBinderImpl_GenBundle {
  private static AlertContentUc_AlertContentUcUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new AlertContentUc_AlertContentUcUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new org.ednovo.gooru.client.uc.AlertContentUc_AlertContentUcUiBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-uc-AlertContentUc_AlertContentUcUiBinderImpl_GenCss_style-title {\n  background : " + ("none"+ " " +"repeat"+ " " +"scroll"+ " " +"0"+ " " +"0"+ " " +"#515151")  + ";\n  border-radius : " + ("4px"+ " " +"4px"+ " " +"0"+ " " +"0")  + ";\n  color : " + ("#fff")  + ";\n  height : " + ("30px")  + ";\n  padding-right : " + ("5px")  + ";\n  padding-top : " + ("10px")  + ";\n  text-align : " + ("right")  + ";\n}\n.org-ednovo-gooru-client-uc-AlertContentUc_AlertContentUcUiBinderImpl_GenCss_style-content {\n  min-height : " + ("102px")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#c1bfbf")  + ";\n  padding : " + ("10px")  + ";\n  background-color : ") + (("white")  + ";\n}\n.org-ednovo-gooru-client-uc-AlertContentUc_AlertContentUcUiBinderImpl_GenCss_style-contentStyle {\n  width : " + ("98%")  + ";\n  word-wrap : " + ("break-word")  + ";\n}\n.org-ednovo-gooru-client-uc-AlertContentUc_AlertContentUcUiBinderImpl_GenCss_style-okButton {\n  margin : " + ("5px"+ " " +"auto")  + ";\n  text-align : " + ("center")  + ";\n  width : " + ("100%")  + ";\n  margin-top : " + ("39px")  + ";\n}\n.org-ednovo-gooru-client-uc-AlertContentUc_AlertContentUcUiBinderImpl_GenCss_style-okButton button {\n  color : " + ("#515151")  + ";\n}\n.org-ednovo-gooru-client-uc-AlertContentUc_AlertContentUcUiBinderImpl_GenCss_style-okButton button:hover {\n  color : " + ("#515151")  + ";\n  background : " + ("#ddd")  + ";\n}\n")) : ((".org-ednovo-gooru-client-uc-AlertContentUc_AlertContentUcUiBinderImpl_GenCss_style-title {\n  background : " + ("none"+ " " +"repeat"+ " " +"scroll"+ " " +"0"+ " " +"0"+ " " +"#515151")  + ";\n  border-radius : " + ("4px"+ " " +"4px"+ " " +"0"+ " " +"0")  + ";\n  color : " + ("#fff")  + ";\n  height : " + ("30px")  + ";\n  padding-left : " + ("5px")  + ";\n  padding-top : " + ("10px")  + ";\n  text-align : " + ("left")  + ";\n}\n.org-ednovo-gooru-client-uc-AlertContentUc_AlertContentUcUiBinderImpl_GenCss_style-content {\n  min-height : " + ("102px")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#c1bfbf")  + ";\n  padding : " + ("10px")  + ";\n  background-color : ") + (("white")  + ";\n}\n.org-ednovo-gooru-client-uc-AlertContentUc_AlertContentUcUiBinderImpl_GenCss_style-contentStyle {\n  width : " + ("98%")  + ";\n  word-wrap : " + ("break-word")  + ";\n}\n.org-ednovo-gooru-client-uc-AlertContentUc_AlertContentUcUiBinderImpl_GenCss_style-okButton {\n  margin : " + ("5px"+ " " +"auto")  + ";\n  text-align : " + ("center")  + ";\n  width : " + ("100%")  + ";\n  margin-top : " + ("39px")  + ";\n}\n.org-ednovo-gooru-client-uc-AlertContentUc_AlertContentUcUiBinderImpl_GenCss_style-okButton button {\n  color : " + ("#515151")  + ";\n}\n.org-ednovo-gooru-client-uc-AlertContentUc_AlertContentUcUiBinderImpl_GenCss_style-okButton button:hover {\n  color : " + ("#515151")  + ";\n  background : " + ("#ddd")  + ";\n}\n"));
      }
      public java.lang.String content(){
        return "org-ednovo-gooru-client-uc-AlertContentUc_AlertContentUcUiBinderImpl_GenCss_style-content";
      }
      public java.lang.String contentStyle(){
        return "org-ednovo-gooru-client-uc-AlertContentUc_AlertContentUcUiBinderImpl_GenCss_style-contentStyle";
      }
      public java.lang.String okButton(){
        return "org-ednovo-gooru-client-uc-AlertContentUc_AlertContentUcUiBinderImpl_GenCss_style-okButton";
      }
      public java.lang.String title(){
        return "org-ednovo-gooru-client-uc-AlertContentUc_AlertContentUcUiBinderImpl_GenCss_style-title";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static org.ednovo.gooru.client.uc.AlertContentUc_AlertContentUcUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public org.ednovo.gooru.client.uc.AlertContentUc_AlertContentUcUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.uc.AlertContentUc_AlertContentUcUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@org.ednovo.gooru.client.uc.AlertContentUc_AlertContentUcUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
