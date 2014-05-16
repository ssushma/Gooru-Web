package org.ednovo.gooru.client.mvp.shelf.collection;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenBundle {
  private static CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-shareAlertPopup {\n  font-family : " + ("Arial")  + ";\n  font-size : " + ("12px")  + ";\n  width : " + ("350px")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-alertHeaderStyle {\n  background : " + ("-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#666" + ")"+ ","+ " " +"to(" + "#515151" + ")" + ")")  + ";\n  background : " + ("-webkit-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  background : " + ("-moz-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  background : " + ("-ms-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  background-color : " + ("#515151")  + ";\n  color : ") + (("#fff")  + ";\n  margin : " + ("3px")  + ";\n  padding : " + ("10px"+ " " +"15px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-alertHeaderTxtStyle {\n  font-size : " + ("16px")  + ";\n  color : " + ("#fff")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-alertBodyStyle {\n  margin : " + ("-4px"+ " " +"4px"+ " " +"4px")  + ";\n  padding : " + ("50px"+ " " +"30px"+ " " +"15px"+ " " +"30px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-alertSuccessTxt {\n  padding : " + ("10px")  + ";\n  padding-bottom : " + ("15px")  + ";\n  text-align : " + ("center")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-alertSuccessTitleTxt {\n  padding : " + ("10px") ) + (";\n  font-weight : " + ("bold")  + ";\n  font-size : " + ("16px")  + ";\n  text-align : " + ("center")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-alertSuccessMsgTxt {\n  text-align : " + ("center")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-okSuccessBtn {\n  width : " + ("100%")  + ";\n  text-align : " + ("center")  + ";\n  padding-bottom : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-resourceHeaderPanel {\n  float : " + ("right")  + ";\n  width : " + ("375px")  + ";\n  margin : " + ("20px"+ " " +"10px")  + ";\n  height : ") + (("125px")  + ";\n  overflow-y : " + ("scroll")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-privateMsgTxt {\n  padding : " + ("10px")  + ";\n  text-align : " + ("center")  + ";\n  border-bottom : " + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-marginRight {\n  margin-left : " + ("5px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-gooruPublicShare {\n  margin-top : " + ("15px")  + ";\n}\n")) : ((".org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-shareAlertPopup {\n  font-family : " + ("Arial")  + ";\n  font-size : " + ("12px")  + ";\n  width : " + ("350px")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-alertHeaderStyle {\n  background : " + ("-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#666" + ")"+ ","+ " " +"to(" + "#515151" + ")" + ")")  + ";\n  background : " + ("-webkit-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  background : " + ("-moz-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  background : " + ("-ms-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  background-color : " + ("#515151")  + ";\n  color : ") + (("#fff")  + ";\n  margin : " + ("3px")  + ";\n  padding : " + ("10px"+ " " +"15px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-alertHeaderTxtStyle {\n  font-size : " + ("16px")  + ";\n  color : " + ("#fff")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-alertBodyStyle {\n  margin : " + ("-4px"+ " " +"4px"+ " " +"4px")  + ";\n  padding : " + ("50px"+ " " +"30px"+ " " +"15px"+ " " +"30px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-alertSuccessTxt {\n  padding : " + ("10px")  + ";\n  padding-bottom : " + ("15px")  + ";\n  text-align : " + ("center")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-alertSuccessTitleTxt {\n  padding : " + ("10px") ) + (";\n  font-weight : " + ("bold")  + ";\n  font-size : " + ("16px")  + ";\n  text-align : " + ("center")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-alertSuccessMsgTxt {\n  text-align : " + ("center")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-okSuccessBtn {\n  width : " + ("100%")  + ";\n  text-align : " + ("center")  + ";\n  padding-bottom : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-resourceHeaderPanel {\n  float : " + ("left")  + ";\n  width : " + ("375px")  + ";\n  margin : " + ("20px"+ " " +"10px")  + ";\n  height : ") + (("125px")  + ";\n  overflow-y : " + ("scroll")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-privateMsgTxt {\n  padding : " + ("10px")  + ";\n  text-align : " + ("center")  + ";\n  border-bottom : " + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-marginRight {\n  margin-right : " + ("5px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-gooruPublicShare {\n  margin-top : " + ("15px")  + ";\n}\n"));
      }
      public java.lang.String alertBodyStyle(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-alertBodyStyle";
      }
      public java.lang.String alertHeaderStyle(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-alertHeaderStyle";
      }
      public java.lang.String alertHeaderTxtStyle(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-alertHeaderTxtStyle";
      }
      public java.lang.String alertSuccessMsgTxt(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-alertSuccessMsgTxt";
      }
      public java.lang.String alertSuccessTitleTxt(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-alertSuccessTitleTxt";
      }
      public java.lang.String alertSuccessTxt(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-alertSuccessTxt";
      }
      public java.lang.String gooruPublicShare(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-gooruPublicShare";
      }
      public java.lang.String marginRight(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-marginRight";
      }
      public java.lang.String okSuccessBtn(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-okSuccessBtn";
      }
      public java.lang.String privateMsgTxt(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-privateMsgTxt";
      }
      public java.lang.String resourceHeaderPanel(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-resourceHeaderPanel";
      }
      public java.lang.String shareAlertPopup(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style-shareAlertPopup";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareAlertPopup_CollectionShareAlertPopupUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
