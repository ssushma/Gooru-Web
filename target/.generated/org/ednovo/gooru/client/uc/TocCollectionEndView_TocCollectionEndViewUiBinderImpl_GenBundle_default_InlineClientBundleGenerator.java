package org.ednovo.gooru.client.uc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.uc.TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenBundle {
  private static TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void playerStyleInitializer() {
    playerStyle = new org.ednovo.gooru.client.uc.TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-resource-container {\n  float : " + ("right")  + ";\n  height : " + ("90px")  + ";\n  padding : " + ("6px")  + ";\n  margin : " + ("5px")  + ";\n  width : " + ("80px")  + ";\n  margin-bottom : " + ("10px")  + ";\n  list-style-type : " + ("none")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-resource-container:hover, .org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-collection-home-container:hover {\n  background-color : " + ("#414141")  + ";\n}\n.org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-resource-thumbnail {\n  float : " + ("right")  + ";\n  width : ") + (("80px")  + ";\n  height : " + ("60px")  + ";\n  margin : " + ("0"+ " " +"0"+ " " +"0"+ " " +"10px")  + ";\n}\n.org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-resource-image {\n  width : " + ("80px")  + ";\n  height : " + ("60px")  + ";\n}\n.org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-resource-type {\n  position : " + ("relative")  + ";\n  top : " + ("-19px")  + ";\n  z-index : " + ("10")  + ";\n  margin-right : " + ("0")  + " !important;\n}\n.org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-nav-resource-title {\n  display : " + ("block")  + ";\n  color : " + ("#515151") ) + (";\n  margin-top : " + ("5px")  + ";\n  font-family : " + ("Arial"+ ","+ " " +"sans-serif")  + " !important;\n}\n.org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-collection-home-container {\n  float : " + ("right")  + ";\n  height : " + ("90px")  + ";\n  padding : " + ("10px")  + ";\n  margin : " + ("5px")  + ";\n  width : " + ("120px")  + ";\n  margin-bottom : " + ("10px")  + ";\n  list-style-type : " + ("none")  + ";\n  cursor : " + ("pointer")  + ";\n  position : ") + (("relative")  + ";\n}\n.org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-collection-home-thumbnail {\n  float : " + ("right")  + ";\n  width : " + ("120px")  + ";\n  height : " + ("90px")  + ";\n  margin : " + ("0"+ " " +"0"+ " " +"0"+ " " +"10px")  + ";\n}\n.org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-collection-home-image {\n  width : " + ("120px")  + ";\n  height : " + ("90px")  + ";\n  background-color : " + ("black")  + ";\n  opacity : " + ("0.7")  + ";\n}\n.org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-collection-home-type {\n  width : " + ("5px")  + ";\n  height : " + ("90px") ) + (";\n  background : " + ("#1076bb")  + ";\n  position : " + ("absolute")  + ";\n  z-index : " + ("1")  + ";\n}\n.org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-collection-home-overlay {\n  width : " + ("120px")  + ";\n  height : " + ("90px")  + ";\n  background : " + ("#000")  + ";\n  position : " + ("absolute")  + ";\n  opacity : " + ("0.7")  + ";\n}\n.org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-collection-home-title {\n  position : " + ("absolute")  + ";\n  color : " + ("white")  + ";\n  width : ") + (("78px")  + ";\n  text-align : " + ("center")  + ";\n  margin-right : " + ("20px")  + ";\n  margin-top : " + ("30px")  + ";\n  font-weight : " + ("bold")  + ";\n}\n.org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-collection-top-homeContainer {\n  float : " + ("right")  + ";\n}\n")) : ((".org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-resource-container {\n  float : " + ("left")  + ";\n  height : " + ("90px")  + ";\n  padding : " + ("6px")  + ";\n  margin : " + ("5px")  + ";\n  width : " + ("80px")  + ";\n  margin-bottom : " + ("10px")  + ";\n  list-style-type : " + ("none")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-resource-container:hover, .org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-collection-home-container:hover {\n  background-color : " + ("#414141")  + ";\n}\n.org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-resource-thumbnail {\n  float : " + ("left")  + ";\n  width : ") + (("80px")  + ";\n  height : " + ("60px")  + ";\n  margin : " + ("0"+ " " +"10px"+ " " +"0"+ " " +"0")  + ";\n}\n.org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-resource-image {\n  width : " + ("80px")  + ";\n  height : " + ("60px")  + ";\n}\n.org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-resource-type {\n  position : " + ("relative")  + ";\n  top : " + ("-19px")  + ";\n  z-index : " + ("10")  + ";\n  margin-left : " + ("0")  + " !important;\n}\n.org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-nav-resource-title {\n  display : " + ("block")  + ";\n  color : " + ("#515151") ) + (";\n  margin-top : " + ("5px")  + ";\n  font-family : " + ("Arial"+ ","+ " " +"sans-serif")  + " !important;\n}\n.org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-collection-home-container {\n  float : " + ("left")  + ";\n  height : " + ("90px")  + ";\n  padding : " + ("10px")  + ";\n  margin : " + ("5px")  + ";\n  width : " + ("120px")  + ";\n  margin-bottom : " + ("10px")  + ";\n  list-style-type : " + ("none")  + ";\n  cursor : " + ("pointer")  + ";\n  position : ") + (("relative")  + ";\n}\n.org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-collection-home-thumbnail {\n  float : " + ("left")  + ";\n  width : " + ("120px")  + ";\n  height : " + ("90px")  + ";\n  margin : " + ("0"+ " " +"10px"+ " " +"0"+ " " +"0")  + ";\n}\n.org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-collection-home-image {\n  width : " + ("120px")  + ";\n  height : " + ("90px")  + ";\n  background-color : " + ("black")  + ";\n  opacity : " + ("0.7")  + ";\n}\n.org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-collection-home-type {\n  width : " + ("5px")  + ";\n  height : " + ("90px") ) + (";\n  background : " + ("#1076bb")  + ";\n  position : " + ("absolute")  + ";\n  z-index : " + ("1")  + ";\n}\n.org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-collection-home-overlay {\n  width : " + ("120px")  + ";\n  height : " + ("90px")  + ";\n  background : " + ("#000")  + ";\n  position : " + ("absolute")  + ";\n  opacity : " + ("0.7")  + ";\n}\n.org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-collection-home-title {\n  position : " + ("absolute")  + ";\n  color : " + ("white")  + ";\n  width : ") + (("78px")  + ";\n  text-align : " + ("center")  + ";\n  margin-left : " + ("20px")  + ";\n  margin-top : " + ("30px")  + ";\n  font-weight : " + ("bold")  + ";\n}\n.org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-collection-top-homeContainer {\n  float : " + ("left")  + ";\n}\n"));
      }
      public java.lang.String collectionHomeContainer(){
        return "org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-collection-home-container";
      }
      public java.lang.String collectionHomeImage(){
        return "org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-collection-home-image";
      }
      public java.lang.String collectionHomeOverlay(){
        return "org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-collection-home-overlay";
      }
      public java.lang.String collectionHomeThumbnail(){
        return "org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-collection-home-thumbnail";
      }
      public java.lang.String collectionHomeTitle(){
        return "org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-collection-home-title";
      }
      public java.lang.String collectionHomeType(){
        return "org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-collection-home-type";
      }
      public java.lang.String collectionTopHomeContainer(){
        return "org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-collection-top-homeContainer";
      }
      public java.lang.String navResourceTitle(){
        return "org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-nav-resource-title";
      }
      public java.lang.String resourceContainer(){
        return "org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-resource-container";
      }
      public java.lang.String resourceImage(){
        return "org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-resource-image";
      }
      public java.lang.String resourceThumbnail(){
        return "org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-resource-thumbnail";
      }
      public java.lang.String resourceType(){
        return "org-ednovo-gooru-client-uc-TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle-resource-type";
      }
    }
    ;
  }
  private static class playerStyleInitializer {
    static {
      _instance0.playerStyleInitializer();
    }
    static org.ednovo.gooru.client.uc.TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle get() {
      return playerStyle;
    }
  }
  public org.ednovo.gooru.client.uc.TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle playerStyle() {
    return playerStyleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.uc.TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenCss_playerStyle playerStyle;
  
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
      case 'playerStyle': return this.@org.ednovo.gooru.client.uc.TocCollectionEndView_TocCollectionEndViewUiBinderImpl_GenBundle::playerStyle()();
    }
    return null;
  }-*/;
}
