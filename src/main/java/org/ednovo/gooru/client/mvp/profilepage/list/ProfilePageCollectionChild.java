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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.profilepage.event.RefreshProfileListEvent;
import org.ednovo.gooru.client.mvp.profilepage.event.RequestCollectionOpenEvent;
import org.ednovo.gooru.client.mvp.profilepage.event.RequestFolderOpenEvent;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : ProfilePageCollectionChild.java
 *
 * @description : This file deals with collection data in profile page collection child.
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
public class ProfilePageCollectionChild extends FocusPanel implements ClickHandler {

	private static ProfilePageCollectionUiBinder uiBinder = GWT
			.create(ProfilePageCollectionUiBinder.class);

	interface ProfilePageCollectionUiBinder extends UiBinder<Widget, ProfilePageCollectionChild> {
	}

	@UiField
	HTML titleLbl;

	@UiField
	VerticalPanel contentVerPanel;

	@UiField(provided = true)
	ShelfListCBundle res;

	@UiField
	FocusPanel titleFocPanel;

	@UiField
	FocusPanel wrapperFocPanel;

	@UiField
	DisclosurePanel disPanel;

	@UiField
	FlowPanel folderIcon, collectionIcon;

	private CollectionItemDo collectionItemDo;

	private static ProfilePageCollectionChild shelfCollection;

	/**
	 * Class constructor , assign the {@link CollectionItemDo} instance
	 * 
	 * @param collectionDo
	 *            instance of {@link CollectionItemDo}
	 */
	public ProfilePageCollectionChild(final CollectionItemDo collectionItemDo) {
		res = ShelfListCBundle.INSTANCE;
		res.css().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));
		setData(collectionItemDo);
		titleFocPanel.addClickHandler(this);
		titleFocPanel.getElement().getStyle().setPaddingLeft(45, Unit.PX);
		wrapperFocPanel.addClickHandler(this);
		titleFocPanel.setStyleName(res.css().foldersLi());
	}
	/**
	 * 
	 * @function setData 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This is used to set Data.
	 * 
	 * 
	 * @parm(s) : @param collectionItemDo
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setData(CollectionItemDo collectionItemDo) {
		this.collectionItemDo = collectionItemDo;
		titleLbl.setHTML(this.collectionItemDo.getResource().getTitle());
		if (this.collectionItemDo.getResource().getResourceType().getName().equalsIgnoreCase("folder")) {
			collectionIcon.removeFromParent();
		} else {
			folderIcon.removeFromParent();
		}
	}
	/**
	 * 
	 * @function isOpen 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :returns disPanel.isOpen()
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : boolean
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setOpen(boolean isOpen) {
		disPanel.setOpen(isOpen);
	}

	public boolean isOpen() {
		return disPanel.isOpen();
	}
	/**
	 * 
	 * @function setOpenFolderStyle 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This is used to set OpenFolder Style
	 * 
	 * 
	 * @parm(s) : @param isOpen
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setOpenFolderStyle(boolean isOpen) {
		if(isOpen) {
			titleFocPanel.removeStyleName(res.css().foldersLi());
			titleFocPanel.setStyleName(res.css().foldersLiOpen());
		} else {
			titleFocPanel.removeStyleName(res.css().foldersLiOpen());
			titleFocPanel.setStyleName(res.css().foldersLi());
		}
	}
	/**
	 * This is used to get folder and collection's data based on id's.
	 */
	@Override
	public void onClick(ClickEvent event) {
		if (event.getSource().equals(titleFocPanel))
		{
			/*			MixpanelUtil.Expand_CollectionPanel();
			 */
			if(this.collectionItemDo.getResource().getResourceType().getName().equalsIgnoreCase("folder")) {
				 MixpanelUtil.Click_On_Folder();
				 Map<String, String> params = new HashMap<String, String>();
				 String userId = AppClientFactory.getPlaceManager().getRequestParameter("id");
				 params.put("id", userId);
				 params.put("folderid", collectionItemDo.getResource().getGooruOid());
				 params.put("level", "3");
				 AppClientFactory.fireEvent(new RefreshProfileListEvent(collectionItemDo.getResource().getGooruOid(), "3"));
				 AppClientFactory.fireEvent(new RequestFolderOpenEvent(collectionItemDo.getResource().getGooruOid(),params));
			 } else {
				MixpanelUtil.Click_On_Collection();
				Map<String, String> params = new HashMap<String, String>();
				String userId = AppClientFactory.getPlaceManager().getRequestParameter("id");
				params.put("id", userId);
				params.put("collectionid", collectionItemDo.getResource().getGooruOid());
				AppClientFactory.fireEvent(new RefreshProfileListEvent(collectionItemDo.getResource().getGooruOid(), "4"));
				AppClientFactory.fireEvent(new RequestCollectionOpenEvent(collectionItemDo,params));
			 }
		} else if (event.getSource().equals(wrapperFocPanel)) {
		}
	}
	/**
	 * 
	 * @function setInnerFolderContent 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This is used to set inner folder content.
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setInnerFolderContent() {
	 	 AppClientFactory.getInjector().getProfilePageService().getFolders(this.collectionItemDo.getResource().getGooruOid(), new AsyncCallback<List<CollectionItemDo>>() {
		 @Override
		 public void onFailure(Throwable caught) {
			 
		 }
		 @Override
		 public void onSuccess(List<CollectionItemDo> collectionItems) {
			 contentVerPanel.clear();
			 for (CollectionItemDo collectionItemDo : collectionItems) {
				 contentVerPanel.add(new ProfilePageCollectionFolder(collectionItemDo));
			 }
		 }
	 	 });
	 	 setOpen();	
	}
	/**
	 * 
	 * @function getCollectionItemDo 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : returns collectionItemDo.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : CollectionItemDo
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public CollectionItemDo getCollectionItemDo() {
		return collectionItemDo;
	}
	/**
	 * 
	 * @function getContentVerPanel 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : returns contentVerPanel.
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : VerticalPanel
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public VerticalPanel getContentVerPanel() {
		return contentVerPanel;
	}
	/**
	 * 
	 * @function setOpen 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description : This is used to set shelf collection open.
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 * 
	 *
	 *
	 */
	public void setOpen() { 
		if (shelfCollection == null || !shelfCollection.equals(this)) {
			if (shelfCollection != null) {
				shelfCollection.setOpen(false);
			}
			shelfCollection = this;
			setOpen(!isOpen());
		}
	}
}
