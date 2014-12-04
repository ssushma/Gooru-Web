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

	public ReactionsAndRatingsGivenCommonInfo(String textLbl,Map<String, Integer> result) {
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
			
			String setDefaultVal="(0)";
			countLblPoor.setText(setDefaultVal);
			countLblFair.setText(setDefaultVal);
			countLblGood.setText(setDefaultVal);
			countLblVeryGood.setText(setDefaultVal);
			countLblExcellent.setText(setDefaultVal);
			
			int totalCount=result.get("totalRows");
			for(Map.Entry<String, Integer> entry : result.entrySet()) {
				if(!entry.getKey().toString().equalsIgnoreCase("totalRows")){
					int keyVal=Integer.parseInt(entry.getKey());
					float widthVal=(((float)entry.getValue()/(float)totalCount)*100);
					String setValue="("+entry.getValue()+")";
					if(keyVal==1){
						dataOne.getElement().getStyle().setWidth(widthVal, Unit.PCT);
						countLblPoor.setText(setValue);
					}else if(keyVal==2){
						dataTwo.getElement().getStyle().setWidth(widthVal, Unit.PCT);
						countLblFair.setText(setValue);
					}else if(keyVal==3){
						dataThree.getElement().getStyle().setWidth(widthVal, Unit.PCT);
						countLblGood.setText(setValue);
					}else if(keyVal==4){
						dataFour.getElement().getStyle().setWidth(widthVal, Unit.PCT);
						countLblVeryGood.setText(setValue);
					}else if(keyVal==5){
						dataFive.getElement().getStyle().setWidth(widthVal, Unit.PCT);
						countLblExcellent.setText(setValue);
					}
				}
			}
			
		}else if(textLbl.equalsIgnoreCase("reactions")){
			ratingsOrReviewsBlock.setStyleName(DashBoardCBundle.INSTANCE.css().reactionOutBlock());
			ratingLblPoor.addStyleName(DashBoardCBundle.INSTANCE.css().ratingLabel());
			ratingLabelFair.addStyleName(DashBoardCBundle.INSTANCE.css().ratingLabel());
			ratingLabelGood.addStyleName(DashBoardCBundle.INSTANCE.css().ratingLabel());
			ratingLabelVeryGood.addStyleName(DashBoardCBundle.INSTANCE.css().ratingLabel());
			ratingLabelExcellent.addStyleName(DashBoardCBundle.INSTANCE.css().ratingLabel());
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
			dataOne.getElement().getStyle().setWidth(0, Unit.PCT);
			dataTwo.getElement().getStyle().setWidth(0, Unit.PCT);
			dataThree.getElement().getStyle().setWidth(0, Unit.PCT);
			dataFour.getElement().getStyle().setWidth(45, Unit.PCT);
			dataFive.getElement().getStyle().setWidth(83, Unit.PCT);
		}
	}
}