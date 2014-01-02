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


import org.ednovo.gooru.client.mvp.settings.CustomAnimation;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : SaveSharePanel.java
 *
 * @description : This file is used to play collection in new tab 
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
public abstract class SaveSharePanel extends PopupPanel implements MessageProperties{

 
	@UiField
	Anchor gettingAnchr;
	@UiField FlowPanel helpContainer;
 
	@UiField HTMLPanel saveSharePanelContentContainer;
	
	@UiField HTMLEventPanel closeButton;	
	private static FaqSlideUiBinder uiBinder = GWT
			.create(FaqSlideUiBinder.class);

	@UiTemplate("SaveSharePanel.ui.xml")
	interface FaqSlideUiBinder extends UiBinder<Widget, SaveSharePanel> {
	}

	/**
	 * Class constructor
	 */
	public SaveSharePanel() {
		super(false);
		setWidget(uiBinder.createAndBindUi(this));
		setGlassEnabled(true);
		this.setStyleName("");
		this.getElement().getStyle().setZIndex(9999);
		saveSharePanelContentContainer.getElement().getStyle().setDisplay(Display.NONE);
			
		gettingAnchr.setHref("http://www.goorulearning.org/#!collection-play&id=f96a3e33-4250-406d-8c95-f3f6332ac659");
		gettingAnchr.setTarget("_blank");
	}
	/**
	 * onLoad Event.
	 */
	@Override
	public void onLoad(){
		super.onLoad();
		if(isAttached()){
			new CustomAnimation(saveSharePanelContentContainer).run(500);
		}
		
	}
	/**
	 * 
	 * @function closeButton 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description :UIHandler for CloseButton.
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
	@UiHandler("closeButton")
	public abstract void closeButton(ClickEvent clickEvent);
	
}
