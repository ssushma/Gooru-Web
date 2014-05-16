package org.ednovo.gooru.client;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public void memberInject_Key$type$org$ednovo$gooru$client$AppPlaceKeeper$_annotation$$none$$(org.ednovo.gooru.client.AppPlaceKeeper injectee) {
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$AppRootPresenter$AppSoulView$_annotation$$none$$(org.ednovo.gooru.client.AppRootPresenter.AppSoulView injectee) {
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$AppRootPresenter$_annotation$$none$$(org.ednovo.gooru.client.AppRootPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection___________________________________________________________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    
  }
  
  private org.ednovo.gooru.client.AppPlaceKeeper singleton_Key$type$org$ednovo$gooru$client$AppPlaceKeeper$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.AppPlaceKeeper get_Key$type$org$ednovo$gooru$client$AppPlaceKeeper$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$AppPlaceKeeper$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.AppPlaceKeeper result = org$ednovo$gooru$client$AppPlaceKeeper_org$ednovo$gooru$client$AppPlaceKeeper_methodInjection();
    memberInject_Key$type$org$ednovo$gooru$client$AppPlaceKeeper$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$AppPlaceKeeper$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$AppPlaceKeeper$_annotation$$none$$;
    
  }
  
  public native org.ednovo.gooru.client.AppPlaceKeeper org$ednovo$gooru$client$AppPlaceKeeper_org$ednovo$gooru$client$AppPlaceKeeper_methodInjection() /*-{
    return @org.ednovo.gooru.client.AppPlaceKeeper::new()();
  }-*/;
  
  
  /**
   * Binding for org.ednovo.gooru.client.AppRootPresenter$AppSoulView declared at:
   *   Implicit GWT.create binding for org.ednovo.gooru.client.AppRootPresenter$AppSoulView
   */
  public org.ednovo.gooru.client.AppRootPresenter.AppSoulView get_Key$type$org$ednovo$gooru$client$AppRootPresenter$AppSoulView$_annotation$$none$$() {
    Object created = GWT.create(org.ednovo.gooru.client.AppRootPresenter.AppSoulView.class);
    assert created instanceof org.ednovo.gooru.client.AppRootPresenter.AppSoulView;
    org.ednovo.gooru.client.AppRootPresenter.AppSoulView result = (org.ednovo.gooru.client.AppRootPresenter.AppSoulView) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$AppRootPresenter$AppSoulView$_annotation$$none$$(result);
    
    return result;
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.AppRootPresenter declared at:
   *   Implicit binding for org.ednovo.gooru.client.AppRootPresenter
   */
  public org.ednovo.gooru.client.AppRootPresenter get_Key$type$org$ednovo$gooru$client$AppRootPresenter$_annotation$$none$$() {
    org.ednovo.gooru.client.AppRootPresenter result = org$ednovo$gooru$client$AppRootPresenter_org$ednovo$gooru$client$AppRootPresenter_methodInjection(get_Key$type$org$ednovo$gooru$client$AppRootPresenter$AppSoulView$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_gin().get_Key$type$org$ednovo$gooru$client$gin$IsPlaceManager$_annotation$$none$$(), injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$AppRootPresenter$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.AppRootPresenter org$ednovo$gooru$client$AppRootPresenter_org$ednovo$gooru$client$AppRootPresenter_methodInjection(org.ednovo.gooru.client.AppRootPresenter.AppSoulView _0, org.ednovo.gooru.client.gin.IsPlaceManager _1, com.google.gwt.event.shared.EventBus _2) {
    return new org.ednovo.gooru.client.AppRootPresenter(_0, _1, _2);
  }
  
  
  /**
   * Field for the enclosing injector.
   */
  private final org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector;
  public org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment(org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector) {
    this.injector = injector;
  }
  
}
