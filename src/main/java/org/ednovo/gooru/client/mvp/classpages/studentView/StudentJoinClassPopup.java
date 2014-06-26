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
	@UiField Label closeLbl,lblJoining;
	
	@UiField Button joinClassBtn,joinLaterBtn;
	
	@UiField HTMLPanel headerPanel,welcomePanel,descPanel,classNamePanel,joinBtnPanel;//termsPanel, descPanel, welcomePanel
	
	@UiField HTML htmlInformation,htmlAgree;

	public StudentJoinClassPopup(ClasspageDo classpageDo) {
		setWidget(uiBinder.createAndBindUi(this));
//		setGlassStyleName(HomeCBundle.INSTANCE.css().loginPopupGlassStyle());
		
		this.classpageDo = classpageDo;
		
		String userName = classpageDo.getCreatorUsername();
		setStaticData(classpageDo);

		this.setGlassEnabled(true);

		Window.enableScrolling(false);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, false));
	}

	private void setStaticData(ClasspageDo classpageDo) {
		headerPanel.getElement().setInnerHTML(GL1536);
		headerPanel.getElement().setId("pnlHeader");
		headerPanel.getElement().setAttribute("alt",GL1536);
		headerPanel.getElement().setAttribute("title",GL1536);
		closeLbl.getElement().setId("lblClose");
		lblJoining.setVisible(false);
		joinBtnPanel.setVisible(true);
		lblJoining.setText(GL1976);
		lblJoining.getElement().setId("lblJoining");
		lblJoining.getElement().setAttribute("alt",GL1976);
		lblJoining.getElement().setAttribute("title",GL1976);
		if(classpageDo.getSharing().equalsIgnoreCase("public"))
		{
			welcomePanel.setVisible(true);
			classNamePanel.setVisible(true);
			descPanel.setVisible(true);
			joinLaterBtn.setVisible(true);
		
		welcomePanel.getElement().setInnerHTML(GL1540);
		welcomePanel.getElement().setId("pnlWelcome");
		welcomePanel.getElement().setAttribute("alt",GL1540);
		welcomePanel.getElement().setAttribute("title",GL1540);
		
		classNamePanel.getElement().setInnerHTML(classpageDo.getTitle() +"!");
		classNamePanel.getElement().setId("pnlClassName");
		classNamePanel.getElement().setAttribute("alt",classpageDo.getTitle() +"!");
		classNamePanel.getElement().setAttribute("title",classpageDo.getTitle() +"!");
		
		descPanel.getElement().setInnerHTML(GL1541);
		descPanel.getElement().setId("pnlDesc");
		descPanel.getElement().setAttribute("alt",GL1541);
		descPanel.getElement().setAttribute("title",GL1541);
		
		joinLaterBtn.setText(GL1738);
		joinLaterBtn.getElement().setId("pnlJoinLater");
		joinLaterBtn.getElement().setAttribute("alt",GL1738);
		joinLaterBtn.getElement().setAttribute("title",GL1738);
		
		}
		else
		{
			welcomePanel.setVisible(false);
			classNamePanel.setVisible(false);
			descPanel.setVisible(false);
			joinLaterBtn.setVisible(false);
		}
//		termsPanel.getElement().setInnerHTML(GL1542);
		String userName = classpageDo.getCreatorUsername();
		htmlAgree.getElement().setInnerHTML(StringUtil.generateMessage(GL1543, userName != null ? userName : ""));
		htmlAgree.getElement().setId("htmlAgree");
		htmlAgree.getElement().setAttribute("alt",StringUtil.generateMessage(GL1543, userName != null ? userName : ""));
		htmlAgree.getElement().setAttribute("title",StringUtil.generateMessage(GL1543, userName != null ? userName : ""));
		
		htmlInformation.setHTML(StringUtil.generateMessage(GL1558, userName != null ? userName : ""));
		htmlInformation.getElement().setId("htmlInformation");
		htmlInformation.getElement().setAttribute("alt",StringUtil.generateMessage(GL1558, userName != null ? userName : ""));
		htmlInformation.getElement().setAttribute("title",StringUtil.generateMessage(GL1558, userName != null ? userName : ""));
		joinBtnPanel.getElement().setId("pnlJoin");
		joinClassBtn.setText(GL1536);
		joinClassBtn.getElement().setId("pnlJoinClass");
		joinClassBtn.getElement().setAttribute("alt",GL1536);
		joinClassBtn.getElement().setAttribute("title",GL1536);
		
	}

	@UiHandler("closeLbl")
	public void clickOnCloseBtn(ClickEvent clickEvent){
		closePoup();
	}
	
	@UiHandler("joinLaterBtn")
	public void clickOnJoinLaterBtn(ClickEvent clickEvent){
		closePoup();
	}
	
	@UiHandler("joinClassBtn")
	public void clickOnJoinClassBtn(ClickEvent clickEvent){
		joinIntoClass();
		joinBtnPanel.setVisible(false);
		lblJoining.setVisible(true);
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
	/**
	 * @return the lblJoining
	 */
	public Label getLblJoining() {
		return lblJoining;
	}

	public abstract void closePoup();

	abstract void joinIntoClass();
}
