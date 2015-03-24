package org.ednovo.gooru.client.mvp.shelf.collection.folders;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.UpdateShelfFolderNameEvent;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class FolderItemMetaDataUc extends Composite {

	@UiField Button saveBtnbigIdeas,simplePencilPanelbigIdeas,simplePencilPanelTask,simplePencilPanelquestion, cancelBtnbigIdeas,saveBtnTasks,cancelBtnTasks,saveBtnQuestions,cancelBtnQuestions;
	
	@UiField Label bigIdeasLbl, essentialQuestionsLbl, performanceTaskLbl;
	
	@UiField TextArea bigIdeasHTML, essentialQuestionsHTML, performanceTaskHTML;
	
	@UiField HTMLPanel formButtons,formButtonsQuestions,formButtonsTasks, performanceTaskPanel, essentialQuestionsPanel, bigIdeasPanel;
	@UiField HTMLPanel bigIdeasDiv,questionDiv,taskDiv;
	
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
		bigIdeasDiv.setVisible(true);
		questionDiv.setVisible(false);
		taskDiv.setVisible(false);		
		bigIdeasPanel.addStyleName(folderMetaStyle.highlightContent());
		essentialQuestionsPanel.removeStyleName(folderMetaStyle.highlightContent());
		performanceTaskPanel.removeStyleName(folderMetaStyle.highlightContent());		
		ideasStaticLbl.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				showEditableMetaData(true);
				bigIdeasDiv.setVisible(true);
				questionDiv.setVisible(false);
				taskDiv.setVisible(false);
				bigIdeasPanel.addStyleName(folderMetaStyle.highlightContent());
				essentialQuestionsPanel.removeStyleName(folderMetaStyle.highlightContent());
				performanceTaskPanel.removeStyleName(folderMetaStyle.highlightContent());				
			}
		});
		questionsStaticLbl.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				showEditableMetaData(true);
				bigIdeasDiv.setVisible(false);
				questionDiv.setVisible(true);
				taskDiv.setVisible(false);
				essentialQuestionsPanel.addStyleName(folderMetaStyle.highlightContent());
				bigIdeasPanel.removeStyleName(folderMetaStyle.highlightContent());				
				performanceTaskPanel.removeStyleName(folderMetaStyle.highlightContent());	
			}
		});
		tasksStaticLbl.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			showEditableMetaData(true);
			bigIdeasDiv.setVisible(false);
			questionDiv.setVisible(false);
			taskDiv.setVisible(true);
			performanceTaskPanel.addStyleName(folderMetaStyle.highlightContent());
			bigIdeasPanel.removeStyleName(folderMetaStyle.highlightContent());
			essentialQuestionsPanel.removeStyleName(folderMetaStyle.highlightContent());	
		}
	});
		
		
		bigIdeasLbl.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				formButtons.setVisible(true);
				bigIdeasHTML.setVisible(true);
				bigIdeasLbl.setVisible(false);
			}
		});
		simplePencilPanelbigIdeas.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				simplePencilPanelbigIdeas.setVisible(false);
				formButtons.setVisible(true);
				bigIdeasHTML.setVisible(true);
				bigIdeasLbl.setVisible(false);
			}
		});
		simplePencilPanelbigIdeas.addMouseMoveHandler(new MouseMoveHandler() {
			
			@Override
			public void onMouseMove(MouseMoveEvent event) {				
				simplePencilPanelbigIdeas.setVisible(true);
				simplePencilPanelTask.setVisible(false);
				simplePencilPanelquestion.setVisible(false);
				bigIdeasLbl.addStyleName(folderMetaStyle.addBackground());
			}
		});
		simplePencilPanelbigIdeas.addMouseOutHandler(new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
				simplePencilPanelbigIdeas.setVisible(false);
				simplePencilPanelTask.setVisible(false);
				simplePencilPanelquestion.setVisible(false);
				bigIdeasLbl.removeStyleName(folderMetaStyle.addBackground());
			}
		});
		essentialQuestionsLbl.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				formButtonsQuestions.setVisible(true);
				essentialQuestionsHTML.setVisible(true);
				essentialQuestionsLbl.setVisible(false);
			}
		});
		performanceTaskLbl.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				formButtonsTasks.setVisible(true);
				performanceTaskHTML.setVisible(true);
				performanceTaskLbl.setVisible(false);	
			}
		});
		simplePencilPanelTask.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				simplePencilPanelTask.setVisible(false);
				formButtonsTasks.setVisible(true);
				performanceTaskHTML.setVisible(true);
				performanceTaskLbl.setVisible(false);	
			}
		});
		simplePencilPanelbigIdeas.setVisible(false);
		simplePencilPanelTask.setVisible(false);
		simplePencilPanelquestion.setVisible(false);
		
		bigIdeasLbl.addMouseMoveHandler(new MouseMoveHandler() {
			
			@Override
			public void onMouseMove(MouseMoveEvent event) {				
				simplePencilPanelbigIdeas.setVisible(true);
				simplePencilPanelTask.setVisible(false);
				simplePencilPanelquestion.setVisible(false);
				bigIdeasLbl.addStyleName(folderMetaStyle.addBackground());
			}
		});
		bigIdeasLbl.addMouseOutHandler(new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
				simplePencilPanelbigIdeas.setVisible(false);
				simplePencilPanelTask.setVisible(false);
				simplePencilPanelquestion.setVisible(false);	
				bigIdeasLbl.removeStyleName(folderMetaStyle.addBackground());
			}
		});
		
		simplePencilPanelquestion.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				simplePencilPanelquestion.setVisible(false);
				formButtonsQuestions.setVisible(true);
				essentialQuestionsHTML.setVisible(true);
				essentialQuestionsLbl.setVisible(false);
			}
		});
		
		simplePencilPanelquestion.addMouseMoveHandler(new MouseMoveHandler() {
			
			@Override
			public void onMouseMove(MouseMoveEvent event) {				
				simplePencilPanelbigIdeas.setVisible(false);
				simplePencilPanelTask.setVisible(false);
				simplePencilPanelquestion.setVisible(true);
			}
		});
		simplePencilPanelquestion.addMouseOutHandler(new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
				simplePencilPanelbigIdeas.setVisible(false);
				simplePencilPanelTask.setVisible(false);
				simplePencilPanelquestion.setVisible(false);
				
			}
		});
		essentialQuestionsLbl.addMouseMoveHandler(new MouseMoveHandler() {
			
			@Override
			public void onMouseMove(MouseMoveEvent event) {				
				simplePencilPanelbigIdeas.setVisible(false);
				simplePencilPanelTask.setVisible(false);
				simplePencilPanelquestion.setVisible(true);
			}
		});
		essentialQuestionsLbl.addMouseOutHandler(new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
				simplePencilPanelbigIdeas.setVisible(false);
				simplePencilPanelTask.setVisible(false);
				simplePencilPanelquestion.setVisible(false);
				
			}
		});
		
		
		
		simplePencilPanelquestion.addMouseMoveHandler(new MouseMoveHandler() {
			
			@Override
			public void onMouseMove(MouseMoveEvent event) {
				
				simplePencilPanelbigIdeas.setVisible(false);
				simplePencilPanelTask.setVisible(true);
				simplePencilPanelquestion.setVisible(false);
			}
		});
		simplePencilPanelquestion.addMouseOutHandler(new MouseOutHandler() {
				
				@Override
				public void onMouseOut(MouseOutEvent event) {
					simplePencilPanelbigIdeas.setVisible(false);
					simplePencilPanelTask.setVisible(false);
					simplePencilPanelquestion.setVisible(false);
					
				}
			});
		
		performanceTaskLbl.addMouseMoveHandler(new MouseMoveHandler() {
		
		@Override
		public void onMouseMove(MouseMoveEvent event) {
			
			simplePencilPanelbigIdeas.setVisible(false);
			simplePencilPanelTask.setVisible(true);
			simplePencilPanelquestion.setVisible(false);
		}
	});
		performanceTaskLbl.addMouseOutHandler(new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
				simplePencilPanelbigIdeas.setVisible(false);
				simplePencilPanelTask.setVisible(false);
				simplePencilPanelquestion.setVisible(false);
				
			}
		});
		
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
		
		saveBtnbigIdeas.setText(i18n.GL0141());
		saveBtnbigIdeas.getElement().setId("btnSaveBtn");
		saveBtnbigIdeas.getElement().setAttribute("alt",i18n.GL0141());
		saveBtnbigIdeas.getElement().setAttribute("title",i18n.GL0141());
		
		cancelBtnbigIdeas.setText(i18n.GL0142());
		cancelBtnbigIdeas.getElement().setId("btnCancelBtn");
		cancelBtnbigIdeas.getElement().setAttribute("alt",i18n.GL0142());
		cancelBtnbigIdeas.getElement().setAttribute("title",i18n.GL0142());
		
		saveBtnQuestions.setText(i18n.GL0141());
		saveBtnQuestions.getElement().setId("btnSaveBtn");
		saveBtnQuestions.getElement().setAttribute("alt",i18n.GL0141());
		saveBtnQuestions.getElement().setAttribute("title",i18n.GL0141());
		
		cancelBtnQuestions.setText(i18n.GL0142());
		cancelBtnQuestions.getElement().setId("btnCancelBtn");
		cancelBtnQuestions.getElement().setAttribute("alt",i18n.GL0142());
		cancelBtnQuestions.getElement().setAttribute("title",i18n.GL0142());
		
		saveBtnTasks.setText(i18n.GL0141());
		saveBtnTasks.getElement().setId("btnSaveBtn");
		saveBtnTasks.getElement().setAttribute("alt",i18n.GL0141());
		saveBtnTasks.getElement().setAttribute("title",i18n.GL0141());
		
		cancelBtnTasks.setText(i18n.GL0142());
		cancelBtnTasks.getElement().setId("btnCancelBtn");
		cancelBtnTasks.getElement().setAttribute("alt",i18n.GL0142());
		cancelBtnTasks.getElement().setAttribute("title",i18n.GL0142());
		
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
	
	public void setMetaDataBigIdeas(String bigIdeas) {
		this.bigIdeas = bigIdeas;
		if(bigIdeas==null || bigIdeas.isEmpty()) {
			bigIdeas = i18n.GL1725();
		}		
		bigIdeasLbl.setText(bigIdeas);
		bigIdeasLbl.getElement().setAttribute("alt",bigIdeas);
		bigIdeasLbl.getElement().setAttribute("title",bigIdeas);
		errorLabelbigIdeasHTML.setVisible(false);
		bigIdeasHTML.getElement().removeAttribute("style");		
	}
	
	public void setMetaDataessentialQuestions(String essentialQuestions) {
		this.essentialQuestions = essentialQuestions;
		if(essentialQuestions==null || essentialQuestions.isEmpty()) {
			essentialQuestions = i18n.GL1726();
		}
		essentialQuestionsLbl.setText(essentialQuestions);
		essentialQuestionsLbl.getElement().setAttribute("alt",essentialQuestions);
		essentialQuestionsLbl.getElement().setAttribute("title",essentialQuestions);
		errorLabelessentialQuestionsHTML.setVisible(false);
		essentialQuestionsHTML.getElement().removeAttribute("style");
	}
	
	public void setMetaDataPerformanceTask(String performanceTask) {
		this.performanceTask = performanceTask;
		if(performanceTask==null || performanceTask.isEmpty()) {
			performanceTask = i18n.GL1727();
		}		
		performanceTaskLbl.setText(performanceTask);
		performanceTaskLbl.getElement().setAttribute("alt",performanceTask);
		performanceTaskLbl.getElement().setAttribute("title",performanceTask);
		errorLabelperformanceTaskHTML.setVisible(false);		
		performanceTaskHTML.getElement().removeAttribute("style");		
	}
	
	public void beforeEditSetOpen() {
		performanceTaskPanel.removeStyleName(folderMetaStyle.closedPanelHeight());
		essentialQuestionsPanel.removeStyleName(folderMetaStyle.closedPanelHeight());
		bigIdeasPanel.removeStyleName(folderMetaStyle.closedPanelHeight());

	}
	
	public void showEditableMetaData(boolean isVisible) {
		
		bigIdeasLbl.setVisible(isVisible);
		essentialQuestionsLbl.setVisible(isVisible);
		performanceTaskLbl.setVisible(isVisible);
		
		bigIdeasHTML.setVisible(!isVisible);
		essentialQuestionsHTML.setVisible(!isVisible);
		performanceTaskHTML.setVisible(!isVisible);
		formButtons.setVisible(!isVisible);
		formButtonsQuestions.setVisible(!isVisible);
		formButtonsTasks.setVisible(!isVisible);
		
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
	
	@UiHandler("saveBtnbigIdeas")
	public void clickSaveBtn(ClickEvent event) {
		
		Map<String, String> parms = new HashMap<String, String>();
		parms.put("text", bigIdeasHTML.getText());

						AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {
							
							@Override
							public void onSuccess(Boolean value) {
								if(!value)
								{
								clearErrorMsgs();
								setMetaDataBigIdeas(bigIdeasHTML.getText());
								showEditableMetaData(true);
								if(folderId == null)
								{
								updateFolderDatabyService("ideas");
								}
								else
								{
								updateideasInfo(folderId, title,bigIdeasHTML.getText());
								}	
								}
								else
								{
									bigIdeasHTML.getElement().getStyle().setBorderColor("orange");
									errorLabelbigIdeasHTML.setText(i18n.GL0554());
									errorLabelbigIdeasHTML.getElement().setAttribute("alt",i18n.GL0554());
									errorLabelbigIdeasHTML.getElement().setAttribute("title",i18n.GL0554());
									errorLabelbigIdeasHTML.setVisible(true);
								}
							}
						});
						

	}
	@UiHandler("saveBtnQuestions")
	public void clickSaveBtnQuestions(ClickEvent event) {
		
				Map<String, String> parms1 = new HashMap<String, String>();
				parms1.put("text", essentialQuestionsHTML.getText());
				AppClientFactory.getInjector().getResourceService().checkProfanity(parms1, new SimpleAsyncCallback<Boolean>() {
					
					@Override
					public void onSuccess(Boolean value) {
						if(!value)
						{
							clearErrorMsgs();
							setMetaDataessentialQuestions(essentialQuestionsHTML.getText());
							showEditableMetaData(true);
							if(folderId == null)
							{
							updateFolderDatabyService("questions");
							}
							else
							{
								updatequestionsInfo(folderId, title,essentialQuestionsHTML.getText());
							}
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
	@UiHandler("saveBtnTasks")
	public void clickSaveBtnTasks(ClickEvent event) {
		
					Map<String, String> parms2 = new HashMap<String, String>();
						parms2.put("text", performanceTaskHTML.getText());
						AppClientFactory.getInjector().getResourceService().checkProfanity(parms2, new SimpleAsyncCallback<Boolean>() {
							
							@Override
							public void onSuccess(Boolean value) {
								if(!value)
								{
									clearErrorMsgs();
									setMetaDataPerformanceTask(performanceTaskHTML.getText());
									showEditableMetaData(true);
									if(folderId == null)
									{
									updateFolderDatabyService("tasks");
									}
									else
									{
										updateperformanceInfo(folderId, title,performanceTaskHTML.getText());
									}
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
	
	public void updateideasInfo(final String folderId, final String title, String ideas) {
		AppClientFactory.getInjector().getfolderService().updateFolder(folderId, title, ideas, null, null, new SimpleAsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				AppClientFactory.fireEvent(new UpdateShelfFolderNameEvent(title,folderId)); 
			}
		});
	}
	public void updatequestionsInfo(final String folderId, final String title, String questions) {
		AppClientFactory.getInjector().getfolderService().updateFolder(folderId, title, null, questions, null, new SimpleAsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				AppClientFactory.fireEvent(new UpdateShelfFolderNameEvent(title,folderId)); 
			}
		});
	}
	public void updateperformanceInfo(final String folderId, final String title, String performance) {
		AppClientFactory.getInjector().getfolderService().updateFolder(folderId, title, null, null, performance, new SimpleAsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				AppClientFactory.fireEvent(new UpdateShelfFolderNameEvent(title,folderId)); 
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
	
	@UiHandler("cancelBtnbigIdeas")
	public void clickCancelBtn(ClickEvent event) {
		clearErrorMsgs();
		showEditableMetaData(true);
	}
	@UiHandler("cancelBtnQuestions")
	public void clickCancelBtnQuestions(ClickEvent event) {
		clearErrorMsgs();
		showEditableMetaData(true);
	}
	
	@UiHandler("cancelBtnTasks")
	public void clickCancelBtnTasks(ClickEvent event) {
		clearErrorMsgs();
		showEditableMetaData(true);
	}
	
	public void updateFolderData(String folderId, String title) {
		this.folderId = folderId;
		this.title = title;
	}

	
	public void updateFolderDatabyService(final String textToSave) {
		String folderIdLocal = "";
		String O1_LEVEL_VALUE = AppClientFactory.getPlaceManager().getRequestParameter("o1");
		String O2_LEVEL_VALUE = AppClientFactory.getPlaceManager().getRequestParameter("o2");
		String O3_LEVEL_VALUE = AppClientFactory.getPlaceManager().getRequestParameter("o3");
		if(O3_LEVEL_VALUE!= null)
		{
			folderIdLocal = O3_LEVEL_VALUE;
		}
		else if(O2_LEVEL_VALUE!=null)
		{
			folderIdLocal = O2_LEVEL_VALUE;	
		}
		else if(O1_LEVEL_VALUE!=null)
		{
			folderIdLocal = O1_LEVEL_VALUE;	
		}
		AppClientFactory.getInjector().getfolderService().getFolderInformation(folderIdLocal, new AsyncCallback<CollectionDo>() {
			@Override
			public void onSuccess(CollectionDo result) {
				folderId = result.getGooruOid();
				title = result.getTitle();
				if(textToSave.equalsIgnoreCase("ideas"))
				{
				updateideasInfo(folderId, title,bigIdeasHTML.getText());
				}
				else if(textToSave.equalsIgnoreCase("questions"))
				{
				updatequestionsInfo(folderId, title,essentialQuestionsHTML.getText());
				}
				else
				{
				updateperformanceInfo(folderId, title,performanceTaskHTML.getText());
				}			
			}

			@Override
			public void onFailure(Throwable caught) {

				
			}
		});
		
		
	}
	
	public void updateFolderMetaData() {
		AppClientFactory.getInjector().getfolderService().updateFolder(folderId, title, bigIdeasHTML.getText(), essentialQuestionsHTML.getText(), performanceTaskHTML.getText(), new SimpleAsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				
			}
		});
	}
}