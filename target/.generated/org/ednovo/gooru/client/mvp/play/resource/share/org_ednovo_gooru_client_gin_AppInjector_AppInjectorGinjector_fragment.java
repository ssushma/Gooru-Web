package org.ednovo.gooru.client.mvp.play.resource.share;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$play$resource$share$ResourceSharePresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.play.resource.share.ResourceSharePresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection_________________________________________________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$play$resource$share$ResourceShareView$_annotation$$none$$(org.ednovo.gooru.client.mvp.play.resource.share.ResourceShareView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.play.resource.share.IsResourceShareView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenterWidget(AbstractPresenterModule.java:265)
   */
  public org.ednovo.gooru.client.mvp.play.resource.share.IsResourceShareView get_Key$type$org$ednovo$gooru$client$mvp$play$resource$share$IsResourceShareView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.play.resource.share.IsResourceShareView result = get_Key$type$org$ednovo$gooru$client$mvp$play$resource$share$ResourceShareView$_annotation$$none$$();
    return result;
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.play.resource.share.ResourceSharePresenter declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.play.resource.share.ResourceSharePresenter
   */
  public org.ednovo.gooru.client.mvp.play.resource.share.ResourceSharePresenter get_Key$type$org$ednovo$gooru$client$mvp$play$resource$share$ResourceSharePresenter$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.play.resource.share.ResourceSharePresenter result = org$ednovo$gooru$client$mvp$play$resource$share$ResourceSharePresenter_org$ednovo$gooru$client$mvp$play$resource$share$ResourceSharePresenter_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$play$resource$share$IsResourceShareView$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$play$resource$share$ResourceSharePresenter$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.play.resource.share.ResourceSharePresenter org$ednovo$gooru$client$mvp$play$resource$share$ResourceSharePresenter_org$ednovo$gooru$client$mvp$play$resource$share$ResourceSharePresenter_methodInjection(com.google.gwt.event.shared.EventBus _0, org.ednovo.gooru.client.mvp.play.resource.share.IsResourceShareView _1) {
    return new org.ednovo.gooru.client.mvp.play.resource.share.ResourceSharePresenter(_0, _1);
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.play.resource.share.ResourceShareView declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.play.resource.share.ResourceShareView
   */
  public org.ednovo.gooru.client.mvp.play.resource.share.ResourceShareView get_Key$type$org$ednovo$gooru$client$mvp$play$resource$share$ResourceShareView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.play.resource.share.ResourceShareView result = org$ednovo$gooru$client$mvp$play$resource$share$ResourceShareView_org$ednovo$gooru$client$mvp$play$resource$share$ResourceShareView_methodInjection();
    memberInject_Key$type$org$ednovo$gooru$client$mvp$play$resource$share$ResourceShareView$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.play.resource.share.ResourceShareView org$ednovo$gooru$client$mvp$play$resource$share$ResourceShareView_org$ednovo$gooru$client$mvp$play$resource$share$ResourceShareView_methodInjection() {
    return new org.ednovo.gooru.client.mvp.play.resource.share.ResourceShareView();
  }
  
  
  /**
   * Field for the enclosing injector.
   */
  private final org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector;
  public org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment(org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector) {
    this.injector = injector;
  }
  
}
