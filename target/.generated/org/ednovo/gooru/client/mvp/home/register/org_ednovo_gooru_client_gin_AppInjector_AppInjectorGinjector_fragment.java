package org.ednovo.gooru.client.mvp.home.register;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public native void org$ednovo$gooru$client$mvp$home$register$UserRegistrationPresenter_userService_fieldInjection(org.ednovo.gooru.client.mvp.home.register.UserRegistrationPresenter injectee, org.ednovo.gooru.client.service.UserServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.home.register.UserRegistrationPresenter::userService = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$home$register$UserRegistrationPresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.home.register.UserRegistrationPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection___________________________________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$home$register$UserRegistrationPresenter_userService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$UserServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$home$register$UserRegistrationView$_annotation$$none$$(org.ednovo.gooru.client.mvp.home.register.UserRegistrationView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.home.register.IsUserRegistrationView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenterWidget(AbstractPresenterModule.java:265)
   */
  public org.ednovo.gooru.client.mvp.home.register.IsUserRegistrationView get_Key$type$org$ednovo$gooru$client$mvp$home$register$IsUserRegistrationView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.home.register.IsUserRegistrationView result = get_Key$type$org$ednovo$gooru$client$mvp$home$register$UserRegistrationView$_annotation$$none$$();
    return result;
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.home.register.UserRegistrationPresenter declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.home.register.UserRegistrationPresenter
   */
  public org.ednovo.gooru.client.mvp.home.register.UserRegistrationPresenter get_Key$type$org$ednovo$gooru$client$mvp$home$register$UserRegistrationPresenter$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.home.register.UserRegistrationPresenter result = org$ednovo$gooru$client$mvp$home$register$UserRegistrationPresenter_org$ednovo$gooru$client$mvp$home$register$UserRegistrationPresenter_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$home$register$IsUserRegistrationView$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$home$register$UserRegistrationPresenter$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.home.register.UserRegistrationPresenter org$ednovo$gooru$client$mvp$home$register$UserRegistrationPresenter_org$ednovo$gooru$client$mvp$home$register$UserRegistrationPresenter_methodInjection(com.google.gwt.event.shared.EventBus _0, org.ednovo.gooru.client.mvp.home.register.IsUserRegistrationView _1) {
    return new org.ednovo.gooru.client.mvp.home.register.UserRegistrationPresenter(_0, _1);
  }
  
  
  /**
   * Binding for com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.home.register.UserRegistrationPresenter> declared at:
   *   Implicit injection of com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.home.register.UserRegistrationPresenter>
   */
  public com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.home.register.UserRegistrationPresenter> get_Key$type$com$google$gwt$inject$client$AsyncProvider$org$ednovo$gooru$client$mvp$home$register$UserRegistrationPresenter$$_annotation$$none$$() {
    com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.home.register.UserRegistrationPresenter> result = new com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.home.register.UserRegistrationPresenter>() { 
        public void get(final com.google.gwt.user.client.rpc.AsyncCallback<? super org.ednovo.gooru.client.mvp.home.register.UserRegistrationPresenter> callback) { 
          com.google.gwt.core.client.GWT.runAsync(org.ednovo.gooru.client.mvp.home.register.UserRegistrationPresenter.class,new com.google.gwt.core.client.RunAsyncCallback() { 
            public void onSuccess() { 
              callback.onSuccess(get_Key$type$org$ednovo$gooru$client$mvp$home$register$UserRegistrationPresenter$_annotation$$none$$());
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
   * Binding for org.ednovo.gooru.client.mvp.home.register.UserRegistrationView declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.home.register.UserRegistrationView
   */
  public org.ednovo.gooru.client.mvp.home.register.UserRegistrationView get_Key$type$org$ednovo$gooru$client$mvp$home$register$UserRegistrationView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.home.register.UserRegistrationView result = org$ednovo$gooru$client$mvp$home$register$UserRegistrationView_org$ednovo$gooru$client$mvp$home$register$UserRegistrationView_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$home$register$UserRegistrationView$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.home.register.UserRegistrationView org$ednovo$gooru$client$mvp$home$register$UserRegistrationView_org$ednovo$gooru$client$mvp$home$register$UserRegistrationView_methodInjection(com.google.gwt.event.shared.EventBus _0) {
    return new org.ednovo.gooru.client.mvp.home.register.UserRegistrationView(_0);
  }
  
  
  /**
   * Field for the enclosing injector.
   */
  private final org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector;
  public org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment(org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector) {
    this.injector = injector;
  }
  
}
