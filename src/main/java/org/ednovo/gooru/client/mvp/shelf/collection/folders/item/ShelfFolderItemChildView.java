package org.ednovo.gooru.client.mvp.shelf.collection.folders.item;

import java.util.HashMap;
import java.util.List;

import org.ednovo.gooru.client.PlaceTokens;
import org.ednovo.gooru.client.child.ChildView;
import org.ednovo.gooru.client.gin.AppClientFactory;
import org.ednovo.gooru.client.mvp.dnd.IsDraggableMirage;
import org.ednovo.gooru.client.mvp.shelf.FolderStyleBundle;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.ChangeShelfPanelActiveStyleEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.SetFolderCollectionStyleEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.SetFolderMetaDataEvent;
import org.ednovo.gooru.client.mvp.shelf.collection.folders.events.SetFolderParentNameEvent;
import org.ednovo.gooru.client.uc.HTMLEventPanel;
import org.ednovo.gooru.client.uc.UcCBundle;
import org.ednovo.gooru.shared.i18n.MessageProperties;
import org.ednovo.gooru.shared.model.folder.FolderDo;
import org.ednovo.gooru.shared.model.folder.FolderItemDo;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ShelfFolderItemChildView extends ChildView<ShelfFolderItemChildPresenter> implements
		IsShelfFolderItemView {

	@UiField FolderStyleBundle folderStyle;

	@UiField FlowPanel contentBlock,contents;
	@UiField HTMLEventPanel folderImage;
	@UiField Image collectionImage;
	@UiField Label itemTitle,itemNumber;
	

	@UiField TextBox reorderTxtBox;
	@UiField Button moveUpBtn,moveDownBtn;
	

	private static final String DEFULT_IMAGE_PREFIX = "images/default-collection-image-160x120.png";
	
	private static final String SMALL = "Small";
	
	private static final String SMALL_NEW = "SmallNew";
	
	private static final String FOLDER = "folder";
	
	private static final String COLLECTION = "collection";

	private static final String SCOLLECTION = "scollection";

	private static final String RESOURCE = "resource";
	
	private static final String O1_LEVEL = "o1";
	
	private static final String O2_LEVEL = "o2";
	
	private static final String O3_LEVEL = "o3";
	
	private static final String ID = "id";
	
	private String itemGooruOId;
	
	private FolderDo folderDo;
	
	private int itemNo;
	
	final String o1 = AppClientFactory.getPlaceManager().getRequestParameter(O1_LEVEL);
	
	final String o2 = AppClientFactory.getPlaceManager().getRequestParameter(O2_LEVEL);
	
	final String o3 = AppClientFactory.getPlaceManager().getRequestParameter(O3_LEVEL);

	private static ShelfFolderItemChildViewUiBinder uiBinder = GWT.create(ShelfFolderItemChildViewUiBinder.class);
	
	MessageProperties i18n = GWT.create(MessageProperties.class);

	interface ShelfFolderItemChildViewUiBinder extends UiBinder<Widget, ShelfFolderItemChildView> {}
	
	public ShelfFolderItemChildView(FolderDo folderDo, int folderNumber) { 
		initWidget(uiBinder.createAndBindUi(this));
		this.folderDo = folderDo;
		setItemNo(folderNumber);
		setFolderData(folderDo);
		contentBlock.getElement().setId("fpnlContentBlock");
		folderImage.getElement().setId("epnlFolderImage");
		collectionImage.getElement().setId("imgCollectionImage");
		itemTitle.getElement().setId("lblItemTitle");
		contents.getElement().setId("fpnlContents");
		moveDownBtn.setVisible(true);
		moveUpBtn.setVisible(true);
	}
	
	public void setFolderData(final FolderDo folderDo) {
		itemTitle.addStyleName(folderStyle.folderTitleElipses());
		final String folderType = folderDo.getType();
		/*
		if(getItemNo() == 1){
			moveUpBtn.setVisible(false);
		}else{
			moveUpBtn.setVisible(true); 
		}*/
		
		if(folderType.equals(FOLDER)) {
			folderImage.setVisible(true);
			collectionImage.setVisible(false);
			contentBlock.addStyleName(folderStyle.folder());
		} else if (folderType.equals(SCOLLECTION) || folderType.equals(COLLECTION)){
			folderImage.setVisible(false);
			collectionImage.setUrl(DEFULT_IMAGE_PREFIX);
			collectionImage.setVisible(true);
			if(folderDo.getThumbnails()!=null) 
			{
				if(folderDo.getThumbnails().getUrl()!=null)
				{
					if(!folderDo.getThumbnails().getUrl().isEmpty())
					{
				collectionImage.setUrl(folderDo.getThumbnails().getUrl());
					}
					else {
						collectionImage.setUrl(DEFULT_IMAGE_PREFIX);
					}
				}
				else {
					collectionImage.setUrl(DEFULT_IMAGE_PREFIX);
				}
			} 
			else {
				collectionImage.setUrl(DEFULT_IMAGE_PREFIX);
			}
			collectionImage.addErrorHandler(new ErrorHandler() {
				@Override
				public void onError(ErrorEvent event) {
					collectionImage.setUrl(DEFULT_IMAGE_PREFIX);
				}
			});
			collectionImage.setHeight("90px");
			collectionImage.setWidth("120px");
			contentBlock.addStyleName(folderStyle.collection());
		}
		
		List<FolderItemDo> folderItemDo = folderDo.getCollectionItems();
		if(folderItemDo!=null&&folderItemDo.size()>0) {
			for(int i=0;i<folderItemDo.size();i++) {
				FolderItemDo folderItem = folderItemDo.get(i);
				Label folderItemLbl = new Label(folderItem.getTitle());
				if(folderItem.getType().equals(FOLDER)) {
					folderItemLbl.addStyleName(folderStyle.folder());
					folderItemLbl.addClickHandler(new OpenChildFolderInContent(FOLDER, folderDo.getGooruOid(), folderItem.getGooruOid(), folderItem.getTitle()));
					contents.add(folderItemLbl);
				} else if(folderItem.getType().equals(SCOLLECTION)){
					folderItemLbl.addStyleName(folderStyle.collection());
					folderItemLbl.addClickHandler(new OpenChildFolderInContent(SCOLLECTION, folderDo.getGooruOid(), folderItem.getGooruOid(), folderItem.getTitle()));
					contents.add(folderItemLbl);
				} else {
					HTMLEventPanel resourcePanel = new HTMLEventPanel("");
					resourcePanel.addStyleName(folderStyle.resource());
					if(folderItem.getResourceFormat()!=null) {
						HTMLPanel resourceCategoryPanel = new HTMLPanel("");
						resourceCategoryPanel.addStyleName(UcCBundle.INSTANCE.css().resourceNameNew());
						resourceCategoryPanel.addStyleName(folderItem.getResourceFormat().getDisplayName().toLowerCase() + SMALL_NEW);
						resourceCategoryPanel.getElement().getStyle().setPosition(Position.STATIC);
						resourceCategoryPanel.getElement().getStyle().setFloat(Float.LEFT);
						resourcePanel.add(resourceCategoryPanel);
					}
					HTML resourceTitle = new HTML(StringUtil.getRefinedQuestionText(folderItem.getTitle()));
				//	resourceTitle.setStyleName(folderStyle.shelfFolderItemTitle());
					resourceTitle.setStyleName("shelfFolderItemTitle");
					resourcePanel.add(resourceTitle);
					contents.add(resourcePanel);
					resourcePanel.addClickHandler(new OpenChildFolderInContent(RESOURCE, folderDo.getGooruOid(), folderItem.getGooruOid(), null));
				}
			}
			if(folderDo.getItemCount()-folderItemDo.size()>0) {
				Anchor seeMoreLbl = new Anchor(i18n.GL_SPL_PLUS()+" "+ (folderDo.getItemCount()-folderItemDo.size())+" "+i18n.GL1152());
				seeMoreLbl.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						if(folderType.equals(FOLDER)) {
							AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.SHELF, urlParams(FOLDER, folderDo.getGooruOid()));
						} else {
							AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.SHELF, urlParams(COLLECTION, folderDo.getGooruOid()));
						}
						AppClientFactory.fireEvent(new ChangeShelfPanelActiveStyleEvent());
					}
				});
				contents.add(seeMoreLbl);
			}
		} else {
			contents.addStyleName(folderStyle.empty());
		}
		reorderTxtBox.setText(getItemNo()+""); 
		itemNumber.setText(getItemNo()+""); 
		itemTitle.setText(folderDo.getTitle());	
		itemTitle.getElement().setAttribute("alt",folderDo.getTitle());
		itemTitle.getElement().setAttribute("title",folderDo.getTitle());
	}
	
	@UiHandler("folderImage")
	public void clickOnFolderImage(ClickEvent event) {
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.SHELF, urlParams(FOLDER, folderDo.getGooruOid()));
		AppClientFactory.fireEvent(new ChangeShelfPanelActiveStyleEvent());
	}
	
	@UiHandler("collectionImage")
	public void clickOnCollectionImage(ClickEvent event) {
		AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.SHELF, urlParams(COLLECTION, folderDo.getGooruOid())); 
		AppClientFactory.fireEvent(new ChangeShelfPanelActiveStyleEvent()); 
	}
	
	@UiHandler("itemTitle")
	public void clickOnTitle(ClickEvent event) {
		if(folderDo.getType().equals("folder")){
			AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.SHELF, urlParams(FOLDER, folderDo.getGooruOid()));
		}else{
			AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.SHELF, urlParams(COLLECTION, folderDo.getGooruOid())); 
		}
		AppClientFactory.fireEvent(new ChangeShelfPanelActiveStyleEvent()); 
	}
	
	@Override
	public Widget getDragHandle() {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public IsDraggableMirage initDraggableMirage() {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void onDragBlur() {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public String getDragId() {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public DRAG_TYPE getDragType() {
		throw new RuntimeException("Not implemented");
//		return DRAG_TYPE.COLLECTION_ITEM;
	}

	@Override
	public int getDragTopCorrection() {
		throw new RuntimeException("Not implemented");
//		return 5;
	}

	@Override
	public int getDragLeftCorrection() {
		throw new RuntimeException("Not implemented");
//		return 225;
	}
	
	private HashMap<String,String> urlParams(String assetType, String folderId) {
		HashMap<String,String> params = new HashMap<String,String>();
		
		if(assetType.equals(FOLDER)) {
			if(o3!=null) {
				
			} else if(o2!=null) {
				params.put(O1_LEVEL, o1);
				params.put(O2_LEVEL, o2);
				params.put(O3_LEVEL, folderId);
			} else if(o1!=null) {
				params.put(O1_LEVEL, o1);
				params.put(O2_LEVEL, folderId);
			} else {
				params.put(O1_LEVEL, folderId);
			}
			AppClientFactory.fireEvent(new SetFolderMetaDataEvent(StringUtil.getFolderMetaData(folderDo)));
		} else {
			if(o3!=null) {
				params.put(O1_LEVEL, o1);
				params.put(O2_LEVEL, o2);
				params.put(O3_LEVEL, o3);
				params.put(ID, folderId);
			} else if(o2!=null) {
				params.put(O1_LEVEL, o1);
				params.put(O2_LEVEL, o2);
				params.put(ID, folderId);
			} else if(o1!=null){
				params.put(O1_LEVEL, o1);
				params.put(ID, folderId);
			} else {
				params.put(ID, folderId);
			}
		}
		AppClientFactory.fireEvent(new SetFolderParentNameEvent(folderDo.getTitle()));
		
		return params;
	}
	
	public class OpenChildFolderInContent implements ClickHandler{
		String parentId = null, folderId = null, folderTitle = null, folderType = null;
		public OpenChildFolderInContent(String folderType, String parentId, String folderId, String folderTitle) {
			this.folderType = folderType;
			this.parentId = parentId;
			this.folderId = folderId;
			this.folderTitle = folderTitle;
		}
		
		@Override
		public void onClick(ClickEvent event) {
			HashMap<String,String> params = new HashMap<String,String>();
			if(folderType.equals(FOLDER)) {
				if(o1!=null) {
					params.put(O1_LEVEL, o1);
					params.put(O2_LEVEL, parentId);
					params.put(O3_LEVEL, folderId);
				} else if (o1==null&&o2==null&&o3==null){
					params.put(O1_LEVEL, parentId);
					params.put(O2_LEVEL, folderId);
				}
				AppClientFactory.fireEvent(new SetFolderCollectionStyleEvent(params,FOLDER)); 
				AppClientFactory.fireEvent(new SetFolderParentNameEvent(folderTitle));
				AppClientFactory.fireEvent(new SetFolderMetaDataEvent(StringUtil.getFolderMetaData(folderDo)));
				AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.SHELF, params);
			} else if (folderType.equals(SCOLLECTION)){
				if(o1!=null) {
					params.put(O1_LEVEL, o1);
					params.put(O2_LEVEL, parentId);
					params.put(ID, folderId);
				} else if (o2!=null) {
					params.put(O1_LEVEL, o1);
					params.put(O2_LEVEL, o2);
					params.put(o3, parentId);
					params.put(ID, folderId);
				} else if (o1==null&&o2==null&&o3==null){
					params.put(O1_LEVEL, parentId);
					params.put(ID, folderId);
				}
				AppClientFactory.fireEvent(new SetFolderCollectionStyleEvent(params,SCOLLECTION));  
				AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.SHELF, params);
			}  else if (folderType.equals(RESOURCE)) {
				AppClientFactory.getPlaceManager().revealPlace(PlaceTokens.SHELF, urlParams(COLLECTION, folderDo.getGooruOid()));
				AppClientFactory.fireEvent(new SetFolderCollectionStyleEvent(params,COLLECTION));  
				AppClientFactory.fireEvent(new ChangeShelfPanelActiveStyleEvent());
			}
		}
	}
	
	
	/**
	 * Decides Up and Down button visibility
	 * @param totalCount {@link Integer}
	 */
	public void setUpDownArrowVisibility(int totalCount) { 
		if(getItemNo() == totalCount){
			downButtonIsVisible(false);
		}
		if(getItemNo() == 1){
			upButtonIsVisible(false);
		}
	}
	
	
	
	/**
	 * Sets the re-order Up button visibility
	 * @param isvisible {@link Boolean}
	 */
	public void upButtonIsVisible(boolean isvisible) {
		moveUpBtn.setVisible(isvisible);
	}


	/**
	 * Sets the re-order Down button visibility
	 * @param isvisible {@link Boolean}
	 */
	public void downButtonIsVisible(boolean isvisible) {
		moveDownBtn.setVisible(isvisible);
	}

	/**
	 * @return the itemNo
	 */
	public int getItemNo() {
		return itemNo;
	}

	/**
	 * @param itemNo the itemNo to set
	 */
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	
	/**
	 * @return the itemNumber
	 */
	public Label getItemNumber() {
		return itemNumber;
	}

	/**
	 * @param itemNumber the itemNumber to set
	 */
	public void setItemNumber(Label itemNumber) {
		this.itemNumber = itemNumber;
	}

	/**
	 * @return the reorderTxtBox
	 */
	public TextBox getReorderTxtBox() {
		return reorderTxtBox;
	}

	/**
	 * @param reorderTxtBox the reorderTxtBox to set
	 */
	public void setReorderTxtBox(TextBox reorderTxtBox) {
		this.reorderTxtBox = reorderTxtBox;
	}
	

	/**
	 * @return the moveUpBtn
	 */
	public Button getMoveUpBtn() {
		return moveUpBtn;
	}

	/**
	 * @param moveUpBtn the moveUpBtn to set
	 */
	public void setMoveUpBtn(Button moveUpBtn) {
		this.moveUpBtn = moveUpBtn;
	}

	/**
	 * @return the moveDownBtn
	 */
	public Button getMoveDownBtn() {
		return moveDownBtn;
	}

	/**
	 * @param moveDownBtn the moveDownBtn to set
	 */
	public void setMoveDownBtn(Button moveDownBtn) {
		this.moveDownBtn = moveDownBtn;
	}
	
	/**
	 * @return the itemGooruOId
	 */
	public String getItemGooruOId() {
		return itemGooruOId;
	}

	/**
	 * @param itemGooruOId the itemGooruOId to set
	 */
	public void setItemGooruOId(String itemGooruOId) {
		this.itemGooruOId = itemGooruOId;
	}


	/*public void reorderCollectionItem(int widgetIndex) { 
		
	}*/
}