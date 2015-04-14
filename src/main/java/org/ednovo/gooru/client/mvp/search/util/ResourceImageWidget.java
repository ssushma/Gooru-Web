package org.ednovo.gooru.client.mvp.search.util;

import org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class ResourceImageWidget extends Composite {

	private static ResourceImageWidgetUiBinder uiBinder = GWT
			.create(ResourceImageWidgetUiBinder.class);

	interface ResourceImageWidgetUiBinder extends
			UiBinder<Widget, ResourceImageWidget> {
	}
	
	@UiField Image imgResourceImg;
	@UiField HTMLPanel imageOverlay;
	
	public ResourceImageWidget(final CollectionItemSearchResultDo collectionItemSearchResultDo) {
		initWidget(uiBinder.createAndBindUi(this));
		imgResourceImg.setUrl(collectionItemSearchResultDo.getUrl());
		final String categoryValue=StringUtil.getCategory(collectionItemSearchResultDo.getCategory()!=null?collectionItemSearchResultDo.getCategory():"");
		imgResourceImg.addErrorHandler(new ErrorHandler() {
			@Override
			public void onError(ErrorEvent event) {
				imgResourceImg.setUrl("../images/default-"+categoryValue.toLowerCase()+".png");
			}
		});
		imageOverlay.addStyleName(categoryValue.toLowerCase()+"Small");
	}
}
