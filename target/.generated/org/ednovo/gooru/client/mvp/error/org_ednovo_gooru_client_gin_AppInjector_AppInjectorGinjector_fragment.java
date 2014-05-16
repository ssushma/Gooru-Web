package org.ednovo.gooru.client.mvp.error;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$error$ErrorPresenter$IsErrorProxy$_annotation$$none$$(org.ednovo.gooru.client.mvp.error.ErrorPresenter.IsErrorProxy injectee) {
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$error$ErrorPresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.error.ErrorPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection______________________________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$error$ErrorView$_annotation$$none$$(org.ednovo.gooru.client.mvp.error.ErrorView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.error.IsErrorView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:126)
   */
  public org.ednovo.gooru.client.mvp.error.IsErrorView get_Key$type$org$ednovo$gooru$client$mvp$error$IsErrorView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.error.IsErrorView result = get_Key$type$org$ednovo$gooru$client$mvp$error$ErrorView$_annotation$$none$$();
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.error.ErrorPresenter.IsErrorProxy singleton_Key$type$org$ednovo$gooru$client$mvp$error$ErrorPresenter$IsErrorProxy$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.error.ErrorPresenter.IsErrorProxy get_Key$type$org$ednovo$gooru$client$mvp$error$ErrorPresenter$IsErrorProxy$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$error$ErrorPresenter$IsErrorProxy$_annotation$$none$$ == null) {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.error.ErrorPresenter.IsErrorProxy.class);
    assert created instanceof org.ednovo.gooru.client.mvp.error.ErrorPresenter.IsErrorProxy;
    org.ednovo.gooru.client.mvp.error.ErrorPresenter.IsErrorProxy result = (org.ednovo.gooru.client.mvp.error.ErrorPresenter.IsErrorProxy) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$error$ErrorPresenter$IsErrorProxy$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$error$ErrorPresenter$IsErrorProxy$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$error$ErrorPresenter$IsErrorProxy$_annotation$$none$$;
    
  }
  
  private org.ednovo.gooru.client.mvp.error.ErrorPresenter singleton_Key$type$org$ednovo$gooru$client$mvp$error$ErrorPresenter$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.error.ErrorPresenter get_Key$type$org$ednovo$gooru$client$mvp$error$ErrorPresenter$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$error$ErrorPresenter$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.mvp.error.ErrorPresenter result = org$ednovo$gooru$client$mvp$error$ErrorPresenter_org$ednovo$gooru$client$mvp$error$ErrorPresenter_methodInjection(get_Key$type$org$ednovo$gooru$client$mvp$error$IsErrorView$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$error$ErrorPresenter$IsErrorProxy$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$error$ErrorPresenter$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$error$ErrorPresenter$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$error$ErrorPresenter$_annotation$$none$$;
    
  }
  
  public org.ednovo.gooru.client.mvp.error.ErrorPresenter org$ednovo$gooru$client$mvp$error$ErrorPresenter_org$ednovo$gooru$client$mvp$error$ErrorPresenter_methodInjection(org.ednovo.gooru.client.mvp.error.IsErrorView _0, org.ednovo.gooru.client.mvp.error.ErrorPresenter.IsErrorProxy _1) {
    return new org.ednovo.gooru.client.mvp.error.ErrorPresenter(_0, _1);
  }
  
  
  /**
   * Binding for com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.error.ErrorPresenter> declared at:
   *   Implicit injection of com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.error.ErrorPresenter>
   */
  public com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.error.ErrorPresenter> get_Key$type$com$google$gwt$inject$client$AsyncProvider$org$ednovo$gooru$client$mvp$error$ErrorPresenter$$_annotation$$none$$() {
    com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.error.ErrorPresenter> result = new com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.error.ErrorPresenter>() { 
        public void get(final com.google.gwt.user.client.rpc.AsyncCallback<? super org.ednovo.gooru.client.mvp.error.ErrorPresenter> callback) { 
          com.google.gwt.core.client.GWT.runAsync(org.ednovo.gooru.client.mvp.error.ErrorPresenter.class,new com.google.gwt.core.client.RunAsyncCallback() { 
            public void onSuccess() { 
              callback.onSuccess(get_Key$type$org$ednovo$gooru$client$mvp$error$ErrorPresenter$_annotation$$none$$());
            }
            public void onFailure(Throwable ex) { 
               callback.onFailure(ex); 
            } 
        }); 
        }
     };
    
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.error.ErrorView singleton_Key$type$org$ednovo$gooru$client$mvp$error$ErrorView$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.error.ErrorView get_Key$type$org$ednovo$gooru$client$mvp$error$ErrorView$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$error$ErrorView$_annotation$$none$$ == null) {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.error.ErrorView.class);
    assert created instanceof org.ednovo.gooru.client.mvp.error.ErrorView;
    org.ednovo.gooru.client.mvp.error.ErrorView result = (org.ednovo.gooru.client.mvp.error.ErrorView) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$error$ErrorView$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$error$ErrorView$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$error$ErrorView$_annotation$$none$$;
    
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
    //   Implicit GWT.create binding for org.ednovo.gooru.client.mvp.error.ErrorPresenter$IsErrorProxy
    get_Key$type$org$ednovo$gooru$client$mvp$error$ErrorPresenter$IsErrorProxy$_annotation$$none$$();
    
  }
  
}
