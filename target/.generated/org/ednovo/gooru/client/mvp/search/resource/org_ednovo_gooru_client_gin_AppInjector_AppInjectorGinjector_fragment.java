package org.ednovo.gooru.client.mvp.search.resource;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$search$resource$ResourceSearchPresenter$IsResourceSearchProxy$_annotation$$none$$(org.ednovo.gooru.client.mvp.search.resource.ResourceSearchPresenter.IsResourceSearchProxy injectee) {
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$search$resource$ResourceSearchPresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.search.resource.ResourceSearchPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection___________________________________________________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    injector.getFragment_org_ednovo_gooru_client_mvp_search().org$ednovo$gooru$client$mvp$search$AbstractSearchPresenter_searchService_fieldInjection_(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$SearchServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$search$resource$ResourceSearchView$_annotation$$none$$(org.ednovo.gooru.client.mvp.search.resource.ResourceSearchView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.search.resource.IsResourceSearchView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:126)
   */
  public org.ednovo.gooru.client.mvp.search.resource.IsResourceSearchView get_Key$type$org$ednovo$gooru$client$mvp$search$resource$IsResourceSearchView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.search.resource.IsResourceSearchView result = get_Key$type$org$ednovo$gooru$client$mvp$search$resource$ResourceSearchView$_annotation$$none$$();
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.search.resource.ResourceSearchPresenter.IsResourceSearchProxy singleton_Key$type$org$ednovo$gooru$client$mvp$search$resource$ResourceSearchPresenter$IsResourceSearchProxy$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.search.resource.ResourceSearchPresenter.IsResourceSearchProxy get_Key$type$org$ednovo$gooru$client$mvp$search$resource$ResourceSearchPresenter$IsResourceSearchProxy$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$search$resource$ResourceSearchPresenter$IsResourceSearchProxy$_annotation$$none$$ == null) {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.search.resource.ResourceSearchPresenter.IsResourceSearchProxy.class);
    assert created instanceof org.ednovo.gooru.client.mvp.search.resource.ResourceSearchPresenter.IsResourceSearchProxy;
    org.ednovo.gooru.client.mvp.search.resource.ResourceSearchPresenter.IsResourceSearchProxy result = (org.ednovo.gooru.client.mvp.search.resource.ResourceSearchPresenter.IsResourceSearchProxy) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$search$resource$ResourceSearchPresenter$IsResourceSearchProxy$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$search$resource$ResourceSearchPresenter$IsResourceSearchProxy$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$search$resource$ResourceSearchPresenter$IsResourceSearchProxy$_annotation$$none$$;
    
  }
  
  private org.ednovo.gooru.client.mvp.search.resource.ResourceSearchPresenter singleton_Key$type$org$ednovo$gooru$client$mvp$search$resource$ResourceSearchPresenter$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.search.resource.ResourceSearchPresenter get_Key$type$org$ednovo$gooru$client$mvp$search$resource$ResourceSearchPresenter$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$search$resource$ResourceSearchPresenter$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.mvp.search.resource.ResourceSearchPresenter result = org$ednovo$gooru$client$mvp$search$resource$ResourceSearchPresenter_org$ednovo$gooru$client$mvp$search$resource$ResourceSearchPresenter_methodInjection(get_Key$type$org$ednovo$gooru$client$mvp$search$resource$IsResourceSearchView$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$search$resource$ResourceSearchPresenter$IsResourceSearchProxy$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_authentication().get_Key$type$org$ednovo$gooru$client$mvp$authentication$SignUpPresenter$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$search$resource$ResourceSearchPresenter$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$search$resource$ResourceSearchPresenter$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$search$resource$ResourceSearchPresenter$_annotation$$none$$;
    
  }
  
  public org.ednovo.gooru.client.mvp.search.resource.ResourceSearchPresenter org$ednovo$gooru$client$mvp$search$resource$ResourceSearchPresenter_org$ednovo$gooru$client$mvp$search$resource$ResourceSearchPresenter_methodInjection(org.ednovo.gooru.client.mvp.search.resource.IsResourceSearchView _0, org.ednovo.gooru.client.mvp.search.resource.ResourceSearchPresenter.IsResourceSearchProxy _1, org.ednovo.gooru.client.mvp.authentication.SignUpPresenter _2) {
    return new org.ednovo.gooru.client.mvp.search.resource.ResourceSearchPresenter(_0, _1, _2);
  }
  
  
  /**
   * Binding for com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.search.resource.ResourceSearchPresenter> declared at:
   *   Implicit injection of com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.search.resource.ResourceSearchPresenter>
   */
  public com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.search.resource.ResourceSearchPresenter> get_Key$type$com$google$gwt$inject$client$AsyncProvider$org$ednovo$gooru$client$mvp$search$resource$ResourceSearchPresenter$$_annotation$$none$$() {
    com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.search.resource.ResourceSearchPresenter> result = new com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.search.resource.ResourceSearchPresenter>() { 
        public void get(final com.google.gwt.user.client.rpc.AsyncCallback<? super org.ednovo.gooru.client.mvp.search.resource.ResourceSearchPresenter> callback) { 
          com.google.gwt.core.client.GWT.runAsync(org.ednovo.gooru.client.mvp.search.resource.ResourceSearchPresenter.class,new com.google.gwt.core.client.RunAsyncCallback() { 
            public void onSuccess() { 
              callback.onSuccess(get_Key$type$org$ednovo$gooru$client$mvp$search$resource$ResourceSearchPresenter$_annotation$$none$$());
            }
            public void onFailure(Throwable ex) { 
               callback.onFailure(ex); 
            } 
        }); 
        }
     };
    
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.search.resource.ResourceSearchView singleton_Key$type$org$ednovo$gooru$client$mvp$search$resource$ResourceSearchView$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.search.resource.ResourceSearchView get_Key$type$org$ednovo$gooru$client$mvp$search$resource$ResourceSearchView$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$search$resource$ResourceSearchView$_annotation$$none$$ == null) {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.search.resource.ResourceSearchView.class);
    assert created instanceof org.ednovo.gooru.client.mvp.search.resource.ResourceSearchView;
    org.ednovo.gooru.client.mvp.search.resource.ResourceSearchView result = (org.ednovo.gooru.client.mvp.search.resource.ResourceSearchView) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$search$resource$ResourceSearchView$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$search$resource$ResourceSearchView$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$search$resource$ResourceSearchView$_annotation$$none$$;
    
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
    //   Implicit GWT.create binding for org.ednovo.gooru.client.mvp.search.resource.ResourceSearchPresenter$IsResourceSearchProxy
    get_Key$type$org$ednovo$gooru$client$mvp$search$resource$ResourceSearchPresenter$IsResourceSearchProxy$_annotation$$none$$();
    
  }
  
}
