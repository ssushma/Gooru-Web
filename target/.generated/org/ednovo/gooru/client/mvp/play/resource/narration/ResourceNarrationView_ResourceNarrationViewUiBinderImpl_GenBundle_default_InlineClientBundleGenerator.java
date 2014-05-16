package org.ednovo.gooru.client.mvp.play.resource.narration;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.mvp.play.resource.narration.ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenBundle {
  private static ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new org.ednovo.gooru.client.mvp.play.resource.narration.ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-popupDisplay {\n  background : " + ("url(../images/bg.png)"+ " " +"repeat")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-popup {\n  font-family : " + ("Arial"+ ","+ " " +"Helvetica"+ ","+ " " +"sans-serif")  + ";\n  font-size : " + ("12px")  + ";\n  background-color : " + ("#f0f0f0")  + ";\n  width : " + ("550px")  + ";\n  border-color : " + ("#999")  + ";\n  border-width : " + ("1px")  + ";\n  border-style : " + ("solid")  + ";\n  border-radius : " + ("4px")  + ";\n  min-height : " + ("308px")  + ";\n  -moz-border-radius : ") + (("4px")  + ";\n  -webkit-border-radius : " + ("4px")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-popupInner {\n  text-align : " + ("center")  + ";\n  padding : " + ("0"+ " " +"10px")  + ";\n  padding-bottom : " + ("20px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-popupHeader {\n  padding : " + ("10px"+ " " +"0")  + ";\n  color : " + ("#fff")  + ";\n  margin : " + ("0"+ " " +"10px")  + ";\n  border-bottom : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  display : " + ("inline-block") ) + (";\n  vertical-align : " + ("top")  + ";\n  width : " + ("98%")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-popupHeaderTitle {\n  color : " + ("#515151")  + ";\n  display : " + ("inline-block")  + ";\n  float : " + ("right")  + ";\n  margin-top : " + ("3px")  + ";\n  font-size : " + ("14px")  + ";\n  width : " + ("95%")  + ";\n  white-space : " + ("nowrap")  + ";\n  overflow : " + ("hidden")  + ";\n  text-overflow : ") + (("ellipsis")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-popupContent {\n  text-align : " + ("center")  + ";\n  padding : " + ("15px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-circleBlock {\n  color : " + ("#999")  + ";\n  padding : " + ("0"+ " " +"160px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-circleBg {\n  width : " + ("80px")  + ";\n  height : " + ("80px")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  margin-bottom : " + ("5px")  + ";\n  border-radius : " + ("65px")  + ";\n  -moz-border-radius : " + ("65px") ) + (";\n  -webkit-border-radius : " + ("65px")  + ";\n  background-color : " + ("#515151")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-contentTitle {\n  font-size : " + ("20px")  + ";\n  line-height : " + ("300%")  + ";\n  color : " + ("#515151")  + ";\n  margin-bottom : " + ("32px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-visibilityHidden {\n  visibility : " + ("hidden")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-contentDesc {\n  font-size : " + ("14px")  + ";\n  line-height : " + ("120%")  + ";\n  text-align : " + ("right")  + ";\n  color : ") + (("#515151")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-btn {\n  width : " + ("115px")  + ";\n  margin : " + ("auto")  + ";\n  margin-bottom : " + ("15px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-close-button {\n  display : " + ("inline-block")  + ";\n  vertical-align : " + ("top")  + ";\n  float : " + ("left")  + ";\n  left : " + ("0")  + ";\n  padding-left : " + ("5px")  + ";\n  width : " + ("16px")  + ";\n  height : " + ("17px") ) + (";\n  background : " + ("url(images/closebutton.png)"+ " " +"no-repeat")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-close-button:hover {\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-popupDesc {\n  font-weight : " + ("normal")  + ";\n  font-size : " + ("12px")  + ";\n  text-align : " + ("center")  + ";\n  padding : " + ("0"+ " " +"130px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-buttonBlock {\n  padding : " + ("10px"+ " " +"20px")  + ";\n  font-size : " + ("12px")  + ";\n  color : " + ("#fff")  + ";\n  outline : " + ("0")  + ";\n  border : ") + (("none")  + ";\n  font-weight : " + ("normal")  + ";\n  border-radius : " + ("5px")  + ";\n  -moz-border-radius : " + ("5px")  + ";\n  -webkit-border-radius : " + ("5px")  + ";\n  background-image : " + ("-moz-linear-gradient(" + "43%"+ " " +"-2%"+ " " +"-90deg"+ ","+ " " +"#4c98cc"+ " " +"0"+ ","+ " " +"#1076bb"+ " " +"100%" + ")")  + ";\n  background-image : " + ("-webkit-gradient(" + "linear"+ ","+ " " +"43%"+ " " +"-2%"+ ","+ " " +"43%"+ " " +"113%"+ ","+ " " +"color-stop(" + "0"+ ","+ " " +"#4c98cc" + ")"+ ","+ " " +"color-stop(" + "1"+ ","+ " " +"#1076bb" + ")" + ")")  + ";\n  background-image : " + ("-webkit-linear-gradient(" + "-90deg"+ ","+ " " +"#4c98cc"+ " " +"0"+ ","+ " " +"#1076bb"+ " " +"100%" + ")")  + ";\n  background-image : " + ("-o-linear-gradient(" + "-90deg"+ ","+ " " +"#4c98cc"+ " " +"0"+ ","+ " " +"#1076bb"+ " " +"100%" + ")")  + ";\n  background-image : " + ("-ms-linear-gradient(" + "-90deg"+ ","+ " " +"#4c98cc"+ " " +"0"+ ","+ " " +"#1076bb"+ " " +"100%" + ")")  + ";\n  -ms-filter : " + ("\"progid:DXImageTransform.Microsoft.gradient(startColorstr=#ff4c98cc,endColorstr=#ff1076bb,GradientType=0)\"") ) + (";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-buttonBlock:hover {\n  background : " + ("#1076bb")  + ";\n  cursor : " + ("pointer")  + ";\n}\n")) : ((".org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-popupDisplay {\n  background : " + ("url(../images/bg.png)"+ " " +"repeat")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-popup {\n  font-family : " + ("Arial"+ ","+ " " +"Helvetica"+ ","+ " " +"sans-serif")  + ";\n  font-size : " + ("12px")  + ";\n  background-color : " + ("#f0f0f0")  + ";\n  width : " + ("550px")  + ";\n  border-color : " + ("#999")  + ";\n  border-width : " + ("1px")  + ";\n  border-style : " + ("solid")  + ";\n  border-radius : " + ("4px")  + ";\n  min-height : " + ("308px")  + ";\n  -moz-border-radius : ") + (("4px")  + ";\n  -webkit-border-radius : " + ("4px")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-popupInner {\n  text-align : " + ("center")  + ";\n  padding : " + ("0"+ " " +"10px")  + ";\n  padding-bottom : " + ("20px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-popupHeader {\n  padding : " + ("10px"+ " " +"0")  + ";\n  color : " + ("#fff")  + ";\n  margin : " + ("0"+ " " +"10px")  + ";\n  border-bottom : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  display : " + ("inline-block") ) + (";\n  vertical-align : " + ("top")  + ";\n  width : " + ("98%")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-popupHeaderTitle {\n  color : " + ("#515151")  + ";\n  display : " + ("inline-block")  + ";\n  float : " + ("left")  + ";\n  margin-top : " + ("3px")  + ";\n  font-size : " + ("14px")  + ";\n  width : " + ("95%")  + ";\n  white-space : " + ("nowrap")  + ";\n  overflow : " + ("hidden")  + ";\n  text-overflow : ") + (("ellipsis")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-popupContent {\n  text-align : " + ("center")  + ";\n  padding : " + ("15px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-circleBlock {\n  color : " + ("#999")  + ";\n  padding : " + ("0"+ " " +"160px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-circleBg {\n  width : " + ("80px")  + ";\n  height : " + ("80px")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  margin-bottom : " + ("5px")  + ";\n  border-radius : " + ("65px")  + ";\n  -moz-border-radius : " + ("65px") ) + (";\n  -webkit-border-radius : " + ("65px")  + ";\n  background-color : " + ("#515151")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-contentTitle {\n  font-size : " + ("20px")  + ";\n  line-height : " + ("300%")  + ";\n  color : " + ("#515151")  + ";\n  margin-bottom : " + ("32px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-visibilityHidden {\n  visibility : " + ("hidden")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-contentDesc {\n  font-size : " + ("14px")  + ";\n  line-height : " + ("120%")  + ";\n  text-align : " + ("left")  + ";\n  color : ") + (("#515151")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-btn {\n  width : " + ("115px")  + ";\n  margin : " + ("auto")  + ";\n  margin-bottom : " + ("15px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-close-button {\n  display : " + ("inline-block")  + ";\n  vertical-align : " + ("top")  + ";\n  float : " + ("right")  + ";\n  right : " + ("0")  + ";\n  padding-right : " + ("5px")  + ";\n  width : " + ("16px")  + ";\n  height : " + ("17px") ) + (";\n  background : " + ("url(images/closebutton.png)"+ " " +"no-repeat")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-close-button:hover {\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-popupDesc {\n  font-weight : " + ("normal")  + ";\n  font-size : " + ("12px")  + ";\n  text-align : " + ("center")  + ";\n  padding : " + ("0"+ " " +"130px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-buttonBlock {\n  padding : " + ("10px"+ " " +"20px")  + ";\n  font-size : " + ("12px")  + ";\n  color : " + ("#fff")  + ";\n  outline : " + ("0")  + ";\n  border : ") + (("none")  + ";\n  font-weight : " + ("normal")  + ";\n  border-radius : " + ("5px")  + ";\n  -moz-border-radius : " + ("5px")  + ";\n  -webkit-border-radius : " + ("5px")  + ";\n  background-image : " + ("-moz-linear-gradient(" + "43%"+ " " +"-2%"+ " " +"-90deg"+ ","+ " " +"#4c98cc"+ " " +"0"+ ","+ " " +"#1076bb"+ " " +"100%" + ")")  + ";\n  background-image : " + ("-webkit-gradient(" + "linear"+ ","+ " " +"43%"+ " " +"-2%"+ ","+ " " +"43%"+ " " +"113%"+ ","+ " " +"color-stop(" + "0"+ ","+ " " +"#4c98cc" + ")"+ ","+ " " +"color-stop(" + "1"+ ","+ " " +"#1076bb" + ")" + ")")  + ";\n  background-image : " + ("-webkit-linear-gradient(" + "-90deg"+ ","+ " " +"#4c98cc"+ " " +"0"+ ","+ " " +"#1076bb"+ " " +"100%" + ")")  + ";\n  background-image : " + ("-o-linear-gradient(" + "-90deg"+ ","+ " " +"#4c98cc"+ " " +"0"+ ","+ " " +"#1076bb"+ " " +"100%" + ")")  + ";\n  background-image : " + ("-ms-linear-gradient(" + "-90deg"+ ","+ " " +"#4c98cc"+ " " +"0"+ ","+ " " +"#1076bb"+ " " +"100%" + ")")  + ";\n  -ms-filter : " + ("\"progid:DXImageTransform.Microsoft.gradient(startColorstr=#ff4c98cc,endColorstr=#ff1076bb,GradientType=0)\"") ) + (";\n}\n.org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-buttonBlock:hover {\n  background : " + ("#1076bb")  + ";\n  cursor : " + ("pointer")  + ";\n}\n"));
      }
      public java.lang.String btn(){
        return "org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-btn";
      }
      public java.lang.String buttonBlock(){
        return "org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-buttonBlock";
      }
      public java.lang.String circleBg(){
        return "org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-circleBg";
      }
      public java.lang.String circleBlock(){
        return "org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-circleBlock";
      }
      public java.lang.String closeButton(){
        return "org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-close-button";
      }
      public java.lang.String contentDesc(){
        return "org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-contentDesc";
      }
      public java.lang.String contentTitle(){
        return "org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-contentTitle";
      }
      public java.lang.String popup(){
        return "org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-popup";
      }
      public java.lang.String popupContent(){
        return "org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-popupContent";
      }
      public java.lang.String popupDesc(){
        return "org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-popupDesc";
      }
      public java.lang.String popupDisplay(){
        return "org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-popupDisplay";
      }
      public java.lang.String popupHeader(){
        return "org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-popupHeader";
      }
      public java.lang.String popupHeaderTitle(){
        return "org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-popupHeaderTitle";
      }
      public java.lang.String popupInner(){
        return "org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-popupInner";
      }
      public java.lang.String visibilityHidden(){
        return "org-ednovo-gooru-client-mvp-play-resource-narration-ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style-visibilityHidden";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static org.ednovo.gooru.client.mvp.play.resource.narration.ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public org.ednovo.gooru.client.mvp.play.resource.narration.ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.mvp.play.resource.narration.ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@org.ednovo.gooru.client.mvp.play.resource.narration.ResourceNarrationView_ResourceNarrationViewUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
