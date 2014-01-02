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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.client.uc.BlueButtonUc;
import org.ednovo.gooru.client.uc.TextBoxWithPlaceholder;
import org.ednovo.gooru.client.uc.tooltip.GlobalToolTip;
import org.ednovo.gooru.client.uc.tooltip.ToolTip;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.code.LibraryCodeDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.user.SettingDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.FontStyle;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;
import com.tractionsoftware.gwt.user.client.ui.GroupedListBox;

/**
 * 
 * @fileName : CollectionFormInPlayView.java
 *
 * @description : This file deals with Collection Form in Play View.
 *
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class CollectionFormInPlayView extends PopupViewWithUiHandlers<CollectionFormInPlayUiHandlers> implements IsCollectionFormInPlayView {
	@UiField
	TextBoxWithPlaceholder collectionTitleTxtBox;

	/*@UiField
	TextBoxWithPlaceholder collectionGradeTxtBox;
*/
	GroupedListBox courseLisBox;

	@UiField
	SimplePanel groupSimPanel,collectionGradeTxtBox;

	@UiField
	FlowPanel buttonFloPanel;

	@UiField
	Anchor cancelAnr;

	@UiField
	BlueButtonUc btnOk;

	@UiField
	FlowPanel validationErrorFloPanel;

	@UiField
	Label validationErrorLbl, mandatoryErrorLbl, lblDontWorry, lblVisibility,lblPublic,lblAllow,lblShareable,lblShareableDesc,lblPrivate, lblPrivateDesc;
	
	@UiField Label lblTitle/*mobileTxtLbl*/;
	
	@UiField
	Label lblGrade, lblCourse,loadingTextLbl/*,checkMobileSupport*/;
	
	@UiField
	HTMLEventPanel publicShareFloPanel;
	
	/*@UiField
	Image imgQuestionImage;*/
	/*
	@UiField
	Label guideMoreInfoLbl;
	
	@UiField
	Label courseMoreInfoLbl;*/
	@UiField HTMLPanel publicRadioButtonPanel,shareRadioButtonPanel,privateRadioButtonPanel,buttonMainContainer;
	
	RadioButton radioButtonPublic=new RadioButton("","");
	RadioButton radioButtonShare=new RadioButton("","");
	RadioButton radioButtonPrivate=new RadioButton("","");
	
	final String[] list = { "- Select Grade(s) -","Kindergarten", "1", "2", "3", "4", "5", "6", "7",
			"8", "9", "10", "11", "12", "Higher Education" };

	ListBox gradeDropDownList = new ListBox();
	
	@UiField(provided = true)
	CollectionCBundle res;

	private AppPopUp appPopUp;
	
	ToolTip toolTip;
	
	private boolean isCheckedValue;

	private CollectionDo collectionDo;
	
	private PopupPanel toolTipPopupPanel=new PopupPanel();
	
//	public static final String GRADE_INFO = MessageProperties.GL0320;

