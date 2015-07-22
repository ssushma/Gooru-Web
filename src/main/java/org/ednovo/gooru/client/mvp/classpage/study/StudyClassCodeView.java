
/**
 * 
*/
package org.ednovo.gooru.client.mvp.classpage.study;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.child.ChildView;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.content.ClasspageDo;
import org.ednovo.gooru.client.CssTokens;
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.ednovo.gooru.client.mvp.classpages.newclasspage.NewClassPopupView;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.socialshare.SentEmailSuccessVc;
import org.ednovo.gooru.client.uc.AlertMessageUc;
import org.ednovo.gooru.client.uc.TextBoxWithPlaceholder;
import org.ednovo.gooru.client.util.MixpanelUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;


/**
 * @fileName : StudyClassCodeView.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 21-Jul-2015
 *
 * @Author tumbalam
 *
 * @Reviewer: 
 */
public class StudyClassCodeView extends ChildView<StudyClassCodePresenter> implements IsStudyClassCodeView{
	
	
	@UiField Anchor moreLinkAnr;
	
	@UiField TextBoxWithPlaceholder txtClassCode;
	
	@UiField Button codeBtnEnter,btnCreateClass;
	
	MessageProperties i18n = GWT.create(MessageProperties.class);
	
	private NewClassPopupView newPopup = null;
	
	AlertMessageUc alertMessageUc;
	
	private boolean isValid=true;

	Button goBtn;

	private static StudyClassCodeViewUiBinder uiBinder = GWT.create(StudyClassCodeViewUiBinder.class);

	interface StudyClassCodeViewUiBinder extends	UiBinder<Widget, StudyClassCodeView> {
	}

	public StudyClassCodeView() {
		initWidget(uiBinder.createAndBindUi(this));
		setIds();
		setPresenter(new StudyClassCodePresenter(this));
		btnCreateClass.addClickHandler(new CreateNewClass());
		codeBtnEnter.addClickHandler(new OnEnterClassCodeOpen(codeBtnEnter, txtClassCode));
		Window.enableScrolling(true);
	}

		
	private void setIds() {
		
		btnCreateClass.setText(i18n.GL1771());
		btnCreateClass.getElement().setId("btnCreateClass");
		btnCreateClass.getElement().setAttribute("alt",i18n.GL1771());
		btnCreateClass.getElement().setAttribute("title",i18n.GL1771());
		
		
		txtClassCode.setPlaceholder(i18n.GL1785());
		txtClassCode.getElement().setId("txtCode");
		
		codeBtnEnter.setText(i18n.GL0213());
		codeBtnEnter.getElement().setId("codeBtnEnter");
		codeBtnEnter.getElement().setAttribute("alt",i18n.GL0213());
		codeBtnEnter.getElement().setAttribute("title",i18n.GL0213());
		
		
		txtClassCode.addFocusHandler(new FocusHandler() {
			
			@Override
			public void onFocus(FocusEvent event) {
				txtClassCode.getElement().addClassName("textTransform");
			}
		});
		txtClassCode.addBlurHandler(new BlurHandler() {
			
			@Override
			public void onBlur(BlurEvent event) {
				if (txtClassCode.getText().length() > 0 ){
					
				}else{
					txtClassCode.getElement().removeClassName("textTransform");
				}
			}
		});
		
		
		
	}
	
	public void setEnterBtnVisiblity(Button enterBtn,boolean isVisible){
		if(isVisible){
			enterBtn.setEnabled(!isVisible);
			enterBtn.addStyleName(CssTokens.DISABLED);
		}else{
			enterBtn.setEnabled(!isVisible);
			enterBtn.removeStyleName(CssTokens.DISABLED);
		}
	}
	
	private class CreateNewClass implements ClickHandler{

