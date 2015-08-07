/*******************************************************************************
 * Copyright 2013 Ednovo d/b/a Gooru. All rights reserved.
 * 
 *  http://www.goorulearning.org/
 * 
 *  Permission is hereby granted, free of charge, to any person obtaining
 *  a copy of this software and associated documentation files (the
 *  "Software"), to deal in the Software without restriction, including
 *  without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to
 *  permit persons to whom the Software is furnished to do so, subject to
 *  the following conditions:
 * 
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 * 
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 *  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 *  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 *  WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
package org.ednovo.gooru.client.mvp.shelf.list;

import org.ednovo.gooru.application.shared.model.content.CollectionItemDo;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.application.shared.model.folder.FolderItemDo;
import org.ednovo.gooru.client.effects.FontWeightEffect;
import org.ednovo.gooru.client.util.ImageUtil;

import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.WhiteSpace;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;

/**
 * @author Search Team
 *
 */
public class ShelfResource extends FlowPanel {

	private Label imageLbl;
	private HTML titleLbl;
	
	private FolderItemDo collectionItemDo = null;
	
	private FolderDo resources = null;

	/**
	 * Class constructor , assign colletionItem instance
	 * @param collectionItem instance of {@link CollectionItemDo}
	 */
	public ShelfResource(FolderItemDo collectionItem) {
		this.collectionItemDo = collectionItem;
		imageLbl = new Label();
		titleLbl = new HTML();
		this.getElement().setAttribute("collectionType", collectionItem.getType());
		titleLbl.setStyleName(ShelfListCBundle.INSTANCE.css().shelfResourceTitle());
		titleLbl.addStyleName("collectionItemTitle");
		titleLbl.getElement().getStyle().setWhiteSpace(WhiteSpace.NOWRAP);
		this.setStyleName(ShelfListCBundle.INSTANCE.css().shelfResourcePanel());
		this.setData(collectionItem);
	}

	public ShelfResource(FolderDo resources) { 
		this.resources = resources;
		imageLbl = new Label();
		titleLbl = new HTML();
		this.getElement().setAttribute("collectionType", resources.getType());
		titleLbl.setStyleName(ShelfListCBundle.INSTANCE.css().shelfResourceTitle());
		titleLbl.addStyleName("collectionItemTitle");
		titleLbl.getElement().getStyle().setWhiteSpace(WhiteSpace.NOWRAP);
		this.setStyleName(ShelfListCBundle.INSTANCE.css().shelfResourcePanel());
		this.setData(resources);
	}

	private void setData(FolderDo resources) { 
		if(resources.getResourceFormat()!=null) {
			ImageUtil.renderResourceImage(imageLbl, resources.getResourceFormat().getValue());
		}
		if (resources.getTitle() != null && resources.getTitle().length() > 0) {
//			titleLbl.setText(StringUtil.truncateText(collectionItem.getResource().getTitle(), 30));
			titleLbl.setHTML(resources.getTitle().replaceAll("<p>", "").replaceAll("</p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", ""));
		} else {
			titleLbl.setHTML("--");
		}
		this.add(imageLbl);
		this.add(titleLbl);
	}

	public void updateCurrentTitle(String newTitle) {
		titleLbl.setHTML("");
		if (newTitle != null && newTitle.length() > 0) {
			titleLbl.setHTML(newTitle.replaceAll("<p>", "").replaceAll("</p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", ""));
		} else {
			titleLbl.setHTML("--");
		}
	}
	
	/**
	 * Assign collection item info  title, image url 
	 * @param collectionItem instance of {@link CollectionItemDo}
	 */
	private void setData(FolderItemDo collectionItem) {
		if(collectionItem.getResourceFormat()!=null) {
			ImageUtil.renderResourceImage(imageLbl, collectionItem.getResourceFormat().getValue());
		}
		if (collectionItem.getTitle() != null && collectionItem.getTitle().length() > 0) {
//			titleLbl.setText(StringUtil.truncateText(collectionItem.getResource().getTitle(), 30));
			titleLbl.setHTML(collectionItem.getTitle().replaceAll("<p>", "").replaceAll("</p>", "").replaceAll("<br data-mce-bogus=\"1\">", "").replaceAll("<br>", "").replaceAll("</br>", ""));
		} else {
			titleLbl.setHTML("--");
		}
		this.add(imageLbl);
		this.add(titleLbl);
	}

	public void glowTitle() {
		new FontWeightEffect(titleLbl.getElement(), FontWeight.BOLD, FontWeight.NORMAL, 5000);
	}

	/**
	 * @return instance of {@link CollectionItemDo} 
	 */
	public FolderDo getCollectionItemDo() {
		return resources;
	}

	/**
	 * @param collectionItemDo the {@link CollectionItemDo} to set
	 */
	public void setCollectionItemDo(FolderItemDo collectionItemDo) {
		this.collectionItemDo = collectionItemDo;
	}
	

}
