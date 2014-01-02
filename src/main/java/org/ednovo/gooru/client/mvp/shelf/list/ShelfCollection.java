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
package org.ednovo.gooru.client.mvp.shelf.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.effects.FontWeightEffect;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.dnd.Draggable;
import org.ednovo.gooru.client.mvp.dnd.DropBox;
import org.ednovo.gooru.client.mvp.dnd.IsDraggable.DRAG_TYPE;
import org.ednovo.gooru.client.mvp.resource.dnd.ResourceDropController;
import org.ednovo.gooru.client.mvp.search.event.RegisterSearchDropEvent;
import org.ednovo.gooru.client.mvp.search.event.UnregisterSearchDropEvent;
import org.ednovo.gooru.client.mvp.shelf.event.CreateCollectionItemEvent;
import org.ednovo.gooru.client.mvp.shelf.event.RequestShelfEvent;
import org.ednovo.gooru.client.mvp.shelf.event.UserInfoMsgShelfEvent;
import org.ednovo.gooru.client.uc.AlertContentUc;
import org.ednovo.gooru.client.uc.LabelGlassPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.player.resource.client.view.resourceplayer.CustomAnimation;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.FontStyle;
import com.google.gwt.dom.client.Style.FontWeight;
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
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : ShelfCollection.java
 *
 * @description : This is used to describe the collections in shelf
 *
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public class ShelfCollection extends FocusPanel implements DropBox,
		MouseOverHandler, ClickHandler {

	private static ShelfCollectionUiBinder uiBinder = GWT
			.create(ShelfCollectionUiBinder.class);

	interface ShelfCollectionUiBinder extends UiBinder<Widget, ShelfCollection> {
	}

	@UiField
	HTML titleLbl;

	@UiField
	VerticalPanel contentVerPanel;

	@UiField(provided = true)
	ShelfListCBundle res;

	@UiField
	LabelGlassPanel glassContainer;

	@UiField
	FocusPanel titleFocPanel;

	@UiField
	FocusPanel wrapperFocPanel;

	@UiField
	DisclosurePanel disPanel;

	@UiField
	FlowPanel folderIcon, collectionIcon;

	@UiField
	Label addSuccessMsg;
	
	@UiField
	Button myShelfEditButton;
	
	private CollectionDo collectionDo;

	private CollectionItemDo collectionItemDo;

	private ResourceDropController dropController;

	//private static final String ADD_TO_THIS_COLLECTION = "Add to this Collection";

//	private static final String ADD_TO_THIS_COLLECTION = "Drag a resource here to add to this collection";
	
//	private static final String EDIT_THIS_COLLECTION = "Drop resource here";
	
	private final String CONGRATS_MSG="congrats";

	//private static final String EDIT_THIS_COLLECTION = "Edit this Collection";

	private static final String FOLDER_LEVEL = "1";

	private static ShelfCollection shelfCollection;
	
	private boolean isEditButtonSelected = false;

	HTMLPanel htmlPanel;

	private Draggable draggable;
	
	private boolean isValue=true;
	

	/**
	 * Class constructor , assign the {@link CollectionDo} instance
	 * 
	 * @param collectionDo
	 *            instance of {@link CollectionDo}
	 */
	public ShelfCollection(final CollectionDo collectionDo) {
		res = ShelfListCBundle.INSTANCE;
		res.css().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));
		myShelfEditButton.getElement().setId("btnMyShelfEdit");
		glassContainer.setGlassVisible(false);
		setData(collectionDo);
		this.getElement().setAttribute("style", "min-height: 42px;");
		dropController = new ResourceDropController(this);
		titleFocPanel.addClickHandler(this);
		titleFocPanel.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				if(!isEditButtonSelected) {
					if(!AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.SHELF)) {
						myShelfEditButton.getElement().getStyle().setDisplay(Display.BLOCK);
					}
				}
			}
		});
		titleFocPanel.addMouseOutHandler(new MouseOutHandler() {
			@Override
			public void onMouseOut(MouseOutEvent event) {
				if(!isEditButtonSelected) {
					if(!AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.SHELF)) {
						myShelfEditButton.getElement().getStyle().setDisplay(Display.NONE);
					}
				}
			}
		});
		
		wrapperFocPanel.addMouseOverHandler(this);
		wrapperFocPanel.addMouseOutHandler(new MouseOutHandler() {

			@Override
			public void onMouseOut(MouseOutEvent event) {
				if (!getDropController().isDropActive()) {
					glassContainer.setGlassVisible(false);
				}
			}
		});
		addSuccessMsg.setVisible(false);
		addSuccessMsg.setText("adding...");
		wrapperFocPanel.addClickHandler(this);
	}

	@UiHandler("myShelfEditButton")
	public void myShelfEditButtonHandler(ClickEvent event){
		
		isValue=false;
		AppClientFactory.fireEvent(new RequestShelfEvent(collectionDo.getGooruOid()));
			
	}
	/**
	 * 
	 * @function setData 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :It sets the data in to collection
	 * 
	 * 
	 * @parm(s) : @param collectionDo
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setData(CollectionDo collectionDo) {
		updateData(collectionDo);
		if (this.collectionDo.getCollectionItems() == null) {
			this.collectionDo
					.setCollectionItems(new ArrayList<CollectionItemDo>());
		}
		if (collectionDo.getCollectionItems().size() > 0) {
			for (CollectionItemDo collectionItem : collectionDo
					.getCollectionItems()) {
				addCollectionItem(collectionItem, false);
			}
		} else {
/*			if (collectionDo.getCollectionType().equals("folder")) {
				htmlPanel = new HTMLPanel("This folder is empty!");
			} else if (collectionDo.getCollectionType().equals("collection")) {
				htmlPanel = new HTMLPanel("This collection is empty!");
			}
 */         htmlPanel = new HTMLPanel("This collection is empty!");
			htmlPanel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
			htmlPanel.getElement().getStyle().setMarginLeft(19, Unit.PX);
			htmlPanel.getElement().getStyle().setColor("#999999");
			htmlPanel.getElement().getStyle().setFontStyle(FontStyle.ITALIC);
			htmlPanel.getElement().setId(collectionDo.getGooruOid());
			contentVerPanel.add(htmlPanel);
		}
	}
