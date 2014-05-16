package org.ednovo.gooru.client.mvp.classpages.edit;

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

public class EditClasspageView_EditClassPageViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.classpages.edit.EditClasspageView>, org.ednovo.gooru.client.mvp.classpages.edit.EditClasspageView.EditClassPageViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span>")
    SafeHtml html1(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html2(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span><span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html3(String arg0, String arg1, String arg2, String arg3);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html4(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html5(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html6(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html7(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html8(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html9(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html10(String arg0, String arg1, String arg2);
     
    @Template("")
    SafeHtml html11();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span>")
    SafeHtml html12(String arg0, String arg1, String arg2, String arg3, String arg4);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html13(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span>  <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html14(String arg0, String arg1, String arg2);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.classpages.edit.EditClasspageView owner) {


    return new Widgets(owner).get_mainFlowPanel();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.classpages.edit.EditClasspageView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.OnClickDeleteClasspage(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.OnClickStudentView(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.OnClickNewAssignment(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickedOneditSelfCollectionSaveButton(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickedOnclassPageSaveButtonCancel(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.classpages.edit.EditClasspageView owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId18();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId15();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId17();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId23();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId14();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId16();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId20();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId21();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId22();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId19();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId24();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId25();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId27();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId28();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId29();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId26();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId18Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId15Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId17Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId23Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId14Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId16Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId20Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId21Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId22Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId19Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId24Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId25Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId27Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId28Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId29Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId26Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
    }

    SafeHtml template_html1() {
      return template.html1(get_domId5());
    }
    SafeHtml template_html2() {
      return template.html2(get_domId6(), get_domId7());
    }
    SafeHtml template_html3() {
      return template.html3(get_domId1(), get_domId2(), get_domId3(), get_domId4());
    }
    SafeHtml template_html4() {
      return template.html4(get_domId10(), get_domId11(), get_domId12());
    }
    SafeHtml template_html5() {
      return template.html5(get_domId15());
    }
    SafeHtml template_html6() {
      return template.html6(get_domId18());
    }
    SafeHtml template_html7() {
      return template.html7(get_domId17());
    }
    SafeHtml template_html8() {
      return template.html8(get_domId14(), get_domId16());
    }
    SafeHtml template_html9() {
      return template.html9(get_domId23());
    }
    SafeHtml template_html10() {
      return template.html10(get_domId20(), get_domId21(), get_domId22());
    }
    SafeHtml template_html11() {
      return template.html11();
    }
    SafeHtml template_html12() {
      return template.html12(get_domId9(), get_domId13(), get_domId19(), get_domId24(), get_domId25());
    }
    SafeHtml template_html13() {
      return template.html13(get_domId27(), get_domId28(), get_domId29());
    }
    SafeHtml template_html14() {
      return template.html14(get_domId0(), get_domId8(), get_domId26());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.classpages.edit.EditClasspageView_EditClassPageViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.classpages.edit.EditClasspageView_EditClassPageViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.classpages.edit.EditClasspageView_EditClassPageViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.classpages.edit.EditClasspageView_EditClassPageViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.classpages.edit.EditClasspageView_EditClassPageViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 29 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.classpages.edit.EditClasspageCBundle res;
    private org.ednovo.gooru.client.mvp.classpages.edit.EditClasspageCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.mvp.classpages.edit.EditClasspageCBundle build_res() {
      // Creation section.
      res = owner.res;
      assert res != null : "UiField res with 'provided = true' was null";
      // Setup section.


      return res;
    }

    /**
     * Getter for mainFlowPanel called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_mainFlowPanel() {
      return build_mainFlowPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_mainFlowPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel mainFlowPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      mainFlowPanel.add(get_f_HTMLPanel1());
      mainFlowPanel.add(get_f_FooterUc11());


      owner.mainFlowPanel = mainFlowPanel;

      return mainFlowPanel;
    }

    /**
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html14().asString());
      // Setup section.
      f_HTMLPanel1.setStyleName("" + get_res().css().newMockLeftAlignController() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2103 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId0Element().get();
      get_domId8Element().get();
      get_domId26Element().get();

      // Detach section.
      attachRecord2103.detach();
      f_HTMLPanel1.addAndReplaceElement(get_collectionFloPanel(), get_domId0Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_mainContainer(), get_domId8Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_frameDiv(), get_domId26Element().get());

      return f_HTMLPanel1;
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
     * Getter for collectionFloPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FocusPanel get_collectionFloPanel() {
      return build_collectionFloPanel();
    }
    private com.google.gwt.user.client.ui.FocusPanel build_collectionFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FocusPanel collectionFloPanel = (com.google.gwt.user.client.ui.FocusPanel) GWT.create(com.google.gwt.user.client.ui.FocusPanel.class);
      // Setup section.
      collectionFloPanel.add(get_f_HTMLPanel2());
      collectionFloPanel.setStyleName("" + get_res().css().myCollectionShareStudentContainer() + "");


      owner.collectionFloPanel = collectionFloPanel;

      return collectionFloPanel;
    }

    /**
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_res().css().headerContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2104 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_domId1Element().get();
      get_domId2Element().get();
      get_domId3Element().get();
      get_domId4Element().get();

      // Detach section.
      attachRecord2104.detach();
      f_HTMLPanel2.addAndReplaceElement(get_imgClasspageImage(), get_domId1Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_btnEditImage(), get_domId2Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_btnStudentView(), get_domId3Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_f_FlowPanel3(), get_domId4Element().get());

      return f_HTMLPanel2;
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
     * Getter for imgClasspageImage called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Image get_imgClasspageImage() {
      return build_imgClasspageImage();
    }
    private com.google.gwt.user.client.ui.Image build_imgClasspageImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image imgClasspageImage = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      imgClasspageImage.setStyleName("" + get_res().css().classpageImage() + "");
      imgClasspageImage.setHeight("180");
      imgClasspageImage.setWidth("1000");


      owner.imgClasspageImage = imgClasspageImage;

      return imgClasspageImage;
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
     * Getter for domId2 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for btnEditImage called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Button get_btnEditImage() {
      return build_btnEditImage();
    }
    private com.google.gwt.user.client.ui.Button build_btnEditImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button btnEditImage = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      btnEditImage.setStyleName("secondary " + get_res().css().classpageEditButton() + "");


      owner.btnEditImage = btnEditImage;

      return btnEditImage;
    }

    /**
     * Getter for domId2Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId3 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for btnStudentView called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Button get_btnStudentView() {
      return build_btnStudentView();
    }
    private com.google.gwt.user.client.ui.Button build_btnStudentView() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button btnStudentView = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      btnStudentView.setStyleName("primary " + get_res().css().classpageHoverButton() + "");
      btnStudentView.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.btnStudentView = btnStudentView;

      return btnStudentView;
    }

    /**
     * Getter for domId3Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId4 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_FlowPanel3 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel3() {
      return build_f_FlowPanel3();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel3 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel3.add(get_simplePencilFocPanel());
      f_FlowPanel3.add(get_panelUpdateActionContols());
      f_FlowPanel3.add(get_f_FlowPanel6());
      f_FlowPanel3.setStyleName("" + get_res().css().userCollectionInfo() + "");


      return f_FlowPanel3;
    }

    /**
     * Getter for simplePencilFocPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FocusPanel get_simplePencilFocPanel() {
      return build_simplePencilFocPanel();
    }
    private com.google.gwt.user.client.ui.FocusPanel build_simplePencilFocPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FocusPanel simplePencilFocPanel = (com.google.gwt.user.client.ui.FocusPanel) GWT.create(com.google.gwt.user.client.ui.FocusPanel.class);
      // Setup section.
      simplePencilFocPanel.add(get_f_HTMLPanel4());
      simplePencilFocPanel.setStyleName("" + get_res().css().simplePencil() + "");


      owner.simplePencilFocPanel = simplePencilFocPanel;

      return simplePencilFocPanel;
    }

    /**
     * Getter for f_HTMLPanel4 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel4() {
      return build_f_HTMLPanel4();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel4 = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      f_HTMLPanel4.setStyleName("" + get_res().css().myClasspageWrapperTwoChapterText() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2105 = UiBinderUtil.attachToDom(f_HTMLPanel4.getElement());
      get_domId5Element().get();

      // Detach section.
      attachRecord2105.detach();
      f_HTMLPanel4.addAndReplaceElement(get_classPageTitle(), get_domId5Element().get());

      return f_HTMLPanel4;
    }

    /**
     * Getter for domId5 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for classPageTitle called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.FocusPanel get_classPageTitle() {
      return build_classPageTitle();
    }
    private com.google.gwt.user.client.ui.FocusPanel build_classPageTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.FocusPanel classPageTitle = (com.google.gwt.user.client.ui.FocusPanel) GWT.create(com.google.gwt.user.client.ui.FocusPanel.class);
      // Setup section.
      classPageTitle.add(get_f_FlowPanel5());


      owner.classPageTitle = classPageTitle;

      return classPageTitle;
    }

    /**
     * Getter for f_FlowPanel5 called 1 times. Type: DEFAULT. Build precedence: 9.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel5() {
      return build_f_FlowPanel5();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel5 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel5.add(get_collectionTitleUc());
      f_FlowPanel5.add(get_btnCollectionEditImage());
      f_FlowPanel5.setStyleName("" + get_res().css().myClassPageTitle() + "");


      return f_FlowPanel5;
    }

    /**
     * Getter for collectionTitleUc called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private org.ednovo.gooru.client.uc.AssignmentEditLabelUc get_collectionTitleUc() {
      return build_collectionTitleUc();
    }
    private org.ednovo.gooru.client.uc.AssignmentEditLabelUc build_collectionTitleUc() {
      // Creation section.
      final org.ednovo.gooru.client.uc.AssignmentEditLabelUc collectionTitleUc = owner.collectionTitleUc;
      assert collectionTitleUc != null : "UiField collectionTitleUc with 'provided = true' was null";
      // Setup section.
      collectionTitleUc.setStyleName("" + get_res().css().myClassPageTitle() + "");


      return collectionTitleUc;
    }

    /**
     * Getter for btnCollectionEditImage called 1 times. Type: DEFAULT. Build precedence: 10.
     */
    private com.google.gwt.user.client.ui.Button get_btnCollectionEditImage() {
      return build_btnCollectionEditImage();
    }
    private com.google.gwt.user.client.ui.Button build_btnCollectionEditImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button btnCollectionEditImage = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      btnCollectionEditImage.setStyleName("secondary " + get_res().css().classpageTitleCancel() + "");


      owner.btnCollectionEditImage = btnCollectionEditImage;

      return btnCollectionEditImage;
    }

    /**
     * Getter for domId5Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for panelUpdateActionContols called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelUpdateActionContols() {
      return build_panelUpdateActionContols();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelUpdateActionContols() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelUpdateActionContols = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      panelUpdateActionContols.setStyleName("" + get_res().css().classPagebuttonContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2106 = UiBinderUtil.attachToDom(panelUpdateActionContols.getElement());
      get_domId6Element().get();
      get_domId7Element().get();

      // Detach section.
      attachRecord2106.detach();
      panelUpdateActionContols.addAndReplaceElement(get_btnClasspageSave(), get_domId6Element().get());
      panelUpdateActionContols.addAndReplaceElement(get_btnClasspageCancel(), get_domId7Element().get());

      owner.panelUpdateActionContols = panelUpdateActionContols;

      return panelUpdateActionContols;
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
     * Getter for btnClasspageSave called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Button get_btnClasspageSave() {
      return build_btnClasspageSave();
    }
    private com.google.gwt.user.client.ui.Button build_btnClasspageSave() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button btnClasspageSave = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      btnClasspageSave.setStyleName("primary " + get_res().css().classpageTitleSave() + "");
      btnClasspageSave.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);


      owner.btnClasspageSave = btnClasspageSave;

      return btnClasspageSave;
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
     * Getter for btnClasspageCancel called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Button get_btnClasspageCancel() {
      return build_btnClasspageCancel();
    }
    private com.google.gwt.user.client.ui.Button build_btnClasspageCancel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button btnClasspageCancel = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      btnClasspageCancel.setStyleName("secondary " + get_res().css().classpageTitleCancel() + "");
      btnClasspageCancel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5);


      owner.btnClasspageCancel = btnClasspageCancel;

      return btnClasspageCancel;
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
     * Getter for f_FlowPanel6 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel6() {
      return build_f_FlowPanel6();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel6() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel6 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel6.add(get_titleAlertMessageLbl());
      f_FlowPanel6.setStyleName("" + get_res().css().titleAlertContainer() + "");


      return f_FlowPanel6;
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
     * Getter for domId4Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId8 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for mainContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_mainContainer() {
      return build_mainContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_mainContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel mainContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html12().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2107 = UiBinderUtil.attachToDom(mainContainer.getElement());
      get_domId9Element().get();
      get_domId13Element().get();
      get_domId19Element().get();
      get_domId24Element().get();
      get_domId25Element().get();

      // Detach section.
      attachRecord2107.detach();
      mainContainer.addAndReplaceElement(get_f_HTMLPanel7(), get_domId9Element().get());
      mainContainer.addAndReplaceElement(get_newAssignmentAndMsgPanel(), get_domId13Element().get());
      mainContainer.addAndReplaceElement(get_assignmentsTabContainerPanel(), get_domId19Element().get());
      mainContainer.addAndReplaceElement(get_classListContainer(), get_domId24Element().get());
      mainContainer.addAndReplaceElement(get_shareTabContainerPanel(), get_domId25Element().get());

      owner.mainContainer = mainContainer;

      return mainContainer;
    }

    /**
     * Getter for domId9 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for f_HTMLPanel7 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel7() {
      return build_f_HTMLPanel7();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel7() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel7 = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      f_HTMLPanel7.setStyleName("" + get_res().css().teachTab() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2108 = UiBinderUtil.attachToDom(f_HTMLPanel7.getElement());
      get_domId10Element().get();
      get_domId11Element().get();
      get_domId12Element().get();

      // Detach section.
      attachRecord2108.detach();
      f_HTMLPanel7.addAndReplaceElement(get_assignmentsTab(), get_domId10Element().get());
      f_HTMLPanel7.addAndReplaceElement(get_classListTab(), get_domId11Element().get());
      f_HTMLPanel7.addAndReplaceElement(get_reportsTab(), get_domId12Element().get());

      return f_HTMLPanel7;
    }

    /**
     * Getter for domId10 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for assignmentsTab called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Button get_assignmentsTab() {
      return build_assignmentsTab();
    }
    private com.google.gwt.user.client.ui.Button build_assignmentsTab() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button assignmentsTab = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      assignmentsTab.setStyleName("" + get_res().css().selected() + "");


      owner.assignmentsTab = assignmentsTab;

      return assignmentsTab;
    }

    /**
     * Getter for domId10Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId11 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for classListTab called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Button get_classListTab() {
      return build_classListTab();
    }
    private com.google.gwt.user.client.ui.Button build_classListTab() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button classListTab = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      classListTab.setStyleName("");


      owner.classListTab = classListTab;

      return classListTab;
    }

    /**
     * Getter for domId11Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId12 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for reportsTab called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Button get_reportsTab() {
      return build_reportsTab();
    }
    private com.google.gwt.user.client.ui.Button build_reportsTab() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button reportsTab = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      reportsTab.setStyleName("");


      owner.reportsTab = reportsTab;

      return reportsTab;
    }

    /**
     * Getter for domId12Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId9Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId13 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for newAssignmentAndMsgPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_newAssignmentAndMsgPanel() {
      return build_newAssignmentAndMsgPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_newAssignmentAndMsgPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel newAssignmentAndMsgPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html8().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2109 = UiBinderUtil.attachToDom(newAssignmentAndMsgPanel.getElement());
      get_domId14Element().get();
      get_domId16Element().get();

      // Detach section.
      attachRecord2109.detach();
      newAssignmentAndMsgPanel.addAndReplaceElement(get_f_HTMLPanel8(), get_domId14Element().get());
      newAssignmentAndMsgPanel.addAndReplaceElement(get_noAssignmentsMessagePanel(), get_domId16Element().get());

      owner.newAssignmentAndMsgPanel = newAssignmentAndMsgPanel;

      return newAssignmentAndMsgPanel;
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
     * Getter for f_HTMLPanel8 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel8() {
      return build_f_HTMLPanel8();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel8() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel8 = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2110 = UiBinderUtil.attachToDom(f_HTMLPanel8.getElement());
      get_domId15Element().get();

      // Detach section.
      attachRecord2110.detach();
      f_HTMLPanel8.addAndReplaceElement(get_btnNewAssignment(), get_domId15Element().get());

      return f_HTMLPanel8;
    }

    /**
     * Getter for domId15 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for btnNewAssignment called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Button get_btnNewAssignment() {
      return build_btnNewAssignment();
    }
    private com.google.gwt.user.client.ui.Button build_btnNewAssignment() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button btnNewAssignment = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      btnNewAssignment.setStyleName("secondary plusButton " + get_res().css().addAssignment() + "");
      btnNewAssignment.setText("");
      btnNewAssignment.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);


      owner.btnNewAssignment = btnNewAssignment;

      return btnNewAssignment;
    }

    /**
     * Getter for domId15Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for noAssignmentsMessagePanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_noAssignmentsMessagePanel() {
      return build_noAssignmentsMessagePanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_noAssignmentsMessagePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel noAssignmentsMessagePanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2111 = UiBinderUtil.attachToDom(noAssignmentsMessagePanel.getElement());
      get_domId17Element().get();

      // Detach section.
      attachRecord2111.detach();
      noAssignmentsMessagePanel.addAndReplaceElement(get_f_HTMLPanel9(), get_domId17Element().get());

      owner.noAssignmentsMessagePanel = noAssignmentsMessagePanel;

      return noAssignmentsMessagePanel;
    }

    /**
     * Getter for domId17 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for f_HTMLPanel9 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel9() {
      return build_f_HTMLPanel9();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel9() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel9 = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.
      f_HTMLPanel9.setStyleName("" + get_res().css().classpageHover() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2112 = UiBinderUtil.attachToDom(f_HTMLPanel9.getElement());
      get_domId18Element().get();

      // Detach section.
      attachRecord2112.detach();
      f_HTMLPanel9.addAndReplaceElement(get_noAssignmentsMessageLblTwo(), get_domId18Element().get());

      return f_HTMLPanel9;
    }

    /**
     * Getter for domId18 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
     */
    private java.lang.String domId18;
    private java.lang.String get_domId18() {
      return domId18;
    }
    private java.lang.String build_domId18() {
      // Creation section.
      domId18 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId18;
    }

    /**
     * Getter for noAssignmentsMessageLblTwo called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_noAssignmentsMessageLblTwo() {
      return build_noAssignmentsMessageLblTwo();
    }
    private com.google.gwt.user.client.ui.Label build_noAssignmentsMessageLblTwo() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label noAssignmentsMessageLblTwo = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      noAssignmentsMessageLblTwo.setStyleName("" + get_res().css().classpageHoverTitle() + "");


      owner.noAssignmentsMessageLblTwo = noAssignmentsMessageLblTwo;

      return noAssignmentsMessageLblTwo;
    }

    /**
     * Getter for domId18Element called 2 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId18Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId18Element() {
      return domId18Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId18Element() {
      // Creation section.
      domId18Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId18());
      // Setup section.


      return domId18Element;
    }

    /**
     * Getter for domId17Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId13Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId19 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId19;
    private java.lang.String get_domId19() {
      return domId19;
    }
    private java.lang.String build_domId19() {
      // Creation section.
      domId19 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId19;
    }

    /**
     * Getter for assignmentsTabContainerPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_assignmentsTabContainerPanel() {
      return build_assignmentsTabContainerPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_assignmentsTabContainerPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel assignmentsTabContainerPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html10().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2113 = UiBinderUtil.attachToDom(assignmentsTabContainerPanel.getElement());
      get_domId20Element().get();
      get_domId21Element().get();
      get_domId22Element().get();

      // Detach section.
      attachRecord2113.detach();
      assignmentsTabContainerPanel.addAndReplaceElement(get_assignmentsContainerPanel(), get_domId20Element().get());
      assignmentsTabContainerPanel.addAndReplaceElement(get_paginationFocPanel(), get_domId21Element().get());
      assignmentsTabContainerPanel.addAndReplaceElement(get_f_HTMLPanel10(), get_domId22Element().get());

      owner.assignmentsTabContainerPanel = assignmentsTabContainerPanel;

      return assignmentsTabContainerPanel;
    }

    /**
     * Getter for domId20 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId20;
    private java.lang.String get_domId20() {
      return domId20;
    }
    private java.lang.String build_domId20() {
      // Creation section.
      domId20 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId20;
    }

    /**
     * Getter for assignmentsContainerPanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_assignmentsContainerPanel() {
      return build_assignmentsContainerPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_assignmentsContainerPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel assignmentsContainerPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      assignmentsContainerPanel.setStyleName("" + get_res().css().assignmentsContainer() + "");


      owner.assignmentsContainerPanel = assignmentsContainerPanel;

      return assignmentsContainerPanel;
    }

    /**
     * Getter for domId20Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId20Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId20Element() {
      return domId20Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId20Element() {
      // Creation section.
      domId20Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId20());
      // Setup section.


      return domId20Element;
    }

    /**
     * Getter for domId21 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId21;
    private java.lang.String get_domId21() {
      return domId21;
    }
    private java.lang.String build_domId21() {
      // Creation section.
      domId21 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId21;
    }

    /**
     * Getter for paginationFocPanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_paginationFocPanel() {
      return build_paginationFocPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_paginationFocPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel paginationFocPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      paginationFocPanel.setStyleName("" + get_res().css().searchResultContainer() + "");


      owner.paginationFocPanel = paginationFocPanel;

      return paginationFocPanel;
    }

    /**
     * Getter for domId21Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId21Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId21Element() {
      return domId21Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId21Element() {
      // Creation section.
      domId21Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId21());
      // Setup section.


      return domId21Element;
    }

    /**
     * Getter for domId22 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
     */
    private java.lang.String domId22;
    private java.lang.String get_domId22() {
      return domId22;
    }
    private java.lang.String build_domId22() {
      // Creation section.
      domId22 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId22;
    }

    /**
     * Getter for f_HTMLPanel10 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel10() {
      return build_f_HTMLPanel10();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel10() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel10 = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      f_HTMLPanel10.setStyleName("" + get_res().css().classpageTopLine() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2114 = UiBinderUtil.attachToDom(f_HTMLPanel10.getElement());
      get_domId23Element().get();

      // Detach section.
      attachRecord2114.detach();
      f_HTMLPanel10.addAndReplaceElement(get_btnDeleteClasspage(), get_domId23Element().get());

      return f_HTMLPanel10;
    }

    /**
     * Getter for domId23 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
     */
    private java.lang.String domId23;
    private java.lang.String get_domId23() {
      return domId23;
    }
    private java.lang.String build_domId23() {
      // Creation section.
      domId23 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId23;
    }

    /**
     * Getter for btnDeleteClasspage called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Button get_btnDeleteClasspage() {
      return build_btnDeleteClasspage();
    }
    private com.google.gwt.user.client.ui.Button build_btnDeleteClasspage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button btnDeleteClasspage = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      btnDeleteClasspage.setStyleName("secondary " + get_res().css().classpageDeleteButton() + "");
      btnDeleteClasspage.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.btnDeleteClasspage = btnDeleteClasspage;

      return btnDeleteClasspage;
    }

    /**
     * Getter for domId23Element called 2 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId23Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId23Element() {
      return domId23Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId23Element() {
      // Creation section.
      domId23Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId23());
      // Setup section.


      return domId23Element;
    }

    /**
     * Getter for domId22Element called 2 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId22Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId22Element() {
      return domId22Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId22Element() {
      // Creation section.
      domId22Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId22());
      // Setup section.


      return domId22Element;
    }

    /**
     * Getter for domId19Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId19Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId19Element() {
      return domId19Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId19Element() {
      // Creation section.
      domId19Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId19());
      // Setup section.


      return domId19Element;
    }

    /**
     * Getter for domId24 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId24;
    private java.lang.String get_domId24() {
      return domId24;
    }
    private java.lang.String build_domId24() {
      // Creation section.
      domId24 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId24;
    }

    /**
     * Getter for classListContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_classListContainer() {
      return build_classListContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_classListContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel classListContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      owner.classListContainer = classListContainer;

      return classListContainer;
    }

    /**
     * Getter for domId24Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId24Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId24Element() {
      return domId24Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId24Element() {
      // Creation section.
      domId24Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId24());
      // Setup section.


      return domId24Element;
    }

    /**
     * Getter for domId25 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId25;
    private java.lang.String get_domId25() {
      return domId25;
    }
    private java.lang.String build_domId25() {
      // Creation section.
      domId25 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId25;
    }

    /**
     * Getter for shareTabContainerPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_shareTabContainerPanel() {
      return build_shareTabContainerPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_shareTabContainerPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel shareTabContainerPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html11().asString());
      // Setup section.


      owner.shareTabContainerPanel = shareTabContainerPanel;

      return shareTabContainerPanel;
    }

    /**
     * Getter for domId25Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId25Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId25Element() {
      return domId25Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId25Element() {
      // Creation section.
      domId25Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId25());
      // Setup section.


      return domId25Element;
    }

    /**
     * Getter for domId8Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId26 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
     */
    private java.lang.String domId26;
    private java.lang.String get_domId26() {
      return domId26;
    }
    private java.lang.String build_domId26() {
      // Creation section.
      domId26 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId26;
    }

    /**
     * Getter for frameDiv called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_frameDiv() {
      return build_frameDiv();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_frameDiv() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel frameDiv = new com.google.gwt.user.client.ui.HTMLPanel(template_html13().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2115 = UiBinderUtil.attachToDom(frameDiv.getElement());
      get_domId27Element().get();
      get_domId28Element().get();
      get_domId29Element().get();

      // Detach section.
      attachRecord2115.detach();
      frameDiv.addAndReplaceElement(get_backArrowButton(), get_domId27Element().get());
      frameDiv.addAndReplaceElement(get_monitorProgress(), get_domId28Element().get());
      frameDiv.addAndReplaceElement(get_frameUrl(), get_domId29Element().get());

      owner.frameDiv = frameDiv;

      return frameDiv;
    }

    /**
     * Getter for domId27 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId27;
    private java.lang.String get_domId27() {
      return domId27;
    }
    private java.lang.String build_domId27() {
      // Creation section.
      domId27 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId27;
    }

    /**
     * Getter for backArrowButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Button get_backArrowButton() {
      return build_backArrowButton();
    }
    private com.google.gwt.user.client.ui.Button build_backArrowButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button backArrowButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      backArrowButton.setStyleName("" + get_res().css().backArrowButton() + " backArrowButton");


      owner.backArrowButton = backArrowButton;

      return backArrowButton;
    }

    /**
     * Getter for domId27Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId27Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId27Element() {
      return domId27Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId27Element() {
      // Creation section.
      domId27Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId27());
      // Setup section.


      return domId27Element;
    }

    /**
     * Getter for domId28 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId28;
    private java.lang.String get_domId28() {
      return domId28;
    }
    private java.lang.String build_domId28() {
      // Creation section.
      domId28 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId28;
    }

    /**
     * Getter for monitorProgress called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Button get_monitorProgress() {
      return build_monitorProgress();
    }
    private com.google.gwt.user.client.ui.Button build_monitorProgress() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button monitorProgress = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      monitorProgress.setStyleName("primary " + get_res().css().monitorButton() + "");


      owner.monitorProgress = monitorProgress;

      return monitorProgress;
    }

    /**
     * Getter for domId28Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId28Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId28Element() {
      return domId28Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId28Element() {
      // Creation section.
      domId28Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId28());
      // Setup section.


      return domId28Element;
    }

    /**
     * Getter for domId29 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId29;
    private java.lang.String get_domId29() {
      return domId29;
    }
    private java.lang.String build_domId29() {
      // Creation section.
      domId29 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId29;
    }

    /**
     * Getter for frameUrl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Frame get_frameUrl() {
      return build_frameUrl();
    }
    private com.google.gwt.user.client.ui.Frame build_frameUrl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Frame frameUrl = (com.google.gwt.user.client.ui.Frame) GWT.create(com.google.gwt.user.client.ui.Frame.class);
      // Setup section.
      frameUrl.setStyleName("" + get_res().css().iframeBorder() + "");
      frameUrl.setHeight("500");
      frameUrl.setWidth("900");


      owner.frameUrl = frameUrl;

      return frameUrl;
    }

    /**
     * Getter for domId29Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId29Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId29Element() {
      return domId29Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId29Element() {
      // Creation section.
      domId29Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId29());
      // Setup section.


      return domId29Element;
    }

    /**
     * Getter for domId26Element called 2 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId26Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId26Element() {
      return domId26Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId26Element() {
      // Creation section.
      domId26Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId26());
      // Setup section.


      return domId26Element;
    }

    /**
     * Getter for f_FooterUc11 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.mvp.home.FooterUc get_f_FooterUc11() {
      return build_f_FooterUc11();
    }
    private org.ednovo.gooru.client.mvp.home.FooterUc build_f_FooterUc11() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.home.FooterUc f_FooterUc11 = (org.ednovo.gooru.client.mvp.home.FooterUc) GWT.create(org.ednovo.gooru.client.mvp.home.FooterUc.class);
      // Setup section.


      return f_FooterUc11;
    }
  }
}
