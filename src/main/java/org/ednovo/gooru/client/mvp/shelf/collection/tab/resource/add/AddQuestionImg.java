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
package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
/**
 * 
 * @fileName : AddQuestionImg.java
 *
 * @description :This method is used to set Question Image.  
 *
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class AddQuestionImg extends Composite
{
	@UiField Label changeImgLbl;
	@UiField Label removeImgLbl;
	@UiField Label displayQuestLbl;
	@UiField Image questionImageContainer;
	
	private String fileName=null;
	private static final String DEFAULT_QUESTION_IMAGE="images/default-question.png";
	
	public interface AddQuestionImageUiBinder extends UiBinder <Widget, AddQuestionImg>{
		
	}
	
	public static AddQuestionImageUiBinder addQuestionImageUiBinder = GWT.create(AddQuestionImageUiBinder.class);
	
	public AddQuestionImg() {
		initWidget(addQuestionImageUiBinder.createAndBindUi(this)); 
	}
	
	
	public void setQuestionImage(String imageUrl){
		questionImageContainer.setUrl(imageUrl);
	}

/**
 * 
 * @function getFileName 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :This method is used to Get File name.
 * 
 * 
 * @parm(s) : @return
 * 
 * @return : String
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	public String getFileName() {
		return fileName;
	}

/**
 * 
 * @function setFileName 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :This method is used to Set File Name
 * 
 * 
 * @parm(s) : @param fileName
 * 
 * @return : void
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * 
	 * @function setQuetionDefaultImage 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This method is used to Set Question image Container.
	 * 
	 * 
	 * @parm(s) : @param event
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	@UiHandler("questionImageContainer")
	public void setQuetionDefaultImage(ErrorEvent event){
		questionImageContainer.setUrl(DEFAULT_QUESTION_IMAGE);
	}
	 

}
