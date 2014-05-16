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

public class ShelfCollection_ShelfCollectionUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.shelf.list.ShelfCollection>, org.ednovo.gooru.client.mvp.shelf.list.ShelfCollection.ShelfCollectionUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("")
    SafeHtml html2();
     
    @Template("")
    SafeHtml html3();
     
    @Template("")
    SafeHtml html4();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html5(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html6(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html7(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html8(String arg0);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.shelf.list.ShelfCollection owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.shelf.list.ShelfCollection owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.myShelfEditButtonHandler(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.shelf.list.ShelfCollection owner) {
      this.owner = owner;
      build_folderStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2();
    }
    SafeHtml template_html3() {
      return template.html3();
    }
    SafeHtml template_html4() {
      return template.html4();
    }
    SafeHtml template_html5() {
      return template.html5(get_domId5());
    }
    SafeHtml template_html6() {
      return template.html6(get_domId2(), get_domId3(), get_domId4());
    }
    SafeHtml template_html7() {
      return template.html7(get_domId0(), get_domId1());
    }
    SafeHtml template_html8() {
      return template.html8(get_domId6());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.list.ShelfCollection_ShelfCollectionUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.shelf.list.ShelfCollection_ShelfCollectionUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.list.ShelfCollection_ShelfCollectionUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.shelf.list.ShelfCollection_ShelfCollectionUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.list.ShelfCollection_ShelfCollectionUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 5 times. Type: IMPORTED. Build precedence: 1.
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
     * Getter for folderStyle called 10 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.list.ShelfCollection_ShelfCollectionUiBinderImpl_GenCss_folderStyle folderStyle;
    private org.ednovo.gooru.client.mvp.shelf.list.ShelfCollection_ShelfCollectionUiBinderImpl_GenCss_folderStyle get_folderStyle() {
      return folderStyle;
    }
    private org.ednovo.gooru.client.mvp.shelf.list.ShelfCollection_ShelfCollectionUiBinderImpl_GenCss_folderStyle build_folderStyle() {
      // Creation section.
      folderStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().folderStyle();
      // Setup section.
      folderStyle.ensureInjected();


      owner.folderStyle = folderStyle;

      return folderStyle;
    }

    /**
     * Getter for f_FlowPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel1() {
      return build_f_FlowPanel1();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel1 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel1.add(get_titleFocPanel());
      f_FlowPanel1.add(get_disPanel());


      return f_FlowPanel1;
    }

    /**
     * Getter for titleFocPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FocusPanel get_titleFocPanel() {
      return build_titleFocPanel();
    }
    private com.google.gwt.user.client.ui.FocusPanel build_titleFocPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FocusPanel titleFocPanel = (com.google.gwt.user.client.ui.FocusPanel) GWT.create(com.google.gwt.user.client.ui.FocusPanel.class);
      // Setup section.
      titleFocPanel.add(get_f_FlowPanel2());
      titleFocPanel.setStyleName("" + get_folderStyle().folderLevel() + "");


      owner.titleFocPanel = titleFocPanel;

      return titleFocPanel;
    }

    /**
     * Getter for f_FlowPanel2 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel2() {
      return build_f_FlowPanel2();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel2 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel2.add(get_arrowIcon());
      f_FlowPanel2.add(get_titleLbl());
      f_FlowPanel2.add(get_f_HTMLPanel3());
      f_FlowPanel2.add(get_f_HTMLPanel8());


      return f_FlowPanel2;
    }

    /**
     * Getter for arrowIcon called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_arrowIcon() {
      return build_arrowIcon();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_arrowIcon() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel arrowIcon = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      arrowIcon.setStyleName("" + get_folderStyle().arrow() + "");


      owner.arrowIcon = arrowIcon;

      return arrowIcon;
    }

    /**
     * Getter for titleLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTML get_titleLbl() {
      return build_titleLbl();
    }
    private com.google.gwt.user.client.ui.HTML build_titleLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML titleLbl = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      titleLbl.setStyleName("" + get_folderStyle().title() + "");


      owner.titleLbl = titleLbl;

      return titleLbl;
    }

    /**
     * Getter for f_HTMLPanel3 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel3() {
      return build_f_HTMLPanel3();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.
      f_HTMLPanel3.setStyleName("" + get_folderStyle().emptyHoverContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2097 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
      get_domId0Element().get();
      get_domId1Element().get();

      // Detach section.
      attachRecord2097.detach();
      f_HTMLPanel3.addAndReplaceElement(get_panelToolTip(), get_domId0Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_f_HTMLPanel4(), get_domId1Element().get());

      return f_HTMLPanel3;
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
     * Getter for panelToolTip called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelToolTip() {
      return build_panelToolTip();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelToolTip() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelToolTip = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      panelToolTip.setStyleName("" + get_folderStyle().emptyHover() + "");


      owner.panelToolTip = panelToolTip;

      return panelToolTip;
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
     * Getter for f_HTMLPanel4 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel4() {
      return build_f_HTMLPanel4();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel4 = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.
      f_HTMLPanel4.setStyleName("" + get_folderStyle().tooltipContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2098 = UiBinderUtil.attachToDom(f_HTMLPanel4.getElement());
      get_domId2Element().get();
      get_domId3Element().get();
      get_domId4Element().get();

      // Detach section.
      attachRecord2098.detach();
      f_HTMLPanel4.addAndReplaceElement(get_f_HTMLPanel5(), get_domId2Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_f_HTMLPanel6(), get_domId3Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_f_HTMLPanel7(), get_domId4Element().get());

      return f_HTMLPanel4;
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
     * Getter for f_HTMLPanel5 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel5() {
      return build_f_HTMLPanel5();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel5 = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      f_HTMLPanel5.setStyleName("" + get_folderStyle().arrowBorder() + "");


      return f_HTMLPanel5;
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
     * Getter for f_HTMLPanel6 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel6() {
      return build_f_HTMLPanel6();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel6() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel6 = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      f_HTMLPanel6.setStyleName("" + get_folderStyle().arrow() + "");


      return f_HTMLPanel6;
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
     * Getter for domId4 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for f_HTMLPanel7 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel7() {
      return build_f_HTMLPanel7();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel7() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel7 = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.
      f_HTMLPanel7.setStyleName("" + get_folderStyle().tooltipContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2099 = UiBinderUtil.attachToDom(f_HTMLPanel7.getElement());
      get_domId5Element().get();

      // Detach section.
      attachRecord2099.detach();
      f_HTMLPanel7.addAndReplaceElement(get_htmlToolTipContent(), get_domId5Element().get());

      return f_HTMLPanel7;
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
     * Getter for htmlToolTipContent called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTML get_htmlToolTipContent() {
      return build_htmlToolTipContent();
    }
    private com.google.gwt.user.client.ui.HTML build_htmlToolTipContent() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML htmlToolTipContent = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.


      owner.htmlToolTipContent = htmlToolTipContent;

      return htmlToolTipContent;
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
     * Getter for domId4Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for f_HTMLPanel8 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel8() {
      return build_f_HTMLPanel8();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel8() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel8 = new com.google.gwt.user.client.ui.HTMLPanel(template_html8().asString());
      // Setup section.
      f_HTMLPanel8.setStyleName("" + get_folderStyle().myShelfEditButtonContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2100 = UiBinderUtil.attachToDom(f_HTMLPanel8.getElement());
      get_domId6Element().get();

      // Detach section.
      attachRecord2100.detach();
      f_HTMLPanel8.addAndReplaceElement(get_myShelfEditButton(), get_domId6Element().get());

      return f_HTMLPanel8;
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
     * Getter for myShelfEditButton called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Button get_myShelfEditButton() {
      return build_myShelfEditButton();
    }
    private com.google.gwt.user.client.ui.Button build_myShelfEditButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button myShelfEditButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      myShelfEditButton.setStyleName("secondary");
      myShelfEditButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.myShelfEditButton = myShelfEditButton;

      return myShelfEditButton;
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
     * Getter for disPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.DisclosurePanel get_disPanel() {
      return build_disPanel();
    }
    private com.google.gwt.user.client.ui.DisclosurePanel build_disPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.DisclosurePanel disPanel = (com.google.gwt.user.client.ui.DisclosurePanel) GWT.create(com.google.gwt.user.client.ui.DisclosurePanel.class);
      // Setup section.
      disPanel.add(get_wrapperFocPanel());
      disPanel.setHeader(get_f_SimplePanel11());
      disPanel.setStyleName("" + get_res().css().shelfCollection() + "");
      disPanel.setAnimationEnabled(true);


      owner.disPanel = disPanel;

      return disPanel;
    }

    /**
     * Getter for wrapperFocPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FocusPanel get_wrapperFocPanel() {
      return build_wrapperFocPanel();
    }
    private com.google.gwt.user.client.ui.FocusPanel build_wrapperFocPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FocusPanel wrapperFocPanel = (com.google.gwt.user.client.ui.FocusPanel) GWT.create(com.google.gwt.user.client.ui.FocusPanel.class);
      // Setup section.
      wrapperFocPanel.add(get_glassContainer());
      wrapperFocPanel.setStyleName("" + get_res().css().shelfContentWrapperPanelForFolders() + "");


      owner.wrapperFocPanel = wrapperFocPanel;

      return wrapperFocPanel;
    }

    /**
     * Getter for glassContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.LabelGlassPanel get_glassContainer() {
      return build_glassContainer();
    }
    private org.ednovo.gooru.client.uc.LabelGlassPanel build_glassContainer() {
      // Creation section.
      final org.ednovo.gooru.client.uc.LabelGlassPanel glassContainer = (org.ednovo.gooru.client.uc.LabelGlassPanel) GWT.create(org.ednovo.gooru.client.uc.LabelGlassPanel.class);
      // Setup section.
      glassContainer.setContent(get_f_FlowPanel9());
      glassContainer.setGlassText("");
      glassContainer.setGlassStyleName("" + get_res().css().shelfGlassPanel() + "");
      glassContainer.setTopStyleName("" + get_res().css().shelfGlassTopPanel() + "");


      owner.glassContainer = glassContainer;

      return glassContainer;
    }

    /**
     * Getter for f_FlowPanel9 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel9() {
      return build_f_FlowPanel9();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel9() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel9 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel9.add(get_addSuccessMsg());
      f_FlowPanel9.add(get_f_SimplePanel10());


      return f_FlowPanel9;
    }

    /**
     * Getter for addSuccessMsg called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_addSuccessMsg() {
      return build_addSuccessMsg();
    }
    private com.google.gwt.user.client.ui.Label build_addSuccessMsg() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label addSuccessMsg = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.addSuccessMsg = addSuccessMsg;

      return addSuccessMsg;
    }

    /**
     * Getter for f_SimplePanel10 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_f_SimplePanel10() {
      return build_f_SimplePanel10();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_f_SimplePanel10() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel f_SimplePanel10 = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.
      f_SimplePanel10.add(get_contentVerPanel());
      f_SimplePanel10.setStyleName("" + get_res().css().shelfContentPanelForFolders() + "");


      return f_SimplePanel10;
    }

    /**
     * Getter for contentVerPanel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.VerticalPanel get_contentVerPanel() {
      return build_contentVerPanel();
    }
    private com.google.gwt.user.client.ui.VerticalPanel build_contentVerPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.VerticalPanel contentVerPanel = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
      // Setup section.


      owner.contentVerPanel = contentVerPanel;

      return contentVerPanel;
    }

    /**
     * Getter for f_SimplePanel11 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_f_SimplePanel11() {
      return build_f_SimplePanel11();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_f_SimplePanel11() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel f_SimplePanel11 = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.


      return f_SimplePanel11;
    }
  }
}
