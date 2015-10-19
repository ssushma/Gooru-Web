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
package org.ednovo.gooru.client.mvp.gshelf.collectiondetails;

import java.util.List;
import java.util.Map;

import org.ednovo.gooru.application.client.gin.IsViewWithHandlers;
import org.ednovo.gooru.application.shared.model.content.StandardFo;
import org.ednovo.gooru.application.shared.model.folder.CreateDo;
import org.ednovo.gooru.application.shared.model.folder.FolderDo;
import org.ednovo.gooru.application.shared.model.library.DomainStandardsDo;
import org.ednovo.gooru.client.mvp.gshelf.ShelfTreeWidget;
import org.ednovo.gooru.client.mvp.gshelf.collectiondetails.widgets.AudienceView;
import org.ednovo.gooru.client.mvp.gshelf.collectiondetails.widgets.DepthKnowledgeView;
import org.ednovo.gooru.client.mvp.gshelf.collectiondetails.widgets.LanguageView;
import org.ednovo.gooru.client.mvp.gshelf.util.LiPanelWithClose;
import org.ednovo.gooru.client.uc.UlPanel;

import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TreeItem;

/**
 * @author Search Team
 *
 */
public interface IsCollectionInfoView extends IsViewWithHandlers<CollectionInfoUiHandlers> {


	/**
	 * To set the Updated course data
	 * @param courseObj
	 * @param type
	 */
	void setCouseData(FolderDo courseObj, String type);

	void callCreateAndUpdate(boolean isCreate, Boolean result, int index,
			String collectionType, CreateDo createOrUpDate, TreeItem currentShelfTreeWidget);

	void setCollectionType(String collectionType);


	DepthKnowledgeView getDepthOfKnowledgeContainer();

	LanguageView getLanguageObjectiveContainer();

	HTMLPanel getCenturySkillContainer();

	AudienceView getAudienceContainer();

	void displayStandardsList(List<DomainStandardsDo> result);

//	void addTaxonomyData(UlPanel selectedUlContainer);

	FolderDo getFolderDo();

	void setCollectionImage(String url,String mediaFileName);

	void addTaxonomyData(List<LiPanelWithClose> liPanelWithCloseArray, List<LiPanelWithClose> collectionLiPanelWithCloseArray);

	void resetBtns();

	HTMLPanel getStadardsPanel();

	Image getCollThumbnail();

	void displaySelectedStandards(List<Map<String,String>> standListArray);

	void spinnerImageVisibility(boolean isVisible);

	void setStandardsValue(List<StandardFo> standardFoObj);

	void setActionButtons(String userId, Boolean isCollab); 
}
