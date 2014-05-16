package org.ednovo.gooru.client.mvp.prime;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$prime$PrimePresenter$IsPrimeProxy$_annotation$$none$$(org.ednovo.gooru.client.mvp.prime.PrimePresenter.IsPrimeProxy injectee) {
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$prime$PrimePresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.prime.PrimePresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection____________________________________________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$prime$PrimeView$_annotation$$none$$(org.ednovo.gooru.client.mvp.prime.PrimeView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.prime.IsPrimeView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:126)
   */
  public org.ednovo.gooru.client.mvp.prime.IsPrimeView get_Key$type$org$ednovo$gooru$client$mvp$prime$IsPrimeView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.prime.IsPrimeView result = get_Key$type$org$ednovo$gooru$client$mvp$prime$PrimeView$_annotation$$none$$();
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.prime.PrimePresenter.IsPrimeProxy singleton_Key$type$org$ednovo$gooru$client$mvp$prime$PrimePresenter$IsPrimeProxy$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.prime.PrimePresenter.IsPrimeProxy get_Key$type$org$ednovo$gooru$client$mvp$prime$PrimePresenter$IsPrimeProxy$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$prime$PrimePresenter$IsPrimeProxy$_annotation$$none$$ == null) {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.prime.PrimePresenter.IsPrimeProxy.class);
    assert created instanceof org.ednovo.gooru.client.mvp.prime.PrimePresenter.IsPrimeProxy;
    org.ednovo.gooru.client.mvp.prime.PrimePresenter.IsPrimeProxy result = (org.ednovo.gooru.client.mvp.prime.PrimePresenter.IsPrimeProxy) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$prime$PrimePresenter$IsPrimeProxy$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$prime$PrimePresenter$IsPrimeProxy$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$prime$PrimePresenter$IsPrimeProxy$_annotation$$none$$;
    
  }
  
  private org.ednovo.gooru.client.mvp.prime.PrimePresenter singleton_Key$type$org$ednovo$gooru$client$mvp$prime$PrimePresenter$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.prime.PrimePresenter get_Key$type$org$ednovo$gooru$client$mvp$prime$PrimePresenter$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$prime$PrimePresenter$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.mvp.prime.PrimePresenter result = org$ednovo$gooru$client$mvp$prime$PrimePresenter_org$ednovo$gooru$client$mvp$prime$PrimePresenter_methodInjection(get_Key$type$org$ednovo$gooru$client$mvp$prime$IsPrimeView$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$prime$PrimePresenter$IsPrimeProxy$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$prime$PrimePresenter$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$prime$PrimePresenter$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$prime$PrimePresenter$_annotation$$none$$;
    
  }
  
  public org.ednovo.gooru.client.mvp.prime.PrimePresenter org$ednovo$gooru$client$mvp$prime$PrimePresenter_org$ednovo$gooru$client$mvp$prime$PrimePresenter_methodInjection(org.ednovo.gooru.client.mvp.prime.IsPrimeView _0, org.ednovo.gooru.client.mvp.prime.PrimePresenter.IsPrimeProxy _1) {
    return new org.ednovo.gooru.client.mvp.prime.PrimePresenter(_0, _1);
  }
  
  
  /**
   * Binding for com.google.inject.Provider<org.ednovo.gooru.client.mvp.prime.PrimePresenter> declared at:
   *   Implicit provider for com.google.inject.Provider<org.ednovo.gooru.client.mvp.prime.PrimePresenter>
   */
  public com.google.inject.Provider<org.ednovo.gooru.client.mvp.prime.PrimePresenter> get_Key$type$com$google$inject$Provider$org$ednovo$gooru$client$mvp$prime$PrimePresenter$$_annotation$$none$$() {
    com.google.inject.Provider<org.ednovo.gooru.client.mvp.prime.PrimePresenter> result = new com.google.inject.Provider<org.ednovo.gooru.client.mvp.prime.PrimePresenter>() { 
      public org.ednovo.gooru.client.mvp.prime.PrimePresenter get() { 
        return get_Key$type$org$ednovo$gooru$client$mvp$prime$PrimePresenter$_annotation$$none$$();
      }
    };
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.prime.PrimeView singleton_Key$type$org$ednovo$gooru$client$mvp$prime$PrimeView$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.prime.PrimeView get_Key$type$org$ednovo$gooru$client$mvp$prime$PrimeView$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$prime$PrimeView$_annotation$$none$$ == null) {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.prime.PrimeView.class);
    assert created instanceof org.ednovo.gooru.client.mvp.prime.PrimeView;
    org.ednovo.gooru.client.mvp.prime.PrimeView result = (org.ednovo.gooru.client.mvp.prime.PrimeView) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$prime$PrimeView$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$prime$PrimeView$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$prime$PrimeView$_annotation$$none$$;
    
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
    //   Implicit GWT.create binding for org.ednovo.gooru.client.mvp.prime.PrimePresenter$IsPrimeProxy
    get_Key$type$org$ednovo$gooru$client$mvp$prime$PrimePresenter$IsPrimeProxy$_annotation$$none$$();
    
  }
  
}
