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
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public abstract class AddCollectionToClassView extends PopupPanel {

	@UiField H4Panel addtocollHeaderText;
	
	@UiField HTML addingTextLbl;
	
	@UiField HTMLPanel classListContainer;
	
	@UiField Label lblEmptyErrorMessage, lblError;
	
	@UiField Button cancelResourcePopupBtnLbl, assignBtn;
	
	private List<Integer> classId = new ArrayList<>();
	
	private static AddCollectionToClassViewUiBinder uiBinder = GWT
			.create(AddCollectionToClassViewUiBinder.class);

	interface AddCollectionToClassViewUiBinder extends
			UiBinder<Widget, AddCollectionToClassView> {
	}

	public AddCollectionToClassView(String courseId,String unitId, String lessonId, String collectionId) {
		super(false);
		setWidget(uiBinder.createAndBindUi(this));
		this.setGlassEnabled(true);
		addtocollHeaderText.setText("Publish this Content to Your Classes");
		addingTextLbl.setText("Select the class(es) that can view and access this content. Once you publish content to the class, it can't be reversed!");
		lblError.setVisible(false);
		assignBtn.setVisible(false);
		getTeachClassesList(courseId,unitId,lessonId,collectionId);
		Window.enableScrolling(false);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
		assignBtn.setEnabled(false);
		this.center();
	}
	
	private void getTeachClassesList(String courseId,String unitId, String lessonId, String collectionId) {
		AppClientFactory.getInjector().getClasspageService().v3GetUserCollectionAssociatedClasses(courseId,unitId,lessonId,collectionId, new SimpleAsyncCallback<List<CollectionVisibilityDo>>() {
			@Override
			public void onSuccess(List<CollectionVisibilityDo> classPageListDo) {
				setClassesList(classPageListDo);
			}
		});
	}
	
	public void setClassesList(List<CollectionVisibilityDo> classList) {
		classListContainer.clear();
		if(classList!=null&&classList.size()>0) {
			classId.clear();
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
	
	@UiHandler("cancelResourcePopupBtnLbl")
	public void cancelButtonEvent(ClickEvent event){
		hide();
		Window.enableScrolling(true);
	}
}