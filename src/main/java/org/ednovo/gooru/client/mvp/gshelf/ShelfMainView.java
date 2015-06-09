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
package org.ednovo.gooru.client.mvp.gshelf;

import java.util.List;

import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareTabVc;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionStatisticsTabVc;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.uc.FolderPopupUc;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.vc.DeletePopupViewVc;
import org.ednovo.gooru.client.uc.tooltip.ToolTip;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.ClassPageCollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

/**
 * @fileName : ShelfView.java
 * 
 * @description :
 * 
 * 
 * @version : 5.5
 * 
 * @date: June 17, 2013
 * 
 * @Author Gooru Team
 * 
 * @Reviewer:
 */
public class ShelfMainView extends BaseViewWithHandlers<ShelfMainUiHandlers>
		implements IsShelfMainView, ClickHandler {

	ToolTip toolTip = null;

	DeletePopupViewVc delete = null;


	boolean collectionItemsNotFriendly = false;

	// private DeleteConfirmPopupVc deleteConfirmPopup;

	private FolderPopupUc folderPopupUc;

	// private CollectionCollaboratorTabVc collectionCollaboratorTabVc;

	private CollectionShareTabVc collectionShareTabVc;

	private CollectionStatisticsTabVc collectionStatisticsTabVc;

	private String deleteCollectionId = "";

	private static CollectionDo collectionDo = null;

	private PlaceRequest searchRequest = null;

	private PlaceRequest oldSearchRequest = null;

	private boolean isEditCopy = false;

	private boolean isShowTitlePencil = true;

	private boolean isShowDescPencil = true;

	private static final String COLLECTION_MOVE = "collectionMove";

	private static final String COLLECTION_MOVE_MP_EVENT = "Organize_move_collection";

	/* HTML5 Storage implementation for tab persistance */
	private Storage stockStore = null;

	Image categoryImage = new Image();

	private Timer tooltipTimer = null;

	boolean refresh = true;

	int currentCollabCount = 0;

	int defaultCollabCount = 5;

	boolean isOwnerUsedInOwnCollection = false;

	boolean isCollabUsedThisCollection = false;

	static MessageProperties i18n = GWT.create(MessageProperties.class);

	private static String WHAT_IS_THIS_COLLECTION_ABOUT = i18n.GL1485()
			+ i18n.GL_SPL_FULLSTOP() + i18n.GL_SPL_FULLSTOP()
			+ i18n.GL_SPL_FULLSTOP();

	private static final String PRE_SEARCH_LINK = i18n.GL1487();

	private static final String PRE_CLASSPAGE_LINK = i18n.GL1486();

	private static final String DELETE_COLLECTION = i18n.GL0558();

	private static final String NO_COLLECTION_MESSAGE = i18n.GL0995();

	private static final int TOOLTIP_DELAY_TIME = 1000;

	private static final String DEFULT_ASSESSMENT_IMG = "images/default-assessment-image -160x120.png";

	private static final String DEFULT_COLLECTION_IMG = "images/default-collection-image-160x120.png";

	private static final String ASSESSMENT = "assessment";

	private static final String O1_LEVEL = "o1";

	private static final String O2_LEVEL = "o2";

	private static final String O3_LEVEL = "o3";

	String selectedFolderId = "";

	private static final String ID = "id";

	List<ClassPageCollectionDo> classpageTitles = null;

	private static final String GOORU_UID = "gooruuid";
        
	@UiField HTMLPanel gShelfMainContainer;

	private static ShelfMainViewUiBinder uiBinder = GWT
			.create(ShelfMainViewUiBinder.class);

	interface ShelfMainViewUiBinder extends UiBinder<Widget, ShelfMainView> {
	}

	/**
	 * class constructor
	 */
	public ShelfMainView() {
		setWidget(uiBinder.createAndBindUi(this));
		gShelfMainContainer.getElement().setId("gShelfMainContainer");
	}

	

	@Override
	public void onClick(ClickEvent event) {
		// TODO Auto-generated method stub

	}

}