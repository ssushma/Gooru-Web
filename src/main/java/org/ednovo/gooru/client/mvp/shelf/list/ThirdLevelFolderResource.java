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
import org.ednovo.gooru.application.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.mvp.dnd.Draggable;
import org.ednovo.gooru.client.mvp.dnd.DropBox;
import org.ednovo.gooru.client.mvp.dnd.IsDraggable.DRAG_TYPE;
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

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Float;
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

public class ThirdLevelFolderResource extends FocusPanel implements ClickHandler,MouseOverHandler,DropBox {
	private static ThirdLevelFolderResourceUiBinder uiBinder = GWT.create(ThirdLevelFolderResourceUiBinder.class);

	private static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	interface ThirdLevelFolderResourceUiBinder extends UiBinder<Widget,ThirdLevelFolderResource>{
		
	}
	@UiField
	HTML folderL3TitleLbl; 
	
	@UiField
	FlowPanel  thirdLevelFolders,collectionIcon,folderL3Icon;
	
	@UiField
	FocusPanel L3titleFocPanel;
	
	@UiField
	DisclosurePanel folderL3DisPanel;
	
	@UiField
	LabelGlassPanel glassContainer;
	
	@UiField
	FocusPanel wrapperFocPanel;
	
	@UiField
	VerticalPanel contentVerPanel;
	
	@UiField Label blueLbl,greyLbl;
	
	HTMLPanel htmlPanel;
	
	private ResourceDropController dropController;
	
	@UiField(provided = true)
	ShelfListCBundle res;
	
	private static final String EDIT_THIS_COLLECTION = i18n.GL0991();
	private static final String ADD_TO_THIS_COLLECTION =i18n.GL0990();
	
	private CollectionItemDo collectionItemDo = null;
	private static ThirdLevelFolderResource thirdLevelFolderResource;
	
	private static final String FOLDER_LEVEL = "3";
	
	public ThirdLevelFolderResource(CollectionItemDo collectionItem) {
		res = ShelfListCBundle.INSTANCE; 
		res.css().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));
