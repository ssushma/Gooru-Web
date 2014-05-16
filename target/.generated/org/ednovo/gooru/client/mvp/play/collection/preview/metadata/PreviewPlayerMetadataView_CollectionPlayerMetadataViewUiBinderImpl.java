package org.ednovo.gooru.client.mvp.play.collection.preview.metadata;

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

public class PreviewPlayerMetadataView_CollectionPlayerMetadataViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.play.collection.preview.metadata.PreviewPlayerMetadataView>, org.ednovo.gooru.client.mvp.play.collection.preview.metadata.PreviewPlayerMetadataView.CollectionPlayerMetadataViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span><span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span><span id='{4}'></span>")
    SafeHtml html1(String arg0, String arg1, String arg2, String arg3, String arg4);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span> <span id='{5}'></span> <span id='{6}'></span>")
    SafeHtml html2(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span>")
    SafeHtml html3(String arg0, String arg1, String arg2, String arg3, String arg4);
     
    @Template("")
    SafeHtml html4();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html5(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html6(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html7(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html8(String arg0, String arg1, String arg2, String arg3);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html9(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html10(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html11(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html12(String arg0, String arg1, String arg2, String arg3);
     
    @Template("")
    SafeHtml html13();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html14(String arg0, String arg1);
     
    @Template("")
    SafeHtml html15();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html16(String arg0, String arg1);
     
    @Template("")
    SafeHtml html17();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html18(String arg0, String arg1);
     
    @Template("")
    SafeHtml html19();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html20(String arg0, String arg1);
     
    @Template("")
    SafeHtml html21();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html22(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html23(String arg0);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.play.collection.preview.metadata.PreviewPlayerMetadataView owner) {


    return new Widgets(owner).get_mainPlayerContainer();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.play.collection.preview.metadata.PreviewPlayerMetadataView owner;


    final com.google.gwt.event.dom.client.ErrorHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ErrorHandler() {
      public void onError(com.google.gwt.event.dom.client.ErrorEvent event) {
        owner.setDefaultProfileImage(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickOnLoginUrl(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickOnSignupUrl(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickOnPostCommentBtn(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickOnPostCommentCancel(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickOnSeeMoreButton(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickOnpreviewFlagButton(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.clickSeeAll(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.play.collection.preview.metadata.PreviewPlayerMetadataView owner) {
      this.owner = owner;
      build_playerStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId24();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId14();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId15();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId16();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId22();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId23();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId17();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId18();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId19();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId20();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId21();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId25();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId26();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId27();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId28();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId29();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId30();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId31();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId32();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId33();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId34();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId35();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId36();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId37();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId38();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId39();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId40();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId41();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId42();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId43();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId44();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId45();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId46();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId24Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId14Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId15Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId16Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId22Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId23Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId17Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId18Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId19Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId20Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId21Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId25Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId26Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId27Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId28Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId29Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId30Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId31Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId32Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId33Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId34Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId35Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId36Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId37Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId38Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId39Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId40Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId41Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId42Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId43Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId44Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId45Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId46Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
    }

    SafeHtml template_html1() {
      return template.html1(get_domId6(), get_domId7(), get_domId8(), get_domId9(), get_domId10());
    }
    SafeHtml template_html2() {
      return template.html2(get_domId5(), get_domId11(), get_domId12(), get_domId13(), get_domId14(), get_domId15(), get_domId16());
    }
    SafeHtml template_html3() {
      return template.html3(get_domId0(), get_domId1(), get_domId2(), get_domId3(), get_domId4());
    }
    SafeHtml template_html4() {
      return template.html4();
    }
    SafeHtml template_html5() {
      return template.html5(get_domId17(), get_domId18(), get_domId19());
    }
    SafeHtml template_html6() {
      return template.html6(get_domId24());
    }
    SafeHtml template_html7() {
      return template.html7(get_domId22(), get_domId23());
    }
    SafeHtml template_html8() {
      return template.html8(get_domId20(), get_domId21(), get_domId25(), get_domId26());
    }
    SafeHtml template_html9() {
      return template.html9(get_domId27(), get_domId28());
    }
    SafeHtml template_html10() {
      return template.html10(get_domId29(), get_domId30());
    }
    SafeHtml template_html11() {
      return template.html11(get_domId31());
    }
    SafeHtml template_html12() {
      return template.html12(get_domId32(), get_domId33(), get_domId34(), get_domId35());
    }
    SafeHtml template_html13() {
      return template.html13();
    }
    SafeHtml template_html14() {
      return template.html14(get_domId36(), get_domId37());
    }
    SafeHtml template_html15() {
      return template.html15();
    }
    SafeHtml template_html16() {
      return template.html16(get_domId38(), get_domId39());
    }
    SafeHtml template_html17() {
      return template.html17();
    }
    SafeHtml template_html18() {
      return template.html18(get_domId40(), get_domId41());
    }
    SafeHtml template_html19() {
      return template.html19();
    }
    SafeHtml template_html20() {
      return template.html20(get_domId42(), get_domId43());
    }
    SafeHtml template_html21() {
      return template.html21();
    }
    SafeHtml template_html22() {
      return template.html22(get_domId44(), get_domId45());
    }
    SafeHtml template_html23() {
      return template.html23(get_domId46());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.collection.preview.metadata.PreviewPlayerMetadataView_CollectionPlayerMetadataViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.play.collection.preview.metadata.PreviewPlayerMetadataView_CollectionPlayerMetadataViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.play.collection.preview.metadata.PreviewPlayerMetadataView_CollectionPlayerMetadataViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.play.collection.preview.metadata.PreviewPlayerMetadataView_CollectionPlayerMetadataViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.play.collection.preview.metadata.PreviewPlayerMetadataView_CollectionPlayerMetadataViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for playerStyle called 46 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.collection.preview.metadata.PreviewPlayerMetadataView_CollectionPlayerMetadataViewUiBinderImpl_GenCss_playerStyle playerStyle;
    private org.ednovo.gooru.client.mvp.play.collection.preview.metadata.PreviewPlayerMetadataView_CollectionPlayerMetadataViewUiBinderImpl_GenCss_playerStyle get_playerStyle() {
      return playerStyle;
    }
    private org.ednovo.gooru.client.mvp.play.collection.preview.metadata.PreviewPlayerMetadataView_CollectionPlayerMetadataViewUiBinderImpl_GenCss_playerStyle build_playerStyle() {
      // Creation section.
      playerStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().playerStyle();
      // Setup section.
      playerStyle.ensureInjected();


      owner.playerStyle = playerStyle;

      return playerStyle;
    }

    /**
     * Getter for mainPlayerContainer called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_mainPlayerContainer() {
      return build_mainPlayerContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_mainPlayerContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel mainPlayerContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      mainPlayerContainer.add(get_f_FlowPanel1());
      mainPlayerContainer.add(get_f_FlowPanel4());
      mainPlayerContainer.setStyleName("" + get_playerStyle().container() + " " + get_playerStyle().clearfix() + "");


      owner.mainPlayerContainer = mainPlayerContainer;

      return mainPlayerContainer;
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
      f_FlowPanel1.add(get_metadataContainer());
      f_FlowPanel1.add(get_f_Label2());
      f_FlowPanel1.add(get_f_HTMLPanel3());
      f_FlowPanel1.setStyleName("" + get_playerStyle().leftPanel() + "");


      return f_FlowPanel1;
    }

    /**
     * Getter for metadataContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_metadataContainer() {
      return build_metadataContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_metadataContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel metadataContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      owner.metadataContainer = metadataContainer;

      return metadataContainer;
    }

    /**
     * Getter for f_Label2 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label2() {
      return build_f_Label2();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label2() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label2 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label2.setStyleName("" + get_playerStyle().hrShadow() + "");


      return f_Label2;
    }

    /**
     * Getter for f_HTMLPanel3 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel3() {
      return build_f_HTMLPanel3();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      f_HTMLPanel3.setStyleName("" + get_playerStyle().commentsSection() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1467 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
      get_domId0Element().get();
      get_domId1Element().get();
      get_domId2Element().get();
      get_domId3Element().get();
      get_domId4Element().get();

      // Detach section.
      attachRecord1467.detach();
      f_HTMLPanel3.addAndReplaceElement(get_commentCount(), get_domId0Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_commentsContainer(), get_domId1Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_seeMoreButton(), get_domId2Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_noCommentsLbl(), get_domId3Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_addComment(), get_domId4Element().get());

      return f_HTMLPanel3;
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
     * Getter for commentCount called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_commentCount() {
      return build_commentCount();
    }
    private com.google.gwt.user.client.ui.Label build_commentCount() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label commentCount = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      commentCount.setStyleName("" + get_playerStyle().commentsH2() + "");


      owner.commentCount = commentCount;

      return commentCount;
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
     * Getter for commentsContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.VerticalPanel get_commentsContainer() {
      return build_commentsContainer();
    }
    private com.google.gwt.user.client.ui.VerticalPanel build_commentsContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.VerticalPanel commentsContainer = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
      // Setup section.


      owner.commentsContainer = commentsContainer;

      return commentsContainer;
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
     * Getter for seeMoreButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_seeMoreButton() {
      return build_seeMoreButton();
    }
    private com.google.gwt.user.client.ui.Label build_seeMoreButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label seeMoreButton = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      seeMoreButton.setStyleName("" + get_playerStyle().seeMore() + "");
      seeMoreButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6);


      owner.seeMoreButton = seeMoreButton;

      return seeMoreButton;
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
     * Getter for noCommentsLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_noCommentsLbl() {
      return build_noCommentsLbl();
    }
    private com.google.gwt.user.client.ui.Label build_noCommentsLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label noCommentsLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.noCommentsLbl = noCommentsLbl;

      return noCommentsLbl;
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
     * Getter for domId4 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for addComment called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_addComment() {
      return build_addComment();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_addComment() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel addComment = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      addComment.setStyleName("" + get_playerStyle().addComment() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1468 = UiBinderUtil.attachToDom(addComment.getElement());
      get_domId5Element().get();
      get_domId11Element().get();
      get_domId12Element().get();
      get_domId13Element().get();
      get_domId14Element().get();
      get_domId15Element().get();
      get_domId16Element().get();

      // Detach section.
      attachRecord1468.detach();
      addComment.addAndReplaceElement(get_loginMessaging(), get_domId5Element().get());
      addComment.addAndReplaceElement(get_userPhoto(), get_domId11Element().get());
      addComment.addAndReplaceElement(get_commentField(), get_domId12Element().get());
      addComment.addAndReplaceElement(get_successPostMsg(), get_domId13Element().get());
      addComment.addAndReplaceElement(get_postCommentBtn(), get_domId14Element().get());
      addComment.addAndReplaceElement(get_postCommentCancel(), get_domId15Element().get());
      addComment.addAndReplaceElement(get_characterLimit(), get_domId16Element().get());

      owner.addComment = addComment;

      return addComment;
    }

    /**
     * Getter for domId5 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for loginMessaging called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_loginMessaging() {
      return build_loginMessaging();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_loginMessaging() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel loginMessaging = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      loginMessaging.setStyleName("" + get_playerStyle().loginMessaging() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1469 = UiBinderUtil.attachToDom(loginMessaging.getElement());
      get_domId6Element().get();
      get_domId7Element().get();
      get_domId8Element().get();
      get_domId9Element().get();
      get_domId10Element().get();

      // Detach section.
      attachRecord1469.detach();
      loginMessaging.addAndReplaceElement(get_loginMessagingText(), get_domId6Element().get());
      loginMessaging.addAndReplaceElement(get_loginUrl(), get_domId7Element().get());
      loginMessaging.addAndReplaceElement(get_orText(), get_domId8Element().get());
      loginMessaging.addAndReplaceElement(get_signupUrl(), get_domId9Element().get());
      loginMessaging.addAndReplaceElement(get_toCommentText(), get_domId10Element().get());

      owner.loginMessaging = loginMessaging;

      return loginMessaging;
    }

    /**
     * Getter for domId6 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for loginMessagingText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_loginMessagingText() {
      return build_loginMessagingText();
    }
    private com.google.gwt.user.client.ui.Label build_loginMessagingText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label loginMessagingText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.loginMessagingText = loginMessagingText;

      return loginMessagingText;
    }

    /**
     * Getter for domId6Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId7 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for loginUrl called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Anchor get_loginUrl() {
      return build_loginUrl();
    }
    private com.google.gwt.user.client.ui.Anchor build_loginUrl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor loginUrl = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      loginUrl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.loginUrl = loginUrl;

      return loginUrl;
    }

    /**
     * Getter for domId7Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId8 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for orText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_orText() {
      return build_orText();
    }
    private com.google.gwt.user.client.ui.Label build_orText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label orText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.orText = orText;

      return orText;
    }

    /**
     * Getter for domId8Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId9 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for signupUrl called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Anchor get_signupUrl() {
      return build_signupUrl();
    }
    private com.google.gwt.user.client.ui.Anchor build_signupUrl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor signupUrl = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      signupUrl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);


      owner.signupUrl = signupUrl;

      return signupUrl;
    }

    /**
     * Getter for domId9Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId10 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for toCommentText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_toCommentText() {
      return build_toCommentText();
    }
    private com.google.gwt.user.client.ui.Label build_toCommentText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label toCommentText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.toCommentText = toCommentText;

      return toCommentText;
    }

    /**
     * Getter for domId10Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId5Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for userPhoto called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Image get_userPhoto() {
      return build_userPhoto();
    }
    private com.google.gwt.user.client.ui.Image build_userPhoto() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image userPhoto = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      userPhoto.setStyleName("" + get_playerStyle().userPhoto() + "");


      owner.userPhoto = userPhoto;

      return userPhoto;
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
     * Getter for commentField called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.TextArea get_commentField() {
      return build_commentField();
    }
    private com.google.gwt.user.client.ui.TextArea build_commentField() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextArea commentField = (com.google.gwt.user.client.ui.TextArea) GWT.create(com.google.gwt.user.client.ui.TextArea.class);
      // Setup section.
      commentField.setStyleName("" + get_playerStyle().commentField() + "");


      owner.commentField = commentField;

      return commentField;
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
     * Getter for domId13 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for successPostMsg called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_successPostMsg() {
      return build_successPostMsg();
    }
    private com.google.gwt.user.client.ui.Label build_successPostMsg() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label successPostMsg = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      successPostMsg.setStyleName("" + get_playerStyle().successPostMsg() + "");


      owner.successPostMsg = successPostMsg;

      return successPostMsg;
    }

    /**
     * Getter for domId13Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for postCommentBtn called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Button get_postCommentBtn() {
      return build_postCommentBtn();
    }
    private com.google.gwt.user.client.ui.Button build_postCommentBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button postCommentBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      postCommentBtn.setStyleName("secondary disabled");
      postCommentBtn.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);


      owner.postCommentBtn = postCommentBtn;

      return postCommentBtn;
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
     * Getter for postCommentCancel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Button get_postCommentCancel() {
      return build_postCommentCancel();
    }
    private com.google.gwt.user.client.ui.Button build_postCommentCancel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button postCommentCancel = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      postCommentCancel.setStyleName("secondary " + get_playerStyle().marginTop10() + "");
      postCommentCancel.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5);


      owner.postCommentCancel = postCommentCancel;

      return postCommentCancel;
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
     * Getter for characterLimit called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_characterLimit() {
      return build_characterLimit();
    }
    private com.google.gwt.user.client.ui.Label build_characterLimit() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label characterLimit = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      characterLimit.setStyleName("errorMessage " + get_playerStyle().errorMessage() + "");


      owner.characterLimit = characterLimit;

      return characterLimit;
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
     * Getter for domId4Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for f_FlowPanel4 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel4() {
      return build_f_FlowPanel4();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel4 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel4.add(get_whatNextPanel());
      f_FlowPanel4.add(get_authorPanel());
      f_FlowPanel4.add(get_courseSection());
      f_FlowPanel4.add(get_standardSection());
      f_FlowPanel4.add(get_f_HTMLPanel7());
      f_FlowPanel4.add(get_languageObjectiveContainer());
      f_FlowPanel4.add(get_depthOfKnowledgeContainer());
      f_FlowPanel4.add(get_learningAndInnovationSkillsContainer());
      f_FlowPanel4.add(get_audienceContainer());
      f_FlowPanel4.add(get_InstructionalmethodContainer());
      f_FlowPanel4.add(get_homePageConceptsPanel());
      f_FlowPanel4.add(get_f_HTMLPanel8());
      f_FlowPanel4.setStyleName("" + get_playerStyle().rightPanel() + "");


      return f_FlowPanel4;
    }

    /**
     * Getter for whatNextPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_whatNextPanel() {
      return build_whatNextPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_whatNextPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel whatNextPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.
      whatNextPanel.setStyleName("" + get_playerStyle().nextSteps() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1470 = UiBinderUtil.attachToDom(whatNextPanel.getElement());
      get_domId17Element().get();
      get_domId18Element().get();
      get_domId19Element().get();

      // Detach section.
      attachRecord1470.detach();
      whatNextPanel.addAndReplaceElement(get_lblWhatsNext(), get_domId17Element().get());
      whatNextPanel.addAndReplaceElement(get_lblSeeOtherRelatedConcepts(), get_domId18Element().get());
      whatNextPanel.addAndReplaceElement(get_relatedConceptsEndPage(), get_domId19Element().get());

      owner.whatNextPanel = whatNextPanel;

      return whatNextPanel;
    }

    /**
     * Getter for domId17 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for lblWhatsNext called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_lblWhatsNext() {
      return build_lblWhatsNext();
    }
    private com.google.gwt.user.client.ui.Label build_lblWhatsNext() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblWhatsNext = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblWhatsNext.setStyleName("" + get_playerStyle().h2() + "");


      owner.lblWhatsNext = lblWhatsNext;

      return lblWhatsNext;
    }

    /**
     * Getter for domId17Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId18 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for lblSeeOtherRelatedConcepts called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_lblSeeOtherRelatedConcepts() {
      return build_lblSeeOtherRelatedConcepts();
    }
    private com.google.gwt.user.client.ui.Label build_lblSeeOtherRelatedConcepts() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblSeeOtherRelatedConcepts = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblSeeOtherRelatedConcepts.setStyleName("h6");


      owner.lblSeeOtherRelatedConcepts = lblSeeOtherRelatedConcepts;

      return lblSeeOtherRelatedConcepts;
    }

    /**
     * Getter for domId18Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for relatedConceptsEndPage called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_relatedConceptsEndPage() {
      return build_relatedConceptsEndPage();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_relatedConceptsEndPage() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel relatedConceptsEndPage = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.


      owner.relatedConceptsEndPage = relatedConceptsEndPage;

      return relatedConceptsEndPage;
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
     * Getter for authorPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_authorPanel() {
      return build_authorPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_authorPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel authorPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html8().asString());
      // Setup section.
      authorPanel.setStyleName("" + get_playerStyle().infoSectionAuthor() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1471 = UiBinderUtil.attachToDom(authorPanel.getElement());
      get_domId20Element().get();
      get_domId21Element().get();
      get_domId25Element().get();
      get_domId26Element().get();

      // Detach section.
      attachRecord1471.detach();
      authorPanel.addAndReplaceElement(get_lblAuthor(), get_domId20Element().get());
      authorPanel.addAndReplaceElement(get_f_HTMLPanel5(), get_domId21Element().get());
      authorPanel.addAndReplaceElement(get_userNameLabel(), get_domId25Element().get());
      authorPanel.addAndReplaceElement(get_teamContainer(), get_domId26Element().get());

      owner.authorPanel = authorPanel;

      return authorPanel;
    }

    /**
     * Getter for domId20 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for lblAuthor called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_lblAuthor() {
      return build_lblAuthor();
    }
    private com.google.gwt.user.client.ui.Label build_lblAuthor() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblAuthor = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblAuthor.setStyleName("h6 " + get_playerStyle().marginBotton10Px() + "");


      owner.lblAuthor = lblAuthor;

      return lblAuthor;
    }

    /**
     * Getter for domId20Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId21 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for f_HTMLPanel5 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel5() {
      return build_f_HTMLPanel5();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel5 = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.
      f_HTMLPanel5.setStyleName("" + get_playerStyle().userImageContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1472 = UiBinderUtil.attachToDom(f_HTMLPanel5.getElement());
      get_domId22Element().get();
      get_domId23Element().get();

      // Detach section.
      attachRecord1472.detach();
      f_HTMLPanel5.addAndReplaceElement(get_profileThumbnailImage(), get_domId22Element().get());
      f_HTMLPanel5.addAndReplaceElement(get_f_HTMLPanel6(), get_domId23Element().get());

      return f_HTMLPanel5;
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
     * Getter for profileThumbnailImage called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Image get_profileThumbnailImage() {
      return build_profileThumbnailImage();
    }
    private com.google.gwt.user.client.ui.Image build_profileThumbnailImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image profileThumbnailImage = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      profileThumbnailImage.setStyleName("" + get_playerStyle().userImage() + "");
      profileThumbnailImage.addErrorHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.profileThumbnailImage = profileThumbnailImage;

      return profileThumbnailImage;
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
     * Getter for domId23 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for f_HTMLPanel6 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel6() {
      return build_f_HTMLPanel6();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel6() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel6 = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.
      f_HTMLPanel6.setStyleName("" + get_playerStyle().teacherTipOuterContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1473 = UiBinderUtil.attachToDom(f_HTMLPanel6.getElement());
      get_domId24Element().get();

      // Detach section.
      attachRecord1473.detach();
      f_HTMLPanel6.addAndReplaceElement(get_teacherTipLabel(), get_domId24Element().get());

      return f_HTMLPanel6;
    }

    /**
     * Getter for domId24 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for teacherTipLabel called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_teacherTipLabel() {
      return build_teacherTipLabel();
    }
    private com.google.gwt.user.client.ui.Label build_teacherTipLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label teacherTipLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.teacherTipLabel = teacherTipLabel;

      return teacherTipLabel;
    }

    /**
     * Getter for domId24Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId23Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId21Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for userNameLabel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_userNameLabel() {
      return build_userNameLabel();
    }
    private com.google.gwt.user.client.ui.Label build_userNameLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label userNameLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      userNameLabel.setStyleName("" + get_playerStyle().username() + "");


      owner.userNameLabel = userNameLabel;

      return userNameLabel;
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
     * Getter for domId26 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for teamContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_teamContainer() {
      return build_teamContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_teamContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel teamContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      teamContainer.setStyleName("" + get_playerStyle().username() + "");


      owner.teamContainer = teamContainer;

      return teamContainer;
    }

    /**
     * Getter for domId26Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for courseSection called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_courseSection() {
      return build_courseSection();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_courseSection() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel courseSection = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      courseSection.setStyleName("" + get_playerStyle().infoSection() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1474 = UiBinderUtil.attachToDom(courseSection.getElement());
      get_domId27Element().get();
      get_domId28Element().get();

      // Detach section.
      attachRecord1474.detach();
      courseSection.addAndReplaceElement(get_lblCourse(), get_domId27Element().get());
      courseSection.addAndReplaceElement(get_courseTitle(), get_domId28Element().get());

      owner.courseSection = courseSection;

      return courseSection;
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
     * Getter for lblCourse called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_lblCourse() {
      return build_lblCourse();
    }
    private com.google.gwt.user.client.ui.Label build_lblCourse() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblCourse = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblCourse.setStyleName("h6 " + get_playerStyle().marginBotton10Px() + "");


      owner.lblCourse = lblCourse;

      return lblCourse;
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
     * Getter for courseTitle called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_courseTitle() {
      return build_courseTitle();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_courseTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel courseTitle = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      courseTitle.setStyleName("" + get_playerStyle().courseTitle() + "");


      owner.courseTitle = courseTitle;

      return courseTitle;
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
     * Getter for standardSection called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_standardSection() {
      return build_standardSection();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_standardSection() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel standardSection = new com.google.gwt.user.client.ui.HTMLPanel(template_html10().asString());
      // Setup section.
      standardSection.setStyleName("" + get_playerStyle().infoSection() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1475 = UiBinderUtil.attachToDom(standardSection.getElement());
      get_domId29Element().get();
      get_domId30Element().get();

      // Detach section.
      attachRecord1475.detach();
      standardSection.addAndReplaceElement(get_lblStandards(), get_domId29Element().get());
      standardSection.addAndReplaceElement(get_standardsContainer(), get_domId30Element().get());

      owner.standardSection = standardSection;

      return standardSection;
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
     * Getter for lblStandards called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_lblStandards() {
      return build_lblStandards();
    }
    private com.google.gwt.user.client.ui.Label build_lblStandards() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblStandards = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblStandards.setStyleName("h6 " + get_playerStyle().marginBotton10Px() + "");


      owner.lblStandards = lblStandards;

      return lblStandards;
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
     * Getter for domId30 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId30;
    private java.lang.String get_domId30() {
      return domId30;
    }
    private java.lang.String build_domId30() {
      // Creation section.
      domId30 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId30;
    }

    /**
     * Getter for standardsContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_standardsContainer() {
      return build_standardsContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_standardsContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel standardsContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      standardsContainer.setStyleName("" + get_playerStyle().standard_section() + "");


      owner.standardsContainer = standardsContainer;

      return standardsContainer;
    }

    /**
     * Getter for domId30Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId30Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId30Element() {
      return domId30Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId30Element() {
      // Creation section.
      domId30Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId30());
      // Setup section.


      return domId30Element;
    }

    /**
     * Getter for f_HTMLPanel7 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel7() {
      return build_f_HTMLPanel7();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel7() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel7 = new com.google.gwt.user.client.ui.HTMLPanel(template_html11().asString());
      // Setup section.
      f_HTMLPanel7.setStyleName("" + get_playerStyle().infoSection() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1476 = UiBinderUtil.attachToDom(f_HTMLPanel7.getElement());
      get_domId31Element().get();

      // Detach section.
      attachRecord1476.detach();
      f_HTMLPanel7.addAndReplaceElement(get_viewsCountLabel(), get_domId31Element().get());

      return f_HTMLPanel7;
    }

    /**
     * Getter for domId31 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId31;
    private java.lang.String get_domId31() {
      return domId31;
    }
    private java.lang.String build_domId31() {
      // Creation section.
      domId31 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId31;
    }

    /**
     * Getter for viewsCountLabel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_viewsCountLabel() {
      return build_viewsCountLabel();
    }
    private com.google.gwt.user.client.ui.Label build_viewsCountLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label viewsCountLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      viewsCountLabel.setStyleName("" + get_playerStyle().views() + "");


      owner.viewsCountLabel = viewsCountLabel;

      return viewsCountLabel;
    }

    /**
     * Getter for domId31Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId31Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId31Element() {
      return domId31Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId31Element() {
      // Creation section.
      domId31Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId31());
      // Setup section.


      return domId31Element;
    }

    /**
     * Getter for languageObjectiveContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_languageObjectiveContainer() {
      return build_languageObjectiveContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_languageObjectiveContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel languageObjectiveContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html12().asString());
      // Setup section.
      languageObjectiveContainer.setStyleName("" + get_playerStyle().infoSection() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1477 = UiBinderUtil.attachToDom(languageObjectiveContainer.getElement());
      get_domId32Element().get();
      get_domId33Element().get();
      get_domId34Element().get();
      get_domId35Element().get();

      // Detach section.
      attachRecord1477.detach();
      languageObjectiveContainer.addAndReplaceElement(get_lbllanguageObjectiveText(), get_domId32Element().get());
      languageObjectiveContainer.addAndReplaceElement(get_lbllanguageObjective(), get_domId33Element().get());
      languageObjectiveContainer.addAndReplaceElement(get_seeMoreAnchor(), get_domId34Element().get());
      languageObjectiveContainer.addAndReplaceElement(get_lbllanguageObjectiveAll(), get_domId35Element().get());

      owner.languageObjectiveContainer = languageObjectiveContainer;

      return languageObjectiveContainer;
    }

    /**
     * Getter for domId32 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId32;
    private java.lang.String get_domId32() {
      return domId32;
    }
    private java.lang.String build_domId32() {
      // Creation section.
      domId32 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId32;
    }

    /**
     * Getter for lbllanguageObjectiveText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_lbllanguageObjectiveText() {
      return build_lbllanguageObjectiveText();
    }
    private com.google.gwt.user.client.ui.Label build_lbllanguageObjectiveText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lbllanguageObjectiveText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lbllanguageObjectiveText.setStyleName("h6 " + get_playerStyle().marginBotton10Px() + "");


      owner.lbllanguageObjectiveText = lbllanguageObjectiveText;

      return lbllanguageObjectiveText;
    }

    /**
     * Getter for domId32Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId32Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId32Element() {
      return domId32Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId32Element() {
      // Creation section.
      domId32Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId32());
      // Setup section.


      return domId32Element;
    }

    /**
     * Getter for domId33 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId33;
    private java.lang.String get_domId33() {
      return domId33;
    }
    private java.lang.String build_domId33() {
      // Creation section.
      domId33 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId33;
    }

    /**
     * Getter for lbllanguageObjective called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.InlineLabel get_lbllanguageObjective() {
      return build_lbllanguageObjective();
    }
    private com.google.gwt.user.client.ui.InlineLabel build_lbllanguageObjective() {
      // Creation section.
      final com.google.gwt.user.client.ui.InlineLabel lbllanguageObjective = (com.google.gwt.user.client.ui.InlineLabel) GWT.create(com.google.gwt.user.client.ui.InlineLabel.class);
      // Setup section.


      owner.lbllanguageObjective = lbllanguageObjective;

      return lbllanguageObjective;
    }

    /**
     * Getter for domId33Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId33Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId33Element() {
      return domId33Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId33Element() {
      // Creation section.
      domId33Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId33());
      // Setup section.


      return domId33Element;
    }

    /**
     * Getter for domId34 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId34;
    private java.lang.String get_domId34() {
      return domId34;
    }
    private java.lang.String build_domId34() {
      // Creation section.
      domId34 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId34;
    }

    /**
     * Getter for seeMoreAnchor called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Anchor get_seeMoreAnchor() {
      return build_seeMoreAnchor();
    }
    private com.google.gwt.user.client.ui.Anchor build_seeMoreAnchor() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor seeMoreAnchor = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      seeMoreAnchor.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8);


      owner.seeMoreAnchor = seeMoreAnchor;

      return seeMoreAnchor;
    }

    /**
     * Getter for domId34Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId34Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId34Element() {
      return domId34Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId34Element() {
      // Creation section.
      domId34Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId34());
      // Setup section.


      return domId34Element;
    }

    /**
     * Getter for domId35 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId35;
    private java.lang.String get_domId35() {
      return domId35;
    }
    private java.lang.String build_domId35() {
      // Creation section.
      domId35 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId35;
    }

    /**
     * Getter for lbllanguageObjectiveAll called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.InlineLabel get_lbllanguageObjectiveAll() {
      return build_lbllanguageObjectiveAll();
    }
    private com.google.gwt.user.client.ui.InlineLabel build_lbllanguageObjectiveAll() {
      // Creation section.
      final com.google.gwt.user.client.ui.InlineLabel lbllanguageObjectiveAll = (com.google.gwt.user.client.ui.InlineLabel) GWT.create(com.google.gwt.user.client.ui.InlineLabel.class);
      // Setup section.


      owner.lbllanguageObjectiveAll = lbllanguageObjectiveAll;

      return lbllanguageObjectiveAll;
    }

    /**
     * Getter for domId35Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId35Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId35Element() {
      return domId35Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId35Element() {
      // Creation section.
      domId35Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId35());
      // Setup section.


      return domId35Element;
    }

    /**
     * Getter for depthOfKnowledgeContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_depthOfKnowledgeContainer() {
      return build_depthOfKnowledgeContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_depthOfKnowledgeContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel depthOfKnowledgeContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html14().asString());
      // Setup section.
      depthOfKnowledgeContainer.setStyleName("" + get_playerStyle().infoSection() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1478 = UiBinderUtil.attachToDom(depthOfKnowledgeContainer.getElement());
      get_domId36Element().get();
      get_domId37Element().get();

      // Detach section.
      attachRecord1478.detach();
      depthOfKnowledgeContainer.addAndReplaceElement(get_lbldepthOfKnowledgeText(), get_domId36Element().get());
      depthOfKnowledgeContainer.addAndReplaceElement(get_depthOfKnowledgePanel(), get_domId37Element().get());

      owner.depthOfKnowledgeContainer = depthOfKnowledgeContainer;

      return depthOfKnowledgeContainer;
    }

    /**
     * Getter for domId36 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId36;
    private java.lang.String get_domId36() {
      return domId36;
    }
    private java.lang.String build_domId36() {
      // Creation section.
      domId36 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId36;
    }

    /**
     * Getter for lbldepthOfKnowledgeText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_lbldepthOfKnowledgeText() {
      return build_lbldepthOfKnowledgeText();
    }
    private com.google.gwt.user.client.ui.Label build_lbldepthOfKnowledgeText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lbldepthOfKnowledgeText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lbldepthOfKnowledgeText.setStyleName("h6 " + get_playerStyle().marginBotton10Px() + "");


      owner.lbldepthOfKnowledgeText = lbldepthOfKnowledgeText;

      return lbldepthOfKnowledgeText;
    }

    /**
     * Getter for domId36Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId36Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId36Element() {
      return domId36Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId36Element() {
      // Creation section.
      domId36Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId36());
      // Setup section.


      return domId36Element;
    }

    /**
     * Getter for domId37 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId37;
    private java.lang.String get_domId37() {
      return domId37;
    }
    private java.lang.String build_domId37() {
      // Creation section.
      domId37 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId37;
    }

    /**
     * Getter for depthOfKnowledgePanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_depthOfKnowledgePanel() {
      return build_depthOfKnowledgePanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_depthOfKnowledgePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel depthOfKnowledgePanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html13().asString());
      // Setup section.


      owner.depthOfKnowledgePanel = depthOfKnowledgePanel;

      return depthOfKnowledgePanel;
    }

    /**
     * Getter for domId37Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId37Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId37Element() {
      return domId37Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId37Element() {
      // Creation section.
      domId37Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId37());
      // Setup section.


      return domId37Element;
    }

    /**
     * Getter for learningAndInnovationSkillsContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_learningAndInnovationSkillsContainer() {
      return build_learningAndInnovationSkillsContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_learningAndInnovationSkillsContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel learningAndInnovationSkillsContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html16().asString());
      // Setup section.
      learningAndInnovationSkillsContainer.setStyleName("" + get_playerStyle().infoSection() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1479 = UiBinderUtil.attachToDom(learningAndInnovationSkillsContainer.getElement());
      get_domId38Element().get();
      get_domId39Element().get();

      // Detach section.
      attachRecord1479.detach();
      learningAndInnovationSkillsContainer.addAndReplaceElement(get_lbllearningAndInnovationText(), get_domId38Element().get());
      learningAndInnovationSkillsContainer.addAndReplaceElement(get_learningAndInnovationSkillPanel(), get_domId39Element().get());

      owner.learningAndInnovationSkillsContainer = learningAndInnovationSkillsContainer;

      return learningAndInnovationSkillsContainer;
    }

    /**
     * Getter for domId38 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId38;
    private java.lang.String get_domId38() {
      return domId38;
    }
    private java.lang.String build_domId38() {
      // Creation section.
      domId38 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId38;
    }

    /**
     * Getter for lbllearningAndInnovationText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_lbllearningAndInnovationText() {
      return build_lbllearningAndInnovationText();
    }
    private com.google.gwt.user.client.ui.Label build_lbllearningAndInnovationText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lbllearningAndInnovationText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lbllearningAndInnovationText.setStyleName("h6 " + get_playerStyle().marginBotton10Px() + "");


      owner.lbllearningAndInnovationText = lbllearningAndInnovationText;

      return lbllearningAndInnovationText;
    }

    /**
     * Getter for domId38Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId38Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId38Element() {
      return domId38Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId38Element() {
      // Creation section.
      domId38Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId38());
      // Setup section.


      return domId38Element;
    }

    /**
     * Getter for domId39 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId39;
    private java.lang.String get_domId39() {
      return domId39;
    }
    private java.lang.String build_domId39() {
      // Creation section.
      domId39 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId39;
    }

    /**
     * Getter for learningAndInnovationSkillPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_learningAndInnovationSkillPanel() {
      return build_learningAndInnovationSkillPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_learningAndInnovationSkillPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel learningAndInnovationSkillPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html15().asString());
      // Setup section.


      owner.learningAndInnovationSkillPanel = learningAndInnovationSkillPanel;

      return learningAndInnovationSkillPanel;
    }

    /**
     * Getter for domId39Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId39Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId39Element() {
      return domId39Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId39Element() {
      // Creation section.
      domId39Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId39());
      // Setup section.


      return domId39Element;
    }

    /**
     * Getter for audienceContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_audienceContainer() {
      return build_audienceContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_audienceContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel audienceContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html18().asString());
      // Setup section.
      audienceContainer.setStyleName("" + get_playerStyle().infoSection() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1480 = UiBinderUtil.attachToDom(audienceContainer.getElement());
      get_domId40Element().get();
      get_domId41Element().get();

      // Detach section.
      attachRecord1480.detach();
      audienceContainer.addAndReplaceElement(get_lblAudienceText(), get_domId40Element().get());
      audienceContainer.addAndReplaceElement(get_audiencePanel(), get_domId41Element().get());

      owner.audienceContainer = audienceContainer;

      return audienceContainer;
    }

    /**
     * Getter for domId40 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId40;
    private java.lang.String get_domId40() {
      return domId40;
    }
    private java.lang.String build_domId40() {
      // Creation section.
      domId40 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId40;
    }

    /**
     * Getter for lblAudienceText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_lblAudienceText() {
      return build_lblAudienceText();
    }
    private com.google.gwt.user.client.ui.Label build_lblAudienceText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblAudienceText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblAudienceText.setStyleName("h6 " + get_playerStyle().marginBotton10Px() + "");


      owner.lblAudienceText = lblAudienceText;

      return lblAudienceText;
    }

    /**
     * Getter for domId40Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId40Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId40Element() {
      return domId40Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId40Element() {
      // Creation section.
      domId40Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId40());
      // Setup section.


      return domId40Element;
    }

    /**
     * Getter for domId41 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId41;
    private java.lang.String get_domId41() {
      return domId41;
    }
    private java.lang.String build_domId41() {
      // Creation section.
      domId41 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId41;
    }

    /**
     * Getter for audiencePanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_audiencePanel() {
      return build_audiencePanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_audiencePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel audiencePanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html17().asString());
      // Setup section.


      owner.audiencePanel = audiencePanel;

      return audiencePanel;
    }

    /**
     * Getter for domId41Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId41Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId41Element() {
      return domId41Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId41Element() {
      // Creation section.
      domId41Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId41());
      // Setup section.


      return domId41Element;
    }

    /**
     * Getter for InstructionalmethodContainer called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_InstructionalmethodContainer() {
      return build_InstructionalmethodContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_InstructionalmethodContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel InstructionalmethodContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html20().asString());
      // Setup section.
      InstructionalmethodContainer.setStyleName("" + get_playerStyle().infoSection() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1481 = UiBinderUtil.attachToDom(InstructionalmethodContainer.getElement());
      get_domId42Element().get();
      get_domId43Element().get();

      // Detach section.
      attachRecord1481.detach();
      InstructionalmethodContainer.addAndReplaceElement(get_lblInstructionalmethodText(), get_domId42Element().get());
      InstructionalmethodContainer.addAndReplaceElement(get_instructionalmethodPanel(), get_domId43Element().get());

      owner.InstructionalmethodContainer = InstructionalmethodContainer;

      return InstructionalmethodContainer;
    }

    /**
     * Getter for domId42 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId42;
    private java.lang.String get_domId42() {
      return domId42;
    }
    private java.lang.String build_domId42() {
      // Creation section.
      domId42 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId42;
    }

    /**
     * Getter for lblInstructionalmethodText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_lblInstructionalmethodText() {
      return build_lblInstructionalmethodText();
    }
    private com.google.gwt.user.client.ui.Label build_lblInstructionalmethodText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblInstructionalmethodText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblInstructionalmethodText.setStyleName("h6 " + get_playerStyle().marginBotton10Px() + "");


      owner.lblInstructionalmethodText = lblInstructionalmethodText;

      return lblInstructionalmethodText;
    }

    /**
     * Getter for domId42Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId42Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId42Element() {
      return domId42Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId42Element() {
      // Creation section.
      domId42Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId42());
      // Setup section.


      return domId42Element;
    }

    /**
     * Getter for domId43 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId43;
    private java.lang.String get_domId43() {
      return domId43;
    }
    private java.lang.String build_domId43() {
      // Creation section.
      domId43 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId43;
    }

    /**
     * Getter for instructionalmethodPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_instructionalmethodPanel() {
      return build_instructionalmethodPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_instructionalmethodPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel instructionalmethodPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html19().asString());
      // Setup section.


      owner.instructionalmethodPanel = instructionalmethodPanel;

      return instructionalmethodPanel;
    }

    /**
     * Getter for domId43Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId43Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId43Element() {
      return domId43Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId43Element() {
      // Creation section.
      domId43Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId43());
      // Setup section.


      return domId43Element;
    }

    /**
     * Getter for homePageConceptsPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_homePageConceptsPanel() {
      return build_homePageConceptsPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_homePageConceptsPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel homePageConceptsPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html22().asString());
      // Setup section.
      homePageConceptsPanel.setStyleName("" + get_playerStyle().infoSection() + " " + get_playerStyle().relatedConcepts() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1482 = UiBinderUtil.attachToDom(homePageConceptsPanel.getElement());
      get_domId44Element().get();
      get_domId45Element().get();

      // Detach section.
      attachRecord1482.detach();
      homePageConceptsPanel.addAndReplaceElement(get_lblRelatedConcepts(), get_domId44Element().get());
      homePageConceptsPanel.addAndReplaceElement(get_relatedConceptsCoverPage(), get_domId45Element().get());

      owner.homePageConceptsPanel = homePageConceptsPanel;

      return homePageConceptsPanel;
    }

    /**
     * Getter for domId44 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId44;
    private java.lang.String get_domId44() {
      return domId44;
    }
    private java.lang.String build_domId44() {
      // Creation section.
      domId44 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId44;
    }

    /**
     * Getter for lblRelatedConcepts called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_lblRelatedConcepts() {
      return build_lblRelatedConcepts();
    }
    private com.google.gwt.user.client.ui.Label build_lblRelatedConcepts() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblRelatedConcepts = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblRelatedConcepts.setStyleName("h6 " + get_playerStyle().marginBotton10Px() + "");


      owner.lblRelatedConcepts = lblRelatedConcepts;

      return lblRelatedConcepts;
    }

    /**
     * Getter for domId44Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId44Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId44Element() {
      return domId44Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId44Element() {
      // Creation section.
      domId44Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId44());
      // Setup section.


      return domId44Element;
    }

    /**
     * Getter for domId45 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId45;
    private java.lang.String get_domId45() {
      return domId45;
    }
    private java.lang.String build_domId45() {
      // Creation section.
      domId45 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId45;
    }

    /**
     * Getter for relatedConceptsCoverPage called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_relatedConceptsCoverPage() {
      return build_relatedConceptsCoverPage();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_relatedConceptsCoverPage() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel relatedConceptsCoverPage = new com.google.gwt.user.client.ui.HTMLPanel(template_html21().asString());
      // Setup section.


      owner.relatedConceptsCoverPage = relatedConceptsCoverPage;

      return relatedConceptsCoverPage;
    }

    /**
     * Getter for domId45Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId45Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId45Element() {
      return domId45Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId45Element() {
      // Creation section.
      domId45Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId45());
      // Setup section.


      return domId45Element;
    }

    /**
     * Getter for f_HTMLPanel8 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel8() {
      return build_f_HTMLPanel8();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel8() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel8 = new com.google.gwt.user.client.ui.HTMLPanel(template_html23().asString());
      // Setup section.
      f_HTMLPanel8.setStyleName("" + get_playerStyle().infoSection() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1483 = UiBinderUtil.attachToDom(f_HTMLPanel8.getElement());
      get_domId46Element().get();

      // Detach section.
      attachRecord1483.detach();
      f_HTMLPanel8.addAndReplaceElement(get_previewFlagButton(), get_domId46Element().get());

      return f_HTMLPanel8;
    }

    /**
     * Getter for domId46 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
     */
    private java.lang.String domId46;
    private java.lang.String get_domId46() {
      return domId46;
    }
    private java.lang.String build_domId46() {
      // Creation section.
      domId46 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.


      return domId46;
    }

    /**
     * Getter for previewFlagButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Anchor get_previewFlagButton() {
      return build_previewFlagButton();
    }
    private com.google.gwt.user.client.ui.Anchor build_previewFlagButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor previewFlagButton = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      previewFlagButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7);


      owner.previewFlagButton = previewFlagButton;

      return previewFlagButton;
    }

    /**
     * Getter for domId46Element called 2 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId46Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId46Element() {
      return domId46Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId46Element() {
      // Creation section.
      domId46Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId46());
      // Setup section.


      return domId46Element;
    }
  }
}
