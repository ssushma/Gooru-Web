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

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.child.ChildView;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.classpages.event.ResetPaginationEvent;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.vc.DeletePopupViewVc;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;
import org.ednovo.gooru.shared.model.content.UnitAssignmentsDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
public abstract class ClassSetupUnitView extends ChildView<ClassSetupUnitPresenter> implements IsClassSetupUnitView{

	@UiField ClassSetupCBundle res;
	@UiField HTMLPanel unitSequence,inputContainer,panelComboList,resourceTypePanel;
	@UiField HTMLEventPanel moveAssignmentPopup;
	@UiField Button deleteBtnUnit,cancelBtn,saveBtn,editBtn,cancelButton,saveButton;
	@UiField TextBox unitName;
	@UiField Button btnReorder;
	@UiField HTMLEventPanel divContainer;
	@UiField Label unitnameLBL,unitNameErrorLabel,lblMoveTo,resourceCategoryLabel,resoureDropDownLbl;
	
	String ClickedLabelNum ="";
	String ClickedCollectionItemId ="";
	String totalNoOfAssignments="";

	private static ClassSetupUnitViewUiBinder uiBinder = GWT.create(ClassSetupUnitViewUiBinder.class);

	interface ClassSetupUnitViewUiBinder extends UiBinder<Widget, ClassSetupUnitView> {
		
	}
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	

	public ClassSetupUnitView(){
		initWidget(uiBinder.createAndBindUi(this));		
		setPresenter(new ClassSetupUnitPresenter(this));
		this.res = ClassSetupCBundle.INSTANCE;
		res.css().ensureInjected();
	}
	
