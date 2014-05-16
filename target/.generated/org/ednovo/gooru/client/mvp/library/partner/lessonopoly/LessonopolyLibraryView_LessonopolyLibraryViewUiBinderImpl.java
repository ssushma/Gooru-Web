package org.ednovo.gooru.client.mvp.library.partner.lessonopoly;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class LessonopolyLibraryView_LessonopolyLibraryViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.library.partner.lessonopoly.LessonopolyLibraryView>, org.ednovo.gooru.client.mvp.library.partner.lessonopoly.LessonopolyLibraryView.LessonopolyLibraryViewUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.library.partner.lessonopoly.LessonopolyLibraryView owner) {


    return new Widgets(owner).get_partnerPanel();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.library.partner.lessonopoly.LessonopolyLibraryView owner;


    public Widgets(final org.ednovo.gooru.client.mvp.library.partner.lessonopoly.LessonopolyLibraryView owner) {
      this.owner = owner;
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.library.partner.lessonopoly.LessonopolyLibraryView_LessonopolyLibraryViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.ednovo.gooru.client.mvp.library.partner.lessonopoly.LessonopolyLibraryView_LessonopolyLibraryViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.library.partner.lessonopoly.LessonopolyLibraryView_LessonopolyLibraryViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.library.partner.lessonopoly.LessonopolyLibraryView_LessonopolyLibraryViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.library.partner.lessonopoly.LessonopolyLibraryView_LessonopolyLibraryViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for partnerPanel called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_partnerPanel() {
      return build_partnerPanel();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_partnerPanel() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel partnerPanel = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.


      owner.partnerPanel = partnerPanel;

      return partnerPanel;
    }
  }
}
