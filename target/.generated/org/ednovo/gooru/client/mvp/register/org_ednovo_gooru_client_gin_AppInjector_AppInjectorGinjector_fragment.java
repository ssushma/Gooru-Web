package org.ednovo.gooru.client.mvp.register;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$register$RegisterPresenter$IsRegisterProxy$_annotation$$none$$(org.ednovo.gooru.client.mvp.register.RegisterPresenter.IsRegisterProxy injectee) {
    
  }
  
  public void org$ednovo$gooru$client$mvp$register$RegisterPresenter_placeManager_fieldInjection(org.ednovo.gooru.client.mvp.register.RegisterPresenter injectee, com.gwtplatform.mvp.client.proxy.PlaceManager value) {
    injectee.placeManager = value;
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$register$RegisterPresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.register.RegisterPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection_______________________________________________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$register$RegisterPresenter_placeManager_fieldInjection(injectee, injector.getFragment_com_gwtplatform_mvp_client_proxy().get_Key$type$com$gwtplatform$mvp$client$proxy$PlaceManager$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$register$RegisterView$_annotation$$none$$(org.ednovo.gooru.client.mvp.register.RegisterView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.register.IsRegisterView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:126)
   */
  public org.ednovo.gooru.client.mvp.register.IsRegisterView get_Key$type$org$ednovo$gooru$client$mvp$register$IsRegisterView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.register.IsRegisterView result = get_Key$type$org$ednovo$gooru$client$mvp$register$RegisterView$_annotation$$none$$();
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.register.RegisterPresenter.IsRegisterProxy singleton_Key$type$org$ednovo$gooru$client$mvp$register$RegisterPresenter$IsRegisterProxy$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.register.RegisterPresenter.IsRegisterProxy get_Key$type$org$ednovo$gooru$client$mvp$register$RegisterPresenter$IsRegisterProxy$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$register$RegisterPresenter$IsRegisterProxy$_annotation$$none$$ == null) {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.register.RegisterPresenter.IsRegisterProxy.class);
    assert created instanceof org.ednovo.gooru.client.mvp.register.RegisterPresenter.IsRegisterProxy;
    org.ednovo.gooru.client.mvp.register.RegisterPresenter.IsRegisterProxy result = (org.ednovo.gooru.client.mvp.register.RegisterPresenter.IsRegisterProxy) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$register$RegisterPresenter$IsRegisterProxy$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$register$RegisterPresenter$IsRegisterProxy$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$register$RegisterPresenter$IsRegisterProxy$_annotation$$none$$;
    
  }
  
  private org.ednovo.gooru.client.mvp.register.RegisterPresenter singleton_Key$type$org$ednovo$gooru$client$mvp$register$RegisterPresenter$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.register.RegisterPresenter get_Key$type$org$ednovo$gooru$client$mvp$register$RegisterPresenter$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$register$RegisterPresenter$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.mvp.register.RegisterPresenter result = org$ednovo$gooru$client$mvp$register$RegisterPresenter_org$ednovo$gooru$client$mvp$register$RegisterPresenter_methodInjection(get_Key$type$org$ednovo$gooru$client$mvp$register$IsRegisterView$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$register$RegisterPresenter$IsRegisterProxy$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$register$RegisterPresenter$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$register$RegisterPresenter$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$register$RegisterPresenter$_annotation$$none$$;
    
  }
  
  public org.ednovo.gooru.client.mvp.register.RegisterPresenter org$ednovo$gooru$client$mvp$register$RegisterPresenter_org$ednovo$gooru$client$mvp$register$RegisterPresenter_methodInjection(org.ednovo.gooru.client.mvp.register.IsRegisterView _0, org.ednovo.gooru.client.mvp.register.RegisterPresenter.IsRegisterProxy _1) {
    return new org.ednovo.gooru.client.mvp.register.RegisterPresenter(_0, _1);
  }
  
  
  /**
   * Binding for com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.register.RegisterPresenter> declared at:
   *   Implicit injection of com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.register.RegisterPresenter>
   */
  public com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.register.RegisterPresenter> get_Key$type$com$google$gwt$inject$client$AsyncProvider$org$ednovo$gooru$client$mvp$register$RegisterPresenter$$_annotation$$none$$() {
    com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.register.RegisterPresenter> result = new com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.register.RegisterPresenter>() { 
        public void get(final com.google.gwt.user.client.rpc.AsyncCallback<? super org.ednovo.gooru.client.mvp.register.RegisterPresenter> callback) { 
          com.google.gwt.core.client.GWT.runAsync(org.ednovo.gooru.client.mvp.register.RegisterPresenter.class,new com.google.gwt.core.client.RunAsyncCallback() { 
            public void onSuccess() { 
              callback.onSuccess(get_Key$type$org$ednovo$gooru$client$mvp$register$RegisterPresenter$_annotation$$none$$());
            }
            public void onFailure(Throwable ex) { 
               callback.onFailure(ex); 
            } 
        }); 
        }
     };
    
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.register.RegisterView singleton_Key$type$org$ednovo$gooru$client$mvp$register$RegisterView$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.register.RegisterView get_Key$type$org$ednovo$gooru$client$mvp$register$RegisterView$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$register$RegisterView$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.mvp.register.RegisterView result = org$ednovo$gooru$client$mvp$register$RegisterView_org$ednovo$gooru$client$mvp$register$RegisterView_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$register$RegisterView$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$register$RegisterView$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$register$RegisterView$_annotation$$none$$;
    
  }
  
  public org.ednovo.gooru.client.mvp.register.RegisterView org$ednovo$gooru$client$mvp$register$RegisterView_org$ednovo$gooru$client$mvp$register$RegisterView_methodInjection(com.google.gwt.event.shared.EventBus _0) {
    return new org.ednovo.gooru.client.mvp.register.RegisterView(_0);
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
    //   Implicit GWT.create binding for org.ednovo.gooru.client.mvp.register.RegisterPresenter$IsRegisterProxy
    get_Key$type$org$ednovo$gooru$client$mvp$register$RegisterPresenter$IsRegisterProxy$_annotation$$none$$();
    
  }
  
}