/**
 * 
 * @function setEmptyData 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :It empty's the data.
 * 
 * 
 * @parm(s) : 
 * 
 * @return : void
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	public void setEmptyData() {
		htmlPanel = new HTMLPanel("This folder is empty!");
		htmlPanel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		htmlPanel.getElement().getStyle().setMarginLeft(19, Unit.PX);
		htmlPanel.getElement().getStyle().setColor("#999999");
		htmlPanel.getElement().setId(collectionDo.getGooruOid());
		contentVerPanel.add(htmlPanel);
	}
/**
 * 
 * @function removeEmptyData 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :It removes the empty data
 * 
 * 
 * @parm(s) : 
 * 
 * @return : void
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	public void removeEmptyData() {
		if (contentVerPanel.getWidget(0) instanceof HTMLPanel) {
			contentVerPanel.clear();
		}
	}

	/**
	 * Update collection information
	 * 
	 * @param collectionDo
	 *            instance of {@link CollectionDo}
	 */
	public void updateData(CollectionDo collectionDo) {
		this.collectionDo = collectionDo;
		// titleLbl.setText(StringUtil.truncateText(collectionDo.getTitle(),
		// 30));
//		titleLbl.setHTML(StringUtil.truncateText(collectionDo.getTitle(), 30));
		// titleLbl.setText(StringUtil.truncateText(collectionDo.getTitle(),
		// 30));
		titleLbl.setHTML(collectionDo.getTitle());
		if (collectionDo.getCollectionType().equalsIgnoreCase("folder")) {
			collectionIcon.removeFromParent();
		} else if (collectionDo.getCollectionType().equalsIgnoreCase(
				"collection")) {
			folderIcon.removeFromParent();
		}
	}

	/**
	 * Update collection item
	 * 
	 * @param collectionItemDo
	 *            instance of {@link CollectionItemDo}
	 */
	public void updateCollectionItem(CollectionItemDo collectionItemDo) {
		this.collectionItemDo = collectionItemDo;
		ShelfResource shelfResource = getShelfResource(collectionItemDo	.getCollectionItemId());
		int widgetCount = contentVerPanel.getWidgetCount();

		int sequence = collectionItemDo.getItemSequence() - 1;
		if (collectionItemDo.getItemSequence() > sequence) {
			contentVerPanel.insert(shelfResource,
					widgetCount > 0 ? sequence >= widgetCount ? widgetCount
							: (sequence + 1) : 0);
		}
		if (sequence < collectionItemDo.getItemSequence()) {
			contentVerPanel.insert(shelfResource,
					widgetCount > 0 ? sequence >= widgetCount ? widgetCount
							: sequence : 0);
		}

		// contentVerPanel.insert(shelfResource,widgetCount > 0 ? sequence >=
		// widgetCount ? widgetCount: sequence : 0);
		shelfResource.glowTitle();
	}

	/**
	 * Create new collection item to collection
	 * 
	 * @param collectionItemDo
	 *            which is to be added to collection
	 * @param isNew
	 *            check new collection or exists collection
	 */
	public void addCollectionItem(CollectionItemDo collectionItemDo,
			boolean isNew) {
		Document doc = Document.get();
        if (doc.getElementById(collectionDo.getGooruOid()) != null)
            doc.getElementById(collectionDo.getGooruOid())
                    .removeFromParent();
		if (isNew) {
			if (this.collectionDo.getCollectionItems() == null) {
				this.collectionDo.setCollectionItems(new ArrayList<CollectionItemDo>());
			}
			this.collectionDo.getCollectionItems().add(collectionItemDo);
		}
		ShelfResource shelfResource = new ShelfResource(collectionItemDo);
		int widgetCount = contentVerPanel.getWidgetCount();
		int sequence = collectionItemDo.getItemSequence() - 1;
		if (collectionDo.getCollectionType().equals("collection")) {
			contentVerPanel.insert(shelfResource,widgetCount > 0 ? sequence >= widgetCount ? widgetCount: sequence : 0);
		}
		if (isNew) {
			addSuccessMsg.setVisible(false);
			contentVerPanel.setVisible(true);
			shelfResource.glowTitle();
	            if(contentVerPanel.getWidgetCount()==2 && (AppClientFactory.getCurrentPlaceToken().equals(PlaceTokens.RESOURCE_SEARCH))){
	        		AppClientFactory.fireEvent(new UserInfoMsgShelfEvent(CONGRATS_MSG));
	        	}
		}
	}

	/**
	 * Remove the collection item from the collection
	 * 
	 * @param collectionItemDo
	 *            which is to be removed
	 */
	public void removeCollectionItem(CollectionItemDo collectionItemDo) {
		this.collectionDo.getCollectionItems().remove(collectionItemDo);
		//this.collectionDo.getCollectionItems().remove(1);
		ShelfResource shelfResource = getShelfResource(collectionItemDo
				.getCollectionItemId());
		if (shelfResource != null) {
			contentVerPanel.remove(shelfResource);
		}
		if (collectionItemDo.getCollection().getCollectionItems().size() <= 0) {

			if (collectionDo.getCollectionType().equals("folder")) {
				htmlPanel = new HTMLPanel("This folder is empty!");
				htmlPanel.getElement().getStyle()
						.setTextAlign(TextAlign.CENTER);
				htmlPanel.getElement().getStyle().setMarginLeft(19, Unit.PX);
				htmlPanel.getElement().getStyle().setColor("#999999");
				htmlPanel.getElement().setId(collectionDo.getGooruOid());
				contentVerPanel.add(htmlPanel);
			} else if (collectionDo.getCollectionType().equals("collection")) {
				htmlPanel = new HTMLPanel("This collection is empty!");
				htmlPanel.getElement().getStyle()
						.setTextAlign(TextAlign.CENTER);
				htmlPanel.getElement().getStyle().setMarginLeft(19, Unit.PX);
				htmlPanel.getElement().getStyle().setColor("#999999");
				htmlPanel.getElement().getStyle()
						.setFontStyle(FontStyle.ITALIC);
				htmlPanel.getElement().setId(collectionDo.getGooruOid());
				contentVerPanel.add(htmlPanel);
			}

		}
		
				
	}

	/**
	 * Get collection item
	 * 
	 * @param collectionItemId
	 *            get collection by collection item id
	 * @return instance of {@link ShelfResource} as widget
	 */
	private ShelfResource getShelfResource(String collectionItemId) {
		Iterator<Widget> widgets = contentVerPanel.iterator();
		while (widgets.hasNext()) {
			Widget widget = widgets.next();
			if (widget instanceof ShelfResource
					&& ((ShelfResource) widget).getCollectionItemDo()
							.getCollectionItemId().equals(collectionItemId)) {
				return (ShelfResource) widget;
			}
		}
		return null;
	}
