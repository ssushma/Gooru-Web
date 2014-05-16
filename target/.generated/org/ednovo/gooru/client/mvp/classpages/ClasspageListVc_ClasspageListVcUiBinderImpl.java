package org.ednovo.gooru.client.mvp.classpages;

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

public class ClasspageListVc_ClasspageListVcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.classpages.ClasspageListVc>, org.ednovo.gooru.client.mvp.classpages.ClasspageListVc.ClasspageListVcUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html2(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html3(String arg0, String arg1, String arg2);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.classpages.ClasspageListVc owner) {


    return new Widgets(owner).get_panelMainContainer();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.classpages.ClasspageListVc owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickNewClasspage(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.classpages.ClasspageListVc owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2(get_domId2(), get_domId3());
    }
    SafeHtml template_html3() {
      return template.html3(get_domId0(), get_domId1(), get_domId4());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.classpages.ClasspageListVc_ClasspageListVcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.classpages.ClasspageListVc_ClasspageListVcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.classpages.ClasspageListVc_ClasspageListVcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.classpages.ClasspageListVc_ClasspageListVcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.classpages.ClasspageListVc_ClasspageListVcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 8 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.classpages.ClasspageListPopupViewCBundle res;
    private org.ednovo.gooru.client.mvp.classpages.ClasspageListPopupViewCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.mvp.classpages.ClasspageListPopupViewCBundle build_res() {
      // Creation section.
      res = owner.res;
      assert res != null : "UiField res with 'provided = true' was null";
      // Setup section.


      return res;
    }

    /**
     * Getter for panelMainContainer called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_panelMainContainer() {
      return build_panelMainContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_panelMainContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel panelMainContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      panelMainContainer.add(get_ancNewClasspage());
      panelMainContainer.add(get_f_HTMLPanel1());
      panelMainContainer.add(get_htmlPanelContentContainer());


      return panelMainContainer;
    }

    /**
     * Getter for ancNewClasspage called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Anchor get_ancNewClasspage() {
      return build_ancNewClasspage();
    }
    private com.google.gwt.user.client.ui.Anchor build_ancNewClasspage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor ancNewClasspage = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      ancNewClasspage.setStyleName("" + get_res().css().newClasspageLink() + "");
      ancNewClasspage.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.ancNewClasspage = ancNewClasspage;

      return ancNewClasspage;
    }

    /**
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      f_HTMLPanel1.setStyleName("" + get_res().css().classpageBottomLine() + "");


      return f_HTMLPanel1;
    }

    /**
     * Getter for htmlPanelContentContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_htmlPanelContentContainer() {
      return build_htmlPanelContentContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_htmlPanelContentContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel htmlPanelContentContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      htmlPanelContentContainer.setStyleName("" + get_res().css().htmlPanelContentContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2007 = UiBinderUtil.attachToDom(htmlPanelContentContainer.getElement());
      get_domId0Element().get();
      get_domId1Element().get();
      get_domId4Element().get();

      // Detach section.
      attachRecord2007.detach();
      htmlPanelContentContainer.addAndReplaceElement(get_lblLoading(), get_domId0Element().get());
      htmlPanelContentContainer.addAndReplaceElement(get_htmlPanelNoClasspageContainer(), get_domId1Element().get());
      htmlPanelContentContainer.addAndReplaceElement(get_spanelCollectionList(), get_domId4Element().get());

      owner.htmlPanelContentContainer = htmlPanelContentContainer;

      return htmlPanelContentContainer;
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
     * Getter for lblLoading called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_lblLoading() {
      return build_lblLoading();
    }
    private com.google.gwt.user.client.ui.Label build_lblLoading() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblLoading = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblLoading.setStyleName("" + get_res().css().loadingText() + "");


      owner.lblLoading = lblLoading;

      return lblLoading;
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
     * Getter for htmlPanelNoClasspageContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_htmlPanelNoClasspageContainer() {
      return build_htmlPanelNoClasspageContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_htmlPanelNoClasspageContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel htmlPanelNoClasspageContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      htmlPanelNoClasspageContainer.setStyleName("" + get_res().css().htmlPanelNoClasspageContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2008 = UiBinderUtil.attachToDom(htmlPanelNoClasspageContainer.getElement());
      get_domId2Element().get();
      get_domId3Element().get();

      // Detach section.
      attachRecord2008.detach();
      htmlPanelNoClasspageContainer.addAndReplaceElement(get_lblNoClasspageYet(), get_domId2Element().get());
      htmlPanelNoClasspageContainer.addAndReplaceElement(get_inLineLblCheckOut(), get_domId3Element().get());

      owner.htmlPanelNoClasspageContainer = htmlPanelNoClasspageContainer;

      return htmlPanelNoClasspageContainer;
    }

    /**
     * Getter for domId2 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for lblNoClasspageYet called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_lblNoClasspageYet() {
      return build_lblNoClasspageYet();
    }
    private com.google.gwt.user.client.ui.Label build_lblNoClasspageYet() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblNoClasspageYet = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblNoClasspageYet.setStyleName("" + get_res().css().noClasspageYet() + "");


      owner.lblNoClasspageYet = lblNoClasspageYet;

      return lblNoClasspageYet;
    }

    /**
     * Getter for domId2Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId3 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for inLineLblCheckOut called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.InlineLabel get_inLineLblCheckOut() {
      return build_inLineLblCheckOut();
    }
    private com.google.gwt.user.client.ui.InlineLabel build_inLineLblCheckOut() {
      // Creation section.
      final com.google.gwt.user.client.ui.InlineLabel inLineLblCheckOut = (com.google.gwt.user.client.ui.InlineLabel) GWT.create(com.google.gwt.user.client.ui.InlineLabel.class);
      // Setup section.


      owner.inLineLblCheckOut = inLineLblCheckOut;

      return inLineLblCheckOut;
    }

    /**
     * Getter for domId3Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId4 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for spanelCollectionList called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.ScrollPanel get_spanelCollectionList() {
      return build_spanelCollectionList();
    }
    private com.google.gwt.user.client.ui.ScrollPanel build_spanelCollectionList() {
      // Creation section.
      final com.google.gwt.user.client.ui.ScrollPanel spanelCollectionList = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
      // Setup section.
      spanelCollectionList.add(get_htmlPanelClasspageList());
      spanelCollectionList.setStyleName("" + get_res().css().scrollPanelClasspageList() + "");


      owner.spanelCollectionList = spanelCollectionList;

      return spanelCollectionList;
    }

    /**
     * Getter for htmlPanelClasspageList called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.VerticalPanel get_htmlPanelClasspageList() {
      return build_htmlPanelClasspageList();
    }
    private com.google.gwt.user.client.ui.VerticalPanel build_htmlPanelClasspageList() {
      // Creation section.
      final com.google.gwt.user.client.ui.VerticalPanel htmlPanelClasspageList = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
      // Setup section.
      htmlPanelClasspageList.setStyleName("" + get_res().css().htmlPanelClasspageList() + "");


      owner.htmlPanelClasspageList = htmlPanelClasspageList;

      return htmlPanelClasspageList;
    }

    /**
     * Getter for domId4Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
  }
}
