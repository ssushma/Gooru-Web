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

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BasePopupViewWithHandlers;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.client.uc.BlueButtonUc;
import org.ednovo.gooru.client.uc.DownToolTipUc;
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
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.tractionsoftware.gwt.user.client.ui.GroupedListBox;

/**
 * 
 * @fileName : CollectionFormView.java
 *
 * @description :  This class is used to create new collection
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
public class CollectionFormView extends
		BasePopupViewWithHandlers<CollectionFormUiHandlers> implements
		IsCollectionFormView {

	@UiField
	TextBoxWithPlaceholder collectionTitleTxtBox;

	/*
	 * @UiField TextBoxWithPlaceholder collectionGradeTxtBox;
	 */
	GroupedListBox courseLisBox;

	@UiField
	SimplePanel groupSimPanel, collectionGradeTxtBox;

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

	@UiField
	FlowPanel  linkShareFloPanel, privateShareFloPanel;
	
	@UiField Label lblTitle/*mobileTxtLbl*/;

	// @UiField FocusPanel publicImageTooltipFocPanel;

	@UiField
	HTMLPanel publicRadioButtonPanel, shareRadioButtonPanel,
			privateRadioButtonPanel,buttonMainContainer;

	@UiField
	Label gradeHelpIcon, courseHelpIcon, lblGrade, lblCourse,loadingTextLbl/*checkMobileSupport*/;
	
	@UiField
	HTMLEventPanel gradeToolTip, courseToolTip, publicShareFloPanel;
	
//	@UiField Image imgQuestionImage;
	
	RadioButton radioButtonPublic = new RadioButton("", "");
	RadioButton radioButtonShare = new RadioButton("", "");
	RadioButton radioButtonPrivate = new RadioButton("", "");
	private static final String GOORU_UID = "gooruuid";

	final String[] list = { "- Select Grade(s) -", "Kindergarten", "1", "2",
			"3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
			"Higher Education" };

	ListBox gradeDropDownList = new ListBox();

	private NewCollectionInfoPopup newCollectionInfoPopup;

	@UiField(provided = true)
	CollectionCBundle res;

	private AppPopUp appPopUp;
	
	ToolTip toolTip = null;

	private CollectionDo collectionDo;
	
	private  boolean isCheckedValue;

//	public static final String GRADE_INFO = MessageProperties.GL0320;

