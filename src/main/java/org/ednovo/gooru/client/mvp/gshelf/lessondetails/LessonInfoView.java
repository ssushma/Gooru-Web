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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.code.CourseSubjectDo;
import org.ednovo.gooru.application.shared.model.folder.CreateDo;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.application.shared.model.library.DomainStandardsDo;
import org.ednovo.gooru.application.shared.model.library.SubDomainStandardsDo;
import org.ednovo.gooru.application.shared.model.library.SubSubDomainStandardsDo;
import org.ednovo.gooru.client.mvp.gshelf.collectiondetails.StandardsCodeDecView;
import org.ednovo.gooru.client.mvp.gshelf.util.AssessmentPopupWidget;
import org.ednovo.gooru.client.mvp.gshelf.util.CourseGradeWidget;
import org.ednovo.gooru.client.mvp.gshelf.util.LiPanelWithClose;
import org.ednovo.gooru.client.uc.LiPanel;
import org.ednovo.gooru.client.uc.UlPanel;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.SetStyleForProfanity;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
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

	@UiField HTMLPanel lessonInfo,standardsUI;
	@UiField TextBox lessonTitle;
	@UiField UlPanel standardsDropListValues;
	@UiField HTMLEventPanel btnStandardsBrowse, taxonomyToggleBtn;
	@UiField Button saveLessonBtn,btnSaveAndCreateCollection,btnSaveAndCreateAssessment,taxonomyBtn;
	@UiField Label lblErrorMessage;
	@UiField UlPanel ulSelectedItems;
	
	
	AssessmentPopupWidget assessmentPopup;

	private static MessageProperties i18n = GWT.create(MessageProperties.class);

	String[] standardsTypesArray = new String[]{i18n.GL3379(),i18n.GL3322(),i18n.GL3323(),i18n.GL3324(),i18n.GL3325()};
	List<Integer> selectedValues=new ArrayList<Integer>();

	final String ACTIVE="active";
	final String COLLECTION="collection";
	final String ASSESSMENT="assessment";
	private static final String ASSESSMENT_URL = "assessment/url";
	CourseGradeWidget courseGradeWidget;
	public FolderDo courseObj;
	
	List<LiPanelWithClose> lessonLiPanelWithCloseArray = new ArrayList<LiPanelWithClose>();
	
	/**
	 * Class constructor
	 * @param eventBus {@link EventBus}
	 */
	@Inject
	public LessonInfoView() {
		setWidget(uiBinder.createAndBindUi(this));
		lessonInfo.getElement().setId("pnlLessonInfo");
		lessonInfo.getElement().setAttribute("style", "min-height:"+Window.getClientHeight()+"px");
		Window.addResizeHandler(new ResizeHandler() {
			@Override
			public void onResize(ResizeEvent event) {
				lessonInfo.getElement().setAttribute("style", "min-height:"+Window.getClientHeight()+"px");
			}
		});
		populateStandardValues();
		taxonomyBtn.addClickHandler(new OnClickTaxonomy());
		taxonomyToggleBtn.addClickHandler(new OnClickTaxonomy());
		Event.addNativePreviewHandler(new NativePreviewHandler() {
	        public void onPreviewNativeEvent(NativePreviewEvent event) {
	        	hideDropDown(event);
	          }
	    });
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
	
	
	public void displayStandardsList(final List<DomainStandardsDo> standardsList){
		standardsUI.clear();
		final String selValues = getSelectedStandards().toString();
		for(int i=0;i<standardsList.size();i++)
		{
			Boolean flgLevelOne = false;
			if(standardsList.get(i).getCode().contains("Math"))
			{
				flgLevelOne = true;
			}

			final StandardsCodeDecView standardsCode = new StandardsCodeDecView(standardsList.get(i).getCode(), standardsList.get(i).getLabel(),flgLevelOne);
			final DomainStandardsDo domainStand = standardsList.get(i);
			if(domainStand.getTypeId()!=null && !(standardsList.get(i).getCode().contains("ELA")))
			{
				if(domainStand.getTypeId().equals(1))
				{
					
				}
				else if(domainStand.getTypeId().equals(2))
				{
					standardsCode.getWidgetContainer().getElement().getStyle().setPaddingLeft(35, Unit.PX);	
				}
				else
				{
					standardsCode.getWidgetContainer().getElement().getStyle().setPaddingLeft(70, Unit.PX);		
				}
				
			}
			standardsCode.getWidgetContainer().getElement().setId(domainStand.getCodeId().toString());
			
			if(selValues.contains(standardsList.get(i).getCodeId().toString()))
			{
				standardsCode.getWidgetContainer().addStyleName("active");
			}
			standardsCode.getWidgetContainer().addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					if(!standardsCode.getWidgetContainer().getStyleName().contains("active"))
					{
					
					standardsCode.getWidgetContainer().addStyleName("active");
					standardsCode.getWidgetContainer().getElement().setId(domainStand.getCodeId().toString());
					
					if(!selValues.contains(domainStand.getCodeId().toString())){
						selectedValues.add(domainStand.getCodeId());
					}
					
					final LiPanelWithClose liPanelWithClose=new LiPanelWithClose(domainStand.getCode());
					liPanelWithClose.getCloseButton().addClickHandler(new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							//This will remove the selected value when we are trying by close button
							if(selValues.contains(domainStand.getCodeId().toString())){
								selectedValues.remove(domainStand.getCodeId());
							}
							standardsCode.removeStyleName("active");
							removeGradeWidget(ulSelectedItems,domainStand.getCodeId());
							liPanelWithClose.removeFromParent();
						}
					});
					//selectedValues.add(domainStand.getCodeId());
					liPanelWithClose.setId(domainStand.getCodeId());
					liPanelWithClose.setName(domainStand.getCode());
					liPanelWithClose.setRelatedId(domainStand.getCodeId());
					ulSelectedItems.add(liPanelWithClose);
					}
					else
					{
						standardsCode.getWidgetContainer().removeStyleName("active");
						removeGradeWidget(ulSelectedItems,domainStand.getCodeId());
					}
				}
			});
			standardsUI.add(standardsCode);
			displaySubStandardsList(standardsList.get(i).getNode());
		}
	}
		
		public void displaySubStandardsList(final List<SubDomainStandardsDo> standardsList){
		//	standardsUI.clear();
			final String selValues = getSelectedStandards().toString();
			
			for(int i=0;i<standardsList.size();i++)
			{
				final StandardsCodeDecView standardsCode = new StandardsCodeDecView(standardsList.get(i).getCode(), standardsList.get(i).getLabel(),false);
				final SubDomainStandardsDo domainStand = standardsList.get(i);
				standardsCode.getWidgetContainer().getElement().getStyle().setPaddingLeft(35, Unit.PX);
				standardsCode.getWidgetContainer().getElement().setId(domainStand.getCodeId().toString());
				
				if(selValues.contains(standardsList.get(i).getCodeId().toString()))
				{
					standardsCode.getWidgetContainer().addStyleName("active");
				}
				standardsCode.getWidgetContainer().addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						if(!standardsCode.getWidgetContainer().getStyleName().contains("active"))
						{
						
						standardsCode.getWidgetContainer().addStyleName("active");
						
						
						if(!selValues.contains(domainStand.getCodeId().toString())){
							selectedValues.add(domainStand.getCodeId());
						}
						
						final LiPanelWithClose liPanelWithClose=new LiPanelWithClose(domainStand.getCode());
						liPanelWithClose.getCloseButton().addClickHandler(new ClickHandler() {
							@Override
							public void onClick(ClickEvent event) {
								//This will remove the selected value when we are trying by close button
								if(selValues.contains(domainStand.getCodeId().toString())){
									selectedValues.remove(domainStand.getCodeId());
								}
								standardsCode.removeStyleName("active");
								removeGradeWidget(ulSelectedItems,domainStand.getCodeId());
								liPanelWithClose.removeFromParent();
							}
						});
						//selectedValues.add(domainStand.getCodeId());
						liPanelWithClose.setId(domainStand.getCodeId());
						liPanelWithClose.setName(domainStand.getCode());
						liPanelWithClose.setRelatedId(domainStand.getCodeId());
						ulSelectedItems.add(liPanelWithClose);
						}
						else
						{
							standardsCode.getWidgetContainer().removeStyleName("active");
							removeGradeWidget(ulSelectedItems,domainStand.getCodeId());
						}
					}
				});
				standardsUI.add(standardsCode);
				displaySubSubStandardsList(standardsList.get(i).getNode());
			}
		

	}
	public void displaySubSubStandardsList(final List<SubSubDomainStandardsDo> standardsList){
			//standardsUI.clear();
		final String selValues = getSelectedStandards().toString();
			for(int i=0;i<standardsList.size();i++)
			{
				final StandardsCodeDecView standardsCode = new StandardsCodeDecView(standardsList.get(i).getCode(), standardsList.get(i).getLabel(),false);
				final SubSubDomainStandardsDo domainStand = standardsList.get(i);
				standardsCode.getWidgetContainer().getElement().getStyle().setPaddingLeft(70, Unit.PX);
				standardsCode.getWidgetContainer().getElement().setId(domainStand.getCodeId().toString());
				
				if(selValues.contains(standardsList.get(i).getCodeId().toString()))
				{
					standardsCode.getWidgetContainer().addStyleName("active");
				}
				standardsCode.getWidgetContainer().addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						if(!standardsCode.getWidgetContainer().getStyleName().contains("active"))
						{
						
						standardsCode.getWidgetContainer().addStyleName("active");
						
						if(!selValues.contains(domainStand.getCodeId().toString())){
							selectedValues.add(domainStand.getCodeId());
						}
						
						final LiPanelWithClose liPanelWithClose=new LiPanelWithClose(domainStand.getCode());
						liPanelWithClose.getCloseButton().addClickHandler(new ClickHandler() {
							@Override
							public void onClick(ClickEvent event) {
								//This will remove the selected value when we are trying by close button
								if(selValues.contains(domainStand.getCodeId().toString())){
									selectedValues.remove(domainStand.getCodeId());
								}
								standardsCode.removeStyleName("active");
								removeGradeWidget(ulSelectedItems,domainStand.getCodeId());
								liPanelWithClose.removeFromParent();
							}
						});
						//selectedValues.add(domainStand.getCodeId());
						liPanelWithClose.setId(domainStand.getCodeId());
						liPanelWithClose.setName(domainStand.getCode());
						liPanelWithClose.setRelatedId(domainStand.getCodeId());
						ulSelectedItems.add(liPanelWithClose);
						}
						else
						{
							standardsCode.getWidgetContainer().removeStyleName("active");
							removeGradeWidget(ulSelectedItems,domainStand.getCodeId());
						}
						
					}
				});
				standardsUI.add(standardsCode);
			}
		

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
					liPanel.getElement().setAttribute("standarddesc", standardsDescriptionList.get(j).toString());
				}
				headerDiv.getElement().setInnerHTML(standardsDescriptionList.get(j).toString());
				liPanel.add(headerDiv);
			}
			liPanel.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					String standardsVal = event.getRelativeElement().getAttribute("id");
					String standardsDesc = event.getRelativeElement().getAttribute("standarddesc");
					getUiHandlers().showStandardsPopup(standardsVal,standardsDesc);
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
				getUiHandlers().checkProfanity(lessonTitle.getText().trim(),true,ASSESSMENT_URL);
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
			createOrUpDate.setStandardIds(getSelectedStandards());
			String id= AppClientFactory.getPlaceManager().getRequestParameter("o3",null);
			if(id!=null){
				getUiHandlers().updateLessonDetails(createOrUpDate,id,isCreate,type,courseObj);
			}else{
				getUiHandlers().createAndSaveLessonDetails(createOrUpDate,isCreate,type);
			}
		}
	}
	/**
	 * This method is used to get the selected course id's
	 * @return
	 */
	public List<Integer> getSelectedStandards(){
		List<Integer> taxonomyCourseIds=new ArrayList<Integer>();
		Iterator<Widget> widgets=ulSelectedItems.iterator();
		List<CourseSubjectDo> courseList=new ArrayList<CourseSubjectDo>();
		while (widgets.hasNext()) {
			Widget widget=widgets.next();
			if(widget instanceof LiPanelWithClose){
				LiPanelWithClose obj=(LiPanelWithClose) widget;
				Integer intVal = (int)obj.getId();
				taxonomyCourseIds.add(intVal);
				CourseSubjectDo courseObj=new CourseSubjectDo();
				selectedValues.add((int)obj.getId());
				courseObj.setId((int)obj.getId());
				courseObj.setCode(obj.getName());
				courseObj.setSubjectId(obj.getRelatedId());
				courseList.add(courseObj);
			}
		}
		if(courseObj!=null){
			courseObj.setStandards(courseList);
		}
		return taxonomyCourseIds;
	}
	
	@Override
	public void setLessonInfoData(FolderDo folderObj) {
		this.courseObj=folderObj;
		ulSelectedItems.clear();
		selectedValues.clear();
		standardsUI.clear();
		lessonTitle.setText(folderObj==null?i18n.GL3365():folderObj.getTitle());
		if(folderObj!=null){
			if(folderObj.getStandards()!=null && folderObj.getStandards().size()>0){
				//Render the existing standards
				for(final CourseSubjectDo courseSubjectDo : folderObj.getStandards()) {
					final LiPanelWithClose liPanelWithClose=new LiPanelWithClose(courseSubjectDo.getCode());

					liPanelWithClose.getCloseButton().addClickHandler(new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							for(int i=0;i<selectedValues.size();i++) {							     
							     if((selectedValues.get(i)).equals(courseSubjectDo.getId())){
							    	 selectedValues.remove(courseSubjectDo.getId());
							    	 Element element = Document.get().getElementById(courseSubjectDo.getId().toString());
							    	 if(element!=null){
							 			element.removeClassName("active");
							 		}
							     }
							 }
							removeGradeWidget(ulSelectedItems,courseSubjectDo.getId());
							liPanelWithClose.removeFromParent();
						}
					});
					liPanelWithClose.setId(courseSubjectDo.getId());
					liPanelWithClose.setName(courseSubjectDo.getCode());
					ulSelectedItems.add(liPanelWithClose);
				}
	
			}
		}
		getUiHandlers().callCourseInfoTaxonomy();
	}
	/**
	 * This method will remove the widget based on the codeId in the UlPanel
	 * @param ulPanel
	 * @param codeId
	 */
	public void removeGradeWidget(UlPanel ulPanel,Integer codeId){
		Iterator<Widget> widgets=ulPanel.iterator();
		while (widgets.hasNext()) {
			Widget widget=widgets.next();
			if(widget instanceof LiPanelWithClose){
				LiPanelWithClose obj=(LiPanelWithClose) widget;
				if(obj.getId()==codeId){
					obj.removeFromParent();
				}
			}
			if(widget instanceof LiPanel){
				LiPanel obj=(LiPanel) widget;
				if(obj.getCodeId()==codeId){
					obj.removeStyleName("active");
				}
			}
		}
	}
	
	private class OnClickTaxonomy implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			lessonLiPanelWithCloseArray.clear();
			for(int i=0;i<ulSelectedItems.getWidgetCount();i++){
				lessonLiPanelWithCloseArray.add((LiPanelWithClose) ulSelectedItems.getWidget(i));
			}
			getUiHandlers().invokeTaxonomyPopup("Lesson",lessonLiPanelWithCloseArray);
		}
	}
	

	/**
	 * Adds the selected domains from the taxonomy popup into lesson info view.
	 */
	@Override
	public void addTaxonomyData(List<LiPanelWithClose> liPanelWithCloseArray,List<LiPanelWithClose> removedLiPanelWithCloseArray) {
		for(int i=0;i<liPanelWithCloseArray.size();i++){
			if(isWidgetExists(liPanelWithCloseArray.get(i).getId())){
				ulSelectedItems.add(liPanelWithCloseArray.get(i));
			}
			
			if(i<removedLiPanelWithCloseArray.size()){ 
				removeFromUlSelectedItemsContainer(removedLiPanelWithCloseArray.get(i).getId());
			}
		}
	}
	
	/**
	 * Checks the selected widgets in info view got from taxonomy popup.
	 * @param id
	 * @return
	 */
	private boolean isWidgetExists(long id) {
		boolean flag = true;
		Iterator<Widget> widgets = ulSelectedItems.iterator();
		while(widgets.hasNext()){
			Widget widget = widgets.next();
			if(widget instanceof LiPanelWithClose && ((LiPanelWithClose) widget).getId() == id){
				flag = false;
			}
		}
		return flag;
	}
	
	/**
	 * Removes the widget, which has been removed from taxonomy popup from info view 
	 * @param removeWidgetId
	 */
	private void removeFromUlSelectedItemsContainer(long removeWidgetId) {
		Iterator<Widget> widgets = ulSelectedItems.iterator();
		while(widgets.hasNext()){
			Widget widget = widgets.next();
			if(widget instanceof LiPanelWithClose && ((LiPanelWithClose) widget).getId() == removeWidgetId){
				widget.removeFromParent();
			}
		}
	}
	
	protected void hideDropDown(NativePreviewEvent event) {
		if(event.getTypeInt()==Event.ONCLICK){
    		Event nativeEvent = Event.as(event.getNativeEvent());
        	boolean target=eventTargetsPopup(nativeEvent);
        	if(!target){
        		standardsDropListValues.getElement().removeAttribute("style");
        	}
    	}
	}
	
	private boolean eventTargetsPopup(NativeEvent event) {
		EventTarget target = event.getEventTarget();
		if (Element.is(target)) {
			return standardsDropListValues.getElement().isOrHasChild(Element.as(target))||standardsDropListValues.getElement().isOrHasChild(Element.as(target));
		}
		return false;
	}
	
}
