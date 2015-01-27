package org.ednovo.gooru.client.mvp.library.partner;

import org.ednovo.gooru.shared.model.content.ThumbnailDo;
import org.ednovo.gooru.shared.model.library.CourseDo;
import org.ednovo.gooru.shared.model.library.LibraryUserDo;

public interface LoadBannerActionInterface {
	public void loadLibBanner(CourseDo courseDo, ThumbnailDo thumbnailDo, LibraryUserDo libraryUserDo);
}
