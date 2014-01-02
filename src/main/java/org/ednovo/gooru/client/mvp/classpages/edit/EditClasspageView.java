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
/**
 * 
 */
package org.ednovo.gooru.client.mvp.classpages.edit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.classpages.event.DeleteClasspageListEvent;
import org.ednovo.gooru.client.mvp.classpages.event.RefreshClasspageResourceItemListEvent;
import org.ednovo.gooru.client.mvp.classpages.event.SetSelectedClasspageListEvent;
import org.ednovo.gooru.client.mvp.classpages.event.UpdateClasspageTitleEvent;
import org.ednovo.gooru.client.mvp.classpages.newclasspage.NewClasspagePopupView;
import org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.AssignmentsTabView;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.DeleteConfirmPopupVc;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshType;
import org.ednovo.gooru.client.uc.AssignmentEditLabelUc;
import org.ednovo.gooru.client.uc.PaginationButtonUc;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.content.AssignmentsListDo;
import org.ednovo.gooru.shared.model.content.AssignmentsSearchDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
/**
 * 
 * @fileName : EditClasspageView.java
 *
 * @description : This will set the Edit class page View.
 *
 * @version : 1.0
 *
 * @date: 27-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class EditClasspageView extends
		BaseViewWithHandlers<EditClasspageUiHandlers> implements
		IsEditClasspageView, ClickHandler, MessageProperties {
	
	@UiField(provided = true)
	EditClasspageCBundle res;

	@UiField(provided = true)
	AssignmentEditLabelUc collectionTitleUc;
	
	@UiField TextBox  txtClasspageCodeShare,txtClasspageLinkShare; 
	
	@UiField HTML htmlPopupTitleDesc, htmlShareText,htmlWebLinkTitleDesc;
	
	@UiField Label noAssignmentsMessageLblTwo,noAssignmentsMessageLblOne,lblPopupTitle, lblOr,lblAWebLink,lblWebLink;
	
	@UiField Image imgClasspageImage;
	
	@UiField FlowPanel mainFlowPanel;

	@UiField HTMLPanel panelUpdateActionContols;
	
	@UiField Label titleAlertMessageLbl, lblCodeHelp, lblWebHelp;

	@UiField Button btnStudentView, btnCollectionEditImage, btnEditImage, btnNewAssignment;
	
	@UiField HTMLPanel shareTabContainerPanel, assignmentsTabContainerPanel, assignmentsContainerPanel, noAssignmentsMessagePanel, newAssignmentAndMsgPanel;

	@UiField FlowPanel paginationFocPanel;

	@UiField HTMLPanel loadingPanel, panelCode, panelWebLink;

	@UiField FocusPanel simplePencilFocPanel, classPageTitle,collectionFloPanel;
	
	@UiField Button btnClasspageCancel, btnClasspageSave, btnDeleteClasspage;

	NewClasspagePopupView newPopup = null;

	CollectionDo collectionDo = null;
	
	DeleteConfirmPopupVc deleteConfirmVc =null;
	
	boolean isEditing=false;
	
	boolean isClicked=true;
	
	private String DEFAULT_CLASSPAGE_IMAGE = "images/Classpage/default-classpage.png";
	
	private String classpageId = null;

	private static final String SHORTEN_URL = "shortenUrl";

	private static final String PREVIOUS = "PREVIOUS";

	private static final String NEXT = "NEXT";
	
	private AssignmentsTabView assignmentTabView;

	private int pageSize = 10;

	private int pageNum = 0;

	private int pos = 0;

	int noOfItems = 10;

	private int assignmentCount = 0;

	private final String START_PAGE = "1";
	List<CollectionItemDo> collectionItemList = new ArrayList<CollectionItemDo>();

	private static EditClassPageViewUiBinder uiBinder = GWT
			.create(EditClassPageViewUiBinder.class);

	interface EditClassPageViewUiBinder extends
			UiBinder<Widget, EditClasspageView> {

	}
	/**
	 * Class constructor.
	 */
	@Inject
	public EditClasspageView() {
		this.res = EditClasspageCBundle.INSTANCE;
		collectionTitleUc = new AssignmentEditLabelUc() {

			@Override
			public void onEditDisabled(String text) {
				if (text.trim().length()>0){
					isEditing = false;
					btnCollectionEditImage.setVisible(false);
					titleAlertMessageLbl.setVisible(false);
					titleAlertMessageLbl.setText(MessageProperties.GL0143);
					titleAlertMessageLbl.addStyleName("titleAlertMessageDeActive");
					titleAlertMessageLbl.removeStyleName("titleAlertMessageActive");
	
	//				panelUpdateActionContols.setVisible(false);
					
					collectionDo.setTitle(text);
					getUiHandlers().updateClassPageInfo(getClasspageId(),
							collectionDo.getCollectionType(), text);
					AppClientFactory.fireEvent(new UpdateClasspageTitleEvent(classpageId, text));
					panelUpdateActionContols.getElement().getStyle().setDisplay(Display.NONE);
				}else{
					/*titleAlertMessageLbl.setText(MessageProperties.GL0173);
					titleAlertMessageLbl.setVisible(true);*/
				}
			}

			@Override
			public void checkCharacterLimit(String text) {
				titleAlertMessageLbl.setText(MessageProperties.GL0143);
				if (text.length() >= 50) {
					titleAlertMessageLbl
							.addStyleName("titleAlertMessageActive");
					titleAlertMessageLbl
							.removeStyleName("titleAlertMessageDeActive");
				} else {
					titleAlertMessageLbl
							.addStyleName("titleAlertMessageDeActive");
					titleAlertMessageLbl
							.removeStyleName("titleAlertMessageActive");
				}
			}
		/*	
			@Override
			public void checkEmptyTitle(String text){
				titleAlertMessageLbl.setText(MessageProperties.GL0143);
				if (text.length()<=0){
					titleAlertMessageLbl.setText(MessageProperties.GL0173);
					titleAlertMessageLbl.setVisible(true);
					return;
				}
			}*/
		};

		res.css().ensureInjected();

		setWidget(uiBinder.createAndBindUi(this));
		
		txtClasspageLinkShare.setEnabled(true);
		txtClasspageLinkShare.setReadOnly(true);
		
		txtClasspageCodeShare.setEnabled(true);
		txtClasspageCodeShare.setReadOnly(true);
		
		
		shareTabContainerPanel.clear();
		shareTabContainerPanel.setVisible(false);

		assignmentsContainerPanel.clear();

		noAssignmentsMessagePanel.setVisible(true);
		assignmentsTabContainerPanel.setVisible(true);
		assignmentsContainerPanel.setVisible(true);
		btnCollectionEditImage.setVisible(false);
		txtClasspageCodeShare.getElement().setId("txtClasspageCodeShare");
		txtClasspageLinkShare.getElement().setId("txtClasspageLinkShare");


//		panelUpdateActionContols.setVisible(false);
		panelUpdateActionContols.getElement().getStyle().setDisplay(Display.NONE);

		simplePencilFocPanel.addMouseOverHandler(new hideEditPencil());
		simplePencilFocPanel.addMouseOutHandler(new showEditPencil());

		btnCollectionEditImage.addClickHandler(new OnEditImageClick());
		classPageTitle.addClickHandler(new OnEditImageClick());
		collectionFloPanel.addDomHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				event.stopPropagation();

			}
		}, ClickEvent.getType());
		
		loadingPanel.setVisible(false);

		imgClasspageImage.addErrorHandler(new ErrorHandler() {
			
			@Override
			public void onError(ErrorEvent event) {
				imgClasspageImage.setUrl(DEFAULT_CLASSPAGE_IMAGE);
			}
		});
		
		collectionFloPanel.addMouseOverHandler(new MouseOverHandler() {
			
			@Override
			public void onMouseOver(MouseOverEvent event) {
				btnEditImage.getElement().getStyle().setVisibility(Visibility.VISIBLE);
			}
		});
		collectionFloPanel.addMouseOutHandler(new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
				btnEditImage.getElement().getStyle().setVisibility(Visibility.HIDDEN);
			}
		});
		btnEditImage.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				MixpanelUtil.ClickOnEditImage();
				getUiHandlers().showImageUploadWidget();
			}
		});
		
