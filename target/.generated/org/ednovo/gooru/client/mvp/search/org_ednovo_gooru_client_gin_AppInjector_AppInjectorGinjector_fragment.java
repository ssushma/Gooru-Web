package org.ednovo.gooru.client.mvp.search;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public native void org$ednovo$gooru$client$mvp$search$AbstractSearchPresenter_searchService_fieldInjection(org.ednovo.gooru.client.mvp.search.AbstractSearchPresenter injectee, org.ednovo.gooru.client.service.SearchServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.search.AbstractSearchPresenter::searchService = value;
  }-*/;
  
  public native void org$ednovo$gooru$client$mvp$search$AbstractSearchPresenter_searchService_fieldInjection_(org.ednovo.gooru.client.mvp.search.AbstractSearchPresenter injectee, org.ednovo.gooru.client.service.SearchServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.search.AbstractSearchPresenter::searchService = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$search$SearchRootPresenter$IsSearchRootProxy$_annotation$$none$$(org.ednovo.gooru.client.mvp.search.SearchRootPresenter.IsSearchRootProxy injectee) {
    
  }
  
  public native void org$ednovo$gooru$client$mvp$search$SearchRootPresenter_searchService_fieldInjection(org.ednovo.gooru.client.mvp.search.SearchRootPresenter injectee, org.ednovo.gooru.client.service.SearchServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.search.SearchRootPresenter::searchService = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$search$SearchRootPresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.search.SearchRootPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection_____________________________________________________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$search$SearchRootPresenter_searchService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$SearchServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$search$SearchRootView$_annotation$$none$$(org.ednovo.gooru.client.mvp.search.SearchRootView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.search.IsSearchRootView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:126)
   */
  public org.ednovo.gooru.client.mvp.search.IsSearchRootView get_Key$type$org$ednovo$gooru$client$mvp$search$IsSearchRootView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.search.IsSearchRootView result = get_Key$type$org$ednovo$gooru$client$mvp$search$SearchRootView$_annotation$$none$$();
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.search.SearchRootPresenter.IsSearchRootProxy singleton_Key$type$org$ednovo$gooru$client$mvp$search$SearchRootPresenter$IsSearchRootProxy$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.search.SearchRootPresenter.IsSearchRootProxy get_Key$type$org$ednovo$gooru$client$mvp$search$SearchRootPresenter$IsSearchRootProxy$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$search$SearchRootPresenter$IsSearchRootProxy$_annotation$$none$$ == null) {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.search.SearchRootPresenter.IsSearchRootProxy.class);
    assert created instanceof org.ednovo.gooru.client.mvp.search.SearchRootPresenter.IsSearchRootProxy;
    org.ednovo.gooru.client.mvp.search.SearchRootPresenter.IsSearchRootProxy result = (org.ednovo.gooru.client.mvp.search.SearchRootPresenter.IsSearchRootProxy) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$search$SearchRootPresenter$IsSearchRootProxy$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$search$SearchRootPresenter$IsSearchRootProxy$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$search$SearchRootPresenter$IsSearchRootProxy$_annotation$$none$$;
    
  }
  
  private org.ednovo.gooru.client.mvp.search.SearchRootPresenter singleton_Key$type$org$ednovo$gooru$client$mvp$search$SearchRootPresenter$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.search.SearchRootPresenter get_Key$type$org$ednovo$gooru$client$mvp$search$SearchRootPresenter$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$search$SearchRootPresenter$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.mvp.search.SearchRootPresenter result = org$ednovo$gooru$client$mvp$search$SearchRootPresenter_org$ednovo$gooru$client$mvp$search$SearchRootPresenter_methodInjection(injector.getFragment_org_ednovo_gooru_client_mvp_shelf_list().get_Key$type$org$ednovo$gooru$client$mvp$shelf$list$ShelfListPresenter$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$search$IsSearchRootView$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$search$SearchRootPresenter$IsSearchRootProxy$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_search_resource().get_Key$type$org$ednovo$gooru$client$mvp$search$resource$ResourceSearchPresenter$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_search_collection().get_Key$type$org$ednovo$gooru$client$mvp$search$collection$CollectionSearchPresenter$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$search$SearchRootPresenter$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$search$SearchRootPresenter$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$search$SearchRootPresenter$_annotation$$none$$;
    
  }
  
  public org.ednovo.gooru.client.mvp.search.SearchRootPresenter org$ednovo$gooru$client$mvp$search$SearchRootPresenter_org$ednovo$gooru$client$mvp$search$SearchRootPresenter_methodInjection(org.ednovo.gooru.client.mvp.shelf.list.ShelfListPresenter _0, org.ednovo.gooru.client.mvp.search.IsSearchRootView _1, org.ednovo.gooru.client.mvp.search.SearchRootPresenter.IsSearchRootProxy _2, org.ednovo.gooru.client.mvp.search.resource.ResourceSearchPresenter _3, org.ednovo.gooru.client.mvp.search.collection.CollectionSearchPresenter _4) {
    return new org.ednovo.gooru.client.mvp.search.SearchRootPresenter(_0, _1, _2, _3, _4);
  }
  
  
  /**
   * Binding for com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.search.SearchRootPresenter> declared at:
   *   Implicit injection of com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.search.SearchRootPresenter>
   */
  public com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.search.SearchRootPresenter> get_Key$type$com$google$gwt$inject$client$AsyncProvider$org$ednovo$gooru$client$mvp$search$SearchRootPresenter$$_annotation$$none$$() {
    com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.search.SearchRootPresenter> result = new com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.search.SearchRootPresenter>() { 
        public void get(final com.google.gwt.user.client.rpc.AsyncCallback<? super org.ednovo.gooru.client.mvp.search.SearchRootPresenter> callback) { 
          com.google.gwt.core.client.GWT.runAsync(org.ednovo.gooru.client.mvp.search.SearchRootPresenter.class,new com.google.gwt.core.client.RunAsyncCallback() { 
            public void onSuccess() { 
              callback.onSuccess(get_Key$type$org$ednovo$gooru$client$mvp$search$SearchRootPresenter$_annotation$$none$$());
            }
            public void onFailure(Throwable ex) { 
               callback.onFailure(ex); 
            } 
        }); 
        }
     };
    
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.search.SearchRootView singleton_Key$type$org$ednovo$gooru$client$mvp$search$SearchRootView$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.search.SearchRootView get_Key$type$org$ednovo$gooru$client$mvp$search$SearchRootView$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$search$SearchRootView$_annotation$$none$$ == null) {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.search.SearchRootView.class);
    assert created instanceof org.ednovo.gooru.client.mvp.search.SearchRootView;
    org.ednovo.gooru.client.mvp.search.SearchRootView result = (org.ednovo.gooru.client.mvp.search.SearchRootView) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$search$SearchRootView$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$search$SearchRootView$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$search$SearchRootView$_annotation$$none$$;
    
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
    //   Implicit GWT.create binding for org.ednovo.gooru.client.mvp.search.SearchRootPresenter$IsSearchRootProxy
    get_Key$type$org$ednovo$gooru$client$mvp$search$SearchRootPresenter$IsSearchRootProxy$_annotation$$none$$();
    
  }
  
}
