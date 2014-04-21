package org.ednovo.gooru.client.mvp.shelf.list;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Tree;
/**
 * @fileName : TreeMenuImages.java
 *
 * @description : 
 *
 * @version : 1.0
 *
 * @date: 31-Jan-2014
 *
 * @Author Gooru Team
 *
 * @Reviewer: 
 */
public class TreeMenuImages implements Tree.Resources{

	@Override
	public ImageResource treeClosed() {
		return TreeImageBundle.INSTANCE.leaf();
	}

	@Override
	public ImageResource treeLeaf() {
		return TreeImageBundle.INSTANCE.leaf();
	}
	
	@Override
	public ImageResource treeOpen() {
		return TreeImageBundle.INSTANCE.leaf();
	}
}
