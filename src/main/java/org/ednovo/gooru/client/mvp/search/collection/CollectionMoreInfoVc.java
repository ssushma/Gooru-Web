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
package org.ednovo.gooru.client.mvp.search.collection;

import java.util.List;

import org.apache.commons.digester.SetNextRule;
import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.resource.dnd.ResourceDragController;
import org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc;
import org.ednovo.gooru.client.mvp.search.SearchMoreInfoVc;
import org.ednovo.gooru.client.mvp.search.SimpleResourceVc;
import org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo;
import org.ednovo.gooru.shared.model.search.CollectionSearchResultDo;
import org.ednovo.gooru.shared.util.MessageProperties;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.dom.client.Style.Display;

/**
 * 
 * @fileName : CollectionMoreInfoVc.java
 *
 * @description : This file is to set Collection More Info.
 *
 *
 * @version : 1.0
 *
 * @date: 31-Dec-2013
 *
 * @Author : Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class CollectionMoreInfoVc extends SearchMoreInfoVc<CollectionSearchResultDo, CollectionItemSearchResultDo> implements MessageProperties {
	
	private static final String NO_RESOURCES_IN_THIS_COLLECTION = "There are no resources in this collection.";
	
	private static final String RESOURCES_IN_THIS_COLLECTION= "Resources in this Collection";

	private String collectionId;
	/**
	 * Class constructor
	 * @param searchDragController instance of {@link ResourceDragController}
	 */
	public CollectionMoreInfoVc(ResourceDragController searchDragController,String collectionId) {
		super(searchDragController,false);
		this.collectionId=collectionId;
		getRightsField().setVisible(false);
		getLikesField().setVisible(false);
	}
	/**
	 * To render UsedInResources.
	 */
	@Override
	public void renderUsedInResource(CollectionItemSearchResultDo usedInResource) {
			getUsedInResourcesPanel().addDraggable(new SimpleResourceVc(usedInResource, getUsedInResourcesPanel().getWidgetCount() + 1));
	}
	/**
	 * To set used in resources.
	 */
	@Override
	public void setUsedInResources(List<CollectionItemSearchResultDo> usedInResources) {
		gradeFieldVc = new MoreInfoFieldVc();
		if (usedInResources.size() == 0) {
			getMessageInfo().setMessage(NO_RESOURCES_IN_THIS_COLLECTION, GL0091);
			getMessageInfo().getElement().getStyle().setDisplay(Display.BLOCK); 
		} else {
			setResourceCountTxt(RESOURCES_IN_THIS_COLLECTION);
			setResourceCount("(" + getUsedInSearchDo().getCollectionItemsCount()+ ")");
		}
		int notMobileFriendly = 0;
		
		for (int j=0; j<getUsedInSearchDo().getCollectionItemsCount()-1; j++){
			
			String mediaType = getUsedInSearchDo().getSearchResults().get(j).getMediaType();
			boolean notFriendly = mediaType !=null ?  mediaType.equalsIgnoreCase("not_iPad_friendly") ? true : false : false;
			if (notFriendly){
				notMobileFriendly++;
			}
		}
		if (AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equalsIgnoreCase(PlaceTokens.COLLECTION_SEARCH)){
			showNotFriendly(notMobileFriendly>0 ? true : false);
			setNotFriendly(StringUtil.generateMessage("("+MessageProperties.GL0449+")", String.valueOf(notMobileFriendly), notMobileFriendly>1 ? MessageProperties.GL_GRR_ARE : MessageProperties.GL_GRR_IS));
		}else{
			showNotFriendly(false);
		}
		super.setUsedInResources(usedInResources);

	}
	/**
	 * To get collection items.
	 */
	@Override
	public void requestUsedInResources() {
		//AppClientFactory.getInjector().getSearchService().getCollectionResources(getUsedInSearchDo(), getUsedInResourcesAsyncCallback());
		AppClientFactory.getInjector().getSearchService().getCollectionItems(collectionId, getUsedInResourcesAsyncCallback());
	}

}
