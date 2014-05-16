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

public class LogoutPanelVc_logoutPanelVcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.home.LogoutPanelVc>, org.ednovo.gooru.client.mvp.home.LogoutPanelVc.logoutPanelVcUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
    @Template("")
    SafeHtml html2();
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.home.LogoutPanelVc owner) {


    return new Widgets(owner).get_logPanel();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.home.LogoutPanelVc owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.logoutPopupClicked(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.supportLinkClicked(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.classicGooruClicked(event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.feedbackPopupClick(event);
      }
    };

    public Widgets(final org.ednovo.gooru.client.mvp.home.LogoutPanelVc owner) {
      this.owner = owner;
      build_res();  // more than one getter call detected. Type: IMPORTED, precedence: 1
    }

    SafeHtml template_html1() {
      return template.html1();
    }
    SafeHtml template_html2() {
      return template.html2();
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.LogoutPanelVc_logoutPanelVcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.home.LogoutPanelVc_logoutPanelVcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.home.LogoutPanelVc_logoutPanelVcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.home.LogoutPanelVc_logoutPanelVcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.home.LogoutPanelVc_logoutPanelVcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 8 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.HomeCBundle res;
    private org.ednovo.gooru.client.mvp.home.HomeCBundle get_res() {
      return res;
    }
    private org.ednovo.gooru.client.mvp.home.HomeCBundle build_res() {
      // Creation section.
      res = (org.ednovo.gooru.client.mvp.home.HomeCBundle) GWT.create(org.ednovo.gooru.client.mvp.home.HomeCBundle.class);
      // Setup section.


      return res;
    }

    /**
     * Getter for logPanel called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_logPanel() {
      return build_logPanel();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_logPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel logPanel = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      logPanel.add(get_anrSettings());
      logPanel.add(get_classicGooruAnr());
      logPanel.add(get_f_HTMLPanel1());
      logPanel.add(get_supportAnr());
      logPanel.add(get_feedbackAnr());
      logPanel.add(get_f_HTMLPanel2());
      logPanel.add(get_logoutAnr());
      logPanel.setStyleName("" + get_res().css().logPanel() + "");


      owner.logPanel = logPanel;

      return logPanel;
    }

    /**
     * Getter for anrSettings called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Anchor get_anrSettings() {
      return build_anrSettings();
    }
    private com.google.gwt.user.client.ui.Anchor build_anrSettings() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor anrSettings = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      anrSettings.setStyleName("" + get_res().css().logoutText() + "");


      owner.anrSettings = anrSettings;

      return anrSettings;
    }

    /**
     * Getter for classicGooruAnr called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Anchor get_classicGooruAnr() {
      return build_classicGooruAnr();
    }
    private com.google.gwt.user.client.ui.Anchor build_classicGooruAnr() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor classicGooruAnr = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      classicGooruAnr.setStyleName("" + get_res().css().logoutText() + "");
      classicGooruAnr.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);


      owner.classicGooruAnr = classicGooruAnr;

      return classicGooruAnr;
    }

    /**
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      f_HTMLPanel1.setStyleName("" + get_res().css().userMenuBottomLine() + "");


      return f_HTMLPanel1;
    }

    /**
     * Getter for supportAnr called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Anchor get_supportAnr() {
      return build_supportAnr();
    }
    private com.google.gwt.user.client.ui.Anchor build_supportAnr() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor supportAnr = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      supportAnr.setStyleName("" + get_res().css().logoutText() + "");
      supportAnr.setTarget("_blank");
      supportAnr.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);


      owner.supportAnr = supportAnr;

      return supportAnr;
    }

    /**
     * Getter for feedbackAnr called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Anchor get_feedbackAnr() {
      return build_feedbackAnr();
    }
    private com.google.gwt.user.client.ui.Anchor build_feedbackAnr() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor feedbackAnr = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      feedbackAnr.setStyleName("" + get_res().css().logoutText() + "");
      feedbackAnr.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames4);


      owner.feedbackAnr = feedbackAnr;

      return feedbackAnr;
    }

    /**
     * Getter for f_HTMLPanel2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel2() {
      return build_f_HTMLPanel2();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel2 = new com.google.gwt.user.client.ui.HTMLPanel(template_html2().asString());
      // Setup section.
      f_HTMLPanel2.setStyleName("" + get_res().css().userMenuBottomLine() + "");


      return f_HTMLPanel2;
    }

    /**
     * Getter for logoutAnr called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.Anchor get_logoutAnr() {
      return build_logoutAnr();
    }
    private com.google.gwt.user.client.ui.Anchor build_logoutAnr() {
      // Creation section.
      final com.google.gwt.user.client.ui.Anchor logoutAnr = (com.google.gwt.user.client.ui.Anchor) GWT.create(com.google.gwt.user.client.ui.Anchor.class);
      // Setup section.
      logoutAnr.setStyleName("" + get_res().css().logoutText() + "");
      logoutAnr.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);


      owner.logoutAnr = logoutAnr;

      return logoutAnr;
    }
  }
}
