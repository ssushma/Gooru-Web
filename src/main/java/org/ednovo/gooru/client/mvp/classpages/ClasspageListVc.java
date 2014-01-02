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
package org.ednovo.gooru.client.mvp.classpages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.classpages.event.DeleteClasspageListEvent;
import org.ednovo.gooru.client.mvp.classpages.event.DeleteClasspageListHandler;
import org.ednovo.gooru.client.mvp.classpages.event.RefreshClasspageListEvent;
import org.ednovo.gooru.client.mvp.classpages.event.RefreshClasspageListHandler;
import org.ednovo.gooru.client.mvp.classpages.event.SetSelectedClasspageListEvent;
import org.ednovo.gooru.client.mvp.classpages.event.SetSelectedClasspageListHandler;
import org.ednovo.gooru.client.mvp.classpages.event.UpdateClasspageTitleEvent;
import org.ednovo.gooru.client.mvp.classpages.event.UpdateClasspageTitleHandler;
import org.ednovo.gooru.client.mvp.classpages.newclasspage.NewClasspagePopupView;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.content.AssignmentDo;
import org.ednovo.gooru.shared.model.content.AttachToDo;
import org.ednovo.gooru.shared.model.content.ClasspageListDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.TaskDo;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.event.dom.client.ScrollHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : ClasspageListVc.java
 * 
 * @description : This class is used to display the List of Classpaes on
 *              clicking on Teach Tab.
 * 
 * @version : 1.0
 * 
 * @date: Aug 14, 2013
 * 
 * @Author Anil Kumar T
 * 
 * @Reviewer:
 */
public class ClasspageListVc extends PopupPanel implements MessageProperties {

	@UiField
	Label lblLoading, lblNoClasspageYet;
	@UiField
	HTMLPanel htmlPanelContentContainer, htmlPanelNoClasspageContainer;
	@UiField VerticalPanel htmlPanelClasspageList;
	@UiField
	Anchor ancNewClasspage;

	@UiField
	InlineLabel inLineLblCheckOut;//, inLineLblGooruGuide, inLineLblCreateOne;

	@UiField
	ScrollPanel spanelCollectionList;

	ClasspageListDo classpageListDo = null;

	Map<String, CollectionDo> classpageList = new HashMap<String, CollectionDo>();
	ArrayList<String> listClasspage = new ArrayList<String>();
	
	private int limit = 10;
	private int offSet = 0;
	private int tmpOffSet = 0;
	private boolean toClear = false;
	private boolean isApiCalling = false;
	private boolean whileDeleting = false;
	private int resultSize = 0;

	private static ClasspageListVcUiBinder uiBinder = GWT
			.create(ClasspageListVcUiBinder.class);

	interface ClasspageListVcUiBinder extends UiBinder<Widget, ClasspageListVc> {
	}

	@UiField(provided = true)
	ClasspageListPopupViewCBundle res;

	private NewClasspagePopupView newPopup = null;

	/**
	 * Class constructor
	 */
	public ClasspageListVc() {
		super(true);
		this.res = ClasspageListPopupViewCBundle.INSTANCE;
		res.css().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));
		ancNewClasspage.getElement().setId("lnkNewClasspage");
