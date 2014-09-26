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
package org.ednovo.gooru.client.mvp.home.library.assign;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.child.ChildView;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.dnd.IsDraggableMirage;
import org.ednovo.gooru.client.mvp.shelf.event.CollectionEditShareEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshCollectionInShelfListEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshType;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshUserShelfCollectionsEvent;
import org.ednovo.gooru.client.service.ClasspageServiceAsync;
import org.ednovo.gooru.client.uc.AlertMessageUc;
import org.ednovo.gooru.client.uc.BlueButtonUc;
import org.ednovo.gooru.client.uc.DateBoxUcCustomizedForAssign;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.client.util.SetStyleForProfanity;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.AssignmentsListDo;
import org.ednovo.gooru.shared.model.content.ClassDo;
import org.ednovo.gooru.shared.model.content.ClasspageItemDo;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.ResourceDo;
import org.ednovo.gooru.shared.model.content.TaskResourceAssocDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.event.dom.client.ScrollHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName :
 *
 * @description : 
 *	This class is used to set the Editing collection to Assignment under Classpages.
 *
 * @version : 1.0
 *
 * @date: Jul 30, 2013
 *
 *
 * @Reviewer:
 */
public abstract class AssignCollectionView extends ChildView<AssignCollectionPresenter> implements
IsCollectionAssign {

	@UiField(provided = true)
	AssignPopUpCBundle res;
	
	@UiField Label lblAssignCollectionTitle,lblClasspages,lblClasspagesUnits,lblClasspagePlaceHolder,lblClasspageUnitPlaceHolder, lblClasspagesArrow,lblClasspagesUnitArrow,lblDirections,lblDirectionsOptional;
	

	@UiField Label lblAssignCollectionPrivate, lblNoClassPageMsg,lblNoClassPage,lblDuedate,lblDuedateOptional,directionsErrorLbl,errorLabel;
	
	@UiField BlueButtonUc btnAssign;
	
	@UiField ScrollPanel spanelClasspagesPanel,spanelClasspagesUnitPanel;
	
	@UiField HTMLPanel htmlClasspagesListContainer,htmlClasspagesUnitListContainer,duedateContainer;
	
	@UiField HTMLPanel  panelNoClasspages,htmlPanelContainer,panelTitleContainer,loadingImageLabel;
	
	@UiField HTMLPanel controlsContainer;
	
	@UiField HTMLPanel assignMoreCpContainer;
	
	@UiField InlineLabel assignMoreCpLbl,ancClasspageTitle;
	
	@UiField Button classPageBtn;
	
	@UiField TextArea textAreaVal;
	
	@UiField Image lblNoClassPageImage;
	
	
	AlertMessageUc alertMessageUc;
	private SimpleAsyncCallback<ClasspageListDo> getClasspageList;	
	private SimpleAsyncCallback<AssignmentsListDo> assignmentsListAsyncCallback;	
	private SimpleAsyncCallback<CollectionDo> collectionDoAsyncCallback;	
	
	String toAssignStr = null;	
	String limit="10";//pagesize	
	int classpageOffSet=0;
	int classpageUnitOffSet=0;
	int assignmentOffSet=0;	
	boolean isApiCalling=false;	
	boolean toClear=true;	
	boolean toUnitClear=true;
	boolean isAdded = false;	
	List<String> collectionsList = new ArrayList<String>();
	boolean toClearAssignment = true;	
	boolean isAssignmentsEnabled = false;
	CollectionDo collectionDoGlobal = new CollectionDo();	
	String classpageId=null;
	String unitId=null;
	String assignmentId=null;	
	boolean isMoreThanLimit=false;	//Limit = 10	
	String shareType=null;
	boolean isValid=true;
	private ClasspageServiceAsync classpageService;	
	
	private String createrId="";
	
	private DateBoxUcCustomizedForAssign dateBoxUc;

	private static AssignCollectionViewUiBinder uiBinder = GWT.create(AssignCollectionViewUiBinder.class);

	interface AssignCollectionViewUiBinder extends UiBinder<Widget, AssignCollectionView> {
	}

	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	/**
	 * Class constructor
	 */
	public AssignCollectionView(CollectionDo collectionDoObject) {
		

		res = AssignPopUpCBundle.INSTANCE;
		AssignPopUpCBundle.INSTANCE.css().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));
		
		loadingImageLabel.setVisible(true);
		
		toAssignStr = collectionDoObject.getGooruOid();
		collectionDoGlobal = collectionDoObject;
		
		lblDirections.setText(i18n.GL1166());
		lblDirections.getElement().setAttribute("alt",i18n.GL1166());
		lblDirections.getElement().setAttribute("title",i18n.GL1166());
		
		lblDirectionsOptional.setText(i18n.GL1167());
		lblDirectionsOptional.getElement().setAttribute("alt",i18n.GL1167());
		lblDirectionsOptional.getElement().setAttribute("title",i18n.GL1167());
		
		lblDuedateOptional.setText(i18n.GL1167());
		lblDuedateOptional.getElement().setAttribute("alt",i18n.GL1167());
		lblDuedateOptional.getElement().setAttribute("title",i18n.GL1167());
		
		lblDuedate.setText(i18n.GL1168());
		lblDuedate.getElement().setAttribute("alt",i18n.GL1168());
		lblDuedate.getElement().setAttribute("title",i18n.GL1168());
		
		textAreaVal.setText(i18n.GL1461());
		textAreaVal.getElement().setAttribute("alt",i18n.GL1461());
		textAreaVal.getElement().setAttribute("title",i18n.GL1461());
		textAreaVal.getElement().getStyle().setColor("#999");
		StringUtil.setAttributes(textAreaVal, true);
		
		dateBoxUc = new DateBoxUcCustomizedForAssign(false, false,false);
		duedateContainer.add(dateBoxUc);
		dateBoxUc.getDoneButton().addClickHandler(new OnDoneClick());
		textAreaVal.addKeyUpHandler(new DirectionsKeyUpHandler());
		textAreaVal.getElement().setAttribute("maxlength", "400");
		StringUtil.setAttributes(textAreaVal, true);
		
		textAreaVal.addFocusHandler(new FocusHandler() {
			@Override
			public void onFocus(FocusEvent event) {
				String directionText=textAreaVal.getText().trim();
				if(directionText.equalsIgnoreCase(i18n.GL1389())){ 
					textAreaVal.setText("");
				}
				textAreaVal.getElement().getStyle().setColor("black");
			}
		});
		
		textAreaVal.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				if(textAreaVal.getText().length() > 415)
				{
					textAreaVal.cancelKey();
				}			
			}
		});
		textAreaVal.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				if(textAreaVal.getText().length() == 0)
				{
					textAreaVal.setText(i18n.GL1389());
					textAreaVal.getElement().getStyle().setColor("#999");
				}
				Map<String, String> parms = new HashMap<String, String>();
				parms.put("text", textAreaVal.getText());
				AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {
					@Override
					public void onSuccess(Boolean value) {
							directionsErrorLbl.setText("");
							SetStyleForProfanity.SetStyleForProfanityForTextArea(textAreaVal, directionsErrorLbl, value);
							directionsErrorLbl.setStyleName(res.css().directionsErrorLbl());
					}
				});
			}
		});
		
		//dateValidationUc.setStyleName(AddAssignmentContainerCBundle.INSTANCE.css().registerErrorLabel());

		getClassPageData();
	}

	public void getClassPageData() {
		lblNoClassPage.setText(i18n.GL0106());
		lblNoClassPage.getElement().setAttribute("alt",i18n.GL0106());
		lblNoClassPage.getElement().setAttribute("title",i18n.GL0106());
		
		lblNoClassPageMsg.setText(i18n.GL0109());
		lblNoClassPageMsg.getElement().setAttribute("alt",i18n.GL0109());
		lblNoClassPageMsg.getElement().setAttribute("title",i18n.GL0109());
		
		lblNoClassPageImage.setUrl("images/library/banner-assign.png");
		lblNoClassPageImage.setTitle(i18n.GL1025());
		lblNoClassPageImage.setAltText(i18n.GL1025());
		setLabelsAndIds();
		htmlPanelContainer.setVisible(false);
		panelNoClasspages.setVisible(false);
		errorLabel.setVisible(false);
		onLoaded();
		panelTitleContainer.getElement().getStyle().setMarginBottom(15, Unit.PX);
		spanelClasspagesPanel.setVisible(false);
		spanelClasspagesPanel.addScrollHandler(new ScrollHandler() {
			@Override
			public void onScroll(ScrollEvent event) {
				if (spanelClasspagesPanel.getVerticalScrollPosition() == spanelClasspagesPanel.getMaximumVerticalScrollPosition()){
					toClear = false;
					getNextClasspages();
				}
			}
		});
		spanelClasspagesUnitPanel.setVisible(false);
		
		spanelClasspagesUnitPanel.addScrollHandler(new ScrollHandler() {
			
			
			
			@Override
			public void onScroll(ScrollEvent event) {
				if(spanelClasspagesUnitPanel.getVerticalScrollPosition() == spanelClasspagesUnitPanel.getMaximumVerticalScrollPosition()){
					toUnitClear = false;
					getNextClasspagesUnit();
				}
			}
		});
		
	
		getClasspage(collectionDoGlobal, null);
		assignMoreCpContainer.setVisible(false);
	
	}
	

	public void onLoaded(){
		
		setGetClasspageList(new SimpleAsyncCallback<ClasspageListDo>() {

			@Override
			public void onSuccess(ClasspageListDo result) 
			{				
				setClasspageData(result);
				loadingImageLabel.setVisible(false);
			}
		});
		
	
	}
	private class DirectionsKeyUpHandler implements KeyUpHandler {
		public void onKeyUp(KeyUpEvent event) {
			directionsErrorLbl.setVisible(false);
			if (textAreaVal.getText().length() >=400) {
				textAreaVal.setText(textAreaVal.getText().trim()
						.substring(0, 400));
				directionsErrorLbl.setText("");
				directionsErrorLbl.setText(i18n.GL0143());
				directionsErrorLbl.getElement().setAttribute("alt",i18n.GL0143());
				directionsErrorLbl.getElement().setAttribute("title",i18n.GL0143());
				directionsErrorLbl.setVisible(true);
			}

		}
	}
	private class OnDoneClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			if (dateBoxUc.dateValidation()){
				if (!(dateBoxUc.getValue() == null || dateBoxUc.getDateBox()
						.getText().isEmpty())
						&& dateBoxUc.hasValidateDate()) {
				Date date = dateBoxUc.getValue();
				
				} else {
					dateBoxUc.getDatePickerUc().hide();
				}
			}
		}
	}
	
	/** 
	 * This method is to get the getClasspageList
	 */
	public SimpleAsyncCallback<ClasspageListDo> getGetClasspageList() {
		return getClasspageList;
	}

	public ClasspageServiceAsync getClasspageService() {
		return classpageService;
	}

	public void setClasspageService(ClasspageServiceAsync classpageService) {
		this.classpageService = classpageService;
	}
	
	

	public SimpleAsyncCallback<CollectionDo> getCollectionDoAsyncCallback() {
		return collectionDoAsyncCallback;
	}



	public void setCollectionDoAsyncCallback(
			SimpleAsyncCallback<CollectionDo> collectionDoAsyncCallback) {
		this.collectionDoAsyncCallback = collectionDoAsyncCallback;
	}



	/** 
	 * This method is to set the getClasspageList
	 */
	public void setGetClasspageList(SimpleAsyncCallback<ClasspageListDo> getClasspageList) {
		this.getClasspageList = getClasspageList;
	}

	public void getAssignmentsByClasspageId(String classpageId,String pageSize, String pageNum) {
		this.classpageId = classpageId;
		AppClientFactory.getInjector().getClasspageService().v2GetAssignemtsByClasspageId(classpageId, pageSize, pageNum, getAssignmentsListAsyncCallback());
	}

	/** 
	 * This method is to get the assignmentsListAsyncCallback
	 */
	public SimpleAsyncCallback<AssignmentsListDo> getAssignmentsListAsyncCallback() {
		return assignmentsListAsyncCallback;
	}

	/** 
	 * This method is to set the assignmentsListAsyncCallback
	 */
	public void setAssignmentsListAsyncCallback(
			SimpleAsyncCallback<AssignmentsListDo> assignmentsListAsyncCallback) {
		this.assignmentsListAsyncCallback = assignmentsListAsyncCallback;
	}

	public void getNextAssignments() {
		if (classpageId!=null){
			assignmentOffSet = assignmentOffSet+10;
			getAssignmentsByClasspageId(classpageId, limit, String.valueOf(assignmentOffSet));
		}
	}
	
	/** 
	 * This method is to get the assignmentOffSet
	 */
	public int getAssignmentOffSet() {
		return assignmentOffSet;
	}

	/** 
	 * This method is to set the assignmentOffSet
	 */
	public void setAssignmentOffSet(int assignmentOffSet) {
		this.assignmentOffSet = assignmentOffSet;
	}
	/** 
	 * This method is to get the shareType
	 */
	public String getShareType() {
		return shareType;
	}

	/** 
	 * This method is to set the shareType
	 */
	public void setShareType(String shareType) {
		this.shareType = shareType;
	}	
	
	public void setPrivateLableVisibility(boolean visibility) {
		lblAssignCollectionPrivate.setVisible(visibility);
	}
	
	/**
	 * 
	 * @function setClasspageData 
	 * 
	 * @created_date : Jul 31, 2013
	 * 
	 * @description
	 * 		Create Classpage (title) label and set to Classpage list box
	 * 
	 * @parm(s) : @param classpageListDo
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setClasspageData(ClasspageListDo classpageListDo){
		


		int resultSize = classpageListDo.getSearchResults().size();
		if (resultSize > 0){
			//htmlEvenPanelContainer.setVisible(true);
			htmlPanelContainer.setVisible(true);
			if (toClear){
				htmlClasspagesListContainer.clear();
				toClear=false;
			}
			for (int i = 0; i < resultSize; i++) {
				String classpageTitle = classpageListDo.getSearchResults().get(i).getTitle();
				classpageId = classpageListDo.getSearchResults().get(i).getGooruOid();
				final Label titleLabel = new Label(classpageTitle);
				titleLabel.setStyleName(AssignPopUpCBundle.INSTANCE.css().classpageTitleText());
				titleLabel.getElement().setAttribute("id", classpageId);
				//Set Click event for title
				titleLabel.addClickHandler(new CpTitleLabelClick(titleLabel));
				htmlClasspagesListContainer.add(titleLabel);
				
			}
		}else{
			//Set if there are not classpages.
			if (toClear){
				htmlPanelContainer.setVisible(false);
				panelNoClasspages.setVisible(true);
				
			}
		}
	}
	
	public void setUnitList(ClassDo classpageListDo) {
		Label unitLabel = null;
		int resultSize = classpageListDo.getSearchResults().size();
		errorLabel.setVisible(false);
		if (resultSize > 0){
			//htmlClasspagesUnitListContainer.clear();
			if(toUnitClear){
				htmlClasspagesUnitListContainer.clear();
				toUnitClear=false;
			}
			for(int i=0;i<resultSize;i++){
				unitId = classpageListDo.getSearchResults().get(i).getResource().getGooruOid();
				String unitTitle = classpageListDo.getSearchResults().get(i).getResource().getTitle();
				unitLabel = new Label(unitTitle);
				unitLabel.setStyleName(AssignPopUpCBundle.INSTANCE.css().classpageTitleText());
				unitLabel.getElement().setAttribute("id", unitId);
				unitLabel.addClickHandler(new CpuTitleLabelClick(unitLabel));
				htmlClasspagesUnitListContainer.add(unitLabel);
			}
			lblClasspageUnitPlaceHolder.setText(classpageListDo.getSearchResults().get(0).getResource().getTitle());
			lblClasspageUnitPlaceHolder.getElement().setId(classpageListDo.getSearchResults().get(0).getResource().getGooruOid());
			lblClasspageUnitPlaceHolder.setStyleName(AssignPopUpCBundle.INSTANCE.css().selectedClasspageText());
			
			unitId = classpageListDo.getSearchResults().get(0).getResource().getGooruOid();
			
			btnAssign.setEnabled(true);
			btnAssign.setStyleName(AssignPopUpCBundle.INSTANCE.css().activeAssignButton());

			
			//Hide the scroll container
			spanelClasspagesUnitPanel.setVisible(false);
		}else{
			if(toUnitClear){
				htmlClasspagesUnitListContainer.clear();
				lblClasspageUnitPlaceHolder.setText(i18n.GL0105());
				lblClasspageUnitPlaceHolder.getElement().setId("lblClasspagePlaceHolder");
				lblClasspageUnitPlaceHolder.getElement().setAttribute("alt",i18n.GL0105());
				lblClasspageUnitPlaceHolder.getElement().setAttribute("title",i18n.GL0105());
				lblClasspageUnitPlaceHolder.removeStyleName(AssignPopUpCBundle.INSTANCE.css().selectedClasspageText());
				lblClasspageUnitPlaceHolder.setStyleName(AssignPopUpCBundle.INSTANCE.css().placeHolderText());
				errorLabel.setVisible(true);
				errorLabel.setText(i18n.GL2176());
				btnAssign.setEnabled(false);
				btnAssign.removeStyleName(AssignPopUpCBundle.INSTANCE.css().activeAssignButton());
				btnAssign.setStyleName(AssignPopUpCBundle.INSTANCE.css().disableAssignButon());
			}else{
				errorLabel.setVisible(false);
				//errorLabel.setText(i18n.GL2176());
			}
		}
	}
	
	public class CpTitleLabelClick implements ClickHandler{
		/**
		 * @param titleLabel
		 */
		
		private Label titleLabel;
		public CpTitleLabelClick(Label titleLabel) {
			this.titleLabel = titleLabel;
		}

		@Override
		public void onClick(ClickEvent event) {
			lblClasspagePlaceHolder.setText(titleLabel.getText());
			lblClasspagePlaceHolder.getElement().setId(titleLabel.getElement().getId());
			lblClasspagePlaceHolder.setStyleName(AssignPopUpCBundle.INSTANCE.css().selectedClasspageText());
			
			classpageId = titleLabel.getElement().getId();
			
			btnAssign.setEnabled(true);
			btnAssign.setStyleName(AssignPopUpCBundle.INSTANCE.css().activeAssignButton());

			
			//Hide the scroll container
			spanelClasspagesPanel.setVisible(false);
			classpageUnitOffSet=0;
			AppClientFactory.getInjector().getClasspageService().v2GetPathwaysOptimized(classpageId, limit, String.valueOf(classpageUnitOffSet), new SimpleAsyncCallback<ClassDo>() {
				@Override
				public void onSuccess(ClassDo result) {
					//htmlClasspagesUnitListContainer.clear();
					toUnitClear=true;
					setUnitList(result);
				}
			});
		}
	}
	
	public class CpuTitleLabelClick implements ClickHandler{
		
		private Label unitLabel;
		public CpuTitleLabelClick(Label unitLabel){
			this.unitLabel = unitLabel;
		}


		@Override
		public void onClick(ClickEvent event) {
			lblClasspageUnitPlaceHolder.setText(unitLabel.getText());
			lblClasspageUnitPlaceHolder.getElement().setId(unitLabel.getElement().getId());
			lblClasspageUnitPlaceHolder.setStyleName(AssignPopUpCBundle.INSTANCE.css().selectedClasspageText());
			
			unitId = unitLabel.getElement().getId();
			
			
			btnAssign.setEnabled(true);
			btnAssign.setStyleName(AssignPopUpCBundle.INSTANCE.css().activeAssignButton());

			
			//Hide the scroll container
			spanelClasspagesUnitPanel.setVisible(false);
		}
		
	}
	
	
	public void setCollectionDo(CollectionDo collectionDo) {
		this.collectionDoGlobal = collectionDo;
		createrId=collectionDo.getUser().getGooruUId();
	}
	
	
	@UiHandler("btnAssign")
	public void OnClickAssign(ClickEvent event){
		btnAssign.setEnabled(false);
		Map<String, String> parms = new HashMap<String, String>();
		parms.put("text", textAreaVal.getText());
		AppClientFactory.getInjector().getResourceService().checkProfanity(parms, new SimpleAsyncCallback<Boolean>() {
			@Override
			public void onSuccess(Boolean value) {
				if(value){
					directionsErrorLbl.setText("");
					SetStyleForProfanity.SetStyleForProfanityForTextArea(textAreaVal, directionsErrorLbl, value);
					directionsErrorLbl.setStyleName(res.css().directionsErrorLbl());
					btnAssign.setEnabled(true);
				}else{
					btnAssign.getElement().setAttribute("id", "btnAssign");
					btnAssign.setText(i18n.GL1172());
					//btnAssign.getElement().getStyle().setMarginRight(17, Unit.PCT);
					btnAssign.setEnabled(false);
					btnAssign.setStyleName(AssignPopUpCBundle.INSTANCE.css().disableAssignButon());
					
					//Track Mixpanel
					MixpanelUtil.Click_Assign_Click();
					// Api call for adding Collection to Assignment
					if(collectionDoGlobal.getSharing() != null){
						if (collectionDoGlobal.getSharing().equalsIgnoreCase("private")){
							updateShare("anyonewithlink");
							setShareType("anyonewithlink");
							lblAssignCollectionPrivate.setVisible(false);
							collectionDoGlobal.setSharing("anyonewithlink");
						}else{

						}
					}
					
				if(!createrId.equalsIgnoreCase(AppClientFactory.getGooruUid())){
					
					AppClientFactory.getInjector().getResourceService().copyCollection(collectionDoGlobal, "true", null, new SimpleAsyncCallback<CollectionDo>() {

						@Override
						public void onSuccess(final CollectionDo collectionDoResult) {
							
							final TaskResourceAssocDo taskResourceAssocDo = new TaskResourceAssocDo();
							ResourceDo resourceDo = new ResourceDo();
							resourceDo.setGooruOid(collectionDoResult.getGooruOid());
							taskResourceAssocDo.setResource(resourceDo);
							String directionsVal = textAreaVal.getText();
							if(directionsVal.equalsIgnoreCase(i18n.GL1389()))
							{
								directionsVal = "";
							}
					
							if(directionsVal.isEmpty())
							{
								directionsVal = null;
							}
							String dueDateVal = dateBoxUc.getDateBox().getValue();
							if(dueDateVal.isEmpty())
							{
								dueDateVal = null;
							}
							
							AppClientFactory.getInjector().getClasspageService().v2AssignCollectionTOPathway(classpageId, unitId, resourceDo.getGooruOid(),dueDateVal,directionsVal,null,null, new SimpleAsyncCallback<ArrayList<ClasspageItemDo>>() {

								@Override
								public void onSuccess(ArrayList<ClasspageItemDo> result) {
									MixpanelUtil.mixpanelEvent("Library_Assign_Successful");
									
									AppClientFactory.fireEvent(new RefreshCollectionInShelfListEvent(collectionDoResult, RefreshType.INSERT));
									
									controlsContainer.setVisible(false);
									btnAssign.setVisible(false);
									
									assignMoreCpContainer.setVisible(true);
									assignMoreCpLbl.setText(i18n.GL0521()+ " ");
									assignMoreCpLbl.getElement().setAttribute("alt",i18n.GL0521());
									assignMoreCpLbl.getElement().setAttribute("title",i18n.GL0521());
									
									ancClasspageTitle.setText(lblClasspagePlaceHolder.getText());
									ancClasspageTitle.getElement().setAttribute("alt",lblClasspagePlaceHolder.getText());
									ancClasspageTitle.getElement().setAttribute("title",lblClasspagePlaceHolder.getText());
								}
							});
							/*AppClientFactory.getInjector().getClasspageService().assignItemToClass(classpageId, resourceDo.getGooruOid(),dueDateVal,directionsVal, new SimpleAsyncCallback<ArrayList<ClasspageItemDo>>() {

								@Override
								public void onSuccess(ArrayList<ClasspageItemDo> result) {
									// TODO Auto-generated method stub
									MixpanelUtil.mixpanelEvent("Library_Assign_Successful");
									
									AppClientFactory.fireEvent(new RefreshCollectionInShelfListEvent(
											collectionDoResult, RefreshType.INSERT));
									
									controlsContainer.setVisible(false);
									btnAssign.setVisible(false);
									
									assignMoreCpContainer.setVisible(true);
									assignMoreCpLbl.setText(i18n.GL0521()+ " ");
									assignMoreCpLbl.getElement().setAttribute("alt",i18n.GL0521());
									assignMoreCpLbl.getElement().setAttribute("title",i18n.GL0521());
									
									ancClasspageTitle.setText(lblClasspagePlaceHolder.getText());
									ancClasspageTitle.getElement().setAttribute("alt",lblClasspagePlaceHolder.getText());
									ancClasspageTitle.getElement().setAttribute("title",lblClasspagePlaceHolder.getText());
								}
							});*/
							/*AppClientFactory.getInjector().getClasspageService().createClassPageItem(classpageId, resourceDo.getGooruOid(),dueDateVal,directionsVal, new SimpleAsyncCallback<ClasspageItemDo>() {
								@Override
								public void onSuccess(ClasspageItemDo result) {

									MixpanelUtil.mixpanelEvent("Library_Assign_Successful");
									
									AppClientFactory.fireEvent(new RefreshCollectionInShelfListEvent(
											collectionDoResult, RefreshType.INSERT));
									
									controlsContainer.setVisible(false);
									btnAssign.setVisible(false);
									
									assignMoreCpContainer.setVisible(true);
									assignMoreCpLbl.setText(i18n.GL0521()+ " ");
									assignMoreCpLbl.getElement().setAttribute("alt",i18n.GL0521());
									assignMoreCpLbl.getElement().setAttribute("title",i18n.GL0521());
									
									ancClasspageTitle.setText(lblClasspagePlaceHolder.getText());
									ancClasspageTitle.getElement().setAttribute("alt",lblClasspagePlaceHolder.getText());
									ancClasspageTitle.getElement().setAttribute("title",lblClasspagePlaceHolder.getText());
								}
							});*/
						}
						
					});

				}
				else
				{
					final TaskResourceAssocDo taskResourceAssocDo = new TaskResourceAssocDo();
					ResourceDo resourceDo = new ResourceDo();
					resourceDo.setGooruOid(collectionDoGlobal.getGooruOid());
					taskResourceAssocDo.setResource(resourceDo);
					String directionsVal = textAreaVal.getText();
					if(directionsVal.equalsIgnoreCase(i18n.GL1389()))
					{
						directionsVal = "";
					}
					if(directionsVal.isEmpty())
					{
						directionsVal = null;
					}
					String dueDateVal = dateBoxUc.getDateBox().getValue();
					if(dueDateVal.isEmpty())
					{
						dueDateVal = null;
					}
					AppClientFactory.getInjector().getClasspageService().v2AssignCollectionTOPathway(classpageId, unitId, collectionDoGlobal.getGooruOid(),null,null,dueDateVal,directionsVal, new SimpleAsyncCallback<ArrayList<ClasspageItemDo>>() {

						@Override
						public void onSuccess(ArrayList<ClasspageItemDo> result) {
							MixpanelUtil.mixpanelEvent("Library_Assign_Successful");
							controlsContainer.setVisible(false);
							btnAssign.setVisible(false);
							assignMoreCpContainer.setVisible(true);
							assignMoreCpLbl.setText(i18n.GL0521()+" ");
							assignMoreCpLbl.getElement().setAttribute("alt",i18n.GL0521()+" ");
							assignMoreCpLbl.getElement().setAttribute("title",i18n.GL0521());
							ancClasspageTitle.setText(lblClasspagePlaceHolder.getText());
							ancClasspageTitle.getElement().setAttribute("alt",lblClasspagePlaceHolder.getText());
							ancClasspageTitle.getElement().setAttribute("title",lblClasspagePlaceHolder.getText());
						}
					});
					/*AppClientFactory.getInjector().getClasspageService().assignItemToClass(classpageId, collectionDoGlobal.getGooruOid(), dueDateVal, directionsVal, new SimpleAsyncCallback<ArrayList<ClasspageItemDo>>() {

						@Override
						public void onSuccess(ArrayList<ClasspageItemDo> result) {
							// TODO Auto-generated method stub
							MixpanelUtil.mixpanelEvent("Library_Assign_Successful");
							
							controlsContainer.setVisible(false);
							btnAssign.setVisible(false);
							assignMoreCpContainer.setVisible(true);
							assignMoreCpLbl.setText(i18n.GL0521()+" ");
							assignMoreCpLbl.getElement().setAttribute("alt",i18n.GL0521()+" ");
							assignMoreCpLbl.getElement().setAttribute("title",i18n.GL0521());
							ancClasspageTitle.setText(lblClasspagePlaceHolder.getText());
							ancClasspageTitle.getElement().setAttribute("alt",lblClasspagePlaceHolder.getText());
							ancClasspageTitle.getElement().setAttribute("title",lblClasspagePlaceHolder.getText());
						}
					});*/
					
					/*AppClientFactory.getInjector().getClasspageService().createClassPageItem(classpageId,collectionDoGlobal.getGooruOid(),dueDateVal,directionsVal, new SimpleAsyncCallback<ClasspageItemDo>() {
						@Override
						public void onSuccess(ClasspageItemDo result) {
							//closePoupfromChild();
							MixpanelUtil.mixpanelEvent("Library_Assign_Successful");
							
							controlsContainer.setVisible(false);
							btnAssign.setVisible(false);
							
							assignMoreCpContainer.setVisible(true);
							assignMoreCpLbl.setText(i18n.GL0521()+" ");
							assignMoreCpLbl.getElement().setAttribute("alt",i18n.GL0521()+" ");
							assignMoreCpLbl.getElement().setAttribute("title",i18n.GL0521());
							ancClasspageTitle.setText(lblClasspagePlaceHolder.getText());
							ancClasspageTitle.getElement().setAttribute("alt",lblClasspagePlaceHolder.getText());
							ancClasspageTitle.getElement().setAttribute("title",lblClasspagePlaceHolder.getText());
						}
					});	*/
				}
					MixpanelUtil.mixpanelEvent("CoursePage_Assign_Collection");
					btnAssign.setEnabled(true);
				}
			}
		});
	}
	
	@UiHandler("classPageBtn")
	public void classPageBtnClicked(ClickEvent event) {
		htmlClasspagesListContainer.clear();
		htmlClasspagesUnitListContainer.clear();
		controlsContainer.setVisible(true);
		btnAssign.setVisible(true);
		
		btnAssign.getElement().setAttribute("id", "btnAssign");
		btnAssign.setText(i18n.GL0104());
		
		textAreaVal.setText("");
		dateBoxUc.getDateBox().setValue("");
		
		getClassPageData();
	}
	
	public void updateShare(String shareType) 
	{
		AppClientFactory.getInjector().getResourceService().updateCollectionMetadata(collectionDoGlobal.getGooruOid(), null, null, null, shareType, null, null, null, null, null, new SimpleAsyncCallback<CollectionDo>() {

			@Override
			public void onSuccess(CollectionDo result) {
				collectionDoGlobal = result;
				AppClientFactory.fireEvent(new CollectionEditShareEvent(result.getSharing()));
			}
		});
	}


	@Override
	public Widget getDragHandle() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public IsDraggableMirage initDraggableMirage() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void onDragBlur() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String getDragId() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public DRAG_TYPE getDragType() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getDragTopCorrection() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getDragLeftCorrection() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void getClasspage(CollectionDo collectionDo, String shareType){
		this.shareType = shareType;
		this.collectionDoGlobal = collectionDo;
	
		setCollectionDo(collectionDo);
		
				//This condition is added because, this method is called thrice from shelf
			classpageOffSet = 0;
			isApiCalling = true;
			/**
			 * getting available classpages of the user
			 */
			getAllClasspages(limit, String.valueOf(classpageOffSet));
			
			//hideContainers();
		
	}
	public void getAllClasspages(String limit, String offSet) {
		AppClientFactory.getInjector().getClasspageService().v2GetAllClasspages(limit, offSet, getGetClasspageList());
		
		
	}
	
	public void getAllClasspagesUnit(String classpageId,String limit,String offset){
		this.classpageId = classpageId;
		AppClientFactory.getInjector().getClasspageService().v2GetPathwaysOptimized(classpageId, limit, String.valueOf(offset), new SimpleAsyncCallback<ClassDo>() {

			@Override
			public void onSuccess(ClassDo result) {
				setUnitList(result);
			}
		});
	}
	public void getNextClasspages() {
		classpageOffSet = classpageOffSet+10;
		getAllClasspages(limit,String.valueOf(classpageOffSet));
	}
	
	public void getNextClasspagesUnit(){
		if(classpageId!=null){
			classpageUnitOffSet = classpageUnitOffSet+10;
			getAllClasspagesUnit(classpageId,limit,String.valueOf(classpageUnitOffSet));
		}
		
	}
	
	@UiHandler("lblClasspagePlaceHolder")
	public void OnClickClasspagePlaceHolder(ClickEvent event){
		OpenClasspageContainer();
	}
	@UiHandler("lblClasspagesArrow")
	public void OnClickClasspageArrow(ClickEvent event){
		OpenClasspageContainer();
	}
	
	@UiHandler("lblClasspagesUnitArrow")
	public void OnClickClasspageUnitArrow(ClickEvent event){
		OpenClasspageUnitContainer();
	}
	
	@UiHandler("lblClasspageUnitPlaceHolder")
	public void OnClickClasspageUnitPlaceHolder(ClickEvent event){
		OpenClasspageUnitContainer();
	}
	
	public void OpenClasspageContainer(){
		spanelClasspagesPanel.setVisible(!spanelClasspagesPanel.isVisible());

		
		
	}
	
	public void OpenClasspageUnitContainer(){
		spanelClasspagesUnitPanel.setVisible(!spanelClasspagesUnitPanel.isVisible());

		
		
	}
	
	public void setLabelsAndIds()
	{
		panelTitleContainer.getElement().setId("pnlTitleContainer");

		lblAssignCollectionPrivate.setText(i18n.GL0112());
		lblAssignCollectionPrivate.getElement().setId("lblAssignCollectionPrivate");
		lblAssignCollectionPrivate.getElement().setAttribute("alt",i18n.GL0112());
		lblAssignCollectionPrivate.getElement().setAttribute("title",i18n.GL0112());
		lblAssignCollectionPrivate.setVisible(false);
		
		lblAssignCollectionTitle.setText(i18n.GL0101());
		lblAssignCollectionTitle.getElement().setId("lblAssignCollectionTitle");
		lblAssignCollectionTitle.getElement().setAttribute("alt",i18n.GL0101());
		lblAssignCollectionTitle.getElement().setAttribute("title",i18n.GL0101());
		
		
		lblClasspages.setText(i18n.GL0102());
		lblClasspages.getElement().setId("lblClasspages");
		lblClasspages.getElement().setAttribute("alt",i18n.GL0102());
		lblClasspages.getElement().setAttribute("title",i18n.GL0102());
		
		lblClasspagesUnits.setText(i18n.GL2175());
		lblClasspagesUnits.getElement().setId("lblClasspagesUnit");
		lblClasspagesUnits.getElement().setAttribute("alt",i18n.GL2175());
		lblClasspagesUnits.getElement().setAttribute("title",i18n.GL2175());
		
		
		btnAssign.setText(i18n.GL0104());
		btnAssign.getElement().setAttribute("alt",i18n.GL0104());
		btnAssign.getElement().setAttribute("title",i18n.GL0104());
		
		lblClasspagePlaceHolder.setText(i18n.GL0105());
		lblClasspagePlaceHolder.getElement().setId("lblClasspagePlaceHolder");
		lblClasspagePlaceHolder.getElement().setAttribute("alt",i18n.GL0105());
		lblClasspagePlaceHolder.getElement().setAttribute("title",i18n.GL0105());
		
		lblClasspageUnitPlaceHolder.setText(i18n.GL0105());
		lblClasspageUnitPlaceHolder.getElement().setId("lblClasspagePlaceHolder");
		lblClasspageUnitPlaceHolder.getElement().setAttribute("alt",i18n.GL0105());
		lblClasspageUnitPlaceHolder.getElement().setAttribute("title",i18n.GL0105());
		
		classPageBtn.setText(i18n.GL0517());
		classPageBtn.getElement().setId("btnClassPage");
		classPageBtn.getElement().setAttribute("alt",i18n.GL0517());
		classPageBtn.getElement().setAttribute("title",i18n.GL0517());
	
		//Ids
		btnAssign.getElement().setAttribute("id", "btnAssign");
		btnAssign.setStyleName(res.css().disableAssignButon());
		btnAssign.getElement().getStyle().setMarginLeft(190, Unit.PX);
		btnAssign.setEnabled(false);
		btnAssign.setStyleName(AssignPopUpCBundle.INSTANCE.css().disableAssignButon());

		lblClasspagePlaceHolder.setStyleName(AssignPopUpCBundle.INSTANCE.css().placeHolderText());
		lblClasspageUnitPlaceHolder.setStyleName(AssignPopUpCBundle.INSTANCE.css().placeHolderText());

		panelNoClasspages.getElement().setId("pnlNoClasspages");
		lblNoClassPageImage.getElement().setId("imgLblNoClassPageImage");
		lblNoClassPage.getElement().setId("lblNoClassPage");
		lblNoClassPageMsg.getElement().setId("lblNoClassPageMsg");
		loadingImageLabel.getElement().setId("pnlLoadingImageLabel");
		htmlPanelContainer.getElement().setId("pnlHtmlPanelContainer");
		controlsContainer.getElement().setId("pnlControlsContainer");
		lblClasspagesArrow.getElement().setId("lblClasspagesArrow");
		lblClasspagesUnitArrow.getElement().setId("lblClasspagesUnitArrow");
		spanelClasspagesPanel.getElement().setId("sbSpanelClasspagesPanel");
		spanelClasspagesUnitPanel.getElement().setId("spanelClasspagesUnitPanel");
		htmlClasspagesListContainer.getElement().setId("pnlHtmlClasspagesListContainer");
		htmlClasspagesUnitListContainer.getElement().setId("pnlhtmlClasspagesUnitListContainer");
		lblDuedate.getElement().setId("lblDuedate");
		lblDuedateOptional.getElement().setId("lblDuedateOptional");
		duedateContainer.getElement().setId("pnlDuedateContainer");
		lblDirections.getElement().setId("lblDirections");
		lblDirectionsOptional.getElement().setId("lblDirectionsOptional");
		textAreaVal.getElement().setId("tatTextAreaVal");
		directionsErrorLbl.getElement().setId("errlblDirectionsErrorLbl");
		assignMoreCpContainer.getElement().setId("pnlAssignMoreCpContainer");
		assignMoreCpLbl.getElement().setId("spnAssignMoreCpLbl");
		ancClasspageTitle.getElement().setId("spnAncClasspageTitle");
	}
	
	public abstract void closePoupfromChild();
	
	@UiHandler("ancClasspageTitle")
	public void onClickAncClasspageTitle(ClickEvent clickevent) {
//		getAssignmentView();
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("classpageid", classpageId);
		params.put("pageSize", "10");
		params.put("pageNum", "0");
		params.put("pos", "1");
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.EDIT_CLASSPAGE,params);
		AppClientFactory.fireEvent(new RefreshUserShelfCollectionsEvent());
		closePoupfromChild();
	}
	
}
