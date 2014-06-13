/**
 * 
 */
package org.ednovo.gooru.client.mvp.classpages.edit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.DataInsightsUrlTokens;
import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.classpages.classlist.ClassListPresenter;
import org.ednovo.gooru.client.mvp.classpages.event.DeleteClasspageListEvent;
import org.ednovo.gooru.client.mvp.classpages.event.RefreshClasspageResourceItemListEvent;
import org.ednovo.gooru.client.mvp.classpages.event.SetSelectedClasspageListEvent;
import org.ednovo.gooru.client.mvp.classpages.event.UpdateClasspageTitleEvent;
import org.ednovo.gooru.client.mvp.classpages.newclasspage.NewClasspagePopupView;
import org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections.CollectionsView;
import org.ednovo.gooru.client.mvp.search.event.ResetProgressEvent;
import org.ednovo.gooru.client.mvp.search.event.ResetProgressHandler;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.DeleteConfirmPopupVc;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignCBundle;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.vc.DeletePopupViewVc;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshType;
import org.ednovo.gooru.client.uc.AssignmentEditLabelUc;
import org.ednovo.gooru.client.uc.PaginationButtonUc;
import org.ednovo.gooru.client.uc.tooltip.GlobalToolTip;
import org.ednovo.gooru.client.uc.tooltip.ToolTip;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.content.AssignmentsListDo;
import org.ednovo.gooru.shared.model.content.AssignmentsSearchDo;
import org.ednovo.gooru.shared.model.content.ClasspageDo;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

/**
 * @fileName : EditClasspageView.java
 * 
 * @description :
 * 
 * 
 * @version : 1.0
 * 
 * @date: Apr 17, 2013
 * 
 * @Author Anil Kumar T
 * 
 * @Reviewer:
 */
