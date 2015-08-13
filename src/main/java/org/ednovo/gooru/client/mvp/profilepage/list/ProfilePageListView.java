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
package org.ednovo.gooru.client.mvp.profilepage.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.client.mvp.shelf.ShelfCBundle;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Gooru Team
 * 
 */
public class ProfilePageListView extends BaseViewWithHandlers<ProfilePageListUiHandlers> implements IsProfilePageListView {

	private static ProfilePageListViewUiBinder uiBinder = GWT
			.create(ProfilePageListViewUiBinder.class);

	interface ProfilePageListViewUiBinder extends UiBinder<Widget, ProfilePageListView> {}

	@UiField
	VerticalPanel myShelfVerPanel;
	
	@UiField(provided = true)
	ShelfListCBundle res;

	@UiField
	static ScrollPanel collectionListScrollpanel;

	private ProfilePageCollection selectedProfilePageCollection = null;
	
	private ProfilePageCollectionFolder selectedProfilePageCollectionFolder = null;
	
	private ProfilePageCollectionFolderChild selectedProfilePageCollectionFolderChild = null;
	
	private ProfilePageCollectionChild selectedProfilePageCollectionChild = null;

	private static final List<CollectionItemDo> SHELF_COLLECTIONS = new ArrayList<CollectionItemDo>();

	int collectionItemDoSize;
	
	private final String PROFILE_LEVEL_ONE = "1";
	
	private final String PROFILE_LEVEL_TWO = "2";

	private final String PROFILE_LEVEL_THREE = "3";
	
	private final String PROFILE_LEVEL_FOUR = "4";	

	Label noCollectionMsgPanel=new Label() ;

