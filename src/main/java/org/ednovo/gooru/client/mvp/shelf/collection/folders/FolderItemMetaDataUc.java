package org.ednovo.gooru.client.mvp.shelf.collection.folders;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.UpdateShelfFolderMetaDataEvent;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.BodyElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.IFrameElement;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
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
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class FolderItemMetaDataUc extends Composite implements MessageProperties{

	@UiField Button closeItem, saveBtn, cancelBtn;
	
	@UiField HTML bigIdeasLbl, essentialQuestionsLbl, performanceTaskLbl;
	
	@UiField TextArea bigIdeasHTML, essentialQuestionsHTML, performanceTaskHTML;
	
	@UiField HTMLPanel formButtons, performanceTaskPanel, essentialQuestionsPanel, bigIdeasPanel;
	
	@UiField FolderItemMetaDataUcStyleBundle folderMetaStyle;
	
	@UiField Label ideasStaticLbl, questionsStaticLbl, tasksStaticLbl,errorLabelbigIdeasHTML,errorLabelperformanceTaskHTML,errorLabelessentialQuestionsHTML;
	
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
		
		bigIdeasHTML.getElement().setAttribute("maxlength", "600");
		essentialQuestionsHTML.getElement().setAttribute("maxlength", "600");
		performanceTaskHTML.getElement().setAttribute("maxlength", "600");
		
		bigIdeasHTML.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				restrictKeyLimit(event, bigIdeasHTML, bigIdeasHTML.getText(), errorLabelbigIdeasHTML);
			}
		});
		
		bigIdeasHTML.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				restrictKeyLimit(null, bigIdeasHTML, bigIdeasHTML.getText(), errorLabelbigIdeasHTML);
			}
		});
		
		essentialQuestionsHTML.addKeyPressHandler(new KeyPressHandler() {			
			@Override
			public void onKeyPress(KeyPressEvent event) {
				restrictKeyLimit(event, essentialQuestionsHTML, essentialQuestionsHTML.getText(), errorLabelessentialQuestionsHTML);
			}
		});

		essentialQuestionsHTML.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				restrictKeyLimit(null, essentialQuestionsHTML, essentialQuestionsHTML.getText(), errorLabelessentialQuestionsHTML);
			}
		});
		
		performanceTaskHTML.addKeyPressHandler(new KeyPressHandler() {			
			@Override
			public void onKeyPress(KeyPressEvent event) {
				restrictKeyLimit(event, performanceTaskHTML, performanceTaskHTML.getText(), errorLabelperformanceTaskHTML);
			}
		});

		performanceTaskHTML.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				restrictKeyLimit(null, performanceTaskHTML, performanceTaskHTML.getText(), errorLabelperformanceTaskHTML);
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
	
	private void restrictKeyLimit(KeyPressEvent event, TextArea textArea, String text, Label errorLabelToDisplay) {
		if(text.trim().length()<=599) {
			errorLabelToDisplay.setVisible(false);	 
		} else if(text.trim().length()>598) {
			if(event==null) {
				textArea.cancelKey();
				errorLabelToDisplay.setVisible(true);
				errorLabelToDisplay.setText(GL0143);	        	 
			} else {
				if(event.isControlKeyDown() || event.isShiftKeyDown() ||
						((event.getNativeEvent().getKeyCode() == KeyCodes.KEY_UP)) || 
						((event.getNativeEvent().getKeyCode() == KeyCodes.KEY_LEFT)) || 
						((event.getNativeEvent().getKeyCode() == KeyCodes.KEY_DOWN)) || 
						((event.getNativeEvent().getKeyCode() == KeyCodes.KEY_RIGHT)) || 
						((event.getNativeEvent().getKeyCode() == KeyCodes.KEY_BACKSPACE)) || 
						((event.getNativeEvent().getKeyCode() == KeyCodes.KEY_DELETE))) {
				} else {
					textArea.cancelKey();
					errorLabelToDisplay.setVisible(true);
					errorLabelToDisplay.setText(GL0143);
				}
			}
		}
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
		
		bigIdeasLbl.setText(bigIdeas);
		essentialQuestionsLbl.setText(essentialQuestions);
		performanceTaskLbl.setText(performanceTask);
		
		errorLabelbigIdeasHTML.setVisible(false);
		errorLabelessentialQuestionsHTML.setVisible(false);
		errorLabelperformanceTaskHTML.setVisible(false);
		
		bigIdeasHTML.getElement().removeAttribute("style");
		essentialQuestionsHTML.getElement().removeAttribute("style");
		performanceTaskHTML.getElement().removeAttribute("style");
		
	}
	
	public void beforeEditSetOpen() {
		performanceTaskPanel.removeStyleName(folderMetaStyle.closedPanelHeight());
		essentialQuestionsPanel.removeStyleName(folderMetaStyle.closedPanelHeight());
		bigIdeasPanel.removeStyleName(folderMetaStyle.closedPanelHeight());
		closeItem.addStyleName(folderMetaStyle.closeItem());
		closeItem.removeStyleName(folderMetaStyle.openItem());
	}
	
	public void showEditableMetaData(boolean isVisible) {
		
		bigIdeasLbl.setVisible(isVisible);
		essentialQuestionsLbl.setVisible(isVisible);
		performanceTaskLbl.setVisible(isVisible);
		
		bigIdeasHTML.setVisible(!isVisible);
		essentialQuestionsHTML.setVisible(!isVisible);
		performanceTaskHTML.setVisible(!isVisible);
		formButtons.setVisible(!isVisible);
		
		if(!bigIdeas.isEmpty()) {
			bigIdeasHTML.setText(bigIdeasLbl.getText());
		} else {
			bigIdeasHTML.setText(bigIdeas);
		}
		if(!essentialQuestions.isEmpty()) {
			essentialQuestionsHTML.setText(essentialQuestionsLbl.getText());
		} else {
			essentialQuestionsHTML.setText(essentialQuestions);
		}
		if(!performanceTask.isEmpty()) {
			performanceTaskHTML.setText(performanceTaskLbl.getText());
		} else {
			performanceTaskHTML.setText(performanceTask);
		}
	}
	
	@UiHandler("saveBtn")
	public void clickSaveBtn(ClickEvent event) {
		
		Map<String, String> parms = new HashMap<String, String>();
		parms.put("text", bigIdeasHTML.getText());
		AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {
			
			@Override
			public void onSuccess(Boolean value) {
				if(!value)
				{
					clearErrorMsgs();
				Map<String, String> parms1 = new HashMap<String, String>();
				parms1.put("text", essentialQuestionsHTML.getText());
				AppClientFactory.getInjector().getResourceService().checkProfanity(parms1, new SimpleAsyncCallback<Boolean>() {
					
					@Override
					public void onSuccess(Boolean value) {
						if(!value)
						{
						clearErrorMsgs();
						Map<String, String> parms2 = new HashMap<String, String>();
						parms2.put("text", performanceTaskHTML.getText());
						AppClientFactory.getInjector().getResourceService().checkProfanity(parms2, new SimpleAsyncCallback<Boolean>() {
							
							@Override
							public void onSuccess(Boolean value) {
								if(!value)
								{
									clearErrorMsgs();
								setMetaData(bigIdeasHTML.getText(), essentialQuestionsHTML.getText(), performanceTaskHTML.getText());
								AppClientFactory.fireEvent(new UpdateShelfFolderMetaDataEvent(bigIdeasHTML.getText(), performanceTaskHTML.getText(), essentialQuestionsHTML.getText()));
								showEditableMetaData(true);
								updateFolderMetaData();
								
								}
								else
								{
									performanceTaskHTML.getElement().getStyle().setBorderColor("orange");
									errorLabelperformanceTaskHTML.setText(GL0554);
									errorLabelperformanceTaskHTML.setVisible(true);	
								}
							}
						});
						}
						else
						{
							essentialQuestionsHTML.getElement().getStyle().setBorderColor("orange");
							errorLabelessentialQuestionsHTML.setText(GL0554);
							errorLabelessentialQuestionsHTML.setVisible(true);
						}
					}
				});
				}
				else
				{
					//errorLabelbigIdeasHTML.setText("error text");
					bigIdeasHTML.getElement().getStyle().setBorderColor("orange");
					errorLabelbigIdeasHTML.setText(GL0554);
					errorLabelbigIdeasHTML.setVisible(true);
				}
				
			}
		});

	}
	
	public void clearErrorMsgs()
	{
		errorLabelessentialQuestionsHTML.setVisible(false);
		essentialQuestionsHTML.getElement().removeAttribute("style");
		errorLabelperformanceTaskHTML.setVisible(false);	
		performanceTaskHTML.getElement().removeAttribute("style");
		errorLabelbigIdeasHTML.setVisible(false);	
		bigIdeasHTML.getElement().removeAttribute("style");
	}
	
	@UiHandler("cancelBtn")
	public void clickCancelBtn(ClickEvent event) {
		clearErrorMsgs();
		showEditableMetaData(true);
	}
	
	@UiHandler("closeItem")
	public void clickCloseItem(ClickEvent event) {
		showEditableMetaData(true);
		if(closeItem.getStyleName().contains(folderMetaStyle.closeItem())) 
		{
			closeItem.removeStyleName(folderMetaStyle.closeItem());
			closeItem.addStyleName(folderMetaStyle.openItem());
			performanceTaskPanel.addStyleName(folderMetaStyle.closedPanelHeight());
			essentialQuestionsPanel.addStyleName(folderMetaStyle.closedPanelHeight());
			bigIdeasPanel.addStyleName(folderMetaStyle.closedPanelHeight());
	
		} 
		else 
		{
			closeItem.addStyleName(folderMetaStyle.closeItem());
			closeItem.removeStyleName(folderMetaStyle.openItem());
			performanceTaskPanel.removeStyleName(folderMetaStyle.closedPanelHeight());
			essentialQuestionsPanel.removeStyleName(folderMetaStyle.closedPanelHeight());
			bigIdeasPanel.removeStyleName(folderMetaStyle.closedPanelHeight());

		}
	}
	
	public void updateFolderData(String folderId, String title) {
		this.folderId = folderId;
		this.title = title;
	}
	
	public void updateFolderMetaData() {
		AppClientFactory.getInjector().getfolderService().updateFolder(folderId, title, bigIdeasHTML.getText(), essentialQuestionsHTML.getText(), performanceTaskHTML.getText(), new SimpleAsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				
			}
		});
	}
}