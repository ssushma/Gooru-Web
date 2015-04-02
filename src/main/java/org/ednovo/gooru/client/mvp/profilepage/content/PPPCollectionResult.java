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
package org.ednovo.gooru.client.mvp.profilepage.content;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.search.SearchUiUtil;
import org.ednovo.gooru.client.uc.CollectionImageUc;
import org.ednovo.gooru.client.uc.SeparatorUc;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

/**
 * @author Gooru Team
 * 
 */

public class PPPCollectionResult extends Composite{
	
	private static PPPCollectionResultUiBinder uiBinder = GWT.create(PPPCollectionResultUiBinder.class);

	interface PPPCollectionResultUiBinder extends UiBinder<Widget, PPPCollectionResult> {
	}
	
	private MessageProperties i18n = GWT.create(MessageProperties.class);
	
	@UiField
	Label resourceCountLbl;
	//creatorNameLbl,creatorNameLblValue
	@UiField
	HTML collectionDescriptionHtml,collectionTitleLbl;

	@UiField
	FlowPanel collectionTitlePanel,metaDataPanelFloPanel, standardsFloPanel;

	@UiField
	CollectionImageUc collectionImageUc;

	@UiField(provided = true)
	PPPCollectionSearchResultWrapperVc wrapperVc;

	@UiField(provided = true)
	PPPCollectionResultCBundle res;

	private CollectionItemDo collectionItemDo;
	
//	private static final String VIEWS =" "+i18n.GL1099;
	
//	private static final String CREATED_BY = "Created by ";
	
//	private static final String RESOURCES =i18n.GL0174;
	
//	private static final String RESOURCE = " "+i18n.GL1110;
	
	/**
	 * Class constructor, creates new instance of PPPCollectionSearchResultWrapperVc and call collection search result setData method
	 * @param collectionItemDo instance {@link CollectionItemDo}
	 */
	public PPPCollectionResult(CollectionItemDo collectionItemDo) { 
		wrapperVc = new PPPCollectionSearchResultWrapperVc(collectionItemDo.getResource().getGooruOid());
		this.res = PPPCollectionResultCBundle.INSTANCE;
		res.css().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));
		setData(collectionItemDo);
		wrapperVc.addStyleName("collectionSearchResultBox");
	}
	

	/**
	 * Set PPP collection meta info such as collection title, image, creator, etc..
	 * @param collectionItemDo instance of {@link CollectionItemDo}
	 */
	public void setData(CollectionItemDo collectionItemDo) {
		
		this.collectionItemDo = collectionItemDo;
		wrapperVc.setData(collectionItemDo);
		collectionTitleLbl.setHTML(StringUtil.truncateText(collectionItemDo.getResourceTitle(), 40));
		collectionTitleLbl.getElement().setId("htmlCollectionTitleLbl");
		collectionTitleLbl.getElement().setAttribute("alt",StringUtil.truncateText(collectionItemDo.getResourceTitle(), 40));
		collectionTitleLbl.getElement().setAttribute("title",StringUtil.truncateText(collectionItemDo.getResourceTitle(), 40));
		
		//creatorNameLbl.setText(CREATED_BY);
		//creatorNameLblValue.setText(" "+collectionItemDo.getCreator().getUsernameDisplay());
		collectionDescriptionHtml.setHTML(collectionItemDo.getDescription());
		collectionDescriptionHtml.getElement().setId("htmlCollectionDescriptionHtml");
		collectionDescriptionHtml.getElement().setAttribute("alt",collectionItemDo.getDescription());
		collectionDescriptionHtml.getElement().setAttribute("title",collectionItemDo.getDescription());
		
		SearchUiUtil.renderMetaData(metaDataPanelFloPanel, collectionItemDo.getCourse(), 30);
		SearchUiUtil.renderMetaData(metaDataPanelFloPanel, collectionItemDo.getViews() + "", " "+i18n.GL1099());
		metaDataPanelFloPanel.add(new SeparatorUc());
		collectionImageUc.setUrl(collectionItemDo.getUrl(),collectionItemDo.getResourceTitle());
//		collectionImageUc.getElement().getStyle().setZIndex(9999);
		collectionImageUc.setGooruOid(collectionItemDo.getGooruOid());
		resourceCountLbl.getElement().setId("lblResourceCountLbl");
		if(collectionItemDo.getResourceCount()==1)
		{
			resourceCountLbl.setText(collectionItemDo.getResourceCount() +  " "+i18n.GL1110());
			resourceCountLbl.getElement().setAttribute("alt",collectionItemDo.getResourceCount() +  " "+i18n.GL1110());
			resourceCountLbl.getElement().setAttribute("title",collectionItemDo.getResourceCount() +  " "+i18n.GL1110());
		}
		else{
		resourceCountLbl.setText(collectionItemDo.getResourceCount() +" "+i18n.GL0174());
		resourceCountLbl.getElement().setAttribute("alt",collectionItemDo.getResourceCount() +" "+i18n.GL0174());
		resourceCountLbl.getElement().setAttribute("title",collectionItemDo.getResourceCount() +" "+i18n.GL0174());
		}
		SearchUiUtil.renderStandards(standardsFloPanel, collectionItemDo);
		collectionTitlePanel.getElement().setId("fpnlCollectionTitlePanel");
		standardsFloPanel.getElement().setId("fpnlStandardsFloPanel");
	}

	/*
	 * opens the More Info Disclosure panel.
	 */
	public void openDisclosurePanel() {
		wrapperVc.discloseCollectionMoreInfoTab();
	}
	
	/**
	 * Added click handler to play Collection
	 * @param clickEvent instance of {@link ClickEvent} 
	 **/
	
	@UiHandler("collectionTitleLbl")
	public void onClickCollectionTitle(ClickEvent event){
		MixpanelUtil.Preview_Collection_From_Profile("CollectionTitleLbl");
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", collectionItemDo.getResource().getGooruOid());
		com.google.gwt.user.client.Window.scrollTo(0, 0);
		PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.COLLECTION_PLAY, params);
		AppClientFactory.getPlaceManager().revealPlace(false,placeRequest,true);
	}
	
	/**
	 * @return type of {@link PPPCollectionSearchResultWrapperVc}
	 */
	public PPPCollectionSearchResultWrapperVc getSearchResultVc() {
		return wrapperVc;
	}

	/**
	 * Assign {@link PPPCollectionSearchResultWrapperVc} instance
	 * @param searchResultVc instance of {@link PPPCollectionSearchResultWrapperVc}
	 */
	public void setSearchResultVc(PPPCollectionSearchResultWrapperVc searchResultVc) {
		this.wrapperVc = searchResultVc;
	}

}
