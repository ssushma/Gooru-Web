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
package org.ednovo.gooru.client.mvp.classpages.assignments;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.event.AssignmentEvent;
import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.shared.model.content.AssignmentDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;
/**
 * 
 * @fileName : AddAssignmentContainerView.java
 *
 * @description : This file is a UiBinder
 *
 *
 * @version : 1.0
 *
 * @date: 27-Dec-2013
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class AddAssignmentContainerView extends
		PopupViewWithUiHandlers<AddAssignmentContainerUiHandlers> implements
		IsAddAssignmentContainerView {

	String classpageId="";
	
	private static AddAssignmentContainerViewUiBinder uiBinder = GWT
			.create(AddAssignmentContainerViewUiBinder.class);

	interface AddAssignmentContainerViewUiBinder extends
			UiBinder<Widget, AddAssignmentContainerView> {
	}

	private AddAssignmentWidget addAssignmentWidget;

	public AddAssignmentWidget getAddAssignmentWidget() {
		return addAssignmentWidget;
	}

	protected AppPopUp appPopUp;

	@UiField
	HTMLPanel tabViewContainer;

	@UiField
	HTMLEventPanel assignmentTabButton;

	@UiField
	AddAssignmentContainerCBundle res;

	CollectionDo collectionDo = null;
	/**
	 * Constructor 
	 * @param eventBus
	 */
	@Inject
	public AddAssignmentContainerView(EventBus eventBus) {
		super(eventBus);
		appPopUp = new AppPopUp("type");
		appPopUp.setContent(uiBinder.createAndBindUi(this));

		res = AddAssignmentContainerCBundle.INSTANCE;
		AddAssignmentContainerCBundle.INSTANCE.css().ensureInjected();

		tabViewContainer.clear();
		addAssignmentWidget = new AddAssignmentWidget();
		addAssignmentWidget.setClasspageId(classpageId);
		tabViewContainer.add(addAssignmentWidget);
		assignmentTabButton.setStyleName(res.css().buttonSelected());
		assignmentTabButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {

			}
		});
	}
	/**
	 * 
	 * @fileName : AddAssignmentContainerView.java
	 *
	 * @description : This is related to Assignment Popup.
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 27-Dec-2013
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	public class AddAssignmentWidget extends AssignmentPopupView {
	     /**
	      * This is used to close the popup.
	      */
		@Override
		public void hidePopup() {
			Window.enableScrolling(true);
	        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
			hide();
		}
		/**
		 * This is used to get the UIHandlers for create Assignment by passing collectionDo and todays Date as arguments.
		 */
		@Override
		public void createAssignment(CollectionDo collectionDo, String todaysDate) {
			getUiHandlers().createAssignment(collectionDo, todaysDate);
		}
		/**
		 * This is used to get the UIHandlers for create Assignment by passing assignmentDo as argument.
		 */
		@Override
		public void createAssignment(AssignmentDo assignmentDo) {
			getUiHandlers().v2CreateAssignment(assignmentDo);
		}
	}
		/**
		 * It will return the representation of a view as the widget
		 */
		@Override
		public Widget asWidget() {
				addAssignmentWidget.assignmentTitleTxt.setFocus(true);
			return appPopUp;
		}
		/**
		 * This is used to clear the data
		 */
		@Override
		public void reset() {
			// TODO Auto-generated method stub
	
		}
		/**
		 * This method is called immediately after a widget becomes attached to the browser's document.	
	     */
		
		@Override
		public void onLoad() {
			// TODO Auto-generated method stub
	
		}
		/**
		 * This method is called immediately before a widget will be detached from the browser's document
		 */
		@Override
		public void onUnload() {
			appPopUp.hide();
		}
		/**
		 * 
		 * @function getCollectionDo 
		 * 
		 * @created_date : 27-Dec-2013
		 * 
		 * @description : This method is to get the collectionDo.
		 * 
		 * 
		 * @parm(s) : @return
		 * 
		 * @return : CollectionDo
		 *
		 * @throws : <Mentioned if any exceptions>
		 *
		 * 
		 *
		 *
		 */
		public CollectionDo getCollectionDo() {
			return collectionDo;
		}
		/**
		 * 
		 * @function setCollectionDo 
		 * 
		 * @created_date : 27-Dec-2013
		 * 
		 * @description : This is a method to set the collectionDo.
		 * 
		 * 
		 * @parm(s) : @param collectionDo
		 * 
		 * @return : void
		 *
		 * @throws : <Mentioned if any exceptions>
		 *
		 * 
		 *
		 *
		 */
		public void setCollectionDo(CollectionDo collectionDo) {
			this.collectionDo = collectionDo;
		}
	/*Setter and getters */
		/** 
		 * This method is to get the classpageId
		 */
		public String getClasspageId() {
			return classpageId;
		}

		/** 
		 * This method is to set the classpageId
		 */
		public void setClasspageId(String classpageId) {
			addAssignmentWidget.setClasspageId(classpageId);
			this.classpageId = classpageId;
		}
		/**
		 * This method is used to set the assignment data.
		 */
		@Override
		public void setAssignmentData(CollectionItemDo result) {
			//To do create event to insert data.
			AppClientFactory.fireEvent(new AssignmentEvent(result));
			Window.enableScrolling(true);
	        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
	
			hide();
		}
		/**
		 * This is used to reset all the fields.
		 */
		@Override
		public void resetAllFields() {
			
			addAssignmentWidget.clearFields();
		}
	
		@Override
			public void resetClicked() {
				addAssignmentWidget.isClikedMethod();
			}
}
