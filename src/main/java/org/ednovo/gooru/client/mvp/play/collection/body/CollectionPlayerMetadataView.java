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
package org.ednovo.gooru.client.mvp.play.collection.body;

import java.util.List;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.play.collection.event.UpdateCollectionViewCountEvent;
import org.ednovo.gooru.client.uc.BottomButtonView;
import org.ednovo.gooru.client.uc.CollectionAcknowledgeView;
import org.ednovo.gooru.client.uc.CollectionCourseView;
import org.ednovo.gooru.client.uc.CollectionStandardsView;
import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.content.StandardFo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class CollectionPlayerMetadataView extends BaseViewWithHandlers<CollectionPlayerMetadataUiHandlers> implements IsCollectionPlayerMetadataView{

	@UiField InlineLabel userNameLabel,viewsCountLabel,likesCountLabel;
	@UiField Label collectionGoalLabel;
	@UiField Button studyButton;
	@UiField Image collectionThumbnailImage;
	@UiField FlowPanel upArrowImage,bottomContainer;
	@UiField BottomButtonView courseButton,standardButton,acknowledgeButton;
	private CollectionDo collectionDo=null;
	private static CollectionPlayerMetadataViewUiBinder uiBinder = GWT.create(CollectionPlayerMetadataViewUiBinder.class);

	interface CollectionPlayerMetadataViewUiBinder extends UiBinder<Widget, CollectionPlayerMetadataView> {
	}
	
	@Inject
	public CollectionPlayerMetadataView(){
		setWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiHandler("collectionThumbnailImage")
	public void thumbnailErrorImage(ErrorEvent event){
		collectionThumbnailImage.setUrl("images/collection-default-thubnail.png");
	}
	
	@UiHandler("courseButton")
	public void courseButtonClickEvent(ClickEvent event){
		if(courseButton.getCount()>0){
			selectBottomButton(true,false,false);
			upArrowImage.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().bottomButtonArrowCourse());
			renderCourses(collectionDo.getMetaInfo().getCourse());
		}
	}
	@UiHandler("standardButton")
	public void standardButtonClickEvent(ClickEvent event){
		if(standardButton.getCount()>0){
			selectBottomButton(false,true,false);
			upArrowImage.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().bottomButtonArrowStand());
			renderStandards(collectionDo.getMetaInfo().getStandards());
		}
	}
	@UiHandler("acknowledgeButton")
	public void acknowledgeButtonClickEvent(ClickEvent event){
		if(acknowledgeButton.getCount()>0){
			selectBottomButton(false,false,true);
			upArrowImage.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().bottomButtonArrowAck());
			renderAcknowlegesList(collectionDo);
		}
	}
	
	@Override
	public void setCollectionMetadata(final CollectionDo collectionDo) {
		if(collectionDo!=null&&collectionDo.getGooruOid()!=null){
			if(this.collectionDo!=null&&this.collectionDo.getGooruOid().equalsIgnoreCase(collectionDo.getGooruOid())){
				return;
			}
			this.collectionDo=collectionDo;
			setThumbnailImage(collectionDo.getThumbnails().getUrl());
			setUserName(collectionDo.getUser().getUsernameDisplay());
			setViewCount(collectionDo.getViews());
			setCollectionGoal(collectionDo.getGoals());
			setLikesCount(collectionDo.getMetaInfo().getRating().getVotesUp());
			setMetadataCounts(collectionDo);
			studyButton.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					List<CollectionItemDo> collectionItems=collectionDo.getCollectionItems();
					if(collectionItems.size()>0){
						CollectionItemDo collectionItemDo=collectionItems.get(0);
						AppClientFactory.fireEvent(new UpdateCollectionViewCountEvent());
						if(collectionItemDo.getNarration()!=null&&!collectionItemDo.getNarration().trim().equals("")){
							PlaceRequest request=new PlaceRequest(PlaceTokens.COLLECTION_PLAY).with("id", collectionDo.getGooruOid())
									.with("rid", collectionItemDo.getCollectionItemId())
									.with("tab", "narration");
							AppClientFactory.getPlaceManager().revealPlace(false,request,true);
						}else{
							PlaceRequest request=new PlaceRequest(PlaceTokens.COLLECTION_PLAY).with("id", collectionDo.getGooruOid()).with("rid", collectionItemDo.getCollectionItemId());
							AppClientFactory.getPlaceManager().revealPlace(false,request,true);
						}
						
					}
				}
			});
		}
	}
	public void setUserName(String userName){
		userNameLabel.setText(userName);
	}
	public void setCollectionGoal(String collectionGoal){
		collectionGoalLabel.setText(collectionGoal);
	}
	public void setViewCount(String viewCount){
		String viewsText=Integer.parseInt(viewCount)==1?viewCount+" View":viewCount+" Views";
		viewsCountLabel.setText(viewsText);
	}
	public void setLikesCount(int likesCount){
		String likesText=likesCount==1?likesCount+" Like":likesCount+" Likes";
		likesCountLabel.setText(likesText);
	}
	public void setThumbnailImage(String imageUrl){
		collectionThumbnailImage.setUrl(imageUrl);
	}
	public void setMetadataCounts(CollectionDo collectionDo){
		int courseCount=collectionDo.getMetaInfo().getCourse()!=null?collectionDo.getMetaInfo().getCourse().size():0;
		int standardCount=collectionDo.getMetaInfo().getStandards()!=null?collectionDo.getMetaInfo().getStandards().size():0;
		int acknowldegeCount=collectionDo.getMetaInfo().getAcknowledgement()!=null?collectionDo.getMetaInfo().getAcknowledgement().size():0;
		if(courseCount!=0){
			courseButton.setCount(courseCount);
			courseButton.addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().bottomButtonContainer());
			courseButton.addCountStyle(PlayerBundle.INSTANCE.getPlayerStyle().bottomButtonNormal());
		}
		if(standardCount!=0){
			standardButton.setCount(standardCount);
			standardButton.addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().bottomButtonContainer());
			standardButton.addCountStyle(PlayerBundle.INSTANCE.getPlayerStyle().bottomButtonNormal());
		}
		if(acknowldegeCount!=0){
			acknowledgeButton.setCount(acknowldegeCount);
			acknowledgeButton.addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().bottomButtonContainer());
			acknowledgeButton.addCountStyle(PlayerBundle.INSTANCE.getPlayerStyle().bottomButtonNormal());
		}
		if(courseCount!=0){
			courseButtonClickEvent(null);
		}else if(standardCount!=0){
			standardButtonClickEvent(null);
		}else if(acknowldegeCount!=0){
			acknowledgeButtonClickEvent(null);
		}
	}
	private void selectBottomButton(boolean isCourseButtonActive,boolean isStandardButtonActive,boolean isAcknowledgeButtonActive){
		makeButtonNormal();
		if(isCourseButtonActive){
			courseButton.getCourseCountText().getElement().getStyle().setColor("#82BFE9");
		}else if(isStandardButtonActive){
			standardButton.getCourseCountText().getElement().getStyle().setColor("#82BFE9");
		}else if(isAcknowledgeButtonActive){
			acknowledgeButton.getCourseCountText().getElement().getStyle().setColor("#82BFE9");
		}
	}
	private void makeButtonNormal(){
		courseButton.getCourseCountText().getElement().getStyle().clearColor();
		standardButton.getCourseCountText().getElement().getStyle().clearColor();
		acknowledgeButton.getCourseCountText().getElement().getStyle().clearColor();
	}	
	public void renderCourses(List<String> coursesList){
		 bottomContainer.clear();
		 bottomContainer.add(new CollectionCourseView(coursesList));
	}
	public void renderStandards(List<StandardFo> standardsList){
		bottomContainer.clear();
		bottomContainer.add(new CollectionStandardsView(standardsList));
	}
	public void renderAcknowlegesList(CollectionDo collectionDo){
		bottomContainer.clear();
		bottomContainer.add(new CollectionAcknowledgeView(collectionDo));
		
	}
	public void resetMetadataFields(){
		userNameLabel.setText("");
		collectionGoalLabel.setText("");
		viewsCountLabel.setText("");
		likesCountLabel.setText("");
	}

	@Override
	public void setUserProfileName(String gooruUid) {
		Anchor anchor=new Anchor();
		String userName=userNameLabel.getText();
		anchor.setHref("#profilepage&id="+gooruUid+"&user="+userName);
		anchor.setText(userName);
		anchor.setStyleName(PlayerBundle.INSTANCE.getPlayerStyle().setUserText());
		anchor.setTarget("_blank");
		userNameLabel.setText("");
		userNameLabel.getElement().appendChild(anchor.getElement());
	}	
}
