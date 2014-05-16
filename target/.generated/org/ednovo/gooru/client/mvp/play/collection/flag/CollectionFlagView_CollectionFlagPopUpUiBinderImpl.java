package org.ednovo.gooru.client.mvp.play.collection.flag;

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

public class CollectionFlagView_CollectionFlagPopUpUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagView>, org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagView.CollectionFlagPopUpUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span>")
    SafeHtml html1(String arg0);
     
    @Template("")
    SafeHtml html2();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html3(String arg0);
     
    @Template("")
    SafeHtml html4();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html5(String arg0);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html6(String arg0, String arg1);
     
    @Template("")
    SafeHtml html7();
     
    @Template("<div class='{0}'> <span id='{1}'></span> <div class='{2}'> <div class='{3}'> <span id='{4}'></span> <span id='{5}'></span> </div>    </div> <span id='{6}'></span> <div class='{7}'> <span id='{8}'></span> <span id='{9}'></span> </div> <div class='{10}'> <span id='{11}'></span> <span id='{12}'></span> </div> <div class='{13}'> <span id='{14}'></span> <span id='{15}'></span> </div>  <div class='{16}'> <span id='{17}'></span> <span id='{18}'></span> </div> <span id='{19}'></span> <span id='{20}'></span>  </div>")
    SafeHtml html8(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15, String arg16, String arg17, String arg18, String arg19, String arg20);
     
    @Template("<div class='{0}'> <span id='{1}'></span> <div class='{2}'> <span id='{3}'></span> <span id='{4}'></span> </div> <div class='{5}'> <span id='{6}'></span> <span id='{7}'></span> </div> <div class='{8}'> <span id='{9}'></span> <span id='{10}'></span> </div> <div class='{11}'> <span id='{12}'></span> <span id='{13}'></span> </div> <span id='{14}'></span> <span id='{15}'></span>  </div>")
    SafeHtml html9(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15);
     
    @Template("")
    SafeHtml html10();
     
    @Template("")
    SafeHtml html11();
     
    @Template("")
    SafeHtml html12();
     
    @Template("<div class='{0}'> <div class='{1}'> <div class='{2}'> <span id='{3}'></span> <span id='{4}'></span> </div> <span id='{5}'></span>  <span id='{6}'></span>  <span id='{7}'></span> <div class='{8}'> <span id='{9}'></span> <span id='{10}'></span> <span id='{11}'></span> </div>  </div> </div>")
    SafeHtml html13(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagView owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagView owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickOfCollectionCancelButton(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickOfcollectionCheckBox1(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickOfcollectionCheckBox2(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickOfcollectionCheckBox3(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickOfcollectionCheckBox4(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickOfresourceCheckBox1(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickOfresourceCheckBox2(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickOfresourceCheckBox3(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames9 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickOfresourceCheckBox4(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames10 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickOfflagCollections(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames11 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickOfflagResources(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames12 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.onClickOfcollectionSubmitButton(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagView owner) {
      this.owner = owner;
      build_flagPopUpstyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId9();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId10();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId11();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId12();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId13();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId14();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId15();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId16();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId17();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId18();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId19();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId20();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId21();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId22();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId24();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId25();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId26();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId27();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId28();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId29();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId30();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId31();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId32();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId33();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId34();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId8();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId23();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId35();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId36();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId37();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId9Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId10Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId11Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId12Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId13Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId14Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId15Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId16Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId17Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId18Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId19Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId20Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId21Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId22Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId24Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId25Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId26Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId27Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId28Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId29Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId30Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId31Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId32Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId33Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId34Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId8Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId23Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId35Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId36Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
      build_domId37Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1(get_domId2());
    }
    SafeHtml template_html2() {
      return template.html2();
    }
    SafeHtml template_html3() {
      return template.html3(get_domId5());
    }
    SafeHtml template_html4() {
      return template.html4();
    }
    SafeHtml template_html5() {
      return template.html5(get_domId7());
    }
    SafeHtml template_html6() {
      return template.html6(get_domId4(), get_domId6());
    }
    SafeHtml template_html7() {
      return template.html7();
    }
    SafeHtml template_html8() {
      return template.html8("" + get_flagPopUpstyle().playerflagcollectionresourcescontentcontainer() + "", get_domId9(), "" + get_flagPopUpstyle().leftalign() + "", "" + get_flagPopUpstyle().collectionPlayerExistingCollectionInputContainer() + "", get_domId10(), get_domId11(), get_domId12(), "" + get_flagPopUpstyle().playerflagradiobutton() + "", get_domId13(), get_domId14(), "" + get_flagPopUpstyle().playerflagradiobutton() + "", get_domId15(), get_domId16(), "" + get_flagPopUpstyle().playerflagradiobutton() + "", get_domId17(), get_domId18(), "" + get_flagPopUpstyle().playerflagradiobutton() + "", get_domId19(), get_domId20(), get_domId21(), get_domId22());
    }
    SafeHtml template_html9() {
      return template.html9("" + get_flagPopUpstyle().playerflagcollectionresourcescontentcontainer() + "", get_domId24(), "" + get_flagPopUpstyle().playerflagradiobutton() + "", get_domId25(), get_domId26(), "" + get_flagPopUpstyle().playerflagradiobutton() + "", get_domId27(), get_domId28(), "" + get_flagPopUpstyle().playerflagradiobutton() + "", get_domId29(), get_domId30(), "" + get_flagPopUpstyle().playerflagradiobutton() + "", get_domId31(), get_domId32(), get_domId33(), get_domId34());
    }
    SafeHtml template_html10() {
      return template.html10();
    }
    SafeHtml template_html11() {
      return template.html11();
    }
    SafeHtml template_html12() {
      return template.html12();
    }
    SafeHtml template_html13() {
      return template.html13("" + get_flagPopUpstyle().endedquestionwrapper() + "", "" + get_flagPopUpstyle().flagresourcesinnerwrapper() + "", "" + get_flagPopUpstyle().endedquestionheader() + "", get_domId0(), get_domId1(), get_domId3(), get_domId8(), get_domId23(), "" + get_flagPopUpstyle().playerflagbuttoncontainer() + "", get_domId35(), get_domId36(), get_domId37());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagView_CollectionFlagPopUpUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagView_CollectionFlagPopUpUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagView_CollectionFlagPopUpUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagView_CollectionFlagPopUpUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagView_CollectionFlagPopUpUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for flagPopUpstyle called 52 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagView_CollectionFlagPopUpUiBinderImpl_GenCss_flagPopUpstyle flagPopUpstyle;
    private org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagView_CollectionFlagPopUpUiBinderImpl_GenCss_flagPopUpstyle get_flagPopUpstyle() {
      return flagPopUpstyle;
    }
    private org.ednovo.gooru.client.mvp.play.collection.flag.CollectionFlagView_CollectionFlagPopUpUiBinderImpl_GenCss_flagPopUpstyle build_flagPopUpstyle() {
      // Creation section.
      flagPopUpstyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().flagPopUpstyle();
      // Setup section.
      flagPopUpstyle.ensureInjected();


      return flagPopUpstyle;
    }

    /**
     * Getter for flagBundleCss called 0 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.player.collection.client.view.add.tooltip.FlagBundle get_flagBundleCss() {
      return build_flagBundleCss();
    }
    private org.ednovo.gooru.player.collection.client.view.add.tooltip.FlagBundle build_flagBundleCss() {
      // Creation section.
      final org.ednovo.gooru.player.collection.client.view.add.tooltip.FlagBundle flagBundleCss = (org.ednovo.gooru.player.collection.client.view.add.tooltip.FlagBundle) GWT.create(org.ednovo.gooru.player.collection.client.view.add.tooltip.FlagBundle.class);
      // Setup section.


      return flagBundleCss;
    }

    /**
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html13().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1616 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId0Element().get();
      get_domId1Element().get();
      get_domId3Element().get();
      get_domId8Element().get();
      get_domId23Element().get();
      get_domId35Element().get();
      get_domId36Element().get();
      get_domId37Element().get();

      // Detach section.
      attachRecord1616.detach();
      f_HTMLPanel1.addAndReplaceElement(get_headerflagtext(), get_domId0Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_closeButton(), get_domId1Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_flagresourceleftpart(), get_domId3Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_resourceFlagContainer(), get_domId8Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_collectionFlagContainer(), get_domId23Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_collectionCancelButton(), get_domId35Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_collectionSubmitButton(), get_domId36Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_submitButtonGray(), get_domId37Element().get());

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
     * Getter for headerflagtext called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Label get_headerflagtext() {
      return build_headerflagtext();
    }
    private com.google.gwt.user.client.ui.Label build_headerflagtext() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label headerflagtext = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      headerflagtext.setStyleName("" + get_flagPopUpstyle().endedquestionheaderflagtext() + "");


      owner.headerflagtext = headerflagtext;

      return headerflagtext;
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
     * Getter for closeButton called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_closeButton() {
      return build_closeButton();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_closeButton() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel closeButton = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html1().asString());
      // Setup section.
      closeButton.setStyleName("" + get_flagPopUpstyle().playerflagpopupheaderCloseBtn() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1617 = UiBinderUtil.attachToDom(closeButton.getElement());
      get_domId2Element().get();

      // Detach section.
      attachRecord1617.detach();
      closeButton.addAndReplaceElement(get_popUpCloseButton(), get_domId2Element().get());

      return closeButton;
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
     * Getter for popUpCloseButton called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Image get_popUpCloseButton() {
      return build_popUpCloseButton();
    }
    private com.google.gwt.user.client.ui.Image build_popUpCloseButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image popUpCloseButton = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.


      owner.popUpCloseButton = popUpCloseButton;

      return popUpCloseButton;
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

    /**
     * Getter for domId3 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for flagresourceleftpart called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_flagresourceleftpart() {
      return build_flagresourceleftpart();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_flagresourceleftpart() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel flagresourceleftpart = new com.google.gwt.user.client.ui.HTMLPanel(template_html6().asString());
      // Setup section.
      flagresourceleftpart.setStyleName("" + get_flagPopUpstyle().flagresourceleftpart() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1618 = UiBinderUtil.attachToDom(flagresourceleftpart.getElement());
      get_domId4Element().get();
      get_domId6Element().get();

      // Detach section.
      attachRecord1618.detach();
      flagresourceleftpart.addAndReplaceElement(get_flagCollections(), get_domId4Element().get());
      flagresourceleftpart.addAndReplaceElement(get_flagResources(), get_domId6Element().get());

      return flagresourceleftpart;
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
     * Getter for flagCollections called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_flagCollections() {
      return build_flagCollections();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_flagCollections() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel flagCollections = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html3().asString());
      // Setup section.
      flagCollections.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames10);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1619 = UiBinderUtil.attachToDom(flagCollections.getElement());
      get_domId5Element().get();

      // Detach section.
      attachRecord1619.detach();
      flagCollections.addAndReplaceElement(get_flagCollectionText(), get_domId5Element().get());

      owner.flagCollections = flagCollections;

      return flagCollections;
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
     * Getter for flagCollectionText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_flagCollectionText() {
      return build_flagCollectionText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_flagCollectionText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel flagCollectionText = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      flagCollectionText.setStyleName("" + get_flagPopUpstyle().flagresourcenmenutext() + "");


      owner.flagCollectionText = flagCollectionText;

      return flagCollectionText;
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
     * Getter for domId6 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for flagResources called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_flagResources() {
      return build_flagResources();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_flagResources() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel flagResources = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html5().asString());
      // Setup section.
      flagResources.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames11);

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1620 = UiBinderUtil.attachToDom(flagResources.getElement());
      get_domId7Element().get();

      // Detach section.
      attachRecord1620.detach();
      flagResources.addAndReplaceElement(get_flagResourceText(), get_domId7Element().get());

      owner.flagResources = flagResources;

      return flagResources;
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
     * Getter for flagResourceText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_flagResourceText() {
      return build_flagResourceText();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_flagResourceText() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel flagResourceText = new com.google.gwt.user.client.ui.HTMLPanel(template_html4().asString());
      // Setup section.
      flagResourceText.setStyleName("" + get_flagPopUpstyle().flagresourcenmenutext() + "");


      owner.flagResourceText = flagResourceText;

      return flagResourceText;
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
     * Getter for domId6Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId3Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
     * Getter for domId8 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for resourceFlagContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_resourceFlagContainer() {
      return build_resourceFlagContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_resourceFlagContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel resourceFlagContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html8().asString());
      // Setup section.
      resourceFlagContainer.setStyleName("" + get_flagPopUpstyle().endedquestionrightpart() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1621 = UiBinderUtil.attachToDom(resourceFlagContainer.getElement());
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

      // Detach section.
      attachRecord1621.detach();
      resourceFlagContainer.addAndReplaceElement(get_chooseResourceText(), get_domId9Element().get());
      resourceFlagContainer.addAndReplaceElement(get_dropdownListPlaceHolder(), get_domId10Element().get());
      resourceFlagContainer.addAndReplaceElement(get_dropdownListContainerScrollPanel(), get_domId11Element().get());
      resourceFlagContainer.addAndReplaceElement(get_becauseText(), get_domId12Element().get());
      resourceFlagContainer.addAndReplaceElement(get_resourceCheckBox3(), get_domId13Element().get());
      resourceFlagContainer.addAndReplaceElement(get_incorporateresourceText(), get_domId14Element().get());
      resourceFlagContainer.addAndReplaceElement(get_resourceCheckBox2(), get_domId15Element().get());
      resourceFlagContainer.addAndReplaceElement(get_unavailableresourceText(), get_domId16Element().get());
      resourceFlagContainer.addAndReplaceElement(get_resourceCheckBox1(), get_domId17Element().get());
      resourceFlagContainer.addAndReplaceElement(get_inaccurateTextresource(), get_domId18Element().get());
      resourceFlagContainer.addAndReplaceElement(get_resourceCheckBox4(), get_domId19Element().get());
      resourceFlagContainer.addAndReplaceElement(get_otherReason(), get_domId20Element().get());
      resourceFlagContainer.addAndReplaceElement(get_provideMore(), get_domId21Element().get());
      resourceFlagContainer.addAndReplaceElement(get_resourceDescTextArea(), get_domId22Element().get());

      owner.resourceFlagContainer = resourceFlagContainer;

      return resourceFlagContainer;
    }

    /**
     * Getter for domId9 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for chooseResourceText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_chooseResourceText() {
      return build_chooseResourceText();
    }
    private com.google.gwt.user.client.ui.Label build_chooseResourceText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label chooseResourceText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      chooseResourceText.setStyleName("" + get_flagPopUpstyle().playerflagcontentChooseResource() + "");


      owner.chooseResourceText = chooseResourceText;

      return chooseResourceText;
    }

    /**
     * Getter for domId9Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId10 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for dropdownListPlaceHolder called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTML get_dropdownListPlaceHolder() {
      return build_dropdownListPlaceHolder();
    }
    private com.google.gwt.user.client.ui.HTML build_dropdownListPlaceHolder() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML dropdownListPlaceHolder = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      dropdownListPlaceHolder.setStyleName("" + get_flagPopUpstyle().dropdownListPlaceHolder() + "");


      owner.dropdownListPlaceHolder = dropdownListPlaceHolder;

      return dropdownListPlaceHolder;
    }

    /**
     * Getter for domId10Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId11 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for dropdownListContainerScrollPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.ScrollPanel get_dropdownListContainerScrollPanel() {
      return build_dropdownListContainerScrollPanel();
    }
    private com.google.gwt.user.client.ui.ScrollPanel build_dropdownListContainerScrollPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.ScrollPanel dropdownListContainerScrollPanel = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
      // Setup section.
      dropdownListContainerScrollPanel.add(get_dropdownListContainer());
      dropdownListContainerScrollPanel.setStyleName("" + get_flagPopUpstyle().dropdownListContainerScrollPanel() + "");


      owner.dropdownListContainerScrollPanel = dropdownListContainerScrollPanel;

      return dropdownListContainerScrollPanel;
    }

    /**
     * Getter for dropdownListContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_dropdownListContainer() {
      return build_dropdownListContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_dropdownListContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel dropdownListContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html7().asString());
      // Setup section.
      dropdownListContainer.setStyleName("" + get_flagPopUpstyle().dropdownListContainer() + "");


      owner.dropdownListContainer = dropdownListContainer;

      return dropdownListContainer;
    }

    /**
     * Getter for domId11Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId12 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for becauseText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_becauseText() {
      return build_becauseText();
    }
    private com.google.gwt.user.client.ui.Label build_becauseText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label becauseText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      becauseText.setStyleName("" + get_flagPopUpstyle().playerflagcontentTextdescription() + "");


      owner.becauseText = becauseText;

      return becauseText;
    }

    /**
     * Getter for domId12Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId13 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for resourceCheckBox3 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.CheckBox get_resourceCheckBox3() {
      return build_resourceCheckBox3();
    }
    private com.google.gwt.user.client.ui.CheckBox build_resourceCheckBox3() {
      // Creation section.
      final com.google.gwt.user.client.ui.CheckBox resourceCheckBox3 = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
      // Setup section.
      resourceCheckBox3.setStyleName("" + get_flagPopUpstyle().ckeckBoxPlyerStyle() + "");
      resourceCheckBox3.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames8);


      owner.resourceCheckBox3 = resourceCheckBox3;

      return resourceCheckBox3;
    }

    /**
     * Getter for domId13Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId14 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for incorporateresourceText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_incorporateresourceText() {
      return build_incorporateresourceText();
    }
    private com.google.gwt.user.client.ui.Label build_incorporateresourceText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label incorporateresourceText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      incorporateresourceText.setStyleName("" + get_flagPopUpstyle().playerflagcontent() + "");


      owner.incorporateresourceText = incorporateresourceText;

      return incorporateresourceText;
    }

    /**
     * Getter for domId14Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId15 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for resourceCheckBox2 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.CheckBox get_resourceCheckBox2() {
      return build_resourceCheckBox2();
    }
    private com.google.gwt.user.client.ui.CheckBox build_resourceCheckBox2() {
      // Creation section.
      final com.google.gwt.user.client.ui.CheckBox resourceCheckBox2 = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
      // Setup section.
      resourceCheckBox2.setStyleName("" + get_flagPopUpstyle().ckeckBoxPlyerStyle() + "");
      resourceCheckBox2.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames7);


      owner.resourceCheckBox2 = resourceCheckBox2;

      return resourceCheckBox2;
    }

    /**
     * Getter for domId15Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId16 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for unavailableresourceText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_unavailableresourceText() {
      return build_unavailableresourceText();
    }
    private com.google.gwt.user.client.ui.Label build_unavailableresourceText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label unavailableresourceText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      unavailableresourceText.setStyleName("" + get_flagPopUpstyle().playerflagcontent() + "");


      owner.unavailableresourceText = unavailableresourceText;

      return unavailableresourceText;
    }

    /**
     * Getter for domId16Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId17 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for resourceCheckBox1 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.CheckBox get_resourceCheckBox1() {
      return build_resourceCheckBox1();
    }
    private com.google.gwt.user.client.ui.CheckBox build_resourceCheckBox1() {
      // Creation section.
      final com.google.gwt.user.client.ui.CheckBox resourceCheckBox1 = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
      // Setup section.
      resourceCheckBox1.setStyleName("" + get_flagPopUpstyle().ckeckBoxPlyerStyle() + "");
      resourceCheckBox1.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames6);


      owner.resourceCheckBox1 = resourceCheckBox1;

      return resourceCheckBox1;
    }

    /**
     * Getter for domId17Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId18 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for inaccurateTextresource called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_inaccurateTextresource() {
      return build_inaccurateTextresource();
    }
    private com.google.gwt.user.client.ui.Label build_inaccurateTextresource() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label inaccurateTextresource = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      inaccurateTextresource.setStyleName("" + get_flagPopUpstyle().playerflagcontent() + "");


      owner.inaccurateTextresource = inaccurateTextresource;

      return inaccurateTextresource;
    }

    /**
     * Getter for domId18Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId19 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for resourceCheckBox4 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.CheckBox get_resourceCheckBox4() {
      return build_resourceCheckBox4();
    }
    private com.google.gwt.user.client.ui.CheckBox build_resourceCheckBox4() {
      // Creation section.
      final com.google.gwt.user.client.ui.CheckBox resourceCheckBox4 = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
      // Setup section.
      resourceCheckBox4.setStyleName("" + get_flagPopUpstyle().ckeckBoxPlyerStyle() + "");
      resourceCheckBox4.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames9);


      owner.resourceCheckBox4 = resourceCheckBox4;

      return resourceCheckBox4;
    }

    /**
     * Getter for domId19Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId20 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for otherReason called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_otherReason() {
      return build_otherReason();
    }
    private com.google.gwt.user.client.ui.Label build_otherReason() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label otherReason = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      otherReason.setStyleName("" + get_flagPopUpstyle().playerflagcontent() + "");


      owner.otherReason = otherReason;

      return otherReason;
    }

    /**
     * Getter for domId20Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId21 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for provideMore called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_provideMore() {
      return build_provideMore();
    }
    private com.google.gwt.user.client.ui.Label build_provideMore() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label provideMore = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      provideMore.setStyleName("" + get_flagPopUpstyle().playerflagcontentTextCollectiondescription() + "");


      owner.provideMore = provideMore;

      return provideMore;
    }

    /**
     * Getter for domId21Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId22 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for resourceDescTextArea called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.TextArea get_resourceDescTextArea() {
      return build_resourceDescTextArea();
    }
    private com.google.gwt.user.client.ui.TextArea build_resourceDescTextArea() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextArea resourceDescTextArea = (com.google.gwt.user.client.ui.TextArea) GWT.create(com.google.gwt.user.client.ui.TextArea.class);
      // Setup section.
      resourceDescTextArea.setStyleName("" + get_flagPopUpstyle().playerflagtextarea() + "");


      owner.resourceDescTextArea = resourceDescTextArea;

      return resourceDescTextArea;
    }

    /**
     * Getter for domId22Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId8Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
     * Getter for domId23 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for collectionFlagContainer called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_collectionFlagContainer() {
      return build_collectionFlagContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_collectionFlagContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel collectionFlagContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html9().asString());
      // Setup section.
      collectionFlagContainer.setStyleName("" + get_flagPopUpstyle().endedquestionrightpart() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1622 = UiBinderUtil.attachToDom(collectionFlagContainer.getElement());
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

      // Detach section.
      attachRecord1622.detach();
      collectionFlagContainer.addAndReplaceElement(get_collectionTitleField(), get_domId24Element().get());
      collectionFlagContainer.addAndReplaceElement(get_collectionCheckBox1(), get_domId25Element().get());
      collectionFlagContainer.addAndReplaceElement(get_incorporateText(), get_domId26Element().get());
      collectionFlagContainer.addAndReplaceElement(get_collectionCheckBox2(), get_domId27Element().get());
      collectionFlagContainer.addAndReplaceElement(get_notAppropriateText(), get_domId28Element().get());
      collectionFlagContainer.addAndReplaceElement(get_collectionCheckBox3(), get_domId29Element().get());
      collectionFlagContainer.addAndReplaceElement(get_inaccurateText(), get_domId30Element().get());
      collectionFlagContainer.addAndReplaceElement(get_collectionCheckBox4(), get_domId31Element().get());
      collectionFlagContainer.addAndReplaceElement(get_otherReasonText(), get_domId32Element().get());
      collectionFlagContainer.addAndReplaceElement(get_provideMoreDetails(), get_domId33Element().get());
      collectionFlagContainer.addAndReplaceElement(get_collectionDescTextArea(), get_domId34Element().get());

      owner.collectionFlagContainer = collectionFlagContainer;

      return collectionFlagContainer;
    }

    /**
     * Getter for domId24 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for collectionTitleField called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTML get_collectionTitleField() {
      return build_collectionTitleField();
    }
    private com.google.gwt.user.client.ui.HTML build_collectionTitleField() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML collectionTitleField = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      collectionTitleField.setStyleName("" + get_flagPopUpstyle().playerflagcontentTextdescription() + "");


      owner.collectionTitleField = collectionTitleField;

      return collectionTitleField;
    }

    /**
     * Getter for domId24Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId25 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for collectionCheckBox1 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.CheckBox get_collectionCheckBox1() {
      return build_collectionCheckBox1();
    }
    private com.google.gwt.user.client.ui.CheckBox build_collectionCheckBox1() {
      // Creation section.
      final com.google.gwt.user.client.ui.CheckBox collectionCheckBox1 = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
      // Setup section.
      collectionCheckBox1.setStyleName("" + get_flagPopUpstyle().ckeckBoxPlyerStyle() + "");
      collectionCheckBox1.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.collectionCheckBox1 = collectionCheckBox1;

      return collectionCheckBox1;
    }

    /**
     * Getter for domId25Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for incorporateText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_incorporateText() {
      return build_incorporateText();
    }
    private com.google.gwt.user.client.ui.Label build_incorporateText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label incorporateText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      incorporateText.setStyleName("" + get_flagPopUpstyle().playerflagcontent() + "");


      owner.incorporateText = incorporateText;

      return incorporateText;
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
     * Getter for domId27 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for collectionCheckBox2 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.CheckBox get_collectionCheckBox2() {
      return build_collectionCheckBox2();
    }
    private com.google.gwt.user.client.ui.CheckBox build_collectionCheckBox2() {
      // Creation section.
      final com.google.gwt.user.client.ui.CheckBox collectionCheckBox2 = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
      // Setup section.
      collectionCheckBox2.setStyleName("" + get_flagPopUpstyle().ckeckBoxPlyerStyle() + "");
      collectionCheckBox2.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);


      owner.collectionCheckBox2 = collectionCheckBox2;

      return collectionCheckBox2;
    }

    /**
     * Getter for domId27Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId28 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for notAppropriateText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_notAppropriateText() {
      return build_notAppropriateText();
    }
    private com.google.gwt.user.client.ui.Label build_notAppropriateText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label notAppropriateText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      notAppropriateText.setStyleName("" + get_flagPopUpstyle().playerflagcontent() + "");


      owner.notAppropriateText = notAppropriateText;

      return notAppropriateText;
    }

    /**
     * Getter for domId28Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId29 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for collectionCheckBox3 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.CheckBox get_collectionCheckBox3() {
      return build_collectionCheckBox3();
    }
    private com.google.gwt.user.client.ui.CheckBox build_collectionCheckBox3() {
      // Creation section.
      final com.google.gwt.user.client.ui.CheckBox collectionCheckBox3 = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
      // Setup section.
      collectionCheckBox3.setStyleName("" + get_flagPopUpstyle().ckeckBoxPlyerStyle() + "");
      collectionCheckBox3.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);


      owner.collectionCheckBox3 = collectionCheckBox3;

      return collectionCheckBox3;
    }

    /**
     * Getter for domId29Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId30 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for inaccurateText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_inaccurateText() {
      return build_inaccurateText();
    }
    private com.google.gwt.user.client.ui.Label build_inaccurateText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label inaccurateText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      inaccurateText.setStyleName("" + get_flagPopUpstyle().playerflagcontent() + "");


      owner.inaccurateText = inaccurateText;

      return inaccurateText;
    }

    /**
     * Getter for domId30Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId31 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for collectionCheckBox4 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.CheckBox get_collectionCheckBox4() {
      return build_collectionCheckBox4();
    }
    private com.google.gwt.user.client.ui.CheckBox build_collectionCheckBox4() {
      // Creation section.
      final com.google.gwt.user.client.ui.CheckBox collectionCheckBox4 = (com.google.gwt.user.client.ui.CheckBox) GWT.create(com.google.gwt.user.client.ui.CheckBox.class);
      // Setup section.
      collectionCheckBox4.setStyleName("" + get_flagPopUpstyle().ckeckBoxPlyerStyle() + "");
      collectionCheckBox4.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames5);


      owner.collectionCheckBox4 = collectionCheckBox4;

      return collectionCheckBox4;
    }

    /**
     * Getter for domId31Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId32 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for otherReasonText called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_otherReasonText() {
      return build_otherReasonText();
    }
    private com.google.gwt.user.client.ui.Label build_otherReasonText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label otherReasonText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      otherReasonText.setStyleName("" + get_flagPopUpstyle().playerflagcontent() + "");


      owner.otherReasonText = otherReasonText;

      return otherReasonText;
    }

    /**
     * Getter for domId32Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId33 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for provideMoreDetails called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_provideMoreDetails() {
      return build_provideMoreDetails();
    }
    private com.google.gwt.user.client.ui.Label build_provideMoreDetails() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label provideMoreDetails = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      provideMoreDetails.setStyleName("" + get_flagPopUpstyle().playerflagcontentTextCollectiondescription() + "");


      owner.provideMoreDetails = provideMoreDetails;

      return provideMoreDetails;
    }

    /**
     * Getter for domId33Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId34 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for collectionDescTextArea called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.TextArea get_collectionDescTextArea() {
      return build_collectionDescTextArea();
    }
    private com.google.gwt.user.client.ui.TextArea build_collectionDescTextArea() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextArea collectionDescTextArea = (com.google.gwt.user.client.ui.TextArea) GWT.create(com.google.gwt.user.client.ui.TextArea.class);
      // Setup section.
      collectionDescTextArea.setStyleName("" + get_flagPopUpstyle().playerflagtextarea() + "");


      owner.collectionDescTextArea = collectionDescTextArea;

      return collectionDescTextArea;
    }

    /**
     * Getter for domId34Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
     * Getter for domId23Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
     * Getter for domId35 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for collectionCancelButton called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_collectionCancelButton() {
      return build_collectionCancelButton();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_collectionCancelButton() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel collectionCancelButton = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html10().asString());
      // Setup section.
      collectionCancelButton.setStyleName("" + get_flagPopUpstyle().playerflagbuttoncancel() + "");
      collectionCancelButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.collectionCancelButton = collectionCancelButton;

      return collectionCancelButton;
    }

    /**
     * Getter for domId35Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
     * Getter for domId36 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for collectionSubmitButton called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_collectionSubmitButton() {
      return build_collectionSubmitButton();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_collectionSubmitButton() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel collectionSubmitButton = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html11().asString());
      // Setup section.
      collectionSubmitButton.setStyleName("" + get_flagPopUpstyle().playerflagbuttonsubmit() + "");
      collectionSubmitButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames12);


      owner.collectionSubmitButton = collectionSubmitButton;

      return collectionSubmitButton;
    }

    /**
     * Getter for domId36Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
     * Getter for domId37 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
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
     * Getter for submitButtonGray called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.uc.HTMLEventPanel get_submitButtonGray() {
      return build_submitButtonGray();
    }
    private org.ednovo.gooru.client.uc.HTMLEventPanel build_submitButtonGray() {
      // Creation section.
      final org.ednovo.gooru.client.uc.HTMLEventPanel submitButtonGray = new org.ednovo.gooru.client.uc.HTMLEventPanel(template_html12().asString());
      // Setup section.
      submitButtonGray.setStyleName("" + get_flagPopUpstyle().playerflagbuttoncancelGray() + "");


      owner.submitButtonGray = submitButtonGray;

      return submitButtonGray;
    }

    /**
     * Getter for domId37Element called 2 times. Type: DEFAULT. Build precedence: 2.
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
  }
}
