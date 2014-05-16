package org.ednovo.gooru.client.mvp.shelf;

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

public class ShelfView_ShelfViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.shelf.ShelfView>, org.ednovo.gooru.client.mvp.shelf.ShelfView.ShelfViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span>")
    SafeHtml html1(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html2(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html3(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html4(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html5(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html6(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html7(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html8(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html9(String arg0, String arg1, String arg2);
     
    @Template("")
    SafeHtml html10();
     
    @Template("")
    SafeHtml html11();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html12(String arg0, String arg1, String arg2);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.shelf.ShelfView owner) {


    return new Widgets(owner).get_shelfViewMainContainer();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.shelf.ShelfView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.deleteCollectionPopup(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.collectionPlay(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onCopyCollectionClick(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onMoveCollectionClick(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickedOneditSelfCollectionSaveButton(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickedOneditFolderDescSaveButton(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickedOneditSelfCollectionSaveButtonCancel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickedOnEditFolderDescSaveButtonCancel(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.shelf.ShelfView owner) {
      this.owner = owner;
      build_folderStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId14();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId15();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId16();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId17();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId14Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId15Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId16Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId17Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
    }

    SafeHtml template_html1() {
      return template.html1(get_domId0());
    }
    SafeHtml template_html2() {
      return template.html2(get_domId4());
    }
    SafeHtml template_html3() {
      return template.html3(get_domId3(), get_domId5());
    }
    SafeHtml template_html4() {
      return template.html4(get_domId6(), get_domId7());
    }
    SafeHtml template_html5() {
      return template.html5(get_domId8());
    }
    SafeHtml template_html6() {
      return template.html6(get_domId10());
    }
    SafeHtml template_html7() {
      return template.html7(get_domId9(), get_domId11());
    }
    SafeHtml template_html8() {
      return template.html8(get_domId12(), get_domId13());
    }
    SafeHtml template_html9() {
      return template.html9(get_domId14(), get_domId15(), get_domId16());
    }
    SafeHtml template_html10() {
      return template.html10();
    }
    SafeHtml template_html11() {
      return template.html11();
    }
    SafeHtml template_html12() {
      return template.html12(get_domId1(), get_domId2(), get_domId17());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.ShelfView_ShelfViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.shelf.ShelfView_ShelfViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.ShelfView_ShelfViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.shelf.ShelfView_ShelfViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.ShelfView_ShelfViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 43 times. Type: IMPORTED. Build precedence: 1.
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
     * Getter for folderStyle called 4 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.ShelfView_ShelfViewUiBinderImpl_GenCss_folderStyle folderStyle;
    private org.ednovo.gooru.client.mvp.shelf.ShelfView_ShelfViewUiBinderImpl_GenCss_folderStyle get_folderStyle() {
      return folderStyle;
    }
    private org.ednovo.gooru.client.mvp.shelf.ShelfView_ShelfViewUiBinderImpl_GenCss_folderStyle build_folderStyle() {
      // Creation section.
      folderStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().folderStyle();
      // Setup section.
      folderStyle.ensureInjected();


      return folderStyle;
    }

    /**
     * Getter for shelfViewMainContainer called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_shelfViewMainContainer() {
      return build_shelfViewMainContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_shelfViewMainContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel shelfViewMainContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      shelfViewMainContainer.add(get_scrollContainer());
      shelfViewMainContainer.add(get_noCollectionResetPanel());
      shelfViewMainContainer.add(get_loadingImageLabel());
      shelfViewMainContainer.add(get_editPanel());
      shelfViewMainContainer.setStyleName("" + get_res().css().userShelfViewMainCenterContainer() + "");


      owner.shelfViewMainContainer = shelfViewMainContainer;

      return shelfViewMainContainer;
    }

    /**
     * Getter for scrollContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_scrollContainer() {
      return build_scrollContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_scrollContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel scrollContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      scrollContainer.add(get_backToSearchFloPanel());
      scrollContainer.add(get_shelfTabSimPanel());
      scrollContainer.setStyleName("" + get_folderStyle().scrollContainer() + "");


      owner.scrollContainer = scrollContainer;

      return scrollContainer;
    }

    /**
     * Getter for backToSearchFloPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_backToSearchFloPanel() {
      return build_backToSearchFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_backToSearchFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel backToSearchFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      backToSearchFloPanel.add(get_backToSearchPreHtml());
      backToSearchFloPanel.add(get_backToSearchHtml());
      backToSearchFloPanel.setStyleName("" + get_res().css().backToSearchPanel() + "");
      backToSearchFloPanel.setVisible(false);


      owner.backToSearchFloPanel = backToSearchFloPanel;

      return backToSearchFloPanel;
    }

    /**
     * Getter for backToSearchPreHtml called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTML get_backToSearchPreHtml() {
      return build_backToSearchPreHtml();
    }
    private com.google.gwt.user.client.ui.HTML build_backToSearchPreHtml() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML backToSearchPreHtml = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      backToSearchPreHtml.setStyleName("" + get_res().css().preBackToSearch() + "");
      backToSearchPreHtml.setVisible(false);


      owner.backToSearchPreHtml = backToSearchPreHtml;

      return backToSearchPreHtml;
    }

    /**
     * Getter for backToSearchHtml called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTML get_backToSearchHtml() {
      return build_backToSearchHtml();
    }
    private com.google.gwt.user.client.ui.HTML build_backToSearchHtml() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML backToSearchHtml = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      backToSearchHtml.setStyleName("" + get_res().css().backToSearch() + "");


      owner.backToSearchHtml = backToSearchHtml;

      return backToSearchHtml;
    }

    /**
     * Getter for shelfTabSimPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_shelfTabSimPanel() {
      return build_shelfTabSimPanel();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_shelfTabSimPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel shelfTabSimPanel = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.
      shelfTabSimPanel.setStyleName("" + get_folderStyle().shelfFolderPanel() + " " + get_folderStyle().organize() + "");


      owner.shelfTabSimPanel = shelfTabSimPanel;

      return shelfTabSimPanel;
    }

    /**
     * Getter for noCollectionResetPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_noCollectionResetPanel() {
      return build_noCollectionResetPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_noCollectionResetPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel noCollectionResetPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      noCollectionResetPanel.setStyleName("" + get_res().css().noCollectionMessage() + "");


      owner.noCollectionResetPanel = noCollectionResetPanel;

      return noCollectionResetPanel;
    }

    /**
     * Getter for loadingImageLabel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_loadingImageLabel() {
      return build_loadingImageLabel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_loadingImageLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel loadingImageLabel = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      loadingImageLabel.setStyleName("" + get_res().css().loadingImageMainDiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1928 = UiBinderUtil.attachToDom(loadingImageLabel.getElement());
      get_domId0Element().get();

      // Detach section.
      attachRecord1928.detach();
      loadingImageLabel.addAndReplaceElement(get_f_Label1(), get_domId0Element().get());

      owner.loadingImageLabel = loadingImageLabel;

      return loadingImageLabel;
    }

    /**
     * Getter for domId0 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId0;
    private java.lang.String get_domId0() {
      return domId0;
    }
    private java.lang.String build_domId0() {
      // Creation section.
      domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId0;
    }

    /**
     * Getter for f_Label1 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label1() {
      return build_f_Label1();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label1() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label1 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label1.setStyleName("" + get_res().css().loadingImageForSelfEdit() + "");


      return f_Label1;
    }

    /**
     * Getter for domId0Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId0Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId0Element() {
      return domId0Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId0Element() {
      // Creation section.
      domId0Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId0());
      // Setup section.


      return domId0Element;
    }

    /**
     * Getter for editPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_editPanel() {
      return build_editPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_editPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel editPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html12().asString());
      // Setup section.
      editPanel.setStyleName("" + get_folderStyle().editPanel() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1929 = UiBinderUtil.attachToDom(editPanel.getElement());
      get_domId1Element().get();
      get_domId2Element().get();
      get_domId17Element().get();

      // Detach section.
      attachRecord1929.detach();
      editPanel.addAndReplaceElement(get_folderListPanel(), get_domId1Element().get());
      editPanel.addAndReplaceElement(get_collectionFloPanel(), get_domId2Element().get());
      editPanel.addAndReplaceElement(get_panelFoooter(), get_domId17Element().get());

      owner.editPanel = editPanel;

      return editPanel;
    }

    /**
     * Getter for domId1 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId1;
    private java.lang.String get_domId1() {
      return domId1;
    }
    private java.lang.String build_domId1() {
      // Creation section.
      domId1 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId1;
    }

    /**
     * Getter for folderListPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_folderListPanel() {
      return build_folderListPanel();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_folderListPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel folderListPanel = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.


      owner.folderListPanel = folderListPanel;

      return folderListPanel;
    }

    /**
     * Getter for domId1Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId1Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId1Element() {
      return domId1Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId1Element() {
      // Creation section.
      domId1Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId1());
      // Setup section.


      return domId1Element;
    }

    /**
     * Getter for domId2 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId2;
    private java.lang.String get_domId2() {
      return domId2;
    }
    private java.lang.String build_domId2() {
      // Creation section.
      domId2 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId2;
    }

    /**
     * Getter for collectionFloPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_collectionFloPanel() {
      return build_collectionFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_collectionFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel collectionFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      collectionFloPanel.add(get_f_FlowPanel2());
      collectionFloPanel.add(get_panelFriendly());
      collectionFloPanel.add(get_f_FlowPanel8());
      collectionFloPanel.add(get_collectionMetaDataSimPanel());


      owner.collectionFloPanel = collectionFloPanel;

      return collectionFloPanel;
    }

    /**
     * Getter for f_FlowPanel2 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel2() {
      return build_f_FlowPanel2();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel2 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel2.add(get_lblLastEditedBy());
      f_FlowPanel2.add(get_collectionImageShelfUc());
      f_FlowPanel2.add(get_f_FlowPanel3());
      f_FlowPanel2.add(get_f_FlowPanel7());
      f_FlowPanel2.setStyleName("" + get_res().css().userCollectionInShelf() + "");


      return f_FlowPanel2;
    }

    /**
     * Getter for lblLastEditedBy called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_lblLastEditedBy() {
      return build_lblLastEditedBy();
    }
    private com.google.gwt.user.client.ui.Label build_lblLastEditedBy() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblLastEditedBy = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblLastEditedBy.setStyleName("" + get_res().css().lastEditedBy() + "");


      owner.lblLastEditedBy = lblLastEditedBy;

      return lblLastEditedBy;
    }

    /**
     * Getter for collectionImageShelfUc called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionUploadImageUc get_collectionImageShelfUc() {
      return build_collectionImageShelfUc();
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionUploadImageUc build_collectionImageShelfUc() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.collection.CollectionUploadImageUc collectionImageShelfUc = (org.ednovo.gooru.client.mvp.shelf.collection.CollectionUploadImageUc) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.CollectionUploadImageUc.class);
      // Setup section.


      owner.collectionImageShelfUc = collectionImageShelfUc;

      return collectionImageShelfUc;
    }

    /**
     * Getter for f_FlowPanel3 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel3() {
      return build_f_FlowPanel3();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel3 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel3.add(get_collectionTitleContainer());
      f_FlowPanel3.add(get_panelActionItems());
      f_FlowPanel3.add(get_f_FlowPanel4());
      f_FlowPanel3.add(get_collectionDescriptionTitleContainer());
      f_FlowPanel3.add(get_editCollectionDescTitle());
      f_FlowPanel3.add(get_f_HTMLPanel6());
      f_FlowPanel3.add(get_descriptionAlertMessageLbl());
      f_FlowPanel3.setStyleName("" + get_res().css().userCollectionInfo() + "");


      return f_FlowPanel3;
    }

    /**
     * Getter for collectionTitleContainer called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_collectionTitleContainer() {
      return build_collectionTitleContainer();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_collectionTitleContainer() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel collectionTitleContainer = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html3().asString());
      // Setup section.
      collectionTitleContainer.setStyleName("" + get_res().css().collectionTitleContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1930 = UiBinderUtil.attachToDom(collectionTitleContainer.getElement());
      get_domId3Element().get();
      get_domId5Element().get();

      // Detach section.
      attachRecord1930.detach();
      collectionTitleContainer.addAndReplaceElement(get_editCollectionTitle(), get_domId3Element().get());
      collectionTitleContainer.addAndReplaceElement(get_collectionEditImageLbl(), get_domId5Element().get());

      owner.collectionTitleContainer = collectionTitleContainer;

      return collectionTitleContainer;
    }

    /**
     * Getter for domId3 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId3;
    private java.lang.String get_domId3() {
      return domId3;
    }
    private java.lang.String build_domId3() {
      // Creation section.
      domId3 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId3;
    }

    /**
     * Getter for editCollectionTitle called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_editCollectionTitle() {
      return build_editCollectionTitle();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_editCollectionTitle() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel editCollectionTitle = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html2().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1931 = UiBinderUtil.attachToDom(editCollectionTitle.getElement());
      get_domId4Element().get();

      // Detach section.
      attachRecord1931.detach();
      editCollectionTitle.addAndReplaceElement(get_collectionTitleUc(), get_domId4Element().get());

      owner.editCollectionTitle = editCollectionTitle;

      return editCollectionTitle;
    }

    /**
     * Getter for domId4 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
     */
    private java.lang.String domId4;
    private java.lang.String get_domId4() {
      return domId4;
    }
    private java.lang.String build_domId4() {
      // Creation section.
      domId4 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId4;
    }

    /**
     * Getter for collectionTitleUc called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private org.ednovo.gooru.client.uc.EditableLabelUc get_collectionTitleUc() {
      return build_collectionTitleUc();
    }
    private org.ednovo.gooru.client.uc.EditableLabelUc build_collectionTitleUc() {
      // Creation section.
      final org.ednovo.gooru.client.uc.EditableLabelUc collectionTitleUc = owner.collectionTitleUc;
      assert collectionTitleUc != null : "UiField collectionTitleUc with 'provided = true' was null";
      // Setup section.
      collectionTitleUc.setStyleName("" + get_res().css().collectionTitle() + "");


      return collectionTitleUc;
    }

    /**
     * Getter for domId4Element called 2 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId4Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId4Element() {
      return domId4Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId4Element() {
      // Creation section.
      domId4Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId4());
      // Setup section.


      return domId4Element;
    }

    /**
     * Getter for domId3Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId3Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId3Element() {
      return domId3Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId3Element() {
      // Creation section.
      domId3Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId3());
      // Setup section.


      return domId3Element;
    }

    /**
     * Getter for domId5 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId5;
    private java.lang.String get_domId5() {
      return domId5;
    }
    private java.lang.String build_domId5() {
      // Creation section.
      domId5 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId5;
    }

    /**
     * Getter for collectionEditImageLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_collectionEditImageLbl() {
      return build_collectionEditImageLbl();
    }
    private com.google.gwt.user.client.ui.Label build_collectionEditImageLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label collectionEditImageLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      collectionEditImageLbl.setStyleName("" + get_res().css().collectionEditImage() + "");


      owner.collectionEditImageLbl = collectionEditImageLbl;

      return collectionEditImageLbl;
    }

    /**
     * Getter for domId5Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId5Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId5Element() {
      return domId5Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId5Element() {
      // Creation section.
      domId5Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId5());
      // Setup section.


      return domId5Element;
    }

    /**
     * Getter for panelActionItems called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelActionItems() {
      return build_panelActionItems();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelActionItems() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelActionItems = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      panelActionItems.setStyleName("" + get_res().css().buttonContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1932 = UiBinderUtil.attachToDom(panelActionItems.getElement());
      get_domId6Element().get();
      get_domId7Element().get();

      // Detach section.
      attachRecord1932.detach();
      panelActionItems.addAndReplaceElement(get_editSelfCollectionSaveButtonCancel(), get_domId6Element().get());
      panelActionItems.addAndReplaceElement(get_editSelfCollectionSaveButton(), get_domId7Element().get());

      owner.panelActionItems = panelActionItems;

      return panelActionItems;
    }

    /**
     * Getter for domId6 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId6;
    private java.lang.String get_domId6() {
      return domId6;
    }
    private java.lang.String build_domId6() {
      // Creation section.
      domId6 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId6;
    }

    /**
     * Getter for editSelfCollectionSaveButtonCancel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Button get_editSelfCollectionSaveButtonCancel() {
      return build_editSelfCollectionSaveButtonCancel();
    }
    private com.google.gwt.user.client.ui.Button build_editSelfCollectionSaveButtonCancel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button editSelfCollectionSaveButtonCancel = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      editSelfCollectionSaveButtonCancel.setStyleName("" + get_res().css().mySelfCollectionEditTitlePreviewCancelButton() + "");
      editSelfCollectionSaveButtonCancel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7);


      owner.editSelfCollectionSaveButtonCancel = editSelfCollectionSaveButtonCancel;

      return editSelfCollectionSaveButtonCancel;
    }

    /**
     * Getter for domId6Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId6Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId6Element() {
      return domId6Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId6Element() {
      // Creation section.
      domId6Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId6());
      // Setup section.


      return domId6Element;
    }

    /**
     * Getter for domId7 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId7;
    private java.lang.String get_domId7() {
      return domId7;
    }
    private java.lang.String build_domId7() {
      // Creation section.
      domId7 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId7;
    }

    /**
     * Getter for editSelfCollectionSaveButton called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Button get_editSelfCollectionSaveButton() {
      return build_editSelfCollectionSaveButton();
    }
    private com.google.gwt.user.client.ui.Button build_editSelfCollectionSaveButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button editSelfCollectionSaveButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      editSelfCollectionSaveButton.setStyleName("primary " + get_res().css().mySelfCollectionrEditTitle() + "");
      editSelfCollectionSaveButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5);


      owner.editSelfCollectionSaveButton = editSelfCollectionSaveButton;

      return editSelfCollectionSaveButton;
    }

    /**
     * Getter for domId7Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId7Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId7Element() {
      return domId7Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId7Element() {
      // Creation section.
      domId7Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId7());
      // Setup section.


      return domId7Element;
    }

    /**
     * Getter for f_FlowPanel4 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel4() {
      return build_f_FlowPanel4();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel4 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel4.add(get_titleAlertMessageLbl());
      f_FlowPanel4.setStyleName("" + get_res().css().titleAlertContainer() + "");


      return f_FlowPanel4;
    }

    /**
     * Getter for titleAlertMessageLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_titleAlertMessageLbl() {
      return build_titleAlertMessageLbl();
    }
    private com.google.gwt.user.client.ui.Label build_titleAlertMessageLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label titleAlertMessageLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      titleAlertMessageLbl.setStyleName("" + get_res().css().titleAlertMessage() + "");


      owner.titleAlertMessageLbl = titleAlertMessageLbl;

      return titleAlertMessageLbl;
    }

    /**
     * Getter for collectionDescriptionTitleContainer called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_collectionDescriptionTitleContainer() {
      return build_collectionDescriptionTitleContainer();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_collectionDescriptionTitleContainer() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel collectionDescriptionTitleContainer = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html5().asString());
      // Setup section.
      collectionDescriptionTitleContainer.setStyleName("" + get_res().css().collectionDescriptionTitleContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1933 = UiBinderUtil.attachToDom(collectionDescriptionTitleContainer.getElement());
      get_domId8Element().get();

      // Detach section.
      attachRecord1933.detach();
      collectionDescriptionTitleContainer.addAndReplaceElement(get_collectionDescriptionTitle(), get_domId8Element().get());

      owner.collectionDescriptionTitleContainer = collectionDescriptionTitleContainer;

      return collectionDescriptionTitleContainer;
    }

    /**
     * Getter for domId8 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId8;
    private java.lang.String get_domId8() {
      return domId8;
    }
    private java.lang.String build_domId8() {
      // Creation section.
      domId8 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId8;
    }

    /**
     * Getter for collectionDescriptionTitle called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_collectionDescriptionTitle() {
      return build_collectionDescriptionTitle();
    }
    private com.google.gwt.user.client.ui.Label build_collectionDescriptionTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label collectionDescriptionTitle = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      collectionDescriptionTitle.setStyleName("" + get_res().css().collectionDescriptionTitle() + "");


      owner.collectionDescriptionTitle = collectionDescriptionTitle;

      return collectionDescriptionTitle;
    }

    /**
     * Getter for domId8Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId8Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId8Element() {
      return domId8Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId8Element() {
      // Creation section.
      domId8Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId8());
      // Setup section.


      return domId8Element;
    }

    /**
     * Getter for editCollectionDescTitle called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_editCollectionDescTitle() {
      return build_editCollectionDescTitle();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_editCollectionDescTitle() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel editCollectionDescTitle = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html7().asString());
      // Setup section.
      editCollectionDescTitle.setStyleName("" + get_res().css().collectionTitleContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1934 = UiBinderUtil.attachToDom(editCollectionDescTitle.getElement());
      get_domId9Element().get();
      get_domId11Element().get();

      // Detach section.
      attachRecord1934.detach();
      editCollectionDescTitle.addAndReplaceElement(get_f_HTMLEventPanel5(), get_domId9Element().get());
      editCollectionDescTitle.addAndReplaceElement(get_simplePencilPanel(), get_domId11Element().get());

      owner.editCollectionDescTitle = editCollectionDescTitle;

      return editCollectionDescTitle;
    }

    /**
     * Getter for domId9 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId9;
    private java.lang.String get_domId9() {
      return domId9;
    }
    private java.lang.String build_domId9() {
      // Creation section.
      domId9 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId9;
    }

    /**
     * Getter for f_HTMLEventPanel5 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_f_HTMLEventPanel5() {
      return build_f_HTMLEventPanel5();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_f_HTMLEventPanel5() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel f_HTMLEventPanel5 = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html6().asString());
      // Setup section.
      f_HTMLEventPanel5.setStyleName("collectionDesctionConatiner");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1935 = UiBinderUtil.attachToDom(f_HTMLEventPanel5.getElement());
      get_domId10Element().get();

      // Detach section.
      attachRecord1935.detach();
      f_HTMLEventPanel5.addAndReplaceElement(get_collectionDescriptionUc(), get_domId10Element().get());

      return f_HTMLEventPanel5;
    }

    /**
     * Getter for domId10 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
     */
    private java.lang.String domId10;
    private java.lang.String get_domId10() {
      return domId10;
    }
    private java.lang.String build_domId10() {
      // Creation section.
      domId10 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId10;
    }

    /**
     * Getter for collectionDescriptionUc called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private org.ednovo.gooru.client.uc.EditableTextAreaUc get_collectionDescriptionUc() {
      return build_collectionDescriptionUc();
    }
    private org.ednovo.gooru.client.uc.EditableTextAreaUc build_collectionDescriptionUc() {
      // Creation section.
      final org.ednovo.gooru.client.uc.EditableTextAreaUc collectionDescriptionUc = owner.collectionDescriptionUc;
      assert collectionDescriptionUc != null : "UiField collectionDescriptionUc with 'provided = true' was null";
      // Setup section.
      collectionDescriptionUc.setStyleName("" + get_res().css().collectionDescription() + "");
      collectionDescriptionUc.setExtraTextAreaStyleName("" + get_res().css().collectionDescriptionTxtArea() + "");
      collectionDescriptionUc.setExtraHtmlStyleName("" + get_res().css().collectionDescriptionHtml() + "");


      return collectionDescriptionUc;
    }

    /**
     * Getter for domId10Element called 2 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId10Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId10Element() {
      return domId10Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId10Element() {
      // Creation section.
      domId10Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId10());
      // Setup section.


      return domId10Element;
    }

    /**
     * Getter for domId9Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId9Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId9Element() {
      return domId9Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId9Element() {
      // Creation section.
      domId9Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId9());
      // Setup section.


      return domId9Element;
    }

    /**
     * Getter for domId11 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId11;
    private java.lang.String get_domId11() {
      return domId11;
    }
    private java.lang.String build_domId11() {
      // Creation section.
      domId11 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId11;
    }

    /**
     * Getter for simplePencilPanel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_simplePencilPanel() {
      return build_simplePencilPanel();
    }
    private com.google.gwt.user.client.ui.Label build_simplePencilPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label simplePencilPanel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      simplePencilPanel.setStyleName("" + get_res().css().collectionEditImage() + "");


      owner.simplePencilPanel = simplePencilPanel;

      return simplePencilPanel;
    }

    /**
     * Getter for domId11Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId11Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId11Element() {
      return domId11Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId11Element() {
      // Creation section.
      domId11Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId11());
      // Setup section.


      return domId11Element;
    }

    /**
     * Getter for f_HTMLPanel6 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel6() {
      return build_f_HTMLPanel6();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel6() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel6 = new com.google.gwt.user.client.ui.HTMLPanel(template_html8().asString());
      // Setup section.
      f_HTMLPanel6.setStyleName("" + get_res().css().buttonContainerDesc() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1936 = UiBinderUtil.attachToDom(f_HTMLPanel6.getElement());
      get_domId12Element().get();
      get_domId13Element().get();

      // Detach section.
      attachRecord1936.detach();
      f_HTMLPanel6.addAndReplaceElement(get_editSelfCollectionDescSaveButtonCancel(), get_domId12Element().get());
      f_HTMLPanel6.addAndReplaceElement(get_editSelfCollectionDescSaveButton(), get_domId13Element().get());

      return f_HTMLPanel6;
    }

    /**
     * Getter for domId12 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId12;
    private java.lang.String get_domId12() {
      return domId12;
    }
    private java.lang.String build_domId12() {
      // Creation section.
      domId12 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId12;
    }

    /**
     * Getter for editSelfCollectionDescSaveButtonCancel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Button get_editSelfCollectionDescSaveButtonCancel() {
      return build_editSelfCollectionDescSaveButtonCancel();
    }
    private com.google.gwt.user.client.ui.Button build_editSelfCollectionDescSaveButtonCancel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button editSelfCollectionDescSaveButtonCancel = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      editSelfCollectionDescSaveButtonCancel.setStyleName("" + get_res().css().mySelfCollectionEditTitlePreviewCancelButton() + "");
      editSelfCollectionDescSaveButtonCancel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8);


      owner.editSelfCollectionDescSaveButtonCancel = editSelfCollectionDescSaveButtonCancel;

      return editSelfCollectionDescSaveButtonCancel;
    }

    /**
     * Getter for domId12Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId12Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId12Element() {
      return domId12Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId12Element() {
      // Creation section.
      domId12Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId12());
      // Setup section.


      return domId12Element;
    }

    /**
     * Getter for domId13 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId13;
    private java.lang.String get_domId13() {
      return domId13;
    }
    private java.lang.String build_domId13() {
      // Creation section.
      domId13 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId13;
    }

    /**
     * Getter for editSelfCollectionDescSaveButton called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Button get_editSelfCollectionDescSaveButton() {
      return build_editSelfCollectionDescSaveButton();
    }
    private com.google.gwt.user.client.ui.Button build_editSelfCollectionDescSaveButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button editSelfCollectionDescSaveButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      editSelfCollectionDescSaveButton.setStyleName("primary " + get_res().css().mySelfCollectionrEditTitle() + "");
      editSelfCollectionDescSaveButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6);


      owner.editSelfCollectionDescSaveButton = editSelfCollectionDescSaveButton;

      return editSelfCollectionDescSaveButton;
    }

    /**
     * Getter for domId13Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId13Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId13Element() {
      return domId13Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId13Element() {
      // Creation section.
      domId13Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId13());
      // Setup section.


      return domId13Element;
    }

    /**
     * Getter for descriptionAlertMessageLbl called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_descriptionAlertMessageLbl() {
      return build_descriptionAlertMessageLbl();
    }
    private com.google.gwt.user.client.ui.Label build_descriptionAlertMessageLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label descriptionAlertMessageLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      descriptionAlertMessageLbl.setStyleName("" + get_res().css().descriptionAlertMessage() + "");


      owner.descriptionAlertMessageLbl = descriptionAlertMessageLbl;

      return descriptionAlertMessageLbl;
    }

    /**
     * Getter for f_FlowPanel7 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel7() {
      return build_f_FlowPanel7();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel7() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel7 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel7.add(get_collectionPreviewBtn());
      f_FlowPanel7.add(get_copyCollectionLbl());
      f_FlowPanel7.add(get_moveCollectionLbl());
      f_FlowPanel7.add(get_deleteUserCollectionLbl());
      f_FlowPanel7.add(get_lblDeleting());
      f_FlowPanel7.setStyleName("" + get_res().css().panelAlignRight() + "");


      return f_FlowPanel7;
    }

    /**
     * Getter for collectionPreviewBtn called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Button get_collectionPreviewBtn() {
      return build_collectionPreviewBtn();
    }
    private com.google.gwt.user.client.ui.Button build_collectionPreviewBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button collectionPreviewBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      collectionPreviewBtn.setStyleName("primary");
      collectionPreviewBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.collectionPreviewBtn = collectionPreviewBtn;

      return collectionPreviewBtn;
    }

    /**
     * Getter for copyCollectionLbl called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_copyCollectionLbl() {
      return build_copyCollectionLbl();
    }
    private com.google.gwt.user.client.ui.Label build_copyCollectionLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label copyCollectionLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      copyCollectionLbl.setStyleName("" + get_res().css().userCopyCollection() + "");
      copyCollectionLbl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);


      owner.copyCollectionLbl = copyCollectionLbl;

      return copyCollectionLbl;
    }

    /**
     * Getter for moveCollectionLbl called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_moveCollectionLbl() {
      return build_moveCollectionLbl();
    }
    private com.google.gwt.user.client.ui.Label build_moveCollectionLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label moveCollectionLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      moveCollectionLbl.setStyleName("" + get_res().css().userCopyCollection() + "");
      moveCollectionLbl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);


      owner.moveCollectionLbl = moveCollectionLbl;

      return moveCollectionLbl;
    }

    /**
     * Getter for deleteUserCollectionLbl called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_deleteUserCollectionLbl() {
      return build_deleteUserCollectionLbl();
    }
    private com.google.gwt.user.client.ui.Label build_deleteUserCollectionLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label deleteUserCollectionLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      deleteUserCollectionLbl.setStyleName("" + get_res().css().userCopyCollection() + "");
      deleteUserCollectionLbl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.deleteUserCollectionLbl = deleteUserCollectionLbl;

      return deleteUserCollectionLbl;
    }

    /**
     * Getter for lblDeleting called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_lblDeleting() {
      return build_lblDeleting();
    }
    private com.google.gwt.user.client.ui.Label build_lblDeleting() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblDeleting = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblDeleting.setStyleName("pleaseWaitMessage " + get_res().css().deleteDiv() + "");


      owner.lblDeleting = lblDeleting;

      return lblDeleting;
    }

    /**
     * Getter for panelFriendly called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelFriendly() {
      return build_panelFriendly();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelFriendly() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelFriendly = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      panelFriendly.setStyleName("" + get_res().css().objectFloat() + " " + get_res().css().friendlyDiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1937 = UiBinderUtil.attachToDom(panelFriendly.getElement());
      get_domId14Element().get();
      get_domId15Element().get();
      get_domId16Element().get();

      // Detach section.
      attachRecord1937.detach();
      panelFriendly.addAndReplaceElement(get_imgFriendly(), get_domId14Element().get());
      panelFriendly.addAndReplaceElement(get_lblFriendly(), get_domId15Element().get());
      panelFriendly.addAndReplaceElement(get_imgNotFriendly(), get_domId16Element().get());

      owner.panelFriendly = panelFriendly;

      return panelFriendly;
    }

    /**
     * Getter for domId14 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId14;
    private java.lang.String get_domId14() {
      return domId14;
    }
    private java.lang.String build_domId14() {
      // Creation section.
      domId14 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId14;
    }

    /**
     * Getter for imgFriendly called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Image get_imgFriendly() {
      return build_imgFriendly();
    }
    private com.google.gwt.user.client.ui.Image build_imgFriendly() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image imgFriendly = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      imgFriendly.setStyleName("" + get_res().css().objectFloat() + "");


      owner.imgFriendly = imgFriendly;

      return imgFriendly;
    }

    /**
     * Getter for domId14Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId14Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId14Element() {
      return domId14Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId14Element() {
      // Creation section.
      domId14Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId14());
      // Setup section.


      return domId14Element;
    }

    /**
     * Getter for domId15 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId15;
    private java.lang.String get_domId15() {
      return domId15;
    }
    private java.lang.String build_domId15() {
      // Creation section.
      domId15 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId15;
    }

    /**
     * Getter for lblFriendly called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_lblFriendly() {
      return build_lblFriendly();
    }
    private com.google.gwt.user.client.ui.Label build_lblFriendly() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblFriendly = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblFriendly.setStyleName("" + get_res().css().objectFloat() + " " + get_res().css().objectFontType() + "");


      owner.lblFriendly = lblFriendly;

      return lblFriendly;
    }

    /**
     * Getter for domId15Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId15Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId15Element() {
      return domId15Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId15Element() {
      // Creation section.
      domId15Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId15());
      // Setup section.


      return domId15Element;
    }

    /**
     * Getter for domId16 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId16;
    private java.lang.String get_domId16() {
      return domId16;
    }
    private java.lang.String build_domId16() {
      // Creation section.
      domId16 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId16;
    }

    /**
     * Getter for imgNotFriendly called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Image get_imgNotFriendly() {
      return build_imgNotFriendly();
    }
    private com.google.gwt.user.client.ui.Image build_imgNotFriendly() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image imgNotFriendly = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      imgNotFriendly.setStyleName("friendlyQuestionMark");


      owner.imgNotFriendly = imgNotFriendly;

      return imgNotFriendly;
    }

    /**
     * Getter for domId16Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId16Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId16Element() {
      return domId16Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId16Element() {
      // Creation section.
      domId16Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId16());
      // Setup section.


      return domId16Element;
    }

    /**
     * Getter for f_FlowPanel8 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel8() {
      return build_f_FlowPanel8();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel8() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel8 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel8.add(get_infoTabVc());
      f_FlowPanel8.add(get_resourceTabVc());
      f_FlowPanel8.add(get_shareTabVc());
      f_FlowPanel8.add(get_assignTabVc());
      f_FlowPanel8.add(get_collaboratorTabVc());
      f_FlowPanel8.add(get_collPopup());
      f_FlowPanel8.add(get_statisticsTabVc());
      f_FlowPanel8.add(get_statPopup());
      f_FlowPanel8.setStyleName("" + get_res().css().userCollectionMetaDataInfoContainer() + "");


      return f_FlowPanel8;
    }

    /**
     * Getter for infoTabVc called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc get_infoTabVc() {
      return build_infoTabVc();
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc build_infoTabVc() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc infoTabVc = (org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc.class);
      // Setup section.


      owner.infoTabVc = infoTabVc;

      return infoTabVc;
    }

    /**
     * Getter for resourceTabVc called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc get_resourceTabVc() {
      return build_resourceTabVc();
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc build_resourceTabVc() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc resourceTabVc = (org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc.class);
      // Setup section.
      resourceTabVc.setEnabled(true);


      owner.resourceTabVc = resourceTabVc;

      return resourceTabVc;
    }

    /**
     * Getter for shareTabVc called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc get_shareTabVc() {
      return build_shareTabVc();
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc build_shareTabVc() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc shareTabVc = (org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc.class);
      // Setup section.


      owner.shareTabVc = shareTabVc;

      return shareTabVc;
    }

    /**
     * Getter for assignTabVc called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc get_assignTabVc() {
      return build_assignTabVc();
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc build_assignTabVc() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc assignTabVc = (org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc.class);
      // Setup section.
      assignTabVc.setEnabled(true);
      assignTabVc.setImageStyle("" + get_res().css().userCollectionMetaAssignImage() + "");


      owner.assignTabVc = assignTabVc;

      return assignTabVc;
    }

    /**
     * Getter for collaboratorTabVc called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc get_collaboratorTabVc() {
      return build_collaboratorTabVc();
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc build_collaboratorTabVc() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc collaboratorTabVc = (org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.CollectionTabTitleVc.class);
      // Setup section.
      collaboratorTabVc.setEnabled(true);


      owner.collaboratorTabVc = collaboratorTabVc;

      return collaboratorTabVc;
    }

    /**
     * Getter for collPopup called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_collPopup() {
      return build_collPopup();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_collPopup() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel collPopup = new com.google.gwt.user.client.ui.HTMLPanel(template_html10().asString());
      // Setup section.


      owner.collPopup = collPopup;

      return collPopup;
    }

    /**
     * Getter for statisticsTabVc called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_statisticsTabVc() {
      return build_statisticsTabVc();
    }
    private com.google.gwt.user.client.ui.Label build_statisticsTabVc() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label statisticsTabVc = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      statisticsTabVc.setStyleName("" + get_res().css().analyticsStyle() + "");


      owner.statisticsTabVc = statisticsTabVc;

      return statisticsTabVc;
    }

    /**
     * Getter for statPopup called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_statPopup() {
      return build_statPopup();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_statPopup() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel statPopup = new com.google.gwt.user.client.ui.HTMLPanel(template_html11().asString());
      // Setup section.


      owner.statPopup = statPopup;

      return statPopup;
    }

    /**
     * Getter for collectionMetaDataSimPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_collectionMetaDataSimPanel() {
      return build_collectionMetaDataSimPanel();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_collectionMetaDataSimPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel collectionMetaDataSimPanel = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.
      collectionMetaDataSimPanel.setStyleName("" + get_res().css().metaInfo() + "");


      owner.collectionMetaDataSimPanel = collectionMetaDataSimPanel;

      return collectionMetaDataSimPanel;
    }

    /**
     * Getter for domId2Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId2Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId2Element() {
      return domId2Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId2Element() {
      // Creation section.
      domId2Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId2());
      // Setup section.


      return domId2Element;
    }

    /**
     * Getter for domId17 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId17;
    private java.lang.String get_domId17() {
      return domId17;
    }
    private java.lang.String build_domId17() {
      // Creation section.
      domId17 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId17;
    }

    /**
     * Getter for panelFoooter called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.mvp.home.FooterOrganizeUc get_panelFoooter() {
      return build_panelFoooter();
    }
    private org.ednovo.gooru.client.mvp.home.FooterOrganizeUc build_panelFoooter() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.home.FooterOrganizeUc panelFoooter = (org.ednovo.gooru.client.mvp.home.FooterOrganizeUc) GWT.create(org.ednovo.gooru.client.mvp.home.FooterOrganizeUc.class);
      // Setup section.


      owner.panelFoooter = panelFoooter;

      return panelFoooter;
    }

    /**
     * Getter for domId17Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId17Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId17Element() {
      return domId17Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId17Element() {
      // Creation section.
      domId17Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId17());
      // Setup section.


      return domId17Element;
    }
  }
}