		/* (non-Javadoc)
		 * @see com.google.gwt.event.dom.client.ClickHandler#onClick(com.google.gwt.event.dom.client.ClickEvent)
		 */
		@Override
		public void onClick(ClickEvent event) {
			MixpanelUtil.ClickOnNewClassPage();
			newPopup = new NewClassPopupView() {
				
				@Override
				public void createNewClasspage(String title, String grade, boolean sharing) {
					try{
						getPresenter().createNewClass(title,grade,sharing);
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
			};
		}
		
	}
	
	private class OnEnterClassCodeOpen implements ClickHandler{
		
		Button enterBtn;
		TextBoxWithPlaceholder classCodeTxt;
		
		public OnEnterClassCodeOpen(Button enterBtn,TextBoxWithPlaceholder classCodeTxt){
			this.enterBtn=enterBtn;
			this.classCodeTxt=classCodeTxt;
			goBtn=enterBtn;
		}

		/* (non-Javadoc)
		 * @see com.google.gwt.event.dom.client.ClickHandler#onClick(com.google.gwt.event.dom.client.ClickEvent)
		 */
		@Override
		public void onClick(ClickEvent event) {
			setEnterBtnVisiblity(enterBtn,true);
			if (classCodeTxt.getText().trim().equalsIgnoreCase("") || classCodeTxt.getText().trim() == null){
				alertMessageUc=new AlertMessageUc(i18n.GL0061(), new Label(i18n.GL0243()));
				ClickHandler alertHandler=new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						isValid=false;
						setEnterBtnVisiblity(enterBtn,false);
					}
				};
				alertMessageUc.appPopUp.addDomHandler(alertHandler, ClickEvent.getType());
				
				alertMessageUc.okButton.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						isValid=false;
						setEnterBtnVisiblity(enterBtn,false);
					}
				});
				return;
			}
			MixpanelUtil.ClickOnStudyNow();
			getPresenter().getClassData(classCodeTxt.getText().trim());
		}
		
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.classpage.study.IsStudyClassCodeView#setCreatedClass(org.ednovo.gooru.application.shared.model.content.ClasspageDo)
	 */
	@Override
	public void setCreatedClass(ClasspageDo result) {
		if(result != null){
			String[] uri=result.getUri().split("/");
			final String classpageId =  uri[uri.length-1];
			OpenClasspageEdit(classpageId, PlaceTokens.EDIT_CLASS);
			newPopup.ClosePopup();
		}
		
	}
	 
	private void OpenClasspageEdit(String gooruOId, String token){
		Map<String, String> params = new HashMap<String, String>();
		params.put(UrlNavigationTokens.CLASSPAGEID, gooruOId);
		AppClientFactory.getPlaceManager().revealPlace(token, params);
		AppClientFactory.getPlaceManager().revealPlace(token, params);
	}


	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.classpage.study.IsStudyClassCodeView#setClassData(org.ednovo.gooru.application.shared.model.content.ClasspageDo)
	 */
	@Override
	public void setClassData(ClasspageDo result) {
		setEnterBtnVisiblity(goBtn,false);
		if(result.getClassUid()==null){
			Window.enableScrolling(false);
			 AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
			alertMessageUc=new AlertMessageUc(i18n.GL0061(), new Label(i18n.GL0244()));
			ClickHandler alertHandler=new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					isValid=false;
					
				}
			};
			alertMessageUc.appPopUp.addDomHandler(alertHandler, ClickEvent.getType());
			
			alertMessageUc.okButton.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					isValid=false;
				}
			});
		}else if(result.getUser().getGooruUId().equalsIgnoreCase(AppClientFactory.getGooruUid())){
			Map<String, String> params = new HashMap<String, String>();
			params.put("id",result.getClassUid());
			if(result.getCourseGooruOid() != null){
				params.put(UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_ID, result.getCourseGooruOid());
			}
			AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.STUDENT_VIEW,params);
			txtClassCode.setText("");
			if(alertMessageUc!=null)
			alertMessageUc.hide();
		}else if(!result.isVisibility()){
			if(result.getUser().getGooruUId().equalsIgnoreCase(AppClientFactory.getGooruUid()))
			{
				if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.HOME)) {
					MixpanelUtil.Click_Study_LandingPage();
				}
				Map<String, String> params = new HashMap<String, String>();
				params.put("id",result.getClassUid());
				if(result.getCourseGooruOid() != null){
					params.put(UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_ID, result.getCourseGooruOid());
				}
				AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.STUDENT_VIEW,params);
				txtClassCode.setText("");
				if(alertMessageUc!=null)
				alertMessageUc.hide();
			}else if(result.getStatus().equalsIgnoreCase("active")){
				if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.HOME)) {
					MixpanelUtil.Click_Study_LandingPage();
				}
				Map<String, String> params = new HashMap<String, String>();
				if(result.getCourseGooruOid() != null){
					params.put(UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_ID, result.getCourseGooruOid());
				}
				params.put("id",result.getClassUid());
				AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.STUDENT_VIEW,params);
				txtClassCode.setText("");
				if(alertMessageUc!=null)
				alertMessageUc.hide();
			}else if(result.getStatus().equalsIgnoreCase("pending")){
				if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.HOME)) {
					MixpanelUtil.Click_Study_LandingPage();
				}
				Map<String, String> params = new HashMap<String, String>();
				if(result.getCourseGooruOid() != null){
					params.put(UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_ID, result.getCourseGooruOid());
				}
				params.put("id",result.getClassUid());
				AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.STUDENT_VIEW,params);
				txtClassCode.setText("");
				if(alertMessageUc!=null)
				alertMessageUc.hide();
				
			}else{
		       if(AppClientFactory.isAnonymous()){
		    	   new SentEmailSuccessVc(i18n.GL1177(), i18n.GL1535());
		       }else{
		    	   new SentEmailSuccessVc(i18n.GL1177(), i18n.GL1535_1());
		       }
			}
			
		}else{	
			Map<String, String> params = new HashMap<String, String>();
			if(result.getCourseGooruOid() != null){
				params.put(UrlNavigationTokens.STUDENT_CLASSPAGE_COURSE_ID, result.getCourseGooruOid());
			}
			params.put("id",result.getClassUid());
			AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.STUDENT_VIEW,params);
			txtClassCode.setText("");
			if(alertMessageUc!=null)
			alertMessageUc.hide();
		}
		setEnterBtnVisiblity(goBtn,false);
	}

}