//	public static final String COURSE_INFO = MessageProperties.GL0321;

	private static final String TITLE_THIS_COLLECTION = MessageProperties.GL0322;
	
	private static final String GOORU_UID = "gooruuid";
	
	private static String CONFIRM_MESSAGE = "You need to confirm your account before you can make collections public!";
	
	private static CollectionFormViewUiBinder uiBinder = GWT.create(CollectionFormViewUiBinder.class);
	
	@UiTemplate("CollectionFormView.ui.xml")
	interface CollectionFormViewUiBinder extends UiBinder<Widget, CollectionFormInPlayView> {
	}

	/**
	 * Class constructor 
	 * @param eventBus {@link EventBus}
	 */
	@Inject
	public CollectionFormInPlayView(EventBus eventBus) {
		super(eventBus);
		this.res = CollectionCBundle.INSTANCE;
		res.css().ensureInjected();

		appPopUp = new AppPopUp();
		
		appPopUp.setContent(TITLE_THIS_COLLECTION, uiBinder.createAndBindUi(this));
		appPopUp.setGlassStyleName(CollectionCBundle.INSTANCE.css().gwtGlassPanel());
		appPopUp.getElement().getStyle().setZIndex(99999);
		buttonFloPanel.add(validationErrorFloPanel);
		validationErrorLbl.setVisible(false);
		mandatoryErrorLbl.setVisible(false);
		//buttonFloPanel.add(btnOk);
		//buttonFloPanel.add(cancelAnr);
		publicShareFloPanel.setVisible(false);
		appPopUp.getElement().getStyle().setWidth(538, Unit.PX);
		collectionTitleTxtBox.getElement().setAttribute("maxlength", "50");
		radioButtonPublic.getElement().setId("rdPublic");
		radioButtonShare.getElement().setId("rdShare");
		radioButtonPrivate.getElement().setId("rdPrivate");
		collectionTitleTxtBox.getElement().setId("txtCollectionTitle");
		collectionTitleTxtBox.getElement().setAttribute("style", "width:180px !important");
		/*loadingTextLbl.getElement().getStyle().setFontStyle(FontStyle.ITALIC);
		loadingTextLbl.getElement().getStyle().setDisplay(Display.NONE);
		mobileTxtLbl.getElement().getStyle().setPaddingTop(6, Unit.PX);*/
		isCheckedValue=false;
		appPopUp.setTitle("New Collection");
		/*imgQuestionImage.getElement().getStyle().setPaddingTop(16, Unit.PX);
		imgQuestionImage.addMouseOverHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(MouseOverEvent event) {
				toolTip = new ToolTip();

				toolTip.getElement().getStyle().setBackgroundColor("transparent");
				toolTip.getElement().getStyle().setPosition(Position.ABSOLUTE);
				toolTip.getElement().getStyle().setZIndex(99999);	
				toolTip.setPopupPosition(imgQuestionImage.getAbsoluteLeft()-(150+22), imgQuestionImage.getAbsoluteTop()+31);
				toolTip.show();
			}
		});
		imgQuestionImage.addMouseOutHandler(new MouseOutHandler() {

			@Override
			public void onMouseOut(MouseOutEvent event) {

				EventTarget target = event.getRelatedTarget();
				if (Element.is(target)) {
					if (!toolTip.getElement().isOrHasChild(Element.as(target))){
						toolTip.hide();
					}
				}
			}
		});*/
		
		btnOk.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (validateCollectionForm().size() == 0) {
					btnOk.setEnabled(false);
					buttonMainContainer.setVisible(false);
					loadingTextLbl.getElement().getStyle().setDisplay(Display.BLOCK);
					getUiHandlers().saveCollection();
				}
			}
		});
		cancelAnr.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				reset();
				hide();
			}
		});
		setAutoHideOnNavigationEventEnabled(true);
		
		collectionTitleTxtBox.addKeyUpHandler(new TitleKeyUpHandler());
		getGradeList();
		publicRadioButtonPanel.add(radioButtonPublic);
		shareRadioButtonPanel.add(radioButtonShare);
		privateRadioButtonPanel.add(radioButtonPrivate);
	
		if(AppClientFactory.getLoggedInUser().getConfirmStatus()==1){
			radioButtonPublic.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					radioButtonPublic.setChecked(true);
					radioButtonShare.setChecked(false);	
					radioButtonPrivate.setChecked(false);	
				}
			});
		}else{
			publicShareFloPanel.addMouseOverHandler(new MouseOverHandler() {

				@Override
				public void onMouseOver(MouseOverEvent event) {
					toolTipPopupPanel.clear();
					toolTipPopupPanel.setWidget(new GlobalToolTip(CONFIRM_MESSAGE));
					toolTipPopupPanel.setStyleName("");
					toolTipPopupPanel.getElement().getStyle().setZIndex(99999);
					toolTipPopupPanel.setPopupPosition(publicShareFloPanel.getElement().getAbsoluteLeft(), publicShareFloPanel.getElement().getAbsoluteTop());
					toolTipPopupPanel.show();
				}
			});

			publicShareFloPanel.addMouseOutHandler(new MouseOutHandler() {

				@Override
				public void onMouseOut(MouseOutEvent event) {
					toolTipPopupPanel.hide();
				}
			});
		}
        	
	
		
	radioButtonShare.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			radioButtonPublic.setChecked(false);
			radioButtonShare.setChecked(true);	
			radioButtonPrivate.setChecked(false);	
		}
	});
	radioButtonPrivate.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			radioButtonPublic.setChecked(false);
			radioButtonShare.setChecked(false);	
			radioButtonPrivate.setChecked(true);	
		}
			
		
	});
	
	
		reset();
		
		setTextAndIds();
	}
	/**
	 * 
	 * @function setTextAndIds 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This is used to set the UI
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setTextAndIds(){
		lblDontWorry.setText(MessageProperties.GL0303);
		lblTitle.setText(MessageProperties.GL0318 + MessageProperties.GL_SPL_STAR);
		//collectionTitleTxtBox.setPlaceholder(MessageProperties.GL0319);
		collectionTitleTxtBox.getElement().setAttribute("placeholder", MessageProperties.GL0319);
		mandatoryErrorLbl.setText(MessageProperties.GL0173);
		lblGrade.setText(MessageProperties.GL0325);
//		gradeHelpIcon.setText(MessageProperties.GL_SPL_QUESTION);
		lblCourse.setText(MessageProperties.GL0326);
//		courseHelpIcon.setText(MessageProperties.GL_SPL_QUESTION);
		validationErrorLbl.setText(MessageProperties.GL0327);
		lblVisibility.setText(MessageProperties.GL0328);
		lblPublic.setText(MessageProperties.GL0329);
		lblAllow.setText(MessageProperties.GL0330);
		lblShareable.setText(MessageProperties.GL0331);
		lblShareableDesc.setText(MessageProperties.GL0332);
		lblPrivate.setText(MessageProperties.GL0333);
		lblPrivateDesc.setText(MessageProperties.GL0334);
		
		btnOk.setText(MessageProperties.GL0190);
		btnOk.getElement().setId("btnOk");
		cancelAnr.getElement().setId("lnkCancel");
		cancelAnr.setText(MessageProperties.GL0142);
	}
	/**
	 * 
	 * @function getGradeList 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This is used to get the grade list.
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void getGradeList() {
		
		gradeDropDownList.setStyleName(CollectionCBundle.INSTANCE.css().contentAlignInputs());

		for (int i = 0; i < list.length; i++) {
			gradeDropDownList.addItem(list[i]);
		}
		collectionGradeTxtBox.setWidget(gradeDropDownList);
		gradeDropDownList.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {

			}
		});
	}
	/**
	 * 
	 * @fileName : CollectionFormInPlayView.java
	 *
	 * @description : This is used to display validation for collectionTitleTxtBox if its length exceeds 50
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: 02-Jan-2014
	 *
	 * @Author : Gooru Team
	 *
	 * @Reviewer: Gooru Team
	 */
	private class TitleKeyUpHandler implements KeyUpHandler {

		public void onKeyUp(KeyUpEvent event) {
			mandatoryErrorLbl.setVisible(false);
			if (collectionTitleTxtBox.getText().length() >= 50) {
				mandatoryErrorLbl.setText(MessageProperties.GL0143);
				mandatoryErrorLbl.setVisible(true);
			}
		}
	}
	/**
	 * This method is used to get the collection data.
	 */
	@Override
	public CollectionDo getData() {
		
		CollectionDo collection = new CollectionDo();
		if (this.collectionDo != null) {
			collection.setGooruOid(this.collectionDo.getGooruOid());
		}
		collection.setTitle(collectionTitleTxtBox.getText());
		if(!(gradeDropDownList.getSelectedIndex() == 0)){
		collection.setGrade(list[gradeDropDownList.getSelectedIndex()]);
		}
			
		/*if (!collectionGradeTxtBox.getValue().equals("")) {
			collection.setGrade(generateGrade(collectionGradeTxtBox.getValue()));
		}*/
		if(radioButtonPublic.isChecked()==true)
		{
			collection.setSharing("public");	
		}
		if(radioButtonShare.isChecked()==true)
		{
			collection.setSharing("anyonewithlink");	
		}
		if(radioButtonPrivate.isChecked()==true)
		{
			collection.setSharing("private");	
		}
		collection.setCollectionType("collection");
		if(isCheckedValue){
			collection.setMediaType("iPad_friendly");
		}else{
			collection.setMediaType("not_ipad_friendly");
		}

		return collection;
	}

	/*private String generateGrade(String gradeTxt){
		String tmpGradeTxt = "";
		gradeTxt = gradeTxt.replaceAll(" ", "");
		if (gradeTxt.indexOf("-") > 0){
			if (gradeTxt.indexOf(",") == -1){
				tmpGradeTxt = generateGradeIfHypen(gradeTxt);
			}else{
				String gradeList[];
				gradeList = gradeTxt.split(",");
				for (int k=0; k<gradeList.length;k++){
					if (gradeList[k].indexOf("-") > 0){
						if (k==gradeList.length){
							tmpGradeTxt = tmpGradeTxt + generateGradeIfHypen(gradeList[k]);
						}else{
							tmpGradeTxt = tmpGradeTxt + generateGradeIfHypen(gradeList[k]) + ",";
						}
					}else{
						if (k==gradeList.length-1){
							tmpGradeTxt = tmpGradeTxt + gradeList[k];
						}else{
							tmpGradeTxt = tmpGradeTxt + gradeList[k] + ",";
						}
					}
				}
			}
		}else{
			tmpGradeTxt = gradeTxt;
		}
		return tmpGradeTxt;
	}*/
	
	/*private String generateGradeIfHypen(String grade){
		String gradeList[];
		StringBuilder gradeStr = new StringBuilder();
		gradeList = grade.split("-");
		if (gradeList.length>=2){
			int start = Integer.parseInt(gradeList[0].trim());
			int end = Integer.parseInt(gradeList[1].trim());
			if ( start < end){
				for (int i = start; i<=end; i++){
					if (i==end){
						gradeStr.append(i);
					}else{
						gradeStr.append(i).append(",");
					}
				}
			}
		}else{
			gradeStr.append(Integer.parseInt(gradeList[0].trim()));
		}
		return gradeStr.toString();
	}*/
	/**
	 * It will return the representation of a view as the widget
	 */
	@Override
	public Widget asWidget() {
		collectionTitleTxtBox.setFocus(true);
		return appPopUp;
	}
	/**
	 * This method is used to reset the data.
	 */
	@Override
	public void reset() {
		btnOk.setEnabled(true);
		collectionDo = null;
		buttonMainContainer.setVisible(true);
		loadingTextLbl.setVisible(false);
		collectionTitleTxtBox.setText("");
		validationErrorLbl.setVisible(false);
		mandatoryErrorLbl.setVisible(false);
		courseLisBox = new GroupedListBox();
		courseLisBox.setStyleName(CollectionCBundle.INSTANCE.css().contentAlignInputs());
		groupSimPanel.setWidget(courseLisBox);
		gradeDropDownList.setSelectedIndex(0);
		if(AppClientFactory.getLoggedInUser().getConfirmStatus()==0){
			radioButtonPublic.setEnabled(false);
			radioButtonPublic.setChecked(false);
			radioButtonShare.setChecked(true);
			radioButtonPrivate.setChecked(false);
		}else{
			radioButtonPublic.setEnabled(true);
			radioButtonPublic.setChecked(true);
			radioButtonShare.setChecked(false);
			radioButtonPrivate.setChecked(false);
		}
	}
	
	
	/**
	 * This method is used to create the  mobile support collection
	 */
	/*@UiHandler("checkMobileSupport")
	public void oncheckMobileSupportEvent(ClickEvent event) {

		if (isCheckedValue) {
			MixpanelUtil.MOS_New_Collection_Player_Checkbox("Unselected");
			checkMobileSupport.setStyleName(res.css().classPageEmailCheckBoxBgHoverSprite());
			isCheckedValue = false;
		} else {
			MixpanelUtil.MOS_New_Collection_Player_Checkbox("Selected");
			checkMobileSupport.setStyleName(res.css()
					.classPageEmailCheckBoxBgHover());
			isCheckedValue = true;
		}
		
		 * if(cfm.equalsIgnoreCase("yes")){
		 * toTxt.setText(toTxt.getText()+","+fromTxt.getText()); }else{
		 * 
		 * }
		 

	}*/
	/**
	 * This method is used to set the collection data.
	 */
	@Override
	public CollectionDo setData(CollectionDo collection) {
		this.collectionDo = collection;
		collectionTitleTxtBox.setText(collection.getTitle());
		/*if (collection.getGrade() != null) {
			collectionGradeTxtBox.setText(collection.getGrade());
		}*/
		setCourseData();
		return collection;
	}
	/**
	 * 
	 * @function setCourseData 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This method is used to set the course data.
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	private void setCourseData() {
		if (this.collectionDo != null && this.collectionDo.getTaxonomySet() != null && courseLisBox.getItemCount() > 0) {
			for (CodeDo code : this.collectionDo.getTaxonomySet()) {
				if (code.getDepth() == 2) {
					courseLisBox.setValue(code.getCodeId() + "");
					break;
				}
			}
		}
	}
	/**
	 * This method is used to set the library codes.
	 */
	@Override
	public void setLibraryCodes(List<LibraryCodeDo> libraryCode) {
		//courseLisBox.clear();
		courseLisBox.addItem("- Select course -", "-1");
		if (libraryCode != null) {
			for (LibraryCodeDo libraryCodes : libraryCode) {
				for (LibraryCodeDo libCode : libraryCodes.getNode()) {
					courseLisBox.addItem(libraryCodes.getLabel() + "|" + libCode.getLabel(), libCode.getCodeId() + "");
				}
			}
		}
		setCourseData();
	}

	/**
	 * Check and added error message if any error occurred in the collection form  
	 * 
	 * @return error list
	 */
	public Map<String, String> validateCollectionForm() {
		Map<String, String> errorList = new HashMap<String, String>();
		String tiltle = collectionTitleTxtBox.getText();
		if (tiltle.toLowerCase().contains("www.") || tiltle.toLowerCase().contains("http://") || tiltle.toLowerCase().contains("https://") || tiltle.toLowerCase().contains("ftp://")){
			mandatoryErrorLbl.setText("Title cannot be a URL.");
			mandatoryErrorLbl.setVisible(true);
			errorList.put("title", "title cannot be a url.");
		}else if (tiltle.trim().equals("") || tiltle.equalsIgnoreCase("Untitled Collection")) {
			errorList.put("title", "title can not be empty");
			mandatoryErrorLbl.setText("Please enter a title");
			mandatoryErrorLbl.setVisible(true);
		}
		return errorList;
	}
	/**
	 * This method is used to get the course id's.
	 */
	@Override
	public String getCourseCodeId() {
		if (!courseLisBox.getValue().equals("-1")) {
			String selectedValue = courseLisBox.getValue(courseLisBox.getSelectedIndex());
			if (!selectedValue.equals("-1")) {
				return selectedValue;
			}
		}
		return null;
	}
	/**
	 * This method is used to get the account type id.
	 */
	public void getAccountTypeId()
	{
	AppClientFactory
				.getInjector().getUserService().getUserProfileDetails(GOORU_UID, new AsyncCallback<SettingDo>() {
					
					@Override
					public void onSuccess(SettingDo result) {
						if(result.getUser().getAccountTypeId()!=null)
						{
							if(result.getUser().getAccountTypeId()==2)
							{
								publicShareFloPanel.setVisible(false);
							}
							else
							{
								publicShareFloPanel.setVisible(true);
							}
						}
						else
						{
							publicShareFloPanel.setVisible(true);	
						}
						
					}

					@Override
					public void onFailure(Throwable caught) {
					}
					
				});
		
	}
	/**
	 * This method is called immediately after a widget becomes attached to the browser's document.
	 */
	@Override
	public void onLoad() {
		getUiHandlers().getCourse();
	}
	/**
	 * This method is called immediately before a widget will be detached from the browser's document.
	 */
	@Override
	public void onUnload() {
		// TODO Auto-generated method stub
		
	}
}
