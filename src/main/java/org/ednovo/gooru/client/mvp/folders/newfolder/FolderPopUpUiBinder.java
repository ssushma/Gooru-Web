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
package org.ednovo.gooru.client.mvp.folders.newfolder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BasePopupViewWithHandlers;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionCBundle;
import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.client.uc.BlueButtonUc;
import org.ednovo.gooru.client.uc.TextBoxWithPlaceholder;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.code.LibraryCodeDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.tractionsoftware.gwt.user.client.ui.GroupedListBox;

/**
 * 
 * @author BLR Team.
 *
 */

public class FolderPopUpUiBinder extends
		BasePopupViewWithHandlers<FoldersPopupUiHandlers> implements
		IsFoldersPopupView {

	@UiField
	TextBoxWithPlaceholder collectionTitleTxtBox;

	@UiField
	SimplePanel collectionGradeTxtBox;

	GroupedListBox courseLisBox;

	@UiField
	SimplePanel groupSimPanel;

	@UiField
	FlowPanel buttonFloPanel;

	@UiField
	Anchor cancelAnr;

	@UiField
	BlueButtonUc okBtnUc;

	@UiField
	FlowPanel validationErrorFloPanel;

	@UiField
	Label validationErrorLbl;

	@UiField(provided = true)
	CollectionCBundle res;
	private AppPopUp appPopUp;

	private CollectionDo collectionDo = new CollectionDo();

	public static final String GRADE_INFO = "Please select which grade the content in this folder is for. It helps us classify it!";

	public static final String COURSE_INFO = "Please select which Course the content in this folder is for. It helps us classify it!";

	private static final String TITLE_THIS_COLLECTION = "New Folder";

	final String[] list = { "- Select a grade -","Kindergarten", "1", "2", "3", "4", "5", "6", "7",
			"8", "9", "10", "11", "12", "Higher Education" };

	ListBox dropDownList = new ListBox();
	
	private String folderGrade = null;
	
	private String folderCourse = null;
	
	private Integer folderCourseId = 0;

	private static FolderPopUpUiBinderUiBinder uiBinder = GWT
			.create(FolderPopUpUiBinderUiBinder.class);

	interface FolderPopUpUiBinderUiBinder extends
			UiBinder<Widget, FolderPopUpUiBinder> {
	}

	/**
	 * Class constructor, to create new folder popup.
	 * 
	 * @param eventBus
	 *            {@link EventBus}
	 */
	@Inject
	public FolderPopUpUiBinder(EventBus eventBus) {
		super(eventBus);
		hideFromPopup(true);
		this.res = CollectionCBundle.INSTANCE;
		res.css().ensureInjected();

		//AppClientFactory.getEventBus().addHandler(InsertMetaDataInNewFolderEvent.TYPE,setGradeCourse);
		appPopUp = new AppPopUp();
		appPopUp.getElement().getStyle().setWidth(400, Unit.PX);
		appPopUp.setContent(TITLE_THIS_COLLECTION,
				uiBinder.createAndBindUi(this));

		buttonFloPanel.add(validationErrorFloPanel);
		validationErrorLbl.setVisible(false);
		buttonFloPanel.add(okBtnUc);
		buttonFloPanel.add(cancelAnr);
		appPopUp.setTitle("New Folder");
		appPopUp.center();
		okBtnUc.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (validateCollectionForm().size() == 0) {
					GWT.log("on ok click");
					okBtnUc.setEnabled(false);
					CollectionDo collectionDo = new CollectionDo();
					collectionDo.setTitle(collectionTitleTxtBox.getValue());
					
					if(!(dropDownList.getSelectedIndex() == 0)){
						collectionDo.setGrade(list[dropDownList.getSelectedIndex()]);
					} else {
						collectionDo.setGrade("");
					}
					Set<CodeDo> codeDoSet = new HashSet<CodeDo>();
					CodeDo codeDo = new CodeDo();
					String courseCodeId = getCourseCodeId();
					if(courseCodeId!=null) {
						codeDo.setCodeId(Integer.parseInt(getCourseCodeId()));
					} else {
						codeDo.setCodeId(null);
					}
					codeDoSet.add(codeDo);
					collectionDo.setTaxonomySet(codeDoSet);
					collectionDo.setCollectionType("folder");
					
					String folderId = AppClientFactory.getPlaceManager().getRequestParameter("folderid");
					
					if(folderId!=null){
						AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));	
						getUiHandlers().createFolderToParentFolder(collectionDo, folderId);
					} else {
						AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));	
						getUiHandlers().createFolder(collectionDo);
					}
						
				}
			}
		});
		
		/**
		 * Added click handler to hide new folder pop up.
		 * @param clickEvent instance of {@link ClickEvent} 
		 */
		
		cancelAnr.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GWT.log("on Cancel click");
				appPopUp.hide();
				AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));	
			}
		});
		setAutoHideOnNavigationEventEnabled(true);
		getGradeList();
		
		collectionTitleTxtBox.getElement().setId("txtCollectionTitle");
		validationErrorLbl.getElement().setId("errlblValidation");
		collectionGradeTxtBox.getElement().setId("spnlCollectionGrade");
		groupSimPanel.getElement().setId("spnlGroupSimPanel");
		buttonFloPanel.getElement().setId("fpnlButtonFloPanel");
		validationErrorFloPanel.getElement().setId("fpnlValidationErrorFloPanel");
		okBtnUc.getElement().setId("btnOkBtnUc");
		cancelAnr.getElement().setId("lnkCancelAnr");
	}
	
