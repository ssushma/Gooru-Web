package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class WebResourcePreview_WebResourcePreviewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.WebResourcePreview_WebResourcePreviewUiBinderImpl_GenBundle {
  private static WebResourcePreview_WebResourcePreviewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new WebResourcePreview_WebResourcePreviewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-shareAlertPopup {\n  font-family : " + ("Arial")  + ";\n  font-size : " + ("12px")  + ";\n  width : " + ("500px")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-alertHeaderStyle {\n  background : " + ("-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#666" + ")"+ ","+ " " +"to(" + "#515151" + ")" + ")")  + ";\n  background : " + ("-webkit-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  background : " + ("-moz-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  background : " + ("-ms-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  background-color : " + ("#515151")  + ";\n  color : ") + (("#fff")  + ";\n  margin : " + ("3px")  + ";\n  padding : " + ("10px"+ " " +"15px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-alertHeaderTxtStyle {\n  font-size : " + ("16px")  + ";\n  color : " + ("#fff")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-alertBodyStyle {\n  margin : " + ("-4px"+ " " +"4px"+ " " +"4px")  + ";\n  padding : " + ("0"+ " " +"30px"+ " " +"15px"+ " " +"30px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-alertBodyStyle1 {\n  margin : " + ("0"+ " " +"36px"+ " " +"15px"+ " " +"30px")  + ";\n  float : " + ("right")  + ";\n  border-bottom : " + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";\n  min-height : " + ("250px") ) + (";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-alertSuccessTxt {\n  padding : " + ("10px")  + ";\n  text-align : " + ("center")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-privateMsgTxt {\n  padding : " + ("10px")  + ";\n  text-align : " + ("center")  + ";\n  border-bottom : " + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-okSuccessBtn {\n  width : " + ("100%")  + ";\n  text-align : " + ("center")  + ";\n  margin : " + ("30px"+ " " +"0")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-overRideBlueButton {\n  background : " + ("-moz-linear-gradient(" + "center"+ " " +"top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")"+ " " +"repeat"+ " " +"scroll"+ " " +"0"+ " " +"0"+ " " +"transparent")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : ") + (("-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#4c98cc" + ")"+ ","+ " " +"to(" + "#1076bb" + ")" + ")")  + ";\n  background : " + ("-webkit-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("-moz-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background-image : " + ("-ms-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background-color : " + ("#1076bb")  + ";\n  border : " + ("0"+ " " +"none")  + ";\n  border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  clear : " + ("both")  + ";\n  color : " + ("#fff")  + ";\n  cursor : " + ("pointer") ) + (";\n  padding : " + ("5px"+ " " +"11px"+ " " +"5px"+ " " +"11px")  + ";\n  position : " + ("relative")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-overRideBlueButton:HOVER {\n  background : " + ("#1076bb")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-leftColumnBold {\n  width : " + ("100px")  + ";\n  text-align : " + ("left")  + ";\n  font-weight : " + ("bold")  + ";\n  padding-left : " + ("20px")  + ";\n  float : " + ("right")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-rightColumn {\n  float : " + ("right")  + ";\n  width : ") + (("330px")  + ";\n  text-align : " + ("right")  + ";\n  word-wrap : " + ("break-word")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-contentDiv {\n  float : " + ("right")  + ";\n  width : " + ("450px")  + ";\n  padding-bottom : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-resourceThumbnailImage {\n  width : " + ("80px")  + ";\n  height : " + ("60px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-addResourceCloseButton {\n  background : " + ("url(images/sprites-login.png)"+ " " +"no-repeat")  + ";\n  background-position : " + ("-52px"+ " " +"-116px")  + ";\n  width : " + ("18px") ) + (";\n  height : " + ("19px")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-addResourceCloseButtonContainer {\n  float : " + ("left")  + ";\n  padding : " + ("8px"+ " " +"0"+ " " +"0"+ " " +"0")  + ";\n  margin-top : " + ("-28px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-adding {\n  text-align : " + ("center")  + ";\n  width : " + ("95%")  + ";\n  color : " + ("#999")  + " !important;\n  font-style : " + ("italic")  + ";\n  padding : " + ("10px")  + ";\n  margin : ") + (("30px")  + ";\n}\n")) : ((".org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-shareAlertPopup {\n  font-family : " + ("Arial")  + ";\n  font-size : " + ("12px")  + ";\n  width : " + ("500px")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-alertHeaderStyle {\n  background : " + ("-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#666" + ")"+ ","+ " " +"to(" + "#515151" + ")" + ")")  + ";\n  background : " + ("-webkit-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  background : " + ("-moz-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  background : " + ("-ms-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#666"+ ","+ " " +"#515151" + ")")  + ";\n  background-color : " + ("#515151")  + ";\n  color : ") + (("#fff")  + ";\n  margin : " + ("3px")  + ";\n  padding : " + ("10px"+ " " +"15px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-alertHeaderTxtStyle {\n  font-size : " + ("16px")  + ";\n  color : " + ("#fff")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-alertBodyStyle {\n  margin : " + ("-4px"+ " " +"4px"+ " " +"4px")  + ";\n  padding : " + ("0"+ " " +"30px"+ " " +"15px"+ " " +"30px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-alertBodyStyle1 {\n  margin : " + ("0"+ " " +"30px"+ " " +"15px"+ " " +"36px")  + ";\n  float : " + ("left")  + ";\n  border-bottom : " + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";\n  min-height : " + ("250px") ) + (";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-alertSuccessTxt {\n  padding : " + ("10px")  + ";\n  text-align : " + ("center")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-privateMsgTxt {\n  padding : " + ("10px")  + ";\n  text-align : " + ("center")  + ";\n  border-bottom : " + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-okSuccessBtn {\n  width : " + ("100%")  + ";\n  text-align : " + ("center")  + ";\n  margin : " + ("30px"+ " " +"0")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-overRideBlueButton {\n  background : " + ("-moz-linear-gradient(" + "center"+ " " +"top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")"+ " " +"repeat"+ " " +"scroll"+ " " +"0"+ " " +"0"+ " " +"transparent")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : ") + (("-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#4c98cc" + ")"+ ","+ " " +"to(" + "#1076bb" + ")" + ")")  + ";\n  background : " + ("-webkit-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("-moz-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background-image : " + ("-ms-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background-color : " + ("#1076bb")  + ";\n  border : " + ("0"+ " " +"none")  + ";\n  border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  clear : " + ("both")  + ";\n  color : " + ("#fff")  + ";\n  cursor : " + ("pointer") ) + (";\n  padding : " + ("5px"+ " " +"11px"+ " " +"5px"+ " " +"11px")  + ";\n  position : " + ("relative")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-overRideBlueButton:HOVER {\n  background : " + ("#1076bb")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-leftColumnBold {\n  width : " + ("100px")  + ";\n  text-align : " + ("right")  + ";\n  font-weight : " + ("bold")  + ";\n  padding-right : " + ("20px")  + ";\n  float : " + ("left")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-rightColumn {\n  float : " + ("left")  + ";\n  width : ") + (("330px")  + ";\n  text-align : " + ("left")  + ";\n  word-wrap : " + ("break-word")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-contentDiv {\n  float : " + ("left")  + ";\n  width : " + ("450px")  + ";\n  padding-bottom : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-resourceThumbnailImage {\n  width : " + ("80px")  + ";\n  height : " + ("60px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-addResourceCloseButton {\n  background : " + ("url(images/sprites-login.png)"+ " " +"no-repeat")  + ";\n  background-position : " + ("-52px"+ " " +"-116px")  + ";\n  width : " + ("18px") ) + (";\n  height : " + ("19px")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-addResourceCloseButtonContainer {\n  float : " + ("right")  + ";\n  padding : " + ("8px"+ " " +"0"+ " " +"0"+ " " +"0")  + ";\n  margin-top : " + ("-28px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-adding {\n  text-align : " + ("center")  + ";\n  width : " + ("95%")  + ";\n  color : " + ("#999")  + " !important;\n  font-style : " + ("italic")  + ";\n  padding : " + ("10px")  + ";\n  margin : ") + (("30px")  + ";\n}\n"));
      }
      public java.lang.String addResourceCloseButton(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-addResourceCloseButton";
      }
      public java.lang.String addResourceCloseButtonContainer(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-addResourceCloseButtonContainer";
      }
      public java.lang.String adding(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-adding";
      }
      public java.lang.String alertBodyStyle(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-alertBodyStyle";
      }
      public java.lang.String alertBodyStyle1(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-alertBodyStyle1";
      }
      public java.lang.String alertHeaderStyle(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-alertHeaderStyle";
      }
      public java.lang.String alertHeaderTxtStyle(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-alertHeaderTxtStyle";
      }
      public java.lang.String alertSuccessMsgTxt(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-alertSuccessMsgTxt";
      }
      public java.lang.String alertSuccessTxt(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-alertSuccessTxt";
      }
      public java.lang.String contentDiv(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-contentDiv";
      }
      public java.lang.String leftColumnBold(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-leftColumnBold";
      }
      public java.lang.String okSuccessBtn(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-okSuccessBtn";
      }
      public java.lang.String overRideBlueButton(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-overRideBlueButton";
      }
      public java.lang.String privateMsgTxt(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-privateMsgTxt";
      }
      public java.lang.String resourceThumbnailImage(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-resourceThumbnailImage";
      }
      public java.lang.String rightColumn(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-rightColumn";
      }
      public java.lang.String shareAlertPopup(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-tab-resource-add-WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style-shareAlertPopup";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.WebResourcePreview_WebResourcePreviewUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.WebResourcePreview_WebResourcePreviewUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
