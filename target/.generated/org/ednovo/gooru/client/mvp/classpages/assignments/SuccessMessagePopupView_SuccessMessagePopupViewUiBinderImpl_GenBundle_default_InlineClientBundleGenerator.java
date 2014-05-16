package org.ednovo.gooru.client.mvp.classpages.assignments;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.mvp.classpages.assignments.SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenBundle {
  private static SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new org.ednovo.gooru.client.mvp.classpages.assignments.SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-mvp-classpages-assignments-SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style-popupContent {\n  border : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  height : " + ("320px")  + ";\n  width : " + ("450px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-assignments-SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style-successPopupContainer {\n  padding : " + ("3px")  + ";\n  height : " + ("323px")  + ";\n  background : " + ("white")  + ";\n  z-index : " + ("999")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-assignments-SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style-popupHeader {\n  padding : " + ("10px"+ " " +"15px")  + ";\n  color : " + ("white")  + ";\n  background-color : " + ("#515151")  + ";\n  font-size : ") + (("16px")  + ";\n  background : " + ("-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#666" + ")"+ ","+ " " +"to(" + "#515151" + ")" + ")")  + ";\n  background : " + ("-webkit-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  background : " + ("-moz-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  background : " + ("-ms-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  filter : " + ("progid")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-assignments-SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style-popupHeaderText {\n  color : " + ("white")  + ";\n  font-size : " + ("16px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-assignments-SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style-assignmentSuccessMainContainer {\n  float : " + ("right")  + ";\n  width : " + ("100%") ) + (";\n}\n.org-ednovo-gooru-client-mvp-classpages-assignments-SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style-successImage {\n  background : " + ("url(images/Classpage/assignment.png)")  + ";\n  height : " + ("60px")  + ";\n  width : " + ("60px")  + ";\n  background-repeat : " + ("no-repeat")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  margin-top : " + ("50px")  + ";\n  margin-bottom : " + ("40px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-assignments-SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style-successText {\n  text-align : " + ("center")  + ";\n  width : " + ("80%")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  word-wrap : ") + (("break-word")  + ";\n  font-size : " + ("12px")  + ";\n  color : " + ("#999")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-assignments-SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style-assignmentButtonsContainer {\n  text-align : " + ("center")  + ";\n  margin-top : " + ("40px")  + ";\n}\n")) : ((".org-ednovo-gooru-client-mvp-classpages-assignments-SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style-popupContent {\n  border : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  height : " + ("320px")  + ";\n  width : " + ("450px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-assignments-SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style-successPopupContainer {\n  padding : " + ("3px")  + ";\n  height : " + ("323px")  + ";\n  background : " + ("white")  + ";\n  z-index : " + ("999")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-assignments-SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style-popupHeader {\n  padding : " + ("10px"+ " " +"15px")  + ";\n  color : " + ("white")  + ";\n  background-color : " + ("#515151")  + ";\n  font-size : ") + (("16px")  + ";\n  background : " + ("-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#666" + ")"+ ","+ " " +"to(" + "#515151" + ")" + ")")  + ";\n  background : " + ("-webkit-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  background : " + ("-moz-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  background : " + ("-ms-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  filter : " + ("progid")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-assignments-SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style-popupHeaderText {\n  color : " + ("white")  + ";\n  font-size : " + ("16px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-assignments-SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style-assignmentSuccessMainContainer {\n  float : " + ("left")  + ";\n  width : " + ("100%") ) + (";\n}\n.org-ednovo-gooru-client-mvp-classpages-assignments-SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style-successImage {\n  background : " + ("url(images/Classpage/assignment.png)")  + ";\n  height : " + ("60px")  + ";\n  width : " + ("60px")  + ";\n  background-repeat : " + ("no-repeat")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  margin-top : " + ("50px")  + ";\n  margin-bottom : " + ("40px")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-assignments-SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style-successText {\n  text-align : " + ("center")  + ";\n  width : " + ("80%")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  word-wrap : ") + (("break-word")  + ";\n  font-size : " + ("12px")  + ";\n  color : " + ("#999")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-assignments-SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style-assignmentButtonsContainer {\n  text-align : " + ("center")  + ";\n  margin-top : " + ("40px")  + ";\n}\n"));
      }
      public java.lang.String assignmentButtonsContainer(){
        return "org-ednovo-gooru-client-mvp-classpages-assignments-SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style-assignmentButtonsContainer";
      }
      public java.lang.String assignmentContentContainer(){
        return "org-ednovo-gooru-client-mvp-classpages-assignments-SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style-assignmentContentContainer";
      }
      public java.lang.String assignmentSuccessMainContainer(){
        return "org-ednovo-gooru-client-mvp-classpages-assignments-SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style-assignmentSuccessMainContainer";
      }
      public java.lang.String popupContent(){
        return "org-ednovo-gooru-client-mvp-classpages-assignments-SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style-popupContent";
      }
      public java.lang.String popupHeader(){
        return "org-ednovo-gooru-client-mvp-classpages-assignments-SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style-popupHeader";
      }
      public java.lang.String popupHeaderText(){
        return "org-ednovo-gooru-client-mvp-classpages-assignments-SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style-popupHeaderText";
      }
      public java.lang.String successImage(){
        return "org-ednovo-gooru-client-mvp-classpages-assignments-SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style-successImage";
      }
      public java.lang.String successPopupContainer(){
        return "org-ednovo-gooru-client-mvp-classpages-assignments-SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style-successPopupContainer";
      }
      public java.lang.String successText(){
        return "org-ednovo-gooru-client-mvp-classpages-assignments-SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style-successText";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static org.ednovo.gooru.client.mvp.classpages.assignments.SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public org.ednovo.gooru.client.mvp.classpages.assignments.SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.mvp.classpages.assignments.SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@org.ednovo.gooru.client.mvp.classpages.assignments.SuccessMessagePopupView_SuccessMessagePopupViewUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
