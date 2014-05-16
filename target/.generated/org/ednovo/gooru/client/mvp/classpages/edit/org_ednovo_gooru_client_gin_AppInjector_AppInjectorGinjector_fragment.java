package org.ednovo.gooru.client.mvp.classpages.edit;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$classpages$edit$EditClasspagePresenter$IsEditClasspageProxy$_annotation$$none$$(org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter.IsEditClasspageProxy injectee) {
    
  }
  
  public native void org$ednovo$gooru$client$mvp$classpages$edit$EditClasspagePresenter_classpageService_fieldInjection(org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter injectee, org.ednovo.gooru.client.service.ClasspageServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter::classpageService = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$classpages$edit$EditClasspagePresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection_________________________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$classpages$edit$EditClasspagePresenter_classpageService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$ClasspageServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$classpages$edit$EditClasspageView$_annotation$$none$$(org.ednovo.gooru.client.mvp.classpages.edit.EditClasspageView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.classpages.edit.IsEditClasspageView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:126)
   */
  public org.ednovo.gooru.client.mvp.classpages.edit.IsEditClasspageView get_Key$type$org$ednovo$gooru$client$mvp$classpages$edit$IsEditClasspageView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.classpages.edit.IsEditClasspageView result = get_Key$type$org$ednovo$gooru$client$mvp$classpages$edit$EditClasspageView$_annotation$$none$$();
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter.IsEditClasspageProxy singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$edit$EditClasspagePresenter$IsEditClasspageProxy$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter.IsEditClasspageProxy get_Key$type$org$ednovo$gooru$client$mvp$classpages$edit$EditClasspagePresenter$IsEditClasspageProxy$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$edit$EditClasspagePresenter$IsEditClasspageProxy$_annotation$$none$$ == null) {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter.IsEditClasspageProxy.class);
    assert created instanceof org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter.IsEditClasspageProxy;
    org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter.IsEditClasspageProxy result = (org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter.IsEditClasspageProxy) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$classpages$edit$EditClasspagePresenter$IsEditClasspageProxy$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$edit$EditClasspagePresenter$IsEditClasspageProxy$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$edit$EditClasspagePresenter$IsEditClasspageProxy$_annotation$$none$$;
    
  }
  
  private org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$edit$EditClasspagePresenter$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter get_Key$type$org$ednovo$gooru$client$mvp$classpages$edit$EditClasspagePresenter$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$edit$EditClasspagePresenter$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter result = org$ednovo$gooru$client$mvp$classpages$edit$EditClasspagePresenter_org$ednovo$gooru$client$mvp$classpages$edit$EditClasspagePresenter_methodInjection(get_Key$type$org$ednovo$gooru$client$mvp$classpages$edit$IsEditClasspageView$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$classpages$edit$EditClasspagePresenter$IsEditClasspageProxy$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_classpages_assignments().get_Key$type$org$ednovo$gooru$client$mvp$classpages$assignments$AddAssignmentContainerPresenter$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_image_upload().get_Key$type$org$ednovo$gooru$client$mvp$image$upload$ImageUploadPresenter$_annotation$$none$$(), injector.getFragment_org_ednovo_gooru_client_mvp_classpages_classlist().get_Key$type$org$ednovo$gooru$client$mvp$classpages$classlist$ClassListPresenter$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$classpages$edit$EditClasspagePresenter$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$edit$EditClasspagePresenter$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$edit$EditClasspagePresenter$_annotation$$none$$;
    
  }
  
  public org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter org$ednovo$gooru$client$mvp$classpages$edit$EditClasspagePresenter_org$ednovo$gooru$client$mvp$classpages$edit$EditClasspagePresenter_methodInjection(org.ednovo.gooru.client.mvp.classpages.edit.IsEditClasspageView _0, org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter.IsEditClasspageProxy _1, org.ednovo.gooru.client.mvp.classpages.assignments.AddAssignmentContainerPresenter _2, org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter _3, org.ednovo.gooru.client.mvp.classpages.classlist.ClassListPresenter _4) {
    return new org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter(_0, _1, _2, _3, _4);
  }
  
  
  /**
   * Binding for com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter> declared at:
   *   Implicit injection of com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter>
   */
  public com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter> get_Key$type$com$google$gwt$inject$client$AsyncProvider$org$ednovo$gooru$client$mvp$classpages$edit$EditClasspagePresenter$$_annotation$$none$$() {
    com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter> result = new com.google.gwt.inject.client.AsyncProvider<org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter>() { 
        public void get(final com.google.gwt.user.client.rpc.AsyncCallback<? super org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter> callback) { 
          com.google.gwt.core.client.GWT.runAsync(org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter.class,new com.google.gwt.core.client.RunAsyncCallback() { 
            public void onSuccess() { 
              callback.onSuccess(get_Key$type$org$ednovo$gooru$client$mvp$classpages$edit$EditClasspagePresenter$_annotation$$none$$());
            }
            public void onFailure(Throwable ex) { 
               callback.onFailure(ex); 
            } 
        }); 
        }
     };
    
    return result;
    
  }
  
  private org.ednovo.gooru.client.mvp.classpages.edit.EditClasspageView singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$edit$EditClasspageView$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.mvp.classpages.edit.EditClasspageView get_Key$type$org$ednovo$gooru$client$mvp$classpages$edit$EditClasspageView$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$edit$EditClasspageView$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.mvp.classpages.edit.EditClasspageView result = org$ednovo$gooru$client$mvp$classpages$edit$EditClasspageView_org$ednovo$gooru$client$mvp$classpages$edit$EditClasspageView_methodInjection();
    memberInject_Key$type$org$ednovo$gooru$client$mvp$classpages$edit$EditClasspageView$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$edit$EditClasspageView$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$mvp$classpages$edit$EditClasspageView$_annotation$$none$$;
    
  }
  
  public org.ednovo.gooru.client.mvp.classpages.edit.EditClasspageView org$ednovo$gooru$client$mvp$classpages$edit$EditClasspageView_org$ednovo$gooru$client$mvp$classpages$edit$EditClasspageView_methodInjection() {
    return new org.ednovo.gooru.client.mvp.classpages.edit.EditClasspageView();
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
    //   Implicit GWT.create binding for org.ednovo.gooru.client.mvp.classpages.edit.EditClasspagePresenter$IsEditClasspageProxy
    get_Key$type$org$ednovo$gooru$client$mvp$classpages$edit$EditClasspagePresenter$IsEditClasspageProxy$_annotation$$none$$();
    
  }
  
}
