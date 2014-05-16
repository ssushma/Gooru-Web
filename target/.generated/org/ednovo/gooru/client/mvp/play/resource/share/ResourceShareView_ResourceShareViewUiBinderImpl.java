package org.ednovo.gooru.client.mvp.play.resource.share;

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

public class ResourceShareView_ResourceShareViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.play.resource.share.ResourceShareView>, org.ednovo.gooru.client.mvp.play.resource.share.ResourceShareView.ResourceShareViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("")
    SafeHtml html2();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html3(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html4(String arg0, String arg1);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.play.resource.share.ResourceShareView owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.play.resource.share.ResourceShareView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickEmbedLink(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickBitlyLink(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickresourceShareTextArea(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onhideBtnClicked(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.play.resource.share.ResourceShareView owner) {
      this.owner = owner;
      build_playerStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2();
    }
    SafeHtml template_html3() {
      return template.html3(get_domId0(), get_domId1());
    }
    SafeHtml template_html4() {
      return template.html4(get_domId2(), get_domId3());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.resource.share.ResourceShareView_ResourceShareViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.play.resource.share.ResourceShareView_ResourceShareViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.play.resource.share.ResourceShareView_ResourceShareViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.play.resource.share.ResourceShareView_ResourceShareViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.play.resource.share.ResourceShareView_ResourceShareViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for playerStyle called 16 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.resource.share.ResourceShareView_ResourceShareViewUiBinderImpl_GenCss_playerStyle playerStyle;
    private org.ednovo.gooru.client.mvp.play.resource.share.ResourceShareView_ResourceShareViewUiBinderImpl_GenCss_playerStyle get_playerStyle() {
      return playerStyle;
    }
    private org.ednovo.gooru.client.mvp.play.resource.share.ResourceShareView_ResourceShareViewUiBinderImpl_GenCss_playerStyle build_playerStyle() {
      // Creation section.
      playerStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().playerStyle();
      // Setup section.
      playerStyle.ensureInjected();


      return playerStyle;
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
      f_FlowPanel1.add(get_f_FlowPanel2());
      f_FlowPanel1.add(get_hideButton());
      f_FlowPanel1.setStyleName("" + get_playerStyle().collectionNarrationContainer() + "");


      return f_FlowPanel1;
    }

    /**
     * Getter for f_FlowPanel2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel2() {
      return build_f_FlowPanel2();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel2 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel2.add(get_shareMainTitle());
      f_FlowPanel2.add(get_f_FlowPanel3());
      f_FlowPanel2.add(get_f_HTMLPanel7());
      f_FlowPanel2.setStyleName("" + get_playerStyle().collectionNarrationWrapper() + "");


      return f_FlowPanel2;
    }

    /**
     * Getter for shareMainTitle called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_shareMainTitle() {
      return build_shareMainTitle();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_shareMainTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel shareMainTitle = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      shareMainTitle.setStyleName("" + get_playerStyle().collectionShareMaintitle() + "");


      owner.shareMainTitle = shareMainTitle;

      return shareMainTitle;
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
      f_FlowPanel3.add(get_f_FlowPanel4());
      f_FlowPanel3.add(get_f_FlowPanel5());
      f_FlowPanel3.add(get_socialSharePanel());
      f_FlowPanel3.setStyleName("" + get_playerStyle().collectionShareWrapper() + "");


      return f_FlowPanel3;
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
      f_FlowPanel4.add(get_resourceTitleText());
      f_FlowPanel4.add(get_resourceShareTextArea());
      f_FlowPanel4.setStyleName("" + get_playerStyle().collectionShareTitleContainer() + "");


      return f_FlowPanel4;
    }

    /**
     * Getter for resourceTitleText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_resourceTitleText() {
      return build_resourceTitleText();
    }
    private com.google.gwt.user.client.ui.Label build_resourceTitleText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label resourceTitleText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      resourceTitleText.setStyleName("" + get_playerStyle().collectionShareTitle() + "");


      owner.resourceTitleText = resourceTitleText;

      return resourceTitleText;
    }

    /**
     * Getter for resourceShareTextArea called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.TextArea get_resourceShareTextArea() {
      return build_resourceShareTextArea();
    }
    private com.google.gwt.user.client.ui.TextArea build_resourceShareTextArea() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextArea resourceShareTextArea = (com.google.gwt.user.client.ui.TextArea) GWT.create(com.google.gwt.user.client.ui.TextArea.class);
      // Setup section.
      resourceShareTextArea.setStyleName("" + get_playerStyle().collectionShareTextbox() + "");
      resourceShareTextArea.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);


      owner.resourceShareTextArea = resourceShareTextArea;

      return resourceShareTextArea;
    }

    /**
     * Getter for f_FlowPanel5 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel5() {
      return build_f_FlowPanel5();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel5 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel5.setStyleName("" + get_playerStyle().collectionShareSeparator() + "");


      return f_FlowPanel5;
    }

    /**
     * Getter for socialSharePanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_socialSharePanel() {
      return build_socialSharePanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_socialSharePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel socialSharePanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      socialSharePanel.add(get_f_Label6());
      socialSharePanel.add(get_sharePanel());


      owner.socialSharePanel = socialSharePanel;

      return socialSharePanel;
    }

    /**
     * Getter for f_Label6 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label6() {
      return build_f_Label6();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label6() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label6 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label6.setStyleName("" + get_playerStyle().collectionSocialshareTitle() + "");


      return f_Label6;
    }

    /**
     * Getter for sharePanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_sharePanel() {
      return build_sharePanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_sharePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel sharePanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      sharePanel.setStyleName("" + get_playerStyle().collectionShareTitleContainer() + "");


      owner.sharePanel = sharePanel;

      return sharePanel;
    }

    /**
     * Getter for f_HTMLPanel7 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel7() {
      return build_f_HTMLPanel7();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel7() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel7 = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      f_HTMLPanel7.setStyleName("" + get_playerStyle().collectionShareButtonscontainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord164 = UiBinderUtil.attachToDom(f_HTMLPanel7.getElement());
      get_domId0Element().get();
      get_domId1Element().get();

      // Detach section.
      attachRecord164.detach();
      f_HTMLPanel7.addAndReplaceElement(get_bitlyLink(), get_domId0Element().get());
      f_HTMLPanel7.addAndReplaceElement(get_embedLink(), get_domId1Element().get());

      return f_HTMLPanel7;
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
     * Getter for bitlyLink called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.InlineLabel get_bitlyLink() {
      return build_bitlyLink();
    }
    private com.google.gwt.user.client.ui.InlineLabel build_bitlyLink() {
      // Creation section.
      final com.google.gwt.user.client.ui.InlineLabel bitlyLink = (com.google.gwt.user.client.ui.InlineLabel) GWT.create(com.google.gwt.user.client.ui.InlineLabel.class);
      // Setup section.
      bitlyLink.setStyleName("" + get_playerStyle().collectionShareButton1() + "");
      bitlyLink.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.bitlyLink = bitlyLink;

      return bitlyLink;
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
     * Getter for domId1 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for embedLink called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.InlineLabel get_embedLink() {
      return build_embedLink();
    }
    private com.google.gwt.user.client.ui.InlineLabel build_embedLink() {
      // Creation section.
      final com.google.gwt.user.client.ui.InlineLabel embedLink = (com.google.gwt.user.client.ui.InlineLabel) GWT.create(com.google.gwt.user.client.ui.InlineLabel.class);
      // Setup section.
      embedLink.setStyleName("" + get_playerStyle().collectionShareButton2() + "");
      embedLink.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.embedLink = embedLink;

      return embedLink;
    }

    /**
     * Getter for domId1Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for hideButton called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_hideButton() {
      return build_hideButton();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_hideButton() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel hideButton = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html4().asString());
      // Setup section.
      hideButton.setStyleName("" + get_playerStyle().resourceInfoBottomImageContainer() + "");
      hideButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord165 = UiBinderUtil.attachToDom(hideButton.getElement());
      get_domId2Element().get();
      get_domId3Element().get();

      // Detach section.
      attachRecord165.detach();
      hideButton.addAndReplaceElement(get_f_Label8(), get_domId2Element().get());
      hideButton.addAndReplaceElement(get_hideText(), get_domId3Element().get());

      owner.hideButton = hideButton;

      return hideButton;
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
     * Getter for f_Label8 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label8() {
      return build_f_Label8();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label8() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label8 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label8.setStyleName("" + get_playerStyle().resourceInfoHideImage() + "");


      return f_Label8;
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
     * Getter for domId3 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for hideText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_hideText() {
      return build_hideText();
    }
    private com.google.gwt.user.client.ui.Label build_hideText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label hideText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      hideText.setStyleName("" + get_playerStyle().resourceInfoHideText() + "");


      owner.hideText = hideText;

      return hideText;
    }

    /**
     * Getter for domId3Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
  }
}
