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
import org.ednovo.gooru.client.mvp.dnd.Draggable;
import org.ednovo.gooru.client.mvp.dnd.IsDraggable;
import org.ednovo.gooru.client.mvp.home.LoginPopupUc;
import org.ednovo.gooru.client.mvp.search.AbstractSearchView;
import org.ednovo.gooru.client.mvp.search.AddResourceContainerPresenter;
import org.ednovo.gooru.client.mvp.search.AnalyticsInfoContainer;
import org.ednovo.gooru.shared.model.folder.FolderDo;
import org.ednovo.gooru.shared.model.folder.FolderItemDo;
import org.ednovo.gooru.shared.model.search.ResourceSearchResultDo;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 * 
 */
public class ResourceSearchView extends AbstractSearchView<ResourceSearchResultDo> implements IsResourceSearchView {
	
	ResourceSearchResultVc resourceSearchResultVc; 

	/**
	 * Class constructor
	 */
	/**
	 * 
	 */
	public ResourceSearchView() {
		super(true);
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.search.AbstractSearchView#renderSearchResult(org.ednovo.gooru.shared.model.search.ResourceSearchResultDo)
	 */
	@Override
	public IsDraggable renderSearchResult(final ResourceSearchResultDo searchResultDo) {
		final ResourceSearchResultVc resourceSearchResultVc=new ResourceSearchResultVc(searchResultDo, dragController);
		setResourceSearchResultVc(resourceSearchResultVc);
		resourceSearchResultVc.setUpdateReviewCount(searchResultDo.getRatings().getReviewCount());
		resourceSearchResultVc.getRatingWidgetView().getRatingCountLabel().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(resourceSearchResultVc.getUpdateReviewCount()>0){
					getUiHandlers().showRatingAndReviewPopup(searchResultDo);
				}
			}
		});
		//		}


		resourceSearchResultVc.getAddButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(AppClientFactory.isAnonymous()){
					LoginPopupUc loginPopupUc=new LoginPopupUc();
				}else{
					getUiHandlers().showAddResourceToShelfView(resourceSearchResultVc.getAddResourceContainerPanel(),searchResultDo,"resource");
					getUiHandlers().showAndHideDisclosurePanelOnCLick(resourceSearchResultVc.getDisclosurePanelClose());
				}
			}
		});

		resourceSearchResultVc.getAnalyticsButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(AppClientFactory.isAnonymous()){
					LoginPopupUc loginPopupUc=new LoginPopupUc();
				}else{
					getUiHandlers().setAnalyticsTabData(resourceSearchResultVc.getAddResourceContainerPanel(),searchResultDo,"resource");
				}
			}
		});
		
		/**
		 * Giving click handler for tags tab in search result widget.
		 */
		resourceSearchResultVc.getAddTagsTab().addClickHandler(new ClickHandler() {
			
			/** (non-Javadoc)
			 * @see com.google.gwt.event.dom.client.ClickHandler#onClick(com.google.gwt.event.dom.client.ClickEvent)
			 */
			
			@Override
			public void onClick(ClickEvent event) {
				getUiHandlers().setTagsWidget(resourceSearchResultVc.getAddResourceContainerPanel(),searchResultDo,resourceSearchResultVc.isTagsPanelOpen(),resourceSearchResultVc.getAddTagsTab());
			}
		});
		
		return resourceSearchResultVc;
	}
	
	
/*	private class ShowRatingPopupEvent implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			
		}
	}*/

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.search.AbstractSearchView#refreshShelfCollections(java.util.List)
	 */
	@Override
	protected void refreshShelfCollections(List<FolderDo> shelfCollections) {
		
		for (Widget widget : getSearchResultPanel()) {
			if (widget instanceof Draggable && ((Draggable)widget).getDraggableUc() instanceof ResourceSearchResultVc) {
				ResourceSearchResultVc searchResultVc = (ResourceSearchResultVc) ((Draggable)widget).getDraggableUc();
				boolean added = false;
				for (FolderDo collection : shelfCollections) {
					if (collection.getType().equals("scollection")&&collection.getCollectionItems() != null) {
						for (FolderItemDo collectionItem : collection.getCollectionItems()) {
							if (collectionItem.getGooruOid().equals(searchResultVc.getResourceSearchResultDo().getGooruOid())) {
								searchResultVc.setAddedToShelf(true);
								added = true;
								break;
							}
						}
						if (added) {
							break;
						}
					}
				}
				if (!added) {
					searchResultVc.setAddedToShelf(false);
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.ednovo.gooru.client.mvp.search.AbstractSearchView#setAddResourceContainerPresenter(org.ednovo.gooru.client.mvp.search.AddResourceContainerPresenter)
	 */
	@Override
	public void setAddResourceContainerPresenter(AddResourceContainerPresenter addResourceContainerPresenter) {
//		if(resourceSearchResultVc!=null){
//			resourceSearchResultVc.getAddResourceContainerPanel().clear();
//			resourceSearchResultVc.getAddResourceContainerPanel().setWidget(addResourceContainerPresenter.getWidget());
//		}
	}


	/**
	 * @return the resourceSearchResultVc
	 */
	public ResourceSearchResultVc getResourceSearchResultVc() {
		return resourceSearchResultVc;
	}

	/**
	 * @param resourceSearchResultVc the resourceSearchResultVc to set
	 */
	public void setResourceSearchResultVc(
			ResourceSearchResultVc resourceSearchResultVc) {
		this.resourceSearchResultVc = resourceSearchResultVc;
	}

}
