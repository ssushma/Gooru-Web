package org.ednovo.gooru.client.mvp.profilepage.list;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public native void org$ednovo$gooru$client$mvp$profilepage$list$ProfilePageListPresenter_profilePageService_fieldInjection(org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListPresenter injectee, org.ednovo.gooru.client.service.ProfilePageServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListPresenter::profilePageService = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$profilepage$list$ProfilePageListPresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection_____________________________________________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$profilepage$list$ProfilePageListPresenter_profilePageService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$ProfilePageServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$profilepage$list$ProfilePageListView$_annotation$$none$$(org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.profilepage.list.IsProfilePageListView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenterWidget(AbstractPresenterModule.java:265)
   */
  public org.ednovo.gooru.client.mvp.profilepage.list.IsProfilePageListView get_Key$type$org$ednovo$gooru$client$mvp$profilepage$list$IsProfilePageListView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.profilepage.list.IsProfilePageListView result = get_Key$type$org$ednovo$gooru$client$mvp$profilepage$list$ProfilePageListView$_annotation$$none$$();
    return result;
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListPresenter declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListPresenter
   */
  public org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListPresenter get_Key$type$org$ednovo$gooru$client$mvp$profilepage$list$ProfilePageListPresenter$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListPresenter result = org$ednovo$gooru$client$mvp$profilepage$list$ProfilePageListPresenter_org$ednovo$gooru$client$mvp$profilepage$list$ProfilePageListPresenter_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$profilepage$list$IsProfilePageListView$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$profilepage$list$ProfilePageListPresenter$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListPresenter org$ednovo$gooru$client$mvp$profilepage$list$ProfilePageListPresenter_org$ednovo$gooru$client$mvp$profilepage$list$ProfilePageListPresenter_methodInjection(com.google.gwt.event.shared.EventBus _0, org.ednovo.gooru.client.mvp.profilepage.list.IsProfilePageListView _1) {
    return new org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListPresenter(_0, _1);
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListView declared at:
   *   Implicit GWT.create binding for org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListView
   */
  public org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListView get_Key$type$org$ednovo$gooru$client$mvp$profilepage$list$ProfilePageListView$_annotation$$none$$() {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListView.class);
    assert created instanceof org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListView;
    org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListView result = (org.ednovo.gooru.client.mvp.profilepage.list.ProfilePageListView) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$profilepage$list$ProfilePageListView$_annotation$$none$$(result);
    
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
