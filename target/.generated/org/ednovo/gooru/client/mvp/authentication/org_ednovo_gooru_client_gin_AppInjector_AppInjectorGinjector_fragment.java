package org.ednovo.gooru.client.mvp.authentication;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public native void org$ednovo$gooru$client$mvp$authentication$SignUpPresenter_userService_fieldInjection(org.ednovo.gooru.client.mvp.authentication.SignUpPresenter injectee, org.ednovo.gooru.client.service.UserServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.authentication.SignUpPresenter::userService = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$authentication$SignUpPresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.authentication.SignUpPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection_(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$authentication$SignUpPresenter_userService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$UserServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$authentication$SignUpView$_annotation$$none$$(org.ednovo.gooru.client.mvp.authentication.SignUpView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.authentication.IsSignUpView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenterWidget(AbstractPresenterModule.java:265)
   */
  public org.ednovo.gooru.client.mvp.authentication.IsSignUpView get_Key$type$org$ednovo$gooru$client$mvp$authentication$IsSignUpView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.authentication.IsSignUpView result = get_Key$type$org$ednovo$gooru$client$mvp$authentication$SignUpView$_annotation$$none$$();
    return result;
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.authentication.SignUpPresenter declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.authentication.SignUpPresenter
   */
  public org.ednovo.gooru.client.mvp.authentication.SignUpPresenter get_Key$type$org$ednovo$gooru$client$mvp$authentication$SignUpPresenter$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.authentication.SignUpPresenter result = org$ednovo$gooru$client$mvp$authentication$SignUpPresenter_org$ednovo$gooru$client$mvp$authentication$SignUpPresenter_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$authentication$IsSignUpView$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$authentication$SignUpPresenter$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.authentication.SignUpPresenter org$ednovo$gooru$client$mvp$authentication$SignUpPresenter_org$ednovo$gooru$client$mvp$authentication$SignUpPresenter_methodInjection(com.google.gwt.event.shared.EventBus _0, org.ednovo.gooru.client.mvp.authentication.IsSignUpView _1) {
    return new org.ednovo.gooru.client.mvp.authentication.SignUpPresenter(_0, _1);
  }
  
  
  /**
   * Binding for com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.authentication.SignUpPresenter> declared at:
   *   Implicit injection of com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.authentication.SignUpPresenter>
   */
  public com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.authentication.SignUpPresenter> get_Key$type$com$google$gwt$inject$client$AsyncProvider$org$ednovo$gooru$client$mvp$authentication$SignUpPresenter$$_annotation$$none$$() {
    com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.authentication.SignUpPresenter> result = new com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.authentication.SignUpPresenter>() { 
        public void get(final com.google.gwt.user.client.rpc.AsyncCallback<? super org.ednovo.gooru.client.mvp.authentication.SignUpPresenter> callback) { 
          com.google.gwt.core.client.GWT.runAsync(org.ednovo.gooru.client.mvp.authentication.SignUpPresenter.class,new com.google.gwt.core.client.RunAsyncCallback() { 
            public void onSuccess() { 
              callback.onSuccess(get_Key$type$org$ednovo$gooru$client$mvp$authentication$SignUpPresenter$_annotation$$none$$());
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
   * Binding for org.ednovo.gooru.client.mvp.authentication.SignUpView declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.authentication.SignUpView
   */
  public org.ednovo.gooru.client.mvp.authentication.SignUpView get_Key$type$org$ednovo$gooru$client$mvp$authentication$SignUpView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.authentication.SignUpView result = org$ednovo$gooru$client$mvp$authentication$SignUpView_org$ednovo$gooru$client$mvp$authentication$SignUpView_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$authentication$SignUpView$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.authentication.SignUpView org$ednovo$gooru$client$mvp$authentication$SignUpView_org$ednovo$gooru$client$mvp$authentication$SignUpView_methodInjection(com.google.gwt.event.shared.EventBus _0) {
    return new org.ednovo.gooru.client.mvp.authentication.SignUpView(_0);
  }
  
  
  /**
   * Field for the enclosing injector.
   */
  private final org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector;
  public org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment(org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector) {
    this.injector = injector;
  }
  
}
