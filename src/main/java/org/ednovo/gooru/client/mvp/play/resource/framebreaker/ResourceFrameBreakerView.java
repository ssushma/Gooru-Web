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
package org.ednovo.gooru.client.mvp.play.resource.framebreaker;

import org.ednovo.gooru.client.uc.PlayerBundle;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ResourceFrameBreakerView extends Composite{
	
	
	@UiField Image resourceThumbnail;
	@UiField Label resourceCatrgoryIcon,resourceAttribution;
	@UiField HTMLPanel resourceTitle;
	@UiField Anchor resourceUrl;
	
	private String resourceThumbnailUrl="";
	private String resourceType="";
	
	private static ResourceFrameBreakerViewUiBinder uiBinder = GWT.create(ResourceFrameBreakerViewUiBinder.class);

	interface ResourceFrameBreakerViewUiBinder extends UiBinder<Widget, ResourceFrameBreakerView> {
	}
	
	public ResourceFrameBreakerView(){
		initWidget(uiBinder.createAndBindUi(this));
	}
	@UiConstructor
	public ResourceFrameBreakerView(CollectionItemDo collectionItemDo){
		initWidget(uiBinder.createAndBindUi(this));
		PlayerBundle.INSTANCE.getPlayerStyle().ensureInjected();
		setResourceTitle(collectionItemDo.getResource().getTitle());
		setResourceAttrubution(collectionItemDo.getResource().getResourceSource().getAttribution());
		setResourceUrl(collectionItemDo.getResource().getUrl());
		setResourceThumbnail(collectionItemDo.getResource().getThumbnails().getUrl(), collectionItemDo.getResource().getCategory());
	}
	
	@UiHandler("resourceThumbnail")
	public void setResourceDefaultImage(ErrorEvent event){
		resourceThumbnail.setUrl("images/resource_trans.png");
		resourceThumbnail.setStyleName(getResourceDefaultImage(resourceType));
		resourceCatrgoryIcon.setStyleName(getResourceTypeImage(resourceType));
		resourceCatrgoryIcon.addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().resourceTypeImage());
	}
	
	public void setResourceTitle(String title){
		HTML html=new HTML(title);
		html.setStyleName("");
		resourceTitle.clear();
		resourceTitle.add(html);
	}
	public void setResourceAttrubution(String resourceAttributionText){
		if(resourceAttributionText!=null&&!resourceAttributionText.equals("")&&!resourceAttributionText.equalsIgnoreCase("null")){
			resourceAttribution.setText(resourceAttributionText);
		}
	}
	
	public void setResourceUrl(String url){
		resourceUrl.setHref(url);
		resourceUrl.setTarget("_blank");
	}
	
	public void setResourceThumbnail(String url,String resourceCategory){
		this.resourceThumbnailUrl=url;
		this.resourceType=resourceCategory;
	}
	
	public void onLoad(){
		super.onLoad();
		resourceThumbnail.setUrl(resourceThumbnailUrl);
		resourceThumbnail.setStyleName("");
		resourceCatrgoryIcon.setStyleName(getResourceTypeImage(resourceType));
		resourceCatrgoryIcon.addStyleName(PlayerBundle.INSTANCE.getPlayerStyle().resourceTypeImage());
		
	}
	
	public String getResourceTypeImage(String resourceType){
		if(resourceType.equalsIgnoreCase("Video")){
			return PlayerBundle.INSTANCE.getPlayerStyle().videoResourceType();
		}else if(resourceType.equalsIgnoreCase("Interactive")){
			return PlayerBundle.INSTANCE.getPlayerStyle().interactiveResourceType();
		}
		else if(resourceType.equalsIgnoreCase("Website")){
			return PlayerBundle.INSTANCE.getPlayerStyle().websiteResourceType();		
		}
		else if(resourceType.equalsIgnoreCase("Slide")){
			return PlayerBundle.INSTANCE.getPlayerStyle().slideResourceType();
		}
		else if(resourceType.equalsIgnoreCase("Textbook")){
			return PlayerBundle.INSTANCE.getPlayerStyle().textbookResourceType();
		}
		else if(resourceType.equalsIgnoreCase("Question")){
			return PlayerBundle.INSTANCE.getPlayerStyle().questionResourceType();
		}
		else if(resourceType.equalsIgnoreCase("lesson")){
			return PlayerBundle.INSTANCE.getPlayerStyle().lessonResourceType();
		}else if(resourceType.equalsIgnoreCase("Handout")){
			return PlayerBundle.INSTANCE.getPlayerStyle().handoutResourceType();
		}else {
			return PlayerBundle.INSTANCE.getPlayerStyle().examResourceType();
		}
	}
	
	public String getResourceDefaultImage(String resourceType){
		if(resourceType.equalsIgnoreCase("Video")){
			return PlayerBundle.INSTANCE.getPlayerStyle().videoResourceDefault();
		}else if(resourceType.equalsIgnoreCase("Interactive")){
			return PlayerBundle.INSTANCE.getPlayerStyle().interactiveResourceDefault();
		}
		else if(resourceType.equalsIgnoreCase("Website")){
			return PlayerBundle.INSTANCE.getPlayerStyle().websiteResourceDefault();		
		}
		else if(resourceType.equalsIgnoreCase("Slide")){
			return PlayerBundle.INSTANCE.getPlayerStyle().slideResourceDefault();
		}
		else if(resourceType.equalsIgnoreCase("Textbook")){
			return PlayerBundle.INSTANCE.getPlayerStyle().textbookResourceDefault();
		}
		else if(resourceType.equalsIgnoreCase("Question")){
			return PlayerBundle.INSTANCE.getPlayerStyle().questionResourceDefault();
		}
		else if(resourceType.equalsIgnoreCase("lesson")){
			return PlayerBundle.INSTANCE.getPlayerStyle().lessonResourceDefault();
		}else if(resourceType.equalsIgnoreCase("Handout")){
			return PlayerBundle.INSTANCE.getPlayerStyle().handoutResourceDefault();
		}else {
			return PlayerBundle.INSTANCE.getPlayerStyle().examResourceDefault();
		}
	}
	
}
