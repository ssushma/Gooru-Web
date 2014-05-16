package org.ednovo.gooru.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class TinyMceBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.ui.TinyMceBundle {
  private static TinyMceBundle_default_InlineClientBundleGenerator _instance0 = new TinyMceBundle_default_InlineClientBundleGenerator();
  private void tinyMceStyleInitializer() {
    tinyMceStyle = new org.ednovo.gooru.client.ui.TinyMceBundle.TinyMceStyle() {
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
        return "tinyMceStyle";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-ui-TinyMceBundle-TinyMceStyle-tinyMceStyleButton {\n  color : " + ("#1076bb")  + ";\n  border-radius : " + ("4px"+ " " +"4px"+ " " +"0"+ " " +"0")  + ";\n  padding : " + ("1px"+ " " +"6px")  + ";\n  border : " + ("none")  + ";\n  font-family : " + ("Arial"+ ","+ " " +"sans-serif")  + ";\n  display : " + ("inline-block")  + ";\n  background : " + ("#efefef")  + ";\n  background : " + ("-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#fdfdfd" + ")"+ ","+ " " +"to(" + "#ddd" + ")" + ")")  + ";\n  background : " + ("-webkit-linear-gradient(" + "top"+ ","+ " " +"#fdfdfd"+ ","+ " " +"#ddd" + ")")  + ";\n  background : " + ("-moz-linear-gradient(" + "top"+ ","+ " " +"#fdfdfd"+ ","+ " " +"#ddd" + ")")  + ";\n  background : ") + (("-ms-linear-gradient(" + "top"+ ","+ " " +"#fdfdfd"+ ","+ " " +"#ddd" + ")")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#fdfdfd"+ ","+ " " +"#ddd" + ")")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  float : " + ("left")  + ";\n  margin-top : " + ("-20px")  + ";\n  font-weight : " + ("bold")  + ";\n  font-style : " + ("italic")  + ";\n}\n.org-ednovo-gooru-client-ui-TinyMceBundle-TinyMceStyle-tinyMceStyleButton:hover {\n  cursor : " + ("pointer")  + ";\n  background : " + ("#eee")  + ";\n}\n.org-ednovo-gooru-client-ui-TinyMceBundle-TinyMceStyle-addBackGroundColor {\n  background-color : " + ("#ccc")  + ";\n}\n.org-ednovo-gooru-client-ui-TinyMceBundle-TinyMceStyle-errorMessagesForRichText {\n  color : " + ("#fbb03b") ) + (";\n  font-size : " + ("12px")  + ";\n  font-family : " + ("Arial"+ ","+ " " +"sans-serif")  + ";\n  font-style : " + ("italic")  + ";\n  float : " + ("left")  + ";\n}\n.org-ednovo-gooru-client-ui-TinyMceBundle-TinyMceStyle-markAsBlankLabel {\n  font-family : " + ("Arial"+ ","+ " " +"Helvetica"+ ","+ " " +"sans-serif")  + ";\n  font-size : " + ("12px")  + ";\n  float : " + ("left")  + ";\n  cursor : " + ("pointer")  + ";\n  color : " + ("#1076ba")  + ";\n  text-align : " + ("left")  + ";\n  padding : ") + (("0"+ " " +"0"+ " " +"0"+ " " +"0")  + ";\n  margin : " + ("-16px"+ " " +"0"+ " " +"0"+ " " +"28px")  + ";\n}\n.org-ednovo-gooru-client-ui-TinyMceBundle-TinyMceStyle-markAsBlankLabel:hover {\n  color : " + ("#87badd")  + " !important;\n}\n")) : ((".org-ednovo-gooru-client-ui-TinyMceBundle-TinyMceStyle-tinyMceStyleButton {\n  color : " + ("#1076bb")  + ";\n  border-radius : " + ("4px"+ " " +"4px"+ " " +"0"+ " " +"0")  + ";\n  padding : " + ("1px"+ " " +"6px")  + ";\n  border : " + ("none")  + ";\n  font-family : " + ("Arial"+ ","+ " " +"sans-serif")  + ";\n  display : " + ("inline-block")  + ";\n  background : " + ("#efefef")  + ";\n  background : " + ("-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#fdfdfd" + ")"+ ","+ " " +"to(" + "#ddd" + ")" + ")")  + ";\n  background : " + ("-webkit-linear-gradient(" + "top"+ ","+ " " +"#fdfdfd"+ ","+ " " +"#ddd" + ")")  + ";\n  background : " + ("-moz-linear-gradient(" + "top"+ ","+ " " +"#fdfdfd"+ ","+ " " +"#ddd" + ")")  + ";\n  background : ") + (("-ms-linear-gradient(" + "top"+ ","+ " " +"#fdfdfd"+ ","+ " " +"#ddd" + ")")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#fdfdfd"+ ","+ " " +"#ddd" + ")")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  float : " + ("right")  + ";\n  margin-top : " + ("-20px")  + ";\n  font-weight : " + ("bold")  + ";\n  font-style : " + ("italic")  + ";\n}\n.org-ednovo-gooru-client-ui-TinyMceBundle-TinyMceStyle-tinyMceStyleButton:hover {\n  cursor : " + ("pointer")  + ";\n  background : " + ("#eee")  + ";\n}\n.org-ednovo-gooru-client-ui-TinyMceBundle-TinyMceStyle-addBackGroundColor {\n  background-color : " + ("#ccc")  + ";\n}\n.org-ednovo-gooru-client-ui-TinyMceBundle-TinyMceStyle-errorMessagesForRichText {\n  color : " + ("#fbb03b") ) + (";\n  font-size : " + ("12px")  + ";\n  font-family : " + ("Arial"+ ","+ " " +"sans-serif")  + ";\n  font-style : " + ("italic")  + ";\n  float : " + ("right")  + ";\n}\n.org-ednovo-gooru-client-ui-TinyMceBundle-TinyMceStyle-markAsBlankLabel {\n  font-family : " + ("Arial"+ ","+ " " +"Helvetica"+ ","+ " " +"sans-serif")  + ";\n  font-size : " + ("12px")  + ";\n  float : " + ("right")  + ";\n  cursor : " + ("pointer")  + ";\n  color : " + ("#1076ba")  + ";\n  text-align : " + ("right")  + ";\n  padding : ") + (("0"+ " " +"0"+ " " +"0"+ " " +"0")  + ";\n  margin : " + ("-16px"+ " " +"28px"+ " " +"0"+ " " +"0")  + ";\n}\n.org-ednovo-gooru-client-ui-TinyMceBundle-TinyMceStyle-markAsBlankLabel:hover {\n  color : " + ("#87badd")  + " !important;\n}\n"));
      }
      public java.lang.String addBackGroundColor(){
        return "org-ednovo-gooru-client-ui-TinyMceBundle-TinyMceStyle-addBackGroundColor";
      }
      public java.lang.String errorMessagesForRichText(){
        return "org-ednovo-gooru-client-ui-TinyMceBundle-TinyMceStyle-errorMessagesForRichText";
      }
      public java.lang.String markAsBlankLabel(){
        return "org-ednovo-gooru-client-ui-TinyMceBundle-TinyMceStyle-markAsBlankLabel";
      }
      public java.lang.String tinyMceStyleButton(){
        return "org-ednovo-gooru-client-ui-TinyMceBundle-TinyMceStyle-tinyMceStyleButton";
      }
    }
    ;
  }
  private static class tinyMceStyleInitializer {
    static {
      _instance0.tinyMceStyleInitializer();
    }
    static org.ednovo.gooru.client.ui.TinyMceBundle.TinyMceStyle get() {
      return tinyMceStyle;
    }
  }
  public org.ednovo.gooru.client.ui.TinyMceBundle.TinyMceStyle tinyMceStyle() {
    return tinyMceStyleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.ui.TinyMceBundle.TinyMceStyle tinyMceStyle;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      tinyMceStyle(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("tinyMceStyle", tinyMceStyle());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'tinyMceStyle': return this.@org.ednovo.gooru.client.ui.TinyMceBundle::tinyMceStyle()();
    }
    return null;
  }-*/;
}
