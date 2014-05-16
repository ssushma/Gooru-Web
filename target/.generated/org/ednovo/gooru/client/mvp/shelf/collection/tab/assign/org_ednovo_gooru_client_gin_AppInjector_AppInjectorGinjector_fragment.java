package org.ednovo.gooru.client.mvp.shelf.collection.tab.assign;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public native void org$ednovo$gooru$client$mvp$shelf$collection$tab$assign$CollectionAssignTabPresenter_classpageService_fieldInjection(org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabPresenter injectee, org.ednovo.gooru.client.service.ClasspageServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabPresenter::classpageService = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$assign$CollectionAssignTabPresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection_____(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$shelf$collection$tab$assign$CollectionAssignTabPresenter_classpageService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$ClasspageServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$assign$CollectionAssignTabView$_annotation$$none$$(org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.IsCollectionAssignTab declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenterWidget(AbstractPresenterModule.java:265)
   */
  public org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.IsCollectionAssignTab get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$assign$IsCollectionAssignTab$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.IsCollectionAssignTab result = get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$assign$CollectionAssignTabView$_annotation$$none$$();
    return result;
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabPresenter declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabPresenter
   */
  public org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabPresenter get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$assign$CollectionAssignTabPresenter$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabPresenter result = org$ednovo$gooru$client$mvp$shelf$collection$tab$assign$CollectionAssignTabPresenter_org$ednovo$gooru$client$mvp$shelf$collection$tab$assign$CollectionAssignTabPresenter_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$assign$IsCollectionAssignTab$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$assign$CollectionAssignTabPresenter$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabPresenter org$ednovo$gooru$client$mvp$shelf$collection$tab$assign$CollectionAssignTabPresenter_org$ednovo$gooru$client$mvp$shelf$collection$tab$assign$CollectionAssignTabPresenter_methodInjection(com.google.gwt.event.shared.EventBus _0, org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.IsCollectionAssignTab _1) {
    return new org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabPresenter(_0, _1);
  }
  
  
  /**
   * Binding for com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabPresenter> declared at:
   *   Implicit injection of com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabPresenter>
   */
  public com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabPresenter> get_Key$type$com$google$gwt$inject$client$AsyncProvider$org$ednovo$gooru$client$mvp$shelf$collection$tab$assign$CollectionAssignTabPresenter$$_annotation$$none$$() {
    com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabPresenter> result = new com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabPresenter>() { 
        public void get(final com.google.gwt.user.client.rpc.AsyncCallback<? super org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabPresenter> callback) { 
          com.google.gwt.core.client.GWT.runAsync(org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabPresenter.class,new com.google.gwt.core.client.RunAsyncCallback() { 
            public void onSuccess() { 
              callback.onSuccess(get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$assign$CollectionAssignTabPresenter$_annotation$$none$$());
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
   * Binding for org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabView declared at:
   *   Implicit GWT.create binding for org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabView
   */
  public org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabView get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$assign$CollectionAssignTabView$_annotation$$none$$() {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabView.class);
    assert created instanceof org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabView;
    org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabView result = (org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignTabView) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$assign$CollectionAssignTabView$_annotation$$none$$(result);
    
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
