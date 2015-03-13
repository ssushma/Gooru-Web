package org.ednovo.gooru.client.mvp.shelf.collection.folders;

import java.util.HashMap;
import java.util.Map;

import org.ednovo.gooru.client.SimpleAsyncCallback;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.UpdateFolderItemEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.UpdateShelfFolderNameEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.item.ShelfFolderItemChildView;
import org.ednovo.gooru.client.service.FolderServiceAsync;
import org.ednovo.gooru.client.service.ResourceServiceAsync;
import org.ednovo.gooru.shared.model.folder.FolderDo;
import org.ednovo.gooru.shared.model.folder.FolderListDo;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

/**
 * @author Search Team
 *
 */
public class FolderItemTabPresenter extends PresenterWidget<IsFolderItemTabView> implements FolderItemTabUiHandlers {
	/**
	 * Class constructor
	 * 
	 * @param eventBus {@link EventBus}
	 * @param view {@link View}
	 */
	
	@Inject
	private FolderServiceAsync folderService;
	
	@Inject
	private ResourceServiceAsync resourceService;
	
	private SimpleAsyncCallback<FolderListDo> userCollectionAsyncCallback;

	private String folderParentName = "";
	
	
	@Inject
	public FolderItemTabPresenter(EventBus eventBus, IsFolderItemTabView view) {
		super(eventBus, view);
		getView().setUiHandlers(this);
		addRegisteredHandler(UpdateFolderItemEvent.TYPE, this);
	}

	@Override
	public void onBind() {
		super.onBind();
	}

	@Override
	public void onReveal() {
		super.onReveal();
		getView().onLoad();
		getView().reset();
		Window.enableScrolling(false);
	}
	@Override
	protected void onHide() {
		super.onHide();
		getView().onUnload();
	}
	
	public FolderServiceAsync getFolderService() {
		return folderService;
	}

	public void setFolderService(FolderServiceAsync folderService) {
		this.folderService = folderService;
	}
	
	public ResourceServiceAsync getResourceService() {
		return resourceService;
	}

	@Override
	public void setFolderData(String parentId, String folderParentName, int pageNumber) {
		this.folderParentName = folderParentName;
		getView().setPageDetails(pageNumber+1, parentId, folderParentName);
		if(parentId==null) {
			getResourceService().getFolderWorkspace((pageNumber-1)*20, 20,null,null,false,getUserCollectionAsyncCallback(true));
		} else {
			getChildFolderItems(parentId, pageNumber);
		}
	}
	
	public SimpleAsyncCallback<FolderListDo> getUserCollectionAsyncCallback(boolean clearShelfPanel) {
		if (userCollectionAsyncCallback == null) {
			userCollectionAsyncCallback = new SimpleAsyncCallback<FolderListDo>() {

				@Override
				public void onSuccess(FolderListDo result) {
					if(result != null)
					{
						if(result.getSearchResult()!=null && result.getCount()!=null)
						{
							getView().setFolderData(result.getSearchResult(), null, null,result.getCount());
						}
					}
				}
			};
		}
		return userCollectionAsyncCallback;
	}

	public void getChildFolderItems(final String folderId, final int pageNumber) {
		AppClientFactory.getInjector().getfolderService().getChildFolders((pageNumber-1)*20, 20,folderId,null, null,false,new SimpleAsyncCallback<FolderListDo>() {
			@Override
			public void onSuccess(FolderListDo result) {
				getView().setFolderData(result.getSearchResult(), folderParentName, folderId,result.getCount());
			}			
		});
	}

	@Override
	public void updateCollectionInfo(final String folderId, final String title, String description) {
		AppClientFactory.getInjector().getfolderService().updateFolder(folderId, title, null, null, null, new SimpleAsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				AppClientFactory.fireEvent(new UpdateShelfFolderNameEvent(title,folderId)); 
			}
		});
	}
	
	public void createFolderInParent(String folderName, final String parentId) {
		boolean addToShelf = false;
		if(parentId.isEmpty()) {
			addToShelf = true;
		}
		AppClientFactory.getInjector().getfolderService().createFolder(folderName, parentId, addToShelf, new SimpleAsyncCallback<FolderDo>() {
			@Override
			public void onSuccess(FolderDo result) {
				getView().addFolderItem(result, parentId, null);
			}
		});

	}

	@Override
	public void setFolderTitle(String title) {
		getView().setFolderTitle(title);
	}
	
	@Override
	public void updateFolderItem(FolderDo folderDo, String parentId, HashMap<String,String> params) {
		getView().addFolderItem(folderDo, parentId, params);
	}

	public void setFolderMetaData(Map<String, String> folderMetaData) {
		getView().setFolderMetaData(folderMetaData);
	}

	@Override
	public void reorderFoldersOrCollection(final ShelfFolderItemChildView shelfFolderItemChildView, final int itemToBeMovedPosSeqNumb,final int itemPosSeqNumb, final String downArrow, String collectionItemId,int itemSeqToAPI) {
		AppClientFactory.getInjector().getfolderService().reorderFoldersOrCollections(itemSeqToAPI,collectionItemId, new SimpleAsyncCallback<Void>() {

			@Override
			public void onSuccess(Void result) {
				getView().onReorderChangeWidgetPosition(shelfFolderItemChildView,itemToBeMovedPosSeqNumb,itemPosSeqNumb,downArrow);
			}
		});
		
//		getView().onReorderChangeWidgetPosition(shelfFolderItemChildView,itemToBeMovedPosSeqNumb,itemPosSeqNumb,downArrow);
	}


	@Override
	public void deletAssessment(String assessmentId,final FolderDo folderDo) {
		AppClientFactory.getInjector().getResourceService().deleteCollection(assessmentId, new SimpleAsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				getView().resetCollectionsAfterDeletingAssessment(folderDo);
			}
		});
	}
}