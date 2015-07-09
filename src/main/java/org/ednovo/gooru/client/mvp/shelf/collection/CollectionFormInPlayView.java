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

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.code.CodeDo;
import org.ednovo.gooru.application.shared.model.code.LibraryCodeDo;
import org.ednovo.gooru.application.shared.model.content.CollectionDo;
import org.ednovo.gooru.application.shared.model.user.V2UserDo;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.client.uc.BrowserAgent;
import org.ednovo.gooru.client.uc.TextBoxWithPlaceholder;
import org.ednovo.gooru.client.uc.tooltip.GlobalToolTip;
import org.ednovo.gooru.client.uc.tooltip.ToolTip;
import org.ednovo.gooru.client.ui.HTMLEventPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
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
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
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
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;
import com.tractionsoftware.gwt.user.client.ui.GroupedListBox;

/**
 * @author Search Team
 *
 */
public class CollectionFormInPlayView extends PopupViewWithUiHandlers<CollectionFormInPlayUiHandlers> implements IsCollectionFormInPlayView {
	@UiField
	TextBoxWithPlaceholder collectionTitleTxtBox;
	GroupedListBox courseLisBox;

	@UiField
	SimplePanel groupSimPanel,collectionGradeTxtBox;

	@UiField
	FlowPanel buttonFloPanel;
	@UiField
	Button cancelAnr;


	@UiField
	Button btnOk;

	@UiField
	Label mandatoryErrorLbl, lblVisibility,lblPublic,lblAllow,lblShareable,lblShareableDesc,lblPrivate, lblPrivateDesc;

	@UiField
	Label loadingTextLbl,collPopUpMainheading,collPopUpSubheading,collTitleLbl,gradeLbl,courseLbl;


	@UiField
	HTMLEventPanel publicShareFloPanel;

	@UiField HTMLPanel  pnlExistingAssessmentContainer,pnlNewAssessmentContainer,pnlCreateNewAssessment,bodyContainer,shelfItemContent,publicRadioButtonPanel,shareRadioButtonPanel,privateRadioButtonPanel,buttonMainContainer;

	RadioButton radioButtonPublic=new RadioButton("","");
	RadioButton radioButtonShare=new RadioButton("","");
	RadioButton radioButtonPrivate=new RadioButton("","");

	final String[] list = { "- Select Grade -","Kindergarten", "1", "2", "3", "4", "5", "6", "7",
			"8", "9", "10", "11", "12", "Higher Education" };

	ListBox gradeDropDownList = new ListBox();

	private AppPopUp appPopUp;

	ToolTip toolTip;

	private boolean isCheckedValue;

	private CollectionDo collectionDo;

	private PopupPanel toolTipPopupPanel=new PopupPanel();

	private static final String GOORU_UID = "gooruuid";

	private static CollectionFormViewUiBinder uiBinder = GWT.create(CollectionFormViewUiBinder.class);

	static MessageProperties i18n = GWT.create(MessageProperties.class);

	private static final String TITLE_THIS_COLLECTION = i18n.GL0322();

	private static String CONFIRM_MESSAGE = i18n.GL1490()+i18n.GL_SPL_EXCLAMATION();

	boolean isHavingBadWords;

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
		appPopUp = new AppPopUp();
		if (!BrowserAgent.isDevice()){
			appPopUp.getMainPanel().getElement().getStyle().setWidth(550, Unit.PX);
		}
		appPopUp.setContent(TITLE_THIS_COLLECTION, uiBinder.createAndBindUi(this));
		appPopUp.setGlassStyleName(CollectionCBundle.INSTANCE.css().gwtGlassPanel());


		pnlCreateNewAssessment.setVisible(false);
		bodyContainer.setVisible(true);

