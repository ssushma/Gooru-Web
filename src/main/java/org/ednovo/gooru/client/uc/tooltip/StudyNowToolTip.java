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
/**
 * 
 */
package org.ednovo.gooru.client.uc.tooltip;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.home.HeaderUc;
import org.ednovo.gooru.client.uc.AlertMessageUc;
import org.ednovo.gooru.client.uc.TextBoxWithPlaceholder;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : StudyNowToolTip.java
 *
 * @description : This class is used to display the study now tooltip.
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class StudyNowToolTip extends PopupPanel implements MessageProperties {

	private static StudyNowToolTipUiBinder uiBinder = GWT
			.create(StudyNowToolTipUiBinder.class);

	interface StudyNowToolTipUiBinder extends UiBinder<Widget, StudyNowToolTip> {
	}

	@UiField Label lblTitle;

	@UiField TextBoxWithPlaceholder classCodeTxtBox;

	@UiField Button enterLbl;
	
	@UiField HTMLPanel tooltipPanel;

	AlertMessageUc alertMessageUc;

	private boolean isValid=true;

	HeaderUc headerUc;

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
	public StudyNowToolTip() {
		setWidget(uiBinder.createAndBindUi(this));
//		lblTitle.getElement().getStyle().setMarginTop(14, Unit.PX);
		tooltipPanel.getElement().getStyle().setTop(14, Unit.PX);
		lblTitle.setText(MessageProperties.GL0474);
		classCodeTxtBox.setText("");
		classCodeTxtBox.getElement().setAttribute("maxlength", "10");
		classCodeTxtBox.getElement().setId("txtClassCode");
		classCodeTxtBox.setPlaceholder(MessageProperties.GL0184);
		
		ClickHandler rootHandler=new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if(!isValid && isVisible()){
					show();
					isValid=true;
				}
			}
		};
		RootPanel.get().addDomHandler(rootHandler, ClickEvent.getType());

	}
	/**
	 * 
	 * @function onEnterClassCodeClick 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This will handle the click event on the enter label.
	 * 
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("enterLbl")
	public void onEnterClassCodeClick(ClickEvent clickEvent){

		if (classCodeTxtBox.getText().trim().equalsIgnoreCase("") || classCodeTxtBox.getText().trim() == null){
			alertMessageUc=new AlertMessageUc(MessageProperties.GL0061, new Label(MessageProperties.GL0243));
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
			return;
		}
		
		MixpanelUtil.ClickOnStudyNow();
		
		AppClientFactory.getInjector().getClasspageService().v2getClasspageByCode(classCodeTxtBox.getText(), new SimpleAsyncCallback<CollectionDo>(){

			@Override
			public void onSuccess(CollectionDo result) {

				if(result.getGooruOid()==null){
					alertMessageUc=new AlertMessageUc(MessageProperties.GL0061, new Label(MessageProperties.GL0244));
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
				}else{

					Map<String, String> params = new HashMap<String, String>();
					params.put("id",result.getGooruOid());
					params.put("pageSize", "10");
					params.put("pageNum", "0");
					params.put("pos", "1");
					AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.STUDENT,params);
					classCodeTxtBox.setText("");
					hide();
					alertMessageUc.hide();
				}
			}

		});
	}
}