//		this.setCollectionItemDo(collectionItem);
		glassContainer.setGlassText(i18n.GL0991());
		glassContainer.getElement().setId("GlassContainer");
		glassContainer.getElement().setAttribute("alt", i18n.GL0991());
		glassContainer.getElement().setAttribute("title", i18n.GL0991());
		this.collectionItemDo = collectionItem;
		glassContainer.setGlassVisible(false);
		this.setStyleName(ShelfListCBundle.INSTANCE.css().shelfResourcePanel());
		thirdLevelFolders.getElement().setId("fpnlThirdLevelFolders");
		thirdLevelFolders.getElement().getStyle().setFloat(Float.LEFT);
		L3titleFocPanel.getElement().setId("focuspnlL3titleFocPanel");
		collectionIcon.getElement().setId("fpnlCollectionIcon");
		blueLbl.getElement().setId("lblBlueLbl");
		greyLbl.getElement().setId("lblGreyLbl");
		folderL3Icon.getElement().setId("fpnlFolderL3Icon");
		folderL3DisPanel.getElement().setId("discpnlFolderL3DisPanel");
		wrapperFocPanel.getElement().setId("focuspnlWrapperFocPanel");
		contentVerPanel.getElement().setId("vpnlContentVerPanel");
		L3titleFocPanel.addClickHandler(this);
		wrapperFocPanel.addMouseOverHandler(this);
		wrapperFocPanel.addMouseOutHandler(new MouseOutHandler(){

			@Override
			public void onMouseOut(MouseOutEvent event) {
				if (!getDropController().isDropActive()) {
					glassContainer.setGlassVisible(false);
				}				
			}
			
		});
		dropController = new ResourceDropController(this);
		wrapperFocPanel.addClickHandler(this);
		this.setData(collectionItem);
	}
	
	
	private void setData(CollectionItemDo collectionItem) {
		if (collectionItem.getResource().getTitle() != null && collectionItem.getResource().getTitle().length() > 0) {
			if(collectionItem.getResource().getResourceType().getName().equalsIgnoreCase("folder")){
				collectionIcon.removeFromParent();
			} else if(collectionItem.getResource().getResourceType().getName().equalsIgnoreCase("scollection")) {
				folderL3Icon.removeFromParent();
			}
			L3titleFocPanel.getElement().setAttribute("collectionType", collectionItem.getResource().getResourceType().getName());
		//	folderL3TitleLbl.setText(StringUtil.truncateText(collectionItem.getResource().getTitle(), 30));
			folderL3TitleLbl.setHTML(StringUtil.truncateText(collectionItem.getResource().getTitle(), 30));
			folderL3TitleLbl.getElement().setAttribute("alt", collectionItem.getResource().getTitle());
			folderL3TitleLbl.getElement().setAttribute("title", collectionItem.getResource().getTitle());
			
			folderL3TitleLbl.getElement().setId(collectionItem.getResource().getGooruOid());
		}else {
			folderL3TitleLbl.setText("--");
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
		if (event.getSource().equals(L3titleFocPanel)) 
		{
			L3titleFocPanel.setStyleName(res.css().shelfCollectionTitleActive());
			int widgetCount = contentVerPanel.getWidgetCount();
			AppClientFactory.fireEvent(new RefreshLevelFolderInShelfListEvent(collectionItemDo.getResource().getGooruOid(), RefreshType.UPDATE,FOLDER_LEVEL,collectionItemDo.getItemSequence(),true));
			if(collectionItemDo.getResource().getResourceType().getName().equals("folder")&&widgetCount==0)
			{
				String gooruOId =  folderL3TitleLbl.getElement().getId();
				AppClientFactory.getInjector().getfolderService().getFolders(gooruOId, new SimpleAsyncCallback<List<CollectionItemDo>>() {
					@Override
					public void onSuccess(List<CollectionItemDo> result) {
						if(result.size()==0)
						{
							htmlPanel = new HTMLPanel(i18n.GL0989());
							htmlPanel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
							htmlPanel.getElement().getStyle().setMarginLeft(19, Unit.PX);
							htmlPanel.getElement().getStyle().setColor("#999999");
							htmlPanel.getElement().setId(collectionItemDo.getResource().getGooruOid());
							contentVerPanel.add(htmlPanel);
						}
						for(CollectionItemDo collectionFolderItems:result)
						{
							addFolderItems(collectionFolderItems); 
						}
					}
					
				});
			}
			setOpen();
			String currentNameToken = AppClientFactory.getPlaceManager()
					.getCurrentPlaceRequest().getNameToken();

			if (currentNameToken.equalsIgnoreCase(PlaceTokens.EDIT_FOLDERS)
					|| currentNameToken.equalsIgnoreCase(PlaceTokens.FOLDERS) || currentNameToken.equalsIgnoreCase(PlaceTokens.SHELF)) {
				Map<String, String> params = new HashMap<String, String>();
				params.put("level", "3");
				params.put("folderid", folderL3TitleLbl.getElement().getId());
				AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.EDIT_FOLDERS, params,true);
			}
		}else if (event.getSource().equals(wrapperFocPanel)) {
//			AppClientFactory.fireEvent(new RequestShelfEvent(collectionItemDo.getResource().getGooruOid()));
			if (!getDropController().isDropActive()) 
			 {
				// Set default tabFlag in persistant store for Collection Edit
					Storage stockStore = Storage.getLocalStorageIfSupported();
					if (stockStore != null) {
						stockStore.setItem("tabKey", "resourceTab");
					}
					if(collectionItemDo.getResource().getResourceType().getName().equalsIgnoreCase("scollection")) {
						AppClientFactory.fireEvent(new RequestShelfEvent(collectionItemDo.getResource().getGooruOid()));
					}
			 }
		}
		 
	}
	
	protected void addFolderItems(CollectionItemDo collectionFolderItems) { 
		ThirdLevelFolderResourceData folderResource = new ThirdLevelFolderResourceData(collectionFolderItems); 
		int widgetCount = contentVerPanel.getWidgetCount();
		int sequence = collectionFolderItems.getItemSequence() - 1;
		contentVerPanel.insert(folderResource,widgetCount > 0 ? sequence >= widgetCount ? widgetCount: sequence : 0);
		
	}
	

	
	/*public void setEmptyData() {
		htmlPanel = new HTMLPanel("This folder is empty!");
		htmlPanel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		htmlPanel.getElement().getStyle().setMarginLeft(19, Unit.PX);
		htmlPanel.getElement().getStyle().setColor("#999999");
		htmlPanel.getElement().getStyle().setFontStyle(FontStyle.ITALIC);
		htmlPanel.getElement().setId(collectionItemDo.getResource().getGooruOid());
		contentVerPanel.add(htmlPanel);
	}

	public void removeEmptyData() {
		  if (contentVerPanel.getWidget(0) instanceof HTMLPanel) {
			  contentVerPanel.clear();
		  }
	}
	
	public void setOpenFolder() {
		L3titleFocPanel.setStyleName(res.css().shelfCollectionTitleActive());
		int widgetCount = contentVerPanel.getWidgetCount();
		if(collectionItemDo.getResource().getResourceType().getName().equals("folder")&&widgetCount==0)
		{
			String gooruOId =  folderL3TitleLbl.getElement().getId();
			AppClientFactory.getInjector().getfolderService().getFolders(gooruOId, new AsyncCallback<List<CollectionItemDo>>() {
				@Override
				public void onSuccess(List<CollectionItemDo> result) {
					if(result.size()==0)
					{
						htmlPanel = new HTMLPanel("This folder is empty!");
						htmlPanel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
						htmlPanel.getElement().getStyle().setMarginLeft(19, Unit.PX);
						htmlPanel.getElement().getStyle().setColor("#999999");
						htmlPanel.getElement().getStyle().setFontStyle(FontStyle.ITALIC);
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
		}else  if(collectionItemDo.getResource().getResourceType().getName().equals("scollection")||collectionItemDo.getResource().getResourceType().getName().equals("collection")){
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
	}
	
	
	public void addCollectionItem(CollectionItemDo collectionItemDo,boolean isNew) {
		if (isNew) {
			if (this.collectionDo.getCollectionItems() == null) {
				this.collectionDo.setCollectionItems(new ArrayList<CollectionItemDo>());
			}
			this.collectionDo.getCollectionItems().add(collectionItemDo);
		}
		ShelfResource shelfResource  = new ShelfResource(collectionItemDo);
		int widgetCount = contentVerPanel.getWidgetCount();
		int sequence = collectionItemDo.getItemSequence() - 1;
		contentVerPanel.insert(shelfResource,widgetCount > 0 ? sequence >= widgetCount ? widgetCount: sequence : 0);
		if (isNew) {
			shelfResource.glowTitle();
		}
	}*/

	public VerticalPanel getContentVerPanel(){
		return contentVerPanel;
	}

	public void setOpen() {
		if (thirdLevelFolderResource == null || !thirdLevelFolderResource.equals(this)) {
			glassContainer.setGlassText(EDIT_THIS_COLLECTION);
			glassContainer.getElement().setAttribute("alt", EDIT_THIS_COLLECTION);
			glassContainer.getElement().setAttribute("title", EDIT_THIS_COLLECTION);
			if (thirdLevelFolderResource != null) {
				thirdLevelFolderResource.setOpen(false);
				thirdLevelFolderResource.L3titleFocPanel.setStyleName(res.css().shelfCollectionTitle()); 
			}
			thirdLevelFolderResource = this;
			setOpen(!isOpen());
		} else if (thirdLevelFolderResource != null) {
			thirdLevelFolderResource.enableGlassPanel(false);
		}
	}
	
	public void setOpen(boolean isOpen) {
		folderL3DisPanel.setOpen(isOpen);
	}

	public boolean isOpen() {
		return folderL3DisPanel.isOpen();
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
				if(collectionItemDo.getResource().getResourceType().getName().equalsIgnoreCase("scollection"))
				{
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
		AppClientFactory.fireEvent(new DisableDraggableEvent("1", "SimpleCollection"));
		AppClientFactory.fireEvent(new DisableDraggableEvent("2", "FolderResource"));
		if (draggable.getType().equals(DRAG_TYPE.RESOURCE)) {
			setOpen();
			if (getCollectionItemDo().getCollection().getCollectionItems().size() < 25) {
				Document doc = Document.get();
				if (doc.getElementById(getCollectionItemDo().getCollection().getGooruOid()) != null)
					doc.getElementById(getCollectionItemDo().getCollection().getGooruOid()).removeFromParent();
				AppClientFactory.fireEvent(new CreateCollectionItemEvent(getCollectionItemDo().getCollection().getGooruOid(), draggable.getDragId()));
			}else{
				AlertContentUc alertContentUc = new AlertContentUc(i18n.GL0061(),i18n.GL0302());
			}
		} else if (draggable.getType().equals(DRAG_TYPE.COLLECTION)) {
			AppClientFactory.fireEvent(new CreateCollectionItemInFoldersEvent(
					folderL3TitleLbl.getElement().getId(), draggable
							.getDragId(), "3"));
		}
	}

	@Override
	public void onDragOver(Draggable draggable) {
		glassContainer.setGlassText(ADD_TO_THIS_COLLECTION);
		glassContainer.getElement().setAttribute("alt", ADD_TO_THIS_COLLECTION);
		glassContainer.getElement().setAttribute("title", ADD_TO_THIS_COLLECTION);
		glassContainer.setGlassVisible(true);
		if (draggable.getType().equals(DRAG_TYPE.RESOURCE)) {
			draggable.getDraggableMirageUc().onDroppable(true);
		} else if(collectionItemDo.getResource().getResourceType().getName().equalsIgnoreCase("folder")){
			glassContainer.setGlassVisible(false);
			if (draggable.getType().equals(DRAG_TYPE.COLLECTION)) {
				draggable.getDraggableMirageUc().onDroppable(true);
			}
		}
	}

	@Override
	public void onDragOut(Draggable draggable) {
		glassContainer.setGlassVisible(false);
		if (draggable.getType().equals(DRAG_TYPE.RESOURCE)) {
			draggable.getDraggableMirageUc().onDroppable(false);
		}		
	}


	@Override
	public Widget getDropTarget() {
		return this;
	}


	@Override
	public void registerDropController() {
		AppClientFactory.fireEvent(new RegisterSearchDropEvent(dropController,RegisterSearchDropEvent.DROP_AREA.COLLECTION));		
	}


	@Override
	public void unregisterDropController() {
		AppClientFactory.fireEvent(new UnregisterSearchDropEvent(dropController, RegisterSearchDropEvent.DROP_AREA.COLLECTION));		
	}


	@Override
	public void reregisterDropController() {
		unregisterDropController();
		registerDropController();		
	}

}
