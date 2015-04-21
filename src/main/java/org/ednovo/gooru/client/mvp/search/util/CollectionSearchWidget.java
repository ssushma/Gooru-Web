/**
 * 
 */
package org.ednovo.gooru.client.mvp.search.util;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.home.library.customize.RenameAndCustomizeLibraryPopUp;
import org.ednovo.gooru.client.mvp.search.SearchUiUtil;
import org.ednovo.gooru.client.uc.BrowserAgent;
import org.ednovo.gooru.client.uc.suggestbox.widget.Paragraph;
import org.ednovo.gooru.client.uc.tooltip.GlobalToolTip;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo;
import org.ednovo.gooru.shared.model.search.CollectionSearchResultDo;
import org.ednovo.gooru.shared.model.search.SearchDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

/**
 * @author janamitra
 *
 */
public class CollectionSearchWidget extends Composite {

	private static CollectionSearchWidgetUiBinder uiBinder = GWT
			.create(CollectionSearchWidgetUiBinder.class);

	interface CollectionSearchWidgetUiBinder extends
			UiBinder<Widget, CollectionSearchWidget> {
	}
	
	private static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	private PopupPanel toolTipPopupPanelCustomize = new PopupPanel();
	public static boolean isCustomizePopup = false;
	String CUSTOMIZE = "customize";

	@UiField HTMLPanel pnlResourceWidget,collectionDescription;
	@UiField Label collectionTitle,authorName,lblViewCount;
	@UiField Paragraph pResourceText;
	@UiField Image imgAuthor,imgCollection;
	@UiField FlowPanel standardsDataPanel;
	@UiField Button remixBtn;
	
	private static String DEFULT_IMAGE = "images/default-collection-image.png";
	
