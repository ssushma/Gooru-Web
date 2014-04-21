package org.ednovo.gooru.client.mvp.image.upload;
import com.google.code.gwt.crop.client.CropperStyleResource;
import com.google.code.gwt.crop.client.ICropperStyleSource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

class StylesDesktopImpl implements ICropperStyleSource {

	interface IStyleDesktop extends ClientBundle {
		
		@Source("GwtGooruCropper.css")
		CropperStyleResource getStyles();
	}

	private final IStyleDesktop bundleResources = GWT.create(IStyleDesktop.class);
	
	/**
	 * {@inheritDoc}
	 */
	public CropperStyleResource css() {
		return bundleResources.getStyles();
	}

}