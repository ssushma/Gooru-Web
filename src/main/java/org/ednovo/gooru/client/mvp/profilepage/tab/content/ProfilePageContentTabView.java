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
package org.ednovo.gooru.client.mvp.profilepage.tab.content;

import java.util.Iterator;
import java.util.List;

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.profilepage.tab.content.item.ProfilePageItemChildView;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 * 
 */
public class ProfilePageContentTabView extends BaseViewWithHandlers<ProfilePageContentTabUiHandlers> implements IsProfilePageContentTabView {

	@UiField 
	SimplePanel shelfTabSimPanel;

	@UiField
	HTMLPanel publicPPRightContainer;
	
	final private String WORKSPACE_FOLDER = "folder";
	
	final private String WORKSPACE_COLLECTION = "scollection";
	
	private static ProfilePageContentTabViewUiBinder uiBinder = GWT.create(ProfilePageContentTabViewUiBinder.class);

	interface ProfilePageContentTabViewUiBinder extends UiBinder<Widget, ProfilePageContentTabView> {
	}

	/**
	 * Class constructor
	 */
	public ProfilePageContentTabView() {
		setWidget(uiBinder.createAndBindUi(this));
		shelfTabSimPanel.getElement().setId("spnlShelfTabSimPanel");
		publicPPRightContainer.getElement().setId("pnlPublicPPRightContainer");
	}

	@Override
	public void reset() {
		super.reset();
	}

	@Override
	public void setInSlot(Object slot, Widget content) {
		if (content != null) {
			if (slot == ProfilePageContentTabUiHandlers.TYPE_PUBLIC_SHELF_VIEW) {
				shelfTabSimPanel.setWidget(content);
			}
		}
	}
	
	@Override
	public void setContentItemData(List<CollectionItemDo> collectionItemDo) {
		Iterator<CollectionItemDo> iterator = collectionItemDo.iterator();
		while (iterator.hasNext()) {
			CollectionItemDo collectionItem = iterator.next();
			if(collectionItem.getResource().getResourceType().getName().equalsIgnoreCase(WORKSPACE_FOLDER)) {
				publicPPRightContainer.add(new ProfilePageItemChildView(collectionItem));
			} else if(collectionItem.getResource().getResourceType().getName().equalsIgnoreCase(WORKSPACE_COLLECTION)){
				publicPPRightContainer.add(new ProfilePageItemChildView(collectionItem));
			}
		}
	}
	
	@Override
	public void clearContentItemData() {
		publicPPRightContainer.clear();
	}

	@Override
	public void setMetaData(CollectionItemDo collectionItemDo) {
		publicPPRightContainer.add(new ProfilePageCollectionMetaData(collectionItemDo));
	}

}
