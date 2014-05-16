package org.ednovo.gooru.client.mvp.home;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$home$HomePresenter$IsHomeProxy$_annotation$$none$$(org.ednovo.gooru.client.mvp.home.HomePresenter.IsHomeProxy injectee) {
    
  }
  
  public native void org$ednovo$gooru$client$mvp$home$HomePresenter_homeService_fieldInjection(org.ednovo.gooru.client.mvp.home.HomePresenter injectee, org.ednovo.gooru.client.service.HomeServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.home.HomePresenter::homeService = value;
  }-*/;
  
  public native void org$ednovo$gooru$client$mvp$home$HomePresenter_searchService_fieldInjection(org.ednovo.gooru.client.mvp.home.HomePresenter injectee, org.ednovo.gooru.client.service.SearchServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.home.HomePresenter::searchService = value;
  }-*/;
  
  public native void org$ednovo$gooru$client$mvp$home$HomePresenter_userService_fieldInjection(org.ednovo.gooru.client.mvp.home.HomePresenter injectee, org.ednovo.gooru.client.service.UserServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.home.HomePresenter::userService = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$home$HomePresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.home.HomePresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection______________________________________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$home$HomePresenter_homeService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$HomeServiceAsync$_annotation$$none$$());
    
    org$ednovo$gooru$client$mvp$home$HomePresenter_searchService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$SearchServiceAsync$_annotation$$none$$());
    
    org$ednovo$gooru$client$mvp$home$HomePresenter_userService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$UserServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$home$HomeView$_annotation$$none$$(org.ednovo.gooru.client.mvp.home.HomeView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.home.IsHomeView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:126)
   */
  public org.ednovo.gooru.client.mvp.home.IsHomeView get_Key$type$org$ednovo$gooru$client$mvp$home$IsHomeView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.home.IsHomeView result = get_Key$type$org$ednovo$gooru$client$mvp$home$HomeView$_annotation$$none$$();
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.home.HomePresenter.IsHomeProxy singleton_Key$type$org$ednovo$gooru$client$mvp$home$HomePresenter$IsHomeProxy$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.home.HomePresenter.IsHomeProxy get_Key$type$org$ednovo$gooru$client$mvp$home$HomePresenter$IsHomeProxy$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$home$HomePresenter$IsHomeProxy$_annotation$$none$$ == null) {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.home.HomePresenter.IsHomeProxy.class);
    assert created instanceof org.ednovo.gooru.client.mvp.home.HomePresenter.IsHomeProxy;
    org.ednovo.gooru.client.mvp.home.HomePresenter.IsHomeProxy result = (org.ednovo.gooru.client.mvp.home.HomePresenter.IsHomeProxy) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$home$HomePresenter$IsHomeProxy$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$home$HomePresenter$IsHomeProxy$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$home$HomePresenter$IsHomeProxy$_annotation$$none$$;
    
  }
  
  private org.ednovo.gooru.client.mvp.home.HomePresenter singleton_Key$type$org$ednovo$gooru$client$mvp$home$HomePresenter$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.home.HomePresenter get_Key$type$org$ednovo$gooru$client$mvp$home$HomePresenter$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$home$HomePresenter$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.mvp.home.HomePresenter result = org$ednovo$gooru$client$mvp$home$HomePresenter_org$ednovo$gooru$client$mvp$home$HomePresenter_methodInjection(injector.getFragment_org_ednovo_gooru_client_mvp_home_register().get_Key$type$org$ednovo$gooru$client$mvp$home$register$UserRegistrationPresenter$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_authentication().get_Key$type$org$ednovo$gooru$client$mvp$authentication$SignUpPresenter$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_authentication_afterthirteen().get_Key$type$org$ednovo$gooru$client$mvp$authentication$afterthirteen$SignUpCompleteProfilePresenter$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_authentication_afterthirteen().get_Key$type$org$ednovo$gooru$client$mvp$authentication$afterthirteen$SignUpAfterThirteenPresenter$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$home$IsHomeView$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$home$HomePresenter$IsHomeProxy$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$home$HomePresenter$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$home$HomePresenter$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$home$HomePresenter$_annotation$$none$$;
    
  }
  
  public org.ednovo.gooru.client.mvp.home.HomePresenter org$ednovo$gooru$client$mvp$home$HomePresenter_org$ednovo$gooru$client$mvp$home$HomePresenter_methodInjection(org.ednovo.gooru.client.mvp.home.register.UserRegistrationPresenter _0, org.ednovo.gooru.client.mvp.authentication.SignUpPresenter _1, org.ednovo.gooru.client.mvp.authentication.afterthirteen.SignUpCompleteProfilePresenter _2, org.ednovo.gooru.client.mvp.authentication.afterthirteen.SignUpAfterThirteenPresenter _3, org.ednovo.gooru.client.mvp.home.IsHomeView _4, org.ednovo.gooru.client.mvp.home.HomePresenter.IsHomeProxy _5) {
    return new org.ednovo.gooru.client.mvp.home.HomePresenter(_0, _1, _2, _3, _4, _5);
  }
  
  
  /**
   * Binding for com.google.inject.Provider<org.ednovo.gooru.client.mvp.home.HomePresenter> declared at:
   *   Implicit provider for com.google.inject.Provider<org.ednovo.gooru.client.mvp.home.HomePresenter>
   */
  public com.google.inject.Provider<org.ednovo.gooru.client.mvp.home.HomePresenter> get_Key$type$com$google$inject$Provider$org$ednovo$gooru$client$mvp$home$HomePresenter$$_annotation$$none$$() {
    com.google.inject.Provider<org.ednovo.gooru.client.mvp.home.HomePresenter> result = new com.google.inject.Provider<org.ednovo.gooru.client.mvp.home.HomePresenter>() { 
      public org.ednovo.gooru.client.mvp.home.HomePresenter get() { 
        return get_Key$type$org$ednovo$gooru$client$mvp$home$HomePresenter$_annotation$$none$$();
      }
    };
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.home.HomeView singleton_Key$type$org$ednovo$gooru$client$mvp$home$HomeView$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.home.HomeView get_Key$type$org$ednovo$gooru$client$mvp$home$HomeView$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$home$HomeView$_annotation$$none$$ == null) {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.home.HomeView.class);
    assert created instanceof org.ednovo.gooru.client.mvp.home.HomeView;
    org.ednovo.gooru.client.mvp.home.HomeView result = (org.ednovo.gooru.client.mvp.home.HomeView) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$home$HomeView$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$home$HomeView$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$home$HomeView$_annotation$$none$$;
    
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
    //   Implicit GWT.create binding for org.ednovo.gooru.client.mvp.home.HomePresenter$IsHomeProxy
    get_Key$type$org$ednovo$gooru$client$mvp$home$HomePresenter$IsHomeProxy$_annotation$$none$$();
    
  }
  
}
