package org.ednovo.gooru.client.mvp.shelf.collection.tab.info;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public native void org$ednovo$gooru$client$mvp$shelf$collection$tab$info$CollectionInfoTabPresenter_searchService_fieldInjection(org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabPresenter injectee, org.ednovo.gooru.client.service.SearchServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabPresenter::searchService = value;
  }-*/;
  
  public native void org$ednovo$gooru$client$mvp$shelf$collection$tab$info$CollectionInfoTabPresenter_taxonomyService_fieldInjection(org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabPresenter injectee, org.ednovo.gooru.client.service.TaxonomyServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabPresenter::taxonomyService = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$info$CollectionInfoTabPresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection_________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$shelf$collection$tab$info$CollectionInfoTabPresenter_searchService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$SearchServiceAsync$_annotation$$none$$());
    
    org$ednovo$gooru$client$mvp$shelf$collection$tab$info$CollectionInfoTabPresenter_taxonomyService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$TaxonomyServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$info$CollectionInfoTabView$_annotation$$none$$(org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.shelf.collection.tab.info.IsCollectionInfoTabView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenterWidget(AbstractPresenterModule.java:265)
   */
  public org.ednovo.gooru.client.mvp.shelf.collection.tab.info.IsCollectionInfoTabView get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$info$IsCollectionInfoTabView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.shelf.collection.tab.info.IsCollectionInfoTabView result = get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$info$CollectionInfoTabView$_annotation$$none$$();
    return result;
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabPresenter declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabPresenter
   */
  public org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabPresenter get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$info$CollectionInfoTabPresenter$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabPresenter result = org$ednovo$gooru$client$mvp$shelf$collection$tab$info$CollectionInfoTabPresenter_org$ednovo$gooru$client$mvp$shelf$collection$tab$info$CollectionInfoTabPresenter_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$info$IsCollectionInfoTabView$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$info$CollectionInfoTabPresenter$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabPresenter org$ednovo$gooru$client$mvp$shelf$collection$tab$info$CollectionInfoTabPresenter_org$ednovo$gooru$client$mvp$shelf$collection$tab$info$CollectionInfoTabPresenter_methodInjection(com.google.gwt.event.shared.EventBus _0, org.ednovo.gooru.client.mvp.shelf.collection.tab.info.IsCollectionInfoTabView _1) {
    return new org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabPresenter(_0, _1);
  }
  
  
  /**
   * Binding for com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabPresenter> declared at:
   *   Implicit injection of com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabPresenter>
   */
  public com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabPresenter> get_Key$type$com$google$gwt$inject$client$AsyncProvider$org$ednovo$gooru$client$mvp$shelf$collection$tab$info$CollectionInfoTabPresenter$$_annotation$$none$$() {
    com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabPresenter> result = new com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabPresenter>() { 
        public void get(final com.google.gwt.user.client.rpc.AsyncCallback<? super org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabPresenter> callback) { 
          com.google.gwt.core.client.GWT.runAsync(org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabPresenter.class,new com.google.gwt.core.client.RunAsyncCallback() { 
            public void onSuccess() { 
              callback.onSuccess(get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$info$CollectionInfoTabPresenter$_annotation$$none$$());
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
   * Binding for org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabView declared at:
   *   Implicit GWT.create binding for org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabView
   */
  public org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabView get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$info$CollectionInfoTabView$_annotation$$none$$() {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabView.class);
    assert created instanceof org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabView;
    org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabView result = (org.ednovo.gooru.client.mvp.shelf.collection.tab.info.CollectionInfoTabView) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$info$CollectionInfoTabView$_annotation$$none$$(result);
    
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
