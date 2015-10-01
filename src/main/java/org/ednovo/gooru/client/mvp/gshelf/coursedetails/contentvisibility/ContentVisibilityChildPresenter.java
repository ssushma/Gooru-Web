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
/**
 *
 */
package org.ednovo.gooru.client.mvp.gshelf.coursedetails.contentvisibility;

import java.util.ArrayList;

import org.ednovo.gooru.application.client.child.ChildPresenter;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.model.classpages.PlanProgressDo;
import org.ednovo.gooru.shared.util.ClientConstants;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author Search Team
 *
 */
public class ContentVisibilityChildPresenter extends ChildPresenter<ContentVisibilityChildPresenter, IsContentVisibilityView> implements ContentVisibilityUiHandlers,ClientConstants{

	public ContentVisibilityChildPresenter(IsContentVisibilityView childView) {
		super(childView);
	}

	@Override
	public void getClassData(final String classId, final String courseId, final String unitId, final String lessonId, final String contentType, final ContentVisibilityItemWidget widget) {
		AppClientFactory.getInjector().getClasspageService().getContentVisibilityData(classId, courseId, unitId, lessonId, new AsyncCallback<ArrayList<PlanProgressDo>>() {
			@Override
			public void onSuccess(ArrayList<PlanProgressDo> dataList) {
				getView().setData(dataList, classId, courseId, unitId, lessonId, contentType, widget);
			}
			@Override
			public void onFailure(Throwable caught) {
				
			}
		});
	}
	
	@Override
	public void updateContentVisibilityData(String classId, final ArrayList<PlanProgressDo> data) {
		AppClientFactory.getInjector().getClasspageService().updateClassContentVisibility(classId, data, new AsyncCallback<Boolean>() {
			@Override
			public void onFailure(Throwable caught) {
				
			}
			@Override
			public void onSuccess(Boolean result) {
				getView().closePublishPopup(data);
			}
		});
	}
}