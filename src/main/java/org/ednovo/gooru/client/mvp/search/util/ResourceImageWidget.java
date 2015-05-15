package org.ednovo.gooru.client.mvp.search.util;

import org.ednovo.gooru.client.uc.tooltip.LibraryTopicCollectionToolTip;
import org.ednovo.gooru.shared.model.content.ResourceDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class ResourceImageWidget extends Composite {

	private static ResourceImageWidgetUiBinder uiBinder = GWT
			.create(ResourceImageWidgetUiBinder.class);

	interface ResourceImageWidgetUiBinder extends
			UiBinder<Widget, ResourceImageWidget> {
	}
	
	@UiField Image imgResourceImg;
	@UiField HTMLPanel imageOverlay;
	private PopupPanel toolTipPopupPanel = new PopupPanel();
	
	public ResourceImageWidget(final ResourceDo resourceDo) {
		initWidget(uiBinder.createAndBindUi(this));
		final String categoryValue=StringUtil.getCategory(resourceDo.getResourceFormat().getValue()!=null?resourceDo.getResourceFormat().getValue().toLowerCase():"");
		if(resourceDo.getThumbnails()!= null){
			String thumbnailAssetURI=resourceDo.getThumbnails().getThumbnailAssetURI()!=null?resourceDo.getThumbnails().getThumbnailAssetURI():"";
			String thumbnailFolder=resourceDo.getThumbnails().getThumbnailFolder()!=null?resourceDo.getThumbnails().getThumbnailFolder():"";
			String thumbnailName=resourceDo.getThumbnails().getThumbnailName()!=null?resourceDo.getThumbnails().getThumbnailName():"";
			if(thumbnailName.startsWith("http"))
			{
				if("video".equalsIgnoreCase(categoryValue)){
					imgResourceImg.setUrl(thumbnailName);
				}
				else{
					imgResourceImg.setUrl(thumbnailAssetURI+thumbnailFolder+thumbnailName);
				}
			}
			else{
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
		imgResourceImg.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				// TODO Auto-generated method stub
				toolTipPopupPanel.clear();
				toolTipPopupPanel.setWidget(new LibraryTopicCollectionToolTip(resourceDo.getTitle(),categoryValue,""));
				toolTipPopupPanel.setStyleName("");
				toolTipPopupPanel.setPopupPosition(event.getRelativeElement().getAbsoluteLeft() - 2, event.getRelativeElement().getAbsoluteTop() + 55);
				toolTipPopupPanel.show();
			}
		});
		imgResourceImg.addMouseOutHandler(new MouseOutHandler() {
			@Override
			public void onMouseOut(MouseOutEvent event) {
				toolTipPopupPanel.hide();
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