//	    inLineLblGooruGuide.getElement().setId("lnkGooruGuide");

		
		SetSelectedClasspageListHandler setSelectedHandler = new SetSelectedClasspageListHandler() {
			
			@Override
			public void setClasspageTitle(String classpageId) {
//				setClassapageItemSeleted(classpageId);
				setClasspageSetSelected(classpageId);
			}
		};

		DeleteClasspageListHandler deleteHandler = new DeleteClasspageListHandler() {
			
			@Override
			public void deleteClasspage(String classpageId) {
				removeClasspageItem(classpageId);
			}
		};
		
		RefreshClasspageListHandler refreshHandler = new RefreshClasspageListHandler() {
			
			@Override
			public void refreshClasspage() {
				toClear= true;
				offSet = 0;
				getAllClasspages(String.valueOf(offSet));
			}
		};
		
		UpdateClasspageTitleHandler updateTitleHandler = new UpdateClasspageTitleHandler() {
			
			@Override
			public void updateClasspageTitle(String classpageId, String classpageTitle) {
				updateTitle(classpageId, classpageTitle);
			}
		};
		
		AppClientFactory.getEventBus().addHandler(SetSelectedClasspageListEvent.TYPE, setSelectedHandler);
		AppClientFactory.getEventBus().addHandler(DeleteClasspageListEvent.TYPE, deleteHandler);
		AppClientFactory.getEventBus().addHandler(RefreshClasspageListEvent.TYPE, refreshHandler);
		AppClientFactory.getEventBus().addHandler(UpdateClasspageTitleEvent.TYPE, updateTitleHandler);
		
		spanelCollectionList.addScrollHandler(new ScrollHandler() {
			
			@Override
			public void onScroll(ScrollEvent event) {
				if (spanelCollectionList.getVerticalScrollPosition() == spanelCollectionList.getMaximumVerticalScrollPosition() && !isApiCalling && resultSize >=limit){
					tmpOffSet = offSet;
					offSet+=limit;
					htmlPanelClasspageList.add(createClasspageTitleLabel("Loading...", "lblLoading", true));
					isApiCalling = true;
					getAllClasspages(String.valueOf(offSet));
				}
			}
		});
		
		
		
		setLabels();
		showLoading();
		toClear= true;
		getAllClasspages(String.valueOf(offSet));
	}
	
	/**
	 * 
	 * @function updateTitle 
	 * 
	 * @created_date : Aug 21, 2013
	 * 
	 * @description
	 * 
	 * @parm(s) : @param classpageId
	 * 
	 * @parm(s) : @param classpageTitle
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	
	private void updateTitle(String classpageId, String classpageTitle){
		Iterator<Widget> widgets = htmlPanelClasspageList.iterator();
		while (widgets.hasNext()) {
			Widget widget = widgets.next();
			if (widget.getElement().getId().equalsIgnoreCase(classpageId)){
				widget.getElement().setInnerHTML(classpageTitle);
			}
		}
		
		// Update the ClasspageObject inside classpageList object.
		
		CollectionDo  classpageDo =  classpageList.get(classpageId);
		classpageDo.setTitle(classpageTitle);
		
		classpageList.put(classpageId, classpageDo);
		
	}
	
	/**
	 * 
	 * @function showDefualts
	 * 
	 * @created_date : Aug 14, 2013
	 * 
	 * @description This method to show Loading content by default and hide
	 *              Content Container.
	 * 
	 * @parm(s) :
	 * 
	 * @return : void
	 * 
	 */
	private void showLoading() {
		lblLoading.setVisible(true);
		htmlPanelNoClasspageContainer.setVisible(false);
		spanelCollectionList.setVisible(false);
	}
	/**
	 * 
	 * @function showClasspageList 
	 * 
	 * @created_date : Aug 21, 2013
	 * 
	 * @description : This method is used to set visible the class pages list.
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private void showClasspageList() {
		lblLoading.setVisible(false);
		htmlPanelNoClasspageContainer.setVisible(false);
		spanelCollectionList.setVisible(true);
	}
	/**
	 * 
	 * @function showNoClasspages 
	 * 
	 * @created_date : Aug 21, 2013
	 * 
	 * @description : This method is used to set the visible the no class pages.
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 */
	private void showNoClasspages() {
		lblLoading.setVisible(false);
		htmlPanelNoClasspageContainer.setVisible(true);
		spanelCollectionList.setVisible(false);
	}
	/**
	 * 
	 * @function setLabels
	 * 
	 * @created_date : Aug 14, 2013
	 * 
	 * @description This method is used to set the Label text.
	 * 
	 * @parm(s) :
	 * 
	 * @return : void
	 * 
	 */
	private void setLabels() {
		lblLoading.setText(MessageProperties.GL0110);
		ancNewClasspage.setText(MessageProperties.GL0115);

		lblNoClasspageYet.setText(MessageProperties.GL0117);
		inLineLblCheckOut.setText(MessageProperties.GL0118);
//		inLineLblGooruGuide.setText(MessageProperties.GL0119);
//		inLineLblCreateOne.setText(MessageProperties.GL0120);

	}

	/**
	 * 
	 * @function getAllClasspages
	 * 
	 * @created_date : Aug 15, 2013
	 * 
	 * @description : This method is used to get the all the list of class pages.
	 * 
	 * @parm(s) : @param offSet
	 * 
	 * @return : void
	 * 
	 * @throws : <Mentioned if any exceptions>
	 */
	public void getAllClasspages(String offSet) {
		AppClientFactory.getInjector().getClasspageService().v2GetAllClasspages(String.valueOf(limit), offSet,
						new SimpleAsyncCallback<ClasspageListDo>() {
							@Override
							public void onSuccess(ClasspageListDo result) {
								classpageListDo = result;
								listClasspages(result);
							}
						});
	}
	/**
	 * 
	 * @function listClasspages 
	 * 
	 * @created_date : Aug 15, 2013
	 * 
	 * @description: This method will set all the list of class pages in the front end.
	 * 
	 * @parm(s) : @param result
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 */
	private void listClasspages(ClasspageListDo result) {
		lblLoading.setVisible(false);
		isApiCalling = false;
		if(classpageListDo!=null){
			resultSize=classpageListDo.getSearchResults()!=null?classpageListDo.getSearchResults().size():0;
		}else{
			resultSize =0;
		}
		if (resultSize > 0) {
			htmlPanelNoClasspageContainer.setVisible(false);
			htmlPanelClasspageList.setVisible(true);
			spanelCollectionList.setVisible(true);
			if (toClear) {
				htmlPanelClasspageList.clear();
				toClear = false;
				classpageList.clear();
			}
			
			for (int i = 0; i < resultSize; i++) {
				String classpageId = classpageListDo.getSearchResults().get(i)
						.getGooruOid();				
				classpageList.put(classpageId, classpageListDo.getSearchResults().get(i));
				listClasspage.add(classpageId);
			}
			generateClasspageList();
		} else {
			// Set no classpage info, if there are not classpages.
			if (toClear) {
				htmlPanelNoClasspageContainer.setVisible(true);
			}
			offSet = tmpOffSet;
			Element element=Document.get().getElementById("lblLoading");
			if(element!=null){
				element.removeFromParent();
			}
			if (whileDeleting){
				whileDeleting = false;
				showNoClasspages();
//				AppClientFactory.getPlaceManager().revealPlace(
//						PlaceTokens.TEACH);
//			}else{
//				AppClientFactory.getPlaceManager().revealPlace(
//						PlaceTokens.HOME);
			}
		}
	}
	/**
	 * 
	 * @function generateClasspageList 
	 * 
	 * @created_date : Aug 18, 2013
	 * 
	 * @description: This method is used to generate the class pages list.
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void generateClasspageList(){
		htmlPanelClasspageList.clear();
		for (int i=0;i<listClasspage.size();i++){
			String classpageTitle = classpageList.get(listClasspage.get(i)).getTitle();
			htmlPanelClasspageList.add(createClasspageTitleLabel(
				classpageTitle, listClasspage.get(i), false));
		}
	}
	
	
	/**
	 * 
	 * @function createClasspageTitleLabel
	 * 
	 * @created_date : Aug 15, 2013
	 * 
	 * @description: This method is used to crate the class page title.
	 * 
	 * @parm(s) : @param classpageTitle
	 * @parm(s) : @param classpageId
	 * @parm(s) : @return
	 * 
	 * @return : Label
	 * 
	 * @throws : <Mentioned if any exceptions>
	 * 
	 */
	private Label createClasspageTitleLabel(String classpageTitle,
			final String classpageId, boolean isStatic) {
		Label titleLabel = null;
		
		if (classpageTitle.length() >=30){
			titleLabel = new Label(classpageTitle.substring(0, 30));
		}else{
			titleLabel = new Label(classpageTitle);
		}
		titleLabel.getElement().setAttribute("id", classpageId);
		if (!isStatic){
			titleLabel.setStyleName(ClasspageListPopupViewCBundle.INSTANCE.css().classpageTitleHeader());
		}else{
			titleLabel.setStyleName(ClasspageListPopupViewCBundle.INSTANCE.css().classpageLoadingOnPagination());
		}
		// Set Click event for title
		titleLabel.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				 OpenClasspageEdit(classpageId);
				 hide();
			}
		});
		return titleLabel;
	}
	
	// Ui Handlers.
