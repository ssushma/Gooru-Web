package org.ednovo.gooru.client.uc;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.InsertPanel;
import com.google.gwt.user.client.ui.Widget;
public class LiPanel extends ComplexPanel implements InsertPanel,HasClickHandlers{
	public LiPanel() {
		setElement(Document.get().createLIElement());
	}

	@Override
	public void add(Widget w){
		add(w,getElement());
	}
	
	public void insert(Widget w,int beforeIndex){
		insert(w, getElement(), beforeIndex, true);
	}

	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		// TODO Auto-generated method stub
		return addDomHandler(handler, ClickEvent.getType());
	}
}