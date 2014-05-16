package org.ednovo.gooru.client.uc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class CourseListUc_CourseListUcUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.uc.CourseListUc_CourseListUcUiBinderImpl_GenBundle {
  private static CourseListUc_CourseListUcUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new CourseListUc_CourseListUcUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new org.ednovo.gooru.client.uc.CourseListUc_CourseListUcUiBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-uc-CourseListUc_CourseListUcUiBinderImpl_GenCss_style-myFolderCollectionFormContainer {\n  float : " + ("right")  + ";\n  padding : " + ("0"+ " " +"0"+ " " +"0"+ " " +"21px")  + ";\n  width : " + ("250px")  + ";\n  border-right : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  background-color : " + ("white")  + ";\n  overflow-y : " + ("auto")  + " !important;\n  overflow-x : " + ("hidden")  + " !important;\n  max-height : " + ("446px")  + ";\n  min-height : " + ("370px")  + ";\n}\n.org-ednovo-gooru-client-uc-CourseListUc_CourseListUcUiBinderImpl_GenCss_style-collectionInfoAddButtonContainer {\n  display : " + ("inline-block")  + ";\n  background : ") + (("#fff")  + ";\n  padding : " + ("10px"+ " " +"0")  + ";\n  text-align : " + ("center")  + ";\n  width : " + ("100%")  + ";\n  border-top : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n}\n.org-ednovo-gooru-client-uc-CourseListUc_CourseListUcUiBinderImpl_GenCss_style-collectionAddButton {\n  display : " + ("inline-block")  + ";\n  vertical-align : " + ("top")  + ";\n  margin-left : " + ("14px")  + ";\n}\n.org-ednovo-gooru-client-uc-CourseListUc_CourseListUcUiBinderImpl_GenCss_style-myFolderCollectionPopupOuterdiv {\n  width : " + ("531px")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  position : " + ("relative") ) + (";\n  padding : " + ("3px"+ " " +"5px"+ " " +"3px"+ " " +"7px")  + ";\n  background : " + ("#fff")  + ";\n  border-color : " + ("#ddd")  + ";\n}\n.org-ednovo-gooru-client-uc-CourseListUc_CourseListUcUiBinderImpl_GenCss_style-myFolderCollectionUrlContent {\n  float : " + ("right")  + ";\n  width : " + ("259px")  + ";\n  border-bottom : " + ("none")  + ";\n  border-right : " + ("none")  + ";\n  font-size : " + ("15px")  + ";\n  border-style : " + ("solid")  + ";\n  border-color : " + ("#ddd")  + ";\n  border-right : ") + (("none")  + ";\n  border-bottom : " + ("none")  + ";\n  background : " + ("url(../images/core/background-image.png)")  + " !important;\n}\n")) : ((".org-ednovo-gooru-client-uc-CourseListUc_CourseListUcUiBinderImpl_GenCss_style-myFolderCollectionFormContainer {\n  float : " + ("left")  + ";\n  padding : " + ("0"+ " " +"21px"+ " " +"0"+ " " +"0")  + ";\n  width : " + ("250px")  + ";\n  border-left : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  background-color : " + ("white")  + ";\n  overflow-y : " + ("auto")  + " !important;\n  overflow-x : " + ("hidden")  + " !important;\n  max-height : " + ("446px")  + ";\n  min-height : " + ("370px")  + ";\n}\n.org-ednovo-gooru-client-uc-CourseListUc_CourseListUcUiBinderImpl_GenCss_style-collectionInfoAddButtonContainer {\n  display : " + ("inline-block")  + ";\n  background : ") + (("#fff")  + ";\n  padding : " + ("10px"+ " " +"0")  + ";\n  text-align : " + ("center")  + ";\n  width : " + ("100%")  + ";\n  border-top : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n}\n.org-ednovo-gooru-client-uc-CourseListUc_CourseListUcUiBinderImpl_GenCss_style-collectionAddButton {\n  display : " + ("inline-block")  + ";\n  vertical-align : " + ("top")  + ";\n  margin-right : " + ("14px")  + ";\n}\n.org-ednovo-gooru-client-uc-CourseListUc_CourseListUcUiBinderImpl_GenCss_style-myFolderCollectionPopupOuterdiv {\n  width : " + ("531px")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  position : " + ("relative") ) + (";\n  padding : " + ("3px"+ " " +"7px"+ " " +"3px"+ " " +"5px")  + ";\n  background : " + ("#fff")  + ";\n  border-color : " + ("#ddd")  + ";\n}\n.org-ednovo-gooru-client-uc-CourseListUc_CourseListUcUiBinderImpl_GenCss_style-myFolderCollectionUrlContent {\n  float : " + ("left")  + ";\n  width : " + ("259px")  + ";\n  border-bottom : " + ("none")  + ";\n  border-left : " + ("none")  + ";\n  font-size : " + ("15px")  + ";\n  border-style : " + ("solid")  + ";\n  border-color : " + ("#ddd")  + ";\n  border-left : ") + (("none")  + ";\n  border-bottom : " + ("none")  + ";\n  background : " + ("url(../images/core/background-image.png)")  + " !important;\n}\n"));
      }
      public java.lang.String collectionAddButton(){
        return "org-ednovo-gooru-client-uc-CourseListUc_CourseListUcUiBinderImpl_GenCss_style-collectionAddButton";
      }
      public java.lang.String collectionInfoAddButtonContainer(){
        return "org-ednovo-gooru-client-uc-CourseListUc_CourseListUcUiBinderImpl_GenCss_style-collectionInfoAddButtonContainer";
      }
      public java.lang.String myFolderCollectionFormContainer(){
        return "org-ednovo-gooru-client-uc-CourseListUc_CourseListUcUiBinderImpl_GenCss_style-myFolderCollectionFormContainer";
      }
      public java.lang.String myFolderCollectionPopupOuterdiv(){
        return "org-ednovo-gooru-client-uc-CourseListUc_CourseListUcUiBinderImpl_GenCss_style-myFolderCollectionPopupOuterdiv";
      }
      public java.lang.String myFolderCollectionUrlContent(){
        return "org-ednovo-gooru-client-uc-CourseListUc_CourseListUcUiBinderImpl_GenCss_style-myFolderCollectionUrlContent";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static org.ednovo.gooru.client.uc.CourseListUc_CourseListUcUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public org.ednovo.gooru.client.uc.CourseListUc_CourseListUcUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.uc.CourseListUc_CourseListUcUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@org.ednovo.gooru.client.uc.CourseListUc_CourseListUcUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
