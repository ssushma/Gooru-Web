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
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.dnd.Draggable;
import org.ednovo.gooru.client.mvp.dnd.DropBox;
import org.ednovo.gooru.client.mvp.dnd.IsDraggable.DRAG_TYPE;
import org.ednovo.gooru.client.mvp.resource.dnd.ResourceDropController;
import org.ednovo.gooru.client.mvp.search.event.RegisterSearchDropEvent;
import org.ednovo.gooru.client.mvp.search.event.UnregisterSearchDropEvent;
import org.ednovo.gooru.client.mvp.shelf.event.CreateCollectionAndItemEvent;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.player.resource.client.view.resourceplayer.CustomAnimation;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.CollectionDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 *
 */
public class ShelfAddCollection extends FocusPanel implements DropBox {

	private ResourceDropController dropController;

	private Label lbl;
	
	private Label blueLbl;
	
	private FlowPanel gradientContFloPanel;
	
	private static MessageProperties i18n = GWT.create(MessageProperties.class);

	/**
	 * Class constructor
	 */
	public ShelfAddCollection() {
		super();
		dropController = new ResourceDropController(this);
		this.setStyleName(ShelfListCBundle.INSTANCE.css().shelfNewCollection());
	}

	/**
	 * Create new instance for {@link Label} and set label name 
	 * @param label name of the {@link Label}
	 */
	public void setLabel(String label) {
		gradientContFloPanel = new FlowPanel();
		lbl = new Label(label);
		gradientContFloPanel.add(lbl);
		lbl.setStyleName(ShelfListCBundle.INSTANCE.css().shelfNewCollectionText());
		this.setWidget(gradientContFloPanel);
	}
	
	public Label getLabel() {
		return lbl;
	}

	@Override
	public void onDrop(Draggable draggable) {
		if (draggable.getType().equals(DRAG_TYPE.COLLECTION)) { 
			MixpanelUtil.Drag_Collection();
			new CustomAnimation(draggable).run(50);
			this.setLabel(i18n.GL0591());
			/*RenameCustomizePopUp renameCustomizePopUp = new RenameCustomizePopUp(draggable.getDragId()){
				@Override
				public void closePoup() {
					Window.enableScrolling(true);
					this.hide();	
				}
				
			};
			renameCustomizePopUp.setWidth("450px");
			renameCustomizePopUp.setHeight("190px");
			renameCustomizePopUp.show();
			renameCustomizePopUp.center();*/
//			AppClientFactory.fireEvent(new CopyCollectionEvent(draggable.getDragId()));
			
			AppClientFactory.getInjector().getClasspageService().getSCollIdClasspageById(draggable.getDragId(), new SimpleAsyncCallback<CollectionDo>(){

				@Override
				public void onSuccess(CollectionDo result) {
					Map<String, String> params = new HashMap<String, String>();
					params.put("collectionId", result.getGooruOid());
					params.put("collectionTitle", result.getTitle());
					AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.COLLECTION, params);
				}
				
			});
			
		} else if (draggable.getType().equals(DRAG_TYPE.RESOURCE)) {
			new CustomAnimation(draggable).run(50);
			MixpanelUtil.Drag_Resource();
			
			AppClientFactory.fireEvent(new CreateCollectionAndItemEvent(draggable.getDragId()));
		}
	}

	@Override
	public void onDragOver(Draggable draggable) {
		if (draggable.getType().equals(DRAG_TYPE.RESOURCE) || draggable.getType().equals(DRAG_TYPE.COLLECTION)) {
			draggable.getDraggableMirageUc().onDroppable(true);
			this.addStyleName(ShelfListCBundle.INSTANCE.css().blueBorder());
		}
	}

	@Override
	public void onDragOut(Draggable draggable) {
		if (draggable.getType().equals(DRAG_TYPE.RESOURCE) || draggable.getType().equals(DRAG_TYPE.COLLECTION)) {
			draggable.getDraggableMirageUc().onDroppable(false);
			this.removeStyleName(ShelfListCBundle.INSTANCE.css().blueBorder());
		}

	}

	@Override
	public Widget getDropTarget() {
		return this;
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
	public void registerDropController() {
		AppClientFactory.fireEvent(new RegisterSearchDropEvent(dropController, RegisterSearchDropEvent.DROP_AREA.SHELF_ADD_COLLECTION));
	}

	@Override
	public void unregisterDropController() {
		AppClientFactory.fireEvent(new UnregisterSearchDropEvent(dropController, RegisterSearchDropEvent.DROP_AREA.SHELF_ADD_COLLECTION));
	}

	@Override
	public void reregisterDropController() {
		unregisterDropController();
		registerDropController();
	}
}
