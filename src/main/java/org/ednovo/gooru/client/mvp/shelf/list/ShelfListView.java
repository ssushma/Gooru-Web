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
package org.ednovo.gooru.client.mvp.shelf.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.event.InvokeLoginEvent;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.dnd.Draggable;
import org.ednovo.gooru.client.mvp.dnd.DropBox;
import org.ednovo.gooru.client.mvp.dnd.IsDraggable.DRAG_TYPE;
import org.ednovo.gooru.client.mvp.resource.dnd.ResourceDropController;
import org.ednovo.gooru.client.mvp.search.event.RegisterSearchDropEvent;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.mvp.search.event.UnregisterSearchDropEvent;
import org.ednovo.gooru.client.mvp.shelf.ShelfCBundle;
import org.ednovo.gooru.client.mvp.shelf.ShelfView;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshType;
import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.client.uc.LabelGlassPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.FontStyle;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * @author Search Team
 * 
 */
public class ShelfListView extends BaseViewWithHandlers<ShelfListUiHandlers>
		implements IsShelfListView {

	private static ShelfTabViewUiBinder uiBinder = GWT
			.create(ShelfTabViewUiBinder.class);

	interface ShelfTabViewUiBinder extends UiBinder<Widget, ShelfListView> {
	}

	@UiField
	ShelfAddCollection addCollectionItem;

	@UiField
	ShelfAddCollection newCollectionShelf;
	
	@UiField
	VerticalPanel myShelfVerPanel;

	@UiField
	FocusPanel shelfFocPanel;

	@UiField(provided = true)
	ShelfListCBundle res;

	@UiField
	LabelGlassPanel shelfDropPanel;

	@UiField
	SimplePanel dragImageSimPanel;

	/*
	 * @UiField Label newFolderUIHandler;
	 */
	@UiField
	FlowPanel folderCollectionPanel;

	@UiField
	static ScrollPanel collectionListScrollpanel;

	@UiField
	HTMLPanel folderListPanelEvent;

	static Integer pageNumber = 1;

	private ResourceDropController tabDropController;

	private boolean fireConsumeShelfCollectionEvent;

	private ShelfCollection selectedShelfCollection = null;

	private FolderResource selectedFolder = null;

	private ThirdLevelFolderResource thirdLevelFolder = null;

	private static final List<CollectionDo> SHELF_COLLECTIONS = new ArrayList<CollectionDo>();

	private static final String NO_COLLECTION_MESSAGE = "You have no collections!";
	
	private static final String LOADING_COLLECTION_MESSAGE = "Looking for your collections...";

	@Inject
	ShelfView shelfView;
	
	public Map<Integer,Integer> totWidgets = new HashMap<Integer,Integer>();

	@UiField
	Label noCollectionMsgLbl;

	int collectionItemDoSize;

	private static String openedCollectionId = "";
	private final String NEW_RESOURCE_DRAG_MSG = "Drag a resource here to create a new collection.";
	private final String NEW_COLLECTION_DRAG_MSG = "Drag a collection here to save it.";
	private final String CONGRATS_NO_IMG = "onlyCongrats";
	private final String MSG_NO_IMG = "onlyMsg";
	private final String INFO_MSG = "infoMsg";
	
	/**
	 * Class constructor
	 */
	public ShelfListView() {
		res = ShelfListCBundle.INSTANCE;
		res.css().ensureInjected();
		ShelfCBundle.INSTANCE.css().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));
		noCollectionMsgLbl.setText(LOADING_COLLECTION_MESSAGE);
		noCollectionMsgLbl.setVisible(true);
		newCollectionShelf.getElement().setId("lblNewCollection");

		tabDropController = new ResourceDropController(this);
		GWT.log("Current Place Token "
				+ AppClientFactory.getCurrentPlaceToken());
		setShelfPosition(true);
		newCollectionShelf.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {

				if (AppClientFactory.getLoggedInUser().getUserUid()
						.equals(AppClientFactory.GOORU_ANONYMOUS)) {
					AppClientFactory.fireEvent(new InvokeLoginEvent());
				} else {
					if (checkFolderCollectionSize()) {
						AlertContentUc alertContentUc = new AlertContentUc(
								"Oops!",
								"You've reached the limit of folders/collections you can add to a folder!");
					} else {
						Window.enableScrolling(false);
						AppClientFactory.fireEvent(new SetHeaderZIndexEvent(99, false));
						MixpanelUtil.Click_Add_NewCollection();
						getUiHandlers().initCreateCollection();
					}
				}
			}
		});
	}

	public void setShelfPosition(boolean toRemove) {
		if (AppClientFactory.getCurrentPlaceToken().equals(
				PlaceTokens.EDIT_FOLDERS)
				|| AppClientFactory.getCurrentPlaceToken().equals(
						PlaceTokens.FOLDERS)
				|| AppClientFactory.getCurrentPlaceToken().equals(
						PlaceTokens.HOME)) {
			if (toRemove) {
				addCollectionItem.removeFromParent();
			}
			shelfFocPanel.setStyleName(res.css().shelfPanelForWorkspace());
		} else if (AppClientFactory.getCurrentPlaceToken().equals(
				PlaceTokens.SHELF)) {
			shelfFocPanel.setStyleName(res.css().shelfPanelForShelf());
		} else {
			shelfFocPanel.setStyleName(res.css().shelfPanel());
		}
	}

	@Override
	public void reset() {
//		super.reset();
		fireConsumeShelfCollectionEvent = false;
		selectedShelfCollection = null;
		selectedFolder = null;
		thirdLevelFolder = null;

		SHELF_COLLECTIONS.clear();
		myShelfVerPanel.clear();
		resetDragImage();
	}

	public void enableNoCollectionMessage(boolean isNoCollection) {
		if (isNoCollection == true) {
			noCollectionMsgLbl.getElement().getStyle().setDisplay(Display.NONE);
//			noCollectionMsgLbl.getElement().getStyle().setTextAlign(TextAlign.CENTER);
//			noCollectionMsgLbl.getElement().getStyle().setMarginLeft(65, Unit.PX);
			noCollectionMsgLbl.getElement().getStyle()
					.setMarginTop(20, Unit.PX);
			noCollectionMsgLbl.getElement().getStyle()
					.setFontStyle(FontStyle.ITALIC);
			noCollectionMsgLbl.getElement().getStyle().setWidth(163, Unit.PX);
			noCollectionMsgLbl.getElement().getStyle().setColor("#999999");
			noCollectionMsgLbl.getElement().getStyle()
					.setDisplay(Display.BLOCK);
		} else {
			noCollectionMsgLbl.getElement().getStyle().setDisplay(Display.NONE);
		}
	}

	@Override
	public void resetDragImage() {
		if (AppClientFactory.getCurrentPlaceToken().equals(	PlaceTokens.RESOURCE_SEARCH)) {
			enableNoCollectionMessage(false);
			totWidgets = setUserShelfMsg();
			setDiplayShelfMsg(totWidgets);
		}

		if (myShelfVerPanel.getWidgetCount() > 0) {
			displayFoldersPanel(false);
			enableNoCollectionMessage(false);
			if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.SHELF)){
				dragImageSimPanel.clear();
			}
			else if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.COLLECTION_SEARCH)){
				dragImageSimPanel.clear();
			}
			
		} else {
			if (AppClientFactory.getCurrentPlaceToken().equals(	PlaceTokens.COLLECTION_SEARCH)) {
				displayFoldersPanel(false);
				dragImageSimPanel.setWidget(new NoCollectionInShelfListView());
			} else if (AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.RESOURCE_SEARCH)) {
				displayFoldersPanel(false);
				
			} else {
				
				enableNoCollectionMessage(true);
				displayFoldersPanel(false);
				dragImageSimPanel.clear();
			}
		}
	}

	@Override
	public void setUserShelfData(List<CollectionDo> collections,boolean clearShelfPanel) {
		SHELF_COLLECTIONS.clear();
		SHELF_COLLECTIONS.addAll(collections);
		collectionItemDoSize = SHELF_COLLECTIONS.size();
		if (clearShelfPanel) {
			pageNumber = 1;
			myShelfVerPanel.clear();

		}
       
		for (CollectionDo collection : collections) {
			// myShelfVerPanel.add(new ShelfFolderCollection(collection));
			if (!collection.getCollectionType().toString().trim().equalsIgnoreCase("folder")){
				myShelfVerPanel.add(new ShelfCollection(collection));
			}
		}
		if(collectionItemDoSize==0){
			noCollectionMsgLbl.setText(NO_COLLECTION_MESSAGE);
		}

		resetDragImage();
		fireConsumeShelfCollectionEvent = true;
		getUiHandlers().requestShelfCollections();

	}

	@Override
	public Widget getDropTarget() {
		return asWidget();
	}

	@Override
	public void onDragOver(Draggable draggable) {
		if (draggable.getType().equals(DRAG_TYPE.COLLECTION)) {
//			shelfDropPanel.setGlassVisible(true);
//			draggable.getDraggableMirageUc().onDroppable(true);
			
		}
	}

	@Override
	public void onDragOut(Draggable draggable) {
		if (draggable.getType().equals(DRAG_TYPE.COLLECTION)) {
			shelfDropPanel.setGlassVisible(false);
			draggable.getDraggableMirageUc().onDroppable(false);
		}
	}

	@Override
	public void onDrop(Draggable draggable) {
		if (draggable.getType().equals(DRAG_TYPE.COLLECTION)) {
//			new CustomAnimation(draggable).run(50);
//			AppClientFactory.fireEvent(new CopyCollectionEvent(draggable.getDragId()));
			
		}
	}

	@Override
	public void registerDropController() {
		if (AppClientFactory.getCurrentPlaceToken().equals(
				PlaceTokens.COLLECTION_SEARCH)
				|| AppClientFactory.getCurrentPlaceToken().equals(
						PlaceTokens.RESOURCE_SEARCH)) {
			AppClientFactory.fireEvent(new RegisterSearchDropEvent(
					getDropController(),
					RegisterSearchDropEvent.DROP_AREA.SHELF));
		}
	}

	@Override
	public void unregisterDropController() {
		if (AppClientFactory.getCurrentPlaceToken().equals(
				PlaceTokens.COLLECTION_SEARCH)
				|| AppClientFactory.getCurrentPlaceToken().equals(
						PlaceTokens.RESOURCE_SEARCH)) {
			AppClientFactory.fireEvent(new UnregisterSearchDropEvent(
					getDropController(),
					RegisterSearchDropEvent.DROP_AREA.SHELF));
		}
	}

	@Override
	public void onLoad() {
//		super.onLoad();
		setShelfPosition(false);
		registerDropController();
	}

	@Override
	public void onUnload() {
//		super.onUnload();
		unregisterDropController();
	}

	public ResourceDropController getDropController() {
		return tabDropController;
	}

	/**
	 * @param dropController
	 *            instance of {@link ResourceDropController}
	 */
	public void setDropController(ResourceDropController dropController) {
		this.tabDropController = dropController;
	}

	@Override
	public void registerDropControllers() {
		registerDropController();
		addCollectionItem.registerDropController();
		Iterator<Widget> widgets = myShelfVerPanel.iterator();
		while (widgets.hasNext()) {
			Widget widget = widgets.next();
			if (widget instanceof DropBox) {
				((DropBox) widget).registerDropController();
			}
		}
	}

	@Override
	public void reregisterDropController() {
		unregisterDropController();
		registerDropController();
	}

	@Override
	public void refreshLevelFolderInShelfList(String collectionId,
			RefreshType refreshType, String folderLevel, int sequence,
			boolean flag) {/*
							 * System.out.println("--->>>>> "+folderLevel); if
							 * (folderLevel.equalsIgnoreCase("1")) {
							 * ShelfCollection shelfCollection =
							 * getShelfCollection(collectionId);
							 * selectedShelfCollection = shelfCollection; if
							 * (refreshType.equals(RefreshType.OPEN) && !flag) {
							 * try { shelfCollection.setOpenFolder(); } catch
							 * (Exception e) {
							 * 
							 * } } else if
							 * (refreshType.equals(RefreshType.UPDATE) && !flag)
							 * {
							 * System.out.println("--- Work Space folder ----");
							 * if (sequence >
							 * shelfCollection.getCollectionItemDo
							 * ().getItemSequence()) {
							 * selectedShelfCollection.getContentVerPanel
							 * ().insert(shelfCollection, sequence); } if
							 * (sequence <
							 * shelfCollection.getCollectionItemDo().
							 * getItemSequence()) {
							 * selectedShelfCollection.getContentVerPanel
							 * ().insert(shelfCollection, (sequence - 1)); } }
							 * 
							 * } else if (folderLevel.equalsIgnoreCase("2")) {
							 * FolderResource folderResource =
							 * getLevelTwoFolders
							 * (collectionId,selectedShelfCollection
							 * .getContentVerPanel()); selectedFolder =
							 * folderResource; if
							 * (refreshType.equals(RefreshType.OPEN) && !flag) {
							 * try { folderResource.setOpenFolder(); } catch
							 * (Exception e) {
							 * 
							 * } } else if
							 * (refreshType.equals(RefreshType.UPDATE) && !flag)
							 * {
							 * 
							 * if (sequence >
							 * folderResource.getCollectionItemDo()
							 * .getItemSequence()) {
							 * selectedShelfCollection.getContentVerPanel
							 * ().insert(folderResource, sequence); } if
							 * (sequence <
							 * folderResource.getCollectionItemDo().getItemSequence
							 * ()) {
							 * selectedShelfCollection.getContentVerPanel()
							 * .insert(folderResource, (sequence - 1)); } } }
							 * else if (folderLevel.equalsIgnoreCase("3")) {
							 * ThirdLevelFolderResource thirdLevelFolderResource
							 * = getLevelThreeFolders(collectionId,
							 * selectedFolder.getContentVerPanel());
							 * thirdLevelFolder = thirdLevelFolderResource; if
							 * (refreshType.equals(RefreshType.OPEN) && !flag) {
							 * try { thirdLevelFolderResource.setOpenFolder(); }
							 * catch (Exception e) {
							 * 
							 * } } else if
							 * (refreshType.equals(RefreshType.UPDATE) && !flag)
							 * { if (sequence >
							 * thirdLevelFolderResource.getCollectionItemDo()
							 * .getItemSequence()) {
							 * selectedFolder.getContentVerPanel().insert(
							 * thirdLevelFolderResource, sequence); } if
							 * (sequence <
							 * thirdLevelFolderResource.getCollectionItemDo()
							 * .getItemSequence()) {
							 * selectedFolder.getContentVerPanel().insert(
							 * thirdLevelFolderResource, (sequence - 1)); }
							 * 
							 * // selectedFolder.getContentVerPanel().insert(
							 * thirdLevelFolderResource,sequence); } }else
							 * if(folderLevel.equalsIgnoreCase("")) {
							 * ThirdLevelFolderResourceData
							 * thirdLevelFolderResourceData =
							 * getLevelThreeCollections(collectionId,
							 * thirdLevelFolder.getContentVerPanel());
							 * thirdLevelFolderResourceData.setCollectionOpen();
							 * }
							 */
	}

	@Override
	public void insertFolderInShelfView(CollectionItemDo collectionItemDo,
			RefreshType refreshType, String folderLevel) {/*
														 * if
														 * (refreshType.equals
														 * (RefreshType.INSERT))
														 * { if (folderLevel.
														 * equalsIgnoreCase
														 * ("1")) {
														 * FolderResource
														 * folderResource = new
														 * FolderResource
														 * (collectionItemDo,
														 * null);
														 * folderResource.
														 * secondLevelFolders
														 * .getElement
														 * ().getStyle
														 * ().setWidth
														 * (300,Unit.PX);
														 * if(collectionItemDo
														 * .getResource
														 * ().getResourceType
														 * ().getName
														 * ().equalsIgnoreCase
														 * ("collection")) {
														 * folderResource
														 * .folderL2Icon
														 * .removeFromParent();
														 * }
														 * setShelfCollectionDefaultMsg
														 * ();
														 * selectedShelfCollection
														 * .
														 * getContentVerPanel().
														 * insert
														 * (folderResource, 0);
														 * } else if
														 * (folderLevel
														 * .equalsIgnoreCase
														 * ("2")) {
														 * ThirdLevelFolderResource
														 * thirdLevelFolderResource
														 * = new
														 * ThirdLevelFolderResource
														 * (collectionItemDo);
														 * thirdLevelFolderResource
														 * .thirdLevelFolders.
														 * getElement
														 * ().getStyle(
														 * ).setWidth
														 * (300,Unit.PX);
														 * if(collectionItemDo
														 * .getResource
														 * ().getResourceType
														 * ().getName
														 * ().equalsIgnoreCase
														 * ("collection")) {
														 * thirdLevelFolderResource
														 * .folderL3Icon.
														 * removeFromParent(); }
														 * setFolderResourceDefaultMsg
														 * (); selectedFolder.
														 * getContentVerPanel
														 * ().insert
														 * (thirdLevelFolderResource
														 * , 0); } else if
														 * (folderLevel
														 * .equalsIgnoreCase
														 * ("3")) {
														 * ThirdLevelFolderResourceData
														 * thirdLevelFolderResourceData
														 * = new
														 * ThirdLevelFolderResourceData
														 * (collectionItemDo);
														 * thirdLevelFolderResourceData
														 * .
														 * thirdLevelFoldersData
														 * .
														 * getElement().getStyle
														 * (
														 * ).setWidth(300,Unit.PX
														 * );
														 * if(collectionItemDo
														 * .getResource
														 * ().getResourceType
														 * ().getName
														 * ().equalsIgnoreCase
														 * ("collection")) {
														 * thirdLevelFolderResourceData
														 * .folderL3DataIcon.
														 * removeFromParent(); }
														 * setShelfResourceDefaultMsg
														 * (); thirdLevelFolder.
														 * getContentVerPanel
														 * ().insert(
														 * thirdLevelFolderResourceData
														 * ,0); } } else if
														 * (refreshType
														 * .equals(RefreshType
														 * .DELETE)) { if
														 * (folderLevel
														 * .equalsIgnoreCase
														 * ("1")) {
														 * FolderResource
														 * folderResource =
														 * getLevelTwoFolders(
														 * collectionItemDo
														 * .getResource
														 * ().getGooruOid(),
														 * selectedShelfCollection
														 * .
														 * getContentVerPanel())
														 * ;
														 * folderResource.asWidget
														 * (
														 * ).removeFromParent();
														 * setShelfCollectionDefaultMsg
														 * (); } else if
														 * (folderLevel
														 * .equalsIgnoreCase
														 * ("2")) {
														 * ThirdLevelFolderResource
														 * thirdLevelFolderResource
														 * =
														 * getLevelThreeFolders(
														 * collectionItemDo
														 * .getResource
														 * ().getGooruOid(),
														 * selectedFolder
														 * .getContentVerPanel
														 * ());
														 * thirdLevelFolderResource
														 * .asWidget().
														 * removeFromParent();
														 * setFolderResourceDefaultMsg
														 * (); } else if
														 * (folderLevel
														 * .equalsIgnoreCase
														 * ("3")) {
														 * ThirdLevelFolderResourceData
														 * thirdLevelFolderResourceData
														 * =
														 * getLevelThreeCollections
														 * (collectionItemDo.
														 * getResource
														 * ().getGooruOid
														 * (),thirdLevelFolder
														 * .getContentVerPanel
														 * ());
														 * thirdLevelFolderResourceData
														 * .asWidget().
														 * removeFromParent();
														 * setShelfResourceDefaultMsg
														 * (); } }
														 */
	}

	@Override
	public void disableDraggableEvent(String folderLevel,
			String folderObjectType) {
		if (folderLevel.equalsIgnoreCase("1")) {
		} else if (folderLevel.equalsIgnoreCase("2")) {
		}
	}

	public void setShelfCollectionDefaultMsg() {
		/*
		 * if(selectedShelfCollection.getContentVerPanel().getWidgetCount()<=0)
		 * { selectedShelfCollection.setEmptyData(); } else { try {
		 * selectedShelfCollection.removeEmptyData(); } catch (Exception e) {
		 * e.printStackTrace(); } }
		 */}

	public void setFolderResourceDefaultMsg() {
		/*
		 * if (selectedFolder.getContentVerPanel().getWidgetCount() <= 0) {
		 * selectedFolder.setEmptyData(); } else { try {
		 * selectedFolder.removeEmptyData(); } catch (Exception e) {
		 * e.printStackTrace(); } }
		 */}

	public void setShelfResourceDefaultMsg() {

		/*
		 * if(thirdLevelFolder.getContentVerPanel().getWidgetCount()<=0) {
		 * thirdLevelFolder.setEmptyData(); } else { try {
		 * thirdLevelFolder.removeEmptyData(); } catch (Exception e) {
		 * e.printStackTrace(); } }
		 */}

	/*@Override
	public void deleteFolderInShelfView(CollectionItemDo collectionItemDo,
			RefreshType refreshType, String folderLevel) {

	}*/

	/*
	 * @Override public void refreshLevelFolderInShelfList(String collectionId,
	 * RefreshType refreshType, String folderLevel, int sequence) {
	 * 
	 * if(folderLevel.equalsIgnoreCase("1")) { ShelfCollection shelfCollection =
	 * getShelfCollection(collectionId); selectedShelfCollection =
	 * shelfCollection; } else if (folderLevel.equalsIgnoreCase("2")) {
	 * FolderResource folderResource =
	 * getLevelTwoFolders(collectionId,selectedShelfCollection
	 * .getContentVerPanel()); selectedFolder = folderResource;
	 * System.out.println("------ "+sequence);
	 * selectedShelfCollection.getContentVerPanel
	 * ().insert(folderResource,sequence); } else
	 * if(folderLevel.equalsIgnoreCase("3")) { FolderResource folderResource =
	 * getLevelTwoFolders(collectionId,selectedFolder.getContentVerPanel());
	 * selectedFolder = folderResource;
	 * selectedShelfCollection.getContentVerPanel
	 * ().insert(folderResource,sequence); } }
	 */

	@Override
	public void refreshCollectionInShelfList(CollectionDo collectionDo,
			RefreshType refreshType) {
		if (collectionDo != null) {
			if (refreshType.equals(RefreshType.INSERT)|| refreshType.equals(RefreshType.INSERT_AND_VIEW)) {
				SHELF_COLLECTIONS.add(collectionDo);
				ShelfCollection shelfCollection = new ShelfCollection(
						collectionDo);
				myShelfVerPanel.insert(shelfCollection, 0);
				shelfCollection.setOpen();
				shelfCollection.glowTitle();
				totWidgets = setUserShelfMsg();
				setDiplayShelfMsg(totWidgets);
				if (refreshType.equals(RefreshType.INSERT_AND_VIEW)) {
					AppClientFactory.getPlaceManager().revealPlace(
							PlaceTokens.SHELF,
							new String[] { "id", collectionDo.getGooruOid() });
				}
				setNewCollectionPanelCss(false, NEW_COLLECTION_DRAG_MSG);
				resetDragImage();
				
			} else if (refreshType.equals(RefreshType.UPDATE)) {
				ShelfCollection shelfCollection = getShelfCollection(collectionDo
						.getGooruOid());
				shelfCollection.updateData(collectionDo);
			} else if (refreshType.equals(RefreshType.DELETE)) {

				ShelfCollection shelfCollection = getShelfCollection(collectionDo
						.getGooruOid());
				int index = myShelfVerPanel.getWidgetIndex(shelfCollection);
				selectedShelfCollection = null;
				if (myShelfVerPanel.getWidgetCount() > 1) {
					if (index == 0) {
						selectedShelfCollection = (ShelfCollection) myShelfVerPanel
								.getWidget(1);
					} else {
						selectedShelfCollection = (ShelfCollection) myShelfVerPanel
								.getWidget(index - 1);
					}
					selectedShelfCollection.setOpen();
					AppClientFactory.getPlaceManager().revealPlace(
							PlaceTokens.SHELF,
							new String[] {
									"id",
									selectedShelfCollection.getCollectionDo()
											.getGooruOid() });
				} else {
					AppClientFactory.getPlaceManager().revealPlace(
							PlaceTokens.SHELF);
				}
				shelfCollection.removeFromParent();
				if(myShelfVerPanel.getWidgetCount()==0){
					noCollectionMsgLbl.setText(NO_COLLECTION_MESSAGE);
				}else{
					noCollectionMsgLbl.setText(LOADING_COLLECTION_MESSAGE);
				}
				// resetDragImage();

			} else if (refreshType.equals(RefreshType.OPEN)) {
				selectedShelfCollection = getShelfCollection(collectionDo
						.getGooruOid());
				if (selectedShelfCollection != null) {
					selectedShelfCollection.setOpen();
				}
			}
		} else if (myShelfVerPanel.getWidgetCount() > 0) {
			selectedShelfCollection = (ShelfCollection) myShelfVerPanel
					.getWidget(0);
			AppClientFactory.getPlaceManager().revealPlace(
					PlaceTokens.SHELF,
					new String[] {
							"id",
							selectedShelfCollection.getCollectionDo()
									.getGooruOid() });
		} else {
			AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.SHELF);
		}
		getUiHandlers().requestShelfCollections();
		shelfView.setFocusCollectionTitle();
	}

	@Override
	public void refreshCollectionItemInShelfList(
			CollectionItemDo collectionItemDo, RefreshType refreshType) {
		if (refreshType.equals(RefreshType.INSERT)) {
			ShelfCollection shelfCollection = getShelfCollection(collectionItemDo.getCollection().getGooruOid());
			shelfCollection.addCollectionItem(collectionItemDo, true);
		} else if (refreshType.equals(RefreshType.UPDATE)) {
			ShelfCollection shelfCollection = getShelfCollection(collectionItemDo
					.getCollection().getGooruOid());
			shelfCollection.updateCollectionItem(collectionItemDo);
		} else if (refreshType.equals(RefreshType.DELETE)) {
			ShelfCollection shelfCollection = getShelfCollection(collectionItemDo
					.getCollection().getGooruOid());
			shelfCollection.removeCollectionItem(collectionItemDo);
		}
		getUiHandlers().requestShelfCollections();
	}

	@Override
	public List<CollectionDo> getShelfCollections() {
		return SHELF_COLLECTIONS;
	}

	@Override
	public boolean isFireConsumeShelfCollectionEvent() {
		return fireConsumeShelfCollectionEvent;
	}

	public void setFireConsumeShelfCollectionEvent(
			boolean fireConsumeShelfCollectionEvent) {
		this.fireConsumeShelfCollectionEvent = fireConsumeShelfCollectionEvent;
	}

	@Override
	public void openShelfCollection(String collectionId) {
		selectedShelfCollection = getShelfCollection(collectionId);
		selectedShelfCollection.setOpen();
	}

	private ShelfCollection getShelfCollection(String collectionId) {
		Iterator<Widget> widgets = myShelfVerPanel.iterator();
		while (widgets.hasNext()) {
			Widget widget = widgets.next();
			if (widget instanceof ShelfCollection
					&& ((ShelfCollection) widget).getCollectionDo()
							.getGooruOid().equals(collectionId)) {
				return (ShelfCollection) widget;
			}
		}

		return null;
	}

	private ShelfCollection getOpenShelfCollection() {
		Iterator<Widget> widgets = myShelfVerPanel.iterator();
		while (widgets.hasNext()) {
			Widget widget = widgets.next();
			if (widget instanceof ShelfCollection&& ((ShelfCollection) widget).disPanel.isOpen()) {
				return (ShelfCollection) widget;
			}
	}
		return null;
	}

	/*private FolderResource getLevelTwoFolders(String collectionId,
			VerticalPanel contentVerPanel) {
		Iterator<Widget> widgets = contentVerPanel.iterator();
		while (widgets.hasNext()) {
			Widget widget = widgets.next();
			if (widget instanceof FolderResource
					&& ((FolderResource) widget).getCollectionItemDo()
							.getResource().getGooruOid().equals(collectionId)) {
				return (FolderResource) widget;
			}
		}

		return null;
	}

	private ThirdLevelFolderResource getLevelThreeFolders(String collectionId,
			VerticalPanel contentVerPanel) {
		Iterator<Widget> widgets = contentVerPanel.iterator();
		while (widgets.hasNext()) {
			Widget widget = widgets.next();
			if (widget instanceof ThirdLevelFolderResource
					&& ((ThirdLevelFolderResource) widget)
							.getCollectionItemDo().getResource().getGooruOid()
							.equals(collectionId)) {
				return (ThirdLevelFolderResource) widget;
			}
		}

		return null;
	}

	private ThirdLevelFolderResourceData getLevelThreeCollections(
			String collectionId, VerticalPanel contentVerPanel) {
		Iterator<Widget> widgets = contentVerPanel.iterator();
		while (widgets.hasNext()) {
			Widget widget = widgets.next();
			if (widget instanceof ThirdLevelFolderResourceData
					&& ((ThirdLevelFolderResourceData) widget)
							.getCollectionItemDo().getResource().getGooruOid()
							.equals(collectionId)) {
				return (ThirdLevelFolderResourceData) widget;
			}
		}

		return null;
	}*/