	public CollectionSearchWidget(final CollectionSearchResultDo collectionSearchResultDo) {
		initWidget(uiBinder.createAndBindUi(this));
		//set the data
		imgAuthor.setUrl(collectionSearchResultDo.getAssetURI()+collectionSearchResultDo.getOwner().getGooruUId()+".png");
		imgAuthor.addErrorHandler(new ErrorHandler() {
			@Override
			public void onError(ErrorEvent event) {
				imgAuthor.setUrl("images/settings/setting-user-image.png");
			}
		});
		
		toolTipPopupPanelCustomize.clear();
		toolTipPopupPanelCustomize.hide();
		remixBtn.addMouseOverHandler(new OncustomizeCollectionBtnMouseOver());
		remixBtn.addMouseOutHandler(new OncustomizeCollectionBtnMouseOut());
	
		collectionTitle.setText(collectionSearchResultDo.getResourceTitle());
		
		remixBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				onremixBtnClicked(collectionSearchResultDo.getGooruOid(), collectionSearchResultDo.getResourceTitle());
				
			}
		});
		String collectionDesc=collectionSearchResultDo.getDescription();
		collectionDescription.getElement().setAttribute("title", collectionDesc);
		if(!StringUtil.isEmpty(collectionDesc)){
			if(collectionDesc.length()>=120){
				collectionDesc=collectionDesc.substring(0,120)+"...";
			}
			collectionDescription.getElement().setInnerText(collectionDesc);
		}
		authorName.setText(collectionSearchResultDo.getOwner().getUsername());
		if(!StringUtil.isEmpty(collectionSearchResultDo.getUrl())){
			imgCollection.setUrl(StringUtil.formThumbnailName(collectionSearchResultDo.getUrl(), "-160x120."));
		}
		imgCollection.addErrorHandler(new ErrorHandler() {

			@Override
			public void onError(ErrorEvent event) {
				imgCollection.setUrl(DEFULT_IMAGE);
			}
		});
		imgCollection.addClickHandler(new OnCollectionImageClick(collectionSearchResultDo.getGooruOid()));
		imgCollection.getElement().getStyle().setZIndex(9999);
		//imgCollection.setGooruOid(collectionSearchResultDo.getGooruOid());
		lblViewCount.setText(collectionSearchResultDo.getTotalViews()+"");
		String resourceText="";
		if(collectionSearchResultDo.getResourceCount()>4){
			resourceText="4 "+i18n.GL_GRR_OF()+" "+i18n.GL_GRR_THE()+" "+collectionSearchResultDo.getResourceCount()+" "+i18n.GL1094();
		}else{
			resourceText=collectionSearchResultDo.getResourceCount()+" "+i18n.GL_GRR_OF()+" "+i18n.GL_GRR_THE()+" "+collectionSearchResultDo.getResourceCount()+" "+i18n.GL1094();
		}
		pResourceText.setText(resourceText);
		if(collectionSearchResultDo.getCollectionItems().size()>0){
			int count=0;
				for (CollectionItemDo collectionItemSearchResultDo :collectionSearchResultDo.getCollectionItems()) {
					if(count>=4){
						break;
					}
					pnlResourceWidget.add(new ResourceImageWidget(collectionItemSearchResultDo.getResource()));
					count++;
				}
		}
		SearchUiUtil.renderStandards(standardsDataPanel, collectionSearchResultDo);
	}
	/**
	 * 
	 * @function oncustomizeCollectionBtnClicked 
	 * 
	 * @created_date : 11-Dec-2013
	 * 
	 * @description
	 * 
	 * 
	 * @parm(s) : @param clickEvent
	 * 
	 * @return : void
	 *category
	 * @throws : <Mentioned if any exceptions>
	 *
	 */

	public void onremixBtnClicked(String collectionId,String collectionTitle) {
		toolTipPopupPanelCustomize.clear();
		toolTipPopupPanelCustomize.hide();

		final Map<String, String> params = StringUtil.splitQuery(Window.Location.getHref());
			Boolean loginFlag = false;
			if (AppClientFactory.isAnonymous()){
				loginFlag = true;
			}else{
				loginFlag = false;
			}
			RenameAndCustomizeLibraryPopUp successPopupVc = new RenameAndCustomizeLibraryPopUp(collectionId, loginFlag, collectionTitle) {
				@Override
				public void closePoup() {
					Window.enableScrolling(true);
					this.hide();	
				}
			};
			Window.scrollTo(0, 0);
			if (!BrowserAgent.isDevice() && AppClientFactory.isAnonymous()){
				successPopupVc.setWidth("500px");
				successPopupVc.setHeight("515px");
			}else if(!BrowserAgent.isDevice() && !AppClientFactory.isAnonymous()){
				successPopupVc.setWidth("500px");
				successPopupVc.setHeight("336px");
			}
			successPopupVc.show();
			successPopupVc.center();
			
			params.put(CUSTOMIZE, "yes");
			params.put("collectionId", collectionId);
			PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(AppClientFactory.getCurrentPlaceToken(), params);
			AppClientFactory.getPlaceManager().revealPlace(false, placeRequest, true);
	}
	public class OncustomizeCollectionBtnMouseOver implements MouseOverHandler{
		@Override
		public void onMouseOver(MouseOverEvent event) {
			toolTipPopupPanelCustomize.clear();
			toolTipPopupPanelCustomize.setWidget(new GlobalToolTip(i18n.GL0677()));
			toolTipPopupPanelCustomize.setStyleName("");
			toolTipPopupPanelCustomize.setPopupPosition(remixBtn.getElement().getAbsoluteLeft()+18, remixBtn.getElement().getAbsoluteTop()+10);
			toolTipPopupPanelCustomize.getElement().getStyle().setZIndex(999999);
			toolTipPopupPanelCustomize.show();
		}
		
	}
	
	public class OncustomizeCollectionBtnMouseOut implements MouseOutHandler{
		@Override
		public void onMouseOut(MouseOutEvent event) {
			toolTipPopupPanelCustomize.hide();
		}
	}
	/**
	 * This inner class will handle the click event on the collection image click
	 * @author Gooru
	 */
	public class OnCollectionImageClick implements ClickHandler{
		String gooruOid;
		OnCollectionImageClick(String gooruOid){
			this.gooruOid=gooruOid;
		}
		@Override
		public void onClick(ClickEvent event) {
			Map<String, String> params = new HashMap<String, String>();
			params.put("id", gooruOid);
			Cookies.setCookie("getScrollTop", Window.getScrollTop()+"");
			PlaceRequest placeRequest=AppClientFactory.getPlaceManager().preparePlaceRequest(PlaceTokens.COLLECTION_PLAY, params);
			AppClientFactory.getPlaceManager().revealPlace(false,placeRequest,true);
		}
	}
}
