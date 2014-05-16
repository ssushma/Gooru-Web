package org.ednovo.gooru.client.mvp.home.library;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class LibraryUnitMenuView_LibraryUnitMenuViewUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, org.ednovo.gooru.client.mvp.home.library.LibraryUnitMenuView>, org.ednovo.gooru.client.mvp.home.library.LibraryUnitMenuView.LibraryUnitMenuViewUiBinder {


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final org.ednovo.gooru.client.mvp.home.library.LibraryUnitMenuView owner) {


    return new Widgets(owner).get_unitMenuItem();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.ednovo.gooru.client.mvp.home.library.LibraryUnitMenuView owner;


    public Widgets(final org.ednovo.gooru.client.mvp.home.library.LibraryUnitMenuView owner) {
      this.owner = owner;
      build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();  // more than one getter call detected. Type: GENERATED_BUNDLE, precedence: 1
      build_libraryStyle();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_libraryStyleUc();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 2 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.library.LibraryUnitMenuView_LibraryUnitMenuViewUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    private org.ednovo.gooru.client.mvp.home.library.LibraryUnitMenuView_LibraryUnitMenuViewUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }
    private org.ednovo.gooru.client.mvp.home.library.LibraryUnitMenuView_LibraryUnitMenuViewUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.ednovo.gooru.client.mvp.home.library.LibraryUnitMenuView_LibraryUnitMenuViewUiBinderImpl_GenBundle) GWT.create(org.ednovo.gooru.client.mvp.home.library.LibraryUnitMenuView_LibraryUnitMenuViewUiBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for libraryStyle called 1 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.library.LibraryUnitMenuView_LibraryUnitMenuViewUiBinderImpl_GenCss_libraryStyle get_libraryStyle() {
      return build_libraryStyle();
    }
    private org.ednovo.gooru.client.mvp.home.library.LibraryUnitMenuView_LibraryUnitMenuViewUiBinderImpl_GenCss_libraryStyle build_libraryStyle() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.home.library.LibraryUnitMenuView_LibraryUnitMenuViewUiBinderImpl_GenCss_libraryStyle libraryStyle = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().libraryStyle();
      // Setup section.
      libraryStyle.ensureInjected();


      return libraryStyle;
    }

    /**
     * Getter for libraryStyleUc called 0 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.ednovo.gooru.client.mvp.home.library.LibraryUnitMenuView_LibraryUnitMenuViewUiBinderImpl_GenCss_libraryStyleUc get_libraryStyleUc() {
      return build_libraryStyleUc();
    }
    private org.ednovo.gooru.client.mvp.home.library.LibraryUnitMenuView_LibraryUnitMenuViewUiBinderImpl_GenCss_libraryStyleUc build_libraryStyleUc() {
      // Creation section.
      final org.ednovo.gooru.client.mvp.home.library.LibraryUnitMenuView_LibraryUnitMenuViewUiBinderImpl_GenCss_libraryStyleUc libraryStyleUc = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().libraryStyleUc();
      // Setup section.
      libraryStyleUc.ensureInjected();


      owner.libraryStyleUc = libraryStyleUc;

      return libraryStyleUc;
    }

    /**
     * Getter for unitMenuItem called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.Label get_unitMenuItem() {
      return build_unitMenuItem();
    }
    private com.google.gwt.user.client.ui.Label build_unitMenuItem() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label unitMenuItem = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      unitMenuItem.setStyleName("" + get_libraryStyle().unitLi() + "");


      owner.unitMenuItem = unitMenuItem;

      return unitMenuItem;
    }
  }
}
