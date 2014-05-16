package org.ednovo.gooru.client.mvp.play.collection.preview;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.CssResource.Import;

public interface PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenBundle extends ClientBundle {
  @Source("collectionplayer.css")
  PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_playerStyle playerStyle();

  @Source("uibinder:org.ednovo.gooru.client.mvp.play.collection.preview.PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style.css")
  PreviewPlayerView_CollectionPlayerViewUiBinderImpl_GenCss_style style();

}
