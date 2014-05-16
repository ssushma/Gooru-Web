package org.ednovo.gooru.client.mvp.library.partner;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$library$partner$PartnerLibraryPresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$library$partner$PartnerLibraryView$_annotation$$none$$(org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.library.partner.IsPartnerLibraryView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenterWidget(AbstractPresenterModule.java:265)
   */
  public org.ednovo.gooru.client.mvp.library.partner.IsPartnerLibraryView get_Key$type$org$ednovo$gooru$client$mvp$library$partner$IsPartnerLibraryView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.library.partner.IsPartnerLibraryView result = get_Key$type$org$ednovo$gooru$client$mvp$library$partner$PartnerLibraryView$_annotation$$none$$();
    return result;
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryPresenter declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryPresenter
   */
  public org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryPresenter get_Key$type$org$ednovo$gooru$client$mvp$library$partner$PartnerLibraryPresenter$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryPresenter result = org$ednovo$gooru$client$mvp$library$partner$PartnerLibraryPresenter_org$ednovo$gooru$client$mvp$library$partner$PartnerLibraryPresenter_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$library$partner$IsPartnerLibraryView$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$library$partner$PartnerLibraryPresenter$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryPresenter org$ednovo$gooru$client$mvp$library$partner$PartnerLibraryPresenter_org$ednovo$gooru$client$mvp$library$partner$PartnerLibraryPresenter_methodInjection(com.google.gwt.event.shared.EventBus _0, org.ednovo.gooru.client.mvp.library.partner.IsPartnerLibraryView _1) {
    return new org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryPresenter(_0, _1);
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryView declared at:
   *   Implicit GWT.create binding for org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryView
   */
  public org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryView get_Key$type$org$ednovo$gooru$client$mvp$library$partner$PartnerLibraryView$_annotation$$none$$() {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryView.class);
    assert created instanceof org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryView;
    org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryView result = (org.ednovo.gooru.client.mvp.library.partner.PartnerLibraryView) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$library$partner$PartnerLibraryView$_annotation$$none$$(result);
    
    return result;
    
  }
  
  
  /**
   * Field for the enclosing injector.
   */
  private final org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector;
  public org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment(org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector) {
    this.injector = injector;
  }
  
}
