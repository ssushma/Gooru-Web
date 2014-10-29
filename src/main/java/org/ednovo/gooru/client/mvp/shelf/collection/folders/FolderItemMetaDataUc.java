package org.ednovo.gooru.client.mvp.shelf.collection.folders;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.UpdateShelfFolderMetaDataEvent;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
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

public class FolderItemMetaDataUc extends Composite {

	@UiField Button closeItem, saveBtn, cancelBtn;
	
	@UiField HTML bigIdeasLbl, essentialQuestionsLbl, performanceTaskLbl;
	
	@UiField TextArea bigIdeasHTML, essentialQuestionsHTML, performanceTaskHTML;
	
	@UiField HTMLPanel formButtons, performanceTaskPanel, essentialQuestionsPanel, bigIdeasPanel;
	
	@UiField FolderItemMetaDataUcStyleBundle folderMetaStyle;
	
	@UiField Label ideasStaticLbl, questionsStaticLbl, tasksStaticLbl,errorLabelbigIdeasHTML,errorLabelperformanceTaskHTML,errorLabelessentialQuestionsHTML;
	
	@UiField Label charLimitLblForBigIdeas,charLimitLblForEssential,charLimitLblForPerformance;
	
	private String folderId = null, title = null, bigIdeas = "", essentialQuestions = "", performanceTask = "";
	
	private static FolderItemMetaDataUcUiBinder uiBinder = GWT
			.create(FolderItemMetaDataUcUiBinder.class);
	
	MessageProperties i18n = GWT.create(MessageProperties.class);

	interface FolderItemMetaDataUcUiBinder extends
			UiBinder<Widget, FolderItemMetaDataUc> {
	}

