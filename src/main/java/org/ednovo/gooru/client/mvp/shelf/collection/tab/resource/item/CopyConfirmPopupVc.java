/*******************************************************************************
 * Copyright 2013 Ednovo d/b/a Gooru. All rights reserved.
 * 
 *  http://www.goorulearning.org/
 * 
 *  Permission is hereby granted, free of charge, to any person obtaining
 *  a copy of this software and associated documentation files (the
 *  "Software"), to deal in the Software without restriction, including
 *  without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to
 *  permit persons to whom the Software is furnished to do so, subject to
 *  the following conditions:
 * 
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 * 
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 *  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 *  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 *  WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.item;

import java.util.List;

import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.event.SetHeaderZIndexEvent;
import org.ednovo.gooru.client.uc.AppPopUp;
import org.ednovo.gooru.client.uc.BlueButtonUc;
import org.ednovo.gooru.client.uc.HTMLEventPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * @fileName : CopyConfirmPopupVc.java
 *
 * @description : This class is used to copy collection in self page
 *
 * @version : 1.0
 *
 * @date: 02-Jan-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: Gooru Team
 */
public abstract class CopyConfirmPopupVc extends AppPopUp {

	@UiField

	BlueButtonUc btnCopy;

	@UiField
	Label btnCancel, resourceFirstElement,loadingTextLbl;

	// @UiField
	// ListBox copyPopupListBox;

	
	

	@UiField
	HTMLEventPanel popUpCopyCollection;
	@UiField
	ScrollPanel copyPopUpScrollHtmlPanel;

	@UiField
	FocusPanel copyPopUpResourceListImage;
	@UiField
	HTMLPanel copyLabel, htmlScrollPanel, loadingPanel;
	/*@UiField
	Label cancelButton;*/
	
	List<Integer> collectionItemDoSize;

	/* Setter and getters */
	/**
	 * This method is used to get collectionItem size
	 * 
	 * @return collectionItemDoSize
	 */
	public List<Integer> getCollectionItemDoSize() {
		return collectionItemDoSize;
	}

	/**
	 * This method is used to set collectionItem size
	 */

	public void setCollectionItemDoSize(List<Integer> collectionItemDoSize) {
		this.collectionItemDoSize = collectionItemDoSize;
	}

	private static CopyConfirmPopupVcUiBinder uiBinder = GWT
			.create(CopyConfirmPopupVcUiBinder.class);

	interface CopyConfirmPopupVcUiBinder extends
			UiBinder<Widget, CopyConfirmPopupVc> {
	}

	/**
	 * default constructor of CopyConfirmPopupVc
	 */
	public CopyConfirmPopupVc() {
		super();
		this.getElement().getStyle().setWidth(350, Unit.PX);
		setContent("Copy Resources to", uiBinder.createAndBindUi(this));
		/*setWidget(uiBinder.createAndBindUi(this));*/
		setModal(true);
		Window.enableScrolling(false);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(88, false));

		show();
		center();
		loadingTextLbl.setVisible(true);
		populateUserCollections();
		btnCopy.getElement().setId("btnCopy");
		btnCancel.getElement().setId("lblCancel");
		loadingPanel.setVisible(false);
//		copyLabel.setVisible(false);
//		btnCancel.setVisible(false);
//		loadingPanel.setVisible(true);
		copyPopUpScrollHtmlPanel.getElement().getStyle().setVisibility(Visibility.HIDDEN);
		copyPopUpResourceListImage.getElement().removeAttribute("tabindex");
		/**
		 * on click for display list of collection in listbox
		 */
		copyPopUpResourceListImage.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (copyPopUpScrollHtmlPanel.getElement().getStyle()
						.getVisibility().equalsIgnoreCase("VISIBLE")) {
					copyPopUpScrollHtmlPanel.getElement().getStyle()
							.setVisibility(Visibility.HIDDEN);
				} else {
					copyPopUpScrollHtmlPanel.getElement().getStyle()
							.setVisibility(Visibility.VISIBLE);
				}
			}
		});

	}

	public abstract void populateUserCollections();

	/**
	 * for close copy collection popup
	 * 
	 * @param clickEvent
	 */
	@UiHandler("btnCancel")
	public void onCancelClick(ClickEvent clickEvent) {
		hide();
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));

	}

	/**
	 * on click for hide listbox when user click outside the listbox
	 */
	@UiHandler("popUpCopyCollection")
	public void onpopUpCopyCollection(ClickEvent clickEvent) {
		if (copyPopUpScrollHtmlPanel.getElement().getStyle().getVisibility()
				.equalsIgnoreCase("VISIBLE")) {
			copyPopUpScrollHtmlPanel.getElement().getStyle()
					.setVisibility(Visibility.HIDDEN);
		}

	}

	@UiHandler("btnCopy")
	public void onClickCopyBtn(ClickEvent clickEvent){
		copyLabel.setVisible(false);
		btnCancel.setVisible(false);
		loadingPanel.setVisible(true);
		onCopyClick(clickEvent);
	}
	public abstract void onCopyClick(ClickEvent clickEvent);
	
	
	/**
	 * for close copy collection popup
	 * 
	 * @param clickEvent
	 *//*
	@UiHandler("cancelButton")
	public void onCloseClick(ClickEvent clickEvent) {
		hide();
		Window.enableScrolling(true);
		AppClientFactory.fireEvent(new SetHeaderZIndexEvent(0, true));

	}*/

}
