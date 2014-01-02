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
package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : UpdateQuestionImageView.java
 *
 * @description : This will return the update question image view.
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class UpdateQuestionImageView extends Composite{
	
	private String thumbnailImageUrl=null;
	@UiField Image updateQuestionImage;
	@UiField Label uploadImage;
	@UiField Label removeImage;
	public interface UpdateQuestionImageViewUiBinder extends UiBinder<Widget, UpdateQuestionImageView>{
		
	}
	
	private static UpdateQuestionImageViewUiBinder uiBinder=GWT.create(UpdateQuestionImageViewUiBinder.class);
	
	
	/**
	 * Class constructor.
	 */
	public UpdateQuestionImageView(){
		initWidget(uiBinder.createAndBindUi(this));
	}


	/**
	 * This method is used to get the update question image.
	 */
	public Image getUpdateQuestionImage() {
		return updateQuestionImage;
	}


	/**
	 * This method is used to get the update image.
	 */
	public Label getUploadImage() {
		return uploadImage;
	}


	/**
	 * This method is used to get the remove image.
	 */
	public Label getRemoveImage() {
		return removeImage;
	}


	/**
	 * This method is used to set the update question image.
	 */
	public void setUpdateQuestionImage(Image updateQuestionImage) {
		this.updateQuestionImage = updateQuestionImage;
	}


	/**
	 * This method is used to set the update  image.
	 */
	public void setUploadImage(Label uploadImage) {
		this.uploadImage = uploadImage;
	}


	/**
	 * This method is used to set the remove image.
	 */
	public void setRemoveImage(Label removeImage) {
		this.removeImage = removeImage;
	}


	/**
	 * This method is used to get the thumbnail image url.
	 */
	public String getThumbnailImageUrl() {
		return thumbnailImageUrl;
	}


	/**
	 * This method is used to set the thumbnail image url.
	 */
	public void setThumbnailImageUrl(String thumbnailImageUrl) {
		this.thumbnailImageUrl = thumbnailImageUrl;
	}
	
	
}
