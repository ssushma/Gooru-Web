package org.ednovo.gooru.client.uc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.uc.StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenBundle {
  private static StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void toolTipInitializer() {
    toolTip = new org.ednovo.gooru.client.uc.StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip() {
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
        return "toolTip";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-organizeContainer {\n  display : " + ("block")  + ";\n  width : " + ("240px")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n}\n.org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-PopupArrow {\n  background : " + ("url(images/bubble-arrow.png)")  + ";\n  display : " + ("block")  + ";\n  width : " + ("25px")  + ";\n  height : " + ("13px")  + ";\n  position : " + ("relative")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  z-index : " + ("999999")  + ";\n}\n.org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-organizePopupTextContainer {\n  -webkit-border-radius : ") + (("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -moz-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -ms-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -khtml-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -o-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  color : " + ("#515151")  + ";\n  font-size : " + ("12px")  + ";\n  padding : " + ("5px")  + ";\n  position : " + ("relative")  + ";\n  top : " + ("-1px")  + ";\n  color : " + ("#515151") ) + (";\n  float : " + ("right")  + ";\n  line-height : " + ("18px")  + ";\n  z-index : " + ("99999")  + ";\n}\n.org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-organizeTextContainer {\n  float : " + ("right")  + ";\n  min-width : " + ("84px")  + ";\n  max-width : " + ("300px")  + ";\n}\n.org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-organizeText {\n  float : " + ("right")  + ";\n  font-family : " + ("Arial"+ ","+ " " +"Helvetica"+ ","+ " " +"sans-serif")  + ";\n  font-size : " + ("12px")  + ";\n  margin : " + ("2px"+ " " +"8px"+ " " +"0"+ " " +"0")  + ";\n}\n.org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-content {\n  background-color : ") + (("white")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -webkit-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -moz-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -ms-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -khtml-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -o-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.2" + ")")  + ";\n  color : " + ("#515151")  + ";\n  font-size : " + ("12px") ) + (";\n  padding : " + ("5px")  + ";\n  position : " + ("relative")  + ";\n  top : " + ("-4px")  + ";\n}\n.org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-tooltipContainer {\n  position : " + ("absolute")  + ";\n}\n.org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-arrowBorder {\n  width : " + ("0")  + ";\n  height : " + ("0")  + ";\n  border : " + ("10px"+ " " +"solid")  + ";\n  border-color : " + ("transparent"+ " " +"transparent"+ " " +"#ddd"+ " " +"transparent")  + ";\n  position : " + ("relative")  + ";\n  top : " + ("0")  + ";\n  margin : ") + (("auto")  + ";\n  border-top : " + ("none")  + ";\n}\n.org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-arrow {\n  width : " + ("0")  + ";\n  height : " + ("0")  + ";\n  border : " + ("10px"+ " " +"solid")  + ";\n  border-color : " + ("transparent"+ " " +"transparent"+ " " +"white"+ " " +"transparent")  + ";\n  position : " + ("relative")  + ";\n  margin : " + ("auto")  + ";\n  top : " + ("-9px")  + ";\n  border-top : " + ("none")  + ";\n  z-index : " + ("100") ) + (";\n  right : " + ("0")  + ";\n  left : " + ("0")  + ";\n}\n.org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-tooltipContent {\n  text-align : " + ("right")  + ";\n  color : " + ("#515151")  + ";\n  font-size : " + ("12px")  + ";\n  font-weight : " + ("normal")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  padding : " + ("5px")  + ";\n  background-color : " + ("white")  + ";\n  -moz-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.1" + ")")  + ";\n  -webkit-box-shadow : ") + (("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.1" + ")")  + ";\n  box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.1" + ")")  + ";\n  -moz-border-radius : " + ("4px")  + ";\n  position : " + ("relative")  + ";\n  top : " + ("-10px")  + ";\n  width : " + ("163px")  + ";\n  float : " + ("right")  + ";\n  right : " + ("-7px")  + ";\n}\n.org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-tooltipContentTitle {\n  padding-bottom : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-tooltipContentorganize {\n  text-align : " + ("right")  + ";\n  color : " + ("#515151") ) + (";\n  font-size : " + ("12px")  + ";\n  font-weight : " + ("normal")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  padding : " + ("5px")  + ";\n  background-color : " + ("white")  + ";\n  -moz-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.1" + ")")  + ";\n  -webkit-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.1" + ")")  + ";\n  box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.1" + ")")  + ";\n  -moz-border-radius : " + ("4px")  + ";\n  position : " + ("relative")  + ";\n  top : ") + (("-6px")  + ";\n  width : " + ("277px")  + ";\n  float : " + ("right")  + ";\n  right : " + ("-7px")  + ";\n}\n")) : ((".org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-organizeContainer {\n  display : " + ("block")  + ";\n  width : " + ("240px")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n}\n.org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-PopupArrow {\n  background : " + ("url(images/bubble-arrow.png)")  + ";\n  display : " + ("block")  + ";\n  width : " + ("25px")  + ";\n  height : " + ("13px")  + ";\n  position : " + ("relative")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  z-index : " + ("999999")  + ";\n}\n.org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-organizePopupTextContainer {\n  -webkit-border-radius : ") + (("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -moz-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -ms-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -khtml-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -o-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  color : " + ("#515151")  + ";\n  font-size : " + ("12px")  + ";\n  padding : " + ("5px")  + ";\n  position : " + ("relative")  + ";\n  top : " + ("-1px")  + ";\n  color : " + ("#515151") ) + (";\n  float : " + ("left")  + ";\n  line-height : " + ("18px")  + ";\n  z-index : " + ("99999")  + ";\n}\n.org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-organizeTextContainer {\n  float : " + ("left")  + ";\n  min-width : " + ("84px")  + ";\n  max-width : " + ("300px")  + ";\n}\n.org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-organizeText {\n  float : " + ("left")  + ";\n  font-family : " + ("Arial"+ ","+ " " +"Helvetica"+ ","+ " " +"sans-serif")  + ";\n  font-size : " + ("12px")  + ";\n  margin : " + ("2px"+ " " +"0"+ " " +"0"+ " " +"8px")  + ";\n}\n.org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-content {\n  background-color : ") + (("white")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -webkit-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -moz-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -ms-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -khtml-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -o-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.2" + ")")  + ";\n  color : " + ("#515151")  + ";\n  font-size : " + ("12px") ) + (";\n  padding : " + ("5px")  + ";\n  position : " + ("relative")  + ";\n  top : " + ("-4px")  + ";\n}\n.org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-tooltipContainer {\n  position : " + ("absolute")  + ";\n}\n.org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-arrowBorder {\n  width : " + ("0")  + ";\n  height : " + ("0")  + ";\n  border : " + ("10px"+ " " +"solid")  + ";\n  border-color : " + ("transparent"+ " " +"transparent"+ " " +"#ddd"+ " " +"transparent")  + ";\n  position : " + ("relative")  + ";\n  top : " + ("0")  + ";\n  margin : ") + (("auto")  + ";\n  border-top : " + ("none")  + ";\n}\n.org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-arrow {\n  width : " + ("0")  + ";\n  height : " + ("0")  + ";\n  border : " + ("10px"+ " " +"solid")  + ";\n  border-color : " + ("transparent"+ " " +"transparent"+ " " +"white"+ " " +"transparent")  + ";\n  position : " + ("relative")  + ";\n  margin : " + ("auto")  + ";\n  top : " + ("-9px")  + ";\n  border-top : " + ("none")  + ";\n  z-index : " + ("100") ) + (";\n  left : " + ("0")  + ";\n  right : " + ("0")  + ";\n}\n.org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-tooltipContent {\n  text-align : " + ("left")  + ";\n  color : " + ("#515151")  + ";\n  font-size : " + ("12px")  + ";\n  font-weight : " + ("normal")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  padding : " + ("5px")  + ";\n  background-color : " + ("white")  + ";\n  -moz-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.1" + ")")  + ";\n  -webkit-box-shadow : ") + (("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.1" + ")")  + ";\n  box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.1" + ")")  + ";\n  -moz-border-radius : " + ("4px")  + ";\n  position : " + ("relative")  + ";\n  top : " + ("-10px")  + ";\n  width : " + ("163px")  + ";\n  float : " + ("left")  + ";\n  left : " + ("-7px")  + ";\n}\n.org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-tooltipContentTitle {\n  padding-bottom : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-tooltipContentorganize {\n  text-align : " + ("left")  + ";\n  color : " + ("#515151") ) + (";\n  font-size : " + ("12px")  + ";\n  font-weight : " + ("normal")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  padding : " + ("5px")  + ";\n  background-color : " + ("white")  + ";\n  -moz-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.1" + ")")  + ";\n  -webkit-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.1" + ")")  + ";\n  box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.1" + ")")  + ";\n  -moz-border-radius : " + ("4px")  + ";\n  position : " + ("relative")  + ";\n  top : ") + (("-6px")  + ";\n  width : " + ("277px")  + ";\n  float : " + ("left")  + ";\n  left : " + ("-7px")  + ";\n}\n"));
      }
      public java.lang.String PopupArrow(){
        return "org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-PopupArrow";
      }
      public java.lang.String arrow(){
        return "org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-arrow";
      }
      public java.lang.String arrowBorder(){
        return "org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-arrowBorder";
      }
      public java.lang.String content(){
        return "org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-content";
      }
      public java.lang.String organizeContainer(){
        return "org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-organizeContainer";
      }
      public java.lang.String organizePopupTextContainer(){
        return "org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-organizePopupTextContainer";
      }
      public java.lang.String organizeText(){
        return "org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-organizeText";
      }
      public java.lang.String organizeTextContainer(){
        return "org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-organizeTextContainer";
      }
      public java.lang.String tooltipContainer(){
        return "org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-tooltipContainer";
      }
      public java.lang.String tooltipContent(){
        return "org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-tooltipContent";
      }
      public java.lang.String tooltipContentTitle(){
        return "org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-tooltipContentTitle";
      }
      public java.lang.String tooltipContentorganize(){
        return "org-ednovo-gooru-client-uc-StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip-tooltipContentorganize";
      }
    }
    ;
  }
  private static class toolTipInitializer {
    static {
      _instance0.toolTipInitializer();
    }
    static org.ednovo.gooru.client.uc.StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip get() {
      return toolTip;
    }
  }
  public org.ednovo.gooru.client.uc.StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip toolTip() {
    return toolTipInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.uc.StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenCss_toolTip toolTip;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      toolTip(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("toolTip", toolTip());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'toolTip': return this.@org.ednovo.gooru.client.uc.StandardPreferenceTooltip_StandardPreferenceTooltipUiBinderImpl_GenBundle::toolTip()();
    }
    return null;
  }-*/;
}
