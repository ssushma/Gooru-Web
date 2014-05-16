package org.ednovo.gooru.client.uc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class PreviewResourceView_TocResourceViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.uc.PreviewResourceView_TocResourceViewUiBinderImpl_GenBundle {
  private static PreviewResourceView_TocResourceViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new PreviewResourceView_TocResourceViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void playerStyleInitializer() {
    playerStyle = new org.ednovo.gooru.client.uc.PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle() {
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
        return "playerStyle";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceContainer {\n  overflow : " + ("visible")  + ";\n  display : " + ("inline-block")  + ";\n  vertical-align : " + ("middle")  + ";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resource-thumbnail {\n  width : " + ("80px")  + ";\n  height : " + ("60px")  + ";\n  position : " + ("relative")  + ";\n  display : " + ("inline-block")  + ";\n  margin-left : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resource-image {\n  width : " + ("80px")  + ";\n  height : " + ("60px")  + ";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resource-type {\n  position : ") + (("relative")  + ";\n  top : " + ("-19px")  + ";\n  z-index : " + ("10")  + ";\n  margin-right : " + ("0")  + " !important;\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceContainer .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-toolTip {\n  background : " + ("white")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  width : " + ("300px")  + ";\n  -moz-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.2" + ")")  + ";\n  -webkit-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.2" + ")")  + ";\n  box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.2" + ")")  + ";\n  padding : " + ("10px") ) + (";\n  line-height : " + ("1.4em")  + ";\n  white-space : " + ("normal")  + ";\n  border-radius : " + ("4px")  + ";\n  position : " + ("absolute")  + ";\n  margin : " + ("-45px"+ " " +"15px"+ " " +"0"+ " " +"0")  + ";\n  visibility : " + ("hidden")  + ";\n  transition : " + ("visibility"+ " " +"0"+ " " +"linear"+ " " +"0.2s"+ ","+ " " +"opacity"+ " " +"0.2s"+ " " +"linear")  + ";\n  opacity : " + ("0")  + ";\n  z-index : " + ("100")  + ";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceContainer:hover .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-toolTip {\n  visibility : " + ("visible")  + ";\n  opacity : ") + (("1")  + ";\n  transition-delay : " + ("0")  + ";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceContainer .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-toolTip .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceNumber {\n  display : " + ("inline-block")  + ";\n  vertical-align : " + ("top")  + ";\n  color : " + ("#ccc")  + ";\n  font-size : " + ("24px")  + ";\n  line-height : " + ("24px")  + ";\n  font-weight : " + ("bold")  + ";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceContainer .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-toolTip .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceInfo {\n  display : " + ("inline-block")  + ";\n  border-right : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  margin-right : " + ("10px") ) + (";\n  padding-right : " + ("10px")  + ";\n  width : " + ("245px")  + ";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceContainer .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-toolTip .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceInfo .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-title {\n  font-weight : " + ("bold")  + ";\n  width : " + ("250px")  + ";\n  white-space : " + ("nowrap")  + ";\n  overflow : " + ("hidden")  + ";\n  text-overflow : " + ("ellipsis")  + ";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceContainer .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-toolTip .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceInfo .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-source {\n  font-style : " + ("italic")  + ";\n  color : " + ("#999")  + ";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceContainer .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-toolTip .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceInfo .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-type {\n  line-height : " + ("1.4em")  + ";\n  white-space : ") + (("normal")  + ";\n  color : " + ("#515151")  + ";\n  font-size : " + ("12px")  + ";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceContainer .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceBlock {\n  width : " + ("108px")  + ";\n  overflow : " + ("visible")  + ";\n  display : " + ("inline-block")  + ";\n  margin-left : " + ("5px")  + ";\n  padding : " + ("15px")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#eee")  + ";\n  background-color : " + ("#f7f7f7")  + ";\n  text-align : " + ("center") ) + (";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceContainer:hover .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceBlock {\n  cursor : " + ("pointer")  + ";\n  opacity : " + ("0.6")  + ";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceBlock .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-number {\n  margin : " + ("5px")  + ";\n  font-weight : " + ("bold")  + ";\n  color : " + ("#999")  + ";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceBlock .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-restitle {\n  white-space : " + ("normal")  + ";\n  color : " + ("#515151")  + " !important;\n  font-size : " + ("12px")  + ";\n  font-family : " + ("Arial"+ ","+ " " +"sans-serif")  + " !important;\n  height : " + ("28px")  + ";\n  width : ") + (("108px")  + ";\n  overflow : " + ("hidden")  + ";\n  white-space : " + ("nowrap")  + ";\n  text-overflow : " + ("ellipsis")  + ";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceContainer a:hover {\n  opacity : " + ("1")  + " !important;\n}\n* {\n  -webkit-font-smoothing : " + ("antialiased")  + " !important;\n}\n")) : ((".org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceContainer {\n  overflow : " + ("visible")  + ";\n  display : " + ("inline-block")  + ";\n  vertical-align : " + ("middle")  + ";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resource-thumbnail {\n  width : " + ("80px")  + ";\n  height : " + ("60px")  + ";\n  position : " + ("relative")  + ";\n  display : " + ("inline-block")  + ";\n  margin-right : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resource-image {\n  width : " + ("80px")  + ";\n  height : " + ("60px")  + ";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resource-type {\n  position : ") + (("relative")  + ";\n  top : " + ("-19px")  + ";\n  z-index : " + ("10")  + ";\n  margin-left : " + ("0")  + " !important;\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceContainer .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-toolTip {\n  background : " + ("white")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  width : " + ("300px")  + ";\n  -moz-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.2" + ")")  + ";\n  -webkit-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.2" + ")")  + ";\n  box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.2" + ")")  + ";\n  padding : " + ("10px") ) + (";\n  line-height : " + ("1.4em")  + ";\n  white-space : " + ("normal")  + ";\n  border-radius : " + ("4px")  + ";\n  position : " + ("absolute")  + ";\n  margin : " + ("-45px"+ " " +"0"+ " " +"0"+ " " +"15px")  + ";\n  visibility : " + ("hidden")  + ";\n  transition : " + ("visibility"+ " " +"0"+ " " +"linear"+ " " +"0.2s"+ ","+ " " +"opacity"+ " " +"0.2s"+ " " +"linear")  + ";\n  opacity : " + ("0")  + ";\n  z-index : " + ("100")  + ";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceContainer:hover .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-toolTip {\n  visibility : " + ("visible")  + ";\n  opacity : ") + (("1")  + ";\n  transition-delay : " + ("0")  + ";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceContainer .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-toolTip .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceNumber {\n  display : " + ("inline-block")  + ";\n  vertical-align : " + ("top")  + ";\n  color : " + ("#ccc")  + ";\n  font-size : " + ("24px")  + ";\n  line-height : " + ("24px")  + ";\n  font-weight : " + ("bold")  + ";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceContainer .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-toolTip .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceInfo {\n  display : " + ("inline-block")  + ";\n  border-left : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  margin-left : " + ("10px") ) + (";\n  padding-left : " + ("10px")  + ";\n  width : " + ("245px")  + ";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceContainer .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-toolTip .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceInfo .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-title {\n  font-weight : " + ("bold")  + ";\n  width : " + ("250px")  + ";\n  white-space : " + ("nowrap")  + ";\n  overflow : " + ("hidden")  + ";\n  text-overflow : " + ("ellipsis")  + ";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceContainer .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-toolTip .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceInfo .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-source {\n  font-style : " + ("italic")  + ";\n  color : " + ("#999")  + ";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceContainer .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-toolTip .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceInfo .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-type {\n  line-height : " + ("1.4em")  + ";\n  white-space : ") + (("normal")  + ";\n  color : " + ("#515151")  + ";\n  font-size : " + ("12px")  + ";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceContainer .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceBlock {\n  width : " + ("108px")  + ";\n  overflow : " + ("visible")  + ";\n  display : " + ("inline-block")  + ";\n  margin-right : " + ("5px")  + ";\n  padding : " + ("15px")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#eee")  + ";\n  background-color : " + ("#f7f7f7")  + ";\n  text-align : " + ("center") ) + (";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceContainer:hover .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceBlock {\n  cursor : " + ("pointer")  + ";\n  opacity : " + ("0.6")  + ";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceBlock .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-number {\n  margin : " + ("5px")  + ";\n  font-weight : " + ("bold")  + ";\n  color : " + ("#999")  + ";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceBlock .org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-restitle {\n  white-space : " + ("normal")  + ";\n  color : " + ("#515151")  + " !important;\n  font-size : " + ("12px")  + ";\n  font-family : " + ("Arial"+ ","+ " " +"sans-serif")  + " !important;\n  height : " + ("28px")  + ";\n  width : ") + (("108px")  + ";\n  overflow : " + ("hidden")  + ";\n  white-space : " + ("nowrap")  + ";\n  text-overflow : " + ("ellipsis")  + ";\n}\n.org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceContainer a:hover {\n  opacity : " + ("1")  + " !important;\n}\n* {\n  -webkit-font-smoothing : " + ("antialiased")  + " !important;\n}\n"));
      }
      public java.lang.String number(){
        return "org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-number";
      }
      public java.lang.String resourceBlock(){
        return "org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceBlock";
      }
      public java.lang.String resourceContainer(){
        return "org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceContainer";
      }
      public java.lang.String resourceImage(){
        return "org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resource-image";
      }
      public java.lang.String resourceInfo(){
        return "org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceInfo";
      }
      public java.lang.String resourceNumber(){
        return "org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resourceNumber";
      }
      public java.lang.String resourceThumbnail(){
        return "org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resource-thumbnail";
      }
      public java.lang.String resourceType(){
        return "org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-resource-type";
      }
      public java.lang.String restitle(){
        return "org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-restitle";
      }
      public java.lang.String source(){
        return "org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-source";
      }
      public java.lang.String title(){
        return "org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-title";
      }
      public java.lang.String toolTip(){
        return "org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-toolTip";
      }
      public java.lang.String type(){
        return "org-ednovo-gooru-client-uc-PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle-type";
      }
    }
    ;
  }
  private static class playerStyleInitializer {
    static {
      _instance0.playerStyleInitializer();
    }
    static org.ednovo.gooru.client.uc.PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle get() {
      return playerStyle;
    }
  }
  public org.ednovo.gooru.client.uc.PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle playerStyle() {
    return playerStyleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.uc.PreviewResourceView_TocResourceViewUiBinderImpl_GenCss_playerStyle playerStyle;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      playerStyle(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("playerStyle", playerStyle());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'playerStyle': return this.@org.ednovo.gooru.client.uc.PreviewResourceView_TocResourceViewUiBinderImpl_GenBundle::playerStyle()();
    }
    return null;
  }-*/;
}
