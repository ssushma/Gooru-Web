/**
 * 
 */
package org.ednovo.gooru.client.mvp.classpages.edit;

import java.util.ArrayList;
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
import org.ednovo.gooru.client.mvp.shelf.collection.tab.assign.CollectionAssignCBundle;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.vc.DeletePopupViewVc;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshType;
import org.ednovo.gooru.client.uc.AssignmentEditLabelUc;
import org.ednovo.gooru.client.uc.PaginationButtonUc;
import org.ednovo.gooru.client.uc.tooltip.GlobalToolTip;
import org.ednovo.gooru.client.uc.tooltip.ToolTip;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.AssignmentsListDo;
import org.ednovo.gooru.shared.model.content.AssignmentsSearchDo;
import org.ednovo.gooru.shared.model.content.ClasspageDo;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.StudentsAssociatedListDo;
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
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.event.dom.client.ScrollHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
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
public class EditClasspageView extends BaseViewWithHandlers<EditClasspageUiHandlers> implements IsEditClasspageView, ClickHandler{
	
	@UiField(provided = true)
	EditClasspageCBundle res;

	@UiField(provided = true)
	AssignmentEditLabelUc collectionTitleUc;
	
	ArrayList<ClasspageItemDo> globalClasspageProcess;
	
	ArrayList<ClasspageItemDo> classpageItemsList = new ArrayList<ClasspageItemDo>();

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
	
	private PopupPanel toolTipPopupPanelComingSoon = new PopupPanel();

	@UiField Image imgClasspageImage;
	
	@UiField FlowPanel mainFlowPanel;

	@UiField Label lblSelected, lblArrow;
	
	@UiField ScrollPanel spanelSutdentsList;
	
	@UiField
	static HTMLPanel mainContainer, panelSutdentsList;

	@UiField HTMLPanel panelUpdateActionContols;

	@UiField Label titleAlertMessageLbl;

	@UiField Button btnCollectionEditImage;

	@UiField Button btnEditImage,btnDeleteClasspage;

	@UiField Button assignmentsTab;

	@UiField Button classListTab,reportsTab;
	
	@UiField FlowPanel classSetupContainer;

	@UiField FocusPanel simplePencilFocPanel, classPageTitle,collectionFloPanel;
	
	@UiField Button btnClasspageCancel, btnClasspageSave;
	
	@UiField TextBox classCodeTextBox;
	
	@UiField HTMLPanel questionMarkPanel;
	
	@UiField VerticalPanel ananyticsPanel;

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
	
	private int studentPageSize = 20;
	
	private int studentResultSize = 0;
	
	private int studentOffSet=0;

	private int pageNum = 0;

	private Integer offsetProgress=0;
	private Integer limitProgress=20;
	
	private int pos = 0;

	int noOfItems = 5;

	private int assignmentCount = 0;
	
	private int totalHitCount=0;
	private int limit=5;
	private int pageNumber=0;
	private int collectionProgressCount=1;
	
	private final String START_PAGE = "1";
	
	ToolTip toolTip = null;
	
	ClassListPresenter classlistPresenter;
	
	List<CollectionItemDo> collectionItemList = new ArrayList<CollectionItemDo>();
	
	List<String> sortingOptionsList=new ArrayList<String>();




