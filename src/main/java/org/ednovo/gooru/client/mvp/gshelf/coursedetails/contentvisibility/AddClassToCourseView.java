package org.ednovo.gooru.client.mvp.gshelf.coursedetails.contentvisibility;

import java.util.Iterator;
import java.util.List;

import org.ednovo.gooru.application.client.SimpleAsyncCallback;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.model.content.ClasspageListDo;
import org.ednovo.gooru.application.shared.model.content.CollectionDo;
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

public abstract class AddClassToCourseView extends PopupPanel {

	@UiField H4Panel addtocollHeaderText;
	
	@UiField HTML addingTextLbl;
	
	@UiField HTMLPanel classListContainer;
	
	@UiField Label lblEmptyErrorMessage, lblError;
	
	@UiField Button cancelResourcePopupBtnLbl, assignBtn;
	
	private String classId = null;
	
	private static AddClassToCourseViewUiBinder uiBinder = GWT
			.create(AddClassToCourseViewUiBinder.class);

	interface AddClassToCourseViewUiBinder extends
			UiBinder<Widget, AddClassToCourseView> {
	}

	public AddClassToCourseView() {
		super(false);
		setWidget(uiBinder.createAndBindUi(this));
		this.setGlassEnabled(true);
		addtocollHeaderText.setText("Assign Course");
		addingTextLbl.setText("Assign this course to a class. Note that classes that are already tied to a course will not show up here.");
		lblError.setVisible(false);
		getTeachClassesList();
		Window.enableScrolling(false);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(98, false));
		this.center();
	}
	
	private void getTeachClassesList() {
		AppClientFactory.getInjector().getClasspageService().v3GetUserClasses("20", "0",true, new SimpleAsyncCallback<ClasspageListDo>() {
			@Override
			public void onSuccess(ClasspageListDo classPageListDo) {
				setClassesList(classPageListDo.getSearchResult());
			}
		});
	}
	
	public void setClassesList(List<CollectionDo> classList) {
		classListContainer.clear();
		if(classList!=null&&classList.size()>0) {
			for(int i=0;i<classList.size();i++) {
				final Label classname = new Label(classList.get(i).getName());
				classname.setStyleName("my-content-class-individual-item");
				classname.getElement().setId(classList.get(i).getClassUid());
				classname.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						classId = classname.getElement().getId();
						highlightClass(classname);
					}
				});
				classListContainer.add(classname);
			}
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
	
	public String getClassId() {
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