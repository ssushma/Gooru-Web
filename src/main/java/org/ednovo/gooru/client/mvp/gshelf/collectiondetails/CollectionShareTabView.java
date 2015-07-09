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
package org.ednovo.gooru.client.mvp.gshelf.collectiondetails;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.application.client.PlaceTokens;
import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.application.shared.model.content.ClassPageCollectionDo;
import org.ednovo.gooru.application.shared.model.content.CollectionDo;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionConfirmationPopup;
import org.ednovo.gooru.client.mvp.shelf.collection.CollectionShareAlertPopup;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.collaborators.vc.SuccessPopupViewVc;
import org.ednovo.gooru.client.mvp.shelf.event.CollectionAssignShareEvent;
import org.ednovo.gooru.client.mvp.shelf.event.EmbedEnableEvent;
import org.ednovo.gooru.client.mvp.shelf.event.PublishButtonHideEvent;
import org.ednovo.gooru.client.uc.tooltip.GlobalToolTip;
import org.ednovo.gooru.client.ui.HTMLEventPanel;
import org.ednovo.gooru.client.util.MixpanelUtil;
import org.ednovo.gooru.shared.util.ClientConstants;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * @author Search Team
 *
 */
public class CollectionShareTabView extends BaseViewWithHandlers<CollectionShareTabUiHandlers> implements IsCollectionShareTabView {

	private static CollectionShareTabViewUiBinder uiBinder = GWT.create(CollectionShareTabViewUiBinder.class);

	@UiTemplate("CollectionShareTabView.ui.xml")
	interface CollectionShareTabViewUiBinder extends UiBinder<Widget, CollectionShareTabView> {
	}	

	@UiField TextArea shareTextArea;
	@UiField Anchor bitlyLink,embedLink;
	@UiField HTMLEventPanel privateShareFloPanel,publicShareFloPanel,linkShareFloPanel;
	@UiField HTMLPanel rbPublicPanel,publishedPanel;
	@UiField Button rbPublic;
	@UiField Label lblPublishPending,lblPublish;
     
	FolderDo collectionDo;

	public static MessageProperties i18n = GWT.create(MessageProperties.class);

	private String shareUrl="";

	private String shareBitlyUrl="";

	private String embedurl="";
	private String embedBitlyUrl="";
	
	private static final String FOLDER="Folder";
	private static final String VIEW="view";
	
	private static String CONFIRM_MESSAGE = i18n.GL1490()+i18n.GL_SPL_EXCLAMATION();

	private Map<String, String> collectionShareMap=null;
	private CollectionShareAlertPopup collectionShareAlertPopup;
	
	private CollectionConfirmationPopup collectionConfirmationPopup;
	
	private PopupPanel toolTipPopupPanel=new PopupPanel();

