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
package org.ednovo.gooru.client.mvp.classpage.teach.edit.content;

import java.util.ArrayList;
import java.util.List;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.content.ClassLessonDo;
import org.ednovo.gooru.application.shared.model.content.ClasspageDo;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.client.CssTokens;
import org.ednovo.gooru.client.UrlNavigationTokens;
import org.ednovo.gooru.client.mvp.classpage.event.SetCollectionTypeVisibilityEvent;
import org.ednovo.gooru.client.mvp.classpage.event.SetCollectionTypeVisibilityHandler;
import org.ednovo.gooru.client.mvp.classpage.teach.edit.content.widget.EditClassCollectionWidget;
import org.ednovo.gooru.client.mvp.classpage.teach.edit.content.widget.EditClassLessonView;
import org.ednovo.gooru.client.uc.PPanel;
import org.ednovo.gooru.client.ui.HTMLEventPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.event.dom.client.ScrollHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;


/**
 * @fileName : EditClassContentView.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 02-Jul-2015
 *
 * @Author tumbalam
 *
 * @Reviewer: 
 */
public class EditClassContentView extends BaseViewWithHandlers<EditClassContentViewUiHandler> implements IsEditClassContentView {
	
	
	@UiField InlineLabel markAllLbl,visiblLbl,hiddenLbl;
	
	@UiField Button saveBtn;
	
	@UiField HTMLPanel scoreContainer,contentSeetingsContainer;
	
	@UiField PPanel scorePanel,helpPanel,unitPanel,choseTxtPanel,noteTxtPanel;
	
	@UiField TextBox scoreTextBox;
	
	@UiField HTMLEventPanel unitList;
	
	@UiField PPanel lessonPanel,collectionTitlePanel,visiblePanel;
	
	@UiField HTMLPanel tableConatiner,unitsPanel;
	
	ClasspageDo classpageDo;
	
	//@UiField ListBox unitListBox;
	
	int miniScore;
	
	@UiField Label errorLabel,saveLblText,selectedLbl;
	
	@UiField ScrollPanel unitScrollPanel;
	
	String unitId;
	
	boolean hasClickedOnDropDwn = false;
	
	@UiField CheckBox hiddenBox,makeAllVisChkBox;
	
	MessageProperties i18n = GWT.create(MessageProperties.class);
	
	List<Long> collectionIds = new ArrayList<Long>();
	
	List<ClassLessonDo> classLessonDos = new ArrayList<ClassLessonDo>();
	
	private int pageNum=1;
	
	private int pageSize=25;
	
	boolean visiblity;
	

	private static EditClassContentViewUiBinder uiBinder = GWT.create(EditClassContentViewUiBinder.class);

	interface EditClassContentViewUiBinder extends
			UiBinder<Widget, EditClassContentView> {
	}

