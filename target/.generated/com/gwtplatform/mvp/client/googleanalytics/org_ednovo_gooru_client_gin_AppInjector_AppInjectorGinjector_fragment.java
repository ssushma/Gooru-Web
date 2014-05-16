package com.gwtplatform.mvp.client.googleanalytics;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public void memberInject_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalyticsImpl$_annotation$$none$$(com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl injectee) {
    
  }
  
  
  /**
   * Binding for com.gwtplatform.mvp.client.googleanalytics.GoogleAnalytics declared at:
   *   org.ednovo.gooru.client.gin.AppModule.configure(AppModule.java:393)
   */
  public com.gwtplatform.mvp.client.googleanalytics.GoogleAnalytics get_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalytics$_annotation$$none$$() {
    com.gwtplatform.mvp.client.googleanalytics.GoogleAnalytics result = get_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalyticsImpl$_annotation$$none$$();
    return result;
    
  }
  
  
  /**
   * Binding for com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl declared at:
   *   Implicit GWT.create binding for com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl
   */
  public com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl get_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalyticsImpl$_annotation$$none$$() {
    Object created = GWT.create(com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl.class);
    assert created instanceof com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl;
    com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl result = (com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl) created;
    
    memberInject_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalyticsImpl$_annotation$$none$$(result);
    
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
