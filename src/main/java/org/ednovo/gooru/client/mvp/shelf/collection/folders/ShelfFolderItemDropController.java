/**
 * 
 */
package org.ednovo.gooru.client.mvp.shelf.collection.folders;

import org.ednovo.gooru.client.mvp.dnd.AppVerticalPanelDropController;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.CollectionEditResourceCBundle;

import com.allen_sauer.gwt.dnd.client.DragContext;
import com.allen_sauer.gwt.dnd.client.util.Area;
import com.allen_sauer.gwt.dnd.client.util.CoordinateLocation;
import com.allen_sauer.gwt.dnd.client.util.DOMUtil;
import com.allen_sauer.gwt.dnd.client.util.DragClientBundle;
import com.allen_sauer.gwt.dnd.client.util.Location;
import com.allen_sauer.gwt.dnd.client.util.LocationWidgetComparator;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Search Team
 * 
 */
public class ShelfFolderItemDropController extends AppVerticalPanelDropController {

	private Widget positioner;

	/**
	 * Class constructor
	 * @param dropTarget  target view panel while drop collection item
	 */
	public ShelfFolderItemDropController(VerticalPanel dropTarget) {
		super(dropTarget);
	}

	@Override
	protected Widget newPositioner(DragContext context) {
		Widget widget = super.newPositioner(context);
		widget.removeStyleName(DragClientBundle.INSTANCE.css().positioner());
		widget.addStyleName(CollectionEditResourceCBundle.INSTANCE.css().shelfResourceDragdropPositioner());
		positioner = widget;
		return widget;
	}

	@Override
	protected LocationWidgetComparator getLocationWidgetComparator() {
		return new LocationWidgetComparator() {

			@Override
			public boolean locationIndicatesIndexFollowingWidget(Area widgetArea, Location location) {
				return location.getTop() > widgetArea.getTop() + widgetArea.getHeight();
			}
		};
	}

	/**
	 * @return drag and drop widget comparator
	 */
	protected LocationWidgetComparator getMoveLocationWidgetComparator() {
		return new LocationWidgetComparator() {

			@Override
			public boolean locationIndicatesIndexFollowingWidget(Area widgetArea, Location location) {
				return location.getTop() > widgetArea.getTop() + widgetArea.getHeight() / 2;
			}
		};
	}

	@Override
	public void onEnter(DragContext context) {
		super.onEnter(context);
		int positionerIndex = dropTarget.getWidgetIndex(positioner);
		GWT.log("postionIndex: " + positionerIndex );
		if (positionerIndex == 0) {
			dropTarget.insert(positioner, 2);
		}
	}

	@Override
	public void onMove(DragContext context) {
		int targetIndex = DOMUtil.findIntersect(dropTarget, new CoordinateLocation(context.mouseX, context.mouseY), getMoveLocationWidgetComparator());

		// check that positioner not already in the correct location
		int positionerIndex = dropTarget.getWidgetIndex(positioner);

		if (positionerIndex != targetIndex && (positionerIndex != targetIndex - 1 && targetIndex != 0)) {
			if (positionerIndex == 0 && dropTarget.getWidgetCount() == 1) {
				// do nothing, the positioner is the only widget
			} else if (targetIndex == -1) {
				// outside drop target, so remove positioner to indicate a drop
				positioner.removeFromParent();
			} else {
				dropTarget.insert(positioner, targetIndex);
			}
		}
	}

	@Override
	public void onLeave(DragContext context) {
		positioner.removeFromParent();
		positioner = null;
		super.onLeave(context);
	}

}
