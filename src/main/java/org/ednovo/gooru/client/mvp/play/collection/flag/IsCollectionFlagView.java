package org.ednovo.gooru.client.mvp.play.collection.flag;

import org.ednovo.gooru.client.gin.IsViewWithHandlers;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.shared.model.content.CollectionDo;
import org.ednovo.gooru.shared.model.content.ContentReportDo;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;
import com.gwtplatform.mvp.client.PopupView;


public interface IsCollectionFlagView extends PopupView,IsViewWithHandlers<CollectionFlagUiHandler>{
	
	public void getDisplayData(CollectionDo collectionDo);
	public void setDefaultView();
	public void setFlag(ContentReportDo contentReportDo, String gooruFlagId); 
	public Image getCloseButton();
	public Button getSubmitButton();
	
	public void showSuccesmessagePopup();
	
	
}
