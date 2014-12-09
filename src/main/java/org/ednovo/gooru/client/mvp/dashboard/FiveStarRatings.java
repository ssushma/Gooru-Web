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

import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.code.UserDashBoardCommonInfoDO;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * 
 * @fileName : FiveStarRatings.java
 *
 * @description : 
 *
 *
 * @version : 1.0
 *
 * @date: 08-Dec-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer:
 */
public class FiveStarRatings extends Composite{
	private static FiveStarRatingsUiBinder uiBinder = GWT
			.create(FiveStarRatingsUiBinder.class);
	
	@UiField Label fiveStarRatedLbl,icanExplainLbl,reactionResourcesLbl;
	@UiField Image fivestarImage,iCanExplainImage;
	@UiField HTMLPanel ratingsHeaderPnl,reactionsHeaderPnl,resourcesDataBlock;
	@UiField Anchor viewAllLbl;

	interface FiveStarRatingsUiBinder extends
			UiBinder<Widget, FiveStarRatings> {

	}
	public MessageProperties i18n = GWT.create(MessageProperties.class);
	
	public interface Binder extends UiBinder<Widget, FiveStarRatings> {
	}
	@Inject
	public FiveStarRatings() {
		initWidget(uiBinder.createAndBindUi(this));
		PlayerBundle.INSTANCE.getPlayerStyle().ensureInjected();
		DashBoardCBundle.INSTANCE.css().ensureInjected();
	}
	/**
	 * 
	 * @param val
	 * @param userDashBoardCommonInfoDOObject
	 */
	public FiveStarRatings(String val,UserDashBoardCommonInfoDO userDashBoardCommonInfoDOObject) {
		initWidget(uiBinder.createAndBindUi(this));
		DashBoardCBundle.INSTANCE.css().ensureInjected();
		PlayerBundle.INSTANCE.getPlayerStyle().ensureInjected();
		fiveStarRatedLbl.setText(i18n.GL3062());
		fivestarImage.setUrl("../images/profileimages/rating.png");
		iCanExplainImage.setUrl("../images/profileimages/iconBig.png");
		icanExplainLbl.setText(i18n.GL0581());
		reactionResourcesLbl.setText(i18n.GL3063());
		if(val.equalsIgnoreCase("fivestarRatings")){
				for(int i=0; i<3; i++){
				HTMLPanel resourceBlockPanel = new HTMLPanel("");
				HTMLPanel CollectionHeadPanel = new HTMLPanel("");
				HTMLPanel resourceNamePnl = new HTMLPanel("");
				if(userDashBoardCommonInfoDOObject.getContent().get(i).getCategory()!=null){
				HTMLPanel imagePanel = new HTMLPanel("");
				Image resourceImagePnl = new Image();
				resourceImagePnl.setStyleName(getResourceTypeImage(userDashBoardCommonInfoDOObject.getContent().get(i).getCategory()));
				imagePanel.add(resourceImagePnl);
				CollectionHeadPanel.add(imagePanel);
				}
				resourceNamePnl.add(new Label(userDashBoardCommonInfoDOObject.getContent().get(i).getTitle()));
				CollectionHeadPanel.add(resourceNamePnl);
				CollectionHeadPanel.setStyleName(DashBoardCBundle.INSTANCE.css().collHead());
				resourceBlockPanel.add(CollectionHeadPanel);
				resourceBlockPanel.setStyleName(DashBoardCBundle.INSTANCE.css().resourceBlock());
				resourcesDataBlock.add(resourceBlockPanel);
			}
			ratingsHeaderPnl.setVisible(true);
			reactionsHeaderPnl.setVisible(false);
			viewAllLbl.setText(i18n.GL3064());
		}else if(val.equalsIgnoreCase("fivestarReviews")){
			ratingsHeaderPnl.setVisible(false);
			reactionsHeaderPnl.setVisible(true);
			viewAllLbl.setText(i18n.GL3065());
			for(int i=0;i<3;i++){
				HTMLPanel resourceBlockPanel = new HTMLPanel("");
				HTMLPanel CollectionHeadPanel = new HTMLPanel("");
				HTMLPanel resourceNamePnl = new HTMLPanel("");
				if(userDashBoardCommonInfoDOObject.getContent().get(i).getCategory()!=null){
				HTMLPanel imagePanel = new HTMLPanel("");
				Image resourceImagePnl = new Image();
				resourceImagePnl.setStyleName(getResourceTypeImage(userDashBoardCommonInfoDOObject.getContent().get(i).getCategory()));
				imagePanel.add(resourceImagePnl);
				CollectionHeadPanel.add(imagePanel);
				}
				resourceNamePnl.add(new Label(userDashBoardCommonInfoDOObject.getContent().get(i).getTitle()));
				CollectionHeadPanel.add(resourceNamePnl);
				CollectionHeadPanel.setStyleName(DashBoardCBundle.INSTANCE.css().collHead());
				resourceBlockPanel.add(CollectionHeadPanel);
				resourceBlockPanel.setStyleName(DashBoardCBundle.INSTANCE.css().resourceBlock());
				resourcesDataBlock.add(resourceBlockPanel);
			}
		}
	}
	/**
	 * 
	 * @function getResourceTypeImage 
	 * 
	 * @created_date : 07-Dec-2014
	 * 
	 * @description
	 * 
	 * 
	 * @parm(s) : @param resourceType
	 * @parm(s) : @return
	 * 
	 * @return : String
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public String getResourceTypeImage(String resourceType){
		if(resourceType.equalsIgnoreCase("Video")||resourceType.equalsIgnoreCase("Videos")){
			return PlayerBundle.INSTANCE.getPlayerStyle().videoResourceTypeInfo();
		}else if(resourceType.equalsIgnoreCase("Interactive")){
			return PlayerBundle.INSTANCE.getPlayerStyle().interactiveResourceTypeInfo();
		}
		else if(resourceType.equalsIgnoreCase("Website")||resourceType.equalsIgnoreCase("Webpage")){
			return PlayerBundle.INSTANCE.getPlayerStyle().websiteResourceTypeInfo();		
		}
		else if(resourceType.equalsIgnoreCase("Slide")){
			return PlayerBundle.INSTANCE.getPlayerStyle().imageResourceTypeInfo();
		}
		else if(resourceType.equalsIgnoreCase("Textbook")){
			return PlayerBundle.INSTANCE.getPlayerStyle().textResourceTypeInfo();
		}
		else if(resourceType.equalsIgnoreCase("Question")){
			return PlayerBundle.INSTANCE.getPlayerStyle().questionResourceTypeInfo();
		}
		else if(resourceType.equalsIgnoreCase("lesson")){
			return PlayerBundle.INSTANCE.getPlayerStyle().lessonResourceTypeInfo();
			
		}else if(resourceType.equalsIgnoreCase("Handout")){
			return PlayerBundle.INSTANCE.getPlayerStyle().textResourceTypeInfo();
		} else if(resourceType.equalsIgnoreCase("text")){
			return PlayerBundle.INSTANCE.getPlayerStyle().textResourceTypeInfo();
		}
		else if(resourceType.equalsIgnoreCase("image")){
			return PlayerBundle.INSTANCE.getPlayerStyle().imageResourceTypeInfo();
		}
		else if(resourceType.equalsIgnoreCase("audio")){
			return PlayerBundle.INSTANCE.getPlayerStyle().audioResourceTypeInfo();
		}else if(resourceType.equalsIgnoreCase("exam")){
			return PlayerBundle.INSTANCE.getPlayerStyle().websiteResourceTypeInfo();
		}
		else {
			return PlayerBundle.INSTANCE.getPlayerStyle().otherResourceTypeInfo();
		}
	}
	/**
	 * This method will return the view more label
	 * @return
	 */
	public Anchor getViewAllLabel(){
		return viewAllLbl;
	}
}