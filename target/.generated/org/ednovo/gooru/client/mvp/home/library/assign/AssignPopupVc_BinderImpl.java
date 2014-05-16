package org.ednovo.gooru.client.mvp.home.library.assign;

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

public class AssignPopupVc_BinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.home.library.assign.AssignPopupVc>, org.ednovo.gooru.client.mvp.home.library.assign.AssignPopupVc.Binder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html1(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html2(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html3(String arg0);
     
    @Template("")
    SafeHtml html4();
     
    @Template("")
    SafeHtml html5();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html6(String arg0);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html7(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html8(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html9(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html10(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span> <span id='{5}'></span> <span id='{6}'></span>")
    SafeHtml html11(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6);
     
    @Template("")
    SafeHtml html12();
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span> <span id='{4}'></span> <span id='{5}'></span>  <span id='{6}'></span> <span id='{7}'></span>  <span id='{8}'></span>")
    SafeHtml html13(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html14(String arg0, String arg1);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html15(String arg0, String arg1);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html16(String arg0);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.home.library.assign.AssignPopupVc owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.home.library.assign.AssignPopupVc owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onCancelClicked(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickSwithUrl(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickSwithToEmbed(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onLoginClicked(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onForgotPwdClicked(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onSignUp(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onGmailButtonClicked(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.home.library.assign.AssignPopupVc owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_domId26();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 8
      build_domId21();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId23();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId24();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId25();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId28();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId29();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId31();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId32();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 7
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId17();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId18();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId19();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId20();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId22();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId27();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId30();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId14();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId15();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId16();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId33();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId26Element();  // more than one getter call detected. Type: DEFAULT, precedence: 8
      build_domId21Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId23Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId24Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId25Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId28Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId29Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId31Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId32Element();  // more than one getter call detected. Type: DEFAULT, precedence: 7
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId17Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId18Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId19Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId20Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId22Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId27Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId30Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId14Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId15Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId16Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId33Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1(get_domId2(), get_domId3());
    }
    SafeHtml template_html2() {
      return template.html2(get_domId6());
    }
    SafeHtml template_html3() {
      return template.html3(get_domId11());
    }
    SafeHtml template_html4() {
      return template.html4();
    }
    SafeHtml template_html5() {
      return template.html5();
    }
    SafeHtml template_html6() {
      return template.html6(get_domId21());
    }
    SafeHtml template_html7() {
      return template.html7(get_domId26());
    }
    SafeHtml template_html8() {
      return template.html8(get_domId23(), get_domId24(), get_domId25());
    }
    SafeHtml template_html9() {
      return template.html9(get_domId28(), get_domId29());
    }
    SafeHtml template_html10() {
      return template.html10(get_domId31(), get_domId32());
    }
    SafeHtml template_html11() {
      return template.html11(get_domId17(), get_domId18(), get_domId19(), get_domId20(), get_domId22(), get_domId27(), get_domId30());
    }
    SafeHtml template_html12() {
      return template.html12();
    }
    SafeHtml template_html13() {
      return template.html13(get_domId8(), get_domId9(), get_domId10(), get_domId12(), get_domId13(), get_domId14(), get_domId15(), get_domId16(), get_domId33());
    }
    SafeHtml template_html14() {
      return template.html14(get_domId5(), get_domId7());
    }
    SafeHtml template_html15() {
      return template.html15(get_domId1(), get_domId4());
    }
    SafeHtml template_html16() {
      return template.html16(get_domId0());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.library.assign.AssignPopupVc_BinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.home.library.assign.AssignPopupVc_BinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.home.library.assign.AssignPopupVc_BinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.home.library.assign.AssignPopupVc_BinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.home.library.assign.AssignPopupVc_BinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 31 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.library.assign.AssignPopUpCBundle res;
    private org.ednovo.gooru.client.mvp.home.library.assign.AssignPopUpCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.mvp.home.library.assign.AssignPopUpCBundle build_res() {
      // Creation section.
      res = owner.res;
      assert res != null : "UiField res with 'provided = true' was null";
      // Setup section.


      return res;
    }

    /**
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html16().asString());
      // Setup section.
      f_HTMLPanel1.setStyleName("" + get_res().css().assign() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord460 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId0Element().get();

      // Detach section.
      attachRecord460.detach();
      f_HTMLPanel1.addAndReplaceElement(get_f_HTMLPanel2(), get_domId0Element().get());

      return f_HTMLPanel1;
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
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html15().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_res().css().assignContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord461 = UiBinderUtil.attachToDom(f_HTMLPanel2.getElement());
      get_domId1Element().get();
      get_domId4Element().get();

      // Detach section.
      attachRecord461.detach();
      f_HTMLPanel2.addAndReplaceElement(get_f_HTMLPanel3(), get_domId1Element().get());
      f_HTMLPanel2.addAndReplaceElement(get_f_HTMLPanel4(), get_domId4Element().get());

      return f_HTMLPanel2;
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
     * Getter for f_HTMLPanel3 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel3() {
      return build_f_HTMLPanel3();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel3 = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      f_HTMLPanel3.setStyleName("" + get_res().css().assignHeader() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord462 = UiBinderUtil.attachToDom(f_HTMLPanel3.getElement());
      get_domId2Element().get();
      get_domId3Element().get();

      // Detach section.
      attachRecord462.detach();
      f_HTMLPanel3.addAndReplaceElement(get_lblAssignTitle(), get_domId2Element().get());
      f_HTMLPanel3.addAndReplaceElement(get_cancelButton(), get_domId3Element().get());

      return f_HTMLPanel3;
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
     * Getter for lblAssignTitle called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_lblAssignTitle() {
      return build_lblAssignTitle();
    }
    private com.google.gwt.user.client.ui.Label build_lblAssignTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblAssignTitle = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblAssignTitle.setStyleName("" + get_res().css().assignTitle() + "");


      owner.lblAssignTitle = lblAssignTitle;

      return lblAssignTitle;
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
     * Getter for cancelButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_cancelButton() {
      return build_cancelButton();
    }
    private com.google.gwt.user.client.ui.Label build_cancelButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label cancelButton = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      cancelButton.setStyleName("" + get_res().css().assignCloseMarker() + " " + get_res().css().assignSprite() + " " + get_res().css().assignCloseMark() + "");
      cancelButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      return cancelButton;
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
     * Getter for f_HTMLPanel4 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel4() {
      return build_f_HTMLPanel4();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel4 = new com.google.gwt.user.client.ui.HTMLPanel(template_html14().asString());
      // Setup section.
      f_HTMLPanel4.setStyleName("" + get_res().css().conent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord463 = UiBinderUtil.attachToDom(f_HTMLPanel4.getElement());
      get_domId5Element().get();
      get_domId7Element().get();

      // Detach section.
      attachRecord463.detach();
      f_HTMLPanel4.addAndReplaceElement(get_loadingImageLabel(), get_domId5Element().get());
      f_HTMLPanel4.addAndReplaceElement(get_popupContentAssign(), get_domId7Element().get());

      return f_HTMLPanel4;
    }

    /**
     * Getter for domId5 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for loadingImageLabel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_loadingImageLabel() {
      return build_loadingImageLabel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_loadingImageLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel loadingImageLabel = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      loadingImageLabel.setStyleName("" + get_res().css().loadingImageMainDiv() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord464 = UiBinderUtil.attachToDom(loadingImageLabel.getElement());
      get_domId6Element().get();

      // Detach section.
      attachRecord464.detach();
      loadingImageLabel.addAndReplaceElement(get_f_Label5(), get_domId6Element().get());

      owner.loadingImageLabel = loadingImageLabel;

      return loadingImageLabel;
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
     * Getter for f_Label5 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label5() {
      return build_f_Label5();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label5() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label5 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label5.setStyleName("" + get_res().css().loadingImageForSelfEdit() + "");


      return f_Label5;
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
     * Getter for domId5Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
     * Getter for domId7 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 4.
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
     * Getter for popupContentAssign called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_popupContentAssign() {
      return build_popupContentAssign();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_popupContentAssign() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel popupContentAssign = new com.google.gwt.user.client.ui.HTMLPanel(template_html13().asString());
      // Setup section.
      popupContentAssign.setStyleName("" + get_res().css().popupContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord465 = UiBinderUtil.attachToDom(popupContentAssign.getElement());
      get_domId8Element().get();
      get_domId9Element().get();
      get_domId10Element().get();
      get_domId12Element().get();
      get_domId13Element().get();
      get_domId14Element().get();
      get_domId15Element().get();
      get_domId16Element().get();
      get_domId33Element().get();

      // Detach section.
      attachRecord465.detach();
      popupContentAssign.addAndReplaceElement(get_lblpopupTitle(), get_domId8Element().get());
      popupContentAssign.addAndReplaceElement(get_assignDes(), get_domId9Element().get());
      popupContentAssign.addAndReplaceElement(get_f_HTMLPanel6(), get_domId10Element().get());
      popupContentAssign.addAndReplaceElement(get_swithUrlLbl(), get_domId12Element().get());
      popupContentAssign.addAndReplaceElement(get_swithToEmbedLbl(), get_domId13Element().get());
      popupContentAssign.addAndReplaceElement(get_f_HTMLPanel7(), get_domId14Element().get());
      popupContentAssign.addAndReplaceElement(get_f_HTMLPanel8(), get_domId15Element().get());
      popupContentAssign.addAndReplaceElement(get_htmlLoginPanel(), get_domId16Element().get());
      popupContentAssign.addAndReplaceElement(get_htmlEvenPanelContainer(), get_domId33Element().get());

      owner.popupContentAssign = popupContentAssign;

      return popupContentAssign;
    }

    /**
     * Getter for domId8 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for lblpopupTitle called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_lblpopupTitle() {
      return build_lblpopupTitle();
    }
    private com.google.gwt.user.client.ui.Label build_lblpopupTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblpopupTitle = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblpopupTitle.setStyleName("" + get_res().css().popupTitle() + "");


      owner.lblpopupTitle = lblpopupTitle;

      return lblpopupTitle;
    }

    /**
     * Getter for domId8Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId9 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for assignDes called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_assignDes() {
      return build_assignDes();
    }
    private com.google.gwt.user.client.ui.Label build_assignDes() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label assignDes = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      assignDes.setStyleName("" + get_res().css().popupDesc() + "");


      owner.assignDes = assignDes;

      return assignDes;
    }

    /**
     * Getter for domId9Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for f_HTMLPanel6 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel6() {
      return build_f_HTMLPanel6();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel6() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel6 = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      f_HTMLPanel6.setStyleName("" + get_res().css().popupcornerBg() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord466 = UiBinderUtil.attachToDom(f_HTMLPanel6.getElement());
      get_domId11Element().get();

      // Detach section.
      attachRecord466.detach();
      f_HTMLPanel6.addAndReplaceElement(get_shareLinkTxtBox(), get_domId11Element().get());

      return f_HTMLPanel6;
    }

    /**
     * Getter for domId11 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for shareLinkTxtBox called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.TextArea get_shareLinkTxtBox() {
      return build_shareLinkTxtBox();
    }
    private com.google.gwt.user.client.ui.TextArea build_shareLinkTxtBox() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextArea shareLinkTxtBox = (com.google.gwt.user.client.ui.TextArea) GWT.create(com.google.gwt.user.client.ui.TextArea.class);
      // Setup section.
      shareLinkTxtBox.setStyleName("" + get_res().css().shareTextarea() + "");


      owner.shareLinkTxtBox = shareLinkTxtBox;

      return shareLinkTxtBox;
    }

    /**
     * Getter for domId11Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for swithUrlLbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_swithUrlLbl() {
      return build_swithUrlLbl();
    }
    private com.google.gwt.user.client.ui.Label build_swithUrlLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label swithUrlLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      swithUrlLbl.setStyleName("" + get_res().css().url() + "");
      swithUrlLbl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.swithUrlLbl = swithUrlLbl;

      return swithUrlLbl;
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
     * Getter for swithToEmbedLbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_swithToEmbedLbl() {
      return build_swithToEmbedLbl();
    }
    private com.google.gwt.user.client.ui.Label build_swithToEmbedLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label swithToEmbedLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      swithToEmbedLbl.setStyleName("" + get_res().css().url() + "");
      swithToEmbedLbl.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);


      owner.swithToEmbedLbl = swithToEmbedLbl;

      return swithToEmbedLbl;
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
     * Getter for f_HTMLPanel7 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel7() {
      return build_f_HTMLPanel7();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel7() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel7 = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      f_HTMLPanel7.setStyleName("" + get_res().css().clear() + "");


      return f_HTMLPanel7;
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
     * Getter for f_HTMLPanel8 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel8() {
      return build_f_HTMLPanel8();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel8() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel8 = new com.google.gwt.user.client.ui.HTMLPanel(template_html5().asString());
      // Setup section.
      f_HTMLPanel8.setStyleName("" + get_res().css().contentBorder() + "");


      return f_HTMLPanel8;
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
     * Getter for htmlLoginPanel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_htmlLoginPanel() {
      return build_htmlLoginPanel();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_htmlLoginPanel() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel htmlLoginPanel = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html11().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord467 = UiBinderUtil.attachToDom(htmlLoginPanel.getElement());
      get_domId17Element().get();
      get_domId18Element().get();
      get_domId19Element().get();
      get_domId20Element().get();
      get_domId22Element().get();
      get_domId27Element().get();
      get_domId30Element().get();

      // Detach section.
      attachRecord467.detach();
      htmlLoginPanel.addAndReplaceElement(get_lblLoginPopupTitle(), get_domId17Element().get());
      htmlLoginPanel.addAndReplaceElement(get_lblAssignPopDes(), get_domId18Element().get());
      htmlLoginPanel.addAndReplaceElement(get_gmailButton(), get_domId19Element().get());
      htmlLoginPanel.addAndReplaceElement(get_f_HTMLPanel9(), get_domId20Element().get());
      htmlLoginPanel.addAndReplaceElement(get_f_HTMLPanel10(), get_domId22Element().get());
      htmlLoginPanel.addAndReplaceElement(get_f_HTMLPanel12(), get_domId27Element().get());
      htmlLoginPanel.addAndReplaceElement(get_signUpStyles(), get_domId30Element().get());

      owner.htmlLoginPanel = htmlLoginPanel;

      return htmlLoginPanel;
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
     * Getter for lblLoginPopupTitle called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_lblLoginPopupTitle() {
      return build_lblLoginPopupTitle();
    }
    private com.google.gwt.user.client.ui.Label build_lblLoginPopupTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblLoginPopupTitle = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblLoginPopupTitle.setStyleName("" + get_res().css().popupTitle() + "");


      owner.lblLoginPopupTitle = lblLoginPopupTitle;

      return lblLoginPopupTitle;
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
     * Getter for domId18 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for lblAssignPopDes called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Label get_lblAssignPopDes() {
      return build_lblAssignPopDes();
    }
    private com.google.gwt.user.client.ui.Label build_lblAssignPopDes() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblAssignPopDes = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblAssignPopDes.setStyleName("" + get_res().css().popupDesc() + "");


      owner.lblAssignPopDes = lblAssignPopDes;

      return lblAssignPopDes;
    }

    /**
     * Getter for domId18Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId19 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for gmailButton called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Button get_gmailButton() {
      return build_gmailButton();
    }
    private com.google.gwt.user.client.ui.Button build_gmailButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button gmailButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      gmailButton.setStyleName("" + get_res().css().gConnectButton() + "");
      gmailButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7);


      owner.gmailButton = gmailButton;

      return gmailButton;
    }

    /**
     * Getter for domId19Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId20 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for f_HTMLPanel9 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel9() {
      return build_f_HTMLPanel9();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel9() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel9 = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.
      f_HTMLPanel9.setStyleName("" + get_res().css().divider() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord468 = UiBinderUtil.attachToDom(f_HTMLPanel9.getElement());
      get_domId21Element().get();

      // Detach section.
      attachRecord468.detach();
      f_HTMLPanel9.addAndReplaceElement(get_lblOr(), get_domId21Element().get());

      return f_HTMLPanel9;
    }

    /**
     * Getter for domId21 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for lblOr called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_lblOr() {
      return build_lblOr();
    }
    private com.google.gwt.user.client.ui.Label build_lblOr() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblOr = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblOr.setStyleName("" + get_res().css().dividerText() + "");


      owner.lblOr = lblOr;

      return lblOr;
    }

    /**
     * Getter for domId21Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId20Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId22 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for f_HTMLPanel10 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel10() {
      return build_f_HTMLPanel10();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel10() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel10 = new com.google.gwt.user.client.ui.HTMLPanel(template_html8().asString());
      // Setup section.
      f_HTMLPanel10.setStyleName("" + get_res().css().inputBlockOuter() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord469 = UiBinderUtil.attachToDom(f_HTMLPanel10.getElement());
      get_domId23Element().get();
      get_domId24Element().get();
      get_domId25Element().get();

      // Detach section.
      attachRecord469.detach();
      f_HTMLPanel10.addAndReplaceElement(get_loginTxtBox(), get_domId23Element().get());
      f_HTMLPanel10.addAndReplaceElement(get_passwordTxtBox(), get_domId24Element().get());
      f_HTMLPanel10.addAndReplaceElement(get_f_HTMLPanel11(), get_domId25Element().get());

      return f_HTMLPanel10;
    }

    /**
     * Getter for domId23 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for loginTxtBox called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private org.ednovo.gooru.client.uc.TextBoxWithPlaceholder get_loginTxtBox() {
      return build_loginTxtBox();
    }
    private org.ednovo.gooru.client.uc.TextBoxWithPlaceholder build_loginTxtBox() {
      // Creation section.
      final org.ednovo.gooru.client.uc.TextBoxWithPlaceholder loginTxtBox = (org.ednovo.gooru.client.uc.TextBoxWithPlaceholder) GWT.create(org.ednovo.gooru.client.uc.TextBoxWithPlaceholder.class);
      // Setup section.
      loginTxtBox.setSetFocus(true);


      owner.loginTxtBox = loginTxtBox;

      return loginTxtBox;
    }

    /**
     * Getter for domId23Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId24 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for passwordTxtBox called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private org.ednovo.gooru.client.uc.TextBoxWithPlaceholder get_passwordTxtBox() {
      return build_passwordTxtBox();
    }
    private org.ednovo.gooru.client.uc.TextBoxWithPlaceholder build_passwordTxtBox() {
      // Creation section.
      final org.ednovo.gooru.client.uc.TextBoxWithPlaceholder passwordTxtBox = (org.ednovo.gooru.client.uc.TextBoxWithPlaceholder) GWT.create(org.ednovo.gooru.client.uc.TextBoxWithPlaceholder.class);
      // Setup section.
      passwordTxtBox.setPassword(true);


      owner.passwordTxtBox = passwordTxtBox;

      return passwordTxtBox;
    }

    /**
     * Getter for domId24Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId25 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for f_HTMLPanel11 called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel11() {
      return build_f_HTMLPanel11();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel11() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel11 = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.
      f_HTMLPanel11.setStyleName("" + get_res().css().pwdTxt() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord470 = UiBinderUtil.attachToDom(f_HTMLPanel11.getElement());
      get_domId26Element().get();

      // Detach section.
      attachRecord470.detach();
      f_HTMLPanel11.addAndReplaceElement(get_forgotPwd(), get_domId26Element().get());

      return f_HTMLPanel11;
    }

    /**
     * Getter for domId26 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 8.
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
     * Getter for forgotPwd called 1 times. Type: DEFAULT. Build precedence: 8.
     */
    private com.google.gwt.user.client.ui.Anchor get_forgotPwd() {
      return build_forgotPwd();
    }
    private com.google.gwt.user.client.ui.Anchor build_forgotPwd() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor forgotPwd = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      forgotPwd.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5);


      owner.forgotPwd = forgotPwd;

      return forgotPwd;
    }

    /**
     * Getter for domId26Element called 2 times. Type: DEFAULT. Build precedence: 8.
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
     * Getter for domId25Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId22Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId27 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for f_HTMLPanel12 called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel12() {
      return build_f_HTMLPanel12();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel12() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel12 = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      f_HTMLPanel12.setStyleName("" + get_res().css().btn() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord471 = UiBinderUtil.attachToDom(f_HTMLPanel12.getElement());
      get_domId28Element().get();
      get_domId29Element().get();

      // Detach section.
      attachRecord471.detach();
      f_HTMLPanel12.addAndReplaceElement(get_loginButton(), get_domId28Element().get());
      f_HTMLPanel12.addAndReplaceElement(get_lblPleaseWait(), get_domId29Element().get());

      return f_HTMLPanel12;
    }

    /**
     * Getter for domId28 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for loginButton called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Button get_loginButton() {
      return build_loginButton();
    }
    private com.google.gwt.user.client.ui.Button build_loginButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button loginButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      loginButton.setStyleName("primary " + get_res().css().LoginText() + "");
      loginButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);


      owner.loginButton = loginButton;

      return loginButton;
    }

    /**
     * Getter for domId28Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId29 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for lblPleaseWait called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_lblPleaseWait() {
      return build_lblPleaseWait();
    }
    private com.google.gwt.user.client.ui.Label build_lblPleaseWait() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblPleaseWait = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblPleaseWait.setStyleName("" + get_res().css().processing() + "");


      owner.lblPleaseWait = lblPleaseWait;

      return lblPleaseWait;
    }

    /**
     * Getter for domId29Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId27Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId30 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 6.
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
     * Getter for signUpStyles called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_signUpStyles() {
      return build_signUpStyles();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_signUpStyles() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel signUpStyles = new com.google.gwt.user.client.ui.HTMLPanel(template_html10().asString());
      // Setup section.
      signUpStyles.setStyleName("" + get_res().css().signUp() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord472 = UiBinderUtil.attachToDom(signUpStyles.getElement());
      get_domId31Element().get();
      get_domId32Element().get();

      // Detach section.
      attachRecord472.detach();
      signUpStyles.addAndReplaceElement(get_donothaveAC(), get_domId31Element().get());
      signUpStyles.addAndReplaceElement(get_ancSignUp(), get_domId32Element().get());

      owner.signUpStyles = signUpStyles;

      return signUpStyles;
    }

    /**
     * Getter for domId31 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for donothaveAC called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Label get_donothaveAC() {
      return build_donothaveAC();
    }
    private com.google.gwt.user.client.ui.Label build_donothaveAC() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label donothaveAC = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.donothaveAC = donothaveAC;

      return donothaveAC;
    }

    /**
     * Getter for domId31Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId32 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 7.
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
     * Getter for ancSignUp called 1 times. Type: DEFAULT. Build precedence: 7.
     */
    private com.google.gwt.user.client.ui.Anchor get_ancSignUp() {
      return build_ancSignUp();
    }
    private com.google.gwt.user.client.ui.Anchor build_ancSignUp() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor ancSignUp = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      ancSignUp.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6);


      owner.ancSignUp = ancSignUp;

      return ancSignUp;
    }

    /**
     * Getter for domId32Element called 2 times. Type: DEFAULT. Build precedence: 7.
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
     * Getter for domId30Element called 2 times. Type: DEFAULT. Build precedence: 6.
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
     * Getter for domId33 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for htmlEvenPanelContainer called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_htmlEvenPanelContainer() {
      return build_htmlEvenPanelContainer();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_htmlEvenPanelContainer() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel htmlEvenPanelContainer = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html12().asString());
      // Setup section.
      htmlEvenPanelContainer.setStyleName("" + get_res().css().heightClasspagecontainer() + "");


      owner.htmlEvenPanelContainer = htmlEvenPanelContainer;

      return htmlEvenPanelContainer;
    }

    /**
     * Getter for domId33Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId7Element called 2 times. Type: DEFAULT. Build precedence: 4.
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
  }
}
