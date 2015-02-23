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
package org.ednovo.gooru.client.mvp.shelf.collection.folders.item;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.uc.TextBoxWithPlaceholder;
import org.ednovo.gooru.client.util.SetStyleForProfanity;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.folder.FolderDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public abstract class EditAssessmentPopup extends PopupPanel {

	private static EditAssessmentPopupUiBinder uiBinder = GWT
			.create(EditAssessmentPopupUiBinder.class);

	interface EditAssessmentPopupUiBinder extends
			UiBinder<Widget, EditAssessmentPopup> {
	}
	
	static MessageProperties i18n = GWT.create(MessageProperties.class);

	@UiField Button btnSaveAssessment,btnCancelAssessment;
	@UiField Label lblExistingAssessmentError,lblExistingAssessmentURLError;
	@UiField TextBoxWithPlaceholder txtExistingAssessmentTitle,txtExistingAssessmentURL;
	
	public FolderDo folderDo=null;
	
	public EditAssessmentPopup() {
		setWidget(uiBinder.createAndBindUi(this));
	}
	public EditAssessmentPopup(FolderDo folderDo) {
		setWidget(uiBinder.createAndBindUi(this));
		this.folderDo=folderDo;
		txtExistingAssessmentTitle.setPlaceholder(i18n.GL3168());
		txtExistingAssessmentURL.setPlaceholder(i18n.GL3124());
		if(folderDo.getTitle()!=null)
		txtExistingAssessmentTitle.setText(folderDo.getTitle());
		if(folderDo.getUrl()!=null)
		txtExistingAssessmentURL.setText(folderDo.getUrl());
		// This will handle the focus on existing assessment title.
		txtExistingAssessmentTitle.addFocusHandler(new FocusHandler() {
			@Override
			public void onFocus(FocusEvent event) {
				if (lblExistingAssessmentError.isVisible()) {
					lblExistingAssessmentError.setVisible(false);
					txtExistingAssessmentTitle.getElement().removeAttribute("style");
				}
			}
		});
		// This will handle the focus on existing assessment URL.
		txtExistingAssessmentURL.addFocusHandler(new FocusHandler() {
			@Override
			public void onFocus(FocusEvent event) {
				if (lblExistingAssessmentURLError.isVisible()) {
					lblExistingAssessmentURLError.setVisible(false);
					txtExistingAssessmentURL.getElement().removeAttribute("style");
				}
			}
		});
	}
	@UiHandler("btnSaveAssessment")
	public void clickEventOnSaveAssessment(final ClickEvent event){
		//Code when save or update assessment clicked
		final String assessmentExistingTitle=txtExistingAssessmentTitle.getText();
		final String assessmentURL=txtExistingAssessmentURL.getText();
		if(assessmentExistingTitle.isEmpty()){
			lblExistingAssessmentError.setVisible(true);
			lblExistingAssessmentError.setText(i18n.GL1026());
		}else if(assessmentURL.isEmpty()){
			lblExistingAssessmentError.setVisible(false);
			lblExistingAssessmentError.setText("");
			lblExistingAssessmentURLError.setVisible(true);
			lblExistingAssessmentURLError.setText(i18n.GL3166());
		}else{
			final Map<String, String> parms = new HashMap<String, String>();
			parms.put("text", assessmentExistingTitle);
			AppClientFactory.getInjector().getResourceService().checkProfanity(parms,new AsyncCallback<Boolean>() {
				@Override
				public void onSuccess(Boolean value) {
					if(value){
						//Displaying error message
						SetStyleForProfanity.SetStyleForProfanityForTextBoxWithPlaceholder(txtExistingAssessmentTitle, lblExistingAssessmentError, value);
					}else{
						lblExistingAssessmentError.setVisible(false);
						lblExistingAssessmentError.setText("");
						parms.put("text", assessmentURL);
						AppClientFactory.getInjector().getResourceService().checkProfanity(parms,new AsyncCallback<Boolean>() {
							@Override
							public void onSuccess(Boolean result) {
								if(result){
									//Displaying error message
									SetStyleForProfanity.SetStyleForProfanityForTextBoxWithPlaceholder(txtExistingAssessmentURL, lblExistingAssessmentURLError, result);
								}else{
									lblExistingAssessmentURLError.setVisible(false);
									lblExistingAssessmentURLError.setText("");
									//Update code here
									AppClientFactory.getInjector().getResourceService().updateAssessmentDetails(folderDo.getGooruOid(), assessmentExistingTitle, assessmentURL, new AsyncCallback<FolderDo>() {
										
										@Override
										public void onSuccess(FolderDo result) {
											clickEventOnSaveAssessmentHandler(result);
										}
										
										@Override
										public void onFailure(Throwable caught) {
										}
									});
								}
							}
							@Override
							public void onFailure(Throwable caught) {
								
							}
						});
					}
				}
				@Override
				public void onFailure(Throwable caught) {
				}
			});
		}
	}
	@UiHandler("btnCancelAssessment")
	public void clickEventOnCancelAssessment(ClickEvent event){
		clickEventOnCancelAssessmentHandler(event);
	}
	abstract void clickEventOnSaveAssessmentHandler(FolderDo result);
	abstract void clickEventOnCancelAssessmentHandler(ClickEvent event);
}
