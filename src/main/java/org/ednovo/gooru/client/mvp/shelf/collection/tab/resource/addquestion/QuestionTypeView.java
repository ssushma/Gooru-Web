package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.addquestion;


import org.ednovo.gooru.client.gin.BaseViewWithHandlers;
import org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.add.AddQuestionImg;
import org.ednovo.gooru.client.uc.ConfirmationPopupVc;
import org.ednovo.gooru.client.ui.TinyMCE;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class QuestionTypeView extends BaseViewWithHandlers<QuestionTypeUiHandlers>
implements IsQuestionTypeView {

	@UiField QuestionTypeCBundle res;

	private static QuestionTypeViewUiBinder uiBinder = GWT	.create(QuestionTypeViewUiBinder.class);

	private static MessageProperties i18n = GWT.create(MessageProperties.class);

	interface QuestionTypeViewUiBinder extends UiBinder<Widget, QuestionTypeView> {
	}
	
	@UiField Label questionTypeHeader,questionTypeText,charLimitLbl,questionNameErrorLbl;
	@UiField Anchor addQuestionImg;
	@UiField HTMLPanel questionText,addQuestImgContainer;
	@UiField TinyMCE questionNameTextArea;
	
	private static final String MESSAGE_HEADER = i18n.GL0748();
	private static final String MESSAGE_CONTENT = i18n.GL0891();
	
	private DeleteConfirmationPopupVc deleteConfirmationPopup;
	private CollectionItemDo collectionItemDo=null;

	public QuestionTypeView() {
		setWidget(uiBinder.createAndBindUi(this));
		setHeaderAndBodyText("EQ");
		questionTypeHeader.getElement().setId("lblQuestionTypeHeader");
		questionTypeText.getElement().setId("lblQuestionTypeText");
		questionText.getElement().setId("pnlQuestionText");
		questionText.getElement().setInnerHTML(" "+i18n.GL0863());
		questionText.getElement().setAttribute("alt", i18n.GL0863());
		questionText.getElement().setAttribute("title", i18n.GL0863());
		questionNameTextArea.getElement().setId("tinyMCEQuestionNameTextArea");
		questionNameTextArea.getElement().setAttribute("maxlength", "500");
		questionNameTextArea.markAsBlankPanel.setVisible(false);
		questionNameErrorLbl.getElement().setId("errlblQuestionNameErrorLbl");
		addQuestionImg.setText(i18n.GL0860());
		addQuestionImg.getElement().setAttribute("alt", i18n.GL0860());
		addQuestionImg.getElement().setAttribute("title", i18n.GL0860());
		addQuestionImg.getElement().setId("lnkAddQuestionImg");
		addQuestImgContainer.getElement().setId("pnlAddQuestImgContainer");
		setTextForTheFields();
	}
	
	public void setTextForTheFields(){
		String value = StringUtil.generateMessage(i18n.GL2103(), "500");
		charLimitLbl.setText(value);
		StringUtil.setAttributes(charLimitLbl.getElement(), "charLimitLbl", value, value);
	}
	

	public void setHeaderAndBodyText(String tabType){
		if(tabType.equals("EQ")){
			questionTypeHeader.setText(i18n.GL0349());
			questionTypeHeader.getElement().setAttribute("alt", i18n.GL0349());
			questionTypeHeader.getElement().setAttribute("title", i18n.GL0349());
			questionTypeText.setText(i18n.GL0350());
			questionTypeText.getElement().setAttribute("alt", i18n.GL0350());
			questionTypeText.getElement().setAttribute("title", i18n.GL0350());
		}
	}
	
	
	@UiHandler("addQuestionImg")
	public void clickOnAddQuestImg(ClickEvent event){
		
		if(addQuestImgContainer.getElement().hasChildNodes()){
			addQuestImgContainer.setVisible(true);
			addQuestionImg.setVisible(false);
			setImageContainer();
			
		}else{
			uploadQuestionImage();
		}
		
		
	}
	
	public void setImageContainer(){

		if(addQuestImgContainer.getElement().hasChildNodes()){
			addQuestionImg.removeStyleName("ancTab");
			addQuestionImg.addStyleName("ancTabActive");
		}else{
			addQuestionImg.addStyleName("ancTab");
			addQuestionImg.removeStyleName("ancTabActive");
		}
	}

	public void uploadQuestionImage(){
		getUiHandlers().questionImageUpload();
	}
	

	@Override
	public void getRevealType() {
		System.out.println("");
	}

	@Override
	public void setImageUrl(String fileName,String fileNameWithoutRepository,boolean isQuestionImage,boolean isUserOwnResourceImage){
		double randNumber = Math.random();
		
		if(isQuestionImage){
			AddQuestionImg addQuestionImage = new AddQuestionImg();
			addQuestionImage.setQuestionImage(fileName+"?"+randNumber);
			addQuestionImage.setFileName(fileNameWithoutRepository);
			addQuestImgContainer.clear();
			addQuestionImg.getElement().getStyle().setDisplay(Display.NONE);
			addQuestImgContainer.add(addQuestionImage);
			setImageHandler();
			
			
			addQuestionImage.getChangeImgLbl().addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					if(getQuestionEditMode()){
						getUiHandlers().questionImageUpload(collectionItemDo.getCollectionItemId());
					}else{
						getUiHandlers().questionImageUpload();
					}
				}
			});
			addQuestionImage.getRemoveImgLbl().addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					boolean isQuestionEditMode=getQuestionEditMode();
					if(isQuestionEditMode){
						deleteConfirmationPopup=new DeleteConfirmationPopupVc(MESSAGE_HEADER,MESSAGE_CONTENT);
					}else{
						addQuestImgContainer.clear();
						addQuestionImg.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
					}
				}
			});
		}
		else{
		}
	}
	
	
	public void setImageHandler(){
		if(addQuestImgContainer.getElement().hasChildNodes()){
    		AddQuestionImg addQuestionImage=(AddQuestionImg)addQuestImgContainer.getWidget(0);
    		addQuestionImage.geteHearderIconImage().addClickHandler(new MinimizePanelsClickHandler());
    	}
	}
	
	private class MinimizePanelsClickHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			if(event.getRelativeElement().getId().equalsIgnoreCase("eHearderIconImage")){
				addQuestImgContainer.setVisible(false);
				addQuestionImg.setVisible(true);
				setImageContainer();
			}
		}
	}
	
	public boolean getQuestionEditMode(){
		return collectionItemDo!=null?true:false;
	}
	private class DeleteConfirmationPopupVc extends ConfirmationPopupVc{
		public DeleteConfirmationPopupVc(String messageHeader,String messageContent){
			super(messageHeader, messageContent);
			setPopupZindex(9999);
			setGlassZindex(9998);
			setScrollDisable();
		}
		@Override
		public void onDelete(ClickEvent clickEvent) {
			setImageContainer();
			getUiHandlers().removeQuestionImage(collectionItemDo.getCollectionItemId());
		}
		public void hide() {
			 super.hide();
			 
		}
	}
}