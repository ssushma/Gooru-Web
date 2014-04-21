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

import org.apache.bcel.generic.GETSTATIC;
import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
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
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.query.client.css.HeightProperty;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.tractionsoftware.gwt.user.client.ui.GroupedListBox;

/**
 * @fileName : CollectionFormView.java
 * 
 * @description : This class is used to create new collection
 * 
 * 
 * @version : 5.5
 * 
 * @date: Apr 17, 2013
 * 
 * @Author :Gooru Team
 * 
 * @Reviewer:
 */
public class CollectionFormView extends
		BasePopupViewWithHandlers<CollectionFormUiHandlers> implements
		IsCollectionFormView,MessageProperties {

	@UiField
	TextBoxWithPlaceholder collectionTitleTxtBox;

	GroupedListBox courseLisBox;

	@UiField
	SimplePanel groupSimPanel, collectionGradeTxtBox;

	@UiField
	FlowPanel buttonFloPanel;

	/*@UiField
	Anchor cancelAnr;*/
	
	@UiField
	Button cancelAnr;

	

	/*@UiField
	BlueButtonUc btnOk;*/
	
	@UiField
	Button btnOk;
	
	@UiField
	Label mandatoryErrorLbl, lblVisibility,lblPublic,lblAllow,lblShareable,lblShareableDesc,lblPrivate, lblPrivateDesc;

	@UiField
	FlowPanel  linkShareFloPanel, privateShareFloPanel;
	
	@UiField
	HTMLPanel publicRadioButtonPanel, shareRadioButtonPanel,
			privateRadioButtonPanel,buttonMainContainer,visibilitySection,courseContainer,gradeContainer,shelfItemContent;

	@UiField
	Label loadingTextLbl,collPopUpMainheading,collPopUpSubheading,collTitleLbl,gradeLbl,courseLbl;
	
	@UiField
	HTMLEventPanel publicShareFloPanel;
	
	
	RadioButton radioButtonPublic = new RadioButton("", "");
	RadioButton radioButtonShare = new RadioButton("", "");
	RadioButton radioButtonPrivate = new RadioButton("", "");
	private static final String GOORU_UID = "gooruuid";

	final String[] list = { "- Select Grade(s) -", "Kindergarten", "1", "2",
			"3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
			"Higher Education" };

	ListBox gradeDropDownList = new ListBox();

	private NewCollectionInfoPopup newCollectionInfoPopup;

	private AppPopUp appPopUp;
	
	ToolTip toolTip = null;

	private CollectionDo collectionDo;
	
	private  boolean isCheckedValue;
	
	boolean isHavingBadWords;

	private static String TITLE_THIS_COLLECTION = GL0322;

	
	private static String CONFIRM_MESSAGE =GL1490+GL_SPL_EXCLAMATION;
	
	private static String REQ_COLLECTION_TITLE="collectionTitle";
	
	private static String DRAGGED_COLLECTION_TITLE="draggedCollectionTitle";

	private DownToolTipUc gradetooltipPopUpUc;
	
	private DownToolTipUc coursetooltipPopUpUc;
	

	private static final String O1_LEVEL = "o1";
	
	private static final String O2_LEVEL = "o2";
	
	private static final String O3_LEVEL = "o3";
	
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
		appPopUp = new AppPopUp();
		appPopUp.setContent(TITLE_THIS_COLLECTION,uiBinder.createAndBindUi(this));
		getAccountTypeId();
		mandatoryErrorLbl.setVisible(false);
		isCheckedValue=false;
		publicShareFloPanel.setVisible(false);
		loadingTextLbl.setText(GL0591.toLowerCase());
		collectionTitleTxtBox.getElement().setAttribute("maxlength", "50");
//		collectionTitleTxtBox.getElement().setAttribute("placeholder", MessageProperties.GL0319);
		radioButtonPublic.getElement().setId("rdPublic");
		radioButtonShare.getElement().setId("rdShare");
		radioButtonPrivate.getElement().setId("rdPrivate");
		collectionTitleTxtBox.getElement().setId("txtCollectionTitle");
		appPopUp.setTitle(GL0993);
		
		collectionTitleTxtBox.addBlurHandler(new BlurHandler() {
			
			@Override
			public void onBlur(BlurEvent event) {
				if (collectionTitleTxtBox.getText().length() > 0){
					Map<String, String> parms = new HashMap<String, String>();
					parms.put("text", collectionTitleTxtBox.getText());
					AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {
	
						@Override
						public void onSuccess(Boolean value) {
							btnOk.getElement().removeClassName("disabled");
							if (value){
								collectionTitleTxtBox.getElement().getStyle().setBorderColor("orange");
								mandatoryErrorLbl.setText(GL0554);
								mandatoryErrorLbl.setVisible(true);
								mandatoryErrorLbl.getElement().getStyle().setMarginRight(63,Unit.PX);
							}else{
								collectionTitleTxtBox.getElement().getStyle().clearBackgroundColor();
								collectionTitleTxtBox.getElement().getStyle().setBorderColor("#ccc");
								mandatoryErrorLbl.setVisible(false);
							}
						}
					});
				}
			}
		});
		
		collectionTitleTxtBox.addKeyPressHandler(new KeyPressHandler() {
			
			@Override
			public void onKeyPress(KeyPressEvent event) {
				collectionTitleTxtBox.getElement().getStyle().clearBackgroundColor();
				collectionTitleTxtBox.getElement().getStyle().setBorderColor("#ccc");
				mandatoryErrorLbl.setVisible(false);
			}
		});
		
		appPopUp.getElement().getStyle().setWidth(521, Unit.PX);
		appPopUp.getElement().getStyle().setHeight(460, Unit.PX);
		
		btnOk.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				btnOk.setEnabled(false);
				btnOk.getElement().addClassName("disabled");
				Map<String, String> parms = new HashMap<String, String>();
				parms.put("text", collectionTitleTxtBox.getText());
				AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {
					
					@Override
					public void onSuccess(Boolean value) {
						isHavingBadWords = value;
//						btnOk.getElement().addClassName("disabled");
						if (value){
							collectionTitleTxtBox.getElement().getStyle().setBorderColor("orange");
							mandatoryErrorLbl.setText(GL0554);
							mandatoryErrorLbl.setVisible(true);
							mandatoryErrorLbl.getElement().getStyle().setMarginRight(63,Unit.PX);
							btnOk.setEnabled(true);
							btnOk.getElement().removeClassName("disabled");
						}else{
							collectionTitleTxtBox.getElement().getStyle().clearBackgroundColor();
							collectionTitleTxtBox.getElement().getStyle().setBorderColor("#ccc");
							mandatoryErrorLbl.setVisible(false);
							if (validateCollectionForm().size() == 0) {
								MixpanelUtil.Create_EmptyCollection();
								String folderId = AppClientFactory.getPlaceManager().getRequestParameter("folderId");
								final String o1 = AppClientFactory.getPlaceManager().getRequestParameter(O1_LEVEL);
								final String o2 = AppClientFactory.getPlaceManager().getRequestParameter(O2_LEVEL);
								final String o3 = AppClientFactory.getPlaceManager().getRequestParameter(O3_LEVEL);
								btnOk.setEnabled(false);
//								btnOk.getElement().addClassName("disabled");
								buttonMainContainer.setVisible(false);
								loadingTextLbl.getElement().getStyle().setDisplay(Display.BLOCK); 
								if(AppClientFactory.getPlaceManager().getRequestParameter(REQ_COLLECTION_TITLE)!=null&&!AppClientFactory.getPlaceManager().getRequestParameter(REQ_COLLECTION_TITLE).equalsIgnoreCase("")){
									getUiHandlers().copyCollection(collectionTitleTxtBox.getText().trim(),AppClientFactory.getPlaceManager().getRequestParameter("collectionId"));
								}else if(AppClientFactory.getPlaceManager().getRequestParameter(DRAGGED_COLLECTION_TITLE)!=null&&!AppClientFactory.getPlaceManager().getRequestParameter(DRAGGED_COLLECTION_TITLE).equalsIgnoreCase("")){
									getUiHandlers().copyDraggedCollection(collectionTitleTxtBox.getText().trim(),AppClientFactory.getPlaceManager().getRequestParameter("collectionId"),AppClientFactory.getPlaceManager().getRequestParameter("selectedFolderId"));
								}else{
									getUiHandlers().saveCollection(folderId,o1,o2,o3); 
								}
								
								AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
								toolTipPopupPanel.hide();
							}
						}
					}
				});
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
	
	public void setTextAndIds(){
		collectionTitleTxtBox.setPlaceholder(GL0319);
		mandatoryErrorLbl.setText(GL0173);
		lblVisibility.setText(GL0328);
		lblPublic.setText(GL0329);
		lblAllow.setText(GL0330);
		lblShareable.setText(GL0331);
		lblShareableDesc.setText(GL0332);
		lblPrivate.setText(GL0333);
		lblPrivateDesc.setText(GL0334);
		
		gradeLbl.setText(GL0325+GL_SPL_SEMICOLON);
		courseLbl.setText(GL0326+GL_SPL_SEMICOLON);
		btnOk.getElement().setId("btnOk");
		cancelAnr.getElement().setId("lnkCancel");
		/*btnOk.setText(GL0636);
		cancelAnr.setText(MessageProperties.GL0142);*/
	}

	/**
	 * This method is used to get GrageList
	 */
	public void getGradeList() {
		gradeDropDownList.setStyleName(CollectionCBundle.INSTANCE.css().createCollContentAlignInputs());
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
			btnOk.setEnabled(true);
			btnOk.getElement().removeClassName("disabled");
			if (collectionTitleTxtBox.getText().length() >= 50) {
				mandatoryErrorLbl.setText(GL0143);
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
		btnOk.getElement().removeClassName("disabled");
		collectionTitleTxtBox.getElement().getStyle().setBorderColor("#cccccc");
		cancelAnr.getElement().getStyle().setMarginRight(10, Unit.PX);
		buttonMainContainer.setVisible(true);
		loadingTextLbl.setVisible(false);
		collectionDo = null;
		collectionTitleTxtBox.setText("");
		removePopUpStyle();
		
		
		if(AppClientFactory.getPlaceManager().getRequestParameter(REQ_COLLECTION_TITLE)!=null&&!AppClientFactory.getPlaceManager().getRequestParameter(REQ_COLLECTION_TITLE).equalsIgnoreCase("")){
			collPopUpMainheading.setText(GL1421);
			collPopUpSubheading.setText(GL1365);
			collTitleLbl.setText(GL0553);
			collectionTitleTxtBox.setText(AppClientFactory.getPlaceManager().getRequestParameter(REQ_COLLECTION_TITLE));
			btnOk.setText(GL0636);
			cancelAnr.setText(GL0142);
			appPopUp.setViewTitle(GL1421);
			setPopUpStyle();
		}else if(AppClientFactory.getPlaceManager().getRequestParameter(DRAGGED_COLLECTION_TITLE)!=null&&!AppClientFactory.getPlaceManager().getRequestParameter(DRAGGED_COLLECTION_TITLE).equalsIgnoreCase("")){
			collPopUpMainheading.setText(GL1421);
			collPopUpSubheading.setText(GL1365);
			collTitleLbl.setText(GL0553);
			collectionTitleTxtBox.setText(AppClientFactory.getPlaceManager().getRequestParameter(DRAGGED_COLLECTION_TITLE));
			btnOk.setText(GL0636);
			cancelAnr.setText(GL0142);
			appPopUp.setViewTitle(GL1421);
			setPopUpStyle();
		}else{
			if(AppClientFactory.getPlaceManager().getPreviousRequest().getNameToken().equals(PlaceTokens.SHELF)){
				collPopUpMainheading.setText(GL0993);
				collPopUpSubheading.setText(GL1033);
				collTitleLbl.setText(GL0993+GL_SPL_SEMICOLON);
				btnOk.setText(GL0141);
				cancelAnr.setText(GL0142);
				appPopUp.setViewTitle(GL0322);
			}else{
				collPopUpMainheading.setText(GL0993);
				collPopUpSubheading.setText(GL1033);
				collTitleLbl.setText(GL0651);
				btnOk.setText(GL0636);
				cancelAnr.setText(GL0142);
				appPopUp.setViewTitle(GL0322);
			}
			
		}
		
		if(AppClientFactory.getPlaceManager().getRequestParameter("resourceId")!=null&&!AppClientFactory.getPlaceManager().getRequestParameter("resourceId").equalsIgnoreCase("")){
			appPopUp.setViewTitle(GL0322);
		}
//		validationErrorLbl.setVisible(false);
		mandatoryErrorLbl.setVisible(false);
		courseLisBox = new GroupedListBox();
		courseLisBox.setStyleName(CollectionCBundle.INSTANCE.css().createCollContentAlignInputs());
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
	
	private void setPopUpStyle() {
		visibilitySection.getElement().getStyle().setDisplay(Display.NONE);
		lblVisibility.getElement().getStyle().setDisplay(Display.NONE);
		gradeContainer.getElement().getStyle().setDisplay(Display.NONE);
		courseContainer.getElement().getStyle().setDisplay(Display.NONE);
		appPopUp.getElement().getStyle().setHeight(200, Unit.PX);
		appPopUp.getElement().getStyle().setTop(195, Unit.PX);
		shelfItemContent.getElement().setAttribute("style", "min-height: 200px");	
	}
	
	private void removePopUpStyle() {
		visibilitySection.getElement().getStyle().setDisplay(Display.BLOCK);
		lblVisibility.getElement().getStyle().setDisplay(Display.BLOCK);
		gradeContainer.getElement().getStyle().setDisplay(Display.BLOCK);
		courseContainer.getElement().getStyle().setDisplay(Display.BLOCK);
		appPopUp.getElement().getStyle().setHeight(460, Unit.PX);
		shelfItemContent.getElement().setAttribute("style", "min-height: 400px");	
	}

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
			mandatoryErrorLbl.setText(GL0323);
			mandatoryErrorLbl.setVisible(true);
			errorList.put("title", GL0323.toLowerCase());
		} else if (tiltle.trim().equals("")
				|| tiltle.equalsIgnoreCase(GL0319)) {
			errorList.put("title", GL0324);
			mandatoryErrorLbl.setText(GL0173);
			mandatoryErrorLbl.setVisible(true);
			mandatoryErrorLbl.getElement().getStyle().setMarginRight(62,Unit.PX);
		}else if (isHavingBadWords){
			errorList.put("title", GL0554);
			mandatoryErrorLbl.setText(GL0554);
			mandatoryErrorLbl.setVisible(true);
		}
		return errorList;
	}

	/**
	 * This method is used to get course code id for selected course 
	 */
	@Override
	public String getCourseCodeId() {
		try {
			if (!courseLisBox.getValue().equals("-1")) {
				String selectedValue = courseLisBox.getValue(courseLisBox
						.getSelectedIndex());
				if (!selectedValue.equals("-1")) {
					return selectedValue;
				}
			}
			return null;
		} catch (Exception e) {
			return null;}
	}
/**
 * This method is for default page view 
 * @return COLLECTION_SEARCH Token
 */
	@Override
	protected String getDefaultView() {
		return PlaceTokens.COLLECTION_SEARCH;
	}

	@Override
	public void onUnload() {
		if(!AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.HOME)){
			AppClientFactory.getPlaceManager().revealPlayerPreviousPlace(false, getDefaultView());
		}
	}

	@Override
	public void closeAllopenedPopUp() {
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		hide();
	}
	
	public void getAccountTypeId()
	{
		AppClientFactory.getInjector().getUserService().getUserProfileDetails(GOORU_UID, new AsyncCallback<SettingDo>() {

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
