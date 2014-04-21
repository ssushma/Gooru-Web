package org.ednovo.gooru.client.mvp.classpages.studentView;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.shared.model.content.ClasspageDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public abstract class StudentJoinClassPopup extends PopupPanel implements MessageProperties {

	private static StudentJoinClassPopupUiBinder uiBinder = GWT
			.create(StudentJoinClassPopupUiBinder.class);

	interface StudentJoinClassPopupUiBinder extends
			UiBinder<Widget, StudentJoinClassPopup> {
	}
	ClasspageDo classpageDo;
	@UiField Label closeLbl;
	
	@UiField Button joinClassBtn;
	
	@UiField HTMLPanel headerPanel;//termsPanel, descPanel, welcomePanel
	
	@UiField HTML htmlInformation,htmlAgree;

	public StudentJoinClassPopup(ClasspageDo classpageDo) {
		setWidget(uiBinder.createAndBindUi(this));
//		setGlassStyleName(HomeCBundle.INSTANCE.css().loginPopupGlassStyle());
		
		this.classpageDo = classpageDo;
		
		String userName = classpageDo.getCreatorUsername();
		System.out.println("userName : "+userName);
		setStaticData();

		this.setGlassEnabled(true);

		Window.enableScrolling(false);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, false));
	}

	private void setStaticData() {
		headerPanel.getElement().setInnerHTML(GL1536);
//		welcomePanel.getElement().setInnerHTML(GL1540);
//		descPanel.getElement().setInnerHTML(GL1541);
//		termsPanel.getElement().setInnerHTML(GL1542);
		String userName = classpageDo.getCreatorUsername();
		htmlAgree.getElement().setInnerHTML(StringUtil.generateMessage(GL1543, userName != null ? userName : ""));
		htmlInformation.setHTML(StringUtil.generateMessage(GL1558, userName != null ? userName : ""));
		
		joinClassBtn.setText(GL1536);
		
	}

	@UiHandler("closeLbl")
	public void clickOnCloseBtn(ClickEvent clickEvent){
		closePoup();
	}
	
	@UiHandler("joinClassBtn")
	public void clickOnJoinClassBtn(ClickEvent clickEvent){
		joinIntoClass();
		StudentAssignmentView.setPrivatePageActive();
		/*if(AppClientFactory.isAnonymous()){
			LoginPopupUc loginPopupUc=new LoginPopupUc();
		}else{
			AppClientFactory.getInjector().getClasspageService().studentJoinIntoClass(C, new SimpleAsyncCallback<ClasspageDo>() {

				@Override
				public void onSuccess(ClasspageDo result) {
					// TODO Auto-generated method stub
					
				}
			});
		}*/
		
	}
	
	public abstract void closePoup();

	abstract void joinIntoClass();
}