/*	InsertMetaDataInNewFolderHandler setGradeCourse=new InsertMetaDataInNewFolderHandler(){

		@Override
		public void insertMetaDataInNewFolder(String grade, String course, Integer courseId) {
			folderGrade = grade;
			folderCourse = course;
			folderCourseId = courseId;
		}
       
	};
*/	
	
	/**
	 * Added click handler for textbox to perform basic validations.
	 * @param event instance of {@link KeyUpEvent} 
	 */
	@UiHandler("collectionTitleTxtBox")
	public  void keyUserNameTextBox(KeyUpEvent event){
		String titleName=collectionTitleTxtBox.getText();
		validationErrorLbl.setText("");
		if(titleName.trim().length()>0){
			validationErrorLbl.setText("");
		}
	}
	
	/**
	 *  Getting all available grades and adding into the list box.
	 */
	
	public void getGradeList() {

		dropDownList.setStyleName(CollectionCBundle.INSTANCE.css()
				.contentAlignInputs());
		dropDownList.getElement().getStyle().setWidth(330, Unit.PX);
		
			for (int i = 0; i < list.length; i++) {
				dropDownList.addItem(list[i]);
			}

		collectionGradeTxtBox.setWidget(dropDownList);
		dropDownList.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				
			}
		});
	}

	@Override
	protected String getDefaultView() {
		return PlaceTokens.FOLDERS;
	}

	@Override
	public Widget asWidget() {
		return appPopUp;
	}

	@Override
	public CollectionDo getData() {
		CollectionDo collection = new CollectionDo();
		if (this.collectionDo != null) {
			collection.setGooruOid(this.collectionDo.getGooruOid());
		}
		collection.setTitle(collectionTitleTxtBox.getText());

		collection.setCollectionType("folder");

		return collection;
	}

	@Override
	public void reset() {
		okBtnUc.setEnabled(true);
		collectionDo = null;
		collectionTitleTxtBox.setText("");
		validationErrorLbl.setVisible(false);
		courseLisBox = new GroupedListBox();
		courseLisBox.setStyleName(CollectionCBundle.INSTANCE.css()
				.contentAlignInputs());
		courseLisBox.getElement().getStyle().setWidth(330, Unit.PX);
		groupSimPanel.setWidget(courseLisBox);
		dropDownList.setSelectedIndex(0);
	}

	@Override
	public CollectionDo setData(CollectionDo collection) {
		this.collectionDo = collection;
		collectionTitleTxtBox.setText(collection.getTitle());
		setCourseData();
		return collection;
	}

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

	@Override
	public void setLibraryCodes(List<LibraryCodeDo> libraryCode) {
		courseLisBox.addItem("- Select a course -", "-1");
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
	 * Check and added error message if any error occurred in the Folder form
	 * 
	 * @return error list
	 */
	public Map<String, String> validateCollectionForm() {
		Map<String, String> errorList = new HashMap<String, String>();
		String tiltle = collectionTitleTxtBox.getText();
		if (tiltle.trim().equals("")
				|| tiltle.equalsIgnoreCase("e.g Algebra Period 1")) {
			errorList.put("title", "title can not be empty");
			validationErrorLbl.setText("Title cannot be empty.");
			validationErrorLbl.setVisible(true);
		}
		return errorList;
	}

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

	@Override
	public void closePopupPanel() {

		hide();

	}

}
