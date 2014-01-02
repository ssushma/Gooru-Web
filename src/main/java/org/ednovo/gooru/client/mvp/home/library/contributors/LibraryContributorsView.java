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

import java.util.ArrayList;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.library.LibraryUserDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : LibraryContributorsView.java
 *
 * @description : This class will display the library contributors.
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class LibraryContributorsView extends Composite {

	@UiField HTMLPanel container;
	@UiField HTMLPanel featuredEducatorsPanel;
	
	private static LibraryContributorsViewUiBinder uiBinder = GWT
			.create(LibraryContributorsViewUiBinder.class);

	interface LibraryContributorsViewUiBinder extends
			UiBinder<Widget, LibraryContributorsView> {
	}
	/**
	 * Class constructor.
	 */
	public LibraryContributorsView() {
		initWidget(uiBinder.createAndBindUi(this));
		getFeaturedUsers();
	}
	
	/**
	 * 
	 * @function getFeaturedUsers 
	 * 
	 * @created_date : 06-Dec-2013
	 * 
	 * @description : This method is used to get the featured users.
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 */
	private void getFeaturedUsers() {
		AppClientFactory.getInjector().getLibraryService().getLibraryFeaturedUsers(new AsyncCallback<ArrayList<LibraryUserDo>>() {
			@Override
			public void onSuccess(ArrayList<LibraryUserDo> userDoList) {
				setFeaturedUsers(userDoList);
			}
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}
	
	/**
	 * 
	 * @function setFeaturedUsers 
	 * 
	 * @created_date : 06-Dec-2013
	 * 
	 * @description : This method is used to set the featured users.
	 * 
	 * @parm(s) : @param userDoList
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 */
	private void setFeaturedUsers(ArrayList<LibraryUserDo> userDoList) {
		MixpanelUtil.mixpanelEvent("View_ContributorsPage");
		container.getElement().setId("container");
		for(int i=0; i<userDoList.size();i++) {
			featuredEducatorsPanel.add(new LibraryContributor(userDoList.get(i)));
		}
	}
}
