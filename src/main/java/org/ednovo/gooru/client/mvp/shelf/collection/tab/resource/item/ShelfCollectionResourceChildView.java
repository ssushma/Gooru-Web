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
package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.child.ChildView;
import org.ednovo.gooru.client.effects.BackgroundColorEffect;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.addTagesPopup.AddTagesPopupView;
import org.ednovo.gooru.client.mvp.dnd.IsDraggableMirage;
import org.ednovo.gooru.client.mvp.resource.dnd.ResourceDragUc;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.vc.SuccessPopupViewVc;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.IsCollectionResourceTabView;
import org.ednovo.gooru.client.mvp.shelf.event.InsertCollectionItemInAddResourceEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshCollectionItemInShelfListEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshType;
import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.client.uc.ConfirmationPopupVc;
import org.ednovo.gooru.client.uc.ResourceImageUc;
import org.ednovo.gooru.client.uc.tooltip.ToolTip;
import org.ednovo.gooru.client.util.ImageUtil;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.content.AssetsDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.ThumbnailDo;
import org.ednovo.gooru.shared.model.folder.FolderListDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.ResourceImageUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Widget;


/**
 * @author Search Team
 * 
 */
public class ShelfCollectionResourceChildView extends
		ChildView<ShelfCollectionResourceChildPresenter> implements
		IsShelfCollectionResourceView, MessageProperties {

	@UiField
	HTML resourceNarrationHtml;
	
	@UiField HTMLPanel resourceTitle1,resourceTitleContainer,minsText,secondsText,endMinsText,endSecondsText;

	@UiField
	Label  confirmDeleteLbl, fromLbl,updatePDFLabelText,startStopTimeDisplayText,editSartPageText,StartPageLbl;
	
	@UiField
	HTML resourceTitleLbl;

	@UiField
	ResourceImageUc resourceImageUc;

	/*@UiField
	VerticalPanel actionVerPanel;
*/
	@UiField
	Button EditBtn,updateNarrationBtn,cancelNarrationBtn,updateVideoTimeBtn,cancelVideoTimeBtn,updatePdfBtn,cancelpdfBtn;

	@UiField
	FlowPanel editFloPanel, editFieldsFloPanel,actionVerPanel,actionVerPanelForUpdateTime;

	@UiField
	TextBox fromTxt, toTxt,EndTimeTxt1,EndTimeTxt2,startpdfPageNumber;

	@UiField
	TextArea narrationTxtArea;
	
	/*@UiField
	TinyMCE narrationTxtArea;*/

	@UiField
	FlowPanel narationFloPanel,resourceFlowPanel,ResourceEditButtonContainer,videoDisplay,narrationConatainer,videoImage,editPdfFlowPanel,actionVerPanelForUpdatePDF;

	@UiField
	Label pencilEditNarationLbl,updateResourceBtn,addTages;

	@UiField
	Label narrationAlertMessageLbl,videoTimeField,fromLblDisplayText,ToLbl,UpdateTextMessage,editStartPageLbl,editVideoTimeLbl;

	@UiField Image imgNotFriendly;
	
	ToolTip toolTip = null;
	
	@UiField(provided = true)
	CollectionEditResourceCBundle res;

//	IsCollectionResourceTabView isCollResourceTabView = null;

	private CollectionItemDo collectionItemDo;

	List<Integer> collectionItems;
	
	Map<String, Integer> collectionListCount = new HashMap<String, Integer>();
	
	private int totalSize;
	
	private Integer pageNumber=1;
	
	private Integer pageSize=20;
	
	//private static final String REG_EXP = "^(?:[01]\\d|2[0-3]):(?:[0-9]\\d):(?:[0-5]\\d)$";
	
	private static final String REG_EXP = "^(?:[01]\\d|2[0-3]):(?:[0-9]{0,6}):(?:[0-5]\\d)$";

	private static final String START_STOP_MINUTE = "00";
	private static final String START_STOP_SEC = "00";

	private int totalVideoLength;
	String narrationData;
	int narrationDataLength;
	@UiField
	Label copyResource, editInfoLbl;
	AddTagesPopupView popup;
	public Label getEditInfoLbl() {
		return editInfoLbl;
	}
	public Button getEditButton() {
		return EditBtn;
	}
	public FlowPanel getResourceEditButtonContainer()
	{
		return ResourceEditButtonContainer;
	}
	public void setEditInfoLbl(Label editInfoLbl) {
		this.editInfoLbl = editInfoLbl;
	}
	/*public void setResourceEditButtonContainer(FlowPanel ResourceEditButtonContainer)
	{
		this.ResourceEditButtonContainer=ResourceEditButtonContainer;
	}*/
	private static final String NO_NARRATION_ADDED =GL0956;

	private static final String ADD_NARRATION_FOR_YOUR_VIEWERS =GL0967;

	private ConfirmationPopupVc deleteConfirmationPopupVc;

	private CopyConfirmPopupVc copyConfirmPopupVc;

	private EditQuestionPopupVc editQuestionPopupVc;

	private IsCollectionResourceTabView collectionResourceTabView;

	private static ShelfCollectionResourceChildView previousCollectionResourceChildView;

	private static final String MESSAGE_CONTENT =GL0968;

	private static final String MESSAGE_HEADER =GL0748;

	private static final String PLAYER_NAME =GL0969;

	private static final String VALID_START_STOP_TIME = GL0970;

	private static final String YOUTUBE_START_END_TIME = GL0971;

	private static final String FROM_START_TIME =GL0972;
	private static final String FROM_STOP_TIME = GL0973;
//	private static final String FROM_START_PAGE = "Start page";
	private static final String VIDEO_TIME =GL0974;
	//private static final String START_TIME=GL0972+GL_SPL_SEMICOLON;
	
	private static final String START_PAGE=GL0961;
	private static boolean isConfirmationPopup;
	private static final String START_MINUTE="00";
	private static final String START_SEC="00";
	private static final String END_MINUTE="00";
	private static final String END_SEC="00";
	
	private static final String DEFAULT_START_PAGE="1";

	private static boolean isEdited = false;

	private static final String OOPS = GL0061;

	private static final String EDIT_CONFIRM =GL0975;

	private String selectedCollectionId;
	private boolean youtube;

	String mediaType = "";
	boolean setVisibility = false;
	
	boolean isHavingBadWords=false;
	
	private static ShelfCollectionResourceChildViewUiBinder uiBinder = GWT
			.create(ShelfCollectionResourceChildViewUiBinder.class);

	interface ShelfCollectionResourceChildViewUiBinder extends
			UiBinder<Widget, ShelfCollectionResourceChildView> {
	}

	public static void disableAllEditMode() {
		
		if (previousCollectionResourceChildView != null
				&& previousCollectionResourceChildView.isAttached()) {
			previousCollectionResourceChildView.setEditMode(false);
			previousCollectionResourceChildView = null;
		}
	}

	/**
	 * To alert user to save/update the content before moving to next action.
	 * 
	 * 
	 */
	public static void checkEditState() {

		if (isEdited) {
			if (previousCollectionResourceChildView != null	&& previousCollectionResourceChildView.isAttached()) {
				if (!isConfirmationPopup) {
					isConfirmationPopup = true;
					new ConfirmationPopupVc(OOPS, EDIT_CONFIRM) {

						@Override
						@UiHandler("okButton")
						public void onDelete(ClickEvent clickEvent) {
							hide();
							isConfirmationPopup = false;
							clickEvent.stopPropagation();
						}

						@Override
						@UiHandler("cancelButton")
						public void onCancelClick(ClickEvent clickEvent) {
							disableAllEditMode();
							hide();
							isEdited = false;
							isConfirmationPopup = false;
							clickEvent.stopPropagation();
						}
					};
				}
			}
		} else {
			disableAllEditMode();
		}
	}

	public boolean checkLoggedInUser() {
		boolean isValid = true;
		if (AppClientFactory.getLoggedInUser().getGooruUId().equalsIgnoreCase(
				collectionItemDo.getResource().getUser().getGooruUId())) {
			isValid = true;
		} else {
			isValid = false;
		}

		return isValid;
	}

	/**
	 * Class constructor
	 * 
	 * @param collectionResourceTabView
	 * @param collectionItem
	 *            instance of {@link CollectionItemDo}
	 */
	public ShelfCollectionResourceChildView(
			IsCollectionResourceTabView collectionResourceTabView,
			CollectionItemDo collectionItem) {
		this.collectionResourceTabView = collectionResourceTabView;
		res = CollectionEditResourceCBundle.INSTANCE;
		CollectionEditResourceCBundle.INSTANCE.css().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));
		this.collectionItemDo = collectionItem;
		
		editFloPanel.setVisible(false);
		imgNotFriendly.setUrl("images/mos/ipadFriendly.png");
		startStopTimeDisplayText.setText(GL0957);
		minsText.getElement().setInnerHTML(GL0958);
		secondsText.getElement().setInnerHTML(GL0959);
		endMinsText.getElement().setInnerHTML(GL0958);
		endSecondsText.getElement().setInnerHTML(GL0959);
		editSartPageText.setText(GL0960);
		StartPageLbl.setText(GL0961);
		EditBtn.setText(GL0140);
		updateResourceBtn.setText(GL0962);
		addTages.setText("Add Tags");
		editInfoLbl.setText(GL0963);
		editVideoTimeLbl.setText(GL0964);
		editStartPageLbl.setText(GL0960);
		copyResource.setText(GL0965);
		confirmDeleteLbl.setText(GL0237);
		UpdateTextMessage.setText(GL0966);
		updateNarrationBtn.setText(GL0240);
		cancelNarrationBtn.setText(GL0142);
		updateVideoTimeBtn.setText(GL0240);
		cancelVideoTimeBtn.setText(GL0142);
		updatePdfBtn.setText(GL0240);
		cancelpdfBtn.setText(GL0142);
		setData(collectionItem);
		
		onResourceNarrationOut();
		addDomHandler(new ActionPanelHover(), MouseOverEvent.getType());
		addDomHandler(new ActionPanelOut(), MouseOutEvent.getType());
		setPresenter(new ShelfCollectionResourceChildPresenter(this));
		//For 5.9 
		narrationAlertMessageLbl.setText(GL0143);
		actionVerPanel.setVisible(false);
		actionVerPanelForUpdateTime.setVisible(false);
		UpdateTextMessage.setVisible(false);
		ResourceEditButtonContainer.getElement().getStyle().setVisibility(Visibility.HIDDEN);
		EditBtn.setVisible(false);
		editPdfFlowPanel.setVisible(false);
		actionVerPanelForUpdatePDF.setVisible(false);
		fromTxt.setFocus(true);
		toTxt.setFocus(true);
		EndTimeTxt1.setFocus(true);
		EndTimeTxt2.setFocus(true);
		startpdfPageNumber.setFocus(true);
		fromTxt.getElement().setAttribute("maxlength", "4");
		toTxt.getElement().setAttribute("maxlength", "4");
		EndTimeTxt1.getElement().setAttribute("maxlength", "4");
		EndTimeTxt2.getElement().setAttribute("maxlength", "4");
		startpdfPageNumber.getElement().setAttribute("maxlength", "4");
		EditBtn.getElement().setId("btnEdit");
		updateResourceBtn.getElement().setId("lblUpdateResoure");
		addTages.getElement().setId("lblAddTages");
		copyResource.getElement().setId("lblCopyResource");
		editInfoLbl.getElement().setId("lblEditInfo");
		editStartPageLbl.getElement().setId("lblEditStartPage");
		confirmDeleteLbl.getElement().setId("lblConfirmDelete");
		updateNarrationBtn.getElement().setId("btnUpdateNarration");
		cancelNarrationBtn.getElement().setId("btnCancelNarration");
		updatePdfBtn.getElement().setId("btnUpdatePdf");
		cancelpdfBtn.getElement().setId("btnCancelPdf");
		editVideoTimeLbl.getElement().setId("lblEditVideoTime");
		updateVideoTimeBtn.getElement().setId("btnUpdateVideoTime");
		cancelVideoTimeBtn.getElement().setId("btnCancelVideoTime");
		fromTxt.addKeyPressHandler(new NumbersOnly());
		toTxt.addKeyPressHandler(new NumbersOnly());
		EndTimeTxt1.addKeyPressHandler(new NumbersOnly());
		EndTimeTxt2.addKeyPressHandler(new NumbersOnly());
		startpdfPageNumber.addKeyPressHandler(new NumbersOnly());
		// resourceNarrationHtml.addMouseOverHandler(new showNarationPencil());
		// resourceNarrationHtml.addMouseOutHandler(new hideNarationPencil());
		narrationTxtArea.getElement().setAttribute("maxlength", "600");
	//	narrationTxtArea.addKeyUpHandler(new narationValidation());
		fromTxt.addKeyUpHandler(new fromTxtKeyUpHandler());
		toTxt.addKeyUpHandler(new toTxtKeyUpHandler());
		editFieldsFloPanel.setVisible(false);
		// To check whether resource is public and is created by logged in user
		String resourceShare = collectionItemDo.getResource().getSharing();
		String resourceCategory = collectionItemDo.getResource().getCategory();

		if (resourceShare.equalsIgnoreCase("public")
				&& !resourceCategory.equalsIgnoreCase("question")) {
			editInfoLbl.setVisible(false);
		} else if (resourceShare.equalsIgnoreCase("public")
				&& resourceCategory.equalsIgnoreCase("question")
				&& checkLoggedInUser()) {
			editInfoLbl.setVisible(true);
		} else if (resourceShare.equalsIgnoreCase("private")
				&& !resourceCategory.equalsIgnoreCase("question")
				&& checkLoggedInUser()) {
			editInfoLbl.setVisible(true);
		} else if (!checkLoggedInUser()) {
			editInfoLbl.setVisible(false);
		}
		/*narrationTxtArea.addInitializeHandler(new InitializeHandler() {
			@Override
			public void onInitialize(InitializeEvent event) {
				    Document document = IFrameElement.as(narrationTxtArea.getElement()).getContentDocument();
	                BodyElement body = document.getBody();
	                body.setAttribute("style", "font-family: Arial;font-size:13px;color:#515151;line-height:1.2;margin:0px;");
			}
		});*/
		
