package org.ednovo.gooru.client.mvp.shelf.collection.folders.uc;

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

public class FolderPopupChildItem_FolderPopupChildItemUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.shelf.collection.folders.uc.FolderPopupChildItem>, org.ednovo.gooru.client.mvp.shelf.collection.folders.uc.FolderPopupChildItem.FolderPopupChildItemUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html2(String arg0, String arg1);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.shelf.collection.folders.uc.FolderPopupChildItem owner) {


    return new Widgets(owner).get_folderLevel();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.shelf.collection.folders.uc.FolderPopupChildItem owner;


    public Widgets(final org.ednovo.gooru.client.mvp.shelf.collection.folders.uc.FolderPopupChildItem owner) {
      this.owner = owner;
      build_folderPopupStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2(get_domId0(), get_domId1());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.folders.uc.FolderPopupChildItem_FolderPopupChildItemUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.folders.uc.FolderPopupChildItem_FolderPopupChildItemUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.collection.folders.uc.FolderPopupChildItem_FolderPopupChildItemUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.shelf.collection.folders.uc.FolderPopupChildItem_FolderPopupChildItemUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.folders.uc.FolderPopupChildItem_FolderPopupChildItemUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for folderPopupStyle called 3 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.folders.uc.FolderPopupChildItem_FolderPopupChildItemUiBinderImpl_GenCss_folderPopupStyle folderPopupStyle;
    private org.ednovo.gooru.client.mvp.shelf.collection.folders.uc.FolderPopupChildItem_FolderPopupChildItemUiBinderImpl_GenCss_folderPopupStyle get_folderPopupStyle() {
      return folderPopupStyle;
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.folders.uc.FolderPopupChildItem_FolderPopupChildItemUiBinderImpl_GenCss_folderPopupStyle build_folderPopupStyle() {
      // Creation section.
      folderPopupStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().folderPopupStyle();
      // Setup section.
      folderPopupStyle.ensureInjected();


      owner.folderPopupStyle = folderPopupStyle;

      return folderPopupStyle;
    }

    /**
     * Getter for folderLevel called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_folderLevel() {
      return build_folderLevel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_folderLevel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel folderLevel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html2().asString());
      // Setup section.
      folderLevel.setStyleName("" + get_folderPopupStyle().folderLevel() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord713 = UiBinderUtil.attachToDom(folderLevel.getElement());
      get_domId0Element().get();
      get_domId1Element().get();

      // Detach section.
      attachRecord713.detach();
      folderLevel.addAndReplaceElement(get_arrow(), get_domId0Element().get());
      folderLevel.addAndReplaceElement(get_title(), get_domId1Element().get());

      owner.folderLevel = folderLevel;

      return folderLevel;
    }

    /**
     * Getter for domId0 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for arrow called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_arrow() {
      return build_arrow();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_arrow() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel arrow = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      arrow.setStyleName("" + get_folderPopupStyle().arrow() + "");


      owner.arrow = arrow;

      return arrow;
    }

    /**
     * Getter for domId0Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
     * Getter for domId1 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for title called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_title() {
      return build_title();
    }
    private com.google.gwt.user.client.ui.Label build_title() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label title = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      title.setStyleName("" + get_folderPopupStyle().title() + "");


      owner.title = title;

      return title;
    }

    /**
     * Getter for domId1Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
  }
}
