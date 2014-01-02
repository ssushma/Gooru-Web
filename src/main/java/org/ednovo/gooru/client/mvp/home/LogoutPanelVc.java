/*******************************************************************************
 * Copyright 2013 Ednovo d/b/a Gooru. All rights reserved.
 * 
 *  http://www.goorulearning.org/
 * 
 *  Permission is hereby granted, free of charge, to any person obtaining
 *  a copy of this software and associated documentation files (the
 *  "Software"), to deal in the Software without restriction, including
 *  without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to
 *  permit persons to whom the Software is furnished to do so, subject to
 *  the following conditions:
 * 
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 * 
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 *  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 *  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 *  WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
package org.ednovo.gooru.client.mvp.home;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.user.UserDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : LogoutPanelVc.java
 *
 * @description : Relate dto LogOut PopUp.
 *
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class LogoutPanelVc extends PopupPanel implements MessageProperties{

	@UiField
	Anchor logoutAnr, anrSettings;
	
	@UiField
	Anchor feedbackAnr;
	
	@UiField
	Anchor classicGooruAnr;
	
	@UiField
	Anchor supportAnr;
	
	@UiField
	FlowPanel logPanel;
	
	
	public LogoutPopupVc logoutPopupVc;
	
	UserDo userdo;

	private static logoutPanelVcUiBinder uiBinder = GWT
			.create(logoutPanelVcUiBinder.class);

	interface logoutPanelVcUiBinder extends UiBinder<Widget, LogoutPanelVc> {
	}

	/**
	 * Class constructor
	 */
	public LogoutPanelVc() {
		super(true);
		setWidget(uiBinder.createAndBindUi(this));
		
		anrSettings.setText(MessageProperties.GL0192);
		classicGooruAnr.setText(MessageProperties.GL0193);
//		supportAnr.setText(StringUtil.generateMessage(MessageProperties.GL0194, "Anil") );
		supportAnr.setText(MessageProperties.GL0194);
		feedbackAnr.setText(MessageProperties.GL0195);
		logoutAnr.setText(MessageProperties.GL0197);
		anrSettings.getElement().setId("lnkSettings");
		classicGooruAnr.getElement().setId("lnkClassicGooru");
		supportAnr.getElement().setId("lnkSupport");
		feedbackAnr.getElement().setId("lnkFeedback");
		logoutAnr.getElement().setId("lnkLogout");
		
		//triggerUserVoice();
	}

	/**
	 * Get confirm to logout popup
	 * 
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */
	
	/*public int getGooruGuideIconLeft() {
		return gooruGuideImgLbl.getAbsoluteLeft();
	}

	public int getGooruGuideIconTop() {
		return gooruGuideImgLbl.getAbsoluteTop();
	}
	*/
	/**
	 * 
	 * @function logoutPopupClicked 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : logoutAnr UIHandler.
	 * 
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("logoutAnr")
	public void logoutPopupClicked(ClickEvent clickEvent) {
		hide();
		Window.enableScrolling(false);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, false));
        logoutPopupVc = new LogoutPopupVc();
	}
	/**
	 * 
	 * @function logoutPopupClicked 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : supportAnr UIHandler.
	 * 
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("supportAnr")
	public void supportLinkClicked(ClickEvent clickEvent) {
		MixpanelUtil.Click_On_Support();
	}
	/**
	 * 
	 * @function logoutPopupClicked 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : classicGooruAnr UIHandler.
	 * 
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("classicGooruAnr")
	public void classicGooruClicked(ClickEvent clickEvent) {
		MixpanelUtil.Click_On_ClassicGooru();
		Window.Location.replace(AppClientFactory.getLoggedInUser().getSettings().getClassicEndPoint());
	}

	public void displayClassicGooruLink(boolean isVisible) {
		if(isVisible) {
			logPanel.getElement().getStyle().setHeight(123, Unit.PX);
			classicGooruAnr.setVisible(true);
		} else {
			logPanel.getElement().getStyle().setHeight(100, Unit.PX);
			classicGooruAnr.setVisible(false);
		}
	}
	
	/**
	 * Initialise user voice feedback popup
	 * 
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */
	@UiHandler("feedbackAnr")
	public void feedbackPopupClick(ClickEvent clickEvent) {
		MixpanelUtil.Click_On_FeedBack();
		//triggerUserVoiceFeedback();

	}
	/**
	 * 
	 * @function triggerUserVoice 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :Native method for triggerUserVoice
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	protected final native void triggerUserVoice() /*-{ 

		UserVoice = window.UserVoice || [];
		$wnd.UserVoice.push(['showTab', 'classic_widget', { mode: 'feedback', primary_color: '#cc6d00', link_color: '#007dbf', forum_id: 192782, tab_label: 'Feedback', tab_color: '#4e9746', tab_position: 'bottom-right', tab_inverted: false }]);
		
	}-*/;
	/**
	 * 
	 * @function triggerUserVoice 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :Native method for triggerUserVoiceFeedback
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	protected final native void triggerUserVoiceFeedback() /*-{ 
    var my_options = {
        mode: 'feedback',
        primary_color: '#cc6d00',
        link_color: '#007dbf',
        default_mode: 'support',
        forum_id: 34190,
        tab_label: 'Feedback & Support',
        tab_color: '#cc6d00',
        tab_position: 'middle-right',
        tab_inverted: false
    };
    $wnd.UserVoice.push(['showLightbox', 'classic_widget', my_options]);
}-*/;
}
