package org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections;

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

public class CollectionsView_CollectionsViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections.CollectionsView>, org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections.CollectionsView.CollectionsViewUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span> <span id='{1}'></span>")
    SafeHtml html1(String arg0, String arg1);
     
    @Template("")
    SafeHtml html2();
     
    @Template("<span id='{0}'></span>")
    SafeHtml html3(String arg0);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections.CollectionsView owner) {


    return new Widgets(owner).get_classpageItemContainer();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections.CollectionsView owner;


    final com.google.gwt.event.dom.client.ErrorHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ErrorHandler() {
      public void onError(com.google.gwt.event.dom.client.ErrorEvent event) {
        owner.setErrorImage(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections.CollectionsView owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 5
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 4
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 5
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 4
    }

    SafeHtml template_html1() {
      return template.html1(get_domId0(), get_domId1());
    }
    SafeHtml template_html2() {
      return template.html2();
    }
    SafeHtml template_html3() {
      return template.html3(get_domId2());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections.CollectionsView_CollectionsViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections.CollectionsView_CollectionsViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections.CollectionsView_CollectionsViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections.CollectionsView_CollectionsViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections.CollectionsView_CollectionsViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for style called 27 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections.CollectionsView_CollectionsViewUiBinderImpl_GenCss_style style;
    private org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections.CollectionsView_CollectionsViewUiBinderImpl_GenCss_style get_style() {
      return style;
    }
    private org.ednovo.gooru.client.mvp.classpages.tabitem.assignments.collections.CollectionsView_CollectionsViewUiBinderImpl_GenCss_style build_style() {
      // Creation section.
      style = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().style();
      // Setup section.
      style.ensureInjected();


      return style;
    }

    /**
     * Getter for classpageItemContainer called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_classpageItemContainer() {
      return build_classpageItemContainer();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_classpageItemContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel classpageItemContainer = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      classpageItemContainer.add(get_editButtonsToolBar());
      classpageItemContainer.add(get_f_FlowPanel2());
      classpageItemContainer.setStyleName("" + get_style().classpageContainer() + "");


      owner.classpageItemContainer = classpageItemContainer;

      return classpageItemContainer;
    }

    /**
     * Getter for editButtonsToolBar called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_editButtonsToolBar() {
      return build_editButtonsToolBar();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_editButtonsToolBar() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel editButtonsToolBar = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      editButtonsToolBar.add(get_f_HTMLPanel1());
      editButtonsToolBar.add(get_headerRightPanel());
      editButtonsToolBar.setStyleName("" + get_style().classpageHeader() + "");


      owner.editButtonsToolBar = editButtonsToolBar;

      return editButtonsToolBar;
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
      f_HTMLPanel1.setStyleName("" + get_style().headerLeft() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1272 = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());
      get_domId0Element().get();
      get_domId1Element().get();

      // Detach section.
      attachRecord1272.detach();
      f_HTMLPanel1.addAndReplaceElement(get_dueDateText(), get_domId0Element().get());
      f_HTMLPanel1.addAndReplaceElement(get_dueDate(), get_domId1Element().get());

      return f_HTMLPanel1;
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
     * Getter for dueDateText called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_dueDateText() {
      return build_dueDateText();
    }
    private com.google.gwt.user.client.ui.Label build_dueDateText() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label dueDateText = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      dueDateText.setStyleName("" + get_style().headerText() + "");


      owner.dueDateText = dueDateText;

      return dueDateText;
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
     * Getter for dueDate called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_dueDate() {
      return build_dueDate();
    }
    private com.google.gwt.user.client.ui.Label build_dueDate() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label dueDate = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      dueDate.setStyleName("" + get_style().headerDueDate() + "");


      owner.dueDate = dueDate;

      return dueDate;
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
     * Getter for headerRightPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_headerRightPanel() {
      return build_headerRightPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_headerRightPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel headerRightPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      headerRightPanel.add(get_viewClassItemAnalyticsButton());
      headerRightPanel.add(get_dropdownPanelAnalyticsButton());
      headerRightPanel.add(get_editClassItemButton());
      headerRightPanel.add(get_dropdownPanel());
      headerRightPanel.setStyleName("" + get_style().headerRight() + "");


      owner.headerRightPanel = headerRightPanel;

      return headerRightPanel;
    }

    /**
     * Getter for viewClassItemAnalyticsButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Button get_viewClassItemAnalyticsButton() {
      return build_viewClassItemAnalyticsButton();
    }
    private com.google.gwt.user.client.ui.Button build_viewClassItemAnalyticsButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button viewClassItemAnalyticsButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      viewClassItemAnalyticsButton.setStyleName("" + get_style().viewAnaytics() + "");


      owner.viewClassItemAnalyticsButton = viewClassItemAnalyticsButton;

      return viewClassItemAnalyticsButton;
    }

    /**
     * Getter for dropdownPanelAnalyticsButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_dropdownPanelAnalyticsButton() {
      return build_dropdownPanelAnalyticsButton();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_dropdownPanelAnalyticsButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel dropdownPanelAnalyticsButton = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      dropdownPanelAnalyticsButton.add(get_moniterProgress());
      dropdownPanelAnalyticsButton.add(get_collectionSummary());
      dropdownPanelAnalyticsButton.setStyleName("" + get_style().AnalyticsDropdown() + "");


      owner.dropdownPanelAnalyticsButton = dropdownPanelAnalyticsButton;

      return dropdownPanelAnalyticsButton;
    }

    /**
     * Getter for moniterProgress called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_moniterProgress() {
      return build_moniterProgress();
    }
    private com.google.gwt.user.client.ui.Label build_moniterProgress() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label moniterProgress = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      moniterProgress.setStyleName("" + get_style().AnalyticsDropdownLi() + "");


      owner.moniterProgress = moniterProgress;

      return moniterProgress;
    }

    /**
     * Getter for collectionSummary called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_collectionSummary() {
      return build_collectionSummary();
    }
    private com.google.gwt.user.client.ui.Label build_collectionSummary() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label collectionSummary = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      collectionSummary.setStyleName("" + get_style().AnalyticsDropdownLi() + "");


      owner.collectionSummary = collectionSummary;

      return collectionSummary;
    }

    /**
     * Getter for editClassItemButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Button get_editClassItemButton() {
      return build_editClassItemButton();
    }
    private com.google.gwt.user.client.ui.Button build_editClassItemButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button editClassItemButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      editClassItemButton.setStyleName("" + get_style().editButton() + "");


      owner.editClassItemButton = editClassItemButton;

      return editClassItemButton;
    }

    /**
     * Getter for dropdownPanel called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_dropdownPanel() {
      return build_dropdownPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_dropdownPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel dropdownPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      dropdownPanel.add(get_editDueDateButton());
      dropdownPanel.add(get_editDirectionButton());
      dropdownPanel.add(get_editCollection());
      dropdownPanel.add(get_deleteItemButton());
      dropdownPanel.setStyleName("" + get_style().classpageDropdown() + "");


      owner.dropdownPanel = dropdownPanel;

      return dropdownPanel;
    }

    /**
     * Getter for editDueDateButton called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_editDueDateButton() {
      return build_editDueDateButton();
    }
    private com.google.gwt.user.client.ui.Label build_editDueDateButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label editDueDateButton = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      editDueDateButton.setStyleName("" + get_style().classpadeDropdownLi() + "");


      owner.editDueDateButton = editDueDateButton;

      return editDueDateButton;
    }

    /**
     * Getter for editDirectionButton called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_editDirectionButton() {
      return build_editDirectionButton();
    }
    private com.google.gwt.user.client.ui.Label build_editDirectionButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label editDirectionButton = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      editDirectionButton.setStyleName("" + get_style().classpadeDropdownLi() + "");


      owner.editDirectionButton = editDirectionButton;

      return editDirectionButton;
    }

    /**
     * Getter for editCollection called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_editCollection() {
      return build_editCollection();
    }
    private com.google.gwt.user.client.ui.Label build_editCollection() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label editCollection = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      editCollection.setStyleName("" + get_style().classpadeDropdownLi() + "");


      owner.editCollection = editCollection;

      return editCollection;
    }

    /**
     * Getter for deleteItemButton called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_deleteItemButton() {
      return build_deleteItemButton();
    }
    private com.google.gwt.user.client.ui.Label build_deleteItemButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label deleteItemButton = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      deleteItemButton.setStyleName("" + get_style().classpadeDropdownLi() + "");


      owner.deleteItemButton = deleteItemButton;

      return deleteItemButton;
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
      f_FlowPanel2.add(get_directionsLabel());
      f_FlowPanel2.add(get_directionContentPanel());
      f_FlowPanel2.add(get_f_Label3());
      f_FlowPanel2.add(get_f_FlowPanel4());
      f_FlowPanel2.setStyleName("" + get_style().classpageContent() + "");


      return f_FlowPanel2;
    }

    /**
     * Getter for directionsLabel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_directionsLabel() {
      return build_directionsLabel();
    }
    private com.google.gwt.user.client.ui.Label build_directionsLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label directionsLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      directionsLabel.setStyleName("" + get_style().classpageHeading() + "");


      owner.directionsLabel = directionsLabel;

      return directionsLabel;
    }

    /**
     * Getter for directionContentPanel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_directionContentPanel() {
      return build_directionContentPanel();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_directionContentPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel directionContentPanel = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      directionContentPanel.setStyleName("" + get_style().classpageDesc() + "");


      owner.directionContentPanel = directionContentPanel;

      return directionContentPanel;
    }

    /**
     * Getter for f_Label3 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label3() {
      return build_f_Label3();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label3() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label3 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label3.setStyleName("" + get_style().classpageBorder() + "");


      return f_Label3;
    }

    /**
     * Getter for f_FlowPanel4 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel4() {
      return build_f_FlowPanel4();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel4() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel4 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel4.add(get_thumbnailContainer());
      f_FlowPanel4.add(get_f_FlowPanel5());
      f_FlowPanel4.setStyleName("" + get_style().classpageContentPanel() + "");


      return f_FlowPanel4;
    }

    /**
     * Getter for thumbnailContainer called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_thumbnailContainer() {
      return build_thumbnailContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_thumbnailContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel thumbnailContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html3().asString());
      // Setup section.
      thumbnailContainer.setStyleName("" + get_style().classpageResourceThumbnail() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord1273 = UiBinderUtil.attachToDom(thumbnailContainer.getElement());
      get_domId2Element().get();

      // Detach section.
      attachRecord1273.detach();
      thumbnailContainer.addAndReplaceElement(get_collectionImage(), get_domId2Element().get());

      owner.thumbnailContainer = thumbnailContainer;

      return thumbnailContainer;
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
     * Getter for collectionImage called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Image get_collectionImage() {
      return build_collectionImage();
    }
    private com.google.gwt.user.client.ui.Image build_collectionImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image collectionImage = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      collectionImage.setStyleName("" + get_style().classpageResourceImage() + "");
      collectionImage.addErrorHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.collectionImage = collectionImage;

      return collectionImage;
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
     * Getter for f_FlowPanel5 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel5() {
      return build_f_FlowPanel5();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel5 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel5.add(get_classpageItemTitle());
      f_FlowPanel5.add(get_learningObjective());
      f_FlowPanel5.add(get_learningObject());
      f_FlowPanel5.setStyleName("" + get_style().resourceHeaderTextPanel() + "");


      return f_FlowPanel5;
    }

    /**
     * Getter for classpageItemTitle called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Anchor get_classpageItemTitle() {
      return build_classpageItemTitle();
    }
    private com.google.gwt.user.client.ui.Anchor build_classpageItemTitle() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor classpageItemTitle = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      classpageItemTitle.setStyleName("" + get_style().resourceTitle() + "");


      owner.classpageItemTitle = classpageItemTitle;

      return classpageItemTitle;
    }

    /**
     * Getter for learningObjective called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_learningObjective() {
      return build_learningObjective();
    }
    private com.google.gwt.user.client.ui.Label build_learningObjective() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label learningObjective = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      learningObjective.setStyleName("" + get_style().classpageHeading() + "");


      owner.learningObjective = learningObjective;

      return learningObjective;
    }

    /**
     * Getter for learningObject called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.HTML get_learningObject() {
      return build_learningObject();
    }
    private com.google.gwt.user.client.ui.HTML build_learningObject() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTML learningObject = (com.google.gwt.user.client.ui.HTML) GWT.create(com.google.gwt.user.client.ui.HTML.class);
      // Setup section.
      learningObject.setStyleName("" + get_style().classpageDesc() + "");


      owner.learningObject = learningObject;

      return learningObject;
    }
  }
}
