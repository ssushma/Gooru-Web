package org.ednovo.gooru.client.mvp.gshelf.righttabs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.ednovo.gooru.application.client.SimpleAsyncCallback;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.model.content.CollectionDo;
import org.ednovo.gooru.application.shared.model.content.CollectionVisibilityDo;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.uc.H4Panel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.event.dom.client.ScrollHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

public abstract class AddCollectionToClassView extends PopupPanel {

	@UiField H4Panel addtocollHeaderText;
	
	@UiField HTML addingTextLbl;
	
	@UiField HTMLPanel classListContainer;
	
	@UiField Label lblEmptyErrorMessage, lblError;
	
	@UiField ScrollPanel dropdownListContainerScrollPanel;
	
	@UiField Button cancelResourcePopupBtnLbl, assignBtn;
	
	private List<Integer> classId = new ArrayList<>();
	

	int totalClassesCountVal = 0;
	int limitClasses = 20;
	int initialOffset = 0;
	
	private static AddCollectionToClassViewUiBinder uiBinder = GWT
			.create(AddCollectionToClassViewUiBinder.class);

	interface AddCollectionToClassViewUiBinder extends
			UiBinder<Widget, AddCollectionToClassView> {
	}

	public AddCollectionToClassView(final String courseId,final String unitId, final String lessonId, final String collectionId) {
		super(false);
		setWidget(uiBinder.createAndBindUi(this));
		this.setGlassEnabled(true);
		addtocollHeaderText.setText("Publish this Content to Your Classes");
		addingTextLbl.setText("Select the class(es) that can view and access this content. Once you publish content to the class, it can't be reversed!");
		lblError.setVisible(false);
		assignBtn.setVisible(false);
		resetValues();
		getTeachClassesList(courseId,unitId,lessonId,collectionId,limitClasses,initialOffset);
		dropdownListContainerScrollPanel.addScrollHandler(new ScrollHandler() {
			
			@Override
			public void onScroll(ScrollEvent event) {
				if((totalClassesCountVal>=initialOffset)&&(initialOffset!=0))
				{
				getTeachClassesList(courseId,unitId,lessonId,collectionId,limitClasses,initialOffset);
				initialOffset = initialOffset+20;
				}
			}
		});
		Window.enableScrolling(false);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
		assignBtn.setEnabled(false);
		this.center();
	}
	
	private void getTeachClassesList(String courseId,String unitId, String lessonId, String collectionId,int limit, int offSet) {
		AppClientFactory.getInjector().getClasspageService().v3GetUserCollectionAssociatedClasses(courseId,unitId,lessonId,collectionId,String.valueOf(limit), String.valueOf(offSet), new SimpleAsyncCallback<List<CollectionVisibilityDo>>() {
			@Override
			public void onSuccess(List<CollectionVisibilityDo> classPageListDo) {
				if(classPageListDo.size()==20)
				{
				totalClassesCountVal = initialOffset+limitClasses;
				initialOffset = initialOffset+20;
				}
				else
				{
					totalClassesCountVal = 0;
				}
				if(classPageListDo.size()>0)
				{
				setClassesList(classPageListDo);
				}
			}
		});
	}
	public void resetValues()
	{
		classListContainer.clear();
		classId.clear();
		totalClassesCountVal = 0;
		limitClasses = 20;
		initialOffset = 0;
	}
	
	public void setClassesList(List<CollectionVisibilityDo> classList) {

		if(classList!=null&&classList.size()>0) {

			for(int i=0;i<classList.size();i++) {
				final Label classname = new Label(classList.get(i).getName());
				Boolean visibleCollStatus = classList.get(i).getVisibility();
				final Label classDotSelection = new Label("");
				classname.setStyleName("my-content-class-individual-itemColl");
				classDotSelection.setStyleName("dottedButtonCollClass");
				classDotSelection.getElement().setId(String.valueOf(classList.get(i).getClassId()));
				if(!visibleCollStatus)
				{
				classDotSelection.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {				
						if(!classDotSelection.getStyleName().contains("green"))
						{
						classDotSelection.addStyleName("green");
						classId.add(Integer.parseInt(classDotSelection.getElement().getId()));
						}
						else
						{
						classDotSelection.removeStyleName("green");
						classId.remove(classId.indexOf(Integer.parseInt(classDotSelection.getElement().getId())));
						}
						if(classId.size()>0)
						{
							assignBtn.setEnabled(true);
							assignBtn.setStyleName("primary");
						}
						else
						{
							assignBtn.setEnabled(false);
							assignBtn.setStyleName("secondary");
						}
						//highlightClass(classname);
					}
				});
				}
				else
				{
					classDotSelection.addStyleName("green");
					classDotSelection.addStyleName("tick");
				}
				classListContainer.add(classname);
				classListContainer.add(classDotSelection);
			}
			assignBtn.setVisible(true);
		} else {
			lblEmptyErrorMessage.setText("No Classes available");
		}
	}
	
	private void highlightClass(final Label classname) {
		Iterator<Widget> classList= classListContainer.iterator();
		while (classList.hasNext()){
			  Widget className = classList.next();
			  if (className instanceof Label) {
				  Label classWidget = (Label)className;
				  classWidget.removeStyleName("selectedActiveItem");
				  if(classWidget.getElement().getId().equalsIgnoreCase(classname.getElement().getId())) {
					  classWidget.addStyleName("selectedActiveItem");
				  }
			  }
		}
	}
	
	@UiHandler("assignBtn")
	public void clickAssignBtn(ClickEvent event) {
		onClickPositiveButton(event);
	}
	
	public abstract void onClickPositiveButton(ClickEvent event);
	
	public List<Integer> getClassId() {
		return classId;
	}
	
	public Label getErrorLabel() {
		return lblError;
	}	
	
	public Button getCancelResourcePopupBtnLbl() {
		return cancelResourcePopupBtnLbl;
	}

}