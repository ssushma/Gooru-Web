package org.ednovo.gooru.client.mvp.shelf.list;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class TreeImageBundle_default_InlineClientBundleGenerator implements org.ednovo.gooru.client.mvp.shelf.list.TreeImageBundle {
  private static TreeImageBundle_default_InlineClientBundleGenerator _instance0 = new TreeImageBundle_default_InlineClientBundleGenerator();
  private void leafInitializer() {
    leaf = new com.google.gwt.resources.client.impl.ImageResourcePrototype(
      "leaf",
      com.google.gwt.safehtml.shared.UriUtils.fromTrustedString(externalImage),
      0, 0, 1, 1, false, false
    );
  }
  private static class leafInitializer {
    static {
      _instance0.leafInitializer();
    }
    static com.google.gwt.resources.client.ImageResource get() {
      return leaf;
    }
  }
  public com.google.gwt.resources.client.ImageResource leaf() {
    return leafInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static final java.lang.String externalImage = "data:image/gif;base64,R0lGODlhAQABAIAAAAAAAAAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==";
  private static com.google.gwt.resources.client.ImageResource leaf;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      leaf(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("leaf", leaf());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'leaf': return this.@org.ednovo.gooru.client.mvp.shelf.list.TreeImageBundle::leaf()();
    }
    return null;
  }-*/;
}
