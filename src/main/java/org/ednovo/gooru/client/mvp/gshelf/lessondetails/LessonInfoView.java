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
package org.ednovo.gooru.client.mvp.gshelf.lessondetails;

import java.util.Arrays;
import java.util.List;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.folder.CreateDo;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.client.mvp.gshelf.util.AssessmentPopupWidget;
import org.ednovo.gooru.client.uc.LiPanel;
import org.ednovo.gooru.client.uc.UlPanel;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.SetStyleForProfanity;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * @author Search Team
 *
 */
public class LessonInfoView extends BaseViewWithHandlers<LessonInfoUiHandlers> implements IsLessonInfoView {

	private static LessonViewUiBinder uiBinder = GWT.create(LessonViewUiBinder.class);
	
	@UiTemplate("LessonInfoView.ui.xml")
	interface LessonViewUiBinder extends UiBinder<Widget, LessonInfoView> {
	}	

	@UiField HTMLPanel lessonInfo;
	@UiField TextBox lessonTitle;
	@UiField UlPanel standardsDropListValues;
	@UiField HTMLEventPanel btnStandardsBrowse;
	@UiField Button saveLessonBtn,btnSaveAndCreateCollection,btnSaveAndCreateAssessment;
	@UiField Label lblErrorMessage;
	AssessmentPopupWidget assessmentPopup;
	 
	private static MessageProperties i18n = GWT.create(MessageProperties.class);

	String[] standardsTypesArray = new String[]{i18n.GL3321(),i18n.GL3322(),i18n.GL3323(),i18n.GL3324(),i18n.GL3325()};

	final String ACTIVE="active";
	final String COLLECTION="Collection";
	final String ASSESSMENT="Assessment";
	final String ASSESSMENTEXTERNAL="ExternalAssessment";
	
	/**
	 * Class constructor 
	 * @param eventBus {@link EventBus}
	 */
	@Inject
	public LessonInfoView() {
		setWidget(uiBinder.createAndBindUi(this));
		lessonInfo.getElement().setId("pnlLessonInfo");
		lessonInfo.getElement().getStyle().setOverflowY(Overflow.AUTO);
		populateStandardValues();
		btnStandardsBrowse.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!standardsDropListValues.getElement().getAttribute("style").equalsIgnoreCase("display:block;")){
					standardsDropListValues.getElement().setAttribute("style", "display:block;");
				}else{
					standardsDropListValues.getElement().removeAttribute("style");
				}
			}
		});
		lessonTitle.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				SetStyleForProfanity.SetStyleForProfanityForTextBox(lessonTitle, lblErrorMessage, false);
			}
		});
	}
	public void populateStandardValues(){
		for(int i=0; i<standardsTypesArray.length; i++){		
			List<String> standardsDescriptionList = Arrays.asList(standardsTypesArray[i].toString().split(","));
			LiPanel liPanel = new LiPanel();
			for(int j=0; j<standardsDescriptionList.size(); j++){
				HTMLPanel headerDiv = new HTMLPanel("");
				if(j==0){
					if(standardsDescriptionList.get(j).toString().equalsIgnoreCase("CA CCSS")){
						liPanel.getElement().setId("CA");
					}else{
						liPanel.getElement().setId(standardsDescriptionList.get(j).toString());
					}
					headerDiv.setStyleName("liPanelStyle");
				}else{
					headerDiv.setStyleName("liPanelStylenonBold");	
				}
				headerDiv.getElement().setInnerHTML(standardsDescriptionList.get(j).toString());
				liPanel.add(headerDiv);
			}
			liPanel.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {				
					String standardsVal = event.getRelativeElement().getAttribute("id");
					getUiHandlers().showStandardsPopup(standardsVal);
				}
			});
			standardsDropListValues.add(liPanel);
		}
	}
	@UiHandler("saveLessonBtn")
	public void clickOnSaveCourseBtn(ClickEvent saveCourseEvent){
		getUiHandlers().checkProfanity(lessonTitle.getText().trim(),false,null);
	}
	@UiHandler("btnSaveAndCreateCollection")
	public void clickOnSaveAndCreateCollection(ClickEvent saveCourseEvent){
		getUiHandlers().checkProfanity(lessonTitle.getText().trim(),true,COLLECTION);
	}
	@UiHandler("btnSaveAndCreateAssessment")
	public void clickOnSaveAndCreateAssessment(ClickEvent saveCourseEvent){
		Window.enableScrolling(false);
		assessmentPopup=new AssessmentPopupWidget() {
			@Override
			public void clickOnNoramlAssessmentClick() {
				assessmentPopup.hide();
				Window.enableScrolling(true);
				//This will display the normal assessment info
				getUiHandlers().checkProfanity(lessonTitle.getText().trim(),true,ASSESSMENT);
			}
			@Override
			public void clickOnExternalAssessmentClick() {
				assessmentPopup.hide();
				Window.enableScrolling(true);
				//This will display the external assessment info
				getUiHandlers().checkProfanity(lessonTitle.getText().trim(),true,ASSESSMENTEXTERNAL);
			}
		};
		assessmentPopup.setGlassEnabled(true);
		assessmentPopup.show();
		assessmentPopup.center();
	}
	@Override
	public void callCreateAndUpdate(boolean isCreate,boolean result,String type){
		if(result){
			SetStyleForProfanity.SetStyleForProfanityForTextBox(lessonTitle, lblErrorMessage, result);
		}else{
			CreateDo createOrUpDate=new CreateDo();
			createOrUpDate.setTitle(lessonTitle.getText());
			String id= AppClientFactory.getPlaceManager().getRequestParameter("o3",null);
			System.out.println("id val:::"+id);
			if(id!=null){
				getUiHandlers().updateLessonDetails(createOrUpDate,id,isCreate,type);
			}else{
				getUiHandlers().createAndSaveLessonDetails(createOrUpDate,isCreate,type);
			}
		}
	}
	@Override
	public void setLessonInfoData(FolderDo folderObj) {
		lessonTitle.setText(folderObj==null?i18n.GL3365():folderObj.getTitle());
	}
}
