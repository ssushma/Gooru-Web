package org.ednovo.gooru.client.uc.tooltip;

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

public class StudyNowToolTip_StudyNowToolTipUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.uc.tooltip.StudyNowToolTip>, org.ednovo.gooru.client.uc.tooltip.StudyNowToolTip.StudyNowToolTipUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html1(String arg0, String arg1, String arg2, String arg3);
     
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span>")
    SafeHtml html2(String arg0, String arg1, String arg2);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html3(String arg0);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.uc.tooltip.StudyNowToolTip owner) {


    return new Widgets(owner).get_panelCode();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.uc.tooltip.StudyNowToolTip owner;


    public Widgets(final org.ednovo.gooru.client.uc.tooltip.StudyNowToolTip owner) {
      this.owner = owner;
      build_toolTip();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId5();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId6();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId7();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId5Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId6Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId7Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1(get_domId2(), get_domId3(), get_domId4(), get_domId5());
    }
    SafeHtml template_html2() {
      return template.html2(get_domId1(), get_domId6(), get_domId7());
    }
    SafeHtml template_html3() {
      return template.html3(get_domId0());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.tooltip.StudyNowToolTip_StudyNowToolTipUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.uc.tooltip.StudyNowToolTip_StudyNowToolTipUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.uc.tooltip.StudyNowToolTip_StudyNowToolTipUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.uc.tooltip.StudyNowToolTip_StudyNowToolTipUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.uc.tooltip.StudyNowToolTip_StudyNowToolTipUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for toolTip called 5 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.uc.tooltip.StudyNowToolTip_StudyNowToolTipUiBinderImpl_GenCss_toolTip toolTip;
    private org.ednovo.gooru.client.uc.tooltip.StudyNowToolTip_StudyNowToolTipUiBinderImpl_GenCss_toolTip get_toolTip() {
      return toolTip;
    }
    private org.ednovo.gooru.client.uc.tooltip.StudyNowToolTip_StudyNowToolTipUiBinderImpl_GenCss_toolTip build_toolTip() {
      // Creation section.
      toolTip = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().toolTip();
      // Setup section.
      toolTip.ensureInjected();


      return toolTip;
    }

    /**
     * Getter for res called 2 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.classpages.ClasspageListPopupViewCBundle res;
    private org.ednovo.gooru.client.mvp.classpages.ClasspageListPopupViewCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.mvp.classpages.ClasspageListPopupViewCBundle build_res() {
      // Creation section.
      res = (org.ednovo.gooru.client.mvp.classpages.ClasspageListPopupViewCBundle) GWT.create(org.ednovo.gooru.client.mvp.classpages.ClasspageListPopupViewCBundle.class);
      // Setup section.


      return res;
    }

    /**
     * Getter for panelCode called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelCode() {
      return build_panelCode();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelCode() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelCode = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      panelCode.setStyleName("" + get_toolTip().tooltipContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1223 = UiBinderUtil.attachToDom(panelCode.getElement());
      get_domId0Element().get();

      // Detach section.
      attachRecord1223.detach();
      panelCode.addAndReplaceElement(get_tooltipPanel(), get_domId0Element().get());

      return panelCode;
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
     * Getter for tooltipPanel called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_tooltipPanel() {
      return build_tooltipPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_tooltipPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel tooltipPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      tooltipPanel.setStyleName("" + get_toolTip().studyTooltipContent() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1224 = UiBinderUtil.attachToDom(tooltipPanel.getElement());
      get_domId1Element().get();
      get_domId6Element().get();
      get_domId7Element().get();

      // Detach section.
      attachRecord1224.detach();
      tooltipPanel.addAndReplaceElement(get_f_HTMLPanel1(), get_domId1Element().get());
      tooltipPanel.addAndReplaceElement(get_lblLoading(), get_domId6Element().get());
      tooltipPanel.addAndReplaceElement(get_spanelCollectionList(), get_domId7Element().get());

      owner.tooltipPanel = tooltipPanel;

      return tooltipPanel;
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
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      f_HTMLPanel1.setStyleName("" + get_toolTip().inputContainer() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1225 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId2Element().get();
      get_domId3Element().get();
      get_domId4Element().get();
      get_domId5Element().get();

      // Detach section.
      attachRecord1225.detach();
      f_HTMLPanel1.addAndReplaceElement(get_lblTitle(), get_domId2Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_classCodeTxtBox(), get_domId3Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_enterLbl(), get_domId4Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_disabledBtn(), get_domId5Element().get());

      return f_HTMLPanel1;
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
     * Getter for lblTitle called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_lblTitle() {
      return build_lblTitle();
    }
    private com.google.gwt.user.client.ui.Label build_lblTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblTitle = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblTitle.setStyleName("" + get_toolTip().tooltipContentTitle() + "");


      owner.lblTitle = lblTitle;

      return lblTitle;
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
     * Getter for classCodeTxtBox called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private org.ednovo.gooru.client.uc.TextBoxWithPlaceholder get_classCodeTxtBox() {
      return build_classCodeTxtBox();
    }
    private org.ednovo.gooru.client.uc.TextBoxWithPlaceholder build_classCodeTxtBox() {
      // Creation section.
      final org.ednovo.gooru.client.uc.TextBoxWithPlaceholder classCodeTxtBox = (org.ednovo.gooru.client.uc.TextBoxWithPlaceholder) GWT.create(org.ednovo.gooru.client.uc.TextBoxWithPlaceholder.class);
      // Setup section.
      classCodeTxtBox.setStyleName("" + get_toolTip().classCodeTxtBox() + "");


      owner.classCodeTxtBox = classCodeTxtBox;

      return classCodeTxtBox;
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
     * Getter for enterLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Button get_enterLbl() {
      return build_enterLbl();
    }
    private com.google.gwt.user.client.ui.Button build_enterLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button enterLbl = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      enterLbl.setStyleName("primary");


      owner.enterLbl = enterLbl;

      return enterLbl;
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
     * Getter for disabledBtn called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Button get_disabledBtn() {
      return build_disabledBtn();
    }
    private com.google.gwt.user.client.ui.Button build_disabledBtn() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button disabledBtn = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      disabledBtn.setStyleName("primary disabled");


      owner.disabledBtn = disabledBtn;

      return disabledBtn;
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
     * Getter for lblLoading called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_lblLoading() {
      return build_lblLoading();
    }
    private com.google.gwt.user.client.ui.Label build_lblLoading() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblLoading = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.


      owner.lblLoading = lblLoading;

      return lblLoading;
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
     * Getter for domId7 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 3.
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
     * Getter for spanelCollectionList called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.ScrollPanel get_spanelCollectionList() {
      return build_spanelCollectionList();
    }
    private com.google.gwt.user.client.ui.ScrollPanel build_spanelCollectionList() {
      // Creation section.
      final com.google.gwt.user.client.ui.ScrollPanel spanelCollectionList = (com.google.gwt.user.client.ui.ScrollPanel) GWT.create(com.google.gwt.user.client.ui.ScrollPanel.class);
      // Setup section.
      spanelCollectionList.add(get_classStudyList());
      spanelCollectionList.setStyleName("" + get_res().css().scrollPanelClasspageList() + "");


      owner.spanelCollectionList = spanelCollectionList;

      return spanelCollectionList;
    }

    /**
     * Getter for classStudyList called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.VerticalPanel get_classStudyList() {
      return build_classStudyList();
    }
    private com.google.gwt.user.client.ui.VerticalPanel build_classStudyList() {
      // Creation section.
      final com.google.gwt.user.client.ui.VerticalPanel classStudyList = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
      // Setup section.
      classStudyList.setStyleName("" + get_res().css().htmlPanelClasspageList() + "");


      owner.classStudyList = classStudyList;

      return classStudyList;
    }

    /**
     * Getter for domId7Element called 2 times. Type: DEFAULT. Build precedence: 3.
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
