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
package org.ednovo.gooru.client.mvp.shelf.collection;

import java.util.List;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.client.uc.CloseLabel;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.user.UserDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 *
 */
public class CollectionCollaboratorTabVc extends Composite {
	
	private static EditCollaboratorVcUiBinder uiBinder = GWT.create(EditCollaboratorVcUiBinder.class);

	interface EditCollaboratorVcUiBinder extends UiBinder<Widget, CollectionCollaboratorTabVc> {
	}
	private static MessageProperties i18n = GWT.create(MessageProperties.class);
	
    private static final String USER_DOES_NOT_EXIST = i18n.GL1488();
	
	private static final String COLLABORATOR_ALREADY_ADDED = i18n.GL1489(); 


	@UiField
	FlowPanel addedCollaboratorFloPanel;

	@UiField
	TextBox collaboratorTxtBox;

	@UiField
	Label gooruBlueLbl,collaboratorsText,addRecentText;

	private CollectionDo collection = null;

	/**
	 * Class constructor , get collection collaborator and sets instance of CollectionDo 
	 * @param collectionDo instance of {@link CollectionDo}
	 */
	public CollectionCollaboratorTabVc(CollectionDo collectionDo) {
		this.collection = collectionDo;
		initWidget(uiBinder.createAndBindUi(this));
		collaboratorsText.setText(i18n.GL0832());
		collaboratorsText.getElement().setId("lblCollaboratorsText");
		collaboratorsText.getElement().setAttribute("alt",i18n.GL0832());
		collaboratorsText.getElement().setAttribute("title",i18n.GL0832());
		
		gooruBlueLbl.setText(i18n.GL0590());
		gooruBlueLbl.getElement().setId("lblGooruBlueLbl");
		gooruBlueLbl.getElement().setAttribute("alt",i18n.GL0590());
		gooruBlueLbl.getElement().setAttribute("title",i18n.GL0590());
		
		addRecentText.setText(i18n.GL0833());
		addRecentText.getElement().setId("lblAddRecentText");
		addRecentText.getElement().setAttribute("alt",i18n.GL0833());
		addRecentText.getElement().setAttribute("title",i18n.GL0833());
		
		collaboratorTxtBox.addKeyUpHandler(new OnTextPress());
		collaboratorTxtBox.getElement().setId("txtCollaboratorTxtBox");
		StringUtil.setAttributes(collaboratorTxtBox, true);
		addedCollaboratorFloPanel.getElement().setId("fpnlAddedCollaboratorFloPanel");
	}

	/**
	 * allows to add collection collaborator
	 * @param event {@link ClickEvent} instance 
	 */
	@UiHandler("gooruBlueLbl")
	public void AddingCollab(ClickEvent event) {
		getcollaborator();
	}

	/**
	 * @param collaborator collection collaborator user names
	 * @param emailId collection collaborator email id
	 */
	public void handleEvent(final String collaborator, final String emailId) {
		CloseLabel filterSuggestItem = new CloseLabel(collaborator){

			@Override
			public void onCloseLabelClick(ClickEvent event) {
				
			}
			
		};
		filterSuggestItem.getLabelSource().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				AppClientFactory.getInjector().getResourceService().deleteCollaborators(collection.getGooruOid(), emailId, new SimpleAsyncCallback<UserDo>() {
					@Override
					public void onSuccess(UserDo user) {
					}
				});
			}
		});
		addedCollaboratorFloPanel.add(filterSuggestItem);
		collaboratorTxtBox.setText("");
	}

	/**
	 * @author Search Team
	 *
	 * keyUpHandler event to get collaborator list
	 */
	private class OnTextPress implements KeyUpHandler {
		@Override
		public void onKeyUp(KeyUpEvent event) {
			if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
				getcollaborator();
			}
		}
	}

	/**
	 * Check if the user has and account in gooru or not and create alert popup if user is not exists 
	 * @param user instance of {@link UserDo} object
	 * @param email user email id used to find out availability
	 */
	private void checkAvailability(UserDo user, String email) {
		if (user.isAvailability() && user.getConfirmStatus() == 0) {
			new AlertContentUc(i18n.GL0065(), i18n.GL0092());

		} else if (user.isAvailability() && user.getConfirmStatus() == 1) {
			AppClientFactory.getInjector().getResourceService().addCollaborator(collection.getGooruOid(), user.getExternalId(), new SimpleAsyncCallback<UserDo>() {
				@Override
				public void onSuccess(UserDo user) {
					handleEvent(user.getUsername(), user.getEmailId());
				}
			});

		} else {
			new AlertContentUc(i18n.GL0061(), USER_DOES_NOT_EXIST);
		}
	}

	/**
	 * get added collaborator for the collection by user name 
	 */
	private void getcollaborator() {
		if (collaboratorTxtBox.getText() != null && collaboratorTxtBox.getText().length() > 0) {
			final String text = collaboratorTxtBox.getValue();
			if (!hasCollaboraor(text)) {
				AppClientFactory.getInjector().getUserService().getEmailId(text, "byUsername", new SimpleAsyncCallback<UserDo>() {
					@Override
					public void onSuccess(UserDo user) {
						checkAvailability(user, text);
					}
				});
			} else {
				new AlertContentUc(i18n.GL0061(),COLLABORATOR_ALREADY_ADDED);
				collaboratorTxtBox.setText("");
			}
		}
	}

	private boolean hasCollaboraor(String collaborator) {
		for (Widget widget : addedCollaboratorFloPanel) {
			CloseLabel filterSuggestItem = (CloseLabel) widget;
			String hasCourses = filterSuggestItem.getSourceText();
			if (collaborator.equalsIgnoreCase(hasCourses)) {
				return true;
			}
		}
		return false;
	}

}
