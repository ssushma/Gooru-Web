package org.ednovo.gooru.client.mvp.folders;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$folders$FoldersPresenter$IsFoldersProxy$_annotation$$none$$(org.ednovo.gooru.client.mvp.folders.FoldersPresenter.IsFoldersProxy injectee) {
    
  }
  
  public native void org$ednovo$gooru$client$mvp$folders$FoldersPresenter_folderService_fieldInjection(org.ednovo.gooru.client.mvp.folders.FoldersPresenter injectee, org.ednovo.gooru.client.service.FolderServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.folders.FoldersPresenter::folderService = value;
  }-*/;
  
  public native void org$ednovo$gooru$client$mvp$folders$FoldersPresenter_shelfListPresenter_fieldInjection(org.ednovo.gooru.client.mvp.folders.FoldersPresenter injectee, org.ednovo.gooru.client.mvp.shelf.list.ShelfListPresenter value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.folders.FoldersPresenter::shelfListPresenter = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$folders$FoldersPresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.folders.FoldersPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection_________________________________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$folders$FoldersPresenter_folderService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$FolderServiceAsync$_annotation$$none$$());
    
    org$ednovo$gooru$client$mvp$folders$FoldersPresenter_shelfListPresenter_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_mvp_shelf_list().get_Key$type$org$ednovo$gooru$client$mvp$shelf$list$ShelfListPresenter$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$folders$FoldersView$_annotation$$none$$(org.ednovo.gooru.client.mvp.folders.FoldersView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.folders.IsFoldersView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:126)
   */
  public org.ednovo.gooru.client.mvp.folders.IsFoldersView get_Key$type$org$ednovo$gooru$client$mvp$folders$IsFoldersView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.folders.IsFoldersView result = get_Key$type$org$ednovo$gooru$client$mvp$folders$FoldersView$_annotation$$none$$();
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.folders.FoldersPresenter.IsFoldersProxy singleton_Key$type$org$ednovo$gooru$client$mvp$folders$FoldersPresenter$IsFoldersProxy$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.folders.FoldersPresenter.IsFoldersProxy get_Key$type$org$ednovo$gooru$client$mvp$folders$FoldersPresenter$IsFoldersProxy$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$folders$FoldersPresenter$IsFoldersProxy$_annotation$$none$$ == null) {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.folders.FoldersPresenter.IsFoldersProxy.class);
    assert created instanceof org.ednovo.gooru.client.mvp.folders.FoldersPresenter.IsFoldersProxy;
    org.ednovo.gooru.client.mvp.folders.FoldersPresenter.IsFoldersProxy result = (org.ednovo.gooru.client.mvp.folders.FoldersPresenter.IsFoldersProxy) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$folders$FoldersPresenter$IsFoldersProxy$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$folders$FoldersPresenter$IsFoldersProxy$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$folders$FoldersPresenter$IsFoldersProxy$_annotation$$none$$;
    
  }
  
  private org.ednovo.gooru.client.mvp.folders.FoldersPresenter singleton_Key$type$org$ednovo$gooru$client$mvp$folders$FoldersPresenter$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.folders.FoldersPresenter get_Key$type$org$ednovo$gooru$client$mvp$folders$FoldersPresenter$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$folders$FoldersPresenter$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.mvp.folders.FoldersPresenter result = org$ednovo$gooru$client$mvp$folders$FoldersPresenter_org$ednovo$gooru$client$mvp$folders$FoldersPresenter_methodInjection(injector.getFragment_org_ednovo_gooru_client_mvp_shelf_list().get_Key$type$org$ednovo$gooru$client$mvp$shelf$list$ShelfListPresenter$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$folders$IsFoldersView$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$folders$FoldersPresenter$IsFoldersProxy$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$folders$FoldersPresenter$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$folders$FoldersPresenter$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$folders$FoldersPresenter$_annotation$$none$$;
    
  }
  
  public org.ednovo.gooru.client.mvp.folders.FoldersPresenter org$ednovo$gooru$client$mvp$folders$FoldersPresenter_org$ednovo$gooru$client$mvp$folders$FoldersPresenter_methodInjection(org.ednovo.gooru.client.mvp.shelf.list.ShelfListPresenter _0, org.ednovo.gooru.client.mvp.folders.IsFoldersView _1, org.ednovo.gooru.client.mvp.folders.FoldersPresenter.IsFoldersProxy _2) {
    return new org.ednovo.gooru.client.mvp.folders.FoldersPresenter(_0, _1, _2);
  }
  
  
  /**
   * Binding for com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.folders.FoldersPresenter> declared at:
   *   Implicit injection of com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.folders.FoldersPresenter>
   */
  public com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.folders.FoldersPresenter> get_Key$type$com$google$gwt$inject$client$AsyncProvider$org$ednovo$gooru$client$mvp$folders$FoldersPresenter$$_annotation$$none$$() {
    com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.folders.FoldersPresenter> result = new com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.folders.FoldersPresenter>() { 
        public void get(final com.google.gwt.user.client.rpc.AsyncCallback<? super org.ednovo.gooru.client.mvp.folders.FoldersPresenter> callback) { 
          com.google.gwt.core.client.GWT.runAsync(org.ednovo.gooru.client.mvp.folders.FoldersPresenter.class,new com.google.gwt.core.client.RunAsyncCallback() { 
            public void onSuccess() { 
              callback.onSuccess(get_Key$type$org$ednovo$gooru$client$mvp$folders$FoldersPresenter$_annotation$$none$$());
            }
            public void onFailure(Throwable ex) { 
               callback.onFailure(ex); 
            } 
        }); 
        }
     };
    
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.folders.FoldersView singleton_Key$type$org$ednovo$gooru$client$mvp$folders$FoldersView$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.folders.FoldersView get_Key$type$org$ednovo$gooru$client$mvp$folders$FoldersView$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$folders$FoldersView$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.mvp.folders.FoldersView result = org$ednovo$gooru$client$mvp$folders$FoldersView_org$ednovo$gooru$client$mvp$folders$FoldersView_methodInjection();
    memberInject_Key$type$org$ednovo$gooru$client$mvp$folders$FoldersView$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$folders$FoldersView$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$folders$FoldersView$_annotation$$none$$;
    
  }
  
  public org.ednovo.gooru.client.mvp.folders.FoldersView org$ednovo$gooru$client$mvp$folders$FoldersView_org$ednovo$gooru$client$mvp$folders$FoldersView_methodInjection() {
    return new org.ednovo.gooru.client.mvp.folders.FoldersView();
  }
  
  
  /**
   * Field for the enclosing injector.
   */
  private final org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector;
  public org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment(org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector) {
    this.injector = injector;
  }
  
  public void initializeEagerSingletons() {
    // Eager singleton bound at:
    //   Implicit GWT.create binding for org.ednovo.gooru.client.mvp.folders.FoldersPresenter$IsFoldersProxy
    get_Key$type$org$ednovo$gooru$client$mvp$folders$FoldersPresenter$IsFoldersProxy$_annotation$$none$$();
    
  }
  
}