//	@UiHandler("inLineLblGooruGuide")
//	public void onClickGooruGuide(ClickEvent event){
//		
//	}
	
	/**
	 * 
	 * @function onClickNewClasspage 
	 * 
	 * @created_date : Aug 21, 2013
	 * 
	 * @description: This will handle the click event of the NewClasspage
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("ancNewClasspage")
	public void onClickNewClasspage(ClickEvent event) {
		MixpanelUtil.ClickOnNewClassPage();
		hide();
		newPopup = new NewClasspagePopupView() {

			@Override
			public void createNewClasspage(String title) {
				
				MixpanelUtil.Create_NewClasspage();
				CollectionDo collectionDo = new CollectionDo();
				collectionDo.setTitle(title);
				collectionDo.setCollectionType("classpage");
				AppClientFactory
						.getInjector()
						.getClasspageService()
						.createClasspage(collectionDo,
								new SimpleAsyncCallback<CollectionDo>() {
									@Override
									public void onSuccess(CollectionDo result) {
										final String classpageId = result.getGooruOid();
//										final String classpageTitle = result.getTitle();
										AssignmentDo assignmentDo = new AssignmentDo();
										assignmentDo.setClasspageId(classpageId);
										
										TaskDo taskDo = new TaskDo();
										taskDo.setTitle(MessageProperties.GL0121);
										taskDo.setTypeName("assignment");
										assignmentDo.setTask(taskDo);
										
										AttachToDo attachToDo = new AttachToDo();
										attachToDo.setId(classpageId);
										attachToDo.setType("classpage");
										
										assignmentDo.setAttachTo(attachToDo);
										listClasspage.add(0, classpageId);
										
										classpageList.put(classpageId, result);
										
										AppClientFactory.getInjector().getClasspageService().v2CreateAssignment(assignmentDo, new SimpleAsyncCallback<AssignmentDo>() {

											@Override
											public void onSuccess(
													AssignmentDo result) {
												// Assig to classpage.
												htmlPanelClasspageList.clear();
												generateClasspageList();
												showClasspageList();
												OpenClasspageEdit(classpageId);
												
												newPopup.ClosePopup();
											}
										});
									}
								});
			}
		};
	}

	/**
	 * 
	 * @function OpenClasspageEdit
	 * 
	 * @created_date : Aug 15, 2013
	 * 
	 * @description: This methosd is used to open the class page list in edit mode.
	 * 
	 * @parm(s) : @param gooruOId
	 * 
	 * @return : void
	 * 
	 * @throws : <Mentioned if any exceptions>
	 */
	private void OpenClasspageEdit(String gooruOId) {
		setClassapageItemSeleted(gooruOId);
		Map<String, String> params = new HashMap<String, String>();
		params.put("classpageid", gooruOId);
		params.put("pageNum", "0");
		params.put("pageSize", "10");
		params.put("pos", "1");
		AppClientFactory.getPlaceManager().revealPlace(
				PlaceTokens.EDIT_CLASSPAGE, params);
	}

	/**
	 * 
	 * @function setClassapageItemSeleted
	 * 
	 * @created_date : Aug 15, 2013
	 * 
	 * @description: This method is used to set the  selected  class page Item.
	 * 
	 * @parm(s) : @param classpageId
	 * 
	 * @return : void
	 * 
	 * @throws : <Mentioned if any exceptions>
	 */
	private void setClassapageItemSeleted(String classpageId) {
		
		for (int i = 0; i < listClasspage.size(); i++) {
			Element element=Document.get().getElementById(listClasspage.get(i));
			if(element!=null){
				element.setClassName(res.css().classpageTitleHeader());
			}
		}
		if(classpageId!=null && !classpageId.equalsIgnoreCase("")){
			Element element=Document.get().getElementById(classpageId);
			if(element!=null){
				element.setClassName(res.css().classpageTitleHeaderActive());
			}
		}
	}
	/**
	 * 
	 * @function setClasspageSetSelected 
	 * 
	 * @created_date : Aug 21, 2013
	 * 
	 * @description : This method is used to set the  selected  class page.
	 * 
	 * @parm(s) : @param classpageId
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private void setClasspageSetSelected(String classpageId){
		Iterator<Widget> widgets = htmlPanelClasspageList.iterator();
		while (widgets.hasNext()) {
			Widget widget = widgets.next();
			if (widget.getElement().getId().equalsIgnoreCase(classpageId)){
				widget.getElement().setClassName(res.css().classpageTitleHeaderActive());
			}else{
				widget.getElement().setClassName(res.css().classpageTitleHeader());
			}
		}
	}
	/**
	 * 
	 * @function removeClasspageItem 
	 * 
	 * @created_date : Aug 15, 2013
	 * 
	 * @description : This method is used to remove the  selected  class page Item.
	 * 
	 * @parm(s) : @param classpageId
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private void removeClasspageItem(String classpageId) {
		String nextClasspageId = null;
		int listCount = listClasspage.size();
		for (int i=0; i<listClasspage.size(); i++){			
			if (listClasspage.get(i).equalsIgnoreCase(classpageId)){
				if (i==(listCount-1)){
					if ((listCount-1) >0 ){
						nextClasspageId =  listClasspage.get(i-1);
					}else{
						nextClasspageId = null;
					}
					
				}else{
					nextClasspageId =  listClasspage.get(i+1);
				}
				listClasspage.remove(i);
				classpageList.remove(classpageId);
			}
		}
		htmlPanelClasspageList.clear();
		generateClasspageList();
		if (nextClasspageId!=null){
			OpenClasspageEdit(nextClasspageId);
		}else{
			showNoClasspages();
			AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.HOME);
//			whileDeleting = true;
//			getAllClasspages("0");
		}
	}
}