/**
 * @description: This is used to drag 
 */
	@Override
	public void onDragOver(Draggable draggable) {
	        if (draggable.getType().equals(DRAG_TYPE.RESOURCE)) {
	            draggable.getDraggableMirageUc().onDroppable(true);
//			 	glassContainer.setGlassText(ADD_TO_THIS_COLLECTION);
		        glassContainer.setGlassVisible(true);
	            this.setOpen();
	        }
	}

	/**
	 * @description: This method used to drag out after dragging
	 */
	@Override
	public void onDragOut(Draggable draggable) {
        glassContainer.setGlassVisible(false);
        if (draggable.getType().equals(DRAG_TYPE.RESOURCE)) {
            draggable.getDraggableMirageUc().onDroppable(false);
        }
    }
/**
 * @description: This widget gives support receiving events from browser and add them to panels
 */
	@Override
	public Widget getDropTarget() {
		return this;
	}
/**
 * @description:This is used to drop the event after dragging the event
 */
	@Override
	public void onDrop(Draggable draggable) {
        if (draggable.getType().equals(DRAG_TYPE.RESOURCE)) {
            //setOpen();
        	new CustomAnimation(draggable).run(50);
        	   	 
            if (collectionDo.getCollectionItems().size()<25) {
           	contentVerPanel.setVisible(false);
    		addSuccessMsg.setVisible(true);
    		Document doc = Document.get();
            if (doc.getElementById(collectionDo.getGooruOid()) != null)
                doc.getElementById(collectionDo.getGooruOid()).removeFromParent();
            AppClientFactory.fireEvent(new CreateCollectionItemEvent(collectionDo.getGooruOid(), draggable.getDragId()));
           
            }else{
            	AlertContentUc alertContentUc = new AlertContentUc("Oops!", "You've reached the limit of resources you can add to a collection!\n\nTip: Try dividing this into two collections.");
            }
        }
	}
