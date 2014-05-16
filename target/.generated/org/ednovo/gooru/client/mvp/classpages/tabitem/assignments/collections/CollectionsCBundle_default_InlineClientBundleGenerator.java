package org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class CollectionsCBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections.CollectionsCBundle {
  private static CollectionsCBundle_default_InlineClientBundleGenerator _instance0 = new CollectionsCBundle_default_InlineClientBundleGenerator();
  private void cssInitializer() {
    css = new org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections.CollectionsCBundle.CollectionsCss() {
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
        return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".org-ednovo-gooru-client-mvp-classpages-tabitem-assignments-collections-CollectionsCBundle-CollectionsCss-classpageTextarea {\n  font-family : " + ("Arial"+ ","+ " " +"Helvetica"+ ","+ " " +"sans-serif")  + ";\n  width : " + ("785px")  + ";\n  outline : " + ("0")  + ";\n  height : " + ("65px")  + ";\n  line-height : " + ("180%")  + ";\n  margin-top : " + ("5px")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  background-color : " + ("#fff")  + ";\n  resize : " + ("none")  + ";\n  float : " + ("none")  + " !important;\n}\n.org-ednovo-gooru-client-mvp-classpages-tabitem-assignments-collections-CollectionsCBundle-CollectionsCss-dateText {\n  display : ") + (("inline-block")  + ";\n  vertical-align : " + ("top")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-tabitem-assignments-collections-CollectionsCBundle-CollectionsCss-systemMessage {\n  color : " + ("#999")  + ";\n  font-style : " + ("italic")  + ";\n  width : " + ("100%")  + ";\n  text-align : " + ("right")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-tabitem-assignments-collections-CollectionsCBundle-CollectionsCss-dueDataIcon {\n  display : " + ("inline-block")  + ";\n  vertical-align : " + ("top")  + ";\n  background : " + ("url(images/Classpage/calendar.png)"+ " " +"no-repeat")  + ";\n  padding-right : " + ("21px")  + ";\n  height : " + ("18px") ) + (";\n}\n")) : ((".org-ednovo-gooru-client-mvp-classpages-tabitem-assignments-collections-CollectionsCBundle-CollectionsCss-classpageTextarea {\n  font-family : " + ("Arial"+ ","+ " " +"Helvetica"+ ","+ " " +"sans-serif")  + ";\n  width : " + ("785px")  + ";\n  outline : " + ("0")  + ";\n  height : " + ("65px")  + ";\n  line-height : " + ("180%")  + ";\n  margin-top : " + ("5px")  + ";\n  border : " + ("1px"+ " " +"solid"+ " " +"#ddd")  + ";\n  background-color : " + ("#fff")  + ";\n  resize : " + ("none")  + ";\n  float : " + ("none")  + " !important;\n}\n.org-ednovo-gooru-client-mvp-classpages-tabitem-assignments-collections-CollectionsCBundle-CollectionsCss-dateText {\n  display : ") + (("inline-block")  + ";\n  vertical-align : " + ("top")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-tabitem-assignments-collections-CollectionsCBundle-CollectionsCss-systemMessage {\n  color : " + ("#999")  + ";\n  font-style : " + ("italic")  + ";\n  width : " + ("100%")  + ";\n  text-align : " + ("left")  + ";\n}\n.org-ednovo-gooru-client-mvp-classpages-tabitem-assignments-collections-CollectionsCBundle-CollectionsCss-dueDataIcon {\n  display : " + ("inline-block")  + ";\n  vertical-align : " + ("top")  + ";\n  background : " + ("url(images/Classpage/calendar.png)"+ " " +"no-repeat")  + ";\n  padding-left : " + ("21px")  + ";\n  height : " + ("18px") ) + (";\n}\n"));
      }
      public java.lang.String classpageTextarea(){
        return "org-ednovo-gooru-client-mvp-classpages-tabitem-assignments-collections-CollectionsCBundle-CollectionsCss-classpageTextarea";
      }
      public java.lang.String dateText(){
        return "org-ednovo-gooru-client-mvp-classpages-tabitem-assignments-collections-CollectionsCBundle-CollectionsCss-dateText";
      }
      public java.lang.String dueDataIcon(){
        return "org-ednovo-gooru-client-mvp-classpages-tabitem-assignments-collections-CollectionsCBundle-CollectionsCss-dueDataIcon";
      }
      public java.lang.String systemMessage(){
        return "org-ednovo-gooru-client-mvp-classpages-tabitem-assignments-collections-CollectionsCBundle-CollectionsCss-systemMessage";
      }
    }
    ;
  }
  private static class cssInitializer {
    static {
      _instance0.cssInitializer();
    }
    static org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections.CollectionsCBundle.CollectionsCss get() {
      return css;
    }
  }
  public org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections.CollectionsCBundle.CollectionsCss css() {
    return cssInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections.CollectionsCBundle.CollectionsCss css;
  
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
      case 'css': return this.@org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections.CollectionsCBundle::css()();
    }
    return null;
  }-*/;
}
