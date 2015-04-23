package org.ednovo.gooru.client.mvp.gsearch.util;

import java.util.HashMap;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.play.collection.end.study.CloseCollectionPlayerEvent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class SuccessPopupForResource extends Composite {

	private static SuccessPopupForResourceUiBinder uiBinder = GWT
			.create(SuccessPopupForResourceUiBinder.class);

	interface SuccessPopupForResourceUiBinder extends
			UiBinder<Widget, SuccessPopupForResource> {
	}

	@UiField Button btnContinueSearching,btnViewInMyCollections;
	@UiField Label lblSuccessText;
	
	public SuccessPopupForResource() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	public void setData(String collectionName,String selectedGooruOid,final HashMap<String, String> params){
		lblSuccessText.setText("This resource has been added to "+collectionName);
		btnViewInMyCollections.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				AppClientFactory.getPlaceManager().revealPlace(
						PlaceTokens.SHELF, params);
				AppClientFactory.fireEvent(new CloseCollectionPlayerEvent(true));
			}
		});
	}
	public Button getCloseButton(){
		return btnContinueSearching;
	}
}
