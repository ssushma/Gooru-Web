/**
 * 
 */
package org.ednovo.gooru.client.mvp.classpages.classlist;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Gooru Team
 *
 */
public class WelcomeClassView extends PopupPanel implements MessageProperties {

	private static NewFeaturesClassVcUiBinder uiBinder = GWT
			.create(NewFeaturesClassVcUiBinder.class);

	interface NewFeaturesClassVcUiBinder extends
			UiBinder<Widget, WelcomeClassView> {
	}
	
	@UiField Button btnOk;
	@UiField HTMLPanel popupHeader,/*headingTittle,*/headingTxt,manageList;
	@UiField InlineHTML /*popupContentDesc,popupContentDesc1,*//*popupContentTxt,*/headingTxtDesc,manageListDesc;
	@UiField Label popupContentDesc,popupContentDesc1;
	private static final String CLASSKEY = "classpage_welcome_popup_is_autoopen";

	/**
	 * Because this class has a default constructor, it can
	 * be used as a binder template. In other words, it can be used in other
	 * *.ui.xml files as follows:
	 * <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
	 *   xmlns:g="urn:import:**user's package**">
	 *  <g:**UserClassName**>Hello!</g:**UserClassName>
	 * </ui:UiBinder>
	 * Note that depending on the widget that is used, it may be necessary to
	 * implement HasHTML instead of HasText.
	 */
	public WelcomeClassView(boolean isHide) {
		super(isHide);
		setWidget(uiBinder.createAndBindUi(this));
		setGlassEnabled(true);
		this.setPixelSize(520, 453);
		show();
		center();
		setDefaultText();
	}
	
	private void setDefaultText() {
		// TODO Auto-generated method stub
		btnOk.setText(GL1386);
		btnOk.getElement().setId("btnOk");
		btnOk.getElement().setAttribute("alt",GL1386);
		btnOk.getElement().setAttribute("title",GL1386);
		
		popupHeader.getElement().setInnerHTML(GL1605);
		popupHeader.getElement().setId("pnlPopupHeader");
		popupHeader.getElement().setAttribute("alt",GL1605);
		popupHeader.getElement().setAttribute("title",GL1605);
		
//		headingTittle.getElement().setInnerHTML(GL1607);
		headingTxt.getElement().setInnerHTML(GL1609);
		headingTxt.getElement().setId("pnlHeadingText");
		headingTxt.getElement().setAttribute("alt",GL1609);
		headingTxt.getElement().setAttribute("title",GL1609);
		
		manageList.getElement().setInnerHTML(GL1611);
		manageList.getElement().setId("pnlManageList");
		manageList.getElement().setAttribute("alt",GL1611);
		manageList.getElement().setAttribute("title",GL1611);
		
		popupContentDesc.setText(GL1606);
		popupContentDesc.getElement().setId("lblPopupContentDesc");
		popupContentDesc.getElement().setAttribute("alt",GL1606);
		popupContentDesc.getElement().setAttribute("title",GL1606);
		
		popupContentDesc1.setText(GL1606_1);
		popupContentDesc1.getElement().setId("lblPopupContentDesc1");
		popupContentDesc1.getElement().setAttribute("alt",GL1606_1);
		popupContentDesc1.getElement().setAttribute("title",GL1606_1);
		
//		popupContentTxt.setText(GL1608);
		headingTxtDesc.setText(GL1610);
		headingTxtDesc.getElement().setId("spnHeadingTxtDesc");
		headingTxtDesc.getElement().setAttribute("alt",GL1610);
		headingTxtDesc.getElement().setAttribute("title",GL1610);
		
		manageListDesc.setText(GL1612);
		manageListDesc.getElement().setId("spnManageListDesc");
		manageListDesc.getElement().setAttribute("alt",GL1612);
		manageListDesc.getElement().setAttribute("title",GL1612);
		
	}

	@UiHandler("btnOk")
	public void clickOnOkButton(ClickEvent clickEvent){
		
		AppClientFactory.getInjector().getUserService().updatePartyCustomField(AppClientFactory.getLoggedInUser().getGooruUId(), CLASSKEY, "false", new SimpleAsyncCallback<Void>() {

			@Override
			public void onSuccess(Void result) {
				hide(true);
			}
		});
		
	}

	@Override
	public void hide(boolean isHide){
		super.hide(isHide);
		Window.enableScrolling(true);
	}	
	
}
