package org.ednovo.gooru.client.mvp.shelf;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$ShelfPresenter$IsShelfProxy$_annotation$$none$$(org.ednovo.gooru.client.mvp.shelf.ShelfPresenter.IsShelfProxy injectee) {
    
  }
  
  public native void org$ednovo$gooru$client$mvp$shelf$ShelfPresenter_resourceService_fieldInjection(org.ednovo.gooru.client.mvp.shelf.ShelfPresenter injectee, org.ednovo.gooru.client.service.ResourceServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.shelf.ShelfPresenter::resourceService = value;
  }-*/;
  
  public native void org$ednovo$gooru$client$mvp$shelf$ShelfPresenter_shelfService_fieldInjection(org.ednovo.gooru.client.mvp.shelf.ShelfPresenter injectee, org.ednovo.gooru.client.service.ShelfServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.shelf.ShelfPresenter::shelfService = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$ShelfPresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.shelf.ShelfPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection______________________________________________________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$shelf$ShelfPresenter_resourceService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$ResourceServiceAsync$_annotation$$none$$());
    
    org$ednovo$gooru$client$mvp$shelf$ShelfPresenter_shelfService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$ShelfServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$ShelfView$_annotation$$none$$(org.ednovo.gooru.client.mvp.shelf.ShelfView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.shelf.IsShelfView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:126)
   */
  public org.ednovo.gooru.client.mvp.shelf.IsShelfView get_Key$type$org$ednovo$gooru$client$mvp$shelf$IsShelfView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.shelf.IsShelfView result = get_Key$type$org$ednovo$gooru$client$mvp$shelf$ShelfView$_annotation$$none$$();
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.shelf.ShelfPresenter.IsShelfProxy singleton_Key$type$org$ednovo$gooru$client$mvp$shelf$ShelfPresenter$IsShelfProxy$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.shelf.ShelfPresenter.IsShelfProxy get_Key$type$org$ednovo$gooru$client$mvp$shelf$ShelfPresenter$IsShelfProxy$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$shelf$ShelfPresenter$IsShelfProxy$_annotation$$none$$ == null) {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.shelf.ShelfPresenter.IsShelfProxy.class);
    assert created instanceof org.ednovo.gooru.client.mvp.shelf.ShelfPresenter.IsShelfProxy;
    org.ednovo.gooru.client.mvp.shelf.ShelfPresenter.IsShelfProxy result = (org.ednovo.gooru.client.mvp.shelf.ShelfPresenter.IsShelfProxy) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$ShelfPresenter$IsShelfProxy$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$shelf$ShelfPresenter$IsShelfProxy$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$shelf$ShelfPresenter$IsShelfProxy$_annotation$$none$$;
    
  }
  
  private org.ednovo.gooru.client.mvp.shelf.ShelfPresenter singleton_Key$type$org$ednovo$gooru$client$mvp$shelf$ShelfPresenter$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.shelf.ShelfPresenter get_Key$type$org$ednovo$gooru$client$mvp$shelf$ShelfPresenter$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$shelf$ShelfPresenter$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.mvp.shelf.ShelfPresenter result = org$ednovo$gooru$client$mvp$shelf$ShelfPresenter_org$ednovo$gooru$client$mvp$shelf$ShelfPresenter_methodInjection(injector.getFragment_org_ednovo_gooru_client_mvp_image_upload().get_Key$type$org$ednovo$gooru$client$mvp$image$upload$ImageUploadPresenter$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_shelf_list().get_Key$type$org$ednovo$gooru$client$mvp$shelf$list$ShelfListPresenter$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_shelf_collection_tab_resource().get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$resource$CollectionResourceTabPresenter$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_shelf_collection_tab_info().get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$info$CollectionInfoTabPresenter$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_shelf_collection_tab_assign().get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$assign$CollectionAssignTabPresenter$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_shelf_collection_tab_collaborators().get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$collaborators$CollectionCollaboratorsTabPresenter$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_shelf_collection_folders().get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$folders$FolderItemTabPresenter$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$shelf$IsShelfView$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$shelf$ShelfPresenter$IsShelfProxy$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$ShelfPresenter$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$shelf$ShelfPresenter$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$shelf$ShelfPresenter$_annotation$$none$$;
    
  }
  
  public org.ednovo.gooru.client.mvp.shelf.ShelfPresenter org$ednovo$gooru$client$mvp$shelf$ShelfPresenter_org$ednovo$gooru$client$mvp$shelf$ShelfPresenter_methodInjection(org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter _0, org.ednovo.gooru.client.mvp.shelf.list.ShelfListPresenter _1, org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.CollectionResourceTabPresenter _2, org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabPresenter _3, org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabPresenter _4, org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.CollectionCollaboratorsTabPresenter _5, org.ednovo.gooru.client.mvp.shelf.collection.folders.FolderItemTabPresenter _6, org.ednovo.gooru.client.mvp.shelf.IsShelfView _7, org.ednovo.gooru.client.mvp.shelf.ShelfPresenter.IsShelfProxy _8) {
    return new org.ednovo.gooru.client.mvp.shelf.ShelfPresenter(_0, _1, _2, _3, _4, _5, _6, _7, _8);
  }
  
  
  /**
   * Binding for com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.ShelfPresenter> declared at:
   *   Implicit injection of com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.ShelfPresenter>
   */
  public com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.ShelfPresenter> get_Key$type$com$google$gwt$inject$client$AsyncProvider$org$ednovo$gooru$client$mvp$shelf$ShelfPresenter$$_annotation$$none$$() {
    com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.ShelfPresenter> result = new com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.ShelfPresenter>() { 
        public void get(final com.google.gwt.user.client.rpc.AsyncCallback<? super org.ednovo.gooru.client.mvp.shelf.ShelfPresenter> callback) { 
          com.google.gwt.core.client.GWT.runAsync(org.ednovo.gooru.client.mvp.shelf.ShelfPresenter.class,new com.google.gwt.core.client.RunAsyncCallback() { 
            public void onSuccess() { 
              callback.onSuccess(get_Key$type$org$ednovo$gooru$client$mvp$shelf$ShelfPresenter$_annotation$$none$$());
            }
            public void onFailure(Throwable ex) { 
               callback.onFailure(ex); 
            } 
        }); 
        }
     };
    
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.shelf.ShelfView singleton_Key$type$org$ednovo$gooru$client$mvp$shelf$ShelfView$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.shelf.ShelfView get_Key$type$org$ednovo$gooru$client$mvp$shelf$ShelfView$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$shelf$ShelfView$_annotation$$none$$ == null) {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.shelf.ShelfView.class);
    assert created instanceof org.ednovo.gooru.client.mvp.shelf.ShelfView;
    org.ednovo.gooru.client.mvp.shelf.ShelfView result = (org.ednovo.gooru.client.mvp.shelf.ShelfView) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$ShelfView$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$shelf$ShelfView$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$shelf$ShelfView$_annotation$$none$$;
    
  }
  
  
  /**
   * Field for the enclosing injector.
   */
  private final org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector;
  public org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment(org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector) {
    this.injector = injector;
  }
  
  public void initializeEagerSingletons() {
    // Eager singleton bound at:
    //   Implicit GWT.create binding for org.ednovo.gooru.client.mvp.shelf.ShelfPresenter$IsShelfProxy
    get_Key$type$org$ednovo$gooru$client$mvp$shelf$ShelfPresenter$IsShelfProxy$_annotation$$none$$();
    
  }
  
}
