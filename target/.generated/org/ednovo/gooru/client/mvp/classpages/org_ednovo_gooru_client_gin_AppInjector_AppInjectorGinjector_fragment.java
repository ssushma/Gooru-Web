package org.ednovo.gooru.client.mvp.classpages;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$classpages$ClasspagePresenter$IsClasspageProxy$_annotation$$none$$(org.ednovo.gooru.client.mvp.classpages.ClasspagePresenter.IsClasspageProxy injectee) {
    
  }
  
  public native void org$ednovo$gooru$client$mvp$classpages$ClasspagePresenter_classpageService_fieldInjection(org.ednovo.gooru.client.mvp.classpages.ClasspagePresenter injectee, org.ednovo.gooru.client.service.ClasspageServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.classpages.ClasspagePresenter::classpageService = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$classpages$ClasspagePresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.classpages.ClasspagePresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection____(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$classpages$ClasspagePresenter_classpageService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$ClasspageServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$classpages$ClasspageView$_annotation$$none$$(org.ednovo.gooru.client.mvp.classpages.ClasspageView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.classpages.IsClasspageView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:126)
   */
  public org.ednovo.gooru.client.mvp.classpages.IsClasspageView get_Key$type$org$ednovo$gooru$client$mvp$classpages$IsClasspageView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.classpages.IsClasspageView result = get_Key$type$org$ednovo$gooru$client$mvp$classpages$ClasspageView$_annotation$$none$$();
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.classpages.ClasspagePresenter.IsClasspageProxy singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$ClasspagePresenter$IsClasspageProxy$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.classpages.ClasspagePresenter.IsClasspageProxy get_Key$type$org$ednovo$gooru$client$mvp$classpages$ClasspagePresenter$IsClasspageProxy$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$ClasspagePresenter$IsClasspageProxy$_annotation$$none$$ == null) {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.classpages.ClasspagePresenter.IsClasspageProxy.class);
    assert created instanceof org.ednovo.gooru.client.mvp.classpages.ClasspagePresenter.IsClasspageProxy;
    org.ednovo.gooru.client.mvp.classpages.ClasspagePresenter.IsClasspageProxy result = (org.ednovo.gooru.client.mvp.classpages.ClasspagePresenter.IsClasspageProxy) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$classpages$ClasspagePresenter$IsClasspageProxy$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$ClasspagePresenter$IsClasspageProxy$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$ClasspagePresenter$IsClasspageProxy$_annotation$$none$$;
    
  }
  
  private org.ednovo.gooru.client.mvp.classpages.ClasspagePresenter singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$ClasspagePresenter$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.classpages.ClasspagePresenter get_Key$type$org$ednovo$gooru$client$mvp$classpages$ClasspagePresenter$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$ClasspagePresenter$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.mvp.classpages.ClasspagePresenter result = org$ednovo$gooru$client$mvp$classpages$ClasspagePresenter_org$ednovo$gooru$client$mvp$classpages$ClasspagePresenter_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$classpages$IsClasspageView$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$classpages$ClasspagePresenter$IsClasspageProxy$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$classpages$ClasspagePresenter$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$ClasspagePresenter$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$ClasspagePresenter$_annotation$$none$$;
    
  }
  
  public org.ednovo.gooru.client.mvp.classpages.ClasspagePresenter org$ednovo$gooru$client$mvp$classpages$ClasspagePresenter_org$ednovo$gooru$client$mvp$classpages$ClasspagePresenter_methodInjection(com.google.gwt.event.shared.EventBus _0, org.ednovo.gooru.client.mvp.classpages.IsClasspageView _1, org.ednovo.gooru.client.mvp.classpages.ClasspagePresenter.IsClasspageProxy _2) {
    return new org.ednovo.gooru.client.mvp.classpages.ClasspagePresenter(_0, _1, _2);
  }
  
  
  /**
   * Binding for com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.classpages.ClasspagePresenter> declared at:
   *   Implicit injection of com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.classpages.ClasspagePresenter>
   */
  public com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.classpages.ClasspagePresenter> get_Key$type$com$google$gwt$inject$client$AsyncProvider$org$ednovo$gooru$client$mvp$classpages$ClasspagePresenter$$_annotation$$none$$() {
    com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.classpages.ClasspagePresenter> result = new com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.classpages.ClasspagePresenter>() { 
        public void get(final com.google.gwt.user.client.rpc.AsyncCallback<? super org.ednovo.gooru.client.mvp.classpages.ClasspagePresenter> callback) { 
          com.google.gwt.core.client.GWT.runAsync(org.ednovo.gooru.client.mvp.classpages.ClasspagePresenter.class,new com.google.gwt.core.client.RunAsyncCallback() { 
            public void onSuccess() { 
              callback.onSuccess(get_Key$type$org$ednovo$gooru$client$mvp$classpages$ClasspagePresenter$_annotation$$none$$());
            }
            public void onFailure(Throwable ex) { 
               callback.onFailure(ex); 
            } 
        }); 
        }
     };
    
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.classpages.ClasspageView singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$ClasspageView$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.classpages.ClasspageView get_Key$type$org$ednovo$gooru$client$mvp$classpages$ClasspageView$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$ClasspageView$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.mvp.classpages.ClasspageView result = org$ednovo$gooru$client$mvp$classpages$ClasspageView_org$ednovo$gooru$client$mvp$classpages$ClasspageView_methodInjection();
    memberInject_Key$type$org$ednovo$gooru$client$mvp$classpages$ClasspageView$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$ClasspageView$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$ClasspageView$_annotation$$none$$;
    
  }
  
  public org.ednovo.gooru.client.mvp.classpages.ClasspageView org$ednovo$gooru$client$mvp$classpages$ClasspageView_org$ednovo$gooru$client$mvp$classpages$ClasspageView_methodInjection() {
    return new org.ednovo.gooru.client.mvp.classpages.ClasspageView();
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
    //   Implicit GWT.create binding for org.ednovo.gooru.client.mvp.classpages.ClasspagePresenter$IsClasspageProxy
    get_Key$type$org$ednovo$gooru$client$mvp$classpages$ClasspagePresenter$IsClasspageProxy$_annotation$$none$$();
    
  }
  
}
