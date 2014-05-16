package org.ednovo.gooru.client.mvp.home.library;

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

public class LibraryLessonUc_LibraryLessonUcUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.home.library.LibraryLessonUc>, org.ednovo.gooru.client.mvp.home.library.LibraryLessonUc.LibraryLessonUcUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("")
    SafeHtml html1();
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.home.library.LibraryLessonUc owner) {


    return new Widgets(owner).get_lessonList();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.home.library.LibraryLessonUc owner;


    public Widgets(final org.ednovo.gooru.client.mvp.home.library.LibraryLessonUc owner) {
      this.owner = owner;
      build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();  // more than one getter call detected. Type: GENERATED_BUNDLE, precedence: 1
      build_libraryStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_libraryStyleUc();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
    }

    SafeHtml template_html1() {
      return template.html1();
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 2 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.library.LibraryLessonUc_LibraryLessonUcUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    private org.ednovo.gooru.client.mvp.home.library.LibraryLessonUc_LibraryLessonUcUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }
    private org.ednovo.gooru.client.mvp.home.library.LibraryLessonUc_LibraryLessonUcUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.home.library.LibraryLessonUc_LibraryLessonUcUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.home.library.LibraryLessonUc_LibraryLessonUcUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for libraryStyle called 0 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.library.LibraryLessonUc_LibraryLessonUcUiBinderImpl_GenCss_libraryStyle get_libraryStyle() {
      return build_libraryStyle();
    }
    private org.ednovo.gooru.client.mvp.home.library.LibraryLessonUc_LibraryLessonUcUiBinderImpl_GenCss_libraryStyle build_libraryStyle() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.home.library.LibraryLessonUc_LibraryLessonUcUiBinderImpl_GenCss_libraryStyle libraryStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().libraryStyle();
      // Setup section.
      libraryStyle.ensureInjected();


      return libraryStyle;
    }

    /**
     * Getter for libraryStyleUc called 0 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.library.LibraryLessonUc_LibraryLessonUcUiBinderImpl_GenCss_libraryStyleUc get_libraryStyleUc() {
      return build_libraryStyleUc();
    }
    private org.ednovo.gooru.client.mvp.home.library.LibraryLessonUc_LibraryLessonUcUiBinderImpl_GenCss_libraryStyleUc build_libraryStyleUc() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.home.library.LibraryLessonUc_LibraryLessonUcUiBinderImpl_GenCss_libraryStyleUc libraryStyleUc = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().libraryStyleUc();
      // Setup section.
      libraryStyleUc.ensureInjected();


      owner.libraryStyleUc = libraryStyleUc;

      return libraryStyleUc;
    }

    /**
     * Getter for lessonList called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_lessonList() {
      return build_lessonList();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_lessonList() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel lessonList = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.
      lessonList.setStyleName("lesson");


      owner.lessonList = lessonList;

      return lessonList;
    }
  }
}
