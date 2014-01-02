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
package org.ednovo.gooru.client.mvp.settings;

import com.google.gwt.animation.client.Animation;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Widget;

public class DragDropAnimation extends Animation {
	
	private Widget dragWidget;
	private String showWidget="";
	int startLeft;
	int startTop;
	int endLeft;
	int endTop;
	
	/**
	 * This is the Constructor to set drag widget positions.
	 * @param widget
	 * @param startLeft
	 * @param startTop
	 * @param endLeft
	 * @param endTop
	 */
	public DragDropAnimation(Widget widget,int startLeft, int startTop,int endLeft, int endTop){
		
		this.dragWidget=widget;
		this.startLeft = startLeft;
		this.startTop = startTop;
		this.endLeft = endLeft;
		this.endTop = endTop;
	}
	/**
	 * This method is Called immediately before the animation starts.
	 */
	protected void onStart() {
		super.onStart();
		if(dragWidget.getElement().getStyle().getProperty("display").equals("none")){
			dragWidget.getElement().getStyle().setProperty("display", "block");
			dragWidget.getElement().getStyle().setProperty("height", "0px");
		}
		else{
			showWidget="block";
		}
	}
	/**
	 *This method is Called when the animation should be updated.
	 */
	@Override
	protected void onUpdate(double progress) {
		double left = extractProportionalLeft(progress) ;
		double top = extractProportionalRight(progress) ;
		
		dragWidget.getElement().getStyle().setProperty("left", left,Unit.PX);
		dragWidget.getElement().getStyle().setProperty("top", top,Unit.PX);
	}
	
	/**
	 * 
	 * @function extractProportionalLeft 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :returns ProportionalLeft.
	 * 
	 * 
	 * @parm(s) : @param progress
	 * @parm(s) : @return
	 * 
	 * @return : double
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	 private double extractProportionalLeft(double progress) {
         double proportionalLeft = startLeft - (startLeft - endLeft) * progress; 
         
         return proportionalLeft;
	 }
	 /**
	  * 
	  * @function extractProportionalRight 
	  * 
	  * @created_date : 02-Jan-2014
	  * 
	  * @description : returns proportionalRight.
	  * 
	  * 
	  * @parm(s) : @param progress
	  * @parm(s) : @return
	  * 
	  * @return : double
	  *
	  * @throws : <Mentioned if any exceptions>
	  *
	  * 
	  *
	  *
	  */
	 private double extractProportionalRight(double progress) {
         double proportionalRight = startTop - (startTop - endTop) * progress; 
         
         return proportionalRight;
	 }
	 /**
	  * Interpolate the linear progress into a more natural easing function.
	  */
	protected double interpolate(double progress) {
		return (Math.sin((progress + 0.5) * Math.PI)) / 2 + 0.5;
	}
	
	/**
	 *This method is Called immediately after the animation completes.
	 */
	protected void onComplete() {
		dragWidget.getElement().getStyle().clearHeight();
		
		if(showWidget.equals("block")){
			dragWidget.getElement().getStyle().setProperty("display", "none");
		}
	}
	
	
	
	
}
