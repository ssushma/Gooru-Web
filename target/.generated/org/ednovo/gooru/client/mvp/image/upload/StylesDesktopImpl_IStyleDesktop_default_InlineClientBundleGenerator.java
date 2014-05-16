package org.ednovo.gooru.client.mvp.image.upload;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class StylesDesktopImpl_IStyleDesktop_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.mvp.image.upload.StylesDesktopImpl.IStyleDesktop {
  private static StylesDesktopImpl_IStyleDesktop_default_InlineClientBundleGenerator _instance0 = new StylesDesktopImpl_IStyleDesktop_default_InlineClientBundleGenerator();
  private void getStylesInitializer() {
    getStyles = new com.google.code.gwt.crop.client.CropperStyleResource() {
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
        return "getStyles";
      }
      public String getText() {
        return ("/* CssDef */\n.com-google-code-gwt-crop-client-CropperStyleResource-base {\n  background-color : " + ("#000")  + ";\n  position : " + ("relative")  + ";\n}\n.com-google-code-gwt-crop-client-CropperStyleResource-imageCanvas {\n  opacity : " + ("0.4")  + ";\n  background : " + ("#fff")  + ";\n}\n.com-google-code-gwt-crop-client-CropperStyleResource-selection {\n  border : " + ("1px"+ " " +"dashed"+ " " +"white")  + ";\n}\n.com-google-code-gwt-crop-client-CropperStyleResource-selection IMG {\n  background-color : " + ("#fff")  + ";\n}\n.com-google-code-gwt-crop-client-CropperStyleResource-selectionDraggableBackground {\n  background : " + ("rgba(" + "255"+ ","+ " " +"255"+ ","+ " " +"255"+ ","+ " " +"0" + ")")  + ";\n}\n.com-google-code-gwt-crop-client-CropperStyleResource-handlesContainer {\n  overflow : " + ("visible")  + ";\n}\n.com-google-code-gwt-crop-client-CropperStyleResource-handle {\n  width : " + ("10px")  + ";\n  height : " + ("10px")  + ";\n  border : ") + (("1px"+ " " +"solid"+ " " +"white")  + ";\n  background : " + ("rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.7" + ")")  + ";\n  position : " + ("absolute")  + ";\n}\n.com-google-code-gwt-crop-client-CropperStyleResource-base DIV {\n  -webkit-touch-callout : " + ("none")  + ";\n  -webkit-user-select : " + ("none")  + ";\n  -khtml-user-select : " + ("none")  + ";\n  -moz-user-select : " + ("none")  + ";\n  -ms-user-select : " + ("none")  + ";\n  user-select : " + ("none")  + ";\n}\n");
      }
      public java.lang.String base(){
        return "com-google-code-gwt-crop-client-CropperStyleResource-base";
      }
      public java.lang.String handle(){
        return "com-google-code-gwt-crop-client-CropperStyleResource-handle";
      }
      public int handleSize() {
        return 10;
      }
      public java.lang.String handlesContainer(){
        return "com-google-code-gwt-crop-client-CropperStyleResource-handlesContainer";
      }
      public java.lang.String imageCanvas(){
        return "com-google-code-gwt-crop-client-CropperStyleResource-imageCanvas";
      }
      public java.lang.String selection(){
        return "com-google-code-gwt-crop-client-CropperStyleResource-selection";
      }
      public java.lang.String selectionDraggableBackground(){
        return "com-google-code-gwt-crop-client-CropperStyleResource-selectionDraggableBackground";
      }
    }
    ;
  }
  private static class getStylesInitializer {
    static {
      _instance0.getStylesInitializer();
    }
    static com.google.code.gwt.crop.client.CropperStyleResource get() {
      return getStyles;
    }
  }
  public com.google.code.gwt.crop.client.CropperStyleResource getStyles() {
    return getStylesInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.code.gwt.crop.client.CropperStyleResource getStyles;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      getStyles(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("getStyles", getStyles());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'getStyles': return this.@org.ednovo.gooru.client.mvp.image.upload.StylesDesktopImpl.IStyleDesktop::getStyles()();
    }
    return null;
  }-*/;
}
