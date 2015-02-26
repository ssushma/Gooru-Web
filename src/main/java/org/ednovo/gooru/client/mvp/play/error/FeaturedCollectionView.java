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
package org.ednovo.gooru.client.mvp.play.error;



import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
/**
* @fileName : FeaturedCollectionView.java
*
* @description : To display all featured collection widget is created.
* 
* @version : 1.0
*
* @date:  December, 2013.
*
* @Author: Gooru Team.
* 
* @Reviewer: Gooru Team.
*/
public class FeaturedCollectionView extends Composite{
	
	//@UiTemplate("AddResourceToCollection.ui.xml")
	public interface FeaturedCollectionViewUiBinder extends UiBinder<Widget,FeaturedCollectionView>{

	}
	public static FeaturedCollectionViewUiBinder featuredCollectionViewUiBinder=GWT.create(FeaturedCollectionViewUiBinder.class);
	Image featureCollectionImage =new Image();
	@UiField HTMLPanel featureCollectionTitle;
	@UiField Anchor imageAnchor;
	private String imageUrl="";
	public static final int INDEX_NOT_FOUND = -1;
    public static final String EMPTY = "";

    /**
     * Class constructor.
     * 
     * @param title {@link String}
     * @param imageUrl {@link String}
     * @param featuredCollectionId {@link String}
     */
	public FeaturedCollectionView(String title,String imageUrl,String featuredCollectionId){
		initWidget(featuredCollectionViewUiBinder.createAndBindUi(this));
		this.imageUrl=imageUrl;
		if(!StringUtil.isEmpty(title)){
			featureCollectionTitle.add(getHTML(title));
		}
		if(!StringUtil.isEmpty(featuredCollectionId)){
			imageAnchor.setHref("#collection-play&id="+featuredCollectionId);
		}
		imageAnchor.getElement().appendChild(featureCollectionImage.getElement());
		featureCollectionImage.addErrorHandler(new ErrorHandler() {
			@Override
			public void onError(ErrorEvent event) {

			}
		});
	}
	
	/**
	 * Generates HTML.
	 * 
	 * @param html {@link String}
	 * @return contentHtml {@link HTML}
	 */
	private HTML getHTML(String html){
		HTML contentHtml=new HTML(html);
		contentHtml.setStyleName("");
		return contentHtml;
	}
	
	/**
	 * On load sets all the featured collection thumnail images.
	 */
	@Override
	public void onLoad(){
		super.onLoad();
		featureCollectionImage.setUrl(formThumbnailName(imageUrl,"-160x120."));
		imageAnchor.getElement().setId("lnkImageAnchor");
		featureCollectionTitle.getElement().setId("pnlFeatureCollectionTitle");
	}
	/**
	 * Manipulates the given string.
	 * 
	 * @param str {@link String}
	 * @param separator {@link String}
	 * @return
	 */
	public static String substringBeforeLast(String str, String separator) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(separator)) {
            return str;
        }
        int pos = str.lastIndexOf(separator);
        if (pos == INDEX_NOT_FOUND) {
            return str;
        }
        return str.substring(0, pos);
    }
	
	/**
	 * Manipulates the given string.
	 * 
	 * @param str {@link String}
	 * @param separator {@link String}
	 * @return
	 */
	public static String substringAfterLast(String str, String separator) {
        if (StringUtil.isEmpty(str)) {
            return str;
        }
        if (StringUtil.isEmpty(separator)) {
            return EMPTY;
        }
        int pos = str.lastIndexOf(separator);
        if (pos == INDEX_NOT_FOUND || pos == (str.length() - separator.length())) {
            return EMPTY;
        }
        return str.substring(pos + separator.length());
    }
	
	/**
	 * Gets the thumbnail fime name.
	 * 
	 * @param thumbnailName {@link String}
	 * @param thumbnailSuffix {@link String}
	 * @return
	 */
	public static String formThumbnailName(String thumbnailName, String thumbnailSuffix){
		String  thumbnailFilename = null;
    	if (thumbnailName != null) {
			String  fileExtension = substringAfterLast(thumbnailName, ".");
			if (fileExtension != null) { 
				thumbnailFilename = substringBeforeLast(thumbnailName, "." + fileExtension) + thumbnailSuffix + fileExtension;
			}
		}
		return thumbnailFilename;
	}
}
