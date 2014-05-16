package org.ednovo.gooru.client.uc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class ConfirmationPopupVc_RemoveResourcePopupVcUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.uc.ConfirmationPopupVc_RemoveResourcePopupVcUiBinderImpl_GenBundle {
  private static ConfirmationPopupVc_RemoveResourcePopupVcUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new ConfirmationPopupVc_RemoveResourcePopupVcUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new org.ednovo.gooru.client.uc.ConfirmationPopupVc_RemoveResourcePopupVcUiBinderImpl_GenCss_style() {
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
        return (".org-ednovo-gooru-client-uc-ConfirmationPopupVc_RemoveResourcePopupVcUiBinderImpl_GenCss_style-important {\n  font-weight : " + ("bold")  + ";\n}\n.org-ednovo-gooru-client-uc-ConfirmationPopupVc_RemoveResourcePopupVcUiBinderImpl_GenCss_style-removePopupContainer {\n  border : " + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";\n  height : " + ("100px")  + " !important;\n  margin : " + ("-4px"+ " " +"4px"+ " " +"4px")  + ";\n}\n.org-ednovo-gooru-client-uc-ConfirmationPopupVc_RemoveResourcePopupVcUiBinderImpl_GenCss_style-actionField {\n  text-align : " + ("center")  + ";\n  width : " + ("100%")  + ";\n  margin-top : " + ("19px")  + ";\n}\n.org-ednovo-gooru-client-uc-ConfirmationPopupVc_RemoveResourcePopupVcUiBinderImpl_GenCss_style-loadingTxtStyle {\n  text-align : " + ("center")  + ";\n  width : " + ("100%")  + ";\n  margin-top : " + ("19px")  + ";\n  font-style : ") + (("italic")  + ";\n}\n.org-ednovo-gooru-client-uc-ConfirmationPopupVc_RemoveResourcePopupVcUiBinderImpl_GenCss_style-removeText {\n  padding : " + ("10px")  + ";\n  width : " + ("90%")  + ";\n}\n");
      }
      public java.lang.String actionField(){
        return "org-ednovo-gooru-client-uc-ConfirmationPopupVc_RemoveResourcePopupVcUiBinderImpl_GenCss_style-actionField";
      }
      public java.lang.String important(){
        return "org-ednovo-gooru-client-uc-ConfirmationPopupVc_RemoveResourcePopupVcUiBinderImpl_GenCss_style-important";
      }
      public java.lang.String loadingTxtStyle(){
        return "org-ednovo-gooru-client-uc-ConfirmationPopupVc_RemoveResourcePopupVcUiBinderImpl_GenCss_style-loadingTxtStyle";
      }
      public java.lang.String removePopupContainer(){
        return "org-ednovo-gooru-client-uc-ConfirmationPopupVc_RemoveResourcePopupVcUiBinderImpl_GenCss_style-removePopupContainer";
      }
      public java.lang.String removeText(){
        return "org-ednovo-gooru-client-uc-ConfirmationPopupVc_RemoveResourcePopupVcUiBinderImpl_GenCss_style-removeText";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static org.ednovo.gooru.client.uc.ConfirmationPopupVc_RemoveResourcePopupVcUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public org.ednovo.gooru.client.uc.ConfirmationPopupVc_RemoveResourcePopupVcUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.uc.ConfirmationPopupVc_RemoveResourcePopupVcUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@org.ednovo.gooru.client.uc.ConfirmationPopupVc_RemoveResourcePopupVcUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