		appPopUp.getElement().getStyle().setZIndex(99999);
		CollectionCBundle.INSTANCE.css().ensureInjected();
		mandatoryErrorLbl.setVisible(false);
		publicShareFloPanel.setVisible(false);
		appPopUp.getElement().getStyle().setWidth(521, Unit.PX);
		appPopUp.getElement().getStyle().setHeight(320, Unit.PX);
		collectionTitleTxtBox.getElement().setAttribute("maxlength", "50");
		radioButtonPublic.getElement().setId("rdPublic");
		radioButtonShare.getElement().setId("rdShare");
		radioButtonPrivate.getElement().setId("rdPrivate");
		collectionTitleTxtBox.getElement().setId("txtCollectionTitle");
		isCheckedValue=false;
		appPopUp.setTitle(i18n.GL0993());
		buttonFloPanel.setVisible(false);
		btnOk.getElement().setAttribute("style", "margin-left:10px");
		loadingTextLbl.setText(i18n.GL0591().toLowerCase());
		loadingTextLbl.getElement().setId("lblLoadingTextLbl");
		loadingTextLbl.getElement().setAttribute("alt",i18n.GL0591().toLowerCase());
		loadingTextLbl.getElement().setAttribute("title",i18n.GL0591().toLowerCase());
		cancelAnr.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				reset();
				hide();
				Window.enableScrolling(true);
			}
		});
		setAutoHideOnNavigationEventEnabled(true);
		collectionTitleTxtBox.addBlurHandler(new BlurHandler() {

			@Override
			public void onBlur(BlurEvent event) {

				if (collectionTitleTxtBox.getText().length() > 0){
					Map<String, String> parms = new HashMap<String, String>();
					parms.put("text", collectionTitleTxtBox.getText());
					AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {

						@Override
						public void onSuccess(Boolean value) {

							isHavingBadWords = value;

							if (value){
								collectionTitleTxtBox.getElement().getStyle().setBorderColor("orange");
								mandatoryErrorLbl.setText(i18n.GL0554());
								mandatoryErrorLbl.setVisible(true);
							}else{
								btnOk.setEnabled(true);
								btnOk.getElement().removeClassName("disabled");
								collectionTitleTxtBox.getElement().getStyle().clearBackgroundColor();
								collectionTitleTxtBox.getElement().getStyle().setBorderColor("#ccc");
								mandatoryErrorLbl.setVisible(false);
							}
						}
					});
				}
			}
		});

		collectionTitleTxtBox.addKeyUpHandler(new TitleKeyUpHandler());
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
						if (value){
							collectionTitleTxtBox.getElement().getStyle().setBorderColor("orange");
							mandatoryErrorLbl.setText(i18n.GL0554());
							mandatoryErrorLbl.setVisible(true);
							btnOk.setEnabled(true);
							btnOk.getElement().removeClassName("disabled");
						}else{
							collectionTitleTxtBox.getElement().getStyle().clearBackgroundColor();
							collectionTitleTxtBox.getElement().getStyle().setBorderColor("#ccc");
							mandatoryErrorLbl.setVisible(false);

							if (validateCollectionForm().size() == 0) {
								loadingTextLbl.getElement().getStyle().setDisplay(Display.BLOCK);

								btnOk.setEnabled(false);
								btnOk.getElement().addClassName("disabled");
								buttonMainContainer.setVisible(false);
								getUiHandlers().saveCollection();
							}
						}
					}
				});
			}
		});
		getGradeList();
		publicRadioButtonPanel.add(radioButtonPublic);
		shareRadioButtonPanel.add(radioButtonShare);
		privateRadioButtonPanel.add(radioButtonPrivate);

		if(AppClientFactory.getLoggedInUser() != null && AppClientFactory.getLoggedInUser().getConfirmStatus()==1){
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

	public void setTextAndIds(){
		collectionTitleTxtBox.getElement().setAttribute("placeholder", i18n.GL0319());
		mandatoryErrorLbl.setText(i18n.GL0173());
		collPopUpMainheading.setText(i18n.GL1032());
		collPopUpSubheading.setText(i18n.GL1033());
		collTitleLbl.setText(i18n.GL0651());
		lblVisibility.setText(i18n.GL0328());
		lblPublic.setText(i18n.GL0329());
		if(collectionDo != null && collectionDo.getCollectionType()!=null && collectionDo.getCollectionType().equalsIgnoreCase("assessment"))
		{
			lblAllow.setText(i18n.GL3175());
		}
		else
		{
			lblAllow.setText(i18n.GL0330());
		}
		lblShareable.setText(i18n.GL0331());
		lblShareableDesc.setText(i18n.GL0332());
		lblPrivate.setText(i18n.GL0333());
		if(collectionDo != null && collectionDo.getCollectionType()!=null && collectionDo.getCollectionType().equalsIgnoreCase("assessment"))
		{
			lblPrivateDesc.setText(i18n.GL3176());
		}
		else
		{
			lblPrivateDesc.setText(i18n.GL0334());
		}

		btnOk.setText(i18n.GL0190());
		btnOk.getElement().setId("btnOk");
		gradeLbl.setText(i18n.GL0325());
		courseLbl.setText(i18n.GL0326());
		cancelAnr.getElement().setId("lnkCancel");
		cancelAnr.setText(i18n.GL0142());
	}


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



	private class TitleKeyUpHandler implements KeyUpHandler {

		public void onKeyUp(KeyUpEvent event) {
			mandatoryErrorLbl.setVisible(false);
			if (collectionTitleTxtBox.getText().length() >= 50) {
				mandatoryErrorLbl.setText(i18n.GL0143());
				mandatoryErrorLbl.setVisible(true);
			}
		}
	}

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


	@Override
	public Widget asWidget() {
		collectionTitleTxtBox.setFocus(true);
		return appPopUp;
	}

	@Override
	public void reset() {
		btnOk.setEnabled(true);
		btnOk.getElement().removeClassName("disabled");
		collectionDo = null;
		buttonMainContainer.setVisible(true);
		loadingTextLbl.setVisible(false);
		collectionTitleTxtBox.setText("");
		mandatoryErrorLbl.setVisible(false);
		courseLisBox = new GroupedListBox();
		courseLisBox.setStyleName(CollectionCBundle.INSTANCE.css().createCollContentAlignInputs());
		groupSimPanel.setWidget(courseLisBox);
		gradeDropDownList.setSelectedIndex(0);
		if(AppClientFactory.getLoggedInUser() != null && AppClientFactory.getLoggedInUser().getConfirmStatus()==0){
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



	@Override
	public CollectionDo setData(CollectionDo collection) {
		this.collectionDo = collection;
		collectionTitleTxtBox.setText(collection.getTitle());
		setCourseData();
		return collection;
	}

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

	@Override
	public void setLibraryCodes(List<LibraryCodeDo> libraryCode) {
		courseLisBox.addItem("- Select Course -", "-1");
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
			mandatoryErrorLbl.setText(i18n.GL0323());
			mandatoryErrorLbl.setVisible(true);
			errorList.put("title", "title cannot be a url.");
		}else if (tiltle.trim().equals("") || tiltle.equalsIgnoreCase("Untitled Collection")) {
			errorList.put("title", "title can not be empty");
			mandatoryErrorLbl.setText(i18n.GL0746());
			mandatoryErrorLbl.setVisible(true);
		}
		return errorList;
	}

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

	public void getAccountTypeId()
	{
	AppClientFactory
				.getInjector().getUserService().getV2UserProfileDetails(GOORU_UID, new SimpleAsyncCallback<V2UserDo>() {

					@Override
					public void onSuccess(V2UserDo result) {
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
				});

	}
	@Override
	public void onLoad() {
		getUiHandlers().getCourse();
	}

	@Override
	public void onUnload() {
	}
}
