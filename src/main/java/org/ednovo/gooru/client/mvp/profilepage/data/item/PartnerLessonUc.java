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
package org.ednovo.gooru.client.mvp.profilepage.data.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.home.library.events.OpenLessonConceptEvent;
import org.ednovo.gooru.client.mvp.home.library.events.SetConceptTitleStyleEvent;
import org.ednovo.gooru.client.mvp.home.library.events.SetConceptTitleStyleHandler;
import org.ednovo.gooru.client.mvp.home.library.events.SetLoadingIconEvent;
import org.ednovo.gooru.client.mvp.profilepage.data.ProfilePageLibraryStyleBundle;
import org.ednovo.gooru.shared.model.library.ConceptDo;
import org.ednovo.gooru.shared.model.library.LessonDo;
import org.ednovo.gooru.shared.model.library.PartnerFolderDo;
import org.ednovo.gooru.shared.util.MessageProperties;

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

public class PartnerLessonUc extends Composite implements MessageProperties {

	@UiField HTMLPanel lessonList;
	@UiField ProfilePageLibraryStyleBundle style;
	private Integer topicId;
	private String conceptId;
	private Integer lessonId;
	private String lessonLabel;
	private String lessonCode;
	Map<String,Label> conceptTitles = new HashMap<String,Label>();
	HTMLPanel conceptList = new HTMLPanel("");
	HTML lessonTitle = new HTML();
	
	private static LibraryLessonUcUiBinder uiBinder = GWT
			.create(LibraryLessonUcUiBinder.class);

	interface LibraryLessonUcUiBinder extends UiBinder<Widget, PartnerLessonUc> {
	}

	public PartnerLessonUc(ArrayList<ConceptDo> conceptDoList, Integer topicId, boolean isLessonHighlighted, Integer lessonNumber) {
		initWidget(uiBinder.createAndBindUi(this));
		AppClientFactory.getEventBus().addHandler(SetConceptTitleStyleEvent.TYPE, setConceptTitleStyleHandler);
		this.topicId = topicId;
		setLessonData(null, null, conceptDoList, isLessonHighlighted,lessonNumber);
	}

	public PartnerLessonUc(PartnerFolderDo partnerFolderDo, Integer topicId, boolean isLessonHighlighted, Integer lessonNumber) {
		initWidget(uiBinder.createAndBindUi(this));
		AppClientFactory.getEventBus().addHandler(SetConceptTitleStyleEvent.TYPE, setConceptTitleStyleHandler);
		this.topicId = topicId;
		setLessonData(null, partnerFolderDo,partnerFolderDo.getCollections(),isLessonHighlighted,lessonNumber);
	}
	/**
	 * 
	 * @param arrayList 
	 * @param lessonNumber 
	 * @function setLessonData 
	 * 
	 * @created_date : 11-Dec-2013
	 * 
	 * @description
	 * 
	 * 
	 * @parm(s) : @param lessonDo
	 * @parm(s) : @param isLessonHighlighted
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>	 
	 * 
	 */
	private void setLessonData(final LessonDo lessonDo, final PartnerFolderDo partnerFolderDo, ArrayList<ConceptDo> conceptDoList, boolean isLessonHighlighted, Integer lessonNumber) {
		if(partnerFolderDo!=null) {
			lessonTitle.setHTML(partnerFolderDo.getTitle());
			lessonTitle.addStyleName(style.lessonTitle());
			if(lessonNumber == 1) {
				lessonTitle = setOpenStyle(true);
			} else {
				lessonTitle = setOpenStyle(false);
			}
			lessonList.add(lessonTitle);
			lessonId = lessonNumber;
		}
		lessonTitle.addClickHandler(new OpenLessonHandler());
		for(int i = 0; i<conceptDoList.size(); i++) {
			String conceptTitle = "";
			final ConceptDo conceptDo = conceptDoList.get(i);
			conceptTitle = conceptDo.getTitle();
			
			Label conceptTitleLbl = new Label(conceptTitle);
			conceptTitleLbl.addStyleName(style.conceptTitle());
			conceptTitleLbl.addStyleName(style.collectionSmall());
			conceptList.add(conceptTitleLbl);
			conceptTitles.put(conceptDo.getGooruOid(), conceptTitleLbl);
			if(i==0&&isLessonHighlighted) {
				conceptTitleLbl.addStyleName(style.conceptActive());
				isLessonHighlighted = false;
			}
			conceptTitleLbl.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					conceptId = conceptDo.getGooruOid();
					AppClientFactory.fireEvent(new SetConceptTitleStyleEvent(conceptId,topicId,lessonId));
					AppClientFactory.fireEvent(new SetLoadingIconEvent(true,topicId));
					getConceptDetails(conceptId);
				}
			});
		}
		lessonList.add(conceptList);
		if(lessonNumber == 1) {
			conceptList = openConceptList(true);
		} else {
			conceptList = openConceptList(false);
		}
	}

	/**
	 * 
	 * @function getConceptDetails 
	 * 
	 * @created_date : 13-Dec-2013
	 * 
	 * @description
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
				AppClientFactory.fireEvent(new OpenLessonConceptEvent(conceptDo,topicId,lessonId+"",lessonLabel,lessonCode));
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
					    entry.getValue().addStyleName(style.conceptActive());
				    } else {
				    	entry.getValue().removeStyleName(style.conceptActive());
				    }
				}
			}
		}
	};
	
	private HTML setOpenStyle(boolean isOpen) {
		if(isOpen) {
			lessonTitle.addStyleName(style.open());
		} else {
			lessonTitle.removeStyleName(style.open());
		}
		return lessonTitle;
	}
	
	private HTMLPanel openConceptList(boolean isOpen) {
		if(isOpen) {
			conceptList.setVisible(true);
		} else {
			conceptList.setVisible(false);
		}
		return conceptList;
	}
	
	public class OpenLessonHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			if(conceptList.isVisible()) {
				openConceptList(false);
				setOpenStyle(false);
			} else {
				openConceptList(true);
				setOpenStyle(true);
			}
		}
	}
}