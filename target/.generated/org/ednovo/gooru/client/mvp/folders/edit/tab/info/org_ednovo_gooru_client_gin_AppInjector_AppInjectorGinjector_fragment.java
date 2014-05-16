package org.ednovo.gooru.client.mvp.folders.edit.tab.info;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public native void org$ednovo$gooru$client$mvp$folders$edit$tab$info$FolderInfoTabPresenter_folderService_fieldInjection(org.ednovo.gooru.client.mvp.folders.edit.tab.info.FolderInfoTabPresenter injectee, org.ednovo.gooru.client.service.FolderServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.folders.edit.tab.info.FolderInfoTabPresenter::folderService = value;
  }-*/;
  
  public native void org$ednovo$gooru$client$mvp$folders$edit$tab$info$FolderInfoTabPresenter_searchService_fieldInjection(org.ednovo.gooru.client.mvp.folders.edit.tab.info.FolderInfoTabPresenter injectee, org.ednovo.gooru.client.service.SearchServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.folders.edit.tab.info.FolderInfoTabPresenter::searchService = value;
  }-*/;
  
  public native void org$ednovo$gooru$client$mvp$folders$edit$tab$info$FolderInfoTabPresenter_taxonomyService_fieldInjection(org.ednovo.gooru.client.mvp.folders.edit.tab.info.FolderInfoTabPresenter injectee, org.ednovo.gooru.client.service.TaxonomyServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.folders.edit.tab.info.FolderInfoTabPresenter::taxonomyService = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$folders$edit$tab$info$FolderInfoTabPresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.folders.edit.tab.info.FolderInfoTabPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection___________________________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$folders$edit$tab$info$FolderInfoTabPresenter_folderService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$FolderServiceAsync$_annotation$$none$$());
    
    org$ednovo$gooru$client$mvp$folders$edit$tab$info$FolderInfoTabPresenter_searchService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$SearchServiceAsync$_annotation$$none$$());
    
    org$ednovo$gooru$client$mvp$folders$edit$tab$info$FolderInfoTabPresenter_taxonomyService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$TaxonomyServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$folders$edit$tab$info$FolderInfoTabView$_annotation$$none$$(org.ednovo.gooru.client.mvp.folders.edit.tab.info.FolderInfoTabView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.folders.edit.tab.info.IsFolderInfoTabView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenterWidget(AbstractPresenterModule.java:265)
   */
  public org.ednovo.gooru.client.mvp.folders.edit.tab.info.IsFolderInfoTabView get_Key$type$org$ednovo$gooru$client$mvp$folders$edit$tab$info$IsFolderInfoTabView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.folders.edit.tab.info.IsFolderInfoTabView result = get_Key$type$org$ednovo$gooru$client$mvp$folders$edit$tab$info$FolderInfoTabView$_annotation$$none$$();
    return result;
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.folders.edit.tab.info.FolderInfoTabPresenter declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.folders.edit.tab.info.FolderInfoTabPresenter
   */
  public org.ednovo.gooru.client.mvp.folders.edit.tab.info.FolderInfoTabPresenter get_Key$type$org$ednovo$gooru$client$mvp$folders$edit$tab$info$FolderInfoTabPresenter$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.folders.edit.tab.info.FolderInfoTabPresenter result = org$ednovo$gooru$client$mvp$folders$edit$tab$info$FolderInfoTabPresenter_org$ednovo$gooru$client$mvp$folders$edit$tab$info$FolderInfoTabPresenter_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$folders$edit$tab$info$IsFolderInfoTabView$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$folders$edit$tab$info$FolderInfoTabPresenter$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.folders.edit.tab.info.FolderInfoTabPresenter org$ednovo$gooru$client$mvp$folders$edit$tab$info$FolderInfoTabPresenter_org$ednovo$gooru$client$mvp$folders$edit$tab$info$FolderInfoTabPresenter_methodInjection(com.google.gwt.event.shared.EventBus _0, org.ednovo.gooru.client.mvp.folders.edit.tab.info.IsFolderInfoTabView _1) {
    return new org.ednovo.gooru.client.mvp.folders.edit.tab.info.FolderInfoTabPresenter(_0, _1);
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.folders.edit.tab.info.FolderInfoTabView declared at:
   *   Implicit GWT.create binding for org.ednovo.gooru.client.mvp.folders.edit.tab.info.FolderInfoTabView
   */
  public org.ednovo.gooru.client.mvp.folders.edit.tab.info.FolderInfoTabView get_Key$type$org$ednovo$gooru$client$mvp$folders$edit$tab$info$FolderInfoTabView$_annotation$$none$$() {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.folders.edit.tab.info.FolderInfoTabView.class);
    assert created instanceof org.ednovo.gooru.client.mvp.folders.edit.tab.info.FolderInfoTabView;
    org.ednovo.gooru.client.mvp.folders.edit.tab.info.FolderInfoTabView result = (org.ednovo.gooru.client.mvp.folders.edit.tab.info.FolderInfoTabView) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$folders$edit$tab$info$FolderInfoTabView$_annotation$$none$$(result);
    
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
