package org.ednovo.gooru.client.mvp.shelf.collection.tab.resource.addquestion;

import org.ednovo.gooru.client.gin.BaseUiHandlers;
import org.ednovo.gooru.client.mvp.shelf.event.AddResourceImageHandler;



/**
 * @author Hari
 *
 */

public interface QuestionTypeUiHandlers extends BaseUiHandlers,AddResourceImageHandler{
	
	void removeQuestionImage(String collectionItemId);
	void questionImageUpload();
	void questionImageUpload(String collectionItemId);
	void browseStandardsInfo(boolean isQuestion, boolean isUserResource);
	void addUpdatedBrowseStandards();
	void closeStandardsPopup();
	void hidePopup();
	void removeAnswerImage(String collectionItemId);
	void answerImageUpload();
	void answerImageUpload(String collectionItemId);
}
