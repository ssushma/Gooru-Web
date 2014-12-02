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
package org.ednovo.gooru.client.mvp.profilepage.tab.content.tags;

import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.shared.model.user.UserTagsDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ProfileUserTagWidget extends Composite {

	private static ProfileUserTagWidgetUiBinder uiBinder = GWT
			.create(ProfileUserTagWidgetUiBinder.class);

	interface ProfileUserTagWidgetUiBinder extends
			UiBinder<Widget, ProfileUserTagWidget> {
	}
	@UiField
	Label tagTitle;
	@UiField
	Label tagcount;
	@UiField
	HTMLEventPanel mainContainer;
	HTMLPanel followingContainer; HTMLPanel tagResourceContainer;		
	@UiField HTMLPanel tagRightPanel;
	
	UserTagsDo userTagDo =new UserTagsDo();
	String titleLabelName;
	public ProfileUserTagWidget(){
		initWidget(uiBinder.createAndBindUi(this));
		
	}
	public ProfileUserTagWidget(UserTagsDo userTagDo,HTMLPanel followingContainer, HTMLPanel tagResourceContainer) {
		this.userTagDo = userTagDo;
		initWidget(uiBinder.createAndBindUi(this));
		this.followingContainer = followingContainer;
		this.tagResourceContainer = tagResourceContainer;
		setData(userTagDo);
	}
	
	
	/**
	 * Class constructor, calls from TagsTabView class.
	 * 
	 * @param resourceTagsDo {@link UserTagsDo}
	 */
	public ProfileUserTagWidget(UserTagsDo resourceTagsDo) {
		initWidget(uiBinder.createAndBindUi(this));
		setResourceTags(resourceTagsDo);
	}
	public void setData(UserTagsDo userTagDo){
		String titleLabel=userTagDo.getLabel();
		titleLabelName=userTagDo.getLabel();
		mainContainer.setTitle(titleLabel);
		mainContainer.getElement().setAttribute("alt", titleLabel);
		/*if(titleLabel.length()>=12){
			titleLabel = titleLabel.substring(0, 12) + "...";
		}*/
		tagTitle.setText(titleLabel);
		tagTitle.getElement().setId("lblTagTitle");
		tagTitle.getElement().setAttribute("alt",titleLabel);
		tagTitle.getElement().setAttribute("title",titleLabel);
		
		tagcount.setText(userTagDo.getCount());
		tagcount.getElement().setId("lblTagcount");
		tagcount.getElement().setAttribute("alt",userTagDo.getCount());
		tagcount.getElement().setAttribute("title",userTagDo.getCount());
		
		mainContainer.getElement().setId(userTagDo.getTagGooruOid());
		
		
		
	}
	@UiHandler("mainContainer")
	public void onclick(ClickEvent event)
	{
		tagResourceContainer.clear();
		ProfileUserTagsResourceView ProfileUserTagsResourceView=new ProfileUserTagsResourceView(mainContainer.getElement().getId(),titleLabelName,tagcount.getText(),followingContainer,tagResourceContainer);
		tagResourceContainer.add(ProfileUserTagsResourceView);
		followingContainer.setVisible(false);
		tagResourceContainer.setVisible(true);
	}
	
	
	/**
	 * Sets the tags at search results tags tab.
	 * 
	 * @param resourceTagsDo {@link UserTagsDo}
	 */
	public void setResourceTags(UserTagsDo resourceTagsDo) {
		
		String titleLabel=resourceTagsDo.getLabel();
		titleLabelName=resourceTagsDo.getLabel();
		tagTitle.setText(titleLabel);
		tagTitle.getElement().setId("lblTagTitle");
		tagTitle.getElement().setAttribute("alt",titleLabel);
		tagTitle.getElement().setAttribute("title",titleLabel);
		
		tagcount.setText(resourceTagsDo.getCount());
		tagcount.getElement().setId("lblTagcount");
		tagcount.getElement().setAttribute("alt",resourceTagsDo.getCount());
		tagcount.getElement().setAttribute("title",resourceTagsDo.getCount());
	}
	
	
	/**
	 * Overrides the default style with search tags style
	 * 
	 * @param styleName {@link String}
	 */
	public void setSearchTagsBgStyleName(String styleName){
		mainContainer.setStyleName(styleName);
	}
	
	
	/**
	 * Overrides the default style with search tags style
	 * 
	 * @param styleName {@link String}
	 */
	public void setSearchTabTagRightStyleName(String styleName){
		tagRightPanel.setStyleName(styleName);
	}
	
	
	/**
	 * Overrides the default style with search tags style
	 * 
	 * @param styleName {@link String}
	 */
	public void setSearchTabTagLblStyleName(String styleName){
		tagcount.setStyleName(styleName);
		tagTitle.setStyleName(styleName);
	}
	
	
	
	
}
