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

import java.util.List;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.shared.model.user.UserTagsResourceDO;
import org.ednovo.gooru.shared.util.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

public class ProfileUserTagsResourceView extends Composite implements MessageProperties {

	private static ProfileUserTagsResourceViewUiBinder uiBinder = GWT
			.create(ProfileUserTagsResourceViewUiBinder.class);

	interface ProfileUserTagsResourceViewUiBinder extends
			UiBinder<Widget, ProfileUserTagsResourceView> {
	}
	@UiField HTMLPanel userTagsResourceContainerConatiner,tagContainer;
	@UiField Label TagTextMessage,tagType,tagCount;
	@UiField
	Label tagMessage;
	@UiField ScrollPanel tagScrollPanel;
	String tagId;
	String labelName;
	String count;
	HTMLPanel followingContainer; 
	HTMLPanel tagResourceContainer;
	
	String limit = "10";
	int totalResourceCount = 0;
	int totalHintCount=0;
	
	public ProfileUserTagsResourceView(String tagId,String labelName,String count,HTMLPanel followingContainer, HTMLPanel tagResourceContainer) {
		initWidget(uiBinder.createAndBindUi(this));
		this.tagId = tagId;
		this.labelName = labelName;
		this.count = count;
		this.followingContainer=followingContainer;
		this.tagResourceContainer=tagResourceContainer;
		tagContainer.setVisible(false);
		userTagsResourceContainerConatiner.clear();
		getData(tagId);
		
		
		
	}
	
	public void getData(String tagGooruOid)
	{
		String profileUserUserId=AppClientFactory.getPlaceManager().getRequestParameter("id", null);
		AppClientFactory.getInjector().getUserService().getResourcesByTag(tagGooruOid,Integer.toString(totalResourceCount),limit,profileUserUserId, new SimpleAsyncCallback<List<UserTagsResourceDO>>() {
			
			@Override
			public void onSuccess(List<UserTagsResourceDO> result) {
				
				setData(result);
				totalResourceCount=0;
				totalResourceCount=totalResourceCount+result.size();
				totalHintCount=result.get(0).getTotalHintCount();
			}			
		});
	}
	public void setData(List<UserTagsResourceDO> result){
		
		tagContainer.setVisible(true);
		TagTextMessage.setText(GL1915);
		tagMessage.setText(GL1944);
		tagContainer.getElement().setAttribute("alt", labelName);
		tagContainer.setTitle(labelName);
		
		/*if(labelName.length()>=12){
			labelName = labelName.substring(0, 12) + "...";
		}*/
		tagType.setText(labelName);
		tagCount.setText(count);
		userTagsResourceContainerConatiner.clear();
		for(int i=0;i<result.size();i++){
			ProfileUserTagsResourceWidget profileUserTagsResourceWidget=new ProfileUserTagsResourceWidget(result.get(i));
			userTagsResourceContainerConatiner.add(profileUserTagsResourceWidget);
		}
			
		
	}
	@UiHandler("tagMessage")
	public void onclickOnBackButton(ClickEvent event){
		tagResourceContainer.setVisible(false);
		followingContainer.setVisible(true);
	}
	@UiHandler("tagScrollPanel")
	public void dragFollowingScrollPanel(ScrollEvent event) {
		if (tagScrollPanel.getVerticalScrollPosition() == tagScrollPanel.getMaximumVerticalScrollPosition() && totalResourceCount <totalHintCount) {
			String profileUserUserId=AppClientFactory.getPlaceManager().getRequestParameter("id", null);
		AppClientFactory.getInjector().getUserService().getResourcesByTag(tagId,Integer.toString(totalResourceCount),limit,profileUserUserId, new AsyncCallback<List<UserTagsResourceDO>>() {
			
			@Override
			public void onSuccess(List<UserTagsResourceDO> result) {
				
				if(result.size()>0){
					totalResourceCount = totalResourceCount+result.size();
			
				for(int i=0;i<result.size();i++){
					ProfileUserTagsResourceWidget profileUserTagsResourceWidget=new ProfileUserTagsResourceWidget(result.get(i));
					userTagsResourceContainerConatiner.add(profileUserTagsResourceWidget);
				}
				
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	}
}
