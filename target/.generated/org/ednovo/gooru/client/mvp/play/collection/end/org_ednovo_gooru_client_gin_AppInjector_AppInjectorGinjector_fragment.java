package org.ednovo.gooru.client.mvp.play.collection.end;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public native void org$ednovo$gooru$client$mvp$play$collection$end$CollectionEndPresenter_playerAppService_fieldInjection(org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndPresenter injectee, org.ednovo.gooru.client.service.PlayerAppServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndPresenter::playerAppService = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$play$collection$end$CollectionEndPresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection_______________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$play$collection$end$CollectionEndPresenter_playerAppService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$PlayerAppServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$play$collection$end$CollectionEndView$_annotation$$none$$(org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.play.collection.end.IsCollectionEndView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenterWidget(AbstractPresenterModule.java:265)
   */
  public org.ednovo.gooru.client.mvp.play.collection.end.IsCollectionEndView get_Key$type$org$ednovo$gooru$client$mvp$play$collection$end$IsCollectionEndView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.play.collection.end.IsCollectionEndView result = get_Key$type$org$ednovo$gooru$client$mvp$play$collection$end$CollectionEndView$_annotation$$none$$();
    return result;
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndPresenter declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndPresenter
   */
  public org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndPresenter get_Key$type$org$ednovo$gooru$client$mvp$play$collection$end$CollectionEndPresenter$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndPresenter result = org$ednovo$gooru$client$mvp$play$collection$end$CollectionEndPresenter_org$ednovo$gooru$client$mvp$play$collection$end$CollectionEndPresenter_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$play$collection$end$IsCollectionEndView$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$play$collection$end$CollectionEndPresenter$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndPresenter org$ednovo$gooru$client$mvp$play$collection$end$CollectionEndPresenter_org$ednovo$gooru$client$mvp$play$collection$end$CollectionEndPresenter_methodInjection(com.google.gwt.event.shared.EventBus _0, org.ednovo.gooru.client.mvp.play.collection.end.IsCollectionEndView _1) {
    return new org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndPresenter(_0, _1);
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndView declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndView
   */
  public org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndView get_Key$type$org$ednovo$gooru$client$mvp$play$collection$end$CollectionEndView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndView result = org$ednovo$gooru$client$mvp$play$collection$end$CollectionEndView_org$ednovo$gooru$client$mvp$play$collection$end$CollectionEndView_methodInjection();
    memberInject_Key$type$org$ednovo$gooru$client$mvp$play$collection$end$CollectionEndView$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndView org$ednovo$gooru$client$mvp$play$collection$end$CollectionEndView_org$ednovo$gooru$client$mvp$play$collection$end$CollectionEndView_methodInjection() {
    return new org.ednovo.gooru.client.mvp.play.collection.end.CollectionEndView();
  }
  
  
  /**
   * Field for the enclosing injector.
   */
  private final org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector;
  public org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment(org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector) {
    this.injector = injector;
  }
  
}
