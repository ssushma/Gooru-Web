package org.ednovo.gooru.client.mvp.resource.dnd;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class ResourceDragUc_ResourceDragUcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.resource.dnd.ResourceDragUc>, org.ednovo.gooru.client.mvp.resource.dnd.ResourceDragUc.ResourceDragUcUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.resource.dnd.ResourceDragUc owner) {


    return new Widgets(owner).get_container();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.resource.dnd.ResourceDragUc owner;


    public Widgets(final org.ednovo.gooru.client.mvp.resource.dnd.ResourceDragUc owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.resource.dnd.ResourceDragUc_ResourceDragUcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.resource.dnd.ResourceDragUc_ResourceDragUcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.resource.dnd.ResourceDragUc_ResourceDragUcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.resource.dnd.ResourceDragUc_ResourceDragUcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.resource.dnd.ResourceDragUc_ResourceDragUcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 3 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.ShelfCBundle res;
    private org.ednovo.gooru.client.mvp.shelf.ShelfCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.mvp.shelf.ShelfCBundle build_res() {
      // Creation section.
      res = owner.res;
      assert res != null : "UiField res with 'provided = true' was null";
      // Setup section.


      return res;
    }

    /**
     * Getter for container called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.AbsolutePanel get_container() {
      return build_container();
    }
    private com.google.gwt.user.client.ui.AbsolutePanel build_container() {
      // Creation section.
      final com.google.gwt.user.client.ui.AbsolutePanel container = (com.google.gwt.user.client.ui.AbsolutePanel) GWT.create(com.google.gwt.user.client.ui.AbsolutePanel.class);
      // Setup section.
      container.add(get_labelPanel());
      container.setHeight("45px");
      container.setWidth("248px");


      owner.container = container;

      return container;
    }

    /**
     * Getter for labelPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_labelPanel() {
      return build_labelPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_labelPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel labelPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      labelPanel.add(get_dragResourceImage());
      labelPanel.add(get_dragresourceTitle());
      labelPanel.setStyleName("" + get_res().css().resourceDrag() + "");


      owner.labelPanel = labelPanel;

      return labelPanel;
    }

    /**
     * Getter for dragResourceImage called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_dragResourceImage() {
      return build_dragResourceImage();
    }
    private com.google.gwt.user.client.ui.Label build_dragResourceImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label dragResourceImage = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      dragResourceImage.setStyleName("" + get_res().css().resourceDragImage() + "");


      owner.dragResourceImage = dragResourceImage;

      return dragResourceImage;
    }

    /**
     * Getter for dragresourceTitle called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTML get_dragresourceTitle() {
      return build_dragresourceTitle();
    }
    private com.google.gwt.user.client.ui.HTML build_dragresourceTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML dragresourceTitle = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      dragresourceTitle.setStyleName("" + get_res().css().resourceDragTitle() + " collectionItemEditDragTitle");


      owner.dragresourceTitle = dragresourceTitle;

      return dragresourceTitle;
    }
  }
}
