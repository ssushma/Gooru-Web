package org.ednovo.gooru.client.mvp.home;

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

public class SaveSharePanel_FaqSlideUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.home.SaveSharePanel>, org.ednovo.gooru.client.mvp.home.SaveSharePanel.FaqSlideUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span>")
    SafeHtml html1(String arg0);
     
    @Template("<div class='{0}'> <div class='{1}'> <div class='{2}'> <span id='{3}'></span> <div class='{4}'> \"<span id='{5}'></span>\" </div> </div> <span id='{6}'></span> <span id='{7}'></span> </div> <div class='{8}'> <div class='{9}'> <span id='{10}'></span> <div class='{11}'> <input class='{12}' readonly='readonly' type='text'> </div> <span id='{13}'></span> <div class='{14}'> <span id='{15}'></span> </div> <div class='{16}'> <div class='{17}'>&gt;</div> <div class='{18}'> <span id='{19}'></span> </div> </div> <div class='{20}'> <div class='{21}'>&gt;</div> <div class='{22}'> <span id='{23}'></span> </div> </div> <div class='{24}'> <div class='{25}'>&gt;</div> <div class='{26}'> <span id='{27}'></span> </div> </div> <div class='{28}'> <span id='{29}'></span> </div> </div> <div class='{30}'> <span id='{31}'></span> <div class='{32}'> <div class='{33}'> <div class='{34}'> <div class='{35}'> <span id='{36}'></span> <span id='{37}'></span> </div> </div> <div class='{38}'> <div class='{39}'> <span id='{40}'></span> <span id='{41}'></span> </div> </div> <div class='{42}'> <div class='{43}'> <span id='{44}'></span> </div> <div class='{45}'> <span id='{46}'></span> </div> </div> </div> <div class='{47}'> <span id='{48}'></span> <div class='{49}'></div> </div> </div> <div class='{50}'> <div class='{51}'>&gt;</div> <div class='{52}'> <span id='{53}'></span> </div> </div> <div class='{54}'> <div class='{55}'>&gt;</div> <div class='{56}'> <span id='{57}'></span> </div> </div> <div class='{58}'> <div class='{59}'>&gt;</div> <div class='{60}'> <span id='{61}'></span> </div> </div> <div class='{62}'> <span id='{63}'></span> </div> </div> <div class='{64}'> <span id='{65}'></span> <div class='{66}'> <span id='{67}'></span> </div> <div class='{68}'> <span id='{69}'></span> <div class='{70}'></div> <span id='{71}'></span> </div> <div class='{72}'> <span id='{73}'></span> <div class='{74}'></div> <span id='{75}'></span> </div> <div class='{76}'> <div class='{77}'>&gt;</div> <div class='{78}'> <span id='{79}'></span> </div> </div> <div class='{80}'> <div class='{81}'>&gt;</div> <div class='{82}'> <span id='{83}'></span> </div> </div> <div class='{84}'> <div class='{85}'>&gt;</div> <div class='{86}'> <span id='{87}'></span> </div> </div> <div class='{88}'> <span id='{89}'></span> </div> </div> <div class='{90}'> <span id='{91}'></span> <div class='{92}'> <span id='{93}'></span> </div> <div class='{94}'> <div class='{95}'>&gt;</div> <div class='{96}'> <span id='{97}'></span> </div> </div> <div class='{98}'> <div class='{99}'> </div> </div> <div class='{100}'> <span id='{101}'></span> </div> </div> </div> <div class='{102}'> <span id='{103}'></span> <div class='{104}'> <span id='{105}'></span> </div> </div> </div>")
    SafeHtml html2(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15, String arg16, String arg17, String arg18, String arg19, String arg20, String arg21, String arg22, String arg23, String arg24, String arg25, String arg26, String arg27, String arg28, String arg29, String arg30, String arg31, String arg32, String arg33, String arg34, String arg35, String arg36, String arg37, String arg38, String arg39, String arg40, String arg41, String arg42, String arg43, String arg44, String arg45, String arg46, String arg47, String arg48, String arg49, String arg50, String arg51, String arg52, String arg53, String arg54, String arg55, String arg56, String arg57, String arg58, String arg59, String arg60, String arg61, String arg62, String arg63, String arg64, String arg65, String arg66, String arg67, String arg68, String arg69, String arg70, String arg71, String arg72, String arg73, String arg74, String arg75, String arg76, String arg77, String arg78, String arg79, String arg80, String arg81, String arg82, String arg83, String arg84, String arg85, String arg86, String arg87, String arg88, String arg89, String arg90, String arg91, String arg92, String arg93, String arg94, String arg95, String arg96, String arg97, String arg98, String arg99, String arg100, String arg101, String arg102, String arg103, String arg104, String arg105);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.home.SaveSharePanel owner) {


    return new Widgets(owner).get_f_FlowPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.home.SaveSharePanel owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.closeButton(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.home.SaveSharePanel owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 6
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId14();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId15();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId16();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId17();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId18();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId19();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId20();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId21();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId22();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId23();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId24();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId25();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId26();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId27();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId28();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId29();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId30();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId31();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId32();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId33();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId34();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId35();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId36();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId37();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId38();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId39();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 6
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId14Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId15Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId16Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId17Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId18Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId19Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId20Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId21Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId22Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId23Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId24Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId25Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId26Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId27Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId28Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId29Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId30Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId31Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId32Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId33Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId34Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId35Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId36Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId37Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId38Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId39Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
    }

    SafeHtml template_html1() {
      return template.html1(get_domId4());
    }
    SafeHtml template_html2() {
      return template.html2("" + get_style().landingHelpPopupContainer() + "", "" + get_style().landingPageHeaderContainer() + "", "" + get_style().quickHelpTextContainer() + "", get_domId0(), "" + get_style().GettingStarted() + "", get_domId1(), get_domId2(), get_domId3(), "" + get_style().landingPageHelpDotsTotalContainer() + "", "" + get_style().landingPageHelpDotsContainer() + "", get_domId5(), "" + get_style().landingPageHelpDiscoverSearchBoxContainer() + "", "" + get_style().landingPageHelpDiscoverSearchBox() + "", get_domId6(), "" + get_style().landingDiscoverIconContainer() + "", get_domId7(), "" + get_style().landingPageHelpDotsFirstText() + "", "" + get_style().singleText() + "", "" + get_style().landingPageHelpDotsHints() + "", get_domId8(), "" + get_style().landingPageHelpDotsText() + "", "" + get_style().singleText() + "", "" + get_style().landingPageHelpDotsHints() + "", get_domId9(), "" + get_style().landingPageHelpDotsText() + "", "" + get_style().singleText() + "", "" + get_style().landingPageHelpDotsHints() + "", get_domId10(), "" + get_style().landingPageHelpSeeMoreORG() + "", get_domId11(), "" + get_style().landingPageHelpDotsContainer() + "", get_domId12(), "" + get_style().landingPageHelpOrganizeImageContainer() + "", "" + get_style().landingPageHelpOrganizeBigIconContainer() + "", "" + get_style().landingPageHelpOrganizeBigIconContainer() + "", "" + get_style().landingPageHelpOrganizeBigIconHolder() + "", get_domId13(), get_domId14(), "" + get_style().landingPageHelpOrganizeBigIconContainerTwo() + "", "" + get_style().landingPageHelpOrganizeBigIconHolder() + "", get_domId15(), get_domId16(), "" + get_style().landingPageHelpOrganizeLessionTotlatContainer() + "", "" + get_style().landingPageHelpOrganizeTopArrow() + "", get_domId17(), "" + get_style().landingPageHelpOrganizeDownArrow() + "", get_domId18(), "" + get_style().landingPageHelpDottedBoxContainer() + "", get_domId19(), "" + get_style().borderStyle() + "", "" + get_style().landingPageHelpDotsFirstText() + "", "" + get_style().singleText() + "", "" + get_style().landingPageHelpDotsHints() + "", get_domId20(), "" + get_style().landingPageHelpDotsText() + "", "" + get_style().singleText() + "", "" + get_style().landingPageHelpDotsHints() + "", get_domId21(), "" + get_style().landingPageHelpDotsText() + "", "" + get_style().singleText() + "", "" + get_style().landingPageHelpDotsHints() + "", get_domId22(), "" + get_style().landingPageHelpSeeMore() + "", get_domId23(), "" + get_style().landingPageHelpDotsContainer() + "", get_domId24(), "" + get_style().landingPageLessionTitle() + "", get_domId25(), "" + get_style().landingPageHelpTeachLessoinContainer() + "", get_domId26(), "" + get_style().landingPageHelpTeachLessoinHintActive() + "", get_domId27(), "" + get_style().landingPageHelpTeachLessoinContainer() + "", get_domId28(), "" + get_style().landingPageHelpTeachLessoinHint() + "", get_domId29(), "" + get_style().landingPageHelpDotsFirstText() + "", "" + get_style().singleText() + "", "" + get_style().landingPageHelpDotsHints() + "", get_domId30(), "" + get_style().landingPageHelpDotsText() + "", "" + get_style().singleText() + "", "" + get_style().landingPageHelpDotsHints() + "", get_domId31(), "" + get_style().landingPageHelpDotsText() + "", "" + get_style().singleText() + "", "" + get_style().landingPageHelpDotsHints() + "", get_domId32(), "" + get_style().landingPageHelpSeeMoreTeach() + "", get_domId33(), "" + get_style().landingPageHelpDotsContainerLast() + "", get_domId34(), "" + get_style().studyImage() + "", get_domId35(), "" + get_style().landingPageHelpDotsText() + "", "" + get_style().singleText() + "", "" + get_style().landingPageHelpDotsHints() + "", get_domId36(), "" + get_style().landingPageHelpDotsText() + "", "" + get_style().landingPageHelpDotsHints() + "", "" + get_style().landingPageHelpSeeMoreStudy() + "", get_domId37(), "" + get_style().supportLinkContainer() + "", get_domId38(), "" + get_style().supportLink() + "", get_domId39());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.SaveSharePanel_FaqSlideUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.home.SaveSharePanel_FaqSlideUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.home.SaveSharePanel_FaqSlideUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.home.SaveSharePanel_FaqSlideUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.home.SaveSharePanel_FaqSlideUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 0 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.register.RegisterCBundle get_res() {
      return build_res();
    }
    private org.ednovo.gooru.client.mvp.home.register.RegisterCBundle build_res() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.home.register.RegisterCBundle res = (org.ednovo.gooru.client.mvp.home.register.RegisterCBundle) GWT.create(org.ednovo.gooru.client.mvp.home.register.RegisterCBundle.class);
      // Setup section.


      return res;
    }

    /**
     * Getter for style called 104 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.SaveSharePanel_FaqSlideUiBinderImpl_GenCss_style style;
    private org.ednovo.gooru.client.mvp.home.SaveSharePanel_FaqSlideUiBinderImpl_GenCss_style get_style() {
      return style;
    }
    private org.ednovo.gooru.client.mvp.home.SaveSharePanel_FaqSlideUiBinderImpl_GenCss_style build_style() {
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
      f_FlowPanel1.add(get_helpContainer());
      f_FlowPanel1.setStyleName("" + get_style().mainSliderContent() + "");


      return f_FlowPanel1;
    }

    /**
     * Getter for helpContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_helpContainer() {
      return build_helpContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_helpContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel helpContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      helpContainer.add(get_f_FlowPanel2());
      helpContainer.setStyleName("" + get_style().helpTotalContainerNew() + "");


      owner.helpContainer = helpContainer;

      return helpContainer;
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
      f_FlowPanel2.add(get_saveSharePanelContentContainer());
      f_FlowPanel2.setStyleName("" + get_style().helpContentDiv() + "");


      return f_FlowPanel2;
    }

    /**
     * Getter for saveSharePanelContentContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_saveSharePanelContentContainer() {
      return build_saveSharePanelContentContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_saveSharePanelContentContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel saveSharePanelContentContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      saveSharePanelContentContainer.setStyleName("" + get_style().landingHelpPopupContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1900 = UiBinderUtil.attachToDom(saveSharePanelContentContainer.getElement());
      get_domId0Element().get();
      get_domId1Element().get();
      get_domId2Element().get();
      get_domId3Element().get();
      get_domId5Element().get();
      get_domId6Element().get();
      get_domId7Element().get();
      get_domId8Element().get();
      get_domId9Element().get();
      get_domId10Element().get();
      get_domId11Element().get();
      get_domId12Element().get();
      get_domId13Element().get();
      get_domId14Element().get();
      get_domId15Element().get();
      get_domId16Element().get();
      get_domId17Element().get();
      get_domId18Element().get();
      get_domId19Element().get();
      get_domId20Element().get();
      get_domId21Element().get();
      get_domId22Element().get();
      get_domId23Element().get();
      get_domId24Element().get();
      get_domId25Element().get();
      get_domId26Element().get();
      get_domId27Element().get();
      get_domId28Element().get();
      get_domId29Element().get();
      get_domId30Element().get();
      get_domId31Element().get();
      get_domId32Element().get();
      get_domId33Element().get();
      get_domId34Element().get();
      get_domId35Element().get();
      get_domId36Element().get();
      get_domId37Element().get();
      get_domId38Element().get();
      get_domId39Element().get();

      // Detach section.
      attachRecord1900.detach();
      saveSharePanelContentContainer.addAndReplaceElement(get_quickHelpText(), get_domId0Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_gettingAnchr(), get_domId1Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_whatText(), get_domId2Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_closeButton(), get_domId3Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_discoverText(), get_domId5Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_searchText(), get_domId6Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_helpImage(), get_domId7Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_howDoISearchText(), get_domId8Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_whichTypeText(), get_domId9Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_filtersText(), get_domId10Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_seeMoreLbl(), get_domId11Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_organizeText(), get_domId12Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_videoBigIconImage(), get_domId13Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_plusIconImage(), get_domId14Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_textBookBigIconImage(), get_domId15Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_plusImage(), get_domId16Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_topArrowImage(), get_domId17Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_smalllArrowImage(), get_domId18Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_lessonText(), get_domId19Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_saveResourceText(), get_domId20Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_narrationText(), get_domId21Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_collectionShareText(), get_domId22Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_seeMoreLabel(), get_domId23Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_teachLbl(), get_domId24Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_teachLessonTitle(), get_domId25Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_tLNo_ONE(), get_domId26Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_thinkAboutText(), get_domId27Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_tLNo_TWO(), get_domId28Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_answerThisText(), get_domId29Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_howtoTeachText(), get_domId30Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_classPageText(), get_domId31Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_shareClasspageText(), get_domId32Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_seeMoreTeachLbl(), get_domId33Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_studyLbl(), get_domId34Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_studyImage(), get_domId35Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_startAssignmentText(), get_domId36Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_seemoreStudyLbl(), get_domId37Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_visitText(), get_domId38Element().get());
      saveSharePanelContentContainer.addAndReplaceElement(get_supportCenterLbl(), get_domId39Element().get());

      owner.saveSharePanelContentContainer = saveSharePanelContentContainer;

      return saveSharePanelContentContainer;
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
     * Getter for quickHelpText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_quickHelpText() {
      return build_quickHelpText();
    }
    private com.google.gwt.user.client.ui.Label build_quickHelpText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label quickHelpText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      quickHelpText.setStyleName("" + get_style().quickHelpText() + "");


      owner.quickHelpText = quickHelpText;

      return quickHelpText;
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
     * Getter for gettingAnchr called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Anchor get_gettingAnchr() {
      return build_gettingAnchr();
    }
    private com.google.gwt.user.client.ui.Anchor build_gettingAnchr() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor gettingAnchr = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      gettingAnchr.setStyleName("" + get_style().textDecor() + "");


      owner.gettingAnchr = gettingAnchr;

      return gettingAnchr;
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
     * Getter for whatText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_whatText() {
      return build_whatText();
    }
    private com.google.gwt.user.client.ui.Label build_whatText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label whatText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      whatText.setStyleName("" + get_style().landingHelpPopupTitle() + "");


      owner.whatText = whatText;

      return whatText;
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
     * Getter for closeButton called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_closeButton() {
      return build_closeButton();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_closeButton() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel closeButton = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html1().asString());
      // Setup section.
      closeButton.setStyleName("" + get_style().landingPageCloseButton() + "");
      closeButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1901 = UiBinderUtil.attachToDom(closeButton.getElement());
      get_domId4Element().get();

      // Detach section.
      attachRecord1901.detach();
      closeButton.addAndReplaceElement(get_closeButtonText(), get_domId4Element().get());

      owner.closeButton = closeButton;

      return closeButton;
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
     * Getter for closeButtonText called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.google.gwt.user.client.ui.Image get_closeButtonText() {
      return build_closeButtonText();
    }
    private com.google.gwt.user.client.ui.Image build_closeButtonText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image closeButtonText = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      closeButtonText.setHeight("15");
      closeButtonText.setWidth("15");


      owner.closeButtonText = closeButtonText;

      return closeButtonText;
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
     * Getter for discoverText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_discoverText() {
      return build_discoverText();
    }
    private com.google.gwt.user.client.ui.Label build_discoverText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label discoverText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      discoverText.setStyleName("" + get_style().landingPageDotsTitle() + "");


      owner.discoverText = discoverText;

      return discoverText;
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
     * Getter for searchText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_searchText() {
      return build_searchText();
    }
    private com.google.gwt.user.client.ui.Label build_searchText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label searchText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      searchText.setStyleName("" + get_style().ladningPageHelpSearchButton() + "");


      owner.searchText = searchText;

      return searchText;
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
     * Getter for helpImage called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Image get_helpImage() {
      return build_helpImage();
    }
    private com.google.gwt.user.client.ui.Image build_helpImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image helpImage = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      helpImage.setHeight("40");


      owner.helpImage = helpImage;

      return helpImage;
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
     * Getter for howDoISearchText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Anchor get_howDoISearchText() {
      return build_howDoISearchText();
    }
    private com.google.gwt.user.client.ui.Anchor build_howDoISearchText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor howDoISearchText = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      howDoISearchText.setStyleName("" + get_style().textDecor() + "");
      howDoISearchText.setTarget("_blank");


      owner.howDoISearchText = howDoISearchText;

      return howDoISearchText;
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
     * Getter for whichTypeText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Anchor get_whichTypeText() {
      return build_whichTypeText();
    }
    private com.google.gwt.user.client.ui.Anchor build_whichTypeText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor whichTypeText = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      whichTypeText.setStyleName("" + get_style().textDecor() + "");
      whichTypeText.setTarget("_blank");


      owner.whichTypeText = whichTypeText;

      return whichTypeText;
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
     * Getter for filtersText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Anchor get_filtersText() {
      return build_filtersText();
    }
    private com.google.gwt.user.client.ui.Anchor build_filtersText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor filtersText = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      filtersText.setStyleName("" + get_style().textDecor() + "");
      filtersText.setTarget("_blank");


      owner.filtersText = filtersText;

      return filtersText;
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
     * Getter for seeMoreLbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Anchor get_seeMoreLbl() {
      return build_seeMoreLbl();
    }
    private com.google.gwt.user.client.ui.Anchor build_seeMoreLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor seeMoreLbl = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      seeMoreLbl.setStyleName("" + get_style().textDecor() + "");
      seeMoreLbl.setTarget("_blank");


      owner.seeMoreLbl = seeMoreLbl;

      return seeMoreLbl;
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
     * Getter for organizeText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_organizeText() {
      return build_organizeText();
    }
    private com.google.gwt.user.client.ui.Label build_organizeText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label organizeText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      organizeText.setStyleName("" + get_style().landingPageDotsTitle() + "");


      owner.organizeText = organizeText;

      return organizeText;
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
     * Getter for videoBigIconImage called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Image get_videoBigIconImage() {
      return build_videoBigIconImage();
    }
    private com.google.gwt.user.client.ui.Image build_videoBigIconImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image videoBigIconImage = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      videoBigIconImage.setHeight("37");
      videoBigIconImage.setWidth("45");


      owner.videoBigIconImage = videoBigIconImage;

      return videoBigIconImage;
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
     * Getter for plusIconImage called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Image get_plusIconImage() {
      return build_plusIconImage();
    }
    private com.google.gwt.user.client.ui.Image build_plusIconImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image plusIconImage = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      plusIconImage.setStyleName("" + get_style().landingPageHelpOrganizePlusIcon() + "");
      plusIconImage.setHeight("18");
      plusIconImage.setWidth("18");


      owner.plusIconImage = plusIconImage;

      return plusIconImage;
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
     * Getter for textBookBigIconImage called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Image get_textBookBigIconImage() {
      return build_textBookBigIconImage();
    }
    private com.google.gwt.user.client.ui.Image build_textBookBigIconImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image textBookBigIconImage = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      textBookBigIconImage.setHeight("37");
      textBookBigIconImage.setWidth("45");


      owner.textBookBigIconImage = textBookBigIconImage;

      return textBookBigIconImage;
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
     * Getter for plusImage called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Image get_plusImage() {
      return build_plusImage();
    }
    private com.google.gwt.user.client.ui.Image build_plusImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image plusImage = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      plusImage.setStyleName("" + get_style().landingPageHelpOrganizePlusIcon() + "");
      plusImage.setHeight("18");
      plusImage.setWidth("18");


      owner.plusImage = plusImage;

      return plusImage;
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
     * Getter for domId17 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for topArrowImage called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Image get_topArrowImage() {
      return build_topArrowImage();
    }
    private com.google.gwt.user.client.ui.Image build_topArrowImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image topArrowImage = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      topArrowImage.setHeight("26");
      topArrowImage.setWidth("46");


      owner.topArrowImage = topArrowImage;

      return topArrowImage;
    }

    /**
     * Getter for domId17Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId18 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for smalllArrowImage called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Image get_smalllArrowImage() {
      return build_smalllArrowImage();
    }
    private com.google.gwt.user.client.ui.Image build_smalllArrowImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image smalllArrowImage = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      smalllArrowImage.setHeight("19");
      smalllArrowImage.setWidth("25");


      owner.smalllArrowImage = smalllArrowImage;

      return smalllArrowImage;
    }

    /**
     * Getter for domId18Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId19 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for lessonText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_lessonText() {
      return build_lessonText();
    }
    private com.google.gwt.user.client.ui.Label build_lessonText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lessonText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lessonText.setStyleName("" + get_style().landingPageLessionSmallTitle() + "");


      owner.lessonText = lessonText;

      return lessonText;
    }

    /**
     * Getter for domId19Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for saveResourceText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Anchor get_saveResourceText() {
      return build_saveResourceText();
    }
    private com.google.gwt.user.client.ui.Anchor build_saveResourceText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor saveResourceText = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      saveResourceText.setStyleName("" + get_style().textDecor() + "");
      saveResourceText.setTarget("_blank");


      owner.saveResourceText = saveResourceText;

      return saveResourceText;
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
     * Getter for narrationText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Anchor get_narrationText() {
      return build_narrationText();
    }
    private com.google.gwt.user.client.ui.Anchor build_narrationText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor narrationText = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      narrationText.setStyleName("" + get_style().textDecor() + "");
      narrationText.setTarget("_blank");


      owner.narrationText = narrationText;

      return narrationText;
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
     * Getter for collectionShareText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Anchor get_collectionShareText() {
      return build_collectionShareText();
    }
    private com.google.gwt.user.client.ui.Anchor build_collectionShareText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor collectionShareText = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      collectionShareText.setStyleName("" + get_style().textDecor() + "");
      collectionShareText.setTarget("_blank");


      owner.collectionShareText = collectionShareText;

      return collectionShareText;
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
     * Getter for seeMoreLabel called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Anchor get_seeMoreLabel() {
      return build_seeMoreLabel();
    }
    private com.google.gwt.user.client.ui.Anchor build_seeMoreLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor seeMoreLabel = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      seeMoreLabel.setStyleName("" + get_style().textDecor() + "");
      seeMoreLabel.setTarget("_blank");


      owner.seeMoreLabel = seeMoreLabel;

      return seeMoreLabel;
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
     * Getter for domId24 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for teachLbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_teachLbl() {
      return build_teachLbl();
    }
    private com.google.gwt.user.client.ui.Label build_teachLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label teachLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      teachLbl.setStyleName("" + get_style().landingPageDotsTitle() + "");


      owner.teachLbl = teachLbl;

      return teachLbl;
    }

    /**
     * Getter for domId24Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId25 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for teachLessonTitle called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_teachLessonTitle() {
      return build_teachLessonTitle();
    }
    private com.google.gwt.user.client.ui.Label build_teachLessonTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label teachLessonTitle = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      teachLessonTitle.setStyleName("" + get_style().lessionTitle() + "");


      owner.teachLessonTitle = teachLessonTitle;

      return teachLessonTitle;
    }

    /**
     * Getter for domId25Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId26 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for tLNo_ONE called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_tLNo_ONE() {
      return build_tLNo_ONE();
    }
    private com.google.gwt.user.client.ui.Label build_tLNo_ONE() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label tLNo_ONE = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      tLNo_ONE.setStyleName("" + get_style().landingPageHelpTeachLessoinNumberActive() + "");


      owner.tLNo_ONE = tLNo_ONE;

      return tLNo_ONE;
    }

    /**
     * Getter for domId26Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId27 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for thinkAboutText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_thinkAboutText() {
      return build_thinkAboutText();
    }
    private com.google.gwt.user.client.ui.Label build_thinkAboutText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label thinkAboutText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      thinkAboutText.setStyleName("" + get_style().landingPageHelpTeachLessoinTextActive() + "");


      owner.thinkAboutText = thinkAboutText;

      return thinkAboutText;
    }

    /**
     * Getter for domId27Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId28 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for tLNo_TWO called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_tLNo_TWO() {
      return build_tLNo_TWO();
    }
    private com.google.gwt.user.client.ui.Label build_tLNo_TWO() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label tLNo_TWO = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      tLNo_TWO.setStyleName("" + get_style().landingPageHelpTeachLessoinNumber() + "");


      owner.tLNo_TWO = tLNo_TWO;

      return tLNo_TWO;
    }

    /**
     * Getter for domId28Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId29 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for answerThisText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_answerThisText() {
      return build_answerThisText();
    }
    private com.google.gwt.user.client.ui.Label build_answerThisText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label answerThisText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      answerThisText.setStyleName("" + get_style().landingPageHelpTeachLessoinText() + "");


      owner.answerThisText = answerThisText;

      return answerThisText;
    }

    /**
     * Getter for domId29Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId30 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for howtoTeachText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Anchor get_howtoTeachText() {
      return build_howtoTeachText();
    }
    private com.google.gwt.user.client.ui.Anchor build_howtoTeachText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor howtoTeachText = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      howtoTeachText.setStyleName("" + get_style().textDecor() + "");
      howtoTeachText.setTarget("_blank");


      owner.howtoTeachText = howtoTeachText;

      return howtoTeachText;
    }

    /**
     * Getter for domId30Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId31 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for classPageText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Anchor get_classPageText() {
      return build_classPageText();
    }
    private com.google.gwt.user.client.ui.Anchor build_classPageText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor classPageText = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      classPageText.setStyleName("" + get_style().textDecor() + "");
      classPageText.setTarget("_blank");


      owner.classPageText = classPageText;

      return classPageText;
    }

    /**
     * Getter for domId31Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId32 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for shareClasspageText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Anchor get_shareClasspageText() {
      return build_shareClasspageText();
    }
    private com.google.gwt.user.client.ui.Anchor build_shareClasspageText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor shareClasspageText = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      shareClasspageText.setStyleName("" + get_style().textDecor() + "");
      shareClasspageText.setTarget("_blank");


      owner.shareClasspageText = shareClasspageText;

      return shareClasspageText;
    }

    /**
     * Getter for domId32Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for seeMoreTeachLbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Anchor get_seeMoreTeachLbl() {
      return build_seeMoreTeachLbl();
    }
    private com.google.gwt.user.client.ui.Anchor build_seeMoreTeachLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor seeMoreTeachLbl = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      seeMoreTeachLbl.setStyleName("" + get_style().textDecor() + "");
      seeMoreTeachLbl.setTarget("_blank");


      owner.seeMoreTeachLbl = seeMoreTeachLbl;

      return seeMoreTeachLbl;
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
     * Getter for domId34 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for studyLbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_studyLbl() {
      return build_studyLbl();
    }
    private com.google.gwt.user.client.ui.Label build_studyLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label studyLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      studyLbl.setStyleName("" + get_style().landingPageDotsStudyTitle() + "");


      owner.studyLbl = studyLbl;

      return studyLbl;
    }

    /**
     * Getter for domId34Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId35 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for studyImage called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Image get_studyImage() {
      return build_studyImage();
    }
    private com.google.gwt.user.client.ui.Image build_studyImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image studyImage = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      studyImage.setHeight("107");
      studyImage.setWidth("202");


      owner.studyImage = studyImage;

      return studyImage;
    }

    /**
     * Getter for domId35Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId36 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for startAssignmentText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Anchor get_startAssignmentText() {
      return build_startAssignmentText();
    }
    private com.google.gwt.user.client.ui.Anchor build_startAssignmentText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor startAssignmentText = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      startAssignmentText.setStyleName("" + get_style().textDecor() + "");
      startAssignmentText.setTarget("_blank");


      owner.startAssignmentText = startAssignmentText;

      return startAssignmentText;
    }

    /**
     * Getter for domId36Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId37 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for seemoreStudyLbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Anchor get_seemoreStudyLbl() {
      return build_seemoreStudyLbl();
    }
    private com.google.gwt.user.client.ui.Anchor build_seemoreStudyLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor seemoreStudyLbl = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      seemoreStudyLbl.setStyleName("" + get_style().textDecor() + "");
      seemoreStudyLbl.setTarget("_blank");


      owner.seemoreStudyLbl = seemoreStudyLbl;

      return seemoreStudyLbl;
    }

    /**
     * Getter for domId37Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId38 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for visitText called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_visitText() {
      return build_visitText();
    }
    private com.google.gwt.user.client.ui.Label build_visitText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label visitText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      visitText.setStyleName("" + get_style().supportLinkVist() + "");


      owner.visitText = visitText;

      return visitText;
    }

    /**
     * Getter for domId38Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
     * Getter for domId39 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 5.
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
     * Getter for supportCenterLbl called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Anchor get_supportCenterLbl() {
      return build_supportCenterLbl();
    }
    private com.google.gwt.user.client.ui.Anchor build_supportCenterLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor supportCenterLbl = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      supportCenterLbl.setStyleName("" + get_style().textDecor() + "");
      supportCenterLbl.setTarget("_blank");


      owner.supportCenterLbl = supportCenterLbl;

      return supportCenterLbl;
    }

    /**
     * Getter for domId39Element called 2 times. Type: DEFAULT. Build precedence: 5.
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
  }
}
