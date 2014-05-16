package org.ednovo.gooru.client.mvp.shelf.list;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public native void org$ednovo$gooru$client$mvp$shelf$list$ShelfListPresenter_folderService_fieldInjection(org.ednovo.gooru.client.mvp.shelf.list.ShelfListPresenter injectee, org.ednovo.gooru.client.service.FolderServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.shelf.list.ShelfListPresenter::folderService = value;
  }-*/;
  
  public native void org$ednovo$gooru$client$mvp$shelf$list$ShelfListPresenter_resourceService_fieldInjection(org.ednovo.gooru.client.mvp.shelf.list.ShelfListPresenter injectee, org.ednovo.gooru.client.service.ResourceServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.shelf.list.ShelfListPresenter::resourceService = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$list$ShelfListPresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.shelf.list.ShelfListPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection__________________________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$shelf$list$ShelfListPresenter_folderService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$FolderServiceAsync$_annotation$$none$$());
    
    org$ednovo$gooru$client$mvp$shelf$list$ShelfListPresenter_resourceService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$ResourceServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void org$ednovo$gooru$client$mvp$shelf$list$ShelfListView_shelfView_fieldInjection(org.ednovo.gooru.client.mvp.shelf.list.ShelfListView injectee, org.ednovo.gooru.client.mvp.shelf.ShelfView value) {
    injectee.shelfView = value;
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$list$ShelfListView$_annotation$$none$$(org.ednovo.gooru.client.mvp.shelf.list.ShelfListView injectee) {
    org$ednovo$gooru$client$mvp$shelf$list$ShelfListView_shelfView_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_mvp_shelf().get_Key$type$org$ednovo$gooru$client$mvp$shelf$ShelfView$_annotation$$none$$());
    
    
  }
  
  private org.ednovo.gooru.client.mvp.shelf.list.IsShelfListView singleton_Key$type$org$ednovo$gooru$client$mvp$shelf$list$IsShelfListView$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.shelf.list.IsShelfListView get_Key$type$org$ednovo$gooru$client$mvp$shelf$list$IsShelfListView$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$shelf$list$IsShelfListView$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.mvp.shelf.list.IsShelfListView result = get_Key$type$org$ednovo$gooru$client$mvp$shelf$list$ShelfListView$_annotation$$none$$();
        singleton_Key$type$org$ednovo$gooru$client$mvp$shelf$list$IsShelfListView$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$shelf$list$IsShelfListView$_annotation$$none$$;
    
  }
  
  private org.ednovo.gooru.client.mvp.shelf.list.ShelfListPresenter singleton_Key$type$org$ednovo$gooru$client$mvp$shelf$list$ShelfListPresenter$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.shelf.list.ShelfListPresenter get_Key$type$org$ednovo$gooru$client$mvp$shelf$list$ShelfListPresenter$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$shelf$list$ShelfListPresenter$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.mvp.shelf.list.ShelfListPresenter result = org$ednovo$gooru$client$mvp$shelf$list$ShelfListPresenter_org$ednovo$gooru$client$mvp$shelf$list$ShelfListPresenter_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$shelf$list$IsShelfListView$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$list$ShelfListPresenter$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$shelf$list$ShelfListPresenter$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$shelf$list$ShelfListPresenter$_annotation$$none$$;
    
  }
  
  public org.ednovo.gooru.client.mvp.shelf.list.ShelfListPresenter org$ednovo$gooru$client$mvp$shelf$list$ShelfListPresenter_org$ednovo$gooru$client$mvp$shelf$list$ShelfListPresenter_methodInjection(com.google.gwt.event.shared.EventBus _0, org.ednovo.gooru.client.mvp.shelf.list.IsShelfListView _1) {
    return new org.ednovo.gooru.client.mvp.shelf.list.ShelfListPresenter(_0, _1);
  }
  
  
  /**
   * Binding for com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.list.ShelfListPresenter> declared at:
   *   Implicit injection of com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.list.ShelfListPresenter>
   */
  public com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.list.ShelfListPresenter> get_Key$type$com$google$gwt$inject$client$AsyncProvider$org$ednovo$gooru$client$mvp$shelf$list$ShelfListPresenter$$_annotation$$none$$() {
    com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.list.ShelfListPresenter> result = new com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.list.ShelfListPresenter>() { 
        public void get(final com.google.gwt.user.client.rpc.AsyncCallback<? super org.ednovo.gooru.client.mvp.shelf.list.ShelfListPresenter> callback) { 
          com.google.gwt.core.client.GWT.runAsync(org.ednovo.gooru.client.mvp.shelf.list.ShelfListPresenter.class,new com.google.gwt.core.client.RunAsyncCallback() { 
            public void onSuccess() { 
              callback.onSuccess(get_Key$type$org$ednovo$gooru$client$mvp$shelf$list$ShelfListPresenter$_annotation$$none$$());
            }
            public void onFailure(Throwable ex) { 
               callback.onFailure(ex); 
            } 
        }); 
        }
     };
    
    return result;
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.shelf.list.ShelfListView declared at:
   *   Implicit GWT.create binding for org.ednovo.gooru.client.mvp.shelf.list.ShelfListView
   */
  public org.ednovo.gooru.client.mvp.shelf.list.ShelfListView get_Key$type$org$ednovo$gooru$client$mvp$shelf$list$ShelfListView$_annotation$$none$$() {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.shelf.list.ShelfListView.class);
    assert created instanceof org.ednovo.gooru.client.mvp.shelf.list.ShelfListView;
    org.ednovo.gooru.client.mvp.shelf.list.ShelfListView result = (org.ednovo.gooru.client.mvp.shelf.list.ShelfListView) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$list$ShelfListView$_annotation$$none$$(result);
    
    return result;
    
  }
  
  
  /**
   * Field for the enclosing injector.
   */
  private final org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector;
  public org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment(org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector) {
    this.injector = injector;
  }
  
}