/**
 * To get more collection item after scroll down,if collection is more than 20.
 * @param event instance of ScrollEvent
 */
	@UiHandler("collectionListScrollpanel")
	public void dragImageSimPanelscroll(ScrollEvent event) {

		if (collectionListScrollpanel.getVerticalScrollPosition() == collectionListScrollpanel
				.getMaximumVerticalScrollPosition()
				&& collectionItemDoSize >= 20)

		{
			pageNumber = pageNumber + 1;
			getUiHandlers().getSelfCollectionListItems(20, pageNumber, false);

		}
	}

	/**
	 * This method is used to get pageNumber
	 * 
	 * @return pageNumber
	 */
	public static int getpageNumber() {
		return pageNumber;

	}

	/**
	 * This method is used to set page number
	 * 
	 * @param pageNumber
	 */
	public static void setPageNumber(Integer pageNumber) {
		ShelfListView.pageNumber = pageNumber;
	}

	@Override
	public void disableFolderCollectionPanel() {
		folderCollectionPanel.getElement().getStyle().setDisplay(Display.NONE);
	}

	@Override
	public void enableFolderCollectionPanel() {
		folderCollectionPanel.getElement().getStyle().setDisplay(Display.BLOCK);
	}

	/**
	 * This method checks for the limit of each folder/subfolder
	 * 
	 * @return boolean
	 */
	public boolean checkFolderCollectionSize() {
		if (myShelfVerPanel.getWidgetCount() > 50) {
			return true;
		}
		return false;
	}

	/**
 * 
 */
	@Override
	public void collectionListScrollpanel(boolean isSetClear) {

		if (isSetClear) {
			collectionListScrollpanel.getElement().getStyle().clearHeight();
		} else {
			collectionListScrollpanel.getElement().getStyle()
					.setHeight(Window.getClientHeight() - 122, Unit.PX);
		}

	}

	@Override
	public void displayFoldersPanel(boolean isLoggedIn) {
		if (isLoggedIn == true) {
			folderListPanelEvent.getElement().getStyle()
					.setDisplay(Display.BLOCK);
		} else {
			folderListPanelEvent.getElement().getStyle()
					.setDisplay(Display.NONE);
		}
	}

	@Override
	public void setNewCollectionPanel() {
		if (AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.RESOURCE_SEARCH)) {
			setNewCollectionPanelCss(false, NEW_RESOURCE_DRAG_MSG);
		} else if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.COLLECTION_SEARCH)) {
			setNewCollectionPanelCss(false, NEW_COLLECTION_DRAG_MSG);
		} else if(AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.SHELF)) {
			setNewCollectionPanelCss(true, "");
		}
		try {
			ShelfCollection shelfCollection = getOpenShelfCollection();
			if(shelfCollection!=null) {
				shelfCollection.setOpenStatus(true);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setNewCollectionPanelCss(boolean isNewCollection, String msg) {
		if(isNewCollection){
			newCollectionShelf.getElement().getStyle().setDisplay(Display.BLOCK);
			addCollectionItem.getElement().getStyle().setDisplay(Display.NONE);
		} else {
			addCollectionItem.setLabel(msg);
			addCollectionItem.setStyleName(ShelfListCBundle.INSTANCE.css().resourceCollectionPanelStyle());
			addCollectionItem.getLabel().setStyleName(ShelfListCBundle.INSTANCE.css().resourceCollectionPanelText());
			addCollectionItem.getElement().getStyle().setDisplay(Display.BLOCK);
			newCollectionShelf.getElement().getStyle().setDisplay(Display.NONE);
		}
	}

	@Override
	public void setOpenCollectionId(String collectionId) {
		this.openedCollectionId = collectionId;
	}

	@Override
	public void setUserShelfMsg(String userMsg) {
		if(myShelfVerPanel.getWidgetCount()<=10){
			dragImageSimPanel.clear();
			dragImageSimPanel.setWidget(new NoResourceInShelfListView(userMsg));
			if(myShelfVerPanel.getWidgetCount()>5){
				dragImageSimPanel.clear();
				dragImageSimPanel.setWidget(new NoResourceInShelfListView(CONGRATS_NO_IMG));
			}
		}
		
		
	}
	
	public void setDiplayShelfMsg(Map<Integer, Integer> totWidgets){ 
		if(myShelfVerPanel.getWidgetCount()<=5){
			for(Map.Entry<Integer,Integer> obj:totWidgets.entrySet()){
				if(obj.getValue()<2 ){
					dragImageSimPanel.clear();
					dragImageSimPanel.setWidget(new NoResourceInShelfListView(INFO_MSG));
				}
				/*if(obj.getValue()>=2 ){
					dragImageSimPanel.clear();
					dragImageSimPanel.setWidget(new NoResourceInShelfListView(""));
				}*/
			}
		}
		else if(myShelfVerPanel.getWidgetCount()>5 && myShelfVerPanel.getWidgetCount()<=10){
			dragImageSimPanel.clear();
			dragImageSimPanel.setWidget(new NoResourceInShelfListView(MSG_NO_IMG));
		}
		else if(myShelfVerPanel.getWidgetCount()>10){
			dragImageSimPanel.clear();
		}
		
	}
	
	private Map<Integer, Integer> setUserShelfMsg() { 
		Map<Integer,Integer> totWidgetsCount = new HashMap<Integer,Integer>();
		if(myShelfVerPanel.getWidgetCount()==0){
			dragImageSimPanel.setWidget(new NoResourceInShelfListView(""));
		}
		Iterator<Widget> widgets = myShelfVerPanel.iterator();
		int counter=0;
		while (widgets.hasNext()) {
			Widget widget = widgets.next();
			if (widget instanceof ShelfCollection) {
				int childWidget = ((ShelfCollection) widget).getContentVerPanel().getWidgetCount();
				totWidgetsCount.put(counter,childWidget);
			}
			counter++;
	}
		return totWidgetsCount;
	}

}
