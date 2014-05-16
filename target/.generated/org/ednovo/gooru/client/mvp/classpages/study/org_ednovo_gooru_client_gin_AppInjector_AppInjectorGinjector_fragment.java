package org.ednovo.gooru.client.mvp.classpages.study;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$classpages$study$ClassCodePresenter$IsClassCodeProxy$_annotation$$none$$(org.ednovo.gooru.client.mvp.classpages.study.ClassCodePresenter.IsClassCodeProxy injectee) {
    
  }
  
  public native void org$ednovo$gooru$client$mvp$classpages$study$ClassCodePresenter_classpageServiceAsync_fieldInjection(org.ednovo.gooru.client.mvp.classpages.study.ClassCodePresenter injectee, org.ednovo.gooru.client.service.ClasspageServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.classpages.study.ClassCodePresenter::classpageServiceAsync = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$classpages$study$ClassCodePresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.classpages.study.ClassCodePresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection___(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$classpages$study$ClassCodePresenter_classpageServiceAsync_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$ClasspageServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$classpages$study$ClassCodeView$_annotation$$none$$(org.ednovo.gooru.client.mvp.classpages.study.ClassCodeView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.classpages.study.IsClassCodeView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:126)
   */
  public org.ednovo.gooru.client.mvp.classpages.study.IsClassCodeView get_Key$type$org$ednovo$gooru$client$mvp$classpages$study$IsClassCodeView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.classpages.study.IsClassCodeView result = get_Key$type$org$ednovo$gooru$client$mvp$classpages$study$ClassCodeView$_annotation$$none$$();
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.classpages.study.ClassCodePresenter.IsClassCodeProxy singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$study$ClassCodePresenter$IsClassCodeProxy$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.classpages.study.ClassCodePresenter.IsClassCodeProxy get_Key$type$org$ednovo$gooru$client$mvp$classpages$study$ClassCodePresenter$IsClassCodeProxy$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$study$ClassCodePresenter$IsClassCodeProxy$_annotation$$none$$ == null) {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.classpages.study.ClassCodePresenter.IsClassCodeProxy.class);
    assert created instanceof org.ednovo.gooru.client.mvp.classpages.study.ClassCodePresenter.IsClassCodeProxy;
    org.ednovo.gooru.client.mvp.classpages.study.ClassCodePresenter.IsClassCodeProxy result = (org.ednovo.gooru.client.mvp.classpages.study.ClassCodePresenter.IsClassCodeProxy) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$classpages$study$ClassCodePresenter$IsClassCodeProxy$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$study$ClassCodePresenter$IsClassCodeProxy$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$study$ClassCodePresenter$IsClassCodeProxy$_annotation$$none$$;
    
  }
  
  private org.ednovo.gooru.client.mvp.classpages.study.ClassCodePresenter singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$study$ClassCodePresenter$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.classpages.study.ClassCodePresenter get_Key$type$org$ednovo$gooru$client$mvp$classpages$study$ClassCodePresenter$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$study$ClassCodePresenter$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.mvp.classpages.study.ClassCodePresenter result = org$ednovo$gooru$client$mvp$classpages$study$ClassCodePresenter_org$ednovo$gooru$client$mvp$classpages$study$ClassCodePresenter_methodInjection(get_Key$type$org$ednovo$gooru$client$mvp$classpages$study$IsClassCodeView$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$classpages$study$ClassCodePresenter$IsClassCodeProxy$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$classpages$study$ClassCodePresenter$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$study$ClassCodePresenter$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$study$ClassCodePresenter$_annotation$$none$$;
    
  }
  
  public org.ednovo.gooru.client.mvp.classpages.study.ClassCodePresenter org$ednovo$gooru$client$mvp$classpages$study$ClassCodePresenter_org$ednovo$gooru$client$mvp$classpages$study$ClassCodePresenter_methodInjection(org.ednovo.gooru.client.mvp.classpages.study.IsClassCodeView _0, org.ednovo.gooru.client.mvp.classpages.study.ClassCodePresenter.IsClassCodeProxy _1) {
    return new org.ednovo.gooru.client.mvp.classpages.study.ClassCodePresenter(_0, _1);
  }
  
  
  /**
   * Binding for com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.classpages.study.ClassCodePresenter> declared at:
   *   Implicit injection of com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.classpages.study.ClassCodePresenter>
   */
  public com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.classpages.study.ClassCodePresenter> get_Key$type$com$google$gwt$inject$client$AsyncProvider$org$ednovo$gooru$client$mvp$classpages$study$ClassCodePresenter$$_annotation$$none$$() {
    com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.classpages.study.ClassCodePresenter> result = new com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.classpages.study.ClassCodePresenter>() { 
        public void get(final com.google.gwt.user.client.rpc.AsyncCallback<? super org.ednovo.gooru.client.mvp.classpages.study.ClassCodePresenter> callback) { 
          com.google.gwt.core.client.GWT.runAsync(org.ednovo.gooru.client.mvp.classpages.study.ClassCodePresenter.class,new com.google.gwt.core.client.RunAsyncCallback() { 
            public void onSuccess() { 
              callback.onSuccess(get_Key$type$org$ednovo$gooru$client$mvp$classpages$study$ClassCodePresenter$_annotation$$none$$());
            }
            public void onFailure(Throwable ex) { 
               callback.onFailure(ex); 
            } 
        }); 
        }
     };
    
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.classpages.study.ClassCodeView singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$study$ClassCodeView$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.classpages.study.ClassCodeView get_Key$type$org$ednovo$gooru$client$mvp$classpages$study$ClassCodeView$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$study$ClassCodeView$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.mvp.classpages.study.ClassCodeView result = org$ednovo$gooru$client$mvp$classpages$study$ClassCodeView_org$ednovo$gooru$client$mvp$classpages$study$ClassCodeView_methodInjection();
    memberInject_Key$type$org$ednovo$gooru$client$mvp$classpages$study$ClassCodeView$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$study$ClassCodeView$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$study$ClassCodeView$_annotation$$none$$;
    
  }
  
  public org.ednovo.gooru.client.mvp.classpages.study.ClassCodeView org$ednovo$gooru$client$mvp$classpages$study$ClassCodeView_org$ednovo$gooru$client$mvp$classpages$study$ClassCodeView_methodInjection() {
    return new org.ednovo.gooru.client.mvp.classpages.study.ClassCodeView();
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
    //   Implicit GWT.create binding for org.ednovo.gooru.client.mvp.classpages.study.ClassCodePresenter$IsClassCodeProxy
    get_Key$type$org$ednovo$gooru$client$mvp$classpages$study$ClassCodePresenter$IsClassCodeProxy$_annotation$$none$$();
    
  }
  
}