/*		narrationTxtArea.addBlurHandler(new BlurHandler() {
			
			@Override
			public void onBlur(BlurEvent event) {
				updateNarrationBtn.setEnabled(false);
				updateNarrationBtn.getElement().addClassName("disabled");
				if (trim(narrationTxtArea.getHTML()).length() > 0){
				
					updateNarrationBtn.setEnabled(false);
					updateNarrationBtn.getElement().addClassName("disabled");
					
				}
			}
		});*/
		

		
		narrationTxtArea.addKeyPressHandler(new KeyPressHandler() {
			
			@Override
			public void onKeyPress(KeyPressEvent event) {
				narrationTxtArea.getElement().getStyle().clearBackgroundColor();
				narrationTxtArea.getElement().getStyle().setBorderColor("#ccc");
				if(narrationTxtArea.getText().toString().trim().length() >= 600){ 
					narrationAlertMessageLbl
                    .removeStyleName("titleAlertMessageDeActive");
					narrationAlertMessageLbl
                    .addStyleName("titleAlertMessageActive");
					updateNarrationBtn.setEnabled(false);
	                updateNarrationBtn.getElement().addClassName("disabled");
					event.preventDefault();
				}
				else
				{ 
					updateNarrationBtn.setEnabled(true);
	                updateNarrationBtn.getElement().removeClassName("disabled");
					narrationAlertMessageLbl
							.addStyleName("titleAlertMessageDeActive");
					narrationAlertMessageLbl
							.removeStyleName("titleAlertMessageActive");
				}
				
			}
		});
		narrationTxtArea.addKeyDownHandler(new KeyDownHandler() {
			
			@Override
			public void onKeyDown(KeyDownEvent event) {
				narrationAlertMessageLbl.setVisible(false);
				if(narrationTxtArea.getText().toString().trim().length() >= 600){ 
					narrationAlertMessageLbl
                    .removeStyleName("titleAlertMessageDeActive");
					narrationAlertMessageLbl
                    .addStyleName("titleAlertMessageActive");
					updateNarrationBtn.setEnabled(false);
	                updateNarrationBtn.getElement().addClassName("disabled");
					if(event.getNativeEvent().getCtrlKey() && event.getNativeEvent().getKeyCode()==86){
						event.getNativeEvent().preventDefault();
						((RichTextArea)event.getSource()).setFocus(false);
						narrationAlertMessageLbl.setVisible(true);
						return;
					}
				}else{
					narrationAlertMessageLbl
					.addStyleName("titleAlertMessageDeActive");
			narrationAlertMessageLbl
					.removeStyleName("titleAlertMessageActive");
			updateNarrationBtn.setEnabled(true);
            updateNarrationBtn.getElement().removeClassName("disabled");
            narrationAlertMessageLbl.setVisible(false);
				}
			}
		});
		
		imgNotFriendly.addMouseOverHandler(new MouseOverHandler() {
			
			@Override
			public void onMouseOver(MouseOverEvent event) {
				toolTip = new ToolTip(GL0454+""+"<img src='/images/mos/ipadFriendly.png' style='margin-top:0px;'/>"+" "+GL04431);
				
				toolTip.getElement().getStyle().setBackgroundColor("transparent");
				toolTip.getElement().getStyle().setPosition(Position.ABSOLUTE);
				toolTip.setPopupPosition(imgNotFriendly.getAbsoluteLeft()-(50+22), imgNotFriendly.getAbsoluteTop()+22);
				toolTip.show();
			}
		});
		imgNotFriendly.addMouseOutHandler(new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
				
				EventTarget target = event.getRelatedTarget();
				  if (Element.is(target)) {
					  if (!toolTip.getElement().isOrHasChild(Element.as(target))){
						  toolTip.hide();
					  }
				  }
			}
		});
	}

	public void setUpdatedData(CollectionItemDo collectionItemDo) {
		
	}
	@UiHandler("EditBtn")
	public void onClickEdit(ClickEvent clickEvent)
	{
		if (ResourceEditButtonContainer.getElement().getStyle()
				.getVisibility().equalsIgnoreCase("VISIBLE")) {
			ResourceEditButtonContainer.getElement().getStyle()
					.setVisibility(Visibility.HIDDEN);
		} else {
			narrationAlertMessageLbl
				.addStyleName("titleAlertMessageDeActive");
			narrationAlertMessageLbl
				.removeStyleName("titleAlertMessageActive");
	
			narrationTxtArea.getElement().getStyle().clearBackgroundColor();
			narrationTxtArea.getElement().getStyle().setBorderColor("#ccc");
			narrationAlertMessageLbl.setVisible(false);
			

			ResourceEditButtonContainer.getElement().getStyle()
					.setVisibility(Visibility.VISIBLE);
		}	
	}
	private class toTxtKeyUpHandler implements KeyUpHandler {

		@Override
		public void onKeyUp(KeyUpEvent event) {
			isEdited = true;
			toTxt.setFocus(true);
			
		}
	}

	private class fromTxtKeyUpHandler implements KeyUpHandler {

		@Override
		public void onKeyUp(KeyUpEvent event) {
			isEdited = true;
			fromTxt.setFocus(true);
		}

	}
	private class NumbersOnly implements KeyPressHandler {
	      
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
					
		}
    }
	/*private class showNarationPencil implements MouseOverHandler {

		@Override
		public void onMouseOver(MouseOverEvent event) {
			onResourceNarrationHover();
		}

	}*/

	private class narationValidation implements KeyUpHandler {

		@Override
		public void onKeyUp(KeyUpEvent event) {
			narrationDataLength=narrationTxtArea.getText().toString().trim().length();
			 if (trim(narrationTxtArea.getText()).length() > 0 && trim(narrationTxtArea.getText()).length() <= 600){
				
				updateNarrationBtn.setEnabled(true);
                updateNarrationBtn.getElement().removeClassName("disabled");
                narrationAlertMessageLbl
                        .addStyleName("titleAlertMessageDeActive");
                narrationAlertMessageLbl
                        .removeStyleName("titleAlertMessageActive");
				
			}
			else {
				updateNarrationBtn.setEnabled(true);
                updateNarrationBtn.getElement().addClassName("disabled");
				narrationAlertMessageLbl
						.addStyleName("titleAlertMessageDeActive");
				narrationAlertMessageLbl
						.removeStyleName("titleAlertMessageActive");
			}
			isEdited = true;
		}

	}

	/*private class hideNarationPencil implements MouseOutHandler {

		@Override
		public void onMouseOut(MouseOutEvent event) {
			onResourceNarrationOut();
		}

	}*/

	/**
	 * 
	 * To show the ResourceMetaDataInfo Edit,Copy and Remove buttons
	 */
	private class ActionPanelHover implements MouseOverHandler {

		@Override
		public void onMouseOver(MouseOverEvent event) {
			if ((actionVerPanel.isVisible()==false) && (actionVerPanelForUpdateTime.isVisible()==false) && (actionVerPanelForUpdatePDF.isVisible()==false)) {
				EditBtn.setVisible(true);
				//ResourceEditButtonContainer.getElement().getStyle().setVisibility(Visibility.VISIBLE);
				//actionVerPanel.setVisible(true);
				// onResourceNarrationHover();

			}
		}
	}

	/**
	 * 
	 * To hide the ResourceMetaDataInfo Edit,Copy and Remove buttons
	 */
	private class ActionPanelOut implements MouseOutHandler {

		@Override
		public void onMouseOut(MouseOutEvent event) {
			//if (updateResourceBtn.getText().equalsIgnoreCase("Edit Narration")) {
				EditBtn.setVisible(false);
				ResourceEditButtonContainer.getElement().getStyle().setVisibility(Visibility.HIDDEN);
				//actionVerPanel.setVisible(false);
				//actionVerPanelForUpdateTime.setVisible(false);
				// onResourceNarrationOut();
			//}
		}
	}

	/**
	 * set collection item meta data , set title , url, narration, start and
	 * stop
	 * 
	 * @param collectionItem
	 *            instance of {@link CollectionItemDo}
	 */
	public void setData(CollectionItemDo collectionItem) {
		Window.enableScrolling(true);
		String tumbnailUrl;
		//resourceTitleLbl.setText(StringUtil.truncateText(collectionItem.getResource().getTitle(), 70));
		String resourceTitle = collectionItem.getResource().getTitle()==null?"":collectionItem.getResource().getTitle();
		resourceTitleLbl.setHTML(resourceTitle.replaceAll("<p>", "").replaceAll("</p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", ""));
		resourceTitleLbl.getElement().getStyle().setWidth(63, Unit.PCT);
		setResourcePlayLink();
		String resourceType = collectionItemDo.getResource().getResourceType().getName();
		youtube = resourceType.equalsIgnoreCase(ImageUtil.YOUTUBE);

		mediaType = collectionItem.getResource().getMediaType();
		setVisibility = mediaType !=null ?  mediaType.equalsIgnoreCase("not_iPad_friendly") ? true : false : false;
		imgNotFriendly.setVisible(setVisibility);
		resourceTitle=resourceTitleLbl.getText();
		if (resourceTitleLbl.getText().length()>=70){
			resourceTitleLbl.getElement().getStyle().setWidth(80, Unit.PCT);
		}else{
			resourceTitleLbl.getElement().getStyle().clearWidth();	
		}
		
		if (collectionItem.getResource().getAssets() != null
				&& collectionItem.getResource().getAssets().size() > 0) {
			for (AssetsDo asstesDo : collectionItem.getResource().getAssets()) {

				tumbnailUrl = collectionItem.getCollection().getAssetURI()
						+ collectionItem.getResource().getFolder()
						+ asstesDo.getAsset().getName();
//				resourceImageUc.renderSearch(collectionItem.getResource().getCategory(), tumbnailUrl, collectionItem.getResource().getUrl(), collectionItem.getCollectionItemId(),PLAYER_NAME,resourceTitle, youtube,"");
				resourceImageUc.renderSearch(collectionItem.getResource().getCategory(), tumbnailUrl, collectionItem.getResource().getUrl(), collectionItem.getCollectionItemId(),resourceTitle, youtube,collectionItem.getNarration());
			}
		} else {
				try {
					if(collectionItem.getResource().getThumbnails()==null) {
						ThumbnailDo thumbnailDo = new ThumbnailDo();
						collectionItem.getResource().setThumbnails(thumbnailDo);
						collectionItem.getResource().getThumbnails().setUrl("/null");
					}
				} catch (Exception e) {
						ThumbnailDo thumbnailDo = new ThumbnailDo();
						collectionItem.getResource().setThumbnails(thumbnailDo);
						collectionItem.getResource().getThumbnails().setUrl("/null");
				}
				
				/*resourceImageUc.renderSearch(collectionItem.getResource()
					.getCategory(), collectionItem.getResource()
					.getThumbnails().getUrl(), collectionItem.getResource()
					.getUrl(), collectionItem.getCollectionItemId(),
					PLAYER_NAME,resourceTitle, youtube,"");*/
				resourceImageUc.renderSearch(collectionItem.getResource().getCategory(), collectionItem.getResource().getThumbnails().getUrl(), collectionItem.getResource().getUrl(), collectionItem.getCollectionItemId(),resourceTitle, youtube,collectionItem.getNarration());
		}

		if (collectionItem.getNarration() != null && !collectionItem.getNarration().trim().isEmpty()){
			narrationData=collectionItem.getNarration();
			narrationData=narrationData.replaceAll("rgb", "");
			resourceNarrationHtml.setHTML(narrationData);
			/*if(collectionItem.getNarration().length() > 80) {
				narrationData=collectionItem.getNarration();
			String narration = collectionItem.getNarration().length() > 80 ? collectionItem
					.getNarration().substring(0, 80).trim()
					+ "..."
					: collectionItem.getNarration().trim();
			resourceNarrationHtml.setHTML(narration);
				}
				else
				{
					resourceNarrationHtml.setHTML(collectionItem.getNarration());	
				}*/
		} else {
			resourceNarrationHtml.setHTML(NO_NARRATION_ADDED);
		}
		String category = collectionItemDo.getResource().getCategory();
		if(!youtube){
			videoImage.removeStyleName(CollectionEditResourceCBundle.INSTANCE.css().videoImageContainer());
			editVideoTimeLbl.setVisible(false);
			editStartPageLbl.setVisible(false);	
		}
		if (youtube) {
			editStartPageLbl.setVisible(false);
			editVideoTimeLbl.setVisible(true);
			videoTimeField.setText(VIDEO_TIME);
			videoDisplay.setVisible(true);
			videoImage.setStyleName(CollectionEditResourceCBundle.INSTANCE.css().videoImageContainer());
			//if(collectionItemDo.getStart()!=null && collectionItemDo.getStop()!=null && collectionItemDo.getStart()!="00:00:00" && collectionItemDo.getStop()!="00:00:00"){
			String stopTime = (collectionItemDo.getStop() == null) ? "00:00:00"
					: collectionItemDo.getStop();
			
			String startTime = (collectionItemDo.getStart() == null) ? "00:00:00"
					: collectionItemDo.getStart();

			startTime = startTime.replaceAll("\\.", ":");
			stopTime = stopTime.replaceAll("\\.", ":");
			
			if (!"00:00:00".equalsIgnoreCase(stopTime) ||!"00:00:00".equalsIgnoreCase(startTime)) {
					String[] VideoStartTime=startTime.split(":");
					String[] VideoEndTime=stopTime.split(":");
					String startMm=Integer.parseInt(VideoStartTime[0])*60+Integer.parseInt(VideoStartTime[1])+"";
					String startSec =null;
					String endSec = null;
					if (VideoStartTime.length>2){
						startSec=Integer.parseInt(VideoStartTime[2])+"";
					}else{
						startSec="00";
					}
					String endMm=Integer.parseInt(VideoEndTime[0])*60+Integer.parseInt(VideoEndTime[1])+"";
					if (VideoEndTime.length>2){
						endSec=Integer.parseInt(VideoEndTime[2])+"";
					}else{
						endSec="00";
					}
					 
					if(startMm.length()<2)
					{
						startMm="0"+startMm;
					}
					if(startSec.length()<2)
					{
						startSec="0"+startSec;
					}
					if(endMm.length()<2)
					{
						endMm="0"+endMm;
					}
					if(endSec.length()<2)
					{
						endSec="0"+endSec;
					}
					fromTxt.setText(startMm);
					toTxt.setText(startSec);
					EndTimeTxt1.setText(endMm);
					EndTimeTxt2.setText(endSec);
					fromLblDisplayText.setText(startMm+" "+GL0958+" "+startSec +" "+GL0959+" "+GL_GRR_Hyphen+" "+endMm+" "+GL0958+" "+endSec +" "+GL0959+" ");
					fromLbl.setText(FROM_START_TIME);
					ToLbl.setText(FROM_STOP_TIME);
			}
					
			else
			{
				
			String videoId = ResourceImageUtil.getYoutubeVideoId(collectionItemDo
						.getResource().getUrl());
					
				if (videoId != null) {
					AppClientFactory.getInjector().getResourceService().getYoutubeDuration(videoId, new SimpleAsyncCallback<String>() {
										@Override
										public void onSuccess(String youtubeInfo) {
											if (youtubeInfo != null) {
												totalVideoLength = Integer.parseInt(youtubeInfo);
												String tolTimeInmin = "";
												String totalTimeSec = "";

												int tolTimeInminutes = totalVideoLength / 60;
												if (tolTimeInminutes < 10) {
													tolTimeInmin = "0"
															+ tolTimeInminutes;
												} else {
													tolTimeInmin = tolTimeInminutes
															+ "";
												}

												int totalTimeInseconds = totalVideoLength % 60;
												if (totalTimeInseconds < 10) {
													totalTimeSec = "0"
															+ totalTimeInseconds;
												} else {
													totalTimeSec = totalTimeInseconds
															+ "";
												}
												fromLblDisplayText
														.setText(START_MINUTE
																+ " "+GL0958+" "
																+ START_SEC
																+ " "+GL0959+" "+GL_GRR_Hyphen+" "
																+ tolTimeInmin
																+ " "+GL0958+" "
																+ totalTimeSec
																+ " "+GL0959+" ");
												EndTimeTxt1
														.setText(tolTimeInmin);
												EndTimeTxt2
														.setText(totalTimeSec);
											} else {
												fromLblDisplayText
														.setText(START_MINUTE
																+ " "+GL0958+" "
																+ START_SEC
																+ " "+GL0959+" "+GL_GRR_Hyphen+" "
																+ START_MINUTE
																+ " "+GL0958+" "
																+ END_MINUTE
																+ " "+GL0959+" ");
												EndTimeTxt1.setText(END_MINUTE);
												EndTimeTxt2.setText(END_SEC);

											}
										}

									});
				}
				fromLbl.setText(FROM_START_TIME);
				ToLbl.setText(FROM_STOP_TIME);
				fromTxt.setText(START_STOP_MINUTE);
				toTxt.setText(START_STOP_SEC);

			}
		} else if (category!=null){ 
			if (category.equalsIgnoreCase("Slide")
				|| category.equalsIgnoreCase("Textbook")
				|| category.equalsIgnoreCase("Handout") || category.equalsIgnoreCase("Question")||category.equalsIgnoreCase("Exam")||category.equalsIgnoreCase("Lesson")
				||category.equalsIgnoreCase("Website")||category.equalsIgnoreCase("Webpage")||category.equalsIgnoreCase("Text")) {
				//fromLbl.setText(FROM_START_PAGE);
				videoImage.removeStyleName(CollectionEditResourceCBundle.INSTANCE.css().videoImageContainer());
				editVideoTimeLbl.setVisible(false);
				editStartPageLbl.setVisible(false);
			}
			
		}
		//if(category.equalsIgnoreCase("Textbook"))
		
		if(collectionItemDo.getResource() !=null && collectionItemDo.getResource().getUrl() != null && collectionItemDo.getResource().getUrl().endsWith(".pdf"))
		{
			
			editStartPageLbl.setVisible(true);
			editVideoTimeLbl.setVisible(false);
			fromLblDisplayText.setVisible(true);
			videoDisplay.setVisible(true);
					
			videoImage.removeStyleName(CollectionEditResourceCBundle.INSTANCE.css().videoImageContainer());
			videoImage.setStyleName(CollectionEditResourceCBundle.INSTANCE.css().pdfImageContainer());
			String startPageNumber=collectionItemDo.getStart();
		//	String endPageNumber=collectionItemDo.getStop();
			
			//updatePDFLabelText.setText("0f "+endPageNumber+" pages");
			if(startPageNumber==null){
			startpdfPageNumber.setText("1");
			//videoImage.removeStyleName(CollectionEditResourceCBundle.INSTANCE.css().pdfImageContainer());
			fromLblDisplayText.setText(START_PAGE+DEFAULT_START_PAGE);
			//fromLblDisplayText.setText(START_PAGE+DEFAULT_START_PAGE+" of "+DEFAULT_END_PAGE+" pages");
			}
			else{
				fromLblDisplayText.setText(START_PAGE+startPageNumber);
				startpdfPageNumber.setText(startPageNumber);
			//fromLblDisplayText.setText(START_PAGE+startPageNumber+" of "+endPageNumber+" pages");
			}
		}
		else if (category!=null){ 
			if (category.equalsIgnoreCase("Slide")
				|| category.equalsIgnoreCase("Textbook")
				|| category.equalsIgnoreCase("Handout") ||category.equalsIgnoreCase("Question")||category.equalsIgnoreCase("Exam")||category.equalsIgnoreCase("Lesson")
				||category.equalsIgnoreCase("Website")||category.equalsIgnoreCase("Webpage")) {
				//fromLbl.setText(FROM_START_PAGE);
				videoImage.removeStyleName(CollectionEditResourceCBundle.INSTANCE.css().pdfImageContainer());
				editStartPageLbl.setVisible(false);
				editVideoTimeLbl.setVisible(false);
			}
		}
	}
		
	/**
	 * To play resource
	 * 
	 * @param clickEvent
	 */
	/*@UiHandler("resourceTitleLbl")
	public void onResourceTitleClick(ClickEvent clickEvent) {
//		setResourcePlayLink();
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", collectionItemDo.getCollectionItemId());
		params.put("pn", "collectionItem");
		AppClientFactory.getPlaceManager().revealPlace(
				PlaceTokens.RESOURCE_PLAY, params);
	}*/
	
	public void setResourcePlayLink(){
		Anchor resourceAnchor=new Anchor();
		resourceAnchor.setHref(getResourceLink());
		resourceAnchor.setStyleName("");
		resourceAnchor.getElement().appendChild(resourceTitleLbl.getElement());
		resourceTitleContainer.add(resourceAnchor);
		resourceAnchor.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				AppClientFactory.getPlaceManager().setRefreshPlace(false);
			}
		});
	}
	
	public String getResourceLink(){
		String collectionId=AppClientFactory.getPlaceManager().getRequestParameter("id", null);
		if(collectionItemDo.getNarration()!=null&&!collectionItemDo.getNarration().trim().equals("")){
			String resourceLink="#"+PlaceTokens.PREVIEW_PLAY+"&id="+collectionId+"&rid="+collectionItemDo.getCollectionItemId()+"&tab=narration";
			return resourceLink;
		}else{
			String resourceLink="#"+PlaceTokens.PREVIEW_PLAY+"&id="+collectionId+"&rid="+collectionItemDo.getCollectionItemId();
			return resourceLink;
		}
	}

	/**
	 * Edit collection item , update collection item
	 * 
	 * @param clickEvent
	 */
	@UiHandler("updateResourceBtn")
	public void onEditClick(ClickEvent clickEvent) {
		MixpanelUtil.Organize_Click_Edit_Narration();
		EditBtn.setVisible(false);
		ResourceEditButtonContainer.getElement().getStyle()
		.setVisibility(Visibility.HIDDEN);
		actionVerPanel.setVisible(true);
			editAndUpdateResource();
		
		
	}
	@UiHandler("addTages")
	public void onAddTagesClick(ClickEvent clickEvent) {
		Window.enableScrolling(false);
		popup=new AddTagesPopupView(collectionItemDo.getResource().getGooruOid()){
			
			@Override
			public void closePoup(boolean isCancelclicked) {
		        this.hide();
		        if(!isCancelclicked){
		        SuccessPopupViewVc success = new SuccessPopupViewVc() {

					@Override
					public void onClickPositiveButton(ClickEvent event) {
						this.hide();
						Window.enableScrolling(true);
					}
					
				};
				success.setHeight("253px");
				success.setWidth("450px");
				success.setPopupTitle(GL1788);
				success.setDescText(GL1789);
				success.enableTaggingImage();
				success.setPositiveButtonText(GL0190);
				success.center();
				success.show();
		        }else{
		        	Window.enableScrolling(true);
		        }
			}
		};
		popup.show();
		popup.setPopupPosition(popup.getAbsoluteLeft(),Window.getScrollTop()+10);
	}
	/*
	 * This clickEvent is used to edit pdf
	 */
	@UiHandler("editStartPageLbl")
	public void oneditStartPageLblClick(ClickEvent clickEvent) {
		MixpanelUtil.Organize_Click_Edit_Start_Page();
		actionVerPanelForUpdatePDF.setVisible(true);
		editPdfFlowPanel.setVisible(true);
		ResourceEditButtonContainer.getElement().getStyle()
		.setVisibility(Visibility.HIDDEN);
		EditBtn.setVisible(false);
		fromLblDisplayText.setVisible(false);
		videoDisplay.setVisible(false);
		narrationConatainer.setVisible(false);
		setEditMode(true);
		
		
	}
	/*
	 * This clickEvent is used to update pdf start page
	 */
	@UiHandler("updatePdfBtn")
	public void updatePdfBtnClick(ClickEvent clickEvent) {
		updatePdfStartPage();
		
	}
	/*
	 * This clickEvent is used to cancel the pdf edit
	 */
	@UiHandler("cancelpdfBtn")
	public void cancelpdfBtnClick(ClickEvent clickEvent) {
		fromLblDisplayText.setVisible(true);
		videoDisplay.setVisible(true);
		actionVerPanelForUpdatePDF.setVisible(false);
		editPdfFlowPanel.setVisible(false);
		narrationConatainer.setVisible(true);
		videoDisplay.setVisible(true);
		startpdfPageNumber.setFocus(true);
		editFloPanel.setVisible(false);
		isEdited=false;
		disableAllEditMode();
		}
	
	/**
	 * Add or update narration for the collection resource
	 * 
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */
	// @UiHandler("resourceNarrationHtml")
	// public void onEditNarationClick(ClickEvent clickEvent) {
	// editAndUpdateResource();
	// }

	@UiHandler("pencilEditNarationLbl")
	public void onPencilNarationClick(ClickEvent clickEvent) {
		editAndUpdateResource();
	}

	/**
	 * Copy collection item
	 * 
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */
	@UiHandler("copyResource")
	public void copyResource(ClickEvent clickEvent) {
		ResourceEditButtonContainer.getElement().getStyle().setVisibility(Visibility.HIDDEN);
		EditBtn.setVisible(false);
		if (isEdited) {
				if (previousCollectionResourceChildView != null	&& previousCollectionResourceChildView.isAttached()) {
				if (!isConfirmationPopup) {
					isConfirmationPopup = true;
					new ConfirmationPopupVc(OOPS, EDIT_CONFIRM) {

						@Override
						@UiHandler("okButton")
						public void onDelete(ClickEvent clickEvent) {
							hide();
							isConfirmationPopup = false;
							clickEvent.stopPropagation();
						}

						@Override
						@UiHandler("cancelButton")
						public void onCancelClick(ClickEvent clickEvent) {
							disableAllEditMode();
							hide();
							isEdited = false;
							isConfirmationPopup = false;
							clickEvent.stopPropagation();
						}
					};
				}
			}
		} else {
			disableAllEditMode();
			copyConfirmPopupVc = new CopyConfirmPopupVc() {
				@Override
				public void populateUserCollections() {
					pageNumber=1;
					getPresenter().getUserColletionsList(pageSize,pageNumber);
				}
				public void copyResourceToCollection(String collectionId) {
					disableAllEditMode();
					selectedCollectionId=collectionId;
					getPresenter().createCollectionItem(collectionId,collectionItemDo.getCollectionItemId());
				}

				@Override
				public void getFolderInnerItems(TreeItem item, String parentId) {
					getPresenter().getFolderItems(item, parentId);
				}

				@Override
				public void getWorkspaceData(int offset, int limit,boolean clearShelfPanel) {
					getPresenter().getWorkspaceData(offset, limit,clearShelfPanel);
					
				}

			};
		}
	}

	
	/**
	 * Confirmation popup for collection item delete, delete collection item
	 * regarding the popup action
	 * 
	 * @param clickEvent
	 *            instance of {@link ClickEvent}
	 */
	@UiHandler("confirmDeleteLbl")
	public void deleteCollectionItem(ClickEvent clickEvent) {
		ResourceEditButtonContainer.getElement().getStyle().setVisibility(Visibility.HIDDEN);
		EditBtn.setVisible(false);
		Window.enableScrolling(false);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(88, false));

		deleteConfirmationPopupVc = new ConfirmationPopupVc(MESSAGE_HEADER,
				MESSAGE_CONTENT) {

			@Override
			public void onDelete(ClickEvent clickEvent) {
				getPresenter().deleteCollectionItem(
						collectionItemDo.getCollectionItemId());

			}
		};

	}
	/*
	 * This clickEvent is used to update pdf
	 */
	public void updatePdfStartPage()
	{
		MixpanelUtil.Organize_Click_Edit_Start_Page_Update();
		actionVerPanelForUpdatePDF.setVisible(false);
		editFloPanel.setVisible(false);
		editPdfFlowPanel.setVisible(false);
		actionVerPanelForUpdateTime.setVisible(false);
		fromLblDisplayText.setVisible(true);
		videoDisplay.setVisible(true);
		narrationConatainer.setVisible(true);
		UpdateTextMessage.setVisible(true);
		actionVerPanel.setVisible(false);
		String start=startpdfPageNumber.getText();
		
		//collectionItemDo.setStart(start);
		getPresenter().updateCollectionItem(
				collectionItemDo.getCollectionItemId(),narrationData,
				start, "");
		isEdited = false;
		
	}
	/*
	 * This clickEvent is used to update video
	 */
	public void editAndUpdateVideoTime()
	{
		MixpanelUtil.Organize_Click_Edit_Start_Time_Update();
		actionVerPanelForUpdateTime.setVisible(false);
		actionVerPanelForUpdatePDF.setVisible(false);
		actionVerPanel.setVisible(false);
		editFloPanel.setVisible(false);
		UpdateTextMessage.setVisible(true);
		videoDisplay.setVisible(true);
		narrationConatainer.setVisible(true);
		editFieldsFloPanel.setVisible(false);
		
		
		String narration = null;
		String from = null;
		String to = null;
		if (collectionItemDo.getResource().getResourceType().getName()
				.equalsIgnoreCase("video/youtube")) {
			from = FROM_START_TIME;
			to = FROM_STOP_TIME;
		}
		/*if (resourceNarrationHtml.getHTML().length() > 0) {
			narration = narrationTxtArea.getHTML();
			collectionItemDo.setNarration(narration);
		}*/
		if (fromTxt.getText().length() > 0 && toTxt.getText().length() > 0) {
			from = fromTxt.getText();
			fromTxt.setText(from);
			from = toTxt.getText();
			toTxt.setText(from);
			String startTimeTxtMin = null;
			String startTimeTxtSec = null;
			if(fromTxt.getText().length()<2)
			{
				startTimeTxtMin="0"+fromTxt.getText();
				
			}
			else
			{
				startTimeTxtMin=fromTxt.getText();
			}
			if(toTxt.getText().length()<2)
			{
				startTimeTxtSec="0"+toTxt.getText();
			}
			else
			{
				startTimeTxtSec=toTxt.getText();
			}
			from="00:"+startTimeTxtMin+":"+startTimeTxtSec;
			//collectionItemDo.setStart(from);
		
		}
		if (EndTimeTxt1.getText().length() > 0 && EndTimeTxt2.getText().length() > 0 ) {
			to = EndTimeTxt1.getText();
			EndTimeTxt1.setText(to);
			to = EndTimeTxt2.getText();
			EndTimeTxt2.setText(to);
			String EndTimeTxtMin = null;
			String EndTimeTxtSec = null;
			if(EndTimeTxt1.getText().length()<2)
			{
				EndTimeTxtMin="0"+EndTimeTxt1.getText();
				
			}
			else
			{
				EndTimeTxtMin=EndTimeTxt1.getText();
			}
			if(EndTimeTxt2.getText().length()<2)
			{
				EndTimeTxtSec="0"+EndTimeTxt2.getText();
			}
			else
			{
				EndTimeTxtSec=EndTimeTxt2.getText();
			}
			to="00:"+ EndTimeTxtMin+":"+EndTimeTxtSec;
			//collectionItemDo.setStop(to);
		}
		
		if ((collectionItemDo.getResource().getResourceType().getName()
				.equalsIgnoreCase("video/youtube"))
				&& (!from.equals(FROM_START_TIME) || !to
						.equals(FROM_STOP_TIME))) {
			this.youtubeValidation(narration, from, to);
		} else {
					getPresenter().updateCollectionItem(
					collectionItemDo.getCollectionItemId(),narrationData,
					from, to);
					//setEditMode(false);	
		}
		isEdited = false;
		
	}
	/**
	 * Update the collection item meta data
	 * 
	 */
	public void editAndUpdateResource() {
		//	if (updateResourceBtn.getText().equalsIgnoreCase("Edit Narration")) {
		videoDisplay.setVisible(false);
		editFieldsFloPanel.setVisible(false);
			if (collectionItemDo.getNarration() != null) {
				narrationTxtArea.setText(collectionItemDo.getNarration());
			}
			resourceNarrationHtml.setHTML(ADD_NARRATION_FOR_YOUR_VIEWERS);
			setEditMode(true);

	}
	/*
	 * This clickEvent is used to upadte narration
	 */
	@UiHandler("updateNarrationBtn")
	public void onclickOfnarrationUpdate(ClickEvent event)
	{
		Map<String, String> parms = new HashMap<String, String>();
		parms.put("text", narrationTxtArea.getText());
		AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {
			
			@Override
			public void onSuccess(Boolean value) {
				isHavingBadWords = value;
				if (value){
					narrationAlertMessageLbl.addStyleName("narrationTxtArea");
					narrationAlertMessageLbl
							.removeStyleName("titleAlertMessageDeActive");
					narrationAlertMessageLbl
							.addStyleName("titleAlertMessageActive");
					
					
					narrationTxtArea.getElement().getStyle().setBorderColor("orange");
					narrationAlertMessageLbl.setText(GL0554);
					narrationAlertMessageLbl.setVisible(true);
					
					MixpanelUtil.mixpanelEvent("Collaborator_edits_collection");
				}else{
//					if(narrationDataLength<=600){
						String narration = null;
						actionVerPanel.setVisible(false);
						actionVerPanelForUpdateTime.setVisible(false);
						actionVerPanelForUpdatePDF.setVisible(false);
						MixpanelUtil.Organize_Click_Edit_Narration_Update();
						UpdateTextMessage.setVisible(true);
						if (resourceNarrationHtml.getHTML().length() > 0) {
							//narration = narrationTxtArea.getRawContent();
							narration = trim(narrationTxtArea.getText());
							collectionItemDo.setNarration(narration);
						}
					
						try{
							getPresenter().updateNarrationItem(
									collectionItemDo.getCollectionItemId(), narration);
						}catch(Exception e){
							e.printStackTrace();
						}
						isEdited = false;
//					}
					
				}
			}
		});
		
		
		
		
		
	}
	/*
	 * This clickEvent is used to cancel narration edit
	 */
	@UiHandler("cancelNarrationBtn")
	public void onclickcancelNarrationBtn(ClickEvent event){
		narrationTxtArea.setText(collectionItemDo.getNarration());
		fromLblDisplayText.setVisible(true);
		videoDisplay.setVisible(true);
		setEditMode(false);
		isEdited = false;
		disableAllEditMode();
	}
	/*
	 * This clickEvent is used to edit video time
	 */
	@UiHandler("editVideoTimeLbl")
	public void onclickEditVideoTimeLbl(ClickEvent event)
	{
			if(youtube){
			MixpanelUtil.Organize_Click_Edit_Start_Time();
			EditBtn.setVisible(false);
			actionVerPanelForUpdateTime.setVisible(true);
			videoDisplay.setVisible(false);
			narrationConatainer.setVisible(false);
			editFieldsFloPanel.setVisible(true);
			ResourceEditButtonContainer.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			fromTxt.setFocus(true);
			setEditMode(true);
			
		}
		
	}
	/*
	 * This clickEvent is used to update video time 
	 */
	@UiHandler("updateVideoTimeBtn")
	public void updateVideoTimeBtnClickEvent(ClickEvent event)
	{
		editAndUpdateVideoTime();
	}
	/*
	 * This clickEvent is used to cancel video time edit
	 */
	@UiHandler("cancelVideoTimeBtn")
	public void cancelVideoTimeBtnClickEvent(ClickEvent event)
	{
		videoDisplay.setVisible(true);
		narrationConatainer.setVisible(true);
		editFieldsFloPanel.setVisible(false);
		actionVerPanelForUpdateTime.setVisible(false);
		editFloPanel.setVisible(false);
		isEdited = false;
		disableAllEditMode();
		
	}

	/**
	 * Reorder the collection item with new new sequence
	 * 
	 * @param newSequence
	 *            reorder the collection item
	 */
	public void reorderCollectionItem(Integer newSequence) {
		collectionItemDo.setItemSequence(newSequence);
		getPresenter().reorderCollectionItem(collectionItemDo);
		new Timer() {

			@Override
			public void run() {
				//remove in 5.9 sprint
				//setEditMode(false);
			}
		}.schedule(2000);
	}

	@Override
	public Widget getDragHandle() {
		// The whole widget acts as drag widget
		return null;
	}

	@Override
	public IsDraggableMirage initDraggableMirage() {
		return new ResourceDragUc(collectionItemDo.getResource().getCategory(),
				collectionItemDo.getResource().getTitle());
	}

	@Override
	public void onDragBlur() {
		// Nothing
	}

	@Override
	public String getDragId() {
		return collectionItemDo.getCollectionItemId();
	}

	public CollectionItemDo getCollectionItemDo() {
		return collectionItemDo;
	}
	
	@Override
	public DRAG_TYPE getDragType() {
		return DRAG_TYPE.COLLECTION_ITEM;
	}

	@Override
	public int getDragTopCorrection() {
		return 5;
	}

	@Override
	public int getDragLeftCorrection() {
		return 225;
	}

	@Override
	public void onPostReorder(CollectionItemDo collectionItemDo) {
		collectionItemDo.setCollection(this.collectionItemDo.getCollection());
		this.collectionItemDo.setItemSequence(collectionItemDo
				.getItemSequence());
		AppClientFactory.fireEvent(new RefreshCollectionItemInShelfListEvent(collectionItemDo, RefreshType.UPDATE));

	}

	@Override
	public void onPostUpdate(CollectionItemDo collectionItemDo) {
		// FIXME Bring all data
		this.collectionItemDo.setNarration(collectionItemDo.getNarration());
		this.collectionItemDo.setStart(collectionItemDo.getStart());
		this.collectionItemDo.setStop(collectionItemDo.getStop());
		//this.collectionItemDo.setStop(collectionItemDo.getAverageTime());
		setEditMode(false);
		
	}

	/**
	 * Collection item update label view , update or edit text
	 * 
	 * @param editMode
	 *            update or edit text view
	 */
	public void setEditMode(boolean editMode) {
	/*	if ((editMode && updateResourceBtn.getText().equalsIgnoreCase(
				"Edit Narration"))
				|| (!editMode && updateResourceBtn.getText().equalsIgnoreCase(
						"Update"))) {
	*/		
		
			if (editMode && previousCollectionResourceChildView != null
					&& previousCollectionResourceChildView.isAttached()) {
				previousCollectionResourceChildView.setEditMode(false);
				previousCollectionResourceChildView = null;
			}
			actionVerPanel.setVisible(editMode);
			previousCollectionResourceChildView = editMode ? this : null;
			editFloPanel.setVisible(editMode);
			
			if (editMode) {
				addStyleName(CollectionEditResourceCBundle.INSTANCE.css()
						.collectionResourceEdit());
			} else {
				setData(this.collectionItemDo);
				removeStyleName(CollectionEditResourceCBundle.INSTANCE.css().collectionResourceEdit());
			}
			//updateResourceBtn.setText(editMode ? "Update" : "Edit Narration");
			//updateResourceBtn.setEnabled(true);
			collectionResourceTabView.setEditMode(editMode, this);
		}
	//}

	@Override
	public void onPostDelete() {
		deleteConfirmationPopupVc.hide();

		collectionResourceTabView.removeCollectionItem(collectionItemDo, this);
		AppClientFactory.fireEvent(new RefreshCollectionItemInShelfListEvent(
				collectionItemDo, RefreshType.DELETE));
		Window.enableScrolling(true);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));


	}

	@Override
	public void onPostCopy(CollectionItemDo collectionItem) {
		copyConfirmPopupVc.hide();
		if(selectedCollectionId==AppClientFactory.getPlaceManager().getRequestParameter("id")) {
			AppClientFactory.fireEvent(new InsertCollectionItemInAddResourceEvent(
					collectionItem, RefreshType.INSERT));
		}
		Window.enableScrolling(true);
        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
	
	}

	@Override
	public void onPutUpdate() {

		// collectionResourceTabView.insertColectionItem(collectionItemDo,true);
		editQuestionPopupVc.hide();
		// isCollResourceTabView.updateData();
		AppClientFactory.fireEvent(new RefreshCollectionItemInShelfListEvent(
				collectionItemDo, RefreshType.UPDATE));

	}

	public void onResourceNarrationHover() {
		pencilEditNarationLbl
				.setStyleName(CollectionEditResourceCBundle.INSTANCE.css()
						.pencilEditImage());
		pencilEditNarationLbl
				.addStyleName(CollectionEditResourceCBundle.INSTANCE.css()
						.pencilAllign());
	}

	public void onResourceNarrationOut() {
		pencilEditNarationLbl
				.setStyleName(CollectionEditResourceCBundle.INSTANCE.css()
						.pencilImageHide());
		pencilEditNarationLbl
				.removeStyleName(CollectionEditResourceCBundle.INSTANCE.css()
						.pencilAllign());
	}
