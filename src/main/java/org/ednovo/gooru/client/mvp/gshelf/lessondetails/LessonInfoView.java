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
package org.ednovo.gooru.client.mvp.gshelf.lessondetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.code.LibraryCodeDo;
import org.ednovo.gooru.client.uc.LiPanel;
import org.ednovo.gooru.client.uc.UlPanel;
import org.ednovo.gooru.client.ui.HTMLEventPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * @author Search Team
 *
 */
public class LessonInfoView extends BaseViewWithHandlers<LessonInfoUiHandlers> implements IsLessonInfoView {

	private static LessonViewUiBinder uiBinder = GWT.create(LessonViewUiBinder.class);
	
	@UiTemplate("LessonInfoView.ui.xml")
	interface LessonViewUiBinder extends UiBinder<Widget, LessonInfoView> {
	}	

	@UiField HTMLPanel lessonInfo;
	@UiField UlPanel standardsDropListValues;
	@UiField HTMLEventPanel btnStandardsBrowse;
	
	private static MessageProperties i18n = GWT.create(MessageProperties.class);

	String[] standardsTypesArray = new String[]{i18n.GL3321(),i18n.GL3322(),i18n.GL3323(),i18n.GL3324(),i18n.GL3325()};

	final String ACTIVE="active";
	/**
	 * Class constructor 
	 * @param eventBus {@link EventBus}
	 */
	@Inject
	public LessonInfoView() {
		setWidget(uiBinder.createAndBindUi(this));
		lessonInfo.getElement().setId("pnlLessonInfo");
		lessonInfo.setHeight((Window.getClientHeight() - 190)+""+Unit.PX);
		lessonInfo.getElement().getStyle().setOverflowY(Overflow.AUTO);
		populateStandardValues();
		btnStandardsBrowse.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				System.out.println("standardsDropListValues.getElement().getAtt::"+standardsDropListValues.getElement().getAttribute("style"));
				if(!standardsDropListValues.getElement().getAttribute("style").equalsIgnoreCase("display:block;"))
				{
				standardsDropListValues.getElement().setAttribute("style", "display:block;");
				}
				else
				{
				standardsDropListValues.getElement().removeAttribute("style");
				}
				
			}
		});
	}
	
	public void populateStandardValues()
	{
		for(int i=0; i<standardsTypesArray.length; i++)
		{		
		List<String> standardsDescriptionList = Arrays.asList(standardsTypesArray[i].toString().split(","));
		LiPanel liPanel = new LiPanel();
		for(int j=0; j<standardsDescriptionList.size(); j++)
		{
		HTMLPanel headerDiv = new HTMLPanel("");
		if(j==0)
		{
		headerDiv.setStyleName("liPanelStyle");
		}
		else
		{
		headerDiv.setStyleName("liPanelStylenonBold");	
		}
		headerDiv.getElement().setInnerHTML(standardsDescriptionList.get(j).toString());
		liPanel.add(headerDiv);
		}
		liPanel.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {				
				//standardsDropListValues.setVisible(true);
			}
		});
		standardsDropListValues.add(liPanel);
		
		}
	}
	
	

}
