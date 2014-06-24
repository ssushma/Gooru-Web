package org.ednovo.gooru.client.mvp.profilepage.tab.content.Followers;


import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.shared.model.user.UserFollowDo;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ProfilePageUserInfoWidget extends Composite {

	private static ProfilePageUserInfoUiBinder uiBinder = GWT
			.create(ProfilePageUserInfoUiBinder.class);

	interface ProfilePageUserInfoUiBinder extends
			UiBinder<Widget, ProfilePageUserInfoWidget> {
	}
	@UiField Image profileThumbnailImage;
	@UiField Label userNameLabel,userCollections,userFollowDetails;
	UserFollowDo userFollowDo=new UserFollowDo();
	String tab;
	public ProfilePageUserInfoWidget(UserFollowDo userFollowDo,String tab) {
		this.userFollowDo=userFollowDo;
		this.tab = tab;
		initWidget(uiBinder.createAndBindUi(this));
		SetData();
	}
	public void SetData(){
	if("following".equalsIgnoreCase(tab)){
			setView(userFollowDo);
		}
		if("followers".equalsIgnoreCase(tab)){
			setView(userFollowDo);
		}
	}
	
	public void	setView(UserFollowDo userFollowDo){
		profileThumbnailImage.setUrl(userFollowDo.getProfileImageUrl());
		profileThumbnailImage.addErrorHandler(new ErrorHandler() {
			
			@Override
			public void onError(ErrorEvent event) {
				profileThumbnailImage.setUrl("images/settings/setting-user-image.png");
				
			}
		});
		
		//userNameLabel.setText(userFollowDo.getUsername());
		userNameLabel.getElement().setId(userFollowDo.getGooruUid());
		int collectionCount= userFollowDo.getSummary().getCollection();
		userCollections.setText(collectionCount+(collectionCount==1?" Collection":" Collections"));
		
		userFollowDetails.setText(userFollowDo.getSummary().getFollowers()+" Followers | " +userFollowDo.getSummary().getFollowing()+" Following");
		
		String gooruUid = userNameLabel.getElement().getId();
		Anchor anchor = new Anchor();
		String userName=userFollowDo.getUsername();
		
		String token= "#"+PlaceTokens.PROFILE_PAGE+"&id="+gooruUid+"&user="+userName;
		anchor.setHref(token);
		anchor.setText(userName);
		anchor.getElement().setAttribute("style","font-size: 18px !important");		
		anchor.setTarget("_blank");
		userNameLabel.setText("");
		boolean isEnabled =  userFollowDo.getCustomFields() != null && userFollowDo.getCustomFields().get(0).getOptionalValue() != null && userFollowDo.getCustomFields().get(0).getOptionalValue().equalsIgnoreCase("true") ? true : false;
		if (isEnabled){
			userNameLabel.getElement().appendChild(anchor.getElement());
		}else{
			userNameLabel.setText(userFollowDo.getUsername());
			userNameLabel.getElement().getStyle().setCursor(Cursor.DEFAULT);
		}
			
		
	}
	public void clearAll()
	{
		profileThumbnailImage.setUrl("");
		userNameLabel.setText("");
		userCollections.setText("");
		userFollowDetails.setText("");
		
	}
	
}
