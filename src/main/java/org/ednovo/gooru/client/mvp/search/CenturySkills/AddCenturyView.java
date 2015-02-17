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
package org.ednovo.gooru.client.mvp.search.CenturySkills;

import org.ednovo.gooru.client.uc.AppPopUpCentury;
import org.ednovo.gooru.client.uc.StandardPreferenceTooltip;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.code.StandardsLevel1DO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;

/**
 * @author Search Team
 *
 */
public class AddCenturyView extends PopupViewWithUiHandlers<AddCenturyUiHandlers> implements IsAddCenturyView {
	

	private AppPopUpCentury appPopUp;
	
	String selectedCodeVal = "";
	
	Integer selectedCodeId = 0;
	String selectedCodeDesc = "";
	private static AddCenturyViewUiBinder uiBinder = GWT.create(AddCenturyViewUiBinder.class);
	
	static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	private static final String TITLE_THIS_COLLECTION = i18n.GL0322();
	
	final StandardPreferenceTooltip standardPreferenceTooltip=new StandardPreferenceTooltip();
	

	@UiTemplate("AddCenturyView.ui.xml")
	interface AddCenturyViewUiBinder extends UiBinder<Widget, AddCenturyView> {
	}

	/**
	 * Class constructor 
	 * @param eventBus {@link EventBus}
	 */
	@Inject
	public AddCenturyView(EventBus eventBus) {
		super(eventBus);
		appPopUp = new AppPopUpCentury();
		appPopUp.getCloseBtn().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				appPopUp.hide();
				
			}
		});
	
		appPopUp.setContent(TITLE_THIS_COLLECTION, uiBinder.createAndBindUi(this));
		appPopUp.setGlassStyleName(AddCenturyBundle.INSTANCE.css().gwtGlassPanel());
		appPopUp.getElement().getStyle().setZIndex(99999);
		
		AddCenturyBundle.INSTANCE.css().ensureInjected();

		appPopUp.setViewTitle(i18n.GL3121_1());
		
		
	}
	
	@Override
	public void loadData()
	{
		//API call to load data to be integrated here
	}
	
	@Override
	public void SetData(final StandardsLevel1DO levelOneData, int valArr)
	{
		//Response from api is set here
	}
	
	@Override
	public Widget asWidget() {
		return appPopUp;
	}

	@Override
	public void reset() {
		//reset or clear fields here
	}
	@Override
	public void onLoad() {
		reset();
	}

	@Override
	public void onUnload() {
		
	}

	@Override
	public void hidePopup()
	{
		appPopUp.hide();
	}
}
