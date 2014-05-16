package org.ednovo.gooru.client.mvp.image.upload;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public native void org$ednovo$gooru$client$mvp$image$upload$ImageUploadPresenter_mediaUploadService_fieldInjection(org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter injectee, org.ednovo.gooru.client.service.MediaUploadServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter::mediaUploadService = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$image$upload$ImageUploadPresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection__________________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$image$upload$ImageUploadPresenter_mediaUploadService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$MediaUploadServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$image$upload$ImageUploadView$_annotation$$none$$(org.ednovo.gooru.client.mvp.image.upload.ImageUploadView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.image.upload.IsImageUploadView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenterWidget(AbstractPresenterModule.java:265)
   */
  public org.ednovo.gooru.client.mvp.image.upload.IsImageUploadView get_Key$type$org$ednovo$gooru$client$mvp$image$upload$IsImageUploadView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.image.upload.IsImageUploadView result = get_Key$type$org$ednovo$gooru$client$mvp$image$upload$ImageUploadView$_annotation$$none$$();
    return result;
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter
   */
  public org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter get_Key$type$org$ednovo$gooru$client$mvp$image$upload$ImageUploadPresenter$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter result = org$ednovo$gooru$client$mvp$image$upload$ImageUploadPresenter_org$ednovo$gooru$client$mvp$image$upload$ImageUploadPresenter_methodInjection(injector.getFragment_org_ednovo_gooru_client_mvp_shelf().get_Key$type$org$ednovo$gooru$client$mvp$shelf$IsShelfView$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_shelf_collection_tab_resource_add().get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$resource$add$IsAddResourceView$_annotation$$none$$(), injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$image$upload$IsImageUploadView$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$image$upload$ImageUploadPresenter$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter org$ednovo$gooru$client$mvp$image$upload$ImageUploadPresenter_org$ednovo$gooru$client$mvp$image$upload$ImageUploadPresenter_methodInjection(org.ednovo.gooru.client.mvp.shelf.IsShelfView _0, org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.IsAddResourceView _1, com.google.gwt.event.shared.EventBus _2, org.ednovo.gooru.client.mvp.image.upload.IsImageUploadView _3) {
    return new org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter(_0, _1, _2, _3);
  }
  
  
  /**
   * Binding for com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter> declared at:
   *   Implicit injection of com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter>
   */
  public com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter> get_Key$type$com$google$gwt$inject$client$AsyncProvider$org$ednovo$gooru$client$mvp$image$upload$ImageUploadPresenter$$_annotation$$none$$() {
    com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter> result = new com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter>() { 
        public void get(final com.google.gwt.user.client.rpc.AsyncCallback<? super org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter> callback) { 
          com.google.gwt.core.client.GWT.runAsync(org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter.class,new com.google.gwt.core.client.RunAsyncCallback() { 
            public void onSuccess() { 
              callback.onSuccess(get_Key$type$org$ednovo$gooru$client$mvp$image$upload$ImageUploadPresenter$_annotation$$none$$());
            }
            public void onFailure(Throwable ex) { 
               callback.onFailure(ex); 
            } 
        }); 
        }
     };
    
    return result;
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.image.upload.ImageUploadView declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.image.upload.ImageUploadView
   */
  public org.ednovo.gooru.client.mvp.image.upload.ImageUploadView get_Key$type$org$ednovo$gooru$client$mvp$image$upload$ImageUploadView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.image.upload.ImageUploadView result = org$ednovo$gooru$client$mvp$image$upload$ImageUploadView_org$ednovo$gooru$client$mvp$image$upload$ImageUploadView_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$image$upload$ImageUploadView$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.image.upload.ImageUploadView org$ednovo$gooru$client$mvp$image$upload$ImageUploadView_org$ednovo$gooru$client$mvp$image$upload$ImageUploadView_methodInjection(com.google.gwt.event.shared.EventBus _0) {
    return new org.ednovo.gooru.client.mvp.image.upload.ImageUploadView(_0);
  }
  
  
  /**
   * Field for the enclosing injector.
   */
  private final org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector;
  public org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment(org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector) {
    this.injector = injector;
  }
  
}
