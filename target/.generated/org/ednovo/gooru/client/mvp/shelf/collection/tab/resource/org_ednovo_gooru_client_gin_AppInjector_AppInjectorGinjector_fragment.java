package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public native void org$ednovo$gooru$client$mvp$shelf$collection$tab$resource$CollectionResourceTabPresenter_resourceService_fieldInjection(org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabPresenter injectee, org.ednovo.gooru.client.service.ResourceServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabPresenter::resourceService = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$resource$CollectionResourceTabPresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection____________________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$shelf$collection$tab$resource$CollectionResourceTabPresenter_resourceService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$ResourceServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$resource$CollectionResourceTabView$_annotation$$none$$(org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.IsCollectionResourceTabView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenterWidget(AbstractPresenterModule.java:265)
   */
  public org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.IsCollectionResourceTabView get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$resource$IsCollectionResourceTabView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.IsCollectionResourceTabView result = get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$resource$CollectionResourceTabView$_annotation$$none$$();
    return result;
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabPresenter declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabPresenter
   */
  public org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabPresenter get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$resource$CollectionResourceTabPresenter$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabPresenter result = org$ednovo$gooru$client$mvp$shelf$collection$tab$resource$CollectionResourceTabPresenter_org$ednovo$gooru$client$mvp$shelf$collection$tab$resource$CollectionResourceTabPresenter_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$resource$IsCollectionResourceTabView$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_image_upload().get_Key$type$org$ednovo$gooru$client$mvp$image$upload$ImageUploadPresenter$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_shelf_collection_tab_resource_add().get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$resource$add$AddResourcePresenter$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$resource$CollectionResourceTabPresenter$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabPresenter org$ednovo$gooru$client$mvp$shelf$collection$tab$resource$CollectionResourceTabPresenter_org$ednovo$gooru$client$mvp$shelf$collection$tab$resource$CollectionResourceTabPresenter_methodInjection(com.google.gwt.event.shared.EventBus _0, org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.IsCollectionResourceTabView _1, org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter _2, org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddResourcePresenter _3) {
    return new org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabPresenter(_0, _1, _2, _3);
  }
  
  
  /**
   * Binding for com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabPresenter> declared at:
   *   Implicit injection of com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabPresenter>
   */
  public com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabPresenter> get_Key$type$com$google$gwt$inject$client$AsyncProvider$org$ednovo$gooru$client$mvp$shelf$collection$tab$resource$CollectionResourceTabPresenter$$_annotation$$none$$() {
    com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabPresenter> result = new com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabPresenter>() { 
        public void get(final com.google.gwt.user.client.rpc.AsyncCallback<? super org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabPresenter> callback) { 
          com.google.gwt.core.client.GWT.runAsync(org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabPresenter.class,new com.google.gwt.core.client.RunAsyncCallback() { 
            public void onSuccess() { 
              callback.onSuccess(get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$resource$CollectionResourceTabPresenter$_annotation$$none$$());
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
   * Binding for org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabView declared at:
   *   Implicit GWT.create binding for org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabView
   */
  public org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabView get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$resource$CollectionResourceTabView$_annotation$$none$$() {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabView.class);
    assert created instanceof org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabView;
    org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabView result = (org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabView) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$resource$CollectionResourceTabView$_annotation$$none$$(result);
    
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
