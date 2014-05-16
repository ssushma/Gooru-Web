package org.ednovo.gooru.client.mvp.play.collection.preview;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenBundle {
  private static PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void playerStyleInitializer() {
    playerStyle = new org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayerRightContainer {\n  width : " + ("960px")  + ";\n  height : " + ("525px")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  position : " + ("relative")  + ";\n  z-index : " + ("0")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayerBackgroundImages {\n  width : " + ("700px")  + ";\n  height : " + ("525px")  + ";\n  float : " + ("right")  + ";\n  position : " + ("relative")  + ";\n  z-index : " + ("1")  + ";\n  background-color : ") + (("white")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayLeftBarAssess {\n  width : " + ("35px")  + ";\n  height : " + ("525px")  + ";\n  background : " + ("#1076bb")  + ";\n  float : " + ("right")  + ";\n  position : " + ("absolute")  + ";\n  z-index : " + ("2")  + ";\n  right : " + ("0")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayerCoverSocialContainer {\n  float : " + ("right")  + ";\n  width : " + ("260px")  + ";\n  height : " + ("525px") ) + (";\n  background-color : " + ("#222")  + ";\n  background : " + ("-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#222" + ")"+ ","+ " " +"to(" + "#222" + ")" + ")")  + ";\n  background : " + ("-webkit-linear-gradient(" + "top"+ ","+ " " +"#222"+ ","+ " " +"#222" + ")")  + ";\n  background : " + ("-moz-linear-gradient(" + "top"+ ","+ " " +"#222"+ ","+ " " +"#222" + ")")  + ";\n  background : " + ("-ms-linear-gradient(" + "top"+ ","+ " " +"#222"+ ","+ " " +"#222" + ")")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#222"+ ","+ " " +"#222" + ")")  + ";\n  -moz-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.3" + ")")  + ";\n  -webkit-box-shadow : " + ("0")  + ";\n  box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.3" + ")")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-arrowButton {\n  color : " + ("white")  + ";\n  background-color : ") + (("#1076bb")  + ";\n  border-radius : " + ("4px")  + ";\n  padding : " + ("15px"+ " " +"15px"+ " " +"15px"+ " " +"75px")  + ";\n  font-size : " + ("24px")  + ";\n  border : " + ("none")  + ";\n  font-weight : " + ("bold")  + ";\n  font-family : " + ("Arial"+ ","+ " " +"sans-serif")  + ";\n  display : " + ("inline-block")  + ";\n  margin : " + ("20px"+ " " +"20px"+ " " +"10px"+ " " +"10px")  + ";\n  background : " + ("url(images/button-arrow.png)"+ " " +"left"+ " " +"center"+ " " +"no-repeat"+ ","+ " " +"-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#4c98cc" + ")"+ ","+ " " +"to(" + "#1076bb" + ")" + ")")  + ";\n  background : " + ("url(images/button-arrow.png)"+ " " +"left"+ " " +"center"+ " " +"no-repeat"+ ","+ " " +"-webkit-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")") ) + (";\n  background : " + ("url(images/button-arrow.png)"+ " " +"left"+ " " +"center"+ " " +"no-repeat"+ ","+ " " +"-moz-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("url(images/button-arrow.png)"+ " " +"left"+ " " +"center"+ " " +"no-repeat"+ ","+ " " +"-ms-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("url(images/button-arrow.png)"+ " " +"left"+ " " +"center"+ " " +"no-repeat"+ ","+ " " +"-o-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-arrowButton:hover {\n  color : " + ("white")  + ";\n  background : " + ("#1076bb"+ " " +"url(images/button-arrow.png)"+ " " +"left"+ " " +"center"+ " " +"no-repeat")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayerCoverSocialViewsImageContainer {\n  margin : " + ("10px"+ " " +"20px"+ " " +"10px"+ " " +"0")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionDescriptionContainer {\n  margin : " + ("20px"+ " " +"20px"+ " " +"10px"+ " " +"0")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-coverButtonLikes {\n  background-image : " + ("url(images/player_images.png)")  + ";\n  background-position : " + ("-283px"+ " " +"-34px")  + ";\n  width : ") + (("17px")  + ";\n  height : " + ("18px")  + ";\n  float : " + ("right")  + ";\n  margin-left : " + ("10px")  + ";\n  margin-top : " + ("-3px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-coverButtonViews {\n  background-image : " + ("url(images/player_images.png)")  + ";\n  background-position : " + ("-283px"+ " " +"-76px")  + ";\n  width : " + ("17px")  + ";\n  height : " + ("13px")  + ";\n  float : " + ("right")  + ";\n  margin-left : " + ("10px") ) + (";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionCoverBottomContainerDiv {\n  width : " + ("960px")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  height : " + ("50px")  + ";\n  background : " + ("#171717")  + ";\n}\n")) : ((".org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayerRightContainer {\n  width : " + ("960px")  + ";\n  height : " + ("525px")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  position : " + ("relative")  + ";\n  z-index : " + ("0")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayerBackgroundImages {\n  width : " + ("700px")  + ";\n  height : " + ("525px")  + ";\n  float : " + ("left")  + ";\n  position : " + ("relative")  + ";\n  z-index : " + ("1")  + ";\n  background-color : ") + (("white")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayLeftBarAssess {\n  width : " + ("35px")  + ";\n  height : " + ("525px")  + ";\n  background : " + ("#1076bb")  + ";\n  float : " + ("left")  + ";\n  position : " + ("absolute")  + ";\n  z-index : " + ("2")  + ";\n  left : " + ("0")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayerCoverSocialContainer {\n  float : " + ("left")  + ";\n  width : " + ("260px")  + ";\n  height : " + ("525px") ) + (";\n  background-color : " + ("#222")  + ";\n  background : " + ("-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#222" + ")"+ ","+ " " +"to(" + "#222" + ")" + ")")  + ";\n  background : " + ("-webkit-linear-gradient(" + "top"+ ","+ " " +"#222"+ ","+ " " +"#222" + ")")  + ";\n  background : " + ("-moz-linear-gradient(" + "top"+ ","+ " " +"#222"+ ","+ " " +"#222" + ")")  + ";\n  background : " + ("-ms-linear-gradient(" + "top"+ ","+ " " +"#222"+ ","+ " " +"#222" + ")")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#222"+ ","+ " " +"#222" + ")")  + ";\n  -moz-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.3" + ")")  + ";\n  -webkit-box-shadow : " + ("0")  + ";\n  box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.3" + ")")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-arrowButton {\n  color : " + ("white")  + ";\n  background-color : ") + (("#1076bb")  + ";\n  border-radius : " + ("4px")  + ";\n  padding : " + ("15px"+ " " +"75px"+ " " +"15px"+ " " +"15px")  + ";\n  font-size : " + ("24px")  + ";\n  border : " + ("none")  + ";\n  font-weight : " + ("bold")  + ";\n  font-family : " + ("Arial"+ ","+ " " +"sans-serif")  + ";\n  display : " + ("inline-block")  + ";\n  margin : " + ("20px"+ " " +"10px"+ " " +"10px"+ " " +"20px")  + ";\n  background : " + ("url(images/button-arrow.png)"+ " " +"right"+ " " +"center"+ " " +"no-repeat"+ ","+ " " +"-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#4c98cc" + ")"+ ","+ " " +"to(" + "#1076bb" + ")" + ")")  + ";\n  background : " + ("url(images/button-arrow.png)"+ " " +"right"+ " " +"center"+ " " +"no-repeat"+ ","+ " " +"-webkit-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")") ) + (";\n  background : " + ("url(images/button-arrow.png)"+ " " +"right"+ " " +"center"+ " " +"no-repeat"+ ","+ " " +"-moz-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("url(images/button-arrow.png)"+ " " +"right"+ " " +"center"+ " " +"no-repeat"+ ","+ " " +"-ms-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("url(images/button-arrow.png)"+ " " +"right"+ " " +"center"+ " " +"no-repeat"+ ","+ " " +"-o-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-arrowButton:hover {\n  color : " + ("white")  + ";\n  background : " + ("#1076bb"+ " " +"url(images/button-arrow.png)"+ " " +"right"+ " " +"center"+ " " +"no-repeat")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayerCoverSocialViewsImageContainer {\n  margin : " + ("10px"+ " " +"0"+ " " +"10px"+ " " +"20px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionDescriptionContainer {\n  margin : " + ("20px"+ " " +"0"+ " " +"10px"+ " " +"20px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-coverButtonLikes {\n  background-image : " + ("url(images/player_images.png)")  + ";\n  background-position : " + ("-283px"+ " " +"-34px")  + ";\n  width : ") + (("17px")  + ";\n  height : " + ("18px")  + ";\n  float : " + ("left")  + ";\n  margin-right : " + ("10px")  + ";\n  margin-top : " + ("-3px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-coverButtonViews {\n  background-image : " + ("url(images/player_images.png)")  + ";\n  background-position : " + ("-283px"+ " " +"-76px")  + ";\n  width : " + ("17px")  + ";\n  height : " + ("13px")  + ";\n  float : " + ("left")  + ";\n  margin-right : " + ("10px") ) + (";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionCoverBottomContainerDiv {\n  width : " + ("960px")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n  height : " + ("50px")  + ";\n  background : " + ("#171717")  + ";\n}\n"));
      }
      public java.lang.String arrowButton(){
        return "org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-arrowButton";
      }
      public java.lang.String collectionCoverBottomContainerDiv(){
        return "org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionCoverBottomContainerDiv";
      }
      public java.lang.String collectionDescriptionContainer(){
        return "org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionDescriptionContainer";
      }
      public java.lang.String collectionPlayLeftBarAssess(){
        return "org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayLeftBarAssess";
      }
      public java.lang.String collectionPlayerBackgroundImages(){
        return "org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayerBackgroundImages";
      }
      public java.lang.String collectionPlayerCoverSocialContainer(){
        return "org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayerCoverSocialContainer";
      }
      public java.lang.String collectionPlayerCoverSocialViewsImageContainer(){
        return "org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayerCoverSocialViewsImageContainer";
      }
      public java.lang.String collectionPlayerRightContainer(){
        return "org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-collectionPlayerRightContainer";
      }
      public java.lang.String coverButtonLikes(){
        return "org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-coverButtonLikes";
      }
      public java.lang.String coverButtonViews(){
        return "org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-coverButtonViews";
      }
      public java.lang.String playeraArrowButton(){
        return "org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle-playeraArrowButton";
      }
    }
    ;
  }
  private static class playerStyleInitializer {
    static {
      _instance0.playerStyleInitializer();
    }
    static org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle get() {
      return playerStyle;
    }
  }
  public org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle playerStyle() {
    return playerStyleInitializer.get();
  }
  private void styleInitializer() {
    style = new org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-wrapper {\n  position : " + ("relative")  + ";\n  min-width : " + ("1024px")  + ";\n  height : " + ("auto")  + " !important;\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-wrapperContent {\n  margin-top : " + ("36px")  + ";\n  min-height : " + ("450px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-tabSection {\n  width : " + ("100%")  + ";\n  padding : " + ("20px")  + ";\n  box-sizing : " + ("border-box")  + ";\n  -moz-box-sizing : " + ("border-box")  + ";\n  background : " + ("#f2f2f2")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-viewResult {\n  width : ") + (("1000px")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-closesmall {\n  display : " + ("inline-block")  + ";\n  vertical-align : " + ("top")  + ";\n  height : " + ("80px")  + ";\n  line-height : " + ("80px")  + ";\n  padding-left : " + ("10px")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-closesmall>img {\n  margin-top : " + ("15px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-resource-cover {\n  display : " + ("inline-block")  + ";\n  vertical-align : " + ("top") ) + (";\n  padding-left : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-gooru {\n  font-size : " + ("16px")  + ";\n  line-height : " + ("140%")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-ednovo {\n  font-size : " + ("14px")  + ";\n  font-weight : " + ("bold")  + ";\n  line-height : " + ("140%")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-stars {\n  display : " + ("inline-block")  + ";\n  width : " + ("100px")  + ";\n  height : " + ("22px")  + ";\n  background : " + ("url(../images/ratings.png)"+ " " +"center"+ " " +"no-repeat")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-normal {\n  font-size : ") + (("14px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-view {\n  color : " + ("#1076bb")  + ";\n  font-size : " + ("16px")  + ";\n  height : " + ("80px")  + ";\n  line-height : " + ("80px")  + ";\n  margin-left : " + ("15px")  + ";\n  padding-right : " + ("80px")  + ";\n  padding-left : " + ("20px")  + ";\n  border-left : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-imgSection {\n  display : " + ("inline-block")  + ";\n  vertical-align : " + ("top") ) + (";\n  padding-right : " + ("30px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-info {\n  color : " + ("#515151")  + ";\n  font-size : " + ("14px")  + ";\n  display : " + ("inline-block")  + ";\n  vertical-align : " + ("top")  + ";\n  padding-top : " + ("15px")  + ";\n  padding-right : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-info div:first-child {\n  color : " + ("#4e9746")  + ";\n  font-size : " + ("14px")  + ";\n  line-height : " + ("150%")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-close {\n  position : ") + (("absolute")  + ";\n  left : " + ("40px")  + ";\n  margin-top : " + ("30px")  + ";\n  cursor : " + ("pointer")  + ";\n}\n")) : ((".org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-wrapper {\n  position : " + ("relative")  + ";\n  min-width : " + ("1024px")  + ";\n  height : " + ("auto")  + " !important;\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-wrapperContent {\n  margin-top : " + ("36px")  + ";\n  min-height : " + ("450px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-tabSection {\n  width : " + ("100%")  + ";\n  padding : " + ("20px")  + ";\n  box-sizing : " + ("border-box")  + ";\n  -moz-box-sizing : " + ("border-box")  + ";\n  background : " + ("#f2f2f2")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-viewResult {\n  width : ") + (("1000px")  + ";\n  margin : " + ("0"+ " " +"auto")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-closesmall {\n  display : " + ("inline-block")  + ";\n  vertical-align : " + ("top")  + ";\n  height : " + ("80px")  + ";\n  line-height : " + ("80px")  + ";\n  padding-right : " + ("10px")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-closesmall>img {\n  margin-top : " + ("15px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-resource-cover {\n  display : " + ("inline-block")  + ";\n  vertical-align : " + ("top") ) + (";\n  padding-right : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-gooru {\n  font-size : " + ("16px")  + ";\n  line-height : " + ("140%")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-ednovo {\n  font-size : " + ("14px")  + ";\n  font-weight : " + ("bold")  + ";\n  line-height : " + ("140%")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-stars {\n  display : " + ("inline-block")  + ";\n  width : " + ("100px")  + ";\n  height : " + ("22px")  + ";\n  background : " + ("url(../images/ratings.png)"+ " " +"center"+ " " +"no-repeat")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-normal {\n  font-size : ") + (("14px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-view {\n  color : " + ("#1076bb")  + ";\n  font-size : " + ("16px")  + ";\n  height : " + ("80px")  + ";\n  line-height : " + ("80px")  + ";\n  margin-right : " + ("15px")  + ";\n  padding-left : " + ("80px")  + ";\n  padding-right : " + ("20px")  + ";\n  border-right : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-imgSection {\n  display : " + ("inline-block")  + ";\n  vertical-align : " + ("top") ) + (";\n  padding-left : " + ("30px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-info {\n  color : " + ("#515151")  + ";\n  font-size : " + ("14px")  + ";\n  display : " + ("inline-block")  + ";\n  vertical-align : " + ("top")  + ";\n  padding-top : " + ("15px")  + ";\n  padding-left : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-info div:first-child {\n  color : " + ("#4e9746")  + ";\n  font-size : " + ("14px")  + ";\n  line-height : " + ("150%")  + ";\n}\n.org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-close {\n  position : ") + (("absolute")  + ";\n  right : " + ("40px")  + ";\n  margin-top : " + ("30px")  + ";\n  cursor : " + ("pointer")  + ";\n}\n"));
      }
      public java.lang.String close(){
        return "org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-close";
      }
      public java.lang.String closesmall(){
        return "org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-closesmall";
      }
      public java.lang.String ednovo(){
        return "org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-ednovo";
      }
      public java.lang.String gooru(){
        return "org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-gooru";
      }
      public java.lang.String imgSection(){
        return "org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-imgSection";
      }
      public java.lang.String info(){
        return "org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-info";
      }
      public java.lang.String normal(){
        return "org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-normal";
      }
      public java.lang.String rating(){
        return "org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-rating";
      }
      public java.lang.String resourceCover(){
        return "org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-resource-cover";
      }
      public java.lang.String stars(){
        return "org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-stars";
      }
      public java.lang.String tabSection(){
        return "org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-tabSection";
      }
      public java.lang.String view(){
        return "org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-view";
      }
      public java.lang.String viewResult(){
        return "org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-viewResult";
      }
      public java.lang.String wrapper(){
        return "org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-wrapper";
      }
      public java.lang.String wrapperContent(){
        return "org-ednovo-gooru-client-mvp-play-collection-preview-PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style-wrapperContent";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle playerStyle;
  private static org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style style;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      playerStyle(), 
      style(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("playerStyle", playerStyle());
        resourceMap.put("style", style());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'playerStyle': return this.@org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenBundle::playerStyle()();
      case 'style': return this.@org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
