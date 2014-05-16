package org.ednovo.gooru.client.mvp.settings;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$settings$UserSettingsPresenter$IsUserSettingProxy$_annotation$$none$$(org.ednovo.gooru.client.mvp.settings.UserSettingsPresenter.IsUserSettingProxy injectee) {
    
  }
  
  public native void org$ednovo$gooru$client$mvp$settings$UserSettingsPresenter_userService_fieldInjection(org.ednovo.gooru.client.mvp.settings.UserSettingsPresenter injectee, org.ednovo.gooru.client.service.UserServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.settings.UserSettingsPresenter::userService = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$settings$UserSettingsPresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.settings.UserSettingsPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection________________________________________________________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$settings$UserSettingsPresenter_userService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$UserServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$settings$UserSettingsView$_annotation$$none$$(org.ednovo.gooru.client.mvp.settings.UserSettingsView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.settings.IsUserSettingsView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:126)
   */
  public org.ednovo.gooru.client.mvp.settings.IsUserSettingsView get_Key$type$org$ednovo$gooru$client$mvp$settings$IsUserSettingsView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.settings.IsUserSettingsView result = get_Key$type$org$ednovo$gooru$client$mvp$settings$UserSettingsView$_annotation$$none$$();
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.settings.UserSettingsPresenter.IsUserSettingProxy singleton_Key$type$org$ednovo$gooru$client$mvp$settings$UserSettingsPresenter$IsUserSettingProxy$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.settings.UserSettingsPresenter.IsUserSettingProxy get_Key$type$org$ednovo$gooru$client$mvp$settings$UserSettingsPresenter$IsUserSettingProxy$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$settings$UserSettingsPresenter$IsUserSettingProxy$_annotation$$none$$ == null) {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.settings.UserSettingsPresenter.IsUserSettingProxy.class);
    assert created instanceof org.ednovo.gooru.client.mvp.settings.UserSettingsPresenter.IsUserSettingProxy;
    org.ednovo.gooru.client.mvp.settings.UserSettingsPresenter.IsUserSettingProxy result = (org.ednovo.gooru.client.mvp.settings.UserSettingsPresenter.IsUserSettingProxy) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$settings$UserSettingsPresenter$IsUserSettingProxy$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$settings$UserSettingsPresenter$IsUserSettingProxy$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$settings$UserSettingsPresenter$IsUserSettingProxy$_annotation$$none$$;
    
  }
  
  private org.ednovo.gooru.client.mvp.settings.UserSettingsPresenter singleton_Key$type$org$ednovo$gooru$client$mvp$settings$UserSettingsPresenter$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.settings.UserSettingsPresenter get_Key$type$org$ednovo$gooru$client$mvp$settings$UserSettingsPresenter$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$settings$UserSettingsPresenter$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.mvp.settings.UserSettingsPresenter result = org$ednovo$gooru$client$mvp$settings$UserSettingsPresenter_org$ednovo$gooru$client$mvp$settings$UserSettingsPresenter_methodInjection(get_Key$type$org$ednovo$gooru$client$mvp$settings$IsUserSettingsView$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$settings$UserSettingsPresenter$IsUserSettingProxy$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_image_upload().get_Key$type$org$ednovo$gooru$client$mvp$image$upload$ImageUploadPresenter$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$settings$UserSettingsPresenter$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$settings$UserSettingsPresenter$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$settings$UserSettingsPresenter$_annotation$$none$$;
    
  }
  
  public org.ednovo.gooru.client.mvp.settings.UserSettingsPresenter org$ednovo$gooru$client$mvp$settings$UserSettingsPresenter_org$ednovo$gooru$client$mvp$settings$UserSettingsPresenter_methodInjection(org.ednovo.gooru.client.mvp.settings.IsUserSettingsView _0, org.ednovo.gooru.client.mvp.settings.UserSettingsPresenter.IsUserSettingProxy _1, org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter _2) {
    return new org.ednovo.gooru.client.mvp.settings.UserSettingsPresenter(_0, _1, _2);
  }
  
  
  /**
   * Binding for com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.settings.UserSettingsPresenter> declared at:
   *   Implicit injection of com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.settings.UserSettingsPresenter>
   */
  public com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.settings.UserSettingsPresenter> get_Key$type$com$google$gwt$inject$client$AsyncProvider$org$ednovo$gooru$client$mvp$settings$UserSettingsPresenter$$_annotation$$none$$() {
    com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.settings.UserSettingsPresenter> result = new com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.settings.UserSettingsPresenter>() { 
        public void get(final com.google.gwt.user.client.rpc.AsyncCallback<? super org.ednovo.gooru.client.mvp.settings.UserSettingsPresenter> callback) { 
          com.google.gwt.core.client.GWT.runAsync(org.ednovo.gooru.client.mvp.settings.UserSettingsPresenter.class,new com.google.gwt.core.client.RunAsyncCallback() { 
            public void onSuccess() { 
              callback.onSuccess(get_Key$type$org$ednovo$gooru$client$mvp$settings$UserSettingsPresenter$_annotation$$none$$());
            }
            public void onFailure(Throwable ex) { 
               callback.onFailure(ex); 
            } 
        }); 
        }
     };
    
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.settings.UserSettingsView singleton_Key$type$org$ednovo$gooru$client$mvp$settings$UserSettingsView$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.settings.UserSettingsView get_Key$type$org$ednovo$gooru$client$mvp$settings$UserSettingsView$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$settings$UserSettingsView$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.mvp.settings.UserSettingsView result = org$ednovo$gooru$client$mvp$settings$UserSettingsView_org$ednovo$gooru$client$mvp$settings$UserSettingsView_methodInjection();
    memberInject_Key$type$org$ednovo$gooru$client$mvp$settings$UserSettingsView$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$settings$UserSettingsView$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$settings$UserSettingsView$_annotation$$none$$;
    
  }
  
  public org.ednovo.gooru.client.mvp.settings.UserSettingsView org$ednovo$gooru$client$mvp$settings$UserSettingsView_org$ednovo$gooru$client$mvp$settings$UserSettingsView_methodInjection() {
    return new org.ednovo.gooru.client.mvp.settings.UserSettingsView();
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
    //   Implicit GWT.create binding for org.ednovo.gooru.client.mvp.settings.UserSettingsPresenter$IsUserSettingProxy
    get_Key$type$org$ednovo$gooru$client$mvp$settings$UserSettingsPresenter$IsUserSettingProxy$_annotation$$none$$();
    
  }
  
}
