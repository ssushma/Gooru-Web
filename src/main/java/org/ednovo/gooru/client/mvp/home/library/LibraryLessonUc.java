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
package org.ednovo.gooru.client.mvp.home.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.home.library.events.OpenLessonConceptEvent;
import org.ednovo.gooru.client.mvp.home.library.events.SetConceptTitleStyleEvent;
import org.ednovo.gooru.client.mvp.home.library.events.SetConceptTitleStyleHandler;
import org.ednovo.gooru.client.mvp.home.library.events.SetLoadingIconEvent;
import org.ednovo.gooru.shared.model.library.ConceptDo;
import org.ednovo.gooru.shared.model.library.LessonDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : LibraryLessonUc.java
 *
 * @description : This class is used to display the view for the library lesson.
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class LibraryLessonUc extends Composite {

	@UiField HTMLPanel lessonList;
	@UiField LibraryStyleBundle libraryStyleUc;
	private Integer topicId;
	private String conceptId;
	private Integer lessonId;
	Map<String,Label> conceptTitles = new HashMap<String,Label>();
	
	private static LibraryLessonUcUiBinder uiBinder = GWT
			.create(LibraryLessonUcUiBinder.class);

	interface LibraryLessonUcUiBinder extends UiBinder<Widget, LibraryLessonUc> {
	}
	/**
	 * Class constructor.
	 * @param lessonDo
	 * @param topicId
	 * @param isLessonHighlighted
	 * @param lessonNumber
	 */
	public LibraryLessonUc(LessonDo lessonDo, Integer topicId, boolean isLessonHighlighted, Integer lessonNumber) {
		initWidget(uiBinder.createAndBindUi(this));
		AppClientFactory.getEventBus().addHandler(SetConceptTitleStyleEvent.TYPE, setConceptTitleStyleHandler);
		this.topicId = topicId;
		setLessonData(lessonDo,isLessonHighlighted,lessonNumber);
	}
	/**
	 * @function setLessonData 
	 * 
	 * @created_date : 30-Dec-2013
	 * 
	 * @description : This method is used to set lesson data.
	 * 
	 * @parm(s) : @param lessonDo
	 * @parm(s) : @param isLessonHighlighted
	 * @parm(s) : @param lessonNumber
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private void setLessonData(final LessonDo lessonDo,boolean isLessonHighlighted, Integer lessonNumber) {
		HTML lessonTitle = new HTML("Lesson "+lessonNumber+": "+lessonDo.getLabel());
		lessonTitle.setStyleName(libraryStyleUc.lessonTitle());
		lessonList.add(lessonTitle);
		lessonId = lessonDo.getCodeId();
		ArrayList<ConceptDo> conceptDoList = lessonDo.getCollection();
		for(int i = 0; i<conceptDoList.size(); i++) {
			final ConceptDo conceptDo = conceptDoList.get(i);
			Label conceptTitle = new Label(conceptDo.getTitle());
			conceptTitle.addStyleName(libraryStyleUc.conceptTitle());
			lessonList.add(conceptTitle);
			conceptTitles.put(conceptDo.getGooruOid(), conceptTitle);
			if(i==0&&isLessonHighlighted) {
				conceptTitle.addStyleName(libraryStyleUc.conceptTitleActive());
				isLessonHighlighted = false;
			}
			conceptTitle.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					conceptId = conceptDo.getGooruOid();
					AppClientFactory.fireEvent(new SetConceptTitleStyleEvent(conceptId,topicId,lessonId));
					AppClientFactory.fireEvent(new SetLoadingIconEvent(true,topicId));
					getConceptDetails(conceptId);
				}
			});
		}
	}
	
	/**
	 * 
	 * @function getConceptDetails 
	 * 
	 * @created_date : 13-Dec-2013
	 * 
	 * @description: This method is used to get the concept details based on the gooruOid.
	 * 
	 * @parm(s) : @param gooruOid
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	private void getConceptDetails(String gooruOid) {
		AppClientFactory.getInjector().getLibraryService().getConcept(gooruOid, false, new AsyncCallback<ConceptDo>() {
			@Override
			public void onSuccess(ConceptDo conceptDo) {
				AppClientFactory.fireEvent(new OpenLessonConceptEvent(conceptDo,topicId));
			}
			
			@Override
			public void onFailure(Throwable caught) {
				throw new RuntimeException("Not implemented");
			}
		});
	}
	
	
	SetConceptTitleStyleHandler setConceptTitleStyleHandler = new SetConceptTitleStyleHandler() {
		@Override
		public void setConceptTitleStyleHandler(String collectionId, Integer topicNo, Integer lessonNo) {
			if(topicNo==topicId) {
				for (Map.Entry<String, Label> entry : conceptTitles.entrySet()) {
				    if(entry.getKey().equals(collectionId)&&(lessonId==lessonNo)) {
					    entry.getValue().addStyleName(libraryStyleUc.conceptTitleActive());
				    } else {
				    	entry.getValue().removeStyleName(libraryStyleUc.conceptTitleActive());
				    }
				}
			}
		}
	};
}
