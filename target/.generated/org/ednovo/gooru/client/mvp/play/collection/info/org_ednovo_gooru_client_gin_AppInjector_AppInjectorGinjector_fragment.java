package org.ednovo.gooru.client.mvp.play.collection.info;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public native void org$ednovo$gooru$client$mvp$play$collection$info$ResourceInfoPresenter_playerAppService_fieldInjection(org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoPresenter injectee, org.ednovo.gooru.client.service.PlayerAppServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoPresenter::playerAppService = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$play$collection$info$ResourceInfoPresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection___________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$play$collection$info$ResourceInfoPresenter_playerAppService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$PlayerAppServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$play$collection$info$ResourceInfoView$_annotation$$none$$(org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.play.collection.info.IsResourceInfoView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenterWidget(AbstractPresenterModule.java:265)
   */
  public org.ednovo.gooru.client.mvp.play.collection.info.IsResourceInfoView get_Key$type$org$ednovo$gooru$client$mvp$play$collection$info$IsResourceInfoView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.play.collection.info.IsResourceInfoView result = get_Key$type$org$ednovo$gooru$client$mvp$play$collection$info$ResourceInfoView$_annotation$$none$$();
    return result;
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoPresenter declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoPresenter
   */
  public org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoPresenter get_Key$type$org$ednovo$gooru$client$mvp$play$collection$info$ResourceInfoPresenter$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoPresenter result = org$ednovo$gooru$client$mvp$play$collection$info$ResourceInfoPresenter_org$ednovo$gooru$client$mvp$play$collection$info$ResourceInfoPresenter_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$play$collection$info$IsResourceInfoView$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$play$collection$info$ResourceInfoPresenter$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoPresenter org$ednovo$gooru$client$mvp$play$collection$info$ResourceInfoPresenter_org$ednovo$gooru$client$mvp$play$collection$info$ResourceInfoPresenter_methodInjection(com.google.gwt.event.shared.EventBus _0, org.ednovo.gooru.client.mvp.play.collection.info.IsResourceInfoView _1) {
    return new org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoPresenter(_0, _1);
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoView declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoView
   */
  public org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoView get_Key$type$org$ednovo$gooru$client$mvp$play$collection$info$ResourceInfoView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoView result = org$ednovo$gooru$client$mvp$play$collection$info$ResourceInfoView_org$ednovo$gooru$client$mvp$play$collection$info$ResourceInfoView_methodInjection();
    memberInject_Key$type$org$ednovo$gooru$client$mvp$play$collection$info$ResourceInfoView$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoView org$ednovo$gooru$client$mvp$play$collection$info$ResourceInfoView_org$ednovo$gooru$client$mvp$play$collection$info$ResourceInfoView_methodInjection() {
    return new org.ednovo.gooru.client.mvp.play.collection.info.ResourceInfoView();
  }
  
  
  /**
   * Field for the enclosing injector.
   */
  private final org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector;
  public org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment(org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector) {
    this.injector = injector;
  }
  
}