//	public static final String COURSE_INFO = MessageProperties.GL0321;

	private static final String TITLE_THIS_COLLECTION = MessageProperties.GL0322;
	
	private static String CONFIRM_MESSAGE = "You need to confirm your account before you can make collections public!";

	private DownToolTipUc gradetooltipPopUpUc;
	
	private DownToolTipUc coursetooltipPopUpUc;
	
	private PopupPanel toolTipPopupPanel=new PopupPanel();

	private static CollectionFormViewUiBinder uiBinder = GWT
			.create(CollectionFormViewUiBinder.class);

	interface CollectionFormViewUiBinder extends
			UiBinder<Widget, CollectionFormView> {
	}

	/**
	 * Class constructor
	 * 
	 * @param eventBus
	 *            {@link EventBus}
	 */
	@Inject
	public CollectionFormView(EventBus eventBus) {
		super(eventBus);
		hideFromPopup(true);
		this.res = CollectionCBundle.INSTANCE;
		res.css().ensureInjected();
		appPopUp = new AppPopUp();
		appPopUp.setContent(TITLE_THIS_COLLECTION,uiBinder.createAndBindUi(this));
		getAccountTypeId();
		buttonFloPanel.add(validationErrorFloPanel);
		validationErrorLbl.setVisible(false);
		mandatoryErrorLbl.setVisible(false);
		//buttonFloPanel.add(buttonMainContainer);
		//buttonFloPanel.add(cancelAnr);
		isCheckedValue=false;
		publicShareFloPanel.setVisible(false);
		collectionTitleTxtBox.getElement().setAttribute("maxlength", "50");
		collectionTitleTxtBox.getElement().setAttribute("placeholder", MessageProperties.GL0319);
		collectionTitleTxtBox.getElement().setAttribute("style", "width:180px !important");
		radioButtonPublic.getElement().setId("rdPublic");
		radioButtonShare.getElement().setId("rdShare");
		radioButtonPrivate.getElement().setId("rdPrivate");
		collectionTitleTxtBox.getElement().setId("txtCollectionTitle");
		appPopUp.setTitle("New Collection");
		appPopUp.getElement().getStyle().setWidth(538, Unit.PX);
		/*loadingTextLbl.getElement().getStyle().setFontStyle(FontStyle.ITALIC);
		loadingTextLbl.getElement().getStyle().setDisplay(Display.NONE);
		mobileTxtLbl.getElement().getStyle().setPaddingTop(6, Unit.PX);*/
		/*imgQuestionImage.getElement().getStyle().setPaddingTop(16, Unit.PX);
		imgQuestionImage.addMouseOverHandler(new MouseOverHandler() {
			
			@Override
			public void onMouseOver(MouseOverEvent event) {
				toolTip = new ToolTip();
				
				toolTip.getElement().getStyle().setBackgroundColor("transparent");
				toolTip.getElement().getStyle().setPosition(Position.ABSOLUTE);
				toolTip.getElement().getStyle().setZIndex(999);	
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
					MixpanelUtil.Create_EmptyCollection();
					String folderId = AppClientFactory.getPlaceManager().getRequestParameter("folderid");
					btnOk.setEnabled(false);
					buttonMainContainer.setVisible(false);
					loadingTextLbl.getElement().getStyle().setDisplay(Display.BLOCK);
					getUiHandlers().saveCollection(folderId);
					AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
					toolTipPopupPanel.hide();
				}
			}
		});
		cancelAnr.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
				hide();
				toolTipPopupPanel.hide();
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
					toolTipPopupPanel.setPopupPosition(publicShareFloPanel.getElement().getAbsoluteLeft()+10, publicShareFloPanel.getElement().getAbsoluteTop()+10);
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
		setTextAndIds();
		
	}
	/**
	 * 
	 * @function setTextAndIds 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This method is used to set the UI.
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
		collectionTitleTxtBox.setPlaceholder(MessageProperties.GL0319);
		mandatoryErrorLbl.setText(MessageProperties.GL0173);
		lblGrade.setText(MessageProperties.GL0325);
		gradeHelpIcon.setText(MessageProperties.GL_SPL_QUESTION);
		lblCourse.setText(MessageProperties.GL0326);
		courseHelpIcon.setText(MessageProperties.GL_SPL_QUESTION);
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
	 * This method is used to get GrageList
	 */
	public void getGradeList() {

		gradeDropDownList.setStyleName(CollectionCBundle.INSTANCE.css()
				.contentAlignInputs());

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
	 * This class is used for validation on collection title keypress.
	 * 
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
 * This method is used to get collection data
 * @return collection
 */
	@Override
	public CollectionDo getData() {

		CollectionDo collection = new CollectionDo();
		if (this.collectionDo != null) {
			collection.setGooruOid(this.collectionDo.getGooruOid());
		}
		collection.setTitle(collectionTitleTxtBox.getText());
		if (!(gradeDropDownList.getSelectedIndex() == 0)) {
			collection.setGrade(list[gradeDropDownList.getSelectedIndex()]);
		}
		if (radioButtonPublic.isChecked() == true) {
			collection.setSharing("public");
		}
		if (radioButtonShare.isChecked() == true) {
			collection.setSharing("anyonewithlink");
		}
		if (radioButtonPrivate.isChecked() == true) {
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
/**
 * This method is used to generate grade
 * @param gradeTxt
 * @return tmpGradeTxt
 */
	/*private String generateGrade(String gradeTxt) {
		String tmpGradeTxt = "";
		gradeTxt = gradeTxt.replaceAll(" ", "");
		if (gradeTxt.indexOf("-") > 0) {
			if (gradeTxt.indexOf(",") == -1) {
				tmpGradeTxt = generateGradeIfHypen(gradeTxt);
			} else {
				String gradeList[];
				gradeList = gradeTxt.split(",");
				for (int k = 0; k < gradeList.length; k++) {
					if (gradeList[k].indexOf("-") > 0) {
						if (k == gradeList.length) {
							tmpGradeTxt = tmpGradeTxt
									+ generateGradeIfHypen(gradeList[k]);
						} else {
							tmpGradeTxt = tmpGradeTxt
									+ generateGradeIfHypen(gradeList[k]) + ",";
						}
					} else {
						if (k == gradeList.length - 1) {
							tmpGradeTxt = tmpGradeTxt + gradeList[k];
						} else {
							tmpGradeTxt = tmpGradeTxt + gradeList[k] + ",";
						}
					}
				}
			}
		} else {
			tmpGradeTxt = gradeTxt;
		}
		return tmpGradeTxt;
	}*/

	/*private String generateGradeIfHypen(String grade) {
		String gradeList[];
		StringBuilder gradeStr = new StringBuilder();
		gradeList = grade.split("-");
		if (gradeList.length >= 2) {
			int start = Integer.parseInt(gradeList[0].trim());
			int end = Integer.parseInt(gradeList[1].trim());
			if (start < end) {
				for (int i = start; i <= end; i++) {
					if (i == end) {
						gradeStr.append(i);
					} else {
						gradeStr.append(i).append(",");
					}
				}
			}
		} else {
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
	 * This method is used to reset data
	 * @see org.ednovo.gooru.client.gin.BasePopupViewWithHandlers#reset()
	 */
	@Override
	public void reset() {
		btnOk.setEnabled(true);
		buttonMainContainer.setVisible(true);
		loadingTextLbl.setVisible(false);
		collectionDo = null;
		collectionTitleTxtBox.setText("");
		validationErrorLbl.setVisible(false);
		mandatoryErrorLbl.setVisible(false);
		courseLisBox = new GroupedListBox();
		courseLisBox.setStyleName(CollectionCBundle.INSTANCE.css()
				.contentAlignInputs());
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
	 *//*
	@UiHandler("checkMobileSupport")
	public void oncheckMobileSupportEvent(ClickEvent event) {

		if (isCheckedValue) {
			MixpanelUtil.MOS_New_Collection_Checkbox("Unselected");
			checkMobileSupport.setStyleName(res.css().classPageEmailCheckBoxBgHoverSprite());
			isCheckedValue = false;
		} else {
			MixpanelUtil.MOS_New_Collection_Checkbox("Selected");
			checkMobileSupport.setStyleName(res.css().classPageEmailCheckBoxBgHover());
			isCheckedValue = true;
		}
	}
	*/
	/*@Override
	public void updateCollectionFormCheckBox(boolean check) {
		if(check) {
			MixpanelUtil.MOS_New_Collection_Checkbox("UnSelected");
			checkMobileSupport.setStyleName(res.css().classPageEmailCheckBoxBgHoverSprite());
			isCheckedValue = false;
		} else {
			MixpanelUtil.MOS_New_Collection_Checkbox("Selected");
			checkMobileSupport.setStyleName(res.css().classPageEmailCheckBoxBgHover());
			isCheckedValue = true;
		}
	}*/
	
	/**
	 * This method is used to set collection data
	 * @return collection
	 */
	@Override
	public CollectionDo setData(CollectionDo collection) {
		this.collectionDo = collection;
		collectionTitleTxtBox.setText(collection.getTitle());
		/*
		 * if (collection.getGrade() != null) {
		 * collectionGradeTxtBox.setText(collection.getGrade()); }
		 */
		setCourseData();
		return collection;
	}
	/**
	 * This method is used to set course data
	 */
	private void setCourseData() {
		if (this.collectionDo != null
				&& this.collectionDo.getTaxonomySet() != null
				&& courseLisBox.getItemCount() > 0) {
			for (CodeDo code : this.collectionDo.getTaxonomySet()) {
				if (code.getDepth() == 2) {
					courseLisBox.setValue(code.getCodeId() + "");
					break;
				}
			}
		}
	}

	/**
	 * This method is used for set LibraryCodes for course
	 */
	@Override
	public void setLibraryCodes(List<LibraryCodeDo> libraryCode) {
		courseLisBox.addItem("- Select course -", "-1");
		if (libraryCode != null) {
			for (LibraryCodeDo libraryCodes : libraryCode) {
				for (LibraryCodeDo libCode : libraryCodes.getNode()) {
					courseLisBox.addItem(libraryCodes.getLabel() + "|"
							+ libCode.getLabel(), libCode.getCodeId() + "");
				}
			}
		}
		setCourseData();
	}

	/**
	 * Check and added error message if any error occurred in the collection
	 * form
	 * 
	 * @return error list
	 */
	public Map<String, String> validateCollectionForm() {
		Map<String, String> errorList = new HashMap<String, String>();
		String tiltle = collectionTitleTxtBox.getText();
		if (tiltle.toLowerCase().contains("www.")
				|| tiltle.toLowerCase().contains("http://")
				|| tiltle.toLowerCase().contains("https://")
				|| tiltle.toLowerCase().contains("ftp://")) {
			mandatoryErrorLbl.setText(MessageProperties.GL0323);
			mandatoryErrorLbl.setVisible(true);
			errorList.put("title", MessageProperties.GL0323.toLowerCase());
		} else if (tiltle.trim().equals("")
				|| tiltle.equalsIgnoreCase(MessageProperties.GL0319)) {
			errorList.put("title", MessageProperties.GL0324);
			mandatoryErrorLbl.setText(MessageProperties.GL0173);
			mandatoryErrorLbl.setVisible(true);
		}
		return errorList;
	}

	/**
	 * This method is used to get course code id for selected course 
	 */
	@Override
	public String getCourseCodeId() {
		if (!courseLisBox.getValue().equals("-1")) {
			String selectedValue = courseLisBox.getValue(courseLisBox
					.getSelectedIndex());
			if (!selectedValue.equals("-1")) {
				return selectedValue;
			}
		}
		return null;
	}
	/**
	 * This method is for default page view 
	 * @return COLLECTION_SEARCH Token
	 */
	@Override
	protected String getDefaultView() {
		return PlaceTokens.COLLECTION_SEARCH;
	}

	/*private void showGradePopup(int left, int top) {
		if (!newCollectionInfoPopup.isShowing()) {
			newCollectionInfoPopup.show();
			newCollectionInfoPopup.center();
			newCollectionInfoPopup.setPopupPosition(left, top);
		}
	}*/
	/**
	 * 
	 * @function onGradeHelpiconClicked 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This UIHandler is used to display gradeToolTip on gradeHelpIcon click
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("gradeHelpIcon")
	public void onGradeHelpiconClicked(ClickEvent event) {
		if(!(gradeToolTip.getWidgetCount()>0)) {
			gradetooltipPopUpUc = new DownToolTipUc();
			gradetooltipPopUpUc.getElement().setAttribute("style", "line-height: 1.2 !important;");
			gradetooltipPopUpUc.setContent(new HTML(MessageProperties.GL0300));
			gradeToolTip.add(gradetooltipPopUpUc);
		}
		if(gradeToolTip.isVisible()) {
			gradeToolTip.setVisible(false);
		} else {
			gradeToolTip.setVisible(true);
			courseToolTip.setVisible(false);
		}
	}
	/**
	 * 
	 * @function onCourseHelpiconClicked 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description : This UIHandler is used to display courseToolTip on courseHelpIcon click
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@UiHandler("courseHelpIcon")
	public void onCourseHelpiconClicked(ClickEvent event) {
		if(!(courseToolTip.getWidgetCount()>0)) {
			coursetooltipPopUpUc = new DownToolTipUc();
			coursetooltipPopUpUc.getElement().setAttribute("style", "line-height: 1.2 !important;");
			coursetooltipPopUpUc.setContent(new HTML(MessageProperties.GL0301));
			courseToolTip.add(coursetooltipPopUpUc);
		}
		if(courseToolTip.isVisible()) {
			courseToolTip.setVisible(false);
		} else {
			courseToolTip.setVisible(true);
			gradeToolTip.setVisible(false);
		}
	}
	/**
	 * This is used to close the popup's
	 */
	@Override
	public void closeAllopenedPopUp() {
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		hide();
	}
	/**
	 * This is used to get the account type id.
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
								radioButtonShare.setChecked(true);
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
}