public class EditClasspageView extends
		BaseViewWithHandlers<EditClasspageUiHandlers> implements
		IsEditClasspageView, ClickHandler, MessageProperties {
	
	@UiField(provided = true)
	EditClasspageCBundle res;

	@UiField(provided = true)
	AssignmentEditLabelUc collectionTitleUc;
	
	ArrayList<ClasspageItemDo> globalClasspageProcess;
	
	ArrayList<ClasspageItemDo> classpageItemsList = new ArrayList<ClasspageItemDo>();
	
	/** 
	 * This method is to get the globalClasspageProcess
	 */
	@Override
	public ArrayList<ClasspageItemDo> getGlobalClasspageProcess() {
		return globalClasspageProcess;
	}
	/** 
	 * This method is to set the globalClasspageProcess
	 */
	public void setGlobalClasspageProcess(
			ArrayList<ClasspageItemDo> globalClasspageProcess) {
		this.globalClasspageProcess = globalClasspageProcess;
	}

	private PopupPanel toolTipPopupPanelNew = new PopupPanel();
	
/*	@UiField TextBox  txtClasspageLinkShare; */
	
	/*@UiField HTML htmlWebLinkTitleDesc;*/
	
	@UiField Label noAssignmentsMessageLblTwo,assignmentsDirectionsLabel, lblAssignmentProgress,lblInstructionalPlaceHolder,lblInstructionalArrow;
	
	@UiField Image imgClasspageImage;
	
	@UiField FlowPanel mainFlowPanel;

	@UiField HTMLPanel panelUpdateActionContols, panelAssignmentProgress, panelAssignmentPath,htmlInstructionalListContainer;
	
	@UiField ScrollPanel spanelInstructionalPanel;

	@UiField
	static HTMLPanel frameDiv;

	@UiField
	static HTMLPanel mainContainer;
	
	@UiField
	static Frame frameUrl;
	
	@UiField Label titleAlertMessageLbl, lblNext, lblPrevious;

	@UiField Button btnStudentView;

	@UiField
	static Button monitorProgress;

	@UiField
	static
	Button backArrowButton;

	@UiField
	Button btnCollectionEditImage;

	@UiField
	Button btnEditImage;

	@UiField
	Button btnNewAssignment;

	@UiField
	Button assignmentsTab;

	@UiField
	Button classListTab,reportsTab;
	
	@UiField HTMLPanel shareTabContainerPanel, assignmentsTabContainerPanel, noAssignmentsMessagePanel, newAssignmentAndMsgPanel;

	@UiField FlowPanel paginationFocPanel,assignmentsContainerPanel,classListContainer;

/*	@UiField HTMLPanel panelWebLink;*/

	@UiField FocusPanel simplePencilFocPanel, classPageTitle,collectionFloPanel;
	
	@UiField Button btnClasspageCancel, btnClasspageSave, btnDeleteClasspage;
	
	@UiField TextBox classCodeTextBox;
	
	@UiField HTMLPanel questionMarkPanel;

	NewClasspagePopupView newPopup = null;
	private  ClasspageDo classpageDo =null;

	private HandlerRegistration reportHandler;
	private HandlerRegistration reportMouseOverHandler;
	
	DeleteConfirmPopupVc deleteConfirmVc =null;
	
	boolean isEditing=false;
	
	boolean isClicked=true;
	
	boolean refresh = true;
	
	private String DEFAULT_CLASSPAGE_IMAGE = "images/Classpage/default-classpage.png";
	
	private String classpageId = null;

	private static final String SHORTEN_URL = "shortenUrl";

	private static final String PREVIOUS = "PREVIOUS";

	private static final String NEXT = "NEXT";
	
	private CollectionsView assignmentTabView;

	private int pageSize = 5;

	private int pageNum = 0;

	private Integer offsetProgress=0;
	private Integer limitProgress=30;
	
	private int pos = 0;

	int noOfItems = 5;

	private int assignmentCount = 0;
	
	private int totalHitCount=0;
	private int limit=5;
	private int pageNumber=1;
	
	String dropSortOptionsStr = GL1947;
	
	@UiField HTMLPanel droplistContianer;

	private final String START_PAGE = "1";
	ToolTip toolTip = null;
	
	ClassListPresenter classlistPresenter;
	
	List<CollectionItemDo> collectionItemList = new ArrayList<CollectionItemDo>();

	private static EditClassPageViewUiBinder uiBinder = GWT
			.create(EditClassPageViewUiBinder.class);

	interface EditClassPageViewUiBinder extends
			UiBinder<Widget, EditClasspageView> {

	}

	@Inject
	public EditClasspageView() {
		this.res = EditClasspageCBundle.INSTANCE;
		globalClasspageProcess =  new ArrayList<ClasspageItemDo>(); 
		collectionTitleUc = new AssignmentEditLabelUc() {
			@Override
			public void onEditDisabled(String text) {
				if (text.trim().length()>0){
					isEditing = false;
					btnCollectionEditImage.setVisible(false);
					titleAlertMessageLbl.setVisible(false);
					titleAlertMessageLbl.setText(GL0143);
					titleAlertMessageLbl.addStyleName("titleAlertMessageDeActive");
					titleAlertMessageLbl.removeStyleName("titleAlertMessageActive");
					//panelUpdateActionContols.getElement().getStyle().setDisplay(Display.NONE);
		            getUiHandlers().updateClassPageInfo(classpageDo.getClasspageId(),null, text);
					AppClientFactory.fireEvent(new UpdateClasspageTitleEvent(classpageDo.getClasspageId(), text));
				}else{
					/*titleAlertMessageLbl.setText(MessageProperties.GL0173);
					titleAlertMessageLbl.setVisible(true);*/
				}
			}

			@Override
			public void checkCharacterLimit(String text) {
				titleAlertMessageLbl.setText(GL0143);
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
		
		CollectionAssignCBundle.INSTANCE.css().ensureInjected();
		
		mainContainer.setVisible(true);
		droplistContianer.setVisible(true);

		frameDiv.setVisible(false);
		/*txtClasspageLinkShare.setEnabled(true);
		txtClasspageLinkShare.setReadOnly(true);
		*/
		/*txtClasspageCodeShare.setEnabled(true);
		txtClasspageCodeShare.setReadOnly(true);
		*/
		assignmentsTab.addClickHandler(new AssignmentsTabClicked());
		classListTab.addClickHandler(new ClassListTabClicked());
		
			
		shareTabContainerPanel.clear();
		shareTabContainerPanel.setVisible(false);

		panelAssignmentPath.setVisible(true);
		noAssignmentsMessagePanel.setVisible(false);
		assignmentsTabContainerPanel.setVisible(true);
		btnCollectionEditImage.setVisible(false);
		
		lblInstructionalPlaceHolder.setText(GL1946);
		
		/*txtClasspageCodeShare.getElement().setId("txtClasspageCodeShare");*/
		/*txtClasspageLinkShare.getElement().setId("txtClasspageLinkShare");
*/

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
		
		lblInstructionalArrow.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				OpenInstructionalDropdown();	
			}
		});
		
		backArrowButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			mainContainer.setVisible(true);
			frameDiv.setVisible(false);
			
			assignmentsTab.addStyleName(res.css().selected());

			classListTab.getElement().setClassName("");
			
			reportsTab.getElement().setClassName("");
			
			newAssignmentAndMsgPanel.setVisible(true);
			assignmentsTabContainerPanel.setVisible(true);
			getClassListContainer().setVisible(false);

		
				Map<String,String> params = new HashMap<String,String>();
				String pageSize=AppClientFactory.getPlaceManager().getRequestParameter("pageSize", null);
				String classpageid=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
				String pageNum=AppClientFactory.getPlaceManager().getRequestParameter("pageNum", null);
				String pos=AppClientFactory.getPlaceManager().getRequestParameter("pos", null);
				params.put("pageSize", pageSize);
				params.put("classpageid", classpageid);
				params.put("pageNum", pageNum);
				params.put("pos", pos);
				PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.EDIT_CLASSPAGE, params);
				if(refresh){
					AppClientFactory.getPlaceManager().revealPlace(true, placeRequest, true);
					refresh = false;
				}else{
					AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
				}
				
			}
			
			
				
			
		});
		
		monitorProgress.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				backArrowButton.setVisible(true);
				monitorProgress.setVisible(true);
			mainContainer.setVisible(false);
			frameDiv.setVisible(true);
			if(monitorProgress.getText().equalsIgnoreCase(GL1586)){
				frameUrl.setUrl(frameAnalyticsUrlForMonitor());
				monitorProgress.setText(GL1587);
		    }else{
		    	frameUrl.setUrl(frameAnalyticsUrl());
		    	monitorProgress.setText(GL1586);
		    }
			
				
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
/*//		
		txtClasspageCodeShare.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				txtClasspageCodeShare.selectAll();
				txtClasspageCodeShare.setFocus(true);
			}
		});*/
		
		/*txtClasspageLinkShare.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				txtClasspageLinkShare.selectAll();
				txtClasspageLinkShare.setFocus(true);
			}
		});*/
		
		/*//panelCode.setVisible(false);
		panelWebLink.setVisible(false);*/
		
		
		
		panelUpdateActionContols.getElement().setId("panelUpdateActionContols");
		
		btnEditImage.setText(GL0138);
		btnStudentView.setText(GL0139);
		btnCollectionEditImage.setText(GL0140);
		btnClasspageSave.setText(GL0141);
		btnClasspageCancel.setText(GL0142);
		titleAlertMessageLbl.setText(GL0143);
		btnNewAssignment.setText(GL0144);
		btnDeleteClasspage.setText(GL0145);
		//noAssignmentsMessageLblTwo.setText(GL0147);
		backArrowButton.setText(GL1617);
		monitorProgress.setText(GL1586);
		assignmentsTab.setText(GL1623);
		classListTab.setText(GL1624);
		reportsTab.setText(GL1737);
		assignmentsDirectionsLabel.setText(GL1945);
		
		spanelInstructionalPanel.setVisible(false);
		
		lblPrevious.setVisible(false);

		lblAssignmentProgress.setText(GL1891_1);
		
		//htmlShareText.setHTML(GL0229 + GL0230);
		//lblPopupTitle.setText(GL0230);
	/*	lblOr.setText(GL0209.toUpperCase());
		lblAWebLink.setText(GL0231);
		lblWebLink.setText(GL0232);
		//htmlPopupTitleDesc.setHTML(GL0233);
		htmlWebLinkTitleDesc.setHTML(GL0234);*/
		
		backArrowButton.getElement().setId("backArrowButton");
		
		btnEditImage.getElement().setId("btnEditImage");
		btnStudentView.getElement().setId("btnStudentView");
		btnCollectionEditImage.getElement().setId("btnCollectionEditImage");
		btnClasspageSave.getElement().setId("btnClasspageSave");
		btnClasspageCancel.getElement().setId("btnClasspageCancel");
		btnNewAssignment.getElement().setId("btnNewAssignment");
		btnDeleteClasspage.getElement().setId("btnDeleteClasspage");
		
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		reportHandler=reportsTab.addClickHandler(new reportsTabClicked());
		//AppClientFactory.getEventBus().addHandler(GetStudentJoinListEvent.TYPE, getStudentJoinListHandler);
		
		
		lblNext.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				offsetProgress = offsetProgress +limitProgress;
				
				callAssignmentAPI(AppClientFactory.getPlaceManager().getRequestParameter("classpageid"), offsetProgress.toString(), limitProgress.toString());
			}
		});
		
		List<String> sortOptionsList = Arrays.asList(dropSortOptionsStr.split(","));
		
		for(int k=0; k<sortOptionsList.size(); k++)
		{
			String sortTitle = sortOptionsList.get(k);			
			final Label titleLabel = new Label(sortTitle);
			titleLabel.setStyleName(CollectionAssignCBundle.INSTANCE.css().classpageTitleText());
			titleLabel.getElement().setAttribute("id", sortTitle);
			
			titleLabel.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {		
					String optionSelected = titleLabel.getElement().getId();
					lblInstructionalPlaceHolder.setText(optionSelected);
					spanelInstructionalPanel.setVisible(false);
					lblInstructionalPlaceHolder.getElement().setId(titleLabel.getElement().getId());
					lblInstructionalPlaceHolder.setStyleName(CollectionAssignCBundle.INSTANCE.css().selectedClasspageText());
					
	


						lblInstructionalPlaceHolder.setText(optionSelected);
			
				}
			});
			
			htmlInstructionalListContainer.add(titleLabel);
		}
		
		
