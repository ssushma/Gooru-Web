package org.ednovo.gooru.client.mvp.classpages.classlist;

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

public class MembersViewVc_MembersViewVcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.classpages.classlist.MembersViewVc>, org.ednovo.gooru.client.mvp.classpages.classlist.MembersViewVc.MembersViewVcUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span> <span id='{1}'></span> <span id='{2}'></span> <span id='{3}'></span>")
    SafeHtml html1(String arg0, String arg1, String arg2, String arg3);
     
    @Template("<span id='{0}'></span>")
    SafeHtml html2(String arg0);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.classpages.classlist.MembersViewVc owner) {


    return new Widgets(owner).get_panelCollaboratorsListContainer();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.classpages.classlist.MembersViewVc owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.setStudentsListContainer(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.classpages.classlist.MembersViewVc owner) {
      this.owner = owner;
      build_members();  // more than one getter call detected. Type: IMPORTED, precedence: 1
      build_domId1();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId2();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId3();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId4();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 3
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId1Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId2Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId3Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId4Element();  // more than one getter call detected. Type: DEFAULT, precedence: 3
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1(get_domId1(), get_domId2(), get_domId3(), get_domId4());
    }
    SafeHtml template_html2() {
      return template.html2(get_domId0());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.classpages.classlist.MembersViewVc_MembersViewVcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.classpages.classlist.MembersViewVc_MembersViewVcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.classpages.classlist.MembersViewVc_MembersViewVcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.classpages.classlist.MembersViewVc_MembersViewVcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.classpages.classlist.MembersViewVc_MembersViewVcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for members called 6 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.classpages.classlist.ClasslistpageCBundle members;
    private org.ednovo.gooru.client.mvp.classpages.classlist.ClasslistpageCBundle get_members() {
      return members;
    }
    private org.ednovo.gooru.client.mvp.classpages.classlist.ClasslistpageCBundle build_members() {
      // Creation section.
      members = (org.ednovo.gooru.client.mvp.classpages.classlist.ClasslistpageCBundle) GWT.create(org.ednovo.gooru.client.mvp.classpages.classlist.ClasslistpageCBundle.class);
      // Setup section.


      return members;
    }

    /**
     * Getter for panelCollaboratorsListContainer called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_panelCollaboratorsListContainer() {
      return build_panelCollaboratorsListContainer();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_panelCollaboratorsListContainer() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel panelCollaboratorsListContainer = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      panelCollaboratorsListContainer.setStyleName("" + get_members().css().membersListPanel() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2146 = UiBinderUtil.attachToDom(panelCollaboratorsListContainer.getElement());
      get_domId0Element().get();

      // Detach section.
      attachRecord2146.detach();
      panelCollaboratorsListContainer.addAndReplaceElement(get_panelMembers(), get_domId0Element().get());

      owner.panelCollaboratorsListContainer = panelCollaboratorsListContainer;

      return panelCollaboratorsListContainer;
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
     * Getter for panelMembers called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private org.ednovo.gooru.client.ui.HTMLEventPanel get_panelMembers() {
      return build_panelMembers();
    }
    private org.ednovo.gooru.client.ui.HTMLEventPanel build_panelMembers() {
      // Creation section.
      final org.ednovo.gooru.client.ui.HTMLEventPanel panelMembers = new org.ednovo.gooru.client.ui.HTMLEventPanel(template_html1().asString());
      // Setup section.
      panelMembers.setStyleName("" + get_members().css().panelCollaborators() + "");

      // Attach section.
      UiBinderUtil.TempAttachment attachRecord2147 = UiBinderUtil.attachToDom(panelMembers.getElement());
      get_domId1Element().get();
      get_domId2Element().get();
      get_domId3Element().get();
      get_domId4Element().get();

      // Detach section.
      attachRecord2147.detach();
      panelMembers.addAndReplaceElement(get_imgProfileImage(), get_domId1Element().get());
      panelMembers.addAndReplaceElement(get_lblUserName(), get_domId2Element().get());
      panelMembers.addAndReplaceElement(get_lblEmailId(), get_domId3Element().get());
      panelMembers.addAndReplaceElement(get_btnRemove(), get_domId4Element().get());

      owner.panelMembers = panelMembers;

      return panelMembers;
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
     * Getter for imgProfileImage called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Image get_imgProfileImage() {
      return build_imgProfileImage();
    }
    private com.google.gwt.user.client.ui.Image build_imgProfileImage() {
      // Creation section.
      final com.google.gwt.user.client.ui.Image imgProfileImage = (com.google.gwt.user.client.ui.Image) GWT.create(com.google.gwt.user.client.ui.Image.class);
      // Setup section.
      imgProfileImage.setStyleName("" + get_members().css().radioButtonImg() + "");


      owner.imgProfileImage = imgProfileImage;

      return imgProfileImage;
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
     * Getter for lblUserName called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_lblUserName() {
      return build_lblUserName();
    }
    private com.google.gwt.user.client.ui.Label build_lblUserName() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblUserName = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblUserName.setStyleName("" + get_members().css().usernameCss() + "");


      owner.lblUserName = lblUserName;

      return lblUserName;
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
     * Getter for lblEmailId called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_lblEmailId() {
      return build_lblEmailId();
    }
    private com.google.gwt.user.client.ui.Label build_lblEmailId() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label lblEmailId = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      lblEmailId.setStyleName("" + get_members().css().emailIdCss() + "");


      owner.lblEmailId = lblEmailId;

      return lblEmailId;
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
     * Getter for btnRemove called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_btnRemove() {
      return build_btnRemove();
    }
    private com.google.gwt.user.client.ui.Button build_btnRemove() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button btnRemove = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      btnRemove.setStyleName("secondary " + get_members().css().btnRemove() + "");
      btnRemove.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.btnRemove = btnRemove;

      return btnRemove;
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
