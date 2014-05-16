package org.ednovo.gooru.client.mvp.shelf.collection.folders.item;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.safehtml.shared.UriUtils;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class ShelfFolderItemChildView_ShelfFolderItemChildViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.shelf.collection.folders.item.ShelfFolderItemChildView>, org.ednovo.gooru.client.mvp.shelf.collection.folders.item.ShelfFolderItemChildView.ShelfFolderItemChildViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.shelf.collection.folders.item.ShelfFolderItemChildView owner) {


    return new Widgets(owner).get_contentBlock();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.shelf.collection.folders.item.ShelfFolderItemChildView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickOnFolderImage(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickOnCollectionImage(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickOnTitle(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.shelf.collection.folders.item.ShelfFolderItemChildView owner) {
      this.owner = owner;
      build_folderStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
    }

    SafeHtml template_html1() {
      return template.html1();
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.folders.item.ShelfFolderItemChildView_ShelfFolderItemChildViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.folders.item.ShelfFolderItemChildView_ShelfFolderItemChildViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.collection.folders.item.ShelfFolderItemChildView_ShelfFolderItemChildViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.shelf.collection.folders.item.ShelfFolderItemChildView_ShelfFolderItemChildViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.folders.item.ShelfFolderItemChildView_ShelfFolderItemChildViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for folderStyle called 5 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.folders.item.ShelfFolderItemChildView_ShelfFolderItemChildViewUiBinderImpl_GenCss_folderStyle folderStyle;
    private org.ednovo.gooru.client.mvp.shelf.collection.folders.item.ShelfFolderItemChildView_ShelfFolderItemChildViewUiBinderImpl_GenCss_folderStyle get_folderStyle() {
      return folderStyle;
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.folders.item.ShelfFolderItemChildView_ShelfFolderItemChildViewUiBinderImpl_GenCss_folderStyle build_folderStyle() {
      // Creation section.
      folderStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().folderStyle();
      // Setup section.
      folderStyle.ensureInjected();


      owner.folderStyle = folderStyle;

      return folderStyle;
    }

    /**
     * Getter for contentBlock called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_contentBlock() {
      return build_contentBlock();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_contentBlock() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel contentBlock = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      contentBlock.add(get_f_FlowPanel1());
      contentBlock.add(get_contents());
      contentBlock.setStyleName("" + get_folderStyle().contentBlock() + "");


      owner.contentBlock = contentBlock;

      return contentBlock;
    }

    /**
     * Getter for f_FlowPanel1 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel1() {
      return build_f_FlowPanel1();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel1 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel1.add(get_folderImage());
      f_FlowPanel1.add(get_collectionImage());
      f_FlowPanel1.add(get_itemTitle());
      f_FlowPanel1.setStyleName("" + get_folderStyle().info() + "");


      return f_FlowPanel1;
    }

    /**
     * Getter for folderImage called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_folderImage() {
      return build_folderImage();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_folderImage() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel folderImage = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html1().asString());
      // Setup section.
      folderImage.setStyleName("" + get_folderStyle().image() + "");
      folderImage.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.folderImage = folderImage;

      return folderImage;
    }

    /**
     * Getter for collectionImage called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Image get_collectionImage() {
      return build_collectionImage();
    }
    private com.google.gwt.user.client.ui.Image build_collectionImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image collectionImage = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      collectionImage.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.collectionImage = collectionImage;

      return collectionImage;
    }

    /**
     * Getter for itemTitle called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_itemTitle() {
      return build_itemTitle();
    }
    private com.google.gwt.user.client.ui.Label build_itemTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label itemTitle = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      itemTitle.setStyleName("" + get_folderStyle().title() + "");
      itemTitle.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);


      owner.itemTitle = itemTitle;

      return itemTitle;
    }

    /**
     * Getter for contents called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_contents() {
      return build_contents();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_contents() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel contents = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      contents.setStyleName("" + get_folderStyle().contents() + "");


      owner.contents = contents;

      return contents;
    }
  }
}
