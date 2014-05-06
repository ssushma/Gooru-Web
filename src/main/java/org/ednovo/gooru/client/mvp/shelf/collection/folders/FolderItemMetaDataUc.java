package org.ednovo.gooru.client.mvp.shelf.collection.folders;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.UpdateShelfFolderMetaDataEvent;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.BodyElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.IFrameElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.logical.shared.InitializeEvent;
import com.google.gwt.event.logical.shared.InitializeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.Widget;

public class FolderItemMetaDataUc extends Composite implements MessageProperties{

	@UiField Button closeItem, saveBtn, cancelBtn;
	
	@UiField HTML bigIdeasLbl, essentialQuestionsLbl, performanceTaskLbl;
	
	@UiField RichTextArea bigIdeasHTML, essentialQuestionsHTML, performanceTaskHTML;
	
	@UiField HTMLPanel formButtons, performanceTaskPanel, essentialQuestionsPanel, bigIdeasPanel;
	
	@UiField FolderItemMetaDataUcStyleBundle folderMetaStyle;
	
	@UiField Label ideasStaticLbl, questionsStaticLbl, tasksStaticLbl;
	
	private String folderId = null, title = null, bigIdeas = "", essentialQuestions = "", performanceTask = "";
	
	private static FolderItemMetaDataUcUiBinder uiBinder = GWT
			.create(FolderItemMetaDataUcUiBinder.class);

	interface FolderItemMetaDataUcUiBinder extends
			UiBinder<Widget, FolderItemMetaDataUc> {
	}