	public EditClassContentView() {
		setWidget(uiBinder.createAndBindUi(this));
		scoreTextBox.setMaxLength(3);
		setId();
		saveBtn.setEnabled(false);
		saveBtn.addStyleName(CssTokens.DISABLED);
		AppClientFactory.getEventBus().addHandler(SetCollectionTypeVisibilityEvent.TYPE, updateVisiblity);
		scoreTextBox.addBlurHandler(new BlurHandler() {
			
			@Override
			public void onBlur(BlurEvent event) {
				String score = scoreTextBox.getText();
				if(score.isEmpty()){
					errorLabel.setText("Please enter the minimum score");
					errorLabel.getElement().getStyle().setColor("orange");
					errorLabel.setVisible(true);
					saveEnabled(false);
					saveBtn.addStyleName(CssTokens.DISABLED);
				}else if(score != null || score != ""){
					if(Integer.parseInt(score) >100 || Integer.parseInt(score) <=0){
						errorLabel.setText(i18n.GL3425());
						errorLabel.getElement().getStyle().setColor("orange");
						errorLabel.setVisible(true);
						saveEnabled(false);
						saveBtn.addStyleName(CssTokens.DISABLED);
					}else{
						miniScore=Integer.valueOf(score);
						saveEnabled(true);
						saveBtn.removeStyleName(CssTokens.DISABLED);
						errorLabel.setVisible(false);
					}
				}
			}
		});
		scoreTextBox.addKeyPressHandler(new NumbersOnly());
		unitList.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				hasClickedOnDropDwn=true;
				if (unitScrollPanel.isVisible()){
					unitScrollPanel.setVisible(false);
				}else{
					unitScrollPanel.setVisible(true);
				}
			}
		});
		
		ClickHandler rootHandler= new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!hasClickedOnDropDwn){
					unitScrollPanel.setVisible(false);
				}else{
					hasClickedOnDropDwn=false;
					
				}
			}
		};
		
		
		RootPanel.get().addDomHandler(rootHandler, ClickEvent.getType());
		
		makeAllVisChkBox.addClickHandler(new UpdateAllVisiblityHandler());
		unitScrollPanel.addScrollHandler(new ScrollDropdownListContainer());
		
	}
	
	SetCollectionTypeVisibilityHandler updateVisiblity = new SetCollectionTypeVisibilityHandler() {
		
		@Override
		public void setCollectionTypeVisibility(long collectionId) {
			ClassLessonDo classLessonDo = new ClassLessonDo();
			classLessonDo.setCollectionId(collectionId);
			classLessonDo.setVisibility(true);
			List<ClassLessonDo> classLessonDos = new ArrayList<ClassLessonDo>();
			classLessonDos.add(classLessonDo);
			unitId=selectedLbl.getElement().getId();
			getUiHandlers().updateCollectionOrAssignmentVisiblity(classLessonDos,unitId);
		}
	};
	
	@UiHandler("saveBtn")
	public void saveClass(ClickEvent event){
		ClasspageDo classpageDo = new ClasspageDo();
		String score = Long.toString(miniScore);
		saveLblText.setVisible(true);
		saveBtn.setVisible(false);
		saveEnabled(false);
		saveBtn.addStyleName(CssTokens.DISABLED);
		getUiHandlers().updateClass(score);
	}
	
	private class NumbersOnly implements KeyPressHandler{

		/* (non-Javadoc)
		 * @see com.google.gwt.event.dom.client.KeyPressHandler#onKeyPress(com.google.gwt.event.dom.client.KeyPressEvent)
		 */
		@Override
		public void onKeyPress(KeyPressEvent event) {
			if (!Character.isDigit(event.getCharCode()) 
                    && event.getNativeEvent().getKeyCode() != KeyCodes.KEY_TAB 
                    && event.getNativeEvent().getKeyCode() != KeyCodes.KEY_BACKSPACE
                    && event.getNativeEvent().getKeyCode() != KeyCodes.KEY_SHIFT
                    && event.getNativeEvent().getKeyCode() != KeyCodes.KEY_ENTER
                    && event.getNativeEvent().getKeyCode() != KeyCodes.KEY_LEFT
                    && event.getNativeEvent().getKeyCode() != KeyCodes.KEY_RIGHT
                    && event.getNativeEvent().getKeyCode() != KeyCodes.KEY_DELETE){
                ((TextBox) event.getSource()).cancelKey();
            }
			saveEnabled(true);
			saveBtn.removeStyleName(CssTokens.DISABLED);
			errorLabel.setVisible(false);
		}
	}
	
	public void saveEnabled(boolean isEnabled){
		saveBtn.setEnabled(isEnabled);
	}
	
	public void setTabVisible(boolean visible){
		scoreContainer.setVisible(visible);
		contentSeetingsContainer.setVisible(!visible);
	}
	
	@Override
	public void setNavigationTab(){
		String tabView = AppClientFactory.getPlaceManager().getRequestParameter(UrlNavigationTokens.TEACHER_CLASS_SUBPAGE_VIEW,"");
		if(tabView.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASS_CONTENT_SUB_SCORE)){
			setTabVisible(true);
		}else if(tabView.equalsIgnoreCase(UrlNavigationTokens.TEACHER_CLASS_CONTENT_SUB_SETTINGS)){
			setTabVisible(false);
		}else{
			setTabVisible(true);
		}
	}
	
	public void setId(){

		scorePanel.setText(i18n.GL3407());
		scorePanel.getElement().setId("scorePnlId");
		scorePanel.getElement().setAttribute("alt",i18n.GL3407());
		scorePanel.getElement().setAttribute("title",i18n.GL3407());
		
		helpPanel.setText(i18n.GL3408());
		helpPanel.getElement().setId("helpPnlId");
		helpPanel.getElement().setAttribute("alt",i18n.GL3408());
		helpPanel.getElement().setAttribute("title",i18n.GL3408());
		
		saveBtn.setText(i18n.GL0141());
		saveBtn.getElement().setId("saveBtnId");
		saveBtn.getElement().setAttribute("alt",i18n.GL0141());
		saveBtn.getElement().setAttribute("title",i18n.GL0141());
		
		unitPanel.setText(i18n.GL3281());
		unitPanel.getElement().setId("unitPanelId");
		
		scoreContainer.getElement().setId("scoreContainerId");
		
		choseTxtPanel.setText(i18n.GL3409());
		choseTxtPanel.getElement().setId("choseTxtpanelId");
		
		noteTxtPanel.setText(i18n.GL3410());
		noteTxtPanel.getElement().setId("notetxtPanelId");
		
		markAllLbl.setText(i18n.GL3411());
		markAllLbl.getElement().setId("marlAllLblId");
		
		visiblLbl.setText(i18n.GL3412());
		visiblLbl.getElement().setId("visibleLblId");
		
		hiddenLbl.setText(i18n.GL3413());
		hiddenLbl.getElement().setId("hiddenLblId");
		
		lessonPanel.setText(i18n.GL0910());
		lessonPanel.getElement().setId("lessonPanelId");
		
		collectionTitlePanel.setText(i18n.GL3414());
		collectionTitlePanel.getElement().setId("collectionTitlePanelId");
		
		visiblePanel.setText(i18n.GL3415());
		visiblePanel.getElement().setId("visibliePanelId");
		
		errorLabel.getElement().setId("errorLblId");
		saveLblText.setText(i18n.GL3426());
		saveLblText.getElement().setId("saveLblTxtId");
		
		saveLblText.setVisible(false);
		unitScrollPanel.setVisible(false);
		
		hiddenBox.setEnabled(false);
		hiddenBox.getElement().getStyle().setCursor(Cursor.DEFAULT);
	}
	@Override
	public void setClassData(ClasspageDo classpageDo) {
		this.classpageDo=classpageDo;
		this.visiblity=classpageDo.isVisibility();
		if(classpageDo.getMinimumScore() >0){
			scoreTextBox.setText(classpageDo.getMinimumScore()+"");
		}else{
			scoreTextBox.setText("");
		}
		
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.classpage.teach.edit.content.IsEditClassContentView#setUpdateClass(org.ednovo.gooru.application.shared.model.content.ClasspageDo)
	 */
	@Override
	public void setUpdateClass(ClasspageDo result) {
		saveLblText.setVisible(false);
		saveBtn.setVisible(true);
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.classpage.teach.edit.content.IsEditClassContentView#getUnitListView(java.util.List)
	 */
	@Override
	public void getUnitListView(List<FolderDo> result) {
		if(result.size() > 0){
			unitId = result.get(0).getGooruOid();
			unitsPanel.clear();
			for(int i=0;i<result.size();i++){
				Label label = new Label();
				
				final String unitId = result.get(i).getGooruOid();
				final String unitName = result.get(i).getTitle();
				
				label.setText(unitName);
				label.getElement().setId(unitId);
				label.addStyleName("unitStyle");
				label.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						hasClickedOnDropDwn=false;
						selectedLbl.setText(unitName);
						selectedLbl.getElement().setId(unitId);
						getUiHandlers().getLessonList(unitId);
					}
				});
				unitsPanel.add(label);
				/*unitListBox.addItem(unitName, unitId);*/
			}
			selectedLbl.setText(result.get(0).getTitle());
			selectedLbl.getElement().setId(unitId);
		}
		getUiHandlers().getLessonList(unitId);
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.classpage.teach.edit.content.IsEditClassContentView#setLessonData(java.util.List)
	 */
	@Override
	public void setLessonData(List<ClassLessonDo> result) {
		tableConatiner.clear();
		if (result.size()>0) {
			for(int i=0; i<result.size() ;i++){
				ClassLessonDo classLessonDo = result.get(i);
				EditClassLessonView editClassLessonView = new EditClassLessonView(classLessonDo,i+1);
				tableConatiner.add(editClassLessonView);
			}
		}else{
			Label label = new Label();
			label.setText("No Lessons Found");
			label.addStyleName("errorMessage");
			label.getElement().getStyle().setPadding(50, Unit.PX);
			label.getElement().getStyle().setTextAlign(TextAlign.CENTER);
			
			tableConatiner.add(label);
		}
	}
	
	private class UpdateAllVisiblityHandler implements ClickHandler{
		/* (non-Javadoc)
		 * @see com.google.gwt.event.dom.client.ClickHandler#onClick(com.google.gwt.event.dom.client.ClickEvent)
		 */
		@Override
		public void onClick(ClickEvent event) {
			int widgetCount = tableConatiner.getWidgetCount();
			for(int i=0;i<widgetCount;i++){
				final EditClassLessonView panelContainer = (EditClassLessonView) tableConatiner.getWidget(i);
				int checkBoxCount = panelContainer.getRowContainer().getWidgetCount();
				for(int k =0;k<checkBoxCount;k++){
					ClassLessonDo classLessonDo = new ClassLessonDo();
					final EditClassCollectionWidget checkBoxContainer = (EditClassCollectionWidget) panelContainer.getRowContainer().getWidget(k);
					checkBoxContainer.setChecked();
					classLessonDo.setCollectionId(checkBoxContainer.getCollectionId());
					classLessonDo.setVisibility(true);
					classLessonDos.add(classLessonDo);
				}
			}
			getUiHandlers().updateCollectionOrAssignmentVisiblity(classLessonDos, unitId);
		}
		
	}
	
	private class ScrollDropdownListContainer implements ScrollHandler{
		@Override
		public void onScroll(ScrollEvent event) {
			if((unitScrollPanel.getVerticalScrollPosition() == unitScrollPanel.getMaximumVerticalScrollPosition())){
					//getUiHandlers().getUnitList((pageNum*pageSize)-1, pageSize);
				}
			}
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.classpage.teach.edit.content.IsEditClassContentView#setEmptyUnitListData()
	 */
	@Override
	public void setEmptyUnitListData() {
		selectedLbl.setText("Unit");
		unitScrollPanel.clear();
		Label label = new Label();
		label.setText("No Lessons Found");
		label.addStyleName("errorMessage");
		label.getElement().getStyle().setPadding(50, Unit.PX);
		label.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		tableConatiner.clear();
		tableConatiner.add(label);
	}
}
