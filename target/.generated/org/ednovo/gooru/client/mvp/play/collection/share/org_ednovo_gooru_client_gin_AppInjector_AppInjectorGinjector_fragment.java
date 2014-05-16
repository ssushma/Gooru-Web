package org.ednovo.gooru.client.mvp.play.collection.share;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$play$collection$share$CollectionSharePresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.play.collection.share.CollectionSharePresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection__________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$play$collection$share$CollectionShareView$_annotation$$none$$(org.ednovo.gooru.client.mvp.play.collection.share.CollectionShareView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.play.collection.share.IsCollectionShareView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenterWidget(AbstractPresenterModule.java:265)
   */
  public org.ednovo.gooru.client.mvp.play.collection.share.IsCollectionShareView get_Key$type$org$ednovo$gooru$client$mvp$play$collection$share$IsCollectionShareView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.play.collection.share.IsCollectionShareView result = get_Key$type$org$ednovo$gooru$client$mvp$play$collection$share$CollectionShareView$_annotation$$none$$();
    return result;
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.play.collection.share.CollectionSharePresenter declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.play.collection.share.CollectionSharePresenter
   */
  public org.ednovo.gooru.client.mvp.play.collection.share.CollectionSharePresenter get_Key$type$org$ednovo$gooru$client$mvp$play$collection$share$CollectionSharePresenter$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.play.collection.share.CollectionSharePresenter result = org$ednovo$gooru$client$mvp$play$collection$share$CollectionSharePresenter_org$ednovo$gooru$client$mvp$play$collection$share$CollectionSharePresenter_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$play$collection$share$IsCollectionShareView$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$play$collection$share$CollectionSharePresenter$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.play.collection.share.CollectionSharePresenter org$ednovo$gooru$client$mvp$play$collection$share$CollectionSharePresenter_org$ednovo$gooru$client$mvp$play$collection$share$CollectionSharePresenter_methodInjection(com.google.gwt.event.shared.EventBus _0, org.ednovo.gooru.client.mvp.play.collection.share.IsCollectionShareView _1) {
    return new org.ednovo.gooru.client.mvp.play.collection.share.CollectionSharePresenter(_0, _1);
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.play.collection.share.CollectionShareView declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.play.collection.share.CollectionShareView
   */
  public org.ednovo.gooru.client.mvp.play.collection.share.CollectionShareView get_Key$type$org$ednovo$gooru$client$mvp$play$collection$share$CollectionShareView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.play.collection.share.CollectionShareView result = org$ednovo$gooru$client$mvp$play$collection$share$CollectionShareView_org$ednovo$gooru$client$mvp$play$collection$share$CollectionShareView_methodInjection();
    memberInject_Key$type$org$ednovo$gooru$client$mvp$play$collection$share$CollectionShareView$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.play.collection.share.CollectionShareView org$ednovo$gooru$client$mvp$play$collection$share$CollectionShareView_org$ednovo$gooru$client$mvp$play$collection$share$CollectionShareView_methodInjection() {
    return new org.ednovo.gooru.client.mvp.play.collection.share.CollectionShareView();
  }
  
  
  /**
   * Field for the enclosing injector.
   */
  private final org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector;
  public org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment(org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector) {
    this.injector = injector;
  }
  
}
