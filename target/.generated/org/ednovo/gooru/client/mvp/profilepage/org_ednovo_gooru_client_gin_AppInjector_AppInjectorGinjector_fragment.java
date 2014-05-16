package org.ednovo.gooru.client.mvp.profilepage;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$profilepage$ProfilePagePresenter$IsProfilePageProxy$_annotation$$none$$(org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter.IsProfilePageProxy injectee) {
    
  }
  
  public native void org$ednovo$gooru$client$mvp$profilepage$ProfilePagePresenter_profilePageListPresenter_fieldInjection(org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter injectee, org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListPresenter value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter::profilePageListPresenter = value;
  }-*/;
  
  public native void org$ednovo$gooru$client$mvp$profilepage$ProfilePagePresenter_profilePageService_fieldInjection(org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter injectee, org.ednovo.gooru.client.service.ProfilePageServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter::profilePageService = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$profilepage$ProfilePagePresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection______________________________________________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$profilepage$ProfilePagePresenter_profilePageListPresenter_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_mvp_profilepage_list().get_Key$type$org$ednovo$gooru$client$mvp$profilepage$list$ProfilePageListPresenter$_annotation$$none$$());
    
    org$ednovo$gooru$client$mvp$profilepage$ProfilePagePresenter_profilePageService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$ProfilePageServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$profilepage$ProfilePageView$_annotation$$none$$(org.ednovo.gooru.client.mvp.profilepage.ProfilePageView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.profilepage.IsProfilePageView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:126)
   */
  public org.ednovo.gooru.client.mvp.profilepage.IsProfilePageView get_Key$type$org$ednovo$gooru$client$mvp$profilepage$IsProfilePageView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.profilepage.IsProfilePageView result = get_Key$type$org$ednovo$gooru$client$mvp$profilepage$ProfilePageView$_annotation$$none$$();
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter.IsProfilePageProxy singleton_Key$type$org$ednovo$gooru$client$mvp$profilepage$ProfilePagePresenter$IsProfilePageProxy$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter.IsProfilePageProxy get_Key$type$org$ednovo$gooru$client$mvp$profilepage$ProfilePagePresenter$IsProfilePageProxy$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$profilepage$ProfilePagePresenter$IsProfilePageProxy$_annotation$$none$$ == null) {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter.IsProfilePageProxy.class);
    assert created instanceof org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter.IsProfilePageProxy;
    org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter.IsProfilePageProxy result = (org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter.IsProfilePageProxy) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$profilepage$ProfilePagePresenter$IsProfilePageProxy$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$profilepage$ProfilePagePresenter$IsProfilePageProxy$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$profilepage$ProfilePagePresenter$IsProfilePageProxy$_annotation$$none$$;
    
  }
  
  private org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter singleton_Key$type$org$ednovo$gooru$client$mvp$profilepage$ProfilePagePresenter$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter get_Key$type$org$ednovo$gooru$client$mvp$profilepage$ProfilePagePresenter$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$profilepage$ProfilePagePresenter$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter result = org$ednovo$gooru$client$mvp$profilepage$ProfilePagePresenter_org$ednovo$gooru$client$mvp$profilepage$ProfilePagePresenter_methodInjection(injector.getFragment_org_ednovo_gooru_client_mvp_profilepage_list().get_Key$type$org$ednovo$gooru$client$mvp$profilepage$list$ProfilePageListPresenter$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$profilepage$IsProfilePageView$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$profilepage$ProfilePagePresenter$IsProfilePageProxy$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_image_upload().get_Key$type$org$ednovo$gooru$client$mvp$image$upload$ImageUploadPresenter$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_authentication().get_Key$type$org$ednovo$gooru$client$mvp$authentication$SignUpPresenter$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$profilepage$ProfilePagePresenter$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$profilepage$ProfilePagePresenter$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$profilepage$ProfilePagePresenter$_annotation$$none$$;
    
  }
  
  public org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter org$ednovo$gooru$client$mvp$profilepage$ProfilePagePresenter_org$ednovo$gooru$client$mvp$profilepage$ProfilePagePresenter_methodInjection(org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListPresenter _0, org.ednovo.gooru.client.mvp.profilepage.IsProfilePageView _1, org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter.IsProfilePageProxy _2, org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter _3, org.ednovo.gooru.client.mvp.authentication.SignUpPresenter _4) {
    return new org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter(_0, _1, _2, _3, _4);
  }
  
  
  /**
   * Binding for com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter> declared at:
   *   Implicit injection of com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter>
   */
  public com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter> get_Key$type$com$google$gwt$inject$client$AsyncProvider$org$ednovo$gooru$client$mvp$profilepage$ProfilePagePresenter$$_annotation$$none$$() {
    com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter> result = new com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter>() { 
        public void get(final com.google.gwt.user.client.rpc.AsyncCallback<? super org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter> callback) { 
          com.google.gwt.core.client.GWT.runAsync(org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter.class,new com.google.gwt.core.client.RunAsyncCallback() { 
            public void onSuccess() { 
              callback.onSuccess(get_Key$type$org$ednovo$gooru$client$mvp$profilepage$ProfilePagePresenter$_annotation$$none$$());
            }
            public void onFailure(Throwable ex) { 
               callback.onFailure(ex); 
            } 
        }); 
        }
     };
    
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.profilepage.ProfilePageView singleton_Key$type$org$ednovo$gooru$client$mvp$profilepage$ProfilePageView$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.profilepage.ProfilePageView get_Key$type$org$ednovo$gooru$client$mvp$profilepage$ProfilePageView$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$profilepage$ProfilePageView$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.mvp.profilepage.ProfilePageView result = org$ednovo$gooru$client$mvp$profilepage$ProfilePageView_org$ednovo$gooru$client$mvp$profilepage$ProfilePageView_methodInjection();
    memberInject_Key$type$org$ednovo$gooru$client$mvp$profilepage$ProfilePageView$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$profilepage$ProfilePageView$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$profilepage$ProfilePageView$_annotation$$none$$;
    
  }
  
  public org.ednovo.gooru.client.mvp.profilepage.ProfilePageView org$ednovo$gooru$client$mvp$profilepage$ProfilePageView_org$ednovo$gooru$client$mvp$profilepage$ProfilePageView_methodInjection() {
    return new org.ednovo.gooru.client.mvp.profilepage.ProfilePageView();
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
    //   Implicit GWT.create binding for org.ednovo.gooru.client.mvp.profilepage.ProfilePagePresenter$IsProfilePageProxy
    get_Key$type$org$ednovo$gooru$client$mvp$profilepage$ProfilePagePresenter$IsProfilePageProxy$_annotation$$none$$();
    
  }
  
}
