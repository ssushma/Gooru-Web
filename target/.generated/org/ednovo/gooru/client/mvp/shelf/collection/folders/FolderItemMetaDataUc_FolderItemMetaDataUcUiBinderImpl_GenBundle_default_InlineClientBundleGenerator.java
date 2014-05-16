package org.ednovo.gooru.client.mvp.shelf.collection.folders;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenBundle {
  private static FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenBundle_default_InlineClientBundleGenerator _instance0 = new FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenBundle_default_InlineClientBundleGenerator();
  private void folderMetaStyleInitializer() {
    folderMetaStyle = new org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle() {
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
        return "folderMetaStyle";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-mainSection {\n  border-top : " + ("1px"+ " " +"solid"+ " " +"white")  + ";\n  margin : " + ("5px"+ " " +"30px")  + ";\n  background : " + ("#f0f0f0")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-contentBlock {\n  background : " + ("white")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  -moz-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.1" + ")")  + ";\n  -webkit-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.1" + ")")  + ";\n  box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.1" + ")")  + ";\n  border-radius : " + ("4px")  + ";\n  overflow : " + ("hidden")  + ";\n  margin : ") + (("10px"+ " " +"auto")  + ";\n  width : " + ("91%")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-contentBlock:hover {\n  cursor : " + ("pointer")  + ";\n  -moz-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"#4c98cc")  + ";\n  -webkit-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"#4c98cc")  + ";\n  box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"#4c98cc")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-ideasBlock {\n  color : " + ("#999")  + ";\n  display : " + ("inline-block")  + ";\n  vertical-align : " + ("top")  + ";\n  width : " + ("178px")  + ";\n  height : " + ("170px") ) + (";\n  padding : " + ("10px")  + ";\n  padding-left : " + ("10px")  + ";\n  margin : " + ("5px"+ " " +"0")  + ";\n  border-left : " + ("2px"+ " " +"solid"+ " " +"#f4f4f4")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-ideasBlockLast {\n  border-left : " + ("0"+ " " +"solid"+ " " +"#f4f4f4")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-blockView {\n  padding-right : " + ("22px")  + ";\n  position : " + ("relative")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-blockViewTitle {\n  color : " + ("#515151")  + ";\n  font-size : " + ("14px")  + ";\n  line-height : " + ("17px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-idea {\n  background : ") + (("url(../images/folders/metadata/ideas.png)"+ " " +"no-repeat"+ " " +"2px"+ " " +"0")  + ";\n  height : " + ("17px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-question {\n  background : " + ("url(../images/folders/metadata/question.png)"+ " " +"no-repeat"+ " " +"0"+ " " +"0")  + ";\n  height : " + ("17px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-task {\n  background : " + ("url(../images/folders/metadata/task.png)"+ " " +"no-repeat"+ " " +"0"+ " " +"2px")  + ";\n  height : " + ("17px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-openItem {\n  background : " + ("url(../images/folders/metadata/c_in.png)"+ " " +"no-repeat"+ " " +"0"+ " " +"2px")  + ";\n  height : " + ("20px")  + ";\n  width : " + ("20px")  + ";\n  display : " + ("inline-block")  + ";\n  margin-top : " + ("3px") ) + (";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-closeItem {\n  background : " + ("url(../images/folders/metadata/c_out.png)"+ " " +"no-repeat"+ " " +"0"+ " " +"2px")  + ";\n  height : " + ("20px")  + ";\n  width : " + ("20px")  + ";\n  display : " + ("inline-block")  + ";\n  margin-top : " + ("3px")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-ideasBlock:first-child {\n  padding-right : " + ("12px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-gutter {\n  width : " + ("190px")  + " !important;\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-formButtons {\n  width : " + ("120px")  + ";\n  margin : ") + (("0"+ " " +"auto")  + ";\n  margin-bottom : " + ("10px")  + ";\n  margin-top : " + ("23px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-padding10 {\n  padding : " + ("10px")  + ";\n  overflow : " + ("auto")  + ";\n  height : " + ("137px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-textAreaStyle {\n  font-size : " + ("10px")  + ";\n  color : " + ("#515151")  + ";\n  width : " + ("180px")  + " !important;\n  margin-top : " + ("5px")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#ddd") ) + (";\n  direction : " + ("ltr")  + ";\n  height : " + ("152px")  + ";\n  font-family : " + ("Arial")  + ";\n  font-size : " + ("12px")  + ";\n  overflow : " + ("scroll")  + ";\n  overflow-x : " + ("hidden")  + ";\n  overflow : " + ("visible")  + ";\n  -moz-box-shadow : " + ("inset"+ " " +"0"+ " " +"0"+ " " +"3px")  + ";\n  -webkit-box-shadow : " + ("inset"+ " " +"0"+ " " +"0"+ " " +"3px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-closedPanelHeight {\n  height : " + ("14px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-openedPanelHeight {\n  height : ") + (("170px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-errorLabel {\n  float : " + ("left")  + ";\n}\n")) : ((".org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-mainSection {\n  border-top : " + ("1px"+ " " +"solid"+ " " +"white")  + ";\n  margin : " + ("5px"+ " " +"30px")  + ";\n  background : " + ("#f0f0f0")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-contentBlock {\n  background : " + ("white")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  -moz-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.1" + ")")  + ";\n  -webkit-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.1" + ")")  + ";\n  box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.1" + ")")  + ";\n  border-radius : " + ("4px")  + ";\n  overflow : " + ("hidden")  + ";\n  margin : ") + (("10px"+ " " +"auto")  + ";\n  width : " + ("91%")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-contentBlock:hover {\n  cursor : " + ("pointer")  + ";\n  -moz-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"#4c98cc")  + ";\n  -webkit-box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"#4c98cc")  + ";\n  box-shadow : " + ("0"+ " " +"0"+ " " +"10px"+ " " +"#4c98cc")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-ideasBlock {\n  color : " + ("#999")  + ";\n  display : " + ("inline-block")  + ";\n  vertical-align : " + ("top")  + ";\n  width : " + ("178px")  + ";\n  height : " + ("170px") ) + (";\n  padding : " + ("10px")  + ";\n  padding-right : " + ("10px")  + ";\n  margin : " + ("5px"+ " " +"0")  + ";\n  border-right : " + ("2px"+ " " +"solid"+ " " +"#f4f4f4")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-ideasBlockLast {\n  border-right : " + ("0"+ " " +"solid"+ " " +"#f4f4f4")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-blockView {\n  padding-left : " + ("22px")  + ";\n  position : " + ("relative")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-blockViewTitle {\n  color : " + ("#515151")  + ";\n  font-size : " + ("14px")  + ";\n  line-height : " + ("17px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-idea {\n  background : ") + (("url(../images/folders/metadata/ideas.png)"+ " " +"no-repeat"+ " " +"2px"+ " " +"0")  + ";\n  height : " + ("17px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-question {\n  background : " + ("url(../images/folders/metadata/question.png)"+ " " +"no-repeat"+ " " +"0"+ " " +"0")  + ";\n  height : " + ("17px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-task {\n  background : " + ("url(../images/folders/metadata/task.png)"+ " " +"no-repeat"+ " " +"0"+ " " +"2px")  + ";\n  height : " + ("17px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-openItem {\n  background : " + ("url(../images/folders/metadata/c_in.png)"+ " " +"no-repeat"+ " " +"0"+ " " +"2px")  + ";\n  height : " + ("20px")  + ";\n  width : " + ("20px")  + ";\n  display : " + ("inline-block")  + ";\n  margin-top : " + ("3px") ) + (";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-closeItem {\n  background : " + ("url(../images/folders/metadata/c_out.png)"+ " " +"no-repeat"+ " " +"0"+ " " +"2px")  + ";\n  height : " + ("20px")  + ";\n  width : " + ("20px")  + ";\n  display : " + ("inline-block")  + ";\n  margin-top : " + ("3px")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-ideasBlock:first-child {\n  padding-left : " + ("12px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-gutter {\n  width : " + ("190px")  + " !important;\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-formButtons {\n  width : " + ("120px")  + ";\n  margin : ") + (("0"+ " " +"auto")  + ";\n  margin-bottom : " + ("10px")  + ";\n  margin-top : " + ("23px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-padding10 {\n  padding : " + ("10px")  + ";\n  overflow : " + ("auto")  + ";\n  height : " + ("137px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-textAreaStyle {\n  font-size : " + ("10px")  + ";\n  color : " + ("#515151")  + ";\n  width : " + ("180px")  + " !important;\n  margin-top : " + ("5px")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#ddd") ) + (";\n  direction : " + ("ltr")  + ";\n  height : " + ("152px")  + ";\n  font-family : " + ("Arial")  + ";\n  font-size : " + ("12px")  + ";\n  overflow : " + ("scroll")  + ";\n  overflow-x : " + ("hidden")  + ";\n  overflow : " + ("visible")  + ";\n  -moz-box-shadow : " + ("inset"+ " " +"0"+ " " +"0"+ " " +"3px")  + ";\n  -webkit-box-shadow : " + ("inset"+ " " +"0"+ " " +"0"+ " " +"3px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-closedPanelHeight {\n  height : " + ("14px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-openedPanelHeight {\n  height : ") + (("170px")  + ";\n}\n.org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-errorLabel {\n  float : " + ("right")  + ";\n}\n"));
      }
      public java.lang.String blockView(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-blockView";
      }
      public java.lang.String blockViewTitle(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-blockViewTitle";
      }
      public java.lang.String closeItem(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-closeItem";
      }
      public java.lang.String closedPanelHeight(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-closedPanelHeight";
      }
      public java.lang.String contentBlock(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-contentBlock";
      }
      public java.lang.String errorLabel(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-errorLabel";
      }
      public java.lang.String formButtons(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-formButtons";
      }
      public java.lang.String gutter(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-gutter";
      }
      public java.lang.String idea(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-idea";
      }
      public java.lang.String ideasBlock(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-ideasBlock";
      }
      public java.lang.String ideasBlockLast(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-ideasBlockLast";
      }
      public java.lang.String mainSection(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-mainSection";
      }
      public java.lang.String openItem(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-openItem";
      }
      public java.lang.String openedPanelHeight(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-openedPanelHeight";
      }
      public java.lang.String padding10(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-padding10";
      }
      public java.lang.String question(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-question";
      }
      public java.lang.String task(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-task";
      }
      public java.lang.String textAreaStyle(){
        return "org-ednovo-gooru-client-mvp-shelf-collection-folders-FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle-textAreaStyle";
      }
    }
    ;
  }
  private static class folderMetaStyleInitializer {
    static {
      _instance0.folderMetaStyleInitializer();
    }
    static org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle get() {
      return folderMetaStyle;
    }
  }
  public org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle folderMetaStyle() {
    return folderMetaStyleInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenCss_folderMetaStyle folderMetaStyle;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      folderMetaStyle(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("folderMetaStyle", folderMetaStyle());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'folderMetaStyle': return this.@org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemMetaDataUc_FolderItemMetaDataUcUiBinderImpl_GenBundle::folderMetaStyle()();
    }
    return null;
  }-*/;
}
