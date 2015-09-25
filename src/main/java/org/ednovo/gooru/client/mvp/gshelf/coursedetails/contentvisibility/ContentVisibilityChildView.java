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
package org.ednovo.gooru.client.mvp.gshelf.coursedetails.contentvisibility;

import java.util.ArrayList;

import org.ednovo.gooru.application.client.child.ChildView;
import org.ednovo.gooru.application.shared.model.classpages.PlanProgressDo;
import org.ednovo.gooru.application.shared.model.content.ClasspageDo;
import org.ednovo.gooru.client.uc.SpanPanel;
import org.ednovo.gooru.shared.util.ClientConstants;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * @author Gooru Team
 *
 */

public class ContentVisibilityChildView extends ChildView<ContentVisibilityChildPresenter> implements IsContentVisibilityView,ClientConstants {

		@UiField HTMLPanel allClassPanel, tableItems;
		@UiField SpanPanel className;
		@UiField Button btnPublish;
		@UiField Anchor anrAllClasses;
		
		private static ContentVisibilityChildViewUiBinder uiBinder = GWT
				.create(ContentVisibilityChildViewUiBinder.class);

		interface ContentVisibilityChildViewUiBinder extends
				UiBinder<Widget, ContentVisibilityChildView> {
		}

		public ContentVisibilityChildView(ClasspageDo classObj, String courseId) {
			initWidget(uiBinder.createAndBindUi(this));
			setPresenter(new ContentVisibilityChildPresenter(this));
			className.setText(classObj.getName());
			setIds();
			getPresenter().getClassData(classObj.getClassUid(), courseId, null, null, "unit", null);
		}

		private void setIds() {
			allClassPanel.getElement().setId("shareContentInClass");
		}
		
		public Anchor getAnrAllClasses() {
			return anrAllClasses;
		}
		
		public void setLessonData(ArrayList<PlanProgressDo> dataList, final String classId, final String courseId, final String unitId, final String contentType, final ContentVisibilityItemWidget widget) {
			int size = dataList.size();
			for(int i=0;i<size;i++) {
				final String lessonId = dataList.get(i).getGooruOid();
				final ContentVisibilityItemWidget lessonWidget = new ContentVisibilityItemWidget(contentType, dataList.get(i).getTitle(), unitId, lessonId);
				lessonWidget.getLblContentName().addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						if(lessonWidget.getRowItem().getWidgetCount()<=2) {
							getPresenter().getClassData(classId, courseId, unitId, lessonId, "collection",lessonWidget);
						}
					}
				});
				widget.getRowItem().add(lessonWidget);
			}
		}
		
		public void setCollectionData(ArrayList<PlanProgressDo> dataList, String unitId, String lessonId, ContentVisibilityItemWidget widget) {
			int size = dataList.size();
			for(int i=0;i<size;i++) {
				final ContentVisibilityItemWidget collectionWidget = new ContentVisibilityItemWidget("collection",dataList.get(i).getTitle(),unitId,lessonId);
				if(collectionWidget.getRowItem().getWidgetCount()<=2) {
					widget.getRowItem().add(collectionWidget);
				}
			}
		}
		
		public void setUnitData(ArrayList<PlanProgressDo> dataList, final String classId, final String courseId, String contentType) {
			tableItems.clear();
			int size = dataList.size();
			for(int i=0;i<size;i++) {
				final String unitId = dataList.get(i).getGooruOid();
				final ContentVisibilityItemWidget unitWidget = new ContentVisibilityItemWidget(contentType, dataList.get(i).getTitle(), unitId, null);
				unitWidget.getLblContentName().addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						if(unitWidget.getRowItem().getWidgetCount()<=2) {
							getPresenter().getClassData(classId, courseId, unitId, null, "lesson",unitWidget);
						}
					}
				});
				tableItems.add(unitWidget);
			}
		}

		@Override
		public void setData(ArrayList<PlanProgressDo> dataList, String classId, String courseId, String unitId, String lessonId, String contentType, ContentVisibilityItemWidget widget) {
			if("unit".equalsIgnoreCase(contentType)) {
				setUnitData(dataList, classId, courseId, contentType);
			} else if ("lesson".equalsIgnoreCase(contentType)) {
				setLessonData(dataList,classId,courseId,unitId,contentType,widget);
			} else if ("collection".equalsIgnoreCase(contentType)) {
				setCollectionData(dataList,unitId,lessonId,widget);
			}
		}
	}