	public ClassSetupUnitView(final int sequenceNum, String unitNameVal, final String pathwayId,final int totalhitCounter,final String collectionItemId){
		initWidget(uiBinder.createAndBindUi(this));
		this.res = ClassSetupCBundle.INSTANCE;
		res.css().ensureInjected();
		inputContainer.setVisible(false);
		divContainer.setVisible(true);
		//editBtn.setVisible(false);
		unitNameErrorLabel.setVisible(false);
		saveBtn.setVisible(false);
		cancelBtn.setVisible(false);
		unitName.setText(unitNameVal);
		unitnameLBL.setText(unitName.getText());
		unitName.setMaxLength(50);
		setPresenter(new ClassSetupUnitPresenter(this));
		unitSequence.getElement().setInnerHTML((sequenceNum)+".");
		moveAssignmentPopup.getElement().setId("pnlMoveAssignmentPopup");
		panelComboList.getElement().setId("pnlComboList");
		lblMoveTo.getElement().setId("lblMoveTo");
		lblMoveTo.setText(i18n.GL1912());
		resourceTypePanel.setVisible(false);
		lblMoveTo.getElement().setAttribute("alt",i18n.GL1912());
		lblMoveTo.getElement().setAttribute("title",i18n.GL1912());
		resourceTypePanel.getElement().setAttribute("style", "background-color:white;z-index: 9999;");
		cancelButton.getElement().setAttribute("style", "display: inline-block;");
		saveButton.getElement().setAttribute("style", "display: inline-block;");
		btnReorder.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				moveAssignmentPopup.getElement().getStyle().setDisplay(Display.BLOCK);
			}
		});
		btnReorder.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				// TODO Auto-generated method stub
				moveAssignmentPopup.getElement().getStyle().setDisplay(Display.BLOCK);
			}
		});
		btnReorder.addMouseOutHandler(new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
				// TODO Auto-generated method stub
				moveAssignmentPopup.getElement().getStyle().setDisplay(Display.NONE);
			}
		});
		moveAssignmentPopup.addMouseOverHandler(new MouseOverHandler() {
			
			@Override
			public void onMouseOver(MouseOverEvent event) {
				moveAssignmentPopup.getElement().getStyle().setDisplay(Display.BLOCK);
				
			}
		});
		moveAssignmentPopup.addMouseOutHandler(new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
				moveAssignmentPopup.getElement().getStyle().setDisplay(Display.NONE);
				
			}
		});
		resourceCategoryLabel.setText(String.valueOf(sequenceNum));
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
	
		
		
		for (int i=0; i<totalhitCounter; i++){
			resourceTypePanel.add(createLabel(""+(i+1),collectionItemId,totalhitCounter));
		}
		Event.addNativePreviewHandler(new NativePreviewHandler() {
	        public void onPreviewNativeEvent(NativePreviewEvent event) {
	        	hideDropDown(event);
	          }
	    });
		
		deleteBtnUnit.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String classpageId=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
				if(classpageId != null){
					AppClientFactory.getInjector().getClasspageService().v2GetPathwayItems(classpageId, pathwayId, "sequence", 1, 0, new SimpleAsyncCallback<UnitAssignmentsDo>() {
						@Override
						public void onSuccess(UnitAssignmentsDo result) {
							totalNoOfAssignments = result.getTotalHitCount().toString();
							Window.enableScrolling(false);
							AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
							DeletePopupViewVc delete = new DeletePopupViewVc() {
								@Override
								public void onClickPositiveButton(ClickEvent event) {
									deleteItem(sequenceNum,pathwayId);
									Window.enableScrolling(true);
									AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
									hide();
								}
								@Override
								public void onClickNegitiveButton(ClickEvent event) {
									Window.enableScrolling(true);
									AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
									hide();
								}
							};
							delete.setPopupTitle((i18n.GL0748()));
							delete.setNotes(i18n.GL2244());
							delete.setDescText(StringUtil.generateMessage(i18n.GL2245() + i18n.GL_SPL_FULLSTOP() + i18n.GL2246()+ i18n.GL_SPL_FULLSTOP(),totalNoOfAssignments));
							delete.setPositiveButtonText(i18n.GL0190());
							delete.setNegitiveButtonText(i18n.GL0142());
							delete.setDeleteValidate("delete");
							delete.setPixelSize(450, 345);
							delete.show();
							delete.center();
						}
					});
				}
			}
		});
		cancelBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				inputContainer.setVisible(false);
				divContainer.setVisible(true);
				saveBtn.setVisible(false);
				cancelBtn.setVisible(false);
				editBtn.setVisible(true);
				
			}
		});
		saveBtn.addClickHandler(new ClickHandler() {
		
			@Override
			public void onClick(ClickEvent event) {
				
				//api call to save data to be added
				if(!unitName.getText().isEmpty())
				{
				if(!unitName.getText().trim().isEmpty())
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
							unitNameErrorLabel.getElement().getStyle().setBorderColor("orange");
							unitNameErrorLabel.getElement().getStyle().setPosition(Position.ABSOLUTE);
							unitNameErrorLabel.getElement().getStyle().setColor("orange");
						}else{
							unitNameErrorLabel.setVisible(false);
							unitNameErrorLabel.getElement().getStyle().clearBackgroundColor();
							unitNameErrorLabel.getElement().getStyle().setBorderColor("#ccc");
							
							unitnameLBL.setText(unitName.getText());
							inputContainer.setVisible(false);
							divContainer.setVisible(true);
							saveBtn.setVisible(false);
							cancelBtn.setVisible(false);
							editBtn.setVisible(true);
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
					unitNameErrorLabel.getElement().getStyle().setPosition(Position.ABSOLUTE);
					unitNameErrorLabel.getElement().getStyle().setColor("orange");
				}
			}
			else
			{
				
				unitNameErrorLabel.setText(i18n.GL2177());
				unitNameErrorLabel.setVisible(true);
				unitNameErrorLabel.getElement().getStyle().setBorderColor("orange");
				unitNameErrorLabel.getElement().getStyle().setPosition(Position.ABSOLUTE);
				unitNameErrorLabel.getElement().getStyle().setColor("orange");
			}
			}
		});
		editBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
