package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.addquestion;

import org.ednovo.gooru.client.gin.IsViewWithHandlers;


/**
 * @author Hari
 *
 */
public interface IsQuestionTypeView extends IsViewWithHandlers<QuestionTypeUiHandlers>{
	
	void getRevealType();
	
	void setImageUrl(String fileName,String fileNameWithoutRepository,boolean isQuestionImage, boolean isUserOwnResourceImage);

}