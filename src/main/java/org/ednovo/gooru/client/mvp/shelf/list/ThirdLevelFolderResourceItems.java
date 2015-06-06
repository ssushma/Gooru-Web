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
import org.ednovo.gooru.client.effects.FontWeightEffect;
import org.ednovo.gooru.client.util.ImageUtil;
import org.ednovo.gooru.shared.util.StringUtil;

import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

public class ThirdLevelFolderResourceItems extends FlowPanel {
	private Label imageLbl;
	private Label titleLbl;

	public ThirdLevelFolderResourceItems(CollectionItemDo collectionItem) {
		imageLbl = new Label();
		titleLbl = new Label();

		titleLbl.setStyleName(ShelfListCBundle.INSTANCE.css().shelfResourceTitle());
		this.setStyleName(ShelfListCBundle.INSTANCE.css().shelfResourcePanel());
		this.setData(collectionItem);
	}
	
	private void setData(CollectionItemDo collectionItem) {
		ImageUtil.renderResourceImage(imageLbl, collectionItem.getResource().getCategory());
		if (collectionItem.getResource().getTitle() != null && collectionItem.getResource().getTitle().length() > 0) {
			titleLbl.setText(StringUtil.truncateText(collectionItem.getResource().getTitle(), 30));
		} else {
			titleLbl.setText("--");
		}
		this.add(imageLbl);
		this.add(titleLbl);
	}
	
	public void glowTitle() {
		new FontWeightEffect(titleLbl.getElement(), FontWeight.BOLD, FontWeight.NORMAL, 5000);
	}

}
