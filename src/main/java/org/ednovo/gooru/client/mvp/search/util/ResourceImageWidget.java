package org.ednovo.gooru.client.mvp.search.util;

import org.ednovo.gooru.shared.model.content.ResourceDo;
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
	
	public ResourceImageWidget(final ResourceDo resourceDo) {
		initWidget(uiBinder.createAndBindUi(this));
		final String categoryValue=StringUtil.getCategory(resourceDo.getCategory()!=null?resourceDo.getCategory().toLowerCase():"");
		if(resourceDo.getThumbnails()!= null){
			String thumbnailAssetURI=resourceDo.getThumbnails().getThumbnailAssetURI()!=null?resourceDo.getThumbnails().getThumbnailAssetURI():"";
			String thumbnailFolder=resourceDo.getThumbnails().getThumbnailFolder()!=null?resourceDo.getThumbnails().getThumbnailFolder():"";
			String thumbnailName=resourceDo.getThumbnails().getThumbnailName()!=null?resourceDo.getThumbnails().getThumbnailName():"";
			if("video".equalsIgnoreCase(categoryValue)){
				imgResourceImg.setUrl(thumbnailName);
			}else{
				imgResourceImg.setUrl(thumbnailAssetURI+thumbnailFolder+thumbnailName);
			}
		}else{
			imgResourceImg.setUrl("../images/default-"+categoryValue+".png");
		}
		imgResourceImg.addErrorHandler(new ErrorHandler() {
			@Override
			public void onError(ErrorEvent event) {
				imgResourceImg.setUrl("../images/default-"+categoryValue+".png");
			}
		});
		imageOverlay.addStyleName(categoryValue.toLowerCase()+"Small");
	}

	/**
	 * @return the imgResourceImg
	 */
	public Image getImgResourceImg() {
		return imgResourceImg;
	}
	
	
}
