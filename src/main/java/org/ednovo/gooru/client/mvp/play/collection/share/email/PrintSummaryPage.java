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
package org.ednovo.gooru.client.mvp.play.collection.share.email;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.util.AttemptedAnswersDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class PrintSummaryPage extends Composite implements PlayerMessageProperties{

	@UiField HTMLPanel printPageContainer,gooruLogoContainer,userNameContainer,userClassContainer,classField;
	@UiField HTMLPanel mainContainer,metaDataLeftContainer,metaDataRightContainer,metaDataTitleContainer,metaDataTimeContainer,metaDataUserNameContainer,timeContainer;
	
	@UiField Label userField,userName,userClass,metaDataTitleTxt,metaDataTitleLbl,metaDataTimeTxt,metaDataTimeLbl,metaDataUserNameTxt,metaDataUserNameLbl;
	@UiField Label oeQuestionLbl,bitlyLink;
	@UiField HTMLPanel oeQuestionsContainer,oeQuestionsBox,mcQuestionsContainer,mcQuestionsBox,mcQuestionsLblPanel;
	@UiField InlineLabel mcQuestionsLbl;
	
	@UiField InlineLabel answerCount;
	
	private InlineLabel timeTxt;
	private InlineLabel timeLbl;
	
	private static final String FIB_SEPARATOR = "_______";
	private static final String MC_FIB_TITLE_TXT = "Multiple Choice and Fill in the Blank Questions";
	private static final String MC_TITLE_TXT = "Multiple Choice Questions";
	
	private CollectionDo collectionDo=null;
	
	private static PrintSummaryPageUiBinder uiBinder = GWT
			.create(PrintSummaryPageUiBinder.class);

	interface PrintSummaryPageUiBinder extends
			UiBinder<Widget, PrintSummaryPage> {
	}

	public PrintSummaryPage(CollectionDo collectionDo, String timeSpent, String collectionBitlyLink,  Map<String,AttemptedAnswersDo> attemptedAnswerMap, String completedDate) {
		initWidget(uiBinder.createAndBindUi(this));
		this.collectionDo=collectionDo;
		printPageContainer.getElement().setAttribute("style",PlayerMessageProperties.cp001);
		gooruLogoContainer.getElement().setAttribute("style",PlayerMessageProperties.cp002);
		userNameContainer.getElement().setAttribute("style",PlayerMessageProperties.cp003);
		userName.getElement().setAttribute("style",PlayerMessageProperties.cp004);
		userField.getElement().setAttribute("style",PlayerMessageProperties.cp005);
		userClassContainer.getElement().setAttribute("style",PlayerMessageProperties.cp006);
		userClass.getElement().setAttribute("style",PlayerMessageProperties.cp004);
		classField.getElement().setAttribute("style",PlayerMessageProperties.cp005);
		
		mainContainer.getElement().setAttribute("style",PlayerMessageProperties.cp007);
		metaDataLeftContainer.getElement().setAttribute("style",PlayerMessageProperties.cp008);
		metaDataRightContainer.getElement().setAttribute("style",PlayerMessageProperties.cp0014);
		metaDataTitleContainer.getElement().setAttribute("style",PlayerMessageProperties.cp0025);
		metaDataTitleTxt.getElement().setAttribute("style",PlayerMessageProperties.cp009);
		metaDataTitleLbl.getElement().setAttribute("style",PlayerMessageProperties.cp0010);
	
		metaDataTimeTxt.getElement().setAttribute("style",PlayerMessageProperties.cp009);
		metaDataTimeLbl.getElement().setAttribute("style",PlayerMessageProperties.cp0010);

		metaDataUserNameContainer.getElement().setAttribute("style",PlayerMessageProperties.cp0025);
		metaDataUserNameTxt.getElement().setAttribute("style",PlayerMessageProperties.cp009);
		metaDataUserNameLbl.getElement().setAttribute("style",PlayerMessageProperties.cp0010);
	
		timeTxt = new InlineLabel();
		timeTxt.getElement().getStyle().setFontWeight(FontWeight.BOLD);
		timeLbl = new InlineLabel();
		timeContainer.add(timeTxt);
		timeContainer.add(timeLbl);
		timeLbl.getElement().setAttribute("style",PlayerMessageProperties.cp0012);
		
		oeQuestionLbl.getElement().setAttribute("style",PlayerMessageProperties.cp0013);
		mcQuestionsLbl.getElement().setAttribute("style",PlayerMessageProperties.cp0013);
		mcQuestionsLblPanel.getElement().setAttribute("style",PlayerMessageProperties.cp0013);
		mcQuestionsLbl.setText(MC_TITLE_TXT);
		setMetaData(collectionDo.getTitle(), timeSpent, "", collectionBitlyLink, completedDate);
		//setMcQuestionsData(resourceList, questionResourceOptions);
		
		setQuestionsData();
	
		bitlyLink.getElement().setAttribute("style",PlayerMessageProperties.cp0011);
	}

	private void setMetaData(String collectionTitle, String timeSpent, String collectionUserName, String collectionBitlyLink, String completedDate) {
		userField.setText("");
		metaDataTitleLbl.setText(collectionTitle);
		//metaDataTimeLbl.setText(calculateSpentTime(timeSpent));
		metaDataUserNameLbl.setText(collectionUserName);
		timeTxt.setText("Completed:");
		timeLbl.setText(completedDate);
		bitlyLink.setText("Collection Link: "+collectionBitlyLink);
	}
	
	private String calculateSpentTime(String totalSecs) {
		String timeSpent = "";
		try {
			int totalMilliSeconds = Integer.parseInt(totalSecs);			
			int seconds = (totalMilliSeconds / 1000) % 60;
			int minutes = (totalMilliSeconds / (1000 * 60)) % 60;
			int hours = (totalMilliSeconds / (1000 * 60 * 60)) % 24;

			if(hours!=0) {
				timeSpent += (hours+"h");
			}
			if(minutes!=0) {
				timeSpent += (minutes+"m");
			}
			if(seconds>0) {
				timeSpent += (seconds+"s");
			}
		} catch(Exception e) {
			
		}
		return timeSpent;

	}
	
	private void setOeQuestionsData(int i, String questionText, String questionAnswer) {
			final HTMLPanel oeQuestionDiv = new HTMLPanel("");
			final Label oeQuestionNumber = new Label(""+(i+1));
			questionText = questionText.replaceAll("</p>", " ").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "");
			final HTML oeQuestionSummary = new HTML(questionText);
			final HTML oeQuestionAnswer = new HTML(questionAnswer);
			oeQuestionDiv.getElement().setAttribute("style",PlayerMessageProperties.cp0015);
			oeQuestionNumber.getElement().setAttribute("style",PlayerMessageProperties.cp0017);
			oeQuestionSummary.getElement().setAttribute("style",PlayerMessageProperties.cp0018);
			oeQuestionAnswer.getElement().setAttribute("style",PlayerMessageProperties.cp0019);
			oeQuestionDiv.add(oeQuestionNumber);
			oeQuestionDiv.add(oeQuestionSummary);
			oeQuestionDiv.add(oeQuestionAnswer);
			//oeQuestionDiv.getElement().setAttribute("style",PlayerMessageProperties.cp0016);
			oeQuestionsBox.add(oeQuestionDiv);
	}
	
	public void setQuestionsData(){
		int collectionItemsSize=collectionDo.getCollectionItems().size();
		int correctAnswers=0; int questionResourceOptionsSize=0;
		for(int i = 0; i < collectionItemsSize; i++){
			int fiBCorrectCount = -1;
			CollectionItemDo collectionItemDo=collectionDo.getCollectionItems().get(i);
			if(collectionItemDo.getResource().getResourceType().getName().equalsIgnoreCase("assessment-question")){
				if(collectionItemDo.getResource().getType()==6){
					setOeQuestionsData(i, collectionItemDo.getResource().getQuestionText(), "");
				}else{
					final HTMLPanel mcQuestionDiv = new HTMLPanel("");
					final Image mcQuestionChoice = new Image();
					final Label mcQuestionNumber = new Label(""+(i+1));
					int answerArraySize = collectionItemDo.getResource().getAnswers().size();
					String questionText = collectionItemDo.getResource().getQuestionText();
					questionText = questionText.replaceAll("</p>", "").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "").replaceAll("&nbsp;", " ");
					final HTML mcQuestionAnswer = new HTML();
					final HTMLPanel fibQuestionPanel = new HTMLPanel("");
					if(collectionItemDo.getResource().getType()==4){
						String[] fibArray = questionText.split(FIB_SEPARATOR);
						mcQuestionsLbl.setText(MC_FIB_TITLE_TXT);
						List<String> questionArray = Arrays.asList(fibArray);
						fibQuestionPanel.getElement().setAttribute("style",PlayerMessageProperties.cp0023);
					}
					else {
						mcQuestionAnswer.setHTML(questionText);
						mcQuestionAnswer.getElement().setAttribute("style",PlayerMessageProperties.cp0023);
					}
					
					mcQuestionDiv.getElement().setAttribute("style",PlayerMessageProperties.cp0021);
					mcQuestionChoice.getElement().setAttribute("style",PlayerMessageProperties.cp0022);
					mcQuestionNumber.getElement().setAttribute("style",PlayerMessageProperties.cp0017);
					
					String correctQuestionOption = collectionItemDo.getResource().getGooruOid();
					String questionId = collectionItemDo.getResource().getGooruOid();
					
					mcQuestionDiv.add(mcQuestionChoice);
					mcQuestionDiv.add(mcQuestionNumber);
					
					if(collectionItemDo.getResource().getType()==4) {
						mcQuestionDiv.add(fibQuestionPanel);
					} else {
						mcQuestionDiv.add(mcQuestionAnswer);
					}
					
					if(i==collectionItemsSize-1) {
						mcQuestionDiv.getElement().getStyle().setBorderWidth(0, Unit.PX);
					}
					mcQuestionsBox.add(mcQuestionDiv);
				}
			}
		}
		if(!(oeQuestionsBox.getWidgetCount()>0)) {
			oeQuestionsContainer.setVisible(false);
		}
		if(!(mcQuestionsBox.getWidgetCount()>0)) {
			mcQuestionsContainer.setVisible(false);
		}
		answerCount.setText(correctAnswers+" / "+questionResourceOptionsSize+" correct" );
		answerCount.getElement().setAttribute("style", cp0026);
			
	}
	