	private static EditClassPageViewUiBinder uiBinder = GWT.create(EditClassPageViewUiBinder.class);

	
	static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	String dropSortOptionsStr = i18n.GL1947();

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
					titleAlertMessageLbl.setText(i18n.GL0143());
					titleAlertMessageLbl.getElement().setAttribute("alt",i18n.GL0143());
					titleAlertMessageLbl.getElement().setAttribute("title",i18n.GL0143());
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
				titleAlertMessageLbl.setText(i18n.GL0143());
				titleAlertMessageLbl.getElement().setAttribute("alt",i18n.GL0143());
				titleAlertMessageLbl.getElement().setAttribute("title",i18n.GL0143());
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
		};

		res.css().ensureInjected();

		setWidget(uiBinder.createAndBindUi(this));
		
		CollectionAssignCBundle.INSTANCE.css().ensureInjected();
		mainContainer.setVisible(true);
		assignmentsTab.addClickHandler(new AssignmentsTabClicked());
		classListTab.addClickHandler(new ClassListTabClicked());
		btnCollectionEditImage.setVisible(false);
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
		
		panelUpdateActionContols.getElement().setId("panelUpdateActionContols");
		
		btnEditImage.setText(i18n.GL0138());
		btnEditImage.getElement().setAttribute("alt",i18n.GL0138());
		btnEditImage.getElement().setAttribute("title",i18n.GL0138());
		
		btnCollectionEditImage.setText(i18n.GL0140());
		btnCollectionEditImage.getElement().setAttribute("alt",i18n.GL0140());
		btnCollectionEditImage.getElement().setAttribute("title",i18n.GL0140());
		
		btnClasspageSave.setText(i18n.GL0141());
		btnClasspageSave.getElement().setAttribute("alt",i18n.GL0141());
		btnClasspageSave.getElement().setAttribute("title",i18n.GL0141());
		
		btnClasspageCancel.setText(i18n.GL0142());
		btnClasspageCancel.getElement().setAttribute("alt",i18n.GL0142());
		btnClasspageCancel.getElement().setAttribute("title",i18n.GL0142());
		
		titleAlertMessageLbl.setText(i18n.GL0143());
		titleAlertMessageLbl.getElement().setId("lblTitleAlertMessage");
		titleAlertMessageLbl.getElement().setAttribute("alt",i18n.GL0143());
		titleAlertMessageLbl.getElement().setAttribute("title",i18n.GL0143());
		
		btnDeleteClasspage.setText(i18n.GL2218());
		
	
		
		assignmentsTab.setText(i18n.GL1623());
		assignmentsTab.getElement().setId("btnAssignmentsTab");
		assignmentsTab.getElement().setAttribute("alt",i18n.GL1623());
		assignmentsTab.getElement().setAttribute("title",i18n.GL1623());
		classListTab.setText(i18n.GL1624());
		classListTab.getElement().setId("btnClassListTab");
		classListTab.getElement().setAttribute("alt",i18n.GL1624());
		classListTab.getElement().setAttribute("title",i18n.GL1624());
		
		reportsTab.setText(i18n.GL1737());
		reportsTab.getElement().setId("btnReportsTab");
		reportsTab.getElement().setAttribute("alt",i18n.GL1737());
		reportsTab.getElement().setAttribute("title",i18n.GL1737());
		
		
		btnEditImage.getElement().setId("btnEditImage");
		btnCollectionEditImage.getElement().setId("btnCollectionEditImage");
		btnClasspageSave.getElement().setId("btnClasspageSave");
		btnClasspageCancel.getElement().setId("btnClasspageCancel");
		lblSelected.setText(i18n.GL2174());
		StringUtil.setAttributes(lblSelected.getElement(), "lblSelected", i18n.GL2174(), i18n.GL2174());
		StringUtil.setAttributes(spanelSutdentsList.getElement(), "spanelSutdentsList", null, null);
		spanelSutdentsList.getElement().getStyle().setBackgroundColor("white");
		spanelSutdentsList.getElement().getStyle().setZIndex(9);
		spanelSutdentsList.setVisible(false);
		StringUtil.setAttributes(panelSutdentsList.getElement(), "panelSutdentsList", null, null);
		StringUtil.setAttributes(lblArrow.getElement(), "lblArrow", null, null);
		
		
		lblArrow.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				spanelSutdentsList.setVisible(spanelSutdentsList.isVisible() ? false : true);
			}
		});
		
		lblSelected.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				spanelSutdentsList.setVisible(spanelSutdentsList.isVisible() ? false : true);
			}
		});
		
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		reportHandler=reportsTab.addClickHandler(new reportsTabClicked());		
		//reportsTab.addMouseOverHandler(new MouseOverShowClassCodeToolTip1());
		//reportsTab.addMouseOutHandler(new MouseOutHideToolTip1());

		
		ResetProgressHandler reset = new ResetProgressHandler() {

			@Override
			public void callProgressAPI() {
				callAssignmentAPI(AppClientFactory.getPlaceManager().getRequestParameter("classpageid"), offsetProgress.toString(), limitProgress.toString());
			}
		};
		AppClientFactory.getEventBus().addHandler(ResetProgressEvent.TYPE,reset);
		addSortingOptionsToList();
		mainFlowPanel.getElement().setId("pnlMainFlow");
		collectionFloPanel.getElement().setId("pnlCollectionFloPanel");
		imgClasspageImage.getElement().setId("imgClasspageImage");
		simplePencilFocPanel.getElement().setId("pnlSimplePencilFocPanel");
		classPageTitle.getElement().setId("pnlClassPageTitle");
		collectionTitleUc.getElement().setId("lblCollectionTitleUc");
		panelUpdateActionContols.getElement().setId("pnlUpdateActionContols");
		classCodeTextBox.getElement().setId("txtClassCode");
		StringUtil.setAttributes(classCodeTextBox, true);
		questionMarkPanel.getElement().setId("pnlQuestionMark");
		mainContainer.getElement().setId("pnlMainContainer");
		
		
		
		
		spanelSutdentsList.addScrollHandler(new ScrollHandler() {

			@Override
			public void onScroll(ScrollEvent event) {
				if (spanelSutdentsList.getVerticalScrollPosition() == spanelSutdentsList
						.getMaximumVerticalScrollPosition()
						&& studentResultSize >= studentPageSize) {
					int tmpOffSet = studentOffSet;
					studentOffSet += studentPageSize;
					
					getClassStudentsList(classpageDo.getClasspageCode());
					
				}
			}
		});
		
	}
	
	public class MouseOverShowClassCodeToolTip1 implements MouseOverHandler{

		@Override
		public void onMouseOver(MouseOverEvent event) {
			toolTipPopupPanelComingSoon.clear();
			toolTipPopupPanelComingSoon.setWidget(new GlobalToolTip(i18n.GL0683()));
			toolTipPopupPanelComingSoon.setStyleName("");
			toolTipPopupPanelComingSoon.setPopupPosition(event.getRelativeElement().getAbsoluteLeft() + 135, event.getRelativeElement().getAbsoluteTop()+9);
			toolTipPopupPanelComingSoon.getElement().getStyle().setZIndex(999999);
			toolTipPopupPanelComingSoon.show();
		}

	}

	public class MouseOutHideToolTip1 implements MouseOutHandler{

		@Override
		public void onMouseOut(MouseOutEvent event) {
			toolTipPopupPanelComingSoon.hide();
		}
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
	
/*	private void OpenInstructionalDropdown() {
		
		if (spanelInstructionalPanel.isVisible()){
			spanelInstructionalPanel.setVisible(false);
		}else{
			spanelInstructionalPanel.setVisible(true);
		}
		
		
	}*/
	
	
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
			 if(slot==EditClasspagePresenter.CLASSLIST_SLOT){
				getClassContainer().clear();
				getClassContainer().add(content);
			}else{
				getClassContainer().setVisible(false);
			}
		}
	}
	
	public FlowPanel getClassContainer(){
		return classSetupContainer;
	}
	
	public void setClasspageData(ClasspageDo classpageDo){
		this.classpageDo=classpageDo;
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		AppClientFactory.fireEvent(new SetSelectedClasspageListEvent(classpageDo.getClasspageId()));
		collectionTitleUc.setText(classpageDo.getTitle() !=null ? classpageDo.getTitle() : "" );
		collectionTitleUc.getElement().setAttribute("alt",classpageDo.getTitle() !=null ? classpageDo.getTitle() : "" );
		collectionTitleUc.getElement().setAttribute("title",classpageDo.getTitle() !=null ? classpageDo.getTitle() : "" );
		classCodeTextBox.setText(classpageDo.getClasspageCode()!=null ? classpageDo.getClasspageCode().toUpperCase() : "");
		classCodeTextBox.getElement().setAttribute("alt",classpageDo.getClasspageCode()!=null ? classpageDo.getClasspageCode().toUpperCase() : "");
		classCodeTextBox.getElement().setAttribute("title",classpageDo.getClasspageCode()!=null ? classpageDo.getClasspageCode().toUpperCase() : "");
		lblSelected.setText(i18n.GL2174());
		classCodeTextBox.setReadOnly(true);
		classCodeTextBox.addClickHandler(new ClassCodeTextCopy());
		
		
		//Get list of students and list in dropdown
		getClassStudentsList(classpageDo.getClasspageCode()!=null ? classpageDo.getClasspageCode().toUpperCase() : "");

		final Image imgNotFriendly = new Image("images/mos/questionmark.png");
		imgNotFriendly.getElement().getStyle().setLeft(97.8, Unit.PCT);
		imgNotFriendly.getElement().getStyle().setTop(27, Unit.PX);
		imgNotFriendly.getElement().getStyle().setPosition(Position.ABSOLUTE);
		imgNotFriendly.getElement().getStyle().setCursor(Cursor.POINTER);
		imgNotFriendly.addMouseOverHandler(new MouseOverShowClassCodeToolTip());
		imgNotFriendly.addMouseOutHandler(new MouseOutHideToolTip());

		questionMarkPanel.clear();
		questionMarkPanel.setVisible(false);
		questionMarkPanel.add(imgNotFriendly);
		
		imgClasspageImage.setAltText(classpageDo.getTitle());
		imgClasspageImage.setTitle(classpageDo.getTitle());
		btnCollectionEditImage.setVisible(false);
		imgClasspageImage.setUrl(classpageDo.getThumbnailUrl().isEmpty() ? DEFAULT_CLASSPAGE_IMAGE : classpageDo.getThumbnailUrl());
		//txtClasspageCodeShare.setText(classpageDo.getClasspageCode().toUpperCase());
	}
	
	/**
	 * @function getClassStudentsList 
	 * 
	 * @created_date : 09-Sep-2014
	 * 
	 * @description
	 * 
	 * 
	 * @param string
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 * 
	*/
	
	private void getClassStudentsList(String classCode) {
		String statusType = "active";
		
		AppClientFactory.getInjector().getClasspageService().getActiveAssociatedStudentListByCode(classCode, studentOffSet,  studentPageSize,  statusType, new SimpleAsyncCallback<StudentsAssociatedListDo>() {
			@Override
			public void onSuccess(StudentsAssociatedListDo result) {
				//Display all members in active list.
				studentResultSize = result.getTotalHitCount();
				displayStudentList(result);
			}
		});
	}
	/**
	 * 
	 * @function displayStudentList 
	 * 
	 * @created_date : 09-Sep-2014
	 * 
	 * @description
	 * 
	 * 
	 * @param result
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	private void displayStudentList(StudentsAssociatedListDo result) {
		if (studentOffSet==0){
			panelSutdentsList.clear();
		}
		if(result.getSearchResults().size()>0){
				for (int i=0; i<result.getSearchResults().size();i++){
					String studentName = result.getSearchResults().get(i).getUsername().trim();
					String studentId = result.getSearchResults().get(i).getGooruUid().trim();
					final Label student = new Label();
					student.setText(studentName);
					
					student.setStyleName(res.css().student());
					
					student.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							String selectedStudentId = student.getElement().getAttribute("id"); 
							lblSelected.setText(student.getText());
							spanelSutdentsList.setVisible(false);
							// Need to write logic to navigate to student page.
							revealStudentView();
						}
					});
					
					StringUtil.setAttributes(student.getElement(), studentId, studentName, studentName);
					panelSutdentsList.add(student);
				}//end for loop
		}else{
			panelSutdentsList.clear();
			Label noStudentsLbl = new Label(i18n.GL2248());
			noStudentsLbl.getElement().setAttribute("style", "margin-left: 8px;");
			panelSutdentsList.add(noStudentsLbl);
		}
		
	}

	public class ClassCodeTextCopy implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			classCodeTextBox.selectAll();
			classCodeTextBox.setFocus(true);
		}
		
	}
	public void highlightTab(String tabValue)
	{
		assignmentsTab.removeStyleName(res.css().selected());
		classListTab.removeStyleName(res.css().selected());
		reportsTab.removeStyleName(res.css().selected());		
		if(tabValue!=null && tabValue.equalsIgnoreCase("classList"))
		{
			classListTab.addStyleName(res.css().selected());
		}
		else if(tabValue!=null && tabValue.equalsIgnoreCase("reports"))
		{
			reportsTab.addStyleName(res.css().selected());
		}
		else{
			assignmentsTab.addStyleName(res.css().selected());
		}
		
	}
	public void showClasspageItems(ArrayList<ClasspageItemDo> classpageItemsList1,String tab, String analyticsId, String monitorId,ClassListPresenter classlistPresenter,int assignmentsCount){
		this.classlistPresenter = classlistPresenter;

		classpageItemsList.clear();
		classpageItemsList.addAll(classpageItemsList1);
		if(tab!=null && tab.equalsIgnoreCase("classList")){
			classListTab.addStyleName(res.css().selected());
			assignmentsTab.getElement().setClassName("");
		}
		else if(tab!=null && tab.equalsIgnoreCase("reports")){
			reportsTab.addStyleName(res.css().selected());
			assignmentsTab.getElement().setClassName("");
			classListTab.getElement().setClassName("");
			assignmentsTab.setEnabled(true);
		}
		else if(analyticsId!=null)
		{
			mainContainer.setVisible(false);
		}
		else if(monitorId!=null)
		{
			mainContainer.setVisible(false);
		
		}
		else{
			removeLoadingPanel();
			mainContainer.setVisible(true);
			String order=AppClientFactory.getPlaceManager().getRequestParameter("order",null);
		}
	}
	public CollectionsView showClasspageItem(ClasspageItemDo classpageItemDo,int sequenceNum){
		CollectionsView assignmentCollectionView = new CollectionsView(classpageItemDo){
			public void resetPagination(){
				//restingPagination();
			}
			public void updateCollectionsView(){
				String pageNum=AppClientFactory.getPlaceManager().getRequestParameter("pageNum", null);
				int pageNumber=1;
				if(pageNum!=null){
					try{
						pageNumber=Integer.parseInt(pageNum);
//						if(assignmentsContainerPanel.getWidgetCount()<1){
//							if(pageNumber>1){
//								pageNumber=pageNumber-1;
//							}
//						}
						
					}catch(Exception e){
						
					}
				}
				showCollectionsAfterDeletingCollection(pageNumber);
			}
		};
		return assignmentCollectionView;
	}
	
	public void showCollectionsAfterDeletingCollection(int pageNumber){
		Map<String,String> params = new HashMap<String,String>();
		String classpageid=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
		String order=AppClientFactory.getPlaceManager().getRequestParameter("order", null);
		params.put("order", order);
		params.put("classpageid", classpageid);
		params.put("pageNum", pageNumber+"");
		PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.EDIT_CLASSPAGE, params);
		AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
	}
	
	public void restingPagination(){
		setPagination();
		if((pageNumber*limit)<totalHitCount){
			//assignmentsContainerPanel.add(setLoadingPanel());
			getUiHandlers().getNextClasspageItems(((pageNumber*limit)-1),1);
		}else{
			totalHitCount--;
			setPagination();
			if(totalHitCount==0){
				assignmentsTab.setText(i18n.GL1623()+"("+0+")");
			}
		}
	}
	
	public void setClasspageItemOnTop(ClasspageItemDo classpageItemDo){
		assignmentTabView = showClasspageItem(classpageItemDo,1);                             //TODO refresh the sequence....
		totalHitCount++;
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
//		paginationFocPanel.clear();
//		paginationFocPanel1.clear();
//		Label seeMoreLabel=new Label(i18n.GL0508());
//		//seeMoreLabel.addClickHandler(new PaginationEvent());
//		seeMoreLabel.setStyleName(EditClasspageCBundle.INSTANCE.css().paginationPanel());
//		int totalPages = (this.totalHitCount / 5)
//				+ ((this.totalHitCount % 5) > 0 ? 1 : 0);
//		//int pageNumCount = pageNum + 1;
//		if (totalPages > 1) {
//			if (pageNumber > 1) {
//				paginationFocPanel.add(new PaginationButtonUc(pageNumber - 1, PREVIOUS, this));
//				paginationFocPanel1.add(new PaginationButtonUc(pageNumber - 1, PREVIOUS, this));
//			}
//		
//			int page = pageNumber < 5 ? 1 : pageNumber - 3;
//
//			for (int count = 1; count < 5 && page <= totalPages; page++, ++count) 
//			{
//				paginationFocPanel.add(new PaginationButtonUc(page, page == pageNumber, this));
//				paginationFocPanel1.add(new PaginationButtonUc(page, page == pageNumber, this));
//			}
//			if (pageNumber < totalPages) {
//				paginationFocPanel.add(new PaginationButtonUc(pageNumber + 1, NEXT, this));
//				paginationFocPanel1.add(new PaginationButtonUc(pageNumber + 1, NEXT, this));
//			}
//		}
	}
	public void clearPaginationButton(){
//		paginationFocPanel.clear();
//		paginationFocPanel1.clear();
	}
	private class PaginationEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			pageNumber++;
			setPagination();
			//assignmentsContainerPanel.add(setLoadingPanel());
			getUiHandlers().getNextClasspageItems(((pageNumber-1)*limit),limit);
		}
	}
	public void resetEditClasspageView(){
		collectionTitleUc.setText("");
		collectionTitleUc.getElement().removeAttribute("title");
		collectionTitleUc.getElement().removeAttribute("alt");
		//classCodeTextBox.setText("");
		classCodeTextBox.getElement().removeAttribute("title");
		classCodeTextBox.getElement().removeAttribute("alt");
		imgClasspageImage.setUrl("/d");
		imgClasspageImage.getElement().removeAttribute("title");
		imgClasspageImage.getElement().removeAttribute("alt");
//		paginationFocPanel.clear();
//		paginationFocPanel1.clear();
//		assignmentsContainerPanel.clear();
//		assignmentsContainerPanel.add(setLoadingPanel());
		limit=5;
		pageNumber=1;

	}
	public Label setLoadingPanel(){
		Label loadingImage=new Label();
		loadingImage.setStyleName(EditClasspageCBundle.INSTANCE.css().loadingpanelImage());
		return loadingImage;
	}
	public void removeLoadingPanel(){
//		if(assignmentsContainerPanel.getWidgetCount()>0){
//			Widget loadingPanel=assignmentsContainerPanel.getWidget(assignmentsContainerPanel.getWidgetCount()-1);
//			if(loadingPanel!=null&&loadingPanel instanceof Label){
//				loadingPanel.removeFromParent();
//			}
//		}
	}
	/* Custom methods */
	@Override
	public void setData(CollectionDo collectionDo) {
		try{
			Window.enableScrolling(true);
			AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
			if (collectionDo != null) {
				AppClientFactory.fireEvent(new SetSelectedClasspageListEvent(collectionDo.getGooruOid()));
				collectionTitleUc.setText(collectionDo.getTitle() !=null ? collectionDo.getTitle() : "" );
				collectionTitleUc.getElement().setAttribute("alt",collectionDo.getTitle() !=null ? collectionDo.getTitle() : "" );
				collectionTitleUc.getElement().setAttribute("title",collectionDo.getTitle() !=null ? collectionDo.getTitle() : "" );
				imgClasspageImage.setAltText(collectionDo.getTitle());
				imgClasspageImage.setTitle(collectionDo.getTitle());
				//collectionTitleUc.setText(collectionDo.getTitle());
				btnCollectionEditImage.setVisible(false);
//				paginationFocPanel.clear();
//				paginationFocPanel1.clear();
				getUiHandlers().getAssignmentsByClasspageById(classpageId,pageSize + "", pageNum + "");
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
	
		assignmentTabView = new CollectionsView();
	//	assignmentsContainerPanel.add(assignmentTabView);
		
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
			
//			assignmentsContainerPanel.clear();
//			assignmentsContainerPanel.add(setLoadingPanel());
			
			offsetProgress = 0;
			limitProgress = 20;

			//getUiHandlers().getNextClasspageItems(((pagenumber-1)*limit),limit);
			/*int pagenumber = ((PaginationButtonUc) event.getSource()).getPage();

			pageNum = (pagenumber - 1) * pageSize;

			AssignmentsListDo assignmentListDo = new AssignmentsListDo();
			assignmentListDo.setClasspageId(classpageId);
			assignmentListDo.setPageNum(pageNum);
			assignmentListDo.setPageSize(pageSize);
			assignmentListDo.setPos(pagenumber);*/

			Map<String,String> params = new HashMap<String,String>();
			String classpageid=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
			String pageNum=AppClientFactory.getPlaceManager().getRequestParameter("pageNum", null);
			String order=AppClientFactory.getPlaceManager().getRequestParameter("order", null);
			params.put("order", order);
			params.put("classpageid", classpageid);
			params.put("pageNum", pagenumber+"");
			PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.EDIT_CLASSPAGE, params);
			AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);


		} else {
		}
	}

	public void onDeleteAssignment(boolean isPostDeleteAssignment) {
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));
		restingPagination();
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("classpageid",classpageDo.getClasspageId());
//		params.put("pageSize", pageSize + "");
//		if (assignmentsContainerPanel.getWidgetCount() == 1
//					&& isPostDeleteAssignment) {
//				pageNum = pageNum == 0 ? 0 : pageNum - 5;
//				params.put("pageNum", pageNum + "");
//				params.put("pos", pos + "");
//		}else {
//			pageNum = isPostDeleteAssignment ? pageNum : 0;
//			params.put("pageNum", pageNum + "");
//			if(pageNum==0){
//			    params.put("pos", START_PAGE);
//			}else{
//				params.put("pos", pos + "");
//			}
//		}
//		AppClientFactory.getPlaceManager().revealPlace(
//				PlaceTokens.EDIT_CLASSPAGE, params, true);
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
		
	}


	@Override
	public void clearPanel() {
//		assignmentsContainerPanel.clear();
//		paginationFocPanel.clear();
//		noAssignmentsMessagePanel.setVisible(true);
		
		assignmentsTab.addStyleName(res.css().selected());

		classListTab.getElement().setClassName("");
		
		reportsTab.getElement().setClassName("");
		
//		newAssignmentAndMsgPanel.setVisible(true);
//		assignmentsTabContainerPanel.setVisible(true);
	}
