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
package org.ednovo.gooru.client.mvp.faq;



import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class DiscoverVc extends Composite implements MessageProperties{

	@UiField HTMLPanel gooruGuideImage,discoverText,discoverDescLbl,gooruGuideStyle_One,gooruGuideStyle_Two,gooruGuideStyle_Three,
	gooruGuideStyle_Four,gooruGuideStyle_Five,Style_One_Desc,Style_Two_Desc,Style_Three_Desc,Style_Four_Desc,Style_Five_Desc;
	
	@UiField Label needHelpLbl;
	
	@UiField Anchor supportCenterLbl;
	
	private static DiscoverUiBinder uiBinder = GWT.create(DiscoverUiBinder.class);

	interface DiscoverUiBinder extends UiBinder<Widget, DiscoverVc> {
	}
	
	@UiField
	HTMLEventPanel firstId,secondId,thirdId,fourthId,fifthId;

	/**
	 * Class constructor
	 */
	public DiscoverVc() {
		initWidget(uiBinder.createAndBindUi(this));
		
		firstId.getElement().setId("one");
		secondId.getElement().setId("two");
		thirdId.getElement().setId("three");
		fourthId.getElement().setId("four");
		fifthId.getElement().setId("five");
		discoverText.getElement().setInnerText(GL1342);
		discoverDescLbl.getElement().setInnerText(GL1343+GL_SPL_FULLSTOP);
		gooruGuideStyle_One.getElement().setInnerText(GL_GRR_NUMERIC_ONE);
		Style_One_Desc.getElement().setInnerText(GL1344+GL_SPL_FULLSTOP);
		gooruGuideStyle_Two.getElement().setInnerText(GL_GRR_NUMERIC_TWO);
		Style_Two_Desc.getElement().setInnerText(GL1345+GL_SPL_FULLSTOP);
		gooruGuideStyle_Three.getElement().setInnerText(GL_GRR_NUMERIC_THREE);
		Style_Three_Desc.getElement().setInnerText(GL1346+GL_SPL_FULLSTOP);
		gooruGuideStyle_Four.getElement().setInnerText(GL_GRR_NUMERIC_FOUR);
		Style_Four_Desc.getElement().setInnerText(GL1347+GL_SPL_FULLSTOP);
		gooruGuideStyle_Five.getElement().setInnerText(GL_GRR_NUMERIC_FIVE);
		Style_Five_Desc.getElement().setInnerText(GL1348+GL_SPL_FULLSTOP);
		needHelpLbl.setText(GL1349);
		supportCenterLbl.setText(GL1307+GL_SPL_FULLSTOP);
		supportCenterLbl.setHref("http://support.goorulearning.org/anonymous_requests/new");
		firstId.addMouseOverHandler(new HideOtherNumbers("1"));
		firstId.addMouseOutHandler(new ResetNumbers());
		
		secondId.addMouseOverHandler(new HideOtherNumbers("2"));
		secondId.addMouseOutHandler(new ResetNumbers());
		
		thirdId.addMouseOverHandler(new HideOtherNumbers("3"));
		thirdId.addMouseOutHandler(new ResetNumbers());
		
		fourthId.addMouseOverHandler(new HideOtherNumbers("4"));
		fourthId.addMouseOutHandler(new ResetNumbers());
		
		fifthId.addMouseOverHandler(new HideOtherNumbers("5"));
		fifthId.addMouseOutHandler(new ResetNumbers());
		
		
		
	} 
	
	private class HideOtherNumbers implements MouseOverHandler {
		String tipNo;
		public HideOtherNumbers(String tipNo) {
			this.tipNo = tipNo;
		}

		@Override
		public void onMouseOver(MouseOverEvent event) {
			if(tipNo.equalsIgnoreCase("1")){
				secondId.getElement().getStyle().setDisplay(Display.NONE);
				thirdId.getElement().getStyle().setDisplay(Display.NONE);
				fourthId.getElement().getStyle().setDisplay(Display.NONE);
				fifthId.getElement().getStyle().setDisplay(Display.NONE);
				
			}
			else if(tipNo.equalsIgnoreCase("2")){
				firstId.getElement().getStyle().setDisplay(Display.NONE);
				thirdId.getElement().getStyle().setDisplay(Display.NONE);
				fourthId.getElement().getStyle().setDisplay(Display.NONE);
				fifthId.getElement().getStyle().setDisplay(Display.NONE);
			}
			else if(tipNo.equalsIgnoreCase("3")){
				firstId.getElement().getStyle().setDisplay(Display.NONE);
				secondId.getElement().getStyle().setDisplay(Display.NONE);
				fourthId.getElement().getStyle().setDisplay(Display.NONE);
				fifthId.getElement().getStyle().setDisplay(Display.NONE);
			}
			else if(tipNo.equalsIgnoreCase("4")){
				firstId.getElement().getStyle().setDisplay(Display.NONE);
				secondId.getElement().getStyle().setDisplay(Display.NONE);
				thirdId.getElement().getStyle().setDisplay(Display.NONE);
				fifthId.getElement().getStyle().setDisplay(Display.NONE);
			}
			else if(tipNo.equalsIgnoreCase("5")){
				firstId.getElement().getStyle().setDisplay(Display.NONE);
				secondId.getElement().getStyle().setDisplay(Display.NONE);
				thirdId.getElement().getStyle().setDisplay(Display.NONE);
				fourthId.getElement().getStyle().setDisplay(Display.NONE);
			}
			
		}
		
	}
	
	private class ResetNumbers implements MouseOutHandler {

		@Override
		public void onMouseOut(MouseOutEvent event) {
			firstId.getElement().getStyle().setDisplay(Display.BLOCK);
			secondId.getElement().getStyle().setDisplay(Display.BLOCK);
			thirdId.getElement().getStyle().setDisplay(Display.BLOCK);
			fourthId.getElement().getStyle().setDisplay(Display.BLOCK);
			fifthId.getElement().getStyle().setDisplay(Display.BLOCK);
		}
		
	}
}