/**
 * 
 * @function disableDraggableOnDrop 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :This is used to  disable the draggable on drop event
 * 
 * 
 * @parm(s) : 
 * 
 * @return : void
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	public void disableDraggableOnDrop() {
		this.draggable.getDraggableMirageUc().onDroppable(true);
	}
	/**
	 * 
	 * @function setOpen 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This is used to open the collection list
	 * 
	 * 
	 * @parm(s) : @param isOpen
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void setOpen(boolean isOpen) {
		if(isOpen) {
			this.titleFocPanel.removeStyleName(res.css().shelfCollectionTitle());
			this.titleFocPanel.setStyleName(res.css().shelfCollectionTitleActive());
			myShelfEditButton.getElement().getStyle().setDisplay(Display.BLOCK);
			isEditButtonSelected = true;
		} else {
			this.titleFocPanel.removeStyleName(res.css().shelfCollectionTitleActive());
			this.titleFocPanel.setStyleName(res.css().shelfCollectionTitle());
			myShelfEditButton.getElement().getStyle().setDisplay(Display.NONE);
			isEditButtonSelected = false;
		}
		setOpenStatus(false);
		disPanel.setOpen(isOpen);
	}
/**
 * 
 * @function isOpen 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :Checks whether the collection is opened or not
 * 
 * 
 * @parm(s) : @return
 * 
 * @return : boolean
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	public boolean isOpen() {
		return disPanel.isOpen();
	}
	/**
	 * 
	 * @function setOpenStatus 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :It sets the status whether it is opened or not
	 * 
	 * 
	 * @parm(s) : @param isNewPage
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	
	public void setOpenStatus(boolean isNewPage) {
		if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.SHELF)) {
			disPanel.getElement().getStyle().setDisplay(Display.NONE);
			myShelfEditButton.getElement().getStyle().setDisplay(Display.NONE);
		} else if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.RESOURCE_SEARCH)||AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.COLLECTION_SEARCH)){
			disPanel.getElement().getStyle().setDisplay(Display.BLOCK);
			if(isNewPage == true) {
				myShelfEditButton.getElement().getStyle().setDisplay(Display.BLOCK);
			}
		}
	}
	/**
	 * 
	 * @function enableGlassPanel 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :It enables the glass panel
	 * 
	 * 
	 * @parm(s) : @param enable
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void enableGlassPanel(boolean enable) {
		glassContainer.setGlassVisible(enable);
	}
/**
 * @description:It events the MouseOver event when it is fired
 */
	@Override
	public void onMouseOver(MouseOverEvent event) {
		if (event.getSource().equals(wrapperFocPanel)) {
			if (!getDropController().isDropActive()) {
//					glassContainer.setGlassText(ADD_TO_THIS_COLLECTION);
//					glassContainer.setGlassVisible(true);
			}
		}
	}
