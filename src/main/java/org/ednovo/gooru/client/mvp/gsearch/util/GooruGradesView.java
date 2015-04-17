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
package org.ednovo.gooru.client.mvp.gsearch.util;

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.uc.LiPanel;
import org.ednovo.gooru.client.uc.UlPanel;
import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * @author Search Team
 *
 */
public class GooruGradesView extends BaseViewWithHandlers<GooruGradesUiHandlers> implements IsGooruGradesView {

	private static GooruGradesViewUiBinder uiBinder = GWT.create(GooruGradesViewUiBinder.class);
	
	
	private static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	@UiTemplate("GooruGradesView.ui.xml")
	interface GooruGradesViewUiBinder extends UiBinder<Widget, GooruGradesView> {
	}
	
	@UiField UlPanel elementryPanel,middlePanel,higherPanel;
	
	String[] elementaryGrades = new String[]{"Elementry",i18n.GL3071(),i18n.GL3072(),i18n.GL3073(),i18n.GL3074(),i18n.GL3075(),i18n.GL3076()};
	String[] middleGrades = new String[]{"Middle School",i18n.GL3077(),i18n.GL3078(),i18n.GL3079()};
	String[] higherGrades = new String[]{"High School",i18n.GL3080(),i18n.GL3081(),i18n.GL3082(),i18n.GL3083()};
	String backgroundColor="rgb(16, 118, 187)";
	/**
	 * Class constructor 
	 * @param eventBus {@link EventBus}
	 */
	@Inject
	public GooruGradesView() {
		setWidget(uiBinder.createAndBindUi(this));
		renderGradesLiPanel(elementryPanel,elementaryGrades);
		renderGradesLiPanel(middlePanel,middleGrades);
		renderGradesLiPanel(higherPanel,higherGrades);
	}
	
	public void renderGradesLiPanel(UlPanel ulPanel, String[] stringArray) {
		try{
		
		for(int i=0;i<stringArray.length;i++){
		    LiPanel gradePanel = new LiPanel();
			if(i==0){
				gradePanel.setStyleName("gradeTypes");
			}
			final Anchor lblGrade=new Anchor(stringArray[i]);
			gradePanel.add(lblGrade);
			ulPanel.add(gradePanel);
			gradePanel.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					if(lblGrade.getElement().getStyle().getBackgroundColor().equalsIgnoreCase(backgroundColor)){
						lblGrade.getElement().getStyle().clearBackgroundColor();
					}else{
						lblGrade.getElement().getStyle().setBackgroundColor("#1076bb");
					}
				}
			});
		}
	}catch(Exception e){
				e.printStackTrace();
	 }
	}
}
