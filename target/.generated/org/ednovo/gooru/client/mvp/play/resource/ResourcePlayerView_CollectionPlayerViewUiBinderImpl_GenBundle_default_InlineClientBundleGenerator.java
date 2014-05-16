package org.ednovo.gooru.client.mvp.play.resource;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.mvp.play.resource.ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenBundle {
  private static ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void playerStyleInitializer() {
    playerStyle = new org.ednovo.gooru.client.mvp.play.resource.ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayerRightContainer {\n  width : " + ("960px")  + ";\n  height : " + ("525px")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  position : " + ("relative")  + ";\n  z-index : " + ("0")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayerBackgroundImages {\n  width : " + ("700px")  + ";\n  height : " + ("525px")  + ";\n  float : " + ("right")  + ";\n  position : " + ("relative")  + ";\n  z-index : " + ("1")  + ";\n  background-color : ") + (("white")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayLeftBarAssess {\n  width : " + ("35px")  + ";\n  height : " + ("525px")  + ";\n  background : " + ("#1076bb")  + ";\n  float : " + ("right")  + ";\n  position : " + ("absolute")  + ";\n  z-index : " + ("2")  + ";\n  right : " + ("0")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayerCoverSocialContainer {\n  float : " + ("right")  + ";\n  width : " + ("260px")  + ";\n  height : " + ("525px") ) + (";\n  background-color : " + ("#222")  + ";\n  background : " + ("-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#222" + ")"+ ","+ " " +"to(" + "#222" + ")" + ")")  + ";\n  background : " + ("-webkit-linear-gradient(" + "top"+ ","+ " " +"#222"+ ","+ " " +"#222" + ")")  + ";\n  background : " + ("-moz-linear-gradient(" + "top"+ ","+ " " +"#222"+ ","+ " " +"#222" + ")")  + ";\n  background : " + ("-ms-linear-gradient(" + "top"+ ","+ " " +"#222"+ ","+ " " +"#222" + ")")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#222"+ ","+ " " +"#222" + ")")  + ";\n  -moz-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.3" + ")")  + ";\n  -webkit-box-shadow : " + ("0")  + ";\n  box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.3" + ")")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-arrowButton {\n  color : " + ("white")  + ";\n  background-color : ") + (("#1076bb")  + ";\n  border-radius : " + ("4px")  + ";\n  padding : " + ("15px"+ " " +"15px"+ " " +"15px"+ " " +"75px")  + ";\n  font-size : " + ("24px")  + ";\n  border : " + ("none")  + ";\n  font-weight : " + ("bold")  + ";\n  font-family : " + ("Arial"+ ","+ " " +"sans-serif")  + ";\n  display : " + ("inline-block")  + ";\n  margin : " + ("20px"+ " " +"20px"+ " " +"10px"+ " " +"10px")  + ";\n  background : " + ("url(images/button-arrow.png)"+ " " +"left"+ " " +"center"+ " " +"no-repeat"+ ","+ " " +"-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#4c98cc" + ")"+ ","+ " " +"to(" + "#1076bb" + ")" + ")")  + ";\n  background : " + ("url(images/button-arrow.png)"+ " " +"left"+ " " +"center"+ " " +"no-repeat"+ ","+ " " +"-webkit-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")") ) + (";\n  background : " + ("url(images/button-arrow.png)"+ " " +"left"+ " " +"center"+ " " +"no-repeat"+ ","+ " " +"-moz-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("url(images/button-arrow.png)"+ " " +"left"+ " " +"center"+ " " +"no-repeat"+ ","+ " " +"-ms-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("url(images/button-arrow.png)"+ " " +"left"+ " " +"center"+ " " +"no-repeat"+ ","+ " " +"-o-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-arrowButton:hover {\n  color : " + ("white")  + ";\n  background : " + ("#1076bb"+ " " +"url(images/button-arrow.png)"+ " " +"left"+ " " +"center"+ " " +"no-repeat")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayerCoverSocialViewsImageContainer {\n  margin : " + ("10px"+ " " +"20px"+ " " +"10px"+ " " +"0")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionDescriptionContainer {\n  margin : " + ("20px"+ " " +"20px"+ " " +"10px"+ " " +"0")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-coverButtonLikes {\n  background-image : " + ("url(images/player_images.png)")  + ";\n  background-position : " + ("-283px"+ " " +"-34px")  + ";\n  width : ") + (("17px")  + ";\n  height : " + ("18px")  + ";\n  float : " + ("right")  + ";\n  margin-left : " + ("10px")  + ";\n  margin-top : " + ("-3px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-coverButtonViews {\n  background-image : " + ("url(images/player_images.png)")  + ";\n  background-position : " + ("-283px"+ " " +"-76px")  + ";\n  width : " + ("17px")  + ";\n  height : " + ("13px")  + ";\n  float : " + ("right")  + ";\n  margin-left : " + ("10px") ) + (";\n}\n.org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionCoverBottomContainerDiv {\n  width : " + ("960px")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  height : " + ("50px")  + ";\n  background : " + ("#171717")  + ";\n}\n")) : ((".org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayerRightContainer {\n  width : " + ("960px")  + ";\n  height : " + ("525px")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  position : " + ("relative")  + ";\n  z-index : " + ("0")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayerBackgroundImages {\n  width : " + ("700px")  + ";\n  height : " + ("525px")  + ";\n  float : " + ("left")  + ";\n  position : " + ("relative")  + ";\n  z-index : " + ("1")  + ";\n  background-color : ") + (("white")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayLeftBarAssess {\n  width : " + ("35px")  + ";\n  height : " + ("525px")  + ";\n  background : " + ("#1076bb")  + ";\n  float : " + ("left")  + ";\n  position : " + ("absolute")  + ";\n  z-index : " + ("2")  + ";\n  left : " + ("0")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayerCoverSocialContainer {\n  float : " + ("left")  + ";\n  width : " + ("260px")  + ";\n  height : " + ("525px") ) + (";\n  background-color : " + ("#222")  + ";\n  background : " + ("-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#222" + ")"+ ","+ " " +"to(" + "#222" + ")" + ")")  + ";\n  background : " + ("-webkit-linear-gradient(" + "top"+ ","+ " " +"#222"+ ","+ " " +"#222" + ")")  + ";\n  background : " + ("-moz-linear-gradient(" + "top"+ ","+ " " +"#222"+ ","+ " " +"#222" + ")")  + ";\n  background : " + ("-ms-linear-gradient(" + "top"+ ","+ " " +"#222"+ ","+ " " +"#222" + ")")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#222"+ ","+ " " +"#222" + ")")  + ";\n  -moz-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.3" + ")")  + ";\n  -webkit-box-shadow : " + ("0")  + ";\n  box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.3" + ")")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-arrowButton {\n  color : " + ("white")  + ";\n  background-color : ") + (("#1076bb")  + ";\n  border-radius : " + ("4px")  + ";\n  padding : " + ("15px"+ " " +"75px"+ " " +"15px"+ " " +"15px")  + ";\n  font-size : " + ("24px")  + ";\n  border : " + ("none")  + ";\n  font-weight : " + ("bold")  + ";\n  font-family : " + ("Arial"+ ","+ " " +"sans-serif")  + ";\n  display : " + ("inline-block")  + ";\n  margin : " + ("20px"+ " " +"10px"+ " " +"10px"+ " " +"20px")  + ";\n  background : " + ("url(images/button-arrow.png)"+ " " +"right"+ " " +"center"+ " " +"no-repeat"+ ","+ " " +"-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#4c98cc" + ")"+ ","+ " " +"to(" + "#1076bb" + ")" + ")")  + ";\n  background : " + ("url(images/button-arrow.png)"+ " " +"right"+ " " +"center"+ " " +"no-repeat"+ ","+ " " +"-webkit-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")") ) + (";\n  background : " + ("url(images/button-arrow.png)"+ " " +"right"+ " " +"center"+ " " +"no-repeat"+ ","+ " " +"-moz-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("url(images/button-arrow.png)"+ " " +"right"+ " " +"center"+ " " +"no-repeat"+ ","+ " " +"-ms-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("url(images/button-arrow.png)"+ " " +"right"+ " " +"center"+ " " +"no-repeat"+ ","+ " " +"-o-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-arrowButton:hover {\n  color : " + ("white")  + ";\n  background : " + ("#1076bb"+ " " +"url(images/button-arrow.png)"+ " " +"right"+ " " +"center"+ " " +"no-repeat")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayerCoverSocialViewsImageContainer {\n  margin : " + ("10px"+ " " +"0"+ " " +"10px"+ " " +"20px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionDescriptionContainer {\n  margin : " + ("20px"+ " " +"0"+ " " +"10px"+ " " +"20px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-coverButtonLikes {\n  background-image : " + ("url(images/player_images.png)")  + ";\n  background-position : " + ("-283px"+ " " +"-34px")  + ";\n  width : ") + (("17px")  + ";\n  height : " + ("18px")  + ";\n  float : " + ("left")  + ";\n  margin-right : " + ("10px")  + ";\n  margin-top : " + ("-3px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-coverButtonViews {\n  background-image : " + ("url(images/player_images.png)")  + ";\n  background-position : " + ("-283px"+ " " +"-76px")  + ";\n  width : " + ("17px")  + ";\n  height : " + ("13px")  + ";\n  float : " + ("left")  + ";\n  margin-right : " + ("10px") ) + (";\n}\n.org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionCoverBottomContainerDiv {\n  width : " + ("960px")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  height : " + ("50px")  + ";\n  background : " + ("#171717")  + ";\n}\n"));
      }
      public java.lang.String arrowButton(){
        return "org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-arrowButton";
      }
      public java.lang.String collectionCoverBottomContainerDiv(){
        return "org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionCoverBottomContainerDiv";
      }
      public java.lang.String collectionDescriptionContainer(){
        return "org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionDescriptionContainer";
      }
      public java.lang.String collectionPlayLeftBarAssess(){
        return "org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayLeftBarAssess";
      }
      public java.lang.String collectionPlayerBackgroundImages(){
        return "org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayerBackgroundImages";
      }
      public java.lang.String collectionPlayerCoverSocialContainer(){
        return "org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayerCoverSocialContainer";
      }
      public java.lang.String collectionPlayerCoverSocialViewsImageContainer(){
        return "org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayerCoverSocialViewsImageContainer";
      }
      public java.lang.String collectionPlayerRightContainer(){
        return "org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayerRightContainer";
      }
      public java.lang.String coverButtonLikes(){
        return "org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-coverButtonLikes";
      }
      public java.lang.String coverButtonViews(){
        return "org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-coverButtonViews";
      }
      public java.lang.String playeraArrowButton(){
        return "org-ednovo-gooru-client-mvp-play-resource-ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-playeraArrowButton";
      }
    }
    ;
  }
  private static class playerStyleInitializer {
    static {
      _instance0.playerStyleInitializer();
    }
    static org.ednovo.gooru.client.mvp.play.resource.ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle get() {
      return playerStyle;
    }
  }
  public org.ednovo.gooru.client.mvp.play.resource.ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle playerStyle() {
    return playerStyleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.mvp.play.resource.ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle playerStyle;
  
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
      case 'playerStyle': return this.@org.ednovo.gooru.client.mvp.play.resource.ResourcePlayerView_CollectionPlayerViewUiBinderImpl_GenBundle::playerStyle()();
    }
    return null;
  }-*/;
}
