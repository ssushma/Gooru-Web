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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.content.CollectionDo;
import org.ednovo.gooru.application.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.mvp.dnd.Draggable;
import org.ednovo.gooru.client.mvp.dnd.DropBox;
import org.ednovo.gooru.client.mvp.dnd.IsDraggable.DRAG_TYPE;
import org.ednovo.gooru.client.mvp.home.AleartPopupVc;
import org.ednovo.gooru.client.mvp.resource.dnd.ResourceDropController;
import org.ednovo.gooru.client.mvp.search.event.RegisterSearchDropEvent;
import org.ednovo.gooru.client.mvp.search.event.UnregisterSearchDropEvent;
import org.ednovo.gooru.client.mvp.shelf.event.CreateCollectionItemEvent;
import org.ednovo.gooru.client.mvp.shelf.event.CreateCollectionItemInFoldersEvent;
import org.ednovo.gooru.client.mvp.shelf.event.DisableDraggableEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshLevelFolderInShelfListEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RefreshType;
import org.ednovo.gooru.client.mvp.shelf.event.RequestShelfEvent;
import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.client.uc.LabelGlassPanel;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.FontStyle;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class FolderResource extends FocusPanel implements ClickHandler,
		MouseOverHandler, DropBox {

	private static FolderResourceUiBinder uiBinder = GWT
			.create(FolderResourceUiBinder.class);
	
	static MessageProperties i18n = GWT.create(MessageProperties.class);

	interface FolderResourceUiBinder extends UiBinder<Widget, FolderResource> {
	}

	@UiField
	FocusPanel L1titleFocPanel;

	@UiField
	HTML folderL2TitleLbl;

	@UiField
	DisclosurePanel folderL2DisPanel;

	@UiField
	FocusPanel wrapperFocPanel;

	@UiField
	LabelGlassPanel glassContainer;

	@UiField
	FlowPanel secondLevelFolders, collectionIcon, folderL2Icon;

	@UiField
	VerticalPanel contentVerPanel;
	
	@UiField Label blueLbl,greyLbl;

	@UiField(provided = true)
	ShelfListCBundle res;

	HTMLPanel htmlPanel;

	private CollectionItemDo collectionItemDo = null;

	private static final String FOLDER_LEVEL = "2";

//	private String collectionId = null;
	AlertContentUc alertContentUc;

	private ResourceDropController dropController;
	private static final String EDIT_THIS_COLLECTION = i18n.GL0991();
	private static final String ADD_TO_THIS_COLLECTION = i18n.GL0990();

	private static FolderResource folderResource;

	private Draggable draggable;

	public FolderResource(CollectionItemDo collectionItem,
			CollectionDo collectionDo) {
		res = ShelfListCBundle.INSTANCE;
		res.css().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));
		glassContainer.setGlassText(i18n.GL0991());
		glassContainer.getElement().setId("GlassContainer");
		glassContainer.getElement().setAttribute("alt", i18n.GL0991());
		glassContainer.getElement().setAttribute("title", i18n.GL0991());

		glassContainer.setGlassVisible(false);
		this.collectionItemDo = collectionItem;

		dropController = new ResourceDropController(this);
		this.setStyleName(ShelfListCBundle.INSTANCE.css().shelfResourcePanel());
		L1titleFocPanel.getElement().setId("focuspnlL1titleFocPanel");
		L1titleFocPanel.addClickHandler(this);
		secondLevelFolders.getElement().setId("fpnlsecondLevelFolders");
		secondLevelFolders.getElement().getStyle().setFloat(Float.LEFT);
		collectionIcon.getElement().setId("fpnlCollectionIcon");
		folderL2Icon.getElement().setId("fpnlFolderL2Icon");
		blueLbl.getElement().setId("lblBlueLbl");
		greyLbl.getElement().setId("lblGreyLbl");
		folderL2DisPanel.getElement().setId("discpnlFolderL2DisPanel");
		wrapperFocPanel.getElement().setId("focuspnlWrapperFocPanel");
		contentVerPanel.getElement().setId("vpnlContentVerPanel");
		wrapperFocPanel.addMouseOverHandler(this);
		wrapperFocPanel.addMouseOutHandler(new MouseOutHandler() {

			@Override
			public void onMouseOut(MouseOutEvent event) {
				if (!getDropController().isDropActive()) {
					glassContainer.setGlassVisible(false);
				}
				glassContainer.setGlassVisible(false);
			}
		});
		wrapperFocPanel.addClickHandler(this);
		this.setData(collectionItem);

	}

	/*public FolderResource(String collectionId) {
		this.collectionId = collectionId;
	}*/

	/*
	 * public void setL2FoldersData(CollectionItemDo collectionItemDo) { if
	 * (collectionItemDo.getCollection().getCollectionItems().size() > 0) { for
	 * (CollectionItemDo collectionItem :
	 * collectionItemDo.getCollection().getCollectionItems()) {
	 * addCollectionItem(collectionItem, false); } } else{
	 * if(collectionItemDo.getResource
	 * ().getResourceType().getName().equalsIgnoreCase("folder")) { htmlPanel =
	 * new HTMLPanel("This folder is empty!"); } else
	 * if(collectionItemDo.getResource
	 * ().getResourceType().getName().equalsIgnoreCase("scollection")) {
	 * htmlPanel = new HTMLPanel("This collection is empty!"); }
	 * htmlPanel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
	 * htmlPanel.getElement().getStyle().setMarginLeft(19, Unit.PX);
	 * htmlPanel.getElement().getStyle().setColor("#999999");
	 * htmlPanel.getElement
	 * ().setId(collectionItemDo.getCollection().getGooruOid());
	 * contentVerPanel.add(htmlPanel); }
	 * 
	 * }
	 */

	public void addCollectionItem(CollectionItemDo collectionItem, boolean isNew) {
		// ShelfResource shelfResource = new ShelfResource(collectionItemDo);
		//ShelfResource shelfResource = new ShelfResource(collectionItem);
		int widgetCount = contentVerPanel.getWidgetCount();
		int sequence = collectionItem.getItemSequence() - 1;
		//contentVerPanel.insert(shelfResource,widgetCount > 0 ? sequence >= widgetCount ? widgetCount: sequence : 0);
		if (isNew) {
			// shelfResource.glowTitle();
		}

	}

	private void setData(CollectionItemDo collectionItem) {
		if (collectionItem.getResource().getTitle() != null
				&& collectionItem.getResource().getTitle().length() > 0) {
			if (collectionItem.getResource().getResourceType().getName()
					.equalsIgnoreCase("folder")) {
				collectionIcon.removeFromParent();
			} else if (collectionItem.getResource().getResourceType().getName()
					.equalsIgnoreCase("scollection")) {
				folderL2Icon.removeFromParent();
			}
			L1titleFocPanel.getElement().setAttribute("collectionType",
					collectionItem.getResource().getResourceType().getName());
			// folderL2TitleLbl.setText(StringUtil.truncateText(collectionItem.getResource().getTitle(),
			// 30));
			folderL2TitleLbl.setHTML(StringUtil.truncateText(collectionItem
					.getResource().getTitle(), 30));
			folderL2TitleLbl.getElement().setAttribute("alt", collectionItem.getResource().getTitle());
			folderL2TitleLbl.getElement().setAttribute("title", collectionItem.getResource().getTitle());
			folderL2TitleLbl.getElement().setId(
					collectionItem.getResource().getGooruOid());
			
		} else {
			folderL2TitleLbl.setText("--");
			folderL2TitleLbl.getElement().setId(collectionItem.getResource().getGooruOid());
		}
	}

	public CollectionItemDo getCollectionItemDo() {
		return collectionItemDo;
	}

	public void setCollectionItemDo(CollectionItemDo collectionItemDo) {
		this.collectionItemDo = collectionItemDo;
	}

	@Override
	public void onClick(ClickEvent event) {

		if (event.getSource().equals(L1titleFocPanel)) {
			L1titleFocPanel.setStyleName(res.css().shelfFolderL2TitleActive());
			int widgetCount = contentVerPanel.getWidgetCount();
			AppClientFactory.fireEvent(new RefreshLevelFolderInShelfListEvent(
					collectionItemDo.getResource().getGooruOid(),
					RefreshType.UPDATE, FOLDER_LEVEL, collectionItemDo
							.getItemSequence(), true));
			if (collectionItemDo.getResource().getResourceType().getName()
					.equals("folder")
					&& widgetCount == 0) {
				/*
				 * wrapperFocPanel.setStyleName(res.css().
				 * shelfContentWrapperPanelForFolders());
				 * contentVerPanel.setStyleName
				 * (res.css().shelfContentPanelForFolders());
				 */
				String gooruOId = folderL2TitleLbl.getElement().getId();
				AppClientFactory
						.getInjector()
						.getfolderService()
						.getFolders(gooruOId,
								new SimpleAsyncCallback<List<CollectionItemDo>>() {
									@Override
									public void onSuccess(
											List<CollectionItemDo> result) {
										if (result.size() == 0) {
											htmlPanel = new HTMLPanel(
													i18n.GL0989());
											htmlPanel
													.getElement()
													.getStyle()
													.setTextAlign(
															TextAlign.CENTER);
											htmlPanel.getElement().getStyle()
													.setMarginLeft(19, Unit.PX);
											htmlPanel.getElement().getStyle()
													.setColor("#999999");
											htmlPanel.getElement().setId(
													collectionItemDo
															.getResource()
															.getGooruOid());
											contentVerPanel.add(htmlPanel);
										}
										for (CollectionItemDo collectionFolderItems : result) {
											addFolderItems(collectionFolderItems);
										}
									}
								});
			}
			if (collectionItemDo.getResource().getResourceType().getName()
					.equals("scollection")
					&& widgetCount == 0) {
				AppClientFactory
						.getInjector()
						.getResourceService()
						.getCollection(
								collectionItemDo.getResource().getGooruOid(),
								false, new SimpleAsyncCallback<CollectionDo>() {
									@Override
									public void onSuccess(CollectionDo result) {
										setL2FoldersData(result);
									}
								});
			}
			if (collectionItemDo.getResource().getResourceType().getName()
					.equalsIgnoreCase("folder")) {
				Map<String, String> params = new HashMap<String, String>();
				params.put("level", "2");
				params.put("folderid", folderL2TitleLbl.getElement().getId());
				String currentNameToken = AppClientFactory.getPlaceManager()
						.getCurrentPlaceRequest().getNameToken();

				if (currentNameToken.equalsIgnoreCase(PlaceTokens.EDIT_FOLDERS)
						|| currentNameToken
								.equalsIgnoreCase(PlaceTokens.FOLDERS) || currentNameToken.equalsIgnoreCase(PlaceTokens.SHELF)) {
					AppClientFactory.getPlaceManager().revealPlace(
							PlaceTokens.EDIT_FOLDERS, params, true);
				}
			}

			setOpen();
		} else if (event.getSource().equals(wrapperFocPanel)) {
			if (!getDropController().isDropActive()) {
				// Set default tabFlag in persistant store for Collection Edit
				Storage stockStore = Storage.getLocalStorageIfSupported();
				if (stockStore != null) {
					stockStore.setItem("tabKey", "resourceTab");
				}
				if (collectionItemDo.getResource().getResourceType().getName()
						.equalsIgnoreCase("scollection")) {
					AppClientFactory.fireEvent(new RequestShelfEvent(
							collectionItemDo.getResource().getGooruOid()));
				}
			}
		}
	}

	public void setL2FoldersData(CollectionDo collectionDo) {
		if (collectionDo.getCollectionItems().size() > 0) {
			for (CollectionItemDo collectionItem : collectionDo
					.getCollectionItems()) {
				addCollectionItem(collectionItem, false);
			}
		} else {
			if (collectionDo.getCollectionType().equals("folder")) {
				htmlPanel = new HTMLPanel(i18n.GL0989());
			} else if (collectionDo.getCollectionType().equals("collection")) {
				htmlPanel = new HTMLPanel(i18n.GL0854());
			}

			htmlPanel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
			htmlPanel.getElement().getStyle().setMarginLeft(19, Unit.PX);
			htmlPanel.getElement().getStyle().setColor("#999999");
			htmlPanel.getElement().getStyle().setFontStyle(FontStyle.ITALIC);
			htmlPanel.getElement().setId(collectionDo.getGooruOid());
			contentVerPanel.add(htmlPanel);
		}
	}

	/*public void setEmptyData() {
		htmlPanel = new HTMLPanel("This folder is empty!");
		htmlPanel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		htmlPanel.getElement().getStyle().setMarginLeft(19, Unit.PX);
		htmlPanel.getElement().getStyle().setColor("#999999");
		htmlPanel.getElement().getStyle().setFontStyle(FontStyle.ITALIC);
		htmlPanel.getElement().setId(
				collectionItemDo.getResource().getGooruOid());
		contentVerPanel.add(htmlPanel);
	}*/

	/*public void removeEmptyData() {
		if (contentVerPanel.getWidget(0) instanceof HTMLPanel) {
			contentVerPanel.clear();
		}
	}*/

	protected void addFolderItems(CollectionItemDo collectionFolderItems) {
		ThirdLevelFolderResource folderResource = new ThirdLevelFolderResource(
				collectionFolderItems);
		int widgetCount = contentVerPanel.getWidgetCount();
		int sequence = collectionFolderItems.getItemSequence() - 1;
		contentVerPanel.insert(folderResource,
				widgetCount > 0 ? sequence >= widgetCount ? widgetCount
						: sequence : 0);

	}

	public VerticalPanel getContentVerPanel() {
		return contentVerPanel;
	}

	public void setOpen() {
		if (folderResource == null || !folderResource.equals(this)) {
			glassContainer.setGlassText(EDIT_THIS_COLLECTION);
			glassContainer.getElement().setAttribute("alt", EDIT_THIS_COLLECTION);
			glassContainer.getElement().setAttribute("title", EDIT_THIS_COLLECTION);
			if (folderResource != null) {
				folderResource.setOpen(false);
				folderResource.L1titleFocPanel.setStyleName(res.css()
						.shelfCollectionTitle());
			}
			folderResource = this;
			setOpen(!isOpen());
		} else if (folderResource != null) {
			folderResource.enableGlassPanel(false);
		}
	}

	public void setOpen(boolean isOpen) {
		folderL2DisPanel.setOpen(isOpen);
	}

	public boolean isOpen() {
		return folderL2DisPanel.isOpen();
	}

	public void enableGlassPanel(boolean enable) {
		glassContainer.setGlassVisible(enable);
	}

	public ResourceDropController getDropController() {
		return dropController;
	}

	public void setDropController(ResourceDropController dropController) {
		this.dropController = dropController;
	}

	@Override
	public void onMouseOver(MouseOverEvent event) {
		if (event.getSource().equals(wrapperFocPanel)) {
			if (!getDropController().isDropActive()) {
				if (collectionItemDo.getResource().getResourceType().getName()
						.equalsIgnoreCase("scollection")) {
					glassContainer.setGlassText(EDIT_THIS_COLLECTION);
					glassContainer.getElement().setAttribute("alt", EDIT_THIS_COLLECTION);
					glassContainer.getElement().setAttribute("title", EDIT_THIS_COLLECTION);
					glassContainer.setGlassVisible(true);
				}

			}
		}

	}

	@Override
	public void onDrop(Draggable draggable) {
		this.draggable = draggable;
		AppClientFactory.fireEvent(new DisableDraggableEvent("1",
				"SimpleCollection"));
		if (draggable.getType().equals(DRAG_TYPE.RESOURCE)) {
			setOpen();
			if (collectionItemDo.getResource().getResourceType().getName()
					.equalsIgnoreCase("folder")) {
				new AleartPopupVc();
			}
			if (getCollectionItemDo().getCollection().getCollectionItems()
					.size() < 25) {
				Document doc = Document.get();
				if (doc.getElementById(getCollectionItemDo().getCollection()
						.getGooruOid()) != null)
					doc.getElementById(
							getCollectionItemDo().getCollection().getGooruOid())
							.removeFromParent();
				AppClientFactory.fireEvent(new CreateCollectionItemEvent(
						getCollectionItemDo().getCollection().getGooruOid(),
						draggable.getDragId()));
			} else {
				   alertContentUc = new AlertContentUc(
						   i18n.GL0061(),
						   i18n.GL0302());
			}
		} else if (draggable.getType().equals(DRAG_TYPE.COLLECTION)) {
			AppClientFactory.fireEvent(new CreateCollectionItemInFoldersEvent(
					collectionItemDo.getResource().getGooruOid(), draggable
							.getDragId(), "2"));
		}
	}

	@Override
	public void onDragOver(Draggable draggable) {
		this.draggable = draggable;
		if (collectionItemDo.getResource().getResourceType().getName()
				.equalsIgnoreCase("scollection")) {
			glassContainer.setGlassText(ADD_TO_THIS_COLLECTION);
			glassContainer.getElement().setAttribute("alt", ADD_TO_THIS_COLLECTION);
			glassContainer.getElement().setAttribute("title", ADD_TO_THIS_COLLECTION);
			glassContainer.setGlassVisible(true);
			if (draggable.getType().equals(DRAG_TYPE.RESOURCE)) {
				draggable.getDraggableMirageUc().onDroppable(true);
			}
		} else if (collectionItemDo.getResource().getResourceType().getName()
				.equalsIgnoreCase("folder")) {
			glassContainer.setGlassVisible(false);
			if (draggable.getType().equals(DRAG_TYPE.COLLECTION)) {
				draggable.getDraggableMirageUc().onDroppable(true);
			}
		} else {
			glassContainer.setGlassVisible(false);
			if (draggable.getType().equals(DRAG_TYPE.RESOURCE)) {
				draggable.getDraggableMirageUc().onDroppable(false);
			}
		}
	}

	@Override
	public void onDragOut(Draggable draggable) {
		this.draggable = draggable;
		glassContainer.setGlassVisible(false);
		if (draggable.getType().equals(DRAG_TYPE.RESOURCE)) {
			draggable.getDraggableMirageUc().onDroppable(false);
		}

	}

	/*public void disableDraggableOnDrop() {
		this.draggable.getDraggableMirageUc().onDroppable(false);
	}*/

	@Override
	public Widget getDropTarget() {
		return this;
	}

	@Override
	public void registerDropController() {
		AppClientFactory.fireEvent(new RegisterSearchDropEvent(dropController,
				RegisterSearchDropEvent.DROP_AREA.COLLECTION));
	}

	@Override
	protected void onLoad() {
		super.onLoad();
		registerDropController();
	}

	@Override
	protected void onUnload() {
		super.onUnload();
		unregisterDropController();
	}

	@Override
	public void unregisterDropController() {
		AppClientFactory.fireEvent(new UnregisterSearchDropEvent(
				dropController, RegisterSearchDropEvent.DROP_AREA.COLLECTION));
	}

	@Override
	public void reregisterDropController() {
		unregisterDropController();
		registerDropController();
	}

	/*public void setOpenFolder() {
		
		L1titleFocPanel.setStyleName(res.css().shelfFolderL2TitleActive());
		int widgetCount = contentVerPanel.getWidgetCount();
		if(collectionItemDo.getResource().getResourceType().getName().equals("folder")&& widgetCount==0){
			wrapperFocPanel.setStyleName(res.css().shelfContentWrapperPanelForFolders()); 
			contentVerPanel.setStyleName(res.css().shelfContentPanelForFolders());
			String gooruOId =  folderL2TitleLbl.getElement().getId();
			AppClientFactory.getInjector().getfolderService().getFolders(gooruOId, new AsyncCallback<List<CollectionItemDo>>() {
				@Override
				public void onSuccess(List<CollectionItemDo> result) {
					if(result.size()==0)
					{
						htmlPanel = new HTMLPanel("This folder is empty!");
						htmlPanel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
						htmlPanel.getElement().getStyle().setMarginLeft(19, Unit.PX);
						htmlPanel.getElement().getStyle().setFontStyle(FontStyle.ITALIC);
						htmlPanel.getElement().getStyle().setColor("#999999");
						htmlPanel.getElement().setId(collectionItemDo.getResource().getGooruOid());
						contentVerPanel.add(htmlPanel);
					}
					for(CollectionItemDo collectionFolderItems:result)
					{
						addFolderItems(collectionFolderItems); 
					}
				}
				
				@Override
				public void onFailure(Throwable caught) {
				}
			});
		}else if(collectionItemDo.getResource().getResourceType().getName().equals("scollection")||collectionItemDo.getResource().getResourceType().getName().equals("collection")){
			htmlPanel = new HTMLPanel("This collection is empty!");
			htmlPanel.getElement().getStyle()
					.setTextAlign(TextAlign.CENTER);
			htmlPanel.getElement().getStyle().setMarginLeft(19, Unit.PX);
			htmlPanel.getElement().getStyle().setColor("#999999");
			htmlPanel.getElement().getStyle()
					.setFontStyle(FontStyle.ITALIC);
			htmlPanel.getElement().setId(collectionItemDo.getResource().getGooruOid());
			contentVerPanel.add(htmlPanel);
		}

		setOpen();
	}*/
}
