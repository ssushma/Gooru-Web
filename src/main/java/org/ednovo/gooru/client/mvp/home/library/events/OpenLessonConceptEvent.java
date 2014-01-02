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
package org.ednovo.gooru.client.mvp.home.library.events;

import org.ednovo.gooru.shared.model.library.ConceptDo;

import com.google.gwt.event.shared.GwtEvent;
/**
 * @fileName : OpenLessonConceptEvent.java
 *
 * @description : This event is sent to the {@link com.gwtplatform.mvp.client.EventBus},
 * whenever the user fire this event it will set he concept and topics. 
 * 
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class OpenLessonConceptEvent extends GwtEvent<OpenLessonConceptHandler> {

	private ConceptDo conceptDo;
	private Integer topicId;
	
	public static final Type<OpenLessonConceptHandler> TYPE = new Type<OpenLessonConceptHandler>();
	
	/**
	 * class constructor.
	 */
	public OpenLessonConceptEvent(ConceptDo conceptDo, Integer topicId) {
		setConceptDo(conceptDo);
		setTopicId(topicId);
	}

	@Override
	public Type<OpenLessonConceptHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(OpenLessonConceptHandler handler) {
		handler.openLessonConcept(getConceptDo(),getTopicId());
	}

	/** 
	 * This method is to get the CollectionDo
	 */
	public ConceptDo getConceptDo() {
		return conceptDo;
	}

	/** 
	 * This method is to set the CollectionDo
	 */
	public void setConceptDo(ConceptDo conceptDo) {
		this.conceptDo = conceptDo;
	}

	/** 
	 * This method is to get the topicId
	 */
	public Integer getTopicId() {
		return topicId;
	}

	/** 
	 * This method is to set the topicId
	 */
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

}
