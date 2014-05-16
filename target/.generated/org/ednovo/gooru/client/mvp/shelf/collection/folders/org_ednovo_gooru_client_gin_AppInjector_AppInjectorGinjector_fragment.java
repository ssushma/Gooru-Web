package org.ednovo.gooru.client.mvp.shelf.collection.folders;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public native void org$ednovo$gooru$client$mvp$shelf$collection$folders$FolderItemTabPresenter_folderService_fieldInjection(org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabPresenter injectee, org.ednovo.gooru.client.service.FolderServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabPresenter::folderService = value;
  }-*/;
  
  public native void org$ednovo$gooru$client$mvp$shelf$collection$folders$FolderItemTabPresenter_resourceService_fieldInjection(org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabPresenter injectee, org.ednovo.gooru.client.service.ResourceServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabPresenter::resourceService = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$folders$FolderItemTabPresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection________________________________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$shelf$collection$folders$FolderItemTabPresenter_folderService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$FolderServiceAsync$_annotation$$none$$());
    
    org$ednovo$gooru$client$mvp$shelf$collection$folders$FolderItemTabPresenter_resourceService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$ResourceServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$folders$FolderItemTabView$_annotation$$none$$(org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.shelf.collection.folders.IsFolderItemTabView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenterWidget(AbstractPresenterModule.java:265)
   */
  public org.ednovo.gooru.client.mvp.shelf.collection.folders.IsFolderItemTabView get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$folders$IsFolderItemTabView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.shelf.collection.folders.IsFolderItemTabView result = get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$folders$FolderItemTabView$_annotation$$none$$();
    return result;
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabPresenter declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabPresenter
   */
  public org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabPresenter get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$folders$FolderItemTabPresenter$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabPresenter result = org$ednovo$gooru$client$mvp$shelf$collection$folders$FolderItemTabPresenter_org$ednovo$gooru$client$mvp$shelf$collection$folders$FolderItemTabPresenter_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$folders$IsFolderItemTabView$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$folders$FolderItemTabPresenter$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabPresenter org$ednovo$gooru$client$mvp$shelf$collection$folders$FolderItemTabPresenter_org$ednovo$gooru$client$mvp$shelf$collection$folders$FolderItemTabPresenter_methodInjection(com.google.gwt.event.shared.EventBus _0, org.ednovo.gooru.client.mvp.shelf.collection.folders.IsFolderItemTabView _1) {
    return new org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabPresenter(_0, _1);
  }
  
  
  /**
   * Binding for com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabPresenter> declared at:
   *   Implicit injection of com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabPresenter>
   */
  public com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabPresenter> get_Key$type$com$google$gwt$inject$client$AsyncProvider$org$ednovo$gooru$client$mvp$shelf$collection$folders$FolderItemTabPresenter$$_annotation$$none$$() {
    com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabPresenter> result = new com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabPresenter>() { 
        public void get(final com.google.gwt.user.client.rpc.AsyncCallback<? super org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabPresenter> callback) { 
          com.google.gwt.core.client.GWT.runAsync(org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabPresenter.class,new com.google.gwt.core.client.RunAsyncCallback() { 
            public void onSuccess() { 
              callback.onSuccess(get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$folders$FolderItemTabPresenter$_annotation$$none$$());
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
   * Binding for org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabView declared at:
   *   Implicit GWT.create binding for org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabView
   */
  public org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabView get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$folders$FolderItemTabView$_annotation$$none$$() {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabView.class);
    assert created instanceof org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabView;
    org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabView result = (org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabView) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$folders$FolderItemTabView$_annotation$$none$$(result);
    
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