/**
 * @description: This is used when an native event is  fired
 */
	@Override
	public void onClick(ClickEvent event) {
        if (event.getSource().equals(titleFocPanel)) 
        {
        	MixpanelUtil.Expand_CollectionPanel();
        	if(AppClientFactory.getCurrentPlaceToken().equalsIgnoreCase(PlaceTokens.SHELF)) {
          		Storage stockStore = Storage.getLocalStorageIfSupported();
                if (stockStore != null) {
                    stockStore.setItem("tabKey", "resourceTab");
                }
                if(isValue){
                AppClientFactory.fireEvent(new RequestShelfEvent(collectionDo.getGooruOid()));
                }
                isValue=true;
                
        	}
        	setOpen();
        } 
        else if (event.getSource().equals(wrapperFocPanel)) 
        {
            if (!getDropController().isDropActive()) 
            {
            	MixpanelUtil.Edit_This_Collection();
                // Set default tabFlag in persistant store for Collection Edit
                Storage stockStore = Storage.getLocalStorageIfSupported();
            
                if (stockStore != null) {
                    stockStore.setItem("tabKey", "resourceTab");
                }
            }
        }
	}
/**
 * 
 * @function addFolderItems 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :This is  used top add folderitems to the collection
 * 
 * 
 * @parm(s) : @param collectionFolderItems
 * @parm(s) : @param collectionDo
 * 
 * @return : void
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	protected void addFolderItems(CollectionItemDo collectionFolderItems,
			CollectionDo collectionDo) {
		FolderResource folderResource = new FolderResource(
				collectionFolderItems, collectionDo);
		int widgetCount = contentVerPanel.getWidgetCount();
		int sequence = collectionFolderItems.getItemSequence() - 1;
		contentVerPanel.insert(folderResource,
				widgetCount > 0 ? sequence >= widgetCount ? widgetCount
						: sequence : 0);

	}
	/**
	 * 
	 * @function getContentVerPanel 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :A apanel that laysout a widget in to a single vertical column
	 * 
	 * 
	 * @parm(s) : @return
	 * 
	 * @return : VerticalPanel
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */

	public VerticalPanel getContentVerPanel() {
		return contentVerPanel;
	}
