package org.ednovo.gooru.client.mvp.play.collection.flag;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public native void org$ednovo$gooru$client$mvp$play$collection$flag$CollectionFlagPresenter_playerAppService_fieldInjection(org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagPresenter injectee, org.ednovo.gooru.client.service.PlayerAppServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagPresenter::playerAppService = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$play$collection$flag$CollectionFlagPresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection_______________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$play$collection$flag$CollectionFlagPresenter_playerAppService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$PlayerAppServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$play$collection$flag$CollectionFlagView$_annotation$$none$$(org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.play.collection.flag.IsCollectionFlagView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenterWidget(AbstractPresenterModule.java:265)
   */
  public org.ednovo.gooru.client.mvp.play.collection.flag.IsCollectionFlagView get_Key$type$org$ednovo$gooru$client$mvp$play$collection$flag$IsCollectionFlagView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.play.collection.flag.IsCollectionFlagView result = get_Key$type$org$ednovo$gooru$client$mvp$play$collection$flag$CollectionFlagView$_annotation$$none$$();
    return result;
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagPresenter declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagPresenter
   */
  public org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagPresenter get_Key$type$org$ednovo$gooru$client$mvp$play$collection$flag$CollectionFlagPresenter$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagPresenter result = org$ednovo$gooru$client$mvp$play$collection$flag$CollectionFlagPresenter_org$ednovo$gooru$client$mvp$play$collection$flag$CollectionFlagPresenter_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$play$collection$flag$IsCollectionFlagView$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$play$collection$flag$CollectionFlagPresenter$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagPresenter org$ednovo$gooru$client$mvp$play$collection$flag$CollectionFlagPresenter_org$ednovo$gooru$client$mvp$play$collection$flag$CollectionFlagPresenter_methodInjection(com.google.gwt.event.shared.EventBus _0, org.ednovo.gooru.client.mvp.play.collection.flag.IsCollectionFlagView _1) {
    return new org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagPresenter(_0, _1);
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagView declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagView
   */
  public org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagView get_Key$type$org$ednovo$gooru$client$mvp$play$collection$flag$CollectionFlagView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagView result = org$ednovo$gooru$client$mvp$play$collection$flag$CollectionFlagView_org$ednovo$gooru$client$mvp$play$collection$flag$CollectionFlagView_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$play$collection$flag$CollectionFlagView$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagView org$ednovo$gooru$client$mvp$play$collection$flag$CollectionFlagView_org$ednovo$gooru$client$mvp$play$collection$flag$CollectionFlagView_methodInjection(com.google.gwt.event.shared.EventBus _0) {
    return new org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagView(_0);
  }
  
  
  /**
   * Field for the enclosing injector.
   */
  private final org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector;
  public org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment(org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector) {
    this.injector = injector;
  }
  
}
