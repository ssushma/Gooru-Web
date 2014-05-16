package org.ednovo.gooru.client.mvp.shelf.list;

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

public class ShelfListView_ShelfTabViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.shelf.list.ShelfListView>, org.ednovo.gooru.client.mvp.shelf.list.ShelfListView.ShelfTabViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html1(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html2(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html3(String arg0, String arg1);
     
    @Template("")
    SafeHtml html4();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html5(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html6(String arg0);
     
    @Template("")
    SafeHtml html7();
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.shelf.list.ShelfListView owner) {


    return new Widgets(owner).get_shelfFocPanel();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.shelf.list.ShelfListView owner;


    final com.google.gwt.event.dom.client.ScrollHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ScrollHandler() {
      public void onScroll(com.google.gwt.event.dom.client.ScrollEvent event) {
        owner.dragImageSimPanelscroll(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickOnOrganizeRootPnl(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.shelf.list.ShelfListView owner) {
      this.owner = owner;
      build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();  // more than one getter call detected. Type: GENERATED_BUNDLE, precedence: 1
      build_folderStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
    }

    SafeHtml template_html1() {
      return template.html1(get_domId4(), get_domId5());
    }
    SafeHtml template_html2() {
      return template.html2(get_domId2(), get_domId3());
    }
    SafeHtml template_html3() {
      return template.html3(get_domId0(), get_domId1());
    }
    SafeHtml template_html4() {
      return template.html4();
    }
    SafeHtml template_html5() {
      return template.html5(get_domId6());
    }
    SafeHtml template_html6() {
      return template.html6(get_domId7());
    }
    SafeHtml template_html7() {
      return template.html7();
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 2 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.list.ShelfListView_ShelfTabViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    private org.ednovo.gooru.client.mvp.shelf.list.ShelfListView_ShelfTabViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }
    private org.ednovo.gooru.client.mvp.shelf.list.ShelfListView_ShelfTabViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.shelf.list.ShelfListView_ShelfTabViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.list.ShelfListView_ShelfTabViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 2 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.list.ShelfListCBundle res;
    private org.ednovo.gooru.client.mvp.shelf.list.ShelfListCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.mvp.shelf.list.ShelfListCBundle build_res() {
      // Creation section.
      res = owner.res;
      assert res != null : "UiField res with 'provided = true' was null";
      // Setup section.


      return res;
    }

    /**
     * Getter for folderStyle called 6 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.list.ShelfListView_ShelfTabViewUiBinderImpl_GenCss_folderStyle folderStyle;
    private org.ednovo.gooru.client.mvp.shelf.list.ShelfListView_ShelfTabViewUiBinderImpl_GenCss_folderStyle get_folderStyle() {
      return folderStyle;
    }
    private org.ednovo.gooru.client.mvp.shelf.list.ShelfListView_ShelfTabViewUiBinderImpl_GenCss_folderStyle build_folderStyle() {
      // Creation section.
      folderStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().folderStyle();
      // Setup section.
      folderStyle.ensureInjected();


      owner.folderStyle = folderStyle;

      return folderStyle;
    }

    /**
     * Getter for style called 2 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.list.ShelfListView_ShelfTabViewUiBinderImpl_GenCss_style style;
    private org.ednovo.gooru.client.mvp.shelf.list.ShelfListView_ShelfTabViewUiBinderImpl_GenCss_style get_style() {
      return style;
    }
    private org.ednovo.gooru.client.mvp.shelf.list.ShelfListView_ShelfTabViewUiBinderImpl_GenCss_style build_style() {
      // Creation section.
      style = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().style();
      // Setup section.
      style.ensureInjected();


      return style;
    }

    /**
     * Getter for shelfFocPanel called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FocusPanel get_shelfFocPanel() {
      return build_shelfFocPanel();
    }
    private com.google.gwt.user.client.ui.FocusPanel build_shelfFocPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FocusPanel shelfFocPanel = (com.google.gwt.user.client.ui.FocusPanel) GWT.create(com.google.gwt.user.client.ui.FocusPanel.class);
      // Setup section.
      shelfFocPanel.add(get_collectionListScrollpanel());
      shelfFocPanel.setStyleName("" + get_style().shelfPanel() + "");


      owner.shelfFocPanel = shelfFocPanel;

      return shelfFocPanel;
    }

    /**
     * Getter for collectionListScrollpanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.ScrollPanel get_collectionListScrollpanel() {
      return build_collectionListScrollpanel();
    }
    private com.google.gwt.user.client.ui.ScrollPanel build_collectionListScrollpanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.ScrollPanel collectionListScrollpanel = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
      // Setup section.
      collectionListScrollpanel.add(get_f_FlowPanel1());
      collectionListScrollpanel.setStyleName("" + get_style().collectionScrlPanel() + "");
      collectionListScrollpanel.addScrollHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.collectionListScrollpanel = collectionListScrollpanel;

      return collectionListScrollpanel;
    }

    /**
     * Getter for f_FlowPanel1 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel1() {
      return build_f_FlowPanel1();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel1 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel1.add(get_folderCollectionPanel());
      f_FlowPanel1.add(get_organizeButtonPanel());
      f_FlowPanel1.add(get_organizeRootPnl());
      f_FlowPanel1.add(get_folderListPanelEvent());
      f_FlowPanel1.add(get_noCollectionMsgLbl());
      f_FlowPanel1.add(get_myShelfVerPanelHolder());
      f_FlowPanel1.add(get_dragImageSimPanel());
      f_FlowPanel1.setStyleName("" + get_folderStyle().folderPanel() + "");


      return f_FlowPanel1;
    }

    /**
     * Getter for folderCollectionPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_folderCollectionPanel() {
      return build_folderCollectionPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_folderCollectionPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel folderCollectionPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      folderCollectionPanel.add(get_addCollectionItem());
      folderCollectionPanel.add(get_newCollectionShelf());


      owner.folderCollectionPanel = folderCollectionPanel;

      return folderCollectionPanel;
    }

    /**
     * Getter for addCollectionItem called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private org.ednovo.gooru.client.mvp.shelf.list.ShelfAddCollection get_addCollectionItem() {
      return build_addCollectionItem();
    }
    private org.ednovo.gooru.client.mvp.shelf.list.ShelfAddCollection build_addCollectionItem() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.list.ShelfAddCollection addCollectionItem = (org.ednovo.gooru.client.mvp.shelf.list.ShelfAddCollection) GWT.create(org.ednovo.gooru.client.mvp.shelf.list.ShelfAddCollection.class);
      // Setup section.


      owner.addCollectionItem = addCollectionItem;

      return addCollectionItem;
    }

    /**
     * Getter for newCollectionShelf called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private org.ednovo.gooru.client.mvp.shelf.list.ShelfAddCollection get_newCollectionShelf() {
      return build_newCollectionShelf();
    }
    private org.ednovo.gooru.client.mvp.shelf.list.ShelfAddCollection build_newCollectionShelf() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.list.ShelfAddCollection newCollectionShelf = (org.ednovo.gooru.client.mvp.shelf.list.ShelfAddCollection) GWT.create(org.ednovo.gooru.client.mvp.shelf.list.ShelfAddCollection.class);
      // Setup section.


      owner.newCollectionShelf = newCollectionShelf;

      return newCollectionShelf;
    }

    /**
     * Getter for organizeButtonPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_organizeButtonPanel() {
      return build_organizeButtonPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_organizeButtonPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel organizeButtonPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      organizeButtonPanel.setStyleName("" + get_folderStyle().organizeButtons() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2009 = UiBinderUtil.attachToDom(organizeButtonPanel.getElement());
      get_domId0Element().get();
      get_domId1Element().get();

      // Detach section.
      attachRecord2009.detach();
      organizeButtonPanel.addAndReplaceElement(get_backArrowButton(), get_domId0Element().get());
      organizeButtonPanel.addAndReplaceElement(get_f_HTMLPanel2(), get_domId1Element().get());

      owner.organizeButtonPanel = organizeButtonPanel;

      return organizeButtonPanel;
    }

    /**
     * Getter for domId0 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for backArrowButton called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Button get_backArrowButton() {
      return build_backArrowButton();
    }
    private com.google.gwt.user.client.ui.Button build_backArrowButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button backArrowButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      backArrowButton.setStyleName("backArrowButton");


      owner.backArrowButton = backArrowButton;

      return backArrowButton;
    }

    /**
     * Getter for domId0Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId1 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("dropdownButtonContainer " + get_folderStyle().buttonContainerWidth() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2010 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_domId2Element().get();
      get_domId3Element().get();

      // Detach section.
      attachRecord2010.detach();
      f_HTMLPanel2.addAndReplaceElement(get_createBtn(), get_domId2Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_f_HTMLPanel3(), get_domId3Element().get());

      return f_HTMLPanel2;
    }

    /**
     * Getter for domId2 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for createBtn called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Button get_createBtn() {
      return build_createBtn();
    }
    private com.google.gwt.user.client.ui.Button build_createBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button createBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      createBtn.setStyleName("primary dropdownButton");


      owner.createBtn = createBtn;

      return createBtn;
    }

    /**
     * Getter for domId2Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId3 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for f_HTMLPanel3 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel3() {
      return build_f_HTMLPanel3();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      f_HTMLPanel3.setStyleName("dropdown");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2011 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
      get_domId4Element().get();
      get_domId5Element().get();

      // Detach section.
      attachRecord2011.detach();
      f_HTMLPanel3.addAndReplaceElement(get_folderLabel(), get_domId4Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_collectionLabel(), get_domId5Element().get());

      return f_HTMLPanel3;
    }

    /**
     * Getter for domId4 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for folderLabel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_folderLabel() {
      return build_folderLabel();
    }
    private com.google.gwt.user.client.ui.Label build_folderLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label folderLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      folderLabel.setStyleName("option");


      owner.folderLabel = folderLabel;

      return folderLabel;
    }

    /**
     * Getter for domId4Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for collectionLabel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_collectionLabel() {
      return build_collectionLabel();
    }
    private com.google.gwt.user.client.ui.Label build_collectionLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label collectionLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      collectionLabel.setStyleName("option");


      owner.collectionLabel = collectionLabel;

      return collectionLabel;
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
     * Getter for domId3Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId1Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for organizeRootPnl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_organizeRootPnl() {
      return build_organizeRootPnl();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_organizeRootPnl() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel organizeRootPnl = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html5().asString());
      // Setup section.
      organizeRootPnl.setStyleName("" + get_folderStyle().folderLevel() + " " + get_folderStyle().root() + "");
      organizeRootPnl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2012 = UiBinderUtil.attachToDom(organizeRootPnl.getElement());
      get_domId6Element().get();

      // Detach section.
      attachRecord2012.detach();
      organizeRootPnl.addAndReplaceElement(get_organizelbl(), get_domId6Element().get());

      owner.organizeRootPnl = organizeRootPnl;

      return organizeRootPnl;
    }

    /**
     * Getter for domId6 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for organizelbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_organizelbl() {
      return build_organizelbl();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_organizelbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel organizelbl = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      organizelbl.setStyleName("" + get_folderStyle().title() + "");


      owner.organizelbl = organizelbl;

      return organizelbl;
    }

    /**
     * Getter for domId6Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for folderListPanelEvent called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_folderListPanelEvent() {
      return build_folderListPanelEvent();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_folderListPanelEvent() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel folderListPanelEvent = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.
      folderListPanelEvent.setStyleName("" + get_res().css().myFolderCollectionNavContainerHeading() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2013 = UiBinderUtil.attachToDom(folderListPanelEvent.getElement());
      get_domId7Element().get();

      // Detach section.
      attachRecord2013.detach();
      folderListPanelEvent.addAndReplaceElement(get_foldersText(), get_domId7Element().get());

      owner.folderListPanelEvent = folderListPanelEvent;

      return folderListPanelEvent;
    }

    /**
     * Getter for domId7 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for foldersText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_foldersText() {
      return build_foldersText();
    }
    private com.google.gwt.user.client.ui.Label build_foldersText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label foldersText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      foldersText.setStyleName("" + get_res().css().myFolderCollectionNavContainerHeadingText() + "");


      owner.foldersText = foldersText;

      return foldersText;
    }

    /**
     * Getter for domId7Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for noCollectionMsgLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_noCollectionMsgLbl() {
      return build_noCollectionMsgLbl();
    }
    private com.google.gwt.user.client.ui.Label build_noCollectionMsgLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label noCollectionMsgLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.noCollectionMsgLbl = noCollectionMsgLbl;

      return noCollectionMsgLbl;
    }

    /**
     * Getter for myShelfVerPanelHolder called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_myShelfVerPanelHolder() {
      return build_myShelfVerPanelHolder();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_myShelfVerPanelHolder() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel myShelfVerPanelHolder = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.


      owner.myShelfVerPanelHolder = myShelfVerPanelHolder;

      return myShelfVerPanelHolder;
    }

    /**
     * Getter for dragImageSimPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_dragImageSimPanel() {
      return build_dragImageSimPanel();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_dragImageSimPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel dragImageSimPanel = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.


      owner.dragImageSimPanel = dragImageSimPanel;

      return dragImageSimPanel;
    }
  }
}
