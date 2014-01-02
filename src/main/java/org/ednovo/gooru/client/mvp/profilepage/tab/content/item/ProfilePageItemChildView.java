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
package org.ednovo.gooru.client.mvp.profilepage.tab.content.item;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.child.ChildView;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.profilepage.event.RefreshProfileListEvent;
import org.ednovo.gooru.client.mvp.profilepage.event.RequestCollectionOpenEvent;
import org.ednovo.gooru.client.mvp.profilepage.event.RequestFolderOpenEvent;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : ProfilePageItemChildView.java
 *
 * @description : This is used to setdata to Refresh ProfileListEvent and to Request CollectionOpenEvent.
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
public class ProfilePageItemChildView extends ChildView<ProfilePageItemChildPresenter> implements IsProfilePageItemView {

	@UiField
	FlowPanel childItemFolderIcon, actionVerPanel;

	@UiField
	Label lblChildItemTitle, lblChildItemDescription;

	@UiField
	Button childItemOpenBtn;

	private static ProfilePageItemChildViewUiBinder uiBinder = GWT.create(ProfilePageItemChildViewUiBinder.class);

	interface ProfilePageItemChildViewUiBinder extends UiBinder<Widget, ProfilePageItemChildView> {}

	/**
	 * Class constructor
	 * 
	 * @param collectionItem
	 *            instance of {@link CollectionItemDo}
	 */
	public ProfilePageItemChildView(CollectionItemDo collectionItemDo) {
		initWidget(uiBinder.createAndBindUi(this));
		setData(collectionItemDo);
		addDomHandler(new ActionPanelHover(), MouseOverEvent.getType());
		addDomHandler(new ActionPanelOut(), MouseOutEvent.getType());
		actionVerPanel.setVisible(false);
	}

	/**
	 * To show the Folder Open Button
	 */
	private class ActionPanelHover implements MouseOverHandler {
		@Override
		public void onMouseOver(MouseOverEvent event) {
			actionVerPanel.setVisible(true);
		}
	}

	/**
	 * To hide the Folder Open Button
	 */
	private class ActionPanelOut implements MouseOutHandler {
		@Override
		public void onMouseOut(MouseOutEvent event) {
			actionVerPanel.setVisible(false);
		}
	}
	/**
	 * 
	 * @function setData 
	 * 
	 * @created_date : 31-Dec-2013
	 * 
	 * @description :This is used to setdata to Refresh ProfileListEvent and to Request CollectionOpenEvent.
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
	private void setData(final CollectionItemDo collectionItemDo) {
		lblChildItemTitle.setText(collectionItemDo.getResource().getTitle());
		lblChildItemDescription.setText(collectionItemDo.getResource().getGoals());
		childItemOpenBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				
				Map<String, String> params = new HashMap<String, String>();
				String userId = AppClientFactory.getPlaceManager().getRequestParameter("id");
				String folderLevel = AppClientFactory.getPlaceManager().getRequestParameter("level");
				if(folderLevel==null) {
					folderLevel = "1";
				} else if (folderLevel.equalsIgnoreCase("1")) {
					folderLevel = "2";
				} else if (folderLevel.equalsIgnoreCase("2")) {
					folderLevel = "3";
				}
				if(collectionItemDo.getResource().getResourceType().getName().equalsIgnoreCase("folder")) {
					MixpanelUtil.Click_On_Open();
					params.put("id", userId);
					params.put("folderid", collectionItemDo.getResource().getGooruOid());
					params.put("level", folderLevel);
					AppClientFactory.fireEvent(new RefreshProfileListEvent(collectionItemDo.getResource().getGooruOid(), folderLevel));
					AppClientFactory.fireEvent(new RequestFolderOpenEvent(collectionItemDo.getResource().getGooruOid(),params));
				} else {
					params.put("id", userId);
					params.put("collectionid", collectionItemDo.getResource().getGooruOid());
					params.put("level", folderLevel);
					AppClientFactory.fireEvent(new RefreshProfileListEvent(collectionItemDo.getResource().getGooruOid(), folderLevel));
					AppClientFactory.fireEvent(new RequestCollectionOpenEvent(collectionItemDo,params));
				}
			}
		});
	}
}