/*
 * This method is used to validate video time
 */
	public void youtubeValidation(final String narration, final String start,
			final String stop) {
		RegExp regExp = RegExp.compile(REG_EXP);
		if (!(regExp.test(start)) || !(regExp.test(stop))) {
			UpdateTextMessage.setVisible(false);
			new AlertContentUc(GL0061, YOUTUBE_START_END_TIME);
			return;
		}
		String videoId = ResourceImageUtil.getYoutubeVideoId(collectionItemDo
				.getResource().getUrl());
		if (videoId != null) {
			
			AppClientFactory.getInjector().getResourceService()
					.getYoutubeDuration(videoId,
							new SimpleAsyncCallback<String>() {
								@Override
								public void onSuccess(String youtubeInfo) {
									int totalVideoLengthInMin;
									if(youtubeInfo!=null){
									totalVideoLengthInMin = Integer
											.parseInt(youtubeInfo);
									String[] startSplitTimeHours = start
											.split(":");
									String[] endSplitTimeHours = stop
											.split(":");
									Integer startTimeInSeconds = (Integer
											.parseInt(startSplitTimeHours[0]) * 3600)
											+ (Integer
													.parseInt(startSplitTimeHours[1]) * 60)
											+ (Integer
													.parseInt(startSplitTimeHours[2]));
									Integer endTimeInSeconds = (Integer
											.parseInt(endSplitTimeHours[0]) * 3600)
											+ (Integer
													.parseInt(endSplitTimeHours[1]) * 60)
											+ (Integer
													.parseInt(endSplitTimeHours[2]));
									if (startTimeInSeconds < endTimeInSeconds
											&& startTimeInSeconds <= totalVideoLengthInMin
											&& endTimeInSeconds <= totalVideoLengthInMin
											|| startTimeInSeconds <= totalVideoLengthInMin
											&& endTimeInSeconds == 0
											|| endTimeInSeconds <= totalVideoLengthInMin
											&& startTimeInSeconds == 0
											|| endTimeInSeconds == 0
											&& startTimeInSeconds == 0) {
										getPresenter().updateCollectionItem(
												collectionItemDo
														.getCollectionItemId(),
														narrationData, start, stop);
										///setEditMode(false);
									} else {
										UpdateTextMessage.setVisible(false);
										new AlertContentUc(GL0061,
												VALID_START_STOP_TIME);
									}
								}
								}
							});
		}
		else
		{
			UpdateTextMessage.setVisible(false);
		}
	}

	
	@Override
	public void onPostUserCollections(List<CollectionDo> result) {
//		int count = 0;
//		totalSize=result.size();
//		if(result.size()==0){
//			copyConfirmPopupVc.copyLabel.setVisible(true);
//			copyConfirmPopupVc.btnCancel.setVisible(true);
//			copyConfirmPopupVc.loadingTextLbl.setVisible(false);
//			}
//		collectionItems = new ArrayList<Integer>();
//		String collectionTitle=ShelfView.getCollectionTitle();
//		
//		for (CollectionDo collection : result) {
//			if (!collection.getCollectionType().toString().trim().equalsIgnoreCase("folder")){
//				copyConfirmPopupVc.resourceFirstElement.getElement().setAttribute("style", "padding-left:5px");
//				if(collectionTitle.length()>=40) {
//					copyConfirmPopupVc.resourceFirstElement.setText(collectionTitle.substring(0, 40)+"...");
//				}else{
//					copyConfirmPopupVc.resourceFirstElement.setText(collectionTitle);
//				}
//					
//				final Label titleLabel = new Label(collection.getTitle());
//				titleLabel.setStyleName(CollectionEditResourceCBundle.INSTANCE
//						.css().copyPopUpResourceListBoxText());
//				titleLabel.getElement()
//						.setAttribute("id", collection.getGooruOid());
//						copyConfirmPopupVc.htmlScrollPanel.add(titleLabel);
//				//copyConfirmPopupVc.copyPopUpScrollHtmlPanel.add(ScrPanel);
//	
//				// copyConfirmPopupVc.copyPopupListBox.setVisibleItemCount(count);
//				// copyConfirmPopupVc.copyPopupListBox.setValue(count,
//				// collection.getGooruOid());
//						
//				count++;
//				copyConfirmPopupVc.loadingTextLbl.setVisible(false);
//				copyConfirmPopupVc.copyLabel.setVisible(true);
//				copyConfirmPopupVc.btnCancel.setVisible(true);
//				
//				int collectionItemDoSize = collection.getCollectionItems().size();
//				
//				collectionItems.add(collectionItemDoSize);
//				copyConfirmPopupVc.setCollectionItemDoSize(collectionItems);
//	
//				collectionListCount.put(collection.getGooruOid(), collectionItemDoSize);
//				titleLabel.addClickHandler(new ClickHandler() {
//	
//					@Override
//					public void onClick(ClickEvent event) {
//						if(titleLabel.getText().length()>=40) {
//							copyConfirmPopupVc.resourceFirstElement.setText(titleLabel
//									.getText().substring(0, 40)+"...");
//							copyConfirmPopupVc.resourceFirstElement.getElement()
//									.setAttribute("id",
//											titleLabel.getElement().getAttribute("id"));
//						}
//						else
//						{
//							copyConfirmPopupVc.resourceFirstElement.setText(titleLabel
//									.getText());
//							copyConfirmPopupVc.resourceFirstElement.getElement()
//									.setAttribute("id",
//											titleLabel.getElement().getAttribute("id"));
//					
//						}
//						copyConfirmPopupVc.copyPopUpScrollHtmlPanel.getElement().getStyle().setVisibility(Visibility.HIDDEN);
//						collId = copyConfirmPopupVc.resourceFirstElement.getElement().getId();
//					}
//				});
//			}
//
//		}
//		// Set current collection as selected
//		for (int i = 0; i < result.size(); i++) {
//			if (result.get(i).getGooruOid()
//					.equalsIgnoreCase(
//							collectionItemDo.getCollection().getGooruOid())) {
//				// copyConfirmPopupVc.resourceFirstElement.getText()
//				collId = collectionItemDo.getCollection().getGooruOid();
//				break;
//				
//			}
//		}
//		
//		copyConfirmPopupVc.copyPopUpScrollHtmlPanel.addScrollHandler(new ScrollHandler() {
//
//			@Override
//			public void onScroll(ScrollEvent event) {
//				
//			if (copyConfirmPopupVc.copyPopUpScrollHtmlPanel.getVerticalScrollPosition() == copyConfirmPopupVc.copyPopUpScrollHtmlPanel.getMaximumVerticalScrollPosition() && totalSize >=20)
//				 {
////				copyConfirmPopupVc.copyLabel.setVisible(false);
////				copyConfirmPopupVc.btnCancel.setVisible(false);
//				copyConfirmPopupVc.loadingTextLbl.setVisible(true);
//			
//				
//				pageNumber=pageNumber+1;
//				getPresenter().getUserColletionsList(pageSize,pageNumber);
//					
//				}
//
//			}
//		});
		
	}
	/**
	 * This method is used to trim the text of rich text box.
	 * @function trim 
	 * 
	 * @created_date : 20-Jan-2014
	 * 
	 * @description :
	 * 
	 * 
	 * @parm(s) : @param s
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public String trim(String s) {

		   String result = s.trim(); 
		   String x = result.replaceAll("<br>", "");
		   x = x.replaceAll("&nbsp;", "");
		   x = x.trim();
		   if(x.equals("")) {
		       return x;
		   } else {
		       return result;
		   }
		}
	/**
	 * Highlight the New collection item
	 */
	@Override
	public void addNewResource() {
		//resourceFlowPanel.setStyleName(res.css().addNewResourceBackgroudColor());
		new BackgroundColorEffect(resourceFlowPanel.getElement(),"#E7F1F8" ,"white", 5000);
	}
	

	/*native void redirect()
	-{
	        $wnd.location.reload();
	}-;*/

	@Override
	public Label getVisible() {
		return UpdateTextMessage;
		
	}
	@Override
	public void displayWorkspaceData(FolderListDo folderListDo,boolean clearShelfPanel) {
		copyConfirmPopupVc.displayWorkspaceData(folderListDo,clearShelfPanel);
		
	}
	@Override
	public void setFolderItems(TreeItem item, FolderListDo folderListDo) {
		copyConfirmPopupVc.setFolderItems(item,folderListDo);
	}
	
	
}
