package org.ednovo.gooru.client.gin;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public void memberInject_Key$type$org$ednovo$gooru$client$gin$AppClientFactory$_annotation$$none$$(org.ednovo.gooru.client.gin.AppClientFactory injectee) {
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$gin$AppPlaceManager$_annotation$$none$$(org.ednovo.gooru.client.gin.AppPlaceManager injectee) {
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$gin$AppParameterTokenFormatter$_annotation$$none$$(org.ednovo.gooru.client.gin.AppParameterTokenFormatter injectee) {
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$gin$GoogleAnalyticsNavigationTracker$_annotation$$none$$(org.ednovo.gooru.client.gin.GoogleAnalyticsNavigationTracker injectee) {
    
  }
  
  private org.ednovo.gooru.client.gin.IsPlaceManager singleton_Key$type$org$ednovo$gooru$client$gin$IsPlaceManager$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.gin.IsPlaceManager get_Key$type$org$ednovo$gooru$client$gin$IsPlaceManager$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$gin$IsPlaceManager$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.gin.IsPlaceManager result = get_Key$type$org$ednovo$gooru$client$gin$AppPlaceManager$_annotation$$none$$();
        singleton_Key$type$org$ednovo$gooru$client$gin$IsPlaceManager$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$gin$IsPlaceManager$_annotation$$none$$;
    
  }
  
  
  /**
   * Binding for java.lang.String declared at:
   *   org.ednovo.gooru.client.gin.AppModule.configure(AppModule.java:299)
   */
  public java.lang.String get_Key$type$java$lang$String$_annotation$$org$ednovo$gooru$client$gin$AppDefaultPlace$() {
    java.lang.String result = "discover";
    return result;
    
  }
  
  
  /**
   * Binding for java.lang.String declared at:
   *   org.ednovo.gooru.client.gin.AppModule.configure(AppModule.java:395)
   */
  public java.lang.String get_Key$type$java$lang$String$_annotation$$com$gwtplatform$mvp$client$annotations$GaAccount$() {
    java.lang.String result = "UA-20089789-1";
    return result;
    
  }
  
  private org.ednovo.gooru.client.gin.AppClientFactory singleton_Key$type$org$ednovo$gooru$client$gin$AppClientFactory$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.gin.AppClientFactory get_Key$type$org$ednovo$gooru$client$gin$AppClientFactory$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$gin$AppClientFactory$_annotation$$none$$ == null) {
    Object created = GWT.create(org.ednovo.gooru.client.gin.AppClientFactory.class);
    assert created instanceof org.ednovo.gooru.client.gin.AppClientFactory;
    org.ednovo.gooru.client.gin.AppClientFactory result = (org.ednovo.gooru.client.gin.AppClientFactory) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$gin$AppClientFactory$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$gin$AppClientFactory$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$gin$AppClientFactory$_annotation$$none$$;
    
  }
  
  private org.ednovo.gooru.client.gin.AppPlaceManager singleton_Key$type$org$ednovo$gooru$client$gin$AppPlaceManager$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.gin.AppPlaceManager get_Key$type$org$ednovo$gooru$client$gin$AppPlaceManager$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$gin$AppPlaceManager$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.gin.AppPlaceManager result = org$ednovo$gooru$client$gin$AppPlaceManager_org$ednovo$gooru$client$gin$AppPlaceManager_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), injector.getFragment_com_gwtplatform_mvp_client_proxy().get_Key$type$com$gwtplatform$mvp$client$proxy$TokenFormatter$_annotation$$none$$(), get_Key$type$java$lang$String$_annotation$$org$ednovo$gooru$client$gin$AppDefaultPlace$());
    memberInject_Key$type$org$ednovo$gooru$client$gin$AppPlaceManager$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$gin$AppPlaceManager$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$gin$AppPlaceManager$_annotation$$none$$;
    
  }
  
  public org.ednovo.gooru.client.gin.AppPlaceManager org$ednovo$gooru$client$gin$AppPlaceManager_org$ednovo$gooru$client$gin$AppPlaceManager_methodInjection(com.google.gwt.event.shared.EventBus _0, com.gwtplatform.mvp.client.proxy.TokenFormatter _1, java.lang.String _2) {
    return new org.ednovo.gooru.client.gin.AppPlaceManager(_0, _1, _2);
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.gin.AppParameterTokenFormatter declared at:
   *   Implicit GWT.create binding for org.ednovo.gooru.client.gin.AppParameterTokenFormatter
   */
  public org.ednovo.gooru.client.gin.AppParameterTokenFormatter get_Key$type$org$ednovo$gooru$client$gin$AppParameterTokenFormatter$_annotation$$none$$() {
    Object created = GWT.create(org.ednovo.gooru.client.gin.AppParameterTokenFormatter.class);
    assert created instanceof org.ednovo.gooru.client.gin.AppParameterTokenFormatter;
    org.ednovo.gooru.client.gin.AppParameterTokenFormatter result = (org.ednovo.gooru.client.gin.AppParameterTokenFormatter) created;
    
    memberInject_Key$type$org$ednovo$gooru$client$gin$AppParameterTokenFormatter$_annotation$$none$$(result);
    
    return result;
    
  }
  
  private org.ednovo.gooru.client.gin.GoogleAnalyticsNavigationTracker singleton_Key$type$org$ednovo$gooru$client$gin$GoogleAnalyticsNavigationTracker$_annotation$$none$$ = null;
  
  public org.ednovo.gooru.client.gin.GoogleAnalyticsNavigationTracker get_Key$type$org$ednovo$gooru$client$gin$GoogleAnalyticsNavigationTracker$_annotation$$none$$() {
    
    if (singleton_Key$type$org$ednovo$gooru$client$gin$GoogleAnalyticsNavigationTracker$_annotation$$none$$ == null) {
    org.ednovo.gooru.client.gin.GoogleAnalyticsNavigationTracker result = org$ednovo$gooru$client$gin$GoogleAnalyticsNavigationTracker_org$ednovo$gooru$client$gin$GoogleAnalyticsNavigationTracker_methodInjection(get_Key$type$java$lang$String$_annotation$$com$gwtplatform$mvp$client$annotations$GaAccount$(), injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), injector.getFragment_com_gwtplatform_mvp_client_googleanalytics().get_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalytics$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$gin$GoogleAnalyticsNavigationTracker$_annotation$$none$$(result);
    
        singleton_Key$type$org$ednovo$gooru$client$gin$GoogleAnalyticsNavigationTracker$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$ednovo$gooru$client$gin$GoogleAnalyticsNavigationTracker$_annotation$$none$$;
    
  }
  
  public org.ednovo.gooru.client.gin.GoogleAnalyticsNavigationTracker org$ednovo$gooru$client$gin$GoogleAnalyticsNavigationTracker_org$ednovo$gooru$client$gin$GoogleAnalyticsNavigationTracker_methodInjection(java.lang.String _0, com.google.gwt.event.shared.EventBus _1, com.gwtplatform.mvp.client.googleanalytics.GoogleAnalytics _2) {
    return new org.ednovo.gooru.client.gin.GoogleAnalyticsNavigationTracker(_0, _1, _2);
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
    //   Implicit GWT.create binding for org.ednovo.gooru.client.gin.AppClientFactory
    get_Key$type$org$ednovo$gooru$client$gin$AppClientFactory$_annotation$$none$$();
    // Eager singleton bound at:
    //   Implicit binding for org.ednovo.gooru.client.gin.GoogleAnalyticsNavigationTracker
    get_Key$type$org$ednovo$gooru$client$gin$GoogleAnalyticsNavigationTracker$_annotation$$none$$();
    
  }
  
}
