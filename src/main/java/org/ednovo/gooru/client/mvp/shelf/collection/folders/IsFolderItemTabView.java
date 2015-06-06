package org.ednovo.gooru.client.mvp.shelf.collection.folders;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.application.client.gin.IsViewWithHandlers;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.item.ShelfFolderItemChildView;

/**
 * @author Search Team
 *
 */
public interface IsFolderItemTabView extends IsViewWithHandlers<FolderItemTabUiHandlers> {
	public void setFolderData(List<FolderDo> folderList, String folderParentName, String folderId, int totalCount);
	public void setParentId(String parentId);
	public void addFolderItem(FolderDo folderDo, String parentId, HashMap<String,String> params);
	public void setFolderTitle(String title);
	public void setPageDetails(Integer pageNumber, String parentId, String parentName);
	public void setFolderMetaData(Map<String, String> folderMetaData);
	public void onReorderChangeWidgetPosition(ShelfFolderItemChildView shelfFolderItemChildView, int itemToBeMovedPosSeqNumb,int itemPosSeqNumb, String downArrow);
	/**
	 * This method is used to reset the widget positions after deleting the assessement
	 * @param folderDo
	 */
	void resetCollectionsAfterDeletingAssessment(FolderDo folderDo, String assessmentId);
	/**
	 * It forward to view for updating assessment widget
	 * @param folderDo {@link FolderDo}
	 */
	public void updateAssessmentUrl(FolderDo folderDo); 
	
}