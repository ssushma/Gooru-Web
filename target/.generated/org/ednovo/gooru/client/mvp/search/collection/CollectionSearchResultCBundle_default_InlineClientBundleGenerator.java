package org.ednovo.gooru.client.mvp.search.collection;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class CollectionSearchResultCBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.mvp.search.collection.CollectionSearchResultCBundle {
  private static CollectionSearchResultCBundle_default_InlineClientBundleGenerator _instance0 = new CollectionSearchResultCBundle_default_InlineClientBundleGenerator();
  private void cssInitializer() {
    css = new org.ednovo.gooru.client.mvp.search.collection.CollectionSearchResultCBundle.CollectionSearchResultCss() {
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
        return "css";
      }
      public String getText() {
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collectionPanel {\n  width : " + ("480px")  + ";\n  float : " + ("right")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collectionHeaderPanel {\n  height : " + ("94px")  + ";\n  width : " + ("523px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collectionHeaderTextPanel {\n  float : " + ("right")  + ";\n  height : " + ("60px")  + ";\n  width : " + ("378px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collectionTitle {\n  color : " + ("#1076bb")  + ";\n  font-size : " + ("16px")  + ";\n  font-weight : " + ("bold")  + ";\n  height : ") + (("19px")  + ";\n  margin-bottom : " + ("3px")  + ";\n  overflow : " + ("hidden")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collectionTitle:HOVER {\n  color : " + ("#4c98cc")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-author {\n  font-style : " + ("italic")  + ";\n  margin-bottom : " + ("3px")  + ";\n  margin-left : " + ("4px")  + ";\n  color : " + ("#999")  + ";\n  float : " + ("right")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-authorName {\n  font-style : " + ("italic") ) + (";\n  color : " + ("#999")  + ";\n  display : " + ("inline-block")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-metaDataPanel {\n  font-size : " + ("12px")  + ";\n  font-weight : " + ("normal")  + ";\n  color : " + ("#999")  + ";\n  margin-top : " + ("0")  + ";\n  clear : " + ("both")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-resourceCount {\n  color : " + ("#4e9746")  + ";\n  font-size : " + ("12px")  + ";\n  float : " + ("right")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-standards {\n  clear : ") + (("both")  + ";\n  float : " + ("right")  + ";\n  height : " + ("20px")  + ";\n  margin-top : " + ("15px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collectionDescription {\n  width : " + ("470px")  + ";\n  height : " + ("43px")  + ";\n  font-size : " + ("12px")  + ";\n  color : " + ("#515151")  + ";\n  overflow : " + ("hidden")  + ";\n  line-height : " + ("1.2")  + ";\n  margin-top : " + ("25px") ) + (";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collectionHover {\n  background-color : " + ("rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.6" + ")")  + ";\n  cursor : " + ("pointer")  + ";\n  display : " + ("none")  + ";\n  height : " + ("91px")  + ";\n  position : " + ("relative")  + ";\n  top : " + ("-94px")  + ";\n  width : " + ("121px")  + ";\n  z-index : " + ("20")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collectionThumbnail:hover .org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collectionHover {\n  display : " + ("block")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-playIcon {\n  background : " + ("url(images/Collection-Search/play-icon.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"0"+ " " +"0"+ " " +"transparent")  + ";\n  cursor : ") + (("pointer")  + ";\n  height : " + ("16px")  + ";\n  right : " + ("53px")  + ";\n  position : " + ("relative")  + ";\n  top : " + ("38px")  + ";\n  width : " + ("12px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-authorContainer {\n  float : " + ("right")  + ";\n  width : " + ("288px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collaboratorStyle {\n  display : " + ("inline-block")  + ";\n  color : " + ("#0f76bb")  + ";\n  font-style : " + ("italic") ) + (";\n}\n")) : ((".org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collectionPanel {\n  width : " + ("480px")  + ";\n  float : " + ("left")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collectionHeaderPanel {\n  height : " + ("94px")  + ";\n  width : " + ("523px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collectionHeaderTextPanel {\n  float : " + ("left")  + ";\n  height : " + ("60px")  + ";\n  width : " + ("378px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collectionTitle {\n  color : " + ("#1076bb")  + ";\n  font-size : " + ("16px")  + ";\n  font-weight : " + ("bold")  + ";\n  height : ") + (("19px")  + ";\n  margin-bottom : " + ("3px")  + ";\n  overflow : " + ("hidden")  + ";\n  cursor : " + ("pointer")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collectionTitle:HOVER {\n  color : " + ("#4c98cc")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-author {\n  font-style : " + ("italic")  + ";\n  margin-bottom : " + ("3px")  + ";\n  margin-right : " + ("4px")  + ";\n  color : " + ("#999")  + ";\n  float : " + ("left")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-authorName {\n  font-style : " + ("italic") ) + (";\n  color : " + ("#999")  + ";\n  display : " + ("inline-block")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-metaDataPanel {\n  font-size : " + ("12px")  + ";\n  font-weight : " + ("normal")  + ";\n  color : " + ("#999")  + ";\n  margin-top : " + ("0")  + ";\n  clear : " + ("both")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-resourceCount {\n  color : " + ("#4e9746")  + ";\n  font-size : " + ("12px")  + ";\n  float : " + ("left")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-standards {\n  clear : ") + (("both")  + ";\n  float : " + ("left")  + ";\n  height : " + ("20px")  + ";\n  margin-top : " + ("15px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collectionDescription {\n  width : " + ("470px")  + ";\n  height : " + ("43px")  + ";\n  font-size : " + ("12px")  + ";\n  color : " + ("#515151")  + ";\n  overflow : " + ("hidden")  + ";\n  line-height : " + ("1.2")  + ";\n  margin-top : " + ("25px") ) + (";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collectionHover {\n  background-color : " + ("rgba(" + "0"+ ","+ " " +"0"+ ","+ " " +"0"+ ","+ " " +"0.6" + ")")  + ";\n  cursor : " + ("pointer")  + ";\n  display : " + ("none")  + ";\n  height : " + ("91px")  + ";\n  position : " + ("relative")  + ";\n  top : " + ("-94px")  + ";\n  width : " + ("121px")  + ";\n  z-index : " + ("20")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collectionThumbnail:hover .org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collectionHover {\n  display : " + ("block")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-playIcon {\n  background : " + ("url(images/Collection-Search/play-icon.png)"+ " " +"no-repeat"+ " " +"scroll"+ " " +"0"+ " " +"0"+ " " +"transparent")  + ";\n  cursor : ") + (("pointer")  + ";\n  height : " + ("16px")  + ";\n  left : " + ("53px")  + ";\n  position : " + ("relative")  + ";\n  top : " + ("38px")  + ";\n  width : " + ("12px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-authorContainer {\n  float : " + ("left")  + ";\n  width : " + ("288px")  + ";\n}\n.org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collaboratorStyle {\n  display : " + ("inline-block")  + ";\n  color : " + ("#0f76bb")  + ";\n  font-style : " + ("italic") ) + (";\n}\n"));
      }
      public java.lang.String author(){
        return "org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-author";
      }
      public java.lang.String authorContainer(){
        return "org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-authorContainer";
      }
      public java.lang.String authorName(){
        return "org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-authorName";
      }
      public java.lang.String collaboratorStyle(){
        return "org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collaboratorStyle";
      }
      public java.lang.String collectionDescription(){
        return "org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collectionDescription";
      }
      public java.lang.String collectionHeaderPanel(){
        return "org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collectionHeaderPanel";
      }
      public java.lang.String collectionHeaderTextPanel(){
        return "org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collectionHeaderTextPanel";
      }
      public java.lang.String collectionHover(){
        return "org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collectionHover";
      }
      public java.lang.String collectionPanel(){
        return "org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collectionPanel";
      }
      public java.lang.String collectionThumbnail(){
        return "org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collectionThumbnail";
      }
      public java.lang.String collectionTitle(){
        return "org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-collectionTitle";
      }
      public java.lang.String metaDataPanel(){
        return "org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-metaDataPanel";
      }
      public java.lang.String playIcon(){
        return "org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-playIcon";
      }
      public java.lang.String resourceCount(){
        return "org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-resourceCount";
      }
      public java.lang.String standards(){
        return "org-ednovo-gooru-client-mvp-search-collection-CollectionSearchResultCBundle-CollectionSearchResultCss-standards";
      }
    }
    ;
  }
  private static class cssInitializer {
    static {
      _instance0.cssInitializer();
    }
    static org.ednovo.gooru.client.mvp.search.collection.CollectionSearchResultCBundle.CollectionSearchResultCss get() {
      return css;
    }
  }
  public org.ednovo.gooru.client.mvp.search.collection.CollectionSearchResultCBundle.CollectionSearchResultCss css() {
    return cssInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.mvp.search.collection.CollectionSearchResultCBundle.CollectionSearchResultCss css;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      css(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("css", css());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'css': return this.@org.ednovo.gooru.client.mvp.search.collection.CollectionSearchResultCBundle::css()();
    }
    return null;
  }-*/;
}
