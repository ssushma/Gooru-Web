package org.ednovo.gooru.client.mvp.profilepage;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.CssResource.Import;

public interface ProfilePageView_ProfilePageViewUiBinderImpl_GenBundle extends ClientBundle {
  @Source("profile-page-style.css")
  ProfilePageView_ProfilePageViewUiBinderImpl_GenCss_ProfilePageStyle ProfilePageStyle();

  @Source("../settings/Setting-page.css")
  ProfilePageView_ProfilePageViewUiBinderImpl_GenCss_settingsStyle settingsStyle();

}
