package org.ednovo.gooru.client.mvp.gsearch.util;

import java.util.HashMap;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.shared.i18n.MessageProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
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
	private static MessageProperties i18n = GWT.create(MessageProperties.class);

	@UiField Button btnContinueSearching,btnViewInMyCollections;
	@UiField Label lblSuccessText,cancelResourcePopupBtnLbl,headerLbl;

	public SuccessPopupForResource() {
		setWidget(uiBinder.createAndBindUi(this));
		System.out.println("sucesspopoupfor resource");
	}
	public void setData(String collectionName,String selectedGooruOid,final HashMap<String, String> params,String type){
		if(type.equalsIgnoreCase("resource"))
		{
			lblSuccessText.setText(i18n.GL3192()+collectionName);
			headerLbl.setText(i18n.GL3224());
		}
		else
		{
			headerLbl.setText(i18n.GL3223());
			lblSuccessText.setText(i18n.GL3225()+collectionName);
		}
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
		
	public void enableTopFilters(){
		Element element = Document.get().getElementById("fixedFilterSearchID");
		if(element!=null){
			element.removeAttribute("style");
		}
		Window.enableScrolling(true);
	}

	
	@UiHandler("btnContinueSearching")
	public void clickOnContinue(ClickEvent clickevent){
		this.hide();
		enableTopFilters();
	}
	@UiHandler("cancelResourcePopupBtnLbl")
	public void clickOnCloseBtn (ClickEvent clickevent){
		this.hide();
		enableTopFilters();
	}
	
}
