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
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.child.ChildView;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
public abstract class ClassSetupUnitView extends ChildView<ClassSetupUnitPresenter> implements IsClassSetupUnitView{

	@UiField HTMLPanel unitSequence,inputContainer,panelComboList,resourceTypePanel,moveAssignmentPopup;
	@UiField Button deleteBtnUnit,cancelBtn,saveBtn;
	@UiField TextBox unitName;
	@UiField Label divContainer,lblMoveTo,resourceCategoryLabel,resoureDropDownLbl;
	@UiField Button btnAssignment,btnReorder;
	private String reorderPathwayId ="";
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
		unitName.setText(unitNameVal);
		divContainer.setText(unitName.getText());
		setPresenter(new ClassSetupUnitPresenter(this));
		unitSequence.getElement().setInnerHTML((sequenceNum+1)+".");
		
		moveAssignmentPopup.getElement().setId("pnlMoveAssignmentPopup");
		panelComboList.getElement().setId("pnlComboList");
		lblMoveTo.getElement().setId("lblMoveTo");
		lblMoveTo.setText(i18n.GL1912());
		resourceTypePanel.setVisible(false);
		lblMoveTo.getElement().setAttribute("alt",i18n.GL1912());
		lblMoveTo.getElement().setAttribute("title",i18n.GL1912());
		resourceCategoryLabel.setText(String.valueOf(sequenceNum+1));
		resoureDropDownLbl.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				resourceTypePanel.setVisible(resourceTypePanel.isVisible() ? false : true);
			}
		});
		resourceCategoryLabel.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				resourceTypePanel.setVisible(resourceTypePanel.isVisible() ? false : true);
			}
		});
		this.reorderPathwayId = pathwayId;
		for (int i=0; i<sequenceNum; i++){
			resourceTypePanel.add(createLabel(""+(i+1),pathwayId));
		}
		Event.addNativePreviewHandler(new NativePreviewHandler() {
	        public void onPreviewNativeEvent(NativePreviewEvent event) {
	        	hideDropDown(event);
	          }
	    });
		
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
				
			}
		});
		saveBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				//api call to save data to be added
				divContainer.setText(unitName.getText());
				inputContainer.setVisible(false);
				divContainer.setVisible(true);
				saveItem(unitName.getText(),pathwayId);
				
			}
		});
		divContainer.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				inputContainer.setVisible(true);
				divContainer.setVisible(false);
				
			}
		});
		
	}
	
	public abstract void deleteItem(int sequenceNum, String pathwayId);
	
	public abstract void saveItem(String pathwayTitle, String pathwayId);
	
	public Label createLabel(String title,final String pathwayId){
		Label lblLabel = new Label();
		lblLabel.setText(title);
		/*lblLabel.getElement().addClassName(res.css().myFolderCollectionFolderDropdown());
		lblLabel.getElement().addClassName(res.css().myFolderCollectionFolderVideoTitle());*/
		lblLabel.getElement().setAttribute("alt", title);
		lblLabel.getElement().setAttribute("title", title);
		lblLabel.getElement().setAttribute("id", title);
		lblLabel.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Label lbl = (Label)event.getSource();
				resourceCategoryLabel.setText(lbl.getText());
				resourceCategoryLabel.getElement().setAttribute("alt",lbl.getText());
				resourceCategoryLabel.getElement().setAttribute("title",lbl.getText());
				System.out.println("pathwayId in click handler:::"+pathwayId);
				System.out.println("clicked element in click handler:::"+lbl.getText());
				AppClientFactory.getInjector().getClasspageService().reOrderPathwaysInaClass(pathwayId, Integer.parseInt(lbl.getText()), new SimpleAsyncCallback<ClasspageListDo>() {

					@Override
					public void onSuccess(ClasspageListDo result) {
						// TODO Auto-generated method stub
						
					}
				});
			}

			
				// TODO Auto-generated method stub
				
			

			
				// TODO Auto-generated method stub
				
			
		});
		return lblLabel;
	}
	
	public void hideDropDown(NativePreviewEvent event){
    	if(event.getTypeInt()==Event.ONMOUSEOVER){
    		Event nativeEvent = Event.as(event.getNativeEvent());
        	boolean target=eventTargetsPopup(nativeEvent);
        	if(!target){
        		resourceTypePanel.setVisible(false);
        	}
    	}
     }
	
	private boolean eventTargetsPopup(NativeEvent event) {
		EventTarget target = event.getEventTarget();
		if (Element.is(target)) {
			return resourceTypePanel.getElement().isOrHasChild(Element.as(target)) || resourceCategoryLabel.getElement().isOrHasChild(Element.as(target))
					|| panelComboList.getElement().isOrHasChild(Element.as(target));
		}
		return false;
	}
}