//		lblPrevious.addClickHandler(new ClickHandler() {
//			
//			@Override
//			public void onClick(ClickEvent event) {
//				if (offsetProgress <=0){
//					offsetProgress =0;
//				}else{
//					offsetProgress = offsetProgress - limitProgress;
//				}
//				callAssignmentAPI(AppClientFactory.getPlaceManager().getRequestParameter("classpageid"), offsetProgress.toString(), limitProgress.toString());
//			}
//		});
		
		
		ResetProgressHandler reset = new ResetProgressHandler() {

			@Override
			public void callProgressAPI() {
				callAssignmentAPI(AppClientFactory.getPlaceManager().getRequestParameter("classpageid"), offsetProgress.toString(), limitProgress.toString());
			}
		};
		AppClientFactory.getEventBus().addHandler(ResetProgressEvent.TYPE,
				reset);
	}
	/**
	 * 
	 * @function callAssignmentAPI 
	 * 
	 * @created_date : Jun 11, 2014
	 * 
	 * @description
	 * 
	 * 
	 * @param classpageId
	 * @param pageSize
	 * @param pageNum
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	@Override
	public void callAssignmentAPI(String classpageId, String offsetProgress, String limitProgress){
		getUiHandlers().getAssignmentsProgress(classpageId, offsetProgress.toString(), limitProgress.toString()); // this will call displayAssignmentPath
	}
	
	private void OpenInstructionalDropdown() {
		
		if (spanelInstructionalPanel.isVisible()){
			spanelInstructionalPanel.setVisible(false);
		}else{
			spanelInstructionalPanel.setVisible(true);
		}
		
		
	}
	
	
	/**
	 * 
	 * @fileName : EditClasspageView.java
	 *
	 * @description : 
	 *
	 *
	 * @version : 1.0
	 *
	 * @date: Jun 11, 2014
	 *
	 * @Author Gooru Team
	 *
	 * @Reviewer:
	 */
	public class hideEditPencil implements MouseOverHandler {

		@Override
		public void onMouseOver(MouseOverEvent event) {
			
			if (!isEditing){
				btnCollectionEditImage.setVisible(true);
			}
		}

	}

	public class showEditPencil implements MouseOutHandler {

		@Override
		public void onMouseOut(MouseOutEvent event) {
			btnCollectionEditImage.setVisible(false);
		}

	}

	private class OnEditImageClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			if (!isEditing){
				isEditing = true;
				btnCollectionEditImage.setVisible(false);
				collectionTitleUc.switchToEdit();
				panelUpdateActionContols.getElement().getStyle().setDisplay(Display.BLOCK);
			}

		}
	}

	@Override
	public void setInSlot(Object slot, Widget content) {
		if (content != null) {
			if (slot == EditClasspageUiHandlers.TYPE_SHELF_TAB) {
				// shelfTabSimPanel.setWidget(content);
			}else if(slot==EditClasspagePresenter.CLASSLIST_SLOT){
				getClassListContainer().setVisible(true);
				getClassListContainer().add(content);
			}else{
				getClassListContainer().setVisible(false);
			}
		}
	}

	/* UI Click event handlers */	
//	@UiHandler("lblCodeHelp")
//	public void onClickCodeHelp(ClickEvent event){
//		panelCode.setVisible(!panelCode.isVisible());
//		
//	}
	/*@UiHandler("lblCodeHelp")
	public void onMourOver(MouseOverEvent event){
		panelCode.setVisible(true);
	}
	@UiHandler("lblCodeHelp")
	public void onMourOut(MouseOutEvent event){
		panelCode.setVisible(false);
	}*/
	
