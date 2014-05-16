package org.ednovo.gooru.client.mvp.image.upload;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class GooruImagesView_GooruImagesViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.mvp.image.upload.GooruImagesView_GooruImagesViewUiBinderImpl_GenBundle {
  private static GooruImagesView_GooruImagesViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new GooruImagesView_GooruImagesViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new org.ednovo.gooru.client.mvp.image.upload.GooruImagesView_GooruImagesViewUiBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-mvp-image-upload-GooruImagesView_GooruImagesViewUiBinderImpl_GenCss_style-imageMainContainer, .org-ednovo-gooru-client-mvp-image-upload-GooruImagesView_GooruImagesViewUiBinderImpl_GenCss_style-imageContainer {\n  float : " + ("right")  + ";\n  width : " + ("131px")  + ";\n  height : " + ("131px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-GooruImagesView_GooruImagesViewUiBinderImpl_GenCss_style-imageContainer:hover {\n  float : " + ("right")  + ";\n  background : " + ("#ddd")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-GooruImagesView_GooruImagesViewUiBinderImpl_GenCss_style-imageContainerActive {\n  float : " + ("right")  + ";\n  background : " + ("#ddd")  + ";\n  moz-box-shadow : " + ("inset"+ " " +"0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.3" + ")")  + ";\n  -webkit-box-shadow : " + ("inset"+ " " +"0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.3" + ")")  + ";\n  box-shadow : ") + (("inset"+ " " +"0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.3" + ")")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-GooruImagesView_GooruImagesViewUiBinderImpl_GenCss_style-chooseImage {\n  float : " + ("right")  + ";\n  width : " + ("111px")  + ";\n  height : " + ("111px")  + ";\n  margin : " + ("5px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-GooruImagesView_GooruImagesViewUiBinderImpl_GenCss_style-imageHolder {\n  float : " + ("right")  + ";\n  width : " + ("111px")  + ";\n  height : " + ("111px")  + ";\n  margin : " + ("5px")  + ";\n  background-color : " + ("#515151") ) + (";\n}\n")) : ((".org-ednovo-gooru-client-mvp-image-upload-GooruImagesView_GooruImagesViewUiBinderImpl_GenCss_style-imageMainContainer, .org-ednovo-gooru-client-mvp-image-upload-GooruImagesView_GooruImagesViewUiBinderImpl_GenCss_style-imageContainer {\n  float : " + ("left")  + ";\n  width : " + ("131px")  + ";\n  height : " + ("131px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-GooruImagesView_GooruImagesViewUiBinderImpl_GenCss_style-imageContainer:hover {\n  float : " + ("left")  + ";\n  background : " + ("#ddd")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-GooruImagesView_GooruImagesViewUiBinderImpl_GenCss_style-imageContainerActive {\n  float : " + ("left")  + ";\n  background : " + ("#ddd")  + ";\n  moz-box-shadow : " + ("inset"+ " " +"0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.3" + ")")  + ";\n  -webkit-box-shadow : " + ("inset"+ " " +"0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.3" + ")")  + ";\n  box-shadow : ") + (("inset"+ " " +"0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.3" + ")")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-GooruImagesView_GooruImagesViewUiBinderImpl_GenCss_style-chooseImage {\n  float : " + ("left")  + ";\n  width : " + ("111px")  + ";\n  height : " + ("111px")  + ";\n  margin : " + ("5px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-GooruImagesView_GooruImagesViewUiBinderImpl_GenCss_style-imageHolder {\n  float : " + ("left")  + ";\n  width : " + ("111px")  + ";\n  height : " + ("111px")  + ";\n  margin : " + ("5px")  + ";\n  background-color : " + ("#515151") ) + (";\n}\n"));
      }
      public java.lang.String chooseImage(){
        return "org-ednovo-gooru-client-mvp-image-upload-GooruImagesView_GooruImagesViewUiBinderImpl_GenCss_style-chooseImage";
      }
      public java.lang.String imageContainer(){
        return "org-ednovo-gooru-client-mvp-image-upload-GooruImagesView_GooruImagesViewUiBinderImpl_GenCss_style-imageContainer";
      }
      public java.lang.String imageContainerActive(){
        return "org-ednovo-gooru-client-mvp-image-upload-GooruImagesView_GooruImagesViewUiBinderImpl_GenCss_style-imageContainerActive";
      }
      public java.lang.String imageHolder(){
        return "org-ednovo-gooru-client-mvp-image-upload-GooruImagesView_GooruImagesViewUiBinderImpl_GenCss_style-imageHolder";
      }
      public java.lang.String imageMainContainer(){
        return "org-ednovo-gooru-client-mvp-image-upload-GooruImagesView_GooruImagesViewUiBinderImpl_GenCss_style-imageMainContainer";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static org.ednovo.gooru.client.mvp.image.upload.GooruImagesView_GooruImagesViewUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public org.ednovo.gooru.client.mvp.image.upload.GooruImagesView_GooruImagesViewUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.mvp.image.upload.GooruImagesView_GooruImagesViewUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@org.ednovo.gooru.client.mvp.image.upload.GooruImagesView_GooruImagesViewUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
