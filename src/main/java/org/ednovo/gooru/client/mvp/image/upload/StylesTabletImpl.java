package org.ednovo.gooru.client.mvp.image.upload;

import com.google.code.gwt.crop.client.CropperStyleResource;
import com.google.code.gwt.crop.client.ICropperStyleSource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

class StylesTabletImpl implements ICropperStyleSource {

	private final IStyleTablet bundleResources = GWT.create(IStyleTablet.class);

	interface IStyleTablet extends ClientBundle {
		
		@Source("GwtGooruCropperTablet.css")
		CropperStyleResource getStyles();
	}

	
	/**
	 * {@inheritDoc}
	 */
	public CropperStyleResource css() {
		return bundleResources.getStyles();
	}
}