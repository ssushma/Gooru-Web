package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.addquestion;

import org.ednovo.gooru.client.gin.IsViewWithHandlers;

import com.google.gwt.user.client.ui.Button;


/**
 * @author Hari
 *
 */
public interface IsQuestionTypeView extends IsViewWithHandlers<QuestionTypeUiHandlers>{
	
	void getRevealType();
	
	void setImageUrl(String fileName,String fileNameWithoutRepository,boolean isQuestionImage, boolean isUserOwnResourceImage);

	void OnBrowseStandardsClickEvent(Button addBtn);

	void setUpdatedStandardsCode(String setStandardsVal,int setStandardsIdVal, String setStandardDesc);

	void resetFields();



}