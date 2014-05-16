package org.ednovo.gooru.client.mvp.play.resource.question;

import com.google.gwt.core.client.GWT;
import org.ednovo.gooru.client.gin.org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector;

public class org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment {
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$play$resource$question$QuestionResourcePresenter$_annotation$$none$$(org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourcePresenter injectee) {
    injector.getFragment_com_gwtplatform_mvp_client().com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection______________(injectee, injector.getFragment_com_gwtplatform_mvp_client().get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    
  }
  
  public void memberInject_Key$type$org$ednovo$gooru$client$mvp$play$resource$question$QuestionResourceView$_annotation$$none$$(org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourceView injectee) {
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.play.resource.question.IsQuestionResourceView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenterWidget(AbstractPresenterModule.java:265)
   */
  public org.ednovo.gooru.client.mvp.play.resource.question.IsQuestionResourceView get_Key$type$org$ednovo$gooru$client$mvp$play$resource$question$IsQuestionResourceView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.play.resource.question.IsQuestionResourceView result = get_Key$type$org$ednovo$gooru$client$mvp$play$resource$question$QuestionResourceView$_annotation$$none$$();
    return result;
    
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourcePresenter declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourcePresenter
   */
  public org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourcePresenter get_Key$type$org$ednovo$gooru$client$mvp$play$resource$question$QuestionResourcePresenter$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourcePresenter result = org$ednovo$gooru$client$mvp$play$resource$question$QuestionResourcePresenter_org$ednovo$gooru$client$mvp$play$resource$question$QuestionResourcePresenter_methodInjection(injector.getFragment_com_google_gwt_event_shared().get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$org$ednovo$gooru$client$mvp$play$resource$question$IsQuestionResourceView$_annotation$$none$$());
    memberInject_Key$type$org$ednovo$gooru$client$mvp$play$resource$question$QuestionResourcePresenter$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourcePresenter org$ednovo$gooru$client$mvp$play$resource$question$QuestionResourcePresenter_org$ednovo$gooru$client$mvp$play$resource$question$QuestionResourcePresenter_methodInjection(com.google.gwt.event.shared.EventBus _0, org.ednovo.gooru.client.mvp.play.resource.question.IsQuestionResourceView _1) {
    return new org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourcePresenter(_0, _1);
  }
  
  
  /**
   * Binding for org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourceView declared at:
   *   Implicit binding for org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourceView
   */
  public org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourceView get_Key$type$org$ednovo$gooru$client$mvp$play$resource$question$QuestionResourceView$_annotation$$none$$() {
    org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourceView result = org$ednovo$gooru$client$mvp$play$resource$question$QuestionResourceView_org$ednovo$gooru$client$mvp$play$resource$question$QuestionResourceView_methodInjection();
    memberInject_Key$type$org$ednovo$gooru$client$mvp$play$resource$question$QuestionResourceView$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourceView org$ednovo$gooru$client$mvp$play$resource$question$QuestionResourceView_org$ednovo$gooru$client$mvp$play$resource$question$QuestionResourceView_methodInjection() {
    return new org.ednovo.gooru.client.mvp.play.resource.question.QuestionResourceView();
  }
  
  
  /**
   * Field for the enclosing injector.
   */
  private final org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector;
  public org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector_fragment(org_ednovo_gooru_client_gin_AppInjector_AppInjectorGinjector injector) {
    this.injector = injector;
  }
  
}
