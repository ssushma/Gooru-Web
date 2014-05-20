package org.ednovo.gooru.client.mvp.addTagesPopup;

import org.ednovo.gooru.client.mvp.play.collection.preview.home.assign.AssignPopUpCBundle;
import org.ednovo.gooru.client.uc.SlideBarView;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

public class AddTagesPopupView extends PopupPanel implements MessageProperties{

	public PopupPanel appPopUp;
	
	private static AddTagesPopupViewUiBinder uiBinder = GWT
			.create(AddTagesPopupViewUiBinder.class);

	interface AddTagesPopupViewUiBinder extends
			UiBinder<Widget, AddTagesPopupView> {
	}

	@UiField(provided = true)
	AddTagesCBundle res;
	
	@UiField(provided = true)
	SlideBarView slideBar;

	public AddTagesPopupView() {
		super(false);
		slideBar=new SlideBarView(1,12);
		slideBar.setStepSize(1.0);
		slideBar.setCurrentValue(1);
		slideBar.setNumTicks(12);
		slideBar.setNumLabels(12);
		
		this.res = AddTagesCBundle.INSTANCE;
		res.css().ensureInjected();
		add(uiBinder.createAndBindUi(this));
		slideBar.setStyleName(res.css().gwtSliderBarshell());
		
	}

	@Override
	public Widget asWidget() {
		
		return null;
	}
}
