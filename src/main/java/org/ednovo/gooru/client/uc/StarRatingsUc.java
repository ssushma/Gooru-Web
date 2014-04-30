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
package org.ednovo.gooru.client.uc;

import org.ednovo.gooru.shared.model.content.StarRatingsDo;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.Widget;

/**
* @fileName : StarRatingsUc.java
*
* @description : Creates ratings widget i.e Star Ratings
* 
* @version : 1.0
*
* @date:  April, 2013.
*
* @Author: Gooru Team.
* 
* @Reviewer: Gooru Team.
*/

public abstract class StarRatingsUc extends Composite {

	@UiField
	public SimpleCheckBox starOne,starTwo,starThree,starFour,starFive;
	
	@UiField Label starValue; 
	

	private static StarRatingsUiBinder uiBinder = GWT.create(StarRatingsUiBinder.class);

	interface StarRatingsUiBinder extends UiBinder<Widget, StarRatingsUc> {
	}

	/**
	 * Class Constructor
	 */
	public StarRatingsUc() {
		initWidget(uiBinder.createAndBindUi(this));
		starValue.setVisible(false);
	}
	
	/**
	 * On click of Star 1 sets the rating on view.
	 * @param clickEvent {@link ClickEvent}
	 */
	@UiHandler("starOne")
	public void onStarOneclicked(ClickEvent event){
		if(starOne.getValue()){
			crateStarRating("starOne");
		}else{
		}
	}
	
	/**
	 * On click of Star 2 sets the rating on view.
	 * @param clickEvent {@link ClickEvent}
	 */
	@UiHandler("starTwo")
	public void onStarTwoclicked(ClickEvent event){
		if(starTwo.getValue()){
			crateStarRating("starTwo");
		}else{
		}
	}
	
	/**
	 * On click of Star 3 sets the rating on view.
	 * @param clickEvent {@link ClickEvent}
	 */
	@UiHandler("starThree")
	public void onStarThreeclicked(ClickEvent event){
		if(starThree.getValue()){
			crateStarRating("starThree");
		}else{
		}
	}
	
	/**
	 * On click of Star 4 sets the rating on view.
	 * @param clickEvent {@link ClickEvent}
	 */
	@UiHandler("starFour")
	public void onStarFourclicked(ClickEvent event){
		if(starFour.getValue()){
			crateStarRating("starFour");
		}else{
		}
	}
	
	/**
	 * On click of Star 5 sets the rating on view.
	 * @param clickEvent {@link ClickEvent}
	 */
	@UiHandler("starFive")
	public void onStarFiveclicked(ClickEvent event){
		if(starFive.getValue()){
			crateStarRating("starFive");
		}else{
		}
	}

	/**
	 * Resource ratings will get set based on the respective scores.
	 * 
	 * @param result {@link StarRatingsDo}
	 */
	public void setUserRatings(StarRatingsDo result){
		if(result!=null){
			if(result.getScore()==1){
				starValue.setVisible(true);
				starValue.setText("Poor");
				starOne.setValue(true);
				starTwo.setValue(false);
				starThree.setValue(false);
				starFour.setValue(false);
				starFive.setValue(false);
			}else if(result.getScore()==2){
				starValue.setVisible(true);
				starValue.setText("Fair");
				starOne.setValue(true);
				starTwo.setValue(true);
				starThree.setValue(false);
				starFour.setValue(false);
				starFive.setValue(false);
			}else if(result.getScore()==3){
				starValue.setVisible(true);
				starValue.setText("Good");
				starOne.setValue(true);
				starTwo.setValue(true);
				starThree.setValue(true);
				starFour.setValue(false);
				starFive.setValue(false);
			}else if(result.getScore()==4){
				starValue.setVisible(true);
				starValue.setText("Very Good");
				starOne.setValue(true);
				starTwo.setValue(true);
				starThree.setValue(true);
				starFour.setValue(true);
				starFive.setValue(false);
			}else if(result.getScore()==5){
				starValue.setVisible(true);
				starValue.setText("Excellent");
				starOne.setValue(true);
				starTwo.setValue(true);
				starThree.setValue(true);
				starFour.setValue(true);
				starFive.setValue(true);
			}else{
				starOne.setValue(false);
				starTwo.setValue(false);
				starThree.setValue(false);
				starFour.setValue(false);
				starFive.setValue(false);
			}
		}else{
			starOne.setValue(false);
			starTwo.setValue(false);
			starThree.setValue(false);
			starFour.setValue(false);
			starFive.setValue(false);
		}
		
	}
	/**
	 * Abstract method, which will send the rated information to the implemented class.
	 * @param selectedStar
	 */
	public abstract void crateStarRating(String selectedStar);

}
