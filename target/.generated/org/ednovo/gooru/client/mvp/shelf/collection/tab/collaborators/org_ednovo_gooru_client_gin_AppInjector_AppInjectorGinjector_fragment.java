package org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public native void org$ednovo$gooru$client$mvp$shelf$collection$tab$collaborators$CollectionCollaboratorsTabPresenter_collaboratorsService_fieldInjection(org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.CollectionCollaboratorsTabPresenter injectee, org.ednovo.gooru.client.service.CollaboratorsServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.CollectionCollaboratorsTabPresenter::collaboratorsService = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$collaborators$CollectionCollaboratorsTabPresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.CollectionCollaboratorsTabPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection______(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$shelf$collection$tab$collaborators$CollectionCollaboratorsTabPresenter_collaboratorsService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$CollaboratorsServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$collaborators$CollectionCollaboratorsTabView$_annotation$$none$$(org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.CollectionCollaboratorsTabView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.IsCollectionCollaboratorsTab declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenterWidget(AbstractPresenterModule.java:265)
   */
  public org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.IsCollectionCollaboratorsTab get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$collaborators$IsCollectionCollaboratorsTab$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.IsCollectionCollaboratorsTab result = get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$collaborators$CollectionCollaboratorsTabView$_annotation$$none$$();
    return result;
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.CollectionCollaboratorsTabPresenter declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.CollectionCollaboratorsTabPresenter
   */
  public org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.CollectionCollaboratorsTabPresenter get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$collaborators$CollectionCollaboratorsTabPresenter$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.CollectionCollaboratorsTabPresenter result = org$ednovo$gooru$client$mvp$shelf$collection$tab$collaborators$CollectionCollaboratorsTabPresenter_org$ednovo$gooru$client$mvp$shelf$collection$tab$collaborators$CollectionCollaboratorsTabPresenter_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$collaborators$IsCollectionCollaboratorsTab$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$collaborators$CollectionCollaboratorsTabPresenter$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.CollectionCollaboratorsTabPresenter org$ednovo$gooru$client$mvp$shelf$collection$tab$collaborators$CollectionCollaboratorsTabPresenter_org$ednovo$gooru$client$mvp$shelf$collection$tab$collaborators$CollectionCollaboratorsTabPresenter_methodInjection(com.google.gwt.event.shared.EventBus _0, org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.IsCollectionCollaboratorsTab _1) {
    return new org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.CollectionCollaboratorsTabPresenter(_0, _1);
  }
  
  
  /**
   * Binding for com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.CollectionCollaboratorsTabPresenter> declared at:
   *   Implicit injection of com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.CollectionCollaboratorsTabPresenter>
   */
  public com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.CollectionCollaboratorsTabPresenter> get_Key$type$com$google$gwt$inject$client$AsyncProvider$org$ednovo$gooru$client$mvp$shelf$collection$tab$collaborators$CollectionCollaboratorsTabPresenter$$_annotation$$none$$() {
    com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.CollectionCollaboratorsTabPresenter> result = new com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.CollectionCollaboratorsTabPresenter>() { 
        public void get(final com.google.gwt.user.client.rpc.AsyncCallback<? super org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.CollectionCollaboratorsTabPresenter> callback) { 
          com.google.gwt.core.client.GWT.runAsync(org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.CollectionCollaboratorsTabPresenter.class,new com.google.gwt.core.client.RunAsyncCallback() { 
            public void onSuccess() { 
              callback.onSuccess(get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$collaborators$CollectionCollaboratorsTabPresenter$_annotation$$none$$());
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
   * Binding for org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.CollectionCollaboratorsTabView declared at:
   *   Implicit GWT.create binding for org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.CollectionCollaboratorsTabView
   */
  public org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.CollectionCollaboratorsTabView get_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$collaborators$CollectionCollaboratorsTabView$_annotation$$none$$() {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.CollectionCollaboratorsTabView.class);
    assert created instanceof org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.CollectionCollaboratorsTabView;
    org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.CollectionCollaboratorsTabView result = (org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.CollectionCollaboratorsTabView) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$shelf$collection$tab$collaborators$CollectionCollaboratorsTabView$_annotation$$none$$(result);
    
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
