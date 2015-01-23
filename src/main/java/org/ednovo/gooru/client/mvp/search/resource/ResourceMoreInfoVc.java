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
package org.ednovo.gooru.client.mvp.search.resource;

import java.util.List;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.resource.dnd.ResourceDragController;
import org.ednovo.gooru.client.mvp.search.MoreInfoFieldVc;
import org.ednovo.gooru.client.mvp.search.SearchMoreInfoVc;
import org.ednovo.gooru.client.mvp.search.SimpleCollectionVc;
import org.ednovo.gooru.client.uc.BrowserAgent;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.search.CollectionSearchResultDo;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;

import com.google.gwt.core.client.GWT;

/**
 * @author Search Team
 * 
 */
public class ResourceMoreInfoVc extends SearchMoreInfoVc<ResourceSearchResultDo, CollectionSearchResultDo> {
	
	
	private static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	private static final String RESOURCE_NOT_IN_COLLECTION = i18n.GL1469()+" ";
	
//	private static final String COLLECTIONS_THAT_USE_THIS_RESOURCE = "This resource is used in";
	private static final String COLLECTIONS_THAT_USE_THIS_RESOURCE = i18n.GL1470();
	/**
	 * Class constructor
	 * @param searchDragController instance of {@link ResourceDragController}
	 */
	public ResourceMoreInfoVc(ResourceDragController searchDragController) {
		super(searchDragController,false);
	}

	@Override
	public void renderUsedInResource(CollectionSearchResultDo childResource) {
		boolean device = BrowserAgent.isDevice();
		if (device){
			getUsedInResourcesPanel().add(new SimpleCollectionVc(childResource));
		}else{
			getUsedInResourcesPanel().addDraggable(new SimpleCollectionVc(childResource));
		}
	}

	@Override
	public void setUsedInResources(List<CollectionSearchResultDo> childResources) {
		resourceSearchRightsFieldVc = new MoreInfoFieldVc();
		
		if (childResources.size() == 0) {
			resourceSearchRightsFieldVc.setVisible(false);
			rightsLbl.setVisible(false);
			resourceSearchGradeFieldVc.setVisible(false);
			getMessageInfo().setVisible(true);
			getMessageInfo().setMessage(RESOURCE_NOT_IN_COLLECTION, i18n.GL0093());
		} else {
			
				setResourceCountTxt(COLLECTIONS_THAT_USE_THIS_RESOURCE);
//				setResourceCount("(" + getUsedInSearchDo().getSearchHits() + ")" + " collections. Here are the top 5:");
		}
		
		showNotFriendly( false);
		
		super.setUsedInResources(childResources);
	}

	@Override
	public void requestUsedInResources() {
		try {
			getUsedInSearchDo().getSearchQuery().equalsIgnoreCase(null);
		} catch (NullPointerException npe) {
			getUsedInSearchDo().setQuery("");
		}
		AppClientFactory.getInjector().getSearchService().getResourceCollections(getUsedInSearchDo(), getUsedInResourcesAsyncCallback());
	}

}
