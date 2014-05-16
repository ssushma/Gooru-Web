package org.ednovo.gooru.client.mvp.search;

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

public class SimpleCollectionVc_SimpleCollectionVcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.search.SimpleCollectionVc>, org.ednovo.gooru.client.mvp.search.SimpleCollectionVc.SimpleCollectionVcUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html2(String arg0);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.search.SimpleCollectionVc owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.search.SimpleCollectionVc owner;


    public Widgets(final org.ednovo.gooru.client.mvp.search.SimpleCollectionVc owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2(get_domId0());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.search.SimpleCollectionVc_SimpleCollectionVcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.search.SimpleCollectionVc_SimpleCollectionVcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.search.SimpleCollectionVc_SimpleCollectionVcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.search.SimpleCollectionVc_SimpleCollectionVcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.search.SimpleCollectionVc_SimpleCollectionVcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for style called 11 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.search.SimpleCollectionVc_SimpleCollectionVcUiBinderImpl_GenCss_style style;
    private org.ednovo.gooru.client.mvp.search.SimpleCollectionVc_SimpleCollectionVcUiBinderImpl_GenCss_style get_style() {
      return style;
    }
    private org.ednovo.gooru.client.mvp.search.SimpleCollectionVc_SimpleCollectionVcUiBinderImpl_GenCss_style build_style() {
      // Creation section.
      style = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().style();
      // Setup section.
      style.ensureInjected();


      return style;
    }

    /**
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord302 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId0Element().get();

      // Detach section.
      attachRecord302.detach();
      f_HTMLPanel1.addAndReplaceElement(get_internalPanel1(), get_domId0Element().get());

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
     * Getter for internalPanel1 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_internalPanel1() {
      return build_internalPanel1();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_internalPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel internalPanel1 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      internalPanel1.add(get_collectionImageUc());
      internalPanel1.add(get_collectionTitlePanel());
      internalPanel1.add(get_collectionGradePanel());
      internalPanel1.setStyleName("" + get_style().collectionThumbnailPanel() + "");


      owner.internalPanel1 = internalPanel1;

      return internalPanel1;
    }

    /**
     * Getter for collectionImageUc called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private org.ednovo.gooru.client.uc.CollectionImageUc get_collectionImageUc() {
      return build_collectionImageUc();
    }
    private org.ednovo.gooru.client.uc.CollectionImageUc build_collectionImageUc() {
      // Creation section.
      final org.ednovo.gooru.client.uc.CollectionImageUc collectionImageUc = (org.ednovo.gooru.client.uc.CollectionImageUc) GWT.create(org.ednovo.gooru.client.uc.CollectionImageUc.class);
      // Setup section.


      owner.collectionImageUc = collectionImageUc;

      return collectionImageUc;
    }

    /**
     * Getter for collectionTitlePanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_collectionTitlePanel() {
      return build_collectionTitlePanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_collectionTitlePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel collectionTitlePanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      collectionTitlePanel.add(get_collectionTitleLbl());
      collectionTitlePanel.add(get_creatorNameLbl());
      collectionTitlePanel.add(get_creatorNameLblValue());
      collectionTitlePanel.add(get_containerPanel());
      collectionTitlePanel.add(get_metaDataFloPanel());
      collectionTitlePanel.add(get_standardsDataPanel());
      collectionTitlePanel.add(get_f_Label2());
      collectionTitlePanel.add(get_resourceCountLbl());
      collectionTitlePanel.add(get_questionCountLbl());
      collectionTitlePanel.setStyleName("" + get_style().collectionTitlePanel() + "");


      owner.collectionTitlePanel = collectionTitlePanel;

      return collectionTitlePanel;
    }

    /**
     * Getter for collectionTitleLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTML get_collectionTitleLbl() {
      return build_collectionTitleLbl();
    }
    private com.google.gwt.user.client.ui.HTML build_collectionTitleLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML collectionTitleLbl = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      collectionTitleLbl.setStyleName("" + get_style().collectionTitle() + "");


      owner.collectionTitleLbl = collectionTitleLbl;

      return collectionTitleLbl;
    }

    /**
     * Getter for creatorNameLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_creatorNameLbl() {
      return build_creatorNameLbl();
    }
    private com.google.gwt.user.client.ui.Label build_creatorNameLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label creatorNameLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      creatorNameLbl.setStyleName("" + get_style().author() + "");


      owner.creatorNameLbl = creatorNameLbl;

      return creatorNameLbl;
    }

    /**
     * Getter for creatorNameLblValue called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_creatorNameLblValue() {
      return build_creatorNameLblValue();
    }
    private com.google.gwt.user.client.ui.Label build_creatorNameLblValue() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label creatorNameLblValue = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      creatorNameLblValue.setStyleName("" + get_style().authorName() + "");


      owner.creatorNameLblValue = creatorNameLblValue;

      return creatorNameLblValue;
    }

    /**
     * Getter for containerPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_containerPanel() {
      return build_containerPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_containerPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel containerPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.


      owner.containerPanel = containerPanel;

      return containerPanel;
    }

    /**
     * Getter for metaDataFloPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_metaDataFloPanel() {
      return build_metaDataFloPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_metaDataFloPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel metaDataFloPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      metaDataFloPanel.setStyleName("" + get_style().metaDataPanel() + "");


      owner.metaDataFloPanel = metaDataFloPanel;

      return metaDataFloPanel;
    }

    /**
     * Getter for standardsDataPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_standardsDataPanel() {
      return build_standardsDataPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_standardsDataPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel standardsDataPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      owner.standardsDataPanel = standardsDataPanel;

      return standardsDataPanel;
    }

    /**
     * Getter for f_Label2 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label2() {
      return build_f_Label2();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label2() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label2 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label2.setStyleName("" + get_style().resourceCountImg() + "");


      return f_Label2;
    }

    /**
     * Getter for resourceCountLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_resourceCountLbl() {
      return build_resourceCountLbl();
    }
    private com.google.gwt.user.client.ui.Label build_resourceCountLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label resourceCountLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      resourceCountLbl.setStyleName("" + get_style().resourceCount() + "");


      owner.resourceCountLbl = resourceCountLbl;

      return resourceCountLbl;
    }

    /**
     * Getter for questionCountLbl called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_questionCountLbl() {
      return build_questionCountLbl();
    }
    private com.google.gwt.user.client.ui.Label build_questionCountLbl() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label questionCountLbl = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      questionCountLbl.setStyleName("" + get_style().resourceCount() + "");


      owner.questionCountLbl = questionCountLbl;

      return questionCountLbl;
    }

    /**
     * Getter for collectionGradePanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_collectionGradePanel() {
      return build_collectionGradePanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_collectionGradePanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel collectionGradePanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      collectionGradePanel.add(get_gradesLblValue());
      collectionGradePanel.setStyleName("" + get_style().collectionGradesPanel() + "");


      owner.collectionGradePanel = collectionGradePanel;

      return collectionGradePanel;
    }

    /**
     * Getter for gradesLblValue called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_gradesLblValue() {
      return build_gradesLblValue();
    }
    private com.google.gwt.user.client.ui.Label build_gradesLblValue() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label gradesLblValue = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      gradesLblValue.setStyleName("" + get_style().grades() + "");


      owner.gradesLblValue = gradesLblValue;

      return gradesLblValue;
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
