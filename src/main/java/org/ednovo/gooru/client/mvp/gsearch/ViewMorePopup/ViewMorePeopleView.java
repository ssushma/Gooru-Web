package org.ednovo.gooru.client.mvp.gsearch.ViewMorePopup;

import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.util.ClientConstants;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;

public class ViewMorePeopleView extends PopupViewWithUiHandlers<ViewMorePeopleUiHandlers> implements IsViewMorePeopleView,ClientConstants {

	private static ViewMorePeopleViewUiBinder uiBinder = GWT
			.create(ViewMorePeopleViewUiBinder.class);

	interface ViewMorePeopleViewUiBinder extends
			UiBinder<Widget, ViewMorePeopleView> {
	}


	
	static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	PopupPanel appPopUp;

	@Inject
	public ViewMorePeopleView(EventBus eventBus) {
		super(eventBus);
		appPopUp=new PopupPanel();
		appPopUp.setWidget(uiBinder.createAndBindUi(this));
		appPopUp.setGlassEnabled(true);
		appPopUp.getElement().getStyle().setZIndex(999999);

	
	
	}


	@Override
	public Widget asWidget() {
		return appPopUp;
	}

	@Override
	public void reset() {
	}

	@Override
	public void onLoad() {
		
	}

	@Override
	public void onUnload() {
		
	}


	public void enableTopFilters(){
		Element element = Document.get().getElementById("fixedFilterSearchID");
		if(element!=null){
			element.removeAttribute("style");
		}
		Window.enableScrolling(true);
	}


	@Override
	public void hidePopup() {
		Element element = Document.get().getElementById("fixedFilterSearchID");
		if(element!=null)
		{
		element.removeAttribute("style");
		}
		hide();
		enableTopFilters();
		
	}
	
	
}
