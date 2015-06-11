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
package org.ednovo.gooru.client.mvp.shelf.collection.tab.assign;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshUserShelfCollectionsEvent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author BLR Team
 * 
 */
public abstract class SuccessPopupVc extends PopupPanel {
 
	
	@UiField InlineLabel assignMoreCpLbl,ancClasspageTitle;
	
	@UiField HTMLPanel assignMoreCpContainer,successPopUpHeader;
	
	@UiField Button classPageDoneBtn;
	
	@UiField Label cancelButton;
	
	@UiField(provided = true)
	CollectionAssignCBundle res;
	
	@UiTemplate("SuccessPopupVc.ui.xml")
	interface Binder extends UiBinder<Widget, SuccessPopupVc> {

	}

	private static final Binder binder = GWT.create(Binder.class);
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	/**
	 * 
	 */
	public SuccessPopupVc(String classpageId, String collectionTitle, String classpageTitle) {
		super(false);
		this.res = CollectionAssignCBundle.INSTANCE;
		res.css().ensureInjected();
		add(binder.createAndBindUi(this));
		this.setGlassEnabled(true);

		Window.enableScrolling(false);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, false));
        
        successPopUpHeader.getElement().setInnerHTML(i18n.GL1183());
        successPopUpHeader.getElement().setId("pnlSuccessPopUpHeader");
        successPopUpHeader.getElement().setAttribute("alt",i18n.GL1183());
        successPopUpHeader.getElement().setAttribute("title",i18n.GL1183());
		
        
    	assignMoreCpLbl.setText(i18n.GL0521());
    	assignMoreCpLbl.getElement().setId("spnAssignMoreCpLbl");
    	assignMoreCpLbl.getElement().setAttribute("alt",i18n.GL0521());
    	assignMoreCpLbl.getElement().setAttribute("title",i18n.GL0521());
           
		ancClasspageTitle.setText(classpageTitle);
		ancClasspageTitle.getElement().setId("spnAncClasspageTitle");
		ancClasspageTitle.getElement().setAttribute("alt",classpageTitle);
		ancClasspageTitle.getElement().setAttribute("title",classpageTitle);
    	
		classPageDoneBtn.setText(i18n.GL0190());
		classPageDoneBtn.getElement().setId("btnClassPageDoneBtn");
		classPageDoneBtn.getElement().setAttribute("alt",i18n.GL0190());
		classPageDoneBtn.getElement().setAttribute("title",i18n.GL0190());
		
		ancClasspageTitle.getElement().setAttribute("classpageId", classpageId);
		cancelButton.getElement().setId("lblCancelButton");
		assignMoreCpContainer.getElement().setId("pnlAssignMoreCpContainer");
		
		this.center();

	}

	public abstract void closePoup();
	
	
	/**
	 * Added click handler to hide the login popup.
	 * 
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */
	@UiHandler("cancelButton")
	public void onCancelClicked(ClickEvent clickEvent) {
		closePoup();
	}
	
	/**
	 * Added click handler to hide the login popup.
	 * 
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */
	@UiHandler("classPageDoneBtn")
	public void onclassPageDoneClicked(ClickEvent clickEvent) {
		closePoup();
	}
	
	
	@UiHandler("ancClasspageTitle")
	public void onClickAncClasspageTitle(ClickEvent clickevent) {

		String classpageId = clickevent.getRelativeElement().getAttribute("classpageId");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("classpageid", classpageId);
		params.put("pageSize", "10");
		params.put("pageNum", "0");
		params.put("pos", "1");
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.EDIT_CLASSPAGE,params);
		AppClientFactory.fireEvent(new RefreshUserShelfCollectionsEvent());
		closePoup();
	}
	
	
}
