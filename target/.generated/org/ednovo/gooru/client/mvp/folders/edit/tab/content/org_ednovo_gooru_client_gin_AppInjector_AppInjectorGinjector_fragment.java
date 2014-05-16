package org.ednovo.gooru.client.mvp.folders.edit.tab.content;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public native void org$ednovo$gooru$client$mvp$folders$edit$tab$content$FolderContentTabPresenter_folderService_fieldInjection(org.ednovo.gooru.client.mvp.folders.edit.tab.content.FolderContentTabPresenter injectee, org.ednovo.gooru.client.service.FolderServiceAsync value) /*-{
    injectee.@org.ednovo.gooru.client.mvp.folders.edit.tab.content.FolderContentTabPresenter::folderService = value;
  }-*/;
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$folders$edit$tab$content$FolderContentTabPresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.folders.edit.tab.content.FolderContentTabPresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection____________________________________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    org$ednovo$gooru$client$mvp$folders$edit$tab$content$FolderContentTabPresenter_folderService_fieldInjection(injectee, injector.getFragment_org_ednovo_gooru_client_service().get_Key$type$org$ednovo$gooru$client$service$FolderServiceAsync$_annotation$$none$$());
    
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$folders$edit$tab$content$FolderContentTabView$_annotation$$none$$(org.ednovo.gooru.client.mvp.folders.edit.tab.content.FolderContentTabView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.folders.edit.tab.content.IsFolderContentTabView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenterWidget(AbstractPresenterModule.java:265)
   */
  public org.ednovo.gooru.client.mvp.folders.edit.tab.content.IsFolderContentTabView get_Key$type$org$ednovo$gooru$client$mvp$folders$edit$tab$content$IsFolderContentTabView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.folders.edit.tab.content.IsFolderContentTabView result = get_Key$type$org$ednovo$gooru$client$mvp$folders$edit$tab$content$FolderContentTabView$_annotation$$none$$();
    return result;
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.folders.edit.tab.content.FolderContentTabPresenter declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.folders.edit.tab.content.FolderContentTabPresenter
   */
  public org.ednovo.gooru.client.mvp.folders.edit.tab.content.FolderContentTabPresenter get_Key$type$org$ednovo$gooru$client$mvp$folders$edit$tab$content$FolderContentTabPresenter$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.folders.edit.tab.content.FolderContentTabPresenter result = org$ednovo$gooru$client$mvp$folders$edit$tab$content$FolderContentTabPresenter_org$ednovo$gooru$client$mvp$folders$edit$tab$content$FolderContentTabPresenter_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$folders$edit$tab$content$IsFolderContentTabView$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$folders$edit$tab$content$FolderContentTabPresenter$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.folders.edit.tab.content.FolderContentTabPresenter org$ednovo$gooru$client$mvp$folders$edit$tab$content$FolderContentTabPresenter_org$ednovo$gooru$client$mvp$folders$edit$tab$content$FolderContentTabPresenter_methodInjection(com.google.gwt.event.shared.EventBus _0, org.ednovo.gooru.client.mvp.folders.edit.tab.content.IsFolderContentTabView _1) {
    return new org.ednovo.gooru.client.mvp.folders.edit.tab.content.FolderContentTabPresenter(_0, _1);
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.folders.edit.tab.content.FolderContentTabView declared at:
   *   Implicit GWT.create binding for org.ednovo.gooru.client.mvp.folders.edit.tab.content.FolderContentTabView
   */
  public org.ednovo.gooru.client.mvp.folders.edit.tab.content.FolderContentTabView get_Key$type$org$ednovo$gooru$client$mvp$folders$edit$tab$content$FolderContentTabView$_annotation$$none$$() {
    Object created = GWT.create(org.ednovo.gooru.client.mvp.folders.edit.tab.content.FolderContentTabView.class);
    assert created instanceof org.ednovo.gooru.client.mvp.folders.edit.tab.content.FolderContentTabView;
    org.ednovo.gooru.client.mvp.folders.edit.tab.content.FolderContentTabView result = (org.ednovo.gooru.client.mvp.folders.edit.tab.content.FolderContentTabView) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$mvp$folders$edit$tab$content$FolderContentTabView$_annotation$$none$$(result);
    
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
