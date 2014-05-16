package org.ednovo.gooru.client.mvp.image.upload;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class ImageUploadView_ImageUploadViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.mvp.image.upload.ImageUploadView_ImageUploadViewUiBinderImpl_GenBundle {
  private static ImageUploadView_ImageUploadViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new ImageUploadView_ImageUploadViewUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void styleInitializer() {
    style = new org.ednovo.gooru.client.mvp.image.upload.ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imagePopupLeft {\n  width : " + ("170px")  + ";\n  background-color : " + ("#e7e7e7")  + ";\n  height : " + ("480px")  + ";\n  float : " + ("right")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imageUploadAlign {\n  text-align : " + ("center")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imageUploadMinHeight {\n  min-height : " + ("360px")  + ";\n  clear : " + ("both")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imageUploadMinHeightUrl {\n  clear : " + ("both")  + ";\n  min-height : " + ("290px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imagePopupRight {\n  background-color : " + ("#fff")  + ";\n  float : ") + (("right")  + ";\n  height : " + ("450px")  + ";\n  padding : " + ("10px")  + ";\n  width : " + ("410px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imagePopupContainer, .org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-fileUploadUrl {\n  float : " + ("right")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imageUploadList {\n  min-height : " + ("20px")  + ";\n  border-bottom : " + ("1px"+ " " +"solid"+ " " +"#c1d9ff")  + ";\n  border-right : " + ("1px"+ " " +"solid"+ " " +"#c1d9ff")  + ";\n  border-top : " + ("1px"+ " " +"solid"+ " " +"#c1d9ff")  + ";\n  margin : " + ("0"+ " " +"0"+ " " +"1px")  + ";\n  padding : " + ("5px") ) + (";\n  cursor : " + ("pointer")  + ";\n  display : " + ("block")  + " !important;\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imageUploadList:hover {\n  text-decoration : " + ("none")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imageUploadInfo {\n  font-size : " + ("15px")  + ";\n  padding : " + ("5px")  + ";\n  margin : " + ("0"+ " " +"0"+ " " +"1px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-uploadPicstureInfo {\n  margin-bottom : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imageUploadOnWeb {\n  display : " + ("none")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imageUploadOnUrl {\n  display : " + ("block")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-uploadUrlContainer {\n  float : " + ("right")  + ";\n  width : ") + (("410px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-textboxonUrl {\n  border : " + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";\n  float : " + ("right")  + ";\n  height : " + ("27px")  + ";\n  margin-left : " + ("5px")  + ";\n  width : " + ("270px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-textImageUrl {\n  float : " + ("right")  + ";\n  padding : " + ("5px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-uploadActive {\n  background : " + ("#fff")  + ";\n  border-left : " + ("1px"+ " " +"solid"+ " " +"#c1d9ff")  + ";\n  display : " + ("block") ) + (" !important;\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-infoUrlUpload {\n  color : " + ("#777")  + ";\n  font-size : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imageCropPanel {\n  min-width : " + ("600px")  + ";\n  min-height : " + ("400px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-uploadImageButtonOnWeb {\n  float : " + ("right")  + ";\n  margin : " + ("0")  + ";\n  background-color : " + ("#1076bb")  + ";\n  background : " + ("-moz-linear-gradient(" + "center"+ " " +"top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")"+ " " +"repeat"+ " " +"scroll"+ " " +"0"+ " " +"0"+ " " +"transparent")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#4c98cc" + ")"+ ","+ " " +"to(" + "#1076bb" + ")" + ")")  + ";\n  background : ") + (("-webkit-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("-moz-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("-ms-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  border : " + ("0"+ " " +"none")  + ";\n  border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -webkit-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -moz-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -ms-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -khtml-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -o-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px") ) + (";\n  color : " + ("#fff")  + ";\n  cursor : " + ("pointer")  + ";\n  font-size : " + ("12px")  + ";\n  font-weight : " + ("bold")  + ";\n  padding : " + ("8px"+ " " +"9px")  + ";\n  filter : " + ("progid")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-uploadImageButtonOnWeb:hover {\n  background : " + ("#1076bb")  + ";\n  filter : " + ("progid")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-uploadGooruImagesContainer {\n  display : " + ("none")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-defaultImagesContainer {\n  float : " + ("right")  + ";\n  margin-bottom : ") + (("110px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-okButtonOnUploadGooruImages {\n  background-color : " + ("#1076bb")  + ";\n  background : " + ("-moz-linear-gradient(" + "center"+ " " +"top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")"+ " " +"repeat"+ " " +"scroll"+ " " +"0"+ " " +"0"+ " " +"transparent")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#4c98cc" + ")"+ ","+ " " +"to(" + "#1076bb" + ")" + ")")  + ";\n  background : " + ("-webkit-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("-moz-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background-image : " + ("-ms-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  border : " + ("0"+ " " +"none")  + ";\n  border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px") ) + (";\n  -webkit-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -moz-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -ms-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -khtml-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -o-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  color : " + ("white")  + ";\n  cursor : " + ("pointer")  + ";\n  font-size : " + ("12px")  + ";\n  padding : " + ("8px"+ " " +"9px")  + ";\n  width : " + ("50px")  + ";\n  margin-right : ") + (("130px")  + ";\n  float : " + ("right")  + ";\n  filter : " + ("progid")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-okButtonOnUploadGooruImages:hover {\n  background : " + ("#1076bb")  + ";\n  color : " + ("white")  + " !important;\n  filter : " + ("progid")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-cancelButtonOnUploadGooruImages {\n  float : " + ("right")  + ";\n  margin-top : " + ("8px")  + ";\n  margin-right : " + ("15px")  + ";\n  color : " + ("#1076bb")  + ";\n  cursor : " + ("pointer") ) + (";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-cancelButtonOnUploadGooruImages:hover {\n  color : " + ("#87badd")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-notWorkingPanel {\n  padding-top : " + ("245px")  + ";\n  padding-right : " + ("111px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-notWorkingLbl {\n  float : " + ("right")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-readThisLbl {\n  float : " + ("right")  + ";\n  color : " + ("#1076bb")  + ";\n  padding-right : " + ("6px")  + ";\n}\n")) : ((".org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imagePopupLeft {\n  width : " + ("170px")  + ";\n  background-color : " + ("#e7e7e7")  + ";\n  height : " + ("480px")  + ";\n  float : " + ("left")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imageUploadAlign {\n  text-align : " + ("center")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imageUploadMinHeight {\n  min-height : " + ("360px")  + ";\n  clear : " + ("both")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imageUploadMinHeightUrl {\n  clear : " + ("both")  + ";\n  min-height : " + ("290px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imagePopupRight {\n  background-color : " + ("#fff")  + ";\n  float : ") + (("left")  + ";\n  height : " + ("450px")  + ";\n  padding : " + ("10px")  + ";\n  width : " + ("410px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imagePopupContainer, .org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-fileUploadUrl {\n  float : " + ("left")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imageUploadList {\n  min-height : " + ("20px")  + ";\n  border-bottom : " + ("1px"+ " " +"solid"+ " " +"#c1d9ff")  + ";\n  border-left : " + ("1px"+ " " +"solid"+ " " +"#c1d9ff")  + ";\n  border-top : " + ("1px"+ " " +"solid"+ " " +"#c1d9ff")  + ";\n  margin : " + ("0"+ " " +"0"+ " " +"1px")  + ";\n  padding : " + ("5px") ) + (";\n  cursor : " + ("pointer")  + ";\n  display : " + ("block")  + " !important;\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imageUploadList:hover {\n  text-decoration : " + ("none")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imageUploadInfo {\n  font-size : " + ("15px")  + ";\n  padding : " + ("5px")  + ";\n  margin : " + ("0"+ " " +"0"+ " " +"1px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-uploadPicstureInfo {\n  margin-bottom : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imageUploadOnWeb {\n  display : " + ("none")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imageUploadOnUrl {\n  display : " + ("block")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-uploadUrlContainer {\n  float : " + ("left")  + ";\n  width : ") + (("410px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-textboxonUrl {\n  border : " + ("1px"+ " " +"solid"+ " " +"#ccc")  + ";\n  float : " + ("left")  + ";\n  height : " + ("27px")  + ";\n  margin-right : " + ("5px")  + ";\n  width : " + ("270px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-textImageUrl {\n  float : " + ("left")  + ";\n  padding : " + ("5px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-uploadActive {\n  background : " + ("#fff")  + ";\n  border-right : " + ("1px"+ " " +"solid"+ " " +"#c1d9ff")  + ";\n  display : " + ("block") ) + (" !important;\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-infoUrlUpload {\n  color : " + ("#777")  + ";\n  font-size : " + ("10px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imageCropPanel {\n  min-width : " + ("600px")  + ";\n  min-height : " + ("400px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-uploadImageButtonOnWeb {\n  float : " + ("left")  + ";\n  margin : " + ("0")  + ";\n  background-color : " + ("#1076bb")  + ";\n  background : " + ("-moz-linear-gradient(" + "center"+ " " +"top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")"+ " " +"repeat"+ " " +"scroll"+ " " +"0"+ " " +"0"+ " " +"transparent")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#4c98cc" + ")"+ ","+ " " +"to(" + "#1076bb" + ")" + ")")  + ";\n  background : ") + (("-webkit-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("-moz-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("-ms-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  border : " + ("0"+ " " +"none")  + ";\n  border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -webkit-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -moz-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -ms-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -khtml-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -o-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px") ) + (";\n  color : " + ("#fff")  + ";\n  cursor : " + ("pointer")  + ";\n  font-size : " + ("12px")  + ";\n  font-weight : " + ("bold")  + ";\n  padding : " + ("8px"+ " " +"9px")  + ";\n  filter : " + ("progid")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-uploadImageButtonOnWeb:hover {\n  background : " + ("#1076bb")  + ";\n  filter : " + ("progid")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-uploadGooruImagesContainer {\n  display : " + ("none")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-defaultImagesContainer {\n  float : " + ("left")  + ";\n  margin-bottom : ") + (("110px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-okButtonOnUploadGooruImages {\n  background-color : " + ("#1076bb")  + ";\n  background : " + ("-moz-linear-gradient(" + "center"+ " " +"top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")"+ " " +"repeat"+ " " +"scroll"+ " " +"0"+ " " +"0"+ " " +"transparent")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("-webkit-gradient(" + "linear"+ ","+ " " +"0"+ " " +"0"+ ","+ " " +"0"+ " " +"100%"+ ","+ " " +"from(" + "#4c98cc" + ")"+ ","+ " " +"to(" + "#1076bb" + ")" + ")")  + ";\n  background : " + ("-webkit-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("-moz-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background-image : " + ("-ms-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  background : " + ("-o-linear-gradient(" + "top"+ ","+ " " +"#4c98cc"+ ","+ " " +"#1076bb" + ")")  + ";\n  border : " + ("0"+ " " +"none")  + ";\n  border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px") ) + (";\n  -webkit-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -moz-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -ms-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -khtml-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  -o-border-radius : " + ("4px"+ " " +"4px"+ " " +"4px"+ " " +"4px")  + ";\n  color : " + ("white")  + ";\n  cursor : " + ("pointer")  + ";\n  font-size : " + ("12px")  + ";\n  padding : " + ("8px"+ " " +"9px")  + ";\n  width : " + ("50px")  + ";\n  margin-left : ") + (("130px")  + ";\n  float : " + ("left")  + ";\n  filter : " + ("progid")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-okButtonOnUploadGooruImages:hover {\n  background : " + ("#1076bb")  + ";\n  color : " + ("white")  + " !important;\n  filter : " + ("progid")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-cancelButtonOnUploadGooruImages {\n  float : " + ("left")  + ";\n  margin-top : " + ("8px")  + ";\n  margin-left : " + ("15px")  + ";\n  color : " + ("#1076bb")  + ";\n  cursor : " + ("pointer") ) + (";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-cancelButtonOnUploadGooruImages:hover {\n  color : " + ("#87badd")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-notWorkingPanel {\n  padding-top : " + ("245px")  + ";\n  padding-left : " + ("111px")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-notWorkingLbl {\n  float : " + ("left")  + ";\n}\n.org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-readThisLbl {\n  float : " + ("left")  + ";\n  color : " + ("#1076bb")  + ";\n  padding-left : " + ("6px")  + ";\n}\n"));
      }
      public java.lang.String cancelButtonOnUploadGooruImages(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-cancelButtonOnUploadGooruImages";
      }
      public java.lang.String defaultImagesContainer(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-defaultImagesContainer";
      }
      public java.lang.String fileUploadUrl(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-fileUploadUrl";
      }
      public java.lang.String imageCropPanel(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imageCropPanel";
      }
      public java.lang.String imagePopupContainer(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imagePopupContainer";
      }
      public java.lang.String imagePopupLeft(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imagePopupLeft";
      }
      public java.lang.String imagePopupRight(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imagePopupRight";
      }
      public java.lang.String imageUploadAlign(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imageUploadAlign";
      }
      public java.lang.String imageUploadInfo(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imageUploadInfo";
      }
      public java.lang.String imageUploadList(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imageUploadList";
      }
      public java.lang.String imageUploadMinHeight(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imageUploadMinHeight";
      }
      public java.lang.String imageUploadMinHeightUrl(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imageUploadMinHeightUrl";
      }
      public java.lang.String imageUploadOnUrl(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imageUploadOnUrl";
      }
      public java.lang.String imageUploadOnWeb(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-imageUploadOnWeb";
      }
      public java.lang.String infoUrlUpload(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-infoUrlUpload";
      }
      public java.lang.String notWorkingLbl(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-notWorkingLbl";
      }
      public java.lang.String notWorkingPanel(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-notWorkingPanel";
      }
      public java.lang.String okButtonOnUploadGooruImages(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-okButtonOnUploadGooruImages";
      }
      public java.lang.String readThisLbl(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-readThisLbl";
      }
      public java.lang.String textImageUrl(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-textImageUrl";
      }
      public java.lang.String textboxonUrl(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-textboxonUrl";
      }
      public java.lang.String uploadActive(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-uploadActive";
      }
      public java.lang.String uploadGooruImagesContainer(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-uploadGooruImagesContainer";
      }
      public java.lang.String uploadImageButtonOnWeb(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-uploadImageButtonOnWeb";
      }
      public java.lang.String uploadPicstureInfo(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-uploadPicstureInfo";
      }
      public java.lang.String uploadUrlContainer(){
        return "org-ednovo-gooru-client-mvp-image-upload-ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style-uploadUrlContainer";
      }
    }
    ;
  }
  private static class styleInitializer {
    static {
      _instance0.styleInitializer();
    }
    static org.ednovo.gooru.client.mvp.image.upload.ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style get() {
      return style;
    }
  }
  public org.ednovo.gooru.client.mvp.image.upload.ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style style() {
    return styleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.mvp.image.upload.ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style style;
  
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
      case 'style': return this.@org.ednovo.gooru.client.mvp.image.upload.ImageUploadView_ImageUploadViewUiBinderImpl_GenBundle::style()();
    }
    return null;
  }-*/;
}
