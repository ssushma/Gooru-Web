package org.ednovo.gooru.client.mvp.classpages.classlist;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public native void org$ednovo$gooru$client$mvp$classpages$classlist$ClassListPresenter_classpageServiceAsync_fieldInjection(org.ednovo.gooru.client.mvp.classpages.classlist.ClassListPresenter injectee, org.ednovo.gooru.client.service.ClasspageServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.classpages.classlist.ClassListPresenter::classpageServiceAsync = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$classpages$classlist$ClassListPresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.classpages.classlist.ClassListPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection________________________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$classpages$classlist$ClassListPresenter_classpageServiceAsync_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$ClasspageServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$classpages$classlist$ClassListView$_annotation$$none$$(org.ednovo.gooru.client.mvp.classpages.classlist.ClassListView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.classpages.classlist.IsClassListView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenterWidget(AbstractPresenterModule.java:265)
   */
  public org.ednovo.gooru.client.mvp.classpages.classlist.IsClassListView get_Key$type$org$ednovo$gooru$client$mvp$classpages$classlist$IsClassListView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.classpages.classlist.IsClassListView result = get_Key$type$org$ednovo$gooru$client$mvp$classpages$classlist$ClassListView$_annotation$$none$$();
    return result;
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.classpages.classlist.ClassListPresenter declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.classpages.classlist.ClassListPresenter
   */
  public org.ednovo.gooru.client.mvp.classpages.classlist.ClassListPresenter get_Key$type$org$ednovo$gooru$client$mvp$classpages$classlist$ClassListPresenter$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.classpages.classlist.ClassListPresenter result = org$ednovo$gooru$client$mvp$classpages$classlist$ClassListPresenter_org$ednovo$gooru$client$mvp$classpages$classlist$ClassListPresenter_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$classpages$classlist$IsClassListView$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$classpages$classlist$ClassListPresenter$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.classpages.classlist.ClassListPresenter org$ednovo$gooru$client$mvp$classpages$classlist$ClassListPresenter_org$ednovo$gooru$client$mvp$classpages$classlist$ClassListPresenter_methodInjection(com.google.gwt.event.shared.EventBus _0, org.ednovo.gooru.client.mvp.classpages.classlist.IsClassListView _1) {
    return new org.ednovo.gooru.client.mvp.classpages.classlist.ClassListPresenter(_0, _1);
  }
  
  
  /**
   * Binding for com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.classpages.classlist.ClassListPresenter> declared at:
   *   Implicit injection of com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.classpages.classlist.ClassListPresenter>
   */
  public com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.classpages.classlist.ClassListPresenter> get_Key$type$com$google$gwt$inject$client$AsyncProvider$org$ednovo$gooru$client$mvp$classpages$classlist$ClassListPresenter$$_annotation$$none$$() {
    com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.classpages.classlist.ClassListPresenter> result = new com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.classpages.classlist.ClassListPresenter>() { 
        public void get(final com.google.gwt.user.client.rpc.AsyncCallback<? super org.ednovo.gooru.client.mvp.classpages.classlist.ClassListPresenter> callback) { 
          com.google.gwt.core.client.GWT.runAsync(org.ednovo.gooru.client.mvp.classpages.classlist.ClassListPresenter.class,new com.google.gwt.core.client.RunAsyncCallback() { 
            public void onSuccess() { 
              callback.onSuccess(get_Key$type$org$ednovo$gooru$client$mvp$classpages$classlist$ClassListPresenter$_annotation$$none$$());
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
   * Binding for org.ednovo.gooru.client.mvp.classpages.classlist.ClassListView declared at:
   *   Implicit GWT.create binding for org.ednovo.gooru.client.mvp.classpages.classlist.ClassListView
   */
  public org.ednovo.gooru.client.mvp.classpages.classlist.ClassListView get_Key$type$org$ednovo$gooru$client$mvp$classpages$classlist$ClassListView$_annotation$$none$$() {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.classpages.classlist.ClassListView.class);
    assert created instanceof org.ednovo.gooru.client.mvp.classpages.classlist.ClassListView;
    org.ednovo.gooru.client.mvp.classpages.classlist.ClassListView result = (org.ednovo.gooru.client.mvp.classpages.classlist.ClassListView) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$classpages$classlist$ClassListView$_annotation$$none$$(result);
    
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