//		btnEditImage.addMouseOverHandler(new MouseOverHandler() {
//			
//			@Override
//			public void onMouseOver(MouseOverEvent event) {
//				btnEditImage.setVisible(true);
//			}
//		});
//		btnEditImage.addMouseOutHandler(new MouseOutHandler() {
//			
//			@Override
//			public void onMouseOut(MouseOutEvent event) {
//				btnEditImage.setVisible(false);
//			}
//		});
//		
		txtClasspageCodeShare.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				txtClasspageCodeShare.selectAll();
				txtClasspageCodeShare.setFocus(true);
			}
		});
		
		txtClasspageLinkShare.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				txtClasspageLinkShare.selectAll();
				txtClasspageLinkShare.setFocus(true);
			}
		});
		
		panelCode.setVisible(false);
		panelWebLink.setVisible(false);
		panelUpdateActionContols.getElement().setId("panelUpdateActionContols");
		
		btnEditImage.setText(MessageProperties.GL0138);
		btnStudentView.setText(MessageProperties.GL0139);
		btnCollectionEditImage.setText(MessageProperties.GL0140);
		btnClasspageSave.setText(MessageProperties.GL0141);
		btnClasspageCancel.setText(MessageProperties.GL0142);
		titleAlertMessageLbl.setText(MessageProperties.GL0143);
		btnNewAssignment.setText(MessageProperties.GL0144);
		btnDeleteClasspage.setText(MessageProperties.GL0145);
		noAssignmentsMessageLblOne.setText(MessageProperties.GL0146);
		noAssignmentsMessageLblTwo.setText(MessageProperties.GL0147);
		htmlShareText.setHTML(MessageProperties.GL0229 + MessageProperties.GL0230);
		lblPopupTitle.setText(MessageProperties.GL0230);
		lblOr.setText(MessageProperties.GL0209.toUpperCase());
		lblAWebLink.setText(MessageProperties.GL0231);
		lblWebLink.setText(MessageProperties.GL0232);
		htmlPopupTitleDesc.setHTML(MessageProperties.GL0233);
		htmlWebLinkTitleDesc.setHTML(MessageProperties.GL0234);
		
		btnEditImage.getElement().setId("btnEditImage");
		btnStudentView.getElement().setId("btnStudentView");
		btnCollectionEditImage.getElement().setId("btnCollectionEditImage");
		btnClasspageSave.getElement().setId("btnClasspageSave");
		btnClasspageCancel.getElement().setId("btnClasspageCancel");
		btnNewAssignment.getElement().setId("btnNewAssignment");
		btnDeleteClasspage.getElement().setId("btnDeleteClasspage");
		
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
	}
	/*
	 * This inner class will handle the mouse over event for the edit pencil.
	 */
	public class hideEditPencil implements MouseOverHandler {

		@Override
		public void onMouseOver(MouseOverEvent event) {
			
			if (!isEditing){
				btnCollectionEditImage.setVisible(true);
			}
		}

	}
	/*
	 * This inner class will handle the mouse out event for the edit pencil.
	 */
	public class showEditPencil implements MouseOutHandler {

		@Override
		public void onMouseOut(MouseOutEvent event) {
			btnCollectionEditImage.setVisible(false);
		}

	}
	/*
	 * This inner class will handle the click  event for the edit image .
	 */
	private class OnEditImageClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			// collectionEditImageLbl.setVisible(false);
			if (!isEditing){
				isEditing = true;
				btnCollectionEditImage.setVisible(false);
				collectionTitleUc.switchToEdit();

//				panelUpdateActionContols.setVisible(true);
				panelUpdateActionContols.getElement().getStyle().setDisplay(Display.INLINE);
			}

		}
	}
	/**
	 * GWTP will call setInSlot when a child presenter asks to be added under this view. 
	 */
	@Override
	public void setInSlot(Object slot, Widget content) {
		if (content != null) {
			if (slot == EditClasspageUiHandlers.TYPE_SHELF_TAB) {
				// shelfTabSimPanel.setWidget(content);
			}
		}
	}

	/* UI Click event handlers */	
