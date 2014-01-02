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
package org.ednovo.gooru.client.mvp.image.upload;

import org.ednovo.gooru.client.uc.BlueButtonUc;
import org.ednovo.gooru.client.uc.LoadingUc;

import com.google.code.gwt.crop.client.GWTCropper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : ImageCropView.java
 *
 * @description : This class is used to for image cropping .
 *
 * @version : 1.0
 *
 * @date: 30-Dec-2013
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public abstract class ImageCropView extends Composite {

	@UiField
	Label backPageLinkLbl;

	@UiField
	FlowPanel cropImageWidgetFloPanel;

	@UiField
	BlueButtonUc cropImageBtn;

	@UiField
	Anchor cancelButtonAnr;
	
	@UiField
	VerticalPanel cropImageLoadingVerPanel;
	
	@UiField
	LoadingUc cropImageLoading;
	
	@UiField
	Label loadingTextLbl;
	
	@UiField
	FlowPanel buttonContainer;
	
	private GWTCropper crop;


	private static ImageCropViewUiBinder uiBinder = GWT.create(ImageCropViewUiBinder.class);

	interface ImageCropViewUiBinder extends UiBinder<Widget, ImageCropView> {
	}

	/**
	 * Class constructor
	 */
	public ImageCropView() {
		super();
		initWidget(uiBinder.createAndBindUi(this));
		cropImageLoadingVerPanel.setCellVerticalAlignment(cropImageLoading, HasVerticalAlignment.ALIGN_MIDDLE);
		buttonContainer.setVisible(true);
		loadingTextLbl.setVisible(false);
	}

	/**
	 * Crop given image and add it to crop image widget
	 * @param imageURL of the image , which is to be cropped. 
	 */
	public void cropImage(String imageURL,float aspectRatio) {
		crop = new GWTCropper(imageURL);
		crop.setAspectRatio(aspectRatio);
		cropImageWidgetFloPanel.add(crop);
	}
	
	/**
	 * @return height of cropped image
	 */
	public String getSelectionHeight() {
		return String.valueOf(crop.getSelectionHeight());
	}
	
	/**
	 * @return width of cropped image
	 */
	public String getSelectionWidth() {
		return String.valueOf(crop.getSelectionWidth());
	}
	
	/**
	 * @return x-coordinate of cropped image
	 */
	public String getSelectionXCoordinate() {
		return String.valueOf(crop.getSelectionXCoordinate());
	}
	/**
	 * @return y-coordinate of cropped image
	 */
	public String getSelectionYCoordinate() {
		return String.valueOf(crop.getSelectionYCoordinate());
	}

	/**
	 * Cancel crop event 
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("cancelButtonAnr")
	public void onClickCancelCrop(ClickEvent clickEvent) {
		onCancelCrop();
	}
	
	/**
	 * Back to upload page
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("backPageLinkLbl")
	public void onClickBackToUpload(ClickEvent clickEvent) {
		onBackToUpload();
	}
	
	/**
	 * Crop image 
	 * @param clickEvent instance of {@link ClickEvent}
	 */
	@UiHandler("cropImageBtn")
	public void onClickCrop(ClickEvent clickEvent) {
		buttonContainer.setVisible(false);
		loadingTextLbl.setVisible(true);
		onCrop();
	}

	public abstract void onCancelCrop();

	public abstract void onBackToUpload();
	
	public abstract void onCrop();
	
	public void addCanvasLoadHandler(LoadHandler handler) {
		crop.addCanvasLoadHandler(handler);
	}
	
}
