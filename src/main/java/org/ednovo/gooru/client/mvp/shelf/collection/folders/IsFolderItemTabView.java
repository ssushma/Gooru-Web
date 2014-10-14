package org.ednovo.gooru.client.mvp.shelf.collection.folders;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ednovo.gooru.client.gin.IsViewWithHandlers;
import org.ednovo.gooru.shared.model.folder.FolderDo;

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
}