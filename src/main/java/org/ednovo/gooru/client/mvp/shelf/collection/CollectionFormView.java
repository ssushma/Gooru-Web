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
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BasePopupViewWithHandlers;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.client.uc.BrowserAgent;
import org.ednovo.gooru.client.uc.DownToolTipUc;
import org.ednovo.gooru.client.uc.TextBoxWithPlaceholder;
import org.ednovo.gooru.client.uc.tooltip.GlobalToolTip;
import org.ednovo.gooru.client.uc.tooltip.ToolTip;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.client.util.SetStyleForProfanity;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.code.LibraryCodeDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.user.V2UserDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
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
		IsCollectionFormView {

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
	Button cancelAnr,btnCancelAssessment;

	

	/*@UiField
	BlueButtonUc btnOk;*/
	
	@UiField
	Button btnOk,btnExistingAssessment,btnNewAssessment,btnCreateAssessment;
	
	@UiField
	Label publicLbl,mandatoryErrorLbl, lblVisibility,lblPublic,lblAllow,lblShareable,lblShareableDesc,lblPrivate, lblPrivateDesc;

	@UiField
	FlowPanel  linkShareFloPanel, privateShareFloPanel;
	
	@UiField
	HTMLPanel pnlExistingAssessmentContainer,pnlNewAssessmentContainer,bodyContainer,pnlCreateNewAssessment,publicRadioButtonPanel, shareRadioButtonPanel,
			privateRadioButtonPanel,buttonMainContainer,visibilitySection,courseContainer,gradeContainer,shelfItemContent;

	@UiField
	Label loadingTextLbl,collPopUpMainheading,collPopUpSubheading,collTitleLbl,gradeLbl,courseLbl;
	
	@UiField
	HTMLEventPanel publicShareFloPanel;
	
	@UiField TextBoxWithPlaceholder txtNewAssessmentTitle,txtExistingAssessmentTitle,txtExistingAssessmentURL;
	
	boolean fromAddResourcePresenter=false;
	
	@UiField Label lblNewAssessmentError,lblExistingAssessmentError,lblExistingAssessmentURLError;
	
	
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
	
	static MessageProperties i18n = GWT.create(MessageProperties.class);

	private static String TITLE_THIS_COLLECTION = i18n.GL0322();

	
	private static String CONFIRM_MESSAGE =i18n.GL1490()+i18n.GL_SPL_EXCLAMATION();
	
	private static String REQ_COLLECTION_TITLE="collectionTitle";
	
	private static String DRAGGED_COLLECTION_TITLE="draggedCollectionTitle";

	private DownToolTipUc gradetooltipPopUpUc;
	
	private DownToolTipUc coursetooltipPopUpUc;
	

	private static final String O1_LEVEL = "o1";
	
	private static final String O2_LEVEL = "o2";
	
	private static final String O3_LEVEL = "o3";
	
	private PopupPanel toolTipPopupPanel=new PopupPanel();
	
	boolean isAssessmentEditClicked=false;

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
		CollectionCBundle.INSTANCE.css().ensureInjected();
		appPopUp.setContent(TITLE_THIS_COLLECTION,uiBinder.createAndBindUi(this));
		
		if(!(AppClientFactory.isAnonymous())){
			getAccountTypeId();
		}
		if (!BrowserAgent.isDevice()){
			appPopUp.getMainPanel().getElement().getStyle().setWidth(550, Unit.PX);
		}
		mandatoryErrorLbl.setVisible(false);
		isCheckedValue=false;
		publicShareFloPanel.setVisible(false);
		loadingTextLbl.setText(i18n.GL0591().toLowerCase());
		loadingTextLbl.getElement().setId("lblLoadingTextLbl");
		loadingTextLbl.getElement().setAttribute("alt",i18n.GL0591().toLowerCase());
		loadingTextLbl.getElement().setAttribute("title",i18n.GL0591().toLowerCase());
		  
		
		collectionTitleTxtBox.getElement().setAttribute("maxlength", "50");
//		collectionTitleTxtBox.getElement().setAttribute("placeholder", MessageProperties.i18n.GL0319);
		radioButtonPublic.getElement().setId("rdPublic");
		radioButtonShare.getElement().setId("rdShare");
		radioButtonPrivate.getElement().setId("rdPrivate");
		collectionTitleTxtBox.getElement().setId("txtCollectionTitle");
		appPopUp.setTitle(i18n.GL0993());
		
		buttonFloPanel.setVisible(false);
		
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
								mandatoryErrorLbl.setText(i18n.GL0554());
								mandatoryErrorLbl.getElement().setAttribute("alt",i18n.GL0554());
								mandatoryErrorLbl.getElement().setAttribute("title",i18n.GL0554());
								mandatoryErrorLbl.setVisible(true);
							/*	mandatoryErrorLbl.getElement().getStyle().setMarginRight(63,Unit.PX);*/
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
		appPopUp.getElement().getStyle().setHeight(320, Unit.PX);
		
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
							mandatoryErrorLbl.setText(i18n.GL0554());
							mandatoryErrorLbl.getElement().setAttribute("alt",i18n.GL0554());
							mandatoryErrorLbl.getElement().setAttribute("title",i18n.GL0554());
							mandatoryErrorLbl.setVisible(true);
							/*mandatoryErrorLbl.getElement().getStyle().setMarginRight(63,Unit.PX);*/
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
							//	final String resourceidonclick 	= AppClientFactory.getPlaceManager().getRequestParameter("resourceidfromAddResourcePresenter");
								final String resourceidonclick 	= AppClientFactory.getPlaceManager().getRequestParameter("resourceid");
								final String fromAddresourcePresenter 	= 	AppClientFactory.getPlaceManager().getRequestParameter("fromAddresource");
								
								
								btnOk.setEnabled(false);
//								btnOk.getElement().addClassName("disabled");
								buttonMainContainer.setVisible(false);
								loadingTextLbl.getElement().getStyle().setDisplay(Display.BLOCK); 
								if(AppClientFactory.getPlaceManager().getRequestParameter(REQ_COLLECTION_TITLE)!=null&&!AppClientFactory.getPlaceManager().getRequestParameter(REQ_COLLECTION_TITLE).equalsIgnoreCase("")){
									getUiHandlers().copyCollection(collectionTitleTxtBox.getText().trim(),AppClientFactory.getPlaceManager().getRequestParameter("collectionId"));
								}else if(AppClientFactory.getPlaceManager().getRequestParameter(DRAGGED_COLLECTION_TITLE)!=null&&!AppClientFactory.getPlaceManager().getRequestParameter(DRAGGED_COLLECTION_TITLE).equalsIgnoreCase("")){
									getUiHandlers().copyDraggedCollection(collectionTitleTxtBox.getText().trim(),AppClientFactory.getPlaceManager().getRequestParameter("collectionId"),AppClientFactory.getPlaceManager().getRequestParameter("selectedFolderId"));
								}else if(resourceidonclick!=null){
									getUiHandlers().saveCollectionForSearch(folderId,o1,o2,o3,resourceidonclick,fromAddresourcePresenter);
									}
								else{
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
		btnCancelAssessment.addClickHandler(new ClickHandler() {

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
		//Handling the click event on existing assessment click
		btnExistingAssessment.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				isAssessmentEditClicked=true;
				btnExistingAssessment.removeStyleName(CollectionCBundle.INSTANCE.css().deselecteAssessment());
				btnExistingAssessment.addStyleName(CollectionCBundle.INSTANCE.css().selecteAssessment());
				btnNewAssessment.removeStyleName(CollectionCBundle.INSTANCE.css().selecteAssessment());
				btnNewAssessment.addStyleName(CollectionCBundle.INSTANCE.css().deselecteAssessment());
				
				pnlExistingAssessmentContainer.setVisible(true);
				pnlNewAssessmentContainer.setVisible(false);
				btnCreateAssessment.setVisible(true);
				btnCancelAssessment.setVisible(true);
			}
		});
		//Handling the click event on new assessment click
		btnNewAssessment.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				isAssessmentEditClicked=false;
				btnExistingAssessment.removeStyleName(CollectionCBundle.INSTANCE.css().selecteAssessment());
				btnExistingAssessment.addStyleName(CollectionCBundle.INSTANCE.css().deselecteAssessment());
				btnNewAssessment.removeStyleName(CollectionCBundle.INSTANCE.css().deselecteAssessment());
				btnNewAssessment.addStyleName(CollectionCBundle.INSTANCE.css().selecteAssessment());
				
				pnlExistingAssessmentContainer.setVisible(false);
				pnlNewAssessmentContainer.setVisible(true);
				btnCreateAssessment.setVisible(true);
				btnCancelAssessment.setVisible(true);
			}
		});
		//Handling the click event on create assessment
		btnCreateAssessment.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(isAssessmentEditClicked){
					//Code when edit assessment selected
					String assessmentExistingTitle=txtExistingAssessmentTitle.getText();
					final String assessmentURL=txtExistingAssessmentURL.getText();
					if(assessmentExistingTitle.isEmpty()){
						lblExistingAssessmentError.setVisible(true);
						lblExistingAssessmentError.setText(i18n.GL1026());
					}else if(assessmentURL.isEmpty()){
						lblExistingAssessmentError.setVisible(false);
						lblExistingAssessmentError.setText("");
						lblExistingAssessmentURLError.setVisible(true);
						lblExistingAssessmentURLError.setText(i18n.GL3166());
					}else{
						final Map<String, String> parms = new HashMap<String, String>();
						parms.put("text", assessmentExistingTitle);
						AppClientFactory.getInjector().getResourceService().checkProfanity(parms,new AsyncCallback<Boolean>() {
							@Override
							public void onSuccess(Boolean value) {
								if(value){
									//Displaying error message
									SetStyleForProfanity.SetStyleForProfanityForTextBoxWithPlaceholder(txtExistingAssessmentTitle, lblExistingAssessmentError, value);
								}else{
									lblExistingAssessmentError.setVisible(false);
									lblExistingAssessmentError.setText("");
									parms.put("text", assessmentURL);
									AppClientFactory.getInjector().getResourceService().checkProfanity(parms,new AsyncCallback<Boolean>() {
										@Override
										public void onSuccess(Boolean result) {
											if(result){
												//Displaying error message
												SetStyleForProfanity.SetStyleForProfanityForTextBoxWithPlaceholder(txtExistingAssessmentURL, lblExistingAssessmentURLError, result);
											}else{
												lblExistingAssessmentURLError.setVisible(false);
												lblExistingAssessmentURLError.setText("");
												String folderId = AppClientFactory.getPlaceManager().getRequestParameter("folderId");
												final String o1 = AppClientFactory.getPlaceManager().getRequestParameter(O1_LEVEL);
												final String o2 = AppClientFactory.getPlaceManager().getRequestParameter(O2_LEVEL);
												final String o3 = AppClientFactory.getPlaceManager().getRequestParameter(O3_LEVEL);
												getUiHandlers().saveCollection(folderId, o1, o2, o3);
											}
										}
										@Override
										public void onFailure(Throwable caught) {
											
										}
									});
								}
							}
							@Override
							public void onFailure(Throwable caught) {
							}
						});
					}
				}else{
					//Creating new assessment
					String assessmentTitle=txtNewAssessmentTitle.getText();
					if(assessmentTitle.isEmpty()){
						lblNewAssessmentError.setVisible(true);
						lblNewAssessmentError.setText(i18n.GL1026());
					}else{
						Map<String, String> parms = new HashMap<String, String>();
						parms.put("text", assessmentTitle);
						AppClientFactory.getInjector().getResourceService().checkProfanity(parms,new AsyncCallback<Boolean>() {
							@Override
							public void onSuccess(Boolean value) {
								if(value){
									//Displaying error message
									SetStyleForProfanity.SetStyleForProfanityForTextBoxWithPlaceholder(txtNewAssessmentTitle, lblNewAssessmentError, value);
								}else{
									lblNewAssessmentError.setVisible(false);
									lblNewAssessmentError.setText("");
									String folderId = AppClientFactory.getPlaceManager().getRequestParameter("folderId");
									final String o1 = AppClientFactory.getPlaceManager().getRequestParameter(O1_LEVEL);
									final String o2 = AppClientFactory.getPlaceManager().getRequestParameter(O2_LEVEL);
									final String o3 = AppClientFactory.getPlaceManager().getRequestParameter(O3_LEVEL);
									getUiHandlers().saveCollection(folderId, o1, o2, o3);
								}
							}
							@Override
							public void onFailure(Throwable caught) {
							}
						});
					}
				}
			}
		});
		//This will handle the focus on new assessment.
		txtNewAssessmentTitle.addFocusHandler(new FocusHandler() {
			@Override
			public void onFocus(FocusEvent event) {
				if(lblNewAssessmentError.isVisible()){
					lblNewAssessmentError.setVisible(false);
					txtNewAssessmentTitle.getElement().removeAttribute("style");
				}
			}
		});
		//This will handle the focus on existing assessment title.
		txtExistingAssessmentTitle.addFocusHandler(new FocusHandler() {
			@Override
			public void onFocus(FocusEvent event) {
				if(lblExistingAssessmentError.isVisible()){
					lblExistingAssessmentError.setVisible(false);
					txtExistingAssessmentTitle.getElement().removeAttribute("style");
				}
			}
		});
		//This will handle the focus on existing assessment URL.
		txtExistingAssessmentURL.addFocusHandler(new FocusHandler() {
			@Override
			public void onFocus(FocusEvent event) {
				if(lblExistingAssessmentURLError.isVisible()){
					lblExistingAssessmentURLError.setVisible(false);
					txtExistingAssessmentURL.getElement().removeAttribute("style");
				}
			}
		});
		setTextAndIds();
		pnlNewAssessmentContainer.setVisible(false);
		pnlExistingAssessmentContainer.setVisible(false);
		resetAssessmentFields();
	}
	
	public void setTextAndIds(){
		collectionTitleTxtBox.setPlaceholder(i18n.GL0319());
		txtNewAssessmentTitle.setPlaceholder(i18n.GL3122());
		txtExistingAssessmentTitle.setPlaceholder(i18n.GL3123());
		txtExistingAssessmentURL.setPlaceholder(i18n.GL3124());
		
		mandatoryErrorLbl.setText(i18n.GL0173());
		mandatoryErrorLbl.getElement().setId("lblMandatoryErrorLbl");
		mandatoryErrorLbl.getElement().setAttribute("alt",i18n.GL0173());
		mandatoryErrorLbl.getElement().setAttribute("title",i18n.GL0173());
		  
		lblVisibility.setText(i18n.GL0328());
		lblVisibility.getElement().setId("lblVisibility");
		lblVisibility.getElement().setAttribute("alt",i18n.GL0328());
		lblVisibility.getElement().setAttribute("title",i18n.GL0328());
		
		lblPublic.setText(i18n.GL0329());
		lblPublic.getElement().setId("lblPublic");
		lblPublic.getElement().setAttribute("alt",i18n.GL0329());
		lblPublic.getElement().setAttribute("title",i18n.GL0329());
		
		lblAllow.setText(i18n.GL0330());
		lblAllow.getElement().setId("lblAllow");
		lblAllow.getElement().setAttribute("alt",i18n.GL0330());
		lblAllow.getElement().setAttribute("title",i18n.GL0330());
		
		lblShareable.setText(i18n.GL0331());
		lblShareable.getElement().setId("lblShareable");
		lblShareable.getElement().setAttribute("alt",i18n.GL0331());
		lblShareable.getElement().setAttribute("title",i18n.GL0331());
		
		lblShareableDesc.setText(i18n.GL0332());
		lblShareableDesc.getElement().setId("lblShareableDesc");
		lblShareableDesc.getElement().setAttribute("alt",i18n.GL0332());
		lblShareableDesc.getElement().setAttribute("title",i18n.GL0332());
		
		lblPrivate.setText(i18n.GL0333());
		lblPrivate.getElement().setId("lblPrivate");
		lblPrivate.getElement().setAttribute("alt",i18n.GL0333());
		lblPrivate.getElement().setAttribute("title",i18n.GL0333());
		
		lblPrivateDesc.setText(i18n.GL0334());
		lblPrivateDesc.getElement().setId("lblPrivateDesc");
		lblPrivateDesc.getElement().setAttribute("alt",i18n.GL0334());
		lblPrivateDesc.getElement().setAttribute("title",i18n.GL0334());
		
		gradeLbl.setText(i18n.GL0325()+i18n.GL_SPL_SEMICOLON()+" ");
		gradeLbl.getElement().setId("lblGradeLbl");
		gradeLbl.getElement().setAttribute("alt",i18n.GL0325());
		gradeLbl.getElement().setAttribute("title",i18n.GL0325());
		
		courseLbl.setText(i18n.GL0326()+i18n.GL_SPL_SEMICOLON()+" ");
		courseLbl.getElement().setId("lblCourseLbl");
		courseLbl.getElement().setAttribute("alt",i18n.GL0326());
		courseLbl.getElement().setAttribute("title",i18n.GL0326());
		
		btnCancelAssessment.setText(i18n.GL0142());
		btnCancelAssessment.getElement().setAttribute("alt",i18n.GL0142());
		btnCancelAssessment.getElement().setAttribute("title",i18n.GL0142());
		
		btnOk.getElement().setId("btnOk");
		cancelAnr.getElement().setId("lnkCancel");
		/*btnOk.setText(i18n.GL0636);
		cancelAnr.setText(MessageProperties.i18n.GL0142);*/
		shelfItemContent.getElement().setId("pnlShelfItemContent");
		collPopUpMainheading.getElement().setId("lblCollPopUpMainheading");
		collPopUpSubheading.getElement().setId("lblCollPopUpSubheading");
		collTitleLbl.getElement().setId("lblCollTitleLbl");
		gradeContainer.getElement().setId("pnlGradeContainer");
		collectionGradeTxtBox.getElement().setId("spnlCollectionGradeTxtBox");
		courseContainer.getElement().setId("pnlCourseContainer");
		groupSimPanel.getElement().setId("spnlGroupSimPanel");
		buttonFloPanel.getElement().setId("fpnlButtonFloPanel");
		visibilitySection.getElement().setId("pnlVisibilitySection");
		publicShareFloPanel.getElement().setId("epnlPublicShareFloPanel");
		publicRadioButtonPanel.getElement().setId("pnlPublicRadioButtonPanel");
		publicLbl.getElement().setId("lblPublicLbl");
		linkShareFloPanel.getElement().setId("fpnlLinkShareFloPanel");
		shareRadioButtonPanel.getElement().setId("pnlShareRadioButtonPanel");
		privateShareFloPanel.getElement().setId("fpnlPrivateShareFloPanel");
		privateRadioButtonPanel.getElement().setId("pnlPrivateRadioButtonPanel");
		buttonMainContainer.getElement().setId("pnlButtonMainContainer");
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
				mandatoryErrorLbl.setText(i18n.GL0143());
				mandatoryErrorLbl.getElement().setAttribute("alt",i18n.GL0143());
				mandatoryErrorLbl.getElement().setAttribute("title",i18n.GL0143());
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
		String collectionType=AppClientFactory.getPlaceManager().getRequestParameter("type", null);
	
		CollectionDo collection = new CollectionDo();
		if (this.collectionDo != null) {
			collection.setGooruOid(this.collectionDo.getGooruOid());
		}
		if(collectionType!=null&&collectionType.equalsIgnoreCase("assessment")){
			if(isAssessmentEditClicked){
				collection.setTitle(txtExistingAssessmentTitle.getText());
				collection.setUrl(txtExistingAssessmentURL.getText());
				collection.setCollectionType("assessment/url");
			}else{
				collection.setCollectionType("assessment");
				collection.setTitle(txtNewAssessmentTitle.getText());
			}
		}else{
			collection.setCollectionType("collection");
			collection.setTitle(collectionTitleTxtBox.getText());
		}
	
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
		bodyContainer.setVisible(true);
		pnlCreateNewAssessment.setVisible(false);
		if(AppClientFactory.getPlaceManager().getRequestParameter(REQ_COLLECTION_TITLE)!=null&&!AppClientFactory.getPlaceManager().getRequestParameter(REQ_COLLECTION_TITLE).equalsIgnoreCase("")){
			collPopUpMainheading.setText(i18n.GL1421());
			collPopUpMainheading.getElement().setAttribute("alt",i18n.GL1421());
			collPopUpMainheading.getElement().setAttribute("title",i18n.GL1421());
			collPopUpSubheading.setText(i18n.GL1365());
			collPopUpSubheading.getElement().setAttribute("alt",i18n.GL1365());
			collPopUpSubheading.getElement().setAttribute("title",i18n.GL1365());
			collTitleLbl.setText(i18n.GL0553());
			collTitleLbl.getElement().setAttribute("alt",i18n.GL0553());
			collTitleLbl.getElement().setAttribute("title",i18n.GL0553());
			collectionTitleTxtBox.setText(AppClientFactory.getPlaceManager().getRequestParameter(REQ_COLLECTION_TITLE));
			collectionTitleTxtBox.getElement().setAttribute("alt",AppClientFactory.getPlaceManager().getRequestParameter(REQ_COLLECTION_TITLE));
			collectionTitleTxtBox.getElement().setAttribute("title",AppClientFactory.getPlaceManager().getRequestParameter(REQ_COLLECTION_TITLE));
			btnOk.setText(i18n.GL0590());
			btnOk.getElement().setAttribute("alt",i18n.GL0590());
			btnOk.getElement().setAttribute("title",i18n.GL0590());
			cancelAnr.setText(i18n.GL0142());
			cancelAnr.getElement().setAttribute("alt",i18n.GL0142());
			cancelAnr.getElement().setAttribute("title",i18n.GL0142());
			appPopUp.setViewTitle(i18n.GL1421());
			setPopUpStyle();
		}else if(AppClientFactory.getPlaceManager().getRequestParameter(DRAGGED_COLLECTION_TITLE)!=null&&!AppClientFactory.getPlaceManager().getRequestParameter(DRAGGED_COLLECTION_TITLE).equalsIgnoreCase("")){
			collPopUpMainheading.setText(i18n.GL1421());
			collPopUpMainheading.getElement().setAttribute("alt",i18n.GL1421());
			collPopUpMainheading.getElement().setAttribute("title",i18n.GL1421());
			collPopUpSubheading.setText(i18n.GL1365());
			collPopUpSubheading.getElement().setAttribute("alt",i18n.GL1365());
			collPopUpSubheading.getElement().setAttribute("title",i18n.GL1365());
			collTitleLbl.setText(i18n.GL0553());
			collTitleLbl.getElement().setAttribute("alt",i18n.GL0553());
			collTitleLbl.getElement().setAttribute("title",i18n.GL0553());
			collectionTitleTxtBox.setText(AppClientFactory.getPlaceManager().getRequestParameter(DRAGGED_COLLECTION_TITLE));
			collectionTitleTxtBox.getElement().setAttribute("alt",AppClientFactory.getPlaceManager().getRequestParameter(DRAGGED_COLLECTION_TITLE));
			collectionTitleTxtBox.getElement().setAttribute("title",AppClientFactory.getPlaceManager().getRequestParameter(DRAGGED_COLLECTION_TITLE));
			btnOk.setText(i18n.GL0636());
			btnOk.getElement().setAttribute("alt",i18n.GL0636());
			btnOk.getElement().setAttribute("title",i18n.GL0636());
			cancelAnr.setText(i18n.GL0142());
			cancelAnr.getElement().setAttribute("alt",i18n.GL0142());
			cancelAnr.getElement().setAttribute("title",i18n.GL0142());
			appPopUp.setViewTitle(i18n.GL1421());
			setPopUpStyle();
		}else{
			String collectionType=AppClientFactory.getPlaceManager().getRequestParameter("type",null);
		if(collectionType!=null&&collectionType.equals("assessment")){
			pnlCreateNewAssessment.setVisible(true);
			bodyContainer.setVisible(false);
			collPopUpMainheading.setVisible(false);
			collPopUpSubheading.setVisible(false);
			pnlNewAssessmentContainer.setVisible(false);
			pnlExistingAssessmentContainer.setVisible(false);
			resetAssessmentFields();
			appPopUp.setViewTitle(i18n.GL3008());
			shelfItemContent.getElement().removeAttribute("style");	
			
		   /*collectionTitleTxtBox.setPlaceholder(i18n.GL3010());
			collPopUpMainheading.setText(i18n.GL3009());
			collPopUpMainheading.getElement().setAttribute("alt",i18n.GL3009());
			collPopUpMainheading.getElement().setAttribute("title",i18n.GL3009());
			collPopUpSubheading.setText(i18n.GL1033());
			collPopUpSubheading.getElement().setAttribute("alt",i18n.GL1033());
			collPopUpSubheading.getElement().setAttribute("title",i18n.GL1033());
			collTitleLbl.setText(i18n.GL3009()+i18n.GL_SPL_SEMICOLON()+" ");
			collTitleLbl.getElement().setAttribute("alt",i18n.GL3009());
			collTitleLbl.getElement().setAttribute("title",i18n.GL3009());
			btnOk.setText(i18n.GL0141());
			btnOk.getElement().setAttribute("alt",i18n.GL0141());
			btnOk.getElement().setAttribute("title",i18n.GL0141());
			cancelAnr.setText(i18n.GL0142());
			cancelAnr.getElement().setAttribute("alt",i18n.GL0142());
			cancelAnr.getElement().setAttribute("title",i18n.GL0142());*/
		}else if(AppClientFactory.getPlaceManager().getPreviousRequest().getNameToken().equals(PlaceTokens.SHELF) || AppClientFactory.getPlaceManager().getPreviousRequest().getNameToken().equals(PlaceTokens.DISCOVER)){
				collPopUpMainheading.setText(i18n.GL0993());
				collPopUpMainheading.getElement().setAttribute("alt",i18n.GL0993());
				collPopUpMainheading.getElement().setAttribute("title",i18n.GL0993());
				collPopUpSubheading.setText(i18n.GL1033());
				collPopUpSubheading.getElement().setAttribute("alt",i18n.GL1033());
				collPopUpSubheading.getElement().setAttribute("title",i18n.GL1033());
				collTitleLbl.setText(i18n.GL0993()+i18n.GL_SPL_SEMICOLON()+" ");
				collTitleLbl.getElement().setAttribute("alt",i18n.GL0993());
				collTitleLbl.getElement().setAttribute("title",i18n.GL0993());
				btnOk.setText(i18n.GL0141());
				btnOk.getElement().setAttribute("alt",i18n.GL0141());
				btnOk.getElement().setAttribute("title",i18n.GL0141());
				cancelAnr.setText(i18n.GL0142());
				cancelAnr.getElement().setAttribute("alt",i18n.GL0142());
				cancelAnr.getElement().setAttribute("title",i18n.GL0142());
				appPopUp.setViewTitle(i18n.GL0322());
			}else{
				collPopUpMainheading.setText(i18n.GL0993());
				collPopUpMainheading.getElement().setAttribute("alt",i18n.GL0993());
				collPopUpMainheading.getElement().setAttribute("title",i18n.GL0993());
				collPopUpSubheading.setText(i18n.GL1033());
				collPopUpSubheading.getElement().setAttribute("alt",i18n.GL1033());
				collPopUpSubheading.getElement().setAttribute("title",i18n.GL1033());
				collTitleLbl.setText(i18n.GL0651());
				collTitleLbl.getElement().setAttribute("alt",i18n.GL0651());
				collTitleLbl.getElement().setAttribute("title",i18n.GL0651());
				btnOk.setText(i18n.GL0636());
				btnOk.getElement().setAttribute("alt",i18n.GL0636());
				btnOk.getElement().setAttribute("title",i18n.GL0636());
				cancelAnr.setText(i18n.GL0142());
				cancelAnr.getElement().setAttribute("alt",i18n.GL0142());
				cancelAnr.getElement().setAttribute("title",i18n.GL0142());
				appPopUp.setViewTitle(i18n.GL0322());
			}
			
		}
		
		if(AppClientFactory.getPlaceManager().getRequestParameter("resourceId")!=null&&!AppClientFactory.getPlaceManager().getRequestParameter("resourceId").equalsIgnoreCase("")){
			appPopUp.setViewTitle(i18n.GL0322());
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
			radioButtonPublic.setChecked(false);
			radioButtonShare.setChecked(true);
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
		appPopUp.getElement().getStyle().setHeight(320, Unit.PX);
		shelfItemContent.getElement().setAttribute("style", "min-height: 316px");	
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
			mandatoryErrorLbl.setText(i18n.GL0323());
			mandatoryErrorLbl.getElement().setAttribute("alt",i18n.GL0323());
			mandatoryErrorLbl.getElement().setAttribute("title",i18n.GL0323());
			mandatoryErrorLbl.setVisible(true);
			errorList.put("title", i18n.GL0323().toLowerCase());
		} else if (tiltle.trim().equals("")
				|| tiltle.equalsIgnoreCase(i18n.GL0319())) {
			errorList.put("title", i18n.GL0324());
			mandatoryErrorLbl.setText(i18n.GL0173());
			mandatoryErrorLbl.getElement().setAttribute("alt",i18n.GL0173());
			mandatoryErrorLbl.getElement().setAttribute("title",i18n.GL0173());
			mandatoryErrorLbl.setVisible(true);
			/*mandatoryErrorLbl.getElement().getStyle().setMarginRight(62,Unit.PX);*/
		}else if (isHavingBadWords){
			errorList.put("title", i18n.GL0554());
			mandatoryErrorLbl.setText(i18n.GL0554());
			mandatoryErrorLbl.getElement().setAttribute("alt",i18n.GL0554());
			mandatoryErrorLbl.getElement().setAttribute("title",i18n.GL0554());
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
		if(!AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.DISCOVER)){
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
		AppClientFactory.getInjector().getUserService().getV2UserProfileDetails(GOORU_UID, new SimpleAsyncCallback<V2UserDo>() {

			@Override
			public void onSuccess(V2UserDo result) {
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
		});

	}

	@Override
	public void setStaticData(String collectionType) {
		
	}

	@Override
	public void resetAssessmentFields() {
		btnExistingAssessment.removeStyleName(CollectionCBundle.INSTANCE.css().selecteAssessment());
		btnExistingAssessment.addStyleName(CollectionCBundle.INSTANCE.css().deselecteAssessment());
		btnNewAssessment.removeStyleName(CollectionCBundle.INSTANCE.css().selecteAssessment());
		btnNewAssessment.addStyleName(CollectionCBundle.INSTANCE.css().deselecteAssessment());
		btnCreateAssessment.setVisible(false);
		btnCancelAssessment.setVisible(false);
		txtNewAssessmentTitle.setText("");
		txtExistingAssessmentTitle.setText("");
		txtExistingAssessmentURL.setText("");
		lblNewAssessmentError.setVisible(false);
		lblExistingAssessmentError.setVisible(false);
		lblExistingAssessmentURLError.setVisible(false);
	}
}
