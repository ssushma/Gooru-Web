package org.ednovo.gooru.client.mvp.image.upload;

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

public class ImageUploadView_ImageUploadViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.image.upload.ImageUploadView>, org.ednovo.gooru.client.mvp.image.upload.ImageUploadView.ImageUploadViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html1(String arg0, String arg1);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.image.upload.ImageUploadView owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.image.upload.ImageUploadView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.imageUploadOnComputer(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.imageUploadOnWeb(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.uploadImagesFromGooru(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onSystemCancelClick(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.cancelOnGooruImages(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onWebCancelClick(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.uploadImageButtonOnWeb(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.uploadGooruDefaultImage(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.image.upload.ImageUploadView owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
    }

    SafeHtml template_html1() {
      return template.html1(get_domId0(), get_domId1());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.image.upload.ImageUploadView_ImageUploadViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.image.upload.ImageUploadView_ImageUploadViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.image.upload.ImageUploadView_ImageUploadViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.image.upload.ImageUploadView_ImageUploadViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.image.upload.ImageUploadView_ImageUploadViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for style called 30 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.image.upload.ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style style;
    private org.ednovo.gooru.client.mvp.image.upload.ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style get_style() {
      return style;
    }
    private org.ednovo.gooru.client.mvp.image.upload.ImageUploadView_ImageUploadViewUiBinderImpl_GenCss_style build_style() {
      // Creation section.
      style = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().style();
      // Setup section.
      style.ensureInjected();


      return style;
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
      f_FlowPanel1.add(get_imagUploadFloPanel());
      f_FlowPanel1.add(get_imageCropFloPanel());
      f_FlowPanel1.add(get_glassPanelWithLoadingUc());
      f_FlowPanel1.setStyleName("" + get_style().imagePopupContainer() + "");


      return f_FlowPanel1;
    }

    /**
     * Getter for imagUploadFloPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_imagUploadFloPanel() {
      return build_imagUploadFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_imagUploadFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel imagUploadFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      imagUploadFloPanel.add(get_f_FlowPanel2());
      imagUploadFloPanel.add(get_f_FlowPanel3());


      owner.imagUploadFloPanel = imagUploadFloPanel;

      return imagUploadFloPanel;
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
      f_FlowPanel2.add(get_chooseText());
      f_FlowPanel2.add(get_imageUploadOnWebLbl());
      f_FlowPanel2.add(get_imageUploadOnComputerLbl());
      f_FlowPanel2.add(get_uploadGooruImages());
      f_FlowPanel2.setStyleName("" + get_style().imagePopupLeft() + "");


      return f_FlowPanel2;
    }

    /**
     * Getter for chooseText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_chooseText() {
      return build_chooseText();
    }
    private com.google.gwt.user.client.ui.Label build_chooseText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label chooseText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      chooseText.setStyleName("" + get_style().imageUploadInfo() + "");


      owner.chooseText = chooseText;

      return chooseText;
    }

    /**
     * Getter for imageUploadOnWebLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Anchor get_imageUploadOnWebLbl() {
      return build_imageUploadOnWebLbl();
    }
    private com.google.gwt.user.client.ui.Anchor build_imageUploadOnWebLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor imageUploadOnWebLbl = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      imageUploadOnWebLbl.setStyleName("" + get_style().imageUploadList() + "");
      imageUploadOnWebLbl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.imageUploadOnWebLbl = imageUploadOnWebLbl;

      return imageUploadOnWebLbl;
    }

    /**
     * Getter for imageUploadOnComputerLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Anchor get_imageUploadOnComputerLbl() {
      return build_imageUploadOnComputerLbl();
    }
    private com.google.gwt.user.client.ui.Anchor build_imageUploadOnComputerLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor imageUploadOnComputerLbl = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      imageUploadOnComputerLbl.setStyleName("" + get_style().imageUploadList() + "");
      imageUploadOnComputerLbl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.imageUploadOnComputerLbl = imageUploadOnComputerLbl;

      return imageUploadOnComputerLbl;
    }

    /**
     * Getter for uploadGooruImages called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Anchor get_uploadGooruImages() {
      return build_uploadGooruImages();
    }
    private com.google.gwt.user.client.ui.Anchor build_uploadGooruImages() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor uploadGooruImages = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      uploadGooruImages.setStyleName("" + get_style().imageUploadList() + "");
      uploadGooruImages.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);


      owner.uploadGooruImages = uploadGooruImages;

      return uploadGooruImages;
    }

    /**
     * Getter for f_FlowPanel3 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel3() {
      return build_f_FlowPanel3();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel3 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel3.add(get_imageUploadOnWebFloPanel());
      f_FlowPanel3.add(get_imageUploadOnUrlFloPanel());
      f_FlowPanel3.add(get_uploadGooruImagesContainer());
      f_FlowPanel3.setStyleName("" + get_style().imagePopupRight() + "");


      return f_FlowPanel3;
    }

    /**
     * Getter for imageUploadOnWebFloPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_imageUploadOnWebFloPanel() {
      return build_imageUploadOnWebFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_imageUploadOnWebFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel imageUploadOnWebFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      imageUploadOnWebFloPanel.add(get_uploadFromComputer());
      imageUploadOnWebFloPanel.add(get_fileuploadForm());
      imageUploadOnWebFloPanel.add(get_uploadLimitText());
      imageUploadOnWebFloPanel.add(get_f_FlowPanel4());
      imageUploadOnWebFloPanel.add(get_f_FlowPanel5());
      imageUploadOnWebFloPanel.setStyleName("" + get_style().imageUploadOnWeb() + "");


      owner.imageUploadOnWebFloPanel = imageUploadOnWebFloPanel;

      return imageUploadOnWebFloPanel;
    }

    /**
     * Getter for uploadFromComputer called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_uploadFromComputer() {
      return build_uploadFromComputer();
    }
    private com.google.gwt.user.client.ui.Label build_uploadFromComputer() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label uploadFromComputer = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      uploadFromComputer.setStyleName("" + get_style().uploadPicstureInfo() + "");


      owner.uploadFromComputer = uploadFromComputer;

      return uploadFromComputer;
    }

    /**
     * Getter for fileuploadForm called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FormPanel get_fileuploadForm() {
      return build_fileuploadForm();
    }
    private com.google.gwt.user.client.ui.FormPanel build_fileuploadForm() {
      // Creation section.
      final com.google.gwt.user.client.ui.FormPanel fileuploadForm = (com.google.gwt.user.client.ui.FormPanel) GWT.create(com.google.gwt.user.client.ui.FormPanel.class);
      // Setup section.
      fileuploadForm.add(get_fileUpload());
      fileuploadForm.setEncoding("multipart/form-data");
      fileuploadForm.setMethod("post");


      owner.fileuploadForm = fileuploadForm;

      return fileuploadForm;
    }

    /**
     * Getter for fileUpload called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FileUpload get_fileUpload() {
      return build_fileUpload();
    }
    private com.google.gwt.user.client.ui.FileUpload build_fileUpload() {
      // Creation section.
      final com.google.gwt.user.client.ui.FileUpload fileUpload = (com.google.gwt.user.client.ui.FileUpload) GWT.create(com.google.gwt.user.client.ui.FileUpload.class);
      // Setup section.
      fileUpload.setName("imageUpload");


      owner.fileUpload = fileUpload;

      return fileUpload;
    }

    /**
     * Getter for uploadLimitText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_uploadLimitText() {
      return build_uploadLimitText();
    }
    private com.google.gwt.user.client.ui.Label build_uploadLimitText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label uploadLimitText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.uploadLimitText = uploadLimitText;

      return uploadLimitText;
    }

    /**
     * Getter for f_FlowPanel4 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel4() {
      return build_f_FlowPanel4();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel4 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel4.add(get_notWorkingPanel());
      f_FlowPanel4.setStyleName("" + get_style().imageUploadMinHeight() + "");


      return f_FlowPanel4;
    }

    /**
     * Getter for notWorkingPanel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_notWorkingPanel() {
      return build_notWorkingPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_notWorkingPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel notWorkingPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      notWorkingPanel.setStyleName("" + get_style().notWorkingPanel() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1960 = UiBinderUtil.attachToDom(notWorkingPanel.getElement());
      get_domId0Element().get();
      get_domId1Element().get();

      // Detach section.
      attachRecord1960.detach();
      notWorkingPanel.addAndReplaceElement(get_notWorkingLblText(), get_domId0Element().get());
      notWorkingPanel.addAndReplaceElement(get_readThisLbl(), get_domId1Element().get());

      owner.notWorkingPanel = notWorkingPanel;

      return notWorkingPanel;
    }

    /**
     * Getter for domId0 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for notWorkingLblText called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_notWorkingLblText() {
      return build_notWorkingLblText();
    }
    private com.google.gwt.user.client.ui.Label build_notWorkingLblText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label notWorkingLblText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      notWorkingLblText.setStyleName("" + get_style().notWorkingLbl() + "");


      owner.notWorkingLblText = notWorkingLblText;

      return notWorkingLblText;
    }

    /**
     * Getter for domId0Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId1 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for readThisLbl called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Anchor get_readThisLbl() {
      return build_readThisLbl();
    }
    private com.google.gwt.user.client.ui.Anchor build_readThisLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor readThisLbl = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      readThisLbl.setStyleName("" + get_style().readThisLbl() + "");
      readThisLbl.setTarget("_blank");


      owner.readThisLbl = readThisLbl;

      return readThisLbl;
    }

    /**
     * Getter for domId1Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for f_FlowPanel5 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel5() {
      return build_f_FlowPanel5();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel5 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel5.add(get_onSystemCancelBtn());
      f_FlowPanel5.setStyleName("" + get_style().imageUploadAlign() + "");


      return f_FlowPanel5;
    }

    /**
     * Getter for onSystemCancelBtn called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.uc.BlueButtonUc get_onSystemCancelBtn() {
      return build_onSystemCancelBtn();
    }
    private org.ednovo.gooru.client.uc.BlueButtonUc build_onSystemCancelBtn() {
      // Creation section.
      final org.ednovo.gooru.client.uc.BlueButtonUc onSystemCancelBtn = (org.ednovo.gooru.client.uc.BlueButtonUc) GWT.create(org.ednovo.gooru.client.uc.BlueButtonUc.class);
      // Setup section.
      onSystemCancelBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);


      owner.onSystemCancelBtn = onSystemCancelBtn;

      return onSystemCancelBtn;
    }

    /**
     * Getter for imageUploadOnUrlFloPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_imageUploadOnUrlFloPanel() {
      return build_imageUploadOnUrlFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_imageUploadOnUrlFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel imageUploadOnUrlFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      imageUploadOnUrlFloPanel.add(get_uploadFromWebText());
      imageUploadOnUrlFloPanel.add(get_f_FlowPanel6());
      imageUploadOnUrlFloPanel.setStyleName("" + get_style().imageUploadOnUrl() + "");


      owner.imageUploadOnUrlFloPanel = imageUploadOnUrlFloPanel;

      return imageUploadOnUrlFloPanel;
    }

    /**
     * Getter for uploadFromWebText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_uploadFromWebText() {
      return build_uploadFromWebText();
    }
    private com.google.gwt.user.client.ui.Label build_uploadFromWebText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label uploadFromWebText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      uploadFromWebText.setStyleName("" + get_style().uploadPicstureInfo() + "");


      owner.uploadFromWebText = uploadFromWebText;

      return uploadFromWebText;
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
      f_FlowPanel6.add(get_imageURLLbl());
      f_FlowPanel6.add(get_f_FlowPanel7());
      f_FlowPanel6.add(get_f_FlowPanel8());
      f_FlowPanel6.add(get_infoUrlUploadText());
      f_FlowPanel6.add(get_f_FlowPanel9());
      f_FlowPanel6.setStyleName("" + get_style().fileUploadUrl() + "");


      return f_FlowPanel6;
    }

    /**
     * Getter for imageURLLbl called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_imageURLLbl() {
      return build_imageURLLbl();
    }
    private com.google.gwt.user.client.ui.Label build_imageURLLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label imageURLLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      imageURLLbl.setStyleName("" + get_style().textImageUrl() + "");


      owner.imageURLLbl = imageURLLbl;

      return imageURLLbl;
    }

    /**
     * Getter for f_FlowPanel7 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel7() {
      return build_f_FlowPanel7();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel7() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel7 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel7.add(get_imageWebUploadUrlTxtBox());
      f_FlowPanel7.add(get_uploadImageButtonOnWeb());
      f_FlowPanel7.add(get_urlValidation());
      f_FlowPanel7.setStyleName("" + get_style().uploadUrlContainer() + "");


      return f_FlowPanel7;
    }

    /**
     * Getter for imageWebUploadUrlTxtBox called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.TextBox get_imageWebUploadUrlTxtBox() {
      return build_imageWebUploadUrlTxtBox();
    }
    private com.google.gwt.user.client.ui.TextBox build_imageWebUploadUrlTxtBox() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox imageWebUploadUrlTxtBox = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.
      imageWebUploadUrlTxtBox.setStyleName("" + get_style().textboxonUrl() + "");


      owner.imageWebUploadUrlTxtBox = imageWebUploadUrlTxtBox;

      return imageWebUploadUrlTxtBox;
    }

    /**
     * Getter for uploadImageButtonOnWeb called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private org.ednovo.gooru.client.uc.BlueButtonUc get_uploadImageButtonOnWeb() {
      return build_uploadImageButtonOnWeb();
    }
    private org.ednovo.gooru.client.uc.BlueButtonUc build_uploadImageButtonOnWeb() {
      // Creation section.
      final org.ednovo.gooru.client.uc.BlueButtonUc uploadImageButtonOnWeb = (org.ednovo.gooru.client.uc.BlueButtonUc) GWT.create(org.ednovo.gooru.client.uc.BlueButtonUc.class);
      // Setup section.
      uploadImageButtonOnWeb.setStyleName("" + get_style().uploadImageButtonOnWeb() + "");
      uploadImageButtonOnWeb.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7);


      owner.uploadImageButtonOnWeb = uploadImageButtonOnWeb;

      return uploadImageButtonOnWeb;
    }

    /**
     * Getter for urlValidation called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private org.ednovo.gooru.client.uc.ErrorLabelUc get_urlValidation() {
      return build_urlValidation();
    }
    private org.ednovo.gooru.client.uc.ErrorLabelUc build_urlValidation() {
      // Creation section.
      final org.ednovo.gooru.client.uc.ErrorLabelUc urlValidation = (org.ednovo.gooru.client.uc.ErrorLabelUc) GWT.create(org.ednovo.gooru.client.uc.ErrorLabelUc.class);
      // Setup section.


      owner.urlValidation = urlValidation;

      return urlValidation;
    }

    /**
     * Getter for f_FlowPanel8 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel8() {
      return build_f_FlowPanel8();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel8() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel8 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel8.add(get_typeImageurlText());
      f_FlowPanel8.setStyleName("" + get_style().imageUploadMinHeightUrl() + "");


      return f_FlowPanel8;
    }

    /**
     * Getter for typeImageurlText called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_typeImageurlText() {
      return build_typeImageurlText();
    }
    private com.google.gwt.user.client.ui.Label build_typeImageurlText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label typeImageurlText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.typeImageurlText = typeImageurlText;

      return typeImageurlText;
    }

    /**
     * Getter for infoUrlUploadText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_infoUrlUploadText() {
      return build_infoUrlUploadText();
    }
    private com.google.gwt.user.client.ui.Label build_infoUrlUploadText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label infoUrlUploadText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      infoUrlUploadText.setStyleName("" + get_style().infoUrlUpload() + "");


      owner.infoUrlUploadText = infoUrlUploadText;

      return infoUrlUploadText;
    }

    /**
     * Getter for f_FlowPanel9 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel9() {
      return build_f_FlowPanel9();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel9() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel9 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel9.add(get_onWebCancelBtn());
      f_FlowPanel9.setStyleName("" + get_style().imageUploadAlign() + "");


      return f_FlowPanel9;
    }

    /**
     * Getter for onWebCancelBtn called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private org.ednovo.gooru.client.uc.BlueButtonUc get_onWebCancelBtn() {
      return build_onWebCancelBtn();
    }
    private org.ednovo.gooru.client.uc.BlueButtonUc build_onWebCancelBtn() {
      // Creation section.
      final org.ednovo.gooru.client.uc.BlueButtonUc onWebCancelBtn = (org.ednovo.gooru.client.uc.BlueButtonUc) GWT.create(org.ednovo.gooru.client.uc.BlueButtonUc.class);
      // Setup section.
      onWebCancelBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6);


      owner.onWebCancelBtn = onWebCancelBtn;

      return onWebCancelBtn;
    }

    /**
     * Getter for uploadGooruImagesContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_uploadGooruImagesContainer() {
      return build_uploadGooruImagesContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_uploadGooruImagesContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel uploadGooruImagesContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      uploadGooruImagesContainer.add(get_chooseFromText());
      uploadGooruImagesContainer.add(get_gooruProfileDefaultImagesContainer());
      uploadGooruImagesContainer.add(get_f_FlowPanel16());
      uploadGooruImagesContainer.setStyleName("" + get_style().uploadGooruImagesContainer() + "");


      owner.uploadGooruImagesContainer = uploadGooruImagesContainer;

      return uploadGooruImagesContainer;
    }

    /**
     * Getter for chooseFromText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_chooseFromText() {
      return build_chooseFromText();
    }
    private com.google.gwt.user.client.ui.Label build_chooseFromText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label chooseFromText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      chooseFromText.setStyleName("" + get_style().uploadPicstureInfo() + "");


      owner.chooseFromText = chooseFromText;

      return chooseFromText;
    }

    /**
     * Getter for gooruProfileDefaultImagesContainer called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_gooruProfileDefaultImagesContainer() {
      return build_gooruProfileDefaultImagesContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_gooruProfileDefaultImagesContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel gooruProfileDefaultImagesContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      gooruProfileDefaultImagesContainer.add(get_f_GooruImagesView10());
      gooruProfileDefaultImagesContainer.add(get_f_GooruImagesView11());
      gooruProfileDefaultImagesContainer.add(get_f_GooruImagesView12());
      gooruProfileDefaultImagesContainer.add(get_f_GooruImagesView13());
      gooruProfileDefaultImagesContainer.add(get_f_GooruImagesView14());
      gooruProfileDefaultImagesContainer.add(get_f_GooruImagesView15());
      gooruProfileDefaultImagesContainer.setStyleName("" + get_style().defaultImagesContainer() + "");


      owner.gooruProfileDefaultImagesContainer = gooruProfileDefaultImagesContainer;

      return gooruProfileDefaultImagesContainer;
    }

    /**
     * Getter for f_GooruImagesView10 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.mvp.image.upload.GooruImagesView get_f_GooruImagesView10() {
      return build_f_GooruImagesView10();
    }
    private org.ednovo.gooru.client.mvp.image.upload.GooruImagesView build_f_GooruImagesView10() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.image.upload.GooruImagesView f_GooruImagesView10 = (org.ednovo.gooru.client.mvp.image.upload.GooruImagesView) GWT.create(org.ednovo.gooru.client.mvp.image.upload.GooruImagesView.class);
      // Setup section.
      f_GooruImagesView10.setImageUrl("./images/profile_default_Images/Arts.png");


      return f_GooruImagesView10;
    }

    /**
     * Getter for f_GooruImagesView11 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.mvp.image.upload.GooruImagesView get_f_GooruImagesView11() {
      return build_f_GooruImagesView11();
    }
    private org.ednovo.gooru.client.mvp.image.upload.GooruImagesView build_f_GooruImagesView11() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.image.upload.GooruImagesView f_GooruImagesView11 = (org.ednovo.gooru.client.mvp.image.upload.GooruImagesView) GWT.create(org.ednovo.gooru.client.mvp.image.upload.GooruImagesView.class);
      // Setup section.
      f_GooruImagesView11.setImageUrl("./images/profile_default_Images/Geography.png");


      return f_GooruImagesView11;
    }

    /**
     * Getter for f_GooruImagesView12 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.mvp.image.upload.GooruImagesView get_f_GooruImagesView12() {
      return build_f_GooruImagesView12();
    }
    private org.ednovo.gooru.client.mvp.image.upload.GooruImagesView build_f_GooruImagesView12() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.image.upload.GooruImagesView f_GooruImagesView12 = (org.ednovo.gooru.client.mvp.image.upload.GooruImagesView) GWT.create(org.ednovo.gooru.client.mvp.image.upload.GooruImagesView.class);
      // Setup section.
      f_GooruImagesView12.setImageUrl("./images/profile_default_Images/Math.png");


      return f_GooruImagesView12;
    }

    /**
     * Getter for f_GooruImagesView13 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.mvp.image.upload.GooruImagesView get_f_GooruImagesView13() {
      return build_f_GooruImagesView13();
    }
    private org.ednovo.gooru.client.mvp.image.upload.GooruImagesView build_f_GooruImagesView13() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.image.upload.GooruImagesView f_GooruImagesView13 = (org.ednovo.gooru.client.mvp.image.upload.GooruImagesView) GWT.create(org.ednovo.gooru.client.mvp.image.upload.GooruImagesView.class);
      // Setup section.
      f_GooruImagesView13.setImageUrl("./images/profile_default_Images/Original.png");


      return f_GooruImagesView13;
    }

    /**
     * Getter for f_GooruImagesView14 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.mvp.image.upload.GooruImagesView get_f_GooruImagesView14() {
      return build_f_GooruImagesView14();
    }
    private org.ednovo.gooru.client.mvp.image.upload.GooruImagesView build_f_GooruImagesView14() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.image.upload.GooruImagesView f_GooruImagesView14 = (org.ednovo.gooru.client.mvp.image.upload.GooruImagesView) GWT.create(org.ednovo.gooru.client.mvp.image.upload.GooruImagesView.class);
      // Setup section.
      f_GooruImagesView14.setImageUrl("./images/profile_default_Images/Science.png");


      return f_GooruImagesView14;
    }

    /**
     * Getter for f_GooruImagesView15 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private org.ednovo.gooru.client.mvp.image.upload.GooruImagesView get_f_GooruImagesView15() {
      return build_f_GooruImagesView15();
    }
    private org.ednovo.gooru.client.mvp.image.upload.GooruImagesView build_f_GooruImagesView15() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.image.upload.GooruImagesView f_GooruImagesView15 = (org.ednovo.gooru.client.mvp.image.upload.GooruImagesView) GWT.create(org.ednovo.gooru.client.mvp.image.upload.GooruImagesView.class);
      // Setup section.
      f_GooruImagesView15.setImageUrl("./images/profile_default_Images/Sports.png");


      return f_GooruImagesView15;
    }

    /**
     * Getter for f_FlowPanel16 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel16() {
      return build_f_FlowPanel16();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel16() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel16 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel16.add(get_okButtonOnUploadGooruImages());
      f_FlowPanel16.add(get_cancelButtonOnUploadGooruImages());


      return f_FlowPanel16;
    }

    /**
     * Getter for okButtonOnUploadGooruImages called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Button get_okButtonOnUploadGooruImages() {
      return build_okButtonOnUploadGooruImages();
    }
    private com.google.gwt.user.client.ui.Button build_okButtonOnUploadGooruImages() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button okButtonOnUploadGooruImages = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      okButtonOnUploadGooruImages.setStyleName("" + get_style().okButtonOnUploadGooruImages() + "");
      okButtonOnUploadGooruImages.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8);


      owner.okButtonOnUploadGooruImages = okButtonOnUploadGooruImages;

      return okButtonOnUploadGooruImages;
    }

    /**
     * Getter for cancelButtonOnUploadGooruImages called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_cancelButtonOnUploadGooruImages() {
      return build_cancelButtonOnUploadGooruImages();
    }
    private com.google.gwt.user.client.ui.Label build_cancelButtonOnUploadGooruImages() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label cancelButtonOnUploadGooruImages = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      cancelButtonOnUploadGooruImages.setStyleName("" + get_style().cancelButtonOnUploadGooruImages() + "");
      cancelButtonOnUploadGooruImages.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5);


      owner.cancelButtonOnUploadGooruImages = cancelButtonOnUploadGooruImages;

      return cancelButtonOnUploadGooruImages;
    }

    /**
     * Getter for imageCropFloPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_imageCropFloPanel() {
      return build_imageCropFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_imageCropFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel imageCropFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      imageCropFloPanel.setStyleName("" + get_style().imageCropPanel() + "");


      owner.imageCropFloPanel = imageCropFloPanel;

      return imageCropFloPanel;
    }

    /**
     * Getter for glassPanelWithLoadingUc called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.uc.GlassPanelWithLoadingUc get_glassPanelWithLoadingUc() {
      return build_glassPanelWithLoadingUc();
    }
    private org.ednovo.gooru.client.uc.GlassPanelWithLoadingUc build_glassPanelWithLoadingUc() {
      // Creation section.
      final org.ednovo.gooru.client.uc.GlassPanelWithLoadingUc glassPanelWithLoadingUc = (org.ednovo.gooru.client.uc.GlassPanelWithLoadingUc) GWT.create(org.ednovo.gooru.client.uc.GlassPanelWithLoadingUc.class);
      // Setup section.


      owner.glassPanelWithLoadingUc = glassPanelWithLoadingUc;

      return glassPanelWithLoadingUc;
    }
  }
}
