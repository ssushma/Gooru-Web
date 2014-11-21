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
package org.ednovo.gooru.client.mvp.authentication.uc;

import java.util.HashSet;
import java.util.Set;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.authentication.SignUpCBundle;
import org.ednovo.gooru.client.mvp.home.LoginPopUpCBundle;
import org.ednovo.gooru.shared.model.code.CodeDo;
import org.ednovo.gooru.shared.model.code.ProfileCodeDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.user.ProfileDo;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

/**
 * @author DOTS
 *
 */
public abstract class SignupCourseLabel extends FlowPanel implements ClickHandler {
	
	private static final String REGISTER_USER_LEVEL = "settings";

	private ProfileDo profileDo = null;

	private Set<ProfileCodeDo> profileCodeDoSet = null;
	
	private CodeDo codeDo = null;
	
	private static final String SCIENCE_LBL = "Science";
	
	private static final String MATH_LBL = "Math";
	
	private static final String SOCIAL_LBL = "Social Sciences";

	private static final String ELA_LBL = "Language Arts";
	
	private static final String ARTS_HUMANITIES = "Arts & Humanities";
	
	private static final String TECH_ENGEE = "Technology & Engineering";
	
	/**
	 * Class constructor
	 * @param label name of the {@link Label}
	 * @param collectionDo instance of {@link CollectionDo}
	 */
	public SignupCourseLabel(int codeId, String codeName, ProfileDo profileDo, String imageUrl, final String subjectName){
		SignUpCBundle.INSTANCE.css().ensureInjected();
		addDomHandler(this, ClickEvent.getType());
		this.profileDo = profileDo;
		this.addStyleName(LoginPopUpCBundle.INSTANCE.css().courseOption());
				
		final Image courseImage = new Image(imageUrl);
		courseImage.setAltText(codeName);
		courseImage.setTitle(codeName);
		courseImage.addErrorHandler(new ErrorHandler() {
			
			@Override
			public void onError(ErrorEvent event) {
				if (subjectName.equalsIgnoreCase(SCIENCE_LBL)){
					courseImage.setUrl("images/course/"+SCIENCE_LBL.replaceAll(" ", "_")+"-default-course.gif");
				}else if (subjectName.equalsIgnoreCase(MATH_LBL)){
					courseImage.setUrl("images/course/"+MATH_LBL.replaceAll(" ", "_")+"-default-course.gif");
				}else if (subjectName.equalsIgnoreCase(SOCIAL_LBL)){
					courseImage.setUrl("images/course/"+SOCIAL_LBL.replaceAll(" ", "_")+"-default-course.gif");
				}else if (subjectName.equalsIgnoreCase(ELA_LBL)){
					courseImage.setUrl("images/course/"+ELA_LBL.replaceAll(" ", "_")+"-default-course.gif");
				}else{
					courseImage.setUrl("images/course/default-course.png");
				}
					
			}
		});
		
		this.add(courseImage);
		HTMLPanel coursePanel = new HTMLPanel("");
		coursePanel.addStyleName(LoginPopUpCBundle.INSTANCE.css().title());
		
		codeName = codeName.contains("English Language Arts") ? codeName.replaceAll("English Language Arts", "ELA") : codeName;
		Label courseLabel = new Label(codeName.trim().length() >= 20 ? codeName.trim().substring(0, 17) + "..." : codeName.trim());
		courseLabel.addStyleName("verticallyCentered");
		coursePanel.add(courseLabel);
		this.add(coursePanel);
		
		setCodeDo(codeId);
	}

	private void setCodeDo(int codeId) {
		profileCodeDoSet = new HashSet<ProfileCodeDo>();
		ProfileCodeDo profileCodeDo = new ProfileCodeDo();
		codeDo = new CodeDo();
		codeDo.setCodeId(codeId);
		profileCodeDo.setCode(codeDo);
		profileCodeDoSet.add(profileCodeDo);
	}
	
	@Override
	public void onClick(ClickEvent event) {
		if(this.getStyleName().toString().contains("selected")){
			deleteCourse(codeDo);
			this.removeStyleName(SignUpCBundle.INSTANCE.css().selected());
			selectCourseLabel(false);
			showErrorMessage(false);
		} else {
			if(getCourseCount()<5) {
				selectCourseLabel(true);
				addCourse(profileCodeDoSet);
				this.addStyleName(SignUpCBundle.INSTANCE.css().selected());
				showErrorMessage(false);
			} else {
				showErrorMessage(true);
			}
		}
	}
	

	public void addCourse(Set<ProfileCodeDo> profileCodeDoSet) {
		AppClientFactory.getInjector().getProfilePageService().addCourseUserProfile(profileCodeDoSet, REGISTER_USER_LEVEL, new SimpleAsyncCallback<Void>(){
			@Override
			public void onSuccess(Void result) {
			}
		});
	}

	public void deleteCourse(CodeDo codeDo) {
		AppClientFactory.getInjector().getProfilePageService().deleteCourseUserProfile(codeDo, REGISTER_USER_LEVEL, new SimpleAsyncCallback<Void>(){
			@Override
			public void onSuccess(Void result) {
			}
		});
	}

	public abstract int selectCourseLabel(boolean isSelected);
	
	public abstract int getCourseCount();
	
	public abstract void showErrorMessage(boolean value);
	
}