//here
				unitNameErrorLabel.setVisible(false);
				unitNameErrorLabel.getElement().getStyle().clearBackgroundColor();
				unitNameErrorLabel.getElement().getStyle().setBorderColor("#ccc");
				unitName.setText(unitnameLBL.getText());
				inputContainer.setVisible(true);
				divContainer.setVisible(false);
				saveBtn.setVisible(true);
				cancelBtn.setVisible(true);
				editBtn.setVisible(false);
				
			}
		});

	
		saveButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if(ClickedLabelNum!=null && !ClickedLabelNum.isEmpty()){
				AppClientFactory.getInjector().getClasspageService().reOrderPathwaysInaClass(ClickedCollectionItemId, Integer.parseInt(ClickedLabelNum), new SimpleAsyncCallback<ClasspageListDo>() {
					@Override
					public void onSuccess(ClasspageListDo result) {
						resourceTypePanel.setVisible(resourceTypePanel.isVisible() ? false : true);
						redirectToPage(totalhitCounter);
					}

					private void redirectToPage(int totalhitCounter) {

						int clickedNumber =	Integer.parseInt(ClickedLabelNum);
								int redirectedPageNumber = (clickedNumber / 5)
										+((clickedNumber % 5) >0 ?1 : 0);
								Map<String,String> params = new HashMap<String,String>();
								String pageSize=AppClientFactory.getPlaceManager().getRequestParameter("pageSize", null);
								String classpageid=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
								String pageNum=AppClientFactory.getPlaceManager().getRequestParameter("pageNum", null);
								String pos=AppClientFactory.getPlaceManager().getRequestParameter("pos", null);
								params.put("pageSize", pageSize);
								params.put("classpageid", classpageid);
								params.put("pageNum", redirectedPageNumber+"");
								params.put("pos", pos);
								PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.EDIT_CLASSPAGE, params);
								AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
								int offSetVal = 0;
								if(redirectedPageNumber!=0)
								{
								offSetVal = redirectedPageNumber-1;
								}

								AppClientFactory.fireEvent(new ResetPaginationEvent(offSetVal*5));
						/*	}*///end if loop
						
					}

				});
				
		}//end if loop.
				
			}
		});
		
		cancelButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				moveAssignmentPopup.getElement().getStyle().setDisplay(Display.NONE);

			}
		});
		
		unitName.addKeyUpHandler(new KeyUpHandler() {
			
			@Override
			public void onKeyUp(KeyUpEvent event) {
				if(unitName.getText().length()==50)
				{
					unitNameErrorLabel.setText(i18n.GL0143());
					unitNameErrorLabel.setVisible(true);
					unitNameErrorLabel.getElement().getStyle().setBorderColor("orange");
					unitNameErrorLabel.getElement().getStyle().setPosition(Position.ABSOLUTE);
					unitNameErrorLabel.getElement().getStyle().setColor("orange");
				}
				else
				{
					unitNameErrorLabel.setVisible(false);
					unitNameErrorLabel.getElement().getStyle().clearBackgroundColor();
					unitNameErrorLabel.getElement().getStyle().setBorderColor("#ccc");
					
				}
				
			}
		});

	}
	
	public abstract void deleteItem(int sequenceNum, String pathwayId);
	
	public abstract void saveItem(String pathwayTitle, String pathwayId);
	
	public Label createLabel(String title,final String pathwayId,final int totalhitCounter){
		Label lblLabel = new Label();
		lblLabel.setText(title);
		lblLabel.getElement().addClassName(res.css().myFolderCollectionFolderDropdown());
		lblLabel.getElement().addClassName(res.css().myFolderCollectionFolderVideoTitle());
		lblLabel.getElement().setAttribute("alt", title);
		lblLabel.getElement().setAttribute("title", title);
		lblLabel.getElement().setAttribute("id", title);
		
		lblLabel.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				final Label lbl = (Label)event.getSource();
				resourceCategoryLabel.setText(lbl.getText());
				resourceCategoryLabel.getElement().setAttribute("alt",lbl.getText());
				resourceCategoryLabel.getElement().setAttribute("title",lbl.getText());
				ClickedLabelNum = lbl.getText();
				ClickedCollectionItemId = pathwayId;
			}
			
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
