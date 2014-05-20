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

package org.ednovo.gooru.client.mvp.play.resource.body;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.rating.events.PostUserReviewEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.SetFolderParentNameEvent;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

/**
* @fileName : StarRatingsUc.java
*
* @description : Creates Thank you tool-tip once user rated. 
* 
* @version : 1.0
*
* @date:  April, 2013.
*
* @Author: Gooru Team.
* 
* @Reviewer: Gooru Team.
*/
public class ThankYouResourceStarRatings extends PopupPanel implements MessageProperties {
	
	private static ThankYouResourceStarRatingsUiBinder uiBinder = GWT.create(ThankYouResourceStarRatingsUiBinder.class);

	interface ThankYouResourceStarRatingsUiBinder extends UiBinder<Widget, ThankYouResourceStarRatings> {}
	
	@UiField Button btnSkip,btnPost;
	@UiField TextArea ratingCommentTxtArea;
	@UiField Label totalStars;
	@UiField SimpleCheckBox ThankyouStarOne,ThankyouStarTwo,ThankyouStarThree,ThankyouStarFour,ThankyouStarFive;
	
	String assocGooruOId,review;
	Integer score;
	
	/**
	 * Class Constructor
	 * @param review 
	 * @param integer 
	 * @param string 
	 */
	public ThankYouResourceStarRatings(String assocGooruOId, Integer score, String review){  
		this.assocGooruOId = assocGooruOId;
		this.score = score;
		this.review = review;
		setWidget(uiBinder.createAndBindUi(this));
		setUserReview(review);
		
	}
	
	/**
	 * On click Post button user entered review will get posted.
	 * @param clickEvent {@link ClickEvent}
	 */
	@UiHandler("btnPost")
	public void onRatingReviewPostclick(ClickEvent clickEvent){
		if(btnPost.getText().equalsIgnoreCase("Save")){
			AppClientFactory.fireEvent(new PostUserReviewEvent(assocGooruOId,ratingCommentTxtArea.getText().trim(),score,true));  
		}else if(btnPost.getText().equalsIgnoreCase("Post")){
			AppClientFactory.fireEvent(new PostUserReviewEvent(assocGooruOId,ratingCommentTxtArea.getText().trim(),score,false));  
		}
	}
	
	/**
	 * On click Skip button user user can skip by giving review and thank you tool tip will close.
	 * @param clickEvent {@link ClickEvent}
	 */
	@UiHandler("btnSkip")
	public void onRatingReviewSkipclicked(ClickEvent clickEvent){
		hide();
	}
	
	private void setUserReview(String review) {
		if(!review.equals("")){
			btnPost.setText("Save");
			ratingCommentTxtArea.setText(review.trim());
		}else{
			btnPost.setText("Post");
		}
		
	}

}