	public FolderItemMetaDataUc() {
		initWidget(uiBinder.createAndBindUi(this));
		setDebugIds();
		showEditableMetaData(true);
		
		bigIdeasHTML.getElement().setAttribute("maxlength", "1000");
		essentialQuestionsHTML.getElement().setAttribute("maxlength", "1000");
		performanceTaskHTML.getElement().setAttribute("maxlength", "1000");
		
		bigIdeasHTML.addKeyDownHandler(new KeyDownHandler() {
			
			@Override
			public void onKeyDown(KeyDownEvent event) {
				restrictKeyLimit(event, bigIdeasHTML, bigIdeasHTML.getText(), errorLabelbigIdeasHTML);
			}
		});
		
		bigIdeasHTML.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				restrictKeyLimit(null, bigIdeasHTML, bigIdeasHTML.getText(), errorLabelbigIdeasHTML);
			}
		});
		
		essentialQuestionsHTML.addKeyDownHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				restrictKeyLimit(event, essentialQuestionsHTML, essentialQuestionsHTML.getText(), errorLabelessentialQuestionsHTML);
			}
		});

		essentialQuestionsHTML.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				restrictKeyLimit(null, essentialQuestionsHTML, essentialQuestionsHTML.getText(), errorLabelessentialQuestionsHTML);
			}
		});
		
		performanceTaskHTML.addKeyDownHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				restrictKeyLimit(event, performanceTaskHTML, performanceTaskHTML.getText(), errorLabelperformanceTaskHTML);
			}
		});

		performanceTaskHTML.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				restrictKeyLimit(null, performanceTaskHTML, performanceTaskHTML.getText(), errorLabelperformanceTaskHTML);
			}
		});
		String value = StringUtil.generateMessage(i18n.GL2103(), "1000");
		charLimitLblForBigIdeas.setText(value);
		charLimitLblForEssential.setText(value);
		charLimitLblForPerformance.setText(value);
		
		StringUtil.setAttributes(charLimitLblForBigIdeas.getElement(), "charLimitLblForBigIdeas", value, value);
		StringUtil.setAttributes(charLimitLblForEssential.getElement(), "charLimitLblForEssential", value, value);
		StringUtil.setAttributes(charLimitLblForPerformance.getElement(), "charLimitLblForPerformance", value, value);
		

	}
	
	private void setDebugIds() {
		ideasStaticLbl.setText(i18n.GL1731());
		ideasStaticLbl.getElement().setId("lblIdeasStaticLbl");
		ideasStaticLbl.getElement().setAttribute("alt",i18n.GL1731());
		ideasStaticLbl.getElement().setAttribute("title",i18n.GL1731());
		
		questionsStaticLbl.setText(i18n.GL1732());
		questionsStaticLbl.getElement().setId("lblQuestionsStaticLbl");
		questionsStaticLbl.getElement().setAttribute("alt",i18n.GL1732());
		questionsStaticLbl.getElement().setAttribute("title",i18n.GL1732());
		
		tasksStaticLbl.setText(i18n.GL1733());
		tasksStaticLbl.getElement().setId("lblTasksStaticLbl");
		tasksStaticLbl.getElement().setAttribute("alt",i18n.GL1733());
		tasksStaticLbl.getElement().setAttribute("title",i18n.GL1733());
		
		saveBtn.setText(i18n.GL0141());
		saveBtn.getElement().setId("btnSaveBtn");
		saveBtn.getElement().setAttribute("alt",i18n.GL0141());
		saveBtn.getElement().setAttribute("title",i18n.GL0141());
		
		cancelBtn.setText(i18n.GL0142());
		cancelBtn.getElement().setId("btnCancelBtn");
		cancelBtn.getElement().setAttribute("alt",i18n.GL0142());
		cancelBtn.getElement().setAttribute("title",i18n.GL0142());
		
		bigIdeasPanel.getElement().setId("pnlBigIdeasPanel");
		bigIdeasLbl.getElement().setId("htmlBigIdeasLbl");
		bigIdeasHTML.getElement().setId("tatBigIdeasHTML");
		StringUtil.setAttributes(bigIdeasHTML, true);
		errorLabelbigIdeasHTML.getElement().setId("lblErrorLabelbigIdeasHTML");
		essentialQuestionsPanel.getElement().setId("pnlEssentialQuestionsPanel");
		essentialQuestionsLbl.getElement().setId("htmlEssentialQuestionsLbl");
		essentialQuestionsHTML.getElement().setId("tatEssentialQuestionsHTML");
		StringUtil.setAttributes(essentialQuestionsHTML, true);
		errorLabelessentialQuestionsHTML.getElement().setId("lblErrorLabelessentialQuestionsHTML");
		performanceTaskPanel.getElement().setId("pnlPerformanceTaskPanel");
		performanceTaskLbl.getElement().setId("htmlPerformanceTaskLbl");
		performanceTaskHTML.getElement().setId("tatPerformanceTaskHTML");
		StringUtil.setAttributes(performanceTaskHTML, true);
		errorLabelperformanceTaskHTML.getElement().setId("lblErrorLabelperformanceTaskHTML");
		closeItem.getElement().setId("btnCloseItem");
		formButtons.getElement().setId("pnlFormButtons");
	}
	
	private void restrictKeyLimit(KeyDownEvent event, TextArea textArea, String text, Label errorLabelToDisplay) {
		if(text.trim().length()<=999) {
			errorLabelToDisplay.setVisible(false);	 
		} else if(text.trim().length()>998) {
			if(event==null) {
				textArea.cancelKey();
				errorLabelToDisplay.setVisible(true);
				errorLabelToDisplay.setText(i18n.GL0143());	
				errorLabelToDisplay.getElement().setAttribute("alt",i18n.GL0143());
				errorLabelToDisplay.getElement().setAttribute("title",i18n.GL0143());
			} else {
				if(event.isControlKeyDown() || event.isShiftKeyDown() ||
						((event.getNativeEvent().getKeyCode() == KeyCodes.KEY_UP)) || 
						((event.getNativeEvent().getKeyCode() == KeyCodes.KEY_LEFT)) || 
						((event.getNativeEvent().getKeyCode() == KeyCodes.KEY_DOWN)) || 
						((event.getNativeEvent().getKeyCode() == KeyCodes.KEY_RIGHT)) || 
						((event.getNativeEvent().getKeyCode() == KeyCodes.KEY_BACKSPACE)) || 
						((event.getNativeEvent().getKeyCode() == KeyCodes.KEY_DELETE))) {
					if(text.trim().length()<=1000) {
						errorLabelToDisplay.setVisible(false);	 
					}
				} else {
					textArea.cancelKey();
					errorLabelToDisplay.setVisible(true);
					errorLabelToDisplay.setText(i18n.GL0143());
					errorLabelToDisplay.getElement().setAttribute("alt",i18n.GL0143());
					errorLabelToDisplay.getElement().setAttribute("title",i18n.GL0143());
				}
			}
		}
	}
	
	public void setMetaData(String bigIdeas, String essentialQuestions, String performanceTask) {
		this.bigIdeas = bigIdeas;
		this.essentialQuestions = essentialQuestions;
		this.performanceTask = performanceTask;
		if(bigIdeas==null || bigIdeas.isEmpty()) {
			bigIdeas = i18n.GL1725();
		}
		if(essentialQuestions==null || essentialQuestions.isEmpty()) {
			essentialQuestions = i18n.GL1726();
		}
		if(performanceTask==null || performanceTask.isEmpty()) {
			performanceTask = i18n.GL1727();
		}
		
		bigIdeasLbl.setText(bigIdeas);
		bigIdeasLbl.getElement().setAttribute("alt",bigIdeas);
		bigIdeasLbl.getElement().setAttribute("title",bigIdeas);
		essentialQuestionsLbl.setText(essentialQuestions);
		essentialQuestionsLbl.getElement().setAttribute("alt",essentialQuestions);
		essentialQuestionsLbl.getElement().setAttribute("title",essentialQuestions);
		performanceTaskLbl.setText(performanceTask);
		performanceTaskLbl.getElement().setAttribute("alt",performanceTask);
		performanceTaskLbl.getElement().setAttribute("title",performanceTask);
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
		
		charLimitLblForBigIdeas.setVisible(!isVisible);
		charLimitLblForEssential.setVisible(!isVisible);
		charLimitLblForPerformance.setVisible(!isVisible);
		
		if(!bigIdeas.isEmpty()) {
			bigIdeasHTML.setText(bigIdeasLbl.getText());
			bigIdeasHTML.getElement().setAttribute("alt",bigIdeasLbl.getText());
			bigIdeasHTML.getElement().setAttribute("title",bigIdeasLbl.getText());
		} else {
			bigIdeasHTML.setText(bigIdeas);
			bigIdeasHTML.getElement().setAttribute("alt",bigIdeas);
			bigIdeasHTML.getElement().setAttribute("title",bigIdeas);
		}
		if(!essentialQuestions.isEmpty()) {
			essentialQuestionsHTML.setText(essentialQuestionsLbl.getText());
			essentialQuestionsHTML.getElement().setAttribute("alt",essentialQuestionsLbl.getText());
			essentialQuestionsHTML.getElement().setAttribute("title",essentialQuestionsLbl.getText());
		} else {
			essentialQuestionsHTML.setText(essentialQuestions);
			essentialQuestionsHTML.getElement().setAttribute("alt",essentialQuestions);
			essentialQuestionsHTML.getElement().setAttribute("title",essentialQuestions);
		}
		if(!performanceTask.isEmpty()) {
			performanceTaskHTML.setText(performanceTaskLbl.getText());
			performanceTaskHTML.getElement().setAttribute("alt",performanceTaskLbl.getText());
			performanceTaskHTML.getElement().setAttribute("title",performanceTaskLbl.getText());
		} else {
			performanceTaskHTML.setText(performanceTask);
			performanceTaskHTML.getElement().setAttribute("alt",performanceTask);
			performanceTaskHTML.getElement().setAttribute("title",performanceTask);
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
									errorLabelperformanceTaskHTML.setText(i18n.GL0554());
									errorLabelperformanceTaskHTML.getElement().setAttribute("alt",i18n.GL0554());
									errorLabelperformanceTaskHTML.getElement().setAttribute("title",i18n.GL0554());
									errorLabelperformanceTaskHTML.setVisible(true);	
								}
							}
						});
						}
						else
						{
							essentialQuestionsHTML.getElement().getStyle().setBorderColor("orange");
							errorLabelessentialQuestionsHTML.setText(i18n.GL0554());
							errorLabelperformanceTaskHTML.getElement().setAttribute("alt",i18n.GL0554());
							errorLabelperformanceTaskHTML.getElement().setAttribute("title",i18n.GL0554());
							errorLabelessentialQuestionsHTML.setVisible(true);
						}
					}
				});
				}
				else
				{
					//errorLabelbigIdeasHTML.setText("error text");
					bigIdeasHTML.getElement().getStyle().setBorderColor("orange");
					errorLabelbigIdeasHTML.setText(i18n.GL0554());
					errorLabelbigIdeasHTML.getElement().setAttribute("alt",i18n.GL0554());
					errorLabelbigIdeasHTML.getElement().setAttribute("title",i18n.GL0554());
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