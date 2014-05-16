package org.ednovo.gooru.client.mvp.shelf.list;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.CssResource.Import;

public interface ShelfListView_ShelfTabViewUiBinderImpl_GenBundle extends ClientBundle {
  @Source("../folderList.css")
  ShelfListView_ShelfTabViewUiBinderImpl_GenCss_folderStyle folderStyle();

  @Source("uibinder:org.ednovo.gooru.client.mvp.shelf.list.ShelfListView_ShelfTabViewUiBinderImpl_GenCss_style.css")
  ShelfListView_ShelfTabViewUiBinderImpl_GenCss_style style();

}
