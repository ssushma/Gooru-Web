/**
 * 
 */
package org.ednovo.gooru.client.mvp.search.util;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.uc.CollectionImageUc;
import org.ednovo.gooru.client.uc.suggestbox.widget.Paragraph;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.search.CollectionItemSearchResultDo;
import org.ednovo.gooru.shared.model.search.CollectionSearchResultDo;
import org.ednovo.gooru.shared.model.search.SearchDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

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

	@UiField HTMLPanel pnlResourceWidget,collectionDescription;
	@UiField Label collectionTitle,authorName,lblViewCount;
	@UiField CollectionImageUc imgCollection;
	@UiField Paragraph pResourceText;
	
	public CollectionSearchWidget(CollectionSearchResultDo collectionSearchResultDo) {
		initWidget(uiBinder.createAndBindUi(this));
		//set the data
		collectionTitle.setText(collectionSearchResultDo.getResourceTitle());
		String collectionDesc=collectionSearchResultDo.getDescription();
		if(!StringUtil.isEmpty(collectionDesc)){
			if(collectionDesc.length()>50){
				collectionDesc=collectionDesc.substring(0, 50)+"...";
			}
			collectionDescription.getElement().setInnerText(collectionDesc);
		}
		authorName.setText(collectionSearchResultDo.getOwner().getUsername());
		imgCollection.setUrl(collectionSearchResultDo.getUrl(),collectionSearchResultDo.getResourceTitle());
		imgCollection.getElement().getStyle().setZIndex(9999);
		imgCollection.setGooruOid(collectionSearchResultDo.getGooruOid());
		lblViewCount.setText(collectionSearchResultDo.getTotalViews()+"");
		String resourceText="";
		if(collectionSearchResultDo.getResourceCount()>4){
			resourceText="4 "+i18n.GL_GRR_OF()+" "+i18n.GL_GRR_THE()+" "+collectionSearchResultDo.getResourceCount()+" "+i18n.GL1094();
		}else{
			resourceText=collectionSearchResultDo.getResourceCount()+" "+i18n.GL_GRR_OF()+" "+i18n.GL_GRR_THE()+" "+collectionSearchResultDo.getResourceCount()+" "+i18n.GL1094();
		}
		pResourceText.setText(resourceText);
		if(collectionSearchResultDo.getGooruOid()!=null){
			AppClientFactory.getInjector().getSearchService().getCollectionItems(collectionSearchResultDo.getGooruOid(), new SimpleAsyncCallback<SearchDo<CollectionItemSearchResultDo>>() {
				@Override
				public void onSuccess(SearchDo<CollectionItemSearchResultDo> result) {
					int size=result.getSearchResults().size();
					int count=0;
					if(size>0){
						for (CollectionItemSearchResultDo collectionItemSearchResultDo : result.getSearchResults()) {
							if(count>=4){
								break;
							}
							pnlResourceWidget.add(new ResourceImageWidget());
							count++;
						}
					}
				}
			});
		}
	}
}
