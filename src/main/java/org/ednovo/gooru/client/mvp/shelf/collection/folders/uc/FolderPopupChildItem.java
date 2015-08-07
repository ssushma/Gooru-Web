package org.ednovo.gooru.client.mvp.shelf.collection.folders.uc;

import java.util.HashMap;

import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.client.ui.HTMLEventPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public abstract class FolderPopupChildItem extends Composite{

	@UiField HTMLEventPanel folderLevel;
	@UiField HTMLPanel arrow;
	@UiField Label title;
	@UiField FolderPopupStyleBundle folderPopupStyle;
	
	private String gooruOid;
	private String selectedFolderTitle;
	private int level;
	private int position;
	private boolean collectionIsOpened = false;
	
	HashMap<String,String> urlParams = new HashMap<String,String>();
	
	private static final String O1_LEVEL = "o1";
	
	private static final String O2_LEVEL = "o2";
	
	private static final String O3_LEVEL = "o3";

	private static final String ID = "id";
	
	private static FolderPopupChildItemUiBinder uiBinder = GWT.create(FolderPopupChildItemUiBinder.class);

	interface FolderPopupChildItemUiBinder extends UiBinder<Widget, FolderPopupChildItem> {}
	
	public FolderPopupChildItem(FolderDo folderDo, int level) {
		initWidget(uiBinder.createAndBindUi(this));
		setData(folderDo, level);
		folderLevel.addClickHandler(new ClickOnFolderLevel());
		folderLevel.getElement().setId("epnlFolderLevel");
		arrow.getElement().setId("pnlArrow");
		title.getElement().setId("lblTitle");
	}
	
	private void setData(FolderDo folderDo, int level) {
		if(folderDo.getGooruOid()==null) {
			arrow.setVisible(false);
			folderLevel.addStyleName(folderPopupStyle.root());
		}
		if(folderDo != null)
		{
		if(folderDo.getCollectionItems() != null)
		{
		Boolean hasFolders = false;	
			for(int i=0;i<folderDo.getCollectionItems().size();i++)
			{
				if(folderDo.getCollectionItems().get(i).getType().equalsIgnoreCase("folder"))
				{
					hasFolders = true;
				}
			}
			if((folderDo.getCollectionItems().size() == 0) || ((folderDo.getCollectionItems().size() > 0) && !hasFolders))
			{
				arrow.setVisible(false);
			}
		}
		}
		title.setText(folderDo.getTitle());
		title.getElement().setAttribute("alt",folderDo.getTitle());
		title.getElement().setAttribute("title",folderDo.getTitle());
		setGooruOid(folderDo.getGooruOid());
		setSelectedFolderTitle(folderDo.getTitle());
		if(level==2) {
			folderLevel.addStyleName(folderPopupStyle.parent());
		} else if(level==3) {
			folderLevel.addStyleName(folderPopupStyle.child());
		} else if(level==0) {
			setSelectedStyle(true);
		}
	}
	
	public void setWidgetPositions(int level, int position, HashMap<String, String> params) {
		this.level = level;
		this.position = position;
		if(level==1) {
			this.urlParams.put(O1_LEVEL, getGooruOid());
		}
		if(level==2) {
			this.urlParams.put(O1_LEVEL, params.get(O1_LEVEL));
			this.urlParams.put(O2_LEVEL, getGooruOid());
		}
		if(level==3) {
			this.urlParams.put(O1_LEVEL, params.get(O1_LEVEL));
			this.urlParams.put(O2_LEVEL, params.get(O2_LEVEL));
			this.urlParams.put(O3_LEVEL, getGooruOid());
		}
		if(level==4) {
		}
	}
	
	public HashMap<String,String> getUrlParams() {
		return urlParams;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getPosition() {
		return position;
	}

	public class ClickOnFolderLevel implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
		}
	}
	
	public void setFolderStyle(boolean isOpen){
		if(getLevel()!=0&&getLevel()!=3) {
			if(isOpen) {
				folderLevel.addStyleName(folderPopupStyle.open());
			} else {
				folderLevel.removeStyleName(folderPopupStyle.open());
			}
			onSetFolderItemData(urlParams, gooruOid, selectedFolderTitle);
		}
	}
	
	/** 
	 * This method is to get the gooruOid
	 */
	public String getGooruOid() {
		return gooruOid;
	}

	/** 
	 * This method is to set the gooruOid
	 */
	public void setGooruOid(String gooruOid) {
		this.gooruOid = gooruOid;
	}

	public boolean getCollectionOpenedStatus() {
		return collectionIsOpened;
	}
	
	public void setCollectionOpenedStatus(boolean collectionIsOpened) {
		this.collectionIsOpened = collectionIsOpened;
	}

	public HTMLEventPanel getFolderLevel() {
		return folderLevel;
	}
	
	public void setSelectedStyle(boolean isSelected) {
		if(isSelected){
			folderLevel.addStyleName(folderPopupStyle.selected());
		} else {
			folderLevel.removeStyleName(folderPopupStyle.selected());
		}
	}

	/**
	 * @return the selectedFolderTitle
	 */
	public String getSelectedFolderTitle() {
		return selectedFolderTitle;
	}

	/**
	 * @param selectedFolderTitle the selectedFolderTitle to set
	 */
	public void setSelectedFolderTitle(String selectedFolderTitle) {
		this.selectedFolderTitle = selectedFolderTitle;
	}
	
	public abstract void onSetFolderItemData(HashMap<String,String> urlParams, String parentId, String folderTitle);

	public void setLevel(HashMap<String,String> params) {
		this.urlParams.put(O1_LEVEL, params.get(O1_LEVEL));
		this.urlParams.put(O2_LEVEL, params.get(O2_LEVEL));
		this.urlParams.put(O3_LEVEL, params.get(O3_LEVEL));
	}
}