	/**
	 * Class constructor 
	 * @param eventBus {@link EventBus}
	 */
	@Inject
	public CollectionShareTabView() {
		setWidget(uiBinder.createAndBindUi(this));
		privateShareFloPanel.addClickHandler(new OnPrivateClick());
		linkShareFloPanel.addClickHandler(new OnLinkClick());
		if(AppClientFactory.getLoggedInUser().getConfirmStatus()==1){
			publicShareFloPanel.addClickHandler(new OnPublicClick());
			rbPublic.addClickHandler(new OnPublicClick());
		}else{
			publicShareFloPanel.addMouseOverHandler(new MouseOverHandler() {
				
				@Override
				public void onMouseOver(MouseOverEvent event) {
					toolTipPopupPanel.clear();
					toolTipPopupPanel.setWidget(new GlobalToolTip(CONFIRM_MESSAGE));
					toolTipPopupPanel.setStyleName("");
					toolTipPopupPanel.setPopupPosition(publicShareFloPanel.getElement().getAbsoluteLeft()+105, publicShareFloPanel.getElement().getAbsoluteTop()+25);
					toolTipPopupPanel.show();
				}
			});
			
			publicShareFloPanel.addMouseOutHandler(new MouseOutHandler() {
				
				@Override
				public void onMouseOut(MouseOutEvent event) {
				toolTipPopupPanel.hide();
				}
			});
		}
	}
	
	
	@Override
	public void setData(FolderDo collectionDo) {
		this.collectionDo = collectionDo;
		System.out.println("collectionDo::"+collectionDo.getSharing());
		String view = AppClientFactory.getPlaceManager().getRequestParameter("view", null);
		if(view!=null && FOLDER.equalsIgnoreCase(view)){
			privateShareFloPanel.setVisible(true);
		}else{
			privateShareFloPanel.setVisible(false);
		}
		if(collectionDo.getSharing()!=null){
			if(collectionDo.getSharing().equals("public")) {
				publicShareFloPanel.removeStyleName("inActive");
				privateShareFloPanel.addStyleName("inActive");
				linkShareFloPanel.addStyleName("inActive");
				//isSharable = true;
					if(collectionDo.getPublishStatus()!=null && collectionDo.getPublishStatus().equalsIgnoreCase("reviewed")){
							rbPublic.setVisible(false);
							lblPublishPending.setVisible(false);
							publishedPanel.setVisible(true);
					}
			}else if(collectionDo.getSharing()!=null && collectionDo.getSharing().equals("private")) {
				privateShareFloPanel.removeStyleName("inActive");
				publicShareFloPanel.addStyleName("inActive");
				linkShareFloPanel.addStyleName("inActive");
				//isSharable = false;
					if(collectionDo.getPublishStatus()!=null && collectionDo.getPublishStatus().equalsIgnoreCase("pending")){
							//selectPrivateResource("pending");
							rbPublic.setVisible(false);
							lblPublishPending.setVisible(true);
							publishedPanel.setVisible(false);
					}else{
						//selectPrivateResource("private");
					}
			}else {
				linkShareFloPanel.removeStyleName("inActive");
				privateShareFloPanel.addStyleName("inActive");
				publicShareFloPanel.addStyleName("inActive");
				//isSharable = true;
				if(collectionDo.getPublishStatus()!=null && collectionDo.getPublishStatus().equalsIgnoreCase("pending")){
						//selectPrivateResource("pending");
						rbPublic.setVisible(false);
						lblPublishPending.setVisible(true);
						publishedPanel.setVisible(false);
				}else{
					//selectPrivateResource("shareable");
				}
			}
		}
		
	}

	@Override
	public void setCollectionShareData(Map<String, String> shareUrlsList){
		collectionShareMap=new HashMap<String,String>();
		if(shareUrlsList!=null){
			shareBitlyUrl = shareUrlsList.get(ClientConstants.SHORTENURL).toString();
			//shareUrl= shareUrlsList.get(ClientConstants.DECODERAWURL).toString();
			embedurl=shareUrlsList.get(ClientConstants.EMBEDURLRAWURL).toString();
			setIframeUrl(embedurl);		
		}
		collectionShareMap.put(i18n.GL0643_1(), shareUrl);
		collectionShareMap.put(i18n.GL0639_1(), shareBitlyUrl);
		embedLink.setText(i18n.GL0640_1());
		embedLink.getElement().setAttribute("alt",i18n.GL0640_1());
		embedLink.getElement().setAttribute("title",i18n.GL0640_1());

		bitlyLink.setText(i18n.GL0639_1());
		bitlyLink.getElement().setAttribute("alt",i18n.GL0639_1());
		bitlyLink.getElement().setAttribute("title",i18n.GL0639_1());

		shareTextArea.setText(shareUrl);
		shareTextArea.getElement().setAttribute("alt",shareUrl);
		shareTextArea.getElement().setAttribute("title",shareUrl);
	}

	public void setIframeUrl(String iframeBitlyUrl){
		embedBitlyUrl = "<iframe width=\"1024px\" height=\"768px\" src=\"" + iframeBitlyUrl + "\" frameborder=\"0\" ></iframe>";
		collectionShareMap.put(i18n.GL0640_1(), embedBitlyUrl);
	}

	@UiHandler("embedLink")
	public void onClickEmbedLink(ClickEvent clickEvent){
		String shareTxt=shareTextArea.getText();
		String embed=embedLink.getText();
		Iterator<String> keyIterator =null;

		keyIterator=collectionShareMap.keySet().iterator();

		while(keyIterator.hasNext()){
			String key = keyIterator.next();
			String value = collectionShareMap.get(key);
			if(shareTxt.equalsIgnoreCase(value)){
				embedLink.setText(key);
				embedLink.getElement().setAttribute("alt",key);
				embedLink.getElement().setAttribute("title",key);
				shareTextArea.setText(collectionShareMap.get(embed));
				shareTextArea.getElement().setAttribute("alt",collectionShareMap.get(embed));
				shareTextArea.getElement().setAttribute("title",collectionShareMap.get(embed));

			}
		}
	}

