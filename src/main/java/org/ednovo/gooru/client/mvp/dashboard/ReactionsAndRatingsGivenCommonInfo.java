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
package org.ednovo.gooru.client.mvp.dashboard;
/**


*
* @description : 
*
* @version :1.0
*
* @date: APR 19 2013
   	
* @Author Gooru Team
* 
* Reviewer Gooru Team
*
*/
import java.util.Map;

import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.user.ProfileRatingsReactionsDO;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class ReactionsAndRatingsGivenCommonInfo extends Composite{
	private static ReactionsAndRatingsGivenCommonInfoUiBinder uiBinder = GWT
			.create(ReactionsAndRatingsGivenCommonInfoUiBinder.class);
	
	@UiField HTMLPanel ratingsAndreactionsGivenPnl,ratingsOrReviewsBlock,dataOne,dataTwo,dataThree,dataFour,dataFive;
	@UiField Label smallHeaderTextLbl,ratingLblPoor,ratingLabelFair,ratingLabelGood,ratingLabelVeryGood,ratingLabelExcellent,countLblPoor,countLblFair,countLblGood,countLblVeryGood,countLblExcellent;
	@UiField Image ratingorReactionImgPoor,ratingorReactionImgFair,ratingorReactionImgGood,ratingorReactionImgVeryGood,ratingorReactionImgExcellent;

	interface ReactionsAndRatingsGivenCommonInfoUiBinder extends
			UiBinder<Widget, ReactionsAndRatingsGivenCommonInfo> {
	}
	
	public MessageProperties i18n = GWT.create(MessageProperties.class);
	
	public interface Binder extends UiBinder<Widget, ReactionsAndRatingsGivenCommonInfo> {
	}

	@Inject
	public ReactionsAndRatingsGivenCommonInfo() {
		initWidget(uiBinder.createAndBindUi(this));
		DashBoardCBundle.INSTANCE.css().ensureInjected();
	}

	public ReactionsAndRatingsGivenCommonInfo(String textLbl,ProfileRatingsReactionsDO result) {
		initWidget(uiBinder.createAndBindUi(this));
		DashBoardCBundle.INSTANCE.css().ensureInjected();
		
		if(textLbl.equalsIgnoreCase("ratings")){
			ratingsOrReviewsBlock.setStyleName(DashBoardCBundle.INSTANCE.css().ratingOutBlock());
			ratingLblPoor.addStyleName(DashBoardCBundle.INSTANCE.css().ratingLabel());
			ratingLabelFair.addStyleName(DashBoardCBundle.INSTANCE.css().ratingLabel());
			ratingLabelGood.addStyleName(DashBoardCBundle.INSTANCE.css().ratingLabel());
			ratingLabelVeryGood.addStyleName(DashBoardCBundle.INSTANCE.css().ratingLabel());
			ratingLabelExcellent.addStyleName(DashBoardCBundle.INSTANCE.css().ratingLabel());
			smallHeaderTextLbl.setText("Ratings Given");
			ratingLblPoor.setText("Poor");
			ratingorReactionImgPoor.setUrl("../images/profileimages/rating1.png");
			ratingLabelFair.setText("Fair");
			ratingorReactionImgFair.setUrl("../images/profileimages/rating2.png");
			ratingLabelGood.setText("Good");
			ratingorReactionImgGood.setUrl("../images/profileimages/rating3.png");
			ratingLabelVeryGood.setText("Good");
			ratingorReactionImgVeryGood.setUrl("../images/profileimages/rating4.png");
			ratingLabelExcellent.setText("Excellent");
			ratingorReactionImgExcellent.setUrl("../images/profileimages/rating5.png");
			
			int totalCount=result.getCountOfRating1()+result.getCountOfRating2()+result.getCountOfRating3()+result.getCountOfRating4()+result.getCountOfRating5();
			float widthVal1=(((float)result.getCountOfRating1()/(float)totalCount)*100);
			dataOne.getElement().getStyle().setWidth(widthVal1, Unit.PCT);
			countLblPoor.setText("("+result.getCountOfRating1()+")");
			
			float widthVal2=(((float)result.getCountOfRating2()/(float)totalCount)*100);
			dataTwo.getElement().getStyle().setWidth(widthVal2, Unit.PCT);
			countLblFair.setText("("+result.getCountOfRating2()+")");
			
			float widthVal3=(((float)result.getCountOfRating3()/(float)totalCount)*100);
			dataThree.getElement().getStyle().setWidth(widthVal3, Unit.PCT);
			countLblGood.setText("("+result.getCountOfRating3()+")");
			
			float widthVal4=(((float)result.getCountOfRating4()/(float)totalCount)*100);
			dataFour.getElement().getStyle().setWidth(widthVal4, Unit.PCT);
			countLblVeryGood.setText("("+result.getCountOfRating4()+")");
			
			float widthVal5=(((float)result.getCountOfRating5()/(float)totalCount)*100);
			dataFive.getElement().getStyle().setWidth(widthVal5, Unit.PCT);
			countLblExcellent.setText("("+result.getCountOfRating5()+")");
			
		}else if(textLbl.equalsIgnoreCase("reactions")){
			ratingsOrReviewsBlock.setStyleName(DashBoardCBundle.INSTANCE.css().reactionOutBlock());
			ratingLblPoor.addStyleName(DashBoardCBundle.INSTANCE.css().ratingLabel());
			ratingLabelFair.addStyleName(DashBoardCBundle.INSTANCE.css().ratingLabel());
			ratingLabelGood.addStyleName(DashBoardCBundle.INSTANCE.css().ratingLabel());
			ratingLabelVeryGood.addStyleName(DashBoardCBundle.INSTANCE.css().ratingLabel());
			ratingLabelExcellent.addStyleName(DashBoardCBundle.INSTANCE.css().ratingLabel());
			ratingLblPoor.getElement().getStyle().clearWidth();
			ratingLabelFair.getElement().getStyle().clearWidth();
			ratingLabelGood.getElement().getStyle().clearWidth();
			ratingLabelVeryGood.getElement().getStyle().clearWidth();
			ratingLabelExcellent.getElement().getStyle().clearWidth();
		
			smallHeaderTextLbl.setText("Reactions Given");
			ratingLblPoor.setText("I need help");
			ratingorReactionImgPoor.setUrl("../images/profileimages/emotics1.png");
			ratingLabelFair.setText("I don’t understand");
			ratingorReactionImgFair.setUrl("../images/profileimages/emotics2.png");
			ratingLabelGood.setText("Meh");
			ratingorReactionImgGood.setUrl("../images/profileimages/emotics3.png");
			ratingLabelVeryGood.setText("I understand");
			ratingorReactionImgVeryGood.setUrl("../images/profileimages/emotics4.png");
			ratingLabelExcellent.setText("I can explain");
			ratingorReactionImgExcellent.setUrl("../images/profileimages/emotics5.png");
		
			int totalCount=result.getCountOfMeh()+result.getCountOfINeedHelp()+result.getCountOfIDoNotUnderstand()+result.getCountOfICanUnderstand()+result.getCountOfICanExplain();
			float widthVal1=(((float)result.getCountOfINeedHelp()/(float)totalCount)*100);
			dataOne.getElement().getStyle().setWidth(widthVal1, Unit.PCT);
			countLblPoor.setText("("+result.getCountOfINeedHelp()+")");
			
			float widthVal2=(((float)result.getCountOfIDoNotUnderstand()/(float)totalCount)*100);
			dataTwo.getElement().getStyle().setWidth(widthVal2, Unit.PCT);
			countLblFair.setText("("+result.getCountOfIDoNotUnderstand()+")");
			
			float widthVal3=(((float)result.getCountOfMeh()/(float)totalCount)*100);
			dataThree.getElement().getStyle().setWidth(widthVal3, Unit.PCT);
			countLblGood.setText("("+result.getCountOfMeh()+")");
			
			float widthVal4=(((float)result.getCountOfICanUnderstand()/(float)totalCount)*100);
			dataFour.getElement().getStyle().setWidth(widthVal4, Unit.PCT);
			countLblVeryGood.setText("("+result.getCountOfICanUnderstand()+")");
			
			float widthVal5=(((float)result.getCountOfICanExplain()/(float)totalCount)*100);
			dataFive.getElement().getStyle().setWidth(widthVal5, Unit.PCT);
			countLblExcellent.setText("("+result.getCountOfICanExplain()+")");
		}
	}
}