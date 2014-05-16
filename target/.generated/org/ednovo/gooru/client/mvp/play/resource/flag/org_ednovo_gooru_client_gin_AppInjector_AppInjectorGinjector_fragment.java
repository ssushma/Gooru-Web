package org.ednovo.gooru.client.mvp.play.resource.flag;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public native void org$ednovo$gooru$client$mvp$play$resource$flag$ResourceFlagPresenter_playerAppService_fieldInjection(org.ednovo.gooru.client.mvp.play.resource.flag.ResourceFlagPresenter injectee, org.ednovo.gooru.client.service.PlayerAppServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.play.resource.flag.ResourceFlagPresenter::playerAppService = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$play$resource$flag$ResourceFlagPresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.play.resource.flag.ResourceFlagPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection________________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$play$resource$flag$ResourceFlagPresenter_playerAppService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$PlayerAppServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$play$resource$flag$ResourceFlagView$_annotation$$none$$(org.ednovo.gooru.client.mvp.play.resource.flag.ResourceFlagView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.play.resource.flag.IsResourceFlag declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenterWidget(AbstractPresenterModule.java:265)
   */
  public org.ednovo.gooru.client.mvp.play.resource.flag.IsResourceFlag get_Key$type$org$ednovo$gooru$client$mvp$play$resource$flag$IsResourceFlag$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.play.resource.flag.IsResourceFlag result = get_Key$type$org$ednovo$gooru$client$mvp$play$resource$flag$ResourceFlagView$_annotation$$none$$();
    return result;
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.play.resource.flag.ResourceFlagPresenter declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.play.resource.flag.ResourceFlagPresenter
   */
  public org.ednovo.gooru.client.mvp.play.resource.flag.ResourceFlagPresenter get_Key$type$org$ednovo$gooru$client$mvp$play$resource$flag$ResourceFlagPresenter$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.play.resource.flag.ResourceFlagPresenter result = org$ednovo$gooru$client$mvp$play$resource$flag$ResourceFlagPresenter_org$ednovo$gooru$client$mvp$play$resource$flag$ResourceFlagPresenter_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$play$resource$flag$IsResourceFlag$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$play$resource$flag$ResourceFlagPresenter$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.play.resource.flag.ResourceFlagPresenter org$ednovo$gooru$client$mvp$play$resource$flag$ResourceFlagPresenter_org$ednovo$gooru$client$mvp$play$resource$flag$ResourceFlagPresenter_methodInjection(com.google.gwt.event.shared.EventBus _0, org.ednovo.gooru.client.mvp.play.resource.flag.IsResourceFlag _1) {
    return new org.ednovo.gooru.client.mvp.play.resource.flag.ResourceFlagPresenter(_0, _1);
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.play.resource.flag.ResourceFlagView declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.play.resource.flag.ResourceFlagView
   */
  public org.ednovo.gooru.client.mvp.play.resource.flag.ResourceFlagView get_Key$type$org$ednovo$gooru$client$mvp$play$resource$flag$ResourceFlagView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.play.resource.flag.ResourceFlagView result = org$ednovo$gooru$client$mvp$play$resource$flag$ResourceFlagView_org$ednovo$gooru$client$mvp$play$resource$flag$ResourceFlagView_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$play$resource$flag$ResourceFlagView$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.play.resource.flag.ResourceFlagView org$ednovo$gooru$client$mvp$play$resource$flag$ResourceFlagView_org$ednovo$gooru$client$mvp$play$resource$flag$ResourceFlagView_methodInjection(com.google.gwt.event.shared.EventBus _0) {
    return new org.ednovo.gooru.client.mvp.play.resource.flag.ResourceFlagView(_0);
  }
  
  
  /**
   * Field for the enclosing injector.
   */
  private final org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector;
  public org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment(org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector) {
    this.injector = injector;
  }
  
}
