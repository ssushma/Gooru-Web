package org.ednovo.gooru.client.mvp.shelf.collection.folders;

import org.ednovo.gooru.client.mvp.dnd.AppRepositionDragContainer;
import org.ednovo.gooru.client.mvp.dnd.AppVerticalPanelDropController;
import org.ednovo.gooru.client.mvp.dnd.Draggable;
import org.ednovo.gooru.client.mvp.resource.dnd.ResourceDragController;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.item.ShelfFolderItemChildView;

import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 *
 */
public class FolderItemPanelVc extends AppRepositionDragContainer {

	private AppVerticalPanelDropController widgetDropController;

	private ResourceDragController dragController;

	/**
	 * Class constructor create new instance of  {@link ResourceDragController} and {@link ShelfFolderItemDropController}
	 */
	public FolderItemPanelVc() {
		super();
		dragController = new ResourceDragController(RootPanel.get(), false, false);
		widgetDropController = new ShelfFolderItemDropController(this);
		dragController.registerDropController(widgetDropController);
		setDragController(dragController);
	}

	@Override
	public void onDrop(Draggable draggable) {
		ShelfFolderItemChildView folderItem = (ShelfFolderItemChildView) draggable.getDraggableUc();
//		folderItem.reorderCollectionItem(getWidgetIndex(draggable));
	}

	@Override
	public void onDragOver(Draggable draggable) {

	}

	@Override
	public void onDragOut(Draggable draggable) {
	}

	@Override
	public Widget getDropTarget() {
		return null;
	}

	@Override
	public void registerDropController() {
		dragController.registerDropController(widgetDropController);
	}

	@Override
	public void unregisterDropController() {
		dragController.unregisterDropController(widgetDropController);
	}

	@Override
	public void onLoad() {
		super.onLoad();
		registerDropController();
	}

	@Override
	public void onUnload() {
		super.onUnload();
		unregisterDropController();
	}

	@Override
	public void reregisterDropController() {
		// Not necessary
	}
}
