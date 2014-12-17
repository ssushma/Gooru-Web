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
package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add;

import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.AddSetupAdvancedCBundle;
import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasMouseOutHandlers;
import com.google.gwt.event.dom.client.HasMouseOverHandlers;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public  abstract class AddSetupAdvancedView extends Composite implements HasMouseOutHandlers,HasMouseOverHandlers{

	private  MessageProperties i18n = GWT.create(MessageProperties.class);
	@UiField
	public Anchor educationUseAdvancedPnl,momentsOfLearningAdvancedPnl,standardsAdvancedPnl,accessHazardAdvancedPnl,mediaFeatureAdvancedPnl,mobileFreindlyAdvancedPnl;
	
	@UiField public HTMLPanel educationUseAdvancedContainer,momentsOfLearningAdvancedContainer,standardsAdvancedContainer,
	accessHazardAdvancedContainer,mediaFeatureAdvancedContainer,mobileFreindlyAdvancedContainer,setUpLabel;

	public AddSetupAdvancedView(){
		initWidget(obj.createAndBindUi(this));
		AddSetupAdvancedCBundle.INSTANCE.css().ensureInjected();
		setUpLabel.getElement().setInnerText(i18n.GL3097()+i18n.GL_SPL_QUESTION());
		educationUseAdvancedPnl.setText(i18n.GL1664());
		momentsOfLearningAdvancedPnl.setText(i18n.GL1678());
		standardsAdvancedPnl.setText(i18n.GL1682());
		accessHazardAdvancedPnl.setText(i18n.GL1705());
		mediaFeatureAdvancedPnl.setText(i18n.GL3094());
		mobileFreindlyAdvancedPnl.setText(i18n.GL1811());
		
		
	}
	public interface Binder extends UiBinder<Widget, AddSetupAdvancedView> 
	{
		
	}
	public static Binder obj = GWT.create(Binder.class); 
	
	@Override
	public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
		// TODO Auto-generated method stub
		return addDomHandler(handler, MouseOverEvent.getType());
	}
	@Override
	public HandlerRegistration addMouseOutHandler(MouseOutHandler handler) {
		// TODO Auto-generated method stub
		return addDomHandler(handler, MouseOutEvent.getType());
	}
	
	
	public  abstract  void showAndHideContainers();
}
