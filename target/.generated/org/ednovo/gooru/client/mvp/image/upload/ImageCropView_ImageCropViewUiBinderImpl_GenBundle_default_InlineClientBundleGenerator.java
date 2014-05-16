package org.ednovo.gooru.client.mvp.image.upload;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class ImageCropView_ImageCropViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.mvp.image.upload.ImageCropView_ImageCropViewUiBinderImpl_GenBundle {
  private static ImageCropView_ImageCropViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new ImageCropView_ImageCropViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new org.ednovo.gooru.client.mvp.image.upload.ImageCropView_ImageCropViewUiBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-mvp-image-upload-ImageCropView_ImageCropViewUiBinderImpl_GenCss_style-imageCropContainer {\n  min-height : " + ("281px")  + ";\n  padding : " + ("4px")  + ";\n  min-width : " + ("160px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageCropView_ImageCropViewUiBinderImpl_GenCss_style-backPageLink {\n  color : " + ("#0f76bb")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageCropView_ImageCropViewUiBinderImpl_GenCss_style-overRideBlueButton {\n  background : " + ("-moz-linear-gradient(" + "center"+ " " +"top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")"+ " " +"repeat"+ " " +"scroll"+ " " +"0"+ " " +"0"+ " " +"transparent")  + ";\n  border : " + ("0"+ " " +"none")  + ";\n  border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  clear : " + ("both")  + ";\n  color : " + ("#fff")  + ";\n  cursor : ") + (("pointer")  + ";\n  font-weight : " + ("bold")  + ";\n  margin : " + ("10px"+ " " +"0")  + ";\n  padding : " + ("8px"+ " " +"9px")  + ";\n  position : " + ("relative")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageCropView_ImageCropViewUiBinderImpl_GenCss_style-collectionFormCancelButton {\n  clear : " + ("both")  + ";\n  cursor : " + ("pointer")  + ";\n  right : " + ("25px")  + ";\n  position : " + ("relative")  + ";\n  text-decoration : " + ("none")  + ";\n  top : " + ("0") ) + (";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageCropView_ImageCropViewUiBinderImpl_GenCss_style-actionField {\n  float : " + ("right")  + ";\n  width : " + ("auto")  + ";\n  margin-right : " + ("40%")  + ";\n  margin-top : " + ("50px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageCropView_ImageCropViewUiBinderImpl_GenCss_style-loadingTxtStyle {\n  float : " + ("right")  + ";\n  width : " + ("auto")  + ";\n  margin-right : " + ("40%")  + ";\n  padding-bottom : " + ("20px")  + ";\n  padding-top : " + ("20px")  + ";\n  font-style : " + ("italic")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageCropView_ImageCropViewUiBinderImpl_GenCss_style-cropImageWidget {\n  min-width : ") + (("160px")  + ";\n  min-height : " + ("120px")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageCropView_ImageCropViewUiBinderImpl_GenCss_style-cropImageWidgetLoading {\n  height : " + ("70%")  + ";\n  right : " + ("0")  + ";\n  margin-top : " + ("50px")  + ";\n  position : " + ("absolute")  + ";\n  top : " + ("0")  + ";\n  width : " + ("100%")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageCropView_ImageCropViewUiBinderImpl_GenCss_style-cropImageLoadingPanel {\n  height : " + ("100%")  + ";\n  width : " + ("100%") ) + (";\n}\n")) : ((".org-ednovo-gooru-client-mvp-image-upload-ImageCropView_ImageCropViewUiBinderImpl_GenCss_style-imageCropContainer {\n  min-height : " + ("281px")  + ";\n  padding : " + ("4px")  + ";\n  min-width : " + ("160px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageCropView_ImageCropViewUiBinderImpl_GenCss_style-backPageLink {\n  color : " + ("#0f76bb")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageCropView_ImageCropViewUiBinderImpl_GenCss_style-overRideBlueButton {\n  background : " + ("-moz-linear-gradient(" + "center"+ " " +"top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")"+ " " +"repeat"+ " " +"scroll"+ " " +"0"+ " " +"0"+ " " +"transparent")  + ";\n  border : " + ("0"+ " " +"none")  + ";\n  border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  clear : " + ("both")  + ";\n  color : " + ("#fff")  + ";\n  cursor : ") + (("pointer")  + ";\n  font-weight : " + ("bold")  + ";\n  margin : " + ("10px"+ " " +"0")  + ";\n  padding : " + ("8px"+ " " +"9px")  + ";\n  position : " + ("relative")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageCropView_ImageCropViewUiBinderImpl_GenCss_style-collectionFormCancelButton {\n  clear : " + ("both")  + ";\n  cursor : " + ("pointer")  + ";\n  left : " + ("25px")  + ";\n  position : " + ("relative")  + ";\n  text-decoration : " + ("none")  + ";\n  top : " + ("0") ) + (";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageCropView_ImageCropViewUiBinderImpl_GenCss_style-actionField {\n  float : " + ("left")  + ";\n  width : " + ("auto")  + ";\n  margin-left : " + ("40%")  + ";\n  margin-top : " + ("50px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageCropView_ImageCropViewUiBinderImpl_GenCss_style-loadingTxtStyle {\n  float : " + ("left")  + ";\n  width : " + ("auto")  + ";\n  margin-left : " + ("40%")  + ";\n  padding-bottom : " + ("20px")  + ";\n  padding-top : " + ("20px")  + ";\n  font-style : " + ("italic")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageCropView_ImageCropViewUiBinderImpl_GenCss_style-cropImageWidget {\n  min-width : ") + (("160px")  + ";\n  min-height : " + ("120px")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageCropView_ImageCropViewUiBinderImpl_GenCss_style-cropImageWidgetLoading {\n  height : " + ("70%")  + ";\n  left : " + ("0")  + ";\n  margin-top : " + ("50px")  + ";\n  position : " + ("absolute")  + ";\n  top : " + ("0")  + ";\n  width : " + ("100%")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageCropView_ImageCropViewUiBinderImpl_GenCss_style-cropImageLoadingPanel {\n  height : " + ("100%")  + ";\n  width : " + ("100%") ) + (";\n}\n"));
      }
      public java.lang.String actionField(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageCropView_ImageCropViewUiBinderImpl_GenCss_style-actionField";
      }
      public java.lang.String backPageLink(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageCropView_ImageCropViewUiBinderImpl_GenCss_style-backPageLink";
      }
      public java.lang.String collectionFormCancelButton(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageCropView_ImageCropViewUiBinderImpl_GenCss_style-collectionFormCancelButton";
      }
      public java.lang.String cropImageLoadingPanel(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageCropView_ImageCropViewUiBinderImpl_GenCss_style-cropImageLoadingPanel";
      }
      public java.lang.String cropImageWidget(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageCropView_ImageCropViewUiBinderImpl_GenCss_style-cropImageWidget";
      }
      public java.lang.String cropImageWidgetLoading(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageCropView_ImageCropViewUiBinderImpl_GenCss_style-cropImageWidgetLoading";
      }
      public java.lang.String imageCropContainer(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageCropView_ImageCropViewUiBinderImpl_GenCss_style-imageCropContainer";
      }
      public java.lang.String loadingTxtStyle(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageCropView_ImageCropViewUiBinderImpl_GenCss_style-loadingTxtStyle";
      }
      public java.lang.String overRideBlueButton(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageCropView_ImageCropViewUiBinderImpl_GenCss_style-overRideBlueButton";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static org.ednovo.gooru.client.mvp.image.upload.ImageCropView_ImageCropViewUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public org.ednovo.gooru.client.mvp.image.upload.ImageCropView_ImageCropViewUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.mvp.image.upload.ImageCropView_ImageCropViewUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@org.ednovo.gooru.client.mvp.image.upload.ImageCropView_ImageCropViewUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
