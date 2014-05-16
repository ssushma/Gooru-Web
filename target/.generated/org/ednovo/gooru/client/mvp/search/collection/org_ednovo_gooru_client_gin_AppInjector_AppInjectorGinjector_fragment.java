package org.ednovo.gooru.client.mvp.search.collection;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$search$collection$CollectionSearchPresenter$IsCollectionSearchProxy$_annotation$$none$$(org.ednovo.gooru.client.mvp.search.collection.CollectionSearchPresenter.IsCollectionSearchProxy injectee) {
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$search$collection$CollectionSearchPresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.search.collection.CollectionSearchPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection_____________________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    injector.getFragment_org_ednovo_gooru_client_mvp_search().org$ednovo$gooru$client$mvp$search$AbstractSearchPresenter_searchService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$SearchServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$search$collection$CollectionSearchView$_annotation$$none$$(org.ednovo.gooru.client.mvp.search.collection.CollectionSearchView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.search.collection.IsCollectionSearchView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:126)
   */
  public org.ednovo.gooru.client.mvp.search.collection.IsCollectionSearchView get_Key$type$org$ednovo$gooru$client$mvp$search$collection$IsCollectionSearchView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.search.collection.IsCollectionSearchView result = get_Key$type$org$ednovo$gooru$client$mvp$search$collection$CollectionSearchView$_annotation$$none$$();
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.search.collection.CollectionSearchPresenter.IsCollectionSearchProxy singleton_Key$type$org$ednovo$gooru$client$mvp$search$collection$CollectionSearchPresenter$IsCollectionSearchProxy$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.search.collection.CollectionSearchPresenter.IsCollectionSearchProxy get_Key$type$org$ednovo$gooru$client$mvp$search$collection$CollectionSearchPresenter$IsCollectionSearchProxy$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$search$collection$CollectionSearchPresenter$IsCollectionSearchProxy$_annotation$$none$$ == null) {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.search.collection.CollectionSearchPresenter.IsCollectionSearchProxy.class);
    assert created instanceof org.ednovo.gooru.client.mvp.search.collection.CollectionSearchPresenter.IsCollectionSearchProxy;
    org.ednovo.gooru.client.mvp.search.collection.CollectionSearchPresenter.IsCollectionSearchProxy result = (org.ednovo.gooru.client.mvp.search.collection.CollectionSearchPresenter.IsCollectionSearchProxy) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$search$collection$CollectionSearchPresenter$IsCollectionSearchProxy$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$search$collection$CollectionSearchPresenter$IsCollectionSearchProxy$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$search$collection$CollectionSearchPresenter$IsCollectionSearchProxy$_annotation$$none$$;
    
  }
  
  private org.ednovo.gooru.client.mvp.search.collection.CollectionSearchPresenter singleton_Key$type$org$ednovo$gooru$client$mvp$search$collection$CollectionSearchPresenter$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.search.collection.CollectionSearchPresenter get_Key$type$org$ednovo$gooru$client$mvp$search$collection$CollectionSearchPresenter$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$search$collection$CollectionSearchPresenter$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.mvp.search.collection.CollectionSearchPresenter result = org$ednovo$gooru$client$mvp$search$collection$CollectionSearchPresenter_org$ednovo$gooru$client$mvp$search$collection$CollectionSearchPresenter_methodInjection(get_Key$type$org$ednovo$gooru$client$mvp$search$collection$IsCollectionSearchView$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$search$collection$CollectionSearchPresenter$IsCollectionSearchProxy$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_authentication().get_Key$type$org$ednovo$gooru$client$mvp$authentication$SignUpPresenter$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$search$collection$CollectionSearchPresenter$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$search$collection$CollectionSearchPresenter$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$search$collection$CollectionSearchPresenter$_annotation$$none$$;
    
  }
  
  public org.ednovo.gooru.client.mvp.search.collection.CollectionSearchPresenter org$ednovo$gooru$client$mvp$search$collection$CollectionSearchPresenter_org$ednovo$gooru$client$mvp$search$collection$CollectionSearchPresenter_methodInjection(org.ednovo.gooru.client.mvp.search.collection.IsCollectionSearchView _0, org.ednovo.gooru.client.mvp.search.collection.CollectionSearchPresenter.IsCollectionSearchProxy _1, org.ednovo.gooru.client.mvp.authentication.SignUpPresenter _2) {
    return new org.ednovo.gooru.client.mvp.search.collection.CollectionSearchPresenter(_0, _1, _2);
  }
  
  
  /**
   * Binding for com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.search.collection.CollectionSearchPresenter> declared at:
   *   Implicit injection of com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.search.collection.CollectionSearchPresenter>
   */
  public com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.search.collection.CollectionSearchPresenter> get_Key$type$com$google$gwt$inject$client$AsyncProvider$org$ednovo$gooru$client$mvp$search$collection$CollectionSearchPresenter$$_annotation$$none$$() {
    com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.search.collection.CollectionSearchPresenter> result = new com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.search.collection.CollectionSearchPresenter>() { 
        public void get(final com.google.gwt.user.client.rpc.AsyncCallback<? super org.ednovo.gooru.client.mvp.search.collection.CollectionSearchPresenter> callback) { 
          com.google.gwt.core.client.GWT.runAsync(org.ednovo.gooru.client.mvp.search.collection.CollectionSearchPresenter.class,new com.google.gwt.core.client.RunAsyncCallback() { 
            public void onSuccess() { 
              callback.onSuccess(get_Key$type$org$ednovo$gooru$client$mvp$search$collection$CollectionSearchPresenter$_annotation$$none$$());
            }
            public void onFailure(Throwable ex) { 
               callback.onFailure(ex); 
            } 
        }); 
        }
     };
    
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.search.collection.CollectionSearchView singleton_Key$type$org$ednovo$gooru$client$mvp$search$collection$CollectionSearchView$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.search.collection.CollectionSearchView get_Key$type$org$ednovo$gooru$client$mvp$search$collection$CollectionSearchView$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$search$collection$CollectionSearchView$_annotation$$none$$ == null) {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.search.collection.CollectionSearchView.class);
    assert created instanceof org.ednovo.gooru.client.mvp.search.collection.CollectionSearchView;
    org.ednovo.gooru.client.mvp.search.collection.CollectionSearchView result = (org.ednovo.gooru.client.mvp.search.collection.CollectionSearchView) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$search$collection$CollectionSearchView$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$search$collection$CollectionSearchView$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$search$collection$CollectionSearchView$_annotation$$none$$;
    
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
    //   Implicit GWT.create binding for org.ednovo.gooru.client.mvp.search.collection.CollectionSearchPresenter$IsCollectionSearchProxy
    get_Key$type$org$ednovo$gooru$client$mvp$search$collection$CollectionSearchPresenter$IsCollectionSearchProxy$_annotation$$none$$();
    
  }
  
}
