package org.ednovo.gooru.client.mvp.gshelf.collectiondetails;

import org.ednovo.gooru.application.client.gin.IsViewWithHandlers;
import org.ednovo.gooru.application.shared.model.folder.CreateDo;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;

public interface IsExternalAssessmentView extends IsViewWithHandlers<ExternalAssessmentInfoUiHandlers> {

	void callCreateAndUpdate(boolean isCreate, boolean value, int index, CreateDo createOrUpDate);
	/**
	 * This method is used to set data object
	 * @param folderObj
	 */
	void setData(FolderDo folderObj);

}
