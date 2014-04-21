package org.ednovo.gooru.shared.model.folder;

import java.io.Serializable;
import java.util.List;

import org.ednovo.gooru.shared.model.content.ResourceFormatDo;
import org.ednovo.gooru.shared.model.content.ResourceTypeDo;
import org.ednovo.gooru.shared.model.content.ThumbnailDo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class FolderDo implements Serializable{

	private static final long serialVersionUID = -3298220423508874309L;

	private String gooruOid;
	private String title;
	private String sharing;
	private Integer itemCount;
	private String type;
	private ThumbnailDo thumbnails;
	private List<FolderItemDo> collectionItems;
	private ResourceFormatDo resourceFormat;
	private ResourceTypeDo resourceTypeDo;
	
	public FolderDo(){}

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

	/** 
	 * This method is to get the title
	 */
	public String getTitle() {
		return title;
	}

	/** 
	 * This method is to set the title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/** 
	 * This method is to get the sharing
	 */
	public String getSharing() {
		return sharing;
	}

	/** 
	 * This method is to set the sharing
	 */
	public void setSharing(String sharing) {
		this.sharing = sharing;
	}

	/** 
	 * This method is to get the itemCount
	 */
	public Integer getItemCount() {
		return itemCount;
	}

	/** 
	 * This method is to set the itemCount
	 */
	public void setItemCount(Integer itemCount) {
		this.itemCount = itemCount;
	}

	/** 
	 * This method is to get the type
	 */
	public String getType() {
		return type;
	}

	/** 
	 * This method is to set the type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/** 
	 * This method is to get the thumbnails
	 */
	public ThumbnailDo getThumbnails() {
		return thumbnails;
	}

	/** 
	 * This method is to set the thumbnails
	 */
	public void setThumbnails(ThumbnailDo thumbnails) {
		this.thumbnails = thumbnails;
	}

	/** 
	 * This method is to get the collectionItems
	 */
	public List<FolderItemDo> getCollectionItems() {
		return collectionItems;
	}

	/** 
	 * This method is to set the collectionItems
	 */
	public void setCollectionItems(List<FolderItemDo> collectionItems) {
		this.collectionItems = collectionItems;
	}

	/**
	 * @return the resourceFormat
	 */
	public ResourceFormatDo getResourceFormat() {
		return resourceFormat;
	}

	/**
	 * @param resourceFormat the resourceFormat to set
	 */
	public void setResourceFormat(ResourceFormatDo resourceFormat) {
		this.resourceFormat = resourceFormat;
	}

	/** 
	 * This method is to get the resourceTypeDo
	 */
	public ResourceTypeDo getResourceTypeDo() {
		return resourceTypeDo;
	}

	/** 
	 * This method is to set the resourceTypeDo
	 */
	public void setResourceTypeDo(ResourceTypeDo resourceTypeDo) {
		this.resourceTypeDo = resourceTypeDo;
	}
}