	/**
	 * Class constructor
	 */
	public ProfilePageListView() {
		res = ShelfListCBundle.INSTANCE;
		res.css().ensureInjected();
		ShelfCBundle.INSTANCE.css().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));
		collectionListScrollpanel.getElement().setId("sbCollectionListScrollpanel");
		myShelfVerPanel.getElement().setId("vpnlMyShelfVerPanel");
	}

	@Override
	public void reset() {
		super.reset();
		selectedProfilePageCollection=null;
		SHELF_COLLECTIONS.clear();
		myShelfVerPanel.clear();
	}

	@Override
	public void setUserShelfData(List<CollectionItemDo> collectionItems,
			boolean clearShelfPanel) {
		SHELF_COLLECTIONS.clear();
		SHELF_COLLECTIONS.addAll(collectionItems);
		collectionItemDoSize = collectionItems.size();
		if(collectionItemDoSize==0)
		{
			noCollectionMsgPanel.setStyleName(ShelfCBundle.INSTANCE.css().noCollectionMessageRight());
			noCollectionMsgPanel.getElement().getStyle().setHeight(300, Unit.PX);
			noCollectionMsgPanel.getElement().getStyle().setWidth(200, Unit.PX);
			myShelfVerPanel.add(noCollectionMsgPanel);
			myShelfVerPanel.getParent().getParent().getElement().getStyle().setBorderWidth(0, Unit.PX);
		}
		
		if (clearShelfPanel) {
			myShelfVerPanel.clear();
		}
		for (CollectionItemDo collectionItemDo : collectionItems) {
			myShelfVerPanel.add(new ProfilePageCollection(collectionItemDo));
		}
	}

	@Override
	public void onLoad() {
		super.onLoad();
	}

	@Override
	public void onUnload() {
		super.onUnload();
	}

	@Override
	public void refreshProfileList(String collectionId, String folderLevel) {
		try {
			if(folderLevel.equalsIgnoreCase(PROFILE_LEVEL_ONE) ) {
					if(selectedProfilePageCollection!=null) {
						String previousCollectionId = selectedProfilePageCollection.getCollectionItemDo().getResource().getGooruOid();
						if(!previousCollectionId.equalsIgnoreCase(collectionId)) {
							if(selectedProfilePageCollection.getCollectionItemDo().getResource().getResourceType().getName().equalsIgnoreCase("folder")) {
								selectedProfilePageCollection.getContentVerPanel().clear();
							}
							selectedProfilePageCollection.setOpenFolderStyle(false);
						}
					}
					ProfilePageCollection profilePageCollection = getProfilePageCollection(collectionId);
					selectedProfilePageCollection = profilePageCollection;
					if(selectedProfilePageCollection.getCollectionItemDo().getResource().getResourceType().getName().equalsIgnoreCase("folder")) {
						selectedProfilePageCollection.setInnerFolderContent();
					}
					selectedProfilePageCollection.setOpenFolderStyle(true);
			} else if(folderLevel.equalsIgnoreCase(PROFILE_LEVEL_TWO)) {
					if(selectedProfilePageCollectionFolder!=null) {
						String previousCollectionId = selectedProfilePageCollectionFolder.getCollectionItemDo().getResource().getGooruOid();
						if(!previousCollectionId.equalsIgnoreCase(collectionId)) {
							selectedProfilePageCollectionFolder.setOpenFolderStyle(false);
							if(selectedProfilePageCollectionFolder.getCollectionItemDo().getResource().getResourceType().getName().equalsIgnoreCase("folder")) {
								selectedProfilePageCollectionFolder.getContentVerPanel().clear();
							}
						}
					} 
					ProfilePageCollectionFolder profilePageCollectionFolder = getProfilePageCollectionFolder(collectionId,selectedProfilePageCollection.getContentVerPanel());
					selectedProfilePageCollectionFolder = profilePageCollectionFolder;
					if(selectedProfilePageCollectionFolder.getCollectionItemDo().getResource().getResourceType().getName().equalsIgnoreCase("folder")) {
						selectedProfilePageCollectionFolder.setInnerFolderContent();
					}
					selectedProfilePageCollectionFolder.setOpenFolderStyle(true);
			} else if(folderLevel.equalsIgnoreCase(PROFILE_LEVEL_THREE)) {
					if(selectedProfilePageCollectionFolderChild!=null) {
						String previousCollectionId = selectedProfilePageCollectionFolderChild.getCollectionItemDo().getResource().getGooruOid();
						if(!previousCollectionId.equalsIgnoreCase(collectionId)) {
							selectedProfilePageCollectionFolderChild.setOpenFolderStyle(false);
							if(selectedProfilePageCollectionFolderChild.getCollectionItemDo().getResource().getResourceType().getName().equalsIgnoreCase("folder")) {
								selectedProfilePageCollectionFolderChild.getContentVerPanel().clear();
							}
						}
					} 
					ProfilePageCollectionFolderChild profilePageCollectionFolderChild = getProfilePageCollectionFolderChild(collectionId);
					selectedProfilePageCollectionFolderChild = profilePageCollectionFolderChild;
					if(selectedProfilePageCollectionFolderChild.getCollectionItemDo().getResource().getResourceType().getName().equalsIgnoreCase("folder")) {
						selectedProfilePageCollectionFolderChild.setInnerFolderContent();
					}
					selectedProfilePageCollectionFolderChild.setOpenFolderStyle(true);
			} else if(folderLevel.equalsIgnoreCase(PROFILE_LEVEL_FOUR))  {
				if(selectedProfilePageCollectionChild!=null) {
					String previousCollectionId = selectedProfilePageCollectionChild.getCollectionItemDo().getResource().getGooruOid();
					if(!previousCollectionId.equalsIgnoreCase(collectionId)) {
						selectedProfilePageCollectionChild.setOpenFolderStyle(false);
					}
				} 
				ProfilePageCollectionChild profilePageCollectionChild = getProfilePageCollectionChild(collectionId);
				selectedProfilePageCollectionChild = profilePageCollectionChild;
				selectedProfilePageCollectionChild.setOpenFolderStyle(true);
			}
		} catch (Exception e) {
			AppClientFactory.printSevereLogger("ProfilePageListView refreshProfileList:::"+e);
		}
	}
	
	private ProfilePageCollection getProfilePageCollection(String collectionId) {
		Iterator<Widget> widgets = myShelfVerPanel.iterator();
		while (widgets.hasNext()) {
			Widget widget = widgets.next();
			if (widget instanceof ProfilePageCollection
					&& ((ProfilePageCollection) widget).getCollectionItemDo()
					.getResource().getGooruOid().equals(collectionId)) {
				return (ProfilePageCollection) widget;
			}
		}
		return null;
	}

	private ProfilePageCollectionFolder getProfilePageCollectionFolder(String collectionId, VerticalPanel selectedProfilePageCollection) { 
		Iterator<Widget> widgets = selectedProfilePageCollection.iterator();
		while (widgets.hasNext()) {
			Widget widget = widgets.next();
			if (widget instanceof ProfilePageCollectionFolder	&& ((ProfilePageCollectionFolder) widget).getCollectionItemDo().getResource().getGooruOid().equals(collectionId)) {
				return (ProfilePageCollectionFolder) widget;
			}
		}
		return null;
	}

	private ProfilePageCollectionFolderChild getProfilePageCollectionFolderChild(String collectionId) {
		Iterator<Widget> widgets = selectedProfilePageCollectionFolder.getContentVerPanel().iterator();
		while (widgets.hasNext()) {
			Widget widget = widgets.next();
			if (widget instanceof ProfilePageCollectionFolderChild
					&& ((ProfilePageCollectionFolderChild) widget).getCollectionItemDo()
					.getResource().getGooruOid().equals(collectionId)) {
				return (ProfilePageCollectionFolderChild) widget;
			}
		}
		return null;
	}

	private ProfilePageCollectionChild getProfilePageCollectionChild(String collectionId) {
		Iterator<Widget> widgets = selectedProfilePageCollectionFolder.getContentVerPanel().iterator();
		while (widgets.hasNext()) {
			Widget widget = widgets.next();
			if (widget instanceof ProfilePageCollectionChild
					&& ((ProfilePageCollectionChild) widget).getCollectionItemDo()
					.getResource().getGooruOid().equals(collectionId)) {
				return (ProfilePageCollectionChild) widget;
			}
		}
		return null;
	}

	@Override
	public void clearMyShelfVerPanel() {
		myShelfVerPanel.clear();
	}

	@Override
	public void setNoCollectionData(String firstName) {
//		noCollectionMsgPanel.setText(firstName + " does not have any collections!");
	}
	
}
