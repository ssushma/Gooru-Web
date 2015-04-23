package org.ednovo.gooru.client.mvp.gsearch.util;

import java.util.HashMap;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.play.collection.end.study.CloseCollectionPlayerEvent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class SuccessPopupForResource extends PopupPanel {

	private static SuccessPopupForResourceUiBinder uiBinder = GWT
			.create(SuccessPopupForResourceUiBinder.class);

	interface SuccessPopupForResourceUiBinder extends
			UiBinder<Widget, SuccessPopupForResource> {
	}

	@UiField Button btnContinueSearching,btnViewInMyCollections;
	@UiField Label lblSuccessText;
	
	public SuccessPopupForResource() {
		setWidget(uiBinder.createAndBindUi(this));
	}
	public void setData(String collectionName,String selectedGooruOid,final HashMap<String, String> params){
		lblSuccessText.setText("This resource has been added to "+collectionName);
		btnViewInMyCollections.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				hide();
				AppClientFactory.getPlaceManager().revealPlace(
						PlaceTokens.SHELF, params);
				Element element = Document.get().getElementById("fixedFilterSearchID");
				if(element!=null){
					element.removeAttribute("style");
				}
			}
		});
	}
	public Button getCloseButton(){
		return btnContinueSearching;
	}
}