	@UiHandler("shareTextArea")
	public void onClickshareTextArea(ClickEvent clickEvent){
		shareTextArea.selectAll();
		shareTextArea.setFocus(true);
	}

	@UiHandler("bitlyLink")
	public void onClickBitlyLink(ClickEvent clickEvent){
		String shareTxt=shareTextArea.getText();
		String linkUrl=bitlyLink.getText();
		Iterator<String> keyIterator =null;
		keyIterator=collectionShareMap.keySet().iterator();
		while(keyIterator.hasNext()){
			String key = keyIterator.next();
			String value= collectionShareMap.get(key);
			if(shareTxt.equalsIgnoreCase(value)){
				bitlyLink.setText(key);
				bitlyLink.getElement().setAttribute("alt",key);
				bitlyLink.getElement().setAttribute("title",key);
				shareTextArea.setText(collectionShareMap.get(linkUrl));
				shareTextArea.getElement().setAttribute("alt",collectionShareMap.get(linkUrl));
				shareTextArea.getElement().setAttribute("title",collectionShareMap.get(linkUrl));
			}
		}
	}

	@Override
	public void setShareUrl(String shareUrl) {
		this.shareUrl=shareUrl;
	}
	
	/**
	 * @author Search Team Updated sharing type , change the collection as
	 *         private
	 */
	private class OnPrivateClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			MixpanelUtil.Organize_Visibility_Private();
			final String collectionId=AppClientFactory.getPlaceManager().getRequestParameter("id");
			if(privateShareFloPanel.getStyleName().contains("inActive")) {
			AppClientFactory.getInjector().getClasspageService().getCollectionClasspageAssoc(collectionId, new SimpleAsyncCallback<List<ClassPageCollectionDo>>() {

				@Override
				public void onSuccess(List<ClassPageCollectionDo> result) {

					if(result.size()!=0){

						StringBuffer sb = new StringBuffer();
						for(int i=0;i<result.size();i++){
							if (result.size() >1){
								if(i==result.size()-1){
									sb.append(" "+i18n.GL_GRR_AND()+" ");
								}else{
									if (i==0){
									}else{
										sb.append(i18n.GL_GRR_COMMA()+" ");
									}
								}
							}
							sb.append(result.get(i).getTitle());
						}
						if(result.size()>1){
							sb.append(" "+i18n.GL1154()+".");
						}else{
							sb.append(" "+i18n.GL0102()+".");
						}
						
						 String titles=sb.toString();
						 collectionConfirmationPopup=new CollectionConfirmationPopup();
						 collectionConfirmationPopup.getClassPageNames().setText(titles);
						 collectionConfirmationPopup.getOkButtonMethod().addClickHandler(new ClickHandler() {
							 
							@Override
							public void onClick(ClickEvent event) {
										collectionConfirmationPopup.hide();
										privateShareFloPanel.removeStyleName("inActive");
										publicShareFloPanel.addStyleName("inActive");
										linkShareFloPanel.addStyleName("inActive");
										updateShare("private");
									//	selectPrivateResource("private");
							}
						});
						 
						 
					}else{
						
						collectionShareAlertPopup = new CollectionShareAlertPopup() {
							@Override
							public void setPublicFromAlert() {
								if(collectionDo.getSharing().equalsIgnoreCase("public")){
									privateShareFloPanel.removeStyleName("inActive");
									publicShareFloPanel.addStyleName("inActive");
									linkShareFloPanel.addStyleName("inActive");
									updateShare("private");
									//selectPrivateResource("private");
								}
								
							}
						};
						if(collectionDo.getSharing().equalsIgnoreCase("public")){
							 collectionShareAlertPopup.confirmPopup();
						}else{
							privateShareFloPanel.removeStyleName("inActive");
							publicShareFloPanel.addStyleName("inActive");
							linkShareFloPanel.addStyleName("inActive");
							updateShare("private");
							//selectPrivateResource("private");
						}
					}
				}
			});
			
			}
		}
	}
	
	/**
	 * @author Search Team Updated sharing type , change the collection as
	 *         anyonewithlink
	 */
	private class OnLinkClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			MixpanelUtil.Organize_Visibility_Shareable();
			if(linkShareFloPanel.getStyleName().contains("inActive")) {
				collectionShareAlertPopup = new CollectionShareAlertPopup() {
					@Override
					public void setPublicFromAlert() {
						if(collectionDo.getSharing().equalsIgnoreCase("public")){
							linkShareFloPanel.removeStyleName("inActive");
							privateShareFloPanel.addStyleName("inActive");
							publicShareFloPanel.addStyleName("inActive");
							updateShare("anyonewithlink");
						}
					}
				};
				if(collectionDo.getSharing().equalsIgnoreCase("public")){
					 collectionShareAlertPopup.confirmPopup();
				}else{
					linkShareFloPanel.removeStyleName("inActive");
					privateShareFloPanel.addStyleName("inActive");
					publicShareFloPanel.addStyleName("inActive");
					updateShare("anyonewithlink");
				}
				
			}
		}
	}
	/**
	 * update collection sharing as sharing or public or anyonewithlink
	 * 
	 * @param share
	 */
	private void updateShare(final String share) {
		
		AppClientFactory.getInjector().getResourceService().updateCollectionMetadata(collectionDo.getGooruOid(), null, null,
						null, share, null, null, null, null, null, new SimpleAsyncCallback<CollectionDo>() {
							@Override
							public void onSuccess(CollectionDo result) {
								final boolean isSharable;
								if (result.getSharing().equalsIgnoreCase("private")) {
									isSharable = false;
								}else if (result.getSharing().equalsIgnoreCase("anyonewithlink")) {
									isSharable = true;
								}else {
									isSharable = true;
								}
								if(result.getSharing().equalsIgnoreCase(share)){
									if(result.getPublishStatus()!=null){
										if(result.getPublishStatus().getValue().equals("reviewed")){
										//	publishedPanel.setVisible(true);
										//	rbPublic.setVisible(false);
										//	lblPublishPending.setVisible(false);
											publicShareFloPanel.removeStyleName("inActive");
											privateShareFloPanel.addStyleName("inActive");
											linkShareFloPanel.addStyleName("inActive");
											//selectPrivateResource("public");
										}
									}else{
										//publishedPanel.setVisible(false);
										//rbPublic.setVisible(true);
										//lblPublishPending.setVisible(false);
									}
									
								}else{
									//publishedPanel.setVisible(false);
									//rbPublic.setVisible(false);
									//lblPublishPending.setVisible(true);
								}
								
								if(result!=null && result.getPublishStatus()!=null && result.getPublishStatus().getValue()!=null){
									AppClientFactory.fireEvent(new CollectionAssignShareEvent(result.getSharing(),result.getPublishStatus().getValue(),true,result));
								}else{
									AppClientFactory.fireEvent(new CollectionAssignShareEvent(result.getSharing(),null,true,result));
								}
								AppClientFactory.fireEvent(new EmbedEnableEvent(isSharable));

								//contentpanel.clear();
								//addSocialResource(result.getSharing());
								AppClientFactory.fireEvent(new CollectionAssignShareEvent(result.getSharing(),"",false,result));
							}
				});
	}

	/**
	 * @author Search Team Updated sharing type , change the collection as
	 *         public
	 * 
	 */
	private class OnPublicClick implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			MixpanelUtil.Organize_Visibility_Public();
			clickOnPublic();
		}
	}

	public void clickOnPublic(){
		System.out.println("clickonPublic"+publicShareFloPanel.getStyleName().contains("isActive"));
		if(publicShareFloPanel.getStyleName().contains("isActive")) {
			System.out.println("clickonPublic");
			if(!lblPublishPending.isVisible()){
				collectionShareAlertPopup = new CollectionShareAlertPopup() {
					@Override
					public void setPublicFromAlert() {
						SuccessPopupViewVc success = new SuccessPopupViewVc() {
							@Override
							public void onClickPositiveButton(ClickEvent event) {
								if(AppClientFactory.isContentAdmin()){
									AppClientFactory.fireEvent(new PublishButtonHideEvent());
								}
								this.hide();
								updateShare("public");
								if (AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equalsIgnoreCase(PlaceTokens.SEARCH_COLLECTION) || AppClientFactory.getPlaceManager().getCurrentPlaceRequest().getNameToken().equalsIgnoreCase(PlaceTokens.SEARCH_RESOURCE)){
									Window.enableScrolling(false);
								}else{
									Window.enableScrolling(true);
								}
							}
						};
						success.setPopupTitle(i18n.GL0501());
	                    success.setDescText(i18n.GL1917()+"<br>"+i18n.GL1918());
	                    success.setPositiveButtonText(i18n.GL0190());
					}
				};
				//collectionShareAlertPopup.setPublicMsgData(coll);
			}
		}
	}
}