/**
 * This method is used to update the title
 */
	@Override
	public void onPostClassPageUpdate() {
		collectionTitleUc.cancel();
		panelUpdateActionContols.getElement().getStyle().setDisplay(Display.NONE);
		titleAlertMessageLbl.setText(i18n.GL0143());
		titleAlertMessageLbl.getElement().setAttribute("alt",i18n.GL0143());
		titleAlertMessageLbl.getElement().setAttribute("title",i18n.GL0143());
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
		titleAlertMessageLbl.setText(i18n.GL0143());
		titleAlertMessageLbl.getElement().setAttribute("alt",i18n.GL0143());
		titleAlertMessageLbl.getElement().setAttribute("title",i18n.GL0143());
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
			AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
		}
	}
	public class ClassListTabClicked implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			Map<String,String> params = new HashMap<String,String>();
			String pageSize=AppClientFactory.getPlaceManager().getRequestParameter("pageSize", null);
			String classpageid=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
			String pageNum=AppClientFactory.getPlaceManager().getRequestParameter("pageNum", null);
			String pos=AppClientFactory.getPlaceManager().getRequestParameter("pos", null);
			params.put("pageSize", pageSize);
			params.put("classpageid", classpageid);
			params.put("pageNum", pageNum);
			params.put("pos", pos);
			params.put("tab", "classlist");
			PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.EDIT_CLASSPAGE, params);
			AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
		}
	}
	
	public class reportsTabClicked implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {

			reportsTab.addStyleName(res.css().selected());
			classListTab.getElement().setClassName("");
			assignmentsTab.getElement().setClassName("");
			refresh=false;
			/*droplistContianer.setVisible(false);*/
			assignmentsTab.setEnabled(true);
			

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
		}
	}


	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.classpages.edit.IsEditClasspageView#getCollectionTitleUc()
	 */
	@Override
	public AssignmentEditLabelUc getCollectionTitleUc() {
		return collectionTitleUc;
	}

	
	public class MouseOverShowClassCodeToolTip implements MouseOverHandler{

		@Override
		public void onMouseOver(MouseOverEvent event) {
			toolTipPopupPanelNew.clear();
			toolTipPopupPanelNew.setWidget(new GlobalToolTip(i18n.GL1869()));
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
	
	public void addSortingOptionsToList(){
		sortingOptionsList.clear();
		sortingOptionsList.add(i18n.GL1948());
		sortingOptionsList.add(i18n.GL1950());
		sortingOptionsList.add(i18n.GL1949());//previously it was descending order 
		sortingOptionsList.add(i18n.GL1994());//previous number was 1581
	}
	
	public class addAssignmentHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			MixpanelUtil.Click_Add_NewAssignment();
			Window.enableScrolling(false);
			AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, false));
			getUiHandlers().addAssignmentsContainerPopup(getClasspageId());
			
		}
	}

	@Override
	public void hideNoAssignmentsMessagePanel() {
		// TODO Auto-generated method stub
		
	}

	@UiHandler("btnDeleteClasspage")
	public void OnClickDeleteClasspage(ClickEvent event) {
		Window.enableScrolling(false);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
		DeletePopupViewVc delete = new DeletePopupViewVc() {
			@Override
			public void onClickPositiveButton(ClickEvent event) {
				AppClientFactory
						.getInjector()
						.getClasspageService()
						.deleteClasspage(classpageDo.getClasspageId(),
								new SimpleAsyncCallback<Void>() {
									@Override
									public void onSuccess(Void result) {
										Window.enableScrolling(true);
										AppClientFactory
												.fireEvent(new SetHeaderZIndexEvent(
														0, true));
										AppClientFactory
												.fireEvent(new DeleteClasspageListEvent(
														classpageDo
																.getClasspageId()));
										Window.enableScrolling(true);
										AppClientFactory
												.fireEvent(new SetHeaderZIndexEvent(
														0, true));
										hide();
										if (!AppClientFactory.getLoggedInUser().getUserUid().equals(AppClientFactory.GOORU_ANONYMOUS)) {
										AppClientFactory.getInjector().getClasspageService().v2GetAllClass("10", "0",new SimpleAsyncCallback<ClasspageListDo>() {
													@Override
													public void onSuccess(ClasspageListDo result) {
														if(result.getSearchResults()!=null){
														if (result.getSearchResults().size()>0){
															AppClientFactory.getInjector().getClasspageService().v2GetAllClass("2", "0",new SimpleAsyncCallback<ClasspageListDo>() {
																@Override
																public void onSuccess(ClasspageListDo result) {
															//	hasClasses = result.getSearchResults().size() > 0 ? true : false; 
																	if(result.getSearchResults()!=null){
																	if (result.getSearchResults().size()>0){
																		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.CLASSHOME);
																		////classpageId = result.getSearchResults().get(0).getGooruOid();
																		//String userId = result.getSearchResults().get(0).getUser().getGooruUId();
																	//OpenClasspageEdit(classpageId, userId);
																		//AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.CLASSHOME,null,true);
																	}else{
																		AppClientFactory.getPlaceManager().redirectPlace(PlaceTokens.STUDY);
																		//AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.STUDY);
																	}
																}else
																{
																	AppClientFactory.getPlaceManager().redirectPlace(PlaceTokens.STUDY);
																}
																}
														});
															}else{
															AppClientFactory.getPlaceManager().redirectPlace(PlaceTokens.STUDY);
														}
													}else
													{
														AppClientFactory.getPlaceManager().redirectPlace(PlaceTokens.STUDY);
													}
													}
											});
										}
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
		delete.setPopupTitle((i18n.GL0748()));
		delete.setNotes(i18n.GL0748());
		delete.setDescText(StringUtil.generateMessage(i18n.GL0824() + "\""
				+ classpageDo.getTitle() + "\"" + " " + i18n.GL0102()
				+ i18n.GL_SPL_FULLSTOP() + " " + i18n.GL0825()));
		delete.setPositiveButtonText(i18n.GL0190());
		delete.setNegitiveButtonText(i18n.GL0142());
		delete.setDeleteValidate("delete");
		delete.setPixelSize(450, 345);
		delete.show();
		delete.center();
	}
	
	public void revealStudentView(){
		Map<String,String> params = new HashMap<String,String>();
		String classpageid=AppClientFactory.getPlaceManager().getRequestParameter("classpageid", null);
		String pageNum=AppClientFactory.getPlaceManager().getRequestParameter("pageNum", null);
		String pos=AppClientFactory.getPlaceManager().getRequestParameter("pos", null);
		String pageSize=AppClientFactory.getPlaceManager().getRequestParameter("pageSize", null);
		params.put("pos", pos);
		params.put("id", classpageid);
		/*if(source!=null){
			params.put("source", source);
		}
		if(backButtonStatus!=null){
			params.put("b", "true");
		}*/
		params.put("pageNum", pageNum);
		params.put("pageSize", pageSize);
		PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.STUDENT, params);
		AppClientFactory.getPlaceManager().revealPlace(true, placeRequest, false);
	}

}

