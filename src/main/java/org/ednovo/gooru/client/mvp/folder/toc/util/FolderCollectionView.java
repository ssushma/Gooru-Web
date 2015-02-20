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
package org.ednovo.gooru.client.mvp.folder.toc.util;

import java.util.HashMap;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.uc.H4Panel;
import org.ednovo.gooru.shared.model.folder.FolderDo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
/**
 * @fileName : FolderCollectionView.java
 *
 * @description : 
 *
 * @version : 1.3
 *
 * @date: 06-02-2015
 *
 * @Author Gooru Team
 *
 * @Reviewer: 
 */
public class FolderCollectionView extends Composite {

	private static FolderCollectionViewUiBinder uiBinder = GWT
			.create(FolderCollectionViewUiBinder.class);

	interface FolderCollectionViewUiBinder extends
			UiBinder<Widget, FolderCollectionView> {
	}
	@UiField FlowPanel pnlResources;
	@UiField H4Panel lblCollectionTitle;
	@UiField Label lblCollectionDesc;
	FolderTocCBundle res;
	
	final String ASSESSMENTURL="assessment/url";
	
	public FolderCollectionView(String levelStyleName,final FolderDo folderDo) {
		this.res = FolderTocCBundle.INSTANCE;
		res.css().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));
		if(folderDo.getTitle()!=null && !folderDo.getTitle().isEmpty()){
			lblCollectionTitle.setText(folderDo.getTitle());
		}
		if(folderDo.getDescription()!=null && !folderDo.getDescription().isEmpty()){
			lblCollectionDesc.setText(folderDo.getDescription());
		}
		 if(folderDo.getCollectionItems().size()>0){
			 pnlResources.add(new FolderCollectionResourceView(folderDo));
		 }
		 lblCollectionTitle.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(ASSESSMENTURL.equalsIgnoreCase(folderDo.getCollectionType())){
					AppClientFactory.getInjector().getResourceService().getAssessmentUrl(folderDo.getGooruOid(), new AsyncCallback<String>() {
						@Override
						public void onSuccess(String result) {
							Window.open(result, "", "");
						}
						@Override
						public void onFailure(Throwable caught) {}
					});
				}else{
					HashMap<String,String> params = new HashMap<String,String>();
					params.put("id", folderDo.getGooruOid());
					PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.COLLECTION_PLAY, params);
					AppClientFactory.getPlaceManager().revealPlace(false,placeRequest,true);
				}
			}
		});
	}
}