	public FolderItemMetaDataUc() {
		initWidget(uiBinder.createAndBindUi(this));
		setDebugIds();
		showEditableMetaData(true);
		bigIdeasHTML.addInitializeHandler(new InitializeHandler() {
			@Override
			public void onInitialize(InitializeEvent event) {
			    Document document = IFrameElement.as(bigIdeasHTML.getElement()).getContentDocument();
                BodyElement body = document.getBody();
                body.setAttribute("style", "font-family: Arial;font-size:12px;");
			}
		});
		
		bigIdeasHTML.addKeyDownHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				bigIdeasHTML.setHTML(restrictKeyLimit(event, bigIdeasHTML.getText()));
			}
		});
		
		essentialQuestionsHTML.addInitializeHandler(new InitializeHandler() {
			@Override
			public void onInitialize(InitializeEvent event) {
			    Document document = IFrameElement.as(essentialQuestionsHTML.getElement()).getContentDocument();
                BodyElement body = document.getBody();
                body.setAttribute("style", "font-family: Arial;font-size:12px;");
			}
		});
		
		essentialQuestionsHTML.addKeyDownHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				essentialQuestionsHTML.setHTML(restrictKeyLimit(event, essentialQuestionsHTML.getText()));
			}
		});

		performanceTaskHTML.addInitializeHandler(new InitializeHandler() {
			@Override
			public void onInitialize(InitializeEvent event) {
			    Document document = IFrameElement.as(performanceTaskHTML.getElement()).getContentDocument();
                BodyElement body = document.getBody();
                body.setAttribute("style", "font-family: Arial;font-size:12px;");
			}
		});
		
		performanceTaskHTML.addKeyDownHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				performanceTaskHTML.setHTML(restrictKeyLimit(event, performanceTaskHTML.getText()));
			}
		});

	}
	
	private void setDebugIds() {
		ideasStaticLbl.setText(GL1731);
		questionsStaticLbl.setText(GL1732);
		tasksStaticLbl.setText(GL1733);
		saveBtn.setText(GL0141);
		cancelBtn.setText(GL0142);
	}
	
	private String restrictKeyLimit(KeyDownEvent event, String text) {
		 if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER ||
                 event.getNativeKeyCode() == KeyCodes.KEY_UP ||
                 event.getNativeKeyCode() == KeyCodes.KEY_LEFT||
                 event.getNativeKeyCode() == KeyCodes.KEY_DOWN ||
                 event.getNativeKeyCode() == KeyCodes.KEY_BACKSPACE||
                 event.getNativeKeyCode() == KeyCodes.KEY_SHIFT) {
			 
         } else {
	         if(text.trim().length()>600){
	        	 event.preventDefault();
	         }
         }
		 return text;
	}
	
	public void setMetaData(String bigIdeas, String essentialQuestions, String performanceTask) {
		this.bigIdeas = bigIdeas;
		this.essentialQuestions = essentialQuestions;
		this.performanceTask = performanceTask;
		if(bigIdeas==null || bigIdeas.isEmpty()) {
			bigIdeas = GL1725;
		}
		if(essentialQuestions==null || essentialQuestions.isEmpty()) {
			essentialQuestions = GL1726;
		}
		if(performanceTask==null || performanceTask.isEmpty()) {
			performanceTask = GL1727;
		}
		
		bigIdeasLbl.setHTML(bigIdeas);
		essentialQuestionsLbl.setHTML(essentialQuestions);
		performanceTaskLbl.setHTML(performanceTask);
	}
	
	public void showEditableMetaData(boolean isVisible) {
		bigIdeasLbl.setVisible(isVisible);
		essentialQuestionsLbl.setVisible(isVisible);
		performanceTaskLbl.setVisible(isVisible);
		
		bigIdeasHTML.setVisible(!isVisible);
		essentialQuestionsHTML.setVisible(!isVisible);
		performanceTaskHTML.setVisible(!isVisible);
		formButtons.setVisible(!isVisible);
		System.out.println(bigIdeas);
		System.out.println(essentialQuestions);
		System.out.println(performanceTask);
		
		if(!bigIdeas.isEmpty()) {
			bigIdeasHTML.setHTML(bigIdeasLbl.getText());
		}
		if(!essentialQuestions.isEmpty()) {
			essentialQuestionsHTML.setHTML(essentialQuestionsLbl.getText());
		}
		if(!performanceTask.isEmpty()) {
			performanceTaskHTML.setHTML(performanceTaskLbl.getText());
		}
	}
	
	@UiHandler("saveBtn")
	public void clickSaveBtn(ClickEvent event) {
		setMetaData(bigIdeasHTML.getHTML(), essentialQuestionsHTML.getHTML(), performanceTaskHTML.getHTML());
		AppClientFactory.fireEvent(new UpdateShelfFolderMetaDataEvent(bigIdeasHTML.getHTML(), performanceTaskHTML.getHTML(), essentialQuestionsHTML.getHTML()));
		showEditableMetaData(true);
		updateFolderMetaData();
	}
	
	@UiHandler("cancelBtn")
	public void clickCancelBtn(ClickEvent event) {
		showEditableMetaData(true);
	}
	
	@UiHandler("closeItem")
	public void clickCloseItem(ClickEvent event) {
		showEditableMetaData(true);
		if(closeItem.getStyleName().contains(folderMetaStyle.closeItem())) {
			performanceTaskPanel.addStyleName(folderMetaStyle.closedPanelHeight());
			essentialQuestionsPanel.addStyleName(folderMetaStyle.closedPanelHeight());
			bigIdeasPanel.addStyleName(folderMetaStyle.closedPanelHeight());
			closeItem.removeStyleName(folderMetaStyle.closeItem());
			closeItem.addStyleName(folderMetaStyle.openItem());
		} else {
			performanceTaskPanel.removeStyleName(folderMetaStyle.closedPanelHeight());
			essentialQuestionsPanel.removeStyleName(folderMetaStyle.closedPanelHeight());
			bigIdeasPanel.removeStyleName(folderMetaStyle.closedPanelHeight());
			closeItem.addStyleName(folderMetaStyle.closeItem());
			closeItem.removeStyleName(folderMetaStyle.openItem());
		}
	}
	
	public void updateFolderData(String folderId, String title) {
		this.folderId = folderId;
		this.title = title;
	}
	
	public void updateFolderMetaData() {
		AppClientFactory.getInjector().getfolderService().updateFolder(folderId, title, bigIdeasHTML.getHTML(), essentialQuestionsHTML.getHTML(), performanceTaskHTML.getHTML(), new SimpleAsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				
			}
		});
	}
}