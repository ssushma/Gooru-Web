package org.ednovo.gooru.client.mvp.analytics.util;

import java.util.ArrayList;

import org.ednovo.gooru.shared.model.analytics.OetextDataDO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
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
	/**
	 * Constructor
	 * @param questionCount
	 * @param questionText
	 * @param questionAnswers
	 * @param questionType
	 */
	public ViewResponsesPopup(String questionCount,String questionText,String questionAnswers, String questionType) {
		setWidget(uiBinder.createAndBindUi(this));
		setCollectionProgressData(questionCount, questionText, questionAnswers,questionType);
	}
	
	/**
	 * This method is used to display the view responses
	 * @param result
	 * @param resourceGooruId
	 * @param collectionId
	 * @param classpageId
	 * @param pathwayId
	 * @param questionType
	 * @param isSummary
	 * @param session
	 */
	public ViewResponsesPopup(ArrayList<OetextDataDO> result,String resourceGooruId,String collectionId, String classpageId,String pathwayId,String questionType,boolean isSummary,String session) {
	 	setWidget(uiBinder.createAndBindUi(this));
		setPopUpData(result,resourceGooruId,collectionId,classpageId,pathwayId,questionType,isSummary,session);
	}
	/**
	 * This method is used to set collection progress data.
	 * @param questionCount
	 * @param questionText
	 * @param questionAnswers
	 * @param questionType
	 */
	void setCollectionProgressData(String questionCount,String questionText,String questionAnswers, String questionType){
		viewResponsepnl.clear();
		totalResponselbl.setVisible(false);
		ViewResponseUserWidget responseUserWidget=new ViewResponseUserWidget(questionCount, questionText, questionAnswers, questionType);
		viewResponsepnl.getElement().getStyle().clearHeight();
		viewResponsepnl.add(responseUserWidget);
	}
	/**
	 * This method will set the popup data.
	 * @param result
	 * @param resourceGooruId
	 * @param collectionId
	 * @param classpageId
	 * @param pathwayId
	 * @param questionType
	 * @param isSummary
	 */
	void setPopUpData(ArrayList<OetextDataDO> result,String resourceGooruId,String collectionId, String classpageId,String pathwayId,String questionType,boolean isSummary,String session){
		viewResponsepnl.clear();
		totalResponselbl.setVisible(true);
		totalResponselbl.setText(result.size()+" Responses");
		
		viewResponsepnl.getElement().getStyle().setHeight(250, Unit.PX);
		for (OetextDataDO oetextDataDO : result) {
			ViewResponseUserWidget responseUserWidget=new ViewResponseUserWidget(oetextDataDO,resourceGooruId,collectionId,classpageId,pathwayId,questionType,isSummary,session);
			viewResponsepnl.add(responseUserWidget);
		}
	}
	@Override
	protected void onUnload() {
		super.onUnload();
		Window.enableScrolling(true);
	}
}