/**
 * 
 * @function setOpen 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :It opens  shelf the collection
 * 
 * 
 * @parm(s) : 
 * 
 * @return : void
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	public void setOpen() {
	    if (shelfCollection == null || !shelfCollection.equals(this)) {
//            glassContainer.setGlassText(EDIT_THIS_COLLECTION);
            if (shelfCollection != null) {
                shelfCollection.setOpen(false);
            }
            shelfCollection = this;
            setOpen(!isOpen());
        } else if (shelfCollection != null) {
            shelfCollection.enableGlassPanel(false);
        }
	}
/**
 * 
 * @function setOpenFolder 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :It opens the folder
 * 
 * 
 * @parm(s) : 
 * 
 * @return : void
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	public void setOpenFolder() {
		titleFocPanel.setStyleName(res.css().shelfCollectionTitleActive());
		int widgetCount = contentVerPanel.getWidgetCount();
		if (collectionDo.getCollectionType().equals("folder")
				&& widgetCount == 0) {
			wrapperFocPanel.setStyleName(res.css()
					.shelfContentWrapperPanelFolderResource());
			contentVerPanel.setStyleName(res.css()
					.shelfContentPanelForFolders());
			String gooruOId = collectionDo.getGooruOid();
			AppClientFactory
					.getInjector()
					.getfolderService()
					.getFolders(gooruOId,
							new AsyncCallback<List<CollectionItemDo>>() {
								@Override
								public void onFailure(Throwable caught) {

								}

								@Override
								public void onSuccess(
										List<CollectionItemDo> result) {
									for (CollectionItemDo collectionFolderItems : result) {
										addFolderItems(collectionFolderItems,
												collectionDo);
									}
								}
							});
		}
		else  if(collectionDo.getCollectionType().equals("collection")){
			htmlPanel = new HTMLPanel("This collection is empty!");
			htmlPanel.getElement().getStyle()
					.setTextAlign(TextAlign.CENTER);
			htmlPanel.getElement().getStyle().setMarginLeft(19, Unit.PX);
			htmlPanel.getElement().getStyle().setColor("#999999");
			htmlPanel.getElement().getStyle()
					.setFontStyle(FontStyle.ITALIC);
			htmlPanel.getElement().setId(collectionDo.getGooruOid());
			contentVerPanel.add(htmlPanel);
		}
		setOpen();
	}
/**
 * @descriptiom: This is used  when an widget being attached to the browser document
 */
	@Override
	protected void onLoad() {
		super.onLoad();
		registerDropController();
	}
/**
  * @descriptiom: This is used  when an widget being detached from the browser document

 */
	@Override
	protected void onUnload() {
		super.onUnload();
		unregisterDropController();
	}
/**
 * @description: This is used to register drop  controller
 */
	@Override
	public void registerDropController() {
		AppClientFactory.fireEvent(new RegisterSearchDropEvent(dropController,
				RegisterSearchDropEvent.DROP_AREA.COLLECTION));
	}
/**
 * @description: this is used to unregister the drop controller
 */
	@Override
	public void unregisterDropController() {
		AppClientFactory.fireEvent(new UnregisterSearchDropEvent(
				dropController, RegisterSearchDropEvent.DROP_AREA.COLLECTION));
	}

	/**
	 * @return dropController instance of {@link ResourceDropController}
	 */
	public ResourceDropController getDropController() {
		return dropController;
	}
/**
 * 
 * @function setDropController 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :It sets the drop controller
 * 
 * 
 * @parm(s) : @param dropController
 * 
 * @return : void
 *
 * @throws : <Mentioned if any exceptions>
 *
 */
	public void setDropController(ResourceDropController dropController) {
		this.dropController = dropController;
	}

	/**
	 * @return collectionDo
	 */
	public CollectionDo getCollectionDo() {
		return collectionDo;
	}
	/**
	 * @description: It registre the drop controller
	 */

	@Override
	public void reregisterDropController() {
		unregisterDropController();
		registerDropController();
	}

	/**
	 * @description: It highlights the title
	 */
	public void glowTitle() {
		new FontWeightEffect(titleLbl.getElement(), FontWeight.BOLD,
				FontWeight.NORMAL, 5000);
	}
	/**
	 * 
	 * @function removeCollectionItem 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :It removes the collection items
	 * 
	 * 
	 * @parm(s) : 
	 * 
	 * @return : void
	 *
	 * @throws : <Mentioned if any exceptions>
	 *
	 */
	public void removeCollectionItem() {
		
	}
	
}