/*	@UiHandler("lblWebHelp")
	public void onMouseOver(MouseOverEvent event){
		panelWebLink.setVisible(true);
	}
	
	@UiHandler("lblWebHelp")
	public void onMouseOut(MouseOutEvent event){
		panelWebLink.setVisible(false);
	}*/
	
	@UiHandler("btnDeleteClasspage")
	public void OnClickDeleteClasspage(ClickEvent event){
		Window.enableScrolling(false);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
		DeletePopupViewVc delete = new DeletePopupViewVc() {

			@Override
			public void onClickPositiveButton(ClickEvent event) {
				AppClientFactory.getInjector().getClasspageService().deleteClasspage(classpageDo.getClasspageId(), new SimpleAsyncCallback<Void>() {

					@Override
					public void onSuccess(Void result) {
						Window.enableScrolling(true);
				        AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
				        AppClientFactory.fireEvent(new DeleteClasspageListEvent(classpageDo.getClasspageId()));
				        Window.enableScrolling(true);
						AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
						hide(); 
					}
				});
				
			}

			@Override
			public void onClickNegitiveButton(ClickEvent event) {
				// TODO Auto-generated method stub
				Window.enableScrolling(true);
				AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
				hide();
				
			}
			
		};
		delete.setPopupTitle((GL0748));
		delete.setNotes(GL0748);
		delete.setDescText(StringUtil.generateMessage(GL0824+"\""+ classpageDo.getTitle() + "\"" + " "+GL0102+GL_SPL_FULLSTOP +" "+GL0825));
		delete.setPositiveButtonText(GL0190);						
		delete.setNegitiveButtonText(GL0142);
		delete.setDeleteValidate("delete");
		delete.setPixelSize(450, 345);	
		delete.show();
		delete.center();
	}

	@UiHandler("btnStudentView")
	public void OnClickStudentView(ClickEvent event){
		MixpanelUtil.Click_StudentView_Classpage();

		Map<String, String> params = new HashMap<String, String>();
		params.put("id", classpageDo.getClasspageId());
		params.put("b", "true");

		params.put("pageSize", "5");
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

	@UiHandler("btnNewAssignment")
	public void OnClickNewAssignment(ClickEvent event){
		MixpanelUtil.Click_Add_NewAssignment();
		Window.enableScrolling(false);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, false));
		getUiHandlers().addAssignmentsContainerPopup(getClasspageId());
	}
	
	public void setClasspageData(ClasspageDo classpageDo){
		this.classpageDo=classpageDo;
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		AppClientFactory.fireEvent(new SetSelectedClasspageListEvent(classpageDo.getClasspageId()));
		panelAssignmentPath.setVisible(true);
		noAssignmentsMessagePanel.setVisible(false);
		collectionTitleUc.setText(classpageDo.getTitle() !=null ? classpageDo.getTitle() : "" );
		
		classCodeTextBox.setText(classpageDo.getClasspageCode()!=null ? classpageDo.getClasspageCode().toUpperCase() : "");
		classCodeTextBox.setReadOnly(true);
		classCodeTextBox.addClickHandler(new ClassCodeTextCopy());

		final Image imgNotFriendly = new Image("images/mos/questionmark.png");
		imgNotFriendly.getElement().getStyle().setLeft(97.8, Unit.PCT);
		imgNotFriendly.getElement().getStyle().setTop(27, Unit.PX);
		imgNotFriendly.getElement().getStyle().setPosition(Position.ABSOLUTE);
		imgNotFriendly.getElement().getStyle().setCursor(Cursor.POINTER);
		imgNotFriendly.addMouseOverHandler(new MouseOverShowClassCodeToolTip());
		imgNotFriendly.addMouseOutHandler(new MouseOutHideToolTip());

		questionMarkPanel.clear();
		questionMarkPanel.add(imgNotFriendly);
		
		imgClasspageImage.setAltText(classpageDo.getTitle());
		imgClasspageImage.setTitle(classpageDo.getTitle());
		btnCollectionEditImage.setVisible(false);
		imgClasspageImage.setUrl(classpageDo.getThumbnailUrl().isEmpty() ? DEFAULT_CLASSPAGE_IMAGE : classpageDo.getThumbnailUrl());
		//txtClasspageCodeShare.setText(classpageDo.getClasspageCode().toUpperCase());
	}
	
	public class ClassCodeTextCopy implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			classCodeTextBox.selectAll();
			classCodeTextBox.setFocus(true);
		}
		
	}
	public void showClasspageItems(ArrayList<ClasspageItemDo> classpageItemsList1,String tab, String analyticsId, String monitorId,ClassListPresenter classlistPresenter){
		this.classlistPresenter = classlistPresenter;

		classpageItemsList.clear();
		classpageItemsList.addAll(classpageItemsList1);
		if(tab!=null && tab.equalsIgnoreCase("classList")){
			panelAssignmentPath.setVisible(false);
			paginationFocPanel.setVisible(false);
			classListTab.addStyleName(res.css().selected());
			assignmentsTab.getElement().setClassName("");
			assignmentsDirectionsLabel.setVisible(false);
			backArrowButton.setVisible(false);
			monitorProgress.setVisible(false);
			newAssignmentAndMsgPanel.setVisible(false);
			assignmentsTabContainerPanel.setVisible(false);
			getClassListContainer().setVisible(true);
			frameDiv.setVisible(false);
			
			
			
		}
		else if(tab!=null && tab.equalsIgnoreCase("reports")){
			reportsTab.addStyleName(res.css().selected());
			assignmentsTab.getElement().setClassName("");
			classListTab.getElement().setClassName("");
			newAssignmentAndMsgPanel.setVisible(false);
			assignmentsTabContainerPanel.setVisible(false);
			getClassListContainer().setVisible(false);
			assignmentsDirectionsLabel.setVisible(false);
			backArrowButton.setVisible(false);
			monitorProgress.setVisible(false);
			panelAssignmentPath.setVisible(false);
			paginationFocPanel.setVisible(false);
			
			frameDiv.setVisible(true);
			frameUrl.getElement().getStyle().setWidth(1000, Unit.PX);
			frameUrl.getElement().getStyle().setHeight(300, Unit.PX);
			frameUrl.setUrl(frameReportsUrl());
			
		}
		else if(analyticsId!=null)
		{
			backArrowButton.setVisible(true);
			monitorProgress.setVisible(true);
			mainContainer.setVisible(false);
			frameDiv.setVisible(true);
			frameUrl.getElement().getStyle().setWidth(1000, Unit.PX);
			frameUrl.getElement().getStyle().setHeight(484, Unit.PX);
			frameUrl.setUrl(frameAnalyticsUrl());
			monitorProgress.setVisible(true);
			monitorProgress.setText(GL1586);
			panelAssignmentPath.setVisible(false);
			paginationFocPanel.setVisible(false);
		}
		else if(monitorId!=null)
		{
			backArrowButton.setVisible(true);
			monitorProgress.setVisible(true);
			mainContainer.setVisible(false);
			frameDiv.setVisible(true);
			frameUrl.getElement().getStyle().setWidth(1000, Unit.PX);
			frameUrl.getElement().getStyle().setHeight(484, Unit.PX);
			frameUrl.setUrl(frameAnalyticsUrlForMonitor());
			monitorProgress.setVisible(true);
			monitorProgress.setText(GL1587);
			panelAssignmentPath.setVisible(false);
			paginationFocPanel.setVisible(false);
		}
		else{
			
			removeLoadingPanel();
			panelAssignmentPath.setVisible(true);
			paginationFocPanel.setVisible(true);
			backArrowButton.setVisible(false);
			monitorProgress.setVisible(false);
			mainContainer.setVisible(true);
			frameUrl.getElement().getStyle().clearWidth();
			frameUrl.getElement().getStyle().clearHeight();
			frameDiv.setVisible(false);
			monitorProgress.setText("");
			monitorProgress.setVisible(false);
			assignmentsDirectionsLabel.setVisible(false);
			if(classpageItemsList!=null&&classpageItemsList.size()>0){
				assignmentsContainerPanel.clear();
				for(int itemIndex=0;itemIndex<classpageItemsList.size();itemIndex++){
					ClasspageItemDo classpageItemDo=classpageItemsList.get(itemIndex);
					assignmentTabView = showClasspageItem(classpageItemDo,(itemIndex+1));
					this.totalHitCount=classpageItemDo.getTotalHitCount();
					assignmentsContainerPanel.add(assignmentTabView);
				}
//				displayAssignmentPath(classpageItemsList1);
				setPagination();
			}else{
				panelAssignmentPath.setVisible(false);
				assignmentsDirectionsLabel.setVisible(true);
				noAssignmentsMessagePanel.setVisible(true);
				droplistContianer.setVisible(false);
			}
			getClassListContainer().setVisible(false);
		}
	}
	public CollectionsView showClasspageItem(ClasspageItemDo classpageItemDo,int sequenceNum){
		CollectionsView assignmentCollectionView = new CollectionsView(classpageItemDo,sequenceNum){
			public void resetPagination(){
				setPagination();
				if((pageNumber*limit)<totalHitCount){
					assignmentsContainerPanel.add(setLoadingPanel());
					getUiHandlers().getNextClasspageItems(((pageNumber*limit)-1),1);
				}else{
					totalHitCount--;
					setPagination();
					if(totalHitCount==0){
						panelAssignmentPath.setVisible(false);
						assignmentsDirectionsLabel.setVisible(true);
						noAssignmentsMessagePanel.setVisible(true);
						droplistContianer.setVisible(false);
					}
				}
			}
		};
		return assignmentCollectionView;
	}
	
	public void setClasspageItemOnTop(ClasspageItemDo classpageItemDo){
		assignmentTabView = showClasspageItem(classpageItemDo,1);                             //TODO refresh the sequence....
		totalHitCount++;
		assignmentsContainerPanel.insert(assignmentTabView,0);
		panelAssignmentPath.setVisible(true);
		assignmentsDirectionsLabel.setVisible(false);
		noAssignmentsMessagePanel.setVisible(false);
		droplistContianer.setVisible(true);
		if(assignmentsContainerPanel.getWidgetCount()>limit){
			assignmentsContainerPanel.remove(assignmentsContainerPanel.getWidgetCount()-1);
		}
		setPagination();
		
	}
	
	public void setPagination(){
		if(this.totalHitCount>5){
			showPaginationButton();
		}else{
			clearPaginationButton();
		}
	}
	public void showPaginationButton(){
		paginationFocPanel.clear();
		Label seeMoreLabel=new Label(GL0508);
		//seeMoreLabel.addClickHandler(new PaginationEvent());
		seeMoreLabel.setStyleName(EditClasspageCBundle.INSTANCE.css().paginationPanel());
		int totalPages = (this.totalHitCount / 5)
				+ ((this.totalHitCount % 5) > 0 ? 1 : 0);
		//int pageNumCount = pageNum + 1;
		if (totalPages > 1) {
			if (pageNumber > 1) {
				paginationFocPanel.add(new PaginationButtonUc(pageNumber - 1, PREVIOUS, this));
			}
		
			int page = pageNumber < 5 ? 1 : pageNumber - 3;

			for (int count = 1; count < 5 && page <= totalPages; page++, ++count) 
			{
				paginationFocPanel.add(new PaginationButtonUc(page, page == pageNumber, this));
			}
			if (pageNumber < totalPages) {
				paginationFocPanel.add(new PaginationButtonUc(pageNumber + 1, NEXT, this));
			}
		}
		//paginationFocPanel.add(seeMoreLabel);
	}
	public void clearPaginationButton(){
		paginationFocPanel.clear();
	}
	private class PaginationEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			pageNumber++;
			setPagination();
			assignmentsContainerPanel.add(setLoadingPanel());
			getUiHandlers().getNextClasspageItems(((pageNumber-1)*limit),limit);
		}
	}
	public void resetEditClasspageView(){
		paginationFocPanel.clear();
		assignmentsContainerPanel.clear();
		assignmentsContainerPanel.add(setLoadingPanel());
		limit=5;
		pageNumber=1;

	}
	public Label setLoadingPanel(){
		Label loadingImage=new Label();
		loadingImage.setStyleName(EditClasspageCBundle.INSTANCE.css().loadingpanelImage());
		return loadingImage;
	}
	public void removeLoadingPanel(){
		if(assignmentsContainerPanel.getWidgetCount()>0){
			Widget loadingPanel=assignmentsContainerPanel.getWidget(assignmentsContainerPanel.getWidgetCount()-1);
			if(loadingPanel!=null&&loadingPanel instanceof Label){
				loadingPanel.removeFromParent();
			}
		}
	}
	/* Custom methods */
	@Override
	public void setData(CollectionDo collectionDo) {
		try{
			Window.enableScrolling(true);
			AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
			if (collectionDo != null) {
				
				AppClientFactory.fireEvent(new SetSelectedClasspageListEvent(collectionDo.getGooruOid()));
				panelAssignmentPath.setVisible(true);
				assignmentsDirectionsLabel.setVisible(false);
				noAssignmentsMessagePanel.setVisible(false);
				droplistContianer.setVisible(true);
				collectionTitleUc.setText(collectionDo.getTitle() !=null ? collectionDo.getTitle() : "" );
				imgClasspageImage.setAltText(collectionDo.getTitle());
				imgClasspageImage.setTitle(collectionDo.getTitle());
				//collectionTitleUc.setText(collectionDo.getTitle());
				btnCollectionEditImage.setVisible(false);
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

	@Override
	public void setAssignmentData(AssignmentsSearchDo assignmentsSearchDo,
			boolean isExpandable) {
		insertAssignment(assignmentsSearchDo, true, isExpandable);
	}

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
	 * @description
	 * 
	 * 
	 * @parm(s) : @param assignmentsSearchDo
	 * @parm(s) : @param isNew
	 * @parm(s) : @param isExpandable
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void insertAssignment(AssignmentsSearchDo assignmentsSearchDo,
			boolean isNew, boolean isExpandable) {
		panelAssignmentPath.setVisible(true);
		assignmentsDirectionsLabel.setVisible(false);
		droplistContianer.setVisible(true);
		noAssignmentsMessagePanel.setVisible(false);
		assignmentTabView = new CollectionsView();
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
			//txtClasspageLinkShare.setText(shortenUrl.get(SHORTEN_URL));
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

	@Override
	public void onClick(ClickEvent event) {
		if (event.getSource() instanceof PaginationButtonUc) {
			
			int pagenumber = ((PaginationButtonUc) event.getSource()).getPage();

			int pageNumVal = (pagenumber - 1) * 5;
			
			pageNumber = pagenumber;
			setPagination();
			
			assignmentsContainerPanel.add(setLoadingPanel());

			getUiHandlers().getNextClasspageItems(((pagenumber-1)*limit),limit);
			/*int pagenumber = ((PaginationButtonUc) event.getSource()).getPage();

			pageNum = (pagenumber - 1) * pageSize;

			AssignmentsListDo assignmentListDo = new AssignmentsListDo();
			assignmentListDo.setClasspageId(classpageId);
			assignmentListDo.setPageNum(pageNum);
			assignmentListDo.setPageSize(pageSize);
			assignmentListDo.setPos(pagenumber);

			Map<String, String> params = new HashMap<String, String>();
			params.put("classpageid", classpageDo.getClasspageId());
			params.put("pageSize", pageSize + "");
			params.put("pageNum", pageNum + "");
			params.put("pos", pagenumber + "");
			AppClientFactory.getPlaceManager().revealPlace(
					PlaceTokens.EDIT_CLASSPAGE, params, true);*/

		} else {
		}
	}

	public void onDeleteAssignment(boolean isPostDeleteAssignment) {
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		Map<String, String> params = new HashMap<String, String>();
		params.put("classpageid",classpageDo.getClasspageId());
		params.put("pageSize", pageSize + "");
	if (assignmentsContainerPanel.getWidgetCount() == 1
				&& isPostDeleteAssignment) {
			pageNum = pageNum == 0 ? 0 : pageNum - 5;
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

	@Override
	public void listAssignments(AssignmentsListDo result) {
		isClicked=true;
		if (result.getSearchResults().size() > 0) {
			for (int i = 0; i < result.getSearchResults().size(); i++) {
				boolean isDisplay = i == 0 ? true : false;
				insertAssignment(result.getSearchResults().get(i), false,
						isDisplay);
			}
			
			paginationFocPanel.clear();
			assignmentCount = (result.getTotalHitCount() / pageSize)
					+ ((result.getTotalHitCount() % pageSize) > 0 ? 1 : 0);

			if (assignmentCount > 1) {
				if (pos > 1) {
					paginationFocPanel.add(new PaginationButtonUc(pos - 1,
							PREVIOUS, this));
				}
				int page = pos < 5 ? 1 : pos - 5;
				for (int count = 0; count < 5 && page <= assignmentCount; page++, ++count) {
					paginationFocPanel.add(new PaginationButtonUc(page,
							page == pos, this));
				}
				if (pos < assignmentCount) {
					paginationFocPanel.add(new PaginationButtonUc(pos + 1,
							NEXT, this));
				}
			}
		} else if(result.getTotalHitCount()==0) {
			panelAssignmentProgress.clear();
			panelAssignmentPath.setVisible(false);
			assignmentsDirectionsLabel.setVisible(true);
			noAssignmentsMessagePanel.setVisible(true);
			droplistContianer.setVisible(false);
		}
		else{
			panelAssignmentProgress.clear();
			panelAssignmentPath.setVisible(true);
			assignmentsDirectionsLabel.setVisible(false);
			noAssignmentsMessagePanel.setVisible(false);
			droplistContianer.setVisible(true);
		}

	}


	@Override
	public void clearPanel() {
//		assignmentsContainerPanel.clear();
//		paginationFocPanel.clear();
//		noAssignmentsMessagePanel.setVisible(true);
		
		assignmentsTab.addStyleName(res.css().selected());

		classListTab.getElement().setClassName("");
		
		reportsTab.getElement().setClassName("");
		
		newAssignmentAndMsgPanel.setVisible(true);
		assignmentsTabContainerPanel.setVisible(true);
		getClassListContainer().setVisible(false);
	}
/**
 * This method is used to update the title
 */
	@Override
	public void onPostClassPageUpdate() {
		collectionTitleUc.cancel();
		panelUpdateActionContols.getElement().getStyle().setDisplay(Display.NONE);
		titleAlertMessageLbl.setText(GL0143);
		titleAlertMessageLbl.setVisible(false);
		titleAlertMessageLbl.removeStyleName("titleAlertMessageActive");
		final CollectionDo classpage = null;
		AppClientFactory.fireEvent(new RefreshClasspageResourceItemListEvent(
				classpage, RefreshType.UPDATE));

	}
	private static String frameAnalyticsUrl() {
		String classpageId = AppClientFactory.getPlaceManager().getRequestParameter("classpageid");
		String analyticsId = AppClientFactory.getPlaceManager().getRequestParameter("analyticsId");
		String monitorId = AppClientFactory.getPlaceManager().getRequestParameter("monitorid");
		if(analyticsId == null)
		{
			analyticsId = monitorId;
		}
		else if(monitorId == null)
		{
			monitorId = analyticsId;
		}

			String urlVal = StringUtil.generateMessage(AppClientFactory.getLoggedInUser().getSettings().getAnalyticsEndPoint()+DataInsightsUrlTokens.CLASS_COLLECTION_SUMMARY_DATA,classpageId,analyticsId,AppClientFactory.getLoginSessionToken());

			urlVal = urlVal+"&"+Math.random();
			
		return urlVal;
	}
	
	private static String frameReportsUrl() {
		String classpageId = AppClientFactory.getPlaceManager().getRequestParameter("classpageid");

			String urlVal = StringUtil.generateMessage(AppClientFactory.getLoggedInUser().getSettings().getAnalyticsEndPoint()+DataInsightsUrlTokens.CLASS_REPORTS,classpageId,AppClientFactory.getLoggedInUser().getGooruUId(),AppClientFactory.getLoginSessionToken());

			urlVal = urlVal+"&"+Math.random();
			
		return urlVal;
	}
	
	private static String frameAnalyticsUrlForMonitor() {

		String classpageId = AppClientFactory.getPlaceManager().getRequestParameter("classpageid");
		String analyticsId = AppClientFactory.getPlaceManager().getRequestParameter("analyticsId");
		String monitorId = AppClientFactory.getPlaceManager().getRequestParameter("monitorid");
		if(analyticsId == null)
		{
			analyticsId = monitorId;
		}
		else if(monitorId == null)
		{
			monitorId = analyticsId;
		}

		String urlVal = StringUtil.generateMessage(AppClientFactory.getLoggedInUser().getSettings().getAnalyticsEndPoint()+DataInsightsUrlTokens.CLASS_COLLECTION_MONITOR_DATA,
					classpageId,analyticsId,AppClientFactory.getLoginSessionToken());
		
		urlVal = urlVal+"&"+Math.random();

			
		return urlVal;
	}
	/**
	 * This handler is used to update and save title
	 * @param event instance of ClickEvent
	 */
	@UiHandler("btnClasspageSave")
	public void clickedOneditSelfCollectionSaveButton(ClickEvent event) {
		
//		isEditing = false;
		
		Map<String, String> parms = new HashMap<String, String>();
		parms.put("text", collectionTitleUc.getValue());
		AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {
			
			@Override
			public void onSuccess(Boolean value) {
				boolean isHavingBadWords = value;
				if (isHavingBadWords){
					collectionTitleUc.getElement().getStyle().setBorderColor("orange");
				}else{
					collectionTitleUc.switchToLabel();
					collectionTitleUc.getElement().getStyle().clearBackgroundColor();
					collectionTitleUc.getElement().getStyle().setBorderColor("#ccc");
				}
			}
		});
		
//		titleAlertMessageLbl.setText(MessageProperties.GL0143);
//		titleAlertMessageLbl.setVisible(true);
		
//		collectionTitleUc.switchToLabel();
	}
/**
 * This handler is used to cancel the title update 
 * @param event instance of ClickEvent
 */
	@UiHandler("btnClasspageCancel")
	public void clickedOnclassPageSaveButtonCancel(ClickEvent event) {
		
		isEditing = false;
		titleAlertMessageLbl.setVisible(false);
		titleAlertMessageLbl.setText(GL0143);
		titleAlertMessageLbl.addStyleName("titleAlertMessageDeActive");
		titleAlertMessageLbl.removeStyleName("titleAlertMessageActive");
//		panelUpdateActionContols.setVisible(false);
		panelUpdateActionContols.getElement().getStyle().setDisplay(Display.NONE);

		collectionTitleUc.cancel();

	}

	@Override
	public void setUploadedImageToClassPage(String url) {
		MixpanelUtil.SuccessfullyAddtheImageFromClasspage();
		imgClasspageImage.setUrl(url+"?p="+Math.random());
	}

	@Override
	public void closeAllOpenedPopUp() {
		if(deleteConfirmVc!=null){
			deleteConfirmVc.hide();
		}
	}
	public class AssignmentsTabClicked implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			assignmentsTab.addStyleName(res.css().selected());
			
			if(classpageItemsList!=null&&classpageItemsList.size()>0){
				assignmentsDirectionsLabel.setVisible(false);
				panelAssignmentPath.setVisible(true);
				droplistContianer.setVisible(true);
			}
			else{
				assignmentsDirectionsLabel.setVisible(true);
				panelAssignmentPath.setVisible(false);
				droplistContianer.setVisible(false);
			}
			
			

			classListTab.getElement().setClassName("");
			
			reportsTab.getElement().setClassName("");
			
			backArrowButton.setVisible(true);
			monitorProgress.setVisible(true);
			frameDiv.setVisible(false);
		
			paginationFocPanel.setVisible(true);
			
			newAssignmentAndMsgPanel.setVisible(true);
			assignmentsTabContainerPanel.setVisible(true);
			getClassListContainer().setVisible(false);
			String tab=AppClientFactory.getPlaceManager().getRequestParameter("tab", null);
			if(tab!=null){
				Map<String,String> params = new HashMap<String,String>();
				String pageSize=AppClientFactory.getPlaceManager().getRequestParameter("pageSize", null);
				String classpageid=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
				String pageNum=AppClientFactory.getPlaceManager().getRequestParameter("pageNum", null);
				String pos=AppClientFactory.getPlaceManager().getRequestParameter("pos", null);
				params.put("pageSize", pageSize);
				params.put("classpageid", classpageid);
				params.put("pageNum", pageNum);
				params.put("pos", pos);
				PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.EDIT_CLASSPAGE, params);
				if(refresh){
					AppClientFactory.getPlaceManager().revealPlace(true, placeRequest, true);
				}else{
					AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
				}
				
			}
		}
	}
	public class ClassListTabClicked implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			assignmentsDirectionsLabel.setVisible(false);
			classListTab.addStyleName(res.css().selected());
			reportsTab.getElement().setClassName("");
			assignmentsTab.getElement().setClassName("");
			refresh=false;
			droplistContianer.setVisible(false);
			newAssignmentAndMsgPanel.setVisible(false);
			assignmentsTabContainerPanel.setVisible(false);
			panelAssignmentPath.setVisible(false);
			paginationFocPanel.setVisible(false);
			backArrowButton.setVisible(true);
			monitorProgress.setVisible(true);
			frameDiv.setVisible(false);
			getClassListContainer().setVisible(true);
			Map<String,String> params = new HashMap<String,String>();
			String pageSize=AppClientFactory.getPlaceManager().getRequestParameter("pageSize", null);
			String classpageid=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
			String pageNum=AppClientFactory.getPlaceManager().getRequestParameter("pageNum", null);
			String pos=AppClientFactory.getPlaceManager().getRequestParameter("pos", null);
			params.put("pageSize", pageSize);
			params.put("classpageid", classpageid);
			params.put("pageNum", pageNum);
			params.put("pos", pos);
			params.put("tab", "classList");
			PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.EDIT_CLASSPAGE, params);
			AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
			if(classlistPresenter!=null){
                classlistPresenter.getView().clearDataAndErrorMessages();
        }
		}
	}
	
	public class reportsTabClicked implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			assignmentsDirectionsLabel.setVisible(false);
			reportsTab.addStyleName(res.css().selected());
			classListTab.getElement().setClassName("");
			assignmentsTab.getElement().setClassName("");
			refresh=false;
			droplistContianer.setVisible(false);
			newAssignmentAndMsgPanel.setVisible(false);
			backArrowButton.setVisible(false);
			monitorProgress.setVisible(false);
			assignmentsTabContainerPanel.setVisible(false);
			getClassListContainer().setVisible(false);
			panelAssignmentPath.setVisible(false);
			paginationFocPanel.setVisible(false);
			frameDiv.setVisible(true);
			frameUrl.getElement().getStyle().setWidth(1000, Unit.PX);
			frameUrl.getElement().getStyle().setHeight(300, Unit.PX);
			frameUrl.setUrl(frameReportsUrl());

			
			Map<String,String> params = new HashMap<String,String>();
			String pageSize=AppClientFactory.getPlaceManager().getRequestParameter("pageSize", null);
			String classpageid=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
			String pageNum=AppClientFactory.getPlaceManager().getRequestParameter("pageNum", null);
			String pos=AppClientFactory.getPlaceManager().getRequestParameter("pos", null);
			params.put("pageSize", pageSize);
			params.put("classpageid", classpageid);
			params.put("pageNum", pageNum);
			params.put("pos", pos);
			params.put("tab", "reports");
			PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.EDIT_CLASSPAGE, params);
			AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
			if(classlistPresenter!=null){
                classlistPresenter.getView().clearDataAndErrorMessages();
        }
		}
	}
	
	@Override
	public FlowPanel getClassListContainer() {
		return classListContainer;
	}
	public static void setAnalyticsData()
	{

		mainContainer.setVisible(false);
		backArrowButton.setVisible(true);
		monitorProgress.setVisible(true);
		frameDiv.setVisible(true);
		frameUrl.getElement().getStyle().setWidth(1000, Unit.PX);
		frameUrl.getElement().getStyle().setHeight(300, Unit.PX);
		frameUrl.setUrl(frameAnalyticsUrl());
		monitorProgress.setVisible(true);
		monitorProgress.setText(GL1586);
	}
	public static void setAnalyticsMonitoringData()
	{

		mainContainer.setVisible(false);
		backArrowButton.setVisible(true);
		monitorProgress.setVisible(true);
		frameDiv.setVisible(true);
		frameUrl.getElement().getStyle().setWidth(1000, Unit.PX);
		frameUrl.getElement().getStyle().setHeight(300, Unit.PX);
		frameUrl.setUrl(frameAnalyticsUrlForMonitor());
		monitorProgress.setVisible(true);
		monitorProgress.setText(GL1587);
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.classpages.edit.IsEditClasspageView#getCollectionTitleUc()
	 */
	@Override
	public AssignmentEditLabelUc getCollectionTitleUc() {
		return collectionTitleUc;
	}
	@Override
	public void displayAssignmentPath(ArrayList<ClasspageItemDo> classpageProcess){
		panelAssignmentProgress.clear();
		//Store all classpage details in one global object.
		for (int i=0; i<classpageProcess.size(); i++){
			globalClasspageProcess.add(classpageProcess.get(i));
		}
		
		//hide/show the next and previous buttons
		if (classpageProcess.size() >= limitProgress){
			lblNext.setVisible(true);
		}else{
			lblNext.setVisible(false);
		}
		
		if (offsetProgress <= 0){
//			globalClasspageProcess.clear();
			lblPrevious.setVisible(false);
		}else{
			lblPrevious.setVisible(true);
		}
		
		//display the assignments progress (DOTS)
		for (int i=0; i<globalClasspageProcess.size(); i++){
			panelAssignmentProgress.add(new AssignmentProgressVc(i == globalClasspageProcess.size()-1 ? true : false, 
					globalClasspageProcess.get(i), i+1, globalClasspageProcess.size()));
		}
	}
	
	public class MouseOverShowClassCodeToolTip implements MouseOverHandler{

		@Override
		public void onMouseOver(MouseOverEvent event) {
			toolTipPopupPanelNew.clear();
			toolTipPopupPanelNew.setWidget(new GlobalToolTip(GL1869));
			toolTipPopupPanelNew.setStyleName("");
			toolTipPopupPanelNew.setPopupPosition(event.getRelativeElement().getAbsoluteLeft() - 14, event.getRelativeElement().getAbsoluteTop());
			toolTipPopupPanelNew.getElement().getStyle().setZIndex(999999);
			toolTipPopupPanelNew.show();
		}

	}

	public class MouseOutHideToolTip implements MouseOutHandler{

		@Override
		public void onMouseOut(MouseOutEvent event) {
			toolTipPopupPanelNew.hide();
		}
	}
}

