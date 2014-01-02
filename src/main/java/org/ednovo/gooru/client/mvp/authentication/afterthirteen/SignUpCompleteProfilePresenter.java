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
package org.ednovo.gooru.client.mvp.authentication.afterthirteen;


import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.authentication.uc.ThankPopUpForUpdateProfile;
import org.ednovo.gooru.client.mvp.home.event.SetUpdateProfileImageEvent;
import org.ednovo.gooru.client.mvp.image.upload.ImageUploadPresenter;
import org.ednovo.gooru.shared.model.user.V2UserDo;


import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
/**
 * 
 * @fileName : SignUpCompleteProfilePresenter.java
 *
 * @description : This is the presenter of the sign up complete process. 
 *
 * @version : 1.0
 *
 * @date: 26-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class SignUpCompleteProfilePresenter extends PresenterWidget<IsSignUpCompleteProfile> implements SignUpCompleteProfileUiHandler {
	
	private ImageUploadPresenter imageUploadPresenter;
	/**
	 * Parameterized constructor
	 * @param eventBus
	 * @param view
	 * @param imageUploadPresenter
	 */
	@Inject
	public SignUpCompleteProfilePresenter(EventBus eventBus,
			IsSignUpCompleteProfile view,ImageUploadPresenter imageUploadPresenter) {
			super(eventBus, view);
			getView().setUiHandlers(this);
			this.imageUploadPresenter = imageUploadPresenter;
	}
	/**
	 * This method will load at first time , when we call this presenter.
	 */
	@Override
	public void onBind() {
		super.onBind();
		addRegisteredHandler(SetUpdateProfileImageEvent.TYPE, this);
	}
	/**
	 * This method will load at first time , when we call this presenter.
	 */
	@Override
	public void onReveal() {
		super.onReveal();
	}
	/**
	 * This method is used to display the upload image for a profile.
	 */
	public void showUploadProfileImageWidget(){
	imageUploadPresenter.showUploadTypeWidgets(false);
	addToPopupSlot(imageUploadPresenter);
	imageUploadPresenter.setProfileImage(false);
	imageUploadPresenter.setCollectionImage(false);
	imageUploadPresenter.setEditResourceImage(false);
	imageUploadPresenter.setUdateProfileImage(true);
	}
	/**
	 * This method is used to display the view.
	 */
	@Override
	public void displayView(){
		getView().displayView();
	}
	/**
	 * This method is used to set the update profile image url.
	 */
	@Override
	public void setUpdateProfileImage(String imageUrl) {
		getView().setUpdateProfileImage(imageUrl);
	}
	/**
	 * This method is used to update the profile image for a user.
	 */
	@Override
	public void updateProfile(String fname,String lname,String aboutMe,String password) {
		AppClientFactory.getInjector().getUserService().updateV2ProfileDo("", "", fname, lname, aboutMe,password, new AsyncCallback<V2UserDo>() {
			
			@Override
			public void onSuccess(V2UserDo result) {
				getView().getUpdateButton().setVisible(false);
				ThankPopUpForUpdateProfile thankPopUpForUpdateProfile=new ThankPopUpForUpdateProfile();
				thankPopUpForUpdateProfile.show();
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				
			}
		});
	}
}
