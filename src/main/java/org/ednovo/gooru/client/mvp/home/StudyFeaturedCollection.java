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
package org.ednovo.gooru.client.mvp.home;

import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 *
 */
public class StudyFeaturedCollection extends Composite{

	@UiField
	FlowPanel contentImageFloPanel;
	
	@UiField
	Image contentUrlImg;
	
	@UiField
	FlowPanel featuredStartStudyFloPanel;
	
	@UiField
	Label studyFeaturedCollectionButton;
	
	private static StudyFeaturedCollectionUiBinder uiBinder = GWT
			.create(StudyFeaturedCollectionUiBinder.class);

	interface StudyFeaturedCollectionUiBinder extends
			UiBinder<Widget, StudyFeaturedCollection> {
	}
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);


	/**
	 * Class constructor
	 */
	public StudyFeaturedCollection() {
		initWidget(uiBinder.createAndBindUi(this));
		featuredStartStudyFloPanel.setVisible(false);
		studyFeaturedCollectionButton.setText(i18n.GL0182());
		studyFeaturedCollectionButton.getElement().setId("lblStudyFeaturedCollectionButton");
		studyFeaturedCollectionButton.getElement().setAttribute("alt",i18n.GL0182());
		studyFeaturedCollectionButton.getElement().setAttribute("title",i18n.GL0182());
		
		contentImageFloPanel.getElement().setId("fpnlContentImageFloPanel");
		contentUrlImg.getElement().setId("imgContentUrl");
		featuredStartStudyFloPanel.getElement().setId("fpnlFeaturedStartStudyFloPanel");
	}

	/**
	 * Set featured collection image
	 * @param url collection image url
	 */
	public void setFeaturedCollectionImageUrl(String url){
		contentUrlImg.setUrl(StringUtil.formThumbnailName(url, "-280x215."));
	}

	public Image getContentUrlImg() {
		return contentUrlImg;
	}
	
}