//	private void setMcQuestionsData( HashMap<String, String> questionResourceOptions) {
//		int resourceListSize = resourceList.size();
//		int correctAnswers = 0, questionResourceOptionsSize = 0;
//		for (int i = 0; i < resourceListSize; i++) {
//			int fiBCorrectCount = -1;
//			if (resourceList.get(i).getResourceCategory().equalsIgnoreCase("question")) {
//				if(resourceList.get(i).getQuestionsList().getQuestionType()==6) {
//					setOeQuestionsData(i, resourceList.get(i).getQuestionsList().getQuestionText(), questionResourceOptions.get(resourceList.get(i).getQuestionsList().getQuestionGooruOid()));
//				} else {
//					questionResourceOptionsSize++;
//					final HTMLPanel mcQuestionDiv = new HTMLPanel("");
//					final Image mcQuestionChoice = new Image();
//					final Label mcQuestionNumber = new Label(""+(i+1));
//					int answerArraySize = resourceList.get(i).getQuestionsList().getQuestionOptions().size();
//
//					String questionText = resourceList.get(i).getQuestionsList().getQuestionText();
//					questionText = questionText.replaceAll("</p>", "").replaceAll("<p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", "").replaceAll("&nbsp;", " ");
//					final HTML mcQuestionAnswer = new HTML();
//					final HTMLPanel fibQuestionPanel = new HTMLPanel("");
//					if(resourceList.get(i).getQuestionsList().getQuestionType()==4) {
//						String[] fibArray = questionText.split(FIB_SEPARATOR);
//						mcQuestionsLbl.setText(MC_FIB_TITLE_TXT);
//						List<String> questionArray = Arrays.asList(fibArray);
//						
//						for(int j = 0; j < questionArray.size(); j++) {
//							String questionArrayTxt = questionArray.get(j);
//							questionArrayTxt.replaceAll("&nbsp;", " ").trim();
//							
//						//	Label questionLabel = new Label(questionArrayTxt);
//							HTML questionLabel=new HTML(questionArrayTxt);
//							questionLabel.getElement().setAttribute("style","display:inline;");
//							fibQuestionPanel.add(questionLabel);
//							
//							if(j<answerArraySize) {
//								String systemAnswer = resourceList.get(i).getQuestionsList().getQuestionOptions().get(j).getQuestionAnswerText();
//								systemAnswer = systemAnswer.replaceAll("&nbsp;", " ").trim();
//								String answeredId = Integer.toString(resourceList.get(i).getQuestionsList().getQuestionOptions().get(j).getQuestionAnswerId());
//								if (questionResourceOptions.get(answeredId) != null) {
//									if(fiBCorrectCount==-1) {
//										fiBCorrectCount = 0;
//									}
//									if(questionResourceOptions.get(answeredId).equals(systemAnswer)) {
//										final Image fibRightChoice = new Image();
//										fibRightChoice.setUrl(getRightAnswerBundle());
//										fibRightChoice.getElement().setAttribute("style","display:inline;border-bottom: 1.5px solid #515151; width: 15px;height: 15px;padding-right: 10px; padding-bottom: 1px;padding-left: 10px;");
//										fibQuestionPanel.add(fibRightChoice);
//										fiBCorrectCount++;
//									} else {
//										Label wrongAnswerLabel = new Label(questionResourceOptions.get(answeredId).replaceAll("<p>", "").replaceAll("</p>", ""));
//										wrongAnswerLabel.getElement().setAttribute("style","display:inline;padding-right: 10px; padding-left: 10px;border-bottom: 1.5px solid #515151;color: #ccc;");
//										fibQuestionPanel.add(wrongAnswerLabel);
//									}
//								}
//							}
//						}
//						fibQuestionPanel.getElement().setAttribute("style",PlayerMessageProperties.cp0023);
//					} else {
//						mcQuestionAnswer.setHTML(questionText);
//						mcQuestionAnswer.getElement().setAttribute("style",PlayerMessageProperties.cp0023);
//					}
//					
//					mcQuestionDiv.getElement().setAttribute("style",PlayerMessageProperties.cp0021);
//					mcQuestionChoice.getElement().setAttribute("style",PlayerMessageProperties.cp0022);
//					mcQuestionNumber.getElement().setAttribute("style",PlayerMessageProperties.cp0017);
//					
//					String correctQuestionOption = resourceList.get(i).getQuestionsList().getQuestionGooruOid();
//					String questionId = resourceList.get(i).getQuestionsList().getQuestionGooruOid();
//
//					if(resourceList.get(i).getQuestionsList().getQuestionType()==4) {
//						if(fiBCorrectCount==-1) {
//							fibQuestionPanel.clear();
//							fibQuestionPanel.add(new HTML(questionText));
//							mcQuestionChoice.setUrl(getWrongAnswerBundle());
//						} else if(fiBCorrectCount==answerArraySize) {
//							correctAnswers++;
//							mcQuestionChoice.setUrl(getRightAnswerBundle());
//						} else {
//							mcQuestionChoice.setUrl(getWrongAnswerBundle());
//						}
//					} else {
//						int questionOptionsAnswerList = resourceList.get(i).getQuestionsList().getQuestionOptions().size();
//						for (int j = 0; j < questionOptionsAnswerList; j++) {
//							String answeredId = Integer.toString(resourceList.get(i).getQuestionsList().getQuestionOptions().get(j).getQuestionAnswerId());
//							if (correctQuestionOption.equalsIgnoreCase(questionId)) {
//								if (questionResourceOptions.get(answeredId) != null) {
//									if (questionResourceOptions.get(answeredId).contains("true")) {
//										correctAnswers++;
//										mcQuestionChoice.setUrl(getRightAnswerBundle());
//									} else {
//										mcQuestionChoice.setUrl(getWrongAnswerBundle());
//									}
//								}
//							}
//						}
//					}
//					
//					mcQuestionDiv.add(mcQuestionChoice);
//					mcQuestionDiv.add(mcQuestionNumber);
//					
//					if(resourceList.get(i).getQuestionsList().getQuestionType()==4) {
//						mcQuestionDiv.add(fibQuestionPanel);
//					} else {
//						mcQuestionDiv.add(mcQuestionAnswer);
//					}
//					
//					if(i==resourceListSize-1) {
//						mcQuestionDiv.getElement().getStyle().setBorderWidth(0, Unit.PX);
//					}
//					mcQuestionsBox.add(mcQuestionDiv);
//				}
//			}
//		}
//		if(!(oeQuestionsBox.getWidgetCount()>0)) {
//			oeQuestionsContainer.setVisible(false);
//		}
//		if(!(mcQuestionsBox.getWidgetCount()>0)) {
//			mcQuestionsContainer.setVisible(false);
//		}
//		answerCount.setText(correctAnswers+" / "+questionResourceOptionsSize+" correct" );
//		answerCount.getElement().setAttribute("style", cp0026);
//	}
	
//	private SafeUri getRightAnswerBundle() {
//		return CollectionPlayerImageBundle.IMAGEBUNDLEINSTANCE.correctAnswerIcon().getSafeUri();
//	}
//
//	private SafeUri getWrongAnswerBundle() {
//		return CollectionPlayerImageBundle.IMAGEBUNDLEINSTANCE.incorrectAnswer().getSafeUri();
//	}

}