//	@UiHandler("lblCodeHelp")
//	public void onClickCodeHelp(ClickEvent event){
//		panelCode.setVisible(!panelCode.isVisible());
//		
//	}
	/**
	 * @function onMourOver 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This will handle the Mouse over event of CodeHelp label.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("lblCodeHelp")
	public void onMourOver(MouseOverEvent event){
		panelCode.setVisible(true);
	}
	/**
	 * @function onMourOut 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This will handle the Mouse out event of CodeHelp label.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("lblCodeHelp")
	public void onMourOut(MouseOutEvent event){
		panelCode.setVisible(false);
	}
	/**
	 * @function onMourOver 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This will handle the Mouse over event of WebHelp label.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("lblWebHelp")
	public void onMouseOver(MouseOverEvent event){
		panelWebLink.setVisible(true);
	}
	/**
	 * @function onMouseOut 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This will handle the Mouse out event of WebHelp label.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("lblWebHelp")
	public void onMouseOut(MouseOutEvent event){
		panelWebLink.setVisible(false);
	}
	/**
	 * @function OnClickDeleteClasspage 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This will handle the click event of Delete class page button.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("btnDeleteClasspage")
	public void OnClickDeleteClasspage(ClickEvent event){
		deleteConfirmVc = new DeleteConfirmPopupVc("Are you sure?","\""+ collectionDo.getTitle() + "\"" + " Classpage.")  {
			
			@Override
			public void onTextConfirmed() {
				
				AppClientFactory.getInjector().getClasspageService().deleteClasspage(collectionDo.getGooruOid(), new SimpleAsyncCallback<Void>() {

					@Override
					public void onSuccess(Void result) {
						
						deleteConfirmVc.hide();
						Window.enableScrolling(true);
				        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
				        AppClientFactory.fireEvent(new DeleteClasspageListEvent(classpageId));
				        
					}
				});
			}
		};
	}
	/**
	 * @function OnClickStudentView 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description : This will handle the click event of Student view button.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("btnStudentView")
	public void OnClickStudentView(ClickEvent event){
		if(isClicked){
		isClicked=false;
		MixpanelUtil.Click_StudentView_Classpage();

		Map<String, String> params = new HashMap<String, String>();
		params.put("id", collectionDo.getGooruOid());
		params.put("b", "true");

		params.put("pageSize", "10");
		params.put("pageNum", "0");
		params.put("pos", "1");

		params.put("source", "E");
		Cookies.setCookie("pageSize", AppClientFactory.getPlaceManager()
				.getRequestParameter("pageSize"));
		Cookies.setCookie("classpageid", AppClientFactory.getPlaceManager()
				.getRequestParameter("classpageid"));
		Cookies.setCookie("pageNum", AppClientFactory.getPlaceManager()
				.getRequestParameter("pageNum"));
		Cookies.setCookie("pos", AppClientFactory.getPlaceManager()
				.getRequestParameter("pos"));

		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.STUDENT,
				params);
		
		}
	}
	/**
	 * 
	 * @function OnClickNewAssignment 
	 * 
	 * @created_date : 27-Dec-2013
	 * 
	 * @description :This will handle the click event of New Assignment button.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("btnNewAssignment")
	public void OnClickNewAssignment(ClickEvent event){
		MixpanelUtil.Click_Add_NewAssignment();
		Window.enableScrolling(false);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, false));
		getUiHandlers().addAssignmentsContainerPopup(getClasspageId());
	}

	/* Custom methods */
	/**
	 * This method is used to set the data.
	 */
	@Override
	public void setData(CollectionDo collectionDo) {
		try{
			this.collectionDo = collectionDo;
			Window.enableScrolling(true);
			AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
			if (collectionDo != null) {
				
				AppClientFactory.fireEvent(new SetSelectedClasspageListEvent(collectionDo.getGooruOid()));
				noAssignmentsMessagePanel.setVisible(false);
				loadingPanel.setVisible(true);
				collectionTitleUc.setText(collectionDo.getTitle() !=null ? collectionDo.getTitle() : "" );
				//collectionTitleUc.setText(collectionDo.getTitle());
				btnCollectionEditImage.setVisible(false);
				assignmentsContainerPanel.clear();
				assignmentsContainerPanel.setVisible(true);
				paginationFocPanel.clear();
				getUiHandlers().getAssignmentsByClasspageById(classpageId,
						pageSize + "", pageNum + "");
				getUiHandlers().generateShareLink(classpageId);
				imgClasspageImage.setUrl(collectionDo.getThumbnails().getUrl());
           
		    }
		}
         catch(Exception e){
        	 
         }
	}
	/**
	 * This method is used to set the Assignment data.
	 */
	@Override
	public void setAssignmentData(AssignmentsSearchDo assignmentsSearchDo,
			boolean isExpandable) {
		insertAssignment(assignmentsSearchDo, true, isExpandable);
	}
	/**
	 * This method is used to get the class page By it's Id.
	 */
	@Override
	public void getClasspageById(String classpageId, String pageSize,
			String pageNum, String pos) {
		this.pageNum = Integer.parseInt(pageNum);
		this.pageSize = Integer.parseInt(pageSize);
		this.pos = Integer.parseInt(pos);
		getUiHandlers().getClasspageById(classpageId);
	}
	/**
	 * 
	 * @function insertAssignment 
	 * 
	 * @created_date : Aug 17, 2013
	 * 
	 * @description : This method is used to insert the assignment.
	 * 
	 * @parm(s) : @param assignmentsSearchDo
	 * @parm(s) : @param isNew
	 * @parm(s) : @param isExpandable
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 */
	public void insertAssignment(AssignmentsSearchDo assignmentsSearchDo,
			boolean isNew, boolean isExpandable) {
		noAssignmentsMessagePanel.setVisible(false);
		assignmentTabView = new AssignmentsTabView(assignmentsSearchDo, isExpandable);
		assignmentsContainerPanel.add(assignmentTabView);
		
	}

	/**
	 * Set shorten url of the collection view url
	 * 
	 * @param shortenUrl
	 *            to be set in shorten url UI field
	 */
	@Override
	public void setShareUrl(Map<String, String> shortenUrl) {
		if (shortenUrl != null && shortenUrl.containsKey(SHORTEN_URL)) {
			txtClasspageCodeShare.setText(collectionDo.getClasspageCode().toUpperCase());
			txtClasspageLinkShare.setText(shortenUrl.get(SHORTEN_URL));
		}
	}

	/* Setter and getters */
	/**
	 * This method is to get the collectionItemList
	 */
	public List<CollectionItemDo> getCollectionItemList() {
		return collectionItemList;
	}

	/**
	 * This method is to set the collectionItemList
	 */
	public void setCollectionItemList(List<CollectionItemDo> collectionItemList) {
		this.collectionItemList = collectionItemList;
	}

	/**
	 * This method is to get the classpageId
	 */
	public String getClasspageId() {
		return classpageId;
	}

	/**
	 * This method is to set the classpageId
	 */
	public void setClasspageId(String classpageId) {
		this.classpageId = classpageId;
	}
	/**
	 * This method is used to handle the pagination.
	 */
	@Override
	public void onClick(ClickEvent event) {
		if (event.getSource() instanceof PaginationButtonUc) {
			int pagenumber = ((PaginationButtonUc) event.getSource()).getPage();

			pageNum = (pagenumber - 1) * pageSize;

			AssignmentsListDo assignmentListDo = new AssignmentsListDo();
			assignmentListDo.setClasspageId(classpageId);
			assignmentListDo.setPageNum(pageNum);
			assignmentListDo.setPageSize(pageSize);
			assignmentListDo.setPos(pagenumber);

			Map<String, String> params = new HashMap<String, String>();
			params.put("classpageid", collectionDo.getGooruOid());
			params.put("pageSize", pageSize + "");
			params.put("pageNum", pageNum + "");
			params.put("pos", pagenumber + "");
			AppClientFactory.getPlaceManager().revealPlace(
					PlaceTokens.EDIT_CLASSPAGE, params, true);

		} else {
		}
	}
	/**+
	 * This method is used to delete the Assignment.
	 */
	public void onDeleteAssignment(boolean isPostDeleteAssignment) {
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));

		Map<String, String> params = new HashMap<String, String>();
		params.put("classpageid", collectionDo.getGooruOid());
		params.put("pageSize", pageSize + "");
	if (assignmentsContainerPanel.getWidgetCount() == 1
				&& isPostDeleteAssignment) {
			pageNum = pageNum == 0 ? 0 : pageNum - 10;
					params.put("pageNum", pageNum + "");
			params.put("pos", pos + "");
	}
		else {
			pageNum = isPostDeleteAssignment ? pageNum : 0;
			params.put("pageNum", pageNum + "");
			if(pageNum==0){
			    params.put("pos", START_PAGE);
			}else{
				params.put("pos", pos + "");
			}
		}
		AppClientFactory.getPlaceManager().revealPlace(
				PlaceTokens.EDIT_CLASSPAGE, params, true);
	}
	/**
	 * This method is used to get the assignment by classpageId
	 */
	@Override
	public void getAssignemntsByClasspageId(String classpageId,
			String pageSize, String pageNum) {
		getUiHandlers().getAssignmentsByClasspageById(classpageId, pageSize,
				pageNum);
	}
	/**
	 * This method is used to list all the Assignments.
	 */
	@Override
	public void listAssignments(AssignmentsListDo result) {
		assignmentsContainerPanel.clear();
		isClicked=true;
		if (result.getSearchResults().size() > 0) {
			for (int i = 0; i < result.getSearchResults().size(); i++) {
				boolean isDisplay = i == 0 ? true : false;
				insertAssignment(result.getSearchResults().get(i), false,
						isDisplay);
			}
			
			loadingPanel.setVisible(false);
			paginationFocPanel.clear();
			assignmentCount = (result.getTotalHitCount() / pageSize)
					+ ((result.getTotalHitCount() % pageSize) > 0 ? 1 : 0);

			if (assignmentCount > 1) {
				if (pos > 1) {
					paginationFocPanel.add(new PaginationButtonUc(pos - 1,
							PREVIOUS, this));
				}
				int page = pos < 10 ? 1 : pos - 10;
				for (int count = 0; count < 10 && page <= assignmentCount; page++, ++count) {
					paginationFocPanel.add(new PaginationButtonUc(page,
							page == pos, this));
				}
				if (pos < assignmentCount) {
					paginationFocPanel.add(new PaginationButtonUc(pos + 1,
							NEXT, this));
				}
			}
		} else if(result.getTotalHitCount()==0) {
			noAssignmentsMessagePanel.setVisible(true);
			loadingPanel.setVisible(false);
		}
		else
		{
			noAssignmentsMessagePanel.setVisible(false);
			loadingPanel.setVisible(false);
		}

	}

	/**
	 * This method is used to clear all the panels.
	 */
	@Override
	public void clearPanel() {
		assignmentsContainerPanel.clear();
		paginationFocPanel.clear();
		noAssignmentsMessagePanel.setVisible(true);
	}
	/**
	 * This method is used to update the title
	 */
	@Override
	public void onPostClassPageUpdate() {
		titleAlertMessageLbl.setText(MessageProperties.GL0143);
		titleAlertMessageLbl.setVisible(false);
		titleAlertMessageLbl.removeStyleName("titleAlertMessageActive");
		final CollectionDo classpage = null;
		AppClientFactory.fireEvent(new RefreshClasspageResourceItemListEvent(
				classpage, RefreshType.UPDATE));

	}
	/**
	 * This handler is used to update and save title
	 * @param event instance of ClickEvent
	 */
	@UiHandler("btnClasspageSave")
	public void clickedOneditSelfCollectionSaveButton(ClickEvent event) {
		
		//isEditing = false;
		
		titleAlertMessageLbl.setText(MessageProperties.GL0143);
		titleAlertMessageLbl.setVisible(true);
		//panelUpdateActionContols.getElement().getStyle().setDisplay(Display.NONE);
		
//		classPageSaveButton.getElement().getStyle().setDisplay(Display.NONE);
//		classPageSaveButtonCancel.getElement().getStyle().setDisplay(Display.NONE);
		
		collectionTitleUc.switchToLabel();
	}
	/**
	 * This handler is used to cancel the title update 
	 * @param event instance of ClickEvent
	 */
	@UiHandler("btnClasspageCancel")
	public void clickedOnclassPageSaveButtonCancel(ClickEvent event) {
		
		isEditing = false;
		titleAlertMessageLbl.setVisible(false);
		titleAlertMessageLbl.setText(MessageProperties.GL0143);
		titleAlertMessageLbl.addStyleName("titleAlertMessageDeActive");
		titleAlertMessageLbl.removeStyleName("titleAlertMessageActive");
//		panelUpdateActionContols.setVisible(false);
		panelUpdateActionContols.getElement().getStyle().setDisplay(Display.NONE);

		collectionTitleUc.cancel();

	}
	/**
	 * This method is used to display the uploaded image.
	 */
	@Override
	public void setUploadedImageToClassPage(String url) {
		MixpanelUtil.SuccessfullyAddtheImageFromClasspage();
		imgClasspageImage.setUrl(url+"?p="+Math.random());
	}
	/**
	 * This method is used to close the popup.
	 */
	@Override
	public void closeAllOpenedPopUp() {
		if(deleteConfirmVc!=null){
			deleteConfirmVc.hide();
		}
		if(assignmentTabView!=null){
			assignmentTabView.getPresenter().getView().closeAllOpenedPopUp();
		}
		
	}
	
	
}
