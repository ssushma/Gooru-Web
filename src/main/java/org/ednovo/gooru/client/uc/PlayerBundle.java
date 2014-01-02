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
package org.ednovo.gooru.client.uc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
/**
 * @fileName : PlayerBundle.java
 *
 * @description : This interface is used to set the styles for player. 
 *
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public interface PlayerBundle extends ClientBundle {

	static final PlayerBundle INSTANCE = GWT.create(PlayerBundle.class);

	public interface PlayerStyle extends CssResource {
		
		@ClassName("add-button-disabled")
		public String addButtonDisabled();
		
		@ClassName("add-button-normal")
		public String addButtonNormal();
		
		@ClassName("add-button-active")
		public String addButtonActive();
		
		@ClassName("info-button-disabled")
		public String infoButtonDisabled();
		
		@ClassName("info-button-normal")
		public String infoButtonNormal();
		
		@ClassName("info-button-active")
		public String infoButtonActive();
		
		@ClassName("share-button-disabled")
		public String shareButtonDisabled();
		
		@ClassName("share-button-normal")
		public String shareButtonNormal();
		
		@ClassName("share-button-active")
		public String shareButtonActive();
		
		@ClassName("narration-button-disabled")
		public String narrationButtonDisabled();
		
		@ClassName("narration-button-normal")
		public String narrationButtonNormal();
		
		@ClassName("narration-button-active")
		public String narrationButtonActive();
		
		@ClassName("navigation-button-disabled")
		public String navigationButtonDisabled();
		
		@ClassName("navigation-button-normal")
		public String navigationButtonNormal();
		
		@ClassName("navigation-button-active")
		public String navigationButtonActive();
		
		@ClassName("collection-course-wrapper")
		public String courseWrapper();
		
		@ClassName("collection-course-text")
		public String courseText();
		
		@ClassName("collection-standard-text")
		public String standardText();
		
		@ClassName("bottom-button-container")
		public String bottomButtonContainer();
		
		@ClassName("bottom-button-selected")
		public String bottomButtonSelected();
		
		@ClassName("bottom-button-normal")
		public String bottomButtonNormal();
		
		@ClassName("resource-source-name")
		public String resourceSourceName();
		
		@ClassName("bottom-button-arrow-course")
		public String bottomButtonArrowCourse();
		
		@ClassName("bottom-button-arrow-stand")
		public String bottomButtonArrowStand();
		
		@ClassName("bottom-button-arrow-acknow")
		public String bottomButtonArrowAck();
		
		@ClassName("resource-type-video")
		public String videoResourceType();
		
		@ClassName("resource-type-interactive")
		public String interactiveResourceType();
		
		@ClassName("resource-type-slide")
		public String slideResourceType();
		
		@ClassName("resource-type-question")
		public String questionResourceType();
		
		@ClassName("resource-type-website")
		public String websiteResourceType();
		
		@ClassName("resource-type-textbook")
		public String textbookResourceType();
		
		@ClassName("resource-type-handout")
		public String handoutResourceType();
		
		@ClassName("resource-type-lesson")
		public String lessonResourceType();
		
		@ClassName("resource-type-exam")
		public String examResourceType();
		
		@ClassName("resource-default-video")
		public String videoResourceDefault();
		
		@ClassName("resource-default-interactive")
		public String interactiveResourceDefault();
		
		@ClassName("resource-default-slide")
		public String slideResourceDefault();
		
		@ClassName("resource-default-question")
		public String questionResourceDefault();
		
		@ClassName("resource-default-website")
		public String websiteResourceDefault();
		
		@ClassName("resource-default-textbook")
		public String textbookResourceDefault();
		
		@ClassName("resource-default-handout")
		public String handoutResourceDefault();
		
		@ClassName("resource-default-lesson")
		public String lessonResourceDefault();
		
		@ClassName("resource-default-exam")
		public String examResourceDefault();
		
		@ClassName("resource-type-image")
		public String resourceTypeImage();
		
		
		@ClassName("answer-radio-normal-icon")
		public String normalRadioIcon();
		
		@ClassName("answer-radio-selected-icon")
		public String selectedRadioIcon();
		
		@ClassName("answer-checkbox-selected-icon")
		public String selectedCheckboxIcon();
		
		@ClassName("answer-checkbox-normal-icon")
		public String normalCheckboxIcon();
		
		@ClassName("answer-right-icon")
		public String answerRightIcon();
		
		@ClassName("answer-wrong-icon")
		public String answerWronIcon();
		
		@ClassName("toc-resource-selected")
		public String tocResourceSelected();
		

		@ClassName("source-separator")
		public String sourceSepartor();
		
	
		@ClassName("resource-course-label")
		public String resourceCourseLabel();
		

		@ClassName("resource-course-num")
		public String resourceCourseNum();
		
		@ClassName("collection-course-title")
		public String getCourseTitle();
		
	
		@ClassName("collection-course-count")
		public String getCourseCount();
		

		@ClassName("collection-resource-count")
		public String getResourceCount();

		public String setEllipses(); 
		
		public String setPopupArrow();
		
		@ClassName("popup-glasspanel")
		public String setGlassPanelStyle();
		
		@ClassName("user-text")
		public String setUserText();
		
		@ClassName("player-container")
		public String setPlayerContainer();
		
		public String dropdownListItemContainer();
		
		public String thumbsDownActive();
		
		public String thumbsDownNormal();
		
		public String thumbsUpActive();
		
		public String thumbsUpNormal();
		
	}

	@Source("playerstyle.css")
	PlayerStyle getPlayerStyle();

}
