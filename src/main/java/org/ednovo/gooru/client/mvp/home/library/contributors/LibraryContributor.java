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
package org.ednovo.gooru.client.mvp.home.library.contributors;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.home.library.LibraryStyleBundle;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.player.resource.shared.StringUtil;
import org.ednovo.gooru.shared.model.library.LibraryUserDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : LibraryContributor.java
 *
 * @description : This class is used to display the library contributors.
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class LibraryContributor extends Composite {

	@UiField Image educatorPhoto;
	@UiField Label educatorName, userName;
	@UiField HTMLPanel courses;
	@UiField LibraryStyleBundle libraryStyleUc;

	private static final String COURSE_PAGE_URL = "#discover&page=course-page&subject={0}&courseId={1}";
	
	private static final String PNG = ".png";
	
	private static LibraryContributorUiBinder uiBinder = GWT.create(LibraryContributorUiBinder.class);

	interface LibraryContributorUiBinder extends UiBinder<Widget, LibraryContributor> {}
	/**
	 * Class constructor.
	 * @param libraryUserDo
	 */
	public LibraryContributor(LibraryUserDo libraryUserDo) {
		initWidget(uiBinder.createAndBindUi(this));
		setEducatorData(libraryUserDo);
		educatorPhoto.setHeight("165px");
		educatorPhoto.setWidth("185px");
	}
	
	/**
	 * 
	 * @function setEducatorData 
	 * 
	 * @created_date : 05-Dec-2013
	 * 
	 * @description : This method is used to set the educator data.
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private void setEducatorData(LibraryUserDo libraryUserDo) {
		
		educatorPhoto.setUrl(AppClientFactory.getLoggedInUser().getSettings().getProfileImageUrl() + libraryUserDo.getGooruUId()+PNG);
		educatorPhoto.addErrorHandler(new ErrorHandler() {
			@Override
			public void onError(ErrorEvent event) {
				educatorPhoto.setUrl("../images/settings/setting-user-image.png");
			}
		});
		educatorPhoto.setAltText(libraryUserDo.getFirstName()+"'s photo");
		educatorName.setText(libraryUserDo.getFirstName()+" "+libraryUserDo.getLastName());
		userName.setText(libraryUserDo.getUsername());
		Label authorCoursesLbl = new Label(libraryUserDo.getUsername()+"'s Courses");
		authorCoursesLbl.setStyleName(libraryStyleUc.header());
		courses.add(authorCoursesLbl);
		for(int i=0;i<libraryUserDo.getCourses().size();i++) {
			Anchor authorCourseAnr = new Anchor(libraryUserDo.getCourses().get(i).getLabel());
			authorCourseAnr.setStyleName(libraryStyleUc.course());
			authorCourseAnr.setHref(StringUtil.generateMessage(COURSE_PAGE_URL, libraryUserDo.getCourses().get(i).getParentId(), ""+libraryUserDo.getCourses().get(i).getCodeId()));
			authorCourseAnr.addClickHandler(new MixpanelEventHandler());
			courses.add(authorCourseAnr);
		}
	}
	/**
	 * This inner class will handle the click event on the library page.
	 */
	private class MixpanelEventHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			MixpanelUtil.mixpanelEvent("ContributorsPage_ClickCourse");
		}
	}
}
