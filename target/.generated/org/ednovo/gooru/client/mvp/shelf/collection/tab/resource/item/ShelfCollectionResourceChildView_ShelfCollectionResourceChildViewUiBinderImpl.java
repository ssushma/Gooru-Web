package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item;

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

public class ShelfCollectionResourceChildView_ShelfCollectionResourceChildViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.ShelfCollectionResourceChildView>, org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.ShelfCollectionResourceChildView.ShelfCollectionResourceChildViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span>")
    SafeHtml html1(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html2(String arg0, String arg1);
     
    @Template("")
    SafeHtml html3();
     
    @Template("")
    SafeHtml html4();
     
    @Template("")
    SafeHtml html5();
     
    @Template("")
    SafeHtml html6();
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.ShelfCollectionResourceChildView owner) {


    return new Widgets(owner).get_resourceFlowPanel();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.ShelfCollectionResourceChildView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickEdit(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onEditClick(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.oneditStartPageLblClick(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.updatePdfBtnClick(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.cancelpdfBtnClick(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onPencilNarationClick(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.copyResource(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.deleteCollectionItem(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames9 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onclickOfnarrationUpdate(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames10 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onclickcancelNarrationBtn(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames11 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onclickEditVideoTimeLbl(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames12 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.updateVideoTimeBtnClickEvent(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames13 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.cancelVideoTimeBtnClickEvent(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.ShelfCollectionResourceChildView owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
    }

    SafeHtml template_html1() {
      return template.html1(get_domId1());
    }
    SafeHtml template_html2() {
      return template.html2(get_domId0(), get_domId2());
    }
    SafeHtml template_html3() {
      return template.html3();
    }
    SafeHtml template_html4() {
      return template.html4();
    }
    SafeHtml template_html5() {
      return template.html5();
    }
    SafeHtml template_html6() {
      return template.html6();
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.ShelfCollectionResourceChildView_ShelfCollectionResourceChildViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.ShelfCollectionResourceChildView_ShelfCollectionResourceChildViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.ShelfCollectionResourceChildView_ShelfCollectionResourceChildViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.ShelfCollectionResourceChildView_ShelfCollectionResourceChildViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.ShelfCollectionResourceChildView_ShelfCollectionResourceChildViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 60 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.CollectionEditResourceCBundle res;
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.CollectionEditResourceCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item.CollectionEditResourceCBundle build_res() {
      // Creation section.
      res = owner.res;
      assert res != null : "UiField res with 'provided = true' was null";
      // Setup section.


      return res;
    }

    /**
     * Getter for resourceFlowPanel called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_resourceFlowPanel() {
      return build_resourceFlowPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_resourceFlowPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel resourceFlowPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      resourceFlowPanel.add(get_f_FlowPanel1());
      resourceFlowPanel.add(get_f_FlowPanel13());
      resourceFlowPanel.add(get_ResourceEditButtonContainer());
      resourceFlowPanel.add(get_UpdateTextMessage());
      resourceFlowPanel.add(get_actionVerPanel());
      resourceFlowPanel.add(get_actionVerPanelForUpdateTime());
      resourceFlowPanel.add(get_actionVerPanelForUpdatePDF());
      resourceFlowPanel.setStyleName("" + get_res().css().collectionResource() + "");


      owner.resourceFlowPanel = resourceFlowPanel;

      return resourceFlowPanel;
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
      f_FlowPanel1.add(get_resourceImageUc());
      f_FlowPanel1.add(get_resourceTitle1());
      f_FlowPanel1.add(get_narrationConatainer());
      f_FlowPanel1.add(get_videoDisplay());
      f_FlowPanel1.add(get_editFieldsFloPanel());
      f_FlowPanel1.add(get_editPdfFlowPanel());
      f_FlowPanel1.setStyleName("" + get_res().css().resourceMainPanel() + "");


      return f_FlowPanel1;
    }

    /**
     * Getter for resourceImageUc called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.uc.ResourceImageUc get_resourceImageUc() {
      return build_resourceImageUc();
    }
    private org.ednovo.gooru.client.uc.ResourceImageUc build_resourceImageUc() {
      // Creation section.
      final org.ednovo.gooru.client.uc.ResourceImageUc resourceImageUc = (org.ednovo.gooru.client.uc.ResourceImageUc) GWT.create(org.ednovo.gooru.client.uc.ResourceImageUc.class);
      // Setup section.


      owner.resourceImageUc = resourceImageUc;

      return resourceImageUc;
    }

    /**
     * Getter for resourceTitle1 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_resourceTitle1() {
      return build_resourceTitle1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_resourceTitle1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel resourceTitle1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      resourceTitle1.setStyleName("" + get_res().css().resourceTitle1() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2101 = UiBinderUtil.attachToDom(resourceTitle1.getElement());
      get_domId0Element().get();
      get_domId2Element().get();

      // Detach section.
      attachRecord2101.detach();
      resourceTitle1.addAndReplaceElement(get_resourceTitleContainer(), get_domId0Element().get());
      resourceTitle1.addAndReplaceElement(get_imgNotFriendly(), get_domId2Element().get());

      owner.resourceTitle1 = resourceTitle1;

      return resourceTitle1;
    }

    /**
     * Getter for domId0 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for resourceTitleContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_resourceTitleContainer() {
      return build_resourceTitleContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_resourceTitleContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel resourceTitleContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      resourceTitleContainer.setStyleName("collectionItemEditTitle");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2102 = UiBinderUtil.attachToDom(resourceTitleContainer.getElement());
      get_domId1Element().get();

      // Detach section.
      attachRecord2102.detach();
      resourceTitleContainer.addAndReplaceElement(get_resourceTitleLbl(), get_domId1Element().get());

      owner.resourceTitleContainer = resourceTitleContainer;

      return resourceTitleContainer;
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
     * Getter for resourceTitleLbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTML get_resourceTitleLbl() {
      return build_resourceTitleLbl();
    }
    private com.google.gwt.user.client.ui.HTML build_resourceTitleLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML resourceTitleLbl = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      resourceTitleLbl.setStyleName("" + get_res().css().resourceTitleCursor() + " collectionItemEditTitle");


      owner.resourceTitleLbl = resourceTitleLbl;

      return resourceTitleLbl;
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
     * Getter for domId0Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for imgNotFriendly called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Image get_imgNotFriendly() {
      return build_imgNotFriendly();
    }
    private com.google.gwt.user.client.ui.Image build_imgNotFriendly() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image imgNotFriendly = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      imgNotFriendly.setStyleName("" + get_res().css().imgHeight() + "");


      owner.imgNotFriendly = imgNotFriendly;

      return imgNotFriendly;
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
     * Getter for narrationConatainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_narrationConatainer() {
      return build_narrationConatainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_narrationConatainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel narrationConatainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      narrationConatainer.add(get_f_SimplePanel2());
      narrationConatainer.add(get_resourceNarrationHtml());
      narrationConatainer.add(get_pencilEditNarationLbl());
      narrationConatainer.add(get_editFloPanel());


      owner.narrationConatainer = narrationConatainer;

      return narrationConatainer;
    }

    /**
     * Getter for f_SimplePanel2 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_f_SimplePanel2() {
      return build_f_SimplePanel2();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_f_SimplePanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel f_SimplePanel2 = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.
      f_SimplePanel2.setStyleName("" + get_res().css().resourceNarrationPanel() + "");


      return f_SimplePanel2;
    }

    /**
     * Getter for resourceNarrationHtml called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTML get_resourceNarrationHtml() {
      return build_resourceNarrationHtml();
    }
    private com.google.gwt.user.client.ui.HTML build_resourceNarrationHtml() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML resourceNarrationHtml = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      resourceNarrationHtml.setStyleName("" + get_res().css().resourceNarration() + " collectionItemEditNarration");


      owner.resourceNarrationHtml = resourceNarrationHtml;

      return resourceNarrationHtml;
    }

    /**
     * Getter for pencilEditNarationLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_pencilEditNarationLbl() {
      return build_pencilEditNarationLbl();
    }
    private com.google.gwt.user.client.ui.Label build_pencilEditNarationLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label pencilEditNarationLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      pencilEditNarationLbl.setStyleName("" + get_res().css().pencilEditImage() + "");
      pencilEditNarationLbl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6);


      owner.pencilEditNarationLbl = pencilEditNarationLbl;

      return pencilEditNarationLbl;
    }

    /**
     * Getter for editFloPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_editFloPanel() {
      return build_editFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_editFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel editFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      editFloPanel.add(get_narationFloPanel());
      editFloPanel.setStyleName("" + get_res().css().editPanel() + "");


      owner.editFloPanel = editFloPanel;

      return editFloPanel;
    }

    /**
     * Getter for narationFloPanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_narationFloPanel() {
      return build_narationFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_narationFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel narationFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      narationFloPanel.add(get_narrationTxtArea());
      narationFloPanel.add(get_narrationAlertMessageLbl());
      narationFloPanel.setStyleName("resourceNarrationContainer");


      owner.narationFloPanel = narationFloPanel;

      return narationFloPanel;
    }

    /**
     * Getter for narrationTxtArea called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.RichTextArea get_narrationTxtArea() {
      return build_narrationTxtArea();
    }
    private com.google.gwt.user.client.ui.RichTextArea build_narrationTxtArea() {
      // Creation section.
      final com.google.gwt.user.client.ui.RichTextArea narrationTxtArea = (com.google.gwt.user.client.ui.RichTextArea) GWT.create(com.google.gwt.user.client.ui.RichTextArea.class);
      // Setup section.
      narrationTxtArea.setStyleName("" + get_res().css().resourceNarrationEdit() + "");


      owner.narrationTxtArea = narrationTxtArea;

      return narrationTxtArea;
    }

    /**
     * Getter for narrationAlertMessageLbl called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_narrationAlertMessageLbl() {
      return build_narrationAlertMessageLbl();
    }
    private com.google.gwt.user.client.ui.Label build_narrationAlertMessageLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label narrationAlertMessageLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      narrationAlertMessageLbl.setStyleName("" + get_res().css().narrationAlertMessage() + "");


      owner.narrationAlertMessageLbl = narrationAlertMessageLbl;

      return narrationAlertMessageLbl;
    }

    /**
     * Getter for videoDisplay called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_videoDisplay() {
      return build_videoDisplay();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_videoDisplay() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel videoDisplay = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      videoDisplay.add(get_videoImage());
      videoDisplay.add(get_videoTimeField());
      videoDisplay.add(get_fromLblDisplayText());
      videoDisplay.setStyleName("" + get_res().css().resourceVideoTime() + "");


      owner.videoDisplay = videoDisplay;

      return videoDisplay;
    }

    /**
     * Getter for videoImage called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_videoImage() {
      return build_videoImage();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_videoImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel videoImage = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      owner.videoImage = videoImage;

      return videoImage;
    }

    /**
     * Getter for videoTimeField called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_videoTimeField() {
      return build_videoTimeField();
    }
    private com.google.gwt.user.client.ui.Label build_videoTimeField() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label videoTimeField = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      videoTimeField.setStyleName("" + get_res().css().videoText() + "");


      owner.videoTimeField = videoTimeField;

      return videoTimeField;
    }

    /**
     * Getter for fromLblDisplayText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_fromLblDisplayText() {
      return build_fromLblDisplayText();
    }
    private com.google.gwt.user.client.ui.Label build_fromLblDisplayText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label fromLblDisplayText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      fromLblDisplayText.setStyleName("" + get_res().css().videoStartTimeLabel() + "");


      owner.fromLblDisplayText = fromLblDisplayText;

      return fromLblDisplayText;
    }

    /**
     * Getter for editFieldsFloPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_editFieldsFloPanel() {
      return build_editFieldsFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_editFieldsFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel editFieldsFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      editFieldsFloPanel.add(get_f_FlowPanel3());
      editFieldsFloPanel.add(get_startStopTimeDisplayText());
      editFieldsFloPanel.add(get_f_FlowPanel4());
      editFieldsFloPanel.add(get_f_FlowPanel7());
      editFieldsFloPanel.setStyleName("" + get_res().css().outerdivContainer() + "");


      owner.editFieldsFloPanel = editFieldsFloPanel;

      return editFieldsFloPanel;
    }

    /**
     * Getter for f_FlowPanel3 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel3() {
      return build_f_FlowPanel3();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel3 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel3.setStyleName("" + get_res().css().videoImageContainer() + "");


      return f_FlowPanel3;
    }

    /**
     * Getter for startStopTimeDisplayText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_startStopTimeDisplayText() {
      return build_startStopTimeDisplayText();
    }
    private com.google.gwt.user.client.ui.Label build_startStopTimeDisplayText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label startStopTimeDisplayText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      startStopTimeDisplayText.setStyleName("" + get_res().css().startStopTimeDisplayText() + "");


      owner.startStopTimeDisplayText = startStopTimeDisplayText;

      return startStopTimeDisplayText;
    }

    /**
     * Getter for f_FlowPanel4 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel4() {
      return build_f_FlowPanel4();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel4 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel4.add(get_fromLbl());
      f_FlowPanel4.add(get_f_FlowPanel5());
      f_FlowPanel4.add(get_minsText());
      f_FlowPanel4.add(get_f_FlowPanel6());
      f_FlowPanel4.add(get_secondsText());
      f_FlowPanel4.setStyleName("" + get_res().css().editTimeContainer() + "");


      return f_FlowPanel4;
    }

    /**
     * Getter for fromLbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_fromLbl() {
      return build_fromLbl();
    }
    private com.google.gwt.user.client.ui.Label build_fromLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label fromLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      fromLbl.setStyleName("" + get_res().css().fromLbl() + "");


      owner.fromLbl = fromLbl;

      return fromLbl;
    }

    /**
     * Getter for f_FlowPanel5 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel5() {
      return build_f_FlowPanel5();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel5 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel5.add(get_fromTxt());
      f_FlowPanel5.setStyleName("" + get_res().css().textAlignContainer() + "");


      return f_FlowPanel5;
    }

    /**
     * Getter for fromTxt called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.TextBox get_fromTxt() {
      return build_fromTxt();
    }
    private com.google.gwt.user.client.ui.TextBox build_fromTxt() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox fromTxt = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.
      fromTxt.setStyleName("" + get_res().css().textBox() + "");


      owner.fromTxt = fromTxt;

      return fromTxt;
    }

    /**
     * Getter for minsText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_minsText() {
      return build_minsText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_minsText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel minsText = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      minsText.setStyleName("" + get_res().css().MinuteLabel() + "");


      owner.minsText = minsText;

      return minsText;
    }

    /**
     * Getter for f_FlowPanel6 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel6() {
      return build_f_FlowPanel6();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel6() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel6 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel6.add(get_toTxt());
      f_FlowPanel6.setStyleName("" + get_res().css().textAlignContainer() + "");


      return f_FlowPanel6;
    }

    /**
     * Getter for toTxt called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.TextBox get_toTxt() {
      return build_toTxt();
    }
    private com.google.gwt.user.client.ui.TextBox build_toTxt() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox toTxt = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.
      toTxt.setStyleName("" + get_res().css().textBox() + "");


      owner.toTxt = toTxt;

      return toTxt;
    }

    /**
     * Getter for secondsText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_secondsText() {
      return build_secondsText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_secondsText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel secondsText = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      secondsText.setStyleName("" + get_res().css().MinuteLabel() + "");


      owner.secondsText = secondsText;

      return secondsText;
    }

    /**
     * Getter for f_FlowPanel7 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel7() {
      return build_f_FlowPanel7();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel7() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel7 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel7.add(get_ToLbl());
      f_FlowPanel7.add(get_f_FlowPanel8());
      f_FlowPanel7.add(get_endMinsText());
      f_FlowPanel7.add(get_f_FlowPanel9());
      f_FlowPanel7.add(get_endSecondsText());
      f_FlowPanel7.setStyleName("" + get_res().css().editTimeContainer() + "");


      return f_FlowPanel7;
    }

    /**
     * Getter for ToLbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_ToLbl() {
      return build_ToLbl();
    }
    private com.google.gwt.user.client.ui.Label build_ToLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label ToLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      ToLbl.setStyleName("" + get_res().css().fromLbl() + "");


      owner.ToLbl = ToLbl;

      return ToLbl;
    }

    /**
     * Getter for f_FlowPanel8 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel8() {
      return build_f_FlowPanel8();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel8() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel8 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel8.add(get_EndTimeTxt1());
      f_FlowPanel8.setStyleName("" + get_res().css().textAlignContainer() + "");


      return f_FlowPanel8;
    }

    /**
     * Getter for EndTimeTxt1 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.TextBox get_EndTimeTxt1() {
      return build_EndTimeTxt1();
    }
    private com.google.gwt.user.client.ui.TextBox build_EndTimeTxt1() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox EndTimeTxt1 = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.
      EndTimeTxt1.setStyleName("" + get_res().css().textBox() + "");


      owner.EndTimeTxt1 = EndTimeTxt1;

      return EndTimeTxt1;
    }

    /**
     * Getter for endMinsText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_endMinsText() {
      return build_endMinsText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_endMinsText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel endMinsText = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.
      endMinsText.setStyleName("" + get_res().css().MinuteLabel() + "");


      owner.endMinsText = endMinsText;

      return endMinsText;
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
      f_FlowPanel9.add(get_EndTimeTxt2());
      f_FlowPanel9.setStyleName("" + get_res().css().textAlignContainer() + "");


      return f_FlowPanel9;
    }

    /**
     * Getter for EndTimeTxt2 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.TextBox get_EndTimeTxt2() {
      return build_EndTimeTxt2();
    }
    private com.google.gwt.user.client.ui.TextBox build_EndTimeTxt2() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox EndTimeTxt2 = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.
      EndTimeTxt2.setStyleName("" + get_res().css().textBox() + "");


      owner.EndTimeTxt2 = EndTimeTxt2;

      return EndTimeTxt2;
    }

    /**
     * Getter for endSecondsText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_endSecondsText() {
      return build_endSecondsText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_endSecondsText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel endSecondsText = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.
      endSecondsText.setStyleName("" + get_res().css().MinuteLabel() + "");


      owner.endSecondsText = endSecondsText;

      return endSecondsText;
    }

    /**
     * Getter for editPdfFlowPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_editPdfFlowPanel() {
      return build_editPdfFlowPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_editPdfFlowPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel editPdfFlowPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      editPdfFlowPanel.add(get_f_FlowPanel10());
      editPdfFlowPanel.add(get_editSartPageText());
      editPdfFlowPanel.add(get_f_FlowPanel11());
      editPdfFlowPanel.setStyleName("" + get_res().css().outerdivContainer() + "");


      owner.editPdfFlowPanel = editPdfFlowPanel;

      return editPdfFlowPanel;
    }

    /**
     * Getter for f_FlowPanel10 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel10() {
      return build_f_FlowPanel10();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel10() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel10 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel10.setStyleName("" + get_res().css().pdfImageContainer() + "");


      return f_FlowPanel10;
    }

    /**
     * Getter for editSartPageText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_editSartPageText() {
      return build_editSartPageText();
    }
    private com.google.gwt.user.client.ui.Label build_editSartPageText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label editSartPageText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      editSartPageText.setStyleName("" + get_res().css().startStopTimeDisplayText() + "");


      owner.editSartPageText = editSartPageText;

      return editSartPageText;
    }

    /**
     * Getter for f_FlowPanel11 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel11() {
      return build_f_FlowPanel11();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel11() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel11 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel11.add(get_StartPageLbl());
      f_FlowPanel11.add(get_f_FlowPanel12());
      f_FlowPanel11.add(get_updatePDFLabelText());
      f_FlowPanel11.setStyleName("" + get_res().css().editTimeContainer() + "");


      return f_FlowPanel11;
    }

    /**
     * Getter for StartPageLbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_StartPageLbl() {
      return build_StartPageLbl();
    }
    private com.google.gwt.user.client.ui.Label build_StartPageLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label StartPageLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      StartPageLbl.setStyleName("" + get_res().css().fromLbl() + "");


      owner.StartPageLbl = StartPageLbl;

      return StartPageLbl;
    }

    /**
     * Getter for f_FlowPanel12 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel12() {
      return build_f_FlowPanel12();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel12() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel12 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel12.add(get_startpdfPageNumber());
      f_FlowPanel12.setStyleName("" + get_res().css().textAlignContainer() + "");


      return f_FlowPanel12;
    }

    /**
     * Getter for startpdfPageNumber called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.TextBox get_startpdfPageNumber() {
      return build_startpdfPageNumber();
    }
    private com.google.gwt.user.client.ui.TextBox build_startpdfPageNumber() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox startpdfPageNumber = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.
      startpdfPageNumber.setStyleName("" + get_res().css().textBox() + "");


      owner.startpdfPageNumber = startpdfPageNumber;

      return startpdfPageNumber;
    }

    /**
     * Getter for updatePDFLabelText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_updatePDFLabelText() {
      return build_updatePDFLabelText();
    }
    private com.google.gwt.user.client.ui.Label build_updatePDFLabelText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label updatePDFLabelText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      updatePDFLabelText.setStyleName("" + get_res().css().MinuteLabel() + "");


      owner.updatePDFLabelText = updatePDFLabelText;

      return updatePDFLabelText;
    }

    /**
     * Getter for f_FlowPanel13 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel13() {
      return build_f_FlowPanel13();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel13() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel13 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel13.add(get_EditBtn());
      f_FlowPanel13.setStyleName("" + get_res().css().panelAlignRight() + "");


      return f_FlowPanel13;
    }

    /**
     * Getter for EditBtn called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_EditBtn() {
      return build_EditBtn();
    }
    private com.google.gwt.user.client.ui.Button build_EditBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button EditBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      EditBtn.setStyleName("" + get_res().css().gEditButton() + "");
      EditBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.EditBtn = EditBtn;

      return EditBtn;
    }

    /**
     * Getter for ResourceEditButtonContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_ResourceEditButtonContainer() {
      return build_ResourceEditButtonContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_ResourceEditButtonContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel ResourceEditButtonContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      ResourceEditButtonContainer.add(get_updateResourceBtn());
      ResourceEditButtonContainer.add(get_editInfoLbl());
      ResourceEditButtonContainer.add(get_editVideoTimeLbl());
      ResourceEditButtonContainer.add(get_editStartPageLbl());
      ResourceEditButtonContainer.add(get_copyResource());
      ResourceEditButtonContainer.add(get_confirmDeleteLbl());
      ResourceEditButtonContainer.setStyleName("" + get_res().css().editButtonContainer() + "");


      owner.ResourceEditButtonContainer = ResourceEditButtonContainer;

      return ResourceEditButtonContainer;
    }

    /**
     * Getter for updateResourceBtn called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_updateResourceBtn() {
      return build_updateResourceBtn();
    }
    private com.google.gwt.user.client.ui.Label build_updateResourceBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label updateResourceBtn = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      updateResourceBtn.setStyleName("" + get_res().css().editButtonText() + "");
      updateResourceBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.updateResourceBtn = updateResourceBtn;

      return updateResourceBtn;
    }

    /**
     * Getter for editInfoLbl called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_editInfoLbl() {
      return build_editInfoLbl();
    }
    private com.google.gwt.user.client.ui.Label build_editInfoLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label editInfoLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      editInfoLbl.setStyleName("" + get_res().css().editButtonText() + "");


      owner.editInfoLbl = editInfoLbl;

      return editInfoLbl;
    }

    /**
     * Getter for editVideoTimeLbl called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_editVideoTimeLbl() {
      return build_editVideoTimeLbl();
    }
    private com.google.gwt.user.client.ui.Label build_editVideoTimeLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label editVideoTimeLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      editVideoTimeLbl.setStyleName("" + get_res().css().editButtonText() + "");
      editVideoTimeLbl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames11);


      owner.editVideoTimeLbl = editVideoTimeLbl;

      return editVideoTimeLbl;
    }

    /**
     * Getter for editStartPageLbl called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_editStartPageLbl() {
      return build_editStartPageLbl();
    }
    private com.google.gwt.user.client.ui.Label build_editStartPageLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label editStartPageLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      editStartPageLbl.setStyleName("" + get_res().css().editButtonText() + "");
      editStartPageLbl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);


      owner.editStartPageLbl = editStartPageLbl;

      return editStartPageLbl;
    }

    /**
     * Getter for copyResource called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_copyResource() {
      return build_copyResource();
    }
    private com.google.gwt.user.client.ui.Label build_copyResource() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label copyResource = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      copyResource.setStyleName("" + get_res().css().editButtonText() + "");
      copyResource.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7);


      owner.copyResource = copyResource;

      return copyResource;
    }

    /**
     * Getter for confirmDeleteLbl called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_confirmDeleteLbl() {
      return build_confirmDeleteLbl();
    }
    private com.google.gwt.user.client.ui.Label build_confirmDeleteLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label confirmDeleteLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      confirmDeleteLbl.setStyleName("" + get_res().css().editButtonText() + "");
      confirmDeleteLbl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8);


      owner.confirmDeleteLbl = confirmDeleteLbl;

      return confirmDeleteLbl;
    }

    /**
     * Getter for UpdateTextMessage called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_UpdateTextMessage() {
      return build_UpdateTextMessage();
    }
    private com.google.gwt.user.client.ui.Label build_UpdateTextMessage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label UpdateTextMessage = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      UpdateTextMessage.setStyleName("" + get_res().css().updateTextStyle() + "");


      owner.UpdateTextMessage = UpdateTextMessage;

      return UpdateTextMessage;
    }

    /**
     * Getter for actionVerPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_actionVerPanel() {
      return build_actionVerPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_actionVerPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel actionVerPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      actionVerPanel.add(get_updateNarrationBtn());
      actionVerPanel.add(get_cancelNarrationBtn());
      actionVerPanel.setStyleName("" + get_res().css().actionPanel() + "");


      owner.actionVerPanel = actionVerPanel;

      return actionVerPanel;
    }

    /**
     * Getter for updateNarrationBtn called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_updateNarrationBtn() {
      return build_updateNarrationBtn();
    }
    private com.google.gwt.user.client.ui.Button build_updateNarrationBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button updateNarrationBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      updateNarrationBtn.setStyleName("primary " + get_res().css().updateButton() + "");
      updateNarrationBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames9);


      owner.updateNarrationBtn = updateNarrationBtn;

      return updateNarrationBtn;
    }

    /**
     * Getter for cancelNarrationBtn called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_cancelNarrationBtn() {
      return build_cancelNarrationBtn();
    }
    private com.google.gwt.user.client.ui.Button build_cancelNarrationBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button cancelNarrationBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      cancelNarrationBtn.setStyleName("secondary " + get_res().css().narrationCancelButton() + "");
      cancelNarrationBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames10);


      owner.cancelNarrationBtn = cancelNarrationBtn;

      return cancelNarrationBtn;
    }

    /**
     * Getter for actionVerPanelForUpdateTime called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_actionVerPanelForUpdateTime() {
      return build_actionVerPanelForUpdateTime();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_actionVerPanelForUpdateTime() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel actionVerPanelForUpdateTime = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      actionVerPanelForUpdateTime.add(get_updateVideoTimeBtn());
      actionVerPanelForUpdateTime.add(get_cancelVideoTimeBtn());
      actionVerPanelForUpdateTime.setStyleName("" + get_res().css().actionPanel() + "");


      owner.actionVerPanelForUpdateTime = actionVerPanelForUpdateTime;

      return actionVerPanelForUpdateTime;
    }

    /**
     * Getter for updateVideoTimeBtn called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_updateVideoTimeBtn() {
      return build_updateVideoTimeBtn();
    }
    private com.google.gwt.user.client.ui.Button build_updateVideoTimeBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button updateVideoTimeBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      updateVideoTimeBtn.setStyleName("" + get_res().css().overRideBlueButton() + "");
      updateVideoTimeBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames12);


      owner.updateVideoTimeBtn = updateVideoTimeBtn;

      return updateVideoTimeBtn;
    }

    /**
     * Getter for cancelVideoTimeBtn called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_cancelVideoTimeBtn() {
      return build_cancelVideoTimeBtn();
    }
    private com.google.gwt.user.client.ui.Button build_cancelVideoTimeBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button cancelVideoTimeBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      cancelVideoTimeBtn.setStyleName("secondary " + get_res().css().narrationCancelButton() + "");
      cancelVideoTimeBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames13);


      owner.cancelVideoTimeBtn = cancelVideoTimeBtn;

      return cancelVideoTimeBtn;
    }

    /**
     * Getter for actionVerPanelForUpdatePDF called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_actionVerPanelForUpdatePDF() {
      return build_actionVerPanelForUpdatePDF();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_actionVerPanelForUpdatePDF() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel actionVerPanelForUpdatePDF = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      actionVerPanelForUpdatePDF.add(get_updatePdfBtn());
      actionVerPanelForUpdatePDF.add(get_cancelpdfBtn());
      actionVerPanelForUpdatePDF.setStyleName("" + get_res().css().actionPanel() + "");


      owner.actionVerPanelForUpdatePDF = actionVerPanelForUpdatePDF;

      return actionVerPanelForUpdatePDF;
    }

    /**
     * Getter for updatePdfBtn called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_updatePdfBtn() {
      return build_updatePdfBtn();
    }
    private com.google.gwt.user.client.ui.Button build_updatePdfBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button updatePdfBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      updatePdfBtn.setStyleName("" + get_res().css().overRideBlueButton() + "");
      updatePdfBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);


      owner.updatePdfBtn = updatePdfBtn;

      return updatePdfBtn;
    }

    /**
     * Getter for cancelpdfBtn called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_cancelpdfBtn() {
      return build_cancelpdfBtn();
    }
    private com.google.gwt.user.client.ui.Button build_cancelpdfBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button cancelpdfBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      cancelpdfBtn.setStyleName("secondary " + get_res().css().narrationCancelButton() + "");
      cancelpdfBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5);


      owner.cancelpdfBtn = cancelpdfBtn;

      return cancelpdfBtn;
    }
  }
}
