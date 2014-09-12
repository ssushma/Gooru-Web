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
package org.ednovo.gooru.client.mvp.classpages.classsetup;
import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.child.ChildView;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
public abstract class ClassSetupUnitView extends ChildView<ClassSetupUnitPresenter> implements IsClassSetupUnitView{

	@UiField HTMLPanel unitSequence,inputContainer;
	@UiField Button deleteBtnUnit,cancelBtn,saveBtn,editBtn;
	@UiField TextBox unitName;
	@UiField Button btnAssignment;
	@UiField HTMLEventPanel divContainer;
	@UiField Label unitnameLBL,unitNameErrorLabel;
	private static ClassSetupUnitViewUiBinder uiBinder = GWT.create(ClassSetupUnitViewUiBinder.class);

	interface ClassSetupUnitViewUiBinder extends UiBinder<Widget, ClassSetupUnitView> {
		
	}
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	

	public ClassSetupUnitView(){
		initWidget(uiBinder.createAndBindUi(this));		
		setPresenter(new ClassSetupUnitPresenter(this));
	}
	
	public ClassSetupUnitView(final int sequenceNum, String unitNameVal, final String pathwayId){
		initWidget(uiBinder.createAndBindUi(this));
		inputContainer.setVisible(false);
		divContainer.setVisible(true);
		editBtn.setVisible(false);
		unitNameErrorLabel.setVisible(false);
		unitName.setText(unitNameVal);
		unitnameLBL.setText(unitName.getText());
		unitName.setMaxLength(50);
		setPresenter(new ClassSetupUnitPresenter(this));
		unitSequence.getElement().setInnerHTML((sequenceNum)+".");
		
		deleteBtnUnit.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				deleteItem(sequenceNum,pathwayId);
				
			}
		});
		cancelBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				inputContainer.setVisible(false);
				divContainer.setVisible(true);
				editBtn.setVisible(false);
				
			}
		});
		saveBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				//api call to save data to be added
				if(!unitName.getText().isEmpty())
				{
				Map<String, String> parms = new HashMap<String, String>();
				parms.put("text", unitName.getText());
				AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {
					
					@Override
					public void onSuccess(Boolean value) {
						boolean isHavingBadWords = value;
						if (isHavingBadWords){
							unitNameErrorLabel.setText(i18n.GL0554());
							unitNameErrorLabel.setVisible(true);
							unitNameErrorLabel.getElement().getStyle().setColor("orange");
							unitNameErrorLabel.getElement().getStyle().setPosition(Position.ABSOLUTE);
						}else{
							unitNameErrorLabel.setVisible(false);
							unitNameErrorLabel.getElement().getStyle().clearBackgroundColor();
							unitNameErrorLabel.getElement().getStyle().setBorderColor("#ccc");
							
							unitnameLBL.setText(unitName.getText());
							inputContainer.setVisible(false);
							divContainer.setVisible(true);
							editBtn.setVisible(false);
							saveItem(unitName.getText(),pathwayId);
							
						}
					}
				});
				}
				else
				{
					unitNameErrorLabel.setText(i18n.GL2177());
					unitNameErrorLabel.setVisible(true);
					unitNameErrorLabel.getElement().getStyle().setBorderColor("orange");
				}
				
				
				
				
				
				
		
			}
		});
		editBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				inputContainer.setVisible(true);
				divContainer.setVisible(false);
				
			}
		});
		divContainer.addMouseOverHandler(new MouseOverHandler() {
			
			@Override
			public void onMouseOver(MouseOverEvent event) {
				editBtn.setVisible(true);
				
			}
		});
		divContainer.addMouseOutHandler(new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
				editBtn.setVisible(false);
				
			}
		});
	}
	
	public abstract void deleteItem(int sequenceNum, String pathwayId);
	
	public abstract void saveItem(String pathwayTitle, String pathwayId);
	
}
