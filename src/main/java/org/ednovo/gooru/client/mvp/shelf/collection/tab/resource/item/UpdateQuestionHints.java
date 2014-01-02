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
package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item;

import org.ednovo.gooru.client.ui.TinyMCE;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.HasMouseOutHandlers;
import com.google.gwt.event.dom.client.HasMouseOverHandlers;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : UpdateQuestionHints.java
 *
 * @description : This class is used to update question hints.
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class UpdateQuestionHints extends Composite implements HasMouseOutHandlers,HasMouseOverHandlers{
	 	
      @UiField Label hintsChoice;
      
      @UiField Label addHintsLabel,hintDelLbl;
      
      @UiField TinyMCE hintsTextBox;
      
      private String hintText=null;
      
	  public  interface UpdateQuestionHintsUiBinder extends UiBinder<Widget,UpdateQuestionHints>{
		  
	  }
	  public static UpdateQuestionHintsUiBinder uiBinder=GWT.create(UpdateQuestionHintsUiBinder.class);
	  /**
	   * class constructor.
	   */
	  public UpdateQuestionHints(){
		  initWidget(uiBinder.createAndBindUi(this));
	  }
	  /**
	   * class constructor.
	   */
	  public UpdateQuestionHints(String labelname){
		  initWidget(uiBinder.createAndBindUi(this));
		  hintsChoice.setText(labelname);
	  }
	  /**
	   * class constructor.
	   */
	  public UpdateQuestionHints(int count,String hintText){
		  initWidget(uiBinder.createAndBindUi(this));
		 this.hintText=hintText;
		  if(count==1){
			  hintsChoice.setText(""+count);
			  addHintsLabel.setText("Hints (hints will show up in this order)");
		  }else{
			  hintsChoice.setText(""+count);
		  }
		  hintDelLbl.getElement().getStyle().setDisplay(Display.NONE);
	  }
	  /**
	   * It will hit on load.
	   */
	  public void onLoad(){
		  super.onLoad();
		  Scheduler.get().scheduleDeferred(new ScheduledCommand(){
				@Override
				public void execute() {
					 setHintText();
				}
	        });
		 
	  }
	  /**
	   * @function setHintText 
	   * 
	   * @created_date : 02-Jan-2014
	   * 
	   * @description :This method is used to set hint text.
	   * 
	   * 
	   * @parm(s) : 
	   * 
	   * @return : void
	   *
	   * @throws : <Mentioned if any exceptions>
	   *
	   */
	  public void setHintText(){
		  if(hintText!=null){
			  hintsTextBox.setText(hintText);
		  }
	  }
	  /**
	   * @function setLabelName 
	   * 
	   * @created_date : 02-Jan-2014
	   * 
	   * @description : This method is used to set label name.
	   * 
	   * 
	   * @parm(s) : @param labelName
	   * 
	   * @return : void
	   *
	   * @throws : <Mentioned if any exceptions>
	   *
	   */
	  public void setLabelName(String labelName){
		  hintsChoice.setText(labelName);
		}
	  /**
	   * Adding the mouse over event.
	   */
	  @Override
		public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
			return addDomHandler(handler, MouseOverEvent.getType());
		}
	  /**
	   * Adding the mouse out event.
	   */
		@Override
		public HandlerRegistration addMouseOutHandler(MouseOutHandler handler) {
			return addDomHandler(handler, MouseOutEvent.getType());
		}
		
}
