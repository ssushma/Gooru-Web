package org.ednovo.gooru.client.mvp.gshelf.collectiondetails.widgets;

import org.ednovo.gooru.application.client.gin.AppClientFactory;
import org.ednovo.gooru.application.shared.i18n.MessageProperties;
import org.ednovo.gooru.client.mvp.search.CenturySkills.AddCenturyPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class CenturySkillsView extends Composite {


	@UiField Button centbrowseBtn;
	
	private static DepthKnowledgeViewUiBinder uiBinder = GWT.create(DepthKnowledgeViewUiBinder.class);

	interface DepthKnowledgeViewUiBinder extends UiBinder<Widget, CenturySkillsView> {
	}

	static MessageProperties i18n = GWT.create(MessageProperties.class);
	
	
	public CenturySkillsView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	
	public void init(){
		centbrowseBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				getAddCentury();
			}
		});
	}
	
	public void getAddCentury() {
		AddCenturyPresenter addCenturyPresenter = null;

		/*addCenturyPresenter.getView().resetPopupHilightedData();
		addCenturyPresenter.getSelectedValues().clear();
		if(getView().getSelectedCenturyValuesThroughAutosuggest().size()> 0){
			addCenturyPresenter.setAddResourceData(getView().getSelectedCenturyValuesThroughAutosuggest());
		}
		String collectionUid = AppClientFactory.getPlaceManager().getRequestParameter("id",null);
		if(collectionUid!=null){
			addCenturyPresenter.setCollectionIdFromCollectionInfo(collectionUid,getView().getSelectedCenturyValuesThroughAutosuggest());
			addToPopupSlot(addCenturyPresenter);
			getView().OnCenturyClickEvent(addCenturyPresenter.getAddButton());
		}*/
	}

	
}
