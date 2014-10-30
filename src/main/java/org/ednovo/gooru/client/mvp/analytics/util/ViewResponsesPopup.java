package org.ednovo.gooru.client.mvp.analytics.util;

import java.util.ArrayList;

import org.ednovo.gooru.shared.model.analytics.OetextDataDO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class ViewResponsesPopup extends PopupPanel {
	
	private static ViewResponsesPopupUiBinder uiBinder = GWT
			.create(ViewResponsesPopupUiBinder.class);

	interface ViewResponsesPopupUiBinder extends
			UiBinder<Widget, ViewResponsesPopup> {
	}
	
	@UiField HTMLPanel viewResponsepnl;
	@UiField Label totalResponselbl;
	public ViewResponsesPopup(String questionCount,String questionText,String questionAnswers) {
		setWidget(uiBinder.createAndBindUi(this));
		setCollectionProgressData(questionCount, questionText, questionAnswers);
	}
	
	public ViewResponsesPopup(ArrayList<OetextDataDO> result,String resourceGooruId,String collectionId, String classpageId,String pathwayId,String questionType,boolean isSummary) {
		setWidget(uiBinder.createAndBindUi(this));
		setPopUpData(result,resourceGooruId,collectionId,classpageId,pathwayId,questionType,isSummary);
	}
	void setCollectionProgressData(String questionCount,String questionText,String questionAnswers){
		viewResponsepnl.clear();
		totalResponselbl.setVisible(false);
		ViewResponseUserWidget responseUserWidget=new ViewResponseUserWidget(questionCount, questionText, questionAnswers);
		viewResponsepnl.add(responseUserWidget);
	}
	void setPopUpData(ArrayList<OetextDataDO> result,String resourceGooruId,String collectionId, String classpageId,String pathwayId,String questionType,boolean isSummary){
		viewResponsepnl.clear();
		totalResponselbl.setVisible(true);
		totalResponselbl.setText(result.size()+" Responses");
		for (OetextDataDO oetextDataDO : result) {
			ViewResponseUserWidget responseUserWidget=new ViewResponseUserWidget(oetextDataDO,resourceGooruId,collectionId,classpageId,pathwayId,questionType,isSummary);
			viewResponsepnl.add(responseUserWidget);
		}
	}
	@Override
	protected void onUnload() {
		super.onUnload();
		Window.enableScrolling(true);
	}
}
