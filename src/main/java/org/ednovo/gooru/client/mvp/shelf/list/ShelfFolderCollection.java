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

import org.ednovo.gooru.client.effects.FontWeightEffect;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.dnd.Draggable;
import org.ednovo.gooru.client.mvp.dnd.DropBox;
import org.ednovo.gooru.client.mvp.dnd.IsDraggable.DRAG_TYPE;
import org.ednovo.gooru.client.mvp.resource.dnd.ResourceDropController;
import org.ednovo.gooru.client.mvp.search.event.RegisterSearchDropEvent;
import org.ednovo.gooru.client.mvp.search.event.UnregisterSearchDropEvent;
import org.ednovo.gooru.client.mvp.shelf.event.CreateCollectionItemEvent;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.FontStyle;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @fileName : ShelfFolderCollection.java
 *
 * @description : Describes the shelf folder collection
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
public class ShelfFolderCollection extends FocusPanel implements DropBox,
		MouseOverHandler, ClickHandler {

	private static ShelfCollectionUiBinder uiBinder = GWT
			.create(ShelfCollectionUiBinder.class);

	interface ShelfCollectionUiBinder extends UiBinder<Widget, ShelfFolderCollection> {
	}

	@UiField
	HTML titleLbl;

	@UiField(provided = true)
	ShelfListCBundle res;

	@UiField
	FocusPanel titleFocPanel;

	@UiField
	DisclosurePanel disPanel;

	private CollectionDo collectionDo;

	private ResourceDropController dropController;

	private static final String ADD_TO_THIS_COLLECTION = "Add to this Collection";

	private static final String EDIT_THIS_COLLECTION = "Edit this Collection";

	private static ShelfFolderCollection shelfCollection;

	HTMLPanel htmlPanel;

	/**
	 * Class constructor , assign the {@link CollectionDo} instance
	 * 
	 * @param collectionDo
	 *            instance of {@link CollectionDo}
	 */
	public ShelfFolderCollection(final CollectionDo collectionDo) {
		res = ShelfListCBundle.INSTANCE;
		res.css().ensureInjected();
		setWidget(uiBinder.createAndBindUi(this));
		setData(collectionDo);
		dropController = new ResourceDropController(this);
		titleFocPanel.addClickHandler(this);
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
			htmlPanel = new HTMLPanel("This collection is empty!!!!!!");
			htmlPanel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
			htmlPanel.getElement().getStyle().setMarginLeft(19, Unit.PX);
			htmlPanel.getElement().getStyle().setColor("#999999");
			htmlPanel.getElement().getStyle().setFontStyle(FontStyle.ITALIC);
			htmlPanel.getElement().setId(collectionDo.getGooruOid());
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
	//	titleLbl.setText(StringUtil.truncateText(collectionDo.getTitle(), 30));
		titleLbl.setHTML(StringUtil.truncateText(collectionDo.getTitle(), 30));
	}

	/**
	 * Update collection item
	 * 
	 * @param collectionItemDo
	 *            instance of {@link CollectionItemDo}
	 */
	public void updateCollectionItem(CollectionItemDo collectionItemDo) {
		ShelfResource shelfResource = getShelfResource(collectionItemDo.getCollectionItemId());
		int sequence = collectionItemDo.getItemSequence() - 1;
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
		if (isNew) {
			if (this.collectionDo.getCollectionItems() == null) {
				this.collectionDo
						.setCollectionItems(new ArrayList<CollectionItemDo>());
			}
			this.collectionDo.getCollectionItems().add(collectionItemDo);
		}
		ShelfResource shelfResource = new ShelfResource(collectionItemDo);
		int sequence = collectionItemDo.getItemSequence() - 1;
		if (isNew) {
			shelfResource.glowTitle();
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
		ShelfResource shelfResource = getShelfResource(collectionItemDo
				.getCollectionItemId());
		if (shelfResource != null) {
		}
		if (collectionItemDo.getCollection().getCollectionItems().size() <= 0) {
			htmlPanel = new HTMLPanel("This collection is empty!");
			htmlPanel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
			htmlPanel.getElement().getStyle().setMarginLeft(19, Unit.PX);
			htmlPanel.getElement().getStyle().setColor("#999999");
			htmlPanel.getElement().getStyle().setFontStyle(FontStyle.ITALIC);
			htmlPanel.getElement().setId(collectionDo.getGooruOid());
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
		return null;
	}
/**
 * @description: This is used to set the drag over event
 */
	@Override
	public void onDragOver(Draggable draggable) {
		if (draggable.getType().equals(DRAG_TYPE.RESOURCE)) {
			draggable.getDraggableMirageUc().onDroppable(true);
		}
	}
/**
 * @description: This is used to drag out after dragging the event
 */
	@Override
	public void onDragOut(Draggable draggable) {
		if (draggable.getType().equals(DRAG_TYPE.RESOURCE)) {
			draggable.getDraggableMirageUc().onDroppable(false);
		}
	}
/**
 * @description: This widget add supports events from the browser and also add them to panels directly
 */
	@Override
	public Widget getDropTarget() {
		return this;
	}
/**
 * @description: This is used to drop after dragging
 */
	@Override
	public void onDrop(Draggable draggable) {
		if (draggable.getType().equals(DRAG_TYPE.RESOURCE)) {
			Document doc = Document.get();
			if (doc.getElementById(collectionDo.getGooruOid()) != null)
				doc.getElementById(collectionDo.getGooruOid())
						.removeFromParent();
			AppClientFactory.fireEvent(new CreateCollectionItemEvent(
					collectionDo.getGooruOid(), draggable.getDragId()));
		}
	}

	/**
	 * 
	 * @function setOpen 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :This is used to open 
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
		disPanel.setOpen(isOpen);
	}
	/**
	 * 
	 * @function isOpen 
	 * 
	 * @created_date : 02-Jan-2014
	 * 
	 * @description :It checks whether it is opened or not
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
		
	}
/**
 * @description;It enables the mouse over event
 */
	@Override
	public void onMouseOver(MouseOverEvent event) {
	}
/**
 * @description: it enables the on click event when an  native event is fired
 */
	@Override
	public void onClick(ClickEvent event) {
	}
/**
 * 
 * @function setOpen 
 * 
 * @created_date : 02-Jan-2014
 * 
 * @description :It is used to open the collection
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
 * @description: This method is called when an widget is attached to the browser document
 */
	@Override
	protected void onLoad() {
		super.onLoad();
		registerDropController();
	}
/**
 * @description: This method is called when an widget is detached from the browser document
 */
	@Override
	protected void onUnload() {
		super.onUnload();
		unregisterDropController();
	}
/**
 * @description:This is used to register drop controller
 */
	@Override
	public void registerDropController() {
		AppClientFactory.fireEvent(new RegisterSearchDropEvent(dropController,
				RegisterSearchDropEvent.DROP_AREA.COLLECTION));
	}
	/**
	 * @description:This is used to unregister drop controller
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
 * @description :It is used to setDrop Controller 
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
 * @description: this is used to register drop controller
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
}
